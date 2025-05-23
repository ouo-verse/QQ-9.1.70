package com.tencent.mobileqq.activity.aio.voicetextpanel.controller;

import android.os.Build;
import android.os.Message;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.transfile.BaseTransProcessor;
import com.tencent.mobileqq.transfile.FileMsg;
import com.tencent.mobileqq.transfile.PttSliceUploadProcessor;
import com.tencent.mobileqq.transfile.TransProcessorHandler;
import com.tencent.mobileqq.transfile.TransferRequest;
import com.tencent.mobileqq.transfile.api.ITransFileController;
import com.tencent.mobileqq.utils.StringUtil;
import com.tencent.mobileqq.utils.ey;
import com.tencent.mobileqq.utils.httputils.IHttpCommunicatorListener;
import com.tencent.qphone.base.util.QLog;
import com.tencent.shadow.dynamic.host.Constant;
import com.wx.voice.vad.WXVadSeg;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.Consumer;
import mqq.app.AppRuntime;
import mqq.util.WeakReference;

/* compiled from: P */
/* loaded from: classes10.dex */
public class VoiceTextSttQueryController {

    /* renamed from: a, reason: collision with root package name */
    private String f180170a;

    /* renamed from: b, reason: collision with root package name */
    private int f180171b;

    /* renamed from: c, reason: collision with root package name */
    private AppRuntime f180172c;

    /* renamed from: d, reason: collision with root package name */
    private String f180173d;

    /* renamed from: e, reason: collision with root package name */
    private ITransFileController f180174e;

    /* renamed from: h, reason: collision with root package name */
    private d71.a[] f180177h;

    /* renamed from: i, reason: collision with root package name */
    private c71.b f180178i;

    /* renamed from: f, reason: collision with root package name */
    private AtomicInteger f180175f = new AtomicInteger();

    /* renamed from: g, reason: collision with root package name */
    private AtomicBoolean f180176g = new AtomicBoolean(false);

    /* renamed from: j, reason: collision with root package name */
    private final List<Long> f180179j = Collections.synchronizedList(new ArrayList());

    /* renamed from: k, reason: collision with root package name */
    private final CopyOnWriteArraySet<Runnable> f180180k = new CopyOnWriteArraySet<>();

    /* renamed from: l, reason: collision with root package name */
    private TransProcessorHandler f180181l = new a();

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes10.dex */
    public static class PttVadRunnable implements Runnable {

        /* renamed from: d, reason: collision with root package name */
        private final WeakReference<VoiceTextSttQueryController> f180182d;

        /* renamed from: e, reason: collision with root package name */
        private final String f180183e;

        public PttVadRunnable(VoiceTextSttQueryController voiceTextSttQueryController, String str) {
            this.f180182d = new WeakReference<>(voiceTextSttQueryController);
            this.f180183e = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            VoiceTextSttQueryController voiceTextSttQueryController = this.f180182d.get();
            if (voiceTextSttQueryController != null) {
                List l3 = voiceTextSttQueryController.l();
                if (l3 != null && !l3.isEmpty()) {
                    voiceTextSttQueryController.f180175f.set(voiceTextSttQueryController.f180175f.get() + l3.size());
                    voiceTextSttQueryController.f180177h = new d71.a[voiceTextSttQueryController.f180175f.get()];
                    voiceTextSttQueryController.t(this.f180183e, l3);
                    voiceTextSttQueryController.f180180k.remove(this);
                    voiceTextSttQueryController.k("afterSendSttRequest");
                    return;
                }
                voiceTextSttQueryController.f180180k.remove(this);
                voiceTextSttQueryController.k("seglist is empty");
                voiceTextSttQueryController.f180176g.set(true);
                return;
            }
            if (QLog.isColorLevel()) {
                QLog.d("VoiceTextEdtiController", 2, "VoiceTextSttQueryController is null");
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes10.dex */
    class a extends TransProcessorHandler {
        a() {
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            FileMsg fileMsg = (FileMsg) message.obj;
            if (fileMsg != null && fileMsg.fileType == 327696 && fileMsg.commandId == 68) {
                int i3 = message.what;
                if (i3 != 1004) {
                    if (i3 != 2005) {
                        if (i3 != 2002) {
                            if (i3 == 2003) {
                                String str = fileMsg.pttSliceText;
                                if (str != null) {
                                    VoiceTextSttQueryController.this.v(new d71.a(str, true), fileMsg.pttSlicePos);
                                }
                                VoiceTextSttQueryController.this.f180175f.set(VoiceTextSttQueryController.this.f180175f.get() - 1);
                                VoiceTextSttQueryController.this.k("recv finished");
                                return;
                            }
                            return;
                        }
                        if (!StringUtil.isEmpty(fileMsg.pttSliceText) && VoiceTextSttQueryController.this.f180175f.get() > 0) {
                            VoiceTextSttQueryController.this.v(new d71.a(fileMsg.pttSliceText, false), fileMsg.pttSlicePos);
                            return;
                        }
                        return;
                    }
                    if (QLog.isColorLevel()) {
                        QLog.d("VoiceTextEdtiController", 2, "pttTransProcessorHandler recieve error:" + fileMsg.errorCode);
                    }
                    if (VoiceTextSttQueryController.this.f180178i != null) {
                        VoiceTextSttQueryController.this.f180178i.a(fileMsg.errorCode);
                    }
                    e71.a.b(0, fileMsg.errorCode);
                    VoiceTextSttQueryController.this.i();
                    return;
                }
                if (QLog.isColorLevel()) {
                    QLog.d("VoiceTextEdtiController", 2, "pttTransProcessorHandler STATUS_SEND_CANCEL unFinishSegSize=" + VoiceTextSttQueryController.this.f180175f.get() + " pos=" + fileMsg.pttSlicePos);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes10.dex */
    public class b implements Consumer<WXVadSeg> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ StringBuilder f180185a;

        b(StringBuilder sb5) {
            this.f180185a = sb5;
        }

        @Override // java.util.function.Consumer
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void accept(WXVadSeg wXVadSeg) {
            StringBuilder sb5 = this.f180185a;
            sb5.append(" mbtm=");
            sb5.append(wXVadSeg.mbtm);
            sb5.append(" metm=");
            sb5.append(wXVadSeg.metm);
            sb5.append(" stag=");
            sb5.append(wXVadSeg.stag);
            sb5.append(" stype=");
            sb5.append(wXVadSeg.stype);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void k(String str) {
        boolean q16 = q();
        QLog.d("VoiceTextEdtiController", 1, "doOnPttSliceFinished from=", str + " needFinish=", Boolean.valueOf(q16), " unFinishSegSize=", this.f180175f, " runningTaskList.size=", Integer.valueOf(this.f180180k.size()));
        if (q16) {
            this.f180179j.clear();
            c71.b bVar = this.f180178i;
            if (bVar != null) {
                bVar.c();
            }
            s();
            e71.a.b(1, 0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public List<WXVadSeg> l() {
        if (QLog.isColorLevel()) {
            QLog.d("VoiceTextEdtiController", 2, "vadHelper  vad start");
        }
        ey eyVar = new ey();
        eyVar.b();
        List<WXVadSeg> d16 = eyVar.d(this.f180173d);
        eyVar.c();
        if (QLog.isColorLevel()) {
            QLog.d("VoiceTextEdtiController", 2, "vadHelper  vad start, pcmPathForVad=", this.f180173d, " vsdSegList size=", Integer.valueOf(d16.size()));
        }
        return d16;
    }

    private boolean q() {
        if (this.f180175f.get() <= 0 && this.f180180k.isEmpty()) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void t(String str, List<WXVadSeg> list) {
        if (list != null && !list.isEmpty()) {
            if (QLog.isColorLevel()) {
                QLog.d("VoiceTextEdtiController", 2, "vadHelper size=" + list.size() + " unFinishSegSize=" + this.f180175f.get() + " isSttFinish=" + this.f180176g.get());
            }
            StringBuilder sb5 = new StringBuilder();
            if (Build.VERSION.SDK_INT >= 24) {
                list.forEach(new b(sb5));
            }
            QLog.d("VoiceTextEdtiController", 4, "vsdSegList=", sb5);
            for (int i3 = 0; i3 < list.size(); i3++) {
                ITransFileController iTransFileController = (ITransFileController) this.f180172c.getRuntimeService(ITransFileController.class, "");
                this.f180174e = iTransFileController;
                iTransFileController.addHandle(this.f180181l);
                TransferRequest transferRequest = new TransferRequest();
                transferRequest.mIsUp = true;
                transferRequest.mCommandId = 68;
                transferRequest.mLocalPath = str;
                transferRequest.mUniseq = (long) (Math.random() * 1000000.0d);
                transferRequest.mPeerUin = this.f180170a;
                transferRequest.mFileType = FileMsg.TRANSFILE_TYPE_PTT_SLICE_TO_TEXT;
                transferRequest.mRichTag = StatisticCollector.PTT_SLICE_TO_TEXT;
                transferRequest.pcmForVadPath = this.f180173d;
                transferRequest.pcmForVadNum = list.size();
                transferRequest.pcmForVadPos = i3;
                transferRequest.vadSeg = list.get(i3);
                transferRequest.chatType = this.f180171b;
                this.f180174e.transferAsync(transferRequest);
                this.f180179j.add(Long.valueOf(transferRequest.mUniseq));
            }
        }
    }

    public void i() {
        if (QLog.isColorLevel()) {
            QLog.d("VoiceTextEdtiController", 2, "cancelAllRequest sendIds len=" + this.f180179j.size());
        }
        for (int i3 = 0; i3 < this.f180179j.size(); i3++) {
            j(this.f180170a, this.f180179j.get(i3).longValue());
        }
        this.f180179j.clear();
        this.f180175f.set(0);
    }

    public void j(String str, long j3) {
        if (str != null && j3 != 0) {
            Iterator<Map.Entry<String, IHttpCommunicatorListener>> it = ((ITransFileController) this.f180172c.getRuntimeService(ITransFileController.class, "")).getProcessMap().entrySet().iterator();
            while (it.hasNext()) {
                IHttpCommunicatorListener value = it.next().getValue();
                boolean z16 = false;
                if (value != null && (value instanceof PttSliceUploadProcessor) && ((BaseTransProcessor) value).getFileStatus() != Constant.FROM_ID_START_ACTIVITY) {
                    z16 = true;
                }
                if (z16) {
                    BaseTransProcessor baseTransProcessor = (BaseTransProcessor) value;
                    if (str.equals(baseTransProcessor.mUiRequest.mPeerUin) && j3 == baseTransProcessor.mUiRequest.mUniseq) {
                        baseTransProcessor.cancel();
                        if (QLog.isColorLevel()) {
                            QLog.d("cancelpic", 2, "PttSliceUploadProcessor cancelVoiceTextTask:" + baseTransProcessor.mUiRequest.mUniseq);
                        }
                    }
                }
            }
        }
    }

    public void m(String str) {
        ThreadManagerV2.excute(new PttVadRunnable(this, str), 128, null, true);
    }

    int n(int i3) {
        int i16;
        if (i3 == 3000) {
            i16 = 1;
        } else {
            i16 = 2;
        }
        if (i3 == 0) {
            return 2;
        }
        return i16;
    }

    String o(d71.a aVar, int i3) {
        d71.a aVar2;
        this.f180177h[i3] = aVar;
        StringBuffer stringBuffer = new StringBuffer();
        int i16 = 0;
        while (true) {
            d71.a[] aVarArr = this.f180177h;
            if (i16 >= aVarArr.length || (aVar2 = aVarArr[i16]) == null) {
                break;
            }
            stringBuffer.append(aVar2.f393133a);
            if (!aVar2.f393134b) {
                break;
            }
            i16++;
        }
        return stringBuffer.toString();
    }

    public void p(String str, AppRuntime appRuntime, c71.b bVar, int i3, String str2) {
        this.f180173d = str;
        this.f180178i = bVar;
        this.f180172c = appRuntime;
        this.f180171b = i3;
        this.f180170a = str2;
        this.f180171b = n(i3);
        this.f180181l.addFilterDistinct(PttSliceUploadProcessor.class);
    }

    public void r() {
        s();
    }

    public void s() {
        ITransFileController iTransFileController = this.f180174e;
        if (iTransFileController != null) {
            iTransFileController.removeHandle(this.f180181l);
        }
    }

    public void u(c71.b bVar) {
        this.f180178i = bVar;
    }

    void v(d71.a aVar, int i3) {
        d71.a[] aVarArr = this.f180177h;
        if (aVarArr == null) {
            QLog.i("VoiceTextEdtiController", 1, "updateText failed, sttResultBeans == null");
            return;
        }
        if (i3 >= aVarArr.length) {
            QLog.i("VoiceTextEdtiController", 1, "updateText failed, pos:" + i3 + ", sttResultBeans.length:" + this.f180177h.length);
            return;
        }
        d71.a aVar2 = aVarArr[i3];
        if (aVar2 != null && aVar2.f393134b) {
            QLog.i("VoiceTextEdtiController", 1, "updateText failed, sttResultBeans:" + this.f180177h[i3] + " pos:" + i3);
            return;
        }
        String o16 = o(aVar, i3);
        c71.b bVar = this.f180178i;
        if (bVar != null) {
            bVar.b(o16);
        }
    }
}

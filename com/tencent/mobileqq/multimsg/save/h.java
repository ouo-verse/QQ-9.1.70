package com.tencent.mobileqq.multimsg.save;

import android.os.Environment;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.image.Utils;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForPic;
import com.tencent.mobileqq.data.MessageForShortVideo;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.pic.ac;
import com.tencent.mobileqq.pic.api.IPicBus;
import com.tencent.mobileqq.pic.m;
import com.tencent.mobileqq.pic.q;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.shortvideo.ShortVideoUtils;
import com.tencent.mobileqq.shortvideo.ad;
import com.tencent.mobileqq.shortvideo.u;
import com.tencent.mobileqq.shortvideo.v;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.transfile.AbsDownloader;
import com.tencent.mobileqq.transfile.BaseDownloadProcessor;
import com.tencent.mobileqq.transfile.BaseTransFileController;
import com.tencent.mobileqq.transfile.URLDrawableHelper;
import com.tencent.mobileqq.transfile.api.ITransFileController;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.httputils.IHttpCommunicatorListener;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.VersionUtils;
import java.io.File;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import mqq.manager.Manager;

/* compiled from: P */
/* loaded from: classes15.dex */
public class h implements Manager, Handler.Callback {
    static IPatchRedirector $redirector_;
    private long C;
    private Handler D;

    /* renamed from: d, reason: collision with root package name */
    private QQAppInterface f251686d;

    /* renamed from: e, reason: collision with root package name */
    private ConcurrentHashMap<String, d> f251687e;

    /* renamed from: f, reason: collision with root package name */
    protected com.tencent.mobileqq.activity.aio.photo.i f251688f;

    /* renamed from: h, reason: collision with root package name */
    private boolean f251689h;

    /* renamed from: i, reason: collision with root package name */
    private boolean f251690i;

    /* renamed from: m, reason: collision with root package name */
    private boolean f251691m;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes15.dex */
    public class a extends ac.a {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ long f251692d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ int f251693e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ int f251694f;

        /* renamed from: h, reason: collision with root package name */
        final /* synthetic */ long f251695h;

        /* renamed from: i, reason: collision with root package name */
        final /* synthetic */ String f251696i;

        /* renamed from: m, reason: collision with root package name */
        final /* synthetic */ String f251697m;

        a(long j3, int i3, int i16, long j16, String str, String str2) {
            this.f251692d = j3;
            this.f251693e = i3;
            this.f251694f = i16;
            this.f251695h = j16;
            this.f251696i = str;
            this.f251697m = str2;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, h.this, Long.valueOf(j3), Integer.valueOf(i3), Integer.valueOf(i16), Long.valueOf(j16), str, str2);
            }
        }

        @Override // com.tencent.mobileqq.pic.ac
        public void b(int i3, boolean z16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, Integer.valueOf(i3), Boolean.valueOf(z16));
                return;
            }
            com.tencent.mobileqq.activity.aio.photo.i iVar = h.this.f251688f;
            if (iVar != null) {
                iVar.notifyImageProgress(this.f251692d, this.f251693e, this.f251694f, i3, this.f251695h, z16);
            }
            d u16 = h.this.u(this.f251696i);
            if (u16 != null && !u16.f251678a) {
                if (h.this.f251691m) {
                    h.this.n(u16.f251684g, i3);
                    return;
                }
                int i16 = i3 / 100;
                u16.f251682e = i16;
                h.this.O(this.f251696i, u16);
                h.this.J(u16, i16);
            }
        }

        @Override // com.tencent.mobileqq.pic.ac
        public void g(int i3, q qVar) {
            int i16;
            int i17;
            boolean z16;
            m.a aVar;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, i3, (Object) qVar);
                return;
            }
            int i18 = 2;
            if (QLog.isColorLevel()) {
                QLog.i("MultiRichMediaSaveManager", 2, "downloadRawImage id = " + this.f251692d + ", result = " + i3);
            }
            d u16 = h.this.u(this.f251696i);
            if (u16 != null && !u16.f251678a) {
                u16.f251679b = i3;
                if (i3 == 0) {
                    i16 = 1;
                } else {
                    i16 = 2;
                }
                u16.f251684g.f251674a = 1;
                if (qVar != null) {
                    int i19 = qVar.f258790a;
                    u16.f251679b = i19;
                    if (i19 != 0 && (aVar = qVar.f258791b) != null) {
                        u16.f251680c = aVar.f258738c;
                        u16.f251681d = aVar.f258737b;
                    }
                    if (i19 == 0) {
                        i18 = 1;
                    }
                    z16 = qVar.f258794e;
                    i17 = i18;
                } else {
                    i17 = i16;
                    z16 = false;
                }
                u16.f251685h = new p(this.f251692d, this.f251693e, this.f251694f, i17, this.f251697m, z16);
                h.this.O(this.f251696i, u16);
                h.this.m(u16.f251684g, 0, u16.f251680c, u16.f251681d);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes15.dex */
    public class b implements ad {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ long f251698a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ c f251699b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ String f251700c;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ int f251701d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ int f251702e;

        b(long j3, c cVar, String str, int i3, int i16) {
            this.f251698a = j3;
            this.f251699b = cVar;
            this.f251700c = str;
            this.f251701d = i3;
            this.f251702e = i16;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, h.this, Long.valueOf(j3), cVar, str, Integer.valueOf(i3), Integer.valueOf(i16));
            }
        }

        @Override // com.tencent.mobileqq.shortvideo.ad
        public void onComplete(int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            int i16 = 2;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, i3);
                return;
            }
            if (QLog.isColorLevel()) {
                QLog.i("MultiRichMediaSaveManager", 2, "downloadVideo id = " + this.f251698a + ", result =" + i3);
            }
            MessageForShortVideo messageForShortVideo = this.f251699b.f251676c.F;
            if (messageForShortVideo != null) {
                String j3 = com.tencent.mobileqq.shortvideo.j.j(messageForShortVideo, "mp4");
                d u16 = h.this.u(this.f251700c);
                if (u16 != null && !u16.f251678a) {
                    u16.f251679b = i3;
                    u16.f251684g.f251674a = 3;
                    if (i3 == 0) {
                        i16 = 1;
                    }
                    u16.f251685h = new p(this.f251698a, this.f251701d, this.f251702e, i16, j3, false);
                    h.this.O(this.f251700c, u16);
                    h.this.o(u16.f251684g, 0, 0, "");
                }
            }
        }

        @Override // com.tencent.mobileqq.shortvideo.ad
        public void onProgress(int i3) {
            d u16;
            MessageForShortVideo messageForShortVideo;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, i3);
                return;
            }
            com.tencent.mobileqq.activity.aio.photo.i iVar = h.this.f251688f;
            if (iVar != null && (messageForShortVideo = this.f251699b.f251676c.F) != null) {
                iVar.notifyImageProgress(this.f251698a, this.f251701d, this.f251702e, i3, messageForShortVideo.videoFileSize, true);
            }
            if (this.f251699b.f251676c != null && (u16 = h.this.u(this.f251700c)) != null && !u16.f251678a) {
                u16.f251682e = i3;
                h.this.O(this.f251700c, u16);
                if (h.this.f251691m) {
                    h.this.l(u16, u16.f251682e);
                } else {
                    h.this.J(u16, i3);
                }
            }
        }
    }

    public h(QQAppInterface qQAppInterface) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) qQAppInterface);
            return;
        }
        this.f251687e = new ConcurrentHashMap<>();
        this.f251689h = false;
        this.f251690i = false;
        this.f251691m = false;
        this.C = 0L;
        this.f251686d = qQAppInterface;
        this.D = new Handler(Looper.getMainLooper(), this);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    private void B(c cVar) {
        String str;
        if (cVar != null) {
            switch (cVar.f251674a) {
                case 1:
                    com.tencent.mobileqq.pic.p pVar = cVar.f251675b;
                    if (pVar != null) {
                        str = r(pVar.f258788m);
                        break;
                    }
                    str = "";
                    break;
                case 2:
                case 3:
                    v vVar = cVar.f251676c;
                    if (vVar != null) {
                        str = t(vVar.f288268i);
                        break;
                    }
                    str = "";
                    break;
                case 4:
                case 5:
                case 6:
                case 7:
                default:
                    str = "";
                    break;
            }
            C(str);
        }
    }

    private void D(d dVar) {
        if (dVar != null) {
            HashMap<String, String> hashMap = new HashMap<>();
            if (dVar.f251683f == 1) {
                hashMap.put("isMultiSave", "1");
            } else {
                hashMap.put("isMultiSave", "0");
            }
            if (dVar.f251679b == 0) {
                hashMap.put("isSuccess", "0");
            } else {
                hashMap.put("isSuccess", "1");
                hashMap.put("errorCode", String.valueOf(dVar.f251680c));
                hashMap.put("isSuccess", dVar.f251681d);
            }
            StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance(null, "MultiRichMediaFileSave", true, 0L, 0L, hashMap, "");
        }
    }

    private void E() {
        if (QLog.isColorLevel()) {
            QLog.i("MultiRichMediaSaveManager", 2, "saveCancel");
        }
        this.f251691m = false;
        this.C = 0L;
    }

    private void G(String str, String str2, d dVar) {
        int i3;
        if (TextUtils.isEmpty(str)) {
            i3 = 10001;
        } else if (TextUtils.isEmpty(str2)) {
            i3 = 10002;
        } else if (!FileUtils.fileExists(str)) {
            i3 = 10003;
        } else {
            i3 = 0;
        }
        if (i3 != 0) {
            if (QLog.isColorLevel()) {
                QLog.e("MultiRichMediaSaveManager", 2, "savePictureFile fail, errorCode = " + i3);
            }
            if (dVar != null && dVar.f251684g != null) {
                dVar.f251679b = -1;
                dVar.f251680c = i3;
                dVar.f251681d = com.tencent.mobileqq.multimsg.save.b.a(i3);
                L(dVar);
                return;
            }
            return;
        }
        String str3 = AppConstants.SDCARD_IMG_SAVE;
        new File(str3).mkdirs();
        if (!str2.contains(".")) {
            str2 = str2 + "." + FileUtils.estimateFileType(str);
        }
        ThreadManager.getFileThreadHandler().post(new FileSaveRunnable(new File(str), new File(str3, str2), this.D, dVar, false));
    }

    private void I(String str, String str2, d dVar) {
        int i3;
        File file;
        if (TextUtils.isEmpty(str)) {
            i3 = 10001;
        } else if (TextUtils.isEmpty(str2)) {
            i3 = 10002;
        } else if (!FileUtils.fileExists(str)) {
            i3 = 10003;
        } else {
            i3 = 0;
        }
        if (i3 != 0) {
            if (QLog.isColorLevel()) {
                QLog.e("MultiRichMediaSaveManager", 2, "saveShortVideoFile fail, errorCode = " + i3);
            }
            if (dVar != null && dVar.f251684g != null) {
                dVar.f251679b = -1;
                dVar.f251680c = i3;
                dVar.f251681d = com.tencent.mobileqq.multimsg.save.b.a(i3);
                L(dVar);
                return;
            }
            return;
        }
        if (VersionUtils.isrFroyo()) {
            file = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_MOVIES);
        } else {
            file = new File(AppConstants.SDCARD_VIDEO);
        }
        file.mkdirs();
        ThreadManager.getFileThreadHandler().post(new FileSaveRunnable(new File(str), new File(file, ShortVideoUtils.getShortVideoSaveFileName(str2)), this.D, dVar, false));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void J(d dVar, int i3) {
        Message obtainMessage = this.D.obtainMessage(6);
        obtainMessage.obj = dVar;
        obtainMessage.arg1 = i3;
        this.D.sendMessage(obtainMessage);
    }

    private void K(d dVar, long j3) {
        Message obtainMessage = this.D.obtainMessage(4);
        obtainMessage.obj = dVar;
        this.D.sendMessageDelayed(obtainMessage, j3);
    }

    private void L(d dVar) {
        Message obtainMessage = this.D.obtainMessage(2);
        obtainMessage.obj = dVar;
        this.D.sendMessage(obtainMessage);
    }

    private void M(d dVar) {
        Message obtainMessage = this.D.obtainMessage(5);
        obtainMessage.obj = dVar;
        this.D.sendMessage(obtainMessage);
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:11:0x0029. Please report as an issue. */
    private void f(d dVar, int i3) {
        int i16;
        c cVar;
        MessageForPic messageForPic;
        long j3;
        float f16;
        float f17;
        int i17;
        MessageForShortVideo messageForShortVideo;
        Iterator<Map.Entry<String, d>> it = this.f251687e.entrySet().iterator();
        long j16 = 0;
        while (it.hasNext()) {
            d value = it.next().getValue();
            if (value != null && (cVar = value.f251684g) != null) {
                switch (cVar.f251674a) {
                    case 1:
                        com.tencent.mobileqq.pic.p pVar = cVar.f251675b;
                        if (pVar != null && (messageForPic = pVar.H) != null) {
                            if (value.f251678a) {
                                j3 = messageForPic.size;
                                j16 += j3;
                                break;
                            } else {
                                f16 = (float) j16;
                                f17 = (float) messageForPic.size;
                                i17 = value.f251682e;
                                j16 = f16 + (f17 * (i17 / 100.0f));
                                break;
                            }
                        }
                        break;
                    case 2:
                    case 3:
                        v vVar = cVar.f251676c;
                        if (vVar != null && (messageForShortVideo = vVar.F) != null) {
                            if (value.f251678a) {
                                j3 = messageForShortVideo.videoFileSize;
                                j16 += j3;
                                break;
                            } else {
                                f16 = (float) j16;
                                f17 = messageForShortVideo.videoFileSize;
                                i17 = value.f251682e;
                                j16 = f16 + (f17 * (i17 / 100.0f));
                                break;
                            }
                        }
                        break;
                    case 4:
                    case 5:
                    case 6:
                    case 7:
                    case 8:
                    case 9:
                        cVar.getClass();
                        break;
                }
            }
        }
        long j17 = this.C;
        if (j17 > 0) {
            i16 = (int) ((j16 * 100) / j17);
        } else {
            i16 = 0;
        }
        if (QLog.isColorLevel()) {
            QLog.i("MultiRichMediaSaveManager", 2, "calculateWholeProgress totalProgress = " + i16);
        }
        dVar.f251683f = 0;
        J(dVar, i16);
    }

    private void g() {
        c cVar;
        if (QLog.isColorLevel()) {
            QLog.i("MultiRichMediaSaveManager", 2, "cancelDownloading");
        }
        if (this.f251687e.isEmpty()) {
            return;
        }
        Iterator<Map.Entry<String, d>> it = this.f251687e.entrySet().iterator();
        while (it.hasNext()) {
            d value = it.next().getValue();
            if (value != null && (cVar = value.f251684g) != null) {
                switch (cVar.f251674a) {
                    case 1:
                        com.tencent.mobileqq.pic.p pVar = cVar.f251675b;
                        if (pVar != null && pVar.H != null) {
                            ITransFileController iTransFileController = (ITransFileController) this.f251686d.getRuntimeService(ITransFileController.class);
                            MessageForPic messageForPic = value.f251684g.f251675b.H;
                            IHttpCommunicatorListener findProcessor = iTransFileController.findProcessor(BaseTransFileController.makeReceiveKey(messageForPic.md5, messageForPic.uuid, 131075));
                            if (findProcessor == null) {
                                ITransFileController iTransFileController2 = (ITransFileController) this.f251686d.getRuntimeService(ITransFileController.class);
                                MessageForPic messageForPic2 = value.f251684g.f251675b.H;
                                findProcessor = iTransFileController2.findProcessor(BaseTransFileController.makeReceiveKey(messageForPic2.md5, messageForPic2.uuid, 1));
                            }
                            if (!(findProcessor instanceof BaseDownloadProcessor)) {
                                break;
                            } else {
                                ((BaseDownloadProcessor) findProcessor).cancel();
                                break;
                            }
                        }
                        break;
                    case 2:
                        v vVar = cVar.f251676c;
                        if (vVar != null) {
                            com.tencent.mobileqq.shortvideo.n nVar = vVar.f288268i;
                        }
                        ITransFileController iTransFileController3 = (ITransFileController) this.f251686d.getRuntimeService(ITransFileController.class);
                        com.tencent.mobileqq.shortvideo.n nVar2 = value.f251684g.f251676c.f288268i;
                        IHttpCommunicatorListener findProcessor2 = iTransFileController3.findProcessor(nVar2.f288043f, nVar2.f288045h);
                        if (!(findProcessor2 instanceof BaseDownloadProcessor)) {
                            break;
                        } else {
                            ((BaseDownloadProcessor) findProcessor2).cancel();
                            break;
                        }
                    case 3:
                        v vVar2 = cVar.f251676c;
                        if (vVar2 != null && vVar2.F != null) {
                            ((u) this.f251686d.getManager(QQManagerFactory.SHORT_VIDEO_PREDOWNLOAD_MANAGER)).v(value.f251684g);
                            break;
                        }
                        break;
                    case 4:
                    case 5:
                    case 6:
                    case 7:
                        cVar.getClass();
                        break;
                }
            }
        }
    }

    private void k() {
        c cVar;
        if (!this.f251687e.isEmpty()) {
            Iterator<Map.Entry<String, d>> it = this.f251687e.entrySet().iterator();
            while (it.hasNext()) {
                d value = it.next().getValue();
                if (value != null && (cVar = value.f251684g) != null) {
                    cVar.f251677d.clear();
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void l(d dVar, int i3) {
        if (dVar != null) {
            dVar.f251682e = i3;
            f(dVar, i3);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void m(c cVar, int i3, int i16, String str) {
        com.tencent.mobileqq.pic.p pVar;
        com.tencent.mobileqq.pic.k kVar;
        String r16;
        d u16;
        if (cVar != null && (pVar = cVar.f251675b) != null && (kVar = pVar.f258788m) != null && (u16 = u((r16 = r(kVar)))) != null && u16.f251684g != null && !u16.f251678a) {
            u16.f251678a = true;
            u16.f251679b = i3;
            u16.f251682e = 100;
            O(r16, u16);
            if (i3 == 0) {
                String d16 = cVar.f251675b.f258788m.d();
                G(d16, Utils.Crc64String(d16 + NetConnInfoCenter.getServerTime()), u16);
                return;
            }
            u16.f251680c = i16;
            u16.f251681d = str;
            if (QLog.isColorLevel()) {
                QLog.d("MultiRichMediaSaveManager", 2, "dealPicDownloadComplete errorCode= " + i16 + ", errorDec= " + str);
            }
            L(u16);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void n(c cVar, int i3) {
        com.tencent.mobileqq.pic.p pVar;
        String r16;
        d u16;
        if (cVar != null && (pVar = cVar.f251675b) != null && (u16 = u((r16 = r(pVar.f258788m)))) != null && !u16.f251678a) {
            int i16 = i3 / 100;
            u16.f251682e = i16;
            O(r16, u16);
            l(u16, i16);
        }
    }

    private boolean v() {
        if (!this.f251687e.isEmpty()) {
            Iterator<Map.Entry<String, d>> it = this.f251687e.entrySet().iterator();
            while (it.hasNext()) {
                d value = it.next().getValue();
                if (value == null || !value.f251678a) {
                    return false;
                }
            }
        }
        return true;
    }

    private void y(d dVar) {
        com.tencent.mobileqq.activity.aio.photo.i iVar;
        if (QLog.isColorLevel()) {
            QLog.i("MultiRichMediaSaveManager", 2, "notifySingleComplete");
        }
        if (dVar != null) {
            F(dVar);
            p pVar = dVar.f251685h;
            if (pVar != null && (iVar = this.f251688f) != null) {
                iVar.notifyImageResult(pVar.f251731a, pVar.f251732b, pVar.f251733c, pVar.f251734d, pVar.f251735e, pVar.f251736f);
            }
        }
    }

    private void z(c cVar) {
        if (cVar != null) {
            Iterator<g> it = cVar.f251677d.iterator();
            while (it.hasNext()) {
                it.next().a();
            }
        }
    }

    public void A(com.tencent.mobileqq.activity.aio.photo.i iVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this, (Object) iVar);
        } else {
            this.f251688f = iVar;
        }
    }

    public void C(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            iPatchRedirector.redirect((short) 16, (Object) this, (Object) str);
            return;
        }
        if (!TextUtils.isEmpty(str)) {
            try {
                this.f251687e.remove(str);
            } catch (Exception e16) {
                if (QLog.isColorLevel()) {
                    QLog.i("MultiRichMediaSaveManager", 2, "removeFileSaveResult exception = " + e16.getMessage());
                }
            }
        }
    }

    public void F(d dVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 22)) {
            iPatchRedirector.redirect((short) 22, (Object) this, (Object) dVar);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.i("MultiRichMediaSaveManager", 2, "saveComplete");
        }
        if (dVar != null) {
            if (dVar.f251683f == 1) {
                c cVar = dVar.f251684g;
                if (cVar != null) {
                    Iterator<g> it = cVar.f251677d.iterator();
                    while (it.hasNext()) {
                        g next = it.next();
                        if (dVar.f251679b == 0) {
                            next.b(dVar, 100);
                        }
                        next.d(dVar);
                    }
                }
                B(dVar.f251684g);
                D(dVar);
                return;
            }
            this.f251691m = false;
            this.C = 0L;
            this.f251687e.clear();
            D(dVar);
        }
    }

    public void H(d dVar, int i3) {
        c cVar;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 23)) {
            iPatchRedirector.redirect((short) 23, (Object) this, (Object) dVar, i3);
            return;
        }
        if (dVar != null && dVar.f251683f == 1 && (cVar = dVar.f251684g) != null) {
            Iterator<g> it = cVar.f251677d.iterator();
            while (it.hasNext()) {
                it.next().b(dVar, i3);
            }
        }
    }

    public void N() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this);
        } else {
            this.f251688f = null;
        }
    }

    public void O(String str, d dVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            iPatchRedirector.redirect((short) 17, (Object) this, (Object) str, (Object) dVar);
        } else if (!TextUtils.isEmpty(str)) {
            this.f251687e.put(str, dVar);
        }
    }

    public void h(MessageForPic messageForPic, long j3, int i3, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 26)) {
            iPatchRedirector.redirect((short) 26, this, messageForPic, Long.valueOf(j3), Integer.valueOf(i3), Integer.valueOf(i16));
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.i("MultiRichMediaSaveManager", 2, "cancelSavePic id = " + j3);
        }
        String s16 = s(messageForPic);
        d u16 = u(s16);
        if (u16 != null) {
            u16.f251678a = true;
            u16.f251679b = -1;
            O(s16, u16);
            M(u16);
            C(s16);
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        d dVar;
        c cVar;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return ((Boolean) iPatchRedirector.redirect((short) 11, (Object) this, (Object) message)).booleanValue();
        }
        Object obj = message.obj;
        if ((obj instanceof d) && (cVar = (dVar = (d) obj).f251684g) != null) {
            int i3 = message.what;
            switch (i3) {
                case 1:
                case 2:
                    if (dVar.f251683f == 1) {
                        y(dVar);
                        return true;
                    }
                    if (i3 == 2) {
                        this.f251689h = true;
                        if (QLog.isColorLevel()) {
                            QLog.i("MultiRichMediaSaveManager", 2, "MSG_TYPE_SAVE_FAIL errorCode = " + dVar.f251680c + ", errorMsg = " + dVar.f251681d);
                        }
                    } else {
                        this.f251690i = true;
                    }
                    Iterator<g> it = dVar.f251684g.f251677d.iterator();
                    while (it.hasNext()) {
                        it.next().d(dVar);
                    }
                    if (v()) {
                        J(dVar, 100);
                        boolean z16 = this.f251690i;
                        if (z16 && !this.f251689h) {
                            dVar.f251679b = 0;
                        } else if (this.f251689h && !z16) {
                            dVar.f251679b = -1;
                        } else {
                            dVar.f251679b = 3;
                        }
                        if (QLog.isColorLevel()) {
                            QLog.i("MultiRichMediaSaveManager", 2, "last result = " + dVar.f251679b);
                        }
                        this.f251689h = false;
                        this.f251690i = false;
                        K(dVar, 200L);
                        break;
                    }
                    break;
                case 3:
                    Iterator<g> it5 = cVar.f251677d.iterator();
                    while (it5.hasNext()) {
                        it5.next().c(dVar);
                    }
                    break;
                case 4:
                    F(dVar);
                    break;
                case 5:
                    if (dVar.f251683f == 1) {
                        z(cVar);
                        break;
                    }
                    break;
                case 6:
                    H(dVar, message.arg1);
                    break;
            }
        }
        return true;
    }

    public void i(MessageForShortVideo messageForShortVideo, long j3, int i3, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 27)) {
            iPatchRedirector.redirect((short) 27, this, messageForShortVideo, Long.valueOf(j3), Integer.valueOf(i3), Integer.valueOf(i16));
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.i("MultiRichMediaSaveManager", 2, "cancelSaveVideo id = " + j3);
        }
        if (i16 != 256) {
            if (QLog.isColorLevel()) {
                QLog.i("MultiRichMediaSaveManager", 2, "cancelSaveVideo type = " + i16);
                return;
            }
            return;
        }
        String s16 = s(messageForShortVideo);
        d u16 = u(s16);
        if (u16 != null) {
            u16.f251678a = true;
            u16.f251679b = -1;
            O(s16, u16);
            M(u16);
        }
        ((u) this.f251686d.getManager(QQManagerFactory.SHORT_VIDEO_PREDOWNLOAD_MANAGER)).v(c.b(this.f251686d, messageForShortVideo));
        C(s16);
    }

    public void j() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 29)) {
            iPatchRedirector.redirect((short) 29, (Object) this);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.i("MultiRichMediaSaveManager", 2, "clearFileSaveRequest");
        }
        k();
        this.f251687e.clear();
        this.f251689h = false;
        this.f251690i = false;
        this.f251691m = false;
        this.C = 0L;
        this.D.removeCallbacksAndMessages(null);
    }

    public void o(c cVar, int i3, int i16, String str) {
        v vVar;
        com.tencent.mobileqq.shortvideo.n nVar;
        String t16;
        d u16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            iPatchRedirector.redirect((short) 19, this, cVar, Integer.valueOf(i3), Integer.valueOf(i16), str);
            return;
        }
        if (cVar != null && (vVar = cVar.f251676c) != null && (nVar = vVar.f288268i) != null && (u16 = u((t16 = t(nVar)))) != null && u16.f251684g != null && !u16.f251678a) {
            u16.f251678a = true;
            u16.f251679b = i3;
            u16.f251682e = 100;
            O(t16, u16);
            if (i3 == 0) {
                File file = new File(cVar.f251676c.f288268i.f288193q);
                if (!file.exists() && QLog.isColorLevel()) {
                    QLog.d("MultiRichMediaSaveManager", 2, "dealShortVideoDownloadComplete srcFile not exists");
                }
                String absolutePath = file.getAbsolutePath();
                StringBuilder sb5 = new StringBuilder();
                sb5.append((file.getParentFile().getName() + NetConnInfoCenter.getServerTime()).toLowerCase(Locale.US));
                sb5.append(".mp4");
                I(absolutePath, sb5.toString(), u16);
                return;
            }
            u16.f251680c = i16;
            u16.f251681d = str;
            if (QLog.isColorLevel()) {
                QLog.d("MultiRichMediaSaveManager", 2, "dealShortVideoDownloadComplete errorCode= " + i16 + ", errorDec= " + str);
            }
            L(u16);
        }
    }

    @Override // mqq.manager.Manager
    public void onDestroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 28)) {
            iPatchRedirector.redirect((short) 28, (Object) this);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.i("MultiRichMediaSaveManager", 2, MosaicConstants$JsFunction.FUNC_ON_DESTROY);
        }
        E();
        g();
        j();
    }

    public void p(MessageForPic messageForPic, long j3, int i3, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 24)) {
            iPatchRedirector.redirect((short) 24, this, messageForPic, Long.valueOf(j3), Integer.valueOf(i3), Integer.valueOf(i16));
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.i("MultiRichMediaSaveManager", 2, "downloadRawImage id = " + j3);
        }
        if (i16 != 24) {
            if (QLog.isColorLevel()) {
                QLog.i("MultiRichMediaSaveManager", 2, "downloadRawImage type = " + i16);
                return;
            }
            return;
        }
        try {
            com.tencent.mobileqq.pic.p createPicReq = ((IPicBus) QRoute.api(IPicBus.class)).createPicReq(7, 1);
            createPicReq.d(messageForPic, messageForPic.getPicDownloadInfo());
            String filePath = AbsDownloader.getFilePath(URLDrawableHelper.getURL(messageForPic, 131075, null).toString().toString());
            long j16 = messageForPic.size;
            String r16 = r(messageForPic.getPicDownloadInfo());
            if (u(r16) == null) {
                d dVar = new d();
                dVar.f251684g = c.a(messageForPic);
                dVar.f251683f = 1;
                O(r16, dVar);
            }
            createPicReq.g(new a(j3, i3, i16, j16, r16, filePath));
            ((IPicBus) QRoute.api(IPicBus.class)).launch(createPicReq);
        } catch (Exception e16) {
            if (QLog.isColorLevel()) {
                QLog.i("MultiRichMediaSaveManager", 2, "downloadRawImage exception = " + e16.getMessage());
            }
        }
    }

    public void q(MessageForShortVideo messageForShortVideo, long j3, int i3, int i16) {
        MessageForShortVideo messageForShortVideo2;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 25)) {
            iPatchRedirector.redirect((short) 25, this, messageForShortVideo, Long.valueOf(j3), Integer.valueOf(i3), Integer.valueOf(i16));
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.i("MultiRichMediaSaveManager", 2, "downloadVideo id = " + j3);
        }
        if (i16 != 256) {
            if (QLog.isColorLevel()) {
                QLog.i("MultiRichMediaSaveManager", 2, "downloadVideo type = " + i16);
                return;
            }
            return;
        }
        try {
            c b16 = c.b(this.f251686d, messageForShortVideo);
            if (b16 != null && b16.f251676c != null) {
                String t16 = t(messageForShortVideo.getDownloadInfo(messageForShortVideo.busiType));
                if (u(t16) == null) {
                    d dVar = new d();
                    dVar.f251684g = b16;
                    dVar.f251683f = 1;
                    O(t16, dVar);
                }
                if (w(b16) && (messageForShortVideo2 = b16.f251676c.F) != null && this.f251688f != null) {
                    this.f251688f.notifyImageResult(j3, i3, i16, 1, com.tencent.mobileqq.shortvideo.j.j(messageForShortVideo2, "mp4"), false);
                    return;
                }
                v vVar = b16.f251676c;
                vVar.J = true;
                vVar.K = new b(j3, b16, t16, i3, i16);
                ((u) this.f251686d.getManager(QQManagerFactory.SHORT_VIDEO_PREDOWNLOAD_MANAGER)).x(b16);
            }
        } catch (Exception e16) {
            if (QLog.isColorLevel()) {
                QLog.d("MultiRichMediaSaveManager", 2, "dealSaveVideo exception: " + e16.getMessage());
            }
        }
    }

    public String r(com.tencent.mobileqq.pic.k kVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            return (String) iPatchRedirector.redirect((short) 12, (Object) this, (Object) kVar);
        }
        if (kVar != null) {
            return kVar.f258715m + kVar.D;
        }
        return "";
    }

    public String s(ChatMessage chatMessage) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            return (String) iPatchRedirector.redirect((short) 13, (Object) this, (Object) chatMessage);
        }
        if (chatMessage != null) {
            return chatMessage.frienduin + chatMessage.uniseq;
        }
        return "";
    }

    public String t(com.tencent.mobileqq.shortvideo.n nVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            return (String) iPatchRedirector.redirect((short) 14, (Object) this, (Object) nVar);
        }
        if (nVar != null) {
            return nVar.f288043f + nVar.f288045h;
        }
        return "";
    }

    public d u(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            return (d) iPatchRedirector.redirect((short) 15, (Object) this, (Object) str);
        }
        return this.f251687e.get(str);
    }

    public boolean w(c cVar) {
        MessageForPic messageForPic;
        com.tencent.mobileqq.pic.k picDownloadInfo;
        String j3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            return ((Boolean) iPatchRedirector.redirect((short) 18, (Object) this, (Object) cVar)).booleanValue();
        }
        if (cVar == null) {
            if (QLog.isColorLevel()) {
                QLog.d("MultiRichMediaSaveManager", 2, "isFileExist fileSaveReq is empty!");
            }
            return false;
        }
        switch (cVar.f251674a) {
            case 1:
                com.tencent.mobileqq.pic.p pVar = cVar.f251675b;
                if (pVar == null || (messageForPic = pVar.H) == null || (picDownloadInfo = messageForPic.getPicDownloadInfo()) == null) {
                    return false;
                }
                String d16 = picDownloadInfo.d();
                if (TextUtils.isEmpty(d16)) {
                    return false;
                }
                File file = new File(d16);
                if (!file.exists() || file.length() != cVar.f251675b.H.size) {
                    return false;
                }
                if (QLog.isColorLevel()) {
                    QLog.d("MultiRichMediaSaveManager", 2, "isFileExist picture exists");
                    break;
                }
                break;
            case 2:
            case 3:
                v vVar = cVar.f251676c;
                if (vVar == null || (j3 = com.tencent.mobileqq.shortvideo.j.j(vVar.F, "mp4")) == null) {
                    return false;
                }
                File file2 = new File(j3);
                if (!file2.exists() || cVar.f251676c.F == null || file2.length() != cVar.f251676c.F.videoFileSize) {
                    return false;
                }
                if (QLog.isColorLevel()) {
                    QLog.d("MultiRichMediaSaveManager", 2, "isFileExist shortVideo exists");
                    break;
                }
                break;
            case 4:
            case 5:
            case 6:
            case 7:
            case 8:
            case 9:
            default:
                return false;
        }
        return true;
    }

    public boolean x(ChatMessage chatMessage) {
        d u16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            return ((Boolean) iPatchRedirector.redirect((short) 20, (Object) this, (Object) chatMessage)).booleanValue();
        }
        if (chatMessage == null || (u16 = u(s(chatMessage))) == null || u16.f251683f != 1 || u16.f251678a || u16.f251682e >= 100) {
            return false;
        }
        return true;
    }
}

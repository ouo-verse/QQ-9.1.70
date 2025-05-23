package com.tencent.av.business.manager;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import android.text.TextUtils;
import com.tencent.av.ManageConfig.QAVConfig;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.business.manager.pendant.c;
import com.tencent.av.n;
import com.tencent.av.r;
import com.tencent.av.temp.IExternalUtilsApi;
import com.tencent.av.utils.af;
import com.tencent.av.utils.ba;
import com.tencent.av.utils.e;
import com.tencent.avcore.util.AVCoreLog;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.app.face.util.FaceUtil;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.transfile.HttpNetReq;
import com.tencent.mobileqq.transfile.INetEngineListener;
import com.tencent.mobileqq.transfile.NetReq;
import com.tencent.mobileqq.transfile.NetResp;
import com.tencent.mobileqq.transfile.NetworkCenter;
import com.tencent.mobileqq.transfile.api.IHttpEngineService;
import com.tencent.mobileqq.util.JSONUtils;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.SecUtil;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.io.IOException;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes3.dex */
public abstract class EffectConfigBase<T extends com.tencent.av.business.manager.pendant.c> extends com.tencent.av.business.manager.a {
    protected List<WeakReference<b<T>>> C;
    protected final Checker D;
    int E;

    /* renamed from: h, reason: collision with root package name */
    protected T f73302h;

    /* renamed from: i, reason: collision with root package name */
    protected List<T> f73303i;

    /* renamed from: m, reason: collision with root package name */
    protected Handler f73304m;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes3.dex */
    public class NetReqRunnable implements Runnable {

        /* renamed from: d, reason: collision with root package name */
        final HttpNetReq f73305d;

        public NetReqRunnable(HttpNetReq httpNetReq) {
            this.f73305d = httpNetReq;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                VideoAppInterface videoAppInterface = EffectConfigBase.this.f73316e;
                if (videoAppInterface != null && this.f73305d != null) {
                    ((IHttpEngineService) videoAppInterface.getRuntimeService(IHttpEngineService.class, "all")).sendReq(this.f73305d);
                }
            } catch (Exception e16) {
                if (QLog.isColorLevel()) {
                    e16.printStackTrace();
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes3.dex */
    public class a implements INetEngineListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ long f73306d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ com.tencent.av.business.manager.pendant.c f73307e;

        a(long j3, com.tencent.av.business.manager.pendant.c cVar) {
            this.f73306d = j3;
            this.f73307e = cVar;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Removed duplicated region for block: B:12:0x0125  */
        /* JADX WARN: Removed duplicated region for block: B:14:? A[RETURN, SYNTHETIC] */
        /* JADX WARN: Type inference failed for: r6v10 */
        /* JADX WARN: Type inference failed for: r6v7 */
        /* JADX WARN: Type inference failed for: r6v9, types: [int, boolean] */
        @Override // com.tencent.mobileqq.transfile.INetEngineListener
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void onResp(NetResp netResp) {
            String qqStr;
            ?? r65;
            com.tencent.av.business.manager.pendant.c cVar = (com.tencent.av.business.manager.pendant.c) netResp.mReq.getUserData();
            int i3 = netResp.mResult;
            if (i3 == 3) {
                QLog.w(EffectConfigBase.this.f73315d, 1, "startDownload, onResp, \u91cd\u590d\u4e0b\u8f7d, item[" + cVar + "], seq[" + this.f73306d + "]");
                return;
            }
            if (i3 != 0) {
                qqStr = "fail, mErrCode[" + netResp.mErrCode + "], mErrDesc[" + netResp.mErrDesc + "]";
            } else {
                String fileMd5 = SecUtil.getFileMd5(netResp.mReq.mOutPath);
                if (!cVar.getMd5().equalsIgnoreCase(fileMd5)) {
                    qqStr = "fail, md5\u4e0d\u5339\u914d, fileMD5[" + fileMd5 + "], configMD5[" + cVar.getMd5() + "], mOutPath[" + netResp.mReq.mOutPath + "]";
                } else {
                    try {
                        FileUtils.uncompressZip(netResp.mReq.mOutPath, EffectConfigBase.this.y(this.f73307e), false);
                        qqStr = "";
                        r65 = 1;
                    } catch (IOException e16) {
                        if (QLog.isColorLevel()) {
                            QLog.i(EffectConfigBase.this.f73315d, 4, "startDownload, uncompressZip fail.", e16);
                        }
                        qqStr = HardCodeUtil.qqStr(R.string.m4u);
                    }
                    QLog.w(EffectConfigBase.this.f73315d, 1, "startDownload, onResp, result[" + ((boolean) r65) + "], resp.mResult[" + netResp.mResult + "], item[" + cVar + "], seq[" + this.f73306d + "], " + qqStr + "]");
                    cVar.isDownloading = false;
                    EffectConfigBase.this.f73304m.obtainMessage(1, r65, (int) this.f73306d, this.f73307e).sendToTarget();
                    if (r65 == 0) {
                        EffectConfigBase.this.D(this.f73307e);
                        return;
                    }
                    return;
                }
            }
            r65 = 0;
            QLog.w(EffectConfigBase.this.f73315d, 1, "startDownload, onResp, result[" + ((boolean) r65) + "], resp.mResult[" + netResp.mResult + "], item[" + cVar + "], seq[" + this.f73306d + "], " + qqStr + "]");
            cVar.isDownloading = false;
            EffectConfigBase.this.f73304m.obtainMessage(1, r65, (int) this.f73306d, this.f73307e).sendToTarget();
            if (r65 == 0) {
            }
        }

        @Override // com.tencent.mobileqq.transfile.INetEngineListener
        public void onUpdateProgeress(NetReq netReq, long j3, long j16) {
            EffectConfigBase.this.f73304m.obtainMessage(2, (int) ((j3 * 100) / j16), 0, this.f73307e).sendToTarget();
        }
    }

    /* compiled from: P */
    /* loaded from: classes3.dex */
    public interface b<T> {
        void onDownloadFinish(long j3, T t16, boolean z16);

        void onItemSelectedChanged(long j3, T t16);

        void onProgressUpdate(T t16, int i3);
    }

    /* compiled from: P */
    /* loaded from: classes3.dex */
    static class c<T extends com.tencent.av.business.manager.pendant.c> extends Handler {

        /* renamed from: a, reason: collision with root package name */
        final String f73309a;

        /* renamed from: b, reason: collision with root package name */
        WeakReference<EffectConfigBase<T>> f73310b;

        c(String str, EffectConfigBase<T> effectConfigBase) {
            super(Looper.getMainLooper());
            this.f73309a = str;
            this.f73310b = new WeakReference<>(effectConfigBase);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            long j3;
            boolean z16 = true;
            if (this.f73310b.get() != null) {
                EffectConfigBase<T> effectConfigBase = this.f73310b.get();
                int i3 = message.what;
                if (i3 != 0) {
                    if (i3 != 1) {
                        if (i3 == 2) {
                            effectConfigBase.Q((com.tencent.av.business.manager.pendant.c) message.obj, message.arg1);
                            return;
                        } else {
                            effectConfigBase.z(message);
                            return;
                        }
                    }
                    com.tencent.av.business.manager.pendant.c cVar = (com.tencent.av.business.manager.pendant.c) message.obj;
                    long j16 = message.arg2;
                    if (message.arg1 != 1) {
                        z16 = false;
                    }
                    effectConfigBase.P(j16, cVar, z16);
                    return;
                }
                com.tencent.av.business.manager.pendant.c cVar2 = (com.tencent.av.business.manager.pendant.c) message.obj;
                long j17 = message.arg1;
                boolean A = effectConfigBase.A(cVar2, effectConfigBase.f73302h);
                QLog.w(this.f73309a, 1, "MSG_ON_ITEM_SELECT_CHANGED, seq[" + j17 + "], isEqual[" + A + "], count_MSG[" + effectConfigBase.E + "], \nitem[" + cVar2 + "], \ncur[" + effectConfigBase.f73302h + "]");
                int i16 = effectConfigBase.E;
                if (i16 >= 0) {
                    effectConfigBase.E = i16 - 1;
                }
                if (A) {
                    effectConfigBase.O(j17, cVar2);
                    return;
                }
                return;
            }
            if (message.what == 0) {
                j3 = message.arg1;
            } else {
                j3 = 0;
            }
            QLog.w(this.f73309a, 1, "handleMessage, had destroy, msg[" + message.what + "], seq[" + j3 + "]");
        }
    }

    public EffectConfigBase(VideoAppInterface videoAppInterface) {
        super(videoAppInterface);
        this.D = new Checker();
        this.E = 0;
        this.f73304m = new c(this.f73315d, this);
        this.C = new ArrayList();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean A(T t16, T t17) {
        if (t16 == null) {
            if (t17 == null) {
                return true;
            }
        } else if (t17 != null && t16.getId().equals(t17.getId())) {
            return true;
        }
        return false;
    }

    private WeakReference<b<T>> K(b<T> bVar) {
        int size = this.C.size();
        for (int i3 = 0; i3 < size; i3++) {
            WeakReference<b<T>> weakReference = this.C.get(i3);
            if (weakReference != null && weakReference.get() != null && weakReference.get().equals(bVar)) {
                return weakReference;
            }
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void O(long j3, T t16) {
        int size = this.C.size();
        if (QLog.isDevelopLevel()) {
            QLog.w(this.f73315d, 1, "triggleonItemSelectedChanged, size[" + size + "], seq[" + j3 + "]");
        }
        for (int i3 = 0; i3 < size; i3++) {
            WeakReference<b<T>> weakReference = this.C.get(i3);
            if (weakReference != null && weakReference.get() != null) {
                weakReference.get().onItemSelectedChanged(j3, t16);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void P(long j3, T t16, boolean z16) {
        T w3;
        if (e.k()) {
            QLog.w(this.f73315d, 1, "triggleonResourceDownloadFinished, id[" + t16.getId() + "], isSuccess[" + z16 + "], seq[" + j3 + "]");
        }
        if (z16 && (w3 = w(t16.getId())) != null) {
            w3.setUsable(true);
        }
        int size = this.C.size();
        for (int i3 = 0; i3 < size; i3++) {
            WeakReference<b<T>> weakReference = this.C.get(i3);
            if (weakReference != null && weakReference.get() != null) {
                weakReference.get().onDownloadFinish(j3, t16, z16);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Q(T t16, int i3) {
        int size = this.C.size();
        for (int i16 = 0; i16 < size; i16++) {
            WeakReference<b<T>> weakReference = this.C.get(i16);
            if (weakReference != null && weakReference.get() != null) {
                weakReference.get().onProgressUpdate(t16, i3);
            }
        }
    }

    protected boolean B() {
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean C(T t16) {
        Object obj;
        if (t16 != null && ((t16.cid > 0 || B()) && !TextUtils.isEmpty(t16.getId()))) {
            if (TextUtils.isEmpty(t16.getResUrl())) {
                return true;
            }
            String v3 = v(t16);
            if (!new File(v3).exists()) {
                return false;
            }
            long elapsedRealtime = SystemClock.elapsedRealtime();
            String fileMD5String = ((IExternalUtilsApi) QRoute.api(IExternalUtilsApi.class)).getFileMD5String(v3);
            long elapsedRealtime2 = SystemClock.elapsedRealtime();
            String md5 = t16.getMd5();
            AVCoreLog.printColorLog(this.f73315d, "isTemplateUsable :" + fileMD5String + "|" + md5 + "|" + (elapsedRealtime2 - elapsedRealtime));
            return md5.equalsIgnoreCase(fileMD5String);
        }
        String str = this.f73315d;
        StringBuilder sb5 = new StringBuilder();
        sb5.append("isTemplateUsable:");
        if (t16 != null) {
            obj = Integer.valueOf(t16.cid);
        } else {
            obj = "item == null";
        }
        sb5.append(obj);
        sb5.append("|");
        AVCoreLog.printErrorLog(str, sb5.toString());
        return false;
    }

    public int E(int i3, String str) {
        AVCoreLog.printColorLog(this.f73315d, "onSendMessageToPeer :" + i3 + "|" + str);
        return r.h0().s2(i3, str);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Multi-variable type inference failed */
    public List<T> F(int i3, String str) {
        ArrayList arrayList = new ArrayList();
        if (!TextUtils.isEmpty(str)) {
            boolean z16 = false;
            try {
                JSONObject jSONObject = new JSONObject(str);
                int qQVersion = ba.getQQVersion();
                String t16 = t();
                if (jSONObject.has(t16)) {
                    JSONArray jSONArray = jSONObject.getJSONArray(t16);
                    Class<?> x16 = x();
                    int i16 = 0;
                    while (i16 < jSONArray.length()) {
                        com.tencent.av.business.manager.pendant.c cVar = (com.tencent.av.business.manager.pendant.c) JSONUtils.b((JSONObject) jSONArray.get(i16), x16);
                        if (cVar != null && !TextUtils.isEmpty(cVar.getId())) {
                            cVar.cid = i3;
                            int platform = cVar.getPlatform();
                            if (AVCoreLog.isDevelopLevel()) {
                                AVCoreLog.printColorLog(this.f73315d, "cid = " + cVar.cid + ", item: " + cVar.toString() + "|" + qQVersion + "|" + platform);
                            }
                            boolean C = C(cVar);
                            if (C) {
                                String v3 = v(cVar);
                                String y16 = y(cVar);
                                File file = new File(y16);
                                if (!file.exists()) {
                                    try {
                                        FileUtils.uncompressZip(v3, y16, z16);
                                    } catch (Throwable th5) {
                                        QLog.i(this.f73315d, 1, "parse item fail, item[" + cVar + "]", th5);
                                    }
                                }
                                C = file.exists();
                            }
                            if (platform == 0 || qQVersion >= platform) {
                                cVar.setUsable(C);
                                arrayList.add(cVar);
                            }
                        }
                        i16++;
                        z16 = false;
                    }
                }
            } catch (Exception e16) {
                QLog.w(this.f73315d, 1, "parse, cid[" + i3 + "], Exception", e16);
                af.M(i3, af.f76962q, 0, null);
            }
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void G() {
        if (B()) {
            H();
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.i(this.f73315d, 2, "config pull from manager");
        }
        List<T> list = this.f73303i;
        if (list == null || list.size() == 0) {
            this.f73303i = F(r(), s());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Multi-variable type inference failed */
    public void I(List<T> list) {
        ArrayList arrayList = new ArrayList();
        for (T t16 : list) {
            if (t16 != null && !TextUtils.isEmpty(t16.getId())) {
                t16.cid = r();
                String version = t16.getVersion();
                if (AVCoreLog.isDevelopLevel()) {
                    AVCoreLog.printColorLog(this.f73315d, "cid = " + t16.cid + ", item: " + t16.toString() + "|" + AppSetting.f99551k + "|" + version);
                }
                boolean C = C(t16);
                if (C) {
                    String v3 = v(t16);
                    String y16 = y(t16);
                    File file = new File(y16);
                    if (!file.exists()) {
                        try {
                            FileUtils.uncompressZip(v3, y16, false);
                        } catch (Throwable th5) {
                            QLog.i(this.f73315d, 1, "parse item fail, item[" + t16 + "]", th5);
                        }
                    }
                    C = file.exists();
                }
                if (!TextUtils.isEmpty(version) && AppSetting.b(version) < 0) {
                    arrayList.add(t16);
                } else {
                    t16.setUsable(C);
                }
            }
        }
        list.removeAll(arrayList);
    }

    public void J(long j3, b<T> bVar) {
        if (bVar != null) {
            if (K(bVar) != null) {
                this.C.remove(bVar);
            }
            if (QLog.isColorLevel()) {
                QLog.w(this.f73315d, 1, "removeCallback, callback[" + bVar.getClass().getSimpleName() + "], callback[" + bVar + "], seq[" + j3 + "]");
            }
        }
    }

    public boolean L(long j3, T t16) {
        Throwable th5 = null;
        if (!A(this.f73302h, t16)) {
            T t17 = this.f73302h;
            this.f73302h = t16;
            if (e.k()) {
                if (QLog.isDevelopLevel()) {
                    th5 = new Throwable("\u6253\u5370\u8c03\u7528\u6808");
                }
                QLog.w(this.f73315d, 1, "setCurrentItem, notify MSG_ON_ITEM_SELECT_CHANGED, seq[" + j3 + "], count_MSG[" + this.E + "], \nlast[" + t17 + "], \nnew[" + this.f73302h + "]", th5);
            }
            this.f73304m.removeMessages(0);
            this.E = 1;
            Message obtainMessage = this.f73304m.obtainMessage(0, t16);
            obtainMessage.arg1 = (int) j3;
            this.f73304m.sendMessage(obtainMessage);
            return true;
        }
        if (QLog.isDevelopLevel()) {
            if (QLog.isDevelopLevel()) {
                th5 = new Throwable("\u6253\u5370\u8c03\u7528\u6808");
            }
            QLog.w(this.f73315d, 1, "setCurrentItem, \u91cd\u590d, seq[" + j3 + "], count_MSG_ON_ITEM_SELECT_CHANGED[" + this.E + "], item[" + t16 + "]", th5);
        }
        return false;
    }

    public boolean M(long j3, String str) {
        if (QLog.isDevelopLevel()) {
            QLog.w(this.f73315d, 1, "setCurrentItemById, id[" + str + "], seq[" + j3 + "]");
        }
        if (TextUtils.isEmpty(str)) {
            L(j3, null);
        } else {
            L(j3, w(str));
        }
        return true;
    }

    public void N(long j3, T t16) {
        if (!t16.isUsable() && !TextUtils.isEmpty(t16.getResUrl())) {
            HttpNetReq httpNetReq = new HttpNetReq();
            httpNetReq.mCallback = new a(j3, t16);
            httpNetReq.mReqUrl = t16.getResUrl();
            httpNetReq.mHttpMethod = 0;
            httpNetReq.mOutPath = v(t16);
            httpNetReq.mContinuErrorLimit = NetworkUtil.getConnRetryTimes(NetworkCenter.getInstance().getNetType());
            httpNetReq.setUserData(t16);
            QLog.w(this.f73315d, 1, "startDownload, item[" + t16 + "], seq[" + j3 + "]");
            t16.isDownloading = true;
            ThreadManagerV2.post(new NetReqRunnable(httpNetReq), 5, null, true);
            return;
        }
        QLog.w(this.f73315d, 1, "startDownload, \u4e0d\u4e0b\u8f7d, item[" + t16 + "], seq[" + j3 + "]");
        t16.isDownloading = false;
        this.f73304m.obtainMessage(1, 1, (int) j3, t16).sendToTarget();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.av.business.manager.a
    public void h(String str, boolean z16) {
        if (z16) {
            if (str.equals(n.e().f().f73091w) || str.equals(String.valueOf(n.e().f().P0))) {
                L(e.d(), null);
            }
        }
    }

    public void p(long j3, b<T> bVar) {
        if (bVar != null) {
            if (K(bVar) == null) {
                this.C.add(new WeakReference<>(bVar));
            }
            if (QLog.isColorLevel()) {
                QLog.w(this.f73315d, 1, "addCallback, callback[" + bVar.getClass().getSimpleName() + "], callback[" + bVar + "], seq[" + j3 + "]");
            }
        }
    }

    public List<T> q(String str) {
        G();
        if (QLog.isColorLevel() && this.f73303i != null) {
            QLog.i(this.f73315d, 2, "mItemList size : " + this.f73303i.size());
        } else if (QLog.isColorLevel() && this.f73303i == null) {
            QLog.i(this.f73315d, 2, "mItemList is null ");
        }
        return this.f73303i;
    }

    public abstract int r();

    protected String s() {
        xt.a e16 = QAVConfig.e(r());
        if (e16 != null) {
            return e16.f448490b;
        }
        return null;
    }

    protected String t() {
        return "content";
    }

    public T u() {
        return this.f73302h;
    }

    public String v(T t16) {
        StringBuilder sb5 = new StringBuilder();
        sb5.append(com.tencent.av.b.i());
        sb5.append(t16.cid);
        String str = File.separator;
        sb5.append(str);
        sb5.append(FaceUtil.IMG_TEMP);
        sb5.append(str);
        sb5.append(t16.getId());
        sb5.append(".zip");
        return sb5.toString();
    }

    public T w(String str) {
        G();
        if (this.f73303i != null && !TextUtils.isEmpty(str)) {
            for (T t16 : this.f73303i) {
                if (str.equals(t16.getId())) {
                    return t16;
                }
            }
            return null;
        }
        return null;
    }

    protected abstract Class<?> x();

    public String y(T t16) {
        StringBuilder sb5 = new StringBuilder();
        sb5.append(com.tencent.av.b.i());
        sb5.append(t16.cid);
        String str = File.separator;
        sb5.append(str);
        sb5.append(t16.getId());
        sb5.append(str);
        return sb5.toString();
    }

    protected void H() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.av.business.manager.a
    public void g() {
    }

    protected void D(T t16) {
    }

    protected void z(Message message) {
    }
}

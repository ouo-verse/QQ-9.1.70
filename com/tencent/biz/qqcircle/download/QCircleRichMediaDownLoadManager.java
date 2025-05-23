package com.tencent.biz.qqcircle.download;

import android.os.Build;
import android.text.TextUtils;
import androidx.core.util.Consumer;
import com.tencent.biz.qcircleshadow.lib.HostStaticInvokeHelper;
import com.tencent.biz.qcircleshadow.lib.QCircleHostConstants;
import com.tencent.biz.qcircleshadow.lib.variation.HostFileUtils;
import com.tencent.biz.qcircleshadow.lib.variation.HostHttpUtils;
import com.tencent.biz.qcircleshadow.lib.variation.HostNetworkUtils;
import com.tencent.biz.richframework.delegate.impl.RFWApplication;
import com.tencent.biz.richframework.util.RFWFileUtils;
import com.tencent.biz.richframework.util.RFWSaveUtil;
import com.tencent.biz.richframework.util.bean.RFWSaveMediaResultBean;
import com.tencent.mobileqq.transfile.HttpNetReq;
import com.tencent.mobileqq.transfile.INetEngineListener;
import com.tencent.mobileqq.transfile.NetReq;
import com.tencent.mobileqq.transfile.NetResp;
import com.tencent.mobileqq.transfile.NetworkCenter;
import com.tencent.open.base.MD5Utils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.richframework.thread.RFWThreadManager;
import cooperation.qqcircle.picload.QCircleFeedPicLoader;
import cooperation.qzone.widget.QzoneEmotionUtils;
import java.lang.ref.WeakReference;

/* compiled from: P */
@Deprecated
/* loaded from: classes4.dex */
public class QCircleRichMediaDownLoadManager {

    /* renamed from: a, reason: collision with root package name */
    public static final String f84360a = com.tencent.mobileqq.qcircle.api.constant.a.f261581f + "feedRichMedia/";

    /* renamed from: b, reason: collision with root package name */
    private static volatile QCircleRichMediaDownLoadManager f84361b;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes4.dex */
    public class a implements Consumer<RFWSaveMediaResultBean> {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ d f84364d;

        a(d dVar) {
            this.f84364d = dVar;
        }

        @Override // androidx.core.util.Consumer
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void accept(RFWSaveMediaResultBean rFWSaveMediaResultBean) {
            if (this.f84364d.f84376e != null) {
                this.f84364d.f84376e.onStatusChange(rFWSaveMediaResultBean.isSuccess);
                QLog.d("QCircleRichMediaDownLoadManager", 1, "[moveFileToImaPath] save result: " + rFWSaveMediaResultBean.isSuccess);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes4.dex */
    public class b implements INetEngineListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ d f84366d;

        b(d dVar) {
            this.f84366d = dVar;
        }

        @Override // com.tencent.mobileqq.transfile.INetEngineListener
        public void onResp(NetResp netResp) {
            int i3 = netResp.mResult;
            if (i3 == 0) {
                QLog.d("QCircleRichMediaDownLoadManager", 1, this.f84366d.c() + ",download success ");
                QCircleRichMediaDownLoadManager.this.h(this.f84366d);
                return;
            }
            if (i3 == 1 || i3 == 2) {
                QLog.d("QCircleRichMediaDownLoadManager", 1, this.f84366d.c() + ",download failed ");
                HostFileUtils.delete(this.f84366d.e(), true);
                if (this.f84366d.f84376e != null) {
                    this.f84366d.f84376e.onStatusChange(false);
                }
            }
        }

        @Override // com.tencent.mobileqq.transfile.INetEngineListener
        public void onUpdateProgeress(NetReq netReq, long j3, long j16) {
            if (this.f84366d.f84376e != null) {
                int i3 = (int) ((((float) j3) / ((float) j16)) * 100.0f);
                if (i3 > 100.0f) {
                    i3 = 100;
                }
                this.f84366d.f84376e.onProgress(i3);
                QLog.d("QCircleRichMediaDownLoadManager", 1, this.f84366d.c() + ",download progress:  " + i3);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes4.dex */
    public static class c implements HostStaticInvokeHelper.NetworkChangedObserver {

        /* renamed from: a, reason: collision with root package name */
        private WeakReference<d> f84368a;

        /* renamed from: b, reason: collision with root package name */
        private WeakReference<HttpNetReq> f84369b;

        public c(d dVar, HttpNetReq httpNetReq) {
            this.f84368a = new WeakReference<>(dVar);
            this.f84369b = new WeakReference<>(httpNetReq);
        }

        @Override // com.tencent.biz.qcircleshadow.lib.HostStaticInvokeHelper.NetworkChangedObserver
        public void onNetworkChanged(boolean z16) {
            d dVar;
            if (!z16) {
                WeakReference<d> weakReference = this.f84368a;
                if (weakReference != null && weakReference.get() != null && (dVar = this.f84368a.get()) != null && dVar.f84376e != null) {
                    dVar.f84376e.onStatusChange(false);
                    HostFileUtils.delete(dVar.e(), true);
                }
                WeakReference<HttpNetReq> weakReference2 = this.f84369b;
                if (weakReference2 != null && weakReference2.get() != null) {
                    HostHttpUtils.cancel(this.f84369b.get());
                }
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes4.dex */
    public static class d {

        /* renamed from: g, reason: collision with root package name */
        private static String f84370g;

        /* renamed from: h, reason: collision with root package name */
        private static String f84371h;

        /* renamed from: a, reason: collision with root package name */
        private String f84372a;

        /* renamed from: b, reason: collision with root package name */
        private int f84373b;

        /* renamed from: c, reason: collision with root package name */
        private String f84374c;

        /* renamed from: d, reason: collision with root package name */
        private String f84375d;

        /* renamed from: e, reason: collision with root package name */
        private e f84376e;

        /* renamed from: f, reason: collision with root package name */
        private String f84377f;

        static {
            String SDCARD_IMG_SAVE = QCircleHostConstants.AppConstants.SDCARD_IMG_SAVE();
            f84370g = SDCARD_IMG_SAVE;
            f84371h = SDCARD_IMG_SAVE;
        }

        public d() {
            if (i()) {
                f84371h = QCircleHostConstants.AppConstants.SDCARD_ROOT() + "/DCIM/Video/";
            }
        }

        private String d(int i3) {
            if (i3 != 0) {
                if (i3 != 2) {
                    return ".jpeg";
                }
                return QzoneEmotionUtils.SIGN_ICON_URL_END;
            }
            return ".mp4";
        }

        private boolean i() {
            return String.valueOf(Build.BRAND).toLowerCase().contains("meizu");
        }

        public int b() {
            return this.f84373b;
        }

        public String c() {
            return this.f84372a;
        }

        public String e() {
            return this.f84375d;
        }

        public String f() {
            return this.f84374c;
        }

        public d g(e eVar) {
            this.f84376e = eVar;
            return this;
        }

        public d h(String str, int i3, String str2) {
            String str3;
            this.f84377f = str2;
            this.f84372a = str;
            this.f84373b = i3;
            if (i3 == 1) {
                str2 = MD5Utils.encodeHexStr(QCircleFeedPicLoader.getUniKeyFromUrl(str));
                if (TextUtils.isEmpty(str2)) {
                    str2 = MD5Utils.encodeFileHexStr(str);
                }
            }
            if (str2 != null) {
                str = str2;
            }
            String str4 = str + System.currentTimeMillis();
            this.f84375d = QCircleRichMediaDownLoadManager.f84360a + str4 + d(i3);
            StringBuilder sb5 = new StringBuilder();
            if (i3 == 0) {
                str3 = f84371h;
            } else {
                str3 = f84370g;
            }
            sb5.append(str3);
            sb5.append(str4);
            sb5.append(d(i3));
            this.f84374c = sb5.toString();
            return this;
        }
    }

    /* compiled from: P */
    /* loaded from: classes4.dex */
    public interface e {
        void onProgress(int i3);

        void onStatusChange(boolean z16);
    }

    QCircleRichMediaDownLoadManager() {
        RFWThreadManager.getInstance().execOnFileThread(new Runnable() { // from class: com.tencent.biz.qqcircle.download.QCircleRichMediaDownLoadManager.1
            @Override // java.lang.Runnable
            public void run() {
                RFWFileUtils.createNoMediaFile(QCircleRichMediaDownLoadManager.f84360a);
            }
        });
        HostStaticInvokeHelper.registerNetworkMonitorReceiver();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(d dVar) {
        QLog.d("QCircleRichMediaDownLoadManager", 1, dVar.c() + ",download start ");
        HttpNetReq httpNetReq = new HttpNetReq();
        httpNetReq.mCallback = new b(dVar);
        httpNetReq.mReqUrl = dVar.c();
        httpNetReq.mHttpMethod = 0;
        httpNetReq.mOutPath = dVar.e();
        httpNetReq.mContinuErrorLimit = HostNetworkUtils.getConnRetryTimes(NetworkCenter.getInstance().getNetType());
        HostHttpUtils.httpEngineServiceSendRequest(httpNetReq);
        HostStaticInvokeHelper.addNetworkChangedObserver(new c(dVar, httpNetReq));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(final d dVar) {
        RFWThreadManager.getInstance().execOnFileThread(new Runnable() { // from class: com.tencent.biz.qqcircle.download.QCircleRichMediaDownLoadManager.4
            @Override // java.lang.Runnable
            public void run() {
                QCircleRichMediaDownLoadManager.this.d(dVar);
            }
        });
    }

    public static QCircleRichMediaDownLoadManager g() {
        if (f84361b == null) {
            synchronized (QCircleRichMediaDownLoadManager.class) {
                if (f84361b == null) {
                    f84361b = new QCircleRichMediaDownLoadManager();
                }
            }
        }
        return f84361b;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean h(d dVar) {
        if (dVar == null) {
            QLog.d("QCircleRichMediaDownLoadManager", 1, "[moveFileToImaPath] params is null.");
            return false;
        }
        RFWSaveUtil.insertMedia(RFWApplication.getApplication(), dVar.e(), new a(dVar));
        return true;
    }

    public void f(final d dVar) {
        if (dVar != null) {
            RFWThreadManager.getInstance().execOnFileThread(new Runnable() { // from class: com.tencent.biz.qqcircle.download.QCircleRichMediaDownLoadManager.2
                @Override // java.lang.Runnable
                public void run() {
                    HostFileUtils.createFileIfNotExits(QCircleRichMediaDownLoadManager.f84360a + ".nomedia");
                    if (HostFileUtils.fileExists(dVar.f())) {
                        if (dVar.f84376e != null) {
                            dVar.f84376e.onStatusChange(true);
                        }
                        QLog.d("QCircleRichMediaDownLoadManager", 1, dVar.c() + ",download file is existed ");
                        return;
                    }
                    if (!HostFileUtils.fileExists(dVar.e())) {
                        QCircleRichMediaDownLoadManager.this.e(dVar);
                    } else if (!QCircleRichMediaDownLoadManager.this.h(dVar)) {
                        QCircleRichMediaDownLoadManager.this.e(dVar);
                    }
                }
            });
        }
    }

    public void i() {
        RFWThreadManager.getInstance().execOnFileThread(new Runnable() { // from class: com.tencent.biz.qqcircle.download.QCircleRichMediaDownLoadManager.6
            @Override // java.lang.Runnable
            public void run() {
                HostFileUtils.deleteDirectory(QCircleRichMediaDownLoadManager.f84360a);
            }
        });
    }
}

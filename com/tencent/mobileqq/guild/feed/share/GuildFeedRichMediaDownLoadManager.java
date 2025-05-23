package com.tencent.mobileqq.guild.feed.share;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import androidx.core.util.Consumer;
import com.tencent.biz.qcircleshadow.lib.HostStaticInvokeHelper;
import com.tencent.biz.qcircleshadow.lib.QCircleHostConstants;
import com.tencent.biz.qcircleshadow.lib.variation.HostFileUtils;
import com.tencent.biz.qcircleshadow.lib.variation.HostHttpUtils;
import com.tencent.biz.qcircleshadow.lib.variation.HostNetworkUtils;
import com.tencent.biz.richframework.util.RFWSaveUtil;
import com.tencent.biz.richframework.util.bean.RFWSaveMediaResultBean;
import com.tencent.libra.request.Option;
import com.tencent.mobileqq.guild.feed.share.GuildFeedRichMediaDownLoadManager;
import com.tencent.mobileqq.transfile.HttpNetReq;
import com.tencent.mobileqq.transfile.INetEngineListener;
import com.tencent.mobileqq.transfile.NetReq;
import com.tencent.mobileqq.transfile.NetResp;
import com.tencent.mobileqq.transfile.NetworkCenter;
import com.tencent.open.base.MD5Utils;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.richframework.thread.RFWThreadManager;
import cooperation.qzone.widget.QzoneEmotionUtils;
import java.io.File;
import java.lang.ref.WeakReference;
import java.util.HashMap;

/* compiled from: P */
/* loaded from: classes13.dex */
public class GuildFeedRichMediaDownLoadManager {

    /* renamed from: a, reason: collision with root package name */
    private static final String f223336a = com.tencent.mobileqq.guild.feed.util.x.f223931d + "feedRichMedia/";

    /* renamed from: b, reason: collision with root package name */
    private static volatile GuildFeedRichMediaDownLoadManager f223337b;

    /* compiled from: P */
    /* loaded from: classes13.dex */
    public static class DownLoadParams {

        /* renamed from: g, reason: collision with root package name */
        public static final HashMap<Integer, String> f223340g = new HashMap<Integer, String>() { // from class: com.tencent.mobileqq.guild.feed.share.GuildFeedRichMediaDownLoadManager.DownLoadParams.1
            {
                put(0, ".mp4");
                put(1, ".jpeg");
                put(2, QzoneEmotionUtils.SIGN_ICON_URL_END);
            }
        };

        /* renamed from: h, reason: collision with root package name */
        private static String f223341h;

        /* renamed from: i, reason: collision with root package name */
        private static String f223342i;

        /* renamed from: a, reason: collision with root package name */
        private String f223343a;

        /* renamed from: b, reason: collision with root package name */
        private int f223344b;

        /* renamed from: c, reason: collision with root package name */
        private String f223345c;

        /* renamed from: d, reason: collision with root package name */
        private String f223346d;

        /* renamed from: e, reason: collision with root package name */
        private c f223347e;

        /* renamed from: f, reason: collision with root package name */
        private String f223348f;

        static {
            String SDCARD_IMG_SAVE = QCircleHostConstants.AppConstants.SDCARD_IMG_SAVE();
            f223341h = SDCARD_IMG_SAVE;
            f223342i = SDCARD_IMG_SAVE;
        }

        public DownLoadParams() {
            if (j()) {
                f223342i = QCircleHostConstants.AppConstants.SDCARD_ROOT() + "/DCIM/Video/";
            }
        }

        private boolean j() {
            return String.valueOf(Build.BRAND).toLowerCase().contains("meizu");
        }

        public String d() {
            return this.f223343a;
        }

        public c e() {
            return this.f223347e;
        }

        public String f() {
            return this.f223346d;
        }

        public String g() {
            return this.f223345c;
        }

        public DownLoadParams h(c cVar) {
            this.f223347e = cVar;
            return this;
        }

        public DownLoadParams i(String str, int i3, String str2) {
            String str3;
            this.f223348f = str2;
            this.f223343a = str;
            this.f223344b = i3;
            if (i3 == 1) {
                str2 = MD5Utils.encodeHexStr(com.tencent.mobileqq.guild.picload.e.d(str));
                if (TextUtils.isEmpty(str2)) {
                    str2 = MD5Utils.encodeFileHexStr(str);
                }
            }
            if (str2 != null) {
                str = str2;
            }
            StringBuilder sb5 = new StringBuilder();
            sb5.append(GuildFeedRichMediaDownLoadManager.f223336a);
            sb5.append(str);
            HashMap<Integer, String> hashMap = f223340g;
            sb5.append(hashMap.get(Integer.valueOf(i3)));
            this.f223346d = sb5.toString();
            long currentTimeMillis = System.currentTimeMillis();
            StringBuilder sb6 = new StringBuilder();
            if (i3 == 0) {
                str3 = f223342i;
            } else {
                str3 = f223341h;
            }
            sb6.append(str3);
            sb6.append(str);
            sb6.append(currentTimeMillis);
            sb6.append(hashMap.get(Integer.valueOf(i3)));
            this.f223345c = sb6.toString();
            return this;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes13.dex */
    public class a implements INetEngineListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ DownLoadParams f223349d;

        a(DownLoadParams downLoadParams) {
            this.f223349d = downLoadParams;
        }

        @Override // com.tencent.mobileqq.transfile.INetEngineListener
        public void onResp(NetResp netResp) {
            int i3 = netResp.mResult;
            if (i3 == 0) {
                QLog.d("GuildFeedRichMediaDownLoadManager", 1, this.f223349d.d() + ",download success, move file to local album");
                GuildFeedRichMediaDownLoadManager.h(BaseApplication.getContext(), this.f223349d.f223346d, this.f223349d);
                return;
            }
            if (i3 == 1 || i3 == 2) {
                QLog.d("GuildFeedRichMediaDownLoadManager", 1, this.f223349d.d() + ",download failed ");
                HostFileUtils.delete(this.f223349d.f(), true);
                if (this.f223349d.f223347e != null) {
                    this.f223349d.f223347e.onStatusChange(false);
                }
            }
        }

        @Override // com.tencent.mobileqq.transfile.INetEngineListener
        public void onUpdateProgeress(NetReq netReq, long j3, long j16) {
            if (this.f223349d.f223347e != null) {
                int i3 = (int) ((((float) j3) / ((float) j16)) * 100.0f);
                this.f223349d.f223347e.onProgress(i3);
                QLog.d("GuildFeedRichMediaDownLoadManager", 1, this.f223349d.d() + ",download progress:  " + i3);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes13.dex */
    public static class b implements HostStaticInvokeHelper.NetworkChangedObserver {

        /* renamed from: a, reason: collision with root package name */
        private WeakReference<DownLoadParams> f223351a;

        /* renamed from: b, reason: collision with root package name */
        private WeakReference<HttpNetReq> f223352b;

        public b(DownLoadParams downLoadParams, HttpNetReq httpNetReq) {
            this.f223351a = new WeakReference<>(downLoadParams);
            this.f223352b = new WeakReference<>(httpNetReq);
        }

        @Override // com.tencent.biz.qcircleshadow.lib.HostStaticInvokeHelper.NetworkChangedObserver
        public void onNetworkChanged(boolean z16) {
            DownLoadParams downLoadParams;
            if (!z16) {
                WeakReference<DownLoadParams> weakReference = this.f223351a;
                if (weakReference != null && weakReference.get() != null && (downLoadParams = this.f223351a.get()) != null && downLoadParams.f223347e != null) {
                    downLoadParams.f223347e.onStatusChange(false);
                    HostFileUtils.delete(downLoadParams.f(), true);
                }
                WeakReference<HttpNetReq> weakReference2 = this.f223352b;
                if (weakReference2 != null && weakReference2.get() != null) {
                    HostHttpUtils.cancel(this.f223352b.get());
                }
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes13.dex */
    public interface c {
        void a();

        void onProgress(int i3);

        void onStatusChange(boolean z16);
    }

    GuildFeedRichMediaDownLoadManager() {
        HostFileUtils.createFileIfNotExits(f223336a + ".nomedia");
        HostStaticInvokeHelper.registerNetworkMonitorReceiver();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean g(DownLoadParams downLoadParams) {
        Option option = new Option();
        option.setUrl(downLoadParams.f223343a);
        String c16 = com.tencent.mobileqq.guild.picload.e.a().c(option);
        QLog.d("GuildFeedRichMediaDownLoadManager", 1, "guildPicLoaderPath =  " + c16);
        if (!TextUtils.isEmpty(c16) && new File(c16).exists()) {
            h(BaseApplication.getContext(), c16, downLoadParams);
            QLog.d("GuildFeedRichMediaDownLoadManager", 1, c16 + " ,move file to local album ");
            return true;
        }
        QLog.d("GuildFeedRichMediaDownLoadManager", 1, "checkHasLoadByGuildPicLoader| file not exists");
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void h(Context context, String str, final DownLoadParams downLoadParams) {
        RFWSaveUtil.insertMedia(context, str, new Consumer() { // from class: com.tencent.mobileqq.guild.feed.share.q
            @Override // androidx.core.util.Consumer
            public final void accept(Object obj) {
                GuildFeedRichMediaDownLoadManager.m(GuildFeedRichMediaDownLoadManager.DownLoadParams.this, (RFWSaveMediaResultBean) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i(DownLoadParams downLoadParams) {
        QLog.d("GuildFeedRichMediaDownLoadManager", 1, downLoadParams.d() + ",download start ");
        HttpNetReq httpNetReq = new HttpNetReq();
        httpNetReq.mCallback = new a(downLoadParams);
        httpNetReq.mReqUrl = downLoadParams.d();
        httpNetReq.mHttpMethod = 0;
        httpNetReq.mOutPath = downLoadParams.f();
        httpNetReq.mContinuErrorLimit = HostNetworkUtils.getConnRetryTimes(NetworkCenter.getInstance().getNetType());
        HostHttpUtils.httpEngineServiceSendRequest(httpNetReq);
        HostStaticInvokeHelper.addNetworkChangedObserver(new b(downLoadParams, httpNetReq));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j(final DownLoadParams downLoadParams) {
        RFWThreadManager.getInstance().execOnFileThread(new Runnable() { // from class: com.tencent.mobileqq.guild.feed.share.GuildFeedRichMediaDownLoadManager.2
            @Override // java.lang.Runnable
            public void run() {
                GuildFeedRichMediaDownLoadManager.this.i(downLoadParams);
            }
        });
    }

    public static GuildFeedRichMediaDownLoadManager l() {
        if (f223337b == null) {
            synchronized (GuildFeedRichMediaDownLoadManager.class) {
                if (f223337b == null) {
                    f223337b = new GuildFeedRichMediaDownLoadManager();
                }
            }
        }
        return f223337b;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void m(DownLoadParams downLoadParams, RFWSaveMediaResultBean rFWSaveMediaResultBean) {
        QLog.d("GuildFeedRichMediaDownLoadManager", 1, "insertMedia| isSuccess = " + rFWSaveMediaResultBean.isSuccess);
        if (downLoadParams.f223347e != null) {
            downLoadParams.f223347e.onStatusChange(rFWSaveMediaResultBean.isSuccess);
        }
    }

    public void k(final DownLoadParams downLoadParams) {
        if (downLoadParams != null) {
            RFWThreadManager.getInstance().execOnFileThread(new Runnable() { // from class: com.tencent.mobileqq.guild.feed.share.GuildFeedRichMediaDownLoadManager.1
                @Override // java.lang.Runnable
                public void run() {
                    QLog.d("GuildFeedRichMediaDownLoadManager", 1, "downLoadWithFileCheck| cachePath = " + downLoadParams.f() + ",savePath = " + downLoadParams.g());
                    if (GuildFeedRichMediaDownLoadManager.this.g(downLoadParams)) {
                        return;
                    }
                    if (HostFileUtils.fileExists(downLoadParams.f())) {
                        QLog.d("GuildFeedRichMediaDownLoadManager", 1, "downLoadWithFileCheck| SaveCachePath exist =  " + downLoadParams.f());
                        GuildFeedRichMediaDownLoadManager.h(BaseApplication.getContext(), downLoadParams.f(), downLoadParams);
                        return;
                    }
                    QLog.d("GuildFeedRichMediaDownLoadManager", 1, "downLoadWithFileCheck| nothing exist, direct do download ");
                    GuildFeedRichMediaDownLoadManager.this.j(downLoadParams);
                }
            });
        }
    }
}

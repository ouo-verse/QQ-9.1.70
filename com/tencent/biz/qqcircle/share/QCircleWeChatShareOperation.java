package com.tencent.biz.qqcircle.share;

import android.app.Activity;
import android.graphics.Bitmap;
import android.text.TextUtils;
import androidx.core.util.Consumer;
import com.tencent.biz.qcircleshadow.lib.QCircleHostConstants;
import com.tencent.biz.qcircleshadow.lib.QCircleHostShareInvokeHelper;
import com.tencent.biz.qcircleshadow.lib.listener.QCircleFaceBitmapListener;
import com.tencent.biz.qcircleshadow.lib.listener.QCircleWXShareListener;
import com.tencent.biz.qcircleshadow.lib.variation.HostDataTransUtils;
import com.tencent.biz.qqcircle.proxy.delegate.QCircleToast;
import com.tencent.biz.qqcircle.share.QCircleBaseShareOperation;
import com.tencent.biz.qqcircle.widgets.QCircleProgressDialog;
import com.tencent.libra.LoadState;
import com.tencent.libra.request.Option;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qcircle.picload.listener.QCirclePicStateListener;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.sharehelper.IShareActionHelper;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qq.minibox.api.data.MiniBoxNoticeInfo;
import com.tencent.richframework.thread.RFWThreadManager;
import cooperation.qqcircle.picload.QCircleFeedPicLoader;
import cooperation.qqcircle.report.QCircleLpReportDc05501;
import cooperation.qqcircle.report.QCircleLpReportDc05504;
import feedcloud.FeedCloudMeta$StFeed;
import java.util.HashMap;
import java.util.Map;
import uq3.q;

/* compiled from: P */
/* loaded from: classes5.dex */
public class QCircleWeChatShareOperation extends QCircleBaseShareOperation {
    private String A;
    private String B;
    private Map<String, Bitmap> C;
    private Runnable D;

    /* renamed from: u, reason: collision with root package name */
    private QCircleWXShareListener f92341u;

    /* renamed from: v, reason: collision with root package name */
    private QCirclePicStateListener f92342v;

    /* renamed from: w, reason: collision with root package name */
    private String f92343w;

    /* renamed from: x, reason: collision with root package name */
    private QCircleProgressDialog f92344x;

    /* renamed from: y, reason: collision with root package name */
    private String f92345y;

    /* renamed from: z, reason: collision with root package name */
    private String f92346z;

    /* compiled from: P */
    /* loaded from: classes5.dex */
    class a implements Consumer<String> {
        a() {
        }

        @Override // androidx.core.util.Consumer
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void accept(String str) {
            QCircleWeChatShareOperation.this.f92343w = String.valueOf(System.currentTimeMillis());
            ((IShareActionHelper) QRoute.api(IShareActionHelper.class)).doSharePicToWX("QFSSharePart", QCircleWeChatShareOperation.this.f(), QCircleWeChatShareOperation.this.f92343w, str, QCircleWeChatShareOperation.this.f92314l);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes5.dex */
    public class b implements QCircleWXShareListener {
        b() {
        }

        @Override // com.tencent.biz.qcircleshadow.lib.listener.QCircleWXShareListener
        public void onWXShareResp(int i3, String str, Object obj) {
            if (QCircleWeChatShareOperation.this.f92343w != null && QCircleWeChatShareOperation.this.f92343w.equals(obj)) {
                if (i3 == QCircleHostConstants._BaseResp.ErrCode.ERR_OK()) {
                    QCircleToast.j(QCircleToast.f91646f, com.tencent.biz.qqcircle.utils.h.a(R.string.txc), 0);
                } else if (i3 == QCircleHostConstants._BaseResp.ErrCode.ERR_USER_CANCEL()) {
                    QLog.d("QFSSharePart", 1, "share but user cancel");
                } else if (i3 == QCircleHostConstants._BaseResp.ErrCode.ERR_AUTH_DENIED()) {
                    QCircleToast.j(QCircleToast.f91645e, com.tencent.biz.qqcircle.utils.h.a(R.string.f195614f3), 0);
                } else {
                    QCircleToast.j(QCircleToast.f91645e, com.tencent.biz.qqcircle.utils.h.a(R.string.f195614f3), 0);
                }
                QCircleHostShareInvokeHelper.removeWxShareObserver(QCircleWeChatShareOperation.this.f92341u);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes5.dex */
    public class c extends QCirclePicStateListener {
        c() {
        }

        @Override // com.tencent.mobileqq.qcircle.picload.listener.QCirclePicStateListener, com.tencent.libra.listener.IPicLoadStateListener
        public void onStateChange(LoadState loadState, Option option) {
            super.onStateChange(loadState, option);
            if (loadState == LoadState.STATE_SUCCESS && option != null && option.getResultBitMap() != null && option.getResultBitMap().getConfig() != null) {
                QCircleWeChatShareOperation.this.k0(option.getResultBitMap());
            }
        }
    }

    public QCircleWeChatShareOperation(QCircleBaseShareOperation.a aVar) {
        super(aVar);
    }

    private String Y(String str) {
        if (str == null) {
            return "";
        }
        if (str.length() <= 30 && str.getBytes().length <= 100) {
            return str;
        }
        if (str.length() > 30) {
            str = str.substring(0, 30);
        }
        if (Math.min(str.getBytes().length, 100) == 100) {
            int length = str.length() / 2;
            StringBuilder sb5 = new StringBuilder(str.substring(0, length));
            while (sb5.toString().getBytes().length < 100) {
                sb5.append(str.charAt(length));
                length++;
            }
            str = sb5.toString();
        }
        return str + MiniBoxNoticeInfo.APPNAME_SUFFIX;
    }

    private boolean Z() {
        if (!QCircleHostShareInvokeHelper.isWXInstalled()) {
            QCircleToast.i(QCircleToast.f91644d, R.string.f173257ih1, 0);
            return false;
        }
        if (!QCircleHostShareInvokeHelper.isWXSupportApi()) {
            QCircleToast.i(QCircleToast.f91644d, R.string.f173258ih2, 0);
            return false;
        }
        return true;
    }

    private Runnable a0() {
        return new Runnable() { // from class: com.tencent.biz.qqcircle.share.QCircleWeChatShareOperation.4
            @Override // java.lang.Runnable
            public void run() {
                try {
                    if (QCircleWeChatShareOperation.this.t() == null) {
                        return;
                    }
                    if (QCircleWeChatShareOperation.this.t().type == 1) {
                        QCircleWeChatShareOperation.this.n0();
                    } else {
                        QLog.d("QFSSharePart", 1, "shareToWeChat share url icon");
                        QCircleWeChatShareOperation qCircleWeChatShareOperation = QCircleWeChatShareOperation.this;
                        qCircleWeChatShareOperation.l0(qCircleWeChatShareOperation.t().feed.share.cover.picUrl.get());
                    }
                } catch (Exception e16) {
                    QLog.e("QFSSharePart", 1, "shareToWeChat  Exception : " + e16.getMessage());
                } catch (OutOfMemoryError e17) {
                    QLog.e("QFSSharePart", 1, "shareToWeChat  OutOfMemoryError : " + e17.getMessage());
                }
            }
        };
    }

    private void b0(Activity activity) {
        if (this.f92344x == null) {
            this.f92344x = new QCircleProgressDialog(activity);
        }
    }

    private void c0() {
        this.f92345y = t().feed.share.url.get() + "&sharecategory=1";
        if (((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("qqcircle_share_to_wechat_txt_cut", false)) {
            this.f92346z = Y(t().feed.share.title.get());
            this.A = Y(t().feed.share.prompt.get());
            this.B = Y(t().feed.share.desc.get());
        } else {
            this.f92346z = t().feed.share.title.get();
            this.A = t().feed.share.prompt.get();
            this.B = t().feed.share.desc.get();
        }
        this.C = new HashMap(1);
        this.D = new Runnable() { // from class: com.tencent.biz.qqcircle.share.QCircleWeChatShareOperation.5
            @Override // java.lang.Runnable
            public void run() {
                String str;
                int WXSceneTimeline;
                if (QCircleWeChatShareOperation.this.f92344x != null && QCircleWeChatShareOperation.this.f92344x.isShowing()) {
                    QCircleWeChatShareOperation.this.f92344x.dismiss();
                }
                QCircleWeChatShareOperation.this.f92343w = String.valueOf(System.currentTimeMillis());
                Bitmap bitmap = (Bitmap) QCircleWeChatShareOperation.this.C.remove("image");
                QCircleWeChatShareOperation.this.I(true);
                if (QCircleWeChatShareOperation.this.t().type != 12 && QCircleWeChatShareOperation.this.t().type != 13) {
                    str = TextUtils.isEmpty(QCircleWeChatShareOperation.this.A) ? QCircleWeChatShareOperation.this.f92346z : QCircleWeChatShareOperation.this.A;
                } else {
                    str = QCircleWeChatShareOperation.this.D() ? QCircleWeChatShareOperation.this.A : QCircleWeChatShareOperation.this.f92346z;
                }
                String str2 = str;
                String str3 = QCircleWeChatShareOperation.this.f92343w;
                String str4 = QCircleWeChatShareOperation.this.B;
                String str5 = QCircleWeChatShareOperation.this.f92345y;
                if (QCircleWeChatShareOperation.this.D()) {
                    WXSceneTimeline = QCircleHostConstants._SendMessageToWX.Req.WXSceneSession();
                } else {
                    WXSceneTimeline = QCircleHostConstants._SendMessageToWX.Req.WXSceneTimeline();
                }
                QCircleHostShareInvokeHelper.shareQCircleToWX(str3, str2, bitmap, str4, str5, WXSceneTimeline);
                QLog.d("QFSSharePart", 1, "shareToWeChat success");
            }
        };
    }

    private void d0() {
        if (this.f92341u != null) {
            return;
        }
        b bVar = new b();
        this.f92341u = bVar;
        QCircleHostShareInvokeHelper.addWxShareObserver(bVar);
        this.f92342v = new c();
    }

    private void e0() {
        if (!C(57) && !uq3.c.g6()) {
            if (C(32)) {
                h0();
                return;
            }
            if (C(31)) {
                j0();
                return;
            } else if (A()) {
                i0();
                return;
            } else {
                g0();
                return;
            }
        }
        f0();
    }

    private void f0() {
        int i3;
        if (D()) {
            i3 = 27;
        } else {
            i3 = 28;
        }
        H(i3, 2, t().extraTypeInfo, "");
    }

    private void g0() {
        FeedCloudMeta$StFeed feedCloudMeta$StFeed;
        int i3;
        String str;
        int i16;
        if (t().extraTypeInfo != null) {
            feedCloudMeta$StFeed = t().extraTypeInfo.mFeed;
        } else {
            feedCloudMeta$StFeed = null;
        }
        QCircleLpReportDc05501.DataBuilder a16 = ua0.c.a(feedCloudMeta$StFeed);
        if (D()) {
            i3 = 27;
        } else {
            i3 = 28;
        }
        QCircleLpReportDc05501.DataBuilder subActionType = a16.setActionType(i3).setSubActionType(2);
        if (t().extraTypeInfo != null && t().extraTypeInfo.mFeed != null) {
            str = t().extraTypeInfo.mFeed.poster.f398463id.get();
        } else {
            str = "";
        }
        QCircleLpReportDc05501.DataBuilder toUin = subActionType.setToUin(str);
        if (t().extraTypeInfo != null) {
            i16 = t().extraTypeInfo.mDataPosition;
        } else {
            i16 = -1;
        }
        QCircleLpReportDc05501.report(new QCircleLpReportDc05501.DataBuilder(toUin.setIndex(i16).setPageId(m())));
    }

    private void h0() {
        int i3;
        QCircleLpReportDc05504.DataBuilder subActionType = new QCircleLpReportDc05504.DataBuilder().setToUin(t().feed.poster.f398463id.get()).setActionType(11).setSubActionType(9);
        if (D()) {
            i3 = 3;
        } else {
            i3 = 4;
        }
        QCircleLpReportDc05504.report(subActionType.setThrActionType(i3).setExt9(o()).setFeedReportInfo(p()).setPageId(m()));
    }

    private void i0() {
        int i3 = 3;
        QCircleLpReportDc05504.DataBuilder subActionType = new QCircleLpReportDc05504.DataBuilder().setActionType(F()).setSubActionType(3);
        if (!D()) {
            i3 = 4;
        }
        QCircleLpReportDc05504.report(subActionType.setThrActionType(i3).setExt6(String.valueOf(t().polymerizationName)).setPageId(m()));
    }

    private void j0() {
        int i3 = 4;
        QCircleLpReportDc05504.DataBuilder subActionType = new QCircleLpReportDc05504.DataBuilder().setToUin(t().feed.poster.f398463id.get()).setActionType(6).setSubActionType(4);
        if (D()) {
            i3 = 3;
        }
        QCircleLpReportDc05504.report(subActionType.setThrActionType(i3).setPageId(m()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void k0(Bitmap bitmap) {
        if (bitmap != null) {
            int width = bitmap.getWidth();
            int height = bitmap.getHeight();
            double d16 = width * height;
            if (d16 > 8000.0d) {
                double sqrt = Math.sqrt(8000.0d / d16);
                int i3 = (int) (width * sqrt);
                int i16 = (int) (height * sqrt);
                if (!bitmap.isRecycled()) {
                    Bitmap createScaledBitmap = Bitmap.createScaledBitmap(bitmap, i3, i16, true);
                    if (t().type != 1 && createScaledBitmap != bitmap) {
                        bitmap.recycle();
                    }
                    bitmap = createScaledBitmap;
                }
            }
            this.C.put("image", bitmap);
            RFWThreadManager.getUIHandler().post(this.D);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void l0(String str) {
        Option obtain = Option.obtain();
        obtain.setRequestWidth(80);
        obtain.setRequestHeight(80);
        obtain.setUrl(str);
        QCircleFeedPicLoader.g().loadImage(obtain, this.f92342v);
    }

    private void m0() {
        c0();
        if (TextUtils.isEmpty(this.f92345y)) {
            QCircleToast.j(QCircleToast.f91645e, com.tencent.biz.qqcircle.utils.h.a(R.string.f172748tx4), 0);
            return;
        }
        String str = t().feed.poster.f398463id.get();
        String str2 = t().feed.share.cover.picUrl.get();
        if (TextUtils.isEmpty(str) && TextUtils.isEmpty(str2)) {
            QLog.d("QFSSharePart", 1, "shareToWeChat no picture");
            o0();
        } else {
            p0();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void n0() {
        String str = t().feed.poster.icon.iconUrl.get();
        if (!TextUtils.isEmpty(str)) {
            l0(str);
            QLog.d("QFSSharePart", 1, "shareToWeChat share user icon by url");
        } else {
            QLog.d("QFSSharePart", 1, "shareToWeChat share user icon by uin");
            HostDataTransUtils.getUserFaceBitmap(t().feed.poster.f398463id.get(), new QCircleFaceBitmapListener() { // from class: com.tencent.biz.qqcircle.share.j
                @Override // com.tencent.biz.qcircleshadow.lib.listener.QCircleFaceBitmapListener
                public final void getFaceBitmap(Bitmap bitmap) {
                    QCircleWeChatShareOperation.this.k0(bitmap);
                }
            });
        }
    }

    private void o0() {
        this.D.run();
    }

    private void p0() {
        b0(f());
        this.f92344x.setMessage(R.string.c7z);
        if (f() != null && !f().isFinishing()) {
            this.f92344x.show();
        }
        RFWThreadManager.getInstance().execOnFileThread(a0());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.qqcircle.share.QCircleBaseShareOperation
    public void G() {
        String str;
        String str2;
        if (yb0.c.d(t())) {
            yb0.c.i(f());
            return;
        }
        if (t() != null && t().feed != null && t().feed.share != null && t().feed.poster != null && f() != null) {
            Activity f16 = f();
            if (D()) {
                str = "share_type_wechat";
            } else {
                str = "share_type_temp_circle";
            }
            q.c(f16, "share_lately_type_key", str);
            e0();
            if (D()) {
                str2 = "wechat_connects";
            } else {
                str2 = "wechat_moments";
            }
            d("share", str2);
            if (!Z()) {
                return;
            }
            d0();
            if (t().isShowPersonalQrcodeDown && h() != null) {
                h().g(new a());
            } else {
                m0();
            }
            yb0.g.f449962a.g(true, j());
            return;
        }
        J("QFSSharePart");
    }

    @Override // com.tencent.biz.qqcircle.share.QCircleBaseShareOperation
    protected boolean y() {
        return true;
    }
}

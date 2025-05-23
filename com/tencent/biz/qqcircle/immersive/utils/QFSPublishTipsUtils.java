package com.tencent.biz.qqcircle.immersive.utils;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.PopupWindow;
import android.widget.TextView;
import com.qq.wx.voice.util.ErrorCode;
import com.tencent.biz.qqcircle.QCirclePluginGlobalInfo;
import com.tencent.biz.qqcircle.QCirclePluginUtil;
import com.tencent.biz.qqcircle.beans.QCircleInitBean;
import com.tencent.biz.qqcircle.immersive.personal.bean.QFSPersonalCollectBoxDetailBean;
import com.tencent.biz.qqcircle.immersive.personal.widget.QFSPersonalSelectCollectBoxBottomSheet;
import com.tencent.biz.qqcircle.utils.cx;
import com.tencent.biz.qui.toast.QUIBottomToast;
import com.tencent.biz.richframework.delegate.impl.RFWApplication;
import com.tencent.mobileqq.R;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.richframework.thread.RFWThreadManager;
import cooperation.qqcircle.report.QCircleReportBean;
import cooperation.qqcircle.report.datong.QCircleDTParamBuilder;
import cooperation.qqcircle.report.datong.QCircleDaTongConstant;
import feedcloud.FeedCloudFavoritessvr$FavoritesInfo;
import feedcloud.FeedCloudMeta$StFeed;
import java.lang.ref.WeakReference;
import java.util.Collections;
import java.util.Map;

/* loaded from: classes4.dex */
public class QFSPublishTipsUtils {

    /* renamed from: g, reason: collision with root package name */
    private static final int f90019g = cx.a(42.0f);

    /* renamed from: h, reason: collision with root package name */
    private static final int f90020h = cx.a(8.0f);

    /* renamed from: a, reason: collision with root package name */
    private PopupWindow f90021a;

    /* renamed from: b, reason: collision with root package name */
    private CollectFeedTipRunnableImpl f90022b;

    /* renamed from: c, reason: collision with root package name */
    private CollectBoxTipRunnableImpl f90023c;

    /* renamed from: d, reason: collision with root package name */
    private CollectAlbumTipRunnableImpl f90024d;

    /* renamed from: e, reason: collision with root package name */
    private PublishTipDismissRunnableImpl f90025e;

    /* renamed from: f, reason: collision with root package name */
    private QCircleReportBean f90026f;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes4.dex */
    public static class CollectAlbumTipRunnableImpl implements Runnable {

        /* renamed from: d, reason: collision with root package name */
        private WeakReference<QFSPublishTipsUtils> f90030d;

        /* renamed from: e, reason: collision with root package name */
        private WeakReference<View> f90031e;

        /* renamed from: f, reason: collision with root package name */
        private String f90032f;

        /* renamed from: h, reason: collision with root package name */
        private boolean f90033h;

        public CollectAlbumTipRunnableImpl(QFSPublishTipsUtils qFSPublishTipsUtils, View view, String str, boolean z16) {
            this.f90030d = new WeakReference<>(qFSPublishTipsUtils);
            this.f90031e = new WeakReference<>(view);
            this.f90032f = str;
            this.f90033h = z16;
        }

        @Override // java.lang.Runnable
        public void run() {
            QFSPublishTipsUtils qFSPublishTipsUtils;
            WeakReference<QFSPublishTipsUtils> weakReference = this.f90030d;
            View view = null;
            if (weakReference == null) {
                qFSPublishTipsUtils = null;
            } else {
                qFSPublishTipsUtils = weakReference.get();
            }
            if (qFSPublishTipsUtils == null) {
                return;
            }
            WeakReference<View> weakReference2 = this.f90031e;
            if (weakReference2 != null) {
                view = weakReference2.get();
            }
            qFSPublishTipsUtils.m(view, this.f90032f, this.f90033h);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes4.dex */
    public static class CollectBoxTipRunnableImpl implements Runnable {

        /* renamed from: d, reason: collision with root package name */
        private WeakReference<QFSPublishTipsUtils> f90034d;

        /* renamed from: e, reason: collision with root package name */
        private WeakReference<View> f90035e;

        /* renamed from: f, reason: collision with root package name */
        private FeedCloudFavoritessvr$FavoritesInfo f90036f;

        /* renamed from: h, reason: collision with root package name */
        private FeedCloudFavoritessvr$FavoritesInfo f90037h;

        public CollectBoxTipRunnableImpl(QFSPublishTipsUtils qFSPublishTipsUtils, View view, FeedCloudFavoritessvr$FavoritesInfo feedCloudFavoritessvr$FavoritesInfo, FeedCloudFavoritessvr$FavoritesInfo feedCloudFavoritessvr$FavoritesInfo2) {
            this.f90034d = new WeakReference<>(qFSPublishTipsUtils);
            this.f90035e = new WeakReference<>(view);
            this.f90036f = feedCloudFavoritessvr$FavoritesInfo;
            this.f90037h = feedCloudFavoritessvr$FavoritesInfo2;
        }

        @Override // java.lang.Runnable
        public void run() {
            QFSPublishTipsUtils qFSPublishTipsUtils;
            WeakReference<QFSPublishTipsUtils> weakReference = this.f90034d;
            View view = null;
            if (weakReference == null) {
                qFSPublishTipsUtils = null;
            } else {
                qFSPublishTipsUtils = weakReference.get();
            }
            if (qFSPublishTipsUtils == null) {
                return;
            }
            WeakReference<View> weakReference2 = this.f90035e;
            if (weakReference2 != null) {
                view = weakReference2.get();
            }
            qFSPublishTipsUtils.n(view, this.f90036f, this.f90037h);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes4.dex */
    public static class CollectFeedTipRunnableImpl implements Runnable {

        /* renamed from: d, reason: collision with root package name */
        private WeakReference<QFSPublishTipsUtils> f90038d;

        /* renamed from: e, reason: collision with root package name */
        private WeakReference<View> f90039e;

        /* renamed from: f, reason: collision with root package name */
        private FeedCloudMeta$StFeed f90040f;

        /* renamed from: h, reason: collision with root package name */
        private boolean f90041h;

        public CollectFeedTipRunnableImpl(QFSPublishTipsUtils qFSPublishTipsUtils, View view, FeedCloudMeta$StFeed feedCloudMeta$StFeed, boolean z16) {
            this.f90038d = new WeakReference<>(qFSPublishTipsUtils);
            this.f90039e = new WeakReference<>(view);
            this.f90040f = feedCloudMeta$StFeed;
            this.f90041h = z16;
        }

        @Override // java.lang.Runnable
        public void run() {
            QFSPublishTipsUtils qFSPublishTipsUtils;
            WeakReference<QFSPublishTipsUtils> weakReference = this.f90038d;
            View view = null;
            if (weakReference == null) {
                qFSPublishTipsUtils = null;
            } else {
                qFSPublishTipsUtils = weakReference.get();
            }
            if (qFSPublishTipsUtils == null) {
                return;
            }
            WeakReference<View> weakReference2 = this.f90039e;
            if (weakReference2 != null) {
                view = weakReference2.get();
            }
            qFSPublishTipsUtils.o(view, this.f90040f, this.f90041h);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes4.dex */
    public static class PublishTipDismissRunnableImpl implements Runnable {

        /* renamed from: d, reason: collision with root package name */
        private WeakReference<QFSPublishTipsUtils> f90042d;

        /* renamed from: e, reason: collision with root package name */
        private WeakReference<View> f90043e;

        public PublishTipDismissRunnableImpl(QFSPublishTipsUtils qFSPublishTipsUtils, View view) {
            this.f90042d = new WeakReference<>(qFSPublishTipsUtils);
            this.f90043e = new WeakReference<>(view);
        }

        @Override // java.lang.Runnable
        public void run() {
            QFSPublishTipsUtils qFSPublishTipsUtils;
            WeakReference<QFSPublishTipsUtils> weakReference = this.f90042d;
            if (weakReference == null) {
                qFSPublishTipsUtils = null;
            } else {
                qFSPublishTipsUtils = weakReference.get();
            }
            if (qFSPublishTipsUtils != null) {
                qFSPublishTipsUtils.p();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes4.dex */
    public class a implements View.OnClickListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ boolean f90044d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ FeedCloudMeta$StFeed f90045e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ View f90046f;

        /* renamed from: h, reason: collision with root package name */
        final /* synthetic */ int f90047h;

        a(boolean z16, FeedCloudMeta$StFeed feedCloudMeta$StFeed, View view, int i3) {
            this.f90044d = z16;
            this.f90045e = feedCloudMeta$StFeed;
            this.f90046f = view;
            this.f90047h = i3;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            if (this.f90044d) {
                com.tencent.biz.qqcircle.immersive.personal.bean.r rVar = new com.tencent.biz.qqcircle.immersive.personal.bean.r(1);
                rVar.e(Collections.singletonList(this.f90045e));
                new QFSPersonalSelectCollectBoxBottomSheet(this.f90046f.getContext(), this.f90046f, rVar, QFSPublishTipsUtils.this.f90026f).show();
            } else {
                QCircleInitBean qCircleInitBean = new QCircleInitBean();
                qCircleInitBean.setSourceType(ErrorCode.ERROR_CHECKLEGALAPP_INVALID_SDK_CLI_TYPE);
                qCircleInitBean.setUser(QCirclePluginGlobalInfo.m());
                qCircleInitBean.setStartNewIntent(true);
                com.tencent.biz.qqcircle.launcher.c.d0(this.f90046f.getContext(), qCircleInitBean);
            }
            QFSPublishTipsUtils.this.s(true, this.f90045e.f398449id.get(), this.f90047h);
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes4.dex */
    public class b implements View.OnClickListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ FeedCloudFavoritessvr$FavoritesInfo f90049d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ View f90050e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ long f90051f;

        /* renamed from: h, reason: collision with root package name */
        final /* synthetic */ FeedCloudFavoritessvr$FavoritesInfo f90052h;

        b(FeedCloudFavoritessvr$FavoritesInfo feedCloudFavoritessvr$FavoritesInfo, View view, long j3, FeedCloudFavoritessvr$FavoritesInfo feedCloudFavoritessvr$FavoritesInfo2) {
            this.f90049d = feedCloudFavoritessvr$FavoritesInfo;
            this.f90050e = view;
            this.f90051f = j3;
            this.f90052h = feedCloudFavoritessvr$FavoritesInfo2;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            QFSPersonalCollectBoxDetailBean qFSPersonalCollectBoxDetailBean = new QFSPersonalCollectBoxDetailBean();
            qFSPersonalCollectBoxDetailBean.setFavoritesInfo(this.f90049d);
            com.tencent.biz.qqcircle.launcher.c.b0(this.f90050e.getContext(), qFSPersonalCollectBoxDetailBean);
            QFSPublishTipsUtils.this.l(this.f90051f, this.f90052h, true);
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes4.dex */
    public class c implements View.OnClickListener {
        c() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            QFSPublishTipsUtils.this.r(view.getContext());
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes4.dex */
    public class d implements View.OnClickListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ View f90055d;

        d(View view) {
            this.f90055d = view;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            QCircleInitBean qCircleInitBean = new QCircleInitBean();
            qCircleInitBean.setSourceType(ErrorCode.ERROR_CHECKLEGALAPP_INVALID_INFO);
            qCircleInitBean.setUser(QCirclePluginGlobalInfo.m());
            qCircleInitBean.setStartNewIntent(true);
            com.tencent.biz.qqcircle.launcher.c.d0(this.f90055d.getContext(), qCircleInitBean);
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    private void i(View view, String str) {
        Map<String, Object> buildElementParams = new QCircleDTParamBuilder().buildElementParams();
        buildElementParams.put(QCircleDaTongConstant.ElementParamKey.XSJ_ALBUM_ID, str);
        VideoReport.setElementId(view, QCircleDaTongConstant.ElementId.EM_XSJ_ALBUM_DETAILS_COLLECT_TOAST);
        VideoReport.setElementParams(view, buildElementParams);
    }

    private void k() {
        if (this.f90022b != null) {
            RFWThreadManager.getUIHandler().removeCallbacks(this.f90022b);
        }
        if (this.f90023c != null) {
            RFWThreadManager.getUIHandler().removeCallbacks(this.f90023c);
        }
        if (this.f90024d != null) {
            RFWThreadManager.getUIHandler().removeCallbacks(this.f90024d);
        }
        if (this.f90025e != null) {
            RFWThreadManager.getUIHandler().removeCallbacks(this.f90025e);
        }
        p();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void l(long j3, FeedCloudFavoritessvr$FavoritesInfo feedCloudFavoritessvr$FavoritesInfo, boolean z16) {
        String str;
        Map<String, Object> buildElementParams = new QCircleDTParamBuilder().buildElementParams();
        buildElementParams.put("xsj_eid", QCircleDaTongConstant.ElementId.EM_XSJ_COLLECT_BUBBLE);
        buildElementParams.put(QCircleDaTongConstant.ElementParamKey.XSJ_COLLECT_TOAST_JUMP_TYPE, 2);
        buildElementParams.put(QCircleDaTongConstant.ElementParamKey.XSJ_TARGET_COLLECT_FOLDER_ID, Long.valueOf(j3));
        if (feedCloudFavoritessvr$FavoritesInfo != null) {
            buildElementParams.put(QCircleDaTongConstant.ElementParamKey.XSJ_COLLECT_FOLDER_ID, Long.valueOf(feedCloudFavoritessvr$FavoritesInfo.f398434id.get()));
        }
        QCircleReportBean qCircleReportBean = this.f90026f;
        if (qCircleReportBean != null) {
            buildElementParams.put("xsj_custom_pgid", qCircleReportBean.getDtPageId());
        }
        if (z16) {
            str = "ev_xsj_abnormal_clck";
        } else {
            str = "ev_xsj_abnormal_imp";
        }
        VideoReport.reportEvent(str, buildElementParams);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void m(final View view, String str, boolean z16) {
        if (view == null) {
            QLog.d("QCBT-QFSPublishTipsUtils", 1, "[handleCollectAlbum] anchor view should not be null.");
            return;
        }
        Context context = view.getContext();
        if (this.f90021a == null) {
            View inflate = LayoutInflater.from(context).inflate(R.layout.g8s, (ViewGroup) null);
            PopupWindow popupWindow = new PopupWindow(inflate, -2, f90019g);
            this.f90021a = popupWindow;
            popupWindow.setOutsideTouchable(false);
            inflate.setOnClickListener(new c());
            d dVar = new d(view);
            TextView textView = (TextView) inflate.findViewById(R.id.f56192jy);
            ImageView imageView = (ImageView) inflate.findViewById(R.id.f44241on);
            View findViewById = inflate.findViewById(R.id.f56202jz);
            textView.setOnClickListener(dVar);
            imageView.setOnClickListener(dVar);
            i(textView, str);
            if (!z16) {
                textView.setVisibility(8);
                imageView.setVisibility(8);
                findViewById.setVisibility(8);
            }
        }
        int width = view.getWidth();
        int height = view.getHeight();
        int[] iArr = new int[2];
        view.getLocationInWindow(iArr);
        this.f90021a.getContentView().measure(0, 0);
        int measuredWidth = this.f90021a.getContentView().getMeasuredWidth();
        int measuredHeight = this.f90021a.getContentView().getMeasuredHeight();
        int i3 = iArr[0];
        final int i16 = ((width / 2) + i3) - (measuredWidth / 2);
        int i17 = iArr[1];
        final int i18 = (i17 - measuredHeight) - f90020h;
        QLog.d("QCBT-QFSPublishTipsUtils", 1, "[handlePushMore] view position[" + i3 + "," + i17 + "] size[" + width + "," + height + "] show[" + i16 + "," + i18 + "] popWidth: " + measuredWidth + " \uff5c anchorView: " + view);
        view.post(new Runnable() { // from class: com.tencent.biz.qqcircle.immersive.utils.QFSPublishTipsUtils.5
            @Override // java.lang.Runnable
            public void run() {
                if (view.getWindowToken() == null) {
                    return;
                }
                QFSPublishTipsUtils.this.f90021a.showAtLocation(view, 0, i16, i18);
            }
        });
        this.f90025e = new PublishTipDismissRunnableImpl(this, view);
        RFWThreadManager.getUIHandler().postDelayed(this.f90025e, 3000L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void n(View view, FeedCloudFavoritessvr$FavoritesInfo feedCloudFavoritessvr$FavoritesInfo, FeedCloudFavoritessvr$FavoritesInfo feedCloudFavoritessvr$FavoritesInfo2) {
        if (view == null) {
            QLog.d("QCBT-QFSPublishTipsUtils", 1, "[handleCollectBox] anchor view should not be null.");
            return;
        }
        if (!(view.getContext() instanceof Activity)) {
            QLog.d("QCBT-QFSPublishTipsUtils", 1, "[handleCollectBox] context is not activity");
            return;
        }
        Activity activity = (Activity) view.getContext();
        long j3 = feedCloudFavoritessvr$FavoritesInfo.f398434id.get();
        QUIBottomToast.g(activity, 2, RFWApplication.getApplication().getString(R.string.f19086439, feedCloudFavoritessvr$FavoritesInfo.title.get()), com.tencent.biz.qqcircle.utils.h.a(R.string.f1908743_), new b(feedCloudFavoritessvr$FavoritesInfo, view, j3, feedCloudFavoritessvr$FavoritesInfo2), QCirclePluginUtil.getBottomMarginHeight(view.getContext()) - cx.d(activity)).n();
        l(j3, feedCloudFavoritessvr$FavoritesInfo2, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void o(View view, FeedCloudMeta$StFeed feedCloudMeta$StFeed, boolean z16) {
        boolean z17;
        int i3;
        int i16;
        int i17 = 1;
        if (view == null) {
            QLog.d("QCBT-QFSPublishTipsUtils", 1, "[handleCollectAlbum] anchor view should not be null.");
            return;
        }
        if (!(view.getContext() instanceof Activity)) {
            QLog.d("QCBT-QFSPublishTipsUtils", 1, "[handleCollectAlbum] context is not activity");
            return;
        }
        Activity activity = (Activity) view.getContext();
        if (z16 && com.tencent.biz.qqcircle.immersive.personal.utils.j.a()) {
            z17 = true;
        } else {
            z17 = false;
        }
        if (z17) {
            i3 = R.string.f188753xj;
        } else {
            i3 = R.string.f19085438;
        }
        String a16 = com.tencent.biz.qqcircle.utils.h.a(i3);
        if (z17) {
            i16 = R.string.f187943vc;
        } else {
            i16 = R.string.f1908743_;
        }
        String a17 = com.tencent.biz.qqcircle.utils.h.a(i16);
        if (!z17) {
            i17 = 3;
        }
        QUIBottomToast.g(activity, 2, a16, a17, new a(z17, feedCloudMeta$StFeed, view, i17), QCirclePluginUtil.getBottomMarginHeight(view.getContext()) - cx.d(activity)).n();
        s(false, feedCloudMeta$StFeed.f398449id.get(), i17);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void p() {
        PopupWindow popupWindow = this.f90021a;
        if (popupWindow == null) {
            QLog.d("QCBT-QFSPublishTipsUtils", 1, "[handleDismiss] publish tip pop should not be null.");
        } else if (!popupWindow.isShowing()) {
            QLog.d("QCBT-QFSPublishTipsUtils", 1, "[handleDismiss] publish tip pop not is showing state.");
        } else {
            this.f90021a.dismiss();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void s(boolean z16, String str, int i3) {
        String str2;
        Map<String, Object> buildElementParams = new QCircleDTParamBuilder().buildElementParams();
        buildElementParams.put("xsj_feed_id", str);
        buildElementParams.put(QCircleDaTongConstant.ElementParamKey.XSJ_COLLECT_TOAST_JUMP_TYPE, Integer.valueOf(i3));
        buildElementParams.put("xsj_eid", QCircleDaTongConstant.ElementId.EM_XSJ_COLLECT_BUBBLE);
        QCircleReportBean qCircleReportBean = this.f90026f;
        if (qCircleReportBean != null) {
            buildElementParams.put("xsj_custom_pgid", qCircleReportBean.getDtPageId());
        }
        if (z16) {
            str2 = "ev_xsj_abnormal_clck";
        } else {
            str2 = "ev_xsj_abnormal_imp";
        }
        VideoReport.reportEvent(str2, buildElementParams);
    }

    public void j(View view) {
        if (view != null) {
            r(view.getContext());
        }
    }

    public void q(Context context) {
        if (this.f90024d != null) {
            RFWThreadManager.getUIHandler().removeCallbacks(this.f90024d);
        }
        p();
    }

    public void r(Context context) {
        p();
    }

    public void t(QCircleReportBean qCircleReportBean) {
        this.f90026f = qCircleReportBean;
    }

    public void u(View view, String str, boolean z16) {
        if (view == null) {
            QLog.d("QCBT-QFSPublishTipsUtils", 1, "[showCollectAlbumTips] anchor view should not be null.");
            return;
        }
        k();
        this.f90024d = new CollectAlbumTipRunnableImpl(this, view, str, z16);
        RFWThreadManager.getUIHandler().postDelayed(this.f90024d, 500L);
    }

    public void v(View view, FeedCloudFavoritessvr$FavoritesInfo feedCloudFavoritessvr$FavoritesInfo, FeedCloudFavoritessvr$FavoritesInfo feedCloudFavoritessvr$FavoritesInfo2) {
        if (view == null) {
            QLog.d("QCBT-QFSPublishTipsUtils", 1, "[showCollectFeedTips] anchor view should not be null.");
            return;
        }
        k();
        this.f90023c = new CollectBoxTipRunnableImpl(this, view, feedCloudFavoritessvr$FavoritesInfo, feedCloudFavoritessvr$FavoritesInfo2);
        RFWThreadManager.getUIHandler().postDelayed(this.f90023c, 500L);
    }

    public void w(View view, FeedCloudMeta$StFeed feedCloudMeta$StFeed, boolean z16) {
        if (view == null) {
            QLog.d("QCBT-QFSPublishTipsUtils", 1, "[showCollectFeedTips] anchor view should not be null.");
            return;
        }
        k();
        this.f90022b = new CollectFeedTipRunnableImpl(this, view, feedCloudMeta$StFeed, z16);
        RFWThreadManager.getUIHandler().postDelayed(this.f90022b, 500L);
    }
}

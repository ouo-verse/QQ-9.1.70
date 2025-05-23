package jm;

import android.app.Activity;
import android.content.Intent;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewStub;
import com.qzone.app.ResourcePreloader;
import com.qzone.proxy.feedcomponent.text.font.FontManager;
import com.qzone.reborn.configx.g;
import com.qzone.reborn.feedpro.utils.d;
import com.tencent.biz.richframework.delegate.impl.RFWLog;
import com.tencent.biz.richframework.layoutinflater.RFWLayoutLoaderStrategy;
import com.tencent.biz.richframework.layoutinflater.RFWLayoutPreLoader;
import com.tencent.biz.richframework.layoutinflater.RFWLayoutPreLoaderFactory;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.manager.QzoneFriendFeedManager;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.service.qzone.e;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.richframework.thread.RFWThreadManager;
import cooperation.qzone.QZoneHelper;
import cooperation.qzone.api.QZoneApiProxy;
import cooperation.qzone.util.TimeCostTrace;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.MobileQQ;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b!\u0010\"J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0004\u001a\u00020\u0002H\u0002J,\u0010\u000b\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u00072\b\b\u0002\u0010\t\u001a\u00020\u00072\b\b\u0002\u0010\n\u001a\u00020\u0007H\u0002J\u0010\u0010\u000e\u001a\u00020\u00022\b\u0010\r\u001a\u0004\u0018\u00010\fJ\u0006\u0010\u000f\u001a\u00020\u0002J\"\u0010\u0014\u001a\u0004\u0018\u00010\u00132\b\u0010\u0006\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0010\u001a\u00020\u00072\u0006\u0010\u0012\u001a\u00020\u0011J\u0012\u0010\u0017\u001a\u0004\u0018\u00010\u00132\b\u0010\u0016\u001a\u0004\u0018\u00010\u0015J\u0006\u0010\u0019\u001a\u00020\u0018J\u000e\u0010\u001a\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0005R\u0016\u0010\u001c\u001a\u00020\u00118\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\u001bR\u0016\u0010 \u001a\u00020\u001d8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001e\u0010\u001f\u00a8\u0006#"}, d2 = {"Ljm/b;", "", "", h.F, "j", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "", "layoutId", "preloadMoreThreshold", "preloadMoreCount", "b", "Landroid/content/Intent;", "intent", "k", "l", "resId", "", "inflateIfNotExist", "Landroid/view/View;", "f", "Landroid/view/ViewStub;", "viewStub", "g", "Lcom/tencent/biz/richframework/layoutinflater/RFWLayoutPreLoader;", "e", "d", "Z", "mFriendFeedxPreloaded", "Landroid/os/Handler;", "c", "Landroid/os/Handler;", "mHandler", "<init>", "()V", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes38.dex */
public final class b {

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private static boolean mFriendFeedxPreloaded;

    /* renamed from: a, reason: collision with root package name */
    public static final b f410600a = new b();

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private static Handler mHandler = new Handler(Looper.getMainLooper());

    b() {
    }

    private final void b(Activity activity, int layoutId, int preloadMoreThreshold, int preloadMoreCount) {
        RFWLayoutPreLoader e16 = e();
        int viewCountInCache = e16.getViewCountInCache(activity, layoutId);
        if (viewCountInCache <= preloadMoreThreshold) {
            QLog.d("QZonePreloader", 4, "preload more view, layout: " + layoutId + ", count in cache: " + viewCountInCache + ", preload count: " + preloadMoreCount);
            e16.preloadView(activity, layoutId, preloadMoreCount);
        }
    }

    private final void h() {
        if (g.f53821a.c().k()) {
            RFWThreadManager.getInstance().runOnUiThread(new Runnable() { // from class: jm.a
                @Override // java.lang.Runnable
                public final void run() {
                    b.i();
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void i() {
        QzoneFriendFeedManager.INSTANCE.loadCache();
    }

    private final void j() {
        RFWLog.d("QZonePreloader", RFWLog.USR, "preloadFriendFeedx");
        BaseApplication context = BaseApplication.getContext();
        ResourcePreloader.b().h();
        ResourcePreloader.b().e();
        ResourcePreloader.b().i();
        ResourcePreloader.b().j();
        ResourcePreloader.b().f(context);
        FontManager.preInitData();
    }

    public final void d(Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        if (g.f53821a.b().f0()) {
            QLog.d("QZonePreloader", 4, "checkShouldPreloadMoreItemLayout");
            c(this, activity, R.layout.cgp, 0, 0, 12, null);
            c(this, activity, R.layout.cg8, 0, 0, 12, null);
            c(this, activity, R.layout.chq, 0, 0, 12, null);
            c(this, activity, R.layout.cfa, 0, 0, 12, null);
            c(this, activity, R.layout.chp, 0, 0, 12, null);
        }
    }

    public final RFWLayoutPreLoader e() {
        RFWLayoutLoaderStrategy b16 = sc.a.a().b();
        Intrinsics.checkNotNullExpressionValue(b16, "getInstance().layoutLoaderStrategy");
        return RFWLayoutPreLoaderFactory.getLayoutLoader(b16);
    }

    public final void l() {
        mFriendFeedxPreloaded = false;
    }

    public final void k(Intent intent) {
        if (intent == null || TextUtils.isEmpty(intent.getAction())) {
            return;
        }
        if (!QZoneApiProxy.isQZonePluginInit() && MobileQQ.sMobileQQ.peekAppRuntime() != null) {
            QZoneApiProxy.initEnv(BaseApplication.getContext(), MobileQQ.sMobileQQ.peekAppRuntime());
            QZoneApiProxy.initServlet(BaseApplication.getContext(), MobileQQ.sMobileQQ.peekAppRuntime());
        }
        try {
            if (Intrinsics.areEqual(QZoneHelper.ACTION_PRELOAD_FRIEND_FEEDS, intent.getAction()) && !mFriendFeedxPreloaded) {
                if (d.f54318a.b()) {
                    h();
                } else {
                    j();
                }
                mFriendFeedxPreloaded = true;
            }
        } catch (Throwable th5) {
            RFWLog.fatal(TimeCostTrace.TAG_QZONE_LAUNCH, 1, th5);
        }
        e.f286406a.k();
    }

    public final View g(ViewStub viewStub) {
        if (viewStub == null) {
            return null;
        }
        return e().getPreloadView(viewStub);
    }

    public final View f(Activity activity, int resId, boolean inflateIfNotExist) {
        if (activity == null || resId == 0) {
            return null;
        }
        View preloadView = e().getPreloadView(activity, resId, inflateIfNotExist);
        if (preloadView != null) {
            QLog.i("QZonePreloader", 1, "preload layout hit: " + resId);
        } else {
            QLog.i("QZonePreloader", 1, "preload layout miss: " + resId);
        }
        return preloadView;
    }

    static /* synthetic */ void c(b bVar, Activity activity, int i3, int i16, int i17, int i18, Object obj) {
        if ((i18 & 4) != 0) {
            i16 = 1;
        }
        if ((i18 & 8) != 0) {
            i17 = 3;
        }
        bVar.b(activity, i3, i16, i17);
    }
}

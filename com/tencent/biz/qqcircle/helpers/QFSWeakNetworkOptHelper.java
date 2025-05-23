package com.tencent.biz.qqcircle.helpers;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import com.tencent.biz.qqcircle.helpers.QFSWeakNetworkOptHelper;
import com.tencent.biz.qqcircle.immersive.feed.QFSFeedChildVideoPresenter;
import com.tencent.biz.qqcircle.immersive.views.QFSVideoView;
import com.tencent.biz.qqcircle.proxy.delegate.QCircleToast;
import com.tencent.biz.qqcircle.utils.QCircleNetWorkTestHelper;
import com.tencent.biz.qui.toast.QUIClickableCenterToast;
import com.tencent.biz.richframework.video.rfw.RFWVideoUtils;
import com.tencent.biz.richframework.video.rfw.player.datacollect.RFWPlayerDataCollectManger;
import com.tencent.map.geolocation.TencentLocation;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.richframework.thread.RFWThreadManager;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringNumberConversionsKt;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u000b\b\u00c6\u0002\u0018\u00002\u00020\u0001:\u0001\u0018B\t\b\u0002\u00a2\u0006\u0004\b\u0016\u0010\u0017J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u0006\u0010\u0005\u001a\u00020\u0004J\u0006\u0010\u0006\u001a\u00020\u0004J\u0006\u0010\u0007\u001a\u00020\u0002J\u0006\u0010\b\u001a\u00020\u0002R\u0016\u0010\n\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\tR\u0016\u0010\r\u001a\u00020\u000b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\fR\u0016\u0010\u0010\u001a\u00020\u000e8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u000fR\u0016\u0010\u0011\u001a\u00020\u000b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\b\u0010\fR\u0016\u0010\u0013\u001a\u00020\u000e8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\u000fR\u0016\u0010\u0015\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0014\u0010\t\u00a8\u0006\u0019"}, d2 = {"Lcom/tencent/biz/qqcircle/helpers/QFSWeakNetworkOptHelper;", "", "", "c", "", "d", "a", "b", "e", "Z", "isInitialized", "", "I", "canShowCountOneDay", "", "J", "weakNetKBs", "hasShowCount", "f", "lastShowTime", "g", "mCurHasShow", "<init>", "()V", "WeakNetTipsShowRunnable", "qcircle-plugin-module_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes4.dex */
public final class QFSWeakNetworkOptHelper {

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private static volatile boolean isInitialized;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private static int hasShowCount;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    private static boolean mCurHasShow;

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final QFSWeakNetworkOptHelper f84577a = new QFSWeakNetworkOptHelper();

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private static int canShowCountOneDay = -1;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private static long weakNetKBs = 350;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private static long lastShowTime = -1;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0014\u001a\u00020\u0011\u0012\u0006\u0010\u0015\u001a\u00020\r\u0012\u0006\u0010\u000b\u001a\u00020\u0004\u00a2\u0006\u0004\b\u0016\u0010\u0017J\b\u0010\u0003\u001a\u00020\u0002H\u0016R\"\u0010\u000b\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001a\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\r0\f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00110\f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\u000f\u00a8\u0006\u0018"}, d2 = {"Lcom/tencent/biz/qqcircle/helpers/QFSWeakNetworkOptHelper$WeakNetTipsShowRunnable;", "Ljava/lang/Runnable;", "", TencentLocation.RUN_MODE, "", "d", "I", "getRetryCount", "()I", "setRetryCount", "(I)V", "retryCount", "Ljava/lang/ref/WeakReference;", "Lcom/tencent/biz/qqcircle/immersive/views/QFSVideoView;", "e", "Ljava/lang/ref/WeakReference;", "mWrfVideoView", "Lcom/tencent/biz/qqcircle/immersive/feed/QFSFeedChildVideoPresenter;", "f", "mWrfVideoPresenter", "qfsVideoPresenter", "qfsVideoView", "<init>", "(Lcom/tencent/biz/qqcircle/immersive/feed/QFSFeedChildVideoPresenter;Lcom/tencent/biz/qqcircle/immersive/views/QFSVideoView;I)V", "qcircle-plugin-module_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes4.dex */
    public static final class WeakNetTipsShowRunnable implements Runnable {

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        private int retryCount;

        /* renamed from: e, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final WeakReference<QFSVideoView> mWrfVideoView;

        /* renamed from: f, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final WeakReference<QFSFeedChildVideoPresenter> mWrfVideoPresenter;

        public WeakNetTipsShowRunnable(@NotNull QFSFeedChildVideoPresenter qfsVideoPresenter, @NotNull QFSVideoView qfsVideoView, int i3) {
            Intrinsics.checkNotNullParameter(qfsVideoPresenter, "qfsVideoPresenter");
            Intrinsics.checkNotNullParameter(qfsVideoView, "qfsVideoView");
            this.retryCount = i3;
            this.mWrfVideoView = new WeakReference<>(qfsVideoView);
            this.mWrfVideoPresenter = new WeakReference<>(qfsVideoPresenter);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void b(String str, View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            QLog.d("QFSWeakNetworkOptHelper", 1, "[weakNetWorkTipsRun] click");
            QCircleToast.j(QCircleToast.f91646f, "\u611f\u8c22\u4f60\u7684\u53cd\u9988!", 0);
            RFWPlayerDataCollectManger.g().onWeakNetTipsUserClick(str, System.currentTimeMillis());
            EventCollector.getInstance().onViewClicked(view);
        }

        @Override // java.lang.Runnable
        public void run() {
            Activity activity;
            QFSVideoView qFSVideoView = this.mWrfVideoView.get();
            if (qFSVideoView == null) {
                QLog.e("QFSWeakNetworkOptHelper", 1, "[run], videoView is null, return.");
                return;
            }
            Context context = qFSVideoView.getContext();
            if (context instanceof Activity) {
                activity = (Activity) context;
            } else {
                activity = null;
            }
            Activity activity2 = activity;
            if (activity2 == null) {
                QLog.e("QFSWeakNetworkOptHelper", 1, "[run], context is not activity, return.");
                return;
            }
            QFSFeedChildVideoPresenter qFSFeedChildVideoPresenter = this.mWrfVideoPresenter.get();
            boolean z16 = false;
            if (qFSFeedChildVideoPresenter != null && qFSFeedChildVideoPresenter.E0()) {
                z16 = true;
            }
            if (!z16) {
                QLog.e("QFSWeakNetworkOptHelper", 1, "[run], cur feed not on screen.");
                return;
            }
            final String M0 = qFSVideoView.M0();
            QFSWeakNetworkOptHelper qFSWeakNetworkOptHelper = QFSWeakNetworkOptHelper.f84577a;
            boolean d16 = qFSWeakNetworkOptHelper.d();
            QLog.d("QFSWeakNetworkOptHelper", 1, "[run] isWeakNetwork:" + d16 + ", playTag:" + M0 + ", retryCount:" + this.retryCount);
            if (d16) {
                QUIClickableCenterToast.INSTANCE.a(activity2, null, "\u7f51\u7edc\u4e0d\u4f73\uff0c\u53ef\u7a0d\u540e\u518d\u8bd5 ", "\u70b9\u51fb\u53cd\u9988", new View.OnClickListener() { // from class: com.tencent.biz.qqcircle.helpers.ac
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        QFSWeakNetworkOptHelper.WeakNetTipsShowRunnable.b(M0, view);
                    }
                }).f(5000L).j();
                RFWPlayerDataCollectManger.g().onWeakNetTipsShow(M0);
                qFSWeakNetworkOptHelper.b();
            } else {
                int i3 = this.retryCount;
                if (i3 > 0) {
                    this.retryCount = i3 - 1;
                    RFWThreadManager.getUIHandler().postDelayed(this, 1000L);
                }
            }
        }
    }

    QFSWeakNetworkOptHelper() {
    }

    private final void c() {
        Integer intOrNull;
        int i3;
        Long longOrNull;
        long j3;
        if (!isInitialized) {
            synchronized (this) {
                if (!isInitialized) {
                    HashMap hashMap = new HashMap();
                    hashMap.put("weakNetKBs", "350");
                    hashMap.put("showCountOneDay", "-1");
                    Map<String, String> M = uq3.o.M("qqcircle_weak_net_opt", hashMap);
                    String str = M.get("weakNetKBs");
                    if (str == null) {
                        str = "350";
                    }
                    String str2 = M.get("showCountOneDay");
                    if (str2 == null) {
                        str2 = "-1";
                    }
                    intOrNull = StringsKt__StringNumberConversionsKt.toIntOrNull(str2);
                    if (intOrNull != null) {
                        i3 = intOrNull.intValue();
                    } else {
                        i3 = -1;
                    }
                    canShowCountOneDay = i3;
                    longOrNull = StringsKt__StringNumberConversionsKt.toLongOrNull(str);
                    if (longOrNull != null) {
                        j3 = longOrNull.longValue();
                    } else {
                        j3 = 350;
                    }
                    weakNetKBs = j3;
                    hasShowCount = uq3.k.a().e("qfs_key_weak_net_opt_tips_show_count", 0);
                    lastShowTime = uq3.k.a().f("qfs_key_weak_net_opt_tips_last_show_time", -1L);
                    isInitialized = true;
                    QLog.d("QFSWeakNetworkOptHelper", 1, "[initConfig], canShowCountOneDay:" + str2 + ", weakNetKBs:" + str + ", hasShowCount:" + hasShowCount + ", lastShowTime:" + lastShowTime);
                }
                Unit unit = Unit.INSTANCE;
            }
        }
    }

    public final boolean a() {
        c();
        if (mCurHasShow) {
            return false;
        }
        if (canShowCountOneDay < 0) {
            return true;
        }
        if (lastShowTime == -1 || !uq3.n.c(System.currentTimeMillis(), lastShowTime)) {
            hasShowCount = 0;
            lastShowTime = -1L;
            uq3.k.a().m("qfs_key_weak_net_opt_tips_show_count", hasShowCount);
            uq3.k.a().n("qfs_key_weak_net_opt_tips_last_show_time", lastShowTime);
        }
        if (hasShowCount >= canShowCountOneDay) {
            return false;
        }
        return true;
    }

    public final void b() {
        mCurHasShow = true;
        hasShowCount++;
        lastShowTime = System.currentTimeMillis();
        uq3.k.a().m("qfs_key_weak_net_opt_tips_show_count", hasShowCount);
        uq3.k.a().n("qfs_key_weak_net_opt_tips_last_show_time", lastShowTime);
    }

    public final boolean d() {
        if (QCircleNetWorkTestHelper.f92533b.get()) {
            return true;
        }
        c();
        if (RFWVideoUtils.getPredictSpeedWithOutDownGrade(126) <= weakNetKBs) {
            return true;
        }
        return false;
    }

    public final void e() {
        synchronized (this) {
            isInitialized = false;
            canShowCountOneDay = 0;
            weakNetKBs = 350L;
            QLog.d("QFSWeakNetworkOptHelper", 1, "[reset]");
            Unit unit = Unit.INSTANCE;
        }
    }
}

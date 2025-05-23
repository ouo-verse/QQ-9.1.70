package com.tencent.mobileqq.guild.mainframe;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.os.BundleKt;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentContainerView;
import androidx.fragment.app.FragmentManager;
import com.tencent.cache.api.Business;
import com.tencent.cache.api.Page;
import com.tencent.cache.api.PageHierarchy;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.Frame;
import com.tencent.mobileqq.app.FrameFragment;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.app.be;
import com.tencent.mobileqq.guild.api.IGuildTempApi;
import com.tencent.mobileqq.guild.base.preload.LayoutLoaders;
import com.tencent.mobileqq.guild.base.reflect.FragmentReflect;
import com.tencent.mobileqq.guild.config.subconfig.parser.GuildMemoryReleaseParser;
import com.tencent.mobileqq.guild.discoveryv2.fragment.GuildFrameFragment;
import com.tencent.mobileqq.guild.feed.api.IGuildFeedUtilsApi;
import com.tencent.mobileqq.guild.message.unread.api.IGuildUnreadCntService;
import com.tencent.mobileqq.guild.performance.report.IGuildPerformanceReportApi;
import com.tencent.mobileqq.guild.util.GuildDebugUtils;
import com.tencent.mobileqq.guild.util.Logger;
import com.tencent.mobileqq.guild.util.TraceUtils;
import com.tencent.mobileqq.guild.util.cy;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qaddefine.QAdReportDefine$AdReporterParams;
import com.tencent.mobileqq.util.cv;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.QzoneIPCModule;
import java.util.Iterator;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.time.Duration;
import kotlin.time.ExperimentalTime;
import mqq.util.WeakReference;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u00a6\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\b\u0007\u0018\u0000 c2\u00020\u00012\u00020\u00022\u00020\u0003:\u0001dB\u0017\u0012\u0006\u0010C\u001a\u00020B\u0012\u0006\u0010E\u001a\u000202\u00a2\u0006\u0004\ba\u0010bJ\u0016\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00040\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\b\u0010\t\u001a\u00020\bH\u0002J\f\u0010\u000b\u001a\u00020\b*\u00020\nH\u0002J\b\u0010\r\u001a\u00020\fH\u0002J\b\u0010\u000e\u001a\u00020\fH\u0002J\b\u0010\u000f\u001a\u00020\fH\u0002J\b\u0010\u0010\u001a\u00020\bH\u0002J\u0010\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0012\u001a\u00020\u0011H\u0017J\b\u0010\u0015\u001a\u00020\bH\u0016J\b\u0010\u0016\u001a\u00020\bH\u0016J\u0010\u0010\u0019\u001a\u00020\b2\u0006\u0010\u0018\u001a\u00020\u0017H\u0016J\u0010\u0010\u001a\u001a\u00020\b2\u0006\u0010\u0018\u001a\u00020\u0017H\u0016J\b\u0010\u001b\u001a\u00020\bH\u0016J\b\u0010\u001c\u001a\u00020\bH\u0017J\b\u0010\u001d\u001a\u00020\bH\u0014J\u0010\u0010\u001f\u001a\u00020\b2\u0006\u0010\u001e\u001a\u00020\u0017H\u0016J\u0010\u0010\"\u001a\u00020\b2\u0006\u0010!\u001a\u00020 H\u0016J\u0010\u0010%\u001a\u00020\b2\u0006\u0010$\u001a\u00020#H\u0016J\b\u0010&\u001a\u00020\u0017H\u0016J\u0010\u0010(\u001a\u00020\b2\u0006\u0010'\u001a\u00020\u0017H\u0016J\"\u0010-\u001a\u00020\b2\u0006\u0010*\u001a\u00020)2\u0006\u0010+\u001a\u00020)2\b\u0010,\u001a\u0004\u0018\u00010#H\u0016J\u001a\u00101\u001a\u00020\b2\u0006\u0010.\u001a\u00020\u00172\b\u00100\u001a\u0004\u0018\u00010/H\u0017J\u0012\u00104\u001a\u00020\b2\b\u00103\u001a\u0004\u0018\u000102H\u0016J\u0010\u00106\u001a\u00020\b2\u0006\u00105\u001a\u00020)H\u0016J\u0010\u00107\u001a\u00020\b2\u0006\u00105\u001a\u00020)H\u0016J\u0012\u00109\u001a\u00020\b2\b\u00108\u001a\u0004\u0018\u00010\u0013H\u0016J\u0018\u0010<\u001a\u00020\b2\u0006\u0010:\u001a\u00020)2\u0006\u0010;\u001a\u00020\u0017H\u0016J\u0018\u0010?\u001a\u00020\b2\u0006\u0010=\u001a\u00020\u00042\u0006\u0010>\u001a\u00020\u0017H\u0016J\b\u0010@\u001a\u00020\bH\u0016J\b\u0010A\u001a\u00020\bH\u0007R\u0014\u0010C\u001a\u00020B8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bC\u0010DR\u0014\u0010E\u001a\u0002028\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bE\u0010FR\u0016\u0010G\u001a\u00020\f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bG\u0010HR\u0016\u0010J\u001a\u00020I8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bJ\u0010KR\u0016\u0010M\u001a\u00020L8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bM\u0010NR\u001c\u0010P\u001a\u00020O8\u0002@\u0002X\u0083\u000e\u00a2\u0006\f\n\u0004\bP\u0010Q\u0012\u0004\bR\u0010SR\u0014\u0010U\u001a\u00020T8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bU\u0010VR#\u0010X\u001a\u00020W8\u0002X\u0083\u0004\u00f8\u0001\u0000\u00f8\u0001\u0001\u00f8\u0001\u0002\u00a2\u0006\f\n\u0004\bX\u0010Y\u0012\u0004\bZ\u0010SR\u0016\u0010[\u001a\u00020)8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b[\u0010\\R\u0014\u0010`\u001a\u00020]8BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\b^\u0010_\u0082\u0002\u000f\n\u0002\b\u0019\n\u0005\b\u00a1\u001e0\u0001\n\u0002\b!\u00a8\u0006e"}, d2 = {"Lcom/tencent/mobileqq/guild/mainframe/GuildFragmentDelegateFrame;", "Lcom/tencent/mobileqq/app/Frame;", "Lcom/tencent/mobileqq/guild/mainframe/s;", "Lcom/tencent/mobileqq/guild/mainframe/u;", "", "method", "Lkotlin/Lazy;", "message", "", "ensureFragmentViewExist", "Landroidx/fragment/app/Fragment;", "removeGuildFragment", "Lcom/tencent/mobileqq/guild/mainframe/AbsGuildMainFragment;", "determineGuildTabFragment", "getDiscoverMainFragment", "getWaitGProMainFragment", "clearFeedsListCache", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/View;", "notifyCreateView", "notifyCreate", "notifyStart", "", "tabChanged", "notifyResume", "notifyPause", "notifyStop", "notifyDestroy", "onBeforeAccountChanged", "isSwitchAccount", "fillData", "Landroid/content/res/Configuration;", "newConfig", "notifyConfigurationChanged", "Landroid/content/Intent;", "intent", "notifyNewIntent", "notifyBackPressed", "isInMultiWindowMode", "notifyMultiWindowModeChanged", "", "requestCode", QzoneIPCModule.RESULT_CODE, "data", "notifyActivityResult", "guildTab", "Lcom/tencent/mobileqq/guild/message/unread/api/IGuildUnreadCntService$b;", "tabUnreadCntInfo", "onTabChanged", "Landroid/os/Bundle;", "extra", "handleJumpAction", "height", "onPostThemeChanged", "setTabHeight", "view", "onGuildTabClick", QAdReportDefine$AdReporterParams.K_Q_AD_REPORTER_PARAM_KEY_SHOW_TYPE, "isPlayAnim", "guildCenterPanelInOrOut", "source", NodeProps.VISIBLE, "changeGuildFacadeVisible", "restoreGuildTabFragment", "recycleGuildMainFragment", "Lcom/tencent/mobileqq/app/FrameFragment;", "mainFragment", "Lcom/tencent/mobileqq/app/FrameFragment;", "initBundle", "Landroid/os/Bundle;", "delegateFragment", "Lcom/tencent/mobileqq/guild/mainframe/AbsGuildMainFragment;", "Landroidx/fragment/app/FragmentContainerView;", "fragmentContainer", "Landroidx/fragment/app/FragmentContainerView;", "Lcom/tencent/mobileqq/guild/mainframe/GuildFragmentDelegateFrame$a$a;", "activeStatus", "Lcom/tencent/mobileqq/guild/mainframe/GuildFragmentDelegateFrame$a$a;", "Ljava/lang/Runnable;", "recyclingRunnable", "Ljava/lang/Runnable;", "getRecyclingRunnable$annotations", "()V", "Landroid/os/Handler;", "mHandler", "Landroid/os/Handler;", "Lkotlin/time/Duration;", "memoryReleaseInterval", "J", "getMemoryReleaseInterval-UwyO8pc$annotations", "currentPageType", "I", "Landroidx/fragment/app/FragmentManager;", "getChildFragmentManager", "()Landroidx/fragment/app/FragmentManager;", "childFragmentManager", "<init>", "(Lcom/tencent/mobileqq/app/FrameFragment;Landroid/os/Bundle;)V", "Companion", "a", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
@Page(business = Business.Guild, type = PageHierarchy.MainPage)
/* loaded from: classes14.dex */
public final class GuildFragmentDelegateFrame extends Frame implements s, u {

    @NotNull
    private static final String CHILD_MAIN_FRAGMENT_TAG = "CHILD_MAIN_FRAGMENT_TAG";

    @NotNull
    private static final String TAG = "Guild.MF.GuildFragmentDelegateFrame";

    @NotNull
    private Companion.ActiveStatus activeStatus;
    private int currentPageType;

    @NotNull
    private AbsGuildMainFragment delegateFragment;
    private FragmentContainerView fragmentContainer;

    @NotNull
    private final Bundle initBundle;

    @NotNull
    private final Handler mHandler;

    @NotNull
    private final FrameFragment mainFragment;
    private final long memoryReleaseInterval;

    @NotNull
    private Runnable recyclingRunnable;

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @NotNull
    private static WeakReference<GuildFragmentDelegateFrame> weakFrame = new WeakReference<>(null);

    /* compiled from: P */
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001:\u0001\u0005B\t\b\u0002\u00a2\u0006\u0004\b\u000e\u0010\u000fJ\u0012\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002R\u0014\u0010\u0007\u001a\u00020\u00068\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\bR\u0014\u0010\t\u001a\u00020\u00068\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\t\u0010\bR\u001c\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000b0\n8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\f\u0010\r\u00a8\u0006\u0010"}, d2 = {"Lcom/tencent/mobileqq/guild/mainframe/GuildFragmentDelegateFrame$a;", "", "Landroid/content/Context;", "context", "Lcom/tencent/mobileqq/app/be;", "a", "", GuildFragmentDelegateFrame.CHILD_MAIN_FRAGMENT_TAG, "Ljava/lang/String;", "TAG", "Lmqq/util/WeakReference;", "Lcom/tencent/mobileqq/guild/mainframe/GuildFragmentDelegateFrame;", "weakFrame", "Lmqq/util/WeakReference;", "<init>", "()V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.guild.mainframe.GuildFragmentDelegateFrame$a, reason: from kotlin metadata */
    /* loaded from: classes14.dex */
    public static final class Companion {

        /* compiled from: P */
        @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0010\t\n\u0002\b\b\b\u0082\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0017\u001a\u00020\u0012\u00a2\u0006\u0004\b\u0018\u0010\u0019J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\t\u0010\u0007\u001a\u00020\u0006H\u00d6\u0001J\t\u0010\t\u001a\u00020\bH\u00d6\u0001J\u0013\u0010\u000b\u001a\u00020\u00022\b\u0010\n\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\"\u0010\u0017\u001a\u00020\u00128\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u000e\u0010\u0013\u001a\u0004\b\f\u0010\u0014\"\u0004\b\u0015\u0010\u0016\u00a8\u0006\u001a"}, d2 = {"Lcom/tencent/mobileqq/guild/mainframe/GuildFragmentDelegateFrame$a$a;", "", "", "isActive", "", "c", "", "toString", "", "hashCode", "other", "equals", "a", "Z", "b", "()Z", "setActive", "(Z)V", "", "J", "()J", "setOptionTimestamp", "(J)V", "optionTimestamp", "<init>", "(ZJ)V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
        /* renamed from: com.tencent.mobileqq.guild.mainframe.GuildFragmentDelegateFrame$a$a, reason: collision with other inner class name and from toString */
        /* loaded from: classes14.dex */
        private static final /* data */ class ActiveStatus {

            /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
            private boolean isActive;

            /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
            private long optionTimestamp;

            public ActiveStatus(boolean z16, long j3) {
                this.isActive = z16;
                this.optionTimestamp = j3;
            }

            /* renamed from: a, reason: from getter */
            public final long getOptionTimestamp() {
                return this.optionTimestamp;
            }

            /* renamed from: b, reason: from getter */
            public final boolean getIsActive() {
                return this.isActive;
            }

            public final void c(boolean isActive) {
                if (isActive != this.isActive) {
                    long uptimeMillis = SystemClock.uptimeMillis();
                    Logger.f235387a.d().i(GuildFragmentDelegateFrame.TAG, 1, "updateActiveStatus(" + isActive + "), " + getIsActive() + " -> " + isActive + ", " + getOptionTimestamp() + " -> " + uptimeMillis);
                    this.isActive = isActive;
                    this.optionTimestamp = uptimeMillis;
                    return;
                }
                Logger.f235387a.d().i(GuildFragmentDelegateFrame.TAG, 1, "updateActiveStatus(" + isActive + "), no change");
            }

            public boolean equals(@Nullable Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof ActiveStatus)) {
                    return false;
                }
                ActiveStatus activeStatus = (ActiveStatus) other;
                if (this.isActive == activeStatus.isActive && this.optionTimestamp == activeStatus.optionTimestamp) {
                    return true;
                }
                return false;
            }

            /* JADX WARN: Multi-variable type inference failed */
            /* JADX WARN: Type inference failed for: r0v1, types: [int] */
            /* JADX WARN: Type inference failed for: r0v4 */
            /* JADX WARN: Type inference failed for: r0v5 */
            public int hashCode() {
                boolean z16 = this.isActive;
                ?? r06 = z16;
                if (z16) {
                    r06 = 1;
                }
                return (r06 * 31) + androidx.fragment.app.a.a(this.optionTimestamp);
            }

            @NotNull
            public String toString() {
                return "ActiveStatus(isActive=" + this.isActive + ", optionTimestamp=" + this.optionTimestamp + ")";
            }
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @Nullable
        public final be a(@Nullable Context context) {
            be obtainGuildMainFrame = ((IGuildTempApi) QRoute.api(IGuildTempApi.class)).obtainGuildMainFrame(context);
            if (obtainGuildMainFrame == null) {
                return (be) GuildFragmentDelegateFrame.weakFrame.get();
            }
            return obtainGuildMainFrame;
        }

        Companion() {
        }
    }

    public GuildFragmentDelegateFrame(@NotNull FrameFragment mainFragment, @NotNull Bundle initBundle) {
        Runnable e16;
        Intrinsics.checkNotNullParameter(mainFragment, "mainFragment");
        Intrinsics.checkNotNullParameter(initBundle, "initBundle");
        this.mainFragment = mainFragment;
        this.initBundle = initBundle;
        this.activeStatus = new Companion.ActiveStatus(false, 0L);
        e16 = GuildFragmentDelegateFrameKt.e(this);
        this.recyclingRunnable = e16;
        this.mHandler = new Handler(Looper.getMainLooper());
        this.memoryReleaseInterval = GuildMemoryReleaseParser.INSTANCE.a();
        this.currentPageType = 4;
        cv.c("GuildFragmentDelegateFrame init");
        this.delegateFragment = determineGuildTabFragment();
        Logger logger = Logger.f235387a;
        if (QLog.isColorLevel()) {
            logger.d().d(TAG, 2, "MainFragment " + System.identityHashCode(this.mainFragment) + "/" + System.identityHashCode(getChildFragmentManager()) + " " + message("init").getValue());
        }
        FragmentReflect.f214787a.b();
        QRouteApi api = QRoute.api(IGuildPerformanceReportApi.class);
        Intrinsics.checkNotNullExpressionValue(api, "api(IGuildPerformanceReportApi::class.java)");
        IGuildPerformanceReportApi iGuildPerformanceReportApi = (IGuildPerformanceReportApi) api;
        if (iGuildPerformanceReportApi.isEnableGuildTabMethodTrace()) {
            TraceUtils.o("GuildTabMethodTrace", iGuildPerformanceReportApi.getGuildTabPageMethodTraceDuration());
        }
    }

    private final void clearFeedsListCache() {
        ((IGuildFeedUtilsApi) QRoute.api(IGuildFeedUtilsApi.class)).clearFeedListViewCache();
    }

    private final AbsGuildMainFragment determineGuildTabFragment() {
        if (GuildWaitGProMainFragment.INSTANCE.a()) {
            this.currentPageType = 5;
            return getWaitGProMainFragment();
        }
        this.currentPageType = 4;
        return getDiscoverMainFragment();
    }

    private final void ensureFragmentViewExist() {
        FragmentContainerView fragmentContainerView = this.fragmentContainer;
        FragmentContainerView fragmentContainerView2 = null;
        if (fragmentContainerView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("fragmentContainer");
            fragmentContainerView = null;
        }
        int indexOfChild = fragmentContainerView.indexOfChild(this.delegateFragment.getView());
        Logger.f235387a.d().i(TAG, 1, "ensureFragmentViewExist() - indexOfChild = " + indexOfChild);
        if (indexOfChild < 0) {
            FragmentContainerView fragmentContainerView3 = this.fragmentContainer;
            if (fragmentContainerView3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("fragmentContainer");
            } else {
                fragmentContainerView2 = fragmentContainerView3;
            }
            fragmentContainerView2.addView(this.delegateFragment.getView());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final FragmentManager getChildFragmentManager() {
        FragmentManager childFragmentManager = this.mainFragment.getChildFragmentManager();
        Intrinsics.checkNotNullExpressionValue(childFragmentManager, "mainFragment.childFragmentManager");
        return childFragmentManager;
    }

    private final AbsGuildMainFragment getDiscoverMainFragment() {
        cv.c("GuildFragmentDelegateFrame getDiscoverMainFragment");
        Logger.f235387a.d().i(TAG, 1, "getCurrentMainFragment, addFragment: GuildDiscoverMainFragment");
        TraceUtils traceUtils = TraceUtils.f235403a;
        if (!TraceUtils.m()) {
            traceUtils.l();
            Bundle bundle = new Bundle(this.initBundle);
            this.initBundle.clear();
            getChildFragmentManager().beginTransaction().add(GuildFrameFragment.class, bundle, CHILD_MAIN_FRAGMENT_TAG).commitNowAllowingStateLoss();
            Fragment findFragmentByTag = getChildFragmentManager().findFragmentByTag(CHILD_MAIN_FRAGMENT_TAG);
            Intrinsics.checkNotNull(findFragmentByTag, "null cannot be cast to non-null type com.tencent.mobileqq.guild.discoveryv2.fragment.GuildFrameFragment");
            return (GuildFrameFragment) findFragmentByTag;
        }
        try {
            cy.c("Guild.DiscoveryMain.Fragment.open");
            Bundle bundle2 = new Bundle(this.initBundle);
            this.initBundle.clear();
            getChildFragmentManager().beginTransaction().add(GuildFrameFragment.class, bundle2, CHILD_MAIN_FRAGMENT_TAG).commitNowAllowingStateLoss();
            Fragment findFragmentByTag2 = getChildFragmentManager().findFragmentByTag(CHILD_MAIN_FRAGMENT_TAG);
            Intrinsics.checkNotNull(findFragmentByTag2, "null cannot be cast to non-null type com.tencent.mobileqq.guild.discoveryv2.fragment.GuildFrameFragment");
            return (GuildFrameFragment) findFragmentByTag2;
        } finally {
            cy.d();
        }
    }

    private final AbsGuildMainFragment getWaitGProMainFragment() {
        cv.c("GuildFragmentDelegateFrame getWaitGProMainFragment");
        Logger.f235387a.d().i(TAG, 1, "getCurrentMainFragment, addFragment: GuildWaitGProMainFragment");
        TraceUtils traceUtils = TraceUtils.f235403a;
        if (!TraceUtils.m()) {
            traceUtils.l();
            getChildFragmentManager().beginTransaction().add(GuildWaitGProMainFragment.class, new Bundle(this.initBundle), CHILD_MAIN_FRAGMENT_TAG).commitNowAllowingStateLoss();
            Fragment findFragmentByTag = getChildFragmentManager().findFragmentByTag(CHILD_MAIN_FRAGMENT_TAG);
            Intrinsics.checkNotNull(findFragmentByTag, "null cannot be cast to non-null type com.tencent.mobileqq.guild.mainframe.GuildWaitGProMainFragment");
            return (GuildWaitGProMainFragment) findFragmentByTag;
        }
        try {
            cy.c("Guild.DiscoveryMain.WaitGPro.Fragment.open");
            getChildFragmentManager().beginTransaction().add(GuildWaitGProMainFragment.class, new Bundle(this.initBundle), CHILD_MAIN_FRAGMENT_TAG).commitNowAllowingStateLoss();
            Fragment findFragmentByTag2 = getChildFragmentManager().findFragmentByTag(CHILD_MAIN_FRAGMENT_TAG);
            Intrinsics.checkNotNull(findFragmentByTag2, "null cannot be cast to non-null type com.tencent.mobileqq.guild.mainframe.GuildWaitGProMainFragment");
            return (GuildWaitGProMainFragment) findFragmentByTag2;
        } finally {
            cy.d();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Lazy<String> message(String method) {
        return GuildDebugUtils.f235333a.c(this.delegateFragment, TAG, method);
    }

    private final void removeGuildFragment(Fragment fragment) {
        Object m476constructorimpl;
        String str;
        try {
            Result.Companion companion = Result.INSTANCE;
            Fragment findFragmentByTag = fragment.getChildFragmentManager().findFragmentByTag(CHILD_MAIN_FRAGMENT_TAG);
            Logger.a d16 = Logger.f235387a.d();
            String simpleName = fragment.getClass().getSimpleName();
            if (findFragmentByTag != null) {
                str = findFragmentByTag.getClass().getSimpleName();
            } else {
                str = null;
            }
            d16.i(TAG, 1, simpleName + " removeGuildFragment - fragment: " + str);
            if (findFragmentByTag != null) {
                fragment.getChildFragmentManager().beginTransaction().remove(findFragmentByTag).commitNowAllowingStateLoss();
                fragment.getChildFragmentManager().popBackStack();
            }
            m476constructorimpl = Result.m476constructorimpl(Unit.INSTANCE);
        } catch (Throwable th5) {
            Result.Companion companion2 = Result.INSTANCE;
            m476constructorimpl = Result.m476constructorimpl(ResultKt.createFailure(th5));
        }
        Throwable m479exceptionOrNullimpl = Result.m479exceptionOrNullimpl(m476constructorimpl);
        if (m479exceptionOrNullimpl != null) {
            Logger logger = Logger.f235387a;
            Logger.b bVar = new Logger.b();
            String str2 = "removeGuildFragment " + m479exceptionOrNullimpl.getMessage();
            if (str2 instanceof String) {
                bVar.a().add(str2);
            }
            Iterator<T> it = bVar.a().iterator();
            while (it.hasNext()) {
                Logger.f235387a.d().e(TAG, 1, (String) it.next(), null);
            }
        }
    }

    @Override // com.tencent.mobileqq.guild.mainframe.s
    public void changeGuildFacadeVisible(@NotNull String source, boolean visible) {
        Intrinsics.checkNotNullParameter(source, "source");
        this.delegateFragment.changeGuildFacadeVisible(source, visible);
    }

    @Override // com.tencent.mobileqq.app.Frame
    public void fillData(boolean isSwitchAccount) {
        GuildDebugUtils guildDebugUtils = GuildDebugUtils.f235333a;
        Lazy<String> message = message("fillData(" + isSwitchAccount + ")");
        Logger logger = Logger.f235387a;
        if (QLog.isColorLevel()) {
            logger.d().d("GUILD_DEBUG", 2, ((Object) message.getValue()) + " begin...");
        }
        TraceUtils.h(message.getValue());
        this.delegateFragment.md(isSwitchAccount);
        Unit unit = Unit.INSTANCE;
        if (QLog.isColorLevel()) {
            logger.d().d("GUILD_DEBUG", 2, ((Object) message.getValue()) + " end...");
        }
        TraceUtils.k();
    }

    @Override // com.tencent.mobileqq.guild.mainframe.s
    public void guildCenterPanelInOrOut(int showType, boolean isPlayAnim) {
        this.delegateFragment.guildCenterPanelInOrOut(showType, isPlayAnim);
    }

    @Override // com.tencent.mobileqq.guild.mainframe.s
    public void handleJumpAction(@Nullable Bundle extra) {
        this.delegateFragment.handleJumpAction(extra);
    }

    @Override // com.tencent.mobileqq.app.Frame, com.tencent.mobileqq.app.ba
    public void notifyActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        GuildDebugUtils guildDebugUtils = GuildDebugUtils.f235333a;
        Lazy<String> message = message("onActivityResult()");
        Logger logger = Logger.f235387a;
        if (QLog.isColorLevel()) {
            logger.d().d("GUILD_DEBUG", 2, ((Object) message.getValue()) + " begin...");
        }
        TraceUtils.h(message.getValue());
        this.delegateFragment.th(requestCode, resultCode, data);
        Unit unit = Unit.INSTANCE;
        if (QLog.isColorLevel()) {
            logger.d().d("GUILD_DEBUG", 2, ((Object) message.getValue()) + " end...");
        }
        TraceUtils.k();
    }

    @Override // com.tencent.mobileqq.app.Frame, com.tencent.mobileqq.app.ba
    public boolean notifyBackPressed() {
        boolean z16;
        GuildDebugUtils guildDebugUtils = GuildDebugUtils.f235333a;
        Lazy<String> message = message("onBackPressed()");
        Logger logger = Logger.f235387a;
        if (QLog.isColorLevel()) {
            logger.d().d("GUILD_DEBUG", 2, ((Object) message.getValue()) + " begin...");
        }
        TraceUtils.h(message.getValue());
        if (!this.delegateFragment.uh() && !super.notifyBackPressed()) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (QLog.isColorLevel()) {
            logger.d().d("GUILD_DEBUG", 2, ((Object) message.getValue()) + " end...");
        }
        TraceUtils.k();
        return z16;
    }

    @Override // com.tencent.mobileqq.app.Frame, com.tencent.mobileqq.app.ba
    public void notifyConfigurationChanged(@NotNull Configuration newConfig) {
        Intrinsics.checkNotNullParameter(newConfig, "newConfig");
        super.notifyConfigurationChanged(newConfig);
    }

    @Override // com.tencent.mobileqq.app.Frame, com.tencent.mobileqq.app.ba
    public void notifyCreate() {
        GuildDebugUtils guildDebugUtils = GuildDebugUtils.f235333a;
        Lazy<String> message = message("onCreate()");
        Logger logger = Logger.f235387a;
        if (QLog.isColorLevel()) {
            logger.d().d("GUILD_DEBUG", 2, ((Object) message.getValue()) + " begin...");
        }
        TraceUtils.h(message.getValue());
        super.notifyCreate();
        this.delegateFragment.qh();
        Unit unit = Unit.INSTANCE;
        if (QLog.isColorLevel()) {
            logger.d().d("GUILD_DEBUG", 2, ((Object) message.getValue()) + " end...");
        }
        TraceUtils.k();
    }

    @Override // com.tencent.mobileqq.app.Frame, com.tencent.mobileqq.app.ba
    @SuppressLint({"InflateParams"})
    @NotNull
    public View notifyCreateView(@NotNull LayoutInflater inflater) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        GuildDebugUtils guildDebugUtils = GuildDebugUtils.f235333a;
        Lazy<String> message = message("onCreateView()");
        Logger logger = Logger.f235387a;
        if (QLog.isColorLevel()) {
            logger.d().d("GUILD_DEBUG", 2, ((Object) message.getValue()) + " begin...");
        }
        TraceUtils.h(message.getValue());
        View inflate = inflater.inflate(R.layout.esd, (ViewGroup) null);
        Intrinsics.checkNotNullExpressionValue(inflate, "inflater.inflate(R.layou\u2026e_replacement_main, null)");
        View findViewById = inflate.findViewById(R.id.f165521wg1);
        Intrinsics.checkNotNullExpressionValue(findViewById, "rootView.findViewById(R.\u2026_fragment_container_view)");
        this.fragmentContainer = (FragmentContainerView) findViewById;
        ensureFragmentViewExist();
        weakFrame = new WeakReference<>(this);
        if (QLog.isColorLevel()) {
            logger.d().d("GUILD_DEBUG", 2, ((Object) message.getValue()) + " end...");
        }
        TraceUtils.k();
        return inflate;
    }

    @Override // com.tencent.mobileqq.app.Frame, com.tencent.mobileqq.app.ba
    @ExperimentalTime
    public void notifyDestroy() {
        GuildDebugUtils guildDebugUtils = GuildDebugUtils.f235333a;
        Lazy<String> message = message("onDestroy()");
        Logger logger = Logger.f235387a;
        if (QLog.isColorLevel()) {
            logger.d().d("GUILD_DEBUG", 2, ((Object) message.getValue()) + " begin...");
        }
        TraceUtils.h(message.getValue());
        super.notifyDestroy();
        FragmentContainerView fragmentContainerView = null;
        this.mHandler.removeCallbacksAndMessages(null);
        this.delegateFragment.rh();
        FragmentContainerView fragmentContainerView2 = this.fragmentContainer;
        if (fragmentContainerView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("fragmentContainer");
        } else {
            fragmentContainerView = fragmentContainerView2;
        }
        fragmentContainerView.removeAllViews();
        if (!this.mainFragment.isDetached()) {
            removeGuildFragment(this.mainFragment);
        }
        Unit unit = Unit.INSTANCE;
        if (QLog.isColorLevel()) {
            logger.d().d("GUILD_DEBUG", 2, ((Object) message.getValue()) + " end...");
        }
        TraceUtils.k();
    }

    @Override // com.tencent.mobileqq.app.Frame, com.tencent.mobileqq.app.ba
    public void notifyMultiWindowModeChanged(boolean isInMultiWindowMode) {
        FragmentReflect.f214787a.a(this.delegateFragment, isInMultiWindowMode);
    }

    @Override // com.tencent.mobileqq.app.Frame, com.tencent.mobileqq.app.ba
    public void notifyNewIntent(@NotNull Intent intent) {
        Intrinsics.checkNotNullParameter(intent, "intent");
        this.delegateFragment.sh(intent);
    }

    @Override // com.tencent.mobileqq.app.Frame, com.tencent.mobileqq.app.ba
    public void notifyPause(boolean tabChanged) {
        GuildDebugUtils guildDebugUtils = GuildDebugUtils.f235333a;
        Lazy<String> message = message("onPause(" + tabChanged + ")");
        Logger logger = Logger.f235387a;
        if (QLog.isColorLevel()) {
            logger.d().d("GUILD_DEBUG", 2, ((Object) message.getValue()) + " begin...");
        }
        TraceUtils.h(message.getValue());
        super.notifyPause(tabChanged);
        logger.d().d(TAG, 1, "onPause " + this.delegateFragment + " currentType:" + this.currentPageType);
        if (this.delegateFragment.ph()) {
            GuildFragmentDelegateFrameKt.d(this.mainFragment, this.delegateFragment);
            this.delegateFragment.vh(tabChanged);
            Unit unit = Unit.INSTANCE;
            if (QLog.isColorLevel()) {
                logger.d().d("GUILD_DEBUG", 2, ((Object) message.getValue()) + " end...");
            }
            TraceUtils.k();
            return;
        }
        IllegalStateException illegalStateException = new IllegalStateException("onPause()");
        Logger.b bVar = new Logger.b();
        bVar.a().add("fragment not attached to parent! the call onPause() from FrameFragment is illegal, is unexpected!");
        Iterator<T> it = bVar.a().iterator();
        while (it.hasNext()) {
            Logger.f235387a.d().e(TAG, 1, (String) it.next(), illegalStateException);
        }
    }

    @Override // com.tencent.mobileqq.app.Frame, com.tencent.mobileqq.app.ba
    public void notifyResume(boolean tabChanged) {
        GuildDebugUtils guildDebugUtils = GuildDebugUtils.f235333a;
        Lazy<String> message = message("onResume(" + tabChanged + ")");
        Logger logger = Logger.f235387a;
        if (QLog.isColorLevel()) {
            logger.d().d("GUILD_DEBUG", 2, ((Object) message.getValue()) + " begin...");
        }
        TraceUtils.h(message.getValue());
        super.notifyResume(tabChanged);
        logger.d().i(TAG, 1, "onResume " + this.delegateFragment + " currentPageType:" + this.currentPageType);
        if (this.currentPageType == 0) {
            AbsGuildMainFragment absGuildMainFragment = this.delegateFragment;
            if (absGuildMainFragment instanceof GuildRecycledMainFragment) {
                Bundle bundle = this.initBundle;
                Bundle arguments = absGuildMainFragment.getArguments();
                if (arguments == null) {
                    arguments = BundleKt.bundleOf(new Pair[0]);
                }
                bundle.putAll(arguments);
                restoreGuildTabFragment();
            } else {
                throw new IllegalStateException("Check failed.".toString());
            }
        }
        GuildFragmentDelegateFrameKt.f(this.mainFragment, this.delegateFragment);
        this.delegateFragment.wh(tabChanged);
        Unit unit = Unit.INSTANCE;
        if (QLog.isColorLevel()) {
            logger.d().d("GUILD_DEBUG", 2, ((Object) message.getValue()) + " end...");
        }
        TraceUtils.k();
    }

    @Override // com.tencent.mobileqq.app.Frame, com.tencent.mobileqq.app.ba
    public void notifyStart() {
        GuildDebugUtils guildDebugUtils = GuildDebugUtils.f235333a;
        Lazy<String> message = message("onStart()");
        Logger logger = Logger.f235387a;
        if (QLog.isColorLevel()) {
            logger.d().d("GUILD_DEBUG", 2, ((Object) message.getValue()) + " begin...");
        }
        TraceUtils.h(message.getValue());
        super.notifyStart();
        this.delegateFragment.xh();
        Unit unit = Unit.INSTANCE;
        if (QLog.isColorLevel()) {
            logger.d().d("GUILD_DEBUG", 2, ((Object) message.getValue()) + " end...");
        }
        TraceUtils.k();
    }

    @Override // com.tencent.mobileqq.app.Frame, com.tencent.mobileqq.app.ba
    public void notifyStop() {
        GuildDebugUtils guildDebugUtils = GuildDebugUtils.f235333a;
        Lazy<String> message = message("onStop()");
        Logger logger = Logger.f235387a;
        if (QLog.isColorLevel()) {
            logger.d().d("GUILD_DEBUG", 2, ((Object) message.getValue()) + " begin...");
        }
        TraceUtils.h(message.getValue());
        super.notifyStop();
        this.delegateFragment.yh();
        Unit unit = Unit.INSTANCE;
        if (QLog.isColorLevel()) {
            logger.d().d("GUILD_DEBUG", 2, ((Object) message.getValue()) + " end...");
        }
        TraceUtils.k();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.app.Frame
    public void onBeforeAccountChanged() {
        GuildDebugUtils guildDebugUtils = GuildDebugUtils.f235333a;
        Lazy<String> message = message("onBeforeAccountChanged()");
        Logger logger = Logger.f235387a;
        if (QLog.isColorLevel()) {
            logger.d().d("GUILD_DEBUG", 2, ((Object) message.getValue()) + " begin...");
        }
        TraceUtils.h(message.getValue());
        this.delegateFragment.gg();
        Unit unit = Unit.INSTANCE;
        if (QLog.isColorLevel()) {
            logger.d().d("GUILD_DEBUG", 2, ((Object) message.getValue()) + " end...");
        }
        TraceUtils.k();
    }

    @Override // com.tencent.mobileqq.guild.mainframe.s
    public void onGuildTabClick(@Nullable View view) {
        this.delegateFragment.onGuildTabClick(view);
    }

    @Override // com.tencent.mobileqq.guild.mainframe.s
    public void onPostThemeChanged(int height) {
        this.delegateFragment.onPostThemeChanged(height);
    }

    @Override // com.tencent.mobileqq.guild.mainframe.s
    @ExperimentalTime
    public void onTabChanged(boolean guildTab, @Nullable IGuildUnreadCntService.b tabUnreadCntInfo) {
        if (guildTab) {
            yr1.a aVar = yr1.a.f451054d;
        }
        GuildDebugUtils guildDebugUtils = GuildDebugUtils.f235333a;
        Lazy<String> message = message("onTabChanged(" + guildTab + ", " + tabUnreadCntInfo + ", " + Duration.m1875toStringimpl(this.memoryReleaseInterval) + ")");
        Logger logger = Logger.f235387a;
        if (QLog.isColorLevel()) {
            logger.d().d("GUILD_DEBUG", 2, ((Object) message.getValue()) + " begin...");
        }
        TraceUtils.h(message.getValue());
        this.activeStatus.c(guildTab);
        this.mHandler.removeCallbacks(this.recyclingRunnable);
        if (!guildTab) {
            this.mHandler.postDelayed(this.recyclingRunnable, Duration.m1873toLongMillisecondsimpl(this.memoryReleaseInterval));
        }
        this.delegateFragment.onTabChanged(guildTab, tabUnreadCntInfo);
        Unit unit = Unit.INSTANCE;
        if (QLog.isColorLevel()) {
            logger.d().d("GUILD_DEBUG", 2, ((Object) message.getValue()) + " end...");
        }
        TraceUtils.k();
    }

    @ExperimentalTime
    public final void recycleGuildMainFragment() {
        Logger logger = Logger.f235387a;
        logger.d().d(TAG, 1, "recycleFragmentRunnable run, " + this.activeStatus);
        if (this.activeStatus.getOptionTimestamp() == 0) {
            logger.d().i(TAG, 1, "recycleFragmentRunnable return");
            return;
        }
        if (!this.activeStatus.getIsActive() && this.activeStatus.getOptionTimestamp() + Duration.m1873toLongMillisecondsimpl(this.memoryReleaseInterval) <= SystemClock.uptimeMillis()) {
            logger.d().i(TAG, 1, "recycleFragmentRunnable recycle fragment!");
            FragmentContainerView fragmentContainerView = this.fragmentContainer;
            if (fragmentContainerView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("fragmentContainer");
                fragmentContainerView = null;
            }
            fragmentContainerView.removeAllViews();
            if (!this.mainFragment.isDetached()) {
                removeGuildFragment(this.mainFragment);
            }
            QBaseActivity baseActivity = this.mainFragment.getBaseActivity();
            if (baseActivity != null) {
                LayoutLoaders.f214751a.a(baseActivity);
            }
            this.delegateFragment = new GuildRecycledMainFragment();
            this.currentPageType = 0;
            clearFeedsListCache();
        }
    }

    @Override // com.tencent.mobileqq.guild.mainframe.u
    public void restoreGuildTabFragment() {
        FragmentContainerView fragmentContainerView = this.fragmentContainer;
        if (fragmentContainerView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("fragmentContainer");
            fragmentContainerView = null;
        }
        fragmentContainerView.removeAllViews();
        if (!this.mainFragment.isDetached()) {
            removeGuildFragment(this.mainFragment);
        }
        this.delegateFragment = determineGuildTabFragment();
        ensureFragmentViewExist();
        this.delegateFragment.qh();
        Logger.f235387a.d().i(TAG, 1, "restoreGuildTabFragment " + this.delegateFragment);
    }

    @Override // com.tencent.mobileqq.guild.mainframe.s
    public void setTabHeight(int height) {
        this.delegateFragment.setTabHeight(height);
    }

    @ExperimentalTime
    /* renamed from: getMemoryReleaseInterval-UwyO8pc$annotations, reason: not valid java name */
    private static /* synthetic */ void m190getMemoryReleaseIntervalUwyO8pc$annotations() {
    }

    @ExperimentalTime
    private static /* synthetic */ void getRecyclingRunnable$annotations() {
    }
}

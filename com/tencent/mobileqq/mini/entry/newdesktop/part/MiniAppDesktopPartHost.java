package com.tencent.mobileqq.mini.entry.newdesktop.part;

import android.app.Activity;
import android.app.Application;
import android.content.res.Configuration;
import android.os.Bundle;
import android.os.Looper;
import android.os.SystemClock;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Argus;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStoreOwner;
import com.tencent.ams.dsdk.core.hippy.DKHippyEvent;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.biz.richframework.PartLifecycleHost;
import com.tencent.biz.richframework.delegate.impl.RFWApplication;
import com.tencent.biz.richframework.part.Part;
import com.tencent.biz.richframework.part.interfaces.IContextOwner;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.miniaio.MiniChatConstants;
import com.tencent.mobileqq.activity.recent.DrawerFrame;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.mini.apkg.MiniAppInfo;
import com.tencent.mobileqq.mini.entry.IRefreshOperator;
import com.tencent.mobileqq.mini.entry.IRefreshStatusListener;
import com.tencent.mobileqq.mini.entry.MiniAppExposureManager;
import com.tencent.mobileqq.mini.entry.MiniAppPullInterface;
import com.tencent.mobileqq.mini.entry.MiniAppUtils;
import com.tencent.mobileqq.mini.entry.desktop.DesktopChangeListener;
import com.tencent.mobileqq.mini.entry.desktop.GetAppListV2Scene;
import com.tencent.mobileqq.mini.entry.desktop.IMiniAppDesktopChangeApi;
import com.tencent.mobileqq.mini.entry.desktop.item.DesktopAppInfo;
import com.tencent.mobileqq.mini.entry.desktop.item.DesktopItemInfo;
import com.tencent.mobileqq.mini.entry.desktop.item.MiniDesktopDataPullStep;
import com.tencent.mobileqq.mini.entry.newdesktop.argus.MiniAppNodeCreator;
import com.tencent.mobileqq.mini.entry.newdesktop.mvi.MiniAppDeskTopIntent;
import com.tencent.mobileqq.mini.entry.newdesktop.mvi.MiniAppDeskTopUIState;
import com.tencent.mobileqq.mini.entry.newdesktop.mvi.MiniAppDeskTopViewModel;
import com.tencent.mobileqq.mini.entry.newdesktop.part.MiniAppDesktopPartHost;
import com.tencent.mobileqq.mini.entry.util.MiniAppDesktopPullAnimateUtil;
import com.tencent.mobileqq.mini.report.MiniProgramLpReportDC04239;
import com.tencent.mobileqq.mini.report.MiniProgramReportHelper;
import com.tencent.mobileqq.mini.reuse.MiniAppTransferModule;
import com.tencent.mobileqq.minigame.api.IMiniGameVAManager;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.studymode.StudyModeChangeListener;
import com.tencent.mobileqq.studymode.StudyModeManager;
import com.tencent.qphone.base.util.QLog;
import com.tencent.richframework.argus.node.ArgusTag;
import common.config.service.QzoneConfig;
import eipc.EIPCModule;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.DebugKt;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.manager.Manager;
import mqq.observer.BusinessObserver;

@ArgusTag(tags = {"AUTO_PRELOAD"})
@Metadata(d1 = {"\u0000\u00ca\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0007\u0018\u0000 n2\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u0004:\u0002noB\u0015\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u00a2\u0006\u0002\u0010\tJ\u0012\u0010&\u001a\u00020'2\b\u0010(\u001a\u0004\u0018\u00010\rH\u0016J\u000e\u0010)\u001a\b\u0012\u0004\u0012\u00020\"0\fH\u0016J\u0010\u0010*\u001a\u00020'2\u0006\u0010+\u001a\u00020\u0011H\u0002J\u0010\u0010,\u001a\u00020-2\u0006\u0010.\u001a\u00020\u001eH\u0002J\u000e\u0010/\u001a\b\u0012\u0004\u0012\u00020\r0\fH\u0016J\u001a\u00100\u001a\u0004\u0018\u0001012\u0006\u00102\u001a\u00020\u001e2\u0006\u00103\u001a\u00020-H\u0016J\n\u00104\u001a\u0004\u0018\u000105H\u0016J\u0006\u00106\u001a\u00020\u0011J\b\u00107\u001a\u0004\u0018\u00010\u0016J9\u00108\u001a\u0002H9\"\n\b\u0000\u00109*\u0004\u0018\u00010:2\u0006\u0010;\u001a\u00020<2\b\u0010=\u001a\u0004\u0018\u00010-2\f\u0010>\u001a\b\u0012\u0004\u0012\u0002H90?H\u0016\u00a2\u0006\u0002\u0010@J3\u00108\u001a\u0004\u0018\u0001H9\"\n\b\u0000\u00109*\u0004\u0018\u00010:2\b\u0010=\u001a\u0004\u0018\u00010-2\f\u0010>\u001a\b\u0012\u0004\u0012\u0002H90?H\u0016\u00a2\u0006\u0002\u0010AJ\b\u0010B\u001a\u00020CH\u0016J\u0010\u0010D\u001a\u00020'2\u0006\u0010.\u001a\u00020\u001eH\u0016J\u0012\u0010E\u001a\u00020'2\b\u0010F\u001a\u0004\u0018\u00010\u0006H\u0016J\b\u0010G\u001a\u00020'H\u0002J\b\u0010H\u001a\u00020\u0011H\u0002J\u0006\u0010I\u001a\u00020\u0011J\b\u0010J\u001a\u00020'H\u0002J\b\u0010K\u001a\u00020'H\u0016J\b\u0010L\u001a\u00020\u0011H\u0016J\u0010\u0010M\u001a\u00020'2\u0006\u0010N\u001a\u00020OH\u0016J\b\u0010P\u001a\u00020'H\u0002J\b\u0010Q\u001a\u00020'H\u0016J\u0010\u0010R\u001a\u00020'2\u0006\u0010S\u001a\u00020TH\u0016J\b\u0010U\u001a\u00020'H\u0016J\b\u0010V\u001a\u00020'H\u0016J\"\u0010W\u001a\u00020'2\u0006\u0010X\u001a\u00020\u001e2\u0006\u0010Y\u001a\u00020\u00112\b\u0010Z\u001a\u0004\u0018\u00010[H\u0016J\b\u0010\\\u001a\u00020'H\u0016J\b\u0010]\u001a\u00020'H\u0016J\b\u0010^\u001a\u00020'H\u0002J\u0012\u0010_\u001a\u00020'2\b\u0010(\u001a\u0004\u0018\u00010\rH\u0016J\b\u0010`\u001a\u00020'H\u0002J\u0010\u0010a\u001a\u00020'2\u0006\u0010b\u001a\u00020cH\u0002J\b\u0010d\u001a\u00020'H\u0016J\"\u0010e\u001a\u00020'2\b\u0010f\u001a\u0004\u0018\u00010-2\u0006\u0010g\u001a\u00020[2\u0006\u0010h\u001a\u00020iH\u0016J\u000e\u0010j\u001a\u00020'2\u0006\u0010k\u001a\u00020\u0011J\b\u0010l\u001a\u00020'H\u0002J\b\u0010m\u001a\u00020'H\u0002R\u000e\u0010\n\u001a\u00020\bX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\fX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0011X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0011X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0011X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u0016X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001b\u0010\u0017\u001a\u00020\u00188FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u0019\u0010\u001aR\u000e\u0010\u001d\u001a\u00020\u001eX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020 X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0014\u0010!\u001a\b\u0012\u0004\u0012\u00020\"0\fX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010#\u001a\u00020\u0006X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010$\u001a\u0004\u0018\u00010%X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006p"}, d2 = {"Lcom/tencent/mobileqq/mini/entry/newdesktop/part/MiniAppDesktopPartHost;", "Lcom/tencent/biz/richframework/PartLifecycleHost;", "Lcom/tencent/mobileqq/mini/entry/MiniAppPullInterface;", "Lmqq/observer/BusinessObserver;", "Lcom/tencent/mobileqq/mini/entry/desktop/IMiniAppDesktopChangeApi;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "Landroid/view/ViewGroup;", "refreshOperator", "Lcom/tencent/mobileqq/mini/entry/IRefreshOperator;", "(Landroid/view/ViewGroup;Lcom/tencent/mobileqq/mini/entry/IRefreshOperator;)V", "mConversationOperator", "mDesktopChangeListeners", "", "Lcom/tencent/mobileqq/mini/entry/desktop/DesktopChangeListener;", "mDrawer", "Lcom/tencent/mobileqq/activity/recent/DrawerFrame;", "mIsDesktopOpened", "", "mIsMiniAppDesktopForeground", "mIsMiniAppDesktopInit", "mIsNeedSearchKeyReport", "mMiniAppDesktopRootView", "Landroid/view/View;", "mMiniAppDesktopViewModel", "Lcom/tencent/mobileqq/mini/entry/newdesktop/mvi/MiniAppDeskTopViewModel;", "getMMiniAppDesktopViewModel", "()Lcom/tencent/mobileqq/mini/entry/newdesktop/mvi/MiniAppDeskTopViewModel;", "mMiniAppDesktopViewModel$delegate", "Lkotlin/Lazy;", "mMiniAppOpenedCount", "", "mOpenMiniAppDesktopTime", "", "mPartList", "Lcom/tencent/biz/richframework/part/Part;", "mRootView", "mStudyModelListener", "Lcom/tencent/mobileqq/mini/entry/newdesktop/part/MiniAppDesktopPartHost$MiniAppDesktopStudyModeListener;", "addDesktopChangeListener", "", "listener", "assembleParts", "exposureReport", "needClear", "getCloseDesktopReserves", "", "closedType", "getDesktopChangeListeners", "getMiniAppInfoByDesktopInfoMap", "Lcom/tencent/mobileqq/mini/entry/desktop/item/DesktopItemInfo;", "dataModule", "appId", "getMiniRefreshStatusListener", "Lcom/tencent/mobileqq/mini/entry/IRefreshStatusListener;", "getNeedSearchKeyReport", "getTabHostDivider", "getViewModel", "T", "Landroidx/lifecycle/ViewModel;", "partHost", "Landroidx/lifecycle/ViewModelStoreOwner;", "keyPrefix", "viewModelClass", "Ljava/lang/Class;", "(Landroidx/lifecycle/ViewModelStoreOwner;Ljava/lang/String;Ljava/lang/Class;)Landroidx/lifecycle/ViewModel;", "(Ljava/lang/String;Ljava/lang/Class;)Landroidx/lifecycle/ViewModel;", "getViewTagData", "", "hideMiniAppEntry", "initLater", "drawerFrame", "initPartHostUI", "isMiniAppDesktopInit", "isOpenDesktop", "miniAppDesktopOpen", "onAccountChanged", "onBackPressed", "onConfigurationChanged", "newConfig", "Landroid/content/res/Configuration;", "onDesktopOpened", MosaicConstants$JsFunction.FUNC_ON_DESTROY, "onHeaderShowProgress", "percent", "", "onLowMemory", "onPostThemeChanged", "onReceive", "type", "isSuccess", "bundle", "Landroid/os/Bundle;", "onResume", DKHippyEvent.EVENT_STOP, "registerAppInterfaceEvent", "removeDesktopChangeListener", "removeMiniAppDesktopView", "sendPartUiEvent", "miniAppDeskTopIntent", "Lcom/tencent/mobileqq/mini/entry/newdesktop/mvi/MiniAppDeskTopIntent;", "sendStartUpMiniAppDesktopInfo", "setMiniAppTransferModuleEvent", "action", "params", "eipcModule", "Leipc/EIPCModule;", "setNeedSearchKeyReport", "isNeedSearchKeyReport", "unregisterAppInterfaceEvent", "updatePageArgus", "Companion", "MiniAppDesktopStudyModeListener", "qqmini_impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes33.dex */
public final class MiniAppDesktopPartHost extends PartLifecycleHost implements MiniAppPullInterface, BusinessObserver, IMiniAppDesktopChangeApi {
    private IRefreshOperator mConversationOperator;
    private List<DesktopChangeListener> mDesktopChangeListeners;
    private DrawerFrame mDrawer;
    private volatile boolean mIsDesktopOpened;
    private boolean mIsMiniAppDesktopForeground;
    private volatile boolean mIsMiniAppDesktopInit;
    private boolean mIsNeedSearchKeyReport;
    private View mMiniAppDesktopRootView;

    /* renamed from: mMiniAppDesktopViewModel$delegate, reason: from kotlin metadata */
    private final Lazy mMiniAppDesktopViewModel;
    private int mMiniAppOpenedCount;
    private long mOpenMiniAppDesktopTime;
    private List<Part> mPartList;
    private ViewGroup mRootView;
    private MiniAppDesktopStudyModeListener mStudyModelListener;

    /* JADX INFO: Access modifiers changed from: private */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\b\u0002\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016R\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00030\u0006X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u000b"}, d2 = {"Lcom/tencent/mobileqq/mini/entry/newdesktop/part/MiniAppDesktopPartHost$MiniAppDesktopStudyModeListener;", "Lcom/tencent/mobileqq/studymode/StudyModeChangeListener;", "desktopPartHost", "Lcom/tencent/mobileqq/mini/entry/newdesktop/part/MiniAppDesktopPartHost;", "(Lcom/tencent/mobileqq/mini/entry/newdesktop/part/MiniAppDesktopPartHost;)V", "partHostRef", "Ljava/lang/ref/WeakReference;", "onChange", "", "isStudyMode", "", "qqmini_impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes33.dex */
    public static final class MiniAppDesktopStudyModeListener implements StudyModeChangeListener {
        private WeakReference<MiniAppDesktopPartHost> partHostRef;

        public MiniAppDesktopStudyModeListener(MiniAppDesktopPartHost desktopPartHost) {
            Intrinsics.checkNotNullParameter(desktopPartHost, "desktopPartHost");
            this.partHostRef = new WeakReference<>(desktopPartHost);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void onChange$lambda$1(MiniAppDesktopStudyModeListener this$0, boolean z16) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            MiniAppDesktopPartHost miniAppDesktopPartHost = this$0.partHostRef.get();
            Intrinsics.checkNotNull(miniAppDesktopPartHost);
            for (Part part : miniAppDesktopPartHost.mPartList) {
                if (part instanceof MiniAppDesktopAbstractPart) {
                    ((MiniAppDesktopAbstractPart) part).studyModeChange(z16);
                }
            }
        }

        @Override // com.tencent.mobileqq.studymode.StudyModeChangeListener
        public void onChange(final boolean isStudyMode) {
            if (this.partHostRef.get() == null) {
                QLog.e("MiniAppDesktopPartHost", 1, "MiniAppDesktopStudyModeListener onChange partHostRef is null\uff0cisStudyMode:" + isStudyMode);
                return;
            }
            if (QLog.isColorLevel()) {
                MiniAppDesktopPartHost miniAppDesktopPartHost = this.partHostRef.get();
                Intrinsics.checkNotNull(miniAppDesktopPartHost);
                QLog.i(miniAppDesktopPartHost.getViewTagData().toString(), 1, "StudyModeChangeListener onChange isStudyMode:" + isStudyMode);
            }
            ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.mobileqq.mini.entry.newdesktop.part.k
                @Override // java.lang.Runnable
                public final void run() {
                    MiniAppDesktopPartHost.MiniAppDesktopStudyModeListener.onChange$lambda$1(MiniAppDesktopPartHost.MiniAppDesktopStudyModeListener.this, isStudyMode);
                }
            });
        }
    }

    static {
        Argus.INSTANCE.addBlockCreator(new MiniAppNodeCreator());
    }

    public MiniAppDesktopPartHost(ViewGroup rootView, IRefreshOperator refreshOperator) {
        Lazy lazy;
        Intrinsics.checkNotNullParameter(rootView, "rootView");
        Intrinsics.checkNotNullParameter(refreshOperator, "refreshOperator");
        this.mPartList = new ArrayList();
        this.mDesktopChangeListeners = new ArrayList();
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<MiniAppDeskTopViewModel>() { // from class: com.tencent.mobileqq.mini.entry.newdesktop.part.MiniAppDesktopPartHost$mMiniAppDesktopViewModel$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final MiniAppDeskTopViewModel invoke() {
                ViewModel viewModel = new ViewModelProvider(MiniAppDesktopPartHost.this).get(MiniAppDeskTopViewModel.class);
                Intrinsics.checkNotNullExpressionValue(viewModel, "ViewModelProvider(this).\u2026TopViewModel::class.java)");
                MiniAppDeskTopViewModel miniAppDeskTopViewModel = (MiniAppDeskTopViewModel) viewModel;
                Activity hostActivity = MiniAppDesktopPartHost.this.getHostActivity();
                miniAppDeskTopViewModel.setContextHashCode(hostActivity != null ? hostActivity.hashCode() : 0);
                QLog.i(MiniAppDesktopPartHost.this.getViewTagData().toString(), 1, "mMiniAppDesktopViewModel=" + miniAppDeskTopViewModel);
                return miniAppDeskTopViewModel;
            }
        });
        this.mMiniAppDesktopViewModel = lazy;
        this.mConversationOperator = refreshOperator;
        this.mRootView = rootView;
        initPartHostUI();
    }

    private final void exposureReport(boolean needClear) {
        Manager manager = MobileQQ.sMobileQQ.peekAppRuntime().getManager(QQManagerFactory.MINI_APP_EXPOSURE_MANAGER);
        Intrinsics.checkNotNull(manager, "null cannot be cast to non-null type com.tencent.mobileqq.mini.entry.MiniAppExposureManager");
        ((MiniAppExposureManager) manager).submitDuplicateItemMapReportData(needClear);
        QLog.d(getViewTagData().toString(), 1, "exposureReport needClear:" + needClear);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean initLater$lambda$4(View view, MotionEvent motionEvent) {
        return false;
    }

    private final void initPartHostUI() {
        if (QLog.isColorLevel()) {
            QLog.i(getViewTagData().toString(), 1, "initPartHostUI, container:" + this.mRootView);
        }
        View inflate = LayoutInflater.from(this.mRootView.getContext()).inflate(R.layout.die, (ViewGroup) null);
        this.mMiniAppDesktopRootView = inflate;
        this.mRootView.addView(inflate, new ViewGroup.LayoutParams(-1, -1));
        View view = this.mMiniAppDesktopRootView;
        if (view != null) {
            Argus.INSTANCE.getNode(view, this, true);
            init(view);
        }
        registerAppInterfaceEvent();
        MiniAppDesktopStudyModeListener miniAppDesktopStudyModeListener = new MiniAppDesktopStudyModeListener(this);
        this.mStudyModelListener = miniAppDesktopStudyModeListener;
        StudyModeManager.H(miniAppDesktopStudyModeListener);
        MiniDesktopDataPullStep.setMiniDesktopMiniViewCreated();
        this.mIsMiniAppDesktopInit = true;
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.mini.entry.newdesktop.part.g
            @Override // java.lang.Runnable
            public final void run() {
                MiniProgramReportHelper.miniAppConfigForPreload();
            }
        }, 16, null, true);
    }

    private final boolean isMiniAppDesktopInit() {
        return this.mIsMiniAppDesktopInit && getHasInit();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void miniAppDesktopOpen() {
        if (QLog.isColorLevel()) {
            QLog.i(getViewTagData().toString(), 2, "animateOpen");
        }
        if (!MiniAppUtils.isConversationTab()) {
            hideMiniAppEntry(-1);
            return;
        }
        this.mIsDesktopOpened = true;
        if (QzoneConfig.getInstance().getConfig("qqminiapp", QzoneConfig.SECONDARY_KEY_CLEAR_DESKTOP_EXPOSURE_REPORT_DATA, 0) == 0) {
            Manager manager = MobileQQ.sMobileQQ.peekAppRuntime().getManager(QQManagerFactory.MINI_APP_EXPOSURE_MANAGER);
            Intrinsics.checkNotNull(manager, "null cannot be cast to non-null type com.tencent.mobileqq.mini.entry.MiniAppExposureManager");
            ((MiniAppExposureManager) manager).clear();
        }
        this.mOpenMiniAppDesktopTime = SystemClock.uptimeMillis();
        updatePageArgus();
        try {
            getMMiniAppDesktopViewModel().setUserAccountFirstOpenDesktop(true);
            getMMiniAppDesktopViewModel().setStartAppDesktopFirstOpen(true);
            getMMiniAppDesktopViewModel().setDesktopOpen(true);
            this.mIsNeedSearchKeyReport = true;
            MiniProgramLpReportDC04239.reportAsync("desktop", "pulldown", null, null);
            Iterator<T> it = this.mDesktopChangeListeners.iterator();
            while (it.hasNext()) {
                ((DesktopChangeListener) it.next()).onStartDesktopOpenAnimation();
            }
        } catch (Exception e16) {
            this.mIsDesktopOpened = false;
            this.mConversationOperator.close();
            QLog.e(getViewTagData().toString(), 1, "miniAppDesktopOpen error, hasInit:" + getHasInit(), e16);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onAccountChanged$lambda$2(MiniAppDesktopPartHost this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (QLog.isColorLevel()) {
            QLog.i(this$0.getViewTagData().toString(), 1, "onAccountChanged isTeenagerMode:" + MiniAppUtils.isTeenagerMode());
        }
        if (!this$0.isMiniAppDesktopInit()) {
            QLog.i(this$0.getViewTagData().toString(), 1, "onAccountChanged MiniAppDesktop is not init!");
            return;
        }
        try {
            this$0.getMMiniAppDesktopViewModel().setAccountChange(true);
            this$0.getMMiniAppDesktopViewModel().setUserAccountFirstOpenDesktop(false);
            this$0.getMMiniAppDesktopViewModel().initLocalDataState();
            this$0.getMMiniAppDesktopViewModel().obtainUiState().setValue(MiniAppDeskTopUIState.OnAccountChanged.INSTANCE);
            if (this$0.mIsDesktopOpened) {
                this$0.hideMiniAppEntry(-1);
            }
        } catch (Exception e16) {
            QLog.e(this$0.getViewTagData().toString(), 1, "onAccountChanged error, hasInit:" + this$0.getHasInit(), e16);
        }
    }

    private final void onDesktopOpened() {
        Iterator<T> it = this.mDesktopChangeListeners.iterator();
        while (it.hasNext()) {
            ((DesktopChangeListener) it.next()).onDesktopOpened();
        }
        ((IMiniGameVAManager) QRoute.api(IMiniGameVAManager.class)).checkYunGameReady(true);
    }

    private final void registerAppInterfaceEvent() {
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime == null) {
            return;
        }
        peekAppRuntime.registObserver(this);
        peekAppRuntime.addDirectNotifyObserver(MiniAppDesktopPartHost.class, 100);
    }

    private final void removeMiniAppDesktopView() {
        View view = this.mMiniAppDesktopRootView;
        if (view == null) {
            QLog.e(getViewTagData().toString(), 1, "mMiniAppDesktopRootView is null!");
        } else {
            this.mRootView.removeView(view);
        }
    }

    private final void sendPartUiEvent(MiniAppDeskTopIntent miniAppDeskTopIntent) {
        if (isMiniAppDesktopInit()) {
            try {
                BuildersKt__Builders_commonKt.launch$default(LifecycleOwnerKt.getLifecycleScope(getLifecycleOwner()), null, null, new MiniAppDesktopPartHost$sendPartUiEvent$1(this, miniAppDeskTopIntent, null), 3, null);
                return;
            } catch (Exception e16) {
                QLog.e(getViewTagData().toString(), 1, "sendPartUiEvent error, hasInit:" + getHasInit(), e16);
                return;
            }
        }
        QLog.i(getViewTagData().toString(), 1, "sendPartUiEvent MiniAppDesktop is not init!");
    }

    private final void unregisterAppInterfaceEvent() {
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime == null) {
            return;
        }
        peekAppRuntime.unRegistObserver(this);
        peekAppRuntime.removeDirectNotifyObserver(MiniAppDesktopPartHost.class, 100);
    }

    private final void updatePageArgus() {
        if (Intrinsics.areEqual(Looper.getMainLooper(), Looper.myLooper())) {
            View view = this.mMiniAppDesktopRootView;
            if (view != null) {
                Argus.INSTANCE.updatePage(view);
                return;
            }
            return;
        }
        ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.mobileqq.mini.entry.newdesktop.part.h
            @Override // java.lang.Runnable
            public final void run() {
                MiniAppDesktopPartHost.updatePageArgus$lambda$10(MiniAppDesktopPartHost.this);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void updatePageArgus$lambda$10(MiniAppDesktopPartHost this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        View view = this$0.mMiniAppDesktopRootView;
        if (view != null) {
            Argus.INSTANCE.updatePage(view);
        }
    }

    @Override // com.tencent.biz.richframework.part.interfaces.IPartHost
    public List<Part> assembleParts() {
        List<Part> mutableListOf;
        QLog.i(getViewTagData().toString(), 1, "assembleParts");
        mutableListOf = CollectionsKt__CollectionsKt.mutableListOf(new MiniAppDesktopTitlePart(), new MiniAppDesktopRvPart(), new MiniAppDesktopBottomPart(), new MiniAppDesktopSubLayoutPart());
        this.mPartList = mutableListOf;
        return mutableListOf;
    }

    @Override // com.tencent.mobileqq.mini.entry.MiniAppPullInterface
    public List<DesktopChangeListener> getDesktopChangeListeners() {
        return this.mDesktopChangeListeners;
    }

    public final MiniAppDeskTopViewModel getMMiniAppDesktopViewModel() {
        return (MiniAppDeskTopViewModel) this.mMiniAppDesktopViewModel.getValue();
    }

    @Override // com.tencent.mobileqq.mini.entry.MiniAppPullInterface
    public DesktopItemInfo getMiniAppInfoByDesktopInfoMap(int dataModule, String appId) {
        Intrinsics.checkNotNullParameter(appId, "appId");
        if (!isMiniAppDesktopInit()) {
            QLog.i(getViewTagData().toString(), 1, "getMiniAppInfoByDesktopInfoMap MiniAppDesktop is not init!");
            return null;
        }
        MiniAppInfo miniAppInfoByDesktopDataInfoMap = getMMiniAppDesktopViewModel().getMiniAppInfoByDesktopDataInfoMap(dataModule, appId, 3);
        if (miniAppInfoByDesktopDataInfoMap != null) {
            return new DesktopAppInfo(dataModule, miniAppInfoByDesktopDataInfoMap);
        }
        return null;
    }

    @Override // com.tencent.mobileqq.mini.entry.MiniAppPullInterface
    public IRefreshStatusListener getMiniRefreshStatusListener() {
        return new MiniAppDesktopPartHost$getMiniRefreshStatusListener$1(this);
    }

    /* renamed from: getNeedSearchKeyReport, reason: from getter */
    public final boolean getMIsNeedSearchKeyReport() {
        return this.mIsNeedSearchKeyReport;
    }

    public final View getTabHostDivider() {
        DrawerFrame drawerFrame = this.mDrawer;
        if (drawerFrame != null) {
            return drawerFrame.findViewById(R.id.f916655s);
        }
        return null;
    }

    public /* bridge */ /* synthetic */ ViewModel getViewModel(Class cls) {
        return ne0.a.b(this, cls);
    }

    @Override // com.tencent.biz.richframework.PartLifecycleHost, com.tencent.biz.richframework.part.interfaces.IPartHost
    public Object getViewTagData() {
        return "MiniAppDesktopPart.MiniAppDesktopPartHost";
    }

    @Override // com.tencent.mobileqq.mini.entry.MiniAppPullInterface
    public void hideMiniAppEntry(int closedType) {
        QLog.i(getViewTagData().toString(), 1, "hideMiniAppEntry closedType\uff1a" + closedType);
        if (!this.mIsDesktopOpened) {
            QLog.i(getViewTagData().toString(), 1, "isOpenDesktop is false!");
            return;
        }
        this.mIsDesktopOpened = false;
        getMMiniAppDesktopViewModel().setDesktopOpen(false);
        this.mConversationOperator.close();
        getMMiniAppDesktopViewModel().obtainUiState().setValue(MiniAppDeskTopUIState.CloseMiniAppSubPage.INSTANCE);
        getMMiniAppDesktopViewModel().obtainUiState().setValue(MiniAppDeskTopUIState.MiniAppDesktopClose.INSTANCE);
        updatePageArgus();
        Iterator<T> it = this.mDesktopChangeListeners.iterator();
        while (it.hasNext()) {
            ((DesktopChangeListener) it.next()).onDesktopClosed();
        }
        String closeDesktopReserves = getCloseDesktopReserves(closedType);
        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
        String format = String.format("%.2f", Arrays.copyOf(new Object[]{Float.valueOf(((float) (SystemClock.uptimeMillis() - this.mOpenMiniAppDesktopTime)) / 1000.0f)}, 1));
        Intrinsics.checkNotNullExpressionValue(format, "format(format, *args)");
        MiniProgramLpReportDC04239.reportAsync("desktop", DebugKt.DEBUG_PROPERTY_VALUE_OFF, closeDesktopReserves, format, String.valueOf(this.mMiniAppOpenedCount), (String) null);
        exposureReport(true);
        this.mMiniAppOpenedCount = 0;
        this.mOpenMiniAppDesktopTime = 0L;
    }

    @Override // com.tencent.mobileqq.mini.entry.MiniAppPullInterface
    public void initLater(ViewGroup drawerFrame) {
        if (QLog.isColorLevel()) {
            QLog.i(getViewTagData().toString(), 1, "initLater");
        }
        if (drawerFrame instanceof DrawerFrame) {
            DrawerFrame drawerFrame2 = (DrawerFrame) drawerFrame;
            this.mDrawer = drawerFrame2;
            if (drawerFrame2 != null) {
                drawerFrame2.setMiniAppTouchEventInterceptor(com.tencent.mobileqq.activity.home.impl.a.f183038a, new DrawerFrame.e() { // from class: com.tencent.mobileqq.mini.entry.newdesktop.part.i
                    @Override // com.tencent.mobileqq.activity.recent.DrawerFrame.e
                    public final boolean interceptDrawer(View view, MotionEvent motionEvent) {
                        boolean initLater$lambda$4;
                        initLater$lambda$4 = MiniAppDesktopPartHost.initLater$lambda$4(view, motionEvent);
                        return initLater$lambda$4;
                    }
                });
            }
        }
    }

    /* renamed from: isOpenDesktop, reason: from getter */
    public final boolean getMIsDesktopOpened() {
        return this.mIsDesktopOpened;
    }

    @Override // com.tencent.mobileqq.mini.entry.MiniAppPullInterface
    public void onAccountChanged() {
        ThreadManagerV2.getUIHandlerV2().postDelayed(new Runnable() { // from class: com.tencent.mobileqq.mini.entry.newdesktop.part.j
            @Override // java.lang.Runnable
            public final void run() {
                MiniAppDesktopPartHost.onAccountChanged$lambda$2(MiniAppDesktopPartHost.this);
            }
        }, 1000L);
    }

    @Override // com.tencent.mobileqq.mini.entry.MiniAppPullInterface
    public boolean onBackPressed() {
        QLog.i(getViewTagData().toString(), 1, "onBackPressed");
        if (!this.mIsDesktopOpened) {
            return false;
        }
        for (Part part : this.mPartList) {
            if ((part instanceof MiniAppDesktopSubLayoutPart) && ((MiniAppDesktopSubLayoutPart) part).onBackPressed()) {
                return true;
            }
        }
        hideMiniAppEntry(0);
        return true;
    }

    @Override // com.tencent.biz.richframework.PartLifecycleHost, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration newConfig) {
        Intrinsics.checkNotNullParameter(newConfig, "newConfig");
        super.onConfigurationChanged(newConfig);
        QLog.i(getViewTagData().toString(), 1, "onConfigurationChanged:" + newConfig);
        if (!isMiniAppDesktopInit()) {
            QLog.i(getViewTagData().toString(), 1, "onConfigurationChanged MiniAppDesktop is not init!");
        } else {
            if (this.mIsDesktopOpened) {
                return;
            }
            QLog.i(getViewTagData().toString(), 1, "desktop is not open!");
        }
    }

    @Override // com.tencent.mobileqq.mini.entry.MiniAppPullInterface
    public void onDestroy() {
        if (QLog.isColorLevel()) {
            QLog.i(getViewTagData().toString(), 1, MosaicConstants$JsFunction.FUNC_ON_DESTROY);
        }
        Iterator<T> it = this.mDesktopChangeListeners.iterator();
        while (it.hasNext()) {
            ((DesktopChangeListener) it.next()).onDesktopDestroy();
        }
        MiniAppDesktopStudyModeListener miniAppDesktopStudyModeListener = this.mStudyModelListener;
        if (miniAppDesktopStudyModeListener != null) {
            StudyModeManager.U(miniAppDesktopStudyModeListener);
            this.mStudyModelListener = null;
        }
        removeMiniAppDesktopView();
        unregisterAppInterfaceEvent();
        Application application = RFWApplication.getApplication();
        Application application2 = application instanceof Application ? application : null;
        if (application2 != null) {
            application2.unregisterComponentCallbacks(this);
        }
    }

    @Override // com.tencent.mobileqq.mini.entry.MiniAppPullInterface
    public void onHeaderShowProgress(float percent) {
        if (isMiniAppDesktopInit()) {
            try {
                MiniAppDesktopPullAnimateUtil.setMiniAppDesktopAnimate(this.mMiniAppDesktopRootView, percent);
                if ((percent == 0.0f) && this.mIsDesktopOpened) {
                    QLog.d(getViewTagData().toString(), 1, "onHeaderShowProgress sliding sethideMiniAppEntry!");
                    hideMiniAppEntry(-1);
                } else {
                    if (percent == 1.0f) {
                        QLog.d(getViewTagData().toString(), 1, "onHeaderShowProgress opened!");
                        onDesktopOpened();
                    }
                }
            } catch (Exception e16) {
                QLog.e(getViewTagData().toString(), 1, "onHeaderShowProgress error, hasInit:" + getHasInit(), e16);
            }
        }
    }

    @Override // android.content.ComponentCallbacks
    public void onLowMemory() {
        QLog.i(getViewTagData().toString(), 1, "onLowMemory");
    }

    @Override // com.tencent.biz.richframework.PartLifecycleHost, com.tencent.biz.richframework.part.interfaces.IPartHost
    @Deprecated
    public /* bridge */ /* synthetic */ void onPartTimeCostReport(String str, String str2, long j3) {
        ne0.a.e(this, str, str2, j3);
    }

    @Override // com.tencent.mobileqq.mini.entry.MiniAppPullInterface
    public void onPostThemeChanged() {
        if (!isMiniAppDesktopInit()) {
            QLog.i(getViewTagData().toString(), 1, "onPostThemeChanged MiniAppDesktop is not init!");
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.i(getViewTagData().toString(), 1, "onPostThemeChanged");
        }
        try {
            getMMiniAppDesktopViewModel().obtainUiState().setValue(MiniAppDeskTopUIState.OnPostThemeChanged.INSTANCE);
        } catch (Exception e16) {
            QLog.e(getViewTagData().toString(), 1, "onPostThemeChanged error, hasInit:" + getHasInit(), e16);
        }
    }

    @Override // mqq.observer.BusinessObserver
    public void onReceive(int type, boolean isSuccess, Bundle bundle) {
        QLog.d(getViewTagData().toString(), 1, "onReceive, type = " + type);
        if (type == 100) {
            hideMiniAppEntry(-1);
            return;
        }
        if (type != 102) {
            if (type != 104) {
                return;
            }
            this.mMiniAppOpenedCount++;
        } else if (bundle != null) {
            getMMiniAppDesktopViewModel().obtainUiState().postValue(new MiniAppDeskTopUIState.OnChangeRedDotSwitch(bundle));
        }
    }

    @Override // com.tencent.mobileqq.mini.entry.MiniAppPullInterface
    public void onResume() {
        if (QLog.isColorLevel()) {
            QLog.i(getViewTagData().toString(), 1, "onResume");
        }
        Iterator<T> it = this.mDesktopChangeListeners.iterator();
        while (it.hasNext()) {
            ((DesktopChangeListener) it.next()).onDesktopResume();
        }
        this.mIsMiniAppDesktopForeground = true;
    }

    @Override // com.tencent.mobileqq.mini.entry.MiniAppPullInterface
    public void onStop() {
        if (QLog.isColorLevel()) {
            QLog.i(getViewTagData().toString(), 1, DKHippyEvent.EVENT_STOP);
        }
        boolean z16 = QzoneConfig.getInstance().getConfig("qqminiapp", QzoneConfig.SECONDARY_KEY_DESKTOP_EXPOSURE_REPORT_ON_STOP, 0) == 0;
        if (this.mIsDesktopOpened && z16) {
            exposureReport(false);
        }
        this.mIsMiniAppDesktopForeground = false;
        this.mOpenMiniAppDesktopTime = 0L;
    }

    @Override // com.tencent.mobileqq.mini.entry.MiniAppPullInterface
    public void sendStartUpMiniAppDesktopInfo() {
        QLog.i(getViewTagData().toString(), 1, "sendStartUpMiniAppDesktopInfo!");
        sendPartUiEvent(new MiniAppDeskTopIntent.GetMiniAppDesktopNetworkData(false, GetAppListV2Scene.START_UP));
    }

    @Override // com.tencent.mobileqq.mini.entry.MiniAppPullInterface
    public void setMiniAppTransferModuleEvent(String action, Bundle params, EIPCModule eipcModule) {
        Intrinsics.checkNotNullParameter(params, "params");
        Intrinsics.checkNotNullParameter(eipcModule, "eipcModule");
        if (action != null) {
            switch (action.hashCode()) {
                case -1330740909:
                    if (action.equals(MiniAppTransferModule.ACTION_CHECK_IS_IN_MY_APP_LIST)) {
                        sendPartUiEvent(new MiniAppDeskTopIntent.CheckIsInMyAppList(params, eipcModule));
                        return;
                    }
                    return;
                case 413932364:
                    if (action.equals(MiniAppTransferModule.ACTION_SYNC_MINI_APP_DATA)) {
                        String string = params.getString("appid");
                        int i3 = params.getInt(MiniChatConstants.MINI_APP_TOP_TYPE);
                        int i16 = params.getInt("callbackId");
                        if (string != null && i3 == 0) {
                            sendPartUiEvent(new MiniAppDeskTopIntent.RemoveMyMiniAppTopById(string, i16, eipcModule));
                            return;
                        } else {
                            if (string == null || i3 != 1) {
                                return;
                            }
                            sendPartUiEvent(new MiniAppDeskTopIntent.InsertMyMiniAppToTopById(string, i16, eipcModule));
                            return;
                        }
                    }
                    return;
                case 610127233:
                    if (action.equals(MiniAppTransferModule.ACTION_UPDATE_ENTRY_LIST)) {
                        sendPartUiEvent(new MiniAppDeskTopIntent.GetMiniAppDesktopNetworkData(true, null, 2, null));
                        return;
                    }
                    return;
                case 1541555897:
                    if (action.equals(MiniAppTransferModule.ACTION_QUERY_MINI_APP_DATA)) {
                        sendPartUiEvent(new MiniAppDeskTopIntent.QueryMyMiniAppInfo(params, eipcModule));
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
    }

    public final void setNeedSearchKeyReport(boolean isNeedSearchKeyReport) {
        this.mIsNeedSearchKeyReport = isNeedSearchKeyReport;
    }

    public /* bridge */ /* synthetic */ boolean useArgusLifecycle() {
        return ne0.a.f(this);
    }

    @Override // com.tencent.biz.richframework.PartLifecycleHost, com.tencent.biz.richframework.part.interfaces.IPartHost
    public <T extends ViewModel> T getViewModel(String keyPrefix, Class<T> viewModelClass) {
        Intrinsics.checkNotNullParameter(viewModelClass, "viewModelClass");
        return (T) getViewModel(this, keyPrefix, viewModelClass);
    }

    @Override // com.tencent.mobileqq.mini.entry.desktop.IMiniAppDesktopChangeApi
    public void addDesktopChangeListener(DesktopChangeListener listener) {
        if (listener == null || this.mDesktopChangeListeners.contains(listener)) {
            return;
        }
        this.mDesktopChangeListeners.add(listener);
    }

    @Override // com.tencent.biz.richframework.PartLifecycleHost, com.tencent.biz.richframework.part.interfaces.IPartHost
    public <T extends ViewModel> T getViewModel(ViewModelStoreOwner partHost, String keyPrefix, Class<T> viewModelClass) {
        Intrinsics.checkNotNullParameter(partHost, "partHost");
        Intrinsics.checkNotNullParameter(viewModelClass, "viewModelClass");
        ViewModelProvider viewModelProvider = new ViewModelProvider(partHost);
        String canonicalName = viewModelClass.getCanonicalName();
        if (keyPrefix == null) {
            Objects.requireNonNull(canonicalName);
        } else {
            canonicalName = keyPrefix + canonicalName;
        }
        T t16 = (T) viewModelProvider.get(canonicalName, viewModelClass);
        if (t16 instanceof IContextOwner) {
            IContextOwner iContextOwner = (IContextOwner) t16;
            Activity hostActivity = getHostActivity();
            iContextOwner.setContextHashCode(hostActivity != null ? hostActivity.hashCode() : 0);
        }
        return t16;
    }

    @Override // com.tencent.mobileqq.mini.entry.desktop.IMiniAppDesktopChangeApi
    public void removeDesktopChangeListener(DesktopChangeListener listener) {
        if (listener == null || !this.mDesktopChangeListeners.contains(listener)) {
            return;
        }
        this.mDesktopChangeListeners.remove(listener);
    }

    private final String getCloseDesktopReserves(int closedType) {
        if (closedType == 1) {
            return "off_bottom";
        }
        if (closedType != 2) {
            return "off_system";
        }
        return "off_right";
    }
}

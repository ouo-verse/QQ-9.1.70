package com.tencent.mobileqq.zootopia.ueloading;

import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.Window;
import androidx.exifinterface.media.ExifInterface;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.mobileqq.zootopia.ZootopiaSource;
import com.tencent.mobileqq.zootopia.ZootopiaUEActivity;
import com.tencent.mobileqq.zootopia.data.ZootopiaEnterParams;
import com.tencent.mobileqq.zootopia.download.ZootopiaDownloadManagerIpc;
import com.tencent.mobileqq.zootopia.lua.ar;
import com.tencent.mobileqq.zootopia.ueloading.report.ZPlanUEReportHelper;
import com.tencent.mobileqq.zootopia.ueloading.report.ZPlanUETechReportParams;
import com.tencent.mobileqq.zootopia.view.ZPlanBaseSceneLoadingView;
import com.tencent.mobileqq.zootopia.view.ZootopiaSceneLoadingView;
import com.tencent.mobileqq.zootopia.view.ZootoppiaSceneLoadingViewV2;
import com.tencent.mobileqq.zootopia.view.b;
import com.tencent.mobileqq.zplan.lua.plugins.ZPlanDialogLuaPlugin;
import com.tencent.mobileqq.zplan.scheme.ISchemeApi;
import com.tencent.mobileqq.zplan.smallhome.event.ZPlanUEShowDialogEvent;
import com.tencent.mobileqq.zplan.smallhome.status.ZPlanModLoadStatus;
import com.tencent.mobileqq.zplan.smallhome.status.ZPlanModLoadStatusInfo;
import com.tencent.mobileqq.zplan.smallhome.status.ZPlanModLoadStatusManagerForModProcess;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qphone.base.util.QLog;
import com.tencent.zplan.luabridge.LuaArgument;
import java.util.ArrayList;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;
import ud3.d;

@Metadata(d1 = {"\u0000\u0090\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 Z2\u00020\u00012\u00020\u0002:\u0001[B+\u0012\u0006\u0010-\u001a\u00020(\u0012\u0006\u0010/\u001a\u00020\u0005\u0012\b\u00105\u001a\u0004\u0018\u000101\u0012\b\u0010:\u001a\u0004\u0018\u000106\u00a2\u0006\u0004\bX\u0010YJ\u0018\u0010\b\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0005H\u0002J\b\u0010\t\u001a\u00020\u0007H\u0002J\b\u0010\u000b\u001a\u00020\nH\u0002J\u0010\u0010\u000e\u001a\u00020\u00072\u0006\u0010\r\u001a\u00020\fH\u0002J\b\u0010\u0010\u001a\u00020\u000fH\u0002J\u001a\u0010\u0015\u001a\u00020\u00072\b\u0010\u0012\u001a\u0004\u0018\u00010\u00112\u0006\u0010\u0014\u001a\u00020\u0013H\u0016J\b\u0010\u0016\u001a\u00020\u0007H\u0016J\b\u0010\u0017\u001a\u00020\u0005H\u0016J\b\u0010\u0018\u001a\u00020\u0007H\u0016J\u0010\u0010\u001a\u001a\u00020\u00072\u0006\u0010\u0019\u001a\u00020\u0005H\u0016J\u0010\u0010\u001b\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u0003H\u0016J\b\u0010\u001c\u001a\u00020\u0007H\u0016J\u0010\u0010\u001f\u001a\u00020\u00072\u0006\u0010\u001e\u001a\u00020\u001dH\u0016J\b\u0010 \u001a\u00020\u0007H\u0016J\b\u0010\"\u001a\u00020!H\u0016J\u0016\u0010%\u001a\u00020\u00072\u0006\u0010\u0012\u001a\u00020#2\u0006\u0010$\u001a\u00020\fJ\u0006\u0010&\u001a\u00020\nJ\u0006\u0010'\u001a\u00020\u0007R\u0017\u0010-\u001a\u00020(8\u0006\u00a2\u0006\f\n\u0004\b)\u0010*\u001a\u0004\b+\u0010,R\u0017\u0010/\u001a\u00020\u00058\u0006\u00a2\u0006\f\n\u0004\b%\u0010.\u001a\u0004\b/\u00100R\u0019\u00105\u001a\u0004\u0018\u0001018\u0006\u00a2\u0006\f\n\u0004\b\u0010\u00102\u001a\u0004\b3\u00104R\u0019\u0010:\u001a\u0004\u0018\u0001068\u0006\u00a2\u0006\f\n\u0004\b+\u00107\u001a\u0004\b8\u00109R$\u0010A\u001a\u0004\u0018\u00010;8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u000b\u0010<\u001a\u0004\b=\u0010>\"\u0004\b?\u0010@R\u001b\u0010F\u001a\u00020B8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b8\u0010C\u001a\u0004\bD\u0010ER\u001b\u0010K\u001a\u00020G8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\bH\u0010C\u001a\u0004\bI\u0010JR\u0018\u0010N\u001a\u0004\u0018\u00010\u00118\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bL\u0010MR\u0018\u0010\u0014\u001a\u0004\u0018\u00010\u00138\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bO\u0010PR\u0016\u0010S\u001a\u00020\n8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bQ\u0010RR\u0016\u0010W\u001a\u00020T8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bU\u0010V\u00a8\u0006\\"}, d2 = {"Lcom/tencent/mobileqq/zootopia/ueloading/ZPlanUELoadingController;", "Lud3/d;", "Lcom/tencent/mobileqq/zplan/smallhome/status/a;", "Lcom/tencent/mobileqq/zplan/smallhome/status/ZPlanModLoadStatusInfo;", "statusInfo", "", "isStatusChanged", "", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "r", "", "i", "", NodeProps.VISIBLE, "y", "Lcom/tencent/mobileqq/zootopia/ueloading/report/c;", "f", "Landroid/view/ViewGroup;", "view", "Landroid/view/Window;", "window", HippyTKDListViewAdapter.X, "u", "g", ReportConstant.COSTREPORT_PREFIX, "isRebind", "t", "updateStatus", "ya", "Lcom/tencent/mobileqq/zplan/smallhome/event/ZPlanUEShowDialogEvent;", "event", "Y1", "Ub", "Lud3/b;", "o", "Landroid/view/View;", "index", "e", DomainData.DOMAIN_NAME, MosaicConstants$JsFunction.FUNC_ON_DESTROY, "Lcom/tencent/mobileqq/zootopia/ZootopiaUEActivity;", "d", "Lcom/tencent/mobileqq/zootopia/ZootopiaUEActivity;", tl.h.F, "()Lcom/tencent/mobileqq/zootopia/ZootopiaUEActivity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "Z", "isV2Loading", "()Z", "Lcom/tencent/mobileqq/zootopia/data/ZootopiaEnterParams;", "Lcom/tencent/mobileqq/zootopia/data/ZootopiaEnterParams;", "k", "()Lcom/tencent/mobileqq/zootopia/data/ZootopiaEnterParams;", "enterParams", "Lcom/tencent/mobileqq/zootopia/ZootopiaSource;", "Lcom/tencent/mobileqq/zootopia/ZootopiaSource;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "()Lcom/tencent/mobileqq/zootopia/ZootopiaSource;", "source", "Lcom/tencent/mobileqq/zootopia/view/ZPlanBaseSceneLoadingView;", "Lcom/tencent/mobileqq/zootopia/view/ZPlanBaseSceneLoadingView;", "l", "()Lcom/tencent/mobileqq/zootopia/view/ZPlanBaseSceneLoadingView;", "setLoadingView", "(Lcom/tencent/mobileqq/zootopia/view/ZPlanBaseSceneLoadingView;)V", "loadingView", "Lcom/tencent/mobileqq/zootopia/ueloading/report/ZPlanUEReportHelper;", "Lkotlin/Lazy;", "p", "()Lcom/tencent/mobileqq/zootopia/ueloading/report/ZPlanUEReportHelper;", "ueReportHelper", "Lcom/tencent/mobileqq/zootopia/ueloading/ZPlanUEDialogController;", BdhLogUtil.LogTag.Tag_Conn, "j", "()Lcom/tencent/mobileqq/zootopia/ueloading/ZPlanUEDialogController;", "dialogController", "D", "Landroid/view/ViewGroup;", "activityRootView", "E", "Landroid/view/Window;", UserInfo.SEX_FEMALE, "J", "startTime", "Lcom/tencent/mobileqq/zplan/smallhome/status/ZPlanModLoadStatus;", "G", "Lcom/tencent/mobileqq/zplan/smallhome/status/ZPlanModLoadStatus;", "status", "<init>", "(Lcom/tencent/mobileqq/zootopia/ZootopiaUEActivity;ZLcom/tencent/mobileqq/zootopia/data/ZootopiaEnterParams;Lcom/tencent/mobileqq/zootopia/ZootopiaSource;)V", "H", "a", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes35.dex */
public final class ZPlanUELoadingController implements ud3.d, com.tencent.mobileqq.zplan.smallhome.status.a {

    /* renamed from: C, reason: from kotlin metadata */
    private final Lazy dialogController;

    /* renamed from: D, reason: from kotlin metadata */
    private ViewGroup activityRootView;

    /* renamed from: E, reason: from kotlin metadata */
    private Window window;

    /* renamed from: F, reason: from kotlin metadata */
    private long startTime;

    /* renamed from: G, reason: from kotlin metadata */
    private volatile ZPlanModLoadStatus status;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private final ZootopiaUEActivity activity;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private final boolean isV2Loading;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private final ZootopiaEnterParams enterParams;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private final ZootopiaSource source;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private ZPlanBaseSceneLoadingView loadingView;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private final Lazy ueReportHelper;

    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\u0010\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016\u00a8\u0006\b"}, d2 = {"com/tencent/mobileqq/zootopia/ueloading/ZPlanUELoadingController$b", "Lcom/tencent/mobileqq/zootopia/view/b;", "", "f", "Landroid/view/View;", "view", "c", "a", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes35.dex */
    public static final class b implements com.tencent.mobileqq.zootopia.view.b {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ ZPlanUEShowDialogEvent f329427a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ ZPlanUELoadingController f329428b;

        b(ZPlanUEShowDialogEvent zPlanUEShowDialogEvent, ZPlanUELoadingController zPlanUELoadingController) {
            this.f329427a = zPlanUEShowDialogEvent;
            this.f329428b = zPlanUELoadingController;
        }

        private final void f() {
            if (TextUtils.isEmpty(this.f329427a.getNativeScheme())) {
                return;
            }
            ISchemeApi iSchemeApi = (ISchemeApi) QRoute.api(ISchemeApi.class);
            String nativeScheme = this.f329427a.getNativeScheme();
            Intrinsics.checkNotNull(nativeScheme);
            ZootopiaSource source = this.f329428b.getSource();
            if (source == null) {
                source = ZootopiaSource.INSTANCE.i();
            }
            ((ISchemeApi) QRoute.api(ISchemeApi.class)).launchScheme(this.f329428b.getActivity(), iSchemeApi.appendSourceToScheme(nativeScheme, source));
        }

        @Override // com.tencent.mobileqq.zootopia.view.b
        public void a(View view) {
            Intrinsics.checkNotNullParameter(view, "view");
            QLog.d("ZPlanUELoadingController-ZootopiaUEActivity", 1, "handleDialogEvent, click right");
            if (this.f329427a.getDialogType() == 0) {
                LuaArgument argument = this.f329427a.getArgument();
                if (argument != null) {
                    argument.callback(ZPlanDialogLuaPlugin.INSTANCE.a(false));
                    return;
                }
                return;
            }
            f();
            this.f329428b.getActivity().finish();
        }

        @Override // com.tencent.mobileqq.zootopia.view.b
        public void b(View view) {
            b.a.b(this, view);
        }

        @Override // com.tencent.mobileqq.zootopia.view.b
        public void c(View view) {
            Intrinsics.checkNotNullParameter(view, "view");
            QLog.d("ZPlanUELoadingController-ZootopiaUEActivity", 1, "handleDialogEvent, click left");
            if (this.f329427a.getDialogType() == 0) {
                LuaArgument argument = this.f329427a.getArgument();
                if (argument != null) {
                    argument.callback(ZPlanDialogLuaPlugin.INSTANCE.a(true));
                    return;
                }
                return;
            }
            if (TextUtils.isEmpty(this.f329427a.getConfirmBtn())) {
                f();
            }
            this.f329428b.getActivity().finish();
        }

        @Override // com.tencent.mobileqq.zootopia.view.b
        public void d(View view) {
            b.a.a(this, view);
        }

        @Override // com.tencent.mobileqq.zootopia.view.b
        public void e(View view) {
            b.a.c(this, view);
        }
    }

    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016\u00a8\u0006\b"}, d2 = {"com/tencent/mobileqq/zootopia/ueloading/ZPlanUELoadingController$c", "Lcom/tencent/mobileqq/zootopia/view/a;", "", "errorCode", "", "errorMessage", "", "onFailed", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes35.dex */
    public static final class c extends com.tencent.mobileqq.zootopia.view.a {
        c() {
        }

        @Override // com.tencent.mobileqq.zootopia.view.a, com.tencent.mobileqq.zootopia.ipc.ah
        public void onFailed(int errorCode, String errorMessage) {
            Intrinsics.checkNotNullParameter(errorMessage, "errorMessage");
            super.onFailed(errorCode, errorMessage);
            if (errorCode == -87604) {
                ZPlanUELoadingController.this.getActivity().finish();
            }
        }
    }

    public ZPlanUELoadingController(ZootopiaUEActivity activity, boolean z16, ZootopiaEnterParams zootopiaEnterParams, ZootopiaSource zootopiaSource) {
        Lazy lazy;
        Lazy lazy2;
        ZPlanModLoadStatus status;
        Intrinsics.checkNotNullParameter(activity, "activity");
        this.activity = activity;
        this.isV2Loading = z16;
        this.enterParams = zootopiaEnterParams;
        this.source = zootopiaSource;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<ZPlanUEReportHelper>() { // from class: com.tencent.mobileqq.zootopia.ueloading.ZPlanUELoadingController$ueReportHelper$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ZPlanUEReportHelper invoke() {
                return new ZPlanUEReportHelper(ZPlanUELoadingController.this.getSource(), ZPlanUELoadingController.this.getEnterParams());
            }
        });
        this.ueReportHelper = lazy;
        lazy2 = LazyKt__LazyJVMKt.lazy(new Function0<ZPlanUEDialogController>() { // from class: com.tencent.mobileqq.zootopia.ueloading.ZPlanUELoadingController$dialogController$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ZPlanUEDialogController invoke() {
                ZPlanUELoadingController zPlanUELoadingController = ZPlanUELoadingController.this;
                return new ZPlanUEDialogController(zPlanUELoadingController, zPlanUELoadingController.getActivity(), ZPlanUELoadingController.this.getEnterParams(), ZPlanUELoadingController.this.getSource());
            }
        });
        this.dialogController = lazy2;
        ZPlanModLoadStatusInfo c16 = ZPlanModLoadStatusManagerForModProcess.f335710a.c();
        this.status = (c16 == null || (status = c16.getStatus()) == null) ? ZPlanModLoadStatus.Init : status;
    }

    private final ZPlanUETechReportParams f() {
        String str;
        ZootopiaEnterParams zootopiaEnterParams = this.enterParams;
        int mapId = zootopiaEnterParams != null ? zootopiaEnterParams.getMapId() : 0;
        long currentTimeMillis = System.currentTimeMillis();
        ZootopiaEnterParams zootopiaEnterParams2 = this.enterParams;
        long startTime = currentTimeMillis - (zootopiaEnterParams2 != null ? zootopiaEnterParams2.getStartTime() : 0L);
        long i3 = i();
        boolean z16 = this.isV2Loading;
        ZootopiaEnterParams zootopiaEnterParams3 = this.enterParams;
        if (zootopiaEnterParams3 == null || (str = zootopiaEnterParams3.getSource()) == null) {
            str = "0";
        }
        return new ZPlanUETechReportParams(mapId, startTime, i3, false, z16, str, false, false, 0, TroopInfo.PAY_PRIVILEGE_ALL, null);
    }

    private final long i() {
        return System.currentTimeMillis() - getStartTime();
    }

    private final ZPlanUEDialogController j() {
        return (ZPlanUEDialogController) this.dialogController.getValue();
    }

    private final ZPlanUEReportHelper p() {
        return (ZPlanUEReportHelper) this.ueReportHelper.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void q(ZPlanUELoadingController this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.y(0);
        this$0.t(false);
    }

    private final void r() {
        j().h();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void v(ZPlanUELoadingController this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.s();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void z(ZPlanUELoadingController this$0, ZPlanModLoadStatusInfo statusInfo) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(statusInfo, "$statusInfo");
        boolean z16 = this$0.status != statusInfo.getStatus();
        this$0.status = statusInfo.getStatus();
        ZPlanBaseSceneLoadingView zPlanBaseSceneLoadingView = this$0.loadingView;
        if (zPlanBaseSceneLoadingView != null) {
            zPlanBaseSceneLoadingView.h(this$0.status);
        }
        this$0.A(statusInfo, z16);
    }

    @Override // ud3.d
    public void Y1(ZPlanUEShowDialogEvent event) {
        Intrinsics.checkNotNullParameter(event, "event");
        QLog.d("ZPlanUELoadingController-ZootopiaUEActivity", 1, "notify handleDialogEvent");
        j().a(event.getTitle(), event.getMsg(), event.getCancelBtn(), event.getConfirmBtn(), new b(event, this));
    }

    public final void e(View view, int index) {
        Intrinsics.checkNotNullParameter(view, "view");
        Window window = this.window;
        View decorView = window != null ? window.getDecorView() : null;
        Intrinsics.checkNotNull(decorView, "null cannot be cast to non-null type android.view.ViewGroup");
        ((ViewGroup) decorView).addView(view);
    }

    public boolean g() {
        return ZootopiaSceneLoadingView.S && this.loadingView != null;
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public ArrayList<Class<SimpleBaseEvent>> getEventClass() {
        return d.a.a(this);
    }

    /* renamed from: h, reason: from getter */
    public final ZootopiaUEActivity getActivity() {
        return this.activity;
    }

    /* renamed from: k, reason: from getter */
    public final ZootopiaEnterParams getEnterParams() {
        return this.enterParams;
    }

    /* renamed from: l, reason: from getter */
    public final ZPlanBaseSceneLoadingView getLoadingView() {
        return this.loadingView;
    }

    /* renamed from: m, reason: from getter */
    public final ZootopiaSource getSource() {
        return this.source;
    }

    /* renamed from: n, reason: from getter */
    public final long getStartTime() {
        return this.startTime;
    }

    public ud3.b o() {
        return j();
    }

    public final void onDestroy() {
        ZPlanModLoadStatusManagerForModProcess.f335710a.g(this);
        SimpleEventBus.getInstance().unRegisterReceiver(this);
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public void onReceiveEvent(SimpleBaseEvent simpleBaseEvent) {
        d.a.b(this, simpleBaseEvent);
    }

    public void s() {
        String str;
        QLog.i("ZPlanUELoadingController-ZootopiaUEActivity", 1, "handleLoadingBackEvent");
        try {
            JSONObject jSONObject = new JSONObject();
            ZootopiaEnterParams zootopiaEnterParams = this.enterParams;
            jSONObject.put("ViewType", zootopiaEnterParams != null ? Integer.valueOf(zootopiaEnterParams.getType()) : null);
            str = jSONObject.toString();
            Intrinsics.checkNotNullExpressionValue(str, "JSONObject().apply {\n   \u2026\n            }.toString()");
        } catch (Throwable th5) {
            QLog.e("ZPlanUELoadingController-ZootopiaUEActivity", 1, "get luaParams err, ", th5);
            str = "";
        }
        ar.f328509a.a("N2L_LeaveSceneLoading", str);
    }

    public void u() {
        ZPlanBaseSceneLoadingView zootoppiaSceneLoadingViewV2;
        ZootopiaEnterParams zootopiaEnterParams;
        com.tencent.mobileqq.zootopia.ueloading.report.b.f329531a.m(f());
        QLog.d("ZPlanUELoadingController-ZootopiaUEActivity", 1, "initLoading, isV2Loading: " + this.isV2Loading);
        AttributeSet attributeSet = null;
        byte b16 = 0;
        if (!this.isV2Loading) {
            zootoppiaSceneLoadingViewV2 = new ZootopiaSceneLoadingView(this.activity);
        } else {
            zootoppiaSceneLoadingViewV2 = new ZootoppiaSceneLoadingViewV2(this.activity, attributeSet, 2, b16 == true ? 1 : 0);
        }
        this.loadingView = zootoppiaSceneLoadingViewV2;
        y(4);
        ZPlanBaseSceneLoadingView zPlanBaseSceneLoadingView = this.loadingView;
        if (zPlanBaseSceneLoadingView != null) {
            zPlanBaseSceneLoadingView.a(this.activity);
            zPlanBaseSceneLoadingView.b(this.source);
            zPlanBaseSceneLoadingView.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
            Window window = this.window;
            View decorView = window != null ? window.getDecorView() : null;
            Intrinsics.checkNotNull(decorView, "null cannot be cast to non-null type android.view.ViewGroup");
            e(zPlanBaseSceneLoadingView, 1);
            p().a((ViewGroup) decorView, zPlanBaseSceneLoadingView, this.enterParams);
            p().h(zPlanBaseSceneLoadingView);
            zPlanBaseSceneLoadingView.c(null, this.enterParams, this.source);
            zPlanBaseSceneLoadingView.setOnBackArrowClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.zootopia.ueloading.t
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    ZPlanUELoadingController.v(ZPlanUELoadingController.this, view);
                }
            });
            zPlanBaseSceneLoadingView.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.zootopia.ueloading.u
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    ZPlanUELoadingController.w(view);
                }
            });
            ZootopiaEnterParams zootopiaEnterParams2 = this.enterParams;
            if (zootopiaEnterParams2 != null ? Intrinsics.areEqual(zootopiaEnterParams2.getIsDownloaded(), Boolean.FALSE) : false) {
                Float progress = this.enterParams.getProgress();
                float floatValue = progress != null ? progress.floatValue() * 100 : 0.0f;
                String string = this.activity.getString(R.string.xwc);
                Intrinsics.checkNotNullExpressionValue(string, "activity.getString(R.str\u2026lan_ue_in_pause_download)");
                zPlanBaseSceneLoadingView.g(floatValue, string, "");
            }
            ZPlanModLoadStatusInfo c16 = ZPlanModLoadStatusManagerForModProcess.f335710a.c();
            if (c16 != null) {
                updateStatus(c16);
                if (c16.getStatus() != ZPlanModLoadStatus.MainPakPausing || (zootopiaEnterParams = this.enterParams) == null) {
                    return;
                }
                ZootopiaDownloadManagerIpc.f328013a.o(zootopiaEnterParams.getMapId(), new c(), this.activity);
            }
        }
    }

    @Override // com.tencent.mobileqq.zplan.smallhome.status.a
    public void updateStatus(final ZPlanModLoadStatusInfo statusInfo) {
        Intrinsics.checkNotNullParameter(statusInfo, "statusInfo");
        ZPlanBaseSceneLoadingView zPlanBaseSceneLoadingView = this.loadingView;
        if (zPlanBaseSceneLoadingView != null) {
            zPlanBaseSceneLoadingView.post(new Runnable() { // from class: com.tencent.mobileqq.zootopia.ueloading.s
                @Override // java.lang.Runnable
                public final void run() {
                    ZPlanUELoadingController.z(ZPlanUELoadingController.this, statusInfo);
                }
            });
        }
    }

    public void x(ViewGroup view, Window window) {
        Intrinsics.checkNotNullParameter(window, "window");
        QLog.d("ZPlanUELoadingController-ZootopiaUEActivity", 1, "onCreate");
        this.startTime = System.currentTimeMillis();
        this.activityRootView = view;
        this.window = window;
        ZPlanModLoadStatusManagerForModProcess.f335710a.f(this);
        SimpleEventBus.getInstance().registerReceiver(this);
    }

    @Override // ud3.d
    public void ya() {
        QLog.d("ZPlanUELoadingController-ZootopiaUEActivity", 1, "notify handleCloseView, cost: " + System.currentTimeMillis());
        ZPlanBaseSceneLoadingView zPlanBaseSceneLoadingView = this.loadingView;
        if (zPlanBaseSceneLoadingView != null) {
            zPlanBaseSceneLoadingView.post(new Runnable() { // from class: com.tencent.mobileqq.zootopia.ueloading.r
                @Override // java.lang.Runnable
                public final void run() {
                    ZPlanUELoadingController.q(ZPlanUELoadingController.this);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void w(View view) {
        QLog.i("ZPlanUELoadingController-ZootopiaUEActivity", 1, "click loading view!");
    }

    @Override // ud3.d
    public void Ub() {
        QLog.d("ZPlanUELoadingController-ZootopiaUEActivity", 1, "notify handleShowResBtn");
        ZPlanBaseSceneLoadingView zPlanBaseSceneLoadingView = this.loadingView;
        if (zPlanBaseSceneLoadingView != null) {
            zPlanBaseSceneLoadingView.f();
        }
    }

    public void t(boolean isRebind) {
        QLog.i("ZPlanUELoadingController-ZootopiaUEActivity", 1, "notify hideLoading");
        if (!isRebind) {
            com.tencent.mobileqq.zootopia.ueloading.report.b.f329531a.i(f());
        }
        ZPlanBaseSceneLoadingView zPlanBaseSceneLoadingView = this.loadingView;
        if (zPlanBaseSceneLoadingView != null) {
            zPlanBaseSceneLoadingView.setOnBackArrowClickListener(null);
            p().g(zPlanBaseSceneLoadingView);
            ViewParent parent = zPlanBaseSceneLoadingView.getParent();
            ViewGroup viewGroup = parent instanceof ViewGroup ? (ViewGroup) parent : null;
            if (viewGroup != null) {
                viewGroup.removeView(zPlanBaseSceneLoadingView);
            }
            this.loadingView = null;
        }
    }

    private final void A(ZPlanModLoadStatusInfo statusInfo, boolean isStatusChanged) {
        if (isStatusChanged) {
            QLog.d("ZPlanUELoadingController-ZootopiaUEActivity", 1, "updateUI: " + statusInfo);
        }
        if (statusInfo.getStatus() == ZPlanModLoadStatus.MainPakDownloadError) {
            r();
        }
        ZPlanBaseSceneLoadingView zPlanBaseSceneLoadingView = this.loadingView;
        if (zPlanBaseSceneLoadingView != null) {
            zPlanBaseSceneLoadingView.i(statusInfo.getGameVersion1(), statusInfo.getGameVersion2(), statusInfo.getGameVersion3());
            String downloadTips1 = statusInfo.getDownloadTips1();
            String downloadTips2 = statusInfo.getDownloadTips2();
            if (downloadTips1.length() == 0) {
                if (statusInfo.getStatus() != ZPlanModLoadStatus.MainPakDownloading && statusInfo.getStatus() != ZPlanModLoadStatus.MainPakDownloadFinish) {
                    if (statusInfo.getStatus() == ZPlanModLoadStatus.MainPakPausing) {
                        downloadTips1 = this.activity.getString(R.string.xwc);
                        Intrinsics.checkNotNullExpressionValue(downloadTips1, "activity.getString(R.str\u2026lan_ue_in_pause_download)");
                    }
                } else {
                    downloadTips1 = this.activity.getString(R.string.xwa);
                    Intrinsics.checkNotNullExpressionValue(downloadTips1, "activity.getString(R.string.zplan_ue_in_download)");
                }
            }
            zPlanBaseSceneLoadingView.g(statusInfo.getDownloadProgress() * 100, downloadTips1, downloadTips2);
        }
    }

    private final void y(int visible) {
    }
}

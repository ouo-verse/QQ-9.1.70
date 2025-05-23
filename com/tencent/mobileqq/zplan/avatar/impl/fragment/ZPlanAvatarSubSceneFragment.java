package com.tencent.mobileqq.zplan.avatar.impl.fragment;

import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.fragment.app.FragmentActivity;
import com.qzone.proxy.personalitycomponent.model.WidgetCacheLunarData;
import com.tencent.ams.dsdk.monitor.metric.event.TagName;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.common.ParseCommon;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mobileqq.z1.lua.c;
import com.tencent.mobileqq.zootopia.lua.ar;
import com.tencent.mobileqq.zootopia.scene.data.SceneComponentType;
import com.tencent.mobileqq.zootopia.scene.data.SceneInfo;
import com.tencent.mobileqq.zootopia.scene.fragment.base.BaseAvatarWithLoadingFragment;
import com.tencent.mobileqq.zootopia.ue.ZPlanLua2H5Plugin;
import com.tencent.mobileqq.zootopia.ue.ZootopiaUeModuleManager;
import com.tencent.mobileqq.zplan.api.IZPlanApi;
import com.tencent.mobileqq.zplan.avatar.impl.fragment.ZPlanAvatarSubSceneFragment;
import com.tencent.mobileqq.zplan.avatar.impl.input.ZPlanUEInputHelperView;
import com.tencent.mobileqq.zplan.event.api.Event;
import com.tencent.mobileqq.zplan.scheme.ISchemeApi;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqmini.sdk.launcher.MiniSDKConst;
import com.tencent.qqmini.sdk.plugins.SensorJsPlugin;
import com.tencent.sqshow.utils.featureswitch.ZPlanFeatureSwitch;
import com.tencent.sqshow.utils.featureswitch.ZPlanQQMC;
import com.tencent.sqshow.zootopia.ZootopiaActivity;
import com.tencent.sqshow.zootopia.avatar.AvatarEngineType;
import com.tencent.sqshow.zootopia.avatar.filament.FilamentApiImpl;
import com.tencent.sqshow.zootopia.avatar.filament.f;
import com.tencent.sqshow.zootopia.avatar.loading.ISceneLoadingView;
import com.tencent.sqshow.zootopia.avatar.mall.AvatarMallLoadingComponent;
import com.tencent.sqshow.zootopia.nativeui.data.CameraKey;
import com.tencent.sqshow.zootopia.scene.component.ComponentLoading;
import com.tencent.sqshow.zootopia.utils.ah;
import com.tencent.sqshow.zootopia.utils.r;
import com.tencent.sqshow.zootopia.widget.reddot.ZPlanRedDotManager;
import com.tencent.state.report.SquareReportConst;
import com.tencent.upload.report.UploadQualityReportBuilder;
import com.tencent.zplan.world.model.FirstFrameResult;
import cooperation.qqcircle.report.datong.QCircleDaTongConstant;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.Constants;
import mqq.util.WeakReference;
import org.json.JSONException;
import org.json.JSONObject;
import pd3.a;
import t74.u;
import ye3.a;

@Metadata(d1 = {"\u0000\u00e0\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010$\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0018\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 \u0090\u00012\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u00042\u00020\u0005:\u0004\u0091\u0001\u0092\u0001B\t\u00a2\u0006\u0006\b\u008e\u0001\u0010\u008f\u0001J\b\u0010\u0007\u001a\u00020\u0006H\u0002J\u0010\u0010\n\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0002J&\u0010\u000f\u001a\u00020\u00062\b\u0010\f\u001a\u0004\u0018\u00010\u000b2\u0012\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u000b0\rH\u0002J\b\u0010\u0010\u001a\u00020\u0006H\u0002J\b\u0010\u0011\u001a\u00020\u0006H\u0002J\b\u0010\u0012\u001a\u00020\u0006H\u0002J\b\u0010\u0013\u001a\u00020\u0006H\u0002J\u0012\u0010\u0016\u001a\u00020\u00062\b\u0010\u0015\u001a\u0004\u0018\u00010\u0014H\u0002J\u001a\u0010\u0018\u001a\u00020\u00062\b\u0010\u0015\u001a\u0004\u0018\u00010\u00142\u0006\u0010\u0017\u001a\u00020\u0014H\u0002J\b\u0010\u001a\u001a\u00020\u0019H\u0002J\u0014\u0010\u001b\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u000b0\rH\u0002J\u0010\u0010\u001c\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0002J\u0012\u0010\u001f\u001a\u00020\u00062\b\u0010\u001e\u001a\u0004\u0018\u00010\u001dH\u0016J&\u0010\"\u001a\u0004\u0018\u00010\b2\u0006\u0010!\u001a\u00020 2\b\u0010\u0015\u001a\u0004\u0018\u00010\u00142\b\u0010\u001e\u001a\u0004\u0018\u00010\u001dH\u0016J\b\u0010$\u001a\u00020#H\u0016J\b\u0010%\u001a\u00020\u0006H\u0016J\b\u0010&\u001a\u00020\u0006H\u0016J\b\u0010'\u001a\u00020\u0006H\u0016J\b\u0010(\u001a\u00020\u0006H\u0016J\b\u0010)\u001a\u00020\u0006H\u0016J\b\u0010*\u001a\u00020\u0006H\u0016J\b\u0010,\u001a\u00020+H\u0016J\u0012\u00100\u001a\u00020/2\b\u0010.\u001a\u0004\u0018\u00010-H\u0016J\u0010\u00102\u001a\u00020\u00062\u0006\u00101\u001a\u00020/H\u0016J\u0010\u00104\u001a\u00020\u00062\u0006\u00103\u001a\u00020/H\u0016J\b\u00105\u001a\u00020\u0006H\u0016J\b\u00106\u001a\u00020\u000bH\u0014J\b\u00107\u001a\u00020/H\u0016J\u0010\u00109\u001a\u00020\u00062\u0006\u00108\u001a\u00020\bH\u0016J\u0018\u0010;\u001a\u00020\u00062\u0006\u00108\u001a\u00020\b2\u0006\u0010:\u001a\u00020#H\u0016J\b\u0010<\u001a\u00020\u0006H\u0016J\b\u0010=\u001a\u00020\u0006H\u0016J\b\u0010>\u001a\u00020\u0006H\u0016J\b\u0010?\u001a\u00020\u0006H\u0014J\b\u0010@\u001a\u00020/H\u0014J\b\u0010A\u001a\u00020\u000bH\u0016J\b\u0010B\u001a\u00020\u000bH\u0016J\u0011\u0010C\u001a\u0004\u0018\u00010\u0019H\u0016\u00a2\u0006\u0004\bC\u0010DJ\u0011\u0010E\u001a\u0004\u0018\u00010/H\u0016\u00a2\u0006\u0004\bE\u0010FJ\b\u0010G\u001a\u00020\u000bH\u0016J\u0010\u0010J\u001a\u00020\u00062\u0006\u0010I\u001a\u00020HH\u0016R\u0018\u0010N\u001a\u0004\u0018\u00010K8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bL\u0010MR\u0016\u0010R\u001a\u00020O8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bP\u0010QR\u0016\u0010U\u001a\u00020/8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bS\u0010TR\u0016\u0010V\u001a\u00020/8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bT\u0010TR\u0014\u0010Z\u001a\u00020W8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bX\u0010YR\u0018\u0010^\u001a\u0004\u0018\u00010[8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\\\u0010]R\u0018\u0010b\u001a\u0004\u0018\u00010_8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b`\u0010aR\u0018\u0010f\u001a\u0004\u0018\u00010c8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bd\u0010eR\u0018\u0010j\u001a\u0004\u0018\u00010g8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bh\u0010iR\u0018\u0010n\u001a\u0004\u0018\u00010k8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bl\u0010mR\u0016\u0010q\u001a\u00020#8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bo\u0010pR\u001b\u0010w\u001a\u00020r8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\bs\u0010t\u001a\u0004\bu\u0010vR\u0016\u0010y\u001a\u00020/8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bx\u0010TR\u001b\u0010~\u001a\u00020z8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b{\u0010t\u001a\u0004\b|\u0010}R\u0017\u0010\u0082\u0001\u001a\u00020\u007f8\u0002X\u0082\u0004\u00a2\u0006\b\n\u0006\b\u0080\u0001\u0010\u0081\u0001R\u0019\u0010\u0085\u0001\u001a\u00020\u00198\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u0083\u0001\u0010\u0084\u0001R\u001c\u0010\u0089\u0001\u001a\u0005\u0018\u00010\u0086\u00018\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u0087\u0001\u0010\u0088\u0001R\u001a\u0010\u008d\u0001\u001a\u00030\u008a\u00018\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u008b\u0001\u0010\u008c\u0001\u00a8\u0006\u0093\u0001"}, d2 = {"Lcom/tencent/mobileqq/zplan/avatar/impl/fragment/ZPlanAvatarSubSceneFragment;", "Lcom/tencent/mobileqq/zootopia/scene/fragment/base/BaseAvatarWithLoadingFragment;", "Lod3/b;", "Lcom/tencent/mobileqq/zootopia/api/c;", "Lcom/tencent/sqshow/zootopia/avatar/loading/ISceneLoadingView$b;", "Lpd3/b;", "", "Ki", "Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "Di", "", "branchId", "", "reportMap", SensorJsPlugin.SENSOR_INTERVAL_UI, "Oi", "Ni", "Bi", "Ji", "Landroid/view/ViewGroup;", ParseCommon.CONTAINER, "Fi", "nativeUIContainer", "Ci", "", "Ii", "zi", "Ai", "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, "onCreate", "Landroid/view/LayoutInflater;", "inflater", "onCreateView", "", "xh", "beforeFinish", "onDestroyView", MosaicConstants$JsFunction.FUNC_ON_DESTROY, "onResume", MiniSDKConst.NOTIFY_EVENT_ONPAUSE, "Eh", "Lcom/tencent/mobileqq/zootopia/scene/data/c;", "M2", "Landroid/view/KeyEvent;", "event", "", "J5", "success", "engineInitFinish", UploadQualityReportBuilder.STATE_CONNECT, "serviceConnected", "engineDestroy", "getSubSource", "onBackPressedEvent", "view", "onCloseClick", "time", "K2", "w0", "Bb", "U", "Xh", "rh", "di", "ei", "bi", "()Ljava/lang/Integer;", "fi", "()Ljava/lang/Boolean;", "getPageId", "Landroid/content/res/Configuration;", "newConfig", "onConfigurationChanged", "Lcom/tencent/mobileqq/zootopia/ue/ZootopiaUeModuleManager;", "W", "Lcom/tencent/mobileqq/zootopia/ue/ZootopiaUeModuleManager;", "moduleManager", "Lcom/tencent/mobileqq/zootopia/utils/n;", "X", "Lcom/tencent/mobileqq/zootopia/utils/n;", "zplanEngineHelper", "Y", "Z", "loadingShowing", "loadingLogicEnd", "Lid3/d;", "a0", "Lid3/d;", "reporter", "Lye3/a$b;", "b0", "Lye3/a$b;", "backBufferSizeBefore", "La84/a;", "c0", "La84/a;", "avatarComponent", "Landroid/widget/ImageView;", "d0", "Landroid/widget/ImageView;", "backgroundIgv", "Landroid/widget/FrameLayout;", "e0", "Landroid/widget/FrameLayout;", "avatarContainer", "Lcom/tencent/mobileqq/zplan/avatar/impl/input/ZPlanUEInputHelperView;", "f0", "Lcom/tencent/mobileqq/zplan/avatar/impl/input/ZPlanUEInputHelperView;", "inputHelperView", "g0", "J", "finishDelay", "Lcom/tencent/mobileqq/z1/lua/c;", "h0", "Lkotlin/Lazy;", WidgetCacheLunarData.YI, "()Lcom/tencent/mobileqq/z1/lua/c;", "leaveAvatarScenePlugin", "i0", "onlyMakeupMode", "Lec3/b;", "j0", "xi", "()Lec3/b;", "apiReport", "Ljava/lang/Runnable;", "k0", "Ljava/lang/Runnable;", "avatarShowTask", "l0", "I", "currentViewType", "Lcom/tencent/mobileqq/zplan/avatar/impl/fragment/helper/b;", "m0", "Lcom/tencent/mobileqq/zplan/avatar/impl/fragment/helper/b;", "avatarPanelHelper", "Lcom/tencent/sqshow/zootopia/avatar/AvatarEngineType;", "n0", "Lcom/tencent/sqshow/zootopia/avatar/AvatarEngineType;", TagName.ENGINE_TYPE, "<init>", "()V", "o0", "a", "b", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes35.dex */
public final class ZPlanAvatarSubSceneFragment extends BaseAvatarWithLoadingFragment implements com.tencent.mobileqq.zootopia.api.c, ISceneLoadingView.b, pd3.b {

    /* renamed from: W, reason: from kotlin metadata */
    private ZootopiaUeModuleManager moduleManager;

    /* renamed from: Y, reason: from kotlin metadata */
    private boolean loadingShowing;

    /* renamed from: Z, reason: from kotlin metadata */
    private boolean loadingLogicEnd;

    /* renamed from: b0, reason: collision with root package name and from kotlin metadata */
    private a.Size backBufferSizeBefore;

    /* renamed from: c0, reason: collision with root package name and from kotlin metadata */
    private a84.a avatarComponent;

    /* renamed from: d0, reason: collision with root package name and from kotlin metadata */
    private ImageView backgroundIgv;

    /* renamed from: e0, reason: collision with root package name and from kotlin metadata */
    private FrameLayout avatarContainer;

    /* renamed from: f0, reason: collision with root package name and from kotlin metadata */
    private ZPlanUEInputHelperView inputHelperView;

    /* renamed from: h0, reason: collision with root package name and from kotlin metadata */
    private final Lazy leaveAvatarScenePlugin;

    /* renamed from: i0, reason: collision with root package name and from kotlin metadata */
    private boolean onlyMakeupMode;

    /* renamed from: j0, reason: collision with root package name and from kotlin metadata */
    private final Lazy apiReport;

    /* renamed from: k0, reason: collision with root package name and from kotlin metadata */
    private final Runnable avatarShowTask;

    /* renamed from: l0, reason: collision with root package name and from kotlin metadata */
    private int currentViewType;

    /* renamed from: m0, reason: collision with root package name and from kotlin metadata */
    private com.tencent.mobileqq.zplan.avatar.impl.fragment.helper.b avatarPanelHelper;

    /* renamed from: n0, reason: collision with root package name and from kotlin metadata */
    private AvatarEngineType engineType;

    /* renamed from: X, reason: from kotlin metadata */
    private com.tencent.mobileqq.zootopia.utils.n zplanEngineHelper = new com.tencent.mobileqq.zootopia.utils.n(1);

    /* renamed from: a0, reason: collision with root package name and from kotlin metadata */
    private final id3.d reporter = new id3.d(null, 1, null);

    /* renamed from: g0, reason: collision with root package name and from kotlin metadata */
    private long finishDelay = 250;

    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0000\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\t\u001a\u00020\u0005\u00a2\u0006\u0004\b\n\u0010\u000bJ\b\u0010\u0003\u001a\u00020\u0002H\u0016R\"\u0010\b\u001a\u0010\u0012\f\u0012\n \u0006*\u0004\u0018\u00010\u00050\u00050\u00048\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0007\u00a8\u0006\f"}, d2 = {"Lcom/tencent/mobileqq/zplan/avatar/impl/fragment/ZPlanAvatarSubSceneFragment$b;", "Lcom/tencent/mobileqq/z1/lua/c$b;", "", "a", "Lmqq/util/WeakReference;", "Lcom/tencent/mobileqq/zplan/avatar/impl/fragment/ZPlanAvatarSubSceneFragment;", "kotlin.jvm.PlatformType", "Lmqq/util/WeakReference;", "fragmentRefer", "fragment", "<init>", "(Lcom/tencent/mobileqq/zplan/avatar/impl/fragment/ZPlanAvatarSubSceneFragment;)V", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes35.dex */
    public static final class b implements c.b {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        private final WeakReference<ZPlanAvatarSubSceneFragment> fragmentRefer;

        public b(ZPlanAvatarSubSceneFragment fragment) {
            Intrinsics.checkNotNullParameter(fragment, "fragment");
            this.fragmentRefer = new WeakReference<>(fragment);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void c(ZPlanAvatarSubSceneFragment refer) {
            Window window;
            Intrinsics.checkNotNullParameter(refer, "$refer");
            FragmentActivity activity = refer.getActivity();
            if (activity instanceof ZootopiaActivity) {
                QLog.i("ZPlanAvatarSubSceneFragment_", 1, "activity is ZootopiaActivity");
                ((ZootopiaActivity) activity).I2();
            }
            refer.finishDelay = 0L;
            View decorView = (activity == null || (window = activity.getWindow()) == null) ? null : window.getDecorView();
            if (decorView != null) {
                decorView.setVisibility(4);
            }
            if (activity != null) {
                activity.finish();
            }
        }

        @Override // com.tencent.mobileqq.z1.lua.c.b
        public boolean a() {
            final ZPlanAvatarSubSceneFragment zPlanAvatarSubSceneFragment = this.fragmentRefer.get();
            if (zPlanAvatarSubSceneFragment == null) {
                return false;
            }
            ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.mobileqq.zplan.avatar.impl.fragment.k
                @Override // java.lang.Runnable
                public final void run() {
                    ZPlanAvatarSubSceneFragment.b.c(ZPlanAvatarSubSceneFragment.this);
                }
            });
            return true;
        }
    }

    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes35.dex */
    public /* synthetic */ class c {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f331893a;

        static {
            int[] iArr = new int[AvatarEngineType.values().length];
            try {
                iArr[AvatarEngineType.FILAMENT.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            f331893a = iArr;
        }
    }

    @Metadata(d1 = {"\u0000!\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J!\u0010\u0006\u001a\u00020\u00052\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0016\u00a2\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\n\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\bH\u0016\u00a8\u0006\u000b"}, d2 = {"com/tencent/mobileqq/zplan/avatar/impl/fragment/ZPlanAvatarSubSceneFragment$d", "Lpd3/a;", "", QCircleDaTongConstant.ElementParamValue.XSJ_SHARE_PANEL_STYLE_OLD, QCircleDaTongConstant.ElementParamValue.NEW, "", "b", "(Ljava/lang/Integer;I)V", "Lcom/tencent/zplan/world/model/FirstFrameResult;", "result", "a", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes35.dex */
    public static final class d implements pd3.a {
        d() {
        }

        @Override // pd3.a
        public void a(FirstFrameResult result) {
            Intrinsics.checkNotNullParameter(result, "result");
            SceneInfo M2 = ZPlanAvatarSubSceneFragment.this.M2();
            boolean m3 = M2.m(SceneInfo.INSTANCE.b(result.getParams()));
            QLog.i("ZPlanAvatarSubSceneFragment_", 1, "onSceneFirstFrame isSame:" + m3 + ", self:" + M2 + ", result:" + result);
            if (m3) {
                com.tencent.mobileqq.zplan.avatar.impl.fragment.helper.b bVar = ZPlanAvatarSubSceneFragment.this.avatarPanelHelper;
                if (bVar != null) {
                    bVar.onFirstFrame(result);
                }
                ThreadManagerV2.getUIHandlerV2().post(ZPlanAvatarSubSceneFragment.this.avatarShowTask);
                ZPlanAvatarSubSceneFragment.this.hideLoadingView();
            }
        }

        @Override // pd3.a
        public void b(Integer old, int r36) {
            if (((we3.a) k74.i.INSTANCE.a(we3.a.class)).needLoading(r36)) {
                QLog.i("ZPlanAvatarSubSceneFragment_", 1, "onSceneChange needLoading true , loading showing");
                ZPlanAvatarSubSceneFragment.this.showLoadingView();
            }
        }

        @Override // pd3.a
        public void c() {
            a.C11005a.a(this);
        }
    }

    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/mobileqq/zplan/avatar/impl/fragment/ZPlanAvatarSubSceneFragment$e", "Lcom/tencent/sqshow/zootopia/scene/component/d;", "Lcom/tencent/sqshow/zootopia/scene/component/c;", "originHandler", "", ReportConstant.COSTREPORT_PREFIX, "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes35.dex */
    public static final class e implements com.tencent.sqshow.zootopia.scene.component.d {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ ComponentLoading f331895d;

        e(ComponentLoading componentLoading) {
            this.f331895d = componentLoading;
        }

        @Override // com.tencent.sqshow.zootopia.scene.component.d
        public boolean s(com.tencent.sqshow.zootopia.scene.component.c originHandler) {
            Intrinsics.checkNotNullParameter(originHandler, "originHandler");
            ISceneLoadingView V = this.f331895d.V();
            if (V != null) {
                return V.s(originHandler);
            }
            return false;
        }
    }

    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/mobileqq/zplan/avatar/impl/fragment/ZPlanAvatarSubSceneFragment$f", "Lcom/tencent/sqshow/zootopia/scene/component/d;", "Lcom/tencent/sqshow/zootopia/scene/component/c;", "originHandler", "", ReportConstant.COSTREPORT_PREFIX, "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes35.dex */
    public static final class f implements com.tencent.sqshow.zootopia.scene.component.d {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ ComponentLoading f331896d;

        f(ComponentLoading componentLoading) {
            this.f331896d = componentLoading;
        }

        @Override // com.tencent.sqshow.zootopia.scene.component.d
        public boolean s(com.tencent.sqshow.zootopia.scene.component.c originHandler) {
            Intrinsics.checkNotNullParameter(originHandler, "originHandler");
            ISceneLoadingView V = this.f331896d.V();
            if (V == null) {
                return false;
            }
            V.s(originHandler);
            return false;
        }
    }

    public ZPlanAvatarSubSceneFragment() {
        Lazy lazy;
        Lazy lazy2;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<com.tencent.mobileqq.z1.lua.c>() { // from class: com.tencent.mobileqq.zplan.avatar.impl.fragment.ZPlanAvatarSubSceneFragment$leaveAvatarScenePlugin$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final com.tencent.mobileqq.z1.lua.c invoke() {
                return new com.tencent.mobileqq.z1.lua.c(new ZPlanAvatarSubSceneFragment.b(ZPlanAvatarSubSceneFragment.this));
            }
        });
        this.leaveAvatarScenePlugin = lazy;
        lazy2 = LazyKt__LazyJVMKt.lazy(new Function0<ec3.b>() { // from class: com.tencent.mobileqq.zplan.avatar.impl.fragment.ZPlanAvatarSubSceneFragment$apiReport$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ec3.b invoke() {
                return new ec3.b();
            }
        });
        this.apiReport = lazy2;
        this.avatarShowTask = new Runnable() { // from class: com.tencent.mobileqq.zplan.avatar.impl.fragment.e
            @Override // java.lang.Runnable
            public final void run() {
                ZPlanAvatarSubSceneFragment.vi(ZPlanAvatarSubSceneFragment.this);
            }
        };
        this.engineType = ((te3.a) vb3.a.f441346a.b(te3.a.class)).g0();
    }

    private final void Ai(View rootView) {
        AvatarEngineType g06;
        Bundle arguments = getArguments();
        if (arguments != null ? arguments.getBoolean("NeedLoading", false) : false) {
            rootView.setBackground(new ColorDrawable(-1));
            showLoadingView();
        }
        Bundle arguments2 = getArguments();
        boolean z16 = arguments2 != null ? arguments2.getBoolean("onlyMakeupMode", false) : false;
        this.onlyMakeupMode = z16;
        if (z16) {
            g06 = AvatarEngineType.UE;
        } else {
            g06 = ((te3.a) vb3.a.f441346a.b(te3.a.class)).g0();
        }
        this.engineType = g06;
    }

    private final void Bi() {
        FrameLayout frameLayout = this.avatarContainer;
        if (frameLayout != null) {
            frameLayout.removeAllViews();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Ei(ZPlanAvatarSubSceneFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        QRouteApi api = QRoute.api(ISchemeApi.class);
        Intrinsics.checkNotNullExpressionValue(api, "api(ISchemeApi::class.java)");
        ISchemeApi iSchemeApi = (ISchemeApi) api;
        String a16 = ISchemeApi.b.a(iSchemeApi, this$0.Ch(), null, 2, null);
        BaseApplication context = BaseApplication.context;
        Intrinsics.checkNotNullExpressionValue(context, "context");
        iSchemeApi.launchScheme(context, a16);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Hi(View view) {
        com.tencent.sqshow.zootopia.avatar.f.f369932a.b().b(view.getWidth(), view.getHeight());
    }

    private final int Ii() {
        Intent intent;
        Bundle arguments = getArguments();
        int i3 = arguments != null ? arguments.getInt("sceneType", 0) : 0;
        if (i3 <= 0) {
            Bundle arguments2 = getArguments();
            String string = arguments2 != null ? arguments2.getString("ueParams", null) : null;
            if (TextUtils.isEmpty(string)) {
                xb4.b bVar = xb4.b.f447772a;
                FragmentActivity activity = getActivity();
                JSONObject j3 = bVar.j((activity == null || (intent = activity.getIntent()) == null) ? null : intent.getExtras());
                string = j3 != null ? j3.toString() : null;
            }
            if (string == null || string.length() == 0) {
                return 1;
            }
            i3 = new JSONObject(string).optInt("sceneType", 1);
        }
        this.currentViewType = i3;
        return i3;
    }

    private final void Ji() {
        a.Size size = this.backBufferSizeBefore;
        if (size == null) {
            return;
        }
        this.backBufferSizeBefore = null;
        a.C11609a.a((ye3.a) vb3.a.f441346a.b(ye3.a.class), getActivity(), size.getWidth(), size.getHeight(), false, 8, null);
    }

    private final void Ki() {
        final int Bh = Bh();
        u.Companion companion = u.INSTANCE;
        final int c16 = companion.c(getContext());
        final int b16 = companion.b(getContext()) + Bh;
        a.C11609a.a((ye3.a) vb3.a.f441346a.b(ye3.a.class), getActivity(), c16, b16, false, 8, null);
        FrameLayout frameLayout = this.avatarContainer;
        if (frameLayout != null) {
            frameLayout.requestLayout();
        }
        FrameLayout frameLayout2 = this.avatarContainer;
        if (frameLayout2 != null) {
            frameLayout2.post(new Runnable() { // from class: com.tencent.mobileqq.zplan.avatar.impl.fragment.h
                @Override // java.lang.Runnable
                public final void run() {
                    ZPlanAvatarSubSceneFragment.Li(ZPlanAvatarSubSceneFragment.this, c16, b16, Bh);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Li(ZPlanAvatarSubSceneFragment this$0, int i3, int i16, int i17) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        FrameLayout frameLayout = this$0.avatarContainer;
        Integer valueOf = frameLayout != null ? Integer.valueOf(frameLayout.getWidth()) : null;
        FrameLayout frameLayout2 = this$0.avatarContainer;
        Integer valueOf2 = frameLayout2 != null ? Integer.valueOf(frameLayout2.getHeight()) : null;
        QLog.i("ZPlanAvatarSubSceneFragment_", 1, "resizeBackBufferSizeToFull viewWidth:" + valueOf + ", viewHeight:" + valueOf2 + ", screenWidth:" + i3 + ", screenHeight:" + i16 + ", statusBarHeight:" + i17);
        if (valueOf != null) {
            i3 = valueOf.intValue();
        }
        int i18 = i3;
        if (valueOf2 != null) {
            i16 = valueOf2.intValue();
        }
        a.C11609a.a((ye3.a) vb3.a.f441346a.b(ye3.a.class), this$0.getActivity(), i18, i16, false, 8, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Mi(ZPlanAvatarSubSceneFragment this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.Ki();
    }

    private final void Ni() {
        a84.a aVar;
        Bitmap v46;
        ImageView imageView = this.backgroundIgv;
        if (imageView == null || (aVar = this.avatarComponent) == null || (v46 = aVar.v4()) == null) {
            return;
        }
        imageView.setImageBitmap(v46);
    }

    private final void Oi() {
        Ni();
        com.tencent.mobileqq.zplan.avatar.impl.fragment.helper.b bVar = this.avatarPanelHelper;
        boolean z16 = false;
        if (bVar != null && bVar.getMNeedPanelView()) {
            z16 = true;
        }
        if (!z16) {
            Bi();
        }
        ((xe3.a) vb3.a.f441346a.b(xe3.a.class)).k0(M2());
        Ji();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void vi(ZPlanAvatarSubSceneFragment this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        QLog.i("ZPlanAvatarSubSceneFragment_", 1, "avatarShowTask running");
        FrameLayout frameLayout = this$0.avatarContainer;
        if (frameLayout == null) {
            return;
        }
        frameLayout.setAlpha(1.0f);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void wi(ZPlanAvatarSubSceneFragment this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        ar.f328509a.b(this$0.yi());
    }

    private final ec3.b xi() {
        return (ec3.b) this.apiReport.getValue();
    }

    private final com.tencent.mobileqq.z1.lua.c yi() {
        return (com.tencent.mobileqq.z1.lua.c) this.leaveAvatarScenePlugin.getValue();
    }

    private final Map<String, String> zi() {
        JSONObject jSONObject;
        JSONObject optJSONObject;
        SceneInfo M2 = M2();
        try {
            jSONObject = new JSONObject(M2.getJsonStr()).optJSONObject("SubScene");
        } catch (Exception unused) {
            QLog.e("ZPlanAvatarSubSceneFragment_", 1, "getNativeReportPageId error - " + M2);
            jSONObject = null;
        }
        int i3 = -1;
        int optInt = jSONObject != null ? jSONObject.optInt("SceneType") : -1;
        if (jSONObject != null && (optJSONObject = jSONObject.optJSONObject("SceneParams")) != null) {
            i3 = optJSONObject.optInt("BrandId");
        }
        String str = "pg_zplan_avatar_mall";
        if (optInt == 1) {
            if (i3 > 0) {
                str = "pg_zplan_brand_mall";
            }
        } else if (optInt != 5 && optInt != 6) {
            str = optInt == 7 ? "pg_zplan_props_backpack" : this.currentViewType == 25 ? "pg_zplan_creator_tool" : "";
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put("dt_pgid", str);
        if (i3 > 0) {
            linkedHashMap.put("zplan_brand_id", String.valueOf(i3));
        }
        return linkedHashMap;
    }

    @Override // pd3.b
    public void Bb() {
        QLog.i("ZPlanAvatarSubSceneFragment_", 1, "onLoadingLogicEnd");
        this.loadingLogicEnd = true;
    }

    @Override // com.tencent.mobileqq.zootopia.scene.fragment.base.BaseAvatarFragment, com.tencent.sqshow.fragment.ZootopiaBaseFragment
    public void Eh() {
        super.Eh();
        if (this.engineType == AvatarEngineType.UE || ZPlanFeatureSwitch.f369852a.y0()) {
            this.zplanEngineHelper.c();
        }
    }

    @Override // com.tencent.sqshow.zootopia.avatar.loading.ISceneLoadingView.b
    public void K2(View view, long time) {
        Intrinsics.checkNotNullParameter(view, "view");
    }

    /* JADX WARN: Removed duplicated region for block: B:42:0x00a8  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x00d2  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x00e9  */
    @Override // com.tencent.mobileqq.zootopia.scene.fragment.base.BaseAvatarFragment, od3.a
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public SceneInfo M2() {
        SceneInfo.Companion companion;
        String a16;
        com.tencent.mobileqq.zplan.avatar.impl.fragment.helper.b bVar;
        CameraKey cameraId;
        JSONObject jSONObject;
        boolean z16;
        JSONObject optJSONObject;
        JSONObject optJSONObject2;
        Intent intent;
        int Ii = Ii();
        String str = "";
        if (ZPlanQQMC.INSTANCE.enableZPlanFriendDressBuyUinReport()) {
            Bundle arguments = getArguments();
            str = arguments != null ? arguments.getString("friendUin", "") : null;
        }
        Bundle arguments2 = getArguments();
        String string = arguments2 != null ? arguments2.getString("ueParams", null) : null;
        if (TextUtils.isEmpty(string)) {
            xb4.b bVar2 = xb4.b.f447772a;
            FragmentActivity activity = getActivity();
            JSONObject j3 = bVar2.j((activity == null || (intent = activity.getIntent()) == null) ? null : intent.getExtras());
            string = j3 != null ? j3.toString() : null;
        }
        try {
            jSONObject = new JSONObject(string == null ? "{}" : string);
            jSONObject.put("Source", ah.b(Ch()));
        } catch (JSONException e16) {
            QLog.e("ZPlanAvatarSubSceneFragment_", 1, "getSceneParams failed", e16);
        }
        if (str != null && str.length() != 0) {
            z16 = false;
            if (!z16 && (optJSONObject = jSONObject.optJSONObject("SubScene")) != null && (optJSONObject2 = optJSONObject.optJSONObject("SceneParams")) != null) {
                optJSONObject2.put(SquareReportConst.Key.KEY_ZPLAN_FRIEND_UIN, str);
            }
            string = jSONObject.toString();
            companion = SceneInfo.INSTANCE;
            if (string == null) {
                string = "{}";
            }
            a16 = companion.a(string, "NativePageHash", "ZPlanAvatarSubSceneFragment" + hashCode());
            bVar = this.avatarPanelHelper;
            if (bVar != null && (cameraId = bVar.getCameraId()) != null) {
                if (a16 == null) {
                    a16 = "{}";
                }
                a16 = companion.a(a16, "InitCameraConfig", r94.c.u(j94.a.f409675a.b(cameraId)));
            }
            return new SceneInfo(Ii, a16 != null ? a16 : "{}");
        }
        z16 = true;
        if (!z16) {
            optJSONObject2.put(SquareReportConst.Key.KEY_ZPLAN_FRIEND_UIN, str);
        }
        string = jSONObject.toString();
        companion = SceneInfo.INSTANCE;
        if (string == null) {
        }
        a16 = companion.a(string, "NativePageHash", "ZPlanAvatarSubSceneFragment" + hashCode());
        bVar = this.avatarPanelHelper;
        if (bVar != null) {
            if (a16 == null) {
            }
            a16 = companion.a(a16, "InitCameraConfig", r94.c.u(j94.a.f409675a.b(cameraId)));
        }
        return new SceneInfo(Ii, a16 != null ? a16 : "{}");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.zootopia.scene.fragment.base.BaseAvatarWithLoadingFragment
    public void Xh() {
        if (((we3.a) k74.i.INSTANCE.a(we3.a.class)).needLoading(M2().getSceneType())) {
            super.Xh();
        }
    }

    @Override // com.tencent.mobileqq.zootopia.scene.fragment.base.BaseAvatarWithLoadingFragment, com.tencent.sqshow.fragment.ZPlanPublicBaseFragment, com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, com.tencent.biz.richframework.compat.CompatPublicFragment
    public void beforeFinish() {
        try {
            Oi();
        } catch (Exception e16) {
            QLog.e("ZPlanAvatarSubSceneFragment_", 1, "beforeFinish error", e16);
        }
        super.beforeFinish();
    }

    @Override // com.tencent.mobileqq.zootopia.scene.fragment.base.BaseAvatarWithLoadingFragment
    public Integer bi() {
        return Integer.valueOf(this.currentViewType);
    }

    @Override // com.tencent.mobileqq.zootopia.scene.fragment.base.BaseAvatarWithLoadingFragment
    public String di() {
        return "SUB_AVATAR";
    }

    @Override // com.tencent.mobileqq.zootopia.scene.fragment.base.BaseAvatarWithLoadingFragment
    public String ei() {
        return "ZPlanAvatarSubSceneFragment_-" + hashCode();
    }

    @Override // com.tencent.mobileqq.zootopia.scene.fragment.base.BaseAvatarWithLoadingFragment, com.tencent.mobileqq.zootopia.scene.fragment.base.BaseAvatarFragment, com.tencent.zplan.engine.ZPlanEngineStatusUpdateListener
    public void engineDestroy() {
        ZootopiaUeModuleManager zootopiaUeModuleManager = this.moduleManager;
        if (zootopiaUeModuleManager != null) {
            zootopiaUeModuleManager.engineDestroy();
        }
        super.engineDestroy();
    }

    @Override // com.tencent.mobileqq.zootopia.scene.fragment.base.BaseAvatarFragment, com.tencent.zplan.engine.ZPlanEngineStatusUpdateListener
    public void engineInitFinish(boolean success) {
        Integer bi5;
        ZootopiaUeModuleManager zootopiaUeModuleManager = this.moduleManager;
        if (zootopiaUeModuleManager != null) {
            zootopiaUeModuleManager.engineInitFinish(success);
        }
        com.tencent.mobileqq.zplan.avatar.impl.fragment.helper.b bVar = this.avatarPanelHelper;
        if (bVar != null) {
            bVar.engineInitFinish(success);
        }
        super.engineInitFinish(success);
        QLog.i("ZPlanAvatarSubSceneFragment_", 1, "engineInitFinish " + success + ", " + bi());
        if (success && (bi5 = bi()) != null && bi5.intValue() == 25) {
            t74.l.f435563a.f(new Runnable() { // from class: com.tencent.mobileqq.zplan.avatar.impl.fragment.d
                @Override // java.lang.Runnable
                public final void run() {
                    ZPlanAvatarSubSceneFragment.wi(ZPlanAvatarSubSceneFragment.this);
                }
            });
        }
    }

    @Override // com.tencent.mobileqq.zootopia.scene.fragment.base.BaseAvatarWithLoadingFragment
    public Boolean fi() {
        return Boolean.valueOf(this.loadingShowing);
    }

    @Override // com.tencent.mobileqq.zootopia.scene.fragment.base.BaseAvatarWithLoadingFragment
    public String getPageId() {
        String str = zi().get("dt_pgid");
        return str == null ? "" : str;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.sqshow.fragment.ZootopiaBaseFragment
    public String getSubSource() {
        return "1";
    }

    @Override // com.tencent.mobileqq.zootopia.api.b
    public boolean onBackPressedEvent() {
        return false;
    }

    @Override // com.tencent.sqshow.zootopia.avatar.loading.ISceneLoadingView.b
    public void onCloseClick(View view) {
        FragmentActivity activity;
        Intrinsics.checkNotNullParameter(view, "view");
        if (this.loadingLogicEnd || (activity = getActivity()) == null) {
            return;
        }
        activity.finish();
    }

    @Override // com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration newConfig) {
        Intrinsics.checkNotNullParameter(newConfig, "newConfig");
        super.onConfigurationChanged(newConfig);
        QLog.i("ZPlanAvatarSubSceneFragment_", 1, "onConfigurationChanged ");
        this.backBufferSizeBefore = null;
        Ki();
    }

    @Override // com.tencent.mobileqq.zootopia.scene.fragment.base.BaseAvatarFragment, com.tencent.sqshow.fragment.ZootopiaBaseFragment, com.tencent.sqshow.fragment.ZPlanPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle savedInstanceState) {
        ZootopiaUeModuleManager zootopiaUeModuleManager;
        super.onCreate(savedInstanceState);
        FilamentApiImpl.f369933a.f();
        Ii();
        this.backBufferSizeBefore = ((ye3.a) vb3.a.f441346a.a(ye3.a.class)).n();
        this.moduleManager = new ZootopiaUeModuleManager(1, "SUB_AVATAR");
        FragmentActivity activity = getActivity();
        if (activity != null && (zootopiaUeModuleManager = this.moduleManager) != null) {
            zootopiaUeModuleManager.u9(activity, new com.tencent.mobileqq.zootopia.ue.d(Ch()));
        }
        ZPlanLua2H5Plugin.INSTANCE.a();
        QLog.i("ZPlanAvatarSubSceneFragment_", 1, "onCreate :: " + bi());
    }

    @Override // com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Window window;
        ZPlanUEInputHelperView zPlanUEInputHelperView;
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        final View view = inflater.inflate(R.layout.d9a, container, false);
        this.inputHelperView = (ZPlanUEInputHelperView) view.findViewById(R.id.f163425q22);
        FragmentActivity activity = getActivity();
        if (activity != null && (window = activity.getWindow()) != null && (zPlanUEInputHelperView = this.inputHelperView) != null) {
            zPlanUEInputHelperView.b(window);
        }
        ImageView imageView = (ImageView) view.findViewById(R.id.pdc);
        this.backgroundIgv = imageView;
        if (imageView != null) {
            imageView.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.zplan.avatar.impl.fragment.f
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    ZPlanAvatarSubSceneFragment.Gi(view2);
                }
            });
        }
        View findViewById = view.findViewById(R.id.qz9);
        Intrinsics.checkNotNullExpressionValue(findViewById, "view.findViewById(R.id.z\u2026ia_base_avatar_container)");
        this.avatarContainer = (FrameLayout) findViewById;
        FrameLayout nativeUIContainer = (FrameLayout) view.findViewById(R.id.pbv);
        FrameLayout frameLayout = (FrameLayout) view.findViewById(R.id.qz_);
        Intrinsics.checkNotNullExpressionValue(view, "view");
        Ai(view);
        FrameLayout frameLayout2 = this.avatarContainer;
        Intrinsics.checkNotNullExpressionValue(nativeUIContainer, "nativeUIContainer");
        Ci(frameLayout2, nativeUIContainer);
        Fi(frameLayout);
        if (j74.b.f409622a.f()) {
            frameLayout.setVisibility(8);
            view.setBackgroundColor(-1);
        }
        ThreadManagerV2.getUIHandlerV2().postDelayed(this.avatarShowTask, 3000L);
        Map<String, String> zi5 = zi();
        String str = zi5.get("dt_pgid");
        Intrinsics.checkNotNull(str, "null cannot be cast to non-null type kotlin.String");
        String str2 = str;
        if (!TextUtils.isEmpty(str2)) {
            QLog.i("ZPlanAvatarSubSceneFragment_", 1, "ZPlanAvatarSubSceneFragment nativeReportPage - " + str2);
            FragmentActivity activity2 = getActivity();
            if (activity2 != null) {
                String str3 = zi5.containsKey("zplan_brand_id") ? zi5.get("zplan_brand_id") : null;
                HashMap hashMap = new HashMap();
                hashMap.put(SquareReportConst.Key.KEY_EXTERNAL_ENTRANCE, ah.b(Ch()));
                if (str3 != null) {
                    hashMap.put("zplan_brand_id", str3);
                }
                if (!Intrinsics.areEqual(str2, "pg_zplan_avatar_mall")) {
                    this.reporter.j(activity2, view, str2, hashMap);
                }
                ui(str3, zi5);
            }
        }
        view.post(new Runnable() { // from class: com.tencent.mobileqq.zplan.avatar.impl.fragment.g
            @Override // java.lang.Runnable
            public final void run() {
                ZPlanAvatarSubSceneFragment.Hi(view);
            }
        });
        Di(view);
        view.findViewById(R.id.pof).setVisibility(8);
        FragmentActivity activity3 = getActivity();
        QBaseActivity qBaseActivity = activity3 instanceof QBaseActivity ? (QBaseActivity) activity3 : null;
        if (qBaseActivity != null) {
            com.tencent.sqshow.zootopia.utils.a.a(qBaseActivity);
            r.c(qBaseActivity.getWindow());
        }
        return view;
    }

    @Override // com.tencent.mobileqq.zootopia.scene.fragment.base.BaseAvatarWithLoadingFragment, com.tencent.mobileqq.zootopia.scene.fragment.base.BaseAvatarFragment, com.tencent.sqshow.fragment.ZootopiaBaseFragment, com.tencent.sqshow.fragment.ZPlanPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        QLog.i("ZPlanAvatarSubSceneFragment_", 1, "onDestroy :: getCurrentViewType() == " + bi());
        Integer bi5 = bi();
        if (bi5 != null && bi5.intValue() == 25) {
            ar.f328509a.c(yi());
        }
        ZootopiaUeModuleManager zootopiaUeModuleManager = this.moduleManager;
        if (zootopiaUeModuleManager != null) {
            zootopiaUeModuleManager.destroy();
        }
        if (this.engineType == AvatarEngineType.UE || ZPlanFeatureSwitch.f369852a.y0()) {
            this.zplanEngineHelper.c();
        }
        a84.a aVar = this.avatarComponent;
        if (aVar != null) {
            aVar.destroy();
        }
        this.avatarComponent = null;
        qe3.a.f428883a.b();
        com.tencent.mobileqq.zplan.avatar.impl.fragment.helper.b bVar = this.avatarPanelHelper;
        if (bVar != null) {
            bVar.destroy();
        }
    }

    @Override // com.tencent.sqshow.fragment.ZootopiaBaseFragment, androidx.fragment.app.Fragment
    public void onDestroyView() {
        ZPlanUEInputHelperView zPlanUEInputHelperView = this.inputHelperView;
        if (zPlanUEInputHelperView != null) {
            zPlanUEInputHelperView.d();
        }
        super.onDestroyView();
    }

    @Override // com.tencent.mobileqq.zootopia.scene.fragment.base.BaseAvatarWithLoadingFragment, com.tencent.mobileqq.zootopia.scene.fragment.base.BaseAvatarFragment, com.tencent.sqshow.fragment.ZootopiaBaseFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onPause() {
        super.onPause();
        ZootopiaUeModuleManager zootopiaUeModuleManager = this.moduleManager;
        if (zootopiaUeModuleManager != null) {
            zootopiaUeModuleManager.pause();
        }
        ZPlanUEInputHelperView zPlanUEInputHelperView = this.inputHelperView;
        if (zPlanUEInputHelperView != null) {
            zPlanUEInputHelperView.e();
        }
    }

    @Override // com.tencent.mobileqq.zootopia.scene.fragment.base.BaseAvatarWithLoadingFragment, com.tencent.mobileqq.zootopia.scene.fragment.base.BaseAvatarFragment, com.tencent.sqshow.fragment.ZootopiaBaseFragment, com.tencent.sqshow.fragment.ZPlanPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        ZPlanRedDotManager.f373437a.v();
        Ki();
        ZootopiaUeModuleManager zootopiaUeModuleManager = this.moduleManager;
        if (zootopiaUeModuleManager != null) {
            zootopiaUeModuleManager.resume();
        }
        ZPlanUEInputHelperView zPlanUEInputHelperView = this.inputHelperView;
        if (zPlanUEInputHelperView != null) {
            zPlanUEInputHelperView.f();
        }
        FragmentActivity activity = getActivity();
        if (activity != null) {
            qe3.a.d(qe3.a.f428883a, activity, null, 2, null);
        }
    }

    @Override // com.tencent.mobileqq.zootopia.scene.fragment.base.BaseAvatarWithLoadingFragment, com.tencent.sqshow.fragment.ZPlanPublicBaseFragment
    protected boolean rh() {
        return true;
    }

    @Override // com.tencent.mobileqq.zootopia.scene.fragment.base.BaseAvatarWithLoadingFragment, com.tencent.mobileqq.zootopia.scene.fragment.base.BaseAvatarFragment, com.tencent.zplan.engine.ZPlanEngineStatusUpdateListener
    public void serviceConnected(boolean connect) {
        ZootopiaUeModuleManager zootopiaUeModuleManager = this.moduleManager;
        if (zootopiaUeModuleManager != null) {
            zootopiaUeModuleManager.serviceConnected(connect);
        }
        com.tencent.mobileqq.zplan.avatar.impl.fragment.helper.b bVar = this.avatarPanelHelper;
        if (bVar != null) {
            bVar.serviceConnected(connect);
        }
        if (connect) {
            ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.mobileqq.zplan.avatar.impl.fragment.i
                @Override // java.lang.Runnable
                public final void run() {
                    ZPlanAvatarSubSceneFragment.Mi(ZPlanAvatarSubSceneFragment.this);
                }
            });
        }
        super.serviceConnected(connect);
    }

    @Override // pd3.b
    public void w0() {
        QLog.i("ZPlanAvatarSubSceneFragment_", 1, "onLoadingShow");
        this.loadingShowing = true;
        this.loadingLogicEnd = false;
    }

    @Override // com.tencent.sqshow.fragment.ZootopiaBaseFragment
    /* renamed from: xh, reason: from getter */
    public long getFinishDelay() {
        return this.finishDelay;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Gi(View view) {
        QLog.i("ZPlanAvatarSubSceneFragment_", 1, "clicked backgroundIgv");
    }

    @Override // pd3.b
    public void U() {
        this.loadingShowing = false;
    }

    private final void ui(String branchId, Map<String, String> reportMap) {
        if (branchId != null) {
            xi().a(new Event("dt_pgin", 0, 0, null, reportMap, 12, null));
        }
    }

    private final void Ci(ViewGroup container, ViewGroup nativeUIContainer) {
        FragmentActivity activity;
        a84.a fVar;
        if (container == null || (activity = getActivity()) == null) {
            return;
        }
        SceneInfo M2 = M2();
        if (M2.k()) {
            if (c.f331893a[this.engineType.ordinal()] == 1) {
                fVar = f.a.a(FilamentApiImpl.f369933a, null, 1, null);
            } else {
                fVar = new jf3.f();
            }
        } else {
            fVar = new jf3.f();
        }
        a84.a aVar = fVar;
        com.tencent.mobileqq.zplan.avatar.impl.fragment.helper.b bVar = new com.tencent.mobileqq.zplan.avatar.impl.fragment.helper.b(activity, nativeUIContainer, container, Ch(), this.onlyMakeupMode, M2.c() > 0);
        this.avatarPanelHelper = bVar;
        com.tencent.mobileqq.zplan.avatar.impl.fragment.helper.b.m(bVar, M2, aVar.m8(), false, false, 12, null);
        Kh(SceneComponentType.TYPE_AVATAR, aVar);
        com.tencent.mobileqq.zplan.avatar.impl.fragment.helper.b bVar2 = this.avatarPanelHelper;
        if (bVar2 != null) {
            bVar2.q(aVar);
        }
        aVar.gh(this);
        aVar.B6(this);
        aVar.W7(this);
        aVar.Qf(new d());
        aVar.j(activity, this, this, container);
        this.avatarComponent = aVar;
        Ki();
        if (this.engineType == AvatarEngineType.UE) {
            ((IZPlanApi) QRoute.api(IZPlanApi.class)).startEngineWhenNotReady(null, "ZPlanAvatarSubSceneFragment_");
        }
    }

    private final void Di(View rootView) {
        ((Button) rootView.findViewById(R.id.poe)).setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.zplan.avatar.impl.fragment.j
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ZPlanAvatarSubSceneFragment.Ei(ZPlanAvatarSubSceneFragment.this, view);
            }
        });
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void Fi(ViewGroup container) {
        FragmentActivity activity;
        ComponentLoading componentLoading;
        b94.e mControlView;
        c84.a wc5;
        b94.e mControlView2;
        if (container == null || (activity = getActivity()) == null) {
            return;
        }
        com.tencent.mobileqq.zplan.avatar.impl.fragment.helper.b bVar = this.avatarPanelHelper;
        boolean z16 = false;
        int i3 = 1;
        if ((bVar != null && bVar.getMNeedPanelView()) != false) {
            componentLoading = new AvatarMallLoadingComponent(5, "SUB_AVATAR", this.engineType);
        } else {
            componentLoading = new ComponentLoading(null, i3, 0 == true ? 1 : 0);
        }
        com.tencent.mobileqq.zplan.avatar.impl.fragment.helper.b bVar2 = this.avatarPanelHelper;
        if (bVar2 != null && bVar2.getMNeedPanelView()) {
            z16 = true;
        }
        if (z16) {
            com.tencent.mobileqq.zplan.avatar.impl.fragment.helper.b bVar3 = this.avatarPanelHelper;
            if (bVar3 != null && (mControlView2 = bVar3.getMControlView()) != null) {
                mControlView2.q0(new e(componentLoading));
            }
            if (this.onlyMakeupMode) {
                com.tencent.mobileqq.zplan.avatar.impl.fragment.helper.b bVar4 = this.avatarPanelHelper;
                if (bVar4 != null && (mControlView = bVar4.getMControlView()) != null && (wc5 = mControlView.wc()) != null) {
                    componentLoading.N(wc5);
                }
                container.setVisibility(4);
            }
        }
        a84.a aVar = this.avatarComponent;
        if (aVar != null) {
            aVar.q0(new f(componentLoading));
        }
        Kh(SceneComponentType.TYPE_AVATAR_LOADING, componentLoading);
        componentLoading.a0(Ch());
        componentLoading.j(activity, this, this, container);
        if (!((IZPlanApi) QRoute.api(IZPlanApi.class)).isEngineReady()) {
            componentLoading.show();
        }
        componentLoading.Z(this);
        componentLoading.b0(this);
    }

    @Override // com.tencent.mobileqq.zootopia.api.c
    public boolean J5(KeyEvent event) {
        if (event != null && event.getKeyCode() == 4) {
            com.tencent.mobileqq.zplan.avatar.impl.fragment.helper.b bVar = this.avatarPanelHelper;
            if (bVar != null && bVar.getMNeedPanelView()) {
                com.tencent.mobileqq.zplan.avatar.impl.fragment.helper.b bVar2 = this.avatarPanelHelper;
                if (bVar2 != null) {
                    return bVar2.k();
                }
                return false;
            }
        }
        ZootopiaUeModuleManager zootopiaUeModuleManager = this.moduleManager;
        if (zootopiaUeModuleManager != null) {
            return zootopiaUeModuleManager.d(event);
        }
        return false;
    }
}

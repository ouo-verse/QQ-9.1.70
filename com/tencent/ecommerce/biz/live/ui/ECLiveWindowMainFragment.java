package com.tencent.ecommerce.biz.live.ui;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.exifinterface.media.ExifInterface;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.ViewPager2;
import ci0.ECLiveWindowAddEvent;
import ci0.ECLiveWindowContentSizeChangeEvent;
import ci0.ECLiveWindowEditEvent;
import ci0.ECLiveWindowFirstLoadEvent;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.d;
import com.qzone.proxy.personalitycomponent.model.WidgetCacheLunarData;
import com.tencent.ams.dsdk.core.DKEngine;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.ecommerce.base.eventbus.EventObserver;
import com.tencent.ecommerce.base.eventbus.LifecycleEventBus;
import com.tencent.ecommerce.base.eventbus.ThreadMode;
import com.tencent.ecommerce.base.fragment.ECBaseFragment;
import com.tencent.ecommerce.base.ktx.ViewExtKt;
import com.tencent.ecommerce.base.list.IStateCenterView;
import com.tencent.ecommerce.base.report.service.ECShowPageCostTimeScene;
import com.tencent.ecommerce.base.rmonitor.service.ECRMonitorManager;
import com.tencent.ecommerce.base.router.api.IECSchemeCallback;
import com.tencent.ecommerce.base.ui.ECSkin;
import com.tencent.ecommerce.base.ui.skeleton.SkeletonScreen;
import com.tencent.ecommerce.base.ui.stateview.ECStateCenterView;
import com.tencent.ecommerce.biz.live.LiveTabId;
import com.tencent.ecommerce.biz.live.event.ECLiveWindowRemoteUpdateEvent;
import com.tencent.ecommerce.biz.live.ui.viewmodel.ECLiveWindowMainViewModel;
import com.tencent.ecommerce.biz.router.ECScheme;
import com.tencent.ecommerce.repo.live.TabInfo;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqmini.sdk.launcher.MiniSDKConst;
import com.tencent.qqmini.sdk.plugins.SensorJsPlugin;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringNumberConversionsKt;
import kotlin.text.StringsKt__StringsJVMKt;
import mqq.app.Constants;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u00c6\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0013\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b+\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010%\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 \u00a3\u00012\u00020\u00012\u00020\u0002:\u0002\u00a4\u0001B\t\u00a2\u0006\u0006\b\u00a1\u0001\u0010\u00a2\u0001J\b\u0010\u0004\u001a\u00020\u0003H\u0016J\u0012\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0016J\b\u0010\t\u001a\u00020\u0003H\u0016J\u001a\u0010\f\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\n2\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0016J\b\u0010\r\u001a\u00020\u0007H\u0016J\u0012\u0010\u000e\u001a\u00020\u00072\b\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0016J\b\u0010\u0010\u001a\u00020\u000fH\u0016J\b\u0010\u0012\u001a\u00020\u0011H\u0016J\b\u0010\u0013\u001a\u00020\u0007H\u0016J\b\u0010\u0014\u001a\u00020\u0011H\u0016J\b\u0010\u0015\u001a\u00020\u0007H\u0016J\b\u0010\u0016\u001a\u00020\u0007H\u0002J\b\u0010\u0017\u001a\u00020\u0007H\u0002J\b\u0010\u0018\u001a\u00020\u0007H\u0002J\u0010\u0010\u001a\u001a\u00020\u00072\u0006\u0010\u0019\u001a\u00020\nH\u0002J\b\u0010\u001b\u001a\u00020\u0007H\u0002J\b\u0010\u001c\u001a\u00020\u0007H\u0002J\b\u0010\u001d\u001a\u00020\u0007H\u0002J\b\u0010\u001e\u001a\u00020\u0007H\u0002J\b\u0010\u001f\u001a\u00020\u0007H\u0002J\u0010\u0010!\u001a\u00020\u00072\u0006\u0010 \u001a\u00020\u0011H\u0002J\b\u0010\"\u001a\u00020\u0007H\u0002J\b\u0010#\u001a\u00020\u0007H\u0002J\b\u0010$\u001a\u00020\u0007H\u0002J\u0016\u0010(\u001a\u00020\u00072\f\u0010'\u001a\b\u0012\u0004\u0012\u00020&0%H\u0002J\b\u0010)\u001a\u00020\u0011H\u0002J\u0012\u0010+\u001a\u00020\u00072\b\u0010*\u001a\u0004\u0018\u00010&H\u0002J\b\u0010,\u001a\u00020\u0007H\u0002J\b\u0010-\u001a\u00020\u0011H\u0002J\b\u0010.\u001a\u00020\u0007H\u0002J\b\u0010/\u001a\u00020\u0007H\u0002J\b\u00100\u001a\u00020\u0007H\u0002J\b\u00101\u001a\u00020\u0007H\u0002J\b\u00102\u001a\u00020\u0007H\u0002J\b\u00103\u001a\u00020\u0007H\u0002J\b\u00104\u001a\u00020\u0007H\u0002J\b\u00105\u001a\u00020\u0007H\u0002J\b\u00106\u001a\u00020\u0007H\u0002J\b\u00107\u001a\u00020\u0007H\u0002J\b\u00108\u001a\u00020\u0007H\u0002J\u0010\u00109\u001a\u00020\u00072\u0006\u0010*\u001a\u00020&H\u0002J\u0010\u0010;\u001a\u00020\u00072\u0006\u0010:\u001a\u00020\u0011H\u0002J\b\u0010<\u001a\u00020\u0007H\u0002J\u0010\u0010>\u001a\u00020\u00072\u0006\u0010=\u001a\u00020\u0011H\u0002R\u0016\u0010A\u001a\u00020\u00118\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b?\u0010@R\u0016\u0010C\u001a\u00020\u00118\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bB\u0010@R\u0016\u0010F\u001a\u00020\u000f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bD\u0010ER\u0016\u0010H\u001a\u00020\u000f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bG\u0010ER\u0016\u0010K\u001a\u00020\u00038\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bI\u0010JR\u0016\u0010M\u001a\u00020\u000f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bL\u0010ER\u0016\u0010O\u001a\u00020\u00038\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bN\u0010JR\u0016\u0010Q\u001a\u00020\u000f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bP\u0010ER\u0016\u0010U\u001a\u00020R8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bS\u0010TR\u0016\u0010W\u001a\u00020R8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bV\u0010TR\u0016\u0010Z\u001a\u00020X8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b@\u0010YR\u0016\u0010]\u001a\u00020\n8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b[\u0010\\R\u0016\u0010_\u001a\u00020\n8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b^\u0010\\R\u0016\u0010c\u001a\u00020`8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\ba\u0010bR\u0016\u0010e\u001a\u00020`8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bd\u0010bR\u0016\u0010i\u001a\u00020f8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bg\u0010hR\u0016\u0010m\u001a\u00020j8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bk\u0010lR\u0016\u0010q\u001a\u00020n8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bo\u0010pR\u0016\u0010u\u001a\u00020r8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bs\u0010tR\u0016\u0010y\u001a\u00020v8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bw\u0010xR\u0016\u0010}\u001a\u00020z8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b{\u0010|R\u0016\u0010\u007f\u001a\u00020z8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b~\u0010|R\u0018\u0010\u0081\u0001\u001a\u00020z8\u0002@\u0002X\u0082.\u00a2\u0006\u0007\n\u0005\b\u0080\u0001\u0010|R\u001a\u0010\u0085\u0001\u001a\u00030\u0082\u00018\u0002@\u0002X\u0082.\u00a2\u0006\b\n\u0006\b\u0083\u0001\u0010\u0084\u0001R\u0018\u0010\u0087\u0001\u001a\u00020\n8\u0002@\u0002X\u0082.\u00a2\u0006\u0007\n\u0005\b\u0086\u0001\u0010\\R\u001a\u0010\u008b\u0001\u001a\u00030\u0088\u00018\u0002@\u0002X\u0082.\u00a2\u0006\b\n\u0006\b\u0089\u0001\u0010\u008a\u0001R\u001a\u0010\u008f\u0001\u001a\u00030\u008c\u00018\u0002@\u0002X\u0082.\u00a2\u0006\b\n\u0006\b\u008d\u0001\u0010\u008e\u0001R\u0018\u0010\u0093\u0001\u001a\u00030\u0090\u00018\u0002X\u0082\u0004\u00a2\u0006\b\n\u0006\b\u0091\u0001\u0010\u0092\u0001R\u001c\u0010\u0097\u0001\u001a\u0005\u0018\u00010\u0094\u00018\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u0095\u0001\u0010\u0096\u0001R'\u0010\u009c\u0001\u001a\u0010\u0012\u0004\u0012\u00020\u000f\u0012\u0005\u0012\u00030\u0099\u00010\u0098\u00018\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u009a\u0001\u0010\u009b\u0001R\u001c\u0010\u00a0\u0001\u001a\u0005\u0018\u00010\u009d\u00018\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u009e\u0001\u0010\u009f\u0001\u00a8\u0006\u00a5\u0001"}, d2 = {"Lcom/tencent/ecommerce/biz/live/ui/ECLiveWindowMainFragment;", "Lcom/tencent/ecommerce/base/fragment/ECBaseFragment;", "Landroid/view/View$OnClickListener;", "", "uh", "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, "", "onCreate", "getContentLayoutId", "Landroid/view/View;", "view", DKEngine.ExtraEvent.EXTRA_EVENT_ON_VIEW_CREATED, "onDestroyView", NodeProps.ON_CLICK, "", "getBusinessDescription", "", "onBackPressed", "onResume", "Eh", MiniSDKConst.NOTIFY_EVENT_ONPAUSE, "initArguments", "zi", "Fi", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "initUI", "Ki", "xi", "Ai", WidgetCacheLunarData.YI, "Li", "isEditable", "Ni", "ni", "mi", "li", "", "Lcom/tencent/ecommerce/repo/live/TabInfo;", "tabList", "oi", "Ei", "tabInfo", "pi", "doEnterAnim", "Di", "qi", "ri", "Hi", "Gi", "Mi", SensorJsPlugin.SENSOR_INTERVAL_UI, "ti", "vi", "Bi", "si", "Ci", "wi", "isSuccess", "Ii", "ki", "isWindowShow", "Ji", "P", "Z", "isLiveOpened", AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, "isMaster", BdhLogUtil.LogTag.Tag_Req, "Ljava/lang/String;", "userId", ExifInterface.LATITUDE_SOUTH, "roomId", "T", "I", WadlProxyConsts.CHANNEL, "U", "programId", "V", "liveType", "W", "couponId", "", "X", "J", "livePlayTimeSec", "Y", "windowInitTimeMs", "Lcom/tencent/ecommerce/biz/live/ui/viewmodel/ECLiveWindowMainViewModel;", "Lcom/tencent/ecommerce/biz/live/ui/viewmodel/ECLiveWindowMainViewModel;", "viewModel", "a0", "Landroid/view/View;", "emptyOutside", "b0", "rootContainer", "Landroid/view/animation/Animation;", "c0", "Landroid/view/animation/Animation;", "enterAnim", "d0", "exitAnim", "Lcom/tencent/ecommerce/base/ui/stateview/ECStateCenterView;", "e0", "Lcom/tencent/ecommerce/base/ui/stateview/ECStateCenterView;", "stateView", "Landroidx/recyclerview/widget/RecyclerView;", "f0", "Landroidx/recyclerview/widget/RecyclerView;", "recycleView", "Lcom/tencent/ecommerce/base/ui/skeleton/SkeletonScreen;", "g0", "Lcom/tencent/ecommerce/base/ui/skeleton/SkeletonScreen;", "skeleton", "Lcom/tencent/ecommerce/biz/live/ui/ECLiveWindowTitleBar;", "h0", "Lcom/tencent/ecommerce/biz/live/ui/ECLiveWindowTitleBar;", "titleBarContainer", "Landroid/widget/ImageView;", "i0", "Landroid/widget/ImageView;", "backBtn", "Landroid/widget/TextView;", "j0", "Landroid/widget/TextView;", "windowCenterTitle", "k0", "addProductBtn", "l0", "operatorBtn", "Lcom/google/android/material/tabs/TabLayout;", "m0", "Lcom/google/android/material/tabs/TabLayout;", "tabLayout", "n0", "tablayoutMask", "Landroidx/viewpager2/widget/ViewPager2;", "o0", "Landroidx/viewpager2/widget/ViewPager2;", "viewPager", "Lfi0/b;", "p0", "Lfi0/b;", "fragmentAdapter", "Lcom/tencent/ecommerce/base/report/service/k;", "q0", "Lcom/tencent/ecommerce/base/report/service/k;", "showPageCostTime", "Lcom/tencent/ecommerce/biz/live/ui/ECLiveWindowSubFragment;", "r0", "Lcom/tencent/ecommerce/biz/live/ui/ECLiveWindowSubFragment;", "currentFragment", "", "", "s0", "Ljava/util/Map;", "schemeCallbackParams", "Lcom/tencent/ecommerce/base/router/api/IECSchemeCallback;", "t0", "Lcom/tencent/ecommerce/base/router/api/IECSchemeCallback;", "schemeCallback", "<init>", "()V", "u0", "a", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes31.dex */
public final class ECLiveWindowMainFragment extends ECBaseFragment implements View.OnClickListener {

    /* renamed from: P, reason: from kotlin metadata */
    private boolean isLiveOpened;

    /* renamed from: Q, reason: from kotlin metadata */
    private boolean isMaster;

    /* renamed from: T, reason: from kotlin metadata */
    private int channel;

    /* renamed from: V, reason: from kotlin metadata */
    private int liveType;

    /* renamed from: X, reason: from kotlin metadata */
    private long livePlayTimeSec;

    /* renamed from: Y, reason: from kotlin metadata */
    private long windowInitTimeMs;

    /* renamed from: Z, reason: from kotlin metadata */
    private ECLiveWindowMainViewModel viewModel;

    /* renamed from: a0, reason: collision with root package name and from kotlin metadata */
    private View emptyOutside;

    /* renamed from: b0, reason: collision with root package name and from kotlin metadata */
    private View rootContainer;

    /* renamed from: c0, reason: collision with root package name and from kotlin metadata */
    private Animation enterAnim;

    /* renamed from: d0, reason: collision with root package name and from kotlin metadata */
    private Animation exitAnim;

    /* renamed from: e0, reason: collision with root package name and from kotlin metadata */
    private ECStateCenterView stateView;

    /* renamed from: f0, reason: collision with root package name and from kotlin metadata */
    private RecyclerView recycleView;

    /* renamed from: g0, reason: collision with root package name and from kotlin metadata */
    private SkeletonScreen skeleton;

    /* renamed from: h0, reason: collision with root package name and from kotlin metadata */
    private ECLiveWindowTitleBar titleBarContainer;

    /* renamed from: i0, reason: collision with root package name and from kotlin metadata */
    private ImageView backBtn;

    /* renamed from: j0, reason: collision with root package name and from kotlin metadata */
    private TextView windowCenterTitle;

    /* renamed from: k0, reason: collision with root package name and from kotlin metadata */
    private TextView addProductBtn;

    /* renamed from: l0, reason: collision with root package name and from kotlin metadata */
    private TextView operatorBtn;

    /* renamed from: m0, reason: collision with root package name and from kotlin metadata */
    private TabLayout tabLayout;

    /* renamed from: n0, reason: collision with root package name and from kotlin metadata */
    private View tablayoutMask;

    /* renamed from: o0, reason: collision with root package name and from kotlin metadata */
    private ViewPager2 viewPager;

    /* renamed from: p0, reason: collision with root package name and from kotlin metadata */
    private fi0.b fragmentAdapter;

    /* renamed from: r0, reason: collision with root package name and from kotlin metadata */
    private ECLiveWindowSubFragment currentFragment;

    /* renamed from: t0, reason: collision with root package name and from kotlin metadata */
    private IECSchemeCallback schemeCallback;

    /* renamed from: R, reason: from kotlin metadata */
    private String userId = "";

    /* renamed from: S, reason: from kotlin metadata */
    private String roomId = "";

    /* renamed from: U, reason: from kotlin metadata */
    private String programId = "";

    /* renamed from: W, reason: from kotlin metadata */
    private String couponId = "";

    /* renamed from: q0, reason: collision with root package name and from kotlin metadata */
    private final com.tencent.ecommerce.base.report.service.k showPageCostTime = new com.tencent.ecommerce.base.report.service.k(ECShowPageCostTimeScene.SHOW_COST_TIME_SCENE_LIVE_WINDOW);

    /* renamed from: s0, reason: collision with root package name and from kotlin metadata */
    private Map<String, Object> schemeCallbackParams = new LinkedHashMap();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0002H\n\u00a2\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"Lcom/google/android/material/tabs/TabLayout$g;", "tab", "", "position", "", "a", "(Lcom/google/android/material/tabs/TabLayout$g;I)V"}, k = 3, mv = {1, 4, 1})
    /* loaded from: classes31.dex */
    public static final class c implements d.b {
        c() {
        }

        @Override // com.google.android.material.tabs.d.b
        public final void a(TabLayout.g gVar, int i3) {
            TabInfo S1 = ECLiveWindowMainFragment.Yh(ECLiveWindowMainFragment.this).S1(i3);
            if (S1 != null) {
                gVar.t(S1.name + '(' + S1.getTotal() + ')');
                ei0.d.f396304b.m(gVar.f34288i, S1.id);
            }
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/ecommerce/biz/live/ui/ECLiveWindowMainFragment$d", "Lcom/tencent/ecommerce/base/router/api/IECSchemeCallback;", "Lorg/json/JSONObject;", "data", "", "onCallbackFinished", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
    /* loaded from: classes31.dex */
    public static final class d implements IECSchemeCallback {
        d() {
        }

        @Override // com.tencent.ecommerce.base.router.api.IECSchemeCallback
        public void onCallbackFinished(JSONObject data) {
            Long longOrNull;
            boolean optBoolean = data.optBoolean("need_update");
            LiveTabId a16 = LiveTabId.INSTANCE.a(data.optInt("live_tab_id"));
            if (optBoolean) {
                com.tencent.ecommerce.biz.live.a aVar = com.tencent.ecommerce.biz.live.a.f102661d;
                boolean z16 = ECLiveWindowMainFragment.this.isMaster;
                int i3 = ECLiveWindowMainFragment.this.channel;
                String str = ECLiveWindowMainFragment.this.userId;
                longOrNull = StringsKt__StringNumberConversionsKt.toLongOrNull(ECLiveWindowMainFragment.this.roomId);
                aVar.r(0, a16, z16, i3, null, str, longOrNull != null ? longOrNull.longValue() : 0L);
            }
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/ecommerce/biz/live/ui/ECLiveWindowMainFragment$e", "Lcom/tencent/ecommerce/base/eventbus/EventObserver;", "Lcom/tencent/ecommerce/biz/live/event/ECLiveWindowRemoteUpdateEvent;", "updateEvent", "", "a", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
    /* loaded from: classes31.dex */
    public static final class e implements EventObserver<ECLiveWindowRemoteUpdateEvent> {
        e() {
        }

        @Override // com.tencent.ecommerce.base.eventbus.EventObserver
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onEvent(ECLiveWindowRemoteUpdateEvent updateEvent) {
            cg0.a.b("ECLiveWindowMainFragment", "OnEventBus LiveWindowUpdateEvent: " + updateEvent);
            if (updateEvent.event != 3) {
                return;
            }
            ECLiveWindowMainFragment.this.ri();
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/ecommerce/biz/live/ui/ECLiveWindowMainFragment$f", "Lcom/tencent/ecommerce/base/eventbus/EventObserver;", "Lci0/b;", "event", "", "a", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
    /* loaded from: classes31.dex */
    public static final class f implements EventObserver<ECLiveWindowContentSizeChangeEvent> {
        f() {
        }

        @Override // com.tencent.ecommerce.base.eventbus.EventObserver
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onEvent(ECLiveWindowContentSizeChangeEvent event) {
            cg0.a.b("ECLiveWindowMainFragment", "OnEventBus LiveWindowContentSizeChangeEvent: " + event);
            ECLiveWindowMainFragment.Yh(ECLiveWindowMainFragment.this).e2(event.tabId, event.getListSize());
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/ecommerce/biz/live/ui/ECLiveWindowMainFragment$g", "Lcom/tencent/ecommerce/base/eventbus/EventObserver;", "Lci0/d;", "event", "", "a", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
    /* loaded from: classes31.dex */
    public static final class g implements EventObserver<ECLiveWindowFirstLoadEvent> {
        g() {
        }

        @Override // com.tencent.ecommerce.base.eventbus.EventObserver
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onEvent(ECLiveWindowFirstLoadEvent event) {
            Integer value;
            if (event.tabId == ECLiveWindowMainFragment.Yh(ECLiveWindowMainFragment.this).Q1() && (value = ECLiveWindowMainFragment.Yh(ECLiveWindowMainFragment.this).R1().getValue()) != null && value.intValue() == 1) {
                cg0.a.b("ECLiveWindowMainFragment", "OnEventBus LiveWindowFirstLoadEvent: " + event);
                ECLiveWindowMainFragment.Yh(ECLiveWindowMainFragment.this).c2(event.getSuccess() ? 2 : 3);
            }
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/ecommerce/biz/live/ui/ECLiveWindowMainFragment$h", "Lcom/tencent/ecommerce/base/eventbus/EventObserver;", "Lci0/g;", "event", "", "a", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
    /* loaded from: classes31.dex */
    public static final class h implements EventObserver<ci0.g> {
        h() {
        }

        @Override // com.tencent.ecommerce.base.eventbus.EventObserver
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onEvent(ci0.g event) {
            ECLiveWindowMainFragment.this.wi(event.tabInfo);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/ecommerce/biz/live/ui/ECLiveWindowMainFragment$i", "Lcom/tencent/ecommerce/base/eventbus/EventObserver;", "Lci0/h;", "event", "", "a", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
    /* loaded from: classes31.dex */
    public static final class i implements EventObserver<ci0.h> {
        i() {
        }

        @Override // com.tencent.ecommerce.base.eventbus.EventObserver
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onEvent(ci0.h event) {
            ECLiveWindowMainFragment.Wh(ECLiveWindowMainFragment.this).setIsTouchable(event.isTouchable);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/ecommerce/biz/live/ui/ECLiveWindowMainFragment$j", "Lcom/tencent/ecommerce/base/eventbus/EventObserver;", "Lci0/a;", "event", "", "a", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
    /* loaded from: classes31.dex */
    public static final class j implements EventObserver<ECLiveWindowAddEvent> {
        j() {
        }

        @Override // com.tencent.ecommerce.base.eventbus.EventObserver
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onEvent(ECLiveWindowAddEvent event) {
            if (event.getTabId() == ECLiveWindowMainFragment.Yh(ECLiveWindowMainFragment.this).Q1()) {
                ECLiveWindowMainFragment.this.Ci();
                return;
            }
            cg0.a.a("ECLiveWindowMainFragment", "ECLiveWindowAddEvent onEvent wrong tabId", "event:" + event + ", curTabId:" + ECLiveWindowMainFragment.Yh(ECLiveWindowMainFragment.this).Q1());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0005\u001a\u00020\u00042\u001a\u0010\u0003\u001a\u0016\u0012\u0004\u0012\u00020\u0001 \u0002*\n\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u00000\u0000H\n\u00a2\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"", "Lcom/tencent/ecommerce/repo/live/TabInfo;", "kotlin.jvm.PlatformType", "it", "", "a", "(Ljava/util/List;)V"}, k = 3, mv = {1, 4, 1})
    /* loaded from: classes31.dex */
    public static final class k<T> implements Observer<List<? extends TabInfo>> {
        k() {
        }

        @Override // androidx.lifecycle.Observer
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final void onChanged(List<TabInfo> list) {
            if (!list.isEmpty()) {
                ECLiveWindowMainFragment.this.xi();
                ECLiveWindowMainFragment.Uh(ECLiveWindowMainFragment.this).setSucceededState();
                ECLiveWindowMainFragment.Qh(ECLiveWindowMainFragment.this).setData(list);
                ECLiveWindowMainFragment.this.oi(list);
                int M1 = ECLiveWindowMainFragment.Yh(ECLiveWindowMainFragment.this).M1();
                cg0.a.b("ECLiveWindowMainFragment", "LiveDataChange tabListLiveData onChange, size:" + list.size() + " targetIndex:" + M1);
                if (M1 > -1) {
                    ECLiveWindowMainFragment.Zh(ECLiveWindowMainFragment.this).setCurrentItem(M1, false);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0004\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n\u00a2\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Lcom/tencent/ecommerce/repo/live/TabInfo;", "kotlin.jvm.PlatformType", "it", "", "a", "(Lcom/tencent/ecommerce/repo/live/TabInfo;)V"}, k = 3, mv = {1, 4, 1})
    /* loaded from: classes31.dex */
    public static final class l<T> implements Observer<TabInfo> {
        l() {
        }

        @Override // androidx.lifecycle.Observer
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final void onChanged(TabInfo tabInfo) {
            cg0.a.b("ECLiveWindowMainFragment", "LiveDataChange curTabLiveData onChange, value:" + tabInfo);
            if (tabInfo == null || !ECLiveWindowMainFragment.this.isMaster) {
                return;
            }
            if (tabInfo.allowEdit) {
                ECLiveWindowMainFragment.Rh(ECLiveWindowMainFragment.this).setEnabled(true);
                ECLiveWindowMainFragment.Nh(ECLiveWindowMainFragment.this).setEnabled(true);
            } else {
                ECLiveWindowMainFragment.Rh(ECLiveWindowMainFragment.this).setEnabled(false);
                ECLiveWindowMainFragment.Nh(ECLiveWindowMainFragment.this).setEnabled(false);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0004\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n\u00a2\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"", "kotlin.jvm.PlatformType", "it", "", "a", "(Ljava/lang/Boolean;)V"}, k = 3, mv = {1, 4, 1})
    /* loaded from: classes31.dex */
    public static final class m<T> implements Observer<Boolean> {
        m() {
        }

        @Override // androidx.lifecycle.Observer
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final void onChanged(Boolean bool) {
            cg0.a.b("ECLiveWindowMainFragment", "LiveDataChange curTabEditableLiveData , value:" + bool);
            LifecycleEventBus.f100688b.f(new ECLiveWindowEditEvent(ECLiveWindowMainFragment.Yh(ECLiveWindowMainFragment.this).Q1(), bool.booleanValue()));
            ECLiveWindowMainFragment.Zh(ECLiveWindowMainFragment.this).setUserInputEnabled(bool.booleanValue() ^ true);
            ECLiveWindowMainFragment.this.Ni(bool.booleanValue());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0004\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n\u00a2\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"", "kotlin.jvm.PlatformType", "it", "", "a", "(Ljava/lang/Boolean;)V"}, k = 3, mv = {1, 4, 1})
    /* loaded from: classes31.dex */
    public static final class n<T> implements Observer<Boolean> {
        n() {
        }

        @Override // androidx.lifecycle.Observer
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final void onChanged(Boolean bool) {
            cg0.a.b("ECLiveWindowMainFragment", "LiveDataChange contentSizeChangeLiveData , value:" + bool);
            ECLiveWindowMainFragment.this.Mi();
        }
    }

    private final void Ai() {
        this.tabLayout = (TabLayout) yh().findViewById(R.id.f163110oc4);
        View findViewById = yh().findViewById(R.id.obx);
        this.tablayoutMask = findViewById;
        if (findViewById == null) {
            Intrinsics.throwUninitializedPropertyAccessException("tablayoutMask");
        }
        ECSkin eCSkin = ECSkin.INSTANCE;
        findViewById.setBackground(eCSkin.getDrawable(R.drawable.d08));
        Integer color = eCSkin.getColor("qecommerce_skin_color_text_primary");
        if (color != null) {
            int intValue = color.intValue();
            TabLayout tabLayout = this.tabLayout;
            if (tabLayout == null) {
                Intrinsics.throwUninitializedPropertyAccessException("tabLayout");
            }
            tabLayout.setSelectedTabIndicatorColor(intValue);
            TabLayout tabLayout2 = this.tabLayout;
            if (tabLayout2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("tabLayout");
            }
            tabLayout2.setTabTextColors(intValue, intValue);
        }
        TabLayout tabLayout3 = this.tabLayout;
        if (tabLayout3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("tabLayout");
        }
        ViewPager2 viewPager2 = this.viewPager;
        if (viewPager2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewPager");
        }
        new com.google.android.material.tabs.d(tabLayout3, viewPager2, new c()).a();
        TabLayout tabLayout4 = this.tabLayout;
        if (tabLayout4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("tabLayout");
        }
        tabLayout4.f(new ECLiveWindowMainFragment$initTitleBarUI$3(this));
        if (this.isMaster) {
            if (this.isLiveOpened) {
                ImageView imageView = this.backBtn;
                if (imageView == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("backBtn");
                }
                imageView.setVisibility(8);
                TextView textView = this.operatorBtn;
                if (textView == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("operatorBtn");
                }
                textView.setVisibility(0);
                TextView textView2 = this.addProductBtn;
                if (textView2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("addProductBtn");
                }
                textView2.setVisibility(0);
                return;
            }
            ImageView imageView2 = this.backBtn;
            if (imageView2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("backBtn");
            }
            imageView2.setVisibility(8);
            TextView textView3 = this.operatorBtn;
            if (textView3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("operatorBtn");
            }
            textView3.setVisibility(8);
            TextView textView4 = this.addProductBtn;
            if (textView4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("addProductBtn");
            }
            textView4.setVisibility(0);
            yi();
            return;
        }
        li();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Ci() {
        String str;
        ECLiveWindowSubFragment eCLiveWindowSubFragment = this.currentFragment;
        if (eCLiveWindowSubFragment == null || (str = eCLiveWindowSubFragment.Gi()) == null) {
            str = "mqqapi://ecommerce/open?target=7&channel=8&window_type=3&src_type=internal&version=1";
        }
        StringBuilder sb5 = new StringBuilder();
        sb5.append(str);
        sb5.append("&live_user_id=");
        sb5.append(this.userId);
        sb5.append("&live_room_id=");
        sb5.append(this.roomId);
        sb5.append("&live_tab_id=");
        ECLiveWindowMainViewModel eCLiveWindowMainViewModel = this.viewModel;
        if (eCLiveWindowMainViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        }
        sb5.append(eCLiveWindowMainViewModel.Q1());
        ECScheme.f(sb5.toString(), new d(), null, 4, null);
    }

    private final boolean Di() {
        View view = this.rootContainer;
        if (view == null) {
            Intrinsics.throwUninitializedPropertyAccessException("rootContainer");
        }
        return view.getVisibility() == 0;
    }

    private final boolean Ei() {
        ECLiveWindowMainViewModel eCLiveWindowMainViewModel = this.viewModel;
        if (eCLiveWindowMainViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        }
        return !Intrinsics.areEqual(eCLiveWindowMainViewModel.O1().getValue(), Boolean.TRUE);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Fi() {
        boolean isBlank;
        ECLiveWindowMainViewModel eCLiveWindowMainViewModel = this.viewModel;
        if (eCLiveWindowMainViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        }
        isBlank = StringsKt__StringsJVMKt.isBlank(this.couponId);
        eCLiveWindowMainViewModel.X1(!isBlank);
    }

    private final void Gi() {
        LifecycleEventBus lifecycleEventBus = LifecycleEventBus.f100688b;
        ThreadMode threadMode = ThreadMode.MAIN;
        lifecycleEventBus.c(threadMode, this, ECLiveWindowRemoteUpdateEvent.class, new e());
        lifecycleEventBus.c(threadMode, this, ECLiveWindowContentSizeChangeEvent.class, new f());
        lifecycleEventBus.c(threadMode, this, ECLiveWindowFirstLoadEvent.class, new g());
        lifecycleEventBus.c(threadMode, this, ci0.g.class, new h());
        lifecycleEventBus.c(threadMode, this, ci0.h.class, new i());
        lifecycleEventBus.c(threadMode, this, ECLiveWindowAddEvent.class, new j());
    }

    private final void Hi() {
        ECLiveWindowMainViewModel eCLiveWindowMainViewModel = this.viewModel;
        if (eCLiveWindowMainViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        }
        eCLiveWindowMainViewModel.R1().observe(getViewLifecycleOwner(), new Observer<Integer>() { // from class: com.tencent.ecommerce.biz.live.ui.ECLiveWindowMainFragment$registerLiveDataObserver$1
            @Override // androidx.lifecycle.Observer
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public final void onChanged(Integer num) {
                String string;
                String string2;
                cg0.a.b("ECLiveWindowMainFragment", "LiveDataChange refreshStatusLiveData onChange, value:" + num);
                if (num != null && num.intValue() == 1) {
                    if (ECLiveWindowMainFragment.Yh(ECLiveWindowMainFragment.this).W1()) {
                        ECLiveWindowMainFragment.this.Ki();
                        ECLiveWindowMainFragment.Uh(ECLiveWindowMainFragment.this).setVisibility(8);
                        return;
                    }
                    return;
                }
                if (num != null && num.intValue() == 2) {
                    ECLiveWindowMainFragment.this.xi();
                    if (ECLiveWindowMainFragment.Yh(ECLiveWindowMainFragment.this).W1()) {
                        if (ECLiveWindowMainFragment.this.isMaster) {
                            ECStateCenterView Uh = ECLiveWindowMainFragment.Uh(ECLiveWindowMainFragment.this);
                            FragmentActivity activity = ECLiveWindowMainFragment.this.getActivity();
                            IStateCenterView.a.a(Uh, (activity == null || (string2 = activity.getString(R.string.wls)) == null) ? "" : string2, null, 0, 6, null);
                        } else {
                            ECStateCenterView Uh2 = ECLiveWindowMainFragment.Uh(ECLiveWindowMainFragment.this);
                            FragmentActivity activity2 = ECLiveWindowMainFragment.this.getActivity();
                            IStateCenterView.a.a(Uh2, (activity2 == null || (string = activity2.getString(R.string.wlr)) == null) ? "" : string, null, 0, 6, null);
                        }
                        ECLiveWindowMainFragment.Uh(ECLiveWindowMainFragment.this).setVisibility(0);
                    } else {
                        ECLiveWindowMainFragment.Uh(ECLiveWindowMainFragment.this).setSucceededState();
                        ECLiveWindowMainFragment.this.Mi();
                    }
                    ECLiveWindowMainFragment.this.Ii(true);
                    return;
                }
                if (num != null && num.intValue() == 3) {
                    ECLiveWindowMainFragment.this.xi();
                    if (ECLiveWindowMainFragment.Yh(ECLiveWindowMainFragment.this).W1()) {
                        ECLiveWindowMainFragment.Uh(ECLiveWindowMainFragment.this).setRetryListener(new Function0<Unit>() { // from class: com.tencent.ecommerce.biz.live.ui.ECLiveWindowMainFragment$registerLiveDataObserver$1.1
                            {
                                super(0);
                            }

                            @Override // kotlin.jvm.functions.Function0
                            public /* bridge */ /* synthetic */ Unit invoke() {
                                invoke2();
                                return Unit.INSTANCE;
                            }

                            /* renamed from: invoke, reason: avoid collision after fix types in other method */
                            public final void invoke2() {
                                ECLiveWindowMainFragment.this.Fi();
                            }
                        });
                        ECLiveWindowMainFragment.Uh(ECLiveWindowMainFragment.this).setFailedState("");
                        ECLiveWindowMainFragment.Uh(ECLiveWindowMainFragment.this).setVisibility(0);
                    } else {
                        ECLiveWindowMainFragment.Uh(ECLiveWindowMainFragment.this).setSucceededState();
                    }
                    ECLiveWindowMainFragment.this.Ii(false);
                }
            }
        });
        ECLiveWindowMainViewModel eCLiveWindowMainViewModel2 = this.viewModel;
        if (eCLiveWindowMainViewModel2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        }
        eCLiveWindowMainViewModel2.T1().observe(getViewLifecycleOwner(), new k());
        ECLiveWindowMainViewModel eCLiveWindowMainViewModel3 = this.viewModel;
        if (eCLiveWindowMainViewModel3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        }
        eCLiveWindowMainViewModel3.P1().observe(getViewLifecycleOwner(), new l());
        ECLiveWindowMainViewModel eCLiveWindowMainViewModel4 = this.viewModel;
        if (eCLiveWindowMainViewModel4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        }
        eCLiveWindowMainViewModel4.O1().observe(getViewLifecycleOwner(), new m());
        ECLiveWindowMainViewModel eCLiveWindowMainViewModel5 = this.viewModel;
        if (eCLiveWindowMainViewModel5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        }
        eCLiveWindowMainViewModel5.N1().observe(getViewLifecycleOwner(), new n());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Ii(boolean isSuccess) {
        Map<Object, ? extends Object> d16 = new com.tencent.ecommerce.base.report.service.m().a(this.isMaster).c(isSuccess ? 2 : 3).d();
        this.showPageCostTime.b(d16);
        cg0.a.b("ECLiveWindowMainFragment", "[reportShowPageCostWhenGetNetworkData] params = " + d16);
    }

    private final void Ji(boolean isWindowShow) {
        Intent intent = new Intent("com.tencent.ecommerce.biz.live_window");
        intent.putExtra("isWindowShow", isWindowShow);
        cg0.a.b("ECLiveWindowMainFragment", "[sendBroadcast] isWindowShow = " + isWindowShow);
        requireContext().sendBroadcast(intent);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Ki() {
        RecyclerView recyclerView = this.recycleView;
        if (recyclerView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("recycleView");
        }
        recyclerView.setVisibility(0);
        SkeletonScreen skeletonScreen = this.skeleton;
        if (skeletonScreen == null) {
            Intrinsics.throwUninitializedPropertyAccessException("skeleton");
        }
        skeletonScreen.show();
    }

    private final void Li() {
        TabLayout tabLayout = this.tabLayout;
        if (tabLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("tabLayout");
        }
        tabLayout.setVisibility(0);
        View view = this.tablayoutMask;
        if (view == null) {
            Intrinsics.throwUninitializedPropertyAccessException("tablayoutMask");
        }
        view.setVisibility(0);
        TextView textView = this.windowCenterTitle;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("windowCenterTitle");
        }
        textView.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Mi() {
        String valueOf;
        TabLayout tabLayout = this.tabLayout;
        if (tabLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("tabLayout");
        }
        int C = tabLayout.C();
        for (int i3 = 0; i3 < C; i3++) {
            TabLayout tabLayout2 = this.tabLayout;
            if (tabLayout2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("tabLayout");
            }
            TabLayout.g B = tabLayout2.B(i3);
            if (B != null) {
                ECLiveWindowMainViewModel eCLiveWindowMainViewModel = this.viewModel;
                if (eCLiveWindowMainViewModel == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("viewModel");
                }
                TabInfo S1 = eCLiveWindowMainViewModel.S1(i3);
                if (S1 != null) {
                    if (S1.getTotal() > 0) {
                        valueOf = S1.name + '(' + S1.getTotal() + ')';
                    } else {
                        valueOf = String.valueOf(S1.name);
                    }
                    B.t(valueOf);
                }
            }
        }
        TextView textView = this.windowCenterTitle;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("windowCenterTitle");
        }
        if (textView.getVisibility() == 0) {
            ECLiveWindowMainViewModel eCLiveWindowMainViewModel2 = this.viewModel;
            if (eCLiveWindowMainViewModel2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            }
            pi(eCLiveWindowMainViewModel2.P1().getValue());
        }
    }

    public static final /* synthetic */ TextView Nh(ECLiveWindowMainFragment eCLiveWindowMainFragment) {
        TextView textView = eCLiveWindowMainFragment.addProductBtn;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("addProductBtn");
        }
        return textView;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Ni(boolean isEditable) {
        if (this.isMaster) {
            if (isEditable) {
                mi();
            } else {
                ni();
            }
        }
    }

    public static final /* synthetic */ fi0.b Qh(ECLiveWindowMainFragment eCLiveWindowMainFragment) {
        fi0.b bVar = eCLiveWindowMainFragment.fragmentAdapter;
        if (bVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("fragmentAdapter");
        }
        return bVar;
    }

    public static final /* synthetic */ TextView Rh(ECLiveWindowMainFragment eCLiveWindowMainFragment) {
        TextView textView = eCLiveWindowMainFragment.operatorBtn;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("operatorBtn");
        }
        return textView;
    }

    public static final /* synthetic */ ECStateCenterView Uh(ECLiveWindowMainFragment eCLiveWindowMainFragment) {
        ECStateCenterView eCStateCenterView = eCLiveWindowMainFragment.stateView;
        if (eCStateCenterView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("stateView");
        }
        return eCStateCenterView;
    }

    public static final /* synthetic */ TabLayout Vh(ECLiveWindowMainFragment eCLiveWindowMainFragment) {
        TabLayout tabLayout = eCLiveWindowMainFragment.tabLayout;
        if (tabLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("tabLayout");
        }
        return tabLayout;
    }

    public static final /* synthetic */ ECLiveWindowTitleBar Wh(ECLiveWindowMainFragment eCLiveWindowMainFragment) {
        ECLiveWindowTitleBar eCLiveWindowTitleBar = eCLiveWindowMainFragment.titleBarContainer;
        if (eCLiveWindowTitleBar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("titleBarContainer");
        }
        return eCLiveWindowTitleBar;
    }

    public static final /* synthetic */ ECLiveWindowMainViewModel Yh(ECLiveWindowMainFragment eCLiveWindowMainFragment) {
        ECLiveWindowMainViewModel eCLiveWindowMainViewModel = eCLiveWindowMainFragment.viewModel;
        if (eCLiveWindowMainViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        }
        return eCLiveWindowMainViewModel;
    }

    public static final /* synthetic */ ViewPager2 Zh(ECLiveWindowMainFragment eCLiveWindowMainFragment) {
        ViewPager2 viewPager2 = eCLiveWindowMainFragment.viewPager;
        if (viewPager2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewPager");
        }
        return viewPager2;
    }

    private final void doEnterAnim() {
        this.enterAnim = AnimationUtils.loadAnimation(getActivity(), R.anim.f1676);
        View view = this.rootContainer;
        if (view == null) {
            Intrinsics.throwUninitializedPropertyAccessException("rootContainer");
        }
        view.clearAnimation();
        View view2 = this.rootContainer;
        if (view2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("rootContainer");
        }
        Animation animation = this.enterAnim;
        if (animation == null) {
            Intrinsics.throwUninitializedPropertyAccessException("enterAnim");
        }
        view2.startAnimation(animation);
    }

    private final void initArguments() {
        String str;
        Intent intent;
        FragmentActivity activity = getActivity();
        Bundle bundle = null;
        Intent intent2 = activity != null ? activity.getIntent() : null;
        Bundle arguments = getArguments();
        if (arguments == null || (str = arguments.getString("scheme_callback_id")) == null) {
            str = "";
        }
        this.schemeCallback = ug0.a.b(str);
        if (intent2 != null) {
            this.isLiveOpened = Intrinsics.areEqual(intent2.getStringExtra("is_live_opened"), "1");
            this.isMaster = Intrinsics.areEqual(intent2.getStringExtra("is_master"), "1");
            String stringExtra = intent2.getStringExtra("live_user_id");
            if (stringExtra == null) {
                stringExtra = "";
            }
            this.userId = stringExtra;
            String stringExtra2 = intent2.getStringExtra("live_room_id");
            if (stringExtra2 == null) {
                stringExtra2 = "0";
            }
            this.roomId = stringExtra2;
            String stringExtra3 = intent2.getStringExtra(WadlProxyConsts.CHANNEL);
            if (stringExtra3 == null) {
                stringExtra3 = "0";
            }
            this.channel = Integer.parseInt(stringExtra3);
            String stringExtra4 = intent2.getStringExtra("live_play_time");
            if (stringExtra4 == null) {
                stringExtra4 = "0";
            }
            this.livePlayTimeSec = Long.parseLong(stringExtra4);
            String stringExtra5 = intent2.getStringExtra("live_program_id");
            if (stringExtra5 == null) {
                stringExtra5 = "";
            }
            this.programId = stringExtra5;
            String stringExtra6 = intent2.getStringExtra("live_type");
            this.liveType = Integer.parseInt(stringExtra6 != null ? stringExtra6 : "0");
            String stringExtra7 = intent2.getStringExtra("coupon_id");
            this.couponId = stringExtra7 != null ? stringExtra7 : "";
        }
        StringBuilder sb5 = new StringBuilder();
        sb5.append("initArguments, isLiveOpened:");
        sb5.append(this.isLiveOpened);
        sb5.append(", isMaster:");
        sb5.append(this.isMaster);
        sb5.append(", intent.extras:");
        FragmentActivity activity2 = getActivity();
        if (activity2 != null && (intent = activity2.getIntent()) != null) {
            bundle = intent.getExtras();
        }
        sb5.append(String.valueOf(bundle));
        cg0.a.b("ECLiveWindowMainFragment", sb5.toString());
    }

    private final void ki() {
        ECLiveWindowSubFragment eCLiveWindowSubFragment = this.currentFragment;
        if (eCLiveWindowSubFragment != null) {
            this.schemeCallbackParams.putAll(eCLiveWindowSubFragment.Ii());
        }
        JSONObject jSONObject = new JSONObject();
        for (Map.Entry<String, Object> entry : this.schemeCallbackParams.entrySet()) {
            jSONObject.put(entry.getKey(), entry.getValue());
        }
        IECSchemeCallback iECSchemeCallback = this.schemeCallback;
        if (iECSchemeCallback != null) {
            iECSchemeCallback.onCallbackFinished(jSONObject);
        }
        cg0.a.b("ECLiveWindowMainFragment", "onDestroyView callback=" + this.schemeCallback + ", json:" + jSONObject);
    }

    private final void li() {
        ImageView imageView = this.backBtn;
        if (imageView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("backBtn");
        }
        imageView.setVisibility(8);
        TextView textView = this.addProductBtn;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("addProductBtn");
        }
        textView.setVisibility(8);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(11);
        layoutParams.addRule(15);
        TextView textView2 = this.operatorBtn;
        if (textView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("operatorBtn");
        }
        textView2.setLayoutParams(layoutParams);
        TextView textView3 = this.operatorBtn;
        if (textView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("operatorBtn");
        }
        textView3.setVisibility(0);
        TextView textView4 = this.operatorBtn;
        if (textView4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("operatorBtn");
        }
        textView4.setText(getText(R.string.f169615wm1));
    }

    private final void mi() {
        yi();
        if (this.isLiveOpened) {
            ImageView imageView = this.backBtn;
            if (imageView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("backBtn");
            }
            imageView.setVisibility(0);
            TextView textView = this.operatorBtn;
            if (textView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("operatorBtn");
            }
            textView.setVisibility(8);
            TextView textView2 = this.addProductBtn;
            if (textView2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("addProductBtn");
            }
            textView2.setVisibility(0);
        } else {
            ImageView imageView2 = this.backBtn;
            if (imageView2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("backBtn");
            }
            imageView2.setVisibility(8);
            TextView textView3 = this.operatorBtn;
            if (textView3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("operatorBtn");
            }
            textView3.setVisibility(8);
            TextView textView4 = this.addProductBtn;
            if (textView4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("addProductBtn");
            }
            textView4.setVisibility(0);
        }
        pi(null);
    }

    private final void ni() {
        ImageView imageView = this.backBtn;
        if (imageView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("backBtn");
        }
        imageView.setVisibility(8);
        TextView textView = this.operatorBtn;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("operatorBtn");
        }
        textView.setVisibility(this.isLiveOpened ? 0 : 8);
        TextView textView2 = this.addProductBtn;
        if (textView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("addProductBtn");
        }
        textView2.setVisibility(0);
        ECLiveWindowMainViewModel eCLiveWindowMainViewModel = this.viewModel;
        if (eCLiveWindowMainViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        }
        List<TabInfo> value = eCLiveWindowMainViewModel.T1().getValue();
        if (value != null) {
            oi(value);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void oi(List<TabInfo> tabList) {
        if (this.isMaster && !this.isLiveOpened) {
            yi();
            return;
        }
        int size = tabList.size();
        if (size == 0) {
            yi();
            return;
        }
        if (size != 1) {
            Li();
            return;
        }
        yi();
        TabInfo tabInfo = tabList.get(0);
        if (this.isMaster) {
            if (tabInfo.allowEdit) {
                TextView textView = this.operatorBtn;
                if (textView == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("operatorBtn");
                }
                textView.setVisibility(this.isLiveOpened ? 0 : 8);
                TextView textView2 = this.addProductBtn;
                if (textView2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("addProductBtn");
                }
                textView2.setVisibility(0);
            } else {
                TextView textView3 = this.operatorBtn;
                if (textView3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("operatorBtn");
                }
                textView3.setVisibility(8);
                TextView textView4 = this.addProductBtn;
                if (textView4 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("addProductBtn");
                }
                textView4.setVisibility(8);
            }
        } else {
            TextView textView5 = this.operatorBtn;
            if (textView5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("operatorBtn");
            }
            textView5.setVisibility(0);
            TextView textView6 = this.addProductBtn;
            if (textView6 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("addProductBtn");
            }
            textView6.setVisibility(8);
        }
        pi(tabInfo);
    }

    private final void pi(TabInfo tabInfo) {
        if (Ei()) {
            int total = tabInfo != null ? tabInfo.getTotal() : 0;
            StringBuilder sb5 = new StringBuilder(getText((tabInfo != null ? tabInfo.id : null) == LiveTabId.LIVE_TAB_QSHOP ? R.string.wni : R.string.wlw));
            if (total > 0) {
                sb5.append("(");
                sb5.append(total);
                sb5.append(")");
            }
            TextView textView = this.windowCenterTitle;
            if (textView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("windowCenterTitle");
            }
            textView.setText(sb5.toString());
            return;
        }
        TextView textView2 = this.windowCenterTitle;
        if (textView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("windowCenterTitle");
        }
        textView2.setText(getText(R.string.wly));
    }

    private final void qi() {
        if (Di()) {
            ki();
            this.exitAnim = AnimationUtils.loadAnimation(getActivity(), R.anim.f1687);
            View view = this.rootContainer;
            if (view == null) {
                Intrinsics.throwUninitializedPropertyAccessException("rootContainer");
            }
            view.clearAnimation();
            View view2 = this.rootContainer;
            if (view2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("rootContainer");
            }
            Animation animation = this.exitAnim;
            if (animation == null) {
                Intrinsics.throwUninitializedPropertyAccessException("exitAnim");
            }
            view2.startAnimation(animation);
            Animation animation2 = this.exitAnim;
            if (animation2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("exitAnim");
            }
            animation2.setAnimationListener(new b());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void ri() {
        View view = this.rootContainer;
        if (view == null) {
            Intrinsics.throwUninitializedPropertyAccessException("rootContainer");
        }
        view.setVisibility(8);
        finish();
    }

    private final void si() {
        Ci();
    }

    private final void ti() {
        ECLiveWindowMainViewModel eCLiveWindowMainViewModel = this.viewModel;
        if (eCLiveWindowMainViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        }
        if (eCLiveWindowMainViewModel.O1().getValue() != null) {
            ECLiveWindowMainViewModel eCLiveWindowMainViewModel2 = this.viewModel;
            if (eCLiveWindowMainViewModel2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            }
            eCLiveWindowMainViewModel2.b2(!r0.booleanValue());
        }
    }

    private final void ui() {
        qi();
    }

    private final void vi() {
        if (this.isMaster) {
            ECLiveWindowMainViewModel eCLiveWindowMainViewModel = this.viewModel;
            if (eCLiveWindowMainViewModel == null) {
                Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            }
            if (eCLiveWindowMainViewModel.O1().getValue() != null) {
                ECLiveWindowMainViewModel eCLiveWindowMainViewModel2 = this.viewModel;
                if (eCLiveWindowMainViewModel2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("viewModel");
                }
                eCLiveWindowMainViewModel2.b2(!r0.booleanValue());
                return;
            }
            return;
        }
        Bi();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void wi(TabInfo tabInfo) {
        FragmentManager supportFragmentManager;
        ECLiveWindowSearchFragment a16 = ECLiveWindowSearchFragment.INSTANCE.a();
        Bundle requireArguments = requireArguments();
        requireArguments.putParcelable("ARG_TAB_INFO", tabInfo);
        a16.setArguments(requireArguments);
        FragmentActivity activity = getActivity();
        FragmentTransaction beginTransaction = (activity == null || (supportFragmentManager = activity.getSupportFragmentManager()) == null) ? null : supportFragmentManager.beginTransaction();
        if (beginTransaction != null) {
            beginTransaction.add(R.id.o_0, a16).addToBackStack(null).commit();
        }
        ECLiveWindowTitleBar eCLiveWindowTitleBar = this.titleBarContainer;
        if (eCLiveWindowTitleBar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("titleBarContainer");
        }
        eCLiveWindowTitleBar.setIsTouchable(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void xi() {
        SkeletonScreen skeletonScreen = this.skeleton;
        if (skeletonScreen == null) {
            Intrinsics.throwUninitializedPropertyAccessException("skeleton");
        }
        skeletonScreen.hide();
        RecyclerView recyclerView = this.recycleView;
        if (recyclerView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("recycleView");
        }
        recyclerView.setVisibility(8);
    }

    private final void yi() {
        TabLayout tabLayout = this.tabLayout;
        if (tabLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("tabLayout");
        }
        tabLayout.setVisibility(8);
        View view = this.tablayoutMask;
        if (view == null) {
            Intrinsics.throwUninitializedPropertyAccessException("tablayoutMask");
        }
        view.setVisibility(8);
        TextView textView = this.windowCenterTitle;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("windowCenterTitle");
        }
        textView.setVisibility(0);
    }

    private final void zi() {
        ei0.d dVar = ei0.d.f396304b;
        dVar.p(this, this.isMaster);
        if (this.isMaster) {
            TextView textView = this.addProductBtn;
            if (textView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("addProductBtn");
            }
            dVar.a(textView);
            TextView textView2 = this.operatorBtn;
            if (textView2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("operatorBtn");
            }
            dVar.i(textView2);
        }
    }

    @Override // com.tencent.ecommerce.base.fragment.ECBaseFragment
    public boolean Eh() {
        return true;
    }

    @Override // com.tencent.ecommerce.base.fragment.api.IECBaseFragment
    /* renamed from: getBusinessDescription */
    public String getTAG() {
        return "ECLiveWindowMainFragment";
    }

    @Override // com.tencent.ecommerce.base.fragment.ECBaseFragment
    public int getContentLayoutId() {
        return R.layout.cqv;
    }

    @Override // com.tencent.ecommerce.base.fragment.ECBaseFragment, com.tencent.ecommerce.base.ui.api.IECFragmentApi
    public boolean onBackPressed() {
        ECLiveWindowMainViewModel eCLiveWindowMainViewModel = this.viewModel;
        if (eCLiveWindowMainViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        }
        if (Intrinsics.areEqual(eCLiveWindowMainViewModel.O1().getValue(), Boolean.TRUE)) {
            ECLiveWindowMainViewModel eCLiveWindowMainViewModel2 = this.viewModel;
            if (eCLiveWindowMainViewModel2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            }
            if (eCLiveWindowMainViewModel2.O1().getValue() != null) {
                ECLiveWindowMainViewModel eCLiveWindowMainViewModel3 = this.viewModel;
                if (eCLiveWindowMainViewModel3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("viewModel");
                }
                eCLiveWindowMainViewModel3.b2(!r0.booleanValue());
            }
            return true;
        }
        if (Di()) {
            qi();
            return true;
        }
        return super.onBackPressed();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Integer valueOf = view != null ? Integer.valueOf(view.getId()) : null;
        if (valueOf != null && valueOf.intValue() == R.id.ofv) {
            ui();
        } else if (valueOf != null && valueOf.intValue() == R.id.ofd) {
            ti();
        } else if (valueOf != null && valueOf.intValue() == R.id.ofu) {
            vi();
        } else if (valueOf != null && valueOf.intValue() == R.id.ofc) {
            si();
        } else {
            StringBuilder sb5 = new StringBuilder();
            sb5.append("unknown click, id:");
            sb5.append(view != null ? Integer.valueOf(view.getId()) : null);
            cg0.a.a("ECLiveWindowMainFragment", NodeProps.ON_CLICK, sb5.toString());
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    @Override // com.tencent.ecommerce.base.fragment.ECBaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.windowInitTimeMs = System.currentTimeMillis();
        initArguments();
        ECLiveWindowMainViewModel eCLiveWindowMainViewModel = (ECLiveWindowMainViewModel) new ViewModelProvider(this).get(ECLiveWindowMainViewModel.class);
        this.viewModel = eCLiveWindowMainViewModel;
        if (eCLiveWindowMainViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        }
        FragmentActivity activity = getActivity();
        eCLiveWindowMainViewModel.U1(activity != null ? activity.getIntent() : null);
    }

    @Override // com.tencent.ecommerce.base.fragment.ECBaseFragment, androidx.fragment.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        Ji(false);
    }

    @Override // com.tencent.ecommerce.base.fragment.ECBaseFragment, androidx.fragment.app.Fragment
    public void onPause() {
        super.onPause();
        if (this.isMaster) {
            ECRMonitorManager.f100953c.b("EC_STAGE_LIVE_WINDOW_HOST");
        } else {
            ECRMonitorManager.f100953c.b("EC_STAGE_LIVE_WINDOW_GUEST");
        }
    }

    @Override // com.tencent.ecommerce.base.fragment.ECBaseFragment, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        if (this.isMaster) {
            ECRMonitorManager.f100953c.c("EC_STAGE_LIVE_WINDOW_HOST");
        } else {
            ECRMonitorManager.f100953c.c("EC_STAGE_LIVE_WINDOW_GUEST");
        }
    }

    @Override // com.tencent.ecommerce.base.fragment.ECBaseFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initUI(view);
        Hi();
        Gi();
        Fi();
        zi();
        Ji(true);
    }

    @Override // com.tencent.ecommerce.base.fragment.ECBaseFragment
    public int uh() {
        return 0;
    }

    private final void Bi() {
        ECScheme.g("mqqapi://ecommerce/open?target=2&channel=8", null, 2, null);
    }

    private final void initUI(View rootView) {
        this.rootContainer = rootView.findViewById(R.id.o9h);
        this.emptyOutside = rootView.findViewById(R.id.ofv);
        RecyclerView recyclerView = (RecyclerView) rootView.findViewById(R.id.o8n);
        this.recycleView = recyclerView;
        if (recyclerView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("recycleView");
        }
        recyclerView.setHasFixedSize(true);
        RecyclerView recyclerView2 = this.recycleView;
        if (recyclerView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("recycleView");
        }
        recyclerView2.setLayoutManager(new LinearLayoutManager(getActivity()));
        this.stateView = (ECStateCenterView) rootView.findViewById(R.id.f163103ob2);
        this.titleBarContainer = (ECLiveWindowTitleBar) rootView.findViewById(R.id.f163126og0);
        this.backBtn = (ImageView) rootView.findViewById(R.id.ofd);
        this.windowCenterTitle = (TextView) rootView.findViewById(R.id.ofh);
        this.operatorBtn = (TextView) rootView.findViewById(R.id.ofu);
        this.addProductBtn = (TextView) rootView.findViewById(R.id.ofc);
        View view = this.emptyOutside;
        if (view == null) {
            Intrinsics.throwUninitializedPropertyAccessException("emptyOutside");
        }
        view.setOnClickListener(this);
        ImageView imageView = this.backBtn;
        if (imageView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("backBtn");
        }
        imageView.setOnClickListener(this);
        ImageView imageView2 = this.backBtn;
        if (imageView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("backBtn");
        }
        ViewExtKt.a(imageView2, com.tencent.ecommerce.biz.util.e.c(50.0f));
        TextView textView = this.operatorBtn;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("operatorBtn");
        }
        textView.setOnClickListener(this);
        TextView textView2 = this.addProductBtn;
        if (textView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("addProductBtn");
        }
        textView2.setOnClickListener(this);
        this.viewPager = (ViewPager2) rootView.findViewById(R.id.of7);
        this.fragmentAdapter = new fi0.b(this);
        ViewPager2 viewPager2 = this.viewPager;
        if (viewPager2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewPager");
        }
        fi0.b bVar = this.fragmentAdapter;
        if (bVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("fragmentAdapter");
        }
        viewPager2.setAdapter(bVar);
        ViewPager2 viewPager22 = this.viewPager;
        if (viewPager22 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewPager");
        }
        viewPager22.registerOnPageChangeCallback(new ECLiveWindowMainFragment$initUI$1(this));
        RecyclerView recyclerView3 = this.recycleView;
        if (recyclerView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("recycleView");
        }
        this.skeleton = fh0.c.a(recyclerView3).q(true).l(10).m(R.color.f6722b).o(true).n(9).p(R.layout.crv).r();
        Ai();
        doEnterAnim();
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\u0006\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\u0007\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016\u00a8\u0006\b"}, d2 = {"com/tencent/ecommerce/biz/live/ui/ECLiveWindowMainFragment$b", "Landroid/view/animation/Animation$AnimationListener;", "Landroid/view/animation/Animation;", "p0", "", "onAnimationRepeat", "onAnimationStart", "onAnimationEnd", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
    /* loaded from: classes31.dex */
    public static final class b implements Animation.AnimationListener {
        b() {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation p06) {
            ECLiveWindowMainFragment.this.ri();
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation p06) {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation p06) {
        }
    }
}

package com.tencent.mobileqq.zootopia.portal.detail;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.os.Bundle;
import android.transition.Fade;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.PathInterpolator;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.view.ViewCompat;
import androidx.exifinterface.media.ExifInterface;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.viewpager.widget.ViewPager;
import com.heytap.databaseengine.apiv3.data.Element;
import com.qzone.proxy.personalitycomponent.model.WidgetCacheLunarData;
import com.tencent.ams.dsdk.core.DKEngine;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.common.ParseCommon;
import com.tencent.biz.pubaccount.weishi.event.WSComboHomePageChangeEvent;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.eventbus.SimpleEventReceiver;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.shortvideo.gesture.DownloadInfo;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.z1.cloudmod.api.ZPlanCloudGameInfo;
import com.tencent.mobileqq.zootopia.ZootopiaSource;
import com.tencent.mobileqq.zootopia.download.ui.ZootopiaDownloadManagerFragment;
import com.tencent.mobileqq.zootopia.portal.detail.ZootopiaDetailFragment;
import com.tencent.mobileqq.zootopia.portal.detail.ZootopiaDetailFragmentV2$guideTipsView$2;
import com.tencent.mobileqq.zootopia.portal.detail.events.ZootopiaDetailFragmentCloseEvent;
import com.tencent.mobileqq.zootopia.portal.detail.v2.ZootopiaDetailTabView;
import com.tencent.mobileqq.zootopia.portal.detail.v2.ZootopiaDetailTabViewPager;
import com.tencent.mobileqq.zootopia.portal.detail.v2.ZootopiaDetailV2HeaderView;
import com.tencent.mobileqq.zootopia.view.ZootopiaDownloadButton;
import com.tencent.mobileqq.zootopia.view.ZootopiaDownloadButtonBinder;
import com.tencent.mobileqq.zplan.smallhome.floatwindow.ZPlanFloatWindowManager;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqmini.minigame.action.OperateCustomButton;
import com.tencent.sqshow.zootopia.ZootopiaActivity;
import com.tencent.sqshow.zootopia.data.ButtonStatus;
import com.tencent.sqshow.zootopia.data.ErrorMessage;
import com.tencent.sqshow.zootopia.data.ZootopiaMapDetail;
import com.tencent.sqshow.zootopia.data.ZootopiaMapSimpleInfo;
import com.tencent.sqshow.zootopia.data.ZootopiaMapTab;
import com.tencent.sqshow.zootopia.guide.DetailGuideTask;
import com.tencent.sqshow.zootopia.guide.ZplanGuideManager;
import com.tencent.sqshow.zootopia.guide.ZplanGuideTriggerEvent;
import com.tencent.sqshow.zootopia.guide.ZplanGuideVisibilityChangedEvent;
import com.tencent.sqshow.zootopia.guide.i;
import com.tencent.sqshow.zootopia.portal.detail.scrollingheader.ScrollingHeaderLayout;
import com.tencent.sqshow.zootopia.view.pull2refresh.ZootopiaDetailPullToRefreshView;
import com.tencent.widget.immersive.ImmersiveUtils;
import com.tencent.widget.pull2refresh.anim.IAnimManager;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.Constants;
import mqq.util.WeakReference;
import n74.bk;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u008a\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0014\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000b*\u0002\u008f\u0001\u0018\u0000 \u009c\u00012\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u00042\u00020\u00052\u00020\u00062\b\u0012\u0004\u0012\u00020\b0\u0007:\u0004\u009d\u0001\u009e\u0001B\t\u00a2\u0006\u0006\b\u009a\u0001\u0010\u009b\u0001J\u0010\u0010\f\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\tH\u0002J\b\u0010\r\u001a\u00020\u000bH\u0002J\u0012\u0010\u0010\u001a\u00020\u000b2\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eH\u0002J-\u0010\u0015\u001a\u00020\u000b2\b\u0010\u0012\u001a\u0004\u0018\u00010\u00112\b\u0010\u000f\u001a\u0004\u0018\u00010\u000e2\b\u0010\u0014\u001a\u0004\u0018\u00010\u0013H\u0002\u00a2\u0006\u0004\b\u0015\u0010\u0016J\u0010\u0010\u0019\u001a\u00020\u000b2\u0006\u0010\u0018\u001a\u00020\u0017H\u0002J\u0010\u0010\u001c\u001a\u00020\u000b2\u0006\u0010\u001b\u001a\u00020\u001aH\u0002J\u0010\u0010\u001e\u001a\u00020\u001d2\u0006\u0010\u001b\u001a\u00020\u001aH\u0002J\b\u0010\u001f\u001a\u00020\u000bH\u0002J\u0010\u0010!\u001a\u00020 2\u0006\u0010\u000f\u001a\u00020\u000eH\u0002J\b\u0010\"\u001a\u00020\u000bH\u0002J\u0018\u0010&\u001a\u00020\u000b2\u0006\u0010$\u001a\u00020#2\u0006\u0010%\u001a\u00020\u0017H\u0002J\u0010\u0010(\u001a\u00020\u000b2\u0006\u0010'\u001a\u00020\u0011H\u0002J\u0010\u0010)\u001a\u00020\u000b2\u0006\u0010'\u001a\u00020\u0011H\u0002J\u0010\u0010+\u001a\u00020\u000b2\u0006\u0010*\u001a\u00020 H\u0002J\u0010\u0010-\u001a\u00020\u000b2\u0006\u0010,\u001a\u00020 H\u0002J\u0010\u00100\u001a\u00020\u000b2\u0006\u0010/\u001a\u00020.H\u0002J\u0016\u00104\u001a\u00020\u000b2\f\u00103\u001a\b\u0012\u0004\u0012\u00020201H\u0002J\b\u00105\u001a\u00020\u000bH\u0002J\b\u00106\u001a\u00020\u000bH\u0002J\b\u00108\u001a\u000207H\u0014J\u0012\u0010;\u001a\u00020\u000b2\b\u0010:\u001a\u0004\u0018\u000109H\u0016J&\u0010@\u001a\u0004\u0018\u00010\t2\u0006\u0010=\u001a\u00020<2\b\u0010?\u001a\u0004\u0018\u00010>2\b\u0010:\u001a\u0004\u0018\u000109H\u0016J\u001a\u0010B\u001a\u00020\u000b2\u0006\u0010A\u001a\u00020\t2\b\u0010:\u001a\u0004\u0018\u000109H\u0016J\u001a\u0010F\u001a\u00020\u000b2\b\u0010D\u001a\u0004\u0018\u00010C2\u0006\u0010E\u001a\u00020 H\u0016J\b\u0010G\u001a\u00020\u000bH\u0016J\u0018\u0010J\u001a\u00020\u000b2\u0006\u0010H\u001a\u00020\u00172\u0006\u0010I\u001a\u00020\u0017H\u0016J\u0012\u0010L\u001a\u00020\u000b2\b\u0010K\u001a\u0004\u0018\u00010\tH\u0016J\b\u0010M\u001a\u00020\u000bH\u0016J\b\u0010N\u001a\u00020 H\u0016J\b\u0010O\u001a\u00020 H\u0016J\u0010\u0010Q\u001a\u00020 2\u0006\u0010P\u001a\u00020\u0017H\u0016J\u0012\u0010T\u001a\u00020\u000b2\b\u0010S\u001a\u0004\u0018\u00010RH\u0016J\n\u0010V\u001a\u0004\u0018\u00010UH\u0016J\b\u0010W\u001a\u00020\u000bH\u0016J\b\u0010X\u001a\u00020\u000bH\u0016J\u0014\u0010Z\u001a\u00020\u000b2\f\u0010Y\u001a\b\u0012\u0004\u0012\u00020.01J\u0006\u0010[\u001a\u00020\u000bJ\u0012\u0010^\u001a\u00020\u000b2\b\u0010]\u001a\u0004\u0018\u00010\\H\u0016J\u0014\u0010a\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0`0_H\u0016R\u001b\u0010g\u001a\u00020b8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\bc\u0010d\u001a\u0004\be\u0010fR\u001b\u0010l\u001a\u00020h8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\bi\u0010d\u001a\u0004\bj\u0010kR\u001b\u0010q\u001a\u00020m8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\bn\u0010d\u001a\u0004\bo\u0010pR\u0018\u0010u\u001a\u0004\u0018\u00010r8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bs\u0010tR\u0018\u0010y\u001a\u0004\u0018\u00010v8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bw\u0010xR\u0016\u0010}\u001a\u00020z8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b{\u0010|R\u0017\u0010\u0080\u0001\u001a\u00020 8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b~\u0010\u007fR\u0018\u0010\u0082\u0001\u001a\u00020 8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0007\n\u0005\b\u0081\u0001\u0010\u007fR\u001b\u0010\u0085\u0001\u001a\u0004\u0018\u00010.8\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u0083\u0001\u0010\u0084\u0001R\u0017\u0010\u0086\u0001\u001a\u00020 8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bW\u0010\u007fR\u0017\u0010\u0087\u0001\u001a\u00020 8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u007f\u0010\u007fR\u0019\u0010\u008a\u0001\u001a\u00020\u00178\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u0088\u0001\u0010\u0089\u0001R\u0019\u0010\u008c\u0001\u001a\u00020\u00178\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u008b\u0001\u0010\u0089\u0001R\u0019\u0010\u008e\u0001\u001a\u00020\u00178\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u008d\u0001\u0010\u0089\u0001R \u0010\u0093\u0001\u001a\u00030\u008f\u00018BX\u0082\u0084\u0002\u00a2\u0006\u000f\n\u0005\b\u0090\u0001\u0010d\u001a\u0006\b\u0091\u0001\u0010\u0092\u0001R\u001e\u0010\u0097\u0001\u001a\t\u0012\u0004\u0012\u00020\u000e0\u0094\u00018\u0002X\u0082\u0004\u00a2\u0006\b\n\u0006\b\u0095\u0001\u0010\u0096\u0001R\u001e\u0010\u0099\u0001\u001a\t\u0012\u0004\u0012\u00020\u00110\u0094\u00018\u0002X\u0082\u0004\u00a2\u0006\b\n\u0006\b\u0098\u0001\u0010\u0096\u0001\u00a8\u0006\u009f\u0001"}, d2 = {"Lcom/tencent/mobileqq/zootopia/portal/detail/ZootopiaDetailFragmentV2;", "Lcom/tencent/mobileqq/zootopia/portal/detail/IZootopiaDetailFragment;", "Lcom/tencent/widget/pull2refresh/anim/IAnimManager$OnRefreshPullDistanceListener;", "Lcom/tencent/sqshow/zootopia/view/pull2refresh/ZootopiaDetailPullToRefreshView$c;", "Lcom/tencent/sqshow/zootopia/view/pull2refresh/ZootopiaDetailPullToRefreshView$b;", "Landroid/view/View$OnClickListener;", "Lxc3/a;", "Lcom/tencent/biz/richframework/eventbus/SimpleEventReceiver;", "Lcom/tencent/sqshow/zootopia/guide/ZplanGuideTriggerEvent;", "Landroid/view/View;", "target", "", "Ei", "pi", "Lcom/tencent/sqshow/zootopia/data/ButtonStatus;", "buttonStatus", "ei", "", "buttonProgress", "Lcom/tencent/sqshow/zootopia/data/ZootopiaMapSimpleInfo;", "mapSimpleInfo", "qi", "(Ljava/lang/Float;Lcom/tencent/sqshow/zootopia/data/ButtonStatus;Lcom/tencent/sqshow/zootopia/data/ZootopiaMapSimpleInfo;)V", "", "mapId", "Zh", "Lcom/tencent/sqshow/zootopia/data/m;", "detail", "Yh", "Lcom/tencent/mobileqq/zootopia/portal/detail/an;", "gi", "fi", "", "bi", "Ii", "Lcom/tencent/sqshow/zootopia/portal/detail/scrollingheader/ScrollingHeaderLayout;", "appBarLayout", "verticalOffset", "ti", "percent", "ci", "di", "useDark", "Ji", "isPined", "si", "Lpv4/f;", "status", "ai", "", "Lcom/tencent/sqshow/zootopia/data/n;", "tabList", "li", "ri", "Di", "", "getSubSource", "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, "onCreate", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", ParseCommon.CONTAINER, "onCreateView", "view", DKEngine.ExtraEvent.EXTRA_EVENT_ON_VIEW_CREATED, "Lcom/tencent/sqshow/zootopia/view/pull2refresh/ZootopiaDetailPullToRefreshView;", "recyclerView", "isMachineRefresh", "F1", "endOfRefresh", Element.ELEMENT_NAME_DISTANCE, "touchMode", "onPullDistance", "v", NodeProps.ON_CLICK, MosaicConstants$JsFunction.FUNC_ON_DESTROY, "onBackEvent", "onBackPressedEvent", "dirct", "canScrollVertically", "Landroid/widget/RelativeLayout$LayoutParams;", "lp", "Xf", "Landroid/view/ViewGroup$LayoutParams;", "u7", "Y", "onResume", "data", "ni", "Hi", "Lcom/tencent/biz/richframework/eventbus/SimpleBaseEvent;", "event", "onReceiveEvent", "Ljava/util/ArrayList;", "Ljava/lang/Class;", "getEventClass", "Lcom/tencent/mobileqq/zootopia/portal/detail/am;", "P", "Lkotlin/Lazy;", "ki", "()Lcom/tencent/mobileqq/zootopia/portal/detail/am;", "vm", "Loa4/a;", AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, "ii", "()Loa4/a;", "mapResVm", "Lcom/tencent/mobileqq/zootopia/portal/detail/ah;", BdhLogUtil.LogTag.Tag_Req, WidgetCacheLunarData.JI, "()Lcom/tencent/mobileqq/zootopia/portal/detail/ah;", "reportHelper", "Lcom/tencent/mobileqq/zootopia/portal/detail/v2/ZootopiaDetailV2HeaderView;", ExifInterface.LATITUDE_SOUTH, "Lcom/tencent/mobileqq/zootopia/portal/detail/v2/ZootopiaDetailV2HeaderView;", "headerView", "Lfi3/u;", "T", "Lfi3/u;", "binding", "Lcom/tencent/mobileqq/zootopia/portal/detail/ZootopiaDetailFragment$Config;", "U", "Lcom/tencent/mobileqq/zootopia/portal/detail/ZootopiaDetailFragment$Config;", DownloadInfo.spKey_Config, "V", "Z", "needAutoDownload", "W", "isAppBarPined", "X", "Lpv4/f;", "guideStatus", "isStatusBarDarkMode", "isCloudMod", "a0", "I", "tabBarTopMargin", "b0", "tabBarContentHeight", "c0", "appBarContainerNormalMinHeight", "com/tencent/mobileqq/zootopia/portal/detail/ZootopiaDetailFragmentV2$guideTipsView$2$a", "d0", "hi", "()Lcom/tencent/mobileqq/zootopia/portal/detail/ZootopiaDetailFragmentV2$guideTipsView$2$a;", "guideTipsView", "Landroidx/lifecycle/Observer;", "e0", "Landroidx/lifecycle/Observer;", "statusObserver", "f0", "progressObserver", "<init>", "()V", "g0", "a", "b", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes35.dex */
public final class ZootopiaDetailFragmentV2 extends IZootopiaDetailFragment implements IAnimManager.OnRefreshPullDistanceListener, ZootopiaDetailPullToRefreshView.c, ZootopiaDetailPullToRefreshView.b, View.OnClickListener, xc3.a, SimpleEventReceiver<ZplanGuideTriggerEvent> {

    /* renamed from: P, reason: from kotlin metadata */
    private final Lazy vm;

    /* renamed from: Q, reason: from kotlin metadata */
    private final Lazy mapResVm;

    /* renamed from: R, reason: from kotlin metadata */
    private final Lazy reportHelper;

    /* renamed from: S, reason: from kotlin metadata */
    private ZootopiaDetailV2HeaderView headerView;

    /* renamed from: T, reason: from kotlin metadata */
    private fi3.u binding;

    /* renamed from: U, reason: from kotlin metadata */
    private ZootopiaDetailFragment.Config config;

    /* renamed from: V, reason: from kotlin metadata */
    private boolean needAutoDownload;

    /* renamed from: W, reason: from kotlin metadata */
    private boolean isAppBarPined;

    /* renamed from: X, reason: from kotlin metadata */
    private pv4.f guideStatus;

    /* renamed from: Y, reason: from kotlin metadata */
    private boolean isStatusBarDarkMode;

    /* renamed from: Z, reason: from kotlin metadata */
    private boolean isCloudMod;

    /* renamed from: a0, reason: collision with root package name and from kotlin metadata */
    private int tabBarTopMargin;

    /* renamed from: b0, reason: collision with root package name and from kotlin metadata */
    private int tabBarContentHeight;

    /* renamed from: c0, reason: collision with root package name and from kotlin metadata */
    private int appBarContainerNormalMinHeight;

    /* renamed from: d0, reason: collision with root package name and from kotlin metadata */
    private final Lazy guideTipsView;

    /* renamed from: e0, reason: collision with root package name and from kotlin metadata */
    private final Observer<ButtonStatus> statusObserver;

    /* renamed from: f0, reason: collision with root package name and from kotlin metadata */
    private final Observer<Float> progressObserver;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\b\u0000\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0010\u001a\u00020\n\u00a2\u0006\u0004\b\u0011\u0010\u0012J\u001e\u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004H\u0016R%\u0010\u000f\u001a\u0010\u0012\f\u0012\n \u000b*\u0004\u0018\u00010\n0\n0\t8\u0006\u00a2\u0006\f\n\u0004\b\b\u0010\f\u001a\u0004\b\r\u0010\u000e\u00a8\u0006\u0013"}, d2 = {"Lcom/tencent/mobileqq/zootopia/portal/detail/ZootopiaDetailFragmentV2$b;", "Lcom/tencent/sqshow/zootopia/guide/i$b;", "", "needGuide", "", "Lpv4/f;", "result", "", "a", "Lmqq/util/WeakReference;", "Lcom/tencent/mobileqq/zootopia/portal/detail/ZootopiaDetailFragmentV2;", "kotlin.jvm.PlatformType", "Lmqq/util/WeakReference;", "getContextRefer", "()Lmqq/util/WeakReference;", "contextRefer", "context", "<init>", "(Lcom/tencent/mobileqq/zootopia/portal/detail/ZootopiaDetailFragmentV2;)V", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes35.dex */
    public static final class b implements i.b {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        private final WeakReference<ZootopiaDetailFragmentV2> contextRefer;

        public b(ZootopiaDetailFragmentV2 context) {
            Intrinsics.checkNotNullParameter(context, "context");
            this.contextRefer = new WeakReference<>(context);
        }

        @Override // com.tencent.sqshow.zootopia.guide.i.b
        public void a(boolean needGuide, List<pv4.f> result) {
            ZootopiaDetailFragmentV2 zootopiaDetailFragmentV2;
            Intrinsics.checkNotNullParameter(result, "result");
            if (!needGuide || (zootopiaDetailFragmentV2 = this.contextRefer.get()) == null) {
                return;
            }
            zootopiaDetailFragmentV2.ni(result);
        }
    }

    /* compiled from: P */
    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes35.dex */
    public /* synthetic */ class c {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f328714a;

        static {
            int[] iArr = new int[ButtonStatus.values().length];
            try {
                iArr[ButtonStatus.INIT.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[ButtonStatus.WAITING.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[ButtonStatus.LOADING.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[ButtonStatus.UPDATE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr[ButtonStatus.PAUSE.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            f328714a = iArr;
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0016\u00a8\u0006\u0007"}, d2 = {"com/tencent/mobileqq/zootopia/portal/detail/ZootopiaDetailFragmentV2$d", "Lpk3/b;", "", "isContinueNext", "hasPermissionGranted", "", "a", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes35.dex */
    public static final class d implements pk3.b {
        d() {
        }

        @Override // pk3.b
        public void a(boolean isContinueNext, boolean hasPermissionGranted) {
            FragmentActivity activity;
            QLog.i("ZootopiaDetailFragmentV2", 1, "doWhenBackPressed - " + ZootopiaDetailFragmentV2.this.ki().T1() + ", checkNeedShowFloatWindowAfterExit - " + isContinueNext);
            if (!isContinueNext || (activity = ZootopiaDetailFragmentV2.this.getActivity()) == null) {
                return;
            }
            activity.finish();
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J \u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0002H\u0016J\u0010\u0010\t\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\n"}, d2 = {"com/tencent/mobileqq/zootopia/portal/detail/ZootopiaDetailFragmentV2$e", "Landroidx/viewpager/widget/ViewPager$SimpleOnPageChangeListener;", "", "position", "", "positionOffset", "positionOffsetPixels", "", WSComboHomePageChangeEvent.EVENT_ON_PAGE_SCROLLED, "onPageSelected", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes35.dex */
    public static final class e extends ViewPager.SimpleOnPageChangeListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ fi3.u f328716d;

        e(fi3.u uVar) {
            this.f328716d = uVar;
        }

        @Override // androidx.viewpager.widget.ViewPager.SimpleOnPageChangeListener, androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
            this.f328716d.f399401r.setTranslationX((-((ViewUtils.getScreenWidth() * positionOffset) + (position * ViewUtils.getScreenWidth()))) + ViewUtils.getScreenWidth());
        }

        @Override // androidx.viewpager.widget.ViewPager.SimpleOnPageChangeListener, androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageSelected(int position) {
            super.onPageSelected(position);
        }
    }

    public ZootopiaDetailFragmentV2() {
        Lazy lazy;
        Lazy lazy2;
        Lazy lazy3;
        Lazy lazy4;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<am>() { // from class: com.tencent.mobileqq.zootopia.portal.detail.ZootopiaDetailFragmentV2$vm$2

            /* compiled from: P */
            @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J)\u0010\u0006\u001a\u00028\u0000\"\n\b\u0000\u0010\u0003*\u0004\u0018\u00010\u00022\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004H\u0016\u00a2\u0006\u0004\b\u0006\u0010\u0007\u00a8\u0006\b"}, d2 = {"com/tencent/mobileqq/zootopia/portal/detail/ZootopiaDetailFragmentV2$vm$2$a", "Landroidx/lifecycle/ViewModelProvider$Factory;", "Landroidx/lifecycle/ViewModel;", "T", "Ljava/lang/Class;", "modelClass", OperateCustomButton.OPERATE_CREATE, "(Ljava/lang/Class;)Landroidx/lifecycle/ViewModel;", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
            /* loaded from: classes35.dex */
            public static final class a implements ViewModelProvider.Factory {
                a() {
                }

                @Override // androidx.lifecycle.ViewModelProvider.Factory
                public <T extends ViewModel> T create(Class<T> modelClass) {
                    Intrinsics.checkNotNullParameter(modelClass, "modelClass");
                    return new am(new ai(1));
                }
            }

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final am invoke() {
                ViewModel viewModel = com.tencent.mobileqq.mvvm.h.b(ZootopiaDetailFragmentV2.this, new a()).get(am.class);
                Intrinsics.checkNotNullExpressionValue(viewModel, "ofViewModelProvider(this\u2026ailViewModel::class.java)");
                return (am) viewModel;
            }
        });
        this.vm = lazy;
        lazy2 = LazyKt__LazyJVMKt.lazy(new Function0<oa4.a>() { // from class: com.tencent.mobileqq.zootopia.portal.detail.ZootopiaDetailFragmentV2$mapResVm$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final oa4.a invoke() {
                ViewModel viewModel = com.tencent.mobileqq.mvvm.h.a(ZootopiaDetailFragmentV2.this.requireActivity()).get(oa4.a.class);
                Intrinsics.checkNotNullExpressionValue(viewModel, "ofViewModelProvider(requ\u2026ResViewModel::class.java)");
                return (oa4.a) viewModel;
            }
        });
        this.mapResVm = lazy2;
        lazy3 = LazyKt__LazyJVMKt.lazy(new Function0<ah>() { // from class: com.tencent.mobileqq.zootopia.portal.detail.ZootopiaDetailFragmentV2$reportHelper$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ah invoke() {
                Context requireContext = ZootopiaDetailFragmentV2.this.requireContext();
                Intrinsics.checkNotNullExpressionValue(requireContext, "requireContext()");
                return new ah(requireContext);
            }
        });
        this.reportHelper = lazy3;
        this.config = new ZootopiaDetailFragment.Config(0, false, false, false, null, null, false, null, 255, null);
        lazy4 = LazyKt__LazyJVMKt.lazy(new Function0<ZootopiaDetailFragmentV2$guideTipsView$2.a>() { // from class: com.tencent.mobileqq.zootopia.portal.detail.ZootopiaDetailFragmentV2$guideTipsView$2

            /* compiled from: P */
            @Metadata(d1 = {"\u0000%\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0012\u0010\u0006\u001a\u00020\u00052\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003H\u0016J\u0014\u0010\t\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00020\b0\u0007H\u0016\u00a8\u0006\n"}, d2 = {"com/tencent/mobileqq/zootopia/portal/detail/ZootopiaDetailFragmentV2$guideTipsView$2$a", "Lcom/tencent/biz/richframework/eventbus/SimpleEventReceiver;", "Lcom/tencent/sqshow/zootopia/guide/ZplanGuideVisibilityChangedEvent;", "Lcom/tencent/biz/richframework/eventbus/SimpleBaseEvent;", "event", "", "onReceiveEvent", "Ljava/util/ArrayList;", "Ljava/lang/Class;", "getEventClass", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
            /* loaded from: classes35.dex */
            public static final class a implements SimpleEventReceiver<ZplanGuideVisibilityChangedEvent> {

                /* renamed from: d, reason: collision with root package name */
                final /* synthetic */ ZootopiaDetailFragmentV2 f328717d;

                a(ZootopiaDetailFragmentV2 zootopiaDetailFragmentV2) {
                    this.f328717d = zootopiaDetailFragmentV2;
                }

                @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
                public void onReceiveEvent(SimpleBaseEvent event) {
                    ZootopiaDetailV2HeaderView zootopiaDetailV2HeaderView;
                    bk guideView;
                    QLog.d("ZootopiaDetailFragmentV2", 1, "receiver Event " + event);
                    if (event instanceof ZplanGuideVisibilityChangedEvent) {
                        ZplanGuideVisibilityChangedEvent zplanGuideVisibilityChangedEvent = (ZplanGuideVisibilityChangedEvent) event;
                        if (zplanGuideVisibilityChangedEvent.getGroupId() == 12) {
                            if (zplanGuideVisibilityChangedEvent.getVisibliity()) {
                                this.f328717d.Di();
                                return;
                            }
                            zootopiaDetailV2HeaderView = this.f328717d.headerView;
                            ConstraintLayout constraintLayout = (zootopiaDetailV2HeaderView == null || (guideView = zootopiaDetailV2HeaderView.getGuideView()) == null) ? null : guideView.f418849b;
                            if (constraintLayout == null) {
                                return;
                            }
                            constraintLayout.setVisibility(8);
                        }
                    }
                }

                @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
                public ArrayList<Class<ZplanGuideVisibilityChangedEvent>> getEventClass() {
                    ArrayList<Class<ZplanGuideVisibilityChangedEvent>> arrayListOf;
                    arrayListOf = CollectionsKt__CollectionsKt.arrayListOf(ZplanGuideVisibilityChangedEvent.class);
                    return arrayListOf;
                }
            }

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final a invoke() {
                return new a(ZootopiaDetailFragmentV2.this);
            }
        });
        this.guideTipsView = lazy4;
        this.statusObserver = new Observer() { // from class: com.tencent.mobileqq.zootopia.portal.detail.p
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                ZootopiaDetailFragmentV2.Fi(ZootopiaDetailFragmentV2.this, (ButtonStatus) obj);
            }
        };
        this.progressObserver = new Observer() { // from class: com.tencent.mobileqq.zootopia.portal.detail.t
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                ZootopiaDetailFragmentV2.Ci(ZootopiaDetailFragmentV2.this, (Float) obj);
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Ai(fi3.u binding, ZootopiaDetailFragmentV2 this$0, ZootopiaMapDetail zootopiaMapDetail) {
        Intrinsics.checkNotNullParameter(binding, "$binding");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (zootopiaMapDetail != null) {
            binding.f399402s.setVisibility(8);
            this$0.Yh(zootopiaMapDetail);
            binding.f399400q.s(true);
        }
        if (!zootopiaMapDetail.getFromSimpleData()) {
            ZootopiaDetailTabViewPager zootopiaDetailTabViewPager = binding.f399394k;
            FragmentManager childFragmentManager = this$0.getChildFragmentManager();
            Intrinsics.checkNotNullExpressionValue(childFragmentManager, "childFragmentManager");
            List<ZootopiaMapTab> t16 = zootopiaMapDetail.t();
            ZootopiaDetailTabView zootopiaDetailTabView = binding.f399395l;
            Intrinsics.checkNotNullExpressionValue(zootopiaDetailTabView, "binding.contentViewpagerTitleLayout");
            RelativeLayout relativeLayout = binding.f399386c;
            Intrinsics.checkNotNullExpressionValue(relativeLayout, "binding.appbarContainer");
            zootopiaDetailTabViewPager.setDataTem(childFragmentManager, t16, zootopiaDetailTabView, relativeLayout, this$0.appBarContainerNormalMinHeight);
        }
        this$0.li(zootopiaMapDetail.t());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Bi(fi3.u binding, ZootopiaDetailFragmentV2 this$0, ErrorMessage errorMessage) {
        Intrinsics.checkNotNullParameter(binding, "$binding");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        binding.f399402s.setVisibility(0);
        if (errorMessage != null) {
            QLog.d("ZootopiaDetailFragmentV2", 1, "errorMessage:" + errorMessage);
            binding.f399400q.s(false);
            QQToast.makeText(this$0.getActivity(), 1, this$0.getString(R.string.xi6), 0).show();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Ci(ZootopiaDetailFragmentV2 this$0, Float it) {
        ZootopiaDownloadButton zootopiaDownloadButton;
        ZootopiaDownloadButton btnEnter;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        ZootopiaDetailV2HeaderView zootopiaDetailV2HeaderView = this$0.headerView;
        if (zootopiaDetailV2HeaderView != null && (btnEnter = zootopiaDetailV2HeaderView.getBtnEnter()) != null) {
            Intrinsics.checkNotNullExpressionValue(it, "it");
            btnEnter.setProcess(it.floatValue());
        }
        fi3.u uVar = this$0.binding;
        if (uVar == null || (zootopiaDownloadButton = uVar.f399399p) == null) {
            return;
        }
        Intrinsics.checkNotNullExpressionValue(it, "it");
        zootopiaDownloadButton.setProcess(it.floatValue());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Di() {
        bk guideView;
        ZootopiaDetailV2HeaderView zootopiaDetailV2HeaderView = this.headerView;
        if (zootopiaDetailV2HeaderView == null || (guideView = zootopiaDetailV2HeaderView.getGuideView()) == null) {
            return;
        }
        ConstraintLayout constraintLayout = guideView.f418849b;
        if (constraintLayout != null) {
            constraintLayout.setVisibility(0);
        }
        ConstraintLayout constraintLayout2 = guideView.f418849b;
        if (constraintLayout2 != null) {
            constraintLayout2.bringToFront();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Fi(final ZootopiaDetailFragmentV2 this$0, ButtonStatus it) {
        ZootopiaDetailV2HeaderView zootopiaDetailV2HeaderView;
        ZootopiaDownloadButton btnEnter;
        ZootopiaDownloadButton btnEnter2;
        ZootopiaDownloadButton btnEnter3;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (it != ButtonStatus.LOADING) {
            QLog.i("ZootopiaDetailFragmentV2", 1, "statusObserver - " + it + ", needAutoDownload= " + this$0.needAutoDownload + ", guideStatus= " + this$0.guideStatus);
        }
        fi3.u uVar = this$0.binding;
        if (uVar == null) {
            return;
        }
        ZootopiaDetailV2HeaderView zootopiaDetailV2HeaderView2 = this$0.headerView;
        if (zootopiaDetailV2HeaderView2 != null && (btnEnter3 = zootopiaDetailV2HeaderView2.getBtnEnter()) != null && btnEnter3.getIsInitCloudModType()) {
            ZootopiaDownloadButtonBinder.Companion companion = ZootopiaDownloadButtonBinder.INSTANCE;
            Intrinsics.checkNotNullExpressionValue(it, "it");
            if (companion.a(it)) {
                QLog.i("ZootopiaDetailFragmentV2", 1, "update to cloud mod status, origin: " + it);
                ButtonStatus buttonStatus = ButtonStatus.CLOUD_GAME;
                btnEnter3.setStatus(buttonStatus);
                uVar.f399399p.setStatus(buttonStatus);
                return;
            }
        }
        QLog.i("ZootopiaDetailFragmentV2", 1, "update to other status: " + it);
        if (it == ButtonStatus.LOADED || it == ButtonStatus.ONLY_DOWNLOAD) {
            QLog.i("ZootopiaDetailFragmentV2", 1, "LOADED");
            this$0.needAutoDownload = false;
            if (this$0.guideStatus != null && (zootopiaDetailV2HeaderView = this$0.headerView) != null && (btnEnter = zootopiaDetailV2HeaderView.getBtnEnter()) != null) {
                btnEnter.post(new Runnable() { // from class: com.tencent.mobileqq.zootopia.portal.detail.q
                    @Override // java.lang.Runnable
                    public final void run() {
                        ZootopiaDetailFragmentV2.Gi(ZootopiaDetailFragmentV2.this);
                    }
                });
            }
        }
        ZootopiaDetailV2HeaderView zootopiaDetailV2HeaderView3 = this$0.headerView;
        if (zootopiaDetailV2HeaderView3 != null && (btnEnter2 = zootopiaDetailV2HeaderView3.getBtnEnter()) != null) {
            btnEnter2.B();
        }
        uVar.f399399p.B();
        ZootopiaDetailV2HeaderView zootopiaDetailV2HeaderView4 = this$0.headerView;
        ZootopiaDownloadButton btnEnter4 = zootopiaDetailV2HeaderView4 != null ? zootopiaDetailV2HeaderView4.getBtnEnter() : null;
        if (btnEnter4 != null) {
            Intrinsics.checkNotNullExpressionValue(it, "it");
            btnEnter4.setStatus(it);
        }
        ZootopiaDownloadButton zootopiaDownloadButton = uVar.f399399p;
        Intrinsics.checkNotNullExpressionValue(it, "it");
        zootopiaDownloadButton.setStatus(it);
        this$0.ei(it);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Gi(ZootopiaDetailFragmentV2 this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        pv4.f fVar = this$0.guideStatus;
        Intrinsics.checkNotNull(fVar);
        this$0.ai(fVar);
    }

    private final void Ii() {
        fi3.u uVar = this.binding;
        if (uVar == null) {
            return;
        }
        this.tabBarTopMargin = Bh();
        int dimensionPixelSize = requireContext().getResources().getDimensionPixelSize(R.dimen.f12086i);
        this.tabBarContentHeight = dimensionPixelSize;
        this.appBarContainerNormalMinHeight = this.tabBarTopMargin + dimensionPixelSize;
        ViewGroup.LayoutParams layoutParams = uVar.f399387d.getLayoutParams();
        layoutParams.height = this.tabBarTopMargin;
        uVar.f399387d.setLayoutParams(layoutParams);
    }

    private final void Ji(boolean useDark) {
        if (this.isStatusBarDarkMode != useDark) {
            QLog.i("ZootopiaDetailFragmentV2", 1, "updateStatusBarColorMode - " + useDark);
            this.isStatusBarDarkMode = useDark;
            if (ImmersiveUtils.couldSetStatusTextColor()) {
                ImmersiveUtils.setStatusTextColor(useDark, requireActivity().getWindow());
            }
        }
    }

    private final void Yh(ZootopiaMapDetail detail) {
        ZootopiaDownloadButton zootopiaDownloadButton;
        ZootopiaDownloadButton zootopiaDownloadButton2;
        ZootopiaDownloadButton zootopiaDownloadButton3;
        ZootopiaDownloadButton zootopiaDownloadButton4;
        QLog.i("ZootopiaDetailFragmentV2", 1, "bindDownloadButtonWithDetail " + detail);
        ZootopiaDetailV2HeaderView zootopiaDetailV2HeaderView = this.headerView;
        if (zootopiaDetailV2HeaderView == null) {
            return;
        }
        zootopiaDetailV2HeaderView.getBtnEnter().setButtonStatusListener(gi(detail));
        zootopiaDetailV2HeaderView.getBtnEnter().setDownloadSize(detail);
        ZootopiaDownloadButton btnEnter = zootopiaDetailV2HeaderView.getBtnEnter();
        ButtonStatus buttonStatus = ButtonStatus.LOADED;
        btnEnter.setStatusText(buttonStatus, detail.getButtonText());
        fi3.u uVar = this.binding;
        if (uVar != null && (zootopiaDownloadButton4 = uVar.f399399p) != null) {
            zootopiaDownloadButton4.setButtonStatusListener(gi(detail));
        }
        fi3.u uVar2 = this.binding;
        if (uVar2 != null && (zootopiaDownloadButton3 = uVar2.f399399p) != null) {
            zootopiaDownloadButton3.setDownloadSize(detail);
        }
        fi3.u uVar3 = this.binding;
        if (uVar3 != null && (zootopiaDownloadButton2 = uVar3.f399399p) != null) {
            zootopiaDownloadButton2.setStatusText(buttonStatus, detail.getButtonText());
        }
        if (ZPlanCloudGameInfo.INSTANCE.a(detail.getCloudGameInfo())) {
            zootopiaDetailV2HeaderView.getBtnEnter().setIsInitCloudModType(true);
            ZootopiaDownloadButton btnEnter2 = zootopiaDetailV2HeaderView.getBtnEnter();
            ButtonStatus buttonStatus2 = ButtonStatus.CLOUD_GAME;
            btnEnter2.setStatus(buttonStatus2);
            fi3.u uVar4 = this.binding;
            if (uVar4 != null && (zootopiaDownloadButton = uVar4.f399399p) != null) {
                zootopiaDownloadButton.setIsInitCloudModType(true);
            }
            fi3.u uVar5 = this.binding;
            ZootopiaDownloadButton zootopiaDownloadButton5 = uVar5 != null ? uVar5.f399399p : null;
            if (zootopiaDownloadButton5 == null) {
                return;
            }
            zootopiaDownloadButton5.setStatus(buttonStatus2);
        }
    }

    private final void Zh(int mapId) {
        QLog.i("ZootopiaDetailFragmentV2", 1, "bindDownloadButtonWithId " + mapId);
        ii().M1(String.valueOf(mapId));
        LiveData<ButtonStatus> P1 = ii().P1(String.valueOf(mapId));
        if (P1 != null) {
            P1.removeObserver(this.statusObserver);
            P1.observe(getViewLifecycleOwner(), this.statusObserver);
        }
        LiveData<Float> O1 = ii().O1(String.valueOf(mapId));
        if (O1 != null) {
            O1.removeObserver(this.progressObserver);
            O1.observe(getViewLifecycleOwner(), this.progressObserver);
        }
    }

    private final void ai(pv4.f status) {
        com.tencent.sqshow.zootopia.guide.h k3 = com.tencent.sqshow.zootopia.guide.q.f370741a.k(status);
        ZplanGuideManager a16 = ZplanGuideManager.INSTANCE.a();
        Lifecycle lifecycle = getLifecycle();
        Intrinsics.checkNotNullExpressionValue(lifecycle, "lifecycle");
        a16.n(lifecycle, k3);
    }

    private final boolean bi(ButtonStatus buttonStatus) {
        int i3 = c.f328714a[buttonStatus.ordinal()];
        return i3 == 1 || i3 == 2 || i3 == 3 || i3 == 4 || i3 == 5;
    }

    private final void fi() {
        ZPlanFloatWindowManager.d(ZPlanFloatWindowManager.f335646d, Integer.valueOf(ki().T1()), null, new d(), 2, null);
    }

    private final an gi(ZootopiaMapDetail detail) {
        Context requireContext = requireContext();
        Intrinsics.checkNotNullExpressionValue(requireContext, "requireContext()");
        return new an(requireContext, detail, ii(), Ch(), this.config.getUeParams());
    }

    private final ZootopiaDetailFragmentV2$guideTipsView$2.a hi() {
        return (ZootopiaDetailFragmentV2$guideTipsView$2.a) this.guideTipsView.getValue();
    }

    private final oa4.a ii() {
        return (oa4.a) this.mapResVm.getValue();
    }

    private final ah ji() {
        return (ah) this.reportHelper.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final am ki() {
        return (am) this.vm.getValue();
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void li(List<ZootopiaMapTab> tabList) {
        Object obj;
        List<pv4.f> a16;
        ZootopiaDownloadButton btnEnter;
        ZootopiaDownloadButton btnEnter2;
        if (tabList.isEmpty()) {
            return;
        }
        ZootopiaDetailV2HeaderView zootopiaDetailV2HeaderView = this.headerView;
        final pv4.f fVar = null;
        ButtonStatus status = (zootopiaDetailV2HeaderView == null || (btnEnter2 = zootopiaDetailV2HeaderView.getBtnEnter()) == null) ? null : btnEnter2.getStatus();
        ZootopiaDetailV2HeaderView zootopiaDetailV2HeaderView2 = this.headerView;
        QLog.d("ZootopiaDetailFragmentV2", 1, "skip guide as downloaded " + ((zootopiaDetailV2HeaderView2 == null || (btnEnter = zootopiaDetailV2HeaderView2.getBtnEnter()) == null) ? null : btnEnter.getStatus()));
        if (status == ButtonStatus.INIT || status == ButtonStatus.PAUSE) {
            Iterator<T> it = tabList.iterator();
            while (true) {
                if (!it.hasNext()) {
                    obj = null;
                    break;
                } else {
                    obj = it.next();
                    if (((ZootopiaMapTab) obj).h()) {
                        break;
                    }
                }
            }
            ZootopiaMapTab zootopiaMapTab = (ZootopiaMapTab) obj;
            if (com.tencent.mobileqq.zootopia.g.f328305a.d()) {
                fVar = new pv4.f();
                fVar.f427598b = 10;
                fVar.f427599c = 0;
            } else if (zootopiaMapTab != null && (a16 = zootopiaMapTab.a()) != null) {
                Iterator<T> it5 = a16.iterator();
                while (true) {
                    if (!it5.hasNext()) {
                        break;
                    }
                    Object next = it5.next();
                    pv4.f fVar2 = (pv4.f) next;
                    if (fVar2.f427598b == 10 && com.tencent.sqshow.zootopia.guide.j.a(fVar2)) {
                        fVar = next;
                        break;
                    }
                }
                fVar = fVar;
            }
            QLog.d("ZootopiaDetailFragmentV2", 1, "rankTabConfig  " + zootopiaMapTab + " " + fVar);
            if (fVar != null) {
                final FragmentActivity activity = getActivity();
                if (activity != null) {
                    ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.mobileqq.zootopia.portal.detail.s
                        @Override // java.lang.Runnable
                        public final void run() {
                            ZootopiaDetailFragmentV2.mi(FragmentActivity.this, fVar, this);
                        }
                    });
                }
                QLog.d("ZootopiaDetailFragmentV2", 1, "trigger guide here " + fVar);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void mi(FragmentActivity it, pv4.f fVar, ZootopiaDetailFragmentV2 this$0) {
        Intrinsics.checkNotNullParameter(it, "$it");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        DetailGuideTask detailGuideTask = new DetailGuideTask(it, fVar, this$0.Ch());
        ZplanGuideManager a16 = ZplanGuideManager.INSTANCE.a();
        Lifecycle lifecycle = this$0.getLifecycle();
        Intrinsics.checkNotNullExpressionValue(lifecycle, "lifecycle");
        a16.n(lifecycle, detailGuideTask);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void oi(ZootopiaDetailFragmentV2 this$0, pv4.f fVar) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.ai(fVar);
    }

    private final void pi() {
        am ki5 = ki();
        Bundle arguments = getArguments();
        Serializable serializable = arguments != null ? arguments.getSerializable("ZOOTOPIA_MAP_INFO") : null;
        ki5.f2(serializable instanceof ZootopiaMapSimpleInfo ? (ZootopiaMapSimpleInfo) serializable : null);
        am ki6 = ki();
        Bundle arguments2 = getArguments();
        ki6.e2(arguments2 != null ? arguments2.getInt("mapId", 0) : 0);
        ki().b2();
        Bundle arguments3 = getArguments();
        Serializable serializable2 = arguments3 != null ? arguments3.getSerializable("detail_config") : null;
        ZootopiaDetailFragment.Config config = serializable2 instanceof ZootopiaDetailFragment.Config ? (ZootopiaDetailFragment.Config) serializable2 : null;
        if (config == null) {
            config = new ZootopiaDetailFragment.Config(0, false, false, false, null, null, false, null, 255, null);
        }
        this.config = config;
        Bundle arguments4 = getArguments();
        this.isCloudMod = arguments4 != null ? arguments4.getBoolean("isDetailCloudMod", false) : false;
    }

    private final void qi(Float buttonProgress, ButtonStatus buttonStatus, ZootopiaMapSimpleInfo mapSimpleInfo) {
        ZootopiaDownloadButton zootopiaDownloadButton;
        ZootopiaDownloadButton zootopiaDownloadButton2;
        ZootopiaDownloadButton btnEnter;
        ZootopiaDownloadButton btnEnter2;
        ZootopiaDownloadButton zootopiaDownloadButton3;
        ZootopiaDownloadButton btnEnter3;
        ZootopiaDownloadButton zootopiaDownloadButton4;
        ZootopiaDownloadButton btnEnter4;
        ZootopiaDownloadButton zootopiaDownloadButton5;
        ZootopiaDownloadButton btnEnter5;
        ZootopiaDetailV2HeaderView zootopiaDetailV2HeaderView = this.headerView;
        if (zootopiaDetailV2HeaderView != null && (btnEnter5 = zootopiaDetailV2HeaderView.getBtnEnter()) != null) {
            btnEnter5.setCloudModButtonStyle(s84.b.f433495a.a(3));
        }
        fi3.u uVar = this.binding;
        if (uVar != null && (zootopiaDownloadButton5 = uVar.f399399p) != null) {
            zootopiaDownloadButton5.setCloudModButtonStyle(s84.b.f433495a.a(2));
        }
        if (buttonProgress != null) {
            float floatValue = buttonProgress.floatValue();
            ZootopiaDetailV2HeaderView zootopiaDetailV2HeaderView2 = this.headerView;
            if (zootopiaDetailV2HeaderView2 != null && (btnEnter4 = zootopiaDetailV2HeaderView2.getBtnEnter()) != null) {
                btnEnter4.setProcess(floatValue);
            }
            fi3.u uVar2 = this.binding;
            if (uVar2 != null && (zootopiaDownloadButton4 = uVar2.f399399p) != null) {
                zootopiaDownloadButton4.setProcess(floatValue);
            }
        }
        if (buttonStatus != null) {
            if (this.isCloudMod && ZootopiaDownloadButtonBinder.INSTANCE.a(buttonStatus)) {
                buttonStatus = ButtonStatus.CLOUD_GAME;
                ZootopiaDetailV2HeaderView zootopiaDetailV2HeaderView3 = this.headerView;
                if (zootopiaDetailV2HeaderView3 != null && (btnEnter3 = zootopiaDetailV2HeaderView3.getBtnEnter()) != null) {
                    btnEnter3.setIsInitCloudModType(true);
                }
                fi3.u uVar3 = this.binding;
                if (uVar3 != null && (zootopiaDownloadButton3 = uVar3.f399399p) != null) {
                    zootopiaDownloadButton3.setIsInitCloudModType(true);
                }
            }
            ZootopiaDetailV2HeaderView zootopiaDetailV2HeaderView4 = this.headerView;
            ZootopiaDownloadButton btnEnter6 = zootopiaDetailV2HeaderView4 != null ? zootopiaDetailV2HeaderView4.getBtnEnter() : null;
            if (btnEnter6 != null) {
                btnEnter6.setStatus(buttonStatus);
            }
            fi3.u uVar4 = this.binding;
            ZootopiaDownloadButton zootopiaDownloadButton6 = uVar4 != null ? uVar4.f399399p : null;
            if (zootopiaDownloadButton6 != null) {
                zootopiaDownloadButton6.setStatus(buttonStatus);
            }
        }
        if (mapSimpleInfo != null) {
            ZootopiaMapDetail a16 = ZootopiaMapDetail.INSTANCE.a(mapSimpleInfo);
            ZootopiaDetailV2HeaderView zootopiaDetailV2HeaderView5 = this.headerView;
            if (zootopiaDetailV2HeaderView5 != null && (btnEnter2 = zootopiaDetailV2HeaderView5.getBtnEnter()) != null) {
                btnEnter2.setDownloadSize(a16);
            }
            ZootopiaDetailV2HeaderView zootopiaDetailV2HeaderView6 = this.headerView;
            if (zootopiaDetailV2HeaderView6 != null && (btnEnter = zootopiaDetailV2HeaderView6.getBtnEnter()) != null) {
                btnEnter.setStatusText(ButtonStatus.LOADED, a16.getButtonText());
            }
            fi3.u uVar5 = this.binding;
            if (uVar5 != null && (zootopiaDownloadButton2 = uVar5.f399399p) != null) {
                zootopiaDownloadButton2.setDownloadSize(a16);
            }
            fi3.u uVar6 = this.binding;
            if (uVar6 == null || (zootopiaDownloadButton = uVar6.f399399p) == null) {
                return;
            }
            zootopiaDownloadButton.setStatusText(ButtonStatus.LOADED, a16.getButtonText());
        }
    }

    private final void ri() {
        bk guideView;
        ZootopiaDetailV2HeaderView zootopiaDetailV2HeaderView = this.headerView;
        if (zootopiaDetailV2HeaderView == null || (guideView = zootopiaDetailV2HeaderView.getGuideView()) == null) {
            return;
        }
        TextView textView = guideView.f418852e;
        if (textView != null) {
            textView.setText(R.string.xpr);
        }
        ConstraintLayout constraintLayout = guideView.f418849b;
        if (constraintLayout == null) {
            return;
        }
        constraintLayout.setVisibility(8);
    }

    private final void si(boolean isPined) {
        ZootopiaDetailTabViewPager zootopiaDetailTabViewPager;
        xc3.b m3;
        ZootopiaDetailTabViewPager zootopiaDetailTabViewPager2;
        fi3.u uVar = this.binding;
        int currentItem = (uVar == null || (zootopiaDetailTabViewPager2 = uVar.f399394k) == null) ? 0 : zootopiaDetailTabViewPager2.getCurrentItem();
        fi3.u uVar2 = this.binding;
        if (uVar2 == null || (zootopiaDetailTabViewPager = uVar2.f399394k) == null || (m3 = zootopiaDetailTabViewPager.m(currentItem)) == null) {
            return;
        }
        m3.x8(isPined);
    }

    private final void ti(ScrollingHeaderLayout appBarLayout, int verticalOffset) {
        float height;
        ZootopiaDetailTabView zootopiaDetailTabView;
        int i3 = this.tabBarTopMargin;
        int i16 = this.tabBarContentHeight;
        int i17 = i3 + i16;
        if (verticalOffset > (i16 + i17) - appBarLayout.getHeight()) {
            height = 0.0f;
        } else {
            height = verticalOffset <= i17 - appBarLayout.getHeight() ? 1.0f : ((r2 - appBarLayout.getHeight()) - verticalOffset) / i16;
        }
        if (this.isAppBarPined != (height == 1.0f)) {
            boolean z16 = height == 1.0f;
            this.isAppBarPined = z16;
            si(z16);
        }
        fi3.u uVar = this.binding;
        if ((uVar == null || (zootopiaDetailTabView = uVar.f399395l) == null || zootopiaDetailTabView.getVisibility() != 0) ? false : true) {
            ci(height);
        } else {
            di(height);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void ui(ZootopiaDetailFragmentV2 this$0, ScrollingHeaderLayout appBarLayout, int i3) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullExpressionValue(appBarLayout, "appBarLayout");
        this$0.ti(appBarLayout, i3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void vi(ZootopiaDetailFragmentV2 this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.ki().b2();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void wi(ZootopiaDetailFragmentV2 this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        ZootopiaDetailV2HeaderView zootopiaDetailV2HeaderView = this$0.headerView;
        Intrinsics.checkNotNull(zootopiaDetailV2HeaderView, "null cannot be cast to non-null type android.view.View");
        this$0.Ei(zootopiaDetailV2HeaderView);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void xi(ZootopiaDetailFragmentV2 this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        ZootopiaActivity.Companion companion = ZootopiaActivity.INSTANCE;
        Context requireContext = this$0.requireContext();
        Intrinsics.checkNotNullExpressionValue(requireContext, "requireContext()");
        ZootopiaActivity.Companion.c(companion, requireContext, ZootopiaDownloadManagerFragment.class, this$0.Ch(), null, false, 24, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void yi(fi3.u binding, Integer count) {
        Intrinsics.checkNotNullParameter(binding, "$binding");
        Intrinsics.checkNotNullExpressionValue(count, "count");
        if (count.intValue() > 0) {
            binding.f399391h.setText(String.valueOf(count));
            binding.f399391h.setVisibility(0);
        } else {
            binding.f399391h.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void zi(fi3.u binding, Integer downloadingCount) {
        Intrinsics.checkNotNullParameter(binding, "$binding");
        Intrinsics.checkNotNullExpressionValue(downloadingCount, "downloadingCount");
        if (downloadingCount.intValue() > 0) {
            binding.f399393j.setVisibility(8);
            binding.f399392i.setVisibility(0);
        } else {
            binding.f399392i.setVisibility(8);
            binding.f399393j.setVisibility(0);
        }
    }

    @Override // com.tencent.sqshow.zootopia.view.pull2refresh.ZootopiaDetailPullToRefreshView.c
    public void F1(ZootopiaDetailPullToRefreshView recyclerView, boolean isMachineRefresh) {
        ZootopiaDetailTabViewPager zootopiaDetailTabViewPager;
        xc3.b m3;
        ZootopiaDetailTabViewPager zootopiaDetailTabViewPager2;
        fi3.u uVar = this.binding;
        int currentItem = (uVar == null || (zootopiaDetailTabViewPager2 = uVar.f399394k) == null) ? 0 : zootopiaDetailTabViewPager2.getCurrentItem();
        fi3.u uVar2 = this.binding;
        if (uVar2 == null || (zootopiaDetailTabViewPager = uVar2.f399394k) == null || (m3 = zootopiaDetailTabViewPager.m(currentItem)) == null) {
            return;
        }
        m3.X0();
    }

    public final void Hi() {
        ZplanGuideManager a16 = ZplanGuideManager.INSTANCE.a();
        Lifecycle lifecycle = getLifecycle();
        Intrinsics.checkNotNullExpressionValue(lifecycle, "lifecycle");
        a16.p(lifecycle, 7, new b(this));
    }

    @Override // xc3.a
    public void Y() {
        ZootopiaDetailPullToRefreshView zootopiaDetailPullToRefreshView;
        fi3.u uVar = this.binding;
        if (uVar == null || (zootopiaDetailPullToRefreshView = uVar.f399400q) == null) {
            return;
        }
        zootopiaDetailPullToRefreshView.s(true);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.sqshow.fragment.ZootopiaBaseFragment
    public String getSubSource() {
        return ZootopiaSource.SUB_SOURCE_MAP_DETAIL;
    }

    public final void ni(List<pv4.f> data) {
        ButtonStatus buttonStatus;
        Object obj;
        ZootopiaDownloadButton btnEnter;
        ZootopiaDownloadButton btnEnter2;
        Intrinsics.checkNotNullParameter(data, "data");
        Iterator<T> it = data.iterator();
        while (true) {
            buttonStatus = null;
            if (!it.hasNext()) {
                obj = null;
                break;
            }
            obj = it.next();
            pv4.f fVar = (pv4.f) obj;
            if (fVar.f427598b == 12 && com.tencent.sqshow.zootopia.guide.j.a(fVar)) {
                break;
            }
        }
        final pv4.f fVar2 = (pv4.f) obj;
        QLog.d("ZootopiaDetailFragmentV2", 1, "get valid data  " + fVar2);
        if (fVar2 != null) {
            ZootopiaDetailV2HeaderView zootopiaDetailV2HeaderView = this.headerView;
            if (zootopiaDetailV2HeaderView != null && (btnEnter2 = zootopiaDetailV2HeaderView.getBtnEnter()) != null) {
                buttonStatus = btnEnter2.getStatus();
            }
            if (buttonStatus == ButtonStatus.LOADED) {
                ZootopiaDetailV2HeaderView zootopiaDetailV2HeaderView2 = this.headerView;
                if (zootopiaDetailV2HeaderView2 == null || (btnEnter = zootopiaDetailV2HeaderView2.getBtnEnter()) == null) {
                    return;
                }
                btnEnter.post(new Runnable() { // from class: com.tencent.mobileqq.zootopia.portal.detail.r
                    @Override // java.lang.Runnable
                    public final void run() {
                        ZootopiaDetailFragmentV2.oi(ZootopiaDetailFragmentV2.this, fVar2);
                    }
                });
                return;
            }
        }
        this.guideStatus = fVar2;
    }

    @Override // com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, com.tencent.biz.richframework.compat.IFragmentCallbacks
    public boolean onBackEvent() {
        QLog.i("ZootopiaDetailFragmentV2", 1, "onBackEvent - " + this);
        fi();
        return true;
    }

    @Override // com.tencent.mobileqq.zootopia.api.b
    public boolean onBackPressedEvent() {
        QLog.i("ZootopiaDetailFragmentV2", 1, "onBackPressedEvent - " + this);
        fi();
        return true;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v3) {
        onBackPressedEvent();
    }

    @Override // com.tencent.sqshow.fragment.ZootopiaBaseFragment, com.tencent.sqshow.fragment.ZPlanPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setEnterTransition(new Fade());
        QLog.i("ZootopiaDetailFragmentV2", 1, "onCreate - " + this);
        SimpleEventBus.getInstance().registerReceiver(hi());
    }

    @Override // com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        this.binding = fi3.u.g(inflater, container, false);
        Ii();
        fi3.u uVar = this.binding;
        if (uVar != null) {
            return uVar.getRoot();
        }
        return null;
    }

    @Override // com.tencent.widget.pull2refresh.anim.IAnimManager.OnRefreshPullDistanceListener
    public void onPullDistance(int distance, int touchMode) {
        ZootopiaDetailV2HeaderView zootopiaDetailV2HeaderView = this.headerView;
        if (zootopiaDetailV2HeaderView != null) {
            zootopiaDetailV2HeaderView.w(distance);
        }
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public void onReceiveEvent(SimpleBaseEvent event) {
        if ((event instanceof ZplanGuideTriggerEvent) && ((ZplanGuideTriggerEvent) event).getSourceId() == 7) {
            Hi();
        }
    }

    @Override // com.tencent.sqshow.fragment.ZootopiaBaseFragment, com.tencent.sqshow.fragment.ZPlanPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        Hi();
    }

    @Override // com.tencent.sqshow.fragment.ZootopiaBaseFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle savedInstanceState) {
        int T1;
        int T12;
        int T13;
        String name;
        String name2;
        Intrinsics.checkNotNullParameter(view, "view");
        QLog.i("ZootopiaDetailFragmentV2", 1, "onViewCreated - " + this);
        final fi3.u uVar = this.binding;
        if (uVar == null) {
            return;
        }
        pi();
        this.headerView = uVar.f399397n;
        ZootopiaDetailPullToRefreshView zootopiaDetailPullToRefreshView = uVar.f399400q;
        zootopiaDetailPullToRefreshView.Q = this;
        zootopiaDetailPullToRefreshView.setOnRefreshPullDistanceListener(this);
        zootopiaDetailPullToRefreshView.setRefreshCallback(this);
        zootopiaDetailPullToRefreshView.setHeaderNightStyle(Boolean.TRUE);
        zootopiaDetailPullToRefreshView.x();
        ZootopiaDetailFragment.Config config = this.config;
        zootopiaDetailPullToRefreshView.setRefreshEnable(config != null ? config.getEnablePullRefresh() : true);
        uVar.f399395l.setVisibility(8);
        ZootopiaDetailV2HeaderView zootopiaDetailV2HeaderView = uVar.f399397n;
        this.headerView = zootopiaDetailV2HeaderView;
        if (zootopiaDetailV2HeaderView != null) {
            zootopiaDetailV2HeaderView.u(Dh(), this, ki());
        }
        ZootopiaDetailV2HeaderView zootopiaDetailV2HeaderView2 = this.headerView;
        if (zootopiaDetailV2HeaderView2 != null) {
            Intrinsics.checkNotNull(zootopiaDetailV2HeaderView2);
            ViewCompat.setTransitionName(zootopiaDetailV2HeaderView2, "zootopia_share_bg");
        }
        qi(this.config.getButtonProgress(), this.config.getButtonStatus(), ki().getMapItemInfo());
        uVar.f399394k.i(ki(), ii(), ji(), this.headerView, this.config, uVar.f399401r, this);
        uVar.f399395l.setViewPager(uVar.f399394k);
        if (this.config.getNeedBack()) {
            uVar.f399389f.setVisibility(0);
            uVar.f399389f.setOnClickListener(this);
            uVar.f399398o.setVisibility(0);
            uVar.f399398o.setOnClickListener(this);
        } else {
            uVar.f399389f.setVisibility(8);
            uVar.f399398o.setVisibility(8);
        }
        uVar.f399402s.getBtnNetworkError().setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.zootopia.portal.detail.u
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                ZootopiaDetailFragmentV2.vi(ZootopiaDetailFragmentV2.this, view2);
            }
        });
        if (this.config.getNeedAnimation()) {
            ZootopiaDetailV2HeaderView zootopiaDetailV2HeaderView3 = this.headerView;
            if (zootopiaDetailV2HeaderView3 != null) {
                zootopiaDetailV2HeaderView3.setTranslationY(100.0f);
            }
            ZootopiaDetailV2HeaderView zootopiaDetailV2HeaderView4 = this.headerView;
            if (zootopiaDetailV2HeaderView4 != null) {
                zootopiaDetailV2HeaderView4.setAlpha(0.0f);
            }
            ZootopiaDetailV2HeaderView zootopiaDetailV2HeaderView5 = this.headerView;
            if (zootopiaDetailV2HeaderView5 != null) {
                zootopiaDetailV2HeaderView5.post(new Runnable() { // from class: com.tencent.mobileqq.zootopia.portal.detail.v
                    @Override // java.lang.Runnable
                    public final void run() {
                        ZootopiaDetailFragmentV2.wi(ZootopiaDetailFragmentV2.this);
                    }
                });
            }
        }
        uVar.f399399p.setShowButtonSubText(false);
        uVar.f399390g.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.zootopia.portal.detail.w
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                ZootopiaDetailFragmentV2.xi(ZootopiaDetailFragmentV2.this, view2);
            }
        });
        vc3.g gVar = vc3.g.f441394a;
        Context context = getContext();
        ImageView imageView = uVar.f399392i;
        Intrinsics.checkNotNullExpressionValue(imageView, "binding.btnDownloadDynamicIcon");
        gVar.c(context, "ZootopiaDetailDownload", imageView);
        ii().N1().observe(getViewLifecycleOwner(), new Observer() { // from class: com.tencent.mobileqq.zootopia.portal.detail.x
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                ZootopiaDetailFragmentV2.yi(fi3.u.this, (Integer) obj);
            }
        });
        ii().Q1().observe(getViewLifecycleOwner(), new Observer() { // from class: com.tencent.mobileqq.zootopia.portal.detail.y
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                ZootopiaDetailFragmentV2.zi(fi3.u.this, (Integer) obj);
            }
        });
        ZootopiaMapSimpleInfo mapItemInfo = ki().getMapItemInfo();
        if (mapItemInfo != null) {
            T1 = mapItemInfo.getMapID();
        } else {
            T1 = ki().T1();
        }
        Zh(T1);
        ki().R1().observe(getViewLifecycleOwner(), new Observer() { // from class: com.tencent.mobileqq.zootopia.portal.detail.z
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                ZootopiaDetailFragmentV2.Ai(fi3.u.this, this, (ZootopiaMapDetail) obj);
            }
        });
        ki().S1().observe(getViewLifecycleOwner(), new Observer() { // from class: com.tencent.mobileqq.zootopia.portal.detail.aa
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                ZootopiaDetailFragmentV2.Bi(fi3.u.this, this, (ErrorMessage) obj);
            }
        });
        this.needAutoDownload = (!this.isCloudMod || ZootopiaDownloadButtonBinder.INSTANCE.a(this.config.getButtonStatus())) ? this.config.getNeedDownload() : true;
        uVar.f399385b.b(new ScrollingHeaderLayout.c() { // from class: com.tencent.mobileqq.zootopia.portal.detail.ab
            @Override // com.tencent.sqshow.zootopia.portal.detail.scrollingheader.ScrollingHeaderLayout.b
            public final void a(ScrollingHeaderLayout scrollingHeaderLayout, int i3) {
                ZootopiaDetailFragmentV2.ui(ZootopiaDetailFragmentV2.this, scrollingHeaderLayout, i3);
            }
        });
        ah ji5 = ji();
        ZootopiaMapSimpleInfo mapItemInfo2 = ki().getMapItemInfo();
        if (mapItemInfo2 != null) {
            T12 = mapItemInfo2.getMapID();
        } else {
            T12 = ki().T1();
        }
        int i3 = T12;
        ZootopiaMapSimpleInfo mapItemInfo3 = ki().getMapItemInfo();
        ah.f(ji5, view, i3, (mapItemInfo3 == null || (name2 = mapItemInfo3.getName()) == null) ? "" : name2, Dh(), null, 16, null);
        ZootopiaDetailV2HeaderView zootopiaDetailV2HeaderView6 = this.headerView;
        ZootopiaMapSimpleInfo mapItemInfo4 = ki().getMapItemInfo();
        if (mapItemInfo4 != null) {
            T13 = mapItemInfo4.getMapID();
        } else {
            T13 = ki().T1();
        }
        int i16 = T13;
        ZootopiaMapSimpleInfo mapItemInfo5 = ki().getMapItemInfo();
        ah.f(ji5, zootopiaDetailV2HeaderView6, i16, (mapItemInfo5 == null || (name = mapItemInfo5.getName()) == null) ? "" : name, Dh(), null, 16, null);
        ZootopiaDetailV2HeaderView zootopiaDetailV2HeaderView7 = this.headerView;
        ah.c(ji5, zootopiaDetailV2HeaderView7 != null ? zootopiaDetailV2HeaderView7.getBtnEnter() : null, false, true, 2, null);
        ji5.b(uVar.f399393j, true, true);
        uVar.f399394k.addOnPageChangeListener(new e(uVar));
        ri();
    }

    @Override // com.tencent.sqshow.zootopia.view.pull2refresh.ZootopiaDetailPullToRefreshView.b
    public ViewGroup.LayoutParams u7() {
        CoordinatorLayout coordinatorLayout;
        fi3.u uVar = this.binding;
        if (uVar == null || (coordinatorLayout = uVar.f399396m) == null) {
            return null;
        }
        return coordinatorLayout.getLayoutParams();
    }

    private final void Ei(View target) {
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(target, "translationY", 100.0f, 0.0f);
        ofFloat.setDuration(600L);
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(target, com.tencent.luggage.wxa.c8.c.f123400v, 0.0f, 1.0f);
        ofFloat2.setDuration(350L);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.setInterpolator(new PathInterpolator(0.28f, 0.03f, 0.25f, 1.0f));
        animatorSet.playTogether(ofFloat, ofFloat2);
        animatorSet.start();
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public ArrayList<Class<ZplanGuideTriggerEvent>> getEventClass() {
        ArrayList<Class<ZplanGuideTriggerEvent>> arrayListOf;
        arrayListOf = CollectionsKt__CollectionsKt.arrayListOf(ZplanGuideTriggerEvent.class);
        return arrayListOf;
    }

    @Override // com.tencent.sqshow.fragment.ZootopiaBaseFragment, com.tencent.sqshow.fragment.ZPlanPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        this.binding = null;
        super.onDestroy();
        QLog.i("ZootopiaDetailFragmentV2", 1, "onDestroy - " + this + " - " + ki().T1());
        SimpleEventBus.getInstance().dispatchEvent(new ZootopiaDetailFragmentCloseEvent(ki().T1(), Ch(), false, 4, null));
        SimpleEventBus.getInstance().unRegisterReceiver(hi());
    }

    private final void ei(ButtonStatus buttonStatus) {
        int id5;
        HashMap<String, Object> hashMapOf;
        if (buttonStatus != null && this.needAutoDownload && bi(buttonStatus)) {
            ZootopiaMapSimpleInfo mapItemInfo = ki().getMapItemInfo();
            if (mapItemInfo != null) {
                id5 = mapItemInfo.getMapID();
            } else {
                ZootopiaMapDetail value = ki().R1().getValue();
                id5 = value != null ? value.getId() : 0;
            }
            if (id5 > 0) {
                QLog.i("ZootopiaDetailFragmentV2", 1, "autoDownload - saveModBtnReportParams - " + id5);
                com.tencent.sqshow.zootopia.report.a aVar = com.tencent.sqshow.zootopia.report.a.f372690a;
                ZootopiaSource Ch = Ch();
                hashMapOf = MapsKt__MapsKt.hashMapOf(TuplesKt.to("dt_pgid", "pg_zplan_playground_detail"));
                aVar.e(id5, buttonStatus, Ch, hashMapOf);
                this.needAutoDownload = false;
                ZootopiaMapSimpleInfo mapItemInfo2 = ki().getMapItemInfo();
                if (mapItemInfo2 != null) {
                    ii().U1(mapItemInfo2, true);
                    return;
                }
                ZootopiaMapDetail value2 = ki().R1().getValue();
                if (value2 != null) {
                    ii().T1(value2, true);
                    return;
                }
                return;
            }
            QLog.e("ZootopiaDetailFragmentV2", 1, "modMapId invalid - " + id5);
        }
    }

    @Override // com.tencent.sqshow.zootopia.view.pull2refresh.ZootopiaDetailPullToRefreshView.b
    public void Xf(RelativeLayout.LayoutParams lp5) {
        if (lp5 != null) {
            fi3.u uVar = this.binding;
            CoordinatorLayout coordinatorLayout = uVar != null ? uVar.f399396m : null;
            if (coordinatorLayout == null) {
                return;
            }
            coordinatorLayout.setLayoutParams(lp5);
        }
    }

    @Override // com.tencent.sqshow.zootopia.view.pull2refresh.ZootopiaDetailPullToRefreshView.b
    public boolean canScrollVertically(int dirct) {
        ScrollingHeaderLayout scrollingHeaderLayout;
        ScrollingHeaderLayout scrollingHeaderLayout2;
        if (dirct >= 0) {
            return true;
        }
        fi3.u uVar = this.binding;
        int height = (uVar == null || (scrollingHeaderLayout2 = uVar.f399385b) == null) ? 0 : scrollingHeaderLayout2.getHeight();
        fi3.u uVar2 = this.binding;
        return height != ((uVar2 == null || (scrollingHeaderLayout = uVar2.f399385b) == null) ? 0 : scrollingHeaderLayout.getBottom());
    }

    private final void di(float percent) {
        int i3;
        View view;
        float f16 = 0.0f;
        if (percent <= 0.0f) {
            i3 = 8;
        } else {
            f16 = percent < 1.0f ? percent : 1.0f;
            i3 = 0;
        }
        fi3.u uVar = this.binding;
        if (!((uVar == null || (view = uVar.f399387d) == null || view.getVisibility() != i3) ? false : true)) {
            fi3.u uVar2 = this.binding;
            View view2 = uVar2 != null ? uVar2.f399387d : null;
            if (view2 != null) {
                view2.setVisibility(i3);
            }
        }
        fi3.u uVar3 = this.binding;
        View view3 = uVar3 != null ? uVar3.f399387d : null;
        if (view3 != null) {
            view3.setAlpha(f16);
        }
        Ji(f16 >= 0.7f);
    }

    private final void ci(float percent) {
        int i3;
        ZootopiaDetailTabView zootopiaDetailTabView;
        RelativeLayout relativeLayout;
        View view;
        if (percent <= 0.0f) {
            percent = 0.0f;
            i3 = 8;
        } else {
            if (percent >= 1.0f) {
                percent = 1.0f;
            }
            i3 = 0;
        }
        fi3.u uVar = this.binding;
        if (!((uVar == null || (view = uVar.f399387d) == null || view.getVisibility() != i3) ? false : true)) {
            fi3.u uVar2 = this.binding;
            View view2 = uVar2 != null ? uVar2.f399387d : null;
            if (view2 != null) {
                view2.setVisibility(i3);
            }
        }
        fi3.u uVar3 = this.binding;
        if (!((uVar3 == null || (relativeLayout = uVar3.f399388e) == null || relativeLayout.getVisibility() != i3) ? false : true)) {
            fi3.u uVar4 = this.binding;
            RelativeLayout relativeLayout2 = uVar4 != null ? uVar4.f399388e : null;
            if (relativeLayout2 != null) {
                relativeLayout2.setVisibility(i3);
            }
        }
        fi3.u uVar5 = this.binding;
        View view3 = uVar5 != null ? uVar5.f399387d : null;
        if (view3 != null) {
            view3.setAlpha(percent);
        }
        fi3.u uVar6 = this.binding;
        RelativeLayout relativeLayout3 = uVar6 != null ? uVar6.f399388e : null;
        if (relativeLayout3 != null) {
            relativeLayout3.setAlpha(percent);
        }
        fi3.u uVar7 = this.binding;
        if (uVar7 != null && (zootopiaDetailTabView = uVar7.f399395l) != null) {
            zootopiaDetailTabView.i(percent);
        }
        Ji(percent >= 0.7f);
        float f16 = 1 - percent;
        fi3.u uVar8 = this.binding;
        TextView textView = uVar8 != null ? uVar8.f399391h : null;
        if (textView != null) {
            textView.setAlpha(f16);
        }
        fi3.u uVar9 = this.binding;
        ImageView imageView = uVar9 != null ? uVar9.f399389f : null;
        if (imageView != null) {
            imageView.setAlpha(f16);
        }
        fi3.u uVar10 = this.binding;
        FrameLayout frameLayout = uVar10 != null ? uVar10.f399390g : null;
        if (frameLayout != null) {
            frameLayout.setAlpha(f16);
        }
        boolean z16 = f16 >= 0.5f;
        fi3.u uVar11 = this.binding;
        TextView textView2 = uVar11 != null ? uVar11.f399391h : null;
        if (textView2 != null) {
            textView2.setEnabled(z16);
        }
        fi3.u uVar12 = this.binding;
        ImageView imageView2 = uVar12 != null ? uVar12.f399389f : null;
        if (imageView2 != null) {
            imageView2.setEnabled(z16);
        }
        fi3.u uVar13 = this.binding;
        ImageView imageView3 = uVar13 != null ? uVar13.f399389f : null;
        if (imageView3 != null) {
            imageView3.setVisibility(f16 > 0.2f ? 0 : 8);
        }
        fi3.u uVar14 = this.binding;
        FrameLayout frameLayout2 = uVar14 != null ? uVar14.f399390g : null;
        if (frameLayout2 == null) {
            return;
        }
        frameLayout2.setEnabled(z16);
    }

    @Override // com.tencent.sqshow.zootopia.view.pull2refresh.ZootopiaDetailPullToRefreshView.c
    public void endOfRefresh() {
    }
}

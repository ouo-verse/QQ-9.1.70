package com.tencent.ecommerce.biz.live.ui;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.exifinterface.media.ExifInterface;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import ci0.ECLiveWindowAddEvent;
import ci0.ECLiveWindowContentSizeChangeEvent;
import ci0.ECLiveWindowEditEvent;
import ci0.ECLiveWindowFirstLoadEvent;
import ci0.ECSetSellingPointFinishEvent;
import com.qzone.proxy.personalitycomponent.model.WidgetCacheLunarData;
import com.tencent.ams.dsdk.core.DKEngine;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.biz.qqcircle.immersive.request.search.QFSSearchBaseRequest;
import com.tencent.ditto.shell.LayoutAttrDefine;
import com.tencent.ecommerce.base.eventbus.EventObserver;
import com.tencent.ecommerce.base.eventbus.LifecycleEventBus;
import com.tencent.ecommerce.base.eventbus.ThreadMode;
import com.tencent.ecommerce.base.fragment.ECBaseFragment;
import com.tencent.ecommerce.base.list.IStateCenterView;
import com.tencent.ecommerce.base.ui.recyclerviewhelper.ECOnDragSortListener;
import com.tencent.ecommerce.base.ui.skeleton.SkeletonScreen;
import com.tencent.ecommerce.base.ui.stateview.ECStateCenterView;
import com.tencent.ecommerce.biz.live.LiveTabId;
import com.tencent.ecommerce.biz.live.event.ECLiveWindowLocalUpdateEvent;
import com.tencent.ecommerce.biz.live.event.ECLiveWindowRemoteUpdateEvent;
import com.tencent.ecommerce.biz.live.event.ECLiveWindowUpdateEvent;
import com.tencent.ecommerce.biz.live.ui.ECLiveWindowConfirmDialog;
import com.tencent.ecommerce.biz.live.ui.viewholder.ItemPayload;
import com.tencent.ecommerce.biz.live.ui.viewmodel.ECLiveWindowSubViewModel;
import com.tencent.ecommerce.biz.router.ECScheme;
import com.tencent.ecommerce.biz.util.ECThreadUtilKt;
import com.tencent.ecommerce.biz.util.e;
import com.tencent.ecommerce.repo.live.ActivityType;
import com.tencent.ecommerce.repo.live.ECLiveWindowProductRepo;
import com.tencent.ecommerce.repo.live.LiveActivity;
import com.tencent.ecommerce.repo.live.LiveCouponDetail;
import com.tencent.ecommerce.repo.live.LiveProduct;
import com.tencent.ecommerce.repo.live.TabInfo;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqmini.sdk.launcher.MiniSDKConst;
import ei0.d;
import fh0.a;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.MapsKt__MapsJVMKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.text.StringsKt__StringsJVMKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import mqq.app.Constants;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u00e4\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010$\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010 \n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u001c\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 \u00b0\u00012\u00020\u00012\u00020\u00022\u00020\u0003:\u0002\u00b1\u0001B\t\u00a2\u0006\u0006\b\u00ae\u0001\u0010\u00af\u0001J\b\u0010\u0005\u001a\u00020\u0004H\u0016J\b\u0010\u0006\u001a\u00020\u0004H\u0016J\b\u0010\b\u001a\u00020\u0007H\u0016J\u0012\u0010\f\u001a\u00020\u000b2\b\u0010\n\u001a\u0004\u0018\u00010\tH\u0016J\u001a\u0010\u000f\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\r2\b\u0010\n\u001a\u0004\u0018\u00010\tH\u0016J\b\u0010\u0010\u001a\u00020\u000bH\u0016J\b\u0010\u0011\u001a\u00020\u000bH\u0016J\b\u0010\u0012\u001a\u00020\u000bH\u0016J\u0012\u0010\u0013\u001a\u00020\u000b2\b\u0010\u000e\u001a\u0004\u0018\u00010\rH\u0016J\u0010\u0010\u0016\u001a\u00020\u000b2\u0006\u0010\u0015\u001a\u00020\u0014H\u0016J\u0010\u0010\u0017\u001a\u00020\u000b2\u0006\u0010\u0015\u001a\u00020\u0014H\u0016J\b\u0010\u0018\u001a\u00020\u000bH\u0016J\u0012\u0010\u001b\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u001a0\u0019J\u0006\u0010\u001c\u001a\u00020\u0007J\u0006\u0010\u001e\u001a\u00020\u001dJ\b\u0010\u001f\u001a\u00020\u000bH\u0002J\u0010\u0010\"\u001a\u00020\u000b2\u0006\u0010!\u001a\u00020 H\u0002J\u0010\u0010#\u001a\u00020\u000b2\u0006\u0010!\u001a\u00020 H\u0002J\u0010\u0010$\u001a\u00020\u000b2\u0006\u0010!\u001a\u00020 H\u0002J\u0010\u0010&\u001a\u00020\u000b2\u0006\u0010!\u001a\u00020%H\u0002J\u0010\u0010'\u001a\u00020\u000b2\u0006\u0010!\u001a\u00020 H\u0002J\b\u0010(\u001a\u00020\u000bH\u0002J\b\u0010)\u001a\u00020\u000bH\u0002J\b\u0010*\u001a\u00020\u000bH\u0002J\u001e\u0010-\u001a\u00020\u000b2\n\b\u0002\u0010+\u001a\u0004\u0018\u00010\u00072\b\b\u0002\u0010,\u001a\u00020\u001dH\u0002J\u0010\u0010/\u001a\u00020\u000b2\u0006\u0010.\u001a\u00020\rH\u0002J\b\u00100\u001a\u00020\u000bH\u0002J\u0010\u00102\u001a\u00020\u000b2\u0006\u00101\u001a\u00020\u001dH\u0002J\b\u00103\u001a\u00020\u000bH\u0002J\b\u00104\u001a\u00020\u000bH\u0002J\b\u00105\u001a\u00020\u000bH\u0002J\b\u00107\u001a\u000206H\u0002J\u0018\u0010;\u001a\u00020\u000b2\u0006\u00109\u001a\u0002082\u0006\u0010:\u001a\u00020\u001dH\u0002J\u0010\u0010<\u001a\u00020\u000b2\u0006\u00109\u001a\u000208H\u0002J\u0010\u0010=\u001a\u00020\u000b2\u0006\u00109\u001a\u000208H\u0002J\u0010\u0010>\u001a\u00020\u000b2\u0006\u00109\u001a\u000208H\u0002J\u0010\u0010?\u001a\u00020\u000b2\u0006\u00109\u001a\u000208H\u0002J\b\u0010@\u001a\u00020\u000bH\u0002J\u0016\u0010C\u001a\u00020\u000b2\f\u0010B\u001a\b\u0012\u0004\u0012\u0002080AH\u0002J\b\u0010D\u001a\u00020\u000bH\u0002J\b\u0010E\u001a\u00020\u000bH\u0002J\b\u0010F\u001a\u00020\u000bH\u0002J\b\u0010G\u001a\u00020\u000bH\u0002J\b\u0010H\u001a\u00020\u000bH\u0002J\u000e\u0010I\u001a\b\u0012\u0004\u0012\u0002080AH\u0002J\u0010\u0010L\u001a\u00020\u000b2\u0006\u0010K\u001a\u00020JH\u0002J\"\u0010O\u001a\u00020\u000b2\b\u00109\u001a\u0004\u0018\u0001082\u0006\u0010M\u001a\u0002062\u0006\u0010N\u001a\u00020\u001dH\u0002R\u0016\u0010S\u001a\u00020P8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bQ\u0010RR\u0016\u0010V\u001a\u00020\u00078\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bT\u0010UR\u0016\u0010Y\u001a\u00020\u001d8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bW\u0010XR\u0016\u0010[\u001a\u00020\u001d8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bZ\u0010XR\u0016\u0010]\u001a\u00020\u00078\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\\\u0010UR\u0016\u0010_\u001a\u00020\u00078\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b^\u0010UR\u0016\u0010b\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b`\u0010aR\u0016\u0010d\u001a\u00020\u00078\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bc\u0010UR\u0016\u0010f\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\be\u0010aR\u0016\u0010i\u001a\u0002068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bg\u0010hR\u0016\u0010j\u001a\u0002068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bX\u0010hR\u0016\u0010l\u001a\u00020\u00078\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bk\u0010UR\u0016\u0010p\u001a\u00020m8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bn\u0010oR\u0016\u0010t\u001a\u00020q8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\br\u0010sR\u0016\u0010x\u001a\u00020u8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bv\u0010wR\u0016\u0010|\u001a\u00020y8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bz\u0010{R\u0016\u0010\u007f\u001a\u00020\r8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b}\u0010~R\u001a\u0010\u0083\u0001\u001a\u00030\u0080\u00018\u0002@\u0002X\u0082.\u00a2\u0006\b\n\u0006\b\u0081\u0001\u0010\u0082\u0001R\u0018\u0010\u0085\u0001\u001a\u00020\r8\u0002@\u0002X\u0082.\u00a2\u0006\u0007\n\u0005\b\u0084\u0001\u0010~R\u001a\u0010\u0089\u0001\u001a\u00030\u0086\u00018\u0002@\u0002X\u0082.\u00a2\u0006\b\n\u0006\b\u0087\u0001\u0010\u0088\u0001R\u0018\u0010\u008b\u0001\u001a\u00020\r8\u0002@\u0002X\u0082.\u00a2\u0006\u0007\n\u0005\b\u008a\u0001\u0010~R\u001a\u0010\u008d\u0001\u001a\u00030\u0086\u00018\u0002@\u0002X\u0082.\u00a2\u0006\b\n\u0006\b\u008c\u0001\u0010\u0088\u0001R\u001a\u0010\u008f\u0001\u001a\u00030\u0086\u00018\u0002@\u0002X\u0082.\u00a2\u0006\b\n\u0006\b\u008e\u0001\u0010\u0088\u0001R\u001a\u0010\u0091\u0001\u001a\u00030\u0086\u00018\u0002@\u0002X\u0082.\u00a2\u0006\b\n\u0006\b\u0090\u0001\u0010\u0088\u0001R\u0018\u0010\u0093\u0001\u001a\u00020\r8\u0002@\u0002X\u0082.\u00a2\u0006\u0007\n\u0005\b\u0092\u0001\u0010~R\u001a\u0010\u0097\u0001\u001a\u00030\u0094\u00018\u0002@\u0002X\u0082.\u00a2\u0006\b\n\u0006\b\u0095\u0001\u0010\u0096\u0001R\u001a\u0010\u009b\u0001\u001a\u00030\u0098\u00018\u0002@\u0002X\u0082.\u00a2\u0006\b\n\u0006\b\u0099\u0001\u0010\u009a\u0001R\u001c\u0010\u009f\u0001\u001a\u0005\u0018\u00010\u009c\u00018\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u009d\u0001\u0010\u009e\u0001R\u001c\u0010\u00a3\u0001\u001a\u0005\u0018\u00010\u00a0\u00018\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u00a1\u0001\u0010\u00a2\u0001R\u0018\u0010\u00a5\u0001\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0007\n\u0005\b\u00a4\u0001\u0010aR\u001a\u0010\u00a9\u0001\u001a\u00030\u00a6\u00018\u0002@\u0002X\u0082.\u00a2\u0006\b\n\u0006\b\u00a7\u0001\u0010\u00a8\u0001R\u0018\u0010\u00ad\u0001\u001a\u00030\u00aa\u00018\u0002X\u0082\u0004\u00a2\u0006\b\n\u0006\b\u00ab\u0001\u0010\u00ac\u0001\u00a8\u0006\u00b2\u0001"}, d2 = {"Lcom/tencent/ecommerce/biz/live/ui/ECLiveWindowSubFragment;", "Lcom/tencent/ecommerce/base/fragment/ECBaseFragment;", "Lcom/tencent/ecommerce/base/ui/recyclerviewhelper/ECOnDragSortListener;", "Landroid/view/View$OnClickListener;", "", "uh", "getContentLayoutId", "", "getBusinessDescription", "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, "", "onCreate", "Landroid/view/View;", "view", DKEngine.ExtraEvent.EXTRA_EVENT_ON_VIEW_CREATED, "onResume", MiniSDKConst.NOTIFY_EVENT_ONPAUSE, MosaicConstants$JsFunction.FUNC_ON_DESTROY, NodeProps.ON_CLICK, "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "viewHolder", "onStartDrag", "onDragEnd", "onDestroyView", "", "", "Ii", "Gi", "", "Si", "initArguments", "Lcom/tencent/ecommerce/biz/live/event/ECLiveWindowUpdateEvent;", "event", "Mi", "Ki", "Li", "Lcom/tencent/ecommerce/biz/live/event/ECLiveWindowRemoteUpdateEvent;", "Ci", "Di", "bj", "cj", WidgetCacheLunarData.YI, "successToast", QFSSearchBaseRequest.EXTRA_KEY_IS_LOAD_MORE, "Zi", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "initUI", "Pi", "isEditable", "fj", "Ai", "Bi", "Ri", "", "Hi", "Lcom/tencent/ecommerce/repo/live/q;", "liveProduct", "exposureEnd", "Xi", "Wi", "Ui", "Ti", "Yi", "Ji", "", "selectedProductList", "dj", "Ei", "Oi", "Ni", "Vi", "zi", "Fi", "Landroid/content/Context;", "context", "ej", "curPlayTime", "isButton", "Qi", "Lcom/tencent/ecommerce/repo/live/TabInfo;", "P", "Lcom/tencent/ecommerce/repo/live/TabInfo;", "tabInfo", AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, "Ljava/lang/String;", "logTag", BdhLogUtil.LogTag.Tag_Req, "Z", "isLiveOpened", ExifInterface.LATITUDE_SOUTH, "isMaster", "T", "userId", "U", "roomId", "V", "I", WadlProxyConsts.CHANNEL, "W", "programId", "X", "liveType", "Y", "J", "livePlayTimeSec", "windowInitTimeMs", "a0", "couponId", "Lcom/tencent/ecommerce/biz/live/ui/viewmodel/ECLiveWindowSubViewModel;", "b0", "Lcom/tencent/ecommerce/biz/live/ui/viewmodel/ECLiveWindowSubViewModel;", "viewModel", "Landroidx/recyclerview/widget/ItemTouchHelper;", "c0", "Landroidx/recyclerview/widget/ItemTouchHelper;", "itemTouchHelper", "Landroidx/recyclerview/widget/RecyclerView;", "d0", "Landroidx/recyclerview/widget/RecyclerView;", "recycleView", "Lfi0/a;", "e0", "Lfi0/a;", "listAdapter", "f0", "Landroid/view/View;", "couponLabelBar", "Lcom/tencent/ecommerce/biz/live/ui/ECLiveLabelView;", "g0", "Lcom/tencent/ecommerce/biz/live/ui/ECLiveLabelView;", "couponLabelView", "h0", "searchBar", "Landroid/widget/TextView;", "i0", "Landroid/widget/TextView;", "searchHint", "j0", "windowBottomBar", "k0", "selectHintText", "l0", "deleteBtn", "m0", "setTopBtn", "n0", "emptyLayout", "Lcom/tencent/ecommerce/base/ui/stateview/ECStateCenterView;", "o0", "Lcom/tencent/ecommerce/base/ui/stateview/ECStateCenterView;", "stateView", "Landroid/widget/Button;", "p0", "Landroid/widget/Button;", "emptyButton", "Landroid/widget/FrameLayout;", "q0", "Landroid/widget/FrameLayout;", "deleteConfirmDialogContainer", "Lcom/tencent/ecommerce/biz/live/ui/ECLiveWindowConfirmDialog;", "r0", "Lcom/tencent/ecommerce/biz/live/ui/ECLiveWindowConfirmDialog;", "confirmDialog", "s0", "refreshCount", "Lcom/tencent/ecommerce/base/ui/skeleton/SkeletonScreen;", "t0", "Lcom/tencent/ecommerce/base/ui/skeleton/SkeletonScreen;", "skeleton", "Landroid/os/Handler;", "u0", "Landroid/os/Handler;", "timeHandler", "<init>", "()V", "w0", "a", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes31.dex */
public final class ECLiveWindowSubFragment extends ECBaseFragment implements ECOnDragSortListener, View.OnClickListener {

    /* renamed from: v0, reason: collision with root package name */
    private static final Lazy f102746v0;

    /* renamed from: w0, reason: collision with root package name and from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: Q, reason: from kotlin metadata */
    private String logTag;

    /* renamed from: R, reason: from kotlin metadata */
    private boolean isLiveOpened;

    /* renamed from: S, reason: from kotlin metadata */
    private boolean isMaster;

    /* renamed from: V, reason: from kotlin metadata */
    private int channel;

    /* renamed from: X, reason: from kotlin metadata */
    private int liveType;

    /* renamed from: Y, reason: from kotlin metadata */
    private long livePlayTimeSec;

    /* renamed from: Z, reason: from kotlin metadata */
    private long windowInitTimeMs;

    /* renamed from: b0, reason: collision with root package name and from kotlin metadata */
    private ECLiveWindowSubViewModel viewModel;

    /* renamed from: c0, reason: collision with root package name and from kotlin metadata */
    private ItemTouchHelper itemTouchHelper;

    /* renamed from: d0, reason: collision with root package name and from kotlin metadata */
    private RecyclerView recycleView;

    /* renamed from: e0, reason: collision with root package name and from kotlin metadata */
    private fi0.a listAdapter;

    /* renamed from: f0, reason: collision with root package name and from kotlin metadata */
    private View couponLabelBar;

    /* renamed from: g0, reason: collision with root package name and from kotlin metadata */
    private ECLiveLabelView couponLabelView;

    /* renamed from: h0, reason: collision with root package name and from kotlin metadata */
    private View searchBar;

    /* renamed from: i0, reason: collision with root package name and from kotlin metadata */
    private TextView searchHint;

    /* renamed from: j0, reason: collision with root package name and from kotlin metadata */
    private View windowBottomBar;

    /* renamed from: k0, reason: collision with root package name and from kotlin metadata */
    private TextView selectHintText;

    /* renamed from: l0, reason: collision with root package name and from kotlin metadata */
    private TextView deleteBtn;

    /* renamed from: m0, reason: collision with root package name and from kotlin metadata */
    private TextView setTopBtn;

    /* renamed from: n0, reason: collision with root package name and from kotlin metadata */
    private View emptyLayout;

    /* renamed from: o0, reason: collision with root package name and from kotlin metadata */
    private ECStateCenterView stateView;

    /* renamed from: p0, reason: collision with root package name and from kotlin metadata */
    private Button emptyButton;

    /* renamed from: q0, reason: collision with root package name and from kotlin metadata */
    private FrameLayout deleteConfirmDialogContainer;

    /* renamed from: r0, reason: collision with root package name and from kotlin metadata */
    private ECLiveWindowConfirmDialog confirmDialog;

    /* renamed from: s0, reason: collision with root package name and from kotlin metadata */
    private int refreshCount;

    /* renamed from: t0, reason: collision with root package name and from kotlin metadata */
    private SkeletonScreen skeleton;

    /* renamed from: u0, reason: collision with root package name and from kotlin metadata */
    private final Handler timeHandler;

    /* renamed from: P, reason: from kotlin metadata */
    private TabInfo tabInfo = new TabInfo();

    /* renamed from: T, reason: from kotlin metadata */
    private String userId = "";

    /* renamed from: U, reason: from kotlin metadata */
    private String roomId = "";

    /* renamed from: W, reason: from kotlin metadata */
    private String programId = "";

    /* renamed from: a0, reason: collision with root package name and from kotlin metadata */
    private String couponId = "";

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\t\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0013\u0010\u0014J\u0006\u0010\u0003\u001a\u00020\u0002R\u001b\u0010\t\u001a\u00020\u00048BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\bR\u0014\u0010\n\u001a\u00020\u00048\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\n\u0010\u000bR\u0014\u0010\r\u001a\u00020\f8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\r\u0010\u000eR\u0014\u0010\u000f\u001a\u00020\u00048\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\u000bR\u0014\u0010\u0010\u001a\u00020\u00048\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\u000bR\u0014\u0010\u0011\u001a\u00020\u00048\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\u000bR\u0014\u0010\u0012\u001a\u00020\u00048\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\u000b\u00a8\u0006\u0015"}, d2 = {"Lcom/tencent/ecommerce/biz/live/ui/ECLiveWindowSubFragment$a;", "", "Lcom/tencent/ecommerce/biz/live/ui/ECLiveWindowSubFragment;", "c", "", "ICON_SZIE$delegate", "Lkotlin/Lazy;", "b", "()I", "ICON_SZIE", "COUNTDOWN_INTERVAL_SEC", "I", "", "KEY_TAB_INFO", "Ljava/lang/String;", "MSG_TYPE_COUNTDOWN", "MSG_TYPE_POLLING_ACTIVITY", "POLLING_INTERVAL_MIN_SEC", "RECYCLER_VIEW_REMAIN_MIN_ITEM_CNT", "<init>", "()V", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
    /* renamed from: com.tencent.ecommerce.biz.live.ui.ECLiveWindowSubFragment$a, reason: from kotlin metadata */
    /* loaded from: classes31.dex */
    public static final class Companion {
        Companion() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final int b() {
            return ((Number) ECLiveWindowSubFragment.f102746v0.getValue()).intValue();
        }

        public final ECLiveWindowSubFragment c() {
            return new ECLiveWindowSubFragment();
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J \u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004H\u0016\u00a8\u0006\t"}, d2 = {"com/tencent/ecommerce/biz/live/ui/ECLiveWindowSubFragment$c", "Landroidx/recyclerview/widget/RecyclerView$OnScrollListener;", "Landroidx/recyclerview/widget/RecyclerView;", "recyclerView", "", "dx", "dy", "", "onScrolled", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
    /* loaded from: classes31.dex */
    public static final class c extends RecyclerView.OnScrollListener {
        c() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrolled(RecyclerView recyclerView, int dx5, int dy5) {
            super.onScrolled(recyclerView, dx5, dy5);
            if (ECLiveWindowSubFragment.mi(ECLiveWindowSubFragment.this).getIsListEnd().get()) {
                return;
            }
            RecyclerView.LayoutManager layoutManager = recyclerView.getLayoutManager();
            if (!(layoutManager instanceof LinearLayoutManager) || dy5 <= 0) {
                return;
            }
            if (((LinearLayoutManager) layoutManager).findLastVisibleItemPosition() >= r1.getItemCount() - 10) {
                ECLiveWindowSubFragment.this.Zi(null, true);
            }
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/ecommerce/biz/live/ui/ECLiveWindowSubFragment$d", "Lcom/tencent/ecommerce/base/eventbus/EventObserver;", "Lcom/tencent/ecommerce/biz/live/event/ECLiveWindowRemoteUpdateEvent;", "event", "", "a", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
    /* loaded from: classes31.dex */
    public static final class d implements EventObserver<ECLiveWindowRemoteUpdateEvent> {
        d() {
        }

        @Override // com.tencent.ecommerce.base.eventbus.EventObserver
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onEvent(ECLiveWindowRemoteUpdateEvent event) {
            if (event.tabId == ECLiveWindowSubFragment.this.tabInfo.id) {
                ECLiveWindowSubFragment.this.Di(event);
            } else {
                ECLiveWindowSubFragment.this.Ci(event);
            }
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/ecommerce/biz/live/ui/ECLiveWindowSubFragment$e", "Lcom/tencent/ecommerce/base/eventbus/EventObserver;", "Lcom/tencent/ecommerce/biz/live/event/ECLiveWindowLocalUpdateEvent;", "event", "", "a", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
    /* loaded from: classes31.dex */
    public static final class e implements EventObserver<ECLiveWindowLocalUpdateEvent> {
        e() {
        }

        @Override // com.tencent.ecommerce.base.eventbus.EventObserver
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onEvent(ECLiveWindowLocalUpdateEvent event) {
            if (event.tabId == ECLiveWindowSubFragment.this.tabInfo.id) {
                ECLiveWindowSubFragment.this.Di(event);
            }
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/ecommerce/biz/live/ui/ECLiveWindowSubFragment$f", "Lcom/tencent/ecommerce/base/eventbus/EventObserver;", "Lci0/i;", "event", "", "a", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
    /* loaded from: classes31.dex */
    public static final class f implements EventObserver<ECSetSellingPointFinishEvent> {
        f() {
        }

        @Override // com.tencent.ecommerce.base.eventbus.EventObserver
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onEvent(ECSetSellingPointFinishEvent event) {
            cg0.a.b(ECLiveWindowSubFragment.bi(ECLiveWindowSubFragment.this), "OnEventBus SetSellingPointFinishEvent: " + event);
            int i3 = event.positionInList;
            if (i3 < 0 || i3 > ECLiveWindowSubFragment.Zh(ECLiveWindowSubFragment.this).getNUM_BACKGOURND_ICON()) {
                return;
            }
            ECLiveWindowSubFragment.mi(ECLiveWindowSubFragment.this).R2(event.positionInList, event.mediaProductId, event.sellingPointTxt, ECLiveWindowSubFragment.Zh(ECLiveWindowSubFragment.this));
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/ecommerce/biz/live/ui/ECLiveWindowSubFragment$g", "Lcom/tencent/ecommerce/base/eventbus/EventObserver;", "Lci0/c;", "event", "", "a", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
    /* loaded from: classes31.dex */
    public static final class g implements EventObserver<ECLiveWindowEditEvent> {
        g() {
        }

        @Override // com.tencent.ecommerce.base.eventbus.EventObserver
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onEvent(ECLiveWindowEditEvent event) {
            if (event.tabId == ECLiveWindowSubFragment.this.tabInfo.id) {
                cg0.a.b(ECLiveWindowSubFragment.bi(ECLiveWindowSubFragment.this), "OnEventBus LiveWindowEditEvent: " + event);
                ECLiveWindowSubFragment.mi(ECLiveWindowSubFragment.this).M2(event.getEnterEdit());
                if (event.getEnterEdit()) {
                    return;
                }
                ECLiveWindowSubFragment.aj(ECLiveWindowSubFragment.this, null, false, 3, null);
                ECLiveWindowSubFragment.mi(ECLiveWindowSubFragment.this).i2();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0004\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n\u00a2\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"", "kotlin.jvm.PlatformType", "it", "", "a", "(Ljava/lang/Boolean;)V"}, k = 3, mv = {1, 4, 1})
    /* loaded from: classes31.dex */
    public static final class i<T> implements Observer<Boolean> {
        i() {
        }

        @Override // androidx.lifecycle.Observer
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final void onChanged(Boolean bool) {
            ECLiveWindowSubFragment.this.fj(bool.booleanValue());
            if (bool.booleanValue()) {
                ECLiveWindowSubFragment.di(ECLiveWindowSubFragment.this).setClipToPadding(false);
                ECLiveWindowSubFragment.di(ECLiveWindowSubFragment.this).setPadding(0, 0, 0, com.tencent.ecommerce.biz.util.e.c(80.0f));
            } else {
                ECLiveWindowSubFragment.di(ECLiveWindowSubFragment.this).setClipToPadding(true);
                ECLiveWindowSubFragment.di(ECLiveWindowSubFragment.this).setPadding(0, 0, 0, 0);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0005\u001a\u00020\u00042\u001a\u0010\u0003\u001a\u0016\u0012\u0004\u0012\u00020\u0001 \u0002*\n\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u00000\u0000H\n\u00a2\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"", "Lcom/tencent/ecommerce/repo/live/l;", "kotlin.jvm.PlatformType", "list", "", "a", "(Ljava/util/List;)V"}, k = 3, mv = {1, 4, 1})
    /* loaded from: classes31.dex */
    public static final class l<T> implements Observer<List<? extends LiveActivity>> {
        l() {
        }

        /* JADX WARN: Removed duplicated region for block: B:19:0x0059 A[SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:22:? A[LOOP:1: B:7:0x002b->B:22:?, LOOP_END, SYNTHETIC] */
        @Override // androidx.lifecycle.Observer
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final void onChanged(List<LiveActivity> list) {
            LiveActivity liveActivity;
            boolean z16;
            for (LiveActivity liveActivity2 : list) {
                List<LiveProduct> value = ECLiveWindowSubFragment.mi(ECLiveWindowSubFragment.this).t2().getValue();
                LiveProduct liveProduct = null;
                if (value != null) {
                    Iterator<T> it = value.iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            break;
                        }
                        T next = it.next();
                        LiveProduct liveProduct2 = (LiveProduct) next;
                        if (liveProduct2.getLiveActivity() != null) {
                            String activityId = liveActivity2.getActivityId();
                            LiveActivity liveActivity3 = liveProduct2.getLiveActivity();
                            if (Intrinsics.areEqual(activityId, liveActivity3 != null ? liveActivity3.getActivityId() : null)) {
                                z16 = true;
                                if (!z16) {
                                    liveProduct = next;
                                    break;
                                }
                            }
                        }
                        z16 = false;
                        if (!z16) {
                        }
                    }
                    liveProduct = liveProduct;
                }
                if (liveProduct != null && (liveActivity = liveProduct.getLiveActivity()) != null) {
                    cg0.a.b(ECLiveWindowSubFragment.bi(ECLiveWindowSubFragment.this), "StartPollingActivity, localActivity:" + liveActivity + " remoteActivity:" + liveActivity2);
                    ItemPayload m3 = liveActivity.m(liveActivity2);
                    cg0.a.b(ECLiveWindowSubFragment.bi(ECLiveWindowSubFragment.this), "StartPollingActivity, update payload:" + m3 + " targetProduct:" + liveProduct);
                    ECLiveWindowSubFragment.Zh(ECLiveWindowSubFragment.this).notifyItemChanged(liveProduct.getPositionInList(), m3);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0004\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n\u00a2\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Lcom/tencent/ecommerce/repo/live/n;", "kotlin.jvm.PlatformType", "it", "", "a", "(Lcom/tencent/ecommerce/repo/live/n;)V"}, k = 3, mv = {1, 4, 1})
    /* loaded from: classes31.dex */
    public static final class m<T> implements Observer<LiveCouponDetail> {
        m() {
        }

        @Override // androidx.lifecycle.Observer
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final void onChanged(LiveCouponDetail liveCouponDetail) {
            ECLiveWindowSubFragment.Th(ECLiveWindowSubFragment.this).setPrefix("\u5238");
            ECLiveWindowSubFragment.Th(ECLiveWindowSubFragment.this).setContent(liveCouponDetail.getMsg());
            ECLiveWindowSubFragment.Th(ECLiveWindowSubFragment.this).setVisibility(0);
            ECLiveWindowSubFragment.Sh(ECLiveWindowSubFragment.this).setVisibility(0);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0007"}, d2 = {"com/tencent/ecommerce/biz/live/ui/ECLiveWindowSubFragment$n", "Lcom/tencent/ecommerce/biz/live/ui/ECLiveWindowConfirmDialog$IButtonClickListener;", "Landroid/view/View;", "view", "", "onNegativeBtnClick", "onPositiveBtnClick", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
    /* loaded from: classes31.dex */
    public static final class n implements ECLiveWindowConfirmDialog.IButtonClickListener {

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ List f102782b;

        n(List list) {
            this.f102782b = list;
        }

        @Override // com.tencent.ecommerce.biz.live.ui.ECLiveWindowConfirmDialog.IButtonClickListener
        public void onNegativeBtnClick(View view) {
            ECLiveWindowSubFragment.this.Ei();
        }

        @Override // com.tencent.ecommerce.biz.live.ui.ECLiveWindowConfirmDialog.IButtonClickListener
        public void onPositiveBtnClick(View view) {
            FragmentManager supportFragmentManager;
            FragmentActivity activity = ECLiveWindowSubFragment.this.getActivity();
            Fragment findFragmentById = (activity == null || (supportFragmentManager = activity.getSupportFragmentManager()) == null) ? null : supportFragmentManager.findFragmentById(R.id.nx_);
            ECLiveWindowMainFragment eCLiveWindowMainFragment = (ECLiveWindowMainFragment) (findFragmentById instanceof ECLiveWindowMainFragment ? findFragmentById : null);
            if (eCLiveWindowMainFragment != null) {
                Iterator it = this.f102782b.iterator();
                while (it.hasNext()) {
                    ei0.d.f396304b.t(eCLiveWindowMainFragment, (LiveProduct) it.next());
                }
            }
            ECLiveWindowSubFragment.mi(ECLiveWindowSubFragment.this).j2(this.f102782b);
            ECLiveWindowSubFragment.this.Ei();
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/ecommerce/biz/live/ui/ECLiveWindowSubFragment$o", "Landroid/os/Handler;", "Landroid/os/Message;", "msg", "", "handleMessage", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
    /* loaded from: classes31.dex */
    public static final class o extends Handler {
        o(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message msg2) {
            int i3 = msg2.what;
            if (i3 != 1) {
                if (i3 == 2 && ECLiveWindowSubFragment.this.Si()) {
                    ECLiveWindowSubFragment eCLiveWindowSubFragment = ECLiveWindowSubFragment.this;
                    eCLiveWindowSubFragment.ej(eCLiveWindowSubFragment.requireContext());
                    sendEmptyMessageDelayed(2, 1000L);
                    return;
                }
                return;
            }
            if (ECLiveWindowSubFragment.mi(ECLiveWindowSubFragment.this).C2()) {
                ECLiveWindowSubFragment.mi(ECLiveWindowSubFragment.this).I2();
                sendEmptyMessageDelayed(1, ECLiveWindowProductRepo.INSTANCE.c() * 1000);
            }
        }
    }

    static {
        Lazy lazy;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<Integer>() { // from class: com.tencent.ecommerce.biz.live.ui.ECLiveWindowSubFragment$Companion$ICON_SZIE$2
            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Integer invoke() {
                return Integer.valueOf(invoke2());
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final int invoke2() {
                return e.c(16.0f);
            }
        });
        f102746v0 = lazy;
    }

    public ECLiveWindowSubFragment() {
        Looper mainLooper = Looper.getMainLooper();
        Intrinsics.checkNotNull(mainLooper);
        this.timeHandler = new o(mainLooper);
    }

    private final void Ai() {
        View view = this.windowBottomBar;
        if (view == null) {
            Intrinsics.throwUninitializedPropertyAccessException("windowBottomBar");
        }
        view.setVisibility(0);
        BuildersKt__Builders_commonKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this), null, null, new ECLiveWindowSubFragment$configUIForMasterEditable$1(this, null), 3, null);
    }

    private final void Bi() {
        View view = this.windowBottomBar;
        if (view == null) {
            Intrinsics.throwUninitializedPropertyAccessException("windowBottomBar");
        }
        view.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Ci(ECLiveWindowRemoteUpdateEvent event) {
        if (event.tabId != this.tabInfo.id) {
            String str = this.logTag;
            if (str == null) {
                Intrinsics.throwUninitializedPropertyAccessException("logTag");
            }
            cg0.a.b(str, "dealOtherUpdateEvent ECLiveWindowUpdateEvent: " + event);
            int i3 = event.event;
            if (i3 == 1 || i3 == 4) {
                Li(new ECLiveWindowLocalUpdateEvent(2, this.tabInfo.id, "", this.userId, this.roomId, null));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Di(ECLiveWindowUpdateEvent event) {
        if (event.tabId != this.tabInfo.id) {
            return;
        }
        String str = this.logTag;
        if (str == null) {
            Intrinsics.throwUninitializedPropertyAccessException("logTag");
        }
        cg0.a.b(str, "dealSelfUpdateEvent ECLiveWindowUpdateEvent: " + event);
        int i3 = event.event;
        if (i3 == 0) {
            Mi(event);
            return;
        }
        if (i3 == 1) {
            Ki(event);
            return;
        }
        if (i3 != 2) {
            if (i3 == 4 && this.tabInfo.id == LiveTabId.LIVE_TAB_GOK) {
                if (event instanceof ECLiveWindowLocalUpdateEvent) {
                    Ki(ci0.e.b((ECLiveWindowLocalUpdateEvent) event, 2, null, "", null, null, null, 58, null));
                    return;
                }
                if (event instanceof ECLiveWindowRemoteUpdateEvent) {
                    Li(ci0.f.b((ECLiveWindowRemoteUpdateEvent) event, 2, null, "", null, null, null, 58, null));
                    ECLiveWindowSubViewModel eCLiveWindowSubViewModel = this.viewModel;
                    if (eCLiveWindowSubViewModel == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
                    }
                    eCLiveWindowSubViewModel.D2(2);
                    return;
                }
                return;
            }
            return;
        }
        Li(event);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Ei() {
        FragmentManager supportFragmentManager;
        FragmentTransaction beginTransaction;
        FragmentTransaction remove;
        ECLiveWindowConfirmDialog eCLiveWindowConfirmDialog = this.confirmDialog;
        if (eCLiveWindowConfirmDialog != null) {
            FragmentActivity activity = getActivity();
            if (activity != null && (supportFragmentManager = activity.getSupportFragmentManager()) != null && (beginTransaction = supportFragmentManager.beginTransaction()) != null && (remove = beginTransaction.remove(eCLiveWindowConfirmDialog)) != null) {
                remove.commit();
            }
            FrameLayout frameLayout = this.deleteConfirmDialogContainer;
            if (frameLayout != null) {
                frameLayout.setVisibility(8);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x0051, code lost:
    
        if ((r3 != null ? r3.getActivityStatus() : null) == com.tencent.ecommerce.repo.live.ActivityStatus.ACTIVITY_STATUS_RUNNING) goto L25;
     */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0059 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0021 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final List<LiveProduct> Fi() {
        List<LiveProduct> emptyList;
        boolean z16;
        ECLiveWindowSubViewModel eCLiveWindowSubViewModel = this.viewModel;
        if (eCLiveWindowSubViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        }
        List<LiveProduct> value = eCLiveWindowSubViewModel.t2().getValue();
        if (value == null) {
            emptyList = CollectionsKt__CollectionsKt.emptyList();
            return emptyList;
        }
        ArrayList arrayList = new ArrayList();
        for (Object obj : value) {
            LiveProduct liveProduct = (LiveProduct) obj;
            if (!liveProduct.F()) {
                LiveActivity liveActivity = liveProduct.getLiveActivity();
                if ((liveActivity != null ? liveActivity.getActivityType() : null) == ActivityType.ACTIVITY_TYPE_LIVE) {
                    LiveActivity liveActivity2 = liveProduct.getLiveActivity();
                }
                z16 = false;
                if (!z16) {
                    arrayList.add(obj);
                }
            }
            z16 = true;
            if (!z16) {
            }
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final long Hi() {
        long currentTimeMillis = this.livePlayTimeSec + ((System.currentTimeMillis() - this.windowInitTimeMs) / 1000);
        this.livePlayTimeSec = currentTimeMillis;
        return currentTimeMillis;
    }

    private final void Ji() {
        ECLiveWindowSubViewModel eCLiveWindowSubViewModel = this.viewModel;
        if (eCLiveWindowSubViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        }
        List<LiveProduct> value = eCLiveWindowSubViewModel.v2().getValue();
        if ((value != null ? value.size() : 0) <= 0) {
            return;
        }
        ECLiveWindowSubViewModel eCLiveWindowSubViewModel2 = this.viewModel;
        if (eCLiveWindowSubViewModel2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        }
        List<LiveProduct> value2 = eCLiveWindowSubViewModel2.v2().getValue();
        if (value2 != null) {
            dj(value2);
        }
    }

    private final void Ki(ECLiveWindowUpdateEvent event) {
        FragmentActivity activity;
        if (this.tabInfo.id == LiveTabId.LIVE_TAB_GOK) {
            ECLiveWindowSubViewModel eCLiveWindowSubViewModel = this.viewModel;
            if (eCLiveWindowSubViewModel == null) {
                Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            }
            LiveTabId liveTabId = event.tabId;
            String str = event.mediaProductId;
            if (str == null) {
                str = "";
            }
            fi0.a aVar = this.listAdapter;
            if (aVar == null) {
                Intrinsics.throwUninitializedPropertyAccessException("listAdapter");
            }
            eCLiveWindowSubViewModel.x2(liveTabId, str, aVar, event.getLiveProduct());
        } else {
            aj(this, (this.isMaster || (event instanceof ECLiveWindowLocalUpdateEvent) || (activity = getActivity()) == null) ? null : activity.getString(R.string.wlc), false, 2, null);
        }
        if (event instanceof ECLiveWindowRemoteUpdateEvent) {
            ECLiveWindowSubViewModel eCLiveWindowSubViewModel2 = this.viewModel;
            if (eCLiveWindowSubViewModel2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            }
            eCLiveWindowSubViewModel2.D2(2);
        }
    }

    private final void Li(ECLiveWindowUpdateEvent event) {
        FragmentActivity activity;
        if (this.tabInfo.id == LiveTabId.LIVE_TAB_GOK) {
            ECLiveWindowSubViewModel eCLiveWindowSubViewModel = this.viewModel;
            if (eCLiveWindowSubViewModel == null) {
                Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            }
            String str = event.mediaProductId;
            if (str == null) {
                str = "";
            }
            fi0.a aVar = this.listAdapter;
            if (aVar == null) {
                Intrinsics.throwUninitializedPropertyAccessException("listAdapter");
            }
            eCLiveWindowSubViewModel.y2(str, aVar);
            return;
        }
        aj(this, (this.isMaster || (event instanceof ECLiveWindowLocalUpdateEvent) || (activity = getActivity()) == null) ? null : activity.getString(R.string.wld), false, 2, null);
        if (event instanceof ECLiveWindowRemoteUpdateEvent) {
            ECLiveWindowSubViewModel eCLiveWindowSubViewModel2 = this.viewModel;
            if (eCLiveWindowSubViewModel2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            }
            eCLiveWindowSubViewModel2.D2(4);
        }
    }

    private final void Mi(ECLiveWindowUpdateEvent event) {
        FragmentActivity activity;
        aj(this, (this.isMaster || (activity = getActivity()) == null) ? null : activity.getString(R.string.wle), false, 2, null);
    }

    private final void Ni() {
        String str = this.logTag;
        if (str == null) {
            Intrinsics.throwUninitializedPropertyAccessException("logTag");
        }
        cg0.a.b(str, "handleSearchBarClick");
        LifecycleEventBus.f100688b.f(new ci0.g(this.tabInfo));
    }

    private final void Oi() {
        ECLiveWindowSubViewModel eCLiveWindowSubViewModel = this.viewModel;
        if (eCLiveWindowSubViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        }
        List<LiveProduct> value = eCLiveWindowSubViewModel.v2().getValue();
        if ((value != null ? value.size() : 0) <= 0) {
            return;
        }
        ECLiveWindowSubViewModel eCLiveWindowSubViewModel2 = this.viewModel;
        if (eCLiveWindowSubViewModel2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        }
        List<LiveProduct> value2 = eCLiveWindowSubViewModel2.v2().getValue();
        if (value2 != null) {
            ECLiveWindowSubViewModel eCLiveWindowSubViewModel3 = this.viewModel;
            if (eCLiveWindowSubViewModel3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            }
            eCLiveWindowSubViewModel3.S2(value2);
        }
    }

    private final void Pi() {
        ei0.d dVar = ei0.d.f396304b;
        RecyclerView recyclerView = this.recycleView;
        if (recyclerView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("recycleView");
        }
        dVar.h(recyclerView);
        if (this.isMaster) {
            TextView textView = this.setTopBtn;
            if (textView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("setTopBtn");
            }
            dVar.l(textView);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Ri() {
        LifecycleEventBus.f100688b.f(new ECLiveWindowAddEvent(this.tabInfo.id));
    }

    public static final /* synthetic */ View Sh(ECLiveWindowSubFragment eCLiveWindowSubFragment) {
        View view = eCLiveWindowSubFragment.couponLabelBar;
        if (view == null) {
            Intrinsics.throwUninitializedPropertyAccessException("couponLabelBar");
        }
        return view;
    }

    public static final /* synthetic */ ECLiveLabelView Th(ECLiveWindowSubFragment eCLiveWindowSubFragment) {
        ECLiveLabelView eCLiveLabelView = eCLiveWindowSubFragment.couponLabelView;
        if (eCLiveLabelView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("couponLabelView");
        }
        return eCLiveLabelView;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Ti(LiveProduct liveProduct) {
        if (this.isMaster) {
            ECLiveWindowSubViewModel eCLiveWindowSubViewModel = this.viewModel;
            if (eCLiveWindowSubViewModel == null) {
                Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            }
            fi0.a aVar = this.listAdapter;
            if (aVar == null) {
                Intrinsics.throwUninitializedPropertyAccessException("listAdapter");
            }
            eCLiveWindowSubViewModel.U2(liveProduct, aVar);
            ei0.d.f396304b.q(this.userId, this.roomId, this.programId, this.liveType, liveProduct);
            return;
        }
        Qi(liveProduct, 0L, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Ui(LiveProduct liveProduct) {
        ECLiveWindowSubViewModel eCLiveWindowSubViewModel = this.viewModel;
        if (eCLiveWindowSubViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        }
        eCLiveWindowSubViewModel.L2(liveProduct, !liveProduct.getIsSelected());
    }

    public static final /* synthetic */ TextView Vh(ECLiveWindowSubFragment eCLiveWindowSubFragment) {
        TextView textView = eCLiveWindowSubFragment.deleteBtn;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("deleteBtn");
        }
        return textView;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Vi() {
        String str = this.logTag;
        if (str == null) {
            Intrinsics.throwUninitializedPropertyAccessException("logTag");
        }
        cg0.a.b(str, "onFooterRetryClick");
        Zi(null, true);
    }

    public static final /* synthetic */ Button Wh(ECLiveWindowSubFragment eCLiveWindowSubFragment) {
        Button button = eCLiveWindowSubFragment.emptyButton;
        if (button == null) {
            Intrinsics.throwUninitializedPropertyAccessException("emptyButton");
        }
        return button;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Wi(LiveProduct liveProduct) {
        if (this.isMaster) {
            return;
        }
        Qi(liveProduct, Hi(), false);
    }

    public static final /* synthetic */ View Xh(ECLiveWindowSubFragment eCLiveWindowSubFragment) {
        View view = eCLiveWindowSubFragment.emptyLayout;
        if (view == null) {
            Intrinsics.throwUninitializedPropertyAccessException("emptyLayout");
        }
        return view;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Xi(final LiveProduct liveProduct, boolean exposureEnd) {
        if (this.isMaster) {
            return;
        }
        String str = this.logTag;
        if (str == null) {
            Intrinsics.throwUninitializedPropertyAccessException("logTag");
        }
        cg0.a.b(str, "onItemExposure : " + liveProduct + "\uff0c exposureEnd\uff1a" + exposureEnd);
        if (exposureEnd) {
            ECThreadUtilKt.a(new Function0<Unit>() { // from class: com.tencent.ecommerce.biz.live.ui.ECLiveWindowSubFragment$onItemExposure$1
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
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
                    String str2;
                    String str3;
                    String str4;
                    int i3;
                    d dVar = d.f396304b;
                    str2 = ECLiveWindowSubFragment.this.userId;
                    str3 = ECLiveWindowSubFragment.this.roomId;
                    str4 = ECLiveWindowSubFragment.this.programId;
                    i3 = ECLiveWindowSubFragment.this.liveType;
                    dVar.y(str2, str3, str4, i3, liveProduct);
                }
            });
        } else {
            ei0.d.f396304b.A(liveProduct);
            ECThreadUtilKt.a(new Function0<Unit>() { // from class: com.tencent.ecommerce.biz.live.ui.ECLiveWindowSubFragment$onItemExposure$2
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
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
                    String str2;
                    String str3;
                    String str4;
                    int i3;
                    long Hi;
                    String str5;
                    String str6;
                    String str7;
                    int i16;
                    d dVar = d.f396304b;
                    str2 = ECLiveWindowSubFragment.this.userId;
                    str3 = ECLiveWindowSubFragment.this.roomId;
                    str4 = ECLiveWindowSubFragment.this.programId;
                    i3 = ECLiveWindowSubFragment.this.liveType;
                    Hi = ECLiveWindowSubFragment.this.Hi();
                    dVar.x(str2, str3, str4, i3, Hi, liveProduct);
                    str5 = ECLiveWindowSubFragment.this.userId;
                    str6 = ECLiveWindowSubFragment.this.roomId;
                    str7 = ECLiveWindowSubFragment.this.programId;
                    i16 = ECLiveWindowSubFragment.this.liveType;
                    dVar.r(str5, str6, str7, i16, liveProduct);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Yi(LiveProduct liveProduct) {
        FragmentManager supportFragmentManager;
        if (this.isMaster) {
            ECLiveWindowSubViewModel eCLiveWindowSubViewModel = this.viewModel;
            if (eCLiveWindowSubViewModel == null) {
                Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            }
            if (Intrinsics.areEqual(eCLiveWindowSubViewModel.o2().getValue(), Boolean.FALSE)) {
                return;
            }
            ECLiveSellingPointFragment a16 = ECLiveSellingPointFragment.INSTANCE.a();
            Bundle bundle = new Bundle();
            bundle.putString("args_selling_point", liveProduct != null ? liveProduct.getAdTxt() : null);
            bundle.putString("args_product_id", liveProduct != null ? liveProduct.getMediaProductId() : null);
            bundle.putInt("args_position_in_list", (liveProduct != null ? Integer.valueOf(liveProduct.getPositionInList()) : null).intValue());
            a16.setArguments(bundle);
            FragmentActivity activity = getActivity();
            FragmentTransaction beginTransaction = (activity == null || (supportFragmentManager = activity.getSupportFragmentManager()) == null) ? null : supportFragmentManager.beginTransaction();
            if (beginTransaction != null) {
                beginTransaction.setCustomAnimations(R.anim.f1676, 0);
                beginTransaction.add(R.id.ofj, a16).addToBackStack(null).commit();
            }
        }
    }

    public static final /* synthetic */ fi0.a Zh(ECLiveWindowSubFragment eCLiveWindowSubFragment) {
        fi0.a aVar = eCLiveWindowSubFragment.listAdapter;
        if (aVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("listAdapter");
        }
        return aVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Zi(String successToast, boolean isLoadMore) {
        this.refreshCount++;
        ECLiveWindowSubViewModel eCLiveWindowSubViewModel = this.viewModel;
        if (eCLiveWindowSubViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        }
        eCLiveWindowSubViewModel.V2(this.couponId, successToast, isLoadMore);
    }

    public static final /* synthetic */ String bi(ECLiveWindowSubFragment eCLiveWindowSubFragment) {
        String str = eCLiveWindowSubFragment.logTag;
        if (str == null) {
            Intrinsics.throwUninitializedPropertyAccessException("logTag");
        }
        return str;
    }

    private final void bj() {
        LifecycleEventBus lifecycleEventBus = LifecycleEventBus.f100688b;
        ThreadMode threadMode = ThreadMode.MAIN;
        lifecycleEventBus.c(threadMode, this, ECLiveWindowRemoteUpdateEvent.class, new d());
        lifecycleEventBus.c(threadMode, this, ECLiveWindowLocalUpdateEvent.class, new e());
        lifecycleEventBus.c(threadMode, this, ECSetSellingPointFinishEvent.class, new f());
        lifecycleEventBus.c(threadMode, this, ECLiveWindowEditEvent.class, new g());
    }

    private final void cj() {
        ECLiveWindowSubViewModel eCLiveWindowSubViewModel = this.viewModel;
        if (eCLiveWindowSubViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        }
        eCLiveWindowSubViewModel.u2().observe(getViewLifecycleOwner(), new Observer<Integer>() { // from class: com.tencent.ecommerce.biz.live.ui.ECLiveWindowSubFragment$registerLiveDataObserver$1

            /* JADX INFO: Access modifiers changed from: package-private */
            /* compiled from: P */
            @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n\u00a2\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", NodeProps.ON_CLICK}, k = 3, mv = {1, 4, 1})
            /* loaded from: classes31.dex */
            public static final class a implements View.OnClickListener {
                a() {
                }

                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    EventCollector.getInstance().onViewClickedBefore(view);
                    ECLiveWindowSubFragment.this.Ri();
                    EventCollector.getInstance().onViewClicked(view);
                }
            }

            @Override // androidx.lifecycle.Observer
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public final void onChanged(Integer num) {
                int i3;
                boolean z16;
                int i16;
                int i17;
                int i18;
                String str;
                boolean z17;
                String str2;
                boolean isBlank;
                String string;
                String string2;
                String string3;
                cg0.a.b(ECLiveWindowSubFragment.bi(ECLiveWindowSubFragment.this), "LiveDataChange refreshStatusLiveData onChange, value:" + num);
                if (num != null && num.intValue() == 1) {
                    if (ECLiveWindowSubFragment.mi(ECLiveWindowSubFragment.this).A2()) {
                        ECLiveWindowSubFragment.ii(ECLiveWindowSubFragment.this).show();
                        ECLiveWindowSubFragment.Xh(ECLiveWindowSubFragment.this).setVisibility(8);
                    }
                    ECLiveWindowSubFragment.Zh(ECLiveWindowSubFragment.this).m0(0);
                    return;
                }
                if (num != null && num.intValue() == 2) {
                    ECLiveWindowSubFragment.ii(ECLiveWindowSubFragment.this).hide();
                    if (ECLiveWindowSubFragment.mi(ECLiveWindowSubFragment.this).A2()) {
                        ECLiveWindowSubFragment.Xh(ECLiveWindowSubFragment.this).setVisibility(0);
                        z17 = ECLiveWindowSubFragment.this.isMaster;
                        if (z17) {
                            ECLiveWindowSubFragment.Wh(ECLiveWindowSubFragment.this).setVisibility(0);
                            ECLiveWindowSubFragment.Wh(ECLiveWindowSubFragment.this).setOnClickListener(new a());
                            ECStateCenterView ji5 = ECLiveWindowSubFragment.ji(ECLiveWindowSubFragment.this);
                            FragmentActivity activity = ECLiveWindowSubFragment.this.getActivity();
                            IStateCenterView.a.a(ji5, (activity == null || (string3 = activity.getString(R.string.wls)) == null) ? "" : string3, null, 0, 6, null);
                        } else {
                            ECLiveWindowSubFragment.Wh(ECLiveWindowSubFragment.this).setVisibility(8);
                            str2 = ECLiveWindowSubFragment.this.couponId;
                            isBlank = StringsKt__StringsJVMKt.isBlank(str2);
                            if (!isBlank) {
                                ECStateCenterView ji6 = ECLiveWindowSubFragment.ji(ECLiveWindowSubFragment.this);
                                FragmentActivity activity2 = ECLiveWindowSubFragment.this.getActivity();
                                IStateCenterView.a.a(ji6, (activity2 == null || (string2 = activity2.getString(R.string.wl8)) == null) ? "" : string2, "qecommerce_skin_emptystate_img_wenjian", 0, 4, null);
                            } else {
                                ECStateCenterView ji7 = ECLiveWindowSubFragment.ji(ECLiveWindowSubFragment.this);
                                FragmentActivity activity3 = ECLiveWindowSubFragment.this.getActivity();
                                IStateCenterView.a.a(ji7, (activity3 == null || (string = activity3.getString(R.string.wlr)) == null) ? "" : string, null, 0, 6, null);
                            }
                        }
                    } else {
                        ECLiveWindowSubFragment.Xh(ECLiveWindowSubFragment.this).setVisibility(8);
                        z16 = ECLiveWindowSubFragment.this.isMaster;
                        if (z16) {
                            i17 = ECLiveWindowSubFragment.this.refreshCount;
                            if (i17 == 1 && (ECLiveWindowSubFragment.this.tabInfo.id == LiveTabId.LIVE_TAB_PRODUCT || ECLiveWindowSubFragment.this.tabInfo.id == LiveTabId.LIVE_TAB_QSHOP)) {
                                ECLiveWindowSubFragment.this.yi();
                            }
                        }
                        i16 = ECLiveWindowSubFragment.this.refreshCount;
                        if (i16 == 1) {
                            final Ref.IntRef intRef = new Ref.IntRef();
                            RecyclerView.LayoutManager layoutManager = ECLiveWindowSubFragment.di(ECLiveWindowSubFragment.this).getLayoutManager();
                            if (!(layoutManager instanceof LinearLayoutManager)) {
                                layoutManager = null;
                            }
                            LinearLayoutManager linearLayoutManager = (LinearLayoutManager) layoutManager;
                            int findLastVisibleItemPosition = linearLayoutManager != null ? linearLayoutManager.findLastVisibleItemPosition() : -1;
                            intRef.element = findLastVisibleItemPosition;
                            if (findLastVisibleItemPosition == -1) {
                                ECThreadUtilKt.c(new Function0<Unit>() { // from class: com.tencent.ecommerce.biz.live.ui.ECLiveWindowSubFragment$registerLiveDataObserver$1.2
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
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
                                        Ref.IntRef intRef2 = intRef;
                                        RecyclerView.LayoutManager layoutManager2 = ECLiveWindowSubFragment.di(ECLiveWindowSubFragment.this).getLayoutManager();
                                        if (!(layoutManager2 instanceof LinearLayoutManager)) {
                                            layoutManager2 = null;
                                        }
                                        LinearLayoutManager linearLayoutManager2 = (LinearLayoutManager) layoutManager2;
                                        intRef2.element = linearLayoutManager2 != null ? linearLayoutManager2.findLastVisibleItemPosition() : -1;
                                        ECLiveWindowSubFragment.mi(ECLiveWindowSubFragment.this).N2(intRef.element);
                                        cg0.a.b(ECLiveWindowSubFragment.bi(ECLiveWindowSubFragment.this), "last chance to init lastVisibleItemIndex:" + intRef.element);
                                    }
                                });
                            } else {
                                ECLiveWindowSubFragment.mi(ECLiveWindowSubFragment.this).N2(intRef.element);
                            }
                            cg0.a.b(ECLiveWindowSubFragment.bi(ECLiveWindowSubFragment.this), "after first refresh, init lastVisibleItemIndex:" + intRef.element);
                        }
                    }
                    i18 = ECLiveWindowSubFragment.this.refreshCount;
                    if (i18 == 1) {
                        LifecycleEventBus.f100688b.f(new ECLiveWindowFirstLoadEvent(ECLiveWindowSubFragment.this.tabInfo.id, true));
                    }
                    ECLiveWindowSubViewModel mi5 = ECLiveWindowSubFragment.mi(ECLiveWindowSubFragment.this);
                    str = ECLiveWindowSubFragment.this.couponId;
                    mi5.h2(str);
                    ECLiveWindowSubFragment.Zh(ECLiveWindowSubFragment.this).m0(ECLiveWindowSubFragment.mi(ECLiveWindowSubFragment.this).getIsListEnd().get() ? 1 : 0);
                    ECLiveWindowSubFragment.this.zi();
                    return;
                }
                if (num != null && num.intValue() == 3) {
                    ECLiveWindowSubFragment.ii(ECLiveWindowSubFragment.this).hide();
                    if (ECLiveWindowSubFragment.mi(ECLiveWindowSubFragment.this).A2()) {
                        ECLiveWindowSubFragment.Xh(ECLiveWindowSubFragment.this).setVisibility(0);
                        ECLiveWindowSubFragment.Wh(ECLiveWindowSubFragment.this).setVisibility(8);
                        ECLiveWindowSubFragment.ji(ECLiveWindowSubFragment.this).setRetryListener(new Function0<Unit>() { // from class: com.tencent.ecommerce.biz.live.ui.ECLiveWindowSubFragment$registerLiveDataObserver$1.3
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
                                ECLiveWindowSubFragment.aj(ECLiveWindowSubFragment.this, null, false, 3, null);
                            }
                        });
                        ECLiveWindowSubFragment.ji(ECLiveWindowSubFragment.this).setFailedState("");
                    }
                    i3 = ECLiveWindowSubFragment.this.refreshCount;
                    if (i3 == 1) {
                        LifecycleEventBus.f100688b.f(new ECLiveWindowFirstLoadEvent(ECLiveWindowSubFragment.this.tabInfo.id, false));
                    }
                    ECLiveWindowSubFragment.Zh(ECLiveWindowSubFragment.this).m0(2);
                }
            }
        });
        ECLiveWindowSubViewModel eCLiveWindowSubViewModel2 = this.viewModel;
        if (eCLiveWindowSubViewModel2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        }
        eCLiveWindowSubViewModel2.t2().observe(getViewLifecycleOwner(), new h());
        ECLiveWindowSubViewModel eCLiveWindowSubViewModel3 = this.viewModel;
        if (eCLiveWindowSubViewModel3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        }
        eCLiveWindowSubViewModel3.o2().observe(getViewLifecycleOwner(), new i());
        ECLiveWindowSubViewModel eCLiveWindowSubViewModel4 = this.viewModel;
        if (eCLiveWindowSubViewModel4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        }
        eCLiveWindowSubViewModel4.v2().observe(getViewLifecycleOwner(), new j());
        ECLiveWindowSubViewModel eCLiveWindowSubViewModel5 = this.viewModel;
        if (eCLiveWindowSubViewModel5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        }
        eCLiveWindowSubViewModel5.w2().observe(getViewLifecycleOwner(), new k());
        ECLiveWindowSubViewModel eCLiveWindowSubViewModel6 = this.viewModel;
        if (eCLiveWindowSubViewModel6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        }
        eCLiveWindowSubViewModel6.q2().observe(getViewLifecycleOwner(), new l());
        ECLiveWindowSubViewModel eCLiveWindowSubViewModel7 = this.viewModel;
        if (eCLiveWindowSubViewModel7 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        }
        eCLiveWindowSubViewModel7.r2().observe(getViewLifecycleOwner(), new m());
    }

    public static final /* synthetic */ RecyclerView di(ECLiveWindowSubFragment eCLiveWindowSubFragment) {
        RecyclerView recyclerView = eCLiveWindowSubFragment.recycleView;
        if (recyclerView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("recycleView");
        }
        return recyclerView;
    }

    private final void dj(List<LiveProduct> selectedProductList) {
        FragmentManager supportFragmentManager;
        FragmentTransaction beginTransaction;
        FragmentTransaction add;
        if (this.confirmDialog == null) {
            ECLiveWindowConfirmDialog eCLiveWindowConfirmDialog = new ECLiveWindowConfirmDialog();
            this.confirmDialog = eCLiveWindowConfirmDialog;
            eCLiveWindowConfirmDialog.Nh(new n(selectedProductList));
        }
        String str = this.logTag;
        if (str == null) {
            Intrinsics.throwUninitializedPropertyAccessException("logTag");
        }
        StringBuilder sb5 = new StringBuilder();
        sb5.append("showConfirmDialog selectedProductList.size:");
        sb5.append(selectedProductList.size());
        sb5.append(", dataSize:");
        ECLiveWindowSubViewModel eCLiveWindowSubViewModel = this.viewModel;
        if (eCLiveWindowSubViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        }
        sb5.append(eCLiveWindowSubViewModel.s2());
        cg0.a.b(str, sb5.toString());
        ECLiveWindowConfirmDialog eCLiveWindowConfirmDialog2 = this.confirmDialog;
        if (eCLiveWindowConfirmDialog2 != null) {
            FragmentActivity activity = getActivity();
            if (activity != null && (supportFragmentManager = activity.getSupportFragmentManager()) != null && (beginTransaction = supportFragmentManager.beginTransaction()) != null && (add = beginTransaction.add(R.id.f163019nv4, eCLiveWindowConfirmDialog2)) != null) {
                add.commit();
            }
            FrameLayout frameLayout = this.deleteConfirmDialogContainer;
            if (frameLayout != null) {
                frameLayout.setVisibility(0);
            }
        }
        ECLiveWindowConfirmDialog eCLiveWindowConfirmDialog3 = this.confirmDialog;
        if (eCLiveWindowConfirmDialog3 != null) {
            int size = selectedProductList.size();
            ECLiveWindowSubViewModel eCLiveWindowSubViewModel2 = this.viewModel;
            if (eCLiveWindowSubViewModel2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            }
            List<LiveProduct> value = eCLiveWindowSubViewModel2.t2().getValue();
            if (value != null && size == value.size()) {
                eCLiveWindowConfirmDialog3.Mh(getString(R.string.wl_));
            } else {
                eCLiveWindowConfirmDialog3.Mh(getString(R.string.wla, Integer.valueOf(selectedProductList.size())));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void ej(Context context) {
        BuildersKt__Builders_commonKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this), null, null, new ECLiveWindowSubFragment$updateActivityCountdown$1(this, context, null), 3, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void fj(boolean isEditable) {
        if (this.isMaster) {
            if (isEditable) {
                Ai();
            } else {
                Bi();
            }
        }
        fi0.a aVar = this.listAdapter;
        if (aVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("listAdapter");
        }
        aVar.l0(isEditable);
    }

    public static final /* synthetic */ TextView gi(ECLiveWindowSubFragment eCLiveWindowSubFragment) {
        TextView textView = eCLiveWindowSubFragment.selectHintText;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("selectHintText");
        }
        return textView;
    }

    public static final /* synthetic */ TextView hi(ECLiveWindowSubFragment eCLiveWindowSubFragment) {
        TextView textView = eCLiveWindowSubFragment.setTopBtn;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("setTopBtn");
        }
        return textView;
    }

    public static final /* synthetic */ SkeletonScreen ii(ECLiveWindowSubFragment eCLiveWindowSubFragment) {
        SkeletonScreen skeletonScreen = eCLiveWindowSubFragment.skeleton;
        if (skeletonScreen == null) {
            Intrinsics.throwUninitializedPropertyAccessException("skeleton");
        }
        return skeletonScreen;
    }

    private final void initArguments() {
        TabInfo tabInfo;
        Intent intent;
        FragmentActivity activity = getActivity();
        Bundle bundle = null;
        Intent intent2 = activity != null ? activity.getIntent() : null;
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
        Bundle arguments = getArguments();
        if (arguments == null || (tabInfo = (TabInfo) arguments.getParcelable("KEY_TAB_INFO")) == null) {
            tabInfo = new TabInfo();
        }
        this.tabInfo = tabInfo;
        String str = "ECLiveWindowSubFragment_" + this.tabInfo.id;
        this.logTag = str;
        if (str == null) {
            Intrinsics.throwUninitializedPropertyAccessException("logTag");
        }
        StringBuilder sb5 = new StringBuilder();
        sb5.append("initArguments, intent.extras:");
        FragmentActivity activity2 = getActivity();
        if (activity2 != null && (intent = activity2.getIntent()) != null) {
            bundle = intent.getExtras();
        }
        sb5.append(String.valueOf(bundle));
        sb5.append(" tabInfo:");
        sb5.append(this.tabInfo);
        cg0.a.b(str, sb5.toString());
    }

    public static final /* synthetic */ ECStateCenterView ji(ECLiveWindowSubFragment eCLiveWindowSubFragment) {
        ECStateCenterView eCStateCenterView = eCLiveWindowSubFragment.stateView;
        if (eCStateCenterView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("stateView");
        }
        return eCStateCenterView;
    }

    public static final /* synthetic */ ECLiveWindowSubViewModel mi(ECLiveWindowSubFragment eCLiveWindowSubFragment) {
        ECLiveWindowSubViewModel eCLiveWindowSubViewModel = eCLiveWindowSubFragment.viewModel;
        if (eCLiveWindowSubViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        }
        return eCLiveWindowSubViewModel;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void yi() {
        ECLiveWindowSubViewModel eCLiveWindowSubViewModel = this.viewModel;
        if (eCLiveWindowSubViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        }
        int m26 = eCLiveWindowSubViewModel.m2();
        if (m26 != -1) {
            RecyclerView recyclerView = this.recycleView;
            if (recyclerView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("recycleView");
            }
            recyclerView.smoothScrollToPosition(m26);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void zi() {
        ECLiveWindowSubViewModel eCLiveWindowSubViewModel = this.viewModel;
        if (eCLiveWindowSubViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        }
        if (eCLiveWindowSubViewModel.C2()) {
            this.timeHandler.removeMessages(1);
            this.timeHandler.sendEmptyMessage(1);
        } else {
            String str = this.logTag;
            if (str == null) {
                Intrinsics.throwUninitializedPropertyAccessException("logTag");
            }
            cg0.a.b(str, "check needPollingActivity false");
            this.timeHandler.removeMessages(1);
        }
        if (Si()) {
            this.timeHandler.removeMessages(2);
            this.timeHandler.sendEmptyMessage(2);
            return;
        }
        String str2 = this.logTag;
        if (str2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("logTag");
        }
        cg0.a.b(str2, "check needUpdateCountdown false");
        this.timeHandler.removeMessages(2);
    }

    public final String Gi() {
        if (a.f102788b[this.tabInfo.id.ordinal()] != 1) {
            return "mqqapi://ecommerce/open?target=7&channel=8&window_type=3&src_type=internal&version=1";
        }
        return "mqqapi://ecommerce/open?target=51&channel=8&window_type=4&src_type=internal&version=1&is_appcompat_style=1";
    }

    public final Map<String, Object> Ii() {
        String str;
        Map<String, Object> mapOf;
        int i3 = a.f102787a[this.tabInfo.id.ordinal()];
        if (i3 == 1) {
            str = "live_product_counts";
        } else if (i3 != 2) {
            str = "none";
        } else {
            str = "shop_product_counts";
        }
        ECLiveWindowSubViewModel eCLiveWindowSubViewModel = this.viewModel;
        if (eCLiveWindowSubViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        }
        mapOf = MapsKt__MapsJVMKt.mapOf(new Pair(str, Integer.valueOf(eCLiveWindowSubViewModel.s2())));
        return mapOf;
    }

    public final boolean Si() {
        return !Fi().isEmpty();
    }

    @Override // com.tencent.ecommerce.base.fragment.api.IECBaseFragment
    /* renamed from: getBusinessDescription */
    public String getTAG() {
        return "ECLiveWindowSubFragment";
    }

    @Override // com.tencent.ecommerce.base.fragment.ECBaseFragment
    public int getContentLayoutId() {
        return R.layout.cqx;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Integer valueOf = view != null ? Integer.valueOf(view.getId()) : null;
        if (valueOf != null && valueOf.intValue() == R.id.ofl) {
            Ji();
        } else if (valueOf != null && valueOf.intValue() == R.id.ofy) {
            Oi();
        } else if (valueOf != null && valueOf.intValue() == R.id.o9u) {
            Ni();
        } else {
            String str = this.logTag;
            if (str == null) {
                Intrinsics.throwUninitializedPropertyAccessException("logTag");
            }
            StringBuilder sb5 = new StringBuilder();
            sb5.append("unknown click, id:");
            sb5.append(view != null ? Integer.valueOf(view.getId()) : null);
            cg0.a.a(str, NodeProps.ON_CLICK, sb5.toString());
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    @Override // com.tencent.ecommerce.base.fragment.ECBaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.windowInitTimeMs = System.currentTimeMillis();
        initArguments();
        ECLiveWindowSubViewModel eCLiveWindowSubViewModel = (ECLiveWindowSubViewModel) new ViewModelProvider(this).get(ECLiveWindowSubViewModel.class);
        this.viewModel = eCLiveWindowSubViewModel;
        if (eCLiveWindowSubViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        }
        FragmentActivity activity = getActivity();
        eCLiveWindowSubViewModel.z2(activity != null ? activity.getIntent() : null, this.tabInfo);
    }

    @Override // com.tencent.ecommerce.base.fragment.ECBaseFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        this.timeHandler.removeCallbacksAndMessages(null);
    }

    @Override // com.tencent.ecommerce.base.fragment.ECBaseFragment, androidx.fragment.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        ECThreadUtilKt.a(new Function0<Unit>() { // from class: com.tencent.ecommerce.biz.live.ui.ECLiveWindowSubFragment$onDestroyView$1
            /* JADX INFO: Access modifiers changed from: package-private */
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
                String str;
                String str2;
                String str3;
                int i3;
                List<LiveProduct> value = ECLiveWindowSubFragment.mi(ECLiveWindowSubFragment.this).t2().getValue();
                if (value != null) {
                    for (LiveProduct liveProduct : value) {
                        d dVar = d.f396304b;
                        str = ECLiveWindowSubFragment.this.userId;
                        str2 = ECLiveWindowSubFragment.this.roomId;
                        str3 = ECLiveWindowSubFragment.this.programId;
                        i3 = ECLiveWindowSubFragment.this.liveType;
                        dVar.y(str, str2, str3, i3, liveProduct);
                    }
                }
            }
        });
    }

    @Override // com.tencent.ecommerce.base.ui.recyclerviewhelper.ECOnDragSortListener
    public void onDragEnd(RecyclerView.ViewHolder viewHolder) {
        String str = this.logTag;
        if (str == null) {
            Intrinsics.throwUninitializedPropertyAccessException("logTag");
        }
        cg0.a.b(str, "onDragEnd");
        ECLiveWindowSubViewModel eCLiveWindowSubViewModel = this.viewModel;
        if (eCLiveWindowSubViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        }
        fi0.a aVar = this.listAdapter;
        if (aVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("listAdapter");
        }
        eCLiveWindowSubViewModel.T2(aVar.j0());
    }

    @Override // com.tencent.ecommerce.base.fragment.ECBaseFragment, androidx.fragment.app.Fragment
    public void onPause() {
        super.onPause();
        String str = this.logTag;
        if (str == null) {
            Intrinsics.throwUninitializedPropertyAccessException("logTag");
        }
        cg0.a.b(str, MiniSDKConst.NOTIFY_EVENT_ONPAUSE);
        this.timeHandler.removeCallbacksAndMessages(null);
    }

    @Override // com.tencent.ecommerce.base.fragment.ECBaseFragment, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        String str = this.logTag;
        if (str == null) {
            Intrinsics.throwUninitializedPropertyAccessException("logTag");
        }
        cg0.a.b(str, "onResume");
        zi();
    }

    @Override // com.tencent.ecommerce.base.ui.recyclerviewhelper.ECOnDragSortListener
    public void onStartDrag(RecyclerView.ViewHolder viewHolder) {
        String str = this.logTag;
        if (str == null) {
            Intrinsics.throwUninitializedPropertyAccessException("logTag");
        }
        cg0.a.b(str, "onStartDrag");
        ItemTouchHelper itemTouchHelper = this.itemTouchHelper;
        if (itemTouchHelper == null) {
            Intrinsics.throwUninitializedPropertyAccessException("itemTouchHelper");
        }
        itemTouchHelper.startDrag(viewHolder);
    }

    @Override // com.tencent.ecommerce.base.fragment.ECBaseFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initUI(view);
        cj();
        bj();
        aj(this, null, false, 3, null);
        if (this.isMaster && !this.isLiveOpened) {
            ECLiveWindowSubViewModel eCLiveWindowSubViewModel = this.viewModel;
            if (eCLiveWindowSubViewModel == null) {
                Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            }
            eCLiveWindowSubViewModel.M2(true);
        }
        Pi();
    }

    @Override // com.tencent.ecommerce.base.fragment.ECBaseFragment
    public int uh() {
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0005\u001a\u00020\u00042\u001a\u0010\u0003\u001a\u0016\u0012\u0004\u0012\u00020\u0001 \u0002*\n\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u00000\u0000H\n\u00a2\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"", "Lcom/tencent/ecommerce/repo/live/q;", "kotlin.jvm.PlatformType", "it", "", "a", "(Ljava/util/List;)V"}, k = 3, mv = {1, 4, 1})
    /* loaded from: classes31.dex */
    public static final class j<T> implements Observer<List<? extends LiveProduct>> {
        j() {
        }

        @Override // androidx.lifecycle.Observer
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final void onChanged(List<LiveProduct> list) {
            if (list != null) {
                cg0.a.b(ECLiveWindowSubFragment.bi(ECLiveWindowSubFragment.this), "LiveDataChange selectedProductListLiveData onChange, size:" + list.size());
                if (list.isEmpty()) {
                    ECLiveWindowSubFragment.gi(ECLiveWindowSubFragment.this).setText("");
                    ECLiveWindowSubFragment.Vh(ECLiveWindowSubFragment.this).setEnabled(false);
                    ECLiveWindowSubFragment.hi(ECLiveWindowSubFragment.this).setEnabled(false);
                } else {
                    TextView gi5 = ECLiveWindowSubFragment.gi(ECLiveWindowSubFragment.this);
                    FragmentActivity activity = ECLiveWindowSubFragment.this.getActivity();
                    gi5.setText(activity != null ? activity.getString(R.string.wmz, Integer.valueOf(list.size())) : null);
                    ECLiveWindowSubFragment.Vh(ECLiveWindowSubFragment.this).setEnabled(true);
                    ECLiveWindowSubFragment.hi(ECLiveWindowSubFragment.this).setEnabled(true);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0003\u001a\u00020\u00022\b\u0010\u0001\u001a\u0004\u0018\u00010\u0000H\n\u00a2\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/tencent/ecommerce/repo/live/q;", "topProduct", "", "a", "(Lcom/tencent/ecommerce/repo/live/q;)V"}, k = 3, mv = {1, 4, 1})
    /* loaded from: classes31.dex */
    public static final class k<T> implements Observer<LiveProduct> {
        k() {
        }

        @Override // androidx.lifecycle.Observer
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final void onChanged(LiveProduct liveProduct) {
            if (liveProduct != null) {
                RecyclerView.LayoutManager layoutManager = ECLiveWindowSubFragment.di(ECLiveWindowSubFragment.this).getLayoutManager();
                if (!(layoutManager instanceof LinearLayoutManager)) {
                    layoutManager = null;
                }
                LinearLayoutManager linearLayoutManager = (LinearLayoutManager) layoutManager;
                int findFirstCompletelyVisibleItemPosition = linearLayoutManager != null ? linearLayoutManager.findFirstCompletelyVisibleItemPosition() : -1;
                if (findFirstCompletelyVisibleItemPosition == 0 || findFirstCompletelyVisibleItemPosition == 1) {
                    ECLiveWindowSubFragment.di(ECLiveWindowSubFragment.this).scrollToPosition(0);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0005\u001a\u00020\u00042\u001a\u0010\u0003\u001a\u0016\u0012\u0004\u0012\u00020\u0001 \u0002*\n\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u00000\u0000H\n\u00a2\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"", "Lcom/tencent/ecommerce/repo/live/q;", "kotlin.jvm.PlatformType", "it", "", "a", "(Ljava/util/List;)V"}, k = 3, mv = {1, 4, 1})
    /* loaded from: classes31.dex */
    public static final class h<T> implements Observer<List<? extends LiveProduct>> {
        h() {
        }

        @Override // androidx.lifecycle.Observer
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final void onChanged(List<LiveProduct> list) {
            if (list != null) {
                if (!list.isEmpty()) {
                    ECLiveWindowSubFragment.Xh(ECLiveWindowSubFragment.this).setVisibility(8);
                    ECLiveWindowSubFragment.this.zi();
                }
                cg0.a.b(ECLiveWindowSubFragment.bi(ECLiveWindowSubFragment.this), "LiveDataChange liveProductListLiveData onChange, size:" + list.size());
                ECLiveWindowSubFragment.Zh(ECLiveWindowSubFragment.this).setData(list);
                if (ECLiveWindowSubFragment.this.tabInfo.id == LiveTabId.LIVE_TAB_PRODUCT || ECLiveWindowSubFragment.this.tabInfo.id == LiveTabId.LIVE_TAB_QSHOP) {
                    LifecycleEventBus.f100688b.f(new ECLiveWindowContentSizeChangeEvent(ECLiveWindowSubFragment.this.tabInfo.id, list.size()));
                }
            }
        }
    }

    private final void Qi(final LiveProduct liveProduct, final long curPlayTime, final boolean isButton) {
        String detailUrl;
        boolean isBlank;
        if (liveProduct == null || (detailUrl = liveProduct.getDetailUrl()) == null) {
            return;
        }
        isBlank = StringsKt__StringsJVMKt.isBlank(detailUrl);
        if (!isBlank) {
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            linkedHashMap.put("half", "1");
            linkedHashMap.put(LayoutAttrDefine.MARGIN_TOP, 224);
            linkedHashMap.put("is_from_live", "1");
            ECScheme.e(liveProduct.getDetailUrl(), linkedHashMap);
            ECThreadUtilKt.a(new Function0<Unit>() { // from class: com.tencent.ecommerce.biz.live.ui.ECLiveWindowSubFragment$jumpToDetailPage$1
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
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
                    String str;
                    String str2;
                    String str3;
                    int i3;
                    String str4;
                    d dVar = d.f396304b;
                    str = ECLiveWindowSubFragment.this.userId;
                    str2 = ECLiveWindowSubFragment.this.roomId;
                    str3 = ECLiveWindowSubFragment.this.programId;
                    i3 = ECLiveWindowSubFragment.this.liveType;
                    dVar.w(str, str2, str3, i3, curPlayTime, liveProduct, isButton);
                    com.tencent.ecommerce.repo.live.e eVar = com.tencent.ecommerce.repo.live.e.f105131a;
                    str4 = ECLiveWindowSubFragment.this.roomId;
                    eVar.a(str4);
                }
            });
        }
    }

    private final void initUI(View rootView) {
        this.emptyLayout = rootView.findViewById(R.id.ofn);
        this.stateView = (ECStateCenterView) rootView.findViewById(R.id.f163103ob2);
        this.emptyButton = (Button) rootView.findViewById(R.id.ofm);
        this.listAdapter = new fi0.a(requireContext(), this.isMaster, new Function1<LiveProduct, Unit>() { // from class: com.tencent.ecommerce.biz.live.ui.ECLiveWindowSubFragment$initUI$onItemClick$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(LiveProduct liveProduct) {
                invoke2(liveProduct);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(LiveProduct liveProduct) {
                ECLiveWindowSubFragment.this.Wi(liveProduct);
            }
        }, this, new Function1<LiveProduct, Unit>() { // from class: com.tencent.ecommerce.biz.live.ui.ECLiveWindowSubFragment$initUI$onActionClick$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(LiveProduct liveProduct) {
                invoke2(liveProduct);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(LiveProduct liveProduct) {
                ECLiveWindowSubFragment.this.Ti(liveProduct);
            }
        }, new Function1<LiveProduct, Unit>() { // from class: com.tencent.ecommerce.biz.live.ui.ECLiveWindowSubFragment$initUI$onSellingPointClick$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(LiveProduct liveProduct) {
                invoke2(liveProduct);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(LiveProduct liveProduct) {
                ECLiveWindowSubFragment.this.Yi(liveProduct);
            }
        }, new Function1<LiveProduct, Unit>() { // from class: com.tencent.ecommerce.biz.live.ui.ECLiveWindowSubFragment$initUI$onSelectClick$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(LiveProduct liveProduct) {
                invoke2(liveProduct);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(LiveProduct liveProduct) {
                ECLiveWindowSubFragment.this.Ui(liveProduct);
            }
        }, new Function2<LiveProduct, Boolean, Unit>() { // from class: com.tencent.ecommerce.biz.live.ui.ECLiveWindowSubFragment$initUI$itemExposure$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(LiveProduct liveProduct, Boolean bool) {
                invoke(liveProduct, bool.booleanValue());
                return Unit.INSTANCE;
            }

            public final void invoke(LiveProduct liveProduct, boolean z16) {
                ECLiveWindowSubFragment.this.Xi(liveProduct, z16);
            }
        }, new Function0<Unit>() { // from class: com.tencent.ecommerce.biz.live.ui.ECLiveWindowSubFragment$initUI$onFooterRetryClick$1
            /* JADX INFO: Access modifiers changed from: package-private */
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
                ECLiveWindowSubFragment.this.Vi();
            }
        });
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
        fi0.a aVar = this.listAdapter;
        if (aVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("listAdapter");
        }
        recyclerView2.setAdapter(aVar);
        RecyclerView recyclerView3 = this.recycleView;
        if (recyclerView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("recycleView");
        }
        recyclerView3.setLayoutManager(new LinearLayoutManager(getActivity()));
        RecyclerView recyclerView4 = this.recycleView;
        if (recyclerView4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("recycleView");
        }
        recyclerView4.addOnAttachStateChangeListener(new b());
        RecyclerView recyclerView5 = this.recycleView;
        if (recyclerView5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("recycleView");
        }
        recyclerView5.addOnScrollListener(new c());
        fi0.a aVar2 = this.listAdapter;
        if (aVar2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("listAdapter");
        }
        ItemTouchHelper itemTouchHelper = new ItemTouchHelper(new eh0.a(aVar2));
        this.itemTouchHelper = itemTouchHelper;
        RecyclerView recyclerView6 = this.recycleView;
        if (recyclerView6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("recycleView");
        }
        itemTouchHelper.attachToRecyclerView(recyclerView6);
        this.windowBottomBar = rootView.findViewById(R.id.ofg);
        this.selectHintText = (TextView) rootView.findViewById(R.id.ofr);
        this.deleteBtn = (TextView) rootView.findViewById(R.id.ofl);
        this.setTopBtn = (TextView) rootView.findViewById(R.id.ofy);
        TextView textView = this.deleteBtn;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("deleteBtn");
        }
        textView.setOnClickListener(this);
        TextView textView2 = this.setTopBtn;
        if (textView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("setTopBtn");
        }
        textView2.setOnClickListener(this);
        this.searchBar = rootView.findViewById(R.id.o9u);
        this.searchHint = (TextView) rootView.findViewById(R.id.o_1);
        View view = this.searchBar;
        if (view == null) {
            Intrinsics.throwUninitializedPropertyAccessException("searchBar");
        }
        view.setOnClickListener(this);
        if (this.isMaster && this.tabInfo.hasSearch) {
            View view2 = this.searchBar;
            if (view2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("searchBar");
            }
            view2.setVisibility(0);
            if (this.tabInfo.id == LiveTabId.LIVE_TAB_GOK) {
                TextView textView3 = this.searchHint;
                if (textView3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("searchHint");
                }
                textView3.setText(requireContext().getString(R.string.wnp));
            }
        }
        FragmentActivity activity = getActivity();
        this.deleteConfirmDialogContainer = activity != null ? (FrameLayout) activity.findViewById(R.id.f163019nv4) : null;
        RecyclerView recyclerView7 = this.recycleView;
        if (recyclerView7 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("recycleView");
        }
        a.b a16 = fh0.c.a(recyclerView7);
        fi0.a aVar3 = this.listAdapter;
        if (aVar3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("listAdapter");
        }
        this.skeleton = a16.k(aVar3).q(true).l(10).m(R.color.f6722b).o(true).n(9).p(R.layout.crv).r();
        this.couponLabelBar = rootView.findViewById(R.id.nuu);
        this.couponLabelView = (ECLiveLabelView) rootView.findViewById(R.id.oc5);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void aj(ECLiveWindowSubFragment eCLiveWindowSubFragment, String str, boolean z16, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            str = null;
        }
        if ((i3 & 2) != 0) {
            z16 = false;
        }
        eCLiveWindowSubFragment.Zi(str, z16);
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\u0006\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016\u00a8\u0006\u0007"}, d2 = {"com/tencent/ecommerce/biz/live/ui/ECLiveWindowSubFragment$b", "Landroid/view/View$OnAttachStateChangeListener;", "Landroid/view/View;", "view", "", "onViewAttachedToWindow", "onViewDetachedFromWindow", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
    /* loaded from: classes31.dex */
    public static final class b implements View.OnAttachStateChangeListener {
        b() {
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewAttachedToWindow(View view) {
            RecyclerView.LayoutManager layoutManager = ECLiveWindowSubFragment.di(ECLiveWindowSubFragment.this).getLayoutManager();
            if (layoutManager == null || layoutManager.getItemCount() <= 0) {
                return;
            }
            ECLiveWindowSubFragment.Zh(ECLiveWindowSubFragment.this).notifyItemChanged(layoutManager.getItemCount() - 1);
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewDetachedFromWindow(View view) {
        }
    }
}

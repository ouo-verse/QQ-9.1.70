package com.tencent.sqshow.zootopia.nativeui.view.page;

import android.content.Context;
import android.content.res.Configuration;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.HorizontalScrollView;
import androidx.exifinterface.media.ExifInterface;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.utils.QQTheme;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.sqshow.zootopia.card.report.ZplanViewReportHelper;
import com.tencent.sqshow.zootopia.nativeui.adapter.holder.BaseAvatarPanelItemViewHolder;
import com.tencent.sqshow.zootopia.nativeui.data.CameraKey;
import com.tencent.sqshow.zootopia.nativeui.data.repo.PanelSubTitlePageDataRepo;
import com.tencent.sqshow.zootopia.nativeui.data.repo.t;
import com.tencent.sqshow.zootopia.nativeui.data.title.PortalStorePanelCategoryData;
import com.tencent.sqshow.zootopia.nativeui.data.title.PortalStorePanelTypeData;
import com.tencent.sqshow.zootopia.nativeui.view.common.AvatarPanelErrorView;
import com.tencent.sqshow.zootopia.nativeui.view.page.a;
import com.tencent.sqshow.zootopia.nativeui.view.title.PortalStorePanelThirdTitleView;
import com.tencent.sqshow.zootopia.view.pull2refresh.ZootopiaLoadMoreView;
import com.tencent.sqshow.zootopia.view.pull2refresh.androidx.RecyclerViewXWithHeaderFooter;
import com.tencent.sqshow.zootopia.view.pull2refresh.androidx.XPullToRefreshViewV2;
import com.tencent.sqshow.zootopia.widget.reddot.ZPlanRedDotManager;
import i94.CollectInfo;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.ArraysKt___ArraysKt;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import n74.bs;
import uv4.aa;
import uv4.ah;
import uv4.az;
import uv4.bh;
import uv4.bj;
import uv4.bk;

@Metadata(d1 = {"\u0000\u00e0\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005*\u0004\u0084\u0001\u0087\u0001\u0018\u0000 \n2\u00020\u00012\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u00022\u00020\u0005:\u0001BB6\b\u0007\u0012\b\u0010\u008b\u0001\u001a\u00030\u008a\u0001\u0012\f\b\u0002\u0010\u008d\u0001\u001a\u0005\u0018\u00010\u008c\u0001\u0012\t\b\u0002\u0010\u008e\u0001\u001a\u00020\u0014\u0012\u0006\u0010Q\u001a\u00020N\u00a2\u0006\u0006\b\u008f\u0001\u0010\u0090\u0001J\b\u0010\u0007\u001a\u00020\u0006H\u0002J\u0010\u0010\t\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u0003H\u0002J\b\u0010\n\u001a\u00020\u0006H\u0002J\b\u0010\u000b\u001a\u00020\u0006H\u0002J\b\u0010\f\u001a\u00020\u0006H\u0002J\u0016\u0010\u0010\u001a\u00020\u00062\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u000e0\rH\u0002J\b\u0010\u0011\u001a\u00020\u0006H\u0002J\b\u0010\u0012\u001a\u00020\u0006H\u0002J\b\u0010\u0013\u001a\u00020\u0006H\u0002J\b\u0010\u0015\u001a\u00020\u0014H\u0002J\b\u0010\u0016\u001a\u00020\u0006H\u0002J\b\u0010\u0017\u001a\u00020\u0006H\u0002J\b\u0010\u0018\u001a\u00020\u0006H\u0002J\b\u0010\u0019\u001a\u00020\u0006H\u0002J\u0018\u0010\u001e\u001a\u00020\u00062\u0006\u0010\u001b\u001a\u00020\u001a2\u0006\u0010\u001d\u001a\u00020\u001cH\u0002J\u0010\u0010!\u001a\u00020\u00142\u0006\u0010 \u001a\u00020\u001fH\u0002J\u001a\u0010%\u001a\u00020\u00062\u0010\b\u0002\u0010$\u001a\n\u0012\u0004\u0012\u00020#\u0018\u00010\"H\u0002J\u001a\u0010&\u001a\u00020\u00062\u0010\b\u0002\u0010$\u001a\n\u0012\u0004\u0012\u00020#\u0018\u00010\"H\u0002J\b\u0010'\u001a\u00020\u0006H\u0002J\b\u0010(\u001a\u00020\u0006H\u0002J\b\u0010)\u001a\u00020\u0003H\u0002J\b\u0010*\u001a\u00020\u001cH\u0002J\b\u0010+\u001a\u00020\u001cH\u0002J\b\u0010,\u001a\u00020\u0006H\u0002J\u0010\u0010/\u001a\u00020\u00062\u0006\u0010.\u001a\u00020-H\u0002J\b\u00100\u001a\u00020\u0006H\u0002J\b\u00101\u001a\u00020\u0006H\u0002J\b\u00102\u001a\u00020\u0014H\u0002J\u0010\u00103\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\u0004H\u0016J\b\u00104\u001a\u00020\u0004H\u0016J\b\u00105\u001a\u00020\u0014H\u0016J\u0010\u00107\u001a\u00020\u00062\u0006\u00106\u001a\u00020\u0014H\u0016J\b\u00109\u001a\u000208H\u0016J\u001a\u0010=\u001a\u00020\u00062\b\u0010;\u001a\u0004\u0018\u00010:2\u0006\u0010<\u001a\u00020\u001cH\u0016J\u001a\u0010?\u001a\u00020\u00062\b\u0010;\u001a\u0004\u0018\u00010:2\u0006\u0010>\u001a\u00020\u0014H\u0016J\b\u0010@\u001a\u00020\u0006H\u0016J\b\u0010A\u001a\u00020\u0006H\u0016J\b\u0010B\u001a\u00020\u0006H\u0016J\b\u0010C\u001a\u00020\u0006H\u0016J\b\u0010D\u001a\u00020\u0006H\u0016J\f\u0010E\u001a\b\u0012\u0004\u0012\u00020\u000e0\rJ\u000e\u0010H\u001a\u00020\u00062\u0006\u0010G\u001a\u00020FJ\u0012\u0010K\u001a\u00020\u00062\b\u0010J\u001a\u0004\u0018\u00010IH\u0014J\b\u0010L\u001a\u00020\u0006H\u0014J\b\u0010M\u001a\u00020\u0006H\u0014R\u0014\u0010Q\u001a\u00020N8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bO\u0010PR\u0014\u0010T\u001a\u00020R8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b=\u0010SR\u0016\u0010V\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bD\u0010UR\u0014\u0010Y\u001a\u00020W8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bA\u0010XR\u0014\u0010]\u001a\u00020Z8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b[\u0010\\R\u0014\u0010a\u001a\u00020^8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b_\u0010`R\u001e\u0010d\u001a\n\u0012\u0004\u0012\u00020#\u0018\u00010\"8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bb\u0010cR\u001e\u0010f\u001a\n\u0012\u0004\u0012\u00020#\u0018\u00010\"8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\be\u0010cR\u0016\u0010i\u001a\u00020\u001c8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bg\u0010hR\u0016\u0010k\u001a\u00020\u001c8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bj\u0010hR\u0016\u0010m\u001a\u00020\u001c8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bl\u0010hR&\u0010r\u001a\u0012\u0012\u0004\u0012\u00020\u00030nj\b\u0012\u0004\u0012\u00020\u0003`o8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bp\u0010qR\u0016\u0010t\u001a\u00020\u00148\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bs\u0010sR\u0016\u0010u\u001a\u00020\u00148\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b(\u0010sR\u0016\u0010w\u001a\u00020\u00038\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b'\u0010vR\u0016\u0010x\u001a\u00020\u00148\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b!\u0010sR\u0016\u0010y\u001a\u00020\u001c8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0015\u0010hR\u0016\u0010z\u001a\u00020\u001c8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b4\u0010hR\u0016\u0010{\u001a\u00020\u00148\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bE\u0010sR\u0016\u0010|\u001a\u00020\u00148\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b)\u0010sR\u001b\u0010\u0080\u0001\u001a\b\u0012\u0004\u0012\u00020~0}8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b/\u0010\u007fR\u001c\u0010\u0082\u0001\u001a\t\u0012\u0005\u0012\u00030\u0081\u00010}8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b,\u0010\u007fR\u001b\u0010\u0083\u0001\u001a\b\u0012\u0004\u0012\u00020\u001c0}8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\f\u0010\u007fR\u0017\u0010\u0086\u0001\u001a\u00030\u0084\u00018\u0002X\u0082\u0004\u00a2\u0006\u0007\n\u0005\b\u0011\u0010\u0085\u0001R\u0017\u0010\u0089\u0001\u001a\u00030\u0087\u00018\u0002X\u0082\u0004\u00a2\u0006\u0007\n\u0005\b\u0017\u0010\u0088\u0001\u00a8\u0006\u0091\u0001"}, d2 = {"Lcom/tencent/sqshow/zootopia/nativeui/view/page/PortalStorePanelCategoryPage;", "Landroid/widget/FrameLayout;", "Lcom/tencent/sqshow/zootopia/nativeui/view/page/a;", "", "Lcom/tencent/sqshow/zootopia/nativeui/data/title/PortalStorePanelCategoryData;", "Lcom/tencent/sqshow/zootopia/view/pull2refresh/androidx/XPullToRefreshViewV2$c;", "", "q0", "tabId", "p0", "W", "w0", "T", "", "Lcom/tencent/sqshow/zootopia/nativeui/data/repo/g;", "data", "o0", "U", "a0", "k0", "", "M", "m0", "V", "r0", "v0", "Lcom/tencent/sqshow/zootopia/nativeui/view/common/AvatarPanelErrorView;", "errorView", "", "isFirstRequestError", "s0", "Luv4/bj;", "activeTypeCfg", "L", "Lcom/tencent/mobileqq/zootopia/api/e;", "Luv4/aa;", "cb", "i0", "l0", "K", "J", AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, "c0", "b0", ExifInterface.LATITUDE_SOUTH, "Luv4/az;", "targetItem", BdhLogUtil.LogTag.Tag_Req, "g0", "h0", "O", "setData", "N", "getPosition", "position", "setPosition", "Landroid/view/View;", "getView", "Lcom/tencent/sqshow/zootopia/view/pull2refresh/androidx/XPullToRefreshViewV2;", "recyclerView", "isMachineRefresh", "e", "reqType", "b", "endOfRefresh", tl.h.F, "a", "c", "f", "P", "Lcom/tencent/sqshow/zootopia/nativeui/view/page/b;", "l", "setDataChangedListener", "Landroid/content/res/Configuration;", "newConfig", "onConfigurationChanged", NodeProps.ON_ATTACHED_TO_WINDOW, NodeProps.ON_DETACHED_FROM_WINDOW, "Lcom/tencent/sqshow/zootopia/nativeui/data/j;", "d", "Lcom/tencent/sqshow/zootopia/nativeui/data/j;", "mChannel", "Ln74/bs;", "Ln74/bs;", "mBinding", "Lcom/tencent/sqshow/zootopia/nativeui/data/title/PortalStorePanelCategoryData;", "mData", "Lcom/tencent/sqshow/zootopia/nativeui/data/repo/PanelSubTitlePageDataRepo;", "Lcom/tencent/sqshow/zootopia/nativeui/data/repo/PanelSubTitlePageDataRepo;", "mItemDataController", "Lg94/a;", "i", "Lg94/a;", "mItemSizeHelper", "Ld94/g;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Ld94/g;", "mAdapter", BdhLogUtil.LogTag.Tag_Conn, "Lcom/tencent/mobileqq/zootopia/api/e;", "mRefreshCallback", "D", "mLoadMoreCallback", "E", "Z", "mPageIsShowing", UserInfo.SEX_FEMALE, "mOrderTypeChanged", "G", "mFilterTypeChanged", "Ljava/util/HashSet;", "Lkotlin/collections/HashSet;", "H", "Ljava/util/HashSet;", "mLocalCollectedItem", "I", "mPosition", "mCurrentSelectedPos", "Ljava/lang/String;", "mCurrentSelectedId", "mActiveSelectedPos", "mFirstSetData", "mDataChanged", "mCurrentSpan", "mCurrentOrderType", "Landroidx/lifecycle/Observer;", "Li94/a;", "Landroidx/lifecycle/Observer;", "mCollectObserver", "Lcom/tencent/sqshow/zootopia/nativeui/data/sort/d;", "mSortChangeObserver", "mItemBuySucceedObserver", "com/tencent/sqshow/zootopia/nativeui/view/page/PortalStorePanelCategoryPage$e", "Lcom/tencent/sqshow/zootopia/nativeui/view/page/PortalStorePanelCategoryPage$e;", "onThirdTitleItemSelectedListener", "com/tencent/sqshow/zootopia/nativeui/view/page/PortalStorePanelCategoryPage$h", "Lcom/tencent/sqshow/zootopia/nativeui/view/page/PortalStorePanelCategoryPage$h;", "updateCreationItemCallback", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;ILcom/tencent/sqshow/zootopia/nativeui/data/j;)V", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public final class PortalStorePanelCategoryPage extends FrameLayout implements a<String, PortalStorePanelCategoryData>, XPullToRefreshViewV2.c {

    /* renamed from: C, reason: from kotlin metadata */
    private com.tencent.mobileqq.zootopia.api.e<aa> mRefreshCallback;

    /* renamed from: D, reason: from kotlin metadata */
    private com.tencent.mobileqq.zootopia.api.e<aa> mLoadMoreCallback;

    /* renamed from: E, reason: from kotlin metadata */
    private boolean mPageIsShowing;

    /* renamed from: F, reason: from kotlin metadata */
    private boolean mOrderTypeChanged;

    /* renamed from: G, reason: from kotlin metadata */
    private boolean mFilterTypeChanged;

    /* renamed from: H, reason: from kotlin metadata */
    private HashSet<String> mLocalCollectedItem;

    /* renamed from: I, reason: from kotlin metadata */
    private int mPosition;

    /* renamed from: J, reason: from kotlin metadata */
    private int mCurrentSelectedPos;

    /* renamed from: K, reason: from kotlin metadata */
    private String mCurrentSelectedId;

    /* renamed from: L, reason: from kotlin metadata */
    private int mActiveSelectedPos;

    /* renamed from: M, reason: from kotlin metadata */
    private boolean mFirstSetData;

    /* renamed from: N, reason: from kotlin metadata */
    private boolean mDataChanged;

    /* renamed from: P, reason: from kotlin metadata */
    private int mCurrentSpan;

    /* renamed from: Q, reason: from kotlin metadata */
    private int mCurrentOrderType;

    /* renamed from: R, reason: from kotlin metadata */
    private final Observer<CollectInfo> mCollectObserver;

    /* renamed from: S, reason: from kotlin metadata */
    private final Observer<com.tencent.sqshow.zootopia.nativeui.data.sort.d> mSortChangeObserver;

    /* renamed from: T, reason: from kotlin metadata */
    private final Observer<Boolean> mItemBuySucceedObserver;

    /* renamed from: U, reason: from kotlin metadata */
    private final e onThirdTitleItemSelectedListener;

    /* renamed from: V, reason: from kotlin metadata */
    private final h updateCreationItemCallback;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private final com.tencent.sqshow.zootopia.nativeui.data.j mChannel;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private final bs mBinding;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private PortalStorePanelCategoryData mData;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private final PanelSubTitlePageDataRepo mItemDataController;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private final g94.a mItemSizeHelper;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private final d94.g mAdapter;

    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u001a\u0010\n\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016\u00a8\u0006\u000b"}, d2 = {"com/tencent/sqshow/zootopia/nativeui/view/page/PortalStorePanelCategoryPage$b", "Lcom/tencent/mobileqq/zootopia/api/e;", "Luv4/aa;", "result", "", "a", "", "error", "", "message", "onResultFailure", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes34.dex */
    public static final class b implements com.tencent.mobileqq.zootopia.api.e<aa> {

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ HashSet<String> f371931e;

        b(HashSet<String> hashSet) {
            this.f371931e = hashSet;
        }

        @Override // com.tencent.mobileqq.zootopia.api.e
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onResultSuccess(aa result) {
            Intrinsics.checkNotNullParameter(result, "result");
            if (PortalStorePanelCategoryPage.this.mOrderTypeChanged || PortalStorePanelCategoryPage.this.mFilterTypeChanged) {
                PortalStorePanelCategoryPage.this.mBinding.f418910e.D().setLoadMore(true);
            }
            PortalStorePanelCategoryPage.this.mOrderTypeChanged = false;
            PortalStorePanelCategoryPage.this.mFilterTypeChanged = false;
            PortalStorePanelCategoryPage.this.mDataChanged = false;
            com.tencent.mobileqq.zootopia.api.e eVar = PortalStorePanelCategoryPage.this.mRefreshCallback;
            if (eVar != null) {
                eVar.onResultSuccess(result);
            }
        }

        @Override // com.tencent.mobileqq.zootopia.api.e
        public void onResultFailure(int error, String message) {
            com.tencent.mobileqq.zootopia.api.e eVar = PortalStorePanelCategoryPage.this.mRefreshCallback;
            if (eVar != null) {
                eVar.onResultFailure(error, message);
            }
            PortalStorePanelCategoryPage.this.mLocalCollectedItem.addAll(this.f371931e);
        }
    }

    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u001a\u0010\n\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016\u00a8\u0006\u000b"}, d2 = {"com/tencent/sqshow/zootopia/nativeui/view/page/PortalStorePanelCategoryPage$c", "Lcom/tencent/mobileqq/zootopia/api/e;", "Luv4/aa;", "result", "", "a", "", "error", "", "message", "onResultFailure", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes34.dex */
    public static final class c implements com.tencent.mobileqq.zootopia.api.e<aa> {
        c() {
        }

        @Override // com.tencent.mobileqq.zootopia.api.e
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onResultSuccess(aa result) {
            Intrinsics.checkNotNullParameter(result, "result");
            boolean z16 = result.f440105c;
            bk[] bkVarArr = result.f440103a;
            QLog.i("PortalStorePanelCategoryPage_", 1, "mRefreshCallback onResultSuccess hasMore:" + z16 + ",list:" + (bkVarArr != null ? Integer.valueOf(bkVarArr.length) : null));
            PortalStorePanelCategoryPage.this.mBinding.f418910e.s(true);
            PortalStorePanelCategoryPage.this.mBinding.f418910e.F(true, result.f440105c);
        }

        @Override // com.tencent.mobileqq.zootopia.api.e
        public void onResultFailure(int error, String message) {
            QLog.i("PortalStorePanelCategoryPage_", 1, "mRefreshCallback onResultFailure error:" + error + ", message:" + message);
            PortalStorePanelCategoryPage.this.mBinding.f418910e.s(true);
            PortalStorePanelCategoryPage.this.mBinding.f418910e.F(true, false);
        }
    }

    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u001a\u0010\n\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016\u00a8\u0006\u000b"}, d2 = {"com/tencent/sqshow/zootopia/nativeui/view/page/PortalStorePanelCategoryPage$d", "Lcom/tencent/mobileqq/zootopia/api/e;", "Luv4/aa;", "result", "", "a", "", "error", "", "message", "onResultFailure", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes34.dex */
    public static final class d implements com.tencent.mobileqq.zootopia.api.e<aa> {
        d() {
        }

        @Override // com.tencent.mobileqq.zootopia.api.e
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onResultSuccess(aa result) {
            Intrinsics.checkNotNullParameter(result, "result");
            boolean z16 = result.f440105c;
            bk[] bkVarArr = result.f440103a;
            QLog.i("PortalStorePanelCategoryPage_", 1, "mLoadMoreCallback onResultSuccess hasMore:" + z16 + ",list:" + (bkVarArr != null ? Integer.valueOf(bkVarArr.length) : null));
            PortalStorePanelCategoryPage.this.mBinding.f418910e.F(true, result.f440105c);
        }

        @Override // com.tencent.mobileqq.zootopia.api.e
        public void onResultFailure(int error, String message) {
            QLog.i("PortalStorePanelCategoryPage_", 1, "mLoadMoreCallback onResultFailure error:" + error + ", message:" + message);
            PortalStorePanelCategoryPage.this.mBinding.f418910e.F(true, false);
        }
    }

    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/sqshow/zootopia/nativeui/view/page/PortalStorePanelCategoryPage$e", "Lcom/tencent/sqshow/zootopia/nativeui/view/title/PortalStorePanelThirdTitleView$a;", "", "index", "", "a", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes34.dex */
    public static final class e implements PortalStorePanelThirdTitleView.a {
        e() {
        }

        @Override // com.tencent.sqshow.zootopia.nativeui.view.title.PortalStorePanelThirdTitleView.a
        public void a(int index) {
            PortalStorePanelCategoryPage.this.mCurrentSelectedPos = index;
            PortalStorePanelCategoryPage.this.mChannel.S(PortalStorePanelCategoryPage.this.mCurrentSelectedPos);
            PortalStorePanelCategoryPage.this.mActiveSelectedPos = 0;
            if (Intrinsics.areEqual(PortalStorePanelCategoryPage.this.mData, new PortalStorePanelCategoryData(0, 0, 0, null, null, null, null, null, null, 511, null))) {
                return;
            }
            PortalStorePanelCategoryPage.this.mItemDataController.g(PortalStorePanelCategoryPage.this.mData.getCategoryCfg(), PortalStorePanelCategoryPage.this.mCurrentSelectedPos);
            PortalStorePanelCategoryPage.this.q0();
            PortalStorePanelCategoryPage.j0(PortalStorePanelCategoryPage.this, null, 1, null);
        }
    }

    @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0005"}, d2 = {"com/tencent/sqshow/zootopia/nativeui/view/page/PortalStorePanelCategoryPage$f", "Landroidx/recyclerview/widget/GridLayoutManager$SpanSizeLookup;", "", "position", "getSpanSize", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes34.dex */
    public static final class f extends GridLayoutManager.SpanSizeLookup {

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ int f371936b;

        f(int i3) {
            this.f371936b = i3;
        }

        @Override // androidx.recyclerview.widget.GridLayoutManager.SpanSizeLookup
        public int getSpanSize(int position) {
            if (PortalStorePanelCategoryPage.this.mAdapter.getItemViewType(position) == 4 || PortalStorePanelCategoryPage.this.mAdapter.getItemViewType(position) == 5) {
                return this.f371936b;
            }
            return 1;
        }
    }

    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016\u00a8\u0006\b"}, d2 = {"com/tencent/sqshow/zootopia/nativeui/view/page/PortalStorePanelCategoryPage$g", "Landroidx/recyclerview/widget/RecyclerView$OnScrollListener;", "Landroidx/recyclerview/widget/RecyclerView;", "recyclerView", "", "newState", "", "onScrollStateChanged", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes34.dex */
    public static final class g extends RecyclerView.OnScrollListener {
        g() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
            Intrinsics.checkNotNullParameter(recyclerView, "recyclerView");
            if (newState == 0) {
                VideoReport.traversePage(PortalStorePanelCategoryPage.this.mBinding.getMRv());
            }
        }
    }

    @Metadata(d1 = {"\u0000\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001\u00a8\u0006\u0002"}, d2 = {"com/tencent/sqshow/zootopia/nativeui/view/page/PortalStorePanelCategoryPage$h", "Ld94/b;", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes34.dex */
    public static final class h implements d94.b {
        h() {
        }
    }

    private final void J() {
        com.tencent.sqshow.zootopia.nativeui.data.c.f370920a.r().a().removeObserver(this.mItemBuySucceedObserver);
        g94.b.f401562a.g().removeObserver(this.mCollectObserver);
        this.mChannel.getPanelSortData().e().removeObserver(this.mSortChangeObserver);
    }

    private final void K() {
        List<com.tencent.sqshow.zootopia.nativeui.data.repo.g> emptyList;
        d94.g gVar = this.mAdapter;
        emptyList = CollectionsKt__CollectionsKt.emptyList();
        gVar.v0(emptyList);
    }

    private final int L(bj activeTypeCfg) {
        int indexOf;
        bj[] bjVarArr = this.mData.getCategoryCfg().f440189g;
        Intrinsics.checkNotNullExpressionValue(bjVarArr, "mData.categoryCfg.types");
        indexOf = ArraysKt___ArraysKt.indexOf(bjVarArr, activeTypeCfg);
        if (indexOf == -1) {
            return 0;
        }
        return indexOf;
    }

    private final int M() {
        Object obj;
        Object obj2;
        String str = this.mData.getCategoryCfg().f440190h;
        Iterator<T> it = this.mData.getTypeList().iterator();
        while (true) {
            obj = null;
            if (!it.hasNext()) {
                obj2 = null;
                break;
            }
            obj2 = it.next();
            if (Intrinsics.areEqual(((PortalStorePanelTypeData) obj2).getStoreTypeCfg().f440349a, str)) {
                break;
            }
        }
        PortalStorePanelTypeData portalStorePanelTypeData = (PortalStorePanelTypeData) obj2;
        Iterator<T> it5 = this.mData.getTypeList().iterator();
        while (true) {
            if (!it5.hasNext()) {
                break;
            }
            Object next = it5.next();
            if (Intrinsics.areEqual(((PortalStorePanelTypeData) next).getStoreTypeCfg().f440349a, this.mCurrentSelectedId)) {
                obj = next;
                break;
            }
        }
        PortalStorePanelTypeData portalStorePanelTypeData2 = (PortalStorePanelTypeData) obj;
        if (portalStorePanelTypeData2 != null) {
            return this.mData.getTypeList().indexOf(portalStorePanelTypeData2);
        }
        if (portalStorePanelTypeData == null) {
            return 0;
        }
        return this.mData.getTypeList().indexOf(portalStorePanelTypeData);
    }

    private final int O() {
        List list;
        Object orNull;
        int[] iArr = this.mData.getCategoryCfg().f440194l;
        Intrinsics.checkNotNullExpressionValue(iArr, "mData.categoryCfg.orderTypes");
        list = ArraysKt___ArraysKt.toList(iArr);
        orNull = CollectionsKt___CollectionsKt.getOrNull(list, 0);
        Integer num = (Integer) orNull;
        if (num != null) {
            return num.intValue();
        }
        return 0;
    }

    private final String Q() {
        return "grand=" + this.mData.getGrandIndex() + ", parent:" + this.mData.getParentIndex() + ", self:" + this.mData.getSelfIndex();
    }

    private final void R(az targetItem) {
        this.mAdapter.w0(targetItem);
        if (this.mAdapter.getNUM_BACKGOURND_ICON() == 0) {
            AvatarPanelErrorView avatarPanelErrorView = this.mBinding.f418907b;
            Intrinsics.checkNotNullExpressionValue(avatarPanelErrorView, "mBinding.errorView");
            s0(avatarPanelErrorView, false);
        }
    }

    private final void S() {
        HashSet hashSet = new HashSet(this.mLocalCollectedItem);
        this.mLocalCollectedItem.clear();
        if (this.mOrderTypeChanged || this.mFilterTypeChanged || hashSet.size() > 0 || this.mDataChanged) {
            b bVar = new b(hashSet);
            K();
            l0(bVar);
        }
    }

    private final void T() {
        this.mBinding.f418912g.setVisibility(8);
    }

    private final void U() {
        this.mRefreshCallback = new c();
        this.mLoadMoreCallback = new d();
    }

    private final void V() {
        LifecycleOwner lifecycleOwner = this.mChannel.getLifecycleOwner();
        if (lifecycleOwner == null) {
            return;
        }
        if (b0()) {
            g94.b.f401562a.g().observe(lifecycleOwner, this.mCollectObserver);
        } else {
            g94.b.f401562a.g().removeObserver(this.mCollectObserver);
        }
        this.mChannel.getPanelSortData().e().observe(lifecycleOwner, this.mSortChangeObserver);
    }

    private final void W() {
        LifecycleOwner lifecycleOwner = this.mChannel.getLifecycleOwner();
        if (lifecycleOwner == null) {
            return;
        }
        this.mItemDataController.p().observe(lifecycleOwner, new Observer() { // from class: com.tencent.sqshow.zootopia.nativeui.view.page.i
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                PortalStorePanelCategoryPage.X(PortalStorePanelCategoryPage.this, (t) obj);
            }
        });
        MutableLiveData<PanelSubTitlePageDataRepo.Error> l3 = this.mItemDataController.l();
        final Function1<PanelSubTitlePageDataRepo.Error, Unit> function1 = new Function1<PanelSubTitlePageDataRepo.Error, Unit>() { // from class: com.tencent.sqshow.zootopia.nativeui.view.page.PortalStorePanelCategoryPage$initStaticObserver$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(PanelSubTitlePageDataRepo.Error error) {
                invoke2(error);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(PanelSubTitlePageDataRepo.Error error) {
                if (error == PanelSubTitlePageDataRepo.Error.REFRESH_ERROR) {
                    PortalStorePanelCategoryPage.this.mBinding.f418910e.s(true);
                    PortalStorePanelCategoryPage.this.mBinding.f418910e.F(true, false);
                    if (PortalStorePanelCategoryPage.this.mAdapter.getNUM_BACKGOURND_ICON() != 0) {
                        PortalStorePanelCategoryPage.this.r0();
                        return;
                    }
                    PortalStorePanelCategoryPage portalStorePanelCategoryPage = PortalStorePanelCategoryPage.this;
                    AvatarPanelErrorView avatarPanelErrorView = portalStorePanelCategoryPage.mBinding.f418907b;
                    Intrinsics.checkNotNullExpressionValue(avatarPanelErrorView, "mBinding.errorView");
                    portalStorePanelCategoryPage.s0(avatarPanelErrorView, true);
                    return;
                }
                PortalStorePanelCategoryPage.this.mBinding.f418910e.F(true, false);
                PortalStorePanelCategoryPage.this.r0();
            }
        };
        l3.observe(lifecycleOwner, new Observer() { // from class: com.tencent.sqshow.zootopia.nativeui.view.page.j
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                PortalStorePanelCategoryPage.Y(Function1.this, obj);
            }
        });
        com.tencent.sqshow.zootopia.nativeui.data.c.f370920a.r().a().observe(lifecycleOwner, this.mItemBuySucceedObserver);
        this.mChannel.G().observe(lifecycleOwner, new Observer() { // from class: com.tencent.sqshow.zootopia.nativeui.view.page.k
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                PortalStorePanelCategoryPage.Z(PortalStorePanelCategoryPage.this, (Boolean) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void X(PortalStorePanelCategoryPage this$0, t tVar) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        List<com.tencent.sqshow.zootopia.nativeui.data.repo.g> a16 = tVar.a();
        if (tVar.getOp() == 1) {
            this$0.mAdapter.v0(a16);
        } else {
            this$0.mAdapter.j0(a16);
        }
        this$0.o0(a16);
        if (this$0.mAdapter.getNUM_BACKGOURND_ICON() < 40) {
            this$0.mBinding.f418910e.D().setLoadMore(true);
        }
        if (this$0.mAdapter.getNUM_BACKGOURND_ICON() == 0) {
            AvatarPanelErrorView avatarPanelErrorView = this$0.mBinding.f418907b;
            Intrinsics.checkNotNullExpressionValue(avatarPanelErrorView, "mBinding.errorView");
            this$0.s0(avatarPanelErrorView, false);
        } else {
            this$0.r0();
        }
        VideoReport.traversePage(this$0.mBinding.getMRv());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Y(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Z(PortalStorePanelCategoryPage this$0, Boolean bool) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (!Intrinsics.areEqual(bool, Boolean.TRUE) && this$0.mActiveSelectedPos == 0) {
            this$0.T();
        } else {
            this$0.w0();
        }
    }

    private final void a0() {
        m0();
        RecyclerViewXWithHeaderFooter E = this.mBinding.f418910e.E();
        E.setClipChildren(false);
        this.mBinding.f418910e.setPullRefreshMode(1);
        this.mBinding.f418910e.G(true);
        this.mBinding.f418910e.setRefreshCallback(this);
        ZootopiaLoadMoreView I = this.mBinding.f418910e.I();
        if (I != null) {
            I.h("");
        }
        this.mBinding.f418910e.setHeaderNightStyle(QQTheme.isNowThemeIsNight());
        this.mBinding.f418910e.setHeaderBgRes(R.drawable.qui_common_bg_middle_light_bg);
        this.mBinding.f418910e.J();
        this.mBinding.f418913h.L(this.mChannel);
        E.getRecycledViewPool().setMaxRecycledViews(2, 15);
    }

    private final boolean b0() {
        return ha4.b.INSTANCE.a(this.mData.getCategoryCfg());
    }

    private final boolean c0() {
        return ha4.b.INSTANCE.b(this.mData.getCategoryCfg());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void d0(PortalStorePanelCategoryPage this$0, CollectInfo collectInfo) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (collectInfo.getType() == 2) {
            this$0.mLocalCollectedItem.remove(collectInfo.getItem().B);
            this$0.R(collectInfo.getItem());
            return;
        }
        this$0.mLocalCollectedItem.add(collectInfo.getItem().B);
        if (this$0.mPageIsShowing) {
            this$0.S();
        } else {
            this$0.mLocalCollectedItem.add(collectInfo.getItem().B);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void e0(PortalStorePanelCategoryPage this$0, Boolean bool) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (!Intrinsics.areEqual(bool, Boolean.TRUE) || Intrinsics.areEqual(this$0.mData, new PortalStorePanelCategoryData(0, 0, 0, null, null, null, null, null, null, 511, null))) {
            return;
        }
        this$0.i0(this$0.mRefreshCallback);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void f0(PortalStorePanelCategoryPage this$0, com.tencent.sqshow.zootopia.nativeui.data.sort.d dVar) {
        Object obj;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        int newOrderType = dVar.getNewOrderType();
        boolean z16 = true;
        boolean z17 = newOrderType != this$0.mCurrentOrderType;
        int[] iArr = this$0.mData.getCategoryCfg().f440195m;
        Intrinsics.checkNotNullExpressionValue(iArr, "mData.categoryCfg.filterTypes");
        if (!(iArr.length == 0)) {
            int length = this$0.mData.getCategoryCfg().f440195m.length;
            for (int i3 = 0; i3 < length; i3++) {
                Iterator<T> it = dVar.a().iterator();
                while (true) {
                    if (it.hasNext()) {
                        obj = it.next();
                        if (((ah) obj).f440138a == this$0.mData.getCategoryCfg().f440195m[i3]) {
                            break;
                        }
                    } else {
                        obj = null;
                        break;
                    }
                }
                if (obj != null) {
                    break;
                }
            }
        }
        z16 = false;
        this$0.mOrderTypeChanged = z17;
        this$0.mFilterTypeChanged = z16;
        if (this$0.mPageIsShowing) {
            this$0.mCurrentOrderType = newOrderType;
            this$0.S();
        }
    }

    private final void g0() {
        bj bjVar;
        bj[] bjVarArr = this.mData.getCategoryCfg().f440189g;
        Intrinsics.checkNotNullExpressionValue(bjVarArr, "mData.categoryCfg.types");
        int length = bjVarArr.length;
        int i3 = 0;
        while (true) {
            if (i3 >= length) {
                bjVar = null;
                break;
            }
            bjVar = bjVarArr[i3];
            if (Intrinsics.areEqual(bjVar.f440349a, this.mData.getCategoryCfg().f440190h)) {
                break;
            } else {
                i3++;
            }
        }
        if (bjVar == null) {
            return;
        }
        CameraKey cameraKey = new CameraKey(bjVar.f440360l, 0, 2, null);
        CameraKey k3 = this.mChannel.getCameraController().k();
        QLog.i("PortalStorePanelCategoryPage_", 1, "refreshCameraId cameraId:" + cameraKey + ", currentCameraId:" + k3);
        if (!cameraKey.c() || Intrinsics.areEqual(cameraKey, k3)) {
            return;
        }
        com.tencent.sqshow.zootopia.nativeui.ue.e.q(this.mChannel.getCameraController(), cameraKey, "refreshCameraId", false, 4, null);
    }

    private final void h0() {
        int O = O();
        this.mOrderTypeChanged = O != this.mCurrentOrderType;
        this.mCurrentOrderType = O;
        this.mChannel.getPanelSortData().f(Integer.valueOf(this.mCurrentOrderType));
    }

    private final void i0(com.tencent.mobileqq.zootopia.api.e<aa> cb5) {
        if (this.mPageIsShowing) {
            l0(cb5);
        } else {
            this.mDataChanged = true;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:12:0x003d, code lost:
    
        if (r1.f440192j == true) goto L17;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final void k0() {
        Object obj;
        boolean z16;
        String str = this.mData.getCategoryCfg().f440190h;
        Iterator<T> it = this.mData.getTypeList().iterator();
        while (true) {
            if (!it.hasNext()) {
                obj = null;
                break;
            } else {
                obj = it.next();
                if (Intrinsics.areEqual(((PortalStorePanelTypeData) obj).getStoreTypeCfg().f440349a, str)) {
                    break;
                }
            }
        }
        PortalStorePanelTypeData portalStorePanelTypeData = (PortalStorePanelTypeData) obj;
        if (portalStorePanelTypeData != null && (r1 = portalStorePanelTypeData.getCategoryCfg()) != null) {
            z16 = true;
        }
        z16 = false;
        if (z16) {
            this.mBinding.f418912g.setVisibility(8);
            return;
        }
        this.mBinding.f418913h.j(this.mChannel.getLifecycleOwner());
        this.mBinding.f418913h.setTitleData(this.mData.getTypeList(), M());
        bs bsVar = this.mBinding;
        PortalStorePanelThirdTitleView portalStorePanelThirdTitleView = bsVar.f418913h;
        HorizontalScrollView horizontalScrollView = bsVar.f418912g;
        Intrinsics.checkNotNullExpressionValue(horizontalScrollView, "mBinding.thirdTitleScrollview");
        portalStorePanelThirdTitleView.k(horizontalScrollView, 0);
        this.mBinding.f418913h.setOnItemSelectedListener(this.onThirdTitleItemSelectedListener);
    }

    private final void l0(com.tencent.mobileqq.zootopia.api.e<aa> cb5) {
        if (this.mAdapter.getNUM_BACKGOURND_ICON() == 0) {
            v0();
        }
        this.mBinding.f418910e.G(true);
        this.mBinding.f418910e.F(true, true);
        this.mItemDataController.s(cb5);
    }

    private final void m0() {
        this.mItemSizeHelper.r();
        int i3 = this.mItemSizeHelper.getCom.google.android.exoplayer2.text.ttml.TtmlNode.TAG_SPAN java.lang.String();
        int i16 = this.mCurrentSpan;
        if (i3 != i16 || i16 == 0) {
            RecyclerViewXWithHeaderFooter E = this.mBinding.f418910e.E();
            GridLayoutManager gridLayoutManager = new GridLayoutManager(getContext(), i3);
            gridLayoutManager.setOrientation(1);
            gridLayoutManager.setSpanSizeLookup(new f(i3));
            E.setLayoutManager(gridLayoutManager);
            E.setAdapter(this.mAdapter);
            E.addOnScrollListener(new g());
            E.setRecyclerListener(new RecyclerView.RecyclerListener() { // from class: com.tencent.sqshow.zootopia.nativeui.view.page.e
                @Override // androidx.recyclerview.widget.RecyclerView.RecyclerListener
                public final void onViewRecycled(RecyclerView.ViewHolder viewHolder) {
                    PortalStorePanelCategoryPage.n0(PortalStorePanelCategoryPage.this, viewHolder);
                }
            });
            this.mCurrentSpan = i3;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void n0(PortalStorePanelCategoryPage this$0, RecyclerView.ViewHolder holder) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(holder, "holder");
        BaseAvatarPanelItemViewHolder baseAvatarPanelItemViewHolder = holder instanceof BaseAvatarPanelItemViewHolder ? (BaseAvatarPanelItemViewHolder) holder : null;
        if (baseAvatarPanelItemViewHolder != null) {
            this$0.mAdapter.onViewRecycled(baseAvatarPanelItemViewHolder);
        }
    }

    private final void o0(List<com.tencent.sqshow.zootopia.nativeui.data.repo.g> data) {
        az azVar;
        int i3;
        ArrayList arrayList = new ArrayList();
        Iterator<T> it = data.iterator();
        while (it.hasNext()) {
            bk storeTypeItem = ((com.tencent.sqshow.zootopia.nativeui.data.repo.g) it.next()).getStoreTypeItem();
            if (storeTypeItem != null && (azVar = storeTypeItem.f440366b) != null && (i3 = azVar.D) > 0) {
                arrayList.add(Integer.valueOf(i3));
            }
        }
        if (arrayList.isEmpty()) {
            QLog.i("PortalStorePanelCategoryPage_", 1, "id list is empty, return");
            return;
        }
        ZPlanRedDotManager zPlanRedDotManager = ZPlanRedDotManager.f373437a;
        Object[] array = arrayList.toArray(new Integer[0]);
        Intrinsics.checkNotNull(array, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
        zPlanRedDotManager.t((Integer[]) array, true);
    }

    private final void p0(String tabId) {
        this.mAdapter.y0(tabId);
        d94.c cVar = d94.c.f393249a;
        cVar.b();
        if (Intrinsics.areEqual(this.mAdapter.getCurrentTabId(), com.tencent.sqshow.zootopia.nativeui.adapter.holder.j.f370868a.b())) {
            cVar.a(this.updateCreationItemCallback);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void q0() {
        bj[] bjVarArr = this.mData.getCategoryCfg().f440189g;
        boolean z16 = true;
        if (bjVarArr != null) {
            if (!(bjVarArr.length == 0)) {
                z16 = false;
            }
        }
        if (z16) {
            return;
        }
        int length = bjVarArr.length;
        int i3 = this.mCurrentSelectedPos;
        if (length <= i3) {
            return;
        }
        String str = bjVarArr[i3].f440349a;
        Intrinsics.checkNotNullExpressionValue(str, "typeCfgList[mCurrentSelectedPos].id");
        p0(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void r0() {
        this.mBinding.f418910e.setVisibility(0);
        this.mBinding.f418907b.setVisibility(8);
        this.mBinding.f418908c.setVisibility(8);
        this.mBinding.f418909d.g();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void s0(AvatarPanelErrorView errorView, boolean isFirstRequestError) {
        Object orNull;
        bj storeTypeCfg;
        this.mBinding.f418907b.setVisibility(0);
        this.mBinding.f418910e.setVisibility(8);
        this.mBinding.f418908c.setVisibility(8);
        this.mBinding.f418909d.g();
        if (isFirstRequestError) {
            errorView.setNetErrorVisibility(true, 5);
            String string = getContext().getResources().getString(R.string.xrf);
            Intrinsics.checkNotNullExpressionValue(string, "context.resources.getStr\u2026ui_shop_empty_fail_title)");
            errorView.f(string);
            String string2 = getContext().getResources().getString(R.string.xre);
            Intrinsics.checkNotNullExpressionValue(string2, "context.resources.getStr\u2026eui_shop_empty_fail_desc)");
            errorView.b(string2);
            String string3 = getContext().getResources().getString(R.string.xrd);
            Intrinsics.checkNotNullExpressionValue(string3, "context.resources.getStr\u2026i_shop_empty_fail_button)");
            errorView.setRetryButton(string3, new View.OnClickListener() { // from class: com.tencent.sqshow.zootopia.nativeui.view.page.l
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    PortalStorePanelCategoryPage.t0(PortalStorePanelCategoryPage.this, view);
                }
            });
            return;
        }
        if (c0()) {
            errorView.setNetErrorVisibility(true, 16);
            String string4 = getContext().getResources().getString(R.string.xri);
            Intrinsics.checkNotNullExpressionValue(string4, "context.resources.getStr\u2026veui_shop_empty_my_title)");
            errorView.f(string4);
            String string5 = getContext().getResources().getString(R.string.xrh);
            Intrinsics.checkNotNullExpressionValue(string5, "context.resources.getStr\u2026iveui_shop_empty_my_desc)");
            errorView.b(string5);
            orNull = CollectionsKt___CollectionsKt.getOrNull(this.mData.getTypeList(), M());
            PortalStorePanelTypeData portalStorePanelTypeData = (PortalStorePanelTypeData) orNull;
            final bh bhVar = (portalStorePanelTypeData == null || (storeTypeCfg = portalStorePanelTypeData.getStoreTypeCfg()) == null) ? null : storeTypeCfg.f440361m;
            if (bhVar != null) {
                String string6 = getContext().getResources().getString(R.string.xrg);
                Intrinsics.checkNotNullExpressionValue(string6, "context.resources.getStr\u2026eui_shop_empty_my_button)");
                errorView.setRetryButton(string6, new View.OnClickListener() { // from class: com.tencent.sqshow.zootopia.nativeui.view.page.m
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        PortalStorePanelCategoryPage.u0(PortalStorePanelCategoryPage.this, bhVar, view);
                    }
                });
                this.mChannel.getReporter().getMReporter().g(errorView.c(), "em_zplan_shop_btn", (r16 & 4) != 0 ? null : null, (r16 & 8) != 0, (r16 & 16) != 0 ? null : null, (r16 & 32) != 0 ? false : false);
                return;
            }
            errorView.setRetryButtonVisibility(false);
            return;
        }
        if (b0()) {
            errorView.setNetErrorVisibility(true, 11);
            String string7 = getContext().getResources().getString(R.string.xra);
            Intrinsics.checkNotNullExpressionValue(string7, "context.resources.getStr\u2026shop_empty_collect_title)");
            errorView.f(string7);
            String string8 = getContext().getResources().getString(R.string.xr_);
            Intrinsics.checkNotNullExpressionValue(string8, "context.resources.getStr\u2026_shop_empty_collect_desc)");
            errorView.b(string8);
            errorView.setRetryButtonVisibility(false);
            return;
        }
        errorView.setNetErrorVisibility(true, 16);
        String string9 = getContext().getResources().getString(R.string.xrc);
        Intrinsics.checkNotNullExpressionValue(string9, "context.resources.getStr\u2026shop_empty_default_title)");
        errorView.f(string9);
        String string10 = getContext().getResources().getString(R.string.xrb);
        Intrinsics.checkNotNullExpressionValue(string10, "context.resources.getStr\u2026_shop_empty_default_desc)");
        errorView.b(string10);
        errorView.setRetryButtonVisibility(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void t0(PortalStorePanelCategoryPage this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.v0();
        this$0.mBinding.f418910e.G(false);
        this$0.mBinding.f418910e.G(true);
        this$0.e(this$0.mBinding.f418910e, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void u0(PortalStorePanelCategoryPage this$0, bh bhVar, View it) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        ZplanViewReportHelper mReporter = this$0.mChannel.getReporter().getMReporter();
        Intrinsics.checkNotNullExpressionValue(it, "it");
        ZplanViewReportHelper.f(mReporter, it, "em_zplan_shop_btn", null, 4, null);
        b94.e O = this$0.mChannel.O();
        if (O != null) {
            String str = bhVar.f440341a;
            Intrinsics.checkNotNullExpressionValue(str, "jumpData.groupId");
            String str2 = bhVar.f440342b;
            Intrinsics.checkNotNullExpressionValue(str2, "jumpData.categoryId");
            String str3 = bhVar.f440343c;
            Intrinsics.checkNotNullExpressionValue(str3, "jumpData.typeId");
            O.r9(str, str2, str3);
        }
    }

    private final void v0() {
        this.mBinding.f418907b.setVisibility(8);
        this.mBinding.f418910e.setVisibility(8);
        this.mBinding.f418908c.setVisibility(0);
        this.mBinding.f418909d.f();
    }

    private final void w0() {
        this.mBinding.f418912g.setVisibility(0);
    }

    @Override // com.tencent.sqshow.zootopia.nativeui.view.page.a
    /* renamed from: N, reason: from getter */
    public PortalStorePanelCategoryData getMData() {
        return this.mData;
    }

    public final List<com.tencent.sqshow.zootopia.nativeui.data.repo.g> P() {
        return this.mAdapter.getData();
    }

    @Override // com.tencent.sqshow.zootopia.nativeui.view.page.a
    public void a() {
        g0();
    }

    @Override // com.tencent.sqshow.zootopia.view.pull2refresh.androidx.XPullToRefreshViewV2.c
    public void b(XPullToRefreshViewV2 recyclerView, int reqType) {
        this.mItemDataController.u(this.mLoadMoreCallback);
    }

    @Override // com.tencent.sqshow.zootopia.nativeui.view.page.a
    public void c() {
        String Q = Q();
        if (this.mPageIsShowing) {
            QLog.w("PortalStorePanelCategoryPage_", 1, "pageShow " + Q + ", filtered!");
            return;
        }
        this.mChannel.h().setValue(this.mData);
        this.mChannel.S(this.mCurrentSelectedPos);
        this.mPageIsShowing = true;
        QLog.i("PortalStorePanelCategoryPage_", 1, "pageShow " + Q);
        h0();
        S();
        b94.e O = this.mChannel.O();
        if (O != null && O.getMMainPanelIsShow()) {
            g0();
        }
        this.mChannel.G().postValue(Boolean.FALSE);
    }

    @Override // com.tencent.sqshow.zootopia.nativeui.view.page.a
    public void d() {
        a.C9831a.d(this);
    }

    @Override // com.tencent.sqshow.zootopia.view.pull2refresh.androidx.XPullToRefreshViewV2.c
    public void e(XPullToRefreshViewV2 recyclerView, boolean isMachineRefresh) {
        l0(this.mRefreshCallback);
    }

    @Override // com.tencent.sqshow.zootopia.nativeui.view.page.a
    public void g() {
        a.C9831a.a(this);
    }

    @Override // com.tencent.sqshow.zootopia.nativeui.view.page.a
    /* renamed from: getPosition, reason: from getter */
    public int getMPosition() {
        return this.mPosition;
    }

    @Override // com.tencent.sqshow.zootopia.nativeui.view.page.a
    public void h() {
        this.mAdapter.destroy();
        J();
        d94.c.f393249a.b();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        m0();
        requestLayout();
    }

    @Override // android.view.View
    protected void onConfigurationChanged(Configuration newConfig) {
        m0();
        this.mAdapter.notifyDataSetChanged();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.mAdapter.q0();
    }

    public final void setDataChangedListener(com.tencent.sqshow.zootopia.nativeui.view.page.b l3) {
        Intrinsics.checkNotNullParameter(l3, "l");
        this.mAdapter.z0(l3);
    }

    @Override // com.tencent.sqshow.zootopia.nativeui.view.page.a
    public void setPosition(int position) {
        this.mPosition = position;
    }

    @Override // com.tencent.sqshow.zootopia.nativeui.view.page.a
    public void f() {
        this.mPageIsShowing = false;
        this.mActiveSelectedPos = 0;
        this.mAdapter.q0();
    }

    @Override // com.tencent.sqshow.zootopia.nativeui.view.page.a
    public void setData(PortalStorePanelCategoryData data) {
        bj bjVar;
        Object orNull;
        Intrinsics.checkNotNullParameter(data, "data");
        if (Intrinsics.areEqual(this.mData, data)) {
            return;
        }
        this.mAdapter.x0(data);
        this.mData = data;
        V();
        bj[] bjVarArr = data.getCategoryCfg().f440189g;
        Intrinsics.checkNotNullExpressionValue(bjVarArr, "data.categoryCfg.types");
        int length = bjVarArr.length;
        int i3 = 0;
        while (true) {
            if (i3 >= length) {
                bjVar = null;
                break;
            }
            bjVar = bjVarArr[i3];
            if (Intrinsics.areEqual(bjVar.f440349a, data.getCategoryCfg().f440190h)) {
                break;
            } else {
                i3++;
            }
        }
        if (bjVar == null) {
            bj[] bjVarArr2 = data.getCategoryCfg().f440189g;
            Intrinsics.checkNotNullExpressionValue(bjVarArr2, "data.categoryCfg.types");
            orNull = ArraysKt___ArraysKt.getOrNull(bjVarArr2, this.mCurrentSelectedPos);
            bjVar = (bj) orNull;
            if (bjVar == null) {
                return;
            }
        }
        this.mActiveSelectedPos = L(bjVar);
        this.mItemDataController.h(bjVar);
        String str = bjVar.f440349a;
        Intrinsics.checkNotNullExpressionValue(str, "activeTypeCfg.id");
        p0(str);
        this.mItemSizeHelper.s(bjVar.f440362n == 1);
        m0();
        k0();
        K();
        j0(this, null, 1, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    static /* synthetic */ void j0(PortalStorePanelCategoryPage portalStorePanelCategoryPage, com.tencent.mobileqq.zootopia.api.e eVar, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            eVar = null;
        }
        portalStorePanelCategoryPage.i0(eVar);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PortalStorePanelCategoryPage(Context context, AttributeSet attributeSet, int i3, com.tencent.sqshow.zootopia.nativeui.data.j mChannel) {
        super(context, attributeSet, i3);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(mChannel, "mChannel");
        this.mChannel = mChannel;
        this.mData = new PortalStorePanelCategoryData(0, 0, 0, null, null, null, null, null, null, 511, null);
        PanelSubTitlePageDataRepo panelSubTitlePageDataRepo = new PanelSubTitlePageDataRepo(mChannel);
        this.mItemDataController = panelSubTitlePageDataRepo;
        g94.a aVar = new g94.a(context, mChannel.getOrientationMode());
        this.mItemSizeHelper = aVar;
        this.mAdapter = new d94.g(context, mChannel, panelSubTitlePageDataRepo, aVar);
        this.mLocalCollectedItem = new HashSet<>();
        this.mPosition = -1;
        this.mCurrentSelectedId = "";
        this.mFirstSetData = true;
        this.mCurrentOrderType = O();
        this.mCollectObserver = new Observer() { // from class: com.tencent.sqshow.zootopia.nativeui.view.page.f
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                PortalStorePanelCategoryPage.d0(PortalStorePanelCategoryPage.this, (CollectInfo) obj);
            }
        };
        this.mSortChangeObserver = new Observer() { // from class: com.tencent.sqshow.zootopia.nativeui.view.page.g
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                PortalStorePanelCategoryPage.f0(PortalStorePanelCategoryPage.this, (com.tencent.sqshow.zootopia.nativeui.data.sort.d) obj);
            }
        };
        this.mItemBuySucceedObserver = new Observer() { // from class: com.tencent.sqshow.zootopia.nativeui.view.page.h
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                PortalStorePanelCategoryPage.e0(PortalStorePanelCategoryPage.this, (Boolean) obj);
            }
        };
        this.onThirdTitleItemSelectedListener = new e();
        this.updateCreationItemCallback = new h();
        bs f16 = bs.f(LayoutInflater.from(context), this);
        Intrinsics.checkNotNullExpressionValue(f16, "inflate(LayoutInflater.from(context), this)");
        this.mBinding = f16;
        U();
        a0();
        W();
        setMotionEventSplittingEnabled(false);
    }

    @Override // com.tencent.sqshow.zootopia.view.pull2refresh.androidx.XPullToRefreshViewV2.c
    public void endOfRefresh() {
    }

    @Override // com.tencent.sqshow.zootopia.nativeui.view.page.a
    public View getView() {
        return this;
    }
}

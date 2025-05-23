package com.tencent.mobileqq.cardcontainer.framework;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Rect;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;
import androidx.core.content.ContextCompat;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerViewClearKt;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.cardcontainer.api.ICardContainerDataApi;
import com.tencent.mobileqq.cardcontainer.data.ContainerData;
import com.tencent.mobileqq.cardcontainer.data.ContainerDataUtil;
import com.tencent.mobileqq.cardcontainer.framework.CardsAdapter;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.vaswebviewplugin.VasWebviewConstants;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import com.tencent.qphone.base.util.QLog;
import com.tencent.sqshow.zootopia.publish.ZPlanPublishSource;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Triple;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u00b4\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u0000 k2\u00020\u00012\u00020\u00022\u00020\u0003:\u0003\u0018\u001f\u001bB'\u0012\u0006\u0010h\u001a\u00020g\u0012\u0006\u0010\"\u001a\u00020 \u0012\u0006\u0010&\u001a\u00020#\u0012\u0006\u0010*\u001a\u00020'\u00a2\u0006\u0004\bi\u0010jJ\b\u0010\u0005\u001a\u00020\u0004H\u0002J\b\u0010\u0006\u001a\u00020\u0004H\u0002J\b\u0010\u0007\u001a\u00020\u0004H\u0002J\b\u0010\t\u001a\u00020\bH\u0002J\b\u0010\n\u001a\u00020\u0004H\u0002J\b\u0010\u000b\u001a\u00020\u0004H\u0002J\u0014\u0010\u000f\u001a\u00020\u00042\n\u0010\u000e\u001a\u00060\fR\u00020\rH\u0002J\b\u0010\u0010\u001a\u00020\u0004H\u0016J\u0010\u0010\u0012\u001a\u00020\u00042\u0006\u0010\u0011\u001a\u00020\bH\u0016J\u0012\u0010\u0015\u001a\u00020\b2\b\u0010\u0014\u001a\u0004\u0018\u00010\u0013H\u0016J\u0010\u0010\u0018\u001a\u00020\u00042\u0006\u0010\u0017\u001a\u00020\u0016H\u0016J\u0018\u0010\u001b\u001a\u00020\u00042\u0006\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u001a\u001a\u00020\u0019H\u0016J\b\u0010\u001d\u001a\u00020\u001cH\u0016J\b\u0010\u001e\u001a\u00020\u0004H\u0017J\b\u0010\u001f\u001a\u00020\u0004H\u0016R\u0014\u0010\"\u001a\u00020 8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001b\u0010!R\u0014\u0010&\u001a\u00020#8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b$\u0010%R\u0014\u0010*\u001a\u00020'8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b(\u0010)R\u0014\u0010.\u001a\u00020+8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b,\u0010-R\u0014\u00102\u001a\u00020/8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b0\u00101R\u0014\u00105\u001a\u00020\r8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b3\u00104R\u0014\u00108\u001a\u00020\u00168\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b6\u00107R\u0014\u0010:\u001a\u00020\u00168\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b9\u00107R\u0014\u0010<\u001a\u00020\u00168\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b;\u00107R\u0014\u0010>\u001a\u00020\u00168\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b=\u00107R\u0016\u0010A\u001a\u00020\b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b?\u0010@RJ\u0010G\u001a6\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\u0019\u0012\u0004\u0012\u00020\b0C0Bj\u001a\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\u0019\u0012\u0004\u0012\u00020\b0C`D8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bE\u0010FR\"\u0010L\u001a\u00020\b8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b7\u0010@\u001a\u0004\bH\u0010I\"\u0004\bJ\u0010KR$\u0010T\u001a\u0004\u0018\u00010M8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bN\u0010O\u001a\u0004\bP\u0010Q\"\u0004\bR\u0010SR$\u0010\\\u001a\u0004\u0018\u00010U8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bV\u0010W\u001a\u0004\bX\u0010Y\"\u0004\bZ\u0010[R$\u0010b\u001a\u0012\u0012\u0004\u0012\u00020^0]j\b\u0012\u0004\u0012\u00020^`_8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b`\u0010aR\u0014\u0010f\u001a\u00020c8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bd\u0010e\u00a8\u0006l"}, d2 = {"Lcom/tencent/mobileqq/cardcontainer/framework/CardContainerView;", "Landroid/widget/FrameLayout;", "Lcom/tencent/mobileqq/cardcontainer/framework/l;", "Lcom/tencent/mobileqq/cardcontainer/i;", "", "t", "r", "w", "", HippyTKDListViewAdapter.X, "o", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "Lcom/tencent/mobileqq/cardcontainer/framework/CardsAdapter$b;", "Lcom/tencent/mobileqq/cardcontainer/framework/CardsAdapter;", "viewHolder", "v", "onResume", "fromScroll", "a", "Landroid/view/MotionEvent;", "ev", NodeProps.ON_INTERCEPT_TOUCH_EVENT, "", "position", "b", "", ZPlanPublishSource.FROM_SCHEME, "d", "Landroid/view/View;", "getView", "refresh", "c", "Lcom/tencent/mobileqq/cardcontainer/g;", "Lcom/tencent/mobileqq/cardcontainer/g;", "cardsViewModel", "Landroidx/lifecycle/LifecycleOwner;", "e", "Landroidx/lifecycle/LifecycleOwner;", "lifecycleOwner", "Lcom/tencent/mobileqq/cardcontainer/j;", "f", "Lcom/tencent/mobileqq/cardcontainer/j;", "daTongReportDelegate", "Lcom/tencent/mobileqq/cardcontainer/framework/j;", tl.h.F, "Lcom/tencent/mobileqq/cardcontainer/framework/j;", "cardReportHelper", "Landroidx/recyclerview/widget/RecyclerView;", "i", "Landroidx/recyclerview/widget/RecyclerView;", "recyclerView", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lcom/tencent/mobileqq/cardcontainer/framework/CardsAdapter;", "adapter", BdhLogUtil.LogTag.Tag_Conn, "I", "itemMargin", "D", "horizontalPadding", "E", "itemReserveSpace", UserInfo.SEX_FEMALE, "firstItemMargin", "G", "Z", "needRefreshView", "Ljava/util/ArrayList;", "Lkotlin/Triple;", "Lkotlin/collections/ArrayList;", "H", "Ljava/util/ArrayList;", "mDeleteList", "u", "()Z", "setPause", "(Z)V", "isPause", "Lcom/tencent/mobileqq/cardcontainer/h;", "J", "Lcom/tencent/mobileqq/cardcontainer/h;", "p", "()Lcom/tencent/mobileqq/cardcontainer/h;", "setListener", "(Lcom/tencent/mobileqq/cardcontainer/h;)V", "listener", "Lcom/tencent/mobileqq/cardcontainer/k;", "K", "Lcom/tencent/mobileqq/cardcontainer/k;", "getParentScrollHelper", "()Lcom/tencent/mobileqq/cardcontainer/k;", "setParentScrollHelper", "(Lcom/tencent/mobileqq/cardcontainer/k;)V", "parentScrollHelper", "Ljava/util/HashSet;", "", "Lkotlin/collections/HashSet;", "L", "Ljava/util/HashSet;", "visibleItemIdSet", "Ljava/lang/Runnable;", "M", "Ljava/lang/Runnable;", "checkItemExposureRunnable", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;Lcom/tencent/mobileqq/cardcontainer/g;Landroidx/lifecycle/LifecycleOwner;Lcom/tencent/mobileqq/cardcontainer/j;)V", "N", "cardcontainer_impl_release"}, k = 1, mv = {1, 7, 1})
@SuppressLint({"ViewConstructor"})
/* loaded from: classes11.dex */
public final class CardContainerView extends FrameLayout implements l, com.tencent.mobileqq.cardcontainer.i {
    static IPatchRedirector $redirector_;

    /* renamed from: N, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: C, reason: from kotlin metadata */
    private final int itemMargin;

    /* renamed from: D, reason: from kotlin metadata */
    private final int horizontalPadding;

    /* renamed from: E, reason: from kotlin metadata */
    private final int itemReserveSpace;

    /* renamed from: F, reason: from kotlin metadata */
    private final int firstItemMargin;

    /* renamed from: G, reason: from kotlin metadata */
    private boolean needRefreshView;

    /* renamed from: H, reason: from kotlin metadata */
    @NotNull
    private ArrayList<Triple<Integer, String, Boolean>> mDeleteList;

    /* renamed from: I, reason: from kotlin metadata */
    private boolean isPause;

    /* renamed from: J, reason: from kotlin metadata */
    @Nullable
    private com.tencent.mobileqq.cardcontainer.h listener;

    /* renamed from: K, reason: from kotlin metadata */
    @Nullable
    private com.tencent.mobileqq.cardcontainer.k parentScrollHelper;

    /* renamed from: L, reason: from kotlin metadata */
    @NotNull
    private final HashSet<Long> visibleItemIdSet;

    /* renamed from: M, reason: from kotlin metadata */
    @NotNull
    private final Runnable checkItemExposureRunnable;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final com.tencent.mobileqq.cardcontainer.g cardsViewModel;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final LifecycleOwner lifecycleOwner;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final com.tencent.mobileqq.cardcontainer.j daTongReportDelegate;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final j cardReportHelper;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final RecyclerView recyclerView;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final CardsAdapter adapter;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016\u00a8\u0006\b"}, d2 = {"com/tencent/mobileqq/cardcontainer/framework/CardContainerView$a", "Landroidx/recyclerview/widget/RecyclerView$OnScrollListener;", "Landroidx/recyclerview/widget/RecyclerView;", "recyclerView", "", "newState", "", "onScrollStateChanged", "cardcontainer_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes11.dex */
    public static final class a extends RecyclerView.OnScrollListener {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) CardContainerView.this);
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(@NotNull RecyclerView recyclerView, int newState) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) recyclerView, newState);
                return;
            }
            Intrinsics.checkNotNullParameter(recyclerView, "recyclerView");
            if (newState == 0) {
                CardContainerView.this.o();
            }
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000b\u0010\fR\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0005\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u0004R\u0014\u0010\u0006\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u0004R\u0014\u0010\u0007\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\u0004R\u0014\u0010\t\u001a\u00020\b8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\t\u0010\n\u00a8\u0006\r"}, d2 = {"Lcom/tencent/mobileqq/cardcontainer/framework/CardContainerView$b;", "", "", "CARD_END_MARGIN", "I", "CARD_VERTICAL_PADDING", "MARGIN_BETWEEN_CARDS", "PADDING_HORIZONTAL", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "cardcontainer_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.cardcontainer.framework.CardContainerView$b, reason: from kotlin metadata */
    /* loaded from: classes11.dex */
    public static final class Companion {
        static IPatchRedirector $redirector_;

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                return;
            }
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) defaultConstructorMarker);
        }

        Companion() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
                return;
            }
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\b\b\u0002\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u000f\u001a\u00020\f\u00a2\u0006\u0004\b\u0012\u0010\u0013J(\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0016R\u0014\u0010\u000f\u001a\u00020\f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\r\u0010\u000eR\u0014\u0010\u0011\u001a\u00020\f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\u000e\u00a8\u0006\u0014"}, d2 = {"Lcom/tencent/mobileqq/cardcontainer/framework/CardContainerView$c;", "Landroidx/recyclerview/widget/RecyclerView$ItemDecoration;", "Landroid/graphics/Rect;", "outRect", "Landroid/view/View;", "view", "Landroidx/recyclerview/widget/RecyclerView;", HippyNestedScrollComponent.PRIORITY_PARENT, "Landroidx/recyclerview/widget/RecyclerView$State;", "state", "", "getItemOffsets", "", "d", "I", "itemMargin", "e", "margin", "<init>", "(I)V", "cardcontainer_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes11.dex */
    private static final class c extends RecyclerView.ItemDecoration {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        private final int itemMargin;

        /* renamed from: e, reason: collision with root package name and from kotlin metadata */
        private final int margin;

        public c(int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, i3);
            } else {
                this.itemMargin = i3;
                this.margin = i3 / 2;
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
        public void getItemOffsets(@NotNull Rect outRect, @NotNull View view, @NotNull RecyclerView parent, @NotNull RecyclerView.State state) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, outRect, view, parent, state);
                return;
            }
            Intrinsics.checkNotNullParameter(outRect, "outRect");
            Intrinsics.checkNotNullParameter(view, "view");
            Intrinsics.checkNotNullParameter(parent, "parent");
            Intrinsics.checkNotNullParameter(state, "state");
            int i3 = this.margin;
            outRect.left = i3;
            outRect.right = i3;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    @Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0010\u000e\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\b\u0002\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0012\u001a\u00020\r\u00a2\u0006\u0004\b\u0013\u0010\u0014J\b\u0010\u0003\u001a\u00020\u0002H\u0016JD\u0010\u000b\u001a\u00020\u00022:\u0010\n\u001a6\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u00050\u0004j\u001a\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u0005`\tH\u0016R\"\u0010\u0011\u001a\u0010\u0012\f\u0012\n \u000e*\u0004\u0018\u00010\r0\r0\f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\u0010\u00a8\u0006\u0015"}, d2 = {"Lcom/tencent/mobileqq/cardcontainer/framework/CardContainerView$d;", "Lcom/tencent/mobileqq/cardcontainer/api/d;", "", "e", "Ljava/util/ArrayList;", "Lkotlin/Triple;", "", "", "", "Lkotlin/collections/ArrayList;", "deleteList", "f", "Ljava/lang/ref/WeakReference;", "Lcom/tencent/mobileqq/cardcontainer/framework/CardContainerView;", "kotlin.jvm.PlatformType", "a", "Ljava/lang/ref/WeakReference;", "cardContainerView", "owner", "<init>", "(Lcom/tencent/mobileqq/cardcontainer/framework/CardContainerView;)V", "cardcontainer_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes11.dex */
    public static final class d implements com.tencent.mobileqq.cardcontainer.api.d {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final WeakReference<CardContainerView> cardContainerView;

        public d(@NotNull CardContainerView owner) {
            Intrinsics.checkNotNullParameter(owner, "owner");
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) owner);
            } else {
                this.cardContainerView = new WeakReference<>(owner);
            }
        }

        @Override // com.tencent.mobileqq.cardcontainer.api.d
        public void e() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this);
                return;
            }
            CardContainerView cardContainerView = this.cardContainerView.get();
            if (cardContainerView != null) {
                QLog.i("CardContainer.CardContainerView", 1, "Updating data in CardContainerView, isPause = " + cardContainerView.u());
                if (cardContainerView.u()) {
                    cardContainerView.w();
                } else {
                    cardContainerView.needRefreshView = true;
                }
            }
        }

        @Override // com.tencent.mobileqq.cardcontainer.api.d
        public void f(@NotNull ArrayList<Triple<Integer, String, Boolean>> deleteList) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, (Object) deleteList);
                return;
            }
            Intrinsics.checkNotNullParameter(deleteList, "deleteList");
            CardContainerView cardContainerView = this.cardContainerView.get();
            if (cardContainerView != null) {
                QLog.i("CardContainer.CardContainerView", 1, "Delete data(" + deleteList.size() + ") in CardContainerView, isPause = " + cardContainerView.u());
                cardContainerView.mDeleteList.addAll(deleteList);
                if (cardContainerView.u()) {
                    cardContainerView.w();
                } else {
                    cardContainerView.needRefreshView = true;
                }
            }
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(VasWebviewConstants.REPORT_FROM_PROFILE_CARD_MALL_BUTON);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 17)) {
            redirector.redirect((short) 17);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CardContainerView(@NotNull Context context, @NotNull com.tencent.mobileqq.cardcontainer.g cardsViewModel, @NotNull LifecycleOwner lifecycleOwner, @NotNull com.tencent.mobileqq.cardcontainer.j daTongReportDelegate) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(cardsViewModel, "cardsViewModel");
        Intrinsics.checkNotNullParameter(lifecycleOwner, "lifecycleOwner");
        Intrinsics.checkNotNullParameter(daTongReportDelegate, "daTongReportDelegate");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, context, cardsViewModel, lifecycleOwner, daTongReportDelegate);
            return;
        }
        this.cardsViewModel = cardsViewModel;
        this.lifecycleOwner = lifecycleOwner;
        this.daTongReportDelegate = daTongReportDelegate;
        j jVar = new j(daTongReportDelegate);
        this.cardReportHelper = jVar;
        RecyclerView recyclerView = new RecyclerView(context);
        this.recyclerView = recyclerView;
        CardsAdapter cardsAdapter = new CardsAdapter(this, jVar);
        this.adapter = cardsAdapter;
        com.tencent.qqnt.base.utils.c cVar = com.tencent.qqnt.base.utils.c.f353052a;
        int b16 = cVar.b(8);
        this.itemMargin = b16;
        int b17 = cVar.b(12);
        this.horizontalPadding = b17;
        int b18 = cVar.b(16);
        this.itemReserveSpace = b18;
        this.firstItemMargin = (b16 / 2) + b17;
        this.mDeleteList = new ArrayList<>();
        this.visibleItemIdSet = new HashSet<>();
        this.checkItemExposureRunnable = new Runnable() { // from class: com.tencent.mobileqq.cardcontainer.framework.a
            @Override // java.lang.Runnable
            public final void run() {
                CardContainerView.n(CardContainerView.this);
            }
        };
        t();
        addView(recyclerView, new FrameLayout.LayoutParams(-1, -1));
        recyclerView.setAdapter(cardsAdapter);
        CardsLinearLayoutManager cardsLinearLayoutManager = new CardsLinearLayoutManager(context, 0, false);
        cardsLinearLayoutManager.s(b18);
        recyclerView.setLayoutManager(cardsLinearLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.addItemDecoration(new c(b16));
        recyclerView.setPadding(b17, 0, b17, 0);
        recyclerView.setClipToPadding(false);
        recyclerView.setOverScrollMode(1);
        recyclerView.addOnScrollListener(new a());
        r();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void n(CardContainerView this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.q();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void o() {
        this.recyclerView.removeCallbacks(this.checkItemExposureRunnable);
        this.recyclerView.postDelayed(this.checkItemExposureRunnable, 200L);
    }

    private final void q() {
        CardsAdapter.b bVar;
        com.tencent.mobileqq.cardcontainer.data.a m3;
        RecyclerView.LayoutManager layoutManager = this.recyclerView.getLayoutManager();
        Intrinsics.checkNotNull(layoutManager, "null cannot be cast to non-null type androidx.recyclerview.widget.LinearLayoutManager");
        LinearLayoutManager linearLayoutManager = (LinearLayoutManager) layoutManager;
        int findFirstVisibleItemPosition = linearLayoutManager.findFirstVisibleItemPosition();
        int findLastVisibleItemPosition = linearLayoutManager.findLastVisibleItemPosition();
        HashSet hashSet = new HashSet(this.visibleItemIdSet);
        this.visibleItemIdSet.clear();
        if (findFirstVisibleItemPosition > findLastVisibleItemPosition) {
            return;
        }
        while (true) {
            RecyclerView.ViewHolder findViewHolderForAdapterPosition = this.recyclerView.findViewHolderForAdapterPosition(findFirstVisibleItemPosition);
            if (findViewHolderForAdapterPosition instanceof CardsAdapter.b) {
                bVar = (CardsAdapter.b) findViewHolderForAdapterPosition;
            } else {
                bVar = null;
            }
            if (bVar != null && (m3 = bVar.m()) != null) {
                long d16 = m3.d();
                this.visibleItemIdSet.add(Long.valueOf(d16));
                if (!hashSet.contains(Long.valueOf(d16))) {
                    v(bVar);
                }
            }
            if (findFirstVisibleItemPosition != findLastVisibleItemPosition) {
                findFirstVisibleItemPosition++;
            } else {
                return;
            }
        }
    }

    private final void r() {
        List<com.tencent.mobileqq.cardcontainer.data.a> value = this.cardsViewModel.L1().getValue();
        if (value != null) {
            if (QLog.isColorLevel()) {
                QLog.i("CardContainer.CardContainerView", 2, "[initData] submit data after initializing, data size: " + value.size());
            }
            List<com.tencent.mobileqq.cardcontainer.data.a> list = value;
            if (!list.isEmpty()) {
                this.adapter.submitList(new ArrayList(list));
            }
        }
        MutableLiveData<List<com.tencent.mobileqq.cardcontainer.data.a>> L1 = this.cardsViewModel.L1();
        LifecycleOwner lifecycleOwner = this.lifecycleOwner;
        final CardContainerView$initData$2 cardContainerView$initData$2 = new CardContainerView$initData$2(this);
        L1.observe(lifecycleOwner, new Observer() { // from class: com.tencent.mobileqq.cardcontainer.framework.b
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                CardContainerView.s(Function1.this, obj);
            }
        });
        if (ContainerDataUtil.b()) {
            ((ICardContainerDataApi) QRoute.api(ICardContainerDataApi.class)).setUpdateDataCallback(new d(this));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void s(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    private final void t() {
        setBackground(ContextCompat.getDrawable(getContext(), R.drawable.qui_common_fill_light_primary_bg));
        com.tencent.qqnt.base.utils.c cVar = com.tencent.qqnt.base.utils.c.f353052a;
        setPadding(0, cVar.b(4), 0, cVar.b(4));
    }

    private final void v(CardsAdapter.b viewHolder) {
        ContainerData containerData;
        com.tencent.mobileqq.cardcontainer.data.a m3 = viewHolder.m();
        if (m3 instanceof ContainerData) {
            containerData = (ContainerData) m3;
        } else {
            containerData = null;
        }
        if (containerData != null) {
            this.cardReportHelper.b(containerData);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void w() {
        QLog.i("CardContainer.CardContainerView", 1, "refreshDataWithCache(" + this.mDeleteList.size() + ")");
        Iterator<T> it = this.mDeleteList.iterator();
        while (it.hasNext()) {
            Triple triple = (Triple) it.next();
            ((ICardContainerDataApi) QRoute.api(ICardContainerDataApi.class)).deleteCardData(((Number) triple.getFirst()).intValue(), (String) triple.getSecond(), ((Boolean) triple.getThird()).booleanValue());
        }
        this.cardsViewModel.O1();
        this.mDeleteList.clear();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean x() {
        LinearLayoutManager linearLayoutManager;
        View findViewByPosition;
        if (this.recyclerView.getScrollState() != 0) {
            return false;
        }
        RecyclerView.LayoutManager layoutManager = this.recyclerView.getLayoutManager();
        if (layoutManager instanceof LinearLayoutManager) {
            linearLayoutManager = (LinearLayoutManager) layoutManager;
        } else {
            linearLayoutManager = null;
        }
        if (linearLayoutManager == null || linearLayoutManager.findFirstVisibleItemPosition() != 0 || (findViewByPosition = linearLayoutManager.findViewByPosition(0)) == null || findViewByPosition.getLeft() != this.firstItemMargin) {
            return false;
        }
        return true;
    }

    @Override // com.tencent.mobileqq.cardcontainer.i
    public void a(boolean fromScroll) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this, fromScroll);
            return;
        }
        if (QLog.isDevelopLevel()) {
            QLog.d("CardContainer.CardContainerView", 4, "[onPause]");
        }
        this.visibleItemIdSet.clear();
        if (this.needRefreshView && !fromScroll) {
            this.isPause = true;
            this.needRefreshView = false;
            w();
        }
    }

    @Override // com.tencent.mobileqq.cardcontainer.framework.l
    public void b(int position) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this, position);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("CardContainer.CardContainerView", 1, "[onCloseCard] position: " + position);
        }
        this.cardsViewModel.M1(position);
    }

    @Override // com.tencent.mobileqq.cardcontainer.i
    public void c() {
        List emptyList;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            iPatchRedirector.redirect((short) 16, (Object) this);
            return;
        }
        CardsAdapter cardsAdapter = this.adapter;
        emptyList = CollectionsKt__CollectionsKt.emptyList();
        cardsAdapter.submitList(emptyList);
    }

    @Override // com.tencent.mobileqq.cardcontainer.framework.l
    public void d(int position, @NotNull String scheme) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this, position, (Object) scheme);
            return;
        }
        Intrinsics.checkNotNullParameter(scheme, "scheme");
        if (QLog.isColorLevel()) {
            QLog.d("CardContainer.CardContainerView", 1, "[onJumpAction] position: " + position);
        }
        this.cardsViewModel.N1(position, scheme);
    }

    @Override // com.tencent.mobileqq.cardcontainer.i
    @NotNull
    public View getView() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            return (View) iPatchRedirector.redirect((short) 13, (Object) this);
        }
        return this;
    }

    /* JADX WARN: Code restructure failed: missing block: B:27:0x0046, code lost:
    
        if (r0 != false) goto L30;
     */
    @Override // android.view.ViewGroup
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean onInterceptTouchEvent(@Nullable MotionEvent ev5) {
        boolean z16;
        boolean z17;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return ((Boolean) iPatchRedirector.redirect((short) 10, (Object) this, (Object) ev5)).booleanValue();
        }
        boolean z18 = true;
        if (ev5 != null && ev5.getAction() == 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            com.tencent.mobileqq.cardcontainer.k kVar = this.parentScrollHelper;
            if (kVar != null) {
                kVar.requestDisallowInterceptTouchEvent(true);
            }
        } else {
            if (ev5 != null && ev5.getAction() == 1) {
                z17 = true;
            } else {
                z17 = false;
            }
            if (!z17) {
                if (ev5 == null || ev5.getAction() != 3) {
                    z18 = false;
                }
            }
            com.tencent.mobileqq.cardcontainer.k kVar2 = this.parentScrollHelper;
            if (kVar2 != null) {
                kVar2.requestDisallowInterceptTouchEvent(false);
            }
        }
        return super.onInterceptTouchEvent(ev5);
    }

    @Override // com.tencent.mobileqq.cardcontainer.i
    public void onResume() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this);
            return;
        }
        if (QLog.isDevelopLevel()) {
            QLog.d("CardContainer.CardContainerView", 4, "[onResume]");
        }
        this.isPause = false;
        o();
    }

    @Nullable
    public final com.tencent.mobileqq.cardcontainer.h p() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (com.tencent.mobileqq.cardcontainer.h) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        return this.listener;
    }

    @Override // com.tencent.mobileqq.cardcontainer.i
    @SuppressLint({"NotifyDataSetChanged"})
    public void refresh() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, (Object) this);
        } else {
            RecyclerViewClearKt.clearAllCachedViews(this.recyclerView);
            this.adapter.notifyDataSetChanged();
        }
    }

    public final void setListener(@Nullable com.tencent.mobileqq.cardcontainer.h hVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) hVar);
        } else {
            this.listener = hVar;
        }
    }

    public final void setParentScrollHelper(@Nullable com.tencent.mobileqq.cardcontainer.k kVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) kVar);
        } else {
            this.parentScrollHelper = kVar;
        }
    }

    public final void setPause(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, z16);
        } else {
            this.isPause = z16;
        }
    }

    public final boolean u() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this)).booleanValue();
        }
        return this.isPause;
    }
}

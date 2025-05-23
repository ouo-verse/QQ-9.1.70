package com.tencent.biz.qqcircle.immersive.layer.biz.outside.publicaccount.staggered.item;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.view.View;
import android.view.animation.LinearInterpolator;
import android.view.animation.RotateAnimation;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.biz.qqcircle.immersive.layer.biz.outside.publicaccount.staggered.presentation.QFSPublicAccountStaggerFragment;
import com.tencent.biz.qqcircle.proxy.delegate.QCircleToast;
import com.tencent.biz.qqcircle.utils.QFSAsyncUtils;
import com.tencent.biz.qqcircle.utils.QFSQUIUtilsKt;
import com.tencent.biz.qqcircle.widgets.QCircleBaseWidgetView;
import com.tencent.biz.richframework.compat.DisplayUtil;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.eventbus.SimpleEventReceiver;
import com.tencent.biz.richframework.part.block.base.SafeLinearLayoutManager;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qcircle.api.event.QCircleFollowUpdateEvent;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.constants.ExposurePolicy;
import com.tencent.tuxmetersdk.impl.ruleengine.JsonRuleKey;
import cooperation.qqcircle.report.QCircleAlphaUserReporter;
import cooperation.qqcircle.report.datong.QCircleDaTongConstant;
import feedcloud.FeedCloudMeta$StFeed;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.MapsKt__MapsJVMKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt___RangesKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import qqcircle.QQCircleDitto$StCircleDittoDataNew;
import qqcircle.QQCircleDitto$StItemContainer;
import qqcircle.QQCircleDitto$StItemInfo;

@Metadata(d1 = {"\u0000\u00a4\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 O2\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u00032\b\u0012\u0004\u0012\u00020\u00050\u0004:\u0001PB\u0017\u0012\u0006\u0010L\u001a\u00020K\u0012\u0006\u0010,\u001a\u00020'\u00a2\u0006\u0004\bM\u0010NJ\b\u0010\u0007\u001a\u00020\u0006H\u0002J\b\u0010\t\u001a\u00020\bH\u0002J\b\u0010\n\u001a\u00020\u0006H\u0002J\u0010\u0010\u000e\u001a\u00020\r2\u0006\u0010\f\u001a\u00020\u000bH\u0002J\b\u0010\u000f\u001a\u00020\u0006H\u0002J\b\u0010\u0010\u001a\u00020\u0006H\u0002J\b\u0010\u0011\u001a\u00020\u0006H\u0002J\u0010\u0010\u0014\u001a\u00020\u00062\u0006\u0010\u0013\u001a\u00020\u0012H\u0002J\b\u0010\u0015\u001a\u00020\rH\u0002J\u0010\u0010\u0018\u001a\u00020\u00062\u0006\u0010\u0017\u001a\u00020\u0016H\u0002J\b\u0010\u0019\u001a\u00020\u0012H\u0016J\u001a\u0010\u001c\u001a\u00020\u00062\b\u0010\u001a\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u001b\u001a\u00020\u0012H\u0015J\u0010\u0010\u001f\u001a\u00020\u00062\u0006\u0010\u001e\u001a\u00020\u001dH\u0016J\u0012\u0010 \u001a\u00020\u00062\b\u0010\u0017\u001a\u0004\u0018\u00010\u0005H\u0016J$\u0010$\u001a\u001e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\"0!j\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\"`#H\u0016J\b\u0010%\u001a\u00020\u0006H\u0014J\b\u0010&\u001a\u00020\u0006H\u0014R\u0017\u0010,\u001a\u00020'8\u0006\u00a2\u0006\f\n\u0004\b(\u0010)\u001a\u0004\b*\u0010+R\u0018\u00100\u001a\u0004\u0018\u00010-8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b.\u0010/R\u001a\u00104\u001a\b\u0012\u0004\u0012\u00020\u000b018\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b2\u00103R\u001a\u00106\u001a\b\u0012\u0004\u0012\u00020\u000b018\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b5\u00103R\u0016\u0010:\u001a\u0002078\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b8\u00109R\u0016\u0010>\u001a\u00020;8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b<\u0010=R\u0016\u0010B\u001a\u00020?8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b@\u0010AR\u0016\u0010F\u001a\u00020C8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bD\u0010ER\u0016\u0010J\u001a\u00020G8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bH\u0010I\u00a8\u0006Q"}, d2 = {"Lcom/tencent/biz/qqcircle/immersive/layer/biz/outside/publicaccount/staggered/item/QFSPublicAccountStaggeredPYMKListItemView;", "Lcom/tencent/biz/qqcircle/widgets/QCircleBaseWidgetView;", "Le30/b;", "Landroid/view/View$OnClickListener;", "Lcom/tencent/biz/richframework/eventbus/SimpleEventReceiver;", "Lcom/tencent/biz/richframework/eventbus/SimpleBaseEvent;", "", "initView", "Landroid/graphics/drawable/Drawable;", "p0", "n0", "Lqqcircle/QQCircleDitto$StItemInfo;", QCircleAlphaUserReporter.KEY_USER, "", "s0", "m0", "o0", "u0", "", "position", "v0", "r0", "Lcom/tencent/mobileqq/qcircle/api/event/QCircleFollowUpdateEvent;", "event", "q0", "getLayoutId", "objData", com.tencent.luggage.wxa.c8.c.G, "bindData", "Landroid/view/View;", "v", NodeProps.ON_CLICK, "onReceiveEvent", "Ljava/util/ArrayList;", "Ljava/lang/Class;", "Lkotlin/collections/ArrayList;", "getEventClass", NodeProps.ON_ATTACHED_TO_WINDOW, NodeProps.ON_DETACHED_FROM_WINDOW, "Lcom/tencent/biz/qqcircle/immersive/layer/biz/outside/publicaccount/staggered/presentation/a;", "d", "Lcom/tencent/biz/qqcircle/immersive/layer/biz/outside/publicaccount/staggered/presentation/a;", "getOperator", "()Lcom/tencent/biz/qqcircle/immersive/layer/biz/outside/publicaccount/staggered/presentation/a;", JsonRuleKey.OPERATOR, "Lqqcircle/QQCircleDitto$StItemContainer;", "e", "Lqqcircle/QQCircleDitto$StItemContainer;", "itemContainer", "", "f", "Ljava/util/List;", "candidateUsers", tl.h.F, "showingUsers", "Landroid/widget/FrameLayout;", "i", "Landroid/widget/FrameLayout;", "topMantle", "Landroidx/recyclerview/widget/RecyclerView;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Landroidx/recyclerview/widget/RecyclerView;", "pymkList", "Lcom/tencent/biz/qqcircle/immersive/layer/biz/outside/publicaccount/staggered/presentation/k;", BdhLogUtil.LogTag.Tag_Conn, "Lcom/tencent/biz/qqcircle/immersive/layer/biz/outside/publicaccount/staggered/presentation/k;", "pymkListAdapter", "Landroid/widget/LinearLayout;", "D", "Landroid/widget/LinearLayout;", "changeBtn", "Landroid/widget/ImageView;", "E", "Landroid/widget/ImageView;", "changeIcon", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;Lcom/tencent/biz/qqcircle/immersive/layer/biz/outside/publicaccount/staggered/presentation/a;)V", UserInfo.SEX_FEMALE, "a", "qcircle-plugin-module_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes4.dex */
public final class QFSPublicAccountStaggeredPYMKListItemView extends QCircleBaseWidgetView<e30.b> implements View.OnClickListener, SimpleEventReceiver<SimpleBaseEvent> {

    /* renamed from: C, reason: from kotlin metadata */
    private com.tencent.biz.qqcircle.immersive.layer.biz.outside.publicaccount.staggered.presentation.k pymkListAdapter;

    /* renamed from: D, reason: from kotlin metadata */
    private LinearLayout changeBtn;

    /* renamed from: E, reason: from kotlin metadata */
    private ImageView changeIcon;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final com.tencent.biz.qqcircle.immersive.layer.biz.outside.publicaccount.staggered.presentation.a operator;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private QQCircleDitto$StItemContainer itemContainer;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final List<QQCircleDitto$StItemInfo> candidateUsers;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final List<QQCircleDitto$StItemInfo> showingUsers;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private FrameLayout topMantle;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private RecyclerView pymkList;

    @Metadata(d1 = {"\u0000!\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0011\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001J)\u0010\u0006\u001a\u0004\u0018\u00010\u00032\u0016\u0010\u0005\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00020\u0004\"\u0004\u0018\u00010\u0002H\u0016\u00a2\u0006\u0004\b\u0006\u0010\u0007J\u0012\u0010\n\u001a\u00020\t2\b\u0010\b\u001a\u0004\u0018\u00010\u0003H\u0016\u00a8\u0006\u000b"}, d2 = {"com/tencent/biz/qqcircle/immersive/layer/biz/outside/publicaccount/staggered/item/QFSPublicAccountStaggeredPYMKListItemView$b", "Lcom/tencent/biz/qqcircle/utils/QFSAsyncUtils$Callback;", "Ljava/lang/Void;", "Lqqcircle/QQCircleDitto$StItemContainer;", "", "param", "a", "([Ljava/lang/Void;)Lqqcircle/QQCircleDitto$StItemContainer;", "result", "", "b", "qcircle-plugin-module_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes4.dex */
    public static final class b extends QFSAsyncUtils.Callback<Void, QQCircleDitto$StItemContainer> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ e30.b f86826a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ QFSPublicAccountStaggeredPYMKListItemView f86827b;

        b(e30.b bVar, QFSPublicAccountStaggeredPYMKListItemView qFSPublicAccountStaggeredPYMKListItemView) {
            this.f86826a = bVar;
            this.f86827b = qFSPublicAccountStaggeredPYMKListItemView;
        }

        @Override // com.tencent.biz.qqcircle.utils.QFSAsyncUtils.Callback
        @Nullable
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public QQCircleDitto$StItemContainer doBackgroundAction(@NotNull Void... param) {
            Intrinsics.checkNotNullParameter(param, "param");
            try {
                QLog.d("QFSPublicAccountStaggeredPYMKListItemView", 1, "[bindData] get data from merge");
                return new QQCircleDitto$StCircleDittoDataNew().mergeFrom(this.f86826a.g().dittoFeed.dittoDataNew.get().toByteArray()).itemContainter;
            } catch (Exception e16) {
                QLog.e("QFSPublicAccountStaggeredPYMKListItemView", 1, "[bindData] Exception " + e16);
                return null;
            }
        }

        @Override // com.tencent.biz.qqcircle.utils.QFSAsyncUtils.Callback
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void doMainAction(@Nullable QQCircleDitto$StItemContainer result) {
            this.f86827b.itemContainer = result;
            this.f86827b.n0();
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public QFSPublicAccountStaggeredPYMKListItemView(@NotNull Context context, @NotNull com.tencent.biz.qqcircle.immersive.layer.biz.outside.publicaccount.staggered.presentation.a operator) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(operator, "operator");
        this.operator = operator;
        this.candidateUsers = new ArrayList();
        this.showingUsers = new ArrayList();
        initView();
    }

    private final void initView() {
        View findViewById = findViewById(R.id.f4996244);
        Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(R.id.qfs_pu\u2026count_pymk_list_title_bg)");
        FrameLayout frameLayout = (FrameLayout) findViewById;
        this.topMantle = frameLayout;
        if (frameLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("topMantle");
            frameLayout = null;
        }
        frameLayout.setBackground(p0());
        View findViewById2 = findViewById(R.id.f4995243);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "findViewById(R.id.qfs_pu\u2026_pymk_list_recycler_view)");
        this.pymkList = (RecyclerView) findViewById2;
        View findViewById3 = findViewById(R.id.f4997245);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "findViewById(R.id.qfs_pu\u2026account_pymk_list_update)");
        this.changeBtn = (LinearLayout) findViewById3;
        View findViewById4 = findViewById(R.id.f4998246);
        Intrinsics.checkNotNullExpressionValue(findViewById4, "findViewById(R.id.qfs_pu\u2026nt_pymk_list_update_icon)");
        this.changeIcon = (ImageView) findViewById4;
    }

    private final void m0() {
        Map mapOf;
        LinearLayout linearLayout = this.changeBtn;
        LinearLayout linearLayout2 = null;
        if (linearLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("changeBtn");
            linearLayout = null;
        }
        linearLayout.setOnClickListener(this);
        LinearLayout linearLayout3 = this.changeBtn;
        if (linearLayout3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("changeBtn");
            linearLayout3 = null;
        }
        VideoReport.setElementId(linearLayout3, QCircleDaTongConstant.ElementId.EM_XSJ_PYMK_CHANGE_ITEM_LIST);
        LinearLayout linearLayout4 = this.changeBtn;
        if (linearLayout4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("changeBtn");
            linearLayout4 = null;
        }
        VideoReport.setElementExposePolicy(linearLayout4, ExposurePolicy.REPORT_NONE);
        LinearLayout linearLayout5 = this.changeBtn;
        if (linearLayout5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("changeBtn");
        } else {
            linearLayout2 = linearLayout5;
        }
        mapOf = MapsKt__MapsJVMKt.mapOf(TuplesKt.to(QCircleDaTongConstant.ElementParamKey.XSJ_PYMK_MODULE_TYPE, 4));
        VideoReport.setElementParams(linearLayout2, mapOf);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void n0() {
        this.candidateUsers.clear();
        this.showingUsers.clear();
        QQCircleDitto$StItemContainer qQCircleDitto$StItemContainer = this.itemContainer;
        if (qQCircleDitto$StItemContainer != null) {
            List<QQCircleDitto$StItemInfo> list = this.candidateUsers;
            List<QQCircleDitto$StItemInfo> list2 = qQCircleDitto$StItemContainer.items.get();
            Intrinsics.checkNotNullExpressionValue(list2, "users.items.get()");
            ArrayList arrayList = new ArrayList();
            for (Object obj : list2) {
                QQCircleDitto$StItemInfo it = (QQCircleDitto$StItemInfo) obj;
                Intrinsics.checkNotNullExpressionValue(it, "it");
                if (s0(it)) {
                    arrayList.add(obj);
                }
            }
            list.addAll(arrayList);
            if (this.candidateUsers.isEmpty()) {
                setVisibility(8);
            } else {
                o0();
                m0();
            }
        }
    }

    private final void o0() {
        FeedCloudMeta$StFeed feedCloudMeta$StFeed;
        RecyclerView recyclerView = this.pymkList;
        com.tencent.biz.qqcircle.immersive.layer.biz.outside.publicaccount.staggered.presentation.k kVar = null;
        if (recyclerView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("pymkList");
            recyclerView = null;
        }
        recyclerView.setLayoutManager(new SafeLinearLayoutManager(getContext()));
        com.tencent.biz.qqcircle.immersive.layer.biz.outside.publicaccount.staggered.presentation.k kVar2 = new com.tencent.biz.qqcircle.immersive.layer.biz.outside.publicaccount.staggered.presentation.k();
        this.pymkListAdapter = kVar2;
        e30.b data = getData();
        if (data != null) {
            feedCloudMeta$StFeed = data.g();
        } else {
            feedCloudMeta$StFeed = null;
        }
        kVar2.j0(feedCloudMeta$StFeed);
        RecyclerView recyclerView2 = this.pymkList;
        if (recyclerView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("pymkList");
            recyclerView2 = null;
        }
        com.tencent.biz.qqcircle.immersive.layer.biz.outside.publicaccount.staggered.presentation.k kVar3 = this.pymkListAdapter;
        if (kVar3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("pymkListAdapter");
        } else {
            kVar = kVar3;
        }
        recyclerView2.setAdapter(kVar);
        u0();
    }

    private final Drawable p0() {
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setGradientType(0);
        gradientDrawable.setOrientation(GradientDrawable.Orientation.TOP_BOTTOM);
        int d16 = QFSQUIUtilsKt.d(getContext(), R.color.qui_common_bg_nav_primary);
        gradientDrawable.setColors(new int[]{xy2.b.m(d16, 26), xy2.b.m(d16, 0)});
        float dip2px = DisplayUtil.dip2px(getContext(), 8.0f);
        gradientDrawable.setCornerRadii(new float[]{dip2px, dip2px, dip2px, dip2px, 0.0f, 0.0f, 0.0f, 0.0f});
        return gradientDrawable;
    }

    private final void q0(QCircleFollowUpdateEvent event) {
        int i3 = event.mFollowStatus;
        if (i3 != 1 && i3 != 3) {
            return;
        }
        Iterator<QQCircleDitto$StItemInfo> it = this.showingUsers.iterator();
        int i16 = 0;
        int i17 = -1;
        while (it.hasNext()) {
            int i18 = i16 + 1;
            if (it.next().f429300id.get().equals(event.mUserId)) {
                i17 = i16;
            }
            i16 = i18;
        }
        if (i17 == -1) {
            return;
        }
        v0(i17);
    }

    private final boolean r0() {
        return !this.candidateUsers.isEmpty();
    }

    private final boolean s0(QQCircleDitto$StItemInfo user) {
        int i3 = user.buttonInfo.buttonValue.get();
        if (i3 != 1 && i3 != 3) {
            return true;
        }
        return false;
    }

    private final void u0() {
        int coerceAtMost;
        this.showingUsers.clear();
        List<QQCircleDitto$StItemInfo> list = this.showingUsers;
        List<QQCircleDitto$StItemInfo> list2 = this.candidateUsers;
        coerceAtMost = RangesKt___RangesKt.coerceAtMost(list2.size(), 4);
        list.addAll(list2.subList(0, coerceAtMost));
        this.candidateUsers.removeAll(this.showingUsers);
        com.tencent.biz.qqcircle.immersive.layer.biz.outside.publicaccount.staggered.presentation.k kVar = this.pymkListAdapter;
        if (kVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("pymkListAdapter");
            kVar = null;
        }
        kVar.k0(this.showingUsers);
    }

    private final void v0(int position) {
        if (position < 0) {
            return;
        }
        if (this.showingUsers.size() == 1) {
            this.operator.removeAll(new Function1<e30.b, Boolean>() { // from class: com.tencent.biz.qqcircle.immersive.layer.biz.outside.publicaccount.staggered.item.QFSPublicAccountStaggeredPYMKListItemView$replaceFollowedUser$1
                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                @NotNull
                public final Boolean invoke(@NotNull e30.b it) {
                    Intrinsics.checkNotNullParameter(it, "it");
                    return Boolean.valueOf(Intrinsics.areEqual(QFSPublicAccountStaggeredPYMKListItemView.this.getData().g().dittoFeed.dittoId, it.g().dittoFeed.dittoId));
                }
            });
            return;
        }
        this.showingUsers.remove(position);
        RecyclerView recyclerView = null;
        com.tencent.biz.qqcircle.immersive.layer.biz.outside.publicaccount.staggered.presentation.k kVar = null;
        if (this.candidateUsers.size() == 0) {
            com.tencent.biz.qqcircle.immersive.layer.biz.outside.publicaccount.staggered.presentation.k kVar2 = this.pymkListAdapter;
            if (kVar2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("pymkListAdapter");
            } else {
                kVar = kVar2;
            }
            kVar.i0(this.showingUsers, position, false);
            return;
        }
        this.showingUsers.add(this.candidateUsers.get(0));
        this.candidateUsers.remove(0);
        com.tencent.biz.qqcircle.immersive.layer.biz.outside.publicaccount.staggered.presentation.k kVar3 = this.pymkListAdapter;
        if (kVar3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("pymkListAdapter");
            kVar3 = null;
        }
        kVar3.i0(this.showingUsers, position, true);
        RecyclerView recyclerView2 = this.pymkList;
        if (recyclerView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("pymkList");
        } else {
            recyclerView = recyclerView2;
        }
        VideoReport.traversePage(recyclerView);
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    @NotNull
    public ArrayList<Class<SimpleBaseEvent>> getEventClass() {
        ArrayList<Class<SimpleBaseEvent>> arrayListOf;
        arrayListOf = CollectionsKt__CollectionsKt.arrayListOf(QCircleFollowUpdateEvent.class);
        Intrinsics.checkNotNull(arrayListOf, "null cannot be cast to non-null type java.util.ArrayList<java.lang.Class<com.tencent.biz.richframework.eventbus.SimpleBaseEvent>>{ kotlin.collections.TypeAliasesKt.ArrayList<java.lang.Class<com.tencent.biz.richframework.eventbus.SimpleBaseEvent>> }");
        return arrayListOf;
    }

    @Override // com.tencent.biz.richframework.widget.BaseWidgetView
    public int getLayoutId() {
        return R.layout.go6;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        SimpleEventBus.getInstance().registerReceiver(this);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(@NotNull View v3) {
        EventCollector.getInstance().onViewClickedBefore(v3);
        Intrinsics.checkNotNullParameter(v3, "v");
        if (v3.getId() == R.id.f4997245) {
            if (!r0()) {
                QCircleToast.l(QCircleToast.f91644d, com.tencent.biz.qqcircle.utils.h.a(R.string.f193824a9), 0, false, false);
            } else {
                RecyclerView recyclerView = this.pymkList;
                ImageView imageView = null;
                if (recyclerView == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("pymkList");
                    recyclerView = null;
                }
                VideoReport.traversePage(recyclerView);
                if (getWidth() != 0 && getHeight() != 0) {
                    QLog.d("QFSPublicAccountStaggeredPYMKListItemView", 1, "width: " + getWidth() + ", height: " + getHeight());
                    getLayoutParams().height = getHeight() + QFSPublicAccountStaggerFragment.INSTANCE.b();
                    setLayoutParams(getLayoutParams());
                }
                RotateAnimation rotateAnimation = new RotateAnimation(0.0f, 360.0f, 1, 0.5f, 1, 0.5f);
                rotateAnimation.setDuration(500L);
                rotateAnimation.setInterpolator(new LinearInterpolator());
                ImageView imageView2 = this.changeIcon;
                if (imageView2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("changeIcon");
                } else {
                    imageView = imageView2;
                }
                imageView.startAnimation(rotateAnimation);
                u0();
            }
        }
        EventCollector.getInstance().onViewClicked(v3);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.widget.BaseWidgetView, android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        SimpleEventBus.getInstance().unRegisterReceiver(this);
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public void onReceiveEvent(@Nullable SimpleBaseEvent event) {
        if (event instanceof QCircleFollowUpdateEvent) {
            q0((QCircleFollowUpdateEvent) event);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.widget.BaseWidgetView
    @SuppressLint({"SetTextI18n"})
    public void bindData(@Nullable e30.b objData, int pos) {
        if (objData != null && objData.g() != null) {
            if (!this.showingUsers.isEmpty()) {
                QLog.d("QFSPublicAccountStaggeredPYMKListItemView", 1, "[bindData] already showing. ");
                return;
            }
            Object b16 = objData.b(String.valueOf(objData.g().dittoFeed.dittoId.get()));
            if (b16 instanceof QQCircleDitto$StCircleDittoDataNew) {
                this.itemContainer = ((QQCircleDitto$StCircleDittoDataNew) b16).itemContainter;
                QLog.d("QFSPublicAccountStaggeredPYMKListItemView", 1, "[bindData] get data from blockData");
            }
            if (this.itemContainer == null) {
                QFSAsyncUtils.executeSub(new b(objData, this), new Void[0]);
                return;
            } else {
                n0();
                return;
            }
        }
        QLog.e("QFSPublicAccountStaggeredPYMKListItemView", 1, "[bindData] feedBlockData == null ");
    }
}

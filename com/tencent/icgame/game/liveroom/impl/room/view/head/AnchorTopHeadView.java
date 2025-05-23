package com.tencent.icgame.game.liveroom.impl.room.view.head;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextSwitcher;
import android.widget.TextView;
import android.widget.ViewSwitcher;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import com.heytap.databaseengine.model.UserInfo;
import com.qzone.proxy.personalitycomponent.model.WidgetCacheConstellationData;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.eventbus.SimpleEventReceiver;
import com.tencent.icgame.common.api.IAegisLogApi;
import com.tencent.icgame.game.api.live.LiveRoomExtraInfo;
import com.tencent.icgame.game.liveroom.impl.room.toparea.a;
import com.tencent.icgame.game.ui.widget.RoundCornerImageView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.miniaio.MiniChatConstants;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mobileqq.util.x;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u009e\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \u00132\u00020\u00012\u00020\u00022\b\u0012\u0004\u0012\u00020\u00040\u0003:\u0001bB'\b\u0007\u0012\u0006\u0010\\\u001a\u00020[\u0012\n\b\u0002\u0010^\u001a\u0004\u0018\u00010]\u0012\b\b\u0002\u0010_\u001a\u00020A\u00a2\u0006\u0004\b`\u0010aJ\b\u0010\u0006\u001a\u00020\u0005H\u0002J\u0018\u0010\u000b\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\tH\u0002J\u0018\u0010\u000e\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\r\u001a\u00020\fH\u0002J\b\u0010\u000f\u001a\u00020\u0005H\u0002J\u0010\u0010\u0011\u001a\u00020\u00052\u0006\u0010\u0010\u001a\u00020\u0007H\u0002J\f\u0010\u0013\u001a\u00020\u0005*\u00020\u0012H\u0002J\b\u0010\u0014\u001a\u00020\u0005H\u0002J\b\u0010\u0015\u001a\u00020\u0005H\u0002J\u000e\u0010\u0017\u001a\u00020\u00052\u0006\u0010\u0016\u001a\u00020\u0012J\u000e\u0010\u001a\u001a\u00020\u00052\u0006\u0010\u0019\u001a\u00020\u0018J\u0006\u0010\u001b\u001a\u00020\u0005J\b\u0010\u001c\u001a\u00020\u0005H\u0014J\u000e\u0010\u001e\u001a\u00020\u00052\u0006\u0010\u001d\u001a\u00020\tJ\"\u0010 \u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\t2\b\u0010\u001f\u001a\u0004\u0018\u00010\fH\u0016J\u0010\u0010!\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0007H\u0016J\u0010\u0010\"\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0007H\u0016J\u0018\u0010#\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\tH\u0016J\u0006\u0010$\u001a\u00020\u0005J\u0010\u0010%\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0007H\u0016J\u000e\u0010(\u001a\u00020\u00052\u0006\u0010'\u001a\u00020&J\u0006\u0010)\u001a\u00020\u0005J\u0012\u0010+\u001a\u00020\u00052\b\u0010*\u001a\u0004\u0018\u00010\u0004H\u0016J$\u0010/\u001a\u001e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040-0,j\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040-`.H\u0016R\u0016\u00102\u001a\u00020\t8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b0\u00101R\u0016\u00104\u001a\u00020\t8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b3\u00101R\u0018\u00107\u001a\u0004\u0018\u00010\u00128\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b5\u00106R\u0018\u0010:\u001a\u0004\u0018\u00010\u00188\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b8\u00109R\u0016\u0010>\u001a\u00020;8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b<\u0010=R\u0016\u0010@\u001a\u00020\u00078\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b?\u0010(R\"\u0010G\u001a\u00020A8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bB\u0010 \u001a\u0004\bC\u0010D\"\u0004\bE\u0010FR\u0014\u0010J\u001a\u00020H8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b#\u0010IR\u0014\u0010M\u001a\u00020K8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b%\u0010LR\u0014\u0010P\u001a\u00020N8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001e\u0010OR\u0014\u0010S\u001a\u00020Q8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b!\u0010RR\u0014\u0010U\u001a\u00020\u00018\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\"\u0010TR\u0014\u0010X\u001a\u00020V8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b \u0010WR\u0014\u0010Y\u001a\u00020Q8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b(\u0010RR\u0014\u0010Z\u001a\u00020V8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0014\u0010W\u00a8\u0006c"}, d2 = {"Lcom/tencent/icgame/game/liveroom/impl/room/view/head/AnchorTopHeadView;", "Landroid/widget/FrameLayout;", "", "Lcom/tencent/biz/richframework/eventbus/SimpleEventReceiver;", "Lcom/tencent/biz/richframework/eventbus/SimpleBaseEvent;", "", ReportConstant.COSTREPORT_PREFIX, "", "roomId", "", "isAnchor", "p", "", "programId", "r", "v", WidgetCacheConstellationData.NUM, "O", "Lcom/tencent/icgame/game/liveroom/impl/room/toparea/e;", "L", "K", "o", "vm", "setViewModel", "Landroidx/lifecycle/LifecycleOwner;", "owner", "setLifecycle", "M", NodeProps.ON_DETACHED_FROM_WINDOW, MiniChatConstants.MINI_APP_LANDSCAPE, UserInfo.SEX_FEMALE, AppConstants.Key.KEY_QZONE_VIDEO_URL, "I", "G", "H", "D", "setQQLive", "E", "Lcom/tencent/icgame/game/api/live/LiveRoomExtraInfo;", "extraInfo", "J", "N", "event", "onReceiveEvent", "Ljava/util/ArrayList;", "Ljava/lang/Class;", "Lkotlin/collections/ArrayList;", "getEventClass", "d", "Z", "isDetachedFromWindow", "e", "hadEnterRoom", "f", "Lcom/tencent/icgame/game/liveroom/impl/room/toparea/e;", "viewModel", tl.h.F, "Landroidx/lifecycle/LifecycleOwner;", "lifecycleOwner", "Lcom/tencent/icgame/common/api/IAegisLogApi;", "i", "Lcom/tencent/icgame/common/api/IAegisLogApi;", "mAegisLog", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "curRoomPlayerNum", "", BdhLogUtil.LogTag.Tag_Conn, "getRoomType", "()I", "setRoomType", "(I)V", "roomType", "Lcom/tencent/icgame/game/ui/widget/RoundCornerImageView;", "Lcom/tencent/icgame/game/ui/widget/RoundCornerImageView;", "portraitIgv", "Landroid/widget/TextSwitcher;", "Landroid/widget/TextSwitcher;", "anchorLiveStatusTxv", "Landroid/widget/LinearLayout;", "Landroid/widget/LinearLayout;", "nameContainer", "Landroid/widget/TextView;", "Landroid/widget/TextView;", "unfollowTxv", "Landroid/widget/FrameLayout;", "fansGroupFl", "Landroid/view/View;", "Landroid/view/View;", "placeHolderView", "nameTxv", "headIconBgView", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "a", "ic-game-timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes7.dex */
public final class AnchorTopHeadView extends FrameLayout implements SimpleEventReceiver<SimpleBaseEvent> {

    /* renamed from: C, reason: from kotlin metadata */
    private int roomType;

    /* renamed from: D, reason: from kotlin metadata */
    @NotNull
    private final RoundCornerImageView portraitIgv;

    /* renamed from: E, reason: from kotlin metadata */
    @NotNull
    private final TextSwitcher anchorLiveStatusTxv;

    /* renamed from: F, reason: from kotlin metadata */
    @NotNull
    private final LinearLayout nameContainer;

    /* renamed from: G, reason: from kotlin metadata */
    @NotNull
    private final TextView unfollowTxv;

    /* renamed from: H, reason: from kotlin metadata */
    @NotNull
    private final FrameLayout fansGroupFl;

    /* renamed from: I, reason: from kotlin metadata */
    @NotNull
    private final View placeHolderView;

    /* renamed from: J, reason: from kotlin metadata */
    @NotNull
    private final TextView nameTxv;

    /* renamed from: K, reason: from kotlin metadata */
    @NotNull
    private final View headIconBgView;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private boolean isDetachedFromWindow;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private boolean hadEnterRoom;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private com.tencent.icgame.game.liveroom.impl.room.toparea.e viewModel;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private LifecycleOwner lifecycleOwner;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private IAegisLogApi mAegisLog;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private long curRoomPlayerNum;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public AnchorTopHeadView(@NotNull Context context) {
        this(context, null, 0, 6, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void A(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void C(AnchorTopHeadView this$0, Integer visible) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        View view = this$0.placeHolderView;
        Intrinsics.checkNotNullExpressionValue(visible, "visible");
        view.setVisibility(visible.intValue());
    }

    private final void K() {
        com.tencent.icgame.game.liveroom.impl.room.toparea.e eVar = this.viewModel;
        if (eVar != null) {
            Intrinsics.checkNotNull(eVar);
            if (!eVar.w()) {
                return;
            }
        }
        ViewGroup.LayoutParams layoutParams = this.portraitIgv.getLayoutParams();
        layoutParams.width = (int) uu0.a.d(35);
        layoutParams.height = (int) uu0.a.d(35);
        this.portraitIgv.setLayoutParams(layoutParams);
        this.portraitIgv.setRadius(uu0.a.d(18), uu0.a.d(18), uu0.a.d(18), uu0.a.d(18));
        this.headIconBgView.setVisibility(8);
        this.portraitIgv.setImageResource(R.drawable.ovu);
    }

    private final void L(com.tencent.icgame.game.liveroom.impl.room.toparea.e eVar) {
        int i3;
        int c16;
        if (eVar.w()) {
            i3 = 0;
        } else {
            i3 = 8;
        }
        this.portraitIgv.setVisibility(i3);
        LinearLayout linearLayout = this.nameContainer;
        ViewGroup.LayoutParams layoutParams = linearLayout.getLayoutParams();
        Intrinsics.checkNotNull(layoutParams, "null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
        if (eVar.w()) {
            c16 = x.c(getContext(), 38.0f);
        } else {
            c16 = x.c(getContext(), 12.0f);
        }
        marginLayoutParams.leftMargin = c16;
        linearLayout.setLayoutParams(marginLayoutParams);
        K();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void O(long num) {
        TextView textView;
        TextSwitcher textSwitcher = this.anchorLiveStatusTxv;
        View childAt = textSwitcher.getChildAt(textSwitcher.getDisplayedChild());
        if (childAt instanceof TextView) {
            textView = (TextView) childAt;
        } else {
            textView = null;
        }
        if (textView != null) {
            String str = com.tencent.icgame.game.liveroom.impl.room.util.g.f115696a.a(Long.valueOf(num)) + " \u4eba\u5728\u73a9";
            this.mAegisLog.i("ICGameUnknown|ICGameAnchorTopHeadView_", "updatePlayerNumView roomLikeText:" + str);
            textView.setText(str);
            textView.setTextColor(-1);
        }
    }

    private final void p(long roomId, boolean isAnchor) {
        if (this.anchorLiveStatusTxv.getChildCount() > 0) {
            return;
        }
        this.anchorLiveStatusTxv.setFactory(new ViewSwitcher.ViewFactory() { // from class: com.tencent.icgame.game.liveroom.impl.room.view.head.j
            @Override // android.widget.ViewSwitcher.ViewFactory
            public final View makeView() {
                View q16;
                q16 = AnchorTopHeadView.q(AnchorTopHeadView.this);
                return q16;
            }
        });
        r(roomId, r42.b.n(r42.b.f430720a, roomId, 0, 2, null));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final View q(AnchorTopHeadView this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        TextView textView = new TextView(this$0.getContext());
        textView.setLayoutParams(new FrameLayout.LayoutParams(-2, -1));
        textView.setTextSize(1, 10.0f);
        textView.setGravity(16);
        textView.setTextColor(-1);
        textView.setMaxLines(1);
        textView.setMaxEms(20);
        textView.setEllipsize(TextUtils.TruncateAt.END);
        return textView;
    }

    private final void r(long roomId, String programId) {
        com.tencent.icgame.game.liveroom.impl.room.toparea.e eVar = this.viewModel;
        if (eVar != null) {
            eVar.u(roomId, programId);
        }
    }

    private final void s() {
        RoundCornerImageView.setRadius$default(this.portraitIgv, uu0.a.d(16), 0.0f, 0.0f, uu0.a.d(16), 6, null);
        setOnClickListener(new View.OnClickListener() { // from class: com.tencent.icgame.game.liveroom.impl.room.view.head.a
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                AnchorTopHeadView.t(AnchorTopHeadView.this, view);
            }
        });
        this.unfollowTxv.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.icgame.game.liveroom.impl.room.view.head.b
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                AnchorTopHeadView.u(AnchorTopHeadView.this, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void t(AnchorTopHeadView this$0, View it) {
        EventCollector.getInstance().onViewClickedBefore(it);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        com.tencent.icgame.game.liveroom.impl.room.toparea.e eVar = this$0.viewModel;
        if (eVar != null) {
            Activity c16 = com.tencent.icgame.game.utils.a.c(this$0);
            Intrinsics.checkNotNullExpressionValue(it, "it");
            eVar.P(c16, it);
        }
        EventCollector.getInstance().onViewClicked(it);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void u(AnchorTopHeadView this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        com.tencent.icgame.game.liveroom.impl.room.toparea.e eVar = this$0.viewModel;
        if (eVar != null) {
            eVar.B();
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    private final void v() {
        final com.tencent.icgame.game.liveroom.impl.room.toparea.e eVar;
        LifecycleOwner lifecycleOwner = this.lifecycleOwner;
        if (lifecycleOwner != null && (eVar = this.viewModel) != null) {
            MutableLiveData<Integer> i3 = eVar.i();
            final AnchorTopHeadView$observeVm$1$1$1 anchorTopHeadView$observeVm$1$1$1 = new Function1<Integer, Unit>() { // from class: com.tencent.icgame.game.liveroom.impl.room.view.head.AnchorTopHeadView$observeVm$1$1$1
                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(Integer num) {
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(Integer num) {
                    invoke2(num);
                    return Unit.INSTANCE;
                }
            };
            i3.observe(lifecycleOwner, new Observer() { // from class: com.tencent.icgame.game.liveroom.impl.room.view.head.c
                @Override // androidx.lifecycle.Observer
                public final void onChanged(Object obj) {
                    AnchorTopHeadView.y(Function1.this, obj);
                }
            });
            MutableLiveData<Integer> s16 = eVar.s();
            final Function1<Integer, Unit> function1 = new Function1<Integer, Unit>() { // from class: com.tencent.icgame.game.liveroom.impl.room.view.head.AnchorTopHeadView$observeVm$1$1$2
                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(Integer num) {
                    invoke2(num);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(Integer visible) {
                    TextView textView;
                    textView = AnchorTopHeadView.this.unfollowTxv;
                    Intrinsics.checkNotNullExpressionValue(visible, "visible");
                    textView.setVisibility(visible.intValue());
                }
            };
            s16.observe(lifecycleOwner, new Observer() { // from class: com.tencent.icgame.game.liveroom.impl.room.view.head.d
                @Override // androidx.lifecycle.Observer
                public final void onChanged(Object obj) {
                    AnchorTopHeadView.z(Function1.this, obj);
                }
            });
            MutableLiveData<Long> o16 = eVar.o();
            final Function1<Long, Unit> function12 = new Function1<Long, Unit>() { // from class: com.tencent.icgame.game.liveroom.impl.room.view.head.AnchorTopHeadView$observeVm$1$1$3
                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(Long l3) {
                    invoke2(l3);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(Long playerNumValue) {
                    long j3;
                    AnchorTopHeadView anchorTopHeadView = AnchorTopHeadView.this;
                    Intrinsics.checkNotNullExpressionValue(playerNumValue, "playerNumValue");
                    anchorTopHeadView.curRoomPlayerNum = playerNumValue.longValue();
                    AnchorTopHeadView anchorTopHeadView2 = AnchorTopHeadView.this;
                    j3 = anchorTopHeadView2.curRoomPlayerNum;
                    anchorTopHeadView2.O(j3);
                }
            };
            o16.observe(lifecycleOwner, new Observer() { // from class: com.tencent.icgame.game.liveroom.impl.room.view.head.e
                @Override // androidx.lifecycle.Observer
                public final void onChanged(Object obj) {
                    AnchorTopHeadView.A(Function1.this, obj);
                }
            });
            eVar.j().observe(lifecycleOwner, new Observer() { // from class: com.tencent.icgame.game.liveroom.impl.room.view.head.f
                @Override // androidx.lifecycle.Observer
                public final void onChanged(Object obj) {
                    AnchorTopHeadView.B((Integer) obj);
                }
            });
            eVar.n().observe(lifecycleOwner, new Observer() { // from class: com.tencent.icgame.game.liveroom.impl.room.view.head.g
                @Override // androidx.lifecycle.Observer
                public final void onChanged(Object obj) {
                    AnchorTopHeadView.C(AnchorTopHeadView.this, (Integer) obj);
                }
            });
            eVar.m().observe(lifecycleOwner, new Observer() { // from class: com.tencent.icgame.game.liveroom.impl.room.view.head.h
                @Override // androidx.lifecycle.Observer
                public final void onChanged(Object obj) {
                    AnchorTopHeadView.w(AnchorTopHeadView.this, (String) obj);
                }
            });
            eVar.k().observe(lifecycleOwner, new Observer() { // from class: com.tencent.icgame.game.liveroom.impl.room.view.head.i
                @Override // androidx.lifecycle.Observer
                public final void onChanged(Object obj) {
                    AnchorTopHeadView.x(com.tencent.icgame.game.liveroom.impl.room.toparea.e.this, this, (String) obj);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void w(AnchorTopHeadView this$0, String str) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.nameTxv.setText(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void x(com.tencent.icgame.game.liveroom.impl.room.toparea.e this_apply, AnchorTopHeadView this$0, String str) {
        Intrinsics.checkNotNullParameter(this_apply, "$this_apply");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (!this_apply.w()) {
            return;
        }
        RoundCornerImageView roundCornerImageView = this$0.portraitIgv;
        com.tencent.icgame.game.utils.a.e(roundCornerImageView, str, this_apply.r(roundCornerImageView));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void y(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void z(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    public void D(long roomId, boolean isAnchor) {
        this.mAegisLog.i("ICGameUnknown|ICGameAnchorTopHeadView_", 1, "onEnterRoom roomId:" + roomId + ", isAnchor:" + isAnchor);
        setVisibility(0);
        this.hadEnterRoom = true;
        com.tencent.icgame.game.liveroom.impl.room.toparea.e eVar = this.viewModel;
        if (eVar != null) {
            L(eVar);
            eVar.v(roomId, this.roomType, isAnchor);
            eVar.e();
            eVar.C(com.tencent.icgame.game.utils.a.c(this));
        }
        p(roomId, isAnchor);
    }

    public void E(long roomId) {
        this.mAegisLog.i("ICGameUnknown|ICGameAnchorTopHeadView_", 1, "onExitRoom: viewModel:" + this.viewModel);
        this.mAegisLog.i("ICGameUnknown|ICGameAnchorTopHeadView_", 1, "onExitRoom roomId:" + roomId);
        com.tencent.icgame.game.liveroom.impl.room.toparea.e eVar = this.viewModel;
        if (eVar != null) {
            eVar.f();
        }
        o();
        this.hadEnterRoom = false;
    }

    public final void F(boolean isLandscape) {
        com.tencent.icgame.game.liveroom.impl.room.toparea.e eVar = this.viewModel;
        if (eVar != null) {
            eVar.M(isLandscape);
        }
    }

    public void I(long roomId, boolean isAnchor, @Nullable String videoUrl) {
        com.tencent.icgame.game.liveroom.impl.room.toparea.e eVar = this.viewModel;
        if (eVar != null) {
            L(eVar);
            eVar.v(roomId, this.roomType, isAnchor);
            eVar.preload();
        }
        setVisibility(0);
    }

    public final void J(@NotNull LiveRoomExtraInfo extraInfo) {
        Intrinsics.checkNotNullParameter(extraInfo, "extraInfo");
        com.tencent.icgame.game.liveroom.impl.room.toparea.e eVar = this.viewModel;
        if (eVar != null && eVar.x()) {
            String string = extraInfo.E.getString("ext_anchor_head", "");
            eVar.G(extraInfo.E.getString("ext_anchor_nick", ""));
            eVar.F(string);
        }
    }

    public final void M() {
        com.tencent.icgame.game.liveroom.impl.room.toparea.e eVar = this.viewModel;
        if (eVar != null) {
            eVar.J();
        }
    }

    public final void N() {
        this.mAegisLog.i("ICGameUnknown|ICGameAnchorTopHeadView_", 1, "updateFollowState");
        com.tencent.icgame.game.liveroom.impl.room.toparea.e eVar = this.viewModel;
        if (eVar != null) {
            a.C5841a.a(eVar, false, 1, null);
        }
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    @NotNull
    public ArrayList<Class<SimpleBaseEvent>> getEventClass() {
        return new ArrayList<>();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.isDetachedFromWindow = true;
        com.tencent.icgame.game.liveroom.impl.room.toparea.e eVar = this.viewModel;
        if (eVar != null) {
            eVar.d();
        }
    }

    public final void setLifecycle(@NotNull LifecycleOwner owner) {
        Intrinsics.checkNotNullParameter(owner, "owner");
        this.lifecycleOwner = owner;
        v();
    }

    public final void setQQLive() {
        K();
    }

    public final void setRoomType(int i3) {
        this.roomType = i3;
    }

    public final void setViewModel(@NotNull com.tencent.icgame.game.liveroom.impl.room.toparea.e vm5) {
        Intrinsics.checkNotNullParameter(vm5, "vm");
        this.mAegisLog.i("ICGameUnknown|ICGameAnchorTopHeadView_", 1, "setViewModel " + this);
        vm5.O(this);
        vm5.N(this.fansGroupFl);
        this.viewModel = vm5;
        vm5.y();
        if (this.lifecycleOwner != null) {
            v();
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public AnchorTopHeadView(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    public /* synthetic */ AnchorTopHeadView(Context context, AttributeSet attributeSet, int i3, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i16 & 2) != 0 ? null : attributeSet, (i16 & 4) != 0 ? 0 : i3);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public AnchorTopHeadView(@NotNull Context context, @Nullable AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        Intrinsics.checkNotNullParameter(context, "context");
        QRouteApi api = QRoute.api(IAegisLogApi.class);
        Intrinsics.checkNotNullExpressionValue(api, "api(IAegisLogApi::class.java)");
        this.mAegisLog = (IAegisLogApi) api;
        View.inflate(context, R.layout.fba, this);
        View findViewById = findViewById(R.id.f26470dm);
        Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(R.id.portraitIgv)");
        this.portraitIgv = (RoundCornerImageView) findViewById;
        View findViewById2 = findViewById(R.id.f114086sd);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "findViewById(R.id.unfollowTxv)");
        this.unfollowTxv = (TextView) findViewById2;
        View findViewById3 = findViewById(R.id.sne);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "findViewById(R.id.anchorLiveStatusTxv)");
        this.anchorLiveStatusTxv = (TextSwitcher) findViewById3;
        View findViewById4 = findViewById(R.id.uzn);
        Intrinsics.checkNotNullExpressionValue(findViewById4, "findViewById(R.id.fansGroupFl)");
        this.fansGroupFl = (FrameLayout) findViewById4;
        View findViewById5 = findViewById(R.id.f25520b2);
        Intrinsics.checkNotNullExpressionValue(findViewById5, "findViewById(R.id.placeHolderView)");
        this.placeHolderView = findViewById5;
        View findViewById6 = findViewById(R.id.f166375zm0);
        Intrinsics.checkNotNullExpressionValue(findViewById6, "findViewById(R.id.nameTxv)");
        this.nameTxv = (TextView) findViewById6;
        View findViewById7 = findViewById(R.id.zlx);
        Intrinsics.checkNotNullExpressionValue(findViewById7, "findViewById(R.id.nameContainer)");
        this.nameContainer = (LinearLayout) findViewById7;
        View findViewById8 = findViewById(R.id.x7r);
        Intrinsics.checkNotNullExpressionValue(findViewById8, "findViewById(R.id.headIconBgView)");
        this.headIconBgView = findViewById8;
        setBackgroundResource(R.drawable.lqf);
        SimpleEventBus.getInstance().registerReceiver(this);
        s();
    }

    private final void o() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void B(Integer num) {
    }

    public void G(long roomId) {
    }

    public void H(long roomId) {
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public void onReceiveEvent(@Nullable SimpleBaseEvent event) {
    }
}

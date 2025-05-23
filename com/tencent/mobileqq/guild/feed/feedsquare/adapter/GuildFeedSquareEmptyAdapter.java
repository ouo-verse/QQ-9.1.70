package com.tencent.mobileqq.guild.feed.feedsquare.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.RecyclerView;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.biz.qui.quibutton.QUIButton;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.eventbus.SimpleEventReceiver;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.guild.component.GuildQUIEmptyState;
import com.tencent.mobileqq.guild.feed.event.GuildEmptyPartEvent;
import com.tencent.mobileqq.guild.feed.event.GuildSpeakThresholdStateChangeEvent;
import com.tencent.mobileqq.guild.feed.launcher.GuildFeedMainInitBean;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0098\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\u000e\u0018\u0000 V2\f\u0012\b\u0012\u00060\u0002R\u00020\u00000\u00012\b\u0012\u0004\u0012\u00020\u00040\u0003:\u0003WXYB\u001f\u0012\u0006\u00106\u001a\u000201\u0012\u0006\u0010:\u001a\u000207\u0012\u0006\u0010>\u001a\u00020;\u00a2\u0006\u0004\bT\u0010UJ\b\u0010\u0006\u001a\u00020\u0005H\u0002J\b\u0010\u0007\u001a\u00020\u0005H\u0002J\b\u0010\b\u001a\u00020\u0005H\u0002J\b\u0010\t\u001a\u00020\u0005H\u0002J\u0010\u0010\r\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\nH\u0002J\f\u0010\u000e\u001a\u00020\u0005*\u00020\fH\u0002J\n\u0010\u0010\u001a\u0004\u0018\u00010\u000fH\u0002J\f\u0010\u0013\u001a\u00020\u0012*\u00020\u0011H\u0002J\b\u0010\u0014\u001a\u00020\u0005H\u0002J\u0010\u0010\u0017\u001a\u00020\u00052\u0006\u0010\u0016\u001a\u00020\u0015H\u0002J\b\u0010\u0019\u001a\u00020\u0018H\u0002J$\u0010 \u001a\u00020\u001f2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001a2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001a2\u0006\u0010\u001e\u001a\u00020\u001dH\u0002J\u0006\u0010!\u001a\u00020\u0005J\u0010\u0010#\u001a\u00020\u001d2\u0006\u0010\"\u001a\u00020\u001dH\u0016J\u001c\u0010'\u001a\u00060\u0002R\u00020\u00002\u0006\u0010%\u001a\u00020$2\u0006\u0010&\u001a\u00020\u001dH\u0016J\u001c\u0010)\u001a\u00020\u00052\n\u0010(\u001a\u00060\u0002R\u00020\u00002\u0006\u0010\"\u001a\u00020\u001dH\u0016J\b\u0010*\u001a\u00020\u001dH\u0016J$\u0010.\u001a\u001e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040,0+j\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040,`-H\u0016J\u0012\u0010/\u001a\u00020\u00052\b\u0010\u0016\u001a\u0004\u0018\u00010\u0004H\u0016J\u0014\u00100\u001a\u00020\u00052\n\u0010(\u001a\u00060\u0002R\u00020\u0000H\u0016R\u0017\u00106\u001a\u0002018\u0006\u00a2\u0006\f\n\u0004\b2\u00103\u001a\u0004\b4\u00105R\u0014\u0010:\u001a\u0002078\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b8\u00109R\u0014\u0010>\u001a\u00020;8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b<\u0010=R\u0018\u0010A\u001a\u0004\u0018\u00010\f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b?\u0010@R\u0018\u0010D\u001a\u0004\u0018\u00010\u00128\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bB\u0010CR\u0018\u0010F\u001a\u0004\u0018\u00010\u00128\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bE\u0010CR\u0016\u0010I\u001a\u00020\u001f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bG\u0010HR\u0016\u0010K\u001a\u00020\u001f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bJ\u0010HR$\u0010S\u001a\u0004\u0018\u00010L8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bM\u0010N\u001a\u0004\bO\u0010P\"\u0004\bQ\u0010R\u00a8\u0006Z"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/feedsquare/adapter/GuildFeedSquareEmptyAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/tencent/mobileqq/guild/feed/feedsquare/adapter/GuildFeedSquareEmptyAdapter$c;", "Lcom/tencent/biz/richframework/eventbus/SimpleEventReceiver;", "Lcom/tencent/biz/richframework/eventbus/SimpleBaseEvent;", "", "H0", "B0", "z0", "x0", "Landroid/content/Context;", "context", "Landroid/widget/FrameLayout;", "p0", "J0", "Landroid/view/View;", "s0", "Lcom/tencent/mobileqq/guild/component/GuildQUIEmptyState$a;", "Lcom/tencent/mobileqq/guild/component/GuildQUIEmptyState;", "o0", "t0", "Lcom/tencent/mobileqq/guild/feed/event/GuildEmptyPartEvent;", "simpleBaseEvent", "u0", "Landroid/widget/FrameLayout$LayoutParams;", "r0", "", "gId", "cId", "", "busType", "", "w0", "q0", "position", "getItemViewType", "Landroid/view/ViewGroup;", HippyNestedScrollComponent.PRIORITY_PARENT, "viewType", "D0", "holder", "C0", "getItemCount", "Ljava/util/ArrayList;", "Ljava/lang/Class;", "Lkotlin/collections/ArrayList;", "getEventClass", "onReceiveEvent", "E0", "Lcom/tencent/mobileqq/guild/feed/launcher/GuildFeedMainInitBean;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lcom/tencent/mobileqq/guild/feed/launcher/GuildFeedMainInitBean;", "getMInitBean", "()Lcom/tencent/mobileqq/guild/feed/launcher/GuildFeedMainInitBean;", "mInitBean", "Lcom/tencent/mobileqq/guild/feed/viewmodel/k;", BdhLogUtil.LogTag.Tag_Conn, "Lcom/tencent/mobileqq/guild/feed/viewmodel/k;", "mInfoManagerViewModel", "Landroidx/fragment/app/Fragment;", "D", "Landroidx/fragment/app/Fragment;", "mParentFragment", "E", "Landroid/widget/FrameLayout;", "mContainer", UserInfo.SEX_FEMALE, "Lcom/tencent/mobileqq/guild/component/GuildQUIEmptyState;", "quiEmptyState", "G", "quiNetErrorState", "H", "Z", "lastVisibleStatus", "I", "mIsMember", "Lcom/tencent/mobileqq/guild/feed/feedsquare/adapter/GuildFeedSquareEmptyAdapter$a;", "J", "Lcom/tencent/mobileqq/guild/feed/feedsquare/adapter/GuildFeedSquareEmptyAdapter$a;", "getCallback", "()Lcom/tencent/mobileqq/guild/feed/feedsquare/adapter/GuildFeedSquareEmptyAdapter$a;", "F0", "(Lcom/tencent/mobileqq/guild/feed/feedsquare/adapter/GuildFeedSquareEmptyAdapter$a;)V", "callback", "<init>", "(Lcom/tencent/mobileqq/guild/feed/launcher/GuildFeedMainInitBean;Lcom/tencent/mobileqq/guild/feed/viewmodel/k;Landroidx/fragment/app/Fragment;)V", "K", "a", "b", "c", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class GuildFeedSquareEmptyAdapter extends RecyclerView.Adapter<c> implements SimpleEventReceiver<SimpleBaseEvent> {

    /* renamed from: C, reason: from kotlin metadata */
    @NotNull
    private final com.tencent.mobileqq.guild.feed.viewmodel.k mInfoManagerViewModel;

    /* renamed from: D, reason: from kotlin metadata */
    @NotNull
    private final Fragment mParentFragment;

    /* renamed from: E, reason: from kotlin metadata */
    @Nullable
    private FrameLayout mContainer;

    /* renamed from: F, reason: from kotlin metadata */
    @Nullable
    private GuildQUIEmptyState quiEmptyState;

    /* renamed from: G, reason: from kotlin metadata */
    @Nullable
    private GuildQUIEmptyState quiNetErrorState;

    /* renamed from: H, reason: from kotlin metadata */
    private boolean lastVisibleStatus;

    /* renamed from: I, reason: from kotlin metadata */
    private boolean mIsMember;

    /* renamed from: J, reason: from kotlin metadata */
    @Nullable
    private a callback;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final GuildFeedMainInitBean mInitBean;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H&\u00a8\u0006\u0004"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/feedsquare/adapter/GuildFeedSquareEmptyAdapter$a;", "", "", UserInfo.SEX_FEMALE, "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes13.dex */
    public interface a {
        void F();
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u00a2\u0006\u0004\b\u0004\u0010\u0005\u00a8\u0006\u0006"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/feedsquare/adapter/GuildFeedSquareEmptyAdapter$c;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "Landroid/view/View;", "itemView", "<init>", "(Lcom/tencent/mobileqq/guild/feed/feedsquare/adapter/GuildFeedSquareEmptyAdapter;Landroid/view/View;)V", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes13.dex */
    public final class c extends RecyclerView.ViewHolder {
        final /* synthetic */ GuildFeedSquareEmptyAdapter E;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(@NotNull GuildFeedSquareEmptyAdapter guildFeedSquareEmptyAdapter, View itemView) {
            super(itemView);
            Intrinsics.checkNotNullParameter(itemView, "itemView");
            this.E = guildFeedSquareEmptyAdapter;
        }
    }

    public GuildFeedSquareEmptyAdapter(@NotNull GuildFeedMainInitBean mInitBean, @NotNull com.tencent.mobileqq.guild.feed.viewmodel.k mInfoManagerViewModel, @NotNull Fragment mParentFragment) {
        Intrinsics.checkNotNullParameter(mInitBean, "mInitBean");
        Intrinsics.checkNotNullParameter(mInfoManagerViewModel, "mInfoManagerViewModel");
        Intrinsics.checkNotNullParameter(mParentFragment, "mParentFragment");
        this.mInitBean = mInitBean;
        this.mInfoManagerViewModel = mInfoManagerViewModel;
        this.mParentFragment = mParentFragment;
        SimpleEventBus.getInstance().registerReceiver(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void A0(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    private final void B0() {
        if (this.mInitBean.getBusinessType() == 15) {
            x0();
        } else {
            z0();
        }
    }

    private final void H0() {
        GuildQUIEmptyState guildQUIEmptyState;
        Context context;
        Context context2;
        FrameLayout frameLayout = this.mContainer;
        GuildQUIEmptyState guildQUIEmptyState2 = null;
        if (frameLayout != null && (context2 = frameLayout.getContext()) != null) {
            GuildQUIEmptyState.a q16 = new GuildQUIEmptyState.a(context2).s(7).u("\u7f51\u7edc\u5f02\u5e38").q("\u8bf7\u68c0\u67e5\u7f51\u7edc\u8bbe\u7f6e\u540e\u91cd\u8bd5");
            String qqStr = HardCodeUtil.qqStr(R.string.zxy);
            Intrinsics.checkNotNullExpressionValue(qqStr, "qqStr(R.string.feed_retry)");
            guildQUIEmptyState = o0(q16.p(qqStr, new View.OnClickListener() { // from class: com.tencent.mobileqq.guild.feed.feedsquare.adapter.f
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    GuildFeedSquareEmptyAdapter.I0(GuildFeedSquareEmptyAdapter.this, view);
                }
            }));
        } else {
            guildQUIEmptyState = null;
        }
        this.quiNetErrorState = guildQUIEmptyState;
        FrameLayout frameLayout2 = this.mContainer;
        if (frameLayout2 != null && (context = frameLayout2.getContext()) != null) {
            GuildQUIEmptyState.a s16 = new GuildQUIEmptyState.a(context).s(8);
            String string = context.getString(R.string.f145530rq);
            Intrinsics.checkNotNullExpressionValue(string, "it.getString(R.string.gu\u2026d_feed_square_emtpy_tips)");
            guildQUIEmptyState2 = o0(s16.u(string));
        }
        this.quiEmptyState = guildQUIEmptyState2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void I0(GuildFeedSquareEmptyAdapter this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.t0();
        EventCollector.getInstance().onViewClicked(view);
    }

    private final void J0(FrameLayout frameLayout) {
        ViewGroup.LayoutParams layoutParams;
        FrameLayout frameLayout2 = this.mContainer;
        if (frameLayout2 != null) {
            layoutParams = frameLayout2.getLayoutParams();
        } else {
            layoutParams = null;
        }
        if (layoutParams == null) {
            layoutParams = r0();
        }
        if (this.lastVisibleStatus) {
            frameLayout.setVisibility(0);
            layoutParams.height = -2;
            frameLayout.removeAllViews();
            View s06 = s0();
            if (s06 != null) {
                frameLayout.addView(s06);
                return;
            }
            return;
        }
        frameLayout.setVisibility(8);
        layoutParams.height = 0;
    }

    private final GuildQUIEmptyState o0(GuildQUIEmptyState.a aVar) {
        GuildQUIEmptyState a16 = aVar.n(false).o(0).a();
        QUIButton qUIButton = (QUIButton) a16.findViewById(R.id.uuk);
        if (qUIButton != null) {
            Intrinsics.checkNotNullExpressionValue(qUIButton, "findViewById<QUIButton?>\u2026d.empty_state_medium_btn)");
            ViewGroup.LayoutParams layoutParams = qUIButton.getLayoutParams();
            if (layoutParams != null) {
                layoutParams.width = qUIButton.getResources().getDimensionPixelSize(R.dimen.c_0);
            }
            ViewGroup.LayoutParams layoutParams2 = qUIButton.getLayoutParams();
            if (layoutParams2 != null) {
                layoutParams2.height = qUIButton.getResources().getDimensionPixelSize(R.dimen.c_c);
            }
            qUIButton.setTextSize(17.0f);
        }
        return a16;
    }

    private final FrameLayout p0(Context context) {
        FrameLayout frameLayout = new FrameLayout(context);
        FrameLayout.LayoutParams r06 = r0();
        r06.height = 0;
        frameLayout.setLayoutParams(r06);
        frameLayout.setPadding(frameLayout.getResources().getDimensionPixelSize(R.dimen.f158700mp), frameLayout.getResources().getDimensionPixelSize(R.dimen.c9x), frameLayout.getResources().getDimensionPixelSize(R.dimen.f158700mp), 0);
        J0(frameLayout);
        frameLayout.setVisibility(8);
        return frameLayout;
    }

    private final FrameLayout.LayoutParams r0() {
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -2);
        layoutParams.gravity = 1;
        return layoutParams;
    }

    private final View s0() {
        Context context;
        if (!NetworkUtil.isNetworkAvailable()) {
            QLog.d("GuildFeedSquareEmptyAdapter", 1, "getTipView = " + this.quiNetErrorState);
            return this.quiNetErrorState;
        }
        GuildQUIEmptyState guildQUIEmptyState = this.quiEmptyState;
        FrameLayout frameLayout = this.mContainer;
        if (frameLayout != null) {
            context = frameLayout.getContext();
        } else {
            context = null;
        }
        QLog.d("GuildFeedSquareEmptyAdapter", 1, "getTipView = " + guildQUIEmptyState + ", mContainer = " + frameLayout + ", context = " + context);
        return this.quiEmptyState;
    }

    private final void t0() {
        a aVar = this.callback;
        if (aVar != null) {
            aVar.F();
        }
    }

    private final void u0(final GuildEmptyPartEvent simpleBaseEvent) {
        ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.mobileqq.guild.feed.feedsquare.adapter.e
            @Override // java.lang.Runnable
            public final void run() {
                GuildFeedSquareEmptyAdapter.v0(GuildEmptyPartEvent.this, this);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void v0(GuildEmptyPartEvent simpleBaseEvent, GuildFeedSquareEmptyAdapter this$0) {
        Intrinsics.checkNotNullParameter(simpleBaseEvent, "$simpleBaseEvent");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (simpleBaseEvent.isShowView()) {
            this$0.B0();
        }
        this$0.lastVisibleStatus = simpleBaseEvent.isShowView();
        FrameLayout frameLayout = this$0.mContainer;
        if (frameLayout != null) {
            this$0.J0(frameLayout);
        }
    }

    private final boolean w0(String gId, String cId, int busType) {
        boolean z16;
        boolean z17;
        if (gId != null && gId.length() != 0) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (!z16) {
            if (cId != null && cId.length() != 0) {
                z17 = false;
            } else {
                z17 = true;
            }
            if (!z17) {
                if (Intrinsics.areEqual(gId, this.mInitBean.getGuildId()) && Intrinsics.areEqual(cId, this.mInitBean.getChannelId()) && this.mInitBean.getBusinessType() == busType) {
                    return true;
                }
                return false;
            }
        }
        return false;
    }

    private final void x0() {
        this.mInfoManagerViewModel.Z1(this.mInitBean.getGuildId(), this.mInitBean.getChannelId());
        MutableLiveData<Boolean> Q1 = this.mInfoManagerViewModel.Q1();
        if (Q1 != null) {
            Fragment fragment = this.mParentFragment;
            final Function1<Boolean, Unit> function1 = new Function1<Boolean, Unit>() { // from class: com.tencent.mobileqq.guild.feed.feedsquare.adapter.GuildFeedSquareEmptyAdapter$observeSectionViewModel$1
                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
                    invoke2(bool);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(Boolean bool) {
                    com.tencent.mobileqq.guild.feed.viewmodel.k kVar;
                    GuildFeedSquareEmptyAdapter guildFeedSquareEmptyAdapter = GuildFeedSquareEmptyAdapter.this;
                    kVar = guildFeedSquareEmptyAdapter.mInfoManagerViewModel;
                    guildFeedSquareEmptyAdapter.mIsMember = kVar.P1();
                }
            };
            Q1.observe(fragment, new Observer() { // from class: com.tencent.mobileqq.guild.feed.feedsquare.adapter.h
                @Override // androidx.lifecycle.Observer
                public final void onChanged(Object obj) {
                    GuildFeedSquareEmptyAdapter.y0(Function1.this, obj);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void y0(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    private final void z0() {
        this.mInfoManagerViewModel.X1(this.mInitBean.getGuildId());
        MutableLiveData<Boolean> Q1 = this.mInfoManagerViewModel.Q1();
        if (Q1 != null) {
            Fragment fragment = this.mParentFragment;
            final Function1<Boolean, Unit> function1 = new Function1<Boolean, Unit>() { // from class: com.tencent.mobileqq.guild.feed.feedsquare.adapter.GuildFeedSquareEmptyAdapter$observeSquareViewModel$1
                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
                    invoke2(bool);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(Boolean bool) {
                    com.tencent.mobileqq.guild.feed.viewmodel.k kVar;
                    GuildFeedSquareEmptyAdapter guildFeedSquareEmptyAdapter = GuildFeedSquareEmptyAdapter.this;
                    kVar = guildFeedSquareEmptyAdapter.mInfoManagerViewModel;
                    guildFeedSquareEmptyAdapter.mIsMember = kVar.P1();
                }
            };
            Q1.observe(fragment, new Observer() { // from class: com.tencent.mobileqq.guild.feed.feedsquare.adapter.g
                @Override // androidx.lifecycle.Observer
                public final void onChanged(Object obj) {
                    GuildFeedSquareEmptyAdapter.A0(Function1.this, obj);
                }
            });
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: C0, reason: merged with bridge method [inline-methods] */
    public void onBindViewHolder(@NotNull c holder, int position) {
        FrameLayout frameLayout;
        Intrinsics.checkNotNullParameter(holder, "holder");
        QLog.d("GuildFeedSquareEmptyAdapter", 1, "onBindViewHolder, old = " + this.mContainer + ", new = " + holder.itemView);
        View view = holder.itemView;
        if (view instanceof FrameLayout) {
            frameLayout = (FrameLayout) view;
        } else {
            frameLayout = null;
        }
        this.mContainer = frameLayout;
        H0();
        FrameLayout frameLayout2 = this.mContainer;
        if (frameLayout2 != null) {
            J0(frameLayout2);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @NotNull
    /* renamed from: D0, reason: merged with bridge method [inline-methods] */
    public c onCreateViewHolder(@NotNull ViewGroup parent, int viewType) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        Context context = parent.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "parent.context");
        this.mContainer = p0(context);
        H0();
        FrameLayout frameLayout = this.mContainer;
        Intrinsics.checkNotNull(frameLayout);
        return new c(this, frameLayout);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: E0, reason: merged with bridge method [inline-methods] */
    public void onViewRecycled(@NotNull c holder) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        super.onViewRecycled(holder);
        this.mContainer = null;
    }

    public final void F0(@Nullable a aVar) {
        this.callback = aVar;
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    @NotNull
    public ArrayList<Class<SimpleBaseEvent>> getEventClass() {
        ArrayList<Class<SimpleBaseEvent>> arrayListOf;
        arrayListOf = CollectionsKt__CollectionsKt.arrayListOf(GuildEmptyPartEvent.class, GuildSpeakThresholdStateChangeEvent.class);
        return arrayListOf;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: getItemCount */
    public int getNUM_BACKGOURND_ICON() {
        return 1;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int position) {
        return 11;
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public void onReceiveEvent(@Nullable SimpleBaseEvent simpleBaseEvent) {
        if (simpleBaseEvent instanceof GuildEmptyPartEvent) {
            GuildEmptyPartEvent guildEmptyPartEvent = (GuildEmptyPartEvent) simpleBaseEvent;
            if (w0(guildEmptyPartEvent.getGuildId(), guildEmptyPartEvent.getChannelId(), guildEmptyPartEvent.getBusinessType())) {
                u0(guildEmptyPartEvent);
            }
        }
    }

    public final void q0() {
        SimpleEventBus.getInstance().unRegisterReceiver(this);
    }
}

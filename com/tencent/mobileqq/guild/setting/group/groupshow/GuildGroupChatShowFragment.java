package com.tencent.mobileqq.guild.setting.group.groupshow;

import android.content.Context;
import android.content.Intent;
import android.graphics.Rect;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStoreOwner;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.common.ParseCommon;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.eventbus.SimpleEventReceiver;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.QPublicFragmentActivity;
import com.tencent.mobileqq.guild.base.QQGuildTitleBarFragment;
import com.tencent.mobileqq.guild.base.extension.m;
import com.tencent.mobileqq.guild.event.GuildHomeFragmentOnRefreshEvent;
import com.tencent.mobileqq.guild.mainframe.startpanel.rightpart.facade.FacadeArgsData;
import com.tencent.mobileqq.guild.rolegroup.model.repositories.r;
import com.tencent.mobileqq.guild.setting.group.GuildBindGroupSettingFragment;
import com.tencent.mobileqq.guild.setting.group.groupshow.g;
import com.tencent.mobileqq.guild.setting.group.groupshow.viewmodel.GuildGroupChatShowViewModel;
import com.tencent.mobileqq.guild.util.Logger;
import com.tencent.mobileqq.guild.util.QQGuildUIUtil;
import com.tencent.mobileqq.guild.util.bc;
import com.tencent.mobileqq.guild.util.ch;
import com.tencent.mobileqq.guild.util.cn;
import com.tencent.mobileqq.guild.util.o;
import com.tencent.mobileqq.guild.widget.OverScrollRecyclerViewWithHeaderFooter;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqmini.minigame.action.OperateCustomButton;
import com.tencent.qqmini.sdk.launcher.MiniSDKConst;
import ef1.c;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.time.Duration;
import kotlin.time.TimeSource;
import kotlin.time.TimedValue;
import mqq.app.Constants;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u008b\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n*\u0001\u000e\u0018\u0000 F2\u00020\u00012\b\u0012\u0004\u0012\u00020\u00030\u0002:\u0001GB\u0007\u00a2\u0006\u0004\bD\u0010EJ\b\u0010\u0005\u001a\u00020\u0004H\u0002J\b\u0010\u0006\u001a\u00020\u0004H\u0002J\b\u0010\b\u001a\u00020\u0007H\u0002J\b\u0010\t\u001a\u00020\u0004H\u0002J\b\u0010\n\u001a\u00020\u0004H\u0002J\u0010\u0010\r\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u000bH\u0002J\u000f\u0010\u000f\u001a\u00020\u000eH\u0002\u00a2\u0006\u0004\b\u000f\u0010\u0010J\b\u0010\u0012\u001a\u00020\u0011H\u0014J\u0012\u0010\u0015\u001a\u00020\u00042\b\u0010\u0014\u001a\u0004\u0018\u00010\u0013H\u0016J\b\u0010\u0016\u001a\u00020\u0004H\u0016J&\u0010\u001b\u001a\u00020\u00042\b\u0010\u0018\u001a\u0004\u0018\u00010\u00172\b\u0010\u001a\u001a\u0004\u0018\u00010\u00192\b\u0010\u0014\u001a\u0004\u0018\u00010\u0013H\u0014J\b\u0010\u001c\u001a\u00020\u0011H\u0014J\b\u0010\u001d\u001a\u00020\u0011H\u0014J\b\u0010\u001e\u001a\u00020\u0004H\u0016J\b\u0010\u001f\u001a\u00020\u0004H\u0016J\b\u0010 \u001a\u00020\u0004H\u0016J\u0012\u0010\"\u001a\u00020\u00042\b\u0010!\u001a\u0004\u0018\u00010\u0003H\u0016J$\u0010&\u001a\u001e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030$0#j\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030$`%H\u0016R\u0016\u0010)\u001a\u00020\u00078\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b'\u0010(R\u0016\u0010-\u001a\u00020*8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b+\u0010,R\u0014\u00101\u001a\u00020.8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b/\u00100R\u0016\u00105\u001a\u0002028\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b3\u00104R\u0016\u00109\u001a\u0002068\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b7\u00108R\u0016\u0010=\u001a\u00020:8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b;\u0010<R\u0016\u0010@\u001a\u00020>8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b(\u0010?R\u0014\u0010C\u001a\u00020\u000b8BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\bA\u0010B\u00a8\u0006H"}, d2 = {"Lcom/tencent/mobileqq/guild/setting/group/groupshow/GuildGroupChatShowFragment;", "Lcom/tencent/mobileqq/guild/base/QQGuildTitleBarFragment;", "Lcom/tencent/biz/richframework/eventbus/SimpleEventReceiver;", "Lcom/tencent/biz/richframework/eventbus/SimpleBaseEvent;", "", "initView", "initTitleBar", "", "Nh", "Jh", "initViewModel", "Landroid/view/View;", "view", "Ph", "com/tencent/mobileqq/guild/setting/group/groupshow/GuildGroupChatShowFragment$newGroupChatItemCallback$1", "Oh", "()Lcom/tencent/mobileqq/guild/setting/group/groupshow/GuildGroupChatShowFragment$newGroupChatItemCallback$1;", "", "getContentLayoutId", "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, "onCreate", MosaicConstants$JsFunction.FUNC_ON_DESTROY, "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", ParseCommon.CONTAINER, "doOnCreateView", "qh", "ph", "onResume", MiniSDKConst.NOTIFY_EVENT_ONPAUSE, "onDestroyView", "event", "onReceiveEvent", "Ljava/util/ArrayList;", "Ljava/lang/Class;", "Lkotlin/collections/ArrayList;", "getEventClass", "T", "Z", "isActive", "", "U", "Ljava/lang/String;", "guildId", "Lbz1/a;", "V", "Lbz1/a;", "groupChatItemCallback", "Lcom/tencent/mobileqq/guild/mainframe/startpanel/rightpart/facade/FacadeArgsData;", "W", "Lcom/tencent/mobileqq/guild/mainframe/startpanel/rightpart/facade/FacadeArgsData;", "facadeArgsData", "Lcom/tencent/mobileqq/guild/widget/OverScrollRecyclerViewWithHeaderFooter;", "X", "Lcom/tencent/mobileqq/guild/widget/OverScrollRecyclerViewWithHeaderFooter;", "recyclerView", "Lzy1/a;", "Y", "Lzy1/a;", "adapter", "Lcom/tencent/mobileqq/guild/setting/group/groupshow/viewmodel/GuildGroupChatShowViewModel;", "Lcom/tencent/mobileqq/guild/setting/group/groupshow/viewmodel/GuildGroupChatShowViewModel;", "viewModel", "getContentView", "()Landroid/view/View;", "contentView", "<init>", "()V", "a0", "a", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public final class GuildGroupChatShowFragment extends QQGuildTitleBarFragment implements SimpleEventReceiver<SimpleBaseEvent> {

    /* renamed from: a0, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: T, reason: from kotlin metadata */
    private boolean isActive;

    /* renamed from: U, reason: from kotlin metadata */
    @NotNull
    private String guildId = "";

    /* renamed from: V, reason: from kotlin metadata */
    @NotNull
    private final bz1.a groupChatItemCallback = Oh();

    /* renamed from: W, reason: from kotlin metadata */
    private FacadeArgsData facadeArgsData;

    /* renamed from: X, reason: from kotlin metadata */
    private OverScrollRecyclerViewWithHeaderFooter recyclerView;

    /* renamed from: Y, reason: from kotlin metadata */
    private zy1.a adapter;

    /* renamed from: Z, reason: from kotlin metadata */
    private GuildGroupChatShowViewModel viewModel;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000f\u0010\u0010J\u0016\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004R\u0014\u0010\t\u001a\u00020\b8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\t\u0010\nR\u0014\u0010\f\u001a\u00020\u000b8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\f\u0010\rR\u0014\u0010\u000e\u001a\u00020\b8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\n\u00a8\u0006\u0011"}, d2 = {"Lcom/tencent/mobileqq/guild/setting/group/groupshow/GuildGroupChatShowFragment$a;", "", "Landroid/content/Context;", "context", "Lcom/tencent/mobileqq/guild/mainframe/startpanel/rightpart/facade/FacadeArgsData;", "facadeArgsData", "", "a", "", "PARAM_FACADE_ARGS_DATA", "Ljava/lang/String;", "", "RET_JOIN_SUCCESS", "I", "TAG", "<init>", "()V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.guild.setting.group.groupshow.GuildGroupChatShowFragment$a, reason: from kotlin metadata */
    /* loaded from: classes14.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final void a(@NotNull Context context, @NotNull FacadeArgsData facadeArgsData) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(facadeArgsData, "facadeArgsData");
            Intent intent = new Intent();
            intent.putExtra("param_facade_args_data", facadeArgsData);
            QPublicFragmentActivity.start(context, intent, GuildGroupChatShowFragment.class);
        }

        Companion() {
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000)\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J(\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0016\u00a8\u0006\f"}, d2 = {"com/tencent/mobileqq/guild/setting/group/groupshow/GuildGroupChatShowFragment$b", "Landroidx/recyclerview/widget/RecyclerView$ItemDecoration;", "Landroid/graphics/Rect;", "outRect", "Landroid/view/View;", "view", "Landroidx/recyclerview/widget/RecyclerView;", HippyNestedScrollComponent.PRIORITY_PARENT, "Landroidx/recyclerview/widget/RecyclerView$State;", "state", "", "getItemOffsets", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes14.dex */
    public static final class b extends RecyclerView.ItemDecoration {
        b() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
        public void getItemOffsets(@NotNull Rect outRect, @NotNull View view, @NotNull RecyclerView parent, @NotNull RecyclerView.State state) {
            Intrinsics.checkNotNullParameter(outRect, "outRect");
            Intrinsics.checkNotNullParameter(view, "view");
            Intrinsics.checkNotNullParameter(parent, "parent");
            Intrinsics.checkNotNullParameter(state, "state");
            super.getItemOffsets(outRect, view, parent, state);
            if (parent.getAdapter() == null) {
                return;
            }
            int childAdapterPosition = parent.getChildAdapterPosition(view);
            Intrinsics.checkNotNull(parent.getAdapter());
            if (childAdapterPosition == r4.getItemCount() - 1) {
                outRect.bottom = QQGuildUIUtil.f(60.0f);
            }
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J'\u0010\u0006\u001a\u00028\u0000\"\b\b\u0000\u0010\u0003*\u00020\u00022\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004H\u0016\u00a2\u0006\u0004\b\u0006\u0010\u0007\u00a8\u0006\b"}, d2 = {"com/tencent/mobileqq/guild/base/mvvm/SingleViewModelProvider$Companion$factory$1", "Landroidx/lifecycle/ViewModelProvider$Factory;", "Landroidx/lifecycle/ViewModel;", "T", "Ljava/lang/Class;", "p0", OperateCustomButton.OPERATE_CREATE, "(Ljava/lang/Class;)Landroidx/lifecycle/ViewModel;", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes14.dex */
    public static final class c implements ViewModelProvider.Factory {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ ViewModelStoreOwner f233441a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ GuildGroupChatShowFragment f233442b;

        public c(ViewModelStoreOwner viewModelStoreOwner, GuildGroupChatShowFragment guildGroupChatShowFragment) {
            this.f233441a = viewModelStoreOwner;
            this.f233442b = guildGroupChatShowFragment;
        }

        @Override // androidx.lifecycle.ViewModelProvider.Factory
        @NotNull
        public <T extends ViewModel> T create(@NotNull Class<T> p06) {
            Intrinsics.checkNotNullParameter(p06, "p0");
            TimedValue timedValue = new TimedValue(new GuildGroupChatShowViewModel(this.f233442b.guildId), TimeSource.Monotonic.ValueTimeMark.m1966elapsedNowUwyO8pc(TimeSource.Monotonic.INSTANCE.m1963markNowz9LOYto()), null);
            Logger logger = Logger.f235387a;
            if (QLog.isColorLevel()) {
                logger.d().d("GuildViewModelProvider", 2, "create " + m.a(timedValue.getValue()) + " cost " + Duration.m1875toStringimpl(timedValue.m1981getDurationUwyO8pc()));
            }
            return (T) timedValue.getValue();
        }
    }

    private final void Jh() {
        if (Nh()) {
            setRightButtonEnable(true);
            g.Companion companion = g.INSTANCE;
            View rightTextView = getRightTextView();
            Intrinsics.checkNotNullExpressionValue(rightTextView, "rightTextView");
            g.Companion.h(companion, rightTextView, false, 2, null);
            wh(R.drawable.guild_title_top_right_more_icon, new View.OnClickListener() { // from class: com.tencent.mobileqq.guild.setting.group.groupshow.a
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    GuildGroupChatShowFragment.Kh(GuildGroupChatShowFragment.this, view);
                }
            });
            return;
        }
        setRightButtonEnable(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Kh(GuildGroupChatShowFragment this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (!o.c("fastClickGuard")) {
            View rightTextView = this$0.getRightTextView();
            Intrinsics.checkNotNullExpressionValue(rightTextView, "rightTextView");
            this$0.Ph(rightTextView);
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Lh(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Mh(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    private final boolean Nh() {
        if (ch.n0(this.guildId)) {
            return true;
        }
        return r.p().getGuildPermission(this.guildId).g();
    }

    private final GuildGroupChatShowFragment$newGroupChatItemCallback$1 Oh() {
        return new GuildGroupChatShowFragment$newGroupChatItemCallback$1(this);
    }

    private final void Ph(View view) {
        g.INSTANCE.e(view);
        Intent intent = new Intent();
        intent.putExtra("extra_guild_id", this.guildId);
        QPublicFragmentActivity.start(getContext(), intent, GuildBindGroupSettingFragment.class);
    }

    private final View getContentView() {
        View mContentView = this.P;
        Intrinsics.checkNotNullExpressionValue(mContentView, "mContentView");
        return mContentView;
    }

    private final void initTitleBar() {
        this.E.setText("\u76f8\u5173\u7fa4\u804a");
        Jh();
    }

    private final void initView() {
        FacadeArgsData facadeArgsData;
        Bundle arguments = getArguments();
        OverScrollRecyclerViewWithHeaderFooter overScrollRecyclerViewWithHeaderFooter = null;
        if (arguments != null) {
            facadeArgsData = (FacadeArgsData) arguments.getParcelable("param_facade_args_data");
        } else {
            facadeArgsData = null;
        }
        if (facadeArgsData != null) {
            this.facadeArgsData = facadeArgsData;
            String str = facadeArgsData.f227656e;
            Intrinsics.checkNotNullExpressionValue(str, "facadeArgsData.guildId");
            this.guildId = str;
            View contentView = getContentView();
            Context requireContext = requireContext();
            Intrinsics.checkNotNullExpressionValue(requireContext, "requireContext()");
            contentView.setBackground(bc.b(requireContext, R.drawable.qui_common_bg_nav_secondary_bg));
            initTitleBar();
            View findViewById = getContentView().findViewById(R.id.vtc);
            Intrinsics.checkNotNullExpressionValue(findViewById, "contentView.findViewById\u2026.group_chat_recyclerview)");
            OverScrollRecyclerViewWithHeaderFooter overScrollRecyclerViewWithHeaderFooter2 = (OverScrollRecyclerViewWithHeaderFooter) findViewById;
            this.recyclerView = overScrollRecyclerViewWithHeaderFooter2;
            if (overScrollRecyclerViewWithHeaderFooter2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
                overScrollRecyclerViewWithHeaderFooter2 = null;
            }
            overScrollRecyclerViewWithHeaderFooter2.setLayoutManager(new LinearLayoutManager(getActivity()));
            this.adapter = new zy1.a(this.groupChatItemCallback);
            OverScrollRecyclerViewWithHeaderFooter overScrollRecyclerViewWithHeaderFooter3 = this.recyclerView;
            if (overScrollRecyclerViewWithHeaderFooter3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
                overScrollRecyclerViewWithHeaderFooter3 = null;
            }
            zy1.a aVar = this.adapter;
            if (aVar == null) {
                Intrinsics.throwUninitializedPropertyAccessException("adapter");
                aVar = null;
            }
            overScrollRecyclerViewWithHeaderFooter3.setAdapter(aVar);
            OverScrollRecyclerViewWithHeaderFooter overScrollRecyclerViewWithHeaderFooter4 = this.recyclerView;
            if (overScrollRecyclerViewWithHeaderFooter4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
                overScrollRecyclerViewWithHeaderFooter4 = null;
            }
            overScrollRecyclerViewWithHeaderFooter4.setItemAnimator(new DefaultItemAnimator());
            OverScrollRecyclerViewWithHeaderFooter overScrollRecyclerViewWithHeaderFooter5 = this.recyclerView;
            if (overScrollRecyclerViewWithHeaderFooter5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
            } else {
                overScrollRecyclerViewWithHeaderFooter = overScrollRecyclerViewWithHeaderFooter5;
            }
            overScrollRecyclerViewWithHeaderFooter.addItemDecoration(new b());
            return;
        }
        throw new IllegalStateException("GuildGroupChatShowFragment param_facade_args_data is null");
    }

    private final void initViewModel() {
        c.Companion companion = ef1.c.INSTANCE;
        ViewModel viewModel = new ViewModelProvider(this, new c(this, this)).get(GuildGroupChatShowViewModel.class);
        Intrinsics.checkNotNullExpressionValue(viewModel, "ViewModelProvider(this, \u2026k(this) })[T::class.java]");
        GuildGroupChatShowViewModel guildGroupChatShowViewModel = (GuildGroupChatShowViewModel) viewModel;
        this.viewModel = guildGroupChatShowViewModel;
        GuildGroupChatShowViewModel guildGroupChatShowViewModel2 = null;
        if (guildGroupChatShowViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            guildGroupChatShowViewModel = null;
        }
        LiveData<List<az1.a>> a26 = guildGroupChatShowViewModel.a2();
        LifecycleOwner lifecycleOwner = getLifecycleOwner();
        final GuildGroupChatShowFragment$initViewModel$2 guildGroupChatShowFragment$initViewModel$2 = new GuildGroupChatShowFragment$initViewModel$2(this);
        a26.observe(lifecycleOwner, new Observer() { // from class: com.tencent.mobileqq.guild.setting.group.groupshow.b
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                GuildGroupChatShowFragment.Lh(Function1.this, obj);
            }
        });
        GuildGroupChatShowViewModel guildGroupChatShowViewModel3 = this.viewModel;
        if (guildGroupChatShowViewModel3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        } else {
            guildGroupChatShowViewModel2 = guildGroupChatShowViewModel3;
        }
        cn<Boolean> c26 = guildGroupChatShowViewModel2.c2();
        LifecycleOwner lifecycleOwner2 = getLifecycleOwner();
        final Function1<Boolean, Unit> function1 = new Function1<Boolean, Unit>() { // from class: com.tencent.mobileqq.guild.setting.group.groupshow.GuildGroupChatShowFragment$initViewModel$3
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
                OverScrollRecyclerViewWithHeaderFooter overScrollRecyclerViewWithHeaderFooter;
                OverScrollRecyclerViewWithHeaderFooter overScrollRecyclerViewWithHeaderFooter2;
                zy1.a aVar;
                overScrollRecyclerViewWithHeaderFooter = GuildGroupChatShowFragment.this.recyclerView;
                zy1.a aVar2 = null;
                if (overScrollRecyclerViewWithHeaderFooter == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
                    overScrollRecyclerViewWithHeaderFooter = null;
                }
                overScrollRecyclerViewWithHeaderFooter.setItemViewCacheSize(0);
                overScrollRecyclerViewWithHeaderFooter2 = GuildGroupChatShowFragment.this.recyclerView;
                if (overScrollRecyclerViewWithHeaderFooter2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
                    overScrollRecyclerViewWithHeaderFooter2 = null;
                }
                overScrollRecyclerViewWithHeaderFooter2.setItemViewCacheSize(2);
                aVar = GuildGroupChatShowFragment.this.adapter;
                if (aVar == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("adapter");
                } else {
                    aVar2 = aVar;
                }
                aVar2.notifyDataSetChanged();
            }
        };
        c26.observe(lifecycleOwner2, new Observer() { // from class: com.tencent.mobileqq.guild.setting.group.groupshow.c
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                GuildGroupChatShowFragment.Mh(Function1.this, obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.guild.base.QQGuildTitleBarFragment, com.tencent.mobileqq.guild.base.QQGuildCustomTitleBarFragment
    public void doOnCreateView(@Nullable LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        super.doOnCreateView(inflater, container, savedInstanceState);
        initView();
        initViewModel();
        SimpleEventBus.getInstance().registerReceiver(this);
        g.Companion companion = g.INSTANCE;
        Context requireContext = requireContext();
        Intrinsics.checkNotNullExpressionValue(requireContext, "requireContext()");
        RelativeLayout titleRoot = this.N;
        Intrinsics.checkNotNullExpressionValue(titleRoot, "titleRoot");
        companion.a(requireContext, titleRoot, this.guildId);
    }

    @Override // com.tencent.mobileqq.guild.base.QQGuildCustomTitleBarFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment
    protected int getContentLayoutId() {
        return R.layout.esx;
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    @NotNull
    public ArrayList<Class<SimpleBaseEvent>> getEventClass() {
        ArrayList<Class<SimpleBaseEvent>> arrayListOf;
        arrayListOf = CollectionsKt__CollectionsKt.arrayListOf(GuildHomeFragmentOnRefreshEvent.class);
        return arrayListOf;
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, androidx.fragment.app.Fragment
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Logger.f235387a.d().i("GuildGroupChatShowFragment", 1, "onCreate");
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        Logger.f235387a.d().i("GuildGroupChatShowFragment", 1, MosaicConstants$JsFunction.FUNC_ON_DESTROY);
    }

    @Override // com.tencent.mobileqq.guild.base.QQGuildCustomTitleBarFragment, androidx.fragment.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        SimpleEventBus.getInstance().unRegisterReceiver(this);
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onPause() {
        super.onPause();
        this.isActive = false;
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public void onReceiveEvent(@Nullable SimpleBaseEvent event) {
        if ((event instanceof GuildHomeFragmentOnRefreshEvent) && this.isActive) {
            GuildGroupChatShowViewModel guildGroupChatShowViewModel = this.viewModel;
            if (guildGroupChatShowViewModel == null) {
                Intrinsics.throwUninitializedPropertyAccessException("viewModel");
                guildGroupChatShowViewModel = null;
            }
            guildGroupChatShowViewModel.h2();
        }
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        this.isActive = true;
        Logger.f235387a.d().i("GuildGroupChatShowFragment", 1, "onResume(" + this.guildId + ")");
        GuildGroupChatShowViewModel guildGroupChatShowViewModel = this.viewModel;
        if (guildGroupChatShowViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            guildGroupChatShowViewModel = null;
        }
        guildGroupChatShowViewModel.h2();
    }

    @Override // com.tencent.mobileqq.guild.base.QQGuildCustomTitleBarFragment
    protected int ph() {
        return R.color.qui_common_bg_nav_secondary;
    }

    @Override // com.tencent.mobileqq.guild.base.QQGuildCustomTitleBarFragment
    protected int qh() {
        return R.drawable.qui_common_bg_nav_secondary_bg;
    }
}

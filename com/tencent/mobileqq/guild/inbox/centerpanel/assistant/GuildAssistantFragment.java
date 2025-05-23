package com.tencent.mobileqq.guild.inbox.centerpanel.assistant;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.common.ParseCommon;
import com.tencent.biz.qui.quiemptystate.QUIEmptyState;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.guild.base.QQGuildTitleBarFragment;
import com.tencent.mobileqq.guild.inbox.startpanel.dialog.k;
import com.tencent.mobileqq.guild.jump.GuildJumpUtil;
import com.tencent.mobileqq.guild.jump.model.QQGuildJumpSource;
import com.tencent.mobileqq.guild.mainframe.centerpanel.GuildCenterPanelController;
import com.tencent.mobileqq.guild.message.directmessage.model.data.InboxNoticeNode;
import com.tencent.mobileqq.guild.message.directmessage.model.repositories.InboxNoticeNodeRepository;
import com.tencent.mobileqq.guild.message.directmessage.model.repositories.m;
import com.tencent.mobileqq.guild.util.GuildSplitViewUtils;
import com.tencent.mobileqq.guild.util.Logger;
import com.tencent.mobileqq.guild.util.ch;
import com.tencent.mobileqq.guild.widget.OverScrollRecyclerViewWithHeaderFooter;
import com.tencent.mobileqq.guild.widget.RecyclerViewWithHeaderFooter;
import com.tencent.mobileqq.qqguildsdk.api.IGPSService;
import com.tencent.mobileqq.qqguildsdk.api.IGProSession;
import com.tencent.mobileqq.qqguildsdk.data.IGProGuildInfo;
import com.tencent.mobileqq.qqguildsdk.data.co;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.PageParams;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.dtreport.constants.DTParamKey;
import com.tencent.qqnt.kernelgpro.nativeinterface.IGuildHelperNotifySwitchOperateCallback;
import com.tencent.util.Pair;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import mqq.app.Constants;
import mqq.app.MobileQQ;
import mqq.app.api.IRuntimeService;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0087\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u000b*\u0001\u000e\u0018\u0000 L2\u00020\u00012\u00020\u0002:\u0001MB\u0013\u0012\n\b\u0002\u0010,\u001a\u0004\u0018\u00010)\u00a2\u0006\u0004\bJ\u0010KJ\b\u0010\u0004\u001a\u00020\u0003H\u0002J\b\u0010\u0005\u001a\u00020\u0003H\u0002J\b\u0010\u0006\u001a\u00020\u0003H\u0002J\b\u0010\u0007\u001a\u00020\u0003H\u0002J\u0018\u0010\u000b\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\bH\u0002J\u0018\u0010\r\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\bH\u0002J\u000f\u0010\u000f\u001a\u00020\u000eH\u0002\u00a2\u0006\u0004\b\u000f\u0010\u0010J\u0010\u0010\u0013\u001a\u00020\u00032\u0006\u0010\u0012\u001a\u00020\u0011H\u0002J\b\u0010\u0014\u001a\u00020\u0003H\u0002J$\u0010\u001b\u001a\u00020\u00032\u0006\u0010\u0016\u001a\u00020\u00152\b\u0010\u0018\u001a\u0004\u0018\u00010\u00172\b\u0010\u001a\u001a\u0004\u0018\u00010\u0019H\u0014J\b\u0010\u001c\u001a\u00020\u0011H\u0016J\b\u0010\u001e\u001a\u00020\u001dH\u0014J\b\u0010\u001f\u001a\u00020\u001dH\u0014J\b\u0010 \u001a\u00020\u0003H\u0016J\b\u0010!\u001a\u00020\u0003H\u0016J\u0016\u0010%\u001a\u00020\u00032\f\u0010$\u001a\b\u0012\u0004\u0012\u00020#0\"H\u0016J\u0006\u0010&\u001a\u00020\u0003J\b\u0010'\u001a\u00020\u0011H\u0016J\b\u0010(\u001a\u00020\u0011H\u0016R\u0018\u0010,\u001a\u0004\u0018\u00010)8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b*\u0010+R\u0016\u00100\u001a\u00020-8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b.\u0010/R\u0016\u00104\u001a\u0002018\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b2\u00103R\u0016\u00108\u001a\u0002058\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b6\u00107R\u001c\u0010=\u001a\b\u0012\u0004\u0012\u00020:098\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b;\u0010<R\u001d\u0010B\u001a\u0004\u0018\u00010\u001d8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b>\u0010?\u001a\u0004\b@\u0010AR\u0016\u0010F\u001a\u00020C8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bD\u0010ER\u0016\u0010I\u001a\u00020:8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bG\u0010H\u00a8\u0006N"}, d2 = {"Lcom/tencent/mobileqq/guild/inbox/centerpanel/assistant/GuildAssistantFragment;", "Lcom/tencent/mobileqq/guild/base/QQGuildTitleBarFragment;", "Lcom/tencent/mobileqq/guild/message/directmessage/model/repositories/m;", "", "Qh", "initView", "Sh", "initData", "", "guildId", "url", "Ph", "joinSign", "Oh", "com/tencent/mobileqq/guild/inbox/centerpanel/assistant/GuildAssistantFragment$b", "Mh", "()Lcom/tencent/mobileqq/guild/inbox/centerpanel/assistant/GuildAssistantFragment$b;", "", "isNoDisturb", "Vh", "Wh", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", ParseCommon.CONTAINER, "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, "doOnCreateView", "onBackEvent", "", "getContentLayoutId", "ph", "onPostThemeChanged", MosaicConstants$JsFunction.FUNC_ON_DESTROY, "", "Lcom/tencent/mobileqq/guild/message/directmessage/model/data/b;", "list", "d9", "Uh", "needStatusTrans", "needImmersive", "Lcom/tencent/mobileqq/guild/mainframe/i;", "T", "Lcom/tencent/mobileqq/guild/mainframe/i;", "mainViewContext", "Landroid/view/View;", "U", "Landroid/view/View;", "mLoadingView", "Lcom/tencent/mobileqq/guild/widget/OverScrollRecyclerViewWithHeaderFooter;", "V", "Lcom/tencent/mobileqq/guild/widget/OverScrollRecyclerViewWithHeaderFooter;", "mListView", "Landroid/widget/LinearLayout;", "W", "Landroid/widget/LinearLayout;", "mEmptyView", "Lcom/tencent/mobileqq/guild/widget/RecyclerViewWithHeaderFooter$c;", "Lcom/tencent/mobileqq/guild/inbox/centerpanel/assistant/b;", "X", "Lcom/tencent/mobileqq/guild/widget/RecyclerViewWithHeaderFooter$c;", "mFooterAdapter", "Y", "Lkotlin/Lazy;", "Nh", "()Ljava/lang/Integer;", "fragmentType", "Lcom/tencent/mobileqq/guild/inbox/centerpanel/assistant/h;", "Z", "Lcom/tencent/mobileqq/guild/inbox/centerpanel/assistant/h;", "mViewModel", "a0", "Lcom/tencent/mobileqq/guild/inbox/centerpanel/assistant/b;", "mAdapter", "<init>", "(Lcom/tencent/mobileqq/guild/mainframe/i;)V", "b0", "a", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class GuildAssistantFragment extends QQGuildTitleBarFragment implements m {

    /* renamed from: b0, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: T, reason: from kotlin metadata */
    @Nullable
    private com.tencent.mobileqq.guild.mainframe.i mainViewContext;

    /* renamed from: U, reason: from kotlin metadata */
    private View mLoadingView;

    /* renamed from: V, reason: from kotlin metadata */
    private OverScrollRecyclerViewWithHeaderFooter mListView;

    /* renamed from: W, reason: from kotlin metadata */
    private LinearLayout mEmptyView;

    /* renamed from: X, reason: from kotlin metadata */
    private RecyclerViewWithHeaderFooter.c<com.tencent.mobileqq.guild.inbox.centerpanel.assistant.b> mFooterAdapter;

    /* renamed from: Y, reason: from kotlin metadata */
    @NotNull
    private final Lazy fragmentType;

    /* renamed from: Z, reason: from kotlin metadata */
    @NotNull
    private h mViewModel;

    /* renamed from: a0, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private com.tencent.mobileqq.guild.inbox.centerpanel.assistant.b mAdapter;

    /* compiled from: P */
    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\b\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0013\u0010\u0014J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006R\u0014\u0010\u000b\u001a\u00020\n8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\fR\u0014\u0010\u000e\u001a\u00020\r8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\u000fR\u0014\u0010\u0010\u001a\u00020\r8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\u000fR\u0014\u0010\u0011\u001a\u00020\n8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\fR\u0014\u0010\u0012\u001a\u00020\n8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\f\u00a8\u0006\u0015"}, d2 = {"Lcom/tencent/mobileqq/guild/inbox/centerpanel/assistant/GuildAssistantFragment$a;", "", "Lcom/tencent/mobileqq/guild/mainframe/i;", "mainViewContext", "Lcom/tencent/mobileqq/guild/inbox/centerpanel/assistant/GuildAssistantFragment;", "a", "Landroid/content/Context;", "context", "", "b", "", "FRAGMENT_TAG", "Ljava/lang/String;", "", "FRAG_TYPE_IN_MAIN_FRAME_PANEL", "I", "FRAG_TYPE_SINGLE_PAGE", "KEY_FRAG_TYPE", "TAG", "<init>", "()V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.guild.inbox.centerpanel.assistant.GuildAssistantFragment$a, reason: from kotlin metadata */
    /* loaded from: classes13.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final GuildAssistantFragment a(@NotNull com.tencent.mobileqq.guild.mainframe.i mainViewContext) {
            Intrinsics.checkNotNullParameter(mainViewContext, "mainViewContext");
            GuildAssistantFragment guildAssistantFragment = new GuildAssistantFragment(mainViewContext);
            Bundle bundle = new Bundle();
            bundle.putInt("key_fragment_type", 1);
            guildAssistantFragment.setArguments(bundle);
            return guildAssistantFragment;
        }

        public final void b(@NotNull Context context) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intent intent = new Intent();
            if (!(context instanceof Activity)) {
                intent.addFlags(268435456);
            }
            Bundle bundle = new Bundle();
            bundle.putInt("key_fragment_type", 2);
            intent.putExtras(bundle);
            GuildSplitViewUtils.p(GuildSplitViewUtils.f235370a, context, intent, GuildAssistantFragment.class, null, 8, null);
        }

        Companion() {
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016\u00a8\u0006\b"}, d2 = {"com/tencent/mobileqq/guild/inbox/centerpanel/assistant/GuildAssistantFragment$b", "Landroidx/recyclerview/widget/RecyclerView$OnScrollListener;", "Landroidx/recyclerview/widget/RecyclerView;", "recyclerView", "", "newState", "", "onScrollStateChanged", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes13.dex */
    public static final class b extends RecyclerView.OnScrollListener {
        b() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(@NotNull RecyclerView recyclerView, int newState) {
            Intrinsics.checkNotNullParameter(recyclerView, "recyclerView");
            if (newState != 0) {
                return;
            }
            RecyclerView.LayoutManager layoutManager = recyclerView.getLayoutManager();
            if (!(layoutManager instanceof LinearLayoutManager)) {
                return;
            }
            if (GuildAssistantFragment.this.mAdapter.getNUM_BACKGOURND_ICON() - ((LinearLayoutManager) layoutManager).findLastVisibleItemPosition() < 10 && !GuildAssistantFragment.this.mViewModel.getMIsEnd()) {
                GuildAssistantFragment.this.mViewModel.loadMore();
            }
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\f\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u0003\"\u0006\b\u0000\u0010\u0000\u0018\u00012\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00018\u00008\u0000H\n\u00a2\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"T", "kotlin.jvm.PlatformType", "it", "", "onChanged", "(Ljava/lang/Object;)V", "<anonymous>"}, k = 3, mv = {1, 7, 1})
    /* loaded from: classes13.dex */
    public static final class c<T> implements Observer {
        public c() {
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // androidx.lifecycle.Observer
        public final void onChanged(T t16) {
            boolean z16;
            ArrayList<co> it = (ArrayList) t16;
            int i3 = 0;
            if (it != null && !it.isEmpty()) {
                z16 = false;
            } else {
                z16 = true;
            }
            OverScrollRecyclerViewWithHeaderFooter overScrollRecyclerViewWithHeaderFooter = null;
            if (z16) {
                LinearLayout linearLayout = GuildAssistantFragment.this.mEmptyView;
                if (linearLayout == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mEmptyView");
                    linearLayout = null;
                }
                final GuildAssistantFragment guildAssistantFragment = GuildAssistantFragment.this;
                linearLayout.postDelayed(new Runnable() { // from class: com.tencent.mobileqq.guild.inbox.centerpanel.assistant.GuildAssistantFragment$initData$1$1
                    @Override // java.lang.Runnable
                    public final void run() {
                        boolean z17;
                        LinearLayout linearLayout2 = GuildAssistantFragment.this.mEmptyView;
                        if (linearLayout2 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("mEmptyView");
                            linearLayout2 = null;
                        }
                        ArrayList<co> value = GuildAssistantFragment.this.mViewModel.c2().getValue();
                        int i16 = 0;
                        if (value != null && !value.isEmpty()) {
                            z17 = false;
                        } else {
                            z17 = true;
                        }
                        if (!z17) {
                            i16 = 8;
                        }
                        linearLayout2.setVisibility(i16);
                    }
                }, 1000L);
            } else {
                LinearLayout linearLayout2 = GuildAssistantFragment.this.mEmptyView;
                if (linearLayout2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mEmptyView");
                    linearLayout2 = null;
                }
                linearLayout2.setVisibility(8);
            }
            OverScrollRecyclerViewWithHeaderFooter overScrollRecyclerViewWithHeaderFooter2 = GuildAssistantFragment.this.mListView;
            if (overScrollRecyclerViewWithHeaderFooter2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mListView");
            } else {
                overScrollRecyclerViewWithHeaderFooter = overScrollRecyclerViewWithHeaderFooter2;
            }
            Intrinsics.checkNotNullExpressionValue(it, "it");
            if (!(true ^ it.isEmpty())) {
                i3 = 8;
            }
            overScrollRecyclerViewWithHeaderFooter.setVisibility(i3);
            GuildAssistantFragment.this.mAdapter.k0(it);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\f\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u0003\"\u0006\b\u0000\u0010\u0000\u0018\u00012\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00018\u00008\u0000H\n\u00a2\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"T", "kotlin.jvm.PlatformType", "it", "", "onChanged", "(Ljava/lang/Object;)V", "<anonymous>"}, k = 3, mv = {1, 7, 1})
    /* loaded from: classes13.dex */
    public static final class d<T> implements Observer {
        public d() {
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // androidx.lifecycle.Observer
        public final void onChanged(T t16) {
            int i3;
            Boolean it = (Boolean) t16;
            View view = GuildAssistantFragment.this.mLoadingView;
            if (view == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mLoadingView");
                view = null;
            }
            Intrinsics.checkNotNullExpressionValue(it, "it");
            if (it.booleanValue()) {
                i3 = 0;
            } else {
                i3 = 8;
            }
            view.setVisibility(i3);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\f\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u0003\"\u0006\b\u0000\u0010\u0000\u0018\u00012\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00018\u00008\u0000H\n\u00a2\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"T", "kotlin.jvm.PlatformType", "it", "", "onChanged", "(Ljava/lang/Object;)V", "<anonymous>"}, k = 3, mv = {1, 7, 1})
    /* loaded from: classes13.dex */
    public static final class e<T> implements Observer {
        public e() {
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // androidx.lifecycle.Observer
        public final void onChanged(T t16) {
            Integer it = (Integer) t16;
            Intrinsics.checkNotNullExpressionValue(it, "it");
            if (it.intValue() >= 0 && it.intValue() < GuildAssistantFragment.this.mAdapter.getNUM_BACKGOURND_ICON()) {
                GuildAssistantFragment.this.mAdapter.notifyItemChanged(it.intValue());
            }
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0004"}, d2 = {"com/tencent/mobileqq/guild/inbox/centerpanel/assistant/GuildAssistantFragment$f", "Lkv1/a;", "", "a", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes13.dex */
    public static final class f implements kv1.a {
        f() {
        }

        @Override // kv1.a
        public void a() {
            if (GuildAssistantFragment.this.mAdapter.getNUM_BACKGOURND_ICON() > 0) {
                com.tencent.mobileqq.guild.performance.report.d.b(GuildAssistantFragment.this.mAdapter.getNUM_BACKGOURND_ICON());
                OverScrollRecyclerViewWithHeaderFooter overScrollRecyclerViewWithHeaderFooter = GuildAssistantFragment.this.mListView;
                if (overScrollRecyclerViewWithHeaderFooter == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mListView");
                    overScrollRecyclerViewWithHeaderFooter = null;
                }
                overScrollRecyclerViewWithHeaderFooter.O();
            }
        }
    }

    public GuildAssistantFragment() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    private final b Mh() {
        return new b();
    }

    private final Integer Nh() {
        return (Integer) this.fragmentType.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Oh(String guildId, String joinSign) {
        QBaseActivity qBaseActivity;
        GuildCenterPanelController Z0;
        Logger logger = Logger.f235387a;
        if (QLog.isColorLevel()) {
            logger.d().d("Guild.C2C.GuildAssistantFragment", 2, "handleJumpTargetGuild guildId:" + guildId + ", joinSign:" + joinSign);
        }
        Integer Nh = Nh();
        if (Nh != null && Nh.intValue() == 1) {
            Pair<String, String> b16 = QQGuildJumpSource.b(246619, "Guild.C2C.GuildAssistantFragment");
            Intrinsics.checkNotNullExpressionValue(b16, "getSourceInfoByFrom(GPro\u2026SOURCE_GUILD_NOTICE, TAG)");
            com.tencent.mobileqq.guild.mainframe.i iVar = this.mainViewContext;
            if (iVar != null) {
                qBaseActivity = iVar.getActivity();
            } else {
                qBaseActivity = null;
            }
            String str = b16.first;
            Intrinsics.checkNotNullExpressionValue(str, "sourceInfo.first");
            String str2 = b16.second;
            Intrinsics.checkNotNullExpressionValue(str2, "sourceInfo.second");
            GuildJumpUtil.l(qBaseActivity, guildId, "", joinSign, str, str2, null, null, 192, null);
            com.tencent.mobileqq.guild.mainframe.i iVar2 = this.mainViewContext;
            if (iVar2 != null && (Z0 = iVar2.Z0()) != null) {
                Z0.y(2);
                return;
            }
            return;
        }
        if (Nh != null && Nh.intValue() == 2) {
            Pair<String, String> b17 = QQGuildJumpSource.b(246619, "Guild.C2C.GuildAssistantFragment");
            Intrinsics.checkNotNullExpressionValue(b17, "getSourceInfoByFrom(GPro\u2026SOURCE_GUILD_NOTICE, TAG)");
            FragmentActivity activity = getActivity();
            String str3 = b17.first;
            Intrinsics.checkNotNullExpressionValue(str3, "sourceInfo.first");
            String str4 = b17.second;
            Intrinsics.checkNotNullExpressionValue(str4, "sourceInfo.second");
            GuildJumpUtil.l(activity, guildId, "", joinSign, str3, str4, null, null, 192, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:7:0x0042, code lost:
    
        if (r5.getIsBanned() == true) goto L11;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void Ph(String guildId, String url) {
        boolean z16;
        Logger logger = Logger.f235387a;
        if (QLog.isColorLevel()) {
            logger.d().d("Guild.C2C.GuildAssistantFragment", 2, "handleJumpTargetH5 url:" + url);
        }
        IRuntimeService S0 = ch.S0(IGPSService.class, "");
        Intrinsics.checkNotNullExpressionValue(S0, "runtimeService(java, process)");
        IGProGuildInfo guildInfo = ((IGPSService) S0).getGuildInfo(guildId);
        if (guildInfo != null) {
            z16 = true;
        }
        z16 = false;
        if (z16) {
            QQToast.makeText(getActivity(), getString(R.string.f139760c5), 0).show();
        } else {
            GuildJumpUtil.w(getActivity(), url);
        }
    }

    private final void Qh() {
        rh();
        setTitle(getResources().getString(R.string.f157561n9));
        wh(R.drawable.qui_more, new View.OnClickListener() { // from class: com.tencent.mobileqq.guild.inbox.centerpanel.assistant.d
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                GuildAssistantFragment.Rh(GuildAssistantFragment.this, view);
            }
        });
        GuildSplitViewUtils.f235370a.B(this.N);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Rh(GuildAssistantFragment this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.Sh();
        EventCollector.getInstance().onViewClicked(view);
    }

    private final void Sh() {
        AppInterface appInterface;
        uh2.c gProGuildMsgService;
        DialogFragment a16 = k.INSTANCE.a(7);
        FragmentManager parentFragmentManager = getParentFragmentManager();
        Intrinsics.checkNotNullExpressionValue(parentFragmentManager, "parentFragmentManager");
        com.tencent.mobileqq.guild.base.extension.d.a(a16, parentFragmentManager, "Guild.C2C.GuildAssistantFragment");
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        IRuntimeService iRuntimeService = null;
        if (peekAppRuntime instanceof AppInterface) {
            appInterface = (AppInterface) peekAppRuntime;
        } else {
            appInterface = null;
        }
        if (appInterface != null) {
            iRuntimeService = appInterface.getRuntimeService(IGProSession.class, "");
        }
        IGProSession iGProSession = (IGProSession) iRuntimeService;
        if (iGProSession != null && (gProGuildMsgService = iGProSession.getGProGuildMsgService()) != null) {
            gProGuildMsgService.getGuildHelperNotifySwitch(new IGuildHelperNotifySwitchOperateCallback() { // from class: com.tencent.mobileqq.guild.inbox.centerpanel.assistant.e
                @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IGuildHelperNotifySwitchOperateCallback
                public final void onResult(int i3, String str, HashMap hashMap) {
                    GuildAssistantFragment.Th(GuildAssistantFragment.this, i3, str, hashMap);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Th(GuildAssistantFragment this$0, int i3, String str, HashMap hashMap) {
        Integer num;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (i3 == 0 && (num = (Integer) hashMap.get(103)) != null) {
            boolean z16 = true;
            if (num.intValue() != 1) {
                z16 = false;
            }
            this$0.Vh(z16);
        }
    }

    private final void Vh(boolean isNoDisturb) {
        HashMap hashMap = new HashMap();
        hashMap.put("pgid", "pg_sgrp_channelassitant");
        hashMap.put("sgrp_channelassitant_switch", String.valueOf(isNoDisturb));
        VideoReport.setElementId(this.G, "em_sgrp_channelassitant_switch");
        VideoReport.reportEvent("clck", this.G, hashMap);
    }

    private final void Wh() {
        VideoReport.addToDetectionWhitelist(getActivity());
        VideoReport.setPageId(this.N, "pg_sgrp_channelassitant");
        HashMap hashMap = new HashMap();
        hashMap.put(DTParamKey.REPORT_KEY_APPKEY, "0S200MNJT807V3GE");
        VideoReport.setPageParams(this.N, new PageParams(hashMap));
    }

    private final void initData() {
        OverScrollRecyclerViewWithHeaderFooter overScrollRecyclerViewWithHeaderFooter = this.mListView;
        RecyclerViewWithHeaderFooter.c<com.tencent.mobileqq.guild.inbox.centerpanel.assistant.b> cVar = null;
        if (overScrollRecyclerViewWithHeaderFooter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mListView");
            overScrollRecyclerViewWithHeaderFooter = null;
        }
        overScrollRecyclerViewWithHeaderFooter.setLayoutManager(new LinearLayoutManager(getContext()));
        RecyclerViewWithHeaderFooter.c<com.tencent.mobileqq.guild.inbox.centerpanel.assistant.b> cVar2 = new RecyclerViewWithHeaderFooter.c<>(this.mAdapter);
        this.mFooterAdapter = cVar2;
        View view = this.mLoadingView;
        if (view == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mLoadingView");
            view = null;
        }
        cVar2.k0(view);
        OverScrollRecyclerViewWithHeaderFooter overScrollRecyclerViewWithHeaderFooter2 = this.mListView;
        if (overScrollRecyclerViewWithHeaderFooter2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mListView");
            overScrollRecyclerViewWithHeaderFooter2 = null;
        }
        RecyclerViewWithHeaderFooter.c<com.tencent.mobileqq.guild.inbox.centerpanel.assistant.b> cVar3 = this.mFooterAdapter;
        if (cVar3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mFooterAdapter");
        } else {
            cVar = cVar3;
        }
        overScrollRecyclerViewWithHeaderFooter2.setAdapter(cVar);
        MutableLiveData<ArrayList<co>> c26 = this.mViewModel.c2();
        LifecycleOwner viewLifecycleOwner = getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner, "viewLifecycleOwner");
        c26.observe(viewLifecycleOwner, new c());
        MutableLiveData<Boolean> d26 = this.mViewModel.d2();
        LifecycleOwner viewLifecycleOwner2 = getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner2, "viewLifecycleOwner");
        d26.observe(viewLifecycleOwner2, new d());
        MutableLiveData<Integer> e26 = this.mViewModel.e2();
        LifecycleOwner viewLifecycleOwner3 = getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner3, "viewLifecycleOwner");
        e26.observe(viewLifecycleOwner3, new e());
        this.mViewModel.addListener();
        Integer Nh = Nh();
        if (Nh != null && Nh.intValue() == 2) {
            Uh();
        }
    }

    private final void initView() {
        Qh();
        View findViewById = this.P.findViewById(R.id.ztg);
        Intrinsics.checkNotNullExpressionValue(findViewById, "mContentView.findViewById(R.id.notice_list)");
        OverScrollRecyclerViewWithHeaderFooter overScrollRecyclerViewWithHeaderFooter = (OverScrollRecyclerViewWithHeaderFooter) findViewById;
        this.mListView = overScrollRecyclerViewWithHeaderFooter;
        OverScrollRecyclerViewWithHeaderFooter overScrollRecyclerViewWithHeaderFooter2 = null;
        if (overScrollRecyclerViewWithHeaderFooter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mListView");
            overScrollRecyclerViewWithHeaderFooter = null;
        }
        overScrollRecyclerViewWithHeaderFooter.setDrawListener(new f());
        View findViewById2 = this.P.findViewById(R.id.vyu);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "mContentView.findViewByI\u2026d_assistant_empty_layout)");
        this.mEmptyView = (LinearLayout) findViewById2;
        QUIEmptyState.Builder imageType = new QUIEmptyState.Builder(getContext()).setImageType(12);
        String qqStr = HardCodeUtil.qqStr(R.string.f1513917k);
        Intrinsics.checkNotNullExpressionValue(qqStr, "qqStr(R.string.guild_notice_empty_view_text)");
        QUIEmptyState build = imageType.setTitle(qqStr).setHalfScreenState(true).setBackgroundColorType(0).build();
        LinearLayout linearLayout = this.mEmptyView;
        if (linearLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mEmptyView");
            linearLayout = null;
        }
        linearLayout.addView(build);
        View inflate = LayoutInflater.from(getActivity()).inflate(R.layout.eju, (ViewGroup) null);
        Intrinsics.checkNotNullExpressionValue(inflate, "from(activity).inflate(R\u2026common_progressbar, null)");
        this.mLoadingView = inflate;
        OverScrollRecyclerViewWithHeaderFooter overScrollRecyclerViewWithHeaderFooter3 = this.mListView;
        if (overScrollRecyclerViewWithHeaderFooter3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mListView");
            overScrollRecyclerViewWithHeaderFooter3 = null;
        }
        overScrollRecyclerViewWithHeaderFooter3.addOnScrollListener(Mh());
        OverScrollRecyclerViewWithHeaderFooter overScrollRecyclerViewWithHeaderFooter4 = this.mListView;
        if (overScrollRecyclerViewWithHeaderFooter4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mListView");
        } else {
            overScrollRecyclerViewWithHeaderFooter2 = overScrollRecyclerViewWithHeaderFooter4;
        }
        VideoReport.enableAndroidXRVExposure(overScrollRecyclerViewWithHeaderFooter2);
    }

    public final void Uh() {
        this.mViewModel.initData();
    }

    @Override // com.tencent.mobileqq.guild.message.directmessage.model.repositories.m
    public void d9(@NotNull List<InboxNoticeNode> list) {
        boolean z16;
        Object obj;
        boolean z17;
        Intrinsics.checkNotNullParameter(list, "list");
        Iterator<T> it = list.iterator();
        while (true) {
            z16 = false;
            if (it.hasNext()) {
                obj = it.next();
                if (7 == ((InboxNoticeNode) obj).getType()) {
                    z17 = true;
                } else {
                    z17 = false;
                }
                if (z17) {
                    break;
                }
            } else {
                obj = null;
                break;
            }
        }
        InboxNoticeNode inboxNoticeNode = (InboxNoticeNode) obj;
        if (inboxNoticeNode != null && !inboxNoticeNode.getIsVisible()) {
            z16 = true;
        }
        if (z16) {
            Logger.f235387a.d().d("Guild.C2C.GuildAssistantFragment", 1, "[onInboxNoticeNodeChanged] remove guild assistant finish activity");
            FragmentActivity activity = getActivity();
            if (activity != null) {
                activity.finish();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.guild.base.QQGuildTitleBarFragment, com.tencent.mobileqq.guild.base.QQGuildCustomTitleBarFragment
    public void doOnCreateView(@NotNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        com.tencent.mobileqq.guild.performance.report.d.c();
        initView();
        initData();
        Wh();
        InboxNoticeNodeRepository.k(this);
        GuildSplitViewUtils.f235370a.B(this.N);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.guild.base.QQGuildCustomTitleBarFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment
    public int getContentLayoutId() {
        return R.layout.eg6;
    }

    @Override // com.tencent.mobileqq.guild.base.QQGuildCustomTitleBarFragment, com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment
    public boolean needImmersive() {
        return false;
    }

    @Override // com.tencent.mobileqq.guild.base.QQGuildCustomTitleBarFragment, com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment
    public boolean needStatusTrans() {
        return true;
    }

    @Override // com.tencent.mobileqq.guild.base.QQGuildCustomTitleBarFragment, com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, com.tencent.biz.richframework.compat.IFragmentCallbacks
    public boolean onBackEvent() {
        Integer Nh = Nh();
        if (Nh != null && Nh.intValue() == 1) {
            com.tencent.mobileqq.guild.mainframe.i iVar = this.mainViewContext;
            if (iVar != null) {
                iVar.guildCenterPanelInOrOut(2, true);
            }
        } else if (Nh != null && Nh.intValue() == 2) {
            GuildSplitViewUtils.u(GuildSplitViewUtils.f235370a, getActivity(), false, 2, null);
            return true;
        }
        return false;
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        this.mViewModel.removeListener();
        InboxNoticeNodeRepository.z(this);
    }

    @Override // com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, com.tencent.biz.richframework.compat.IFragmentCallbacks
    public void onPostThemeChanged() {
        super.onPostThemeChanged();
        rh();
        yh(ph());
    }

    @Override // com.tencent.mobileqq.guild.base.QQGuildCustomTitleBarFragment
    protected int ph() {
        return R.color.qui_common_bg_bottom_light;
    }

    public GuildAssistantFragment(@Nullable com.tencent.mobileqq.guild.mainframe.i iVar) {
        Lazy lazy;
        this.mainViewContext = iVar;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<Integer>() { // from class: com.tencent.mobileqq.guild.inbox.centerpanel.assistant.GuildAssistantFragment$fragmentType$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @Nullable
            public final Integer invoke() {
                Bundle arguments = GuildAssistantFragment.this.getArguments();
                if (arguments != null) {
                    return Integer.valueOf(arguments.getInt("key_fragment_type", -1));
                }
                return null;
            }
        });
        this.fragmentType = lazy;
        this.mViewModel = new h();
        this.mAdapter = new com.tencent.mobileqq.guild.inbox.centerpanel.assistant.b(new com.tencent.mobileqq.guild.inbox.centerpanel.assistant.c(new GuildAssistantFragment$mAdapter$1(this), new GuildAssistantFragment$mAdapter$2(this)));
    }

    public /* synthetic */ GuildAssistantFragment(com.tencent.mobileqq.guild.mainframe.i iVar, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? null : iVar);
    }
}

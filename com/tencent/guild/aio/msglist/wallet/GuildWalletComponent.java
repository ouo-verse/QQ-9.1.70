package com.tencent.guild.aio.msglist.wallet;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.widget.TextView;
import com.tencent.guild.aio.msglist.checkbox.GuildMultiMsgManager;
import com.tencent.guild.aio.msglist.holder.component.nick.GuildMsgNickState;
import com.tencent.guild.aio.msglist.holder.component.s;
import com.tencent.guild.aio.util.ex.FromScene;
import com.tencent.guild.api.data.msglist.GuildMsgItem;
import com.tencent.guild.api.wallet.IGuildWalletApi;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mvi.base.mvi.MviUIState;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsJVMKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000l\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 -2\u00020\u0001:\u0001.B\u000f\u0012\u0006\u0010*\u001a\u00020\u000b\u00a2\u0006\u0004\b+\u0010,J&\u0010\n\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006H\u0016J\b\u0010\f\u001a\u00020\u000bH\u0016J\u0010\u0010\u000f\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\rH\u0016J\u0014\u0010\u0013\u001a\u000e\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u00120\u0010H\u0016J\u0010\u0010\u0015\u001a\u00020\t2\u0006\u0010\u0014\u001a\u00020\u0012H\u0016J\u0016\u0010\u0019\u001a\u0010\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u00180\u00170\u0016H\u0016J\b\u0010\u001b\u001a\u00020\u001aH\u0016R\u001b\u0010 \u001a\u00020\u000b8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u001e\u0010\u001fR\u0018\u0010$\u001a\u0004\u0018\u00010!8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\"\u0010#R$\u0010)\u001a\u0012\u0012\u0004\u0012\u00020\u001a0%j\b\u0012\u0004\u0012\u00020\u001a`&8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b'\u0010(\u00a8\u0006/"}, d2 = {"Lcom/tencent/guild/aio/msglist/wallet/GuildWalletComponent;", "Lcom/tencent/guild/aio/msglist/holder/component/a;", "", "position", "Lcom/tencent/aio/data/msglist/a;", "msgItem", "", "", "payloads", "", "b1", "Landroid/view/View;", "d1", "Lcom/tencent/mvi/api/help/a;", "createViewParams", "onCreateView", "Lcom/tencent/aio/base/mvvm/b;", "Lol3/b;", "Lcom/tencent/mvi/base/mvi/MviUIState;", "e1", "state", "handleUIState", "", "Ljava/lang/Class;", "Lcom/tencent/guild/aio/msglist/holder/component/nick/GuildMsgNickState;", "getObserverStates", "", "getTag", "f", "Lkotlin/Lazy;", "k1", "()Landroid/view/View;", "contentView", "Lcom/tencent/guild/api/wallet/a;", h.F, "Lcom/tencent/guild/api/wallet/a;", "viewHolder", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "i", "Ljava/util/ArrayList;", "specifyUinList", "root", "<init>", "(Landroid/view/View;)V", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "a", "aio-guild_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes6.dex */
public final class GuildWalletComponent extends com.tencent.guild.aio.msglist.holder.component.a {

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy contentView;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private com.tencent.guild.api.wallet.a viewHolder;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final ArrayList<String> specifyUinList;

    public GuildWalletComponent(@NotNull final View root) {
        Lazy lazy;
        Intrinsics.checkNotNullParameter(root, "root");
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<View>() { // from class: com.tencent.guild.aio.msglist.wallet.GuildWalletComponent$contentView$2
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final View invoke() {
                return ((IGuildWalletApi) QRoute.api(IGuildWalletApi.class)).createWalletContentView(root);
            }
        });
        this.contentView = lazy;
        this.specifyUinList = new ArrayList<>();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void j1(GuildWalletComponent this$0, TextView this_apply, com.tencent.guild.api.wallet.a viewHolder, View view) {
        Activity activity;
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(this_apply, "$this_apply");
        Intrinsics.checkNotNullParameter(viewHolder, "$viewHolder");
        Context mContext = this$0.getMContext();
        String str = null;
        if (mContext instanceof Activity) {
            activity = (Activity) mContext;
        } else {
            activity = null;
        }
        if (activity != null) {
            Object tag = this_apply.getTag();
            if (tag instanceof String) {
                str = (String) tag;
            }
            if (str != null) {
                viewHolder.e(activity, str);
            }
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    private final View k1() {
        return (View) this.contentView.getValue();
    }

    @Override // com.tencent.guild.aio.msglist.holder.component.a
    public void b1(int position, @NotNull final com.tencent.aio.data.msglist.a msgItem, @NotNull List<Object> payloads) {
        Intrinsics.checkNotNullParameter(msgItem, "msgItem");
        Intrinsics.checkNotNullParameter(payloads, "payloads");
        QLog.d("GuildWalletComponent", 4, "bind " + this);
        QRouteApi api = QRoute.api(IGuildWalletApi.class);
        Intrinsics.checkNotNullExpressionValue(api, "api(IGuildWalletApi::class.java)");
        final com.tencent.guild.api.wallet.a a16 = IGuildWalletApi.a.a((IGuildWalletApi) api, (GuildMsgItem) msgItem, k1(), false, 4, null);
        final View background = a16.getBackground();
        if (background != null) {
            final long j3 = 200;
            background.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.guild.aio.msglist.wallet.GuildWalletComponent$bind$$inlined$setSingleClickListener$1
                @Override // android.view.View.OnClickListener
                public final void onClick(View it) {
                    int ordinal;
                    EventCollector.getInstance().onViewClickedBefore(it);
                    background.setClickable(false);
                    Intrinsics.checkNotNullExpressionValue(it, "it");
                    if (fo0.b.c(this.f1())) {
                        QLog.i("GuildWalletComponent", 1, "interceptOperationWhenInGuestInputMode");
                    } else {
                        String str = ((GuildMsgItem) msgItem).getMsgRecord().channelId;
                        Intrinsics.checkNotNullExpressionValue(str, "msgItem.msgRecord.channelId");
                        Activity activity = null;
                        com.tencent.aio.api.runtime.a context = new s.AioContextWrapper(null, 1, null).getContext();
                        if (context != null) {
                            ordinal = com.tencent.guild.aio.util.ex.a.d(context);
                        } else {
                            ordinal = FromScene.DEFAULT.ordinal();
                        }
                        if (!GuildMultiMsgManager.INSTANCE.a().i(new GuildMultiMsgManager.d(str, ordinal))) {
                            Context mContext = this.getMContext();
                            if (mContext instanceof Activity) {
                                activity = (Activity) mContext;
                            }
                            if (activity != null) {
                                a16.c(activity);
                            }
                        }
                    }
                    final View view = background;
                    view.postDelayed(new Runnable() { // from class: com.tencent.guild.aio.msglist.wallet.GuildWalletComponent$bind$$inlined$setSingleClickListener$1.1
                        @Override // java.lang.Runnable
                        public final void run() {
                            view.setClickable(true);
                        }
                    }, j3);
                    EventCollector.getInstance().onViewClicked(it);
                }
            });
        }
        final TextView a17 = a16.a();
        if (a17 != null) {
            a17.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.guild.aio.msglist.wallet.a
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    GuildWalletComponent.j1(GuildWalletComponent.this, a17, a16, view);
                }
            });
        }
        this.specifyUinList.clear();
        this.specifyUinList.addAll(a16.d());
        this.viewHolder = a16;
    }

    @Override // com.tencent.guild.aio.msglist.holder.component.a
    @NotNull
    public View d1() {
        return k1();
    }

    @Override // com.tencent.guild.aio.msglist.holder.component.a, com.tencent.mvi.mvvm.framework.FrameworkVB
    @NotNull
    /* renamed from: e1 */
    public com.tencent.aio.base.mvvm.b<ol3.b, MviUIState> createVM() {
        return new b();
    }

    @Override // com.tencent.mvi.mvvm.framework.FrameworkVB
    @NotNull
    public List<Class<? extends GuildMsgNickState>> getObserverStates() {
        List<Class<? extends GuildMsgNickState>> listOf;
        listOf = CollectionsKt__CollectionsJVMKt.listOf(GuildMsgNickState.class);
        return listOf;
    }

    @Override // com.tencent.guild.aio.msglist.holder.component.a
    @NotNull
    public String getTag() {
        return "GuildWalletComponent";
    }

    @Override // com.tencent.mvi.mvvm.BaseVB
    public void handleUIState(@NotNull MviUIState state) {
        boolean contains;
        com.tencent.guild.api.wallet.a aVar;
        Intrinsics.checkNotNullParameter(state, "state");
        if (state instanceof GuildMsgNickState) {
            GuildMsgNickState guildMsgNickState = (GuildMsgNickState) state;
            if (guildMsgNickState.getUpdateType() == 1) {
                contains = CollectionsKt___CollectionsKt.contains(this.specifyUinList, guildMsgNickState.getTinyId());
                if (contains && (aVar = this.viewHolder) != null) {
                    aVar.b();
                    return;
                }
                return;
            }
            return;
        }
        if (state instanceof GuildWalletHbApngUiState) {
            ((IGuildWalletApi) QRoute.api(IGuildWalletApi.class)).changeGuildWalletApngState(((GuildWalletHbApngUiState) state).getPlay());
        }
    }

    @Override // com.tencent.mvi.mvvm.b
    @NotNull
    public View onCreateView(@NotNull com.tencent.mvi.api.help.a createViewParams) {
        Intrinsics.checkNotNullParameter(createViewParams, "createViewParams");
        View containerView = getContainerView();
        Intrinsics.checkNotNull(containerView);
        return containerView;
    }
}

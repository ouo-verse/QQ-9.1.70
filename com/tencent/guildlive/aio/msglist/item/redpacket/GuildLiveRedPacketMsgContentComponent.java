package com.tencent.guildlive.aio.msglist.item.redpacket;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.widget.TextView;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.guild.aio.msglist.holder.component.s;
import com.tencent.guild.api.channel.IGuildChannelApi;
import com.tencent.guild.api.data.msglist.GuildMsgItem;
import com.tencent.guild.api.wallet.IGuildWalletApi;
import com.tencent.guildlive.aio.msglist.holder.component.AbsGuildLiveComponent;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010!\n\u0002\u0010\u0000\n\u0002\b\u0010\u0018\u0000 \u001f2\u00020\u0001:\u0001 B\u000f\u0012\u0006\u0010\u0018\u001a\u00020\u000b\u00a2\u0006\u0004\b\u001d\u0010\u001eJ\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0018\u0010\n\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\f\u001a\u00020\u000bH\u0016J&\u0010\u0013\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0005\u001a\u00020\u000f2\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00110\u0010H\u0016R\u0017\u0010\u0018\u001a\u00020\u000b8\u0006\u00a2\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017R\u001b\u0010\u001c\u001a\u00020\u000b8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u001b\u0010\u0017\u00a8\u0006!"}, d2 = {"Lcom/tencent/guildlive/aio/msglist/item/redpacket/GuildLiveRedPacketMsgContentComponent;", "Lcom/tencent/guildlive/aio/msglist/holder/component/AbsGuildLiveComponent;", "Lcom/tencent/guild/api/wallet/a;", "viewHolder", "Lcom/tencent/guild/api/data/msglist/GuildMsgItem;", "msgItem", "", "L1", "Landroid/widget/TextView;", "textView", "J1", "Landroid/view/View;", "d1", "", "position", "Lcom/tencent/aio/data/msglist/a;", "", "", "payloads", "b1", "D", "Landroid/view/View;", "getRoot", "()Landroid/view/View;", "root", "E", "Lkotlin/Lazy;", "M1", "contentView", "<init>", "(Landroid/view/View;)V", UserInfo.SEX_FEMALE, "a", "aio-guild-live_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes6.dex */
public final class GuildLiveRedPacketMsgContentComponent extends AbsGuildLiveComponent {

    /* renamed from: D, reason: from kotlin metadata */
    @NotNull
    private final View root;

    /* renamed from: E, reason: from kotlin metadata */
    @NotNull
    private final Lazy contentView;

    public GuildLiveRedPacketMsgContentComponent(@NotNull View root) {
        Lazy lazy;
        Intrinsics.checkNotNullParameter(root, "root");
        this.root = root;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<View>() { // from class: com.tencent.guildlive.aio.msglist.item.redpacket.GuildLiveRedPacketMsgContentComponent$contentView$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final View invoke() {
                return ((IGuildWalletApi) QRoute.api(IGuildWalletApi.class)).createWalletContentView(GuildLiveRedPacketMsgContentComponent.this.getRoot());
            }
        });
        this.contentView = lazy;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void I1(GuildLiveRedPacketMsgContentComponent this$0, com.tencent.guild.api.wallet.a viewHolder, com.tencent.aio.data.msglist.a msgItem, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(viewHolder, "$viewHolder");
        Intrinsics.checkNotNullParameter(msgItem, "$msgItem");
        this$0.L1(viewHolder, (GuildMsgItem) msgItem);
        EventCollector.getInstance().onViewClicked(view);
    }

    private final void J1(TextView textView, final com.tencent.guild.api.wallet.a viewHolder) {
        textView.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.guildlive.aio.msglist.item.redpacket.b
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                GuildLiveRedPacketMsgContentComponent.K1(GuildLiveRedPacketMsgContentComponent.this, viewHolder, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void K1(GuildLiveRedPacketMsgContentComponent this$0, com.tencent.guild.api.wallet.a viewHolder, View view) {
        Activity activity;
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(viewHolder, "$viewHolder");
        Context mContext = this$0.getMContext();
        String str = null;
        if (mContext instanceof Activity) {
            activity = (Activity) mContext;
        } else {
            activity = null;
        }
        if (activity != null) {
            Object tag = view.getTag();
            if (tag instanceof String) {
                str = (String) tag;
            }
            if (str != null) {
                viewHolder.e(activity, str);
            }
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    private final void L1(com.tencent.guild.api.wallet.a viewHolder, GuildMsgItem msgItem) {
        IGuildChannelApi iGuildChannelApi = (IGuildChannelApi) QRoute.api(IGuildChannelApi.class);
        String str = msgItem.getMsgRecord().channelId;
        Intrinsics.checkNotNullExpressionValue(str, "msgItem.msgRecord.channelId");
        String str2 = msgItem.getMsgRecord().guildId;
        Intrinsics.checkNotNullExpressionValue(str2, "msgItem.msgRecord.guildId");
        boolean isSelfGuest = iGuildChannelApi.isSelfGuest(str, str2);
        Activity activity = null;
        if (isSelfGuest) {
            s.AioContextWrapper aioContextWrapper = new s.AioContextWrapper(null, 1, null);
            sendIntent(new s.GetAioContext(aioContextWrapper));
            com.tencent.aio.api.runtime.a context = aioContextWrapper.getContext();
            if (context != null) {
                fo0.b.c(context);
                return;
            }
            return;
        }
        Context mContext = getMContext();
        if (mContext instanceof Activity) {
            activity = (Activity) mContext;
        }
        if (activity == null) {
            return;
        }
        viewHolder.c(activity);
    }

    private final View M1() {
        return (View) this.contentView.getValue();
    }

    @Override // com.tencent.guildlive.aio.msglist.holder.component.AbsGuildLiveComponent, com.tencent.guild.aio.msglist.holder.component.a
    public void b1(int position, @NotNull final com.tencent.aio.data.msglist.a msgItem, @NotNull List<Object> payloads) {
        Intrinsics.checkNotNullParameter(msgItem, "msgItem");
        Intrinsics.checkNotNullParameter(payloads, "payloads");
        super.b1(position, msgItem, payloads);
        if (msgItem instanceof GuildMsgItem) {
            final com.tencent.guild.api.wallet.a createGuildWalletHolder = ((IGuildWalletApi) QRoute.api(IGuildWalletApi.class)).createGuildWalletHolder((GuildMsgItem) msgItem, M1(), true);
            View background = createGuildWalletHolder.getBackground();
            if (background != null) {
                background.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.guildlive.aio.msglist.item.redpacket.a
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        GuildLiveRedPacketMsgContentComponent.I1(GuildLiveRedPacketMsgContentComponent.this, createGuildWalletHolder, msgItem, view);
                    }
                });
            }
            TextView a16 = createGuildWalletHolder.a();
            if (a16 != null) {
                J1(a16, createGuildWalletHolder);
            }
        }
    }

    @Override // com.tencent.guild.aio.msglist.holder.component.a
    @NotNull
    public View d1() {
        return M1();
    }

    @NotNull
    public final View getRoot() {
        return this.root;
    }
}

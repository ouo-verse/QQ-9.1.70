package com.tencent.guildlive.aio.msglist.holder.component;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.common.app.AppInterface;
import com.tencent.guild.api.data.msglist.GuildMsgItem;
import com.tencent.guildlive.aio.msglist.holder.component.f;
import com.tencent.mobileqq.guild.widget.GuildUserAvatarView;
import com.tencent.mobileqq.qqguildsdk.api.IGPSService;
import com.tencent.mobileqq.qqguildsdk.data.IGProChannelInfo;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.HashMap;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.app.api.IRuntimeService;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010!\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000f\b\u0016\u0018\u0000 \u001e2\u00020\u0001:\u0001\u001fB\u000f\u0012\u0006\u0010\u0016\u001a\u00020\u0011\u00a2\u0006\u0004\b\u001c\u0010\u001dJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J&\u0010\f\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\b2\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\n0\tH\u0016J\b\u0010\u000e\u001a\u00020\rH\u0016J\b\u0010\u0010\u001a\u00020\u000fH\u0016R\u0017\u0010\u0016\u001a\u00020\u00118\u0006\u00a2\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015R\u001b\u0010\u001b\u001a\u00020\r8DX\u0084\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0019\u0010\u001a\u00a8\u0006 "}, d2 = {"Lcom/tencent/guildlive/aio/msglist/holder/component/GuildLiveAvatarComponent;", "Lcom/tencent/guildlive/aio/msglist/holder/component/AbsGuildLiveComponent;", "Lcom/tencent/guild/api/data/msglist/GuildMsgItem;", "msgItem", "", "K1", "", "position", "Lcom/tencent/aio/data/msglist/a;", "", "", "payloads", "b1", "Lcom/tencent/mobileqq/guild/widget/GuildUserAvatarView;", "L1", "Lcom/tencent/guildlive/aio/msglist/holder/component/g;", "M1", "Landroid/view/View;", "D", "Landroid/view/View;", "getRoot", "()Landroid/view/View;", "root", "E", "Lkotlin/Lazy;", "N1", "()Lcom/tencent/mobileqq/guild/widget/GuildUserAvatarView;", "avatarView", "<init>", "(Landroid/view/View;)V", UserInfo.SEX_FEMALE, "a", "aio-guild-live_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes6.dex */
public class GuildLiveAvatarComponent extends AbsGuildLiveComponent {

    /* renamed from: D, reason: from kotlin metadata */
    @NotNull
    private final View root;

    /* renamed from: E, reason: from kotlin metadata */
    @NotNull
    private final Lazy avatarView;

    public GuildLiveAvatarComponent(@NotNull View root) {
        Lazy lazy;
        Intrinsics.checkNotNullParameter(root, "root");
        this.root = root;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<GuildUserAvatarView>() { // from class: com.tencent.guildlive.aio.msglist.holder.component.GuildLiveAvatarComponent$avatarView$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final GuildUserAvatarView invoke() {
                GuildUserAvatarView guildUserAvatarView = new GuildUserAvatarView(GuildLiveAvatarComponent.this.getRoot().getContext());
                int dip2px = ViewUtils.dip2px(20.0f);
                guildUserAvatarView.setLayoutParams(new ViewGroup.LayoutParams(dip2px, dip2px));
                yr0.a.q(guildUserAvatarView, "em_aio_profile", null, 4, null);
                return guildUserAvatarView;
            }
        });
        this.avatarView = lazy;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void I1(GuildLiveAvatarComponent this$0, com.tencent.aio.data.msglist.a msgItem, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(msgItem, "$msgItem");
        if (this$0.s1(this$0.root)) {
            Context mContext = this$0.getMContext();
            Intrinsics.checkNotNull(mContext, "null cannot be cast to non-null type android.app.Activity");
            yr0.a.l((Activity) mContext, (GuildMsgItem) msgItem);
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean J1(GuildLiveAvatarComponent this$0, com.tencent.aio.data.msglist.a msgItem, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(msgItem, "$msgItem");
        if (this$0.s1(this$0.root)) {
            this$0.sendIntent(new f.a((GuildMsgItem) msgItem));
            return true;
        }
        return false;
    }

    private final void K1(GuildMsgItem msgItem) {
        AppInterface appInterface;
        IRuntimeService iRuntimeService;
        IGProChannelInfo channelInfo;
        HashMap hashMap = new HashMap();
        String str = msgItem.getMsgRecord().channelId;
        hashMap.put("sgrp_channel_id", msgItem.getMsgRecord().guildId);
        hashMap.put("sgrp_sub_channel_id", str);
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        Integer num = null;
        if (peekAppRuntime instanceof AppInterface) {
            appInterface = (AppInterface) peekAppRuntime;
        } else {
            appInterface = null;
        }
        if (appInterface != null) {
            iRuntimeService = appInterface.getRuntimeService(IGPSService.class, "");
        } else {
            iRuntimeService = null;
        }
        IGPSService iGPSService = (IGPSService) iRuntimeService;
        if (iGPSService != null && (channelInfo = iGPSService.getChannelInfo(str)) != null) {
            num = Integer.valueOf(channelInfo.getType());
        }
        hashMap.put("sgrp_sub_channel_type", num);
        VideoReport.setElementParams(N1(), hashMap);
    }

    @Override // com.tencent.guild.aio.msglist.holder.component.a
    @NotNull
    /* renamed from: L1, reason: merged with bridge method [inline-methods] */
    public GuildUserAvatarView d1() {
        return N1();
    }

    @Override // com.tencent.guildlive.aio.msglist.holder.component.AbsGuildLiveComponent, com.tencent.guild.aio.msglist.holder.component.a
    @NotNull
    /* renamed from: M1, reason: merged with bridge method [inline-methods] */
    public g createVM() {
        return new g();
    }

    @NotNull
    protected final GuildUserAvatarView N1() {
        return (GuildUserAvatarView) this.avatarView.getValue();
    }

    @Override // com.tencent.guildlive.aio.msglist.holder.component.AbsGuildLiveComponent, com.tencent.guild.aio.msglist.holder.component.a
    public void b1(int position, @NotNull final com.tencent.aio.data.msglist.a msgItem, @NotNull List<Object> payloads) {
        Intrinsics.checkNotNullParameter(msgItem, "msgItem");
        Intrinsics.checkNotNullParameter(payloads, "payloads");
        super.b1(position, msgItem, payloads);
        if (msgItem instanceof GuildMsgItem) {
            GuildMsgItem guildMsgItem = (GuildMsgItem) msgItem;
            N1().setAvatarTinyId(guildMsgItem.getMsgRecord().guildId, guildMsgItem.getMsgRecord().senderUid);
            N1().setOnClickListener(new View.OnClickListener() { // from class: com.tencent.guildlive.aio.msglist.holder.component.d
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    GuildLiveAvatarComponent.I1(GuildLiveAvatarComponent.this, msgItem, view);
                }
            });
            N1().setOnLongClickListener(new View.OnLongClickListener() { // from class: com.tencent.guildlive.aio.msglist.holder.component.e
                @Override // android.view.View.OnLongClickListener
                public final boolean onLongClick(View view) {
                    boolean J1;
                    J1 = GuildLiveAvatarComponent.J1(GuildLiveAvatarComponent.this, msgItem, view);
                    return J1;
                }
            });
            K1(guildMsgItem);
        }
    }

    @NotNull
    public final View getRoot() {
        return this.root;
    }
}

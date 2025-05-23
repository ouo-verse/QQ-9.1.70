package com.tencent.guild.aio.component.combinestyle;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.common.app.AppInterface;
import com.tencent.guild.aio.component.combinestyle.n;
import com.tencent.guild.api.data.msglist.GuildMsgItem;
import com.tencent.mobileqq.guild.widget.GuildUserAvatarView;
import com.tencent.mobileqq.qqguildsdk.api.IGPSService;
import com.tencent.mobileqq.qqguildsdk.data.IGProChannelInfo;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mvi.base.mvi.MviUIState;
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
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\n\b\u0016\u0018\u0000 \u001e2\u00020\u0001:\u0001\u001fB\u000f\u0012\u0006\u0010\u0015\u001a\u00020\u000b\u00a2\u0006\u0004\b\u001c\u0010\u001dJ&\u0010\n\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006H\u0016J\b\u0010\f\u001a\u00020\u000bH\u0016J\u0016\u0010\u0010\u001a\u0010\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u000f\u0018\u00010\rH\u0016R\u0017\u0010\u0015\u001a\u00020\u000b8\u0006\u00a2\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014R\u001b\u0010\u001b\u001a\u00020\u00168DX\u0084\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0019\u0010\u001a\u00a8\u0006 "}, d2 = {"Lcom/tencent/guild/aio/component/combinestyle/GuildMediaAvatarComponent;", "Lcom/tencent/guild/aio/component/combinestyle/AbsGuildMediaStyleComponent;", "", "position", "Lcom/tencent/aio/data/msglist/a;", "msgItem", "", "", "payloads", "", "b1", "Landroid/view/View;", "d1", "Lcom/tencent/aio/base/mvvm/b;", "Lol3/b;", "Lcom/tencent/mvi/base/mvi/MviUIState;", "e1", "D", "Landroid/view/View;", "getRoot", "()Landroid/view/View;", "root", "Lcom/tencent/mobileqq/guild/widget/GuildUserAvatarView;", "E", "Lkotlin/Lazy;", "L1", "()Lcom/tencent/mobileqq/guild/widget/GuildUserAvatarView;", "avatarView", "<init>", "(Landroid/view/View;)V", UserInfo.SEX_FEMALE, "a", "aio-guild_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes6.dex */
public class GuildMediaAvatarComponent extends AbsGuildMediaStyleComponent {

    /* renamed from: D, reason: from kotlin metadata */
    @NotNull
    private final View root;

    /* renamed from: E, reason: from kotlin metadata */
    @NotNull
    private final Lazy avatarView;

    public GuildMediaAvatarComponent(@NotNull View root) {
        Lazy lazy;
        Intrinsics.checkNotNullParameter(root, "root");
        this.root = root;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<GuildUserAvatarView>() { // from class: com.tencent.guild.aio.component.combinestyle.GuildMediaAvatarComponent$avatarView$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final GuildUserAvatarView invoke() {
                GuildUserAvatarView guildUserAvatarView = new GuildUserAvatarView(GuildMediaAvatarComponent.this.getRoot().getContext());
                int dip2px = ViewUtils.dip2px(20.0f);
                guildUserAvatarView.setLayoutParams(new ViewGroup.LayoutParams(dip2px, dip2px));
                com.tencent.guild.aio.util.h.D(com.tencent.guild.aio.util.h.f112401a, guildUserAvatarView, "em_aio_profile", null, 4, null);
                return guildUserAvatarView;
            }
        });
        this.avatarView = lazy;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void J1(GuildMediaAvatarComponent this$0, com.tencent.aio.data.msglist.a msgItem, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(msgItem, "$msgItem");
        if (this$0.u1(this$0.root)) {
            com.tencent.guild.aio.util.h hVar = com.tencent.guild.aio.util.h.f112401a;
            Context mContext = this$0.getMContext();
            Intrinsics.checkNotNull(mContext, "null cannot be cast to non-null type android.app.Activity");
            hVar.B((Activity) mContext, (GuildMsgItem) msgItem);
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean K1(GuildMediaAvatarComponent this$0, com.tencent.aio.data.msglist.a msgItem, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(msgItem, "$msgItem");
        if (this$0.u1(this$0.root)) {
            this$0.sendIntent(new n.a((GuildMsgItem) msgItem));
            return true;
        }
        return false;
    }

    @NotNull
    protected final GuildUserAvatarView L1() {
        return (GuildUserAvatarView) this.avatarView.getValue();
    }

    @Override // com.tencent.guild.aio.component.combinestyle.AbsGuildMediaStyleComponent, com.tencent.guild.aio.msglist.holder.component.a
    public void b1(int position, @NotNull final com.tencent.aio.data.msglist.a msgItem, @NotNull List<Object> payloads) {
        AppInterface appInterface;
        IRuntimeService iRuntimeService;
        IGProChannelInfo channelInfo;
        Intrinsics.checkNotNullParameter(msgItem, "msgItem");
        Intrinsics.checkNotNullParameter(payloads, "payloads");
        super.b1(position, msgItem, payloads);
        if (msgItem instanceof GuildMsgItem) {
            GuildMsgItem guildMsgItem = (GuildMsgItem) msgItem;
            L1().setAvatarTinyId(guildMsgItem.getMsgRecord().guildId, guildMsgItem.getMsgRecord().senderUid);
            L1().setOnClickListener(new View.OnClickListener() { // from class: com.tencent.guild.aio.component.combinestyle.l
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    GuildMediaAvatarComponent.J1(GuildMediaAvatarComponent.this, msgItem, view);
                }
            });
            L1().setOnLongClickListener(new View.OnLongClickListener() { // from class: com.tencent.guild.aio.component.combinestyle.m
                @Override // android.view.View.OnLongClickListener
                public final boolean onLongClick(View view) {
                    boolean K1;
                    K1 = GuildMediaAvatarComponent.K1(GuildMediaAvatarComponent.this, msgItem, view);
                    return K1;
                }
            });
            HashMap hashMap = new HashMap();
            String str = guildMsgItem.getMsgRecord().channelId;
            hashMap.put("sgrp_channel_id", guildMsgItem.getMsgRecord().guildId);
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
            VideoReport.setElementParams(L1(), hashMap);
        }
    }

    @Override // com.tencent.guild.aio.msglist.holder.component.a
    @NotNull
    public View d1() {
        return L1();
    }

    @Override // com.tencent.guild.aio.component.combinestyle.AbsGuildMediaStyleComponent, com.tencent.guild.aio.msglist.holder.component.a, com.tencent.mvi.mvvm.framework.FrameworkVB
    @Nullable
    /* renamed from: e1 */
    public com.tencent.aio.base.mvvm.b<ol3.b, MviUIState> createVM() {
        return new o();
    }

    @NotNull
    public final View getRoot() {
        return this.root;
    }
}

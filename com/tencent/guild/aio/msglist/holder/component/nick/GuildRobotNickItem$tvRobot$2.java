package com.tencent.guild.aio.msglist.holder.component.nick;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.tencent.guild.aio.msglist.holder.component.nick.GuildRobotNickItem;
import com.tencent.guild.api.data.msglist.GuildMsgItem;
import com.tencent.mobileqq.R;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqnt.kernel.nativeinterface.MsgRecord;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n\u00a2\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Landroid/widget/ImageView;", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes6.dex */
public final class GuildRobotNickItem$tvRobot$2 extends Lambda implements Function0<ImageView> {
    final /* synthetic */ GuildRobotNickItem this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GuildRobotNickItem$tvRobot$2(GuildRobotNickItem guildRobotNickItem) {
        super(0);
        this.this$0 = guildRobotNickItem;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(GuildRobotNickItem this$0, ImageView this_apply, View view) {
        GuildMsgItem guildMsgItem;
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(this_apply, "$this_apply");
        guildMsgItem = this$0.curMsgItem;
        if (guildMsgItem != null) {
            com.tencent.guild.aio.util.h hVar = com.tencent.guild.aio.util.h.f112401a;
            MsgRecord msgRecord = guildMsgItem.getMsgRecord();
            Context context = this_apply.getContext();
            Intrinsics.checkNotNullExpressionValue(context, "context");
            hVar.A(msgRecord, context);
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    @NotNull
    public final ImageView invoke() {
        final ImageView imageView = new ImageView(this.this$0.getContext());
        final GuildRobotNickItem guildRobotNickItem = this.this$0;
        GuildRobotNickItem.Companion companion = GuildRobotNickItem.INSTANCE;
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(companion.c(), companion.a());
        layoutParams.leftMargin = companion.b();
        layoutParams.gravity = 16;
        imageView.setLayoutParams(layoutParams);
        imageView.setBackgroundResource(R.drawable.qq_troop_bot_icon);
        imageView.setPadding(companion.d(), 0, companion.e(), 0);
        imageView.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.guild.aio.msglist.holder.component.nick.k
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                GuildRobotNickItem$tvRobot$2.b(GuildRobotNickItem.this, imageView, view);
            }
        });
        guildRobotNickItem.b(imageView);
        return imageView;
    }
}

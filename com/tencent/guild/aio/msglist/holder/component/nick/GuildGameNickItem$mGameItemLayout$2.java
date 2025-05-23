package com.tencent.guild.aio.msglist.holder.component.nick;

import android.content.Context;
import android.view.View;
import android.widget.LinearLayout;
import com.tencent.guild.api.data.msglist.GuildMsgItem;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqnt.kernel.nativeinterface.MsgRecord;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n\u00a2\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Landroid/widget/LinearLayout;", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes6.dex */
public final class GuildGameNickItem$mGameItemLayout$2 extends Lambda implements Function0<LinearLayout> {
    final /* synthetic */ GuildGameNickItem this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GuildGameNickItem$mGameItemLayout$2(GuildGameNickItem guildGameNickItem) {
        super(0);
        this.this$0 = guildGameNickItem;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(GuildGameNickItem this$0, LinearLayout this_apply, View view) {
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
    public final LinearLayout invoke() {
        final LinearLayout linearLayout = new LinearLayout(this.this$0.getContext());
        final GuildGameNickItem guildGameNickItem = this.this$0;
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.leftMargin = ViewUtils.dpToPx(6.0f);
        layoutParams.gravity = 16;
        linearLayout.setLayoutParams(layoutParams);
        linearLayout.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.guild.aio.msglist.holder.component.nick.e
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                GuildGameNickItem$mGameItemLayout$2.b(GuildGameNickItem.this, linearLayout, view);
            }
        });
        guildGameNickItem.b(linearLayout);
        return linearLayout;
    }
}

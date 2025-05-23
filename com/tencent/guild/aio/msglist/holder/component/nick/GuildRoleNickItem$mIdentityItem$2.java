package com.tencent.guild.aio.msglist.holder.component.nick;

import android.content.Context;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.guild.api.data.msglist.GuildMsgItem;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.guild.util.GuildUIUtils;
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
@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n\u00a2\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Landroid/widget/TextView;", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes6.dex */
public final class GuildRoleNickItem$mIdentityItem$2 extends Lambda implements Function0<TextView> {
    final /* synthetic */ GuildRoleNickItem this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GuildRoleNickItem$mIdentityItem$2(GuildRoleNickItem guildRoleNickItem) {
        super(0);
        this.this$0 = guildRoleNickItem;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(GuildRoleNickItem this$0, TextView this_apply, View view) {
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
    public final TextView invoke() {
        final TextView textView = new TextView(this.this$0.getContext());
        final GuildRoleNickItem guildRoleNickItem = this.this$0;
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.leftMargin = ViewUtils.dpToPx(6.0f);
        layoutParams.height = ViewUtils.dpToPx(13.0f);
        layoutParams.gravity = 16;
        textView.setLayoutParams(layoutParams);
        textView.setGravity(17);
        textView.setPadding(ViewUtils.dpToPx(4.0f), 0, ViewUtils.dpToPx(4.0f), 0);
        GuildUIUtils.f235378a.b(textView, R.color.qui_common_text_allwhite_primary);
        textView.setIncludeFontPadding(false);
        textView.setTextSize(1, 9.0f);
        textView.setVisibility(8);
        textView.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.guild.aio.msglist.holder.component.nick.l
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                GuildRoleNickItem$mIdentityItem$2.b(GuildRoleNickItem.this, textView, view);
            }
        });
        guildRoleNickItem.b(textView);
        return textView;
    }
}

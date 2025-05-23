package com.tencent.guild.aio.msglist.holder.component.nick;

import android.content.Context;
import android.graphics.Paint;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.tencent.guild.api.data.msglist.GuildMsgItem;
import com.tencent.mobileqq.R;
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
public final class GuildNickItem$tvNick$2 extends Lambda implements Function0<TextView> {
    final /* synthetic */ GuildNickItem this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GuildNickItem$tvNick$2(GuildNickItem guildNickItem) {
        super(0);
        this.this$0 = guildNickItem;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(GuildNickItem this$0, TextView this_apply, View view) {
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
        final GuildNickItem guildNickItem = this.this$0;
        textView.setLayoutParams(new ViewGroup.LayoutParams(-2, -2));
        textView.setTextSize(0, textView.getContext().getResources().getDimensionPixelSize(R.dimen.f158239c03));
        textView.getPaint().setStyle(Paint.Style.FILL_AND_STROKE);
        textView.getPaint().setStrokeWidth(1.0f);
        textView.setSingleLine();
        textView.setEllipsize(TextUtils.TruncateAt.END);
        textView.setClickable(false);
        textView.setFocusable(false);
        textView.setMaxWidth(ViewUtils.dpToPx(160.0f));
        textView.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.guild.aio.msglist.holder.component.nick.j
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                GuildNickItem$tvNick$2.b(GuildNickItem.this, textView, view);
            }
        });
        guildNickItem.b(textView);
        return textView;
    }
}

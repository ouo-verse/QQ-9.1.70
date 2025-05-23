package com.tencent.guild.aio.msglist.holder.component.nick;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
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
@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n\u00a2\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Landroid/widget/LinearLayout;", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes6.dex */
public final class GuildSVipNamePlateItem$namePlateContainer$2 extends Lambda implements Function0<LinearLayout> {
    final /* synthetic */ GuildSVipNamePlateItem this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GuildSVipNamePlateItem$namePlateContainer$2(GuildSVipNamePlateItem guildSVipNamePlateItem) {
        super(0);
        this.this$0 = guildSVipNamePlateItem;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(GuildSVipNamePlateItem this$0, ImageView this_apply, View view) {
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
        LinearLayout linearLayout = new LinearLayout(this.this$0.getContext());
        final GuildSVipNamePlateItem guildSVipNamePlateItem = this.this$0;
        linearLayout.setPadding(ViewUtils.dpToPx(3.0f), 0, 0, 0);
        final ImageView imageView = new ImageView(linearLayout.getContext());
        imageView.setLayoutParams(new LinearLayout.LayoutParams(-2, ViewUtils.dpToPx(15.0f)));
        imageView.setMaxWidth(ViewUtils.dpToPx(160.0f));
        imageView.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.guild.aio.msglist.holder.component.nick.n
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                GuildSVipNamePlateItem$namePlateContainer$2.b(GuildSVipNamePlateItem.this, imageView, view);
            }
        });
        linearLayout.addView(imageView);
        guildSVipNamePlateItem.ivNamePlate = imageView;
        guildSVipNamePlateItem.b(linearLayout);
        return linearLayout;
    }
}

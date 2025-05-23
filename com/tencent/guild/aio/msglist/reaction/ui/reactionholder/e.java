package com.tencent.guild.aio.msglist.reaction.ui.reactionholder;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.biz.pubaccount.util.api.impl.PublicAccountMessageUtilImpl;
import com.tencent.guild.aio.msglist.reaction.ui.GuildReactionAdapter;
import com.tencent.guild.aio.msglist.reaction.ui.reactionholder.BaseReactionHolder;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.guild.util.GuildUIUtils;
import com.tencent.mobileqq.utils.x;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.mvi.base.mvi.MviUIState;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqnt.kernel.nativeinterface.MsgRecord;
import com.tencent.qqnt.kernelpublic.nativeinterface.Contact;
import gq0.ReplyReactionItem;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \u00182\u00020\u0001:\u0001\u0019B\u0017\u0012\u0006\u0010\u0013\u001a\u00020\u000b\u0012\u0006\u0010\u0015\u001a\u00020\u0014\u00a2\u0006\u0004\b\u0016\u0010\u0017J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u001e\u0010\n\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00062\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u0007H\u0014J\u0010\u0010\r\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u000bH\u0016R\u001c\u0010\u0012\u001a\n \u000f*\u0004\u0018\u00010\u000e0\u000e8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\u0011\u00a8\u0006\u001a"}, d2 = {"Lcom/tencent/guild/aio/msglist/reaction/ui/reactionholder/e;", "Lcom/tencent/guild/aio/msglist/reaction/ui/reactionholder/BaseReactionHolder;", "Lgq0/e;", PublicAccountMessageUtilImpl.ITEM_STRUCT_FIRST_LEVEL_NAME, "", "t", "Lgq0/d;", "", "", "payloads", "o", "Landroid/view/View;", "v", NodeProps.ON_CLICK, "Landroid/widget/TextView;", "kotlin.jvm.PlatformType", "H", "Landroid/widget/TextView;", "replyCntView", "itemView", "Lcom/tencent/guild/aio/msglist/reaction/ui/reactionholder/d;", "adapterCtrl", "<init>", "(Landroid/view/View;Lcom/tencent/guild/aio/msglist/reaction/ui/reactionholder/d;)V", "I", "a", "aio-guild_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes6.dex */
public final class e extends BaseReactionHolder {

    /* renamed from: I, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: H, reason: from kotlin metadata */
    private final TextView replyCntView;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\t\u0010\nJ\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002R\u0014\u0010\u0007\u001a\u00020\u00068\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\b\u00a8\u0006\u000b"}, d2 = {"Lcom/tencent/guild/aio/msglist/reaction/ui/reactionholder/e$a;", "", "Landroid/content/Context;", "context", "Landroid/view/View;", "a", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "aio-guild_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.guild.aio.msglist.reaction.ui.reactionholder.e$a, reason: from kotlin metadata */
    /* loaded from: classes6.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final View a(@NotNull Context context) {
            Intrinsics.checkNotNullParameter(context, "context");
            ImageView imageView = new ImageView(context);
            GuildUIUtils guildUIUtils = GuildUIUtils.f235378a;
            imageView.setImageDrawable(guildUIUtils.A(context, R.drawable.guild_emj_reply_icon, R.color.qui_common_icon_secondary));
            imageView.setScaleType(ImageView.ScaleType.CENTER);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(x.a(20.0f), x.a(20.0f));
            layoutParams.leftMargin = x.a(5.0f);
            layoutParams.rightMargin = x.a(6.0f);
            layoutParams.gravity = 16;
            imageView.setLayoutParams(layoutParams);
            TextView textView = new TextView(context);
            textView.setId(R.id.vy8);
            textView.setTextSize(2, 13.0f);
            guildUIUtils.b(textView, R.color.qui_common_text_secondary);
            LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
            layoutParams2.rightMargin = x.a(13.0f);
            layoutParams2.gravity = 16;
            textView.setLayoutParams(layoutParams2);
            LinearLayout linearLayout = new LinearLayout(context);
            linearLayout.setOrientation(0);
            linearLayout.addView(imageView);
            linearLayout.addView(textView);
            return linearLayout;
        }

        Companion() {
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public e(@NotNull View itemView, @NotNull d adapterCtrl) {
        super(itemView, adapterCtrl);
        Intrinsics.checkNotNullParameter(itemView, "itemView");
        Intrinsics.checkNotNullParameter(adapterCtrl, "adapterCtrl");
        this.replyCntView = (TextView) itemView.findViewById(R.id.vy8);
    }

    private final void t(ReplyReactionItem item) {
        this.replyCntView.setText(String.valueOf(item.getReplyCnt()));
    }

    @Override // com.tencent.guild.aio.msglist.reaction.ui.reactionholder.BaseReactionHolder
    protected void o(@NotNull gq0.d item, @NotNull List<? extends Object> payloads) {
        Intrinsics.checkNotNullParameter(item, "item");
        Intrinsics.checkNotNullParameter(payloads, "payloads");
        ReplyReactionItem replyReactionItem = (ReplyReactionItem) item;
        if (payloads.contains(BaseReactionHolder.PayloadType.ITEM_BG_REFRESH_PAYLOAD)) {
            s();
        } else {
            t(replyReactionItem);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(@NotNull View v3) {
        EventCollector.getInstance().onViewClickedBefore(v3);
        Intrinsics.checkNotNullParameter(v3, "v");
        Context context = this.itemView.getContext();
        Intrinsics.checkNotNull(context, "null cannot be cast to non-null type android.app.Activity");
        Activity activity = (Activity) context;
        MsgRecord msg2 = q().getMsg();
        if (msg2 != null) {
            Contact contact = new Contact();
            contact.peerUid = msg2.peerUid;
            contact.guildId = msg2.guildId;
            long j3 = msg2.msgSeq;
            d adapter = getAdapter();
            Intrinsics.checkNotNull(adapter, "null cannot be cast to non-null type com.tencent.guild.aio.msglist.reaction.ui.GuildReactionAdapter");
            com.tencent.aio.base.mvvm.a<ol3.b, MviUIState> aVar = ((GuildReactionAdapter) adapter).o0().get();
            Intrinsics.checkNotNull(aVar, "null cannot be cast to non-null type com.tencent.guild.aio.msglist.holder.component.AbsGuildMsgItemComponent");
            in0.c.c(activity, contact, j3, null, ((com.tencent.guild.aio.msglist.holder.component.a) aVar).f1(), 0, 32, null);
        }
        EventCollector.getInstance().onViewClicked(v3);
    }
}

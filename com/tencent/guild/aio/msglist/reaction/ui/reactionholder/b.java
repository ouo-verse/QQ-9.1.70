package com.tencent.guild.aio.msglist.reaction.ui.reactionholder;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.tencent.biz.pubaccount.util.api.impl.PublicAccountMessageUtilImpl;
import com.tencent.guild.api.emoji.IGuildEmojiApi;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.guild.emoj.f;
import com.tencent.mobileqq.guild.util.GuildUIUtils;
import com.tencent.mobileqq.guild.util.IQQGuildUtilApi;
import com.tencent.mobileqq.msf.sdk.AppNetConnInfo;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.x;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqnt.kernel.nativeinterface.MsgRecord;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \u00152\u00020\u0001:\u0001\u0016B\u0017\u0012\u0006\u0010\u0010\u001a\u00020\r\u0012\u0006\u0010\u0012\u001a\u00020\u0011\u00a2\u0006\u0004\b\u0013\u0010\u0014J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u001e\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0007\u001a\u00020\u00062\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\bH\u0014J\u0010\u0010\u000f\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\rH\u0016\u00a8\u0006\u0017"}, d2 = {"Lcom/tencent/guild/aio/msglist/reaction/ui/reactionholder/b;", "Lcom/tencent/guild/aio/msglist/reaction/ui/reactionholder/BaseReactionHolder;", "Lcom/tencent/qqnt/kernel/nativeinterface/MsgRecord;", "msg", "Lcom/tencent/mobileqq/guild/emoj/b;", "u", "Lgq0/d;", PublicAccountMessageUtilImpl.ITEM_STRUCT_FIRST_LEVEL_NAME, "", "", "payloads", "", "o", "Landroid/view/View;", "v", NodeProps.ON_CLICK, "itemView", "Lcom/tencent/guild/aio/msglist/reaction/ui/reactionholder/d;", "adapter", "<init>", "(Landroid/view/View;Lcom/tencent/guild/aio/msglist/reaction/ui/reactionholder/d;)V", "H", "a", "aio-guild_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes6.dex */
public final class b extends BaseReactionHolder {

    /* renamed from: H, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\t\u0010\nJ\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002R\u0014\u0010\u0007\u001a\u00020\u00068\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\b\u00a8\u0006\u000b"}, d2 = {"Lcom/tencent/guild/aio/msglist/reaction/ui/reactionholder/b$a;", "", "Landroid/content/Context;", "context", "Landroid/view/View;", "a", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "aio-guild_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.guild.aio.msglist.reaction.ui.reactionholder.b$a, reason: from kotlin metadata */
    /* loaded from: classes6.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final View a(@NotNull Context context) {
            Intrinsics.checkNotNullParameter(context, "context");
            ImageView imageView = new ImageView(context);
            imageView.setFocusable(true);
            imageView.setImageDrawable(GuildUIUtils.f235378a.A(context, R.drawable.guild_emoji_more, R.color.qui_common_text_secondary));
            imageView.setLayoutParams(new LinearLayout.LayoutParams(x.a(28.0f), x.a(28.0f)));
            LinearLayout linearLayout = new LinearLayout(context);
            linearLayout.setOrientation(0);
            linearLayout.addView(imageView);
            return linearLayout;
        }

        Companion() {
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(@NotNull View itemView, @NotNull d adapter) {
        super(itemView, adapter);
        Intrinsics.checkNotNullParameter(itemView, "itemView");
        Intrinsics.checkNotNullParameter(adapter, "adapter");
    }

    private final com.tencent.mobileqq.guild.emoj.b u(MsgRecord msg2) {
        Activity activity;
        com.tencent.mobileqq.guild.emoj.b bVar = new com.tencent.mobileqq.guild.emoj.b();
        bVar.f217867a = 1;
        bVar.f217870d = msg2.msgSeq;
        bVar.f217871e = msg2.peerUid;
        bVar.f217874h = ((IQQGuildUtilApi) QRoute.api(IQQGuildUtilApi.class)).appInterface();
        Context context = this.itemView.getContext();
        if (context instanceof Activity) {
            activity = (Activity) context;
        } else {
            activity = null;
        }
        bVar.f217875i = activity;
        bVar.f217873g = msg2.guildId;
        bVar.f217872f = msg2.channelId;
        return bVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void v(View v3, b this$0, MsgRecord msgRecord, String str, String str2, long j3, int i3, int i16, boolean z16) {
        Intrinsics.checkNotNullParameter(v3, "$v");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(msgRecord, "$msgRecord");
        if (!AppNetConnInfo.isNetSupport()) {
            QQToast.makeText(v3.getContext(), "\u7f51\u7edc\u4e0d\u53ef\u7528", 0).show();
        }
        int transEmoServerIdToEmoLocalId = ((IGuildEmojiApi) QRoute.api(IGuildEmojiApi.class)).transEmoServerIdToEmoLocalId(i3, i16);
        d adapter = this$0.getAdapter();
        if (adapter != null) {
            adapter.t(transEmoServerIdToEmoLocalId, i16, msgRecord);
        }
    }

    @Override // com.tencent.guild.aio.msglist.reaction.ui.reactionholder.BaseReactionHolder
    protected void o(@NotNull gq0.d item, @NotNull List<? extends Object> payloads) {
        Intrinsics.checkNotNullParameter(item, "item");
        Intrinsics.checkNotNullParameter(payloads, "payloads");
        s();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(@NotNull final View v3) {
        EventCollector.getInstance().onViewClickedBefore(v3);
        Intrinsics.checkNotNullParameter(v3, "v");
        final MsgRecord msg2 = q().getMsg();
        if (msg2 != null) {
            if (msg2.emojiLikesList.size() >= 20) {
                QQToast.makeText(BaseApplication.getContext(), 1, R.string.f143480m7, 0).show();
            } else {
                ((IGuildEmojiApi) QRoute.api(IGuildEmojiApi.class)).showReactionEmoPanel(u(msg2), x.a(482.0f), new f() { // from class: com.tencent.guild.aio.msglist.reaction.ui.reactionholder.a
                    @Override // com.tencent.mobileqq.guild.emoj.f
                    public final void a(String str, String str2, long j3, int i3, int i16, boolean z16) {
                        b.v(v3, this, msg2, str, str2, j3, i3, i16, z16);
                    }
                });
            }
        }
        EventCollector.getInstance().onViewClicked(v3);
    }
}

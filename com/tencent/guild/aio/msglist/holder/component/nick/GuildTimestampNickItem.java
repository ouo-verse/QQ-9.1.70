package com.tencent.guild.aio.msglist.holder.component.nick;

import android.content.Context;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.guild.api.data.msglist.GuildMsgItem;
import com.tencent.guild.api.data.msglist.GuildMsgItemPayloadType;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.guild.util.GuildUIUtils;
import com.tencent.mobileqq.utils.ViewUtils;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 \u00172\u00020\u0001:\u0001\bB\u000f\u0012\u0006\u0010\u000e\u001a\u00020\t\u00a2\u0006\u0004\b\u0015\u0010\u0016J\u001e\u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004H\u0016R\u0017\u0010\u000e\u001a\u00020\t8\u0006\u00a2\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\u001b\u0010\u0014\u001a\u00020\u000f8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013\u00a8\u0006\u0018"}, d2 = {"Lcom/tencent/guild/aio/msglist/holder/component/nick/GuildTimestampNickItem;", "Lcom/tencent/guild/aio/msglist/holder/component/nick/r;", "Lcom/tencent/guild/api/data/msglist/GuildMsgItem;", "msgItem", "", "", "payloads", "", "a", "Landroid/content/Context;", "c", "Landroid/content/Context;", "i", "()Landroid/content/Context;", "context", "Landroid/widget/TextView;", "d", "Lkotlin/Lazy;", "j", "()Landroid/widget/TextView;", "mTimeStamp", "<init>", "(Landroid/content/Context;)V", "e", "aio-guild_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes6.dex */
public final class GuildTimestampNickItem extends r {

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Context context;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy mTimeStamp;

    public GuildTimestampNickItem(@NotNull Context context) {
        Lazy lazy;
        Intrinsics.checkNotNullParameter(context, "context");
        this.context = context;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<TextView>() { // from class: com.tencent.guild.aio.msglist.holder.component.nick.GuildTimestampNickItem$mTimeStamp$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final TextView invoke() {
                TextView textView = new TextView(GuildTimestampNickItem.this.getContext());
                GuildTimestampNickItem guildTimestampNickItem = GuildTimestampNickItem.this;
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
                layoutParams.leftMargin = ViewUtils.dpToPx(6.0f);
                layoutParams.gravity = 16;
                textView.setLayoutParams(layoutParams);
                textView.setTextSize(10.0f);
                textView.setSingleLine();
                textView.setId(R.id.vxt);
                GuildUIUtils.f235378a.b(textView, R.color.qui_common_text_secondary);
                guildTimestampNickItem.b(textView);
                return textView;
            }
        });
        this.mTimeStamp = lazy;
    }

    private final TextView j() {
        return (TextView) this.mTimeStamp.getValue();
    }

    @Override // com.tencent.guild.aio.msglist.holder.component.nick.a
    public void a(@NotNull GuildMsgItem msgItem, @NotNull List<Object> payloads) {
        Intrinsics.checkNotNullParameter(msgItem, "msgItem");
        Intrinsics.checkNotNullParameter(payloads, "payloads");
        boolean z16 = false;
        boolean z17 = false;
        for (Object obj : payloads) {
            if ((obj instanceof HashMap) && ((Map) obj).get(GuildMsgItemPayloadType.TIME_PAYLOAD) != null) {
                z17 = true;
            }
        }
        String msgTime = msgItem.getPreParseInfo().getMsgTime();
        if (msgTime == null || msgTime.length() == 0) {
            z16 = true;
        }
        if (z16 || z17) {
            msgTime = o.INSTANCE.b(this.context, msgItem.getMsgRecord().msgTime * 1000);
            msgItem.getPreParseInfo().k(msgTime);
        }
        j().setText(msgTime);
    }

    @NotNull
    /* renamed from: i, reason: from getter */
    public final Context getContext() {
        return this.context;
    }
}

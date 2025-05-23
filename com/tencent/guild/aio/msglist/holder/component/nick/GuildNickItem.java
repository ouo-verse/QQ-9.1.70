package com.tencent.guild.aio.msglist.holder.component.nick;

import android.content.Context;
import android.widget.TextView;
import com.tencent.guild.api.data.msglist.GuildMsgItem;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.guild.util.GuildUIUtils;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.text.QQText;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010!\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u0000 \u000e2\u00020\u0001:\u0001\fB\u000f\u0012\u0006\u0010\u0015\u001a\u00020\u0010\u00a2\u0006\u0004\b\u001f\u0010 J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u001e\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0003\u001a\u00020\u00022\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\bH\u0016J\u0018\u0010\u000e\u001a\u00020\u000b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\u0006H\u0016J\u0016\u0010\u000f\u001a\u00020\u000b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004R\u0017\u0010\u0015\u001a\u00020\u00108\u0006\u00a2\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014R\u001b\u0010\u001b\u001a\u00020\u00168BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0019\u0010\u001aR\u0018\u0010\u001e\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001c\u0010\u001d\u00a8\u0006!"}, d2 = {"Lcom/tencent/guild/aio/msglist/holder/component/nick/GuildNickItem;", "Lcom/tencent/guild/aio/msglist/holder/component/nick/r;", "Lcom/tencent/guild/api/data/msglist/GuildMsgItem;", "msgItem", "", "isRefresh", "", "j", "", "", "payloads", "", "a", "type", "f", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Landroid/content/Context;", "c", "Landroid/content/Context;", "k", "()Landroid/content/Context;", "context", "Landroid/widget/TextView;", "d", "Lkotlin/Lazy;", "l", "()Landroid/widget/TextView;", "tvNick", "e", "Lcom/tencent/guild/api/data/msglist/GuildMsgItem;", "curMsgItem", "<init>", "(Landroid/content/Context;)V", "aio-guild_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes6.dex */
public final class GuildNickItem extends r {

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Context context;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy tvNick;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private GuildMsgItem curMsgItem;

    public GuildNickItem(@NotNull Context context) {
        Lazy lazy;
        Intrinsics.checkNotNullParameter(context, "context");
        this.context = context;
        lazy = LazyKt__LazyJVMKt.lazy(new GuildNickItem$tvNick$2(this));
        this.tvNick = lazy;
    }

    private final int j(GuildMsgItem msgItem, boolean isRefresh) {
        if (isRefresh) {
            int e16 = e(msgItem);
            msgItem.getPreParseInfo().l(Integer.valueOf(e16));
            return e16;
        }
        Integer nickColor = msgItem.getPreParseInfo().getNickColor();
        if (nickColor == null) {
            nickColor = Integer.valueOf(e(msgItem));
            msgItem.getPreParseInfo().l(nickColor);
        }
        return nickColor.intValue();
    }

    private final TextView l() {
        return (TextView) this.tvNick.getValue();
    }

    @Override // com.tencent.guild.aio.msglist.holder.component.nick.a
    public void a(@NotNull GuildMsgItem msgItem, @NotNull List<Object> payloads) {
        Intrinsics.checkNotNullParameter(msgItem, "msgItem");
        Intrinsics.checkNotNullParameter(payloads, "payloads");
        this.curMsgItem = msgItem;
        QQText nickname = msgItem.getPreParseInfo().getNickname();
        if (nickname == null) {
            QQText qQText = new QQText(com.tencent.guild.aio.util.h.f112401a.n(msgItem, this.context), 3, 16);
            msgItem.getPreParseInfo().m(qQText);
            nickname = qQText;
        }
        l().setText(nickname);
        m(msgItem, false);
    }

    @Override // com.tencent.guild.aio.msglist.holder.component.nick.r
    public void f(@NotNull GuildMsgItem msgItem, int type) {
        Intrinsics.checkNotNullParameter(msgItem, "msgItem");
        if (type != 1) {
            if (type == 2) {
                m(msgItem, true);
            }
        } else {
            l().setText(new QQText(com.tencent.guild.aio.util.h.f112401a.n(msgItem, this.context), 3, 16));
        }
    }

    @NotNull
    /* renamed from: k, reason: from getter */
    public final Context getContext() {
        return this.context;
    }

    public final void m(@NotNull GuildMsgItem msgItem, boolean isRefresh) {
        Intrinsics.checkNotNullParameter(msgItem, "msgItem");
        int j3 = j(msgItem, isRefresh);
        if (j3 != -1) {
            l().setTextColor(j3);
        } else {
            GuildUIUtils.f235378a.b(l(), R.color.qui_common_text_secondary);
        }
    }
}

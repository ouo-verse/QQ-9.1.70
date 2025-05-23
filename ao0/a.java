package ao0;

import android.content.Context;
import com.tencent.aio.data.AIOParam;
import com.tencent.guild.aio.msglist.holder.component.nick.o;
import com.tencent.guild.aio.util.h;
import com.tencent.guild.api.data.msglist.GuildMsgItem;
import com.tencent.mobileqq.text.QQText;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\u0018\u0000 \r2\u00020\u0001:\u0001\rB\u0007\u00a2\u0006\u0004\b\u0013\u0010\u0014J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0018\u0010\b\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0010\u0010\t\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0018\u0010\n\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0010\u0010\u000b\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\r\u001a\u00020\f2\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\"\u0010\u0010\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u000f\u001a\u00020\u000eH\u0016J\b\u0010\u0012\u001a\u00020\u0011H\u0016\u00a8\u0006\u0015"}, d2 = {"Lao0/a;", "Lao0/f;", "Lcom/tencent/guild/api/data/msglist/GuildMsgItem;", "msgItem", "Landroid/content/Context;", "context", "", "c", "g", "f", "e", "d", "", "a", "Lcom/tencent/aio/data/AIOParam;", "aioParam", "b", "", "getTag", "<init>", "()V", "aio-guild_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes6.dex */
public final class a implements f {
    private final void c(GuildMsgItem msgItem, Context context) {
        msgItem.getPreParseInfo().k(o.INSTANCE.b(context, msgItem.getMsgRecord().msgTime * 1000));
    }

    private final void d(GuildMsgItem msgItem) {
        Object b16 = h.f112401a.b(msgItem);
        com.tencent.guild.api.data.msglist.c preParseInfo = msgItem.getPreParseInfo();
        if (b16 == null) {
            b16 = "EMPTY_OBJ";
        }
        preParseInfo.j(b16);
    }

    private final void e(GuildMsgItem msgItem, Context context) {
        String o16 = h.f112401a.o(msgItem, context);
        if (o16 != null) {
            msgItem.getPreParseInfo().m(new QQText(o16, 3, 16));
        }
    }

    private final void f(GuildMsgItem msgItem) {
        msgItem.getPreParseInfo().l(h.m(h.f112401a, msgItem, 0L, 2, null));
    }

    private final void g(GuildMsgItem msgItem, Context context) {
        msgItem.getPreParseInfo().o(h.f112401a.g(msgItem, context));
    }

    @Override // ao0.f
    public boolean a(@NotNull GuildMsgItem msgItem) {
        Intrinsics.checkNotNullParameter(msgItem, "msgItem");
        if (!msgItem.isGrayTipMsg()) {
            return true;
        }
        return false;
    }

    @Override // ao0.f
    public void b(@NotNull GuildMsgItem msgItem, @Nullable Context context, @NotNull AIOParam aioParam) {
        Intrinsics.checkNotNullParameter(msgItem, "msgItem");
        Intrinsics.checkNotNullParameter(aioParam, "aioParam");
        if (context != null) {
            c(msgItem, context);
            g(msgItem, context);
            e(msgItem, context);
        }
        f(msgItem);
        d(msgItem);
    }

    @Override // ao0.f
    @NotNull
    public String getTag() {
        return "GuildMsgNickPreParser";
    }
}

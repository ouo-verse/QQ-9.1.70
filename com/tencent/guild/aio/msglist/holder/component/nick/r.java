package com.tencent.guild.aio.msglist.holder.component.nick;

import android.view.View;
import com.tencent.aio.exception.AIOException;
import com.tencent.guild.aio.msglist.holder.component.nick.a;
import com.tencent.guild.aio.util.h;
import com.tencent.guild.api.data.msglist.GuildMsgItem;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0005\b&\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0014\u0010\u0015J\u0014\u0010\u0005\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002J\u0010\u0010\b\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u0006H\u0004R\"\u0010\u0010\u001a\u00020\t8\u0006@\u0006X\u0086.\u00a2\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u0016\u0010\u0013\u001a\u00020\u00118\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\b\u0010\u0012\u00a8\u0006\u0016"}, d2 = {"Lcom/tencent/guild/aio/msglist/holder/component/nick/r;", "Lcom/tencent/guild/aio/msglist/holder/component/nick/a;", "Lkotlin/Function0;", "", "function", tl.h.F, "Landroid/view/View;", "child", "b", "Lcom/tencent/guild/aio/msglist/holder/component/nick/b;", "a", "Lcom/tencent/guild/aio/msglist/holder/component/nick/b;", "c", "()Lcom/tencent/guild/aio/msglist/holder/component/nick/b;", "g", "(Lcom/tencent/guild/aio/msglist/holder/component/nick/b;)V", "attacher", "", "Z", "isAttach", "<init>", "()V", "aio-guild_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes6.dex */
public abstract class r implements a {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    public b attacher;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private boolean isAttach;

    /* JADX INFO: Access modifiers changed from: protected */
    public final void b(@NotNull View child) {
        Intrinsics.checkNotNullParameter(child, "child");
        if (!this.isAttach) {
            c().a(child);
            this.isAttach = true;
        } else {
            throw new AIOException("can not attach more than once " + child);
        }
    }

    @NotNull
    public final b c() {
        b bVar = this.attacher;
        if (bVar != null) {
            return bVar;
        }
        Intrinsics.throwUninitializedPropertyAccessException("attacher");
        return null;
    }

    @Nullable
    public h.MemberRoleInfo d(@NotNull GuildMsgItem guildMsgItem) {
        return a.C1202a.a(this, guildMsgItem);
    }

    public int e(@NotNull GuildMsgItem guildMsgItem) {
        return a.C1202a.b(this, guildMsgItem);
    }

    public void f(@NotNull GuildMsgItem guildMsgItem, int i3) {
        a.C1202a.c(this, guildMsgItem, i3);
    }

    public final void g(@NotNull b bVar) {
        Intrinsics.checkNotNullParameter(bVar, "<set-?>");
        this.attacher = bVar;
    }

    public final void h(@NotNull Function0<Unit> function) {
        Intrinsics.checkNotNullParameter(function, "function");
        if (this.isAttach) {
            function.invoke();
        }
    }
}

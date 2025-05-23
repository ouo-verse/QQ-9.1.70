package com.tencent.qqnt.aio.menu;

import android.content.Context;
import com.tencent.mobileqq.aio.msg.AIOMsgItem;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qqnt.aio.holder.IMsgItemMviUIState;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u000f\b\u0016\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u001b\u0010\u001cJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016JA\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u000e0\r\"\u0014\b\u0000\u0010\t*\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u00062\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\f\u001a\u00028\u0000\u00a2\u0006\u0004\b\u000f\u0010\u0010JC\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u000e0\r\"\u0014\b\u0000\u0010\t*\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u00062\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\f\u001a\u00028\u0000H\u0016\u00a2\u0006\u0004\b\u0011\u0010\u0010JC\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u000e0\r\"\u0014\b\u0000\u0010\t*\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u00062\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\f\u001a\u00028\u0000H\u0016\u00a2\u0006\u0004\b\u0012\u0010\u0010JC\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u000e0\r\"\u0014\b\u0000\u0010\t*\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u00062\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\f\u001a\u00028\u0000H\u0016\u00a2\u0006\u0004\b\u0013\u0010\u0010JC\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u000e0\r\"\u0014\b\u0000\u0010\t*\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u00062\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\f\u001a\u00028\u0000H\u0016\u00a2\u0006\u0004\b\u0014\u0010\u0010JC\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u000e0\r\"\u0014\b\u0000\u0010\t*\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u00062\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\f\u001a\u00028\u0000H\u0016\u00a2\u0006\u0004\b\u0015\u0010\u0010JC\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u000e0\r\"\u0014\b\u0000\u0010\t*\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u00062\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\f\u001a\u00028\u0000H\u0016\u00a2\u0006\u0004\b\u0016\u0010\u0010JC\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u000e0\r\"\u0014\b\u0000\u0010\t*\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u00062\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\f\u001a\u00028\u0000H\u0016\u00a2\u0006\u0004\b\u0017\u0010\u0010JC\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u000e0\r\"\u0014\b\u0000\u0010\t*\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u00062\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\f\u001a\u00028\u0000H\u0016\u00a2\u0006\u0004\b\u0018\u0010\u0010JC\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u000e0\r\"\u0014\b\u0000\u0010\t*\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u00062\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\f\u001a\u00028\u0000H\u0016\u00a2\u0006\u0004\b\u0019\u0010\u0010JC\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u000e0\r\"\u0014\b\u0000\u0010\t*\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u00062\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\f\u001a\u00028\u0000H\u0016\u00a2\u0006\u0004\b\u001a\u0010\u0010\u00a8\u0006\u001d"}, d2 = {"Lcom/tencent/qqnt/aio/menu/q;", "", "Lcom/tencent/mobileqq/aio/msg/AIOMsgItem;", "msgItem", "", "l", "Lcom/tencent/aio/base/mvvm/a;", "Lcom/tencent/qqnt/aio/holder/a;", "Lcom/tencent/qqnt/aio/holder/IMsgItemMviUIState;", "VB", "Landroid/content/Context;", "context", "vb", "", "Lcom/tencent/qqnt/aio/menu/ui/d;", "f", "(Landroid/content/Context;Lcom/tencent/mobileqq/aio/msg/AIOMsgItem;Lcom/tencent/aio/base/mvvm/a;)Ljava/util/List;", "j", tl.h.F, "i", "b", "a", "d", "e", "g", "k", "c", "<init>", "()V", "aio_kit_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes23.dex */
public class q {
    static IPatchRedirector $redirector_;

    public q() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @NotNull
    public <VB extends com.tencent.aio.base.mvvm.a<com.tencent.qqnt.aio.holder.a, IMsgItemMviUIState>> List<com.tencent.qqnt.aio.menu.ui.d> a(@NotNull Context context, @NotNull AIOMsgItem msgItem, @NotNull VB vb5) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return (List) iPatchRedirector.redirect((short) 8, this, context, msgItem, vb5);
        }
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(msgItem, "msgItem");
        Intrinsics.checkNotNullParameter(vb5, "vb");
        return new ArrayList();
    }

    @NotNull
    public <VB extends com.tencent.aio.base.mvvm.a<com.tencent.qqnt.aio.holder.a, IMsgItemMviUIState>> List<com.tencent.qqnt.aio.menu.ui.d> b(@NotNull Context context, @NotNull AIOMsgItem msgItem, @NotNull VB vb5) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (List) iPatchRedirector.redirect((short) 7, this, context, msgItem, vb5);
        }
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(msgItem, "msgItem");
        Intrinsics.checkNotNullParameter(vb5, "vb");
        return new ArrayList();
    }

    @NotNull
    public <VB extends com.tencent.aio.base.mvvm.a<com.tencent.qqnt.aio.holder.a, IMsgItemMviUIState>> List<com.tencent.qqnt.aio.menu.ui.d> c(@NotNull Context context, @NotNull AIOMsgItem msgItem, @NotNull VB vb5) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            return (List) iPatchRedirector.redirect((short) 13, this, context, msgItem, vb5);
        }
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(msgItem, "msgItem");
        Intrinsics.checkNotNullParameter(vb5, "vb");
        return new ArrayList();
    }

    @NotNull
    public <VB extends com.tencent.aio.base.mvvm.a<com.tencent.qqnt.aio.holder.a, IMsgItemMviUIState>> List<com.tencent.qqnt.aio.menu.ui.d> d(@NotNull Context context, @NotNull AIOMsgItem msgItem, @NotNull VB vb5) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return (List) iPatchRedirector.redirect((short) 9, this, context, msgItem, vb5);
        }
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(msgItem, "msgItem");
        Intrinsics.checkNotNullParameter(vb5, "vb");
        return new ArrayList();
    }

    @NotNull
    public <VB extends com.tencent.aio.base.mvvm.a<com.tencent.qqnt.aio.holder.a, IMsgItemMviUIState>> List<com.tencent.qqnt.aio.menu.ui.d> e(@NotNull Context context, @NotNull AIOMsgItem msgItem, @NotNull VB vb5) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return (List) iPatchRedirector.redirect((short) 10, this, context, msgItem, vb5);
        }
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(msgItem, "msgItem");
        Intrinsics.checkNotNullParameter(vb5, "vb");
        return new ArrayList();
    }

    @NotNull
    public final <VB extends com.tencent.aio.base.mvvm.a<com.tencent.qqnt.aio.holder.a, IMsgItemMviUIState>> List<com.tencent.qqnt.aio.menu.ui.d> f(@NotNull Context context, @NotNull AIOMsgItem msgItem, @NotNull VB vb5) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (List) iPatchRedirector.redirect((short) 3, this, context, msgItem, vb5);
        }
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(msgItem, "msgItem");
        Intrinsics.checkNotNullParameter(vb5, "vb");
        if (com.tencent.mobileqq.aio.utils.d.Z(msgItem) && !com.tencent.mobileqq.aio.utils.d.q(msgItem)) {
            return j(context, msgItem, vb5);
        }
        if (com.tencent.mobileqq.aio.utils.d.L(msgItem)) {
            return h(context, msgItem, vb5);
        }
        if (com.tencent.mobileqq.aio.utils.d.N(msgItem)) {
            return i(context, msgItem, vb5);
        }
        if (com.tencent.mobileqq.aio.utils.d.t(msgItem)) {
            return b(context, msgItem, vb5);
        }
        if (com.tencent.mobileqq.aio.utils.d.q(msgItem)) {
            return a(context, msgItem, vb5);
        }
        if (com.tencent.mobileqq.aio.utils.d.D(msgItem)) {
            return d(context, msgItem, vb5);
        }
        if (com.tencent.mobileqq.aio.utils.d.F(msgItem)) {
            return e(context, msgItem, vb5);
        }
        if (com.tencent.mobileqq.aio.utils.d.E(msgItem)) {
            return g(context, msgItem, vb5);
        }
        if (com.tencent.mobileqq.aio.utils.al.h(msgItem.getMsgRecord())) {
            return k(context, msgItem, vb5);
        }
        if (com.tencent.mobileqq.aio.utils.d.x(msgItem)) {
            return c(context, msgItem, vb5);
        }
        return new ArrayList();
    }

    @NotNull
    public <VB extends com.tencent.aio.base.mvvm.a<com.tencent.qqnt.aio.holder.a, IMsgItemMviUIState>> List<com.tencent.qqnt.aio.menu.ui.d> g(@NotNull Context context, @NotNull AIOMsgItem msgItem, @NotNull VB vb5) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return (List) iPatchRedirector.redirect((short) 11, this, context, msgItem, vb5);
        }
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(msgItem, "msgItem");
        Intrinsics.checkNotNullParameter(vb5, "vb");
        return new ArrayList();
    }

    @NotNull
    public <VB extends com.tencent.aio.base.mvvm.a<com.tencent.qqnt.aio.holder.a, IMsgItemMviUIState>> List<com.tencent.qqnt.aio.menu.ui.d> h(@NotNull Context context, @NotNull AIOMsgItem msgItem, @NotNull VB vb5) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (List) iPatchRedirector.redirect((short) 5, this, context, msgItem, vb5);
        }
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(msgItem, "msgItem");
        Intrinsics.checkNotNullParameter(vb5, "vb");
        return new ArrayList();
    }

    @NotNull
    public <VB extends com.tencent.aio.base.mvvm.a<com.tencent.qqnt.aio.holder.a, IMsgItemMviUIState>> List<com.tencent.qqnt.aio.menu.ui.d> i(@NotNull Context context, @NotNull AIOMsgItem msgItem, @NotNull VB vb5) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (List) iPatchRedirector.redirect((short) 6, this, context, msgItem, vb5);
        }
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(msgItem, "msgItem");
        Intrinsics.checkNotNullParameter(vb5, "vb");
        return new ArrayList();
    }

    @NotNull
    public <VB extends com.tencent.aio.base.mvvm.a<com.tencent.qqnt.aio.holder.a, IMsgItemMviUIState>> List<com.tencent.qqnt.aio.menu.ui.d> j(@NotNull Context context, @NotNull AIOMsgItem msgItem, @NotNull VB vb5) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (List) iPatchRedirector.redirect((short) 4, this, context, msgItem, vb5);
        }
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(msgItem, "msgItem");
        Intrinsics.checkNotNullParameter(vb5, "vb");
        return new ArrayList();
    }

    @NotNull
    public <VB extends com.tencent.aio.base.mvvm.a<com.tencent.qqnt.aio.holder.a, IMsgItemMviUIState>> List<com.tencent.qqnt.aio.menu.ui.d> k(@NotNull Context context, @NotNull AIOMsgItem msgItem, @NotNull VB vb5) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            return (List) iPatchRedirector.redirect((short) 12, this, context, msgItem, vb5);
        }
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(msgItem, "msgItem");
        Intrinsics.checkNotNullParameter(vb5, "vb");
        return new ArrayList();
    }

    public boolean l(@NotNull AIOMsgItem msgItem) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this, (Object) msgItem)).booleanValue();
        }
        Intrinsics.checkNotNullParameter(msgItem, "msgItem");
        return false;
    }
}

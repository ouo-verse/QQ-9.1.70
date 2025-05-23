package com.tencent.mobileqq.aio.gamemsg;

import android.content.Context;
import com.tencent.mobileqq.aio.msg.AIOMsgItem;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qqnt.aio.holder.IMsgItemMviUIState;
import com.tencent.qqnt.aio.menu.ac;
import com.tencent.qqnt.aio.menu.aj;
import com.tencent.qqnt.aio.menu.i;
import com.tencent.qqnt.aio.menu.k;
import com.tencent.qqnt.aio.menu.q;
import com.tencent.qqnt.aio.menu.ui.d;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0013\u0010\u0014J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016JC\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u000e0\r\"\u0014\b\u0000\u0010\t*\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u00062\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\f\u001a\u00028\u0000H\u0016\u00a2\u0006\u0004\b\u000f\u0010\u0010JC\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u000e0\r\"\u0014\b\u0000\u0010\t*\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u00062\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\f\u001a\u00028\u0000H\u0016\u00a2\u0006\u0004\b\u0011\u0010\u0010JC\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u000e0\r\"\u0014\b\u0000\u0010\t*\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u00062\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\f\u001a\u00028\u0000H\u0016\u00a2\u0006\u0004\b\u0012\u0010\u0010\u00a8\u0006\u0015"}, d2 = {"Lcom/tencent/mobileqq/aio/gamemsg/c;", "Lcom/tencent/qqnt/aio/menu/q;", "Lcom/tencent/mobileqq/aio/msg/AIOMsgItem;", "msgItem", "", "l", "Lcom/tencent/aio/base/mvvm/a;", "Lcom/tencent/qqnt/aio/holder/a;", "Lcom/tencent/qqnt/aio/holder/IMsgItemMviUIState;", "VB", "Landroid/content/Context;", "context", "vb", "", "Lcom/tencent/qqnt/aio/menu/ui/d;", "j", "(Landroid/content/Context;Lcom/tencent/mobileqq/aio/msg/AIOMsgItem;Lcom/tencent/aio/base/mvvm/a;)Ljava/util/List;", h.F, "d", "<init>", "()V", "aio_ext_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes10.dex */
public final class c extends q {
    static IPatchRedirector $redirector_;

    public c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // com.tencent.qqnt.aio.menu.q
    @NotNull
    public <VB extends com.tencent.aio.base.mvvm.a<com.tencent.qqnt.aio.holder.a, IMsgItemMviUIState>> List<d> d(@NotNull Context context, @NotNull AIOMsgItem msgItem, @NotNull VB vb5) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (List) iPatchRedirector.redirect((short) 5, this, context, msgItem, vb5);
        }
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(msgItem, "msgItem");
        Intrinsics.checkNotNullParameter(vb5, "vb");
        ArrayList arrayList = new ArrayList();
        arrayList.add(new com.tencent.qqnt.aio.menu.b(context, msgItem, vb5));
        arrayList.add(new com.tencent.qqnt.aio.menu.c(context, msgItem, vb5));
        arrayList.add(new k(context, msgItem, vb5, null, 8, null));
        arrayList.add(new com.tencent.qqnt.aio.menu.h(context, msgItem, vb5));
        arrayList.add(new aj(context, msgItem, vb5));
        arrayList.add(new ac(context, msgItem, vb5));
        return arrayList;
    }

    @Override // com.tencent.qqnt.aio.menu.q
    @NotNull
    public <VB extends com.tencent.aio.base.mvvm.a<com.tencent.qqnt.aio.holder.a, IMsgItemMviUIState>> List<d> h(@NotNull Context context, @NotNull AIOMsgItem msgItem, @NotNull VB vb5) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (List) iPatchRedirector.redirect((short) 4, this, context, msgItem, vb5);
        }
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(msgItem, "msgItem");
        Intrinsics.checkNotNullParameter(vb5, "vb");
        ArrayList arrayList = new ArrayList();
        arrayList.add(new com.tencent.qqnt.aio.menu.b(context, msgItem, vb5));
        arrayList.add(new k(context, msgItem, vb5, null, 8, null));
        arrayList.add(new i(context, msgItem));
        arrayList.add(new com.tencent.qqnt.aio.menu.h(context, msgItem, vb5));
        arrayList.add(new aj(context, msgItem, vb5));
        return arrayList;
    }

    @Override // com.tencent.qqnt.aio.menu.q
    @NotNull
    public <VB extends com.tencent.aio.base.mvvm.a<com.tencent.qqnt.aio.holder.a, IMsgItemMviUIState>> List<d> j(@NotNull Context context, @NotNull AIOMsgItem msgItem, @NotNull VB vb5) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (List) iPatchRedirector.redirect((short) 3, this, context, msgItem, vb5);
        }
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(msgItem, "msgItem");
        Intrinsics.checkNotNullParameter(vb5, "vb");
        ArrayList arrayList = new ArrayList();
        arrayList.add(new com.tencent.qqnt.aio.menu.d(context, msgItem));
        return arrayList;
    }

    @Override // com.tencent.qqnt.aio.menu.q
    public boolean l(@NotNull AIOMsgItem msgItem) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this, (Object) msgItem)).booleanValue();
        }
        Intrinsics.checkNotNullParameter(msgItem, "msgItem");
        if (msgItem.getMsgRecord().chatType == 105) {
            return true;
        }
        return false;
    }
}

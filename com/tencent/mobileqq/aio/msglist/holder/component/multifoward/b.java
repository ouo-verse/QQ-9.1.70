package com.tencent.mobileqq.aio.msglist.holder.component.multifoward;

import com.tencent.hippy.qq.api.TabPreloadItem;
import com.tencent.mobileqq.aio.event.MultiSelectEvent;
import com.tencent.mobileqq.aio.msg.AIOMsgItem;
import com.tencent.mobileqq.aio.msg.p;
import com.tencent.mobileqq.aio.msglist.holder.component.c;
import com.tencent.mobileqq.aio.msglist.holder.d;
import com.tencent.mobileqq.aio.utils.d;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\b\b\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0017\u0010\u0018J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u000e\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006J\u000e\u0010\f\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\nJ\u0016\u0010\r\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\u000e\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\nJ\u000e\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\nJ\u000e\u0010\u0010\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\nJ\u0014\u0010\u0013\u001a\u00020\u00042\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00020\u0011J\u0014\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00020\u00112\u0006\u0010\u000b\u001a\u00020\nJ\u0014\u0010\u0015\u001a\u00020\u00042\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00020\u0011J\u000e\u0010\u0016\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\n\u00a8\u0006\u0019"}, d2 = {"Lcom/tencent/mobileqq/aio/msglist/holder/component/multifoward/b;", "", "Lcom/tencent/mobileqq/aio/msg/AIOMsgItem;", "msgItem", "", "b", "Lcom/tencent/mobileqq/aio/msglist/holder/component/c;", "vb", "", "k", "Lcom/tencent/aio/api/runtime/a;", "context", "j", h.F, "f", "g", "a", "", TabPreloadItem.TAB_NAME_MESSAGE, "d", "e", "c", "i", "<init>", "()V", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes11.dex */
public final class b {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final b f191309a;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(62498);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 13)) {
            redirector.redirect((short) 13);
        } else {
            f191309a = new b();
        }
    }

    b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private final int b(AIOMsgItem msgItem) {
        if (msgItem instanceof p) {
            return msgItem.S();
        }
        return 1;
    }

    public final boolean a(@NotNull com.tencent.aio.api.runtime.a context) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return ((Boolean) iPatchRedirector.redirect((short) 7, (Object) this, (Object) context)).booleanValue();
        }
        Intrinsics.checkNotNullParameter(context, "context");
        List<AIOMsgItem> e16 = e(context);
        if ((e16 instanceof Collection) && e16.isEmpty()) {
            return false;
        }
        Iterator<T> it = e16.iterator();
        while (it.hasNext()) {
            if (d.F((AIOMsgItem) it.next())) {
                return true;
            }
        }
        return false;
    }

    public final int c(@NotNull List<? extends AIOMsgItem> msgList) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return ((Integer) iPatchRedirector.redirect((short) 11, (Object) this, (Object) msgList)).intValue();
        }
        Intrinsics.checkNotNullParameter(msgList, "msgList");
        Iterator<T> it = msgList.iterator();
        int i3 = 0;
        while (it.hasNext()) {
            i3 += f191309a.b((AIOMsgItem) it.next());
        }
        return i3;
    }

    public final int d(@NotNull List<? extends AIOMsgItem> msgList) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return ((Integer) iPatchRedirector.redirect((short) 8, (Object) this, (Object) msgList)).intValue();
        }
        Intrinsics.checkNotNullParameter(msgList, "msgList");
        int i3 = 0;
        for (AIOMsgItem aIOMsgItem : msgList) {
            if (!d.s(aIOMsgItem)) {
                i3 += f191309a.b(aIOMsgItem);
            }
        }
        return i3;
    }

    @NotNull
    public final List<AIOMsgItem> e(@NotNull com.tencent.aio.api.runtime.a context) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return (List) iPatchRedirector.redirect((short) 9, (Object) this, (Object) context);
        }
        Intrinsics.checkNotNullParameter(context, "context");
        MultiSelectEvent.GetSelectMsgList getSelectMsgList = new MultiSelectEvent.GetSelectMsgList(null, 1, 0 == true ? 1 : 0);
        context.e().h(getSelectMsgList);
        return getSelectMsgList.a();
    }

    public final int f(@NotNull com.tencent.aio.api.runtime.a context) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Integer) iPatchRedirector.redirect((short) 5, (Object) this, (Object) context)).intValue();
        }
        Intrinsics.checkNotNullParameter(context, "context");
        MultiSelectEvent.GetSelectMsgSum getSelectMsgSum = new MultiSelectEvent.GetSelectMsgSum(0, 1, null);
        context.e().h(getSelectMsgSum);
        return getSelectMsgSum.a();
    }

    public final int g(@NotNull com.tencent.aio.api.runtime.a context) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Integer) iPatchRedirector.redirect((short) 6, (Object) this, (Object) context)).intValue();
        }
        Intrinsics.checkNotNullParameter(context, "context");
        MultiSelectEvent.GetSelectNormalMsgSum getSelectNormalMsgSum = new MultiSelectEvent.GetSelectNormalMsgSum(0, 1, null);
        context.e().h(getSelectNormalMsgSum);
        return getSelectNormalMsgSum.a();
    }

    public final boolean h(@NotNull com.tencent.aio.api.runtime.a context, @NotNull AIOMsgItem msgItem) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Boolean) iPatchRedirector.redirect((short) 4, (Object) this, (Object) context, (Object) msgItem)).booleanValue();
        }
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(msgItem, "msgItem");
        MultiSelectEvent.IsMsgSelect isMsgSelect = new MultiSelectEvent.IsMsgSelect(msgItem, false, 2, null);
        context.e().h(isMsgSelect);
        return isMsgSelect.b();
    }

    public final boolean i(@NotNull com.tencent.aio.api.runtime.a context) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            return ((Boolean) iPatchRedirector.redirect((short) 12, (Object) this, (Object) context)).booleanValue();
        }
        Intrinsics.checkNotNullParameter(context, "context");
        MultiSelectEvent.IsMsgSelectPage isMsgSelectPage = new MultiSelectEvent.IsMsgSelectPage(false, 1, null);
        context.e().h(isMsgSelectPage);
        return isMsgSelectPage.a();
    }

    public final boolean j(@NotNull com.tencent.aio.api.runtime.a context) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this, (Object) context)).booleanValue();
        }
        Intrinsics.checkNotNullParameter(context, "context");
        MultiSelectEvent.GetSelectMode getSelectMode = new MultiSelectEvent.GetSelectMode(false, 1, null);
        context.e().h(getSelectMode);
        return getSelectMode.a();
    }

    public final boolean k(@NotNull c vb5) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this, (Object) vb5)).booleanValue();
        }
        Intrinsics.checkNotNullParameter(vb5, "vb");
        d.n nVar = new d.n(false, 1, null);
        vb5.sendIntent(nVar);
        return nVar.a();
    }
}

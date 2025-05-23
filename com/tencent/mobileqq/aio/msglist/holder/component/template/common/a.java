package com.tencent.mobileqq.aio.msglist.holder.component.template.common;

import com.tencent.mobileqq.aio.msg.AIOMsgItem;
import com.tencent.mobileqq.aio.msg.TemplateMsgItem;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\r\u0010\u000eJ\u0014\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002J\u001a\u0010\n\u001a\u00020\t2\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\u0010\b\u001a\u0004\u0018\u00010\u0006J\u0010\u0010\u000b\u001a\u00020\t2\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002J\u0010\u0010\f\u001a\u00020\t2\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u00a8\u0006\u000f"}, d2 = {"Lcom/tencent/mobileqq/aio/msglist/holder/component/template/common/a;", "", "Lcom/tencent/mobileqq/aio/msg/AIOMsgItem;", "msgItem", "Lcom/tencent/mobileqq/aio/msg/TemplateMsgItem;", "a", "", "appName", "viewName", "", "c", "b", "d", "<init>", "()V", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes11.dex */
public final class a {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final a f191908a;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(63334);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 6)) {
            redirector.redirect((short) 6);
        } else {
            f191908a = new a();
        }
    }

    a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private final TemplateMsgItem a(AIOMsgItem msgItem) {
        TemplateMsgItem templateMsgItem;
        if (msgItem instanceof TemplateMsgItem) {
            templateMsgItem = (TemplateMsgItem) msgItem;
        } else {
            templateMsgItem = null;
        }
        if (templateMsgItem == null) {
            return null;
        }
        if (templateMsgItem.n2() == null) {
            templateMsgItem.p2();
        }
        return templateMsgItem;
    }

    public final boolean b(@Nullable AIOMsgItem msgItem) {
        String str;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Boolean) iPatchRedirector.redirect((short) 4, (Object) this, (Object) msgItem)).booleanValue();
        }
        TemplateMsgItem a16 = a(msgItem);
        if (a16 == null) {
            return false;
        }
        com.tencent.mobileqq.aio.msg.template.d n26 = a16.n2();
        String str2 = null;
        if (n26 != null) {
            str = n26.a();
        } else {
            str = null;
        }
        com.tencent.mobileqq.aio.msg.template.d n27 = a16.n2();
        if (n27 != null) {
            str2 = n27.f();
        }
        return c(str, str2);
    }

    public final boolean c(@Nullable String appName, @Nullable String viewName) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this, (Object) appName, (Object) viewName)).booleanValue();
        }
        if (Intrinsics.areEqual(appName, "com.tencent.multimsg") && Intrinsics.areEqual(viewName, "contact")) {
            return true;
        }
        return false;
    }

    public final boolean d(@Nullable TemplateMsgItem msgItem) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Boolean) iPatchRedirector.redirect((short) 5, (Object) this, (Object) msgItem)).booleanValue();
        }
        TemplateMsgItem a16 = a(msgItem);
        if (a16 == null) {
            return false;
        }
        return k.f191932a.d(a16);
    }
}

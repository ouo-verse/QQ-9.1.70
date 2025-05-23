package com.tencent.mobileqq.reminder.multishare.config;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B5\u0012\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002\u0012\b\b\u0002\u0010\f\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0011\u001a\u00020\r\u0012\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u0012\u00a2\u0006\u0004\b\u0018\u0010\u0019R\u001d\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007R\u0017\u0010\f\u001a\u00020\u00038\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u0004\u0010\u000bR\u0017\u0010\u0011\u001a\u00020\r8\u0006\u00a2\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u000e\u0010\u0010R$\u0010\u0017\u001a\u0004\u0018\u00010\u00128\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0006\u0010\u0013\u001a\u0004\b\t\u0010\u0014\"\u0004\b\u0015\u0010\u0016\u00a8\u0006\u001a"}, d2 = {"Lcom/tencent/mobileqq/reminder/multishare/config/a;", "", "", "", "a", "Ljava/util/List;", "d", "()Ljava/util/List;", "userUinList", "b", "Ljava/lang/String;", "()Ljava/lang/String;", "msgHint", "", "c", "Z", "()Z", "showMoreUser", "Lcom/tencent/mobileqq/reminder/multishare/listener/a;", "Lcom/tencent/mobileqq/reminder/multishare/listener/a;", "()Lcom/tencent/mobileqq/reminder/multishare/listener/a;", "setMsgSendEventListener", "(Lcom/tencent/mobileqq/reminder/multishare/listener/a;)V", "msgSendEventListener", "<init>", "(Ljava/util/List;Ljava/lang/String;ZLcom/tencent/mobileqq/reminder/multishare/listener/a;)V", "qqreminder-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes18.dex */
public final class a {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final List<String> userUinList;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String msgHint;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private final boolean showMoreUser;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private com.tencent.mobileqq.reminder.multishare.listener.a msgSendEventListener;

    public a(@NotNull List<String> userUinList, @NotNull String msgHint, boolean z16, @Nullable com.tencent.mobileqq.reminder.multishare.listener.a aVar) {
        Intrinsics.checkNotNullParameter(userUinList, "userUinList");
        Intrinsics.checkNotNullParameter(msgHint, "msgHint");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, userUinList, msgHint, Boolean.valueOf(z16), aVar);
            return;
        }
        this.userUinList = userUinList;
        this.msgHint = msgHint;
        this.showMoreUser = z16;
        this.msgSendEventListener = aVar;
    }

    @NotNull
    public final String a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (String) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        return this.msgHint;
    }

    @Nullable
    public final com.tencent.mobileqq.reminder.multishare.listener.a b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (com.tencent.mobileqq.reminder.multishare.listener.a) iPatchRedirector.redirect((short) 6, (Object) this);
        }
        return this.msgSendEventListener;
    }

    public final boolean c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Boolean) iPatchRedirector.redirect((short) 5, (Object) this)).booleanValue();
        }
        return this.showMoreUser;
    }

    @NotNull
    public final List<String> d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (List) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return this.userUinList;
    }

    public /* synthetic */ a(List list, String str, boolean z16, com.tencent.mobileqq.reminder.multishare.listener.a aVar, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(list, (i3 & 2) != 0 ? "" : str, (i3 & 4) != 0 ? false : z16, (i3 & 8) != 0 ? null : aVar);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            return;
        }
        iPatchRedirector.redirect((short) 2, this, list, str, Boolean.valueOf(z16), aVar, Integer.valueOf(i3), defaultConstructorMarker);
    }
}

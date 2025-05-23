package com.tencent.mobileqq.multishare.item;

import com.tencent.mobileqq.multishare.action.c;
import com.tencent.mobileqq.multishare.p007const.MultiShareSelectStatus;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\t\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0015\u001a\u00020\u0014\u0012\u0006\u0010\u0016\u001a\u00020\u0002\u0012\u0006\u0010\u0017\u001a\u00020\u0014\u00a2\u0006\u0004\b\u0018\u0010\u0019J\b\u0010\u0003\u001a\u00020\u0002H\u0016R\"\u0010\u000b\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\"\u0010\u0013\u001a\u00020\f8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012\u00a8\u0006\u001a"}, d2 = {"Lcom/tencent/mobileqq/multishare/item/a;", "Lcom/tencent/mobileqq/multishare/action/c;", "", "a", "Lcom/tencent/mobileqq/multishare/const/MultiShareSelectStatus;", "e", "Lcom/tencent/mobileqq/multishare/const/MultiShareSelectStatus;", "i", "()Lcom/tencent/mobileqq/multishare/const/MultiShareSelectStatus;", "k", "(Lcom/tencent/mobileqq/multishare/const/MultiShareSelectStatus;)V", "selectStatus", "", "f", "J", "getLastMsgTime", "()J", "j", "(J)V", "lastMsgTime", "", "uin", "uinType", "name", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "qqmultishare-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes15.dex */
public final class a extends c {
    static IPatchRedirector $redirector_;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private MultiShareSelectStatus selectStatus;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private long lastMsgTime;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(@NotNull String uin, int i3, @NotNull String name) {
        super(uin, i3, name);
        Intrinsics.checkNotNullParameter(uin, "uin");
        Intrinsics.checkNotNullParameter(name, "name");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, uin, Integer.valueOf(i3), name);
        } else {
            this.selectStatus = MultiShareSelectStatus.UNSELECTED;
        }
    }

    @Override // com.tencent.mobileqq.multishare.action.c, com.tencent.mobileqq.multishare.action.a
    /* renamed from: a */
    public int getId() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Integer) iPatchRedirector.redirect((short) 6, (Object) this)).intValue();
        }
        return 0;
    }

    @NotNull
    public final MultiShareSelectStatus i() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (MultiShareSelectStatus) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return this.selectStatus;
    }

    public final void j(long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, j3);
        } else {
            this.lastMsgTime = j3;
        }
    }

    public final void k(@NotNull MultiShareSelectStatus multiShareSelectStatus) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) multiShareSelectStatus);
        } else {
            Intrinsics.checkNotNullParameter(multiShareSelectStatus, "<set-?>");
            this.selectStatus = multiShareSelectStatus;
        }
    }
}

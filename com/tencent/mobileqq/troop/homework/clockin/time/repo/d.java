package com.tencent.mobileqq.troop.homework.clockin.time.repo;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.troop.homework.common.widget.pickersheet.a;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\b\n\u0002\b\u000b\b&\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0015\u0010\u0016J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u0006\u0010\u0006\u001a\u00020\u0002J\b\u0010\b\u001a\u00020\u0007H&J\b\u0010\n\u001a\u00020\tH&J\u0016\u0010\u000e\u001a\u00020\u00042\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\f0\u000bH&R$\u0010\u0014\u001a\u0004\u0018\u00010\u00028\u0004@\u0004X\u0084\u000e\u00a2\u0006\u0012\n\u0004\b\u0006\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013\u00a8\u0006\u0017"}, d2 = {"Lcom/tencent/mobileqq/troop/homework/clockin/time/repo/d;", "", "Lcom/tencent/mobileqq/troop/homework/clockin/time/data/a;", "info", "", "f", "a", "", "c", "Lcom/tencent/mobileqq/troop/homework/common/widget/pickersheet/a$b;", "b", "", "", "selectItems", "e", "Lcom/tencent/mobileqq/troop/homework/clockin/time/data/a;", "d", "()Lcom/tencent/mobileqq/troop/homework/clockin/time/data/a;", "setTimeInfo", "(Lcom/tencent/mobileqq/troop/homework/clockin/time/data/a;)V", "timeInfo", "<init>", "()V", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes19.dex */
public abstract class d {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private com.tencent.mobileqq.troop.homework.clockin.time.data.a timeInfo;

    public d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @NotNull
    public final com.tencent.mobileqq.troop.homework.clockin.time.data.a a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (com.tencent.mobileqq.troop.homework.clockin.time.data.a) iPatchRedirector.redirect((short) 5, (Object) this);
        }
        com.tencent.mobileqq.troop.homework.clockin.time.data.a aVar = this.timeInfo;
        if (aVar == null) {
            return new com.tencent.mobileqq.troop.homework.clockin.time.data.a(0, null, 0L, 7, null);
        }
        return aVar;
    }

    @NotNull
    public abstract a.b b();

    @NotNull
    public abstract String c();

    /* JADX INFO: Access modifiers changed from: protected */
    @Nullable
    public final com.tencent.mobileqq.troop.homework.clockin.time.data.a d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (com.tencent.mobileqq.troop.homework.clockin.time.data.a) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return this.timeInfo;
    }

    public abstract void e(@NotNull List<Integer> selectItems);

    public final void f(@NotNull com.tencent.mobileqq.troop.homework.clockin.time.data.a info) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) info);
        } else {
            Intrinsics.checkNotNullParameter(info, "info");
            this.timeInfo = info;
        }
    }
}

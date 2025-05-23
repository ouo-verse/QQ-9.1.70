package com.tencent.mobileqq.troop.homework.clockin.time.repo;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0007\u0010\bJ\u0014\u0010\u0006\u001a\u00020\u00052\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002\u00a8\u0006\t"}, d2 = {"Lcom/tencent/mobileqq/troop/homework/clockin/time/repo/c;", "", "", "", "daysIntList", "", "a", "<init>", "()V", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes19.dex */
public final class c {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final c f296621a;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(45893);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 4)) {
            redirector.redirect((short) 4);
        } else {
            f296621a = new c();
        }
    }

    c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @NotNull
    public final String a(@NotNull List<Integer> daysIntList) {
        List sorted;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (String) iPatchRedirector.redirect((short) 3, (Object) this, (Object) daysIntList);
        }
        Intrinsics.checkNotNullParameter(daysIntList, "daysIntList");
        sorted = CollectionsKt___CollectionsKt.sorted(daysIntList);
        if (sorted.size() == 7) {
            return "\u6bcf\u5929";
        }
        int size = daysIntList.size();
        String str = "";
        for (int i3 = 0; i3 < size; i3++) {
            str = str + com.tencent.mobileqq.troop.homework.clockin.b.f296279a.a()[((Number) sorted.get(i3)).intValue()];
            if (i3 != daysIntList.size() - 1) {
                str = str + "\uff0c";
            }
        }
        return str;
    }
}

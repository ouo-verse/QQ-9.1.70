package com.tencent.qqnt.kernel.internel;

import com.tencent.component.media.image.ProgressTracer;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.collections.ArraysKt___ArraysKt;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0004\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\t\u0010\nJ!\u0010\u0005\u001a\u00020\u00042\u0012\u0010\u0003\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00010\u0002\"\u00020\u0001\u00a2\u0006\u0004\b\u0005\u0010\u0006J\u0014\u0010\b\u001a\u00020\u00042\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00010\u0007\u00a8\u0006\u000b"}, d2 = {"Lcom/tencent/qqnt/kernel/internel/a;", "", "", "msg", "", "b", "([Ljava/lang/Object;)Ljava/lang/String;", "", "a", "<init>", "()V", "kernel_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes24.dex */
public final class a {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final a f359089a;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(54549);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 4)) {
            redirector.redirect((short) 4);
        } else {
            f359089a = new a();
        }
    }

    a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @NotNull
    public final String a(@NotNull List<? extends Object> msg2) {
        int collectionSizeOrDefault;
        String valueOf;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (String) iPatchRedirector.redirect((short) 3, (Object) this, (Object) msg2);
        }
        Intrinsics.checkNotNullParameter(msg2, "msg");
        List<? extends Object> list = msg2;
        collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(list, 10);
        ArrayList arrayList = new ArrayList(collectionSizeOrDefault);
        for (Object obj : list) {
            if (obj instanceof Pair) {
                Pair pair = (Pair) obj;
                valueOf = "(" + pair.getFirst() + ProgressTracer.SEPARATOR + pair.getSecond() + ")";
            } else {
                valueOf = String.valueOf(obj);
            }
            arrayList.add(valueOf);
        }
        return arrayList.toString();
    }

    @NotNull
    public final String b(@NotNull Object... msg2) {
        List<? extends Object> list;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (String) iPatchRedirector.redirect((short) 2, (Object) this, (Object) msg2);
        }
        Intrinsics.checkNotNullParameter(msg2, "msg");
        list = ArraysKt___ArraysKt.toList(msg2);
        return a(list);
    }
}

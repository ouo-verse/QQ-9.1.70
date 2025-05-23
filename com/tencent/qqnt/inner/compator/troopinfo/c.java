package com.tencent.qqnt.inner.compator.troopinfo;

import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qqnt.inner.compator.troopinfo.processor.g;
import com.tencent.qqnt.inner.compator.troopinfo.processor.k;
import com.tencent.qqnt.inner.compator.troopinfo.processor.m;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u000f\u0010\u0010J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u0010\u0010\b\u001a\u00020\u00002\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006J\u0010\u0010\t\u001a\u00020\u00002\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006J\u0006\u0010\n\u001a\u00020\u0004R$\u0010\u000e\u001a\u0012\u0012\u0004\u0012\u00020\u00020\u000bj\b\u0012\u0004\u0012\u00020\u0002`\f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\r\u00a8\u0006\u0011"}, d2 = {"Lcom/tencent/qqnt/inner/compator/troopinfo/c;", "", "Lcom/tencent/qqnt/inner/compator/troopinfo/a;", "processor", "", "a", "Lcom/tencent/mobileqq/data/troop/TroopInfo;", "troopInfo", "c", "b", "d", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "Ljava/util/ArrayList;", "mProcessorList", "<init>", "()V", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes24.dex */
public final class c {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final ArrayList<a> mProcessorList;

    public c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        ArrayList<a> arrayList = new ArrayList<>();
        this.mProcessorList = arrayList;
        arrayList.add(new k());
        arrayList.add(new g());
        arrayList.add(new m());
        arrayList.add(new com.tencent.mobileqq.troop.troopidentity.processor.a());
    }

    public final void a(@NotNull a processor) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) processor);
        } else {
            Intrinsics.checkNotNullParameter(processor, "processor");
            this.mProcessorList.add(processor);
        }
    }

    @NotNull
    public final c b(@Nullable TroopInfo troopInfo) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (c) iPatchRedirector.redirect((short) 4, (Object) this, (Object) troopInfo);
        }
        Iterator<T> it = this.mProcessorList.iterator();
        while (it.hasNext()) {
            ((a) it.next()).c(troopInfo);
        }
        return this;
    }

    @NotNull
    public final c c(@Nullable TroopInfo troopInfo) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (c) iPatchRedirector.redirect((short) 3, (Object) this, (Object) troopInfo);
        }
        Iterator<T> it = this.mProcessorList.iterator();
        while (it.hasNext()) {
            ((a) it.next()).b(troopInfo);
        }
        return this;
    }

    public final void d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this);
            return;
        }
        Iterator<T> it = this.mProcessorList.iterator();
        while (it.hasNext()) {
            ((a) it.next()).a();
        }
    }
}

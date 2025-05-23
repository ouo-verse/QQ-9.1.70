package com.tencent.qqnt.pluspanel.data.loader;

import android.os.Bundle;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qqnt.pluspanel.utils.a;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0011\u0010\u0012JB\u0010\t\u001a.\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u00060\u0005j\u0016\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u0006`\b2\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0002JD\u0010\r\u001a.\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u00060\u0005j\u0016\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u0006`\b2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\u0003H\u0016J\"\u0010\u0010\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\u000e\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\u0003H\u0016\u00a8\u0006\u0013"}, d2 = {"Lcom/tencent/qqnt/pluspanel/data/loader/g;", "Lcom/tencent/qqnt/pluspanel/data/loader/d;", "", "", "list", "Ljava/util/ArrayList;", "Lkotlin/Pair;", "Landroid/os/Bundle;", "Lkotlin/collections/ArrayList;", "c", "", "curId", "curType", "a", "appID", "Lcom/tencent/qqnt/pluspanel/data/b;", "b", "<init>", "()V", "plus_panel_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes22.dex */
public final class g implements d {
    static IPatchRedirector $redirector_;

    public g() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private final ArrayList<Pair<Integer, Bundle>> c(List<Integer> list) {
        ArrayList<Pair<Integer, Bundle>> arrayList = new ArrayList<>();
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(new Pair<>(Integer.valueOf(((Number) it.next()).intValue()), null));
        }
        return arrayList;
    }

    @Override // com.tencent.qqnt.pluspanel.data.loader.d
    @NotNull
    public ArrayList<Pair<Integer, Bundle>> a(@NotNull String curId, int curType) {
        ArrayList arrayListOf;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (ArrayList) iPatchRedirector.redirect((short) 2, (Object) this, (Object) curId, curType);
        }
        Intrinsics.checkNotNullParameter(curId, "curId");
        a.Companion companion = com.tencent.qqnt.pluspanel.utils.a.INSTANCE;
        arrayListOf = CollectionsKt__CollectionsKt.arrayListOf(Integer.valueOf(companion.z()), Integer.valueOf(companion.G()));
        return c(arrayListOf);
    }

    @Override // com.tencent.qqnt.pluspanel.data.loader.d
    @Nullable
    public com.tencent.qqnt.pluspanel.data.b b(int appID, @NotNull String curId, int curType) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (com.tencent.qqnt.pluspanel.data.b) iPatchRedirector.redirect((short) 4, this, Integer.valueOf(appID), curId, Integer.valueOf(curType));
        }
        Intrinsics.checkNotNullParameter(curId, "curId");
        com.tencent.qqnt.pluspanel.config.b f16 = com.tencent.qqnt.pluspanel.config.e.f360364a.f(String.valueOf(appID));
        if (f16 != null) {
            com.tencent.qqnt.pluspanel.data.b bVar = new com.tencent.qqnt.pluspanel.data.b(0);
            bVar.q(f16.r());
            bVar.p(f16.o());
            bVar.w(f16.p());
            bVar.l(f16.h());
            bVar.m(f16.i());
            bVar.t(f16.n());
            return bVar;
        }
        return null;
    }
}

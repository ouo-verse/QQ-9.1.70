package com.tencent.mobileqq.troop.homework.common.trooplist.data;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringNumberConversionsKt;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u000b\u0018\u00002\u00020\u0001B\u001d\u0012\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006\u0012\u0006\u0010\u000f\u001a\u00020\u0007\u00a2\u0006\u0004\b\u0010\u0010\u0011J\u0016\u0010\u0005\u001a\u0012\u0012\u0004\u0012\u00020\u00030\u0002j\b\u0012\u0004\u0012\u00020\u0003`\u0004R\u001d\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00070\u00068\u0006\u00a2\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR\u0017\u0010\u000f\u001a\u00020\u00078\u0006\u00a2\u0006\f\n\u0004\b\n\u0010\r\u001a\u0004\b\b\u0010\u000e\u00a8\u0006\u0012"}, d2 = {"Lcom/tencent/mobileqq/troop/homework/common/trooplist/data/b;", "", "Ljava/util/ArrayList;", "", "Lkotlin/collections/ArrayList;", "c", "", "", "a", "Ljava/util/List;", "b", "()Ljava/util/List;", "troopUinList", "Ljava/lang/String;", "()Ljava/lang/String;", "troopNameListStr", "<init>", "(Ljava/util/List;Ljava/lang/String;)V", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes19.dex */
public final class b {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final List<String> troopUinList;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String troopNameListStr;

    public b(@NotNull List<String> troopUinList, @NotNull String troopNameListStr) {
        Intrinsics.checkNotNullParameter(troopUinList, "troopUinList");
        Intrinsics.checkNotNullParameter(troopNameListStr, "troopNameListStr");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) troopUinList, (Object) troopNameListStr);
        } else {
            this.troopUinList = troopUinList;
            this.troopNameListStr = troopNameListStr;
        }
    }

    @NotNull
    public final String a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (String) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return this.troopNameListStr;
    }

    @NotNull
    public final List<String> b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (List) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return this.troopUinList;
    }

    @NotNull
    public final ArrayList<Long> c() {
        Long longOrNull;
        long j3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (ArrayList) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        ArrayList<Long> arrayList = new ArrayList<>();
        Iterator<String> it = this.troopUinList.iterator();
        while (it.hasNext()) {
            longOrNull = StringsKt__StringNumberConversionsKt.toLongOrNull(it.next());
            if (longOrNull != null) {
                j3 = longOrNull.longValue();
            } else {
                j3 = 0;
            }
            arrayList.add(Long.valueOf(j3));
        }
        return arrayList;
    }
}

package com.tencent.qqnt.avatar.core;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.qqnt.avatar.layer.d;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__MutableCollectionsJVMKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.comparisons.ComparisonsKt__ComparisonsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010$\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001:\u0001\u0007J$\u0010\u0007\u001a\u00020\u00062\u001a\u0010\u0005\u001a\u0016\u0012\u0004\u0012\u00020\u0003\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u00010\u00040\u0002H&\u00a8\u0006\b"}, d2 = {"Lcom/tencent/qqnt/avatar/core/b;", "", "", "", "Lcom/tencent/qqnt/avatar/layer/d;", "raw", "Lcom/tencent/qqnt/avatar/core/c;", "a", "avatar_util_kit_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes23.dex */
public interface b {

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\t\u0010\nJ$\u0010\b\u001a\u00020\u00072\u001a\u0010\u0006\u001a\u0016\u0012\u0004\u0012\u00020\u0003\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u00050\u00040\u0002H\u0016\u00a8\u0006\u000b"}, d2 = {"Lcom/tencent/qqnt/avatar/core/b$a;", "Lcom/tencent/qqnt/avatar/core/b;", "", "", "Lcom/tencent/qqnt/avatar/layer/d;", "", "raw", "Lcom/tencent/qqnt/avatar/core/c;", "a", "<init>", "()V", "avatar_util_kit_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes23.dex */
    public static final class a implements b {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        @NotNull
        public static final a f352736a;

        /* compiled from: P */
        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u000e\u0010\u0003\u001a\n \u0004*\u0004\u0018\u0001H\u0002H\u00022\u000e\u0010\u0005\u001a\n \u0004*\u0004\u0018\u0001H\u0002H\u0002H\n\u00a2\u0006\u0004\b\u0006\u0010\u0007\u00a8\u0006\b"}, d2 = {"<anonymous>", "", "T", "a", "kotlin.jvm.PlatformType", "b", "compare", "(Ljava/lang/Object;Ljava/lang/Object;)I", "kotlin/comparisons/ComparisonsKt__ComparisonsKt$compareBy$2"}, k = 3, mv = {1, 7, 1}, xi = 48)
        /* renamed from: com.tencent.qqnt.avatar.core.b$a$a, reason: collision with other inner class name */
        /* loaded from: classes23.dex */
        public static final class C9508a<T> implements Comparator {
            static IPatchRedirector $redirector_;

            public C9508a() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this);
                }
            }

            /* JADX WARN: Multi-variable type inference failed */
            @Override // java.util.Comparator
            public final int compare(T t16, T t17) {
                int compareValues;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                    compareValues = ComparisonsKt__ComparisonsKt.compareValues(Integer.valueOf(((d) t16).b().b()), Integer.valueOf(((d) t17).b().b()));
                    return compareValues;
                }
                return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this, (Object) t16, (Object) t17)).intValue();
            }
        }

        static {
            IPatchRedirector redirector = PatchRedirectCenter.getRedirector(39071);
            $redirector_ = redirector;
            if (redirector != null && redirector.hasPatch((short) 3)) {
                redirector.redirect((short) 3);
            } else {
                f352736a = new a();
            }
        }

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }

        @Override // com.tencent.qqnt.avatar.core.b
        @NotNull
        public c a(@NotNull Map<Integer, ? extends d<? extends Object>> raw) {
            List list;
            Map map;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (c) iPatchRedirector.redirect((short) 2, (Object) this, (Object) raw);
            }
            Intrinsics.checkNotNullParameter(raw, "raw");
            ArrayList arrayList = new ArrayList();
            arrayList.addAll(raw.values());
            if (arrayList.size() > 1) {
                CollectionsKt__MutableCollectionsJVMKt.sortWith(arrayList, new C9508a());
            }
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            Iterator<Integer> it = raw.keySet().iterator();
            while (it.hasNext()) {
                linkedHashMap.put(Integer.valueOf(it.next().intValue()), 0);
            }
            list = CollectionsKt___CollectionsKt.toList(arrayList);
            map = MapsKt__MapsKt.toMap(linkedHashMap);
            return new c(list, map);
        }
    }

    @NotNull
    c a(@NotNull Map<Integer, ? extends d<? extends Object>> raw);
}

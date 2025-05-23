package com.tencent.cachedrawable.dynamicdrawable.cachedrawable;

import android.text.TextUtils;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__IteratorsJVMKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000f\u0010\u0010J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J&\u0010\n\u001a\u0012\u0012\u0004\u0012\u00020\u00040\bj\b\u0012\u0004\u0012\u00020\u0004`\t2\u0006\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0002R&\u0010\u000e\u001a\u0014\u0012\u0004\u0012\u00020\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\f0\u000b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\n\u0010\r\u00a8\u0006\u0011"}, d2 = {"Lcom/tencent/cachedrawable/dynamicdrawable/cachedrawable/e;", "", "", "sceneBusinessTag", "Lcom/tencent/cachedrawable/dynamicdrawable/cachedrawable/d;", "a", "scene", "business", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "b", "Ljava/util/concurrent/ConcurrentHashMap;", "Ljava/lang/ref/WeakReference;", "Ljava/util/concurrent/ConcurrentHashMap;", "timeLineMap", "<init>", "()V", "cachedrawable_debug"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes5.dex */
public final class e {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final e f98943a;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final ConcurrentHashMap<String, WeakReference<d>> timeLineMap;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(8759);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 4)) {
            redirector.redirect((short) 4);
        } else {
            f98943a = new e();
            timeLineMap = new ConcurrentHashMap<>();
        }
    }

    e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @NotNull
    public final d a(@NotNull String sceneBusinessTag) {
        d dVar;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (d) iPatchRedirector.redirect((short) 2, (Object) this, (Object) sceneBusinessTag);
        }
        Intrinsics.checkNotNullParameter(sceneBusinessTag, "sceneBusinessTag");
        ConcurrentHashMap<String, WeakReference<d>> concurrentHashMap = timeLineMap;
        WeakReference<d> weakReference = concurrentHashMap.get(sceneBusinessTag);
        if (weakReference == null || (dVar = weakReference.get()) == null) {
            d dVar2 = new d(sceneBusinessTag);
            concurrentHashMap.put(sceneBusinessTag, new WeakReference<>(dVar2));
            return dVar2;
        }
        return dVar;
    }

    @NotNull
    public final ArrayList<d> b(@NotNull String scene, @NotNull String business) {
        Iterator it;
        boolean startsWith$default;
        WeakReference<d> weakReference;
        d dVar;
        d dVar2;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (ArrayList) iPatchRedirector.redirect((short) 3, (Object) this, (Object) scene, (Object) business);
        }
        Intrinsics.checkNotNullParameter(scene, "scene");
        Intrinsics.checkNotNullParameter(business, "business");
        ArrayList<d> arrayList = new ArrayList<>();
        String a16 = k.INSTANCE.a(scene, business);
        if (!TextUtils.isEmpty(business)) {
            WeakReference<d> weakReference2 = timeLineMap.get(a16);
            if (weakReference2 != null && (dVar2 = weakReference2.get()) != null) {
                arrayList.add(dVar2);
            }
            return arrayList;
        }
        Enumeration<String> keys = timeLineMap.keys();
        Intrinsics.checkNotNullExpressionValue(keys, "timeLineMap.keys()");
        it = CollectionsKt__IteratorsJVMKt.iterator(keys);
        while (it.hasNext()) {
            String key = (String) it.next();
            Intrinsics.checkNotNullExpressionValue(key, "key");
            startsWith$default = StringsKt__StringsJVMKt.startsWith$default(key, scene, false, 2, null);
            if (startsWith$default && (weakReference = timeLineMap.get(key)) != null && (dVar = weakReference.get()) != null) {
                arrayList.add(dVar);
            }
        }
        return arrayList;
    }
}

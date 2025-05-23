package com.tencent.qqnt.chats.biz.summary.state.core;

import android.content.Context;
import com.tencent.biz.pubaccount.util.api.impl.PublicAccountMessageUtilImpl;
import com.tencent.mobileqq.listentogether.nt.d;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.annotation.qautoinject.QAutoInjectJustClazz;
import com.tencent.mobileqq.troop.j;
import com.tencent.qqnt.chats.core.adapter.itemdata.g;
import iv.e;
import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.ArraysKt___ArraysKt;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010 \n\u0002\b\u0005\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0019\u0010\u0013J'\u0010\t\u001a\u0004\u0018\u00010\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006\u00a2\u0006\u0004\b\t\u0010\nR,\u0010\u0014\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\r0\f0\u000b8\u0006X\u0087\u0004\u00a2\u0006\u0012\n\u0004\b\u000e\u0010\u000f\u0012\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0010\u0010\u0011R\u001a\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\r0\u00158\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0016\u0010\u0017\u00a8\u0006\u001a"}, d2 = {"Lcom/tencent/qqnt/chats/biz/summary/state/core/b;", "", "Lcom/tencent/qqnt/chats/core/adapter/itemdata/g;", PublicAccountMessageUtilImpl.ITEM_STRUCT_FIRST_LEVEL_NAME, "Landroid/content/Context;", "context", "Lmqq/app/AppRuntime;", "appRuntime", "", "a", "(Lcom/tencent/qqnt/chats/core/adapter/itemdata/g;Landroid/content/Context;Lmqq/app/AppRuntime;)Ljava/lang/Integer;", "Ljava/util/ArrayList;", "Ljava/lang/Class;", "Lcom/tencent/qqnt/chats/biz/summary/state/core/a;", "b", "Ljava/util/ArrayList;", "getSupplierClass", "()Ljava/util/ArrayList;", "getSupplierClass$annotations", "()V", "supplierClass", "", "c", "Ljava/util/List;", "mSupplierList", "<init>", "chats_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes24.dex */
public final class b {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final b f354416a;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @QAutoInjectJustClazz(configPath = "AutoInjectYml/Business/Chats/Inject_SummaryState.yml", version = 3)
    @NotNull
    private static final ArrayList<Class<a>> supplierClass;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final List<a> mSupplierList;

    static {
        int collectionSizeOrDefault;
        Object first;
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(44264);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 3)) {
            redirector.redirect((short) 3);
            return;
        }
        f354416a = new b();
        ArrayList<Class<a>> arrayList = new ArrayList<>();
        supplierClass = arrayList;
        arrayList.add(com.tencent.qqnt.chats.biz.summary.state.a.class);
        arrayList.add(com.tencent.qqnt.state.a.class);
        arrayList.add(d.class);
        arrayList.add(e.class);
        arrayList.add(j.class);
        collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(arrayList, 10);
        ArrayList arrayList2 = new ArrayList(collectionSizeOrDefault);
        Iterator<T> it = arrayList.iterator();
        while (it.hasNext()) {
            Constructor<?>[] constructors = ((Class) it.next()).getConstructors();
            Intrinsics.checkNotNullExpressionValue(constructors, "it.constructors");
            first = ArraysKt___ArraysKt.first(constructors);
            Object newInstance = ((Constructor) first).newInstance(new Object[0]);
            Intrinsics.checkNotNull(newInstance, "null cannot be cast to non-null type com.tencent.qqnt.chats.biz.summary.state.core.ISummaryStateSupplier");
            arrayList2.add((a) newInstance);
        }
        mSupplierList = arrayList2;
    }

    b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Nullable
    public final Integer a(@NotNull g item, @NotNull Context context, @NotNull AppRuntime appRuntime) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (Integer) iPatchRedirector.redirect((short) 2, this, item, context, appRuntime);
        }
        Intrinsics.checkNotNullParameter(item, "item");
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(appRuntime, "appRuntime");
        if (!item.q().getBoolean("is_first_data", false)) {
            Iterator<T> it = mSupplierList.iterator();
            while (it.hasNext()) {
                Integer a16 = ((a) it.next()).a(item, context, appRuntime);
                if (a16 != null) {
                    return a16;
                }
            }
        }
        return 0;
    }
}

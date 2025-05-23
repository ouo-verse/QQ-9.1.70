package com.tencent.mobileqq.app.message.cleanup.tree;

import android.text.TextUtils;
import com.tencent.mobileqq.app.message.filescan.d;
import com.tencent.mobileqq.app.message.messageclean.y;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.CollectionsKt__MutableCollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import kotlin.text.StringsKt__StringsKt;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0005\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0015\u0010\u0016J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u00a6\u0001\u0010\u0011\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u000428\u0010\r\u001a4\u0012\u0004\u0012\u00020\u0004\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\n0\tj\u001e\u0012\u0004\u0012\u00020\u0004\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\u00040\nj\b\u0012\u0004\u0012\u00020\u0004`\f`\u000b28\u0010\u000e\u001a4\u0012\u0004\u0012\u00020\u0004\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\n0\tj\u001e\u0012\u0004\u0012\u00020\u0004\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\u00040\nj\b\u0012\u0004\u0012\u00020\u0004`\f`\u000b2\"\u0010\u0010\u001a\u001e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u000f0\tj\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u000f`\u000bR\u001a\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00040\u00128\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\u0013\u00a8\u0006\u0017"}, d2 = {"Lcom/tencent/mobileqq/app/message/cleanup/tree/a;", "", "Lcom/tencent/mobileqq/app/message/cleanup/tree/b;", "root", "", "path", "", "b", "prefix", "Ljava/util/HashMap;", "Ljava/util/ArrayList;", "Lkotlin/collections/HashMap;", "Lkotlin/collections/ArrayList;", "configWhiteList", "configDeleteWhiteList", "Lcom/tencent/mobileqq/app/message/messageclean/y;", "localWhiteList", "a", "", "Ljava/util/List;", "avoidCoverPath", "<init>", "()V", "storage-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes11.dex */
public final class a {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final a f195961a;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final List<String> avoidCoverPath;

    static {
        ArrayList arrayListOf;
        List<String> plus;
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(18839);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 3)) {
            redirector.redirect((short) 3);
            return;
        }
        f195961a = new a();
        d dVar = d.f195978a;
        arrayListOf = CollectionsKt__CollectionsKt.arrayListOf(dVar.b(), dVar.j(), dVar.f());
        plus = CollectionsKt___CollectionsKt.plus((Collection) arrayListOf, (Iterable) dVar.m());
        avoidCoverPath = plus;
    }

    a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private final void b(b root, String path) {
        List split$default;
        Object obj;
        if (!TextUtils.isEmpty(path)) {
            split$default = StringsKt__StringsKt.split$default((CharSequence) path, new String[]{"/"}, false, 0, 6, (Object) null);
            String str = (String) split$default.get(0);
            Iterator<T> it = root.a().iterator();
            while (true) {
                if (it.hasNext()) {
                    obj = it.next();
                    if (TextUtils.equals(((b) obj).b(), str)) {
                        break;
                    }
                } else {
                    obj = null;
                    break;
                }
            }
            b bVar = (b) obj;
            if (bVar == null) {
                bVar = new b(str, new ArrayList());
                root.a().add(bVar);
            }
            if (str.length() + 1 > path.length()) {
                return;
            }
            String substring = path.substring(str.length() + 1);
            Intrinsics.checkNotNullExpressionValue(substring, "this as java.lang.String).substring(startIndex)");
            b(bVar, substring);
        }
    }

    @NotNull
    public final b a(@NotNull String prefix, @NotNull HashMap<String, ArrayList<String>> configWhiteList, @NotNull HashMap<String, ArrayList<String>> configDeleteWhiteList, @NotNull HashMap<String, y> localWhiteList) {
        List flatten;
        List plus;
        Collection plus2;
        int collectionSizeOrDefault;
        boolean startsWith$default;
        List flatten2;
        List plus3;
        boolean z16;
        boolean startsWith$default2;
        IPatchRedirector iPatchRedirector = $redirector_;
        boolean z17 = true;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (b) iPatchRedirector.redirect((short) 2, this, prefix, configWhiteList, configDeleteWhiteList, localWhiteList);
        }
        Intrinsics.checkNotNullParameter(prefix, "prefix");
        Intrinsics.checkNotNullParameter(configWhiteList, "configWhiteList");
        Intrinsics.checkNotNullParameter(configDeleteWhiteList, "configDeleteWhiteList");
        Intrinsics.checkNotNullParameter(localWhiteList, "localWhiteList");
        String str = prefix + '/';
        b bVar = new b(prefix, new ArrayList());
        Collection<y> values = localWhiteList.values();
        Intrinsics.checkNotNullExpressionValue(values, "localWhiteList\n         \u2026\u914d\u7f6e\u7684\u76ee\u5f55\n            .values");
        ArrayList arrayList = new ArrayList();
        Iterator<T> it = values.iterator();
        while (it.hasNext()) {
            CollectionsKt__MutableCollectionsKt.addAll(arrayList, ((y) it.next()).getWhiteList());
        }
        Collection<ArrayList<String>> values2 = configWhiteList.values();
        Intrinsics.checkNotNullExpressionValue(values2, "configWhiteList.values");
        flatten = CollectionsKt__IterablesKt.flatten(values2);
        plus = CollectionsKt___CollectionsKt.plus((Collection) arrayList, (Iterable) flatten);
        ArrayList arrayList2 = new ArrayList();
        for (Object obj : plus) {
            String str2 = (String) obj;
            Collection<ArrayList<String>> values3 = configDeleteWhiteList.values();
            Intrinsics.checkNotNullExpressionValue(values3, "configDeleteWhiteList.values");
            flatten2 = CollectionsKt__IterablesKt.flatten(values3);
            plus3 = CollectionsKt___CollectionsKt.plus((Collection) flatten2, (Iterable) avoidCoverPath);
            Iterator it5 = plus3.iterator();
            while (true) {
                if (it5.hasNext()) {
                    String str3 = str2 + '/';
                    startsWith$default2 = StringsKt__StringsJVMKt.startsWith$default(str3, ((String) it5.next()) + '/', false, 2, null);
                    if (startsWith$default2) {
                        QLog.d("TreeBuilder", 1, "constructWhiteListTree filter path: " + str2);
                        z16 = false;
                        break;
                    }
                } else {
                    z16 = true;
                    break;
                }
            }
            if (z16) {
                arrayList2.add(obj);
            }
        }
        plus2 = CollectionsKt___CollectionsKt.plus((Collection) arrayList2, (Iterable) avoidCoverPath);
        if (str.length() <= 0) {
            z17 = false;
        }
        if (z17) {
            ArrayList arrayList3 = new ArrayList();
            for (Object obj2 : plus2) {
                startsWith$default = StringsKt__StringsJVMKt.startsWith$default((String) obj2, str, false, 2, null);
                if (startsWith$default) {
                    arrayList3.add(obj2);
                }
            }
            collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(arrayList3, 10);
            plus2 = new ArrayList(collectionSizeOrDefault);
            Iterator it6 = arrayList3.iterator();
            while (it6.hasNext()) {
                String substring = ((String) it6.next()).substring(str.length());
                Intrinsics.checkNotNullExpressionValue(substring, "this as java.lang.String).substring(startIndex)");
                plus2.add(substring);
            }
        }
        Iterator it7 = plus2.iterator();
        while (it7.hasNext()) {
            f195961a.b(bVar, (String) it7.next());
        }
        return bVar;
    }
}

package com.tencent.mobileqq.search.util;

import androidx.annotation.UiThread;
import androidx.collection.SparseArrayCompat;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.panorama.util.PanoramaConfig;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.collections.CollectionsKt__MutableCollectionsKt;
import kotlin.collections.SetsKt__SetsJVMKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import mqq.app.MobileQQ;
import okhttp3.HttpUrl;
import okhttp3.internal.Util;
import org.jetbrains.annotations.NotNull;
import org.json.JSONArray;

/* compiled from: P */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u001d\u0010\u001eJ\u0018\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0007J\u001e\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0007J\u0010\u0010\t\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u0002H\u0007J\u0010\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J \u0010\u000e\u001a\u0012\u0012\u0004\u0012\u00020\u00020\fj\b\u0012\u0004\u0012\u00020\u0002`\r2\u0006\u0010\u0003\u001a\u00020\u0002H\u0003J\u0010\u0010\u000f\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u0002H\u0003J \u0010\u0010\u001a\u0012\u0012\u0004\u0012\u00020\u00020\fj\b\u0012\u0004\u0012\u00020\u0002`\r2\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\f\u0010\u0012\u001a\u00020\u0011*\u00020\u0002H\u0002J\u0016\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u0002H\u0007R\u0014\u0010\u0016\u001a\u00020\u00028\u0002X\u0082D\u00a2\u0006\u0006\n\u0004\b\u0014\u0010\u0015R*\u0010\u0019\u001a\u0018\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\u00020\fj\b\u0012\u0004\u0012\u00020\u0002`\r0\u00178\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\u0018R\u0016\u0010\u001a\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0013\u0010\u0015R\u0014\u0010\u001c\u001a\u00020\u00028BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0014\u0010\u001b\u00a8\u0006\u001f"}, d2 = {"Lcom/tencent/mobileqq/search/util/ab;", "", "", "key", "keyword", "", tl.h.F, "", "g", "f", "", "c", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "e", "i", "a", "Lorg/json/JSONArray;", "j", "d", "b", "Ljava/lang/String;", "TAG", "Landroidx/collection/SparseArrayCompat;", "Landroidx/collection/SparseArrayCompat;", "histories", "previousUin", "()Ljava/lang/String;", PanoramaConfig.KEY_CURRENT_UIN, "<init>", "()V", "qqsearch-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes18.dex */
public final class ab {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final ab f284985a = new ab();

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final String TAG = "SearchHistoryUtils";

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final SparseArrayCompat<ArrayList<String>> histories = new SparseArrayCompat<>();

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static String previousUin = "";

    ab() {
    }

    private final ArrayList<String> a(String key) {
        if (!Intrinsics.areEqual(b(), previousUin)) {
            previousUin = b();
            histories.clear();
            d(key);
        }
        ArrayList<String> arrayList = histories.get(key.hashCode());
        Intrinsics.checkNotNull(arrayList);
        return arrayList;
    }

    private final String b() {
        String account = MobileQQ.sMobileQQ.peekAppRuntime().getAccount();
        if (account == null) {
            return "";
        }
        return account;
    }

    private final int c(String key) {
        if (Intrinsics.areEqual(key, MmkvKeys.MMKV_KEY_FIND_USER_AND_GROUP_SEARCH_HISTORY_KEY)) {
            return 10;
        }
        return 15;
    }

    @UiThread
    private final ArrayList<String> e(String key) {
        boolean isBlank;
        String h16 = ah.f284994a.h(key, HttpUrl.PATH_SEGMENT_ENCODE_SET_URI);
        int c16 = c(key);
        JSONArray j3 = j(h16);
        HashSet hashSet = new HashSet();
        ArrayList<String> arrayList = new ArrayList<>(j3.length());
        int length = j3.length();
        for (int i3 = 0; i3 < length; i3++) {
            String keyword = j3.optString(i3, "");
            Intrinsics.checkNotNullExpressionValue(keyword, "keyword");
            isBlank = StringsKt__StringsJVMKt.isBlank(keyword);
            if ((!isBlank) && !hashSet.contains(keyword)) {
                arrayList.add(keyword);
                hashSet.add(keyword);
            }
            if (arrayList.size() >= c16) {
                break;
            }
        }
        QLog.i(TAG, 1, "loadHistoryListFromMmkv " + key + " size: " + arrayList.size());
        return arrayList;
    }

    @JvmStatic
    @UiThread
    public static final void f(@NotNull String key) {
        Intrinsics.checkNotNullParameter(key, "key");
        ab abVar = f284985a;
        abVar.a(key).clear();
        abVar.i(key);
    }

    @JvmStatic
    @UiThread
    @NotNull
    public static final List<String> g(@NotNull String key, @NotNull String keyword) {
        Set of5;
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(keyword, "keyword");
        ArrayList<String> a16 = f284985a.a(key);
        boolean z16 = false;
        if (!(a16 instanceof Collection) || !a16.isEmpty()) {
            Iterator<T> it = a16.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                if (Intrinsics.areEqual((String) it.next(), keyword)) {
                    z16 = true;
                    break;
                }
            }
        }
        if (z16) {
            of5 = SetsKt__SetsJVMKt.setOf(keyword);
            a16.removeAll(of5);
            f284985a.i(key);
        }
        return Util.toImmutableList(a16);
    }

    @JvmStatic
    @UiThread
    public static final void h(@NotNull String key, @NotNull String keyword) {
        boolean z16;
        Set of5;
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(keyword, "keyword");
        ArrayList<String> a16 = f284985a.a(key);
        if (!(a16 instanceof Collection) || !a16.isEmpty()) {
            Iterator<T> it = a16.iterator();
            while (it.hasNext()) {
                if (Intrinsics.areEqual((String) it.next(), keyword)) {
                    z16 = true;
                    break;
                }
            }
        }
        z16 = false;
        if (z16) {
            of5 = SetsKt__SetsJVMKt.setOf(keyword);
            a16.removeAll(of5);
            a16.add(0, keyword);
        } else {
            a16.add(0, keyword);
            if (a16.size() > f284985a.c(key)) {
                CollectionsKt__MutableCollectionsKt.removeLast(a16);
            }
        }
        f284985a.i(key);
    }

    @UiThread
    private final void i(String key) {
        ArrayList<String> a16 = a(key);
        QLog.i(TAG, 1, "saveHistoryListToMmkv " + key + " size: " + a16.size());
        JSONArray jSONArray = new JSONArray();
        Iterator<String> it = a16.iterator();
        while (it.hasNext()) {
            jSONArray.mo162put(it.next());
        }
        ah ahVar = ah.f284994a;
        String jSONArray2 = jSONArray.toString(0);
        Intrinsics.checkNotNullExpressionValue(jSONArray2, "jsonArray.toString(0)");
        ahVar.r(key, jSONArray2);
    }

    private final JSONArray j(String str) {
        Object m476constructorimpl;
        try {
            Result.Companion companion = Result.INSTANCE;
            m476constructorimpl = Result.m476constructorimpl(new JSONArray(str));
        } catch (Throwable th5) {
            Result.Companion companion2 = Result.INSTANCE;
            m476constructorimpl = Result.m476constructorimpl(ResultKt.createFailure(th5));
        }
        if (Result.m482isFailureimpl(m476constructorimpl)) {
            m476constructorimpl = null;
        }
        JSONArray jSONArray = (JSONArray) m476constructorimpl;
        if (jSONArray == null) {
            return new JSONArray();
        }
        return jSONArray;
    }

    @UiThread
    @NotNull
    public final List<String> d(@NotNull String key) {
        Intrinsics.checkNotNullParameter(key, "key");
        if (!Intrinsics.areEqual(b(), previousUin)) {
            previousUin = b();
            histories.clear();
        }
        int hashCode = key.hashCode();
        SparseArrayCompat<ArrayList<String>> sparseArrayCompat = histories;
        if (sparseArrayCompat.containsKey(hashCode)) {
            ArrayList<String> arrayList = sparseArrayCompat.get(hashCode);
            Intrinsics.checkNotNull(arrayList);
            return Util.toImmutableList(arrayList);
        }
        ArrayList<String> e16 = e(key);
        sparseArrayCompat.put(hashCode, e16);
        return Util.toImmutableList(e16);
    }
}

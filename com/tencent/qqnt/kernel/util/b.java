package com.tencent.qqnt.kernel.util;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.qqnt.kernel.nativeinterface.RecentContactInfo;
import com.tencent.qqnt.kernel.nativeinterface.RecentContactListChangedInfo;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.MapsKt__MapsJVMKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt___RangesKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0015\u0010\u0016JB\u0010\n\u001a\u0012\u0012\u0004\u0012\u00020\u00030\bj\b\u0012\u0004\u0012\u00020\u0003`\t2\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00022\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0002J\b\u0010\f\u001a\u0004\u0018\u00010\u000bJ\u0010\u0010\u000f\u001a\u00020\u000e2\b\u0010\r\u001a\u0004\u0018\u00010\u000bJ.\u0010\u0012\u001a\u0012\u0012\u0004\u0012\u00020\u00030\bj\b\u0012\u0004\u0012\u00020\u0003`\t2\u000e\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00022\u0006\u0010\u0011\u001a\u00020\u0010R\u0018\u0010\u0014\u001a\u0004\u0018\u00010\u000b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\u0013\u00a8\u0006\u0017"}, d2 = {"Lcom/tencent/qqnt/kernel/util/b;", "", "", "Lcom/tencent/qqnt/kernel/nativeinterface/RecentContactInfo;", "originList", "", "sortedContactList", "changedList", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "c", "", "a", "uid", "", "d", "Lcom/tencent/qqnt/kernel/nativeinterface/RecentContactListChangedInfo;", "changeInfo", "b", "Ljava/lang/String;", "sCurAIOUid", "<init>", "()V", "kernel_api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes24.dex */
public final class b {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final b f359257a;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private static String sCurAIOUid;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(40675);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 5)) {
            redirector.redirect((short) 5);
        } else {
            f359257a = new b();
        }
    }

    b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private final ArrayList<RecentContactInfo> c(List<RecentContactInfo> originList, List<Long> sortedContactList, List<RecentContactInfo> changedList) {
        int collectionSizeOrDefault;
        int mapCapacity;
        int coerceAtLeast;
        int collectionSizeOrDefault2;
        int mapCapacity2;
        int coerceAtLeast2;
        RecentContactInfo recentContactInfo;
        List<RecentContactInfo> list = originList;
        collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(list, 10);
        mapCapacity = MapsKt__MapsJVMKt.mapCapacity(collectionSizeOrDefault);
        coerceAtLeast = RangesKt___RangesKt.coerceAtLeast(mapCapacity, 16);
        LinkedHashMap linkedHashMap = new LinkedHashMap(coerceAtLeast);
        for (Object obj : list) {
            linkedHashMap.put(Long.valueOf(((RecentContactInfo) obj).contactId), obj);
        }
        List<RecentContactInfo> list2 = changedList;
        collectionSizeOrDefault2 = CollectionsKt__IterablesKt.collectionSizeOrDefault(list2, 10);
        mapCapacity2 = MapsKt__MapsJVMKt.mapCapacity(collectionSizeOrDefault2);
        coerceAtLeast2 = RangesKt___RangesKt.coerceAtLeast(mapCapacity2, 16);
        LinkedHashMap linkedHashMap2 = new LinkedHashMap(coerceAtLeast2);
        for (Object obj2 : list2) {
            linkedHashMap2.put(Long.valueOf(((RecentContactInfo) obj2).contactId), obj2);
        }
        ArrayList<RecentContactInfo> arrayList = new ArrayList<>();
        Iterator<T> it = sortedContactList.iterator();
        while (it.hasNext()) {
            long longValue = ((Number) it.next()).longValue();
            RecentContactInfo recentContactInfo2 = (RecentContactInfo) linkedHashMap2.get(Long.valueOf(longValue));
            if (recentContactInfo2 != null) {
                arrayList.add(recentContactInfo2);
            } else {
                recentContactInfo2 = null;
            }
            if (recentContactInfo2 == null && (recentContactInfo = (RecentContactInfo) linkedHashMap.get(Long.valueOf(longValue))) != null) {
                arrayList.add(recentContactInfo);
            }
        }
        return arrayList;
    }

    @Nullable
    public final String a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (String) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return sCurAIOUid;
    }

    @NotNull
    public final ArrayList<RecentContactInfo> b(@Nullable List<RecentContactInfo> originList, @NotNull RecentContactListChangedInfo changeInfo) {
        List<RecentContactInfo> emptyList;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (ArrayList) iPatchRedirector.redirect((short) 4, (Object) this, (Object) originList, (Object) changeInfo);
        }
        Intrinsics.checkNotNullParameter(changeInfo, "changeInfo");
        if (changeInfo.notificationType != 2) {
            emptyList = CollectionsKt__CollectionsKt.emptyList();
            ArrayList<Long> arrayList = changeInfo.sortedContactList;
            Intrinsics.checkNotNullExpressionValue(arrayList, "changeInfo.sortedContactList");
            ArrayList<RecentContactInfo> arrayList2 = changeInfo.changedList;
            Intrinsics.checkNotNullExpressionValue(arrayList2, "changeInfo.changedList");
            return c(emptyList, arrayList, arrayList2);
        }
        if (originList == null) {
            originList = CollectionsKt__CollectionsKt.emptyList();
        }
        ArrayList<Long> arrayList3 = changeInfo.sortedContactList;
        Intrinsics.checkNotNullExpressionValue(arrayList3, "changeInfo.sortedContactList");
        ArrayList<RecentContactInfo> arrayList4 = changeInfo.changedList;
        Intrinsics.checkNotNullExpressionValue(arrayList4, "changeInfo.changedList");
        return c(originList, arrayList3, arrayList4);
    }

    public final void d(@Nullable String uid) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) uid);
        } else {
            sCurAIOUid = uid;
        }
    }
}

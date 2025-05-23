package com.tencent.mobileqq.tianshu.util;

import android.text.TextUtils;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.tianshu.pb.BusinessInfoCheckUpdate;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.MapsKt__MapsJVMKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt___RangesKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\b\u0010\tJ,\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u00022\u000e\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00022\u000e\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0002\u00a8\u0006\n"}, d2 = {"Lcom/tencent/mobileqq/tianshu/util/a;", "", "", "Lcom/tencent/mobileqq/tianshu/pb/BusinessInfoCheckUpdate$AppInfo;", "newList", "oldList", "Lcom/tencent/mobileqq/tianshu/bean/a;", "a", "<init>", "()V", "tianshu-api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes18.dex */
public final class a {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final a f293182a;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(34498);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 3)) {
            redirector.redirect((short) 3);
        } else {
            f293182a = new a();
        }
    }

    a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @NotNull
    public final List<com.tencent.mobileqq.tianshu.bean.a> a(@Nullable List<BusinessInfoCheckUpdate.AppInfo> newList, @Nullable List<BusinessInfoCheckUpdate.AppInfo> oldList) {
        int collectionSizeOrDefault;
        int mapCapacity;
        int coerceAtLeast;
        int collectionSizeOrDefault2;
        int mapCapacity2;
        int coerceAtLeast2;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (List) iPatchRedirector.redirect((short) 2, (Object) this, (Object) newList, (Object) oldList);
        }
        ArrayList arrayList = new ArrayList();
        if (newList == null) {
            newList = new ArrayList<>();
        }
        if (oldList == null) {
            oldList = new ArrayList<>();
        }
        List<BusinessInfoCheckUpdate.AppInfo> list = newList;
        collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(list, 10);
        mapCapacity = MapsKt__MapsJVMKt.mapCapacity(collectionSizeOrDefault);
        coerceAtLeast = RangesKt___RangesKt.coerceAtLeast(mapCapacity, 16);
        LinkedHashMap linkedHashMap = new LinkedHashMap(coerceAtLeast);
        for (Object obj : list) {
            linkedHashMap.put(((BusinessInfoCheckUpdate.AppInfo) obj).path.get(), obj);
        }
        List<BusinessInfoCheckUpdate.AppInfo> list2 = oldList;
        collectionSizeOrDefault2 = CollectionsKt__IterablesKt.collectionSizeOrDefault(list2, 10);
        mapCapacity2 = MapsKt__MapsJVMKt.mapCapacity(collectionSizeOrDefault2);
        coerceAtLeast2 = RangesKt___RangesKt.coerceAtLeast(mapCapacity2, 16);
        LinkedHashMap linkedHashMap2 = new LinkedHashMap(coerceAtLeast2);
        for (Object obj2 : list2) {
            linkedHashMap2.put(((BusinessInfoCheckUpdate.AppInfo) obj2).path.get(), obj2);
        }
        for (BusinessInfoCheckUpdate.AppInfo appInfo : newList) {
            BusinessInfoCheckUpdate.AppInfo appInfo2 = (BusinessInfoCheckUpdate.AppInfo) linkedHashMap2.get(appInfo.path.get());
            if (appInfo2 != null) {
                if (appInfo.iNewFlag.get() != appInfo2.iNewFlag.get() || appInfo.mission_level.get() != appInfo2.mission_level.get() || appInfo.type.get() != appInfo2.type.get() || appInfo.version.get() != appInfo2.version.get() || !TextUtils.equals(appInfo.buffer.get(), appInfo2.buffer.get()) || !Arrays.equals(appInfo.busi_data.get().toByteArray(), appInfo2.busi_data.get().toByteArray()) || !Intrinsics.areEqual(appInfo.hash.get(), appInfo2.hash.get())) {
                    QLog.d("TianshuRedUtil", 1, "getChangedAppInfos appInfo ui change, path:" + appInfo.path);
                    int i3 = appInfo.appset.get();
                    String str = appInfo.path.get();
                    Intrinsics.checkNotNullExpressionValue(str, "appInfo.path.get()");
                    arrayList.add(new com.tencent.mobileqq.tianshu.bean.a(i3, str));
                }
            } else {
                QLog.d("TianshuRedUtil", 1, "getChangedAppInfos add appInfo, path:" + appInfo.path);
                int i16 = appInfo.appset.get();
                String str2 = appInfo.path.get();
                Intrinsics.checkNotNullExpressionValue(str2, "appInfo.path.get()");
                arrayList.add(new com.tencent.mobileqq.tianshu.bean.a(i16, str2));
            }
        }
        for (BusinessInfoCheckUpdate.AppInfo appInfo3 : oldList) {
            if (!linkedHashMap.containsKey(appInfo3.path.get())) {
                QLog.d("TianshuRedUtil", 1, "getChangedAppInfos remove appInfo, path:" + appInfo3.path);
                int i17 = appInfo3.appset.get();
                String str3 = appInfo3.path.get();
                Intrinsics.checkNotNullExpressionValue(str3, "appInfo.path.get()");
                arrayList.add(new com.tencent.mobileqq.tianshu.bean.a(i17, str3));
            }
        }
        return arrayList;
    }
}

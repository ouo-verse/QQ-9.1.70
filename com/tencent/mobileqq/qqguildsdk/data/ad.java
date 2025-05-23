package com.tencent.mobileqq.qqguildsdk.data;

import com.tencent.qqnt.kernelgpro.nativeinterface.GProPermissionInfo;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProRolePermissionDesc;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.TypeIntrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a\u000e\u0010\u0003\u001a\u00060\u0001j\u0002`\u0002*\u00020\u0000\u001a\u000e\u0010\u0004\u001a\u00020\u0000*\u00060\u0001j\u0002`\u0002\u001a\u001a\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u0005*\f\u0012\b\u0012\u00060\u0006j\u0002`\u00070\u0005*\n\u0010\u000b\"\u00020\n2\u00020\n*\n\u0010\f\"\u00020\u00012\u00020\u0001*\n\u0010\r\"\u00020\u00062\u00020\u0006\u00a8\u0006\u000e"}, d2 = {"Lcom/tencent/mobileqq/qqguildsdk/data/GProRolePermission;", "Lcom/tencent/qqnt/kernelgpro/nativeinterface/GProRolePermission;", "Lcom/tencent/mobileqq/qqguildsdk/data/CppGProRolePermission;", "b", "a", "", "Lcom/tencent/qqnt/kernelgpro/nativeinterface/GProRolePermissionDesc;", "Lcom/tencent/mobileqq/qqguildsdk/data/CppGProRolePermissionDesc;", "Lcom/tencent/mobileqq/qqguildsdk/data/bv;", "c", "Lcom/tencent/qqnt/kernelgpro/nativeinterface/GProPermissionInfo;", "CppGProPermissionInfo", "CppGProRolePermission", "CppGProRolePermissionDesc", "qqguild-sdk-impl_release"}, k = 2, mv = {1, 7, 1})
/* loaded from: classes17.dex */
public final class ad {
    @NotNull
    public static final GProRolePermission a(@NotNull com.tencent.qqnt.kernelgpro.nativeinterface.GProRolePermission gProRolePermission) {
        Intrinsics.checkNotNullParameter(gProRolePermission, "<this>");
        GProRolePermission gProRolePermission2 = new GProRolePermission();
        gProRolePermission2.e(gProRolePermission.hasRolePermission);
        List<bh> c16 = gProRolePermission2.c();
        Intrinsics.checkNotNull(c16, "null cannot be cast to non-null type kotlin.collections.MutableList<com.tencent.mobileqq.qqguildsdk.data.GProPermissionInfo>");
        List asMutableList = TypeIntrinsics.asMutableList(c16);
        ArrayList<GProPermissionInfo> permissionList = gProRolePermission.permissionList;
        Intrinsics.checkNotNullExpressionValue(permissionList, "permissionList");
        for (GProPermissionInfo gProPermissionInfo : permissionList) {
            int i3 = gProPermissionInfo.rootId;
            ArrayList<Integer> arrayList = gProPermissionInfo.childIds;
            Intrinsics.checkNotNullExpressionValue(arrayList, "it.childIds");
            asMutableList.add(new bh(i3, arrayList));
        }
        return gProRolePermission2;
    }

    @NotNull
    public static final com.tencent.qqnt.kernelgpro.nativeinterface.GProRolePermission b(@NotNull GProRolePermission gProRolePermission) {
        Intrinsics.checkNotNullParameter(gProRolePermission, "<this>");
        boolean hasRolePermission = gProRolePermission.getHasRolePermission();
        List<bh> c16 = gProRolePermission.c();
        ArrayList arrayList = new ArrayList();
        Iterator<T> it = c16.iterator();
        while (it.hasNext()) {
            arrayList.add(new GProPermissionInfo(((bh) it.next()).getId(), new ArrayList()));
        }
        return new com.tencent.qqnt.kernelgpro.nativeinterface.GProRolePermission(hasRolePermission, arrayList);
    }

    @NotNull
    public static final List<Desc> c(@NotNull List<GProRolePermissionDesc> list) {
        int collectionSizeOrDefault;
        Intrinsics.checkNotNullParameter(list, "<this>");
        List<GProRolePermissionDesc> list2 = list;
        collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(list2, 10);
        ArrayList arrayList = new ArrayList(collectionSizeOrDefault);
        for (GProRolePermissionDesc gProRolePermissionDesc : list2) {
            int i3 = gProRolePermissionDesc.rootId;
            String str = gProRolePermissionDesc.title;
            Intrinsics.checkNotNullExpressionValue(str, "it.title");
            String str2 = gProRolePermissionDesc.desc;
            Intrinsics.checkNotNullExpressionValue(str2, "it.desc");
            arrayList.add(new Desc(i3, str, str2, gProRolePermissionDesc.permType));
        }
        return arrayList;
    }
}

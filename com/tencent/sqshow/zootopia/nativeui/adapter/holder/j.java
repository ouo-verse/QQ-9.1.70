package com.tencent.sqshow.zootopia.nativeui.adapter.holder;

import com.tencent.sqshow.utils.featureswitch.ZPlanQQMC;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import uv4.bk;

/* compiled from: P */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0013\u0010\u0014J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0005\u001a\u00020\u0004H\u0002J\u0006\u0010\u0007\u001a\u00020\u0006J\n\u0010\b\u001a\u00020\u0002*\u00020\u0004J.\u0010\u0010\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\u00062\u0016\u0010\r\u001a\u0012\u0012\u0004\u0012\u00020\u000b0\nj\b\u0012\u0004\u0012\u00020\u000b`\f2\u0006\u0010\u000f\u001a\u00020\u000eJ&\u0010\u0012\u001a\u00020\u00112\u0006\u0010\t\u001a\u00020\u00062\u0016\u0010\r\u001a\u0012\u0012\u0004\u0012\u00020\u000b0\nj\b\u0012\u0004\u0012\u00020\u000b`\f\u00a8\u0006\u0015"}, d2 = {"Lcom/tencent/sqshow/zootopia/nativeui/adapter/holder/j;", "", "", "c", "Luv4/bk;", "a", "", "b", "d", "currentTabId", "Ljava/util/ArrayList;", "Lcom/tencent/sqshow/zootopia/nativeui/data/repo/g;", "Lkotlin/collections/ArrayList;", "dataList", "", "position", "e", "", "f", "<init>", "()V", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public final class j {

    /* renamed from: a, reason: collision with root package name */
    public static final j f370868a = new j();

    j() {
    }

    private final bk a() {
        return new bk();
    }

    private final boolean c() {
        return ZPlanQQMC.INSTANCE.enableZPlanStoreShowDiyButton();
    }

    public final String b() {
        return "my:2:5";
    }

    public final boolean d(bk bkVar) {
        Intrinsics.checkNotNullParameter(bkVar, "<this>");
        return bkVar.f440366b == null;
    }

    public final boolean e(String currentTabId, ArrayList<com.tencent.sqshow.zootopia.nativeui.data.repo.g> dataList, int position) {
        Intrinsics.checkNotNullParameter(currentTabId, "currentTabId");
        Intrinsics.checkNotNullParameter(dataList, "dataList");
        if (!Intrinsics.areEqual(currentTabId, b()) || position != 0 || position < 0 || position >= dataList.size()) {
            return false;
        }
        com.tencent.sqshow.zootopia.nativeui.data.repo.g gVar = dataList.get(position);
        Intrinsics.checkNotNullExpressionValue(gVar, "dataList[position]");
        bk storeTypeItem = gVar.getStoreTypeItem();
        if (storeTypeItem != null) {
            return d(storeTypeItem);
        }
        return false;
    }

    public final void f(String currentTabId, ArrayList<com.tencent.sqshow.zootopia.nativeui.data.repo.g> dataList) {
        Object orNull;
        Intrinsics.checkNotNullParameter(currentTabId, "currentTabId");
        Intrinsics.checkNotNullParameter(dataList, "dataList");
        if (!ZPlanQQMC.INSTANCE.disableZPlanAIGCEntrance() && Intrinsics.areEqual(currentTabId, b()) && c()) {
            orNull = CollectionsKt___CollectionsKt.getOrNull(dataList, 0);
            com.tencent.sqshow.zootopia.nativeui.data.repo.g gVar = (com.tencent.sqshow.zootopia.nativeui.data.repo.g) orNull;
            if (gVar == null) {
                dataList.add(0, new com.tencent.sqshow.zootopia.nativeui.data.repo.g(1, a(), null, 4, null));
                return;
            }
            bk storeTypeItem = gVar.getStoreTypeItem();
            if ((storeTypeItem == null || f370868a.d(storeTypeItem)) ? false : true) {
                dataList.add(0, new com.tencent.sqshow.zootopia.nativeui.data.repo.g(1, f370868a.a(), null, 4, null));
            }
        }
    }
}

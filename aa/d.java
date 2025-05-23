package aa;

import com.qzone.reborn.albumx.common.bean.CommonGridItemData;
import com.qzone.reborn.albumx.common.convert.bean.CommonStMedia;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0010\u0010\u0011J\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00052\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0002J\u001a\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\u00022\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u0002J\u001a\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\t0\u00022\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u0002J\u0016\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\f\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\t\u00a8\u0006\u0012"}, d2 = {"Laa/d;", "", "", "Lcom/qzone/reborn/albumx/common/convert/bean/CommonStMedia;", "list", "", "a", "Lcom/qzone/reborn/albumx/common/bean/a;", "allBatch", "Lcom/qzone/reborn/albumx/common/bean/CommonGridItemData;", "d", "c", "oldItem", "newItem", "", "b", "<init>", "()V", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes39.dex */
public final class d {

    /* renamed from: a, reason: collision with root package name */
    public static final d f25752a = new d();

    d() {
    }

    private final String a(List<CommonStMedia> list) {
        if (list.size() == 0) {
            return "";
        }
        return e.f25753a.b(list.get(0));
    }

    public final boolean b(CommonGridItemData oldItem, CommonGridItemData newItem) {
        Intrinsics.checkNotNullParameter(oldItem, "oldItem");
        Intrinsics.checkNotNullParameter(newItem, "newItem");
        if (oldItem.getItemType() != newItem.getItemType()) {
            return false;
        }
        if (oldItem.getItemType() == CommonGridItemData.ItemType.HEAD_SECTION_ITEM) {
            return oldItem.getBatchBean().getBatchInfo().getLinkId() == newItem.getBatchBean().getBatchInfo().getLinkId() && Intrinsics.areEqual(a(oldItem.getBatchBean().getBatchInfo().j()), a(newItem.getBatchBean().getBatchInfo().j()));
        }
        if (oldItem.getItemType() == CommonGridItemData.ItemType.PIC_SECTION_ITEM) {
            e eVar = e.f25753a;
            return Intrinsics.areEqual(eVar.b(oldItem.f()), eVar.b(newItem.f()));
        }
        oldItem.getItemType();
        CommonGridItemData.ItemType itemType = CommonGridItemData.ItemType.HEAD_SECTION_ITEM;
        return false;
    }

    public final List<CommonGridItemData> c(List<com.qzone.reborn.albumx.common.bean.a> allBatch) {
        Intrinsics.checkNotNullParameter(allBatch, "allBatch");
        ArrayList arrayList = new ArrayList();
        int i3 = 0;
        for (Object obj : allBatch) {
            int i16 = i3 + 1;
            if (i3 < 0) {
                CollectionsKt__CollectionsKt.throwIndexOverflow();
            }
            com.qzone.reborn.albumx.common.bean.a aVar = (com.qzone.reborn.albumx.common.bean.a) obj;
            if (aVar.getBatchInfo().getBanner().getCom.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts.KEY_MATERIAL java.lang.String() > 0) {
                CommonGridItemData commonGridItemData = new CommonGridItemData(aVar, CommonGridItemData.ItemType.BANNER_SECTION_ITEM, i3, 0);
                commonGridItemData.g(aVar.getBatchInfo().getBanner());
                arrayList.add(commonGridItemData);
            }
            arrayList.add(new CommonGridItemData(aVar, CommonGridItemData.ItemType.HEAD_SECTION_ITEM, i3, 0));
            int i17 = 0;
            for (Object obj2 : aVar.getBatchInfo().j()) {
                int i18 = i17 + 1;
                if (i17 < 0) {
                    CollectionsKt__CollectionsKt.throwIndexOverflow();
                }
                CommonGridItemData commonGridItemData2 = new CommonGridItemData(aVar, CommonGridItemData.ItemType.PIC_SECTION_ITEM, i3, i17);
                commonGridItemData2.h((CommonStMedia) obj2);
                arrayList.add(commonGridItemData2);
                i17 = i18;
            }
            i3 = i16;
        }
        return arrayList;
    }

    public final List<CommonGridItemData> d(List<com.qzone.reborn.albumx.common.bean.a> allBatch) {
        Intrinsics.checkNotNullParameter(allBatch, "allBatch");
        ArrayList arrayList = new ArrayList();
        int i3 = 0;
        for (Object obj : allBatch) {
            int i16 = i3 + 1;
            if (i3 < 0) {
                CollectionsKt__CollectionsKt.throwIndexOverflow();
            }
            com.qzone.reborn.albumx.common.bean.a aVar = (com.qzone.reborn.albumx.common.bean.a) obj;
            arrayList.add(new CommonGridItemData(aVar, CommonGridItemData.ItemType.HEAD_SECTION_ITEM, i3, 0));
            int i17 = 0;
            for (Object obj2 : aVar.getBatchInfo().j()) {
                int i18 = i17 + 1;
                if (i17 < 0) {
                    CollectionsKt__CollectionsKt.throwIndexOverflow();
                }
                CommonGridItemData commonGridItemData = new CommonGridItemData(aVar, CommonGridItemData.ItemType.PIC_SECTION_ITEM, i3, i17);
                commonGridItemData.h((CommonStMedia) obj2);
                arrayList.add(commonGridItemData);
                i17 = i18;
            }
            i3 = i16;
        }
        return arrayList;
    }
}

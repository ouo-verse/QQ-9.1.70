package com.dataline.nt;

import com.tencent.biz.pubaccount.util.api.impl.PublicAccountMessageUtilImpl;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.annotation.KeepClassConstructor;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.chats.api.IChatPartConvertProcessor;
import com.tencent.qqnt.chats.core.adapter.itemdata.g;
import cooperation.qzone.util.QZoneImageUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@KeepClassConstructor
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u0000 \t2\u00020\u0001:\u0001\u0005B\u0007\u00a2\u0006\u0004\b\u0011\u0010\u0012J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0018\u0010\b\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\u0010\u0010\t\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0018\u0010\f\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0006H\u0016R\u001a\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u000e0\r8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u000f\u00a8\u0006\u0013"}, d2 = {"Lcom/dataline/nt/DataLineConvertProcessor;", "Lcom/tencent/qqnt/chats/data/converter/e;", "Lcom/tencent/qqnt/chats/core/adapter/itemdata/g;", PublicAccountMessageUtilImpl.ITEM_STRUCT_FIRST_LEVEL_NAME, "", "a", "Lcom/tencent/qqnt/chats/data/converter/c;", "params", "c", "b", "", QZoneImageUtils.KEY_MATCH, "update", "", "Lcom/tencent/qqnt/chats/data/converter/g;", "Ljava/util/List;", "mProcessorList", "<init>", "()V", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes2.dex */
public final class DataLineConvertProcessor extends com.tencent.qqnt.chats.data.converter.e {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final List<com.tencent.qqnt.chats.data.converter.g> mProcessorList;

    public DataLineConvertProcessor() {
        List<com.tencent.qqnt.chats.data.converter.g> listOf;
        listOf = CollectionsKt__CollectionsKt.listOf((Object[]) new com.tencent.qqnt.chats.data.converter.g[]{(com.tencent.qqnt.chats.data.converter.g) ((IChatPartConvertProcessor) QRoute.api(IChatPartConvertProcessor.class)).createSummaryConvertProcessor(), (com.tencent.qqnt.chats.data.converter.g) ((IChatPartConvertProcessor) QRoute.api(IChatPartConvertProcessor.class)).createTimeConvertProcessor(), (com.tencent.qqnt.chats.data.converter.g) ((IChatPartConvertProcessor) QRoute.api(IChatPartConvertProcessor.class)).createUnreadConvertProcessor()});
        this.mProcessorList = listOf;
    }

    private final void a(com.tencent.qqnt.chats.core.adapter.itemdata.g item) {
        boolean z16;
        item.g().n(2);
        try {
            DataLineRecentContactUtil dataLineRecentContactUtil = DataLineRecentContactUtil.f32313a;
            String str = item.s().peerUid;
            Intrinsics.checkNotNullExpressionValue(str, "item.originData.peerUid");
            if (dataLineRecentContactUtil.h(str).length() > 0) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (z16) {
                QLog.i("DataLineConvertProcessor", 1, "processAvatar for old contact, uid=" + item.s().peerUid + ", uin=" + item.s().peerUin);
                g.a g16 = item.g();
                String str2 = item.s().peerUid;
                Intrinsics.checkNotNullExpressionValue(str2, "item.originData.peerUid");
                g16.l(Integer.valueOf(dataLineRecentContactUtil.m(dataLineRecentContactUtil.h(str2))));
            } else {
                QLog.i("DataLineConvertProcessor", 1, "processAvatar for new contact, uid=" + item.s().peerUid + ", uin=" + item.s().peerUin);
                g.a g17 = item.g();
                String str3 = item.s().peerUid;
                Intrinsics.checkNotNullExpressionValue(str3, "item.originData.peerUid");
                g17.l(Integer.valueOf(dataLineRecentContactUtil.m(str3)));
            }
        } catch (NumberFormatException e16) {
            QLog.e("DataLineConvertProcessor", 1, "processAvatar error:" + e16);
        }
    }

    private final void b(com.tencent.qqnt.chats.core.adapter.itemdata.g item) {
        ArrayList arrayList = new ArrayList();
        if (item.H()) {
            arrayList.add(com.tencent.qqnt.chats.core.adapter.menu.creator.c.INSTANCE.d());
        } else {
            arrayList.add(com.tencent.qqnt.chats.core.adapter.menu.creator.c.INSTANCE.q());
        }
        arrayList.add(com.tencent.qqnt.chats.core.adapter.menu.creator.c.INSTANCE.g());
        item.O(arrayList);
    }

    private final void c(com.tencent.qqnt.chats.core.adapter.itemdata.g item, com.tencent.qqnt.chats.data.converter.c params) {
        boolean z16;
        DataLineRecentContactUtil dataLineRecentContactUtil = DataLineRecentContactUtil.f32313a;
        String str = item.s().peerUid;
        Intrinsics.checkNotNullExpressionValue(str, "item.originData.peerUid");
        if (dataLineRecentContactUtil.h(str).length() > 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            QLog.i("DataLineConvertProcessor", 1, "processTitle for old contact, uid=" + item.s().peerUid + ", uin=" + item.s().peerUin);
            g.f w3 = item.w();
            String str2 = item.s().peerUid;
            Intrinsics.checkNotNullExpressionValue(str2, "item.originData.peerUid");
            w3.i(dataLineRecentContactUtil.o(dataLineRecentContactUtil.h(str2)));
            return;
        }
        QLog.i("DataLineConvertProcessor", 1, "processTitle for new contact, uid=" + item.s().peerUid + ", uin=" + item.s().peerUin);
        g.f w16 = item.w();
        String str3 = item.s().peerUid;
        Intrinsics.checkNotNullExpressionValue(str3, "item.originData.peerUid");
        w16.i(dataLineRecentContactUtil.o(str3));
    }

    @Override // com.tencent.qqnt.chats.data.converter.e
    public boolean match(@NotNull com.tencent.qqnt.chats.core.adapter.itemdata.g item) {
        Intrinsics.checkNotNullParameter(item, "item");
        if (item.n() == 8) {
            return true;
        }
        return false;
    }

    @Override // com.tencent.qqnt.chats.data.converter.e
    public void update(@NotNull com.tencent.qqnt.chats.core.adapter.itemdata.g item, @NotNull com.tencent.qqnt.chats.data.converter.c params) {
        int collectionSizeOrDefault;
        Intrinsics.checkNotNullParameter(item, "item");
        Intrinsics.checkNotNullParameter(params, "params");
        List<com.tencent.qqnt.chats.data.converter.g> list = this.mProcessorList;
        collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(list, 10);
        ArrayList arrayList = new ArrayList(collectionSizeOrDefault);
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            ((com.tencent.qqnt.chats.data.converter.g) it.next()).update(item, params);
            arrayList.add(Unit.INSTANCE);
        }
        a(item);
        c(item, params);
        b(item);
    }
}

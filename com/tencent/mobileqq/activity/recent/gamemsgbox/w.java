package com.tencent.mobileqq.activity.recent.gamemsgbox;

import com.tencent.biz.pubaccount.util.api.impl.PublicAccountMessageUtilImpl;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.QRoute;
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

/* compiled from: P */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0010\u0010\u0011J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0018\u0010\b\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0010\u0010\n\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0018\u0010\u000b\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016R\u001a\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\r0\f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\u000e\u00a8\u0006\u0012"}, d2 = {"Lcom/tencent/mobileqq/activity/recent/gamemsgbox/w;", "Lcom/tencent/qqnt/chats/data/converter/e;", "Lcom/tencent/qqnt/chats/core/adapter/itemdata/g;", PublicAccountMessageUtilImpl.ITEM_STRUCT_FIRST_LEVEL_NAME, "Lcom/tencent/qqnt/chats/data/converter/c;", "params", "", "a", "b", "", QZoneImageUtils.KEY_MATCH, "update", "", "Lcom/tencent/qqnt/chats/data/converter/g;", "Ljava/util/List;", "mProcessorList", "<init>", "()V", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes10.dex */
public final class w extends com.tencent.qqnt.chats.data.converter.e {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final List<com.tencent.qqnt.chats.data.converter.g> mProcessorList;

    public w() {
        List<com.tencent.qqnt.chats.data.converter.g> listOf;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
            listOf = CollectionsKt__CollectionsKt.listOf((Object[]) new com.tencent.qqnt.chats.data.converter.g[]{(com.tencent.qqnt.chats.data.converter.g) ((IChatPartConvertProcessor) QRoute.api(IChatPartConvertProcessor.class)).createTitleConvertProcessor(), (com.tencent.qqnt.chats.data.converter.g) ((IChatPartConvertProcessor) QRoute.api(IChatPartConvertProcessor.class)).createSummaryConvertProcessor(), (com.tencent.qqnt.chats.data.converter.g) ((IChatPartConvertProcessor) QRoute.api(IChatPartConvertProcessor.class)).createTimeConvertProcessor(), (com.tencent.qqnt.chats.data.converter.g) ((IChatPartConvertProcessor) QRoute.api(IChatPartConvertProcessor.class)).createUnreadConvertProcessor()});
            this.mProcessorList = listOf;
        } else {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private final void a(com.tencent.qqnt.chats.core.adapter.itemdata.g item, com.tencent.qqnt.chats.data.converter.c params) {
        String qqStr = HardCodeUtil.qqStr(R.string.f199514pm);
        Intrinsics.checkNotNullExpressionValue(qqStr, "qqStr(R.string.qq_gamemsgbox_title)");
        item.S(new g.f(qqStr));
        item.K(new g.a(2, "", null, null, 12, null));
        item.g().l(Integer.valueOf(R.drawable.neb));
    }

    private final void b(com.tencent.qqnt.chats.core.adapter.itemdata.g item, com.tencent.qqnt.chats.data.converter.c params) {
        ArrayList arrayList = new ArrayList();
        if (item.H()) {
            arrayList.add(com.tencent.qqnt.chats.core.adapter.menu.creator.c.INSTANCE.d());
        } else {
            arrayList.add(com.tencent.qqnt.chats.core.adapter.menu.creator.c.INSTANCE.q());
        }
        arrayList.add(com.tencent.qqnt.chats.core.adapter.menu.creator.c.INSTANCE.g());
        item.O(arrayList);
    }

    @Override // com.tencent.qqnt.chats.data.converter.e
    public boolean match(@NotNull com.tencent.qqnt.chats.core.adapter.itemdata.g item) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this, (Object) item)).booleanValue();
        }
        Intrinsics.checkNotNullParameter(item, "item");
        if (item.n() == 116) {
            return true;
        }
        return false;
    }

    @Override // com.tencent.qqnt.chats.data.converter.e
    public void update(@NotNull com.tencent.qqnt.chats.core.adapter.itemdata.g item, @NotNull com.tencent.qqnt.chats.data.converter.c params) {
        int collectionSizeOrDefault;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) item, (Object) params);
            return;
        }
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
        b(item, params);
        a(item, params);
    }
}

package com.tencent.qqnt.chats.api.impl;

import com.tencent.biz.pubaccount.util.api.impl.PublicAccountMessageUtilImpl;
import com.tencent.mobileqq.matchfriend.reborn.liteinteraction.QQStrangerLIAHelper;
import com.tencent.qqnt.chats.api.IQQStrangerLIAAdapterApi;
import com.tencent.qqnt.chats.core.adapter.itemdata.g;
import com.tencent.qqnt.kernelpublic.nativeinterface.Contact;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\n\u0010\u000bJ\u0018\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0002J\u0010\u0010\b\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0002H\u0002J\u0018\u0010\t\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0016\u00a8\u0006\f"}, d2 = {"Lcom/tencent/qqnt/chats/api/impl/QQStrangerLIAAdapterApiImpl;", "Lcom/tencent/qqnt/chats/api/IQQStrangerLIAAdapterApi;", "Lcom/tencent/qqnt/chats/core/adapter/itemdata/g;", "newItem", "oldItem", "", "hasUnreadChanged", PublicAccountMessageUtilImpl.ITEM_STRUCT_FIRST_LEVEL_NAME, "hasLIA", "needAddLIAPayload", "<init>", "()V", "matchfriend_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public final class QQStrangerLIAAdapterApiImpl implements IQQStrangerLIAAdapterApi {
    private final boolean hasLIA(g item) {
        return QQStrangerLIAHelper.f245114a.u(new Contact(item.n(), item.k(), ""), 1) != null;
    }

    private final boolean hasUnreadChanged(g newItem, g oldItem) {
        return newItem.x().b() == 0 && oldItem.x().b() != newItem.x().b();
    }

    @Override // com.tencent.qqnt.chats.api.IQQStrangerLIAAdapterApi
    public boolean needAddLIAPayload(g newItem, g oldItem) {
        Intrinsics.checkNotNullParameter(newItem, "newItem");
        Intrinsics.checkNotNullParameter(oldItem, "oldItem");
        return hasUnreadChanged(newItem, oldItem) && hasLIA(newItem);
    }
}

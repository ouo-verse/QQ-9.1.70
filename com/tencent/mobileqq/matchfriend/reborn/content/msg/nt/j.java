package com.tencent.mobileqq.matchfriend.reborn.content.msg.nt;

import android.view.View;
import com.tencent.biz.pubaccount.util.api.impl.PublicAccountMessageUtilImpl;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\b\u0010\tJ\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016\u00a8\u0006\n"}, d2 = {"Lcom/tencent/mobileqq/matchfriend/reborn/content/msg/nt/j;", "Lcom/tencent/qqnt/chats/inject/summary/a;", "Lcom/tencent/qqnt/chats/core/adapter/itemdata/g;", PublicAccountMessageUtilImpl.ITEM_STRUCT_FIRST_LEVEL_NAME, "Landroid/view/View;", "view", "", "a", "<init>", "()V", "matchfriend_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes33.dex */
public final class j extends com.tencent.qqnt.chats.inject.summary.a {
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.tencent.qqnt.chats.inject.summary.a
    public void a(com.tencent.qqnt.chats.core.adapter.itemdata.g item, View view) {
        Intrinsics.checkNotNullParameter(item, "item");
        Intrinsics.checkNotNullParameter(view, "view");
        if (item.n() != 104) {
            return;
        }
        com.tencent.qqnt.chats.view.a aVar = view instanceof com.tencent.qqnt.chats.view.a ? (com.tencent.qqnt.chats.view.a) view : null;
        if (aVar != null) {
            aVar.setSummaryTextColor(com.tencent.mobileqq.matchfriend.reborn.utils.o.f245489a.i());
        }
    }
}

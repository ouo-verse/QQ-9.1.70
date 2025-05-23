package com.tencent.state.square.chatland.data;

import com.tencent.state.template.data.Table;
import com.tencent.state.template.item.TemplateTableItem;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006R\u0014\u0010\u0004\u001a\u00020\u0005X\u0096\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b\u00a8\u0006\t"}, d2 = {"Lcom/tencent/state/square/chatland/data/ChatLandTableItem;", "Lcom/tencent/state/template/item/TemplateTableItem;", "table", "Lcom/tencent/state/template/data/Table;", "appId", "", "(Lcom/tencent/state/template/data/Table;I)V", "getAppId", "()I", "state_square_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes38.dex */
public final class ChatLandTableItem extends TemplateTableItem {
    private final int appId;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ChatLandTableItem(Table table, int i3) {
        super(table, null, 9);
        Intrinsics.checkNotNullParameter(table, "table");
        this.appId = i3;
    }

    @Override // com.tencent.state.map.MapItem
    public int getAppId() {
        return this.appId;
    }
}

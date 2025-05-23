package hw3;

import com.tencent.biz.pubaccount.util.api.impl.PublicAccountMessageUtilImpl;
import com.tencent.qqnt.chats.core.adapter.itemdata.g;
import com.tencent.qqnt.chats.data.converter.f;
import com.tencent.qqnt.chats.data.converter.g;
import com.tencent.qqnt.chats.data.converter.k;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringNumberConversionsKt;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\f\u0010\rJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0018\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0016\u00a8\u0006\u000e"}, d2 = {"Lhw3/d;", "Lcom/tencent/qqnt/chats/data/converter/g;", "Lcom/tencent/qqnt/chats/data/converter/f;", "payload", "", "matchPayload", "Lcom/tencent/qqnt/chats/core/adapter/itemdata/g;", PublicAccountMessageUtilImpl.ITEM_STRUCT_FIRST_LEVEL_NAME, "Lcom/tencent/qqnt/chats/data/converter/c;", "params", "", "update", "<init>", "()V", "chats_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes24.dex */
public final class d extends g {
    @Override // com.tencent.qqnt.chats.data.converter.g
    public boolean matchPayload(@NotNull f payload) {
        Intrinsics.checkNotNullParameter(payload, "payload");
        return payload instanceof k;
    }

    @Override // com.tencent.qqnt.chats.data.converter.g
    public void update(@NotNull com.tencent.qqnt.chats.core.adapter.itemdata.g item, @NotNull com.tencent.qqnt.chats.data.converter.c params) {
        boolean z16;
        Integer intOrNull;
        String str;
        Intrinsics.checkNotNullParameter(item, "item");
        Intrinsics.checkNotNullParameter(params, "params");
        String g16 = ex3.a.g(item.s());
        g.f w3 = item.w();
        if (g16.length() == 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            String str2 = item.s().peerUid;
            Intrinsics.checkNotNullExpressionValue(str2, "item.originData.peerUid");
            intOrNull = StringsKt__StringNumberConversionsKt.toIntOrNull(str2);
            if (intOrNull != null && intOrNull.intValue() == 101) {
                str = "\u52a8\u8d26\u6d88\u606f";
            } else if (intOrNull != null && intOrNull.intValue() == 102) {
                str = "\u9891\u9053\u79c1\u4fe1";
            } else if (intOrNull != null && intOrNull.intValue() == 103) {
                str = "\u7cfb\u7edf\u6d88\u606f";
            } else {
                str = "\u4e92\u52a8\u6d88\u606f";
            }
            g16 = str;
        }
        w3.i(g16);
    }
}

package hw3;

import com.tencent.biz.pubaccount.util.api.impl.PublicAccountMessageUtilImpl;
import com.tencent.mobileqq.R;
import com.tencent.qqnt.chats.core.adapter.itemdata.g;
import com.tencent.qqnt.chats.data.converter.f;
import com.tencent.qqnt.chats.data.converter.g;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringNumberConversionsKt;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\f\u0010\rJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0018\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0016\u00a8\u0006\u000e"}, d2 = {"Lhw3/a;", "Lcom/tencent/qqnt/chats/data/converter/g;", "Lcom/tencent/qqnt/chats/data/converter/f;", "payload", "", "matchPayload", "Lcom/tencent/qqnt/chats/core/adapter/itemdata/g;", PublicAccountMessageUtilImpl.ITEM_STRUCT_FIRST_LEVEL_NAME, "Lcom/tencent/qqnt/chats/data/converter/c;", "params", "", "update", "<init>", "()V", "chats_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes24.dex */
public final class a extends g {
    @Override // com.tencent.qqnt.chats.data.converter.g
    public boolean matchPayload(@NotNull f payload) {
        Intrinsics.checkNotNullParameter(payload, "payload");
        return payload instanceof com.tencent.qqnt.chats.data.converter.a;
    }

    @Override // com.tencent.qqnt.chats.data.converter.g
    public void update(@NotNull com.tencent.qqnt.chats.core.adapter.itemdata.g item, @NotNull com.tencent.qqnt.chats.data.converter.c params) {
        Integer intOrNull;
        Integer valueOf;
        Intrinsics.checkNotNullParameter(item, "item");
        Intrinsics.checkNotNullParameter(params, "params");
        String str = item.s().peerUid;
        Intrinsics.checkNotNullExpressionValue(str, "item.originData.peerUid");
        intOrNull = StringsKt__StringNumberConversionsKt.toIntOrNull(str);
        g.a g16 = item.g();
        g16.n(2);
        if (intOrNull != null && intOrNull.intValue() == 101) {
            valueOf = Integer.valueOf(R.drawable.guild_payment_icon);
        } else if (intOrNull != null && intOrNull.intValue() == 102) {
            valueOf = Integer.valueOf(R.drawable.guild_private_message_icon);
        } else if (intOrNull != null && intOrNull.intValue() == 103) {
            valueOf = Integer.valueOf(R.drawable.guild_remind_icon);
        } else {
            valueOf = Integer.valueOf(R.drawable.guild_message_icon);
        }
        g16.l(valueOf);
    }
}

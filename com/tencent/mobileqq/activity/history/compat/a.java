package com.tencent.mobileqq.activity.history.compat;

import android.content.Context;
import com.tencent.mobileqq.activity.history.ChatHistoryC2CSettingFragment;
import com.tencent.qqnt.chathistory.bridge.IHistoryBridgeInterface;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\b\u0000\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\r\u0010\u000eJ-\u0010\u0007\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0012\u0010\u0006\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00050\u0004\"\u00020\u0005H\u0016\u00a2\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\f\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\tH\u0016\u00a8\u0006\u000f"}, d2 = {"Lcom/tencent/mobileqq/activity/history/compat/a;", "Lcom/tencent/qqnt/chathistory/bridge/IHistoryBridgeInterface;", "", "action", "", "", "args", "invoke", "(I[Ljava/lang/Object;)Ljava/lang/Object;", "Lcom/tencent/qqnt/chathistory/bridge/IHistoryBridgeInterface$b;", "listener", "", "q8", "<init>", "()V", "base_proj_nt_ext_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes33.dex */
public final class a implements IHistoryBridgeInterface {
    @Override // com.tencent.qqnt.chathistory.bridge.IHistoryBridgeInterface
    public Object invoke(int action, Object... args) {
        Intrinsics.checkNotNullParameter(args, "args");
        if (action != 8) {
            return null;
        }
        Object obj = args[0];
        Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type android.content.Context");
        Object obj2 = args[1];
        Intrinsics.checkNotNull(obj2, "null cannot be cast to non-null type kotlin.String");
        ChatHistoryC2CSettingFragment.Ah((Context) obj, (String) obj2);
        return null;
    }

    @Override // com.tencent.qqnt.chathistory.bridge.IHistoryBridgeInterface
    public void q8(IHistoryBridgeInterface.b listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
    }
}

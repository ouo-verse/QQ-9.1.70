package com.tencent.state.common.push;

import kotlin.Metadata;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\b&\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002R\u0012\u0010\u0003\u001a\u00020\u0004X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006R\u0012\u0010\u0007\u001a\u00020\bX\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\t\u0010\n\u00a8\u0006\u000b"}, d2 = {"Lcom/tencent/state/common/push/PushMessage;", "", "()V", "info", "Lcom/tencent/state/common/push/PushBasic;", "getInfo", "()Lcom/tencent/state/common/push/PushBasic;", "type", "", "getType", "()I", "state_square_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes31.dex */
public abstract class PushMessage {
    public abstract PushBasic getInfo();

    public abstract int getType();
}

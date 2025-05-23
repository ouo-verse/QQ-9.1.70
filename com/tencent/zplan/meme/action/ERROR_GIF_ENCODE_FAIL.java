package com.tencent.zplan.meme.action;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0016J\b\u0010\u0005\u001a\u00020\u0004H\u0016\u00a8\u0006\u0006"}, d2 = {"Lcom/tencent/zplan/meme/action/ERROR_GIF_ENCODE_FAIL;", "Lcom/tencent/zplan/meme/action/ExtendActionStatus;", "()V", "toInt", "", "toReportErrorCode", "record_debug"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes27.dex */
public final class ERROR_GIF_ENCODE_FAIL extends ExtendActionStatus {

    @NotNull
    public static final ERROR_GIF_ENCODE_FAIL INSTANCE = new ERROR_GIF_ENCODE_FAIL();

    ERROR_GIF_ENCODE_FAIL() {
    }

    @Override // com.tencent.zplan.meme.action.ActionStatus
    public int toInt() {
        return 14;
    }

    @Override // com.tencent.zplan.meme.action.ActionStatus
    public int toReportErrorCode() {
        return -13417;
    }
}

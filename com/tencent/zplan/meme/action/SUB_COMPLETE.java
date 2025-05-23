package com.tencent.zplan.meme.action;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0016J\b\u0010\u0005\u001a\u00020\u0006H\u0016\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/zplan/meme/action/SUB_COMPLETE;", "Lcom/tencent/zplan/meme/action/ActionStatus;", "()V", "isEndState", "", "toInt", "", "record_debug"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes27.dex */
public final class SUB_COMPLETE extends ActionStatus {

    @NotNull
    public static final SUB_COMPLETE INSTANCE = new SUB_COMPLETE();

    SUB_COMPLETE() {
        super(null);
    }

    @Override // com.tencent.zplan.meme.action.ActionStatus
    public boolean isEndState() {
        return false;
    }

    @Override // com.tencent.zplan.meme.action.ActionStatus
    public int toInt() {
        return 24;
    }
}

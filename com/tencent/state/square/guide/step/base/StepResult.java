package com.tencent.state.square.guide.step.base;

import com.tencent.raft.codegenmeta.utils.RLog;
import java.io.Serializable;
import kotlin.Metadata;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u00012\u00020\u0002B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007\u00a8\u0006\b"}, d2 = {"Lcom/tencent/state/square/guide/step/base/StepResult;", "", "Ljava/io/Serializable;", "(Ljava/lang/String;I)V", "COMPLETE", "IGNORE", "CANCEL", RLog.ERROR, "state_square_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes38.dex */
public enum StepResult implements Serializable {
    COMPLETE,
    IGNORE,
    CANCEL,
    ERROR
}

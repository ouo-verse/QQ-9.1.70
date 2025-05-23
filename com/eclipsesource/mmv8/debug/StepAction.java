package com.eclipsesource.mmv8.debug;

/* compiled from: P */
/* loaded from: classes2.dex */
public enum StepAction {
    STEP_OUT(0),
    STEP_NEXT(1),
    STEP_IN(2),
    STEP_FRAME(3);

    int index;

    StepAction(int i3) {
        this.index = i3;
    }
}

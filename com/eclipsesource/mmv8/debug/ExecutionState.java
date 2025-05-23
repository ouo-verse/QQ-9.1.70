package com.eclipsesource.mmv8.debug;

import com.eclipsesource.mmv8.Releasable;
import com.eclipsesource.mmv8.V8Array;
import com.eclipsesource.mmv8.V8Object;
import com.eclipsesource.mmv8.debug.mirror.Frame;

/* compiled from: P */
/* loaded from: classes2.dex */
public class ExecutionState implements Releasable {
    private static final String FRAME = "frame";
    private static final String FRAME_COUNT = "frameCount";
    private static final String PREPARE_STEP = "prepareStep";
    private V8Object v8Object;

    public ExecutionState(V8Object v8Object) {
        this.v8Object = v8Object.twin();
    }

    public Frame getFrame(int i3) {
        V8Array v8Array = new V8Array(this.v8Object.getRuntime());
        v8Array.push(i3);
        V8Object v8Object = null;
        try {
            v8Object = this.v8Object.executeObjectFunction("frame", v8Array);
            return new Frame(v8Object);
        } finally {
            v8Array.release();
            if (v8Object != null) {
                v8Object.release();
            }
        }
    }

    public int getFrameCount() {
        return this.v8Object.executeIntegerFunction(FRAME_COUNT, null);
    }

    public void prepareStep(StepAction stepAction) {
        V8Array v8Array = new V8Array(this.v8Object.getRuntime());
        v8Array.push(stepAction.index);
        try {
            this.v8Object.executeVoidFunction(PREPARE_STEP, v8Array);
        } finally {
            v8Array.release();
        }
    }

    @Override // com.eclipsesource.mmv8.Releasable
    public void release() {
        V8Object v8Object = this.v8Object;
        if (v8Object != null && !v8Object.isReleased()) {
            this.v8Object.release();
            this.v8Object = null;
        }
    }
}

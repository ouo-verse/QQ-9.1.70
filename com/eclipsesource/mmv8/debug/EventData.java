package com.eclipsesource.mmv8.debug;

import com.eclipsesource.mmv8.Releasable;
import com.eclipsesource.mmv8.V8Object;

/* compiled from: P */
/* loaded from: classes2.dex */
public class EventData implements Releasable {
    protected V8Object v8Object;

    public EventData(V8Object v8Object) {
        this.v8Object = v8Object.twin();
    }

    @Override // com.eclipsesource.mmv8.Releasable
    public void release() {
        if (!this.v8Object.isReleased()) {
            this.v8Object.release();
        }
    }
}

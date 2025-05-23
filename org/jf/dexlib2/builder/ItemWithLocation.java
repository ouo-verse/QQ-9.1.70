package org.jf.dexlib2.builder;

import javax.annotation.Nullable;

/* compiled from: P */
/* loaded from: classes29.dex */
public abstract class ItemWithLocation {

    @Nullable
    MethodLocation location;

    public boolean isPlaced() {
        if (this.location != null) {
            return true;
        }
        return false;
    }

    public void setLocation(MethodLocation methodLocation) {
        this.location = methodLocation;
    }
}

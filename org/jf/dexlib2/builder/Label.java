package org.jf.dexlib2.builder;

import javax.annotation.Nonnull;

/* compiled from: P */
/* loaded from: classes29.dex */
public class Label extends ItemWithLocation {
    /* JADX INFO: Access modifiers changed from: package-private */
    public Label() {
    }

    public int getCodeAddress() {
        return getLocation().getCodeAddress();
    }

    @Nonnull
    public MethodLocation getLocation() {
        MethodLocation methodLocation = this.location;
        if (methodLocation != null) {
            return methodLocation;
        }
        throw new IllegalStateException("Cannot get the location of a label that hasn't been placed yet.");
    }

    Label(MethodLocation methodLocation) {
        this.location = methodLocation;
    }
}

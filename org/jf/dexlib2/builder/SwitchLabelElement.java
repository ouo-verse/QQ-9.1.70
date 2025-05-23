package org.jf.dexlib2.builder;

import javax.annotation.Nonnull;

/* compiled from: P */
/* loaded from: classes29.dex */
public class SwitchLabelElement {
    public final int key;

    @Nonnull
    public final Label target;

    public SwitchLabelElement(int i3, @Nonnull Label label) {
        this.key = i3;
        this.target = label;
    }
}

package org.jf.dexlib2.iface;

import java.util.Set;
import javax.annotation.Nonnull;

/* compiled from: P */
/* loaded from: classes29.dex */
public interface BasicAnnotation {
    @Nonnull
    Set<? extends AnnotationElement> getElements();

    @Nonnull
    String getType();
}

package org.jf.dexlib2.iface;

import java.util.Set;
import javax.annotation.Nonnull;

/* compiled from: P */
/* loaded from: classes29.dex */
public interface Annotatable {
    @Nonnull
    Set<? extends Annotation> getAnnotations();
}

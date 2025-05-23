package org.jf.dexlib2.iface;

import java.util.Set;
import javax.annotation.Nonnull;
import org.jf.dexlib2.HiddenApiRestriction;

/* compiled from: P */
/* loaded from: classes29.dex */
public interface Member extends Annotatable {
    int getAccessFlags();

    @Nonnull
    String getDefiningClass();

    @Nonnull
    Set<HiddenApiRestriction> getHiddenApiRestrictions();

    @Nonnull
    String getName();
}

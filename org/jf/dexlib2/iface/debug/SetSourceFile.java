package org.jf.dexlib2.iface.debug;

import javax.annotation.Nullable;
import org.jf.dexlib2.iface.reference.StringReference;

/* compiled from: P */
/* loaded from: classes29.dex */
public interface SetSourceFile extends DebugItem {
    @Nullable
    String getSourceFile();

    @Nullable
    StringReference getSourceFileReference();
}

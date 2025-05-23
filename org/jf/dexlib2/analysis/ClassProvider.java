package org.jf.dexlib2.analysis;

import javax.annotation.Nullable;
import org.jf.dexlib2.iface.ClassDef;

/* loaded from: classes29.dex */
public interface ClassProvider {
    @Nullable
    ClassDef getClassDef(String str);
}

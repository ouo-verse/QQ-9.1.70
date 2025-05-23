package org.jf.dexlib2.analysis;

import com.google.common.collect.Maps;
import java.util.Map;
import javax.annotation.Nullable;
import org.jf.dexlib2.iface.ClassDef;
import org.jf.dexlib2.iface.DexFile;

/* loaded from: classes29.dex */
public class DexClassProvider implements ClassProvider {
    private Map<String, ClassDef> classMap = Maps.j();
    private final DexFile dexFile;

    public DexClassProvider(DexFile dexFile) {
        this.dexFile = dexFile;
        for (ClassDef classDef : dexFile.getClasses()) {
            this.classMap.put(classDef.getType(), classDef);
        }
    }

    @Override // org.jf.dexlib2.analysis.ClassProvider
    @Nullable
    public ClassDef getClassDef(String str) {
        return this.classMap.get(str);
    }
}

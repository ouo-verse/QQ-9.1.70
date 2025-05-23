package org.jf.dexlib2.analysis;

import androidx.exifinterface.media.ExifInterface;
import com.google.common.base.Suppliers;
import com.google.common.base.o;
import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.f;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Lists;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import javax.annotation.Nonnull;
import org.jf.dexlib2.Opcodes;
import org.jf.dexlib2.analysis.reflection.ReflectionClassDef;
import org.jf.dexlib2.iface.ClassDef;
import org.jf.dexlib2.immutable.ImmutableDexFile;

/* loaded from: classes29.dex */
public class ClassPath {
    public static final int NOT_ART = -1;
    public static final int NOT_SPECIFIED = -2;
    private final boolean checkPackagePrivateAccess;
    private final CacheLoader<String, TypeProto> classLoader;

    @Nonnull
    private List<ClassProvider> classProviders;
    private final o<OdexedFieldInstructionMapper> fieldInstructionMapperSupplier;

    @Nonnull
    private f<String, TypeProto> loadedClasses;
    public final int oatVersion;

    @Nonnull
    private final TypeProto unknownClass;

    public ClassPath(ClassProvider... classProviderArr) throws IOException {
        this(Arrays.asList(classProviderArr), false, -1);
    }

    private static ClassProvider getBasicClasses() {
        return new DexClassProvider(new ImmutableDexFile(Opcodes.getDefault(), (Collection<? extends ClassDef>) ImmutableSet.of(new ReflectionClassDef(Class.class), new ReflectionClassDef(Cloneable.class), new ReflectionClassDef(Object.class), new ReflectionClassDef(Serializable.class), new ReflectionClassDef(String.class), new ReflectionClassDef(Throwable.class), new ReflectionClassDef[0])));
    }

    private void loadPrimitiveType(String str) {
        this.loadedClasses.put(str, new PrimitiveProto(this, str));
    }

    @Nonnull
    public TypeProto getClass(@Nonnull CharSequence charSequence) {
        return this.loadedClasses.getUnchecked(charSequence.toString());
    }

    @Nonnull
    public ClassDef getClassDef(String str) {
        Iterator<ClassProvider> it = this.classProviders.iterator();
        while (it.hasNext()) {
            ClassDef classDef = it.next().getClassDef(str);
            if (classDef != null) {
                return classDef;
            }
        }
        throw new UnresolvedClassException("Could not resolve class %s", str);
    }

    @Nonnull
    public OdexedFieldInstructionMapper getFieldInstructionMapper() {
        return this.fieldInstructionMapperSupplier.get();
    }

    @Nonnull
    public TypeProto getUnknownClass() {
        return this.unknownClass;
    }

    public boolean isArt() {
        if (this.oatVersion != -1) {
            return true;
        }
        return false;
    }

    public boolean shouldCheckPackagePrivateAccess() {
        return this.checkPackagePrivateAccess;
    }

    public ClassPath(Iterable<ClassProvider> iterable) throws IOException {
        this(iterable, false, -1);
    }

    public ClassPath(@Nonnull Iterable<? extends ClassProvider> iterable, boolean z16, int i3) {
        CacheLoader<String, TypeProto> cacheLoader = new CacheLoader<String, TypeProto>() { // from class: org.jf.dexlib2.analysis.ClassPath.1
            @Override // com.google.common.cache.CacheLoader
            public TypeProto load(String str) throws Exception {
                if (str.charAt(0) == '[') {
                    return new ArrayProto(ClassPath.this, str);
                }
                return new ClassProto(ClassPath.this, str);
            }
        };
        this.classLoader = cacheLoader;
        this.loadedClasses = CacheBuilder.y().b(cacheLoader);
        this.fieldInstructionMapperSupplier = Suppliers.a(new o<OdexedFieldInstructionMapper>() { // from class: org.jf.dexlib2.analysis.ClassPath.2
            @Override // com.google.common.base.o
            public OdexedFieldInstructionMapper get() {
                return new OdexedFieldInstructionMapper(ClassPath.this.isArt());
            }
        });
        UnknownClassProto unknownClassProto = new UnknownClassProto(this);
        this.unknownClass = unknownClassProto;
        this.loadedClasses.put(unknownClassProto.getType(), unknownClassProto);
        this.checkPackagePrivateAccess = z16;
        this.oatVersion = i3;
        loadPrimitiveType("Z");
        loadPrimitiveType("B");
        loadPrimitiveType(ExifInterface.LATITUDE_SOUTH);
        loadPrimitiveType(BdhLogUtil.LogTag.Tag_Conn);
        loadPrimitiveType("I");
        loadPrimitiveType("J");
        loadPrimitiveType(UserInfo.SEX_FEMALE);
        loadPrimitiveType("D");
        loadPrimitiveType("L");
        ArrayList i16 = Lists.i(iterable);
        this.classProviders = i16;
        i16.add(getBasicClasses());
    }
}

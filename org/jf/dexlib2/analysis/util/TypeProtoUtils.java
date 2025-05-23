package org.jf.dexlib2.analysis.util;

import java.util.Iterator;
import java.util.NoSuchElementException;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import org.jf.dexlib2.analysis.TypeProto;
import org.jf.dexlib2.analysis.UnresolvedClassException;

/* loaded from: classes29.dex */
public class TypeProtoUtils {
    public static boolean extendsFrom(@Nonnull TypeProto typeProto, @Nonnull String str) {
        if (typeProto.getType().equals(str)) {
            return true;
        }
        Iterator<TypeProto> it = getSuperclassChain(typeProto).iterator();
        while (it.hasNext()) {
            if (it.next().getType().equals(str)) {
                return true;
            }
        }
        return false;
    }

    @Nullable
    public static TypeProto getSuperclassAsTypeProto(@Nonnull TypeProto typeProto) {
        try {
            String superclass = typeProto.getSuperclass();
            if (superclass != null) {
                return typeProto.getClassPath().getClass(superclass);
            }
            return null;
        } catch (UnresolvedClassException unused) {
            return typeProto.getClassPath().getUnknownClass();
        }
    }

    @Nonnull
    public static Iterable<TypeProto> getSuperclassChain(@Nonnull final TypeProto typeProto) {
        return new Iterable<TypeProto>() { // from class: org.jf.dexlib2.analysis.util.TypeProtoUtils.1
            @Override // java.lang.Iterable
            public Iterator<TypeProto> iterator() {
                return new Iterator<TypeProto>() { // from class: org.jf.dexlib2.analysis.util.TypeProtoUtils.1.1

                    @Nullable
                    private TypeProto type;

                    {
                        this.type = TypeProtoUtils.getSuperclassAsTypeProto(TypeProto.this);
                    }

                    @Override // java.util.Iterator
                    public boolean hasNext() {
                        if (this.type != null) {
                            return true;
                        }
                        return false;
                    }

                    @Override // java.util.Iterator
                    public void remove() {
                        throw new UnsupportedOperationException();
                    }

                    @Override // java.util.Iterator
                    public TypeProto next() {
                        TypeProto typeProto2 = this.type;
                        if (typeProto2 != null) {
                            this.type = TypeProtoUtils.getSuperclassAsTypeProto(typeProto2);
                            return typeProto2;
                        }
                        throw new NoSuchElementException();
                    }
                };
            }
        };
    }
}

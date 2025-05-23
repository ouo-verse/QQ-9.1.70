package kotlin.reflect.jvm.internal.impl.load.kotlin.header;

import cooperation.qzone.webviewplugin.QZoneJsConstants;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kotlin.reflect.jvm.internal.impl.descriptors.SourceElement;
import kotlin.reflect.jvm.internal.impl.load.java.JvmAnnotationNames;
import kotlin.reflect.jvm.internal.impl.load.kotlin.KotlinJvmBinaryClass;
import kotlin.reflect.jvm.internal.impl.load.kotlin.header.KotlinClassHeader;
import kotlin.reflect.jvm.internal.impl.metadata.jvm.deserialization.BitEncoding;
import kotlin.reflect.jvm.internal.impl.metadata.jvm.deserialization.JvmMetadataVersion;
import kotlin.reflect.jvm.internal.impl.name.ClassId;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.resolve.constants.ClassLiteralValue;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
/* loaded from: classes28.dex */
public class ReadKotlinClassHeaderAnnotationVisitor implements KotlinJvmBinaryClass.AnnotationVisitor {
    private static final Map<ClassId, KotlinClassHeader.Kind> HEADER_KINDS;
    private static final boolean IGNORE_OLD_METADATA = "true".equals(System.getProperty("kotlin.ignore.old.metadata"));
    private int[] metadataVersionArray = null;
    private String extraString = null;
    private int extraInt = 0;
    private String packageName = null;
    private String[] data = null;
    private String[] strings = null;
    private String[] incompatibleData = null;
    private KotlinClassHeader.Kind headerKind = null;
    private String[] serializedIrFields = null;

    /* compiled from: P */
    /* loaded from: classes28.dex */
    private static abstract class CollectStringArrayAnnotationVisitor implements KotlinJvmBinaryClass.AnnotationArrayArgumentVisitor {
        private final List<String> strings = new ArrayList();

        private static /* synthetic */ void $$$reportNull$$$0(int i3) {
            Object[] objArr = new Object[3];
            if (i3 != 1) {
                if (i3 != 2) {
                    if (i3 != 3) {
                        objArr[0] = "enumClassId";
                    } else {
                        objArr[0] = "classId";
                    }
                } else {
                    objArr[0] = "classLiteralValue";
                }
            } else {
                objArr[0] = "enumEntryName";
            }
            objArr[1] = "kotlin/reflect/jvm/internal/impl/load/kotlin/header/ReadKotlinClassHeaderAnnotationVisitor$CollectStringArrayAnnotationVisitor";
            if (i3 != 2) {
                if (i3 != 3) {
                    objArr[2] = "visitEnum";
                } else {
                    objArr[2] = "visitAnnotation";
                }
            } else {
                objArr[2] = "visitClassLiteral";
            }
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", objArr));
        }

        @Override // kotlin.reflect.jvm.internal.impl.load.kotlin.KotlinJvmBinaryClass.AnnotationArrayArgumentVisitor
        public void visit(@Nullable Object obj) {
            if (obj instanceof String) {
                this.strings.add((String) obj);
            }
        }

        @Override // kotlin.reflect.jvm.internal.impl.load.kotlin.KotlinJvmBinaryClass.AnnotationArrayArgumentVisitor
        @Nullable
        public KotlinJvmBinaryClass.AnnotationArgumentVisitor visitAnnotation(@NotNull ClassId classId) {
            if (classId == null) {
                $$$reportNull$$$0(3);
                return null;
            }
            return null;
        }

        @Override // kotlin.reflect.jvm.internal.impl.load.kotlin.KotlinJvmBinaryClass.AnnotationArrayArgumentVisitor
        public void visitClassLiteral(@NotNull ClassLiteralValue classLiteralValue) {
            if (classLiteralValue == null) {
                $$$reportNull$$$0(2);
            }
        }

        @Override // kotlin.reflect.jvm.internal.impl.load.kotlin.KotlinJvmBinaryClass.AnnotationArrayArgumentVisitor
        public void visitEnd() {
            visitEnd((String[]) this.strings.toArray(new String[0]));
        }

        protected abstract void visitEnd(@NotNull String[] strArr);

        @Override // kotlin.reflect.jvm.internal.impl.load.kotlin.KotlinJvmBinaryClass.AnnotationArrayArgumentVisitor
        public void visitEnum(@NotNull ClassId classId, @NotNull Name name) {
            if (classId == null) {
                $$$reportNull$$$0(0);
            }
            if (name == null) {
                $$$reportNull$$$0(1);
            }
        }
    }

    private static /* synthetic */ void $$$reportNull$$$0(int i3) {
        Object[] objArr = new Object[3];
        if (i3 != 1) {
            objArr[0] = "classId";
        } else {
            objArr[0] = "source";
        }
        objArr[1] = "kotlin/reflect/jvm/internal/impl/load/kotlin/header/ReadKotlinClassHeaderAnnotationVisitor";
        objArr[2] = "visitAnnotation";
        throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", objArr));
    }

    static {
        HashMap hashMap = new HashMap();
        HEADER_KINDS = hashMap;
        hashMap.put(ClassId.topLevel(new FqName("kotlin.jvm.internal.KotlinClass")), KotlinClassHeader.Kind.CLASS);
        hashMap.put(ClassId.topLevel(new FqName("kotlin.jvm.internal.KotlinFileFacade")), KotlinClassHeader.Kind.FILE_FACADE);
        hashMap.put(ClassId.topLevel(new FqName("kotlin.jvm.internal.KotlinMultifileClass")), KotlinClassHeader.Kind.MULTIFILE_CLASS);
        hashMap.put(ClassId.topLevel(new FqName("kotlin.jvm.internal.KotlinMultifileClassPart")), KotlinClassHeader.Kind.MULTIFILE_CLASS_PART);
        hashMap.put(ClassId.topLevel(new FqName("kotlin.jvm.internal.KotlinSyntheticClass")), KotlinClassHeader.Kind.SYNTHETIC_CLASS);
    }

    private boolean shouldHaveData() {
        KotlinClassHeader.Kind kind = this.headerKind;
        if (kind != KotlinClassHeader.Kind.CLASS && kind != KotlinClassHeader.Kind.FILE_FACADE && kind != KotlinClassHeader.Kind.MULTIFILE_CLASS_PART) {
            return false;
        }
        return true;
    }

    @Nullable
    public KotlinClassHeader createHeader() {
        boolean z16;
        byte[] bArr = null;
        if (this.headerKind == null || this.metadataVersionArray == null) {
            return null;
        }
        int[] iArr = this.metadataVersionArray;
        if ((this.extraInt & 8) != 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        JvmMetadataVersion jvmMetadataVersion = new JvmMetadataVersion(iArr, z16);
        if (!jvmMetadataVersion.isCompatible()) {
            this.incompatibleData = this.data;
            this.data = null;
        } else if (shouldHaveData() && this.data == null) {
            return null;
        }
        String[] strArr = this.serializedIrFields;
        if (strArr != null) {
            bArr = BitEncoding.decodeBytes(strArr);
        }
        return new KotlinClassHeader(this.headerKind, jvmMetadataVersion, this.data, this.incompatibleData, this.strings, this.extraString, this.extraInt, this.packageName, bArr);
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.kotlin.KotlinJvmBinaryClass.AnnotationVisitor
    @Nullable
    public KotlinJvmBinaryClass.AnnotationArgumentVisitor visitAnnotation(@NotNull ClassId classId, @NotNull SourceElement sourceElement) {
        KotlinClassHeader.Kind kind;
        if (classId == null) {
            $$$reportNull$$$0(0);
        }
        if (sourceElement == null) {
            $$$reportNull$$$0(1);
        }
        FqName asSingleFqName = classId.asSingleFqName();
        if (asSingleFqName.equals(JvmAnnotationNames.METADATA_FQ_NAME)) {
            return new KotlinMetadataArgumentVisitor();
        }
        if (asSingleFqName.equals(JvmAnnotationNames.SERIALIZED_IR_FQ_NAME)) {
            return new KotlinSerializedIrArgumentVisitor();
        }
        if (IGNORE_OLD_METADATA || this.headerKind != null || (kind = HEADER_KINDS.get(classId)) == null) {
            return null;
        }
        this.headerKind = kind;
        return new OldDeprecatedAnnotationArgumentVisitor();
    }

    /* compiled from: P */
    /* loaded from: classes28.dex */
    private class KotlinMetadataArgumentVisitor implements KotlinJvmBinaryClass.AnnotationArgumentVisitor {
        private static /* synthetic */ void $$$reportNull$$$0(int i3) {
            Object[] objArr = new Object[3];
            if (i3 != 1) {
                if (i3 != 2) {
                    if (i3 != 3) {
                        objArr[0] = "classLiteralValue";
                    } else {
                        objArr[0] = "classId";
                    }
                } else {
                    objArr[0] = "enumEntryName";
                }
            } else {
                objArr[0] = "enumClassId";
            }
            objArr[1] = "kotlin/reflect/jvm/internal/impl/load/kotlin/header/ReadKotlinClassHeaderAnnotationVisitor$KotlinMetadataArgumentVisitor";
            if (i3 != 1 && i3 != 2) {
                if (i3 != 3) {
                    objArr[2] = "visitClassLiteral";
                } else {
                    objArr[2] = "visitAnnotation";
                }
            } else {
                objArr[2] = "visitEnum";
            }
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", objArr));
        }

        KotlinMetadataArgumentVisitor() {
        }

        @NotNull
        private KotlinJvmBinaryClass.AnnotationArrayArgumentVisitor dataArrayVisitor() {
            return new CollectStringArrayAnnotationVisitor() { // from class: kotlin.reflect.jvm.internal.impl.load.kotlin.header.ReadKotlinClassHeaderAnnotationVisitor.KotlinMetadataArgumentVisitor.1
                private static /* synthetic */ void $$$reportNull$$$0(int i3) {
                    throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "result", "kotlin/reflect/jvm/internal/impl/load/kotlin/header/ReadKotlinClassHeaderAnnotationVisitor$KotlinMetadataArgumentVisitor$1", "visitEnd"));
                }

                @Override // kotlin.reflect.jvm.internal.impl.load.kotlin.header.ReadKotlinClassHeaderAnnotationVisitor.CollectStringArrayAnnotationVisitor
                protected void visitEnd(@NotNull String[] strArr) {
                    if (strArr == null) {
                        $$$reportNull$$$0(0);
                    }
                    ReadKotlinClassHeaderAnnotationVisitor.this.data = strArr;
                }
            };
        }

        @NotNull
        private KotlinJvmBinaryClass.AnnotationArrayArgumentVisitor stringsArrayVisitor() {
            return new CollectStringArrayAnnotationVisitor() { // from class: kotlin.reflect.jvm.internal.impl.load.kotlin.header.ReadKotlinClassHeaderAnnotationVisitor.KotlinMetadataArgumentVisitor.2
                private static /* synthetic */ void $$$reportNull$$$0(int i3) {
                    throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "result", "kotlin/reflect/jvm/internal/impl/load/kotlin/header/ReadKotlinClassHeaderAnnotationVisitor$KotlinMetadataArgumentVisitor$2", "visitEnd"));
                }

                @Override // kotlin.reflect.jvm.internal.impl.load.kotlin.header.ReadKotlinClassHeaderAnnotationVisitor.CollectStringArrayAnnotationVisitor
                protected void visitEnd(@NotNull String[] strArr) {
                    if (strArr == null) {
                        $$$reportNull$$$0(0);
                    }
                    ReadKotlinClassHeaderAnnotationVisitor.this.strings = strArr;
                }
            };
        }

        @Override // kotlin.reflect.jvm.internal.impl.load.kotlin.KotlinJvmBinaryClass.AnnotationArgumentVisitor
        public void visit(@Nullable Name name, @Nullable Object obj) {
            if (name == null) {
                return;
            }
            String asString = name.asString();
            if ("k".equals(asString)) {
                if (obj instanceof Integer) {
                    ReadKotlinClassHeaderAnnotationVisitor.this.headerKind = KotlinClassHeader.Kind.getById(((Integer) obj).intValue());
                    return;
                }
                return;
            }
            if (QZoneJsConstants.DEFAULT_DYNAMIC_ALBUM_TEMPLT_ID_FOR_SHARE.equals(asString)) {
                if (obj instanceof int[]) {
                    ReadKotlinClassHeaderAnnotationVisitor.this.metadataVersionArray = (int[]) obj;
                    return;
                }
                return;
            }
            if ("xs".equals(asString)) {
                if (obj instanceof String) {
                    ReadKotlinClassHeaderAnnotationVisitor.this.extraString = (String) obj;
                    return;
                }
                return;
            }
            if ("xi".equals(asString)) {
                if (obj instanceof Integer) {
                    ReadKotlinClassHeaderAnnotationVisitor.this.extraInt = ((Integer) obj).intValue();
                    return;
                }
                return;
            }
            if ("pn".equals(asString) && (obj instanceof String)) {
                ReadKotlinClassHeaderAnnotationVisitor.this.packageName = (String) obj;
            }
        }

        @Override // kotlin.reflect.jvm.internal.impl.load.kotlin.KotlinJvmBinaryClass.AnnotationArgumentVisitor
        @Nullable
        public KotlinJvmBinaryClass.AnnotationArgumentVisitor visitAnnotation(@Nullable Name name, @NotNull ClassId classId) {
            if (classId == null) {
                $$$reportNull$$$0(3);
                return null;
            }
            return null;
        }

        @Override // kotlin.reflect.jvm.internal.impl.load.kotlin.KotlinJvmBinaryClass.AnnotationArgumentVisitor
        @Nullable
        public KotlinJvmBinaryClass.AnnotationArrayArgumentVisitor visitArray(@Nullable Name name) {
            String str;
            if (name != null) {
                str = name.asString();
            } else {
                str = null;
            }
            if ("d1".equals(str)) {
                return dataArrayVisitor();
            }
            if (!"d2".equals(str)) {
                return null;
            }
            return stringsArrayVisitor();
        }

        @Override // kotlin.reflect.jvm.internal.impl.load.kotlin.KotlinJvmBinaryClass.AnnotationArgumentVisitor
        public void visitClassLiteral(@Nullable Name name, @NotNull ClassLiteralValue classLiteralValue) {
            if (classLiteralValue == null) {
                $$$reportNull$$$0(0);
            }
        }

        @Override // kotlin.reflect.jvm.internal.impl.load.kotlin.KotlinJvmBinaryClass.AnnotationArgumentVisitor
        public void visitEnum(@Nullable Name name, @NotNull ClassId classId, @NotNull Name name2) {
            if (classId == null) {
                $$$reportNull$$$0(1);
            }
            if (name2 == null) {
                $$$reportNull$$$0(2);
            }
        }

        @Override // kotlin.reflect.jvm.internal.impl.load.kotlin.KotlinJvmBinaryClass.AnnotationArgumentVisitor
        public void visitEnd() {
        }
    }

    /* compiled from: P */
    /* loaded from: classes28.dex */
    private class KotlinSerializedIrArgumentVisitor implements KotlinJvmBinaryClass.AnnotationArgumentVisitor {
        private static /* synthetic */ void $$$reportNull$$$0(int i3) {
            Object[] objArr = new Object[3];
            if (i3 != 1) {
                if (i3 != 2) {
                    if (i3 != 3) {
                        objArr[0] = "classLiteralValue";
                    } else {
                        objArr[0] = "classId";
                    }
                } else {
                    objArr[0] = "enumEntryName";
                }
            } else {
                objArr[0] = "enumClassId";
            }
            objArr[1] = "kotlin/reflect/jvm/internal/impl/load/kotlin/header/ReadKotlinClassHeaderAnnotationVisitor$KotlinSerializedIrArgumentVisitor";
            if (i3 != 1 && i3 != 2) {
                if (i3 != 3) {
                    objArr[2] = "visitClassLiteral";
                } else {
                    objArr[2] = "visitAnnotation";
                }
            } else {
                objArr[2] = "visitEnum";
            }
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", objArr));
        }

        KotlinSerializedIrArgumentVisitor() {
        }

        @NotNull
        private KotlinJvmBinaryClass.AnnotationArrayArgumentVisitor serializedIrArrayVisitor() {
            return new CollectStringArrayAnnotationVisitor() { // from class: kotlin.reflect.jvm.internal.impl.load.kotlin.header.ReadKotlinClassHeaderAnnotationVisitor.KotlinSerializedIrArgumentVisitor.1
                private static /* synthetic */ void $$$reportNull$$$0(int i3) {
                    throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "result", "kotlin/reflect/jvm/internal/impl/load/kotlin/header/ReadKotlinClassHeaderAnnotationVisitor$KotlinSerializedIrArgumentVisitor$1", "visitEnd"));
                }

                @Override // kotlin.reflect.jvm.internal.impl.load.kotlin.header.ReadKotlinClassHeaderAnnotationVisitor.CollectStringArrayAnnotationVisitor
                protected void visitEnd(@NotNull String[] strArr) {
                    if (strArr == null) {
                        $$$reportNull$$$0(0);
                    }
                    ReadKotlinClassHeaderAnnotationVisitor.this.serializedIrFields = strArr;
                }
            };
        }

        @Override // kotlin.reflect.jvm.internal.impl.load.kotlin.KotlinJvmBinaryClass.AnnotationArgumentVisitor
        @Nullable
        public KotlinJvmBinaryClass.AnnotationArgumentVisitor visitAnnotation(@Nullable Name name, @NotNull ClassId classId) {
            if (classId == null) {
                $$$reportNull$$$0(3);
                return null;
            }
            return null;
        }

        @Override // kotlin.reflect.jvm.internal.impl.load.kotlin.KotlinJvmBinaryClass.AnnotationArgumentVisitor
        @Nullable
        public KotlinJvmBinaryClass.AnnotationArrayArgumentVisitor visitArray(@Nullable Name name) {
            String str;
            if (name != null) {
                str = name.asString();
            } else {
                str = null;
            }
            if (!"b".equals(str)) {
                return null;
            }
            return serializedIrArrayVisitor();
        }

        @Override // kotlin.reflect.jvm.internal.impl.load.kotlin.KotlinJvmBinaryClass.AnnotationArgumentVisitor
        public void visitClassLiteral(@Nullable Name name, @NotNull ClassLiteralValue classLiteralValue) {
            if (classLiteralValue == null) {
                $$$reportNull$$$0(0);
            }
        }

        @Override // kotlin.reflect.jvm.internal.impl.load.kotlin.KotlinJvmBinaryClass.AnnotationArgumentVisitor
        public void visitEnum(@Nullable Name name, @NotNull ClassId classId, @NotNull Name name2) {
            if (classId == null) {
                $$$reportNull$$$0(1);
            }
            if (name2 == null) {
                $$$reportNull$$$0(2);
            }
        }

        @Override // kotlin.reflect.jvm.internal.impl.load.kotlin.KotlinJvmBinaryClass.AnnotationArgumentVisitor
        public void visitEnd() {
        }

        @Override // kotlin.reflect.jvm.internal.impl.load.kotlin.KotlinJvmBinaryClass.AnnotationArgumentVisitor
        public void visit(@Nullable Name name, @Nullable Object obj) {
        }
    }

    /* compiled from: P */
    /* loaded from: classes28.dex */
    private class OldDeprecatedAnnotationArgumentVisitor implements KotlinJvmBinaryClass.AnnotationArgumentVisitor {
        private static /* synthetic */ void $$$reportNull$$$0(int i3) {
            Object[] objArr = new Object[3];
            if (i3 != 1) {
                if (i3 != 2) {
                    if (i3 != 3) {
                        objArr[0] = "classLiteralValue";
                    } else {
                        objArr[0] = "classId";
                    }
                } else {
                    objArr[0] = "enumEntryName";
                }
            } else {
                objArr[0] = "enumClassId";
            }
            objArr[1] = "kotlin/reflect/jvm/internal/impl/load/kotlin/header/ReadKotlinClassHeaderAnnotationVisitor$OldDeprecatedAnnotationArgumentVisitor";
            if (i3 != 1 && i3 != 2) {
                if (i3 != 3) {
                    objArr[2] = "visitClassLiteral";
                } else {
                    objArr[2] = "visitAnnotation";
                }
            } else {
                objArr[2] = "visitEnum";
            }
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", objArr));
        }

        OldDeprecatedAnnotationArgumentVisitor() {
        }

        @NotNull
        private KotlinJvmBinaryClass.AnnotationArrayArgumentVisitor dataArrayVisitor() {
            return new CollectStringArrayAnnotationVisitor() { // from class: kotlin.reflect.jvm.internal.impl.load.kotlin.header.ReadKotlinClassHeaderAnnotationVisitor.OldDeprecatedAnnotationArgumentVisitor.1
                private static /* synthetic */ void $$$reportNull$$$0(int i3) {
                    throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "data", "kotlin/reflect/jvm/internal/impl/load/kotlin/header/ReadKotlinClassHeaderAnnotationVisitor$OldDeprecatedAnnotationArgumentVisitor$1", "visitEnd"));
                }

                @Override // kotlin.reflect.jvm.internal.impl.load.kotlin.header.ReadKotlinClassHeaderAnnotationVisitor.CollectStringArrayAnnotationVisitor
                protected void visitEnd(@NotNull String[] strArr) {
                    if (strArr == null) {
                        $$$reportNull$$$0(0);
                    }
                    ReadKotlinClassHeaderAnnotationVisitor.this.data = strArr;
                }
            };
        }

        @NotNull
        private KotlinJvmBinaryClass.AnnotationArrayArgumentVisitor stringsArrayVisitor() {
            return new CollectStringArrayAnnotationVisitor() { // from class: kotlin.reflect.jvm.internal.impl.load.kotlin.header.ReadKotlinClassHeaderAnnotationVisitor.OldDeprecatedAnnotationArgumentVisitor.2
                private static /* synthetic */ void $$$reportNull$$$0(int i3) {
                    throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "data", "kotlin/reflect/jvm/internal/impl/load/kotlin/header/ReadKotlinClassHeaderAnnotationVisitor$OldDeprecatedAnnotationArgumentVisitor$2", "visitEnd"));
                }

                @Override // kotlin.reflect.jvm.internal.impl.load.kotlin.header.ReadKotlinClassHeaderAnnotationVisitor.CollectStringArrayAnnotationVisitor
                protected void visitEnd(@NotNull String[] strArr) {
                    if (strArr == null) {
                        $$$reportNull$$$0(0);
                    }
                    ReadKotlinClassHeaderAnnotationVisitor.this.strings = strArr;
                }
            };
        }

        @Override // kotlin.reflect.jvm.internal.impl.load.kotlin.KotlinJvmBinaryClass.AnnotationArgumentVisitor
        public void visit(@Nullable Name name, @Nullable Object obj) {
            String str;
            if (name == null) {
                return;
            }
            String asString = name.asString();
            if ("version".equals(asString)) {
                if (obj instanceof int[]) {
                    ReadKotlinClassHeaderAnnotationVisitor.this.metadataVersionArray = (int[]) obj;
                    return;
                }
                return;
            }
            if ("multifileClassName".equals(asString)) {
                ReadKotlinClassHeaderAnnotationVisitor readKotlinClassHeaderAnnotationVisitor = ReadKotlinClassHeaderAnnotationVisitor.this;
                if (obj instanceof String) {
                    str = (String) obj;
                } else {
                    str = null;
                }
                readKotlinClassHeaderAnnotationVisitor.extraString = str;
            }
        }

        @Override // kotlin.reflect.jvm.internal.impl.load.kotlin.KotlinJvmBinaryClass.AnnotationArgumentVisitor
        @Nullable
        public KotlinJvmBinaryClass.AnnotationArgumentVisitor visitAnnotation(@Nullable Name name, @NotNull ClassId classId) {
            if (classId == null) {
                $$$reportNull$$$0(3);
                return null;
            }
            return null;
        }

        @Override // kotlin.reflect.jvm.internal.impl.load.kotlin.KotlinJvmBinaryClass.AnnotationArgumentVisitor
        @Nullable
        public KotlinJvmBinaryClass.AnnotationArrayArgumentVisitor visitArray(@Nullable Name name) {
            String str;
            if (name != null) {
                str = name.asString();
            } else {
                str = null;
            }
            if (!"data".equals(str) && !"filePartClassNames".equals(str)) {
                if (!"strings".equals(str)) {
                    return null;
                }
                return stringsArrayVisitor();
            }
            return dataArrayVisitor();
        }

        @Override // kotlin.reflect.jvm.internal.impl.load.kotlin.KotlinJvmBinaryClass.AnnotationArgumentVisitor
        public void visitClassLiteral(@Nullable Name name, @NotNull ClassLiteralValue classLiteralValue) {
            if (classLiteralValue == null) {
                $$$reportNull$$$0(0);
            }
        }

        @Override // kotlin.reflect.jvm.internal.impl.load.kotlin.KotlinJvmBinaryClass.AnnotationArgumentVisitor
        public void visitEnum(@Nullable Name name, @NotNull ClassId classId, @NotNull Name name2) {
            if (classId == null) {
                $$$reportNull$$$0(1);
            }
            if (name2 == null) {
                $$$reportNull$$$0(2);
            }
        }

        @Override // kotlin.reflect.jvm.internal.impl.load.kotlin.KotlinJvmBinaryClass.AnnotationArgumentVisitor
        public void visitEnd() {
        }
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.kotlin.KotlinJvmBinaryClass.AnnotationVisitor
    public void visitEnd() {
    }
}

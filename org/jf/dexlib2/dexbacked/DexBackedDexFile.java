package org.jf.dexlib2.dexbacked;

import java.io.IOException;
import java.io.InputStream;
import java.util.AbstractList;
import java.util.List;
import java.util.Set;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import org.jf.dexlib2.Opcodes;
import org.jf.dexlib2.dexbacked.raw.HeaderItem;
import org.jf.dexlib2.dexbacked.raw.MapItem;
import org.jf.dexlib2.dexbacked.reference.DexBackedCallSiteReference;
import org.jf.dexlib2.dexbacked.reference.DexBackedFieldReference;
import org.jf.dexlib2.dexbacked.reference.DexBackedMethodHandleReference;
import org.jf.dexlib2.dexbacked.reference.DexBackedMethodProtoReference;
import org.jf.dexlib2.dexbacked.reference.DexBackedMethodReference;
import org.jf.dexlib2.dexbacked.reference.DexBackedStringReference;
import org.jf.dexlib2.dexbacked.reference.DexBackedTypeReference;
import org.jf.dexlib2.dexbacked.util.FixedSizeList;
import org.jf.dexlib2.dexbacked.util.FixedSizeSet;
import org.jf.dexlib2.iface.DexFile;
import org.jf.dexlib2.iface.reference.Reference;
import org.jf.dexlib2.util.DexUtil;

/* compiled from: P */
/* loaded from: classes29.dex */
public class DexBackedDexFile implements DexFile {
    private IndexedSection<DexBackedCallSiteReference> callSiteSection;
    private final int classCount;
    private IndexedSection<DexBackedClassDef> classSection;
    private final int classStartOffset;
    private final DexBuffer dataBuffer;
    private final DexBuffer dexBuffer;
    private final int fieldCount;
    private IndexedSection<DexBackedFieldReference> fieldSection;
    private final int fieldStartOffset;
    private final int hiddenApiRestrictionsOffset;
    private final int mapOffset;
    private final int methodCount;
    private IndexedSection<DexBackedMethodHandleReference> methodHandleSection;
    private IndexedSection<DexBackedMethodReference> methodSection;
    private final int methodStartOffset;

    @Nonnull
    private final Opcodes opcodes;
    private final int protoCount;
    private IndexedSection<DexBackedMethodProtoReference> protoSection;
    private final int protoStartOffset;
    private final int stringCount;
    private OptionalIndexedSection<String> stringSection;
    private final int stringStartOffset;
    private final int typeCount;
    private OptionalIndexedSection<String> typeSection;
    private final int typeStartOffset;

    /* compiled from: P */
    /* loaded from: classes29.dex */
    public static abstract class IndexedSection<T> extends AbstractList<T> {
        public abstract int getOffset(int i3);
    }

    /* compiled from: P */
    /* loaded from: classes29.dex */
    public static class NotADexFile extends RuntimeException {
        public NotADexFile() {
        }

        public NotADexFile(Throwable th5) {
            super(th5);
        }

        public NotADexFile(String str) {
            super(str);
        }

        public NotADexFile(String str, Throwable th5) {
            super(str, th5);
        }
    }

    /* compiled from: P */
    /* loaded from: classes29.dex */
    public static abstract class OptionalIndexedSection<T> extends IndexedSection<T> {
        @Nullable
        public abstract T getOptional(int i3);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public DexBackedDexFile(@Nullable Opcodes opcodes, @Nonnull byte[] bArr, int i3, boolean z16) {
        this.stringSection = new OptionalIndexedSection<String>() { // from class: org.jf.dexlib2.dexbacked.DexBackedDexFile.5
            @Override // org.jf.dexlib2.dexbacked.DexBackedDexFile.IndexedSection
            public int getOffset(int i16) {
                if (i16 >= 0 && i16 < size()) {
                    return DexBackedDexFile.this.stringStartOffset + (i16 * 4);
                }
                throw new IndexOutOfBoundsException(String.format("Invalid string index %d, not in [0, %d)", Integer.valueOf(i16), Integer.valueOf(size())));
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
            public int size() {
                return DexBackedDexFile.this.stringCount;
            }

            @Override // java.util.AbstractList, java.util.List
            public String get(int i16) {
                DexReader<? extends DexBuffer> readerAt = DexBackedDexFile.this.dataBuffer.readerAt(DexBackedDexFile.this.dexBuffer.readSmallUint(getOffset(i16)));
                return readerAt.readString(readerAt.readSmallUleb128());
            }

            @Override // org.jf.dexlib2.dexbacked.DexBackedDexFile.OptionalIndexedSection
            @Nullable
            public String getOptional(int i16) {
                if (i16 == -1) {
                    return null;
                }
                return get(i16);
            }
        };
        this.typeSection = new OptionalIndexedSection<String>() { // from class: org.jf.dexlib2.dexbacked.DexBackedDexFile.6
            @Override // org.jf.dexlib2.dexbacked.DexBackedDexFile.IndexedSection
            public int getOffset(int i16) {
                if (i16 >= 0 && i16 < size()) {
                    return DexBackedDexFile.this.typeStartOffset + (i16 * 4);
                }
                throw new IndexOutOfBoundsException(String.format("Invalid type index %d, not in [0, %d)", Integer.valueOf(i16), Integer.valueOf(size())));
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
            public int size() {
                return DexBackedDexFile.this.typeCount;
            }

            @Override // java.util.AbstractList, java.util.List
            public String get(int i16) {
                return DexBackedDexFile.this.getStringSection().get(DexBackedDexFile.this.dexBuffer.readSmallUint(getOffset(i16)));
            }

            @Override // org.jf.dexlib2.dexbacked.DexBackedDexFile.OptionalIndexedSection
            @Nullable
            public String getOptional(int i16) {
                if (i16 == -1) {
                    return null;
                }
                return get(i16);
            }
        };
        this.fieldSection = new IndexedSection<DexBackedFieldReference>() { // from class: org.jf.dexlib2.dexbacked.DexBackedDexFile.7
            @Override // org.jf.dexlib2.dexbacked.DexBackedDexFile.IndexedSection
            public int getOffset(int i16) {
                if (i16 >= 0 && i16 < size()) {
                    return DexBackedDexFile.this.fieldStartOffset + (i16 * 8);
                }
                throw new IndexOutOfBoundsException(String.format("Invalid field index %d, not in [0, %d)", Integer.valueOf(i16), Integer.valueOf(size())));
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
            public int size() {
                return DexBackedDexFile.this.fieldCount;
            }

            @Override // java.util.AbstractList, java.util.List
            public DexBackedFieldReference get(int i16) {
                return new DexBackedFieldReference(DexBackedDexFile.this, i16);
            }
        };
        this.methodSection = new IndexedSection<DexBackedMethodReference>() { // from class: org.jf.dexlib2.dexbacked.DexBackedDexFile.8
            @Override // org.jf.dexlib2.dexbacked.DexBackedDexFile.IndexedSection
            public int getOffset(int i16) {
                if (i16 >= 0 && i16 < size()) {
                    return DexBackedDexFile.this.methodStartOffset + (i16 * 8);
                }
                throw new IndexOutOfBoundsException(String.format("Invalid method index %d, not in [0, %d)", Integer.valueOf(i16), Integer.valueOf(size())));
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
            public int size() {
                return DexBackedDexFile.this.methodCount;
            }

            @Override // java.util.AbstractList, java.util.List
            public DexBackedMethodReference get(int i16) {
                return new DexBackedMethodReference(DexBackedDexFile.this, i16);
            }
        };
        this.protoSection = new IndexedSection<DexBackedMethodProtoReference>() { // from class: org.jf.dexlib2.dexbacked.DexBackedDexFile.9
            @Override // org.jf.dexlib2.dexbacked.DexBackedDexFile.IndexedSection
            public int getOffset(int i16) {
                if (i16 >= 0 && i16 < size()) {
                    return DexBackedDexFile.this.protoStartOffset + (i16 * 12);
                }
                throw new IndexOutOfBoundsException(String.format("Invalid proto index %d, not in [0, %d)", Integer.valueOf(i16), Integer.valueOf(size())));
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
            public int size() {
                return DexBackedDexFile.this.protoCount;
            }

            @Override // java.util.AbstractList, java.util.List
            public DexBackedMethodProtoReference get(int i16) {
                return new DexBackedMethodProtoReference(DexBackedDexFile.this, i16);
            }
        };
        this.classSection = new IndexedSection<DexBackedClassDef>() { // from class: org.jf.dexlib2.dexbacked.DexBackedDexFile.10
            @Override // org.jf.dexlib2.dexbacked.DexBackedDexFile.IndexedSection
            public int getOffset(int i16) {
                if (i16 >= 0 && i16 < size()) {
                    return DexBackedDexFile.this.classStartOffset + (i16 * 32);
                }
                throw new IndexOutOfBoundsException(String.format("Invalid class index %d, not in [0, %d)", Integer.valueOf(i16), Integer.valueOf(size())));
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
            public int size() {
                return DexBackedDexFile.this.classCount;
            }

            @Override // java.util.AbstractList, java.util.List
            public DexBackedClassDef get(int i16) {
                return new DexBackedClassDef(DexBackedDexFile.this, getOffset(i16), DexBackedDexFile.this.readHiddenApiRestrictionsOffset(i16));
            }
        };
        this.callSiteSection = new IndexedSection<DexBackedCallSiteReference>() { // from class: org.jf.dexlib2.dexbacked.DexBackedDexFile.11
            @Override // org.jf.dexlib2.dexbacked.DexBackedDexFile.IndexedSection
            public int getOffset(int i16) {
                MapItem mapItemForSection = DexBackedDexFile.this.getMapItemForSection(7);
                if (i16 >= 0 && i16 < size()) {
                    return mapItemForSection.getOffset() + (i16 * 4);
                }
                throw new IndexOutOfBoundsException(String.format("Invalid callsite index %d, not in [0, %d)", Integer.valueOf(i16), Integer.valueOf(size())));
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
            public int size() {
                MapItem mapItemForSection = DexBackedDexFile.this.getMapItemForSection(7);
                if (mapItemForSection == null) {
                    return 0;
                }
                return mapItemForSection.getItemCount();
            }

            @Override // java.util.AbstractList, java.util.List
            public DexBackedCallSiteReference get(int i16) {
                return new DexBackedCallSiteReference(DexBackedDexFile.this, i16);
            }
        };
        this.methodHandleSection = new IndexedSection<DexBackedMethodHandleReference>() { // from class: org.jf.dexlib2.dexbacked.DexBackedDexFile.12
            @Override // org.jf.dexlib2.dexbacked.DexBackedDexFile.IndexedSection
            public int getOffset(int i16) {
                MapItem mapItemForSection = DexBackedDexFile.this.getMapItemForSection(8);
                if (i16 >= 0 && i16 < size()) {
                    return mapItemForSection.getOffset() + (i16 * 8);
                }
                throw new IndexOutOfBoundsException(String.format("Invalid method handle index %d, not in [0, %d)", Integer.valueOf(i16), Integer.valueOf(size())));
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
            public int size() {
                MapItem mapItemForSection = DexBackedDexFile.this.getMapItemForSection(8);
                if (mapItemForSection == null) {
                    return 0;
                }
                return mapItemForSection.getItemCount();
            }

            @Override // java.util.AbstractList, java.util.List
            public DexBackedMethodHandleReference get(int i16) {
                return new DexBackedMethodHandleReference(DexBackedDexFile.this, i16);
            }
        };
        DexBuffer dexBuffer = new DexBuffer(bArr, i3);
        this.dexBuffer = dexBuffer;
        this.dataBuffer = new DexBuffer(bArr, getBaseDataOffset() + i3);
        int version = getVersion(bArr, i3, z16);
        if (opcodes == null) {
            this.opcodes = getDefaultOpcodes(version);
        } else {
            this.opcodes = opcodes;
        }
        this.stringCount = dexBuffer.readSmallUint(56);
        this.stringStartOffset = dexBuffer.readSmallUint(60);
        this.typeCount = dexBuffer.readSmallUint(64);
        this.typeStartOffset = dexBuffer.readSmallUint(68);
        this.protoCount = dexBuffer.readSmallUint(72);
        this.protoStartOffset = dexBuffer.readSmallUint(76);
        this.fieldCount = dexBuffer.readSmallUint(80);
        this.fieldStartOffset = dexBuffer.readSmallUint(84);
        this.methodCount = dexBuffer.readSmallUint(88);
        this.methodStartOffset = dexBuffer.readSmallUint(92);
        this.classCount = dexBuffer.readSmallUint(96);
        this.classStartOffset = dexBuffer.readSmallUint(100);
        this.mapOffset = dexBuffer.readSmallUint(52);
        MapItem mapItemForSection = getMapItemForSection(61440);
        if (mapItemForSection != null) {
            this.hiddenApiRestrictionsOffset = mapItemForSection.getOffset();
        } else {
            this.hiddenApiRestrictionsOffset = 0;
        }
    }

    @Nonnull
    public static DexBackedDexFile fromInputStream(@Nullable Opcodes opcodes, @Nonnull InputStream inputStream) throws IOException {
        DexUtil.verifyDexHeader(inputStream);
        return new DexBackedDexFile(opcodes, q1.b.j(inputStream), 0, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int readHiddenApiRestrictionsOffset(int i3) {
        int readInt;
        int i16 = this.hiddenApiRestrictionsOffset;
        if (i16 == 0 || (readInt = this.dexBuffer.readInt(i16 + 4 + (i3 * 4))) == 0) {
            return 0;
        }
        return this.hiddenApiRestrictionsOffset + readInt;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public DexBackedMethodImplementation createMethodImplementation(@Nonnull DexBackedDexFile dexBackedDexFile, @Nonnull DexBackedMethod dexBackedMethod, int i3) {
        return new DexBackedMethodImplementation(dexBackedDexFile, dexBackedMethod, i3);
    }

    public int getBaseDataOffset() {
        return 0;
    }

    public DexBuffer getBuffer() {
        return this.dexBuffer;
    }

    public IndexedSection<DexBackedCallSiteReference> getCallSiteSection() {
        return this.callSiteSection;
    }

    public IndexedSection<DexBackedClassDef> getClassSection() {
        return this.classSection;
    }

    @Override // org.jf.dexlib2.iface.DexFile
    @Nonnull
    public Set<? extends DexBackedClassDef> getClasses() {
        return new FixedSizeSet<DexBackedClassDef>() { // from class: org.jf.dexlib2.dexbacked.DexBackedDexFile.1
            @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
            public int size() {
                return DexBackedDexFile.this.classCount;
            }

            @Override // org.jf.dexlib2.dexbacked.util.FixedSizeSet
            @Nonnull
            public DexBackedClassDef readItem(int i3) {
                return DexBackedDexFile.this.getClassSection().get(i3);
            }
        };
    }

    public DexBuffer getDataBuffer() {
        return this.dataBuffer;
    }

    protected Opcodes getDefaultOpcodes(int i3) {
        return Opcodes.forDexVersion(i3);
    }

    public IndexedSection<DexBackedFieldReference> getFieldSection() {
        return this.fieldSection;
    }

    @Nullable
    public MapItem getMapItemForSection(int i3) {
        for (MapItem mapItem : getMapItems()) {
            if (mapItem.getType() == i3) {
                return mapItem;
            }
        }
        return null;
    }

    public List<MapItem> getMapItems() {
        final int readSmallUint = this.dataBuffer.readSmallUint(this.mapOffset);
        return new FixedSizeList<MapItem>() { // from class: org.jf.dexlib2.dexbacked.DexBackedDexFile.4
            @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
            public int size() {
                return readSmallUint;
            }

            @Override // org.jf.dexlib2.dexbacked.util.FixedSizeList
            public MapItem readItem(int i3) {
                return new MapItem(DexBackedDexFile.this, DexBackedDexFile.this.mapOffset + 4 + (i3 * 12));
            }
        };
    }

    public IndexedSection<DexBackedMethodHandleReference> getMethodHandleSection() {
        return this.methodHandleSection;
    }

    public IndexedSection<DexBackedMethodReference> getMethodSection() {
        return this.methodSection;
    }

    @Override // org.jf.dexlib2.iface.DexFile
    @Nonnull
    public Opcodes getOpcodes() {
        return this.opcodes;
    }

    public IndexedSection<DexBackedMethodProtoReference> getProtoSection() {
        return this.protoSection;
    }

    public List<? extends Reference> getReferences(int i3) {
        if (i3 != 0) {
            if (i3 != 1) {
                if (i3 != 2) {
                    if (i3 == 3) {
                        return getMethodSection();
                    }
                    throw new IllegalArgumentException(String.format("Invalid reference type: %d", Integer.valueOf(i3)));
                }
                return getFieldSection();
            }
            return getTypeReferences();
        }
        return getStringReferences();
    }

    public List<DexBackedStringReference> getStringReferences() {
        return new AbstractList<DexBackedStringReference>() { // from class: org.jf.dexlib2.dexbacked.DexBackedDexFile.2
            @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
            public int size() {
                return DexBackedDexFile.this.getStringSection().size();
            }

            @Override // java.util.AbstractList, java.util.List
            public DexBackedStringReference get(int i3) {
                if (i3 >= 0 && i3 < DexBackedDexFile.this.getStringSection().size()) {
                    return new DexBackedStringReference(DexBackedDexFile.this, i3);
                }
                throw new IndexOutOfBoundsException();
            }
        };
    }

    public OptionalIndexedSection<String> getStringSection() {
        return this.stringSection;
    }

    public List<DexBackedTypeReference> getTypeReferences() {
        return new AbstractList<DexBackedTypeReference>() { // from class: org.jf.dexlib2.dexbacked.DexBackedDexFile.3
            @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
            public int size() {
                return DexBackedDexFile.this.getTypeSection().size();
            }

            @Override // java.util.AbstractList, java.util.List
            public DexBackedTypeReference get(int i3) {
                if (i3 >= 0 && i3 < DexBackedDexFile.this.getTypeSection().size()) {
                    return new DexBackedTypeReference(DexBackedDexFile.this, i3);
                }
                throw new IndexOutOfBoundsException();
            }
        };
    }

    public OptionalIndexedSection<String> getTypeSection() {
        return this.typeSection;
    }

    protected int getVersion(byte[] bArr, int i3, boolean z16) {
        if (z16) {
            return DexUtil.verifyDexHeader(bArr, i3);
        }
        return HeaderItem.getVersion(bArr, i3);
    }

    public boolean supportsOptimizedOpcodes() {
        return false;
    }

    protected DexBackedDexFile(@Nullable Opcodes opcodes, @Nonnull DexBuffer dexBuffer, @Nonnull DexBuffer dexBuffer2, int i3, boolean z16) {
        this.stringSection = new OptionalIndexedSection<String>() { // from class: org.jf.dexlib2.dexbacked.DexBackedDexFile.5
            @Override // org.jf.dexlib2.dexbacked.DexBackedDexFile.IndexedSection
            public int getOffset(int i16) {
                if (i16 >= 0 && i16 < size()) {
                    return DexBackedDexFile.this.stringStartOffset + (i16 * 4);
                }
                throw new IndexOutOfBoundsException(String.format("Invalid string index %d, not in [0, %d)", Integer.valueOf(i16), Integer.valueOf(size())));
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
            public int size() {
                return DexBackedDexFile.this.stringCount;
            }

            @Override // java.util.AbstractList, java.util.List
            public String get(int i16) {
                DexReader<? extends DexBuffer> readerAt = DexBackedDexFile.this.dataBuffer.readerAt(DexBackedDexFile.this.dexBuffer.readSmallUint(getOffset(i16)));
                return readerAt.readString(readerAt.readSmallUleb128());
            }

            @Override // org.jf.dexlib2.dexbacked.DexBackedDexFile.OptionalIndexedSection
            @Nullable
            public String getOptional(int i16) {
                if (i16 == -1) {
                    return null;
                }
                return get(i16);
            }
        };
        this.typeSection = new OptionalIndexedSection<String>() { // from class: org.jf.dexlib2.dexbacked.DexBackedDexFile.6
            @Override // org.jf.dexlib2.dexbacked.DexBackedDexFile.IndexedSection
            public int getOffset(int i16) {
                if (i16 >= 0 && i16 < size()) {
                    return DexBackedDexFile.this.typeStartOffset + (i16 * 4);
                }
                throw new IndexOutOfBoundsException(String.format("Invalid type index %d, not in [0, %d)", Integer.valueOf(i16), Integer.valueOf(size())));
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
            public int size() {
                return DexBackedDexFile.this.typeCount;
            }

            @Override // java.util.AbstractList, java.util.List
            public String get(int i16) {
                return DexBackedDexFile.this.getStringSection().get(DexBackedDexFile.this.dexBuffer.readSmallUint(getOffset(i16)));
            }

            @Override // org.jf.dexlib2.dexbacked.DexBackedDexFile.OptionalIndexedSection
            @Nullable
            public String getOptional(int i16) {
                if (i16 == -1) {
                    return null;
                }
                return get(i16);
            }
        };
        this.fieldSection = new IndexedSection<DexBackedFieldReference>() { // from class: org.jf.dexlib2.dexbacked.DexBackedDexFile.7
            @Override // org.jf.dexlib2.dexbacked.DexBackedDexFile.IndexedSection
            public int getOffset(int i16) {
                if (i16 >= 0 && i16 < size()) {
                    return DexBackedDexFile.this.fieldStartOffset + (i16 * 8);
                }
                throw new IndexOutOfBoundsException(String.format("Invalid field index %d, not in [0, %d)", Integer.valueOf(i16), Integer.valueOf(size())));
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
            public int size() {
                return DexBackedDexFile.this.fieldCount;
            }

            @Override // java.util.AbstractList, java.util.List
            public DexBackedFieldReference get(int i16) {
                return new DexBackedFieldReference(DexBackedDexFile.this, i16);
            }
        };
        this.methodSection = new IndexedSection<DexBackedMethodReference>() { // from class: org.jf.dexlib2.dexbacked.DexBackedDexFile.8
            @Override // org.jf.dexlib2.dexbacked.DexBackedDexFile.IndexedSection
            public int getOffset(int i16) {
                if (i16 >= 0 && i16 < size()) {
                    return DexBackedDexFile.this.methodStartOffset + (i16 * 8);
                }
                throw new IndexOutOfBoundsException(String.format("Invalid method index %d, not in [0, %d)", Integer.valueOf(i16), Integer.valueOf(size())));
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
            public int size() {
                return DexBackedDexFile.this.methodCount;
            }

            @Override // java.util.AbstractList, java.util.List
            public DexBackedMethodReference get(int i16) {
                return new DexBackedMethodReference(DexBackedDexFile.this, i16);
            }
        };
        this.protoSection = new IndexedSection<DexBackedMethodProtoReference>() { // from class: org.jf.dexlib2.dexbacked.DexBackedDexFile.9
            @Override // org.jf.dexlib2.dexbacked.DexBackedDexFile.IndexedSection
            public int getOffset(int i16) {
                if (i16 >= 0 && i16 < size()) {
                    return DexBackedDexFile.this.protoStartOffset + (i16 * 12);
                }
                throw new IndexOutOfBoundsException(String.format("Invalid proto index %d, not in [0, %d)", Integer.valueOf(i16), Integer.valueOf(size())));
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
            public int size() {
                return DexBackedDexFile.this.protoCount;
            }

            @Override // java.util.AbstractList, java.util.List
            public DexBackedMethodProtoReference get(int i16) {
                return new DexBackedMethodProtoReference(DexBackedDexFile.this, i16);
            }
        };
        this.classSection = new IndexedSection<DexBackedClassDef>() { // from class: org.jf.dexlib2.dexbacked.DexBackedDexFile.10
            @Override // org.jf.dexlib2.dexbacked.DexBackedDexFile.IndexedSection
            public int getOffset(int i16) {
                if (i16 >= 0 && i16 < size()) {
                    return DexBackedDexFile.this.classStartOffset + (i16 * 32);
                }
                throw new IndexOutOfBoundsException(String.format("Invalid class index %d, not in [0, %d)", Integer.valueOf(i16), Integer.valueOf(size())));
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
            public int size() {
                return DexBackedDexFile.this.classCount;
            }

            @Override // java.util.AbstractList, java.util.List
            public DexBackedClassDef get(int i16) {
                return new DexBackedClassDef(DexBackedDexFile.this, getOffset(i16), DexBackedDexFile.this.readHiddenApiRestrictionsOffset(i16));
            }
        };
        this.callSiteSection = new IndexedSection<DexBackedCallSiteReference>() { // from class: org.jf.dexlib2.dexbacked.DexBackedDexFile.11
            @Override // org.jf.dexlib2.dexbacked.DexBackedDexFile.IndexedSection
            public int getOffset(int i16) {
                MapItem mapItemForSection = DexBackedDexFile.this.getMapItemForSection(7);
                if (i16 >= 0 && i16 < size()) {
                    return mapItemForSection.getOffset() + (i16 * 4);
                }
                throw new IndexOutOfBoundsException(String.format("Invalid callsite index %d, not in [0, %d)", Integer.valueOf(i16), Integer.valueOf(size())));
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
            public int size() {
                MapItem mapItemForSection = DexBackedDexFile.this.getMapItemForSection(7);
                if (mapItemForSection == null) {
                    return 0;
                }
                return mapItemForSection.getItemCount();
            }

            @Override // java.util.AbstractList, java.util.List
            public DexBackedCallSiteReference get(int i16) {
                return new DexBackedCallSiteReference(DexBackedDexFile.this, i16);
            }
        };
        this.methodHandleSection = new IndexedSection<DexBackedMethodHandleReference>() { // from class: org.jf.dexlib2.dexbacked.DexBackedDexFile.12
            @Override // org.jf.dexlib2.dexbacked.DexBackedDexFile.IndexedSection
            public int getOffset(int i16) {
                MapItem mapItemForSection = DexBackedDexFile.this.getMapItemForSection(8);
                if (i16 >= 0 && i16 < size()) {
                    return mapItemForSection.getOffset() + (i16 * 8);
                }
                throw new IndexOutOfBoundsException(String.format("Invalid method handle index %d, not in [0, %d)", Integer.valueOf(i16), Integer.valueOf(size())));
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
            public int size() {
                MapItem mapItemForSection = DexBackedDexFile.this.getMapItemForSection(8);
                if (mapItemForSection == null) {
                    return 0;
                }
                return mapItemForSection.getItemCount();
            }

            @Override // java.util.AbstractList, java.util.List
            public DexBackedMethodHandleReference get(int i16) {
                return new DexBackedMethodHandleReference(DexBackedDexFile.this, i16);
            }
        };
        this.dexBuffer = dexBuffer;
        this.dataBuffer = dexBuffer2;
        int version = getVersion(dexBuffer.readByteRange(i3, 112), i3, z16);
        if (opcodes == null) {
            this.opcodes = getDefaultOpcodes(version);
        } else {
            this.opcodes = opcodes;
        }
        this.stringCount = dexBuffer.readSmallUint(56);
        this.stringStartOffset = dexBuffer.readSmallUint(60);
        this.typeCount = dexBuffer.readSmallUint(64);
        this.typeStartOffset = dexBuffer.readSmallUint(68);
        this.protoCount = dexBuffer.readSmallUint(72);
        this.protoStartOffset = dexBuffer.readSmallUint(76);
        this.fieldCount = dexBuffer.readSmallUint(80);
        this.fieldStartOffset = dexBuffer.readSmallUint(84);
        this.methodCount = dexBuffer.readSmallUint(88);
        this.methodStartOffset = dexBuffer.readSmallUint(92);
        this.classCount = dexBuffer.readSmallUint(96);
        this.classStartOffset = dexBuffer.readSmallUint(100);
        this.mapOffset = dexBuffer.readSmallUint(52);
        MapItem mapItemForSection = getMapItemForSection(61440);
        if (mapItemForSection != null) {
            this.hiddenApiRestrictionsOffset = mapItemForSection.getOffset();
        } else {
            this.hiddenApiRestrictionsOffset = 0;
        }
    }

    public DexBackedDexFile(@Nullable Opcodes opcodes, @Nonnull DexBuffer dexBuffer) {
        this(opcodes, dexBuffer.buf, dexBuffer.baseOffset);
    }

    public DexBackedDexFile(@Nullable Opcodes opcodes, @Nonnull byte[] bArr, int i3) {
        this(opcodes, bArr, i3, false);
    }

    public DexBackedDexFile(@Nullable Opcodes opcodes, @Nonnull byte[] bArr) {
        this(opcodes, bArr, 0, true);
    }
}

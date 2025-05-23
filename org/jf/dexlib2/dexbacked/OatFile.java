package org.jf.dexlib2.dexbacked;

import com.google.common.base.k;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.r;
import com.tencent.biz.pubaccount.util.api.IPublicAccountH5AbilityPlugin;
import com.tencent.biz.pubaccount.util.api.impl.PublicAccountH5AbilityPluginImpl;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;
import java.util.AbstractList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import org.jf.dexlib2.DexFileFactory;
import org.jf.dexlib2.Opcodes;
import org.jf.dexlib2.dexbacked.DexBackedDexFile;
import org.jf.dexlib2.dexbacked.OatFile;
import org.jf.dexlib2.iface.MultiDexContainer;
import org.jf.dexlib2.util.DexUtil;
import org.jf.util.AbstractForwardSequentialList;

/* compiled from: P */
/* loaded from: classes29.dex */
public class OatFile extends DexBuffer implements MultiDexContainer<DexBackedDexFile> {
    private static final int MAX_OAT_VERSION = 178;
    private static final int MIN_ELF_HEADER_SIZE = 52;
    private static final int MIN_OAT_VERSION = 56;
    public static final int SUPPORTED = 1;
    public static final int UNKNOWN = 2;
    public static final int UNSUPPORTED = 0;
    private final boolean is64bit;

    @Nonnull
    private final OatHeader oatHeader;

    @Nonnull
    private final Opcodes opcodes;

    @Nullable
    private final VdexProvider vdexProvider;
    private static final byte[] ELF_MAGIC = {Byte.MAX_VALUE, 69, 76, 70};
    private static final byte[] OAT_MAGIC = {PublicAccountH5AbilityPluginImpl.OPENIMG, 97, IPublicAccountH5AbilityPlugin.REQ_CODE_UGC_CAMERA_CAPTURE, 10};

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes29.dex */
    public class DexEntryIterator implements Iterator<OatDexEntry> {
        int index;
        int offset;

        DexEntryIterator() {
            this.index = 0;
            this.offset = OatFile.this.oatHeader.getDexListStart();
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            if (this.index < OatFile.this.oatHeader.getDexFileCount()) {
                return true;
            }
            return false;
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.Iterator
        public OatDexEntry next() {
            byte[] bArr;
            while (hasNext()) {
                int readSmallUint = OatFile.this.readSmallUint(this.offset);
                int i3 = this.offset + 4;
                this.offset = i3;
                String str = new String(OatFile.this.buf, i3, readSmallUint, Charset.forName("US-ASCII"));
                int i16 = this.offset + readSmallUint + 4;
                this.offset = i16;
                int readSmallUint2 = OatFile.this.readSmallUint(i16);
                this.offset += 4;
                if (OatFile.this.getOatVersion() >= 87 && OatFile.this.vdexProvider != null && OatFile.this.vdexProvider.getVdex() != null) {
                    bArr = OatFile.this.vdexProvider.getVdex();
                } else {
                    OatFile oatFile = OatFile.this;
                    byte[] bArr2 = oatFile.buf;
                    readSmallUint2 += oatFile.oatHeader.headerOffset;
                    bArr = bArr2;
                }
                if (OatFile.this.getOatVersion() >= 75) {
                    this.offset += 4;
                }
                if (OatFile.this.getOatVersion() >= 73) {
                    this.offset += 4;
                }
                if (OatFile.this.getOatVersion() >= 131) {
                    this.offset += 4;
                }
                if (OatFile.this.getOatVersion() >= 127) {
                    this.offset += 4;
                }
                if (OatFile.this.getOatVersion() >= 135) {
                    this.offset += 8;
                }
                if (OatFile.this.getOatVersion() < 75) {
                    this.offset += OatFile.this.readSmallUint(readSmallUint2 + 96) * 4;
                }
                this.index++;
                if (OatFile.this.getOatVersion() < 138 || readSmallUint2 != 0) {
                    return new OatDexEntry(str, bArr, readSmallUint2);
                }
            }
            return null;
        }
    }

    /* compiled from: P */
    /* loaded from: classes29.dex */
    public static class InvalidOatFileException extends RuntimeException {
        public InvalidOatFileException(String str) {
            super(str);
        }
    }

    /* compiled from: P */
    /* loaded from: classes29.dex */
    public static class NotAnOatFileException extends RuntimeException {
    }

    /* compiled from: P */
    /* loaded from: classes29.dex */
    public class OatCDexFile extends CDexBackedDexFile {
        public OatCDexFile(byte[] bArr, int i3) {
            super(OatFile.this.opcodes, bArr, i3);
        }

        @Override // org.jf.dexlib2.dexbacked.DexBackedDexFile
        public boolean supportsOptimizedOpcodes() {
            return true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes29.dex */
    public class OatDexEntry implements MultiDexContainer.DexEntry<DexBackedDexFile> {
        public final byte[] buf;
        public final int dexOffset;
        public final String entryName;

        public OatDexEntry(String str, byte[] bArr, int i3) {
            this.entryName = str;
            this.buf = bArr;
            this.dexOffset = i3;
        }

        @Override // org.jf.dexlib2.iface.MultiDexContainer.DexEntry
        @Nonnull
        public MultiDexContainer<? extends DexBackedDexFile> getContainer() {
            return OatFile.this;
        }

        @Override // org.jf.dexlib2.iface.MultiDexContainer.DexEntry
        @Nonnull
        public String getEntryName() {
            return this.entryName;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // org.jf.dexlib2.iface.MultiDexContainer.DexEntry
        public DexBackedDexFile getDexFile() {
            if (CDexBackedDexFile.isCdex(this.buf, this.dexOffset)) {
                return new OatCDexFile(this.buf, this.dexOffset);
            }
            try {
                DexUtil.verifyDexHeader(this.buf, this.dexOffset);
                return new OatDexFile(this.buf, this.dexOffset);
            } catch (DexBackedDexFile.NotADexFile e16) {
                if (OatFile.this.getOatVersion() >= 87) {
                    throw new DexFileFactory.DexFileNotFoundException(e16, "Could not locate the embedded dex file %s. Is the vdex file missing?", this.entryName);
                }
                throw new DexFileFactory.DexFileNotFoundException(e16, "The embedded dex file %s does not appear to be a valid dex file.", this.entryName);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes29.dex */
    public class OatDexFile extends DexBackedDexFile {
        public OatDexFile(@Nonnull byte[] bArr, int i3) {
            super(OatFile.this.opcodes, bArr, i3);
        }

        @Override // org.jf.dexlib2.dexbacked.DexBackedDexFile
        public boolean supportsOptimizedOpcodes() {
            return true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes29.dex */
    public class OatHeader {
        private final int headerOffset;
        private final int keyValueStoreOffset;

        public OatHeader(int i3) {
            this.headerOffset = i3;
            if (getVersion() >= 170) {
                this.keyValueStoreOffset = 56;
                return;
            }
            if (getVersion() >= 166) {
                this.keyValueStoreOffset = 64;
                return;
            }
            if (getVersion() >= 162) {
                this.keyValueStoreOffset = 68;
            } else if (getVersion() >= 127) {
                this.keyValueStoreOffset = 76;
            } else {
                this.keyValueStoreOffset = 72;
            }
        }

        public int getDexFileCount() {
            return OatFile.this.readSmallUint(this.headerOffset + 20);
        }

        public int getDexListStart() {
            int i3;
            int headerSize;
            if (getVersion() >= 127) {
                i3 = this.headerOffset;
                headerSize = OatFile.this.readSmallUint(i3 + 24);
            } else {
                i3 = this.headerOffset;
                headerSize = getHeaderSize();
            }
            return i3 + headerSize;
        }

        public int getHeaderSize() {
            if (getVersion() >= 56) {
                return this.keyValueStoreOffset + getKeyValueStoreSize();
            }
            throw new IllegalStateException("Unsupported oat version");
        }

        @Nullable
        public String getKeyValue(@Nonnull String str) {
            int keyValueStoreSize = getKeyValueStoreSize();
            int i3 = this.headerOffset + this.keyValueStoreOffset;
            int i16 = keyValueStoreSize + i3;
            while (i3 < i16) {
                int i17 = i3;
                while (i17 < i16 && OatFile.this.buf[i17] != 0) {
                    i17++;
                }
                if (i17 < i16) {
                    if (new String(OatFile.this.buf, i3, i17 - i3).equals(str)) {
                        int i18 = i17 + 1;
                        int i19 = i18;
                        while (i19 < i16 && OatFile.this.buf[i19] != 0) {
                            i19++;
                        }
                        if (i19 < i16) {
                            return new String(OatFile.this.buf, i18, i19 - i18);
                        }
                        throw new InvalidOatFileException("Oat file contains truncated key value store");
                    }
                    i3 = i17 + 1;
                } else {
                    throw new InvalidOatFileException("Oat file contains truncated key value store");
                }
            }
            return null;
        }

        public int getKeyValueStoreSize() {
            if (getVersion() >= 56) {
                return OatFile.this.readSmallUint(this.headerOffset + (this.keyValueStoreOffset - 4));
            }
            throw new IllegalStateException("Unsupported oat version");
        }

        public int getVersion() {
            return Integer.valueOf(new String(OatFile.this.buf, this.headerOffset + 4, 3)).intValue();
        }

        public boolean isValid() {
            for (int i3 = 0; i3 < OatFile.OAT_MAGIC.length; i3++) {
                if (OatFile.this.buf[this.headerOffset + i3] != OatFile.OAT_MAGIC[i3]) {
                    return false;
                }
            }
            for (int i16 = 4; i16 < 7; i16++) {
                byte[] bArr = OatFile.this.buf;
                int i17 = this.headerOffset;
                if (bArr[i17 + i16] < 48 || bArr[i17 + i16] > 57) {
                    return false;
                }
            }
            if (OatFile.this.buf[this.headerOffset + 7] != 0) {
                return false;
            }
            return true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes29.dex */
    public abstract class SectionHeader {
        public static final int TYPE_DYNAMIC_SYMBOL_TABLE = 11;
        protected final int offset;

        public SectionHeader(int i3) {
            this.offset = i3;
        }

        public abstract long getAddress();

        public abstract int getEntrySize();

        public abstract int getLink();

        @Nonnull
        public String getName() {
            return OatFile.this.getSectionNameStringTable().getString(OatFile.this.readSmallUint(this.offset));
        }

        public abstract int getOffset();

        public abstract int getSize();

        public int getType() {
            return OatFile.this.readInt(this.offset + 4);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes29.dex */
    public class SectionHeader32Bit extends SectionHeader {
        public SectionHeader32Bit(int i3) {
            super(i3);
        }

        @Override // org.jf.dexlib2.dexbacked.OatFile.SectionHeader
        public long getAddress() {
            return OatFile.this.readInt(this.offset + 12) & 4294967295L;
        }

        @Override // org.jf.dexlib2.dexbacked.OatFile.SectionHeader
        public int getEntrySize() {
            return OatFile.this.readSmallUint(this.offset + 36);
        }

        @Override // org.jf.dexlib2.dexbacked.OatFile.SectionHeader
        public int getLink() {
            return OatFile.this.readSmallUint(this.offset + 24);
        }

        @Override // org.jf.dexlib2.dexbacked.OatFile.SectionHeader
        public int getOffset() {
            return OatFile.this.readSmallUint(this.offset + 16);
        }

        @Override // org.jf.dexlib2.dexbacked.OatFile.SectionHeader
        public int getSize() {
            return OatFile.this.readSmallUint(this.offset + 20);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes29.dex */
    public class SectionHeader64Bit extends SectionHeader {
        public SectionHeader64Bit(int i3) {
            super(i3);
        }

        @Override // org.jf.dexlib2.dexbacked.OatFile.SectionHeader
        public long getAddress() {
            return OatFile.this.readLong(this.offset + 16);
        }

        @Override // org.jf.dexlib2.dexbacked.OatFile.SectionHeader
        public int getEntrySize() {
            return OatFile.this.readLongAsSmallUint(this.offset + 56);
        }

        @Override // org.jf.dexlib2.dexbacked.OatFile.SectionHeader
        public int getLink() {
            return OatFile.this.readSmallUint(this.offset + 40);
        }

        @Override // org.jf.dexlib2.dexbacked.OatFile.SectionHeader
        public int getOffset() {
            return OatFile.this.readLongAsSmallUint(this.offset + 24);
        }

        @Override // org.jf.dexlib2.dexbacked.OatFile.SectionHeader
        public int getSize() {
            return OatFile.this.readLongAsSmallUint(this.offset + 32);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes29.dex */
    public class StringTable {
        private final int offset;
        private final int size;

        public StringTable(@Nonnull SectionHeader sectionHeader) {
            int offset = sectionHeader.getOffset();
            this.offset = offset;
            int size = sectionHeader.getSize();
            this.size = size;
            if (offset + size <= OatFile.this.buf.length) {
            } else {
                throw new InvalidOatFileException("String table extends past end of file");
            }
        }

        @Nonnull
        public String getString(int i3) {
            if (i3 < this.size) {
                int i16 = this.offset + i3;
                int i17 = i16;
                do {
                    byte[] bArr = OatFile.this.buf;
                    if (bArr[i17] != 0) {
                        i17++;
                    } else {
                        return new String(bArr, i16, i17 - i16, Charset.forName("US-ASCII"));
                    }
                } while (i17 < this.offset + this.size);
                throw new InvalidOatFileException("String extends past end of string table");
            }
            throw new InvalidOatFileException("String index is out of bounds");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes29.dex */
    public class SymbolTable {
        private final int entryCount;
        private final int entrySize;
        private final int offset;

        @Nonnull
        private final StringTable stringTable;

        /* compiled from: P */
        /* loaded from: classes29.dex */
        public abstract class Symbol {
            static final /* synthetic */ boolean $assertionsDisabled = false;
            protected final int offset;

            public Symbol(int i3) {
                this.offset = i3;
            }

            public int getFileOffset() {
                try {
                    SectionHeader sectionHeader = (SectionHeader) OatFile.this.getSections().get(getSectionIndex());
                    long address = sectionHeader.getAddress();
                    int offset = sectionHeader.getOffset();
                    int size = sectionHeader.getSize();
                    long value = getValue();
                    if (value >= address && value < size + address) {
                        return (int) (offset + (getValue() - address));
                    }
                    throw new InvalidOatFileException("symbol address lies outside it's associated section");
                } catch (IndexOutOfBoundsException unused) {
                    throw new InvalidOatFileException("Section index for symbol is out of bounds");
                }
            }

            @Nonnull
            public abstract String getName();

            public abstract int getSectionIndex();

            public abstract int getSize();

            public abstract long getValue();
        }

        /* compiled from: P */
        /* loaded from: classes29.dex */
        public class Symbol32 extends Symbol {
            public Symbol32(int i3) {
                super(i3);
            }

            @Override // org.jf.dexlib2.dexbacked.OatFile.SymbolTable.Symbol
            @Nonnull
            public String getName() {
                return SymbolTable.this.stringTable.getString(OatFile.this.readSmallUint(this.offset));
            }

            @Override // org.jf.dexlib2.dexbacked.OatFile.SymbolTable.Symbol
            public int getSectionIndex() {
                return OatFile.this.readUshort(this.offset + 14);
            }

            @Override // org.jf.dexlib2.dexbacked.OatFile.SymbolTable.Symbol
            public int getSize() {
                return OatFile.this.readSmallUint(this.offset + 8);
            }

            @Override // org.jf.dexlib2.dexbacked.OatFile.SymbolTable.Symbol
            public long getValue() {
                return OatFile.this.readSmallUint(this.offset + 4);
            }
        }

        /* compiled from: P */
        /* loaded from: classes29.dex */
        public class Symbol64 extends Symbol {
            public Symbol64(int i3) {
                super(i3);
            }

            @Override // org.jf.dexlib2.dexbacked.OatFile.SymbolTable.Symbol
            @Nonnull
            public String getName() {
                return SymbolTable.this.stringTable.getString(OatFile.this.readSmallUint(this.offset));
            }

            @Override // org.jf.dexlib2.dexbacked.OatFile.SymbolTable.Symbol
            public int getSectionIndex() {
                return OatFile.this.readUshort(this.offset + 6);
            }

            @Override // org.jf.dexlib2.dexbacked.OatFile.SymbolTable.Symbol
            public int getSize() {
                return OatFile.this.readLongAsSmallUint(this.offset + 16);
            }

            @Override // org.jf.dexlib2.dexbacked.OatFile.SymbolTable.Symbol
            public long getValue() {
                return OatFile.this.readLong(this.offset + 8);
            }
        }

        public SymbolTable(@Nonnull SectionHeader sectionHeader) {
            try {
                this.stringTable = new StringTable((SectionHeader) OatFile.this.getSections().get(sectionHeader.getLink()));
                int offset = sectionHeader.getOffset();
                this.offset = offset;
                int entrySize = sectionHeader.getEntrySize();
                this.entrySize = entrySize;
                int size = sectionHeader.getSize() / entrySize;
                this.entryCount = size;
                if (offset + (size * entrySize) <= OatFile.this.buf.length) {
                } else {
                    throw new InvalidOatFileException("Symbol table extends past end of file");
                }
            } catch (IndexOutOfBoundsException unused) {
                throw new InvalidOatFileException("String table section index is invalid");
            }
        }

        @Nonnull
        public List<Symbol> getSymbols() {
            return new AbstractList<Symbol>() { // from class: org.jf.dexlib2.dexbacked.OatFile.SymbolTable.1
                @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
                public int size() {
                    return SymbolTable.this.entryCount;
                }

                @Override // java.util.AbstractList, java.util.List
                public Symbol get(int i3) {
                    if (i3 >= 0 && i3 < SymbolTable.this.entryCount) {
                        if (OatFile.this.is64bit) {
                            SymbolTable symbolTable = SymbolTable.this;
                            return new Symbol64(symbolTable.offset + (i3 * SymbolTable.this.entrySize));
                        }
                        SymbolTable symbolTable2 = SymbolTable.this;
                        return new Symbol32(symbolTable2.offset + (i3 * SymbolTable.this.entrySize));
                    }
                    throw new IndexOutOfBoundsException();
                }
            };
        }
    }

    /* compiled from: P */
    /* loaded from: classes29.dex */
    public interface VdexProvider {
        @Nullable
        byte[] getVdex();
    }

    public OatFile(@Nonnull byte[] bArr) {
        this(bArr, null);
    }

    public static OatFile fromInputStream(@Nonnull InputStream inputStream) throws IOException {
        return fromInputStream(inputStream, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Nonnull
    public StringTable getSectionNameStringTable() {
        int readUshort = readUshort(50);
        if (readUshort != 0) {
            try {
                return new StringTable(getSections().get(readUshort));
            } catch (IndexOutOfBoundsException unused) {
                throw new InvalidOatFileException("The section index for the section name string table is invalid");
            }
        }
        throw new InvalidOatFileException("There is no section name string table");
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Nonnull
    public List<SectionHeader> getSections() {
        final int readSmallUint;
        final int readUshort;
        final int readUshort2;
        if (this.is64bit) {
            readSmallUint = readLongAsSmallUint(40);
            readUshort = readUshort(58);
            readUshort2 = readUshort(60);
        } else {
            readSmallUint = readSmallUint(32);
            readUshort = readUshort(46);
            readUshort2 = readUshort(48);
        }
        if ((readUshort * readUshort2) + readSmallUint <= this.buf.length) {
            return new AbstractList<SectionHeader>() { // from class: org.jf.dexlib2.dexbacked.OatFile.3
                @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
                public int size() {
                    return readUshort2;
                }

                @Override // java.util.AbstractList, java.util.List
                public SectionHeader get(int i3) {
                    if (i3 >= 0 && i3 < readUshort2) {
                        if (OatFile.this.is64bit) {
                            return new SectionHeader64Bit(readSmallUint + (i3 * readUshort));
                        }
                        return new SectionHeader32Bit(readSmallUint + (i3 * readUshort));
                    }
                    throw new IndexOutOfBoundsException();
                }
            };
        }
        throw new InvalidOatFileException("The ELF section headers extend past the end of the file");
    }

    @Nonnull
    private SymbolTable getSymbolTable() {
        for (SectionHeader sectionHeader : getSections()) {
            if (sectionHeader.getType() == 11) {
                return new SymbolTable(sectionHeader);
            }
        }
        throw new InvalidOatFileException("Oat file has no symbol table");
    }

    private static void verifyMagic(byte[] bArr) {
        int i3 = 0;
        while (true) {
            byte[] bArr2 = ELF_MAGIC;
            if (i3 < bArr2.length) {
                if (bArr[i3] == bArr2[i3]) {
                    i3++;
                } else {
                    throw new NotAnOatFileException();
                }
            } else {
                return;
            }
        }
    }

    @Nonnull
    public List<String> getBootClassPath() {
        if (getOatVersion() < 75) {
            return ImmutableList.of();
        }
        String keyValue = this.oatHeader.getKeyValue("bootclasspath");
        if (keyValue == null) {
            return ImmutableList.of();
        }
        return Arrays.asList(keyValue.split(":"));
    }

    @Override // org.jf.dexlib2.iface.MultiDexContainer
    @Nonnull
    public List<String> getDexEntryNames() throws IOException {
        return new AbstractForwardSequentialList<String>() { // from class: org.jf.dexlib2.dexbacked.OatFile.2
            @Override // org.jf.util.AbstractForwardSequentialList, java.util.AbstractSequentialList, java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.List
            @Nonnull
            public Iterator<String> iterator() {
                return r.x(r.l(new DexEntryIterator(), new k() { // from class: org.jf.dexlib2.dexbacked.d
                    @Override // com.google.common.base.k
                    public final boolean apply(Object obj) {
                        return com.tencent.qqlive.tvkplayer.thirdparties.dnsjava.lookup.k.a((OatFile.OatDexEntry) obj);
                    }
                }), new com.google.common.base.d<OatDexEntry, String>() { // from class: org.jf.dexlib2.dexbacked.OatFile.2.1
                    @Override // com.google.common.base.d
                    @Nullable
                    public String apply(OatDexEntry oatDexEntry) {
                        return oatDexEntry.entryName;
                    }
                });
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
            public int size() {
                return r.v(r.l(new DexEntryIterator(), new k() { // from class: org.jf.dexlib2.dexbacked.c
                    @Override // com.google.common.base.k
                    public final boolean apply(Object obj) {
                        return com.tencent.qqlive.tvkplayer.thirdparties.dnsjava.lookup.k.a((OatFile.OatDexEntry) obj);
                    }
                }));
            }
        };
    }

    @Nonnull
    public List<DexBackedDexFile> getDexFiles() {
        return new AbstractForwardSequentialList<DexBackedDexFile>() { // from class: org.jf.dexlib2.dexbacked.OatFile.1
            @Override // org.jf.util.AbstractForwardSequentialList, java.util.AbstractSequentialList, java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.List
            @Nonnull
            public Iterator<DexBackedDexFile> iterator() {
                return r.x(r.l(new DexEntryIterator(), new k() { // from class: org.jf.dexlib2.dexbacked.b
                    @Override // com.google.common.base.k
                    public final boolean apply(Object obj) {
                        return com.tencent.qqlive.tvkplayer.thirdparties.dnsjava.lookup.k.a((OatFile.OatDexEntry) obj);
                    }
                }), new com.google.common.base.d<OatDexEntry, DexBackedDexFile>() { // from class: org.jf.dexlib2.dexbacked.OatFile.1.1
                    @Override // com.google.common.base.d
                    @Nullable
                    public DexBackedDexFile apply(OatDexEntry oatDexEntry) {
                        return oatDexEntry.getDexFile();
                    }
                });
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
            public int size() {
                return r.v(r.l(new DexEntryIterator(), new k() { // from class: org.jf.dexlib2.dexbacked.a
                    @Override // com.google.common.base.k
                    public final boolean apply(Object obj) {
                        return com.tencent.qqlive.tvkplayer.thirdparties.dnsjava.lookup.k.a((OatFile.OatDexEntry) obj);
                    }
                }));
            }
        };
    }

    public int getOatVersion() {
        return this.oatHeader.getVersion();
    }

    public int isSupportedVersion() {
        int oatVersion = getOatVersion();
        if (oatVersion < 56) {
            return 0;
        }
        if (oatVersion <= 178) {
            return 1;
        }
        return 2;
    }

    public OatFile(@Nonnull byte[] bArr, @Nullable VdexProvider vdexProvider) {
        super(bArr);
        OatHeader oatHeader;
        if (bArr.length >= 52) {
            verifyMagic(bArr);
            byte b16 = bArr[4];
            if (b16 == 1) {
                this.is64bit = false;
            } else if (b16 == 2) {
                this.is64bit = true;
            } else {
                throw new InvalidOatFileException(String.format("Invalid word-size value: %x", Byte.valueOf(bArr[5])));
            }
            Iterator<SymbolTable.Symbol> it = getSymbolTable().getSymbols().iterator();
            while (true) {
                if (!it.hasNext()) {
                    oatHeader = null;
                    break;
                }
                SymbolTable.Symbol next = it.next();
                if (next.getName().equals("oatdata")) {
                    oatHeader = new OatHeader(next.getFileOffset());
                    break;
                }
            }
            if (oatHeader != null) {
                this.oatHeader = oatHeader;
                if (oatHeader.isValid()) {
                    this.opcodes = Opcodes.forArtVersion(oatHeader.getVersion());
                    this.vdexProvider = vdexProvider;
                    return;
                }
                throw new InvalidOatFileException("Invalid oat magic value");
            }
            throw new InvalidOatFileException("Oat file has no oatdata symbol");
        }
        throw new NotAnOatFileException();
    }

    /* JADX WARN: Finally extract failed */
    public static OatFile fromInputStream(@Nonnull InputStream inputStream, @Nullable VdexProvider vdexProvider) throws IOException {
        if (inputStream.markSupported()) {
            inputStream.mark(4);
            byte[] bArr = new byte[4];
            try {
                try {
                    q1.b.e(inputStream, bArr);
                    inputStream.reset();
                    verifyMagic(bArr);
                    inputStream.reset();
                    return new OatFile(q1.b.j(inputStream), vdexProvider);
                } catch (EOFException unused) {
                    throw new NotAnOatFileException();
                }
            } catch (Throwable th5) {
                inputStream.reset();
                throw th5;
            }
        }
        throw new IllegalArgumentException("InputStream must support mark");
    }

    @Override // org.jf.dexlib2.iface.MultiDexContainer
    @Nullable
    public MultiDexContainer.DexEntry<DexBackedDexFile> getEntry(@Nonnull String str) throws IOException {
        DexEntryIterator dexEntryIterator = new DexEntryIterator();
        while (dexEntryIterator.hasNext()) {
            OatDexEntry next = dexEntryIterator.next();
            if (next != null && next.getEntryName().equals(str)) {
                return next;
            }
        }
        return null;
    }
}

package org.jf.dexlib2;

import com.google.common.base.e;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Lists;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import org.jf.dexlib2.dexbacked.DexBackedDexFile;
import org.jf.dexlib2.dexbacked.DexBackedOdexFile;
import org.jf.dexlib2.dexbacked.OatFile;
import org.jf.dexlib2.dexbacked.ZipDexContainer;
import org.jf.dexlib2.iface.DexFile;
import org.jf.dexlib2.iface.MultiDexContainer;
import org.jf.dexlib2.writer.pool.DexPool;
import org.jf.util.ExceptionWithContext;
import q1.g;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class DexFileFactory {

    /* JADX INFO: Access modifiers changed from: protected */
    /* compiled from: P */
    /* loaded from: classes29.dex */
    public static class DexEntryFinder {
        static final /* synthetic */ boolean $assertionsDisabled = false;
        private final MultiDexContainer<? extends DexBackedDexFile> dexContainer;
        private final String filename;

        public DexEntryFinder(@Nonnull String str, @Nonnull MultiDexContainer<? extends DexBackedDexFile> multiDexContainer) {
            this.filename = str;
            this.dexContainer = multiDexContainer;
        }

        @Nonnull
        public MultiDexContainer.DexEntry<? extends DexBackedDexFile> findEntry(@Nonnull String str, boolean z16) throws IOException {
            if (z16) {
                try {
                    MultiDexContainer.DexEntry<? extends DexBackedDexFile> entry = this.dexContainer.getEntry(str);
                    if (entry != null) {
                        return entry;
                    }
                    throw new DexFileNotFoundException("Could not find entry %s in %s.", str, this.filename);
                } catch (DexBackedDexFile.NotADexFile unused) {
                    throw new UnsupportedFileTypeException("Entry %s in %s is not a dex file", str, this.filename);
                }
            }
            ArrayList h16 = Lists.h();
            ArrayList h17 = Lists.h();
            ArrayList h18 = Lists.h();
            ArrayList h19 = Lists.h();
            for (String str2 : this.dexContainer.getDexEntryNames()) {
                if (DexFileFactory.fullEntryMatch(str2, str)) {
                    h16.add(str2);
                    h17.add(this.dexContainer.getEntry(str2));
                } else if (DexFileFactory.partialEntryMatch(str2, str)) {
                    h18.add(str2);
                    h19.add(this.dexContainer.getEntry(str2));
                }
            }
            if (h17.size() == 1) {
                try {
                    return (MultiDexContainer.DexEntry) h17.get(0);
                } catch (DexBackedDexFile.NotADexFile unused2) {
                    throw new UnsupportedFileTypeException("Entry %s in %s is not a dex file", h16.get(0), this.filename);
                }
            }
            if (h17.size() <= 1) {
                if (h19.size() != 0) {
                    if (h19.size() <= 1) {
                        return (MultiDexContainer.DexEntry) h19.get(0);
                    }
                    throw new MultipleMatchingDexEntriesException(String.format("Multiple dex entries in %s match %s: %s", this.filename, str, e.h(", ").d(h18)), new Object[0]);
                }
                throw new DexFileNotFoundException("Could not find a dex entry in %s matching %s", this.filename, str);
            }
            throw new MultipleMatchingDexEntriesException(String.format("Multiple entries in %s match %s: %s", this.filename, str, e.h(", ").d(h16)), new Object[0]);
        }
    }

    /* compiled from: P */
    /* loaded from: classes29.dex */
    public static class DexFileNotFoundException extends ExceptionWithContext {
        public DexFileNotFoundException(@Nullable String str, Object... objArr) {
            super(str, objArr);
        }

        public DexFileNotFoundException(Throwable th5, @Nullable String str, Object... objArr) {
            super(th5, str, objArr);
        }
    }

    /* compiled from: P */
    /* loaded from: classes29.dex */
    public static class FilenameVdexProvider implements OatFile.VdexProvider {

        @Nullable
        private byte[] buf = null;
        private boolean loadedVdex = false;
        private final File vdexFile;

        public FilenameVdexProvider(File file) {
            this.vdexFile = new File(file.getAbsoluteFile().getParentFile(), g.c(file.getAbsolutePath()) + ".vdex");
        }

        @Override // org.jf.dexlib2.dexbacked.OatFile.VdexProvider
        @Nullable
        public byte[] getVdex() {
            File parentFile;
            if (!this.loadedVdex) {
                File file = this.vdexFile;
                if (!file.exists() && (parentFile = file.getParentFile().getParentFile()) != null) {
                    file = new File(parentFile, this.vdexFile.getName());
                }
                if (file.exists()) {
                    try {
                        this.buf = q1.b.j(new FileInputStream(file));
                    } catch (FileNotFoundException unused) {
                        this.buf = null;
                    } catch (IOException e16) {
                        throw new RuntimeException(e16);
                    }
                }
                this.loadedVdex = true;
            }
            return this.buf;
        }
    }

    /* compiled from: P */
    /* loaded from: classes29.dex */
    public static class MultipleMatchingDexEntriesException extends ExceptionWithContext {
        public MultipleMatchingDexEntriesException(@Nonnull String str, Object... objArr) {
            super(String.format(str, objArr), new Object[0]);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes29.dex */
    public static class SingletonMultiDexContainer implements MultiDexContainer<DexBackedDexFile> {
        private final DexBackedDexFile dexFile;
        private final String entryName;

        public SingletonMultiDexContainer(@Nonnull String str, @Nonnull DexBackedDexFile dexBackedDexFile) {
            this.entryName = str;
            this.dexFile = dexBackedDexFile;
        }

        @Override // org.jf.dexlib2.iface.MultiDexContainer
        @Nonnull
        public List<String> getDexEntryNames() {
            return ImmutableList.of(this.entryName);
        }

        @Override // org.jf.dexlib2.iface.MultiDexContainer
        @Nullable
        public MultiDexContainer.DexEntry<DexBackedDexFile> getEntry(@Nonnull final String str) {
            if (str.equals(this.entryName)) {
                return new MultiDexContainer.DexEntry<DexBackedDexFile>() { // from class: org.jf.dexlib2.DexFileFactory.SingletonMultiDexContainer.1
                    @Override // org.jf.dexlib2.iface.MultiDexContainer.DexEntry
                    @Nonnull
                    public MultiDexContainer<? extends DexBackedDexFile> getContainer() {
                        return SingletonMultiDexContainer.this;
                    }

                    @Override // org.jf.dexlib2.iface.MultiDexContainer.DexEntry
                    @Nonnull
                    public String getEntryName() {
                        return str;
                    }

                    /* JADX WARN: Can't rename method to resolve collision */
                    @Override // org.jf.dexlib2.iface.MultiDexContainer.DexEntry
                    @Nonnull
                    public DexBackedDexFile getDexFile() {
                        return SingletonMultiDexContainer.this.dexFile;
                    }
                };
            }
            return null;
        }
    }

    /* compiled from: P */
    /* loaded from: classes29.dex */
    public static class UnsupportedFileTypeException extends ExceptionWithContext {
        public UnsupportedFileTypeException(@Nonnull String str, Object... objArr) {
            super(String.format(str, objArr), new Object[0]);
        }
    }

    /* compiled from: P */
    /* loaded from: classes29.dex */
    public static class UnsupportedOatVersionException extends ExceptionWithContext {

        @Nonnull
        public final OatFile oatFile;

        public UnsupportedOatVersionException(@Nonnull OatFile oatFile) {
            super("Unsupported oat version: %d", Integer.valueOf(oatFile.getOatVersion()));
            this.oatFile = oatFile;
        }
    }

    DexFileFactory() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean fullEntryMatch(@Nonnull String str, @Nonnull String str2) {
        if (str.equals(str2)) {
            return true;
        }
        if (str.charAt(0) == '/') {
            str = str.substring(1);
        }
        if (str2.charAt(0) == '/') {
            str2 = str2.substring(1);
        }
        return str.equals(str2);
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x004f A[Catch: all -> 0x002f, TRY_ENTER, TRY_LEAVE, TryCatch #3 {all -> 0x002f, blocks: (B:9:0x001e, B:13:0x0031, B:17:0x0042, B:19:0x004f, B:23:0x0059, B:24:0x005e), top: B:8:0x001e }] */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0063  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static MultiDexContainer<? extends DexBackedDexFile> loadDexContainer(@Nonnull File file, @Nullable Opcodes opcodes) throws IOException {
        OatFile oatFile;
        if (file.exists()) {
            ZipDexContainer zipDexContainer = new ZipDexContainer(file, opcodes);
            if (zipDexContainer.isZipFile()) {
                return zipDexContainer;
            }
            BufferedInputStream bufferedInputStream = new BufferedInputStream(new FileInputStream(file));
            try {
                try {
                    try {
                        try {
                            return new SingletonMultiDexContainer(file.getPath(), DexBackedDexFile.fromInputStream(opcodes, bufferedInputStream));
                        } finally {
                            bufferedInputStream.close();
                        }
                    } catch (OatFile.NotAnOatFileException unused) {
                        oatFile = null;
                        if (oatFile == null) {
                        }
                    }
                } catch (DexBackedOdexFile.NotAnOdexFile unused2) {
                    oatFile = OatFile.fromInputStream(bufferedInputStream, new FilenameVdexProvider(file));
                    if (oatFile == null) {
                        if (oatFile.isSupportedVersion() != 0) {
                            return oatFile;
                        }
                        throw new UnsupportedOatVersionException(oatFile);
                    }
                    bufferedInputStream.close();
                    throw new UnsupportedFileTypeException("%s is not an apk, dex, odex or oat file.", file.getPath());
                }
            } catch (DexBackedDexFile.NotADexFile unused3) {
                return new SingletonMultiDexContainer(file.getPath(), DexBackedOdexFile.fromInputStream(opcodes, (InputStream) bufferedInputStream));
            }
        } else {
            throw new DexFileNotFoundException("%s does not exist", file.getName());
        }
    }

    public static MultiDexContainer.DexEntry<? extends DexBackedDexFile> loadDexEntry(@Nonnull File file, @Nonnull String str, boolean z16, @Nullable Opcodes opcodes) throws IOException {
        OatFile oatFile;
        if (file.exists()) {
            try {
                return new DexEntryFinder(file.getPath(), new ZipDexContainer(file, opcodes)).findEntry(str, z16);
            } catch (ZipDexContainer.NotAZipFileException unused) {
                BufferedInputStream bufferedInputStream = new BufferedInputStream(new FileInputStream(file));
                try {
                    try {
                        oatFile = OatFile.fromInputStream(bufferedInputStream, new FilenameVdexProvider(file));
                    } finally {
                        bufferedInputStream.close();
                    }
                } catch (OatFile.NotAnOatFileException unused2) {
                    oatFile = null;
                }
                if (oatFile != null) {
                    if (oatFile.isSupportedVersion() != 0) {
                        if (oatFile.getDexFiles().size() != 0) {
                            return new DexEntryFinder(file.getPath(), oatFile).findEntry(str, z16);
                        }
                        throw new DexFileNotFoundException("Oat file %s contains no dex files", file.getName());
                    }
                    throw new UnsupportedOatVersionException(oatFile);
                }
                bufferedInputStream.close();
                throw new UnsupportedFileTypeException("%s is not an apk or oat file.", file.getPath());
            }
        }
        throw new DexFileNotFoundException("Container file %s does not exist", file.getName());
    }

    @Nonnull
    public static DexBackedDexFile loadDexFile(@Nonnull String str, @Nullable Opcodes opcodes) throws IOException {
        return loadDexFile(new File(str), opcodes);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean partialEntryMatch(String str, String str2) {
        if (str.equals(str2)) {
            return true;
        }
        if (!str.endsWith(str2)) {
            return false;
        }
        char charAt = str.charAt((str.length() - str2.length()) - 1);
        char charAt2 = str2.charAt(0);
        if (charAt2 == ':' || charAt2 == '/' || charAt2 == '!' || charAt == ':' || charAt == '/' || charAt == '!') {
            return true;
        }
        return false;
    }

    public static void writeDexFile(@Nonnull String str, @Nonnull DexFile dexFile) throws IOException {
        DexPool.writeTo(str, dexFile);
    }

    /* JADX WARN: Removed duplicated region for block: B:23:0x004d A[Catch: all -> 0x0036, TRY_ENTER, TryCatch #2 {all -> 0x0036, blocks: (B:13:0x002e, B:17:0x0038, B:21:0x0040, B:23:0x004d, B:25:0x0053, B:27:0x005d, B:30:0x0067, B:31:0x0077, B:32:0x0078, B:33:0x007d), top: B:11:0x002e }] */
    /* JADX WARN: Removed duplicated region for block: B:34:0x0082  */
    @Nonnull
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static DexBackedDexFile loadDexFile(@Nonnull File file, @Nullable Opcodes opcodes) throws IOException {
        OatFile oatFile;
        if (file.exists()) {
            try {
                return new DexEntryFinder(file.getPath(), new ZipDexContainer(file, opcodes)).findEntry("classes.dex", true).getDexFile();
            } catch (ZipDexContainer.NotAZipFileException unused) {
                BufferedInputStream bufferedInputStream = new BufferedInputStream(new FileInputStream(file));
                try {
                    try {
                        try {
                            try {
                                return DexBackedDexFile.fromInputStream(opcodes, bufferedInputStream);
                            } catch (DexBackedOdexFile.NotAnOdexFile unused2) {
                                oatFile = OatFile.fromInputStream(bufferedInputStream, new FilenameVdexProvider(file));
                                if (oatFile == null) {
                                }
                            }
                        } catch (OatFile.NotAnOatFileException unused3) {
                            oatFile = null;
                            if (oatFile == null) {
                                if (oatFile.isSupportedVersion() != 0) {
                                    List<DexBackedDexFile> dexFiles = oatFile.getDexFiles();
                                    if (dexFiles.size() != 0) {
                                        return dexFiles.get(0);
                                    }
                                    throw new DexFileNotFoundException("Oat file %s contains no dex files", file.getName());
                                }
                                throw new UnsupportedOatVersionException(oatFile);
                            }
                            bufferedInputStream.close();
                            throw new UnsupportedFileTypeException("%s is not an apk, dex, odex or oat file.", file.getPath());
                        }
                    } catch (DexBackedDexFile.NotADexFile unused4) {
                        return DexBackedOdexFile.fromInputStream(opcodes, (InputStream) bufferedInputStream);
                    }
                } finally {
                    bufferedInputStream.close();
                }
            }
        } else {
            throw new DexFileNotFoundException("%s does not exist", file.getName());
        }
    }
}

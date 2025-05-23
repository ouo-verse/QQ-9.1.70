package org.jf.dexlib2.dexbacked;

import com.google.common.collect.Lists;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import org.jf.dexlib2.Opcodes;
import org.jf.dexlib2.dexbacked.DexBackedDexFile;
import org.jf.dexlib2.iface.DexFile;
import org.jf.dexlib2.iface.MultiDexContainer;
import org.jf.dexlib2.util.DexUtil;

/* compiled from: P */
/* loaded from: classes29.dex */
public class ZipDexContainer implements MultiDexContainer<DexBackedDexFile> {

    @Nullable
    private final Opcodes opcodes;
    private final File zipFilePath;

    /* compiled from: P */
    /* loaded from: classes29.dex */
    public static class NotAZipFileException extends RuntimeException {
    }

    public ZipDexContainer(@Nonnull File file, @Nullable Opcodes opcodes) {
        this.zipFilePath = file;
        this.opcodes = opcodes;
    }

    @Override // org.jf.dexlib2.iface.MultiDexContainer
    @Nonnull
    public List<String> getDexEntryNames() throws IOException {
        ArrayList h16 = Lists.h();
        ZipFile zipFile = getZipFile();
        try {
            Enumeration<? extends ZipEntry> entries = zipFile.entries();
            while (entries.hasMoreElements()) {
                ZipEntry nextElement = entries.nextElement();
                if (isDex(zipFile, nextElement)) {
                    h16.add(nextElement.getName());
                }
            }
            return h16;
        } finally {
            zipFile.close();
        }
    }

    @Override // org.jf.dexlib2.iface.MultiDexContainer
    @Nullable
    public MultiDexContainer.DexEntry<DexBackedDexFile> getEntry(@Nonnull String str) throws IOException {
        ZipFile zipFile = getZipFile();
        try {
            ZipEntry entry = zipFile.getEntry(str);
            if (entry == null) {
                zipFile.close();
                return null;
            }
            return loadEntry(zipFile, entry);
        } finally {
            zipFile.close();
        }
    }

    protected ZipFile getZipFile() throws IOException {
        try {
            return new ZipFile(this.zipFilePath);
        } catch (IOException unused) {
            throw new NotAZipFileException();
        }
    }

    protected boolean isDex(@Nonnull ZipFile zipFile, @Nonnull ZipEntry zipEntry) throws IOException {
        BufferedInputStream bufferedInputStream = new BufferedInputStream(zipFile.getInputStream(zipEntry));
        try {
            DexUtil.verifyDexHeader(bufferedInputStream);
            bufferedInputStream.close();
            return true;
        } catch (DexBackedDexFile.NotADexFile unused) {
            bufferedInputStream.close();
            return false;
        } catch (DexUtil.InvalidFile unused2) {
            bufferedInputStream.close();
            return false;
        } catch (DexUtil.UnsupportedFile unused3) {
            bufferedInputStream.close();
            return false;
        } catch (Throwable th5) {
            bufferedInputStream.close();
            throw th5;
        }
    }

    public boolean isZipFile() {
        try {
            ZipFile zipFile = getZipFile();
            if (zipFile != null) {
                try {
                    zipFile.close();
                    return true;
                } catch (IOException unused) {
                    return true;
                }
            }
            return true;
        } catch (IOException | NotAZipFileException unused2) {
            return false;
        }
    }

    @Nonnull
    protected MultiDexContainer.DexEntry loadEntry(@Nonnull ZipFile zipFile, @Nonnull final ZipEntry zipEntry) throws IOException {
        InputStream inputStream = zipFile.getInputStream(zipEntry);
        try {
            final byte[] j3 = q1.b.j(inputStream);
            return new MultiDexContainer.DexEntry() { // from class: org.jf.dexlib2.dexbacked.ZipDexContainer.1
                @Override // org.jf.dexlib2.iface.MultiDexContainer.DexEntry
                @Nonnull
                public MultiDexContainer getContainer() {
                    return ZipDexContainer.this;
                }

                @Override // org.jf.dexlib2.iface.MultiDexContainer.DexEntry
                @Nonnull
                public DexFile getDexFile() {
                    return new DexBackedDexFile(ZipDexContainer.this.opcodes, j3);
                }

                @Override // org.jf.dexlib2.iface.MultiDexContainer.DexEntry
                @Nonnull
                public String getEntryName() {
                    return zipEntry.getName();
                }
            };
        } finally {
            inputStream.close();
        }
    }
}

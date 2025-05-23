package org.jf.dexlib2.analysis;

import com.google.common.base.e;
import com.google.common.base.l;
import com.google.common.collect.Lists;
import cooperation.qzone.patch.QZonePatchService;
import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import org.jf.dexlib2.DexFileFactory;
import org.jf.dexlib2.analysis.PathEntryLoader;
import org.jf.dexlib2.dexbacked.DexBackedOdexFile;
import org.jf.dexlib2.dexbacked.OatFile;
import org.jf.dexlib2.iface.MultiDexContainer;

/* loaded from: classes29.dex */
public class ClassPathResolver {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private final Iterable<String> classPathDirs;
    private final PathEntryLoader pathEntryLoader;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes29.dex */
    public static class NotFoundException extends Exception {
        public NotFoundException(String str, Object... objArr) {
            super(String.format(str, objArr));
        }
    }

    /* loaded from: classes29.dex */
    public static class ResolveException extends RuntimeException {
        public ResolveException(String str, Object... objArr) {
            super(String.format(str, objArr));
        }

        public ResolveException(Throwable th5) {
            super(th5);
        }

        public ResolveException(Throwable th5, String str, Object... objArr) {
            super(String.format(str, objArr), th5);
        }
    }

    /* JADX WARN: Type inference failed for: r12v5, types: [org.jf.dexlib2.iface.DexFile] */
    /* JADX WARN: Type inference failed for: r3v0, types: [org.jf.dexlib2.iface.DexFile] */
    /* JADX WARN: Type inference failed for: r4v0, types: [org.jf.dexlib2.iface.DexFile] */
    public ClassPathResolver(@Nonnull List<String> list, @Nullable List<String> list2, @Nonnull List<String> list3, @Nonnull MultiDexContainer.DexEntry<?> dexEntry) throws IOException {
        ?? dexFile = dexEntry.getDexFile();
        this.classPathDirs = list;
        this.pathEntryLoader = new PathEntryLoader(dexEntry.getDexFile().getOpcodes());
        for (String str : list2 == null ? getDefaultBootClassPath(dexEntry, dexFile.getOpcodes().api) : list2) {
            try {
                loadLocalOrDeviceBootClassPathEntry(str);
            } catch (NotFoundException e16) {
                if (str.endsWith(".odex")) {
                    String str2 = str.substring(0, str.length() - 5) + QZonePatchService.PATCH_SUFFIX;
                    try {
                        loadLocalOrDeviceBootClassPathEntry(str2);
                    } catch (NotFoundException unused) {
                        throw new ResolveException(e16);
                    } catch (PathEntryLoader.NoDexException unused2) {
                        throw new ResolveException("Neither %s nor %s contain a dex file", str, str2);
                    }
                } else {
                    throw new ResolveException(e16);
                }
            } catch (PathEntryLoader.NoDexException e17) {
                if (str.endsWith(QZonePatchService.PATCH_SUFFIX)) {
                    String str3 = str.substring(0, str.length() - 4) + ".odex";
                    try {
                        loadLocalOrDeviceBootClassPathEntry(str3);
                    } catch (NotFoundException unused3) {
                        throw new ResolveException(e17);
                    } catch (PathEntryLoader.NoDexException unused4) {
                        throw new ResolveException("Neither %s nor %s contain a dex file", str, str3);
                    }
                } else {
                    throw new ResolveException(e17);
                }
            }
        }
        Iterator<String> it = list3.iterator();
        while (it.hasNext()) {
            try {
                loadLocalClassPathEntry(it.next());
            } catch (PathEntryLoader.NoDexException e18) {
                throw new ResolveException(e18);
            }
        }
        MultiDexContainer<? extends Object> container = dexEntry.getContainer();
        Iterator<String> it5 = container.getDexEntryNames().iterator();
        while (it5.hasNext()) {
            this.pathEntryLoader.getClassProviders().add(new DexClassProvider(container.getEntry(it5.next()).getDexFile()));
        }
    }

    private static List<String> bootClassPathForOat(@Nonnull OatFile oatFile) {
        List<String> bootClassPath = oatFile.getBootClassPath();
        if (bootClassPath.isEmpty()) {
            return Lists.k("boot.oat");
        }
        return replaceElementsSuffix(bootClassPath, ".art", ".oat");
    }

    @Nonnull
    private static List<String> getDefaultBootClassPath(@Nonnull MultiDexContainer.DexEntry<?> dexEntry, int i3) {
        MultiDexContainer<? extends Object> container = dexEntry.getContainer();
        if (container instanceof OatFile) {
            return bootClassPathForOat((OatFile) container);
        }
        Object dexFile = dexEntry.getDexFile();
        if (dexFile instanceof DexBackedOdexFile) {
            return ((DexBackedOdexFile) dexFile).getDependencies();
        }
        if (i3 <= 8) {
            return Lists.k("/system/framework/core.jar", "/system/framework/ext.jar", "/system/framework/framework.jar", "/system/framework/android.policy.jar", "/system/framework/services.jar");
        }
        if (i3 <= 11) {
            return Lists.k("/system/framework/core.jar", "/system/framework/bouncycastle.jar", "/system/framework/ext.jar", "/system/framework/framework.jar", "/system/framework/android.policy.jar", "/system/framework/services.jar", "/system/framework/core-junit.jar");
        }
        if (i3 <= 13) {
            return Lists.k("/system/framework/core.jar", "/system/framework/apache-xml.jar", "/system/framework/bouncycastle.jar", "/system/framework/ext.jar", "/system/framework/framework.jar", "/system/framework/android.policy.jar", "/system/framework/services.jar", "/system/framework/core-junit.jar");
        }
        if (i3 <= 15) {
            return Lists.k("/system/framework/core.jar", "/system/framework/core-junit.jar", "/system/framework/bouncycastle.jar", "/system/framework/ext.jar", "/system/framework/framework.jar", "/system/framework/android.policy.jar", "/system/framework/services.jar", "/system/framework/apache-xml.jar", "/system/framework/filterfw.jar");
        }
        if (i3 <= 17) {
            return Lists.k("/system/framework/core.jar", "/system/framework/core-junit.jar", "/system/framework/bouncycastle.jar", "/system/framework/ext.jar", "/system/framework/framework.jar", "/system/framework/telephony-common.jar", "/system/framework/mms-common.jar", "/system/framework/android.policy.jar", "/system/framework/services.jar", "/system/framework/apache-xml.jar");
        }
        if (i3 <= 18) {
            return Lists.k("/system/framework/core.jar", "/system/framework/core-junit.jar", "/system/framework/bouncycastle.jar", "/system/framework/ext.jar", "/system/framework/framework.jar", "/system/framework/telephony-common.jar", "/system/framework/voip-common.jar", "/system/framework/mms-common.jar", "/system/framework/android.policy.jar", "/system/framework/services.jar", "/system/framework/apache-xml.jar");
        }
        if (i3 <= 19) {
            return Lists.k("/system/framework/core.jar", "/system/framework/conscrypt.jar", "/system/framework/core-junit.jar", "/system/framework/bouncycastle.jar", "/system/framework/ext.jar", "/system/framework/framework.jar", "/system/framework/framework2.jar", "/system/framework/telephony-common.jar", "/system/framework/voip-common.jar", "/system/framework/mms-common.jar", "/system/framework/android.policy.jar", "/system/framework/services.jar", "/system/framework/apache-xml.jar", "/system/framework/webviewchromium.jar");
        }
        if (i3 <= 22) {
            return Lists.k("/system/framework/core-libart.jar", "/system/framework/conscrypt.jar", "/system/framework/okhttp.jar", "/system/framework/core-junit.jar", "/system/framework/bouncycastle.jar", "/system/framework/ext.jar", "/system/framework/framework.jar", "/system/framework/telephony-common.jar", "/system/framework/voip-common.jar", "/system/framework/ims-common.jar", "/system/framework/mms-common.jar", "/system/framework/android.policy.jar", "/system/framework/apache-xml.jar");
        }
        if (i3 <= 23) {
            return Lists.k("/system/framework/core-libart.jar", "/system/framework/conscrypt.jar", "/system/framework/okhttp.jar", "/system/framework/core-junit.jar", "/system/framework/bouncycastle.jar", "/system/framework/ext.jar", "/system/framework/framework.jar", "/system/framework/telephony-common.jar", "/system/framework/voip-common.jar", "/system/framework/ims-common.jar", "/system/framework/apache-xml.jar", "/system/framework/org.apache.http.legacy.boot.jar");
        }
        return Lists.k("/system/framework/core-oj.jar", "/system/framework/core-libart.jar", "/system/framework/conscrypt.jar", "/system/framework/okhttp.jar", "/system/framework/core-junit.jar", "/system/framework/bouncycastle.jar", "/system/framework/ext.jar", "/system/framework/framework.jar", "/system/framework/telephony-common.jar", "/system/framework/voip-common.jar", "/system/framework/ims-common.jar", "/system/framework/apache-xml.jar", "/system/framework/org.apache.http.legacy.boot.jar");
    }

    private boolean loadLocalClassPathEntry(@Nonnull String str) throws PathEntryLoader.NoDexException, IOException {
        File file = new File(str);
        if (!file.exists() || !file.isFile()) {
            return false;
        }
        try {
            this.pathEntryLoader.loadEntry(file, true);
            return true;
        } catch (DexFileFactory.UnsupportedFileTypeException e16) {
            throw new ResolveException(e16, "Couldn't load classpath entry %s", str);
        }
    }

    private void loadLocalOrDeviceBootClassPathEntry(@Nonnull String str) throws IOException, PathEntryLoader.NoDexException, NotFoundException {
        if (loadLocalClassPathEntry(str)) {
            return;
        }
        List<String> splitDevicePath = splitDevicePath(str);
        e g16 = e.g(File.separatorChar);
        Iterator<String> it = this.classPathDirs.iterator();
        while (true) {
            if (it.hasNext()) {
                File file = new File(it.next());
                if (file.exists()) {
                    for (int i3 = 0; i3 < splitDevicePath.size(); i3++) {
                        File file2 = new File(file, g16.d(splitDevicePath.subList(i3, splitDevicePath.size())));
                        if (file2.exists() && file2.isFile()) {
                            this.pathEntryLoader.loadEntry(file2, true);
                            return;
                        }
                    }
                }
            } else {
                throw new NotFoundException("Could not find classpath entry %s", str);
            }
        }
    }

    private static List<String> replaceElementsSuffix(List<String> list, String str, String str2) {
        for (int i3 = 0; i3 < list.size(); i3++) {
            String str3 = list.get(i3);
            if (str3.endsWith(str)) {
                list.set(i3, str3.substring(0, str3.length() - str.length()) + str2);
            }
        }
        return list;
    }

    @Nonnull
    private static List<String> splitDevicePath(@Nonnull String str) {
        return Lists.i(l.e('/').g(str));
    }

    @Nonnull
    public List<ClassProvider> getResolvedClassProviders() {
        return this.pathEntryLoader.getResolvedClassProviders();
    }

    public ClassPathResolver(@Nonnull List<String> list, @Nonnull List<String> list2, @Nonnull MultiDexContainer.DexEntry<?> dexEntry) throws IOException {
        this(list, null, list2, dexEntry);
    }
}

package org.jf.dexlib2.analysis;

import com.google.common.collect.Lists;
import com.google.common.collect.ab;
import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import javax.annotation.Nonnull;
import org.jf.dexlib2.DexFileFactory;
import org.jf.dexlib2.Opcodes;
import org.jf.dexlib2.analysis.ClassPathResolver;
import org.jf.dexlib2.dexbacked.DexBackedDexFile;
import org.jf.dexlib2.dexbacked.OatFile;
import org.jf.dexlib2.iface.MultiDexContainer;

/* loaded from: classes29.dex */
public class PathEntryLoader {
    Opcodes opcodes;
    final Set<File> loadedFiles = ab.d();
    final List<ClassProvider> classProviders = Lists.h();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes29.dex */
    public static class NoDexException extends Exception {
        public NoDexException(String str, Object... objArr) {
            super(String.format(str, objArr));
        }
    }

    public PathEntryLoader(Opcodes opcodes) {
        this.opcodes = opcodes;
    }

    @Nonnull
    private String getFilenameForOatDependency(String str) {
        String substring = str.substring(str.lastIndexOf(47) + 1);
        if (substring.endsWith(".art")) {
            return substring.substring(0, substring.length() - 4) + ".oat";
        }
        return substring;
    }

    private void loadOatDependencies(@Nonnull File file, @Nonnull List<String> list) throws IOException, NoDexException, ClassPathResolver.NotFoundException {
        Iterator<String> it = list.iterator();
        while (it.hasNext()) {
            String filenameForOatDependency = getFilenameForOatDependency(it.next());
            File file2 = new File(file, filenameForOatDependency);
            if (file2.exists()) {
                loadEntry(file2, false);
            } else {
                throw new ClassPathResolver.NotFoundException("Cannot find dependency %s in %s", filenameForOatDependency, file);
            }
        }
    }

    public List<ClassProvider> getClassProviders() {
        return this.classProviders;
    }

    public Opcodes getOpcodes() {
        return this.opcodes;
    }

    @Nonnull
    public List<ClassProvider> getResolvedClassProviders() {
        return this.classProviders;
    }

    public void loadEntry(@Nonnull File file, boolean z16) throws IOException, NoDexException {
        if (this.loadedFiles.contains(file)) {
            return;
        }
        try {
            MultiDexContainer<? extends DexBackedDexFile> loadDexContainer = DexFileFactory.loadDexContainer(file, this.opcodes);
            List<String> dexEntryNames = loadDexContainer.getDexEntryNames();
            if (!dexEntryNames.isEmpty()) {
                this.loadedFiles.add(file);
                Iterator<String> it = dexEntryNames.iterator();
                while (it.hasNext()) {
                    this.classProviders.add(new DexClassProvider(loadDexContainer.getEntry(it.next()).getDexFile()));
                }
                if (z16 && (loadDexContainer instanceof OatFile)) {
                    List<String> bootClassPath = ((OatFile) loadDexContainer).getBootClassPath();
                    if (!bootClassPath.isEmpty()) {
                        try {
                            loadOatDependencies(file.getParentFile(), bootClassPath);
                            return;
                        } catch (ClassPathResolver.NotFoundException e16) {
                            throw new ClassPathResolver.ResolveException(e16, "Error while loading oat file %s", file);
                        } catch (NoDexException e17) {
                            throw new ClassPathResolver.ResolveException(e17, "Error while loading dependencies for oat file %s", file);
                        }
                    }
                    return;
                }
                return;
            }
            throw new NoDexException("%s contains no dex file", file);
        } catch (DexFileFactory.UnsupportedFileTypeException e18) {
            throw new ClassPathResolver.ResolveException(e18);
        }
    }
}

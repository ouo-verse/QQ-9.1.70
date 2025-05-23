package org.light.internal.relinker;

import android.content.Context;
import android.util.Log;
import com.tencent.thread.monitor.plugin.proxy.BaseThread;
import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Set;
import org.light.internal.relinker.ReLinker;
import org.light.internal.relinker.elf.ElfParser;

/* compiled from: P */
/* loaded from: classes29.dex */
public class ReLinkerInstance {
    private static final String LIB_DIR = "lib";
    protected boolean force;
    protected final ReLinker.LibraryInstaller libraryInstaller;
    protected final ReLinker.LibraryLoader libraryLoader;
    protected final Set<String> loadedLibraries;
    protected ReLinker.Logger logger;
    protected boolean recursive;

    /* JADX INFO: Access modifiers changed from: protected */
    public ReLinkerInstance() {
        this(new SystemLibraryLoader(), new ApkLibraryInstaller());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void loadLibraryInternal(Context context, String str, String str2) {
        ElfParser elfParser;
        if (this.loadedLibraries.contains(str) && !this.force) {
            log("%s already loaded previously!", str);
            return;
        }
        try {
            this.libraryLoader.loadLibrary(str);
            this.loadedLibraries.add(str);
            log("%s (%s) was loaded normally!", str, str2);
        } catch (UnsatisfiedLinkError e16) {
            log("Loading the library normally failed: %s", Log.getStackTraceString(e16));
            log("%s (%s) was not loaded normally, re-linking...", str, str2);
            File workaroundLibFile = getWorkaroundLibFile(context, str, str2);
            if (!workaroundLibFile.exists() || this.force) {
                if (this.force) {
                    log("Forcing a re-link of %s (%s)...", str, str2);
                }
                cleanupOldLibFiles(context, str, str2);
                this.libraryInstaller.installLibrary(context, this.libraryLoader.supportedAbis(), this.libraryLoader.mapLibraryName(str), workaroundLibFile, this);
            }
            try {
                if (this.recursive) {
                    ElfParser elfParser2 = null;
                    try {
                        elfParser = new ElfParser(workaroundLibFile);
                    } catch (Throwable th5) {
                        th = th5;
                    }
                    try {
                        List<String> parseNeededDependencies = elfParser.parseNeededDependencies();
                        elfParser.close();
                        Iterator<String> it = parseNeededDependencies.iterator();
                        while (it.hasNext()) {
                            loadLibrary(context, this.libraryLoader.unmapLibraryName(it.next()));
                        }
                    } catch (Throwable th6) {
                        th = th6;
                        elfParser2 = elfParser;
                        elfParser2.close();
                        throw th;
                    }
                }
            } catch (IOException unused) {
            }
            this.libraryLoader.loadPath(workaroundLibFile.getAbsolutePath());
            this.loadedLibraries.add(str);
            log("%s (%s) was re-linked!", str, str2);
        }
    }

    protected void cleanupOldLibFiles(Context context, String str, String str2) {
        File workaroundLibDir = getWorkaroundLibDir(context);
        File workaroundLibFile = getWorkaroundLibFile(context, str, str2);
        final String mapLibraryName = this.libraryLoader.mapLibraryName(str);
        File[] listFiles = workaroundLibDir.listFiles(new FilenameFilter() { // from class: org.light.internal.relinker.ReLinkerInstance.2
            @Override // java.io.FilenameFilter
            public boolean accept(File file, String str3) {
                return str3.startsWith(mapLibraryName);
            }
        });
        if (listFiles == null) {
            return;
        }
        for (File file : listFiles) {
            if (this.force || !file.getAbsolutePath().equals(workaroundLibFile.getAbsolutePath())) {
                try {
                    file.delete();
                } catch (SecurityException e16) {
                    e16.printStackTrace();
                }
            }
        }
    }

    public ReLinkerInstance force() {
        this.force = true;
        return this;
    }

    protected File getWorkaroundLibDir(Context context) {
        return context.getDir("lib", 0);
    }

    protected File getWorkaroundLibFile(Context context, String str, String str2) {
        String mapLibraryName = this.libraryLoader.mapLibraryName(str);
        if (TextUtils.isEmpty(str2)) {
            return new File(getWorkaroundLibDir(context), mapLibraryName);
        }
        return new File(getWorkaroundLibDir(context), mapLibraryName + "." + str2);
    }

    public void loadLibrary(Context context, String str) {
        loadLibrary(context, str, null, null);
    }

    public ReLinkerInstance log(ReLinker.Logger logger) {
        this.logger = logger;
        return this;
    }

    public ReLinkerInstance recursively() {
        this.recursive = true;
        return this;
    }

    protected ReLinkerInstance(ReLinker.LibraryLoader libraryLoader, ReLinker.LibraryInstaller libraryInstaller) {
        this.loadedLibraries = new HashSet();
        if (libraryLoader == null) {
            throw new IllegalArgumentException("Cannot pass null library loader");
        }
        if (libraryInstaller != null) {
            this.libraryLoader = libraryLoader;
            this.libraryInstaller = libraryInstaller;
            return;
        }
        throw new IllegalArgumentException("Cannot pass null library installer");
    }

    public void loadLibrary(Context context, String str, String str2) {
        loadLibrary(context, str, str2, null);
    }

    public void log(String str, Object... objArr) {
        log(String.format(Locale.US, str, objArr));
    }

    public void loadLibrary(Context context, String str, ReLinker.LoadListener loadListener) {
        loadLibrary(context, str, null, loadListener);
    }

    public void log(String str) {
        ReLinker.Logger logger = this.logger;
        if (logger != null) {
            logger.log(str);
        }
    }

    public void loadLibrary(final Context context, final String str, final String str2, final ReLinker.LoadListener loadListener) {
        if (context != null) {
            if (!TextUtils.isEmpty(str)) {
                log("Beginning load of %s...", str);
                if (loadListener == null) {
                    loadLibraryInternal(context, str, str2);
                    return;
                } else {
                    new BaseThread(new Runnable() { // from class: org.light.internal.relinker.ReLinkerInstance.1
                        @Override // java.lang.Runnable
                        public void run() {
                            try {
                                ReLinkerInstance.this.loadLibraryInternal(context, str, str2);
                                loadListener.success();
                            } catch (UnsatisfiedLinkError e16) {
                                loadListener.failure(e16);
                            } catch (MissingLibraryException e17) {
                                loadListener.failure(e17);
                            }
                        }
                    }).start();
                    return;
                }
            }
            throw new IllegalArgumentException("Given library is either null or empty");
        }
        throw new IllegalArgumentException("Given context is null");
    }
}

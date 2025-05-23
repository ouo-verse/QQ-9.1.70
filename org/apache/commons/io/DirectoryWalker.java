package org.apache.commons.io;

import java.io.File;
import java.io.FileFilter;
import java.io.IOException;
import java.util.Collection;
import org.apache.commons.io.filefilter.FileFilterUtils;
import org.apache.commons.io.filefilter.IOFileFilter;
import org.apache.commons.io.filefilter.TrueFileFilter;

/* compiled from: P */
/* loaded from: classes29.dex */
public abstract class DirectoryWalker<T> {
    private final int depthLimit;
    private final FileFilter filter;

    /* compiled from: P */
    /* loaded from: classes29.dex */
    public static class CancelException extends IOException {
        private static final long serialVersionUID = 1347339620135041008L;
        private final int depth;
        private final File file;

        public CancelException(File file, int i3) {
            this("Operation Cancelled", file, i3);
        }

        public int getDepth() {
            return this.depth;
        }

        public File getFile() {
            return this.file;
        }

        public CancelException(String str, File file, int i3) {
            super(str);
            this.file = file;
            this.depth = i3;
        }
    }

    protected DirectoryWalker() {
        this(null, -1);
    }

    protected final void checkIfCancelled(File file, int i3, Collection<T> collection) throws IOException {
        if (!handleIsCancelled(file, i3, collection)) {
        } else {
            throw new CancelException(file, i3);
        }
    }

    protected boolean handleDirectory(File file, int i3, Collection<T> collection) throws IOException {
        return true;
    }

    protected boolean handleIsCancelled(File file, int i3, Collection<T> collection) throws IOException {
        return false;
    }

    protected final void walk(File file, Collection<T> collection) throws IOException {
        if (file != null) {
            try {
                handleStart(file, collection);
                walk(file, 0, collection);
                handleEnd(collection);
                return;
            } catch (CancelException e16) {
                handleCancelled(file, collection, e16);
                return;
            }
        }
        throw new NullPointerException("Start Directory is null");
    }

    protected DirectoryWalker(FileFilter fileFilter, int i3) {
        this.filter = fileFilter;
        this.depthLimit = i3;
    }

    protected DirectoryWalker(IOFileFilter iOFileFilter, IOFileFilter iOFileFilter2, int i3) {
        if (iOFileFilter == null && iOFileFilter2 == null) {
            this.filter = null;
        } else {
            this.filter = FileFilterUtils.or(FileFilterUtils.makeDirectoryOnly(iOFileFilter == null ? TrueFileFilter.TRUE : iOFileFilter), FileFilterUtils.makeFileOnly(iOFileFilter2 == null ? TrueFileFilter.TRUE : iOFileFilter2));
        }
        this.depthLimit = i3;
    }

    private void walk(File file, int i3, Collection<T> collection) throws IOException {
        checkIfCancelled(file, i3, collection);
        if (handleDirectory(file, i3, collection)) {
            handleDirectoryStart(file, i3, collection);
            int i16 = i3 + 1;
            int i17 = this.depthLimit;
            if (i17 < 0 || i16 <= i17) {
                checkIfCancelled(file, i3, collection);
                FileFilter fileFilter = this.filter;
                File[] filterDirectoryContents = filterDirectoryContents(file, i3, fileFilter == null ? file.listFiles() : file.listFiles(fileFilter));
                if (filterDirectoryContents == null) {
                    handleRestricted(file, i16, collection);
                } else {
                    for (File file2 : filterDirectoryContents) {
                        if (file2.isDirectory()) {
                            walk(file2, i16, collection);
                        } else {
                            checkIfCancelled(file2, i16, collection);
                            handleFile(file2, i16, collection);
                            checkIfCancelled(file2, i16, collection);
                        }
                    }
                }
            }
            handleDirectoryEnd(file, i3, collection);
        }
        checkIfCancelled(file, i3, collection);
    }

    protected void handleEnd(Collection<T> collection) throws IOException {
    }

    protected void handleStart(File file, Collection<T> collection) throws IOException {
    }

    protected File[] filterDirectoryContents(File file, int i3, File[] fileArr) throws IOException {
        return fileArr;
    }

    protected void handleCancelled(File file, Collection<T> collection, CancelException cancelException) throws IOException {
        throw cancelException;
    }

    protected void handleDirectoryEnd(File file, int i3, Collection<T> collection) throws IOException {
    }

    protected void handleDirectoryStart(File file, int i3, Collection<T> collection) throws IOException {
    }

    protected void handleFile(File file, int i3, Collection<T> collection) throws IOException {
    }

    protected void handleRestricted(File file, int i3, Collection<T> collection) throws IOException {
    }
}

package com.tencent.mm.vfs;

import android.net.Uri;
import com.tencent.mm.vfs.FileSystem;
import com.tencent.mm.vfs.FileSystemManager;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

/* compiled from: P */
/* loaded from: classes9.dex */
public class VFSFile implements Comparable<VFSFile> {
    public static final String pathSeparator = ":";
    public static final char pathSeparatorChar = ':';
    public static final String separator = "/";
    public static final char separatorChar = '/';
    private FileSystemManager.Resolution mResolved;
    private final Uri mUri;

    public VFSFile(String str) {
        this(VFSUtils.parseUri(str));
    }

    private Uri getAbsoluteUri() {
        if (isAbsolute()) {
            return this.mUri;
        }
        String path = this.mUri.getPath();
        String property = System.getProperty("user.dir");
        if (!path.isEmpty()) {
            property = property + '/' + path;
        }
        return this.mUri.buildUpon().path(property).build();
    }

    public boolean canExecute() {
        String realPath;
        FileSystemManager.Resolution resolve = resolve();
        if (!resolve.valid()) {
            return false;
        }
        FileSystem fileSystem = resolve.fileSystem;
        if ((fileSystem.capabilityFlags() & 2) == 0 || (realPath = fileSystem.realPath(resolve.path, false)) == null || !new File(realPath).canExecute()) {
            return false;
        }
        return true;
    }

    public boolean canRead() {
        FileSystemManager.Resolution resolve = resolve();
        if (!resolve.valid()) {
            return false;
        }
        FileSystem fileSystem = resolve.fileSystem;
        String realPath = fileSystem.realPath(resolve.path, false);
        if (realPath != null) {
            return new File(realPath).canRead();
        }
        return fileSystem.exists(resolve.path);
    }

    public boolean canWrite() {
        FileSystemManager.Resolution resolve = resolve();
        if (!resolve.valid()) {
            return false;
        }
        FileSystem fileSystem = resolve.fileSystem;
        if ((fileSystem.capabilityFlags() & 1) == 0) {
            return false;
        }
        String realPath = fileSystem.realPath(resolve.path, true);
        if (realPath != null) {
            return new File(realPath).canWrite();
        }
        return fileSystem.exists(resolve.path);
    }

    public boolean createNewFile() throws IOException {
        FileSystemManager.Resolution resolve = resolve();
        if (resolve.valid()) {
            if (resolve.fileSystem.exists(resolve.path)) {
                return false;
            }
            resolve.fileSystem.openWrite(resolve.path, false).close();
            return true;
        }
        throw new FileNotFoundException("Cannot resolve path or URI: " + this.mUri);
    }

    public boolean delete() {
        FileSystemManager.Resolution resolve = resolve();
        if (resolve.valid() && resolve.fileSystem.delete(resolve.path)) {
            return true;
        }
        return false;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof VFSFile)) {
            return false;
        }
        return this.mUri.equals(((VFSFile) obj).mUri);
    }

    public boolean exists() {
        FileSystemManager.Resolution resolve = resolve();
        if (!resolve.valid()) {
            return false;
        }
        return resolve.fileSystem.exists(resolve.path);
    }

    public VFSFile getAbsoluteFile() {
        return new VFSFile(getAbsoluteUri());
    }

    public String getAbsolutePath() {
        return VFSUtils.uriToString(getAbsoluteUri());
    }

    public long getFreeSpace() {
        return getUsableSpace();
    }

    public String getName() {
        String path = this.mUri.getPath();
        int lastIndexOf = path.lastIndexOf("/");
        if (lastIndexOf >= 0) {
            return path.substring(lastIndexOf + 1, path.length());
        }
        return path;
    }

    public String getParent() {
        Uri parentUri = getParentUri();
        if (parentUri == null) {
            return null;
        }
        return VFSUtils.uriToString(parentUri);
    }

    public VFSFile getParentFile() {
        Uri parentUri = getParentUri();
        if (parentUri == null) {
            return null;
        }
        return new VFSFile(parentUri);
    }

    public Uri getParentUri() {
        String substring;
        String path = this.mUri.getPath();
        int length = path.length();
        int lastIndexOf = path.lastIndexOf(47);
        if (lastIndexOf != -1 && path.charAt(length - 1) != '/') {
            if (path.indexOf(47) == lastIndexOf && path.charAt(0) == '/') {
                substring = path.substring(0, lastIndexOf + 1);
            } else {
                substring = path.substring(0, lastIndexOf);
            }
            return this.mUri.buildUpon().path(substring).build();
        }
        return null;
    }

    public String getPath() {
        return VFSUtils.uriToString(this.mUri);
    }

    public long getTotalSpace() {
        FileSystem.FsStat fileSystemStat;
        FileSystemManager.Resolution resolve = resolve();
        if (!resolve.valid() || (fileSystemStat = resolve.fileSystem.fileSystemStat(resolve.path)) == null) {
            return 0L;
        }
        return fileSystemStat.totalSpace;
    }

    public Uri getUri() {
        return this.mUri;
    }

    public long getUsableSpace() {
        FileSystem.FsStat fileSystemStat;
        FileSystemManager.Resolution resolve = resolve();
        if (!resolve.valid() || (fileSystemStat = resolve.fileSystem.fileSystemStat(resolve.path)) == null) {
            return 0L;
        }
        return fileSystemStat.availableSpace;
    }

    public int hashCode() {
        return getPath().hashCode() ^ 1234321;
    }

    public boolean isAbsolute() {
        String path = this.mUri.getPath();
        if (!this.mUri.isAbsolute() && (path.length() <= 0 || path.charAt(0) != '/')) {
            return false;
        }
        return true;
    }

    public boolean isDirectory() {
        FileSystemManager.Resolution resolve = resolve();
        if (!resolve.valid()) {
            return false;
        }
        return new File(resolve.fileSystem.realPath(resolve.path, false)).isDirectory();
    }

    public boolean isFile() {
        FileSystemManager.Resolution resolve = resolve();
        if (!resolve.valid()) {
            return false;
        }
        return new File(resolve.fileSystem.realPath(resolve.path, false)).isFile();
    }

    public boolean isHidden() {
        if (this.mUri.getPath().isEmpty()) {
            return false;
        }
        return getName().startsWith(".");
    }

    public long lastModified() {
        FileSystem.FileEntry stat;
        FileSystemManager.Resolution resolve = resolve();
        if (!resolve.valid() || (stat = resolve.fileSystem.stat(resolve.path)) == null) {
            return 0L;
        }
        return stat.modifiedTime;
    }

    public long length() {
        FileSystemManager.Resolution resolve = resolve();
        if (!resolve.valid()) {
            return 0L;
        }
        return new File(resolve.fileSystem.realPath(resolve.path, false)).length();
    }

    public String[] list() {
        Iterable<FileSystem.FileEntry> list;
        FileSystemManager.Resolution resolve = resolve();
        if (!resolve.valid() || (list = resolve.fileSystem.list(resolve.path, false)) == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        Iterator<FileSystem.FileEntry> it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(it.next().name);
        }
        return (String[]) arrayList.toArray(new String[0]);
    }

    public VFSFile[] listFiles() {
        Iterable<FileSystem.FileEntry> list;
        FileSystemManager.Resolution resolve = resolve();
        if (!resolve.valid() || (list = resolve.fileSystem.list(resolve.path, false)) == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        Iterator<FileSystem.FileEntry> it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(new VFSFile(this, it.next().name));
        }
        return (VFSFile[]) arrayList.toArray(new VFSFile[0]);
    }

    public boolean mkdir() {
        return mkdirs();
    }

    public boolean mkdirs() {
        FileSystemManager.Resolution resolve = resolve();
        if (!resolve.valid()) {
            return false;
        }
        return resolve.fileSystem.mkdirs(resolve.path);
    }

    public boolean renameTo(VFSFile vFSFile) {
        FileSystemManager.Resolution resolve = resolve();
        FileSystemManager.Resolution resolve2 = vFSFile.resolve();
        if (resolve.valid() && resolve2.valid()) {
            try {
                resolve2.fileSystem.moveFile(resolve2.path, resolve.fileSystem, resolve.path);
                return true;
            } catch (IOException unused) {
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public FileSystemManager.Resolution resolve() {
        FileSystemManager.Resolution resolve = FileSystemManager.instance().resolve(this.mUri, this.mResolved);
        this.mResolved = resolve;
        return resolve;
    }

    public String toString() {
        return getPath();
    }

    public VFSFile(Uri uri) {
        this.mResolved = null;
        if (uri != null) {
            String path = uri.getPath();
            if (path != null) {
                String normalizePath = VFSUtils.normalizePath(path, false, false);
                if (!uri.getPath().equals(normalizePath)) {
                    uri = uri.buildUpon().path(normalizePath).build();
                }
            }
            this.mUri = uri;
            return;
        }
        throw new NullPointerException("uri == null");
    }

    @Override // java.lang.Comparable
    public int compareTo(VFSFile vFSFile) {
        return getPath().compareTo(vFSFile.getPath());
    }

    public String[] list(VFSFilenameFilter vFSFilenameFilter) {
        Iterable<FileSystem.FileEntry> list;
        if (vFSFilenameFilter == null) {
            return list();
        }
        FileSystemManager.Resolution resolve = resolve();
        if (!resolve.valid() || (list = resolve.fileSystem.list(resolve.path, false)) == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (FileSystem.FileEntry fileEntry : list) {
            if (vFSFilenameFilter.accept(this, fileEntry.name)) {
                arrayList.add(fileEntry.name);
            }
        }
        return (String[]) arrayList.toArray(new String[0]);
    }

    public VFSFile[] listFiles(VFSFilenameFilter vFSFilenameFilter) {
        Iterable<FileSystem.FileEntry> list;
        if (vFSFilenameFilter == null) {
            return listFiles();
        }
        FileSystemManager.Resolution resolve = resolve();
        if (!resolve.valid() || (list = resolve.fileSystem.list(resolve.path, false)) == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (FileSystem.FileEntry fileEntry : list) {
            if (vFSFilenameFilter.accept(this, fileEntry.name)) {
                arrayList.add(new VFSFile(this, fileEntry.name));
            }
        }
        return (VFSFile[]) arrayList.toArray(new VFSFile[0]);
    }

    public VFSFile(File file) {
        this(VFSUtils.parseUri(file.getPath()));
    }

    public VFSFile(String str, String str2) {
        this(VFSUtils.parseUri(str), str2);
    }

    public VFSFile(VFSFile vFSFile, String str) {
        this(vFSFile == null ? null : vFSFile.getUri(), str);
    }

    public VFSFile(File file, String str) {
        this(VFSUtils.parseUri(file.getPath()), str);
    }

    public VFSFile(Uri uri, String str) {
        Uri.Builder buildUpon;
        this.mResolved = null;
        if (str != null) {
            if (uri == null) {
                buildUpon = new Uri.Builder().path(str);
            } else {
                buildUpon = uri.buildUpon();
                if (!str.isEmpty()) {
                    buildUpon.appendPath(str);
                }
            }
            Uri build = buildUpon.build();
            String path = build.getPath();
            if (path != null) {
                String normalizePath = VFSUtils.normalizePath(path, false, false);
                if (!build.getPath().equals(normalizePath)) {
                    build = buildUpon.path(normalizePath).build();
                }
            }
            this.mUri = build;
            return;
        }
        throw new NullPointerException("name == null");
    }

    public VFSFile[] listFiles(VFSFileFilter vFSFileFilter) {
        Iterable<FileSystem.FileEntry> list;
        if (vFSFileFilter == null) {
            return listFiles();
        }
        FileSystemManager.Resolution resolve = resolve();
        if (!resolve.valid() || (list = resolve.fileSystem.list(resolve.path, false)) == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        Iterator<FileSystem.FileEntry> it = list.iterator();
        while (it.hasNext()) {
            VFSFile vFSFile = new VFSFile(this, it.next().name);
            if (vFSFileFilter.accept(vFSFile)) {
                arrayList.add(vFSFile);
            }
        }
        return (VFSFile[]) arrayList.toArray(new VFSFile[0]);
    }
}

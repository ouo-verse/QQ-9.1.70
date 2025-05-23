package com.tencent.mm.vfs;

import android.content.Context;
import android.content.res.AssetManager;
import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.Pair;
import com.tencent.mm.vfs.FileSystem;
import com.tencent.mm.vfs.SchemeResolver;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

/* compiled from: P */
/* loaded from: classes9.dex */
public final class AssetsSchemeResolver extends SchemeResolver.Base {
    public static final SingletonCreator CREATOR = new SingletonCreator();
    private final AssetsFileSystem mFileSystem;

    /* compiled from: P */
    /* loaded from: classes9.dex */
    private static final class AssetsFileSystem extends AbstractFileSystem {
        public static final Parcelable.Creator<AssetsFileSystem> CREATOR = null;
        private AssetManager mAssets;

        AssetsFileSystem(Context context) {
            this.mAssets = context.getAssets();
        }

        private void recursiveList(String str, String str2, ArrayList<FileSystem.FileEntry> arrayList) throws IOException {
            String str3;
            String str4;
            if (str2 != null && !str2.isEmpty()) {
                if (str.isEmpty()) {
                    str4 = str2;
                } else {
                    str4 = str + '/' + str2;
                }
                str3 = str4;
            } else {
                str3 = str;
            }
            String[] list = this.mAssets.list(str3);
            if (list != null && list.length != 0) {
                if (str2 != null) {
                    arrayList.add(new FileSystem.FileEntry(this, str3, str2, 0L, 0L, 0L, true));
                }
                for (String str5 : list) {
                    if (str5 != null && !str5.isEmpty()) {
                        recursiveList(str3, str5, arrayList);
                    }
                }
                return;
            }
            if (str2 != null) {
                arrayList.add(new FileSystem.FileEntry(this, str3, str2, 0L, 0L, 0L, false));
            }
        }

        @Override // com.tencent.mm.vfs.AbstractFileSystem, com.tencent.mm.vfs.FileSystem
        public int batchDelete(List<String> list) {
            return 0;
        }

        @Override // com.tencent.mm.vfs.FileSystem
        public int capabilityFlags() {
            return 12;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.tencent.mm.vfs.AbstractFileSystem
        public long copyFileImpl(String str, FileSystem fileSystem, String str2) throws IOException {
            throw new IOException("Not implemented");
        }

        @Override // com.tencent.mm.vfs.FileSystem
        public boolean delete(String str) {
            return false;
        }

        @Override // com.tencent.mm.vfs.FileSystem
        public boolean deleteDir(String str, boolean z16) {
            return false;
        }

        @Override // com.tencent.mm.vfs.FileSystem
        public boolean exists(String str) {
            try {
                openRead(str).close();
                return true;
            } catch (IOException unused) {
                return false;
            }
        }

        @Override // com.tencent.mm.vfs.FileSystem
        public FileSystem.FsStat fileSystemStat(String str) {
            return new FileSystem.FsStat();
        }

        @Override // com.tencent.mm.vfs.FileSystem
        public Iterable<FileSystem.FileEntry> list(String str, boolean z16) {
            boolean z17;
            String str2 = str;
            boolean z18 = true;
            boolean z19 = false;
            if (str2.endsWith("/")) {
                str2 = str2.substring(0, str.length() - 1);
            }
            try {
                if (z16) {
                    ArrayList<FileSystem.FileEntry> arrayList = new ArrayList<>();
                    recursiveList(str2, null, arrayList);
                    return arrayList;
                }
                String[] list = this.mAssets.list(str2);
                if (list == null) {
                    return null;
                }
                String str3 = str2 + '/';
                ArrayList arrayList2 = new ArrayList(list.length);
                int length = list.length;
                int i3 = 0;
                while (i3 < length) {
                    String str4 = list[i3];
                    String str5 = str3 + str4;
                    String[] list2 = this.mAssets.list(str5);
                    if (list2 != null && list2.length > 0) {
                        z17 = z18;
                    } else {
                        z17 = z19;
                    }
                    int i16 = i3;
                    ArrayList arrayList3 = arrayList2;
                    int i17 = length;
                    String str6 = str3;
                    arrayList3.add(new FileSystem.FileEntry(this, str5, str4, 0L, 0L, 0L, z17));
                    i3 = i16 + 1;
                    arrayList2 = arrayList3;
                    length = i17;
                    str3 = str6;
                    z18 = true;
                    z19 = false;
                }
                return arrayList2;
            } catch (IOException unused) {
                return null;
            }
        }

        @Override // com.tencent.mm.vfs.FileSystem
        public boolean mkdirs(String str) {
            return false;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.tencent.mm.vfs.AbstractFileSystem
        public boolean moveFileImpl(String str, FileSystem fileSystem, String str2) throws IOException {
            throw new IOException("Not implemented");
        }

        @Override // com.tencent.mm.vfs.FileSystem
        public InputStream openRead(String str) throws FileNotFoundException {
            try {
                return this.mAssets.open(str);
            } catch (IOException e16) {
                if (e16 instanceof FileNotFoundException) {
                    throw ((FileNotFoundException) e16);
                }
                throw new FileNotFoundException(e16.getMessage());
            }
        }

        @Override // com.tencent.mm.vfs.FileSystem
        public OutputStream openWrite(String str, boolean z16) throws FileNotFoundException {
            throw new FileNotFoundException("Cannot open files for writing on read-only filesystems");
        }

        @Override // com.tencent.mm.vfs.FileSystem
        public String realPath(String str, boolean z16) {
            return null;
        }

        @Override // com.tencent.mm.vfs.FileSystem
        public boolean setModifiedTime(String str, long j3) {
            return false;
        }

        @Override // com.tencent.mm.vfs.FileSystem
        public FileSystem.FileEntry stat(String str) {
            String substring;
            try {
                InputStream openRead = openRead(str);
                int available = openRead.available();
                openRead.close();
                int lastIndexOf = str.lastIndexOf(47);
                if (lastIndexOf < 0) {
                    substring = str;
                } else {
                    substring = str.substring(lastIndexOf + 1);
                }
                return new FileSystem.FileEntry(this, str, substring, available, 0L, 0L, false);
            } catch (IOException unused) {
                return null;
            }
        }

        public String toString() {
            return "AssetsFS";
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i3) {
            throw new UnsupportedOperationException();
        }
    }

    /* compiled from: P */
    /* loaded from: classes9.dex */
    private static class SingletonCreator implements Parcelable.Creator<AssetsSchemeResolver> {
        static final AssetsSchemeResolver INSTANCE = new AssetsSchemeResolver();

        SingletonCreator() {
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public AssetsSchemeResolver createFromParcel(Parcel parcel) {
            return INSTANCE;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public AssetsSchemeResolver[] newArray(int i3) {
            return new AssetsSchemeResolver[i3];
        }
    }

    public static AssetsSchemeResolver instance() {
        return SingletonCreator.INSTANCE;
    }

    @Override // com.tencent.mm.vfs.SchemeResolver
    public Pair<FileSystem, String> resolve(SchemeResolver.ResolverContext resolverContext, Uri uri) {
        String normalizePath;
        String path = uri.getPath();
        if (path == null) {
            normalizePath = "";
        } else {
            normalizePath = VFSUtils.normalizePath(path, true, true);
        }
        return new Pair<>(this.mFileSystem, normalizePath);
    }

    AssetsSchemeResolver() {
        this.mFileSystem = new AssetsFileSystem(FileSystemManager.instance().getContext());
    }
}

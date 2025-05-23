package com.tencent.mm.vfs;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.Pair;
import com.tencent.mm.vfs.ResolverState;
import com.tencent.mm.vfs.SchemeResolver;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.io.IOException;
import java.util.Collections;
import java.util.List;

/* compiled from: P */
/* loaded from: classes9.dex */
public class FileSchemeResolver extends SchemeResolver.Base {
    public static final SingletonCreator CREATOR = new SingletonCreator();
    private static final String TAG = "VFS.FileSchemeResolver";

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes9.dex */
    public static class SingletonCreator implements Parcelable.Creator<FileSchemeResolver> {
        static final FileSchemeResolver INSTANCE = new FileSchemeResolver();

        SingletonCreator() {
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public FileSchemeResolver createFromParcel(Parcel parcel) {
            return INSTANCE;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public FileSchemeResolver[] newArray(int i3) {
            return new FileSchemeResolver[i3];
        }
    }

    private static String canonicalizePath(String str) {
        File file = new File(str);
        try {
            return file.getCanonicalPath();
        } catch (IOException unused) {
            return file.getAbsolutePath();
        }
    }

    public static FileSchemeResolver instance() {
        return SingletonCreator.INSTANCE;
    }

    private Pair<ResolverState.MountPointEntry, String> resolveMountPoint(SchemeResolver.ResolverContext resolverContext, Uri uri) {
        ResolverState.MountPointEntry mountPointEntry;
        List<ResolverState.MountPointEntry> list = ((ResolverState) resolverContext).mActiveMountPoints;
        String path = uri.getPath();
        ResolverState.MountPointEntry mountPointEntry2 = null;
        if (path != null && !path.isEmpty()) {
            String canonicalizePath = canonicalizePath(path);
            int binarySearch = Collections.binarySearch(list, canonicalizePath);
            if (binarySearch >= 0) {
                mountPointEntry = list.get(binarySearch);
                canonicalizePath = "";
            } else {
                int i3 = (-binarySearch) - 2;
                while (true) {
                    if (i3 >= 0) {
                        ResolverState.MountPointEntry mountPointEntry3 = list.get(i3);
                        if (canonicalizePath.startsWith(mountPointEntry3.basePath) && canonicalizePath.charAt(mountPointEntry3.basePath.length()) == '/') {
                            mountPointEntry2 = mountPointEntry3;
                            break;
                        }
                        i3 = mountPointEntry3.fallbackIndex;
                    } else {
                        break;
                    }
                }
                if (i3 >= 0) {
                    canonicalizePath = canonicalizePath.substring(mountPointEntry2.basePath.length() + 1);
                } else if (!canonicalizePath.isEmpty() && canonicalizePath.charAt(0) == '/') {
                    canonicalizePath = canonicalizePath.substring(1);
                }
                mountPointEntry = mountPointEntry2;
            }
            return new Pair<>(mountPointEntry, canonicalizePath);
        }
        QLog.e(TAG, 1, "resolveMountPoint is wrong! " + uri.toString());
        return null;
    }

    @Override // com.tencent.mm.vfs.SchemeResolver.Base, com.tencent.mm.vfs.SchemeResolver
    public Uri exportUri(SchemeResolver.ResolverContext resolverContext, Uri uri) {
        Pair<ResolverState.MountPointEntry, String> resolveMountPoint = resolveMountPoint(resolverContext, uri);
        if (resolveMountPoint != null && resolveMountPoint.first != null) {
            return new Uri.Builder().scheme("wcf").authority(((ResolverState.MountPointEntry) resolveMountPoint.first).fileSystemName).path((String) resolveMountPoint.second).build();
        }
        return null;
    }

    @Override // com.tencent.mm.vfs.SchemeResolver
    public Pair<FileSystem, String> resolve(SchemeResolver.ResolverContext resolverContext, Uri uri) {
        FileSystem fileSystem;
        Pair<ResolverState.MountPointEntry, String> resolveMountPoint = resolveMountPoint(resolverContext, uri);
        if (resolveMountPoint == null) {
            return null;
        }
        Object obj = resolveMountPoint.first;
        if (obj == null) {
            fileSystem = resolverContext.root();
        } else {
            fileSystem = ((ResolverState.MountPointEntry) obj).fileSystem;
        }
        return new Pair<>(fileSystem, resolveMountPoint.second);
    }

    FileSchemeResolver() {
    }
}

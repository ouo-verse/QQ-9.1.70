package com.tencent.mm.vfs;

import android.os.Bundle;
import android.os.Parcelable;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.mm.vfs.SchemeResolver;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.SortedMap;
import java.util.TreeMap;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
/* loaded from: classes9.dex */
public final class ResolverState implements SchemeResolver.ResolverContext {
    private static final FileSystem DEFAULT_ROOT = new NativeFileSystem("", false);
    private static final String TAG = "VFS.ResolverState";
    final List<MountPointEntry> mActiveMountPoints;
    private Map<String, String> mEnvSnapshot;
    final Map<String, String> mEnvVars;
    final Map<String, FileSystem> mFileSystems;
    private Map<String, FileSystem> mFileSystemsSnapshot;
    final SortedMap<String, String> mMountPoints;
    final FileSystem mRootFileSystem;
    final Map<String, SchemeResolver> mSchemeResolvers;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes9.dex */
    public static final class MountPointEntry implements Comparable<String> {
        final String basePath;
        final int fallbackIndex;
        final FileSystem fileSystem;
        final String fileSystemName;

        MountPointEntry(String str, String str2, FileSystem fileSystem, int i3) {
            this.basePath = str;
            this.fileSystemName = str2;
            this.fileSystem = fileSystem;
            this.fallbackIndex = i3;
        }

        public String toString() {
            return this.basePath + " -> " + this.fileSystemName + " " + this.fileSystem.toString();
        }

        @Override // java.lang.Comparable
        public int compareTo(String str) {
            return this.basePath.compareTo(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ResolverState() {
        this.mFileSystemsSnapshot = null;
        this.mEnvSnapshot = null;
        this.mSchemeResolvers = Collections.emptyMap();
        this.mFileSystems = Collections.emptyMap();
        this.mMountPoints = new TreeMap();
        this.mActiveMountPoints = Collections.emptyList();
        this.mEnvVars = Collections.emptyMap();
        this.mRootFileSystem = DEFAULT_ROOT;
    }

    /* JADX WARN: Removed duplicated region for block: B:28:0x00e8  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x00f5 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static List<MountPointEntry> generateMountPoints(Map<String, FileSystem> map, SortedMap<String, String> sortedMap, Map<String, String> map2) {
        int i3;
        VFSTrack.track(null, "generateMountPoints");
        ArrayList arrayList = new ArrayList(sortedMap.size());
        for (Map.Entry<String, String> entry : sortedMap.entrySet()) {
            String key = entry.getKey();
            String value = entry.getValue();
            FileSystem fileSystem = map.get(value);
            if (fileSystem != null) {
                String macroResolve = VFSUtils.macroResolve(key, map2);
                if (macroResolve != null) {
                    arrayList.add(new MountPointEntry(macroResolve, value, fileSystem, -1));
                }
            } else {
                throw new IllegalArgumentException("FileSystem '" + value + "' for mount point '" + key + "' not exist.");
            }
        }
        MountPointEntry[] mountPointEntryArr = (MountPointEntry[]) arrayList.toArray(new MountPointEntry[0]);
        Arrays.sort(mountPointEntryArr, new Comparator<MountPointEntry>() { // from class: com.tencent.mm.vfs.ResolverState.1
            @Override // java.util.Comparator
            public int compare(MountPointEntry mountPointEntry, MountPointEntry mountPointEntry2) {
                return mountPointEntry.basePath.compareTo(mountPointEntry2.basePath);
            }
        });
        for (int i16 = 1; i16 < mountPointEntryArr.length; i16++) {
            MountPointEntry mountPointEntry = mountPointEntryArr[i16];
            String str = mountPointEntry.basePath;
            int i17 = i16 - 1;
            MountPointEntry mountPointEntry2 = mountPointEntryArr[i17];
            if (str.equals(mountPointEntry2.basePath)) {
                if (QLog.isColorLevel()) {
                    QLog.w(TAG, 2, "Oops, duplicated mount point detected: " + mountPointEntry.toString() + " <=> " + mountPointEntry2.toString());
                }
                i3 = mountPointEntry2.fallbackIndex;
                if (i3 < 0) {
                    mountPointEntryArr[i16] = new MountPointEntry(mountPointEntry.basePath, mountPointEntry.fileSystemName, mountPointEntry.fileSystem, i3);
                }
            }
            do {
                MountPointEntry mountPointEntry3 = mountPointEntryArr[i17];
                if (str.startsWith(mountPointEntry3.basePath) && str.charAt(mountPointEntry3.basePath.length()) == '/') {
                    break;
                }
                i17 = mountPointEntry3.fallbackIndex;
            } while (i17 >= 0);
            i3 = i17;
            if (i3 < 0) {
            }
        }
        VFSTrack.track("generateMountPoints", null);
        return Arrays.asList(mountPointEntryArr);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static ResolverState loadFromBundle(Bundle bundle) {
        VFSTrack.track(null, VFSTrack.LOAD_BUNDLE);
        ArrayList parcelableArrayList = bundle.getParcelableArrayList("sl");
        Bundle bundle2 = bundle.getBundle("sm");
        HashMap hashMap = new HashMap();
        if (parcelableArrayList != null && bundle2 != null) {
            for (String str : bundle2.keySet()) {
                int i3 = bundle2.getInt(str);
                if (i3 >= 0 && i3 < parcelableArrayList.size()) {
                    hashMap.put(str, parcelableArrayList.get(i3));
                }
            }
        }
        Bundle bundle3 = bundle.getBundle("fs");
        HashMap hashMap2 = new HashMap();
        if (bundle3 != null) {
            bundle3.setClassLoader(bundle.getClassLoader());
            for (String str2 : bundle3.keySet()) {
                hashMap2.put(str2, bundle3.getParcelable(str2));
            }
        }
        Bundle bundle4 = bundle.getBundle("mp");
        TreeMap treeMap = new TreeMap();
        if (bundle4 != null) {
            bundle4.setClassLoader(bundle.getClassLoader());
            for (String str3 : bundle4.keySet()) {
                treeMap.put(str3, bundle4.getString(str3));
            }
        }
        Bundle bundle5 = bundle.getBundle(MosaicConstants$JsProperty.PROP_ENV);
        HashMap hashMap3 = new HashMap();
        if (bundle5 != null) {
            for (String str4 : bundle5.keySet()) {
                hashMap3.put(str4, bundle5.getString(str4));
            }
        }
        FileSystem fileSystem = (FileSystem) bundle.getParcelable("root");
        VFSTrack.track(VFSTrack.LOAD_BUNDLE, null);
        return new ResolverState(hashMap, hashMap2, treeMap, hashMap3, fileSystem);
    }

    private static <K, V> void mergeMap(Map<K, V> map, Map<K, V> map2) {
        for (Map.Entry<K, V> entry : map2.entrySet()) {
            if (entry.getValue() == null) {
                map.remove(entry.getKey());
            } else {
                map.put(entry.getKey(), entry.getValue());
            }
        }
    }

    @Override // com.tencent.mm.vfs.SchemeResolver.ResolverContext
    public SortedMap<String, FileSystem> activeMountPoints() {
        return null;
    }

    @Override // com.tencent.mm.vfs.SchemeResolver.ResolverContext
    public Map<String, String> envVars() {
        if (this.mEnvSnapshot == null) {
            this.mEnvSnapshot = Collections.unmodifiableMap(this.mEnvVars);
        }
        return this.mEnvSnapshot;
    }

    @Override // com.tencent.mm.vfs.SchemeResolver.ResolverContext
    public Map<String, FileSystem> fileSystems() {
        if (this.mFileSystemsSnapshot == null) {
            this.mFileSystemsSnapshot = Collections.unmodifiableMap(this.mFileSystems);
        }
        return this.mFileSystemsSnapshot;
    }

    @Override // com.tencent.mm.vfs.SchemeResolver.ResolverContext
    public FileSystem root() {
        return this.mRootFileSystem;
    }

    public String toString() {
        return "schemes: " + this.mSchemeResolvers.size() + ", fileSystems: " + this.mFileSystems.size() + ", mountPoints: " + this.mMountPoints.size() + " (" + this.mActiveMountPoints + " active), envVars: " + this.mEnvVars.size();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Multi-variable type inference failed */
    public ResolverState update(Map<String, SchemeResolver> map, Map<String, FileSystem> map2, SortedMap<String, String> sortedMap, Map<String, String> map3, FileSystem fileSystem) {
        Map map4;
        boolean z16;
        Map map5;
        SortedMap sortedMap2;
        Map map6;
        FileSystem fileSystem2;
        ResolverState resolverState;
        VFSTrack.track(null, "update");
        boolean z17 = true;
        if (map.isEmpty()) {
            z16 = false;
            map4 = this.mSchemeResolvers;
        } else {
            Map hashMap = new HashMap(this.mSchemeResolvers);
            mergeMap(hashMap, map);
            map4 = hashMap;
            z16 = true;
        }
        if (map2.isEmpty()) {
            map5 = this.mFileSystems;
        } else {
            Map hashMap2 = new HashMap(this.mFileSystems);
            mergeMap(hashMap2, map2);
            map5 = hashMap2;
            z16 = true;
        }
        if (sortedMap.isEmpty()) {
            sortedMap2 = this.mMountPoints;
        } else {
            SortedMap treeMap = new TreeMap((SortedMap) this.mMountPoints);
            mergeMap(treeMap, sortedMap);
            sortedMap2 = treeMap;
            z16 = true;
        }
        if (map3.isEmpty()) {
            map6 = this.mEnvVars;
            z17 = z16;
        } else {
            Map hashMap3 = new HashMap(this.mEnvVars);
            mergeMap(hashMap3, map3);
            map6 = hashMap3;
        }
        if (fileSystem == null) {
            fileSystem2 = this.mRootFileSystem;
        } else {
            fileSystem2 = fileSystem;
        }
        if (z17) {
            resolverState = new ResolverState(map4, map5, sortedMap2, map6, fileSystem2);
        } else {
            resolverState = this;
        }
        if (map2.isEmpty()) {
            resolverState.mFileSystemsSnapshot = this.mFileSystemsSnapshot;
        }
        if (map3.isEmpty()) {
            resolverState.mEnvSnapshot = this.mEnvSnapshot;
        }
        VFSTrack.track("update", null);
        return resolverState;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Bundle writeToBundle() {
        VFSTrack.track(null, "writeToBundle");
        Bundle bundle = new Bundle();
        HashMap hashMap = new HashMap();
        ArrayList<? extends Parcelable> arrayList = new ArrayList<>(this.mSchemeResolvers.size());
        Bundle bundle2 = new Bundle();
        for (Map.Entry<String, SchemeResolver> entry : this.mSchemeResolvers.entrySet()) {
            SchemeResolver value = entry.getValue();
            Integer num = (Integer) hashMap.get(value);
            if (num == null) {
                num = Integer.valueOf(arrayList.size());
                arrayList.add(value);
                hashMap.put(value, num);
            }
            bundle2.putInt(entry.getKey(), num.intValue());
        }
        bundle.putParcelableArrayList("sl", arrayList);
        bundle.putBundle("sm", bundle2);
        Bundle bundle3 = new Bundle();
        for (Map.Entry<String, FileSystem> entry2 : this.mFileSystems.entrySet()) {
            bundle3.putParcelable(entry2.getKey(), entry2.getValue());
        }
        bundle.putBundle("fs", bundle3);
        Bundle bundle4 = new Bundle();
        for (Map.Entry<String, String> entry3 : this.mMountPoints.entrySet()) {
            bundle4.putString(entry3.getKey(), entry3.getValue());
        }
        bundle.putBundle("mp", bundle4);
        Bundle bundle5 = new Bundle();
        for (Map.Entry<String, String> entry4 : this.mEnvVars.entrySet()) {
            bundle5.putString(entry4.getKey(), entry4.getValue());
        }
        bundle.putBundle(MosaicConstants$JsProperty.PROP_ENV, bundle5);
        bundle.putParcelable("root", this.mRootFileSystem);
        VFSTrack.track("writeToBundle", null);
        return bundle;
    }

    ResolverState(Map<String, SchemeResolver> map, Map<String, FileSystem> map2, SortedMap<String, String> sortedMap, Map<String, String> map3, FileSystem fileSystem) {
        this.mFileSystemsSnapshot = null;
        this.mEnvSnapshot = null;
        this.mSchemeResolvers = map;
        this.mFileSystems = map2;
        this.mMountPoints = sortedMap;
        this.mActiveMountPoints = generateMountPoints(map2, sortedMap, map3);
        this.mEnvVars = map3;
        this.mRootFileSystem = fileSystem == null ? DEFAULT_ROOT : fileSystem;
    }
}

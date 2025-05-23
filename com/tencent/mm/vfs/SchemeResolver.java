package com.tencent.mm.vfs;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.Pair;
import java.util.Map;
import java.util.SortedMap;

/* compiled from: P */
/* loaded from: classes9.dex */
public interface SchemeResolver extends Parcelable {

    /* compiled from: P */
    /* loaded from: classes9.dex */
    public interface ResolverContext {
        SortedMap<String, FileSystem> activeMountPoints();

        Map<String, String> envVars();

        Map<String, FileSystem> fileSystems();

        FileSystem root();
    }

    void configure(Map<String, String> map);

    Uri exportUri(ResolverContext resolverContext, Uri uri);

    void maintain(CancellationSignalCompat cancellationSignalCompat);

    Pair<FileSystem, String> resolve(ResolverContext resolverContext, Uri uri);

    /* compiled from: P */
    /* loaded from: classes9.dex */
    public static abstract class Base implements SchemeResolver {
        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @Override // com.tencent.mm.vfs.SchemeResolver
        public Uri exportUri(ResolverContext resolverContext, Uri uri) {
            if (resolve(resolverContext, uri) == null) {
                return null;
            }
            return uri;
        }

        @Override // com.tencent.mm.vfs.SchemeResolver
        public void configure(Map<String, String> map) {
        }

        @Override // com.tencent.mm.vfs.SchemeResolver
        public void maintain(CancellationSignalCompat cancellationSignalCompat) {
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i3) {
        }
    }
}

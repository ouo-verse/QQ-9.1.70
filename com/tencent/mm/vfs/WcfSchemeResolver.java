package com.tencent.mm.vfs;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.Pair;
import com.tencent.mm.vfs.SchemeResolver;

/* compiled from: P */
/* loaded from: classes9.dex */
public final class WcfSchemeResolver extends SchemeResolver.Base {
    public static final SingletonCreator CREATOR = new SingletonCreator();

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes9.dex */
    public static class SingletonCreator implements Parcelable.Creator<WcfSchemeResolver> {
        static final WcfSchemeResolver INSTANCE = new WcfSchemeResolver();

        SingletonCreator() {
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public WcfSchemeResolver createFromParcel(Parcel parcel) {
            return INSTANCE;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public WcfSchemeResolver[] newArray(int i3) {
            return new WcfSchemeResolver[i3];
        }
    }

    public static WcfSchemeResolver instance() {
        return SingletonCreator.INSTANCE;
    }

    @Override // com.tencent.mm.vfs.SchemeResolver
    public Pair<FileSystem, String> resolve(SchemeResolver.ResolverContext resolverContext, Uri uri) {
        String normalizePath;
        FileSystem fileSystem = ((ResolverState) resolverContext).mFileSystems.get(uri.getAuthority());
        String path = uri.getPath();
        if (path == null) {
            normalizePath = "";
        } else {
            normalizePath = VFSUtils.normalizePath(path, true, true);
        }
        return new Pair<>(fileSystem, normalizePath);
    }

    WcfSchemeResolver() {
    }
}

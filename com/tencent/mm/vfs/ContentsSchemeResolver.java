package com.tencent.mm.vfs;

import android.content.ContentResolver;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.os.Parcel;
import android.os.ParcelFileDescriptor;
import android.os.Parcelable;
import android.util.Pair;
import com.tencent.mm.vfs.FileSystem;
import com.tencent.mm.vfs.SchemeResolver;
import com.tencent.qmethod.pandoraex.monitor.ContactsMonitor;
import com.tencent.util.InputMethodUtil;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.channels.ByteChannel;
import py3.b;

/* compiled from: P */
/* loaded from: classes9.dex */
public final class ContentsSchemeResolver extends SchemeResolver.Base {
    public static final SingletonCreator CREATOR = new SingletonCreator();
    private final ContentProviderFileSystem mFileSystem;

    /* compiled from: P */
    /* loaded from: classes9.dex */
    private static final class ContentProviderFileSystem extends AbstractFileSystem {
        public static final Parcelable.Creator<ContentProviderFileSystem> CREATOR = null;
        private final ContentResolver mCR;

        ContentProviderFileSystem(Context context) {
            this.mCR = context.getContentResolver();
        }

        @Override // com.tencent.mm.vfs.FileSystem
        public int capabilityFlags() {
            return 1;
        }

        @Override // com.tencent.mm.vfs.FileSystem
        public boolean delete(String str) {
            if (b.e(this.mCR, Uri.parse(str), null, null) >= 1) {
                return true;
            }
            return false;
        }

        @Override // com.tencent.mm.vfs.FileSystem
        public boolean deleteDir(String str, boolean z16) {
            return false;
        }

        @Override // com.tencent.mm.vfs.FileSystem
        public boolean exists(String str) {
            if (stat(str) != null) {
                return true;
            }
            return false;
        }

        @Override // com.tencent.mm.vfs.FileSystem
        public FileSystem.FsStat fileSystemStat(String str) {
            return new FileSystem.FsStat();
        }

        @Override // com.tencent.mm.vfs.FileSystem
        public Iterable<FileSystem.FileEntry> list(String str, boolean z16) {
            return null;
        }

        @Override // com.tencent.mm.vfs.FileSystem
        public boolean mkdirs(String str) {
            return false;
        }

        @Override // com.tencent.mm.vfs.AbstractFileSystem, com.tencent.mm.vfs.FileSystem
        public ParcelFileDescriptor openParcelFd(String str, String str2) throws FileNotFoundException {
            return this.mCR.openFileDescriptor(Uri.parse(str), str2);
        }

        @Override // com.tencent.mm.vfs.FileSystem
        public InputStream openRead(String str) throws FileNotFoundException {
            return this.mCR.openInputStream(Uri.parse(str));
        }

        @Override // com.tencent.mm.vfs.AbstractFileSystem, com.tencent.mm.vfs.FileSystem
        public ByteChannel openReadWriteChannel(String str) throws FileNotFoundException {
            throw new FileNotFoundException("Not supported.");
        }

        @Override // com.tencent.mm.vfs.FileSystem
        public OutputStream openWrite(String str, boolean z16) throws FileNotFoundException {
            String str2;
            ContentResolver contentResolver = this.mCR;
            Uri parse = Uri.parse(str);
            if (z16) {
                str2 = "wa";
            } else {
                str2 = "w";
            }
            return contentResolver.openOutputStream(parse, str2);
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
            Cursor cursor = null;
            try {
                Cursor query = ContactsMonitor.query(this.mCR, Uri.parse(str), null, null, null, null);
                if (query == null) {
                    VFSUtils.closeQuietly(query);
                    return null;
                }
                try {
                    int columnIndex = query.getColumnIndex(InputMethodUtil.SOUGOU_URI_DISPLAYNAME);
                    int columnIndex2 = query.getColumnIndex("_size");
                    if (!query.moveToFirst()) {
                        VFSUtils.closeQuietly(query);
                        return null;
                    }
                    FileSystem.FileEntry fileEntry = new FileSystem.FileEntry(this, str, query.getString(columnIndex), query.getLong(columnIndex2), 0L, 0L, false);
                    VFSUtils.closeQuietly(query);
                    return fileEntry;
                } catch (Throwable th5) {
                    th = th5;
                    cursor = query;
                    VFSUtils.closeQuietly(cursor);
                    throw th;
                }
            } catch (Throwable th6) {
                th = th6;
            }
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i3) {
            throw new UnsupportedOperationException();
        }
    }

    /* compiled from: P */
    /* loaded from: classes9.dex */
    private static class SingletonCreator implements Parcelable.Creator<ContentsSchemeResolver> {
        static final ContentsSchemeResolver INSTANCE = new ContentsSchemeResolver();

        SingletonCreator() {
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public ContentsSchemeResolver createFromParcel(Parcel parcel) {
            return INSTANCE;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public ContentsSchemeResolver[] newArray(int i3) {
            return new ContentsSchemeResolver[i3];
        }
    }

    public static ContentsSchemeResolver instance() {
        return SingletonCreator.INSTANCE;
    }

    @Override // com.tencent.mm.vfs.SchemeResolver
    public Pair<FileSystem, String> resolve(SchemeResolver.ResolverContext resolverContext, Uri uri) {
        return new Pair<>(this.mFileSystem, uri.toString());
    }

    ContentsSchemeResolver() {
        this.mFileSystem = new ContentProviderFileSystem(FileSystemManager.instance().getContext());
    }
}

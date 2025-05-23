package com.tencent.mm.vfs;

import android.os.ParcelFileDescriptor;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.channels.ByteChannel;
import java.nio.channels.Channels;
import java.nio.channels.ReadableByteChannel;
import java.nio.channels.WritableByteChannel;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes9.dex */
public abstract class AbstractFileSystem implements FileSystem {
    private StatisticsCallback mStatistics;
    private String mStatisticsId;

    private static FileSystem resolveDelegate(FileSystem fileSystem, String str, int i3) {
        while (fileSystem instanceof DelegateFileSystem) {
            fileSystem = ((DelegateFileSystem) fileSystem).delegate(str, i3);
        }
        return fileSystem;
    }

    @Override // com.tencent.mm.vfs.FileSystem
    public int batchDelete(List<String> list) {
        Iterator<String> it = list.iterator();
        int i3 = 0;
        while (it.hasNext()) {
            if (delete(it.next())) {
                i3++;
            }
        }
        return i3;
    }

    @Override // com.tencent.mm.vfs.FileSystem
    public final long copyFile(String str, FileSystem fileSystem, String str2) throws IOException {
        FileSystem resolveDelegate = resolveDelegate(this, str, 2);
        FileSystem resolveDelegate2 = resolveDelegate(fileSystem, str2, 1);
        if (resolveDelegate != null && resolveDelegate2 != null) {
            if (resolveDelegate instanceof AbstractFileSystem) {
                return ((AbstractFileSystem) resolveDelegate).copyFileImpl(str, resolveDelegate2, str2);
            }
            return resolveDelegate.copyFile(str, resolveDelegate2, str2);
        }
        throw new IOException("Cannot resolve delegate filesystem.");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public long copyFileImpl(String str, FileSystem fileSystem, String str2) throws IOException {
        return VFSUtils.streamCopy(fileSystem, str2, this, str);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // com.tencent.mm.vfs.FileSystem
    public final boolean moveFile(String str, FileSystem fileSystem, String str2) throws IOException {
        FileSystem resolveDelegate = resolveDelegate(this, str, 2);
        FileSystem resolveDelegate2 = resolveDelegate(fileSystem, str2, 1);
        if (resolveDelegate != null && resolveDelegate2 != null) {
            if (resolveDelegate instanceof AbstractFileSystem) {
                return ((AbstractFileSystem) resolveDelegate).moveFileImpl(str, resolveDelegate2, str2);
            }
            return resolveDelegate.moveFile(str, resolveDelegate2, str2);
        }
        throw new IOException("Cannot resolve delegate filesystem.");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean moveFileImpl(String str, FileSystem fileSystem, String str2) throws IOException {
        return false;
    }

    @Override // com.tencent.mm.vfs.FileSystem
    public ParcelFileDescriptor openParcelFd(String str, String str2) throws FileNotFoundException {
        throw new FileNotFoundException("Not supported by the filesystem.");
    }

    @Override // com.tencent.mm.vfs.FileSystem
    public ReadableByteChannel openReadChannel(String str) throws FileNotFoundException {
        return Channels.newChannel(openRead(str));
    }

    @Override // com.tencent.mm.vfs.FileSystem
    public ByteChannel openReadWriteChannel(String str) throws FileNotFoundException {
        throw new FileNotFoundException("Not supported by the filesystem.");
    }

    @Override // com.tencent.mm.vfs.FileSystem
    public WritableByteChannel openWriteChannel(String str, boolean z16) throws FileNotFoundException {
        return Channels.newChannel(openWrite(str, z16));
    }

    public void setStatisticsCallback(String str, StatisticsCallback statisticsCallback) {
        synchronized (this) {
            this.mStatisticsId = str;
            this.mStatistics = statisticsCallback;
        }
    }

    protected void statistics(int i3, Map<String, Object> map) {
        String str;
        StatisticsCallback statisticsCallback;
        synchronized (this) {
            str = this.mStatisticsId;
            statisticsCallback = this.mStatistics;
        }
        if (statisticsCallback != null) {
            statisticsCallback.statistics(str, i3, map);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void statistics(int i3, Object... objArr) {
        HashMap hashMap;
        if (objArr.length == 0) {
            hashMap = null;
        } else {
            HashMap hashMap2 = new HashMap(objArr.length / 2);
            int i16 = 0;
            while (i16 < objArr.length - 1) {
                int i17 = i16 + 1;
                Object obj = objArr[i16];
                if (i17 >= objArr.length) {
                    break;
                }
                hashMap2.put(obj.toString(), String.valueOf(objArr[i17]));
                i16 = i17 + 1;
            }
            hashMap = hashMap2;
        }
        statistics(i3, hashMap);
    }

    @Override // com.tencent.mm.vfs.FileSystem
    public void configure(Map<String, String> map) {
    }

    @Override // com.tencent.mm.vfs.FileSystem
    public void maintain(CancellationSignalCompat cancellationSignalCompat) {
    }
}

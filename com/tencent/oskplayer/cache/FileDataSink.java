package com.tencent.oskplayer.cache;

import com.tencent.oskplayer.cache.CacheDataSink;
import com.tencent.oskplayer.datasource.DataSink;
import com.tencent.oskplayer.datasource.DataSpec;
import com.tencent.oskplayer.proxy.FileType;
import com.tencent.oskplayer.support.log.Logger;
import com.tencent.oskplayer.support.util.OskFile;
import com.tencent.oskplayer.util.PlayerUtils;
import java.io.File;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes22.dex */
public class FileDataSink extends CacheDataSink {
    public static final String DEFAULT_SINK_DIR = "oskfile";
    public static final String LOG_TAG = "FileDataSink";
    public static final String TEMP_FILE = ".temp";
    private File dstFile;
    private String extensionName;
    private File sinkDir;

    public FileDataSink(String str, File file) {
        super(null, Long.MAX_VALUE);
        this.dstFile = null;
        this.extensionName = "";
        this.sinkDir = file;
        this.extensionName = PlayerUtils.guessExtension(str);
    }

    public static String getLocalFile(String str, File file) {
        String absolutePath;
        if (file == null) {
            absolutePath = OskFile.ensureFilesDir(DEFAULT_SINK_DIR);
        } else {
            absolutePath = file.getAbsolutePath();
        }
        File file2 = new File(absolutePath + File.separator + PlayerUtils.parseVideoKey(str) + "." + PlayerUtils.guessExtension(str));
        if (file2.exists() && file2.isFile()) {
            return file2.getAbsolutePath();
        }
        return null;
    }

    @Override // com.tencent.oskplayer.cache.CacheDataSink
    protected void commitFile() throws IOException {
        if (!this.file.exists()) {
            this.dstFile = null;
            return;
        }
        if (this.dstFile.exists()) {
            this.dstFile.delete();
        }
        long length = this.file.length();
        long j3 = this.totalLength;
        if (j3 > 0) {
            if (j3 == this.file.length()) {
                if (!this.file.renameTo(this.dstFile)) {
                    this.dstFile = null;
                    Logger.g().e(LOG_TAG, "failed rename file " + this.file);
                    throw new IOException("rename failed");
                }
                return;
            }
            this.file.delete();
            this.dstFile = null;
            Logger.g().w(LOG_TAG, "commitFile failed totalLength=" + this.totalLength + ",current total=" + this.file.length());
            throw new IOException("length not match");
        }
        if (length != 0) {
            return;
        }
        this.file.delete();
        this.dstFile = null;
        Logger.g().w(LOG_TAG, "commitFile failed file_length=" + this.file.length());
        throw new IOException("length is zero");
    }

    public long getBytesTotal() {
        return this.totalLength;
    }

    public long getBytesWritten() {
        return this.outputStreamBytesWritten;
    }

    public File getFile() {
        if (this.dstFile.isFile() && this.dstFile.exists() && this.dstFile.length() > 0) {
            return this.dstFile;
        }
        return null;
    }

    @Override // com.tencent.oskplayer.cache.CacheDataSink, com.tencent.oskplayer.datasource.DataSink
    public DataSink open(DataSpec dataSpec, long j3, FileType fileType) throws CacheDataSink.CacheDataSinkException {
        this.totalLength = j3;
        this.fileType = fileType;
        try {
            this.dataSpec = dataSpec;
            this.dataSpecBytesWritten = 0L;
            openNextOutputStream();
            return this;
        } catch (IOException e16) {
            throw new CacheDataSink.CacheDataSinkException(e16);
        }
    }

    @Override // com.tencent.oskplayer.cache.CacheDataSink
    protected void startFile() {
        String absolutePath;
        File file = this.sinkDir;
        if (file == null) {
            absolutePath = OskFile.ensureFilesDir(DEFAULT_SINK_DIR);
        } else {
            absolutePath = file.getAbsolutePath();
        }
        String str = this.dataSpec.key + TEMP_FILE;
        StringBuilder sb5 = new StringBuilder();
        sb5.append(absolutePath);
        String str2 = File.separator;
        sb5.append(str2);
        sb5.append(str);
        this.file = new File(sb5.toString());
        this.dstFile = new File(absolutePath + str2 + this.dataSpec.key + "." + this.extensionName);
        if (this.file.exists() && this.file.isFile()) {
            this.file.delete();
        }
    }
}

package com.tencent.qqmusic.mediaplayer.codec.mp3;

import com.tencent.qqmusic.mediaplayer.AudioInformation;

/* loaded from: classes23.dex */
public class MP3Information extends AudioInformation {
    private int bitratemode;
    private int encoding;
    private String error;
    private long fileLengthInBytes;
    private long firstFramePos;
    private long firstFrameSize;
    private long id3v2Size;
    private int layer;
    private long[] mTocTable;
    private int mpeg_version;
    private boolean success = false;

    public int getBitratemode() {
        return this.bitratemode;
    }

    public int getEncoding() {
        return this.encoding;
    }

    public String getError() {
        return this.error;
    }

    public long getFileLengthInBytes() {
        return this.fileLengthInBytes;
    }

    public long getFirstFramePos() {
        return this.firstFramePos;
    }

    public long getFirstFrameSize() {
        return this.firstFrameSize;
    }

    public long getId3v2Size() {
        return this.id3v2Size;
    }

    public int getLayer() {
        return this.layer;
    }

    public int getMpeg_version() {
        return this.mpeg_version;
    }

    public long[] getTocTable() {
        return this.mTocTable;
    }

    public boolean isSuccess() {
        return this.success;
    }

    public void setBitratemode(int i3) {
        this.bitratemode = i3;
    }

    public void setEncoding(int i3) {
        this.encoding = i3;
    }

    public void setError(String str) {
        this.error = str;
    }

    public void setSuccess(boolean z16) {
        this.success = z16;
    }

    public void setTocTable(long[] jArr) {
        this.mTocTable = jArr;
    }
}

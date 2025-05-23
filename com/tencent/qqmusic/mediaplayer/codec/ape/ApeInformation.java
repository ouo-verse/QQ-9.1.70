package com.tencent.qqmusic.mediaplayer.codec.ape;

import com.tencent.qqmusic.mediaplayer.AudioInformation;

/* compiled from: P */
/* loaded from: classes23.dex */
public class ApeInformation extends AudioInformation {
    private String album;
    private int apeFileVersion;
    private String artist;
    private long blocks;
    private int compressionLevel;
    private int frames;
    private String title;
    private String writer;

    public String getAlbum() {
        return this.album;
    }

    public String getArtist() {
        return this.artist;
    }

    public long getBlocks() {
        return this.blocks;
    }

    public int getCompressionLevel() {
        return this.compressionLevel;
    }

    public String getTitle() {
        return this.title;
    }

    public String getWriter() {
        return this.writer;
    }

    public void setAlbum(String str) {
        this.album = str;
    }

    public void setArtist(String str) {
        this.artist = str;
    }

    public void setBlocks(long j3) {
        this.blocks = j3;
    }

    public void setTitle(String str) {
        this.title = str;
    }

    public void setWriter(String str) {
        this.writer = str;
    }
}

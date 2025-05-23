package com.tencent.karaoke.decodesdk;

/* compiled from: P */
/* loaded from: classes7.dex */
public class M4AInformation {
    private String album;
    private String artist;
    private int bitrate;
    private int channels;
    private byte[] coverart;
    private String date;
    private long duration;
    private int frameSize;
    private int numSamples;
    private int sampleID;
    private long sampleRate;
    private String title;
    private int track;
    private String writer;

    public String getAlbum() {
        return this.album;
    }

    public String getArtist() {
        return this.artist;
    }

    public int getBitrate() {
        return this.bitrate;
    }

    public int getChannels() {
        return this.channels;
    }

    public byte[] getCoverart() {
        return this.coverart;
    }

    public String getDate() {
        return this.date;
    }

    public int getDuration() {
        return (int) this.duration;
    }

    public int getFrameSize() {
        return this.frameSize;
    }

    public int getNumSamples() {
        return this.numSamples;
    }

    public int getSampleID() {
        return this.sampleID;
    }

    public long getSampleRate() {
        return this.sampleRate;
    }

    public String getTitle() {
        return this.title;
    }

    public int getTrack() {
        return this.track;
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

    public void setBitrate(int i3) {
        this.bitrate = i3;
    }

    public void setChannels(int i3) {
        this.channels = i3;
    }

    public void setCoverart(byte[] bArr) {
        this.coverart = bArr;
    }

    public void setDate(String str) {
        this.date = str;
    }

    public void setDuration(long j3) {
        this.duration = j3;
    }

    public void setFrameSize(int i3) {
        this.frameSize = i3;
    }

    public void setNumSamples(int i3) {
        this.numSamples = i3;
    }

    public void setSampleID(int i3) {
        this.sampleID = i3;
    }

    public void setSampleRate(long j3) {
        this.sampleRate = j3;
    }

    public void setTitle(String str) {
        this.title = str;
    }

    public void setTrack(int i3) {
        this.track = i3;
    }

    public void setWriter(String str) {
        this.writer = str;
    }

    public String toString() {
        return "M4AInformation[sampleRate: " + this.sampleRate + ", duration: " + this.duration + ", bitrate: " + this.bitrate + ", channels: " + this.channels + ", track: " + this.track + ", numSamples: " + this.numSamples + ", sampleID: " + this.sampleID + ", frameSize: " + this.frameSize;
    }
}

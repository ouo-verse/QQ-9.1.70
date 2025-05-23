package com.tencent.mobileqq.activity.richmedia.p2veffect.model;

/* compiled from: P */
/* loaded from: classes10.dex */
public class MediaItem implements Cloneable {
    public static final int TYPE_IMAGE = 2;
    public static final int TYPE_VIDEO = 1;
    private long end;
    private int height;
    private String path;
    private int rotation;
    private long start;
    private int type;
    private int width;

    public MediaItem(String str, int i3, long j3, long j16) {
        this.rotation = 0;
        this.path = str;
        this.type = i3;
        this.start = j3;
        this.end = j16;
    }

    public long getDuration() {
        return this.end - this.start;
    }

    public long getEnd() {
        return this.end;
    }

    public int getHeight() {
        return this.height;
    }

    public String getPath() {
        return this.path;
    }

    public int getRotation() {
        return this.rotation;
    }

    public long getStart() {
        return this.start;
    }

    public int getType() {
        return this.type;
    }

    public int getWidth() {
        return this.width;
    }

    public void setDimen(int i3, int i16) {
        this.width = i3;
        this.height = i16;
    }

    public void setEnd(long j3) {
        this.end = j3;
    }

    public void setRotation(int i3) {
        this.rotation = i3;
        if (i3 == 90 || i3 == 270) {
            int i16 = this.width;
            this.width = this.height;
            this.height = i16;
        }
    }

    public void setStart(long j3) {
        this.start = j3;
    }

    public String toString() {
        return "[" + this.start + ", " + this.end + ", " + this.path + "], duration = " + (this.end - this.start);
    }

    /* renamed from: clone, reason: merged with bridge method [inline-methods] */
    public MediaItem m166clone() {
        try {
            return (MediaItem) super.clone();
        } catch (CloneNotSupportedException e16) {
            e16.printStackTrace();
            return null;
        }
    }

    public MediaItem(String str, int i3, long j3, long j16, int i16, int i17, int i18) {
        this.path = str;
        this.type = i3;
        this.start = j3;
        this.end = j16;
        this.width = i16;
        this.height = i17;
        this.rotation = i18;
    }
}

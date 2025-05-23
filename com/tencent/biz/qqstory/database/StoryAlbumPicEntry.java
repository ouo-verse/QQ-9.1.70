package com.tencent.biz.qqstory.database;

import com.tencent.mobileqq.persistence.Entity;

/* loaded from: classes5.dex */
public class StoryAlbumPicEntry extends Entity {
    public static final int PIC_STATE_BLACK_POI = 4;
    public static final int PIC_STATE_DEFAULT = 1;
    public static final int PIC_STATE_EXCULSIVE = 2;
    public long createTime;
    public String geohashString;
    public double gpsLat;
    public double gpsLng;
    public int height;
    public String mime;
    public int orientation;
    public String path;
    public long size;
    public int state;
    public String thumbPath;
    public int width;

    public static String getTimeSelection(long j3, long j16) {
        return " createTime >= " + j3 + " AND  createTime <= " + j16 + " AND  state <>4 AND  state <>2";
    }
}

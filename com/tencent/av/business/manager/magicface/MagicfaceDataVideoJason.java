package com.tencent.av.business.manager.magicface;

import android.graphics.Point;
import java.util.ArrayList;

/* compiled from: P */
/* loaded from: classes3.dex */
public class MagicfaceDataVideoJason {
    public static final String Background = "background/background.png";
    public static final int DECORATION_DURATION = 3;
    public static final int DECORATION_DURATION_MAX = 50000;
    public static final int MATCH_PARENT = -1;
    private static final String TAG = "MagicfaceDataJason";
    public static final String VIDEO_SRC = "video";
    public static final String VIDEO_SRC_MIRROR = "mirror";
    public static final String VIDEO_SRC_NORMAL = "normal";
    static Point emptyPoint = new Point(0, 0);
    String common_id;
    String src_prefix;
    String tips;
    boolean withdeco = false;
    boolean persistent = false;
    boolean hasMirrorRes = false;
    protected int location_x = 0;
    protected int location_y = 0;
    int width = 0;
    int height = 0;
    int fps = 8;
    int frame_count = 0;
    int repeat_count = 1;
    int exptype = 0;
    boolean hasbackground = false;
    public ArrayList<Point> pointArrayList = new ArrayList<>();
    int lastLocationIndex = -1;

    public Point getLocation(int i3) {
        int random;
        int size = this.pointArrayList.size();
        if (size == 0) {
            return emptyPoint;
        }
        if (com.tencent.av.utils.e.e(14) == 1) {
            random = i3;
        } else {
            random = (int) (Math.random() * size);
        }
        if (random == i3) {
            random++;
        }
        int i16 = random % size;
        this.lastLocationIndex = i16;
        return this.pointArrayList.get(i16);
    }

    public String toString() {
        return "MagicfaceDataVideoJason{src_prefix='" + this.src_prefix + "', withdeco=" + this.withdeco + ", persistent=" + this.persistent + ", hasMirrorRes=" + this.hasMirrorRes + ", location_x=" + this.location_x + ", location_y=" + this.location_y + ", width=" + this.width + ", height=" + this.height + ", fps=" + this.fps + ", frame_count=" + this.frame_count + ", repeat_count=" + this.repeat_count + ", exptype=" + this.exptype + ", common_id='" + this.common_id + "', hasbackground='" + this.hasbackground + "', pointArrayList='" + this.pointArrayList.size() + "'}";
    }
}

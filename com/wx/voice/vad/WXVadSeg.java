package com.wx.voice.vad;

import androidx.annotation.Nullable;

/* compiled from: P */
/* loaded from: classes22.dex */
public class WXVadSeg {
    public static final int ST_NSPK = 1;
    public static final int ST_SEG = 2;
    public static final int ST_SPK = 0;
    public static final int ST_UNKNOW = 3;
    public long mbtm;
    public long metm;
    public int stag;
    public int stype;

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        WXVadSeg wXVadSeg = (WXVadSeg) obj;
        if (this.mbtm == wXVadSeg.mbtm && this.metm == wXVadSeg.metm) {
            return true;
        }
        return false;
    }
}

package org.light.extDecoder.apng.chunk;

import android.text.TextUtils;

/* compiled from: P */
/* loaded from: classes29.dex */
public class Chunk {
    public int crc;
    public int fourcc;
    public int length;
    public int offset;

    public static int fourCCToInt(String str) {
        if (!TextUtils.isEmpty(str) && str.length() == 4) {
            return ((str.charAt(3) & '\u00ff') << 24) | (str.charAt(0) & '\u00ff') | ((str.charAt(1) & '\u00ff') << 8) | ((str.charAt(2) & '\u00ff') << 16);
        }
        return -1159790593;
    }
}

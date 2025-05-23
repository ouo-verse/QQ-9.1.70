package com.tencent.mobileqq.data;

import com.tencent.mobileqq.persistence.Entity;

/* compiled from: P */
/* loaded from: classes10.dex */
public class RecentEmotionData extends Entity {
    public static final int TYPE_CUSTOM_EMO = 3;
    public static final int TYPE_EMOJI_EMO = 4;
    public static final int TYPE_MARKET_FACE = 5;
    public static final int TYPE_SMALL_EMO = 6;
    public static final int TYPE_SYS_EMO = 0;
    public int emoId;
    public int emoIndex;
    public String emoPath;
    public int type;
    public String uin;
}

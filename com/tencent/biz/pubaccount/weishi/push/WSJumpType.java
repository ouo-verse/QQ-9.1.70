package com.tencent.biz.pubaccount.weishi.push;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* compiled from: P */
/* loaded from: classes32.dex */
public interface WSJumpType {
    public static final int TYPE_DRAMA_PREVIEW = 6;
    public static final int TYPE_DRAMA_PREVIEW_AND_CALL_WS = 7;
    public static final int TYPE_JUMP_FOLLOW = 5;
    public static final int TYPE_JUMP_H5 = 4;
    public static final int TYPE_JUMP_RECOMMEND = 1;
    public static final int TYPE_JUMP_VIDEO_LAYER = 2;
    public static final int TYPE_JUMP_WEISHI = 3;
    public static final int TYPE_OPEN_HOME_THEN_VERTICAL_VIDEO = 8;

    /* compiled from: P */
    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes32.dex */
    public @interface Type {
    }
}

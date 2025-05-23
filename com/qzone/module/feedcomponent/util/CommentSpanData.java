package com.qzone.module.feedcomponent.util;

import com.qzone.proxy.feedcomponent.model.ClickedComment;

/* compiled from: P */
/* loaded from: classes39.dex */
public class CommentSpanData {
    public final float clickPosY;
    public final ClickedComment comment;

    public CommentSpanData(ClickedComment clickedComment, float f16) {
        this.comment = clickedComment;
        this.clickPosY = f16;
    }
}

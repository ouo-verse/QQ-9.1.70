package com.tencent.biz.richframework.animation.transition;

import android.view.View;
import android.widget.ImageView;
import java.io.Serializable;

/* compiled from: P */
/* loaded from: classes5.dex */
public class TransitionBean implements Serializable {
    private int mEnterCoverHeight;
    private int mEnterCoverWidth;
    private TransitionRect mEnterViewRect;
    private String mImageUrl;
    private int mPrePageViewTag;
    private ImageView.ScaleType mScaleType;

    public int getEnterCoverHeight() {
        return this.mEnterCoverHeight;
    }

    public int getEnterCoverWidth() {
        return this.mEnterCoverWidth;
    }

    public TransitionRect getEnterViewRect() {
        return this.mEnterViewRect;
    }

    public String getImageUrl() {
        return this.mImageUrl;
    }

    public int getPrePageViewTag() {
        return this.mPrePageViewTag;
    }

    public ImageView.ScaleType getScaleType() {
        return this.mScaleType;
    }

    public TransitionBean setEnterViewRect(View view) {
        int[] iArr = new int[2];
        view.getLocationInWindow(iArr);
        int i3 = iArr[0];
        this.mEnterViewRect = new TransitionRect(i3, iArr[1], view.getWidth() + i3, iArr[1] + view.getHeight());
        this.mPrePageViewTag = TransitionHelper.g().addPrePageView(view);
        return this;
    }

    public TransitionBean setScaleType(ImageView.ScaleType scaleType) {
        this.mScaleType = scaleType;
        return this;
    }

    public TransitionBean setStImage(String str, int i3, int i16) {
        this.mImageUrl = str;
        this.mEnterCoverWidth = i3;
        this.mEnterCoverHeight = i16;
        return this;
    }

    public TransitionBean setEnterViewRect(int i3, int i16, int i17, int i18) {
        this.mEnterViewRect = new TransitionRect(i3, i16, i17 + i3, i18 + i16);
        return this;
    }
}

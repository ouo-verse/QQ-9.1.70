package com.tencent.biz.qqcircle.immersive.events;

import android.widget.ImageView;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;

/* compiled from: P */
/* loaded from: classes4.dex */
public class QFSTransitionChangeLocationEvent extends SimpleBaseEvent {
    private int mBottom;
    private String mCoverUrl;
    private int mLeft;
    private int mPageCode;
    private int mRight;
    private ImageView.ScaleType mScaleType;
    private int mTop;

    public int getBottom() {
        return this.mBottom;
    }

    public String getCoverUrl() {
        return this.mCoverUrl;
    }

    public int getLeft() {
        return this.mLeft;
    }

    public int getPageCode() {
        return this.mPageCode;
    }

    public int getRight() {
        return this.mRight;
    }

    public ImageView.ScaleType getScaleType() {
        return this.mScaleType;
    }

    public int getTop() {
        return this.mTop;
    }

    public void setBottom(int i3) {
        this.mBottom = i3;
    }

    public void setCoverUrl(String str) {
        this.mCoverUrl = str;
    }

    public void setLeft(int i3) {
        this.mLeft = i3;
    }

    public void setPageCode(int i3) {
        this.mPageCode = i3;
    }

    public void setRight(int i3) {
        this.mRight = i3;
    }

    public void setScaleType(ImageView.ScaleType scaleType) {
        this.mScaleType = scaleType;
    }

    public void setTop(int i3) {
        this.mTop = i3;
    }

    public String toString() {
        return "QFSTransitionChangeLocationEvent{mPageCode=" + this.mPageCode + ", mLeft=" + this.mLeft + ", mTop=" + this.mTop + ", mRight=" + this.mRight + ", mBottom=" + this.mBottom + ", mCoverUrl='" + this.mCoverUrl + "', mScaleType=" + this.mScaleType + '}';
    }
}

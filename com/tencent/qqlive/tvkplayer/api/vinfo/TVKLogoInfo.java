package com.tencent.qqlive.tvkplayer.api.vinfo;

import java.io.Serializable;

/* compiled from: P */
/* loaded from: classes23.dex */
public class TVKLogoInfo implements Serializable {
    private static final long serialVersionUID = -1;
    private int mAlpha = 100;
    private int mHeight;
    private int mId;
    private String mLogoHttpsUrl;
    private String mLogoUrl;
    private String mMd5;
    private boolean mShow;
    private int mVideoMinSideSize;
    private int mWidth;
    private int mX;
    private int mY;

    public int getAlpha() {
        return this.mAlpha;
    }

    public int getHeight() {
        return this.mHeight;
    }

    public int getId() {
        return this.mId;
    }

    public String getLogoHttpsUrl() {
        return this.mLogoHttpsUrl;
    }

    public String getLogoUrl() {
        return this.mLogoUrl;
    }

    public String getMd5() {
        return this.mMd5;
    }

    public boolean getShow() {
        return this.mShow;
    }

    public int getVideoMinSideSize() {
        return this.mVideoMinSideSize;
    }

    public int getWidth() {
        return this.mWidth;
    }

    public int getX() {
        return this.mX;
    }

    public int getY() {
        return this.mY;
    }

    public void setAlpha(int i3) {
        this.mAlpha = i3;
    }

    public void setHeight(int i3) {
        this.mHeight = i3;
    }

    public void setId(int i3) {
        this.mId = i3;
    }

    public void setLogoHttpsUrl(String str) {
        this.mLogoHttpsUrl = str;
    }

    public void setLogoUrl(String str) {
        this.mLogoUrl = str;
    }

    public void setMd5(String str) {
        this.mMd5 = str;
    }

    public void setShow(boolean z16) {
        this.mShow = z16;
    }

    public void setVideoMinSideSize(int i3) {
        this.mVideoMinSideSize = i3;
    }

    public void setWidth(int i3) {
        this.mWidth = i3;
    }

    public void setX(int i3) {
        this.mX = i3;
    }

    public void setY(int i3) {
        this.mY = i3;
    }
}

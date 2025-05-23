package com.tencent.qqmini.minigame.model;

import com.tencent.qqmini.sdk.launcher.model.MiniAppInfo;
import java.util.ArrayList;

/* compiled from: P */
/* loaded from: classes23.dex */
public class BlockAdInfo {
    public static final int BLOCK_AD_SAFE_GAP = 32;
    public static final int BLOCK_UPDATE_SIZE_LEFT = 1;
    public static final int BLOCK_UPDATE_SIZE_NO = -1;
    public static final int BLOCK_UPDATE_SIZE_TOP = 2;
    private static final String TAG = "BlockAdPositionInfo";
    private String mAdUnitId;
    private int mId;
    private int mLeft;
    private int mOri;
    private int mSize;
    private int mTop;
    private int mRealWidth = 0;
    private int mRealHeight = 0;
    private ArrayList<MiniAppInfo> mAdMiniAppInfoList = new ArrayList<>();

    public BlockAdInfo(String str, int i3, int i16, int i17, int i18, int i19) {
        this.mAdUnitId = "";
        this.mLeft = 0;
        this.mTop = 0;
        this.mSize = 0;
        this.mOri = 0;
        this.mId = 0;
        this.mAdUnitId = str;
        this.mLeft = i3;
        this.mTop = i16;
        this.mSize = i17;
        this.mOri = i18;
        this.mId = i19;
    }

    public String getAdUnitId() {
        return this.mAdUnitId;
    }

    public ArrayList<MiniAppInfo> getBlockAdInfo() {
        return this.mAdMiniAppInfoList;
    }

    public int getCompId() {
        return this.mId;
    }

    public int getLeft() {
        return this.mLeft;
    }

    public int getOri() {
        return this.mOri;
    }

    public int getRealHeight() {
        return this.mRealHeight;
    }

    public int getRealWidth() {
        return this.mRealWidth;
    }

    public int getSize() {
        return this.mSize;
    }

    public int getTop() {
        return this.mTop;
    }

    public boolean isValid() {
        int i3;
        if (this.mLeft >= 0 && this.mTop >= 0 && this.mSize > 0 && ((i3 = this.mOri) == 0 || i3 == 90)) {
            return true;
        }
        return false;
    }

    public void setLeft(int i3) {
        this.mLeft = i3;
    }

    public void setRealHeight(int i3) {
        this.mRealHeight = i3;
    }

    public void setRealWidth(int i3) {
        this.mRealWidth = i3;
    }

    public void setTop(int i3) {
        this.mTop = i3;
    }
}

package com.tencent.biz.qqcircle.beans;

/* compiled from: P */
/* loaded from: classes4.dex */
public class QFSNegativeItemInfo {
    public static final int FEEDBACK_QUESTION = 2;
    public static final int ITEM_TYPE_DETAIL = -102;
    public static final int ITEM_TYPE_TITLE = -101;
    public static final int NOT_WANT_WATCH = 1;
    private int mCategoryType;
    private boolean mIsSelected;
    private int mItemType;
    private String mSubTitle;
    private String mTitle;

    public QFSNegativeItemInfo(int i3, String str, int i16) {
        this.mItemType = i3;
        this.mTitle = str;
        this.mCategoryType = i16;
    }

    public int getCategoryType() {
        return this.mCategoryType;
    }

    public int getItemType() {
        return this.mItemType;
    }

    public String getSubTitle() {
        return this.mSubTitle;
    }

    public String getTitle() {
        return this.mTitle;
    }

    public boolean isSelected() {
        return this.mIsSelected;
    }

    public void setCategoryType(int i3) {
        this.mCategoryType = i3;
    }

    public void setSelected(boolean z16) {
        this.mIsSelected = z16;
    }

    public void setSubTitle(String str) {
        this.mSubTitle = str;
    }

    public void setTitle(String str) {
        this.mTitle = str;
    }
}

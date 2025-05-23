package com.tencent.richframework.data.base;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* compiled from: P */
/* loaded from: classes25.dex */
public class UIStateData<T> {
    private T mData;
    private ModifyListRecord mModifyRecord;
    private int mPos;
    private long mRetCode;
    private int mTop;
    private int mType;
    private int mUIState;
    private String mMsg = null;
    private byte[] mExtraByte = null;
    private boolean mIsLoadMore = false;
    private boolean mIsUpTurning = false;
    private boolean mIsFinish = false;
    private boolean mIsFakeData = false;
    public Map<String, Object> mExtraData = new ConcurrentHashMap();

    /* compiled from: P */
    /* loaded from: classes25.dex */
    public static class ModifyListRecord {
        private final int mItemCount;
        private final int mModifyType;
        private final int mStartPosition;

        ModifyListRecord(int i3, int i16, int i17) {
            this.mModifyType = i3;
            this.mStartPosition = i16;
            this.mItemCount = i17;
        }

        public static ModifyListRecord obtainNotifyDataSetChanged() {
            return new ModifyListRecord(0, -1, -1);
        }

        public static ModifyListRecord obtainNotifyItemRangeChange(int i3, int i16) {
            return new ModifyListRecord(1, i3, i16);
        }

        public static ModifyListRecord obtainNotifyItemRangeInsert(int i3, int i16) {
            return new ModifyListRecord(2, i3, i16);
        }

        public static ModifyListRecord obtainNotifyItemRangeRemoved(int i3, int i16) {
            return new ModifyListRecord(3, i3, i16);
        }

        public static ModifyListRecord obtainSelectedPositionChanged(int i3) {
            return new ModifyListRecord(4, i3, -1);
        }

        public int getModifyType() {
            return this.mModifyType;
        }

        public int getStartPosition() {
            return this.mStartPosition;
        }
    }

    UIStateData(int i3) {
        this.mUIState = i3;
    }

    @Deprecated
    public static <T> UIStateData<T> obtainDelete() {
        return new UIStateData<>(6);
    }

    @Deprecated
    public static <T> UIStateData<T> obtainEmpty() {
        return new UIStateData<>(0);
    }

    @Deprecated
    public static <T> UIStateData<T> obtainError(String str) {
        return new UIStateData(4).setMsg(str);
    }

    @Deprecated
    public static <T> UIStateData<T> obtainInsert(int i3) {
        return new UIStateData(8).setPos(i3);
    }

    @Deprecated
    public static <T> UIStateData<T> obtainLoading() {
        return new UIStateData<>(1);
    }

    @Deprecated
    public static <T> UIStateData<T> obtainModify() {
        return new UIStateData<>(7);
    }

    @Deprecated
    public static <T> UIStateData<T> obtainResumeCache(int i3, int i16) {
        return new UIStateData(5).setPos(i3).setTop(i16);
    }

    @Deprecated
    public static <T> UIStateData<T> obtainSuccess(boolean z16) {
        int i3;
        if (z16) {
            i3 = 2;
        } else {
            i3 = 3;
        }
        return new UIStateData<>(i3);
    }

    public UIStateData<T> copy() {
        UIStateData<T> uIStateData = new UIStateData<>(getState());
        uIStateData.setMsg(getMsg()).setDataList(getData()).setData(getIsLoadMore(), getData()).setType(getType()).setLatestModifyRecord(getLatestModifyRecord()).setExtraByte(getExtraType()).setFakeData(isFakeData()).setFinish(getIsFinish()).setLoadMore(getIsLoadMore()).setPos(getPos()).setRetCode(getRetCode()).setTop(getTop());
        return uIStateData;
    }

    public T getData() {
        return this.mData;
    }

    public byte[] getExtraType() {
        return this.mExtraByte;
    }

    public boolean getIsFinish() {
        return this.mIsFinish;
    }

    public boolean getIsLoadMore() {
        return this.mIsLoadMore;
    }

    public boolean getIsUpTurning() {
        return this.mIsUpTurning;
    }

    public ModifyListRecord getLatestModifyRecord() {
        return this.mModifyRecord;
    }

    public String getMsg() {
        return this.mMsg;
    }

    public int getPos() {
        return this.mPos;
    }

    public long getRetCode() {
        return this.mRetCode;
    }

    public int getState() {
        return this.mUIState;
    }

    public int getTop() {
        return this.mTop;
    }

    public int getType() {
        return this.mType;
    }

    public boolean isCacheData() {
        if (this.mUIState == 2) {
            return true;
        }
        return false;
    }

    @Deprecated
    public boolean isFakeData() {
        return this.mIsFakeData;
    }

    public boolean isLoading() {
        if (this.mUIState == 1) {
            return true;
        }
        return false;
    }

    public UIStateData<T> setData(boolean z16, T t16) {
        this.mIsLoadMore = z16;
        this.mData = t16;
        return this;
    }

    public UIStateData<T> setDataList(T t16) {
        this.mData = t16;
        return this;
    }

    @Deprecated
    public UIStateData<T> setExtraByte(byte[] bArr) {
        this.mExtraByte = bArr;
        return this;
    }

    @Deprecated
    public UIStateData<T> setFakeData(boolean z16) {
        this.mIsFakeData = z16;
        return this;
    }

    public UIStateData<T> setFinish(boolean z16) {
        this.mIsFinish = z16;
        return this;
    }

    public UIStateData<T> setLatestModifyRecord(ModifyListRecord modifyListRecord) {
        this.mModifyRecord = modifyListRecord;
        return this;
    }

    public UIStateData<T> setLoadMore(boolean z16) {
        this.mIsLoadMore = z16;
        return this;
    }

    public void setLoadingState() {
        this.mUIState = 1;
    }

    @Deprecated
    public UIStateData<T> setMsg(String str) {
        this.mMsg = str;
        return this;
    }

    public UIStateData<T> setPos(int i3) {
        this.mPos = i3;
        return this;
    }

    public UIStateData<T> setRetCode(long j3) {
        this.mRetCode = j3;
        return this;
    }

    public void setState(int i3) {
        this.mUIState = i3;
    }

    @Deprecated
    public UIStateData<T> setTop(int i3) {
        this.mTop = i3;
        return this;
    }

    @Deprecated
    public UIStateData<T> setType(int i3) {
        this.mType = i3;
        return this;
    }

    public UIStateData<T> setUpTurning(boolean z16) {
        this.mIsUpTurning = z16;
        return this;
    }
}

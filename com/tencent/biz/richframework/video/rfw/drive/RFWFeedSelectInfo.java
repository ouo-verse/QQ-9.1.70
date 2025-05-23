package com.tencent.biz.richframework.video.rfw.drive;

import android.text.TextUtils;
import androidx.recyclerview.widget.RecyclerView;

/* compiled from: P */
/* loaded from: classes5.dex */
public class RFWFeedSelectInfo {
    private boolean mIsReselected;
    private boolean mIsScrollToNext;
    private boolean mIsSelectedInfo;
    private int mPosition;
    private String mSelectType;
    private String mSelectedTag;
    private RecyclerView.ViewHolder mSelectedViewHolder;
    private String mUnSelectedTag;
    private String mUnSelectedType;
    private int mNextPosition = -1;
    private boolean isFullVideo = false;

    public RFWFeedSelectInfo(int i3) {
        this.mPosition = i3;
    }

    public RFWFeedSelectInfo copy(RFWFeedSelectInfo rFWFeedSelectInfo) {
        if (rFWFeedSelectInfo == null) {
            return this;
        }
        this.mSelectType = rFWFeedSelectInfo.getSelectedType();
        this.mUnSelectedType = rFWFeedSelectInfo.getUnSelectedType();
        this.mPosition = rFWFeedSelectInfo.getPosition();
        this.mNextPosition = rFWFeedSelectInfo.getNextPosition();
        this.isFullVideo = rFWFeedSelectInfo.isFullVideo();
        this.mIsReselected = rFWFeedSelectInfo.isIsReselected();
        this.mSelectedTag = rFWFeedSelectInfo.getSelectedTag();
        this.mUnSelectedType = rFWFeedSelectInfo.getUnSelectedType();
        this.mIsScrollToNext = rFWFeedSelectInfo.isScrollToNext();
        return this;
    }

    public int getNextPosition() {
        return this.mNextPosition;
    }

    public int getPosition() {
        return this.mPosition;
    }

    public RecyclerView.ViewHolder getSelectedHolder() {
        return this.mSelectedViewHolder;
    }

    public String getSelectedTag() {
        if (TextUtils.isEmpty(this.mSelectedTag)) {
            return "";
        }
        return this.mSelectedTag;
    }

    public String getSelectedType() {
        return this.mSelectType;
    }

    public String getUnSelectedTag() {
        if (TextUtils.isEmpty(this.mUnSelectedTag)) {
            return "";
        }
        return this.mUnSelectedTag;
    }

    public String getUnSelectedType() {
        return this.mUnSelectedType;
    }

    public boolean isFullVideo() {
        return this.isFullVideo;
    }

    public boolean isIsReselected() {
        return this.mIsReselected;
    }

    public boolean isScrollToNext() {
        return this.mIsScrollToNext;
    }

    public RFWFeedSelectInfo setFullVideo(boolean z16) {
        this.isFullVideo = z16;
        return this;
    }

    public RFWFeedSelectInfo setIsReselected(boolean z16) {
        this.mIsReselected = z16;
        return this;
    }

    public RFWFeedSelectInfo setIsScrollToNext(boolean z16) {
        this.mIsScrollToNext = z16;
        return this;
    }

    public RFWFeedSelectInfo setNextPosition(int i3) {
        this.mNextPosition = i3;
        return this;
    }

    public RFWFeedSelectInfo setSelectedHolder(RecyclerView.ViewHolder viewHolder) {
        this.mSelectedViewHolder = viewHolder;
        return this;
    }

    public RFWFeedSelectInfo setSelectedType(String str) {
        this.mSelectType = str;
        this.mIsSelectedInfo = true;
        return this;
    }

    public RFWFeedSelectInfo setUnSelectedType(String str) {
        this.mUnSelectedType = str;
        this.mIsSelectedInfo = false;
        return this;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer("QFSFeedSelectInfo{");
        stringBuffer.append("mIsSelectedInfo=");
        stringBuffer.append(this.mIsSelectedInfo);
        stringBuffer.append(", mSelectType='");
        stringBuffer.append(this.mSelectType);
        stringBuffer.append('\'');
        stringBuffer.append(", mUnSelectedType='");
        stringBuffer.append(this.mUnSelectedType);
        stringBuffer.append('\'');
        stringBuffer.append(", mPosition=");
        stringBuffer.append(this.mPosition);
        stringBuffer.append(", mNextPosition=");
        stringBuffer.append(this.mNextPosition);
        stringBuffer.append(", isFullVideo=");
        stringBuffer.append(this.isFullVideo);
        stringBuffer.append(", mIsReselected=");
        stringBuffer.append(this.mIsReselected);
        stringBuffer.append(", mSelectedTag='");
        stringBuffer.append(this.mSelectedTag);
        stringBuffer.append('\'');
        stringBuffer.append(", mUnSelectedTag='");
        stringBuffer.append(this.mUnSelectedTag);
        stringBuffer.append('\'');
        stringBuffer.append('}');
        return stringBuffer.toString();
    }

    public RFWFeedSelectInfo updateSelectedTag(String str) {
        this.mSelectedTag = str;
        return this;
    }

    public RFWFeedSelectInfo updateUnSelectedTag(String str) {
        this.mUnSelectedTag = str;
        return this;
    }
}

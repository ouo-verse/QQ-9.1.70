package com.tencent.qqnt.kernel.nativeinterface;

import java.util.ArrayList;

/* compiled from: P */
/* loaded from: classes24.dex */
public final class UfsResultItemGroup {
    public int groupExtraFlag;
    public long groupMask;
    public int hideTitle;
    public int hideTitleBlankView;
    public int highlightTitleKeyword;
    public int isBigPic;
    public int isEnd;
    public long totalResultCount;
    public String groupName = "";
    public ArrayList<UfsResultItem> resultItems = new ArrayList<>();
    public String moreUrl = "";
    public String moreName = "";
    public String groupFooterName = "";
    public String groupFooterJumpUrl = "";
    public byte[] sessionInfo = new byte[0];
    public String layoutName = "";
    public ArrayList<String> highlightWordsList = new ArrayList<>();

    public int getGroupExtraFlag() {
        return this.groupExtraFlag;
    }

    public String getGroupFooterJumpUrl() {
        return this.groupFooterJumpUrl;
    }

    public String getGroupFooterName() {
        return this.groupFooterName;
    }

    public long getGroupMask() {
        return this.groupMask;
    }

    public String getGroupName() {
        return this.groupName;
    }

    public int getHideTitle() {
        return this.hideTitle;
    }

    public int getHideTitleBlankView() {
        return this.hideTitleBlankView;
    }

    public int getHighlightTitleKeyword() {
        return this.highlightTitleKeyword;
    }

    public ArrayList<String> getHighlightWordsList() {
        return this.highlightWordsList;
    }

    public int getIsBigPic() {
        return this.isBigPic;
    }

    public int getIsEnd() {
        return this.isEnd;
    }

    public String getLayoutName() {
        return this.layoutName;
    }

    public String getMoreName() {
        return this.moreName;
    }

    public String getMoreUrl() {
        return this.moreUrl;
    }

    public ArrayList<UfsResultItem> getResultItems() {
        return this.resultItems;
    }

    public byte[] getSessionInfo() {
        return this.sessionInfo;
    }

    public long getTotalResultCount() {
        return this.totalResultCount;
    }

    public String toString() {
        return "UfsResultItemGroup{groupMask=" + this.groupMask + ",groupName=" + this.groupName + ",resultItems=" + this.resultItems + ",totalResultCount=" + this.totalResultCount + ",moreUrl=" + this.moreUrl + ",moreName=" + this.moreName + ",hideTitle=" + this.hideTitle + ",highlightTitleKeyword=" + this.highlightTitleKeyword + ",hideTitleBlankView=" + this.hideTitleBlankView + ",groupFooterName=" + this.groupFooterName + ",groupFooterJumpUrl=" + this.groupFooterJumpUrl + ",groupExtraFlag=" + this.groupExtraFlag + ",isEnd=" + this.isEnd + ",sessionInfo=" + this.sessionInfo + ",layoutName=" + this.layoutName + ",highlightWordsList=" + this.highlightWordsList + ",isBigPic=" + this.isBigPic + ",}";
    }
}

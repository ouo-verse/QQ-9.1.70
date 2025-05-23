package com.tencent.qqnt.kernel.nativeinterface;

import java.util.ArrayList;

/* compiled from: P */
/* loaded from: classes24.dex */
public final class SearchMiniAppDetail {
    public int miniAppType;
    public SearchIcon icon = new SearchIcon();
    public SearchText title = new SearchText();
    public ArrayList<SearchIcon> tagList = new ArrayList<>();
    public SearchText adInfo = new SearchText();
    public SearchText subTitle = new SearchText();
    public SearchIcon subTitleTag = new SearchIcon();
    public SearchText userBehaviorLabel = new SearchText();
    public SearchText introduction = new SearchText();
    public ArrayList<SearchLabel> gameLabelList = new ArrayList<>();
    public SearchText gameUserBehaviorLabel = new SearchText();
    public SearchText operationInformationHighlight = new SearchText();
    public SearchText operationInformation = new SearchText();
    public ArrayList<SearchButton> buttonList = new ArrayList<>();
    public SearchReportInfo reportInfo = new SearchReportInfo();
    public SearchReportInfo backendReportInfo = new SearchReportInfo();
    public SearchIcon littleIcon = new SearchIcon();
    public SearchIcon rankLeftIcon = new SearchIcon();
    public SearchIcon rankRightIcon = new SearchIcon();

    public SearchText getAdInfo() {
        return this.adInfo;
    }

    public SearchReportInfo getBackendReportInfo() {
        return this.backendReportInfo;
    }

    public ArrayList<SearchButton> getButtonList() {
        return this.buttonList;
    }

    public ArrayList<SearchLabel> getGameLabelList() {
        return this.gameLabelList;
    }

    public SearchText getGameUserBehaviorLabel() {
        return this.gameUserBehaviorLabel;
    }

    public SearchIcon getIcon() {
        return this.icon;
    }

    public SearchText getIntroduction() {
        return this.introduction;
    }

    public SearchIcon getLittleIcon() {
        return this.littleIcon;
    }

    public int getMiniAppType() {
        return this.miniAppType;
    }

    public SearchText getOperationInformation() {
        return this.operationInformation;
    }

    public SearchText getOperationInformationHighlight() {
        return this.operationInformationHighlight;
    }

    public SearchIcon getRankLeftIcon() {
        return this.rankLeftIcon;
    }

    public SearchIcon getRankRightIcon() {
        return this.rankRightIcon;
    }

    public SearchReportInfo getReportInfo() {
        return this.reportInfo;
    }

    public SearchText getSubTitle() {
        return this.subTitle;
    }

    public SearchIcon getSubTitleTag() {
        return this.subTitleTag;
    }

    public ArrayList<SearchIcon> getTagList() {
        return this.tagList;
    }

    public SearchText getTitle() {
        return this.title;
    }

    public SearchText getUserBehaviorLabel() {
        return this.userBehaviorLabel;
    }

    public String toString() {
        return "SearchMiniAppDetail{icon=" + this.icon + ",title=" + this.title + ",tagList=" + this.tagList + ",adInfo=" + this.adInfo + ",subTitle=" + this.subTitle + ",subTitleTag=" + this.subTitleTag + ",userBehaviorLabel=" + this.userBehaviorLabel + ",introduction=" + this.introduction + ",gameLabelList=" + this.gameLabelList + ",gameUserBehaviorLabel=" + this.gameUserBehaviorLabel + ",operationInformationHighlight=" + this.operationInformationHighlight + ",operationInformation=" + this.operationInformation + ",buttonList=" + this.buttonList + ",miniAppType=" + this.miniAppType + ",reportInfo=" + this.reportInfo + ",backendReportInfo=" + this.backendReportInfo + ",littleIcon=" + this.littleIcon + ",rankLeftIcon=" + this.rankLeftIcon + ",rankRightIcon=" + this.rankRightIcon + ",}";
    }
}

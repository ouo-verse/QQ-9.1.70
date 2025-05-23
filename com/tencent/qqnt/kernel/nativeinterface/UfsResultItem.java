package com.tencent.qqnt.kernel.nativeinterface;

import java.util.ArrayList;

/* compiled from: P */
/* loaded from: classes24.dex */
public final class UfsResultItem {
    public float finalScore;
    public long groupMask;
    public int isBottom;
    public int isMultiPic;
    public int isTop;
    public int layoutId;
    public long resultItemType;
    public int seporatorType;
    public String resultId = "";
    public String name = "";
    public String picUrl = "";
    public String jmpUrl = "";
    public String word = "";
    public String bytesExtension = "";
    public ArrayList<UfsMeaning> meaningList = new ArrayList<>();
    public ArrayList<UfsSubItem> subItemList = new ArrayList<>();
    public byte[] layoutContent = new byte[0];
    public String dbgMsg = "";
    public String mlFormula = "";
    public ArrayList<UfsResultItem> subResultItems = new ArrayList<>();
    public byte[] reportExtData = new byte[0];
    public UfsSugWordInfo sugWordInfo = new UfsSugWordInfo();
    public String layoutName = "";
    public UfsLayoutContentCollections layoutContentObject = new UfsLayoutContentCollections();

    public String getBytesExtension() {
        return this.bytesExtension;
    }

    public String getDbgMsg() {
        return this.dbgMsg;
    }

    public float getFinalScore() {
        return this.finalScore;
    }

    public long getGroupMask() {
        return this.groupMask;
    }

    public int getIsBottom() {
        return this.isBottom;
    }

    public int getIsMultiPic() {
        return this.isMultiPic;
    }

    public int getIsTop() {
        return this.isTop;
    }

    public String getJmpUrl() {
        return this.jmpUrl;
    }

    public byte[] getLayoutContent() {
        return this.layoutContent;
    }

    public UfsLayoutContentCollections getLayoutContentObject() {
        return this.layoutContentObject;
    }

    public int getLayoutId() {
        return this.layoutId;
    }

    public String getLayoutName() {
        return this.layoutName;
    }

    public ArrayList<UfsMeaning> getMeaningList() {
        return this.meaningList;
    }

    public String getMlFormula() {
        return this.mlFormula;
    }

    public String getName() {
        return this.name;
    }

    public String getPicUrl() {
        return this.picUrl;
    }

    public byte[] getReportExtData() {
        return this.reportExtData;
    }

    public String getResultId() {
        return this.resultId;
    }

    public long getResultItemType() {
        return this.resultItemType;
    }

    public int getSeporatorType() {
        return this.seporatorType;
    }

    public ArrayList<UfsSubItem> getSubItemList() {
        return this.subItemList;
    }

    public ArrayList<UfsResultItem> getSubResultItems() {
        return this.subResultItems;
    }

    public UfsSugWordInfo getSugWordInfo() {
        return this.sugWordInfo;
    }

    public String getWord() {
        return this.word;
    }

    public String toString() {
        return "UfsResultItem{resultId=" + this.resultId + ",name=" + this.name + ",picUrl=" + this.picUrl + ",jmpUrl=" + this.jmpUrl + ",word=" + this.word + ",bytesExtension=" + this.bytesExtension + ",meaningList=" + this.meaningList + ",groupMask=" + this.groupMask + ",subItemList=" + this.subItemList + ",layoutId=" + this.layoutId + ",layoutContent=" + this.layoutContent + ",isTop=" + this.isTop + ",isBottom=" + this.isBottom + ",dbgMsg=" + this.dbgMsg + ",finalScore=" + this.finalScore + ",mlFormula=" + this.mlFormula + ",subResultItems=" + this.subResultItems + ",resultItemType=" + this.resultItemType + ",seporatorType=" + this.seporatorType + ",reportExtData=" + this.reportExtData + ",sugWordInfo=" + this.sugWordInfo + ",isMultiPic=" + this.isMultiPic + ",layoutName=" + this.layoutName + ",layoutContentObject=" + this.layoutContentObject + ",}";
    }
}

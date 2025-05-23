package com.tencent.qqnt.kernel.nativeinterface;

import java.util.ArrayList;

/* compiled from: P */
/* loaded from: classes24.dex */
public final class UfsDisResult {
    public int hasHeader;
    public int hideTopDivider;
    public int hotwordUpdateTs;
    public int type;
    public UfsDisTitleHeaderItem titleHeader = new UfsDisTitleHeaderItem();
    public ArrayList<UfsDisSubBusinessItem> subBusinessItems = new ArrayList<>();
    public ArrayList<UfsDisOperationItem> operationItems = new ArrayList<>();
    public ArrayList<UfsDisHotSearchItem> hotSearchItems = new ArrayList<>();
    public UfsDisSpecialTopic specialTopicItem = new UfsDisSpecialTopic();
    public UfsDisGifInfoItem hotWordGifItem = new UfsDisGifInfoItem();
    public UfsDisGifInfoItem hotSearchGifItem = new UfsDisGifInfoItem();
    public byte[] resultExt = new byte[0];
    public UfsDisGuessWantSearch guessWantItems = new UfsDisGuessWantSearch();
    public UfsDisOperationHotSearch operationHotSearchItems = new UfsDisOperationHotSearch();

    public UfsDisGuessWantSearch getGuessWantItems() {
        return this.guessWantItems;
    }

    public int getHasHeader() {
        return this.hasHeader;
    }

    public int getHideTopDivider() {
        return this.hideTopDivider;
    }

    public UfsDisGifInfoItem getHotSearchGifItem() {
        return this.hotSearchGifItem;
    }

    public ArrayList<UfsDisHotSearchItem> getHotSearchItems() {
        return this.hotSearchItems;
    }

    public UfsDisGifInfoItem getHotWordGifItem() {
        return this.hotWordGifItem;
    }

    public int getHotwordUpdateTs() {
        return this.hotwordUpdateTs;
    }

    public UfsDisOperationHotSearch getOperationHotSearchItems() {
        return this.operationHotSearchItems;
    }

    public ArrayList<UfsDisOperationItem> getOperationItems() {
        return this.operationItems;
    }

    public byte[] getResultExt() {
        return this.resultExt;
    }

    public UfsDisSpecialTopic getSpecialTopicItem() {
        return this.specialTopicItem;
    }

    public ArrayList<UfsDisSubBusinessItem> getSubBusinessItems() {
        return this.subBusinessItems;
    }

    public UfsDisTitleHeaderItem getTitleHeader() {
        return this.titleHeader;
    }

    public int getType() {
        return this.type;
    }

    public String toString() {
        return "UfsDisResult{type=" + this.type + ",hasHeader=" + this.hasHeader + ",titleHeader=" + this.titleHeader + ",hideTopDivider=" + this.hideTopDivider + ",hotwordUpdateTs=" + this.hotwordUpdateTs + ",subBusinessItems=" + this.subBusinessItems + ",operationItems=" + this.operationItems + ",hotSearchItems=" + this.hotSearchItems + ",specialTopicItem=" + this.specialTopicItem + ",hotWordGifItem=" + this.hotWordGifItem + ",hotSearchGifItem=" + this.hotSearchGifItem + ",resultExt=" + this.resultExt + ",guessWantItems=" + this.guessWantItems + ",operationHotSearchItems=" + this.operationHotSearchItems + ",}";
    }
}

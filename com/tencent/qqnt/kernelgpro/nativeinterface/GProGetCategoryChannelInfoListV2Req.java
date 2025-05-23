package com.tencent.qqnt.kernelgpro.nativeinterface;

/* loaded from: classes24.dex */
public final class GProGetCategoryChannelInfoListV2Req {
    public boolean filterCategorySchedule;
    public boolean filterFeedSquare;
    public boolean filterNormalCategoryChannel;
    public boolean filterTheAllBoard;
    public long guildId;
    public boolean isPinFeedSquareToTop;

    public GProGetCategoryChannelInfoListV2Req() {
    }

    public boolean getFilterCategorySchedule() {
        return this.filterCategorySchedule;
    }

    public boolean getFilterFeedSquare() {
        return this.filterFeedSquare;
    }

    public boolean getFilterNormalCategoryChannel() {
        return this.filterNormalCategoryChannel;
    }

    public boolean getFilterTheAllBoard() {
        return this.filterTheAllBoard;
    }

    public long getGuildId() {
        return this.guildId;
    }

    public boolean getIsPinFeedSquareToTop() {
        return this.isPinFeedSquareToTop;
    }

    public void setFilterCategorySchedule(boolean z16) {
        this.filterCategorySchedule = z16;
    }

    public void setFilterFeedSquare(boolean z16) {
        this.filterFeedSquare = z16;
    }

    public void setFilterNormalCategoryChannel(boolean z16) {
        this.filterNormalCategoryChannel = z16;
    }

    public void setFilterTheAllBoard(boolean z16) {
        this.filterTheAllBoard = z16;
    }

    public void setGuildId(long j3) {
        this.guildId = j3;
    }

    public void setIsPinFeedSquareToTop(boolean z16) {
        this.isPinFeedSquareToTop = z16;
    }

    public String toString() {
        return "GProGetCategoryChannelInfoListV2Req{guildId=" + this.guildId + ",filterFeedSquare=" + this.filterFeedSquare + ",filterTheAllBoard=" + this.filterTheAllBoard + ",filterNormalCategoryChannel=" + this.filterNormalCategoryChannel + ",isPinFeedSquareToTop=" + this.isPinFeedSquareToTop + ",filterCategorySchedule=" + this.filterCategorySchedule + ",}";
    }

    public GProGetCategoryChannelInfoListV2Req(long j3, boolean z16, boolean z17, boolean z18, boolean z19) {
        this.guildId = j3;
        this.filterFeedSquare = z16;
        this.filterTheAllBoard = z17;
        this.filterNormalCategoryChannel = z18;
        this.isPinFeedSquareToTop = z19;
    }
}

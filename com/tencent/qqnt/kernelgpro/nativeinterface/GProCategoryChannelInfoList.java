package com.tencent.qqnt.kernelgpro.nativeinterface;

import com.tencent.mobileqq.haoliyou.JefsClass;
import java.util.ArrayList;

/* loaded from: classes24.dex */
public final class GProCategoryChannelInfoList {
    public long categoryId;
    public int categoryType;
    public boolean closeSwitch;
    public boolean folded;
    public int urlType;
    public String name = "";
    public ArrayList<GProChannel> channelInfoList = new ArrayList<>();
    public String categoryAlias = "";
    public String url = "";
    public GProNavigationV2Info navigation = new GProNavigationV2Info();

    public String getCategoryAlias() {
        return this.categoryAlias;
    }

    public long getCategoryId() {
        return this.categoryId;
    }

    public int getCategoryType() {
        return this.categoryType;
    }

    public ArrayList<GProChannel> getChannelInfoList() {
        return this.channelInfoList;
    }

    public boolean getCloseSwitch() {
        return this.closeSwitch;
    }

    public boolean getFolded() {
        return this.folded;
    }

    public String getName() {
        return this.name;
    }

    public GProNavigationV2Info getNavigation() {
        return this.navigation;
    }

    public String getUrl() {
        return this.url;
    }

    public int getUrlType() {
        return this.urlType;
    }

    public String toString() {
        return "GProCategoryChannelInfoList{name=" + this.name + ",categoryId=" + this.categoryId + ",channelInfoList=" + this.channelInfoList + ",folded=" + this.folded + ",categoryType=" + this.categoryType + ",closeSwitch=" + this.closeSwitch + ",categoryAlias=" + this.categoryAlias + JefsClass.INDEX_URL + this.url + ",urlType=" + this.urlType + ",navigation=" + this.navigation + ",}";
    }
}

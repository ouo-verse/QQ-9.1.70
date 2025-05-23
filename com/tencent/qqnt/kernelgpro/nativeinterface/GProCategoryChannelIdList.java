package com.tencent.qqnt.kernelgpro.nativeinterface;

import com.tencent.mobileqq.haoliyou.JefsClass;
import java.io.Serializable;
import java.util.ArrayList;

/* loaded from: classes24.dex */
public final class GProCategoryChannelIdList implements Serializable {
    public String categoryAlias;
    public long categoryId;
    public int categoryType;
    public ArrayList<Long> channelList;
    public boolean closeSwitch;
    public boolean folded;
    public String name;
    long serialVersionUID;
    public String url;
    public int urlType;

    public GProCategoryChannelIdList() {
        this.serialVersionUID = 1L;
        this.name = "";
        this.channelList = new ArrayList<>();
        this.categoryAlias = "";
        this.url = "";
    }

    public String getCategoryAlias() {
        return this.categoryAlias;
    }

    public long getCategoryId() {
        return this.categoryId;
    }

    public int getCategoryType() {
        return this.categoryType;
    }

    public ArrayList<Long> getChannelList() {
        return this.channelList;
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

    public String getUrl() {
        return this.url;
    }

    public int getUrlType() {
        return this.urlType;
    }

    public String toString() {
        return "GProCategoryChannelIdList{name=" + this.name + ",categoryId=" + this.categoryId + ",channelList=" + this.channelList + ",folded=" + this.folded + ",categoryType=" + this.categoryType + ",closeSwitch=" + this.closeSwitch + ",categoryAlias=" + this.categoryAlias + JefsClass.INDEX_URL + this.url + ",urlType=" + this.urlType + ",}";
    }

    public GProCategoryChannelIdList(String str, long j3, ArrayList<Long> arrayList, boolean z16, int i3, boolean z17, String str2, String str3, int i16) {
        this.serialVersionUID = 1L;
        this.name = "";
        new ArrayList();
        this.name = str;
        this.categoryId = j3;
        this.channelList = arrayList;
        this.folded = z16;
        this.categoryType = i3;
        this.closeSwitch = z17;
        this.categoryAlias = str2;
        this.url = str3;
        this.urlType = i16;
    }
}

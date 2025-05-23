package com.tencent.qqnt.kernelgpro.nativeinterface;

import java.io.Serializable;

/* loaded from: classes24.dex */
public final class GProRecommendCategory implements Serializable {
    public int categoryConfId;
    public int categoryId;
    public int categoryType;
    public String groupId;
    public boolean hasMore;
    public String name;
    long serialVersionUID;
    public String type;

    public GProRecommendCategory() {
        this.serialVersionUID = 1L;
        this.name = "";
        this.groupId = "";
        this.type = "";
    }

    public int getCategoryConfId() {
        return this.categoryConfId;
    }

    public int getCategoryId() {
        return this.categoryId;
    }

    public int getCategoryType() {
        return this.categoryType;
    }

    public String getGroupId() {
        return this.groupId;
    }

    public boolean getHasMore() {
        return this.hasMore;
    }

    public String getName() {
        return this.name;
    }

    public String getType() {
        return this.type;
    }

    public void setCategoryConfId(int i3) {
        this.categoryConfId = i3;
    }

    public void setCategoryId(int i3) {
        this.categoryId = i3;
    }

    public void setCategoryType(int i3) {
        this.categoryType = i3;
    }

    public void setGroupId(String str) {
        this.groupId = str;
    }

    public void setHasMore(boolean z16) {
        this.hasMore = z16;
    }

    public void setName(String str) {
        this.name = str;
    }

    public void setType(String str) {
        this.type = str;
    }

    public String toString() {
        return "GProRecommendCategory{name=" + this.name + ",categoryId=" + this.categoryId + ",groupId=" + this.groupId + ",hasMore=" + this.hasMore + ",type=" + this.type + ",categoryType=" + this.categoryType + ",categoryConfId=" + this.categoryConfId + ",}";
    }

    public GProRecommendCategory(String str, int i3, String str2, boolean z16, String str3, int i16) {
        this.serialVersionUID = 1L;
        this.name = str;
        this.categoryId = i3;
        this.groupId = str2;
        this.hasMore = z16;
        this.type = str3;
        this.categoryType = i16;
    }
}

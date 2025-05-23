package com.tencent.qqnt.kernelgpro.nativeinterface;

import java.io.Serializable;
import java.util.ArrayList;

/* loaded from: classes24.dex */
public final class GProStRichTextCardContent implements Serializable {
    public int originFrom;
    public int type;
    long serialVersionUID = 1;
    public String cardId = "";
    public String logoUrl = "";
    public String title = "";
    public String stringAbstract = "";
    public String redirectUrl = "";
    public ArrayList<String> buttonTextList = new ArrayList<>();

    public ArrayList<String> getButtonTextList() {
        return this.buttonTextList;
    }

    public String getCardId() {
        return this.cardId;
    }

    public String getLogoUrl() {
        return this.logoUrl;
    }

    public int getOriginFrom() {
        return this.originFrom;
    }

    public String getRedirectUrl() {
        return this.redirectUrl;
    }

    public String getStringAbstract() {
        return this.stringAbstract;
    }

    public String getTitle() {
        return this.title;
    }

    public int getType() {
        return this.type;
    }

    public String toString() {
        return "GProStRichTextCardContent{type=" + this.type + ",cardId=" + this.cardId + ",originFrom=" + this.originFrom + ",logoUrl=" + this.logoUrl + ",title=" + this.title + ",stringAbstract=" + this.stringAbstract + ",redirectUrl=" + this.redirectUrl + ",buttonTextList=" + this.buttonTextList + ",}";
    }
}

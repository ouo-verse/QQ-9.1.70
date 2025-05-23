package com.tencent.qqnt.kernelgpro.nativeinterface;

import java.util.ArrayList;

/* loaded from: classes24.dex */
public final class GProFetchShareInfo0x10c3Req {
    public byte[] businessParam;
    public int businessType;
    public GProCmd0x10c3Filter filter;
    public boolean isEncry;
    public boolean isShortLink;
    public ArrayList<GProURLParam> urlParams;

    public GProFetchShareInfo0x10c3Req() {
        this.businessParam = new byte[0];
        this.urlParams = new ArrayList<>();
        this.filter = new GProCmd0x10c3Filter();
    }

    public byte[] getBusinessParam() {
        return this.businessParam;
    }

    public int getBusinessType() {
        return this.businessType;
    }

    public GProCmd0x10c3Filter getFilter() {
        return this.filter;
    }

    public boolean getIsEncry() {
        return this.isEncry;
    }

    public boolean getIsShortLink() {
        return this.isShortLink;
    }

    public ArrayList<GProURLParam> getUrlParams() {
        return this.urlParams;
    }

    public void setBusinessParam(byte[] bArr) {
        this.businessParam = bArr;
    }

    public void setBusinessType(int i3) {
        this.businessType = i3;
    }

    public void setFilter(GProCmd0x10c3Filter gProCmd0x10c3Filter) {
        this.filter = gProCmd0x10c3Filter;
    }

    public void setIsEncry(boolean z16) {
        this.isEncry = z16;
    }

    public void setIsShortLink(boolean z16) {
        this.isShortLink = z16;
    }

    public void setUrlParams(ArrayList<GProURLParam> arrayList) {
        this.urlParams = arrayList;
    }

    public String toString() {
        return "GProFetchShareInfo0x10c3Req{businessType=" + this.businessType + ",businessParam=" + this.businessParam + ",isShortLink=" + this.isShortLink + ",urlParams=" + this.urlParams + ",filter=" + this.filter + ",isEncry=" + this.isEncry + ",}";
    }

    public GProFetchShareInfo0x10c3Req(int i3, byte[] bArr, boolean z16, ArrayList<GProURLParam> arrayList, GProCmd0x10c3Filter gProCmd0x10c3Filter) {
        this.businessParam = new byte[0];
        this.urlParams = new ArrayList<>();
        new GProCmd0x10c3Filter();
        this.businessType = i3;
        this.businessParam = bArr;
        this.isShortLink = z16;
        this.urlParams = arrayList;
        this.filter = gProCmd0x10c3Filter;
    }
}

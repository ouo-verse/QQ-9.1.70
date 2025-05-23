package com.tencent.gdt.tangram.ad.qzone.embedded;

import com.qzone.proxy.feedcomponent.model.BusinessFeedData;

/* compiled from: P */
/* loaded from: classes31.dex */
public class a extends com.tencent.gdt.tangram.ad.qzone.b {
    public a(BusinessFeedData businessFeedData) {
        super(businessFeedData);
    }

    private boolean o() {
        BusinessFeedData businessFeedData = this.f108418a;
        return (businessFeedData == null || businessFeedData.getCellCornerAdv() == null) ? false : true;
    }

    @Override // com.tencent.gdt.tangram.ad.qzone.b
    public int a(int i3, Object obj) {
        if (n()) {
            return -1;
        }
        if (i3 == 5 && this.f108418a.getCellCornerAdv() != null) {
            return this.f108418a.getCellCornerAdv().actiontype;
        }
        return super.a(i3, obj);
    }

    @Override // com.tencent.gdt.tangram.ad.qzone.b
    public String k(int i3, Object... objArr) {
        if (!n()) {
            return null;
        }
        if (this.f108418a.isAdvContainerThreeGridStyle() && this.f108418a.isAppAd() && this.f108418a.getOperationInfoV2() != null && i3 == 5) {
            return this.f108418a.getOperationInfoV2().actionUrl;
        }
        return super.k(i3, objArr);
    }

    @Override // com.tencent.gdt.tangram.ad.qzone.b
    protected boolean n() {
        BusinessFeedData businessFeedData;
        return p() || o() || ((businessFeedData = this.f108418a) != null && businessFeedData.isGDTAdvFeed());
    }

    public boolean p() {
        BusinessFeedData businessFeedData = this.f108418a;
        return businessFeedData != null && businessFeedData.isWindowAd();
    }
}

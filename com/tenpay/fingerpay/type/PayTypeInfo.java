package com.tenpay.fingerpay.type;

import com.tencent.mobileqq.kandian.base.image.api.IPublicAccountHttpDownloader;
import com.tenpay.sdk.util.QWSoterConstans;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\f\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0007R\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u001a\u0010\u0006\u001a\u00020\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\f\"\u0004\b\r\u0010\u000eR\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0002\u0010\f\"\u0004\b\u000f\u0010\u000eR\u0011\u0010\u0010\u001a\u00020\u00038F\u00a2\u0006\u0006\u001a\u0004\b\u0010\u0010\f\u00a8\u0006\u0011"}, d2 = {"Lcom/tenpay/fingerpay/type/PayTypeInfo;", "", "isCloseBtn", "", IPublicAccountHttpDownloader.BUSI_TYPE_PARAM_KEY, "", "isChosen", "(ZIZ)V", "getBusiType", "()I", "setBusiType", "(I)V", "()Z", "setChosen", "(Z)V", "setCloseBtn", "isValidBusiType", "qwallet-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes27.dex */
public final class PayTypeInfo {
    private int busiType;
    private boolean isChosen;
    private boolean isCloseBtn;

    public PayTypeInfo(boolean z16, int i3, boolean z17) {
        this.isCloseBtn = z16;
        this.busiType = i3;
        this.isChosen = z17;
    }

    public final int getBusiType() {
        return this.busiType;
    }

    /* renamed from: isChosen, reason: from getter */
    public final boolean getIsChosen() {
        return this.isChosen;
    }

    /* renamed from: isCloseBtn, reason: from getter */
    public final boolean getIsCloseBtn() {
        return this.isCloseBtn;
    }

    public final boolean isValidBusiType() {
        return QWSoterConstans.isValidBusiType(this.busiType);
    }

    public final void setBusiType(int i3) {
        this.busiType = i3;
    }

    public final void setChosen(boolean z16) {
        this.isChosen = z16;
    }

    public final void setCloseBtn(boolean z16) {
        this.isCloseBtn = z16;
    }
}

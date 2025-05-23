package com.tencent.mobileqq.vas;

import androidx.annotation.NonNull;

/* compiled from: P */
/* loaded from: classes20.dex */
public class BalanceExplainDialogData {
    public long coinBalance;
    public String descString;
    public long marketingBalance;
    public String marketingIconUrl;
    public String marketingName;
    public String moreAreaJumpUrl;

    public BalanceExplainDialogData(long j3, long j16, @NonNull String str, @NonNull String str2, @NonNull String str3, @NonNull String str4) {
        this.coinBalance = j3;
        this.marketingBalance = j16;
        this.descString = str;
        this.marketingName = str2;
        this.moreAreaJumpUrl = str3;
        this.marketingIconUrl = str4;
    }
}

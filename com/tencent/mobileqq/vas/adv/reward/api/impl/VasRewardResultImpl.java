package com.tencent.mobileqq.vas.adv.reward.api.impl;

import com.tencent.mobileqq.vas.adv.reward.api.IVasRewardResult;
import kotlin.Metadata;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u000f\u0018\u0000 \u000f2\u00020\u0001:\u0001\u0010B\u0007\u00a2\u0006\u0004\b\r\u0010\u000eJ\b\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0004\u001a\u00020\u0002H\u0016J\b\u0010\u0005\u001a\u00020\u0002H\u0016J\b\u0010\u0006\u001a\u00020\u0002H\u0016J\b\u0010\u0007\u001a\u00020\u0002H\u0016J\b\u0010\b\u001a\u00020\u0002H\u0016J\b\u0010\t\u001a\u00020\u0002H\u0016J\b\u0010\n\u001a\u00020\u0002H\u0016J\b\u0010\u000b\u001a\u00020\u0002H\u0016J\b\u0010\f\u001a\u00020\u0002H\u0016\u00a8\u0006\u0011"}, d2 = {"Lcom/tencent/mobileqq/vas/adv/reward/api/impl/VasRewardResultImpl;", "Lcom/tencent/mobileqq/vas/adv/reward/api/IVasRewardResult;", "", "_SUCCESS", "_BIZ_NO_AD", "_REQUEST_AD_ERROR", "_REPORT_AD_ERROR", "_NON_PROFITABLE", "_DEVICE_INFO_NULL", "_REQUEST_AD_RSP_ERROR", "_REPORT_AD_RSP_ERROR", "_ACTIVITY_IS_NULL", "_REPEATING_REQUEST_AD", "<init>", "()V", "Companion", "a", "vas-adv-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes20.dex */
public final class VasRewardResultImpl implements IVasRewardResult {
    public static final int ACTIVITY_IS_NULL = 8;
    public static final int BIZ_NO_AD = 1;
    public static final int DEVICE_INFO_NULL = 5;
    public static final int NON_PROFITABLE = 4;
    public static final int REPEATING_REQUEST_AD = 9;
    public static final int REPORT_AD_ERROR = 3;
    public static final int REPORT_AD_RSP_ERROR = 7;
    public static final int REQUEST_AD_ERROR = 2;
    public static final int REQUEST_AD_RSP_ERROR = 6;
    public static final int SUCCESS = 0;

    @Override // com.tencent.mobileqq.vas.adv.reward.api.IVasRewardResult
    public int _ACTIVITY_IS_NULL() {
        return 8;
    }

    @Override // com.tencent.mobileqq.vas.adv.reward.api.IVasRewardResult
    public int _BIZ_NO_AD() {
        return 1;
    }

    @Override // com.tencent.mobileqq.vas.adv.reward.api.IVasRewardResult
    public int _DEVICE_INFO_NULL() {
        return 5;
    }

    @Override // com.tencent.mobileqq.vas.adv.reward.api.IVasRewardResult
    public int _NON_PROFITABLE() {
        return 4;
    }

    @Override // com.tencent.mobileqq.vas.adv.reward.api.IVasRewardResult
    public int _REPEATING_REQUEST_AD() {
        return 9;
    }

    @Override // com.tencent.mobileqq.vas.adv.reward.api.IVasRewardResult
    public int _REPORT_AD_ERROR() {
        return 3;
    }

    @Override // com.tencent.mobileqq.vas.adv.reward.api.IVasRewardResult
    public int _REPORT_AD_RSP_ERROR() {
        return 7;
    }

    @Override // com.tencent.mobileqq.vas.adv.reward.api.IVasRewardResult
    public int _REQUEST_AD_ERROR() {
        return 2;
    }

    @Override // com.tencent.mobileqq.vas.adv.reward.api.IVasRewardResult
    public int _REQUEST_AD_RSP_ERROR() {
        return 6;
    }

    @Override // com.tencent.mobileqq.vas.adv.reward.api.IVasRewardResult
    public int _SUCCESS() {
        return 0;
    }
}

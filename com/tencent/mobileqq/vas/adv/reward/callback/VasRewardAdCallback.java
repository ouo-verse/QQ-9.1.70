package com.tencent.mobileqq.vas.adv.reward.callback;

import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J(\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0007H&\u00a8\u0006\t"}, d2 = {"Lcom/tencent/mobileqq/vas/adv/reward/callback/VasRewardAdCallback;", "", "onReward", "", "retCode", "", "requestBizBuff", "", "reportBizBuff", "vas-adv-api_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes20.dex */
public interface VasRewardAdCallback {

    /* compiled from: P */
    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes20.dex */
    public static final class DefaultImpls {
        public static /* synthetic */ void onReward$default(VasRewardAdCallback vasRewardAdCallback, int i3, byte[] bArr, byte[] bArr2, int i16, Object obj) {
            if (obj == null) {
                if ((i16 & 2) != 0) {
                    bArr = null;
                }
                if ((i16 & 4) != 0) {
                    bArr2 = null;
                }
                vasRewardAdCallback.onReward(i3, bArr, bArr2);
                return;
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: onReward");
        }
    }

    void onReward(int retCode, @Nullable byte[] requestBizBuff, @Nullable byte[] reportBizBuff);
}

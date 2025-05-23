package com.tencent.mobileqq.vas.pendant.drawable;

import com.tencent.mobileqq.vip.api.VipData;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0004\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\b\u0010\tJ\u0016\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004\u00a8\u0006\n"}, d2 = {"Lcom/tencent/mobileqq/vas/pendant/drawable/m;", "", "", "mNeedScaleDownVipNumber", "", "numAppId", "", "a", "<init>", "()V", "vas-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes20.dex */
public final class m {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final m f310515a = new m();

    m() {
    }

    public final float a(boolean mNeedScaleDownVipNumber, int numAppId) {
        if (numAppId == VipData.VipNumberInfo.APPID.Pendant.getId()) {
            if (!mNeedScaleDownVipNumber) {
                return 1.0f;
            }
            return 0.6f;
        }
        if (numAppId == VipData.VipNumberInfo.APPID.Avatar.getId()) {
            if (mNeedScaleDownVipNumber) {
                return 0.6f;
            }
            return 0.922f;
        }
        if (!mNeedScaleDownVipNumber) {
            return 1.0f;
        }
        return 0.6f;
    }
}

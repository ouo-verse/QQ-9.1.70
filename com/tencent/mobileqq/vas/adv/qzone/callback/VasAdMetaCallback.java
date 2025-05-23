package com.tencent.mobileqq.vas.adv.qzone.callback;

import com.tencent.mobileqq.vas.adv.common.data.AlumBasicData;
import com.tencent.mobileqq.vas.adv.common.data.VasAdvServiceCode;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J$\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\b\u0010\b\u001a\u0004\u0018\u00010\tH&\u00a8\u0006\n"}, d2 = {"Lcom/tencent/mobileqq/vas/adv/qzone/callback/VasAdMetaCallback;", "", "onGetAdInfoResponse", "", "retCode", "Lcom/tencent/mobileqq/vas/adv/common/data/VasAdvServiceCode;", "retMsg", "", "albumBasicData", "Lcom/tencent/mobileqq/vas/adv/common/data/AlumBasicData;", "vas-adv-api_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes20.dex */
public interface VasAdMetaCallback {
    void onGetAdInfoResponse(@NotNull VasAdvServiceCode retCode, @Nullable String retMsg, @Nullable AlumBasicData albumBasicData);
}

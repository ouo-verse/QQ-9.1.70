package com.tencent.mobileqq.qne.utils.network;

import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J0\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0001H&\u00a8\u0006\n"}, d2 = {"Lcom/tencent/mobileqq/qne/utils/network/a;", "", "", "ssoErrorCode", "trpcErrorCode", "", "trpcErrorMsg", "rspData", "", "onResponse", "qne-api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes16.dex */
public interface a {
    void onResponse(int ssoErrorCode, int trpcErrorCode, @Nullable String trpcErrorMsg, @Nullable Object rspData);
}

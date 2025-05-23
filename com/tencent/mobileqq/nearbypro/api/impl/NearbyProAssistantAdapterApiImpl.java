package com.tencent.mobileqq.nearbypro.api.impl;

import com.tencent.mobileqq.nearbypro.api.INearbyProAssistantAdapterApi;
import com.tencent.mobileqq.nearbypro.base.j;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\u0018\u0000 \n2\u00020\u0001:\u0001\u000bB\u0007\u00a2\u0006\u0004\b\b\u0010\tJ\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016\u00a8\u0006\f"}, d2 = {"Lcom/tencent/mobileqq/nearbypro/api/impl/NearbyProAssistantAdapterApiImpl;", "Lcom/tencent/mobileqq/nearbypro/api/INearbyProAssistantAdapterApi;", "", "appID", "", "tinyId", "", "isLittleAssistant", "<init>", "()V", "Companion", "a", "qq_nearby_pro_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes15.dex */
public final class NearbyProAssistantAdapterApiImpl implements INearbyProAssistantAdapterApi {

    @NotNull
    public static final String TAG = "NearbyProAssistantAdapterApiImpl";

    @Override // com.tencent.mobileqq.nearbypro.api.INearbyProAssistantAdapterApi
    public boolean isLittleAssistant(int appID, @NotNull String tinyId) {
        Intrinsics.checkNotNullParameter(tinyId, "tinyId");
        j.c().e(TAG, appID + ", " + tinyId);
        if (appID == 119 && Intrinsics.areEqual(tinyId, "144115219935613893")) {
            return true;
        }
        return false;
    }
}

package com.tencent.mobileqq.profilecard.nt.api.impl;

import android.content.Context;
import android.content.Intent;
import com.tencent.mobileqq.activity.ChatActivity;
import com.tencent.mobileqq.activity.aio.BaseAIOUtils;
import com.tencent.mobileqq.profilecard.nt.api.IProfileNtApi;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/mobileqq/profilecard/nt/api/impl/ProfileNtApiImpl;", "Lcom/tencent/mobileqq/profilecard/nt/api/IProfileNtApi;", "()V", "getEnterNtAIOIntent", "Landroid/content/Intent;", "context", "Landroid/content/Context;", "profilecard_feature_impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes35.dex */
public final class ProfileNtApiImpl implements IProfileNtApi {
    @Override // com.tencent.mobileqq.profilecard.nt.api.IProfileNtApi
    public Intent getEnterNtAIOIntent(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intent intent = new Intent(context, (Class<?>) ChatActivity.class);
        BaseAIOUtils.m(intent, null);
        return intent;
    }
}

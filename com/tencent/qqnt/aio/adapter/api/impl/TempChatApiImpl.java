package com.tencent.qqnt.aio.adapter.api.impl;

import android.content.Context;
import android.content.Intent;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.setting.api.ISettingApi;
import com.tencent.qqnt.aio.adapter.api.ITempChatApi;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/qqnt/aio/adapter/api/impl/TempChatApiImpl;", "Lcom/tencent/qqnt/aio/adapter/api/ITempChatApi;", "()V", "openTempChatSetting", "", "context", "Landroid/content/Context;", "base_proj_nt_ext_impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes34.dex */
public final class TempChatApiImpl implements ITempChatApi {
    @Override // com.tencent.qqnt.aio.adapter.api.ITempChatApi
    public void openTempChatSetting(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        ((ISettingApi) QRoute.api(ISettingApi.class)).startTempMsgSettingPage(context, new Intent());
    }
}

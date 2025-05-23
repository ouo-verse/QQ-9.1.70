package com.tencent.qqnt.aio.adapter.api.impl;

import android.content.Context;
import android.content.Intent;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.setting.api.ISettingApi;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qqnt.aio.adapter.api.IAssistantJumpApi;
import kotlin.Metadata;
import mqq.app.Foreground;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0016\u00a8\u0006\u0005"}, d2 = {"Lcom/tencent/qqnt/aio/adapter/api/impl/AssistantJumpApiImpl;", "Lcom/tencent/qqnt/aio/adapter/api/IAssistantJumpApi;", "()V", "jumpToAssistantFragment", "", "base_proj_nt_ext_impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes34.dex */
public final class AssistantJumpApiImpl implements IAssistantJumpApi {
    @Override // com.tencent.qqnt.aio.adapter.api.IAssistantJumpApi
    public void jumpToAssistantFragment() {
        Context topActivity = Foreground.getTopActivity();
        if (topActivity == null && (topActivity = BaseApplication.getContext()) == null) {
            return;
        }
        Intent intent = new Intent();
        intent.putExtra("setting_search_title1", "\u804a\u5929");
        ((ISettingApi) QRoute.api(ISettingApi.class)).startGeneralSettingChatPage(topActivity, intent);
    }
}

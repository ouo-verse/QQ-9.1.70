package com.tencent.qqnt.aio.adapter.api.impl;

import android.content.SharedPreferences;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.ptt.temp.api.IQQRecorderTempApi;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qqnt.aio.adapter.api.IAIOPttApi;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\u0012\u0010\u0007\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\nH\u0016\u00a8\u0006\u000b"}, d2 = {"Lcom/tencent/qqnt/aio/adapter/api/impl/AIOPttApiImpl;", "Lcom/tencent/qqnt/aio/adapter/api/IAIOPttApi;", "()V", "getPttFileDuration", "", "path", "", "isAutoChangeText", "", "app", "Lmqq/app/AppRuntime;", "base_proj_nt_ext_impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes34.dex */
public final class AIOPttApiImpl implements IAIOPttApi {
    @Override // com.tencent.qqnt.aio.adapter.api.IAIOPttApi
    public int getPttFileDuration(String path) {
        Intrinsics.checkNotNullParameter(path, "path");
        return ((IQQRecorderTempApi) QRoute.api(IQQRecorderTempApi.class)).getFilePlayTime(path);
    }

    @Override // com.tencent.qqnt.aio.adapter.api.IAIOPttApi
    public boolean isAutoChangeText(AppRuntime app) {
        if (app == null) {
            return false;
        }
        SharedPreferences sharedPreferences = app.getApp().getSharedPreferences(AppConstants.Preferences.CHECK_UPDATE_SP_KEY, 0);
        Intrinsics.checkNotNullExpressionValue(sharedPreferences, "it.app.getSharedPreferen\u2026EY, Context.MODE_PRIVATE)");
        return sharedPreferences.getBoolean("businessinfo_ptt_auto_change_text_" + app.getCurrentAccountUin(), false);
    }
}

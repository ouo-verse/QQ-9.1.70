package com.tencent.mobileqq.icgame.api.impl;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import au0.c;
import com.tencent.icgame.common.api.IAegisLogApi;
import com.tencent.mobileqq.icgame.api.IQQLiveSDK;
import com.tencent.mobileqq.icgame.api.IQQLiveUtil;
import com.tencent.mobileqq.icgame.api.end.IQQLiveEndView;
import com.tencent.mobileqq.icgame.data.QQLiveEndPageInfo;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.proxyinner.plugin.loader.PluginToolProcessService;
import com.tencent.qphone.base.util.BaseApplication;

/* compiled from: P */
/* loaded from: classes15.dex */
public class QQLiveUtilImpl implements IQQLiveUtil {
    private static final String TAG = "QQLiveUtilImpl";

    @Override // com.tencent.mobileqq.icgame.api.IQQLiveUtil
    public IQQLiveEndView getAudienceEndLiveView(Context context, IQQLiveSDK iQQLiveSDK, QQLiveEndPageInfo qQLiveEndPageInfo, c cVar, s22.a aVar) {
        return new com.tencent.mobileqq.icgame.room.end.c(context, iQQLiveSDK, qQLiveEndPageInfo, cVar, aVar);
    }

    @Override // com.tencent.mobileqq.icgame.api.IQQLiveUtil
    public void openCommonWebDialog(Context context, String str, Bundle bundle) {
        q22.a.c(context, str, bundle);
    }

    @Override // com.tencent.mobileqq.icgame.api.IQQLiveUtil
    public void preloadICGameRoom() {
        BaseApplication context = BaseApplication.getContext();
        Intent intent = new Intent(context, (Class<?>) PluginToolProcessService.class);
        intent.setAction("action_preload_icgame_room");
        try {
            context.startService(intent);
        } catch (IllegalStateException | SecurityException e16) {
            ((IAegisLogApi) QRoute.api(IAegisLogApi.class)).e(TAG, "startService fail " + e16.getMessage());
        }
    }

    @Override // com.tencent.mobileqq.icgame.api.IQQLiveUtil
    public void clearAutoSwitchFlags() {
    }
}

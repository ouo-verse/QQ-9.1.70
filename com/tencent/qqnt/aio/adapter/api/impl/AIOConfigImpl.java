package com.tencent.qqnt.aio.adapter.api.impl;

import android.content.Context;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.util.IFeatureServiceProxy;
import com.tencent.qqnt.aio.adapter.api.IAIOConfig;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

/* compiled from: P */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 \u00112\u00020\u0001:\u0001\u0012B\u0007\u00a2\u0006\u0004\b\u000f\u0010\u0010J \u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0005H\u0002J\u0010\u0010\n\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\bH\u0016J\u0018\u0010\n\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\u0002H\u0016J\u0010\u0010\u000e\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\fH\u0016\u00a8\u0006\u0013"}, d2 = {"Lcom/tencent/qqnt/aio/adapter/api/impl/AIOConfigImpl;", "Lcom/tencent/qqnt/aio/adapter/api/IAIOConfig;", "", "isMute", "canVibrator", "Lcom/tencent/mobileqq/app/QQAppInterface;", "app", "isCanVibrator", "", "switchId", "isFeatureSwitchOn", "default", "Landroid/content/Context;", "context", "canSwipeReplyVibrate", "<init>", "()V", "Companion", "a", "base_proj_nt_ext_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public final class AIOConfigImpl implements IAIOConfig {
    public static final String TAG = "AIOConfigApiImpl";

    private final boolean isCanVibrator(boolean isMute, boolean canVibrator, QQAppInterface app) {
        if ((!app.isRingerVibrate() || isMute) && !(app.isRingerNormal() && app.isRingerNormalVibrate() && !isMute)) {
            return canVibrator;
        }
        return true;
    }

    @Override // com.tencent.qqnt.aio.adapter.api.IAIOConfig
    public boolean canSwipeReplyVibrate(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        QQAppInterface qQAppInterface = peekAppRuntime instanceof QQAppInterface ? (QQAppInterface) peekAppRuntime : null;
        if (qQAppInterface != null) {
            return isCanVibrator(com.tencent.mobileqq.util.az.c(BaseApplicationImpl.getApplication().getApplicationContext(), qQAppInterface), false, qQAppInterface);
        }
        return false;
    }

    @Override // com.tencent.qqnt.aio.adapter.api.IAIOConfig
    public boolean isFeatureSwitchOn(String switchId) {
        Intrinsics.checkNotNullParameter(switchId, "switchId");
        return isFeatureSwitchOn(switchId, true);
    }

    @Override // com.tencent.qqnt.aio.adapter.api.IAIOConfig
    public boolean isFeatureSwitchOn(String switchId, boolean r36) {
        Intrinsics.checkNotNullParameter(switchId, "switchId");
        return ((IFeatureServiceProxy) QRoute.api(IFeatureServiceProxy.class)).isFeatureSwitchOn(switchId, r36);
    }
}

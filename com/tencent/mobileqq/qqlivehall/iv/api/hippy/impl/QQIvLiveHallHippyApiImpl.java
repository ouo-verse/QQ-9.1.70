package com.tencent.mobileqq.qqlivehall.iv.api.hippy.impl;

import com.tencent.common.app.AppInterface;
import com.tencent.hippy.qq.update.HippyQQConstants;
import com.tencent.hippy.qq.utils.HippyUtils;
import com.tencent.mobileqq.qqlivehall.iv.api.hippy.IQQIvLiveHallHippyApi;
import com.tencent.mobileqq.tianshu.api.IRedTouchManager;
import com.tencent.mobileqq.tianshu.pb.BusinessInfoCheckUpdate;
import com.tencent.mtt.hippy.HippyAPIProvider;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.MobileQQ;
import mqq.app.api.IRuntimeService;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import xi2.d;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\b\u0018\u0000 \f2\u00020\u0001:\u0001\rB\u0007\u00a2\u0006\u0004\b\n\u0010\u000bJ\b\u0010\u0003\u001a\u00020\u0002H\u0016J\u0012\u0010\u0007\u001a\u00020\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016J\b\u0010\b\u001a\u00020\u0006H\u0016J\b\u0010\t\u001a\u00020\u0006H\u0016\u00a8\u0006\u000e"}, d2 = {"Lcom/tencent/mobileqq/qqlivehall/iv/api/hippy/impl/QQIvLiveHallHippyApiImpl;", "Lcom/tencent/mobileqq/qqlivehall/iv/api/hippy/IQQIvLiveHallHippyApi;", "Lcom/tencent/mtt/hippy/HippyAPIProvider;", "getQQIvLiveHallHippyAPIProvider", "", "moduleName", "", "isQQIvLiveHallModule", "isCanPreload", "hasNewMessage", "<init>", "()V", "Companion", "a", "qq-iv-live-hall-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes17.dex */
public final class QQIvLiveHallHippyApiImpl implements IQQIvLiveHallHippyApi {
    private static final int PLUGIN_PLUGINID_LIVE = 879;

    @NotNull
    private static final String TAG = "QQIvLiveHallHippyApiImpl";

    @Override // com.tencent.mobileqq.qqlivehall.iv.api.hippy.IQQIvLiveHallHippyApi
    @NotNull
    public HippyAPIProvider getQQIvLiveHallHippyAPIProvider() {
        return new d();
    }

    @Override // com.tencent.mobileqq.qqlivehall.iv.api.hippy.IQQIvLiveHallHippyApi
    public boolean hasNewMessage() {
        AppInterface appInterface;
        boolean z16 = false;
        if (MobileQQ.sProcessId != 1 || (appInterface = HippyUtils.getAppInterface()) == null) {
            return false;
        }
        IRuntimeService runtimeService = appInterface.getRuntimeService(IRedTouchManager.class, "");
        Intrinsics.checkNotNullExpressionValue(runtimeService, "app.getRuntimeService(IR\u2026va, ProcessConstant.MAIN)");
        BusinessInfoCheckUpdate.AppInfo appInfoByPath = ((IRedTouchManager) runtimeService).getAppInfoByPath("879");
        if (appInfoByPath != null && appInfoByPath.iNewFlag.has() && appInfoByPath.iNewFlag.get() == 1) {
            z16 = true;
        }
        QLog.i(TAG, 2, "hasNewMessage " + z16);
        return z16;
    }

    @Override // com.tencent.mobileqq.qqlivehall.iv.api.hippy.IQQIvLiveHallHippyApi
    public boolean isCanPreload() {
        return true;
    }

    @Override // com.tencent.mobileqq.qqlivehall.iv.api.hippy.IQQIvLiveHallHippyApi
    public boolean isQQIvLiveHallModule(@Nullable String moduleName) {
        return Intrinsics.areEqual(HippyQQConstants.ModuleName.QQ_LIVE_HALL, moduleName);
    }
}

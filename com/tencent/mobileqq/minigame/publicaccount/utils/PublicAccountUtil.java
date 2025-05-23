package com.tencent.mobileqq.minigame.publicaccount.utils;

import android.app.Activity;
import android.os.Bundle;
import com.tencent.biz.pubaccount.accountdetail.api.IPublicAccountDetailActivity;
import com.tencent.biz.pubaccount.api.IPublicAccountDataManager;
import com.tencent.biz.pubaccount.api.IPublicAccountObserver;
import com.tencent.biz.pubaccount.util.api.IPublicAccountUtil;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.mini.reuse.MiniAppTransferModule;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.route.ActivityURIRequest;
import com.tencent.mobileqq.qroute.route.o;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import eipc.EIPCResult;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.api.IRuntimeService;

@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J(\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0007J \u0010\u0012\u001a\u00020\t2\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0002J(\u0010\u0015\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0007J\u0012\u0010\u0016\u001a\u00020\t2\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018H\u0007R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0019"}, d2 = {"Lcom/tencent/mobileqq/minigame/publicaccount/utils/PublicAccountUtil;", "", "()V", "KEY_IS_FOLLOW", "", "KEY_PA_UIN", "KEY_RESULT_CODE", "TAG", "followPA", "", "appInterface", "Lcom/tencent/mobileqq/app/QQAppInterface;", "params", "Landroid/os/Bundle;", "transferModule", "Lcom/tencent/mobileqq/mini/reuse/MiniAppTransferModule;", "callbackId", "", "followPACallBack", "isSuccess", "", "isPAFollow", "openAccountDetail", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "Landroid/app/Activity;", "qqmini_impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes33.dex */
public final class PublicAccountUtil {
    public static final PublicAccountUtil INSTANCE = new PublicAccountUtil();
    public static final String KEY_IS_FOLLOW = "pa_is_follow";
    public static final String KEY_PA_UIN = "pa_uin";
    public static final String KEY_RESULT_CODE = "pa_result_code";
    private static final String TAG = "PublicAccountUtil";

    PublicAccountUtil() {
    }

    @JvmStatic
    public static final void followPA(QQAppInterface appInterface, Bundle params, final MiniAppTransferModule transferModule, final int callbackId) {
        Intrinsics.checkNotNullParameter(appInterface, "appInterface");
        Intrinsics.checkNotNullParameter(params, "params");
        Intrinsics.checkNotNullParameter(transferModule, "transferModule");
        long j3 = params.getLong(KEY_PA_UIN);
        boolean z16 = params.getBoolean(KEY_IS_FOLLOW);
        QRouteApi api = QRoute.api(IPublicAccountObserver.class);
        Intrinsics.checkNotNullExpressionValue(api, "api(IPublicAccountObserver::class.java)");
        IPublicAccountObserver iPublicAccountObserver = (IPublicAccountObserver) api;
        iPublicAccountObserver.setOnCallback(new IPublicAccountObserver.c() { // from class: com.tencent.mobileqq.minigame.publicaccount.utils.PublicAccountUtil$followPA$1
            @Override // com.tencent.biz.pubaccount.api.IPublicAccountObserver.c
            public void onFollowPublicAccount(boolean isSuccess, String uin) {
                if (QLog.isColorLevel()) {
                    QLog.d(IPublicAccountUtil.TAG, 2, "[followPA] onFollowPublicAccount isSuccess=" + isSuccess);
                }
                PublicAccountUtil.INSTANCE.followPACallBack(isSuccess, MiniAppTransferModule.this, callbackId);
            }

            @Override // com.tencent.biz.pubaccount.api.IPublicAccountObserver.c
            public void onUnfollowPublicAccount(boolean isSuccess, String uin) {
                if (QLog.isColorLevel()) {
                    QLog.d(IPublicAccountUtil.TAG, 2, "[followPA] onUnfollowPublicAccount isSuccess=" + isSuccess);
                }
                PublicAccountUtil.INSTANCE.followPACallBack(isSuccess, MiniAppTransferModule.this, callbackId);
            }
        });
        if (z16) {
            ((IPublicAccountUtil) QRoute.api(IPublicAccountUtil.class)).followUin(appInterface, BaseApplication.getContext(), String.valueOf(j3), iPublicAccountObserver, false, 0, true);
        } else {
            ((IPublicAccountUtil) QRoute.api(IPublicAccountUtil.class)).unfollowUin(appInterface, BaseApplication.getContext(), String.valueOf(j3), false, iPublicAccountObserver, true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void followPACallBack(boolean isSuccess, MiniAppTransferModule transferModule, int callbackId) {
        Bundle bundle = new Bundle();
        bundle.putBoolean(KEY_RESULT_CODE, isSuccess);
        transferModule.callbackResult(callbackId, EIPCResult.createResult(0, bundle));
    }

    @JvmStatic
    public static final void isPAFollow(QQAppInterface appInterface, Bundle params, final MiniAppTransferModule transferModule, final int callbackId) {
        Intrinsics.checkNotNullParameter(appInterface, "appInterface");
        Intrinsics.checkNotNullParameter(params, "params");
        Intrinsics.checkNotNullParameter(transferModule, "transferModule");
        final long j3 = params.getLong(KEY_PA_UIN);
        IRuntimeService runtimeService = appInterface.getRuntimeService(IPublicAccountDataManager.class, "all");
        Intrinsics.checkNotNullExpressionValue(runtimeService, "appInterface.getRuntimeS\u2026ava, ProcessConstant.ALL)");
        final IPublicAccountDataManager iPublicAccountDataManager = (IPublicAccountDataManager) runtimeService;
        final Bundle bundle = new Bundle();
        ThreadManagerV2.executeOnFileThread(new Runnable() { // from class: com.tencent.mobileqq.minigame.publicaccount.utils.c
            @Override // java.lang.Runnable
            public final void run() {
                PublicAccountUtil.isPAFollow$lambda$0(IPublicAccountDataManager.this, j3, bundle, transferModule, callbackId);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void isPAFollow$lambda$0(IPublicAccountDataManager pam, long j3, Bundle result, MiniAppTransferModule transferModule, int i3) {
        Intrinsics.checkNotNullParameter(pam, "$pam");
        Intrinsics.checkNotNullParameter(result, "$result");
        Intrinsics.checkNotNullParameter(transferModule, "$transferModule");
        boolean isFollowedUin = pam.isFollowedUin(Long.valueOf(j3));
        if (QLog.isColorLevel()) {
            QLog.d("PublicAccountUtil", 2, "[isPAFollow] isFollowed=" + isFollowedUin);
        }
        result.putBoolean(KEY_IS_FOLLOW, isFollowedUin);
        transferModule.callbackResult(i3, EIPCResult.createResult(0, result));
    }

    @JvmStatic
    public static final void openAccountDetail(Activity activity) {
        if (activity == null) {
            QLog.e("PublicAccountUtil", 1, "openAccountDetail: activity is null");
            return;
        }
        ActivityURIRequest activityURIRequest = new ActivityURIRequest(activity, IPublicAccountDetailActivity.ROUTE_NAME);
        activityURIRequest.extra().putString("uin", AppConstants.MINI_GAME_PUBLIC_ACCOUNT_UIN);
        activityURIRequest.extra().putBoolean("fromMiniGamePub", true);
        QRoute.startUri(activityURIRequest, (o) null);
    }
}

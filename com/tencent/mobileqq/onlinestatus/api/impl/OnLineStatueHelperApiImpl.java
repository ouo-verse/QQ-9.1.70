package com.tencent.mobileqq.onlinestatus.api.impl;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.Nullable;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.QPublicFragmentActivity;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.fragment.QPublicBaseFragment;
import com.tencent.mobileqq.onlinestatus.AccountOnlineStateActivity;
import com.tencent.mobileqq.onlinestatus.OnlineStatusFriendsPermissionItem;
import com.tencent.mobileqq.onlinestatus.OnlineStatusPermissionChecker;
import com.tencent.mobileqq.onlinestatus.OnlineStatusView;
import com.tencent.mobileqq.onlinestatus.af;
import com.tencent.mobileqq.onlinestatus.api.IOnLineStatueHelperApi;
import com.tencent.mobileqq.onlinestatus.api.IOnlineStatusManagerService;
import com.tencent.mobileqq.onlinestatus.api.IOnlineStatusService;
import com.tencent.mobileqq.onlinestatus.ar;
import com.tencent.mobileqq.onlinestatus.au;
import com.tencent.mobileqq.onlinestatus.bs;
import com.tencent.mobileqq.onlinestatus.debug.OnlineStatusDebugFragment;
import com.tencent.mobileqq.onlinestatus.manager.OnlineStatusPermissionManager;
import com.tencent.mobileqq.onlinestatus.olympic.fragment.OlympicShareFragment;
import com.tencent.mobileqq.onlinestatus.utils.OnlineStatusToggleUtils;
import com.tencent.mobileqq.onlinestatus.utils.ae;
import com.tencent.mobileqq.onlinestatus.v;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.kernel.api.IKernelService;
import com.tencent.qqnt.kernel.api.y;
import com.tencent.qqnt.kernel.nativeinterface.IOperateCallback;
import com.tencent.qqnt.ntrelation.api.IFriendDataTransApi;
import com.tencent.relation.common.api.IRelationNTUinAndUidApi;
import java.util.HashMap;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

/* compiled from: P */
/* loaded from: classes16.dex */
public class OnLineStatueHelperApiImpl implements IOnLineStatueHelperApi {
    private static final String TAG = "OnlineStatusHelperApiImpl";
    qc2.a mViewBinding;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes16.dex */
    public static /* synthetic */ class a {

        /* renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f255438a;

        static {
            int[] iArr = new int[AppRuntime.Status.values().length];
            f255438a = iArr;
            try {
                iArr[AppRuntime.Status.online.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f255438a[AppRuntime.Status.qme.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f255438a[AppRuntime.Status.away.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f255438a[AppRuntime.Status.busy.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f255438a[AppRuntime.Status.dnd.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f255438a[AppRuntime.Status.invisiable.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
        }
    }

    private Bitmap getBitmap(AppRuntime.Status status, BitmapFactory.Options options) {
        switch (a.f255438a[status.ordinal()]) {
            case 1:
                return BitmapFactory.decodeResource(MobileQQ.sMobileQQ.getResources(), R.drawable.bzf, options);
            case 2:
                return BitmapFactory.decodeResource(MobileQQ.sMobileQQ.getResources(), R.drawable.bzh, options);
            case 3:
                return BitmapFactory.decodeResource(MobileQQ.sMobileQQ.getResources(), R.drawable.bz7, options);
            case 4:
                return BitmapFactory.decodeResource(MobileQQ.sMobileQQ.getResources(), R.drawable.bz9, options);
            case 5:
                return BitmapFactory.decodeResource(MobileQQ.sMobileQQ.getResources(), R.drawable.bzb, options);
            case 6:
                return BitmapFactory.decodeResource(MobileQQ.sMobileQQ.getResources(), R.drawable.bzd, options);
            default:
                return null;
        }
    }

    private com.tencent.mobileqq.onlinestatus.manager.d getEventStatusManager(AppRuntime appRuntime) {
        return (com.tencent.mobileqq.onlinestatus.manager.d) ((IOnlineStatusManagerService) appRuntime.getRuntimeService(IOnlineStatusManagerService.class, "")).getManager(com.tencent.mobileqq.onlinestatus.manager.d.class);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$requestNTOnlineStatus$0(String str, int i3, String str2) {
        QLog.i(TAG, 1, "requestNTOnlineStatus " + str + " result:" + i3 + ", errMsg:" + str2);
    }

    @Override // com.tencent.mobileqq.onlinestatus.api.IOnLineStatueHelperApi
    public boolean bindOnlineStatusView(AppRuntime appRuntime, com.tencent.qqnt.ntrelation.onlinestatusinfo.bean.c cVar, OnlineStatusView onlineStatusView) {
        if (this.mViewBinding == null) {
            this.mViewBinding = new qc2.a();
        }
        return this.mViewBinding.a(appRuntime, cVar, onlineStatusView);
    }

    @Override // com.tencent.mobileqq.onlinestatus.api.IOnLineStatueHelperApi
    public Bundle buildSyncBatteryData(AppRuntime appRuntime) {
        return af.C().d(appRuntime);
    }

    @Override // com.tencent.mobileqq.onlinestatus.api.IOnLineStatueHelperApi
    public boolean enableAIOSubTitleClicked(AppRuntime appRuntime, String str) {
        return af.C().m(appRuntime, str);
    }

    @Override // com.tencent.mobileqq.onlinestatus.api.IOnLineStatueHelperApi
    public void fetchAvatarAtShareSheetOpened(com.tencent.mobileqq.onlinestatus.u uVar) {
        bs.o(uVar);
    }

    @Override // com.tencent.mobileqq.onlinestatus.api.IOnLineStatueHelperApi
    public v getAvatarStatusIdByStatusId(AppRuntime.Status status, long j3) {
        return bs.r(status, j3);
    }

    @Override // com.tencent.mobileqq.onlinestatus.api.IOnLineStatueHelperApi
    public v getAvatarStatusInfo(AppRuntime appRuntime, String str) {
        return bs.q(appRuntime, str);
    }

    @Override // com.tencent.mobileqq.onlinestatus.api.IOnLineStatueHelperApi
    public v getAvatarStatusInfoByKey(int i3, int i16) {
        return bs.s(i3, i16);
    }

    @Override // com.tencent.mobileqq.onlinestatus.api.IOnLineStatueHelperApi
    public int getButtonId(AppRuntime.Status status) {
        return ar.b(status);
    }

    @Override // com.tencent.mobileqq.onlinestatus.api.IOnLineStatueHelperApi
    public String getDisplayOnlineStatusInfo(AppRuntime appRuntime, com.tencent.qqnt.ntrelation.onlinestatusinfo.bean.c cVar, TextView textView, int i3, au auVar, Boolean bool) {
        return af.C().x(appRuntime, cVar, textView, i3, auVar, bool);
    }

    @Override // com.tencent.mobileqq.onlinestatus.api.IOnLineStatueHelperApi
    public int getLocalBatteryCapacity() {
        return af.D();
    }

    @Override // com.tencent.mobileqq.onlinestatus.api.IOnLineStatueHelperApi
    public AppRuntime.Status getOldStatus(com.tencent.qqnt.ntrelation.onlinestatusinfo.bean.c cVar) {
        return bs.z(cVar);
    }

    @Override // com.tencent.mobileqq.onlinestatus.api.IOnLineStatueHelperApi
    public Bitmap getOldStatusAIOIcon(au auVar) {
        if (auVar.f255493f == 2) {
            BitmapFactory.Options options = new BitmapFactory.Options();
            options.inJustDecodeBounds = true;
            getBitmap(auVar.f255494g, options);
            options.inJustDecodeBounds = false;
            options.inSampleSize = options.outHeight / ViewUtils.dip2px(16.0f);
            return getBitmap(auVar.f255494g, options);
        }
        return null;
    }

    @Override // com.tencent.mobileqq.onlinestatus.api.IOnLineStatueHelperApi
    public Bitmap getOnlineStatusBatteryIcon(int i3, int i16) {
        return af.C().k(i3, i16);
    }

    @Override // com.tencent.mobileqq.onlinestatus.api.IOnLineStatueHelperApi
    public au getOnlineStatusItem(AppRuntime.Status status, long j3, boolean z16) {
        return af.C().J(status, j3, z16);
    }

    @Override // com.tencent.mobileqq.onlinestatus.api.IOnLineStatueHelperApi
    public String getOnlineStatusName(AppRuntime.Status status, long j3) {
        AppRuntime.Status status2 = AppRuntime.Status.online;
        if (status == status2) {
            if (j3 == 1000) {
                return "\u6211\u7684\u7535\u91cf";
            }
            au onlineStatusItem = getOnlineStatusItem(status2, j3, false);
            if (onlineStatusItem != null && !TextUtils.isEmpty(onlineStatusItem.f255490c)) {
                return onlineStatusItem.f255490c;
            }
        }
        return ar.f(status);
    }

    @Override // com.tencent.mobileqq.onlinestatus.api.IOnLineStatueHelperApi
    public long getSelfExtOnlineStatus(AppRuntime appRuntime) {
        return af.C().M(appRuntime);
    }

    @Override // com.tencent.mobileqq.onlinestatus.api.IOnLineStatueHelperApi
    public Drawable getSelfStatusDrawable(long j3, AppRuntime.Status status, int i3, com.tencent.qqnt.ntrelation.onlinestatusinfo.bean.c cVar, int i16) {
        return af.C().O(j3, status, i3, cVar, i16);
    }

    @Override // com.tencent.mobileqq.onlinestatus.api.IOnLineStatueHelperApi
    public String getSelfStatusNameBySubTitle(long j3, AppRuntime.Status status) {
        return af.C().Q(j3, status);
    }

    @Override // com.tencent.mobileqq.onlinestatus.api.IOnLineStatueHelperApi
    public int getSendBatteryStatus(int i3, int i16) {
        return af.R(i3, i16);
    }

    @Override // com.tencent.mobileqq.onlinestatus.api.IOnLineStatueHelperApi
    public Drawable getStatusDrawableWithBigType(com.tencent.qqnt.ntrelation.onlinestatusinfo.bean.c cVar, long j3) {
        return af.C().V(af.C().I(ae.c(cVar), j3), cVar, 5);
    }

    @Override // com.tencent.mobileqq.onlinestatus.api.IOnLineStatueHelperApi
    public AppRuntime.Status getStatusFromProfile(int i3) {
        return ar.e(i3);
    }

    @Override // com.tencent.mobileqq.onlinestatus.api.IOnLineStatueHelperApi
    public au getStatusItem(int i3) {
        return new au(AppRuntime.Status.online);
    }

    @Override // com.tencent.mobileqq.onlinestatus.api.IOnLineStatueHelperApi
    public String getStatusName(AppRuntime.Status status) {
        return ar.f(status);
    }

    @Override // com.tencent.mobileqq.onlinestatus.api.IOnLineStatueHelperApi
    public String getStatusNamePlusNetWorkType(int i3) {
        return bs.K(i3);
    }

    @Override // com.tencent.mobileqq.onlinestatus.api.IOnLineStatueHelperApi
    public Drawable[] getSubtitleOnlineDrawable(AppRuntime appRuntime, com.tencent.qqnt.ntrelation.onlinestatusinfo.bean.c cVar, boolean z16, boolean z17) {
        return af.C().X(appRuntime, cVar, z16, z17);
    }

    @Override // com.tencent.mobileqq.onlinestatus.api.IOnLineStatueHelperApi
    public boolean handleAIOSubTitleClicked(AppRuntime appRuntime, Activity activity, String str, View view) {
        return af.C().b0(appRuntime, activity, str, view);
    }

    @Override // com.tencent.mobileqq.onlinestatus.api.IOnLineStatueHelperApi
    public void handleEventStatusEgg(AppRuntime appRuntime, au auVar, Activity activity, ViewGroup viewGroup, int i3, int i16) {
        getEventStatusManager(appRuntime).m(auVar, activity, viewGroup, i3, i16);
    }

    @Override // com.tencent.mobileqq.onlinestatus.api.IOnLineStatueHelperApi
    public boolean handleOlympicEggAnim(AppRuntime appRuntime, View view) {
        com.tencent.mobileqq.onlinestatus.manager.u uVar = (com.tencent.mobileqq.onlinestatus.manager.u) ((IOnlineStatusManagerService) appRuntime.getRuntimeService(IOnlineStatusManagerService.class, "")).getManager(com.tencent.mobileqq.onlinestatus.manager.h.class);
        if (uVar != null) {
            return uVar.K(view);
        }
        return false;
    }

    @Override // com.tencent.mobileqq.onlinestatus.api.IOnLineStatueHelperApi
    public boolean hasPermission(String str) {
        OnlineStatusFriendsPermissionItem D;
        if (TextUtils.isEmpty(str) || (D = ((OnlineStatusPermissionManager) ((IOnlineStatusManagerService) MobileQQ.sMobileQQ.waitAppRuntime(null).getRuntimeService(IOnlineStatusManagerService.class, "")).getManager(com.tencent.mobileqq.onlinestatus.manager.i.class)).D(40001L, false, null)) == null) {
            return true;
        }
        OnlineStatusPermissionChecker.OnlineStatusPermissionItem create = OnlineStatusPermissionChecker.OnlineStatusPermissionItem.create(40001L, D.allHasPermission, D.permissionUins);
        if (create.isAllHasPermission() || create.getPermissionUins().contains(Long.valueOf(Long.parseLong(str)))) {
            return true;
        }
        return false;
    }

    @Override // com.tencent.mobileqq.onlinestatus.api.IOnLineStatueHelperApi
    public boolean isAvatarAccountAutoWhite(String str) {
        return bs.R(str);
    }

    @Override // com.tencent.mobileqq.onlinestatus.api.IOnLineStatueHelperApi
    public boolean isInOlympicMedalEvent() {
        return af.C().f0();
    }

    @Override // com.tencent.mobileqq.onlinestatus.api.IOnLineStatueHelperApi
    public boolean isWeatherInfoValid(com.tencent.qqnt.ntrelation.onlinestatusinfo.bean.c cVar) {
        return bs.d0(cVar);
    }

    @Override // com.tencent.mobileqq.onlinestatus.api.IOnLineStatueHelperApi
    public void launchDebugFragment(Context context) {
        QPublicFragmentActivity.start(context, OnlineStatusDebugFragment.class);
    }

    @Override // com.tencent.mobileqq.onlinestatus.api.IOnLineStatueHelperApi
    public void launchOlympicShareFragment(Activity activity, Intent intent) {
        OlympicShareFragment.ph(activity, intent);
    }

    @Override // com.tencent.mobileqq.onlinestatus.api.IOnLineStatueHelperApi
    public boolean needShowEventStatusEgg(AppRuntime appRuntime, au auVar) {
        return getEventStatusManager(appRuntime).g(auVar);
    }

    @Override // com.tencent.mobileqq.onlinestatus.api.IOnLineStatueHelperApi
    public void onDestroyOlympicEggAnim(AppRuntime appRuntime) {
        com.tencent.mobileqq.onlinestatus.manager.u uVar = (com.tencent.mobileqq.onlinestatus.manager.u) ((IOnlineStatusManagerService) appRuntime.getRuntimeService(IOnlineStatusManagerService.class, "")).getManager(com.tencent.mobileqq.onlinestatus.manager.h.class);
        if (uVar != null) {
            uVar.G();
        }
    }

    @Override // com.tencent.mobileqq.onlinestatus.api.IOnLineStatueHelperApi
    public void onFriendChatPieFinish(AppRuntime appRuntime) {
        getEventStatusManager(appRuntime).l();
    }

    @Override // com.tencent.mobileqq.onlinestatus.api.IOnLineStatueHelperApi
    @Deprecated
    public void parseExtOnlineBusinessInfo(Friends friends, byte[] bArr, String str) {
        bs.v0(friends, bArr, str);
    }

    @Override // com.tencent.mobileqq.onlinestatus.api.IOnLineStatueHelperApi
    @Deprecated
    public void parseFriendMusicInfo(Friends friends, byte[] bArr, String str) {
        com.tencent.mobileqq.onlinestatus.manager.k.F(friends, bArr, str);
    }

    @Override // com.tencent.mobileqq.onlinestatus.api.IOnLineStatueHelperApi
    @Deprecated
    public void parseVecExtInfo(Friends friends, byte[] bArr, long j3, HashMap<String, Long> hashMap) {
        bs.x0(friends, bArr, j3, hashMap);
    }

    @Override // com.tencent.mobileqq.onlinestatus.api.IOnLineStatueHelperApi
    public void refreshOnlineStatusDNDBanner() {
        AppRuntime.Status onlineStatus;
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime == null || !peekAppRuntime.isLogin() || (onlineStatus = ((IOnlineStatusService) peekAppRuntime.getRuntimeService(IOnlineStatusService.class, "")).getOnlineStatus()) == null) {
            return;
        }
        com.tencent.mobileqq.onlinestatus.manager.l.f255972a.c(onlineStatus);
    }

    @Override // com.tencent.mobileqq.onlinestatus.api.IOnLineStatueHelperApi
    public void requestNTOnlineStatus(String str, boolean z16, final String str2) {
        if (!OnlineStatusToggleUtils.F()) {
            return;
        }
        if (TextUtils.isEmpty(str)) {
            QLog.e(TAG, 1, "requestNTOnlineStatus uid is null, trace:" + str2);
            return;
        }
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime == null) {
            QLog.e(TAG, 1, "requestNTOnlineStatus appRuntime is null, trace:" + str2);
            return;
        }
        y profileService = ((IKernelService) peekAppRuntime.getRuntimeService(IKernelService.class, "")).getProfileService();
        if (profileService == null) {
            QLog.e(TAG, 1, "requestNTOnlineStatus profileService is null, trace:" + str2);
            return;
        }
        QLog.d(TAG, 1, "requestNTOnlineStatus " + str + ", forceRefresh: " + z16 + ", trace: " + str2);
        profileService.getStatus(str, z16, new IOperateCallback() { // from class: com.tencent.mobileqq.onlinestatus.api.impl.r
            @Override // com.tencent.qqnt.kernel.nativeinterface.IOperateCallback
            public final void onResult(int i3, String str3) {
                OnLineStatueHelperApiImpl.lambda$requestNTOnlineStatus$0(str2, i3, str3);
            }
        });
    }

    @Override // com.tencent.mobileqq.onlinestatus.api.IOnLineStatueHelperApi
    public void requestNTOnlineStatusByUin(String str, boolean z16, String str2) {
        if (TextUtils.isEmpty(str)) {
            QLog.e(TAG, 1, "requestNTOnlineStatusByUin error, uin is null, trace:" + str2);
            return;
        }
        requestNTOnlineStatus(((IRelationNTUinAndUidApi) QRoute.api(IRelationNTUinAndUidApi.class)).getUidFromUin(str), z16, str2);
    }

    @Override // com.tencent.mobileqq.onlinestatus.api.IOnLineStatueHelperApi
    public void setOnlineStatusTextAndIcon(String str, @Nullable TextView textView, @Nullable ImageView imageView) {
        bs.F0(str, textView, imageView, false);
    }

    @Override // com.tencent.mobileqq.onlinestatus.api.IOnLineStatueHelperApi
    public void sortAndSaveMap(HashMap<String, Long> hashMap) {
        bs.H0(hashMap);
    }

    @Override // com.tencent.mobileqq.onlinestatus.api.IOnLineStatueHelperApi
    public void startAccountOnlineStateActivity(Context context, Intent intent) {
        QPublicFragmentActivity.start(context, intent, AccountOnlineStateActivity.class);
    }

    @Override // com.tencent.mobileqq.onlinestatus.api.IOnLineStatueHelperApi
    public AppRuntime.Status translateNT(com.tencent.qqnt.ntrelation.onlinestatusinfo.bean.c cVar) {
        return ae.c(cVar);
    }

    @Override // com.tencent.mobileqq.onlinestatus.api.IOnLineStatueHelperApi
    public AppRuntime.Status translateStatus(int i3) {
        return ae.b(i3);
    }

    @Override // com.tencent.mobileqq.onlinestatus.api.IOnLineStatueHelperApi
    public void updateOlympicMedalEventInfo(AppRuntime appRuntime, int i3, long j3, long j16, String str) {
        com.tencent.mobileqq.onlinestatus.manager.u uVar = (com.tencent.mobileqq.onlinestatus.manager.u) ((IOnlineStatusManagerService) appRuntime.getRuntimeService(IOnlineStatusManagerService.class, "")).getManager(com.tencent.mobileqq.onlinestatus.manager.h.class);
        if (uVar != null) {
            uVar.R(new pc2.a(i3, j3, j16, str));
        }
    }

    @Override // com.tencent.mobileqq.onlinestatus.api.IOnLineStatueHelperApi
    public au getOnlineStatusItem(String str) {
        return bs.B(str);
    }

    @Override // com.tencent.mobileqq.onlinestatus.api.IOnLineStatueHelperApi
    public void startAccountOnlineStateActivity(Activity activity, Intent intent, int i3) {
        QPublicFragmentActivity.startForResult(activity, intent, (Class<? extends QPublicBaseFragment>) AccountOnlineStateActivity.class, i3);
    }

    @Override // com.tencent.mobileqq.onlinestatus.api.IOnLineStatueHelperApi
    public au getOnlineStatusItem(AppRuntime.Status status, long j3) {
        return af.C().I(AppRuntime.Status.online, j3);
    }

    @Override // com.tencent.mobileqq.onlinestatus.api.IOnLineStatueHelperApi
    @Deprecated
    public boolean bindOnlineStatusView(AppRuntime appRuntime, Friends friends, OnlineStatusView onlineStatusView) {
        return bindOnlineStatusView(appRuntime, ((IFriendDataTransApi) QRoute.api(IFriendDataTransApi.class)).friendsConvertToOnlineStatusInfo(friends, true), onlineStatusView);
    }
}

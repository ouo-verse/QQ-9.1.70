package com.tencent.mobileqq.qqgamepub.api.impl;

import android.app.Notification;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Environment;
import android.text.TextUtils;
import androidx.core.app.NotificationCompat;
import com.huawei.hms.support.api.entity.common.CommonConstant;
import com.qwallet.temp.IQWalletTemp;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.biz.pubaccount.accountdetail.api.IPublicAccountDetail;
import com.tencent.biz.pubaccount.api.IPublicAccountDataManager;
import com.tencent.commonsdk.util.notification.NotificationUtil;
import com.tencent.commonsdk.util.notification.QQNotificationManager;
import com.tencent.image.Utils;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.gamecenter.api.IGameMsgHelperApi;
import com.tencent.mobileqq.gamecenter.api.ITempApi;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.msf.sdk.SettingCloneUtil;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qmmkv.QMMKV;
import com.tencent.mobileqq.qqgamepub.api.IQQGamePushMsgService;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.studymode.api.IStudyModeManager;
import com.tencent.mobileqq.vas.download.api.IDownloaderFactory;
import com.tencent.mobileqq.vfs.VFSAssistantUtils;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.HashMap;
import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

/* loaded from: classes16.dex */
public class QQGamePushMsgServiceImpl implements IQQGamePushMsgService {
    static IPatchRedirector $redirector_ = null;
    private static final String CACHE_FILE_PREFIX = "Cache_game_push_";
    private static final int MAX_MESSAGE_RETENTION_TIME_IN_SECS = 86400;
    private static final String MMKV_KEY_IS_MESSAGE_SHOWED_PREFIX = "qqgame_pubaccount_pushmsg_is_showed_";
    private static final int NOTIFICATION_MAX_SIZE = 100;
    private static final String TAG = "QQGamePushMsgApiImpl";
    private static String sDiskCachePath;
    private boolean mIsDestroyed;
    private final HashMap<String, Integer> mNotificationIds;
    private final ConcurrentHashMap<String, com.tencent.mobileqq.qqgamepub.model.b> mPushMessages;
    private final QQNotificationManager mQNotificationManager;

    static {
        File cacheDir;
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(19021);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 7)) {
            redirector.redirect((short) 7);
            return;
        }
        sDiskCachePath = "";
        if ("mounted".equals(Environment.getExternalStorageState())) {
            cacheDir = new File(VFSAssistantUtils.getSDKPrivatePath(AppConstants.SDCARD_PATH));
        } else {
            cacheDir = MobileQQ.sMobileQQ.getCacheDir();
        }
        sDiskCachePath = new File(cacheDir, AppConstants.PATH_URLDRAWABLE_DISKCACHE).getAbsolutePath();
    }

    public QQGamePushMsgServiceImpl() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.mIsDestroyed = false;
        this.mQNotificationManager = QQNotificationManager.getInstance();
        this.mNotificationIds = new HashMap<>();
        this.mPushMessages = new ConcurrentHashMap<>();
    }

    private boolean canShowMessage(com.tencent.mobileqq.qqgamepub.model.b bVar, int i3) {
        if (NetConnInfoCenter.getServerTime() - i3 > 86400) {
            QLog.d(TAG, 1, "canShowMessage msg time exceeds one day.");
            return false;
        }
        if (!getNewMsgNotifySwitch()) {
            QLog.d(TAG, 1, "canShowMessage msg notification is closed.");
            return false;
        }
        if (!TextUtils.isEmpty(bVar.f264614f) && !isFollowPubAccount(bVar.f264614f)) {
            QLog.d(TAG, 1, "canShowMessage puin:", bVar.f264614f, " not followed.");
            return false;
        }
        if (!QQNotificationManager.getInstance().areNotificationsEnabled(BaseApplication.getContext())) {
            QLog.i(TAG, 1, "canShowMessage system notification disable");
            return false;
        }
        if (((IStudyModeManager) QRoute.api(IStudyModeManager.class)).getStudyModeSwitch()) {
            QLog.d(TAG, 1, "canShowMessage is study mode");
            return false;
        }
        if (((ITempApi) QRoute.api(ITempApi.class)).canNotDisturb()) {
            QLog.d(TAG, 1, "canShowMessage cannot disturbed");
            return false;
        }
        if (!QMMKV.fromV2(BaseApplication.getContext(), "common_mmkv_configurations").getBoolean(MMKV_KEY_IS_MESSAGE_SHOWED_PREFIX + bVar.f264609a, false)) {
            return true;
        }
        QLog.d(TAG, 1, "canShowMessage message has showed:", bVar.f264609a);
        return false;
    }

    private int createGamePubAccountNotificationId(int i3) {
        return (i3 % 1000) + NotificationUtil.Constants.NOTIFY_ID_GAME_PUB_ACCOUNT_PUSH_START;
    }

    private PendingIntent createJumpIntent(com.tencent.mobileqq.qqgamepub.model.b bVar) {
        if (TextUtils.isEmpty(bVar.f264613e)) {
            return null;
        }
        Intent intent = new Intent();
        intent.setAction(CommonConstant.ACTION.HWID_SCHEME_URL);
        intent.setPackage(MobileQQ.PACKAGE_NAME);
        intent.addFlags(268435456);
        intent.putExtra("game_push_msg_id", bVar.f264609a);
        intent.setData(Uri.parse(bVar.f264613e));
        return PendingIntent.getActivity(BaseApplication.getContext(), (int) (System.currentTimeMillis() & 268435455), intent, 201326592);
    }

    private NotificationCompat.Builder createNotificationBuilder(com.tencent.mobileqq.qqgamepub.model.b bVar, Bitmap bitmap) {
        NotificationCompat.Builder builder = new NotificationCompat.Builder(BaseApplication.getContext(), QQNotificationManager.CHANNEL_ID_OTHER);
        builder.setAutoCancel(true).setOngoing(false).setPriority(1).setSmallIcon(R.drawable.qzone_icon_action_sheet_qq);
        if (!TextUtils.isEmpty(bVar.f264610b)) {
            builder.setContentTitle(bVar.f264610b);
        }
        if (!TextUtils.isEmpty(bVar.f264611c)) {
            builder.setTicker(bVar.f264611c);
            builder.setContentText(bVar.f264611c);
        }
        if (bitmap != null) {
            builder.setLargeIcon(bitmap);
        }
        PendingIntent createJumpIntent = createJumpIntent(bVar);
        if (createJumpIntent != null) {
            builder.setContentIntent(createJumpIntent);
        }
        return builder;
    }

    private synchronized int createNotificationId(String str) {
        Integer num = this.mNotificationIds.get(str);
        if (num != null) {
            return num.intValue();
        }
        int createGamePubAccountNotificationId = createGamePubAccountNotificationId(Math.abs(str.hashCode()));
        if (isNotificationIdExist(createGamePubAccountNotificationId)) {
            createGamePubAccountNotificationId = createGamePubAccountNotificationId(Math.abs(String.valueOf(System.currentTimeMillis()).hashCode()));
        }
        this.mNotificationIds.put(str, Integer.valueOf(createGamePubAccountNotificationId));
        return createGamePubAccountNotificationId;
    }

    private boolean downloadFile(String str, String str2) {
        File file = new File(str2);
        if (file.exists()) {
            return true;
        }
        com.tencent.mobileqq.vip.g gVar = new com.tencent.mobileqq.vip.g(str, file);
        gVar.U = true;
        gVar.Q = true;
        gVar.f313008f = 2;
        gVar.X = true;
        if (((IDownloaderFactory) QRoute.api(IDownloaderFactory.class)).download(gVar, MobileQQ.sMobileQQ.peekAppRuntime()) == 0 && file.exists() && file.length() > 0) {
            return true;
        }
        return false;
    }

    private String getLocalFilePath(String str) {
        return sDiskCachePath + File.separator + CACHE_FILE_PREFIX + Utils.Crc64String(str);
    }

    private boolean getNewMsgNotifySwitch() {
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime == null) {
            return false;
        }
        String currentAccountUin = peekAppRuntime.getCurrentAccountUin();
        if (TextUtils.isEmpty(currentAccountUin)) {
            return false;
        }
        return SettingCloneUtil.readValue((Context) BaseApplication.getContext(), currentAccountUin, (String) null, AppConstants.NEW_MSG_NOTIFICATION_KEY, true);
    }

    private boolean isNotificationIdExist(int i3) {
        Iterator<Integer> it = this.mNotificationIds.values().iterator();
        while (it.hasNext()) {
            if (it.next().intValue() == i3) {
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$prepareNotificationResource$0(com.tencent.mobileqq.qqgamepub.model.b bVar) {
        try {
            String localFilePath = getLocalFilePath(bVar.f264612d);
            QLog.d(TAG, 2, "loadImage isDestroyed=", Boolean.valueOf(this.mIsDestroyed), " id=", bVar.f264609a, " isSuccess:", Boolean.valueOf(downloadFile(bVar.f264612d, localFilePath)));
            Bitmap a16 = com.tencent.gamecenter.wadl.notification.e.a(localFilePath, 100, 100);
            if (!this.mIsDestroyed) {
                onNotificationResourceReady(bVar, a16);
            } else if (a16 != null && !a16.isRecycled()) {
                a16.recycle();
            }
        } catch (Throwable th5) {
            QLog.e(TAG, 1, "prepareNotificationResource e:", th5);
        }
    }

    private void onNotificationResourceReady(com.tencent.mobileqq.qqgamepub.model.b bVar, Bitmap bitmap) {
        int createNotificationId = createNotificationId(bVar.f264609a);
        QLog.d(TAG, 1, "onNotificationResourceReady msgId=", bVar.f264609a, " notificationId=", Integer.valueOf(createNotificationId));
        showNotification(createNotificationId, createNotificationBuilder(bVar, bitmap).build());
        this.mPushMessages.put(bVar.f264609a, bVar);
        reportShowPushMsg(bVar);
        QMMKV.fromV2(BaseApplication.getContext(), "common_mmkv_configurations").putBoolean(MMKV_KEY_IS_MESSAGE_SHOWED_PREFIX + bVar.f264609a, true);
    }

    private void prepareNotificationResource(final com.tencent.mobileqq.qqgamepub.model.b bVar) {
        QLog.i(TAG, 1, "prepareNotificationResource id=" + bVar.f264609a);
        if (TextUtils.isEmpty(bVar.f264612d)) {
            onNotificationResourceReady(bVar, null);
        } else {
            ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.qqgamepub.api.impl.k
                @Override // java.lang.Runnable
                public final void run() {
                    QQGamePushMsgServiceImpl.this.lambda$prepareNotificationResource$0(bVar);
                }
            }, 128, null, true);
        }
    }

    private void reportReceivePushMsg(com.tencent.mobileqq.qqgamepub.model.b bVar) {
        String str;
        HashMap<String, String> hashMap = new HashMap<>();
        boolean isScreenLocked = ((IQWalletTemp) QRoute.api(IQWalletTemp.class)).isScreenLocked(BaseApplication.getContext());
        hashMap.put("ad_id", "9004");
        hashMap.put("ext2", bVar.f264615g);
        hashMap.put("ext4", "18");
        hashMap.put("ext8", bVar.f264618j);
        hashMap.put("ext6", bVar.f264617i);
        if (isScreenLocked) {
            str = "1";
        } else {
            str = "2";
        }
        hashMap.put("ext29", str);
        hashMap.put("ext41", bVar.f264619k);
        ((IGameMsgHelperApi) QRoute.api(IGameMsgHelperApi.class)).reportForGameMsg(bVar.f264616h, "1", "9501", "9713", "971301", "989472", "", hashMap);
    }

    private void reportShowPushMsg(com.tencent.mobileqq.qqgamepub.model.b bVar) {
        String str;
        HashMap<String, String> hashMap = new HashMap<>();
        boolean isScreenLocked = ((IQWalletTemp) QRoute.api(IQWalletTemp.class)).isScreenLocked(BaseApplication.getContext());
        hashMap.put("ad_id", "9004");
        hashMap.put("ext2", bVar.f264615g);
        hashMap.put("ext4", "8");
        hashMap.put("ext8", bVar.f264618j);
        hashMap.put("ext6", bVar.f264617i);
        if (isScreenLocked) {
            str = "1";
        } else {
            str = "2";
        }
        hashMap.put("ext29", str);
        hashMap.put("ext41", bVar.f264619k);
        ((IGameMsgHelperApi) QRoute.api(IGameMsgHelperApi.class)).reportForGameMsg(bVar.f264616h, "1", "9501", "9713", "971301", "989473", "", hashMap);
    }

    private void showNotification(int i3, Notification notification) {
        QLog.d(TAG, 2, "showNotification id=" + i3 + ",notification=" + notification);
        try {
            QQNotificationManager.addChannelIfNeed(notification, QQNotificationManager.CHANNEL_ID_OTHER);
            notification.when = System.currentTimeMillis();
            QQNotificationManager qQNotificationManager = this.mQNotificationManager;
            if (qQNotificationManager != null) {
                qQNotificationManager.notify("gamecenter", i3, notification);
            }
        } catch (Throwable th5) {
            QLog.e(TAG, 2, "showNotification e:", th5);
        }
    }

    @Override // com.tencent.mobileqq.qqgamepub.api.IQQGamePushMsgService
    public boolean isFollowPubAccount(String str) {
        IPublicAccountDataManager iPublicAccountDataManager;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Boolean) iPatchRedirector.redirect((short) 6, (Object) this, (Object) str)).booleanValue();
        }
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime == null || (iPublicAccountDataManager = (IPublicAccountDataManager) peekAppRuntime.getRuntimeService(IPublicAccountDataManager.class, "all")) == null) {
            return false;
        }
        if (!iPublicAccountDataManager.isCached()) {
            iPublicAccountDataManager.initPublicAccountDataManager();
        }
        IPublicAccountDetail findAccountDetailInfoCache = iPublicAccountDataManager.findAccountDetailInfoCache(str);
        if (findAccountDetailInfoCache == null || findAccountDetailInfoCache.getFollowType() != 1) {
            return false;
        }
        return true;
    }

    @Override // mqq.app.api.IRuntimeService
    public void onCreate(AppRuntime appRuntime) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) appRuntime);
        } else {
            QLog.i(TAG, 1, "onCreate");
        }
    }

    @Override // mqq.app.api.IRuntimeService
    public void onDestroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
            return;
        }
        QLog.i(TAG, 1, MosaicConstants$JsFunction.FUNC_ON_DESTROY);
        this.mIsDestroyed = true;
        this.mPushMessages.clear();
    }

    @Override // com.tencent.mobileqq.qqgamepub.api.IQQGamePushMsgService
    public void onReceivePushMsg(String str, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) str, i3);
            return;
        }
        QLog.d(TAG, 1, "onReceivePushMsg msg:", str, " timestamp:", Integer.valueOf(i3), " servertime:", Long.valueOf(NetConnInfoCenter.getServerTime()));
        com.tencent.mobileqq.qqgamepub.model.b a16 = com.tencent.mobileqq.qqgamepub.model.b.a(str);
        if (a16 != null && a16.b()) {
            reportReceivePushMsg(a16);
            if (canShowMessage(a16, i3)) {
                prepareNotificationResource(a16);
                return;
            }
            return;
        }
        QLog.w(TAG, 1, "onReceivePushMsg msg is invalid.");
    }

    @Override // com.tencent.mobileqq.qqgamepub.api.IQQGamePushMsgService
    public void reportPushMsgClicked(String str) {
        String str2;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) str);
            return;
        }
        com.tencent.mobileqq.qqgamepub.model.b bVar = this.mPushMessages.get(str);
        if (bVar == null) {
            return;
        }
        HashMap<String, String> hashMap = new HashMap<>();
        boolean isScreenLocked = ((IQWalletTemp) QRoute.api(IQWalletTemp.class)).isScreenLocked(BaseApplication.getContext());
        hashMap.put("ad_id", "9004");
        hashMap.put("ext2", bVar.f264615g);
        hashMap.put("ext4", "20");
        hashMap.put("ext8", bVar.f264618j);
        hashMap.put("ext6", bVar.f264617i);
        if (isScreenLocked) {
            str2 = "1";
        } else {
            str2 = "2";
        }
        hashMap.put("ext29", str2);
        hashMap.put("ext41", bVar.f264619k);
        ((IGameMsgHelperApi) QRoute.api(IGameMsgHelperApi.class)).reportForGameMsg(bVar.f264616h, "1", "9501", "9713", "971301", "989474", "", hashMap);
    }
}

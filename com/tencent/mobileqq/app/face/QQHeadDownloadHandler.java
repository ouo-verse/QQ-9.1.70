package com.tencent.mobileqq.app.face;

import AvatarInfo.QQHeadInfo;
import android.content.Context;
import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.ThreadExcutor;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.app.face.FaceConstant;
import com.tencent.mobileqq.app.face.util.FaceUtil;
import com.tencent.mobileqq.avatar.api.IQQAvatarBroadcastService;
import com.tencent.mobileqq.avatar.api.IQQAvatarDataService;
import com.tencent.mobileqq.avatar.api.IQQClassicAvatarService;
import com.tencent.mobileqq.avatar.api.IQQZplanOutsideAvatarApi;
import com.tencent.mobileqq.avatar.api.impl.QQAvatarDataServiceImpl;
import com.tencent.mobileqq.avatar.api.impl.QQAvatarHandlerApiImpl;
import com.tencent.mobileqq.avatar.handler.AvatarHandler;
import com.tencent.mobileqq.config.ah;
import com.tencent.mobileqq.data.Setting;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.proavatar.ProAvatarComponentInit;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qqfeatureswitch.IFeatureRuntimeService;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.util.cu;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.avatar.meta.info.AvatarInfoCheck;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.os.MqqHandler;

/* compiled from: P */
/* loaded from: classes11.dex */
public class QQHeadDownloadHandler extends FaceDownloader {
    static IPatchRedirector $redirector_ = null;
    private static final String QQ_HEAD_DH = "Q.qqhead.QQHeadDownloadHandler";
    private static final String TAG = "Q.qqhead.QQHeadDownloadHandler";
    private static final int[] TROOPS_SYSTEM_HEADS;
    private static Object syncCopyQQHeadLock;
    private final WeakReference<AppInterface> mAppRef;
    private final WeakReference<AvatarHandler> mAvatarHandlerRef;
    private MqqHandler mSubhandler;

    /* compiled from: P */
    /* loaded from: classes11.dex */
    class HeadCostStatRunnable implements Runnable {
        static IPatchRedirector $redirector_;
        int downloadSize;
        String downloadUrl;
        int dstUsrType;
        int errCode;

        /* renamed from: id, reason: collision with root package name */
        String f195557id;
        int idType;
        int resultCode;
        int sizeType;
        int state;
        long time;

        public HeadCostStatRunnable(int i3, String str, int i16, int i17, int i18, int i19, int i26, String str2, int i27, long j3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, QQHeadDownloadHandler.this, Integer.valueOf(i3), str, Integer.valueOf(i16), Integer.valueOf(i17), Integer.valueOf(i18), Integer.valueOf(i19), Integer.valueOf(i26), str2, Integer.valueOf(i27), Long.valueOf(j3));
                return;
            }
            this.resultCode = i3;
            this.f195557id = str;
            this.idType = i16;
            this.sizeType = i17;
            this.dstUsrType = i18;
            this.state = i19;
            this.downloadSize = i26;
            this.downloadUrl = str2;
            this.errCode = i27;
            this.time = j3;
        }

        @Override // java.lang.Runnable
        public void run() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this);
                return;
            }
            if (QQHeadDownloadHandler.this.getAvatarHandler() != null) {
                QQHeadDownloadHandler.this.getAvatarHandler().B3(this.resultCode, this.f195557id, this.dstUsrType, 4, this.downloadSize, this.downloadUrl, this.errCode, this.time);
            }
            String h16 = com.tencent.mobileqq.avatar.utils.c.h(this.dstUsrType, this.f195557id, this.idType, this.sizeType);
            if (QQHeadDownloadHandler.this.getAvatarHandler() != null) {
                QQHeadDownloadHandler.this.getAvatarHandler().r3(h16, true);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes11.dex */
    static class UpdateSettingRunnable implements Runnable {
        static IPatchRedirector $redirector_;
        AvatarHandler avatarHandler;
        FaceInfo mFaceInfo;
        QQHeadInfo mInfo;
        Setting mSetting;

        public UpdateSettingRunnable(Setting setting, FaceInfo faceInfo, AvatarHandler avatarHandler) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, setting, faceInfo, avatarHandler);
                return;
            }
            this.mSetting = setting;
            this.mInfo = faceInfo.mHeadInfo;
            this.mFaceInfo = faceInfo;
            this.avatarHandler = avatarHandler;
        }

        private void clearAvatar(String str) {
            FaceUtil.clearHDAvatar(str);
            FaceUtil.clearFHDAvatar(str);
            AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
            if (peekAppRuntime != null) {
                FaceUtil.removeAvatarFromCache(peekAppRuntime, str);
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this);
                return;
            }
            if (QLog.isColorLevel()) {
                QLog.i("Q.qqhead.QQHeadDownloadHandler", 2, "UpdateSettingRunnable run start. | uin=" + this.mSetting.uin + ", updateTimestamp=" + this.mSetting.updateTimestamp + ", usrtype=" + ((int) this.mSetting.bUsrType) + ", headImgTimestamp=" + this.mSetting.headImgTimestamp + ", usrtype=" + ((int) this.mSetting.bHeadType) + ", status=" + this.mSetting.getStatus() + ", id=" + this.mSetting.getId() + ", currentTimeMillis=" + System.currentTimeMillis());
            }
            AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
            if (peekAppRuntime == null) {
                QLog.e("Q.qqhead.QQHeadDownloadHandler", 1, "UpdateSettingRunnable app is null");
                return;
            }
            ProAvatarComponentInit.f(this.mFaceInfo);
            EntityManager createEntityManager = peekAppRuntime.getEntityManagerFactory().createEntityManager();
            if (this.mSetting.getStatus() == 1000) {
                createEntityManager.persistOrReplace(this.mSetting);
            } else if (this.mSetting.getStatus() == 1001 || this.mSetting.getStatus() == 1002) {
                createEntityManager.update(this.mSetting);
            }
            createEntityManager.close();
            com.tencent.mobileqq.avatar.utils.c.t(peekAppRuntime, this.mSetting);
            QQHeadInfo qQHeadInfo = this.mInfo;
            String h36 = AvatarHandler.h3(qQHeadInfo.uin, qQHeadInfo.phoneNum);
            IQQAvatarDataService iQQAvatarDataService = (IQQAvatarDataService) peekAppRuntime.getRuntimeService(IQQAvatarDataService.class, "");
            QQHeadInfo qQHeadInfo2 = this.mInfo;
            String customFaceFilePath = iQQAvatarDataService.getCustomFaceFilePath(null, qQHeadInfo2.dstUsrType, h36, qQHeadInfo2.idType, qQHeadInfo2.sizeType, this.mFaceInfo);
            if (customFaceFilePath != null) {
                try {
                    int lastIndexOf = customFaceFilePath.lastIndexOf("/");
                    if (lastIndexOf > 0) {
                        String substring = customFaceFilePath.substring(0, lastIndexOf);
                        String substring2 = customFaceFilePath.substring(lastIndexOf + 1);
                        if (!TextUtils.isEmpty(substring2) && substring2.endsWith("jpg_")) {
                            File file = new File(substring + File.separator + substring2.substring(0, substring2.lastIndexOf("jpg_")) + "png");
                            if (file.exists()) {
                                file.delete();
                            }
                        }
                    }
                } catch (Exception e16) {
                    QLog.e("Q.qqhead.QQHeadDownloadHandler", 1, "delete oldAvatar exception", e16);
                }
            } else {
                QLog.e("Q.qqhead.QQHeadDownloadHandler", 1, "delete oldAvatar facePath is null. mInfo= " + this.mInfo);
            }
            byte b16 = this.mInfo.dstUsrType;
            if (b16 == 32) {
                clearAvatar("stranger_" + this.mInfo.idType + "_" + h36);
            } else if (b16 == 16) {
                clearAvatar("qcall_" + this.mInfo.idType + "_" + h36);
            } else {
                clearAvatar(h36);
            }
            AvatarHandler avatarHandler = this.avatarHandler;
            if (avatarHandler != null) {
                avatarHandler.notifyUI(0, true, this.mSetting);
            }
            ArrayList arrayList = new ArrayList();
            arrayList.add(this.mInfo);
            com.tencent.mobileqq.proavatar.info.a.o(arrayList);
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(19349);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 5)) {
            redirector.redirect((short) 5);
        } else {
            TROOPS_SYSTEM_HEADS = new int[]{R.drawable.bqc, R.drawable.h6m, R.drawable.h6n, R.drawable.h6o};
            syncCopyQQHeadLock = new Object();
        }
    }

    public QQHeadDownloadHandler(AppInterface appInterface, AvatarHandler avatarHandler) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) appInterface, (Object) avatarHandler);
            return;
        }
        this.mSubhandler = new MqqHandler(ThreadManagerV2.getSubThreadLooper());
        this.mAppRef = new WeakReference<>(appInterface);
        this.mAvatarHandlerRef = new WeakReference<>(avatarHandler);
    }

    private AppInterface getAppInterface() {
        AppInterface appInterface = this.mAppRef.get();
        if (appInterface == null) {
            QLog.e("Q.qqhead.QQHeadDownloadHandler", 1, "weakRef app is null");
        }
        return appInterface;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public AvatarHandler getAvatarHandler() {
        AvatarHandler avatarHandler = this.mAvatarHandlerRef.get();
        if (avatarHandler == null) {
            QLog.e("Q.qqhead.QQHeadDownloadHandler", 1, "weakRef avatarHandler is null");
        }
        return avatarHandler;
    }

    private static String getFaceFilePath(Setting setting, FaceInfo faceInfo, QQHeadInfo qQHeadInfo) {
        AppRuntime peekAppRuntime;
        try {
            if (((IQQZplanOutsideAvatarApi) QRoute.api(IQQZplanOutsideAvatarApi.class)).isOutboundHeadFeatureOn() && (peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime()) != null && ((IFeatureRuntimeService) peekAppRuntime.getRuntimeService(IFeatureRuntimeService.class, "all")).isFeatureSwitchEnable(FaceConstant.TOGGLE_QQ_AVATAR_ZPLAN_FACE_PATH_SWITCH, false)) {
                if (qQHeadInfo.dstUsrType == 1 && qQHeadInfo.enableZplanOutbound && qQHeadInfo.staticZplanFaceFlag > 0) {
                    return QQAvatarDataServiceImpl.getCustomFaceFilePathBySetting(setting, qQHeadInfo.idType, qQHeadInfo.sizeType, faceInfo);
                }
                return ((IQQAvatarDataService) peekAppRuntime.getRuntimeService(IQQAvatarDataService.class, "")).getCustomFaceFilePathBySetting(setting, qQHeadInfo.idType, qQHeadInfo.sizeType);
            }
        } catch (Exception e16) {
            QLog.e("Q.qqhead.QQHeadDownloadHandler", 1, "getFaceFilePath exception", e16);
        }
        return QQAvatarDataServiceImpl.getCustomFaceFilePathBySetting(setting, qQHeadInfo.idType, qQHeadInfo.sizeType, faceInfo);
    }

    /* JADX WARN: Removed duplicated region for block: B:29:0x00bc  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static Object[] getFaceSetting(FaceInfo faceInfo, String str, String str2, boolean z16, boolean z17) {
        IQQAvatarDataService iQQAvatarDataService;
        Setting setting;
        byte b16;
        boolean z18;
        File file;
        QQHeadInfo qQHeadInfo = faceInfo.mHeadInfo;
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime != null) {
            iQQAvatarDataService = (IQQAvatarDataService) peekAppRuntime.getRuntimeService(IQQAvatarDataService.class, "");
            setting = iQQAvatarDataService.getQQHeadSettingFromDB(str2);
        } else {
            iQQAvatarDataService = null;
            setting = null;
        }
        if (iQQAvatarDataService == null) {
            return new Object[]{Boolean.FALSE, null};
        }
        if (setting == null) {
            setting = new Setting();
            setting.uin = str2;
            z16 = true;
        }
        boolean z19 = !TextUtils.equals(setting.url, qQHeadInfo.downLoadUrl);
        if (z19) {
            QLog.d("Q.qqhead.QQHeadDownloadHandler", 2, "getFaceSetting urlChanged: " + setting.url + " -> " + qQHeadInfo.downLoadUrl);
        }
        setting.bFaceFlags = qQHeadInfo.dwFaceFlgas;
        setting.bUsrType = qQHeadInfo.dstUsrType;
        setting.url = qQHeadInfo.downLoadUrl;
        setting.updateTimestamp = System.currentTimeMillis();
        byte b17 = qQHeadInfo.cHeadType;
        if (b17 == 0) {
            b16 = 0;
        } else {
            b16 = qQHeadInfo.headLevel;
        }
        setting.bSourceType = b16;
        if (!z16) {
            byte b18 = setting.bHeadType;
            if (b18 == b17) {
                z18 = b17 == 0 ? false : false;
                if (qQHeadInfo.dstUsrType != 32 && z18 && b18 == 1 && b17 == 0) {
                    file = new File(iQQAvatarDataService.getCustomFaceFilePath(setting.bUsrType, str, qQHeadInfo.idType));
                    if (file.exists()) {
                        file.delete();
                    }
                }
                z16 = z18;
            }
            z18 = true;
            if (qQHeadInfo.dstUsrType != 32) {
                file = new File(iQQAvatarDataService.getCustomFaceFilePath(setting.bUsrType, str, qQHeadInfo.idType));
                if (file.exists()) {
                }
            }
            z16 = z18;
        }
        setting.bHeadType = qQHeadInfo.cHeadType;
        setting.systemHeadID = qQHeadInfo.systemHeadID;
        setting.headImgTimestamp = qQHeadInfo.dwTimestamp;
        setting.staticZplanFaceFlag = qQHeadInfo.staticZplanFaceFlag;
        setting.dynamicZplanFaceFlag = qQHeadInfo.dynamicZplanFaceFlag;
        setting.zplanFaceBgUrl = qQHeadInfo.zplanFaceBgUrl;
        setting.zplanFaceClipPercent = qQHeadInfo.zplanFaceClipPercent;
        setting.apngFaceFlag = qQHeadInfo.apngFaceFlag;
        return new Object[]{Boolean.valueOf(z16), setting, Boolean.valueOf(z19)};
    }

    private void notifyDownloadHeadComplete(QQHeadInfo qQHeadInfo, String str, String str2, boolean z16, boolean z17, String str3, FaceInfo faceInfo) {
        if (z17 || !z16) {
            if (qQHeadInfo.dstUsrType == 11 && getAvatarHandler() != null) {
                getAvatarHandler().notifyUI(2, true, new Object[]{str});
                return;
            }
            if (qQHeadInfo.dstUsrType == 4 && getAvatarHandler() != null) {
                getAvatarHandler().notifyUI(3, true, new Object[]{str});
                AppInterface appInterface = getAppInterface();
                if (appInterface != null) {
                    ((IQQAvatarBroadcastService) appInterface.getRuntimeService(IQQAvatarBroadcastService.class, "")).sendQQHeadBroadcast(4, str, 0, str2);
                    return;
                }
                return;
            }
            if (qQHeadInfo.dstUsrType == 32 && getAvatarHandler() != null) {
                getAvatarHandler().notifyUI(4, true, new Object[]{str, Integer.valueOf(qQHeadInfo.idType), Boolean.TRUE});
                getAvatarHandler().notifyUI(9, true, new Object[]{str, Integer.valueOf(qQHeadInfo.idType), str3});
                return;
            }
            if (qQHeadInfo.dstUsrType == 16 && getAvatarHandler() != null) {
                getAvatarHandler().notifyUI(5, true, new Object[]{str, Integer.valueOf(qQHeadInfo.idType), Boolean.TRUE});
                return;
            }
            if (qQHeadInfo.dstUsrType == 116 && getAvatarHandler() != null) {
                getAvatarHandler().notifyUI(8, true, new Object[]{str, Integer.valueOf(qQHeadInfo.sizeType), Boolean.TRUE});
                return;
            }
            AppInterface appInterface2 = getAppInterface();
            if (appInterface2 != null) {
                IQQAvatarBroadcastService iQQAvatarBroadcastService = (IQQAvatarBroadcastService) appInterface2.getRuntimeService(IQQAvatarBroadcastService.class, "");
                iQQAvatarBroadcastService.sendQQHeadBroadcast(1, str, 0, str2);
                if (str.equals(appInterface2.getCurrentAccountUin())) {
                    iQQAvatarBroadcastService.sendSelfQQHeadBroadcast(1, str, 0, str2);
                }
                appInterface2.getBusinessHandler(QQAvatarHandlerApiImpl.MESSAGE_HANDLER).notifyUI(1, true, new Object[]{str, faceInfo});
            }
        }
    }

    private void removeCache(QQHeadInfo qQHeadInfo, String str, boolean z16) {
        AppRuntime peekAppRuntime;
        if (!z16 || (peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime()) == null) {
            return;
        }
        IQQAvatarDataService iQQAvatarDataService = (IQQAvatarDataService) peekAppRuntime.getRuntimeService(IQQAvatarDataService.class, "");
        byte b16 = qQHeadInfo.dstUsrType;
        if (b16 == 4) {
            iQQAvatarDataService.removeFaceIconCache(4, str, qQHeadInfo.idType);
            return;
        }
        if (b16 == 32) {
            iQQAvatarDataService.removeFaceIconCache(32, str, qQHeadInfo.idType);
            return;
        }
        if (b16 == 16) {
            iQQAvatarDataService.removeFaceIconCache(16, str, qQHeadInfo.idType);
        } else if (b16 == 116) {
            iQQAvatarDataService.removeFaceIconCacheApollo(116, str, qQHeadInfo.sizeType);
        } else {
            iQQAvatarDataService.removeFaceIconCache(1, str, qQHeadInfo.idType);
        }
    }

    private void removeFileCache(QQHeadInfo qQHeadInfo, String str, FaceInfo faceInfo) {
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime == null) {
            return;
        }
        byte b16 = qQHeadInfo.dstUsrType;
        if (b16 == 116) {
            com.tencent.mobileqq.avatar.utils.a.l(peekAppRuntime, b16, str);
        }
        if (faceInfo != null && faceInfo.isUserHeadType()) {
            ((IQQAvatarDataService) peekAppRuntime.getRuntimeService(IQQAvatarDataService.class, "")).removeFaceFileCache(faceInfo);
        }
    }

    private void savedQQHeadToStorage() {
        BaseApplication app;
        AppInterface appInterface = getAppInterface();
        if (appInterface == null || (app = appInterface.getApp()) == null) {
            return;
        }
        Context applicationContext = app.getApplicationContext();
        if (FaceUtil.isSavedQQHeadToStorage(applicationContext) && cu.e()) {
            synchronized (syncCopyQQHeadLock) {
                if (FaceUtil.isSavedQQHeadToStorage(applicationContext) && cu.e()) {
                    try {
                        FileUtils.copyDirectory("/data/data/com.tencent.mobileqq/files/head/", AppConstants.PATH_CUSTOM_HEAD_ROOT, true);
                    } catch (Exception e16) {
                        e16.printStackTrace();
                    }
                }
                FaceUtil.saveStoreQQHeadToApp(applicationContext, false);
            }
        }
    }

    private int setResultCodeByErrorCode(int i3) {
        if (i3 != 1) {
            if (i3 != 33) {
                if (i3 != 4) {
                    if (i3 != 5) {
                        return FaceConstant.HeadDownload.RESULT_CODE_QQHEAD_DOWNLOAD_PIC_HTTP_RESPONSE_FAIL;
                    }
                    return FaceConstant.HeadDownload.RESULT_CODE_QQHEAD_DOWNLOAD_PIC_EXCEPTION;
                }
                return FaceConstant.HeadDownload.RESULT_CODE_QQHEAD_SAVE_FILE_FAIL;
            }
            return FaceConstant.HeadDownload.RESULT_CODE_QQHEAD_STORGE_EXCEPTION;
        }
        return FaceConstant.HeadDownload.RESULT_CODE_QQHEAD_DOWNLOAD_PIC_NETWORK_FAIL;
    }

    private static void updateDbCache(Setting setting, FaceInfo faceInfo) {
        ((IQQAvatarDataService) MobileQQ.sMobileQQ.peekAppRuntime().getRuntimeService(IQQAvatarDataService.class, "")).updateSettingTableCache(setting);
        ProAvatarComponentInit.g(faceInfo);
    }

    /* JADX WARN: Removed duplicated region for block: B:37:0x0061  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x0066  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void writeTroopSystemHead(int i3, File file) throws IOException {
        InputStream inputStream;
        FileOutputStream fileOutputStream;
        if (i3 < 0 || i3 >= TROOPS_SYSTEM_HEADS.length) {
            i3 = 0;
        }
        FileOutputStream fileOutputStream2 = null;
        fileOutputStream2 = null;
        InputStream inputStream2 = null;
        try {
            inputStream = MobileQQ.sMobileQQ.getResources().openRawResource(TROOPS_SYSTEM_HEADS[i3]);
            try {
                byte[] bArr = new byte[512];
                fileOutputStream = new FileOutputStream(file);
                while (true) {
                    try {
                        int read = inputStream.read(bArr);
                        if (read > 0) {
                            fileOutputStream.write(bArr, 0, read);
                        } else {
                            fileOutputStream.close();
                            inputStream.close();
                            return;
                        }
                    } catch (Exception e16) {
                        e = e16;
                        inputStream2 = inputStream;
                        try {
                            if (QLog.isColorLevel()) {
                                QLog.e("Q.qqhead.QQHeadDownloadHandler", 2, "writeTroopSystemHead...", e);
                            }
                            if (fileOutputStream != null) {
                                fileOutputStream.close();
                            }
                            if (inputStream2 != null) {
                                inputStream2.close();
                                return;
                            }
                            return;
                        } catch (Throwable th5) {
                            th = th5;
                            inputStream = inputStream2;
                            fileOutputStream2 = fileOutputStream;
                            if (fileOutputStream2 != null) {
                                fileOutputStream2.close();
                            }
                            if (inputStream != null) {
                                inputStream.close();
                            }
                            throw th;
                        }
                    } catch (Throwable th6) {
                        th = th6;
                        fileOutputStream2 = fileOutputStream;
                        if (fileOutputStream2 != null) {
                        }
                        if (inputStream != null) {
                        }
                        throw th;
                    }
                }
            } catch (Exception e17) {
                e = e17;
                fileOutputStream = null;
            } catch (Throwable th7) {
                th = th7;
                if (fileOutputStream2 != null) {
                }
                if (inputStream != null) {
                }
                throw th;
            }
        } catch (Exception e18) {
            e = e18;
            fileOutputStream = null;
        } catch (Throwable th8) {
            th = th8;
            inputStream = null;
        }
    }

    /* JADX WARN: Can't wrap try/catch for region: R(19:(3:27|28|(2:29|30))|(3:34|35|(1:37)(17:38|(1:40)|42|43|45|46|48|49|(2:192|193)|51|(2:53|54)|101|(17:121|122|123|124|(4:175|176|177|(8:179|180|(1:182)|184|141|142|143|144))|126|(5:128|129|130|131|(4:162|163|164|165)(1:133))(1:173)|(10:135|136|137|138|139|140|141|142|143|144)(6:156|157|158|142|143|144)|120|74|75|76|77|(2:79|(1:84))|85|25|26)(4:103|104|105|106)|107|108|109|110))|207|(0)|42|43|45|46|48|49|(0)|51|(0)|101|(0)(0)|107|108|109|110) */
    /* JADX WARN: Can't wrap try/catch for region: R(21:27|28|(2:29|30)|(3:34|35|(1:37)(17:38|(1:40)|42|43|45|46|48|49|(2:192|193)|51|(2:53|54)|101|(17:121|122|123|124|(4:175|176|177|(8:179|180|(1:182)|184|141|142|143|144))|126|(5:128|129|130|131|(4:162|163|164|165)(1:133))(1:173)|(10:135|136|137|138|139|140|141|142|143|144)(6:156|157|158|142|143|144)|120|74|75|76|77|(2:79|(1:84))|85|25|26)(4:103|104|105|106)|107|108|109|110))|207|(0)|42|43|45|46|48|49|(0)|51|(0)|101|(0)(0)|107|108|109|110) */
    /* JADX WARN: Can't wrap try/catch for region: R(22:27|28|29|30|(3:34|35|(1:37)(17:38|(1:40)|42|43|45|46|48|49|(2:192|193)|51|(2:53|54)|101|(17:121|122|123|124|(4:175|176|177|(8:179|180|(1:182)|184|141|142|143|144))|126|(5:128|129|130|131|(4:162|163|164|165)(1:133))(1:173)|(10:135|136|137|138|139|140|141|142|143|144)(6:156|157|158|142|143|144)|120|74|75|76|77|(2:79|(1:84))|85|25|26)(4:103|104|105|106)|107|108|109|110))|207|(0)|42|43|45|46|48|49|(0)|51|(0)|101|(0)(0)|107|108|109|110) */
    /* JADX WARN: Code restructure failed: missing block: B:112:0x025b, code lost:
    
        r0 = th;
     */
    /* JADX WARN: Code restructure failed: missing block: B:113:0x025c, code lost:
    
        r14 = r10;
        r29 = "Q.qqhead.QQHeadDownloadHandler";
        r11 = "";
        r10 = r20;
        r12 = r6;
        r20 = r17;
        r17 = r22;
     */
    /* JADX WARN: Code restructure failed: missing block: B:194:0x027c, code lost:
    
        r0 = e;
     */
    /* JADX WARN: Code restructure failed: missing block: B:196:0x026f, code lost:
    
        r0 = th;
     */
    /* JADX WARN: Code restructure failed: missing block: B:197:0x0270, code lost:
    
        r19 = r5;
        r15 = null;
        r21 = r3;
     */
    /* JADX WARN: Code restructure failed: missing block: B:198:0x0294, code lost:
    
        r0 = e;
     */
    /* JADX WARN: Code restructure failed: missing block: B:199:0x0295, code lost:
    
        r23 = r6;
        r14 = 1;
        r15 = null;
        r5 = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:200:0x0284, code lost:
    
        r0 = th;
     */
    /* JADX WARN: Code restructure failed: missing block: B:201:0x0285, code lost:
    
        r15 = null;
        r21 = r3;
        r18 = r7;
        r14 = r10;
        r29 = "Q.qqhead.QQHeadDownloadHandler";
        r11 = "";
        r19 = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:202:0x0303, code lost:
    
        r0 = th;
     */
    /* JADX WARN: Code restructure failed: missing block: B:203:0x0304, code lost:
    
        r20 = r7;
        r8 = r10;
     */
    /* JADX WARN: Code restructure failed: missing block: B:204:0x030d, code lost:
    
        r15 = null;
        r21 = r3;
        r14 = r8;
        r29 = "Q.qqhead.QQHeadDownloadHandler";
        r11 = "";
        r19 = null;
        r10 = 0;
        r18 = r20;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:103:0x021f  */
    /* JADX WARN: Removed duplicated region for block: B:121:0x00f8 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:192:0x00cf A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:40:0x0099 A[Catch: all -> 0x009d, TRY_LEAVE, TryCatch #23 {all -> 0x009d, blocks: (B:35:0x0077, B:37:0x0080, B:38:0x008b, B:40:0x0099), top: B:34:0x0077 }] */
    /* JADX WARN: Removed duplicated region for block: B:53:0x00ee A[Catch: all -> 0x00d3, Exception -> 0x00e4, TRY_ENTER, TRY_LEAVE, TryCatch #23 {Exception -> 0x00e4, all -> 0x00d3, blocks: (B:193:0x00cf, B:53:0x00ee), top: B:192:0x00cf }] */
    /* JADX WARN: Removed duplicated region for block: B:79:0x0403  */
    /* JADX WARN: Type inference failed for: r1v13, types: [int] */
    /* JADX WARN: Type inference failed for: r1v32 */
    /* JADX WARN: Type inference failed for: r1v9 */
    /* JADX WARN: Type inference failed for: r6v4, types: [java.lang.StringBuilder] */
    @Override // com.tencent.mobileqq.app.face.FaceDownloader
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    protected void doDownloadFace(FaceInfo faceInfo) {
        QQHeadInfo qQHeadInfo;
        String str;
        String str2;
        ThreadExcutor.IThreadListener iThreadListener;
        AppInterface appInterface;
        String str3;
        int i3;
        String str4;
        boolean z16;
        boolean z17;
        boolean z18;
        String str5;
        AppInterface appInterface2;
        ?? r16;
        String str6;
        String str7;
        boolean z19;
        boolean z26;
        int i16;
        boolean booleanValue;
        Setting setting;
        boolean booleanValue2;
        Setting setting2;
        IQQClassicAvatarService iQQClassicAvatarService;
        File file;
        int i17;
        boolean z27;
        int i18;
        boolean z28;
        boolean z29;
        boolean z36;
        QQHeadInfo qQHeadInfo2;
        String str8;
        AppInterface appInterface3;
        byte b16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) faceInfo);
            return;
        }
        QQHeadInfo qQHeadInfo3 = faceInfo.mHeadInfo;
        String h36 = AvatarHandler.h3(qQHeadInfo3.uin, qQHeadInfo3.phoneNum);
        boolean z37 = false;
        if (getAvatarHandler() != null) {
            getAvatarHandler().A3(0, h36, qQHeadInfo3.dstUsrType, 3);
        }
        faceInfo.markTime(FaceInfo.TIME_BEGIN_DOWNLOAD);
        int i19 = 0;
        String str9 = qQHeadInfo3.downLoadUrl;
        boolean z38 = false;
        AppInterface appInterface4 = getAppInterface();
        try {
        } catch (Throwable th5) {
            th = th5;
            qQHeadInfo = qQHeadInfo3;
            str = "Q.qqhead.QQHeadDownloadHandler";
            str2 = "";
            iThreadListener = null;
            appInterface = appInterface4;
            str3 = null;
            i3 = 0;
            str4 = str9;
            z16 = false;
            z17 = false;
            z18 = false;
        }
        if (!TextUtils.isEmpty(qQHeadInfo3.downLoadUrl)) {
            try {
                Object[] faceSetting = getFaceSetting(faceInfo, h36, com.tencent.mobileqq.avatar.utils.c.j(qQHeadInfo3.dstUsrType, h36, qQHeadInfo3.idType), false, true);
                booleanValue = ((Boolean) faceSetting[0]).booleanValue();
                try {
                    setting = (Setting) faceSetting[1];
                    booleanValue2 = ((Boolean) faceSetting[2]).booleanValue();
                } catch (Throwable th6) {
                    th = th6;
                    String str10 = str9;
                    QQHeadInfo qQHeadInfo4 = qQHeadInfo3;
                }
            } catch (Throwable th7) {
                th = th7;
                iThreadListener = null;
                qQHeadInfo = qQHeadInfo3;
                str = "Q.qqhead.QQHeadDownloadHandler";
                str2 = "";
                str3 = null;
                i3 = 0;
                str4 = str9;
                z16 = false;
                z17 = false;
                z18 = false;
            }
            if (setting != null && (booleanValue || booleanValue2)) {
                try {
                    updateDbCache(setting, faceInfo);
                    b16 = qQHeadInfo3.dstUsrType;
                } catch (Throwable th8) {
                    th = th8;
                    z18 = booleanValue;
                    str4 = str9;
                    z17 = false;
                    qQHeadInfo = qQHeadInfo3;
                    str = "Q.qqhead.QQHeadDownloadHandler";
                    str2 = "";
                    i3 = 0;
                    iThreadListener = null;
                    str3 = null;
                    appInterface = appInterface4;
                    z16 = z17;
                    try {
                        String str11 = str;
                        QLog.e(str11, 1, "doDownloadFace catch throwable: ", th);
                        str5 = str11;
                        String str12 = str2;
                        appInterface2 = appInterface;
                        ThreadManagerV2.postImmediately(new HeadCostStatRunnable(FaceConstant.HeadDownload.RESULT_CODE_QQHEAD_DOWNLOAD_PIC_EXCEPTION, h36, qQHeadInfo.idType, qQHeadInfo.sizeType, qQHeadInfo.dstUsrType, 4, i3, str4, z38 ? 1 : 0, System.currentTimeMillis()), iThreadListener, false);
                        if (appInterface2 != null) {
                        }
                        r16 = z16;
                        str6 = str4;
                        str7 = str3;
                        z19 = z17;
                        z26 = z18;
                        i16 = 9204;
                        com.tencent.mobileqq.avatar.api.a.a(z19, i16, "1");
                        QLog.d(str5, 1, "handleDonwnloadQQHead . isDownSuccess=" + z19 + ", resultCode=" + i16 + ", isNeedDownload=" + z26 + ", reasonCode=" + r16 + ",faceInfo=[" + faceInfo + "],headInfo=[" + qQHeadInfo + "], facePath=" + str7 + ", downUrl=" + str6);
                    } catch (Throwable th9) {
                        String str13 = str2;
                        AppInterface appInterface5 = appInterface;
                        QQHeadInfo qQHeadInfo5 = qQHeadInfo;
                        ThreadManagerV2.postImmediately(new HeadCostStatRunnable(FaceConstant.HeadDownload.RESULT_CODE_QQHEAD_DOWNLOAD_PIC_EXCEPTION, h36, qQHeadInfo.idType, qQHeadInfo.sizeType, qQHeadInfo.dstUsrType, 4, i3, str4, z38 ? 1 : 0, System.currentTimeMillis()), null, false);
                        if (appInterface5 != null) {
                            IQQClassicAvatarService iQQClassicAvatarService2 = (IQQClassicAvatarService) appInterface5.getRuntimeService(IQQClassicAvatarService.class, str13);
                            if (!z17 && iQQClassicAvatarService2 != null && iQQClassicAvatarService2.isClassicHeadActivityActivate()) {
                                iQQClassicAvatarService2.handleGetHeadError(String.valueOf(qQHeadInfo5.uin));
                            }
                        }
                        throw th9;
                    }
                }
                if (b16 == 11) {
                    AvatarInfoCheck.b(b16, qQHeadInfo3.phoneNum);
                    AvatarInfoCheck.b(1, qQHeadInfo3.phoneNum);
                } else {
                    setting2 = setting;
                    AvatarInfoCheck.b(b16, String.valueOf(qQHeadInfo3.uin));
                    if (booleanValue) {
                        removeFileCache(qQHeadInfo3, h36, faceInfo);
                    }
                    savedQQHeadToStorage();
                    String str14 = getFaceFilePath(setting2, faceInfo, qQHeadInfo3);
                    file = new File(str14.substring(0, str14.lastIndexOf("/")));
                    if (!file.exists()) {
                        try {
                            file.mkdirs();
                        } catch (Exception e16) {
                            e = e16;
                            AppInterface appInterface6 = appInterface4;
                            int i26 = 1;
                            iThreadListener = null;
                            try {
                                QLog.w("Q.qqhead.QQHeadDownloadHandler", i26, "doDownloadFace exception", e);
                                ThreadManagerV2.postImmediately(new HeadCostStatRunnable(FaceConstant.HeadDownload.RESULT_CODE_QQHEAD_SAVE_FILE_FAIL, h36, qQHeadInfo3.idType, qQHeadInfo3.sizeType, qQHeadInfo3.dstUsrType, 4, 0, str9, 0, System.currentTimeMillis()), iThreadListener, false);
                                if (appInterface6 != null && (iQQClassicAvatarService = (IQQClassicAvatarService) appInterface6.getRuntimeService(IQQClassicAvatarService.class, "")) != null && iQQClassicAvatarService.isClassicHeadActivityActivate()) {
                                    iQQClassicAvatarService.handleGetHeadError(String.valueOf(qQHeadInfo3.uin));
                                    return;
                                }
                                return;
                            } catch (Throwable th10) {
                                th = th10;
                                z18 = booleanValue;
                                str3 = str14;
                                qQHeadInfo = qQHeadInfo3;
                                str = "Q.qqhead.QQHeadDownloadHandler";
                                str2 = "";
                                i3 = 0;
                                str4 = str9;
                                appInterface = appInterface6;
                                z16 = false;
                                z17 = false;
                            }
                        } catch (Throwable th11) {
                            th = th11;
                            z18 = booleanValue;
                            str3 = str14;
                            str4 = str9;
                            z17 = z37;
                            qQHeadInfo = qQHeadInfo3;
                            str = "Q.qqhead.QQHeadDownloadHandler";
                            str2 = "";
                            i3 = 0;
                            iThreadListener = null;
                            appInterface = appInterface4;
                            z16 = z17;
                            String str112 = str;
                            QLog.e(str112, 1, "doDownloadFace catch throwable: ", th);
                            str5 = str112;
                            String str122 = str2;
                            appInterface2 = appInterface;
                            ThreadManagerV2.postImmediately(new HeadCostStatRunnable(FaceConstant.HeadDownload.RESULT_CODE_QQHEAD_DOWNLOAD_PIC_EXCEPTION, h36, qQHeadInfo.idType, qQHeadInfo.sizeType, qQHeadInfo.dstUsrType, 4, i3, str4, z38 ? 1 : 0, System.currentTimeMillis()), iThreadListener, false);
                            if (appInterface2 != null) {
                            }
                            r16 = z16;
                            str6 = str4;
                            str7 = str3;
                            z19 = z17;
                            z26 = z18;
                            i16 = 9204;
                            com.tencent.mobileqq.avatar.api.a.a(z19, i16, "1");
                            QLog.d(str5, 1, "handleDonwnloadQQHead . isDownSuccess=" + z19 + ", resultCode=" + i16 + ", isNeedDownload=" + z26 + ", reasonCode=" + r16 + ",faceInfo=[" + faceInfo + "],headInfo=[" + qQHeadInfo + "], facePath=" + str7 + ", downUrl=" + str6);
                        }
                    }
                    File file2 = new File(str14);
                    if (!booleanValue) {
                        booleanValue = !file2.exists();
                    }
                    z18 = booleanValue;
                    if (!z18) {
                        try {
                            String qQHeadDownloadUrl = getQQHeadDownloadUrl(faceInfo, false);
                            try {
                                QLog.d("Q.qqhead.QQHeadDownloadHandler", 2, "doDownloadFace FaceInfo= " + faceInfo + ", QQHeadInfo= " + faceInfo.mHeadInfo);
                                StringBuilder sb5 = new StringBuilder();
                                sb5.append("doDownloadFace downloadUrl= ");
                                sb5.append(qQHeadDownloadUrl);
                                QLog.d("Q.qqhead.QQHeadDownloadHandler", 2, sb5.toString());
                                if (qQHeadInfo3.cHeadType == 0) {
                                    try {
                                        if (qQHeadInfo3.dstUsrType == 4) {
                                            try {
                                                if (!file2.exists()) {
                                                    writeTroopSystemHead(qQHeadInfo3.systemHeadID, file2);
                                                }
                                                i16 = 0;
                                                i17 = 0;
                                                z27 = true;
                                            } catch (Exception unused) {
                                                i16 = FaceConstant.HeadDownload.RESULT_CODE_QQHEAD_SAVE_FILE_FAIL;
                                                i17 = 0;
                                                z27 = false;
                                            }
                                            try {
                                                removeCache(qQHeadInfo3, h36, z27);
                                                str4 = qQHeadDownloadUrl;
                                                i18 = i19;
                                                z28 = z38;
                                                z16 = i17;
                                                z29 = z27;
                                                z36 = true;
                                            } catch (Throwable th12) {
                                                th = th12;
                                                str4 = qQHeadDownloadUrl;
                                                z17 = z27;
                                                str3 = str14;
                                                qQHeadInfo = qQHeadInfo3;
                                                str = "Q.qqhead.QQHeadDownloadHandler";
                                                str2 = "";
                                                i3 = i19;
                                                iThreadListener = null;
                                                z16 = i17;
                                            }
                                        }
                                    } catch (Throwable th13) {
                                        th = th13;
                                        str4 = qQHeadDownloadUrl;
                                        str3 = str14;
                                        z17 = z37;
                                        qQHeadInfo = qQHeadInfo3;
                                        str = "Q.qqhead.QQHeadDownloadHandler";
                                        str2 = "";
                                        i3 = 0;
                                        iThreadListener = null;
                                        appInterface = appInterface4;
                                        z16 = z17;
                                        String str1122 = str;
                                        QLog.e(str1122, 1, "doDownloadFace catch throwable: ", th);
                                        str5 = str1122;
                                        String str1222 = str2;
                                        appInterface2 = appInterface;
                                        ThreadManagerV2.postImmediately(new HeadCostStatRunnable(FaceConstant.HeadDownload.RESULT_CODE_QQHEAD_DOWNLOAD_PIC_EXCEPTION, h36, qQHeadInfo.idType, qQHeadInfo.sizeType, qQHeadInfo.dstUsrType, 4, i3, str4, z38 ? 1 : 0, System.currentTimeMillis()), iThreadListener, false);
                                        if (appInterface2 != null) {
                                        }
                                        r16 = z16;
                                        str6 = str4;
                                        str7 = str3;
                                        z19 = z17;
                                        z26 = z18;
                                        i16 = 9204;
                                        com.tencent.mobileqq.avatar.api.a.a(z19, i16, "1");
                                        QLog.d(str5, 1, "handleDonwnloadQQHead . isDownSuccess=" + z19 + ", resultCode=" + i16 + ", isNeedDownload=" + z26 + ", reasonCode=" + r16 + ",faceInfo=[" + faceInfo + "],headInfo=[" + qQHeadInfo + "], facePath=" + str7 + ", downUrl=" + str6);
                                    }
                                }
                                i17 = downloadData(qQHeadDownloadUrl, file2, faceInfo, false);
                                if (i17 != 0) {
                                    try {
                                        if (NetConnInfoCenter.getActiveNetIpFamily(true) == 3) {
                                            try {
                                                qQHeadDownloadUrl = getQQHeadDownloadUrl(faceInfo, true);
                                                z37 = false;
                                                i17 = downloadData(qQHeadDownloadUrl, file2, faceInfo, false);
                                                QLog.d("Q.qqhead.QQHeadDownloadHandler", 1, "doDownloadFace() traAgain downLoadUrl = " + qQHeadDownloadUrl + " errCode  =" + i17);
                                            } catch (Throwable th14) {
                                                th = th14;
                                                z37 = false;
                                                z38 = i17;
                                                str4 = qQHeadDownloadUrl;
                                                str3 = str14;
                                                z17 = z37;
                                                qQHeadInfo = qQHeadInfo3;
                                                str = "Q.qqhead.QQHeadDownloadHandler";
                                                str2 = "";
                                                i3 = 0;
                                                iThreadListener = null;
                                                appInterface = appInterface4;
                                                z16 = z17;
                                                String str11222 = str;
                                                QLog.e(str11222, 1, "doDownloadFace catch throwable: ", th);
                                                str5 = str11222;
                                                String str12222 = str2;
                                                appInterface2 = appInterface;
                                                ThreadManagerV2.postImmediately(new HeadCostStatRunnable(FaceConstant.HeadDownload.RESULT_CODE_QQHEAD_DOWNLOAD_PIC_EXCEPTION, h36, qQHeadInfo.idType, qQHeadInfo.sizeType, qQHeadInfo.dstUsrType, 4, i3, str4, z38 ? 1 : 0, System.currentTimeMillis()), iThreadListener, false);
                                                if (appInterface2 != null) {
                                                }
                                                r16 = z16;
                                                str6 = str4;
                                                str7 = str3;
                                                z19 = z17;
                                                z26 = z18;
                                                i16 = 9204;
                                                com.tencent.mobileqq.avatar.api.a.a(z19, i16, "1");
                                                QLog.d(str5, 1, "handleDonwnloadQQHead . isDownSuccess=" + z19 + ", resultCode=" + i16 + ", isNeedDownload=" + z26 + ", reasonCode=" + r16 + ",faceInfo=[" + faceInfo + "],headInfo=[" + qQHeadInfo + "], facePath=" + str7 + ", downUrl=" + str6);
                                            }
                                        }
                                    } catch (Throwable th15) {
                                        th = th15;
                                    }
                                }
                                if (i17 == 0) {
                                    try {
                                        int length = (int) file2.length();
                                        try {
                                            updateDbCache(setting2, faceInfo);
                                            this.mSubhandler.postAtFrontOfQueue(new UpdateSettingRunnable(setting2, faceInfo, getAvatarHandler()));
                                            z38 = i17;
                                            i19 = length;
                                            i16 = 0;
                                            i17 = 0;
                                            z27 = true;
                                            removeCache(qQHeadInfo3, h36, z27);
                                            str4 = qQHeadDownloadUrl;
                                            i18 = i19;
                                            z28 = z38;
                                            z16 = i17;
                                            z29 = z27;
                                            z36 = true;
                                        } catch (Throwable th16) {
                                            th = th16;
                                            z38 = i17;
                                            str4 = qQHeadDownloadUrl;
                                            str3 = str14;
                                            qQHeadInfo = qQHeadInfo3;
                                            str = "Q.qqhead.QQHeadDownloadHandler";
                                            str2 = "";
                                            iThreadListener = null;
                                            z16 = false;
                                            z17 = true;
                                            i3 = length;
                                        }
                                    } catch (Throwable th17) {
                                        th = th17;
                                        z38 = i17;
                                        str4 = qQHeadDownloadUrl;
                                        str3 = str14;
                                        qQHeadInfo = qQHeadInfo3;
                                        str = "Q.qqhead.QQHeadDownloadHandler";
                                        str2 = "";
                                        i3 = 0;
                                        iThreadListener = null;
                                        z16 = false;
                                        z17 = false;
                                        appInterface = appInterface4;
                                        String str112222 = str;
                                        QLog.e(str112222, 1, "doDownloadFace catch throwable: ", th);
                                        str5 = str112222;
                                        String str122222 = str2;
                                        appInterface2 = appInterface;
                                        ThreadManagerV2.postImmediately(new HeadCostStatRunnable(FaceConstant.HeadDownload.RESULT_CODE_QQHEAD_DOWNLOAD_PIC_EXCEPTION, h36, qQHeadInfo.idType, qQHeadInfo.sizeType, qQHeadInfo.dstUsrType, 4, i3, str4, z38 ? 1 : 0, System.currentTimeMillis()), iThreadListener, false);
                                        if (appInterface2 != null) {
                                        }
                                        r16 = z16;
                                        str6 = str4;
                                        str7 = str3;
                                        z19 = z17;
                                        z26 = z18;
                                        i16 = 9204;
                                        com.tencent.mobileqq.avatar.api.a.a(z19, i16, "1");
                                        QLog.d(str5, 1, "handleDonwnloadQQHead . isDownSuccess=" + z19 + ", resultCode=" + i16 + ", isNeedDownload=" + z26 + ", reasonCode=" + r16 + ",faceInfo=[" + faceInfo + "],headInfo=[" + qQHeadInfo + "], facePath=" + str7 + ", downUrl=" + str6);
                                    }
                                } else {
                                    try {
                                        i16 = setResultCodeByErrorCode(i17);
                                        z38 = i17;
                                        z27 = false;
                                        removeCache(qQHeadInfo3, h36, z27);
                                        str4 = qQHeadDownloadUrl;
                                        i18 = i19;
                                        z28 = z38;
                                        z16 = i17;
                                        z29 = z27;
                                        z36 = true;
                                    } catch (Throwable th18) {
                                        th = th18;
                                        z38 = i17;
                                        str4 = qQHeadDownloadUrl;
                                        str3 = str14;
                                        qQHeadInfo = qQHeadInfo3;
                                        str = "Q.qqhead.QQHeadDownloadHandler";
                                        str2 = "";
                                        i3 = 0;
                                        iThreadListener = null;
                                        z17 = false;
                                        z16 = z38;
                                    }
                                }
                            } catch (Throwable th19) {
                                th = th19;
                            }
                        } catch (Throwable th20) {
                            th = th20;
                            str3 = str14;
                            str4 = str9;
                        }
                        appInterface = appInterface4;
                        String str1122222 = str;
                        QLog.e(str1122222, 1, "doDownloadFace catch throwable: ", th);
                        str5 = str1122222;
                        String str1222222 = str2;
                        appInterface2 = appInterface;
                        ThreadManagerV2.postImmediately(new HeadCostStatRunnable(FaceConstant.HeadDownload.RESULT_CODE_QQHEAD_DOWNLOAD_PIC_EXCEPTION, h36, qQHeadInfo.idType, qQHeadInfo.sizeType, qQHeadInfo.dstUsrType, 4, i3, str4, z38 ? 1 : 0, System.currentTimeMillis()), iThreadListener, false);
                        if (appInterface2 != null) {
                            IQQClassicAvatarService iQQClassicAvatarService3 = (IQQClassicAvatarService) appInterface2.getRuntimeService(IQQClassicAvatarService.class, str1222222);
                            if (!z17 && iQQClassicAvatarService3 != null && iQQClassicAvatarService3.isClassicHeadActivityActivate()) {
                                iQQClassicAvatarService3.handleGetHeadError(String.valueOf(qQHeadInfo.uin));
                            }
                        }
                        r16 = z16;
                        str6 = str4;
                        str7 = str3;
                        z19 = z17;
                        z26 = z18;
                        i16 = 9204;
                        com.tencent.mobileqq.avatar.api.a.a(z19, i16, "1");
                        QLog.d(str5, 1, "handleDonwnloadQQHead . isDownSuccess=" + z19 + ", resultCode=" + i16 + ", isNeedDownload=" + z26 + ", reasonCode=" + r16 + ",faceInfo=[" + faceInfo + "],headInfo=[" + qQHeadInfo + "], facePath=" + str7 + ", downUrl=" + str6);
                    }
                    z36 = true;
                    try {
                        updateDbCache(setting2, faceInfo);
                        this.mSubhandler.postAtFrontOfQueue(new UpdateSettingRunnable(setting2, faceInfo, getAvatarHandler()));
                        str4 = str9;
                        i18 = 0;
                        z28 = false;
                        i16 = 0;
                        z16 = false;
                        z29 = false;
                    } catch (Throwable th21) {
                        th = th21;
                        str3 = str14;
                        iThreadListener = null;
                        str4 = str9;
                        qQHeadInfo = qQHeadInfo3;
                        str = "Q.qqhead.QQHeadDownloadHandler";
                        str2 = "";
                        i3 = 0;
                        z16 = false;
                        z17 = false;
                        appInterface = appInterface4;
                        String str11222222 = str;
                        QLog.e(str11222222, 1, "doDownloadFace catch throwable: ", th);
                        str5 = str11222222;
                        String str12222222 = str2;
                        appInterface2 = appInterface;
                        ThreadManagerV2.postImmediately(new HeadCostStatRunnable(FaceConstant.HeadDownload.RESULT_CODE_QQHEAD_DOWNLOAD_PIC_EXCEPTION, h36, qQHeadInfo.idType, qQHeadInfo.sizeType, qQHeadInfo.dstUsrType, 4, i3, str4, z38 ? 1 : 0, System.currentTimeMillis()), iThreadListener, false);
                        if (appInterface2 != null) {
                        }
                        r16 = z16;
                        str6 = str4;
                        str7 = str3;
                        z19 = z17;
                        z26 = z18;
                        i16 = 9204;
                        com.tencent.mobileqq.avatar.api.a.a(z19, i16, "1");
                        QLog.d(str5, 1, "handleDonwnloadQQHead . isDownSuccess=" + z19 + ", resultCode=" + i16 + ", isNeedDownload=" + z26 + ", reasonCode=" + r16 + ",faceInfo=[" + faceInfo + "],headInfo=[" + qQHeadInfo + "], facePath=" + str7 + ", downUrl=" + str6);
                    }
                    str3 = str14;
                    iThreadListener = null;
                    notifyDownloadHeadComplete(qQHeadInfo3, h36, str14, z18, z29, str4, faceInfo);
                    qQHeadInfo2 = qQHeadInfo3;
                    str8 = "";
                    appInterface3 = appInterface4;
                }
            }
            setting2 = setting;
            if (booleanValue) {
            }
            savedQQHeadToStorage();
            String str142 = getFaceFilePath(setting2, faceInfo, qQHeadInfo3);
            file = new File(str142.substring(0, str142.lastIndexOf("/")));
            if (!file.exists()) {
            }
            File file22 = new File(str142);
            if (!booleanValue) {
            }
            z18 = booleanValue;
            if (!z18) {
            }
            str3 = str142;
            iThreadListener = null;
            notifyDownloadHeadComplete(qQHeadInfo3, h36, str142, z18, z29, str4, faceInfo);
            qQHeadInfo2 = qQHeadInfo3;
            str8 = "";
            appInterface3 = appInterface4;
        } else {
            qQHeadInfo2 = qQHeadInfo3;
            str8 = "";
            iThreadListener = null;
            appInterface3 = appInterface4;
            str3 = null;
            z28 = false;
            str4 = str9;
            i16 = 0;
            z29 = false;
            z18 = false;
            i18 = 0;
            z16 = false;
        }
        qQHeadInfo = qQHeadInfo2;
        String str15 = str8;
        AppInterface appInterface7 = appInterface3;
        ThreadManagerV2.postImmediately(new HeadCostStatRunnable(i16, h36, qQHeadInfo2.idType, qQHeadInfo2.sizeType, qQHeadInfo2.dstUsrType, 4, i18, str4, z28 ? 1 : 0, System.currentTimeMillis()), iThreadListener, false);
        if (appInterface7 != null) {
            IQQClassicAvatarService iQQClassicAvatarService4 = (IQQClassicAvatarService) appInterface7.getRuntimeService(IQQClassicAvatarService.class, str15);
            if (!z29 && iQQClassicAvatarService4 != null && iQQClassicAvatarService4.isClassicHeadActivityActivate()) {
                iQQClassicAvatarService4.handleGetHeadError(String.valueOf(qQHeadInfo.uin));
            }
        }
        r16 = z16;
        z19 = z29;
        str6 = str4;
        str7 = str3;
        z26 = z18;
        str5 = "Q.qqhead.QQHeadDownloadHandler";
        com.tencent.mobileqq.avatar.api.a.a(z19, i16, "1");
        QLog.d(str5, 1, "handleDonwnloadQQHead . isDownSuccess=" + z19 + ", resultCode=" + i16 + ", isNeedDownload=" + z26 + ", reasonCode=" + r16 + ",faceInfo=[" + faceInfo + "],headInfo=[" + qQHeadInfo + "], facePath=" + str7 + ", downUrl=" + str6);
    }

    @Override // com.tencent.mobileqq.app.face.FaceDownloader
    public String getChoosedIP() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            return (String) iPatchRedirector.redirect((short) 1, (Object) this);
        }
        return ah.b(0);
    }

    @Override // com.tencent.mobileqq.app.face.FaceDownloader
    public String getChoosedStrangerGroupIp() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (String) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return ah.b(1);
    }
}

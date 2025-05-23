package com.tencent.mobileqq.avatar.api.impl;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Pair;
import androidx.annotation.Nullable;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.LogTag;
import com.tencent.mobileqq.app.face.FaceConstant;
import com.tencent.mobileqq.app.face.FaceInfo;
import com.tencent.mobileqq.app.face.util.AvatarOptimiseConfigUtil;
import com.tencent.mobileqq.avatar.api.IQQAvatarDataService;
import com.tencent.mobileqq.avatar.api.IQQZplanOutsideAvatarApi;
import com.tencent.mobileqq.avatar.utils.Md5Utils;
import com.tencent.mobileqq.avatar.utils.ProAvatarComponentUtils;
import com.tencent.mobileqq.data.Setting;
import com.tencent.mobileqq.perf.block.DBMethodProxy;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.proavatar.ProAvatarComponentInit;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qqfeatureswitch.IFeatureRuntimeService;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import com.tencent.mobileqq.util.cu;
import com.tencent.mobileqq.util.j;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.StringUtil;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import mqq.app.AppRuntime;
import oicq.wlogin_sdk.tools.util;

/* compiled from: P */
/* loaded from: classes11.dex */
public class QQAvatarDataServiceImpl implements IQQAvatarDataService {
    static IPatchRedirector $redirector_ = null;
    private static final boolean DEFAULT_SUPPORT_HD_HEAD_SIZE = false;
    private static final String TAG = "Q.qqhead.QQAvatarDataServiceImpl";
    public static String historyAvatarpath;
    private boolean isSupportDecodeHeadSize;
    private AppRuntime mApp;
    private w91.a<Bitmap> mAvatarCache;
    private volatile w91.a<Setting> mAvatarSettingCache;
    private EntityManager mEntityManager;
    private volatile boolean mIsSettingDBInitFinish;
    private int mMaxSize;
    private final Object mSettingCacheLock;
    private final Object mSettingDBInitLock;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(19552);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 35)) {
            redirector.redirect((short) 35);
        } else {
            historyAvatarpath = "";
        }
    }

    public QQAvatarDataServiceImpl() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.mSettingCacheLock = new Object();
        this.mSettingDBInitLock = new Object();
        this.mIsSettingDBInitFinish = false;
        this.isSupportDecodeHeadSize = false;
    }

    private void checkAndCreateFaceSettingCache() {
        if (this.mAvatarSettingCache == null) {
            QLog.i(LogTag.QQ_HEAD, 1, Thread.currentThread().getName() + "\u5c1d\u8bd5\u8fdb\u884c mAvatarSettingCache new \u7684\u521d\u59cb\u5316\uff0cstack = ", new RuntimeException("new mAvatarSettingCache"));
            synchronized (this.mSettingCacheLock) {
                if (this.mAvatarSettingCache == null) {
                    this.mAvatarSettingCache = new com.tencent.mobileqq.avatar.cache.memory.avatarsetting.a(this.mMaxSize);
                    QLog.i(LogTag.QQ_HEAD, 1, Thread.currentThread().getName() + "\u5b8c\u6210\u4e86 mAvatarSettingCache new \u7684\u8fc7\u7a0b\uff0cstack = ", new RuntimeException("new mAvatarSettingCache"));
                }
            }
        }
    }

    private void checkAndInitAvatarCache() {
        if (this.mAvatarCache == null) {
            this.mAvatarCache = new com.tencent.mobileqq.avatar.cache.memory.avatar.a();
        }
    }

    private static String getFaceFilePathPrefix(int i3) {
        StringBuilder sb5 = new StringBuilder();
        if (i3 == 32) {
            if (cu.e()) {
                sb5.append(AppConstants.PATH_HEAD_STRANGER);
            } else {
                sb5.append("/data/data/com.tencent.mobileqq/files/head/_stranger/");
            }
        } else if (i3 == 116) {
            if (cu.e()) {
                sb5.append(AppConstants.PATH_HEAD_APOLLO);
            } else {
                sb5.append("/data/data/com.tencent.mobileqq/files/head/_apollo/");
            }
        } else if (cu.e()) {
            sb5.append(AppConstants.PATH_HEAD_HD);
        } else {
            sb5.append("/data/data/com.tencent.mobileqq/files/head/_hd/");
        }
        return sb5.toString();
    }

    private Object[] getNewFaceTypeBySetting(Setting setting, String str, int i3) {
        if (setting != null && i3 != 101 && i3 != 1001 && i3 != 116 && i3 != 113 && str != null && setting.bHeadType == 0) {
            str = String.valueOf((int) setting.systemHeadID);
            if (i3 == 4) {
                i3 = -56;
            } else if (i3 == 16) {
                i3 = 16;
            } else {
                i3 = -55;
            }
        }
        return new Object[]{Integer.valueOf(i3), str};
    }

    private static void initAvatarCompose() {
        ProAvatarComponentInit.d();
        com.tencent.mobileqq.proavatar.utils.c.a();
    }

    private void initMaxSize() {
        int i3;
        boolean isSwitchOn = ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("101337", false);
        if (isSwitchOn) {
            i3 = 4000;
        } else {
            i3 = 2000;
        }
        this.mMaxSize = i3;
        QLog.i(TAG, 1, "initMaxSize isSwitchOn: " + isSwitchOn + ", mMaxSize:" + this.mMaxSize);
    }

    private boolean isFaceFileExistInternal(int i3, String str, int i16, int i17, FaceInfo faceInfo) {
        String faceBitmapCacheKey = getFaceBitmapCacheKey(i3, str, (byte) 3, i16, i17, false, faceInfo);
        checkAndInitAvatarCache();
        w91.a<Bitmap> aVar = this.mAvatarCache;
        if (aVar != null && aVar.get(faceBitmapCacheKey) != null) {
            return true;
        }
        File file = new File(getCustomFaceFilePath(null, i3, str, i16, i17, faceInfo));
        if (file.exists() && file.isFile()) {
            return true;
        }
        return false;
    }

    @Override // com.tencent.mobileqq.avatar.api.IQQAvatarDataService
    public Bitmap getBitmapFromCache(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (Bitmap) iPatchRedirector.redirect((short) 6, (Object) this, (Object) str);
        }
        checkAndInitAvatarCache();
        try {
            return this.mAvatarCache.get(str);
        } catch (ArrayIndexOutOfBoundsException e16) {
            QLog.e(TAG, 1, e16, new Object[0]);
            return null;
        }
    }

    @Override // com.tencent.mobileqq.avatar.api.IQQAvatarDataService
    public String getCustomFaceFilePath(boolean z16, String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            return (String) iPatchRedirector.redirect((short) 19, this, Boolean.valueOf(z16), str);
        }
        if (z16) {
            return getCustomFaceFilePath(null, 4, str, 0, 0);
        }
        return getCustomFaceFilePath(null, 1, str, 0, 0);
    }

    @Override // com.tencent.mobileqq.avatar.api.IQQAvatarDataService
    public String getCustomFaceFilePathBySetting(Setting setting, int i3, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 26)) {
            return (String) iPatchRedirector.redirect((short) 26, this, setting, Integer.valueOf(i3), Integer.valueOf(i16));
        }
        if (setting == null) {
            return "";
        }
        byte b16 = setting.bUsrType;
        String i17 = com.tencent.mobileqq.avatar.utils.b.i(setting.uin);
        return TextUtils.isEmpty(i17) ? "" : getCustomFaceFilePath(setting, b16, i17, i3, i16);
    }

    protected EntityManager getEntityManager() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (EntityManager) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        if (this.mApp.getAccount() == null) {
            QLog.e(TAG, 1, "getEntityManager return null, app account is null");
            return null;
        }
        AppRuntime appRuntime = this.mApp;
        return appRuntime.getEntityManagerFactory(appRuntime.getAccount()).createEntityManager();
    }

    @Override // com.tencent.mobileqq.avatar.api.IQQAvatarDataService
    public String getFaceBitmapCacheKey(int i3, String str, byte b16, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 8)) ? getFaceBitmapCacheKey(i3, str, b16, i16, 100, false) : (String) iPatchRedirector.redirect((short) 8, this, Integer.valueOf(i3), str, Byte.valueOf(b16), Integer.valueOf(i16));
    }

    @Override // com.tencent.mobileqq.avatar.api.IQQAvatarDataService
    public Setting getFaceSetting(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 28)) {
            return (Setting) iPatchRedirector.redirect((short) 28, (Object) this, (Object) str);
        }
        if (this.mAvatarSettingCache == null) {
            return null;
        }
        return this.mAvatarSettingCache.get(str);
    }

    @Override // com.tencent.mobileqq.avatar.api.IQQAvatarDataService
    public String getHistoryAvatarPath() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 24)) {
            return (String) iPatchRedirector.redirect((short) 24, (Object) this);
        }
        return historyAvatarpath;
    }

    @Override // com.tencent.mobileqq.avatar.api.IQQAvatarDataService
    public String getOldCustomFaceFilePath(int i3, String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return (String) iPatchRedirector.redirect((short) 11, (Object) this, i3, (Object) str);
        }
        String b16 = Md5Utils.b(Md5Utils.b(Md5Utils.b(str) + str) + str);
        StringBuilder sb5 = new StringBuilder(256);
        if (i3 == 4) {
            if (cu.e()) {
                sb5.append(AppConstants.PATH_HEAD_THD);
            } else {
                sb5.append("/data/data/com.tencent.mobileqq/files/head/_thd/");
            }
        } else if (cu.e()) {
            sb5.append(AppConstants.PATH_HEAD_HD);
        } else {
            sb5.append("/data/data/com.tencent.mobileqq/files/head/_hd/");
        }
        if (i3 == 101) {
            sb5.append("discussion_");
        }
        sb5.append(b16);
        sb5.append(".png");
        return sb5.toString();
    }

    @Override // com.tencent.mobileqq.avatar.api.IQQAvatarDataService
    public Pair<Boolean, Setting> getQQHeadSetting(int i3, String str, int i16) {
        Setting setting;
        IPatchRedirector iPatchRedirector = $redirector_;
        boolean z16 = true;
        boolean z17 = false;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 29)) {
            return (Pair) iPatchRedirector.redirect((short) 29, this, Integer.valueOf(i3), str, Integer.valueOf(i16));
        }
        String j3 = com.tencent.mobileqq.avatar.utils.c.j(i3, str, i16);
        if (!TextUtils.isEmpty(j3) && this.mAvatarSettingCache != null) {
            setting = this.mAvatarSettingCache.get(j3);
        } else {
            setting = null;
        }
        if (setting == null) {
            if (this.mEntityManager == null) {
                this.mEntityManager = getEntityManager();
            }
            if (!TextUtils.isEmpty(j3) && this.mEntityManager != null) {
                checkAndCreateFaceSettingCache();
                setting = (Setting) DBMethodProxy.find(this.mEntityManager, (Class<? extends Entity>) Setting.class, j3);
                if (setting != null && this.mAvatarSettingCache != null) {
                    this.mAvatarSettingCache.put(j3, setting);
                }
            }
        }
        if (setting == null) {
            if (QLog.isDevelopLevel()) {
                QLog.i(LogTag.QQ_HEAD, 4, "getQQHeadSetting. qqset is null, | uin=" + str);
            }
            return new Pair<>(Boolean.TRUE, setting);
        }
        if (i3 == 1 || i3 == 4 || i3 == 11 || i3 == 16 || i3 == 32 || i3 == 116) {
            if (System.currentTimeMillis() - setting.updateTimestamp <= 86400000) {
                z16 = false;
            }
            z17 = z16;
        }
        if (QLog.isDevelopLevel() && z17) {
            QLog.i(LogTag.QQ_HEAD, 2, "getQQHeadSetting. | uin=" + str + ", isNeedCheckQQHead=" + z17 + ", updateTimestamp=" + setting.updateTimestamp + ", headImgTimestamp=" + setting.headImgTimestamp + ", status=" + setting.getStatus() + ", id=" + setting.getId() + ", currentTimeMillis=" + System.currentTimeMillis());
        }
        return new Pair<>(Boolean.valueOf(z17), setting);
    }

    @Override // com.tencent.mobileqq.avatar.api.IQQAvatarDataService
    public Setting getQQHeadSettingFromDB(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 30)) {
            return (Setting) iPatchRedirector.redirect((short) 30, (Object) this, (Object) str);
        }
        try {
            try {
                if (this.mEntityManager == null) {
                    this.mEntityManager = getEntityManager();
                }
                Setting setting = (Setting) DBMethodProxy.find(this.mEntityManager, (Class<? extends Entity>) Setting.class, str);
                EntityManager entityManager = this.mEntityManager;
                if (entityManager != null) {
                    entityManager.close();
                    return setting;
                }
                return setting;
            } catch (Exception e16) {
                e16.printStackTrace();
                EntityManager entityManager2 = this.mEntityManager;
                if (entityManager2 != null) {
                    entityManager2.close();
                }
                return null;
            }
        } catch (Throwable th5) {
            EntityManager entityManager3 = this.mEntityManager;
            if (entityManager3 != null) {
                entityManager3.close();
            }
            throw th5;
        }
    }

    @Override // com.tencent.mobileqq.avatar.api.IQQAvatarDataService
    public Drawable getRoundFaceDrawable(Bitmap bitmap) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 32)) {
            return (Drawable) iPatchRedirector.redirect((short) 32, (Object) this, (Object) bitmap);
        }
        return new BitmapDrawable(com.tencent.mobileqq.avatar.utils.c.l(bitmap));
    }

    @Override // com.tencent.mobileqq.avatar.api.IQQAvatarDataService
    public Setting getSettingFromDb(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 27)) {
            return (Setting) iPatchRedirector.redirect((short) 27, (Object) this, (Object) str);
        }
        if (this.mEntityManager == null) {
            this.mEntityManager = getEntityManager();
        }
        EntityManager entityManager = this.mEntityManager;
        if (entityManager == null) {
            return null;
        }
        return (Setting) DBMethodProxy.find(entityManager, (Class<? extends Entity>) Setting.class, str);
    }

    @Override // com.tencent.mobileqq.avatar.api.IQQAvatarDataService
    public String getZplanAvatarFilePath(String str, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            return (String) iPatchRedirector.redirect((short) 17, (Object) this, (Object) str, i3);
        }
        StringBuilder sb5 = new StringBuilder(256);
        sb5.append(getFaceFilePathPrefix(1));
        sb5.append("zs_out_");
        sb5.append(i3);
        sb5.append(util.base64_pad_url);
        if (str != null) {
            sb5.append(Md5Utils.b(Md5Utils.b(Md5Utils.b(str) + str) + str));
        }
        sb5.append(".jpg_");
        return sb5.toString();
    }

    void init(AppRuntime appRuntime) {
        this.mApp = appRuntime;
        this.mEntityManager = getEntityManager();
        initAvatarCompose();
        checkAndInitAvatarCache();
        checkAndCreateFaceSettingCache();
        initMaxSize();
        AppRuntime appRuntime2 = this.mApp;
        if (appRuntime2 != null) {
            this.isSupportDecodeHeadSize = ((IFeatureRuntimeService) appRuntime2.getRuntimeService(IFeatureRuntimeService.class, "all")).isFeatureSwitchEnable(FaceConstant.TOGGLE_QQ_AVATAR_SUPPORT_HEAD_SIZE, false);
        }
    }

    @Override // com.tencent.mobileqq.avatar.api.IQQAvatarDataService
    public void initFaceSettingCache() {
        int i3;
        int i16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 33)) {
            iPatchRedirector.redirect((short) 33, (Object) this);
            return;
        }
        long currentThreadTimeMillis = SystemClock.currentThreadTimeMillis();
        checkAndCreateFaceSettingCache();
        synchronized (this.mSettingDBInitLock) {
            int i17 = 0;
            this.mIsSettingDBInitFinish = false;
            this.mAvatarSettingCache.clear();
            if (this.mEntityManager == null) {
                this.mEntityManager = getEntityManager();
            }
            EntityManager entityManager = this.mEntityManager;
            if (entityManager == null) {
                return;
            }
            List<? extends Entity> query = entityManager.query(Setting.class, new Setting().getTableName(), false, (String) null, (String[]) null, (String) null, (String) null, "updateTimestamp desc", (String) null);
            if (query != null) {
                int size = query.size();
                if (size > 0) {
                    ArrayList arrayList = new ArrayList();
                    i3 = 0;
                    i16 = 0;
                    for (int i18 = 0; i18 < size; i18++) {
                        Setting setting = (Setting) query.get(i18);
                        if (setting != null && !TextUtils.isEmpty(setting.uin) && i3 < this.mMaxSize) {
                            if (!ProAvatarComponentUtils.l()) {
                                setting.url = null;
                            }
                            if ((setting.bSourceType == 1 || setting.bUsrType == 32) && i16 <= 100) {
                                arrayList.add(setting);
                                i16++;
                            } else {
                                this.mAvatarSettingCache.put(setting.uin, setting);
                                i3++;
                            }
                        }
                    }
                    int min = Math.min(100, Math.min(this.mMaxSize - i3, arrayList.size()));
                    if (min > 0) {
                        while (i17 < min) {
                            Setting setting2 = (Setting) arrayList.get(i17);
                            if (setting2 != null && !TextUtils.isEmpty(setting2.uin)) {
                                this.mAvatarSettingCache.put(setting2.uin, setting2);
                            }
                            i17++;
                        }
                    }
                } else {
                    i3 = 0;
                    i16 = 0;
                }
                i17 = size;
            } else {
                i3 = 0;
                i16 = 0;
            }
            this.mIsSettingDBInitFinish = true;
            QLog.d(TAG, 1, "initFaceSettingCache," + i17 + "," + i3 + "," + i16 + "\uff0c\u8017\u65f6\uff1a" + (SystemClock.currentThreadTimeMillis() - currentThreadTimeMillis) + ", Thread name = " + Thread.currentThread().getName() + "\uff0cstack = ", new RuntimeException("initFaceSettingCache"));
        }
    }

    @Override // com.tencent.mobileqq.avatar.api.IQQAvatarDataService
    public boolean isFaceFileExist(int i3, String str, int i16, int i17) {
        IPatchRedirector iPatchRedirector = $redirector_;
        return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 12)) ? isFaceFileExistInternal(i3, str, i16, i17, null) : ((Boolean) iPatchRedirector.redirect((short) 12, this, Integer.valueOf(i3), str, Integer.valueOf(i16), Integer.valueOf(i17))).booleanValue();
    }

    @Override // com.tencent.mobileqq.avatar.api.IQQAvatarDataService
    public boolean isSupportDecodeHeadSize() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 34)) {
            return ((Boolean) iPatchRedirector.redirect((short) 34, (Object) this)).booleanValue();
        }
        return this.isSupportDecodeHeadSize;
    }

    @Override // mqq.app.api.IRuntimeService
    public void onCreate(AppRuntime appRuntime) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) appRuntime);
        } else {
            init(appRuntime);
        }
    }

    @Override // mqq.app.api.IRuntimeService
    public void onDestroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
        }
    }

    @Override // com.tencent.mobileqq.avatar.api.IQQAvatarDataService
    public void putBitmapToCache(String str, Bitmap bitmap, byte b16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, this, str, bitmap, Byte.valueOf(b16));
        } else {
            checkAndInitAvatarCache();
            this.mAvatarCache.put(str, bitmap, b16);
        }
    }

    public Bitmap putSdcardBitmapToCache(int i3, String str, byte b16, String str2, Bitmap bitmap, String str3, j.a aVar, int i16, @Nullable FaceInfo faceInfo) {
        IPatchRedirector iPatchRedirector = $redirector_;
        int i17 = 0;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 31)) {
            return (Bitmap) iPatchRedirector.redirect((short) 31, this, Integer.valueOf(i3), str, Byte.valueOf(b16), str2, bitmap, str3, aVar, Integer.valueOf(i16), faceInfo);
        }
        if (bitmap != null) {
            if (faceInfo == null || !faceInfo.isRealLoadZplanStaticAvatar()) {
                if (com.tencent.mobileqq.avatar.utils.c.q() && i3 == 1 && faceInfo != null) {
                    i17 = faceInfo.sizeType;
                }
                bitmap = com.tencent.mobileqq.avatar.utils.c.b(b16, bitmap, str, i16, i17);
            }
            if (bitmap != null) {
                if (QLog.isDevelopLevel()) {
                    QLog.i(LogTag.QQ_HEAD, 2, "getFaceBitmap decode success, faceType=" + i3 + ", uin=" + str + ", shape=" + ((int) b16) + ", headType=" + i16 + ", path=" + str3 + ", cacheKey=" + str2 + ", bmp=" + bitmap);
                }
                putBitmapToCache(str2, bitmap, com.tencent.mobileqq.avatar.utils.b.d(i3));
            } else if (QLog.isDevelopLevel() && aVar.f306779b == 0) {
                QLog.i(LogTag.QQ_HEAD, 2, "getFaceBitmap decode shape fail, faceType=" + i3 + ", uin=" + str + ", shape=" + ((int) b16) + ", headType=" + i16);
            }
        }
        return bitmap;
    }

    @Override // com.tencent.mobileqq.avatar.api.IQQAvatarDataService
    public void removeBitmapFromCache(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) str);
        } else {
            checkAndInitAvatarCache();
            this.mAvatarCache.remove(str);
        }
    }

    @Override // com.tencent.mobileqq.avatar.api.IQQAvatarDataService
    public void removeFaceFileCache(FaceInfo faceInfo) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            iPatchRedirector.redirect((short) 16, (Object) this, (Object) faceInfo);
            return;
        }
        if (faceInfo == null) {
            QLog.e(TAG, 1, "removeFaceFileCache faceInfo is null");
            return;
        }
        String str = faceInfo.uin;
        if (str == null) {
            QLog.e(TAG, 1, "removeFaceFileCache uin is null");
            return;
        }
        if (faceInfo.isUserHeadType()) {
            FileUtils.deleteFile(getCustomFaceFilePath(1, str, 200));
            if (com.tencent.mobileqq.avatar.utils.c.q()) {
                for (int i3 : FaceConstant.HeadSize.SIZE_RANGE) {
                    FileUtils.deleteFile(getCustomFaceFilePath(1, str, 200, i3));
                }
            }
            for (int i16 : FaceConstant.HeadSize.SIZE_RANGE) {
                FileUtils.deleteFile(getZplanAvatarFilePath(str, i16));
            }
        }
    }

    @Override // com.tencent.mobileqq.avatar.api.IQQAvatarDataService
    public void removeFaceIconCache(int i3, String str, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, this, Integer.valueOf(i3), str, Integer.valueOf(i16));
            return;
        }
        String faceBitmapCacheKey = getFaceBitmapCacheKey(i3, str, (byte) 0, i16);
        for (int i17 = 0; i17 <= 8; i17++) {
            removeBitmapFromCache(faceBitmapCacheKey + "_" + i17);
        }
        if (com.tencent.mobileqq.avatar.utils.c.q()) {
            for (int i18 : FaceConstant.HeadSize.SIZE_RANGE) {
                if (i18 > 140) {
                    for (int i19 = 0; i19 <= 8; i19++) {
                        removeBitmapFromCache(faceBitmapCacheKey + "_" + i18 + "_" + i19);
                    }
                }
            }
        }
        if (i3 == 1) {
            for (int i26 = 0; i26 <= 8; i26++) {
                for (int i27 : FaceConstant.HeadSize.SIZE_RANGE) {
                    removeBitmapFromCache("zs_out_" + i27 + "_" + faceBitmapCacheKey + "_" + i26);
                }
            }
        }
    }

    @Override // com.tencent.mobileqq.avatar.api.IQQAvatarDataService
    public void removeFaceIconCacheApollo(int i3, String str, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            iPatchRedirector.redirect((short) 15, this, Integer.valueOf(i3), str, Integer.valueOf(i16));
            return;
        }
        for (int i17 : FaceConstant.Apollo.FACE_SPEC_ALL) {
            for (int i18 : FaceConstant.Apollo.FACE_SHAPE_ALL) {
                removeBitmapFromCache(getFaceBitmapCacheKey(i3, str, (byte) i18, 200, i17, false));
            }
        }
    }

    @Override // com.tencent.mobileqq.avatar.api.IQQAvatarDataService
    public void setHistoryAvatarPath(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 25)) {
            iPatchRedirector.redirect((short) 25, (Object) this, (Object) str);
        } else {
            historyAvatarpath = str;
        }
    }

    @Override // com.tencent.mobileqq.avatar.api.IQQAvatarDataService
    public void updateSettingTableCache(Setting setting) {
        Setting m175clone;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            iPatchRedirector.redirect((short) 18, (Object) this, (Object) setting);
            return;
        }
        if (setting != null && (m175clone = setting.m175clone()) != null) {
            if (!ProAvatarComponentUtils.l()) {
                m175clone.url = null;
            }
            if (!TextUtils.isEmpty(m175clone.uin)) {
                checkAndCreateFaceSettingCache();
                Setting setting2 = this.mAvatarSettingCache.get(m175clone.uin);
                if (setting2 != null && m175clone.headImgTimestamp < setting2.headImgTimestamp) {
                    return;
                }
                if (this.mIsSettingDBInitFinish) {
                    this.mAvatarSettingCache.put(m175clone.uin, m175clone);
                    return;
                }
                synchronized (this.mSettingDBInitLock) {
                    this.mAvatarSettingCache.put(m175clone.uin, m175clone);
                    QLog.i(LogTag.QQ_HEAD, 1, "\u6709\u7ebf\u7a0b\u5728\u7b49\u5f85 initFaceSettingCache \u5b8c\u6210\u3002\u7ebf\u7a0b\u540d\uff1a" + Thread.currentThread().getName() + "\uff0cstack = ", new RuntimeException("\u7b49\u5f85 initFaceSettingCache \u5b8c\u6210"));
                }
            }
        }
    }

    @Override // com.tencent.mobileqq.avatar.api.IQQAvatarDataService
    public String getFaceBitmapCacheKey(int i3, String str, byte b16, int i16, int i17, boolean z16) {
        Setting setting;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return (String) iPatchRedirector.redirect((short) 9, this, Integer.valueOf(i3), str, Byte.valueOf(b16), Integer.valueOf(i16), Integer.valueOf(i17), Boolean.valueOf(z16));
        }
        StringBuilder sb5 = new StringBuilder(16);
        if (i3 == 101 || i3 == 1001 || str == null) {
            setting = null;
        } else if (z16) {
            setting = getFaceSetting(com.tencent.mobileqq.avatar.utils.c.j(i3, str, i16));
        } else {
            setting = (Setting) getQQHeadSetting(i3, str, i16).second;
        }
        Object[] newFaceTypeBySetting = getNewFaceTypeBySetting(setting, str, i3);
        int intValue = ((Integer) newFaceTypeBySetting[0]).intValue();
        if (intValue == -56) {
            sb5.append("troop_sys_b_");
            str = (String) newFaceTypeBySetting[1];
        } else if (intValue == -55) {
            sb5.append("sys_");
            str = (String) newFaceTypeBySetting[1];
        } else if (intValue == 4) {
            sb5.append("troop_");
        } else if (intValue == 16) {
            sb5.append("qcall_");
            sb5.append(Integer.toString(i16));
            sb5.append("_");
        } else if (intValue == 32) {
            sb5.append("stranger_");
            sb5.append(Integer.toString(i16));
            sb5.append("_");
        } else if (intValue == 101) {
            sb5.append("dis_g_");
        } else if (intValue == 103) {
            sb5.append("sub_");
        } else if (intValue == 113) {
            sb5.append("new_troop_b_");
        } else if (intValue == 116) {
            sb5.append("apollo_");
            sb5.append(i17);
            sb5.append("_");
        } else if (intValue == 1001) {
            sb5.append("dis_pstn_g_");
        }
        sb5.append(str);
        if (com.tencent.mobileqq.avatar.utils.c.q() && intValue == 1 && i17 > 140) {
            sb5.append(util.base64_pad_url);
            sb5.append(i17);
        }
        if (b16 > 0) {
            sb5.append("_");
            sb5.append((int) b16);
        }
        return sb5.toString();
    }

    @Override // com.tencent.mobileqq.avatar.api.IQQAvatarDataService
    public boolean isFaceFileExist(FaceInfo faceInfo) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            return ((Boolean) iPatchRedirector.redirect((short) 13, (Object) this, (Object) faceInfo)).booleanValue();
        }
        if (faceInfo == null) {
            return false;
        }
        if (faceInfo.isRealLoadZplanStaticAvatar()) {
            return isFaceFileExistInternal(faceInfo.headType, faceInfo.uin, faceInfo.idType, faceInfo.sizeType, faceInfo);
        }
        return isFaceFileExistInternal(faceInfo.headType, faceInfo.uin, faceInfo.idType, faceInfo.sizeType, null);
    }

    @Override // com.tencent.mobileqq.avatar.api.IQQAvatarDataService
    public String getCustomFaceFilePath(int i3, String str, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 20)) ? getCustomFaceFilePath(null, i3, str, i16, 0) : (String) iPatchRedirector.redirect((short) 20, this, Integer.valueOf(i3), str, Integer.valueOf(i16));
    }

    @Override // com.tencent.mobileqq.avatar.api.IQQAvatarDataService
    public String getCustomFaceFilePath(int i3, String str, int i16, int i17) {
        IPatchRedirector iPatchRedirector = $redirector_;
        return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 21)) ? getCustomFaceFilePath(null, i3, str, i16, i17) : (String) iPatchRedirector.redirect((short) 21, this, Integer.valueOf(i3), str, Integer.valueOf(i16), Integer.valueOf(i17));
    }

    public static String getCustomFaceFilePathBySetting(Setting setting, int i3, int i16, FaceInfo faceInfo) {
        if (setting == null) {
            return "";
        }
        byte b16 = setting.bUsrType;
        String i17 = com.tencent.mobileqq.avatar.utils.b.i(setting.uin);
        return TextUtils.isEmpty(i17) ? "" : new QQAvatarDataServiceImpl().getCustomFaceFilePath(setting, b16, i17, i3, i16, faceInfo);
    }

    @Override // com.tencent.mobileqq.avatar.api.IQQAvatarDataService
    public String getCustomFaceFilePath(Setting setting, int i3, String str, int i16, int i17) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 22)) {
            return (String) iPatchRedirector.redirect((short) 22, this, setting, Integer.valueOf(i3), str, Integer.valueOf(i16), Integer.valueOf(i17));
        }
        if (AvatarOptimiseConfigUtil.a()) {
            String a16 = a.a(i3, str);
            if (TextUtils.isEmpty(a16)) {
                QLog.e(TAG, 1, "getCustomFaceFilePath [" + i3 + "_" + StringUtil.getSimpleUinForPrint(str) + "] avatarPath is null or empty");
            } else {
                File file = new File(a16);
                if (!file.exists() || file.length() <= 0) {
                    QLog.e(TAG, 1, "getCustomFaceFilePath [" + i3 + "_" + StringUtil.getSimpleUinForPrint(str) + "] file exists? " + file.exists() + ", length = " + file.length());
                }
            }
            if (QLog.isDevelopLevel()) {
                QLog.d(TAG, 4, "getCustomFaceFilePath " + i3 + "_" + StringUtil.getSimpleUinForPrint(str) + " path = " + a16);
            }
            return a16 != null ? a16 : "";
        }
        if (setting == null && str != null && i3 != 101 && i3 != 1001 && i3 != 116) {
            setting = (Setting) getQQHeadSetting(i3, str, i16).second;
        }
        StringBuilder sb5 = new StringBuilder(256);
        sb5.append(getFaceFilePathPrefix(i3));
        Object[] newFaceTypeBySetting = getNewFaceTypeBySetting(setting, str, i3);
        int intValue = ((Integer) newFaceTypeBySetting[0]).intValue();
        if (intValue == -56) {
            sb5.append("troop_sys_b_");
            str = (String) newFaceTypeBySetting[1];
        } else if (intValue == -55) {
            sb5.append("sys_");
            str = (String) newFaceTypeBySetting[1];
        } else if (intValue == 4) {
            sb5.append("troop_");
        } else if (intValue == 16) {
            sb5.append("qcall_");
            sb5.append(Integer.toString(i16));
            sb5.append("_");
        } else if (intValue == 32) {
            sb5.append("stranger_");
            sb5.append(Integer.toString(i16));
            sb5.append("_");
        } else if (intValue == 101) {
            sb5.append("dis_g_");
            str = this.mApp.getAccount() + str;
        } else if (intValue == 113) {
            sb5.append("new_troop_b_");
        } else if (intValue == 116) {
            sb5.append("apollo_");
            sb5.append(i17);
            sb5.append("_");
        } else if (intValue == 1001) {
            sb5.append("dis_pstn_g_");
            str = this.mApp.getAccount() + str;
        }
        if (str != null) {
            sb5.append(Md5Utils.b(Md5Utils.b(Md5Utils.b(str) + str) + str));
        }
        if (com.tencent.mobileqq.avatar.utils.c.q() && intValue == 1 && i17 > 140) {
            sb5.append(util.base64_pad_url);
            sb5.append(i17);
        }
        sb5.append(".jpg_");
        return sb5.toString();
    }

    @Override // com.tencent.mobileqq.avatar.api.IQQAvatarDataService
    public String getFaceBitmapCacheKey(int i3, String str, byte b16, int i16, int i17, boolean z16, @Nullable FaceInfo faceInfo) {
        Setting setting;
        IPatchRedirector iPatchRedirector = $redirector_;
        boolean z17 = true;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return (String) iPatchRedirector.redirect((short) 10, this, Integer.valueOf(i3), str, Byte.valueOf(b16), Integer.valueOf(i16), Integer.valueOf(i17), Boolean.valueOf(z16), faceInfo);
        }
        if (((IQQZplanOutsideAvatarApi) QRoute.api(IQQZplanOutsideAvatarApi.class)).isOutboundHeadFeatureOn() && faceInfo != null && faceInfo.isUserHeadType()) {
            if (!faceInfo.hasUpdateFromSetting()) {
                if (z16) {
                    setting = getFaceSetting(com.tencent.mobileqq.avatar.utils.c.j(i3, str, i16));
                } else {
                    setting = (Setting) getQQHeadSetting(i3, str, i16).second;
                }
                if (setting != null) {
                    faceInfo.updateZplanAvatarInfoFromSetting(setting);
                }
            }
            if (!faceInfo.isRealLoadZplanStaticAvatar() && (!faceInfo.isEnableZplanOutbound() || faceInfo.hasUpdateFromSetting())) {
                z17 = false;
            }
            if (z17) {
                StringBuilder sb5 = new StringBuilder(16);
                sb5.append("zs_out_");
                sb5.append(i17);
                sb5.append("_");
                sb5.append(str);
                if (b16 > 0) {
                    sb5.append("_");
                    sb5.append((int) b16);
                }
                return sb5.toString();
            }
        }
        return getFaceBitmapCacheKey(i3, str, b16, i16, i17, z16);
    }

    @Override // com.tencent.mobileqq.avatar.api.IQQAvatarDataService
    public String getCustomFaceFilePath(Setting setting, int i3, String str, int i16, int i17, @Nullable FaceInfo faceInfo) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 23)) {
            return (String) iPatchRedirector.redirect((short) 23, this, setting, Integer.valueOf(i3), str, Integer.valueOf(i16), Integer.valueOf(i17), faceInfo);
        }
        if (faceInfo != null && faceInfo.isUserHeadType() && faceInfo.isRealLoadZplanStaticAvatar()) {
            return getZplanAvatarFilePath(str, i17);
        }
        return getCustomFaceFilePath(setting, i3, str, i16, i17);
    }
}

package com.tencent.mobileqq.startup.step;

import android.content.Context;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.os.AsyncTask;
import android.os.SystemClock;
import android.util.TypedValue;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.app.g;
import com.tencent.common.config.AppSetting;
import com.tencent.image.Utils;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.skin.transform.ResGuardIgnoreCollection;
import com.tencent.mobileqq.theme.ThemeConstants;
import com.tencent.mobileqq.utils.QQTheme;
import com.tencent.mobileqq.utils.em;
import com.tencent.mobileqq.vas.theme.BusinessTintManager;
import com.tencent.mobileqq.vas.theme.QUIResourcesTransform;
import com.tencent.mobileqq.vas.theme.QUITintManager;
import com.tencent.mobileqq.vas.theme.SimpleTintManager;
import com.tencent.mobileqq.vas.theme.ThemeMMKVPreference;
import com.tencent.mobileqq.vas.theme.ThemeService;
import com.tencent.mobileqq.widget.o;
import com.tencent.qphone.base.util.QLog;
import com.tencent.shadow.core.runtime.skin.loader.SkinResFactory;
import com.tencent.theme.ISkinTint;
import com.tencent.theme.SkinEngine;
import com.tencent.theme.UnSupportPlatformException;
import com.tencent.theme.s;
import com.tencent.util.QUITokenResUtil;
import cooperation.qqcircle.report.datong.QCircleDaTongConstant;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.lang.reflect.Field;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import mqq.app.MobileQQ;
import mqq.app.api.ProcessConstant;

/* compiled from: P */
/* loaded from: classes18.dex */
public class InitSkin {
    static IPatchRedirector $redirector_ = null;
    public static final int COLOR_COUNT = 1264;
    public static final int DRAWABLE_COUNT = 8191;
    public static final int FIRST_COLOR_ID;
    public static final int FIRST_DRAWABLE_ID;
    public static final int LAST_COLOR_ID;
    public static final int LAST_DRAWABLE_ID;
    private static final String TAG = "InitSkin";
    private static int[] colorIds;
    private static int[] drawableIds;
    public static boolean sInited;
    public static boolean sToolAsynInitDPC;
    public static final Object sToolInitLock;
    public static int sToolInitTimeout;
    public static volatile boolean sToolProcessInitComplete;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes18.dex */
    public static class CreateSkinEngineCacheTask extends AsyncTask<Void, Void, Void> implements Runnable {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        private String f289734d;

        /* renamed from: e, reason: collision with root package name */
        private String f289735e;

        public CreateSkinEngineCacheTask(String str, String str2) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) str, (Object) str2);
            } else {
                this.f289734d = str;
                this.f289735e = str2;
            }
        }

        /* JADX WARN: Code restructure failed: missing block: B:62:0x0119, code lost:
        
            if (com.tencent.qphone.base.util.QLog.isColorLevel() == false) goto L72;
         */
        /* JADX WARN: Code restructure failed: missing block: B:63:0x011b, code lost:
        
            com.tencent.qphone.base.util.QLog.e(com.tencent.mobileqq.startup.step.InitSkin.TAG, 2, "", r2);
         */
        /* JADX WARN: Code restructure failed: missing block: B:78:0x0141, code lost:
        
            if (com.tencent.qphone.base.util.QLog.isColorLevel() == false) goto L72;
         */
        /* JADX WARN: Removed duplicated region for block: B:83:0x0149 A[EXC_TOP_SPLITTER, SYNTHETIC] */
        @Override // android.os.AsyncTask
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public Void doInBackground(Void... voidArr) {
            ObjectOutputStream objectOutputStream;
            String[] list;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (Void) iPatchRedirector.redirect((short) 2, (Object) this, (Object) voidArr);
            }
            ObjectOutputStream objectOutputStream2 = null;
            try {
                BaseApplicationImpl baseApplicationImpl = BaseApplicationImpl.sApplication;
                if (QLog.isColorLevel()) {
                    QLog.d(SkinEngine.TAG, 2, "CreateSkinEngineCacheTask start");
                }
                if (this.f289735e.startsWith("/skin/skin_cache_mobileqq_")) {
                    File file = new File(baseApplicationImpl.getCacheDir(), SkinResFactory.SKIN_THEME_APK_SAVE_DIR);
                    if (file.isDirectory() && (list = file.list()) != null) {
                        for (String str : list) {
                            if (QLog.isColorLevel()) {
                                QLog.d(SkinEngine.TAG, 2, "delete old cache file:" + str);
                            }
                            if (str != null && str.startsWith("skin_cache_mobileqq_")) {
                                File file2 = new File(file, str);
                                if (file2.exists()) {
                                    file2.delete();
                                }
                            }
                        }
                    }
                }
                File file3 = new File(baseApplicationImpl.getCacheDir(), this.f289734d);
                File file4 = new File(baseApplicationImpl.getCacheDir(), this.f289735e);
                File file5 = new File(baseApplicationImpl.getCacheDir(), this.f289735e + ".tmp");
                File parentFile = file3.getParentFile();
                if (!parentFile.exists()) {
                    parentFile.mkdirs();
                }
                if (file4.exists()) {
                    file4.delete();
                }
                if (file3.exists()) {
                    file3.delete();
                }
                if (file5.exists()) {
                    file5.delete();
                }
                SkinEngine.getInstances().writeCacheFile(file5);
                if (file5.exists()) {
                    file5.renameTo(file4);
                }
                ObjectOutputStream objectOutputStream3 = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream(file3)));
                try {
                    objectOutputStream3.writeInt(AppSetting.f());
                    objectOutputStream3.writeUTF(AppSetting.f99543c);
                    try {
                        objectOutputStream3.close();
                    } catch (IOException e16) {
                        e = e16;
                    }
                } catch (Exception e17) {
                    objectOutputStream = objectOutputStream3;
                    e = e17;
                    try {
                        if (QLog.isColorLevel()) {
                            QLog.e(InitSkin.TAG, 2, "", e);
                        }
                        if (objectOutputStream != null) {
                            try {
                                objectOutputStream.close();
                            } catch (IOException e18) {
                                e = e18;
                            }
                        }
                        return null;
                    } catch (Throwable th5) {
                        th = th5;
                        objectOutputStream2 = objectOutputStream;
                        if (objectOutputStream2 != null) {
                            try {
                                objectOutputStream2.close();
                            } catch (IOException e19) {
                                if (QLog.isColorLevel()) {
                                    QLog.e(InitSkin.TAG, 2, "", e19);
                                }
                            }
                        }
                        throw th;
                    }
                } catch (Throwable th6) {
                    th = th6;
                    objectOutputStream2 = objectOutputStream3;
                    if (objectOutputStream2 != null) {
                    }
                    throw th;
                }
            } catch (Exception e26) {
                e = e26;
                objectOutputStream = null;
            } catch (Throwable th7) {
                th = th7;
            }
            return null;
        }

        @Override // java.lang.Runnable
        public void run() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this);
            } else {
                Utils.executeAsyncTaskOnThreadPool(this, new Void[0]);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes18.dex */
    public class a implements s {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ boolean f289736a;

        a(boolean z16) {
            this.f289736a = z16;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, z16);
            }
        }

        @Override // com.tencent.theme.s
        public void a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this);
            } else {
                QQTheme.setCurThemeId(null);
                o.k();
            }
        }

        @Override // com.tencent.theme.s
        public void b() {
            ISkinTint instance;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this);
                return;
            }
            QQTheme.setCurThemeId(null);
            QUIResourcesTransform.getInstance().onPreThemeUpdate();
            if (this.f289736a) {
                return;
            }
            if (QUITokenResUtil.isNowQUIDebugTheme()) {
                QUITintManager.instance().setThemeId(QUITokenResUtil.getCurrentDebugThemeId());
                SkinEngine.getInstances().setSkinTint(QUITintManager.instance());
                return;
            }
            String currentThemeId = QQTheme.getCurrentThemeId();
            boolean isThemeSimpleUI = QQTheme.isThemeSimpleUI(currentThemeId);
            SkinEngine instances = SkinEngine.getInstances();
            if (isThemeSimpleUI) {
                instance = SimpleTintManager.instance();
            } else {
                instance = BusinessTintManager.instance();
            }
            instances.setSkinTint(instance);
            SimpleTintManager.instance().setThemeId(currentThemeId);
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(75378);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
            return;
        }
        sInited = false;
        sToolAsynInitDPC = false;
        sToolInitLock = new Object();
        sToolInitTimeout = 3000;
        sToolProcessInitComplete = false;
        FIRST_DRAWABLE_ID = R.drawable.izi;
        LAST_DRAWABLE_ID = R.drawable.off;
        FIRST_COLOR_ID = R.color.agi;
        LAST_COLOR_ID = R.color.d19;
    }

    public InitSkin() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private static void asynInitSkin() {
        ThreadManagerV2.post(new Runnable() { // from class: com.tencent.mobileqq.startup.step.InitSkin.2
            static IPatchRedirector $redirector_;

            {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this);
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
                    QLog.i(InitSkin.TAG, 2, "start asynInitSkin");
                }
                InitSkin.initSkin(BaseApplicationImpl.sApplication);
                InitSkin.sToolProcessInitComplete = true;
                Object obj = InitSkin.sToolInitLock;
                synchronized (obj) {
                    obj.notifyAll();
                }
                if (QLog.isColorLevel()) {
                    QLog.i(InitSkin.TAG, 2, "end asynInitSkin");
                }
            }
        }, 8, null, false);
    }

    private static int[] convertCollection2Array(Collection<Integer> collection) {
        int[] iArr = new int[collection.size()];
        Iterator<Integer> it = collection.iterator();
        int i3 = 0;
        while (it.hasNext()) {
            iArr[i3] = it.next().intValue();
            i3++;
        }
        return iArr;
    }

    private static boolean enableToolSync() {
        boolean z16 = em.b().a().getBoolean(ThemeConstants.KEY_ENABLE_TOOL_SYNC, true);
        QLog.d(SkinEngine.TAG, 1, "enableToolSync =" + z16);
        return z16;
    }

    private static int getDefaultCookieId(Context context) {
        int i3;
        Resources resources = context.getResources();
        TypedValue typedValue = new TypedValue();
        resources.getValue(R.drawable.b8u, typedValue, true);
        if (typedValue.string != null) {
            i3 = typedValue.assetCookie;
        } else {
            i3 = 0;
        }
        if (QLog.isColorLevel()) {
            QLog.i(TAG, 2, "getDefaultCookieId value.string=" + ((Object) typedValue.string) + ", cookieId=" + i3);
        }
        return i3;
    }

    public static void initMMKV() {
        SkinEngine.getInstances().setPreference(new ThemeMMKVPreference());
    }

    private static void initResGuardIgnoreCollection() {
        try {
            HashSet hashSet = ResGuardIgnoreCollection.sDrawableResCollection;
            Field field = ResGuardIgnoreCollection.class.getField("sDrawableResCollection");
            Field field2 = ResGuardIgnoreCollection.class.getField("sColorResCollection");
            HashSet hashSet2 = (HashSet) field.get(ResGuardIgnoreCollection.class);
            HashSet hashSet3 = (HashSet) field2.get(ResGuardIgnoreCollection.class);
            drawableIds = convertCollection2Array(hashSet2);
            colorIds = convertCollection2Array(hashSet3);
            QLog.d(TAG, 1, "drawable size : ", Integer.valueOf(hashSet2.size()), " color size : ", Integer.valueOf(hashSet3.size()));
        } catch (Exception e16) {
            QLog.d(TAG, 1, "get ResGuardIgnoreCollection failed, ", e16);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:27:0x01eb A[Catch: Exception -> 0x0201, TRY_LEAVE, TryCatch #6 {Exception -> 0x0201, blocks: (B:25:0x014e, B:27:0x01eb, B:49:0x012d, B:51:0x0133, B:52:0x0136, B:54:0x013c, B:55:0x013f, B:57:0x0145, B:58:0x014b), top: B:48:0x012d }] */
    /* JADX WARN: Removed duplicated region for block: B:51:0x0133 A[Catch: Exception -> 0x0201, TryCatch #6 {Exception -> 0x0201, blocks: (B:25:0x014e, B:27:0x01eb, B:49:0x012d, B:51:0x0133, B:52:0x0136, B:54:0x013c, B:55:0x013f, B:57:0x0145, B:58:0x014b), top: B:48:0x012d }] */
    /* JADX WARN: Removed duplicated region for block: B:54:0x013c A[Catch: Exception -> 0x0201, TryCatch #6 {Exception -> 0x0201, blocks: (B:25:0x014e, B:27:0x01eb, B:49:0x012d, B:51:0x0133, B:52:0x0136, B:54:0x013c, B:55:0x013f, B:57:0x0145, B:58:0x014b), top: B:48:0x012d }] */
    /* JADX WARN: Removed duplicated region for block: B:57:0x0145 A[Catch: Exception -> 0x0201, TryCatch #6 {Exception -> 0x0201, blocks: (B:25:0x014e, B:27:0x01eb, B:49:0x012d, B:51:0x0133, B:52:0x0136, B:54:0x013c, B:55:0x013f, B:57:0x0145, B:58:0x014b), top: B:48:0x012d }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static boolean initSkin(Context context) {
        boolean z16;
        String str;
        File file;
        File file2;
        int i3;
        g gVar;
        int i16;
        int i17 = 0;
        try {
            File cacheDir = context.getCacheDir();
            long uptimeMillis = SystemClock.uptimeMillis();
            SkinEngine.SWITCH_DEBUG = false;
            SkinEngine.DEBUG = false;
            g gVar2 = new g(BaseApplicationImpl.getApplication());
            SkinEngine.setSKLog(gVar2);
            try {
                BaseApplicationImpl baseApplicationImpl = BaseApplicationImpl.sApplication;
                if (baseApplicationImpl.getPackageManager().getApplicationInfo(baseApplicationImpl.getPackageName(), 128).metaData.getBoolean("com.sec.android.support.multiwindow")) {
                    SkinEngine.mIconResourceID = Integer.valueOf(R.drawable.icon);
                    if (QLog.isColorLevel()) {
                        QLog.d(SkinEngine.TAG, 2, "Set icon resouceID to " + R.drawable.icon);
                    }
                }
            } catch (PackageManager.NameNotFoundException e16) {
                e16.printStackTrace();
            }
            int defaultCookieId = getDefaultCookieId(context);
            StringBuilder sb5 = new StringBuilder();
            sb5.append("/skin/skin_cache_mobileqq_");
            sb5.append(AppSetting.f());
            sb5.append("_");
            sb5.append(AppSetting.f99543c);
            sb5.append("_");
            sb5.append(defaultCookieId);
            sb5.append("_");
            if (!useNewInit()) {
                str = "";
            } else {
                str = QCircleDaTongConstant.ElementParamValue.NEW;
            }
            sb5.append(str);
            String sb6 = sb5.toString();
            File file3 = new File(cacheDir, "/skin/config");
            File file4 = new File(cacheDir, sb6);
            try {
                try {
                    if (file4.exists()) {
                        try {
                            QLog.d(SkinEngine.TAG, 1, "cache find, use cache file accered:" + sb6);
                            int i18 = LAST_DRAWABLE_ID;
                            int i19 = LAST_COLOR_ID;
                            file = file4;
                            file2 = file3;
                            i16 = R.color.agi;
                            i17 = R.drawable.izi;
                            gVar = gVar2;
                            SkinEngine.init(context, DRAWABLE_COUNT, R.drawable.izi, i18, COLOR_COUNT, R.color.agi, i19, file);
                            QQTheme.sInitType = 4;
                        } catch (Exception e17) {
                            e = e17;
                            file = file4;
                            file2 = file3;
                            i17 = R.drawable.izi;
                            gVar = gVar2;
                            i3 = R.color.agi;
                            try {
                                if (file2.exists()) {
                                }
                                if (file.exists()) {
                                }
                                if (QLog.isColorLevel()) {
                                }
                                initSkinEngine(context, i17, i3);
                                SkinEngine.getInstances().setSkinEngineHandler(gVar);
                                SkinEngine.getInstances().addDrawableResource(R.drawable.bg_texture);
                                SkinEngine.getInstances().addDrawableResource(R.drawable.chat_bg_texture);
                                SkinEngine.getInstances().addDrawableResource(R.drawable.bg_texture_theme_version2);
                                SkinEngine.getInstances().addDrawableResource(R.drawable.skin_qq_setting_bg_texture);
                                SkinEngine.getInstances().addDrawableResource(R.drawable.common_list_overscoll_top_bg);
                                SkinEngine.getInstances().addDrawableResource(R.drawable.chat_input_bar_bg_big);
                                long uptimeMillis2 = SystemClock.uptimeMillis() - uptimeMillis;
                                SkinEngine.getInstances().addBackupForOOMData(Integer.valueOf(R.drawable.skin_chat_background), new SkinEngine.BackupForOOMData(R.drawable.skin_chat_background, R.drawable.gub, Bitmap.Config.RGB_565));
                                SkinEngine.getInstances().addBackupForOOMData(Integer.valueOf(R.drawable.qq_setting_me_bg), new SkinEngine.BackupForOOMData(R.drawable.qq_setting_me_bg, R.drawable.gub, Bitmap.Config.RGB_565));
                                SkinEngine.getInstances().addBackupForOOMData(Integer.valueOf(R.drawable.skin_background_theme_version2), new SkinEngine.BackupForOOMData(R.drawable.skin_background_theme_version2, R.drawable.gub, Bitmap.Config.RGB_565));
                                SkinEngine.getInstances().setResourcesTransform(QUIResourcesTransform.getInstance());
                                if (QLog.isColorLevel()) {
                                }
                            } catch (Exception e18) {
                                e = e18;
                                z16 = false;
                                BaseApplicationImpl.IS_SUPPORT_THEME = z16;
                                QLog.e(SkinEngine.TAG, 1, "Init SkinEngine Error:", e);
                                File file5 = new File(context.getCacheDir(), "/skin/unsupport");
                                if (!file5.exists()) {
                                    if (!file5.getParentFile().exists()) {
                                        file5.getParentFile().mkdirs();
                                    }
                                    try {
                                        file5.createNewFile();
                                    } catch (IOException e19) {
                                        if (QLog.isColorLevel()) {
                                            QLog.e(TAG, 2, "", e19);
                                        }
                                    }
                                }
                                return true;
                            }
                            return true;
                        }
                    } else {
                        file = file4;
                        file2 = file3;
                        i16 = R.color.agi;
                        i17 = R.drawable.izi;
                        gVar = gVar2;
                        QLog.d(SkinEngine.TAG, 1, "No cache found");
                        i3 = i16;
                        try {
                            initSkinEngine(context, i17, i3);
                            ThreadManager.getSubThreadHandler().postDelayed(new CreateSkinEngineCacheTask("/skin/config", sb6), 10000L);
                        } catch (Exception e26) {
                            e = e26;
                            if (file2.exists()) {
                                file2.delete();
                            }
                            if (file.exists()) {
                                file.delete();
                            }
                            if (QLog.isColorLevel()) {
                                QLog.d(SkinEngine.TAG, 2, "Cache load failed.", e);
                            }
                            initSkinEngine(context, i17, i3);
                            SkinEngine.getInstances().setSkinEngineHandler(gVar);
                            SkinEngine.getInstances().addDrawableResource(R.drawable.bg_texture);
                            SkinEngine.getInstances().addDrawableResource(R.drawable.chat_bg_texture);
                            SkinEngine.getInstances().addDrawableResource(R.drawable.bg_texture_theme_version2);
                            SkinEngine.getInstances().addDrawableResource(R.drawable.skin_qq_setting_bg_texture);
                            SkinEngine.getInstances().addDrawableResource(R.drawable.common_list_overscoll_top_bg);
                            SkinEngine.getInstances().addDrawableResource(R.drawable.chat_input_bar_bg_big);
                            long uptimeMillis22 = SystemClock.uptimeMillis() - uptimeMillis;
                            SkinEngine.getInstances().addBackupForOOMData(Integer.valueOf(R.drawable.skin_chat_background), new SkinEngine.BackupForOOMData(R.drawable.skin_chat_background, R.drawable.gub, Bitmap.Config.RGB_565));
                            SkinEngine.getInstances().addBackupForOOMData(Integer.valueOf(R.drawable.qq_setting_me_bg), new SkinEngine.BackupForOOMData(R.drawable.qq_setting_me_bg, R.drawable.gub, Bitmap.Config.RGB_565));
                            SkinEngine.getInstances().addBackupForOOMData(Integer.valueOf(R.drawable.skin_background_theme_version2), new SkinEngine.BackupForOOMData(R.drawable.skin_background_theme_version2, R.drawable.gub, Bitmap.Config.RGB_565));
                            SkinEngine.getInstances().setResourcesTransform(QUIResourcesTransform.getInstance());
                            if (QLog.isColorLevel()) {
                            }
                            return true;
                        }
                    }
                } catch (Exception e27) {
                    e = e27;
                    i3 = i16;
                }
            } catch (Exception e28) {
                e = e28;
                file = file4;
                file2 = file3;
                i3 = R.color.agi;
                i17 = R.drawable.izi;
                gVar = gVar2;
            }
            SkinEngine.getInstances().setSkinEngineHandler(gVar);
            SkinEngine.getInstances().addDrawableResource(R.drawable.bg_texture);
            SkinEngine.getInstances().addDrawableResource(R.drawable.chat_bg_texture);
            SkinEngine.getInstances().addDrawableResource(R.drawable.bg_texture_theme_version2);
            SkinEngine.getInstances().addDrawableResource(R.drawable.skin_qq_setting_bg_texture);
            SkinEngine.getInstances().addDrawableResource(R.drawable.common_list_overscoll_top_bg);
            SkinEngine.getInstances().addDrawableResource(R.drawable.chat_input_bar_bg_big);
            long uptimeMillis222 = SystemClock.uptimeMillis() - uptimeMillis;
            SkinEngine.getInstances().addBackupForOOMData(Integer.valueOf(R.drawable.skin_chat_background), new SkinEngine.BackupForOOMData(R.drawable.skin_chat_background, R.drawable.gub, Bitmap.Config.RGB_565));
            SkinEngine.getInstances().addBackupForOOMData(Integer.valueOf(R.drawable.qq_setting_me_bg), new SkinEngine.BackupForOOMData(R.drawable.qq_setting_me_bg, R.drawable.gub, Bitmap.Config.RGB_565));
            SkinEngine.getInstances().addBackupForOOMData(Integer.valueOf(R.drawable.skin_background_theme_version2), new SkinEngine.BackupForOOMData(R.drawable.skin_background_theme_version2, R.drawable.gub, Bitmap.Config.RGB_565));
            SkinEngine.getInstances().setResourcesTransform(QUIResourcesTransform.getInstance());
            if (QLog.isColorLevel()) {
                QLog.d(SkinEngine.TAG, 2, "init skin engine cost: " + uptimeMillis222);
            }
        } catch (Exception e29) {
            e = e29;
            z16 = false;
        }
        return true;
    }

    private static void initSkinEngine(Context context, int i3, int i16) throws UnSupportPlatformException {
        int[] iArr;
        initResGuardIgnoreCollection();
        int[] iArr2 = drawableIds;
        if (iArr2 != null && iArr2.length != 0 && (iArr = colorIds) != null && iArr.length != 0 && useNewInit()) {
            SkinEngine.init(context, drawableIds, colorIds);
            QQTheme.sInitType = 5;
        } else {
            SkinEngine.init(context, DRAWABLE_COUNT, i3, LAST_DRAWABLE_ID, COLOR_COUNT, i16, LAST_COLOR_ID, null);
            QQTheme.sInitType = 3;
        }
    }

    public static void initSkinTinter() {
        SkinEngine instances = SkinEngine.getInstances();
        instances.setQuiPicRenderColorRes(R.color.qui_common_icon_primary);
        instances.setSkinLifecycle(com.tencent.mobileqq.skin.b.b());
        instances.setThemeService(new ThemeService());
        if (QUITokenResUtil.isNowQUIDebugTheme()) {
            QUITintManager.instance().setThemeId(QUITokenResUtil.getCurrentDebugThemeId());
            instances.setSkinTint(QUITintManager.instance());
        } else if (QQTheme.isNowSimpleUI()) {
            instances.setSkinTint(SimpleTintManager.instance());
        } else {
            instances.setSkinTint(BusinessTintManager.instance());
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:49:0x0104  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static synchronized void startInitSkinEngine() {
        String str;
        boolean z16;
        synchronized (InitSkin.class) {
            if (sInited) {
                return;
            }
            String[] split = MobileQQ.processName.split(":");
            if (split.length > 1) {
                str = split[1];
            } else {
                str = null;
            }
            boolean z17 = false;
            if (str != null && !str.endsWith("map") && !str.equals("qzone") && !str.equals("picture") && !str.equals("pedit") && !str.equals(ProcessConstant.OPEN_SDK) && !str.equals("plugin") && !str.equals(ProcessConstant.DEMOJI) && !str.equals("peak") && !str.equals(ProcessConstant.AVGAME) && !str.equals(ProcessConstant.READINJOY) && !str.endsWith(ProcessConstant.NEARBY) && !str.equals("tool") && !str.equals(ProcessConstant.QQFAV) && !str.equals("dataline") && !str.contains("mini") && !str.contains(ProcessConstant.WXA_CONTAINER)) {
                z16 = false;
                if (z16) {
                    if (str == null) {
                        z17 = true;
                    }
                    SkinEngine.getInstances().setUpdateCallback(new a(z17));
                }
                sInited = true;
            }
            if (QLog.isColorLevel()) {
                QLog.d(TAG, 2, "start init skin engine");
            }
            initSkinTinter();
            initMMKV();
            if ("tool".equals(str)) {
                if (enableToolSync()) {
                    sToolAsynInitDPC = true;
                    initSkin(BaseApplicationImpl.sApplication);
                    sToolProcessInitComplete = true;
                    Object obj = sToolInitLock;
                    synchronized (obj) {
                        obj.notifyAll();
                    }
                } else {
                    asynInitSkin();
                }
            } else {
                initSkin(BaseApplicationImpl.sApplication);
            }
            if (QLog.isColorLevel()) {
                QLog.d(TAG, 2, "finish init skin engine");
            }
            z16 = true;
            if (z16) {
            }
            sInited = true;
        }
    }

    private static boolean useNewInit() {
        return true;
    }

    public static void waitAsynInitSkin() {
        if (sToolAsynInitDPC && !sToolProcessInitComplete) {
            if (QLog.isColorLevel()) {
                QLog.i(TAG, 2, "start waitAsynInitSkin");
            }
            Object obj = sToolInitLock;
            synchronized (obj) {
                if (!sToolProcessInitComplete) {
                    try {
                        obj.wait(sToolInitTimeout);
                    } catch (InterruptedException e16) {
                        if (QLog.isColorLevel()) {
                            QLog.i(TAG, 2, e16.toString());
                        }
                    }
                }
            }
            if (QLog.isColorLevel()) {
                QLog.i(TAG, 2, "end waitAsynInitSkin InitSkin.sToolProcessInitComplete = " + sToolProcessInitComplete);
            }
        }
    }
}

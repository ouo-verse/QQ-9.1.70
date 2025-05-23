package com.tencent.mobileqq.app.multilanguage;

import android.app.Activity;
import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.res.AssetManager;
import android.content.res.Resources;
import android.view.LayoutInflater;
import com.tencent.biz.common.util.ZipUtils;
import com.tencent.mobileqq.app.LocaleManager;
import com.tencent.mobileqq.profilecard.api.ProfileContants;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.annotation.ConfigInject;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import tv.danmaku.ijk.media.player.IjkMediaMeta;

/* compiled from: P */
/* loaded from: classes11.dex */
public class MultiLanguageEngine {
    static IPatchRedirector $redirector_ = null;
    private static String EN_ASSET_PKG_FILE = null;
    private static String EN_PKG_FILE = null;
    public static final String TAG = "MultiLanguageEngine";

    @ConfigInject(configPath = "Foundation/QQCommon/src/main/resources/Inject_MultiLanguageFactory.yml", version = 1)
    public static ArrayList<Class<? extends LayoutInflater.Factory2>> sInjectFactoryList;
    private DelegateResources mDelegateResources;
    private QQResourcesImpl mResourcesImpl;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes11.dex */
    public static class EngineHolder {
        static IPatchRedirector $redirector_;
        private static MultiLanguageEngine INSTANCE;

        static {
            IPatchRedirector redirector = PatchRedirectCenter.getRedirector(ProfileContants.FIELD_TENCENT_DOC_FLAG);
            $redirector_ = redirector;
            if (redirector != null && redirector.hasPatch((short) 2)) {
                redirector.redirect((short) 2);
            } else {
                INSTANCE = new MultiLanguageEngine();
            }
        }

        EngineHolder() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(42168);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 7)) {
            redirector.redirect((short) 7);
            return;
        }
        EN_PKG_FILE = "en.lang";
        EN_ASSET_PKG_FILE = "en-release.zip";
        ArrayList<Class<? extends LayoutInflater.Factory2>> arrayList = new ArrayList<>();
        sInjectFactoryList = arrayList;
        arrayList.add(MultiLanguageFactory.class);
    }

    public MultiLanguageEngine() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private void checkLanguagePkg(Context context, String str) {
        if (!new File(str).exists()) {
            QLog.d(TAG, 1, "loadLanguage need unzip:", EN_ASSET_PKG_FILE);
            Long valueOf = Long.valueOf(System.currentTimeMillis());
            String str2 = IjkMediaMeta.IJKM_KEY_LANGUAGE + File.separator + EN_ASSET_PKG_FILE;
            String str3 = getLanguageSavePath() + EN_ASSET_PKG_FILE;
            FileUtils.copyAssetToFile(context, str2, str3);
            try {
                ZipUtils.unZipFile(new File(str3), getLanguageSavePath());
                if (QLog.isColorLevel()) {
                    QLog.e(TAG, 2, "copy and unzip success! cost:", Long.valueOf(System.currentTimeMillis() - valueOf.longValue()));
                }
            } catch (IOException e16) {
                e16.printStackTrace();
            }
        }
    }

    public static MultiLanguageEngine getInstance() {
        return EngineHolder.INSTANCE;
    }

    private static String getLanguageSavePath() {
        File file = new File(BaseApplication.getContext().getFilesDir(), "/multi_language");
        if (!file.exists()) {
            file.mkdirs();
        }
        return file.getAbsolutePath() + File.separator;
    }

    private boolean loadLanguageImpl(Context context, String str) {
        checkLanguagePkg(context, str);
        try {
            long currentTimeMillis = System.currentTimeMillis();
            AssetManager assetManager = (AssetManager) AssetManager.class.getConstructor(new Class[0]).newInstance(new Object[0]);
            Method declaredMethod = AssetManager.class.getDeclaredMethod("addAssetPath", String.class);
            declaredMethod.setAccessible(true);
            declaredMethod.invoke(assetManager, str);
            Resources resources = new Resources(assetManager, this.mResourcesImpl.getDefaultResource().getDisplayMetrics(), this.mResourcesImpl.getDefaultResource().getConfiguration());
            String packageName = context.getPackageName();
            PackageInfo packageArchiveInfo = context.getPackageManager().getPackageArchiveInfo(str, 1);
            if (packageArchiveInfo != null) {
                packageName = packageArchiveInfo.packageName;
            } else {
                QLog.d(TAG, 1, "pkgInfo is null");
            }
            this.mResourcesImpl.setMultiLangResource(resources, packageName);
            QLog.d(TAG, 1, "loadLangPkg:", assetManager.toString(), " ,cost:", Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
            return true;
        } catch (Exception e16) {
            QLog.d(TAG, 1, e16, new Object[0]);
            return false;
        }
    }

    private void resourcesDelegate(Context context) {
        try {
            long currentTimeMillis = System.currentTimeMillis();
            Class<?> cls = Class.forName("android.app.ContextImpl");
            Field declaredField = cls.getDeclaredField("mResources");
            declaredField.setAccessible(true);
            Object obj = declaredField.get(context);
            declaredField.set(context, this.mDelegateResources);
            QLog.d(TAG, 1, "success in delegate ContextImpl resources:", this.mDelegateResources.toString(), " ,old:", obj.toString());
            Field declaredField2 = cls.getDeclaredField("mPackageInfo");
            declaredField2.setAccessible(true);
            Object obj2 = declaredField2.get(context);
            Field declaredField3 = Class.forName("android.app.LoadedApk").getDeclaredField("mResources");
            declaredField3.setAccessible(true);
            Object obj3 = declaredField3.get(obj2);
            declaredField3.set(obj2, this.mDelegateResources);
            QLog.d(TAG, 1, "success in delegate LoadedApk resources:", this.mDelegateResources.toString(), " ,old:", obj3.toString(), " ,cost:", Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
        } catch (Exception e16) {
            e16.printStackTrace();
        }
    }

    public void checkEnglishLangPkg(Context context) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) context);
            return;
        }
        checkLanguagePkg(context, getLanguageSavePath() + EN_PKG_FILE);
    }

    public void initAndDelegate(Context context) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) context);
            return;
        }
        QLog.d(TAG, 1, "initAndDelegate:", Boolean.valueOf(!LocaleManager.isLocaleCN()), ", context:", context);
        if (context == null || LocaleManager.isLocaleCN()) {
            return;
        }
        this.mResourcesImpl = new QQResourcesImpl(context);
        this.mDelegateResources = new DelegateResources(this.mResourcesImpl);
        resourcesDelegate(context);
    }

    public void loadLanguage(Context context) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) context);
            return;
        }
        if (LocaleManager.isLocaleENG()) {
            loadLanguageImpl(context, getLanguageSavePath() + EN_PKG_FILE);
            return;
        }
        QQResourcesImpl qQResourcesImpl = this.mResourcesImpl;
        if (qQResourcesImpl != null) {
            qQResourcesImpl.setMultiLangResource(null, null);
        }
    }

    public void register(Activity activity) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) activity);
            return;
        }
        if (LocaleManager.isLocaleCN()) {
            return;
        }
        long currentTimeMillis = System.currentTimeMillis();
        try {
            LayoutInflater.from(activity).setFactory2(sInjectFactoryList.get(0).getConstructor(Activity.class).newInstance(activity));
            if (QLog.isColorLevel()) {
                QLog.d(TAG, 2, "register cost:", Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
            }
        } catch (Exception e16) {
            QLog.d(TAG, 1, "register error:", e16);
        }
    }

    public void updateLangPkg(Context context) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) context);
            return;
        }
        long currentTimeMillis = System.currentTimeMillis();
        FileUtils.deleteDirectory(getLanguageSavePath());
        loadLanguage(context);
        QLog.d(TAG, 1, "update lang pkg! cost:", Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
    }
}

package com.tencent.mobileqq.pluginsdk;

import android.content.Context;
import android.content.res.AssetManager;
import android.content.res.Resources;
import android.view.ContextThemeWrapper;
import com.tencent.commonsdk.soload.SoLoadCore;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

/* loaded from: classes16.dex */
public class PluginContext extends ContextThemeWrapper {
    static IPatchRedirector $redirector_ = null;
    private static final String TAG;
    private static final boolean USE_RESOURCES_CACHE = false;
    private static final HashMap<String, ContextRIT> sResourcesCache;
    private ClassLoader mClassLoader;
    private Context mOutContext;
    private ContextRIT mRIT;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes16.dex */
    public static class ContextRIT {
        static IPatchRedirector $redirector_;
        public Resources mR;
        public Resources.Theme mT;

        public ContextRIT(Resources.Theme theme, Resources resources) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) theme, (Object) resources);
            } else {
                this.mT = theme;
                this.mR = resources;
            }
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(12757);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 9)) {
            redirector.redirect((short) 9);
        } else {
            TAG = PluginContext.class.getSimpleName();
            sResourcesCache = new HashMap<>();
        }
    }

    public PluginContext(Context context, int i3, String str, ClassLoader classLoader, Resources resources, int i16) {
        super(context, i3);
        ContextRIT orCreateRIT;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, context, Integer.valueOf(i3), str, classLoader, resources, Integer.valueOf(i16));
            return;
        }
        this.mClassLoader = classLoader;
        if (i16 == 2) {
            orCreateRIT = getOrCreateRIT(context, SoLoadCore.getApkPath(BaseApplication.getContext()), str);
        } else if (i16 == 1) {
            orCreateRIT = new ContextRIT(null, resources);
            createTheme(orCreateRIT);
        } else {
            orCreateRIT = getOrCreateRIT(context, str);
        }
        this.mRIT = orCreateRIT;
        this.mOutContext = context;
    }

    private static Resources createResources(Context context, String[] strArr) {
        Resources resources = null;
        try {
            AssetManager assetManager = (AssetManager) AssetManager.class.newInstance();
            Method declaredMethod = AssetManager.class.getDeclaredMethod("addAssetPath", String.class);
            for (String str : strArr) {
                declaredMethod.invoke(assetManager, str);
            }
            resources = createResources(context, assetManager);
            resources.getDisplayMetrics().setTo(context.getResources().getDisplayMetrics());
            return resources;
        } catch (IllegalAccessException e16) {
            e16.printStackTrace();
            return resources;
        } catch (InstantiationException e17) {
            e17.printStackTrace();
            return resources;
        } catch (NoSuchMethodException e18) {
            e18.printStackTrace();
            return resources;
        } catch (InvocationTargetException e19) {
            e19.printStackTrace();
            return resources;
        }
    }

    private static void createTheme(ContextRIT contextRIT) {
        int i3;
        Resources.Theme newTheme = contextRIT.mR.newTheme();
        try {
            i3 = Resources.getSystem().getIdentifier("Theme", "style", "android");
        } catch (Throwable unused) {
            QLog.e(TAG, 1, "create Theme error");
            i3 = -1;
        }
        newTheme.applyStyle(i3, true);
        contextRIT.mT = newTheme;
    }

    private static ContextRIT getOrCreateRIT(Context context, String... strArr) {
        ArrayList arrayList = new ArrayList();
        for (String str : strArr) {
            arrayList.add(str);
        }
        Collections.sort(arrayList);
        ContextRIT contextRIT = new ContextRIT(null, createResources(context, strArr));
        createTheme(contextRIT);
        return contextRIT;
    }

    @Override // android.view.ContextThemeWrapper, android.content.ContextWrapper, android.content.Context
    public AssetManager getAssets() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (AssetManager) iPatchRedirector.redirect((short) 5, (Object) this);
        }
        return this.mRIT.mR.getAssets();
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public ClassLoader getClassLoader() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (ClassLoader) iPatchRedirector.redirect((short) 7, (Object) this);
        }
        ClassLoader classLoader = this.mClassLoader;
        if (classLoader != null) {
            return classLoader;
        }
        return super.getClassLoader();
    }

    public Context getOutContext() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (Context) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return this.mOutContext;
    }

    @Override // android.view.ContextThemeWrapper, android.content.ContextWrapper, android.content.Context
    public Resources getResources() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (Resources) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        return this.mRIT.mR;
    }

    @Override // android.view.ContextThemeWrapper, android.content.ContextWrapper, android.content.Context
    public Resources.Theme getTheme() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (Resources.Theme) iPatchRedirector.redirect((short) 6, (Object) this);
        }
        return this.mRIT.mT;
    }

    public void setClassLoader(ClassLoader classLoader) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, (Object) classLoader);
        } else {
            this.mClassLoader = classLoader;
        }
    }

    @Override // android.view.ContextThemeWrapper
    public void setTheme(Resources.Theme theme) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) theme);
            return;
        }
        ContextRIT contextRIT = this.mRIT;
        if (contextRIT != null) {
            contextRIT.mT = theme;
        }
    }

    private static Resources createResources(Context context, AssetManager assetManager) {
        return new Resources(assetManager, context.getResources().getDisplayMetrics(), context.getResources().getConfiguration());
    }
}

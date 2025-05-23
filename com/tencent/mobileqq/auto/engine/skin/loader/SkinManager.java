package com.tencent.mobileqq.auto.engine.skin.loader;

import android.app.Activity;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.text.TextUtils;
import com.tencent.biz.richframework.delegate.impl.RFWLog;
import com.tencent.mobileqq.auto.engine.skin.listener.ISkinLoader;
import com.tencent.mobileqq.auto.engine.skin.listener.ISkinUpdate;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import java.io.File;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* compiled from: P */
/* loaded from: classes11.dex */
public class SkinManager implements ISkinLoader {
    static IPatchRedirector $redirector_ = null;
    private static final ColorStateList COLORSTATELIST_NULL;
    private static final int COLOR_NULL = 0;
    private static final Drawable DRAWABLE_NULL;
    public static final String KEY_THEME = "key_assign_theme";
    private static final String RES_COLOR = "color";
    private static final String RES_DRAWABLE = "drawable";
    public static final String SKIN_THEME_DEFAULT = "assign_theme_default";
    public static final String SKIN_THEME_NO_DEFAULT = "assign_theme_no_default";
    public static final String TAG;
    private static final ConcurrentHashMap<String, SkinManager> sSkinManagerMap;
    private Map<Integer, Boolean> mAssignThemeMap;
    private boolean mIsDefaultTheme;
    private Map<String, String> mResourceIdAndNameMap;
    private Map<String, Integer> mResourceIdMap;
    private final List<ISkinUpdate> mSkinObservers;
    private String mSkinPackageName;
    private Resources mSkinResource;
    private SkinPkgInfo mSkinResourceData;
    private List<String> sPrefixName;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(8095);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 26)) {
            redirector.redirect((short) 26);
            return;
        }
        TAG = SkinManager.class.getSimpleName();
        COLORSTATELIST_NULL = null;
        DRAWABLE_NULL = null;
        sSkinManagerMap = new ConcurrentHashMap<>();
    }

    SkinManager() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.sPrefixName = new ArrayList();
        this.mSkinObservers = new ArrayList();
        this.mIsDefaultTheme = false;
        int i3 = Build.VERSION.SDK_INT;
        if (i3 != 24 && i3 != 25) {
            this.mAssignThemeMap = new HashMap();
        } else {
            this.mAssignThemeMap = new ConcurrentHashMap();
        }
        setSkinResource(null, null, new SkinPkgInfo("", null), true, null);
    }

    public static SkinManager g(String str) {
        SkinManager skinManager;
        ConcurrentHashMap<String, SkinManager> concurrentHashMap = sSkinManagerMap;
        SkinManager skinManager2 = concurrentHashMap.get(str);
        if (skinManager2 != null) {
            return skinManager2;
        }
        synchronized (SkinManager.class) {
            skinManager = concurrentHashMap.get(str);
            if (skinManager == null) {
                skinManager = new SkinManager();
                concurrentHashMap.put(str, skinManager);
            }
        }
        return skinManager;
    }

    private static String getAssignTheme(Context context) {
        if (context instanceof Activity) {
            Activity activity = (Activity) context;
            if (activity.getIntent() != null && !TextUtils.isEmpty(activity.getIntent().getStringExtra(KEY_THEME))) {
                return activity.getIntent().getStringExtra(KEY_THEME);
            }
            return "";
        }
        return "";
    }

    private static int getColorByName(Resources resources, String str, String str2) {
        if (resources == null) {
            return 0;
        }
        try {
            int identifier = resources.getIdentifier(str, "color", str2);
            if (identifier <= 0) {
                return 0;
            }
            return resources.getColor(identifier);
        } catch (Resources.NotFoundException unused) {
            RFWLog.i(TAG, RFWLog.USR, "getColor skin NotFoundException resId ");
            return 0;
        }
    }

    private int getDefaultColor(Resources resources, int i3) {
        try {
            return resources.getColor(i3);
        } catch (Resources.NotFoundException unused) {
            RFWLog.e(TAG, RFWLog.USR, "getColor default NotFoundException resId : " + i3);
            return 0;
        }
    }

    private Drawable getDefaultDrawable(Resources resources, int i3) {
        try {
            return resources.getDrawable(i3);
        } catch (Resources.NotFoundException unused) {
            RFWLog.e(TAG, RFWLog.USR, "getDrawable default NotFoundException resId : " + i3);
            return DRAWABLE_NULL;
        }
    }

    private Drawable getDrawableByName(Resources resources, String str, String str2) {
        if (resources == null) {
            return null;
        }
        try {
            int identifier = resources.getIdentifier(str, RES_DRAWABLE, str2);
            if (identifier <= 0) {
                return null;
            }
            return resources.getDrawable(identifier, null);
        } catch (Resources.NotFoundException unused) {
            RFWLog.i(TAG, RFWLog.USR, "getDrawable skin NotFoundException resId ");
            return null;
        }
    }

    private boolean loadSkinFile(SkinPkgInfo skinPkgInfo, boolean z16) {
        String skinName = skinPkgInfo.getSkinName();
        if (!new File(skinName).exists()) {
            RFWLog.e(TAG, RFWLog.USR, "load file failed : no skin file or skinFilePath is Empty");
            return false;
        }
        try {
            PackageManager packageManager = ContextHolder.getContext().getPackageManager();
            PackageInfo packageArchiveInfo = packageManager.getPackageArchiveInfo(skinName, 1);
            if (packageArchiveInfo == null) {
                return false;
            }
            ApplicationInfo applicationInfo = packageArchiveInfo.applicationInfo;
            applicationInfo.publicSourceDir = skinName;
            applicationInfo.sourceDir = skinName;
            setSkinResource(packageManager.getResourcesForApplication(applicationInfo), packageArchiveInfo.packageName, skinPkgInfo, z16, skinPkgInfo.getPrefixName());
            notifySkinUpdate();
            return true;
        } catch (Exception e16) {
            e16.printStackTrace();
            RFWLog.e(TAG, RFWLog.USR, "load file failed : " + e16);
            return false;
        }
    }

    private static ColorStateList makeColorStateList(int i3) {
        return new ColorStateList((int[][]) Array.newInstance((Class<?>) Integer.TYPE, 1, 1), new int[]{i3});
    }

    private void putAssignTheme(Context context, boolean z16) {
        if (context == null) {
            return;
        }
        this.mAssignThemeMap.put(Integer.valueOf(context.hashCode()), Boolean.valueOf(z16));
    }

    public static void setContext(Context context) {
        ContextHolder.setContext(context);
    }

    private void setSkinResource(Resources resources, String str, SkinPkgInfo skinPkgInfo, boolean z16, List<String> list) {
        this.mSkinResource = resources;
        this.mSkinPackageName = str;
        this.mSkinResourceData = skinPkgInfo;
        this.mIsDefaultTheme = z16;
        setPrefixName(list);
    }

    @Override // com.tencent.mobileqq.auto.engine.skin.listener.ISkinLoader
    public void attach(ISkinUpdate iSkinUpdate) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) iSkinUpdate);
        } else if (!this.mSkinObservers.contains(iSkinUpdate)) {
            this.mSkinObservers.add(iSkinUpdate);
        }
    }

    @Override // com.tencent.mobileqq.auto.engine.skin.listener.ISkinLoader
    public void detach(ISkinUpdate iSkinUpdate) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) iSkinUpdate);
        } else {
            this.mSkinObservers.remove(iSkinUpdate);
        }
    }

    public int getColor(Context context, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 18)) ? getColor(context, i3, null) : ((Integer) iPatchRedirector.redirect((short) 18, (Object) this, (Object) context, i3)).intValue();
    }

    public ColorStateList getColorStateList(Context context, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 24)) ? getColorStateList(context, i3, null) : (ColorStateList) iPatchRedirector.redirect((short) 24, (Object) this, (Object) context, i3);
    }

    public Drawable getDrawable(Context context, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 21)) ? getDrawable(context, i3, null) : (Drawable) iPatchRedirector.redirect((short) 21, (Object) this, (Object) context, i3);
    }

    @Override // com.tencent.mobileqq.auto.engine.skin.listener.ISkinLoader
    public String getPackageName(Context context) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return (String) iPatchRedirector.redirect((short) 9, (Object) this, (Object) context);
        }
        if (useDefaultTheme(context)) {
            return "";
        }
        return this.mSkinPackageName;
    }

    public List<String> getPrefixName() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            return (List) iPatchRedirector.redirect((short) 12, (Object) this);
        }
        return this.sPrefixName;
    }

    public Map<String, String> getResourceIdAndNameMap() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            return (Map) iPatchRedirector.redirect((short) 16, (Object) this);
        }
        return this.mResourceIdAndNameMap;
    }

    public Map<String, Integer> getResourceIdMap() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            return (Map) iPatchRedirector.redirect((short) 14, (Object) this);
        }
        return this.mResourceIdMap;
    }

    @Override // com.tencent.mobileqq.auto.engine.skin.listener.ISkinLoader
    public SkinPkgInfo getSkinResouceData() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (SkinPkgInfo) iPatchRedirector.redirect((short) 7, (Object) this);
        }
        return this.mSkinResourceData;
    }

    @Override // com.tencent.mobileqq.auto.engine.skin.listener.ISkinLoader
    public Resources getSkinResource() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return (Resources) iPatchRedirector.redirect((short) 8, (Object) this);
        }
        return this.mSkinResource;
    }

    @Override // com.tencent.mobileqq.auto.engine.skin.listener.ISkinLoader
    public boolean loadSkinResource(String str, boolean z16, List<String> list) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Boolean) iPatchRedirector.redirect((short) 6, this, str, Boolean.valueOf(z16), list)).booleanValue();
        }
        if (TextUtils.isEmpty(str)) {
            setSkinResource(null, null, new SkinPkgInfo("", null), true, list);
            return false;
        }
        return loadSkinFile(new SkinPkgInfo(str, list), z16);
    }

    public boolean needChangeTheme(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            return ((Boolean) iPatchRedirector.redirect((short) 17, (Object) this, (Object) str)).booleanValue();
        }
        List<String> list = this.sPrefixName;
        if (list != null && list.size() != 0 && !TextUtils.isEmpty(str)) {
            for (String str2 : this.sPrefixName) {
                if (!TextUtils.isEmpty(str2) && str.startsWith(str2)) {
                    return true;
                }
            }
        }
        return false;
    }

    @Override // com.tencent.mobileqq.auto.engine.skin.listener.ISkinLoader
    public void notifySkinUpdate() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this);
            return;
        }
        RFWLog.d(TAG, RFWLog.USR, "notifySkinUpdate: " + this.mSkinObservers.size());
        Iterator<ISkinUpdate> it = this.mSkinObservers.iterator();
        while (it.hasNext()) {
            it.next().onThemeUpdate();
        }
    }

    public void restoreDefaultTheme() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this);
        } else {
            this.mIsDefaultTheme = true;
            notifySkinUpdate();
        }
    }

    public void setPrefixName(List<String> list) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this, (Object) list);
        } else {
            if (list == null) {
                return;
            }
            this.sPrefixName = list;
        }
    }

    public void setResourceIdAndNameMap(Map<String, String> map) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            iPatchRedirector.redirect((short) 15, (Object) this, (Object) map);
        } else {
            this.mResourceIdAndNameMap = map;
        }
    }

    public void setResourceIdMap(Map<String, Integer> map) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, (Object) this, (Object) map);
        } else {
            this.mResourceIdMap = map;
        }
    }

    public boolean useDefaultTheme(Context context) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return ((Boolean) iPatchRedirector.redirect((short) 10, (Object) this, (Object) context)).booleanValue();
        }
        if (context == null) {
            return this.mIsDefaultTheme;
        }
        if (this.mAssignThemeMap.containsKey(Integer.valueOf(context.hashCode()))) {
            if (this.mAssignThemeMap.get(Integer.valueOf(context.hashCode())).booleanValue()) {
                return SKIN_THEME_DEFAULT.equals(getAssignTheme(context));
            }
            return this.mIsDefaultTheme;
        }
        String assignTheme = getAssignTheme(context);
        boolean z16 = !TextUtils.isEmpty(assignTheme);
        putAssignTheme(context, z16);
        if (z16) {
            return SKIN_THEME_DEFAULT.equals(assignTheme);
        }
        return this.mIsDefaultTheme;
    }

    public int getColor(Context context, int i3, String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            return ((Integer) iPatchRedirector.redirect((short) 19, this, context, Integer.valueOf(i3), str)).intValue();
        }
        if (i3 <= 0) {
            RFWLog.e(TAG, RFWLog.USR, "getColor invalid resId : " + i3);
            return 0;
        }
        Resources resources = ContextHolder.getContext().getResources();
        Resources skinResource = getSkinResource();
        String packageName = getPackageName(context);
        if (skinResource == null) {
            return getDefaultColor(resources, i3);
        }
        if (str == null) {
            try {
                str = resources.getResourceEntryName(i3);
            } catch (Resources.NotFoundException unused) {
                RFWLog.e(TAG, RFWLog.USR, "getColor skin NotFoundException resId : " + i3);
                return getDefaultColor(resources, i3);
            }
        }
        int identifier = skinResource.getIdentifier(str, "color", packageName);
        if (identifier <= 0) {
            return getDefaultColor(resources, i3);
        }
        return skinResource.getColor(identifier);
    }

    public ColorStateList getColorStateList(Context context, int i3, String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 25)) {
            return (ColorStateList) iPatchRedirector.redirect((short) 25, this, context, Integer.valueOf(i3), str);
        }
        if (i3 <= 0) {
            RFWLog.e(TAG, RFWLog.USR, "getColorStateList invalid resId : " + i3);
            return COLORSTATELIST_NULL;
        }
        Resources resources = ContextHolder.getContext().getResources();
        Resources skinResource = getSkinResource();
        String packageName = getPackageName(context);
        try {
            ColorStateList colorStateList = resources.getColorStateList(i3);
            if (skinResource == null) {
                return colorStateList;
            }
            if (str == null) {
                try {
                    str = resources.getResourceEntryName(i3);
                } catch (Resources.NotFoundException unused) {
                    RFWLog.e(TAG, RFWLog.USR, "getColorStateList skin NotFoundException resId : " + i3);
                    return colorStateList;
                }
            }
            int identifier = skinResource.getIdentifier(str, "color", packageName);
            return identifier <= 0 ? colorStateList : skinResource.getColorStateList(identifier);
        } catch (Resources.NotFoundException unused2) {
            RFWLog.w(TAG, RFWLog.USR, "getColorStateList try to getColor\uff0c default NotFoundException resId : " + i3);
            return makeColorStateList(getColor(context, i3, str));
        }
    }

    public Drawable getDrawable(Context context, int i3, String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 22)) {
            return (Drawable) iPatchRedirector.redirect((short) 22, this, context, Integer.valueOf(i3), str);
        }
        if (i3 <= 0) {
            RFWLog.e(TAG, RFWLog.USR, "getDrawable invalid resId : " + i3);
            return DRAWABLE_NULL;
        }
        Resources resources = ContextHolder.getContext().getResources();
        Resources skinResource = getSkinResource();
        String packageName = getPackageName(context);
        if (skinResource == null) {
            return getDefaultDrawable(resources, i3);
        }
        if (str == null) {
            try {
                str = resources.getResourceEntryName(i3);
            } catch (Resources.NotFoundException unused) {
                RFWLog.i(TAG, RFWLog.USR, "getDrawable skin NotFoundException resId : " + i3);
                return getDefaultDrawable(resources, i3);
            }
        }
        int identifier = skinResource.getIdentifier(str, RES_DRAWABLE, packageName);
        if (identifier <= 0) {
            return getDefaultDrawable(resources, i3);
        }
        return skinResource.getDrawable(identifier, null);
    }

    public int getColor(Context context, String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            return ((Integer) iPatchRedirector.redirect((short) 20, (Object) this, (Object) context, (Object) str)).intValue();
        }
        if (TextUtils.isEmpty(str)) {
            return 0;
        }
        Resources skinResource = getSkinResource();
        String packageName = getPackageName(context);
        int colorByName = getColorByName(skinResource, str, packageName);
        return colorByName == 0 ? getColorByName(skinResource, str, packageName) : colorByName;
    }

    public Drawable getDrawable(Context context, String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 23)) {
            return (Drawable) iPatchRedirector.redirect((short) 23, (Object) this, (Object) context, (Object) str);
        }
        if (TextUtils.isEmpty(str)) {
            return DRAWABLE_NULL;
        }
        Resources resources = ContextHolder.getContext().getResources();
        Drawable drawableByName = getDrawableByName(getSkinResource(), str, getPackageName(context));
        return drawableByName == null ? getDrawableByName(resources, str, ContextHolder.getContext().getPackageName()) : drawableByName;
    }
}

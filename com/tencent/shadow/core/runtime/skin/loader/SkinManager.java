package com.tencent.shadow.core.runtime.skin.loader;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.Log;
import com.tencent.shadow.core.runtime.skin.listener.ISkinLoader;
import com.tencent.shadow.core.runtime.skin.listener.ISkinUpdate;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* compiled from: P */
/* loaded from: classes25.dex */
public class SkinManager implements ISkinLoader {
    public static final String TAG = "SkinManager";
    private static volatile SkinManager sInstance;
    private final List<ISkinUpdate> mSkinObservers = new ArrayList();
    private String mSkinPackageName;
    private Resources mSkinResource;
    private SkinPkgInfo mSkinResourceData;

    SkinManager() {
        setSkinResource(null, null, SkinResFactory.createResourceData(5));
    }

    public static int getColor(int i3) {
        return SkinResLoader.getColor(i3, null);
    }

    public static Drawable getDrawable(int i3) {
        return SkinResLoader.getDrawable(i3, null);
    }

    public static SkinManager getsInstance() {
        if (sInstance == null) {
            synchronized (SkinManager.class) {
                if (sInstance == null) {
                    sInstance = new SkinManager();
                }
            }
        }
        return sInstance;
    }

    public static void setContext(Context context) {
        ContextHolder.setContext(context);
    }

    private void setSkinResource(Resources resources, String str, SkinPkgInfo skinPkgInfo) {
        this.mSkinResource = resources;
        this.mSkinPackageName = str;
        this.mSkinResourceData = skinPkgInfo;
    }

    @Override // com.tencent.shadow.core.runtime.skin.listener.ISkinLoader
    public void attach(ISkinUpdate iSkinUpdate) {
        if (!this.mSkinObservers.contains(iSkinUpdate)) {
            this.mSkinObservers.add(iSkinUpdate);
        }
    }

    @Override // com.tencent.shadow.core.runtime.skin.listener.ISkinLoader
    public void detach(ISkinUpdate iSkinUpdate) {
        this.mSkinObservers.remove(iSkinUpdate);
    }

    @Override // com.tencent.shadow.core.runtime.skin.listener.ISkinLoader
    public String getPackageName() {
        return this.mSkinPackageName;
    }

    @Override // com.tencent.shadow.core.runtime.skin.listener.ISkinLoader
    public SkinPkgInfo getSkinResouceData() {
        return this.mSkinResourceData;
    }

    @Override // com.tencent.shadow.core.runtime.skin.listener.ISkinLoader
    public Resources getSkinResource() {
        return this.mSkinResource;
    }

    @Override // com.tencent.shadow.core.runtime.skin.listener.ISkinLoader
    public boolean loadSkinFile(SkinPkgInfo skinPkgInfo) {
        String skinName = skinPkgInfo.getSkinName();
        if (!new File(skinName).exists()) {
            Log.e(TAG, "load file failed : no skin file or skinFilePath is Empty");
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
            setSkinResource(packageManager.getResourcesForApplication(applicationInfo), packageArchiveInfo.packageName, skinPkgInfo);
            notifySkinUpdate();
            return true;
        } catch (Exception e16) {
            e16.printStackTrace();
            Log.e(TAG, "load file failed : " + e16);
            return false;
        }
    }

    public void loadSkinResource(String str) {
        if (TextUtils.isEmpty(str)) {
            setSkinResource(null, null, SkinResFactory.createResourceData(5));
        } else {
            getsInstance().loadSkinFile(new SkinPkgInfo(15, str));
        }
    }

    @Override // com.tencent.shadow.core.runtime.skin.listener.ISkinLoader
    public void notifySkinUpdate() {
        Log.d(TAG, "notifySkinUpdate: " + this.mSkinObservers.size());
        Iterator<ISkinUpdate> it = this.mSkinObservers.iterator();
        while (it.hasNext()) {
            it.next().onThemeUpdate();
        }
    }

    public void restoreDefaultTheme() {
        setSkinResource(null, null, SkinResFactory.createResourceData(5));
        notifySkinUpdate();
    }

    public static int getColor(String str) {
        return SkinResLoader.getColor(str);
    }

    public static Drawable getDrawable(String str) {
        return SkinResLoader.getDrawable(str);
    }
}

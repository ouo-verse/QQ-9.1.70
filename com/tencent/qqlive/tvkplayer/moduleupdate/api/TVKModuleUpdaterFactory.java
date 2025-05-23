package com.tencent.qqlive.tvkplayer.moduleupdate.api;

import android.content.Context;
import androidx.annotation.NonNull;
import com.tencent.qqlive.tvkplayer.api.moduleupdate.ITVKModuleUpdaterMgr;
import com.tencent.qqlive.tvkplayer.tools.utils.TVKLogUtil;

/* compiled from: P */
/* loaded from: classes23.dex */
public class TVKModuleUpdaterFactory {
    private static final String TAG = "TVKPlayer[TVKModuleUpdaterFactory]";
    private static volatile ITVKModuleLibraryLoader mModuleLibraryLoader;
    private static volatile ITVKModuleUpdaterMgr mModuleUpdaterMgr;

    TVKModuleUpdaterFactory() {
    }

    private static ITVKModuleUpdaterMgr createModuleUpdaterMgr(@NonNull Context context, ITVKModuleDownloader iTVKModuleDownloader) {
        try {
            return (ITVKModuleUpdaterMgr) Class.forName("com.tencent.qqlive.tvkplayer.moduleupdate.TVKModuleUpdaterMgr").getConstructor(Context.class, ITVKModuleDownloader.class).newInstance(context, iTVKModuleDownloader);
        } catch (Exception e16) {
            TVKLogUtil.e(TAG, "createModuleUpdaterMgr has exception:" + e16);
            return null;
        }
    }

    public static ITVKModuleLibraryLoader getModuleLibraryLoader() {
        ITVKModuleLibraryLoader iTVKModuleLibraryLoader;
        if (mModuleLibraryLoader != null) {
            return mModuleLibraryLoader;
        }
        synchronized (TVKModuleUpdaterFactory.class) {
            try {
                try {
                    mModuleLibraryLoader = (ITVKModuleLibraryLoader) Class.forName("com.tencent.qqlive.tvkplayer.moduleupdate.TVKModuleLibraryLoader").getConstructor(new Class[0]).newInstance(new Object[0]);
                    iTVKModuleLibraryLoader = mModuleLibraryLoader;
                } catch (Exception e16) {
                    TVKLogUtil.e(TAG, "getModuleLibraryLoader has exception:" + e16);
                    return null;
                }
            } catch (Throwable th5) {
                throw th5;
            }
        }
        return iTVKModuleLibraryLoader;
    }

    public static ITVKModuleUpdaterMgr getModuleUpdaterMgr(@NonNull Context context) {
        if (mModuleUpdaterMgr != null) {
            return mModuleUpdaterMgr;
        }
        synchronized (TVKModuleUpdaterFactory.class) {
            if (mModuleUpdaterMgr == null) {
                mModuleUpdaterMgr = createModuleUpdaterMgr(context, null);
            }
        }
        return mModuleUpdaterMgr;
    }
}

package com.tencent.qqlive.tvkplayer.hook;

import android.os.Looper;
import androidx.annotation.Nullable;
import com.tencent.qqlive.tvkplayer.ad.api.ITVKAdListener;
import com.tencent.qqlive.tvkplayer.ad.api.ITVKAdListenerHookCallback;
import com.tencent.qqlive.tvkplayer.ad.api.TVKAdFactory;
import com.tencent.qqlive.tvkplayer.api.ITVKMediaPlayer;
import com.tencent.qqlive.tvkplayer.api.render.ITVKDrawableContainer;
import com.tencent.qqlive.tvkplayer.context.TVKContext;
import com.tencent.qqlive.tvkplayer.logic.TVKPlayerManager;
import com.tencent.qqlive.tvkplayer.qqliveasset.api.ITVKQQLiveAssetPlayer;
import com.tencent.qqlive.tvkplayer.qqliveasset.api.TVKAssetPlayerFactory;
import com.tencent.qqlive.tvkplayer.tools.utils.TVKLogUtil;
import java.lang.reflect.Field;

/* compiled from: P */
/* loaded from: classes23.dex */
public class TVKHookManager {
    private static final String TAG = "TVKPlayer[TVKHookManager]";
    private static Field mAdListener = null;
    private static Field mAssetPlayer = null;
    private static Field mAssetPlayerListener = null;
    private static Field mDrawableContainer = null;
    private static volatile boolean mIsInit = false;
    private static Field mLooper;
    private static Field mTVKContext;

    public static void hookAdListener(ITVKMediaPlayer iTVKMediaPlayer, ITVKAdListener iTVKAdListener, ITVKAdListenerHookCallback iTVKAdListenerHookCallback) {
        initHook();
        if (!mIsInit) {
            TVKLogUtil.i(TAG, "hookAdListener, init failed");
            return;
        }
        try {
            ITVKAdListener createHookAdListener = TVKAdFactory.createHookAdListener(iTVKAdListener, iTVKAdListenerHookCallback);
            if (createHookAdListener != null) {
                mAdListener.set(iTVKMediaPlayer, createHookAdListener);
            }
        } catch (Exception e16) {
            TVKLogUtil.i(TAG, "hookAdListener has exception:" + e16.toString());
        }
    }

    public static void hookQQLiveAssetPlayer(ITVKMediaPlayer iTVKMediaPlayer, @Nullable Looper looper, ITVKQQLiveAssetPlayerHookCallback iTVKQQLiveAssetPlayerHookCallback) {
        initHook();
        if (!mIsInit) {
            TVKLogUtil.i(TAG, "hook asset player, init failed");
            return;
        }
        try {
            mAssetPlayer.set(iTVKMediaPlayer, TVKAssetPlayerFactory.createAssetPlayerProxyInstance((TVKContext) mTVKContext.get(iTVKMediaPlayer), (ITVKDrawableContainer) mDrawableContainer.get(iTVKMediaPlayer), (Looper) mLooper.get(iTVKMediaPlayer), looper, iTVKQQLiveAssetPlayerHookCallback));
        } catch (Exception e16) {
            TVKLogUtil.e(TAG, "hook asset player has exception:" + e16.toString());
        }
    }

    public static void hookQQLiveAssetPlayerListener(ITVKMediaPlayer iTVKMediaPlayer, ITVKQQLiveAssetPlayer.ITVKQQLiveAssetPlayerListener iTVKQQLiveAssetPlayerListener, ITVKQQLiveAssetPlayerListenerHookCallback iTVKQQLiveAssetPlayerListenerHookCallback) {
        initHook();
        if (!mIsInit) {
            TVKLogUtil.i(TAG, "hookAssetPlayerListener, init failed");
            return;
        }
        try {
            mAssetPlayerListener.set(iTVKMediaPlayer, new TVKHookQQLiveAssetPlayerListener(iTVKQQLiveAssetPlayerListenerHookCallback, iTVKQQLiveAssetPlayerListener));
        } catch (Exception e16) {
            TVKLogUtil.i(TAG, "hookAssetPlayerListener has exception:" + e16.toString());
        }
    }

    private static synchronized void initHook() {
        synchronized (TVKHookManager.class) {
            if (mIsInit) {
                return;
            }
            try {
                int i3 = TVKPlayerManager.f345787d;
                Field declaredField = TVKPlayerManager.class.getDeclaredField("mAdListener");
                mAdListener = declaredField;
                declaredField.setAccessible(true);
                Field declaredField2 = TVKPlayerManager.class.getDeclaredField("mAssetPlayer");
                mAssetPlayer = declaredField2;
                declaredField2.setAccessible(true);
                Field declaredField3 = TVKPlayerManager.class.getDeclaredField("mDrawableContainer");
                mDrawableContainer = declaredField3;
                declaredField3.setAccessible(true);
                Field declaredField4 = TVKPlayerManager.class.getDeclaredField("mLooper");
                mLooper = declaredField4;
                declaredField4.setAccessible(true);
                Field declaredField5 = TVKPlayerManager.class.getDeclaredField("mTVKContext");
                mTVKContext = declaredField5;
                declaredField5.setAccessible(true);
                Field declaredField6 = TVKPlayerManager.class.getDeclaredField("mAssetPlayerListener");
                mAssetPlayerListener = declaredField6;
                declaredField6.setAccessible(true);
                mIsInit = true;
            } catch (Exception e16) {
                TVKLogUtil.i(TAG, "initHook has exception:" + e16.toString());
            }
        }
    }
}

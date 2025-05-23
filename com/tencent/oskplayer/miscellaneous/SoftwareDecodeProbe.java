package com.tencent.oskplayer.miscellaneous;

import android.support.annotation.NonNull;
import com.tencent.oskplayer.support.log.Logger;
import com.tencent.oskplayer.support.util.OskFile;
import com.tencent.qqlive.tvkplayer.thirdparties.dnsjava.TTL;
import java.io.File;
import java.util.HashSet;
import java.util.Set;
import tv.danmaku.ijk.media.player.IMediaPlayer;
import tv.danmaku.ijk.media.player.IjkMediaPlayer;
import tv.danmaku.ijk.media.player.annotations.CalledByNative;

/* loaded from: classes22.dex */
public class SoftwareDecodeProbe implements IMediaPlayer.OnPreparedListener {
    public static final String TAG = "SoftwareDecodeProbe";
    static int mMaxFrameNo;
    static volatile SwProbeCallback mProbeCallback;
    static int mProbeError;
    static String mSavedDir;
    IjkMediaPlayer mProber;
    static Object mLockObject = new Object();
    static Set<Integer> mSaveFrames = new HashSet();
    static long mDecodeFrameAvgCost = TTL.MAX_VALUE;

    /* loaded from: classes22.dex */
    public interface SwProbeCallback {
        void onSwProbeOneFrame(int i3);
    }

    public static long getDecodeFrameAvgCost() {
        return mDecodeFrameAvgCost;
    }

    @CalledByNative
    public static int getMaxNeedSaveFrameNo() {
        return mMaxFrameNo;
    }

    @CalledByNative
    public static String getSavedDir() {
        return mSavedDir;
    }

    @CalledByNative
    public static boolean needSaveFrame(int i3) {
        if (mSaveFrames.contains(Integer.valueOf(i3))) {
            return true;
        }
        return false;
    }

    @CalledByNative
    public static void onProbeDone(int i3, long j3) {
        Logger.g().i(TAG, "[onProbeDone] errorCode=" + i3 + ", avgCost=" + j3);
        mProbeError = i3;
        mDecodeFrameAvgCost = j3;
        synchronized (mLockObject) {
            mLockObject.notifyAll();
        }
    }

    @CalledByNative
    public static void onProbeOneFrame(int i3) {
        if (mProbeCallback != null) {
            mProbeCallback.onSwProbeOneFrame(i3);
        }
    }

    public static void setProbeCallback(SwProbeCallback swProbeCallback) {
        mProbeCallback = swProbeCallback;
    }

    @Override // tv.danmaku.ijk.media.player.IMediaPlayer.OnPreparedListener
    public void onPrepared(IMediaPlayer iMediaPlayer) {
        try {
            iMediaPlayer.start();
        } catch (Exception e16) {
            Logger.g().e(TAG, "[probe] start error, " + e16.toString());
            mProbeError = 20002;
        }
    }

    public int probe(@NonNull String str, @NonNull String str2, Set<Integer> set) {
        if (OskFile.isLocalFile(str) && !new File(str).canRead()) {
            Logger.g().e(TAG, "[decode] file cannot read, " + str);
            return 20015;
        }
        File file = new File(str2);
        if (!file.exists() && !file.mkdirs()) {
            return 20004;
        }
        mSavedDir = str2;
        mSaveFrames.clear();
        mMaxFrameNo = -1;
        for (Integer num : set) {
            mMaxFrameNo = Math.max(mMaxFrameNo, num.intValue());
            mSaveFrames.add(num);
        }
        Logger.g().d(TAG, "[probe] mMaxFrameNo=" + mMaxFrameNo + ", savedDir=" + mSavedDir);
        IjkMediaPlayer ijkMediaPlayer = new IjkMediaPlayer();
        this.mProber = ijkMediaPlayer;
        ijkMediaPlayer.setOption(4, "decoder_probe_mode", 1L);
        this.mProber.setOption(4, "max-fps", -1L);
        this.mProber.setOnPreparedListener(this);
        try {
            this.mProber.setDataSource(str);
            this.mProber.prepareAsync();
            mProbeError = 20003;
            synchronized (mLockObject) {
                try {
                    mLockObject.wait(60000L);
                } catch (InterruptedException e16) {
                    Logger.g().e(TAG, "[probe] InterruptedException, " + e16.toString());
                }
            }
            Logger.g().d(TAG, "[probe] probe done, " + mProbeError);
            return mProbeError;
        } catch (Exception e17) {
            Logger.g().e(TAG, "[probe] setDataSource error, " + e17.toString());
            return 20001;
        }
    }
}

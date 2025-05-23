package com.tencent.mobileqq.shortvideo.dancemachine;

import android.graphics.Rect;
import android.graphics.RectF;
import android.media.SoundPool;
import android.opengl.GLES20;
import android.opengl.Matrix;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/* compiled from: P */
/* loaded from: classes18.dex */
public class GLViewContext implements SoundPool.OnLoadCompleteListener {
    private BgmPlayer mBgmPlayer;
    private SoundPool mSoundPool;
    private Rect mSurfaceViewSize;
    private float mVideoResolveRatio;
    private Rect mViewPort;
    private float mViewPortRatio;
    private float[] mProjectMatrix = new float[16];
    public BoyDataReport mReport = new BoyDataReport();
    private HashMap<String, AudioItem> mSoundPoolIdCache = new HashMap<>();
    private CopyOnWriteArrayList<Integer> mStreamIdCache = new CopyOnWriteArrayList<>();
    private ArrayList<AudioItem> mPlayCommandList = new ArrayList<>();
    private final ArrayList<LoadItem> mLoadItemList = new ArrayList<>();

    /* compiled from: P */
    /* loaded from: classes18.dex */
    public static class AudioItem {
        static final int INIT_STATUS = -1;
        static final int SUCCESS_STATUS = 0;
        int loop;
        int priority;
        int sampleId;
        boolean loaded = false;
        int status = -1;

        AudioItem(int i3) {
            this.sampleId = i3;
        }
    }

    /* compiled from: P */
    /* loaded from: classes18.dex */
    public static class LoadItem {
        int sampleId;
        int status;
    }

    public GLViewContext() {
        Matrix.setIdentityM(this.mProjectMatrix, 0);
        this.mBgmPlayer = new BgmPlayer();
    }

    private void calledInGlThread(int i3, int i16) {
        AudioItem audioItem;
        Iterator<AudioItem> it = this.mSoundPoolIdCache.values().iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            AudioItem next = it.next();
            if (next.sampleId == i3) {
                next.loaded = true;
                next.status = i16;
                break;
            }
        }
        Iterator<AudioItem> it5 = this.mPlayCommandList.iterator();
        while (true) {
            if (it5.hasNext()) {
                audioItem = it5.next();
                if (audioItem.sampleId == i3) {
                    playAudioItem(audioItem);
                    break;
                }
            } else {
                audioItem = null;
                break;
            }
        }
        if (audioItem != null) {
            this.mPlayCommandList.remove(audioItem);
        }
    }

    public static void filterCullBegin() {
        GLES20.glEnable(2884);
        if (GlView.ENABLE_X_INVERSE) {
            GLES20.glFrontFace(2304);
        } else {
            GLES20.glFrontFace(2305);
        }
        GLES20.glCullFace(1029);
    }

    public static void filterCullEnd() {
        GLES20.glDisable(2884);
    }

    private void playAudioItem(AudioItem audioItem) {
        if (audioItem.loaded) {
            if (audioItem.status == 0) {
                this.mStreamIdCache.add(Integer.valueOf(this.mSoundPool.play(audioItem.sampleId, 1.0f, 1.0f, audioItem.priority, audioItem.loop, 1.0f)));
                return;
            }
            return;
        }
        if (!this.mPlayCommandList.contains(audioItem)) {
            this.mPlayCommandList.add(audioItem);
        }
    }

    private void playSoundInternal(String str, int i3, int i16) {
        if (this.mSoundPool == null) {
            return;
        }
        if (!this.mSoundPoolIdCache.containsKey(str)) {
            this.mSoundPoolIdCache.put(str, new AudioItem(this.mSoundPool.load(str, 1)));
        }
        AudioItem audioItem = this.mSoundPoolIdCache.get(str);
        audioItem.loop = i3;
        audioItem.priority = i16;
        playAudioItem(audioItem);
    }

    public void allPauseAudio() {
        SoundPool soundPool = this.mSoundPool;
        if (soundPool != null) {
            soundPool.autoPause();
        }
        BgmPlayer bgmPlayer = this.mBgmPlayer;
        if (bgmPlayer != null) {
            bgmPlayer.pauseAudio();
        }
    }

    public void allResumeAudio() {
        SoundPool soundPool = this.mSoundPool;
        if (soundPool != null) {
            soundPool.autoResume();
        }
        BgmPlayer bgmPlayer = this.mBgmPlayer;
        if (bgmPlayer != null) {
            bgmPlayer.resumeAudio();
        }
    }

    public void executeDraw() {
        int size;
        LoadItem[] loadItemArr;
        if (this.mLoadItemList.size() > 0) {
            synchronized (this.mLoadItemList) {
                size = this.mLoadItemList.size();
                loadItemArr = new LoadItem[size];
                this.mLoadItemList.toArray(loadItemArr);
                this.mLoadItemList.clear();
            }
            for (int i3 = 0; i3 < size; i3++) {
                LoadItem loadItem = loadItemArr[i3];
                if (loadItem != null) {
                    calledInGlThread(loadItem.sampleId, loadItem.status);
                }
            }
        }
    }

    public float[] getProjectMatrix() {
        return this.mProjectMatrix;
    }

    public float getRealVideoRatio() {
        return this.mVideoResolveRatio;
    }

    public final Rect getSurfaceViewSize() {
        return this.mSurfaceViewSize;
    }

    public final Rect getViewPort() {
        return this.mViewPort;
    }

    public float getViewPortRatio() {
        return this.mViewPortRatio;
    }

    public void loadSoundResource(List<String> list) {
        if (this.mSoundPool == null && list != null && list.size() != 0) {
            this.mSoundPoolIdCache.clear();
            this.mStreamIdCache.clear();
            SoundPool soundPool = new SoundPool(3, 3, 0);
            this.mSoundPool = soundPool;
            soundPool.setOnLoadCompleteListener(this);
            for (int i3 = 0; i3 < list.size(); i3++) {
                this.mSoundPoolIdCache.put(list.get(i3), new AudioItem(this.mSoundPool.load(list.get(i3), 1)));
            }
        }
    }

    public final void mapNormalRegion(RectF rectF) {
        float viewPortRatio = getViewPortRatio();
        rectF.set(rectF.left * viewPortRatio, rectF.top * viewPortRatio, rectF.right * viewPortRatio, rectF.bottom * viewPortRatio);
    }

    @Override // android.media.SoundPool.OnLoadCompleteListener
    public void onLoadComplete(SoundPool soundPool, int i3, int i16) {
        LoadItem loadItem = new LoadItem();
        loadItem.sampleId = i3;
        loadItem.status = i16;
        synchronized (this.mLoadItemList) {
            this.mLoadItemList.add(loadItem);
        }
    }

    public void playBackGroundSound(String str) {
        BgmPlayer bgmPlayer = this.mBgmPlayer;
        if (bgmPlayer != null) {
            bgmPlayer.playAsync(str);
        }
    }

    public void playBackGroundSoundPool(String str) {
        playSoundInternal(str, -1, 5);
    }

    public void playSound(String str) {
        playSoundInternal(str, 0, 1);
    }

    public void playSoundCount(String str, int i3) {
        playSoundInternal(str, i3, 1);
    }

    public void releaseSoundResource() {
        if (this.mSoundPool == null) {
            return;
        }
        Iterator<Integer> it = this.mStreamIdCache.iterator();
        while (it.hasNext()) {
            this.mSoundPool.stop(it.next().intValue());
        }
        this.mStreamIdCache.clear();
        Iterator<String> it5 = this.mSoundPoolIdCache.keySet().iterator();
        while (it5.hasNext()) {
            this.mSoundPool.unload(this.mSoundPoolIdCache.get(it5.next()).sampleId);
        }
        this.mSoundPoolIdCache.clear();
        this.mSoundPool.release();
        this.mSoundPool = null;
        BgmPlayer bgmPlayer = this.mBgmPlayer;
        if (bgmPlayer != null) {
            bgmPlayer.releaseResource();
            this.mBgmPlayer = null;
        }
    }

    public final void setSurfaceSize(Rect rect) {
        this.mSurfaceViewSize = rect;
    }

    public final void setViewPort(Rect rect) {
        this.mViewPort = rect;
        Matrix.orthoM(this.mProjectMatrix, 0, 0.0f, rect.width(), this.mViewPort.height(), 0.0f, 0.0f, 1.0f);
        this.mViewPortRatio = (this.mViewPort.width() * 1.0f) / this.mSurfaceViewSize.width();
        this.mVideoResolveRatio = this.mViewPort.width() / 750.0f;
    }

    public void stopAllSound() {
        if (this.mSoundPool != null) {
            Iterator<Integer> it = this.mStreamIdCache.iterator();
            while (it.hasNext()) {
                this.mSoundPool.stop(it.next().intValue());
            }
            this.mStreamIdCache.clear();
        }
        BgmPlayer bgmPlayer = this.mBgmPlayer;
        if (bgmPlayer != null) {
            bgmPlayer.stop();
        }
    }

    public final void unmapNormalRegion(RectF rectF) {
        float viewPortRatio = getViewPortRatio();
        rectF.set(rectF.left / viewPortRatio, rectF.top / viewPortRatio, rectF.right / viewPortRatio, rectF.bottom / viewPortRatio);
    }
}

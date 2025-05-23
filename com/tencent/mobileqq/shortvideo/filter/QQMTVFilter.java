package com.tencent.mobileqq.shortvideo.filter;

import android.opengl.GLES20;
import android.os.Bundle;
import com.tencent.av.opengl.filter.qqavimage.QQAVImageFilterConstants;
import com.tencent.mobileqq.richmedia.capture.data.FilterDesc;
import com.tencent.mobileqq.richmedia.mediacodec.utils.GlUtil;
import com.tencent.mobileqq.shortvideo.filter.QQSpecialAVFilter;
import com.tencent.mobileqq.shortvideo.mtveffects.FilmFilter;
import com.tencent.mobileqq.shortvideo.mtveffects.MTV1Filter;
import com.tencent.mobileqq.shortvideo.mtveffects.MTVBaseFilter;
import com.tencent.sveffects.SLog;
import com.tencent.sveffects.SdkContext;
import com.tencent.ttpic.openapi.filter.RenderBuffer;
import java.util.LinkedList;

/* compiled from: P */
/* loaded from: classes18.dex */
public class QQMTVFilter extends QQBaseFilter {
    public static final String TAG = "QQMTVFilter";
    private FilterDesc mCurrentDesc;
    private MTVBaseFilter mCurrentFilter;
    private boolean mDecodeTime;
    private boolean mEnabled;
    private QQSpecialAVFilter.MusicWaveformSupporter mMusicWaveformSupporter;
    private MTVBaseFilter mOldFilter;
    private RenderBuffer mRenderFBO;
    private boolean mReset;
    private long mResetMs;
    private final LinkedList<Runnable> mRunOnDraw;
    private boolean mWorking;

    public QQMTVFilter(int i3, QQFilterRenderManager qQFilterRenderManager) {
        super(i3, qQFilterRenderManager);
        this.mRunOnDraw = new LinkedList<>();
        this.mDecodeTime = false;
        this.mResetMs = 0L;
        this.mReset = true;
        this.mWorking = false;
        this.mEnabled = true;
        SLog.d(TAG, "QQMTVFilter start...");
    }

    private void checkRenderBuffer(int i3, int i16) {
        RenderBuffer renderBuffer = this.mRenderFBO;
        if (renderBuffer == null || renderBuffer.getWidth() != i3 || this.mRenderFBO.getHeight() != i16) {
            releaseRenderBuffer(this.mRenderFBO);
            this.mRenderFBO = new RenderBuffer(i3, i16, 33984);
            SLog.d(TAG, "create new renderfbo, width:" + i3 + " height:" + i16);
        }
    }

    private MTVBaseFilter createFilmFilter(FilterDesc filterDesc) {
        if (filterDesc == null) {
            return null;
        }
        String resFold = filterDesc.getResFold(SdkContext.getInstance().getResources().getArtFilterResource().getFilterResPath());
        SLog.d(TAG, "create film filter, res path:" + resFold);
        FilmFilter filmFilter = new FilmFilter(resFold);
        Bundle bundle = filterDesc.bundle;
        if (bundle != null) {
            long j3 = bundle.getLong("lSeed", 0L);
            long j16 = filterDesc.bundle.getLong("lZoomingTime", 1300L);
            filmFilter.setSeed(j3);
            filmFilter.setZoomingTime(j16);
            SLog.d(TAG, "create MTV1 filter, gaussiantime:" + j16 + " seed:" + j3 + " zoomingtime:" + j16);
        }
        return filmFilter;
    }

    private MTVBaseFilter createMTV1Filter(FilterDesc filterDesc) {
        if (filterDesc == null) {
            return null;
        }
        String resFold = filterDesc.getResFold(SdkContext.getInstance().getResources().getArtFilterResource().getFilterResPath());
        SLog.d(TAG, "create MTV1 filter, res path:" + resFold);
        MTV1Filter mTV1Filter = new MTV1Filter(resFold);
        Bundle bundle = filterDesc.bundle;
        if (bundle != null) {
            boolean z16 = bundle.getBoolean("bRevert", false);
            long j3 = filterDesc.bundle.getLong("lSeed", 0L);
            boolean z17 = filterDesc.bundle.getBoolean("bShowEntrance", true);
            SLog.d(TAG, "create MTV1 filter, brevert:" + z16 + " seed:" + j3 + " bshowentrance:" + z17);
            mTV1Filter.revert(z16);
            mTV1Filter.setSeed(j3);
            mTV1Filter.setShowEntrance(z17);
        }
        return mTV1Filter;
    }

    private long getCurrentMs() {
        if (this.mDecodeTime) {
            return getQQFilterRenderManager().getBusinessOperation().getOrgTimeStamp() / 1000000;
        }
        if (this.mReset) {
            this.mReset = false;
            this.mResetMs = System.currentTimeMillis();
            return 0L;
        }
        return System.currentTimeMillis() - this.mResetMs;
    }

    private MTVBaseFilter getMTVFilter(int i3, int i16) {
        FilterDesc filterDesc = this.mCurrentDesc;
        if (filterDesc == null || filterDesc.f281357id == -1) {
            return null;
        }
        if (this.mOldFilter != null) {
            SLog.d(TAG, "destroy old filter.");
            this.mOldFilter.onSurfaceDestroy();
            this.mOldFilter = null;
        }
        if (this.mCurrentFilter == null) {
            SLog.d(TAG, "create new filter, id:" + this.mCurrentDesc.f281357id);
            FilterDesc filterDesc2 = this.mCurrentDesc;
            int i17 = filterDesc2.f281357id;
            if (i17 != 1017) {
                if (i17 == 1018) {
                    this.mCurrentFilter = createFilmFilter(filterDesc2);
                }
            } else {
                this.mCurrentFilter = createMTV1Filter(filterDesc2);
            }
            MTVBaseFilter mTVBaseFilter = this.mCurrentFilter;
            if (mTVBaseFilter != null) {
                mTVBaseFilter.onSurfaceChange(i3, i16);
            }
            this.mReset = true;
        }
        return this.mCurrentFilter;
    }

    private boolean isMTVID(FilterDesc filterDesc) {
        if (filterDesc == null || QQAVImageFilterConstants.getFilterType(filterDesc.f281357id) != 4) {
            return false;
        }
        return true;
    }

    private void runOnDraw(Runnable runnable) {
        synchronized (this.mRunOnDraw) {
            this.mRunOnDraw.addLast(runnable);
        }
    }

    private void runPendingOnDrawTasks() {
        synchronized (this.mRunOnDraw) {
            while (!this.mRunOnDraw.isEmpty()) {
                this.mRunOnDraw.removeFirst().run();
            }
        }
    }

    public void enable(boolean z16) {
        this.mEnabled = z16;
        SLog.d(TAG, "enable:" + this.mEnabled);
    }

    @Override // com.tencent.mobileqq.shortvideo.filter.QQBaseFilter
    public boolean isFilterWork() {
        return this.mWorking;
    }

    @Override // com.tencent.mobileqq.shortvideo.filter.QQBaseFilter
    public void onDrawFrame() {
        float currentMusicGain;
        float f16;
        long currentTimeMillis = System.currentTimeMillis();
        runPendingOnDrawTasks();
        if (!this.mEnabled) {
            this.mWorking = false;
            this.mOutputTextureID = this.mInputTextureID;
            return;
        }
        checkRenderBuffer(getQQFilterRenderManager().getFilterWidth(), getQQFilterRenderManager().getFilterHeight());
        if (this.mRenderFBO == null) {
            this.mWorking = false;
            this.mOutputTextureID = this.mInputTextureID;
            return;
        }
        MTVBaseFilter mTVFilter = getMTVFilter(getQQFilterRenderManager().getFilterWidth(), getQQFilterRenderManager().getFilterHeight());
        if (mTVFilter == null) {
            this.mWorking = false;
            this.mOutputTextureID = this.mInputTextureID;
            return;
        }
        long currentMs = getCurrentMs();
        QQSpecialAVFilter.MusicWaveformSupporter musicWaveformSupporter = this.mMusicWaveformSupporter;
        if (musicWaveformSupporter == null) {
            currentMusicGain = getQQFilterRenderManager().getBusinessOperation().getCurrentMusicGain();
        } else {
            currentMusicGain = musicWaveformSupporter.getCurrentMusicGain();
        }
        if (currentMusicGain > 0.0f && currentMusicGain <= 1.0f) {
            f16 = currentMusicGain;
        } else {
            f16 = 0.0f;
        }
        this.mRenderFBO.recoverInitialTexId();
        this.mRenderFBO.bind();
        GLES20.glClearColor(0.0f, 0.0f, 0.0f, 0.0f);
        GLES20.glClear(17664);
        this.mRenderFBO.unbind();
        mTVFilter.onDrawFrame(this.mInputTextureID, this.mRenderFBO, currentMs, f16);
        this.mOutputTextureID = this.mRenderFBO.getTexId();
        this.mWorking = true;
        SLog.d(TAG, "QQMTVFilter onDrawFrame cost: " + (System.currentTimeMillis() - currentTimeMillis));
    }

    @Override // com.tencent.mobileqq.shortvideo.filter.QQBaseFilter
    public void onSurfaceChange(int i3, int i16) {
        super.onSurfaceChange(i3, i16);
        SLog.d(TAG, "onSurfaceChange, width:" + i3 + " height:" + i16);
        setCurrentId(getQQFilterRenderManager().getBusinessOperation().getCurrentAVFilterIdByType(4));
    }

    @Override // com.tencent.mobileqq.shortvideo.filter.QQBaseFilter
    public void onSurfaceDestroy() {
        SLog.d(TAG, "onSurfaceDestroy");
        MTVBaseFilter mTVBaseFilter = this.mCurrentFilter;
        if (mTVBaseFilter != null) {
            mTVBaseFilter.onSurfaceDestroy();
            this.mCurrentFilter = null;
        }
        MTVBaseFilter mTVBaseFilter2 = this.mOldFilter;
        if (mTVBaseFilter2 != null) {
            mTVBaseFilter2.onSurfaceDestroy();
            this.mOldFilter = null;
        }
        this.mCurrentDesc = null;
        this.mWorking = false;
        releaseRenderBuffer(this.mRenderFBO);
    }

    void releaseRenderBuffer(RenderBuffer renderBuffer) {
        if (renderBuffer != null) {
            if (renderBuffer.getTexId() >= 0) {
                GlUtil.deleteTexture(renderBuffer.getTexId());
            }
            renderBuffer.destroy();
        }
    }

    public void reset() {
        runOnDraw(new Runnable() { // from class: com.tencent.mobileqq.shortvideo.filter.QQMTVFilter.2
            @Override // java.lang.Runnable
            public void run() {
                SLog.d(QQMTVFilter.TAG, "reset:" + QQMTVFilter.this.mReset);
                QQMTVFilter.this.mReset = true;
            }
        });
    }

    public void setCurrentId(FilterDesc filterDesc) {
        if (isMTVID(filterDesc)) {
            FilterDesc filterDesc2 = new FilterDesc(filterDesc.f281357id, filterDesc.predownload, filterDesc.resurl, filterDesc.resMD5, filterDesc.iconurl, filterDesc.iconMD5, filterDesc.name, 4);
            this.mCurrentDesc = filterDesc2;
            if (filterDesc.bundle != null) {
                filterDesc2.bundle = new Bundle(filterDesc.bundle);
            }
            this.mWorking = true;
        } else {
            this.mCurrentDesc = null;
            this.mWorking = false;
            SLog.d(TAG, "setCurrentId, is not mtv ID.");
        }
        MTVBaseFilter mTVBaseFilter = this.mCurrentFilter;
        if (mTVBaseFilter != null) {
            this.mOldFilter = mTVBaseFilter;
            this.mCurrentFilter = null;
        }
    }

    public void setMusicWaveformSupporter(QQSpecialAVFilter.MusicWaveformSupporter musicWaveformSupporter) {
        this.mMusicWaveformSupporter = musicWaveformSupporter;
    }

    public void useFrameTime(final boolean z16) {
        runOnDraw(new Runnable() { // from class: com.tencent.mobileqq.shortvideo.filter.QQMTVFilter.1
            @Override // java.lang.Runnable
            public void run() {
                SLog.d(QQMTVFilter.TAG, "useFrameTime:" + z16);
                QQMTVFilter.this.mDecodeTime = z16;
            }
        });
    }
}

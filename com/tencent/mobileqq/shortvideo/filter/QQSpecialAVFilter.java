package com.tencent.mobileqq.shortvideo.filter;

import android.opengl.GLES20;
import com.tencent.av.opengl.filter.qqavimage.QQAVImageFilterConstants;
import com.tencent.av.opengl.filter.qqavimage.specialeffects.MirrorSpecialEffectImageFilter;
import com.tencent.av.opengl.filter.qqavimage.specialeffects.QQAVImageBoxFilter;
import com.tencent.av.opengl.filter.qqavimage.specialeffects.QQAVImageBulgeDistortionFilter;
import com.tencent.av.opengl.filter.qqavimage.specialeffects.QQAVImageGaussianSelecterBlurFilter;
import com.tencent.av.opengl.filter.qqavimage.specialeffects.QQAVImageGhostFilter;
import com.tencent.av.opengl.filter.qqavimage.specialeffects.QQAVImageKaleidoscopeFilter;
import com.tencent.av.opengl.filter.qqavimage.specialeffects.QQAVImageOldTVFilter;
import com.tencent.av.opengl.filter.qqavimage.specialeffects.QQAVImageShakeFilter;
import com.tencent.av.opengl.filter.qqavimage.specialeffects.QQAVImageSoulFilter;
import com.tencent.av.opengl.filter.qqavimage.specialeffects.QQAVImageWrongEraseFilter;
import com.tencent.av.opengl.utils.AVGLUtils;
import com.tencent.av.video.effect.core.qqavimage.QQAVImageFilter;
import com.tencent.mobileqq.richmedia.capture.data.FilterDesc;
import com.tencent.mobileqq.richmedia.capture.data.MusicItemInfo;
import com.tencent.sveffects.SLog;

/* compiled from: P */
/* loaded from: classes18.dex */
public class QQSpecialAVFilter extends QQBaseFilter {
    private final String TAG;
    private boolean bwork;
    private int fboHeight;
    private int fboWidth;
    private FilterDesc mCurrentDesc;
    private QQAVImageFilter mCurrentFilter;
    private int mFilterTextureFbo;
    private int[] mFilterTextureId;
    private MusicWaveformSupporter mMusicWaveformSupporter;
    private QQAVImageFilter mOldFilter;
    private boolean mRenderEditVideoFilterBitmap;

    /* compiled from: P */
    /* loaded from: classes18.dex */
    public interface MusicWaveformShaker {
        void setMusicScale(float f16);
    }

    /* compiled from: P */
    /* loaded from: classes18.dex */
    public interface MusicWaveformSupporter {
        float getCurrentMusicGain();

        MusicItemInfo getMusicItemInfo();
    }

    public QQSpecialAVFilter(int i3, QQFilterRenderManager qQFilterRenderManager) {
        super(i3, qQFilterRenderManager);
        this.TAG = "QQSpecialAVFilter";
        this.mFilterTextureId = new int[]{-1};
        this.mFilterTextureFbo = -1;
        this.fboWidth = -1;
        this.fboHeight = -1;
        this.bwork = false;
        this.mRenderEditVideoFilterBitmap = false;
    }

    private QQAVImageFilter getSpecialFilter(int i3, int i16) {
        if (this.mFilterTextureFbo == -1 || this.mFilterTextureId[0] == -1 || this.fboWidth != i3 || this.fboHeight != i16) {
            int[] iArr = this.mFilterTextureId;
            GLES20.glGenTextures(iArr.length, iArr, 0);
            this.mFilterTextureFbo = AVGLUtils.initFrameBuffer(i3, i16, this.mFilterTextureId[0]);
            this.fboWidth = i3;
            this.fboHeight = i16;
        }
        FilterDesc filterDesc = this.mCurrentDesc;
        if (filterDesc == null || filterDesc.f281357id == -1) {
            return null;
        }
        QQAVImageFilter qQAVImageFilter = this.mOldFilter;
        if (qQAVImageFilter != null) {
            qQAVImageFilter.destroy();
            this.mOldFilter = null;
        }
        if (this.mCurrentFilter == null) {
            switch (this.mCurrentDesc.f281357id) {
                case 1006:
                    this.mCurrentFilter = new MirrorSpecialEffectImageFilter(1006);
                    break;
                case 1007:
                    this.mCurrentFilter = new QQAVImageBulgeDistortionFilter();
                    break;
                case 1008:
                    this.mCurrentFilter = new QQAVImageGaussianSelecterBlurFilter();
                    break;
                case 1009:
                    this.mCurrentFilter = new QQAVImageKaleidoscopeFilter();
                    break;
                case 1010:
                    this.mCurrentFilter = new QQAVImageGhostFilter();
                    break;
                case 1011:
                    this.mCurrentFilter = new QQAVImageWrongEraseFilter();
                    break;
                case 1012:
                    this.mCurrentFilter = new QQAVImageOldTVFilter();
                    break;
                case 1013:
                    this.mCurrentFilter = new QQAVImageShakeFilter();
                    break;
                case 1014:
                    this.mCurrentFilter = new QQAVImageSoulFilter();
                    break;
                case 1015:
                    this.mCurrentFilter = new QQAVImageBoxFilter();
                    break;
                case 1016:
                    this.mCurrentFilter = new MirrorSpecialEffectImageFilter(1016);
                    break;
            }
            QQAVImageFilter qQAVImageFilter2 = this.mCurrentFilter;
            if (qQAVImageFilter2 != null) {
                qQAVImageFilter2.init();
            }
        }
        return this.mCurrentFilter;
    }

    private boolean isSpecialId(FilterDesc filterDesc) {
        if (filterDesc == null || QQAVImageFilterConstants.getFilterType(filterDesc.f281357id) != 2) {
            return false;
        }
        return true;
    }

    @Override // com.tencent.mobileqq.shortvideo.filter.QQBaseFilter
    public boolean isFilterWork() {
        return this.bwork;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.tencent.mobileqq.shortvideo.filter.QQBaseFilter
    public void onDrawFrame() {
        float currentMusicGain;
        QQAVImageFilter specialFilter = getSpecialFilter(getQQFilterRenderManager().getFilterWidth(), getQQFilterRenderManager().getFilterHeight());
        if (specialFilter != 0 && this.mFilterTextureFbo != -1) {
            int intParam = getQQFilterRenderManager().getIntParam("key_orientation_degree");
            if (intParam == -1) {
                intParam = 90;
            }
            specialFilter.onOutputSizeChanged(getQQFilterRenderManager().getFilterWidth(), getQQFilterRenderManager().getFilterHeight());
            if (specialFilter instanceof MirrorSpecialEffectImageFilter) {
                ((MirrorSpecialEffectImageFilter) specialFilter).setOrientation(intParam);
            }
            if (specialFilter instanceof MusicWaveformShaker) {
                MusicWaveformSupporter musicWaveformSupporter = this.mMusicWaveformSupporter;
                if (musicWaveformSupporter == null) {
                    currentMusicGain = getQQFilterRenderManager().getBusinessOperation().getCurrentMusicGain();
                } else {
                    currentMusicGain = musicWaveformSupporter.getCurrentMusicGain();
                }
                if (currentMusicGain > 0.0f && currentMusicGain <= 1.0f) {
                    ((MusicWaveformShaker) specialFilter).setMusicScale(currentMusicGain);
                } else {
                    ((MusicWaveformShaker) specialFilter).setMusicScale(0.0f);
                }
            }
            specialFilter.onDraw2(this.mInputTextureID, this.mFilterTextureFbo);
            this.mOutputTextureID = this.mFilterTextureId[0];
            QQFilterLogManager.setFilterStatus("QQSpecialAVFilter", true);
            this.bwork = true;
            return;
        }
        this.mOutputTextureID = this.mInputTextureID;
        QQFilterLogManager.setFilterStatus("QQSpecialAVFilter", false);
        this.bwork = false;
    }

    @Override // com.tencent.mobileqq.shortvideo.filter.QQBaseFilter
    public void onSurfaceChange(int i3, int i16) {
        SLog.d("QQSpecialAVFilter", "special onSurfaceChange ");
        setCurrentId(getQQFilterRenderManager().getBusinessOperation().getCurrentAVFilterIdByType(2));
    }

    @Override // com.tencent.mobileqq.shortvideo.filter.QQBaseFilter
    public void onSurfaceDestroy() {
        QQAVImageFilter qQAVImageFilter = this.mCurrentFilter;
        if (qQAVImageFilter != null) {
            qQAVImageFilter.destroy();
            this.mCurrentFilter = null;
        }
        QQAVImageFilter qQAVImageFilter2 = this.mOldFilter;
        if (qQAVImageFilter2 != null) {
            qQAVImageFilter2.destroy();
            this.mOldFilter = null;
        }
        this.mCurrentDesc = null;
        this.bwork = false;
        if (this.mFilterTextureFbo != -1) {
            this.mFilterTextureFbo = -1;
        }
        int[] iArr = this.mFilterTextureId;
        if (iArr[0] != -1) {
            iArr[0] = -1;
        }
    }

    public void setCurrentId(FilterDesc filterDesc) {
        if (isSpecialId(filterDesc)) {
            this.mCurrentDesc = new FilterDesc(filterDesc.f281357id, filterDesc.predownload, filterDesc.resurl, filterDesc.resMD5, filterDesc.iconurl, filterDesc.iconMD5, filterDesc.name, 2);
            this.bwork = true;
        } else {
            this.mCurrentDesc = null;
            this.bwork = false;
        }
        QQAVImageFilter qQAVImageFilter = this.mCurrentFilter;
        if (qQAVImageFilter != null) {
            this.mOldFilter = qQAVImageFilter;
            this.mCurrentFilter = null;
        }
    }

    public void setMusicWaveformSupporter(MusicWaveformSupporter musicWaveformSupporter) {
        this.mMusicWaveformSupporter = musicWaveformSupporter;
    }

    public void setRenderEditVideoFilterBitmap(boolean z16) {
        this.mRenderEditVideoFilterBitmap = z16;
    }
}

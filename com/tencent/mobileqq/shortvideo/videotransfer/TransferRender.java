package com.tencent.mobileqq.shortvideo.videotransfer;

import android.text.TextUtils;
import com.tencent.mobileqq.shortvideo.videotransfer.TransferConfig;
import com.tencent.sveffects.SLog;
import com.tencent.ttpic.openapi.filter.GPUBaseFilter;
import com.tencent.ttpic.openapi.filter.RenderBuffer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

/* compiled from: P */
/* loaded from: classes18.dex */
public class TransferRender {
    private static final int STASTE_TRANSFER = 2;
    private static final int STATE_CACHE = 1;
    private static final int STATE_NONE = 0;
    public static final String TAG = "TransferRender";
    private static int TRANSFER_BUFFER_TIME = 300;
    private RenderBuffer mCacheFBO;
    private GPUBaseFilter mCacheFilter;
    private List<TransferInstFilter> mLevelEffectTransFilterList;
    private List<TransferInstFilter> mTransFilterList;
    private TransferData mTransferData;
    private int mLastWidth = 0;
    private int mLastHeight = 0;
    private int mState = 0;
    private long mStartTimeMs = -1;
    private long mEndTimeMs = -1;
    private long mNTransIndex = -1;
    private float[] mCommonFloats = new float[4];
    private int[] mCommonFloatParamPos = {-1, -1, -1, -1};
    private float mSpeedRate = 1.0f;

    private void checkState(long j3) {
        TransferData transferData;
        if (j3 >= 0 && (transferData = this.mTransferData) != null && this.mTransFilterList != null) {
            ArrayList<Long> positions = transferData.getPositions();
            if (positions != null && positions.size() != 0) {
                if (j3 == 0) {
                    resetExtendParam();
                }
                if (this.mSpeedRate > 0.0f) {
                    long duration = getDuration();
                    Iterator<Long> it = positions.iterator();
                    int i3 = -1;
                    while (it.hasNext()) {
                        Long next = it.next();
                        long longValue = next.longValue() + duration;
                        i3++;
                        if (j3 + TRANSFER_BUFFER_TIME < next.longValue()) {
                            this.mState = 0;
                            this.mStartTimeMs = -1L;
                            this.mEndTimeMs = -1L;
                            return;
                        }
                        if (j3 + TRANSFER_BUFFER_TIME >= next.longValue()) {
                            if (j3 < next.longValue()) {
                                this.mState = 1;
                                this.mStartTimeMs = next.longValue();
                                this.mEndTimeMs = longValue;
                                return;
                            }
                            if (j3 <= longValue) {
                                int i16 = this.mState;
                                if (i16 == 0) {
                                    this.mState = 1;
                                    this.mStartTimeMs = next.longValue();
                                    this.mEndTimeMs = longValue;
                                    return;
                                } else {
                                    if (i16 == 1) {
                                        this.mState = 2;
                                        this.mStartTimeMs = next.longValue();
                                        this.mEndTimeMs = longValue;
                                        fillCommonFloats(i3);
                                        this.mNTransIndex = i3;
                                        return;
                                    }
                                    this.mStartTimeMs = next.longValue();
                                    this.mEndTimeMs = longValue;
                                    fillCommonFloats(i3);
                                    this.mNTransIndex = i3;
                                    return;
                                }
                            }
                        }
                    }
                    this.mState = 0;
                    this.mStartTimeMs = -1L;
                    this.mEndTimeMs = -1L;
                    return;
                }
                long duration2 = getDuration();
                for (int size = positions.size() - 1; size >= 0; size--) {
                    Long valueOf = Long.valueOf(positions.get(size).longValue() - this.mTransferData.getReverseShift());
                    long longValue2 = valueOf.longValue() + duration2;
                    if (j3 - TRANSFER_BUFFER_TIME > valueOf.longValue()) {
                        this.mState = 0;
                        this.mStartTimeMs = -1L;
                        this.mEndTimeMs = -1L;
                        return;
                    }
                    if (j3 - TRANSFER_BUFFER_TIME <= valueOf.longValue()) {
                        if (j3 > valueOf.longValue()) {
                            this.mState = 1;
                            this.mStartTimeMs = valueOf.longValue();
                            this.mEndTimeMs = longValue2;
                            return;
                        }
                        if (j3 >= longValue2) {
                            int i17 = this.mState;
                            if (i17 == 0) {
                                this.mState = 1;
                                this.mStartTimeMs = valueOf.longValue();
                                this.mEndTimeMs = longValue2;
                                return;
                            } else {
                                if (i17 == 1) {
                                    this.mState = 2;
                                    this.mStartTimeMs = valueOf.longValue();
                                    this.mEndTimeMs = longValue2;
                                    fillCommonFloats(size);
                                    return;
                                }
                                this.mStartTimeMs = valueOf.longValue();
                                this.mEndTimeMs = longValue2;
                                fillCommonFloats(size);
                                return;
                            }
                        }
                    }
                }
                this.mState = 0;
                this.mStartTimeMs = -1L;
                this.mEndTimeMs = -1L;
                return;
            }
            this.mState = 0;
            this.mStartTimeMs = -1L;
            this.mEndTimeMs = -1L;
            return;
        }
        this.mState = 0;
        this.mStartTimeMs = -1L;
        this.mEndTimeMs = -1L;
    }

    private void clearTransFilter(List<TransferInstFilter> list) {
        if (list != null) {
            Iterator<TransferInstFilter> it = list.iterator();
            while (it.hasNext()) {
                it.next().destroy();
            }
            list.clear();
        }
    }

    private void fillCommonFloats(int i3) {
        TransferConfig.ConfigData configData;
        float[] fArr = this.mCommonFloats;
        fArr[0] = 0.0f;
        fArr[1] = 0.0f;
        fArr[2] = 0.0f;
        fArr[3] = 0.0f;
        TransferData transferData = this.mTransferData;
        if (transferData == null || (configData = transferData.mConfigData) == null) {
            return;
        }
        TransferConfig.ExtendParamFloats extendParamFloats = configData.mCommonFloat1;
        if (extendParamFloats != null) {
            fArr[0] = getExtentParamValue(extendParamFloats, 0, i3);
        }
        TransferConfig.ExtendParamFloats extendParamFloats2 = this.mTransferData.mConfigData.mCommonFloat2;
        if (extendParamFloats2 != null) {
            this.mCommonFloats[1] = getExtentParamValue(extendParamFloats2, 1, i3);
        }
        TransferConfig.ExtendParamFloats extendParamFloats3 = this.mTransferData.mConfigData.mCommonFloat3;
        if (extendParamFloats3 != null) {
            this.mCommonFloats[2] = getExtentParamValue(extendParamFloats3, 2, i3);
        }
        TransferConfig.ConfigData configData2 = this.mTransferData.mConfigData;
        if (configData2.mCommonFloat4 != null) {
            this.mCommonFloats[3] = getExtentParamValue(configData2.mCommonFloat3, 3, i3);
        }
    }

    private long getDuration() {
        if (this.mTransferData != null) {
            if (this.mSpeedRate != -1.0f) {
                this.mSpeedRate = 1.0f;
            }
            return ((float) r0.mConfigData.mDuration) * this.mSpeedRate;
        }
        return 0L;
    }

    private int getExtendParamPosition(TransferConfig.ParamRule paramRule, int i3, int i16) {
        if (paramRule == null) {
            return 0;
        }
        int i17 = paramRule.mMode;
        if (i17 == 2) {
            return (paramRule.mStartPos + i3) % i16;
        }
        return i17 == 0 ? 0 : 0;
    }

    private float getExtentParamValue(TransferConfig.ExtendParamFloats extendParamFloats, int i3, int i16) {
        float[] fArr;
        if (extendParamFloats != null && i3 >= 0) {
            int[] iArr = this.mCommonFloatParamPos;
            if (i3 < iArr.length && (fArr = extendParamFloats.mValues) != null && fArr.length != 0) {
                TransferConfig.ParamRule paramRule = extendParamFloats.mRule;
                if (paramRule == null) {
                    iArr[i3] = i16;
                    if (i16 < 0) {
                        iArr[i3] = 0;
                    } else {
                        iArr[i3] = i16 % fArr.length;
                    }
                    return fArr[iArr[i3]];
                }
                int i17 = paramRule.mLevel;
                if (i17 == 0) {
                    iArr[i3] = getExtendParamPosition(paramRule, i16, fArr.length);
                } else if (i17 == 1) {
                    iArr[i3] = nextExtendParamPosition(paramRule, iArr[i3], fArr.length);
                }
                return extendParamFloats.mValues[this.mCommonFloatParamPos[i3]];
            }
        }
        return 0.0f;
    }

    private void initTransFilterList(List<HashMap<String, String>> list, int i3, boolean z16) {
        if (list != null && !list.isEmpty()) {
            for (int i16 = 0; i16 < list.size(); i16++) {
                String str = list.get(i16).get(TransferConfig.ConfigData.KEY_VERTEX_SHADER);
                String str2 = list.get(i16).get(TransferConfig.ConfigData.KEY_FRAGMENT_SHADER);
                if (TextUtils.isEmpty(str)) {
                    str = TransferInstFilter.DEFAULT_VERTEX_SHADER;
                }
                if (TextUtils.isEmpty(str2)) {
                    str2 = TransferInstFilter.DEFAULT_FRAGMENT_SHADER;
                }
                TransferInstFilter transferInstFilter = new TransferInstFilter(str, str2);
                transferInstFilter.setShaderID(i3);
                transferInstFilter.init();
                transferInstFilter.onOutputSizeChanged(this.mLastWidth, this.mLastHeight);
                if (z16) {
                    this.mLevelEffectTransFilterList.add(transferInstFilter);
                } else {
                    this.mTransFilterList.add(transferInstFilter);
                }
            }
            return;
        }
        this.mTransFilterList.add(new TransferInstFilter(TransferInstFilter.DEFAULT_VERTEX_SHADER, TransferInstFilter.DEFAULT_FRAGMENT_SHADER));
    }

    private int nextExtendParamPosition(TransferConfig.ParamRule paramRule, int i3, int i16) {
        if (paramRule == null) {
            return 0;
        }
        if (i3 < 0) {
            return paramRule.mStartPos;
        }
        int i17 = paramRule.mMode;
        if (i17 != 2) {
            return i17 == 0 ? 0 : 0;
        }
        int i18 = i3 + 1;
        if (i18 >= i16) {
            return 0;
        }
        return i18;
    }

    private void reCreateTransFilter() {
        clearTransFilter(this.mTransFilterList);
        clearTransFilter(this.mLevelEffectTransFilterList);
        if (this.mTransFilterList == null) {
            this.mTransFilterList = new ArrayList();
        }
        if (this.mLevelEffectTransFilterList == null) {
            this.mLevelEffectTransFilterList = new ArrayList();
        }
        TransferData transferData = this.mTransferData;
        if (transferData != null) {
            TransferConfig.ConfigData configData = transferData.mConfigData;
            initTransFilterList(configData.shaderList, configData.mID, configData.mLevelEffectShader);
        }
        if (SLog.isEnable()) {
            SLog.d(TAG, "reCreateTransFilter , mTransferData : " + this.mTransferData + " mTransFilterList.size :" + this.mTransFilterList.size() + " mLevelEffectTransFilterList.size : " + this.mLevelEffectTransFilterList.size());
        }
    }

    private void resetExtendParam() {
        float[] fArr = this.mCommonFloats;
        fArr[0] = 0.0f;
        fArr[1] = 0.0f;
        fArr[2] = 0.0f;
        fArr[3] = 0.0f;
        int[] iArr = this.mCommonFloatParamPos;
        iArr[0] = -1;
        iArr[1] = -1;
        iArr[2] = -1;
        iArr[3] = -1;
    }

    public void destroy() {
        List<TransferInstFilter> list = this.mTransFilterList;
        if (list != null) {
            Iterator<TransferInstFilter> it = list.iterator();
            while (it.hasNext()) {
                it.next().destroy();
            }
            this.mTransFilterList.clear();
            this.mTransFilterList = null;
        }
        GPUBaseFilter gPUBaseFilter = this.mCacheFilter;
        if (gPUBaseFilter != null) {
            gPUBaseFilter.destroy();
            this.mCacheFilter = null;
        }
        RenderBuffer renderBuffer = this.mCacheFBO;
        if (renderBuffer != null) {
            renderBuffer.destroy();
            this.mCacheFBO = null;
        }
        this.mLastWidth = 0;
        this.mLastHeight = 0;
    }

    public boolean isWorking() {
        if (this.mState != 0) {
            return true;
        }
        return false;
    }

    public void onSurfaceChange(int i3, int i16) {
        this.mLastHeight = i16;
        this.mLastWidth = i3;
        RenderBuffer renderBuffer = this.mCacheFBO;
        if (renderBuffer == null || renderBuffer.getWidth() != i3 || this.mCacheFBO.getHeight() != i16) {
            RenderBuffer renderBuffer2 = this.mCacheFBO;
            if (renderBuffer2 != null) {
                renderBuffer2.destroy();
                this.mCacheFBO = null;
            }
            this.mCacheFBO = new RenderBuffer(i3, i16, 33984);
        }
        reCreateTransFilter();
    }

    public int process(int i3, float[] fArr, float[] fArr2, long j3) {
        int i16;
        char c16;
        char c17;
        char c18;
        checkState(j3);
        int i17 = this.mState;
        if (i17 == 0) {
            return -1;
        }
        char c19 = 1;
        if (i17 == 1) {
            if (this.mCacheFilter == null) {
                GPUBaseFilter gPUBaseFilter = new GPUBaseFilter("uniform mat4 uMVPMatrix;\nuniform mat4 uTextureMatrix;\nattribute vec4 aPosition;\nattribute vec4 aTextureCoord;\nvarying vec2 vTextureCoord;\nvoid main() {\n    gl_Position = uMVPMatrix * aPosition;\n    vTextureCoord = (uTextureMatrix * aTextureCoord).xy;\n}\n", GPUBaseFilter.NO_FILTER_FRAGMENT_SHADER);
                this.mCacheFilter = gPUBaseFilter;
                gPUBaseFilter.init();
                this.mCacheFilter.onOutputSizeChanged(this.mLastWidth, this.mLastHeight);
            }
            RenderBuffer renderBuffer = this.mCacheFBO;
            if (renderBuffer != null && this.mCacheFilter != null) {
                renderBuffer.bind();
                this.mCacheFilter.drawTexture(i3, fArr, fArr2);
                this.mCacheFBO.unbind();
            }
        } else if (this.mCacheFBO != null) {
            List<TransferInstFilter> list = this.mLevelEffectTransFilterList;
            float f16 = 0.0f;
            if (list != null && !list.isEmpty()) {
                TransferInstFilter transferInstFilter = this.mLevelEffectTransFilterList.get((int) (this.mNTransIndex % this.mLevelEffectTransFilterList.size()));
                if (this.mSpeedRate > 0.0f) {
                    float[] fArr3 = this.mCommonFloats;
                    transferInstFilter.updateData((int) this.mStartTimeMs, (int) this.mEndTimeMs, (int) j3, fArr3[0], fArr3[1], fArr3[2], fArr3[3]);
                } else {
                    long j16 = this.mEndTimeMs;
                    long j17 = this.mStartTimeMs;
                    float[] fArr4 = this.mCommonFloats;
                    transferInstFilter.updateData((int) j16, (int) j17, (int) ((j17 + j16) - j3), fArr4[0], fArr4[1], fArr4[2], fArr4[3]);
                }
                transferInstFilter.setInputTextureID(i3);
                boolean drawTexture = transferInstFilter.drawTexture(i3, this.mCacheFBO.getTexId(), fArr, fArr2);
                int outputTextureID = transferInstFilter.getOutputTextureID();
                if (!drawTexture) {
                    c19 = 0;
                }
                i16 = outputTextureID;
            } else {
                List<TransferInstFilter> list2 = this.mTransFilterList;
                if (list2 != null && !list2.isEmpty()) {
                    i16 = i3;
                    char c26 = 1;
                    for (TransferInstFilter transferInstFilter2 : this.mTransFilterList) {
                        if (this.mSpeedRate > f16) {
                            c16 = c26;
                            float[] fArr5 = this.mCommonFloats;
                            transferInstFilter2.updateData((int) this.mStartTimeMs, (int) this.mEndTimeMs, (int) j3, fArr5[0], fArr5[c19], fArr5[2], fArr5[3]);
                            c17 = c19;
                        } else {
                            c16 = c26;
                            long j18 = this.mEndTimeMs;
                            long j19 = this.mStartTimeMs;
                            float[] fArr6 = this.mCommonFloats;
                            c17 = 1;
                            transferInstFilter2.updateData((int) j18, (int) j19, (int) ((j19 + j18) - j3), fArr6[0], fArr6[1], fArr6[2], fArr6[3]);
                        }
                        transferInstFilter2.setInputTextureID(i16);
                        boolean drawTexture2 = transferInstFilter2.drawTexture(i3, this.mCacheFBO.getTexId(), fArr, fArr2);
                        i16 = transferInstFilter2.getOutputTextureID();
                        if (c16 != 0 && drawTexture2) {
                            c18 = c17;
                        } else {
                            c18 = 0;
                        }
                        c26 = c18;
                        c19 = c17;
                        f16 = 0.0f;
                    }
                    c19 = c26;
                } else {
                    i16 = i3;
                    c19 = 1;
                }
            }
            if (c19 != 0) {
                return i16;
            }
            return -1;
        }
        return -1;
    }

    public void setSpeedRate(float f16) {
        this.mSpeedRate = f16;
    }

    public void setTransferData(TransferData transferData) {
        this.mTransferData = transferData;
        reCreateTransFilter();
    }
}

package com.tencent.mobileqq.shortvideo.mtveffects;

import android.graphics.BitmapFactory;
import android.graphics.RectF;
import android.opengl.GLES20;
import android.text.TextUtils;
import com.github.henryye.nativeiv.bitmap.NativeBitmapStruct;
import com.tencent.av.video.effect.core.qqavimage.denoise.QQAVImageDenoiseGaussianBlurFilter;
import com.tencent.filter.GLSLRender;
import com.tencent.mobileqq.richmedia.mediacodec.utils.GlUtil;
import com.tencent.sveffects.SLog;
import com.tencent.ttpic.openapi.filter.RenderBuffer;
import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

/* compiled from: P */
/* loaded from: classes18.dex */
public class FilmFilter extends MTVBaseFilter {
    private static final int FIRSET_GAUSSIAN_SHOW_TIME = 360;
    private static final int GAUSSIAN_FILTER_COUNT = 5;
    private static final String MATERIAL_FILE_NAME = "TVErrorNoises.png";
    private static final int MAX_GAUSSIAN_FILTER_RADIUS = 20;
    private static final int MAX_NOISE_COUNT = 18;
    private static final int MAX_NOISE_SHOW_COUNT = 3;
    private static final int MAX_NOISE_SHOW_INTERVAL = 50;
    private static final int MAX_NOISE_SHOW_TIME = 800;
    private static final int MIN_NOISE_SHOW_COUNT = 1;
    private static final int MIN_NOISE_SHOW_TIME = 500;
    private static final int NOISE_ITEM_WIDTH_PX = 79;
    private static final String PALETTE_FILE_NAME = "effectcombofilm.png";
    private static final int PER_GAUSSIAN_SHOW_TIME = 40;
    private static final int SECOND_GAUSSIAN_SHOW_TIME = 200;
    private static final String TAG = "FilmFilter";
    private static final int THIRD_GAUSSIAN_SHOW_DELTA = 800;
    private FilmColorFilter mFilmFilter;
    private int[] mFrameBufferTextures;
    private int[] mFrameBuffers;
    private int mGaussianCurTimes;
    private int mGaussianFilterIndex;
    private QQAVImageDenoiseGaussianBlurFilter[] mGaussianFilters;
    private long mGaussianShowTime;
    private RandomTime mGaussianTime;
    private int mMaterialID;
    private FilmNoiseFilter mNoiseFilter;
    private ArrayList<NoiseItem> mNoiseItems;
    private RandomTime mNoiseShowTime;
    private int mPaletteID;
    private RandomGenerator mRandom;
    private RenderBuffer mRenderFBO;
    private ScaleFilter mScaleFilter;
    private boolean mShowGaussian;
    private boolean mShowNoise;

    /* compiled from: P */
    /* loaded from: classes18.dex */
    public static class NoiseItem {
        public float mSrcX = -1.0f;
        public float mSrcLength = -1.0f;
        public RectF mDstRect = new RectF();
    }

    public FilmFilter(String str) {
        super(1018, str);
        this.mGaussianTime = new RandomTime(false);
        this.mGaussianCurTimes = 0;
        this.mGaussianShowTime = 1300L;
        this.mNoiseShowTime = new RandomTime();
        this.mShowGaussian = false;
        this.mShowNoise = false;
        this.mGaussianFilters = new QQAVImageDenoiseGaussianBlurFilter[5];
        this.mGaussianFilterIndex = -1;
        this.mMaterialID = -1;
        this.mPaletteID = -1;
        this.mNoiseItems = new ArrayList<>();
        this.mRandom = new RandomGenerator(System.currentTimeMillis());
        this.mFrameBufferTextures = new int[1];
        this.mFrameBuffers = new int[1];
    }

    private float calcScaleRate(int i3) {
        return ((i3 * 1.0f) / 60.0f) + 1.0f;
    }

    private void checkData(long j3) {
        boolean checkGaussianTime = checkGaussianTime(j3);
        this.mShowGaussian = checkGaussianTime;
        if (checkGaussianTime) {
            selectGaussianFilter(j3);
        }
        if (checkRandomTime(this.mNoiseShowTime, j3, 500L, 800L, 50L) && !this.mShowNoise) {
            randomNoiseItems();
            if (this.mNoiseItems.size() == 0) {
                this.mShowNoise = false;
                return;
            } else {
                this.mShowNoise = true;
                return;
            }
        }
        this.mShowNoise = false;
    }

    private boolean checkGaussianTime(long j3) {
        long j16;
        if (this.mGaussianTime == null || getPlayMode() == 0 || this.mGaussianShowTime < 0) {
            return false;
        }
        if (getPlayMode() == 2) {
            j16 = -1;
        } else {
            j16 = 1;
        }
        RandomTime randomTime = this.mGaussianTime;
        long j17 = randomTime.mStartPos;
        if (j17 < 0) {
            long j18 = (this.mGaussianShowTime * j16) + j3;
            randomTime.mStartPos = j18;
            randomTime.mEndPos = j18 + (j16 * 360);
            this.mGaussianCurTimes = 0;
        } else if ((j16 != 1 || j17 <= j3) && (j16 != -1 || j17 >= j3)) {
            if ((j16 == 1 && randomTime.mEndPos > j3) || (j16 == -1 && randomTime.mEndPos < j3)) {
                return true;
            }
            int i3 = this.mGaussianCurTimes;
            if (i3 == 0) {
                randomTime.mStartPos = j3;
                randomTime.mEndPos = j3 + (j16 * 200);
                this.mGaussianCurTimes = 1;
            } else if (i3 == 1) {
                long j19 = j3 + (800 * j16);
                randomTime.mStartPos = j19;
                randomTime.mEndPos = j19 + (j16 * 200);
                this.mGaussianCurTimes = 2;
            }
        }
        return false;
    }

    private boolean isOverlapped(NoiseItem noiseItem, NoiseItem noiseItem2) {
        if (noiseItem == null || noiseItem2 == null || Math.abs(noiseItem.mDstRect.left - noiseItem2.mDstRect.left) >= noiseItem.mDstRect.width() || Math.abs(noiseItem.mDstRect.top - noiseItem2.mDstRect.top) >= noiseItem.mDstRect.height()) {
            return false;
        }
        return true;
    }

    /* JADX WARN: Code restructure failed: missing block: B:28:0x008f, code lost:
    
        if (r0 == 0) goto L40;
     */
    /* JADX WARN: Code restructure failed: missing block: B:37:0x006d, code lost:
    
        if (r0 == 0) goto L40;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v0, types: [java.lang.CharSequence, java.lang.String] */
    /* JADX WARN: Type inference failed for: r0v1 */
    /* JADX WARN: Type inference failed for: r0v10 */
    /* JADX WARN: Type inference failed for: r0v11 */
    /* JADX WARN: Type inference failed for: r0v12 */
    /* JADX WARN: Type inference failed for: r0v13 */
    /* JADX WARN: Type inference failed for: r0v14 */
    /* JADX WARN: Type inference failed for: r0v15, types: [java.io.BufferedInputStream, java.io.InputStream] */
    /* JADX WARN: Type inference failed for: r0v16 */
    /* JADX WARN: Type inference failed for: r0v17 */
    /* JADX WARN: Type inference failed for: r0v2 */
    /* JADX WARN: Type inference failed for: r0v3 */
    /* JADX WARN: Type inference failed for: r0v4, types: [java.io.InputStream] */
    /* JADX WARN: Type inference failed for: r0v5 */
    /* JADX WARN: Type inference failed for: r0v6 */
    /* JADX WARN: Type inference failed for: r0v7, types: [java.io.InputStream] */
    /* JADX WARN: Type inference failed for: r0v9 */
    /* JADX WARN: Type inference failed for: r5v2, types: [java.lang.StringBuilder] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private int loadImage(String str) {
        ?? materialPath = getMaterialPath();
        int i3 = -1;
        if (TextUtils.isEmpty(materialPath)) {
            SLog.e(TAG, "loadImage error, path is empty");
            return -1;
        }
        FileInputStream fileInputStream = null;
        try {
            try {
                FileInputStream fileInputStream2 = new FileInputStream(materialPath + str);
                try {
                    materialPath = new BufferedInputStream(fileInputStream2);
                    try {
                        i3 = GlUtil.createTexture(GLSLRender.GL_TEXTURE_2D, BitmapFactory.decodeStream(materialPath));
                        try {
                            fileInputStream2.close();
                        } catch (IOException unused) {
                        }
                    } catch (Exception e16) {
                        e = e16;
                        fileInputStream = fileInputStream2;
                        materialPath = materialPath;
                        e.printStackTrace();
                        SLog.e(TAG, "loadimage exception: " + e);
                        if (fileInputStream != null) {
                            try {
                                fileInputStream.close();
                            } catch (IOException unused2) {
                            }
                        }
                    } catch (OutOfMemoryError unused3) {
                        fileInputStream = fileInputStream2;
                        materialPath = materialPath;
                        SLog.e(TAG, "getBitmap OOM! " + str);
                        if (fileInputStream != null) {
                            try {
                                fileInputStream.close();
                            } catch (IOException unused4) {
                            }
                        }
                    } catch (Throwable th5) {
                        th = th5;
                        fileInputStream = fileInputStream2;
                        if (fileInputStream != null) {
                            try {
                                fileInputStream.close();
                            } catch (IOException unused5) {
                            }
                        }
                        if (materialPath != 0) {
                            try {
                                materialPath.close();
                                throw th;
                            } catch (IOException unused6) {
                                throw th;
                            }
                        }
                        throw th;
                    }
                } catch (Exception e17) {
                    e = e17;
                    materialPath = 0;
                } catch (OutOfMemoryError unused7) {
                    materialPath = 0;
                } catch (Throwable th6) {
                    th = th6;
                    materialPath = 0;
                }
            } catch (Exception e18) {
                e = e18;
                materialPath = 0;
            } catch (OutOfMemoryError unused8) {
                materialPath = 0;
            } catch (Throwable th7) {
                th = th7;
                materialPath = 0;
            }
            try {
                materialPath.close();
            } catch (IOException unused9) {
                return i3;
            }
        } catch (Throwable th8) {
            th = th8;
        }
    }

    private void randomNoiseItems() {
        if (this.mRenderFBO == null) {
            return;
        }
        this.mNoiseItems.clear();
        long nextLong = this.mRandom.nextLong(1L, 3L);
        for (int i3 = 0; i3 < nextLong; i3++) {
            NoiseItem noiseItem = new NoiseItem();
            noiseItem.mSrcLength = 0.055555556f;
            noiseItem.mSrcX = ((float) this.mRandom.nextLong(0L, 18L)) * noiseItem.mSrcLength;
            noiseItem.mDstRect.left = (((float) this.mRandom.nextLong(0L, this.mRenderFBO.getWidth() - 79)) * 1.0f) / this.mRenderFBO.getWidth();
            noiseItem.mDstRect.top = 1.0f - ((((float) this.mRandom.nextLong(0L, this.mRenderFBO.getHeight() - 79)) * 1.0f) / this.mRenderFBO.getHeight());
            RectF rectF = noiseItem.mDstRect;
            rectF.right = rectF.left + 0.055555556f;
            rectF.bottom = rectF.top - 0.055555556f;
            tryAddNoiseItem(noiseItem);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x0074  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0078  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x00e3  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x00e6  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void selectGaussianFilter(long j3) {
        int i3;
        long j16;
        int i16;
        long j17;
        int i17;
        long j18;
        int i18;
        long j19;
        int i19 = 2;
        if (getPlayMode() != 2) {
            RandomTime randomTime = this.mGaussianTime;
            long j26 = randomTime.mEndPos;
            if (j3 <= j26) {
                long j27 = randomTime.mStartPos;
                if (j3 >= j27) {
                    long j28 = (j26 - j27) / 40;
                    if ((j26 - j27) - (40 * j28) > 0) {
                        j28++;
                    }
                    if (j28 <= 2) {
                        this.mGaussianFilterIndex = 0;
                        return;
                    }
                    if (j28 < 9) {
                        while (true) {
                            i17 = 5;
                            if (i19 >= 5) {
                                break;
                            }
                            int i26 = i19 + 1;
                            if (j28 < (i26 * 2) - 1) {
                                j28 = (i19 * 2) - 1;
                                i17 = 5;
                                break;
                            }
                            i19 = i26;
                        }
                        if (i19 != i17) {
                            j18 = j28;
                            RandomTime randomTime2 = this.mGaussianTime;
                            long j29 = randomTime2.mStartPos;
                            i18 = ((int) (j3 - j29)) / (((int) ((randomTime2.mEndPos - j29) / j18)) + 1);
                            j19 = j18 - 1;
                            if (i18 > j19 / 2) {
                                this.mGaussianFilterIndex = i18;
                                return;
                            } else {
                                this.mGaussianFilterIndex = ((int) j19) - i18;
                                return;
                            }
                        }
                    }
                    j18 = 9;
                    RandomTime randomTime22 = this.mGaussianTime;
                    long j292 = randomTime22.mStartPos;
                    i18 = ((int) (j3 - j292)) / (((int) ((randomTime22.mEndPos - j292) / j18)) + 1);
                    j19 = j18 - 1;
                    if (i18 > j19 / 2) {
                    }
                }
            }
            this.mGaussianFilterIndex = -1;
            return;
        }
        RandomTime randomTime3 = this.mGaussianTime;
        long j36 = randomTime3.mEndPos;
        if (j3 >= j36) {
            long j37 = randomTime3.mStartPos;
            if (j3 <= j37) {
                long j38 = (j37 - j36) / 40;
                if ((j37 - j36) - (40 * j38) > 0) {
                    j38++;
                }
                if (j38 <= 2) {
                    this.mGaussianFilterIndex = 0;
                    return;
                }
                if (j38 < 9) {
                    while (true) {
                        i3 = 5;
                        if (i19 >= 5) {
                            break;
                        }
                        int i27 = i19 + 1;
                        if (j38 < (i27 * 2) - 1) {
                            j38 = (i19 * 2) - 1;
                            i3 = 5;
                            break;
                        }
                        i19 = i27;
                    }
                    if (i19 != i3) {
                        j16 = j38;
                        RandomTime randomTime4 = this.mGaussianTime;
                        long j39 = randomTime4.mStartPos;
                        i16 = ((int) (j39 - j3)) / (((int) ((j39 - randomTime4.mEndPos) / j16)) + 1);
                        j17 = j16 - 1;
                        if (i16 > j17 / 2) {
                            this.mGaussianFilterIndex = i16;
                            return;
                        } else {
                            this.mGaussianFilterIndex = ((int) j17) - i16;
                            return;
                        }
                    }
                }
                j16 = 9;
                RandomTime randomTime42 = this.mGaussianTime;
                long j392 = randomTime42.mStartPos;
                i16 = ((int) (j392 - j3)) / (((int) ((j392 - randomTime42.mEndPos) / j16)) + 1);
                j17 = j16 - 1;
                if (i16 > j17 / 2) {
                }
            }
        }
        this.mGaussianFilterIndex = -1;
    }

    private void tryAddNoiseItem(NoiseItem noiseItem) {
        if (noiseItem == null) {
            return;
        }
        if (this.mNoiseItems.size() == 0) {
            this.mNoiseItems.add(noiseItem);
            return;
        }
        Iterator<NoiseItem> it = this.mNoiseItems.iterator();
        while (it.hasNext()) {
            if (isOverlapped(it.next(), noiseItem)) {
                return;
            }
        }
        this.mNoiseItems.add(noiseItem);
    }

    @Override // com.tencent.mobileqq.shortvideo.mtveffects.MTVBaseFilter
    public boolean onDraw(RenderBuffer renderBuffer, int i3, long j3, float f16, float[] fArr, float[] fArr2) {
        boolean z16;
        int i16;
        int i17;
        super.onDraw(renderBuffer, i3, j3, f16, fArr, fArr2);
        if (this.mMaterialID < 0 && this.mPaletteID < 0) {
            SLog.d(TAG, "materialID and paletteID is error");
            return false;
        }
        checkData(j3);
        renderBuffer.bind();
        FilmColorFilter filmColorFilter = this.mFilmFilter;
        if (filmColorFilter != null && (i17 = this.mPaletteID) >= 0) {
            z16 = filmColorFilter.process(i3, i17, fArr, fArr2);
        } else {
            z16 = false;
        }
        if (this.mShowNoise && this.mNoiseFilter != null && this.mNoiseItems.size() > 0 && this.mMaterialID >= 0) {
            this.mNoiseFilter.updateData(this.mNoiseItems);
            this.mNoiseFilter.process(this.mMaterialID, fArr, fArr2);
        }
        renderBuffer.unbind();
        if (z16) {
            i3 = renderBuffer.getTexId();
        }
        if (this.mShowGaussian && (i16 = this.mGaussianFilterIndex) >= 0 && i16 < this.mGaussianFilters.length) {
            if (this.mScaleFilter != null && this.mRenderFBO != null && this.mGaussianCurTimes != 2) {
                float calcScaleRate = calcScaleRate(i16);
                this.mRenderFBO.bind();
                boolean process = this.mScaleFilter.process(i3, 0.5f, 0.5f, calcScaleRate, null, null);
                this.mRenderFBO.unbind();
                if (process) {
                    i3 = this.mRenderFBO.getTexId();
                }
            }
            QQAVImageDenoiseGaussianBlurFilter qQAVImageDenoiseGaussianBlurFilter = this.mGaussianFilters[this.mGaussianFilterIndex];
            if (qQAVImageDenoiseGaussianBlurFilter != null) {
                qQAVImageDenoiseGaussianBlurFilter.onDraw2(i3, this.mFrameBuffers[0]);
            }
            updateRendBuffer(renderBuffer, this.mFrameBufferTextures[0]);
            return true;
        }
        return z16;
    }

    @Override // com.tencent.mobileqq.shortvideo.mtveffects.MTVBaseFilter
    public void onReset(long j3) {
        resetInner(j3);
    }

    @Override // com.tencent.mobileqq.shortvideo.mtveffects.MTVBaseFilter
    public void onSurfaceChange(int i3, int i16) {
        super.onSurfaceChange(i3, i16);
        if (i3 != 0 && i16 != 0) {
            FilmNoiseFilter filmNoiseFilter = this.mNoiseFilter;
            if (filmNoiseFilter != null) {
                filmNoiseFilter.onOutputSizeChanged(i3, i16);
            } else {
                FilmNoiseFilter filmNoiseFilter2 = new FilmNoiseFilter();
                this.mNoiseFilter = filmNoiseFilter2;
                filmNoiseFilter2.init();
                if (this.mNoiseFilter.isInitialized()) {
                    this.mNoiseFilter.onOutputSizeChanged(i3, i16);
                } else {
                    this.mNoiseFilter.destroy();
                    this.mNoiseFilter = null;
                }
            }
            FilmColorFilter filmColorFilter = this.mFilmFilter;
            if (filmColorFilter != null) {
                filmColorFilter.onOutputSizeChanged(i3, i16);
            } else {
                FilmColorFilter filmColorFilter2 = new FilmColorFilter();
                this.mFilmFilter = filmColorFilter2;
                filmColorFilter2.init();
                if (this.mFilmFilter.isInitialized()) {
                    this.mFilmFilter.onOutputSizeChanged(i3, i16);
                } else {
                    this.mFilmFilter.destroy();
                    this.mFilmFilter = null;
                }
            }
            ScaleFilter scaleFilter = this.mScaleFilter;
            if (scaleFilter != null) {
                scaleFilter.onOutputSizeChanged(i3, i16);
            } else {
                ScaleFilter scaleFilter2 = new ScaleFilter();
                this.mScaleFilter = scaleFilter2;
                scaleFilter2.init();
                if (this.mScaleFilter.isInitialized()) {
                    this.mScaleFilter.onOutputSizeChanged(i3, i16);
                } else {
                    this.mScaleFilter.destroy();
                    this.mScaleFilter = null;
                }
            }
            int i17 = 0;
            while (true) {
                QQAVImageDenoiseGaussianBlurFilter[] qQAVImageDenoiseGaussianBlurFilterArr = this.mGaussianFilters;
                if (i17 >= qQAVImageDenoiseGaussianBlurFilterArr.length) {
                    break;
                }
                QQAVImageDenoiseGaussianBlurFilter qQAVImageDenoiseGaussianBlurFilter = qQAVImageDenoiseGaussianBlurFilterArr[i17];
                if (qQAVImageDenoiseGaussianBlurFilter != null) {
                    qQAVImageDenoiseGaussianBlurFilter.onOutputSizeChanged(i3, i16);
                } else {
                    qQAVImageDenoiseGaussianBlurFilterArr[i17] = new QQAVImageDenoiseGaussianBlurFilter((20 / qQAVImageDenoiseGaussianBlurFilterArr.length) * i17);
                    this.mGaussianFilters[i17].init();
                    this.mGaussianFilters[i17].onOutputSizeChanged(i3, i16);
                }
                i17++;
            }
            RenderBuffer renderBuffer = this.mRenderFBO;
            if (renderBuffer == null || renderBuffer.getWidth() != i3 || this.mRenderFBO.getHeight() != i16) {
                RenderBuffer renderBuffer2 = this.mRenderFBO;
                if (renderBuffer2 != null) {
                    renderBuffer2.destroy();
                    this.mRenderFBO = null;
                }
                this.mRenderFBO = new RenderBuffer(i3, i16, 33984);
            }
            if (this.mMaterialID < 0) {
                this.mMaterialID = loadImage(MATERIAL_FILE_NAME);
            }
            if (this.mPaletteID < 0) {
                this.mPaletteID = loadImage(PALETTE_FILE_NAME);
            }
            int length = this.mFrameBufferTextures.length;
            for (int i18 = 0; i18 < length; i18++) {
                GLES20.glGenFramebuffers(1, this.mFrameBuffers, i18);
                GLES20.glGenTextures(1, this.mFrameBufferTextures, i18);
                GLES20.glBindTexture(GLSLRender.GL_TEXTURE_2D, this.mFrameBufferTextures[i18]);
                GLES20.glTexImage2D(GLSLRender.GL_TEXTURE_2D, 0, 6408, i3, i16, 0, 6408, NativeBitmapStruct.GLType.GL_UNSIGNED_BYTE, null);
                GLES20.glTexParameterf(GLSLRender.GL_TEXTURE_2D, 10241, 9729.0f);
                GLES20.glTexParameterf(GLSLRender.GL_TEXTURE_2D, 10240, 9729.0f);
                GLES20.glTexParameteri(GLSLRender.GL_TEXTURE_2D, 10242, 33071);
                GLES20.glTexParameteri(GLSLRender.GL_TEXTURE_2D, 10243, 33071);
                GLES20.glBindFramebuffer(36160, this.mFrameBuffers[i18]);
                GLES20.glFramebufferTexture2D(36160, 36064, GLSLRender.GL_TEXTURE_2D, this.mFrameBufferTextures[i18], 0);
                GLES20.glBindTexture(GLSLRender.GL_TEXTURE_2D, 0);
                GLES20.glBindFramebuffer(36160, 0);
            }
        }
    }

    @Override // com.tencent.mobileqq.shortvideo.mtveffects.MTVBaseFilter
    public void onSurfaceDestroy() {
        super.onSurfaceDestroy();
        FilmColorFilter filmColorFilter = this.mFilmFilter;
        if (filmColorFilter != null) {
            filmColorFilter.destroy();
            this.mFilmFilter = null;
        }
        FilmNoiseFilter filmNoiseFilter = this.mNoiseFilter;
        if (filmNoiseFilter != null) {
            filmNoiseFilter.destroy();
            this.mNoiseFilter = null;
        }
        ScaleFilter scaleFilter = this.mScaleFilter;
        if (scaleFilter != null) {
            scaleFilter.destroy();
            this.mScaleFilter = null;
        }
        int i3 = this.mMaterialID;
        if (i3 >= 0) {
            GlUtil.deleteTexture(i3);
            this.mMaterialID = -1;
        }
        int i16 = this.mPaletteID;
        if (i16 >= 0) {
            GlUtil.deleteTexture(i16);
            this.mPaletteID = -1;
        }
        int i17 = 0;
        while (true) {
            QQAVImageDenoiseGaussianBlurFilter[] qQAVImageDenoiseGaussianBlurFilterArr = this.mGaussianFilters;
            if (i17 >= qQAVImageDenoiseGaussianBlurFilterArr.length) {
                break;
            }
            qQAVImageDenoiseGaussianBlurFilterArr[i17].destroy();
            this.mGaussianFilters[i17] = null;
            i17++;
        }
        this.mGaussianFilterIndex = -1;
        this.mNoiseItems.clear();
        RenderBuffer renderBuffer = this.mRenderFBO;
        if (renderBuffer != null) {
            if (renderBuffer.getTexId() >= 0) {
                GlUtil.deleteTexture(this.mRenderFBO.getTexId());
            }
            this.mRenderFBO.destroy();
        }
        int[] iArr = this.mFrameBuffers;
        if (iArr.length > 0) {
            GLES20.glDeleteFramebuffers(iArr.length, iArr, 0);
        }
        int[] iArr2 = this.mFrameBufferTextures;
        if (iArr2.length > 0) {
            GLES20.glDeleteTextures(iArr2.length, iArr2, 0);
        }
    }

    public void resetInner(long j3) {
        this.mShowGaussian = false;
        this.mShowNoise = false;
        this.mGaussianTime.reset();
        this.mNoiseShowTime.reset();
        this.mNoiseItems.clear();
    }

    @Override // com.tencent.mobileqq.shortvideo.mtveffects.MTVBaseFilter
    public void setSeed(long j3) {
        this.mRandom.setSeed(j3);
    }

    public void setZoomingTime(long j3) {
        this.mGaussianCurTimes = 0;
        this.mGaussianShowTime = j3;
        this.mGaussianTime.reset();
    }
}

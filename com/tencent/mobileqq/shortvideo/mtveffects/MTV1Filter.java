package com.tencent.mobileqq.shortvideo.mtveffects;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.RectF;
import android.opengl.GLES20;
import android.text.TextUtils;
import com.github.henryye.nativeiv.bitmap.NativeBitmapStruct;
import com.tencent.filter.GLSLRender;
import com.tencent.mobileqq.richmedia.mediacodec.utils.GlUtil;
import com.tencent.mobileqq.shortvideo.mtveffects.MTVBaseFilter;
import com.tencent.sveffects.SLog;
import com.tencent.ttpic.openapi.filter.GPUBaseFilter;
import com.tencent.ttpic.openapi.filter.RenderBuffer;
import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes18.dex */
public class MTV1Filter extends MTVBaseFilter {
    private static final int BOTTOM_COLOR_BLUE = -14333474;
    private static final int BOTTOM_COLOR_WHITE = -14868179;
    private static final int BOTTOM_COLOR_YELLOW = -13530;
    private static final float DOV_SCALE = 1.5f;
    private static final float ENTRANCE_1_RECT_MAX_MARGIN_HEIGHT = 0.4f;
    private static final float ENTRANCE_1_RECT_MAX_MARGIN_WIDTH = 0.2f;
    private static final float ENTRANCE_2_RECT_CROSS_HEIGHT = 0.25f;
    private static final float ENTRANCE_2_RECT_CROSS_HEIGHT_DELTA = 0.16f;
    private static final float ENTRANCE_2_RECT_MARGIN_HEIGHT = 0.26f;
    private static final float ENTRANCE_2_RECT_MARGIN_WIDTH = 0.09f;
    private static final float ENTRANCE_SHAPE_CHANGE_POS = 0.7f;
    private static final int GAIN_TYPE_HIGH = 2;
    private static final int GAIN_TYPE_LOW = 1;
    private static final int GAIN_TYPE_NONE = 0;
    public static final String GLITCH_FILE_NAME = "screen_glitch.mp4";
    private static final float HIGH_1_RECT_KEEP_TIME_POSITION = 600.0f;
    private static final float HIGH_1_RECT_MARGIN_HEIGHT = 0.3f;
    private static final float HIGH_1_RECT_MARGIN_WIDTH = 0.0f;
    private static final float HIGH_2_RECT_CROSS_KEEP_TIME_POSITION_1 = 300.0f;
    private static final float HIGH_2_RECT_CROSS_KEEP_TIME_POSITION_2 = 900.0f;
    private static final float HIGH_2_RECT_CROSS_MOVE_TIME_POSITION = 1300.0f;
    private static final float HIGH_2_RECT_HEIGHT = 0.64f;
    private static final float HIGH_2_RECT_MARGIN_HEIGHT_END = 0.74f;
    private static final float HIGH_2_RECT_MARGIN_HEIGHT_START = 0.35f;
    private static final float HIGH_2_RECT_MOVE_MARGIN_WIDTH = 0.09f;
    private static final long HIGH_EFFECT_PERIOD = 10000;
    private static final float LOW_1_RECT_KEEP_TIME_POSITION = 240.0f;
    private static final float LOW_1_RECT_KEEP_TIME_POSITION_2 = 360.0f;
    private static final float LOW_1_RECT_MARGIN_HEIGHT = 0.6f;
    private static final float LOW_1_RECT_MARGIN_HEIGHT_DELTA = 0.08f;
    private static final float LOW_1_RECT_MARGIN_WIDTH = 0.09f;
    private static final float LOW_2_RECT_CROSS_HEIGHT = -0.35f;
    private static final float LOW_2_RECT_CROSS_KEEP_TIME_POSITION_1 = 120.0f;
    private static final float LOW_2_RECT_CROSS_KEEP_TIME_POSITION_2 = 500.0f;
    private static final float LOW_2_RECT_MARGIN_HEIGHT = 0.65f;
    private static final float LOW_2_RECT_MARGIN_WIDTH = 0.09f;
    private static final long LOW_EFFECT_PERIOD = 10000;
    public static final String MATERIAL_FILE_NAME = "material.png";
    private static final int MAX_DOV_COLOR_INTERVAL = 1000;
    private static final int MAX_DOV_COLOR_TIME = 900;
    private static final int MAX_DOV_GLITCH_INTERVAL = 800;
    private static final int MAX_DOV_GLITCH_TIME = 700;
    private static final int MAX_DOV_SCALE_INTERVAL = 1000;
    private static final int MAX_DOV_SCALE_TIME = 1000;
    private static final int MAX_DOV_SHOW_INTERVAL = 1000;
    private static final int MAX_DOV_SHOW_TIME = 3000;
    private static final int MAX_HIGH_PERIOD_TIMES = 2;
    private static final int MAX_LOW_PERIOD_TIMES = 2;
    private static final int MAX_NONE_EFFECT_SHOW = 3000;
    private static final int MAX_NONE_TEXT_SHOW_INTERVAL = 1000;
    private static final int MAX_NONE_TEXT_SHOW_TIME = 200;
    private static final int MAX_NONE_TEXT_SHOW_TIMES = 3;
    private static final int MAX_TODAY_COLOR_INTERVAL = 1000;
    private static final int MAX_TODAY_COLOR_TIME = 500;
    private static final int MAX_TODAY_GLITCH_INTERVAL = 3000;
    private static final int MAX_TODAY_GLITCH_TIME = 500;
    private static final int MAX_TODAY_SCALE_INTERVAL = 1000;
    private static final int MAX_TODAY_SCALE_TIME = 500;
    private static final int MAX_TODAY_SHOW_INTERVAL = 1500;
    private static final int MAX_TODAY_SHOW_TIME = 2000;
    private static final int MAX_VIDEO_CHANGE_INTERVAL = 300;
    private static final int MIN_DOV_COLOR_TIME = 600;
    private static final int MIN_DOV_GLITCH_TIME = 500;
    private static final int MIN_DOV_SCALE_TIME = 500;
    private static final int MIN_DOV_SHOW_TIME = 1500;
    private static final int MIN_NONE_TEXT_SHOW_TIME = 60;
    private static final int MIN_TODAY_COLOR_TIME = 200;
    private static final int MIN_TODAY_GLITCH_TIME = 200;
    private static final int MIN_TODAY_SCALE_TIME = 200;
    private static final int MIN_TODAY_SHOW_TIME = 1000;
    private static final float MUSIC_GAIN_THREASHOLD_HIGH = 0.7f;
    private static final float MUSIC_GAIN_THREASHOLD_LOW = 0.4f;
    public static final int STATE_ENTRANCE = 1;
    public static final int STATE_HIGH_GAIN_EFFECT = 2;
    public static final int STATE_LOW_GAIN_EFFECT = 3;
    public static final int STATE_NONE = 0;
    public static final int STATE_NONE_GAIN_TRANSITION_EFFECT = 4;
    public static final String TAG = "QQMTV1Filter";
    private static final int TEXT_COLOR_BLUE = -14737950;
    private static final int TEXT_COLOR_YELLOW = -265654;
    private static final int TIME_ENTRANCE = 800;
    private static final int TIME_HIGH_GAIN_EFFECT = 1300;
    private static final int TIME_LOW_GAIN_EFFECT = 500;
    private static final int TIME_NONE_EFFECT = 3000;
    private static final int TIME_NONE_GAIN_TRANSITION_EFFECT = 800;
    private static final float TODAY_OFFSET_X = -0.1f;
    private static final float TODAY_OFFSET_Y = -0.1f;
    private static final float TODAY_SCALE = 1.5f;
    private final RectF BG_TEXT_DISTORTION_RECT;
    private final RectF BG_TEXT_RECT;
    private final RectF DOV_RECT;
    private final RectF TODAY_RECT;
    private MTVBaseFilter.TextParam mBGTextParam;
    private GPUBaseFilter mBaseFilter;
    private int mBottomColor;
    private MTV1BottomLayerRender mBottomRender;
    private RandomTime mDovColorTime;
    private RandomTime mDovGlitchTime;
    private RandomTime mDovScaleTime;
    private RandomTime mDovShowTime;
    private MTVBaseFilter.TextParam mDovTextParam;
    private Mp4MaterialLoader mGlitchLoader;
    private long mHighPerioadTimes;
    private long mHighPeriodStartNs;
    private long mLowPerioadTimes;
    private long mLowPeriodStartNs;
    private int mMaterialID;
    private int mPaletteID;
    private float[] mShapePoints;
    private boolean mShowEntrance;
    private int mState;
    private long mStateEndPos;
    private long mStateStartPos;
    private RandomTime mTodayColorTime;
    private RandomTime mTodayGlitchTime;
    private RandomTime mTodayScaleTime;
    private RandomTime mTodayShowTime;
    private MTVBaseFilter.TextParam mTodayTextParam;
    private MTV1TopLayerRender mTopRender;
    private RandomTime mVideoChangeTime;
    private MTV1VideoLayerRender mVideoRender;

    public MTV1Filter(String str) {
        super(1017, str);
        this.TODAY_RECT = new RectF(0.81f, 0.525f, 1.0f, 0.06500003f);
        this.DOV_RECT = new RectF(0.0f, 0.95f, 0.154f, HIGH_2_RECT_HEIGHT);
        this.BG_TEXT_RECT = new RectF(0.317f, 0.884f, 1.0f, 0.031f);
        this.BG_TEXT_DISTORTION_RECT = new RectF(0.15f, 1.0f, 1.0f, -0.1f);
        this.mHighPeriodStartNs = -1L;
        this.mHighPerioadTimes = 2L;
        this.mLowPeriodStartNs = -1L;
        this.mLowPerioadTimes = 2L;
        this.mState = 1;
        this.mStateStartPos = 0L;
        this.mStateEndPos = 0L;
        this.mBGTextParam = new MTVBaseFilter.TextParam();
        this.mDovTextParam = new MTVBaseFilter.TextParam();
        this.mTodayTextParam = new MTVBaseFilter.TextParam();
        this.mDovShowTime = new RandomTime();
        this.mDovGlitchTime = new RandomTime();
        this.mDovScaleTime = new RandomTime();
        this.mDovColorTime = new RandomTime();
        this.mTodayShowTime = new RandomTime();
        this.mTodayScaleTime = new RandomTime();
        this.mTodayGlitchTime = new RandomTime();
        this.mTodayColorTime = new RandomTime();
        this.mVideoChangeTime = new RandomTime(false);
        this.mBottomRender = new MTV1BottomLayerRender();
        this.mVideoRender = new MTV1VideoLayerRender();
        this.mTopRender = new MTV1TopLayerRender();
        this.mGlitchLoader = new Mp4MaterialLoader();
        this.mMaterialID = -1;
        this.mShowEntrance = true;
    }

    private long calcEndPos(int i3, long j3, boolean z16) {
        int i16;
        int i17;
        if (z16) {
            i16 = -1;
        } else {
            i16 = 1;
        }
        if (i3 != 0) {
            if (i3 != 1) {
                if (i3 != 2) {
                    if (i3 != 3) {
                        if (i3 != 4) {
                            return j3;
                        }
                    } else {
                        i17 = i16 * 500;
                    }
                } else {
                    i17 = i16 * 1300;
                }
            }
            i17 = i16 * 800;
        } else {
            i17 = i16 * 3000;
        }
        return j3 + i17;
    }

    private boolean checkHighTimesLimited(long j3) {
        if (j3 - this.mHighPeriodStartNs < 10000) {
            long j16 = this.mHighPerioadTimes;
            if (j16 >= 0) {
                this.mHighPerioadTimes = j16 - 1;
            }
            if (this.mHighPerioadTimes > 0) {
                return true;
            }
            return false;
        }
        this.mHighPeriodStartNs = j3;
        this.mHighPerioadTimes = 2L;
        return true;
    }

    private boolean checkLowTimesLimited(long j3) {
        if (j3 - this.mLowPeriodStartNs < 10000) {
            long j16 = this.mLowPerioadTimes;
            if (j16 >= 0) {
                this.mLowPerioadTimes = j16 - 1;
            }
            if (this.mLowPerioadTimes > 0) {
                return true;
            }
            return false;
        }
        this.mLowPeriodStartNs = j3;
        this.mLowPerioadTimes = 2L;
        return true;
    }

    /* JADX WARN: Code restructure failed: missing block: B:9:0x001e, code lost:
    
        if (r0 != 4) goto L20;
     */
    /* JADX WARN: Removed duplicated region for block: B:37:0x01fc  */
    /* JADX WARN: Removed duplicated region for block: B:39:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:55:0x0186  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x01a1  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x01a6  */
    /* JADX WARN: Removed duplicated region for block: B:64:0x0191  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void checkPlayData(long j3) {
        int i3;
        MTVBaseFilter.TextParam textParam;
        Mp4MaterialLoader mp4MaterialLoader;
        int i16 = this.mState;
        if (i16 != 0) {
            if (i16 != 1) {
                if (i16 != 2) {
                    if (i16 == 3) {
                        this.mBottomColor = BOTTOM_COLOR_BLUE;
                        fillBGTextParam(true, true, TEXT_COLOR_YELLOW, false);
                        this.mPaletteID = 1;
                        fillShapePoints(j3);
                    }
                } else {
                    if (checkRandomTime(this.mVideoChangeTime, j3, 300L, 300L)) {
                        this.mPaletteID = 0;
                        this.mBottomColor = BOTTOM_COLOR_YELLOW;
                        fillBGTextParam(true, true, TEXT_COLOR_BLUE, false);
                    } else {
                        this.mBottomColor = BOTTOM_COLOR_BLUE;
                        fillBGTextParam(true, true, TEXT_COLOR_YELLOW, false);
                        this.mPaletteID = 1;
                    }
                    fillShapePoints(j3);
                }
            } else {
                this.mBottomColor = BOTTOM_COLOR_WHITE;
                fillBGTextParam(false, false, 0, false);
                this.mPaletteID = -1;
                fillShapePoints(j3);
            }
            i3 = this.mState;
            if (i3 == 0 && i3 != 4) {
                this.mDovTextParam.mShow = checkRandomTime(this.mDovShowTime, j3, 1500L, 3000L, 1000L);
                if (checkRandomTime(this.mDovGlitchTime, j3, 500L, 700L, 800L)) {
                    this.mDovTextParam.mGlitchID = this.mGlitchLoader.getCurrentTexture();
                } else {
                    this.mDovTextParam.mGlitchID = -1;
                }
                if (checkRandomTime(this.mDovScaleTime, j3, 500L, 1000L, 1000L)) {
                    this.mDovTextParam.mRect = scaleAndOffset(this.DOV_RECT, 1.5f, 0.0f, 0.0f);
                } else {
                    this.mDovTextParam.mRect = this.DOV_RECT;
                }
                this.mDovTextParam.mChangeColor = checkRandomTime(this.mDovColorTime, j3, 600L, 900L, 1000L);
                MTVBaseFilter.TextParam textParam2 = this.mDovTextParam;
                if (textParam2.mChangeColor) {
                    textParam2.mColor = TEXT_COLOR_BLUE;
                }
                if (textParam2.mShow) {
                    this.mTodayTextParam.mShow = false;
                } else {
                    this.mTodayTextParam.mShow = checkRandomTime(this.mTodayShowTime, j3, 1000L, 2000L, 1500L);
                    if (checkRandomTime(this.mTodayScaleTime, j3, 200L, 500L, 1000L)) {
                        this.mTodayTextParam.mRect = scaleAndOffset(this.TODAY_RECT, 1.5f, -0.1f, -0.1f);
                    } else {
                        this.mTodayTextParam.mRect = this.TODAY_RECT;
                    }
                    if (checkRandomTime(this.mTodayGlitchTime, j3, 200L, 500L, 3000L)) {
                        this.mTodayTextParam.mGlitchID = this.mGlitchLoader.getCurrentTexture();
                    } else {
                        this.mTodayTextParam.mGlitchID = -1;
                    }
                    this.mTodayTextParam.mChangeColor = checkRandomTime(this.mTodayColorTime, j3, 200L, 500L, 1000L);
                    MTVBaseFilter.TextParam textParam3 = this.mTodayTextParam;
                    if (textParam3.mChangeColor) {
                        textParam3.mColor = TEXT_COLOR_BLUE;
                    }
                }
            } else {
                this.mDovTextParam.mShow = checkRandomTime(this.mDovShowTime, j3, 60L, 200L, 1000L);
                if (!checkRandomTime(this.mDovGlitchTime, j3, 500L, 700L, 800L)) {
                    this.mDovTextParam.mGlitchID = this.mGlitchLoader.getCurrentTexture();
                } else {
                    this.mDovTextParam.mGlitchID = -1;
                }
                textParam = this.mDovTextParam;
                textParam.mRect = this.DOV_RECT;
                textParam.mChangeColor = false;
                if (!textParam.mShow) {
                    this.mTodayTextParam.mShow = false;
                } else {
                    this.mTodayTextParam.mShow = checkRandomTime(this.mTodayShowTime, j3, 60L, 200L, 1000L);
                    this.mTodayTextParam.mRect = this.TODAY_RECT;
                    if (checkRandomTime(this.mTodayGlitchTime, j3, 200L, 500L, 3000L)) {
                        this.mTodayTextParam.mGlitchID = this.mGlitchLoader.getCurrentTexture();
                    } else {
                        this.mTodayTextParam.mGlitchID = -1;
                    }
                    this.mTodayTextParam.mChangeColor = false;
                }
            }
            if (this.mTodayTextParam.mGlitchID >= 0 && this.mDovTextParam.mGlitchID < 0) {
                Mp4MaterialLoader mp4MaterialLoader2 = this.mGlitchLoader;
                if (mp4MaterialLoader2 != null) {
                    mp4MaterialLoader2.pause();
                    return;
                }
                return;
            }
            mp4MaterialLoader = this.mGlitchLoader;
            if (mp4MaterialLoader == null) {
                mp4MaterialLoader.resume();
                return;
            }
            return;
        }
        this.mShapePoints = null;
        this.mBottomColor = BOTTOM_COLOR_WHITE;
        fillBGTextParam(false, false, 0, false);
        this.mPaletteID = -1;
        i3 = this.mState;
        if (i3 == 0) {
        }
        this.mDovTextParam.mShow = checkRandomTime(this.mDovShowTime, j3, 60L, 200L, 1000L);
        if (!checkRandomTime(this.mDovGlitchTime, j3, 500L, 700L, 800L)) {
        }
        textParam = this.mDovTextParam;
        textParam.mRect = this.DOV_RECT;
        textParam.mChangeColor = false;
        if (!textParam.mShow) {
        }
        if (this.mTodayTextParam.mGlitchID >= 0) {
        }
        mp4MaterialLoader = this.mGlitchLoader;
        if (mp4MaterialLoader == null) {
        }
    }

    private void checkPlayState(long j3, float f16) {
        if (!this.mShowEntrance && this.mState == 1) {
            enterState(0, j3);
        }
        boolean isStateFinish = isStateFinish(this.mState, j3);
        if (!isStateFinish && this.mState != 0) {
            return;
        }
        clearState(this.mState);
        int i3 = this.mState;
        if (i3 == 1) {
            int musicGainType = getMusicGainType(f16);
            if (musicGainType == 2) {
                if (checkHighTimesLimited(j3)) {
                    enterState(2, j3);
                    return;
                } else {
                    enterState(0, j3);
                    return;
                }
            }
            if (musicGainType == 1) {
                if (checkLowTimesLimited(j3)) {
                    enterState(3, j3);
                    return;
                } else {
                    enterState(0, j3);
                    return;
                }
            }
            enterState(0, j3);
            return;
        }
        if (i3 == 0) {
            if (isStateFinish) {
                if (checkLowTimesLimited(j3)) {
                    enterState(3, j3);
                    return;
                } else {
                    enterState(0, j3);
                    return;
                }
            }
            int musicGainType2 = getMusicGainType(f16);
            if (musicGainType2 == 2) {
                if (checkHighTimesLimited(j3)) {
                    enterState(2, j3);
                    return;
                } else {
                    enterState(0, j3);
                    return;
                }
            }
            if (musicGainType2 == 1) {
                if (checkLowTimesLimited(j3)) {
                    enterState(3, j3);
                    return;
                } else {
                    enterState(0, j3);
                    return;
                }
            }
            return;
        }
        if (i3 == 2) {
            int musicGainType3 = getMusicGainType(f16);
            if (musicGainType3 == 2) {
                enterState(4, j3);
                return;
            }
            if (musicGainType3 == 1) {
                if (checkLowTimesLimited(j3)) {
                    enterState(3, j3);
                    return;
                } else {
                    enterState(0, j3);
                    return;
                }
            }
            enterState(0, j3);
            return;
        }
        if (i3 == 3) {
            int musicGainType4 = getMusicGainType(f16);
            if (musicGainType4 == 2) {
                if (checkHighTimesLimited(j3)) {
                    enterState(2, j3);
                    return;
                } else {
                    enterState(0, j3);
                    return;
                }
            }
            if (musicGainType4 == 1) {
                enterState(4, j3);
                return;
            } else {
                enterState(0, j3);
                return;
            }
        }
        if (i3 == 4) {
            int musicGainType5 = getMusicGainType(f16);
            if (musicGainType5 == 2) {
                if (checkHighTimesLimited(j3)) {
                    enterState(2, j3);
                    return;
                } else {
                    enterState(0, j3);
                    return;
                }
            }
            if (musicGainType5 == 1) {
                enterState(4, j3);
            } else {
                enterState(0, j3);
            }
        }
    }

    private void clearState(int i3) {
        if (i3 != 1 && i3 != 0 && i3 == 2) {
            this.mVideoChangeTime.reset();
        }
    }

    private void enterState(int i3, long j3) {
        boolean z16;
        this.mStateStartPos = j3;
        this.mState = i3;
        if (getPlayMode() == 2) {
            z16 = true;
        } else {
            z16 = false;
        }
        this.mStateEndPos = calcEndPos(i3, j3, z16);
    }

    private void fillBGTextParam(boolean z16, boolean z17, int i3, boolean z18) {
        MTVBaseFilter.TextParam textParam = this.mBGTextParam;
        textParam.mShow = z16;
        textParam.mChangeColor = z17;
        textParam.mColor = i3;
        textParam.mDistortion = z18;
        if (z18) {
            textParam.mRect = this.BG_TEXT_DISTORTION_RECT;
        } else {
            textParam.mRect = this.BG_TEXT_RECT;
        }
    }

    private void fillShapePoints(long j3) {
        int i3 = this.mState;
        if (i3 == 1) {
            if ((((float) Math.abs(j3 - this.mStateStartPos)) * 1.0f) / ((float) Math.abs(this.mStateEndPos - this.mStateStartPos)) < 0.7f) {
                this.mShapePoints = MTV1ShapePoints.getOneRectPoints((((float) Math.abs(j3 - this.mStateStartPos)) * 0.2f) / ((float) Math.abs(this.mStateEndPos - this.mStateStartPos)), (((float) Math.abs(j3 - this.mStateStartPos)) * 0.4f) / ((float) Math.abs(this.mStateEndPos - this.mStateStartPos)), 0.0f);
                return;
            } else {
                this.mShapePoints = MTV1ShapePoints.getTwoStaggerRectPoints(0.09f, ENTRANCE_2_RECT_MARGIN_HEIGHT, ENTRANCE_2_RECT_CROSS_HEIGHT_DELTA, 0.25f, -1.0f);
                return;
            }
        }
        if (i3 == 2) {
            float abs = (float) Math.abs(j3 - this.mStateStartPos);
            if (abs < 300.0f) {
                this.mShapePoints = MTV1ShapePoints.getTwoStaggerRectPoints(0.09f, ENTRANCE_2_RECT_MARGIN_HEIGHT, ENTRANCE_2_RECT_CROSS_HEIGHT_DELTA, 0.25f, -1.0f);
                return;
            }
            if (abs < HIGH_1_RECT_KEEP_TIME_POSITION) {
                this.mShapePoints = MTV1ShapePoints.getOneRectPoints(0.0f, 0.3f, 0.0f);
                return;
            }
            if (abs < HIGH_2_RECT_CROSS_KEEP_TIME_POSITION_2) {
                this.mShapePoints = MTV1ShapePoints.getTwoStaggerRectPoints(0.09f, ENTRANCE_2_RECT_MARGIN_HEIGHT, ENTRANCE_2_RECT_CROSS_HEIGHT_DELTA, 0.25f, -1.0f);
                return;
            } else if (abs < HIGH_2_RECT_CROSS_MOVE_TIME_POSITION) {
                this.mShapePoints = MTV1ShapePoints.getTwoStaggerRectPoints(0.09f, ((((((float) Math.abs(j3 - this.mStateStartPos)) - HIGH_2_RECT_CROSS_KEEP_TIME_POSITION_2) * 1.0f) / 400.0f) * 0.39000002f) + 0.35f, ENTRANCE_2_RECT_CROSS_HEIGHT_DELTA, -1.0f, HIGH_2_RECT_HEIGHT);
                return;
            } else {
                this.mShapePoints = null;
                return;
            }
        }
        if (i3 == 3) {
            float abs2 = (float) Math.abs(j3 - this.mStateStartPos);
            if (abs2 < 120.0f) {
                this.mShapePoints = MTV1ShapePoints.getTwoStaggerRectPoints(0.09f, LOW_2_RECT_MARGIN_HEIGHT, 0.0f, LOW_2_RECT_CROSS_HEIGHT, -1.0f);
                return;
            }
            if (abs2 < 240.0f) {
                this.mShapePoints = MTV1ShapePoints.getOneRectPoints(0.09f, LOW_1_RECT_MARGIN_HEIGHT, 0.0f);
                return;
            }
            if (abs2 < 360.0f) {
                this.mShapePoints = MTV1ShapePoints.getOneRectPoints(0.0f, LOW_1_RECT_MARGIN_HEIGHT, LOW_1_RECT_MARGIN_HEIGHT_DELTA);
            } else if (abs2 < 500.0f) {
                this.mShapePoints = MTV1ShapePoints.getTwoStaggerRectPoints(0.09f, ENTRANCE_2_RECT_MARGIN_HEIGHT, ENTRANCE_2_RECT_CROSS_HEIGHT_DELTA, 0.25f, -1.0f);
            } else {
                this.mShapePoints = null;
            }
        }
    }

    private int getMusicGainType(float f16) {
        if (f16 > 0.7f) {
            return 2;
        }
        if (f16 > 0.4f) {
            return 1;
        }
        return 0;
    }

    private void initMaterialData(int i3, int i16) {
        this.mVideoRender.setMaterialTexture(this.mMaterialID, i3, i16);
        this.mVideoRender.removeAllMaterials();
        this.mVideoRender.addMaterial(1, new RectF(0.012f, 0.204f, 0.33f, 0.19999999f));
        this.mVideoRender.addMaterial(0, new RectF(0.012f, 0.16399997f, 0.33f, 0.16000003f));
        this.mBottomRender.setMaterialTexture(this.mMaterialID, i3, i16);
        this.mBottomRender.removeAllMaterials();
        this.mBottomRender.addMaterial(0, new RectF(0.373f, 1.0f, 1.0f, 0.0f));
        this.mTopRender.setMaterialTexture(this.mMaterialID, i3, i16);
        this.mTopRender.removeAllMaterials();
        this.mTopRender.addMaterial(1, new RectF(0.233463f, 1.0f, 0.337224f, 0.625f));
        this.mTopRender.addMaterial(0, new RectF(0.0f, 1.0f, 0.199741f, 0.686f));
    }

    private boolean isStateFinish(int i3, long j3) {
        int i16;
        if (i3 != 0) {
            i16 = 800;
            if (i3 != 1) {
                if (i3 != 2) {
                    if (i3 != 3) {
                        if (i3 != 4) {
                            i16 = -1;
                        }
                    } else {
                        i16 = 500;
                    }
                } else {
                    i16 = 1300;
                }
            }
        } else {
            i16 = 3000;
        }
        if (Math.abs(j3 - this.mStateStartPos) > i16) {
            return true;
        }
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v12 */
    /* JADX WARN: Type inference failed for: r0v13 */
    /* JADX WARN: Type inference failed for: r0v14 */
    /* JADX WARN: Type inference failed for: r0v15 */
    /* JADX WARN: Type inference failed for: r0v16 */
    /* JADX WARN: Type inference failed for: r0v17 */
    /* JADX WARN: Type inference failed for: r0v18, types: [java.io.BufferedInputStream, java.io.InputStream] */
    /* JADX WARN: Type inference failed for: r0v19 */
    /* JADX WARN: Type inference failed for: r0v2, types: [java.lang.CharSequence, java.lang.String] */
    /* JADX WARN: Type inference failed for: r0v20 */
    /* JADX WARN: Type inference failed for: r0v3 */
    /* JADX WARN: Type inference failed for: r0v4 */
    /* JADX WARN: Type inference failed for: r0v5 */
    /* JADX WARN: Type inference failed for: r0v6, types: [java.io.InputStream] */
    /* JADX WARN: Type inference failed for: r0v7 */
    /* JADX WARN: Type inference failed for: r0v8 */
    /* JADX WARN: Type inference failed for: r0v9, types: [java.io.InputStream] */
    /* JADX WARN: Type inference failed for: r4v2, types: [java.lang.StringBuilder] */
    /* JADX WARN: Type inference failed for: r5v0, types: [java.lang.StringBuilder] */
    private void loadMaterial(int i3, int i16) {
        SLog.d(TAG, "loadMaterial, width:" + i3 + " height:" + i16);
        ?? materialPath = getMaterialPath();
        if (TextUtils.isEmpty(materialPath)) {
            this.mMaterialID = -1;
            SLog.e(TAG, "loadMaterial path is empty");
            return;
        }
        if (!this.mGlitchLoader.isInited()) {
            this.mGlitchLoader.init(i3, i16);
            this.mGlitchLoader.start(materialPath + GLITCH_FILE_NAME);
            this.mGlitchLoader.pause();
        }
        if (this.mMaterialID <= 0) {
            FileInputStream fileInputStream = null;
            try {
                try {
                    FileInputStream fileInputStream2 = new FileInputStream(materialPath + MATERIAL_FILE_NAME);
                    try {
                        materialPath = new BufferedInputStream(fileInputStream2);
                        try {
                            Bitmap decodeStream = BitmapFactory.decodeStream(materialPath);
                            int createTexture = GlUtil.createTexture(GLSLRender.GL_TEXTURE_2D, decodeStream);
                            this.mMaterialID = createTexture;
                            int revertTexture = revertTexture(createTexture, i3, i16);
                            if (revertTexture >= 0) {
                                GlUtil.deleteTexture(this.mMaterialID);
                                this.mMaterialID = revertTexture;
                            }
                            initMaterialData(decodeStream.getWidth(), decodeStream.getHeight());
                            try {
                                fileInputStream2.close();
                            } catch (IOException unused) {
                            }
                        } catch (Exception e16) {
                            e = e16;
                            fileInputStream = fileInputStream2;
                            materialPath = materialPath;
                            SLog.e(TAG, "loadMaterial exception:" + e);
                            this.mMaterialID = -1;
                            e.printStackTrace();
                            if (fileInputStream != null) {
                                try {
                                    fileInputStream.close();
                                } catch (IOException unused2) {
                                }
                            }
                            if (materialPath == 0) {
                                return;
                            }
                            materialPath.close();
                        } catch (OutOfMemoryError unused3) {
                            fileInputStream = fileInputStream2;
                            materialPath = materialPath;
                            SLog.e(TAG, "getBitmap OOM!");
                            this.mMaterialID = -1;
                            if (fileInputStream != null) {
                                try {
                                    fileInputStream.close();
                                } catch (IOException unused4) {
                                }
                            }
                            if (materialPath == 0) {
                                return;
                            }
                            materialPath.close();
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
                }
            } catch (Throwable th8) {
                th = th8;
            }
        }
    }

    private void resetInner(long j3) {
        if (this.mShowEntrance) {
            enterState(1, j3);
        } else {
            enterState(0, j3);
        }
        this.mRandom.reset();
        this.mDovGlitchTime.reset();
        this.mDovShowTime.reset();
        this.mDovScaleTime.reset();
        this.mDovColorTime.reset();
        this.mTodayColorTime.reset();
        this.mTodayScaleTime.reset();
        this.mTodayShowTime.reset();
        this.mTodayGlitchTime.reset();
        this.mVideoChangeTime.reset();
        this.mHighPeriodStartNs = -1L;
        this.mHighPerioadTimes = 2L;
        this.mLowPeriodStartNs = -1L;
        this.mLowPerioadTimes = 2L;
    }

    private int revertTexture(int i3, int i16, int i17) {
        if (this.mBaseFilter == null) {
            return -1;
        }
        GLES20.glActiveTexture(33984);
        int createTexture = GlUtil.createTexture(GLSLRender.GL_TEXTURE_2D);
        if (createTexture < 0) {
            return -1;
        }
        GLES20.glTexImage2D(GLSLRender.GL_TEXTURE_2D, 0, 6408, i16, i17, 0, 6408, NativeBitmapStruct.GLType.GL_UNSIGNED_BYTE, null);
        RenderBuffer renderBuffer = new RenderBuffer(i16, i17, 33984);
        renderBuffer.setTexId(createTexture);
        renderBuffer.bind();
        this.mBaseFilter.drawTexture(i3, new float[]{1.0f, 0.0f, 0.0f, 0.0f, 0.0f, -1.0f, 0.0f, 0.0f, 0.0f, 0.0f, -1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 1.0f}, null);
        renderBuffer.unbind();
        renderBuffer.recoverInitialTexId();
        renderBuffer.destroy();
        return createTexture;
    }

    private static RectF scaleAndOffset(RectF rectF, float f16, float f17, float f18) {
        RectF rectF2 = new RectF(rectF);
        float f19 = rectF2.right;
        float f26 = rectF2.left;
        float f27 = ((f19 - f26) * f16) + f26;
        float f28 = rectF2.top;
        float f29 = f28 - ((f28 - rectF2.bottom) * f16);
        rectF2.left = f26 + f17;
        rectF2.right = f27 + f17;
        rectF2.top = f28 - f18;
        rectF2.bottom = f29 - f18;
        return rectF2;
    }

    @Override // com.tencent.mobileqq.shortvideo.mtveffects.MTVBaseFilter
    public boolean onDraw(RenderBuffer renderBuffer, int i3, long j3, float f16, float[] fArr, float[] fArr2) {
        boolean z16;
        super.onDraw(renderBuffer, i3, j3, f16, fArr, fArr2);
        boolean z17 = false;
        if (this.mMaterialID < 0) {
            SLog.e(TAG, "MTV1 material image load error");
            return false;
        }
        checkPlayState(j3, f16);
        checkPlayData(j3);
        if (getPlayMode() == 0) {
            SLog.e(TAG, "MTV1 playmode is none, return");
            return false;
        }
        this.mBottomRender.updateData(this.mBottomColor, this.mBGTextParam);
        boolean updateRendBuffer = updateRendBuffer(renderBuffer, this.mBottomRender.process(renderBuffer, i3, fArr, fArr2));
        this.mVideoRender.updateData(this.mShapePoints, this.mPaletteID);
        if (!updateRendBuffer(renderBuffer, this.mVideoRender.process(renderBuffer, i3, null, fArr2)) && !updateRendBuffer) {
            z16 = false;
        } else {
            z16 = true;
        }
        this.mTopRender.updateData(this.mDovTextParam, this.mTodayTextParam);
        if (updateRendBuffer(renderBuffer, this.mTopRender.process(renderBuffer, i3, fArr, fArr2)) || z16) {
            z17 = true;
        }
        this.mGlitchLoader.releaseCurrentTexture();
        return z17;
    }

    @Override // com.tencent.mobileqq.shortvideo.mtveffects.MTVBaseFilter
    public void onReset(long j3) {
        resetInner(j3);
    }

    @Override // com.tencent.mobileqq.shortvideo.mtveffects.MTVBaseFilter
    public void onSurfaceChange(int i3, int i16) {
        super.onSurfaceChange(i3, i16);
        if (i3 != 0 && i16 != 0) {
            this.mBottomRender.onSurfaceChanged(i3, i16);
            this.mTopRender.onSurfaceChanged(i3, i16);
            this.mVideoRender.onSurfaceChanged(i3, i16);
            GPUBaseFilter gPUBaseFilter = this.mBaseFilter;
            if (gPUBaseFilter != null) {
                gPUBaseFilter.onOutputSizeChanged(i3, i16);
            } else {
                GPUBaseFilter gPUBaseFilter2 = new GPUBaseFilter();
                this.mBaseFilter = gPUBaseFilter2;
                gPUBaseFilter2.init();
                if (this.mBaseFilter.isInitialized()) {
                    this.mBaseFilter.onOutputSizeChanged(i3, i16);
                } else {
                    this.mBaseFilter = null;
                }
            }
            loadMaterial(i3, i16);
        }
    }

    @Override // com.tencent.mobileqq.shortvideo.mtveffects.MTVBaseFilter
    public void onSurfaceDestroy() {
        super.onSurfaceDestroy();
        int i3 = this.mMaterialID;
        if (i3 > 0) {
            GlUtil.deleteTexture(i3);
            this.mMaterialID = -1;
        }
        this.mBottomRender.onSurfaceDestroy();
        this.mTopRender.onSurfaceDestroy();
        this.mVideoRender.onSurfaceDestroy();
        GPUBaseFilter gPUBaseFilter = this.mBaseFilter;
        if (gPUBaseFilter != null) {
            gPUBaseFilter.destroy();
            this.mBaseFilter = null;
        }
        this.mGlitchLoader.unInit();
        this.mState = 1;
        this.mStateStartPos = 0L;
        this.mStateEndPos = 0L;
        this.mShapePoints = null;
    }

    public void setShowEntrance(boolean z16) {
        this.mShowEntrance = z16;
    }
}

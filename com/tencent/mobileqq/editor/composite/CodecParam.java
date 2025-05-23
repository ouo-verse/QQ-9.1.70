package com.tencent.mobileqq.editor.composite;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.shortvideo.VideoEnvironment;
import com.tencent.mobileqq.transfile.RichMediaStrategy;

/* loaded from: classes6.dex */
public class CodecParam {
    static IPatchRedirector $redirector_ = null;
    public static final int AUDIO_SAMPLE_16K = 16000;
    public static final int AUDIO_SAMPLE_44DOT1K = 44100;
    public static final int AUDIO_SAMPLE_8K = 8000;
    public static final int AUDIO_START_TIME_RATIO_INIT = 65537;
    public static final int BITRATE_MODE_CBR = 1;
    public static final int BITRATE_MODE_VBR = 0;
    public static final int DEFAULT_ADJUST_SPECIAL_SPEED = 1;
    public static final int DEFAULT_CRF_VALUE = 23;
    public static int DST_VIDEO_HEIGHT = 0;
    public static int DST_VIDEO_WIDTH = 0;
    public static int FINAL_DST_VIDEO_HEIGHT = 0;
    public static int FINAL_DST_VIDEO_WIDTH = 0;
    public static final String PARAM_AUDIO_CHANNEL = "audio_channel";
    public static final String PARAM_AUDIO_SAMPLERATE = "audio_samplerate";
    public static final String PARAM_CUR_TYPE = "curType";
    public static final String PARAM_SYNC_STORY_CHECKED = "sync_story_checked";
    public static int RECORD_MAX_TIME = 0;
    public static int RECORD_MIN_TIME = 0;
    public static final int SAVE_BACK_MODE = 5;
    public static final int SAVE_BLACK_WHITE_FILTER_MODE = 9;
    public static final int SAVE_BRIGHT_FILTER_MODE = 6;
    public static final int SAVE_COLD_FILTER_MODE = 8;
    public static final int SAVE_FAST_MODE = 1;
    public static final int SAVE_LITTLE_FAST_MODE = 3;
    public static final int SAVE_LOMO_FILTER_MODE = 7;
    public static final int SAVE_MODE_INDEX = 15;
    public static final int SAVE_NORMAL_MODE = 0;
    public static final int SAVE_SLOW_MODE = 2;
    public static final int SAVE_VERY_SLOW_MODE = 4;
    public static int SEGMENT_RECORD_MAX_TIME;
    public static int VIDEO_FPS;
    public static int VIDEO_RATIO_DEN;
    public static int VIDEO_RATIO_MOL;
    public static int mAdjustSpecialSpeed;
    public static int mAudioChannel;
    public static int mAudioFormat;
    public static int mAudioSampleRate;
    public static int mAudioTimeRatio;
    public static int mAudioTimestampHigh;
    public static int mAudioTimestampLow;
    public static int mBitrateMode;
    public static int mCRFValue;
    public static int mCodecId;
    public static int mDstAudioEncBitrate;
    public static int mDstVideoEncBitrate;
    private static int mEnableBaseLineMp4;
    public static int mEnableTimestampFix;
    public static int mEnableTotalTimeAdjust;
    public static int mGopSize;
    public static int mIFrameInterval;
    public static int mIsSmooth;
    public static int mMaxQdiff;
    public static int mMaxrate;
    public static int mMinrate;
    public static int mQmax;
    public static int mQmin;
    public static int mRecordFrames;
    public static int mRecordTime;
    public static int mRefframe;
    public static int mSaveMode;
    public static int mVersion;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(41990);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
            return;
        }
        mVersion = 1;
        mCodecId = 0;
        RECORD_MAX_TIME = 8000;
        RECORD_MIN_TIME = 2000;
        SEGMENT_RECORD_MAX_TIME = 20000;
        mDstVideoEncBitrate = 500000;
        VIDEO_FPS = 30;
        VIDEO_RATIO_MOL = 2;
        VIDEO_RATIO_DEN = 3;
        DST_VIDEO_WIDTH = 480;
        DST_VIDEO_HEIGHT = 360;
        FINAL_DST_VIDEO_WIDTH = 320;
        FINAL_DST_VIDEO_HEIGHT = 240;
        mDstAudioEncBitrate = 64000;
        mAudioChannel = 16;
        mAudioFormat = 2;
        mAudioSampleRate = 44100;
        mMaxrate = RichMediaStrategy.NO_MSF_SUGGEST_RETRY;
        mMinrate = 100000;
        mQmax = 31;
        mQmin = 1;
        mMaxQdiff = 3;
        mRefframe = 1;
        mIsSmooth = 1;
        mRecordTime = 1000;
        mRecordFrames = 1;
        mGopSize = 300;
        mIFrameInterval = 10;
        mCRFValue = 23;
        mAdjustSpecialSpeed = 1;
        mEnableTotalTimeAdjust = 0;
        mEnableTimestampFix = 0;
        mAudioTimestampLow = 0;
        mAudioTimestampHigh = 0;
        mAudioTimeRatio = 65537;
        mSaveMode = 0;
        mBitrateMode = 0;
        mEnableBaseLineMp4 = 0;
    }

    public CodecParam() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public static int[] getConfigParam() {
        if (VideoEnvironment.getAVCodecSupportFeature(5)) {
            return new int[]{mMaxrate, mMinrate, mQmax, mQmin, mMaxQdiff, mRefframe, mIsSmooth, mRecordTime, mRecordFrames, mEnableTotalTimeAdjust, mEnableTimestampFix, mAudioTimestampLow, mAudioTimestampHigh, mAudioTimeRatio, mEnableBaseLineMp4, mSaveMode, mBitrateMode, mGopSize, mCRFValue, mAdjustSpecialSpeed};
        }
        return new int[]{mMaxrate, mMinrate, mQmax, mQmin, mMaxQdiff, mRefframe, mIsSmooth, mRecordTime, mRecordFrames};
    }

    public static void initFixTimestampSwitch() {
        mEnableTimestampFix = 0;
        mAudioTimestampLow = 0;
        mAudioTimestampHigh = 0;
        mAudioTimeRatio = 65537;
    }

    public static void setEnableBaseLineMp4Flag(boolean z16) {
        mEnableBaseLineMp4 = 0;
        if (z16) {
            mEnableBaseLineMp4 = 1;
        }
    }
}

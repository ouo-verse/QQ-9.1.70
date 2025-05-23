package com.tencent.tav.decoder;

import androidx.annotation.Nullable;
import com.tencent.tav.coremedia.CMSampleState;
import com.tencent.tav.coremedia.CMTime;
import com.tencent.tav.coremedia.CMTimeRange;
import java.util.HashMap;

/* compiled from: P */
/* loaded from: classes26.dex */
public interface IDecoder {
    public static final String EXTRA_INFO_KEY_DECODE_INFO = "extra_info_key_decode_info";
    public static final long SAMPLE_STATE_ERROR = -3;
    public static final long SAMPLE_STATE_FAILED = -2;
    public static final long SAMPLE_STATE_FINISH = -1;
    public static final long SAMPLE_STATE_TIMEOUT = -4;
    public static final long SAMPLE_STATE_UN_START = -100;

    /* compiled from: P */
    /* loaded from: classes26.dex */
    public enum DecodeType {
        Video,
        Audio
    }

    /* compiled from: P */
    /* loaded from: classes26.dex */
    public static class Params {
        public HashMap<String, Object> extraInfo;
        public String filePath;
        public int sourceType;

        public String toString() {
            return "Params{sourceType=" + this.sourceType + ", filePath='" + this.filePath + "', extraInfo=" + this.extraInfo + '}';
        }
    }

    String getSourcePath();

    boolean hasTrack();

    CMSampleState readSample(CMTime cMTime);

    void seekTo(CMTime cMTime);

    void start(@Nullable CMTimeRange cMTimeRange);

    void start(CMTimeRange cMTimeRange, CMTime cMTime);
}

package com.google.android.exoplayer2.ext.mediaplayer;

import com.tencent.mobileqq.activity.recent.MsgSummary;

/* compiled from: P */
/* loaded from: classes2.dex */
public class DecoderInfo {
    public static final int TYPE_AUDIO = 1;
    public static final int TYPE_UNKNOWN = -1;
    public static final int TYPE_VIDEO = 0;
    public String decoderName;
    public int decoderType;
    public long initializationDurationMs;

    /* JADX INFO: Access modifiers changed from: package-private */
    public DecoderInfo(int i3, String str, long j3) {
        this.decoderType = i3;
        this.decoderName = str;
        this.initializationDurationMs = j3;
    }

    private String type2Str(int i3) {
        if (i3 != 0) {
            if (i3 != 1) {
                return "unknown";
            }
            return "adec";
        }
        return "vdec";
    }

    public String toString() {
        return type2Str(this.decoderType) + MsgSummary.STR_COLON + this.decoderName + "," + this.initializationDurationMs;
    }
}

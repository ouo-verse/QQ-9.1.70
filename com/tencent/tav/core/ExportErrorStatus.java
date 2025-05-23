package com.tencent.tav.core;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.tav.coremedia.CMSampleState;

/* compiled from: P */
/* loaded from: classes26.dex */
public class ExportErrorStatus {
    public static final int APPEND_BUFFER = -110;
    public static final int APPEND_VIDEO_SAMPLE_MAKE_CURRENT = -111;
    public static final int APPEND_VIDEO_SAMPLE_SWAP_BUFFERS = -113;
    public static final int AUDIO_CONFIGURE = -104;
    public static final int AUDIO_ENCODER_ASYNC = -105;
    public static final int END_WRITE_AUDIO_SAMPLE = -124;
    public static final int END_WRITE_VIDEO_SAMPLE = -123;
    public static final int ERROR_CODE_AUDIO_EXPORTING = -15;
    public static final int ERROR_CODE_VIDEO_EXPORTING = -14;
    public static final int ERROR_FINISHING = -10;
    public static final int EXPORT_CANCEL = -11;
    public static final int RENDER_SAMPLE_BUFFER = -112;
    public static final int START_AUDIO_ENCODER = -102;
    public static final int START_VIDEO_ENCODER = -101;
    public static final int STOP_AUDIO_ENCODE = -133;
    public static final int STOP_MUXER = -131;
    public static final int STOP_VIDEO_ENCODE = -132;
    public static final int VIDEO_CONFIGURE = -103;
    public static final int VIDEO_DECODER_CONFIGURE = -1031;
    public static final int WRITE_AUDIO_SAMPLE = -122;
    public static final int WRITE_VIDEO_SAMPLE = -121;
    public static final int WRITE_VIDEO_SAMPLE_ERROR_INSUFFICIENT_RESOURCE = -1211100;
    public static final int WRITE_VIDEO_SAMPLE_ERROR_RECLAIMED = -1211101;
    public int code;

    /* renamed from: msg, reason: collision with root package name */
    public String f374239msg;
    public Throwable throwable;

    public ExportErrorStatus(int i3) {
        this(i3, null);
    }

    public void appendMsg(String str) {
        this.f374239msg += str + ";\n";
    }

    public ExportErrorStatus(int i3, @Nullable Throwable th5) {
        this(i3, th5, null);
    }

    public ExportErrorStatus(@NonNull CMSampleState cMSampleState) {
        this((int) cMSampleState.getStateCode(), cMSampleState.getThrowable(), cMSampleState.getMsg());
    }

    public ExportErrorStatus(int i3, Throwable th5, String str) {
        this.f374239msg = "";
        this.code = i3;
        this.throwable = th5;
        appendMsg(str);
    }
}

package com.tencent.video.decode;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes27.dex */
public class AVDecodeError {
    static IPatchRedirector $redirector_ = null;
    public static final int AUDIO_DATA_DECODE_FINISH = -116;
    public static final int ERR_CODE_BASE = -100;
    public static final int JNI_BITMAP_STRIDE_ERR = -115;
    public static final int JNI_NATIVE_BITMAP_ERR = -113;
    public static final int JNI_NOT_SUPPORT_PIXFMT_ERR = -114;
    public static final int J_AUDIO_FORMAT_ERR = -201;
    public static final int J_SO_LOADED_ERR = -202;
    public static final int J_VIDEO_LINK_ERR = -200;
    public static final int VIDEO_ALLOC_BUFFER_ERR = -105;
    public static final int VIDEO_DECODE_A_ERR = -109;
    public static final int VIDEO_DECODE_V_ERR = -108;
    public static final int VIDEO_FILE_EOF_ERR = -110;
    public static final int VIDEO_FIND_DECODER_ERR = -103;
    public static final int VIDEO_FIND_STREAM_ERR = -112;
    public static final int VIDEO_NO_MEDIA_DATA_ERR = -106;
    public static final int VIDEO_NO_MEM_ERR = -107;
    public static final int VIDEO_OK = 0;
    public static final int VIDEO_OPEN_DECODER_ERR = -104;
    public static final int VIDEO_OPEN_SRC_ERR = -101;
    public static final int VIDEO_PARAM_INVALID_ERR = -111;
    public static final int VIDEO_STREAM_INFO_ERR = -102;

    public AVDecodeError() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public static void throwException(int i3) {
        int i16 = i3 & 65535;
        int i17 = (i3 >> 16) & 65535;
        throw new AVideoException(-i16, i17, "[err=" + i16 + "][subcode=" + i17 + "]");
    }
}

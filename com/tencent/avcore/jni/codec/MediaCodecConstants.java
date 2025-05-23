package com.tencent.avcore.jni.codec;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qfix.redirect.utils.ReflectUtils;

/* compiled from: P */
/* loaded from: classes3.dex */
public interface MediaCodecConstants {
    public static final IPatchRedirector $redirector_ = null;
    public static final String AVC_CODEC_MIME = "video/avc";
    public static final String FILE_NAME_AVC_DECODE_TEST = "bitv.mp4";
    public static final String FILE_NAME_AVC_ENCODE_TEST = "test2Frame.yuv";
    public static final String FORCE_I_FRAME = "request-sync";
    public static final String HEVC_CODEC_MIME = "video/hevc";
    public static final String PREFERENCE_AVC_DECODE_TEST = "hwcodec_avc_decode_test";
    public static final String PREFERENCE_AVC_ENCODE_TEST = "hwcodec_avc_encode_test";
    public static final String REPORT_AVC_DECODE_TEST = "AV_HWCODEC_AVC_DEC";
    public static final String REPORT_AVC_ENCODE_TEST = "AV_HWCODEC_AVC_ENC";
    public static final int SUPPORT_AVC_DEC = 1;
    public static final int SUPPORT_AVC_ENC = 2;
    public static final int SUPPORT_HEVC_DEC = 4;
    public static final int SUPPORT_HEVC_ENC = 8;
    public static final int SUPPORT_NONE = 0;
    public static final int SUPPORT_POWER_COUNTS = 4;
    public static final int[] SUPPORT_POWER_LISTS;

    static {
        ReflectUtils.setStaticField(PatchRedirectCenter.getRedirector(14304), (Class<?>) MediaCodecConstants.class, "$redirector_");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1);
        } else {
            SUPPORT_POWER_LISTS = new int[]{1, 2, 4, 8};
        }
    }
}

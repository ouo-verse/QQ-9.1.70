package com.tencent.qq.effect.engine;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes22.dex */
public class QEffectType {
    static IPatchRedirector $redirector_ = null;
    public static final int APNG = 2;
    public static final String APNG_TAG = "a.png";
    public static final int GIF = 8;
    public static final String GIF_TAG = "gif";
    public static final int GLSL = 7;
    public static final String GLSL_TAG = "glsl";
    public static final int IMAGE = 1;
    public static final String IMAGE_TAG = "png,jpg";
    public static final int LOTTIE = 3;
    public static final String LOTTIE_TAG = "lottie";
    public static final int QEFFECT = 6;
    public static final String QEFFECT_TAG = "zip";
    public static final int VERSION = 1;
    public static final int VIDEO = 4;
    public static final int VIDEO_ALPHA = 5;
    public static final String VIDEO_ALPHA_TAG = "alpha.mp4";
    public static final String VIDEO_TAG = "mp4";
    public static final int WEBP = 9;
    public static final String WEBP_TAG = "webp";

    public QEffectType() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }
}

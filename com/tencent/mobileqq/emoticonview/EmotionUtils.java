package com.tencent.mobileqq.emoticonview;

import android.graphics.drawable.Drawable;
import com.tencent.image.AbstractGifImage;
import com.tencent.image.GifDrawable;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes12.dex */
public class EmotionUtils {
    static IPatchRedirector $redirector_ = null;
    private static final String TAG = "EmotionUtils";

    public EmotionUtils() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public static void startSoundDrawablePlay(URLDrawable uRLDrawable) {
        Drawable currDrawable;
        if (uRLDrawable != null && (currDrawable = uRLDrawable.getCurrDrawable()) != null && (currDrawable instanceof GifDrawable)) {
            AbstractGifImage image = ((GifDrawable) currDrawable).getImage();
            if (image != null && (image instanceof VoiceGifImage)) {
                VoiceGifImage voiceGifImage = (VoiceGifImage) image;
                voiceGifImage.stop();
                voiceGifImage.start();
                uRLDrawable.invalidateSelf();
                if (QLog.isColorLevel()) {
                    QLog.d(TAG, 2, "soundgif startSoundDrawablePlay start");
                    return;
                }
                return;
            }
            if (image != null && (image instanceof VoiceGifImageV2)) {
                VoiceGifImageV2 voiceGifImageV2 = (VoiceGifImageV2) image;
                voiceGifImageV2.stop();
                voiceGifImageV2.start();
                uRLDrawable.invalidateSelf();
                if (QLog.isColorLevel()) {
                    QLog.d(TAG, 2, "soundgif startSoundDrawablePlay start");
                }
            }
        }
    }

    public static void stopSoundDrawablePlay(URLDrawable uRLDrawable) {
        Drawable currDrawable;
        if (uRLDrawable != null && (currDrawable = uRLDrawable.getCurrDrawable()) != null && (currDrawable instanceof GifDrawable)) {
            AbstractGifImage image = ((GifDrawable) currDrawable).getImage();
            if (image != null && (image instanceof VoiceGifImage)) {
                ((VoiceGifImage) image).stop();
                if (QLog.isColorLevel()) {
                    QLog.d(TAG, 2, "soundgif stopSoundDrawablePlay stop");
                    return;
                }
                return;
            }
            if (image != null && (image instanceof VoiceGifImageV2)) {
                ((VoiceGifImageV2) image).stop();
                if (QLog.isColorLevel()) {
                    QLog.d(TAG, 2, "soundgif stopSoundDrawablePlay stop");
                }
            }
        }
    }
}

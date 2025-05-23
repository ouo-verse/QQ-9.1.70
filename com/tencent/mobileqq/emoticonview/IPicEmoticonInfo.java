package com.tencent.mobileqq.emoticonview;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Parcelable;
import android.widget.EditText;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.data.Emoticon;
import com.tencent.mobileqq.emoticon.StickerInfo;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qfix.redirect.utils.ReflectUtils;
import com.tencent.qqmini.sdk.launcher.core.proxy.va.TipsElementData;
import mqq.app.AppRuntime;

/* loaded from: classes12.dex */
public interface IPicEmoticonInfo {
    public static final IPatchRedirector $redirector_ = null;
    public static final int DEFAULT_AUDIO_WAVE_BACKGROUND_COLOR;
    public static final int DEFAULT_AUDIO_WAVE_FOREGROUND_COLOR;
    public static final String ORIGINAL_EMOTION_COUNT_SP_FILE_NAME = "originalEmotionCountSp_";
    public static final int ORIGINAL_EMOTION_REWORD_COUNT = 21;
    public static final int TYPE_GIF = 3;
    public static final int TYPE_PNG = 2;

    static {
        ReflectUtils.setStaticField(PatchRedirectCenter.getRedirector(40807), (Class<?>) IPicEmoticonInfo.class, "$redirector_");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1);
        } else {
            DEFAULT_AUDIO_WAVE_BACKGROUND_COLOR = Color.parseColor("#21d9c6");
            DEFAULT_AUDIO_WAVE_FOREGROUND_COLOR = Color.parseColor(TipsElementData.DEFAULT_COLOR);
        }
    }

    int emoExtHeight();

    int emoExtWidth();

    int emoHeight();

    int emoWidth();

    Drawable getAioPreviewDrawable();

    Drawable getBigDrawable(Context context, float f16);

    Drawable getDefault();

    Drawable getDrawable(Context context, float f16);

    String getEid();

    Emoticon getEmoticon();

    String getEpid();

    Drawable getFailed();

    Drawable getFiveInchDefault();

    Drawable getFiveInchFailed();

    int getImageJobType();

    int getImageType();

    URLDrawable getLoadingDrawable(String str);

    URLDrawable getLoadingDrawable(String str, boolean z16);

    <T> URLDrawable getLoadingDrawable(String str, boolean z16, boolean z17, T t16);

    <T> URLDrawable getLoadingDrawable(String str, boolean z16, boolean z17, T t16, int i3, int i16);

    int getVoiceLength();

    int getWaveBackgroundColor();

    int getWaveForegroundColor();

    int[] getWaveformArray();

    boolean isAPNG();

    boolean isAioPreviewExists();

    boolean isBigImageExists();

    boolean isNewSoundType();

    boolean isSound();

    void send(AppRuntime appRuntime, Context context, EditText editText, Parcelable parcelable);

    void send(AppRuntime appRuntime, Context context, EditText editText, Parcelable parcelable, boolean z16, int i3);

    void sendFromGuild(AppRuntime appRuntime, Context context, Parcelable parcelable);

    void setEmoticon(Emoticon emoticon);

    void setStickerInfo(StickerInfo stickerInfo);
}

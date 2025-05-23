package androidx.media;

import android.media.AudioFocusRequest;
import android.media.AudioManager;
import android.os.Build;
import androidx.annotation.DoNotInline;
import androidx.annotation.IntRange;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;

/* compiled from: P */
/* loaded from: classes.dex */
public final class AudioManagerCompat {
    public static final int AUDIOFOCUS_GAIN = 1;
    public static final int AUDIOFOCUS_GAIN_TRANSIENT = 2;
    public static final int AUDIOFOCUS_GAIN_TRANSIENT_EXCLUSIVE = 4;
    public static final int AUDIOFOCUS_GAIN_TRANSIENT_MAY_DUCK = 3;
    private static final String TAG = "AudioManCompat";

    /* compiled from: P */
    @RequiresApi(21)
    /* loaded from: classes.dex */
    private static class Api21Impl {
        Api21Impl() {
        }

        @DoNotInline
        static boolean isVolumeFixed(AudioManager audioManager) {
            return audioManager.isVolumeFixed();
        }
    }

    /* compiled from: P */
    @RequiresApi(26)
    /* loaded from: classes.dex */
    private static class Api26Impl {
        Api26Impl() {
        }

        @DoNotInline
        static int abandonAudioFocusRequest(AudioManager audioManager, AudioFocusRequest audioFocusRequest) {
            int abandonAudioFocusRequest;
            abandonAudioFocusRequest = audioManager.abandonAudioFocusRequest(audioFocusRequest);
            return abandonAudioFocusRequest;
        }

        @DoNotInline
        static int requestAudioFocus(AudioManager audioManager, AudioFocusRequest audioFocusRequest) {
            int requestAudioFocus;
            requestAudioFocus = audioManager.requestAudioFocus(audioFocusRequest);
            return requestAudioFocus;
        }
    }

    /* compiled from: P */
    @RequiresApi(28)
    /* loaded from: classes.dex */
    private static class Api28Impl {
        Api28Impl() {
        }

        @DoNotInline
        static int getStreamMinVolume(AudioManager audioManager, int i3) {
            int streamMinVolume;
            streamMinVolume = audioManager.getStreamMinVolume(i3);
            return streamMinVolume;
        }
    }

    AudioManagerCompat() {
    }

    public static int abandonAudioFocusRequest(@NonNull AudioManager audioManager, @NonNull AudioFocusRequestCompat audioFocusRequestCompat) {
        if (audioManager != null) {
            if (audioFocusRequestCompat != null) {
                if (Build.VERSION.SDK_INT >= 26) {
                    return Api26Impl.abandonAudioFocusRequest(audioManager, audioFocusRequestCompat.getAudioFocusRequest());
                }
                return audioManager.abandonAudioFocus(audioFocusRequestCompat.getOnAudioFocusChangeListener());
            }
            throw new IllegalArgumentException("AudioFocusRequestCompat must not be null");
        }
        throw new IllegalArgumentException("AudioManager must not be null");
    }

    @IntRange(from = 0)
    public static int getStreamMaxVolume(@NonNull AudioManager audioManager, int i3) {
        return audioManager.getStreamMaxVolume(i3);
    }

    @IntRange(from = 0)
    public static int getStreamMinVolume(@NonNull AudioManager audioManager, int i3) {
        if (Build.VERSION.SDK_INT >= 28) {
            return Api28Impl.getStreamMinVolume(audioManager, i3);
        }
        return 0;
    }

    public static boolean isVolumeFixed(@NonNull AudioManager audioManager) {
        return Api21Impl.isVolumeFixed(audioManager);
    }

    public static int requestAudioFocus(@NonNull AudioManager audioManager, @NonNull AudioFocusRequestCompat audioFocusRequestCompat) {
        if (audioManager != null) {
            if (audioFocusRequestCompat != null) {
                if (Build.VERSION.SDK_INT >= 26) {
                    return Api26Impl.requestAudioFocus(audioManager, audioFocusRequestCompat.getAudioFocusRequest());
                }
                return audioManager.requestAudioFocus(audioFocusRequestCompat.getOnAudioFocusChangeListener(), audioFocusRequestCompat.getAudioAttributesCompat().getLegacyStreamType(), audioFocusRequestCompat.getFocusGain());
            }
            throw new IllegalArgumentException("AudioFocusRequestCompat must not be null");
        }
        throw new IllegalArgumentException("AudioManager must not be null");
    }
}

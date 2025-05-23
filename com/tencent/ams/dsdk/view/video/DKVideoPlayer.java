package com.tencent.ams.dsdk.view.video;

import android.view.View;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public interface DKVideoPlayer {

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* loaded from: classes3.dex */
    public static final class ObjectFit {
        private static final /* synthetic */ ObjectFit[] $VALUES;
        static IPatchRedirector $redirector_;
        public static final ObjectFit CONTAIN;
        public static final ObjectFit COVER;
        public static final ObjectFit FILL;

        static {
            IPatchRedirector redirector = PatchRedirectCenter.getRedirector(21511);
            $redirector_ = redirector;
            if (redirector != null && redirector.hasPatch((short) 2)) {
                redirector.redirect((short) 2);
                return;
            }
            ObjectFit objectFit = new ObjectFit("FILL", 0);
            FILL = objectFit;
            ObjectFit objectFit2 = new ObjectFit("CONTAIN", 1);
            CONTAIN = objectFit2;
            ObjectFit objectFit3 = new ObjectFit("COVER", 2);
            COVER = objectFit3;
            $VALUES = new ObjectFit[]{objectFit, objectFit2, objectFit3};
        }

        ObjectFit(String str, int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) str, i3);
            }
        }

        public static ObjectFit valueOf(String str) {
            return (ObjectFit) Enum.valueOf(ObjectFit.class, str);
        }

        public static ObjectFit[] values() {
            return (ObjectFit[]) $VALUES.clone();
        }
    }

    /* loaded from: classes3.dex */
    public interface OnVideoPlayListener {
        void onEnded();

        void onError(int i3, String str);

        void onPause();

        void onPlay();

        void onReady();

        void onSeeked(int i3);

        void onSeeking(int i3);

        void onTimeUpdate(int i3, int i16);

        void onVolumeChange(float f16);

        void onWaiting();
    }

    int getCurrentPosition();

    int getDuration();

    View getView();

    boolean isPlaying();

    void onDestroy();

    void pause();

    void seekTo(int i3);

    void setAutoPlay(boolean z16);

    void setLoop(boolean z16);

    void setMute(boolean z16);

    void setObjectFit(ObjectFit objectFit);

    void setVid(String str);

    void setVideoParams(JSONObject jSONObject);

    void setVideoPath(String str);

    void setVideoPlayListener(OnVideoPlayListener onVideoPlayListener);

    void setVolume(float f16);

    void start();

    void stop();
}

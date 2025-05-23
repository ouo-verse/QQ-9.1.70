package com.tencent.ams.xsad.rewarded.player;

import android.content.Context;
import android.content.res.Configuration;
import android.view.ViewGroup;
import com.tencent.ams.xsad.rewarded.RewardedAdData;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.Locale;
import java.util.Map;

/* loaded from: classes3.dex */
public interface RewardedAdPlayer {

    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes3.dex */
    public @interface PlayFailReason {
        public static final int VIDEO_FAIL_REASON_CONNECT = 2;
        public static final int VIDEO_FAIL_REASON_NO_NETWORK = 1;
        public static final int VIDEO_FAIL_REASON_SDK = 3;
    }

    /* loaded from: classes3.dex */
    public interface a {
        void a();

        void l1(int i3);

        void onPlayStart();
    }

    /* loaded from: classes3.dex */
    public static class b {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        public String f71841a;

        /* renamed from: b, reason: collision with root package name */
        public Map<String, Object> f71842b;

        public b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }

        public static b a(RewardedAdData rewardedAdData) {
            b bVar = new b();
            bVar.f71841a = rewardedAdData.f71691e;
            bVar.f71842b = rewardedAdData.f71702p;
            return bVar;
        }

        public String toString() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return (String) iPatchRedirector.redirect((short) 3, (Object) this);
            }
            return String.format(Locale.getDefault(), "url:%s;", this.f71841a);
        }
    }

    void a(boolean z16);

    void b(Context context, ViewGroup viewGroup);

    void c(b bVar);

    void d(a aVar);

    int getCurrentPosition();

    int getDuration();

    boolean isPlaying();

    void onActivityPause();

    void onActivityResume();

    void onConfigurationChanged(Configuration configuration);

    void pause();

    void seekTo(long j3);

    void setAutoPlay(boolean z16);

    void setOutputMute(boolean z16);

    void start();

    void stop();
}

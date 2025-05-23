package com.tencent.ams.xsad.rewarded;

import android.view.View;
import com.tencent.ams.xsad.rewarded.event.ModuleEvent;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes3.dex */
public interface RewardedAdListener {
    public static final IPatchRedirector $redirector_ = null;

    /* compiled from: P */
    /* loaded from: classes3.dex */
    public static class ClickInfo {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        public int f71716a;

        /* renamed from: b, reason: collision with root package name */
        public float f71717b;

        /* renamed from: c, reason: collision with root package name */
        public float f71718c;

        /* renamed from: d, reason: collision with root package name */
        public float f71719d;

        /* renamed from: e, reason: collision with root package name */
        public float f71720e;

        /* renamed from: f, reason: collision with root package name */
        public View f71721f;

        /* renamed from: g, reason: collision with root package name */
        public JSONObject f71722g;

        /* compiled from: P */
        @Retention(RetentionPolicy.SOURCE)
        /* loaded from: classes3.dex */
        public @interface ClickArea {
            public static final int AUTO_OPEN = 12;
            public static final int BANNER_ACTION_BUTTON = 4;
            public static final int BANNER_EMPTY = 5;
            public static final int BANNER_ICON = 1;
            public static final int BANNER_SUB_TITLE = 3;
            public static final int BANNER_TITLE = 2;
            public static final int END_ACTION_BUTTON = 9;
            public static final int END_EMPTY = 10;
            public static final int END_ICON = 6;
            public static final int END_SUB_TITLE = 8;
            public static final int END_TITLE = 7;
            public static final int HALF_SCREEN = 14;
            public static final int PLAYING_EMPTY = 11;
            public static final int VIP_BUTTON = 13;
        }

        public ClickInfo() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes3.dex */
    public static class a {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        public RewardedAdError f71723a;

        /* renamed from: b, reason: collision with root package name */
        public RewardedAdData f71724b;

        public a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }

        public String toString() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (String) iPatchRedirector.redirect((short) 2, (Object) this);
            }
            return "RewardedAdResponse{error=" + this.f71723a + "', data=" + this.f71724b + '}';
        }
    }

    /* compiled from: P */
    /* loaded from: classes3.dex */
    public interface b {
        void a(a aVar);
    }

    void A1(com.tencent.ams.xsad.rewarded.view.a aVar, JSONObject jSONObject);

    void Ab(ClickInfo clickInfo);

    void D2();

    void J1(boolean z16);

    void K6(ModuleEvent moduleEvent);

    void L7(RewardedAdError rewardedAdError);

    void Od(int i3);

    void S7(com.tencent.ams.xsad.rewarded.view.a aVar);

    void a5();

    void gb(com.tencent.ams.xsad.rewarded.view.a aVar, boolean z16);

    void jb(long j3);

    void m6(int i3, b bVar);

    void onAdPlayComplete();

    void onAdPlayPause();

    void onAdPlayResume();

    void onAdPlayStart();

    void onOriginalExposure();

    void we();

    void yg(com.tencent.ams.xsad.rewarded.b bVar);
}

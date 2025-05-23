package com.tencent.ams.xsad.rewarded;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes3.dex */
public class RewardedAdData {
    static IPatchRedirector $redirector_;

    @RewardType
    public int A;
    public String B;
    public boolean C;

    /* renamed from: a, reason: collision with root package name */
    public Object f71687a;

    /* renamed from: b, reason: collision with root package name */
    public boolean f71688b;

    /* renamed from: c, reason: collision with root package name */
    public int f71689c;

    /* renamed from: d, reason: collision with root package name */
    public int f71690d;

    /* renamed from: e, reason: collision with root package name */
    public String f71691e;

    /* renamed from: f, reason: collision with root package name */
    public String f71692f;

    /* renamed from: g, reason: collision with root package name */
    public int f71693g;

    /* renamed from: h, reason: collision with root package name */
    public String f71694h;

    /* renamed from: i, reason: collision with root package name */
    public String f71695i;

    /* renamed from: j, reason: collision with root package name */
    public String f71696j;

    /* renamed from: k, reason: collision with root package name */
    public String f71697k;

    /* renamed from: l, reason: collision with root package name */
    public String f71698l;

    /* renamed from: m, reason: collision with root package name */
    public String f71699m;

    /* renamed from: n, reason: collision with root package name */
    public String f71700n;

    /* renamed from: o, reason: collision with root package name */
    public String f71701o;

    /* renamed from: p, reason: collision with root package name */
    public Map<String, Object> f71702p;

    /* renamed from: q, reason: collision with root package name */
    public String f71703q;

    /* renamed from: r, reason: collision with root package name */
    public Map<String, String> f71704r;

    /* renamed from: s, reason: collision with root package name */
    public String f71705s;

    /* renamed from: t, reason: collision with root package name */
    public int f71706t;

    /* renamed from: u, reason: collision with root package name */
    public int f71707u;

    /* renamed from: v, reason: collision with root package name */
    public String f71708v;

    /* renamed from: w, reason: collision with root package name */
    public int f71709w;

    /* renamed from: x, reason: collision with root package name */
    public int f71710x;

    /* renamed from: y, reason: collision with root package name */
    public String f71711y;

    /* renamed from: z, reason: collision with root package name */
    @DisplayType
    public int f71712z;

    /* compiled from: P */
    /* loaded from: classes3.dex */
    public @interface DisplayType {
        public static final int BROWSE = 1;
        public static final int IMAGE = 3;
        public static final int VIDEO = 0;
    }

    /* compiled from: P */
    /* loaded from: classes3.dex */
    public @interface RewardType {
        public static final int COUNTDOWN_CLICK = 2;
        public static final int DEFAULT = 0;
        public static final int DOWNLOAD = 1;
        public static final int NONE = -1;
    }

    public RewardedAdData() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.f71689c = 0;
        }
    }
}

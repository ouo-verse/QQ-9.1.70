package com.tencent.lyric.data;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes9.dex */
public class b {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    public final long f147062a;

    /* renamed from: b, reason: collision with root package name */
    public final long f147063b;

    /* renamed from: c, reason: collision with root package name */
    public final int f147064c;

    /* renamed from: d, reason: collision with root package name */
    public final int f147065d;

    public b(long j3, long j16, int i3, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, Long.valueOf(j3), Long.valueOf(j16), Integer.valueOf(i3), Integer.valueOf(i16));
            return;
        }
        this.f147062a = j3;
        this.f147063b = j16;
        this.f147064c = i3;
        this.f147065d = i16;
    }

    public String toString() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (String) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        StringBuilder sb5 = new StringBuilder("LyricCharacter -> ");
        sb5.append("mStartTime:" + this.f147062a);
        sb5.append(", mDuration:" + this.f147063b);
        sb5.append(", mStart:" + this.f147064c);
        sb5.append(", mEnd:" + this.f147065d);
        return sb5.toString();
    }
}

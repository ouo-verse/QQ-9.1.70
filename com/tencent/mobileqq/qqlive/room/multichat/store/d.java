package com.tencent.mobileqq.qqlive.room.multichat.store;

import androidx.annotation.NonNull;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.now.od.logic.app.multiavchat.consts.MultiAvChatUserType;

/* compiled from: P */
/* loaded from: classes17.dex */
public class d {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    public long f271669a;

    /* renamed from: b, reason: collision with root package name */
    public long f271670b;

    /* renamed from: c, reason: collision with root package name */
    public int f271671c;

    /* renamed from: d, reason: collision with root package name */
    public String f271672d;

    /* renamed from: e, reason: collision with root package name */
    public String f271673e;

    /* renamed from: f, reason: collision with root package name */
    public int f271674f;

    /* renamed from: g, reason: collision with root package name */
    public String f271675g;

    /* renamed from: h, reason: collision with root package name */
    public boolean f271676h;

    /* renamed from: i, reason: collision with root package name */
    @MultiAvChatUserType
    public int f271677i;

    /* renamed from: j, reason: collision with root package name */
    public long f271678j;

    /* renamed from: k, reason: collision with root package name */
    public int f271679k;

    /* renamed from: l, reason: collision with root package name */
    public int f271680l;

    /* renamed from: m, reason: collision with root package name */
    public boolean f271681m;

    public d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.f271671c = -1;
        this.f271677i = 0;
        this.f271679k = -1;
    }

    @NonNull
    public String toString() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (String) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return "UserInfo{roomId=" + this.f271669a + ", uid=" + this.f271670b + ", nickName=" + this.f271673e + ", seatNo=" + this.f271671c + ", seatName=" + this.f271675g + ", headUrl=" + this.f271672d + ", score=" + this.f271674f + ", userType=" + this.f271677i + ", isInvited=" + this.f271676h + ", applyLinkMicTimeStamp=" + this.f271678j + ", applySeatNo=" + this.f271679k + ", clientType=" + this.f271680l + ", isHasGoldFrame=" + this.f271681m + "}";
    }
}

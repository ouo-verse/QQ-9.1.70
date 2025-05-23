package com.tencent.mobileqq.qqlive.room.multichat.store;

import androidx.annotation.NonNull;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.now.od.logic.app.multiavchat.consts.MultiAvChatType;
import java.util.HashMap;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes17.dex */
public class e {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    public long f271682a;

    /* renamed from: b, reason: collision with root package name */
    public Map<Long, d> f271683b;

    /* renamed from: c, reason: collision with root package name */
    public Map<Integer, String> f271684c;

    /* renamed from: d, reason: collision with root package name */
    public String f271685d;

    /* renamed from: e, reason: collision with root package name */
    @MultiAvChatType
    public int f271686e;

    /* renamed from: f, reason: collision with root package name */
    public boolean f271687f;

    /* renamed from: g, reason: collision with root package name */
    public boolean f271688g;

    /* renamed from: h, reason: collision with root package name */
    public boolean f271689h;

    /* renamed from: i, reason: collision with root package name */
    public int f271690i;

    public e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.f271683b = new HashMap();
        this.f271684c = new HashMap();
        this.f271686e = 0;
        this.f271687f = true;
        this.f271688g = true;
        this.f271689h = true;
        this.f271690i = 0;
        for (int i3 = 0; i3 < 9; i3++) {
            this.f271684c.put(Integer.valueOf(i3), "");
        }
    }

    public d a(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (d) iPatchRedirector.redirect((short) 6, (Object) this, i3);
        }
        for (d dVar : this.f271683b.values()) {
            if (dVar != null && i3 == dVar.f271671c) {
                return dVar;
            }
        }
        return null;
    }

    @NonNull
    public String toString() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return (String) iPatchRedirector.redirect((short) 8, (Object) this);
        }
        return "SeatUserInfoStore{roomId=" + this.f271682a + ", programSeq=" + this.f271685d + ", seq=" + this.f271690i + ", multiAvChatType=" + this.f271686e + ", isCanOpenCamera=" + this.f271687f + ", isNeedApproveWhenLinkMic=" + this.f271688g + ", isCanSendGift2VipUser=" + this.f271689h + ", userInfoMap=" + this.f271683b.toString() + ", seatNoAndNameMap=" + this.f271684c.toString() + "}";
    }
}

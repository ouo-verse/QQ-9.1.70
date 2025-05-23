package com.tencent.mobileqq.activity.photo.album;

import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.activity.photo.PhotoSendParams;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.util.HashMap;

/* compiled from: P */
/* loaded from: classes10.dex */
public class g extends com.tencent.mobileqq.activity.photo.album.photolist.e {
    static IPatchRedirector $redirector_;
    public boolean A;
    public HashMap<String, byte[]> B;
    public String C;
    public String D;
    public boolean E;
    public boolean F;
    public boolean G;
    public int H;
    public String I;
    public String J;
    public boolean K;
    public boolean L;
    public long M;
    public HashMap<LocalMediaInfo, LocalMediaInfo> N;
    public boolean O;
    public b P;
    k Q;

    /* renamed from: v, reason: collision with root package name */
    public boolean f184241v;

    /* renamed from: w, reason: collision with root package name */
    public HashMap<String, PhotoSendParams> f184242w;

    /* renamed from: x, reason: collision with root package name */
    public boolean f184243x;

    /* renamed from: y, reason: collision with root package name */
    public boolean f184244y;

    /* renamed from: z, reason: collision with root package name */
    public boolean f184245z;

    public g() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.f184241v = false;
        this.f184244y = false;
        this.f184245z = true;
        this.A = false;
        this.E = false;
        this.F = false;
        this.K = false;
        this.L = false;
        this.M = -1L;
        this.N = new HashMap<>();
        this.O = false;
    }
}

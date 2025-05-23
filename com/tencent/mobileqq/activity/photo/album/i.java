package com.tencent.mobileqq.activity.photo.album;

import NS_MOBILE_OPERATION.PicInfo;
import com.tencent.mobileqq.activity.photo.PhotoSendParams;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.util.HashMap;

/* compiled from: P */
/* loaded from: classes10.dex */
public class i extends com.tencent.mobileqq.activity.photo.album.preview.d {
    static IPatchRedirector $redirector_;
    public boolean A;
    public boolean B;
    public boolean C;
    public boolean D;
    public int E;
    public boolean F;
    public int G;

    /* renamed from: k, reason: collision with root package name */
    public HashMap<String, PhotoSendParams> f184252k;

    /* renamed from: l, reason: collision with root package name */
    public HashMap<String, PhotoSendParams> f184253l;

    /* renamed from: m, reason: collision with root package name */
    public HashMap<String, PicInfo> f184254m;

    /* renamed from: n, reason: collision with root package name */
    public HashMap<String, PicInfo> f184255n;

    /* renamed from: o, reason: collision with root package name */
    public boolean f184256o;

    /* renamed from: p, reason: collision with root package name */
    public boolean f184257p;

    /* renamed from: q, reason: collision with root package name */
    public boolean f184258q;

    /* renamed from: r, reason: collision with root package name */
    public boolean f184259r;

    /* renamed from: s, reason: collision with root package name */
    public boolean f184260s;

    /* renamed from: t, reason: collision with root package name */
    public int f184261t;

    /* renamed from: u, reason: collision with root package name */
    public boolean f184262u;

    /* renamed from: v, reason: collision with root package name */
    public boolean f184263v;

    /* renamed from: w, reason: collision with root package name */
    public String f184264w;

    /* renamed from: x, reason: collision with root package name */
    public HashMap<String, byte[]> f184265x;

    /* renamed from: y, reason: collision with root package name */
    public String f184266y;

    /* renamed from: z, reason: collision with root package name */
    public String f184267z;

    public i() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.f184258q = false;
        this.f184262u = false;
        this.f184263v = false;
        this.G = 0;
    }
}

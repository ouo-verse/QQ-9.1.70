package com.tencent.mobileqq.activity.photo.album.preview;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.util.ArrayList;
import java.util.HashMap;

/* compiled from: P */
/* loaded from: classes10.dex */
public class d {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    public boolean f184323a;

    /* renamed from: b, reason: collision with root package name */
    public ArrayList<String> f184324b;

    /* renamed from: c, reason: collision with root package name */
    public HashMap<String, String> f184325c;

    /* renamed from: d, reason: collision with root package name */
    public String f184326d;

    /* renamed from: e, reason: collision with root package name */
    public boolean f184327e;

    /* renamed from: f, reason: collision with root package name */
    public long f184328f;

    /* renamed from: g, reason: collision with root package name */
    public int f184329g;

    /* renamed from: h, reason: collision with root package name */
    public int f184330h;

    /* renamed from: i, reason: collision with root package name */
    public boolean f184331i;

    /* renamed from: j, reason: collision with root package name */
    public int f184332j;

    public d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.f184323a = true;
        this.f184325c = new HashMap<>();
        this.f184327e = false;
        this.f184329g = 0;
        this.f184331i = false;
    }
}

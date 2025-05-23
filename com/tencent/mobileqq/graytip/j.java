package com.tencent.mobileqq.graytip;

import com.tencent.mobileqq.graytip.UniteEntity;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes12.dex */
public class j {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    private int f213703a;

    /* renamed from: b, reason: collision with root package name */
    private String f213704b;

    /* renamed from: c, reason: collision with root package name */
    private UniteEntity.Note f213705c;

    public j(int i3, String str, UniteEntity.Note note) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, Integer.valueOf(i3), str, note);
            return;
        }
        this.f213703a = i3;
        this.f213704b = str;
        this.f213705c = note;
    }
}

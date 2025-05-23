package com.tencent.mobileqq.activity.qqsettingme.bean;

import android.graphics.drawable.Drawable;
import com.tencent.mobileqq.nearby.redtouch.RedTouchItem;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import tencent.im.oidb.redInfo$RedInfo;

/* compiled from: P */
/* loaded from: classes10.dex */
public class j {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    public boolean f184915a;

    /* renamed from: b, reason: collision with root package name */
    public int f184916b;

    /* renamed from: c, reason: collision with root package name */
    public redInfo$RedInfo f184917c;

    /* renamed from: d, reason: collision with root package name */
    public RedTouchItem f184918d;

    /* renamed from: e, reason: collision with root package name */
    public Drawable f184919e;

    public j() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }
}

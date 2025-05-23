package com.tencent.mobileqq.activity.aio.voicetextpanel.ui.viewhelper;

import android.content.Context;
import com.tencent.mobileqq.activity.aio.voicetextpanel.ui.VoiceTextPanel;
import mqq.app.AppRuntime;

/* compiled from: P */
/* loaded from: classes10.dex */
public abstract class a {

    /* renamed from: d, reason: collision with root package name */
    protected AppRuntime f180224d;

    /* renamed from: e, reason: collision with root package name */
    protected Context f180225e;

    /* renamed from: f, reason: collision with root package name */
    protected d71.c f180226f;

    /* renamed from: h, reason: collision with root package name */
    protected c71.c f180227h;

    public a(AppRuntime appRuntime, d71.c cVar) {
        this.f180224d = appRuntime;
        this.f180226f = cVar;
    }

    public d71.b b() {
        return this.f180226f.b();
    }

    public d71.d c() {
        return this.f180226f.c();
    }

    public d71.e d() {
        return this.f180226f.d();
    }

    public void e(c71.c cVar) {
        this.f180227h = cVar;
    }

    public void f(VoiceTextPanel voiceTextPanel) {
        this.f180225e = voiceTextPanel.getContext();
    }

    public void g() {
        this.f180227h = null;
    }
}

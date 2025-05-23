package com.tencent.mobileqq.activity.aio.voicetextpanel.ui.viewhelper;

import android.view.ViewGroup;
import com.tencent.mobileqq.activity.aio.voicetextpanel.ui.VoiceTextPanel;

/* compiled from: P */
/* loaded from: classes10.dex */
public class c {

    /* renamed from: a, reason: collision with root package name */
    private int f180233a;

    /* renamed from: b, reason: collision with root package name */
    protected ViewGroup f180234b;

    /* renamed from: c, reason: collision with root package name */
    private VoiceTextPanel f180235c;

    /* renamed from: d, reason: collision with root package name */
    private ViewGroup f180236d;

    /* renamed from: e, reason: collision with root package name */
    private a61.b f180237e;

    public int a() {
        return this.f180233a;
    }

    public void b(ViewGroup viewGroup, VoiceTextPanel voiceTextPanel, ViewGroup viewGroup2, a61.b bVar) {
        this.f180234b = viewGroup;
        this.f180235c = voiceTextPanel;
        this.f180236d = viewGroup2;
        this.f180237e = bVar;
    }

    public void c() {
        int i3 = this.f180233a;
        if (i3 == 1) {
            this.f180237e.c().f(2, false);
        } else if (i3 == 2) {
            this.f180237e.c().c(true);
        }
    }

    public void d() {
        this.f180233a = 0;
    }

    public void e(int i3) {
        this.f180233a = i3;
    }
}

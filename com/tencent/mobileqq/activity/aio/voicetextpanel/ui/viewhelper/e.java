package com.tencent.mobileqq.activity.aio.voicetextpanel.ui.viewhelper;

import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.aio.voicetextpanel.ui.VoiceTextPanel;
import com.tencent.mobileqq.activity.aio.voicetextpanel.ui.VoiceTextPttPlayView;
import com.tencent.mobileqq.utils.RecordParams;

/* compiled from: P */
/* loaded from: classes10.dex */
public class e {

    /* renamed from: a, reason: collision with root package name */
    private VoiceTextPttPlayView f180243a;

    /* renamed from: b, reason: collision with root package name */
    private TextView f180244b;

    /* renamed from: c, reason: collision with root package name */
    private LinearLayout f180245c;

    public void a() {
        this.f180245c.setVisibility(8);
        this.f180244b.setVisibility(0);
    }

    public void b(String str, RecordParams.RecorderParam recorderParam, int i3, VoiceTextPanel voiceTextPanel) {
        VoiceTextPttPlayView voiceTextPttPlayView = this.f180243a;
        if (voiceTextPttPlayView != null) {
            voiceTextPttPlayView.setDuration(i3, str, recorderParam, voiceTextPanel);
        }
    }

    public void c(VoiceTextPanel voiceTextPanel) {
        this.f180244b = (TextView) voiceTextPanel.findViewById(R.id.dtq);
        this.f180245c = (LinearLayout) voiceTextPanel.findViewById(R.id.elq);
        this.f180243a = (VoiceTextPttPlayView) voiceTextPanel.findViewById(R.id.f166892m93);
    }

    public void d() {
        VoiceTextPttPlayView voiceTextPttPlayView = this.f180243a;
        if (voiceTextPttPlayView != null) {
            voiceTextPttPlayView.j();
        }
    }

    public void e() {
        VoiceTextPttPlayView voiceTextPttPlayView = this.f180243a;
        if (voiceTextPttPlayView != null) {
            voiceTextPttPlayView.k();
        }
    }

    public void f() {
        this.f180245c.setVisibility(0);
        this.f180244b.setVisibility(8);
    }
}

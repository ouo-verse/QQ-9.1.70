package com.tencent.mobileqq.activity.aio.voicetextpanel.ui.viewhelper;

import android.content.SharedPreferences;
import android.graphics.Rect;
import android.view.TouchDelegate;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.aio.voicetextpanel.ui.VoiceTextPanel;
import com.tencent.mobileqq.shortvideo.util.ScreenUtil;
import com.tencent.mobileqq.utils.QQTheme;
import com.tencent.mobileqq.utils.StringUtil;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import mqq.app.AppRuntime;

/* compiled from: P */
/* loaded from: classes10.dex */
public class VoiceTextSendViewHelper extends com.tencent.mobileqq.activity.aio.voicetextpanel.ui.viewhelper.a {
    private CheckBox C;
    private SharedPreferences D;
    private CompoundButton.OnCheckedChangeListener E;

    /* renamed from: i, reason: collision with root package name */
    private Button f180217i;

    /* renamed from: m, reason: collision with root package name */
    private Button f180218m;

    /* compiled from: P */
    /* loaded from: classes10.dex */
    class a implements CompoundButton.OnCheckedChangeListener {
        a() {
        }

        @Override // android.widget.CompoundButton.OnCheckedChangeListener
        public void onCheckedChanged(CompoundButton compoundButton, boolean z16) {
            EventCollector.getInstance().onCompoundButtonCheckedBefore(compoundButton, z16);
            if (!z16) {
                VoiceTextSendViewHelper.this.x(false);
                VoiceTextSendViewHelper.this.f180217i.setText(R.string.f173103vy3);
                if (VoiceTextSendViewHelper.this.c().e() && StringUtil.isEmpty(VoiceTextSendViewHelper.this.f180226f.a())) {
                    VoiceTextSendViewHelper.this.w(false);
                }
                VoiceTextSendViewHelper.this.d().g(false);
                VoiceTextSendViewHelper.this.s();
            } else {
                if (VoiceTextSendViewHelper.this.c().f()) {
                    VoiceTextSendViewHelper.this.w(true);
                }
                VoiceTextSendViewHelper.this.x(true);
                VoiceTextSendViewHelper.this.f180217i.setText(R.string.f173104vy4);
                VoiceTextSendViewHelper.this.d().g(true);
                VoiceTextSendViewHelper.this.r();
            }
            EventCollector.getInstance().onCompoundButtonChecked(compoundButton, z16);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes10.dex */
    public class b implements View.OnClickListener {
        b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            c71.c cVar = VoiceTextSendViewHelper.this.f180227h;
            if (cVar != null) {
                cVar.onCancel();
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes10.dex */
    public class c implements View.OnClickListener {
        c() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            c71.c cVar = VoiceTextSendViewHelper.this.f180227h;
            if (cVar != null) {
                cVar.a();
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    public VoiceTextSendViewHelper(d71.c cVar, AppRuntime appRuntime, SharedPreferences sharedPreferences) {
        super(appRuntime, cVar);
        this.E = new a();
        this.D = sharedPreferences;
    }

    private void m() {
        final View view = (View) this.C.getParent();
        final int dip2px = ScreenUtil.dip2px(8.0f);
        view.post(new Runnable() { // from class: com.tencent.mobileqq.activity.aio.voicetextpanel.ui.viewhelper.VoiceTextSendViewHelper.4
            @Override // java.lang.Runnable
            public void run() {
                Rect rect = new Rect();
                VoiceTextSendViewHelper.this.C.getHitRect(rect);
                int i3 = rect.top;
                int i16 = dip2px;
                rect.top = i3 - i16;
                rect.bottom += i16;
                rect.left -= i16 * 2;
                rect.right += i16;
                view.setTouchDelegate(new TouchDelegate(rect, VoiceTextSendViewHelper.this.C));
            }
        });
    }

    private boolean o() {
        SharedPreferences sharedPreferences = this.D;
        if (sharedPreferences == null) {
            return false;
        }
        return sharedPreferences.getBoolean("businessinfo_ptt_vt_send_type_" + this.f180224d.getCurrentAccountUin(), false);
    }

    private void p() {
        if (QQTheme.isNowThemeIsNight()) {
            this.f180218m.setTextColor(this.f180225e.getColorStateList(R.color.qui_button_text_secondary));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void r() {
        if (d().a()) {
            e71.a.a("0X800A1D8", 2, 0);
        } else {
            e71.a.a("0X800A1D8", 1, 0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void s() {
        if (d().a()) {
            e71.a.a("0X800A1D9", 2, 0);
        } else {
            e71.a.a("0X800A1D9", 1, 0);
        }
    }

    private void u(boolean z16) {
        d().h(z16);
        this.C.setEnabled(z16);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void x(boolean z16) {
        SharedPreferences sharedPreferences = this.D;
        if (sharedPreferences != null) {
            sharedPreferences.edit().putBoolean("businessinfo_ptt_vt_send_type_" + this.f180224d.getCurrentAccountUin(), z16).commit();
        }
    }

    @Override // com.tencent.mobileqq.activity.aio.voicetextpanel.ui.viewhelper.a
    public void f(VoiceTextPanel voiceTextPanel) {
        super.f(voiceTextPanel);
        this.f180217i = (Button) voiceTextPanel.findViewById(R.id.imy);
        Button button = (Button) voiceTextPanel.findViewById(R.id.cancel);
        this.f180218m = button;
        button.setOnClickListener(new b());
        this.f180217i.setOnClickListener(new c());
        CheckBox checkBox = (CheckBox) voiceTextPanel.findViewById(R.id.axa);
        this.C = checkBox;
        checkBox.setOnCheckedChangeListener(this.E);
        m();
        p();
    }

    public void n() {
        u(false);
        this.f180217i.setText(R.string.f173103vy3);
    }

    public boolean q() {
        return this.f180217i.isEnabled();
    }

    public void t() {
        boolean o16 = o();
        u(true);
        if (o16) {
            this.C.setChecked(true);
            d().g(true);
            this.f180217i.setText(R.string.f173104vy4);
            w(true);
            return;
        }
        this.C.setChecked(false);
        d().g(false);
        this.f180217i.setText(R.string.f173103vy3);
        w(false);
    }

    public void v() {
        w(true);
        this.C.setChecked(true);
        d().g(true);
    }

    public void w(boolean z16) {
        this.f180217i.setEnabled(z16);
    }
}

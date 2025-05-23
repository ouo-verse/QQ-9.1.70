package com.tencent.mobileqq.activity.aio.voicetextpanel.ui.viewhelper;

import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.aio.voicetextpanel.ui.VoiceTextPanel;
import com.tencent.mobileqq.app.FontSettingManager;
import com.tencent.mobileqq.shortvideo.util.ScreenUtil;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes10.dex */
public class b {

    /* renamed from: a, reason: collision with root package name */
    private LinearLayout f180228a;

    /* renamed from: b, reason: collision with root package name */
    private Button f180229b;

    /* renamed from: c, reason: collision with root package name */
    private Button f180230c;

    /* renamed from: d, reason: collision with root package name */
    private float f180231d = 0.0f;

    /* renamed from: e, reason: collision with root package name */
    private View f180232e;

    private void d() {
        float f16 = this.f180228a.getResources().getDisplayMetrics().density / FontSettingManager.systemMetrics.density;
        if (f16 != 1.0d) {
            float f17 = this.f180231d;
            if (f17 == 0.0f || f17 != f16) {
                this.f180231d = f16;
                this.f180229b.setTextSize(ViewUtils.pxTosp(r1.getTextSize()) / f16);
                this.f180230c.setTextSize(ViewUtils.pxTosp(r1.getTextSize()) / f16);
                return;
            }
        }
        if (QLog.isColorLevel()) {
            QLog.i("VoiceTextBottomViewHelper", 2, "fontsize doenst change");
        }
    }

    public void a() {
        if (QLog.isColorLevel()) {
            QLog.d("VoiceTextBottomViewHelper", 2, "hideBottom");
        }
        this.f180228a.setVisibility(8);
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.f180232e.getLayoutParams();
        layoutParams.bottomMargin = 0;
        this.f180232e.setLayoutParams(layoutParams);
    }

    public void b(VoiceTextPanel voiceTextPanel) {
        this.f180228a = (LinearLayout) voiceTextPanel.findViewById(R.id.f164635ad4);
        this.f180229b = (Button) voiceTextPanel.findViewById(R.id.imy);
        this.f180230c = (Button) voiceTextPanel.findViewById(R.id.cancel);
        this.f180232e = voiceTextPanel.findViewById(R.id.e_1);
        d();
    }

    public void c() {
        e();
    }

    public void e() {
        if (QLog.isColorLevel()) {
            QLog.d("VoiceTextBottomViewHelper", 2, "showBottom");
        }
        this.f180228a.setVisibility(0);
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.f180232e.getLayoutParams();
        layoutParams.bottomMargin = ScreenUtil.dip2px(75.0f);
        this.f180232e.setLayoutParams(layoutParams);
    }
}

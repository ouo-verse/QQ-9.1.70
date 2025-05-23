package com.tencent.mobileqq.activity.aio.voicetextpanel.ui;

import android.content.Context;
import android.os.Handler;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.aio.item.PttAudioWaveView;
import com.tencent.mobileqq.ptt.temp.api.IVoice2TxtTmpApi;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.RecordParams;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.utils.VoicePlayer;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

/* loaded from: classes10.dex */
public class VoiceTextPttPlayView extends RelativeLayout implements VoicePlayer.a, View.OnClickListener, PttAudioWaveView.b {
    private float C;
    private boolean D;

    /* renamed from: d, reason: collision with root package name */
    private TextView f180207d;

    /* renamed from: e, reason: collision with root package name */
    private PttAudioWaveView f180208e;

    /* renamed from: f, reason: collision with root package name */
    private VoicePlayer f180209f;

    /* renamed from: h, reason: collision with root package name */
    private String f180210h;

    /* renamed from: i, reason: collision with root package name */
    private int f180211i;

    /* renamed from: m, reason: collision with root package name */
    private int f180212m;

    public VoiceTextPttPlayView(Context context) {
        super(context);
        this.C = 0.0f;
        this.D = false;
        h();
    }

    private void c() {
        this.C = 0.0f;
        this.f180208e.setProgress(0.0f);
        this.D = false;
        l();
        this.f180208e.setCanSupportSlide(false);
    }

    private int d(int i3, int i16, RecordParams.RecorderParam recorderParam) {
        int waveViewLen = ((IVoice2TxtTmpApi) QRoute.api(IVoice2TxtTmpApi.class)).getWaveViewLen(getContext(), i16, 0.0f, ViewUtils.pxToDp((int) this.f180207d.getPaint().measureText(this.f180207d.getText().toString())), 5, false, false);
        if (QLog.isColorLevel()) {
            QLog.d("VoiceTextPttPlayView", 2, "setDuration  length=" + waveViewLen + " duration=" + i3 + "  param.waveSampleLen" + recorderParam.C);
        }
        if (waveViewLen > ViewUtils.dpToPx(120.0f)) {
            return ViewUtils.dpToPx(120.0f);
        }
        return waveViewLen;
    }

    private void e() {
        this.f180207d = new TextView(getContext());
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -1);
        layoutParams.addRule(11, -1);
        layoutParams.rightMargin = ViewUtils.dpToPx(5.0f);
        this.f180207d.setTextSize(2, 14.0f);
        this.f180207d.setLayoutParams(layoutParams);
        this.f180207d.setGravity(16);
        addView(this.f180207d);
    }

    private int f(int i3) {
        int i16 = i3 / 1000;
        if (i16 <= 0) {
            this.f180207d.setText("1\"");
        } else {
            this.f180207d.setText(i16 + "\"");
        }
        return i16;
    }

    private void g() {
        this.f180208e = new PttAudioWaveView(getContext());
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -1);
        layoutParams.width = ViewUtils.dpToPx(120.0f);
        layoutParams.addRule(15, -1);
        this.f180208e.setVisibility(8);
        this.f180208e.setLayoutParams(layoutParams);
        addView(this.f180208e);
        this.f180208e.setOnClickListener(this);
        this.f180208e.setSeekListener(this);
    }

    private void h() {
        g();
        e();
        setOnClickListener(this);
        if (QLog.isColorLevel()) {
            QLog.d("VoiceTextPttPlayView", 2, "init width =" + getMeasuredWidth());
        }
    }

    private void l() {
        VoicePlayer voicePlayer = this.f180209f;
        if (voicePlayer != null) {
            voicePlayer.v();
            this.f180209f = null;
        }
        if (this.f180208e != null && !this.D && Math.abs(this.C - 0.0f) < 1.0E-8d) {
            this.f180208e.setCanSupportSlide(false);
        }
    }

    private void m(int i3, int i16, RecordParams.RecorderParam recorderParam, VoiceTextPanel voiceTextPanel) {
        this.f180208e.setAudioData(PttAudioWaveView.d(recorderParam.D, recorderParam.C), i16, i3 / 1000);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -1);
        layoutParams.width = i16;
        layoutParams.addRule(15, -1);
        layoutParams.leftMargin = ViewUtils.dpToPx(5.0f);
        layoutParams.rightMargin = ViewUtils.dpToPx(5.0f);
        this.f180208e.setLayoutParams(layoutParams);
        this.f180208e.setVisibility(0);
        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) getLayoutParams();
        layoutParams2.width = ViewUtils.dpToPx(13.0f) + i16 + ((int) this.f180207d.getPaint().measureText(this.f180207d.getText().toString()));
        setLayoutParams(layoutParams2);
        if (voiceTextPanel != null) {
            voiceTextPanel.y();
        }
    }

    @Override // com.tencent.mobileqq.activity.aio.item.PttAudioWaveView.b
    public void a(PttAudioWaveView pttAudioWaveView, float f16) {
        int i3 = (int) (f16 * this.f180212m);
        if (QLog.isColorLevel()) {
            QLog.d("VoiceTextPttPlayView", 2, "onSeekProgressUpdate, offset = " + i3);
        }
        i(i3);
    }

    @Override // com.tencent.mobileqq.activity.aio.item.PttAudioWaveView.b
    public void b(PttAudioWaveView pttAudioWaveView) {
        this.D = true;
        l();
    }

    @Override // com.tencent.mobileqq.utils.VoicePlayer.a
    public void c5(String str, int i3, int i16) {
        float f16 = i16 / i3;
        this.C = f16;
        this.f180208e.setProgress(f16);
    }

    public void i(int i3) {
        if (this.f180209f == null) {
            VoicePlayer voicePlayer = new VoicePlayer(this.f180210h, new Handler(), this.f180211i);
            this.f180209f = voicePlayer;
            voicePlayer.y(getContext());
            this.f180209f.z();
            this.f180209f.l(this);
            this.f180209f.w(i3);
            this.f180209f.A();
            this.f180208e.setCanSupportSlide(true);
            return;
        }
        l();
    }

    public void j() {
        c();
    }

    public void k() {
        l();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        i((int) (this.C * this.f180212m));
        EventCollector.getInstance().onViewClicked(view);
    }

    public void setDuration(int i3, String str, RecordParams.RecorderParam recorderParam, VoiceTextPanel voiceTextPanel) {
        this.f180212m = i3;
        int f16 = f(i3);
        m(i3, d(i3, f16, recorderParam), recorderParam, voiceTextPanel);
        this.f180210h = str;
        this.f180211i = recorderParam.f307257f;
        this.f180208e.setProgressColor(getContext().getResources().getColorStateList(R.color.qui_common_text_primary).getDefaultColor());
        this.f180207d.setTextColor(getContext().getResources().getColorStateList(R.color.qui_common_text_primary).getDefaultColor());
        setContentDescription(getContext().getResources().getString(R.string.f230346yw, String.valueOf(f16)));
    }

    @Override // com.tencent.mobileqq.utils.VoicePlayer.a
    public void u4(int i3, String str, int i16) {
        c();
    }

    public VoiceTextPttPlayView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.C = 0.0f;
        this.D = false;
        h();
    }

    public VoiceTextPttPlayView(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        this.C = 0.0f;
        this.D = false;
        h();
    }

    @Override // com.tencent.mobileqq.utils.VoicePlayer.a
    public void ic(String str, int i3, int i16) {
    }
}

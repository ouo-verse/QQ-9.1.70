package com.tencent.aelight.camera.aioeditor.takevideo;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.biz.qui.quibutton.QUIButton;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.editor.params.EditVideoParams;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.troop.activity.TroopBarPublishUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes32.dex */
public class b extends r {

    /* renamed from: h0, reason: collision with root package name */
    public static final String f67944h0 = "b";

    /* renamed from: i0, reason: collision with root package name */
    private static final String f67945i0 = HardCodeUtil.qqStr(R.string.lrf);

    /* renamed from: a0, reason: collision with root package name */
    private View f67946a0;

    /* renamed from: b0, reason: collision with root package name */
    private RelativeLayout f67947b0;

    /* renamed from: c0, reason: collision with root package name */
    private TextView f67948c0;

    /* renamed from: d0, reason: collision with root package name */
    private QUIButton f67949d0;

    /* renamed from: e0, reason: collision with root package name */
    private int f67950e0;

    /* renamed from: f0, reason: collision with root package name */
    private String f67951f0;

    /* renamed from: g0, reason: collision with root package name */
    private String f67952g0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes32.dex */
    public class a implements View.OnClickListener {
        a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            if (b.this.f67950e0 == -1) {
                b.this.T0("Clk_add_topic");
            }
            TroopBarPublishUtils.f((Activity) b.this.getContext(), 1001, b.this.f67950e0);
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    public b(EditVideoPartManager editVideoPartManager, int i3) {
        super(editVideoPartManager, i3);
        this.f67950e0 = -1;
        this.f67952g0 = "barindex";
    }

    private void S0() {
        if (this.f67950e0 != -1 && !TextUtils.isEmpty(this.f67951f0)) {
            U0("#" + this.f67951f0);
        } else {
            U0(f67945i0);
        }
        this.f67948c0.setTextColor(-1);
        this.f67948c0.setTextSize(16.0f);
        this.f67948c0.setOnClickListener(new a());
    }

    private void U0(String str) {
        SpannableString spannableString = new SpannableString(str);
        int i3 = this.f67950e0 != -1 ? -18432 : -1;
        spannableString.setSpan(new od0.b(getContext(), R.drawable.dkn), 0, 1, 33);
        this.f67948c0.setText(spannableString);
        this.f67948c0.setTextColor(i3);
    }

    public int P0() {
        return this.f67950e0;
    }

    public String getThemeName() {
        return this.f67951f0;
    }

    @Override // com.tencent.aelight.camera.aioeditor.takevideo.u
    public void onActivityResult(int i3, int i16, Intent intent) {
        super.onActivityResult(i3, i16, intent);
        if (i16 != 0 && i3 == 1001) {
            R0(intent);
        }
    }

    @Override // com.tencent.aelight.camera.aioeditor.takevideo.r, com.tencent.aelight.camera.aioeditor.takevideo.u
    public void onCreate() {
        super.onCreate();
        this.f67947b0 = (RelativeLayout) findViewSure(R.id.f163733rq0);
        this.f67946a0 = (ImageView) findViewSure(R.id.s2v);
        QUIButton qUIButton = (QUIButton) findViewSure(R.id.rrb);
        this.f67949d0 = qUIButton;
        qUIButton.setPadding(0, 0, 0, 0);
        this.f67946a0.setVisibility(8);
        this.f67949d0.setText(HardCodeUtil.qqStr(R.string.lre));
        TextView textView = new TextView(getContext());
        this.f67948c0 = textView;
        textView.setGravity(17);
        this.f67948c0.setMaxWidth(com.tencent.mobileqq.util.x.c(getContext(), 192.0f));
        this.f67948c0.setEllipsize(TextUtils.TruncateAt.END);
        this.f67948c0.setSingleLine(true);
        int c16 = com.tencent.mobileqq.util.x.c(getContext(), 10.0f);
        this.f67948c0.setPadding(c16, 0, c16, 0);
        this.f67948c0.setBackgroundResource(R.drawable.f161445xs);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, com.tencent.mobileqq.util.x.c(getContext(), 28.0f));
        layoutParams.addRule(11);
        layoutParams.addRule(15);
        layoutParams.rightMargin = com.tencent.mobileqq.util.x.c(getContext(), 10.0f);
        this.f67947b0.addView(this.f67948c0, layoutParams);
        JSONObject Q0 = Q0(((EditVideoParams) ((Activity) getContext()).getIntent().getParcelableExtra(EditVideoParams.class.getName())).f204058h);
        if (Q0 != null) {
            boolean optBoolean = Q0.optBoolean("needTheme", false);
            this.f67952g0 = Q0.optString("from", "");
            this.f67950e0 = Q0.optInt("theme_id", -1);
            this.f67951f0 = Q0.optString("theme_name", "");
            if (QLog.isColorLevel()) {
                QLog.d(f67944h0, 2, "onCreate mThemeID = " + this.f67950e0 + " mThemeName = " + this.f67951f0);
            }
            S0();
            if (optBoolean) {
                return;
            }
            this.f67948c0.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void T0(String str) {
        ReportController.o(null, "dc00899", "Grp_tribe", "", "video_edit", str, "barindex".equals(this.f67952g0) ? 1 : 2, 0, "", "", "", "");
    }

    public static JSONObject Q0(Bundle bundle) {
        if (bundle == null) {
            return null;
        }
        String string = bundle.getString("options");
        if (QLog.isColorLevel()) {
            QLog.d(f67944h0, 2, "getTribeJsonExtra option: " + string);
        }
        try {
            return new JSONObject(string);
        } catch (Exception e16) {
            if (!QLog.isColorLevel()) {
                return null;
            }
            QLog.e(f67944h0, 2, "getTribeJsonExtra: " + e16);
            return null;
        }
    }

    private void R0(Intent intent) {
        if (intent == null) {
            return;
        }
        int intExtra = intent.getIntExtra("theme_id", -1);
        String stringExtra = intent.getStringExtra("theme_name");
        this.f67950e0 = intExtra;
        if (intExtra == -1) {
            U0(f67945i0);
            this.f67951f0 = "";
        } else if (stringExtra != null) {
            U0("#" + stringExtra);
            this.f67951f0 = stringExtra;
        }
        if (QLog.isColorLevel()) {
            QLog.d(f67944h0, 2, "handleSelectedTheme mThemeID = " + this.f67950e0 + " mThemeName = " + this.f67951f0);
        }
    }
}

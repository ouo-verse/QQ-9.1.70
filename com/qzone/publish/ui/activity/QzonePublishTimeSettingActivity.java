package com.qzone.publish.ui.activity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.TextView;
import com.qzone.common.activities.base.QZoneTitleBarFragmentV2;
import com.qzone.util.ToastUtil;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.widget.FormSwitchItem;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqmini.sdk.core.utils.WnsConfig;
import common.config.service.QZoneConfigHelper;
import common.config.service.QzoneConfig;
import cooperation.qzone.RDMEtraMsgCollector;
import cooperation.qzone.report.lp.LpReportInfo_pf00064;
import cooperation.qzone.util.QZLog;
import java.util.Calendar;
import java.util.HashMap;
import java.util.TimeZone;
import jp.c;

/* loaded from: classes39.dex */
public class QzonePublishTimeSettingActivity extends QZoneTitleBarFragmentV2 {
    public static long A0 = 864000;

    /* renamed from: z0, reason: collision with root package name */
    public static final String f51831z0 = "QzonePublishTimeSettingActivity";

    /* renamed from: h0, reason: collision with root package name */
    FormSwitchItem f51832h0;

    /* renamed from: i0, reason: collision with root package name */
    TextView f51833i0;

    /* renamed from: j0, reason: collision with root package name */
    FormSwitchItem f51834j0;

    /* renamed from: k0, reason: collision with root package name */
    private jp.c f51835k0;

    /* renamed from: l0, reason: collision with root package name */
    private boolean f51836l0 = false;

    /* renamed from: m0, reason: collision with root package name */
    public long f51837m0 = 0;

    /* renamed from: n0, reason: collision with root package name */
    public long f51838n0 = 0;

    /* renamed from: o0, reason: collision with root package name */
    private long f51839o0 = 0;

    /* renamed from: p0, reason: collision with root package name */
    private long f51840p0 = 0;

    /* renamed from: q0, reason: collision with root package name */
    private boolean f51841q0 = false;

    /* renamed from: r0, reason: collision with root package name */
    private boolean f51842r0 = false;

    /* renamed from: s0, reason: collision with root package name */
    private int f51843s0 = QzoneConfig.getInstance().getConfig("QZoneSetting", "QzoneMoodDeleteTime", 86400);

    /* renamed from: t0, reason: collision with root package name */
    private String f51844t0 = QzoneConfig.getInstance().getConfig(WnsConfig.MAIN_KEY_QZONE_TEXT_SETTING, "TitleTiming", "\u5b9a\u65f6");

    /* renamed from: u0, reason: collision with root package name */
    private String f51845u0 = QzoneConfig.getInstance().getConfig(WnsConfig.MAIN_KEY_QZONE_TEXT_SETTING, "TimingPublish", "\u53d1\u8868");

    /* renamed from: v0, reason: collision with root package name */
    private String f51846v0 = QzoneConfig.getInstance().getConfig(WnsConfig.MAIN_KEY_QZONE_TEXT_SETTING, "TimingAutoDelete", "\u540e\u81ea\u52a8\u5220\u9664");

    /* renamed from: w0, reason: collision with root package name */
    private String f51847w0 = QzoneConfig.getInstance().getConfig(WnsConfig.MAIN_KEY_QZONE_TEXT_SETTING, "TimingPublishMood", "\u53d1\u8868\u540e\uff0c\u8be5\u8bf4\u8bf4\u5c06\u5728");

    /* renamed from: x0, reason: collision with root package name */
    private String f51848x0 = QzoneConfig.getInstance().getConfig(WnsConfig.MAIN_KEY_QZONE_TEXT_SETTING, "TimingAutoDeleteNotBack", "\u540e\u81ea\u52a8\u5220\u9664\uff0c\u8be5\u8bbe\u7f6e\u4e0d\u53ef\u64a4\u56de");

    /* renamed from: y0, reason: collision with root package name */
    private boolean f51849y0 = QZoneConfigHelper.I0();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes39.dex */
    public class a implements View.OnClickListener {
        a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            long j3 = QzonePublishTimeSettingActivity.this.f51839o0;
            long j16 = QzonePublishTimeSettingActivity.this.f51837m0;
            if (j3 != j16) {
                if (j16 > 0) {
                    LpReportInfo_pf00064.allReport(630, 2, 1);
                } else {
                    LpReportInfo_pf00064.allReport(630, 2, 2);
                }
            }
            long j17 = QzonePublishTimeSettingActivity.this.f51840p0;
            long j18 = QzonePublishTimeSettingActivity.this.f51838n0;
            if (j17 != j18) {
                if (j18 > 0) {
                    LpReportInfo_pf00064.allReport(630, 3, 1);
                    if (QzonePublishTimeSettingActivity.this.f51842r0) {
                        QzonePublishTimeSettingActivity.this.zi(2);
                    }
                } else {
                    LpReportInfo_pf00064.allReport(630, 3, 2);
                }
            }
            QzonePublishTimeSettingActivity qzonePublishTimeSettingActivity = QzonePublishTimeSettingActivity.this;
            if (qzonePublishTimeSettingActivity.f51837m0 > 0 && qzonePublishTimeSettingActivity.f51838n0 > 0) {
                LpReportInfo_pf00064.allReport(630, 4);
            }
            Intent intent = new Intent();
            if (QzonePublishTimeSettingActivity.this.f51841q0) {
                QzonePublishTimeSettingActivity.this.f51837m0 = 0L;
            }
            intent.putExtra("SchedualPublishTime", QzonePublishTimeSettingActivity.this.f51837m0);
            intent.putExtra("SchedualDeleteTime", QzonePublishTimeSettingActivity.this.f51838n0);
            QzonePublishTimeSettingActivity.this.setResult(-1, intent);
            QzonePublishTimeSettingActivity.this.finish();
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes39.dex */
    public class b implements View.OnClickListener {
        b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            QzonePublishTimeSettingActivity.this.setResult(0);
            QzonePublishTimeSettingActivity.this.finish();
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes39.dex */
    public class c implements CompoundButton.OnCheckedChangeListener {
        c() {
        }

        @Override // android.widget.CompoundButton.OnCheckedChangeListener
        public void onCheckedChanged(CompoundButton compoundButton, boolean z16) {
            EventCollector.getInstance().onCompoundButtonCheckedBefore(compoundButton, z16);
            if (z16) {
                QzonePublishTimeSettingActivity.this.Bi();
            } else {
                QzonePublishTimeSettingActivity.this.Ai(8);
                QzonePublishTimeSettingActivity.this.f51837m0 = 0L;
            }
            EventCollector.getInstance().onCompoundButtonChecked(compoundButton, z16);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes39.dex */
    public class d implements CompoundButton.OnCheckedChangeListener {

        /* loaded from: classes39.dex */
        class a implements DialogInterface.OnClickListener {
            a() {
            }

            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i3) {
                QzonePublishTimeSettingActivity.this.f51838n0 = r3.f51843s0;
            }
        }

        /* loaded from: classes39.dex */
        class b implements DialogInterface.OnClickListener {
            b() {
            }

            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i3) {
                FormSwitchItem formSwitchItem = QzonePublishTimeSettingActivity.this.f51834j0;
                if (formSwitchItem != null) {
                    formSwitchItem.setChecked(false);
                }
            }
        }

        d() {
        }

        @Override // android.widget.CompoundButton.OnCheckedChangeListener
        public void onCheckedChanged(CompoundButton compoundButton, boolean z16) {
            EventCollector.getInstance().onCompoundButtonCheckedBefore(compoundButton, z16);
            if (z16) {
                QQCustomDialog qQCustomDialog = new QQCustomDialog(QzonePublishTimeSettingActivity.this.getActivity(), R.style.qZoneInputDialog);
                qQCustomDialog.setCancelable(false);
                qQCustomDialog.setCanceledOnTouchOutside(false);
                qQCustomDialog.setContentView(R.layout.custom_dialog);
                StringBuilder sb5 = new StringBuilder();
                sb5.append(QzonePublishTimeSettingActivity.this.f51847w0);
                sb5.append(QzonePublishTimeSettingActivity.this.vi(r2.f51843s0));
                sb5.append(QzonePublishTimeSettingActivity.this.f51848x0);
                qQCustomDialog.setTitle(sb5.toString());
                qQCustomDialog.setTitleMutiLine();
                qQCustomDialog.setPositiveButton(com.qzone.util.l.a(R.string.s6d), new a());
                qQCustomDialog.setNegativeButton(com.qzone.util.l.a(R.string.j6l), new b());
                qQCustomDialog.show();
            } else {
                QzonePublishTimeSettingActivity.this.f51838n0 = 0L;
            }
            EventCollector.getInstance().onCompoundButtonChecked(compoundButton, z16);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes39.dex */
    public class e implements c.InterfaceC10604c {
        e() {
        }

        @Override // jp.c.InterfaceC10604c
        public void a(int i3, int i16, int i17) {
            long e16 = jp.b.e(QzonePublishTimeSettingActivity.this.f51835k0, i3, i16, i17) / 1000;
            if (QzonePublishTimeSettingActivity.this.ui(e16)) {
                QzonePublishTimeSettingActivity.this.f51836l0 = true;
                QzonePublishTimeSettingActivity.this.f51835k0.m();
                QzonePublishTimeSettingActivity qzonePublishTimeSettingActivity = QzonePublishTimeSettingActivity.this;
                qzonePublishTimeSettingActivity.f51837m0 = e16;
                TextView textView = qzonePublishTimeSettingActivity.f51833i0;
                if (textView != null) {
                    if (textView.getVisibility() == 8) {
                        QzonePublishTimeSettingActivity.this.f51833i0.setVisibility(0);
                    }
                    QzonePublishTimeSettingActivity qzonePublishTimeSettingActivity2 = QzonePublishTimeSettingActivity.this;
                    qzonePublishTimeSettingActivity2.f51833i0.setText(qzonePublishTimeSettingActivity2.wi(e16));
                    return;
                }
                return;
            }
            jp.b.f(QzonePublishTimeSettingActivity.this.f51835k0, (jp.b) QzonePublishTimeSettingActivity.this.f51835k0.n());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes39.dex */
    public class f implements c.d {
        f() {
        }

        @Override // jp.c.d
        public void onDismiss() {
            if (QzonePublishTimeSettingActivity.this.f51836l0) {
                return;
            }
            RDMEtraMsgCollector.getInstance().addNoramlClickAction(QzonePublishTimeSettingActivity.this.simpleClassname, null);
            QzonePublishTimeSettingActivity qzonePublishTimeSettingActivity = QzonePublishTimeSettingActivity.this;
            if (qzonePublishTimeSettingActivity.f51837m0 == 0) {
                qzonePublishTimeSettingActivity.f51832h0.setChecked(false);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Ai(int i3) {
        TextView textView = this.f51833i0;
        if (textView == null || textView.getVisibility() == i3) {
            return;
        }
        this.f51833i0.setVisibility(i3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Bi() {
        if (this.f51835k0 == null) {
            try {
                xi();
            } catch (Throwable unused) {
                ToastUtil.r(QzoneConfig.getInstance().getConfig(WnsConfig.MAIN_KEY_QZONE_TEXT_SETTING, "ToastCannotSupportToPublishTimingMood", "\u8be5\u7cfb\u7edf\u6682\u4e0d\u652f\u6301\u5b9a\u65f6\u53d1\u8868\u8bf4\u8bf4\u529f\u80fd"));
                this.f51832h0.setChecked(false);
                return;
            }
        }
        this.f51836l0 = false;
        if (this.f51835k0.n() instanceof jp.b) {
            jp.c cVar = this.f51835k0;
            jp.b.f(cVar, (jp.b) cVar.n());
        }
        this.f51835k0.s();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean ui(long j3) {
        long currentTimeMillis = (System.currentTimeMillis() / 1000) + 1;
        if (this.f51835k0 == null) {
            return false;
        }
        if (j3 < currentTimeMillis) {
            ToastUtil.s(getString(R.string.glw), 4);
            return false;
        }
        if (j3 <= currentTimeMillis + A0) {
            return true;
        }
        ToastUtil.r(getString(R.string.glv));
        return false;
    }

    private void xi() {
        jp.c a16 = jp.b.a(getActivity());
        this.f51835k0 = a16;
        a16.p(new e());
        this.f51835k0.q(new f());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void yi(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Bi();
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void zi(int i3) {
        HashMap<String, String> hashMap = new HashMap<>();
        if (i3 == 1) {
            hashMap.put("setting_page_schedule_video_delete_exposure", "1");
            QZLog.i(f51831z0, "setting page schedule video delete exposure");
        } else if (i3 == 2) {
            hashMap.put("setting_page_schedule_video_delete_selected", "1");
            QZLog.i(f51831z0, "setting page schedule video delete selected");
        }
        if (hashMap.size() > 0) {
            StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance((String) null, StatisticCollector.QZONE_MOOD_SCHEDULE_DELETE_VIDEO_TAG, true, 0L, 0L, hashMap, (String) null, true);
        }
    }

    @Override // com.qzone.common.activities.base.QZoneTitleBarFragmentV2
    protected boolean Hh() {
        return true;
    }

    public void initUI() {
        setTitle(this.f51844t0);
        setRightButton(R.string.f171151ok, new a());
        setLeftButton(R.string.cancel, new b());
        FormSwitchItem formSwitchItem = (FormSwitchItem) findViewById(R.id.g5b);
        this.f51832h0 = formSwitchItem;
        if (formSwitchItem != null) {
            formSwitchItem.setCloseVipTheme(true);
        }
        FormSwitchItem formSwitchItem2 = this.f51832h0;
        if (formSwitchItem2 != null && formSwitchItem2.getTextView() != null && this.f51832h0.getSwitch() != null) {
            this.f51832h0.setImportantForAccessibility(2);
            this.f51832h0.getTextView().setImportantForAccessibility(2);
            this.f51832h0.getSwitch().setContentDescription("\u5b9a\u65f6\u53d1\u8868");
        }
        this.f51833i0 = (TextView) findViewById(R.id.jlu);
        FormSwitchItem formSwitchItem3 = (FormSwitchItem) findViewById(R.id.bfw);
        this.f51834j0 = formSwitchItem3;
        if (formSwitchItem3 != null) {
            formSwitchItem3.setCloseVipTheme(true);
        }
        FormSwitchItem formSwitchItem4 = this.f51834j0;
        if (formSwitchItem4 != null && formSwitchItem4.getTextView() != null && this.f51834j0.getSwitch() != null) {
            this.f51834j0.setImportantForAccessibility(2);
            this.f51834j0.getTextView().setImportantForAccessibility(2);
            this.f51834j0.getSwitch().setContentDescription("\u53d1\u886824\u5c0f\u65f6\u540e\u81ea\u52a8\u5220\u9664");
        }
        this.f51837m0 = getIntent().getLongExtra("SchedualPublishTime", 0L);
        this.f51838n0 = getIntent().getLongExtra("SchedualDeleteTime", 0L);
        this.f51841q0 = getIntent().getBooleanExtra("HideSchedualDeleteTime", false);
        this.f51842r0 = getIntent().getBooleanExtra("VideoSelected", false);
        if (this.f51841q0) {
            FormSwitchItem formSwitchItem5 = this.f51832h0;
            if (formSwitchItem5 != null) {
                formSwitchItem5.setVisibility(8);
            }
            TextView textView = this.f51833i0;
            if (textView != null) {
                textView.setVisibility(8);
            }
        }
        if (this.f51842r0) {
            zi(1);
        }
        long j3 = this.f51837m0;
        this.f51839o0 = j3;
        this.f51840p0 = this.f51838n0;
        if (j3 <= 0) {
            FormSwitchItem formSwitchItem6 = this.f51832h0;
            if (formSwitchItem6 != null) {
                formSwitchItem6.setChecked(false);
            }
            Ai(8);
        } else {
            FormSwitchItem formSwitchItem7 = this.f51832h0;
            if (formSwitchItem7 != null) {
                formSwitchItem7.setChecked(true);
            }
            Ai(0);
            TextView textView2 = this.f51833i0;
            if (textView2 != null) {
                textView2.setText(wi(this.f51837m0));
            }
        }
        FormSwitchItem formSwitchItem8 = this.f51834j0;
        if (formSwitchItem8 != null) {
            if (this.f51849y0) {
                formSwitchItem8.setVisibility(8);
                this.f51838n0 = 0L;
            } else {
                formSwitchItem8.setVisibility(0);
            }
            if (this.f51838n0 <= 0) {
                this.f51834j0.setChecked(false);
            } else {
                this.f51834j0.setChecked(true);
            }
            this.f51834j0.setText(this.f51845u0 + vi(this.f51843s0) + this.f51846v0);
        }
        FormSwitchItem formSwitchItem9 = this.f51832h0;
        if (formSwitchItem9 != null) {
            formSwitchItem9.setOnCheckedChangeListener(new c());
        }
        TextView textView3 = this.f51833i0;
        if (textView3 != null) {
            textView3.setOnClickListener(new View.OnClickListener() { // from class: com.qzone.publish.ui.activity.w
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    QzonePublishTimeSettingActivity.this.yi(view);
                }
            });
        }
        FormSwitchItem formSwitchItem10 = this.f51834j0;
        if (formSwitchItem10 != null) {
            formSwitchItem10.setOnCheckedChangeListener(new d());
        }
    }

    @Override // com.qzone.common.activities.base.QZoneTitleBarFragmentV2, com.qzone.common.activities.base.BaseFragment, com.tencent.biz.richframework.part.ImmersivePartFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        initUI();
        LpReportInfo_pf00064.allReport(630, 1);
    }

    public String vi(long j3) {
        StringBuffer stringBuffer = new StringBuffer();
        if (j3 > 86400) {
            stringBuffer.append(j3 / 86400);
            stringBuffer.append("\u5929");
            j3 %= 86400;
        }
        if (j3 > 3600) {
            stringBuffer.append(j3 / 3600);
            stringBuffer.append("\u5c0f\u65f6");
            j3 %= 3600;
        }
        if (j3 > 60) {
            stringBuffer.append(j3 / 60);
            stringBuffer.append("\u5206\u949f");
            j3 %= 60;
        }
        if (j3 > 0) {
            stringBuffer.append(j3);
            stringBuffer.append("\u79d2");
        }
        return stringBuffer.toString();
    }

    public String wi(long j3) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(j3 * 1000);
        calendar.setTimeZone(TimeZone.getTimeZone("GMT+8:00"));
        String valueOf = String.valueOf(calendar.get(2) + 1);
        String valueOf2 = String.valueOf(calendar.get(5));
        String valueOf3 = String.valueOf(calendar.get(7));
        if ("1".equals(valueOf3)) {
            valueOf3 = com.qzone.util.l.a(R.string.s6m);
        } else if ("2".equals(valueOf3)) {
            valueOf3 = com.qzone.util.l.a(R.string.s5r);
        } else if ("3".equals(valueOf3)) {
            valueOf3 = com.qzone.util.l.a(R.string.s6e);
        } else if ("4".equals(valueOf3)) {
            valueOf3 = com.qzone.util.l.a(R.string.s5o);
        } else if ("5".equals(valueOf3)) {
            valueOf3 = com.qzone.util.l.a(R.string.s6n);
        } else if ("6".equals(valueOf3)) {
            valueOf3 = com.qzone.util.l.a(R.string.s5k);
        } else if ("7".equals(valueOf3)) {
            valueOf3 = com.qzone.util.l.a(R.string.s65);
        }
        String valueOf4 = String.valueOf(calendar.get(11));
        if (valueOf4 != null && valueOf4.length() == 1) {
            valueOf4 = "0" + valueOf4;
        }
        String valueOf5 = String.valueOf(calendar.get(12));
        if (valueOf5 != null && valueOf5.length() == 1) {
            valueOf5 = "0" + valueOf5;
        }
        return valueOf + com.qzone.util.l.a(R.string.s6b) + valueOf2 + com.qzone.util.l.a(R.string.s5d) + com.qzone.util.l.a(R.string.f172568s62) + valueOf3 + " " + valueOf4 + ":" + valueOf5;
    }

    @Override // com.qzone.common.activities.base.QZoneTitleBarFragmentV2, com.qzone.common.activities.base.BaseFragment
    public void IOnSetTheme() {
        setTheme(R.style.a6t);
    }

    @Override // com.qzone.common.activities.base.BaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return Rh(layoutInflater, R.layout.c5d, viewGroup);
    }
}

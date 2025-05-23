package com.tencent.mobileqq.filemanager.activity;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.content.res.ColorStateList;
import android.content.res.Configuration;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.os.Bundle;
import android.os.SystemClock;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.FontSettingManager;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.filemanager.activity.VerifyPwdView;
import com.tencent.mobileqq.filemanager.api.IQQFileEngine;
import com.tencent.mobileqq.filemanager.api.IQQFileTempUtils;
import com.tencent.mobileqq.filemanager.api.IQlinkUtils;
import com.tencent.mobileqq.filemanager.data.FileInfo;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.data.f;
import com.tencent.mobileqq.filemanager.util.p;
import com.tencent.mobileqq.filemanager.widget.QfileTabBarView;
import com.tencent.mobileqq.filemanager.widget.SendBottomBar;
import com.tencent.mobileqq.filemanageraux.data.WeiYunFileInfo;
import com.tencent.mobileqq.kandian.base.image.api.IPublicAccountHttpDownloader;
import com.tencent.mobileqq.profilecard.api.IProfileProtocolConst;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.teamwork.t;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qadreport.advrreport.QAdVrReportParams;
import com.tencent.mobileqq.util.AccessibilityUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqnt.troop.ITroopInfoRepoApi;
import com.tencent.widget.ListView;
import com.tencent.widget.immersive.ImmersiveUtils;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

/* compiled from: P */
/* loaded from: classes12.dex */
public class FMActivity extends BaseFileAssistantActivity {
    static long I1;
    long A1;
    private int C1;
    private int D1;
    private float F1;
    private float G1;
    private HashMap<String, e> H1;

    /* renamed from: s1, reason: collision with root package name */
    String f206213s1;

    /* renamed from: t1, reason: collision with root package name */
    int f206214t1;

    /* renamed from: v1, reason: collision with root package name */
    int f206216v1;

    /* renamed from: w1, reason: collision with root package name */
    boolean f206217w1;

    /* renamed from: y1, reason: collision with root package name */
    int f206219y1;
    public QfileTabBarView X0 = null;
    protected int Y0 = -1;
    protected ArrayList<String> Z0 = null;

    /* renamed from: a1, reason: collision with root package name */
    com.tencent.mobileqq.filemanager.activity.fileassistant.a f206195a1 = null;

    /* renamed from: b1, reason: collision with root package name */
    RadioGroup.OnCheckedChangeListener f206196b1 = null;

    /* renamed from: c1, reason: collision with root package name */
    RadioGroup f206197c1 = null;

    /* renamed from: d1, reason: collision with root package name */
    RadioButton f206198d1 = null;

    /* renamed from: e1, reason: collision with root package name */
    RadioButton f206199e1 = null;

    /* renamed from: f1, reason: collision with root package name */
    RadioButton f206200f1 = null;

    /* renamed from: g1, reason: collision with root package name */
    RadioButton f206201g1 = null;

    /* renamed from: h1, reason: collision with root package name */
    ImageView f206202h1 = null;

    /* renamed from: i1, reason: collision with root package name */
    TextView f206203i1 = null;

    /* renamed from: j1, reason: collision with root package name */
    View f206204j1 = null;

    /* renamed from: k1, reason: collision with root package name */
    RelativeLayout f206205k1 = null;

    /* renamed from: l1, reason: collision with root package name */
    TextView f206206l1 = null;

    /* renamed from: m1, reason: collision with root package name */
    RelativeLayout f206207m1 = null;

    /* renamed from: n1, reason: collision with root package name */
    VerifyPwdView f206208n1 = null;

    /* renamed from: o1, reason: collision with root package name */
    LinearLayout f206209o1 = null;

    /* renamed from: p1, reason: collision with root package name */
    boolean f206210p1 = false;

    /* renamed from: q1, reason: collision with root package name */
    boolean f206211q1 = false;

    /* renamed from: r1, reason: collision with root package name */
    int f206212r1 = -1;

    /* renamed from: u1, reason: collision with root package name */
    int f206215u1 = -1;

    /* renamed from: x1, reason: collision with root package name */
    String f206218x1 = null;

    /* renamed from: z1, reason: collision with root package name */
    int f206220z1 = -1;
    View B1 = null;
    private BroadcastReceiver E1 = null;

    /* compiled from: P */
    /* loaded from: classes12.dex */
    class a implements View.OnClickListener {
        a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            FMActivity.this.u4();
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes12.dex */
    public class b implements RadioGroup.OnCheckedChangeListener {
        b() {
        }

        @Override // android.widget.RadioGroup.OnCheckedChangeListener
        public void onCheckedChanged(RadioGroup radioGroup, int i3) {
            EventCollector.getInstance().onRadioGroupCheckedBefore(radioGroup, i3);
            ImageView imageView = FMActivity.this.f206202h1;
            if (imageView != null) {
                imageView.setVisibility(8);
            }
            FMActivity.this.f3();
            FMActivity.this.f206209o1.setVisibility(8);
            FMActivity.this.f206167a0.setVisibility(0);
            FMActivity fMActivity = FMActivity.this;
            if (fMActivity.f206208n1 != null) {
                fMActivity.f206207m1.removeAllViews();
                FMActivity.this.f206208n1.setVisibility(8);
                FMActivity.this.f206208n1.d();
                FMActivity fMActivity2 = FMActivity.this;
                fMActivity2.f206208n1 = null;
                fMActivity2.f206207m1.addView(fMActivity2.X0);
            }
            int i16 = 1;
            if (i3 == R.id.f166757i12 && FMActivity.this.f206199e1.isChecked()) {
                FMActivity.this.U2().t();
                FMActivity.this.E4();
                FMActivity.this.M3(false);
                FMActivity.this.b5(1);
                i16 = 0;
            } else if (i3 == R.id.f166138eg0 && FMActivity.this.f206198d1.isChecked()) {
                FMActivity.this.U2().w();
                FMActivity.this.B4();
                if (FMActivity.this.P4()) {
                    FMActivity.this.f206209o1.setVisibility(0);
                }
                FMActivity.this.M3(false);
                FMActivity.this.b5(2);
            } else if (i3 == R.id.f164824b00 && FMActivity.this.f206200f1.isChecked()) {
                FMActivity.this.U2().M();
                FMActivity.this.v4(2);
                FMActivity.this.M3(false);
                FMActivity.this.b5(0);
                i16 = 2;
            } else if (i3 == R.id.v0v && FMActivity.this.f206201g1.isChecked()) {
                FMActivity.this.U2().T();
                FMActivity.this.y4();
                FMActivity.this.M3(false);
                FMActivity.this.b5(5);
                ReportController.o(FMActivity.this.D0, "dc00898", "", "", "0X800AFA6", "0X800AFA6", 0, 0, "", "", "", "");
                i16 = 1408041718;
            } else {
                i16 = -1;
            }
            SharedPreferences.Editor edit = FMActivity.this.D0.getApplicationContext().getSharedPreferences("aio_last_select_file", 0).edit();
            edit.putInt("last_select_tab_type", i16);
            edit.commit();
            EventCollector.getInstance().onRadioGroupChecked(radioGroup, i3);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes12.dex */
    public class c implements VerifyPwdView.b {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ int f206223a;

        c(int i3) {
            this.f206223a = i3;
        }

        @Override // com.tencent.mobileqq.filemanager.activity.VerifyPwdView.b
        public void onSuccess() {
            int i3;
            FMActivity.this.V3();
            if (FMActivity.this.p3()) {
                FMActivity.this.f206167a0.setVisibility(0);
            }
            FMActivity.this.B1.setVisibility(8);
            FMActivity.this.f206207m1.removeAllViews();
            FMActivity fMActivity = FMActivity.this;
            fMActivity.f206207m1.addView(fMActivity.X0);
            FMActivity.this.f206168b0.setTabType(this.f206223a);
            FMActivity.this.X0.v();
            FMActivity fMActivity2 = FMActivity.this;
            fMActivity2.X0.setTabTitleList(new String[]{fMActivity2.getString(R.string.bab), FMActivity.this.getString(R.string.baf), FMActivity.this.getString(R.string.bah), FMActivity.this.getString(R.string.bad), FMActivity.this.getString(R.string.bae)});
            FMActivity fMActivity3 = FMActivity.this;
            fMActivity3.X0.d(16, fMActivity3.getString(R.string.bab));
            FMActivity fMActivity4 = FMActivity.this;
            fMActivity4.X0.d(15, fMActivity4.getString(R.string.baf));
            FMActivity fMActivity5 = FMActivity.this;
            fMActivity5.X0.d(17, fMActivity5.getString(R.string.bah));
            FMActivity fMActivity6 = FMActivity.this;
            fMActivity6.X0.d(18, fMActivity6.getString(R.string.bad));
            FMActivity fMActivity7 = FMActivity.this;
            fMActivity7.X0.d(19, fMActivity7.getString(R.string.bae));
            FMActivity fMActivity8 = FMActivity.this;
            if (fMActivity8.f206210p1 && fMActivity8.f206188v0 == 2 && (i3 = fMActivity8.f206212r1) >= 15 && i3 <= 19) {
                fMActivity8.X0.setSelectedTab(i3);
            } else {
                fMActivity8.X0.setSelectedTab(16);
            }
            VerifyPwdView verifyPwdView = FMActivity.this.f206208n1;
            if (verifyPwdView != null) {
                verifyPwdView.d();
                FMActivity.this.f206208n1 = null;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes12.dex */
    public class d extends BroadcastReceiver {
        d() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            if ("com.tencent.qlink.destory.fmactivity".equalsIgnoreCase(intent.getAction())) {
                FMActivity.this.finish();
                FMActivity.this.overridePendingTransition(0, 0);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes12.dex */
    public static class e {

        /* renamed from: a, reason: collision with root package name */
        public String f206226a;

        /* renamed from: b, reason: collision with root package name */
        public int f206227b;

        /* renamed from: c, reason: collision with root package name */
        public String f206228c;

        public e(String str, int i3, String str2) {
            this.f206226a = str;
            this.f206227b = i3;
            this.f206228c = str2;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void B4() {
        int i3;
        if (QLog.isColorLevel()) {
            QLog.d("FMActivity<FileAssistant>", 2, "initLocalTabView");
        }
        b5(2);
        this.f206168b0.setTabType(1);
        z4();
        J4();
        int i16 = this.D0.getApplicationContext().getSharedPreferences("aio_last_select_file", 0).getInt("last_select_tab_type", -1);
        if (this.f206210p1 && ((this.f206188v0 == 1 || i16 == 1) && (i3 = this.f206212r1) >= 8 && i3 <= 14)) {
            if (this.f206219y1 <= 0) {
                if (i3 != 11 && i3 != 9 && i3 != 10 && i3 != 8 && i3 != 14 && i3 != 5 && i3 != 13 && i3 != 12) {
                    Y4();
                } else {
                    this.X0.setSelectedTab(i3);
                }
            } else {
                this.X0.setSelectedTab(this.f206220z1);
            }
        } else if (7 != this.f206215u1) {
            if (this.f206219y1 <= 0) {
                Y4();
            } else {
                this.X0.setSelectedTab(this.f206220z1);
            }
        } else {
            int i17 = this.f206220z1;
            if (i17 != -1) {
                this.X0.setSelectedTab(i17);
            } else {
                this.X0.setSelectedTab(9);
            }
        }
        this.X0.setVisibility(0);
    }

    private void C4() {
        this.f206198d1 = (RadioButton) findViewById(R.id.f166138eg0);
        this.f206199e1 = (RadioButton) findViewById(R.id.f166757i12);
        this.f206200f1 = (RadioButton) findViewById(R.id.f164824b00);
        this.f206201g1 = (RadioButton) findViewById(R.id.v0v);
        k4();
    }

    private void D4() {
        this.f206196b1 = new b();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void E4() {
        int i3;
        int i16;
        if (QLog.isColorLevel()) {
            QLog.d("FMActivity<FileAssistant>", 2, "initRecentTabView");
        }
        this.f206168b0.setTabType(0);
        this.X0.v();
        String str = this.f206213s1;
        if (str != null && str.trim().length() != 0) {
            this.X0.setUin(this.f206213s1);
        }
        if (this.O0) {
            this.X0.setTabTitleList(new String[]{getString(R.string.bab)});
            this.X0.d(4, getString(R.string.bab));
        } else if (!this.A0 && (i3 = this.f206216v1) != 1025 && i3 != 1024) {
            this.X0.setTabTitleList(new String[]{getString(R.string.ba_), getString(R.string.bab), getString(R.string.f186953so), getString(R.string.baf), getString(R.string.bac), getString(R.string.baa)});
            this.X0.e(3, getString(R.string.ba_));
            this.X0.e(4, getString(R.string.bab));
            this.X0.e(21, getString(R.string.f186953so));
            this.X0.e(5, getString(R.string.baf));
            this.X0.e(6, getString(R.string.bac));
            this.X0.e(7, getString(R.string.baa));
        } else {
            this.X0.setTabTitleList(new String[]{getString(R.string.ba_), getString(R.string.bab), getString(R.string.baf), getString(R.string.bac), getString(R.string.baa)});
            this.X0.d(3, getString(R.string.ba_));
            this.X0.d(4, getString(R.string.bab));
            this.X0.d(5, getString(R.string.baf));
            this.X0.d(6, getString(R.string.bac));
            this.X0.d(7, getString(R.string.baa));
        }
        if (this.O0) {
            this.X0.setSelectedTab(4);
        } else if (this.f206210p1 && this.f206188v0 == 0 && (i16 = this.f206212r1) >= 3 && i16 <= 7) {
            this.X0.setSelectedTab(i16);
        } else {
            this.X0.setSelectedTab(3);
        }
        b5(1);
        this.X0.setVisibility(0);
        QfileTabBarView qfileTabBarView = this.X0;
        if (qfileTabBarView.f209464d == 1) {
            qfileTabBarView.w(8);
        }
    }

    private void F4(int i3) {
        QfileTabBarView qfileTabBarView = (QfileTabBarView) findViewById(R.id.c_l);
        this.X0 = qfileTabBarView;
        int i16 = 2;
        qfileTabBarView.setAttribution(2);
        if (!this.A0) {
            QfileTabBarView qfileTabBarView2 = this.X0;
            if (this.f206192z0) {
                i16 = 1;
            }
            qfileTabBarView2.setWYSubAppId(i16);
        }
        if (p3()) {
            this.X0.setMemory(true);
        }
        c5();
        if (p3() && i3 != 5 && i3 != 8 && !this.E0) {
            this.f206197c1 = (RadioGroup) findViewById(R.id.f166758i14);
            H4();
            if (!O4()) {
                this.f206197c1.removeView(this.f206201g1);
            }
            if (this.A0) {
                this.f206197c1.removeView(this.f206200f1);
            }
            a5();
            if (m4() || l4()) {
                return;
            }
        }
        if (this.f206217w1) {
            findViewById(R.id.f166758i14).setVisibility(8);
            findViewById(R.id.efw).setVisibility(0);
        }
        f3();
        this.f206185s0 = getString(R.string.f187173t_);
        I4(i3);
    }

    private void G4() {
        if (this.H0 == null) {
            this.f206185s0 = getString(R.string.b68);
        }
        setTitle(this.f206185s0);
        RadioGroup radioGroup = this.f206197c1;
        if (radioGroup != null && radioGroup.getVisibility() == 0) {
            this.f206198d1.setChecked(true);
        }
        B4();
        if (p3() && (this.E0 || this.f206188v0 == 5)) {
            this.f206203i1 = (TextView) findViewById(R.id.ivTitleBtnLeft);
            setLeftViewName(R.string.ba_);
            this.f206203i1.setOnClickListener(this);
            if (this.f206219y1 <= 0 && this.Y0 != 1) {
                this.f206203i1.setVisibility(0);
            } else {
                this.f206203i1.setVisibility(4);
                this.f206203i1.setOnClickListener(null);
            }
            SharedPreferences.Editor edit = this.D0.getApplicationContext().getSharedPreferences("aio_last_select_file", 0).edit();
            edit.putInt("last_select_tab_type", 1);
            edit.commit();
        }
        if (P2() == 8) {
            this.f206203i1.setVisibility(4);
        }
    }

    private void H4() {
        this.f206197c1.setVisibility(0);
        ImageView imageView = this.f206202h1;
        if (imageView != null) {
            imageView.setVisibility(8);
        }
        if (this.f206196b1 == null) {
            D4();
        }
        this.f206197c1.setOnCheckedChangeListener(this.f206196b1);
    }

    private void I4(int i3) {
        if (i3 != 0) {
            if (i3 != 1) {
                if (i3 != 2 && i3 != 3) {
                    if (i3 != 5) {
                        if (i3 != 6 && i3 != 7) {
                            if (i3 != 8) {
                                if (i3 == 1408041718) {
                                    String string = getString(R.string.zyh);
                                    this.f206185s0 = string;
                                    setTitle(string);
                                    RadioGroup radioGroup = this.f206197c1;
                                    if (radioGroup != null && radioGroup.getVisibility() == 0) {
                                        this.f206201g1.setChecked(true);
                                    }
                                    y4();
                                    return;
                                }
                                return;
                            }
                            String qqStr = HardCodeUtil.qqStr(R.string.f186843sd);
                            this.f206185s0 = qqStr;
                            setTitle(qqStr);
                            TextView textView = (TextView) findViewById(R.id.ivTitleBtnLeft);
                            this.f206203i1 = textView;
                            if (textView != null) {
                                textView.setContentDescription(HardCodeUtil.qqStr(R.string.f170549u3));
                            }
                            setLeftViewName(R.string.f170549u3);
                            getRightTextView().setVisibility(8);
                            x4();
                            return;
                        }
                    }
                } else {
                    String string2 = getString(R.string.b7s);
                    this.f206185s0 = string2;
                    setTitle(string2);
                    RadioGroup radioGroup2 = this.f206197c1;
                    if (radioGroup2 != null && radioGroup2.getVisibility() == 0) {
                        this.f206200f1.setChecked(true);
                    }
                    v4(i3);
                    return;
                }
            } else {
                this.f206185s0 = this.H0;
                if (P4()) {
                    this.f206209o1.setVisibility(0);
                }
            }
            G4();
            return;
        }
        this.f206185s0 = getString(R.string.a0v);
        setTitle(this.f206185s0);
        RadioGroup radioGroup3 = this.f206197c1;
        if (radioGroup3 != null && radioGroup3.getVisibility() == 0) {
            this.f206199e1.setChecked(true);
        }
        E4();
    }

    private void J4() {
        this.X0.v();
        if (this.f206219y1 <= 0) {
            if (this.Y0 == 1) {
                L4();
                return;
            }
            this.X0.setTabTitleList(new String[]{getString(R.string.bac), getString(R.string.baf), getString(R.string.bab), getString(R.string.baa), getString(R.string.bae)});
            this.X0.d(11, getString(R.string.bac));
            this.X0.d(9, getString(R.string.baf));
            this.X0.d(10, getString(R.string.bab));
            this.X0.d(8, getString(R.string.baa));
            this.X0.d(14, getString(R.string.bae));
            return;
        }
        ArrayList arrayList = new ArrayList();
        this.X0.setTabTitleList(new String[]{getString(R.string.bab), getString(R.string.baf), getString(R.string.bah), getString(R.string.bad)});
        if (i4(8)) {
            this.X0.d(10, getString(R.string.bab));
            arrayList.add(10);
        }
        if (i4(4)) {
            this.X0.d(9, getString(R.string.baf));
            arrayList.add(9);
        }
        if (i4(2)) {
            this.X0.d(13, getString(R.string.bah));
            arrayList.add(13);
        }
        if (i4(1)) {
            this.X0.d(12, getString(R.string.bad));
            arrayList.add(12);
        }
        if (arrayList.size() == 1) {
            this.X0.w(8);
        }
    }

    private void L4() {
        ArrayList<String> arrayList = this.Z0;
        if (arrayList != null && !arrayList.contains("all")) {
            int size = this.Z0.size();
            String[] strArr = new String[size];
            for (int i3 = 0; i3 < size; i3++) {
                strArr[i3] = o4(this.Z0.get(i3));
            }
            this.X0.setTabTitleList(strArr);
            Iterator<String> it = this.Z0.iterator();
            while (it.hasNext()) {
                String next = it.next();
                this.X0.d(n4(next), o4(next));
            }
            this.f206212r1 = n4(this.Z0.get(0));
        } else {
            this.X0.setTabTitleList(new String[]{t4(R.string.bab), t4(R.string.bac), t4(R.string.baf), t4(R.string.bae)});
            this.X0.d(10, t4(R.string.bab));
            this.X0.d(11, t4(R.string.bac));
            this.X0.d(9, t4(R.string.baf));
            this.X0.d(14, t4(R.string.bae));
        }
        QfileTabBarView qfileTabBarView = this.X0;
        if (qfileTabBarView.f209464d == 1) {
            LinearLayout linearLayout = (LinearLayout) qfileTabBarView.findViewById(R.id.yir);
            if (linearLayout != null) {
                linearLayout.setBackgroundColor(16777215);
            }
            View findViewById = this.X0.findViewById(R.id.f1186674r);
            if (findViewById != null) {
                findViewById.setVisibility(8);
            }
            this.X0.w(8);
        }
    }

    private boolean M4(SharedPreferences sharedPreferences) {
        if (!p3() || this.f206188v0 == 5 || !sharedPreferences.getBoolean("last_select_All", false) || !sharedPreferences.getBoolean("last_select_send", false)) {
            return false;
        }
        return true;
    }

    private boolean N4(Intent intent, boolean z16) {
        if (!z16 && !this.f206192z0 && this.f206188v0 != 5 && !this.f206190x0 && (intent == null || intent.getIntExtra("approval_attachment_customid", -1) == -1)) {
            return false;
        }
        return true;
    }

    private boolean O4() {
        int i3 = this.C1;
        if (i3 == 1 || i3 == 3 || i3 == 11 || i3 == 4) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean P4() {
        if (this.f206216v1 == 0 && this.f206192z0 && ((IQlinkUtils) QRoute.api(IQlinkUtils.class)).isAllowToQLink()) {
            return true;
        }
        return false;
    }

    private void Q4() {
        if (this.f206189w0 || this.f206191y0) {
            if (QLog.isColorLevel()) {
                QLog.w("FMActivity<FileAssistant>", 2, "registerQlinkFinishFMReceiver");
            }
            if (this.E1 == null) {
                this.E1 = new d();
                IntentFilter intentFilter = new IntentFilter();
                intentFilter.addAction("com.tencent.qlink.destory.fmactivity");
                this.D0.getApplicationContext().registerReceiver(this.E1, intentFilter);
            }
        }
    }

    private void U4(int i3) {
        int i16;
        if (p3() && (i16 = this.f206188v0) != 5 && i16 != 8 && i16 != 6 && !this.E0) {
            E3(R.layout.alj);
            ((LinearLayout) findViewById(R.id.c_q)).setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
            if (ImmersiveUtils.isSupporImmersive() == 1) {
                r3();
                return;
            }
            return;
        }
        setContentView(R.layout.alj);
        ((RelativeLayout) findViewById(R.id.idz)).setVisibility(8);
    }

    private void V4(Bundle bundle) {
        String str;
        if (this.Y0 == 1) {
            bundle.putInt("file_choose_extension_handle_type", 1);
            ArrayList<String> arrayList = this.Z0;
            if (arrayList == null || arrayList.contains("all")) {
                str = "";
            } else {
                Iterator<String> it = this.Z0.iterator();
                str = "";
                while (it.hasNext()) {
                    str = str + S4(it.next());
                }
            }
            bundle.putString("file_choose_extension_in_filter", str);
            bundle.putString("file_choose_extension_out_filter", "");
        }
    }

    private void X4(Intent intent) {
        if (this.Y0 == 1) {
            K3(true);
            R3(10006);
            C3(7);
            this.Z0 = intent.getStringArrayListExtra("file_type");
            f.M(intent.getIntExtra("file_number_limit", 20));
            HashMap<String, e> hashMap = new HashMap<>();
            this.H1 = hashMap;
            hashMap.put(QAdVrReportParams.ParamKey.MEDIA, new e(".swf|.mov|.mp4|.3gp|.avi|.rmvb|.wmf|.mpg|.rm|.asf|.mpeg|.mkv|.wmv|.flv|.f4v|.webm|.mod|.mpe|.fla|.m4r|.m4u|.m4v|.vob|.mp3|.wav|.m4a|.wave|.midi|.wma|.ogg|.ape|.acc|.aac|.aiff|.mid|.xmf|.rtttl|.flac|.amr|.mp2|.m3u|.m4b|.m4p.mpga|", 11, t4(R.string.bac)));
            this.H1.put("image", new e(".jpg|.bmp|.jpeg|.gif|.png|.ico|", 9, t4(R.string.baf)));
            this.H1.put("file", new e(".doc|.docx|.wps|.pages|.ppt|.pptx|.dps|.keynote|.xls|.xlsx|.et|.numbers|.pdf|", 10, t4(R.string.bab)));
            this.H1.put("video", new e(".swf|.mov|.mp4|.3gp|.avi|.rmvb|.wmf|.mpg|.rm|.asf|.mpeg|.mkv|.wmv|.flv|.f4v|.webm|.mod|.mpe|.fla|.m4r|.m4u|.m4v|.vob|", 13, t4(R.string.bah)));
            this.H1.put("audio", new e(".mp3|.wav|.m4a|.wave|.midi|.wma|.ogg|.ape|.acc|.aac|.aiff|.mid|.xmf|.rtttl|.flac|.amr|.mp2|.m3u|.m4b|.m4p.mpga|", 12, t4(R.string.bad)));
        }
    }

    private void Y4() {
        if (this.Y0 == 1) {
            ArrayList<String> arrayList = this.Z0;
            if (arrayList != null && !arrayList.contains("all")) {
                this.X0.setSelectedTab(n4(this.Z0.get(0)));
                return;
            } else {
                this.X0.setSelectedTab(10);
                return;
            }
        }
        this.X0.setSelectedTab(11);
    }

    private void Z4() {
        if (this.E1 != null) {
            this.D0.getApplicationContext().unregisterReceiver(this.E1);
            this.E1 = null;
        }
    }

    private void a5() {
        if (FontSettingManager.getFontLevel() > 17.0f) {
            float f16 = getResources().getDisplayMetrics().density;
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams((int) (s4() * f16), (int) (f16 * 30.0f));
            this.f206200f1.setLayoutParams(layoutParams);
            this.f206200f1.setTextSize(14.0f);
            if (O4()) {
                this.f206201g1.setLayoutParams(layoutParams);
                this.f206201g1.setTextSize(14.0f);
            }
            this.f206198d1.setLayoutParams(layoutParams);
            this.f206198d1.setTextSize(14.0f);
            this.f206199e1.setLayoutParams(layoutParams);
            this.f206199e1.setTextSize(14.0f);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b5(int i3) {
        String string;
        if (!h4()) {
            if (this.f206204j1.getVisibility() == 0) {
                this.f206204j1.setVisibility(8);
            }
            this.D1 = 0;
            return;
        }
        if (i3 == 0) {
            this.f206204j1.setVisibility(8);
            this.D1 = 0;
            return;
        }
        if (i3 != 1) {
            if (i3 != 2) {
                if (i3 != 3) {
                    if (i3 != 4) {
                        string = "";
                    } else {
                        string = getString(R.string.w0d);
                        this.D1 = 4;
                    }
                } else {
                    string = getString(R.string.w0e);
                    this.D1 = 3;
                }
            } else {
                string = getString(R.string.w0a);
                this.D1 = 2;
            }
        } else {
            string = getString(R.string.w0b);
            this.D1 = 1;
        }
        if (!TextUtils.isEmpty(string)) {
            this.f206204j1.setVisibility(0);
            this.f206206l1.setText(string);
        } else {
            this.f206204j1.setVisibility(8);
            this.D1 = 0;
        }
    }

    private void c5() {
        if ("FileAssistant".equalsIgnoreCase(getIntent().getStringExtra("from"))) {
            setLeftViewName(R.string.b7l);
            return;
        }
        String str = this.f206213s1;
        if (str != null && str.trim().length() != 0 && this.f206214t1 != -1) {
            setLeftViewName(R.string.a1l);
        } else {
            setLeftViewName(R.string.f170549u3);
        }
    }

    public static void fileChooseLaunchForResult(Activity activity, int i3, int i16, ArrayList<String> arrayList) {
        Intent intent = new Intent(activity, (Class<?>) FMActivity.class);
        intent.putExtra("mini_file_paths_support", 1);
        intent.putExtra("file_number_limit", i16);
        intent.putExtra("file_type", arrayList);
        intent.putExtra("tab_tab_type", 5);
        intent.putExtra("qlinkselect", true);
        intent.putExtra("qfile_entrance_type_key", 1);
        try {
            activity.startActivityForResult(intent, i3);
        } catch (Exception e16) {
            e16.printStackTrace();
        }
    }

    private boolean h4() {
        int i3 = this.C1;
        boolean z16 = true;
        if (i3 != 11 && i3 != 1 && i3 != 3 && i3 != 5 && i3 != 4 && i3 != 20) {
            z16 = false;
        }
        if (!r3()) {
            return false;
        }
        return z16;
    }

    private boolean l4() {
        if (this.f206210p1 || this.f206211q1) {
            return false;
        }
        this.f206198d1.setChecked(true);
        B4();
        SharedPreferences.Editor edit = this.D0.getApplicationContext().getSharedPreferences("aio_last_select_file", 0).edit();
        edit.putInt("last_select_tab_type", 1);
        edit.commit();
        if (P4()) {
            this.f206209o1.setVisibility(0);
        }
        if (this.O0) {
            this.f206197c1.removeView(this.f206200f1);
            if (O4()) {
                this.f206197c1.removeView(this.f206201g1);
            }
        }
        return true;
    }

    private boolean m4() {
        if (!this.f206211q1) {
            return false;
        }
        this.f206199e1.setChecked(true);
        E4();
        SharedPreferences.Editor edit = this.D0.getApplicationContext().getSharedPreferences("aio_last_select_file", 0).edit();
        edit.putInt("last_select_tab_type", 0);
        edit.commit();
        if (P4()) {
            this.f206209o1.setVisibility(0);
        }
        return true;
    }

    private int n4(String str) {
        HashMap<String, e> hashMap = this.H1;
        if (hashMap != null) {
            return hashMap.get(str).f206227b;
        }
        return -1;
    }

    private String o4(String str) {
        HashMap<String, e> hashMap = this.H1;
        if (hashMap != null) {
            return hashMap.get(str).f206228c;
        }
        return "";
    }

    private void r4(Intent intent) {
        boolean z16;
        if (intent != null) {
            z16 = intent.getBooleanExtra("needRemember", false);
        } else {
            z16 = false;
        }
        SharedPreferences sharedPreferences = this.D0.getApplication().getSharedPreferences("aio_last_select_file", 0);
        if (M4(sharedPreferences)) {
            this.f206211q1 = true;
        } else if (N4(intent, z16)) {
            if (this.f206188v0 == -1) {
                this.f206188v0 = sharedPreferences.getInt("last_select_tab_type", -1);
            }
            int i3 = sharedPreferences.getInt("last_select_tab_view", -1);
            this.f206212r1 = i3;
            if (this.f206188v0 != -1 && i3 != -1) {
                this.f206210p1 = true;
            }
        }
        if (!O4() && this.f206188v0 == 1408041718) {
            this.f206188v0 = 7;
        }
        if (this.A0 && this.f206188v0 == 2) {
            this.f206188v0 = 7;
        }
        if (intent != null) {
            w4(intent.getIntExtra("smart_device_switch_tab_flag", 0));
        }
        SharedPreferences.Editor edit = sharedPreferences.edit();
        edit.putBoolean("last_select_All", false);
        edit.putBoolean("last_select_send", false);
        edit.commit();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void u4() {
        ArrayList<String> arrayList;
        Set<FileInfo> n3 = f.n();
        if (n3 != null && n3.size() > 0) {
            arrayList = new ArrayList<>();
            Iterator<FileInfo> it = n3.iterator();
            while (it.hasNext()) {
                arrayList.add(it.next().k());
            }
        } else {
            arrayList = null;
        }
        ((IQQFileEngine) this.D0.getRuntimeService(IQQFileEngine.class)).requestSendQlinkFile(this, arrayList, this.f206218x1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void v4(int i3) {
        if (QLog.isColorLevel()) {
            QLog.d("FMActivity<FileAssistant>", 2, "initCloudTabView");
        }
        ReportController.o(this.D0, "dc00898", "", "", "0X8009E60", "0X8009E60", 0, 0, "", "", "", "");
        b5(0);
        this.D1 = 3;
        if (3 == i3) {
            e3();
        }
        this.f206167a0.setVisibility(8);
        VerifyPwdView verifyPwdView = this.f206208n1;
        if (verifyPwdView != null) {
            verifyPwdView.d();
        }
        VerifyPwdView verifyPwdView2 = new VerifyPwdView(this);
        this.f206208n1 = verifyPwdView2;
        this.B1 = verifyPwdView2.e(this.f206207m1, new c(i3));
        this.f206208n1.g();
        this.f206207m1.addView(this.B1);
        this.B1.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
    }

    private void w4(int i3) {
        if (i3 != 8 && i3 != 1 && i3 != 2 && i3 != 4) {
            this.f206220z1 = 10;
            return;
        }
        if (i3 == 8 && i4(8)) {
            this.f206220z1 = 10;
            return;
        }
        if (i3 == 1 && i4(1)) {
            this.f206220z1 = 12;
            return;
        }
        if (i3 == 2 && i4(2)) {
            this.f206220z1 = 13;
        } else if (i3 == 4 && i4(4)) {
            this.f206220z1 = 9;
        } else {
            this.f206220z1 = 10;
        }
    }

    private void x4() {
        if (QLog.isColorLevel()) {
            QLog.d("FMActivity<FileAssistant>", 2, "initDownloadedTabView");
        }
        this.f206167a0.setSelectedAllMode();
        f3();
        this.X0.v();
        this.X0.setTabTitleList(new String[]{getString(R.string.bah), getString(R.string.baf), getString(R.string.bab), getString(R.string.baa), getString(R.string.bae)});
        this.X0.d(119, getString(R.string.baf));
        this.X0.d(111, getString(R.string.bah));
        this.X0.d(110, getString(R.string.bab));
        this.X0.d(118, getString(R.string.baa));
        this.X0.d(114, getString(R.string.bae));
        this.X0.setSelectedTab(119);
        this.X0.setVisibility(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void y4() {
        int i3;
        if (QLog.isColorLevel()) {
            QLog.d("FMActivity<FileAssistant>", 2, "initFavTabView");
        }
        this.f206168b0.setTabType(0);
        this.X0.v();
        String str = this.f206213s1;
        if (str != null && str.trim().length() != 0) {
            this.X0.setUin(this.f206213s1);
        }
        this.X0.setTabTitleList(new String[]{getString(R.string.bac), getString(R.string.baf), getString(R.string.bab), getString(R.string.baa), getString(R.string.bae)});
        this.X0.d(1200, getString(R.string.bac));
        this.X0.d(1201, getString(R.string.baf));
        this.X0.d(1202, getString(R.string.bab));
        this.X0.d(1203, getString(R.string.baa));
        this.X0.d(1204, getString(R.string.bae));
        if (this.f206210p1 && (i3 = this.f206212r1) >= 1200 && i3 <= 1204) {
            this.X0.setSelectedTab(i3);
        } else {
            this.X0.setSelectedTab(1200);
        }
        this.X0.setVisibility(0);
        QfileTabBarView qfileTabBarView = this.X0;
        if (qfileTabBarView.f209464d == 1) {
            qfileTabBarView.w(8);
        }
        ReportController.o(this.D0, "dc00898", "", "", "0X800AFA7", "0X800AFA7", 0, 0, "", "", "", "");
    }

    private void z4() {
        if (r3()) {
            if (this.f206202h1 == null) {
                this.f206202h1 = (ImageView) findViewById(R.id.efy);
            }
            this.f206202h1.setOnClickListener(this);
            this.f206202h1.setVisibility(0);
            if (this.f206219y1 <= 0 && this.Y0 == -1) {
                this.f206202h1.setVisibility(0);
            } else {
                this.f206202h1.setVisibility(4);
                this.f206202h1.setOnClickListener(null);
            }
            f3();
            return;
        }
        W3(this);
        ImageView imageView = this.f206202h1;
        if (imageView != null) {
            imageView.setVisibility(8);
        }
    }

    @Override // com.tencent.mobileqq.filemanager.activity.BaseFileAssistantActivity
    protected void B3() {
        this.X0.u();
    }

    @Override // com.tencent.mobileqq.filemanager.activity.BaseFileAssistantActivity
    public void G2(ArrayList<FileManagerEntity> arrayList) {
        this.X0.a(arrayList);
    }

    @Override // com.tencent.mobileqq.filemanager.activity.BaseFileAssistantActivity
    public void H2(boolean z16) {
        int i3;
        if (this.X0 == null) {
            return;
        }
        if (z16) {
            i3 = this.f206168b0.getLayoutParams().height;
        } else {
            i3 = 0;
        }
        this.X0.setTabFrameHeight(getResources().getDisplayMetrics().heightPixels - i3);
    }

    @Override // com.tencent.mobileqq.filemanager.activity.BaseFileAssistantActivity
    public void J2(ArrayList<FileManagerEntity> arrayList) {
        this.X0.j(arrayList);
    }

    @Override // com.tencent.mobileqq.filemanager.activity.BaseFileAssistantActivity
    public void K2(ArrayList<WeiYunFileInfo> arrayList) {
        this.X0.k(arrayList);
    }

    @Override // com.tencent.mobileqq.filemanager.activity.BaseFileAssistantActivity
    public void L2(Set<FileInfo> set) {
        this.X0.l(set);
    }

    public String S4(String str) {
        HashMap<String, e> hashMap = this.H1;
        if (hashMap != null) {
            return hashMap.get(str).f206226a;
        }
        return "";
    }

    @Override // com.tencent.mobileqq.filemanager.activity.BaseFileAssistantActivity
    public void T3(int i3) {
        QfileTabBarView qfileTabBarView = this.X0;
        if (qfileTabBarView == null) {
            super.T3(i3);
        } else {
            qfileTabBarView.setSortType(i3);
        }
    }

    @Override // com.tencent.mobileqq.filemanager.activity.BaseFileAssistantActivity
    public void U3(com.tencent.mobileqq.filemanager.activity.fileassistant.a aVar) {
        this.f206195a1 = aVar;
        if (this.f206188v0 == 8) {
            this.f206167a0.setSelectEvent(aVar);
        }
    }

    @Override // com.tencent.mobileqq.filemanager.activity.BaseFileAssistantActivity
    public int Y2() {
        QfileTabBarView qfileTabBarView = this.X0;
        if (qfileTabBarView == null) {
            return super.Y2();
        }
        return qfileTabBarView.q();
    }

    @Override // com.tencent.mobileqq.filemanager.activity.BaseFileAssistantActivity
    public int[] b3() {
        QfileTabBarView qfileTabBarView = this.X0;
        if (qfileTabBarView == null) {
            return null;
        }
        return qfileTabBarView.r();
    }

    @Override // com.tencent.mobileqq.filemanager.activity.BaseFileAssistantActivity, com.tencent.mobileqq.app.QIphoneTitleBarActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity, android.view.Window.Callback
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        EventCollector.getInstance().onActivityDispatchTouchEvent(this, motionEvent, false, true);
        SendBottomBar sendBottomBar = this.f206167a0;
        if (sendBottomBar != null) {
            sendBottomBar.c0();
            if (motionEvent.getAction() == 0) {
                this.F1 = motionEvent.getX();
                this.G1 = motionEvent.getY();
            } else if (motionEvent.getAction() == 2 && motionEvent.getY() - this.G1 < -200.0f && Math.abs(motionEvent.getX() - this.F1) < 200.0f) {
                this.f206167a0.K(false);
            }
        }
        boolean dispatchTouchEvent = super.dispatchTouchEvent(motionEvent);
        EventCollector.getInstance().onActivityDispatchTouchEvent(this, motionEvent, dispatchTouchEvent, false);
        return dispatchTouchEvent;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.filemanager.activity.BaseFileAssistantActivity, mqq.app.AppActivity
    public void doOnActivityResult(int i3, int i16, Intent intent) {
        String str;
        if (i3 == 9999) {
            if (intent == null) {
                return;
            }
            if (intent.getIntExtra("qfile_send_bottom_bar_finish_result_code", 0) == -1) {
                setResult(i16, new Intent(intent));
                finish();
            }
        }
        if (i16 == -1 && (str = this.f206213s1) != null && str.trim().length() != 0) {
            if ((intent != null && intent.getExtras() != null && (intent.getBooleanExtra("foward_editbar", false) || intent.getBooleanExtra("destroy_last_activity", false))) || i16 == 4) {
                ((IQQFileTempUtils) QRoute.api(IQQFileTempUtils.class)).openAIO(this, intent);
                finish();
                return;
            }
            return;
        }
        super.doOnActivityResult(i3, i16, intent);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.filemanager.activity.BaseFileAssistantActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity
    public boolean doOnCreate(Bundle bundle) {
        boolean z16;
        long uptimeMillis = SystemClock.uptimeMillis();
        long j3 = I1 + 1;
        I1 = j3;
        this.A1 = j3;
        f.k();
        super.doOnCreate(bundle);
        Intent intent = getIntent();
        this.f206188v0 = intent.getIntExtra("tab_tab_type", -1);
        this.f206215u1 = intent.getIntExtra(IPublicAccountHttpDownloader.BUSI_TYPE_PARAM_KEY, -1);
        this.f206213s1 = intent.getStringExtra("uin");
        this.f206214t1 = intent.getIntExtra("uintype", -1);
        this.f206189w0 = intent.getBooleanExtra("from_qlink", false);
        this.f206192z0 = intent.getBooleanExtra("from_aio", false);
        this.f206216v1 = intent.getIntExtra("peerType", -1);
        this.f206217w1 = intent.getBooleanExtra("is_from_file_folder", false);
        this.Y0 = intent.getIntExtra("mini_file_paths_support", -1);
        X4(intent);
        this.C1 = intent.getIntExtra("qfile_entrance_type_key", 0);
        this.f206218x1 = getIntent().getStringExtra(IProfileProtocolConst.PARAM_TARGET_UIN);
        if (QLog.isColorLevel()) {
            QLog.d("FMActivity<FileAssistant>", 2, "doOnCreate type[" + this.f206188v0 + "],select[" + p3() + "]");
        }
        this.f206190x0 = AppConstants.DATALINE_PC_UIN.equalsIgnoreCase(this.f206218x1);
        if (this.f206216v1 == 10014) {
            z16 = true;
        } else {
            z16 = false;
        }
        this.A0 = z16;
        if (z16) {
            this.B0 = intent.getStringExtra("srcDiscGroup");
            this.C0 = intent.getStringExtra(IProfileProtocolConst.PARAM_TARGET_UIN);
        }
        this.f206219y1 = 0;
        r4(intent);
        if (!TextUtils.isEmpty(this.f206213s1) && this.f206214t1 == -1) {
            J3(true);
        }
        U4(getResources().getDisplayMetrics().heightPixels);
        this.f206207m1 = (RelativeLayout) findViewById(R.id.elg);
        LinearLayout linearLayout = (LinearLayout) findViewById(R.id.gme);
        this.f206209o1 = linearLayout;
        linearLayout.setOnClickListener(new a());
        this.f206204j1 = findViewById(R.id.iwd);
        RelativeLayout relativeLayout = (RelativeLayout) findViewById(R.id.f166946jb3);
        this.f206205k1 = relativeLayout;
        relativeLayout.setOnClickListener(this);
        this.f206206l1 = (TextView) findViewById(R.id.ijx);
        b5(0);
        if (!TextUtils.isEmpty(this.f206213s1) && this.f206214t1 == -1) {
            setLeftViewName(R.string.f170549u3);
            TextView textView = this.rightViewText;
            if (textView != null) {
                textView.setVisibility(8);
            }
        }
        C4();
        F4(this.f206188v0);
        ((IQQFileEngine) this.D0.getRuntimeService(IQQFileEngine.class)).clearNewDownload();
        Q4();
        ((IQQFileEngine) this.D0.getRuntimeService(IQQFileEngine.class)).initAppStoreSDK();
        this.f206167a0.setSendBtnPadding(16);
        TextView textView2 = (TextView) super.findViewById(R.id.ivTitleBtnRightText);
        if (textView2 != null) {
            textView2.setTextColor(getResources().getColor(R.color.qui_common_text_nav_secondary));
        }
        TextView textView3 = this.leftView;
        if (textView3 != null && this.centerView != null && this.rightViewText != null && AppSetting.f99565y) {
            AccessibilityUtil.p(textView3, getString(R.string.button_back));
            this.leftView.setAccessibilityTraversalBefore(R.id.ivTitleName);
            this.centerView.setAccessibilityTraversalBefore(R.id.ivTitleBtnRightText);
            this.rightViewText.setAccessibilityTraversalBefore(R.id.c_l);
        }
        p.b(SystemClock.uptimeMillis() - uptimeMillis);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.filemanager.activity.BaseFileAssistantActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity
    public void doOnDestroy() {
        super.doOnDestroy();
        if (QLog.isColorLevel() && !isFinishing()) {
            QLog.i("FMActivity<FileAssistant>", 2, "FMActiviy is called doOnDestroy But not finished!");
        }
        this.X0.m();
        VerifyPwdView verifyPwdView = this.f206208n1;
        if (verifyPwdView != null) {
            verifyPwdView.d();
        }
        if (this.A1 == I1) {
            f.k();
        }
        Z4();
        if (this.f206191y0) {
            this.D0.getApp().sendBroadcast(new Intent("com.tencent.qlink.selectfileover"));
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.filemanager.activity.BaseFileAssistantActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity
    public void doOnPause() {
        com.tencent.mobileqq.filemanager.activity.fileassistant.a aVar = this.f206195a1;
        if (aVar != null) {
            aVar.onPause();
        }
        super.doOnPause();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.filemanager.activity.BaseFileAssistantActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity
    public void doOnResume() {
        if (getIntent().getBooleanExtra("key_check_troop_privilege", false) && this.f206218x1 != null) {
            ((ITroopInfoRepoApi) QRoute.api(ITroopInfoRepoApi.class)).fetchTroopPhotoPrivilege(this.f206218x1, "FMActivity<FileAssistant>", this, null);
        }
        super.doOnResume();
    }

    @Override // com.tencent.mobileqq.filemanager.activity.BaseFileAssistantActivity, com.tencent.mobileqq.app.QBaseActivity, android.app.Activity
    public void finish() {
        super.finish();
        if (!p3() || this.f206188v0 == 8) {
            return;
        }
        overridePendingTransition(R.anim.f154422j, R.anim.f154423k);
    }

    @Override // com.tencent.mobileqq.filemanager.activity.BaseFileAssistantActivity
    public ListView getListView() {
        QfileTabBarView qfileTabBarView = this.X0;
        if (qfileTabBarView != null) {
            return qfileTabBarView.p();
        }
        return null;
    }

    public boolean i4(int i3) {
        if ((i3 & this.f206219y1) > 0) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.app.QBaseActivity
    /* renamed from: isWrapContent */
    public boolean getNeedGestureBack() {
        return false;
    }

    protected void k4() {
        ColorStateList colorStateList = getResources().getColorStateList(R.color.qui_header_tab_item_color);
        this.f206199e1.setTextColor(colorStateList);
        this.f206198d1.setTextColor(colorStateList);
        this.f206201g1.setTextColor(colorStateList);
        this.f206200f1.setTextColor(colorStateList);
        if (this.f206202h1 == null) {
            this.f206202h1 = (ImageView) findViewById(R.id.efy);
        }
        this.f206202h1.setColorFilter(new PorterDuffColorFilter(colorStateList.getDefaultColor(), PorterDuff.Mode.SRC_IN));
        ((TextView) findViewById(R.id.ily)).setTextColor(colorStateList);
        if (this.A0) {
            this.f206198d1.setBackgroundResource(R.drawable.lk9);
        } else {
            this.f206198d1.setBackgroundResource(R.drawable.lk_);
        }
        this.f206198d1.setPadding(0, 0, 0, 0);
        this.f206198d1.setGravity(17);
        this.f206200f1.setPadding(0, 0, 0, 0);
        this.f206200f1.setGravity(17);
        this.f206199e1.setPadding(0, 0, 0, 0);
        this.f206199e1.setGravity(17);
    }

    public int lc() {
        QfileTabBarView qfileTabBarView = this.X0;
        if (qfileTabBarView == null) {
            return -1;
        }
        return qfileTabBarView.o();
    }

    @Override // com.tencent.mobileqq.filemanager.activity.BaseFileAssistantActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        int i3;
        int i16;
        EventCollector.getInstance().onViewClickedBefore(view);
        super.onClick(view);
        if (w3()) {
            Q3();
            int i17 = 1;
            if (view.getId() != R.id.efy && view.getId() != R.id.ivTitleBtnLeft) {
                if (view.getId() == R.id.iim) {
                    Intent intent = new Intent(this, (Class<?>) FMLocalFileActivity.class);
                    intent.putExtra("STRING_Show_Music_Category", false);
                    intent.putExtra("STRING_Show_Video_Category", false);
                    intent.putExtra("STRING_Show_Apk_Category", false);
                    intent.putExtra("STRING_Show_Pic_Category", false);
                    intent.putExtra("STRING_Show_Driver_Category", false);
                    intent.putExtra("STRING_Show_First_Space", false);
                    intent.putExtra(t.f292401f, this.O0);
                    intent.putExtra(t.f292402g, this.P0);
                    intent.putExtra("qrlogin_appid", this.T0);
                    intent.putExtra("localSdCardfile", 1408041716);
                    intent.putExtra("STRING_Show_Download_Category", false);
                    U2().x();
                    startActivityForResult(intent, 20002);
                } else if (view.getId() == R.id.f166946jb3 && (i3 = this.D1) != 0) {
                    if (i3 != 1) {
                        i17 = 2;
                        if (i3 == 2) {
                            i16 = 17;
                        }
                    } else {
                        i16 = 16;
                    }
                    ReportController.o(null, "dc00898", "", "", "0X800AA90", "0X800AA90", i17, 0, "0", "0", "", "");
                    Bundle bundle = new Bundle();
                    bundle.putString("qfile_search_param_ex_params_target_uin", d3());
                    bundle.putString("qfile_search_param_ex_params_target_uid", c3());
                    bundle.putInt("qfile_search_param_exparams_peer_type", S2());
                    bundle.putInt("qfile_search_param_exparams_busi_type", P2());
                    bundle.putString("qfile_search_param_exparams_send_uin", Z2());
                    bundle.putInt("qfile_search_param_exparams_qlink_state", T2());
                    bundle.putBoolean("qfile_search_param_exparams_qlink_ap_created", M2());
                    V4(bundle);
                    ((IQQFileTempUtils) QRoute.api(IQQFileTempUtils.class)).startSeach(this, i16, bundle);
                }
            } else {
                Intent intent2 = new Intent(this, (Class<?>) FMLocalFileActivity.class);
                intent2.putExtra("STRING_Show_Music_Category", false);
                intent2.putExtra("STRING_Show_Video_Category", false);
                intent2.putExtra("STRING_Show_Apk_Category", false);
                intent2.putExtra("STRING_Show_Pic_Category", false);
                intent2.putExtra("STRING_Show_Driver_Category", false);
                intent2.putExtra("STRING_Show_First_Space", false);
                intent2.putExtra(t.f292401f, this.O0);
                intent2.putExtra(t.f292402g, this.P0);
                intent2.putExtra("qrlogin_appid", this.T0);
                intent2.putExtra("localSdCardfile", 1408041717);
                intent2.putExtra("STRING_Show_Download_Category", false);
                intent2.putExtra("STRING_Show_MyFile_Category", true);
                intent2.putExtra("select_file_support_send_docs_file", this.N0);
                intent2.putExtra("select_file_only_docs_file", this.f206167a0.Z());
                U2().i();
                startActivityForResult(intent2, 20001);
                overridePendingTransition(R.anim.f154891f2, R.anim.f154894f5);
            }
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    @Override // com.tencent.mobileqq.filemanager.activity.BaseFileAssistantActivity, com.tencent.mobileqq.app.QIphoneTitleBarActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        EventCollector.getInstance().onActivityConfigurationChanged(this, configuration);
    }

    @Override // com.tencent.mobileqq.app.QBaseActivity, com.tencent.mobileqq.app.ISkinCallback, com.tencent.theme.SkinnableActivityProcesser.Callback
    public void onPostThemeChanged() {
        super.onPostThemeChanged();
        k4();
    }

    @Override // android.app.Activity
    public void onRestart() {
        super.onRestart();
        com.tencent.mobileqq.filemanager.activity.fileassistant.a aVar = this.f206195a1;
        if (aVar != null) {
            aVar.onRestart();
        } else if (QLog.isColorLevel()) {
            QLog.w("FMActivity<FileAssistant>", 2, "onRestart but mUiEvent is null");
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // mqq.app.AppActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        if (f.s() > 0) {
            I2();
        }
        com.tencent.mobileqq.filemanager.activity.fileassistant.a aVar = this.f206195a1;
        if (aVar != null) {
            aVar.onResume();
        }
        super.onResume();
    }

    public int p4() {
        return this.Y0;
    }

    @Override // com.tencent.mobileqq.filemanager.activity.BaseFileAssistantActivity
    public void refreshUI() {
        super.refreshUI();
        this.X0.u();
    }

    int s4() {
        View findViewById;
        RadioGroup radioGroup = this.f206197c1;
        if (radioGroup == null || radioGroup.getChildCount() == 0 || (findViewById = findViewById(R.id.ily)) == null || findViewById.getVisibility() == 8) {
            return 55;
        }
        int i3 = getResources().getDisplayMetrics().widthPixels;
        float f16 = getResources().getDisplayMetrics().density;
        findViewById.measure(0, 0);
        int floor = (int) Math.floor(((i3 - (findViewById.getMeasuredWidth() * 2)) / this.f206197c1.getChildCount()) / f16);
        if (floor > 55) {
            return 55;
        }
        return Math.max(floor, 40);
    }

    public String t4(int i3) {
        return getString(i3);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.filemanager.activity.BaseFileAssistantActivity
    public void y3() {
        if (p3()) {
            ReportController.o(null, "dc00898", "", "", "0X800C3D2", "0X800C3D2", 0, 0, "", "", "", "");
        }
        super.y3();
    }

    @Override // com.tencent.mobileqq.filemanager.activity.BaseFileAssistantActivity
    public void z3() {
        super.z3();
        TextView textView = this.rightViewText;
        if (textView != null) {
            AccessibilityUtil.o(textView);
        }
    }
}

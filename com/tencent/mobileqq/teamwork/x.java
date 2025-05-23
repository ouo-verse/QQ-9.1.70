package com.tencent.mobileqq.teamwork;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.airbnb.lottie.LottieAnimationView;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.teamwork.api.ITeamWorkUtils;
import com.tencent.mobileqq.teamwork.bean.TeamWorkFileImportInfo;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.AutoVerticalScrollTextView;

/* compiled from: P */
/* loaded from: classes18.dex */
public class x {

    /* renamed from: a, reason: collision with root package name */
    Handler f292422a;

    /* renamed from: b, reason: collision with root package name */
    private View f292423b;

    /* renamed from: c, reason: collision with root package name */
    private TextView f292424c;

    /* renamed from: d, reason: collision with root package name */
    private TextView f292425d;

    /* renamed from: e, reason: collision with root package name */
    private View f292426e;

    /* renamed from: f, reason: collision with root package name */
    LottieAnimationView f292427f;

    /* renamed from: g, reason: collision with root package name */
    private TextView f292428g;

    /* renamed from: h, reason: collision with root package name */
    private TextView f292429h;

    /* renamed from: i, reason: collision with root package name */
    private TextView f292430i;

    /* renamed from: j, reason: collision with root package name */
    private TextView f292431j;

    /* renamed from: k, reason: collision with root package name */
    private AutoVerticalScrollTextView f292432k;

    /* renamed from: l, reason: collision with root package name */
    private TeamWorkFileImportInfo f292433l;

    /* renamed from: m, reason: collision with root package name */
    private String[] f292434m = new String[2];

    /* renamed from: n, reason: collision with root package name */
    private int f292435n = 1;

    /* renamed from: o, reason: collision with root package name */
    private RelativeLayout f292436o;

    /* renamed from: p, reason: collision with root package name */
    private Activity f292437p;

    /* renamed from: q, reason: collision with root package name */
    public AppInterface f292438q;

    /* renamed from: r, reason: collision with root package name */
    private View f292439r;

    /* renamed from: s, reason: collision with root package name */
    private LinearLayout f292440s;

    /* renamed from: t, reason: collision with root package name */
    private QQCustomDialog f292441t;

    public x(RelativeLayout relativeLayout, Activity activity, AppInterface appInterface) {
        this.f292436o = relativeLayout;
        this.f292437p = activity;
        this.f292438q = appInterface;
    }

    private void a() {
        QQCustomDialog qQCustomDialog = this.f292441t;
        if (qQCustomDialog != null) {
            if (qQCustomDialog.isShowing()) {
                try {
                    this.f292441t.dismiss();
                } catch (Exception e16) {
                    QLog.e("TeamWorkFileImportCover", 1, " dismiss exception: " + e16.toString());
                }
            }
            this.f292441t = null;
        }
    }

    public View b(Bundle bundle) {
        this.f292439r = LayoutInflater.from(BaseApplicationImpl.getApplication()).inflate(R.layout.c0d, (ViewGroup) this.f292436o, false);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
        layoutParams.addRule(3, R.id.rlCommenTitle);
        layoutParams.topMargin = -e();
        this.f292439r.setLayoutParams(layoutParams);
        this.f292436o.addView(this.f292439r, 1);
        this.f292436o.findViewById(R.id.rlCommenTitle).setBackgroundColor(-1);
        this.f292423b = d(R.id.jc9);
        this.f292424c = (TextView) d(R.id.jc6);
        this.f292425d = (TextView) d(R.id.jc5);
        this.f292426e = d(R.id.jc_);
        LottieAnimationView lottieAnimationView = (LottieAnimationView) d(R.id.f164333s8);
        this.f292427f = lottieAnimationView;
        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) lottieAnimationView.getLayoutParams();
        layoutParams2.height = ViewUtils.dpToPx(60.0f);
        layoutParams2.width = ViewUtils.dpToPx(60.0f);
        this.f292427f.setLayoutParams(layoutParams2);
        this.f292428g = (TextView) d(R.id.jca);
        this.f292429h = (TextView) d(R.id.jcb);
        this.f292430i = (TextView) d(R.id.iws);
        this.f292431j = (TextView) d(R.id.iy5);
        this.f292432k = (AutoVerticalScrollTextView) d(R.id.jc7);
        this.f292434m[0] = this.f292437p.getString(R.string.hxu);
        this.f292434m[1] = this.f292437p.getString(R.string.hxv);
        this.f292432k.setTextArray(this.f292434m);
        g(this.f292437p.getIntent(), this.f292437p);
        if (QLog.isColorLevel()) {
            QLog.i("teamConvert", 2, "show loading view start time [" + (System.currentTimeMillis() / 1000) + "]");
        }
        this.f292440s = (LinearLayout) LayoutInflater.from(BaseApplicationImpl.getApplication()).inflate(R.layout.c0_, (ViewGroup) this.f292436o, false);
        RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams3.addRule(14, -1);
        layoutParams3.addRule(12, -1);
        layoutParams3.bottomMargin = ViewUtils.dpToPx(12.0f);
        this.f292436o.addView(this.f292440s, layoutParams3);
        ((ITeamWorkUtils) QRoute.api(ITeamWorkUtils.class)).reportOnlinePreview(this.f292433l, null, "0X8009ED4");
        return this.f292439r;
    }

    public void c() {
        if (h()) {
            ((ITeamWorkUtils) QRoute.api(ITeamWorkUtils.class)).reportOnlinePreview(this.f292433l, null, "0X8009ED5");
        }
        this.f292438q = null;
        this.f292437p = null;
        this.f292436o = null;
        AutoVerticalScrollTextView autoVerticalScrollTextView = this.f292432k;
        if (autoVerticalScrollTextView != null) {
            autoVerticalScrollTextView.destroy();
        }
        this.f292427f.cancelAnimation();
        this.f292427f = null;
        a();
        this.f292422a = null;
        this.f292439r = null;
    }

    public View d(int i3) {
        return this.f292437p.findViewById(i3);
    }

    public int e() {
        return this.f292437p.getResources().getDimensionPixelSize(R.dimen.title_bar_height);
    }

    public void f() {
        String str;
        this.f292436o.findViewById(R.id.rlCommenTitle).setBackgroundColor(Color.parseColor("#f6f7f9"));
        this.f292439r.setVisibility(8);
        this.f292440s.setVisibility(8);
        if (QLog.isColorLevel()) {
            QLog.i("teamConvert", 2, "hide loading view finish time [" + (System.currentTimeMillis() / 1000) + "]");
        }
        long b16 = lr2.a.b("cover_loading_time");
        TeamWorkFileImportInfo teamWorkFileImportInfo = this.f292433l;
        if (teamWorkFileImportInfo == null) {
            str = "";
        } else {
            str = teamWorkFileImportInfo.X;
        }
        lr2.a.i(null, str, "0X8009E9C", String.valueOf(b16), "", "");
        if (this.f292433l != null) {
            lr2.a.m("TeamWorkFileImportCover", "cover_loading_time", String.valueOf(b16), this.f292433l.X);
        } else {
            lr2.a.l("TeamWorkFileImportCover", "cover_loading_time", String.valueOf(b16));
        }
    }

    public void g(Intent intent, Context context) {
        if (intent != null && intent.getExtras() != null) {
            intent.getExtras().setClassLoader(TeamWorkFileImportInfo.class.getClassLoader());
            TeamWorkFileImportInfo teamWorkFileImportInfo = (TeamWorkFileImportInfo) intent.getParcelableExtra(AppConstants.KEY_TEAM_WORK_FILE_IMPORT_INFO);
            this.f292433l = teamWorkFileImportInfo;
            if (teamWorkFileImportInfo != null) {
                if (teamWorkFileImportInfo.c()) {
                    this.f292428g.setText(context.getString(R.string.hyb));
                    this.f292429h.setText(context.getString(R.string.hyd));
                } else {
                    TeamWorkFileImportInfo teamWorkFileImportInfo2 = this.f292433l;
                    if (teamWorkFileImportInfo2.Y == 6) {
                        this.f292428g.setText(context.getString(R.string.vsr));
                        this.f292429h.setText(context.getString(R.string.vss));
                    } else {
                        int i3 = teamWorkFileImportInfo2.J;
                        if (i3 == 12) {
                            this.f292428g.setText(context.getString(R.string.vst));
                            this.f292429h.setText(context.getString(R.string.hyd));
                        } else if (i3 == 13) {
                            this.f292428g.setText(context.getString(R.string.w8l));
                            this.f292429h.setVisibility(8);
                            this.f292432k.setVisibility(8);
                            this.f292430i.setVisibility(0);
                            this.f292431j.setVisibility(0);
                        } else if (teamWorkFileImportInfo2.b()) {
                            this.f292428g.setText(context.getString(R.string.vst));
                            this.f292429h.setText(context.getString(R.string.hyd));
                        } else {
                            this.f292428g.setText(context.getString(R.string.hya));
                            this.f292429h.setText(context.getString(R.string.hyc));
                        }
                    }
                }
                this.f292435n = 2;
                this.f292427f.setAnimation("teamwork/tim_data_loading.json");
                this.f292427f.loop(true);
                if (NetworkUtil.isNetSupport(BaseApplication.getContext())) {
                    if (QLog.isColorLevel()) {
                        QLog.i("TeamWorkFileImportCover", 2, "tencentdoc log:---FileImport start, fileName\uff1a " + this.f292433l.f292074f + " ---");
                    }
                    lr2.a.k("cover_loading_time");
                    lr2.a.k("get_url_time");
                    this.f292427f.setVisibility(0);
                    this.f292427f.playAnimation();
                    TeamWorkFileImportInfo teamWorkFileImportInfo3 = this.f292433l;
                    if (teamWorkFileImportInfo3 != null && teamWorkFileImportInfo3.J == 9) {
                        lr2.a.j(null, "0X800A4B4");
                        return;
                    }
                    return;
                }
                QQToast.makeText(context, R.string.f171139ci4, 0).show(e());
                i(-1, null);
            }
        }
    }

    public boolean h() {
        View view = this.f292439r;
        if (view != null && view.getVisibility() == 0) {
            return true;
        }
        return false;
    }

    public void i(int i3, String str) {
        String str2;
        String str3;
        this.f292435n = 4;
        ((ITeamWorkUtils) QRoute.api(ITeamWorkUtils.class)).reportOnlinePreview(this.f292433l, null, "0X800A2F2");
        if (this.f292437p == null) {
            QLog.i("teamConvert", 1, "showFailedView, but activity is null");
            return;
        }
        LottieAnimationView lottieAnimationView = this.f292427f;
        if (lottieAnimationView != null) {
            lottieAnimationView.cancelAnimation();
            this.f292427f.setVisibility(8);
        }
        this.f292428g.setVisibility(8);
        this.f292429h.setVisibility(8);
        this.f292432k.setVisibility(8);
        this.f292426e.setVisibility(8);
        this.f292423b.setVisibility(0);
        if (i3 != 116 && i3 != -116) {
            if (i3 == 106) {
                String string = this.f292437p.getResources().getString(R.string.w8i);
                this.f292424c.setVisibility(8);
                this.f292425d.setText(string);
            } else if (Math.abs(i3) >= 100 && Math.abs(i3) < 116) {
                if (TextUtils.isEmpty(str)) {
                    str3 = this.f292437p.getResources().getString(R.string.f173199hy4);
                } else {
                    str3 = str;
                }
                this.f292424c.setVisibility(8);
                this.f292425d.setText(str3);
            } else if (i3 == 20010) {
                c();
            } else {
                this.f292424c.setVisibility(8);
                if (!TextUtils.isEmpty(str)) {
                    this.f292425d.setText(str);
                } else {
                    this.f292425d.setText(this.f292437p.getResources().getString(R.string.f173199hy4));
                }
            }
        } else {
            this.f292424c.setVisibility(0);
            if (i3 == 116) {
                this.f292424c.setText(this.f292437p.getResources().getString(R.string.hxx));
            } else if (i3 == -116) {
                this.f292424c.setText(this.f292437p.getResources().getString(R.string.hym));
            }
            if (TextUtils.isEmpty(str)) {
                str2 = this.f292437p.getResources().getString(R.string.f173199hy4);
            } else {
                str2 = str;
            }
            this.f292425d.setText(str2);
        }
        RelativeLayout relativeLayout = this.f292436o;
        if (relativeLayout != null) {
            relativeLayout.findViewById(R.id.rlCommenTitle).setBackgroundColor(Color.parseColor("#f6f7f9"));
        }
        if (QLog.isColorLevel()) {
            QLog.i("teamConvert", 2, "tencentdoc log:show failed view finish time [" + (System.currentTimeMillis() / 1000) + "] error code = " + i3 + " errorStr = " + str);
        }
    }
}

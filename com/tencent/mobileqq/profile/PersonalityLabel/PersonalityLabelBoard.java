package com.tencent.mobileqq.profile.PersonalityLabel;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.common.config.AppSetting;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.profile.PersonalityLabel.tagCloud.TagCloudView;
import com.tencent.mobileqq.profilecard.ProfileCardDtReportUtil;
import com.tencent.mobileqq.profilecard.api.IProfileCardConst;
import com.tencent.mobileqq.profilecard.bussiness.personalitylabel.ProfilePersonalityLabelComponent;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.util.ProfileCardUtil;
import com.tencent.mobileqq.utils.QQTheme;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;
import java.util.Iterator;
import org.slf4j.Marker;

/* loaded from: classes16.dex */
public class PersonalityLabelBoard extends LinearLayout implements View.OnClickListener, Handler.Callback {
    static IPatchRedirector $redirector_;
    private static final int S;
    View C;
    public TagCloudView D;
    public View E;
    public TextView F;
    public TextView G;
    QQAppInterface H;
    float I;
    Drawable J;
    private int K;
    private String L;
    private String M;
    private boolean N;
    private boolean P;
    ColorStateList Q;
    private ProfilePersonalityLabelComponent R;

    /* renamed from: d, reason: collision with root package name */
    ProfilePersonalityLabelInfo f259802d;

    /* renamed from: e, reason: collision with root package name */
    protected LayoutInflater f259803e;

    /* renamed from: f, reason: collision with root package name */
    LinearLayout.LayoutParams f259804f;

    /* renamed from: h, reason: collision with root package name */
    LinearLayout f259805h;

    /* renamed from: i, reason: collision with root package name */
    public Button f259806i;

    /* renamed from: m, reason: collision with root package name */
    public TextView f259807m;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(73693);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 13)) {
            redirector.redirect((short) 13);
        } else {
            S = Color.parseColor("#A6000000");
        }
    }

    public PersonalityLabelBoard(Context context, QQAppInterface qQAppInterface, String str) {
        super(context);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, context, qQAppInterface, str);
            return;
        }
        this.K = 0;
        this.N = false;
        this.P = true;
        this.Q = ColorStateList.valueOf(-16777216);
        this.H = qQAppInterface;
        c();
        if (!TextUtils.equals(str, qQAppInterface.getCurrentAccountUin())) {
            this.K = 1;
        }
        this.M = str;
    }

    private void b(ProfilePersonalityLabelInfo profilePersonalityLabelInfo) {
        URLDrawable uRLDrawable;
        ArrayList arrayList = new ArrayList(profilePersonalityLabelInfo.getSize());
        if (this.J == null) {
            this.J = getResources().getDrawable(R.color.f156899eo);
        }
        String latestThumbUrl = profilePersonalityLabelInfo.getLatestThumbUrl();
        if (!TextUtils.isEmpty(latestThumbUrl)) {
            Drawable drawable = this.J;
            uRLDrawable = URLDrawable.getDrawable(latestThumbUrl, drawable, drawable);
        } else {
            uRLDrawable = null;
        }
        com.tencent.mobileqq.profile.PersonalityLabel.tagCloud.b.c(arrayList, profilePersonalityLabelInfo, this.I);
        this.D.setTags(arrayList);
        this.D.setTagIcon(uRLDrawable);
        if (AppSetting.f99565y) {
            StringBuilder sb5 = new StringBuilder();
            if (arrayList.size() == 0) {
                sb5.append("\u4e2a\u6027\u6807\u7b7e");
            } else {
                Iterator it = arrayList.iterator();
                while (it.hasNext()) {
                    sb5.append(((Object) ((com.tencent.mobileqq.profile.PersonalityLabel.tagCloud.a) it.next()).f259971c) + " ");
                }
            }
            this.D.setContentDescription(sb5.toString());
        }
    }

    private void c() {
        this.I = getResources().getDisplayMetrics().density;
        this.f259803e = LayoutInflater.from(getContext());
        this.f259804f = new LinearLayout.LayoutParams(-1, -2);
        setOrientation(1);
        setLayoutParams(this.f259804f);
    }

    private void f() {
        g(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h(ProfilePersonalityLabelInfo profilePersonalityLabelInfo, boolean z16) {
        int i3;
        if (this.K == 1) {
            i3 = profilePersonalityLabelInfo.praiseCount + profilePersonalityLabelInfo.unreadCount;
        } else {
            i3 = profilePersonalityLabelInfo.praiseCount;
        }
        if (i3 <= 0 && profilePersonalityLabelInfo.unreadCount <= 0) {
            if (this.E.getVisibility() != 8) {
                this.E.setVisibility(8);
                return;
            }
            return;
        }
        StringBuilder sb5 = new StringBuilder();
        sb5.append("\u83b7\u5f97");
        sb5.append(i3);
        sb5.append("\u4e2a\u8d5e");
        if (!TextUtils.equals(this.F.getText(), sb5)) {
            this.F.setText(sb5);
        }
        if (this.E.getVisibility() != 0) {
            this.E.setVisibility(0);
        }
        if (this.K == 0) {
            if (profilePersonalityLabelInfo.unreadCount <= 0) {
                if (this.G.getVisibility() != 8) {
                    this.G.setVisibility(8);
                }
            } else {
                if (this.G.getVisibility() != 0) {
                    this.G.setVisibility(0);
                }
                sb5.delete(0, sb5.length());
                sb5.append(Marker.ANY_NON_NULL_MARKER);
                sb5.append(profilePersonalityLabelInfo.unreadCount);
                if (!TextUtils.equals(this.G.getText(), sb5)) {
                    this.G.setText(sb5);
                }
            }
        } else if (this.G.getVisibility() != 8) {
            this.G.setVisibility(8);
        }
        if (AppSetting.f99565y) {
            sb5.delete(0, sb5.length());
            sb5.append("\u4e2a\u6027\u6807\u7b7e");
            sb5.append("\uff0c");
            sb5.append(this.F.getText());
            if (this.K == 0) {
                if (profilePersonalityLabelInfo.unreadCount > 0) {
                    sb5.append("\uff0c");
                    sb5.append("\u65b0\u589e");
                    sb5.append(profilePersonalityLabelInfo.unreadCount);
                    sb5.append("\u4e2a\u8d5e");
                }
                sb5.append("\uff0c");
                sb5.append("\u70b9\u6309\u4e24\u6b21\u67e5\u770b");
            }
            this.E.setContentDescription(sb5.toString());
        }
        if (z16 && this.K == 0 && profilePersonalityLabelInfo.unreadCount > 0) {
            ReportController.o(this.H, "dc00898", "", "", "0X8007FCD", "0X8007FCD", 0, 0, "0", "0", "", "");
        }
    }

    public void d(ProfilePersonalityLabelInfo profilePersonalityLabelInfo, boolean z16, boolean z17) {
        View view;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, this, profilePersonalityLabelInfo, Boolean.valueOf(z16), Boolean.valueOf(z17));
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.i("PersonalityLabelBoard", 2, "onGetPersonalityLabels isServer:" + z16 + ", scroll:" + z17 + "," + profilePersonalityLabelInfo.toString());
        }
        if (profilePersonalityLabelInfo.getSize() > 0 && this.C == null) {
            View inflate = this.f259803e.inflate(R.layout.b0e, (ViewGroup) this, false);
            this.C = inflate;
            this.D = (TagCloudView) inflate.findViewById(R.id.ja_);
            this.E = this.C.findViewById(R.id.f167138l74);
            this.F = (TextView) this.C.findViewById(R.id.kca);
            this.G = (TextView) this.C.findViewById(R.id.kcc);
            this.D.setOnClickListener(this);
            this.E.setOnClickListener(this);
            ProfileCardDtReportUtil.initElementWithExposureClick(this.E, "em_profile_tag_goodlist");
            this.D.setMinHeight((int) (this.I * 150.0f));
            this.D.setThreshold((int) (this.I * 7.5f));
        } else if (profilePersonalityLabelInfo.getSize() == 0 && this.f259805h == null) {
            this.f259805h = (LinearLayout) this.f259803e.inflate(R.layout.b0f, (ViewGroup) this, false);
            Drawable drawable = getResources().getDrawable(R.drawable.f4u);
            if (QQTheme.isNowThemeIsNight()) {
                drawable.setColorFilter(S, PorterDuff.Mode.SRC_ATOP);
            }
            this.f259805h.findViewById(R.id.f166804id3).setBackgroundDrawable(drawable);
            Button button = (Button) this.f259805h.findViewById(R.id.k4g);
            this.f259806i = button;
            button.setOnClickListener(this);
            TextView textView = (TextView) this.f259805h.findViewById(R.id.k4h);
            this.f259807m = textView;
            textView.setTextColor(this.Q);
        }
        if (getChildCount() > 0) {
            view = getChildAt(0);
        } else {
            view = null;
        }
        if (profilePersonalityLabelInfo.getSize() == 0) {
            if (view == this.C || view == null) {
                removeAllViews();
                addView(this.f259805h);
            }
        } else {
            if (view != this.f259805h && view != null) {
                if (view == this.C) {
                    if (!profilePersonalityLabelInfo.equals(this.f259802d)) {
                        b(profilePersonalityLabelInfo);
                    } else if (QLog.isColorLevel()) {
                        QLog.i("PersonalityLabelBoard", 2, "onGetPersonalityLabels same data");
                    }
                }
            } else {
                removeAllViews();
                addView(this.C);
                b(profilePersonalityLabelInfo);
            }
            h(profilePersonalityLabelInfo, z16);
        }
        this.f259802d = profilePersonalityLabelInfo;
    }

    public void e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this);
        } else {
            this.N = false;
        }
    }

    public void g(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this, z16);
            return;
        }
        if (this.N) {
            return;
        }
        this.N = true;
        Intent intent = new Intent(getContext(), (Class<?>) PersonalityLabelGalleryActivity.class);
        intent.putExtra(IProfileCardConst.KEY_FROM_TYPE, 0);
        intent.putExtra("uin", this.M);
        if (this.K == 1 && !TextUtils.isEmpty(this.L)) {
            intent.putExtra("nickname", this.L);
        }
        ((Activity) getContext()).startActivityForResult(intent, 1029);
        if (z16) {
            ReportController.o(this.H, "dc00898", "", "", "0X8007FCB", "0X8007FCB", 0, 0, "0", "0", "", "");
            ProfilePersonalityLabelInfo profilePersonalityLabelInfo = this.f259802d;
            if (profilePersonalityLabelInfo != null && profilePersonalityLabelInfo.unreadCount > 0) {
                ReportController.o(this.H, "dc00898", "", "", "0X8007FCE", "0X8007FCE", 0, 0, "0", "0", "", "");
            }
        }
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return ((Boolean) iPatchRedirector.redirect((short) 11, (Object) this, (Object) message)).booleanValue();
        }
        return false;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, (Object) view);
        } else {
            if (view == this.E) {
                if (this.K == 0) {
                    ReportController.o(this.H, "dc00898", "", "", "0X80081D7", "0X80081D7", 0, 0, "", "", "", "");
                    Intent intent = new Intent(getContext(), (Class<?>) QQBrowserActivity.class);
                    intent.putExtra("url", "https://ti.qq.com/cgi-node/specialtag/zanlist?_wv=1027&asyncMode=3");
                    getContext().startActivity(intent);
                    ProfilePersonalityLabelInfo profilePersonalityLabelInfo = this.f259802d;
                    int i3 = profilePersonalityLabelInfo.praiseCount + profilePersonalityLabelInfo.unreadCount;
                    profilePersonalityLabelInfo.praiseCount = i3;
                    profilePersonalityLabelInfo.unreadCount = 0;
                    if (i3 > 0) {
                        postDelayed(new Runnable() { // from class: com.tencent.mobileqq.profile.PersonalityLabel.PersonalityLabelBoard.1
                            static IPatchRedirector $redirector_;

                            {
                                IPatchRedirector iPatchRedirector2 = $redirector_;
                                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) PersonalityLabelBoard.this);
                                }
                            }

                            @Override // java.lang.Runnable
                            public void run() {
                                IPatchRedirector iPatchRedirector2 = $redirector_;
                                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                                    iPatchRedirector2.redirect((short) 2, (Object) this);
                                } else {
                                    PersonalityLabelBoard personalityLabelBoard = PersonalityLabelBoard.this;
                                    personalityLabelBoard.h(personalityLabelBoard.f259802d, false);
                                }
                            }
                        }, 500L);
                    }
                } else {
                    f();
                }
                ProfileCardDtReportUtil.dtReportClick(view);
            }
            if (view == this.f259806i) {
                ProfileCardUtil.k0(this.H.getCurrentAccountUin(), this.H, (Activity) getContext(), true);
                ReportController.o(this.H, "dc00898", "", "", "0X8007FCC", "0X8007FCC", 0, 0, "0", "0", "", "");
            } else if (view == this.D) {
                f();
            }
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    public void setIsNormalTheme(boolean z16) {
        View view;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this, z16);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.i("PersonalityLabelBoard", 2, "setIsNormalTheme:" + z16 + " old:" + this.P);
        }
        if (this.P != z16) {
            this.P = z16;
            if (getChildCount() > 0) {
                view = getChildAt(0);
            } else {
                view = null;
            }
            LinearLayout linearLayout = this.f259805h;
            if (linearLayout != null) {
                this.f259805h = (LinearLayout) this.f259803e.inflate(R.layout.b0f, (ViewGroup) this, false);
                Drawable drawable = getResources().getDrawable(R.drawable.f4u);
                if (QQTheme.isNowThemeIsNight()) {
                    drawable.setColorFilter(S, PorterDuff.Mode.SRC_ATOP);
                }
                Button button = (Button) this.f259805h.findViewById(R.id.k4g);
                this.f259806i = button;
                button.setOnClickListener(this);
                TextView textView = (TextView) this.f259805h.findViewById(R.id.k4h);
                this.f259807m = textView;
                textView.setTextColor(this.Q);
            }
            if (view != null && view == linearLayout) {
                removeAllViews();
                addView(this.f259805h);
            }
        }
    }

    public void setNick(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) str);
        } else if (!TextUtils.equals(str, this.L)) {
            this.L = str;
        }
    }

    public void setPersonalityLabelComponent(ProfilePersonalityLabelComponent profilePersonalityLabelComponent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) profilePersonalityLabelComponent);
        } else {
            this.R = profilePersonalityLabelComponent;
        }
    }

    public void setTextColors(ColorStateList colorStateList) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this, (Object) colorStateList);
            return;
        }
        this.Q = colorStateList;
        TextView textView = this.f259807m;
        if (textView != null) {
            textView.setTextColor(colorStateList);
        }
    }

    public PersonalityLabelBoard(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) context, (Object) attributeSet);
            return;
        }
        this.K = 0;
        this.N = false;
        this.P = true;
        this.Q = ColorStateList.valueOf(-16777216);
        c();
    }

    @TargetApi(11)
    public PersonalityLabelBoard(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, context, attributeSet, Integer.valueOf(i3));
            return;
        }
        this.K = 0;
        this.N = false;
        this.P = true;
        this.Q = ColorStateList.valueOf(-16777216);
        c();
    }
}

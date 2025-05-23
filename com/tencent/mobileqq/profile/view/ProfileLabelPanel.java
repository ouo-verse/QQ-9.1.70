package com.tencent.mobileqq.profile.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.ToggleButton;
import androidx.viewpager.widget.ViewPager;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.profile.ProfileLabelTypeInfo;
import com.tencent.mobileqq.profilecard.entity.ProfileLabelInfo;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.widget.CirclePageIndicator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* loaded from: classes16.dex */
public class ProfileLabelPanel extends RelativeLayout implements ViewPager.OnPageChangeListener {
    static IPatchRedirector $redirector_;
    protected List<ProfileLabelTypeInfo> C;
    protected a D;

    /* renamed from: d, reason: collision with root package name */
    protected ViewPager f260393d;

    /* renamed from: e, reason: collision with root package name */
    protected CirclePageIndicator f260394e;

    /* renamed from: f, reason: collision with root package name */
    protected View f260395f;

    /* renamed from: h, reason: collision with root package name */
    protected TextView f260396h;

    /* renamed from: i, reason: collision with root package name */
    protected TextView f260397i;

    /* renamed from: m, reason: collision with root package name */
    protected b f260398m;

    /* loaded from: classes16.dex */
    public static class a {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        private Map<ProfileLabelInfo, ToggleButton> f260399a;

        public a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            } else {
                this.f260399a = new HashMap();
            }
        }

        public void a(ProfileLabelInfo profileLabelInfo, ToggleButton toggleButton) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, (Object) profileLabelInfo, (Object) toggleButton);
            } else if (!b(profileLabelInfo)) {
                this.f260399a.put(profileLabelInfo, toggleButton);
            }
        }

        public boolean b(ProfileLabelInfo profileLabelInfo) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this, (Object) profileLabelInfo)).booleanValue();
            }
            if (this.f260399a.get(profileLabelInfo) != null) {
                return true;
            }
            return false;
        }

        public void c() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
                iPatchRedirector.redirect((short) 8, (Object) this);
            } else {
                this.f260399a.clear();
            }
        }

        public ToggleButton d(ProfileLabelInfo profileLabelInfo) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
                return (ToggleButton) iPatchRedirector.redirect((short) 6, (Object) this, (Object) profileLabelInfo);
            }
            return this.f260399a.get(profileLabelInfo);
        }

        public Map<ProfileLabelInfo, ToggleButton> e() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
                return (Map) iPatchRedirector.redirect((short) 7, (Object) this);
            }
            return this.f260399a;
        }

        public void f(ProfileLabelInfo profileLabelInfo, ToggleButton toggleButton) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, (Object) this, (Object) profileLabelInfo, (Object) toggleButton);
            } else if (b(profileLabelInfo)) {
                this.f260399a.remove(profileLabelInfo);
            }
        }

        public void g(ProfileLabelInfo profileLabelInfo, ToggleButton toggleButton) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                iPatchRedirector.redirect((short) 5, (Object) this, (Object) profileLabelInfo, (Object) toggleButton);
                return;
            }
            int i3 = profileLabelInfo.labelStatus;
            if (i3 == ProfileLabelInfo.STATUS_NORMAL) {
                a(profileLabelInfo, toggleButton);
            } else if (i3 == ProfileLabelInfo.STATUS_CHECKED) {
                f(profileLabelInfo, toggleButton);
            }
            profileLabelInfo.toggleStatus();
            toggleButton.toggle();
        }
    }

    public ProfileLabelPanel(Context context) {
        super(context);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
            return;
        }
        iPatchRedirector.redirect((short) 1, (Object) this, (Object) context);
    }

    protected void a(Context context, com.tencent.mobileqq.profile.view.a aVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) context, (Object) aVar);
            return;
        }
        this.f260397i = (TextView) this.f260395f.findViewById(R.id.ja5);
        this.f260396h = (TextView) this.f260395f.findViewById(R.id.ja8);
        this.f260397i.setText(this.C.get(0).typeInfo);
        this.f260396h.setText(this.C.get(0).typeName);
        this.f260394e = (CirclePageIndicator) this.f260395f.findViewById(R.id.fhk);
        this.f260393d = (ViewPager) this.f260395f.findViewById(R.id.viewPager);
        b bVar = new b(context, this.C);
        this.f260398m = bVar;
        bVar.e(aVar);
        this.f260398m.f(this.D);
        this.f260393d.setAdapter(this.f260398m);
        this.f260393d.setCurrentItem(0);
        this.f260394e.setViewPager(this.f260393d);
        this.f260394e.setOnPageChangeListener(this);
    }

    @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
    public void onPageScrollStateChanged(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, i3);
        }
    }

    @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
    public void onPageScrolled(int i3, float f16, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, this, Integer.valueOf(i3), Float.valueOf(f16), Integer.valueOf(i16));
        }
    }

    @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
    public void onPageSelected(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, i3);
            return;
        }
        ReportController.o(null, "CliOper", "", "", "card_mall", "0X80066C7", 0, 0, "3", "", "", "");
        ProfileLabelTypeInfo profileLabelTypeInfo = this.C.get(i3);
        this.f260397i.setText(profileLabelTypeInfo.typeInfo);
        this.f260396h.setText(profileLabelTypeInfo.typeName);
    }

    public ProfileLabelPanel(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            return;
        }
        iPatchRedirector.redirect((short) 2, (Object) this, (Object) context, (Object) attributeSet);
    }

    public ProfileLabelPanel(Context context, a aVar, List<ProfileLabelTypeInfo> list, com.tencent.mobileqq.profile.view.a aVar2) {
        this(context);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, context, aVar, list, aVar2);
            return;
        }
        this.f260395f = LayoutInflater.from(context).inflate(R.layout.bem, this);
        this.C = list;
        this.D = aVar;
        a(context, aVar2);
    }
}

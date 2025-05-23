package com.tencent.mobileqq.activity.activateFriend;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.ark.ArkViewImplement;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.item.ArkAppContainer;
import com.tencent.mobileqq.activity.aio.item.ArkAppView;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.data.ArkAppMessage;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.utils.QQTheme;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.utils.en;
import com.tencent.qphone.base.util.QLog;

/* loaded from: classes9.dex */
public class BirthdayActivatePageArkView extends ActivateBasePage {
    static IPatchRedirector $redirector_;
    public final String C;
    private ImageView D;
    private LinearLayout E;
    private TextView F;
    ArkAppContainer G;

    /* renamed from: m, reason: collision with root package name */
    public ArkAppView f177849m;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes9.dex */
    public class a implements ArkViewImplement.LoadCallback {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) BirthdayActivatePageArkView.this);
            }
        }

        @Override // com.tencent.ark.ArkViewImplement.LoadCallback
        public void onLoadFailed(int i3, int i16, String str, boolean z16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, Integer.valueOf(i3), Integer.valueOf(i16), str, Boolean.valueOf(z16));
            } else {
                onLoadState(i3);
            }
        }

        @Override // com.tencent.ark.ArkViewImplement.LoadCallback
        public void onLoadState(int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, i3);
                return;
            }
            if (i3 == 1) {
                if (QLog.isColorLevel()) {
                    QLog.i("BirthdayActivatePageArkView", 1, "@arkgif  onLoadFinish  SUCCESS");
                }
            } else if (i3 == -1) {
                if (QLog.isColorLevel()) {
                    QLog.i("BirthdayActivatePageArkView", 1, "@arkgif  onLoadFinish  failed");
                }
                BirthdayActivatePageArkView.this.h(false);
                BirthdayActivatePageArkView.this.F.setText(HardCodeUtil.qqStr(R.string.k2_));
            }
        }
    }

    public BirthdayActivatePageArkView(Context context) {
        super(context);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) context);
        } else {
            this.C = "BirthdayActivatePageArkView";
        }
    }

    private boolean j() {
        LinearLayout linearLayout = this.E;
        if (linearLayout == null || linearLayout.getVisibility() != 0) {
            return false;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void k(View view, int i3, int i16, int i17, int i18, int i19, int i26, int i27, int i28) {
        if (j()) {
            return;
        }
        int i29 = i28 - i26;
        int i36 = i17 - i3;
        int i37 = i18 - i16;
        if ((i36 != i27 - i19 || i37 != i29) && this.f177849m != null) {
            int dpToPx = i37 - ViewUtils.dpToPx(35.0f);
            this.f177849m.setMinSize(i36, dpToPx);
            this.f177849m.setFixSize(i36, dpToPx);
            this.f177849m.setMaxSize(i36, dpToPx);
            this.f177849m.setViewRect(i36, dpToPx);
        }
    }

    @Override // com.tencent.mobileqq.activity.activateFriend.ActivateBasePage
    public void b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this);
            return;
        }
        this.f177779e = this.f177778d.inflate(R.layout.aqc, (ViewGroup) this, false);
        if (QQTheme.isNowThemeIsNight()) {
            this.f177779e.setBackgroundColor(0);
        }
        this.f177849m = (ArkAppView) this.f177779e.findViewById(R.id.gpj);
        this.f177780f = (TextView) this.f177779e.findViewById(R.id.f163953dg);
        this.E = (LinearLayout) this.f177779e.findViewById(R.id.f165097bx3);
        this.D = (ImageView) this.f177779e.findViewById(R.id.f163961du);
        this.F = (TextView) this.f177779e.findViewById(R.id.bwp);
        this.f177779e.addOnLayoutChangeListener(new View.OnLayoutChangeListener() { // from class: com.tencent.mobileqq.activity.activateFriend.o
            @Override // android.view.View.OnLayoutChangeListener
            public final void onLayoutChange(View view, int i3, int i16, int i17, int i18, int i19, int i26, int i27, int i28) {
                BirthdayActivatePageArkView.this.k(view, i3, i16, i17, i18, i19, i26, i27, i28);
            }
        });
        addView(this.f177779e);
    }

    @Override // com.tencent.mobileqq.activity.activateFriend.ActivateBasePage
    public void destroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
            return;
        }
        super.destroy();
        if (this.G != null) {
            QLog.i("BirthdayActivatePageArkView", 1, "@arkgif  destroy");
            this.G.doOnEvent(2);
        }
    }

    public void f() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this);
        } else {
            this.E.setVisibility(8);
            this.f177849m.setVisibility(0);
        }
    }

    public void g() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this);
        } else {
            h(true);
        }
    }

    public void h(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, z16);
            return;
        }
        if (z16) {
            this.f177849m.setAlpha(1.0f);
        } else {
            l();
        }
        findViewById(R.id.f163951de).setVisibility(8);
        QLog.i("BirthdayActivatePageArkView", 1, "@arkgif  hideLoading");
    }

    public void i(long j3, String str, int i3) {
        int screenWidth;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, Long.valueOf(j3), str, Integer.valueOf(i3));
            return;
        }
        try {
            this.f177780f.setText(en.d(getContext(), 3, j3));
            if (TextUtils.isEmpty(str)) {
                l();
                return;
            }
            f();
            if (getContext() != null) {
                screenWidth = getContext().getResources().getDisplayMetrics().widthPixels;
            } else {
                screenWidth = ViewUtils.getScreenWidth();
            }
            int dpToPx = screenWidth - ViewUtils.dpToPx(84.0f);
            int dpToPx2 = i3 - ViewUtils.dpToPx(35.0f);
            ArkAppMessage arkAppMessage = new ArkAppMessage();
            arkAppMessage.fromAppXml(str);
            if (this.G != null) {
                QLog.i("BirthdayActivatePageArkView", 1, "@arkgif  initdata destroy");
                this.G.doOnEvent(2);
            }
            this.G = new ArkAppContainer();
            QLog.i("BirthdayActivatePageArkView", 1, "@arkgif  arkAppContainer  init height =" + dpToPx2);
            this.G.h(arkAppMessage.appName, arkAppMessage.appView, arkAppMessage.bizSrc, arkAppMessage.appMinVersion, arkAppMessage.metaList, getResources().getDisplayMetrics().scaledDensity, new SessionInfo());
            ArkAppView arkAppView = this.f177849m;
            arkAppView.setOnTouchListener(arkAppView);
            ArkAppView arkAppView2 = this.f177849m;
            arkAppView2.setOnLongClickListener(arkAppView2);
            this.G.setFixSize(dpToPx, dpToPx2);
            this.G.setMaxSize(dpToPx, dpToPx2);
            this.G.setMinSize(dpToPx, dpToPx2);
            this.f177849m.setLoadCallback(new a());
            this.f177849m.initArkView(this.G);
        } catch (Exception e16) {
            QLog.e("BirthdayActivatePageArkView", 1, "@arkgif  initdata erro" + e16.toString());
        }
    }

    public void l() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this);
            return;
        }
        this.E.setVisibility(0);
        this.D.setImageDrawable(getResources().getDrawable(R.drawable.ekp));
        this.F.setVisibility(0);
        this.f177849m.setVisibility(8);
    }

    public void m() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this);
            return;
        }
        this.f177849m.setAlpha(0.0f);
        findViewById(R.id.f163951de).setVisibility(0);
        QLog.i("BirthdayActivatePageArkView", 1, "@arkgif  showLoading");
    }
}

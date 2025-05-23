package com.tencent.mobileqq.activity.activateFriend;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.ark.ArkViewImplement;
import com.tencent.biz.pubaccount.util.api.impl.PublicAccountMessageUtilImpl;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.item.ArkAppContainer;
import com.tencent.mobileqq.activity.aio.item.ArkAppView;
import com.tencent.mobileqq.activity.miniaio.MiniChatConstants;
import com.tencent.mobileqq.profilecard.bussiness.anonymous.utils.AskAnonymouslyUtil;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qqfeatureswitch.IFeatureRuntimeService;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.utils.en;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.QQCustomArkDialogUtil;
import mqq.app.MobileQQ;
import org.json.JSONObject;

/* loaded from: classes9.dex */
public class MemorialActivatePageArk extends ActivateBasePage {
    static IPatchRedirector $redirector_;
    public final String C;
    ArkAppContainer D;
    private ImageView E;
    private LinearLayout F;
    private TextView G;

    /* renamed from: m, reason: collision with root package name */
    public ArkAppView f177868m;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes9.dex */
    public class a implements ArkViewImplement.LoadCallback {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) MemorialActivatePageArk.this);
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
                    QLog.i("MemorialActivatePageArk", 1, "@arkgif  onLoadFinish  SUCCESS");
                }
            } else if (i3 == -1) {
                if (QLog.isColorLevel()) {
                    QLog.i("MemorialActivatePageArk", 1, "@arkgif  onLoadFinish  failed");
                }
                MemorialActivatePageArk.this.g(false);
                MemorialActivatePageArk.this.G.setText(MemorialActivatePageArk.this.getResources().getString(R.string.f220856_9));
            }
        }
    }

    public MemorialActivatePageArk(Context context) {
        super(context);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) context);
        } else {
            this.C = "MemorialActivatePageArk";
        }
    }

    private boolean i() {
        LinearLayout linearLayout = this.F;
        if (linearLayout == null || linearLayout.getVisibility() != 0) {
            return false;
        }
        return true;
    }

    public static boolean j() {
        return ((IFeatureRuntimeService) MobileQQ.sMobileQQ.peekAppRuntime().getRuntimeService(IFeatureRuntimeService.class, "all")).isFeatureSwitchEnable("AIO_QQMemorial_862898663");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void k(View view, int i3, int i16, int i17, int i18, int i19, int i26, int i27, int i28) {
        if (i()) {
            return;
        }
        int i29 = i28 - i26;
        int i36 = i17 - i3;
        int i37 = i18 - i16;
        if ((i36 != i27 - i19 || i37 != i29) && this.f177868m != null) {
            int dpToPx = i37 - ViewUtils.dpToPx(35.0f);
            this.f177868m.setMinSize(i36, dpToPx);
            this.f177868m.setFixSize(i36, dpToPx);
            this.f177868m.setMaxSize(i36, dpToPx);
            this.f177868m.setViewRect(i36, dpToPx);
        }
    }

    @Override // com.tencent.mobileqq.activity.activateFriend.ActivateBasePage
    protected void a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this);
            return;
        }
        this.f177779e.setBackgroundColor(0);
        this.E.setBackgroundColor(MiniChatConstants.COLOR_NIGHT);
        this.G.setBackgroundResource(R.drawable.kva);
    }

    @Override // com.tencent.mobileqq.activity.activateFriend.ActivateBasePage
    public void b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this);
            return;
        }
        View inflate = this.f177778d.inflate(R.layout.aqc, (ViewGroup) this, false);
        this.f177779e = inflate;
        this.f177868m = (ArkAppView) inflate.findViewById(R.id.gpj);
        this.f177780f = (TextView) this.f177779e.findViewById(R.id.f163953dg);
        this.F = (LinearLayout) this.f177779e.findViewById(R.id.f165097bx3);
        this.E = (ImageView) this.f177779e.findViewById(R.id.f163961du);
        this.G = (TextView) this.f177779e.findViewById(R.id.bwp);
        this.f177779e.addOnLayoutChangeListener(new View.OnLayoutChangeListener() { // from class: com.tencent.mobileqq.activity.activateFriend.s
            @Override // android.view.View.OnLayoutChangeListener
            public final void onLayoutChange(View view, int i3, int i16, int i17, int i18, int i19, int i26, int i27, int i28) {
                MemorialActivatePageArk.this.k(view, i3, i16, i17, i18, i19, i26, i27, i28);
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
        if (this.D != null) {
            QLog.i("MemorialActivatePageArk", 1, "@arkgif  destroy");
            this.D.doOnEvent(2);
        }
    }

    public void f() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this);
        } else {
            this.F.setVisibility(8);
        }
    }

    public void g(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, z16);
            return;
        }
        if (z16) {
            this.f177868m.setAlpha(1.0f);
        } else {
            l();
        }
        findViewById(R.id.f163951de).setVisibility(8);
        QLog.i("MemorialActivatePageArk", 1, "@arkgif  hideLoading");
    }

    public boolean h(long j3, JSONObject jSONObject, int i3) {
        int screenWidth;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Boolean) iPatchRedirector.redirect((short) 3, this, Long.valueOf(j3), jSONObject, Integer.valueOf(i3))).booleanValue();
        }
        try {
            this.f177780f.setText(en.d(getContext(), 3, j3));
            if (jSONObject != null && !TextUtils.isEmpty(jSONObject.toString())) {
                f();
                if (getContext() != null) {
                    screenWidth = getContext().getResources().getDisplayMetrics().widthPixels;
                } else {
                    screenWidth = ViewUtils.getScreenWidth();
                }
                int dpToPx = screenWidth - ViewUtils.dpToPx(84.0f);
                int dpToPx2 = i3 - ViewUtils.dpToPx(35.0f);
                if (this.D != null) {
                    QLog.i("MemorialActivatePageArk", 1, "@arkgif  initdata destroy");
                    this.D.doOnEvent(2);
                }
                this.D = new ArkAppContainer();
                QLog.i("MemorialActivatePageArk", 1, "@arkgif  arkAppContainer  init height =" + dpToPx2);
                this.D.h(jSONObject.optString("app"), jSONObject.optString("view"), jSONObject.optString(QQCustomArkDialogUtil.BIZ_SRC), AskAnonymouslyUtil.ARK_APP_VER, jSONObject.optJSONObject(PublicAccountMessageUtilImpl.META_NAME).toString(), getResources().getDisplayMetrics().scaledDensity, new SessionInfo());
                ArkAppView arkAppView = this.f177868m;
                arkAppView.setOnTouchListener(arkAppView);
                ArkAppView arkAppView2 = this.f177868m;
                arkAppView2.setOnLongClickListener(arkAppView2);
                this.D.setFixSize(dpToPx, dpToPx2);
                this.D.setMaxSize(dpToPx, dpToPx2);
                this.D.setMinSize(dpToPx, dpToPx2);
                this.f177868m.setLoadCallback(new a());
                this.f177868m.initArkView(this.D);
                return true;
            }
            if (QLog.isColorLevel()) {
                QLog.i("MemorialActivatePageArk", 1, "initdata json empty");
            }
            return false;
        } catch (Exception e16) {
            QLog.e("MemorialActivatePageArk", 1, "@arkgif  initdata erro" + e16.toString());
            return false;
        }
    }

    public void l() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this);
            return;
        }
        this.F.setVisibility(0);
        this.E.setImageDrawable(getResources().getDrawable(R.drawable.nda));
        this.G.setVisibility(0);
    }

    public void m() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this);
            return;
        }
        this.f177868m.setAlpha(0.0f);
        findViewById(R.id.f163951de).setVisibility(0);
        QLog.i("MemorialActivatePageArk", 1, "@arkgif  showLoading");
    }

    @Override // com.tencent.mobileqq.activity.activateFriend.ActivateBasePage
    public void refresh() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this);
            return;
        }
        super.refresh();
        ArkAppContainer arkAppContainer = this.D;
        if (arkAppContainer != null) {
            arkAppContainer.invalidateRect();
        }
    }
}

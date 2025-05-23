package com.tencent.mobileqq.activity.home.chats.biz;

import android.app.Activity;
import android.view.View;
import android.widget.RelativeLayout;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.guild.api.IGuildLayoutApi;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.resconfig.MainResourceConfig;
import com.tencent.mobileqq.utils.QQTheme;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.vas.theme.api.ThemeUtil;
import com.tencent.mobileqq.widget.search.QUISearchBar;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.AbsListView;
import mqq.app.AppRuntime;

/* compiled from: P */
/* loaded from: classes10.dex */
public class m extends d implements IGuildLayoutApi.d {
    static IPatchRedirector $redirector_;
    public static final float I;
    public static final float J;
    com.tencent.mobileqq.activity.contacts.base.j C;
    com.tencent.qqnt.chats.biz.main.part.c D;
    com.tencent.mobileqq.activity.home.chats.callbcak.a E;
    View F;
    private boolean G;
    private boolean H;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(68466);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 12)) {
            redirector.redirect((short) 12);
        } else {
            I = ViewUtils.dip2px(60.0f);
            J = ViewUtils.dip2px(122.0f);
        }
    }

    public m(com.tencent.mobileqq.activity.home.chats.callbcak.a aVar, com.tencent.qqnt.chats.biz.main.part.c cVar) {
        super(aVar);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) aVar, (Object) cVar);
        } else {
            this.E = aVar;
            this.D = cVar;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void oa(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        scrollToTop();
        EventCollector.getInstance().onViewClicked(view);
    }

    private void pa() {
        if ((!ThemeUtil.isDefaultTheme() && !QQTheme.isNowThemeDefaultNight() && !QQTheme.isNowSimpleUI()) || this.F == null) {
            return;
        }
        qa(ja());
    }

    private void qa(boolean z16) {
        if (this.F != null && this.G != z16) {
            if (QLog.isDevelopLevel()) {
                QLog.d("SearchPart", 4, "updateLocalSearchBar: mShowUPMask = " + this.G + ", dstMsg = " + z16);
            }
            ((QUISearchBar) this.F).setColorType(na(z16) ? 1 : 0);
            this.G = z16;
        }
    }

    private void ra() {
        View view = this.F;
        if (view == null) {
            return;
        }
        ((QUISearchBar) view).setColorType(na(this.G) ? 1 : 0);
    }

    private void scrollToTop() {
        this.D.scrollToTop();
    }

    @Override // com.tencent.qqnt.chats.biz.main.part.a
    public void C9() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this);
            return;
        }
        super.C9();
        if (la() && this.D.ea()) {
            pa();
        }
    }

    @Override // com.tencent.mobileqq.guild.api.IGuildLayoutApi.d
    public void J(float f16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, this, Float.valueOf(f16));
            return;
        }
        if (f16 == 100.0f) {
            this.F.setVisibility(4);
        } else {
            this.F.setVisibility(0);
        }
        float c16 = J - this.E.c();
        float f17 = I;
        this.F.getLayoutParams().height = (int) (f17 * (1.0f - ((f16 * (1.0f - (c16 / f17))) / 100.0f)));
        this.F.requestLayout();
    }

    @Override // com.tencent.mobileqq.activity.home.chats.biz.d
    public String ea() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (String) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return "SearchPart";
    }

    @Override // com.tencent.qqnt.chats.biz.main.part.a, mqq.app.IAccountCallback
    public void onAccountChanged(AppRuntime appRuntime) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) appRuntime);
            return;
        }
        com.tencent.mobileqq.activity.contacts.base.j jVar = this.C;
        if (jVar != null && (appRuntime instanceof QQAppInterface)) {
            jVar.a((QQAppInterface) appRuntime);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v5, types: [android.view.View] */
    @Override // com.tencent.biz.richframework.part.Part
    public void onInitView(View view) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) view);
            return;
        }
        Activity activity = getActivity();
        QUISearchBar qUISearchBar = null;
        if (activity != null && (activity instanceof SplashActivity)) {
            SplashActivity splashActivity = (SplashActivity) activity;
            ?? r36 = splashActivity.mPreloadLocalSearchBar;
            splashActivity.mPreloadLocalSearchBar = null;
            qUISearchBar = r36;
        }
        if (qUISearchBar == null && activity != null) {
            qUISearchBar = new QUISearchBar(activity);
            qUISearchBar.setLayoutParams(new AbsListView.LayoutParams(-1, (int) I));
            qUISearchBar.setId(R.id.f66643b7);
        }
        if (qUISearchBar != null) {
            RelativeLayout relativeLayout = (RelativeLayout) view.findViewById(R.id.j2j);
            this.D.ma(-1, qUISearchBar);
            if (activity instanceof SplashActivity) {
                this.C = ((SplashActivity) activity).preladSearchAssistant;
            }
            if (this.C == null) {
                this.C = new com.tencent.mobileqq.activity.contacts.base.j((BaseActivity) getActivity(), 1, qUISearchBar);
            }
            this.C.f(relativeLayout);
            this.C.e(new View.OnClickListener() { // from class: com.tencent.mobileqq.activity.home.chats.biz.l
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    m.this.oa(view2);
                }
            });
            this.F = qUISearchBar;
            qUISearchBar.setTag(R.id.f166947jb4, Boolean.valueOf(this.H));
        }
    }

    @Override // com.tencent.mobileqq.activity.home.chats.biz.d, com.tencent.biz.richframework.part.Part, com.tencent.biz.richframework.part.PartLifecycleCallbacks
    public void onPartDestroy(Activity activity) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this, (Object) activity);
            return;
        }
        super.onPartDestroy(activity);
        com.tencent.mobileqq.activity.contacts.base.j jVar = this.C;
        if (jVar != null) {
            jVar.b();
        }
    }

    @Override // com.tencent.mobileqq.activity.home.chats.biz.d, com.tencent.biz.richframework.part.Part
    public void onPartPause(Activity activity) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this, (Object) activity);
            return;
        }
        super.onPartPause(activity);
        com.tencent.mobileqq.activity.contacts.base.j jVar = this.C;
        if (jVar != null) {
            jVar.c();
        }
    }

    @Override // com.tencent.mobileqq.activity.home.chats.biz.d, com.tencent.biz.richframework.part.Part
    public void onPartResume(Activity activity) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) activity);
            return;
        }
        super.onPartResume(activity);
        pa();
        com.tencent.mobileqq.activity.contacts.base.j jVar = this.C;
        if (jVar != null) {
            jVar.d();
        }
    }

    @Override // com.tencent.qqnt.chats.biz.main.part.a
    public void onPostThemeChanged() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this);
            return;
        }
        QLog.i("SearchPart", 1, "onPostThemeChanged:" + this.C);
        ra();
        pa();
        com.tencent.mobileqq.activity.contacts.base.j jVar = this.C;
        if (jVar != null) {
            jVar.onPostThemeChanged();
        }
    }

    public void sa(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, z16);
            return;
        }
        this.H = true;
        View view = this.F;
        if (view != null) {
            view.setTag(R.id.f166947jb4, Boolean.valueOf(z16));
            if (MainResourceConfig.r()) {
                this.F.setBackground(MainResourceConfig.g().m(getContext(), this.G, 1.0f, z16));
            }
        }
    }

    private boolean na(boolean z16) {
        return z16;
    }
}

package com.tencent.mobileqq.leba.business.mainbiz;

import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;
import androidx.appcompat.content.res.AppCompatResources;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.search.activity.UniteSearchActivity;
import com.tencent.mobileqq.search.report.b;
import com.tencent.mobileqq.search.searchdetail.util.SearchShadingWordPlay;
import com.tencent.mobileqq.search.util.ar;
import com.tencent.mobileqq.search.util.j;
import com.tencent.mobileqq.search.util.w;
import com.tencent.mobileqq.search.util.y;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.studymode.api.IStudyModeManager;
import com.tencent.mobileqq.util.AccessibilityUtil;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.widget.search.QUISearchBar;
import com.tencent.mobileqq.zplan.api.IZPlanApi;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

/* loaded from: classes15.dex */
public class LebaSearchPart extends com.tencent.mobileqq.leba.business.a {
    static IPatchRedirector $redirector_;

    /* renamed from: b, reason: collision with root package name */
    private EditText f240119b;

    /* renamed from: c, reason: collision with root package name */
    private ViewGroup f240120c;

    /* renamed from: d, reason: collision with root package name */
    private View f240121d;

    /* renamed from: e, reason: collision with root package name */
    private View f240122e;

    /* renamed from: f, reason: collision with root package name */
    View f240123f;

    /* renamed from: g, reason: collision with root package name */
    View f240124g;

    /* renamed from: h, reason: collision with root package name */
    SearchShadingWordPlay f240125h;

    /* loaded from: classes15.dex */
    public static class a implements View.OnFocusChangeListener, View.OnClickListener {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        private WeakReference<QQAppInterface> f240126d;

        /* renamed from: e, reason: collision with root package name */
        private WeakReference<QBaseActivity> f240127e;

        /* renamed from: f, reason: collision with root package name */
        private WeakReference<LebaSearchPart> f240128f;

        a(QQAppInterface qQAppInterface, QBaseActivity qBaseActivity, LebaSearchPart lebaSearchPart) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, qQAppInterface, qBaseActivity, lebaSearchPart);
                return;
            }
            this.f240126d = new WeakReference<>(qQAppInterface);
            this.f240127e = new WeakReference<>(qBaseActivity);
            this.f240128f = new WeakReference<>(lebaSearchPart);
        }

        private void a(View view) {
            b.e(null, 0, 21, "0X8009D15", 0, 0, null, null);
            QBaseActivity qBaseActivity = this.f240127e.get();
            if (qBaseActivity == null) {
                QLog.i("LebaSearchPart", 1, "MyFocusChangeListener activity weakRef null");
                if (view.getContext() instanceof Activity) {
                    qBaseActivity = (Activity) view.getContext();
                }
            }
            Context context = qBaseActivity;
            if (context != null) {
                LebaSearchPart lebaSearchPart = this.f240128f.get();
                ArrayList arrayList = null;
                if (lebaSearchPart != null) {
                    lebaSearchPart.i();
                    j.d(lebaSearchPart.f240123f, lebaSearchPart.f240124g);
                    if (lebaSearchPart.k() != null && !lebaSearchPart.k().isEmpty()) {
                        arrayList = new ArrayList();
                        arrayList.add(lebaSearchPart.k());
                    }
                    lebaSearchPart.m();
                }
                UniteSearchActivity.L2(context, null, 21, null, 3, null, arrayList);
            } else {
                QLog.i("LebaSearchPart", 1, "MyFocusChangeListener act null");
            }
            ReportController.o(this.f240126d.get(), "CliOper", "", "", "0x8004B21", "0x8004B21", 0, 0, "", "", "", "");
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, (Object) view);
            } else {
                a(view);
            }
            EventCollector.getInstance().onViewClicked(view);
        }

        @Override // android.view.View.OnFocusChangeListener
        public void onFocusChange(View view, boolean z16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, view, Boolean.valueOf(z16));
            } else if (z16) {
                view.clearFocus();
                a(view);
            } else {
                QLog.e("LebaSearchPart", 1, "MyFocusChangeListener not focus");
            }
        }
    }

    public LebaSearchPart() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private void n() {
        TextView textView = (TextView) this.f240120c.findViewById(R.id.kag);
        if (textView == null) {
            return;
        }
        Drawable drawable = AppCompatResources.getDrawable(textView.getContext(), R.drawable.qui_search_icon_secondary_01);
        if (drawable != null) {
            int dpToPx = ViewUtils.dpToPx(16.0f);
            drawable.setBounds(0, 0, dpToPx, dpToPx);
            textView.setCompoundDrawables(drawable, null, null, null);
        }
        textView.setTextColor(AppCompatResources.getColorStateList(this.f240119b.getContext(), R.color.qui_common_text_secondary));
    }

    @Override // com.tencent.mobileqq.leba.business.a
    public void a(View view) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) view);
            return;
        }
        QQAppInterface qQAppInterface = (QQAppInterface) MobileQQ.sMobileQQ.peekAppRuntime();
        QBaseActivity qBaseActivity = (QBaseActivity) view.getContext();
        if (qQAppInterface != null && qBaseActivity != null) {
            this.f240120c = (ViewGroup) view.findViewById(R.id.e6t);
            if (y.e()) {
                this.f240120c.setVisibility(8);
                QUISearchBar qUISearchBar = (QUISearchBar) view.findViewById(R.id.f66643b7);
                qUISearchBar.setVisibility(0);
                qUISearchBar.setCustomResource(ar.b(false));
                this.f240120c = qUISearchBar;
                this.f240119b = qUISearchBar.getInputWidget();
                this.f240120c.setOnClickListener(new a(qQAppInterface, qBaseActivity, this));
                SearchShadingWordPlay searchShadingWordPlay = new SearchShadingWordPlay(qUISearchBar, 6, false);
                this.f240125h = searchShadingWordPlay;
                searchShadingWordPlay.c();
            } else {
                this.f240119b = (EditText) this.f240120c.findViewById(R.id.et_search_keyword);
                this.f240120c.findViewById(R.id.btn_cancel_search).setVisibility(8);
                this.f240119b.setOnFocusChangeListener(new a(qQAppInterface, qBaseActivity, this));
            }
            this.f240123f = qBaseActivity.findViewById(R.id.jo9);
            this.f240124g = qBaseActivity.findViewById(R.id.conversation_head);
            this.f240121d = view.findViewById(R.id.ygf);
            this.f240122e = view.findViewById(R.id.ygl);
            this.f240119b.setCursorVisible(false);
            if (!y.e()) {
                AccessibilityUtil.u(this.f240119b, qBaseActivity.getString(R.string.h_a));
            }
            l();
            if (AppSetting.f99565y) {
                AccessibilityUtil.h(view);
            }
            n();
            return;
        }
        QLog.i("LebaSearchPart", 1, "initLebaQQCircleView app == null || activity == null");
    }

    @Override // com.tencent.mobileqq.leba.business.a
    public void b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this);
        } else {
            l();
        }
    }

    @Override // com.tencent.mobileqq.leba.business.a
    public void d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this);
            return;
        }
        super.d();
        SearchShadingWordPlay searchShadingWordPlay = this.f240125h;
        if (searchShadingWordPlay != null) {
            searchShadingWordPlay.b();
        }
    }

    @Override // com.tencent.mobileqq.leba.business.a
    public void f() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this);
            return;
        }
        super.f();
        SearchShadingWordPlay searchShadingWordPlay = this.f240125h;
        if (searchShadingWordPlay != null) {
            searchShadingWordPlay.e();
        }
    }

    @Override // com.tencent.mobileqq.leba.business.a
    public void g() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this);
            return;
        }
        l();
        ViewGroup viewGroup = this.f240120c;
        if (viewGroup instanceof QUISearchBar) {
            ((QUISearchBar) viewGroup).onThemeChanged();
        }
    }

    @Override // com.tencent.mobileqq.leba.business.a
    public void h(boolean z16) {
        ViewGroup viewGroup;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, z16);
            return;
        }
        l();
        if (this.f240125h != null && (viewGroup = this.f240120c) != null) {
            viewGroup.post(new Runnable() { // from class: com.tencent.mobileqq.leba.business.mainbiz.LebaSearchPart.1
                static IPatchRedirector $redirector_;

                {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) LebaSearchPart.this);
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this);
                    } else {
                        LebaSearchPart.this.f240125h.f();
                    }
                }
            });
        }
    }

    public String k() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return (String) iPatchRedirector.redirect((short) 10, (Object) this);
        }
        SearchShadingWordPlay searchShadingWordPlay = this.f240125h;
        if (searchShadingWordPlay == null) {
            return "";
        }
        return searchShadingWordPlay.h();
    }

    /* JADX WARN: Removed duplicated region for block: B:23:0x007f  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0089  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x0095  */
    /* JADX WARN: Removed duplicated region for block: B:36:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0081  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void l() {
        boolean z16;
        int i3;
        View view;
        View view2;
        int i16;
        boolean z17;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
            return;
        }
        if (this.f240120c != null) {
            boolean w3 = w.w();
            boolean z18 = !w3;
            int i17 = 0;
            if (w3) {
                AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
                if (peekAppRuntime != null && ((IZPlanApi) QRoute.api(IZPlanApi.class)).isQzoneEntranceEnabled(peekAppRuntime.getLongAccountUin()) && !((IStudyModeManager) QRoute.api(IStudyModeManager.class)).getStudyModeSwitch()) {
                    z17 = true;
                } else {
                    z17 = false;
                }
                if (z17) {
                    z16 = true;
                    w3 = false;
                    z18 = false;
                    QLog.i("LebaSearchPart", 1, "refreshSearchBar: isShow? " + w3 + ", topSpace? " + z18 + ", zplanTopSpace? " + z16);
                    ViewGroup viewGroup = this.f240120c;
                    if (!w3) {
                        i3 = 0;
                    } else {
                        i3 = 8;
                    }
                    viewGroup.setVisibility(i3);
                    view = this.f240121d;
                    if (view != null) {
                        if (z18) {
                            i16 = 0;
                        } else {
                            i16 = 8;
                        }
                        view.setVisibility(i16);
                    }
                    view2 = this.f240122e;
                    if (view2 == null) {
                        if (!z16) {
                            i17 = 8;
                        }
                        view2.setVisibility(i17);
                        return;
                    }
                    return;
                }
            }
            z16 = false;
            QLog.i("LebaSearchPart", 1, "refreshSearchBar: isShow? " + w3 + ", topSpace? " + z18 + ", zplanTopSpace? " + z16);
            ViewGroup viewGroup2 = this.f240120c;
            if (!w3) {
            }
            viewGroup2.setVisibility(i3);
            view = this.f240121d;
            if (view != null) {
            }
            view2 = this.f240122e;
            if (view2 == null) {
            }
        }
    }

    public void m() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this);
            return;
        }
        SearchShadingWordPlay searchShadingWordPlay = this.f240125h;
        if (searchShadingWordPlay != null) {
            searchShadingWordPlay.p();
        }
    }
}

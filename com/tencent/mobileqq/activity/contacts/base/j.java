package com.tencent.mobileqq.activity.contacts.base;

import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import com.tencent.biz.pubaccount.api.IPublicAccountDetailReportUtil;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.FrameHelperActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.search.activity.UniteSearchActivity;
import com.tencent.mobileqq.search.api.IQQSearchApi;
import com.tencent.mobileqq.search.base.util.SearchConfigManager;
import com.tencent.mobileqq.search.config.SearchConfig;
import com.tencent.mobileqq.search.searchdetail.util.SearchShadingWordPlay;
import com.tencent.mobileqq.search.util.ar;
import com.tencent.mobileqq.util.AccessibilityUtil;
import com.tencent.mobileqq.widget.search.QUISearchBar;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.lang.ref.WeakReference;
import java.util.ArrayList;

/* compiled from: P */
/* loaded from: classes10.dex */
public class j implements View.OnClickListener {
    static IPatchRedirector $redirector_;
    public static final String F;
    private View.OnClickListener C;
    private Runnable D;
    SearchShadingWordPlay E;

    /* renamed from: d, reason: collision with root package name */
    private WeakReference<BaseActivity> f181520d;

    /* renamed from: e, reason: collision with root package name */
    private long f181521e;

    /* renamed from: f, reason: collision with root package name */
    private int f181522f;

    /* renamed from: h, reason: collision with root package name */
    private View f181523h;

    /* renamed from: i, reason: collision with root package name */
    private View f181524i;

    /* renamed from: m, reason: collision with root package name */
    private View f181525m;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(68038);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 11)) {
            redirector.redirect((short) 11);
        } else {
            F = j.class.getSimpleName();
        }
    }

    public j(BaseActivity baseActivity, int i3, View view) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, baseActivity, Integer.valueOf(i3), view);
            return;
        }
        this.f181520d = new WeakReference<>(baseActivity);
        this.f181522f = i3;
        this.f181525m = baseActivity.findViewById(R.id.conversation_head);
        View findViewById = view.findViewById(R.id.iji);
        if (findViewById != null) {
            findViewById.setVisibility(8);
        }
        QUISearchBar qUISearchBar = (QUISearchBar) view.findViewById(R.id.f66643b7);
        qUISearchBar.updateStyle(1);
        qUISearchBar.setVisibility(0);
        qUISearchBar.setCustomResource(ar.b(false));
        qUISearchBar.setOnClickListener(this);
        this.f181523h = qUISearchBar;
        int i16 = this.f181522f;
        if (i16 == 1 || i16 == 2) {
            SearchShadingWordPlay searchShadingWordPlay = new SearchShadingWordPlay(qUISearchBar, 6, this.f181522f == 1);
            this.E = searchShadingWordPlay;
            searchShadingWordPlay.c();
        }
        AccessibilityUtil.c(view, "\u641c\u7d22\u6846", Button.class.getName());
    }

    public void a(QQAppInterface qQAppInterface) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, (Object) qQAppInterface);
            return;
        }
        if (qQAppInterface == null) {
            return;
        }
        String currentUin = qQAppInterface.getCurrentUin();
        if (!TextUtils.isEmpty(currentUin) && !currentUin.equals(SearchConfigManager.curUin)) {
            SearchConfig.isConfigLoaded = false;
        }
        if (this.E != null) {
            QLog.d(F, 1, "onAccountChanged trigger mSearchShadingWordPlay.doOnResume");
            this.E.f();
        }
    }

    public void b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this);
            return;
        }
        if (this.f181522f == 1) {
            ((IPublicAccountDetailReportUtil) QRoute.api(IPublicAccountDetailReportUtil.class)).resetAttribute();
        }
        View view = this.f181523h;
        if (view != null) {
            view.setOnClickListener(null);
        }
        SearchShadingWordPlay searchShadingWordPlay = this.E;
        if (searchShadingWordPlay != null) {
            searchShadingWordPlay.b();
        }
        if (this.D != null) {
            ThreadManager.getUIHandler().removeCallbacks(this.D);
        }
    }

    public void c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this);
            return;
        }
        SearchShadingWordPlay searchShadingWordPlay = this.E;
        if (searchShadingWordPlay != null) {
            searchShadingWordPlay.e();
        }
    }

    public void d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
        } else if (this.f181523h != null) {
            this.D = new Runnable() { // from class: com.tencent.mobileqq.activity.contacts.base.i
                @Override // java.lang.Runnable
                public final void run() {
                    j.this.g();
                }
            };
            ThreadManager.getUIHandler().post(this.D);
        }
    }

    public void e(View.OnClickListener onClickListener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this, (Object) onClickListener);
        } else {
            this.C = onClickListener;
        }
    }

    public void f(View view) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) view);
        } else {
            this.f181524i = view;
        }
    }

    public void g() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this);
            return;
        }
        if (this.f181523h != null) {
            QLog.d(F, 1, "updateWhenResume mSeachContainer's hashCode: " + this.f181523h.hashCode());
            SearchShadingWordPlay searchShadingWordPlay = this.E;
            if (searchShadingWordPlay == null || searchShadingWordPlay.h().isEmpty()) {
                ((QUISearchBar) this.f181523h).getInputWidget().setHint(nn2.a.b());
            }
            if (!((QUISearchBar) this.f181523h).hasOnClickListener()) {
                e(this);
            }
        }
        SearchShadingWordPlay searchShadingWordPlay2 = this.E;
        if (searchShadingWordPlay2 != null) {
            searchShadingWordPlay2.f();
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        ArrayList arrayList;
        EventCollector.getInstance().onViewClickedBefore(view);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) view);
        } else {
            long currentTimeMillis = System.currentTimeMillis();
            int i3 = 2;
            if (QLog.isColorLevel()) {
                QLog.d(F, 2, "onClick()   mFrom = " + this.f181522f + "   time stamp = " + (currentTimeMillis - this.f181521e));
            }
            if (Math.abs(currentTimeMillis - this.f181521e) < 500) {
                QLog.d(F, 4, "onFastClick ignore");
            } else {
                this.f181521e = currentTimeMillis;
                if (!AppSetting.t(view.getContext())) {
                    FrameHelperActivity.gj(false, F);
                }
                BaseActivity baseActivity = this.f181520d.get();
                if (baseActivity != null) {
                    if (this.f181522f != 2) {
                        i3 = 1;
                    }
                    com.tencent.mobileqq.search.report.b.e(null, i3, 0, "0X8009D15", 0, 0, null, null);
                    com.tencent.mobileqq.search.util.j.d(this.f181524i, this.f181525m);
                    View.OnClickListener onClickListener = this.C;
                    if (onClickListener != null) {
                        onClickListener.onClick(view);
                    }
                    if (this.f181522f == 28) {
                        ((IQQSearchApi) QRoute.api(IQQSearchApi.class)).jump2SearchFromGuild(baseActivity);
                    } else {
                        SearchShadingWordPlay searchShadingWordPlay = this.E;
                        if (searchShadingWordPlay != null && !searchShadingWordPlay.h().isEmpty()) {
                            arrayList = new ArrayList();
                            arrayList.add(0, this.E.h());
                        } else {
                            arrayList = null;
                        }
                        UniteSearchActivity.J2(baseActivity, null, this.f181522f, i3, arrayList);
                    }
                    SearchShadingWordPlay searchShadingWordPlay2 = this.E;
                    if (searchShadingWordPlay2 != null) {
                        searchShadingWordPlay2.p();
                    }
                }
            }
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    public void onPostThemeChanged() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this);
            return;
        }
        QLog.i(F, 1, "onPostThemeChanged:" + this.f181523h);
        View view = this.f181523h;
        if (view instanceof QUISearchBar) {
            ((QUISearchBar) view).onThemeChanged();
        }
    }
}

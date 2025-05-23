package com.tencent.mobileqq.troop.shortcutbar.troopapp;

import android.app.Activity;
import android.content.Context;
import android.graphics.Rect;
import android.text.TextUtils;
import android.view.InflateException;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.aio.helper.TroopAppShortcutBarHelper;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.gamecenter.util.QQGameTroopManager;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.troop.essencemsg.s;
import com.tencent.mobileqq.troop.shortcutbar.ShortcutBarInfo;
import com.tencent.mobileqq.troop.shortcutbar.TroopShortcutBarApp;
import com.tencent.mobileqq.troop.utils.r;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.widget.AppShortcutBarScrollView;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.constants.ClickPolicy;
import com.tencent.qqlive.module.videoreport.constants.ExposurePolicy;
import cooperation.qqcircle.report.datong.QCircleDaTongConstant;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import mqq.app.AppRuntime;

/* loaded from: classes19.dex */
public class AppShortcutBarPanel extends e {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    private com.tencent.mobileqq.activity.aio.rebuild.input.shortcutbar.a f298760a;

    /* renamed from: b, reason: collision with root package name */
    private AppShortcutBarScrollView f298761b;

    /* renamed from: c, reason: collision with root package name */
    private LinearLayout f298762c;

    /* renamed from: d, reason: collision with root package name */
    private LinearLayout f298763d;

    /* renamed from: e, reason: collision with root package name */
    private LinearLayout f298764e;

    /* renamed from: f, reason: collision with root package name */
    private TroopAppShortcutBarHelper f298765f;

    /* renamed from: g, reason: collision with root package name */
    private long f298766g;

    /* renamed from: h, reason: collision with root package name */
    private ArrayList<Long> f298767h;

    /* renamed from: i, reason: collision with root package name */
    public boolean f298768i;

    /* renamed from: j, reason: collision with root package name */
    private boolean f298769j;

    /* renamed from: k, reason: collision with root package name */
    private b f298770k;

    /* renamed from: l, reason: collision with root package name */
    private Activity f298771l;

    /* renamed from: m, reason: collision with root package name */
    private Context f298772m;

    /* renamed from: n, reason: collision with root package name */
    private AppRuntime f298773n;

    /* renamed from: o, reason: collision with root package name */
    protected View.OnClickListener f298774o;

    /* loaded from: classes19.dex */
    class a implements View.OnClickListener {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) AppShortcutBarPanel.this);
            }
        }

        private void a(View view) {
            if (view.getTag() instanceof TroopShortcutBarApp) {
                TroopShortcutBarApp troopShortcutBarApp = (TroopShortcutBarApp) view.getTag();
                if (troopShortcutBarApp.getAppIdUnreadNum() != 0 || troopShortcutBarApp.getAddPoint()) {
                    AppShortcutBarPanel.this.r(view, 0, false);
                }
            }
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) view);
            } else if (AppShortcutBarPanel.this.f298765f != null) {
                a(view);
                AppShortcutBarPanel.this.f298765f.onClick(view);
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* loaded from: classes19.dex */
    public static class b {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        public int f298776a;

        /* renamed from: b, reason: collision with root package name */
        public int f298777b;

        /* renamed from: c, reason: collision with root package name */
        public boolean f298778c;

        /* renamed from: d, reason: collision with root package name */
        public long f298779d;

        /* renamed from: e, reason: collision with root package name */
        public long f298780e;

        public b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
                return;
            }
            this.f298776a = 0;
            this.f298777b = 0;
            this.f298778c = false;
            this.f298779d = 0L;
            this.f298780e = 0L;
        }
    }

    public AppShortcutBarPanel(com.tencent.mobileqq.activity.aio.rebuild.input.shortcutbar.a aVar, AppShortcutBarScrollView appShortcutBarScrollView, TroopAppShortcutBarHelper troopAppShortcutBarHelper) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, aVar, appShortcutBarScrollView, troopAppShortcutBarHelper);
            return;
        }
        this.f298767h = new ArrayList<>();
        this.f298768i = false;
        this.f298769j = false;
        this.f298774o = new a();
        this.f298760a = aVar;
        this.f298771l = aVar.c();
        this.f298772m = aVar.e();
        this.f298773n = aVar.d();
        this.f298761b = appShortcutBarScrollView;
        LinearLayout linearLayout = (LinearLayout) appShortcutBarScrollView.findViewById(R.id.f223403g);
        this.f298762c = linearLayout;
        this.f298763d = (LinearLayout) linearLayout.findViewById(R.id.f166477h53);
        this.f298764e = (LinearLayout) this.f298762c.findViewById(R.id.f223203e);
        this.f298765f = troopAppShortcutBarHelper;
        this.f298766g = troopAppShortcutBarHelper.n();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void n() {
        AppRuntime appRuntime = this.f298773n;
        if (appRuntime == null) {
            return;
        }
        long j3 = this.f298766g;
        try {
            String valueOf = String.valueOf(j3);
            TroopInfo k3 = ((TroopManager) appRuntime.getManager(QQManagerFactory.TROOP_MANAGER)).k(valueOf);
            if (k3 == null) {
                return;
            }
            ReportController.o(null, "dc00898", "", "", "0X800ACFF", "0X800ACFF", 0, 0, "", valueOf, String.valueOf(k3.dwGroupClassExt), "");
            s.n((QQAppInterface) appRuntime, j3, true);
            s.o((QQAppInterface) appRuntime, j3, true);
        } catch (Exception e16) {
            QLog.e("AppShortcutBarPanel", 1, "reportExpose exception:" + e16.getMessage());
        }
    }

    private void o() {
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.troop.shortcutbar.troopapp.a
            @Override // java.lang.Runnable
            public final void run() {
                AppShortcutBarPanel.this.n();
            }
        }, 16, null, true);
    }

    private void p(TroopShortcutBarApp troopShortcutBarApp, View view) {
        view.setTag(troopShortcutBarApp);
        view.setOnClickListener(this.f298774o);
        ((TextView) view.findViewById(R.id.iru)).setText(troopShortcutBarApp.getMsgSummary());
        ((LinearLayout) view.findViewById(R.id.ir7)).setBackgroundDrawable(this.f298772m.getResources().getDrawable(R.drawable.a9n));
        r(view, troopShortcutBarApp.getAppIdUnreadNum(), troopShortcutBarApp.getAddPoint());
        URLImageView uRLImageView = (URLImageView) view.findViewById(R.id.ir8);
        Context context = this.f298772m;
        String iconUrl = troopShortcutBarApp.getIconUrl();
        boolean z16 = true;
        if (troopShortcutBarApp.getShowFrame() != 1) {
            z16 = false;
        }
        r.l(context, uRLImageView, iconUrl, 16.0f, z16);
    }

    private void q() {
        TroopShortcutBarApp createManagerShortcutBarApp = TroopShortcutBarApp.createManagerShortcutBarApp(this.f298772m.getResources().getString(R.string.w3e), "https://sola.gtimg.cn/aoi/sola/20200528211216_3ydkcWft2I.png");
        View inflate = View.inflate(this.f298772m, R.layout.bvm, null);
        p(createManagerShortcutBarApp, inflate);
        this.f298763d.addView(inflate);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void r(View view, int i3, boolean z16) {
        TextView textView = (TextView) view.findViewById(R.id.irt);
        if (textView == null) {
            return;
        }
        if (i3 == 0 && !z16) {
            textView.setVisibility(4);
            return;
        }
        textView.setVisibility(0);
        textView.setText("");
        textView.setBackgroundResource(0);
        textView.setCompoundDrawablesWithIntrinsicBounds(R.drawable.f160084mk3, 0, 0, 0);
    }

    @Override // com.tencent.mobileqq.troop.shortcutbar.troopapp.e
    public void a(String str, long j3) {
        LinearLayout linearLayout;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, this, str, Long.valueOf(j3));
            return;
        }
        if (!TextUtils.isEmpty(str) && str.equals(String.valueOf(this.f298766g)) && (linearLayout = this.f298763d) != null) {
            int childCount = linearLayout.getChildCount();
            for (int i3 = 0; i3 < childCount; i3++) {
                View childAt = this.f298763d.getChildAt(i3);
                if (childAt != null && (childAt.getTag() instanceof TroopShortcutBarApp) && ((TroopShortcutBarApp) childAt.getTag()).getAppId() == j3) {
                    r(childAt, 0, false);
                    return;
                }
            }
        }
    }

    @Override // com.tencent.mobileqq.troop.shortcutbar.troopapp.e
    public boolean b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Boolean) iPatchRedirector.redirect((short) 6, (Object) this)).booleanValue();
        }
        return this.f298768i;
    }

    @Override // com.tencent.mobileqq.troop.shortcutbar.b
    public void c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
            return;
        }
        this.f298769j = false;
        this.f298768i = false;
        this.f298773n = null;
    }

    @Override // com.tencent.mobileqq.troop.shortcutbar.b
    public void d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this);
        }
    }

    @Override // com.tencent.mobileqq.troop.shortcutbar.troopapp.e
    public void e() {
        String valueOf;
        TroopInfo k3;
        int i3;
        int i16;
        TroopShortcutBarApp troopShortcutBarApp;
        int i17;
        AppShortcutBarPanel appShortcutBarPanel = this;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) appShortcutBarPanel);
            return;
        }
        if (appShortcutBarPanel.f298761b == null || appShortcutBarPanel.f298763d == null || appShortcutBarPanel.f298773n == null || (k3 = ((TroopManager) appShortcutBarPanel.f298773n.getManager(QQManagerFactory.TROOP_MANAGER)).k((valueOf = String.valueOf(appShortcutBarPanel.f298766g)))) == null) {
            return;
        }
        Rect rect = new Rect();
        appShortcutBarPanel.f298761b.getHitRect(rect);
        int i18 = 0;
        int i19 = 0;
        while (i19 < appShortcutBarPanel.f298763d.getChildCount()) {
            View childAt = appShortcutBarPanel.f298763d.getChildAt(i19);
            if (childAt != null && childAt.getLocalVisibleRect(rect)) {
                Object tag = childAt.getTag();
                if ((tag instanceof TroopShortcutBarApp) && (troopShortcutBarApp = (TroopShortcutBarApp) tag) != null) {
                    long appId = troopShortcutBarApp.getAppId();
                    Iterator<Long> it = appShortcutBarPanel.f298767h.iterator();
                    while (true) {
                        if (it.hasNext()) {
                            if (it.next().longValue() == appId) {
                                i17 = 1;
                                break;
                            }
                        } else {
                            i17 = i18;
                            break;
                        }
                    }
                    if (i17 == 0) {
                        appShortcutBarPanel.f298767h.add(Long.valueOf(appId));
                        i3 = i19;
                        i16 = i18;
                        ReportController.o(null, "dc00898", "", "", "0X800AAD3", "0X800AAD3", 0, 0, String.valueOf(appId), valueOf, String.valueOf(k3.dwGroupClassExt), "");
                        if (appId == 101914115) {
                            QQGameTroopManager.p(i16, valueOf, true);
                        }
                        VideoReport.setElementId(childAt, "em_group_app_capsule");
                        VideoReport.setElementExposePolicy(childAt, ExposurePolicy.REPORT_ALL);
                        VideoReport.setElementClickPolicy(childAt, ClickPolicy.REPORT_ALL);
                        HashMap hashMap = new HashMap();
                        hashMap.put("appid", Long.valueOf(appId));
                        hashMap.put("ad_id", troopShortcutBarApp.getAdId());
                        hashMap.put("element_type", QCircleDaTongConstant.ElementParamValue.XSJ_SHARE_PANEL_STYLE_OLD);
                        VideoReport.setElementParams(childAt, hashMap);
                        i19 = i3 + 1;
                        i18 = i16;
                        appShortcutBarPanel = this;
                    }
                }
            }
            i3 = i19;
            i16 = i18;
            i19 = i3 + 1;
            i18 = i16;
            appShortcutBarPanel = this;
        }
    }

    @Override // com.tencent.mobileqq.troop.shortcutbar.troopapp.e
    public void f(ArrayList<ShortcutBarInfo> arrayList, boolean z16) {
        boolean z17;
        View b16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, arrayList, Boolean.valueOf(z16));
            return;
        }
        if (this.f298761b == null) {
            return;
        }
        if (arrayList != null && !arrayList.isEmpty()) {
            this.f298768i = false;
            LinearLayout linearLayout = this.f298763d;
            if (linearLayout == null) {
                return;
            }
            linearLayout.removeAllViews();
            if (this.f298764e.getChildCount() == 0) {
                z17 = true;
            } else {
                z17 = false;
            }
            this.f298770k = new b();
            boolean isSwitchOn = ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("shortcut_9085_125972787", true);
            Iterator<ShortcutBarInfo> it = arrayList.iterator();
            long j3 = 0;
            int i3 = 1;
            boolean z18 = false;
            while (it.hasNext()) {
                ShortcutBarInfo next = it.next();
                if (next != null && (next instanceof TroopShortcutBarApp) && (((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("102812", true) || next.getAppId() != 10000)) {
                    TroopShortcutBarApp troopShortcutBarApp = (TroopShortcutBarApp) next;
                    if (isSwitchOn) {
                        try {
                            b16 = new f().b(this.f298772m);
                        } catch (InflateException e16) {
                            if (QLog.isColorLevel()) {
                                QLog.e("AppShortcutBarPanel", 2, "AppShortcutBarPanel.updateAppShortcutPanel got InflateException, e:" + e16.getMessage());
                            }
                            System.gc();
                            return;
                        } catch (OutOfMemoryError e17) {
                            if (QLog.isColorLevel()) {
                                QLog.e("AppShortcutBarPanel", 2, "AppShortcutBarPanel.updateAppShortcutPanel got OOM, e:" + e17.getMessage());
                            }
                            System.gc();
                            return;
                        }
                    } else {
                        b16 = View.inflate(this.f298772m, R.layout.bvm, null);
                    }
                    p(troopShortcutBarApp, b16);
                    this.f298763d.addView(b16);
                    b16.setId((int) troopShortcutBarApp.getAppId());
                    this.f298770k.f298777b = b16.getWidth();
                    if (z17) {
                        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) b16.getLayoutParams();
                        layoutParams.setMargins(ViewUtils.dip2px(16.0f), 0, 0, 0);
                        b16.setLayoutParams(layoutParams);
                        z17 = false;
                    }
                    if ((troopShortcutBarApp.getAddPoint() || troopShortcutBarApp.getNeedScroll()) && this.f298764e.getChildCount() == 0) {
                        this.f298770k.f298778c = true;
                        if (troopShortcutBarApp.getNeedScroll()) {
                            j3 = troopShortcutBarApp.getaddts();
                            b bVar = this.f298770k;
                            bVar.f298776a = i3;
                            bVar.f298779d = troopShortcutBarApp.getAppId();
                        } else if (troopShortcutBarApp.getAddPoint() && troopShortcutBarApp.getaddts() > j3) {
                            j3 = troopShortcutBarApp.getaddts();
                            b bVar2 = this.f298770k;
                            if (i3 > bVar2.f298776a) {
                                bVar2.f298776a = i3;
                                bVar2.f298779d = troopShortcutBarApp.getAppId();
                            }
                        }
                    }
                    if (i3 == 4) {
                        this.f298770k.f298780e = troopShortcutBarApp.getAppId();
                    }
                    i3++;
                    if (troopShortcutBarApp.getNeedScroll()) {
                        troopShortcutBarApp.setNeedScroll(false);
                    }
                    z18 = true;
                }
            }
            this.f298768i = z18;
            if (z18 && z16) {
                try {
                    q();
                } catch (InflateException e18) {
                    if (QLog.isColorLevel()) {
                        QLog.e("AppShortcutBarPanel", 2, "ShortcutBarAioHelper.updateAppShortcutPanel ManageBtn got InflateException, e:" + e18.getMessage());
                    }
                    System.gc();
                    return;
                } catch (OutOfMemoryError e19) {
                    if (QLog.isColorLevel()) {
                        QLog.e("AppShortcutBarPanel", 2, "AppShortcutBarPanel.updateAppShortcutPanel ManageBtn got OOM, e:" + e19.getMessage());
                    }
                    System.gc();
                    return;
                }
            }
            if (z18) {
                if (QLog.isColorLevel()) {
                    QLog.d("AppShortcutBarPanel", 2, "AppShortcutBarPanel.bShow -> resumeAppShortcutBar");
                }
                this.f298765f.H();
                if (!this.f298769j && this.f298773n != null) {
                    this.f298769j = true;
                    o();
                }
                ThreadManager.getUIHandler().postDelayed(new Runnable() { // from class: com.tencent.mobileqq.troop.shortcutbar.troopapp.AppShortcutBarPanel.1
                    static IPatchRedirector $redirector_;

                    {
                        IPatchRedirector iPatchRedirector2 = $redirector_;
                        if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                            iPatchRedirector2.redirect((short) 1, (Object) this, (Object) AppShortcutBarPanel.this);
                        }
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        IPatchRedirector iPatchRedirector2 = $redirector_;
                        if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                            iPatchRedirector2.redirect((short) 2, (Object) this);
                            return;
                        }
                        AppShortcutBarPanel.this.e();
                        if (AppShortcutBarPanel.this.f298761b != null && AppShortcutBarPanel.this.f298763d != null && AppShortcutBarPanel.this.f298764e != null && AppShortcutBarPanel.this.f298770k != null && AppShortcutBarPanel.this.f298770k.f298778c && AppShortcutBarPanel.this.f298770k.f298776a > 4 && AppShortcutBarPanel.this.f298764e.getChildCount() == 0) {
                            View findViewById = AppShortcutBarPanel.this.f298763d.findViewById((int) AppShortcutBarPanel.this.f298770k.f298779d);
                            View findViewById2 = AppShortcutBarPanel.this.f298763d.findViewById((int) AppShortcutBarPanel.this.f298770k.f298780e);
                            if (findViewById != null && findViewById2 != null) {
                                AppShortcutBarPanel.this.f298761b.scrollBy(findViewById.getLeft() - findViewById2.getLeft(), 0);
                            }
                        }
                    }
                }, 800L);
                return;
            }
            this.f298768i = false;
            TroopAppShortcutBarHelper troopAppShortcutBarHelper = this.f298765f;
            if (troopAppShortcutBarHelper != null) {
                troopAppShortcutBarHelper.t();
                return;
            }
            return;
        }
        this.f298763d.removeAllViews();
        if (this.f298764e.getChildCount() == 0) {
            this.f298765f.t();
        }
        this.f298768i = false;
    }
}

package com.tencent.mobileqq.c2cshortcutbar;

import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.RelativeLayout;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.aio.helper.TroopAppShortcutBarHelper;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.c2cshortcutbar.c;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.widget.OverScrollCallbackHorizontalListView;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;
import java.util.List;

/* compiled from: P */
/* loaded from: classes11.dex */
public class a extends TroopAppShortcutBarHelper {
    static IPatchRedirector $redirector_;
    private c.a A;
    private C2CShortcutBarJumpController B;
    f C;

    /* renamed from: v, reason: collision with root package name */
    private OverScrollCallbackHorizontalListView f200927v;

    /* renamed from: w, reason: collision with root package name */
    private com.tencent.mobileqq.c2cshortcutbar.c f200928w;

    /* renamed from: x, reason: collision with root package name */
    private long f200929x;

    /* renamed from: y, reason: collision with root package name */
    private boolean f200930y;

    /* renamed from: z, reason: collision with root package name */
    private List<com.tencent.mobileqq.c2cshortcutbar.b> f200931z;

    /* compiled from: P */
    /* renamed from: com.tencent.mobileqq.c2cshortcutbar.a$a, reason: collision with other inner class name */
    /* loaded from: classes11.dex */
    class C7441a implements c.a {
        static IPatchRedirector $redirector_;

        C7441a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) a.this);
            }
        }

        @Override // com.tencent.mobileqq.c2cshortcutbar.c.a
        public void a(com.tencent.mobileqq.c2cshortcutbar.b bVar, int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                a.this.b0(bVar, i3);
            } else {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) bVar, i3);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes11.dex */
    class b extends f {
        static IPatchRedirector $redirector_;

        b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) a.this);
            }
        }

        @Override // com.tencent.mobileqq.c2cshortcutbar.f
        public void a(boolean z16, long j3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, this, Boolean.valueOf(z16), Long.valueOf(j3));
                return;
            }
            if (a.this.f200929x != j3) {
                return;
            }
            if (QLog.isColorLevel()) {
                QLog.d("C2CShortcutBarObserver", 2, "onRecieveNewC2CShortcutAppListPush");
            }
            if (z16) {
                a.this.c0();
            }
        }

        @Override // com.tencent.mobileqq.c2cshortcutbar.f
        protected void b(boolean z16, long j3, List<com.tencent.mobileqq.c2cshortcutbar.b> list) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, Boolean.valueOf(z16), Long.valueOf(j3), list);
                return;
            }
            if (a.this.f200929x != j3) {
                return;
            }
            if (QLog.isColorLevel()) {
                QLog.d("C2CShortcutBarObserver", 2, "C2CShortcutBarAIOHelper onRequestC2cShortcutAppList");
            }
            if (z16) {
                a.this.f200928w.b(e.d(a.this.h()).g(Long.valueOf(j3)));
                a.this.H();
            }
        }

        @Override // com.tencent.mobileqq.c2cshortcutbar.f
        public void c(boolean z16, String str, boolean z17) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                iPatchRedirector.redirect((short) 5, this, Boolean.valueOf(z16), str, Boolean.valueOf(z17));
                return;
            }
            if (z16 && ((TroopAppShortcutBarHelper) a.this).f178719n.f().equals(str)) {
                if (z17) {
                    a.this.H();
                    a.this.c0();
                } else {
                    a.this.t();
                }
            }
        }

        @Override // com.tencent.mobileqq.c2cshortcutbar.f
        public void d(boolean z16, boolean z17) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, this, Boolean.valueOf(z16), Boolean.valueOf(z17));
                return;
            }
            if (QLog.isColorLevel()) {
                QLog.d("C2CShortcutBarObserver", 2, "onSetGlobalSwitcherStatus isSuccess = " + z16 + ",isGlobalOpen = " + z17);
            }
            if (z16 && !z17) {
                a.this.t();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes11.dex */
    public class c implements AdapterView.OnItemClickListener {
        static IPatchRedirector $redirector_;

        c() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) a.this);
            }
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i3, long j3) {
            String str;
            EventCollector.getInstance().onItemClickBefore(adapterView, view, i3, j3);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, adapterView, view, Integer.valueOf(i3), Long.valueOf(j3));
            } else {
                boolean j16 = e.d(a.this.h()).j(i3, a.this.f200928w.getCount());
                if (a.this.B == null) {
                    a.this.B = new C2CShortcutBarJumpController();
                }
                a.this.B.b(((TroopAppShortcutBarHelper) a.this).f178721p, ((TroopAppShortcutBarHelper) a.this).f178719n, a.this.h(), ((TroopAppShortcutBarHelper) a.this).f178719n.g(), a.this.f200928w.getItem(i3), j16);
                QQAppInterface h16 = a.this.h();
                int f16 = e.d(a.this.h()).f(String.valueOf(a.this.f200929x));
                if (j16) {
                    str = "1";
                } else {
                    str = a.this.f200928w.getItem(i3).f200935a;
                }
                ReportController.o(h16, "dc00898", "", "", "0X800B32A", "0X800B32A", f16, 0, str, i3 + "", "", "");
            }
            EventCollector.getInstance().onItemClick(adapterView, view, i3, j3);
        }
    }

    public a(com.tencent.mobileqq.activity.aio.rebuild.input.shortcutbar.d dVar) {
        super(dVar);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) dVar);
            return;
        }
        this.f200931z = new ArrayList();
        this.A = new C7441a();
        this.C = new b();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b0(com.tencent.mobileqq.c2cshortcutbar.b bVar, int i3) {
        if (bVar == null || this.f200931z.contains(bVar)) {
            return;
        }
        ReportController.o(null, "dc00898", "", "", "0X800B329", "0X800B329", e.d(h()).f(String.valueOf(this.f200929x)), 0, bVar.f200935a, String.valueOf(i3), "", "");
        this.f200931z.add(bVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c0() {
        if (!g.a(h(), String.valueOf(this.f200929x), a0())) {
            if (QLog.isColorLevel()) {
                QLog.d("C2CShortcutBarAIOHelper", 2, "tryRequestAppList return for switch limit");
            }
        } else if (!e.d(h()).a(Long.valueOf(this.f200929x))) {
            if (QLog.isColorLevel()) {
                QLog.d("C2CShortcutBarAIOHelper", 2, "tryRequestAppList return for ts limit");
            }
        } else {
            if (QLog.isColorLevel()) {
                QLog.d("C2CShortcutBarAIOHelper", 2, "tryRequestAppList ");
            }
            e.d(h()).c().I2(this.f200929x, a0(), false, 0, "");
        }
    }

    @Override // com.tencent.mobileqq.activity.aio.helper.TroopAppShortcutBarHelper
    protected void B() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
        } else {
            v();
        }
    }

    @Override // com.tencent.mobileqq.activity.aio.helper.TroopAppShortcutBarHelper
    public void C() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("C2CShortcutBarAIOHelper", 2, "onChatPieDestroy");
        }
        h().removeObserver(this.C);
        this.f200930y = false;
        this.f200931z.clear();
        C2CShortcutBarJumpController c2CShortcutBarJumpController = this.B;
        if (c2CShortcutBarJumpController != null) {
            c2CShortcutBarJumpController.a();
        }
        OverScrollCallbackHorizontalListView overScrollCallbackHorizontalListView = this.f200927v;
        if (overScrollCallbackHorizontalListView != null && overScrollCallbackHorizontalListView.getParent() != null && QLog.isColorLevel()) {
            QLog.d("C2CShortcutBarAIOHelper", 2, "onChatPieDestroy remove shortcutContainer");
        }
        super.C();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.activity.aio.helper.TroopAppShortcutBarHelper
    public void E() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("C2CShortcutBarAIOHelper", 2, "onChatPieResume");
        }
        super.E();
        H();
    }

    @Override // com.tencent.mobileqq.activity.aio.helper.TroopAppShortcutBarHelper
    public void H() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            iPatchRedirector.redirect((short) 15, (Object) this);
            return;
        }
        if (!g.a(h(), String.valueOf(this.f200929x), a0())) {
            if (QLog.isColorLevel()) {
                QLog.d("C2CShortcutBarAIOHelper", 2, "resumeAppShorcutBar return for switch off");
            }
        } else {
            if (a0() == 1 && this.f178719n.h()) {
                if (QLog.isColorLevel()) {
                    QLog.d("C2CShortcutBarAIOHelper", 2, "resumeAppShorcutBar return for one way friend");
                    return;
                }
                return;
            }
            super.H();
        }
    }

    @Override // com.tencent.mobileqq.activity.aio.helper.TroopAppShortcutBarHelper
    public void I() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this);
        } else {
            super.I();
            j().setPadding(k(), m(), l(), 0);
        }
    }

    @Override // com.tencent.mobileqq.activity.aio.helper.TroopAppShortcutBarHelper
    protected void J() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this);
        }
    }

    public int a0() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return ((Integer) iPatchRedirector.redirect((short) 8, (Object) this)).intValue();
        }
        if (this.f178719n.b() == 5) {
            return 2;
        }
        return 1;
    }

    @Override // com.tencent.mobileqq.activity.aio.helper.TroopAppShortcutBarHelper
    protected boolean e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            return ((Boolean) iPatchRedirector.redirect((short) 17, (Object) this)).booleanValue();
        }
        return this.f178718m.b(1);
    }

    @Override // com.tencent.mobileqq.activity.aio.helper.TroopAppShortcutBarHelper
    protected boolean f() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            return ((Boolean) iPatchRedirector.redirect((short) 16, (Object) this)).booleanValue();
        }
        if (x() && this.f178718m.c(1)) {
            return true;
        }
        return false;
    }

    @Override // com.tencent.mobileqq.activity.aio.helper.TroopAppShortcutBarHelper
    public ViewGroup.LayoutParams i() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (ViewGroup.LayoutParams) iPatchRedirector.redirect((short) 6, (Object) this);
        }
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, ViewUtils.dip2px(39.0f));
        layoutParams.addRule(2, R.id.inputBar);
        return layoutParams;
    }

    @Override // com.tencent.mobileqq.activity.aio.helper.TroopAppShortcutBarHelper
    protected View j() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return (View) iPatchRedirector.redirect((short) 11, (Object) this);
        }
        return this.f200927v;
    }

    @Override // com.tencent.mobileqq.activity.aio.helper.TroopAppShortcutBarHelper
    protected int k() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            return ((Integer) iPatchRedirector.redirect((short) 12, (Object) this)).intValue();
        }
        return ViewUtils.dip2px(14.0f);
    }

    @Override // com.tencent.mobileqq.activity.aio.helper.TroopAppShortcutBarHelper
    protected int l() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            return ((Integer) iPatchRedirector.redirect((short) 13, (Object) this)).intValue();
        }
        return ViewUtils.dip2px(14.0f);
    }

    @Override // com.tencent.mobileqq.activity.aio.helper.TroopAppShortcutBarHelper
    protected int m() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            return ((Integer) iPatchRedirector.redirect((short) 14, (Object) this)).intValue();
        }
        return ViewUtils.dip2px(10.0f);
    }

    @Override // com.tencent.mobileqq.activity.aio.helper.TroopAppShortcutBarHelper
    public View q() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (View) iPatchRedirector.redirect((short) 5, (Object) this);
        }
        return this.f200927v;
    }

    @Override // com.tencent.mobileqq.activity.aio.helper.TroopAppShortcutBarHelper
    public void v() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
            return;
        }
        if (h() == null) {
            if (QLog.isColorLevel()) {
                QLog.e("C2CShortcutBarAIOHelper", 2, "init mChatPie.app is null");
                return;
            }
            return;
        }
        try {
            this.f200929x = Long.parseLong(this.f178719n.g().f179557e);
        } catch (NumberFormatException e16) {
            if (QLog.isColorLevel()) {
                QLog.e("C2CShortcutBarAIOHelper", 2, "init Exception", e16);
            }
        }
        List<com.tencent.mobileqq.c2cshortcutbar.b> g16 = e.d(h()).g(Long.valueOf(this.f200929x));
        if (QLog.isColorLevel()) {
            QLog.d("C2CShortcutBarAIOHelper", 2, "init friendUin = " + this.f200929x + ",appListSize = " + g16.size());
        }
        this.f200928w = new com.tencent.mobileqq.c2cshortcutbar.c(this.f178720o, g16, this.A);
        OverScrollCallbackHorizontalListView overScrollCallbackHorizontalListView = new OverScrollCallbackHorizontalListView(this.f178720o);
        this.f200927v = overScrollCallbackHorizontalListView;
        overScrollCallbackHorizontalListView.setId(R.id.ics);
        this.f200927v.setAdapter((ListAdapter) this.f200928w);
        this.f200927v.setOnItemClickListener(new c());
        this.f200927v.setOverScrollMode(0);
        this.f200927v.setDividerWidth(ViewUtils.dip2px(8.0f));
        this.f200927v.setPadding(ViewUtils.dip2px(14.0f), ViewUtils.dip2px(10.0f), 0, 0);
        this.f200927v.setClipToPadding(false);
        this.f178718m.b(1);
        h().addObserver(this.C);
        c0();
    }

    @Override // com.tencent.mobileqq.activity.aio.helper.TroopAppShortcutBarHelper
    public boolean x() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            return ((Boolean) iPatchRedirector.redirect((short) 19, (Object) this)).booleanValue();
        }
        if (!g.a(h(), String.valueOf(this.f200929x), a0())) {
            return false;
        }
        if (this.f178716k) {
            if (QLog.isColorLevel()) {
                QLog.e("C2CShortcutBarAIOHelper", 2, "isShortcutBarVisibleOrGoingToBeVisible return false for AIOIceBreakViewShowing");
            }
            return false;
        }
        int count = this.f200928w.getCount();
        if (QLog.isColorLevel()) {
            QLog.d("C2CShortcutBarAIOHelper", 2, "isShortcutBarVisibleOrGoingToBeVisible dataSize = " + count);
        }
        if (count <= 0) {
            return false;
        }
        return true;
    }
}

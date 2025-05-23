package com.tencent.mobileqq.activity.aio.helper;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.InflateException;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.troop.shortcut.api.ITroopShortcutApi;
import com.tencent.mobileqq.troop.shortcutbar.ShortcutBarInfo;
import com.tencent.mobileqq.troop.shortcutbar.importantmsg.LeftAppShortcutBarPanel;
import com.tencent.mobileqq.troop.shortcutbar.troopapp.AppShortcutBarPanel;
import com.tencent.mobileqq.troop.topicrecommend.api.ITroopTopicRecommendApi;
import com.tencent.mobileqq.troop.utils.TroopUtils;
import com.tencent.mobileqq.utils.QQTheme;
import com.tencent.mobileqq.widget.AppShortcutBarScrollView;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.aio.api.IAIOBlurApi;
import et2.c;
import java.util.ArrayList;

/* compiled from: P */
/* loaded from: classes10.dex */
public class TroopAppShortcutBarHelper {

    /* renamed from: a, reason: collision with root package name */
    public AppShortcutBarScrollView f178706a;

    /* renamed from: b, reason: collision with root package name */
    public View f178707b;

    /* renamed from: c, reason: collision with root package name */
    private boolean f178708c;

    /* renamed from: e, reason: collision with root package name */
    private long f178710e;

    /* renamed from: f, reason: collision with root package name */
    private String f178711f;

    /* renamed from: g, reason: collision with root package name */
    private com.tencent.mobileqq.troop.shortcutbar.importantmsg.a f178712g;

    /* renamed from: h, reason: collision with root package name */
    private com.tencent.mobileqq.troop.shortcutbar.troopapp.e f178713h;

    /* renamed from: i, reason: collision with root package name */
    private com.tencent.mobileqq.troop.shortcutbar.trooptopic.g f178714i;

    /* renamed from: j, reason: collision with root package name */
    private com.tencent.mobileqq.troop.shortcutbar.a f178715j;

    /* renamed from: k, reason: collision with root package name */
    protected boolean f178716k;

    /* renamed from: l, reason: collision with root package name */
    protected boolean f178717l;

    /* renamed from: m, reason: collision with root package name */
    protected com.tencent.mobileqq.activity.aio.rebuild.input.shortcutbar.d f178718m;

    /* renamed from: n, reason: collision with root package name */
    protected com.tencent.mobileqq.activity.aio.rebuild.input.shortcutbar.a f178719n;

    /* renamed from: o, reason: collision with root package name */
    protected Context f178720o;

    /* renamed from: p, reason: collision with root package name */
    protected Activity f178721p;

    /* renamed from: r, reason: collision with root package name */
    public et2.c f178723r;

    /* renamed from: s, reason: collision with root package name */
    public boolean f178724s;

    /* renamed from: d, reason: collision with root package name */
    private boolean f178709d = false;

    /* renamed from: q, reason: collision with root package name */
    private boolean f178722q = false;

    /* renamed from: t, reason: collision with root package name */
    protected boolean f178725t = false;

    /* renamed from: u, reason: collision with root package name */
    private boolean f178726u = false;

    /* compiled from: P */
    /* loaded from: classes10.dex */
    class a implements c.a {
        a() {
        }

        @Override // et2.c.a
        public void a() {
            TroopAppShortcutBarHelper.this.H();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes10.dex */
    public class b implements AppShortcutBarScrollView.a {
        b() {
        }

        @Override // com.tencent.mobileqq.widget.AppShortcutBarScrollView.a
        public void onScroll() {
            if (TroopAppShortcutBarHelper.this.f178713h != null && TroopAppShortcutBarHelper.this.f178713h.b()) {
                TroopAppShortcutBarHelper.this.f178713h.e();
            }
            if (TroopAppShortcutBarHelper.this.f178712g != null && TroopAppShortcutBarHelper.this.f178712g.a()) {
                TroopAppShortcutBarHelper.this.f178712g.b();
            }
        }
    }

    public TroopAppShortcutBarHelper(com.tencent.mobileqq.activity.aio.rebuild.input.shortcutbar.d dVar) {
        this.f178723r = null;
        this.f178724s = false;
        QLog.d("TroopAppShortcutBarHelper", 4, "TroopAppShortcutBarHelper constructor");
        this.f178718m = dVar;
        com.tencent.mobileqq.activity.aio.rebuild.input.shortcutbar.a a16 = dVar.a();
        this.f178719n = a16;
        if (a16 != null) {
            this.f178720o = a16.e();
            this.f178721p = this.f178719n.c();
        }
        long o16 = o();
        this.f178724s = ((ITroopShortcutApi) QRoute.api(ITroopShortcutApi.class)).useNewShortcut(String.valueOf(o16));
        QLog.d("TroopAppShortcutBarHelper", 1, "useNewShortcutBar = " + this.f178724s + ", troop uin is " + o16);
        if (this.f178724s) {
            this.f178723r = ((ITroopShortcutApi) QRoute.api(ITroopShortcutApi.class)).createShortcutVB();
            a aVar = new a();
            com.tencent.mobileqq.activity.aio.rebuild.input.shortcutbar.a aVar2 = this.f178719n;
            if (aVar2 != null) {
                this.f178723r.d(aVar2.a(), aVar);
            } else {
                QLog.e("TroopAppShortcutBarHelper", 1, "aioShortcutBarContext is null, init newShortcutVB failed");
            }
        }
        J();
        QLog.d("TroopAppShortcutBarHelper", 4, "TroopAppShortcutBarHelper constructor end");
    }

    private boolean g(com.tencent.mobileqq.activity.aio.rebuild.input.shortcutbar.a aVar) {
        com.tencent.aio.api.runtime.a a16;
        boolean z16 = false;
        if (aVar == null || (a16 = aVar.a()) == null) {
            return false;
        }
        int e16 = a16.g().r().c().e();
        String j3 = a16.g().r().c().j();
        Long valueOf = Long.valueOf(a16.g().l().getLong("key_peerUin"));
        boolean z17 = a16.g().l().getBoolean("key_is_scale_chat");
        boolean z18 = a16.g().l().getBoolean("key_is_miniaio");
        if (!z17 && !z18) {
            z16 = true;
        }
        return ((IAIOBlurApi) com.tencent.qqnt.aio.adapter.a.b(IAIOBlurApi.class)).enableBlur(new com.tencent.qqnt.aio.data.b(Integer.valueOf(e16), j3, valueOf, z16));
    }

    private void s(Bundle bundle) {
        if (bundle != null) {
            this.f178717l = bundle.getBoolean("isSelectMode");
        }
        et2.c cVar = this.f178723r;
        if (cVar != null) {
            cVar.b(this.f178717l);
        }
        if (this.f178717l) {
            t();
        } else {
            H();
        }
    }

    private void w(boolean z16) {
        if (!this.f178722q && z16) {
            long currentTimeMillis = System.currentTimeMillis();
            this.f178722q = true;
            v();
            if (QLog.isColorLevel()) {
                QLog.i("TroopAppShortcutBarHelper_perf", 2, "initShortcutBar cost: " + (System.currentTimeMillis() - currentTimeMillis));
            }
        }
    }

    private boolean y() {
        com.tencent.mobileqq.troop.shortcutbar.trooptopic.g gVar = this.f178714i;
        if (gVar != null && gVar.x()) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void z() {
        com.tencent.mobileqq.troop.shortcutbar.d dVar = new com.tencent.mobileqq.troop.shortcutbar.d(this.f178719n, this);
        this.f178715j = dVar;
        try {
            dVar.b();
        } catch (Exception e16) {
            QLog.e("TroopAppShortcutBarHelper", 1, "loadData error", e16);
        }
    }

    public void A(boolean z16) {
        if (QLog.isColorLevel()) {
            QLog.d("TroopAppShortcutBarHelper", 2, "notifyAIOIceBreakViewShowingStatus isShow = " + z16);
        }
        this.f178716k = z16;
        if (z16) {
            t();
        } else {
            H();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void C() {
        if (QLog.isColorLevel()) {
            QLog.e("TroopAppShortcutBarHelper", 2, "ShortcutBarAioHelper.onChatPieDestroy");
        }
        et2.c cVar = this.f178723r;
        if (cVar != null) {
            cVar.destroy();
        }
        com.tencent.mobileqq.troop.shortcutbar.importantmsg.a aVar = this.f178712g;
        if (aVar != null) {
            aVar.c();
            this.f178712g = null;
        }
        com.tencent.mobileqq.troop.shortcutbar.troopapp.e eVar = this.f178713h;
        if (eVar != null) {
            eVar.c();
            this.f178713h = null;
        }
        com.tencent.mobileqq.troop.shortcutbar.trooptopic.g gVar = this.f178714i;
        if (gVar != null) {
            this.f178726u = false;
            gVar.c();
            this.f178714i = null;
        }
        com.tencent.mobileqq.troop.shortcutbar.a aVar2 = this.f178715j;
        if (aVar2 != null) {
            aVar2.c();
            this.f178715j = null;
        }
        if (QLog.isColorLevel()) {
            QLog.d("TroopAppShortcutBarHelper", 2, "onChatPieDestroy. ");
        }
        t();
        AppShortcutBarScrollView appShortcutBarScrollView = this.f178706a;
        if (appShortcutBarScrollView != null) {
            appShortcutBarScrollView.fullScroll(17);
            this.f178706a.removeAllViews();
            if (this.f178706a.getParent() != null && (this.f178706a.getParent() instanceof ViewGroup)) {
                ((ViewGroup) this.f178706a.getParent()).removeView(this.f178706a);
            }
            this.f178706a.setOnScrollChangedListener(null);
            this.f178706a = null;
        }
        this.f178707b = null;
        this.f178709d = false;
    }

    public void D(int i3, Bundle bundle) {
        QLog.i("TroopAppShortcutBarHelper", 1, "onChatPieEvent:" + i3);
        if (i3 != 1) {
            if (i3 != 11) {
                if (i3 != 12) {
                    switch (i3) {
                        case 3:
                            E();
                            return;
                        case 4:
                            C();
                            return;
                        case 5:
                            break;
                        case 6:
                            A(true);
                            return;
                        case 7:
                            A(false);
                            return;
                        case 8:
                            I();
                            return;
                        default:
                            switch (i3) {
                                case 28:
                                    s(bundle);
                                    return;
                                case 29:
                                    r();
                                    return;
                                case 30:
                                    com.tencent.mobileqq.troop.shortcutbar.a aVar = this.f178715j;
                                    if (aVar != null) {
                                        aVar.g();
                                    }
                                    et2.c cVar = this.f178723r;
                                    if (cVar != null) {
                                        cVar.pause();
                                        return;
                                    }
                                    return;
                                default:
                                    return;
                            }
                    }
                } else {
                    if (bundle != null) {
                        this.f178725t = bundle.getBoolean("InputJump", this.f178725t);
                    }
                    H();
                    return;
                }
            }
            if (bundle != null) {
                this.f178725t = bundle.getBoolean("InputJump", this.f178725t);
            }
            t();
            return;
        }
        B();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void E() {
        if (QLog.isColorLevel()) {
            QLog.e("TroopAppShortcutBarHelper", 2, "ShortcutBarAioHelper.onChatPieResume");
        }
        if (this.f178724s) {
            this.f178723r.a();
        }
        if (this.f178709d) {
            this.f178709d = false;
        }
        com.tencent.mobileqq.troop.shortcutbar.importantmsg.a aVar = this.f178712g;
        if (aVar != null) {
            aVar.d();
        }
        com.tencent.mobileqq.troop.shortcutbar.troopapp.e eVar = this.f178713h;
        if (eVar != null) {
            eVar.d();
        }
        com.tencent.mobileqq.troop.shortcutbar.a aVar2 = this.f178715j;
        if (aVar2 != null) {
            aVar2.d();
        }
    }

    public void F(View view) {
        com.tencent.mobileqq.troop.shortcutbar.a aVar;
        if (view != null && (aVar = this.f178715j) != null) {
            aVar.f(view.getTag());
        }
    }

    public void G(int i3, ArrayList<ShortcutBarInfo> arrayList, boolean z16) {
        boolean z17;
        com.tencent.mobileqq.troop.shortcutbar.importantmsg.a aVar;
        com.tencent.mobileqq.troop.shortcutbar.trooptopic.g gVar;
        com.tencent.mobileqq.troop.shortcutbar.trooptopic.g gVar2;
        long currentTimeMillis = System.currentTimeMillis();
        if (arrayList != null && arrayList.size() > 0) {
            z17 = true;
        } else {
            z17 = false;
        }
        QLog.i("TroopAppShortcutBarHelper", 1, "onUpdatePanel from: " + i3 + ", bShowManageBtn: " + z16 + ", hasItemToShow: " + z17);
        w(z17);
        if (i3 == 6 && this.f178706a != null && z17 && (gVar2 = this.f178714i) != null) {
            this.f178726u = true;
            gVar2.J(arrayList);
        }
        if (this.f178726u) {
            return;
        }
        if (this.f178724s) {
            QLog.d("TroopAppShortcutBarHelper", 1, "useNewShortcutBar and onUpdatePanel for " + i3);
            if (i3 == 6 && z17 && (gVar = this.f178714i) != null) {
                gVar.K(arrayList);
                return;
            }
            return;
        }
        if (this.f178706a != null && this.f178712g != null && this.f178713h != null && this.f178707b != null) {
            if (i3 == 0) {
                if (arrayList != null && arrayList.size() > 0 && this.f178712g.a()) {
                    this.f178707b.setVisibility(0);
                } else {
                    this.f178707b.setVisibility(8);
                }
            } else if (arrayList != null && arrayList.size() > 0 && this.f178713h.b()) {
                this.f178707b.setVisibility(0);
            } else {
                this.f178707b.setVisibility(8);
            }
            if (i3 == 0) {
                com.tencent.mobileqq.troop.shortcutbar.troopapp.e eVar = this.f178713h;
                if (eVar != null) {
                    eVar.f(arrayList, z16);
                }
            } else if (i3 == 1 && (aVar = this.f178712g) != null) {
                aVar.e(arrayList);
            }
        } else {
            View view = this.f178707b;
            if (view != null) {
                view.setVisibility(8);
            }
        }
        if (QLog.isColorLevel()) {
            QLog.i("TroopAppShortcutBarHelper_perf", 2, "onUpdatePanel cost: " + (System.currentTimeMillis() - currentTimeMillis));
        }
    }

    public void H() {
        if (!this.f178716k && !this.f178717l) {
            if (this.f178723r != null) {
                com.tencent.mobileqq.activity.aio.rebuild.input.shortcutbar.d dVar = this.f178718m;
                if (dVar != null) {
                    dVar.c(2);
                }
                this.f178723r.show();
            }
            if (j() == null) {
                if (QLog.isColorLevel()) {
                    QLog.e("TroopAppShortcutBarHelper", 2, "ShortcutBarAioHelper.resumeAppShorcutBar getShortCutBarContainerView is null");
                    return;
                }
                return;
            } else {
                if (this.f178718m != null && !this.f178725t && f()) {
                    if (QLog.isColorLevel()) {
                        QLog.d("TroopAppShortcutBarHelper", 2, "resumeAppShorcutBar");
                    }
                    j().setPadding(k(), m(), l(), 0);
                    I();
                    K(true);
                    this.f178719n.i();
                    this.f178719n.j();
                    return;
                }
                return;
            }
        }
        if (QLog.isColorLevel()) {
            QLog.e("TroopAppShortcutBarHelper", 2, "ShortcutBarAioHelper.resumeAppShorcutBar return for AIOIceBreakViewShowing");
        }
    }

    public void I() {
        if (QLog.isColorLevel()) {
            QLog.d("TroopAppShortcutBarHelper", 2, "ShortcutBarAioHelper.setBlurViewLayout");
        }
        if (this.f178724s) {
            return;
        }
        if (j() == null) {
            if (QLog.isColorLevel()) {
                QLog.e("TroopAppShortcutBarHelper", 2, "ShortcutBarAioHelper error for containerView is null");
            }
        } else if (g(this.f178719n)) {
            this.f178706a.setBackgroundResource(R.color.ajr);
        } else if (QQTheme.isVasTheme()) {
            this.f178706a.setBackgroundResource(R.color.ajr);
        } else {
            this.f178706a.setBackgroundResource(R.drawable.qui_common_bg_nav_bottom_aio_bg);
        }
    }

    protected void J() {
        long currentTimeMillis = System.currentTimeMillis();
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.activity.aio.helper.aj
            @Override // java.lang.Runnable
            public final void run() {
                TroopAppShortcutBarHelper.this.z();
            }
        }, 16, null, true);
        if (QLog.isColorLevel()) {
            QLog.i("TroopAppShortcutBarHelper_perf", 2, "starLoadData cost: " + (System.currentTimeMillis() - currentTimeMillis));
        }
    }

    public void K(boolean z16) {
        this.f178708c = z16;
    }

    public void d(String str, long j3) {
        com.tencent.mobileqq.troop.shortcutbar.troopapp.e eVar = this.f178713h;
        if (eVar != null) {
            eVar.a(str, j3);
        }
    }

    protected boolean e() {
        return this.f178718m.b(2);
    }

    protected boolean f() {
        if (x() && this.f178718m.c(2)) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public QQAppInterface h() {
        return TroopUtils.f();
    }

    public ViewGroup.LayoutParams i() {
        if (this.f178724s) {
            return this.f178723r.getLayoutParams();
        }
        return new ViewGroup.LayoutParams(-1, -2);
    }

    protected View j() {
        return this.f178706a;
    }

    protected int k() {
        return 0;
    }

    protected int l() {
        return 0;
    }

    protected int m() {
        return 0;
    }

    public long n() {
        return this.f178710e;
    }

    public long o() {
        try {
            return Long.parseLong(this.f178719n.f());
        } catch (Exception e16) {
            QLog.e("TroopAppShortcutBarHelper", 1, "getTroopUinNoEmpty is Exception:" + e16);
            return 0L;
        }
    }

    public void onClick(View view) {
        com.tencent.mobileqq.troop.shortcutbar.a aVar;
        if (view == null || (aVar = this.f178715j) == null || this.f178724s) {
            return;
        }
        aVar.e(view.getTag());
    }

    public String p() {
        return this.f178711f;
    }

    public View q() {
        if (this.f178724s) {
            return this.f178723r.getView();
        }
        return this.f178706a;
    }

    public void r() {
        ((ITroopTopicRecommendApi) QRoute.api(ITroopTopicRecommendApi.class)).onClickNavigation(this.f178719n.f());
    }

    public void t() {
        et2.c cVar = this.f178723r;
        if (cVar != null) {
            cVar.hide();
        }
        if (j() == null || j().getVisibility() == 8 || this.f178718m == null) {
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("TroopAppShortcutBarHelper", 2, "hideAppShortcutBar");
        }
        boolean isShown = j().isShown();
        if (e()) {
            j().setPadding(k(), m(), l(), 0);
            I();
            if (isShown) {
                K(true);
            }
            this.f178719n.i();
            this.f178719n.j();
        }
    }

    public void u() {
        this.f178726u = false;
        AppShortcutBarScrollView appShortcutBarScrollView = this.f178706a;
        if (appShortcutBarScrollView != null) {
            appShortcutBarScrollView.setMove(true);
        }
        com.tencent.mobileqq.troop.shortcutbar.trooptopic.g gVar = this.f178714i;
        if (gVar != null) {
            gVar.w();
        }
        if (this.f178723r != null) {
            ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.mobileqq.activity.aio.helper.TroopAppShortcutBarHelper.3
                @Override // java.lang.Runnable
                public void run() {
                    TroopAppShortcutBarHelper.this.f178723r.c().close("topic");
                }
            });
        }
    }

    public void v() {
        com.tencent.mobileqq.activity.aio.rebuild.input.shortcutbar.d dVar = this.f178718m;
        if (dVar == null) {
            if (QLog.isColorLevel()) {
                QLog.e("TroopAppShortcutBarHelper", 2, "ShortcutBarAioHelper.init logic is null");
                return;
            }
            return;
        }
        com.tencent.mobileqq.activity.aio.rebuild.input.shortcutbar.a a16 = dVar.a();
        this.f178719n = a16;
        if (a16 == null) {
            if (QLog.isColorLevel()) {
                QLog.e("TroopAppShortcutBarHelper", 2, "ShortcutBarAioHelper.init logic getAIOShortcutBarContext is null");
                return;
            }
            return;
        }
        if (a16.d() == null) {
            if (QLog.isColorLevel()) {
                QLog.e("TroopAppShortcutBarHelper", 2, "ShortcutBarAioHelper.init logic AppRuntime is null");
                return;
            }
            return;
        }
        long o16 = o();
        this.f178710e = o16;
        this.f178711f = String.valueOf(o16);
        if (QLog.isColorLevel() && QLog.isColorLevel()) {
            QLog.e("TroopAppShortcutBarHelper", 2, "ShortcutBarAioHelper.init mTroopUinStr: " + this.f178711f);
        }
        if (this.f178724s) {
            this.f178714i = new com.tencent.mobileqq.troop.shortcutbar.trooptopic.g(this.f178719n, this.f178706a, this);
            this.f178723r.c().a(this.f178714i, "topic");
            return;
        }
        try {
            AppShortcutBarScrollView appShortcutBarScrollView = (AppShortcutBarScrollView) View.inflate(this.f178720o, R.layout.aoj, null);
            this.f178706a = appShortcutBarScrollView;
            if (appShortcutBarScrollView != null) {
                this.f178707b = appShortcutBarScrollView.findViewById(R.id.f223303f);
            }
            AppShortcutBarScrollView appShortcutBarScrollView2 = this.f178706a;
            if (appShortcutBarScrollView2 == null) {
                if (QLog.isColorLevel()) {
                    QLog.e("TroopAppShortcutBarHelper", 2, "ShortcutBarAioHelper.init mAppShortcutBarView is null");
                    return;
                }
                return;
            }
            this.f178712g = new LeftAppShortcutBarPanel(this.f178719n, appShortcutBarScrollView2, this);
            this.f178713h = new AppShortcutBarPanel(this.f178719n, this.f178706a, this);
            this.f178714i = new com.tencent.mobileqq.troop.shortcutbar.trooptopic.g(this.f178719n, this.f178706a, this);
            this.f178706a.setOnScrollChangedListener(new b());
            if (QLog.isColorLevel()) {
                QLog.d("TroopAppShortcutBarHelper", 2, "initData.");
            }
            this.f178706a.setMove(true);
        } catch (InflateException e16) {
            if (QLog.isColorLevel()) {
                QLog.e("TroopAppShortcutBarHelper", 2, "ShortcutBarAioHelper.init got InflateException, e:" + e16.getMessage());
            }
            this.f178706a = null;
            System.gc();
        } catch (OutOfMemoryError e17) {
            if (QLog.isColorLevel()) {
                QLog.e("TroopAppShortcutBarHelper", 2, "ShortcutBarAioHelper.init got OOM, e:" + e17.getMessage());
            }
            this.f178706a = null;
            System.gc();
        }
    }

    public boolean x() {
        if (this.f178716k) {
            if (QLog.isColorLevel()) {
                QLog.e("TroopAppShortcutBarHelper", 2, "isShortcutBarVisibleOrGoingToBeVisible return false for AIOIceBreakViewShowing");
            }
            return false;
        }
        com.tencent.mobileqq.troop.shortcutbar.importantmsg.a aVar = this.f178712g;
        if (aVar == null || this.f178713h == null) {
            return false;
        }
        if (!aVar.a() && !this.f178713h.b() && !y()) {
            return false;
        }
        return true;
    }

    protected void B() {
    }
}

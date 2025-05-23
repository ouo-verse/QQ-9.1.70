package a61;

import android.content.Context;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import com.tencent.mobileqq.activity.aio.InputLinearLayout;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.helper.t;
import com.tencent.mobileqq.activity.aio.l;
import com.tencent.mobileqq.activity.aio.s;
import com.tencent.mobileqq.activity.aio.w;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ck;
import com.tencent.mobileqq.bubble.ChatXListView;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.mobileqq.widget.navbar.NavBarAIO;
import com.tencent.widget.XEditTextEx;
import com.tencent.widget.XPanelContainer;
import com.tencent.widget.immersive.ImmersiveUtils;

/* compiled from: P */
@Deprecated
/* loaded from: classes10.dex */
public class c {

    /* renamed from: b, reason: collision with root package name */
    public QQAppInterface f25577b;

    /* renamed from: c, reason: collision with root package name */
    public Context f25578c;

    /* renamed from: d, reason: collision with root package name */
    public BaseActivity f25579d;

    /* renamed from: e, reason: collision with root package name */
    protected a f25580e;

    /* renamed from: f, reason: collision with root package name */
    protected XPanelContainer f25581f;

    /* renamed from: g, reason: collision with root package name */
    protected RelativeLayout f25582g;

    /* renamed from: h, reason: collision with root package name */
    public NavBarAIO f25583h;

    /* renamed from: i, reason: collision with root package name */
    public ChatXListView f25584i;

    /* renamed from: j, reason: collision with root package name */
    public s f25585j;

    /* renamed from: k, reason: collision with root package name */
    public InputLinearLayout f25586k;

    /* renamed from: l, reason: collision with root package name */
    public XEditTextEx f25587l;

    /* renamed from: m, reason: collision with root package name */
    public QQProgressDialog f25588m;

    /* renamed from: p, reason: collision with root package name */
    public ck f25591p;

    /* renamed from: s, reason: collision with root package name */
    public ViewGroup f25594s;

    /* renamed from: t, reason: collision with root package name */
    public ViewGroup f25595t;

    /* renamed from: a, reason: collision with root package name */
    public String f25576a = "BaseChatPie";

    /* renamed from: n, reason: collision with root package name */
    public SessionInfo f25589n = new SessionInfo();

    /* renamed from: o, reason: collision with root package name */
    public boolean f25590o = false;

    /* renamed from: q, reason: collision with root package name */
    boolean f25592q = true;

    /* renamed from: r, reason: collision with root package name */
    protected int f25593r = -1;

    public void a() {
        if (this.f25591p == null) {
            this.f25591p = new ck(this.f25577b.getAccount());
        }
    }

    public boolean b(int i3) {
        return false;
    }

    public ViewGroup c() {
        return this.f25594s;
    }

    public BaseActivity d() {
        return this.f25579d;
    }

    public a e() {
        return this.f25580e;
    }

    public final QQAppInterface f() {
        return this.f25577b;
    }

    public RelativeLayout g() {
        return this.f25582g;
    }

    @Deprecated
    public String h() {
        return this.f25589n.f179557e;
    }

    public int i() {
        return this.f25589n.f179555d;
    }

    public int j() {
        return this.f25593r;
    }

    public <T extends t> T k(int i3) {
        w.a("BaseChatPie.getHelper id:" + i3);
        return null;
    }

    public XPanelContainer l() {
        return this.f25581f;
    }

    public SessionInfo m() {
        return this.f25589n;
    }

    public int n() {
        if (r()) {
            return ViewUtils.dip2px(0.0f);
        }
        return ImmersiveUtils.getStatusBarHeight(this.f25578c);
    }

    public int o() {
        return l.D(this.f25578c) + n();
    }

    public void p() {
        this.f25581f.s();
    }

    public boolean r() {
        return false;
    }

    public void v() {
        XPanelContainer xPanelContainer = this.f25581f;
        if (xPanelContainer != null) {
            xPanelContainer.N(1);
        }
    }

    public void u() {
    }

    public void s(int i3) {
    }

    public final void t(int i3) {
    }

    public void w(String str) {
    }

    public void x(ChatMessage chatMessage) {
    }

    public final void q(boolean z16, boolean z17) {
    }
}

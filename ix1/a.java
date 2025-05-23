package ix1;

import android.app.Activity;
import android.text.Editable;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.TextView;
import ap0.f;
import com.tencent.aio.data.AIOParam;
import com.tencent.gamematrix.gmcg.webrtc.WebRTCSDK;
import com.tencent.guild.aio.input.at.quickAt.ui.AtPanelTouchController;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.guild.robot.components.panel.data.MultiRobotsSearch;
import com.tencent.mobileqq.guild.robot.components.panel.data.RobotInlineSearch;
import com.tencent.mobileqq.guild.robot.components.panel.data.h;
import com.tencent.mobileqq.guild.robot.components.panel.data.l;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.kernel.nativeinterface.CommonBotFeatureInfo;
import com.tencent.qqnt.kernel.nativeinterface.CommonBotFeatures;
import com.tencent.qqnt.kernel.nativeinterface.CommonBotInfo;
import com.tencent.qqnt.kernel.nativeinterface.GProGuildRobotInlineLayout;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mx1.RobotFeatureItem;
import uo0.p;

/* compiled from: P */
/* loaded from: classes14.dex */
public class a implements uw1.a, PopupWindow.OnDismissListener {
    private lx1.d C;
    private View D;
    private LinearLayout E;
    private ListView F;
    public mx1.c G;
    private l H;
    private h I;
    private String J;
    private CommonBotInfo K;
    private int M;
    private int N;
    private jx1.c Q;
    private jx1.d R;

    /* renamed from: d, reason: collision with root package name */
    public com.tencent.aio.api.runtime.a f408906d;

    /* renamed from: e, reason: collision with root package name */
    private Activity f408907e;

    /* renamed from: f, reason: collision with root package name */
    private final ViewGroup f408908f;

    /* renamed from: h, reason: collision with root package name */
    private final AIOParam f408909h;

    /* renamed from: i, reason: collision with root package name */
    private final EditText f408910i;

    /* renamed from: m, reason: collision with root package name */
    private lx1.b f408911m;
    private int P = -1;
    private int S = 1000;
    private Long T = 0L;
    private boolean U = true;
    private boolean V = false;
    private boolean W = false;
    private ArrayList<jx1.a> L = new ArrayList<>();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* renamed from: ix1.a$a, reason: collision with other inner class name */
    /* loaded from: classes14.dex */
    public class C10553a extends d {
        C10553a() {
        }

        @Override // ze1.d
        public void d(ze1.c cVar, String str, String str2, int i3) {
            QLog.e("GuildRobotTag:RobotAtManager", 1, "FunctionSearch onSearchError\uff0ckeyword:" + str + ", errMsg:" + str2);
            a.this.U = false;
            int i16 = f.robotFunctionPanelBlockTime;
            if (i16 != 0) {
                f.robotFunctionPanelBlockTime = i16 - 1;
            }
        }

        @Override // ze1.d
        public void e(ze1.c cVar, String str, List list, Object obj) {
            QLog.i("GuildRobotTag:RobotAtManager", 2, "on FunctionSearch Result\uff0clist: " + list);
            if (list.size() == 1 && a.this.f408907e != null && !a.this.f408907e.isFinishing()) {
                CommonBotFeatures commonBotFeatures = (CommonBotFeatures) list.get(0);
                a.this.K = commonBotFeatures.getBotInfo();
                a aVar = a.this;
                aVar.W = aVar.M();
                ArrayList arrayList = new ArrayList(commonBotFeatures.getCommandInfo().size() + commonBotFeatures.getServiceInfo().size());
                Iterator<CommonBotFeatureInfo> it = commonBotFeatures.getCommandInfo().iterator();
                while (it.hasNext()) {
                    arrayList.add(new RobotFeatureItem(0, it.next()));
                }
                Iterator<CommonBotFeatureInfo> it5 = commonBotFeatures.getServiceInfo().iterator();
                while (it5.hasNext()) {
                    arrayList.add(new RobotFeatureItem(1, it5.next()));
                }
                if (a.this.W && a.this.V) {
                    if (QLog.isColorLevel()) {
                        QLog.i("GuildRobotTag:RobotAtManager", 1, "FunctionSearch, search command added.");
                    }
                    if (arrayList.isEmpty() || !h34.a.d(((RobotFeatureItem) arrayList.get(0)).getFeatureInfo())) {
                        arrayList.add(0, new RobotFeatureItem(0, h34.a.a()));
                    }
                }
                if (arrayList.size() == 0) {
                    QLog.w("GuildRobotTag:RobotAtManager", 1, "FunctionSearch Result, function size = 0");
                    a.this.U = false;
                    int i3 = f.robotFunctionPanelBlockTime;
                    if (i3 != 0) {
                        f.robotFunctionPanelBlockTime = i3 - 1;
                    }
                    hx1.a.a().b(a.this.K);
                    a.this.z(true);
                    return;
                }
                int i16 = f.robotFunctionPanelBlockTime;
                if (i16 != 0) {
                    f.robotFunctionPanelBlockTime = i16 - 1;
                } else if (this.f408915d) {
                    a aVar2 = a.this;
                    boolean U = aVar2.U(aVar2.K, arrayList);
                    if (!TextUtils.isEmpty(str) && U) {
                        a.this.A(str);
                    }
                }
                hx1.a.a().b(a.this.K);
                return;
            }
            QLog.w("GuildRobotTag:RobotAtManager", 1, "FunctionSearch Result, list size wrong:" + list.size());
            a.this.U = false;
            int i17 = f.robotFunctionPanelBlockTime;
            if (i17 != 0) {
                f.robotFunctionPanelBlockTime = i17 - 1;
            }
            a.this.z(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes14.dex */
    public class b implements p.b {
        b() {
        }

        @Override // ze1.d
        public void d(ze1.c cVar, String str, String str2, int i3) {
            QLog.e("GuildRobotTag:RobotAtManager", 1, "InlineSearch onSearchError\uff0ckeyword:" + str + ", errMsg:" + str2);
            a.this.I();
        }

        @Override // ze1.d
        public void e(ze1.c cVar, String str, List list, Object obj) {
            if (QLog.isColorLevel()) {
                QLog.i("GuildRobotTag:RobotAtManager", 2, "on InlineSearch Result\uff0csize:" + list.size());
            }
            if (list.size() == 0) {
                a.this.z(false);
                a.this.X(1);
            } else {
                a.this.V(list, str);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes14.dex */
    public class c implements View.OnTouchListener {
        c() {
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            if (motionEvent.getAction() == 4 && AtPanelTouchController.f(a.this.f408910i, motionEvent)) {
                return true;
            }
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes14.dex */
    public static abstract class d implements p.b {

        /* renamed from: d, reason: collision with root package name */
        boolean f408915d = false;

        d() {
        }
    }

    public a(Activity activity, ViewGroup viewGroup, AIOParam aIOParam, EditText editText) {
        this.f408907e = activity;
        this.f408908f = viewGroup;
        this.f408909h = aIOParam;
        this.f408910i = editText;
        MultiRobotsSearch.D(sx1.f.f());
        J();
    }

    private void K() {
        if (QLog.isColorLevel()) {
            QLog.i("GuildRobotTag:RobotAtManager", 2, "initPanel");
        }
        lx1.b h16 = lx1.b.h(this.f408907e);
        this.f408911m = h16;
        h16.setTouchInterceptor(new c());
        this.f408911m.setOnDismissListener(this);
    }

    private boolean N(String str) {
        return str.startsWith("/\u641c\u7d22 ");
    }

    private boolean S(String str) {
        if (!TextUtils.isEmpty(str) && G().equals(hx1.b.b(this.f408910i)) && str.equals(str.trim()) && !str.contains(" ") && str.length() <= 12) {
            return true;
        }
        return false;
    }

    private boolean T(String str) {
        if (!N(str)) {
            return false;
        }
        if ((4 < str.length() && str.substring(4).contains(" ")) || str.replaceFirst("/\u641c\u7d22", "").trim().length() < 2) {
            return false;
        }
        return true;
    }

    private void W(int i3) {
        this.N = i3;
        if (!this.f408907e.isDestroyed() && !this.f408907e.isFinishing() && this.f408911m.isShowing()) {
            Q(i3);
            return;
        }
        yo0.b.d(this.f408907e);
        this.f408911m.F();
        this.f408911m.showAtLocation(this.D, 0, 0, 0);
        this.f408911m.N(yo0.b.b(this.D), this.D.getBottom(), -1);
        this.f408911m.C();
        Q(i3);
    }

    private void Y(boolean z16, String str) {
        this.K = null;
        this.W = M();
        P(1);
        if (this.I == null) {
            this.I = new h(new C10553a());
        }
        p.b u16 = this.I.u();
        if (u16 instanceof d) {
            ((d) u16).f408915d = z16;
        }
        ArrayList arrayList = new ArrayList();
        arrayList.add(this.J);
        this.I.v(arrayList, com.tencent.guild.aio.util.a.g(this.f408909h), com.tencent.guild.aio.util.a.b(this.f408909h), this.J, str, 1, true);
    }

    private void Z(String str) {
        if (this.H == null) {
            this.H = new l(new b());
        }
        X(0);
        this.H.u(this.J, com.tencent.guild.aio.util.a.g(this.f408909h), com.tencent.guild.aio.util.a.b(this.f408909h), str);
    }

    private void v(int i3, String str) {
        if (!G().equals(hx1.b.b(this.f408910i))) {
            i(hx1.b.b(this.f408910i));
        }
        l(this.f408910i, str, 0, true);
        R(i3);
    }

    private void w(String str) {
        if (this.V && this.W) {
            P(5);
            if (System.currentTimeMillis() - this.T.longValue() < this.S) {
                b0();
            }
            if (B() != 4) {
                this.T = Long.valueOf(System.currentTimeMillis());
                l(this.f408910i, str, 1, true);
            }
        }
    }

    private boolean x(String str) {
        if (!TextUtils.isEmpty(str) && str.contains("\n")) {
            return true;
        }
        return false;
    }

    private int y(List<GProGuildRobotInlineLayout> list) {
        this.E.removeAllViews();
        int i3 = 0;
        for (GProGuildRobotInlineLayout gProGuildRobotInlineLayout : list) {
            mx1.d dVar = new mx1.d(this.f408907e, this.f408910i, this, gProGuildRobotInlineLayout.getAction(), gProGuildRobotInlineLayout.getTitle(), this.f408909h);
            View E = E(gProGuildRobotInlineLayout.getType());
            if (E != null) {
                ListView listView = (ListView) E.findViewById(R.id.ebg);
                listView.setAdapter((ListAdapter) dVar);
                listView.setOverScrollMode(2);
                dVar.c(gProGuildRobotInlineLayout.getLayoutDataList());
                listView.setSelection(0);
                ((TextView) E.findViewById(R.id.f108996em)).setText(gProGuildRobotInlineLayout.getTitle());
                i3 += gProGuildRobotInlineLayout.getLayoutDataList().size();
                this.E.addView(E);
            }
        }
        return i3;
    }

    public int A(String str) {
        mx1.c cVar = this.G;
        if (cVar != null && this.f408911m != null) {
            int d16 = cVar.d(str);
            if (d16 == 0) {
                z(false);
            } else {
                this.f408911m.g(this.f408907e, this.D, d16);
            }
            return d16;
        }
        QLog.e("GuildRobotTag:RobotAtManager", 1, "[filterMatchedFunctions]: dialog isn't initialized");
        return 0;
    }

    public int B() {
        return this.M;
    }

    public String C() {
        return com.tencent.guild.aio.util.a.b(this.f408909h);
    }

    public String D() {
        return com.tencent.guild.aio.util.a.g(this.f408909h);
    }

    public View E(int i3) {
        if (i3 != 0) {
            return null;
        }
        return LayoutInflater.from(this.f408907e).inflate(R.layout.f4y, (ViewGroup) null, false);
    }

    public CommonBotInfo F() {
        return this.K;
    }

    public String G() {
        return this.J;
    }

    public int H() {
        return this.P;
    }

    public void I() {
        lx1.d dVar = this.C;
        if (dVar != null) {
            dVar.dismiss();
        }
    }

    public void J() {
        this.W = false;
        boolean a16 = hx1.b.a(this.f408907e);
        this.V = a16;
        if (a16) {
            u();
        }
        RobotInlineSearch.f232175i = sx1.f.f().a();
        this.S = sx1.f.f().e().intValue();
    }

    public boolean L() {
        if (this.f408911m != null && this.M == 2) {
            return true;
        }
        return false;
    }

    public boolean M() {
        CommonBotInfo commonBotInfo = this.K;
        if (commonBotInfo != null && h34.a.e(commonBotInfo)) {
            return true;
        }
        return false;
    }

    public void O(int i3) {
        if (i3 != 0) {
            if (i3 == 1) {
                P(8);
                P(5);
                return;
            }
            return;
        }
        P(3);
        P(5);
    }

    public void P(int i3) {
        this.M = i3;
        if (QLog.isColorLevel()) {
            QLog.i("GuildRobotTag:RobotAtManager", 2, "robot at event id:" + i3 + ", name:" + jx1.b.a(i3));
        }
        for (int i16 = 0; i16 < this.L.size(); i16++) {
            this.L.get(i16).onEvent(i3);
        }
    }

    public void Q(int i3) {
        if (i3 != 0) {
            if (i3 == 1) {
                P(7);
                return;
            }
            return;
        }
        P(2);
    }

    public void R(int i3) {
        this.P = i3;
    }

    public boolean U(CommonBotInfo commonBotInfo, List<RobotFeatureItem> list) {
        if (QLog.isColorLevel()) {
            QLog.i("GuildRobotTag:RobotAtManager", 2, "showFunctionPanel");
        }
        if (this.F == null) {
            this.F = (ListView) LayoutInflater.from(this.f408907e).inflate(R.layout.f4w, (ViewGroup) null, false);
        }
        if (this.f408910i.getText().toString().trim().isEmpty()) {
            z(true);
            return false;
        }
        if (this.f408911m == null) {
            K();
        }
        mx1.c cVar = new mx1.c(this.f408907e, this.f408910i, this);
        this.G = cVar;
        this.F.setAdapter((ListAdapter) cVar);
        this.f408911m.L(this.F);
        this.f408911m.M(0);
        this.f408911m.g(this.f408907e, this.D, list.size());
        this.G.m(commonBotInfo, list);
        this.F.setOverScrollMode(2);
        this.f408911m.x();
        this.f408911m.D(this.F);
        W(0);
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime != null) {
            kx1.a.e(this.f408907e, this.f408911m.getContentView(), peekAppRuntime, D(), C(), this.J, 0, 0, false);
        }
        return true;
    }

    public void V(List<GProGuildRobotInlineLayout> list, String str) {
        if (QLog.isColorLevel()) {
            QLog.i("GuildRobotTag:RobotAtManager", 2, "showInlinePanel");
        }
        if (this.E == null) {
            this.E = (LinearLayout) LayoutInflater.from(this.f408907e).inflate(R.layout.f4x, (ViewGroup) null, false);
        }
        if (this.f408911m == null) {
            K();
        }
        int y16 = y(list);
        if (y16 == 0) {
            return;
        }
        this.f408911m.L(this.E);
        this.f408911m.g(this.f408907e, this.D, y16);
        this.f408911m.x();
        this.f408911m.E(this.E);
        W(1);
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime != null) {
            kx1.b.d(this.f408907e, this.f408911m.getContentView(), peekAppRuntime, D(), C(), this.J, 0);
            kx1.b.c(this.f408910i, str);
        }
    }

    public void X(int i3) {
        if (QLog.isColorLevel()) {
            QLog.i("GuildRobotTag:RobotAtManager", 2, "showTooltip, tooltipType:" + i3);
        }
        if (this.C == null) {
            this.C = lx1.d.b(this.f408907e, this.D);
        }
        this.C.e(i3);
    }

    @Override // uw1.a
    public boolean a(KeyEvent keyEvent) {
        e();
        if (B() == 5) {
            return true;
        }
        return false;
    }

    public void a0() {
        if (QLog.isColorLevel()) {
            QLog.i("GuildRobotTag:RobotAtManager", 2, "stopFunctionSearch");
        }
        h hVar = this.I;
        if (hVar != null) {
            hVar.t().c();
        }
    }

    @Override // uw1.a
    public void b(String str) {
        String str2;
        if (QLog.isColorLevel()) {
            QLog.i("GuildRobotTag:RobotAtManager", 1, "mIsUserAccessInline" + this.V + "mIsAccessFunction" + this.U);
        }
        if (f.isAtListeningBlocked) {
            return;
        }
        if (str.length() != 0 && str.contains("@") && !str.endsWith("\n") && !str.contains("#")) {
            if (TextUtils.equals(hx1.b.b(this.f408910i), "0")) {
                return;
            }
            Editable editableText = this.f408910i.getEditableText();
            int max = Math.max(so0.c.j(editableText, 0, this.f408910i.getSelectionStart()), 0);
            if (max >= this.f408910i.getSelectionStart()) {
                str2 = "";
            } else {
                str2 = editableText.subSequence(max, this.f408910i.getSelectionStart()).toString();
            }
            if (!hx1.b.l(str2)) {
                z(false);
                return;
            }
            String substring = str2.substring(1);
            if (x(substring)) {
                z(false);
                return;
            }
            if (substring.isEmpty()) {
                z(false);
                v(str.length(), substring);
                return;
            }
            if (N(substring)) {
                z(false);
                if (T(substring)) {
                    String trim = substring.replaceFirst("/\u641c\u7d22", "").trim();
                    if (trim.length() >= 10) {
                        trim = trim.substring(0, 10);
                    }
                    w(trim);
                    return;
                }
                return;
            }
            if (S(substring)) {
                if (L()) {
                    A(substring);
                    return;
                } else {
                    v(max + 1, substring);
                    return;
                }
            }
            z(false);
            return;
        }
        z(false);
    }

    public void b0() {
        if (QLog.isColorLevel()) {
            QLog.i("GuildRobotTag:RobotAtManager", 2, "stopInlineSearch");
        }
        l lVar = this.H;
        if (lVar != null) {
            lVar.t().c();
        }
    }

    @Override // uw1.a
    public void c(CommonBotInfo commonBotInfo) {
        this.J = String.valueOf(commonBotInfo.getTinyid());
        this.K = commonBotInfo;
    }

    @Override // uw1.a
    public void d(boolean z16) {
        this.W = z16;
        QLog.i("GuildRobotTag:RobotAtManager", 1, "mRobotAccessInlineSearch:" + this.W);
    }

    @Override // uw1.a
    public void e() {
        z(false);
        I();
        P(15);
    }

    @Override // uw1.a
    public boolean f() {
        if (B() == 15) {
            return true;
        }
        return false;
    }

    @Override // uw1.a
    public void g() {
        this.L = new ArrayList<>();
    }

    @Override // uw1.a
    public boolean h() {
        return this.V;
    }

    @Override // uw1.a
    public void i(String str) {
        this.J = str;
    }

    @Override // uw1.a
    public boolean j() {
        return this.U;
    }

    @Override // uw1.a
    public boolean k() {
        if (B() == 0) {
            return true;
        }
        return false;
    }

    @Override // uw1.a
    public void l(View view, String str, int i3, boolean z16) {
        if (QLog.isColorLevel()) {
            QLog.i("GuildRobotTag:RobotAtManager", 2, "start showPanel, dialogType:" + i3);
        }
        this.D = view;
        if (i3 != 0) {
            if (i3 == 1) {
                Z(str);
                return;
            }
            return;
        }
        Y(z16, str);
    }

    @Override // android.widget.PopupWindow.OnDismissListener
    public void onDismiss() {
        if (QLog.isColorLevel()) {
            QLog.i("GuildRobotTag:RobotAtManager", 2, "onDismiss");
        }
        O(this.N);
        int b16 = yo0.b.b(this.D);
        InputMethodManager inputMethodManager = (InputMethodManager) this.f408907e.getSystemService(WebRTCSDK.PRIVILEGE_INPUT_METHOD);
        View findViewById = this.f408907e.findViewById(R.id.input);
        if (b16 == 2 && inputMethodManager != null && findViewById != null) {
            inputMethodManager.showSoftInput(findViewById, 2);
        }
    }

    public void u() {
        if (this.R == null) {
            this.L.add(new jx1.d(this));
        }
        if (this.Q == null) {
            this.L.add(new jx1.c(this));
        }
    }

    public void z(boolean z16) {
        if (this.f408911m == null) {
            return;
        }
        if (B() == 2) {
            this.f408911m.dismiss();
        } else if (B() == 7) {
            this.f408911m.dismiss();
        } else if (z16) {
            this.f408911m.dismiss();
        }
        P(14);
    }
}

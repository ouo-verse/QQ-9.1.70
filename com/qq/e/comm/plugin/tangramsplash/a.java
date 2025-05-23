package com.qq.e.comm.plugin.tangramsplash;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.media.AudioManager;
import android.text.TextUtils;
import android.util.Pair;
import android.view.View;
import com.qq.e.comm.constants.Constants;
import com.qq.e.comm.managers.GDTADManager;
import com.qq.e.comm.managers.status.SDKStatus;
import com.qq.e.comm.plugin.base.ad.clickcomponent.ClickInfo;
import com.qq.e.comm.plugin.base.ad.e.g;
import com.qq.e.comm.plugin.base.ad.model.r;
import com.qq.e.comm.plugin.k.af;
import com.qq.e.comm.plugin.k.aq;
import com.qq.e.comm.plugin.k.at;
import com.qq.e.comm.plugin.k.ay;
import com.qq.e.comm.plugin.k.y;
import com.qq.e.comm.util.GDTLogger;
import com.qq.e.comm.util.StringUtil;
import java.io.File;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes3.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    private static volatile a f39757a;

    /* renamed from: b, reason: collision with root package name */
    private volatile r f39758b;

    /* renamed from: c, reason: collision with root package name */
    private volatile r f39759c;

    a() {
    }

    private r a(r rVar, r rVar2) {
        return rVar != null ? rVar : rVar2;
    }

    private String ac(r rVar) {
        File file;
        if (rVar == null) {
            return null;
        }
        if (!TextUtils.isEmpty(rVar.i())) {
            file = at.a(1, rVar.s(), rVar.i());
        } else {
            file = null;
        }
        if (file != null && file.exists()) {
            GDTLogger.d("oneShot getOneshotCoverImagePath get img2 url = " + rVar.i());
            return file.getAbsolutePath();
        }
        if (!TextUtils.isEmpty(rVar.h())) {
            file = at.a(1, rVar.s(), rVar.h());
        }
        if (file == null || !file.exists()) {
            return null;
        }
        GDTLogger.d("oneShot getOneshotCoverImagePath get img url = " + rVar.h());
        return file.getAbsolutePath();
    }

    private String ad(r rVar) {
        File a16;
        String h16 = rVar.bx().h();
        if (TextUtils.isEmpty(h16) || (a16 = at.a(1, rVar.bx().s(), h16)) == null || !a16.exists()) {
            return null;
        }
        return a16.getAbsolutePath();
    }

    private String ae(r rVar) {
        File a16;
        String bt5 = rVar.bx().bt();
        String x16 = rVar.bx().x();
        if (TextUtils.isEmpty(bt5)) {
            bt5 = x16;
        }
        if (TextUtils.isEmpty(bt5) || (a16 = at.a(2, rVar.bx().s(), bt5)) == null || !a16.exists()) {
            return null;
        }
        return a16.getAbsolutePath();
    }

    private void af(r rVar) {
        if (rVar.bx() != null) {
            com.qq.e.comm.plugin.tangramsplash.report.c.a(14089, rVar.bx().s());
            String q16 = rVar.bx().q();
            if (!TextUtils.isEmpty(q16)) {
                rVar.n(q16.replace("__ACT_TYPE__", "2001"));
            }
        }
        g.a(rVar);
    }

    private boolean ag(r rVar) {
        r a16 = a(rVar, this.f39759c);
        if (a16 != null && a16.as()) {
            return true;
        }
        return false;
    }

    public boolean A(r rVar) {
        r a16 = a(rVar, this.f39758b);
        if (a16 == null || a16.bB() != 1) {
            return false;
        }
        return true;
    }

    public boolean B(r rVar) {
        r a16 = a(rVar, this.f39758b);
        if (a16 == null || a16.bC() != 1) {
            return false;
        }
        return true;
    }

    public boolean C(r rVar) {
        r a16 = a(rVar, this.f39758b);
        if (a16 == null || a16.bz() <= 0) {
            return false;
        }
        return true;
    }

    public boolean D(r rVar) {
        if (a(rVar, this.f39758b) != null) {
            return !TextUtils.isEmpty(r2.x());
        }
        return false;
    }

    public boolean E(r rVar) {
        r a16 = a(rVar, this.f39758b);
        if (a16 == null || TextUtils.isEmpty(a16.x()) || !a16.cc()) {
            return false;
        }
        return true;
    }

    public boolean F(r rVar) {
        r a16 = a(rVar, this.f39758b);
        if (a16 == null || a16.bf() == 2) {
            return false;
        }
        return true;
    }

    public boolean G(r rVar) {
        r a16 = a(rVar, this.f39758b);
        if (a16 == null || a16.bJ() == null) {
            return false;
        }
        return true;
    }

    public int H(r rVar) {
        boolean z16;
        r a16 = a(rVar, this.f39758b);
        if (a16 != null && a16.bJ() != null) {
            if (a16.bJ().f() != null && a16.bJ().f().a()) {
                z16 = true;
            } else {
                z16 = false;
            }
            String bP = a16.bP();
            a16.bQ();
            if ("ShakeInteractive".equals(bP)) {
                if (z16) {
                    return com.qq.e.comm.plugin.tangramsplash.interactive.a.f40090b;
                }
                return com.qq.e.comm.plugin.tangramsplash.interactive.a.f40091c;
            }
            if ("ShakePlusInteractive".equals(bP)) {
                if (z16) {
                    return com.qq.e.comm.plugin.tangramsplash.interactive.a.f40092d;
                }
                return com.qq.e.comm.plugin.tangramsplash.interactive.a.f40093e;
            }
            if ("SlideInteractive".equals(bP)) {
                if (z16) {
                    return com.qq.e.comm.plugin.tangramsplash.interactive.a.f40098j;
                }
                return com.qq.e.comm.plugin.tangramsplash.interactive.a.f40099k;
            }
            if ("LeanForwardInteractive".equals(bP)) {
                if (z16) {
                    return com.qq.e.comm.plugin.tangramsplash.interactive.a.B;
                }
                return com.qq.e.comm.plugin.tangramsplash.interactive.a.C;
            }
            if ("SlideFlipInteractive".equals(bP)) {
                if (z16) {
                    return com.qq.e.comm.plugin.tangramsplash.interactive.a.L;
                }
                return com.qq.e.comm.plugin.tangramsplash.interactive.a.M;
            }
            if ("SlideVerticalCarouselCard".equals(bP)) {
                if (z16) {
                    return com.qq.e.comm.plugin.tangramsplash.interactive.a.N;
                }
                return com.qq.e.comm.plugin.tangramsplash.interactive.a.O;
            }
            if ("TwistVerticalCarouselCard".equals(bP)) {
                if (z16) {
                    return com.qq.e.comm.plugin.tangramsplash.interactive.a.P;
                }
                return com.qq.e.comm.plugin.tangramsplash.interactive.a.Q;
            }
            if ("IconFlipInteractive".equals(bP)) {
                if (z16) {
                    return com.qq.e.comm.plugin.tangramsplash.interactive.a.R;
                }
                return com.qq.e.comm.plugin.tangramsplash.interactive.a.S;
            }
            return com.qq.e.comm.plugin.tangramsplash.interactive.a.f40089a;
        }
        return -1;
    }

    public boolean I(r rVar) {
        r a16 = a(rVar, this.f39758b);
        if (a16 == null || a16.bO() != 1) {
            return false;
        }
        return true;
    }

    public boolean J(r rVar) {
        r a16 = a(rVar, this.f39758b);
        if (a16 != null) {
            return a16.bG();
        }
        return false;
    }

    public String K(r rVar) {
        r a16 = a(rVar, this.f39759c);
        if (a16 != null) {
            String absolutePath = at.a(1, a16.s(), a16.i()).getAbsolutePath();
            GDTLogger.d("SplashOrder: " + absolutePath);
            return absolutePath;
        }
        return null;
    }

    public String L(r rVar) {
        r a16 = a(rVar, this.f39759c);
        if (a16 != null) {
            GDTLogger.d("SplashOrder: getIconUrl = " + a16.i());
            return a16.i();
        }
        return null;
    }

    public String M(r rVar) {
        r a16 = a(rVar, this.f39759c);
        if (a16 != null && !TextUtils.isEmpty(a16.bE())) {
            String absolutePath = at.a(2, a16.s(), a16.bE()).getAbsolutePath();
            GDTLogger.d("SplashOrder: " + absolutePath);
            return absolutePath;
        }
        return null;
    }

    public String N(r rVar) {
        r a16 = a(rVar, this.f39759c);
        if (a16 != null && !TextUtils.isEmpty(a16.bE())) {
            GDTLogger.d("SplashOrder: getBarVideoUrl = " + a16.bE());
            return a16.bE();
        }
        return null;
    }

    public void O(r rVar) {
        r a16 = a(rVar, this.f39759c);
        if (a16 != null) {
            com.qq.e.comm.plugin.tangramsplash.report.c.a(1310361, a16.s(), a16, false);
        }
    }

    public int P(r rVar) {
        r a16 = a(rVar, this.f39759c);
        if (a16 != null) {
            GDTLogger.d("SplashOrder: " + a16.bF());
            return a16.bF();
        }
        return 0;
    }

    public String Q(r rVar) {
        r a16 = a(rVar, this.f39758b);
        if (a16 != null) {
            GDTLogger.d("SplashOrder: " + a16.br());
            return a16.br();
        }
        return null;
    }

    public JSONObject R(r rVar) {
        r a16 = a(rVar, this.f39758b);
        if (a16 != null && y.a(a16.v())) {
            JSONObject optJSONObject = a16.v().optJSONObject("pass_through_data");
            GDTLogger.d("SplashOrder: " + optJSONObject);
            return optJSONObject;
        }
        return null;
    }

    public boolean S(r rVar) {
        r a16 = a(rVar, this.f39758b);
        if (a16 != null) {
            return a16.ay();
        }
        return false;
    }

    public List<Pair<String, String>> T(r rVar) {
        r bx4;
        String str;
        r a16 = a(rVar, this.f39759c);
        if (a16 != null && (bx4 = a16.bx()) != null && bx4.T() != null && bx4.T().size() > 0) {
            ArrayList arrayList = new ArrayList();
            for (String str2 : bx4.T()) {
                GDTLogger.d("getOneShotWindowImagePathList url = " + str2);
                File a17 = at.a(1, bx4.s(), str2);
                GDTLogger.d("getOneShotWindowImagePathList cacheFile = " + a17.getAbsolutePath());
                if (a17.exists()) {
                    str = a17.getAbsolutePath();
                } else {
                    str = "";
                }
                arrayList.add(new Pair(str2, str));
            }
            return arrayList;
        }
        return null;
    }

    public JSONObject U(r rVar) {
        r a16 = a(rVar, this.f39759c);
        if (a16 != null && a16.bx() != null) {
            return a16.bx().bV();
        }
        return null;
    }

    public String V(r rVar) {
        r bx4;
        r a16 = a(rVar, this.f39759c);
        if (a16 != null && (bx4 = a16.bx()) != null) {
            return at.a(1, bx4.s(), bx4.i()).getAbsolutePath();
        }
        return null;
    }

    public String W(r rVar) {
        r a16 = a(rVar, this.f39759c);
        if (a16 != null && a16.bx() != null) {
            return a16.bx().i();
        }
        return null;
    }

    public String X(r rVar) {
        r bx4;
        File a16;
        r a17 = a(rVar, this.f39759c);
        if (a17 == null || (bx4 = a17.bx()) == null || !a17.bj()) {
            return null;
        }
        if (!TextUtils.isEmpty(bx4.bu())) {
            a16 = at.a(2, bx4.s(), bx4.bu());
        } else {
            a16 = at.a(2, bx4.s(), bx4.ad());
        }
        if (a16 == null || !a16.exists()) {
            return null;
        }
        return a16.getAbsolutePath();
    }

    public String Y(r rVar) {
        r a16 = a(rVar, this.f39759c);
        if (a16 != null && a16.bj()) {
            return a16.bx().ad();
        }
        return null;
    }

    public boolean Z(r rVar) {
        r a16 = a(rVar, this.f39759c);
        if (a16 != null && a16.aH()) {
            return true;
        }
        return false;
    }

    public int aa(r rVar) {
        int i3 = 0;
        if (rVar == null) {
            return 0;
        }
        if (SDKStatus.getSDKVersionCode() >= 350) {
            if (ag(rVar)) {
                i3 = 2;
            } else if (d(rVar)) {
                i3 = 1;
            }
        }
        GDTLogger.d("getJoinAdType = " + i3);
        return i3;
    }

    public boolean ab(r rVar) {
        if (rVar == null || rVar.bM() == 0) {
            return true;
        }
        return false;
    }

    public r b() {
        return this.f39758b;
    }

    @Deprecated
    public boolean c(r rVar) {
        r a16 = a(rVar, this.f39758b);
        return b(a16) && !TextUtils.isEmpty(a16.bx().x());
    }

    public boolean d(r rVar) {
        if (rVar == null || rVar.bx() == null || !com.qq.e.comm.plugin.j.c.a("splashSupportOneshot", 1, 1)) {
            return false;
        }
        return com.qq.e.comm.plugin.tangramsplash.d.f.a(rVar);
    }

    public boolean e(r rVar) {
        return com.qq.e.comm.plugin.tangramsplash.b.c.i(rVar);
    }

    public String f(r rVar) {
        r a16 = a(rVar, this.f39758b);
        if (!b(a16)) {
            return null;
        }
        String i3 = a16.i();
        GDTLogger.d("oneShot getOneshotCoverImageUrl get img2 url = " + i3);
        if (TextUtils.isEmpty(i3)) {
            String h16 = a16.h();
            GDTLogger.d("oneShot getOneshotCoverImageUrl get img url = " + h16);
            return h16;
        }
        return i3;
    }

    public String g(r rVar) {
        if (!b(a(rVar, this.f39758b))) {
            return null;
        }
        return ac(rVar);
    }

    public String h(r rVar) {
        if (rVar != null) {
            if (!b(rVar)) {
                return null;
            }
            return rVar.bx().h();
        }
        if (!b(this.f39758b) || this.f39759c == null || this.f39759c.bx() == null) {
            return null;
        }
        return this.f39759c.bx().h();
    }

    public String i(r rVar) {
        if (rVar != null) {
            if (!b(rVar)) {
                return null;
            }
            return ad(rVar);
        }
        if (!b(this.f39758b) || this.f39759c == null || this.f39759c.bx() == null) {
            return null;
        }
        return ad(this.f39759c);
    }

    public String j(r rVar) {
        if (rVar != null) {
            if (!b(rVar)) {
                return null;
            }
            return rVar.bx().x();
        }
        if (!b(this.f39758b) || this.f39759c == null || this.f39759c.bx() == null) {
            return null;
        }
        return this.f39759c.bx().x();
    }

    public String k(r rVar) {
        if (rVar != null) {
            if (!b(rVar)) {
                return null;
            }
            return ae(rVar);
        }
        if (!b(this.f39758b) || this.f39759c == null || this.f39759c.bx() == null) {
            return null;
        }
        return ae(this.f39759c);
    }

    public String l(r rVar) {
        File a16;
        r a17 = a(rVar, this.f39758b);
        if (!b(a17)) {
            return null;
        }
        if (TextUtils.isEmpty(a17.bt())) {
            a16 = at.a(2, a17.s(), a17.x());
        } else {
            a16 = at.a(2, a17.s(), a17.bt());
        }
        if (a16 == null || !a16.exists()) {
            return null;
        }
        return a16.getAbsolutePath();
    }

    public int m(r rVar) {
        r a16 = a(rVar, this.f39758b);
        if (a16 != null) {
            int p16 = a16.p();
            if (TextUtils.isEmpty(a16.v().optString("customized_invoke_url")) && p16 != 19 && p16 != 12 && p16 != 25) {
                if (com.qq.e.comm.plugin.k.b.e(a16.v())) {
                    return 2;
                }
                return 1;
            }
            return 0;
        }
        return 3;
    }

    public String n(r rVar) {
        r a16 = a(rVar, this.f39758b);
        if (a16 != null && a16.bx() != null) {
            return a16.bx().an();
        }
        return null;
    }

    public String o(r rVar) {
        r a16 = a(rVar, this.f39758b);
        if (a16 != null && a16.bx() != null) {
            return a16.bx().ao();
        }
        return null;
    }

    public String p(r rVar) {
        r a16 = a(rVar, this.f39758b);
        if (a16 == null) {
            return null;
        }
        try {
            return a16.v().toString();
        } catch (Throwable th5) {
            GDTLogger.e("SplashOrdergetAdJson error", th5);
            return null;
        }
    }

    public String q(r rVar) {
        r bx4;
        r a16 = a(rVar, this.f39758b);
        if (a16 == null || (bx4 = a16.bx()) == null) {
            return null;
        }
        try {
            return bx4.v().toString();
        } catch (Throwable th5) {
            GDTLogger.e("SplashOrdergetSubOrderAdJson error", th5);
            return null;
        }
    }

    public void r(r rVar) {
        if (rVar != null) {
            if (rVar.bG()) {
                com.qq.e.comm.plugin.tangramsplash.report.c.a(1310363, rVar.s(), rVar, false);
            }
            if (b(rVar)) {
                af(rVar);
                return;
            }
            return;
        }
        if (this.f39759c != null) {
            af(this.f39759c);
            if (this.f39759c.bG()) {
                com.qq.e.comm.plugin.tangramsplash.report.c.a(1310363, this.f39758b.s(), this.f39758b, false);
                return;
            }
            return;
        }
        if (b(this.f39758b)) {
            af(this.f39758b);
        }
    }

    public String s(r rVar) {
        if (rVar != null) {
            if (b(rVar)) {
                return rVar.bx().getButtonTxt();
            }
            return rVar.getButtonTxt();
        }
        if (b(this.f39758b)) {
            return this.f39759c.bx().getButtonTxt();
        }
        if (this.f39758b != null) {
            return this.f39758b.getButtonTxt();
        }
        return "";
    }

    public String t(r rVar) {
        if (rVar != null) {
            if (b(rVar)) {
                return rVar.bx().g();
            }
            return rVar.g();
        }
        if (b(this.f39758b)) {
            return this.f39759c.bx().g();
        }
        if (this.f39758b != null) {
            return this.f39758b.g();
        }
        return "";
    }

    public String u(r rVar) {
        if (rVar != null) {
            if (b(rVar)) {
                return rVar.bx().getDesc();
            }
            return rVar.getDesc();
        }
        if (b(this.f39758b)) {
            return this.f39759c.bx().getDesc();
        }
        if (this.f39758b != null) {
            return this.f39758b.getDesc();
        }
        return "";
    }

    public int v(r rVar) {
        r a16 = a(rVar, this.f39758b);
        if (a16 != null) {
            if (!TextUtils.isEmpty(a16.x())) {
                return a16.bN();
            }
            return a16.bq();
        }
        return GDTADManager.getInstance().getSM().getInteger(Constants.KEYS.SPLASH_EXPOSURE_TIME, 5);
    }

    public boolean w(r rVar) {
        boolean z16;
        if (GDTADManager.getInstance().getSM().getInteger("splashVideoMute", 1) == 1) {
            return true;
        }
        try {
            AudioManager audioManager = (AudioManager) GDTADManager.getInstance().getAppContext().getSystemService("audio");
            if (aq.a() == 0) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (audioManager.getRingerMode() != 2 || z16) {
                return true;
            }
            return false;
        } catch (Exception e16) {
            e16.printStackTrace();
            return true;
        }
    }

    public int x(r rVar) {
        r a16 = a(rVar, this.f39758b);
        if (a16 != null) {
            return a16.w();
        }
        return -1;
    }

    public String y(r rVar) {
        r a16 = a(rVar, this.f39758b);
        if (a16 != null) {
            return a16.f();
        }
        return null;
    }

    public boolean z(r rVar) {
        r a16 = a(rVar, this.f39758b);
        if (a16 != null) {
            return com.qq.e.comm.plugin.tangramsplash.a.c.b(a16);
        }
        return false;
    }

    public static a a() {
        if (f39757a == null) {
            synchronized (a.class) {
                if (f39757a == null) {
                    f39757a = new a();
                }
            }
        }
        return f39757a;
    }

    public boolean b(r rVar) {
        r a16 = a(rVar, this.f39758b);
        return d(a16) && e(a16);
    }

    public synchronized void c() {
        this.f39759c = null;
        this.f39758b = null;
    }

    public Bitmap b(BitmapFactory.Options options, r rVar) {
        if (!b(a(rVar, this.f39758b))) {
            return null;
        }
        String ac5 = ac(rVar);
        if (TextUtils.isEmpty(ac5)) {
            return null;
        }
        return a(ac5, options);
    }

    public static void a(r rVar, View view) {
        String str;
        if (rVar == null || view == null) {
            return;
        }
        try {
            com.qq.e.comm.plugin.base.ad.c cVar = new com.qq.e.comm.plugin.base.ad.c();
            cVar.b(System.currentTimeMillis());
            cVar.a().a("41");
            com.qq.e.comm.plugin.tangramsplash.d.f.a(cVar, view.getWidth(), view.getHeight());
            cVar.a().b(view.getWidth());
            cVar.a().a(view.getHeight());
            str = URLEncoder.encode(cVar.b(), "UTF-8");
        } catch (Exception e16) {
            GDTLogger.w("GetAntiSpamInfoException:" + e16.getMessage());
            str = null;
        }
        g.a(view, rVar, str, (ClickInfo.e) null, 0, -1);
    }

    public void b(View view, r rVar) {
        r a16 = a(rVar, this.f39759c);
        if (a16 != null) {
            com.qq.e.comm.plugin.tangramsplash.report.c.a(1310362, a16.s(), a16, false);
            a(a16, view);
        }
    }

    public static void a(r rVar, View view, long j3) {
        if (rVar == null) {
            return;
        }
        String j16 = rVar.j();
        if (TextUtils.isEmpty(j16)) {
            return;
        }
        rVar.h(ay.a(j16, "gap", String.valueOf(j3)));
        com.qq.e.comm.plugin.tangramsplash.d.d.a(null, 0, rVar);
        rVar.Z();
        rVar.aa();
        String o16 = rVar.o();
        if (StringUtil.isEmpty(o16)) {
            return;
        }
        af.b(o16);
    }

    public synchronized void a(r rVar) {
        this.f39758b = rVar;
        if (rVar != null && rVar.bx() != null) {
            this.f39758b.a(com.qq.e.comm.plugin.tangramsplash.d.f.b(rVar.bx()));
        }
        if (d(rVar) && this.f39759c == null) {
            GDTLogger.d("SplashOrder is OneShot");
            this.f39759c = rVar;
        }
        if (J(rVar) && this.f39759c == null) {
            GDTLogger.d("SplashOrder is FollowU Ad");
            this.f39759c = rVar;
        }
        GDTLogger.d("SplashOrder SplashManager save ad");
    }

    public void a(View view, r rVar) {
        if (rVar != null) {
            a(view, rVar, b(rVar));
        } else if (this.f39759c != null) {
            a(this.f39759c.bx(), view);
        } else {
            a(view, this.f39758b, b(this.f39758b));
        }
    }

    private void a(View view, r rVar, boolean z16) {
        if (z16) {
            a(rVar.bx(), view);
        }
    }

    public void a(View view, long j3, r rVar) {
        if (rVar != null) {
            a(view, j3, rVar, b(rVar));
        } else if (this.f39759c != null) {
            a(this.f39759c.bx(), view, j3);
        } else {
            a(view, j3, this.f39758b, b(this.f39758b));
        }
    }

    private void a(View view, long j3, r rVar, boolean z16) {
        if (z16) {
            a(rVar.bx(), view, j3);
        }
    }

    public Bitmap a(BitmapFactory.Options options, r rVar) {
        File a16;
        r a17 = a(rVar, this.f39758b);
        if (!b(a17)) {
            return null;
        }
        String h16 = a17.bx().h();
        if (TextUtils.isEmpty(h16) || (a16 = at.a(1, a17.bx().s(), h16)) == null) {
            return null;
        }
        return a(a16.getAbsolutePath(), options);
    }

    private Bitmap a(String str, BitmapFactory.Options options) {
        if (options == null) {
            options = new BitmapFactory.Options();
            options.inJustDecodeBounds = false;
            options.inPreferredConfig = Bitmap.Config.RGB_565;
        }
        return BitmapFactory.decodeFile(str, options);
    }

    public void a(int i3, r rVar) {
        if (rVar != null) {
            com.qq.e.comm.plugin.tangramsplash.report.c.a(i3, rVar.bx(), false);
        } else if (this.f39759c != null) {
            com.qq.e.comm.plugin.tangramsplash.report.c.a(i3, this.f39759c.bx(), false);
        } else if (this.f39758b != null) {
            com.qq.e.comm.plugin.tangramsplash.report.c.a(i3, this.f39758b.bx(), false);
        }
    }
}

package com.tencent.mobileqq.guild.share;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.guild.usecases.b;
import com.tencent.mobileqq.guild.util.QQGuildUIUtil;
import com.tencent.mobileqq.guild.util.bg;
import com.tencent.mobileqq.guild.util.ch;
import com.tencent.mobileqq.mini.report.MiniAppReportManager;
import com.tencent.mobileqq.qqguildsdk.api.IGPSService;
import com.tencent.mobileqq.qqguildsdk.data.IGProChannelInfo;
import com.tencent.mobileqq.qqguildsdk.data.IGProGuildInfo;
import com.tencent.mobileqq.qqguildsdk.data.genc.IGProAppChnnPreInfo;
import com.tencent.mobileqq.qqguildsdk.data.genc.IGProLobbyAppInfo;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.URLUtil;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import mqq.app.MobileQQ;

/* compiled from: P */
/* loaded from: classes14.dex */
public class y {

    /* renamed from: k, reason: collision with root package name */
    protected static final Pattern f235161k = Pattern.compile("http(?:s)?://qun.qq.com/qqweb/qunpro/[\\S]+");

    /* renamed from: a, reason: collision with root package name */
    protected final IGProGuildInfo f235162a;

    /* renamed from: b, reason: collision with root package name */
    private final b.c f235163b;

    /* renamed from: c, reason: collision with root package name */
    protected final IGProChannelInfo f235164c;

    /* renamed from: d, reason: collision with root package name */
    protected final String f235165d;

    /* renamed from: e, reason: collision with root package name */
    private final long f235166e;

    /* renamed from: f, reason: collision with root package name */
    private IGProLobbyAppInfo f235167f;

    /* renamed from: g, reason: collision with root package name */
    private boolean f235168g;

    /* renamed from: h, reason: collision with root package name */
    private int f235169h;

    /* renamed from: i, reason: collision with root package name */
    private com.tencent.mobileqq.sharehelper.a f235170i;

    /* renamed from: j, reason: collision with root package name */
    private String f235171j;

    public y(@NonNull IGProGuildInfo iGProGuildInfo, @Nullable IGProChannelInfo iGProChannelInfo, @NonNull String str, @NonNull b.c cVar, @NonNull String str2) {
        this.f235168g = false;
        this.f235169h = 0;
        this.f235170i = null;
        this.f235171j = null;
        this.f235162a = iGProGuildInfo;
        this.f235164c = iGProChannelInfo;
        this.f235165d = str;
        this.f235163b = a(cVar, str);
        this.f235166e = c(iGProChannelInfo);
    }

    private boolean A() {
        IGProChannelInfo iGProChannelInfo = this.f235164c;
        if (iGProChannelInfo != null && iGProChannelInfo.getType() == 5) {
            return true;
        }
        return false;
    }

    private boolean B() {
        IGProChannelInfo iGProChannelInfo = this.f235164c;
        if (iGProChannelInfo != null && iGProChannelInfo.getType() == 11) {
            return true;
        }
        return false;
    }

    private boolean C() {
        IGProChannelInfo iGProChannelInfo = this.f235164c;
        if (iGProChannelInfo != null && iGProChannelInfo.getType() == 1) {
            return true;
        }
        return false;
    }

    private boolean D() {
        IGProChannelInfo iGProChannelInfo = this.f235164c;
        if (iGProChannelInfo != null && iGProChannelInfo.getType() == 2) {
            return true;
        }
        return false;
    }

    @NonNull
    private b.c a(b.c cVar, String str) {
        Matcher matcher = f235161k.matcher(cVar.f235320b);
        StringBuffer stringBuffer = new StringBuffer(cVar.f235320b.length());
        while (matcher.find()) {
            matcher.appendReplacement(stringBuffer, b(matcher.group(), null));
        }
        matcher.appendTail(stringBuffer);
        return new b.c(cVar.f235319a, stringBuffer.toString(), cVar.f235321c, cVar.f235322d, cVar.f235323e);
    }

    @NonNull
    private String b(String str, @Nullable String str2) {
        if (!TextUtils.isEmpty(str2)) {
            str = URLUtil.addParameter(str, "nickName", URLUtil.encodeUrl(str2));
        }
        return URLUtil.addParameter(URLUtil.addParameter(str, "from", String.valueOf(246610)), "biz", "ka");
    }

    private long c(@Nullable IGProChannelInfo iGProChannelInfo) {
        if (iGProChannelInfo == null) {
            return 0L;
        }
        try {
            return Long.parseLong(iGProChannelInfo.getChannelUin());
        } catch (NumberFormatException unused) {
            return 0L;
        }
    }

    private String i() {
        if (D()) {
            return QQGuildUIUtil.s(R.string.f156561kj, this.f235164c.getChannelName());
        }
        if (A()) {
            String liveRoomName = this.f235164c.getLiveRoomName();
            Object[] objArr = new Object[1];
            if (TextUtils.isEmpty(liveRoomName)) {
                liveRoomName = this.f235164c.getChannelName();
            }
            objArr[0] = liveRoomName;
            return QQGuildUIUtil.s(R.string.f156551ki, objArr);
        }
        if (C()) {
            return QQGuildUIUtil.s(R.string.f156581kl, this.f235164c.getChannelName());
        }
        if (x()) {
            return QQGuildUIUtil.s(R.string.f156531kg, this.f235164c.getChannelName());
        }
        if (B()) {
            return QQGuildUIUtil.s(R.string.f156571kk, this.f235163b.f235321c);
        }
        return QQGuildUIUtil.s(R.string.f156631kq, j(), this.f235164c.getChannelName());
    }

    private String j() {
        if (D()) {
            return QQGuildUIUtil.r(R.string.f142000i7);
        }
        if (A()) {
            return QQGuildUIUtil.r(R.string.f141990i6);
        }
        if (C()) {
            return QQGuildUIUtil.r(R.string.f142020i9);
        }
        if (x()) {
            return QQGuildUIUtil.r(R.string.f152561_q);
        }
        if (y()) {
            return QQGuildUIUtil.r(R.string.f141970i4);
        }
        if (z()) {
            return QQGuildUIUtil.r(R.string.f141980i5);
        }
        if (B()) {
            return QQGuildUIUtil.r(R.string.f142010i8);
        }
        if (w()) {
            return QQGuildUIUtil.r(R.string.f141960i3);
        }
        return "";
    }

    private String o() {
        return ((IGPSService) ch.S0(IGPSService.class, "")).getSelfGuildMemberName(this.f235162a.getGuildID());
    }

    private String p() {
        if (this.f235164c == null && this.f235169h != 15) {
            return (String) cp1.c.f391536a.c(this.f235162a.getUserNum(), QQGuildUIUtil.r(R.string.f156711ky));
        }
        return this.f235162a.getGuildName();
    }

    private boolean w() {
        IGProChannelInfo iGProChannelInfo = this.f235164c;
        if (iGProChannelInfo != null && iGProChannelInfo.getType() == 6) {
            return true;
        }
        return false;
    }

    private boolean x() {
        IGProChannelInfo iGProChannelInfo = this.f235164c;
        if (iGProChannelInfo != null && iGProChannelInfo.getType() == 7) {
            return true;
        }
        return false;
    }

    private boolean y() {
        IGProAppChnnPreInfo appChnnPreInfo;
        IGProChannelInfo iGProChannelInfo = this.f235164c;
        if (iGProChannelInfo == null || iGProChannelInfo.getType() != 6 || (appChnnPreInfo = ((IGPSService) ch.R0(IGPSService.class)).getAppChnnPreInfo(this.f235164c.getGuildId(), this.f235164c.getChannelUin())) == null || appChnnPreInfo.getAppid() != 1000075) {
            return false;
        }
        return true;
    }

    private boolean z() {
        IGProAppChnnPreInfo appChnnPreInfo;
        IGProChannelInfo iGProChannelInfo = this.f235164c;
        if (iGProChannelInfo == null || iGProChannelInfo.getType() != 6 || (appChnnPreInfo = ((IGPSService) ch.R0(IGPSService.class)).getAppChnnPreInfo(this.f235164c.getGuildId(), this.f235164c.getChannelUin())) == null || appChnnPreInfo.getAppid() != MiniAppReportManager.MAX_TIME_VALUE) {
            return false;
        }
        return true;
    }

    public void E(int i3) {
        this.f235169h = i3;
    }

    public void F(String str) {
        this.f235171j = str;
    }

    public void G(String str) {
        this.f235170i = com.tencent.mobileqq.guild.share.util.d.f235123a.c(str);
    }

    public String d() {
        String p16 = p();
        if (p16.length() < 100) {
            return p16;
        }
        return p16.substring(0, 95);
    }

    public com.tencent.mobileqq.sharehelper.a e() {
        if (QLog.isDebugVersion()) {
            QLog.d("Guild.share.ShareInfoProvider", 1, "use new ark info", this.f235170i);
        }
        return this.f235170i;
    }

    public String f() {
        if (!TextUtils.isEmpty(this.f235171j)) {
            return this.f235171j;
        }
        if (!TextUtils.isEmpty(this.f235163b.f235323e)) {
            try {
                return bg.f235465a.a(this.f235163b.f235323e).getQueryParameter("attaContentID");
            } catch (Throwable th5) {
                QLog.e("Guild.share.ShareInfoProvider", 1, "getAttaId exception=", th5);
                return "";
            }
        }
        return "";
    }

    public String g() {
        return this.f235162a.getAvatarUrl(0);
    }

    public int h() {
        return this.f235169h;
    }

    public String k() {
        return "#\u817e\u8baf\u9891\u9053\uff1a" + this.f235162a.getGuildNumber();
    }

    public String l() {
        return QQGuildUIUtil.r(R.string.f15158183);
    }

    public String m() {
        boolean k3 = com.tencent.mobileqq.guild.share.shorturl.a.k(v());
        String a16 = com.tencent.mobileqq.guild.share.util.c.a(v(), String.valueOf(this.f235169h));
        if (!k3) {
            a16 = v();
        }
        if (!TextUtils.isEmpty(this.f235163b.f235320b)) {
            if (k3) {
                return this.f235163b.f235320b.replace(v(), a16);
            }
            return this.f235163b.f235320b;
        }
        if (this.f235164c == null) {
            return QQGuildUIUtil.s(R.string.f156751l2, this.f235162a.getGuildName(), a16);
        }
        return QQGuildUIUtil.s(R.string.f156641kr, j(), this.f235164c.getChannelName(), a16);
    }

    public String n() {
        return QQGuildUIUtil.r(R.string.f156601kn);
    }

    public String q() {
        if (this.f235164c == null) {
            if (this.f235169h == 15) {
                return QQGuildUIUtil.r(R.string.f156541kh);
            }
            return this.f235162a.getGuildName();
        }
        return i();
    }

    public com.tencent.mobileqq.sharehelper.d r() {
        String s16 = s();
        com.tencent.mobileqq.sharehelper.d dVar = new com.tencent.mobileqq.sharehelper.d();
        dVar.n(d());
        dVar.j("");
        dVar.p(q());
        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add(g());
        dVar.l(arrayList);
        if (TextUtils.isEmpty(s16)) {
            s16 = v();
        }
        dVar.o(s16);
        dVar.i(MobileQQ.sMobileQQ.waitAppRuntime(null).getCurrentUin());
        dVar.m(2000);
        return dVar;
    }

    public String s() {
        if (!TextUtils.isEmpty(this.f235163b.f235323e)) {
            return this.f235163b.f235323e;
        }
        if (com.tencent.mobileqq.guild.share.shorturl.a.k(this.f235163b.f235319a)) {
            return com.tencent.mobileqq.guild.share.util.c.a(v(), String.valueOf(this.f235169h));
        }
        return "";
    }

    public long t() {
        return this.f235166e;
    }

    public long u() {
        try {
            return Long.parseLong(this.f235162a.getGuildID());
        } catch (NumberFormatException unused) {
            return 0L;
        }
    }

    public String v() {
        return this.f235163b.f235319a;
    }

    public y(@NonNull IGProGuildInfo iGProGuildInfo, @Nullable IGProChannelInfo iGProChannelInfo, @NonNull b.c cVar) {
        this.f235168g = false;
        this.f235169h = 0;
        this.f235170i = null;
        this.f235171j = null;
        this.f235162a = iGProGuildInfo;
        this.f235164c = iGProChannelInfo;
        String o16 = o();
        this.f235165d = o16;
        this.f235163b = a(cVar, o16);
        this.f235166e = c(iGProChannelInfo);
        boolean z16 = com.tencent.mobileqq.guild.media.core.m.n(com.tencent.mobileqq.guild.media.core.j.c()) == 6;
        this.f235168g = z16;
        if (z16) {
            this.f235167f = com.tencent.mobileqq.guild.media.core.j.a().d0().getThirdAppInfo();
        }
    }
}

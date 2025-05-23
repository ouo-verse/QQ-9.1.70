package com.tencent.mobileqq.guild.robot.components.share;

import androidx.annotation.NonNull;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.guild.robot.api.model.share.RobotShareInGuildParams;
import com.tencent.mobileqq.guild.robot.api.model.share.RobotShareInQQParams;
import com.tencent.mobileqq.guild.robot.components.console.RobotInfo;
import com.tencent.mobileqq.guild.util.QQGuildUIUtil;
import com.tencent.mobileqq.guild.util.ch;
import java.util.ArrayList;
import mqq.app.MobileQQ;

/* compiled from: P */
/* loaded from: classes14.dex */
public class d {

    /* renamed from: a, reason: collision with root package name */
    private final RobotInfo f232240a;

    public d(@NonNull RobotInfo robotInfo) {
        this.f232240a = robotInfo;
    }

    public String a() {
        return this.f232240a.f();
    }

    public String b() {
        return "\u70b9\u51fb\u94fe\u63a5\u4e86\u89e3\u673a\u5668\u4eba\u8be6\u60c5\u3010" + g() + "\u3011" + n();
    }

    public String c() {
        return QQGuildUIUtil.r(R.string.f156601kn);
    }

    public String d() {
        return "\u3010\u5206\u4eab\u3011" + this.f232240a.j();
    }

    public com.tencent.mobileqq.sharehelper.d e() {
        com.tencent.mobileqq.sharehelper.d dVar = new com.tencent.mobileqq.sharehelper.d();
        dVar.n(l());
        dVar.j("");
        dVar.p(m());
        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add(a());
        dVar.l(arrayList);
        dVar.o(n());
        dVar.k(0);
        dVar.i(MobileQQ.sMobileQQ.peekAppRuntime().getCurrentUin());
        dVar.m(2000);
        return dVar;
    }

    public long f() {
        return this.f232240a.a();
    }

    public String g() {
        return this.f232240a.j();
    }

    public RobotShareInGuildParams h() {
        return new RobotShareInGuildParams(String.valueOf(this.f232240a.k()), String.valueOf(this.f232240a.l()), this.f232240a.j(), this.f232240a.g(), this.f232240a.f(), String.valueOf(this.f232240a.a()));
    }

    public RobotShareInQQParams i() {
        return new RobotShareInQQParams(this.f232240a.j(), this.f232240a.g(), this.f232240a.f(), String.valueOf(this.f232240a.a()));
    }

    public long j() {
        return this.f232240a.k();
    }

    public long k() {
        return this.f232240a.l();
    }

    public String l() {
        return this.f232240a.g();
    }

    public String m() {
        return this.f232240a.j();
    }

    public String n() {
        return ch.a0() + "?robot_appid=" + this.f232240a.a();
    }
}

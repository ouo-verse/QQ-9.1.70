package ox1;

import com.tencent.mobileqq.guild.robot.components.console.RobotInfo;
import com.tencent.qqnt.kernel.nativeinterface.GProGuildRobotData;
import com.tencent.qqnt.kernel.nativeinterface.GProGuildRobotInfoRsp;
import java.util.HashMap;

/* compiled from: P */
/* loaded from: classes14.dex */
public class d {

    /* renamed from: a, reason: collision with root package name */
    private boolean f424408a;

    /* renamed from: b, reason: collision with root package name */
    private boolean f424409b;

    /* renamed from: c, reason: collision with root package name */
    private boolean f424410c;

    /* renamed from: d, reason: collision with root package name */
    private String f424411d;

    /* renamed from: e, reason: collision with root package name */
    private String f424412e;

    /* renamed from: f, reason: collision with root package name */
    private String f424413f;

    /* renamed from: g, reason: collision with root package name */
    private String f424414g;

    /* renamed from: h, reason: collision with root package name */
    private String f424415h;

    /* renamed from: i, reason: collision with root package name */
    private boolean f424416i;

    /* renamed from: j, reason: collision with root package name */
    private int f424417j;

    /* renamed from: k, reason: collision with root package name */
    private RobotInfo f424418k;

    /* renamed from: l, reason: collision with root package name */
    private final GProGuildRobotInfoRsp f424419l;

    /* renamed from: m, reason: collision with root package name */
    private HashMap<String, Object> f424420m;

    /* renamed from: n, reason: collision with root package name */
    private String f424421n;

    /* renamed from: o, reason: collision with root package name */
    private boolean f424422o;

    public d(cx1.e eVar, boolean z16, int i3, GProGuildRobotInfoRsp gProGuildRobotInfoRsp) {
        GProGuildRobotData robotData = gProGuildRobotInfoRsp.getRobotData();
        this.f424408a = robotData.getStatus() == 1;
        this.f424409b = robotData.getIsSharable();
        this.f424416i = z16;
        this.f424417j = i3;
        this.f424419l = gProGuildRobotInfoRsp;
        this.f424410c = sx1.f.i(gProGuildRobotInfoRsp.getRole(), robotData.getRobotRole());
        this.f424411d = eVar.g();
        this.f424412e = eVar.c();
        this.f424413f = String.valueOf(eVar.k().k());
        this.f424414g = String.valueOf(eVar.k().l());
        this.f424415h = robotData.getRobotName();
        this.f424418k = eVar.k();
        this.f424420m = eVar.i().a();
        this.f424421n = eVar.d();
        this.f424422o = eVar.q();
    }

    public String a() {
        return this.f424412e;
    }

    public HashMap<String, Object> b() {
        return this.f424420m;
    }

    public String c() {
        return this.f424411d;
    }

    public GProGuildRobotInfoRsp d() {
        return this.f424419l;
    }

    public int e() {
        return this.f424417j;
    }

    public RobotInfo f() {
        return this.f424418k;
    }

    public String g() {
        return this.f424415h;
    }

    public String h() {
        return this.f424413f;
    }

    public String i() {
        return this.f424414g;
    }

    public boolean j() {
        return this.f424408a;
    }

    public boolean k() {
        return this.f424410c;
    }

    public boolean l() {
        return this.f424409b;
    }

    public boolean m() {
        String str = this.f424421n;
        if (str != "4" && str != "5") {
            return false;
        }
        return true;
    }

    public boolean n() {
        return this.f424422o;
    }

    public boolean o() {
        return this.f424416i;
    }

    public String toString() {
        return "MoreSettingData{hasAddedRobot=" + this.f424408a + ", canShareRobot=" + this.f424409b + ", isAdmin=" + this.f424410c + ", guildId='" + this.f424411d + "', channelId='" + this.f424412e + "', robotId='" + this.f424413f + "', robotUin='" + this.f424414g + "', robotName='" + this.f424415h + ", isPunished=" + this.f424416i + ", mPunishString=" + this.f424417j + ", mInfo=" + this.f424418k + ", mInfoReply=" + this.f424419l + ", mDaTongParams=" + this.f424420m + ", mDtSource=" + this.f424421n + ", mIsFromDirectMsg=" + this.f424422o + '}';
    }
}

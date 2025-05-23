package cx1;

import android.app.Activity;
import androidx.fragment.app.FragmentManager;
import com.tencent.mobileqq.guild.robot.api.model.GuildChannel;
import com.tencent.mobileqq.guild.robot.components.console.RobotInfo;
import com.tencent.mobileqq.guild.robot.components.console.RobotInfoFragment;
import com.tencent.qqnt.kernel.nativeinterface.GProGuildRobotData;
import mqq.util.WeakReference;

/* compiled from: P */
/* loaded from: classes14.dex */
public class e {

    /* renamed from: a, reason: collision with root package name */
    private final String f392259a;

    /* renamed from: b, reason: collision with root package name */
    private final String f392260b;

    /* renamed from: c, reason: collision with root package name */
    private final String f392261c;

    /* renamed from: d, reason: collision with root package name */
    private final boolean f392262d;

    /* renamed from: e, reason: collision with root package name */
    private final GuildChannel f392263e;

    /* renamed from: f, reason: collision with root package name */
    private final RobotInfo f392264f;

    /* renamed from: g, reason: collision with root package name */
    private final WeakReference<Activity> f392265g;

    /* renamed from: h, reason: collision with root package name */
    private final RobotInfoFragment f392266h;

    /* renamed from: i, reason: collision with root package name */
    private final d f392267i;

    /* renamed from: j, reason: collision with root package name */
    private final a f392268j;

    /* renamed from: k, reason: collision with root package name */
    private final int f392269k;

    public e(RobotInfo robotInfo, String str, boolean z16, Activity activity, RobotInfoFragment robotInfoFragment, int i3) {
        this.f392259a = String.valueOf(robotInfo.e());
        this.f392260b = String.valueOf(robotInfo.b());
        this.f392261c = str;
        this.f392262d = z16;
        this.f392264f = robotInfo;
        this.f392265g = new WeakReference<>(activity);
        this.f392266h = robotInfoFragment;
        GuildChannel guildChannel = new GuildChannel();
        this.f392263e = guildChannel;
        guildChannel.c(robotInfo.b());
        guildChannel.e(robotInfo.e());
        this.f392268j = new w(this);
        this.f392267i = new ba(this, robotInfoFragment.getRootView());
        this.f392269k = i3;
    }

    public void a() {
        this.f392266h.dismissAllowingStateLoss();
    }

    public Activity b() {
        return this.f392265g.get();
    }

    public String c() {
        return this.f392260b;
    }

    public String d() {
        return this.f392261c;
    }

    public FragmentManager e() {
        return this.f392266h.getParentFragmentManager();
    }

    public GuildChannel f() {
        return this.f392263e;
    }

    public String g() {
        return this.f392259a;
    }

    public a h() {
        return this.f392268j;
    }

    public d i() {
        return this.f392267i;
    }

    public int j() {
        return this.f392269k;
    }

    public RobotInfo k() {
        return this.f392264f;
    }

    public boolean l(GProGuildRobotData gProGuildRobotData) {
        if (gProGuildRobotData.getStatus() != 1 || !o()) {
            return false;
        }
        return sx1.f.e(String.valueOf(gProGuildRobotData.getRobotTid()));
    }

    public void m() {
        this.f392266h.getDialog().hide();
    }

    public boolean n() {
        return this.f392266h.isAdded();
    }

    public boolean o() {
        if (!this.f392261c.equals("4") && !this.f392261c.equals("5")) {
            return false;
        }
        return true;
    }

    public boolean p() {
        return this.f392266h.isDetached();
    }

    public boolean q() {
        return this.f392262d;
    }

    public boolean r() {
        return this.f392261c.equals("0");
    }

    public boolean s() {
        return this.f392266h.isRemoving();
    }

    public void t(c cVar) {
        this.f392266h.uh(cVar);
    }

    public void u() {
        this.f392266h.getDialog().show();
    }

    public void v(int i3) {
        this.f392266h.vh(i3);
    }
}

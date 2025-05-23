package com.tencent.mobileqq.guild.feed.publish;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.util.Consumer;
import androidx.core.util.Supplier;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.guild.feed.event.GuildPublishReEditEvent;
import com.tencent.mobileqq.guild.feed.publish.bean.GuildTaskProgressState;
import com.tencent.mobileqq.guild.feed.publish.event.GuildRemoveFakeFeedTaskEvent;
import com.tencent.mobileqq.guild.feed.publish.event.PostFeedFailedEvent;
import com.tencent.mobileqq.guild.feed.publish.helper.GuildDbDataHelper;
import com.tencent.mobileqq.guild.feed.publish.helper.GuildTaskProgressBoxHelper;
import com.tencent.mobileqq.guild.feed.publish.publish.j;
import com.tencent.mobileqq.guild.feed.publish.publishV2.taskx.FeedMediaUploadTaskRestoreInfoQueryFilter;
import com.tencent.mobileqq.guild.feed.publish.publishV2.taskx.PostFeedMainTaskFacadeImpl;
import com.tencent.mobileqq.guild.feed.util.ax;
import com.tencent.mobileqq.guild.feed.util.bn;
import com.tencent.mobileqq.guild.mainframe.GuildFeedReportSourceInfo;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.richframework.thread.RFWThreadManager;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.concurrent.CancellationException;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* compiled from: P */
/* loaded from: classes13.dex */
public class GuildSingleMainTask implements j.c, v {

    /* renamed from: a, reason: collision with root package name */
    private final PostFeedMainTaskFacadeImpl f222854a;

    /* renamed from: b, reason: collision with root package name */
    private boolean f222855b;

    /* renamed from: c, reason: collision with root package name */
    private final AtomicInteger f222856c;

    /* renamed from: d, reason: collision with root package name */
    private final String f222857d;

    /* renamed from: e, reason: collision with root package name */
    private final com.tencent.mobileqq.guild.feed.publish.publish.j f222858e;

    /* renamed from: f, reason: collision with root package name */
    private final LinkedList<a> f222859f;

    /* renamed from: g, reason: collision with root package name */
    private String f222860g;

    /* renamed from: h, reason: collision with root package name */
    private boolean f222861h;

    /* renamed from: i, reason: collision with root package name */
    private boolean f222862i;

    /* renamed from: j, reason: collision with root package name */
    private boolean f222863j;

    /* renamed from: k, reason: collision with root package name */
    private boolean f222864k;

    /* renamed from: l, reason: collision with root package name */
    private int f222865l;

    /* renamed from: m, reason: collision with root package name */
    private GuildFeedReportSourceInfo f222866m;

    public GuildSingleMainTask(@NonNull String str, String str2, String str3, int i3, boolean z16, int i16, GuildFeedReportSourceInfo guildFeedReportSourceInfo, int i17) {
        AtomicInteger atomicInteger = new AtomicInteger(0);
        this.f222856c = atomicInteger;
        this.f222859f = new LinkedList<>();
        this.f222863j = true;
        this.f222864k = true;
        this.f222857d = str;
        this.f222855b = z16;
        com.tencent.mobileqq.guild.feed.publish.publish.j jVar = new com.tencent.mobileqq.guild.feed.publish.publish.j(z16, str2, str3, this);
        this.f222858e = jVar;
        jVar.M(this);
        this.f222865l = i16;
        this.f222866m = guildFeedReportSourceInfo;
        S(i3);
        GuildTaskProgressBoxHelper.o().j(str, atomicInteger.get(), str2, str3, this.f222855b, this.f222865l, guildFeedReportSourceInfo, i17);
        this.f222854a = new PostFeedMainTaskFacadeImpl(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void A() {
        bn.f223895a.b(R.string.f144630pa, new Function0() { // from class: com.tencent.mobileqq.guild.feed.publish.z
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                Unit z16;
                z16 = GuildSingleMainTask.z();
                return z16;
            }
        });
    }

    private void B() {
        this.f222861h = true;
        this.f222862i = true;
        this.f222854a.c(2);
        S(6);
    }

    private void E(boolean z16) {
        this.f222854a.k(this.f222860g);
        GuildTaskProgressBoxHelper.o().B(this.f222857d, this.f222856c.get(), z16, this.f222860g);
    }

    private boolean F() {
        if (!NetworkUtil.isNetworkAvailable()) {
            QLog.e("PostFeedTask.MainTask", 1, "[publishFeed]: " + m() + " network unavailable");
            Z();
            return true;
        }
        return false;
    }

    private void L() {
        GuildTaskProgressBoxHelper.o().D(this.f222857d, this.f222856c.get(), new Object[0]);
        RFWThreadManager.getUIHandler().postDelayed(new Runnable() { // from class: com.tencent.mobileqq.guild.feed.publish.GuildSingleMainTask.1
            @Override // java.lang.Runnable
            public void run() {
                GuildTaskQueueManager.m().L(GuildSingleMainTask.this.f222857d);
                GuildTaskProgressBoxHelper.o().y(GuildSingleMainTask.this.f222857d);
                GuildDbDataHelper.s().q(GuildSingleMainTask.this.f222857d);
                GuildRemoveFakeFeedTaskEvent guildRemoveFakeFeedTaskEvent = new GuildRemoveFakeFeedTaskEvent();
                guildRemoveFakeFeedTaskEvent.setMainTaskId(GuildSingleMainTask.this.f222857d);
                SimpleEventBus.getInstance().dispatchEvent(guildRemoveFakeFeedTaskEvent);
            }
        }, 500L);
    }

    private void M(boolean z16, long j3, String str) {
        int i3;
        if (z16) {
            i3 = 0;
        } else {
            i3 = 400002;
        }
        km1.a.f412694a.g(this.f222857d, i3, str, j3);
    }

    private void N(com.tencent.mobileqq.guild.feed.publish.publishV2.taskx.h hVar) {
        km1.a.f412694a.g(this.f222857d, 400001, "upload fail: taskInfo=" + hVar, 0L);
    }

    private static void W(long j3, String str) {
        if (TextUtils.isEmpty(str)) {
            int i3 = (int) j3;
            if (i3 != 20015) {
                if (i3 != 20016) {
                    str = HardCodeUtil.qqStr(R.string.f145170qr);
                } else {
                    str = HardCodeUtil.qqStr(R.string.f144990q_);
                }
            } else {
                str = HardCodeUtil.qqStr(R.string.f144980q9);
            }
        }
        yl1.n.C(false, str);
    }

    private synchronized void X(@Nullable com.tencent.mobileqq.guild.feed.publish.publishV2.taskx.h hVar) {
        Map<String, com.tencent.mobileqq.guild.data.o> emptyMap;
        S(2);
        boolean isNetworkAvailable = NetworkUtil.isNetworkAvailable();
        QLog.i("PostFeedTask.MainTask", 1, "[triggerRealPublishRequest]: " + m() + ", networkAvailable = " + isNetworkAvailable + ", uploadResult = " + hVar);
        km1.a.f412694a.i(this.f222857d, this.f222858e.getGuildId(), this.f222858e.getChannelId());
        if (isNetworkAvailable) {
            GuildTaskProgressBoxHelper.o().D(this.f222857d, this.f222856c.get(), new Object[0]);
            com.tencent.mobileqq.guild.feed.publish.publish.j jVar = this.f222858e;
            String str = this.f222860g;
            if (hVar != null) {
                emptyMap = hVar.f();
            } else {
                emptyMap = Collections.emptyMap();
            }
            jVar.F(str, emptyMap, this.f222865l, this.f222866m);
        } else {
            Z();
        }
    }

    private void Z() {
        S(5);
        GuildTaskProgressBoxHelper.o().D(this.f222857d, this.f222856c.get(), new Object[0]);
        SimpleEventBus.getInstance().dispatchEvent(new PostFeedFailedEvent(this.f222857d, this.f222855b, -1, "\u7f51\u7edc\u5f02\u5e38"));
        if (this.f222855b) {
            SimpleEventBus.getInstance().dispatchEvent(new GuildPublishReEditEvent(-1L, "\u7f51\u7edc\u5f02\u5e38", ""), true);
        }
        if (c()) {
            ThreadManagerV2.getUIHandlerV2().postDelayed(new Runnable() { // from class: com.tencent.mobileqq.guild.feed.publish.y
                @Override // java.lang.Runnable
                public final void run() {
                    GuildSingleMainTask.A();
                }
            }, 200L);
        }
        km1.a.f412694a.g(this.f222857d, 400003, "", 0L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void l(com.tencent.mobileqq.guild.feed.publish.publishV2.taskx.h hVar) {
        if (hVar.getResult() != 0) {
            QLog.e("PostFeedTask.MainTask", 1, "[publishFeed]: " + m() + " uploadFail: " + hVar.getErrMsg() + ", inconsistentTaskInfo=" + hVar.getInconsistentTaskInfo());
            if (this.f222856c.get() != 2 && hVar.getResult() == -12000002 && c()) {
                yl1.n.A(1, "\u56fe\u7247/\u89c6\u9891\u4e0d\u5b58\u5728\uff0c\u8bf7\u5220\u9664\u540e\u91cd\u8bd5");
            }
            this.f222862i = false;
            this.f222854a.c(0);
            S(4);
            GuildTaskProgressBoxHelper.o().F(this.f222857d, this.f222856c.get());
            N(hVar);
            return;
        }
        X(hVar);
    }

    private static String o(long j3, String str) {
        if (j3 == 10023) {
            return "\u7f16\u8f91\u5931\u8d25\uff0c\u5f53\u524d\u6682\u65e0\u6743\u9650\u3002";
        }
        if (j3 == 10027) {
            return "\u91cd\u590d\u53d1\u8868";
        }
        if (j3 == 10015) {
            return "\u53d1\u5e16\u9891\u7387\u8fc7\u5feb\uff0c\u8bf7\u7a0d\u540e\u91cd\u8bd5\uff01";
        }
        if (j3 == 20015) {
            return HardCodeUtil.qqStr(R.string.f144980q9);
        }
        if (j3 == 20016) {
            return HardCodeUtil.qqStr(R.string.f144990q_);
        }
        return str;
    }

    public static boolean w(int i3) {
        if (i3 != 3 && i3 != 5 && i3 != 4) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ String y() {
        return this.f222857d;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Unit z() {
        yl1.n.z(1, R.string.f144630pa);
        return Unit.INSTANCE;
    }

    public void C() {
        boolean z16;
        PostFeedMainTaskFacadeImpl postFeedMainTaskFacadeImpl = this.f222854a;
        if (this.f222856c.get() == 3) {
            z16 = true;
        } else {
            z16 = false;
        }
        postFeedMainTaskFacadeImpl.m(z16);
        com.tencent.mobileqq.guild.feed.publish.publish.j jVar = this.f222858e;
        if (jVar != null) {
            jVar.C();
        }
        Iterator<a> it = this.f222859f.iterator();
        while (it.hasNext()) {
            it.next().a();
        }
    }

    public void D(@Nullable CancellationException cancellationException) {
        this.f222854a.l(cancellationException);
    }

    public void H(String str) {
        S(1);
    }

    public void J(String str, boolean z16) {
        int i3;
        if (this.f222862i) {
            QLog.e("PostFeedTask.MainTask", 1, "[publishFeed]: " + m() + ", isActive");
            return;
        }
        StringBuilder sb5 = new StringBuilder();
        sb5.append("[publishFeed]: ");
        sb5.append(m());
        sb5.append(", json.length =");
        if (str != null) {
            i3 = str.length();
        } else {
            i3 = 0;
        }
        sb5.append(i3);
        QLog.i("PostFeedTask.MainTask", 1, sb5.toString());
        this.f222860g = str;
        B();
        E(z16);
        if (F()) {
            this.f222854a.f();
            return;
        }
        S(1);
        if (!this.f222854a.getUploadTaskApi().j()) {
            this.f222854a.f();
            this.f222854a.j(new Consumer() { // from class: com.tencent.mobileqq.guild.feed.publish.w
                @Override // androidx.core.util.Consumer
                public final void accept(Object obj) {
                    GuildSingleMainTask.this.l((com.tencent.mobileqq.guild.feed.publish.publishV2.taskx.h) obj);
                }
            });
            return;
        }
        QLog.w("PostFeedTask.MainTask", 1, "[publishFeed]: " + m() + ", isActive=" + this.f222862i + ", waiting upload task result now!");
    }

    public void K(String str, String str2) {
        this.f222858e.H(str, str2);
    }

    public void O(GuildTaskProgressState guildTaskProgressState) {
        if (guildTaskProgressState == null) {
            return;
        }
        this.f222854a.getUploadTaskApi().e(new FeedMediaUploadTaskRestoreInfoQueryFilter().b(guildTaskProgressState));
    }

    public void P(boolean z16) {
        this.f222855b = z16;
        com.tencent.mobileqq.guild.feed.publish.publish.j jVar = this.f222858e;
        if (jVar != null) {
            jVar.K(z16);
        }
    }

    public void Q(boolean z16) {
        this.f222858e.L(z16);
    }

    public void R(String str) {
        this.f222860g = str;
    }

    public void S(int i3) {
        this.f222856c.set(i3);
        if (i3 == 5 || i3 == 4) {
            this.f222862i = false;
        }
        Iterator<a> it = this.f222859f.iterator();
        while (it.hasNext()) {
            it.next().b(i3);
        }
    }

    public void T(boolean z16) {
        this.f222858e.N(z16);
    }

    public void U(boolean z16) {
        this.f222864k = z16;
    }

    public void V(boolean z16) {
        this.f222863j = z16;
    }

    public void Y(int i3) {
        QLog.i("PostFeedTask.MainTask", 1, "[triggerUploadAllTask]: " + m() + " newState = " + i3);
        S(i3);
        GuildTaskProgressBoxHelper.o().D(this.f222857d, this.f222856c.get(), new Object[0]);
    }

    @Override // com.tencent.mobileqq.guild.feed.publish.publish.j.c
    public void a(boolean z16, long j3, String str, String str2) {
        int i3;
        String str3;
        this.f222862i = false;
        this.f222854a.c(0);
        if ((z16 && j3 == 0) || ax.E(j3)) {
            i3 = 3;
        } else {
            i3 = 5;
        }
        S(i3);
        if (z16 && j3 == 0) {
            this.f222854a.m(true);
            L();
        } else if (ax.E(j3)) {
            QLog.e("PostFeedTask.MainTask", 1, "onRspResult: error duplicate!");
            L();
        } else {
            if (!yl1.n.v((int) j3) && j3 != -2 && j3 != -1) {
                if (j3 == 1006002) {
                    str = HardCodeUtil.qqStr(R.string.f144970q8);
                }
            } else {
                str = HardCodeUtil.qqStr(R.string.f144630pa);
            }
            GuildTaskProgressBoxHelper.o().D(this.f222857d, this.f222856c.get(), Long.valueOf(j3), str);
        }
        if (this.f222855b) {
            if (TextUtils.isEmpty(str)) {
                str3 = o(j3, str);
            } else {
                str3 = str;
            }
            SimpleEventBus.getInstance().dispatchEvent(new GuildPublishReEditEvent(j3, str3, str2), true);
        }
        if (j3 != 0 && c()) {
            W(j3, str);
        }
        this.f222854a.m(false);
        if (j3 != 0) {
            SimpleEventBus.getInstance().dispatchEvent(new PostFeedFailedEvent(this.f222857d, this.f222855b, (int) j3, str));
        }
        M(z16, j3, str);
    }

    @Override // com.tencent.mobileqq.guild.feed.publish.v
    public String b() {
        return this.f222857d;
    }

    @Override // com.tencent.mobileqq.guild.feed.publish.v
    public boolean c() {
        return this.f222864k;
    }

    @Override // com.tencent.mobileqq.guild.feed.publish.v
    public boolean d() {
        return this.f222863j;
    }

    @Deprecated(since = "9.1.70 \u63a5\u53e3\u5e9f\u5f03")
    public void j(String str, LocalMediaInfo localMediaInfo, boolean z16) {
        if (localMediaInfo == null) {
            return;
        }
        QLog.i("PostFeedTask.MainTask", 1, "[addMedia]: " + m() + ", mediaTaskId = " + str + ", id = " + localMediaInfo._id + ", path = " + localMediaInfo.path);
        if (!TextUtils.isEmpty(localMediaInfo.path) && this.f222856c.get() != 4) {
            S(1);
        }
    }

    public String m() {
        return "mainTaskId = " + this.f222857d + ", state = " + this.f222856c;
    }

    @NonNull
    public com.tencent.mobileqq.guild.data.s n() {
        return this.f222858e;
    }

    public boolean p() {
        return this.f222858e.n();
    }

    public String q() {
        return this.f222860g;
    }

    public int r() {
        return this.f222856c.get();
    }

    @NonNull
    public in1.d s() {
        return this.f222854a;
    }

    public String t(String str) {
        com.tencent.mobileqq.guild.data.o oVar = this.f222854a.getUploadTaskApi().c().get(str);
        if (oVar != null) {
            if (oVar.isVideoTask()) {
                return "video";
            }
            return "pic";
        }
        return "";
    }

    public synchronized void u(@NonNull a aVar) {
        aVar.f222867a = new Supplier() { // from class: com.tencent.mobileqq.guild.feed.publish.x
            @Override // androidx.core.util.Supplier
            public final Object get() {
                String y16;
                y16 = GuildSingleMainTask.this.y();
                return y16;
            }
        };
        this.f222859f.add(aVar);
    }

    public boolean v() {
        return this.f222855b;
    }

    public boolean x() {
        return this.f222861h;
    }

    /* compiled from: P */
    /* loaded from: classes13.dex */
    public static abstract class a {

        /* renamed from: a, reason: collision with root package name */
        protected Supplier<String> f222867a;

        public abstract void b(int i3);

        public void a() {
        }
    }

    public void G(String str) {
    }

    public void I(String str) {
    }

    @Deprecated(since = "9.1.70 \u65e0\u6548\u8c03\u7528")
    public void k(String str) {
    }
}

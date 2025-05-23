package com.tencent.icgame.game.liveroom.impl.room.definition;

import android.app.Activity;
import android.view.View;
import androidx.annotation.NonNull;
import com.heytap.databaseengine.utils.DateUtil;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.eventbus.SimpleEventReceiver;
import com.tencent.icgame.common.api.IAegisLogApi;
import com.tencent.icgame.game.liveroom.impl.room.audience.event.DefinitionChangedEvent;
import com.tencent.icgame.game.liveroom.impl.room.definition.c;
import com.tencent.icgame.game.ui.widget.f;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.icgame.api.room.ILiveAudienceTPPlayerRoom;
import com.tencent.mobileqq.icgame.data.room.EnterRoomInfo;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import rv0.DefinitionNeedChangeEvent;
import rv0.FirstFramePlayEvent;

/* compiled from: P */
/* loaded from: classes7.dex */
public class DefinitionController extends b32.a {

    /* renamed from: s, reason: collision with root package name */
    public static SimpleDateFormat f115178s = new SimpleDateFormat(DateUtil.DATE_FORMAT_8, Locale.getDefault());

    /* renamed from: b, reason: collision with root package name */
    protected final Activity f115180b;

    /* renamed from: c, reason: collision with root package name */
    private com.tencent.icgame.game.liveroom.impl.room.definition.c f115181c;

    /* renamed from: d, reason: collision with root package name */
    private com.tencent.icgame.game.liveroom.impl.room.definition.c f115182d;

    /* renamed from: g, reason: collision with root package name */
    private c f115185g;

    /* renamed from: h, reason: collision with root package name */
    protected long f115186h;

    /* renamed from: p, reason: collision with root package name */
    private f32.a f115194p;

    /* renamed from: a, reason: collision with root package name */
    private final IAegisLogApi f115179a = (IAegisLogApi) QRoute.api(IAegisLogApi.class);

    /* renamed from: e, reason: collision with root package name */
    private DefinitionPopupWindow f115183e = new DefinitionPopupWindow();

    /* renamed from: f, reason: collision with root package name */
    private final List<EnterRoomInfo.VideoDefinition> f115184f = new ArrayList();

    /* renamed from: i, reason: collision with root package name */
    private boolean f115187i = true;

    /* renamed from: j, reason: collision with root package name */
    private boolean f115188j = true;

    /* renamed from: k, reason: collision with root package name */
    private boolean f115189k = false;

    /* renamed from: l, reason: collision with root package name */
    private boolean f115190l = true;

    /* renamed from: m, reason: collision with root package name */
    private boolean f115191m = true;

    /* renamed from: n, reason: collision with root package name */
    private long f115192n = 0;

    /* renamed from: o, reason: collision with root package name */
    private long f115193o = -1;

    /* renamed from: q, reason: collision with root package name */
    private com.tencent.icgame.game.liveroom.impl.room.definition.a f115195q = com.tencent.icgame.game.liveroom.impl.room.definition.a.INSTANCE.a();

    /* renamed from: r, reason: collision with root package name */
    private Runnable f115196r = new Runnable() { // from class: com.tencent.icgame.game.liveroom.impl.room.definition.DefinitionController.4
        @Override // java.lang.Runnable
        public void run() {
            DefinitionController.this.o();
        }
    };

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes7.dex */
    public class a implements c.d {
        a() {
        }

        @Override // com.tencent.icgame.game.liveroom.impl.room.definition.c.d
        public void onClick(View view) {
            DefinitionController.this.f115183e.d();
            DefinitionController definitionController = DefinitionController.this;
            definitionController.D(definitionController.f115186h, (EnterRoomInfo.VideoDefinition) view.getTag(), DefinitionController.this.f115188j);
        }
    }

    /* compiled from: P */
    /* loaded from: classes7.dex */
    public static abstract class b implements SimpleEventReceiver {
        public abstract void a(long j3, EnterRoomInfo.VideoDefinition videoDefinition);

        @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
        public ArrayList<Class> getEventClass() {
            ArrayList<Class> arrayList = new ArrayList<>();
            arrayList.add(DefinitionChangedEvent.class);
            return arrayList;
        }

        @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
        public void onReceiveEvent(SimpleBaseEvent simpleBaseEvent) {
            if (!(simpleBaseEvent instanceof DefinitionChangedEvent)) {
                QLog.e("ICGameUnknown|ICGameDefinitionController", 1, "onReceiveEvent failed, not DefinitionChangedEvent");
            } else {
                DefinitionChangedEvent definitionChangedEvent = (DefinitionChangedEvent) simpleBaseEvent;
                a(definitionChangedEvent.getRoomId(), definitionChangedEvent.getDefinition());
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes7.dex */
    public interface c {
        void a(EnterRoomInfo.VideoDefinition videoDefinition, String str);
    }

    public DefinitionController(Activity activity, long j3, f32.a aVar) {
        this.f115186h = 0L;
        this.f115180b = activity;
        if (j3 > 0) {
            this.f115186h = j3;
        }
        this.f115194p = aVar;
    }

    private void B(final String str) {
        ThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.icgame.game.liveroom.impl.room.definition.DefinitionController.2
            @Override // java.lang.Runnable
            public void run() {
                try {
                    f.b(str);
                } catch (Exception e16) {
                    QLog.e("ICGameUnknown|ICGameDefinitionController", 1, e16.getMessage());
                }
            }
        });
    }

    private void C() {
        this.f115189k = true;
    }

    private void E(EnterRoomInfo.VideoDefinition videoDefinition) {
        ILiveAudienceTPPlayerRoom a16 = com.tencent.icgame.game.liveroom.impl.room.definition.b.a(this.f115186h);
        if (a16 != null) {
            if (this.f115190l) {
                a16.unRegisterRoomPlayerListener(this);
                a16.registerRoomPlayerListener(this);
                a16.switchVideoDefinition(videoDefinition);
                return;
            } else {
                a16.updateCurrentDefinitionFromOutPlayer(videoDefinition);
                a16.getTargetUrl(videoDefinition);
                throw null;
            }
        }
        QLog.w("ICGameUnknown|ICGameDefinitionController", 1, "switchDefinition audienceRoom == null");
    }

    public static void F(@NonNull b bVar) {
        SimpleEventBus.getInstance().unRegisterReceiver(bVar);
    }

    private com.tencent.icgame.game.liveroom.impl.room.definition.c e(boolean z16) {
        c.C5833c c5833c = new c.C5833c();
        c5833c.b(this.f115180b).d(z16).c(this.f115184f).e(new a());
        return c5833c.a();
    }

    private void f() {
        x(true);
        if (this.f115189k && this.f115188j) {
            B("\u5df2\u4e3a\u4f60\u5207\u6362\u5230" + com.tencent.icgame.game.liveroom.impl.room.definition.b.e(com.tencent.icgame.game.liveroom.impl.room.definition.b.c(this.f115186h)));
        }
        this.f115189k = false;
    }

    private com.tencent.icgame.game.liveroom.impl.room.definition.c g(boolean z16) {
        if (z16) {
            return h();
        }
        return i();
    }

    private com.tencent.icgame.game.liveroom.impl.room.definition.c h() {
        com.tencent.icgame.game.liveroom.impl.room.definition.c cVar = this.f115181c;
        if (cVar != null) {
            return cVar;
        }
        com.tencent.icgame.game.liveroom.impl.room.definition.c e16 = e(true);
        this.f115181c = e16;
        return e16;
    }

    private com.tencent.icgame.game.liveroom.impl.room.definition.c i() {
        com.tencent.icgame.game.liveroom.impl.room.definition.c cVar = this.f115182d;
        if (cVar != null) {
            return cVar;
        }
        com.tencent.icgame.game.liveroom.impl.room.definition.c e16 = e(false);
        this.f115182d = e16;
        return e16;
    }

    private String j() {
        if (f115178s == null) {
            f115178s = new SimpleDateFormat(DateUtil.DATE_FORMAT_8, Locale.getDefault());
        }
        return f115178s.format(Long.valueOf(System.currentTimeMillis()));
    }

    private boolean l(long j3) {
        List<EnterRoomInfo.VideoDefinition> b16 = com.tencent.icgame.game.liveroom.impl.room.definition.b.b(j3);
        if (b16.isEmpty()) {
            QLog.e("ICGameUnknown|ICGameDefinitionController", 1, "roomId:" + j3 + " RoomDefinitionHelper.getAudienceRoomDefinitionList empty.");
            return false;
        }
        this.f115184f.clear();
        this.f115184f.addAll(b16);
        this.f115184f.remove(EnterRoomInfo.VideoDefinition.ORIGIN);
        this.f115184f.remove(EnterRoomInfo.VideoDefinition.THFD);
        StringBuilder sb5 = new StringBuilder();
        for (EnterRoomInfo.VideoDefinition videoDefinition : this.f115184f) {
            sb5.append(" ");
            sb5.append(videoDefinition);
        }
        QLog.i("ICGameUnknown|ICGameDefinitionController", 1, "roomId:" + j3 + " definition list:" + sb5.toString());
        return true;
    }

    private void n(EnterRoomInfo.VideoDefinition videoDefinition) {
        c cVar = this.f115185g;
        if (cVar != null) {
            cVar.a(videoDefinition, com.tencent.icgame.game.liveroom.impl.room.definition.b.e(videoDefinition));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void o() {
        boolean z16;
        String str = j() + "_day_show_tips_count";
        xw0.b bVar = xw0.b.f448881a;
        long d16 = qt0.a.d(str, bVar.u());
        if (d16 >= this.f115195q.getMaxDayShowCount()) {
            rt0.a.f("ICGameUnknown|ICGameDefinitionController", "notifyDefinitionNeedChange", "fail, hasShowTipsCount=" + d16);
            return;
        }
        long currentTimeMillis = System.currentTimeMillis() - qt0.a.d("last_notify_tips_time", bVar.u());
        if (currentTimeMillis < this.f115195q.getNotifySwitchTime()) {
            rt0.a.f("ICGameUnknown|ICGameDefinitionController", "notifyDefinitionNeedChange", "fail, switch_time=" + currentTimeMillis);
            return;
        }
        List<EnterRoomInfo.VideoDefinition> b16 = com.tencent.icgame.game.liveroom.impl.room.definition.b.b(this.f115186h);
        if (b16 != null && b16.size() > 1) {
            EnterRoomInfo.VideoDefinition f16 = com.tencent.icgame.game.liveroom.impl.room.definition.b.f();
            Iterator<EnterRoomInfo.VideoDefinition> it = b16.iterator();
            while (true) {
                if (it.hasNext()) {
                    if (it.next().level > f16.level) {
                        z16 = true;
                        break;
                    }
                } else {
                    z16 = false;
                    break;
                }
            }
            if (z16) {
                String str2 = j() + "_day_show_tips_count";
                xw0.b bVar2 = xw0.b.f448881a;
                qt0.a.f(str2, bVar2.u(), d16 + 1);
                qt0.a.f("last_notify_tips_time", bVar2.u(), System.currentTimeMillis());
                if (this.f115194p != null) {
                    rt0.a.f("ICGameUnknown|ICGameDefinitionController", "notifyDefinitionNeedChange", "roomId=" + this.f115186h);
                    this.f115194p.w0(new DefinitionNeedChangeEvent(this.f115186h, true));
                    return;
                }
                rt0.a.f("ICGameUnknown|ICGameDefinitionController", "notifyDefinitionNeedChange", "fail, mComponentContext is null");
                return;
            }
            rt0.a.f("ICGameUnknown|ICGameDefinitionController", "notifyDefinitionNeedChange", "fail, can not switch definition");
            return;
        }
        rt0.a.f("ICGameUnknown|ICGameDefinitionController", "notifyDefinitionNeedChange", "fail, only one definition");
    }

    public static void w(@NonNull b bVar) {
        SimpleEventBus.getInstance().registerReceiver(bVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void x(boolean z16) {
        this.f115187i = z16;
        if (!z16) {
            ThreadManager.getUIHandler().postDelayed(new Runnable() { // from class: com.tencent.icgame.game.liveroom.impl.room.definition.DefinitionController.1
                @Override // java.lang.Runnable
                public void run() {
                    DefinitionController.this.x(true);
                }
            }, 8000L);
        }
    }

    public void A(long j3, boolean z16) {
        if (!com.tencent.icgame.game.liveroom.impl.room.definition.b.l(j3)) {
            QLog.i("ICGameUnknown|ICGameDefinitionController", 1, "get room fail! roomId:" + j3);
            return;
        }
        if (this.f115194p != null) {
            rt0.a.f("ICGameUnknown|ICGameDefinitionController", "showDefinitionSwitchView", "notify hide definition tips, roomId=" + j3);
            this.f115194p.w0(new DefinitionNeedChangeEvent(j3, false));
        }
        z(k(j3), j3, z16);
    }

    public void D(long j3, EnterRoomInfo.VideoDefinition videoDefinition, boolean z16) {
        try {
            if (!com.tencent.icgame.game.liveroom.impl.room.definition.b.l(j3)) {
                QLog.w("ICGameUnknown|ICGameDefinitionController", 1, "get audience room fail!");
                return;
            }
            this.f115188j = z16;
            if (z16) {
                com.tencent.icgame.game.liveroom.impl.room.definition.b.m(videoDefinition);
                m(j3, videoDefinition);
                n(videoDefinition);
                x(false);
                B("\u5207\u6362\u6e05\u6670\u5ea6");
            }
            C();
            QLog.i("ICGameUnknown|ICGameDefinitionController", 1, "start switch video definition! definition:" + videoDefinition);
            E(videoDefinition);
        } catch (Exception e16) {
            QLog.e("ICGameUnknown|ICGameDefinitionController", 1, "setDefinition fail! ", e16);
            x(true);
        }
    }

    public EnterRoomInfo.VideoDefinition k(long j3) {
        return com.tencent.icgame.game.liveroom.impl.room.definition.b.c(j3);
    }

    public void m(long j3, EnterRoomInfo.VideoDefinition videoDefinition) {
        SimpleEventBus.getInstance().dispatchEvent(new DefinitionChangedEvent(j3, videoDefinition));
    }

    @Override // b32.a
    public void onError(int i3, int i16, int i17, String str) {
        QLog.i("ICGameUnknown|ICGameDefinitionController", 1, "onError roomId:" + this.f115186h);
        x(true);
    }

    @Override // b32.a
    public void onFirstFrameCome(long j3, long j16) {
        QLog.i("ICGameUnknown|ICGameDefinitionController", 1, "onFirstFrameCome roomId:" + this.f115186h);
        f();
    }

    @Override // b32.a
    public void onInfo(int i3, long j3, long j16, Object obj) {
        f32.a aVar;
        if (i3 == 3) {
            QLog.i("ICGameUnknown|ICGameDefinitionController", 1, "onInfo CALL_SWITCH_DEFINITION roomId:" + this.f115186h);
            f();
            return;
        }
        if (i3 == 104 && (aVar = this.f115194p) != null) {
            aVar.w0(new FirstFramePlayEvent(this.f115186h));
        }
    }

    @Override // b32.a
    public void onPlay() {
        QLog.i("ICGameUnknown|ICGameDefinitionController", 1, "onPlay roomId:" + this.f115186h);
        x(true);
        f();
    }

    @Override // b32.a
    public void onPlayCompleted() {
        QLog.i("ICGameUnknown|ICGameDefinitionController", 1, "onPlayCompleted roomId:" + this.f115186h);
        x(true);
    }

    @Override // b32.a
    public void onStartBuffer() {
        if (this.f115186h <= 0) {
            rt0.a.f("ICGameUnknown|ICGameDefinitionController", "onStartBuffer", "notifySwitchDefinition fail, roomId=" + this.f115186h);
            return;
        }
        this.f115192n = System.currentTimeMillis();
        ThreadManagerV2.getUIHandlerV2().removeCallbacks(this.f115196r);
        ThreadManagerV2.getUIHandlerV2().postDelayed(this.f115196r, this.f115195q.getCheckBufferTime());
    }

    @Override // b32.a
    public void onStopBuffer() {
        if (this.f115186h <= 0) {
            rt0.a.f("ICGameUnknown|ICGameDefinitionController", "onStopBuffer", "notifySwitchDefinition fail, roomId=" + this.f115186h);
            return;
        }
        ThreadManagerV2.getUIHandlerV2().removeCallbacks(this.f115196r);
        long currentTimeMillis = System.currentTimeMillis();
        long j3 = this.f115192n;
        long j16 = currentTimeMillis - j3;
        if (j3 > 0 && j16 >= this.f115195q.getCheckBufferTime()) {
            this.f115192n = 0L;
            rt0.a.f("ICGameUnknown|ICGameDefinitionController", "onStopBuffer", "check player buffer time=" + j16);
            o();
        }
    }

    public void p() {
        rt0.a.f("ICGameUnknown|ICGameDefinitionController", "onEnterRoom", "roomId:" + this.f115186h);
        if (!com.tencent.icgame.game.liveroom.impl.room.definition.b.l(this.f115186h)) {
            rt0.a.c("ICGameUnknown|ICGameDefinitionController", "onEnterRoom", "get audience room fail!");
            return;
        }
        ILiveAudienceTPPlayerRoom a16 = com.tencent.icgame.game.liveroom.impl.room.definition.b.a(this.f115186h);
        if (a16 == null) {
            rt0.a.c("ICGameUnknown|ICGameDefinitionController", "onEnterRoom", "audienceRoom == null");
            return;
        }
        this.f115189k = false;
        a16.unRegisterRoomPlayerListener(this);
        a16.registerRoomPlayerListener(this);
        x(true);
    }

    public void q() {
        rt0.a.f("ICGameUnknown|ICGameDefinitionController", "onExitRoom", "roomId:" + this.f115186h);
        x(true);
        ILiveAudienceTPPlayerRoom a16 = com.tencent.icgame.game.liveroom.impl.room.definition.b.a(this.f115186h);
        if (a16 != null) {
            a16.unRegisterRoomPlayerListener(this);
        }
        ThreadManagerV2.getUIHandlerV2().removeCallbacks(this.f115196r);
    }

    public void r(long j3) {
        QLog.i("ICGameUnknown|ICGameDefinitionController", 1, "onPageIn roomId:" + j3);
        this.f115186h = j3;
    }

    public void s(long j3) {
        QLog.i("ICGameUnknown|ICGameDefinitionController", 1, "onPageOut roomId:" + j3);
        this.f115186h = 0L;
    }

    public void t() {
        this.f115191m = false;
    }

    public void u() {
        this.f115191m = false;
    }

    public void v() {
        this.f115191m = true;
    }

    public void y(c cVar) {
        this.f115185g = cVar;
    }

    protected void z(EnterRoomInfo.VideoDefinition videoDefinition, long j3, boolean z16) {
        QLog.i("ICGameUnknown|ICGameDefinitionController", 1, "show roomId:" + j3 + " definition:" + videoDefinition + " isLandscape:" + z16 + " enableSwitch:" + this.f115187i);
        if (j3 > 0) {
            this.f115186h = j3;
        }
        if (!this.f115187i) {
            return;
        }
        try {
            if (!l(j3)) {
                return;
            }
            com.tencent.icgame.game.liveroom.impl.room.definition.c g16 = g(z16);
            g16.r(videoDefinition);
            this.f115183e.d();
            this.f115183e.e(this.f115180b, g16.j(), z16);
        } catch (Exception e16) {
            QLog.e("ICGameUnknown|ICGameDefinitionController", 1, "show error!", e16);
        }
    }
}

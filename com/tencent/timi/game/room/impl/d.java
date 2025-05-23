package com.tencent.timi.game.room.impl;

import ag4.h;
import com.tencent.timi.game.room.impl.tgpa.YoloRoomTGPALogic;
import com.tencent.timi.game.room.impl.util.YoloRoomUtil;
import com.tencent.timi.game.trtc.roomservice.multipevoiceroom.TimiGameQQTrtcUtil;
import com.tencent.timi.game.utils.l;
import fm4.t;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;
import trpc.yes.common.YesGameInfoOuterClass$GameConfigInfo;
import trpc.yes.common.YoloRoomOuterClass$YoloRoomCommonConf;
import trpc.yes.common.YoloRoomOuterClass$YoloRoomConf;
import trpc.yes.common.YoloRoomOuterClass$YoloRoomInfo;
import trpc.yes.common.YoloRoomOuterClass$YoloRoomSpeakingPosInfo;
import trpc.yes.common.YoloRoomOuterClass$YoloRoomUserData;
import trpc.yes.common.YoloRoomOuterClass$YoloSmobaGameDataInfo;
import trpc.yes.common.YoloRoomOuterClass$YoloUserGameData;

/* compiled from: P */
/* loaded from: classes26.dex */
public class d {

    /* renamed from: e, reason: collision with root package name */
    private static volatile d f379193e;

    /* renamed from: b, reason: collision with root package name */
    private YoloRoomTGPALogic f379195b;

    /* renamed from: a, reason: collision with root package name */
    private HashMap<Long, YoloRoomManager> f379194a = new HashMap<>();

    /* renamed from: c, reason: collision with root package name */
    private CopyOnWriteArrayList<t> f379196c = new CopyOnWriteArrayList<>();

    /* renamed from: d, reason: collision with root package name */
    private t f379197d = new a();

    /* compiled from: P */
    /* loaded from: classes26.dex */
    class a implements t {
        a() {
        }

        @Override // fm4.t
        public void f(long j3, int i3) {
            l.i("YoloRoomList", "onEnterRoom " + j3 + " - " + i3);
            Iterator it = d.this.f379196c.iterator();
            while (it.hasNext()) {
                ((t) it.next()).f(j3, i3);
            }
        }

        @Override // fm4.t
        public void l(long j3, int i3) {
            l.i("YoloRoomList", "onExitRoom " + j3 + " - " + i3);
            Iterator it = d.this.f379196c.iterator();
            while (it.hasNext()) {
                ((t) it.next()).l(j3, i3);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes26.dex */
    public static class b {

        /* renamed from: a, reason: collision with root package name */
        public boolean f379199a = false;

        /* renamed from: b, reason: collision with root package name */
        public boolean f379200b = false;

        /* renamed from: c, reason: collision with root package name */
        public boolean f379201c = false;

        b() {
        }
    }

    public static void b() {
        synchronized (d.class) {
            if (f379193e != null) {
                f379193e.c();
                f379193e = null;
            }
        }
    }

    private void c() {
        this.f379194a.clear();
        this.f379196c.clear();
    }

    private void e() {
        YoloRoomTGPALogic yoloRoomTGPALogic = this.f379195b;
        if (yoloRoomTGPALogic != null) {
            yoloRoomTGPALogic.p();
            this.f379195b.l();
            this.f379195b = null;
        }
        ((hi4.b) mm4.b.b(hi4.b.class)).x1("YoloRoomList.clear");
    }

    public static d g() {
        if (f379193e == null) {
            synchronized (d.class) {
                if (f379193e == null) {
                    f379193e = new d();
                }
            }
        }
        return f379193e;
    }

    private void l(b bVar, YoloRoomManager yoloRoomManager) {
        int roomType = yoloRoomManager.getRoomType();
        boolean z16 = true;
        if (roomType == 5) {
            try {
                if (!bVar.f379200b && !yoloRoomManager.Y().yolo_room_community_conf.wuji_yolo_room_community_conf.speaking_list_switch.get()) {
                    z16 = false;
                }
                bVar.f379200b = z16;
                return;
            } catch (Exception e16) {
                l.n("YoloRoomList", "doWhenExitRoom getRoomConf failed", e16);
                return;
            }
        }
        if (YoloRoomUtil.c0(roomType)) {
            bVar.f379199a = true;
            bVar.f379201c = yoloRoomManager.G1();
        }
    }

    public static void w(boolean z16) {
        l.i("YoloRoomList", "updateHasNeedResumeRoomExist " + z16);
        rm4.a.h("tg_rooms_exist", z16);
    }

    public void d(long j3) {
        l.i("YoloRoomList", "doWhenExitRoom - " + j3);
        YoloRoomManager remove = this.f379194a.remove(Long.valueOf(j3));
        if (remove != null) {
            remove.X0();
        }
        if (this.f379194a.size() == 0) {
            e();
        }
        b bVar = new b();
        Iterator<Map.Entry<Long, YoloRoomManager>> it = this.f379194a.entrySet().iterator();
        while (it.hasNext()) {
            l(bVar, it.next().getValue());
        }
        w(bVar.f379199a);
        l.a("YoloRoomList", 1, "doWhenExitRoom hasGangupRoomAudioEnable:" + bVar.f379201c + ", hasCommunityRoomWithMicCard:" + bVar.f379200b);
        if (this.f379194a.size() == 0 || (!bVar.f379201c && !bVar.f379200b)) {
            l.e("YoloRoomList", "abandonQQAudioEnv");
            TimiGameQQTrtcUtil.c();
        }
    }

    public YoloRoomOuterClass$YoloRoomInfo f() {
        YoloRoomManager k3 = k(YoloRoomUtil.J());
        if (k3 != null) {
            return k3.getRoomInfo();
        }
        return null;
    }

    public YoloRoomOuterClass$YoloRoomInfo h(int i3) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(Integer.valueOf(i3));
        YoloRoomManager k3 = k(arrayList);
        if (k3 != null) {
            return k3.getRoomInfo();
        }
        return null;
    }

    public YoloRoomOuterClass$YoloRoomInfo i(int i3) {
        return h(YoloRoomUtil.y(i3));
    }

    public YoloRoomManager j(long j3) {
        return this.f379194a.get(Long.valueOf(j3));
    }

    public YoloRoomManager k(List<Integer> list) {
        Iterator<Map.Entry<Long, YoloRoomManager>> it = this.f379194a.entrySet().iterator();
        while (it.hasNext()) {
            YoloRoomManager value = it.next().getValue();
            if (list.contains(Integer.valueOf(value.getRoomType()))) {
                return value;
            }
        }
        return null;
    }

    public boolean m() {
        if (this.f379194a.size() > 0) {
            return true;
        }
        return false;
    }

    public boolean n(long j3) {
        if (this.f379194a.get(Long.valueOf(j3)) != null) {
            return true;
        }
        return false;
    }

    public void o(long j3, int i3) {
        this.f379197d.f(j3, i3);
    }

    public void p(long j3, int i3) {
        this.f379197d.l(j3, i3);
    }

    public void q() {
        Iterator<Map.Entry<Long, YoloRoomManager>> it = this.f379194a.entrySet().iterator();
        while (it.hasNext()) {
            it.next().getValue().Z1();
        }
    }

    public void r() {
        int i3;
        Iterator<Map.Entry<Long, YoloRoomManager>> it = this.f379194a.entrySet().iterator();
        while (it.hasNext()) {
            YoloRoomOuterClass$YoloSmobaGameDataInfo s16 = it.next().getValue().s1();
            if (s16 != null) {
                i3 = s16.voice_control.get();
            } else {
                i3 = 0;
            }
            if (1 != i3) {
                l.i("YoloRoomList", "onGameSceneChanged#YOLO_SMOBA_ROOM_VOICE_CONTROL_DEFAULT   doNothing");
            }
        }
    }

    public void s(int i3, YoloRoomOuterClass$YoloRoomInfo yoloRoomOuterClass$YoloRoomInfo, List<YoloRoomOuterClass$YoloRoomSpeakingPosInfo> list, int i16, long j3, YoloRoomOuterClass$YoloRoomConf yoloRoomOuterClass$YoloRoomConf, YoloRoomOuterClass$YoloRoomUserData yoloRoomOuterClass$YoloRoomUserData) {
        boolean z16;
        YoloRoomOuterClass$YoloRoomCommonConf yoloRoomOuterClass$YoloRoomCommonConf;
        YesGameInfoOuterClass$GameConfigInfo yesGameInfoOuterClass$GameConfigInfo;
        long j16 = yoloRoomOuterClass$YoloRoomInfo.room_id.get();
        l.i("YoloRoomList", "onJoinNewRoom - JoinRoomType." + i3 + ", roomId = " + j16 + ", latestActionId = " + j3 + ", speakingPosListVersion = " + i16 + " - " + list);
        if (yoloRoomOuterClass$YoloRoomConf != null && (yoloRoomOuterClass$YoloRoomCommonConf = yoloRoomOuterClass$YoloRoomConf.yolo_room_common_conf) != null && (yesGameInfoOuterClass$GameConfigInfo = yoloRoomOuterClass$YoloRoomCommonConf.game_config_info) != null && yesGameInfoOuterClass$GameConfigInfo.has()) {
            YesGameInfoOuterClass$GameConfigInfo yesGameInfoOuterClass$GameConfigInfo2 = yoloRoomOuterClass$YoloRoomConf.yolo_room_common_conf.game_config_info;
            l.i("YoloRoomList", "onJoinNewRoom - gameConfigInfo.game_id.get()=" + yesGameInfoOuterClass$GameConfigInfo2.game_id.get());
            ((h) mm4.b.b(h.class)).N1(yesGameInfoOuterClass$GameConfigInfo2.game_id.get(), yesGameInfoOuterClass$GameConfigInfo2);
        }
        if (yoloRoomOuterClass$YoloRoomUserData != null && yoloRoomOuterClass$YoloRoomUserData.user_id.yes_uid.get() != 0) {
            l.h("YoloRoomList", 1, "update yesuid - " + yoloRoomOuterClass$YoloRoomUserData.user_id.yes_uid.get() + ", from = " + yoloRoomOuterClass$YoloRoomUserData.user_id.user_from.get());
            ((ll4.a) mm4.b.b(ll4.a.class)).v(((ll4.a) mm4.b.b(ll4.a.class)).B(), yoloRoomOuterClass$YoloRoomUserData.user_id.yes_uid.get());
        }
        YoloRoomManager j17 = j(j16);
        if (i3 == 2 && j17 != null) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (!z16) {
            if (j17 != null) {
                d(j16);
            }
            j17 = new YoloRoomManager(j16);
            this.f379194a.put(Long.valueOf(j16), j17);
        }
        j17.E1(i3, yoloRoomOuterClass$YoloRoomInfo, list, i16, j3, yoloRoomOuterClass$YoloRoomConf, yoloRoomOuterClass$YoloRoomUserData);
        if (this.f379195b == null) {
            YoloRoomTGPALogic yoloRoomTGPALogic = new YoloRoomTGPALogic();
            this.f379195b = yoloRoomTGPALogic;
            yoloRoomTGPALogic.o();
        }
        if (yoloRoomOuterClass$YoloRoomInfo.room_type.get() != 5) {
            w(true);
        }
    }

    public void t() {
        boolean b16 = rm4.a.b("tg_rooms_exist", false);
        l.i("YoloRoomList", "onLogout - " + this.f379194a + ", localRoomCacheValue = " + b16);
        HashMap<Long, YoloRoomManager> hashMap = this.f379194a;
        if (hashMap != null && hashMap.size() > 0) {
            ArrayList arrayList = new ArrayList();
            arrayList.addAll(this.f379194a.values());
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                ((YoloRoomManager) it.next()).g2();
            }
        }
        b();
        if (b16) {
            l.i("YoloRoomList", "resume updateHasNeedResumeRoomExist");
            w(b16);
        }
    }

    public void u(t tVar) {
        if (tVar != null && !this.f379196c.contains(tVar)) {
            this.f379196c.add(tVar);
        }
    }

    public void v(t tVar) {
        if (tVar != null && this.f379196c.contains(tVar)) {
            this.f379196c.remove(tVar);
        }
    }

    public void x(boolean z16, YoloRoomOuterClass$YoloUserGameData yoloRoomOuterClass$YoloUserGameData) {
        Iterator<Map.Entry<Long, YoloRoomManager>> it = this.f379194a.entrySet().iterator();
        while (it.hasNext()) {
            it.next().getValue().X(z16, yoloRoomOuterClass$YoloUserGameData, null);
        }
    }
}

package hm4;

import android.text.TextUtils;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import com.tencent.timi.game.env.ServerEnv;
import com.tencent.timi.game.room.impl.YoloVoiceChangeAlertUtil;
import com.tencent.timi.game.trtc.roomservice.multipevoiceroom.TimiGameQQTrtcUtil;
import com.tencent.timi.game.trtc.roomservice.multipevoiceroom.f;
import com.tencent.timi.game.utils.l;
import com.tencent.trtc.TRTCCloudDef;
import com.tencent.trtc.TRTCCloudListener;
import fm4.g;
import fm4.p;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import mqq.util.LogUtil;
import trpc.yes.common.YoloRoomOuterClass$YoloRoomInfo;

/* compiled from: P */
/* loaded from: classes26.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    boolean f405310a = true;

    /* renamed from: b, reason: collision with root package name */
    private YoloRoomOuterClass$YoloRoomInfo f405311b;

    /* renamed from: c, reason: collision with root package name */
    private int f405312c;

    /* renamed from: d, reason: collision with root package name */
    private long f405313d;

    /* renamed from: e, reason: collision with root package name */
    private com.tencent.timi.game.trtc.roomservice.multipevoiceroom.a f405314e;

    /* renamed from: f, reason: collision with root package name */
    private String f405315f;

    /* renamed from: g, reason: collision with root package name */
    private String f405316g;

    /* renamed from: h, reason: collision with root package name */
    private com.tencent.timi.game.trtc.roomservice.multipevoiceroom.d f405317h;

    /* renamed from: i, reason: collision with root package name */
    private LiveData<sn4.a> f405318i;

    /* renamed from: j, reason: collision with root package name */
    private Observer<sn4.a> f405319j;

    /* renamed from: k, reason: collision with root package name */
    private MutableLiveData<ConcurrentHashMap<String, Integer>> f405320k;

    /* renamed from: l, reason: collision with root package name */
    private Observer<ConcurrentHashMap<String, Integer>> f405321l;

    /* renamed from: m, reason: collision with root package name */
    private MutableLiveData<sn4.a> f405322m;

    /* renamed from: n, reason: collision with root package name */
    private Observer<sn4.a> f405323n;

    /* renamed from: o, reason: collision with root package name */
    private MutableLiveData<ConcurrentHashMap<String, Integer>> f405324o;

    /* renamed from: p, reason: collision with root package name */
    private Observer<ConcurrentHashMap<String, Integer>> f405325p;

    /* renamed from: q, reason: collision with root package name */
    private p f405326q;

    /* renamed from: r, reason: collision with root package name */
    private TRTCCloudListener f405327r;

    /* renamed from: s, reason: collision with root package name */
    private List<fm4.e> f405328s;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* renamed from: hm4.a$a, reason: collision with other inner class name */
    /* loaded from: classes26.dex */
    public class C10455a implements com.tencent.timi.game.trtc.roomservice.multipevoiceroom.c {
        C10455a() {
        }

        @Override // com.tencent.timi.game.trtc.roomservice.multipevoiceroom.c
        public void a(String str, boolean z16) {
            int i3;
            if (str.equals(a.this.f405315f)) {
                boolean q16 = ((g) mm4.b.b(g.class)).K0(a.this.f405313d).q(((ll4.a) mm4.b.b(ll4.a.class)).E());
                l.i("YoloRoomAudioLogic", "onSelfMicAutoChanged " + str + " - " + z16 + " - changeVoiceSwitch - isSelfInSpeaking = " + q16);
                if (q16) {
                    gm4.b A = ((g) mm4.b.b(g.class)).A(a.this.f405313d);
                    if (z16) {
                        i3 = 1;
                    } else {
                        i3 = 2;
                    }
                    A.O(null, i3, null);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes26.dex */
    public class b implements YoloVoiceChangeAlertUtil.b {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ boolean f405330a;

        b(boolean z16) {
            this.f405330a = z16;
        }

        @Override // com.tencent.timi.game.room.impl.YoloVoiceChangeAlertUtil.b
        public void onConfirm() {
            a.this.f405317h.c(a.this.f405315f);
            a.this.o(this.f405330a);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes26.dex */
    public class c extends TRTCCloudListener {
        c() {
        }

        @Override // com.tencent.trtc.TRTCCloudListener
        public void onFirstVideoFrame(String str, int i3, int i16, int i17) {
            super.onFirstVideoFrame(str, i3, i16, i17);
            a.this.w(str);
        }

        @Override // com.tencent.trtc.TRTCCloudListener
        public void onRemoteUserEnterRoom(String str) {
            super.onRemoteUserEnterRoom(str);
            if (a.this.f405311b.game_data_info.common_game_data_info.qq_live_room_config.has()) {
                a.this.f405311b.game_data_info.common_game_data_info.qq_live_room_config.qq_live_uid.get();
                long j3 = a.this.f405311b.game_data_info.common_game_data_info.qq_live_room_config.live_uid.get();
                if (((ll4.a) mm4.b.b(ll4.a.class)).h() == j3) {
                    if (str.equals(j3 + "")) {
                        a.this.f405317h.o(a.this.f405315f, str, true);
                    }
                }
            }
        }

        @Override // com.tencent.trtc.TRTCCloudListener
        public void onUserAudioAvailable(String str, boolean z16) {
            super.onUserAudioAvailable(str, z16);
            a.this.x(str);
        }

        @Override // com.tencent.trtc.TRTCCloudListener
        public void onUserVideoAvailable(String str, boolean z16) {
            super.onUserVideoAvailable(str, z16);
            for (fm4.e eVar : a.this.f405328s) {
                if (eVar != null) {
                    eVar.onUserVideoAvailable(str, z16);
                }
            }
        }

        @Override // com.tencent.trtc.TRTCCloudListener
        public void onUserVoiceVolume(ArrayList<TRTCCloudDef.TRTCVolumeInfo> arrayList, int i3) {
            super.onUserVoiceVolume(arrayList, i3);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes26.dex */
    public class d implements Observer<sn4.a> {
        d() {
        }

        @Override // androidx.lifecycle.Observer
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onChanged(sn4.a aVar) {
            if (a.this.f405326q != null) {
                a.this.f405326q.h(aVar);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes26.dex */
    public class e implements Observer<ConcurrentHashMap<String, Integer>> {
        e() {
        }

        @Override // androidx.lifecycle.Observer
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onChanged(ConcurrentHashMap<String, Integer> concurrentHashMap) {
            if (concurrentHashMap != null) {
                for (Map.Entry<String, Integer> entry : concurrentHashMap.entrySet()) {
                    try {
                    } catch (Exception e16) {
                        l.f("YoloRoomAudioLogic", e16.toString(), e16);
                    }
                    if (a.this.f405316g.equals(entry.getKey())) {
                        if (entry.getValue().intValue() <= 10) {
                            break;
                        }
                        ((g) mm4.b.b(g.class)).A(a.this.f405313d).p("LogIgnore mic level update " + entry.getValue());
                        break;
                    }
                    continue;
                }
            }
            if (a.this.f405326q != null) {
                a.this.f405326q.a(concurrentHashMap);
            }
            if (concurrentHashMap != null && concurrentHashMap.size() > 0) {
                a.this.H();
            }
        }
    }

    public a(YoloRoomOuterClass$YoloRoomInfo yoloRoomOuterClass$YoloRoomInfo) {
        int i3;
        this.f405311b = yoloRoomOuterClass$YoloRoomInfo;
        this.f405312c = yoloRoomOuterClass$YoloRoomInfo.room_type.get();
        long j3 = yoloRoomOuterClass$YoloRoomInfo.room_id.get();
        this.f405313d = j3;
        this.f405315f = l(j3);
        this.f405316g = ((ll4.a) mm4.b.b(ll4.a.class)).M3();
        if (yoloRoomOuterClass$YoloRoomInfo.game_data_info.common_game_data_info.qq_live_room_config.has()) {
            try {
                i3 = Integer.valueOf(yoloRoomOuterClass$YoloRoomInfo.game_data_info.common_game_data_info.qq_live_room_config.qq_live_room_id.get()).intValue();
            } catch (Exception e16) {
                l.f("YoloRoomAudioLogic", e16.toString(), e16);
                i3 = 0;
            }
            this.f405314e = new com.tencent.timi.game.trtc.roomservice.multipevoiceroom.a(1400515537, TimiGameQQTrtcUtil.f380000d, i3, this.f405316g);
            this.f405313d = i3;
            this.f405315f = this.f405314e.f380006c + "";
        }
        this.f405328s = new ArrayList();
        this.f405317h = f.u();
        l.i("YoloRoomAudioLogic", "yoloRoomType = " + this.f405312c + ", yoloRoomId = " + this.f405313d + ", selfUid = " + LogUtil.getSafePrintUin(this.f405316g) + ", audioRoomName = " + this.f405315f);
    }

    private void A() {
        this.f405317h.f(this.f405315f, this.f405327r);
        com.tencent.timi.game.trtc.roomservice.multipevoiceroom.d dVar = this.f405317h;
        String str = this.f405315f;
        c cVar = new c();
        this.f405327r = cVar;
        dVar.d(str, cVar);
    }

    private static void B(boolean z16, int i3) {
        rm4.a.h("room_mic_enable" + i3, z16);
    }

    private void F() {
        LiveData<sn4.a> liveData = this.f405318i;
        if (liveData != null) {
            liveData.removeObserver(this.f405319j);
        }
        MutableLiveData<ConcurrentHashMap<String, Integer>> mutableLiveData = this.f405320k;
        if (mutableLiveData != null) {
            mutableLiveData.removeObserver(this.f405321l);
        }
    }

    private void G() {
        MutableLiveData<sn4.a> mutableLiveData = this.f405322m;
        if (mutableLiveData != null) {
            mutableLiveData.removeObserver(this.f405323n);
        }
        MutableLiveData<ConcurrentHashMap<String, Integer>> mutableLiveData2 = this.f405324o;
        if (mutableLiveData2 != null) {
            mutableLiveData2.removeObserver(this.f405325p);
        }
    }

    public static String l(long j3) {
        return ServerEnv.b().toLowerCase() + "_" + j3;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void o(boolean z16) {
        boolean z17;
        if (z16 && u(this.f405312c)) {
            z17 = true;
        } else {
            z17 = false;
        }
        C(z17);
        D(true);
        this.f405317h.m(100);
        E(100);
        z();
    }

    public static boolean u(int i3) {
        return rm4.a.b("room_mic_enable" + i3, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void w(String str) {
        if (!TextUtils.isEmpty(str)) {
            for (fm4.e eVar : this.f405328s) {
                if (eVar != null) {
                    eVar.a(str);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void x(String str) {
        if (this.f405311b.game_data_info.common_game_data_info.qq_live_room_config.has()) {
            long j3 = this.f405311b.game_data_info.common_game_data_info.qq_live_room_config.live_uid.get();
            if (((ll4.a) mm4.b.b(ll4.a.class)).h() == j3) {
                if (str.equals(j3 + "")) {
                    this.f405317h.o(this.f405315f, str, true);
                }
            }
        }
    }

    private void z() {
        com.tencent.timi.game.trtc.roomservice.multipevoiceroom.e j3 = this.f405317h.j(this.f405315f);
        if (j3 != null) {
            this.f405318i = j3.m();
            this.f405320k = j3.l();
        }
        LiveData<sn4.a> liveData = this.f405318i;
        if (liveData != null) {
            d dVar = new d();
            this.f405319j = dVar;
            liveData.observeForever(dVar);
        }
        MutableLiveData<ConcurrentHashMap<String, Integer>> mutableLiveData = this.f405320k;
        if (mutableLiveData == null) {
            l.e("YoloRoomAudioLogic", "registerLiveData but memberMicLevelLD is null!");
            return;
        }
        e eVar = new e();
        this.f405321l = eVar;
        mutableLiveData.observeForever(eVar);
    }

    public void C(boolean z16) {
        if (z16) {
            this.f405317h.h(this.f405315f);
        } else {
            this.f405317h.b(this.f405315f);
        }
        if (z16 && !v()) {
            D(true);
        }
        B(z16, this.f405312c);
    }

    public void D(boolean z16) {
        l.i("YoloRoomAudioLogic", "setSpeakerEnable, " + z16);
        if (z16) {
            this.f405317h.c(this.f405315f);
        } else {
            this.f405317h.k(this.f405315f);
        }
        this.f405310a = z16;
    }

    public void E(int i3) {
        this.f405317h.g(this.f405315f, i3);
    }

    public void m() {
        l.i("YoloRoomAudioLogic", "destroy ");
        F();
        G();
    }

    public void n(boolean z16, p pVar) {
        l.h("YoloRoomAudioLogic", 1, "enterAudioRoom_" + this.f405315f);
        this.f405326q = pVar;
        this.f405317h.a(this.f405315f, this.f405316g, this.f405314e, this.f405312c, new C10455a());
        A();
        if (YoloVoiceChangeAlertUtil.c(q())) {
            this.f405317h.k(this.f405315f);
            YoloVoiceChangeAlertUtil.d(this.f405312c, new b(z16));
        } else {
            o(z16);
        }
    }

    public void p() {
        l.h("YoloRoomAudioLogic", 1, "exitAudioRoom_" + this.f405315f);
        this.f405317h.n(this.f405315f);
        this.f405317h.f(this.f405315f, this.f405327r);
        this.f405328s.clear();
    }

    public String q() {
        return this.f405315f;
    }

    public LiveData<Boolean> r() {
        com.tencent.timi.game.trtc.roomservice.multipevoiceroom.e j3 = this.f405317h.j(this.f405315f);
        if (j3 != null) {
            return j3.j();
        }
        return null;
    }

    public LiveData<Boolean> s() {
        com.tencent.timi.game.trtc.roomservice.multipevoiceroom.e j3 = this.f405317h.j(this.f405315f);
        if (j3 != null) {
            return j3.k();
        }
        return null;
    }

    public boolean t() {
        return this.f405317h.e(this.f405315f);
    }

    public boolean v() {
        if (this.f405317h.j(this.f405315f) != null) {
            return !r0.p();
        }
        return this.f405310a;
    }

    public void y(boolean z16) {
        l.i("YoloRoomAudioLogic", "opSpeakingSeat, isOn = " + z16);
        if (z16) {
            this.f405317h.l(this.f405315f);
        } else {
            this.f405317h.i(this.f405315f);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void H() {
    }
}

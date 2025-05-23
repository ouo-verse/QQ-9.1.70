package kg4;

import android.content.Context;
import android.os.Bundle;
import androidx.annotation.Nullable;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import com.tencent.mobileqq.qqlive.api.IQQLiveSDK;
import com.tencent.mobileqq.qqlive.api.anchor.room.IQQLiveAnchorRoom;
import com.tencent.mobileqq.qqlive.api.room.IAudienceRoom;
import com.tencent.mobileqq.qqlive.api.room.ILiveAudienceTPPlayerRoom;
import com.tencent.mobileqq.qqlive.api.room.ILiveRoom;
import com.tencent.mobileqq.qqlive.api.room.ILiveRoomMessage;
import com.tencent.mobileqq.qqlive.api.room.ITPPlayerVideoView;
import com.tencent.mobileqq.qqlive.data.anchor.camera.QQLiveAnchorStreamRecordType;
import com.tencent.mobileqq.qqlive.data.anchor.room.QQLiveAnchorRoomInfo;
import com.tencent.mobileqq.qqlive.data.room.BaseRoomInfo;
import com.tencent.mobileqq.qqlive.data.room.LiveInfo;
import com.tencent.mobileqq.qqlive.data.room.LiveRoomInfo;
import com.tencent.mobileqq.qqlive.data.room.realtime.EndPageRealTimeInfo;
import com.tencent.mobileqq.qqlive.data.user.LiveUserInfo;
import com.tencent.qphone.base.util.QLog;
import com.tencent.timi.game.api.live.LiveRoomExtraInfo;
import com.tencent.timi.game.utils.IResultListener;
import com.tencent.timi.game.utils.l;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import jg4.e;
import jg4.f;
import jg4.g;
import jg4.h;

/* compiled from: P */
/* loaded from: classes26.dex */
public class a implements jg4.b {

    /* renamed from: a, reason: collision with root package name */
    private Map<Long, List<Object>> f412318a = new HashMap();

    /* renamed from: b, reason: collision with root package name */
    private jg4.c f412319b = new d();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* renamed from: kg4.a$a, reason: collision with other inner class name */
    /* loaded from: classes26.dex */
    public class C10655a implements f {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ g f412320a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ QQLiveAnchorStreamRecordType f412321b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ boolean f412322c;

        /* compiled from: P */
        /* renamed from: kg4.a$a$a, reason: collision with other inner class name */
        /* loaded from: classes26.dex */
        class C10656a implements IResultListener<Boolean> {

            /* JADX INFO: Access modifiers changed from: package-private */
            /* compiled from: P */
            /* renamed from: kg4.a$a$a$a, reason: collision with other inner class name */
            /* loaded from: classes26.dex */
            public class C10657a implements Observer<Boolean> {

                /* renamed from: d, reason: collision with root package name */
                final /* synthetic */ LiveData f412325d;

                C10657a(LiveData liveData) {
                    this.f412325d = liveData;
                }

                @Override // androidx.lifecycle.Observer
                /* renamed from: a, reason: merged with bridge method [inline-methods] */
                public void onChanged(Boolean bool) {
                    if (bool.booleanValue()) {
                        lg4.b.E().v(vf4.a.b());
                        this.f412325d.removeObserver(this);
                    } else {
                        l.e("TgLiveTag_TgLiveRoomServiceImpl", "createRetLiveData onChanged false");
                    }
                }
            }

            C10656a() {
            }

            @Override // com.tencent.timi.game.utils.IResultListener
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public void onSuccess(Boolean bool) {
                g gVar = C10655a.this.f412320a;
                if (gVar != null) {
                    gVar.k(true);
                }
                lg4.b E = lg4.b.E();
                C10655a c10655a = C10655a.this;
                LiveData<Boolean> s16 = E.s(c10655a.f412321b, c10655a.f412322c, c10655a.f412320a);
                s16.observeForever(new C10657a(s16));
            }

            @Override // com.tencent.timi.game.utils.IResultListener
            public void onError(int i3, String str) {
                com.tencent.timi.game.ui.widget.f.c("\u6570\u636e\u83b7\u53d6\u5f02\u5e38\uff0c\u8bf7\u91cd\u8bd5");
                g gVar = C10655a.this.f412320a;
                if (gVar != null) {
                    gVar.k(false);
                    C10655a.this.f412320a.c(2, i3, str);
                }
            }
        }

        C10655a(g gVar, QQLiveAnchorStreamRecordType qQLiveAnchorStreamRecordType, boolean z16) {
            this.f412320a = gVar;
            this.f412321b = qQLiveAnchorStreamRecordType;
            this.f412322c = z16;
        }

        @Override // jg4.f
        public void a() {
            a.this.W1(new C10656a());
        }

        @Override // jg4.f
        public void b(String[] strArr) {
            g gVar = this.f412320a;
            if (gVar != null) {
                gVar.l(-1000, "\u9700\u8981\u786e\u8ba4\u6388\u6743\u624d\u80fd\u6b63\u5e38\u5f00\u64ad\u54e6");
                this.f412320a.c(1, -1000, "\u9700\u8981\u786e\u8ba4\u6388\u6743\u624d\u80fd\u6b63\u5e38\u5f00\u64ad\u54e6");
            }
        }

        @Override // jg4.f
        public void onError(int i3, String str) {
            g gVar = this.f412320a;
            if (gVar != null) {
                gVar.l(i3, str);
                this.f412320a.c(1, i3, str);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes26.dex */
    public class b implements f {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ g f412327a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ boolean f412328b;

        /* compiled from: P */
        /* renamed from: kg4.a$b$a, reason: collision with other inner class name */
        /* loaded from: classes26.dex */
        class C10658a implements IResultListener<Boolean> {
            C10658a() {
            }

            @Override // com.tencent.timi.game.utils.IResultListener
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public void onSuccess(Boolean bool) {
                g gVar = b.this.f412327a;
                if (gVar != null) {
                    gVar.k(true);
                }
                lg4.b E = lg4.b.E();
                QQLiveAnchorStreamRecordType qQLiveAnchorStreamRecordType = QQLiveAnchorStreamRecordType.THIRD_PUSH_BROADCAST;
                b bVar = b.this;
                E.s(qQLiveAnchorStreamRecordType, bVar.f412328b, bVar.f412327a);
                pg4.c.e(lg4.b.E().G());
            }

            @Override // com.tencent.timi.game.utils.IResultListener
            public void onError(int i3, String str) {
                com.tencent.timi.game.ui.widget.f.c("\u6570\u636e\u83b7\u53d6\u5f02\u5e38\uff0c\u8bf7\u91cd\u8bd5");
                g gVar = b.this.f412327a;
                if (gVar != null) {
                    gVar.k(false);
                    b.this.f412327a.c(2, i3, str);
                }
            }
        }

        b(g gVar, boolean z16) {
            this.f412327a = gVar;
            this.f412328b = z16;
        }

        @Override // jg4.f
        public void a() {
            a.this.W1(new C10658a());
        }

        @Override // jg4.f
        public void b(String[] strArr) {
            g gVar = this.f412327a;
            if (gVar != null) {
                gVar.l(-1000, "\u9700\u8981\u786e\u8ba4\u6388\u6743\u624d\u80fd\u6b63\u5e38\u5f00\u64ad\u54e6");
                this.f412327a.c(1, -1000, "\u9700\u8981\u786e\u8ba4\u6388\u6743\u624d\u80fd\u6b63\u5e38\u5f00\u64ad\u54e6");
            }
        }

        @Override // jg4.f
        public void onError(int i3, String str) {
            g gVar = this.f412327a;
            if (gVar != null) {
                gVar.l(i3, str);
                this.f412327a.c(1, i3, str);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes26.dex */
    class c implements IResultListener<Boolean> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ e f412331a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ long f412332b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ String f412333c;

        c(e eVar, long j3, String str) {
            this.f412331a = eVar;
            this.f412332b = j3;
            this.f412333c = str;
        }

        @Override // com.tencent.timi.game.utils.IResultListener
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onSuccess(Boolean bool) {
            e eVar = this.f412331a;
            if (eVar != null) {
                eVar.k(true);
            }
            lg4.b.E().S(this.f412332b, this.f412333c, this.f412331a);
        }

        @Override // com.tencent.timi.game.utils.IResultListener
        public void onError(int i3, String str) {
            com.tencent.timi.game.ui.widget.f.c("\u6570\u636e\u83b7\u53d6\u5f02\u5e38\uff0c\u8bf7\u91cd\u8bd5");
            e eVar = this.f412331a;
            if (eVar != null) {
                eVar.k(false);
                this.f412331a.c(2, i3, str);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes26.dex */
    class d implements jg4.c {
        d() {
        }

        @Override // jg4.c
        public boolean a() {
            return ((Boolean) ko4.b.a(pg4.d.b().d(), Boolean.FALSE)).booleanValue();
        }

        @Override // jg4.c
        public boolean b() {
            if (a.this.J3(0L) != null) {
                return true;
            }
            return false;
        }

        @Override // jg4.c
        public boolean c() {
            return ((Boolean) ko4.b.a(pg4.d.b().c(), Boolean.FALSE)).booleanValue();
        }

        @Override // jg4.c
        public LiveInfo d(long j3) {
            IAudienceRoom N = a.this.N(j3);
            if (N != null) {
                return N.getRoomLiveInfo();
            }
            return null;
        }
    }

    public static long N3(ILiveRoom iLiveRoom, long j3) {
        BaseRoomInfo roomInfo;
        if (iLiveRoom != null && (roomInfo = iLiveRoom.getRoomInfo()) != null) {
            return roomInfo.getRoomId();
        }
        return j3;
    }

    @Override // jg4.b
    public void F(long j3, List<Object> list) {
        this.f412318a.put(Long.valueOf(j3), list);
    }

    @Override // jg4.b
    public void F0(boolean z16, g gVar) {
        l.h("TgLiveTag_TgLiveRoomServiceImpl", 1, "ensureInitAnchorRoom - " + z16);
        qg4.g.g(QQLiveAnchorStreamRecordType.THIRD_PUSH_BROADCAST, new b(gVar, z16));
    }

    @Override // jg4.b
    public ITPPlayerVideoView G() {
        IAudienceRoom N = N(0L);
        if (!(N instanceof ILiveAudienceTPPlayerRoom)) {
            return null;
        }
        return ((ILiveAudienceTPPlayerRoom) N).getDisplayView();
    }

    @Override // jg4.b
    public boolean H(long j3) {
        jg4.c s16 = s();
        if (s16 != null && s16.c() && q(j3) != null) {
            return true;
        }
        return false;
    }

    @Override // jg4.b
    public void H0(long j3, String str, e eVar) {
        l.h("TgLiveTag_TgLiveRoomServiceImpl", 1, "anchorResumeLiveIfExist - " + j3 + " - " + str);
        W1(new c(eVar, j3, str));
    }

    @Override // jg4.b
    public void H2(jg4.d dVar) {
        mg4.c.g().n(dVar);
    }

    @Override // jg4.b
    public boolean I(long j3) {
        h n3 = n(j3);
        if (n3 != null && n3.getAnchorUid() == K().longValue()) {
            return true;
        }
        return false;
    }

    @Override // jg4.b
    public IQQLiveAnchorRoom J3(long j3) {
        IQQLiveAnchorRoom G = lg4.b.E().G();
        if (j3 > 0 && (G == null || N3(G, 0L) != j3)) {
            return null;
        }
        return G;
    }

    @Override // jg4.b
    public Long K() {
        LiveUserInfo selfUserInfo = getSelfUserInfo();
        if (selfUserInfo == null) {
            return 0L;
        }
        return Long.valueOf(selfUserInfo.uid);
    }

    @Override // jg4.b
    public IAudienceRoom N(long j3) {
        IAudienceRoom h16 = mg4.c.g().h();
        if (j3 > 0 && (h16 == null || N3(h16, 0L) != j3)) {
            return null;
        }
        return h16;
    }

    @Override // jg4.b
    @Nullable
    public jg4.d O0(long j3) {
        return mg4.c.g().j(j3);
    }

    public void W1(IResultListener<Boolean> iResultListener) {
        pg4.b.l().o(vf4.a.a(), iResultListener);
    }

    @Override // jg4.b
    public al4.a Y1(boolean z16) {
        if (z16) {
            return lg4.b.E().H();
        }
        return mg4.c.g().k();
    }

    @Override // jg4.b
    public List<Object> d(long j3) {
        return this.f412318a.get(Long.valueOf(j3));
    }

    @Override // jg4.b
    public IQQLiveSDK f() {
        return pg4.b.l().m();
    }

    @Override // jg4.b
    public void f2(LiveRoomExtraInfo liveRoomExtraInfo) {
        LiveInfo d16 = s().d(liveRoomExtraInfo.f376291d);
        if (d16 == null) {
            if (QLog.isColorLevel()) {
                QLog.d("TgLiveTag_TgLiveRoomServiceImpl", 2, "recordRoomExtraData liveInfo is null!");
            }
        } else {
            LiveRoomInfo liveRoomInfo = d16.roomInfo;
            if (liveRoomInfo != null) {
                if (liveRoomInfo.extData == null) {
                    liveRoomInfo.extData = new Bundle();
                }
                d16.roomInfo.extData.putParcelable("live_room_extra_data", liveRoomExtraInfo);
            }
        }
    }

    @Override // jg4.b
    @Nullable
    public LiveUserInfo getSelfUserInfo() {
        IQQLiveSDK f16 = f();
        if (f16 != null) {
            return f16.getLoginModule().getUserInfo();
        }
        return null;
    }

    @Override // jg4.b
    public ILiveRoomMessage k(long j3) {
        return z(j3);
    }

    @Override // jg4.b
    public h n(long j3) {
        QQLiveAnchorRoomInfo x16 = x(j3);
        if (x16 != null) {
            return new h(x16.userDta);
        }
        IAudienceRoom y16 = y(j3);
        if (y16 != null && y16.getRoomLiveInfo() != null && y16.getRoomLiveInfo().anchorInfo != null) {
            return new h(y16.getRoomLiveInfo().anchorInfo);
        }
        return null;
    }

    @Override // jg4.b
    public void p3(QQLiveAnchorStreamRecordType qQLiveAnchorStreamRecordType, boolean z16, g gVar) {
        l.h("TgLiveTag_TgLiveRoomServiceImpl", 1, "anchorStartLive - " + qQLiveAnchorStreamRecordType + " - " + z16);
        qg4.g.g(qQLiveAnchorStreamRecordType, new C10655a(gVar, qQLiveAnchorStreamRecordType, z16));
    }

    @Override // jg4.b
    public BaseRoomInfo q(long j3) {
        ILiveRoom z16 = z(j3);
        if (z16 != null) {
            return z16.getRoomInfo();
        }
        return null;
    }

    @Override // jg4.b
    public void r(long j3, IResultListener<EndPageRealTimeInfo> iResultListener) {
        l.i("TgLiveTag_TgLiveRoomServiceImpl", "audienceExitRoom - " + j3);
        mg4.c.g().c(j3, iResultListener);
        F(j3, Collections.emptyList());
    }

    @Override // jg4.b
    public jg4.c s() {
        return this.f412319b;
    }

    @Override // jg4.b
    public void v1(boolean z16) {
        lg4.b.E().T(z16);
    }

    @Override // jg4.b
    public QQLiveAnchorRoomInfo x(long j3) {
        IQQLiveAnchorRoom J3 = J3(j3);
        if (J3 != null) {
            return J3.getAnchorRoomInfo();
        }
        return null;
    }

    @Override // jg4.b
    public void x3(long j3, IResultListener<EndPageRealTimeInfo> iResultListener) {
        l.i("TgLiveTag_TgLiveRoomServiceImpl", "anchorStopLive");
        lg4.b.E().t(iResultListener);
        F(j3, Collections.emptyList());
    }

    @Override // jg4.b
    @Nullable
    public IAudienceRoom y(long j3) {
        IAudienceRoom N = N(j3);
        if (N != null && N3(N, 0L) == j3) {
            return N;
        }
        return mg4.c.g().f(j3);
    }

    @Override // jg4.b
    public void y2(QQLiveAnchorRoomInfo qQLiveAnchorRoomInfo) {
        l.h("TgLiveTag_TgLiveRoomServiceImpl", 1, "anchorReconnectRoom - " + qQLiveAnchorRoomInfo);
        lg4.b.E().w(qQLiveAnchorRoomInfo);
    }

    @Override // jg4.b
    public ILiveRoom z(long j3) {
        IAudienceRoom N = N(j3);
        if (N != null) {
            return N;
        }
        return J3(j3);
    }

    @Override // mm4.a
    public void o2() {
    }

    @Override // mm4.a
    public void init(Context context) {
    }
}

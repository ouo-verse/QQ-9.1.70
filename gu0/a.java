package gu0;

import android.content.Context;
import android.os.Bundle;
import androidx.annotation.Nullable;
import com.tencent.icgame.game.api.live.LiveRoomExtraInfo;
import com.tencent.icgame.game.utils.g;
import com.tencent.mobileqq.icgame.api.IQQLiveSDK;
import com.tencent.mobileqq.icgame.api.room.IAudienceRoom;
import com.tencent.mobileqq.icgame.api.room.ILiveAudienceTPPlayerRoom;
import com.tencent.mobileqq.icgame.api.room.ILiveRoom;
import com.tencent.mobileqq.icgame.api.room.ILiveRoomMessage;
import com.tencent.mobileqq.icgame.api.room.ILiveRoomOperation;
import com.tencent.mobileqq.icgame.api.room.ITPPlayerVideoView;
import com.tencent.mobileqq.icgame.api.room.IcgRoomPlayerConfig;
import com.tencent.mobileqq.icgame.data.anchor.room.QQLiveAnchorRoomInfo;
import com.tencent.mobileqq.icgame.data.room.LiveInfo;
import com.tencent.mobileqq.qqlive.data.room.BaseRoomInfo;
import com.tencent.mobileqq.qqlive.data.room.LiveRoomInfo;
import com.tencent.mobileqq.qqlive.data.room.realtime.EndPageRealTimeInfo;
import com.tencent.mobileqq.qqlive.data.user.LiveUserInfo;
import com.tencent.qphone.base.util.QLog;
import com.tencent.timi.game.utils.IResultListener;
import fu0.EnterRoomConfig;
import fu0.c;
import fu0.d;
import fu0.e;
import hu0.f;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import ko4.b;

/* compiled from: P */
/* loaded from: classes7.dex */
public class a implements c {

    /* renamed from: a, reason: collision with root package name */
    private Map<Long, List<Object>> f403351a = new HashMap();

    /* renamed from: b, reason: collision with root package name */
    private d f403352b = new C10395a();

    /* compiled from: P */
    /* renamed from: gu0.a$a, reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    class C10395a implements d {
        C10395a() {
        }

        @Override // fu0.d
        public boolean b() {
            return false;
        }

        @Override // fu0.d
        public boolean c() {
            return ((Boolean) b.a(mu0.c.b().c(), Boolean.FALSE)).booleanValue();
        }

        @Override // fu0.d
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

    @Override // fu0.c
    public ILiveRoomOperation A(long j3) {
        return z(j3);
    }

    @Override // fu0.c
    public IAudienceRoom E1(IcgRoomPlayerConfig icgRoomPlayerConfig) {
        return f.s().i(icgRoomPlayerConfig);
    }

    @Override // fu0.c
    public void F(long j3, List<Object> list) {
        this.f403351a.put(Long.valueOf(j3), list);
    }

    @Override // fu0.c
    public ITPPlayerVideoView G() {
        IAudienceRoom N = N(0L);
        if (!(N instanceof ILiveAudienceTPPlayerRoom)) {
            return null;
        }
        return ((ILiveAudienceTPPlayerRoom) N).getDisplayView();
    }

    @Override // fu0.c
    public boolean H(long j3) {
        d s16 = s();
        if (s16 != null && s16.c() && q(j3) != null) {
            return true;
        }
        return false;
    }

    @Override // fu0.c
    public boolean I(long j3) {
        e n3 = n(j3);
        if (n3 != null && n3.getAnchorUid() == K().longValue()) {
            return true;
        }
        return false;
    }

    @Override // fu0.c
    public Long K() {
        LiveUserInfo selfUserInfo = getSelfUserInfo();
        if (selfUserInfo == null) {
            return 0L;
        }
        return Long.valueOf(selfUserInfo.uid);
    }

    @Override // fu0.c
    @Nullable
    public IAudienceRoom K3(long j3) {
        return f.s().p(j3);
    }

    @Override // fu0.c
    public IAudienceRoom N(long j3) {
        IAudienceRoom r16 = f.s().r();
        if (j3 > 0 && (r16 == null || N3(r16, 0L) != j3)) {
            return null;
        }
        return r16;
    }

    @Override // fu0.c
    public void O1() {
        g.h("ICGameTgLiveTag_ICGameTgLiveRoomServiceImpl", "exitAndDestroy");
        mu0.a.k().j(null);
    }

    @Override // fu0.c
    public cx0.a S1() {
        return f.s().x();
    }

    @Override // fu0.c
    public void T0(long j3) {
        f.s().F(j3);
    }

    @Override // fu0.c
    public void U(long j3, boolean z16) {
        f.s().E(j3, z16);
    }

    @Override // fu0.c
    public void W1(IResultListener<Boolean> iResultListener) {
        mu0.a.k().n(bu0.a.a(), iResultListener);
    }

    @Override // fu0.c
    public long b3() {
        return f.s().t();
    }

    @Override // fu0.c
    public List<Object> d(long j3) {
        return this.f403351a.get(Long.valueOf(j3));
    }

    @Override // fu0.c
    public IQQLiveSDK f() {
        return mu0.a.k().l();
    }

    @Override // fu0.c
    public void g0(EnterRoomConfig enterRoomConfig, IcgRoomPlayerConfig icgRoomPlayerConfig, IResultListener<LiveInfo> iResultListener) {
        g.g("ICGameTgLiveTag_ICGameTgLiveRoomServiceImpl", 1, "audienceEnterRoom - " + enterRoomConfig.getRoomId());
        f.s().g(enterRoomConfig, icgRoomPlayerConfig, iResultListener);
    }

    @Override // fu0.c
    @Nullable
    public LiveUserInfo getSelfUserInfo() {
        IQQLiveSDK f16 = f();
        if (f16 != null) {
            return f16.getLoginModule().getUserInfo();
        }
        return null;
    }

    @Override // fu0.c
    public ILiveRoomMessage k(long j3) {
        return z(j3);
    }

    @Override // fu0.c
    public e n(long j3) {
        QQLiveAnchorRoomInfo x16 = x(j3);
        if (x16 != null) {
            return new e(x16.userDta);
        }
        IAudienceRoom y16 = y(j3);
        if (y16 != null && y16.getRoomLiveInfo() != null && y16.getRoomLiveInfo().anchorInfo != null) {
            return new e(y16.getRoomLiveInfo().anchorInfo);
        }
        return null;
    }

    @Override // fu0.c
    public BaseRoomInfo q(long j3) {
        ILiveRoom z16 = z(j3);
        if (z16 != null) {
            return z16.getRoomInfo();
        }
        return null;
    }

    @Override // fu0.c
    public void r(long j3, IResultListener<EndPageRealTimeInfo> iResultListener) {
        g.h("ICGameTgLiveTag_ICGameTgLiveRoomServiceImpl", "audienceExitRoom - " + j3);
        f.s().h(j3, iResultListener);
        F(j3, Collections.emptyList());
    }

    @Override // fu0.c
    public d s() {
        return this.f403352b;
    }

    @Override // fu0.c
    public QQLiveAnchorRoomInfo x(long j3) {
        return null;
    }

    @Override // fu0.c
    @Nullable
    public IAudienceRoom y(long j3) {
        IAudienceRoom N = N(j3);
        if (N != null && N3(N, 0L) == j3) {
            return N;
        }
        return f.s().p(j3);
    }

    @Override // fu0.c
    public void y0(LiveRoomExtraInfo liveRoomExtraInfo) {
        LiveInfo d16 = s().d(liveRoomExtraInfo.f114880d);
        if (d16 == null) {
            if (QLog.isColorLevel()) {
                QLog.d("ICGameTgLiveTag_ICGameTgLiveRoomServiceImpl", 2, "recordRoomExtraData liveInfo is null!");
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

    @Override // fu0.c
    public ILiveRoom z(long j3) {
        IAudienceRoom N = N(j3);
        if (N != null) {
            return N;
        }
        return null;
    }

    @Override // mm4.a
    public void o2() {
    }

    @Override // mm4.a
    public void init(Context context) {
    }
}

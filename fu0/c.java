package fu0;

import androidx.annotation.Nullable;
import com.tencent.icgame.game.api.live.LiveRoomExtraInfo;
import com.tencent.mobileqq.icgame.api.IQQLiveSDK;
import com.tencent.mobileqq.icgame.api.room.IAudienceRoom;
import com.tencent.mobileqq.icgame.api.room.ILiveRoom;
import com.tencent.mobileqq.icgame.api.room.ILiveRoomMessage;
import com.tencent.mobileqq.icgame.api.room.ILiveRoomOperation;
import com.tencent.mobileqq.icgame.api.room.ITPPlayerVideoView;
import com.tencent.mobileqq.icgame.api.room.IcgRoomPlayerConfig;
import com.tencent.mobileqq.icgame.data.anchor.room.QQLiveAnchorRoomInfo;
import com.tencent.mobileqq.icgame.data.room.LiveInfo;
import com.tencent.mobileqq.qqlive.data.room.BaseRoomInfo;
import com.tencent.mobileqq.qqlive.data.room.realtime.EndPageRealTimeInfo;
import com.tencent.mobileqq.qqlive.data.user.LiveUserInfo;
import com.tencent.timi.game.utils.IResultListener;
import java.util.List;

/* compiled from: P */
/* loaded from: classes7.dex */
public interface c extends mm4.a {
    @Nullable
    ILiveRoomOperation A(long j3);

    @Nullable
    IAudienceRoom E1(IcgRoomPlayerConfig icgRoomPlayerConfig);

    void F(long j3, List<Object> list);

    @Nullable
    ITPPlayerVideoView G();

    boolean H(long j3);

    boolean I(long j3);

    Long K();

    @Nullable
    IAudienceRoom K3(long j3);

    @Nullable
    IAudienceRoom N(long j3);

    void O1();

    cx0.a S1();

    void T0(long j3);

    void U(long j3, boolean z16);

    void W1(IResultListener<Boolean> iResultListener);

    long b3();

    List<Object> d(long j3);

    @Nullable
    IQQLiveSDK f();

    void g0(EnterRoomConfig enterRoomConfig, IcgRoomPlayerConfig icgRoomPlayerConfig, IResultListener<LiveInfo> iResultListener);

    @Nullable
    LiveUserInfo getSelfUserInfo();

    @Nullable
    ILiveRoomMessage k(long j3);

    @Nullable
    e n(long j3);

    @Nullable
    BaseRoomInfo q(long j3);

    void r(long j3, IResultListener<EndPageRealTimeInfo> iResultListener);

    d s();

    @Nullable
    QQLiveAnchorRoomInfo x(long j3);

    @Nullable
    IAudienceRoom y(long j3);

    void y0(LiveRoomExtraInfo liveRoomExtraInfo);

    @Nullable
    ILiveRoom z(long j3);
}

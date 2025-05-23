package jg4;

import androidx.annotation.Nullable;
import com.tencent.mobileqq.qqlive.api.IQQLiveSDK;
import com.tencent.mobileqq.qqlive.api.anchor.room.IQQLiveAnchorRoom;
import com.tencent.mobileqq.qqlive.api.room.IAudienceRoom;
import com.tencent.mobileqq.qqlive.api.room.ILiveRoom;
import com.tencent.mobileqq.qqlive.api.room.ILiveRoomMessage;
import com.tencent.mobileqq.qqlive.api.room.ITPPlayerVideoView;
import com.tencent.mobileqq.qqlive.data.anchor.camera.QQLiveAnchorStreamRecordType;
import com.tencent.mobileqq.qqlive.data.anchor.room.QQLiveAnchorRoomInfo;
import com.tencent.mobileqq.qqlive.data.room.BaseRoomInfo;
import com.tencent.mobileqq.qqlive.data.room.realtime.EndPageRealTimeInfo;
import com.tencent.mobileqq.qqlive.data.user.LiveUserInfo;
import com.tencent.timi.game.api.live.LiveRoomExtraInfo;
import com.tencent.timi.game.utils.IResultListener;
import java.util.List;

/* compiled from: P */
/* loaded from: classes26.dex */
public interface b extends mm4.a {
    void F(long j3, List<Object> list);

    void F0(boolean z16, g gVar);

    @Nullable
    ITPPlayerVideoView G();

    boolean H(long j3);

    void H0(long j3, String str, e eVar);

    void H2(d dVar);

    boolean I(long j3);

    @Nullable
    IQQLiveAnchorRoom J3(long j3);

    Long K();

    @Nullable
    IAudienceRoom N(long j3);

    @Nullable
    d O0(long j3);

    al4.a Y1(boolean z16);

    List<Object> d(long j3);

    @Nullable
    IQQLiveSDK f();

    void f2(LiveRoomExtraInfo liveRoomExtraInfo);

    @Nullable
    LiveUserInfo getSelfUserInfo();

    @Nullable
    ILiveRoomMessage k(long j3);

    @Nullable
    h n(long j3);

    void p3(QQLiveAnchorStreamRecordType qQLiveAnchorStreamRecordType, boolean z16, g gVar);

    @Nullable
    BaseRoomInfo q(long j3);

    void r(long j3, IResultListener<EndPageRealTimeInfo> iResultListener);

    c s();

    void v1(boolean z16);

    @Nullable
    QQLiveAnchorRoomInfo x(long j3);

    void x3(long j3, IResultListener<EndPageRealTimeInfo> iResultListener);

    @Nullable
    IAudienceRoom y(long j3);

    void y2(QQLiveAnchorRoomInfo qQLiveAnchorRoomInfo);

    @Nullable
    ILiveRoom z(long j3);
}

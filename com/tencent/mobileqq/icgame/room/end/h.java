package com.tencent.mobileqq.icgame.room.end;

import android.app.Activity;
import com.tencent.icgame.game.api.live.LiveRoomExtraInfo;
import com.tencent.mobileqq.icgame.api.IQQLiveSDK;
import com.tencent.mobileqq.icgame.api.IQQLiveUtil;
import com.tencent.mobileqq.icgame.api.end.IQQLiveEndView;
import com.tencent.mobileqq.icgame.api.message.IQQLiveFollowMsgService;
import com.tencent.mobileqq.icgame.data.QQLiveEndPageInfo;
import com.tencent.mobileqq.icgame.data.QQLiveEndRecommendInfo;
import com.tencent.mobileqq.icgame.data.record.QQLiveSwitchRoom;
import com.tencent.mobileqq.qqlive.callback.follow.IQQLiveCheckFollowCallback;
import com.tencent.mobileqq.qqlive.data.room.LiveAnchorInfo;
import com.tencent.mobileqq.qqlive.data.room.realtime.EndPageRealTimeInfo;
import com.tencent.mobileqq.qqlive.data.room.realtime.MetricsType;
import com.tencent.mobileqq.qqlive.data.room.realtime.RealTimeData;
import com.tencent.mobileqq.qqlive.data.user.LiveUserInfo;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt___RangesKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000r\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b&\u0010'JT\u0010\u0012\u001a\u0004\u0018\u00010\u00112\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\b\u0010\u0006\u001a\u0004\u0018\u00010\u00052\b\u0010\b\u001a\u0004\u0018\u00010\u00072\b\u0010\n\u001a\u0004\u0018\u00010\t2\b\u0010\f\u001a\u0004\u0018\u00010\u000b2\b\u0010\u000e\u001a\u0004\u0018\u00010\r2\u0006\u0010\u0010\u001a\u00020\u000fH\u0002Jr\u0010\u001e\u001a\u0004\u0018\u00010\u001d2\b\u0010\u0014\u001a\u0004\u0018\u00010\u00132\u0006\u0010\u0004\u001a\u00020\u00022\b\u0010\u0006\u001a\u0004\u0018\u00010\u00052\b\u0010\b\u001a\u0004\u0018\u00010\u00072\b\u0010\u0016\u001a\u0004\u0018\u00010\u00152\b\u0010\u0017\u001a\u0004\u0018\u00010\t2\b\u0010\u0018\u001a\u0004\u0018\u00010\u000b2\b\u0010\u000e\u001a\u0004\u0018\u00010\r2\u0006\u0010\u0010\u001a\u00020\u000f2\b\u0010\u001a\u001a\u0004\u0018\u00010\u00192\b\u0010\u001c\u001a\u0004\u0018\u00010\u001bJ\"\u0010\"\u001a\u00020!2\b\u0010\b\u001a\u0004\u0018\u00010\u00072\u0006\u0010\u001f\u001a\u00020\u00022\b\u0010\u001c\u001a\u0004\u0018\u00010 J\u001e\u0010%\u001a\b\u0012\u0004\u0012\u00020$0#2\b\u0010\b\u001a\u0004\u0018\u00010\u00072\u0006\u0010\u0004\u001a\u00020\u0002\u00a8\u0006("}, d2 = {"Lcom/tencent/mobileqq/icgame/room/end/h;", "", "", "selfUid", "roomId", "", "programId", "Lcom/tencent/mobileqq/icgame/api/IQQLiveSDK;", "liveSdk", "Lcom/tencent/mobileqq/qqlive/data/room/LiveAnchorInfo;", "anchorInfo", "Lcom/tencent/mobileqq/qqlive/data/room/realtime/EndPageRealTimeInfo;", "realTimeInfo", "Lcom/tencent/icgame/game/api/live/LiveRoomExtraInfo;", "extraInfo", "", "follow", "Lcom/tencent/mobileqq/icgame/data/QQLiveEndPageInfo;", "b", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "Lcom/tencent/mobileqq/qqlive/data/user/LiveUserInfo;", "liveUserInfo", "liveAnchorInfo", "liveRealTimeInfo", "Lau0/c;", "roomSwitcher", "Ls22/a;", "callback", "Lcom/tencent/mobileqq/icgame/api/end/IQQLiveEndView;", "a", "anchorUid", "Lcom/tencent/mobileqq/qqlive/callback/follow/IQQLiveCheckFollowCallback;", "", "c", "Ljava/util/ArrayList;", "Lcom/tencent/mobileqq/icgame/data/QQLiveEndRecommendInfo;", "d", "<init>", "()V", "ic-game-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes15.dex */
public final class h {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final h f237569a = new h();

    /* compiled from: P */
    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes15.dex */
    public /* synthetic */ class a {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f237570a;

        static {
            int[] iArr = new int[MetricsType.values().length];
            try {
                iArr[MetricsType.TOTAL_LIVE_TIME.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[MetricsType.CUMULATIVE_UV.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            f237570a = iArr;
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0018\u0010\t\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u0007H\u0016\u00a8\u0006\n"}, d2 = {"com/tencent/mobileqq/icgame/room/end/h$b", "Lcom/tencent/mobileqq/qqlive/callback/follow/IQQLiveCheckFollowCallback;", "", "isFollow", "", "onSuccess", "errCode", "", "errMsg", "onFail", "ic-game-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes15.dex */
    public static final class b implements IQQLiveCheckFollowCallback {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ IQQLiveCheckFollowCallback f237571a;

        b(IQQLiveCheckFollowCallback iQQLiveCheckFollowCallback) {
            this.f237571a = iQQLiveCheckFollowCallback;
        }

        @Override // com.tencent.mobileqq.qqlive.callback.follow.IQQLiveCheckFollowCallback
        public void onFail(int errCode, @NotNull String errMsg) {
            Intrinsics.checkNotNullParameter(errMsg, "errMsg");
            IQQLiveCheckFollowCallback iQQLiveCheckFollowCallback = this.f237571a;
            if (iQQLiveCheckFollowCallback != null) {
                iQQLiveCheckFollowCallback.onFail(errCode, errMsg);
            }
        }

        @Override // com.tencent.mobileqq.qqlive.callback.follow.IQQLiveCheckFollowCallback
        public void onSuccess(int isFollow) {
            IQQLiveCheckFollowCallback iQQLiveCheckFollowCallback = this.f237571a;
            if (iQQLiveCheckFollowCallback != null) {
                iQQLiveCheckFollowCallback.onSuccess(isFollow);
            }
        }
    }

    h() {
    }

    private final QQLiveEndPageInfo b(long selfUid, long roomId, String programId, IQQLiveSDK liveSdk, LiveAnchorInfo anchorInfo, EndPageRealTimeInfo realTimeInfo, LiveRoomExtraInfo extraInfo, int follow) {
        String str;
        String str2;
        long j3;
        String str3;
        String str4;
        List<RealTimeData> list;
        String str5;
        rt0.a.INSTANCE.j("ICGameAudience|ICGameLiveEndViewUtil", "audienceMakeQQLiveEndPageInfo");
        QQLiveEndPageInfo qQLiveEndPageInfo = new QQLiveEndPageInfo();
        qQLiveEndPageInfo.roomId = roomId;
        String str6 = "";
        if (programId == null) {
            programId = "";
        }
        qQLiveEndPageInfo.programId = programId;
        qQLiveEndPageInfo.liveType = 0;
        if (extraInfo == null || (str = Integer.valueOf(extraInfo.f114883h).toString()) == null) {
            str = "";
        }
        qQLiveEndPageInfo.liveContent = str;
        if (extraInfo == null || (str2 = Long.valueOf(extraInfo.f114885m).toString()) == null) {
            str2 = "";
        }
        qQLiveEndPageInfo.liveSource = str2;
        qQLiveEndPageInfo.uid = selfUid;
        if (anchorInfo != null) {
            j3 = anchorInfo.uid;
        } else {
            j3 = 0;
        }
        qQLiveEndPageInfo.anchorUid = j3;
        if (anchorInfo == null || (str3 = anchorInfo.headUrl) == null) {
            str3 = "";
        }
        qQLiveEndPageInfo.headIcon = str3;
        if (anchorInfo != null && (str5 = anchorInfo.nickName) != null) {
            str6 = str5;
        }
        qQLiveEndPageInfo.nick = str6;
        if (extraInfo != null) {
            str4 = extraInfo.C;
        } else {
            str4 = null;
        }
        qQLiveEndPageInfo.from = str4;
        qQLiveEndPageInfo.extraInfo = extraInfo;
        if (realTimeInfo != null && (list = realTimeInfo.items) != null) {
            for (RealTimeData realTimeData : list) {
                MetricsType type = realTimeData.type;
                if (type != null) {
                    Intrinsics.checkNotNullExpressionValue(type, "type");
                    int i3 = a.f237570a[type.ordinal()];
                    if (i3 != 1) {
                        if (i3 == 2) {
                            qQLiveEndPageInfo.popularity = String.valueOf(realTimeData.value);
                        }
                    } else {
                        qQLiveEndPageInfo.time = realTimeData.value;
                    }
                }
            }
        }
        qQLiveEndPageInfo.follow = follow;
        qQLiveEndPageInfo.recommendInfos = d(liveSdk, roomId);
        return qQLiveEndPageInfo;
    }

    @Nullable
    public final IQQLiveEndView a(@Nullable Activity activity, long roomId, @Nullable String programId, @Nullable IQQLiveSDK liveSdk, @Nullable LiveUserInfo liveUserInfo, @Nullable LiveAnchorInfo liveAnchorInfo, @Nullable EndPageRealTimeInfo liveRealTimeInfo, @Nullable LiveRoomExtraInfo extraInfo, int follow, @Nullable au0.c roomSwitcher, @Nullable s22.a callback) {
        long j3;
        rt0.a.INSTANCE.j("ICGameAudience|ICGameLiveEndViewUtil", "audienceCreateLiveEndView");
        if (activity != null && liveSdk != null) {
            if (liveUserInfo != null) {
                j3 = liveUserInfo.uid;
            } else {
                j3 = 0;
            }
            QQLiveEndPageInfo b16 = b(j3, roomId, programId, liveSdk, liveAnchorInfo, liveRealTimeInfo, extraInfo, follow);
            if (b16 != null) {
                return ((IQQLiveUtil) QRoute.api(IQQLiveUtil.class)).getAudienceEndLiveView(activity, liveSdk, b16, roomSwitcher, callback);
            }
        }
        return null;
    }

    public final void c(@Nullable IQQLiveSDK liveSdk, long anchorUid, @Nullable IQQLiveCheckFollowCallback callback) {
        IQQLiveFollowMsgService iQQLiveFollowMsgService;
        rt0.a.INSTANCE.j("ICGameAudience|ICGameLiveEndViewUtil", "checkFollowStatus");
        if (liveSdk != null) {
            iQQLiveFollowMsgService = liveSdk.getFollowMsgService();
        } else {
            iQQLiveFollowMsgService = null;
        }
        if (iQQLiveFollowMsgService != null) {
            iQQLiveFollowMsgService.checkFollowAnchor(anchorUid, new b(callback));
        } else if (callback != null) {
            callback.onFail(-1, "");
        }
    }

    @NotNull
    public final ArrayList<QQLiveEndRecommendInfo> d(@Nullable IQQLiveSDK liveSdk, long roomId) {
        List<QQLiveSwitchRoom> fetchRoomList;
        boolean z16;
        List<QQLiveSwitchRoom> list;
        int coerceAtMost;
        int coerceAtMost2;
        rt0.a.INSTANCE.j("ICGameAudience|ICGameLiveEndViewUtil", "getRecommendRoomList");
        ArrayList<QQLiveEndRecommendInfo> arrayList = new ArrayList<>();
        if (liveSdk != null && (fetchRoomList = liveSdk.getFetchRoomList()) != null) {
            if (fetchRoomList.size() > 0) {
                z16 = true;
            } else {
                z16 = false;
            }
            List<QQLiveSwitchRoom> list2 = null;
            if (!z16) {
                fetchRoomList = null;
            }
            if (fetchRoomList != null) {
                int size = fetchRoomList.size();
                int i3 = 0;
                while (true) {
                    if (i3 < size) {
                        if (roomId == fetchRoomList.get(i3).roomId) {
                            break;
                        }
                        i3++;
                    } else {
                        i3 = -1;
                        break;
                    }
                }
                if (i3 == -1) {
                    coerceAtMost2 = RangesKt___RangesKt.coerceAtMost(2, fetchRoomList.size());
                    list = fetchRoomList.subList(0, coerceAtMost2);
                } else if (i3 < fetchRoomList.size()) {
                    coerceAtMost = RangesKt___RangesKt.coerceAtMost(i3 + 3, fetchRoomList.size());
                    list = fetchRoomList.subList(i3 + 1, coerceAtMost);
                } else {
                    list = null;
                }
                if (list != null) {
                    if (!list.isEmpty()) {
                        list2 = list;
                    }
                    if (list2 != null) {
                        for (QQLiveSwitchRoom qQLiveSwitchRoom : list2) {
                            QQLiveEndRecommendInfo qQLiveEndRecommendInfo = new QQLiveEndRecommendInfo();
                            qQLiveEndRecommendInfo.roomId = qQLiveSwitchRoom.roomId;
                            qQLiveEndRecommendInfo.roomBg = qQLiveSwitchRoom.coverUrl;
                            qQLiveEndRecommendInfo.nick = qQLiveSwitchRoom.anchorNick;
                            Long l3 = qQLiveSwitchRoom.popularity;
                            Intrinsics.checkNotNullExpressionValue(l3, "roomInfo.popularity");
                            qQLiveEndRecommendInfo.popularity = l3.longValue();
                            qQLiveEndRecommendInfo.roomType = qQLiveSwitchRoom.roomType;
                            qQLiveEndRecommendInfo.roomTitle = qQLiveSwitchRoom.title;
                            qQLiveEndRecommendInfo.videoUrl = qQLiveSwitchRoom.videoUrl;
                            qQLiveEndRecommendInfo.videoId = qQLiveSwitchRoom.videoId;
                            qQLiveEndRecommendInfo.gameId = qQLiveSwitchRoom.gameId;
                            qQLiveEndRecommendInfo.gameTagId = qQLiveSwitchRoom.gameTagId;
                            qQLiveEndRecommendInfo.videoSource = qQLiveSwitchRoom.videoSource;
                            qQLiveEndRecommendInfo.rtmpUrl = qQLiveSwitchRoom.rtmpUrl;
                            qQLiveEndRecommendInfo.traceInfo = qQLiveSwitchRoom.traceInfo;
                            arrayList.add(qQLiveEndRecommendInfo);
                        }
                    }
                }
            }
        }
        return arrayList;
    }
}

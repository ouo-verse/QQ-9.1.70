package gw0;

import com.tencent.icgame.game.utils.k;
import com.tencent.mobileqq.icgame.api.IQQLiveSDK;
import com.tencent.mobileqq.icgame.api.end.IQQLiveEndView;
import com.tencent.mobileqq.icgame.data.QQLiveEndRecommendInfo;
import com.tencent.mobileqq.icgame.data.record.QQLiveSwitchRoom;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt___RangesKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0011\u0010\u0012J \u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0018\u0010\f\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\tH\u0002J\"\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u000e\u001a\u0004\u0018\u00010\r2\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u00a8\u0006\u0013"}, d2 = {"Lgw0/b;", "", "Lcom/tencent/mobileqq/icgame/api/IQQLiveSDK;", "liveSdk", "", "roomId", "Ljava/util/ArrayList;", "Lcom/tencent/mobileqq/icgame/data/QQLiveEndRecommendInfo;", "b", "", "totalSize", "index", "c", "Lcom/tencent/mobileqq/icgame/api/end/IQQLiveEndView;", "liveEndView", "", "d", "<init>", "()V", "ic-game-timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes7.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final b f403451a = new b();

    b() {
    }

    private final ArrayList<QQLiveEndRecommendInfo> b(IQQLiveSDK liveSdk, long roomId) {
        List<QQLiveSwitchRoom> fetchRoomList;
        boolean z16;
        List<QQLiveSwitchRoom> arrayList;
        int coerceAtMost;
        boolean z17;
        int coerceAtMost2;
        ArrayList<QQLiveEndRecommendInfo> arrayList2 = new ArrayList<>();
        if (liveSdk != null && (fetchRoomList = liveSdk.getFetchRoomList()) != null) {
            if (fetchRoomList.size() >= 2) {
                z16 = true;
            } else {
                z16 = false;
            }
            List<QQLiveSwitchRoom> list = null;
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
                int c16 = f403451a.c(fetchRoomList.size(), i3);
                int i16 = i3 + 1;
                if (c16 >= 4) {
                    coerceAtMost2 = RangesKt___RangesKt.coerceAtMost(i16 + 4, fetchRoomList.size());
                    arrayList = fetchRoomList.subList(i16, coerceAtMost2);
                } else if (c16 >= 2) {
                    coerceAtMost = RangesKt___RangesKt.coerceAtMost(i16 + 2, fetchRoomList.size());
                    arrayList = fetchRoomList.subList(i16, coerceAtMost);
                } else {
                    arrayList = new ArrayList<>();
                }
                if (!arrayList.isEmpty()) {
                    list = arrayList;
                }
                if (list != null) {
                    for (QQLiveSwitchRoom qQLiveSwitchRoom : list) {
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
                        if (qQLiveSwitchRoom.equipStatus == 1) {
                            z17 = true;
                        } else {
                            z17 = false;
                        }
                        qQLiveEndRecommendInfo.hasWeaponIcon = z17;
                        qQLiveEndRecommendInfo.headerUrl = qQLiveSwitchRoom.anchorHead;
                        arrayList2.add(qQLiveEndRecommendInfo);
                    }
                }
            }
        }
        return arrayList2;
    }

    private final int c(int totalSize, int index) {
        if (index >= 0) {
            return totalSize - (index + 1);
        }
        return totalSize;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void e(IQQLiveEndView iQQLiveEndView, IQQLiveSDK iQQLiveSDK, long j3) {
        if (iQQLiveEndView != null) {
            iQQLiveEndView.setRecommendList(f403451a.b(iQQLiveSDK, j3));
        }
    }

    public final void d(final long roomId, @Nullable final IQQLiveEndView liveEndView, @Nullable final IQQLiveSDK liveSdk) {
        k.b(new Runnable() { // from class: gw0.a
            @Override // java.lang.Runnable
            public final void run() {
                b.e(IQQLiveEndView.this, liveSdk, roomId);
            }
        });
    }
}

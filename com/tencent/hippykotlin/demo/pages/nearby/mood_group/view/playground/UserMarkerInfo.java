package com.tencent.hippykotlin.demo.pages.nearby.mood_group.view.playground;

import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import com.tencent.hippykotlin.demo.pages.activity.blind_box.jiguangshang.view.BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline1;
import com.tencent.hippykotlin.demo.pages.activity.blind_box.jiguangshang.view.BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2;
import com.tencent.hippykotlin.demo.pages.nearby.base.data.UserDataManager;
import com.tencent.hippykotlin.demo.pages.nearby.compose_base.geometry.Point;
import com.tencent.hippykotlin.demo.pages.nearby.mood_group.data.NBPMoodGroupConfig;
import com.tencent.hippykotlin.demo.pages.nearby.mood_group.vm.NBPMoodGroupReportViewModel;
import com.tencent.kuikly.core.timer.TimerKt;
import h35.a;
import java.util.Iterator;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import w25.g;

/* compiled from: P */
/* loaded from: classes31.dex */
public final class UserMarkerInfo {
    public final NBPMoodGroupConfig.BarrageConfig barrageConfig;
    public String barrageTimeoutHandle;
    public final int boomEffectAwayTime;
    public final MutableState boomEffectOffset$delegate;
    public final int boomEffectResetTime;
    public String boomEffectResetTimeoutHandle;
    public final Point containerPos;
    public final MutableState currentAnimation$delegate;
    public final MutableState currentBarrage$delegate;
    public final boolean isNewAdd;
    public final Point markerCenterPos;
    public final NBPMoodGroupConfig.UserMarkerConfig markerConfig;
    public final Point markerTopCenterPos;
    public final g user;

    public UserMarkerInfo(g gVar, NBPMoodGroupConfig.UserMarkerConfig userMarkerConfig, NBPMoodGroupConfig.BarrageConfig barrageConfig, Point point, boolean z16) {
        MutableState mutableStateOf$default;
        MutableState mutableStateOf$default2;
        MutableState mutableStateOf$default3;
        this.user = gVar;
        this.markerConfig = userMarkerConfig;
        this.barrageConfig = barrageConfig;
        this.markerCenterPos = point;
        this.isNewAdd = z16;
        this.containerPos = new Point(point.getX() - (userMarkerConfig.getContainerSize().getWidth() / 2.0f), point.getY() - (userMarkerConfig.getContainerSize().getHeight() - (userMarkerConfig.getMarkerSize().getHeight() / 2.0f)));
        this.markerTopCenterPos = new Point(point.getX(), point.getY() - (userMarkerConfig.getMarkerSize().getHeight() / 2.0f));
        mutableStateOf$default = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(null, null, 2, null);
        this.currentAnimation$delegate = mutableStateOf$default;
        mutableStateOf$default2 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(null, null, 2, null);
        this.currentBarrage$delegate = mutableStateOf$default2;
        mutableStateOf$default3 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(null, null, 2, null);
        this.boomEffectOffset$delegate = mutableStateOf$default3;
        this.boomEffectAwayTime = 100;
        this.boomEffectResetTime = 200;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final int hashCode() {
        int hashCode = (this.markerCenterPos.hashCode() + ((this.barrageConfig.hashCode() + ((this.markerConfig.hashCode() + (this.user.hashCode() * 31)) * 31)) * 31)) * 31;
        boolean z16 = this.isNewAdd;
        int i3 = z16;
        if (z16 != 0) {
            i3 = 1;
        }
        return hashCode + i3;
    }

    public final boolean isHost() {
        return UserDataManager.INSTANCE.isHostTid(Long.valueOf(this.user.f444488d));
    }

    public final String toString() {
        StringBuilder m3 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("UserMarkerInfo(user=");
        m3.append(this.user);
        m3.append(", markerConfig=");
        m3.append(this.markerConfig);
        m3.append(", barrageConfig=");
        m3.append(this.barrageConfig);
        m3.append(", markerCenterPos=");
        m3.append(this.markerCenterPos);
        m3.append(", isNewAdd=");
        return BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline1.m(m3, this.isNewAdd, ')');
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof UserMarkerInfo)) {
            return false;
        }
        UserMarkerInfo userMarkerInfo = (UserMarkerInfo) obj;
        return Intrinsics.areEqual(this.user, userMarkerInfo.user) && Intrinsics.areEqual(this.markerConfig, userMarkerInfo.markerConfig) && Intrinsics.areEqual(this.barrageConfig, userMarkerInfo.barrageConfig) && Intrinsics.areEqual(this.markerCenterPos, userMarkerInfo.markerCenterPos) && this.isNewAdd == userMarkerInfo.isNewAdd;
    }

    public final void showBarrage(final NBPMoodGroupReportViewModel nBPMoodGroupReportViewModel, a aVar, final NBPMoodGroupConfig.BubbleConfig bubbleConfig) {
        Object obj;
        long j3 = this.user.f444488d;
        long j16 = aVar.f404269e;
        boolean z16 = j3 == j16;
        final boolean isHostTid = UserDataManager.INSTANCE.isHostTid(Long.valueOf(j16));
        if (z16) {
            Iterator<T> it = this.barrageConfig.items.iterator();
            while (true) {
                if (!it.hasNext()) {
                    obj = null;
                    break;
                } else {
                    obj = it.next();
                    if (Intrinsics.areEqual(((NBPMoodGroupConfig.BarrageItemConfig) obj).f114228id, String.valueOf(aVar.f404271h))) {
                        break;
                    }
                }
            }
            NBPMoodGroupConfig.BarrageItemConfig barrageItemConfig = (NBPMoodGroupConfig.BarrageItemConfig) obj;
            final NBPMoodGroupConfig.BarrageReplyInteractionConfig barrageReplyInteractionConfig = barrageItemConfig != null ? barrageItemConfig.replyInteraction : null;
            final a aVar2 = new a(aVar.f404268d, aVar.f404269e, aVar.f404270f, aVar.f404271h, aVar.f404272i);
            String str = this.barrageTimeoutHandle;
            if (str != null) {
                TimerKt.b(str);
            }
            TimerKt.d(50, new Function0<Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.mood_group.view.playground.UserMarkerInfo$showBarrage$2
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public final Unit invoke() {
                    NBPMoodGroupConfig.BubbleConfig bubbleConfig2 = NBPMoodGroupConfig.BubbleConfig.this;
                    if (bubbleConfig2 == null) {
                        if (isHostTid) {
                            bubbleConfig2 = this.markerConfig.hostNormalBubbleConfig;
                        } else if (barrageReplyInteractionConfig != null) {
                            nBPMoodGroupReportViewModel.dtReportElementImp("em_nearby_emotion_bubble", null);
                            bubbleConfig2 = this.markerConfig.replyBubbleConfig;
                        } else {
                            bubbleConfig2 = this.markerConfig.guestNormalBubbleConfig;
                        }
                    }
                    final UserMarkerInfo userMarkerInfo = this;
                    BarrageDisplayInfo barrageDisplayInfo = new BarrageDisplayInfo(aVar2, bubbleConfig2, barrageReplyInteractionConfig);
                    int i3 = bubbleConfig2.displayTime;
                    if (i3 > 0) {
                        userMarkerInfo.barrageTimeoutHandle = TimerKt.d(i3, new Function0<Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.mood_group.view.playground.UserMarkerInfo$showBarrage$2$1$1
                            {
                                super(0);
                            }

                            @Override // kotlin.jvm.functions.Function0
                            public final Unit invoke() {
                                UserMarkerInfo userMarkerInfo2 = UserMarkerInfo.this;
                                userMarkerInfo2.barrageTimeoutHandle = null;
                                userMarkerInfo2.currentBarrage$delegate.setValue(null);
                                return Unit.INSTANCE;
                            }
                        });
                    }
                    userMarkerInfo.currentBarrage$delegate.setValue(barrageDisplayInfo);
                    return Unit.INSTANCE;
                }
            });
        }
    }
}

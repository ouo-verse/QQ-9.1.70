package com.tencent.robot.adelie.homepage.eventbus;

import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;
import t14.f;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0011\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u00a2\u0006\u0004\b\u0007\u0010\bR\u0019\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\u00a8\u0006\t"}, d2 = {"Lcom/tencent/robot/adelie/homepage/eventbus/AdelieNewOrOldGuideEvent;", "Lcom/tencent/biz/richframework/eventbus/SimpleBaseEvent;", "Lt14/f;", "bannerRobotGuideInfo", "Lt14/f;", "getBannerRobotGuideInfo", "()Lt14/f;", "<init>", "(Lt14/f;)V", "robot-business-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes25.dex */
public final class AdelieNewOrOldGuideEvent extends SimpleBaseEvent {

    @Nullable
    private final f bannerRobotGuideInfo;

    public AdelieNewOrOldGuideEvent(@Nullable f fVar) {
        this.bannerRobotGuideInfo = fVar;
    }

    @Nullable
    public final f getBannerRobotGuideInfo() {
        return this.bannerRobotGuideInfo;
    }
}

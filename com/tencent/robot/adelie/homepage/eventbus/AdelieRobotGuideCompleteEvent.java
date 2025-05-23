package com.tencent.robot.adelie.homepage.eventbus;

import android.graphics.Rect;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.qqmini.miniapp.widget.CanvasView;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import t14.f;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\b\u001a\u00020\u0007\u00a2\u0006\u0004\b\f\u0010\rR\u0017\u0010\u0003\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0017\u0010\b\u001a\u00020\u00078\u0006\u00a2\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000b\u00a8\u0006\u000e"}, d2 = {"Lcom/tencent/robot/adelie/homepage/eventbus/AdelieRobotGuideCompleteEvent;", "Lcom/tencent/biz/richframework/eventbus/SimpleBaseEvent;", "Landroid/graphics/Rect;", CanvasView.ACTION_RECT, "Landroid/graphics/Rect;", "getRect", "()Landroid/graphics/Rect;", "Lt14/f;", "bannerRobotGuideInfo", "Lt14/f;", "getBannerRobotGuideInfo", "()Lt14/f;", "<init>", "(Landroid/graphics/Rect;Lt14/f;)V", "robot-business-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes25.dex */
public final class AdelieRobotGuideCompleteEvent extends SimpleBaseEvent {

    @NotNull
    private final f bannerRobotGuideInfo;

    @NotNull
    private final Rect rect;

    public AdelieRobotGuideCompleteEvent(@NotNull Rect rect, @NotNull f bannerRobotGuideInfo) {
        Intrinsics.checkNotNullParameter(rect, "rect");
        Intrinsics.checkNotNullParameter(bannerRobotGuideInfo, "bannerRobotGuideInfo");
        this.rect = rect;
        this.bannerRobotGuideInfo = bannerRobotGuideInfo;
    }

    @NotNull
    public final f getBannerRobotGuideInfo() {
        return this.bannerRobotGuideInfo;
    }

    @NotNull
    public final Rect getRect() {
        return this.rect;
    }
}

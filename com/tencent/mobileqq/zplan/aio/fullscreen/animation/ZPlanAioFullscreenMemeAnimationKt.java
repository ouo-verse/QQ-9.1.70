package com.tencent.mobileqq.zplan.aio.fullscreen.animation;

import com.tencent.mobileqq.zplan.aio.fullscreen.stage.a;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u001a$\u0010\u0007\u001a\u00020\u0006*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u0004H\u0007\u00a8\u0006\b"}, d2 = {"Lcom/tencent/mobileqq/zplan/aio/fullscreen/stage/a;", "", "bubbleItemHeight", "stageViewHeight", "", "removed", "", "setFooterHeight", "zplan_impl_release"}, k = 2, mv = {1, 7, 1})
/* loaded from: classes35.dex */
public final class ZPlanAioFullscreenMemeAnimationKt {
    public static final void setFooterHeight(a aVar, int i3, int i16, boolean z16) {
        Intrinsics.checkNotNullParameter(aVar, "<this>");
        if (z16) {
            return;
        }
        if (i3 <= i16) {
            i3 = i16 - i3;
        }
        aVar.a(i3);
    }
}

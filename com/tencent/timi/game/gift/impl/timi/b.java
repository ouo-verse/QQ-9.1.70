package com.tencent.timi.game.gift.impl.timi;

import android.app.Activity;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.timi.game.gift.impl.event.GiftPanelControlEvent;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import trpc.yes.common.CommonOuterClass$QQUserId;

/* compiled from: P */
@Metadata(d1 = {"\u0000 \n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u001a&\u0010\t\u001a\u00020\b2\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006\u00a8\u0006\n"}, d2 = {"", "roomId", "Ltrpc/yes/common/CommonOuterClass$QQUserId;", "certainUid", "", "subSceneId", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "", "a", "timi-game-impl_release"}, k = 2, mv = {1, 7, 1})
/* loaded from: classes26.dex */
public final class b {
    public static final void a(long j3, @NotNull CommonOuterClass$QQUserId certainUid, @NotNull String subSceneId, @NotNull Activity activity) {
        Intrinsics.checkNotNullParameter(certainUid, "certainUid");
        Intrinsics.checkNotNullParameter(subSceneId, "subSceneId");
        Intrinsics.checkNotNullParameter(activity, "activity");
        SimpleEventBus.getInstance().dispatchEvent(new GiftPanelControlEvent(true, 0, certainUid, Long.valueOf(j3), subSceneId));
    }
}

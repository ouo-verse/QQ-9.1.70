package com.tencent.mobileqq.guild.feed.squarehead.noticebubble;

import com.tencent.qqnt.kernelgpro.nativeinterface.GuildInteractiveNotificationItem;
import com.tencent.richframework.data.base.UIStateData;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes13.dex */
/* synthetic */ class GuildFeedSquareNoticeBubblePart$onInitView$2 extends FunctionReferenceImpl implements Function1<UIStateData<GuildInteractiveNotificationItem>, Unit> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public GuildFeedSquareNoticeBubblePart$onInitView$2(Object obj) {
        super(1, obj, GuildFeedSquareNoticeBubblePart.class, "handleNoticeBubbleUiStatus", "handleNoticeBubbleUiStatus(Lcom/tencent/richframework/data/base/UIStateData;)V", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(UIStateData<GuildInteractiveNotificationItem> uIStateData) {
        invoke2(uIStateData);
        return Unit.INSTANCE;
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(@NotNull UIStateData<GuildInteractiveNotificationItem> p06) {
        Intrinsics.checkNotNullParameter(p06, "p0");
        ((GuildFeedSquareNoticeBubblePart) this.receiver).C9(p06);
    }
}

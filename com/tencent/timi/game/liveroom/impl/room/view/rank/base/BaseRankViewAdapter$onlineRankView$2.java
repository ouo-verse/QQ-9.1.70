package com.tencent.timi.game.liveroom.impl.room.view.rank.base;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import com.tencent.mobileqq.qqlive.data.user.LiveUserInfo;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.timi.game.liveroom.impl.room.view.rank.OnlineRankView;
import com.tencent.timi.game.liveroom.impl.room.view.rank.RankViewModel;
import kk4.a;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n\u00a2\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Lcom/tencent/timi/game/liveroom/impl/room/view/rank/OnlineRankView;", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes26.dex */
public final class BaseRankViewAdapter$onlineRankView$2 extends Lambda implements Function0<OnlineRankView> {
    final /* synthetic */ BaseRankViewAdapter this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BaseRankViewAdapter$onlineRankView$2(BaseRankViewAdapter baseRankViewAdapter) {
        super(0);
        this.this$0 = baseRankViewAdapter;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void c(View view, Context context, long j3, long j16, LiveUserInfo liveUserInfo, int i3) {
        if (com.tencent.timi.game.liveroom.impl.room.manager.e.INSTANCE.a().g(j3, liveUserInfo.uid, j16)) {
            gt3.a.b(gt3.a.INSTANCE.a(), "\u56e0\u4e3b\u64ad\u8bbe\u7f6e\u6682\u4e0d\u652f\u6301\u67e5\u770b\u4e2a\u4eba\u4fe1\u606f", 0, null, 6, null);
            return;
        }
        a.Companion companion = kk4.a.INSTANCE;
        Intrinsics.checkNotNullExpressionValue(context, "context");
        Intrinsics.checkNotNullExpressionValue(liveUserInfo, "liveUserInfo");
        a.Companion.j(companion, context, j16, liveUserInfo, i3, false, 16, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void d(OnlineRankView view, boolean z16) {
        Intrinsics.checkNotNullParameter(view, "$view");
        view.b(z16);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    @NotNull
    public final OnlineRankView invoke() {
        Activity activity;
        Context context;
        c cVar;
        c cVar2;
        c cVar3;
        activity = this.this$0.com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY java.lang.String;
        if (activity == null) {
            Intrinsics.throwUninitializedPropertyAccessException(WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY);
            activity = null;
        }
        Activity activity2 = activity;
        context = this.this$0.context;
        cVar = this.this$0.baseRankViewModel;
        long roomId = cVar != null ? cVar.getRoomId() : 0L;
        cVar2 = this.this$0.baseRankViewModel;
        final OnlineRankView onlineRankView = new OnlineRankView(activity2, context, roomId, cVar2 != null ? cVar2.getAnchorId() : 0L);
        BaseRankViewAdapter baseRankViewAdapter = this.this$0;
        onlineRankView.setOnLineRankListItemListener(new com.tencent.timi.game.liveroom.impl.room.view.rank.b() { // from class: com.tencent.timi.game.liveroom.impl.room.view.rank.base.a
            @Override // com.tencent.timi.game.liveroom.impl.room.view.rank.b
            public final void a(View view, Context context2, long j3, long j16, LiveUserInfo liveUserInfo, int i3) {
                BaseRankViewAdapter$onlineRankView$2.c(view, context2, j3, j16, liveUserInfo, i3);
            }
        });
        cVar3 = baseRankViewAdapter.baseRankViewModel;
        if (cVar3 != null) {
            cVar3.q(new RankViewModel.a() { // from class: com.tencent.timi.game.liveroom.impl.room.view.rank.base.b
                @Override // com.tencent.timi.game.liveroom.impl.room.view.rank.RankViewModel.a
                public final void show(boolean z16) {
                    BaseRankViewAdapter$onlineRankView$2.d(OnlineRankView.this, z16);
                }
            });
        }
        return onlineRankView;
    }
}

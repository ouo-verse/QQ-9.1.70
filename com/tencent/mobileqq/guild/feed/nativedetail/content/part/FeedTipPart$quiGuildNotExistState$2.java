package com.tencent.mobileqq.guild.feed.nativedetail.content.part;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.guild.component.GuildQUIEmptyState;
import com.tencent.mobileqq.guild.jump.GuildJumpUtil;
import com.tencent.mobileqq.guild.jump.model.JumpGuildParam;
import com.tencent.mobileqq.guild.util.GuildSplitViewUtils;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n\u00a2\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Lcom/tencent/mobileqq/guild/component/GuildQUIEmptyState;", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes13.dex */
final class FeedTipPart$quiGuildNotExistState$2 extends Lambda implements Function0<GuildQUIEmptyState> {
    final /* synthetic */ FeedTipPart this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FeedTipPart$quiGuildNotExistState$2(FeedTipPart feedTipPart) {
        super(0);
        this.this$0 = feedTipPart;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(FeedTipPart this$0, View view) {
        Activity activity;
        String str;
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        JumpGuildParam.JoinInfoParam joinInfoParam = (JumpGuildParam.JoinInfoParam) GuildSplitViewUtils.f235370a.h(this$0.getPartHost()).getParcelable("join_info_param");
        Context context = this$0.getContext();
        String str2 = null;
        if (context instanceof Activity) {
            activity = (Activity) context;
        } else {
            activity = null;
        }
        if (joinInfoParam != null) {
            str = joinInfoParam.getMainSource();
        } else {
            str = null;
        }
        if (joinInfoParam != null) {
            str2 = joinInfoParam.getSubSource();
        }
        GuildJumpUtil.w(activity, "mqqguild://guild/jumpToRecommendPage?mainSourceId=" + str + "&subSourceId=" + str2 + "&categoryConfId=0");
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    @NotNull
    public final GuildQUIEmptyState invoke() {
        GuildQUIEmptyState.a aVar = new GuildQUIEmptyState.a(this.this$0.getContext());
        final FeedTipPart feedTipPart = this.this$0;
        aVar.s(1);
        String string = feedTipPart.getContext().getString(R.string.f15127179);
        Intrinsics.checkNotNullExpressionValue(string, "context.getString(R.string.guild_not_exist)");
        aVar.u(string);
        aVar.n(false);
        aVar.p("\u53d1\u73b0\u66f4\u591a\u9891\u9053", new View.OnClickListener() { // from class: com.tencent.mobileqq.guild.feed.nativedetail.content.part.y
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                FeedTipPart$quiGuildNotExistState$2.b(FeedTipPart.this, view);
            }
        });
        return aVar.a();
    }
}

package com.tencent.mobileqq.guild.discovery.guildblockdetail.newrecommend;

import com.tencent.biz.richframework.part.block.BlockContainer;
import com.tencent.mobileqq.guild.discovery.guildblockdetail.GuildRecommendDetailViewModel;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n\u00a2\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Lcom/tencent/mobileqq/guild/discovery/guildblockdetail/GuildRecommendDetailViewModel$b;", "kotlin.jvm.PlatformType", "it", "", "invoke", "(Lcom/tencent/mobileqq/guild/discovery/guildblockdetail/GuildRecommendDetailViewModel$b;)V", "<anonymous>"}, k = 3, mv = {1, 7, 1})
/* loaded from: classes13.dex */
final class GuildRecommendContent$onInitView$2 extends Lambda implements Function1<GuildRecommendDetailViewModel.DiscoverRecommendDetailRsp, Unit> {
    final /* synthetic */ GuildRecommendContent this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GuildRecommendContent$onInitView$2(GuildRecommendContent guildRecommendContent) {
        super(1);
        this.this$0 = guildRecommendContent;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(GuildRecommendContent this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.getBlockContainer().getRecyclerView().setVisibility(0);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(GuildRecommendDetailViewModel.DiscoverRecommendDetailRsp discoverRecommendDetailRsp) {
        invoke2(discoverRecommendDetailRsp);
        return Unit.INSTANCE;
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(GuildRecommendDetailViewModel.DiscoverRecommendDetailRsp discoverRecommendDetailRsp) {
        ih1.a B9;
        ih1.a B92;
        B9 = this.this$0.B9();
        B9.setItems(discoverRecommendDetailRsp.d());
        B92 = this.this$0.B9();
        B92.notifyLoadingComplete(true, discoverRecommendDetailRsp.getData().getIsEnd());
        BlockContainer blockContainer = this.this$0.getBlockContainer();
        final GuildRecommendContent guildRecommendContent = this.this$0;
        blockContainer.post(new Runnable() { // from class: com.tencent.mobileqq.guild.discovery.guildblockdetail.newrecommend.d
            @Override // java.lang.Runnable
            public final void run() {
                GuildRecommendContent$onInitView$2.b(GuildRecommendContent.this);
            }
        });
    }
}

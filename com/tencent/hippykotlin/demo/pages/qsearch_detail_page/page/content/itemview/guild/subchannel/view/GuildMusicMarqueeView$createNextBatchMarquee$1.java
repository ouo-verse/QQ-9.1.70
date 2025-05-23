package com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.itemview.guild.subchannel.view;

import com.tencent.kuikly.core.base.ViewContainer;
import com.tencent.kuikly.core.views.t;
import com.tencent.kuikly.core.views.v;
import com.tencent.kuikly.core.views.w;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* compiled from: P */
/* loaded from: classes32.dex */
public final class GuildMusicMarqueeView$createNextBatchMarquee$1 extends Lambda implements Function1<ViewContainer<?, ?>, Unit> {
    public final /* synthetic */ GuildMusicMarqueeView $ctx;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GuildMusicMarqueeView$createNextBatchMarquee$1(GuildMusicMarqueeView guildMusicMarqueeView) {
        super(1);
        this.$ctx = guildMusicMarqueeView;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Unit invoke(ViewContainer<?, ?> viewContainer) {
        ViewContainer<?, ?> viewContainer2 = viewContainer;
        int i3 = 0;
        if (GuildMusicMarqueeView.access$getAttr(this.$ctx).getMarqueeItemListCount$qecommerce_biz_release().invoke().intValue() < GuildMusicMarqueeView.access$getAttr(this.$ctx).maxMarqueeEachBatch) {
            int i16 = GuildMusicMarqueeView.access$getAttr(this.$ctx).maxMarqueeEachBatch;
            while (i3 < i16) {
                GuildMusicMarqueeView guildMusicMarqueeView = this.$ctx;
                guildMusicMarqueeView.currentIndex = (guildMusicMarqueeView.currentIndex + 1) % GuildMusicMarqueeView.access$getAttr(guildMusicMarqueeView).maxMarqueeEachBatch;
                GuildMusicMarqueeView guildMusicMarqueeView2 = this.$ctx;
                if (guildMusicMarqueeView2.currentIndex < GuildMusicMarqueeView.access$getAttr(guildMusicMarqueeView2).getMarqueeItemListCount$qecommerce_biz_release().invoke().intValue()) {
                    Function2<? super ViewContainer<?, ?>, ? super Integer, Unit> function2 = GuildMusicMarqueeView.access$getAttr(this.$ctx).marqueeItemViewCreator;
                    if (function2 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("marqueeItemViewCreator");
                        function2 = null;
                    }
                    function2.invoke(viewContainer2, Integer.valueOf(this.$ctx.currentIndex));
                } else {
                    final GuildMusicMarqueeView guildMusicMarqueeView3 = this.$ctx;
                    w.a(viewContainer2, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.itemview.guild.subchannel.view.GuildMusicMarqueeView$createNextBatchMarquee$1.1
                        {
                            super(1);
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public final Unit invoke(v vVar) {
                            final GuildMusicMarqueeView guildMusicMarqueeView4 = GuildMusicMarqueeView.this;
                            vVar.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.itemview.guild.subchannel.view.GuildMusicMarqueeView.createNextBatchMarquee.1.1.1
                                {
                                    super(1);
                                }

                                @Override // kotlin.jvm.functions.Function1
                                public final Unit invoke(t tVar) {
                                    tVar.mo153width(GuildMusicMarqueeView.this.getFlexNode().U() / GuildMusicMarqueeView.access$getAttr(GuildMusicMarqueeView.this).maxMarqueeEachBatch);
                                    return Unit.INSTANCE;
                                }
                            });
                            return Unit.INSTANCE;
                        }
                    });
                }
                i3++;
            }
        } else {
            int i17 = GuildMusicMarqueeView.access$getAttr(this.$ctx).maxMarqueeEachBatch;
            while (i3 < i17) {
                GuildMusicMarqueeView guildMusicMarqueeView4 = this.$ctx;
                guildMusicMarqueeView4.currentIndex = (guildMusicMarqueeView4.currentIndex + 1) % GuildMusicMarqueeView.access$getAttr(guildMusicMarqueeView4).getMarqueeItemListCount$qecommerce_biz_release().invoke().intValue();
                Function2<? super ViewContainer<?, ?>, ? super Integer, Unit> function22 = GuildMusicMarqueeView.access$getAttr(this.$ctx).marqueeItemViewCreator;
                if (function22 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("marqueeItemViewCreator");
                    function22 = null;
                }
                function22.invoke(viewContainer2, Integer.valueOf(this.$ctx.currentIndex));
                i3++;
            }
        }
        return Unit.INSTANCE;
    }
}

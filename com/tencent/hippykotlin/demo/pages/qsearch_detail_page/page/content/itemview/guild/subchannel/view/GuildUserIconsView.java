package com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.itemview.guild.subchannel.view;

import com.tencent.kuikly.core.base.Attr;
import com.tencent.kuikly.core.base.BorderStyle;
import com.tencent.kuikly.core.base.ComposeView;
import com.tencent.kuikly.core.base.ViewContainer;
import com.tencent.kuikly.core.base.attr.b;
import com.tencent.kuikly.core.base.e;
import com.tencent.kuikly.core.base.event.Event;
import com.tencent.kuikly.core.base.h;
import com.tencent.kuikly.core.base.m;
import com.tencent.kuikly.core.views.ImageView;
import com.tencent.kuikly.core.views.TextView;
import com.tencent.kuikly.core.views.af;
import com.tencent.kuikly.core.views.ah;
import com.tencent.kuikly.core.views.ce;
import com.tencent.kuikly.core.views.cg;
import com.tencent.kuikly.core.views.t;
import com.tencent.kuikly.core.views.v;
import com.tencent.kuikly.core.views.w;
import java.util.List;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Ref;

/* compiled from: P */
/* loaded from: classes32.dex */
public final class GuildUserIconsView extends ComposeView<GuildUserIconsAttr, GuildUserIconsEvent> {
    /* JADX WARN: Multi-variable type inference failed */
    public static final /* synthetic */ GuildUserIconsAttr access$getAttr(GuildUserIconsView guildUserIconsView) {
        return (GuildUserIconsAttr) guildUserIconsView.getAttr();
    }

    @Override // com.tencent.kuikly.core.base.ComposeView
    public final Function1<ViewContainer<?, ?>, Unit> body() {
        return new Function1<ViewContainer<?, ?>, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.itemview.guild.subchannel.view.GuildUserIconsView$body$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Unit invoke(ViewContainer<?, ?> viewContainer) {
                ViewContainer<?, ?> viewContainer2 = viewContainer;
                viewContainer2.attr(new Function1<m, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.itemview.guild.subchannel.view.GuildUserIconsView$body$1.1
                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(m mVar) {
                        m mVar2 = mVar;
                        mVar2.flexDirectionRow();
                        mVar2.alignItemsCenter();
                        return Unit.INSTANCE;
                    }
                });
                final Ref.FloatRef floatRef = new Ref.FloatRef();
                if (!GuildUserIconsView.access$getAttr(GuildUserIconsView.this).userAvatars.isEmpty()) {
                    floatRef.element = 6.0f;
                    final GuildUserIconsView guildUserIconsView = GuildUserIconsView.this;
                    w.a(viewContainer2, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.itemview.guild.subchannel.view.GuildUserIconsView$body$1.2
                        {
                            super(1);
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public final Unit invoke(v vVar) {
                            List take;
                            v vVar2 = vVar;
                            vVar2.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.itemview.guild.subchannel.view.GuildUserIconsView.body.1.2.1
                                @Override // kotlin.jvm.functions.Function1
                                public final Unit invoke(t tVar) {
                                    tVar.flexDirectionRow();
                                    return Unit.INSTANCE;
                                }
                            });
                            take = CollectionsKt___CollectionsKt.take(GuildUserIconsView.access$getAttr(GuildUserIconsView.this).userAvatars, 3);
                            final GuildUserIconsView guildUserIconsView2 = GuildUserIconsView.this;
                            final int i3 = 0;
                            for (Object obj : take) {
                                int i16 = i3 + 1;
                                if (i3 < 0) {
                                    CollectionsKt__CollectionsKt.throwIndexOverflow();
                                }
                                final String str = (String) obj;
                                ah.a(vVar2, new Function1<ImageView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.itemview.guild.subchannel.view.GuildUserIconsView$body$1$2$2$1
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(ImageView imageView) {
                                        final String str2 = str;
                                        final GuildUserIconsView guildUserIconsView3 = guildUserIconsView2;
                                        final int i17 = i3;
                                        imageView.attr(new Function1<af, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.itemview.guild.subchannel.view.GuildUserIconsView$body$1$2$2$1.1
                                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                            {
                                                super(1);
                                            }

                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(af afVar) {
                                                af afVar2 = afVar;
                                                afVar2.mo153width(18.0f);
                                                afVar2.mo141height(18.0f);
                                                afVar2.borderRadius(18.0f);
                                                afVar2.m136border(new e(1.0f, BorderStyle.SOLID, h.INSTANCE.m()));
                                                b.a.b(afVar2, str2, false, 2, null);
                                                afVar2.m154zIndex(GuildUserIconsView.access$getAttr(guildUserIconsView3).userAvatars.size() - i17);
                                                if (i17 != 0) {
                                                    afVar2.marginLeft(-3.0f);
                                                }
                                                return Unit.INSTANCE;
                                            }
                                        });
                                        return Unit.INSTANCE;
                                    }
                                });
                                i3 = i16;
                            }
                            return Unit.INSTANCE;
                        }
                    });
                }
                final GuildUserIconsView guildUserIconsView2 = GuildUserIconsView.this;
                ah.a(viewContainer2, new Function1<ImageView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.itemview.guild.subchannel.view.GuildUserIconsView$body$1.3
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(ImageView imageView) {
                        final GuildUserIconsView guildUserIconsView3 = GuildUserIconsView.this;
                        final Ref.FloatRef floatRef2 = floatRef;
                        imageView.attr(new Function1<af, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.itemview.guild.subchannel.view.GuildUserIconsView.body.1.3.1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(af afVar) {
                                af afVar2 = afVar;
                                GuildUserIconsAttr access$getAttr = GuildUserIconsView.access$getAttr(GuildUserIconsView.this);
                                b.a.b(afVar2, (String) access$getAttr.rightIcon$delegate.getValue(access$getAttr, GuildUserIconsAttr.$$delegatedProperties[0]), false, 2, null);
                                afVar2.size(GuildUserIconsView.access$getAttr(GuildUserIconsView.this).rightIconSize, GuildUserIconsView.access$getAttr(GuildUserIconsView.this).rightIconSize);
                                afVar2.marginLeft(floatRef2.element);
                                return Unit.INSTANCE;
                            }
                        });
                        return Unit.INSTANCE;
                    }
                });
                final GuildUserIconsView guildUserIconsView3 = GuildUserIconsView.this;
                cg.a(viewContainer2, new Function1<TextView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.itemview.guild.subchannel.view.GuildUserIconsView$body$1.4
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(TextView textView) {
                        final GuildUserIconsView guildUserIconsView4 = GuildUserIconsView.this;
                        textView.attr(new Function1<ce, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.itemview.guild.subchannel.view.GuildUserIconsView.body.1.4.1
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(ce ceVar) {
                                ce ceVar2 = ceVar;
                                ceVar2.m140flex(1.0f);
                                ceVar2.marginLeft(1.0f);
                                ceVar2.text(GuildUserIconsView.access$getAttr(GuildUserIconsView.this).audienceCount);
                                ce.fontSize$default(ceVar2, GuildUserIconsView.access$getAttr(GuildUserIconsView.this).fontSize, null, 2, null);
                                ceVar2.color(h.INSTANCE.m());
                                ceVar2.m147opacity(0.75f);
                                return Unit.INSTANCE;
                            }
                        });
                        return Unit.INSTANCE;
                    }
                });
                return Unit.INSTANCE;
            }
        };
    }

    @Override // com.tencent.kuikly.core.base.AbstractBaseView
    public final Attr createAttr() {
        return new GuildUserIconsAttr();
    }

    @Override // com.tencent.kuikly.core.base.AbstractBaseView
    public final Event createEvent() {
        return new GuildUserIconsEvent();
    }
}

package com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.itemview.guild.subchannel.view;

import com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.itemview.guild.subchannel.p001double.view.GuildDoubleItemMiddleAvatarAttr;
import com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.itemview.guild.subchannel.p001double.view.GuildDoubleItemMiddleAvatarView;
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
import com.tencent.kuikly.core.views.af;
import com.tencent.kuikly.core.views.ah;
import com.tencent.kuikly.core.views.t;
import com.tencent.kuikly.core.views.v;
import com.tencent.kuikly.core.views.w;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.properties.ReadWriteProperty;
import kotlin.reflect.KProperty;

/* compiled from: P */
/* loaded from: classes32.dex */
public final class GuildItemMiddleAvatarView extends ComposeView<GuildItemMiddleAvatarAttr, GuildItemMiddleAvatarEvent> {
    public final float marginSize = 21.0f;
    public final float appIconSize = 38.0f;
    public final float dividerMargin = 14.0f;
    public final float dividerWidth = 1.0f;

    /* JADX WARN: Multi-variable type inference failed */
    public static final /* synthetic */ GuildItemMiddleAvatarAttr access$getAttr(GuildItemMiddleAvatarView guildItemMiddleAvatarView) {
        return (GuildItemMiddleAvatarAttr) guildItemMiddleAvatarView.getAttr();
    }

    @Override // com.tencent.kuikly.core.base.ComposeView
    public final Function1<ViewContainer<?, ?>, Unit> body() {
        return new Function1<ViewContainer<?, ?>, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.itemview.guild.subchannel.view.GuildItemMiddleAvatarView$body$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Unit invoke(ViewContainer<?, ?> viewContainer) {
                ViewContainer<?, ?> viewContainer2 = viewContainer;
                final GuildItemMiddleAvatarView guildItemMiddleAvatarView = GuildItemMiddleAvatarView.this;
                viewContainer2.attr(new Function1<m, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.itemview.guild.subchannel.view.GuildItemMiddleAvatarView$body$1.1
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(m mVar) {
                        m mVar2 = mVar;
                        mVar2.m140flex(1.0f);
                        mVar2.flexDirectionRow();
                        mVar2.alignItemsCenter();
                        mVar2.paddingLeft(GuildItemMiddleAvatarView.this.marginSize);
                        mVar2.paddingBottom(20.0f);
                        return Unit.INSTANCE;
                    }
                });
                final boolean z16 = GuildItemMiddleAvatarView.access$getAttr(GuildItemMiddleAvatarView.this).appIcon.length() > 0;
                if (z16) {
                    final GuildItemMiddleAvatarView guildItemMiddleAvatarView2 = GuildItemMiddleAvatarView.this;
                    ah.a(viewContainer2, new Function1<ImageView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.itemview.guild.subchannel.view.GuildItemMiddleAvatarView$body$1.2
                        {
                            super(1);
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public final Unit invoke(ImageView imageView) {
                            final GuildItemMiddleAvatarView guildItemMiddleAvatarView3 = GuildItemMiddleAvatarView.this;
                            imageView.attr(new Function1<af, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.itemview.guild.subchannel.view.GuildItemMiddleAvatarView.body.1.2.1
                                {
                                    super(1);
                                }

                                @Override // kotlin.jvm.functions.Function1
                                public final Unit invoke(af afVar) {
                                    af afVar2 = afVar;
                                    afVar2.mo153width(GuildItemMiddleAvatarView.this.appIconSize);
                                    afVar2.mo141height(GuildItemMiddleAvatarView.this.appIconSize);
                                    afVar2.borderRadius(8.0f);
                                    afVar2.m136border(new e(1.0f, BorderStyle.SOLID, h.INSTANCE.m()));
                                    b.a.b(afVar2, GuildItemMiddleAvatarView.access$getAttr(GuildItemMiddleAvatarView.this).appIcon, false, 2, null);
                                    return Unit.INSTANCE;
                                }
                            });
                            return Unit.INSTANCE;
                        }
                    });
                    final GuildItemMiddleAvatarView guildItemMiddleAvatarView3 = GuildItemMiddleAvatarView.this;
                    w.a(viewContainer2, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.itemview.guild.subchannel.view.GuildItemMiddleAvatarView$body$1.3
                        {
                            super(1);
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public final Unit invoke(v vVar) {
                            final GuildItemMiddleAvatarView guildItemMiddleAvatarView4 = GuildItemMiddleAvatarView.this;
                            vVar.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.itemview.guild.subchannel.view.GuildItemMiddleAvatarView.body.1.3.1
                                {
                                    super(1);
                                }

                                @Override // kotlin.jvm.functions.Function1
                                public final Unit invoke(t tVar) {
                                    t tVar2 = tVar;
                                    tVar2.mo153width(GuildItemMiddleAvatarView.this.dividerWidth);
                                    tVar2.mo141height(36.0f);
                                    tVar2.marginLeft(GuildItemMiddleAvatarView.this.dividerMargin);
                                    tVar2.marginRight(GuildItemMiddleAvatarView.this.dividerMargin - 6.0f);
                                    tVar2.mo113backgroundColor(new h(654311423L));
                                    return Unit.INSTANCE;
                                }
                            });
                            return Unit.INSTANCE;
                        }
                    });
                }
                final GuildItemMiddleAvatarView guildItemMiddleAvatarView4 = GuildItemMiddleAvatarView.this;
                viewContainer2.addChild(new GuildDoubleItemMiddleAvatarView(), new Function1<GuildDoubleItemMiddleAvatarView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.itemview.guild.subchannel.view.GuildItemMiddleAvatarView$body$1.4
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(GuildDoubleItemMiddleAvatarView guildDoubleItemMiddleAvatarView) {
                        final GuildItemMiddleAvatarView guildItemMiddleAvatarView5 = GuildItemMiddleAvatarView.this;
                        final boolean z17 = z16;
                        guildDoubleItemMiddleAvatarView.attr(new Function1<GuildDoubleItemMiddleAvatarAttr, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.itemview.guild.subchannel.view.GuildItemMiddleAvatarView.body.1.4.1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(GuildDoubleItemMiddleAvatarAttr guildDoubleItemMiddleAvatarAttr) {
                                GuildDoubleItemMiddleAvatarAttr guildDoubleItemMiddleAvatarAttr2 = guildDoubleItemMiddleAvatarAttr;
                                GuildItemMiddleAvatarAttr access$getAttr = GuildItemMiddleAvatarView.access$getAttr(GuildItemMiddleAvatarView.this);
                                ReadWriteProperty readWriteProperty = access$getAttr.play$delegate;
                                KProperty<?>[] kPropertyArr = GuildItemMiddleAvatarAttr.$$delegatedProperties;
                                boolean booleanValue = ((Boolean) readWriteProperty.getValue(access$getAttr, kPropertyArr[0])).booleanValue();
                                ReadWriteProperty readWriteProperty2 = guildDoubleItemMiddleAvatarAttr2.play$delegate;
                                KProperty<?>[] kPropertyArr2 = GuildDoubleItemMiddleAvatarAttr.$$delegatedProperties;
                                readWriteProperty2.setValue(guildDoubleItemMiddleAvatarAttr2, kPropertyArr2[0], Boolean.valueOf(booleanValue));
                                guildDoubleItemMiddleAvatarAttr2.audienceList = GuildItemMiddleAvatarView.access$getAttr(GuildItemMiddleAvatarView.this).audienceList;
                                guildDoubleItemMiddleAvatarAttr2.maxAvatarCount = z17 ? 5 : 6;
                                float f16 = GuildItemMiddleAvatarView.access$getAttr(GuildItemMiddleAvatarView.this).cardWidth;
                                GuildItemMiddleAvatarView guildItemMiddleAvatarView6 = GuildItemMiddleAvatarView.this;
                                float f17 = 2;
                                float f18 = (f16 - (guildItemMiddleAvatarView6.marginSize * f17)) - (guildDoubleItemMiddleAvatarAttr2.maxAvatarCount * 50.0f);
                                if (z17) {
                                    f18 = (((f18 - guildItemMiddleAvatarView6.appIconSize) - (guildItemMiddleAvatarView6.dividerMargin * f17)) + 6.0f) - guildItemMiddleAvatarView6.dividerWidth;
                                }
                                float f19 = f18 / (r3 - 1);
                                if (f19 < 0.0f) {
                                    f19 = 0.0f;
                                }
                                guildDoubleItemMiddleAvatarAttr2.marginBetweenAvatar = f19;
                                GuildItemMiddleAvatarAttr access$getAttr2 = GuildItemMiddleAvatarView.access$getAttr(guildItemMiddleAvatarView6);
                                guildDoubleItemMiddleAvatarAttr2.userScrolling$delegate.setValue(guildDoubleItemMiddleAvatarAttr2, kPropertyArr2[1], Boolean.valueOf(((Boolean) access$getAttr2.userScrolling$delegate.getValue(access$getAttr2, kPropertyArr[1])).booleanValue()));
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
        return new GuildItemMiddleAvatarAttr();
    }

    @Override // com.tencent.kuikly.core.base.AbstractBaseView
    public final Event createEvent() {
        return new GuildItemMiddleAvatarEvent();
    }
}

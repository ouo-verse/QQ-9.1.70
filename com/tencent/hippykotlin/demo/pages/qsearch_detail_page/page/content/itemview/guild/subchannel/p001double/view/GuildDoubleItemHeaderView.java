package com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.itemview.guild.subchannel.p001double.view;

import com.tencent.hippykotlin.demo.pages.base.extension.ImageAttrExtKt;
import com.tencent.hippykotlin.demo.pages.foundation.extension.FontModuleExtKt;
import com.tencent.hippykotlin.demo.pages.qsearch_detail_page.PageStatus;
import com.tencent.hippykotlin.demo.pages.qsearch_detail_page.data.pb.UnifySearchTabInfo;
import com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.itemview.guild.subchannel.view.GuildTypeIconView;
import com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.itemview.guild.subchannel.view.GuildTypeIconViewAttr;
import com.tencent.kuikly.core.base.Attr;
import com.tencent.kuikly.core.base.BorderStyle;
import com.tencent.kuikly.core.base.ComposeView;
import com.tencent.kuikly.core.base.Direction;
import com.tencent.kuikly.core.base.ViewContainer;
import com.tencent.kuikly.core.base.e;
import com.tencent.kuikly.core.base.event.Event;
import com.tencent.kuikly.core.base.h;
import com.tencent.kuikly.core.base.j;
import com.tencent.kuikly.core.base.m;
import com.tencent.kuikly.core.views.ImageView;
import com.tencent.kuikly.core.views.af;
import com.tencent.kuikly.core.views.ah;
import com.tencent.kuikly.core.views.t;
import com.tencent.kuikly.core.views.v;
import com.tencent.kuikly.core.views.w;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.properties.ReadWriteProperty;
import kotlin.reflect.KProperty;

/* compiled from: P */
/* loaded from: classes32.dex */
public final class GuildDoubleItemHeaderView extends ComposeView<GuildDoubleItemHeaderAttr, GuildDoubleItemHeaderEvent> {
    /* JADX WARN: Multi-variable type inference failed */
    public static final /* synthetic */ GuildDoubleItemHeaderAttr access$getAttr(GuildDoubleItemHeaderView guildDoubleItemHeaderView) {
        return (GuildDoubleItemHeaderAttr) guildDoubleItemHeaderView.getAttr();
    }

    @Override // com.tencent.kuikly.core.base.ComposeView
    public final Function1<ViewContainer<?, ?>, Unit> body() {
        return new Function1<ViewContainer<?, ?>, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.itemview.guild.subchannel.double.view.GuildDoubleItemHeaderView$body$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Unit invoke(ViewContainer<?, ?> viewContainer) {
                ViewContainer<?, ?> viewContainer2 = viewContainer;
                viewContainer2.attr(new Function1<m, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.itemview.guild.subchannel.double.view.GuildDoubleItemHeaderView$body$1.1
                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(m mVar) {
                        m mVar2 = mVar;
                        mVar2.mo141height(FontModuleExtKt.qqFontScaleAddSize(10.0f) + 44.0f);
                        mVar2.flexDirectionRow();
                        mVar2.padding(12.0f, 12.0f, 0.0f, 12.0f);
                        mVar2.mo135backgroundLinearGradient(Direction.TO_BOTTOM, new j(new h(0, 0, 0, 0.5f), 0.0f), new j(h.INSTANCE.j(), 1.0f));
                        return Unit.INSTANCE;
                    }
                });
                final GuildDoubleItemHeaderView guildDoubleItemHeaderView = GuildDoubleItemHeaderView.this;
                viewContainer2.addChild(new GuildTypeIconView(), new Function1<GuildTypeIconView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.itemview.guild.subchannel.double.view.GuildDoubleItemHeaderView$body$1.2
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(GuildTypeIconView guildTypeIconView) {
                        final GuildDoubleItemHeaderView guildDoubleItemHeaderView2 = GuildDoubleItemHeaderView.this;
                        guildTypeIconView.attr(new Function1<GuildTypeIconViewAttr, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.itemview.guild.subchannel.double.view.GuildDoubleItemHeaderView.body.1.2.1
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(GuildTypeIconViewAttr guildTypeIconViewAttr) {
                                GuildTypeIconViewAttr guildTypeIconViewAttr2 = guildTypeIconViewAttr;
                                guildTypeIconViewAttr2.mo113backgroundColor(GuildDoubleItemHeaderView.access$getAttr(GuildDoubleItemHeaderView.this).iconBgColor);
                                guildTypeIconViewAttr2.iconColor = GuildDoubleItemHeaderView.access$getAttr(GuildDoubleItemHeaderView.this).iconColor;
                                String str = GuildDoubleItemHeaderView.access$getAttr(GuildDoubleItemHeaderView.this).text;
                                ReadWriteProperty readWriteProperty = guildTypeIconViewAttr2.iconText$delegate;
                                KProperty<?>[] kPropertyArr = GuildTypeIconViewAttr.$$delegatedProperties;
                                readWriteProperty.setValue(guildTypeIconViewAttr2, kPropertyArr[0], str);
                                GuildDoubleItemHeaderAttr access$getAttr = GuildDoubleItemHeaderView.access$getAttr(GuildDoubleItemHeaderView.this);
                                ReadWriteProperty readWriteProperty2 = access$getAttr.iconSrcAnd$delegate;
                                KProperty<?>[] kPropertyArr2 = GuildDoubleItemHeaderAttr.$$delegatedProperties;
                                guildTypeIconViewAttr2.iconSrcAnd$delegate.setValue(guildTypeIconViewAttr2, kPropertyArr[1], (String) readWriteProperty2.getValue(access$getAttr, kPropertyArr2[0]));
                                GuildDoubleItemHeaderAttr access$getAttr2 = GuildDoubleItemHeaderView.access$getAttr(GuildDoubleItemHeaderView.this);
                                guildTypeIconViewAttr2.iconSrcIOS$delegate.setValue(guildTypeIconViewAttr2, kPropertyArr[2], (String) access$getAttr2.iconSrcIOS$delegate.getValue(access$getAttr2, kPropertyArr2[1]));
                                GuildDoubleItemHeaderAttr access$getAttr3 = GuildDoubleItemHeaderView.access$getAttr(GuildDoubleItemHeaderView.this);
                                guildTypeIconViewAttr2.iconSrcImg$delegate.setValue(guildTypeIconViewAttr2, kPropertyArr[3], (String) access$getAttr3.iconSrcImg$delegate.getValue(access$getAttr3, kPropertyArr2[2]));
                                GuildDoubleItemHeaderAttr access$getAttr4 = GuildDoubleItemHeaderView.access$getAttr(GuildDoubleItemHeaderView.this);
                                guildTypeIconViewAttr2.setPageStatus((PageStatus) access$getAttr4.pageStatus$delegate.getValue(access$getAttr4, kPropertyArr2[3]));
                                UnifySearchTabInfo unifySearchTabInfo = GuildDoubleItemHeaderView.access$getAttr(GuildDoubleItemHeaderView.this).tabData;
                                if (unifySearchTabInfo == null) {
                                    Intrinsics.throwUninitializedPropertyAccessException("tabData");
                                    unifySearchTabInfo = null;
                                }
                                guildTypeIconViewAttr2.tabData = unifySearchTabInfo;
                                return Unit.INSTANCE;
                            }
                        });
                        return Unit.INSTANCE;
                    }
                });
                final GuildDoubleItemHeaderView guildDoubleItemHeaderView2 = GuildDoubleItemHeaderView.this;
                w.a(viewContainer2, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.itemview.guild.subchannel.double.view.GuildDoubleItemHeaderView$body$1.3
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(v vVar) {
                        v vVar2 = vVar;
                        vVar2.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.itemview.guild.subchannel.double.view.GuildDoubleItemHeaderView.body.1.3.1
                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(t tVar) {
                                t tVar2 = tVar;
                                tVar2.m140flex(1.0f);
                                tVar2.flexDirectionRow();
                                tVar2.justifyContentFlexEnd();
                                return Unit.INSTANCE;
                            }
                        });
                        final GuildDoubleItemHeaderView guildDoubleItemHeaderView3 = GuildDoubleItemHeaderView.this;
                        ah.a(vVar2, new Function1<ImageView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.itemview.guild.subchannel.double.view.GuildDoubleItemHeaderView.body.1.3.2
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(ImageView imageView) {
                                final GuildDoubleItemHeaderView guildDoubleItemHeaderView4 = GuildDoubleItemHeaderView.this;
                                imageView.attr(new Function1<af, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.itemview.guild.subchannel.double.view.GuildDoubleItemHeaderView.body.1.3.2.1
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(af afVar) {
                                        af afVar2 = afVar;
                                        afVar2.size(23.0f, 23.0f);
                                        ImageAttrExtKt.srcUrl(afVar2, GuildDoubleItemHeaderView.access$getAttr(GuildDoubleItemHeaderView.this).avatar, null);
                                        afVar2.borderRadius(4.0f);
                                        afVar2.m136border(new e(0.5f, BorderStyle.SOLID, h.INSTANCE.m()));
                                        return Unit.INSTANCE;
                                    }
                                });
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
        return new GuildDoubleItemHeaderAttr();
    }

    @Override // com.tencent.kuikly.core.base.AbstractBaseView
    public final Event createEvent() {
        return new GuildDoubleItemHeaderEvent();
    }
}

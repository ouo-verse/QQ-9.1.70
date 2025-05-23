package com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.itemview.guild.subchannel.view;

import com.tencent.hippykotlin.demo.pages.foundation.extension.FontModuleExtKt;
import com.tencent.hippykotlin.demo.pages.qsearch_detail_page.PageStatus;
import com.tencent.hippykotlin.demo.pages.qsearch_detail_page.data.pb.UnifySearchTabInfo;
import com.tencent.kuikly.core.base.Attr;
import com.tencent.kuikly.core.base.ComposeView;
import com.tencent.kuikly.core.base.Direction;
import com.tencent.kuikly.core.base.ViewContainer;
import com.tencent.kuikly.core.base.event.Event;
import com.tencent.kuikly.core.base.h;
import com.tencent.kuikly.core.base.j;
import com.tencent.kuikly.core.base.m;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.properties.ReadWriteProperty;
import kotlin.reflect.KProperty;

/* compiled from: P */
/* loaded from: classes32.dex */
public final class GuildItemHeaderView extends ComposeView<GuildItemHeaderAttr, GuildItemHeaderEvent> {
    /* JADX WARN: Multi-variable type inference failed */
    public static final /* synthetic */ GuildItemHeaderAttr access$getAttr(GuildItemHeaderView guildItemHeaderView) {
        return (GuildItemHeaderAttr) guildItemHeaderView.getAttr();
    }

    @Override // com.tencent.kuikly.core.base.ComposeView
    public final Function1<ViewContainer<?, ?>, Unit> body() {
        return new Function1<ViewContainer<?, ?>, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.itemview.guild.subchannel.view.GuildItemHeaderView$body$1
            {
                super(1);
            }

            /* JADX WARN: Type inference failed for: r0v4, types: [kotlin.jvm.functions.Function1, kotlin.jvm.internal.Lambda] */
            @Override // kotlin.jvm.functions.Function1
            public final Unit invoke(ViewContainer<?, ?> viewContainer) {
                ViewContainer<?, ?> viewContainer2 = viewContainer;
                final GuildItemHeaderView guildItemHeaderView = GuildItemHeaderView.this;
                viewContainer2.attr(new Function1<m, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.itemview.guild.subchannel.view.GuildItemHeaderView$body$1.1
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(m mVar) {
                        m mVar2 = mVar;
                        mVar2.mo141height(FontModuleExtKt.qqFontScaleAddSize(10.0f) + 50.0f);
                        mVar2.flexDirectionRow();
                        mVar2.padding(12.0f, 12.0f, 0.0f, 12.0f);
                        mVar2.mo135backgroundLinearGradient(Direction.TO_BOTTOM, new j(new h(0, 0, 0, GuildItemHeaderView.access$getAttr(GuildItemHeaderView.this).maskStartAlpha), 0.0f), new j(h.INSTANCE.j(), 1.0f));
                        return Unit.INSTANCE;
                    }
                });
                final GuildItemHeaderView guildItemHeaderView2 = GuildItemHeaderView.this;
                viewContainer2.addChild(new GuildTypeIconView(), new Function1<GuildTypeIconView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.itemview.guild.subchannel.view.GuildItemHeaderView$body$1.2
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(GuildTypeIconView guildTypeIconView) {
                        final GuildItemHeaderView guildItemHeaderView3 = GuildItemHeaderView.this;
                        guildTypeIconView.attr(new Function1<GuildTypeIconViewAttr, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.itemview.guild.subchannel.view.GuildItemHeaderView.body.1.2.1
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(GuildTypeIconViewAttr guildTypeIconViewAttr) {
                                GuildTypeIconViewAttr guildTypeIconViewAttr2 = guildTypeIconViewAttr;
                                guildTypeIconViewAttr2.mo113backgroundColor(GuildItemHeaderView.access$getAttr(GuildItemHeaderView.this).iconBgColor);
                                guildTypeIconViewAttr2.iconColor = GuildItemHeaderView.access$getAttr(GuildItemHeaderView.this).iconColor;
                                String str = GuildItemHeaderView.access$getAttr(GuildItemHeaderView.this).text;
                                ReadWriteProperty readWriteProperty = guildTypeIconViewAttr2.iconText$delegate;
                                KProperty<?>[] kPropertyArr = GuildTypeIconViewAttr.$$delegatedProperties;
                                readWriteProperty.setValue(guildTypeIconViewAttr2, kPropertyArr[0], str);
                                GuildItemHeaderAttr access$getAttr = GuildItemHeaderView.access$getAttr(GuildItemHeaderView.this);
                                ReadWriteProperty readWriteProperty2 = access$getAttr.iconSrcAnd$delegate;
                                KProperty<?>[] kPropertyArr2 = GuildItemHeaderAttr.$$delegatedProperties;
                                guildTypeIconViewAttr2.iconSrcAnd$delegate.setValue(guildTypeIconViewAttr2, kPropertyArr[1], (String) readWriteProperty2.getValue(access$getAttr, kPropertyArr2[0]));
                                GuildItemHeaderAttr access$getAttr2 = GuildItemHeaderView.access$getAttr(GuildItemHeaderView.this);
                                guildTypeIconViewAttr2.iconSrcIOS$delegate.setValue(guildTypeIconViewAttr2, kPropertyArr[2], (String) access$getAttr2.iconSrcIOS$delegate.getValue(access$getAttr2, kPropertyArr2[1]));
                                GuildItemHeaderAttr access$getAttr3 = GuildItemHeaderView.access$getAttr(GuildItemHeaderView.this);
                                guildTypeIconViewAttr2.iconSrcImg$delegate.setValue(guildTypeIconViewAttr2, kPropertyArr[3], (String) access$getAttr3.iconSrcImg$delegate.getValue(access$getAttr3, kPropertyArr2[2]));
                                GuildItemHeaderAttr access$getAttr4 = GuildItemHeaderView.access$getAttr(GuildItemHeaderView.this);
                                guildTypeIconViewAttr2.setPageStatus((PageStatus) access$getAttr4.pageStatus$delegate.getValue(access$getAttr4, kPropertyArr2[3]));
                                UnifySearchTabInfo unifySearchTabInfo = GuildItemHeaderView.access$getAttr(GuildItemHeaderView.this).tabData;
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
                ?? r06 = GuildItemHeaderView.access$getAttr(GuildItemHeaderView.this).rightPartViewBuilder;
                if (r06 != 0) {
                    r06.invoke(viewContainer2);
                }
                return Unit.INSTANCE;
            }
        };
    }

    @Override // com.tencent.kuikly.core.base.AbstractBaseView
    public final Attr createAttr() {
        return new GuildItemHeaderAttr();
    }

    @Override // com.tencent.kuikly.core.base.AbstractBaseView
    public final Event createEvent() {
        return new GuildItemHeaderEvent();
    }
}

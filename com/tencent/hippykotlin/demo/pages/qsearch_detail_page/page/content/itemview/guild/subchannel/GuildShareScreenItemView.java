package com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.itemview.guild.subchannel;

import com.tencent.hippykotlin.demo.pages.foundation.extension.FontModuleExtKt;
import com.tencent.hippykotlin.demo.pages.qsearch_detail_page.data.pb.guild.GuildVideoItemModel;
import com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.itemview.guild.subchannel.view.GuildItemFooterAttr;
import com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.itemview.guild.subchannel.view.GuildItemHeaderAttr;
import com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.itemview.guild.subchannel.view.GuildUserIconsAttr;
import com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.itemview.guild.subchannel.view.GuildUserIconsView;
import com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.itemview.guild.subchannel.view.GuildUserIconsViewKt;
import com.tencent.kuikly.core.base.ViewContainer;
import com.tencent.kuikly.core.base.h;
import com.tencent.kuikly.core.views.t;
import com.tencent.kuikly.core.views.v;
import com.tencent.kuikly.core.views.w;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* compiled from: P */
/* loaded from: classes32.dex */
public final class GuildShareScreenItemView extends GuildLiveVideoItemView {
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.itemview.guild.subchannel.GuildLiveVideoItemView
    public final void configFooter(GuildItemFooterAttr guildItemFooterAttr) {
        guildItemFooterAttr.mo113backgroundColor(new h(3845206328L));
        int i3 = ((GuildLiveVideoAttr) getAttr()).index;
        guildItemFooterAttr.buttonText = "\u52a0\u5165";
        guildItemFooterAttr.buttonColor = new h(4278229503L);
        guildItemFooterAttr.buttonWidth = 54.0f;
    }

    /* JADX WARN: Type inference failed for: r0v4, types: [com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.itemview.guild.subchannel.GuildShareScreenItemView$configHeader$1$1, kotlin.jvm.internal.Lambda] */
    @Override // com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.itemview.guild.subchannel.GuildLiveVideoItemView
    public final void configHeader(GuildItemHeaderAttr guildItemHeaderAttr, final GuildVideoItemModel guildVideoItemModel) {
        guildItemHeaderAttr.text = "\u5171\u4eab\u4e2d";
        guildItemHeaderAttr.iconColor = new h(4294925304L);
        guildItemHeaderAttr.iconBgColor = new h(2988574513L);
        guildItemHeaderAttr.iconSrcImg$delegate.setValue(guildItemHeaderAttr, GuildItemHeaderAttr.$$delegatedProperties[2], "data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAAB4AAAAeCAYAAAA7MK6iAAAACXBIWXMAACE4AAAhOAFFljFgAAAAAXNSR0IArs4c6QAAAARnQU1BAACxjwv8YQUAAAHHSURBVHgB7ZbdUcJAEMf/G1BhxhnpwNiBdoAViG+KOoMdQAVCBUgF4owib9KBdgAdmBJ4IyGYdfMByFdygcATv5mb3Gw2+ef2djcH7NmzJWg84YdBCQwd2ySNJjWzxkSY78y6XMrYPgYOji6oSX0tMOSxG3SMzHN3kg4MucktQl9C3key6POG9KIPN+g9W0VC8M1AR4p+5u0aNoBLA52L5qd7RUw2EsZIQkgowKavuOKbCU/RPfHi8Fz1gTRiwveDPDh1JbO8DH1GnJwu35oV+sg8R71HWZhLnMPIepGMLwBOYFziqKHOReuEWke1sPcphdrbP9vq+qIKEFelKZU3EvZWKvsHxGinDCnJ8HBHh9q2nmZEyWsuhgy30biNZzahmGvUiu4DocL+aq0gZNSU5Hmlt+z35L6XaF40/A/6pUdJrA4UCF/x0JZMpR7YfqTWcS/E08CIL6mdMaBIqDC1Dl2xi5UOTqoPzemIaIXa/u8uEeEogg+7xhosCrN26u1dUpAkpqMiLCklCVNCUvBy87iOk/7/RuILMzewCwidcTlOD3sFqdmMmcMW+Z/5pPKAd4pYU2AVauWUitWrDRlnUU5JHQRi8wfm9J613jDQpQAAAABJRU5ErkJggg==");
        guildItemHeaderAttr.rightPartViewBuilder = new Function1<ViewContainer<?, ?>, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.itemview.guild.subchannel.GuildShareScreenItemView$configHeader$1$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Unit invoke(ViewContainer<?, ?> viewContainer) {
                final GuildVideoItemModel guildVideoItemModel2 = GuildVideoItemModel.this;
                w.a(viewContainer, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.itemview.guild.subchannel.GuildShareScreenItemView$configHeader$1$1.1
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(v vVar) {
                        v vVar2 = vVar;
                        vVar2.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.itemview.guild.subchannel.GuildShareScreenItemView.configHeader.1.1.1.1
                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(t tVar) {
                                t tVar2 = tVar;
                                tVar2.m140flex(1.0f);
                                tVar2.flexDirectionRow();
                                tVar2.justifyContentFlexEnd();
                                return Unit.INSTANCE;
                            }
                        });
                        final GuildVideoItemModel guildVideoItemModel3 = GuildVideoItemModel.this;
                        GuildUserIconsViewKt.QSearchLiveUserView(vVar2, new Function1<GuildUserIconsView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.itemview.guild.subchannel.GuildShareScreenItemView.configHeader.1.1.1.2
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(GuildUserIconsView guildUserIconsView) {
                                final GuildVideoItemModel guildVideoItemModel4 = GuildVideoItemModel.this;
                                guildUserIconsView.attr(new Function1<GuildUserIconsAttr, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.itemview.guild.subchannel.GuildShareScreenItemView.configHeader.1.1.1.2.1
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(GuildUserIconsAttr guildUserIconsAttr) {
                                        GuildUserIconsAttr guildUserIconsAttr2 = guildUserIconsAttr;
                                        guildUserIconsAttr2.mo141height(FontModuleExtKt.qqFontScaleAddSize(12.0f) + 18.0f);
                                        guildUserIconsAttr2.audienceList(GuildVideoItemModel.this.audienceList);
                                        guildUserIconsAttr2.audienceCount = GuildVideoItemModel.this.getAudienceCount();
                                        guildUserIconsAttr2.setRightIcon("data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAACQAAAAkCAYAAADhAJiYAAAACXBIWXMAACE4AAAhOAFFljFgAAAAAXNSR0IArs4c6QAAAARnQU1BAACxjwv8YQUAAAGUSURBVHgB7Zg9bsJAEIXfWunCAThADkAfeuid3jSpoEnFGahScYD0OUDS5wDkFjlAemcmWpBtFvvNrm0JiU9arZDHq4/ZvwHgxpXhkEhZlhPpJv+DOfeDRKKEvEQubSlt2nh8kPYpch+IwCwkMgvpNvBZaUGz9WLNmklIZArpVoZXzFIZGygyc6OMotP56qe4XyFhjThU6okNpoTkG4YWr4WczRKboUekoTJzJpAVekA61BisUMp0Hel1ypJPYOGXCRpTiBqDFfpGOl9MECv0DjLlFziwpzUlJIOpzBvi2bGB9EktUpqlmBt8b7nLYm57velzMnxnLUPu2MBKDbQATyHvwSJFZUgGnUm3RfwBSZchnUIRNVAbnVPoOmS05KBLB5K93yBBshaZYgAZZe2XQBB3QUYX7wbDoefac2hNZQEZXbgrDIvu2G3oQWjKCpClQiKz0NTVhHzAEuNxlqVmhtgTuC+mzSydhPzaoerenqntZMvPoKG4r344CfktmFJixKDbv1aanJ1D1X8zxhDytdYNmj91+3iieo+iMAAAAABJRU5ErkJggg==");
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
}

package com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.itemview.guild.subchannel.p001double;

import com.tencent.hippykotlin.demo.pages.qsearch_detail_page.data.pb.guild.GuildCommonItemModel;
import com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.itemview.guild.subchannel.p001double.view.GuildDoubleItemHeaderAttr;
import com.tencent.kuikly.core.base.ViewContainer;
import com.tencent.kuikly.core.base.attr.b;
import com.tencent.kuikly.core.base.h;
import com.tencent.kuikly.core.views.ImageView;
import com.tencent.kuikly.core.views.TextView;
import com.tencent.kuikly.core.views.af;
import com.tencent.kuikly.core.views.ah;
import com.tencent.kuikly.core.views.ce;
import com.tencent.kuikly.core.views.cg;
import com.tencent.kuikly.core.views.t;
import com.tencent.kuikly.core.views.v;
import com.tencent.kuikly.core.views.w;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* compiled from: P */
/* loaded from: classes32.dex */
public class GuildMusicDoubleItemView extends GuildBaseImageDoubleItemView {
    @Override // com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.itemview.guild.subchannel.p001double.GuildBaseImageDoubleItemView
    public final void configBottom(final GuildCommonItemModel guildCommonItemModel, ViewContainer viewContainer) {
        w.a(viewContainer, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.itemview.guild.subchannel.double.GuildMusicDoubleItemView$configBottom$1$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Unit invoke(v vVar) {
                v vVar2 = vVar;
                vVar2.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.itemview.guild.subchannel.double.GuildMusicDoubleItemView$configBottom$1$1.1
                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(t tVar) {
                        t tVar2 = tVar;
                        tVar2.marginLeft(12.0f);
                        tVar2.marginBottom(12.0f);
                        tVar2.marginTop(7.0f);
                        tVar2.flexDirectionRow();
                        tVar2.alignItemsCenter();
                        return Unit.INSTANCE;
                    }
                });
                ah.a(vVar2, new Function1<ImageView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.itemview.guild.subchannel.double.GuildMusicDoubleItemView$configBottom$1$1.2
                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(ImageView imageView) {
                        imageView.attr(new Function1<af, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.itemview.guild.subchannel.double.GuildMusicDoubleItemView.configBottom.1.1.2.1
                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(af afVar) {
                                af afVar2 = afVar;
                                b.a.b(afVar2, "data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAACQAAAAkCAYAAADhAJiYAAAACXBIWXMAACE4AAAhOAFFljFgAAAAAXNSR0IArs4c6QAAAARnQU1BAACxjwv8YQUAAAGUSURBVHgB7Zg9bsJAEIXfWunCAThADkAfeuid3jSpoEnFGahScYD0OUDS5wDkFjlAemcmWpBtFvvNrm0JiU9arZDHq4/ZvwHgxpXhkEhZlhPpJv+DOfeDRKKEvEQubSlt2nh8kPYpch+IwCwkMgvpNvBZaUGz9WLNmklIZArpVoZXzFIZGygyc6OMotP56qe4XyFhjThU6okNpoTkG4YWr4WczRKboUekoTJzJpAVekA61BisUMp0Hel1ypJPYOGXCRpTiBqDFfpGOl9MECv0DjLlFziwpzUlJIOpzBvi2bGB9EktUpqlmBt8b7nLYm57velzMnxnLUPu2MBKDbQATyHvwSJFZUgGnUm3RfwBSZchnUIRNVAbnVPoOmS05KBLB5K93yBBshaZYgAZZe2XQBB3QUYX7wbDoefac2hNZQEZXbgrDIvu2G3oQWjKCpClQiKz0NTVhHzAEuNxlqVmhtgTuC+mzSydhPzaoerenqntZMvPoKG4r344CfktmFJixKDbv1aanJ1D1X8zxhDytdYNmj91+3iieo+iMAAAAABJRU5ErkJggg==", false, 2, null);
                                afVar2.size(15.0f, 15.0f);
                                return Unit.INSTANCE;
                            }
                        });
                        return Unit.INSTANCE;
                    }
                });
                final GuildCommonItemModel guildCommonItemModel2 = GuildCommonItemModel.this;
                cg.a(vVar2, new Function1<TextView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.itemview.guild.subchannel.double.GuildMusicDoubleItemView$configBottom$1$1.3
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(TextView textView) {
                        final GuildCommonItemModel guildCommonItemModel3 = GuildCommonItemModel.this;
                        textView.attr(new Function1<ce, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.itemview.guild.subchannel.double.GuildMusicDoubleItemView.configBottom.1.1.3.1
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(ce ceVar) {
                                ce ceVar2 = ceVar;
                                ceVar2.marginLeft(1.0f);
                                ceVar2.text(GuildCommonItemModel.this.getAudienceCount());
                                ceVar2.lines(1);
                                ceVar2.color(new h(3221225471L));
                                ce.fontSize$default(ceVar2, 13.0f, null, 2, null);
                                ceVar2.fontWeight400();
                                return Unit.INSTANCE;
                            }
                        });
                        return Unit.INSTANCE;
                    }
                });
                return Unit.INSTANCE;
            }
        });
    }

    @Override // com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.itemview.guild.subchannel.p001double.GuildBaseImageDoubleItemView
    public void configHeader(GuildDoubleItemHeaderAttr guildDoubleItemHeaderAttr) {
        guildDoubleItemHeaderAttr.text = "\u542c\u6b4c\u4e2d";
        guildDoubleItemHeaderAttr.iconColor = new h(4278976438L);
        guildDoubleItemHeaderAttr.iconBgColor = new h(2986688051L);
        guildDoubleItemHeaderAttr.setIconSrcIOS("ec_search_guild_music.pag");
        guildDoubleItemHeaderAttr.setIconSrcAnd("ecommerce_search_guild_music");
    }
}

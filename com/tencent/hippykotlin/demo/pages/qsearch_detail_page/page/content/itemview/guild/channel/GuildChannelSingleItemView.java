package com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.itemview.guild.channel;

import com.tencent.hippykotlin.demo.pages.base.BridgeModule;
import com.tencent.hippykotlin.demo.pages.base.EcommerceExtKt;
import com.tencent.hippykotlin.demo.pages.base.QUISkinColor;
import com.tencent.hippykotlin.demo.pages.base.Utils;
import com.tencent.hippykotlin.demo.pages.foundation.extension.FontModuleExtKt;
import com.tencent.hippykotlin.demo.pages.qsearch_detail_page.data.pb.guild.SearchGuildChannelItemModel;
import com.tencent.hippykotlin.demo.pages.qsearch_detail_page.data.pb.template.TemplateItemsKt;
import com.tencent.hippykotlin.demo.pages.qsearch_detail_page.data.pb.troop.SearchNetLabel;
import com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.itemview.QSearchBaseSingleItemView;
import com.tencent.hippykotlin.demo.pages.qsearch_detail_page.util.ISearchReport;
import com.tencent.hippykotlin.demo.pages.qsearch_detail_page.view.QSearchGrayBorderButtonAttr;
import com.tencent.hippykotlin.demo.pages.qsearch_detail_page.view.QSearchGrayBorderButtonEvent;
import com.tencent.hippykotlin.demo.pages.qsearch_detail_page.view.QSearchGrayBorderButtonView;
import com.tencent.hippykotlin.demo.pages.qsearch_detail_page.view.QSearchGrayBorderButtonViewKt;
import com.tencent.hippykotlin.demo.pages.qsearch_detail_page.view.adapt_width.HighlightAttr;
import com.tencent.hippykotlin.demo.pages.qsearch_detail_page.view.adapt_width.HighlightTextView;
import com.tencent.hippykotlin.demo.pages.qsearch_detail_page.view.adapt_width.HighlightTextViewKt;
import com.tencent.hippykotlin.demo.pages.qsearch_detail_page.view.adapt_width.TroopTagAttr;
import com.tencent.hippykotlin.demo.pages.qsearch_detail_page.view.adapt_width.TroopTagView;
import com.tencent.hippykotlin.demo.pages.qsearch_detail_page.view.adapt_width.TroopTagViewKt;
import com.tencent.kuikly.core.base.Attr;
import com.tencent.kuikly.core.base.ViewContainer;
import com.tencent.kuikly.core.base.attr.b;
import com.tencent.kuikly.core.base.event.ClickParams;
import com.tencent.kuikly.core.base.event.Event;
import com.tencent.kuikly.core.directives.BindDirectivesView;
import com.tencent.kuikly.core.directives.BindDirectivesViewKt;
import com.tencent.kuikly.core.nvi.serialization.json.e;
import com.tencent.kuikly.core.pager.b;
import com.tencent.kuikly.core.views.ImageView;
import com.tencent.kuikly.core.views.TextView;
import com.tencent.kuikly.core.views.af;
import com.tencent.kuikly.core.views.ah;
import com.tencent.kuikly.core.views.ce;
import com.tencent.kuikly.core.views.cg;
import com.tencent.kuikly.core.views.t;
import com.tencent.kuikly.core.views.u;
import com.tencent.kuikly.core.views.v;
import com.tencent.kuikly.core.views.w;
import cooperation.qqcircle.report.datong.QCircleDaTongConstant;
import java.util.Iterator;
import java.util.List;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;

/* compiled from: P */
/* loaded from: classes32.dex */
public final class GuildChannelSingleItemView extends QSearchBaseSingleItemView<GuildChannelSingleItemAttr, GuildChannelSingleItemEvent> {
    /* JADX WARN: Multi-variable type inference failed */
    public static final /* synthetic */ GuildChannelSingleItemAttr access$getAttr(GuildChannelSingleItemView guildChannelSingleItemView) {
        return (GuildChannelSingleItemAttr) guildChannelSingleItemView.getAttr();
    }

    @Override // com.tencent.kuikly.core.base.ComposeView
    public final Function1<ViewContainer<?, ?>, Unit> body() {
        return new Function1<ViewContainer<?, ?>, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.itemview.guild.channel.GuildChannelSingleItemView$body$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Unit invoke(ViewContainer<?, ?> viewContainer) {
                final GuildChannelSingleItemView guildChannelSingleItemView = GuildChannelSingleItemView.this;
                w.a(viewContainer, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.itemview.guild.channel.GuildChannelSingleItemView$body$1.1
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(v vVar) {
                        v vVar2 = vVar;
                        final GuildChannelSingleItemView guildChannelSingleItemView2 = GuildChannelSingleItemView.this;
                        vVar2.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.itemview.guild.channel.GuildChannelSingleItemView.body.1.1.1
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(t tVar) {
                                t tVar2 = tVar;
                                tVar2.paddingTop(12.0f);
                                tVar2.paddingBottom(13.0f);
                                tVar2.flexDirectionRow();
                                String eid = GuildChannelSingleItemView.access$getAttr(GuildChannelSingleItemView.this).getData().getEid();
                                if (eid == null) {
                                    eid = "em_search_channel_entry";
                                }
                                EcommerceExtKt.vr$default(tVar2, null, eid, GuildChannelSingleItemView.this.getReportParams(), null, String.valueOf(GuildChannelSingleItemView.access$getAttr(GuildChannelSingleItemView.this).getData().hashCode()), true, 9);
                                return Unit.INSTANCE;
                            }
                        });
                        final GuildChannelSingleItemView guildChannelSingleItemView3 = GuildChannelSingleItemView.this;
                        vVar2.event(new Function1<u, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.itemview.guild.channel.GuildChannelSingleItemView.body.1.1.2
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(u uVar) {
                                final u uVar2 = uVar;
                                final GuildChannelSingleItemView guildChannelSingleItemView4 = GuildChannelSingleItemView.this;
                                uVar2.click(new Function1<ClickParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.itemview.guild.channel.GuildChannelSingleItemView.body.1.1.2.1
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(ClickParams clickParams) {
                                        BridgeModule currentBridgeModule = Utils.INSTANCE.currentBridgeModule();
                                        long j3 = GuildChannelSingleItemView.access$getAttr(GuildChannelSingleItemView.this).getData().guildId;
                                        String str = GuildChannelSingleItemView.access$getAttr(GuildChannelSingleItemView.this).getData().joinGuildSig;
                                        String str2 = GuildChannelSingleItemView.access$getAttr(GuildChannelSingleItemView.this).getData().query;
                                        int joinStatus = GuildChannelSingleItemView.access$getAttr(GuildChannelSingleItemView.this).getData().getJoinStatus();
                                        String str3 = GuildChannelSingleItemView.access$getAttr(GuildChannelSingleItemView.this).traceId;
                                        b pager = uVar2.getPager();
                                        ISearchReport iSearchReport = pager instanceof ISearchReport ? (ISearchReport) pager : null;
                                        BridgeModule.openGuildChannel$default(currentBridgeModule, j3, str, str2, joinStatus, str3, "qq_network_search_channel", String.valueOf(iSearchReport != null ? Integer.valueOf(iSearchReport.getQuerySource()) : null), 192);
                                        return Unit.INSTANCE;
                                    }
                                });
                                return Unit.INSTANCE;
                            }
                        });
                        final GuildChannelSingleItemView guildChannelSingleItemView4 = GuildChannelSingleItemView.this;
                        w.a(vVar2, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.itemview.guild.channel.GuildChannelSingleItemView.body.1.1.3
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(v vVar3) {
                                v vVar4 = vVar3;
                                vVar4.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.itemview.guild.channel.GuildChannelSingleItemView.body.1.1.3.1
                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(t tVar) {
                                        tVar.size(52.0f, 52.0f);
                                        return Unit.INSTANCE;
                                    }
                                });
                                final GuildChannelSingleItemView guildChannelSingleItemView5 = GuildChannelSingleItemView.this;
                                ah.a(vVar4, new Function1<ImageView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.itemview.guild.channel.GuildChannelSingleItemView.body.1.1.3.2
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(ImageView imageView) {
                                        final GuildChannelSingleItemView guildChannelSingleItemView6 = GuildChannelSingleItemView.this;
                                        imageView.attr(new Function1<af, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.itemview.guild.channel.GuildChannelSingleItemView.body.1.1.3.2.1
                                            {
                                                super(1);
                                            }

                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(af afVar) {
                                                af afVar2 = afVar;
                                                afVar2.size(52.0f, 52.0f);
                                                b.a.b(afVar2, GuildChannelSingleItemView.access$getAttr(GuildChannelSingleItemView.this).getData().coverUrl, false, 2, null);
                                                afVar2.borderRadius(4.0f);
                                                return Unit.INSTANCE;
                                            }
                                        });
                                        return Unit.INSTANCE;
                                    }
                                });
                                final GuildChannelSingleItemView guildChannelSingleItemView6 = GuildChannelSingleItemView.this;
                                ah.a(vVar4, new Function1<ImageView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.itemview.guild.channel.GuildChannelSingleItemView.body.1.1.3.3
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(ImageView imageView) {
                                        final GuildChannelSingleItemView guildChannelSingleItemView7 = GuildChannelSingleItemView.this;
                                        imageView.attr(new Function1<af, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.itemview.guild.channel.GuildChannelSingleItemView.body.1.1.3.3.1
                                            {
                                                super(1);
                                            }

                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(af afVar) {
                                                String str;
                                                af afVar2 = afVar;
                                                afVar2.positionAbsolute();
                                                afVar2.m142left(34.0f);
                                                afVar2.m150top(34.0f);
                                                afVar2.size(24.0f, 24.0f);
                                                int i3 = GuildChannelSingleItemView.access$getAttr(GuildChannelSingleItemView.this).getData().status;
                                                if (i3 != 1) {
                                                    str = "data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAAEgAAABICAMAAABiM0N1AAAAsVBMVEUAAAAODg4LCwsGBgYEBAQLCwsFBQUHBwf+/v7j4+Py8vLV1dX+/v77+/uLi4vo6Oj19fX////29vbPz8+rq6v9/f37+/vw8PD6+vrt7e37+/u3t7fc3NzR0dH4+Pjt7e34+Pj+/v739/f8/Pzz8/P7+/v6+vr///8Amf/f8v9As/+/5v/v+P8gpv8gpf8Qn//P7P+f2f+AzP+v3/+g2f9fv/9wxv9vxf9PuP8wrP+Q0v9FlKeuAAAAJ3RSTlMABQcJDwsNDOFIQ03woh5pZO+lOxjSwoiDeHItJRSUM8TAtLGXkpNIOqX8AAADCklEQVRYw+2X6XLiMBCEM5JlO9hAuHJB7mTHYMKZc9//wXakUAnSCMV4f6Uq/QOqXMVX3T3SAAe/+tVuwcWoQbq6APgPRuPhpoMbdW4eGnVgAI0mQWx1mg3Yl3M0QK/SI4B93KSMUAd1cYdBNUdQzw43dQUVQOdYQeffk06xkk4BgrGAOFVJlXPVTwdwhR5Nx2MvaffhhJFnXstJQZo8eWbXhx0c0URX4/dio0du607AjmvBOY+E4KRwOAAe7Iuj4/FwAnzBuKFlYalEV0ecBCC4oTcb9IauBh6QOESmuQ16DByB4MiwcORZBALASSY7dUB5X/BkdUB46ILkn3qgS8pmJzuuBzoWwgIJmdcD5dIB9bEeCPs2SPac1VGWUw7aPLc0EhAaWqkvBAeZ5+7YALYdcdATO9lzun0cJLcdCRe0KIq/iLTTnOu/KoqFA9oeGzAQmZmw2/9k0BgGDdEWfYJanW1zZrTo+FbqWfMXbPzrolhRwvlWQ7Qhn7UtWy1pl63cAzkzbSxmn34WxtDMPZBKbnMI5F6R8mNLj18Mar6a6g3ODR0rIQ4sR5fo6MWQSIuy/Hgnziu7tEpXFBqbKaQgIxtNV9TXM18jUhyABWrlyD2Rqee1Lmf9ShjuB/NEuo4Sz6pdWuOfr5Gpq2wQzV9RthDqXafkyQjkfBmpeIBcOhV1PFuO0ac0Nl072dro10QfZ7/aCZ0id2kncRoAhQw5llSSBUF+Qx6QlNHtfqBuvKmatdRK9wGlQ2OISUgVZzt++nln1ouUFwRApDOsrLMvDm8piU6qck5iPTID4iRRnXQSUdN+DmXTNUVn1XIlVjBOIk+97//UZNoPC8Y8Dbthzm2Lc/yNR+00bCfmufzpdqMG7UjbYX58JIqnUVk3Z/uwm0WaQ36YIe/BJBKhiHV/nX9Cru+zFlGihOxwP/6edOdUulGrl5GGxNBKlFICLEzQE5EIlWjWl+KYMMzN9yyN0rAkJhmI6ZjZqeCKejfODIIgpmKGqcYyAmGYGlNXYJLoMPRKbz9K/wDCIIlB85D1RgAAAABJRU5ErkJggg==";
                                                    if (i3 != 4 && i3 != 6) {
                                                        if (i3 == 9) {
                                                            str = "data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAAEgAAABICAMAAABiM0N1AAAAqFBMVEUAAAAPDw8KCgoGBgYFBQX5+fn+/v7j4+P+/v79/f26urr7+/vS0tL19fXIyMjt7e2Li4vo6Oj19fXb29v////9/f36+vrw8PD6+vrt7e37+/vMzMzp6en4+Pj7+/v09PT///8Amf/f8v8gpv/v+f8Qn/9Asv8wrP8gpf+/5v+Q0/9fv/+f2f/P7P+v3/9/zP+AzP+g2f/P6/9vxv9Quf9QuP+w3/8wq/9mW9F2AAAAIHRSTlMABQgLD6TwSOHgFsJNQylFHmlkS+/Ss4iDeHI8NJSSlmhh8z0AAANDSURBVFjD7ZjncuIwFIWRWwCDaYEUUuQKmJoQsu//ZqturoRb9tfO5CSTCUj+5pxzZWdC51e/KhfqB0Oilz5C/8AYvfn3WOjefxv+BIbQ0FUQBXOHqC1nOsc31Z0i1MLNqItNtUf1F7hSboCalaPbMU29oAagZ9xAz/WkR9xIjwhV51KcelLrXO3TIfSCW2iESkFBtw2o20dlhlxsKtnvdrvD5hZpUVI4mpqUPAuFso+m4RAygp3S8EqxgeresoQMQ9Eq1BRH1OU2wlJTC5kcSzO0T0Nd64hwVuEBS81vgUZlnDSO02tO+FnVErJcmCsWlGPEsPlacUJcyLUQ0pPB56GY1jHBUrnkxLiQ10e6oTvA2XE74PhwDgThkQF6A5fwYAd2lC7x6sInzzgQ9EqywWT+9fKGXbHlXRWT35og3wB5ak1dEXFOQUpMkKeBrD5ItpKGslApky9TsLVvQRB8gPCGRMT0vGXniDSfswWwNYAgOLSI7Gbn7sQSCmCO8aeMXOiOZKsBRbyrTE7xVCxAUKcedKbJEtJySkH1jpAGSnhH4lxe9vsv8fpb78gEBWCVlXtiTpTW8liswNYlAZWPP5ZjzgvQh3x/C7aONZDtgXOk7pCj5BzVHXgAB9K2rjkE5Gv3vpzXjkGzjbpd1sCQT0HA0asBWkdihptNwkYQK2uFXg3QHQAJThKBR53Aw6FZHdCRNfbA1DhnlZ7EdckpVZ3DiqAjYskFB5JxeD3nPD9nRedArk2HBrPNiuVvyYEyOXjGKoKOnLla3n/RQLt6Ts+hIEiy7QnWtFlDzJ8N1jQRHJjN6WFdO4Kq+OPfs2+CREtQ+/wri+Nsm6upQ0MSBFta4FZyYUPFUbLHvTacXgAMgZZmbUBLBxwiEM5+as55coAhACKeHppyHhwbGoKWFKmeA4OZlpynhrkgxyTZzrJXO68Z9aODTE+BW81ZjLkfyIHinpxJr9oOGFhVunLUfEIotpnLJNHZMdTA9XSK5w4cwKkzxVCU9e57CuK/D8b0TY5p9M+oyMc1Xg6IAsLgFFBzLUm5gqIUkKqpKy5KIN+SQjmtSIxlCZxFINzMTz7VkDDyg3zpXtqzOhSAOvS3/0p/AYx5R2nJC6u6AAAAAElFTkSuQmCC";
                                                        } else if (i3 != 17) {
                                                        }
                                                    }
                                                } else {
                                                    str = "data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAAEgAAABICAMAAABiM0N1AAAAolBMVEUAAAARERELCwsICAgEBAQGBgb+/v7////j4+PV1dX4+Pj19fX7+/vt7e3o6Oj19fWioqL29vbPz8+Ghob9/f37+/vt7e37+/u3t7fc3Nz5+fnt7e3W1tb4+Pj+/v739/f8/Pzw8PDw8PC+vr77+/v///8Amf+/5v+g2f8gpv/f8v/P7P9fv//v+P8gpf+Q0v9wxv9Quf9As/8QoP+w3/9Asv8bBdIqAAAAJXRSTlMABAcKDw3h8EhNlEOiRWlkGaU7H9LCeHItJYMzFMTAtLGIhxWC4ZjBiQAAAnlJREFUWMPt2H1P2zAQBnBix06Tpu+ltJS3wa6FUjo2tu//1XY9LJ0T58VO9tfEQyWQUH967pxEai++8v8l+vzBF/7dGaHcbIaY7VOE6WSdjVF2l4BJcpcNCQt2hrlBOEl+tgIQZCZLqIyeoOQ/1EgDJ5TiOjcP0Jh8g5TPcjS0RG+xdatzBR65QqhlPdfglWuUGp3vAP0lnqvjdNxnCwEZ1UMbHQLpp6jGETkE5UHQdC408RV4OJbsDelQSHMle7AJBGeCkgvpcGgp3EZiBFZe907earbUeGTHnZuXV3CTl2aLEEr43793VfkFlP1PS0ymRQmdAXCeK6EXwLxh2Wd7NrMlhjIv6MfHrghlphFPdukB7f/gryJ0KWwJHZm0Q++7nQMlsgRNoRXCuBDgtgsrmneFNqVGg67QgCFMX4idPpCwIfmvILHuCs2lfWyix/FLvJz51KTHBflxrLkgbUhIn1vkcHJvESlEEfK8aU8lKJPle83zMXI4FqGBA02tJe2bH2wHa0XKHBpfSCoHznuFczqAm5mkRhyBswU9/HmyYqNzpSUER58nc6BxODRW5nK0KKmU7leIK6UdCjHE5ybj+zBnpsyqnUoLHTTYmgq5UOhw81gyZEuRlGrl76yM44Qqxd98nUfFg/WRHmN2HOhTWvnNpXiwKkmiNNdtjE7ZqYRMp/Ws2blfNDs8XTzWzXXYaelUTy3HMdUhp1UiKp25H45naWwcwU7zeEihld3yx/XbLF2gwn3aJYGnd25FWcxTzBoNDCq0HWZ85qNaVpQihh0/ilohZkIItWHGuxX2EpIjMOz4S2RRInphun7N4uSiT+jt/kj//AVXU3L4vtKXCAAAAABJRU5ErkJggg==";
                                                }
                                                b.a.b(afVar2, str, false, 2, null);
                                                return Unit.INSTANCE;
                                            }
                                        });
                                        return Unit.INSTANCE;
                                    }
                                });
                                return Unit.INSTANCE;
                            }
                        });
                        final GuildChannelSingleItemView guildChannelSingleItemView5 = GuildChannelSingleItemView.this;
                        w.a(vVar2, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.itemview.guild.channel.GuildChannelSingleItemView.body.1.1.4
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(v vVar3) {
                                v vVar4 = vVar3;
                                vVar4.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.itemview.guild.channel.GuildChannelSingleItemView.body.1.1.4.1
                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(t tVar) {
                                        t tVar2 = tVar;
                                        tVar2.m140flex(1.0f);
                                        tVar2.marginLeft(12.0f);
                                        tVar2.alignSelfCenter();
                                        return Unit.INSTANCE;
                                    }
                                });
                                final GuildChannelSingleItemView guildChannelSingleItemView6 = GuildChannelSingleItemView.this;
                                HighlightTextViewKt.HighlightText(vVar4, new Function1<HighlightTextView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.itemview.guild.channel.GuildChannelSingleItemView.body.1.1.4.2
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(HighlightTextView highlightTextView) {
                                        final GuildChannelSingleItemView guildChannelSingleItemView7 = GuildChannelSingleItemView.this;
                                        highlightTextView.attr(new Function1<HighlightAttr, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.itemview.guild.channel.GuildChannelSingleItemView.body.1.1.4.2.1
                                            {
                                                super(1);
                                            }

                                            /* JADX WARN: Type inference failed for: r1v9, types: [kotlin.jvm.internal.Lambda, com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.itemview.guild.channel.GuildChannelSingleItemView$buildTitleTail$1] */
                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(HighlightAttr highlightAttr) {
                                                HighlightAttr highlightAttr2 = highlightAttr;
                                                highlightAttr2.mo141height(FontModuleExtKt.qqFontScaleAddSize(17.0f) + 24.0f);
                                                highlightAttr2.justifyContentCenter();
                                                highlightAttr2.text = GuildChannelSingleItemView.access$getAttr(GuildChannelSingleItemView.this).getData().title;
                                                highlightAttr2.highlightText = GuildChannelSingleItemView.access$getAttr(GuildChannelSingleItemView.this).keyword;
                                                highlightAttr2.fontSize = 17.0f;
                                                final GuildChannelSingleItemView guildChannelSingleItemView8 = GuildChannelSingleItemView.this;
                                                guildChannelSingleItemView8.getClass();
                                                highlightAttr2.tailContentBuilder = new Function1<ViewContainer<?, ?>, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.itemview.guild.channel.GuildChannelSingleItemView$buildTitleTail$1
                                                    {
                                                        super(1);
                                                    }

                                                    @Override // kotlin.jvm.functions.Function1
                                                    public final Unit invoke(ViewContainer<?, ?> viewContainer2) {
                                                        final GuildChannelSingleItemView guildChannelSingleItemView9 = GuildChannelSingleItemView.this;
                                                        w.a(viewContainer2, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.itemview.guild.channel.GuildChannelSingleItemView$buildTitleTail$1.1
                                                            {
                                                                super(1);
                                                            }

                                                            /* JADX WARN: Type inference failed for: r0v4, types: [java.util.List<java.lang.String>, java.util.ArrayList] */
                                                            @Override // kotlin.jvm.functions.Function1
                                                            public final Unit invoke(v vVar5) {
                                                                v vVar6 = vVar5;
                                                                vVar6.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.itemview.guild.channel.GuildChannelSingleItemView.buildTitleTail.1.1.1
                                                                    @Override // kotlin.jvm.functions.Function1
                                                                    public final Unit invoke(t tVar) {
                                                                        tVar.flexDirectionRow();
                                                                        return Unit.INSTANCE;
                                                                    }
                                                                });
                                                                Iterator it = GuildChannelSingleItemView.access$getAttr(GuildChannelSingleItemView.this).getData().icons.iterator();
                                                                final int i3 = 0;
                                                                while (it.hasNext()) {
                                                                    Object next = it.next();
                                                                    int i16 = i3 + 1;
                                                                    if (i3 < 0) {
                                                                        CollectionsKt__CollectionsKt.throwIndexOverflow();
                                                                    }
                                                                    final String str = (String) next;
                                                                    ah.a(vVar6, new Function1<ImageView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.itemview.guild.channel.GuildChannelSingleItemView$buildTitleTail$1$1$2$1
                                                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                                        {
                                                                            super(1);
                                                                        }

                                                                        @Override // kotlin.jvm.functions.Function1
                                                                        public final Unit invoke(ImageView imageView) {
                                                                            final int i17 = i3;
                                                                            final String str2 = str;
                                                                            imageView.attr(new Function1<af, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.itemview.guild.channel.GuildChannelSingleItemView$buildTitleTail$1$1$2$1.1
                                                                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                                                {
                                                                                    super(1);
                                                                                }

                                                                                @Override // kotlin.jvm.functions.Function1
                                                                                public final Unit invoke(af afVar) {
                                                                                    af afVar2 = afVar;
                                                                                    afVar2.size(16.0f, 16.0f);
                                                                                    afVar2.marginLeft(i17 == 0 ? 4.0f : 2.0f);
                                                                                    b.a.b(afVar2, str2, false, 2, null);
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
                                                        return Unit.INSTANCE;
                                                    }
                                                };
                                                highlightAttr2.isIgnoreCase = true;
                                                return Unit.INSTANCE;
                                            }
                                        });
                                        return Unit.INSTANCE;
                                    }
                                });
                                final List<SearchNetLabel> list = GuildChannelSingleItemView.access$getAttr(GuildChannelSingleItemView.this).getData().topLabelList;
                                new Function1<ViewContainer<?, ?>, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.itemview.guild.channel.GuildChannelSingleItemView$buildLabel$1
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(ViewContainer<?, ?> viewContainer2) {
                                        final List<SearchNetLabel> list2 = list;
                                        TroopTagViewKt.TroopTag(viewContainer2, new Function1<TroopTagView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.itemview.guild.channel.GuildChannelSingleItemView$buildLabel$1.1
                                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                            {
                                                super(1);
                                            }

                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(TroopTagView troopTagView) {
                                                final List<SearchNetLabel> list3 = list2;
                                                troopTagView.attr(new Function1<TroopTagAttr, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.itemview.guild.channel.GuildChannelSingleItemView.buildLabel.1.1.1
                                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                    {
                                                        super(1);
                                                    }

                                                    @Override // kotlin.jvm.functions.Function1
                                                    public final Unit invoke(TroopTagAttr troopTagAttr) {
                                                        TroopTagAttr troopTagAttr2 = troopTagAttr;
                                                        troopTagAttr2.marginTop(5.0f);
                                                        troopTagAttr2.labelList = list3;
                                                        return Unit.INSTANCE;
                                                    }
                                                });
                                                return Unit.INSTANCE;
                                            }
                                        });
                                        return Unit.INSTANCE;
                                    }
                                }.invoke(vVar4);
                                if (GuildChannelSingleItemView.access$getAttr(GuildChannelSingleItemView.this).getData().subTitle.length() > 0) {
                                    final GuildChannelSingleItemView guildChannelSingleItemView7 = GuildChannelSingleItemView.this;
                                    cg.a(vVar4, new Function1<TextView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.itemview.guild.channel.GuildChannelSingleItemView.body.1.1.4.3
                                        {
                                            super(1);
                                        }

                                        @Override // kotlin.jvm.functions.Function1
                                        public final Unit invoke(TextView textView) {
                                            final GuildChannelSingleItemView guildChannelSingleItemView8 = GuildChannelSingleItemView.this;
                                            textView.attr(new Function1<ce, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.itemview.guild.channel.GuildChannelSingleItemView.body.1.1.4.3.1
                                                {
                                                    super(1);
                                                }

                                                @Override // kotlin.jvm.functions.Function1
                                                public final Unit invoke(ce ceVar) {
                                                    ce ceVar2 = ceVar;
                                                    ceVar2.marginTop(5.0f);
                                                    ceVar2.text(GuildChannelSingleItemView.access$getAttr(GuildChannelSingleItemView.this).getData().subTitle);
                                                    ceVar2.lines(2);
                                                    ceVar2.textOverFlowTail();
                                                    ceVar2.color(QUISkinColor.INSTANCE.wrapColor("text_secondary"));
                                                    ceVar2.fontWeight400();
                                                    ce.fontSize$default(ceVar2, 14.0f, null, 2, null);
                                                    return Unit.INSTANCE;
                                                }
                                            });
                                            return Unit.INSTANCE;
                                        }
                                    });
                                }
                                final List<SearchNetLabel> list2 = GuildChannelSingleItemView.access$getAttr(GuildChannelSingleItemView.this).getData().bottomLabelList;
                                new Function1<ViewContainer<?, ?>, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.itemview.guild.channel.GuildChannelSingleItemView$buildLabel$1
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(ViewContainer<?, ?> viewContainer2) {
                                        final List<SearchNetLabel> list22 = list2;
                                        TroopTagViewKt.TroopTag(viewContainer2, new Function1<TroopTagView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.itemview.guild.channel.GuildChannelSingleItemView$buildLabel$1.1
                                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                            {
                                                super(1);
                                            }

                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(TroopTagView troopTagView) {
                                                final List<SearchNetLabel> list3 = list22;
                                                troopTagView.attr(new Function1<TroopTagAttr, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.itemview.guild.channel.GuildChannelSingleItemView.buildLabel.1.1.1
                                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                    {
                                                        super(1);
                                                    }

                                                    @Override // kotlin.jvm.functions.Function1
                                                    public final Unit invoke(TroopTagAttr troopTagAttr) {
                                                        TroopTagAttr troopTagAttr2 = troopTagAttr;
                                                        troopTagAttr2.marginTop(5.0f);
                                                        troopTagAttr2.labelList = list3;
                                                        return Unit.INSTANCE;
                                                    }
                                                });
                                                return Unit.INSTANCE;
                                            }
                                        });
                                        return Unit.INSTANCE;
                                    }
                                }.invoke(vVar4);
                                return Unit.INSTANCE;
                            }
                        });
                        final GuildChannelSingleItemView guildChannelSingleItemView6 = GuildChannelSingleItemView.this;
                        Function0<Object> function0 = new Function0<Object>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.itemview.guild.channel.GuildChannelSingleItemView.body.1.1.5
                            {
                                super(0);
                            }

                            @Override // kotlin.jvm.functions.Function0
                            public final Object invoke() {
                                return Integer.valueOf(GuildChannelSingleItemView.access$getAttr(GuildChannelSingleItemView.this).getData().getJoinStatus());
                            }
                        };
                        final GuildChannelSingleItemView guildChannelSingleItemView7 = GuildChannelSingleItemView.this;
                        BindDirectivesViewKt.a(vVar2, function0, new Function1<BindDirectivesView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.itemview.guild.channel.GuildChannelSingleItemView.body.1.1.6
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(BindDirectivesView bindDirectivesView) {
                                final GuildChannelSingleItemView guildChannelSingleItemView8 = GuildChannelSingleItemView.this;
                                w.a(bindDirectivesView, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.itemview.guild.channel.GuildChannelSingleItemView.body.1.1.6.1
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(v vVar3) {
                                        v vVar4 = vVar3;
                                        vVar4.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.itemview.guild.channel.GuildChannelSingleItemView.body.1.1.6.1.1
                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(t tVar) {
                                                t tVar2 = tVar;
                                                tVar2.marginLeft(12.0f);
                                                tVar2.justifyContentCenter();
                                                tVar2.alignSelfCenter();
                                                return Unit.INSTANCE;
                                            }
                                        });
                                        final GuildChannelSingleItemView guildChannelSingleItemView9 = GuildChannelSingleItemView.this;
                                        QSearchGrayBorderButtonViewKt.QSearchGrayBorderButton(vVar4, new Function1<QSearchGrayBorderButtonView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.itemview.guild.channel.GuildChannelSingleItemView.body.1.1.6.1.2
                                            {
                                                super(1);
                                            }

                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(QSearchGrayBorderButtonView qSearchGrayBorderButtonView) {
                                                QSearchGrayBorderButtonView qSearchGrayBorderButtonView2 = qSearchGrayBorderButtonView;
                                                final GuildChannelSingleItemView guildChannelSingleItemView10 = GuildChannelSingleItemView.this;
                                                qSearchGrayBorderButtonView2.attr(new Function1<QSearchGrayBorderButtonAttr, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.itemview.guild.channel.GuildChannelSingleItemView.body.1.1.6.1.2.1
                                                    {
                                                        super(1);
                                                    }

                                                    @Override // kotlin.jvm.functions.Function1
                                                    public final Unit invoke(QSearchGrayBorderButtonAttr qSearchGrayBorderButtonAttr) {
                                                        QSearchGrayBorderButtonAttr qSearchGrayBorderButtonAttr2 = qSearchGrayBorderButtonAttr;
                                                        if (GuildChannelSingleItemView.access$getAttr(GuildChannelSingleItemView.this).getData().getJoinStatus() == 2) {
                                                            qSearchGrayBorderButtonAttr2.text = "\u5df2\u52a0\u5165";
                                                            qSearchGrayBorderButtonAttr2.status = 2;
                                                        } else {
                                                            qSearchGrayBorderButtonAttr2.text = "\u52a0\u5165";
                                                            qSearchGrayBorderButtonAttr2.status = 0;
                                                        }
                                                        EcommerceExtKt.vr$default(qSearchGrayBorderButtonAttr2, null, "em_bas_search_channel_enter", GuildChannelSingleItemView.this.getReportParams(), null, null, true, 25);
                                                        qSearchGrayBorderButtonAttr2.accessibility(qSearchGrayBorderButtonAttr2.text + "\u6309\u94ae");
                                                        return Unit.INSTANCE;
                                                    }
                                                });
                                                if (!(GuildChannelSingleItemView.access$getAttr(GuildChannelSingleItemView.this).getData().getJoinStatus() == 2)) {
                                                    final GuildChannelSingleItemView guildChannelSingleItemView11 = GuildChannelSingleItemView.this;
                                                    qSearchGrayBorderButtonView2.event(new Function1<QSearchGrayBorderButtonEvent, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.itemview.guild.channel.GuildChannelSingleItemView.body.1.1.6.1.2.2
                                                        {
                                                            super(1);
                                                        }

                                                        @Override // kotlin.jvm.functions.Function1
                                                        public final Unit invoke(QSearchGrayBorderButtonEvent qSearchGrayBorderButtonEvent) {
                                                            final GuildChannelSingleItemView guildChannelSingleItemView12 = GuildChannelSingleItemView.this;
                                                            qSearchGrayBorderButtonEvent.click(new Function1<ClickParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.itemview.guild.channel.GuildChannelSingleItemView.body.1.1.6.1.2.2.1
                                                                {
                                                                    super(1);
                                                                }

                                                                @Override // kotlin.jvm.functions.Function1
                                                                public final Unit invoke(ClickParams clickParams) {
                                                                    SearchGuildChannelItemModel data = GuildChannelSingleItemView.access$getAttr(GuildChannelSingleItemView.this).getData();
                                                                    final GuildChannelSingleItemView guildChannelSingleItemView13 = GuildChannelSingleItemView.this;
                                                                    Function1<e, Unit> function1 = new Function1<e, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.itemview.guild.channel.GuildChannelSingleItemView.body.1.1.6.1.2.2.1.1
                                                                        {
                                                                            super(1);
                                                                        }

                                                                        @Override // kotlin.jvm.functions.Function1
                                                                        public final Unit invoke(e eVar) {
                                                                            e eVar2 = eVar;
                                                                            int j3 = eVar2 != null ? eVar2.j("code") : -1;
                                                                            if (j3 == 0) {
                                                                                SearchGuildChannelItemModel data2 = GuildChannelSingleItemView.access$getAttr(GuildChannelSingleItemView.this).getData();
                                                                                data2.joinStatus$delegate.setValue(data2, SearchGuildChannelItemModel.$$delegatedProperties[0], 2);
                                                                            } else {
                                                                                Utils.INSTANCE.logToNative("GuildChannelSingleItemView joinGuildChannel failed, code=" + j3);
                                                                            }
                                                                            return Unit.INSTANCE;
                                                                        }
                                                                    };
                                                                    e eVar = new e();
                                                                    eVar.v("guildId", String.valueOf(data.guildId));
                                                                    eVar.v("joinGuildSig", data.joinGuildSig);
                                                                    eVar.u("guildOwnerUin", data.guildOwnerUin);
                                                                    eVar.v("mainSource", "search");
                                                                    eVar.v("subSource", "qq_network_search_channel");
                                                                    Utils.INSTANCE.currentBridgeModule().callNativeMethod("joinGuildChannel", eVar, function1);
                                                                    return Unit.INSTANCE;
                                                                }
                                                            });
                                                            return Unit.INSTANCE;
                                                        }
                                                    });
                                                }
                                                return Unit.INSTANCE;
                                            }
                                        });
                                        return Unit.INSTANCE;
                                    }
                                });
                                return Unit.INSTANCE;
                            }
                        });
                        if (GuildChannelSingleItemView.access$getAttr(GuildChannelSingleItemView.this).showDivider) {
                            w.a(vVar2, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.itemview.guild.channel.GuildChannelSingleItemView.body.1.1.7
                                @Override // kotlin.jvm.functions.Function1
                                public final Unit invoke(v vVar3) {
                                    vVar3.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.itemview.guild.channel.GuildChannelSingleItemView.body.1.1.7.1
                                        @Override // kotlin.jvm.functions.Function1
                                        public final Unit invoke(t tVar) {
                                            t tVar2 = tVar;
                                            tVar2.positionAbsolute();
                                            tVar2.m138bottom(0.5f);
                                            tVar2.m149right(0.0f);
                                            tVar2.m142left(64.0f);
                                            tVar2.mo141height(0.5f);
                                            tVar2.mo113backgroundColor(QUISkinColor.INSTANCE.wrapColor("border_standard"));
                                            return Unit.INSTANCE;
                                        }
                                    });
                                    return Unit.INSTANCE;
                                }
                            });
                        }
                        return Unit.INSTANCE;
                    }
                });
                return Unit.INSTANCE;
            }
        };
    }

    @Override // com.tencent.kuikly.core.base.AbstractBaseView
    public final Attr createAttr() {
        return new GuildChannelSingleItemAttr();
    }

    @Override // com.tencent.kuikly.core.base.AbstractBaseView
    public final Event createEvent() {
        return new GuildChannelSingleItemEvent();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.itemview.QSearchBaseSingleItemView
    public final e getReportParams() {
        e reportParams = super.getReportParams();
        reportParams.u("sgrp_channel_id", ((GuildChannelSingleItemAttr) getAttr()).getData().guildId);
        reportParams.v(QCircleDaTongConstant.ElementParamKey.SGRP_CHANNEL_NAME, ((GuildChannelSingleItemAttr) getAttr()).getData().title);
        reportParams.u("founder_uin", ((GuildChannelSingleItemAttr) getAttr()).getData().guildOwnerUin);
        if (((GuildChannelSingleItemAttr) getAttr()).filterTag.length() > 0) {
            reportParams.v("filter_tag", ((GuildChannelSingleItemAttr) getAttr()).filterTag);
        }
        e mergeTransferInfo = TemplateItemsKt.mergeTransferInfo(((GuildChannelSingleItemAttr) getAttr()).getData().getReportInfo(), reportParams);
        if (mergeTransferInfo != null) {
            mergeTransferInfo.t("doc_position", ((GuildChannelSingleItemAttr) getAttr()).index);
        }
        if (mergeTransferInfo != null) {
            mergeTransferInfo.t("serial_number", ((GuildChannelSingleItemAttr) getAttr()).getData().serialNumber);
        }
        reportParams.v("transfer_info", mergeTransferInfo);
        return reportParams;
    }
}

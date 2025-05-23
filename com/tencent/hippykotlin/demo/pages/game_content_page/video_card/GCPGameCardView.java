package com.tencent.hippykotlin.demo.pages.game_content_page.video_card;

import com.tencent.hippykotlin.demo.pages.base.BridgeModule;
import com.tencent.hippykotlin.demo.pages.base.SkinColor;
import com.tencent.hippykotlin.demo.pages.base.Utils;
import com.tencent.hippykotlin.demo.pages.game_content_page.content_banner.GCPGameButton;
import com.tencent.hippykotlin.demo.pages.game_content_page.content_banner.GCPGameButtonAttr;
import com.tencent.hippykotlin.demo.pages.game_content_page.content_banner.GCPGameMetaInfoBarAttr;
import com.tencent.hippykotlin.demo.pages.game_content_page.content_banner.GCPGameMetaInfoView;
import com.tencent.hippykotlin.demo.pages.game_content_page.repo.data.advertisement.Button;
import com.tencent.hippykotlin.demo.pages.game_content_page.repo.data.advertisement.GameBasicInfo;
import com.tencent.hippykotlin.demo.pages.game_content_page.repo.data.advertisement.GameDownLoadInfo;
import com.tencent.hippykotlin.demo.pages.game_content_page.repo.data.advertisement.GameInfo;
import com.tencent.hippykotlin.demo.pages.game_content_page.repo.data.advertisement.GamePrivilegeInfo;
import com.tencent.hippykotlin.demo.pages.game_content_page.repo.data.advertisement.Redirect;
import com.tencent.hippykotlin.demo.pages.game_content_page.repo.data.gamefeed.AdCard;
import com.tencent.kuikly.core.base.Attr;
import com.tencent.kuikly.core.base.ComposeView;
import com.tencent.kuikly.core.base.ViewContainer;
import com.tencent.kuikly.core.base.attr.b;
import com.tencent.kuikly.core.base.event.ClickParams;
import com.tencent.kuikly.core.base.event.Event;
import com.tencent.kuikly.core.base.h;
import com.tencent.kuikly.core.base.l;
import com.tencent.kuikly.core.base.m;
import com.tencent.kuikly.core.directives.ConditionView;
import com.tencent.kuikly.core.directives.ConditionViewKt;
import com.tencent.kuikly.core.manager.BridgeManager;
import com.tencent.kuikly.core.views.ImageView;
import com.tencent.kuikly.core.views.TextView;
import com.tencent.kuikly.core.views.af;
import com.tencent.kuikly.core.views.ah;
import com.tencent.kuikly.core.views.ce;
import com.tencent.kuikly.core.views.cg;
import com.tencent.kuikly.core.views.compose.ButtonView;
import com.tencent.kuikly.core.views.compose.a;
import com.tencent.kuikly.core.views.compose.c;
import com.tencent.kuikly.core.views.t;
import com.tencent.kuikly.core.views.u;
import com.tencent.kuikly.core.views.v;
import com.tencent.kuikly.core.views.w;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.properties.ReadWriteProperty;
import kotlin.reflect.KProperty;

/* loaded from: classes31.dex */
public final class GCPGameCardView extends ComposeView<GCPGameCardViewAttr, l> {
    public static final /* synthetic */ int $r8$clinit = 0;

    /* JADX WARN: Multi-variable type inference failed */
    public static final /* synthetic */ GCPGameCardViewAttr access$getAttr(GCPGameCardView gCPGameCardView) {
        return (GCPGameCardViewAttr) gCPGameCardView.getAttr();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final boolean access$isGame(GCPGameCardView gCPGameCardView) {
        return ((GCPGameCardViewAttr) gCPGameCardView.getAttr()).uiType == 1;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final void access$onGoodsClick(GCPGameCardView gCPGameCardView) {
        String str;
        gCPGameCardView.getClass();
        BridgeModule bridgeModule = Utils.INSTANCE.bridgeModule(gCPGameCardView.getPagerId());
        ArrayList<Redirect> arrayList = ((GCPGameCardViewAttr) gCPGameCardView.getAttr()).getAdCard().jumpInfo;
        if (arrayList != null && (arrayList.isEmpty() ^ true)) {
            Iterator<Redirect> it = arrayList.iterator();
            while (it.hasNext()) {
                str = it.next().url;
                if (str.length() > 0) {
                    break;
                }
            }
        }
        str = "";
        BridgeModule.openPage$default(bridgeModule, str, false, null, null, 30);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.tencent.kuikly.core.base.ComposeView
    public final Function1<ViewContainer<?, ?>, Unit> body() {
        final AdCard adCard = ((GCPGameCardViewAttr) getAttr()).getAdCard();
        return new Function1<ViewContainer<?, ?>, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.game_content_page.video_card.GCPGameCardView$body$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Unit invoke(ViewContainer<?, ?> viewContainer) {
                ViewContainer<?, ?> viewContainer2 = viewContainer;
                final GCPGameCardView gCPGameCardView = GCPGameCardView.this;
                viewContainer2.attr(new Function1<m, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.game_content_page.video_card.GCPGameCardView$body$1.1
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(m mVar) {
                        m mVar2 = mVar;
                        mVar2.marginTop(8.0f);
                        mVar2.marginLeft(16.0f);
                        mVar2.marginRight(16.0f);
                        mVar2.mo141height(GCPGameCardView.access$getAttr(GCPGameCardView.this).getShowGameMetaInfoView() ? 63.0f : 52.0f);
                        mVar2.flexDirectionColumn();
                        mVar2.borderRadius(4.0f);
                        if (SkinColor.INSTANCE.isNightMode(mVar2.getPagerId())) {
                            mVar2.mo113backgroundColor(new h(1095652868095L));
                        } else {
                            mVar2.mo113backgroundColor(new h(4294309365L));
                        }
                        return Unit.INSTANCE;
                    }
                });
                final GCPGameCardView gCPGameCardView2 = GCPGameCardView.this;
                final AdCard adCard2 = adCard;
                w.a(viewContainer2, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.game_content_page.video_card.GCPGameCardView$body$1.2
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(v vVar) {
                        v vVar2 = vVar;
                        vVar2.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.game_content_page.video_card.GCPGameCardView.body.1.2.1
                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(t tVar) {
                                t tVar2 = tVar;
                                tVar2.mo141height(52.0f);
                                tVar2.alignItemsCenter();
                                tVar2.flexDirectionRow();
                                return Unit.INSTANCE;
                            }
                        });
                        final GCPGameCardView gCPGameCardView3 = GCPGameCardView.this;
                        vVar2.event(new Function1<u, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.game_content_page.video_card.GCPGameCardView.body.1.2.2
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(u uVar) {
                                final GCPGameCardView gCPGameCardView4 = GCPGameCardView.this;
                                uVar.click(new Function1<ClickParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.game_content_page.video_card.GCPGameCardView.body.1.2.2.1
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(ClickParams clickParams) {
                                        GCPGameCardView.access$onGoodsClick(GCPGameCardView.this);
                                        return Unit.INSTANCE;
                                    }
                                });
                                return Unit.INSTANCE;
                            }
                        });
                        final AdCard adCard3 = adCard2;
                        ah.a(vVar2, new Function1<ImageView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.game_content_page.video_card.GCPGameCardView.body.1.2.3
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(ImageView imageView) {
                                final AdCard adCard4 = AdCard.this;
                                imageView.attr(new Function1<af, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.game_content_page.video_card.GCPGameCardView.body.1.2.3.1
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(af afVar) {
                                        af afVar2 = afVar;
                                        afVar2.marginLeft(8.0f);
                                        afVar2.mo153width(36.0f);
                                        afVar2.mo141height(36.0f);
                                        b.a.b(afVar2, AdCard.this.picUrl, false, 2, null);
                                        return Unit.INSTANCE;
                                    }
                                });
                                return Unit.INSTANCE;
                            }
                        });
                        final AdCard adCard4 = adCard2;
                        w.a(vVar2, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.game_content_page.video_card.GCPGameCardView.body.1.2.4
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(v vVar3) {
                                v vVar4 = vVar3;
                                vVar4.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.game_content_page.video_card.GCPGameCardView.body.1.2.4.1
                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(t tVar) {
                                        t tVar2 = tVar;
                                        tVar2.marginLeft(8.0f);
                                        tVar2.m140flex(1.0f);
                                        return Unit.INSTANCE;
                                    }
                                });
                                final AdCard adCard5 = AdCard.this;
                                cg.a(vVar4, new Function1<TextView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.game_content_page.video_card.GCPGameCardView.body.1.2.4.2
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(TextView textView) {
                                        final AdCard adCard6 = AdCard.this;
                                        textView.attr(new Function1<ce, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.game_content_page.video_card.GCPGameCardView.body.1.2.4.2.1
                                            {
                                                super(1);
                                            }

                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(ce ceVar) {
                                                h blackTextColor;
                                                ce ceVar2 = ceVar;
                                                blackTextColor = SkinColor.INSTANCE.blackTextColor(BridgeManager.f117344a.u());
                                                ceVar2.color(blackTextColor);
                                                ce.fontSize$default(ceVar2, 13.0f, null, 2, null);
                                                ceVar2.fontFamily("PingFang SC");
                                                ceVar2.fontWeightMedium();
                                                ceVar2.text(AdCard.this.title);
                                                ceVar2.lines(1);
                                                return Unit.INSTANCE;
                                            }
                                        });
                                        return Unit.INSTANCE;
                                    }
                                });
                                final AdCard adCard6 = AdCard.this;
                                cg.a(vVar4, new Function1<TextView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.game_content_page.video_card.GCPGameCardView.body.1.2.4.3
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(TextView textView) {
                                        final AdCard adCard7 = AdCard.this;
                                        textView.attr(new Function1<ce, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.game_content_page.video_card.GCPGameCardView.body.1.2.4.3.1
                                            {
                                                super(1);
                                            }

                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(ce ceVar) {
                                                ce ceVar2 = ceVar;
                                                ceVar2.marginTop(4.0f);
                                                ceVar2.color(new h(4288256409L));
                                                ce.fontSize$default(ceVar2, 11.0f, null, 2, null);
                                                ceVar2.fontFamily("PingFang SC");
                                                ceVar2.text(AdCard.this.subTitle);
                                                ceVar2.lines(1);
                                                return Unit.INSTANCE;
                                            }
                                        });
                                        return Unit.INSTANCE;
                                    }
                                });
                                return Unit.INSTANCE;
                            }
                        });
                        final GCPGameCardView gCPGameCardView4 = GCPGameCardView.this;
                        Function0<Object> function0 = new Function0<Object>() { // from class: com.tencent.hippykotlin.demo.pages.game_content_page.video_card.GCPGameCardView.body.1.2.5
                            {
                                super(0);
                            }

                            @Override // kotlin.jvm.functions.Function0
                            public final Object invoke() {
                                return Boolean.valueOf(GCPGameCardView.access$isGame(GCPGameCardView.this));
                            }
                        };
                        final AdCard adCard5 = adCard2;
                        final GCPGameCardView gCPGameCardView5 = GCPGameCardView.this;
                        ConditionViewKt.c(vVar2, function0, new Function1<ConditionView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.game_content_page.video_card.GCPGameCardView.body.1.2.6
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(ConditionView conditionView) {
                                final AdCard adCard6 = AdCard.this;
                                final GCPGameCardView gCPGameCardView6 = gCPGameCardView5;
                                conditionView.addChild(new GCPGameButton(), new Function1<GCPGameButton, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.game_content_page.video_card.GCPGameCardView.body.1.2.6.1
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(GCPGameButton gCPGameButton) {
                                        final AdCard adCard7 = AdCard.this;
                                        final GCPGameCardView gCPGameCardView7 = gCPGameCardView6;
                                        gCPGameButton.attr(new Function1<GCPGameButtonAttr, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.game_content_page.video_card.GCPGameCardView.body.1.2.6.1.1
                                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                            {
                                                super(1);
                                            }

                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(GCPGameButtonAttr gCPGameButtonAttr) {
                                                String str;
                                                String str2;
                                                String str3;
                                                String str4;
                                                String str5;
                                                String str6;
                                                String str7;
                                                String str8;
                                                GameDownLoadInfo gameDownLoadInfo;
                                                GameDownLoadInfo gameDownLoadInfo2;
                                                GameBasicInfo gameBasicInfo;
                                                String str9;
                                                GameDownLoadInfo gameDownLoadInfo3;
                                                GameDownLoadInfo gameDownLoadInfo4;
                                                GameDownLoadInfo gameDownLoadInfo5;
                                                GameBasicInfo gameBasicInfo2;
                                                GameBasicInfo gameBasicInfo3;
                                                GameBasicInfo gameBasicInfo4;
                                                GCPGameButtonAttr gCPGameButtonAttr2 = gCPGameButtonAttr;
                                                GameInfo gameInfo = AdCard.this.gameInfo;
                                                String str10 = "";
                                                if (gameInfo == null || (gameBasicInfo4 = gameInfo.basic) == null || (str = Integer.valueOf(gameBasicInfo4.appId).toString()) == null) {
                                                    str = "";
                                                }
                                                gCPGameButtonAttr2.gameId = str;
                                                GameInfo gameInfo2 = AdCard.this.gameInfo;
                                                if (gameInfo2 == null || (gameBasicInfo3 = gameInfo2.basic) == null || (str2 = gameBasicInfo3.channelId) == null) {
                                                    str2 = "";
                                                }
                                                gCPGameButtonAttr2.channelId = str2;
                                                if (gameInfo2 == null || (gameBasicInfo2 = gameInfo2.basic) == null || (str3 = gameBasicInfo2.detailUrl) == null) {
                                                    str3 = "";
                                                }
                                                gCPGameButtonAttr2.detailUrl = str3;
                                                if (gameInfo2 == null || (gameDownLoadInfo5 = gameInfo2.download) == null || (str4 = gameDownLoadInfo5.iosDownloadUrl) == null) {
                                                    str4 = "";
                                                }
                                                ReadWriteProperty readWriteProperty = gCPGameButtonAttr2.appStoreUrl$delegate;
                                                KProperty<?>[] kPropertyArr = GCPGameButtonAttr.$$delegatedProperties;
                                                readWriteProperty.setValue(gCPGameButtonAttr2, kPropertyArr[1], str4);
                                                GameInfo gameInfo3 = AdCard.this.gameInfo;
                                                if (gameInfo3 == null || (gameDownLoadInfo4 = gameInfo3.download) == null || (str5 = gameDownLoadInfo4.androidDownloadUrl) == null) {
                                                    str5 = "";
                                                }
                                                gCPGameButtonAttr2.androidDownloadUrl$delegate.setValue(gCPGameButtonAttr2, kPropertyArr[2], str5);
                                                GameInfo gameInfo4 = AdCard.this.gameInfo;
                                                if (gameInfo4 == null || (gameDownLoadInfo3 = gameInfo4.download) == null || (str6 = gameDownLoadInfo3.pkgName) == null) {
                                                    str6 = "";
                                                }
                                                gCPGameButtonAttr2.packName$delegate.setValue(gCPGameButtonAttr2, kPropertyArr[0], str6);
                                                h.Companion companion = h.INSTANCE;
                                                Button button = AdCard.this.button;
                                                if (button == null || (str7 = button.buttonBgColor) == null) {
                                                    str7 = "4278229503";
                                                }
                                                gCPGameButtonAttr2.setButtonColor(companion.o(str7));
                                                gCPGameButtonAttr2.subscribeSucUrl$delegate.setValue(gCPGameButtonAttr2, kPropertyArr[11], AdCard.this.subscribeSucUrl);
                                                gCPGameButtonAttr2.scene = 2;
                                                gCPGameButtonAttr2.gameTab = GCPGameCardView.access$getAttr(gCPGameCardView7).gameTab;
                                                GameInfo gameInfo5 = AdCard.this.gameInfo;
                                                if (gameInfo5 != null && (gameBasicInfo = gameInfo5.basic) != null && (str9 = gameBasicInfo.appName) != null) {
                                                    str10 = str9;
                                                }
                                                gCPGameButtonAttr2.gameName$delegate.setValue(gCPGameButtonAttr2, kPropertyArr[12], str10);
                                                GameInfo gameInfo6 = AdCard.this.gameInfo;
                                                if (gameInfo6 == null || (gameDownLoadInfo2 = gameInfo6.download) == null || (str8 = gameDownLoadInfo2.adtag) == null) {
                                                    str8 = "xiaoshijie_gametab";
                                                }
                                                gCPGameButtonAttr2.adTag$delegate.setValue(gCPGameButtonAttr2, kPropertyArr[13], str8);
                                                GameInfo gameInfo7 = AdCard.this.gameInfo;
                                                String str11 = null;
                                                gCPGameButtonAttr2.privilege = gameInfo7 != null ? gameInfo7.privilege : null;
                                                if (gameInfo7 != null && (gameDownLoadInfo = gameInfo7.download) != null) {
                                                    str11 = gameDownLoadInfo.androidPkgSize;
                                                }
                                                gCPGameButtonAttr2.pkgSize = str11;
                                                gCPGameButtonAttr2.buttonFontSize = 12.0f;
                                                gCPGameButtonAttr2.buttonFixedWidth = true;
                                                gCPGameButtonAttr2.isDarkStyle = true;
                                                gCPGameButtonAttr2.alignSelfFlexEnd();
                                                gCPGameButtonAttr2.alignSelfCenter();
                                                gCPGameButtonAttr2.marginLeft(2.0f);
                                                gCPGameButtonAttr2.marginRight(10.0f);
                                                return Unit.INSTANCE;
                                            }
                                        });
                                        return Unit.INSTANCE;
                                    }
                                });
                                return Unit.INSTANCE;
                            }
                        });
                        final GCPGameCardView gCPGameCardView6 = GCPGameCardView.this;
                        final AdCard adCard6 = adCard2;
                        ConditionViewKt.a(vVar2, new Function1<ConditionView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.game_content_page.video_card.GCPGameCardView.body.1.2.7
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(ConditionView conditionView) {
                                final GCPGameCardView gCPGameCardView7 = GCPGameCardView.this;
                                final AdCard adCard7 = adCard6;
                                c.a(conditionView, new Function1<ButtonView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.game_content_page.video_card.GCPGameCardView.body.1.2.7.1
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(ButtonView buttonView) {
                                        final GCPGameCardView gCPGameCardView8 = GCPGameCardView.this;
                                        final AdCard adCard8 = adCard7;
                                        buttonView.attr(new Function1<a, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.game_content_page.video_card.GCPGameCardView.body.1.2.7.1.1
                                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                            {
                                                super(1);
                                            }

                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(a aVar) {
                                                long o16;
                                                a aVar2 = aVar;
                                                aVar2.alignSelfFlexEnd();
                                                aVar2.alignSelfCenter();
                                                aVar2.marginLeft(2.0f);
                                                aVar2.marginRight(10.0f);
                                                final GCPGameCardView gCPGameCardView9 = GCPGameCardView.this;
                                                aVar2.q(new Function1<ce, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.game_content_page.video_card.GCPGameCardView.body.1.2.7.1.1.1
                                                    {
                                                        super(1);
                                                    }

                                                    @Override // kotlin.jvm.functions.Function1
                                                    public final Unit invoke(ce ceVar) {
                                                        String str;
                                                        ce ceVar2 = ceVar;
                                                        Button button = GCPGameCardView.access$getAttr(GCPGameCardView.this).getAdCard().button;
                                                        if (button == null || (str = button.buttonText) == null) {
                                                            str = "\u7acb\u5373\u8d2d\u4e70";
                                                        }
                                                        ceVar2.text(str);
                                                        ceVar2.fontWeightSemisolid();
                                                        ceVar2.color(h.INSTANCE.m());
                                                        ce.fontSize$default(ceVar2, 14.0f, null, 2, null);
                                                        return Unit.INSTANCE;
                                                    }
                                                });
                                                aVar2.mo141height(28.0f);
                                                aVar2.paddingLeft(8.1f);
                                                aVar2.paddingRight(8.1f);
                                                GCPGameCardView gCPGameCardView10 = GCPGameCardView.this;
                                                AdCard adCard9 = adCard8;
                                                int i3 = GCPGameCardView.$r8$clinit;
                                                gCPGameCardView10.getClass();
                                                Button button = adCard9.button;
                                                if (button != null) {
                                                    String str = button.buttonBgColor;
                                                    if (!(str == null || str.length() == 0)) {
                                                        o16 = h.INSTANCE.o(adCard9.button.buttonBgColor);
                                                        aVar2.backgroundColor(o16);
                                                        aVar2.borderRadius(4.0f);
                                                        return Unit.INSTANCE;
                                                    }
                                                }
                                                o16 = h.INSTANCE.o("#0099FF");
                                                aVar2.backgroundColor(o16);
                                                aVar2.borderRadius(4.0f);
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
                });
                if (GCPGameCardView.access$getAttr(GCPGameCardView.this).getShowGameMetaInfoView()) {
                    final AdCard adCard3 = adCard;
                    viewContainer2.addChild(new GCPGameMetaInfoView(), new Function1<GCPGameMetaInfoView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.game_content_page.video_card.GCPGameCardView$body$1.3
                        {
                            super(1);
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public final Unit invoke(GCPGameMetaInfoView gCPGameMetaInfoView) {
                            final AdCard adCard4 = AdCard.this;
                            gCPGameMetaInfoView.attr(new Function1<GCPGameMetaInfoBarAttr, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.game_content_page.video_card.GCPGameCardView.body.1.3.1
                                {
                                    super(1);
                                }

                                @Override // kotlin.jvm.functions.Function1
                                public final Unit invoke(GCPGameMetaInfoBarAttr gCPGameMetaInfoBarAttr) {
                                    GCPGameMetaInfoBarAttr gCPGameMetaInfoBarAttr2 = gCPGameMetaInfoBarAttr;
                                    GameInfo gameInfo = AdCard.this.gameInfo;
                                    Intrinsics.checkNotNull(gameInfo);
                                    GamePrivilegeInfo gamePrivilegeInfo = gameInfo.privilege;
                                    Intrinsics.checkNotNull(gamePrivilegeInfo);
                                    gCPGameMetaInfoBarAttr2.privilegeInfo = gamePrivilegeInfo;
                                    gCPGameMetaInfoBarAttr2.marginLeft(8.0f);
                                    gCPGameMetaInfoBarAttr2.marginRight(10.0f);
                                    gCPGameMetaInfoBarAttr2.marginTop(-4.0f);
                                    return Unit.INSTANCE;
                                }
                            });
                            return Unit.INSTANCE;
                        }
                    });
                }
                return Unit.INSTANCE;
            }
        };
    }

    @Override // com.tencent.kuikly.core.base.AbstractBaseView
    public final Attr createAttr() {
        return new GCPGameCardViewAttr();
    }

    @Override // com.tencent.kuikly.core.base.AbstractBaseView
    public final Event createEvent() {
        return new l();
    }
}

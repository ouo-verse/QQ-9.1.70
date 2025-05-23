package com.tencent.hippykotlin.demo.pages.game_content_page.video_card;

import c01.c;
import com.tencent.hippykotlin.demo.pages.activity.blind_box.yifanshang.detail.view.YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.base.BridgeModule;
import com.tencent.hippykotlin.demo.pages.base.ECCirAvatarAttr;
import com.tencent.hippykotlin.demo.pages.base.ECCirAvatarEvent;
import com.tencent.hippykotlin.demo.pages.base.ECCirAvatarView;
import com.tencent.hippykotlin.demo.pages.base.ECCirRichTextAttr;
import com.tencent.hippykotlin.demo.pages.base.ECCirRichTextEvent;
import com.tencent.hippykotlin.demo.pages.base.ECCirRichTextView;
import com.tencent.hippykotlin.demo.pages.base.EcommerceExtKt;
import com.tencent.hippykotlin.demo.pages.base.SkinColor;
import com.tencent.hippykotlin.demo.pages.base.Utils;
import com.tencent.hippykotlin.demo.pages.base.ktx.IPagerIdKtxKt;
import com.tencent.hippykotlin.demo.pages.game_content_page.repo.GameFeedModel;
import com.tencent.hippykotlin.demo.pages.game_content_page.repo.data.gamefeed.GameFeed;
import com.tencent.hippykotlin.demo.pages.game_content_page.repo.data.gamefeed.Poster;
import com.tencent.kuikly.core.base.Attr;
import com.tencent.kuikly.core.base.ComposeView;
import com.tencent.kuikly.core.base.ViewContainer;
import com.tencent.kuikly.core.base.event.ClickParams;
import com.tencent.kuikly.core.base.event.Event;
import com.tencent.kuikly.core.base.h;
import com.tencent.kuikly.core.base.l;
import com.tencent.kuikly.core.manager.BridgeManager;
import com.tencent.kuikly.core.nvi.serialization.json.e;
import com.tencent.kuikly.core.views.TextView;
import com.tencent.kuikly.core.views.ce;
import com.tencent.kuikly.core.views.cg;
import com.tencent.kuikly.core.views.t;
import com.tencent.kuikly.core.views.u;
import com.tencent.kuikly.core.views.v;
import com.tencent.kuikly.core.views.w;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.properties.ReadWriteProperty;
import kotlin.reflect.KProperty;

/* loaded from: classes31.dex */
public final class GCPBaseInfoView extends ComposeView<GCPBaseInfoAttr, l> {
    public static final /* synthetic */ KProperty<Object>[] $$delegatedProperties = {YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0.m(GCPBaseInfoView.class, "titleLines", "getTitleLines()I", 0)};
    public final ReadWriteProperty titleLines$delegate = c.a(3);

    /* JADX WARN: Multi-variable type inference failed */
    public static final /* synthetic */ GCPBaseInfoAttr access$getAttr(GCPBaseInfoView gCPBaseInfoView) {
        return (GCPBaseInfoAttr) gCPBaseInfoView.getAttr();
    }

    @Override // com.tencent.kuikly.core.base.ComposeView
    public final Function1<ViewContainer<?, ?>, Unit> body() {
        return new Function1<ViewContainer<?, ?>, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.game_content_page.video_card.GCPBaseInfoView$body$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Unit invoke(ViewContainer<?, ?> viewContainer) {
                ViewContainer<?, ?> viewContainer2 = viewContainer;
                final GCPBaseInfoView gCPBaseInfoView = GCPBaseInfoView.this;
                w.a(viewContainer2, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.game_content_page.video_card.GCPBaseInfoView$body$1.1
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(v vVar) {
                        v vVar2 = vVar;
                        vVar2.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.game_content_page.video_card.GCPBaseInfoView.body.1.1.1
                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(t tVar) {
                                tVar.flexDirectionRow();
                                return Unit.INSTANCE;
                            }
                        });
                        final GCPBaseInfoView gCPBaseInfoView2 = GCPBaseInfoView.this;
                        vVar2.addChild(new ECCirAvatarView(), new Function1<ECCirAvatarView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.game_content_page.video_card.GCPBaseInfoView.body.1.1.2
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(ECCirAvatarView eCCirAvatarView) {
                                ECCirAvatarView eCCirAvatarView2 = eCCirAvatarView;
                                final GCPBaseInfoView gCPBaseInfoView3 = GCPBaseInfoView.this;
                                eCCirAvatarView2.attr(new Function1<ECCirAvatarAttr, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.game_content_page.video_card.GCPBaseInfoView.body.1.1.2.1
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(ECCirAvatarAttr eCCirAvatarAttr) {
                                        String str;
                                        GameFeed gameFeed;
                                        ECCirAvatarAttr eCCirAvatarAttr2 = eCCirAvatarAttr;
                                        eCCirAvatarAttr2.marginRight(8.0f);
                                        eCCirAvatarAttr2.size(34.0f, 34.0f);
                                        GameFeedModel gameFeedModel = GCPBaseInfoView.access$getAttr(GCPBaseInfoView.this).getGameFeedModel();
                                        if (gameFeedModel == null || (gameFeed = gameFeedModel.gameFeed) == null || (str = gameFeed.feedPbToken) == null) {
                                            str = "";
                                        }
                                        eCCirAvatarAttr2.with("feedPB", str);
                                        EcommerceExtKt.vr(eCCirAvatarAttr2, "em_xsj_author_avatar", new e().v("xsj_feed_id", GCPBaseInfoView.access$getAttr(GCPBaseInfoView.this).getGameFeedModel().gameFeed.f114193id));
                                        return Unit.INSTANCE;
                                    }
                                });
                                final GCPBaseInfoView gCPBaseInfoView4 = GCPBaseInfoView.this;
                                eCCirAvatarView2.event(new Function1<ECCirAvatarEvent, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.game_content_page.video_card.GCPBaseInfoView.body.1.1.2.2
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(ECCirAvatarEvent eCCirAvatarEvent) {
                                        final GCPBaseInfoView gCPBaseInfoView5 = GCPBaseInfoView.this;
                                        eCCirAvatarEvent.click(new Function1<ClickParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.game_content_page.video_card.GCPBaseInfoView.body.1.1.2.2.1
                                            {
                                                super(1);
                                            }

                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(ClickParams clickParams) {
                                                GameFeedModel gameFeedModel = GCPBaseInfoView.access$getAttr(GCPBaseInfoView.this).getGameFeedModel();
                                                if (gameFeedModel != null) {
                                                    Utils.INSTANCE.currentBridgeModule().qCircleOpenPersonalDetailPage(gameFeedModel.gameFeed.feedPbToken);
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
                        final GCPBaseInfoView gCPBaseInfoView3 = GCPBaseInfoView.this;
                        w.a(vVar2, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.game_content_page.video_card.GCPBaseInfoView.body.1.1.3
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(v vVar3) {
                                v vVar4 = vVar3;
                                final GCPBaseInfoView gCPBaseInfoView4 = GCPBaseInfoView.this;
                                vVar4.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.game_content_page.video_card.GCPBaseInfoView.body.1.1.3.1
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(t tVar) {
                                        t tVar2 = tVar;
                                        tVar2.mo141height(39.0f);
                                        tVar2.justifyContentSpaceBetween();
                                        EcommerceExtKt.vr(tVar2, "em_xsj_author_name", new e().v("xsj_feed_id", GCPBaseInfoView.access$getAttr(GCPBaseInfoView.this).getGameFeedModel().gameFeed.f114193id));
                                        return Unit.INSTANCE;
                                    }
                                });
                                final GCPBaseInfoView gCPBaseInfoView5 = GCPBaseInfoView.this;
                                cg.a(vVar4, new Function1<TextView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.game_content_page.video_card.GCPBaseInfoView.body.1.1.3.2
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(TextView textView) {
                                        final GCPBaseInfoView gCPBaseInfoView6 = GCPBaseInfoView.this;
                                        textView.attr(new Function1<ce, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.game_content_page.video_card.GCPBaseInfoView.body.1.1.3.2.1
                                            {
                                                super(1);
                                            }

                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(ce ceVar) {
                                                h blackTextColor;
                                                String str;
                                                GameFeed gameFeed;
                                                Poster poster;
                                                ce ceVar2 = ceVar;
                                                ce.fontSize$default(ceVar2.fontWeight500(), 15.0f, null, 2, null).lines(1);
                                                blackTextColor = SkinColor.INSTANCE.blackTextColor(BridgeManager.f117344a.u());
                                                ceVar2.color(blackTextColor);
                                                GameFeedModel gameFeedModel = GCPBaseInfoView.access$getAttr(GCPBaseInfoView.this).getGameFeedModel();
                                                if (gameFeedModel == null || (gameFeed = gameFeedModel.gameFeed) == null || (poster = gameFeed.poster) == null || (str = poster.nick) == null) {
                                                    str = "";
                                                }
                                                ceVar2.value(str);
                                                return Unit.INSTANCE;
                                            }
                                        });
                                        return Unit.INSTANCE;
                                    }
                                });
                                final GCPBaseInfoView gCPBaseInfoView6 = GCPBaseInfoView.this;
                                cg.a(vVar4, new Function1<TextView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.game_content_page.video_card.GCPBaseInfoView.body.1.1.3.3
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(TextView textView) {
                                        final GCPBaseInfoView gCPBaseInfoView7 = GCPBaseInfoView.this;
                                        textView.attr(new Function1<ce, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.game_content_page.video_card.GCPBaseInfoView.body.1.1.3.3.1
                                            {
                                                super(1);
                                            }

                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(ce ceVar) {
                                                GameFeed gameFeed;
                                                ce ceVar2 = ceVar;
                                                ce.fontSize$default(ceVar2.fontWeight400(), 12.0f, null, 2, null);
                                                ceVar2.color(new h(4288256409L));
                                                BridgeModule bridgeModule = IPagerIdKtxKt.getBridgeModule(ceVar2);
                                                GameFeedModel gameFeedModel = GCPBaseInfoView.access$getAttr(GCPBaseInfoView.this).getGameFeedModel();
                                                long j3 = (gameFeedModel == null || (gameFeed = gameFeedModel.gameFeed) == null) ? 0L : gameFeed.createTime;
                                                bridgeModule.getClass();
                                                e eVar = new e();
                                                eVar.u("time", j3);
                                                eVar.w("isCapitalized", false);
                                                ceVar2.value(bridgeModule.syncToNativeMethod("getQCircleDateFormat", eVar, (Function1<? super e, Unit>) null));
                                                return Unit.INSTANCE;
                                            }
                                        });
                                        return Unit.INSTANCE;
                                    }
                                });
                                return Unit.INSTANCE;
                            }
                        });
                        final GCPBaseInfoView gCPBaseInfoView4 = GCPBaseInfoView.this;
                        vVar2.event(new Function1<u, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.game_content_page.video_card.GCPBaseInfoView.body.1.1.4
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(u uVar) {
                                final GCPBaseInfoView gCPBaseInfoView5 = GCPBaseInfoView.this;
                                uVar.click(new Function1<ClickParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.game_content_page.video_card.GCPBaseInfoView.body.1.1.4.1
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(ClickParams clickParams) {
                                        GameFeedModel gameFeedModel = GCPBaseInfoView.access$getAttr(GCPBaseInfoView.this).getGameFeedModel();
                                        if (gameFeedModel != null) {
                                            Utils.INSTANCE.currentBridgeModule().qCircleOpenPersonalDetailPage(gameFeedModel.gameFeed.feedPbToken);
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
                final GCPBaseInfoView gCPBaseInfoView2 = GCPBaseInfoView.this;
                viewContainer2.addChild(new ECCirRichTextView(), new Function1<ECCirRichTextView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.game_content_page.video_card.GCPBaseInfoView$body$1.2
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(ECCirRichTextView eCCirRichTextView) {
                        ECCirRichTextView eCCirRichTextView2 = eCCirRichTextView;
                        final GCPBaseInfoView gCPBaseInfoView3 = GCPBaseInfoView.this;
                        eCCirRichTextView2.attr(new Function1<ECCirRichTextAttr, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.game_content_page.video_card.GCPBaseInfoView.body.1.2.1
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(ECCirRichTextAttr eCCirRichTextAttr) {
                                String str;
                                GameFeed gameFeed;
                                ECCirRichTextAttr eCCirRichTextAttr2 = eCCirRichTextAttr;
                                eCCirRichTextAttr2.marginTop(8.0f);
                                ce.fontSize$default(eCCirRichTextAttr2, 15.0f, null, 2, null);
                                GCPBaseInfoView gCPBaseInfoView4 = GCPBaseInfoView.this;
                                eCCirRichTextAttr2.lines(((Number) gCPBaseInfoView4.titleLines$delegate.getValue(gCPBaseInfoView4, GCPBaseInfoView.$$delegatedProperties[0])).intValue());
                                GameFeedModel gameFeedModel = GCPBaseInfoView.access$getAttr(GCPBaseInfoView.this).getGameFeedModel();
                                if (gameFeedModel == null || (gameFeed = gameFeedModel.gameFeed) == null || (str = gameFeed.content) == null) {
                                    str = "";
                                }
                                eCCirRichTextAttr2.with("content", str);
                                return Unit.INSTANCE;
                            }
                        });
                        final GCPBaseInfoView gCPBaseInfoView4 = GCPBaseInfoView.this;
                        eCCirRichTextView2.event(new Function1<ECCirRichTextEvent, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.game_content_page.video_card.GCPBaseInfoView.body.1.2.2
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(ECCirRichTextEvent eCCirRichTextEvent) {
                                final GCPBaseInfoView gCPBaseInfoView5 = GCPBaseInfoView.this;
                                eCCirRichTextEvent.register("contentExpand", new Function1<Object, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.game_content_page.video_card.GCPBaseInfoView.body.1.2.2.1
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(Object obj) {
                                        GCPBaseInfoView gCPBaseInfoView6 = GCPBaseInfoView.this;
                                        gCPBaseInfoView6.titleLines$delegate.setValue(gCPBaseInfoView6, GCPBaseInfoView.$$delegatedProperties[0], 0);
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
        return new GCPBaseInfoAttr();
    }

    @Override // com.tencent.kuikly.core.base.AbstractBaseView
    public final Event createEvent() {
        return new l();
    }
}

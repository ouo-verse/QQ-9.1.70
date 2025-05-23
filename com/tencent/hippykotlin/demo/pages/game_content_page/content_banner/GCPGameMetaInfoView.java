package com.tencent.hippykotlin.demo.pages.game_content_page.content_banner;

import com.tencent.hippykotlin.demo.pages.base.BridgeModule;
import com.tencent.hippykotlin.demo.pages.base.ktx.IPagerIdKtxKt;
import com.tencent.kuikly.core.base.Attr;
import com.tencent.kuikly.core.base.ComposeView;
import com.tencent.kuikly.core.base.ViewContainer;
import com.tencent.kuikly.core.base.aa;
import com.tencent.kuikly.core.base.event.ClickParams;
import com.tencent.kuikly.core.base.event.Event;
import com.tencent.kuikly.core.base.event.FrameEventKt;
import com.tencent.kuikly.core.base.h;
import com.tencent.kuikly.core.base.l;
import com.tencent.kuikly.core.base.m;
import com.tencent.kuikly.core.layout.FlexNode;
import com.tencent.kuikly.core.layout.d;
import com.tencent.kuikly.core.views.RichTextAttr;
import com.tencent.kuikly.core.views.RichTextView;
import com.tencent.kuikly.core.views.RichTextViewKt;
import com.tencent.kuikly.core.views.TextView;
import com.tencent.kuikly.core.views.ce;
import com.tencent.kuikly.core.views.cf;
import com.tencent.kuikly.core.views.cg;
import com.tencent.midas.comm.log.util.APLogFileUtil;
import com.tencent.qq.minibox.api.data.MiniBoxNoticeInfo;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes31.dex */
public final class GCPGameMetaInfoView extends ComposeView<GCPGameMetaInfoBarAttr, l> {
    public static final /* synthetic */ int $r8$clinit = 0;
    public aa<TextView> developerTextView;
    public aa<RichTextView> textViewRef;

    /* JADX WARN: Multi-variable type inference failed */
    public static final /* synthetic */ GCPGameMetaInfoBarAttr access$getAttr(GCPGameMetaInfoView gCPGameMetaInfoView) {
        return (GCPGameMetaInfoBarAttr) gCPGameMetaInfoView.getAttr();
    }

    @Override // com.tencent.kuikly.core.base.ComposeView
    public final Function1<ViewContainer<?, ?>, Unit> body() {
        return new Function1<ViewContainer<?, ?>, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.game_content_page.content_banner.GCPGameMetaInfoView$body$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Unit invoke(ViewContainer<?, ?> viewContainer) {
                ViewContainer<?, ?> viewContainer2 = viewContainer;
                viewContainer2.attr(new Function1<m, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.game_content_page.content_banner.GCPGameMetaInfoView$body$1.1
                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(m mVar) {
                        m mVar2 = mVar;
                        mVar2.flexDirectionRow();
                        mVar2.m140flex(1.0f);
                        return Unit.INSTANCE;
                    }
                });
                final GCPGameMetaInfoView gCPGameMetaInfoView = GCPGameMetaInfoView.this;
                viewContainer2.event(new Function1<Event, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.game_content_page.content_banner.GCPGameMetaInfoView$body$1.2
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(Event event) {
                        final GCPGameMetaInfoView gCPGameMetaInfoView2 = GCPGameMetaInfoView.this;
                        FrameEventKt.d(event, new Function1<d, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.game_content_page.content_banner.GCPGameMetaInfoView.body.1.2.1
                            {
                                super(1);
                            }

                            /* JADX WARN: Multi-variable type inference failed */
                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(d dVar) {
                                ce ceVar;
                                FlexNode flexNode;
                                float width = dVar.getWidth();
                                aa<RichTextView> aaVar = GCPGameMetaInfoView.this.textViewRef;
                                aa<TextView> aaVar2 = null;
                                if (aaVar == null) {
                                    Intrinsics.throwUninitializedPropertyAccessException("textViewRef");
                                    aaVar = null;
                                }
                                RichTextView b16 = aaVar.b();
                                float v3 = ((width - ((b16 == null || (flexNode = b16.getFlexNode()) == null) ? 0.0f : flexNode.v())) - 80.0f) - 24.0f;
                                aa<TextView> aaVar3 = GCPGameMetaInfoView.this.developerTextView;
                                if (aaVar3 == null) {
                                    Intrinsics.throwUninitializedPropertyAccessException("developerTextView");
                                } else {
                                    aaVar2 = aaVar3;
                                }
                                TextView b17 = aaVar2.b();
                                if (b17 != null && (ceVar = (ce) b17.getViewAttr()) != null) {
                                    ceVar.m144maxWidth(v3);
                                }
                                return Unit.INSTANCE;
                            }
                        });
                        return Unit.INSTANCE;
                    }
                });
                final GCPGameMetaInfoView gCPGameMetaInfoView2 = GCPGameMetaInfoView.this;
                cg.a(viewContainer2, new Function1<TextView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.game_content_page.content_banner.GCPGameMetaInfoView$body$1.3
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(TextView textView) {
                        TextView textView2 = textView;
                        final GCPGameMetaInfoView gCPGameMetaInfoView3 = GCPGameMetaInfoView.this;
                        textView2.ref(textView2, new Function1<aa<TextView>, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.game_content_page.content_banner.GCPGameMetaInfoView.body.1.3.1
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(aa<TextView> aaVar) {
                                GCPGameMetaInfoView.this.developerTextView = aaVar;
                                return Unit.INSTANCE;
                            }
                        });
                        final GCPGameMetaInfoView gCPGameMetaInfoView4 = GCPGameMetaInfoView.this;
                        textView2.attr(new Function1<ce, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.game_content_page.content_banner.GCPGameMetaInfoView.body.1.3.2
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(ce ceVar) {
                                h hVar;
                                ce ceVar2 = ceVar;
                                ceVar2.text(GCPGameMetaInfoView.access$getAttr(GCPGameMetaInfoView.this).getPrivilegeInfo().developer);
                                hVar = IPagerIdKtxKt.getSkinColor(ceVar2).tokenColor("qecommerce_skin_color_text_light", false);
                                ceVar2.color(hVar);
                                ceVar2.fontWeight400();
                                ce.fontSize$default(ceVar2, 8.0f, null, 2, null);
                                ceVar2.lines(1);
                                return Unit.INSTANCE;
                            }
                        });
                        return Unit.INSTANCE;
                    }
                });
                final GCPGameMetaInfoView gCPGameMetaInfoView3 = GCPGameMetaInfoView.this;
                cg.a(viewContainer2, new Function1<TextView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.game_content_page.content_banner.GCPGameMetaInfoView$body$1.4
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(TextView textView) {
                        TextView textView2 = textView;
                        final GCPGameMetaInfoView gCPGameMetaInfoView4 = GCPGameMetaInfoView.this;
                        textView2.ref(textView2, new Function1<aa<TextView>, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.game_content_page.content_banner.GCPGameMetaInfoView.body.1.4.1
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(aa<TextView> aaVar) {
                                GCPGameMetaInfoView gCPGameMetaInfoView5 = GCPGameMetaInfoView.this;
                                int i3 = GCPGameMetaInfoView.$r8$clinit;
                                gCPGameMetaInfoView5.getClass();
                                return Unit.INSTANCE;
                            }
                        });
                        final GCPGameMetaInfoView gCPGameMetaInfoView5 = GCPGameMetaInfoView.this;
                        textView2.attr(new Function1<ce, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.game_content_page.content_banner.GCPGameMetaInfoView.body.1.4.2
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(ce ceVar) {
                                h hVar;
                                ce ceVar2 = ceVar;
                                ceVar2.marginLeft(8.0f);
                                String str = GCPGameMetaInfoView.access$getAttr(GCPGameMetaInfoView.this).getPrivilegeInfo().version;
                                if (str.length() > 10) {
                                    StringBuilder sb5 = new StringBuilder();
                                    String substring = str.substring(0, 9);
                                    Intrinsics.checkNotNullExpressionValue(substring, "this as java.lang.String\u2026ing(startIndex, endIndex)");
                                    sb5.append(substring);
                                    sb5.append(MiniBoxNoticeInfo.APPNAME_SUFFIX);
                                    str = sb5.toString();
                                }
                                ceVar2.text(str);
                                hVar = IPagerIdKtxKt.getSkinColor(ceVar2).tokenColor("qecommerce_skin_color_text_light", false);
                                ceVar2.color(hVar);
                                ceVar2.fontWeight400();
                                ce.fontSize$default(ceVar2, 8.0f, null, 2, null);
                                ceVar2.textOverFlowTail();
                                ceVar2.m144maxWidth(80.0f);
                                ceVar2.lines(1);
                                return Unit.INSTANCE;
                            }
                        });
                        return Unit.INSTANCE;
                    }
                });
                final GCPGameMetaInfoView gCPGameMetaInfoView4 = GCPGameMetaInfoView.this;
                RichTextViewKt.b(viewContainer2, new Function1<RichTextView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.game_content_page.content_banner.GCPGameMetaInfoView$body$1.5
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(RichTextView richTextView) {
                        RichTextView richTextView2 = richTextView;
                        final GCPGameMetaInfoView gCPGameMetaInfoView5 = GCPGameMetaInfoView.this;
                        richTextView2.ref(richTextView2, new Function1<aa<RichTextView>, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.game_content_page.content_banner.GCPGameMetaInfoView.body.1.5.1
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(aa<RichTextView> aaVar) {
                                GCPGameMetaInfoView.this.textViewRef = aaVar;
                                return Unit.INSTANCE;
                            }
                        });
                        richTextView2.attr(new Function1<RichTextAttr, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.game_content_page.content_banner.GCPGameMetaInfoView.body.1.5.2
                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(RichTextAttr richTextAttr) {
                                RichTextAttr richTextAttr2 = richTextAttr;
                                Attr.absolutePosition$default(richTextAttr2, 0.0f, 0.0f, 0.0f, 0.0f, 7, null);
                                richTextAttr2.lines(1);
                                return Unit.INSTANCE;
                            }
                        });
                        final GCPGameMetaInfoView gCPGameMetaInfoView6 = GCPGameMetaInfoView.this;
                        RichTextViewKt.c(richTextView2, new Function1<cf, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.game_content_page.content_banner.GCPGameMetaInfoView.body.1.5.3
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(cf cfVar) {
                                h hVar;
                                final cf cfVar2 = cfVar;
                                cfVar2.text(GCPGameMetaInfoView.access$getAttr(GCPGameMetaInfoView.this).getPrivilegeInfo().privatePoliciesText);
                                hVar = IPagerIdKtxKt.getSkinColor(cfVar2).tokenColor("qecommerce_skin_color_text_light", false);
                                cfVar2.color(hVar);
                                cfVar2.fontWeight400();
                                ce.fontSize$default(cfVar2, 8.0f, null, 2, null);
                                final GCPGameMetaInfoView gCPGameMetaInfoView7 = GCPGameMetaInfoView.this;
                                cfVar2.click(new Function1<ClickParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.game_content_page.content_banner.GCPGameMetaInfoView.body.1.5.3.1
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(ClickParams clickParams) {
                                        BridgeModule.openPage$default(IPagerIdKtxKt.getBridgeModule(cf.this), GCPGameMetaInfoView.access$getAttr(gCPGameMetaInfoView7).getPrivilegeInfo().privatePoliciesUrl, false, null, null, 30);
                                        return Unit.INSTANCE;
                                    }
                                });
                                return Unit.INSTANCE;
                            }
                        });
                        RichTextViewKt.c(richTextView2, new Function1<cf, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.game_content_page.content_banner.GCPGameMetaInfoView.body.1.5.4
                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(cf cfVar) {
                                h hVar;
                                cf cfVar2 = cfVar;
                                cfVar2.text(APLogFileUtil.SEPARATOR_LOG);
                                hVar = IPagerIdKtxKt.getSkinColor(cfVar2).tokenColor("qecommerce_skin_color_text_light", false);
                                cfVar2.color(hVar);
                                cfVar2.fontWeight400();
                                ce.fontSize$default(cfVar2, 8.0f, null, 2, null);
                                return Unit.INSTANCE;
                            }
                        });
                        final GCPGameMetaInfoView gCPGameMetaInfoView7 = GCPGameMetaInfoView.this;
                        RichTextViewKt.c(richTextView2, new Function1<cf, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.game_content_page.content_banner.GCPGameMetaInfoView.body.1.5.5
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(cf cfVar) {
                                h hVar;
                                final cf cfVar2 = cfVar;
                                cfVar2.text(GCPGameMetaInfoView.access$getAttr(GCPGameMetaInfoView.this).getPrivilegeInfo().appPrivilegesText);
                                hVar = IPagerIdKtxKt.getSkinColor(cfVar2).tokenColor("qecommerce_skin_color_text_light", false);
                                cfVar2.color(hVar);
                                cfVar2.fontWeight400();
                                ce.fontSize$default(cfVar2, 8.0f, null, 2, null);
                                final GCPGameMetaInfoView gCPGameMetaInfoView8 = GCPGameMetaInfoView.this;
                                cfVar2.click(new Function1<ClickParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.game_content_page.content_banner.GCPGameMetaInfoView.body.1.5.5.1
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(ClickParams clickParams) {
                                        BridgeModule.openPage$default(IPagerIdKtxKt.getBridgeModule(cf.this), GCPGameMetaInfoView.access$getAttr(gCPGameMetaInfoView8).getPrivilegeInfo().appPrivilegesUrl, false, null, null, 30);
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
        return new GCPGameMetaInfoBarAttr();
    }

    @Override // com.tencent.kuikly.core.base.AbstractBaseView
    public final Event createEvent() {
        return new l();
    }
}

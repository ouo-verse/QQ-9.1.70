package com.tencent.hippykotlin.demo.pages.jubao;

import com.tencent.hippykotlin.demo.pages.base.EcommerceExtKt;
import com.tencent.hippykotlin.demo.pages.foundation.module.QQKuiklyPlatformApi;
import com.tencent.hippykotlin.demo.pages.vas_base.misc.VasUIToken;
import com.tencent.kuikly.core.base.Attr;
import com.tencent.kuikly.core.base.ComposeView;
import com.tencent.kuikly.core.base.ViewContainer;
import com.tencent.kuikly.core.base.attr.AccessibilityRole;
import com.tencent.kuikly.core.base.event.ClickParams;
import com.tencent.kuikly.core.base.event.Event;
import com.tencent.kuikly.core.base.h;
import com.tencent.kuikly.core.base.k;
import com.tencent.kuikly.core.base.l;
import com.tencent.kuikly.core.manager.c;
import com.tencent.kuikly.core.nvi.serialization.json.e;
import com.tencent.kuikly.core.views.RichTextAttr;
import com.tencent.kuikly.core.views.RichTextView;
import com.tencent.kuikly.core.views.RichTextViewKt;
import com.tencent.kuikly.core.views.ScrollerAttr;
import com.tencent.kuikly.core.views.ScrollerView;
import com.tencent.kuikly.core.views.bo;
import com.tencent.kuikly.core.views.ce;
import com.tencent.kuikly.core.views.cf;
import com.tencent.kuikly.core.views.w;
import java.util.ArrayList;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.functions.Function1;

/* compiled from: P */
/* loaded from: classes31.dex */
public final class JubaoReasonView extends ComposeView<k, l> {
    public Function1<? super JubaoReasonData, Unit> itemClickCallback;
    public final ArrayList<JubaoReasonData> reasonsData;

    public JubaoReasonView(ArrayList<JubaoReasonData> arrayList) {
        this.reasonsData = arrayList;
    }

    @Override // com.tencent.kuikly.core.base.ComposeView
    public final Function1<ViewContainer<?, ?>, Unit> body() {
        return new Function1<ViewContainer<?, ?>, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.jubao.JubaoReasonView$body$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Unit invoke(ViewContainer<?, ?> viewContainer) {
                ViewContainer<?, ?> viewContainer2 = viewContainer;
                w.a(viewContainer2, JubaoUtil$O3BgView$1.INSTANCE);
                JubaoNavBarKt.JubaoNavBar(viewContainer2, new Function1<JubaoNavBar, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.jubao.JubaoReasonView$body$1.1
                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(JubaoNavBar jubaoNavBar) {
                        jubaoNavBar.setBarData(new NavBarData("\u4e3e\u62a5\u539f\u56e0", false, false));
                        return Unit.INSTANCE;
                    }
                });
                final JubaoReasonView jubaoReasonView = JubaoReasonView.this;
                bo.a(viewContainer2, new Function1<ScrollerView<?, ?>, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.jubao.JubaoReasonView$body$1.2
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(ScrollerView<?, ?> scrollerView) {
                        ScrollerView<?, ?> scrollerView2 = scrollerView;
                        scrollerView2.attr(new Function1<ScrollerAttr, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.jubao.JubaoReasonView.body.1.2.1
                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(ScrollerAttr scrollerAttr) {
                                ScrollerAttr scrollerAttr2 = scrollerAttr;
                                scrollerAttr2.absolutePosition(0.0f, 0.0f, 0.0f, 0.0f);
                                scrollerAttr2.flexDirectionColumn();
                                scrollerAttr2.marginTop(66.0f);
                                scrollerAttr2.showScrollerIndicator(false);
                                return Unit.INSTANCE;
                            }
                        });
                        RichTextViewKt.b(scrollerView2, new Function1<RichTextView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.jubao.JubaoUtil$DescriptionView$1
                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(RichTextView richTextView) {
                                RichTextView richTextView2 = richTextView;
                                richTextView2.attr(new Function1<RichTextAttr, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.jubao.JubaoUtil$DescriptionView$1.1
                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(RichTextAttr richTextAttr) {
                                        RichTextAttr richTextAttr2 = richTextAttr;
                                        richTextAttr2.marginLeft(16.0f);
                                        richTextAttr2.marginRight(16.0f);
                                        richTextAttr2.marginBottom(16.0f);
                                        EcommerceExtKt.elementVR(richTextAttr2, "em_safe_police_immediately", ConstantsKt.getJubaoDTBaseParams());
                                        return Unit.INSTANCE;
                                    }
                                });
                                RichTextViewKt.c(richTextView2, new Function1<cf, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.jubao.JubaoUtil$DescriptionView$1.2
                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(cf cfVar) {
                                        cf cfVar2 = cfVar;
                                        ce.fontSize$default(cfVar2, 14.0f, null, 2, null);
                                        cfVar2.color(JubaoThemeData.INSTANCE.getContentTextColor());
                                        cfVar2.fontWeight400();
                                        cfVar2.text("\u4f60\u7684\u4e3e\u62a5\u662f\u533f\u540d\u7684\uff0c\u88ab\u4e3e\u62a5\u4eba\u65e0\u6cd5\u83b7\u77e5\u4f60\u7684\u8eab\u4efd\u4fe1\u606f\uff0c\u8bf7\u653e\u5fc3\u4e3e\u62a5\u3002\u5982\u679c\u6709\u4eba\u6b63\u9762\u4e34\u5371\u9669\uff0c\u8bf7");
                                        return Unit.INSTANCE;
                                    }
                                });
                                RichTextViewKt.c(richTextView2, new Function1<cf, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.jubao.JubaoUtil$DescriptionView$1.3
                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(cf cfVar) {
                                        h hVar;
                                        cf cfVar2 = cfVar;
                                        ce.fontSize$default(cfVar2, 14.0f, null, 2, null);
                                        JubaoThemeData jubaoThemeData = JubaoThemeData.INSTANCE;
                                        if (!VasUIToken.INSTANCE.isDarkMode()) {
                                            hVar = new h(4281169893L);
                                        } else {
                                            hVar = new h(4281169893L);
                                        }
                                        cfVar2.color(hVar);
                                        cfVar2.fontWeight400();
                                        cfVar2.text("\u7acb\u5373\u62a5\u8b66");
                                        cfVar2.click(new Function1<ClickParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.jubao.JubaoUtil.DescriptionView.1.3.1
                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(ClickParams clickParams) {
                                                QQKuiklyPlatformApi.openPage$default((QQKuiklyPlatformApi) c.f117352a.g().acquireModule("QQKuiklyPlatformApi"), "mqqapi://miniapp/open?_atype=0&_mappid=1112223557&_miniapptype=1&_mvid=&_path=pkgReport%2Fpages%2Freport_guide%2Findex&_vt=3&via=qq_txws&_sig=1115006160&_nq=scene%3Dqq", false, 6);
                                                return Unit.INSTANCE;
                                            }
                                        });
                                        return Unit.INSTANCE;
                                    }
                                });
                                RichTextViewKt.c(richTextView2, new Function1<cf, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.jubao.JubaoUtil$DescriptionView$1.4
                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(cf cfVar) {
                                        cf cfVar2 = cfVar;
                                        ce.fontSize$default(cfVar2, 14.0f, null, 2, null);
                                        cfVar2.color(JubaoThemeData.INSTANCE.getContentTextColor());
                                        cfVar2.fontWeight400();
                                        cfVar2.text("\uff0cQQ\u5b89\u5168\u4e2d\u5fc3\u4f1a\u534f\u52a9\u8b66\u65b9\u4e00\u540c\u5904\u7406\u3002");
                                        return Unit.INSTANCE;
                                    }
                                });
                                return Unit.INSTANCE;
                            }
                        });
                        final JubaoReasonView jubaoReasonView2 = JubaoReasonView.this;
                        final int i3 = 0;
                        for (Object obj : jubaoReasonView2.reasonsData) {
                            int i16 = i3 + 1;
                            if (i3 < 0) {
                                CollectionsKt__CollectionsKt.throwIndexOverflow();
                            }
                            final JubaoReasonData jubaoReasonData = (JubaoReasonData) obj;
                            scrollerView2.addChild(new JubaoArrowTextView(), new Function1<JubaoArrowTextView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.jubao.JubaoReasonView$body$1$2$2$1
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                {
                                    super(1);
                                }

                                @Override // kotlin.jvm.functions.Function1
                                public final Unit invoke(JubaoArrowTextView jubaoArrowTextView) {
                                    JubaoArrowTextView jubaoArrowTextView2 = jubaoArrowTextView;
                                    final JubaoReasonData jubaoReasonData2 = JubaoReasonData.this;
                                    final int i17 = i3;
                                    final JubaoReasonView jubaoReasonView3 = jubaoReasonView2;
                                    jubaoArrowTextView2.attr(new Function1<JubaoArrowTextViewAttr, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.jubao.JubaoReasonView$body$1$2$2$1.1
                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                        {
                                            super(1);
                                        }

                                        @Override // kotlin.jvm.functions.Function1
                                        public final Unit invoke(JubaoArrowTextViewAttr jubaoArrowTextViewAttr) {
                                            JubaoArrowTextViewAttr jubaoArrowTextViewAttr2 = jubaoArrowTextViewAttr;
                                            jubaoArrowTextViewAttr2.text = JubaoReasonData.this.name;
                                            if (i17 == jubaoReasonView3.reasonsData.size() - 1) {
                                                jubaoArrowTextViewAttr2.marginBottom(50.0f);
                                            }
                                            jubaoArrowTextViewAttr2.accessibility(JubaoReasonData.this.name);
                                            jubaoArrowTextViewAttr2.accessibilityRole(AccessibilityRole.TEXT);
                                            e jubaoDTBaseParams = ConstantsKt.getJubaoDTBaseParams();
                                            jubaoDTBaseParams.v("safe_report_type", JubaoReasonData.this.name);
                                            Unit unit = Unit.INSTANCE;
                                            EcommerceExtKt.elementVR(jubaoArrowTextViewAttr2, "em_safe_report_item", jubaoDTBaseParams);
                                            return Unit.INSTANCE;
                                        }
                                    });
                                    final JubaoReasonView jubaoReasonView4 = jubaoReasonView2;
                                    final JubaoReasonData jubaoReasonData3 = JubaoReasonData.this;
                                    jubaoArrowTextView2.event(new Function1<l, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.jubao.JubaoReasonView$body$1$2$2$1.2
                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                        {
                                            super(1);
                                        }

                                        @Override // kotlin.jvm.functions.Function1
                                        public final Unit invoke(l lVar) {
                                            final JubaoReasonView jubaoReasonView5 = JubaoReasonView.this;
                                            final JubaoReasonData jubaoReasonData4 = jubaoReasonData3;
                                            lVar.click(new Function1<ClickParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.jubao.JubaoReasonView.body.1.2.2.1.2.1
                                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                {
                                                    super(1);
                                                }

                                                @Override // kotlin.jvm.functions.Function1
                                                public final Unit invoke(ClickParams clickParams) {
                                                    Function1<? super JubaoReasonData, Unit> function1 = JubaoReasonView.this.itemClickCallback;
                                                    if (function1 != null) {
                                                        function1.invoke(jubaoReasonData4);
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
                            i3 = i16;
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
        return new k();
    }

    @Override // com.tencent.kuikly.core.base.AbstractBaseView
    public final Event createEvent() {
        return new l();
    }
}

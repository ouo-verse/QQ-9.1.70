package com.tencent.hippykotlin.demo.pages.nearby.feed_detail.view.feed_card;

import com.tencent.hippykotlin.demo.pages.adelie.page.compose.category_home.view.CategoryListFooterKt$CategoryListFooter$1$1$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.adelie.page.compose.creative_center.view.BotListCellKt$BotListCell$3$1$2$2$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.base.BridgeModule;
import com.tencent.hippykotlin.demo.pages.base.QUISkinColor;
import com.tencent.hippykotlin.demo.pages.base.Utils;
import com.tencent.hippykotlin.demo.pages.nearby.base.NearbyConst;
import com.tencent.hippykotlin.demo.pages.nearby.base.module.QQNearbyModule;
import com.tencent.hippykotlin.demo.pages.nearby.base.view.ClickLocation;
import com.tencent.hippykotlin.demo.pages.nearby.feed_detail.view_model.UserFeedsCard.NearbyFDPStatusContentViewModel;
import com.tencent.kuikly.core.base.Attr;
import com.tencent.kuikly.core.base.ComposeView;
import com.tencent.kuikly.core.base.ViewContainer;
import com.tencent.kuikly.core.base.event.ClickParams;
import com.tencent.kuikly.core.base.event.Event;
import com.tencent.kuikly.core.base.h;
import com.tencent.kuikly.core.log.KLog;
import com.tencent.kuikly.core.nvi.serialization.json.e;
import com.tencent.kuikly.core.reactive.collection.c;
import com.tencent.kuikly.core.views.RichTextAttr;
import com.tencent.kuikly.core.views.RichTextEvent;
import com.tencent.kuikly.core.views.RichTextView;
import com.tencent.kuikly.core.views.RichTextViewKt;
import com.tencent.kuikly.core.views.ce;
import com.tencent.kuikly.core.views.cf;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Triple;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsJVMKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.text.MatchResult;
import kotlin.text.Regex;
import kotlin.text.StringsKt__StringsKt;
import n25.l;
import n25.m;

/* loaded from: classes31.dex */
public final class NearbyFDPContentTitleView extends ComposeView<NearbyFDPContentTitleViewAttr, NearbyFDPContentTitleViewEvent> {
    /* JADX WARN: Multi-variable type inference failed */
    public static final /* synthetic */ NearbyFDPContentTitleViewAttr access$getAttr(NearbyFDPContentTitleView nearbyFDPContentTitleView) {
        return (NearbyFDPContentTitleViewAttr) nearbyFDPContentTitleView.getAttr();
    }

    public static final void access$openFeedDetailPage(NearbyFDPContentTitleView nearbyFDPContentTitleView, l lVar) {
        boolean z16;
        nearbyFDPContentTitleView.getClass();
        if (lVar != null) {
            z16 = true;
            QQNearbyModule.Companion.getInstance().openFeedDetail(lVar, 1, new e());
        } else {
            z16 = false;
        }
        KLog kLog = KLog.INSTANCE;
        NearbyConst nearbyConst = NearbyConst.INSTANCE;
        CategoryListFooterKt$CategoryListFooter$1$1$$ExternalSyntheticOutline0.m("did click content title to open feed detail page result:", z16, kLog, "feed_detail_page");
    }

    @Override // com.tencent.kuikly.core.base.ComposeView
    public final Function1<ViewContainer<?, ?>, Unit> body() {
        return new Function1<ViewContainer<?, ?>, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.feed_detail.view.feed_card.NearbyFDPContentTitleView$body$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Unit invoke(ViewContainer<?, ?> viewContainer) {
                ViewContainer<?, ?> viewContainer2 = viewContainer;
                final NearbyFDPContentTitleView nearbyFDPContentTitleView = NearbyFDPContentTitleView.this;
                viewContainer2.event(new Function1<Event, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.feed_detail.view.feed_card.NearbyFDPContentTitleView$body$1.1
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(Event event) {
                        final NearbyFDPContentTitleView nearbyFDPContentTitleView2 = NearbyFDPContentTitleView.this;
                        event.click(new Function1<ClickParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.feed_detail.view.feed_card.NearbyFDPContentTitleView.body.1.1.1
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(ClickParams clickParams) {
                                NearbyFDPContentTitleView nearbyFDPContentTitleView3 = NearbyFDPContentTitleView.this;
                                NearbyFDPStatusContentViewModel viewModel = NearbyFDPContentTitleView.access$getAttr(nearbyFDPContentTitleView3).getViewModel();
                                NearbyFDPContentTitleView.access$openFeedDetailPage(nearbyFDPContentTitleView3, viewModel != null ? viewModel.getStatusFeed() : null);
                                return Unit.INSTANCE;
                            }
                        });
                        return Unit.INSTANCE;
                    }
                });
                final NearbyFDPContentTitleView nearbyFDPContentTitleView2 = NearbyFDPContentTitleView.this;
                RichTextViewKt.b(viewContainer2, new Function1<RichTextView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.feed_detail.view.feed_card.NearbyFDPContentTitleView$body$1.2
                    {
                        super(1);
                    }

                    /* JADX WARN: Removed duplicated region for block: B:64:0x0196  */
                    @Override // kotlin.jvm.functions.Function1
                    /*
                        Code decompiled incorrectly, please refer to instructions dump.
                    */
                    public final Unit invoke(RichTextView richTextView) {
                        List listOf;
                        List listOf2;
                        List listOf3;
                        final Triple triple;
                        Iterator it;
                        String joinToString$default;
                        Object obj;
                        String str;
                        String removePrefix;
                        RichTextView richTextView2 = richTextView;
                        final NearbyFDPContentTitleView nearbyFDPContentTitleView3 = NearbyFDPContentTitleView.this;
                        richTextView2.attr(new Function1<RichTextAttr, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.feed_detail.view.feed_card.NearbyFDPContentTitleView.body.1.2.1
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(RichTextAttr richTextAttr) {
                                RichTextAttr richTextAttr2 = richTextAttr;
                                ce.fontSize$default(richTextAttr2, 18.0f, null, 2, null);
                                richTextAttr2.lines(3);
                                NearbyFDPContentTitleViewAttr access$getAttr = NearbyFDPContentTitleView.access$getAttr(NearbyFDPContentTitleView.this);
                                if (((Boolean) access$getAttr.isDarkStyle$delegate.getValue(access$getAttr, NearbyFDPContentTitleViewAttr.$$delegatedProperties[1])).booleanValue()) {
                                    richTextAttr2.color(h.INSTANCE.b());
                                } else {
                                    richTextAttr2.color(h.INSTANCE.m());
                                }
                                richTextAttr2.lineHeight(24.0f);
                                richTextAttr2.fontWeight500();
                                return Unit.INSTANCE;
                            }
                        });
                        final NearbyFDPContentTitleView nearbyFDPContentTitleView4 = NearbyFDPContentTitleView.this;
                        richTextView2.event(new Function1<RichTextEvent, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.feed_detail.view.feed_card.NearbyFDPContentTitleView.body.1.2.2
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(RichTextEvent richTextEvent) {
                                final NearbyFDPContentTitleView nearbyFDPContentTitleView5 = NearbyFDPContentTitleView.this;
                                richTextEvent.doubleClick(new Function1<ClickParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.feed_detail.view.feed_card.NearbyFDPContentTitleView.body.1.2.2.1
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(ClickParams clickParams) {
                                        ClickParams clickParams2 = clickParams;
                                        NearbyFDPStatusContentViewModel viewModel = NearbyFDPContentTitleView.access$getAttr(NearbyFDPContentTitleView.this).getViewModel();
                                        if (viewModel != null) {
                                            viewModel.onClickLikeBtn(true, new ClickLocation(clickParams2.getX(), clickParams2.getY()).getTargetLocation(NearbyFDPContentTitleView.this, Reflection.getOrCreateKotlinClass(NearbyUserFeedsCardView.class)));
                                        }
                                        return Unit.INSTANCE;
                                    }
                                });
                                return Unit.INSTANCE;
                            }
                        });
                        NearbyFDPStatusContentViewModel viewModel = NearbyFDPContentTitleView.access$getAttr(NearbyFDPContentTitleView.this).getViewModel();
                        String str2 = viewModel != null ? (String) viewModel.statusTitle$delegate.getValue(viewModel, NearbyFDPStatusContentViewModel.$$delegatedProperties[2]) : null;
                        NearbyFDPStatusContentViewModel viewModel2 = NearbyFDPContentTitleView.access$getAttr(NearbyFDPContentTitleView.this).getViewModel();
                        c cVar = viewModel2 != null ? (c) viewModel2.statusTopicList$delegate.getValue(viewModel2, NearbyFDPStatusContentViewModel.$$delegatedProperties[1]) : null;
                        if (!(str2 == null || str2.length() == 0)) {
                            if (!(cVar == null || cVar.isEmpty())) {
                                ArrayList arrayList = new ArrayList();
                                ArrayList arrayList2 = new ArrayList();
                                ArrayList arrayList3 = new ArrayList();
                                ArrayList arrayList4 = new ArrayList();
                                Iterator it5 = cVar.iterator();
                                while (it5.hasNext()) {
                                    Object next = it5.next();
                                    if (((m) next).f418100f.length() > 0) {
                                        arrayList4.add(next);
                                    }
                                }
                                joinToString$default = CollectionsKt___CollectionsKt.joinToString$default(arrayList4, "|", null, null, 0, null, new Function1<m, CharSequence>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.base.utils.NearbyProUtilsKt$calculateStatusTopicHighlightParams$regex$2
                                    @Override // kotlin.jvm.functions.Function1
                                    public final CharSequence invoke(m mVar) {
                                        StringBuilder m3 = BotListCellKt$BotListCell$3$1$2$2$$ExternalSyntheticOutline0.m('#');
                                        m3.append(Regex.INSTANCE.escape(mVar.f418099e));
                                        return m3.toString();
                                    }
                                }, 30, null);
                                int i3 = 0;
                                for (MatchResult matchResult : Regex.findAll$default(new Regex(joinToString$default), str2, 0, 2, null)) {
                                    if (matchResult.getRange().getFirst() > i3) {
                                        arrayList.add(Boolean.FALSE);
                                        String substring = str2.substring(i3, matchResult.getRange().getFirst());
                                        Intrinsics.checkNotNullExpressionValue(substring, "this as java.lang.String\u2026ing(startIndex, endIndex)");
                                        arrayList2.add(substring);
                                        arrayList3.add("");
                                    }
                                    arrayList.add(Boolean.TRUE);
                                    arrayList2.add(matchResult.getValue());
                                    Iterator it6 = cVar.iterator();
                                    while (true) {
                                        if (!it6.hasNext()) {
                                            obj = null;
                                            break;
                                        }
                                        obj = it6.next();
                                        String str3 = ((m) obj).f418099e;
                                        removePrefix = StringsKt__StringsKt.removePrefix(matchResult.getValue(), (CharSequence) "#");
                                        if (Intrinsics.areEqual(str3, removePrefix)) {
                                            break;
                                        }
                                    }
                                    m mVar = (m) obj;
                                    if (mVar == null || (str = mVar.f418100f) == null) {
                                        str = "";
                                    }
                                    arrayList3.add(str);
                                    i3 = matchResult.getRange().getLast() + 1;
                                }
                                if (i3 < str2.length()) {
                                    arrayList.add(Boolean.FALSE);
                                    String substring2 = str2.substring(i3);
                                    Intrinsics.checkNotNullExpressionValue(substring2, "this as java.lang.String).substring(startIndex)");
                                    arrayList2.add(substring2);
                                    arrayList3.add("");
                                }
                                triple = new Triple(arrayList, arrayList2, arrayList3);
                                final NearbyFDPContentTitleView nearbyFDPContentTitleView5 = NearbyFDPContentTitleView.this;
                                it = ((List) triple.getFirst()).iterator();
                                final int i16 = 0;
                                while (it.hasNext()) {
                                    int i17 = i16 + 1;
                                    if (((Boolean) it.next()).booleanValue()) {
                                        RichTextViewKt.c(richTextView2, new Function1<cf, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.feed_detail.view.feed_card.NearbyFDPContentTitleView$body$1$2$3$1
                                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                            /* JADX WARN: Multi-variable type inference failed */
                                            {
                                                super(1);
                                            }

                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(cf cfVar) {
                                                cf cfVar2 = cfVar;
                                                cfVar2.text(triple.getSecond().get(i16));
                                                cfVar2.color(QUISkinColor.INSTANCE.wrapColor("brand_standard"));
                                                final Triple<List<Boolean>, List<String>, List<String>> triple2 = triple;
                                                final int i18 = i16;
                                                cfVar2.click(new Function1<ClickParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.feed_detail.view.feed_card.NearbyFDPContentTitleView$body$1$2$3$1.1
                                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                    /* JADX WARN: Multi-variable type inference failed */
                                                    {
                                                        super(1);
                                                    }

                                                    @Override // kotlin.jvm.functions.Function1
                                                    public final Unit invoke(ClickParams clickParams) {
                                                        BridgeModule.openPage$default(Utils.INSTANCE.currentBridgeModule(), triple2.getThird().get(i18), false, null, null, 30);
                                                        return Unit.INSTANCE;
                                                    }
                                                });
                                                return Unit.INSTANCE;
                                            }
                                        });
                                    } else {
                                        RichTextViewKt.c(richTextView2, new Function1<cf, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.feed_detail.view.feed_card.NearbyFDPContentTitleView$body$1$2$3$2
                                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                            /* JADX WARN: Multi-variable type inference failed */
                                            {
                                                super(1);
                                            }

                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(cf cfVar) {
                                                cf cfVar2 = cfVar;
                                                cfVar2.text(triple.getSecond().get(i16));
                                                NearbyFDPContentTitleViewAttr access$getAttr = NearbyFDPContentTitleView.access$getAttr(nearbyFDPContentTitleView5);
                                                if (((Boolean) access$getAttr.isDarkStyle$delegate.getValue(access$getAttr, NearbyFDPContentTitleViewAttr.$$delegatedProperties[1])).booleanValue()) {
                                                    cfVar2.color(h.INSTANCE.b());
                                                } else {
                                                    cfVar2.color(h.INSTANCE.m());
                                                }
                                                final NearbyFDPContentTitleView nearbyFDPContentTitleView6 = nearbyFDPContentTitleView5;
                                                cfVar2.click(new Function1<ClickParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.feed_detail.view.feed_card.NearbyFDPContentTitleView$body$1$2$3$2.1
                                                    {
                                                        super(1);
                                                    }

                                                    @Override // kotlin.jvm.functions.Function1
                                                    public final Unit invoke(ClickParams clickParams) {
                                                        NearbyFDPContentTitleView nearbyFDPContentTitleView7 = NearbyFDPContentTitleView.this;
                                                        NearbyFDPStatusContentViewModel viewModel3 = NearbyFDPContentTitleView.access$getAttr(nearbyFDPContentTitleView7).getViewModel();
                                                        NearbyFDPContentTitleView.access$openFeedDetailPage(nearbyFDPContentTitleView7, viewModel3 != null ? viewModel3.getStatusFeed() : null);
                                                        return Unit.INSTANCE;
                                                    }
                                                });
                                                return Unit.INSTANCE;
                                            }
                                        });
                                    }
                                    i16 = i17;
                                }
                                return Unit.INSTANCE;
                            }
                        }
                        listOf = CollectionsKt__CollectionsJVMKt.listOf(Boolean.FALSE);
                        if (str2 == null) {
                            str2 = "";
                        }
                        listOf2 = CollectionsKt__CollectionsJVMKt.listOf(str2);
                        listOf3 = CollectionsKt__CollectionsJVMKt.listOf("");
                        triple = new Triple(listOf, listOf2, listOf3);
                        final NearbyFDPContentTitleView nearbyFDPContentTitleView52 = NearbyFDPContentTitleView.this;
                        it = ((List) triple.getFirst()).iterator();
                        final int i162 = 0;
                        while (it.hasNext()) {
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
        return new NearbyFDPContentTitleViewAttr();
    }

    @Override // com.tencent.kuikly.core.base.AbstractBaseView
    public final Event createEvent() {
        return new NearbyFDPContentTitleViewEvent();
    }
}

package com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.itemview.expression;

import c01.c;
import com.tencent.hippykotlin.demo.pages.activity.blind_box.yifanshang.detail.view.YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.base.EcommerceExtKt;
import com.tencent.hippykotlin.demo.pages.base.Utils;
import com.tencent.hippykotlin.demo.pages.qsearch_detail_page.data.pb.ExpressionInfo;
import com.tencent.hippykotlin.demo.pages.qsearch_detail_page.data.pb.expression.ExpressionCardItemModel;
import com.tencent.hippykotlin.demo.pages.qsearch_detail_page.data.pb.template.TemplateItemsKt;
import com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.itemview.QSearchBaseAnimControlItemView;
import com.tencent.hippykotlin.demo.pages.qsearch_detail_page.util.ISearchReport;
import com.tencent.kuikly.core.base.Attr;
import com.tencent.kuikly.core.base.BorderStyle;
import com.tencent.kuikly.core.base.ViewContainer;
import com.tencent.kuikly.core.base.attr.b;
import com.tencent.kuikly.core.base.event.ClickParams;
import com.tencent.kuikly.core.base.event.Event;
import com.tencent.kuikly.core.base.event.VisibilityEventKt;
import com.tencent.kuikly.core.base.h;
import com.tencent.kuikly.core.directives.ConditionView;
import com.tencent.kuikly.core.directives.ConditionViewKt;
import com.tencent.kuikly.core.nvi.serialization.json.e;
import com.tencent.kuikly.core.pager.b;
import com.tencent.kuikly.core.views.ImageEvent;
import com.tencent.kuikly.core.views.ImageView;
import com.tencent.kuikly.core.views.LoadSuccessParams;
import com.tencent.kuikly.core.views.af;
import com.tencent.kuikly.core.views.ah;
import com.tencent.kuikly.core.views.t;
import com.tencent.kuikly.core.views.u;
import com.tencent.kuikly.core.views.v;
import com.tencent.kuikly.core.views.w;
import com.tencent.qcircle.weseevideo.common.constants.QzoneCameraConst;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.properties.ReadWriteProperty;
import kotlin.reflect.KProperty;

/* compiled from: P */
/* loaded from: classes32.dex */
public final class ExpressionSingleItemView extends QSearchBaseAnimControlItemView<ExpressionItemAttr, ExpressionItemEvent> {
    public static final /* synthetic */ KProperty<Object>[] $$delegatedProperties = {YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0.m(ExpressionSingleItemView.class, "showBackground", "getShowBackground()Z", 0), YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0.m(ExpressionSingleItemView.class, "startDownloadExpression", "getStartDownloadExpression()Z", 0)};
    public final ReadWriteProperty showBackground$delegate = c.a(Boolean.TRUE);
    public final ReadWriteProperty startDownloadExpression$delegate = c.a(Boolean.FALSE);

    /* JADX WARN: Multi-variable type inference failed */
    public static final /* synthetic */ ExpressionItemAttr access$getAttr(ExpressionSingleItemView expressionSingleItemView) {
        return (ExpressionItemAttr) expressionSingleItemView.getAttr();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final e access$getReportParams(ExpressionSingleItemView expressionSingleItemView) {
        e baseReportParams = expressionSingleItemView.getBaseReportParams();
        baseReportParams.v("search_query_text", ((ExpressionItemAttr) expressionSingleItemView.getAttr()).keyword);
        baseReportParams.v("search_trace_id", ((ExpressionItemAttr) expressionSingleItemView.getAttr()).traceId);
        if (!((ExpressionItemAttr) expressionSingleItemView.getAttr()).isInGroup) {
            baseReportParams.t("serial_number", ((ExpressionItemAttr) expressionSingleItemView.getAttr()).index);
        }
        baseReportParams.v(QzoneCameraConst.Tag.ARG_PARAM_STICKER_ID, ((ExpressionItemAttr) expressionSingleItemView.getAttr()).getExpressionInfo().md5);
        b pager = expressionSingleItemView.getPager();
        ISearchReport iSearchReport = pager instanceof ISearchReport ? (ISearchReport) pager : null;
        if (iSearchReport != null) {
            baseReportParams.v("query_source", String.valueOf(iSearchReport.getQuerySource()));
            baseReportParams.v("user_source", String.valueOf(iSearchReport.getUserSource()));
        }
        ExpressionCardItemModel expressionCardItemModel = ((ExpressionItemAttr) expressionSingleItemView.getAttr()).data;
        if (expressionCardItemModel != null) {
            e mergeTransferInfo = TemplateItemsKt.mergeTransferInfo(expressionCardItemModel.getReportInfo(), baseReportParams);
            if (mergeTransferInfo != null) {
                mergeTransferInfo.t("doc_position", ((ExpressionItemAttr) expressionSingleItemView.getAttr()).index);
            }
            if (mergeTransferInfo != null) {
                ExpressionCardItemModel expressionCardItemModel2 = ((ExpressionItemAttr) expressionSingleItemView.getAttr()).data;
                mergeTransferInfo.t("serial_number", expressionCardItemModel2 != null ? expressionCardItemModel2.serialNumber : -1);
            }
            baseReportParams.v("transfer_info", mergeTransferInfo);
        }
        return baseReportParams;
    }

    @Override // com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.itemview.QSearchBaseAnimControlItemView
    public final Function1<ViewContainer<?, ?>, Unit> configView() {
        return new Function1<ViewContainer<?, ?>, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.itemview.expression.ExpressionSingleItemView$configView$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Unit invoke(ViewContainer<?, ?> viewContainer) {
                final ExpressionSingleItemView expressionSingleItemView = ExpressionSingleItemView.this;
                w.a(viewContainer, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.itemview.expression.ExpressionSingleItemView$configView$1.1
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(v vVar) {
                        v vVar2 = vVar;
                        final ExpressionSingleItemView expressionSingleItemView2 = ExpressionSingleItemView.this;
                        vVar2.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.itemview.expression.ExpressionSingleItemView.configView.1.1.1
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(t tVar) {
                                String str;
                                t tVar2 = tVar;
                                tVar2.size(ExpressionSingleItemView.access$getAttr(ExpressionSingleItemView.this).size.getWidth(), ExpressionSingleItemView.access$getAttr(ExpressionSingleItemView.this).size.getHeight());
                                tVar2.borderRadius(ExpressionSingleItemView.access$getAttr(ExpressionSingleItemView.this).borderRadius);
                                tVar2.m136border(new com.tencent.kuikly.core.base.e(0.5f, BorderStyle.SOLID, new h(0, 0, 0, 0.05f)));
                                ExpressionCardItemModel expressionCardItemModel = ExpressionSingleItemView.access$getAttr(ExpressionSingleItemView.this).data;
                                if (expressionCardItemModel == null || (str = expressionCardItemModel.getEid()) == null) {
                                    str = "em_search_expression_entry";
                                }
                                EcommerceExtKt.vr$default(tVar2, null, str, ExpressionSingleItemView.access$getReportParams(ExpressionSingleItemView.this), null, String.valueOf(ExpressionSingleItemView.access$getAttr(ExpressionSingleItemView.this).getExpressionInfo().hashCode()), true, 9);
                                return Unit.INSTANCE;
                            }
                        });
                        final ExpressionSingleItemView expressionSingleItemView3 = ExpressionSingleItemView.this;
                        vVar2.event(new Function1<u, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.itemview.expression.ExpressionSingleItemView.configView.1.1.2
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(u uVar) {
                                u uVar2 = uVar;
                                final ExpressionSingleItemView expressionSingleItemView4 = ExpressionSingleItemView.this;
                                VisibilityEventKt.b(uVar2, new Function1<Object, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.itemview.expression.ExpressionSingleItemView.configView.1.1.2.1
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(Object obj) {
                                        ExpressionSingleItemView expressionSingleItemView5 = ExpressionSingleItemView.this;
                                        expressionSingleItemView5.startDownloadExpression$delegate.setValue(expressionSingleItemView5, ExpressionSingleItemView.$$delegatedProperties[1], Boolean.TRUE);
                                        return Unit.INSTANCE;
                                    }
                                });
                                final ExpressionSingleItemView expressionSingleItemView5 = ExpressionSingleItemView.this;
                                uVar2.click(new Function1<ClickParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.itemview.expression.ExpressionSingleItemView.configView.1.1.2.2
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(ClickParams clickParams) {
                                        ExpressionInfo expressionInfo = ExpressionSingleItemView.access$getAttr(ExpressionSingleItemView.this).getExpressionInfo();
                                        String str = expressionInfo.srcIconUrl;
                                        if (!(str.length() > 0)) {
                                            str = null;
                                        }
                                        if (str == null) {
                                            str = expressionInfo.thumbUrl;
                                        }
                                        e eVar = new e();
                                        eVar.v("emt_name", expressionInfo.md5);
                                        eVar.v("emt_oriMd5", expressionInfo.md5);
                                        eVar.v("emt_oriUrl", expressionInfo.url);
                                        eVar.t("emt_type", 3);
                                        eVar.v("emt_packCoverUrl", str);
                                        eVar.v("emt_webUrl", expressionInfo.srcWebUrl);
                                        eVar.v("emt_packName", expressionInfo.srcPackName);
                                        Utils.INSTANCE.currentBridgeModule().callNativeMethod("openSearchEmoticonPage", eVar, null);
                                        return Unit.INSTANCE;
                                    }
                                });
                                return Unit.INSTANCE;
                            }
                        });
                        final ExpressionSingleItemView expressionSingleItemView4 = ExpressionSingleItemView.this;
                        Function0<Object> function0 = new Function0<Object>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.itemview.expression.ExpressionSingleItemView.configView.1.1.3
                            {
                                super(0);
                            }

                            @Override // kotlin.jvm.functions.Function0
                            public final Object invoke() {
                                ExpressionSingleItemView expressionSingleItemView5 = ExpressionSingleItemView.this;
                                KProperty<Object>[] kPropertyArr = ExpressionSingleItemView.$$delegatedProperties;
                                return Boolean.valueOf(expressionSingleItemView5.getCanPlayAnim());
                            }
                        };
                        final ExpressionSingleItemView expressionSingleItemView5 = ExpressionSingleItemView.this;
                        ConditionViewKt.c(vVar2, function0, new Function1<ConditionView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.itemview.expression.ExpressionSingleItemView.configView.1.1.4
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(ConditionView conditionView) {
                                ConditionView conditionView2 = conditionView;
                                final ExpressionSingleItemView expressionSingleItemView6 = ExpressionSingleItemView.this;
                                Function0<Object> function02 = new Function0<Object>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.itemview.expression.ExpressionSingleItemView.configView.1.1.4.1
                                    {
                                        super(0);
                                    }

                                    @Override // kotlin.jvm.functions.Function0
                                    public final Object invoke() {
                                        ExpressionSingleItemView expressionSingleItemView7 = ExpressionSingleItemView.this;
                                        return Boolean.valueOf(((Boolean) expressionSingleItemView7.startDownloadExpression$delegate.getValue(expressionSingleItemView7, ExpressionSingleItemView.$$delegatedProperties[1])).booleanValue());
                                    }
                                };
                                final ExpressionSingleItemView expressionSingleItemView7 = ExpressionSingleItemView.this;
                                ConditionViewKt.c(conditionView2, function02, new Function1<ConditionView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.itemview.expression.ExpressionSingleItemView.configView.1.1.4.2
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(ConditionView conditionView3) {
                                        final ExpressionSingleItemView expressionSingleItemView8 = ExpressionSingleItemView.this;
                                        ah.a(conditionView3, new Function1<ImageView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.itemview.expression.ExpressionSingleItemView.configView.1.1.4.2.1
                                            {
                                                super(1);
                                            }

                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(ImageView imageView) {
                                                ImageView imageView2 = imageView;
                                                final ExpressionSingleItemView expressionSingleItemView9 = ExpressionSingleItemView.this;
                                                imageView2.attr(new Function1<af, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.itemview.expression.ExpressionSingleItemView.configView.1.1.4.2.1.1
                                                    {
                                                        super(1);
                                                    }

                                                    @Override // kotlin.jvm.functions.Function1
                                                    public final Unit invoke(af afVar) {
                                                        af afVar2 = afVar;
                                                        b.a.b(afVar2, ExpressionSingleItemView.access$getAttr(ExpressionSingleItemView.this).getExpressionInfo().url, false, 2, null);
                                                        afVar2.size(ExpressionSingleItemView.access$getAttr(ExpressionSingleItemView.this).size.getWidth(), ExpressionSingleItemView.access$getAttr(ExpressionSingleItemView.this).size.getHeight());
                                                        return Unit.INSTANCE;
                                                    }
                                                });
                                                final ExpressionSingleItemView expressionSingleItemView10 = ExpressionSingleItemView.this;
                                                imageView2.event(new Function1<ImageEvent, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.itemview.expression.ExpressionSingleItemView.configView.1.1.4.2.1.2
                                                    {
                                                        super(1);
                                                    }

                                                    @Override // kotlin.jvm.functions.Function1
                                                    public final Unit invoke(ImageEvent imageEvent) {
                                                        final ExpressionSingleItemView expressionSingleItemView11 = ExpressionSingleItemView.this;
                                                        imageEvent.j(new Function1<LoadSuccessParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.itemview.expression.ExpressionSingleItemView.configView.1.1.4.2.1.2.1
                                                            {
                                                                super(1);
                                                            }

                                                            @Override // kotlin.jvm.functions.Function1
                                                            public final Unit invoke(LoadSuccessParams loadSuccessParams) {
                                                                ExpressionSingleItemView expressionSingleItemView12 = ExpressionSingleItemView.this;
                                                                expressionSingleItemView12.showBackground$delegate.setValue(expressionSingleItemView12, ExpressionSingleItemView.$$delegatedProperties[0], Boolean.FALSE);
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
                                final ExpressionSingleItemView expressionSingleItemView8 = ExpressionSingleItemView.this;
                                Function0<Object> function03 = new Function0<Object>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.itemview.expression.ExpressionSingleItemView.configView.1.1.4.3
                                    {
                                        super(0);
                                    }

                                    @Override // kotlin.jvm.functions.Function0
                                    public final Object invoke() {
                                        ExpressionSingleItemView expressionSingleItemView9 = ExpressionSingleItemView.this;
                                        return Boolean.valueOf(((Boolean) expressionSingleItemView9.showBackground$delegate.getValue(expressionSingleItemView9, ExpressionSingleItemView.$$delegatedProperties[0])).booleanValue());
                                    }
                                };
                                final ExpressionSingleItemView expressionSingleItemView9 = ExpressionSingleItemView.this;
                                ConditionViewKt.c(conditionView2, function03, new Function1<ConditionView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.itemview.expression.ExpressionSingleItemView.configView.1.1.4.4
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(ConditionView conditionView3) {
                                        final ExpressionSingleItemView expressionSingleItemView10 = ExpressionSingleItemView.this;
                                        ah.a(conditionView3, new Function1<ImageView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.itemview.expression.ExpressionSingleItemView.configView.1.1.4.4.1
                                            {
                                                super(1);
                                            }

                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(ImageView imageView) {
                                                final ExpressionSingleItemView expressionSingleItemView11 = ExpressionSingleItemView.this;
                                                imageView.attr(new Function1<af, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.itemview.expression.ExpressionSingleItemView.configView.1.1.4.4.1.1
                                                    {
                                                        super(1);
                                                    }

                                                    @Override // kotlin.jvm.functions.Function1
                                                    public final Unit invoke(af afVar) {
                                                        af afVar2 = afVar;
                                                        afVar2.size(ExpressionSingleItemView.access$getAttr(ExpressionSingleItemView.this).size.getWidth(), ExpressionSingleItemView.access$getAttr(ExpressionSingleItemView.this).size.getHeight());
                                                        b.a.b(afVar2, ExpressionSingleItemView.access$getAttr(ExpressionSingleItemView.this).getExpressionInfo().thumbUrl, false, 2, null);
                                                        Attr.absolutePosition$default(afVar2, 0.0f, 0.0f, 0.0f, 0.0f, 12, null);
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
                        return Unit.INSTANCE;
                    }
                });
                return Unit.INSTANCE;
            }
        };
    }

    @Override // com.tencent.kuikly.core.base.AbstractBaseView
    public final Attr createAttr() {
        return new ExpressionItemAttr();
    }

    @Override // com.tencent.kuikly.core.base.AbstractBaseView
    public final Event createEvent() {
        return new ExpressionItemEvent();
    }
}

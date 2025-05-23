package com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.itemview.ai_picture;

import c01.c;
import com.tencent.hippykotlin.demo.pages.activity.blind_box.yifanshang.detail.view.YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.adelie.module.AdelieKuiklyBaseModule$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.adelie.page.compose.category_home.view.HotViewKt$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.base.BridgeModule;
import com.tencent.hippykotlin.demo.pages.base.ECFastClickUtils;
import com.tencent.hippykotlin.demo.pages.base.EcommerceExtKt;
import com.tencent.hippykotlin.demo.pages.base.QUISkinColor;
import com.tencent.hippykotlin.demo.pages.base.QUISkinImage;
import com.tencent.hippykotlin.demo.pages.base.QUISkinImage$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.base.RefreshListState;
import com.tencent.hippykotlin.demo.pages.base.SkinColor;
import com.tencent.hippykotlin.demo.pages.base.Timer;
import com.tencent.hippykotlin.demo.pages.base.Utils;
import com.tencent.hippykotlin.demo.pages.base.extension.ImageAttrExtKt;
import com.tencent.hippykotlin.demo.pages.base.ktx.IPagerIdKtxKt;
import com.tencent.hippykotlin.demo.pages.foundation.view.PAGAttr;
import com.tencent.hippykotlin.demo.pages.foundation.view.PAGView;
import com.tencent.hippykotlin.demo.pages.foundation.view.PAGViewKt;
import com.tencent.hippykotlin.demo.pages.qsearch_detail_page.PageStatus;
import com.tencent.hippykotlin.demo.pages.qsearch_detail_page.data.pb.AIPictureCardInfo;
import com.tencent.hippykotlin.demo.pages.qsearch_detail_page.data.pb.AIPictureCardItemModel;
import com.tencent.hippykotlin.demo.pages.qsearch_detail_page.data.pb.ImageInfo;
import com.tencent.hippykotlin.demo.pages.qsearch_detail_page.data.pb.template.TemplateItemsKt;
import com.tencent.kuikly.core.base.Attr;
import com.tencent.kuikly.core.base.ComposeView;
import com.tencent.kuikly.core.base.ViewContainer;
import com.tencent.kuikly.core.base.attr.b;
import com.tencent.kuikly.core.base.event.ClickParams;
import com.tencent.kuikly.core.base.event.Event;
import com.tencent.kuikly.core.base.h;
import com.tencent.kuikly.core.base.m;
import com.tencent.kuikly.core.directives.ConditionView;
import com.tencent.kuikly.core.directives.ConditionViewKt;
import com.tencent.kuikly.core.manager.BridgeManager;
import com.tencent.kuikly.core.nvi.serialization.json.e;
import com.tencent.kuikly.core.views.ImageEvent;
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
import com.tencent.mobileqq.troop.activity.TroopAvatarWallPreviewActivity;
import com.tencent.qqlive.module.videoreport.dtreport.constants.DTParamKey;
import cooperation.qqcircle.report.datong.QCircleDaTongConstant;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.properties.ReadWriteProperty;
import kotlin.reflect.KProperty;

/* loaded from: classes32.dex */
public final class QSearchAIPictureCardView extends ComposeView<QSearchAIPictureCardAttr, QSearchAIPictureCardEvent> {
    public static final /* synthetic */ KProperty<Object>[] $$delegatedProperties = {YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0.m(QSearchAIPictureCardView.class, "likeStatus", "getLikeStatus()I", 0)};
    public AIPictureCardItemModel cardItemModel;
    public final ReadWriteProperty likeStatus$delegate = c.a(0);
    public final Lazy loadingPAGToken$delegate;

    public QSearchAIPictureCardView() {
        Lazy lazy;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<String>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.itemview.ai_picture.QSearchAIPictureCardView$loadingPAGToken$2
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final String invoke() {
                if (QSearchAIPictureCardView.this.getPagerData().getIsIOS()) {
                    return "qecommerce_skin_loading_img_sangedian";
                }
                return "ecommerce_skin_loading_img_sangedian";
            }
        });
        this.loadingPAGToken$delegate = lazy;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final /* synthetic */ QSearchAIPictureCardAttr access$getAttr(QSearchAIPictureCardView qSearchAIPictureCardView) {
        return (QSearchAIPictureCardAttr) qSearchAIPictureCardView.getAttr();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.tencent.kuikly.core.base.ComposeView
    public final Function1<ViewContainer<?, ?>, Unit> body() {
        final String str;
        AIPictureCardItemModel aIPictureCardItemModel = ((QSearchAIPictureCardAttr) getAttr()).data;
        if (!(aIPictureCardItemModel instanceof AIPictureCardItemModel)) {
            aIPictureCardItemModel = null;
        }
        this.cardItemModel = aIPictureCardItemModel;
        final AIPictureCardInfo aIPictureCardInfo = aIPictureCardItemModel != null ? aIPictureCardItemModel.cardInfo : null;
        if (aIPictureCardInfo == null || (str = aIPictureCardInfo.loadingText) == null) {
            str = "";
        }
        return new Function1<ViewContainer<?, ?>, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.itemview.ai_picture.QSearchAIPictureCardView$body$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Unit invoke(ViewContainer<?, ?> viewContainer) {
                String str2;
                String str3;
                String str4;
                ViewContainer<?, ?> viewContainer2 = viewContainer;
                final QSearchAIPictureCardView qSearchAIPictureCardView = QSearchAIPictureCardView.this;
                viewContainer2.attr(new Function1<m, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.itemview.ai_picture.QSearchAIPictureCardView$body$1.1
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(m mVar) {
                        m mVar2 = mVar;
                        mVar2.flexDirectionColumn();
                        mVar2.mo153width(mVar2.getPagerData().m() - 16.0f);
                        QSearchAIPictureCardViewModel viewModel = QSearchAIPictureCardView.access$getAttr(QSearchAIPictureCardView.this).getViewModel();
                        mVar2.mo141height(((Number) viewModel.cardHeight$delegate.getValue(viewModel, QSearchAIPictureCardViewModel.$$delegatedProperties[3])).floatValue());
                        mVar2.marginLeft(8.0f).marginRight(8.0f).marginTop(8.0f);
                        mVar2.paddingLeft(16.0f).paddingRight(16.0f).paddingTop(8.0f).paddingBottom(8.0f);
                        mVar2.borderRadius(8.0f);
                        mVar2.mo113backgroundColor(QUISkinColor.INSTANCE.wrapColor("bg_bottom_light"));
                        return Unit.INSTANCE;
                    }
                });
                final QSearchAIPictureCardView qSearchAIPictureCardView2 = QSearchAIPictureCardView.this;
                final AIPictureCardInfo aIPictureCardInfo2 = aIPictureCardInfo;
                qSearchAIPictureCardView2.getClass();
                final String str5 = (aIPictureCardInfo2 == null || (str4 = aIPictureCardInfo2.icon) == null) ? "" : str4;
                final String str6 = (aIPictureCardInfo2 == null || (str3 = aIPictureCardInfo2.topic) == null) ? "" : str3;
                final String str7 = (aIPictureCardInfo2 == null || (str2 = aIPictureCardInfo2.prompt) == null) ? "" : str2;
                w.a(viewContainer2, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.itemview.ai_picture.QSearchAIPictureCardView$createHeaderView$1$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(v vVar) {
                        v vVar2 = vVar;
                        final QSearchAIPictureCardView qSearchAIPictureCardView3 = QSearchAIPictureCardView.this;
                        final AIPictureCardInfo aIPictureCardInfo3 = aIPictureCardInfo2;
                        vVar2.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.itemview.ai_picture.QSearchAIPictureCardView$createHeaderView$1$1.1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(t tVar) {
                                t tVar2 = tVar;
                                tVar2.flexDirectionRow();
                                tVar2.alignItemsCenter();
                                QSearchAIPictureCardView qSearchAIPictureCardView4 = QSearchAIPictureCardView.this;
                                KProperty<Object>[] kPropertyArr = QSearchAIPictureCardView.$$delegatedProperties;
                                e reportParams = qSearchAIPictureCardView4.getReportParams();
                                AIPictureCardInfo aIPictureCardInfo4 = aIPictureCardInfo3;
                                EcommerceExtKt.vr$default(tVar2, null, "em_ai_draw_card", reportParams, null, String.valueOf(aIPictureCardInfo4 != null ? aIPictureCardInfo4.hashCode() : 0), true, 9);
                                return Unit.INSTANCE;
                            }
                        });
                        final String str8 = str5;
                        Function0<Object> function0 = new Function0<Object>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.itemview.ai_picture.QSearchAIPictureCardView$createHeaderView$1$1.2
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(0);
                            }

                            @Override // kotlin.jvm.functions.Function0
                            public final Object invoke() {
                                return Boolean.valueOf(str8.length() > 0);
                            }
                        };
                        final String str9 = str5;
                        ConditionViewKt.c(vVar2, function0, new Function1<ConditionView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.itemview.ai_picture.QSearchAIPictureCardView$createHeaderView$1$1.3
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(ConditionView conditionView) {
                                final String str10 = str9;
                                ah.a(conditionView, new Function1<ImageView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.itemview.ai_picture.QSearchAIPictureCardView.createHeaderView.1.1.3.1
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(ImageView imageView) {
                                        final String str11 = str10;
                                        imageView.attr(new Function1<af, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.itemview.ai_picture.QSearchAIPictureCardView.createHeaderView.1.1.3.1.1
                                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                            {
                                                super(1);
                                            }

                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(af afVar) {
                                                af afVar2 = afVar;
                                                ImageAttrExtKt.srcUrl(afVar2, str11, null);
                                                afVar2.mo153width(16.0f);
                                                afVar2.mo141height(16.0f);
                                                afVar2.marginRight(8.0f);
                                                return Unit.INSTANCE;
                                            }
                                        });
                                        return Unit.INSTANCE;
                                    }
                                });
                                return Unit.INSTANCE;
                            }
                        });
                        final String str10 = str6;
                        final String str11 = str7;
                        w.a(vVar2, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.itemview.ai_picture.QSearchAIPictureCardView$createHeaderView$1$1.4
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(v vVar3) {
                                v vVar4 = vVar3;
                                vVar4.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.itemview.ai_picture.QSearchAIPictureCardView.createHeaderView.1.1.4.1
                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(t tVar) {
                                        t tVar2 = tVar;
                                        tVar2.flexDirectionRow();
                                        tVar2.alignItemsFlexStart();
                                        tVar2.m140flex(1.0f);
                                        return Unit.INSTANCE;
                                    }
                                });
                                final String str12 = str10;
                                cg.a(vVar4, new Function1<TextView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.itemview.ai_picture.QSearchAIPictureCardView.createHeaderView.1.1.4.2
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(TextView textView) {
                                        final String str13 = str12;
                                        textView.attr(new Function1<ce, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.itemview.ai_picture.QSearchAIPictureCardView.createHeaderView.1.1.4.2.1
                                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                            {
                                                super(1);
                                            }

                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(ce ceVar) {
                                                ce ceVar2 = ceVar;
                                                ceVar2.alignSelfFlexStart();
                                                ceVar2.lineHeight(20.0f);
                                                ceVar2.text(str13);
                                                ce.fontSize$default(ceVar2, 14.0f, null, 2, null);
                                                ceVar2.lines(1);
                                                ceVar2.color(QUISkinColor.INSTANCE.wrapColor("text_secondary"));
                                                return Unit.INSTANCE;
                                            }
                                        });
                                        return Unit.INSTANCE;
                                    }
                                });
                                final String str13 = str11;
                                cg.a(vVar4, new Function1<TextView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.itemview.ai_picture.QSearchAIPictureCardView.createHeaderView.1.1.4.3
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(TextView textView) {
                                        final String str14 = str13;
                                        textView.attr(new Function1<ce, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.itemview.ai_picture.QSearchAIPictureCardView.createHeaderView.1.1.4.3.1
                                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                            {
                                                super(1);
                                            }

                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(ce ceVar) {
                                                ce ceVar2 = ceVar;
                                                ceVar2.alignSelfFlexStart();
                                                ceVar2.lineHeight(20.0f);
                                                ceVar2.marginLeft(8.0f);
                                                ceVar2.text('\"' + str14 + '\"');
                                                ce.fontSize$default(ceVar2, 14.0f, null, 2, null);
                                                ceVar2.lines(1);
                                                ceVar2.m140flex(1.0f);
                                                ceVar2.textOverFlowTail();
                                                ceVar2.color(QUISkinColor.INSTANCE.wrapColor("brand_standard"));
                                                return Unit.INSTANCE;
                                            }
                                        });
                                        return Unit.INSTANCE;
                                    }
                                });
                                return Unit.INSTANCE;
                            }
                        });
                        final QSearchAIPictureCardView qSearchAIPictureCardView4 = QSearchAIPictureCardView.this;
                        ConditionViewKt.c(vVar2, new Function0<Object>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.itemview.ai_picture.QSearchAIPictureCardView$createHeaderView$1$1.5
                            {
                                super(0);
                            }

                            @Override // kotlin.jvm.functions.Function0
                            public final Object invoke() {
                                return Boolean.valueOf(QSearchAIPictureCardView.access$getAttr(QSearchAIPictureCardView.this).getViewModel().getCardStatus() == 0);
                            }
                        }, new Function1<ConditionView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.itemview.ai_picture.QSearchAIPictureCardView$createHeaderView$1$1.6
                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(ConditionView conditionView) {
                                ah.a(conditionView, new Function1<ImageView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.itemview.ai_picture.QSearchAIPictureCardView.createHeaderView.1.1.6.1
                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(ImageView imageView) {
                                        imageView.attr(new Function1<af, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.itemview.ai_picture.QSearchAIPictureCardView.createHeaderView.1.1.6.1.1
                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(af afVar) {
                                                String sb5;
                                                af afVar2 = afVar;
                                                afVar2.marginLeft(8.0f);
                                                afVar2.mo153width(16.0f);
                                                afVar2.mo141height(16.0f);
                                                afVar2.o();
                                                String str12 = "qui_image://chevron_down?color=text_secondary";
                                                if (SkinColor.INSTANCE.isNightMode(BridgeManager.f117344a.u())) {
                                                    StringBuilder m3 = HotViewKt$$ExternalSyntheticOutline0.m(str12, "&image_unique_id=");
                                                    m3.append(SkinColor.colorUniqueID);
                                                    sb5 = m3.toString();
                                                } else {
                                                    StringBuilder m16 = HotViewKt$$ExternalSyntheticOutline0.m(str12, "&image_unique_id=");
                                                    m16.append(SkinColor.colorUniqueID);
                                                    sb5 = m16.toString();
                                                }
                                                b.a.b(afVar2, sb5, false, 2, null);
                                                return Unit.INSTANCE;
                                            }
                                        });
                                        return Unit.INSTANCE;
                                    }
                                });
                                return Unit.INSTANCE;
                            }
                        });
                        final QSearchAIPictureCardView qSearchAIPictureCardView5 = QSearchAIPictureCardView.this;
                        vVar2.event(new Function1<u, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.itemview.ai_picture.QSearchAIPictureCardView$createHeaderView$1$1.7
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(u uVar) {
                                final QSearchAIPictureCardView qSearchAIPictureCardView6 = QSearchAIPictureCardView.this;
                                uVar.click(new Function1<ClickParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.itemview.ai_picture.QSearchAIPictureCardView.createHeaderView.1.1.7.1
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(ClickParams clickParams) {
                                        QSearchAIPictureCardViewModel viewModel = QSearchAIPictureCardView.access$getAttr(QSearchAIPictureCardView.this).getViewModel();
                                        if (viewModel.getCardStatus() == 0) {
                                            viewModel.startTime = Utils.INSTANCE.currentBridgeModule().currentTimeStamp();
                                            viewModel.endTime = 0L;
                                            viewModel.errorCode = 0;
                                            viewModel.stoped = false;
                                            viewModel.setCardStatus(1);
                                            viewModel.setCardHeight(97.0f);
                                            viewModel.innerLoadData("", true);
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
                final QSearchAIPictureCardView qSearchAIPictureCardView3 = QSearchAIPictureCardView.this;
                Function0<Object> function0 = new Function0<Object>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.itemview.ai_picture.QSearchAIPictureCardView$body$1.2
                    {
                        super(0);
                    }

                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return Boolean.valueOf(QSearchAIPictureCardView.access$getAttr(QSearchAIPictureCardView.this).getViewModel().getCardStatus() == 1);
                    }
                };
                final QSearchAIPictureCardView qSearchAIPictureCardView4 = QSearchAIPictureCardView.this;
                final String str8 = str;
                ConditionViewKt.c(viewContainer2, function0, new Function1<ConditionView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.itemview.ai_picture.QSearchAIPictureCardView$body$1.3
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(ConditionView conditionView) {
                        final QSearchAIPictureCardView qSearchAIPictureCardView5 = QSearchAIPictureCardView.this;
                        final String str9 = str8;
                        w.a(conditionView, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.itemview.ai_picture.QSearchAIPictureCardView.body.1.3.1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(v vVar) {
                                v vVar2 = vVar;
                                vVar2.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.itemview.ai_picture.QSearchAIPictureCardView.body.1.3.1.1
                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(t tVar) {
                                        t tVar2 = tVar;
                                        tVar2.alignItemsCenter();
                                        tVar2.alignSelfCenter();
                                        tVar2.flexDirectionRow();
                                        tVar2.m140flex(1.0f);
                                        return Unit.INSTANCE;
                                    }
                                });
                                final QSearchAIPictureCardView qSearchAIPictureCardView6 = QSearchAIPictureCardView.this;
                                PAGViewKt.PAG(vVar2, new Function1<PAGView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.itemview.ai_picture.QSearchAIPictureCardView.body.1.3.1.2
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(PAGView pAGView) {
                                        final QSearchAIPictureCardView qSearchAIPictureCardView7 = QSearchAIPictureCardView.this;
                                        pAGView.attr(new Function1<PAGAttr, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.itemview.ai_picture.QSearchAIPictureCardView.body.1.3.1.2.1
                                            {
                                                super(1);
                                            }

                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(PAGAttr pAGAttr) {
                                                PAGAttr pAGAttr2 = pAGAttr;
                                                pAGAttr2.size(16.0f, 16.0f);
                                                pAGAttr2.alignSelfCenter();
                                                pAGAttr2.repeatCount(Integer.MAX_VALUE);
                                                pAGAttr2.autoPlay(true);
                                                pAGAttr2.src((String) QSearchAIPictureCardView.this.loadingPAGToken$delegate.getValue());
                                                return Unit.INSTANCE;
                                            }
                                        });
                                        return Unit.INSTANCE;
                                    }
                                });
                                final String str10 = str9;
                                cg.a(vVar2, new Function1<TextView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.itemview.ai_picture.QSearchAIPictureCardView.body.1.3.1.3
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(TextView textView) {
                                        final String str11 = str10;
                                        textView.attr(new Function1<ce, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.itemview.ai_picture.QSearchAIPictureCardView.body.1.3.1.3.1
                                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                            {
                                                super(1);
                                            }

                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(ce ceVar) {
                                                ce ceVar2 = ceVar;
                                                ceVar2.text(str11);
                                                ceVar2.color(QUISkinColor.INSTANCE.wrapColor("text_secondary"));
                                                ce.fontSize$default(ceVar2, 14.0f, null, 2, null);
                                                ceVar2.lineHeight(20.0f);
                                                ceVar2.marginLeft(6.0f);
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
                final QSearchAIPictureCardView qSearchAIPictureCardView5 = QSearchAIPictureCardView.this;
                Function0<Object> function02 = new Function0<Object>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.itemview.ai_picture.QSearchAIPictureCardView$body$1.4
                    {
                        super(0);
                    }

                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return Boolean.valueOf(QSearchAIPictureCardView.access$getAttr(QSearchAIPictureCardView.this).getViewModel().getCardStatus() == 3);
                    }
                };
                final QSearchAIPictureCardView qSearchAIPictureCardView6 = QSearchAIPictureCardView.this;
                final AIPictureCardInfo aIPictureCardInfo3 = aIPictureCardInfo;
                ConditionViewKt.b(viewContainer2, function02, new Function1<ConditionView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.itemview.ai_picture.QSearchAIPictureCardView$body$1.5
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(ConditionView conditionView) {
                        final QSearchAIPictureCardView qSearchAIPictureCardView7 = QSearchAIPictureCardView.this;
                        final AIPictureCardInfo aIPictureCardInfo4 = aIPictureCardInfo3;
                        w.a(conditionView, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.itemview.ai_picture.QSearchAIPictureCardView.body.1.5.1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(v vVar) {
                                v vVar2 = vVar;
                                final QSearchAIPictureCardView qSearchAIPictureCardView8 = QSearchAIPictureCardView.this;
                                final AIPictureCardInfo aIPictureCardInfo5 = aIPictureCardInfo4;
                                vVar2.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.itemview.ai_picture.QSearchAIPictureCardView.body.1.5.1.1
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(t tVar) {
                                        t tVar2 = tVar;
                                        tVar2.alignItemsCenter();
                                        tVar2.alignSelfCenter();
                                        tVar2.flexDirectionRow();
                                        tVar2.m140flex(1.0f);
                                        e buildReportData = QSearchAIPictureCardView.access$getAttr(QSearchAIPictureCardView.this).getViewModel().buildReportData(QSearchAIPictureCardView.this.getReportParams());
                                        AIPictureCardInfo aIPictureCardInfo6 = aIPictureCardInfo5;
                                        EcommerceExtKt.vr$default(tVar2, null, "em_ai_draw_fail", buildReportData, null, String.valueOf(aIPictureCardInfo6 != null ? aIPictureCardInfo6.hashCode() : 0), true, 9);
                                        return Unit.INSTANCE;
                                    }
                                });
                                final QSearchAIPictureCardView qSearchAIPictureCardView9 = QSearchAIPictureCardView.this;
                                cg.a(vVar2, new Function1<TextView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.itemview.ai_picture.QSearchAIPictureCardView.body.1.5.1.2
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(TextView textView) {
                                        final QSearchAIPictureCardView qSearchAIPictureCardView10 = QSearchAIPictureCardView.this;
                                        textView.attr(new Function1<ce, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.itemview.ai_picture.QSearchAIPictureCardView.body.1.5.1.2.1
                                            {
                                                super(1);
                                            }

                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(ce ceVar) {
                                                ce ceVar2 = ceVar;
                                                QSearchAIPictureCardViewModel viewModel = QSearchAIPictureCardView.access$getAttr(QSearchAIPictureCardView.this).getViewModel();
                                                ceVar2.text((String) viewModel.cardText$delegate.getValue(viewModel, QSearchAIPictureCardViewModel.$$delegatedProperties[4]));
                                                ceVar2.color(QUISkinColor.INSTANCE.wrapColor("text_secondary"));
                                                ce.fontSize$default(ceVar2, 14.0f, null, 2, null);
                                                ceVar2.lineHeight(20.0f);
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
                final QSearchAIPictureCardView qSearchAIPictureCardView7 = QSearchAIPictureCardView.this;
                Function0<Object> function03 = new Function0<Object>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.itemview.ai_picture.QSearchAIPictureCardView$body$1.6
                    {
                        super(0);
                    }

                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return Boolean.valueOf(QSearchAIPictureCardView.access$getAttr(QSearchAIPictureCardView.this).getViewModel().getCardStatus() == 2);
                    }
                };
                final QSearchAIPictureCardView qSearchAIPictureCardView8 = QSearchAIPictureCardView.this;
                final AIPictureCardInfo aIPictureCardInfo4 = aIPictureCardInfo;
                ConditionViewKt.b(viewContainer2, function03, new Function1<ConditionView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.itemview.ai_picture.QSearchAIPictureCardView$body$1.7
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(ConditionView conditionView) {
                        String str9;
                        String str10;
                        ConditionView conditionView2 = conditionView;
                        final QSearchAIPictureCardView qSearchAIPictureCardView9 = QSearchAIPictureCardView.this;
                        final AIPictureCardInfo aIPictureCardInfo5 = aIPictureCardInfo4;
                        ah.a(conditionView2, new Function1<ImageView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.itemview.ai_picture.QSearchAIPictureCardView.body.1.7.1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(ImageView imageView) {
                                ImageView imageView2 = imageView;
                                final QSearchAIPictureCardView qSearchAIPictureCardView10 = QSearchAIPictureCardView.this;
                                final AIPictureCardInfo aIPictureCardInfo6 = aIPictureCardInfo5;
                                imageView2.attr(new Function1<af, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.itemview.ai_picture.QSearchAIPictureCardView.body.1.7.1.1
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(af afVar) {
                                        String str11;
                                        af afVar2 = afVar;
                                        afVar2.size(QSearchAIPictureCardView.access$getAttr(QSearchAIPictureCardView.this).getViewModel().getImageSize().getWidth(), QSearchAIPictureCardView.access$getAttr(QSearchAIPictureCardView.this).getViewModel().getImageSize().getHeight());
                                        afVar2.p();
                                        ImageInfo imageInfo = QSearchAIPictureCardView.access$getAttr(QSearchAIPictureCardView.this).getViewModel().getImageInfo();
                                        if (imageInfo == null || (str11 = imageInfo.orgDownUrl) == null) {
                                            str11 = "";
                                        }
                                        ImageAttrExtKt.srcUrl(afVar2, str11, null);
                                        afVar2.borderRadius(8.0f);
                                        afVar2.alignSelfCenter();
                                        afVar2.marginTop(8.0f).marginBottom(4.0f);
                                        e buildReportData = QSearchAIPictureCardView.access$getAttr(QSearchAIPictureCardView.this).getViewModel().buildReportData(QSearchAIPictureCardView.this.getReportParams());
                                        AIPictureCardInfo aIPictureCardInfo7 = aIPictureCardInfo6;
                                        EcommerceExtKt.vr$default(afVar2, null, "em_ai_draw_result", buildReportData, null, String.valueOf(aIPictureCardInfo7 != null ? aIPictureCardInfo7.hashCode() : 0), true, 9);
                                        return Unit.INSTANCE;
                                    }
                                });
                                final QSearchAIPictureCardView qSearchAIPictureCardView11 = QSearchAIPictureCardView.this;
                                imageView2.event(new Function1<ImageEvent, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.itemview.ai_picture.QSearchAIPictureCardView.body.1.7.1.2
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(ImageEvent imageEvent) {
                                        final QSearchAIPictureCardView qSearchAIPictureCardView12 = QSearchAIPictureCardView.this;
                                        imageEvent.click(new Function1<ClickParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.itemview.ai_picture.QSearchAIPictureCardView.body.1.7.1.2.1
                                            {
                                                super(1);
                                            }

                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(ClickParams clickParams) {
                                                String str11;
                                                ArrayList arrayListOf;
                                                ImageInfo imageInfo = QSearchAIPictureCardView.access$getAttr(QSearchAIPictureCardView.this).getViewModel().getImageInfo();
                                                if (imageInfo == null || (str11 = imageInfo.orgDownUrl) == null) {
                                                    str11 = "";
                                                }
                                                arrayListOf = CollectionsKt__CollectionsKt.arrayListOf(str11);
                                                Object[] array = arrayListOf.toArray(new String[0]);
                                                Intrinsics.checkNotNull(array, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
                                                LinkedHashMap linkedHashMap = new LinkedHashMap();
                                                linkedHashMap.put(TroopAvatarWallPreviewActivity.KEY_DT_PG_ID, QCircleDaTongConstant.PageId.PG_QQ_PIC_VIEW_PAGE);
                                                linkedHashMap.put("pic_id", str11);
                                                linkedHashMap.put("is_from_qsearch", "1");
                                                Unit unit = Unit.INSTANCE;
                                                BridgeModule currentBridgeModule = Utils.INSTANCE.currentBridgeModule();
                                                e eVar = new e();
                                                com.tencent.kuikly.core.nvi.serialization.json.b bVar = new com.tencent.kuikly.core.nvi.serialization.json.b();
                                                for (String str12 : (String[]) array) {
                                                    bVar.t(str12);
                                                }
                                                eVar.v("photosUrl", bVar);
                                                eVar.t("photosIndex", 0);
                                                e eVar2 = new e();
                                                for (Map.Entry entry : linkedHashMap.entrySet()) {
                                                    eVar2.v((String) entry.getKey(), entry.getValue());
                                                }
                                                Unit unit2 = Unit.INSTANCE;
                                                eVar.v("extInfoMap", eVar2);
                                                currentBridgeModule.showPhotoBrowser(eVar);
                                                return Unit.INSTANCE;
                                            }
                                        });
                                        return Unit.INSTANCE;
                                    }
                                });
                                return Unit.INSTANCE;
                            }
                        });
                        final QSearchAIPictureCardView qSearchAIPictureCardView10 = QSearchAIPictureCardView.this;
                        final AIPictureCardInfo aIPictureCardInfo6 = aIPictureCardInfo4;
                        KProperty<Object>[] kPropertyArr = QSearchAIPictureCardView.$$delegatedProperties;
                        qSearchAIPictureCardView10.getClass();
                        if (aIPictureCardInfo6 == null || (str9 = aIPictureCardInfo6.actionText) == null) {
                            str9 = "\u753b\u56fe\u673a\u5668\u4eba";
                        }
                        final String str11 = str9;
                        if (aIPictureCardInfo6 == null || (str10 = aIPictureCardInfo6.actionUrl) == null) {
                            str10 = "";
                        }
                        final String str12 = str10;
                        final e reportParams = qSearchAIPictureCardView10.getReportParams();
                        w.a(conditionView2, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.itemview.ai_picture.QSearchAIPictureCardView$createFooterView$1$1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(v vVar) {
                                v vVar2 = vVar;
                                vVar2.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.itemview.ai_picture.QSearchAIPictureCardView$createFooterView$1$1.1
                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(t tVar) {
                                        t tVar2 = tVar;
                                        tVar2.flexDirectionRow();
                                        tVar2.alignItemsCenter();
                                        tVar2.mo141height(20.0f);
                                        return Unit.INSTANCE;
                                    }
                                });
                                final QSearchAIPictureCardView qSearchAIPictureCardView11 = QSearchAIPictureCardView.this;
                                final AIPictureCardInfo aIPictureCardInfo7 = aIPictureCardInfo6;
                                qSearchAIPictureCardView11.getClass();
                                final e reportParams2 = qSearchAIPictureCardView11.getReportParams();
                                final Ref.ObjectRef objectRef = new Ref.ObjectRef();
                                objectRef.element = "like";
                                final Ref.ObjectRef objectRef2 = new Ref.ObjectRef();
                                objectRef2.element = QCircleDaTongConstant.ElementParamValue.DISLIKE;
                                ah.a(vVar2, new Function1<ImageView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.itemview.ai_picture.QSearchAIPictureCardView$createFeedbackView$1$1
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(ImageView imageView) {
                                        ImageView imageView2 = imageView;
                                        final QSearchAIPictureCardView qSearchAIPictureCardView12 = QSearchAIPictureCardView.this;
                                        final Ref.ObjectRef<String> objectRef3 = objectRef;
                                        final e eVar = reportParams2;
                                        final AIPictureCardInfo aIPictureCardInfo8 = aIPictureCardInfo7;
                                        imageView2.attr(new Function1<af, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.itemview.ai_picture.QSearchAIPictureCardView$createFeedbackView$1$1.1
                                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                            {
                                                super(1);
                                            }

                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(af afVar) {
                                                int intValue;
                                                String sb5;
                                                String sb6;
                                                af afVar2 = afVar;
                                                afVar2.size(16.0f, 16.0f);
                                                intValue = ((Number) r10.likeStatus$delegate.getValue(QSearchAIPictureCardView.this, QSearchAIPictureCardView.$$delegatedProperties[0])).intValue();
                                                if (intValue == 1) {
                                                    objectRef3.element = "cancel";
                                                    String m3 = QUISkinImage$$ExternalSyntheticOutline0.m("qui_image://", "like_filled", "?color=", "text_secondary");
                                                    if (SkinColor.INSTANCE.isNightMode(BridgeManager.f117344a.u())) {
                                                        StringBuilder m16 = HotViewKt$$ExternalSyntheticOutline0.m(m3, "&image_unique_id=");
                                                        m16.append(SkinColor.colorUniqueID);
                                                        sb6 = m16.toString();
                                                    } else {
                                                        StringBuilder m17 = HotViewKt$$ExternalSyntheticOutline0.m(m3, "&image_unique_id=");
                                                        m17.append(SkinColor.colorUniqueID);
                                                        sb6 = m17.toString();
                                                    }
                                                    b.a.b(afVar2, sb6, false, 2, null);
                                                } else {
                                                    objectRef3.element = "like";
                                                    String m18 = QUISkinImage$$ExternalSyntheticOutline0.m("qui_image://", "like", "?color=", "text_secondary");
                                                    if (SkinColor.INSTANCE.isNightMode(BridgeManager.f117344a.u())) {
                                                        StringBuilder m19 = HotViewKt$$ExternalSyntheticOutline0.m(m18, "&image_unique_id=");
                                                        m19.append(SkinColor.colorUniqueID);
                                                        sb5 = m19.toString();
                                                    } else {
                                                        StringBuilder m26 = HotViewKt$$ExternalSyntheticOutline0.m(m18, "&image_unique_id=");
                                                        m26.append(SkinColor.colorUniqueID);
                                                        sb5 = m26.toString();
                                                    }
                                                    b.a.b(afVar2, sb5, false, 2, null);
                                                }
                                                e eVar2 = eVar;
                                                eVar2.v("action_type", objectRef3.element);
                                                Unit unit = Unit.INSTANCE;
                                                AIPictureCardInfo aIPictureCardInfo9 = aIPictureCardInfo8;
                                                EcommerceExtKt.vr$default(afVar2, null, "em_like_button", eVar2, null, String.valueOf(aIPictureCardInfo9 != null ? aIPictureCardInfo9.hashCode() : 0), true, 9);
                                                return Unit.INSTANCE;
                                            }
                                        });
                                        final QSearchAIPictureCardView qSearchAIPictureCardView13 = QSearchAIPictureCardView.this;
                                        imageView2.event(new Function1<ImageEvent, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.itemview.ai_picture.QSearchAIPictureCardView$createFeedbackView$1$1.2
                                            {
                                                super(1);
                                            }

                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(ImageEvent imageEvent) {
                                                final QSearchAIPictureCardView qSearchAIPictureCardView14 = QSearchAIPictureCardView.this;
                                                imageEvent.click(new Function1<ClickParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.itemview.ai_picture.QSearchAIPictureCardView.createFeedbackView.1.1.2.1
                                                    {
                                                        super(1);
                                                    }

                                                    @Override // kotlin.jvm.functions.Function1
                                                    public final Unit invoke(ClickParams clickParams) {
                                                        int intValue;
                                                        intValue = ((Number) r2.likeStatus$delegate.getValue(QSearchAIPictureCardView.this, QSearchAIPictureCardView.$$delegatedProperties[0])).intValue();
                                                        if (intValue != 1) {
                                                            r2.likeStatus$delegate.setValue(QSearchAIPictureCardView.this, QSearchAIPictureCardView.$$delegatedProperties[0], Integer.valueOf(1));
                                                        } else {
                                                            r2.likeStatus$delegate.setValue(QSearchAIPictureCardView.this, QSearchAIPictureCardView.$$delegatedProperties[0], Integer.valueOf(0));
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
                                ah.a(vVar2, new Function1<ImageView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.itemview.ai_picture.QSearchAIPictureCardView$createFeedbackView$1$2
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(ImageView imageView) {
                                        ImageView imageView2 = imageView;
                                        final QSearchAIPictureCardView qSearchAIPictureCardView12 = QSearchAIPictureCardView.this;
                                        final Ref.ObjectRef<String> objectRef3 = objectRef2;
                                        final e eVar = reportParams2;
                                        final AIPictureCardInfo aIPictureCardInfo8 = aIPictureCardInfo7;
                                        imageView2.attr(new Function1<af, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.itemview.ai_picture.QSearchAIPictureCardView$createFeedbackView$1$2.1
                                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                            {
                                                super(1);
                                            }

                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(af afVar) {
                                                int intValue;
                                                af afVar2 = afVar;
                                                afVar2.size(16.0f, 16.0f);
                                                afVar2.marginLeft(16.0f);
                                                intValue = ((Number) r9.likeStatus$delegate.getValue(QSearchAIPictureCardView.this, QSearchAIPictureCardView.$$delegatedProperties[0])).intValue();
                                                if (intValue == 2) {
                                                    objectRef3.element = "cancel";
                                                    b.a.b(afVar2, "data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAADAAAAAwCAYAAABXAvmHAAAACXBIWXMAACE4AAAhOAFFljFgAAAAAXNSR0IArs4c6QAAAARnQU1BAACxjwv8YQUAAAJQSURBVHgB7ZhPTsJAFMZfCwsTElJvgAlhwQp37ixbAhFPIJ5APIF6A5fu1BtUIGzt0p0uCWxcumwCS/74TagJodN2mhmgE/tLGkr7mszX6ffmzSPKyPjfGLyL7Xa7tFgsnnFaw2HR/vBwOLlc7sFxnG+RBwIC/MG/47REh8PDGOrD4fArLtDcvjCfz+/psINnWJiFd9u2Y2c/IMAwjAtKB1ahUOjEBeV5D27+6ff7gc+s1WqtaA+Ypmnj5zEyhtLNeVxA2gVYjUajFhWQdgHMk3bU/dQL8H0Qfp/ST6QPdBAQ6QMdBET6QAsB8EHo4qqFAFoXlVx0EWA1m02bd0MXAbRarbizoI2AMB9oI4BCfKCTAK4PdBLA9YFWAng+0EoAcXygm4DAHpm3pfQ2A/e1fRQBHgh0KUyRoLQADwT2xwEB+Xz+mtazkCpQkT70er3X7esBAawjhp7MKWbCpcPjsXHgqGPw97wAI+ppdOmYF7jNJTTAOngrd5QQNpjBYOCSIgySACvjC0RcUTJe0Gu6JkVIpVH4pQsBSU3fEWkZiiIlAH7xkBkucfqd5LlisdglRUh9Qn/4He1PEm/Fe9Pp9MR1Xelsp2QlZpkL5kzyXVuqZkFZKYHM4uDnVjQegm9IATlSyHg8/qhUKscw9plA+FG5XH6bTCY/JIHyYg4z0RVdBLFg1kiSnVSjSK9CmQlCY2Pi2IkAll7xdusUI2I2m0kXjjvbD/g1VehMsOJMRRpVauJtRqPRT7VafVsul8zYJVw68v1xi3LiiTIyMqT5BZDws/sYhrm8AAAAAElFTkSuQmCC", false, 2, null);
                                                } else {
                                                    objectRef3.element = QCircleDaTongConstant.ElementParamValue.DISLIKE;
                                                    b.a.b(afVar2, "data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAADAAAAAwCAYAAABXAvmHAAAACXBIWXMAACE4AAAhOAFFljFgAAAAAXNSR0IArs4c6QAAAARnQU1BAACxjwv8YQUAAAMRSURBVHgB7VlLctpAEG3Ed8kRuEHICeKcIOEECRsoioXhBMAJIAuKz0bOCWyfIOQEISeIjkB2FMUnr+NJZWgNkiwpzrisV+Wipmnk7ul/iyhDhpeNnIk4m81q+XzePZ1OdRyr9JQC5XJr/N9Ju93+HIlfElh4x3G+0RMLboB3PB7fdjodL4jJ8REcZ0z/X3gGX+QX13UDZXEMtPdkD2rb7bYXxFCgEMAXfW62WCxOYTxxwO6LjyFu/sMfGmLxTdBvHLII7O+VSuXsxhHQV0FuZJUCjGazuUEmWuk0uNFFt7ZOAQayz3f9HORGVioAt7kT5+dlAcTCCh8bjVRdLpd1E6+VCjC4IutnDmYTn7UK7Pf7e/0Mhd6Z+Gy2gIyDuimdWquA6oE8jVRFOvXFgbUKMHDr0o182chqBWRBw9lXD6xWoFQqrQTJFwdWKxClrbBaAcbhcPiqn2VbYb0CwEo/yIJmvQKqrdBR0w/WK4DhSaZOvUcyTmTMUNUecKKYmE6n9WKxeE0JIDtRWaF9Cqi1xhWlgG63u1Y3mNqSAEE90s+OgaFJwkxhuNTqMjCcfKKUgGeN5JrFpwAzgPG1HCqCAN7bS3MrZtwJPfJCDPDw14BsQ/lFrG2CcovbswflcjetVqtp4se2gTcNA8Hfg7V/Ujg8Qyb6+xyKifl8PoEQMkD7WLFMJC9bZ7fb/SAtFpQ7DCkhYqfRcrk8xMdakAdqt3MGbglkLMAi12FbtyiIrYASqkFidkWpN8aDIRbYKh8pIRIVMpURztIaT04QbCB5TVYAEtUIRuJKzD4PoaVgPUMFNVmhhlgyzrpRkUoroeLBE2RXxoOywr3gM2auqEhFARYMW4SGIHM8uAb2G/2ATPaKEiC1Zo7bBnz0dRq3JHClcchPExW5VLtRjgc5QdFDPPzeOHNzh/R5ZhW5wHosUm+n0X2yK3mCPOautlAo8Kurmv4FqnGkd2GXkLoCKlAjBSa3H0FtQhT8k4GGhVJKBPn3HazVp4RI5dXQJWivjDjTcMu9QWDzvDFKevMZMmR4wC/GuEZVWaG+xQAAAABJRU5ErkJggg==", false, 2, null);
                                                }
                                                e eVar2 = eVar;
                                                eVar2.v("action_type", objectRef3.element);
                                                Unit unit = Unit.INSTANCE;
                                                AIPictureCardInfo aIPictureCardInfo9 = aIPictureCardInfo8;
                                                EcommerceExtKt.vr$default(afVar2, null, "em_dislike_button", eVar2, null, String.valueOf(aIPictureCardInfo9 != null ? aIPictureCardInfo9.hashCode() : 0), true, 9);
                                                return Unit.INSTANCE;
                                            }
                                        });
                                        final QSearchAIPictureCardView qSearchAIPictureCardView13 = QSearchAIPictureCardView.this;
                                        imageView2.event(new Function1<ImageEvent, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.itemview.ai_picture.QSearchAIPictureCardView$createFeedbackView$1$2.2
                                            {
                                                super(1);
                                            }

                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(ImageEvent imageEvent) {
                                                final QSearchAIPictureCardView qSearchAIPictureCardView14 = QSearchAIPictureCardView.this;
                                                imageEvent.click(new Function1<ClickParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.itemview.ai_picture.QSearchAIPictureCardView.createFeedbackView.1.2.2.1
                                                    {
                                                        super(1);
                                                    }

                                                    @Override // kotlin.jvm.functions.Function1
                                                    public final Unit invoke(ClickParams clickParams) {
                                                        int intValue;
                                                        intValue = ((Number) r2.likeStatus$delegate.getValue(QSearchAIPictureCardView.this, QSearchAIPictureCardView.$$delegatedProperties[0])).intValue();
                                                        if (intValue != 2) {
                                                            r2.likeStatus$delegate.setValue(QSearchAIPictureCardView.this, QSearchAIPictureCardView.$$delegatedProperties[0], Integer.valueOf(2));
                                                        } else {
                                                            r2.likeStatus$delegate.setValue(QSearchAIPictureCardView.this, QSearchAIPictureCardView.$$delegatedProperties[0], Integer.valueOf(0));
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
                                final e eVar = reportParams;
                                final AIPictureCardInfo aIPictureCardInfo8 = aIPictureCardInfo6;
                                final String str13 = str11;
                                final String str14 = str12;
                                w.a(vVar2, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.itemview.ai_picture.QSearchAIPictureCardView$createFooterView$1$1.2
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(v vVar3) {
                                        v vVar4 = vVar3;
                                        final e eVar2 = e.this;
                                        final AIPictureCardInfo aIPictureCardInfo9 = aIPictureCardInfo8;
                                        vVar4.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.itemview.ai_picture.QSearchAIPictureCardView.createFooterView.1.1.2.1
                                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                            {
                                                super(1);
                                            }

                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(t tVar) {
                                                t tVar2 = tVar;
                                                tVar2.flexDirectionRow();
                                                Attr.absolutePosition$default(tVar2, 0.0f, 0.0f, 0.0f, 0.0f, 3, null);
                                                e eVar3 = e.this;
                                                AIPictureCardInfo aIPictureCardInfo10 = aIPictureCardInfo9;
                                                EcommerceExtKt.vr$default(tVar2, null, "em_ai_draw_robot_entrance", eVar3, null, String.valueOf(aIPictureCardInfo10 != null ? aIPictureCardInfo10.hashCode() : 0), true, 9);
                                                return Unit.INSTANCE;
                                            }
                                        });
                                        final String str15 = str13;
                                        cg.a(vVar4, new Function1<TextView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.itemview.ai_picture.QSearchAIPictureCardView.createFooterView.1.1.2.2
                                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                            {
                                                super(1);
                                            }

                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(TextView textView) {
                                                final String str16 = str15;
                                                textView.attr(new Function1<ce, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.itemview.ai_picture.QSearchAIPictureCardView.createFooterView.1.1.2.2.1
                                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                    {
                                                        super(1);
                                                    }

                                                    @Override // kotlin.jvm.functions.Function1
                                                    public final Unit invoke(ce ceVar) {
                                                        h subTextColor;
                                                        ce ceVar2 = ceVar;
                                                        ceVar2.text(str16);
                                                        subTextColor = SkinColor.INSTANCE.subTextColor(BridgeManager.f117344a.u());
                                                        ceVar2.color(subTextColor);
                                                        ce.fontSize$default(ceVar2, 14.0f, null, 2, null);
                                                        ceVar2.fontWeight400();
                                                        return Unit.INSTANCE;
                                                    }
                                                });
                                                return Unit.INSTANCE;
                                            }
                                        });
                                        ah.a(vVar4, new Function1<ImageView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.itemview.ai_picture.QSearchAIPictureCardView.createFooterView.1.1.2.3
                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(ImageView imageView) {
                                                imageView.attr(new Function1<af, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.itemview.ai_picture.QSearchAIPictureCardView.createFooterView.1.1.2.3.1
                                                    @Override // kotlin.jvm.functions.Function1
                                                    public final Unit invoke(af afVar) {
                                                        af afVar2 = afVar;
                                                        afVar2.marginLeft(3.0f);
                                                        afVar2.mo153width(16.0f);
                                                        afVar2.mo141height(16.0f);
                                                        afVar2.o();
                                                        b.a.b(afVar2, QUISkinImage.INSTANCE.viewMoreArrow(), false, 2, null);
                                                        return Unit.INSTANCE;
                                                    }
                                                });
                                                return Unit.INSTANCE;
                                            }
                                        });
                                        final String str16 = str14;
                                        vVar4.event(new Function1<u, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.itemview.ai_picture.QSearchAIPictureCardView.createFooterView.1.1.2.4
                                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                            {
                                                super(1);
                                            }

                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(u uVar) {
                                                final u uVar2 = uVar;
                                                final String str17 = str16;
                                                uVar2.click(new Function1<ClickParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.itemview.ai_picture.QSearchAIPictureCardView.createFooterView.1.1.2.4.1
                                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                    {
                                                        super(1);
                                                    }

                                                    @Override // kotlin.jvm.functions.Function1
                                                    public final Unit invoke(ClickParams clickParams) {
                                                        if (!ECFastClickUtils.isFastDoubleClick$default("ai_pictures_more_btn")) {
                                                            BridgeModule.openPage$default(IPagerIdKtxKt.getBridgeModule(u.this), str17, false, null, null, 30);
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
        return new QSearchAIPictureCardAttr();
    }

    @Override // com.tencent.kuikly.core.base.AbstractBaseView
    public final Event createEvent() {
        return new QSearchAIPictureCardEvent();
    }

    @Override // com.tencent.kuikly.core.base.ComposeView
    public final void created() {
        super.created();
        bindValueChange(new Function0<Object>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.itemview.ai_picture.QSearchAIPictureCardView$created$1
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                QSearchAIPictureCardAttr access$getAttr = QSearchAIPictureCardView.access$getAttr(QSearchAIPictureCardView.this);
                return (PageStatus) access$getAttr.pageStatus$delegate.getValue(access$getAttr, QSearchAIPictureCardAttr.$$delegatedProperties[1]);
            }
        }, new Function1<Object, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.itemview.ai_picture.QSearchAIPictureCardView$created$2
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Unit invoke(Object obj) {
                QSearchAIPictureCardAttr access$getAttr = QSearchAIPictureCardView.access$getAttr(QSearchAIPictureCardView.this);
                if (((PageStatus) access$getAttr.pageStatus$delegate.getValue(access$getAttr, QSearchAIPictureCardAttr.$$delegatedProperties[1])) == PageStatus.WILL_DESTROY) {
                    QSearchAIPictureCardViewModel viewModel = QSearchAIPictureCardView.access$getAttr(QSearchAIPictureCardView.this).getViewModel();
                    viewModel.stoped = true;
                    Timer timer = viewModel.requestTimer;
                    if (timer != null) {
                        timer.stopTimer();
                    }
                }
                return Unit.INSTANCE;
            }
        });
        bindValueChange(new Function0<Object>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.itemview.ai_picture.QSearchAIPictureCardView$created$3
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                QSearchAIPictureCardAttr access$getAttr = QSearchAIPictureCardView.access$getAttr(QSearchAIPictureCardView.this);
                return (RefreshListState) access$getAttr.listState$delegate.getValue(access$getAttr, QSearchAIPictureCardAttr.$$delegatedProperties[2]);
            }
        }, new Function1<Object, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.itemview.ai_picture.QSearchAIPictureCardView$created$4
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Unit invoke(Object obj) {
                QSearchAIPictureCardAttr access$getAttr = QSearchAIPictureCardView.access$getAttr(QSearchAIPictureCardView.this);
                if (Intrinsics.areEqual((RefreshListState) access$getAttr.listState$delegate.getValue(access$getAttr, QSearchAIPictureCardAttr.$$delegatedProperties[2]), RefreshListState.Loading.INSTANCE)) {
                    QSearchAIPictureCardViewModel viewModel = QSearchAIPictureCardView.access$getAttr(QSearchAIPictureCardView.this).getViewModel();
                    viewModel.stoped = true;
                    Timer timer = viewModel.requestTimer;
                    if (timer != null) {
                        timer.stopTimer();
                    }
                }
                return Unit.INSTANCE;
            }
        });
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final e getReportParams() {
        String str;
        e m3 = AdelieKuiklyBaseModule$$ExternalSyntheticOutline0.m(DTParamKey.REPORT_KEY_APPKEY, "0S200MNJT807V3GE", "pageId", "pg_qq_network_search_result_level2_page");
        QSearchAIPictureCardAttr qSearchAIPictureCardAttr = (QSearchAIPictureCardAttr) getAttr();
        m3.v("search_query_text", (String) qSearchAIPictureCardAttr.keyword$delegate.getValue(qSearchAIPictureCardAttr, QSearchAIPictureCardAttr.$$delegatedProperties[0]));
        ImageInfo imageInfo = ((QSearchAIPictureCardAttr) getAttr()).getViewModel().getImageInfo();
        String str2 = "";
        if (imageInfo == null || (str = imageInfo.orgDownUrl) == null) {
            str = "";
        }
        m3.v("pic_id", str);
        AIPictureCardItemModel aIPictureCardItemModel = this.cardItemModel;
        if (aIPictureCardItemModel != null) {
            str2 = aIPictureCardItemModel.getReportInfo();
        }
        e mergeTransferInfo = TemplateItemsKt.mergeTransferInfo(str2, m3);
        if (mergeTransferInfo != null) {
            AIPictureCardItemModel aIPictureCardItemModel2 = ((QSearchAIPictureCardAttr) getAttr()).data;
            mergeTransferInfo.t("serial_number", aIPictureCardItemModel2 != null ? aIPictureCardItemModel2.serialNumber : -1);
        }
        m3.v("transfer_info", mergeTransferInfo);
        return m3;
    }
}

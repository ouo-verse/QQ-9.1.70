package com.tencent.hippykotlin.demo.pages.qplus_traffic.promote_receiver.cards.section_button;

import c01.c;
import com.tencent.hippykotlin.demo.pages.activity.blind_box.yifanshang.detail.view.YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.base.BridgeModule;
import com.tencent.hippykotlin.demo.pages.base.Utils;
import com.tencent.hippykotlin.demo.pages.base.extension.AttrExtKt;
import com.tencent.hippykotlin.demo.pages.qplus_traffic.promote_receiver.page_model.QPPromoteReceiverViewModel;
import com.tencent.kuikly.core.base.Attr;
import com.tencent.kuikly.core.base.ComposeView;
import com.tencent.kuikly.core.base.ViewContainer;
import com.tencent.kuikly.core.base.attr.b;
import com.tencent.kuikly.core.base.event.ClickParams;
import com.tencent.kuikly.core.base.event.Event;
import com.tencent.kuikly.core.base.k;
import com.tencent.kuikly.core.base.l;
import com.tencent.kuikly.core.directives.ConditionView;
import com.tencent.kuikly.core.directives.ConditionViewKt;
import com.tencent.kuikly.core.directives.LoopDirectivesView;
import com.tencent.kuikly.core.directives.LoopDirectivesViewKt;
import com.tencent.kuikly.core.nvi.serialization.json.e;
import com.tencent.kuikly.core.views.ImageEvent;
import com.tencent.kuikly.core.views.ImageView;
import com.tencent.kuikly.core.views.TextView;
import com.tencent.kuikly.core.views.af;
import com.tencent.kuikly.core.views.ah;
import com.tencent.kuikly.core.views.ao;
import com.tencent.kuikly.core.views.aq;
import com.tencent.kuikly.core.views.ar;
import com.tencent.kuikly.core.views.ce;
import com.tencent.kuikly.core.views.cg;
import com.tencent.kuikly.core.views.t;
import com.tencent.kuikly.core.views.u;
import com.tencent.kuikly.core.views.v;
import com.tencent.kuikly.core.views.w;
import java.util.ArrayList;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.properties.ReadWriteProperty;
import kotlin.reflect.KProperty;

/* loaded from: classes31.dex */
public final class QPPromoteReceiverPhotoSelectSectionView extends ComposeView<k, l> {
    public static final /* synthetic */ KProperty<Object>[] $$delegatedProperties = {YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0.m(QPPromoteReceiverPhotoSelectSectionView.class, "needShowPhotoView", "getNeedShowPhotoView()Z", 0)};
    public final Lazy sectionModel$delegate;
    public final QPPromoteReceiverViewModel viewModel;
    public final String sectionTitle = "\u4f7f\u7528\u4ed6\u4eba\u8096\u50cf";
    public final ReadWriteProperty needShowPhotoView$delegate = c.a(Boolean.FALSE);

    public QPPromoteReceiverPhotoSelectSectionView(QPPromoteReceiverViewModel qPPromoteReceiverViewModel) {
        Lazy lazy;
        this.viewModel = qPPromoteReceiverViewModel;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<QPPromoteReceiverSectionViewModel>() { // from class: com.tencent.hippykotlin.demo.pages.qplus_traffic.promote_receiver.cards.section_button.QPPromoteReceiverPhotoSelectSectionView$sectionModel$2
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final QPPromoteReceiverSectionViewModel invoke() {
                ArrayList<QPPromoteReceiverItem> arrayListOf;
                ArrayList<QPPromoteReceiverItem> arrayListOf2;
                final QPPromoteReceiverSectionViewModel qPPromoteReceiverSectionViewModel = new QPPromoteReceiverSectionViewModel();
                final QPPromoteReceiverPhotoSelectSectionView qPPromoteReceiverPhotoSelectSectionView = QPPromoteReceiverPhotoSelectSectionView.this;
                Function3<QPPromoteReceiverSectionViewModel, QPPromoteReceiverItem, Function1<? super Boolean, ? extends Unit>, Unit> function3 = new Function3<QPPromoteReceiverSectionViewModel, QPPromoteReceiverItem, Function1<? super Boolean, ? extends Unit>, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qplus_traffic.promote_receiver.cards.section_button.QPPromoteReceiverPhotoSelectSectionView$sectionModel$2$1$callBackBlock$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(3);
                    }

                    @Override // kotlin.jvm.functions.Function3
                    public final Unit invoke(QPPromoteReceiverSectionViewModel qPPromoteReceiverSectionViewModel2, QPPromoteReceiverItem qPPromoteReceiverItem, Function1<? super Boolean, ? extends Unit> function1) {
                        Object first;
                        boolean z16;
                        function1.invoke(Boolean.TRUE);
                        QPPromoteReceiverPhotoSelectSectionView qPPromoteReceiverPhotoSelectSectionView2 = QPPromoteReceiverPhotoSelectSectionView.this;
                        com.tencent.kuikly.core.reactive.collection.c<QPPromoteReceiverItem> selectItems = qPPromoteReceiverSectionViewModel.getSelectItems();
                        KProperty<Object>[] kPropertyArr = QPPromoteReceiverPhotoSelectSectionView.$$delegatedProperties;
                        qPPromoteReceiverPhotoSelectSectionView2.getClass();
                        first = CollectionsKt___CollectionsKt.first((List<? extends Object>) selectItems);
                        if (((QPPromoteReceiverItem) first).getLabelValue() > 0) {
                            z16 = true;
                        } else {
                            qPPromoteReceiverPhotoSelectSectionView2.viewModel.getUploadUrlList().clear();
                            z16 = false;
                        }
                        qPPromoteReceiverPhotoSelectSectionView2.needShowPhotoView$delegate.setValue(qPPromoteReceiverPhotoSelectSectionView2, QPPromoteReceiverPhotoSelectSectionView.$$delegatedProperties[0], Boolean.valueOf(z16));
                        return Unit.INSTANCE;
                    }
                };
                QPPromoteReceiverItem qPPromoteReceiverItem = new QPPromoteReceiverItem("\u672a\u4f7f\u7528", 0, 0, true, true, (Function3) function3, 64);
                qPPromoteReceiverSectionViewModel.items.add(qPPromoteReceiverItem);
                QPPromoteReceiverItem qPPromoteReceiverItem2 = new QPPromoteReceiverItem("\u4f7f\u7528", 1, 0, true, true, (Function3) function3, 64);
                qPPromoteReceiverSectionViewModel.items.add(qPPromoteReceiverItem2);
                if (qPPromoteReceiverPhotoSelectSectionView.viewModel.getUploadUrlList().size() > 0) {
                    arrayListOf2 = CollectionsKt__CollectionsKt.arrayListOf(qPPromoteReceiverItem2);
                    qPPromoteReceiverSectionViewModel.updateItemsOnFirstCreated(arrayListOf2);
                    qPPromoteReceiverPhotoSelectSectionView.needShowPhotoView$delegate.setValue(qPPromoteReceiverPhotoSelectSectionView, QPPromoteReceiverPhotoSelectSectionView.$$delegatedProperties[0], Boolean.TRUE);
                } else {
                    arrayListOf = CollectionsKt__CollectionsKt.arrayListOf(qPPromoteReceiverItem);
                    qPPromoteReceiverSectionViewModel.updateItemsOnFirstCreated(arrayListOf);
                }
                return qPPromoteReceiverSectionViewModel;
            }
        });
        this.sectionModel$delegate = lazy;
    }

    @Override // com.tencent.kuikly.core.base.ComposeView
    public final Function1<ViewContainer<?, ?>, Unit> body() {
        return new Function1<ViewContainer<?, ?>, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qplus_traffic.promote_receiver.cards.section_button.QPPromoteReceiverPhotoSelectSectionView$body$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Unit invoke(ViewContainer<?, ?> viewContainer) {
                ViewContainer<?, ?> viewContainer2 = viewContainer;
                QPPromoteReceiverSectionViewModel qPPromoteReceiverSectionViewModel = (QPPromoteReceiverSectionViewModel) QPPromoteReceiverPhotoSelectSectionView.this.sectionModel$delegate.getValue();
                QPPromoteReceiverPhotoSelectSectionView qPPromoteReceiverPhotoSelectSectionView = QPPromoteReceiverPhotoSelectSectionView.this;
                QPPromoteReceiverItemSectionViewKt.QPPromoteReceiverItemSectionViewFun(viewContainer2, qPPromoteReceiverSectionViewModel, qPPromoteReceiverPhotoSelectSectionView.viewModel, qPPromoteReceiverPhotoSelectSectionView.sectionTitle, new Function1<QPPromoteReceiverItemSectionView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qplus_traffic.promote_receiver.cards.section_button.QPPromoteReceiverPhotoSelectSectionView$body$1.1
                    @Override // kotlin.jvm.functions.Function1
                    public final /* bridge */ /* synthetic */ Unit invoke(QPPromoteReceiverItemSectionView qPPromoteReceiverItemSectionView) {
                        return Unit.INSTANCE;
                    }
                });
                final QPPromoteReceiverPhotoSelectSectionView qPPromoteReceiverPhotoSelectSectionView2 = QPPromoteReceiverPhotoSelectSectionView.this;
                Function0<Object> function0 = new Function0<Object>() { // from class: com.tencent.hippykotlin.demo.pages.qplus_traffic.promote_receiver.cards.section_button.QPPromoteReceiverPhotoSelectSectionView$body$1.2
                    {
                        super(0);
                    }

                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        QPPromoteReceiverPhotoSelectSectionView qPPromoteReceiverPhotoSelectSectionView3 = QPPromoteReceiverPhotoSelectSectionView.this;
                        return Boolean.valueOf(((Boolean) qPPromoteReceiverPhotoSelectSectionView3.needShowPhotoView$delegate.getValue(qPPromoteReceiverPhotoSelectSectionView3, QPPromoteReceiverPhotoSelectSectionView.$$delegatedProperties[0])).booleanValue());
                    }
                };
                final QPPromoteReceiverPhotoSelectSectionView qPPromoteReceiverPhotoSelectSectionView3 = QPPromoteReceiverPhotoSelectSectionView.this;
                ConditionViewKt.c(viewContainer2, function0, new Function1<ConditionView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qplus_traffic.promote_receiver.cards.section_button.QPPromoteReceiverPhotoSelectSectionView$body$1.3
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(ConditionView conditionView) {
                        ConditionView conditionView2 = conditionView;
                        final QPPromoteReceiverPhotoSelectSectionView qPPromoteReceiverPhotoSelectSectionView4 = QPPromoteReceiverPhotoSelectSectionView.this;
                        ar.a(conditionView2, new Function1<aq<?, ?>, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qplus_traffic.promote_receiver.cards.section_button.QPPromoteReceiverPhotoSelectSectionView.body.1.3.1
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(aq<?, ?> aqVar) {
                                aq<?, ?> aqVar2 = aqVar;
                                aqVar2.attr(new Function1<ao, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qplus_traffic.promote_receiver.cards.section_button.QPPromoteReceiverPhotoSelectSectionView.body.1.3.1.1
                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(ao aoVar) {
                                        ao aoVar2 = aoVar;
                                        aoVar2.flexDirectionRow();
                                        aoVar2.mo153width(aoVar2.getPagerData().m() - 16.0f);
                                        aoVar2.mo141height(77.0f);
                                        aoVar2.marginLeft(16.0f);
                                        aoVar2.showScrollerIndicator(false);
                                        return Unit.INSTANCE;
                                    }
                                });
                                final QPPromoteReceiverPhotoSelectSectionView qPPromoteReceiverPhotoSelectSectionView5 = QPPromoteReceiverPhotoSelectSectionView.this;
                                Function0<com.tencent.kuikly.core.reactive.collection.c<String>> function02 = new Function0<com.tencent.kuikly.core.reactive.collection.c<String>>() { // from class: com.tencent.hippykotlin.demo.pages.qplus_traffic.promote_receiver.cards.section_button.QPPromoteReceiverPhotoSelectSectionView.body.1.3.1.2
                                    {
                                        super(0);
                                    }

                                    @Override // kotlin.jvm.functions.Function0
                                    public final com.tencent.kuikly.core.reactive.collection.c<String> invoke() {
                                        return QPPromoteReceiverPhotoSelectSectionView.this.viewModel.getUploadUrlList();
                                    }
                                };
                                final QPPromoteReceiverPhotoSelectSectionView qPPromoteReceiverPhotoSelectSectionView6 = QPPromoteReceiverPhotoSelectSectionView.this;
                                LoopDirectivesViewKt.a(aqVar2, function02, new Function2<LoopDirectivesView<String>, String, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qplus_traffic.promote_receiver.cards.section_button.QPPromoteReceiverPhotoSelectSectionView.body.1.3.1.3
                                    {
                                        super(2);
                                    }

                                    @Override // kotlin.jvm.functions.Function2
                                    public final Unit invoke(LoopDirectivesView<String> loopDirectivesView, String str) {
                                        final String str2 = str;
                                        final QPPromoteReceiverPhotoSelectSectionView qPPromoteReceiverPhotoSelectSectionView7 = QPPromoteReceiverPhotoSelectSectionView.this;
                                        w.a(loopDirectivesView, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qplus_traffic.promote_receiver.cards.section_button.QPPromoteReceiverPhotoSelectSectionView.body.1.3.1.3.1
                                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                            {
                                                super(1);
                                            }

                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(v vVar) {
                                                v vVar2 = vVar;
                                                vVar2.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qplus_traffic.promote_receiver.cards.section_button.QPPromoteReceiverPhotoSelectSectionView.body.1.3.1.3.1.1
                                                    @Override // kotlin.jvm.functions.Function1
                                                    public final Unit invoke(t tVar) {
                                                        t tVar2 = tVar;
                                                        tVar2.size(77.0f, 77.0f);
                                                        tVar2.marginRight(8.0f);
                                                        tVar2.borderRadius(4.0f);
                                                        return Unit.INSTANCE;
                                                    }
                                                });
                                                final String str3 = str2;
                                                ah.a(vVar2, new Function1<ImageView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qplus_traffic.promote_receiver.cards.section_button.QPPromoteReceiverPhotoSelectSectionView.body.1.3.1.3.1.2
                                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                    {
                                                        super(1);
                                                    }

                                                    @Override // kotlin.jvm.functions.Function1
                                                    public final Unit invoke(ImageView imageView) {
                                                        final String str4 = str3;
                                                        imageView.attr(new Function1<af, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qplus_traffic.promote_receiver.cards.section_button.QPPromoteReceiverPhotoSelectSectionView.body.1.3.1.3.1.2.1
                                                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                            {
                                                                super(1);
                                                            }

                                                            @Override // kotlin.jvm.functions.Function1
                                                            public final Unit invoke(af afVar) {
                                                                af afVar2 = afVar;
                                                                afVar2.size(77.0f, 77.0f);
                                                                b.a.b(afVar2, str4, false, 2, null);
                                                                return Unit.INSTANCE;
                                                            }
                                                        });
                                                        return Unit.INSTANCE;
                                                    }
                                                });
                                                final QPPromoteReceiverPhotoSelectSectionView qPPromoteReceiverPhotoSelectSectionView8 = qPPromoteReceiverPhotoSelectSectionView7;
                                                final String str4 = str2;
                                                ah.a(vVar2, new Function1<ImageView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qplus_traffic.promote_receiver.cards.section_button.QPPromoteReceiverPhotoSelectSectionView.body.1.3.1.3.1.3
                                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                    {
                                                        super(1);
                                                    }

                                                    @Override // kotlin.jvm.functions.Function1
                                                    public final Unit invoke(ImageView imageView) {
                                                        ImageView imageView2 = imageView;
                                                        imageView2.attr(new Function1<af, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qplus_traffic.promote_receiver.cards.section_button.QPPromoteReceiverPhotoSelectSectionView.body.1.3.1.3.1.3.1
                                                            @Override // kotlin.jvm.functions.Function1
                                                            public final Unit invoke(af afVar) {
                                                                af afVar2 = afVar;
                                                                afVar2.size(20.0f, 20.0f);
                                                                afVar2.absolutePosition(2.0f, 50.0f, 50.0f, 2.0f);
                                                                b.a.b(afVar2, "qecommerce_icon_general_close", false, 2, null);
                                                                return Unit.INSTANCE;
                                                            }
                                                        });
                                                        final QPPromoteReceiverPhotoSelectSectionView qPPromoteReceiverPhotoSelectSectionView9 = QPPromoteReceiverPhotoSelectSectionView.this;
                                                        final String str5 = str4;
                                                        imageView2.event(new Function1<ImageEvent, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qplus_traffic.promote_receiver.cards.section_button.QPPromoteReceiverPhotoSelectSectionView.body.1.3.1.3.1.3.2
                                                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                            {
                                                                super(1);
                                                            }

                                                            @Override // kotlin.jvm.functions.Function1
                                                            public final Unit invoke(ImageEvent imageEvent) {
                                                                final QPPromoteReceiverPhotoSelectSectionView qPPromoteReceiverPhotoSelectSectionView10 = QPPromoteReceiverPhotoSelectSectionView.this;
                                                                final String str6 = str5;
                                                                imageEvent.click(new Function1<ClickParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qplus_traffic.promote_receiver.cards.section_button.QPPromoteReceiverPhotoSelectSectionView.body.1.3.1.3.1.3.2.1
                                                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                                    {
                                                                        super(1);
                                                                    }

                                                                    @Override // kotlin.jvm.functions.Function1
                                                                    public final Unit invoke(ClickParams clickParams) {
                                                                        QPPromoteReceiverPhotoSelectSectionView.this.viewModel.getUploadUrlList().remove(str6);
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
                                final QPPromoteReceiverPhotoSelectSectionView qPPromoteReceiverPhotoSelectSectionView7 = QPPromoteReceiverPhotoSelectSectionView.this;
                                w.a(aqVar2, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qplus_traffic.promote_receiver.cards.section_button.QPPromoteReceiverPhotoSelectSectionView.body.1.3.1.4
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(v vVar) {
                                        v vVar2 = vVar;
                                        vVar2.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qplus_traffic.promote_receiver.cards.section_button.QPPromoteReceiverPhotoSelectSectionView.body.1.3.1.4.1
                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(t tVar) {
                                                t tVar2 = tVar;
                                                tVar2.size(77.0f, 77.0f);
                                                tVar2.marginRight(8.0f);
                                                tVar2.borderRadius(4.0f);
                                                AttrExtKt.backgroundColorToken(tVar2, "qecommerce_skin_color_tag_normal");
                                                tVar2.allCenter();
                                                return Unit.INSTANCE;
                                            }
                                        });
                                        final QPPromoteReceiverPhotoSelectSectionView qPPromoteReceiverPhotoSelectSectionView8 = QPPromoteReceiverPhotoSelectSectionView.this;
                                        vVar2.event(new Function1<u, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qplus_traffic.promote_receiver.cards.section_button.QPPromoteReceiverPhotoSelectSectionView.body.1.3.1.4.2
                                            {
                                                super(1);
                                            }

                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(u uVar) {
                                                final QPPromoteReceiverPhotoSelectSectionView qPPromoteReceiverPhotoSelectSectionView9 = QPPromoteReceiverPhotoSelectSectionView.this;
                                                uVar.click(new Function1<ClickParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qplus_traffic.promote_receiver.cards.section_button.QPPromoteReceiverPhotoSelectSectionView.body.1.3.1.4.2.1
                                                    {
                                                        super(1);
                                                    }

                                                    @Override // kotlin.jvm.functions.Function1
                                                    public final Unit invoke(ClickParams clickParams) {
                                                        if (QPPromoteReceiverPhotoSelectSectionView.this.viewModel.getUploadUrlList().size() >= 10) {
                                                            Utils.INSTANCE.currentBridgeModule().toast("\u6700\u591a\u4e0a\u4f2010\u5f20\u56fe\u7247");
                                                        } else {
                                                            BridgeModule currentBridgeModule = Utils.INSTANCE.currentBridgeModule();
                                                            final QPPromoteReceiverPhotoSelectSectionView qPPromoteReceiverPhotoSelectSectionView10 = QPPromoteReceiverPhotoSelectSectionView.this;
                                                            String str = qPPromoteReceiverPhotoSelectSectionView10.viewModel.uploadingNotificationName;
                                                            Function1<e, Unit> function1 = new Function1<e, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qplus_traffic.promote_receiver.cards.section_button.QPPromoteReceiverPhotoSelectSectionView.body.1.3.1.4.2.1.1
                                                                {
                                                                    super(1);
                                                                }

                                                                @Override // kotlin.jvm.functions.Function1
                                                                public final Unit invoke(e eVar) {
                                                                    e eVar2 = eVar;
                                                                    QPPromoteReceiverViewModel qPPromoteReceiverViewModel = QPPromoteReceiverPhotoSelectSectionView.this.viewModel;
                                                                    qPPromoteReceiverViewModel.uploadLoading$delegate.setValue(qPPromoteReceiverViewModel, QPPromoteReceiverViewModel.$$delegatedProperties[2], Boolean.FALSE);
                                                                    boolean z16 = false;
                                                                    Boolean valueOf = eVar2 != null ? Boolean.valueOf(eVar2.g("success", false)) : null;
                                                                    String q16 = eVar2 != null ? eVar2.q("url", "") : null;
                                                                    if (Intrinsics.areEqual(valueOf, Boolean.TRUE)) {
                                                                        if (q16 != null) {
                                                                            if (q16.length() > 0) {
                                                                                z16 = true;
                                                                            }
                                                                        }
                                                                        if (z16) {
                                                                            Utils.INSTANCE.currentBridgeModule().toast("\u56fe\u7247\u4e0a\u4f20\u6210\u529f");
                                                                            QPPromoteReceiverPhotoSelectSectionView.this.viewModel.getUploadUrlList().add(q16);
                                                                            return Unit.INSTANCE;
                                                                        }
                                                                    }
                                                                    Utils.INSTANCE.currentBridgeModule().toast("\u56fe\u7247\u4e0a\u4f20\u5931\u8d25\uff0c\u8bf7\u91cd\u8bd5");
                                                                    return Unit.INSTANCE;
                                                                }
                                                            };
                                                            currentBridgeModule.getClass();
                                                            e eVar = new e();
                                                            if (str != null) {
                                                                eVar.v("notificationName", str);
                                                            }
                                                            currentBridgeModule.callNativeMethod("uploadSinglePhotoFromAlbum", eVar, function1);
                                                        }
                                                        return Unit.INSTANCE;
                                                    }
                                                });
                                                return Unit.INSTANCE;
                                            }
                                        });
                                        ah.a(vVar2, new Function1<ImageView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qplus_traffic.promote_receiver.cards.section_button.QPPromoteReceiverPhotoSelectSectionView.body.1.3.1.4.3
                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(ImageView imageView) {
                                                imageView.attr(new Function1<af, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qplus_traffic.promote_receiver.cards.section_button.QPPromoteReceiverPhotoSelectSectionView.body.1.3.1.4.3.1
                                                    @Override // kotlin.jvm.functions.Function1
                                                    public final Unit invoke(af afVar) {
                                                        af afVar2 = afVar;
                                                        afVar2.size(24.0f, 24.0f);
                                                        b.a.b(afVar2, "qecommerce_skin_icon_general_add_light", false, 2, null);
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
                        cg.a(conditionView2, new Function1<TextView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qplus_traffic.promote_receiver.cards.section_button.QPPromoteReceiverPhotoSelectSectionView.body.1.3.2
                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(TextView textView) {
                                textView.attr(new Function1<ce, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qplus_traffic.promote_receiver.cards.section_button.QPPromoteReceiverPhotoSelectSectionView.body.1.3.2.1
                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(ce ceVar) {
                                        ce ceVar2 = ceVar;
                                        ceVar2.marginTop(8.0f);
                                        ceVar2.marginLeft(16.0f);
                                        ceVar2.text("\u4e0a\u4f20\u76f8\u5173\u6388\u6743\u8bc1\u660e");
                                        ce.fontSize$default(ceVar2, 12.0f, null, 2, null);
                                        AttrExtKt.colorToken(ceVar2, "qecommerce_skin_color_text_secondary");
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
        return new k();
    }

    @Override // com.tencent.kuikly.core.base.AbstractBaseView
    public final Event createEvent() {
        return new l();
    }
}

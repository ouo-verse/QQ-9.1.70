package com.tencent.hippykotlin.demo.pages.qplus_traffic.promote_receiver;

import com.tencent.hippykotlin.demo.pages.base.BasePager;
import com.tencent.hippykotlin.demo.pages.base.ECTransitionAttr;
import com.tencent.hippykotlin.demo.pages.base.ECTransitionEvent;
import com.tencent.hippykotlin.demo.pages.base.ECTransitionView;
import com.tencent.hippykotlin.demo.pages.base.ECTransitionViewKt;
import com.tencent.hippykotlin.demo.pages.base.Utils;
import com.tencent.hippykotlin.demo.pages.base.extension.AttrExtKt;
import com.tencent.hippykotlin.demo.pages.base.extension.PageDataExtKt;
import com.tencent.hippykotlin.demo.pages.qplus_traffic.promote_receiver.cards.QPPromoteReceiverNavBar;
import com.tencent.hippykotlin.demo.pages.qplus_traffic.promote_receiver.cards.QPPromoteReceiverView;
import com.tencent.hippykotlin.demo.pages.qplus_traffic.promote_receiver.cards.QPPromoteReceiverViewAttr;
import com.tencent.hippykotlin.demo.pages.qplus_traffic.promote_receiver.page_model.QPPromoteReceiverPageModel;
import com.tencent.hippykotlin.demo.pages.qplus_traffic.promote_receiver.page_model.QPPromoteReceiverPortraitListItem;
import com.tencent.hippykotlin.demo.pages.qplus_traffic.promote_receiver.page_model.QPPromoteReceiverViewModel;
import com.tencent.hippykotlin.demo.pages.qplus_traffic.repository.protoc.QPlusAgeRange;
import com.tencent.hippykotlin.demo.pages.qplus_traffic.repository.protoc.QPlusCity;
import com.tencent.hippykotlin.demo.pages.qplus_traffic.repository.protoc.QPlusCrowdOption;
import com.tencent.hippykotlin.demo.pages.qplus_traffic.repository.protoc.QPlusPortraitOption;
import com.tencent.hippykotlin.demo.pages.qplus_traffic.repository.protoc.QPlusProfileOption;
import com.tencent.hippykotlin.demo.pages.qplus_traffic.repository.protoc.QPlusTag;
import com.tencent.kuikly.core.base.ViewContainer;
import com.tencent.kuikly.core.nvi.serialization.json.b;
import com.tencent.kuikly.core.nvi.serialization.json.e;
import com.tencent.kuikly.core.views.t;
import com.tencent.kuikly.core.views.v;
import com.tencent.kuikly.core.views.w;
import com.tencent.mobileqq.qwallet.transaction.impl.NotifyMsgApiImpl;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes31.dex */
public final class QPPromoteReceiverPage extends BasePager {
    public static final /* synthetic */ int $r8$clinit = 0;
    public final float halfMarginTop = 101.0f;
    public QPPromoteReceiverPageModel pageModel;

    @Override // com.tencent.kuikly.core.base.ComposeView
    public final Function1<ViewContainer<?, ?>, Unit> body() {
        return new Function1<ViewContainer<?, ?>, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qplus_traffic.promote_receiver.QPPromoteReceiverPage$body$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Unit invoke(ViewContainer<?, ?> viewContainer) {
                ViewContainer<?, ?> viewContainer2 = viewContainer;
                QPPromoteReceiverPage.this.getClass();
                QPPromoteReceiverPage$bodyWithHalfBackgroundView$1.INSTANCE.invoke(viewContainer2);
                final QPPromoteReceiverPage qPPromoteReceiverPage = QPPromoteReceiverPage.this;
                qPPromoteReceiverPage.getClass();
                new Function1<ViewContainer<?, ?>, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qplus_traffic.promote_receiver.QPPromoteReceiverPage$bodyWithHalfMainView$1
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(ViewContainer<?, ?> viewContainer3) {
                        final QPPromoteReceiverPage qPPromoteReceiverPage2 = QPPromoteReceiverPage.this;
                        ECTransitionViewKt.TransitionFromBottomView(viewContainer3, new Function1<ECTransitionView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qplus_traffic.promote_receiver.QPPromoteReceiverPage$bodyWithHalfMainView$1.1
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(ECTransitionView eCTransitionView) {
                                ECTransitionView eCTransitionView2 = eCTransitionView;
                                final QPPromoteReceiverPage qPPromoteReceiverPage3 = QPPromoteReceiverPage.this;
                                eCTransitionView2.attr(new Function1<ECTransitionAttr, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qplus_traffic.promote_receiver.QPPromoteReceiverPage.bodyWithHalfMainView.1.1.1
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(ECTransitionAttr eCTransitionAttr) {
                                        ECTransitionAttr eCTransitionAttr2 = eCTransitionAttr;
                                        eCTransitionAttr2.setTransitionAppear(true);
                                        eCTransitionAttr2.absolutePosition(QPPromoteReceiverPage.this.halfMarginTop, 0.0f, 0.0f, 0.0f);
                                        return Unit.INSTANCE;
                                    }
                                });
                                final QPPromoteReceiverPage qPPromoteReceiverPage4 = QPPromoteReceiverPage.this;
                                eCTransitionView2.event(new Function1<ECTransitionEvent, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qplus_traffic.promote_receiver.QPPromoteReceiverPage.bodyWithHalfMainView.1.1.2
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(ECTransitionEvent eCTransitionEvent) {
                                        final QPPromoteReceiverPage qPPromoteReceiverPage5 = QPPromoteReceiverPage.this;
                                        eCTransitionEvent.transitionFinish(new Function1<Boolean, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qplus_traffic.promote_receiver.QPPromoteReceiverPage.bodyWithHalfMainView.1.1.2.1
                                            {
                                                super(1);
                                            }

                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(Boolean bool) {
                                                if (!bool.booleanValue()) {
                                                    QPPromoteReceiverPageModel qPPromoteReceiverPageModel = QPPromoteReceiverPage.this.pageModel;
                                                    if (qPPromoteReceiverPageModel == null) {
                                                        Intrinsics.throwUninitializedPropertyAccessException("pageModel");
                                                        qPPromoteReceiverPageModel = null;
                                                    }
                                                    qPPromoteReceiverPageModel.viewModel.closePage(false);
                                                }
                                                return Unit.INSTANCE;
                                            }
                                        });
                                        return Unit.INSTANCE;
                                    }
                                });
                                final QPPromoteReceiverPage qPPromoteReceiverPage5 = QPPromoteReceiverPage.this;
                                int i3 = QPPromoteReceiverPage.$r8$clinit;
                                qPPromoteReceiverPage5.getClass();
                                new Function1<ViewContainer<?, ?>, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qplus_traffic.promote_receiver.QPPromoteReceiverPage$bodyWithMainView$1
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(ViewContainer<?, ?> viewContainer4) {
                                        final QPPromoteReceiverPage qPPromoteReceiverPage6 = QPPromoteReceiverPage.this;
                                        w.a(viewContainer4, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qplus_traffic.promote_receiver.QPPromoteReceiverPage$bodyWithMainView$1.1
                                            {
                                                super(1);
                                            }

                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(v vVar) {
                                                v vVar2 = vVar;
                                                final QPPromoteReceiverPage qPPromoteReceiverPage7 = QPPromoteReceiverPage.this;
                                                vVar2.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qplus_traffic.promote_receiver.QPPromoteReceiverPage.bodyWithMainView.1.1.1
                                                    {
                                                        super(1);
                                                    }

                                                    @Override // kotlin.jvm.functions.Function1
                                                    public final Unit invoke(t tVar) {
                                                        t tVar2 = tVar;
                                                        tVar2.mo153width(tVar2.getPagerData().m());
                                                        AttrExtKt.backgroundColorToken(tVar2, "qecommerce_skin_color_bg_default");
                                                        tVar2.borderRadius(8.0f, 8.0f, 0.0f, 0.0f);
                                                        tVar2.mo141height(tVar2.getPagerData().l() - QPPromoteReceiverPage.this.halfMarginTop);
                                                        return Unit.INSTANCE;
                                                    }
                                                });
                                                final QPPromoteReceiverPage qPPromoteReceiverPage8 = QPPromoteReceiverPage.this;
                                                vVar2.addChild(new QPPromoteReceiverNavBar(), new Function1<QPPromoteReceiverNavBar, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qplus_traffic.promote_receiver.QPPromoteReceiverPage.bodyWithMainView.1.1.2
                                                    {
                                                        super(1);
                                                    }

                                                    @Override // kotlin.jvm.functions.Function1
                                                    public final Unit invoke(QPPromoteReceiverNavBar qPPromoteReceiverNavBar) {
                                                        final QPPromoteReceiverPage qPPromoteReceiverPage9 = QPPromoteReceiverPage.this;
                                                        qPPromoteReceiverNavBar.attr(new Function1<QPPromoteReceiverViewAttr, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qplus_traffic.promote_receiver.QPPromoteReceiverPage.bodyWithMainView.1.1.2.1
                                                            {
                                                                super(1);
                                                            }

                                                            @Override // kotlin.jvm.functions.Function1
                                                            public final Unit invoke(QPPromoteReceiverViewAttr qPPromoteReceiverViewAttr) {
                                                                QPPromoteReceiverViewAttr qPPromoteReceiverViewAttr2 = qPPromoteReceiverViewAttr;
                                                                qPPromoteReceiverViewAttr2.marginTop(8.0f);
                                                                QPPromoteReceiverPageModel qPPromoteReceiverPageModel = QPPromoteReceiverPage.this.pageModel;
                                                                if (qPPromoteReceiverPageModel == null) {
                                                                    Intrinsics.throwUninitializedPropertyAccessException("pageModel");
                                                                    qPPromoteReceiverPageModel = null;
                                                                }
                                                                qPPromoteReceiverViewAttr2.viewModel = qPPromoteReceiverPageModel.viewModel;
                                                                return Unit.INSTANCE;
                                                            }
                                                        });
                                                        return Unit.INSTANCE;
                                                    }
                                                });
                                                final QPPromoteReceiverPage qPPromoteReceiverPage9 = QPPromoteReceiverPage.this;
                                                vVar2.addChild(new QPPromoteReceiverView(), new Function1<QPPromoteReceiverView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qplus_traffic.promote_receiver.QPPromoteReceiverPage.bodyWithMainView.1.1.3
                                                    {
                                                        super(1);
                                                    }

                                                    @Override // kotlin.jvm.functions.Function1
                                                    public final Unit invoke(QPPromoteReceiverView qPPromoteReceiverView) {
                                                        final QPPromoteReceiverPage qPPromoteReceiverPage10 = QPPromoteReceiverPage.this;
                                                        qPPromoteReceiverView.attr(new Function1<QPPromoteReceiverViewAttr, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qplus_traffic.promote_receiver.QPPromoteReceiverPage.bodyWithMainView.1.1.3.1
                                                            {
                                                                super(1);
                                                            }

                                                            @Override // kotlin.jvm.functions.Function1
                                                            public final Unit invoke(QPPromoteReceiverViewAttr qPPromoteReceiverViewAttr) {
                                                                QPPromoteReceiverViewAttr qPPromoteReceiverViewAttr2 = qPPromoteReceiverViewAttr;
                                                                QPPromoteReceiverPageModel qPPromoteReceiverPageModel = QPPromoteReceiverPage.this.pageModel;
                                                                if (qPPromoteReceiverPageModel == null) {
                                                                    Intrinsics.throwUninitializedPropertyAccessException("pageModel");
                                                                    qPPromoteReceiverPageModel = null;
                                                                }
                                                                qPPromoteReceiverViewAttr2.viewModel = qPPromoteReceiverPageModel.viewModel;
                                                                qPPromoteReceiverViewAttr2.mo153width(qPPromoteReceiverViewAttr2.getPagerData().m());
                                                                if (qPPromoteReceiverViewAttr2.getPagerData().getIsIOS()) {
                                                                    qPPromoteReceiverViewAttr2.mo141height((((qPPromoteReceiverViewAttr2.getPagerData().l() - QPPromoteReceiverPage.this.halfMarginTop) - 56.0f) - 8.0f) - 34.0f);
                                                                } else {
                                                                    qPPromoteReceiverViewAttr2.mo141height(((qPPromoteReceiverViewAttr2.getPagerData().l() - QPPromoteReceiverPage.this.halfMarginTop) - 56.0f) - 8.0f);
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
                                }.invoke(eCTransitionView2);
                                return Unit.INSTANCE;
                            }
                        });
                        return Unit.INSTANCE;
                    }
                }.invoke(viewContainer2);
                return Unit.INSTANCE;
            }
        };
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:29:0x0098  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x009f A[SYNTHETIC] */
    @Override // com.tencent.hippykotlin.demo.pages.base.BasePager, com.tencent.kuikly.core.base.ComposeView
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void created() {
        boolean z16;
        boolean z17;
        boolean z18;
        QPlusPortraitOption qPlusPortraitOption;
        ArrayList<String> arrayList;
        QPlusCrowdOption qPlusCrowdOption;
        ArrayList<QPlusAgeRange> arrayList2;
        int i3;
        ArrayList<QPlusCity> arrayList3;
        b l3;
        boolean z19;
        ArrayList<QPlusTag> arrayList4;
        super.created();
        QPPromoteReceiverPageModel qPPromoteReceiverPageModel = new QPPromoteReceiverPageModel();
        this.pageModel = qPPromoteReceiverPageModel;
        e userData = PageDataExtKt.getUserData(getPagerData());
        e m3 = userData.m("audienceOption");
        if (m3 == null) {
            m3 = new e();
        }
        int i16 = 0;
        m3.k("audience_type", 0);
        e m16 = m3.m("profile_option");
        QPlusProfileOption decode = m16 != null ? new QPlusProfileOption(0, null, null, null, null, null).decode(m16) : null;
        e m17 = userData.m("extraInfo");
        if (decode == null || (arrayList4 = decode.tags) == null) {
            z16 = false;
        } else {
            qPPromoteReceiverPageModel.viewModel.selectedTags.addAll(arrayList4);
            z16 = !arrayList4.isEmpty();
        }
        if (decode != null && (arrayList3 = decode.cities) != null) {
            qPPromoteReceiverPageModel.viewModel.selectedCity.addAll(arrayList3);
            if (m17 != null && (l3 = m17.l("cityNames")) != null) {
                int c16 = l3.c();
                for (int i17 = 0; i17 < c16; i17++) {
                    String p16 = l3.p(i17, "");
                    if (p16 != null) {
                        if (p16.length() > 0) {
                            z19 = true;
                            if (!z19) {
                                qPPromoteReceiverPageModel.viewModel.selectedCityNames.add(p16);
                            }
                        }
                    }
                    z19 = false;
                    if (!z19) {
                    }
                }
            }
            if (!arrayList3.isEmpty()) {
                z16 = true;
            }
        }
        if (decode != null && (i3 = decode.sexType) != 0) {
            qPPromoteReceiverPageModel.viewModel.sexType = i3;
            z16 = true;
        }
        if (decode != null && (arrayList2 = decode.ageRanges) != null) {
            qPPromoteReceiverPageModel.viewModel.ageRange.addAll(arrayList2);
            if (!arrayList2.isEmpty()) {
                z16 = true;
            }
        }
        if (decode == null || (qPlusCrowdOption = decode.crowdOption) == null) {
            z17 = z16;
        } else {
            qPPromoteReceiverPageModel.viewModel.crowdOption = qPlusCrowdOption;
            b l16 = m17 != null ? m17.l("groups") : null;
            ArrayList arrayList5 = new ArrayList();
            if (l16 != null) {
                int c17 = l16.c();
                while (i16 < c17) {
                    e l17 = l16.l(i16);
                    if (l17 == null) {
                        l17 = new e();
                    }
                    e eVar = l17;
                    arrayList5.add(new QPPromoteReceiverPortraitListItem(eVar.p("uin"), Utils.INSTANCE.currentBridgeModule().urlDecode(eVar.p("name")), eVar.p("icon"), eVar.j(NotifyMsgApiImpl.KEY_GROUP_TYPE), eVar.f("isBlueV"), eVar.f("isBigV")));
                    i16++;
                    c17 = c17;
                    z16 = z16;
                }
            }
            boolean z26 = z16;
            b l18 = m17 != null ? m17.l("creators") : null;
            ArrayList arrayList6 = new ArrayList();
            if (l18 != null) {
                int c18 = l18.c();
                int i18 = 0;
                while (i18 < c18) {
                    e l19 = l18.l(i18);
                    if (l19 == null) {
                        l19 = new e();
                    }
                    arrayList6.add(new QPPromoteReceiverPortraitListItem(l19.p("uin"), Utils.INSTANCE.currentBridgeModule().urlDecode(l19.p("name")), l19.p("icon"), l19.j(NotifyMsgApiImpl.KEY_GROUP_TYPE), l19.f("isBlueV"), l19.f("isBigV")));
                    i18++;
                    l18 = l18;
                }
            }
            ArrayList<Long> arrayList7 = qPlusCrowdOption.qqGroupIds;
            if (arrayList7 != null) {
                Iterator<T> it = arrayList7.iterator();
                z17 = z26;
                while (it.hasNext()) {
                    long longValue = ((Number) it.next()).longValue();
                    int size = arrayList5.size();
                    int i19 = 0;
                    while (true) {
                        if (i19 >= size) {
                            break;
                        }
                        if (Intrinsics.areEqual(String.valueOf(longValue), ((QPPromoteReceiverPortraitListItem) arrayList5.get(i19)).uin)) {
                            qPPromoteReceiverPageModel.viewModel.selectedGroupList.add(arrayList5.get(i19));
                            z17 = true;
                            break;
                        }
                        i19++;
                    }
                }
            } else {
                z17 = z26;
            }
            ArrayList<Long> arrayList8 = qPlusCrowdOption.creatorIds;
            if (arrayList8 != null) {
                Iterator<T> it5 = arrayList8.iterator();
                while (it5.hasNext()) {
                    long longValue2 = ((Number) it5.next()).longValue();
                    int size2 = arrayList6.size();
                    int i26 = 0;
                    while (true) {
                        if (i26 >= size2) {
                            break;
                        }
                        if (Intrinsics.areEqual(String.valueOf(longValue2), ((QPPromoteReceiverPortraitListItem) arrayList6.get(i26)).uin)) {
                            qPPromoteReceiverPageModel.viewModel.selectedCreatorList.add(arrayList6.get(i26));
                            z17 = true;
                            break;
                        }
                        i26++;
                    }
                }
            }
        }
        if (decode == null || (qPlusPortraitOption = decode.portraitOption) == null || (arrayList = qPlusPortraitOption.portraitUrl) == null || arrayList.size() <= 0) {
            z18 = z17;
        } else {
            qPPromoteReceiverPageModel.viewModel.getUploadUrlList().addAll(arrayList);
            z18 = true;
        }
        QPPromoteReceiverViewModel qPPromoteReceiverViewModel = qPPromoteReceiverPageModel.viewModel;
        qPPromoteReceiverViewModel.hasSelectCustomOption$delegate.setValue(qPPromoteReceiverViewModel, QPPromoteReceiverViewModel.$$delegatedProperties[0], Boolean.valueOf(z18));
        Utils.INSTANCE.currentBridgeModule().callNativeMethod("preloadMediaPickerModule", null, null);
    }
}

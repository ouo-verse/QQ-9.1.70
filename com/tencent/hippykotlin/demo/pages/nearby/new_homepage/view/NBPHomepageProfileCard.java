package com.tencent.hippykotlin.demo.pages.nearby.new_homepage.view;

import c01.c;
import com.tencent.hippykotlin.demo.pages.activity.blind_box.jiguangshang.view.BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2;
import com.tencent.hippykotlin.demo.pages.activity.blind_box.yifanshang.detail.view.YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.base.BridgeModule;
import com.tencent.hippykotlin.demo.pages.base.Utils;
import com.tencent.hippykotlin.demo.pages.foundation.module.QQKuiklyPlatformApi;
import com.tencent.hippykotlin.demo.pages.foundation.qui_component.ActionButtonParams;
import com.tencent.hippykotlin.demo.pages.foundation.qui_component.QActionSheetEvent;
import com.tencent.hippykotlin.demo.pages.foundation.qui_component.QActionSheetKt;
import com.tencent.hippykotlin.demo.pages.foundation.qui_component.QActionSheetView;
import com.tencent.hippykotlin.demo.pages.foundation.qui_token.QUIToken;
import com.tencent.hippykotlin.demo.pages.nearby.base.utils.FastClickUtils;
import com.tencent.hippykotlin.demo.pages.nearby.base.utils.NearbyProUtilsKt;
import com.tencent.hippykotlin.demo.pages.nearby.new_homepage.data.TagInfo;
import com.tencent.hippykotlin.demo.pages.nearby.new_homepage.view_model.FollowStatus;
import com.tencent.hippykotlin.demo.pages.nearby.new_homepage.view_model.NBPHomePageBaseViewModel;
import com.tencent.kuikly.core.base.Attr;
import com.tencent.kuikly.core.base.BorderStyle;
import com.tencent.kuikly.core.base.ComposeView;
import com.tencent.kuikly.core.base.ViewContainer;
import com.tencent.kuikly.core.base.attr.b;
import com.tencent.kuikly.core.base.attr.c;
import com.tencent.kuikly.core.base.e;
import com.tencent.kuikly.core.base.event.ClickParams;
import com.tencent.kuikly.core.base.event.Event;
import com.tencent.kuikly.core.base.event.VisibilityEventKt;
import com.tencent.kuikly.core.base.h;
import com.tencent.kuikly.core.base.m;
import com.tencent.kuikly.core.directives.BindDirectivesView;
import com.tencent.kuikly.core.directives.BindDirectivesViewKt;
import com.tencent.kuikly.core.directives.ConditionView;
import com.tencent.kuikly.core.directives.ConditionViewKt;
import com.tencent.kuikly.core.views.ImageView;
import com.tencent.kuikly.core.views.RichTextAttr;
import com.tencent.kuikly.core.views.RichTextEvent;
import com.tencent.kuikly.core.views.RichTextView;
import com.tencent.kuikly.core.views.RichTextViewKt;
import com.tencent.kuikly.core.views.TextView;
import com.tencent.kuikly.core.views.af;
import com.tencent.kuikly.core.views.ah;
import com.tencent.kuikly.core.views.ce;
import com.tencent.kuikly.core.views.cf;
import com.tencent.kuikly.core.views.cg;
import com.tencent.kuikly.core.views.t;
import com.tencent.kuikly.core.views.u;
import com.tencent.kuikly.core.views.v;
import com.tencent.kuikly.core.views.w;
import com.tencent.qqlive.module.videoreport.dtreport.constants.DTParamKey;
import j25.b;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.properties.ReadWriteProperty;
import kotlin.reflect.KProperty;

/* loaded from: classes31.dex */
public final class NBPHomepageProfileCard extends ComposeView<NBPHomepageProfileCardAttr, NBPHomepageProfileCardEvent> {
    public static final /* synthetic */ KProperty<Object>[] $$delegatedProperties = {YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0.m(NBPHomepageProfileCard.class, "showUnfollowActionSheet", "getShowUnfollowActionSheet()Z", 0)};
    public final FastClickUtils fastClickUtils = new FastClickUtils(500);
    public final ReadWriteProperty showUnfollowActionSheet$delegate = c.a(Boolean.FALSE);

    /* JADX WARN: Multi-variable type inference failed */
    public static final /* synthetic */ NBPHomepageProfileCardAttr access$getAttr(NBPHomepageProfileCard nBPHomepageProfileCard) {
        return (NBPHomepageProfileCardAttr) nBPHomepageProfileCard.getAttr();
    }

    @Override // com.tencent.kuikly.core.base.ComposeView
    public final Function1<ViewContainer<?, ?>, Unit> body() {
        return new Function1<ViewContainer<?, ?>, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_homepage.view.NBPHomepageProfileCard$body$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Unit invoke(ViewContainer<?, ?> viewContainer) {
                ViewContainer<?, ?> viewContainer2 = viewContainer;
                viewContainer2.attr(new Function1<m, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_homepage.view.NBPHomepageProfileCard$body$1.1
                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(m mVar) {
                        m mVar2 = mVar;
                        mVar2.flexDirectionColumn();
                        mVar2.mo153width(mVar2.getPagerData().m());
                        mVar2.mo113backgroundColor(QUIToken.color$default("bg_bottom_light"));
                        return Unit.INSTANCE;
                    }
                });
                final NBPHomepageProfileCard nBPHomepageProfileCard = NBPHomepageProfileCard.this;
                w.a(viewContainer2, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_homepage.view.NBPHomepageProfileCard$body$1.2
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(v vVar) {
                        v vVar2 = vVar;
                        vVar2.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_homepage.view.NBPHomepageProfileCard.body.1.2.1
                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(t tVar) {
                                t tVar2 = tVar;
                                tVar2.flexDirectionRow();
                                tVar2.margin(16.0f, 16.0f, 12.0f, 16.0f);
                                tVar2.overflow(true);
                                return Unit.INSTANCE;
                            }
                        });
                        final NBPHomepageProfileCard nBPHomepageProfileCard2 = NBPHomepageProfileCard.this;
                        ah.a(vVar2, new Function1<ImageView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_homepage.view.NBPHomepageProfileCard.body.1.2.2
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(ImageView imageView) {
                                final NBPHomepageProfileCard nBPHomepageProfileCard3 = NBPHomepageProfileCard.this;
                                imageView.attr(new Function1<af, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_homepage.view.NBPHomepageProfileCard.body.1.2.2.1
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(af afVar) {
                                        s35.af userInfo;
                                        String str;
                                        af afVar2 = afVar;
                                        afVar2.marginTop(4.0f);
                                        afVar2.size(90.0f, 90.0f);
                                        afVar2.borderRadius(45.0f);
                                        NBPHomePageBaseViewModel nBPHomePageBaseViewModel = NBPHomepageProfileCard.access$getAttr(NBPHomepageProfileCard.this).viewModel;
                                        if (nBPHomePageBaseViewModel != null && (userInfo = nBPHomePageBaseViewModel.getUserInfo()) != null && (str = userInfo.E) != null) {
                                        }
                                        NBPHomepageProfileCardAttr access$getAttr = NBPHomepageProfileCard.access$getAttr(NBPHomepageProfileCard.this);
                                        afVar2.m147opacity(((Number) access$getAttr.avatarOpacity$delegate.getValue(access$getAttr, NBPHomepageProfileCardAttr.$$delegatedProperties[0])).floatValue());
                                        return Unit.INSTANCE;
                                    }
                                });
                                return Unit.INSTANCE;
                            }
                        });
                        final NBPHomepageProfileCard nBPHomepageProfileCard3 = NBPHomepageProfileCard.this;
                        w.a(vVar2, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_homepage.view.NBPHomepageProfileCard.body.1.2.3
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(v vVar3) {
                                v vVar4 = vVar3;
                                vVar4.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_homepage.view.NBPHomepageProfileCard.body.1.2.3.1
                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(t tVar) {
                                        t tVar2 = tVar;
                                        tVar2.m140flex(1.0f);
                                        tVar2.marginLeft(16.0f);
                                        tVar2.marginTop(4.0f);
                                        tVar2.marginRight(4.0f);
                                        tVar2.m145minHeight(90.0f);
                                        tVar2.justifyContentCenter();
                                        tVar2.flexDirectionColumn();
                                        return Unit.INSTANCE;
                                    }
                                });
                                final NBPHomepageProfileCard nBPHomepageProfileCard4 = NBPHomepageProfileCard.this;
                                w.a(vVar4, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_homepage.view.NBPHomepageProfileCard.body.1.2.3.2
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(v vVar5) {
                                        v vVar6 = vVar5;
                                        vVar6.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_homepage.view.NBPHomepageProfileCard.body.1.2.3.2.1
                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(t tVar) {
                                                t tVar2 = tVar;
                                                tVar2.marginRight(10.0f);
                                                tVar2.flexDirectionRow();
                                                return Unit.INSTANCE;
                                            }
                                        });
                                        final NBPHomepageProfileCard nBPHomepageProfileCard5 = NBPHomepageProfileCard.this;
                                        cg.a(vVar6, new Function1<TextView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_homepage.view.NBPHomepageProfileCard.body.1.2.3.2.2
                                            {
                                                super(1);
                                            }

                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(TextView textView) {
                                                final NBPHomepageProfileCard nBPHomepageProfileCard6 = NBPHomepageProfileCard.this;
                                                textView.attr(new Function1<ce, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_homepage.view.NBPHomepageProfileCard.body.1.2.3.2.2.1
                                                    {
                                                        super(1);
                                                    }

                                                    @Override // kotlin.jvm.functions.Function1
                                                    public final Unit invoke(ce ceVar) {
                                                        s35.af userInfo;
                                                        String str;
                                                        ce ceVar2 = ceVar;
                                                        ceVar2.m140flex(1.0f);
                                                        ceVar2.fontWeight500();
                                                        ce.fontSize$default(ceVar2, 17.0f, null, 2, null);
                                                        ceVar2.color(QUIToken.color$default("text_primary"));
                                                        ceVar2.lines(1);
                                                        NBPHomePageBaseViewModel nBPHomePageBaseViewModel = NBPHomepageProfileCard.access$getAttr(NBPHomepageProfileCard.this).viewModel;
                                                        if (nBPHomePageBaseViewModel != null && (userInfo = nBPHomePageBaseViewModel.getUserInfo()) != null && (str = userInfo.f433209f) != null) {
                                                            ceVar2.text(str);
                                                        }
                                                        NBPHomepageProfileCardAttr access$getAttr = NBPHomepageProfileCard.access$getAttr(NBPHomepageProfileCard.this);
                                                        ceVar2.m147opacity(((Number) access$getAttr.avatarOpacity$delegate.getValue(access$getAttr, NBPHomepageProfileCardAttr.$$delegatedProperties[0])).floatValue());
                                                        return Unit.INSTANCE;
                                                    }
                                                });
                                                return Unit.INSTANCE;
                                            }
                                        });
                                        return Unit.INSTANCE;
                                    }
                                });
                                final NBPHomepageProfileCard nBPHomepageProfileCard5 = NBPHomepageProfileCard.this;
                                Function0<Object> function0 = new Function0<Object>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_homepage.view.NBPHomepageProfileCard.body.1.2.3.3
                                    {
                                        super(0);
                                    }

                                    /* JADX WARN: Removed duplicated region for block: B:21:0x003f  */
                                    @Override // kotlin.jvm.functions.Function0
                                    /*
                                        Code decompiled incorrectly, please refer to instructions dump.
                                    */
                                    public final Object invoke() {
                                        boolean z16;
                                        s35.af userInfo;
                                        j25.c cVar;
                                        String str;
                                        NBPHomePageBaseViewModel nBPHomePageBaseViewModel = NBPHomepageProfileCard.access$getAttr(NBPHomepageProfileCard.this).viewModel;
                                        boolean z17 = false;
                                        if (nBPHomePageBaseViewModel != null && nBPHomePageBaseViewModel.getAppId() == 1) {
                                            NBPHomePageBaseViewModel nBPHomePageBaseViewModel2 = NBPHomepageProfileCard.access$getAttr(NBPHomepageProfileCard.this).viewModel;
                                            if (nBPHomePageBaseViewModel2 != null && (userInfo = nBPHomePageBaseViewModel2.getUserInfo()) != null && (cVar = userInfo.f433208e0) != null && (str = cVar.f409182e) != null) {
                                                if (str.length() > 0) {
                                                    z16 = true;
                                                    if (z16) {
                                                        z17 = true;
                                                    }
                                                }
                                            }
                                            z16 = false;
                                            if (z16) {
                                            }
                                        }
                                        return Boolean.valueOf(z17);
                                    }
                                };
                                final NBPHomepageProfileCard nBPHomepageProfileCard6 = NBPHomepageProfileCard.this;
                                ConditionViewKt.c(vVar4, function0, new Function1<ConditionView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_homepage.view.NBPHomepageProfileCard.body.1.2.3.4
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(ConditionView conditionView) {
                                        final NBPHomepageProfileCard nBPHomepageProfileCard7 = NBPHomepageProfileCard.this;
                                        w.a(conditionView, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_homepage.view.NBPHomepageProfileCard.body.1.2.3.4.1
                                            {
                                                super(1);
                                            }

                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(v vVar5) {
                                                v vVar6 = vVar5;
                                                vVar6.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_homepage.view.NBPHomepageProfileCard.body.1.2.3.4.1.1
                                                    @Override // kotlin.jvm.functions.Function1
                                                    public final Unit invoke(t tVar) {
                                                        tVar.flexDirectionRow();
                                                        return Unit.INSTANCE;
                                                    }
                                                });
                                                final NBPHomepageProfileCard nBPHomepageProfileCard8 = NBPHomepageProfileCard.this;
                                                w.a(vVar6, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_homepage.view.NBPHomepageProfileCard.body.1.2.3.4.1.2
                                                    {
                                                        super(1);
                                                    }

                                                    @Override // kotlin.jvm.functions.Function1
                                                    public final Unit invoke(v vVar7) {
                                                        v vVar8 = vVar7;
                                                        final NBPHomepageProfileCard nBPHomepageProfileCard9 = NBPHomepageProfileCard.this;
                                                        vVar8.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_homepage.view.NBPHomepageProfileCard.body.1.2.3.4.1.2.1
                                                            {
                                                                super(1);
                                                            }

                                                            /* JADX WARN: Code restructure failed: missing block: B:11:0x002d, code lost:
                                                            
                                                                r0 = kotlin.text.StringsKt__StringsJVMKt.replace$default(r1, "#", "0x99", false, 4, (java.lang.Object) null);
                                                             */
                                                            @Override // kotlin.jvm.functions.Function1
                                                            /*
                                                                Code decompiled incorrectly, please refer to instructions dump.
                                                            */
                                                            public final Unit invoke(t tVar) {
                                                                s35.af userInfo;
                                                                j25.c cVar;
                                                                b bVar;
                                                                String replace$default;
                                                                t tVar2 = tVar;
                                                                tVar2.mo141height(25.0f);
                                                                tVar2.marginTop(4.0f);
                                                                tVar2.borderRadius(20.0f);
                                                                NBPHomePageBaseViewModel nBPHomePageBaseViewModel = NBPHomepageProfileCard.access$getAttr(NBPHomepageProfileCard.this).viewModel;
                                                                if (nBPHomePageBaseViewModel != null && (userInfo = nBPHomePageBaseViewModel.getUserInfo()) != null && (cVar = userInfo.f433208e0) != null && (bVar = cVar.f409186m) != null && (r1 = bVar.f409179i) != null && replace$default != null) {
                                                                    tVar2.backgroundColor(h.INSTANCE.o(replace$default));
                                                                }
                                                                tVar2.flexDirectionRow();
                                                                tVar2.allCenter();
                                                                return Unit.INSTANCE;
                                                            }
                                                        });
                                                        final NBPHomepageProfileCard nBPHomepageProfileCard10 = NBPHomepageProfileCard.this;
                                                        vVar8.event(new Function1<u, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_homepage.view.NBPHomepageProfileCard.body.1.2.3.4.1.2.2
                                                            {
                                                                super(1);
                                                            }

                                                            @Override // kotlin.jvm.functions.Function1
                                                            public final Unit invoke(u uVar) {
                                                                final NBPHomepageProfileCard nBPHomepageProfileCard11 = NBPHomepageProfileCard.this;
                                                                uVar.click(new Function1<ClickParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_homepage.view.NBPHomepageProfileCard.body.1.2.3.4.1.2.2.1
                                                                    {
                                                                        super(1);
                                                                    }

                                                                    @Override // kotlin.jvm.functions.Function1
                                                                    public final Unit invoke(ClickParams clickParams) {
                                                                        s35.af userInfo;
                                                                        j25.c cVar;
                                                                        if (!NBPHomepageProfileCard.this.fastClickUtils.isFastDoubleClick()) {
                                                                            StringBuilder m3 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("mqqapi://stranger/signal_square?partner_id=");
                                                                            NBPHomePageBaseViewModel nBPHomePageBaseViewModel = NBPHomepageProfileCard.access$getAttr(NBPHomepageProfileCard.this).viewModel;
                                                                            m3.append((nBPHomePageBaseViewModel == null || (userInfo = nBPHomePageBaseViewModel.getUserInfo()) == null || (cVar = userInfo.f433208e0) == null) ? 0L : cVar.f409181d);
                                                                            String sb5 = m3.toString();
                                                                            QQKuiklyPlatformApi.Companion companion = QQKuiklyPlatformApi.Companion;
                                                                            QQKuiklyPlatformApi.Companion.openPage$default(sb5, false, 6);
                                                                        }
                                                                        return Unit.INSTANCE;
                                                                    }
                                                                });
                                                                return Unit.INSTANCE;
                                                            }
                                                        });
                                                        final NBPHomepageProfileCard nBPHomepageProfileCard11 = NBPHomepageProfileCard.this;
                                                        ah.a(vVar8, new Function1<ImageView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_homepage.view.NBPHomepageProfileCard.body.1.2.3.4.1.2.3
                                                            {
                                                                super(1);
                                                            }

                                                            @Override // kotlin.jvm.functions.Function1
                                                            public final Unit invoke(ImageView imageView) {
                                                                final NBPHomepageProfileCard nBPHomepageProfileCard12 = NBPHomepageProfileCard.this;
                                                                imageView.attr(new Function1<af, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_homepage.view.NBPHomepageProfileCard.body.1.2.3.4.1.2.3.1
                                                                    {
                                                                        super(1);
                                                                    }

                                                                    @Override // kotlin.jvm.functions.Function1
                                                                    public final Unit invoke(af afVar) {
                                                                        s35.af userInfo;
                                                                        j25.c cVar;
                                                                        b bVar;
                                                                        af afVar2 = afVar;
                                                                        afVar2.marginLeft(8.0f);
                                                                        afVar2.size(20.0f, 20.0f);
                                                                        NBPHomePageBaseViewModel nBPHomePageBaseViewModel = NBPHomepageProfileCard.access$getAttr(NBPHomepageProfileCard.this).viewModel;
                                                                        b.a.b(afVar2, String.valueOf((nBPHomePageBaseViewModel == null || (userInfo = nBPHomePageBaseViewModel.getUserInfo()) == null || (cVar = userInfo.f433208e0) == null || (bVar = cVar.f409186m) == null) ? null : bVar.f409178h), false, 2, null);
                                                                        return Unit.INSTANCE;
                                                                    }
                                                                });
                                                                return Unit.INSTANCE;
                                                            }
                                                        });
                                                        final NBPHomepageProfileCard nBPHomepageProfileCard12 = NBPHomepageProfileCard.this;
                                                        cg.a(vVar8, new Function1<TextView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_homepage.view.NBPHomepageProfileCard.body.1.2.3.4.1.2.4
                                                            {
                                                                super(1);
                                                            }

                                                            @Override // kotlin.jvm.functions.Function1
                                                            public final Unit invoke(TextView textView) {
                                                                final NBPHomepageProfileCard nBPHomepageProfileCard13 = NBPHomepageProfileCard.this;
                                                                textView.attr(new Function1<ce, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_homepage.view.NBPHomepageProfileCard.body.1.2.3.4.1.2.4.1
                                                                    {
                                                                        super(1);
                                                                    }

                                                                    @Override // kotlin.jvm.functions.Function1
                                                                    public final Unit invoke(ce ceVar) {
                                                                        s35.af userInfo;
                                                                        j25.c cVar;
                                                                        ce ceVar2 = ceVar;
                                                                        ceVar2.fontWeight400();
                                                                        String str = null;
                                                                        ce.fontSize$default(ceVar2, 12.0f, null, 2, null);
                                                                        ceVar2.marginLeft(4.0f);
                                                                        ceVar2.marginRight(8.0f);
                                                                        ceVar2.color(QUIToken.color$default("text_primary"));
                                                                        StringBuilder sb5 = new StringBuilder();
                                                                        sb5.append('\u627e');
                                                                        NBPHomePageBaseViewModel nBPHomePageBaseViewModel = NBPHomepageProfileCard.access$getAttr(NBPHomepageProfileCard.this).viewModel;
                                                                        if (nBPHomePageBaseViewModel != null && (userInfo = nBPHomePageBaseViewModel.getUserInfo()) != null && (cVar = userInfo.f433208e0) != null) {
                                                                            str = cVar.f409182e;
                                                                        }
                                                                        sb5.append(str);
                                                                        ceVar2.text(sb5.toString());
                                                                        return Unit.INSTANCE;
                                                                    }
                                                                });
                                                                return Unit.INSTANCE;
                                                            }
                                                        });
                                                        return Unit.INSTANCE;
                                                    }
                                                });
                                                w.a(vVar6, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_homepage.view.NBPHomepageProfileCard.body.1.2.3.4.1.3
                                                    @Override // kotlin.jvm.functions.Function1
                                                    public final Unit invoke(v vVar7) {
                                                        vVar7.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_homepage.view.NBPHomepageProfileCard.body.1.2.3.4.1.3.1
                                                            @Override // kotlin.jvm.functions.Function1
                                                            public final Unit invoke(t tVar) {
                                                                tVar.m140flex(1.0f);
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
                                final NBPHomepageProfileCard nBPHomepageProfileCard7 = NBPHomepageProfileCard.this;
                                Function0<Object> function02 = new Function0<Object>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_homepage.view.NBPHomepageProfileCard.body.1.2.3.5
                                    {
                                        super(0);
                                    }

                                    /* JADX WARN: Code restructure failed: missing block: B:12:0x0039, code lost:
                                    
                                        if (((r0 == null || ((java.lang.Boolean) r0.isLoadingFansCount$delegate.getValue(r0, com.tencent.hippykotlin.demo.pages.nearby.new_homepage.view_model.NBPHomePageBaseViewModel.$$delegatedProperties[19])).booleanValue()) ? false : true) != false) goto L18;
                                     */
                                    @Override // kotlin.jvm.functions.Function0
                                    /*
                                        Code decompiled incorrectly, please refer to instructions dump.
                                    */
                                    public final Object invoke() {
                                        NBPHomePageBaseViewModel nBPHomePageBaseViewModel = NBPHomepageProfileCard.access$getAttr(NBPHomepageProfileCard.this).viewModel;
                                        boolean z16 = true;
                                        if (nBPHomePageBaseViewModel != null && nBPHomePageBaseViewModel.getAppId() == 2) {
                                            NBPHomePageBaseViewModel nBPHomePageBaseViewModel2 = NBPHomepageProfileCard.access$getAttr(NBPHomepageProfileCard.this).viewModel;
                                        }
                                        z16 = false;
                                        return Boolean.valueOf(z16);
                                    }
                                };
                                final NBPHomepageProfileCard nBPHomepageProfileCard8 = NBPHomepageProfileCard.this;
                                ConditionViewKt.c(vVar4, function02, new Function1<ConditionView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_homepage.view.NBPHomepageProfileCard.body.1.2.3.6
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(ConditionView conditionView) {
                                        final NBPHomepageProfileCard nBPHomepageProfileCard9 = NBPHomepageProfileCard.this;
                                        w.a(conditionView, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_homepage.view.NBPHomepageProfileCard.body.1.2.3.6.1
                                            {
                                                super(1);
                                            }

                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(v vVar5) {
                                                v vVar6 = vVar5;
                                                vVar6.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_homepage.view.NBPHomepageProfileCard.body.1.2.3.6.1.1
                                                    @Override // kotlin.jvm.functions.Function1
                                                    public final Unit invoke(t tVar) {
                                                        tVar.flexDirectionRow();
                                                        return Unit.INSTANCE;
                                                    }
                                                });
                                                final NBPHomepageProfileCard nBPHomepageProfileCard10 = NBPHomepageProfileCard.this;
                                                RichTextViewKt.b(vVar6, new Function1<RichTextView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_homepage.view.NBPHomepageProfileCard.body.1.2.3.6.1.2
                                                    {
                                                        super(1);
                                                    }

                                                    @Override // kotlin.jvm.functions.Function1
                                                    public final Unit invoke(RichTextView richTextView) {
                                                        RichTextView richTextView2 = richTextView;
                                                        richTextView2.attr(new Function1<RichTextAttr, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_homepage.view.NBPHomepageProfileCard.body.1.2.3.6.1.2.1
                                                            @Override // kotlin.jvm.functions.Function1
                                                            public final Unit invoke(RichTextAttr richTextAttr) {
                                                                RichTextAttr richTextAttr2 = richTextAttr;
                                                                richTextAttr2.lineHeight(24.0f);
                                                                richTextAttr2.m144maxWidth(200.0f);
                                                                richTextAttr2.lines(1);
                                                                return Unit.INSTANCE;
                                                            }
                                                        });
                                                        final NBPHomepageProfileCard nBPHomepageProfileCard11 = NBPHomepageProfileCard.this;
                                                        richTextView2.event(new Function1<RichTextEvent, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_homepage.view.NBPHomepageProfileCard.body.1.2.3.6.1.2.2
                                                            {
                                                                super(1);
                                                            }

                                                            @Override // kotlin.jvm.functions.Function1
                                                            public final Unit invoke(RichTextEvent richTextEvent) {
                                                                RichTextEvent richTextEvent2 = richTextEvent;
                                                                final NBPHomepageProfileCard nBPHomepageProfileCard12 = NBPHomepageProfileCard.this;
                                                                richTextEvent2.click(new Function1<ClickParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_homepage.view.NBPHomepageProfileCard.body.1.2.3.6.1.2.2.1
                                                                    {
                                                                        super(1);
                                                                    }

                                                                    @Override // kotlin.jvm.functions.Function1
                                                                    public final Unit invoke(ClickParams clickParams) {
                                                                        NBPHomePageBaseViewModel nBPHomePageBaseViewModel = NBPHomepageProfileCard.access$getAttr(NBPHomepageProfileCard.this).viewModel;
                                                                        if (nBPHomePageBaseViewModel != null) {
                                                                            nBPHomePageBaseViewModel.handleFollowAreaClick(true);
                                                                        }
                                                                        NBPHomePageBaseViewModel nBPHomePageBaseViewModel2 = NBPHomepageProfileCard.access$getAttr(NBPHomepageProfileCard.this).viewModel;
                                                                        if (nBPHomePageBaseViewModel2 != null) {
                                                                            nBPHomePageBaseViewModel2.homePageBaseReport("dt_clck", "em_nearby_kl_fans_list");
                                                                        }
                                                                        return Unit.INSTANCE;
                                                                    }
                                                                });
                                                                final NBPHomepageProfileCard nBPHomepageProfileCard13 = NBPHomepageProfileCard.this;
                                                                VisibilityEventKt.b(richTextEvent2, new Function1<Object, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_homepage.view.NBPHomepageProfileCard.body.1.2.3.6.1.2.2.2
                                                                    {
                                                                        super(1);
                                                                    }

                                                                    @Override // kotlin.jvm.functions.Function1
                                                                    public final Unit invoke(Object obj) {
                                                                        NBPHomePageBaseViewModel nBPHomePageBaseViewModel = NBPHomepageProfileCard.access$getAttr(NBPHomepageProfileCard.this).viewModel;
                                                                        if (nBPHomePageBaseViewModel != null) {
                                                                            nBPHomePageBaseViewModel.homePageBaseReport("dt_imp", "em_nearby_kl_fans_list");
                                                                        }
                                                                        return Unit.INSTANCE;
                                                                    }
                                                                });
                                                                return Unit.INSTANCE;
                                                            }
                                                        });
                                                        RichTextViewKt.c(richTextView2, new Function1<cf, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_homepage.view.NBPHomepageProfileCard.body.1.2.3.6.1.2.3
                                                            @Override // kotlin.jvm.functions.Function1
                                                            public final Unit invoke(cf cfVar) {
                                                                cf cfVar2 = cfVar;
                                                                cfVar2.text("\u7c89\u4e1d ");
                                                                cfVar2.fontWeight400();
                                                                cfVar2.color(QUIToken.color$default("text_secondary"));
                                                                ce.fontSize$default(cfVar2, 12.0f, null, 2, null);
                                                                return Unit.INSTANCE;
                                                            }
                                                        });
                                                        final NBPHomepageProfileCard nBPHomepageProfileCard12 = NBPHomepageProfileCard.this;
                                                        RichTextViewKt.c(richTextView2, new Function1<cf, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_homepage.view.NBPHomepageProfileCard.body.1.2.3.6.1.2.4
                                                            {
                                                                super(1);
                                                            }

                                                            @Override // kotlin.jvm.functions.Function1
                                                            public final Unit invoke(cf cfVar) {
                                                                cf cfVar2 = cfVar;
                                                                cfVar2.marginLeft(4.0f);
                                                                NBPHomePageBaseViewModel nBPHomePageBaseViewModel = NBPHomepageProfileCard.access$getAttr(NBPHomepageProfileCard.this).viewModel;
                                                                cfVar2.text(String.valueOf(nBPHomePageBaseViewModel != null ? NearbyProUtilsKt.formatToDisplay(nBPHomePageBaseViewModel.getTotalFansCount()) : null));
                                                                cfVar2.fontWeight500();
                                                                cfVar2.color(QUIToken.color$default("text_primary"));
                                                                ce.fontSize$default(cfVar2, 12.0f, null, 2, null);
                                                                return Unit.INSTANCE;
                                                            }
                                                        });
                                                        return Unit.INSTANCE;
                                                    }
                                                });
                                                final NBPHomepageProfileCard nBPHomepageProfileCard11 = NBPHomepageProfileCard.this;
                                                RichTextViewKt.b(vVar6, new Function1<RichTextView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_homepage.view.NBPHomepageProfileCard.body.1.2.3.6.1.3
                                                    {
                                                        super(1);
                                                    }

                                                    @Override // kotlin.jvm.functions.Function1
                                                    public final Unit invoke(RichTextView richTextView) {
                                                        RichTextView richTextView2 = richTextView;
                                                        richTextView2.attr(new Function1<RichTextAttr, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_homepage.view.NBPHomepageProfileCard.body.1.2.3.6.1.3.1
                                                            @Override // kotlin.jvm.functions.Function1
                                                            public final Unit invoke(RichTextAttr richTextAttr) {
                                                                RichTextAttr richTextAttr2 = richTextAttr;
                                                                richTextAttr2.lineHeight(24.0f);
                                                                richTextAttr2.marginLeft(12.0f);
                                                                richTextAttr2.m144maxWidth(200.0f);
                                                                richTextAttr2.lines(1);
                                                                return Unit.INSTANCE;
                                                            }
                                                        });
                                                        final NBPHomepageProfileCard nBPHomepageProfileCard12 = NBPHomepageProfileCard.this;
                                                        richTextView2.event(new Function1<RichTextEvent, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_homepage.view.NBPHomepageProfileCard.body.1.2.3.6.1.3.2
                                                            {
                                                                super(1);
                                                            }

                                                            @Override // kotlin.jvm.functions.Function1
                                                            public final Unit invoke(RichTextEvent richTextEvent) {
                                                                RichTextEvent richTextEvent2 = richTextEvent;
                                                                final NBPHomepageProfileCard nBPHomepageProfileCard13 = NBPHomepageProfileCard.this;
                                                                richTextEvent2.click(new Function1<ClickParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_homepage.view.NBPHomepageProfileCard.body.1.2.3.6.1.3.2.1
                                                                    {
                                                                        super(1);
                                                                    }

                                                                    @Override // kotlin.jvm.functions.Function1
                                                                    public final Unit invoke(ClickParams clickParams) {
                                                                        NBPHomePageBaseViewModel nBPHomePageBaseViewModel = NBPHomepageProfileCard.access$getAttr(NBPHomepageProfileCard.this).viewModel;
                                                                        if (nBPHomePageBaseViewModel != null) {
                                                                            nBPHomePageBaseViewModel.handleFollowAreaClick(false);
                                                                        }
                                                                        NBPHomePageBaseViewModel nBPHomePageBaseViewModel2 = NBPHomepageProfileCard.access$getAttr(NBPHomepageProfileCard.this).viewModel;
                                                                        if (nBPHomePageBaseViewModel2 != null) {
                                                                            nBPHomePageBaseViewModel2.homePageBaseReport("dt_clck", "em_nearby_kl_focus_list");
                                                                        }
                                                                        return Unit.INSTANCE;
                                                                    }
                                                                });
                                                                final NBPHomepageProfileCard nBPHomepageProfileCard14 = NBPHomepageProfileCard.this;
                                                                VisibilityEventKt.b(richTextEvent2, new Function1<Object, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_homepage.view.NBPHomepageProfileCard.body.1.2.3.6.1.3.2.2
                                                                    {
                                                                        super(1);
                                                                    }

                                                                    @Override // kotlin.jvm.functions.Function1
                                                                    public final Unit invoke(Object obj) {
                                                                        NBPHomePageBaseViewModel nBPHomePageBaseViewModel = NBPHomepageProfileCard.access$getAttr(NBPHomepageProfileCard.this).viewModel;
                                                                        if (nBPHomePageBaseViewModel != null) {
                                                                            nBPHomePageBaseViewModel.homePageBaseReport("dt_imp", "em_nearby_kl_focus_list");
                                                                        }
                                                                        return Unit.INSTANCE;
                                                                    }
                                                                });
                                                                return Unit.INSTANCE;
                                                            }
                                                        });
                                                        RichTextViewKt.c(richTextView2, new Function1<cf, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_homepage.view.NBPHomepageProfileCard.body.1.2.3.6.1.3.3
                                                            @Override // kotlin.jvm.functions.Function1
                                                            public final Unit invoke(cf cfVar) {
                                                                cf cfVar2 = cfVar;
                                                                cfVar2.text("\u5173\u6ce8 ");
                                                                cfVar2.fontWeight400();
                                                                cfVar2.color(QUIToken.color$default("text_secondary"));
                                                                ce.fontSize$default(cfVar2, 12.0f, null, 2, null);
                                                                return Unit.INSTANCE;
                                                            }
                                                        });
                                                        final NBPHomepageProfileCard nBPHomepageProfileCard13 = NBPHomepageProfileCard.this;
                                                        RichTextViewKt.c(richTextView2, new Function1<cf, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_homepage.view.NBPHomepageProfileCard.body.1.2.3.6.1.3.4
                                                            {
                                                                super(1);
                                                            }

                                                            @Override // kotlin.jvm.functions.Function1
                                                            public final Unit invoke(cf cfVar) {
                                                                cf cfVar2 = cfVar;
                                                                cfVar2.marginLeft(4.0f);
                                                                cfVar2.marginLeft(12.0f);
                                                                NBPHomePageBaseViewModel nBPHomePageBaseViewModel = NBPHomepageProfileCard.access$getAttr(NBPHomepageProfileCard.this).viewModel;
                                                                cfVar2.text(String.valueOf(nBPHomePageBaseViewModel != null ? NearbyProUtilsKt.formatToDisplay(((Number) nBPHomePageBaseViewModel.totalFollowsCount$delegate.getValue(nBPHomePageBaseViewModel, NBPHomePageBaseViewModel.$$delegatedProperties[18])).intValue()) : null));
                                                                cfVar2.fontWeight500();
                                                                cfVar2.color(QUIToken.color$default("text_primary"));
                                                                ce.fontSize$default(cfVar2, 12.0f, null, 2, null);
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
                        final NBPHomepageProfileCard nBPHomepageProfileCard4 = NBPHomepageProfileCard.this;
                        Function0<Object> function0 = new Function0<Object>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_homepage.view.NBPHomepageProfileCard.body.1.2.4
                            {
                                super(0);
                            }

                            /* JADX WARN: Code restructure failed: missing block: B:12:0x0029, code lost:
                            
                                if ((r0 != null && r0.getAppId() == 2) != false) goto L18;
                             */
                            @Override // kotlin.jvm.functions.Function0
                            /*
                                Code decompiled incorrectly, please refer to instructions dump.
                            */
                            public final Object invoke() {
                                NBPHomePageBaseViewModel nBPHomePageBaseViewModel = NBPHomepageProfileCard.access$getAttr(NBPHomepageProfileCard.this).viewModel;
                                boolean z16 = true;
                                if ((nBPHomePageBaseViewModel == null || nBPHomePageBaseViewModel.isSelf) ? false : true) {
                                    NBPHomePageBaseViewModel nBPHomePageBaseViewModel2 = NBPHomepageProfileCard.access$getAttr(NBPHomepageProfileCard.this).viewModel;
                                }
                                z16 = false;
                                return Boolean.valueOf(z16);
                            }
                        };
                        final NBPHomepageProfileCard nBPHomepageProfileCard5 = NBPHomepageProfileCard.this;
                        ConditionViewKt.c(vVar2, function0, new Function1<ConditionView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_homepage.view.NBPHomepageProfileCard.body.1.2.5
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(ConditionView conditionView) {
                                final NBPHomepageProfileCard nBPHomepageProfileCard6 = NBPHomepageProfileCard.this;
                                Function0<Object> function02 = new Function0<Object>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_homepage.view.NBPHomepageProfileCard.body.1.2.5.1
                                    {
                                        super(0);
                                    }

                                    @Override // kotlin.jvm.functions.Function0
                                    public final Object invoke() {
                                        NBPHomePageBaseViewModel nBPHomePageBaseViewModel = NBPHomepageProfileCard.access$getAttr(NBPHomepageProfileCard.this).viewModel;
                                        if (nBPHomePageBaseViewModel != null) {
                                            return nBPHomePageBaseViewModel.getFollowState();
                                        }
                                        return null;
                                    }
                                };
                                final NBPHomepageProfileCard nBPHomepageProfileCard7 = NBPHomepageProfileCard.this;
                                BindDirectivesViewKt.a(conditionView, function02, new Function1<BindDirectivesView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_homepage.view.NBPHomepageProfileCard.body.1.2.5.2

                                    /* renamed from: com.tencent.hippykotlin.demo.pages.nearby.new_homepage.view.NBPHomepageProfileCard$body$1$2$5$2$WhenMappings */
                                    /* loaded from: classes31.dex */
                                    public /* synthetic */ class WhenMappings {
                                        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

                                        static {
                                            int[] iArr = new int[FollowStatus.values().length];
                                            try {
                                                iArr[1] = 1;
                                            } catch (NoSuchFieldError unused) {
                                            }
                                            try {
                                                iArr[3] = 2;
                                            } catch (NoSuchFieldError unused2) {
                                            }
                                            try {
                                                iArr[2] = 3;
                                            } catch (NoSuchFieldError unused3) {
                                            }
                                            $EnumSwitchMapping$0 = iArr;
                                        }
                                    }

                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(BindDirectivesView bindDirectivesView) {
                                        BindDirectivesView bindDirectivesView2 = bindDirectivesView;
                                        NBPHomePageBaseViewModel nBPHomePageBaseViewModel = NBPHomepageProfileCard.access$getAttr(NBPHomepageProfileCard.this).viewModel;
                                        FollowStatus followState = nBPHomePageBaseViewModel != null ? nBPHomePageBaseViewModel.getFollowState() : null;
                                        int i3 = followState == null ? -1 : WhenMappings.$EnumSwitchMapping$0[followState.ordinal()];
                                        if (i3 == 1) {
                                            final NBPHomepageProfileCard nBPHomepageProfileCard8 = NBPHomepageProfileCard.this;
                                            w.a(bindDirectivesView2, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_homepage.view.NBPHomepageProfileCard.body.1.2.5.2.1
                                                {
                                                    super(1);
                                                }

                                                @Override // kotlin.jvm.functions.Function1
                                                public final Unit invoke(v vVar3) {
                                                    v vVar4 = vVar3;
                                                    vVar4.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_homepage.view.NBPHomepageProfileCard.body.1.2.5.2.1.1
                                                        @Override // kotlin.jvm.functions.Function1
                                                        public final Unit invoke(t tVar) {
                                                            t tVar2 = tVar;
                                                            tVar2.justifyContentCenter();
                                                            tVar2.mo141height(30.0f);
                                                            tVar2.marginRight(4.0f);
                                                            tVar2.borderRadius(4.0f);
                                                            tVar2.mo113backgroundColor(QUIToken.color$default("fill_standard_primary"));
                                                            tVar2.flexDirectionRow();
                                                            tVar2.alignSelfCenter();
                                                            return Unit.INSTANCE;
                                                        }
                                                    });
                                                    final NBPHomepageProfileCard nBPHomepageProfileCard9 = NBPHomepageProfileCard.this;
                                                    vVar4.event(new Function1<u, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_homepage.view.NBPHomepageProfileCard.body.1.2.5.2.1.2
                                                        {
                                                            super(1);
                                                        }

                                                        @Override // kotlin.jvm.functions.Function1
                                                        public final Unit invoke(u uVar) {
                                                            u uVar2 = uVar;
                                                            final NBPHomepageProfileCard nBPHomepageProfileCard10 = NBPHomepageProfileCard.this;
                                                            uVar2.click(new Function1<ClickParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_homepage.view.NBPHomepageProfileCard.body.1.2.5.2.1.2.1
                                                                {
                                                                    super(1);
                                                                }

                                                                @Override // kotlin.jvm.functions.Function1
                                                                public final Unit invoke(ClickParams clickParams) {
                                                                    r3.showUnfollowActionSheet$delegate.setValue(NBPHomepageProfileCard.this, NBPHomepageProfileCard.$$delegatedProperties[0], Boolean.valueOf(true));
                                                                    NBPHomePageBaseViewModel nBPHomePageBaseViewModel2 = NBPHomepageProfileCard.access$getAttr(NBPHomepageProfileCard.this).viewModel;
                                                                    if (nBPHomePageBaseViewModel2 != null) {
                                                                        nBPHomePageBaseViewModel2.homePageBaseReport("dt_clck", "em_nearby_have_focus");
                                                                    }
                                                                    return Unit.INSTANCE;
                                                                }
                                                            });
                                                            final NBPHomepageProfileCard nBPHomepageProfileCard11 = NBPHomepageProfileCard.this;
                                                            VisibilityEventKt.b(uVar2, new Function1<Object, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_homepage.view.NBPHomepageProfileCard.body.1.2.5.2.1.2.2
                                                                {
                                                                    super(1);
                                                                }

                                                                @Override // kotlin.jvm.functions.Function1
                                                                public final Unit invoke(Object obj) {
                                                                    NBPHomePageBaseViewModel nBPHomePageBaseViewModel2 = NBPHomepageProfileCard.access$getAttr(NBPHomepageProfileCard.this).viewModel;
                                                                    if (nBPHomePageBaseViewModel2 != null) {
                                                                        nBPHomePageBaseViewModel2.homePageBaseReport("dt_imp", "em_nearby_have_focus");
                                                                    }
                                                                    return Unit.INSTANCE;
                                                                }
                                                            });
                                                            return Unit.INSTANCE;
                                                        }
                                                    });
                                                    cg.a(vVar4, new Function1<TextView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_homepage.view.NBPHomepageProfileCard.body.1.2.5.2.1.3
                                                        @Override // kotlin.jvm.functions.Function1
                                                        public final Unit invoke(TextView textView) {
                                                            textView.attr(new Function1<ce, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_homepage.view.NBPHomepageProfileCard.body.1.2.5.2.1.3.1
                                                                @Override // kotlin.jvm.functions.Function1
                                                                public final Unit invoke(ce ceVar) {
                                                                    ce ceVar2 = ceVar;
                                                                    ceVar2.alignSelfCenter();
                                                                    ceVar2.color(QUIToken.color$default("text_secondary"));
                                                                    ceVar2.marginLeft(9.0f);
                                                                    ceVar2.text("\u5df2\u5173\u6ce8");
                                                                    ceVar2.fontWeight400();
                                                                    ce.fontSize$default(ceVar2, 14.0f, null, 2, null);
                                                                    return Unit.INSTANCE;
                                                                }
                                                            });
                                                            return Unit.INSTANCE;
                                                        }
                                                    });
                                                    ah.a(vVar4, new Function1<ImageView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_homepage.view.NBPHomepageProfileCard.body.1.2.5.2.1.4
                                                        @Override // kotlin.jvm.functions.Function1
                                                        public final Unit invoke(ImageView imageView) {
                                                            imageView.attr(new Function1<af, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_homepage.view.NBPHomepageProfileCard.body.1.2.5.2.1.4.1
                                                                @Override // kotlin.jvm.functions.Function1
                                                                public final Unit invoke(af afVar) {
                                                                    af afVar2 = afVar;
                                                                    afVar2.alignSelfCenter();
                                                                    afVar2.marginRight(8.0f);
                                                                    afVar2.size(12.0f, 12.0f);
                                                                    b.a.b(afVar2, QUIToken.INSTANCE.image("chevron_down", QUIToken.color$default("icon_secondary")), false, 2, null);
                                                                    return Unit.INSTANCE;
                                                                }
                                                            });
                                                            return Unit.INSTANCE;
                                                        }
                                                    });
                                                    return Unit.INSTANCE;
                                                }
                                            });
                                        } else if (i3 == 2) {
                                            final NBPHomepageProfileCard nBPHomepageProfileCard9 = NBPHomepageProfileCard.this;
                                            w.a(bindDirectivesView2, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_homepage.view.NBPHomepageProfileCard.body.1.2.5.2.2
                                                {
                                                    super(1);
                                                }

                                                @Override // kotlin.jvm.functions.Function1
                                                public final Unit invoke(v vVar3) {
                                                    v vVar4 = vVar3;
                                                    vVar4.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_homepage.view.NBPHomepageProfileCard.body.1.2.5.2.2.1
                                                        @Override // kotlin.jvm.functions.Function1
                                                        public final Unit invoke(t tVar) {
                                                            t tVar2 = tVar;
                                                            tVar2.justifyContentCenter();
                                                            tVar2.mo141height(30.0f);
                                                            tVar2.marginRight(4.0f);
                                                            tVar2.borderRadius(4.0f);
                                                            tVar2.mo113backgroundColor(QUIToken.color$default("fill_standard_primary"));
                                                            tVar2.flexDirectionRow();
                                                            tVar2.alignSelfCenter();
                                                            return Unit.INSTANCE;
                                                        }
                                                    });
                                                    final NBPHomepageProfileCard nBPHomepageProfileCard10 = NBPHomepageProfileCard.this;
                                                    vVar4.event(new Function1<u, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_homepage.view.NBPHomepageProfileCard.body.1.2.5.2.2.2
                                                        {
                                                            super(1);
                                                        }

                                                        @Override // kotlin.jvm.functions.Function1
                                                        public final Unit invoke(u uVar) {
                                                            u uVar2 = uVar;
                                                            final NBPHomepageProfileCard nBPHomepageProfileCard11 = NBPHomepageProfileCard.this;
                                                            uVar2.click(new Function1<ClickParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_homepage.view.NBPHomepageProfileCard.body.1.2.5.2.2.2.1
                                                                {
                                                                    super(1);
                                                                }

                                                                @Override // kotlin.jvm.functions.Function1
                                                                public final Unit invoke(ClickParams clickParams) {
                                                                    r3.showUnfollowActionSheet$delegate.setValue(NBPHomepageProfileCard.this, NBPHomepageProfileCard.$$delegatedProperties[0], Boolean.valueOf(true));
                                                                    NBPHomePageBaseViewModel nBPHomePageBaseViewModel2 = NBPHomepageProfileCard.access$getAttr(NBPHomepageProfileCard.this).viewModel;
                                                                    if (nBPHomePageBaseViewModel2 != null) {
                                                                        nBPHomePageBaseViewModel2.homePageBaseReport("dt_clck", "em_nearby_focus_each");
                                                                    }
                                                                    return Unit.INSTANCE;
                                                                }
                                                            });
                                                            final NBPHomepageProfileCard nBPHomepageProfileCard12 = NBPHomepageProfileCard.this;
                                                            VisibilityEventKt.b(uVar2, new Function1<Object, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_homepage.view.NBPHomepageProfileCard.body.1.2.5.2.2.2.2
                                                                {
                                                                    super(1);
                                                                }

                                                                @Override // kotlin.jvm.functions.Function1
                                                                public final Unit invoke(Object obj) {
                                                                    NBPHomePageBaseViewModel nBPHomePageBaseViewModel2 = NBPHomepageProfileCard.access$getAttr(NBPHomepageProfileCard.this).viewModel;
                                                                    if (nBPHomePageBaseViewModel2 != null) {
                                                                        nBPHomePageBaseViewModel2.homePageBaseReport("dt_imp", "em_nearby_focus_each");
                                                                    }
                                                                    return Unit.INSTANCE;
                                                                }
                                                            });
                                                            return Unit.INSTANCE;
                                                        }
                                                    });
                                                    cg.a(vVar4, new Function1<TextView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_homepage.view.NBPHomepageProfileCard.body.1.2.5.2.2.3
                                                        @Override // kotlin.jvm.functions.Function1
                                                        public final Unit invoke(TextView textView) {
                                                            textView.attr(new Function1<ce, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_homepage.view.NBPHomepageProfileCard.body.1.2.5.2.2.3.1
                                                                @Override // kotlin.jvm.functions.Function1
                                                                public final Unit invoke(ce ceVar) {
                                                                    ce ceVar2 = ceVar;
                                                                    ceVar2.alignSelfCenter();
                                                                    ceVar2.color(QUIToken.color$default("text_secondary"));
                                                                    ceVar2.marginLeft(9.0f);
                                                                    ceVar2.text("\u4e92\u76f8\u5173\u6ce8");
                                                                    ceVar2.fontWeight400();
                                                                    ce.fontSize$default(ceVar2, 14.0f, null, 2, null);
                                                                    return Unit.INSTANCE;
                                                                }
                                                            });
                                                            return Unit.INSTANCE;
                                                        }
                                                    });
                                                    ah.a(vVar4, new Function1<ImageView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_homepage.view.NBPHomepageProfileCard.body.1.2.5.2.2.4
                                                        @Override // kotlin.jvm.functions.Function1
                                                        public final Unit invoke(ImageView imageView) {
                                                            imageView.attr(new Function1<af, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_homepage.view.NBPHomepageProfileCard.body.1.2.5.2.2.4.1
                                                                @Override // kotlin.jvm.functions.Function1
                                                                public final Unit invoke(af afVar) {
                                                                    af afVar2 = afVar;
                                                                    afVar2.alignSelfCenter();
                                                                    afVar2.size(12.0f, 12.0f);
                                                                    afVar2.marginRight(9.0f);
                                                                    b.a.b(afVar2, QUIToken.INSTANCE.image("chevron_down", QUIToken.color$default("icon_secondary")), false, 2, null);
                                                                    return Unit.INSTANCE;
                                                                }
                                                            });
                                                            return Unit.INSTANCE;
                                                        }
                                                    });
                                                    return Unit.INSTANCE;
                                                }
                                            });
                                        } else if (i3 != 3) {
                                            final NBPHomepageProfileCard nBPHomepageProfileCard10 = NBPHomepageProfileCard.this;
                                            w.a(bindDirectivesView2, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_homepage.view.NBPHomepageProfileCard.body.1.2.5.2.4
                                                {
                                                    super(1);
                                                }

                                                @Override // kotlin.jvm.functions.Function1
                                                public final Unit invoke(v vVar3) {
                                                    v vVar4 = vVar3;
                                                    vVar4.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_homepage.view.NBPHomepageProfileCard.body.1.2.5.2.4.1
                                                        @Override // kotlin.jvm.functions.Function1
                                                        public final Unit invoke(t tVar) {
                                                            t tVar2 = tVar;
                                                            tVar2.justifyContentCenter();
                                                            tVar2.mo141height(30.0f);
                                                            tVar2.marginRight(4.0f);
                                                            tVar2.borderRadius(4.0f);
                                                            tVar2.mo113backgroundColor(QUIToken.color$default("button_bg_secondary_default"));
                                                            tVar2.flexDirectionRow();
                                                            tVar2.alignSelfCenter();
                                                            tVar2.allCenter();
                                                            tVar2.m136border(new e(1.0f, BorderStyle.SOLID, QUIToken.color$default("button_border_secondary_default")));
                                                            return Unit.INSTANCE;
                                                        }
                                                    });
                                                    final NBPHomepageProfileCard nBPHomepageProfileCard11 = NBPHomepageProfileCard.this;
                                                    vVar4.event(new Function1<u, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_homepage.view.NBPHomepageProfileCard.body.1.2.5.2.4.2
                                                        {
                                                            super(1);
                                                        }

                                                        @Override // kotlin.jvm.functions.Function1
                                                        public final Unit invoke(u uVar) {
                                                            u uVar2 = uVar;
                                                            final NBPHomepageProfileCard nBPHomepageProfileCard12 = NBPHomepageProfileCard.this;
                                                            uVar2.click(new Function1<ClickParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_homepage.view.NBPHomepageProfileCard.body.1.2.5.2.4.2.1
                                                                {
                                                                    super(1);
                                                                }

                                                                @Override // kotlin.jvm.functions.Function1
                                                                public final Unit invoke(ClickParams clickParams) {
                                                                    NBPHomePageBaseViewModel nBPHomePageBaseViewModel2 = NBPHomepageProfileCard.access$getAttr(NBPHomepageProfileCard.this).viewModel;
                                                                    if (nBPHomePageBaseViewModel2 != null) {
                                                                        NBPHomePageBaseViewModel nBPHomePageBaseViewModel3 = NBPHomepageProfileCard.access$getAttr(NBPHomepageProfileCard.this).viewModel;
                                                                        nBPHomePageBaseViewModel2.setFollowState(1, String.valueOf(nBPHomePageBaseViewModel3 != null ? nBPHomePageBaseViewModel3.accountId : null));
                                                                    }
                                                                    NBPHomePageBaseViewModel nBPHomePageBaseViewModel4 = NBPHomepageProfileCard.access$getAttr(NBPHomepageProfileCard.this).viewModel;
                                                                    if (nBPHomePageBaseViewModel4 != null) {
                                                                        nBPHomePageBaseViewModel4.setTotalFansCount(nBPHomePageBaseViewModel4.getTotalFansCount() + 1);
                                                                    }
                                                                    NBPHomePageBaseViewModel nBPHomePageBaseViewModel5 = NBPHomepageProfileCard.access$getAttr(NBPHomepageProfileCard.this).viewModel;
                                                                    if (nBPHomePageBaseViewModel5 != null) {
                                                                        nBPHomePageBaseViewModel5.homePageBaseReport("dt_clck", "em_nearby_focus");
                                                                    }
                                                                    return Unit.INSTANCE;
                                                                }
                                                            });
                                                            final NBPHomepageProfileCard nBPHomepageProfileCard13 = NBPHomepageProfileCard.this;
                                                            VisibilityEventKt.b(uVar2, new Function1<Object, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_homepage.view.NBPHomepageProfileCard.body.1.2.5.2.4.2.2
                                                                {
                                                                    super(1);
                                                                }

                                                                @Override // kotlin.jvm.functions.Function1
                                                                public final Unit invoke(Object obj) {
                                                                    NBPHomePageBaseViewModel nBPHomePageBaseViewModel2 = NBPHomepageProfileCard.access$getAttr(NBPHomepageProfileCard.this).viewModel;
                                                                    if (nBPHomePageBaseViewModel2 != null) {
                                                                        nBPHomePageBaseViewModel2.homePageBaseReport("dt_imp", "em_nearby_focus");
                                                                    }
                                                                    return Unit.INSTANCE;
                                                                }
                                                            });
                                                            return Unit.INSTANCE;
                                                        }
                                                    });
                                                    cg.a(vVar4, new Function1<TextView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_homepage.view.NBPHomepageProfileCard.body.1.2.5.2.4.3
                                                        @Override // kotlin.jvm.functions.Function1
                                                        public final Unit invoke(TextView textView) {
                                                            textView.attr(new Function1<ce, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_homepage.view.NBPHomepageProfileCard.body.1.2.5.2.4.3.1
                                                                @Override // kotlin.jvm.functions.Function1
                                                                public final Unit invoke(ce ceVar) {
                                                                    ce ceVar2 = ceVar;
                                                                    ceVar2.alignSelfCenter();
                                                                    ceVar2.color(QUIToken.color$default("button_text_secondary_default"));
                                                                    c.a.a(ceVar2, 0.0f, 16.0f, 0.0f, 16.0f, 5, null);
                                                                    ceVar2.text("\u5173\u6ce8");
                                                                    ceVar2.fontWeight400();
                                                                    ce.fontSize$default(ceVar2, 14.0f, null, 2, null);
                                                                    return Unit.INSTANCE;
                                                                }
                                                            });
                                                            return Unit.INSTANCE;
                                                        }
                                                    });
                                                    return Unit.INSTANCE;
                                                }
                                            });
                                        } else {
                                            final NBPHomepageProfileCard nBPHomepageProfileCard11 = NBPHomepageProfileCard.this;
                                            w.a(bindDirectivesView2, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_homepage.view.NBPHomepageProfileCard.body.1.2.5.2.3
                                                {
                                                    super(1);
                                                }

                                                @Override // kotlin.jvm.functions.Function1
                                                public final Unit invoke(v vVar3) {
                                                    v vVar4 = vVar3;
                                                    vVar4.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_homepage.view.NBPHomepageProfileCard.body.1.2.5.2.3.1
                                                        @Override // kotlin.jvm.functions.Function1
                                                        public final Unit invoke(t tVar) {
                                                            t tVar2 = tVar;
                                                            tVar2.justifyContentCenter();
                                                            tVar2.mo141height(30.0f);
                                                            tVar2.marginRight(4.0f);
                                                            tVar2.borderRadius(4.0f);
                                                            tVar2.mo113backgroundColor(QUIToken.color$default("button_bg_secondary_default"));
                                                            tVar2.flexDirectionRow();
                                                            tVar2.alignSelfCenter();
                                                            tVar2.allCenter();
                                                            tVar2.m136border(new e(1.0f, BorderStyle.SOLID, QUIToken.color$default("button_border_secondary_default")));
                                                            return Unit.INSTANCE;
                                                        }
                                                    });
                                                    final NBPHomepageProfileCard nBPHomepageProfileCard12 = NBPHomepageProfileCard.this;
                                                    vVar4.event(new Function1<u, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_homepage.view.NBPHomepageProfileCard.body.1.2.5.2.3.2
                                                        {
                                                            super(1);
                                                        }

                                                        @Override // kotlin.jvm.functions.Function1
                                                        public final Unit invoke(u uVar) {
                                                            u uVar2 = uVar;
                                                            final NBPHomepageProfileCard nBPHomepageProfileCard13 = NBPHomepageProfileCard.this;
                                                            uVar2.click(new Function1<ClickParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_homepage.view.NBPHomepageProfileCard.body.1.2.5.2.3.2.1
                                                                {
                                                                    super(1);
                                                                }

                                                                @Override // kotlin.jvm.functions.Function1
                                                                public final Unit invoke(ClickParams clickParams) {
                                                                    NBPHomePageBaseViewModel nBPHomePageBaseViewModel2 = NBPHomepageProfileCard.access$getAttr(NBPHomepageProfileCard.this).viewModel;
                                                                    if (nBPHomePageBaseViewModel2 != null) {
                                                                        NBPHomePageBaseViewModel nBPHomePageBaseViewModel3 = NBPHomepageProfileCard.access$getAttr(NBPHomepageProfileCard.this).viewModel;
                                                                        nBPHomePageBaseViewModel2.setFollowState(1, String.valueOf(nBPHomePageBaseViewModel3 != null ? nBPHomePageBaseViewModel3.accountId : null));
                                                                    }
                                                                    NBPHomePageBaseViewModel nBPHomePageBaseViewModel4 = NBPHomepageProfileCard.access$getAttr(NBPHomepageProfileCard.this).viewModel;
                                                                    if (nBPHomePageBaseViewModel4 != null) {
                                                                        nBPHomePageBaseViewModel4.setTotalFansCount(nBPHomePageBaseViewModel4.getTotalFansCount() + 1);
                                                                    }
                                                                    NBPHomePageBaseViewModel nBPHomePageBaseViewModel5 = NBPHomepageProfileCard.access$getAttr(NBPHomepageProfileCard.this).viewModel;
                                                                    if (nBPHomePageBaseViewModel5 != null) {
                                                                        nBPHomePageBaseViewModel5.homePageBaseReport("dt_clck", "em_nearby_backfocus");
                                                                    }
                                                                    return Unit.INSTANCE;
                                                                }
                                                            });
                                                            final NBPHomepageProfileCard nBPHomepageProfileCard14 = NBPHomepageProfileCard.this;
                                                            VisibilityEventKt.b(uVar2, new Function1<Object, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_homepage.view.NBPHomepageProfileCard.body.1.2.5.2.3.2.2
                                                                {
                                                                    super(1);
                                                                }

                                                                @Override // kotlin.jvm.functions.Function1
                                                                public final Unit invoke(Object obj) {
                                                                    NBPHomePageBaseViewModel nBPHomePageBaseViewModel2 = NBPHomepageProfileCard.access$getAttr(NBPHomepageProfileCard.this).viewModel;
                                                                    if (nBPHomePageBaseViewModel2 != null) {
                                                                        nBPHomePageBaseViewModel2.homePageBaseReport("dt_imp", "em_nearby_backfocus");
                                                                    }
                                                                    return Unit.INSTANCE;
                                                                }
                                                            });
                                                            return Unit.INSTANCE;
                                                        }
                                                    });
                                                    cg.a(vVar4, new Function1<TextView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_homepage.view.NBPHomepageProfileCard.body.1.2.5.2.3.3
                                                        @Override // kotlin.jvm.functions.Function1
                                                        public final Unit invoke(TextView textView) {
                                                            textView.attr(new Function1<ce, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_homepage.view.NBPHomepageProfileCard.body.1.2.5.2.3.3.1
                                                                @Override // kotlin.jvm.functions.Function1
                                                                public final Unit invoke(ce ceVar) {
                                                                    ce ceVar2 = ceVar;
                                                                    ceVar2.alignSelfCenter();
                                                                    c.a.a(ceVar2, 0.0f, 16.0f, 0.0f, 16.0f, 5, null);
                                                                    ceVar2.color(QUIToken.color$default("button_text_secondary_default"));
                                                                    ceVar2.text("\u56de\u5173");
                                                                    ceVar2.fontWeight400();
                                                                    ce.fontSize$default(ceVar2, 14.0f, null, 2, null);
                                                                    return Unit.INSTANCE;
                                                                }
                                                            });
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
                final NBPHomepageProfileCard nBPHomepageProfileCard2 = NBPHomepageProfileCard.this;
                Function0<Object> function0 = new Function0<Object>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_homepage.view.NBPHomepageProfileCard$body$1.3
                    {
                        super(0);
                    }

                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        NBPHomepageProfileCard nBPHomepageProfileCard3 = NBPHomepageProfileCard.this;
                        return Boolean.valueOf(((Boolean) nBPHomepageProfileCard3.showUnfollowActionSheet$delegate.getValue(nBPHomepageProfileCard3, NBPHomepageProfileCard.$$delegatedProperties[0])).booleanValue());
                    }
                };
                final NBPHomepageProfileCard nBPHomepageProfileCard3 = NBPHomepageProfileCard.this;
                ConditionViewKt.c(viewContainer2, function0, new Function1<ConditionView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_homepage.view.NBPHomepageProfileCard$body$1.4
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(ConditionView conditionView) {
                        final NBPHomepageProfileCard nBPHomepageProfileCard4 = NBPHomepageProfileCard.this;
                        QActionSheetKt.QActionSheet(conditionView, new Function1<QActionSheetView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_homepage.view.NBPHomepageProfileCard.body.1.4.1
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(QActionSheetView qActionSheetView) {
                                final QActionSheetView qActionSheetView2 = qActionSheetView;
                                final NBPHomepageProfileCard nBPHomepageProfileCard5 = NBPHomepageProfileCard.this;
                                qActionSheetView2.event(new Function1<QActionSheetEvent, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_homepage.view.NBPHomepageProfileCard.body.1.4.1.1
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(QActionSheetEvent qActionSheetEvent) {
                                        QActionSheetEvent qActionSheetEvent2 = qActionSheetEvent;
                                        final NBPHomepageProfileCard nBPHomepageProfileCard6 = NBPHomepageProfileCard.this;
                                        final QActionSheetView qActionSheetView3 = qActionSheetView2;
                                        qActionSheetEvent2.onClickWithText(new Function1<ActionButtonParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_homepage.view.NBPHomepageProfileCard.body.1.4.1.1.1
                                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                            {
                                                super(1);
                                            }

                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(ActionButtonParams actionButtonParams) {
                                                com.tencent.kuikly.core.nvi.serialization.json.e eVar;
                                                if (actionButtonParams.index == 0) {
                                                    NBPHomePageBaseViewModel nBPHomePageBaseViewModel = NBPHomepageProfileCard.access$getAttr(NBPHomepageProfileCard.this).viewModel;
                                                    if (nBPHomePageBaseViewModel != null) {
                                                        NBPHomePageBaseViewModel nBPHomePageBaseViewModel2 = NBPHomepageProfileCard.access$getAttr(NBPHomepageProfileCard.this).viewModel;
                                                        nBPHomePageBaseViewModel.setFollowState(0, String.valueOf(nBPHomePageBaseViewModel2 != null ? nBPHomePageBaseViewModel2.accountId : null));
                                                    }
                                                    qActionSheetView3.dismiss();
                                                    r6.showUnfollowActionSheet$delegate.setValue(NBPHomepageProfileCard.this, NBPHomepageProfileCard.$$delegatedProperties[0], Boolean.valueOf(false));
                                                    NBPHomePageBaseViewModel nBPHomePageBaseViewModel3 = NBPHomepageProfileCard.access$getAttr(NBPHomepageProfileCard.this).viewModel;
                                                    if (nBPHomePageBaseViewModel3 != null) {
                                                        nBPHomePageBaseViewModel3.setTotalFansCount(nBPHomePageBaseViewModel3.getTotalFansCount() - 1);
                                                    }
                                                    NBPHomePageBaseViewModel nBPHomePageBaseViewModel4 = NBPHomepageProfileCard.access$getAttr(NBPHomepageProfileCard.this).viewModel;
                                                    if (nBPHomePageBaseViewModel4 != null) {
                                                        eVar = nBPHomePageBaseViewModel4.jsonWithHomePagePgParams();
                                                        NBPHomepageProfileCard nBPHomepageProfileCard7 = NBPHomepageProfileCard.this;
                                                        eVar.v("dt_eid", "em_nearbby_focus_cancel_float");
                                                        NBPHomePageBaseViewModel nBPHomePageBaseViewModel5 = NBPHomepageProfileCard.access$getAttr(nBPHomepageProfileCard7).viewModel;
                                                        eVar.v("cur_pg", nBPHomePageBaseViewModel5 != null ? nBPHomePageBaseViewModel5.jsonWithHomePagePgParams() : null);
                                                        eVar.t("nearby_btn_type", 1);
                                                    } else {
                                                        eVar = new com.tencent.kuikly.core.nvi.serialization.json.e();
                                                    }
                                                    eVar.v(DTParamKey.REPORT_KEY_APPKEY, "0AND05J90ZOPH3DU");
                                                    Utils.INSTANCE.currentBridgeModule().reportCustomDtEvent("dt_clck", eVar);
                                                }
                                                return Unit.INSTANCE;
                                            }
                                        });
                                        final NBPHomepageProfileCard nBPHomepageProfileCard7 = NBPHomepageProfileCard.this;
                                        qActionSheetEvent2.register("onBottomCancelClick", new Function1<Object, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_homepage.view.NBPHomepageProfileCard.body.1.4.1.1.2
                                            {
                                                super(1);
                                            }

                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(Object obj) {
                                                com.tencent.kuikly.core.nvi.serialization.json.e eVar;
                                                r5.showUnfollowActionSheet$delegate.setValue(NBPHomepageProfileCard.this, NBPHomepageProfileCard.$$delegatedProperties[0], Boolean.valueOf(false));
                                                NBPHomePageBaseViewModel nBPHomePageBaseViewModel = NBPHomepageProfileCard.access$getAttr(NBPHomepageProfileCard.this).viewModel;
                                                if (nBPHomePageBaseViewModel != null) {
                                                    eVar = nBPHomePageBaseViewModel.jsonWithHomePagePgParams();
                                                    NBPHomepageProfileCard nBPHomepageProfileCard8 = NBPHomepageProfileCard.this;
                                                    eVar.v("dt_eid", "em_nearbby_focus_cancel_float");
                                                    NBPHomePageBaseViewModel nBPHomePageBaseViewModel2 = NBPHomepageProfileCard.access$getAttr(nBPHomepageProfileCard8).viewModel;
                                                    eVar.v("cur_pg", nBPHomePageBaseViewModel2 != null ? nBPHomePageBaseViewModel2.jsonWithHomePagePgParams() : null);
                                                    eVar.t("nearby_btn_type", 0);
                                                } else {
                                                    eVar = new com.tencent.kuikly.core.nvi.serialization.json.e();
                                                }
                                                eVar.v(DTParamKey.REPORT_KEY_APPKEY, "0AND05J90ZOPH3DU");
                                                Utils.INSTANCE.currentBridgeModule().reportCustomDtEvent("dt_clck", eVar);
                                                return Unit.INSTANCE;
                                            }
                                        });
                                        final NBPHomepageProfileCard nBPHomepageProfileCard8 = NBPHomepageProfileCard.this;
                                        qActionSheetEvent2.register("onDismiss", new Function1<Object, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_homepage.view.NBPHomepageProfileCard.body.1.4.1.1.3
                                            {
                                                super(1);
                                            }

                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(Object obj) {
                                                com.tencent.kuikly.core.nvi.serialization.json.e eVar;
                                                NBPHomePageBaseViewModel nBPHomePageBaseViewModel = NBPHomepageProfileCard.access$getAttr(NBPHomepageProfileCard.this).viewModel;
                                                if (nBPHomePageBaseViewModel != null) {
                                                    eVar = nBPHomePageBaseViewModel.jsonWithHomePagePgParams();
                                                    NBPHomepageProfileCard nBPHomepageProfileCard9 = NBPHomepageProfileCard.this;
                                                    eVar.v("dt_eid", "em_nearbby_focus_cancel_float");
                                                    NBPHomePageBaseViewModel nBPHomePageBaseViewModel2 = NBPHomepageProfileCard.access$getAttr(nBPHomepageProfileCard9).viewModel;
                                                    eVar.v("cur_pg", nBPHomePageBaseViewModel2 != null ? nBPHomePageBaseViewModel2.jsonWithHomePagePgParams() : null);
                                                    eVar.t("nearby_btn_type", 0);
                                                } else {
                                                    eVar = new com.tencent.kuikly.core.nvi.serialization.json.e();
                                                }
                                                eVar.v(DTParamKey.REPORT_KEY_APPKEY, "0AND05J90ZOPH3DU");
                                                Utils.INSTANCE.currentBridgeModule().reportCustomDtEvent("dt_clck", eVar);
                                                r5.showUnfollowActionSheet$delegate.setValue(NBPHomepageProfileCard.this, NBPHomepageProfileCard.$$delegatedProperties[0], Boolean.valueOf(false));
                                                return Unit.INSTANCE;
                                            }
                                        });
                                        return Unit.INSTANCE;
                                    }
                                });
                                qActionSheetView2.addButton("\u53d6\u6d88\u5173\u6ce8");
                                qActionSheetView2.addCancelButton();
                                qActionSheetView2.show();
                                return Unit.INSTANCE;
                            }
                        });
                        NBPHomePageBaseViewModel nBPHomePageBaseViewModel = NBPHomepageProfileCard.access$getAttr(NBPHomepageProfileCard.this).viewModel;
                        if (nBPHomePageBaseViewModel != null) {
                            nBPHomePageBaseViewModel.homePageBaseReport("dt_imp", "em_nearbby_focus_cancel_float");
                        }
                        return Unit.INSTANCE;
                    }
                });
                final NBPHomepageProfileCard nBPHomepageProfileCard4 = NBPHomepageProfileCard.this;
                Function0<Object> function02 = new Function0<Object>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_homepage.view.NBPHomepageProfileCard$body$1.5
                    {
                        super(0);
                    }

                    /* JADX WARN: Removed duplicated region for block: B:13:0x0026  */
                    @Override // kotlin.jvm.functions.Function0
                    /*
                        Code decompiled incorrectly, please refer to instructions dump.
                    */
                    public final Object invoke() {
                        boolean z16;
                        s35.af userInfo;
                        String str;
                        NBPHomePageBaseViewModel nBPHomePageBaseViewModel = NBPHomepageProfileCard.access$getAttr(NBPHomepageProfileCard.this).viewModel;
                        boolean z17 = false;
                        if (nBPHomePageBaseViewModel != null && (userInfo = nBPHomePageBaseViewModel.getUserInfo()) != null && (str = userInfo.F) != null) {
                            if (str.length() == 0) {
                                z16 = true;
                                if (z16) {
                                    NBPHomePageBaseViewModel nBPHomePageBaseViewModel2 = NBPHomepageProfileCard.access$getAttr(NBPHomepageProfileCard.this).viewModel;
                                    if (nBPHomePageBaseViewModel2 != null && nBPHomePageBaseViewModel2.isSelf) {
                                        z17 = true;
                                    }
                                }
                                return Boolean.valueOf(z17);
                            }
                        }
                        z16 = false;
                        if (z16) {
                        }
                        return Boolean.valueOf(z17);
                    }
                };
                final NBPHomepageProfileCard nBPHomepageProfileCard5 = NBPHomepageProfileCard.this;
                ConditionViewKt.c(viewContainer2, function02, new Function1<ConditionView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_homepage.view.NBPHomepageProfileCard$body$1.6
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(ConditionView conditionView) {
                        final NBPHomepageProfileCard nBPHomepageProfileCard6 = NBPHomepageProfileCard.this;
                        w.a(conditionView, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_homepage.view.NBPHomepageProfileCard.body.1.6.1
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(v vVar) {
                                v vVar2 = vVar;
                                vVar2.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_homepage.view.NBPHomepageProfileCard.body.1.6.1.1
                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(t tVar) {
                                        t tVar2 = tVar;
                                        tVar2.flexDirectionRow();
                                        tVar2.marginTop(5.0f);
                                        tVar2.marginBottom(5.0f);
                                        tVar2.marginLeft(16.0f);
                                        tVar2.alignItemsCenter();
                                        return Unit.INSTANCE;
                                    }
                                });
                                final NBPHomepageProfileCard nBPHomepageProfileCard7 = NBPHomepageProfileCard.this;
                                vVar2.event(new Function1<u, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_homepage.view.NBPHomepageProfileCard.body.1.6.1.2
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(u uVar) {
                                        final NBPHomepageProfileCard nBPHomepageProfileCard8 = NBPHomepageProfileCard.this;
                                        uVar.click(new Function1<ClickParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_homepage.view.NBPHomepageProfileCard.body.1.6.1.2.1
                                            {
                                                super(1);
                                            }

                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(ClickParams clickParams) {
                                                String str;
                                                s35.af userInfo;
                                                if (!NBPHomepageProfileCard.this.fastClickUtils.isFastDoubleClick()) {
                                                    BridgeModule currentBridgeModule = Utils.INSTANCE.currentBridgeModule();
                                                    NBPHomePageBaseViewModel nBPHomePageBaseViewModel = NBPHomepageProfileCard.access$getAttr(NBPHomepageProfileCard.this).viewModel;
                                                    if (nBPHomePageBaseViewModel == null || (userInfo = nBPHomePageBaseViewModel.getUserInfo()) == null || (str = userInfo.F) == null) {
                                                        str = "";
                                                    }
                                                    String base64Code = currentBridgeModule.base64Code(str, true);
                                                    StringBuilder m3 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("mqqapi://kuikly/open?target=52&channel=2&version=1&src_type=app&page_name=nearby_manifesto_edit&appid=");
                                                    NBPHomePageBaseViewModel nBPHomePageBaseViewModel2 = NBPHomepageProfileCard.access$getAttr(NBPHomepageProfileCard.this).viewModel;
                                                    m3.append(nBPHomePageBaseViewModel2 != null ? Integer.valueOf(nBPHomePageBaseViewModel2.getAppId()) : null);
                                                    m3.append("&declaration=");
                                                    m3.append(base64Code);
                                                    m3.append("&custom_back_pressed=1&custom_back_pressed_ios=1");
                                                    String sb5 = m3.toString();
                                                    QQKuiklyPlatformApi.Companion companion = QQKuiklyPlatformApi.Companion;
                                                    QQKuiklyPlatformApi.Companion.openPage$default(sb5, false, 6);
                                                }
                                                return Unit.INSTANCE;
                                            }
                                        });
                                        return Unit.INSTANCE;
                                    }
                                });
                                cg.a(vVar2, new Function1<TextView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_homepage.view.NBPHomepageProfileCard.body.1.6.1.3
                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(TextView textView) {
                                        textView.attr(new Function1<ce, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_homepage.view.NBPHomepageProfileCard.body.1.6.1.3.1
                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(ce ceVar) {
                                                ce ceVar2 = ceVar;
                                                ceVar2.fontWeight400();
                                                ce.fontSize$default(ceVar2, 12.0f, null, 2, null);
                                                ceVar2.color(QUIToken.color$default("text_secondary"));
                                                ceVar2.text("\u586b\u5199\u4ea4\u53cb\u5ba3\u8a00");
                                                return Unit.INSTANCE;
                                            }
                                        });
                                        return Unit.INSTANCE;
                                    }
                                });
                                ah.a(vVar2, new Function1<ImageView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_homepage.view.NBPHomepageProfileCard.body.1.6.1.4
                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(ImageView imageView) {
                                        imageView.attr(new Function1<af, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_homepage.view.NBPHomepageProfileCard.body.1.6.1.4.1
                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(af afVar) {
                                                af afVar2 = afVar;
                                                afVar2.size(14.0f, 14.0f);
                                                afVar2.marginLeft(3.0f);
                                                b.a.b(afVar2, "https://image.superqqshow.qq.com/wuji/qq_lplan/lplan_pic_resouce/3c6784d9_9neOGptQ8ao.png", false, 2, null);
                                                afVar2.t(QUIToken.color$default("text_secondary"));
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
                final NBPHomepageProfileCard nBPHomepageProfileCard6 = NBPHomepageProfileCard.this;
                Function0<Object> function03 = new Function0<Object>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_homepage.view.NBPHomepageProfileCard$body$1.7
                    {
                        super(0);
                    }

                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        s35.af userInfo;
                        String str;
                        NBPHomePageBaseViewModel nBPHomePageBaseViewModel = NBPHomepageProfileCard.access$getAttr(NBPHomepageProfileCard.this).viewModel;
                        if (nBPHomePageBaseViewModel == null || (userInfo = nBPHomePageBaseViewModel.getUserInfo()) == null || (str = userInfo.F) == null) {
                            return null;
                        }
                        return Boolean.valueOf(str.length() > 0);
                    }
                };
                final NBPHomepageProfileCard nBPHomepageProfileCard7 = NBPHomepageProfileCard.this;
                ConditionViewKt.b(viewContainer2, function03, new Function1<ConditionView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_homepage.view.NBPHomepageProfileCard$body$1.8
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(ConditionView conditionView) {
                        final NBPHomepageProfileCard nBPHomepageProfileCard8 = NBPHomepageProfileCard.this;
                        cg.a(conditionView, new Function1<TextView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_homepage.view.NBPHomepageProfileCard.body.1.8.1
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(TextView textView) {
                                final NBPHomepageProfileCard nBPHomepageProfileCard9 = NBPHomepageProfileCard.this;
                                textView.attr(new Function1<ce, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_homepage.view.NBPHomepageProfileCard.body.1.8.1.1
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(ce ceVar) {
                                        s35.af userInfo;
                                        String str;
                                        ce ceVar2 = ceVar;
                                        ceVar2.marginLeft(16.0f);
                                        ceVar2.marginBottom(5.0f);
                                        ceVar2.fontWeight400();
                                        ce.fontSize$default(ceVar2, 12.0f, null, 2, null);
                                        ceVar2.color(QUIToken.color$default("text_secondary"));
                                        ceVar2.lines(4);
                                        ceVar2.mo153width(ceVar2.getPagerData().m() - 40.0f);
                                        ceVar2.marginTop(5.0f);
                                        NBPHomePageBaseViewModel nBPHomePageBaseViewModel = NBPHomepageProfileCard.access$getAttr(NBPHomepageProfileCard.this).viewModel;
                                        if (nBPHomePageBaseViewModel != null && (userInfo = nBPHomePageBaseViewModel.getUserInfo()) != null && (str = userInfo.F) != null) {
                                            ceVar2.text(str);
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
                final NBPHomepageProfileCard nBPHomepageProfileCard8 = NBPHomepageProfileCard.this;
                Function0<Object> function04 = new Function0<Object>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_homepage.view.NBPHomepageProfileCard$body$1.9
                    {
                        super(0);
                    }

                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        NBPHomePageBaseViewModel nBPHomePageBaseViewModel = NBPHomepageProfileCard.access$getAttr(NBPHomepageProfileCard.this).viewModel;
                        return Boolean.valueOf((nBPHomePageBaseViewModel != null ? nBPHomePageBaseViewModel.getUserInfo() : null) != null);
                    }
                };
                final NBPHomepageProfileCard nBPHomepageProfileCard9 = NBPHomepageProfileCard.this;
                ConditionViewKt.c(viewContainer2, function04, new Function1<ConditionView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_homepage.view.NBPHomepageProfileCard$body$1.10
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(ConditionView conditionView) {
                        final NBPHomepageProfileCard nBPHomepageProfileCard10 = NBPHomepageProfileCard.this;
                        conditionView.addChild(new NBPTagList(), new Function1<NBPTagList, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_homepage.view.NBPHomepageProfileCard.body.1.10.1
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(NBPTagList nBPTagList) {
                                final NBPHomepageProfileCard nBPHomepageProfileCard11 = NBPHomepageProfileCard.this;
                                nBPTagList.attr(new Function1<TagListAttr, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_homepage.view.NBPHomepageProfileCard.body.1.10.1.1
                                    {
                                        super(1);
                                    }

                                    /* JADX WARN: Code restructure failed: missing block: B:4:0x0020, code lost:
                                    
                                        if (r0.isSelf == true) goto L8;
                                     */
                                    @Override // kotlin.jvm.functions.Function1
                                    /*
                                        Code decompiled incorrectly, please refer to instructions dump.
                                    */
                                    public final Unit invoke(TagListAttr tagListAttr) {
                                        boolean z16;
                                        com.tencent.kuikly.core.reactive.collection.c<TagInfo> tagList;
                                        TagListAttr tagListAttr2 = tagListAttr;
                                        tagListAttr2.margin(0.0f, 10.0f, 0.0f, 10.0f);
                                        tagListAttr2.lastTagIMG = "https://image.superqqshow.qq.com/wuji/qq_lplan/lplan_pic_resouce/3c6784d9_WQAhgtyLgax.png";
                                        tagListAttr2.lastTagTex = "\u6dfb\u52a0\u6807\u7b7e";
                                        NBPHomePageBaseViewModel nBPHomePageBaseViewModel = NBPHomepageProfileCard.access$getAttr(NBPHomepageProfileCard.this).viewModel;
                                        if (nBPHomePageBaseViewModel != null) {
                                            z16 = true;
                                        }
                                        z16 = false;
                                        tagListAttr2.isSelf = z16;
                                        NBPHomePageBaseViewModel nBPHomePageBaseViewModel2 = NBPHomepageProfileCard.access$getAttr(NBPHomepageProfileCard.this).viewModel;
                                        if (nBPHomePageBaseViewModel2 != null && (tagList = nBPHomePageBaseViewModel2.getTagList()) != null) {
                                            tagListAttr2.tags$delegate.setValue(tagListAttr2, TagListAttr.$$delegatedProperties[0], tagList);
                                        }
                                        tagListAttr2.homePageViewModel = NBPHomepageProfileCard.access$getAttr(NBPHomepageProfileCard.this).viewModel;
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
        return new NBPHomepageProfileCardAttr();
    }

    @Override // com.tencent.kuikly.core.base.AbstractBaseView
    public final Event createEvent() {
        return new NBPHomepageProfileCardEvent();
    }
}

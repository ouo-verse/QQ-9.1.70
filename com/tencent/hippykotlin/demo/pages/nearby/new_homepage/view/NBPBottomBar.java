package com.tencent.hippykotlin.demo.pages.nearby.new_homepage.view;

import c01.c;
import com.tencent.hippykotlin.demo.pages.activity.blind_box.yifanshang.detail.view.YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.base.Utils;
import com.tencent.hippykotlin.demo.pages.foundation.qui_token.QUIToken;
import com.tencent.hippykotlin.demo.pages.nearby.base.NearbyConst;
import com.tencent.hippykotlin.demo.pages.nearby.base.module.QQNearbyModule;
import com.tencent.hippykotlin.demo.pages.nearby.new_homepage.view_model.NBPHomePageBaseViewModel;
import com.tencent.kuikly.core.base.Attr;
import com.tencent.kuikly.core.base.BorderStyle;
import com.tencent.kuikly.core.base.ComposeView;
import com.tencent.kuikly.core.base.Direction;
import com.tencent.kuikly.core.base.ViewContainer;
import com.tencent.kuikly.core.base.aa;
import com.tencent.kuikly.core.base.event.ClickParams;
import com.tencent.kuikly.core.base.event.Event;
import com.tencent.kuikly.core.base.event.TouchParams;
import com.tencent.kuikly.core.base.event.VisibilityEventKt;
import com.tencent.kuikly.core.base.h;
import com.tencent.kuikly.core.base.j;
import com.tencent.kuikly.core.base.m;
import com.tencent.kuikly.core.directives.ConditionView;
import com.tencent.kuikly.core.directives.ConditionViewKt;
import com.tencent.kuikly.core.log.KLog;
import com.tencent.kuikly.core.nvi.serialization.json.e;
import com.tencent.kuikly.core.views.TextView;
import com.tencent.kuikly.core.views.ce;
import com.tencent.kuikly.core.views.cg;
import com.tencent.kuikly.core.views.t;
import com.tencent.kuikly.core.views.u;
import com.tencent.kuikly.core.views.v;
import com.tencent.kuikly.core.views.w;
import com.tencent.mobileqq.profilecard.api.IProfileProtocolConst;
import com.tencent.qqlive.module.videoreport.dtreport.constants.DTParamKey;
import java.util.ArrayList;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.properties.ReadWriteProperty;
import kotlin.reflect.KProperty;
import org.apache.httpcore.message.TokenParser;

/* loaded from: classes31.dex */
public final class NBPBottomBar extends ComposeView<NBPBottomBarAttr, NBPBottomBarEvent> {
    public static final /* synthetic */ KProperty<Object>[] $$delegatedProperties = {YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0.m(NBPBottomBar.class, "greetingBtnHighlighted", "getGreetingBtnHighlighted()Z", 0), YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0.m(NBPBottomBar.class, "addFriendBtnHighlighted", "getAddFriendBtnHighlighted()Z", 0), YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0.m(NBPBottomBar.class, "editProfileBtnHighlighted", "getEditProfileBtnHighlighted()Z", 0), YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0.m(NBPBottomBar.class, IProfileProtocolConst.PARAM_IS_FRIEND, "isFriend()Ljava/lang/Boolean;", 0), YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0.m(NBPBottomBar.class, "greetingWidth", "getGreetingWidth()F", 0)};
    public final ReadWriteProperty addFriendBtnHighlighted$delegate;
    public aa<v> addFriendViewRef;
    public final ReadWriteProperty editProfileBtnHighlighted$delegate;
    public final ReadWriteProperty greetingBtnHighlighted$delegate;
    public aa<v> greetingBtnViewRef;
    public final ReadWriteProperty greetingWidth$delegate;
    public final ReadWriteProperty isFriend$delegate;
    public boolean isRequesting;
    public List<aa<v>> viewRefList = new ArrayList();

    public NBPBottomBar() {
        Boolean bool = Boolean.FALSE;
        this.greetingBtnHighlighted$delegate = c.a(bool);
        this.addFriendBtnHighlighted$delegate = c.a(bool);
        this.editProfileBtnHighlighted$delegate = c.a(bool);
        this.isFriend$delegate = c.a(null);
        this.greetingWidth$delegate = c.a(Float.valueOf(129.0f));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final void access$btnReport(NBPBottomBar nBPBottomBar, String str, String str2) {
        e eVar;
        NBPHomePageBaseViewModel nBPHomePageBaseViewModel = ((NBPBottomBarAttr) nBPBottomBar.getAttr()).viewModel;
        if (nBPHomePageBaseViewModel != null) {
            e jsonWithHomePagePgParams = nBPHomePageBaseViewModel.jsonWithHomePagePgParams();
            jsonWithHomePagePgParams.v("dt_eid", str2);
            NBPHomePageBaseViewModel nBPHomePageBaseViewModel2 = ((NBPBottomBarAttr) nBPBottomBar.getAttr()).viewModel;
            if (nBPHomePageBaseViewModel2 != null) {
                eVar = nBPHomePageBaseViewModel2.jsonWithHomePagePgParams();
            } else {
                eVar = new e();
            }
            jsonWithHomePagePgParams.v("cur_pg", eVar);
            jsonWithHomePagePgParams.v(DTParamKey.REPORT_KEY_APPKEY, "0AND05J90ZOPH3DU");
            Utils.INSTANCE.currentBridgeModule().reportCustomDtEvent(str, jsonWithHomePagePgParams);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final /* synthetic */ NBPBottomBarAttr access$getAttr(NBPBottomBar nBPBottomBar) {
        return (NBPBottomBarAttr) nBPBottomBar.getAttr();
    }

    @Override // com.tencent.kuikly.core.base.ComposeView
    public final Function1<ViewContainer<?, ?>, Unit> body() {
        return new Function1<ViewContainer<?, ?>, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_homepage.view.NBPBottomBar$body$1
            {
                super(1);
            }

            /* JADX WARN: Code restructure failed: missing block: B:4:0x0036, code lost:
            
                if (r0.isSelf == true) goto L8;
             */
            @Override // kotlin.jvm.functions.Function1
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public final Unit invoke(ViewContainer<?, ?> viewContainer) {
                ViewContainer<?, ?> viewContainer2 = viewContainer;
                viewContainer2.attr(new Function1<m, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_homepage.view.NBPBottomBar$body$1.1
                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(m mVar) {
                        m mVar2 = mVar;
                        mVar2.flexDirectionRow();
                        mVar2.mo141height(mVar2.getPagerData().getIsIOS() ? 109.0f : mVar2.getPagerData().getAndroidBottomBavBarHeight() > 30.0f ? 69.0f : 89.0f);
                        mVar2.justifyContentCenter();
                        return Unit.INSTANCE;
                    }
                });
                final NBPBottomBar nBPBottomBar = NBPBottomBar.this;
                Function0<Object> function0 = new Function0<Object>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_homepage.view.NBPBottomBar$body$1.2
                    {
                        super(0);
                    }

                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        NBPBottomBar nBPBottomBar2 = NBPBottomBar.this;
                        boolean z16 = false;
                        if (Intrinsics.areEqual((Boolean) nBPBottomBar2.isFriend$delegate.getValue(nBPBottomBar2, NBPBottomBar.$$delegatedProperties[3]), Boolean.FALSE)) {
                            NBPHomePageBaseViewModel nBPHomePageBaseViewModel = NBPBottomBar.access$getAttr(NBPBottomBar.this).viewModel;
                            if ((nBPHomePageBaseViewModel == null || nBPHomePageBaseViewModel.isSelf) ? false : true) {
                                z16 = true;
                            }
                        }
                        return Boolean.valueOf(z16);
                    }
                };
                final NBPBottomBar nBPBottomBar2 = NBPBottomBar.this;
                ConditionViewKt.c(viewContainer2, function0, new Function1<ConditionView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_homepage.view.NBPBottomBar$body$1.3
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(ConditionView conditionView) {
                        final NBPBottomBar nBPBottomBar3 = NBPBottomBar.this;
                        w.a(conditionView, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_homepage.view.NBPBottomBar.body.1.3.1
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(v vVar) {
                                v vVar2 = vVar;
                                final NBPBottomBar nBPBottomBar4 = NBPBottomBar.this;
                                vVar2.ref(vVar2, new Function1<aa<v>, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_homepage.view.NBPBottomBar.body.1.3.1.1
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(aa<v> aaVar) {
                                        NBPBottomBar.this.addFriendViewRef = aaVar;
                                        return Unit.INSTANCE;
                                    }
                                });
                                vVar2.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_homepage.view.NBPBottomBar.body.1.3.1.2
                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(t tVar) {
                                        t tVar2 = tVar;
                                        tVar2.flexDirectionRow();
                                        tVar2.allCenter();
                                        tVar2.marginRight(20.0f);
                                        tVar2.marginTop(15.0f);
                                        tVar2.size(129.0f, 45.0f);
                                        tVar2.borderRadius(4.0f);
                                        tVar2.m136border(new com.tencent.kuikly.core.base.e(1.0f, BorderStyle.SOLID, new h(13421772L, 1.0f)));
                                        tVar2.mo113backgroundColor(QUIToken.color$default("button_bg_secondary_default"));
                                        return Unit.INSTANCE;
                                    }
                                });
                                final NBPBottomBar nBPBottomBar5 = NBPBottomBar.this;
                                vVar2.event(new Function1<u, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_homepage.view.NBPBottomBar.body.1.3.1.3
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(u uVar) {
                                        u uVar2 = uVar;
                                        final NBPBottomBar nBPBottomBar6 = NBPBottomBar.this;
                                        uVar2.click(new Function1<ClickParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_homepage.view.NBPBottomBar.body.1.3.1.3.1

                                            /* renamed from: com.tencent.hippykotlin.demo.pages.nearby.new_homepage.view.NBPBottomBar$body$1$3$1$3$1$1, reason: invalid class name and collision with other inner class name */
                                            /* loaded from: classes31.dex */
                                            public final class C33821 extends Lambda implements Function0<Unit> {
                                                public final /* synthetic */ NBPBottomBar $ctx;

                                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                public C33821(NBPBottomBar nBPBottomBar) {
                                                    super(0);
                                                    this.$ctx = nBPBottomBar;
                                                }

                                                @Override // kotlin.jvm.functions.Function0
                                                public final Unit invoke() {
                                                    this.$ctx.isRequesting = false;
                                                    return Unit.INSTANCE;
                                                }
                                            }

                                            {
                                                super(1);
                                            }

                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(ClickParams clickParams) {
                                                NBPBottomBar nBPBottomBar7 = NBPBottomBar.this;
                                                if (!nBPBottomBar7.isRequesting) {
                                                    nBPBottomBar7.isRequesting = true;
                                                    NBPHomePageBaseViewModel nBPHomePageBaseViewModel = NBPBottomBar.access$getAttr(nBPBottomBar7).viewModel;
                                                    if (nBPHomePageBaseViewModel != null) {
                                                        C33821 c33821 = new C33821(NBPBottomBar.this);
                                                        final NBPBottomBar nBPBottomBar8 = NBPBottomBar.this;
                                                        nBPHomePageBaseViewModel.addFriend(c33821, new Function0<Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_homepage.view.NBPBottomBar.body.1.3.1.3.1.2
                                                            {
                                                                super(0);
                                                            }

                                                            @Override // kotlin.jvm.functions.Function0
                                                            public final Unit invoke() {
                                                                NBPBottomBar.this.isRequesting = false;
                                                                return Unit.INSTANCE;
                                                            }
                                                        });
                                                    }
                                                    NBPBottomBar.access$btnReport(NBPBottomBar.this, "dt_clck", "em_add_fri_btn");
                                                }
                                                return Unit.INSTANCE;
                                            }
                                        });
                                        final NBPBottomBar nBPBottomBar7 = NBPBottomBar.this;
                                        uVar2.touchDown(new Function1<TouchParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_homepage.view.NBPBottomBar.body.1.3.1.3.2
                                            {
                                                super(1);
                                            }

                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(TouchParams touchParams) {
                                                NBPBottomBar nBPBottomBar8 = NBPBottomBar.this;
                                                nBPBottomBar8.addFriendBtnHighlighted$delegate.setValue(nBPBottomBar8, NBPBottomBar.$$delegatedProperties[1], Boolean.TRUE);
                                                return Unit.INSTANCE;
                                            }
                                        });
                                        final NBPBottomBar nBPBottomBar8 = NBPBottomBar.this;
                                        uVar2.touchUp(new Function1<TouchParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_homepage.view.NBPBottomBar.body.1.3.1.3.3
                                            {
                                                super(1);
                                            }

                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(TouchParams touchParams) {
                                                NBPBottomBar nBPBottomBar9 = NBPBottomBar.this;
                                                nBPBottomBar9.addFriendBtnHighlighted$delegate.setValue(nBPBottomBar9, NBPBottomBar.$$delegatedProperties[1], Boolean.FALSE);
                                                return Unit.INSTANCE;
                                            }
                                        });
                                        final NBPBottomBar nBPBottomBar9 = NBPBottomBar.this;
                                        VisibilityEventKt.b(uVar2, new Function1<Object, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_homepage.view.NBPBottomBar.body.1.3.1.3.4
                                            {
                                                super(1);
                                            }

                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(Object obj) {
                                                NBPBottomBar.access$btnReport(NBPBottomBar.this, "dt_imp", "em_add_fri_btn");
                                                return Unit.INSTANCE;
                                            }
                                        });
                                        return Unit.INSTANCE;
                                    }
                                });
                                final NBPBottomBar nBPBottomBar6 = NBPBottomBar.this;
                                w.a(vVar2, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_homepage.view.NBPBottomBar.body.1.3.1.4
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(v vVar3) {
                                        final NBPBottomBar nBPBottomBar7 = NBPBottomBar.this;
                                        vVar3.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_homepage.view.NBPBottomBar.body.1.3.1.4.1
                                            {
                                                super(1);
                                            }

                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(t tVar) {
                                                t tVar2 = tVar;
                                                tVar2.mo113backgroundColor(new h(0, 0, 0, 0.1f));
                                                NBPBottomBar nBPBottomBar8 = NBPBottomBar.this;
                                                tVar2.m152visibility(((Boolean) nBPBottomBar8.addFriendBtnHighlighted$delegate.getValue(nBPBottomBar8, NBPBottomBar.$$delegatedProperties[1])).booleanValue());
                                                tVar2.absolutePositionAllZero();
                                                return Unit.INSTANCE;
                                            }
                                        });
                                        return Unit.INSTANCE;
                                    }
                                });
                                cg.a(vVar2, new Function1<TextView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_homepage.view.NBPBottomBar.body.1.3.1.5
                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(TextView textView) {
                                        textView.attr(new Function1<ce, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_homepage.view.NBPBottomBar.body.1.3.1.5.1
                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(ce ceVar) {
                                                ce ceVar2 = ceVar;
                                                ceVar2.text("\u52a0\u597d\u53cb");
                                                ce.fontSize$default(ceVar2, 17.0f, null, 2, null);
                                                ceVar2.fontWeightBold();
                                                ceVar2.color(QUIToken.color$default("text_primary"));
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
                final NBPBottomBar nBPBottomBar3 = NBPBottomBar.this;
                Function0<Object> function02 = new Function0<Object>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_homepage.view.NBPBottomBar$body$1.4
                    {
                        super(0);
                    }

                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        NBPBottomBar nBPBottomBar4 = NBPBottomBar.this;
                        boolean z16 = false;
                        if (((Boolean) nBPBottomBar4.isFriend$delegate.getValue(nBPBottomBar4, NBPBottomBar.$$delegatedProperties[3])) != null) {
                            NBPHomePageBaseViewModel nBPHomePageBaseViewModel = NBPBottomBar.access$getAttr(NBPBottomBar.this).viewModel;
                            if ((nBPHomePageBaseViewModel == null || nBPHomePageBaseViewModel.isSelf) ? false : true) {
                                z16 = true;
                            }
                        }
                        return Boolean.valueOf(z16);
                    }
                };
                final NBPBottomBar nBPBottomBar4 = NBPBottomBar.this;
                ConditionViewKt.c(viewContainer2, function02, new Function1<ConditionView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_homepage.view.NBPBottomBar$body$1.5
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(ConditionView conditionView) {
                        final NBPBottomBar nBPBottomBar5 = NBPBottomBar.this;
                        w.a(conditionView, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_homepage.view.NBPBottomBar.body.1.5.1
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(v vVar) {
                                v vVar2 = vVar;
                                final NBPBottomBar nBPBottomBar6 = NBPBottomBar.this;
                                vVar2.ref(vVar2, new Function1<aa<v>, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_homepage.view.NBPBottomBar.body.1.5.1.1
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(aa<v> aaVar) {
                                        NBPBottomBar.this.greetingBtnViewRef = aaVar;
                                        return Unit.INSTANCE;
                                    }
                                });
                                final NBPBottomBar nBPBottomBar7 = NBPBottomBar.this;
                                vVar2.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_homepage.view.NBPBottomBar.body.1.5.1.2
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(t tVar) {
                                        t tVar2 = tVar;
                                        tVar2.flexDirectionRow();
                                        tVar2.allCenter();
                                        tVar2.marginTop(15.0f);
                                        NBPBottomBar nBPBottomBar8 = NBPBottomBar.this;
                                        tVar2.size(((Number) nBPBottomBar8.greetingWidth$delegate.getValue(nBPBottomBar8, NBPBottomBar.$$delegatedProperties[4])).floatValue(), 45.0f);
                                        tVar2.mo135backgroundLinearGradient(Direction.TO_BOTTOM_RIGHT, new j(new h(7297023L, 1.0f), 0.0f), new j(new h(13330943L, 1.0f), 1.0f));
                                        tVar2.borderRadius(4.0f);
                                        return Unit.INSTANCE;
                                    }
                                });
                                final NBPBottomBar nBPBottomBar8 = NBPBottomBar.this;
                                vVar2.event(new Function1<u, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_homepage.view.NBPBottomBar.body.1.5.1.3
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(u uVar) {
                                        final u uVar2 = uVar;
                                        final NBPBottomBar nBPBottomBar9 = NBPBottomBar.this;
                                        uVar2.click(new Function1<ClickParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_homepage.view.NBPBottomBar.body.1.5.1.3.1
                                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                            {
                                                super(1);
                                            }

                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(ClickParams clickParams) {
                                                NBPHomePageBaseViewModel nBPHomePageBaseViewModel = NBPBottomBar.access$getAttr(NBPBottomBar.this).viewModel;
                                                if (nBPHomePageBaseViewModel != null) {
                                                    nBPHomePageBaseViewModel.openAio(uVar2.getPager().getPageData().n(), 0);
                                                }
                                                NBPBottomBar.access$btnReport(NBPBottomBar.this, "dt_clck", "em_say_hi_btn");
                                                return Unit.INSTANCE;
                                            }
                                        });
                                        final NBPBottomBar nBPBottomBar10 = NBPBottomBar.this;
                                        uVar2.touchDown(new Function1<TouchParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_homepage.view.NBPBottomBar.body.1.5.1.3.2
                                            {
                                                super(1);
                                            }

                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(TouchParams touchParams) {
                                                NBPBottomBar nBPBottomBar11 = NBPBottomBar.this;
                                                nBPBottomBar11.greetingBtnHighlighted$delegate.setValue(nBPBottomBar11, NBPBottomBar.$$delegatedProperties[0], Boolean.TRUE);
                                                return Unit.INSTANCE;
                                            }
                                        });
                                        final NBPBottomBar nBPBottomBar11 = NBPBottomBar.this;
                                        uVar2.touchUp(new Function1<TouchParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_homepage.view.NBPBottomBar.body.1.5.1.3.3
                                            {
                                                super(1);
                                            }

                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(TouchParams touchParams) {
                                                NBPBottomBar nBPBottomBar12 = NBPBottomBar.this;
                                                nBPBottomBar12.greetingBtnHighlighted$delegate.setValue(nBPBottomBar12, NBPBottomBar.$$delegatedProperties[0], Boolean.FALSE);
                                                return Unit.INSTANCE;
                                            }
                                        });
                                        final NBPBottomBar nBPBottomBar12 = NBPBottomBar.this;
                                        VisibilityEventKt.b(uVar2, new Function1<Object, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_homepage.view.NBPBottomBar.body.1.5.1.3.4
                                            {
                                                super(1);
                                            }

                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(Object obj) {
                                                NBPBottomBar.access$btnReport(NBPBottomBar.this, "dt_imp", "em_say_hi_btn");
                                                return Unit.INSTANCE;
                                            }
                                        });
                                        return Unit.INSTANCE;
                                    }
                                });
                                final NBPBottomBar nBPBottomBar9 = NBPBottomBar.this;
                                w.a(vVar2, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_homepage.view.NBPBottomBar.body.1.5.1.4
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(v vVar3) {
                                        final NBPBottomBar nBPBottomBar10 = NBPBottomBar.this;
                                        vVar3.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_homepage.view.NBPBottomBar.body.1.5.1.4.1
                                            {
                                                super(1);
                                            }

                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(t tVar) {
                                                t tVar2 = tVar;
                                                tVar2.mo113backgroundColor(new h(0, 0, 0, 0.1f));
                                                NBPBottomBar nBPBottomBar11 = NBPBottomBar.this;
                                                tVar2.m152visibility(((Boolean) nBPBottomBar11.greetingBtnHighlighted$delegate.getValue(nBPBottomBar11, NBPBottomBar.$$delegatedProperties[0])).booleanValue());
                                                tVar2.absolutePositionAllZero();
                                                return Unit.INSTANCE;
                                            }
                                        });
                                        return Unit.INSTANCE;
                                    }
                                });
                                cg.a(vVar2, new Function1<TextView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_homepage.view.NBPBottomBar.body.1.5.1.5
                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(TextView textView) {
                                        textView.attr(new Function1<ce, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_homepage.view.NBPBottomBar.body.1.5.1.5.1
                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(ce ceVar) {
                                                ce ceVar2 = ceVar;
                                                ceVar2.text("\u6253\u62db\u547c");
                                                ce.fontSize$default(ceVar2, 17.0f, null, 2, null);
                                                ceVar2.fontWeightBold();
                                                ceVar2.color(h.INSTANCE.m());
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
                NBPHomePageBaseViewModel nBPHomePageBaseViewModel = NBPBottomBar.access$getAttr(NBPBottomBar.this).viewModel;
                boolean z16 = nBPHomePageBaseViewModel != null;
                if (z16) {
                    final NBPBottomBar nBPBottomBar5 = NBPBottomBar.this;
                    w.a(viewContainer2, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_homepage.view.NBPBottomBar$body$1.6
                        {
                            super(1);
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public final Unit invoke(v vVar) {
                            v vVar2 = vVar;
                            final NBPBottomBar nBPBottomBar6 = NBPBottomBar.this;
                            vVar2.ref(vVar2, new Function1<aa<v>, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_homepage.view.NBPBottomBar.body.1.6.1
                                {
                                    super(1);
                                }

                                @Override // kotlin.jvm.functions.Function1
                                public final Unit invoke(aa<v> aaVar) {
                                    NBPBottomBar nBPBottomBar7 = NBPBottomBar.this;
                                    KProperty<Object>[] kPropertyArr = NBPBottomBar.$$delegatedProperties;
                                    nBPBottomBar7.getClass();
                                    return Unit.INSTANCE;
                                }
                            });
                            vVar2.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_homepage.view.NBPBottomBar.body.1.6.2
                                @Override // kotlin.jvm.functions.Function1
                                public final Unit invoke(t tVar) {
                                    t tVar2 = tVar;
                                    tVar2.flexDirectionRow();
                                    tVar2.allCenter();
                                    tVar2.marginTop(15.0f);
                                    tVar2.size(330.0f, 45.0f);
                                    tVar2.mo135backgroundLinearGradient(Direction.TO_BOTTOM_RIGHT, new j(new h(7297023L, 1.0f), 0.0f), new j(new h(13330943L, 1.0f), 1.0f));
                                    tVar2.borderRadius(4.0f);
                                    return Unit.INSTANCE;
                                }
                            });
                            final NBPBottomBar nBPBottomBar7 = NBPBottomBar.this;
                            vVar2.event(new Function1<u, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_homepage.view.NBPBottomBar.body.1.6.3
                                {
                                    super(1);
                                }

                                @Override // kotlin.jvm.functions.Function1
                                public final Unit invoke(u uVar) {
                                    u uVar2 = uVar;
                                    final NBPBottomBar nBPBottomBar8 = NBPBottomBar.this;
                                    uVar2.click(new Function1<ClickParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_homepage.view.NBPBottomBar.body.1.6.3.1
                                        {
                                            super(1);
                                        }

                                        @Override // kotlin.jvm.functions.Function1
                                        public final Unit invoke(ClickParams clickParams) {
                                            NBPHomePageBaseViewModel nBPHomePageBaseViewModel2 = NBPBottomBar.access$getAttr(NBPBottomBar.this).viewModel;
                                            if (nBPHomePageBaseViewModel2 != null) {
                                                nBPHomePageBaseViewModel2.openEditPage();
                                            }
                                            return Unit.INSTANCE;
                                        }
                                    });
                                    final NBPBottomBar nBPBottomBar9 = NBPBottomBar.this;
                                    uVar2.touchDown(new Function1<TouchParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_homepage.view.NBPBottomBar.body.1.6.3.2
                                        {
                                            super(1);
                                        }

                                        @Override // kotlin.jvm.functions.Function1
                                        public final Unit invoke(TouchParams touchParams) {
                                            NBPBottomBar nBPBottomBar10 = NBPBottomBar.this;
                                            nBPBottomBar10.editProfileBtnHighlighted$delegate.setValue(nBPBottomBar10, NBPBottomBar.$$delegatedProperties[2], Boolean.TRUE);
                                            return Unit.INSTANCE;
                                        }
                                    });
                                    final NBPBottomBar nBPBottomBar10 = NBPBottomBar.this;
                                    uVar2.touchUp(new Function1<TouchParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_homepage.view.NBPBottomBar.body.1.6.3.3
                                        {
                                            super(1);
                                        }

                                        @Override // kotlin.jvm.functions.Function1
                                        public final Unit invoke(TouchParams touchParams) {
                                            NBPBottomBar nBPBottomBar11 = NBPBottomBar.this;
                                            nBPBottomBar11.editProfileBtnHighlighted$delegate.setValue(nBPBottomBar11, NBPBottomBar.$$delegatedProperties[2], Boolean.FALSE);
                                            return Unit.INSTANCE;
                                        }
                                    });
                                    return Unit.INSTANCE;
                                }
                            });
                            final NBPBottomBar nBPBottomBar8 = NBPBottomBar.this;
                            w.a(vVar2, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_homepage.view.NBPBottomBar.body.1.6.4
                                {
                                    super(1);
                                }

                                @Override // kotlin.jvm.functions.Function1
                                public final Unit invoke(v vVar3) {
                                    final NBPBottomBar nBPBottomBar9 = NBPBottomBar.this;
                                    vVar3.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_homepage.view.NBPBottomBar.body.1.6.4.1
                                        {
                                            super(1);
                                        }

                                        @Override // kotlin.jvm.functions.Function1
                                        public final Unit invoke(t tVar) {
                                            t tVar2 = tVar;
                                            tVar2.mo113backgroundColor(new h(0, 0, 0, 0.1f));
                                            NBPBottomBar nBPBottomBar10 = NBPBottomBar.this;
                                            tVar2.m152visibility(((Boolean) nBPBottomBar10.editProfileBtnHighlighted$delegate.getValue(nBPBottomBar10, NBPBottomBar.$$delegatedProperties[2])).booleanValue());
                                            tVar2.absolutePositionAllZero();
                                            return Unit.INSTANCE;
                                        }
                                    });
                                    return Unit.INSTANCE;
                                }
                            });
                            cg.a(vVar2, new Function1<TextView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_homepage.view.NBPBottomBar.body.1.6.5
                                @Override // kotlin.jvm.functions.Function1
                                public final Unit invoke(TextView textView) {
                                    textView.attr(new Function1<ce, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_homepage.view.NBPBottomBar.body.1.6.5.1
                                        @Override // kotlin.jvm.functions.Function1
                                        public final Unit invoke(ce ceVar) {
                                            ce ceVar2 = ceVar;
                                            ceVar2.text("\u7f16\u8f91\u8d44\u6599");
                                            ce.fontSize$default(ceVar2, 17.0f, null, 2, null);
                                            ceVar2.fontWeightBold();
                                            ceVar2.color(h.INSTANCE.m());
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
        };
    }

    @Override // com.tencent.kuikly.core.base.AbstractBaseView
    public final Attr createAttr() {
        return new NBPBottomBarAttr();
    }

    @Override // com.tencent.kuikly.core.base.AbstractBaseView
    public final Event createEvent() {
        return new NBPBottomBarEvent();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.tencent.kuikly.core.base.ComposeView
    public final void created() {
        super.created();
        QQNearbyModule companion = QQNearbyModule.Companion.getInstance();
        int i3 = ((NBPBottomBarAttr) getAttr()).appId;
        String str = ((NBPBottomBarAttr) getAttr()).tinyId;
        final Function1<e, Unit> function1 = new Function1<e, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_homepage.view.NBPBottomBar$created$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Unit invoke(e eVar) {
                e eVar2 = eVar;
                Boolean valueOf = eVar2 != null ? Boolean.valueOf(eVar2.g(IProfileProtocolConst.PARAM_IS_FRIEND, false)) : null;
                NBPBottomBar nBPBottomBar = NBPBottomBar.this;
                Boolean bool = Boolean.TRUE;
                Boolean valueOf2 = Boolean.valueOf(Intrinsics.areEqual(valueOf, bool));
                ReadWriteProperty readWriteProperty = nBPBottomBar.isFriend$delegate;
                KProperty<?>[] kPropertyArr = NBPBottomBar.$$delegatedProperties;
                readWriteProperty.setValue(nBPBottomBar, kPropertyArr[3], valueOf2);
                if (Intrinsics.areEqual(valueOf, bool)) {
                    NBPBottomBar nBPBottomBar2 = NBPBottomBar.this;
                    nBPBottomBar2.greetingWidth$delegate.setValue(nBPBottomBar2, kPropertyArr[4], Float.valueOf(330.0f));
                }
                return Unit.INSTANCE;
            }
        };
        companion.getClass();
        KLog kLog = KLog.INSTANCE;
        NearbyConst nearbyConst = NearbyConst.INSTANCE;
        kLog.i("personal_detail_page", "checkIsFriend " + str + TokenParser.SP);
        companion.syncToNativeMethod("checkIsFriend", new Object[]{Integer.valueOf(i3), str}, new Function1<Object, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.base.module.QQNearbyModule$checkIsFriend$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Unit invoke(Object obj) {
                String str2 = obj instanceof String ? (String) obj : null;
                if (str2 == null) {
                    str2 = "{}";
                }
                e eVar = new e(str2);
                Function1<e, Unit> function12 = function1;
                if (function12 != null) {
                    function12.invoke(eVar);
                }
                return Unit.INSTANCE;
            }
        });
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [java.util.List<com.tencent.kuikly.core.base.aa<com.tencent.kuikly.core.views.v>>, java.util.ArrayList] */
    /* JADX WARN: Type inference failed for: r0v1, types: [java.util.List<com.tencent.kuikly.core.base.aa<com.tencent.kuikly.core.views.v>>, java.util.ArrayList] */
    @Override // com.tencent.kuikly.core.base.ComposeView
    public final void viewDidLoad() {
        super.viewDidLoad();
        this.viewRefList.add(this.addFriendViewRef);
        this.viewRefList.add(this.greetingBtnViewRef);
    }
}

package com.tencent.hippykotlin.demo.pages.jubao;

import c01.c;
import com.tencent.hippykotlin.demo.pages.activity.blind_box.yifanshang.detail.view.YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.foundation.module.QQKuiklyBundleModule;
import com.tencent.hippykotlin.demo.pages.foundation.qui_token.QUIToken;
import com.tencent.hippykotlin.demo.pages.vas_base.misc.VasUIToken;
import com.tencent.kuikly.core.base.Attr;
import com.tencent.kuikly.core.base.ComposeView;
import com.tencent.kuikly.core.base.ViewContainer;
import com.tencent.kuikly.core.base.attr.AccessibilityRole;
import com.tencent.kuikly.core.base.attr.b;
import com.tencent.kuikly.core.base.event.ClickParams;
import com.tencent.kuikly.core.base.event.Event;
import com.tencent.kuikly.core.base.h;
import com.tencent.kuikly.core.base.k;
import com.tencent.kuikly.core.base.l;
import com.tencent.kuikly.core.base.m;
import com.tencent.kuikly.core.directives.ConditionView;
import com.tencent.kuikly.core.directives.ConditionViewKt;
import com.tencent.kuikly.core.layout.FlexDirection;
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
import com.tencent.mobileqq.shortvideo.gesture.DownloadInfo;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.properties.ReadWriteProperty;
import kotlin.reflect.KProperty;

/* compiled from: P */
/* loaded from: classes31.dex */
public final class JubaoNavBar extends ComposeView<k, l> {
    public static final /* synthetic */ KProperty<Object>[] $$delegatedProperties = {YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0.m(JubaoNavBar.class, "navBarData", "getNavBarData()Lcom/tencent/hippykotlin/demo/pages/jubao/NavBarData;", 0)};
    public Function0<Unit> backClickCallback;
    public final ReadWriteProperty navBarData$delegate = c.a(new NavBarData("", true));

    public static final NavBarData access$getNavBarData(JubaoNavBar jubaoNavBar) {
        return (NavBarData) jubaoNavBar.navBarData$delegate.getValue(jubaoNavBar, $$delegatedProperties[0]);
    }

    @Override // com.tencent.kuikly.core.base.ComposeView
    public final Function1<ViewContainer<?, ?>, Unit> body() {
        return new Function1<ViewContainer<?, ?>, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.jubao.JubaoNavBar$body$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Unit invoke(ViewContainer<?, ?> viewContainer) {
                ViewContainer<?, ?> viewContainer2 = viewContainer;
                viewContainer2.attr(new Function1<m, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.jubao.JubaoNavBar$body$1.1
                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(m mVar) {
                        m mVar2 = mVar;
                        mVar2.flexDirectionRow();
                        mVar2.mo141height(44.0f);
                        mVar2.allCenter();
                        mVar2.marginTop(6.0f);
                        return Unit.INSTANCE;
                    }
                });
                final JubaoNavBar jubaoNavBar = JubaoNavBar.this;
                cg.a(viewContainer2, new Function1<TextView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.jubao.JubaoNavBar$body$1.2
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(TextView textView) {
                        final JubaoNavBar jubaoNavBar2 = JubaoNavBar.this;
                        textView.attr(new Function1<ce, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.jubao.JubaoNavBar.body.1.2.1
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(ce ceVar) {
                                ce ceVar2 = ceVar;
                                ceVar2.text(JubaoNavBar.access$getNavBarData(JubaoNavBar.this).title);
                                ce.fontSize$default(ceVar2, 17.0f, null, 2, null);
                                ceVar2.color(JubaoThemeData.INSTANCE.getNavTitleTextColor());
                                ceVar2.fontWeight500();
                                return Unit.INSTANCE;
                            }
                        });
                        return Unit.INSTANCE;
                    }
                });
                final JubaoNavBar jubaoNavBar2 = JubaoNavBar.this;
                Function0<Object> function0 = new Function0<Object>() { // from class: com.tencent.hippykotlin.demo.pages.jubao.JubaoNavBar$body$1.3
                    {
                        super(0);
                    }

                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return Boolean.valueOf(JubaoNavBar.access$getNavBarData(JubaoNavBar.this).showCloseIcon);
                    }
                };
                final JubaoNavBar jubaoNavBar3 = JubaoNavBar.this;
                ConditionViewKt.c(viewContainer2, function0, new Function1<ConditionView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.jubao.JubaoNavBar$body$1.4
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(ConditionView conditionView) {
                        final JubaoNavBar jubaoNavBar4 = JubaoNavBar.this;
                        w.a(conditionView, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.jubao.JubaoNavBar.body.1.4.1
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(v vVar) {
                                v vVar2 = vVar;
                                vVar2.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.jubao.JubaoNavBar.body.1.4.1.1
                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(t tVar) {
                                        t tVar2 = tVar;
                                        tVar2.absolutePositionAllZero();
                                        tVar2.flexDirection(FlexDirection.ROW_REVERSE);
                                        return Unit.INSTANCE;
                                    }
                                });
                                final JubaoNavBar jubaoNavBar5 = JubaoNavBar.this;
                                ah.a(vVar2, new Function1<ImageView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.jubao.JubaoNavBar.body.1.4.1.2
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(ImageView imageView) {
                                        ImageView imageView2 = imageView;
                                        imageView2.attr(new Function1<af, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.jubao.JubaoNavBar.body.1.4.1.2.1
                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(af afVar) {
                                                af afVar2 = afVar;
                                                afVar2.size(30.0f, 30.0f);
                                                b.a.b(afVar2, "data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAADwAAAA8BAMAAADI0sRBAAAAFVBMVEUAAAAAAAAAAAAAAAAAAAAAAAAAAAASAQCkAAAAB3RSTlMJAGwvBGZgHXOPCgAAAQJJREFUOMuFlcENgzAQBC9KwjtIVGAasFIBdMArbz7pv4VYF+RxwsHuCzHseYHz2Xo0TFZ0m3vUYIf+QIAHazSDoTsOtj+Bf9ZlfTCl0dxgCwR+RPhSsYVygjmyG7Gj8EbsKLxRO6pu1N6rYGpH1Y3aUXWjdpC9YDtRg6+vXC/ANVmXRnM901KzWU12Tym7OaW1ZgOX2+PXnDKY4H7fnyI62AHmDSMnmFFjx4waO+bQjjmyYxZYFdfR9ItNp59FfFTxS8QPBXe0wwIearfQTCvNRCu+MxebRCOLbSA2kd6CJ4uL7S+Ghxw9enAdhRNDU4xcPbD1uI+5Omr0QaWPOXFIfgBKJTWdEKTU2AAAAABJRU5ErkJggg==", false, 2, null);
                                                afVar2.marginRight(16.0f);
                                                afVar2.alignSelfCenter();
                                                return Unit.INSTANCE;
                                            }
                                        });
                                        final JubaoNavBar jubaoNavBar6 = JubaoNavBar.this;
                                        imageView2.event(new Function1<ImageEvent, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.jubao.JubaoNavBar.body.1.4.1.2.2
                                            {
                                                super(1);
                                            }

                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(ImageEvent imageEvent) {
                                                final JubaoNavBar jubaoNavBar7 = JubaoNavBar.this;
                                                imageEvent.click(new Function1<ClickParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.jubao.JubaoNavBar.body.1.4.1.2.2.1
                                                    {
                                                        super(1);
                                                    }

                                                    @Override // kotlin.jvm.functions.Function1
                                                    public final Unit invoke(ClickParams clickParams) {
                                                        Function0<Unit> function02 = JubaoNavBar.this.backClickCallback;
                                                        if (function02 != null) {
                                                            function02.invoke();
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
                final JubaoNavBar jubaoNavBar4 = JubaoNavBar.this;
                Function0<Object> function02 = new Function0<Object>() { // from class: com.tencent.hippykotlin.demo.pages.jubao.JubaoNavBar$body$1.5
                    {
                        super(0);
                    }

                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return Boolean.valueOf(JubaoNavBar.access$getNavBarData(JubaoNavBar.this).showBackIcon);
                    }
                };
                final JubaoNavBar jubaoNavBar5 = JubaoNavBar.this;
                ConditionViewKt.c(viewContainer2, function02, new Function1<ConditionView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.jubao.JubaoNavBar$body$1.6
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(ConditionView conditionView) {
                        final JubaoNavBar jubaoNavBar6 = JubaoNavBar.this;
                        w.a(conditionView, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.jubao.JubaoNavBar.body.1.6.1
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(v vVar) {
                                v vVar2 = vVar;
                                vVar2.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.jubao.JubaoNavBar.body.1.6.1.1
                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(t tVar) {
                                        t tVar2 = tVar;
                                        tVar2.positionAbsolute();
                                        tVar2.m150top(0.0f);
                                        tVar2.m138bottom(0.0f);
                                        tVar2.mo153width(56.0f);
                                        tVar2.allCenter();
                                        tVar2.accessibility("\u8fd4\u56de");
                                        tVar2.accessibilityRole(AccessibilityRole.BUTTON);
                                        return Unit.INSTANCE;
                                    }
                                });
                                ah.a(vVar2, new Function1<ImageView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.jubao.JubaoNavBar.body.1.6.1.2
                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(ImageView imageView) {
                                        imageView.attr(new Function1<af, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.jubao.JubaoNavBar.body.1.6.1.2.1
                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(af afVar) {
                                                h hVar;
                                                af afVar2 = afVar;
                                                afVar2.mo153width(24.0f);
                                                afVar2.mo141height(24.0f);
                                                QUIToken qUIToken = QUIToken.INSTANCE;
                                                JubaoThemeData jubaoThemeData = JubaoThemeData.INSTANCE;
                                                if (!VasUIToken.INSTANCE.isDarkMode()) {
                                                    hVar = new h(4281282611L);
                                                } else {
                                                    hVar = new h(4291217098L);
                                                }
                                                b.a.b(afVar2, qUIToken.image("chevron_left", hVar), false, 2, null);
                                                return Unit.INSTANCE;
                                            }
                                        });
                                        return Unit.INSTANCE;
                                    }
                                });
                                final JubaoNavBar jubaoNavBar7 = JubaoNavBar.this;
                                vVar2.event(new Function1<u, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.jubao.JubaoNavBar.body.1.6.1.3
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(u uVar) {
                                        final JubaoNavBar jubaoNavBar8 = JubaoNavBar.this;
                                        uVar.click(new Function1<ClickParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.jubao.JubaoNavBar.body.1.6.1.3.1
                                            {
                                                super(1);
                                            }

                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(ClickParams clickParams) {
                                                Function0<Unit> function03 = JubaoNavBar.this.backClickCallback;
                                                if (function03 != null) {
                                                    function03.invoke();
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
                ConditionViewKt.c(viewContainer2, new Function0<Object>() { // from class: com.tencent.hippykotlin.demo.pages.jubao.JubaoNavBar$body$1.7
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return Boolean.valueOf(com.tencent.kuikly.core.manager.c.f117352a.g().getPageData().u());
                    }
                }, new Function1<ConditionView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.jubao.JubaoNavBar$body$1.8
                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(ConditionView conditionView) {
                        cg.a(conditionView, new Function1<TextView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.jubao.JubaoNavBar.body.1.8.1
                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(TextView textView) {
                                textView.attr(new Function1<ce, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.jubao.JubaoNavBar.body.1.8.1.1
                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(ce ceVar) {
                                        ce ceVar2 = ceVar;
                                        ceVar2.positionAbsolute();
                                        ceVar2.m149right(10.0f);
                                        ceVar2.m147opacity(0.3f);
                                        ceVar2.color(JubaoThemeData.INSTANCE.getNavTitleTextColor());
                                        StringBuilder sb5 = new StringBuilder();
                                        sb5.append("resVer:");
                                        QQKuiklyBundleModule qQKuiklyBundleModule = (QQKuiklyBundleModule) com.tencent.kuikly.core.manager.c.f117352a.g().acquireModule("QQKuiklyBundleModule");
                                        qQKuiklyBundleModule.getClass();
                                        e eVar = new e();
                                        eVar.v("bundle_name", "o3");
                                        e eVar2 = new e(qQKuiklyBundleModule.syncToNativeMethod("getBundleInfo", eVar, (Function1<? super e, Unit>) null));
                                        String p16 = eVar2.p("resVersion");
                                        eVar2.p("filePath");
                                        eVar2.p(DownloadInfo.spKey_Config);
                                        sb5.append(p16);
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

    public final void setBarData(NavBarData navBarData) {
        this.navBarData$delegate.setValue(this, $$delegatedProperties[0], navBarData);
    }
}

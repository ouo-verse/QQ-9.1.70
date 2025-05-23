package com.tencent.hippykotlin.demo.pages.jubao;

import com.tencent.biz.pubaccount.util.api.impl.PublicAccountMessageUtilImpl;
import com.tencent.hippykotlin.demo.pages.base.EcommerceExtKt;
import com.tencent.hippykotlin.demo.pages.base.QQFaceImageAttr;
import com.tencent.hippykotlin.demo.pages.base.QQFaceImageView;
import com.tencent.hippykotlin.demo.pages.base.QQFaceImageViewKt;
import com.tencent.hippykotlin.demo.pages.vas_base.VasModule;
import com.tencent.hippykotlin.demo.pages.vas_base.native_api.Friends;
import com.tencent.kuikly.core.base.BorderStyle;
import com.tencent.kuikly.core.base.ViewContainer;
import com.tencent.kuikly.core.base.attr.b;
import com.tencent.kuikly.core.base.event.ClickParams;
import com.tencent.kuikly.core.base.k;
import com.tencent.kuikly.core.coroutines.BuildersKt;
import com.tencent.kuikly.core.layout.FlexDirection;
import com.tencent.kuikly.core.nvi.serialization.json.e;
import com.tencent.kuikly.core.views.ImageEvent;
import com.tencent.kuikly.core.views.ImageView;
import com.tencent.kuikly.core.views.ScrollerAttr;
import com.tencent.kuikly.core.views.ScrollerView;
import com.tencent.kuikly.core.views.TextView;
import com.tencent.kuikly.core.views.af;
import com.tencent.kuikly.core.views.ah;
import com.tencent.kuikly.core.views.bo;
import com.tencent.kuikly.core.views.ce;
import com.tencent.kuikly.core.views.cg;
import com.tencent.kuikly.core.views.t;
import com.tencent.kuikly.core.views.u;
import com.tencent.kuikly.core.views.v;
import com.tencent.kuikly.core.views.w;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
/* loaded from: classes31.dex */
public final class JubaoCompleteView extends JubaoAnimationView {
    public final PageModel model;
    public Function1<? super OperateData, Unit> operateCallback;

    public JubaoCompleteView(PageModel pageModel) {
        this.model = pageModel;
    }

    public static final float access$getItemHeight(JubaoCompleteView jubaoCompleteView) {
        return (jubaoCompleteView.getPagerData().m() - 32) * 0.3411f;
    }

    public static final float access$getItemWidth(JubaoCompleteView jubaoCompleteView) {
        return jubaoCompleteView.getPagerData().m() - 32;
    }

    @Override // com.tencent.hippykotlin.demo.pages.jubao.JubaoAnimationView, com.tencent.kuikly.core.base.ComposeView
    public final Function1<ViewContainer<?, ?>, Unit> body() {
        JubaoAnimationView$body$1 jubaoAnimationView$body$1 = new JubaoAnimationView$body$1(this);
        attr(new Function1<k, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.jubao.JubaoCompleteView$body$1$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Unit invoke(k kVar) {
                e jubaoDTBaseParams = ConstantsKt.getJubaoDTBaseParams();
                JubaoCompleteView jubaoCompleteView = JubaoCompleteView.this;
                jubaoDTBaseParams.v("come_from", jubaoCompleteView.model.getPostData().src);
                jubaoDTBaseParams.v("strategyid", jubaoCompleteView.model.getPostData().grayId);
                Unit unit = Unit.INSTANCE;
                EcommerceExtKt.elementVR(kVar, "em_safe_report_completion", jubaoDTBaseParams);
                return Unit.INSTANCE;
            }
        });
        w.a(this, JubaoUtil$O3BgView$1.INSTANCE);
        JubaoNavBarKt.JubaoNavBar(this, new Function1<JubaoNavBar, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.jubao.JubaoCompleteView$body$1$2
            @Override // kotlin.jvm.functions.Function1
            public final Unit invoke(JubaoNavBar jubaoNavBar) {
                jubaoNavBar.setBarData(new NavBarData("\u4e3e\u62a5\u5b8c\u6210", false, false));
                return Unit.INSTANCE;
            }
        });
        bo.a(this, new Function1<ScrollerView<?, ?>, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.jubao.JubaoCompleteView$body$1$3
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Unit invoke(ScrollerView<?, ?> scrollerView) {
                ScrollerView<?, ?> scrollerView2 = scrollerView;
                scrollerView2.attr(new Function1<ScrollerAttr, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.jubao.JubaoCompleteView$body$1$3.1
                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(ScrollerAttr scrollerAttr) {
                        ScrollerAttr scrollerAttr2 = scrollerAttr;
                        scrollerAttr2.absolutePosition(0.0f, 0.0f, 0.0f, 0.0f);
                        scrollerAttr2.flexDirectionColumn();
                        scrollerAttr2.marginTop(74.0f);
                        scrollerAttr2.showScrollerIndicator(false);
                        return Unit.INSTANCE;
                    }
                });
                final JubaoCompleteView jubaoCompleteView = JubaoCompleteView.this;
                w.a(scrollerView2, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.jubao.JubaoCompleteView$body$1$3.2
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(v vVar) {
                        v vVar2 = vVar;
                        vVar2.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.jubao.JubaoCompleteView.body.1.3.2.1
                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(t tVar) {
                                t tVar2 = tVar;
                                tVar2.flexDirectionColumn();
                                tVar2.mo153width(tVar2.getPagerData().m());
                                tVar2.alignSelfCenter();
                                tVar2.alignItemsCenter();
                                return Unit.INSTANCE;
                            }
                        });
                        ah.a(vVar2, new Function1<ImageView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.jubao.JubaoCompleteView.body.1.3.2.2
                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(ImageView imageView) {
                                imageView.attr(new Function1<af, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.jubao.JubaoCompleteView.body.1.3.2.2.1
                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(af afVar) {
                                        af afVar2 = afVar;
                                        afVar2.mo141height(68.0f);
                                        afVar2.mo153width(68.0f);
                                        b.a.b(afVar2, "data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAAMAAAADACAMAAABlApw1AAAAP1BMVEUAAAAAnP8AnP8Aov8Am/8Amv8Amv8AnP8Anf8AnP8AnP8Anf8Anf8Anf8Amv8AnP8AnP8Anv8Anv8Amv8AnP+pj+R8AAAAFHRSTlMA798QIDBgoL9wkGDPUECvgH9AgNuOj9cAAAcoSURBVHja5V3XkqMwEFREARNs8//fenWhPMLCWLpRGGr7cctedzNRIDSsPKSenDeLFYJvf8CFsNasbtKS0YbUzlu+nYBb7x6MJOTob1sibn5SjBLkw4stEzczMRqQDrwmE8vY3RBytBsKduwZ2A/PNzS46RTV0tmtEMTImkPe+Wc+1qzDNCsl/31W6XkaVmPF56+YttGgPP+U5ofTaqWnj4WioQRljn3ZJVLQwyIQEqo4j3WaZUE720nCAX3r5H8Zcog1CMfq4iFQ7GMNt0hCzQItl3e/9zNDQpt2fuT4G/2nLJITBtGkLChb72cGUd8IE9/TB98pJKGuEaSvbORIgpdF3UdEvl8Bz52RRUE3Gnf/eYn+c50Sz4uZ+Y5wfpQf3Sskfy9ZVcjnztiysPuLmVXHLIoGghKNLj9AmoIKNA+CyrFs4Eu+0Dj+2GuBtzvXqPSJjyd85hj/m/8GeLLGeOIV6A3gWHO40IuQ/s9n1gETRylQApkI8NACFCgMf8VaA09CUuC/V5CXBRcS/HcKlqz+kwh/UJDXmw5h+HeG5vnlQMF3CDxFmYNUlB3AjhGAyw1kH/QPJABdhc8LgIURwQIunRP2gsxjaSkywsC8Ptv9CeJRWrFfHYhWAMeB7FIdyDBS8C/HkOcORC8AIAwSUsv0stTMiGFOoiaIVYBDJxInoULVgfZOtH6P4JERxPw1jg3RDAQF+dwEimIJC6H4OUFDOIL/Yj11EQVRThUQx+rIAKQj+K3R8Zc0QFCouLykAYJUusbarmCAExMMlzBAwNNd0wCM8eOVzeMiBghqwXwcwkSLMEDyo0wqOe0uKISHMD4Ije53Er9jPvJ2++9vN3YB2DiM1WVCeLfskuBBlwnh35BxKVjAKN0g7zfO7aj+y4cIeJAW6Q8U3Xsemvp7kOYZy0H5XstMdw8C/kks7Fstu/W7Gwr8AXOyDwlIoh2rGPBPvo56n0injo0o8AesaS0pZB3f94EM8E/3ZLMLglvPJAr8c+4ru13r0ycEYv4ZnqwgCGAtwxkGeP5ZxYgHF90hqkAF/kNWR+qCGPbsO6jw35G2yY9g6fBnQ+A2PDWGCfF/lTIedEbsCyjxB9aS6bTsRYs/3MfSbEpKQtT4B5Hrkm6oUOPPzCuPriktFDn+L9qemYROiB7/Vx41KWWAIP9X6C4vATNLx2PhG7djP/7QwVnIR/l3J63sxR/6UfESoP5jU+lNNucfC+DQWad/FRT04Q+lmLPsTsJskYL2/BnwzhZw2yIFOP6tBWwAUIDg31yAiBSg+LcXYLZIAYJ/BwHzFitozh8E5KdR5g8UNOcPaTS/kDFzoADPH1+JcQra8oeFZNDMIRWg+COauQXaaaSClvxhJRwuaPAK8PzzFzQelpRoBe34w0o4XNTjFTTjD4v6wJlKKGjFH1bCQT4qoqARf1hIBjfpyihow58B6+jmLlZBE/5wcxe8aWSFFDTgD5EbPeAopCDmX5L/nrQDMaUUoPhnP2ICdyqnoDJ/CNw5fFagCiqoyx/2GkR7PYopqMkfOqHbLiAMK6igJn/YYuZ3cjgrqKAmf6jD0/6BmUYoaMpfv4WtKLDhybTiH+/1gCCwDAHTjD9UAfN+p0eiFDTjr97f75a8yKY504g/7NM92EmKgmnCH+guR7uRUTBN+MNO76PdyDiYBvzjnd54HwKY6vyh9bFHoma0gur8NXjQ4YspWJi6/OEHuDx5MQUDU5U/hLBJeMUP+ZZOOf4J3m6jlhR75qZVrACSX5l0RV+C0HOteSHDJ56SX+NdRPGR5kr2SIwQQxDClzTB2TvpnsCrQBkGiKEoH+txYgCAgVpAFPfzkzsUv8rBGNsHgiu508Eyj06RnHQqHb4fn7hSjmM41sMlRLln5HBPeclmpntE1SPtsLyFqhPJxOPXJCfqRCb1AFRH/aC8r42OpXjOE5Qwk/BZemEgRc4JuhPl4zrHvE19d0YCsNvc/4wja5nilOoZuDRXP+XYZsaeFA/Ofv6ko8uvf3j85Y/vZ0xxSgMUhMKNsJhYBzw4eggHlSEim0asont1FXfMgx5QQGGQDh9+7igjSAT9hklxjb4WANNmnJePx3ldaaDaQ5zwx4+0u1c2gvRb+czxbDB3FC5/jRFcA28z/FWBsc/SJ36wZp2qJu9ngzV/+GjTutNfwfmrto/KtBnvW3GbQjwIWRX0fUTJR8x3NxrtOx7oN2gbJxFt88aYQcKw92bF3kUSNjsqHHsAz6ldeD/CD9rHTi3HSwCIZUwUoZwBv8eXeLwEALd+OlMh9egtP/6qb0MfJIjtE4Q16zg9tJL/aCv1mMbVWPgKwnnKlwU8rJOsC2bD8ey5n1k/yMEiL/7Q/UmcGpb/vfbWdWf/D5O55bIXfqbC/i/U5JNF3Hx/xznG7KI0HxUKp4mSD6rV5FZjrRD8H2sh7GK8m2pQ/wWz+tlSD3viEgAAAABJRU5ErkJggg==", false, 2, null);
                                        return Unit.INSTANCE;
                                    }
                                });
                                return Unit.INSTANCE;
                            }
                        });
                        final JubaoCompleteView jubaoCompleteView2 = JubaoCompleteView.this;
                        cg.a(vVar2, new Function1<TextView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.jubao.JubaoCompleteView.body.1.3.2.3
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(TextView textView) {
                                final JubaoCompleteView jubaoCompleteView3 = JubaoCompleteView.this;
                                textView.attr(new Function1<ce, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.jubao.JubaoCompleteView.body.1.3.2.3.1
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(ce ceVar) {
                                        ce ceVar2 = ceVar;
                                        ceVar2.fontWeight400();
                                        ceVar2.color(JubaoThemeData.INSTANCE.getContentTextColor());
                                        ceVar2.mo153width(JubaoCompleteView.access$getItemWidth(JubaoCompleteView.this));
                                        ceVar2.marginTop(24.0f);
                                        ceVar2.marginBottom(16.0f);
                                        ce.fontSize$default(ceVar2, 14.0f, null, 2, null);
                                        ceVar2.text("\u9884\u8ba148\u5c0f\u65f6\u4e4b\u5185\u5b8c\u6210\u5ba1\u6838\uff0c\u5e76\u5c06\u7ed3\u679c\u901a\u8fc7QQ\u5b89\u5168\u4e2d\u5fc3\u8ba2\u9605\u53f7\u53cd\u9988\u7ed9\u4f60\u3002");
                                        return Unit.INSTANCE;
                                    }
                                });
                                return Unit.INSTANCE;
                            }
                        });
                        final JubaoCompleteView jubaoCompleteView3 = JubaoCompleteView.this;
                        for (final OperateData operateData : jubaoCompleteView3.model.operatesData) {
                            int i3 = operateData.type;
                            if (i3 == 1) {
                                w.a(vVar2, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.jubao.JubaoCompleteView$body$1$3$2$4$1
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(v vVar3) {
                                        v vVar4 = vVar3;
                                        final JubaoCompleteView jubaoCompleteView4 = JubaoCompleteView.this;
                                        vVar4.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.jubao.JubaoCompleteView$body$1$3$2$4$1.1
                                            {
                                                super(1);
                                            }

                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(t tVar) {
                                                t tVar2 = tVar;
                                                tVar2.mo153width(JubaoCompleteView.access$getItemWidth(JubaoCompleteView.this));
                                                tVar2.mo141height(JubaoCompleteView.access$getItemHeight(JubaoCompleteView.this));
                                                tVar2.alignSelfCenter();
                                                tVar2.flexDirectionColumn();
                                                tVar2.borderRadius(8.0f);
                                                tVar2.m136border(new com.tencent.kuikly.core.base.e(1.0f, BorderStyle.SOLID, JubaoThemeData.operateViewBorderColor));
                                                tVar2.marginBottom(6.0f);
                                                return Unit.INSTANCE;
                                            }
                                        });
                                        final OperateData operateData2 = operateData;
                                        cg.a(vVar4, new Function1<TextView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.jubao.JubaoCompleteView$body$1$3$2$4$1.2
                                            {
                                                super(1);
                                            }

                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(TextView textView) {
                                                final OperateData operateData3 = OperateData.this;
                                                textView.attr(new Function1<ce, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.jubao.JubaoCompleteView.body.1.3.2.4.1.2.1
                                                    {
                                                        super(1);
                                                    }

                                                    @Override // kotlin.jvm.functions.Function1
                                                    public final Unit invoke(ce ceVar) {
                                                        ce ceVar2 = ceVar;
                                                        ceVar2.marginTop(24.0f);
                                                        ceVar2.marginLeft(12.0f);
                                                        ceVar2.color(JubaoThemeData.INSTANCE.getTitleTextColor());
                                                        ce.fontSize$default(ceVar2, 17.0f, null, 2, null);
                                                        ceVar2.fontWeight400();
                                                        ceVar2.text(OperateData.this.title);
                                                        return Unit.INSTANCE;
                                                    }
                                                });
                                                return Unit.INSTANCE;
                                            }
                                        });
                                        final OperateData operateData3 = operateData;
                                        final JubaoCompleteView jubaoCompleteView5 = JubaoCompleteView.this;
                                        w.a(vVar4, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.jubao.JubaoCompleteView$body$1$3$2$4$1.3
                                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                            {
                                                super(1);
                                            }

                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(v vVar5) {
                                                v vVar6 = vVar5;
                                                vVar6.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.jubao.JubaoCompleteView.body.1.3.2.4.1.3.1
                                                    @Override // kotlin.jvm.functions.Function1
                                                    public final Unit invoke(t tVar) {
                                                        t tVar2 = tVar;
                                                        tVar2.marginLeft(12.0f);
                                                        tVar2.marginRight(12.0f);
                                                        tVar2.marginTop(8.0f);
                                                        tVar2.mo141height(40.0f);
                                                        tVar2.flexDirection(FlexDirection.ROW_REVERSE);
                                                        return Unit.INSTANCE;
                                                    }
                                                });
                                                final OperateData operateData4 = OperateData.this;
                                                final JubaoCompleteView jubaoCompleteView6 = jubaoCompleteView5;
                                                w.a(vVar6, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.jubao.JubaoCompleteView.body.1.3.2.4.1.3.2
                                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                    {
                                                        super(1);
                                                    }

                                                    @Override // kotlin.jvm.functions.Function1
                                                    public final Unit invoke(v vVar7) {
                                                        v vVar8 = vVar7;
                                                        final OperateData operateData5 = OperateData.this;
                                                        vVar8.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.jubao.JubaoCompleteView.body.1.3.2.4.1.3.2.1
                                                            {
                                                                super(1);
                                                            }

                                                            @Override // kotlin.jvm.functions.Function1
                                                            public final Unit invoke(t tVar) {
                                                                t tVar2 = tVar;
                                                                tVar2.mo141height(26.0f);
                                                                tVar2.mo153width(70.0f);
                                                                tVar2.marginRight(8.0f);
                                                                tVar2.borderRadius(4.0f);
                                                                tVar2.allCenter();
                                                                tVar2.mo113backgroundColor(JubaoThemeData.INSTANCE.getConfirmBtnBgColor());
                                                                tVar2.marginTop(7.0f);
                                                                e jubaoDTBaseParams = ConstantsKt.getJubaoDTBaseParams();
                                                                OperateData operateData6 = OperateData.this;
                                                                jubaoDTBaseParams.v("activity_id", operateData6.title);
                                                                jubaoDTBaseParams.v(PublicAccountMessageUtilImpl.ITEM_STRUCT_FIRST_LEVEL_NAME, operateData6.btnText);
                                                                Unit unit = Unit.INSTANCE;
                                                                EcommerceExtKt.elementVR(tVar2, "em_safe_tipoff_module_first_kind", jubaoDTBaseParams);
                                                                return Unit.INSTANCE;
                                                            }
                                                        });
                                                        final JubaoCompleteView jubaoCompleteView7 = jubaoCompleteView6;
                                                        final OperateData operateData6 = OperateData.this;
                                                        vVar8.event(new Function1<u, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.jubao.JubaoCompleteView.body.1.3.2.4.1.3.2.2
                                                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                            {
                                                                super(1);
                                                            }

                                                            @Override // kotlin.jvm.functions.Function1
                                                            public final Unit invoke(u uVar) {
                                                                final JubaoCompleteView jubaoCompleteView8 = JubaoCompleteView.this;
                                                                final OperateData operateData7 = operateData6;
                                                                uVar.click(new Function1<ClickParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.jubao.JubaoCompleteView.body.1.3.2.4.1.3.2.2.1
                                                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                                    {
                                                                        super(1);
                                                                    }

                                                                    @Override // kotlin.jvm.functions.Function1
                                                                    public final Unit invoke(ClickParams clickParams) {
                                                                        Function1<? super OperateData, Unit> function1 = JubaoCompleteView.this.operateCallback;
                                                                        if (function1 != null) {
                                                                            function1.invoke(operateData7);
                                                                        }
                                                                        return Unit.INSTANCE;
                                                                    }
                                                                });
                                                                return Unit.INSTANCE;
                                                            }
                                                        });
                                                        final OperateData operateData7 = OperateData.this;
                                                        cg.a(vVar8, new Function1<TextView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.jubao.JubaoCompleteView.body.1.3.2.4.1.3.2.3
                                                            {
                                                                super(1);
                                                            }

                                                            @Override // kotlin.jvm.functions.Function1
                                                            public final Unit invoke(TextView textView) {
                                                                final OperateData operateData8 = OperateData.this;
                                                                textView.attr(new Function1<ce, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.jubao.JubaoCompleteView.body.1.3.2.4.1.3.2.3.1
                                                                    {
                                                                        super(1);
                                                                    }

                                                                    @Override // kotlin.jvm.functions.Function1
                                                                    public final Unit invoke(ce ceVar) {
                                                                        ce ceVar2 = ceVar;
                                                                        ceVar2.text(OperateData.this.btnText);
                                                                        ce.fontSize$default(ceVar2, 14.0f, null, 2, null);
                                                                        ceVar2.fontWeight400();
                                                                        ceVar2.color(JubaoThemeData.INSTANCE.getConfirmBtnTextColor());
                                                                        return Unit.INSTANCE;
                                                                    }
                                                                });
                                                                return Unit.INSTANCE;
                                                            }
                                                        });
                                                        return Unit.INSTANCE;
                                                    }
                                                });
                                                final OperateData operateData5 = OperateData.this;
                                                cg.a(vVar6, new Function1<TextView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.jubao.JubaoCompleteView.body.1.3.2.4.1.3.3
                                                    {
                                                        super(1);
                                                    }

                                                    @Override // kotlin.jvm.functions.Function1
                                                    public final Unit invoke(TextView textView) {
                                                        final OperateData operateData6 = OperateData.this;
                                                        textView.attr(new Function1<ce, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.jubao.JubaoCompleteView.body.1.3.2.4.1.3.3.1
                                                            {
                                                                super(1);
                                                            }

                                                            @Override // kotlin.jvm.functions.Function1
                                                            public final Unit invoke(ce ceVar) {
                                                                ce ceVar2 = ceVar;
                                                                ceVar2.color(JubaoThemeData.INSTANCE.getContentTextColor());
                                                                ce.fontSize$default(ceVar2, 14.0f, null, 2, null);
                                                                ceVar2.fontWeight400();
                                                                ceVar2.text(OperateData.this.desc);
                                                                ceVar2.m140flex(1.0f);
                                                                ceVar2.marginRight(19.0f);
                                                                ceVar2.alignSelfCenter();
                                                                ceVar2.lines(2);
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
                            } else if (i3 == 2) {
                                ah.a(vVar2, new Function1<ImageView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.jubao.JubaoCompleteView$body$1$3$2$4$2
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(ImageView imageView) {
                                        ImageView imageView2 = imageView;
                                        final JubaoCompleteView jubaoCompleteView4 = JubaoCompleteView.this;
                                        final OperateData operateData2 = operateData;
                                        imageView2.attr(new Function1<af, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.jubao.JubaoCompleteView$body$1$3$2$4$2.1
                                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                            {
                                                super(1);
                                            }

                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(af afVar) {
                                                af afVar2 = afVar;
                                                afVar2.mo153width(JubaoCompleteView.access$getItemWidth(JubaoCompleteView.this));
                                                afVar2.mo141height(JubaoCompleteView.access$getItemHeight(JubaoCompleteView.this));
                                                afVar2.alignSelfCenter();
                                                afVar2.borderRadius(8.0f);
                                                b.a.b(afVar2, operateData2.picUrl, false, 2, null);
                                                afVar2.marginBottom(6.0f);
                                                e jubaoDTBaseParams = ConstantsKt.getJubaoDTBaseParams();
                                                jubaoDTBaseParams.v("activity_id", operateData2.title);
                                                Unit unit = Unit.INSTANCE;
                                                EcommerceExtKt.elementVR(afVar2, "em_safe_tipoff_module_second_kind", jubaoDTBaseParams);
                                                return Unit.INSTANCE;
                                            }
                                        });
                                        final JubaoCompleteView jubaoCompleteView5 = JubaoCompleteView.this;
                                        final OperateData operateData3 = operateData;
                                        imageView2.event(new Function1<ImageEvent, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.jubao.JubaoCompleteView$body$1$3$2$4$2.2
                                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                            {
                                                super(1);
                                            }

                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(ImageEvent imageEvent) {
                                                final JubaoCompleteView jubaoCompleteView6 = JubaoCompleteView.this;
                                                final OperateData operateData4 = operateData3;
                                                imageEvent.click(new Function1<ClickParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.jubao.JubaoCompleteView.body.1.3.2.4.2.2.1
                                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                    {
                                                        super(1);
                                                    }

                                                    @Override // kotlin.jvm.functions.Function1
                                                    public final Unit invoke(ClickParams clickParams) {
                                                        Function1<? super OperateData, Unit> function1 = JubaoCompleteView.this.operateCallback;
                                                        if (function1 != null) {
                                                            function1.invoke(operateData4);
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
                            } else if (i3 == 3) {
                                w.a(vVar2, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.jubao.JubaoCompleteView$body$1$3$2$4$3
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(v vVar3) {
                                        v vVar4 = vVar3;
                                        final JubaoCompleteView jubaoCompleteView4 = JubaoCompleteView.this;
                                        vVar4.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.jubao.JubaoCompleteView$body$1$3$2$4$3.1
                                            {
                                                super(1);
                                            }

                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(t tVar) {
                                                t tVar2 = tVar;
                                                tVar2.mo153width(JubaoCompleteView.access$getItemWidth(JubaoCompleteView.this));
                                                tVar2.mo141height(JubaoCompleteView.access$getItemHeight(JubaoCompleteView.this));
                                                tVar2.alignSelfCenter();
                                                tVar2.flexDirectionColumn();
                                                tVar2.borderRadius(8.0f);
                                                tVar2.m136border(new com.tencent.kuikly.core.base.e(1.0f, BorderStyle.SOLID, JubaoThemeData.operateViewBorderColor));
                                                tVar2.marginBottom(6.0f);
                                                return Unit.INSTANCE;
                                            }
                                        });
                                        final OperateData operateData2 = operateData;
                                        cg.a(vVar4, new Function1<TextView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.jubao.JubaoCompleteView$body$1$3$2$4$3.2
                                            {
                                                super(1);
                                            }

                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(TextView textView) {
                                                final OperateData operateData3 = OperateData.this;
                                                textView.attr(new Function1<ce, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.jubao.JubaoCompleteView.body.1.3.2.4.3.2.1
                                                    {
                                                        super(1);
                                                    }

                                                    @Override // kotlin.jvm.functions.Function1
                                                    public final Unit invoke(ce ceVar) {
                                                        ce ceVar2 = ceVar;
                                                        ceVar2.marginTop(24.0f);
                                                        ceVar2.marginLeft(12.0f);
                                                        ceVar2.color(JubaoThemeData.INSTANCE.getTitleTextColor());
                                                        ce.fontSize$default(ceVar2, 17.0f, null, 2, null);
                                                        ceVar2.fontWeight400();
                                                        ceVar2.text(OperateData.this.title);
                                                        return Unit.INSTANCE;
                                                    }
                                                });
                                                return Unit.INSTANCE;
                                            }
                                        });
                                        final OperateData operateData3 = operateData;
                                        final JubaoCompleteView jubaoCompleteView5 = JubaoCompleteView.this;
                                        w.a(vVar4, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.jubao.JubaoCompleteView$body$1$3$2$4$3.3
                                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                            {
                                                super(1);
                                            }

                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(v vVar5) {
                                                v vVar6 = vVar5;
                                                vVar6.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.jubao.JubaoCompleteView.body.1.3.2.4.3.3.1
                                                    @Override // kotlin.jvm.functions.Function1
                                                    public final Unit invoke(t tVar) {
                                                        t tVar2 = tVar;
                                                        tVar2.marginLeft(12.0f);
                                                        tVar2.marginRight(12.0f);
                                                        tVar2.marginTop(9.0f);
                                                        tVar2.flexDirection(FlexDirection.ROW_REVERSE);
                                                        return Unit.INSTANCE;
                                                    }
                                                });
                                                final OperateData operateData4 = OperateData.this;
                                                final JubaoCompleteView jubaoCompleteView6 = jubaoCompleteView5;
                                                w.a(vVar6, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.jubao.JubaoCompleteView.body.1.3.2.4.3.3.2
                                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                    {
                                                        super(1);
                                                    }

                                                    @Override // kotlin.jvm.functions.Function1
                                                    public final Unit invoke(v vVar7) {
                                                        v vVar8 = vVar7;
                                                        final OperateData operateData5 = OperateData.this;
                                                        final JubaoCompleteView jubaoCompleteView7 = jubaoCompleteView6;
                                                        vVar8.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.jubao.JubaoCompleteView.body.1.3.2.4.3.3.2.1
                                                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                            {
                                                                super(1);
                                                            }

                                                            /* JADX WARN: Removed duplicated region for block: B:22:0x00b5  */
                                                            /* JADX WARN: Removed duplicated region for block: B:9:0x0098  */
                                                            @Override // kotlin.jvm.functions.Function1
                                                            /*
                                                                Code decompiled incorrectly, please refer to instructions dump.
                                                            */
                                                            public final Unit invoke(t tVar) {
                                                                int i16;
                                                                String str;
                                                                t tVar2 = tVar;
                                                                tVar2.mo141height(26.0f);
                                                                tVar2.mo153width(70.0f);
                                                                tVar2.marginRight(8.0f);
                                                                tVar2.borderRadius(4.0f);
                                                                tVar2.allCenter();
                                                                int i17 = OperateData.this.subType;
                                                                if (i17 != 1 && i17 != 2) {
                                                                    if (i17 != 5) {
                                                                        if (i17 != 6) {
                                                                            tVar2.mo113backgroundColor(JubaoThemeData.INSTANCE.getConfirmBtnBgColor());
                                                                        }
                                                                    } else if (jubaoCompleteView7.model.isFollowAccount()) {
                                                                        tVar2.mo113backgroundColor(JubaoThemeData.INSTANCE.getDisableBtnBgColor());
                                                                    } else {
                                                                        tVar2.mo113backgroundColor(JubaoThemeData.INSTANCE.getConfirmBtnBgColor());
                                                                    }
                                                                    tVar2.alignSelfCenter();
                                                                    e jubaoDTBaseParams = ConstantsKt.getJubaoDTBaseParams();
                                                                    OperateData operateData6 = OperateData.this;
                                                                    jubaoDTBaseParams.v("activity_id", operateData6.title);
                                                                    i16 = operateData6.subType;
                                                                    if (i16 != 1) {
                                                                        str = "\u53bb\u62c9\u9ed1";
                                                                    } else if (i16 == 2) {
                                                                        str = "\u53bb\u9000\u51fa";
                                                                    } else if (i16 == 4) {
                                                                        str = "\u53bb\u52a0\u5165";
                                                                    } else if (i16 == 5) {
                                                                        str = "\u53bb\u5173\u6ce8";
                                                                    } else if (i16 != 6) {
                                                                        str = "";
                                                                    } else {
                                                                        str = "\u53bb\u5220\u9664";
                                                                    }
                                                                    jubaoDTBaseParams.v(PublicAccountMessageUtilImpl.ITEM_STRUCT_FIRST_LEVEL_NAME, str);
                                                                    Unit unit = Unit.INSTANCE;
                                                                    EcommerceExtKt.elementVR(tVar2, "em_safe_tipoff_module_third_kind", jubaoDTBaseParams);
                                                                    return Unit.INSTANCE;
                                                                }
                                                                if (!jubaoCompleteView7.model.isBlackFriend() && !jubaoCompleteView7.model.isQuitGroup() && !jubaoCompleteView7.model.isDeleteFriend()) {
                                                                    tVar2.mo113backgroundColor(JubaoThemeData.INSTANCE.getConfirmBtnBgColor());
                                                                } else {
                                                                    tVar2.mo113backgroundColor(JubaoThemeData.INSTANCE.getDisableBtnBgColor());
                                                                }
                                                                tVar2.alignSelfCenter();
                                                                e jubaoDTBaseParams2 = ConstantsKt.getJubaoDTBaseParams();
                                                                OperateData operateData62 = OperateData.this;
                                                                jubaoDTBaseParams2.v("activity_id", operateData62.title);
                                                                i16 = operateData62.subType;
                                                                if (i16 != 1) {
                                                                }
                                                                jubaoDTBaseParams2.v(PublicAccountMessageUtilImpl.ITEM_STRUCT_FIRST_LEVEL_NAME, str);
                                                                Unit unit2 = Unit.INSTANCE;
                                                                EcommerceExtKt.elementVR(tVar2, "em_safe_tipoff_module_third_kind", jubaoDTBaseParams2);
                                                                return Unit.INSTANCE;
                                                            }
                                                        });
                                                        final JubaoCompleteView jubaoCompleteView8 = jubaoCompleteView6;
                                                        final OperateData operateData6 = OperateData.this;
                                                        vVar8.event(new Function1<u, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.jubao.JubaoCompleteView.body.1.3.2.4.3.3.2.2
                                                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                            {
                                                                super(1);
                                                            }

                                                            @Override // kotlin.jvm.functions.Function1
                                                            public final Unit invoke(u uVar) {
                                                                final JubaoCompleteView jubaoCompleteView9 = JubaoCompleteView.this;
                                                                final OperateData operateData7 = operateData6;
                                                                uVar.click(new Function1<ClickParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.jubao.JubaoCompleteView.body.1.3.2.4.3.3.2.2.1
                                                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                                    {
                                                                        super(1);
                                                                    }

                                                                    @Override // kotlin.jvm.functions.Function1
                                                                    public final Unit invoke(ClickParams clickParams) {
                                                                        Function1<? super OperateData, Unit> function1 = JubaoCompleteView.this.operateCallback;
                                                                        if (function1 != null) {
                                                                            function1.invoke(operateData7);
                                                                        }
                                                                        return Unit.INSTANCE;
                                                                    }
                                                                });
                                                                return Unit.INSTANCE;
                                                            }
                                                        });
                                                        final OperateData operateData7 = OperateData.this;
                                                        final JubaoCompleteView jubaoCompleteView9 = jubaoCompleteView6;
                                                        cg.a(vVar8, new Function1<TextView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.jubao.JubaoCompleteView.body.1.3.2.4.3.3.2.3
                                                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                            {
                                                                super(1);
                                                            }

                                                            @Override // kotlin.jvm.functions.Function1
                                                            public final Unit invoke(TextView textView) {
                                                                final OperateData operateData8 = OperateData.this;
                                                                final JubaoCompleteView jubaoCompleteView10 = jubaoCompleteView9;
                                                                textView.attr(new Function1<ce, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.jubao.JubaoCompleteView.body.1.3.2.4.3.3.2.3.1
                                                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                                    {
                                                                        super(1);
                                                                    }

                                                                    @Override // kotlin.jvm.functions.Function1
                                                                    public final Unit invoke(ce ceVar) {
                                                                        ce ceVar2 = ceVar;
                                                                        int i16 = OperateData.this.subType;
                                                                        if (i16 != 1) {
                                                                            if (i16 != 2) {
                                                                                if (i16 == 4) {
                                                                                    ceVar2.text("\u53bb\u52a0\u5165");
                                                                                } else if (i16 != 5) {
                                                                                    if (i16 == 6) {
                                                                                        if (!jubaoCompleteView10.model.isDeleteFriend()) {
                                                                                            ceVar2.text("\u53bb\u5220\u9664");
                                                                                        } else {
                                                                                            ceVar2.text("\u5df2\u5220\u9664");
                                                                                        }
                                                                                    }
                                                                                } else if (!jubaoCompleteView10.model.isFollowAccount()) {
                                                                                    ceVar2.text("\u53bb\u5173\u6ce8");
                                                                                } else {
                                                                                    ceVar2.text("\u5df2\u5173\u6ce8");
                                                                                }
                                                                            } else if (!jubaoCompleteView10.model.isQuitGroup()) {
                                                                                ceVar2.text("\u53bb\u9000\u51fa");
                                                                            } else {
                                                                                ceVar2.text("\u5df2\u9000\u51fa");
                                                                            }
                                                                        } else if (!jubaoCompleteView10.model.isBlackFriend()) {
                                                                            ceVar2.text("\u53bb\u62c9\u9ed1");
                                                                        } else {
                                                                            ceVar2.text("\u5df2\u62c9\u9ed1");
                                                                        }
                                                                        ce.fontSize$default(ceVar2, 14.0f, null, 2, null);
                                                                        ceVar2.fontWeight400();
                                                                        ceVar2.color(JubaoThemeData.INSTANCE.getConfirmBtnTextColor());
                                                                        return Unit.INSTANCE;
                                                                    }
                                                                });
                                                                return Unit.INSTANCE;
                                                            }
                                                        });
                                                        return Unit.INSTANCE;
                                                    }
                                                });
                                                final OperateData operateData5 = OperateData.this;
                                                final JubaoCompleteView jubaoCompleteView7 = jubaoCompleteView5;
                                                w.a(vVar6, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.jubao.JubaoCompleteView.body.1.3.2.4.3.3.3
                                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                    {
                                                        super(1);
                                                    }

                                                    @Override // kotlin.jvm.functions.Function1
                                                    public final Unit invoke(v vVar7) {
                                                        v vVar8 = vVar7;
                                                        vVar8.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.jubao.JubaoCompleteView.body.1.3.2.4.3.3.3.1
                                                            @Override // kotlin.jvm.functions.Function1
                                                            public final Unit invoke(t tVar) {
                                                                t tVar2 = tVar;
                                                                tVar2.m140flex(1.0f);
                                                                tVar2.flexDirectionRow();
                                                                return Unit.INSTANCE;
                                                            }
                                                        });
                                                        final OperateData operateData6 = OperateData.this;
                                                        if (operateData6.subType == 4) {
                                                            ah.a(vVar8, new Function1<ImageView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.jubao.JubaoCompleteView.body.1.3.2.4.3.3.3.2
                                                                {
                                                                    super(1);
                                                                }

                                                                @Override // kotlin.jvm.functions.Function1
                                                                public final Unit invoke(ImageView imageView) {
                                                                    final OperateData operateData7 = OperateData.this;
                                                                    imageView.attr(new Function1<af, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.jubao.JubaoCompleteView.body.1.3.2.4.3.3.3.2.1
                                                                        {
                                                                            super(1);
                                                                        }

                                                                        @Override // kotlin.jvm.functions.Function1
                                                                        public final Unit invoke(af afVar) {
                                                                            af afVar2 = afVar;
                                                                            afVar2.mo141height(44.0f);
                                                                            afVar2.mo153width(44.0f);
                                                                            afVar2.borderRadius(22.0f);
                                                                            b.a.b(afVar2, OperateData.this.picUrl, false, 2, null);
                                                                            return Unit.INSTANCE;
                                                                        }
                                                                    });
                                                                    return Unit.INSTANCE;
                                                                }
                                                            });
                                                        } else {
                                                            final JubaoCompleteView jubaoCompleteView8 = jubaoCompleteView7;
                                                            QQFaceImageViewKt.QQFaceImage(vVar8, new Function1<QQFaceImageView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.jubao.JubaoCompleteView.body.1.3.2.4.3.3.3.3
                                                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                                {
                                                                    super(1);
                                                                }

                                                                @Override // kotlin.jvm.functions.Function1
                                                                public final Unit invoke(QQFaceImageView qQFaceImageView) {
                                                                    final OperateData operateData7 = OperateData.this;
                                                                    final JubaoCompleteView jubaoCompleteView9 = jubaoCompleteView8;
                                                                    qQFaceImageView.attr(new Function1<QQFaceImageAttr, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.jubao.JubaoCompleteView.body.1.3.2.4.3.3.3.3.1
                                                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                                        {
                                                                            super(1);
                                                                        }

                                                                        /* JADX WARN: Code restructure failed: missing block: B:8:0x0019, code lost:
                                                                        
                                                                            if (r0 != 6) goto L14;
                                                                         */
                                                                        @Override // kotlin.jvm.functions.Function1
                                                                        /*
                                                                            Code decompiled incorrectly, please refer to instructions dump.
                                                                        */
                                                                        public final Unit invoke(QQFaceImageAttr qQFaceImageAttr) {
                                                                            QQFaceImageAttr qQFaceImageAttr2 = qQFaceImageAttr;
                                                                            qQFaceImageAttr2.mo141height(44.0f);
                                                                            qQFaceImageAttr2.mo153width(44.0f);
                                                                            int i16 = OperateData.this.subType;
                                                                            if (i16 != 1) {
                                                                                if (i16 == 2) {
                                                                                    qQFaceImageAttr2.src(jubaoCompleteView9.model.getPostData().groupCode, 1);
                                                                                } else if (i16 == 5) {
                                                                                    qQFaceImageAttr2.src("1770946116", 0);
                                                                                }
                                                                                return Unit.INSTANCE;
                                                                            }
                                                                            qQFaceImageAttr2.src(jubaoCompleteView9.model.getPostData().evilUin, 0);
                                                                            return Unit.INSTANCE;
                                                                        }
                                                                    });
                                                                    return Unit.INSTANCE;
                                                                }
                                                            });
                                                        }
                                                        final OperateData operateData7 = OperateData.this;
                                                        final JubaoCompleteView jubaoCompleteView9 = jubaoCompleteView7;
                                                        cg.a(vVar8, new Function1<TextView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.jubao.JubaoCompleteView.body.1.3.2.4.3.3.3.4
                                                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                            {
                                                                super(1);
                                                            }

                                                            @Override // kotlin.jvm.functions.Function1
                                                            public final Unit invoke(TextView textView) {
                                                                final OperateData operateData8 = OperateData.this;
                                                                final JubaoCompleteView jubaoCompleteView10 = jubaoCompleteView9;
                                                                textView.attr(new Function1<ce, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.jubao.JubaoCompleteView.body.1.3.2.4.3.3.3.4.1

                                                                    /* compiled from: P */
                                                                    @DebugMetadata(c = "com.tencent.hippykotlin.demo.pages.jubao.JubaoCompleteView$body$1$3$2$4$3$3$3$4$1$1", f = "JubaoCompleteView.kt", i = {}, l = {360}, m = "invokeSuspend", n = {}, s = {})
                                                                    /* renamed from: com.tencent.hippykotlin.demo.pages.jubao.JubaoCompleteView$body$1$3$2$4$3$3$3$4$1$1, reason: invalid class name and collision with other inner class name */
                                                                    /* loaded from: classes31.dex */
                                                                    public final class C19221 extends SuspendLambda implements Function2<com.tencent.kuikly.core.coroutines.b, Continuation<? super Unit>, Object> {
                                                                        public final /* synthetic */ ce $this_attr;
                                                                        public final /* synthetic */ JubaoCompleteView $view;
                                                                        public int label;

                                                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                                        public C19221(JubaoCompleteView jubaoCompleteView, ce ceVar, Continuation<? super C19221> continuation) {
                                                                            super(2, continuation);
                                                                            this.$view = jubaoCompleteView;
                                                                            this.$this_attr = ceVar;
                                                                        }

                                                                        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                                                                        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                                                                            return new C19221(this.$view, this.$this_attr, continuation);
                                                                        }

                                                                        @Override // kotlin.jvm.functions.Function2
                                                                        public final Object invoke(com.tencent.kuikly.core.coroutines.b bVar, Continuation<? super Unit> continuation) {
                                                                            return ((C19221) create(bVar, continuation)).invokeSuspend(Unit.INSTANCE);
                                                                        }

                                                                        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                                                                        public final Object invokeSuspend(Object obj) {
                                                                            Object coroutine_suspended;
                                                                            int i3;
                                                                            coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                                                                            int i16 = this.label;
                                                                            int i17 = 6;
                                                                            if (i16 == 0) {
                                                                                ResultKt.throwOnFailure(obj);
                                                                                Friends friends = VasModule.Companion.getInstance().getFriends();
                                                                                String str = this.$view.model.getPostData().evilUin;
                                                                                this.label = 1;
                                                                                obj = Friends.getFriendOrGroupName$default(friends, str, false, this, 6);
                                                                                if (obj == coroutine_suspended) {
                                                                                    return coroutine_suspended;
                                                                                }
                                                                            } else if (i16 == 1) {
                                                                                ResultKt.throwOnFailure(obj);
                                                                            } else {
                                                                                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                                                                            }
                                                                            String str2 = (String) obj;
                                                                            if (str2.length() == 0) {
                                                                                str2 = this.$view.model.getPostData().evilUin;
                                                                                if (str2 != null && str2.length() > 4) {
                                                                                    int length = str2.length();
                                                                                    StringBuilder sb5 = new StringBuilder();
                                                                                    if (length <= 5) {
                                                                                        i17 = 4;
                                                                                        i3 = 1;
                                                                                    } else if (length <= 9) {
                                                                                        i3 = (length - 5) / 2;
                                                                                        i17 = 5;
                                                                                    } else {
                                                                                        i3 = (length - 6) / 2;
                                                                                    }
                                                                                    int i18 = i3 > 0 ? i3 : 1;
                                                                                    String substring = str2.substring(0, i18);
                                                                                    Intrinsics.checkNotNullExpressionValue(substring, "this as java.lang.String\u2026ing(startIndex, endIndex)");
                                                                                    sb5.append(substring);
                                                                                    for (int i19 = 0; i19 < i17; i19++) {
                                                                                        sb5.append("*");
                                                                                    }
                                                                                    int i26 = i18 + i17;
                                                                                    if (i26 < length) {
                                                                                        String substring2 = str2.substring(i26);
                                                                                        Intrinsics.checkNotNullExpressionValue(substring2, "this as java.lang.String).substring(startIndex)");
                                                                                        sb5.append(substring2);
                                                                                    }
                                                                                    str2 = sb5.toString();
                                                                                } else if (str2 == null) {
                                                                                    str2 = "";
                                                                                }
                                                                            }
                                                                            this.$this_attr.text(str2);
                                                                            return Unit.INSTANCE;
                                                                        }
                                                                    }

                                                                    /* compiled from: P */
                                                                    @DebugMetadata(c = "com.tencent.hippykotlin.demo.pages.jubao.JubaoCompleteView$body$1$3$2$4$3$3$3$4$1$2", f = "JubaoCompleteView.kt", i = {}, l = {369}, m = "invokeSuspend", n = {}, s = {})
                                                                    /* renamed from: com.tencent.hippykotlin.demo.pages.jubao.JubaoCompleteView$body$1$3$2$4$3$3$3$4$1$2, reason: invalid class name */
                                                                    /* loaded from: classes31.dex */
                                                                    public final class AnonymousClass2 extends SuspendLambda implements Function2<com.tencent.kuikly.core.coroutines.b, Continuation<? super Unit>, Object> {
                                                                        public final /* synthetic */ ce $this_attr;
                                                                        public final /* synthetic */ JubaoCompleteView $view;
                                                                        public ce L$0;
                                                                        public int label;

                                                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                                        public AnonymousClass2(ce ceVar, JubaoCompleteView jubaoCompleteView, Continuation<? super AnonymousClass2> continuation) {
                                                                            super(2, continuation);
                                                                            this.$this_attr = ceVar;
                                                                            this.$view = jubaoCompleteView;
                                                                        }

                                                                        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                                                                        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                                                                            return new AnonymousClass2(this.$this_attr, this.$view, continuation);
                                                                        }

                                                                        @Override // kotlin.jvm.functions.Function2
                                                                        public final Object invoke(com.tencent.kuikly.core.coroutines.b bVar, Continuation<? super Unit> continuation) {
                                                                            return ((AnonymousClass2) create(bVar, continuation)).invokeSuspend(Unit.INSTANCE);
                                                                        }

                                                                        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                                                                        public final Object invokeSuspend(Object obj) {
                                                                            Object coroutine_suspended;
                                                                            ce ceVar;
                                                                            coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                                                                            int i3 = this.label;
                                                                            if (i3 == 0) {
                                                                                ResultKt.throwOnFailure(obj);
                                                                                ce ceVar2 = this.$this_attr;
                                                                                Friends friends = VasModule.Companion.getInstance().getFriends();
                                                                                String str = this.$view.model.getPostData().groupCode;
                                                                                this.L$0 = ceVar2;
                                                                                this.label = 1;
                                                                                Object friendOrGroupName$default = Friends.getFriendOrGroupName$default(friends, str, true, this, 4);
                                                                                if (friendOrGroupName$default == coroutine_suspended) {
                                                                                    return coroutine_suspended;
                                                                                }
                                                                                ceVar = ceVar2;
                                                                                obj = friendOrGroupName$default;
                                                                            } else if (i3 == 1) {
                                                                                ceVar = this.L$0;
                                                                                ResultKt.throwOnFailure(obj);
                                                                            } else {
                                                                                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                                                                            }
                                                                            ceVar.text((String) obj);
                                                                            return Unit.INSTANCE;
                                                                        }
                                                                    }

                                                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                                    {
                                                                        super(1);
                                                                    }

                                                                    /* JADX WARN: Code restructure failed: missing block: B:9:0x0029, code lost:
                                                                    
                                                                        if (r5 != 6) goto L16;
                                                                     */
                                                                    @Override // kotlin.jvm.functions.Function1
                                                                    /*
                                                                        Code decompiled incorrectly, please refer to instructions dump.
                                                                    */
                                                                    public final Unit invoke(ce ceVar) {
                                                                        ce ceVar2 = ceVar;
                                                                        ceVar2.color(JubaoThemeData.INSTANCE.getContentTextColor());
                                                                        ce.fontSize$default(ceVar2, 14.0f, null, 2, null);
                                                                        ceVar2.fontWeight400();
                                                                        OperateData operateData9 = OperateData.this;
                                                                        int i16 = operateData9.subType;
                                                                        if (i16 != 1) {
                                                                            if (i16 == 2) {
                                                                                BuildersKt.e(com.tencent.kuikly.core.coroutines.e.f117232d, null, null, new AnonymousClass2(ceVar2, jubaoCompleteView10, null), 3, null);
                                                                            } else if (i16 == 4) {
                                                                                ceVar2.text(operateData9.desc);
                                                                            } else if (i16 == 5) {
                                                                                ceVar2.text("QQ\u5b89\u5168\u4e2d\u5fc3");
                                                                            }
                                                                            ceVar2.marginLeft(12.0f);
                                                                            ceVar2.alignSelfCenter();
                                                                            ceVar2.m144maxWidth(JubaoCompleteView.access$getItemWidth(jubaoCompleteView10) - 158);
                                                                            ceVar2.lines(1);
                                                                            return Unit.INSTANCE;
                                                                        }
                                                                        BuildersKt.e(com.tencent.kuikly.core.coroutines.e.f117232d, null, null, new C19221(jubaoCompleteView10, ceVar2, null), 3, null);
                                                                        ceVar2.marginLeft(12.0f);
                                                                        ceVar2.alignSelfCenter();
                                                                        ceVar2.m144maxWidth(JubaoCompleteView.access$getItemWidth(jubaoCompleteView10) - 158);
                                                                        ceVar2.lines(1);
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
                            }
                        }
                        w.a(vVar2, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.jubao.JubaoCompleteView.body.1.3.2.5
                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(v vVar3) {
                                vVar3.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.jubao.JubaoCompleteView.body.1.3.2.5.1
                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(t tVar) {
                                        tVar.mo141height(20.0f);
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
        return jubaoAnimationView$body$1;
    }
}

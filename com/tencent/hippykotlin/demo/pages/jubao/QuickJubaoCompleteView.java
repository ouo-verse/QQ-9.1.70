package com.tencent.hippykotlin.demo.pages.jubao;

import c01.c;
import com.tencent.biz.pubaccount.util.api.impl.PublicAccountMessageUtilImpl;
import com.tencent.hippykotlin.demo.pages.activity.blind_box.jiguangshang.view.BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2;
import com.tencent.hippykotlin.demo.pages.activity.blind_box.yifanshang.detail.view.YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.base.BridgeModule;
import com.tencent.hippykotlin.demo.pages.base.EcommerceExtKt;
import com.tencent.hippykotlin.demo.pages.vas_base.VasModule;
import com.tencent.hippykotlin.demo.pages.vas_base.misc.VasUIToken;
import com.tencent.hippykotlin.demo.pages.vas_base.native_api.Friends;
import com.tencent.kuikly.core.base.BorderStyle;
import com.tencent.kuikly.core.base.ViewContainer;
import com.tencent.kuikly.core.base.attr.b;
import com.tencent.kuikly.core.base.event.ClickParams;
import com.tencent.kuikly.core.base.h;
import com.tencent.kuikly.core.base.k;
import com.tencent.kuikly.core.coroutines.BuildersKt;
import com.tencent.kuikly.core.directives.ConditionView;
import com.tencent.kuikly.core.directives.ConditionViewKt;
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
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.properties.ReadWriteProperty;
import kotlin.reflect.KProperty;
import org.apache.httpcore.message.TokenParser;

/* compiled from: P */
/* loaded from: classes31.dex */
public final class QuickJubaoCompleteView extends JubaoAnimationView {
    public static final /* synthetic */ KProperty<Object>[] $$delegatedProperties = {YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0.m(QuickJubaoCompleteView.class, "curChooseReason", "getCurChooseReason()Ljava/lang/String;", 0)};
    public Function0<Unit> closeCallback;
    public final ReadWriteProperty curChooseReason$delegate = c.a("");
    public final PageModel model;
    public Function1<? super UpdateReasonData, Unit> onUpdateReasonSelectCallback;
    public Function1<? super OperateData, Unit> operateCallback;

    public QuickJubaoCompleteView(PageModel pageModel) {
        this.model = pageModel;
    }

    public static final float access$getItemWidth(QuickJubaoCompleteView quickJubaoCompleteView) {
        return quickJubaoCompleteView.getPagerData().m() - 32;
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x0034 A[ORIG_RETURN, RETURN] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final boolean access$isEnableStyle(QuickJubaoCompleteView quickJubaoCompleteView, OperateData operateData) {
        quickJubaoCompleteView.getClass();
        int i3 = operateData.subType;
        if (i3 != 1 && i3 != 2) {
            if (i3 == 5) {
                return !quickJubaoCompleteView.model.isFollowAccount();
            }
            if (i3 != 6) {
                return true;
            }
        }
        if (!quickJubaoCompleteView.model.isBlackFriend() && !quickJubaoCompleteView.model.isQuitGroup() && !quickJubaoCompleteView.model.isDeleteFriend()) {
            return true;
        }
    }

    @Override // com.tencent.hippykotlin.demo.pages.jubao.JubaoAnimationView, com.tencent.kuikly.core.base.ComposeView
    public final Function1<ViewContainer<?, ?>, Unit> body() {
        JubaoAnimationView$body$1 jubaoAnimationView$body$1 = new JubaoAnimationView$body$1(this);
        attr(new Function1<k, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.jubao.QuickJubaoCompleteView$body$1$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Unit invoke(k kVar) {
                e jubaoDTBaseParams = ConstantsKt.getJubaoDTBaseParams();
                QuickJubaoCompleteView quickJubaoCompleteView = QuickJubaoCompleteView.this;
                jubaoDTBaseParams.v("come_from", quickJubaoCompleteView.model.getPostData().src);
                jubaoDTBaseParams.v("strategyid", quickJubaoCompleteView.model.getPostData().grayId);
                Unit unit = Unit.INSTANCE;
                EcommerceExtKt.elementVR(kVar, "em_safe_report_completion", jubaoDTBaseParams);
                return Unit.INSTANCE;
            }
        });
        w.a(this, JubaoUtil$O3BgView$1.INSTANCE);
        JubaoNavBarKt.JubaoNavBar(this, new Function1<JubaoNavBar, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.jubao.QuickJubaoCompleteView$body$1$2
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Unit invoke(JubaoNavBar jubaoNavBar) {
                JubaoNavBar jubaoNavBar2 = jubaoNavBar;
                jubaoNavBar2.setBarData(new NavBarData("\u4e3e\u62a5\u5b8c\u6210", false, true));
                final QuickJubaoCompleteView quickJubaoCompleteView = QuickJubaoCompleteView.this;
                jubaoNavBar2.backClickCallback = new Function0<Unit>() { // from class: com.tencent.hippykotlin.demo.pages.jubao.QuickJubaoCompleteView$body$1$2.1
                    {
                        super(0);
                    }

                    @Override // kotlin.jvm.functions.Function0
                    public final Unit invoke() {
                        Function0<Unit> function0 = QuickJubaoCompleteView.this.closeCallback;
                        if (function0 != null) {
                            function0.invoke();
                        }
                        return Unit.INSTANCE;
                    }
                };
                return Unit.INSTANCE;
            }
        });
        ah.a(this, new Function1<ImageView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.jubao.QuickJubaoCompleteView$body$1$3
            @Override // kotlin.jvm.functions.Function1
            public final Unit invoke(ImageView imageView) {
                imageView.attr(new Function1<af, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.jubao.QuickJubaoCompleteView$body$1$3.1
                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(af afVar) {
                        af afVar2 = afVar;
                        afVar2.marginTop(24.0f);
                        afVar2.mo141height(68.0f);
                        afVar2.mo153width(68.0f);
                        b.a.b(afVar2, "data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAAMAAAADACAMAAABlApw1AAAAP1BMVEUAAAAAnP8AnP8Aov8Am/8Amv8Amv8AnP8Anf8AnP8AnP8Anf8Anf8Anf8Amv8AnP8AnP8Anv8Anv8Amv8AnP+pj+R8AAAAFHRSTlMA798QIDBgoL9wkGDPUECvgH9AgNuOj9cAAAcoSURBVHja5V3XkqMwEFREARNs8//fenWhPMLCWLpRGGr7cctedzNRIDSsPKSenDeLFYJvf8CFsNasbtKS0YbUzlu+nYBb7x6MJOTob1sibn5SjBLkw4stEzczMRqQDrwmE8vY3RBytBsKduwZ2A/PNzS46RTV0tmtEMTImkPe+Wc+1qzDNCsl/31W6XkaVmPF56+YttGgPP+U5ofTaqWnj4WioQRljn3ZJVLQwyIQEqo4j3WaZUE720nCAX3r5H8Zcog1CMfq4iFQ7GMNt0hCzQItl3e/9zNDQpt2fuT4G/2nLJITBtGkLChb72cGUd8IE9/TB98pJKGuEaSvbORIgpdF3UdEvl8Bz52RRUE3Gnf/eYn+c50Sz4uZ+Y5wfpQf3Sskfy9ZVcjnztiysPuLmVXHLIoGghKNLj9AmoIKNA+CyrFs4Eu+0Dj+2GuBtzvXqPSJjyd85hj/m/8GeLLGeOIV6A3gWHO40IuQ/s9n1gETRylQApkI8NACFCgMf8VaA09CUuC/V5CXBRcS/HcKlqz+kwh/UJDXmw5h+HeG5vnlQMF3CDxFmYNUlB3AjhGAyw1kH/QPJABdhc8LgIURwQIunRP2gsxjaSkywsC8Ptv9CeJRWrFfHYhWAMeB7FIdyDBS8C/HkOcORC8AIAwSUsv0stTMiGFOoiaIVYBDJxInoULVgfZOtH6P4JERxPw1jg3RDAQF+dwEimIJC6H4OUFDOIL/Yj11EQVRThUQx+rIAKQj+K3R8Zc0QFCouLykAYJUusbarmCAExMMlzBAwNNd0wCM8eOVzeMiBghqwXwcwkSLMEDyo0wqOe0uKISHMD4Ije53Er9jPvJ2++9vN3YB2DiM1WVCeLfskuBBlwnh35BxKVjAKN0g7zfO7aj+y4cIeJAW6Q8U3Xsemvp7kOYZy0H5XstMdw8C/kks7Fstu/W7Gwr8AXOyDwlIoh2rGPBPvo56n0injo0o8AesaS0pZB3f94EM8E/3ZLMLglvPJAr8c+4ru13r0ycEYv4ZnqwgCGAtwxkGeP5ZxYgHF90hqkAF/kNWR+qCGPbsO6jw35G2yY9g6fBnQ+A2PDWGCfF/lTIedEbsCyjxB9aS6bTsRYs/3MfSbEpKQtT4B5Hrkm6oUOPPzCuPriktFDn+L9qemYROiB7/Vx41KWWAIP9X6C4vATNLx2PhG7djP/7QwVnIR/l3J63sxR/6UfESoP5jU+lNNucfC+DQWad/FRT04Q+lmLPsTsJskYL2/BnwzhZw2yIFOP6tBWwAUIDg31yAiBSg+LcXYLZIAYJ/BwHzFitozh8E5KdR5g8UNOcPaTS/kDFzoADPH1+JcQra8oeFZNDMIRWg+COauQXaaaSClvxhJRwuaPAK8PzzFzQelpRoBe34w0o4XNTjFTTjD4v6wJlKKGjFH1bCQT4qoqARf1hIBjfpyihow58B6+jmLlZBE/5wcxe8aWSFFDTgD5EbPeAopCDmX5L/nrQDMaUUoPhnP2ICdyqnoDJ/CNw5fFagCiqoyx/2GkR7PYopqMkfOqHbLiAMK6igJn/YYuZ3cjgrqKAmf6jD0/6BmUYoaMpfv4WtKLDhybTiH+/1gCCwDAHTjD9UAfN+p0eiFDTjr97f75a8yKY504g/7NM92EmKgmnCH+guR7uRUTBN+MNO76PdyDiYBvzjnd54HwKY6vyh9bFHoma0gur8NXjQ4YspWJi6/OEHuDx5MQUDU5U/hLBJeMUP+ZZOOf4J3m6jlhR75qZVrACSX5l0RV+C0HOteSHDJ56SX+NdRPGR5kr2SIwQQxDClzTB2TvpnsCrQBkGiKEoH+txYgCAgVpAFPfzkzsUv8rBGNsHgiu508Eyj06RnHQqHb4fn7hSjmM41sMlRLln5HBPeclmpntE1SPtsLyFqhPJxOPXJCfqRCb1AFRH/aC8r42OpXjOE5Qwk/BZemEgRc4JuhPl4zrHvE19d0YCsNvc/4wja5nilOoZuDRXP+XYZsaeFA/Ofv6ko8uvf3j85Y/vZ0xxSgMUhMKNsJhYBzw4eggHlSEim0asont1FXfMgx5QQGGQDh9+7igjSAT9hklxjb4WANNmnJePx3ldaaDaQ5zwx4+0u1c2gvRb+czxbDB3FC5/jRFcA28z/FWBsc/SJ36wZp2qJu9ngzV/+GjTutNfwfmrto/KtBnvW3GbQjwIWRX0fUTJR8x3NxrtOx7oN2gbJxFt88aYQcKw92bF3kUSNjsqHHsAz6ldeD/CD9rHTi3HSwCIZUwUoZwBv8eXeLwEALd+OlMh9egtP/6qb0MfJIjtE4Q16zg9tJL/aCv1mMbVWPgKwnnKlwU8rJOsC2bD8ey5n1k/yMEiL/7Q/UmcGpb/vfbWdWf/D5O55bIXfqbC/i/U5JNF3Hx/xznG7KI0HxUKp4mSD6rV5FZjrRD8H2sh7GK8m2pQ/wWz+tlSD3viEgAAAABJRU5ErkJggg==", false, 2, null);
                        afVar2.alignSelfCenter();
                        return Unit.INSTANCE;
                    }
                });
                return Unit.INSTANCE;
            }
        });
        cg.a(this, new Function1<TextView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.jubao.QuickJubaoCompleteView$body$1$4
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Unit invoke(TextView textView) {
                final QuickJubaoCompleteView quickJubaoCompleteView = QuickJubaoCompleteView.this;
                textView.attr(new Function1<ce, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.jubao.QuickJubaoCompleteView$body$1$4.1
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(ce ceVar) {
                        ce ceVar2 = ceVar;
                        ceVar2.fontWeight400();
                        ceVar2.color(JubaoThemeData.INSTANCE.getContentTextColor());
                        ceVar2.mo153width(QuickJubaoCompleteView.access$getItemWidth(QuickJubaoCompleteView.this));
                        ceVar2.marginTop(24.0f);
                        ce.fontSize$default(ceVar2, 14.0f, null, 2, null);
                        ceVar2.text("\u9884\u8ba148\u5c0f\u65f6\u4e4b\u5185\u5b8c\u6210\u5ba1\u6838\uff0c\u5e76\u5c06\u7ed3\u679c\u901a\u8fc7QQ\u5b89\u5168\u4e2d\u5fc3\u8ba2\u9605\u53f7\u53cd\u9988\u7ed9\u4f60\u3002");
                        ceVar2.alignSelfCenter();
                        return Unit.INSTANCE;
                    }
                });
                return Unit.INSTANCE;
            }
        });
        ConditionViewKt.c(this, new Function0<Object>() { // from class: com.tencent.hippykotlin.demo.pages.jubao.QuickJubaoCompleteView$body$1$5
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return Boolean.valueOf(QuickJubaoCompleteView.this.model.getOperateStatus() == 8);
            }
        }, new Function1<ConditionView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.jubao.QuickJubaoCompleteView$body$1$6
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Unit invoke(ConditionView conditionView) {
                ConditionView conditionView2 = conditionView;
                cg.a(conditionView2, new Function1<TextView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.jubao.QuickJubaoCompleteView$body$1$6.1
                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(TextView textView) {
                        textView.attr(new Function1<ce, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.jubao.QuickJubaoCompleteView.body.1.6.1.1
                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(ce ceVar) {
                                ce ceVar2 = ceVar;
                                ceVar2.marginLeft(16.0f);
                                ceVar2.marginTop(16.0f);
                                ce.fontSize$default(ceVar2, 17.0f, null, 2, null);
                                ceVar2.marginTop(16.0f);
                                ceVar2.fontWeight500();
                                ceVar2.text("\u66f4\u591a\u5b89\u5168\u64cd\u4f5c\u5efa\u8bae");
                                ceVar2.color(JubaoThemeData.INSTANCE.getTitleTextColor());
                                return Unit.INSTANCE;
                            }
                        });
                        return Unit.INSTANCE;
                    }
                });
                final QuickJubaoCompleteView quickJubaoCompleteView = QuickJubaoCompleteView.this;
                bo.a(conditionView2, new Function1<ScrollerView<?, ?>, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.jubao.QuickJubaoCompleteView$body$1$6.2
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(ScrollerView<?, ?> scrollerView) {
                        int i3;
                        ScrollerView<?, ?> scrollerView2 = scrollerView;
                        scrollerView2.attr(new Function1<ScrollerAttr, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.jubao.QuickJubaoCompleteView.body.1.6.2.1
                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(ScrollerAttr scrollerAttr) {
                                ScrollerAttr scrollerAttr2 = scrollerAttr;
                                scrollerAttr2.m140flex(1.0f);
                                scrollerAttr2.flexDirectionColumn();
                                scrollerAttr2.marginTop(20.0f);
                                scrollerAttr2.showScrollerIndicator(false);
                                return Unit.INSTANCE;
                            }
                        });
                        ArrayList<OperateData> arrayList = QuickJubaoCompleteView.this.model.operatesData;
                        ArrayList arrayList2 = new ArrayList();
                        Iterator<T> it = arrayList.iterator();
                        while (true) {
                            if (!it.hasNext()) {
                                break;
                            }
                            Object next = it.next();
                            int i16 = ((OperateData) next).type;
                            if (((i16 == 3 || i16 == 1) ? 1 : 0) != 0) {
                                arrayList2.add(next);
                            }
                        }
                        ArrayList<OperateData> arrayList3 = QuickJubaoCompleteView.this.model.operatesData;
                        ArrayList arrayList4 = new ArrayList();
                        for (Object obj : arrayList3) {
                            if (((OperateData) obj).type == 2) {
                                arrayList4.add(obj);
                            }
                        }
                        final QuickJubaoCompleteView quickJubaoCompleteView2 = QuickJubaoCompleteView.this;
                        Iterator it5 = arrayList2.iterator();
                        while (it5.hasNext()) {
                            Object next2 = it5.next();
                            int i17 = i3 + 1;
                            if (i3 < 0) {
                                CollectionsKt__CollectionsKt.throwIndexOverflow();
                            }
                            final OperateData operateData = (OperateData) next2;
                            w.a(scrollerView2, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.jubao.QuickJubaoCompleteView$body$1$6$2$2$1
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                {
                                    super(1);
                                }

                                @Override // kotlin.jvm.functions.Function1
                                public final Unit invoke(v vVar) {
                                    v vVar2 = vVar;
                                    vVar2.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.jubao.QuickJubaoCompleteView$body$1$6$2$2$1.1
                                        @Override // kotlin.jvm.functions.Function1
                                        public final Unit invoke(t tVar) {
                                            t tVar2 = tVar;
                                            tVar2.flexDirectionRow();
                                            tVar2.marginLeft(16.0f);
                                            tVar2.marginRight(16.0f);
                                            tVar2.marginBottom(12.0f);
                                            return Unit.INSTANCE;
                                        }
                                    });
                                    final OperateData operateData2 = OperateData.this;
                                    final QuickJubaoCompleteView quickJubaoCompleteView3 = quickJubaoCompleteView2;
                                    w.a(vVar2, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.jubao.QuickJubaoCompleteView$body$1$6$2$2$1.2
                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                        {
                                            super(1);
                                        }

                                        @Override // kotlin.jvm.functions.Function1
                                        public final Unit invoke(v vVar3) {
                                            v vVar4 = vVar3;
                                            vVar4.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.jubao.QuickJubaoCompleteView.body.1.6.2.2.1.2.1
                                                @Override // kotlin.jvm.functions.Function1
                                                public final Unit invoke(t tVar) {
                                                    tVar.flexDirectionColumn();
                                                    return Unit.INSTANCE;
                                                }
                                            });
                                            final OperateData operateData3 = OperateData.this;
                                            cg.a(vVar4, new Function1<TextView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.jubao.QuickJubaoCompleteView.body.1.6.2.2.1.2.2
                                                {
                                                    super(1);
                                                }

                                                @Override // kotlin.jvm.functions.Function1
                                                public final Unit invoke(TextView textView) {
                                                    final OperateData operateData4 = OperateData.this;
                                                    textView.attr(new Function1<ce, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.jubao.QuickJubaoCompleteView.body.1.6.2.2.1.2.2.1
                                                        {
                                                            super(1);
                                                        }

                                                        @Override // kotlin.jvm.functions.Function1
                                                        public final Unit invoke(ce ceVar) {
                                                            ce ceVar2 = ceVar;
                                                            ce.fontSize$default(ceVar2, 14.0f, null, 2, null);
                                                            ceVar2.color(JubaoThemeData.INSTANCE.getItemViewTextColor());
                                                            ceVar2.text(OperateData.this.title);
                                                            ceVar2.fontWeight400();
                                                            return Unit.INSTANCE;
                                                        }
                                                    });
                                                    return Unit.INSTANCE;
                                                }
                                            });
                                            final QuickJubaoCompleteView quickJubaoCompleteView4 = quickJubaoCompleteView3;
                                            final OperateData operateData4 = OperateData.this;
                                            cg.a(vVar4, new Function1<TextView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.jubao.QuickJubaoCompleteView.body.1.6.2.2.1.2.3
                                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                {
                                                    super(1);
                                                }

                                                @Override // kotlin.jvm.functions.Function1
                                                public final Unit invoke(TextView textView) {
                                                    final QuickJubaoCompleteView quickJubaoCompleteView5 = QuickJubaoCompleteView.this;
                                                    final OperateData operateData5 = operateData4;
                                                    textView.attr(new Function1<ce, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.jubao.QuickJubaoCompleteView.body.1.6.2.2.1.2.3.1

                                                        /* compiled from: P */
                                                        @DebugMetadata(c = "com.tencent.hippykotlin.demo.pages.jubao.QuickJubaoCompleteView$body$1$6$2$2$1$2$3$1$1", f = "QuickJubaoCompleteView.kt", i = {}, l = {154}, m = "invokeSuspend", n = {}, s = {})
                                                        /* renamed from: com.tencent.hippykotlin.demo.pages.jubao.QuickJubaoCompleteView$body$1$6$2$2$1$2$3$1$1, reason: invalid class name and collision with other inner class name */
                                                        /* loaded from: classes31.dex */
                                                        public final class C19831 extends SuspendLambda implements Function2<com.tencent.kuikly.core.coroutines.b, Continuation<? super Unit>, Object> {
                                                            public final /* synthetic */ ce $this_attr;
                                                            public final /* synthetic */ QuickJubaoCompleteView $view;
                                                            public int label;

                                                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                            public C19831(QuickJubaoCompleteView quickJubaoCompleteView, ce ceVar, Continuation<? super C19831> continuation) {
                                                                super(2, continuation);
                                                                this.$view = quickJubaoCompleteView;
                                                                this.$this_attr = ceVar;
                                                            }

                                                            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                                                            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                                                                return new C19831(this.$view, this.$this_attr, continuation);
                                                            }

                                                            @Override // kotlin.jvm.functions.Function2
                                                            public final Object invoke(com.tencent.kuikly.core.coroutines.b bVar, Continuation<? super Unit> continuation) {
                                                                return ((C19831) create(bVar, continuation)).invokeSuspend(Unit.INSTANCE);
                                                            }

                                                            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                                                            public final Object invokeSuspend(Object obj) {
                                                                Object coroutine_suspended;
                                                                int i3;
                                                                coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                                                                int i16 = this.label;
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
                                                                ((BridgeModule) com.tencent.kuikly.core.manager.c.f117352a.g().acquireModule("HRBridgeModule")).log("getFriendOrGroupName complete " + str2 + TokenParser.SP + str2.length());
                                                                if (str2.length() == 0) {
                                                                    str2 = this.$view.model.getPostData().evilUin;
                                                                    if (str2 != null) {
                                                                        int i17 = 4;
                                                                        if (str2.length() > 4) {
                                                                            int length = str2.length();
                                                                            StringBuilder sb5 = new StringBuilder();
                                                                            if (length <= 5) {
                                                                                i3 = 1;
                                                                            } else if (length <= 9) {
                                                                                i3 = (length - 5) / 2;
                                                                                i17 = 5;
                                                                            } else {
                                                                                i17 = 6;
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
                                                                            ((BridgeModule) com.tencent.kuikly.core.manager.c.f117352a.g().acquireModule("HRBridgeModule")).log("getFriendOrGroupName mask is " + str2 + TokenParser.SP + str2.length());
                                                                        }
                                                                    }
                                                                    if (str2 == null) {
                                                                        str2 = "";
                                                                    }
                                                                    ((BridgeModule) com.tencent.kuikly.core.manager.c.f117352a.g().acquireModule("HRBridgeModule")).log("getFriendOrGroupName mask is " + str2 + TokenParser.SP + str2.length());
                                                                }
                                                                this.$this_attr.text(str2);
                                                                return Unit.INSTANCE;
                                                            }
                                                        }

                                                        /* compiled from: P */
                                                        @DebugMetadata(c = "com.tencent.hippykotlin.demo.pages.jubao.QuickJubaoCompleteView$body$1$6$2$2$1$2$3$1$2", f = "QuickJubaoCompleteView.kt", i = {}, l = {170}, m = "invokeSuspend", n = {}, s = {})
                                                        /* renamed from: com.tencent.hippykotlin.demo.pages.jubao.QuickJubaoCompleteView$body$1$6$2$2$1$2$3$1$2, reason: invalid class name and collision with other inner class name */
                                                        /* loaded from: classes31.dex */
                                                        public final class C19842 extends SuspendLambda implements Function2<com.tencent.kuikly.core.coroutines.b, Continuation<? super Unit>, Object> {
                                                            public final /* synthetic */ ce $this_attr;
                                                            public final /* synthetic */ QuickJubaoCompleteView $view;
                                                            public ce L$0;
                                                            public int label;

                                                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                            public C19842(ce ceVar, QuickJubaoCompleteView quickJubaoCompleteView, Continuation<? super C19842> continuation) {
                                                                super(2, continuation);
                                                                this.$this_attr = ceVar;
                                                                this.$view = quickJubaoCompleteView;
                                                            }

                                                            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                                                            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                                                                return new C19842(this.$this_attr, this.$view, continuation);
                                                            }

                                                            @Override // kotlin.jvm.functions.Function2
                                                            public final Object invoke(com.tencent.kuikly.core.coroutines.b bVar, Continuation<? super Unit> continuation) {
                                                                return ((C19842) create(bVar, continuation)).invokeSuspend(Unit.INSTANCE);
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

                                                        /* JADX WARN: Code restructure failed: missing block: B:15:0x0044, code lost:
                                                        
                                                            if (r4 != 6) goto L19;
                                                         */
                                                        @Override // kotlin.jvm.functions.Function1
                                                        /*
                                                            Code decompiled incorrectly, please refer to instructions dump.
                                                        */
                                                        public final Unit invoke(ce ceVar) {
                                                            ce ceVar2 = ceVar;
                                                            ceVar2.marginTop(4.0f);
                                                            ce.fontSize$default(ceVar2, 12.0f, null, 2, null);
                                                            ceVar2.fontWeight400();
                                                            ceVar2.m144maxWidth(QuickJubaoCompleteView.access$getItemWidth(QuickJubaoCompleteView.this) - 158);
                                                            ceVar2.lines(1);
                                                            ceVar2.color(JubaoThemeData.INSTANCE.getContentTextColor());
                                                            OperateData operateData6 = operateData5;
                                                            if (operateData6.type == 1) {
                                                                ceVar2.text(operateData6.desc);
                                                            } else {
                                                                int i18 = operateData6.subType;
                                                                if (i18 != 1) {
                                                                    if (i18 == 2) {
                                                                        BuildersKt.e(com.tencent.kuikly.core.coroutines.e.f117232d, null, null, new C19842(ceVar2, QuickJubaoCompleteView.this, null), 3, null);
                                                                    } else if (i18 == 4) {
                                                                        ceVar2.text(operateData6.desc);
                                                                    } else if (i18 == 5) {
                                                                        ceVar2.text("QQ\u5b89\u5168\u4e2d\u5fc3");
                                                                    }
                                                                }
                                                                BridgeModule bridgeModule = (BridgeModule) com.tencent.kuikly.core.manager.c.f117352a.g().acquireModule("HRBridgeModule");
                                                                StringBuilder m3 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("start getFriendOrGroupName ");
                                                                m3.append(QuickJubaoCompleteView.this.model.getPostData().evilUin);
                                                                bridgeModule.log(m3.toString());
                                                                BuildersKt.e(com.tencent.kuikly.core.coroutines.e.f117232d, null, null, new C19831(QuickJubaoCompleteView.this, ceVar2, null), 3, null);
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
                                    final QuickJubaoCompleteView quickJubaoCompleteView4 = quickJubaoCompleteView2;
                                    final OperateData operateData3 = OperateData.this;
                                    w.a(vVar2, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.jubao.QuickJubaoCompleteView$body$1$6$2$2$1.3
                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                        {
                                            super(1);
                                        }

                                        @Override // kotlin.jvm.functions.Function1
                                        public final Unit invoke(v vVar3) {
                                            v vVar4 = vVar3;
                                            vVar4.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.jubao.QuickJubaoCompleteView.body.1.6.2.2.1.3.1
                                                @Override // kotlin.jvm.functions.Function1
                                                public final Unit invoke(t tVar) {
                                                    t tVar2 = tVar;
                                                    tVar2.m140flex(1.0f);
                                                    tVar2.flexDirection(FlexDirection.ROW_REVERSE);
                                                    tVar2.alignSelfCenter();
                                                    return Unit.INSTANCE;
                                                }
                                            });
                                            final QuickJubaoCompleteView quickJubaoCompleteView5 = QuickJubaoCompleteView.this;
                                            final OperateData operateData4 = operateData3;
                                            w.a(vVar4, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.jubao.QuickJubaoCompleteView.body.1.6.2.2.1.3.2
                                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                {
                                                    super(1);
                                                }

                                                @Override // kotlin.jvm.functions.Function1
                                                public final Unit invoke(v vVar5) {
                                                    v vVar6 = vVar5;
                                                    final QuickJubaoCompleteView quickJubaoCompleteView6 = QuickJubaoCompleteView.this;
                                                    final OperateData operateData5 = operateData4;
                                                    vVar6.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.jubao.QuickJubaoCompleteView.body.1.6.2.2.1.3.2.1
                                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                        {
                                                            super(1);
                                                        }

                                                        @Override // kotlin.jvm.functions.Function1
                                                        public final Unit invoke(t tVar) {
                                                            h hVar;
                                                            String str;
                                                            t tVar2 = tVar;
                                                            tVar2.mo141height(32.0f);
                                                            tVar2.allCenter();
                                                            BorderStyle borderStyle = BorderStyle.SOLID;
                                                            if (QuickJubaoCompleteView.access$isEnableStyle(QuickJubaoCompleteView.this, operateData5)) {
                                                                hVar = JubaoThemeData.INSTANCE.getButtonBorderSecondaryDefault();
                                                            } else {
                                                                JubaoThemeData jubaoThemeData = JubaoThemeData.INSTANCE;
                                                                if (!VasUIToken.INSTANCE.isDarkMode()) {
                                                                    hVar = new h(2160905420L);
                                                                } else {
                                                                    hVar = new h(2151497021L);
                                                                }
                                                            }
                                                            tVar2.m136border(new com.tencent.kuikly.core.base.e(1.0f, borderStyle, hVar));
                                                            tVar2.borderRadius(16.0f);
                                                            if (operateData5.type == 1) {
                                                                e jubaoDTBaseParams = ConstantsKt.getJubaoDTBaseParams();
                                                                OperateData operateData6 = operateData5;
                                                                jubaoDTBaseParams.v("activity_id", operateData6.title);
                                                                jubaoDTBaseParams.v(PublicAccountMessageUtilImpl.ITEM_STRUCT_FIRST_LEVEL_NAME, operateData6.btnText);
                                                                Unit unit = Unit.INSTANCE;
                                                                EcommerceExtKt.elementVR(tVar2, "em_safe_tipoff_module_first_kind", jubaoDTBaseParams);
                                                            } else {
                                                                e jubaoDTBaseParams2 = ConstantsKt.getJubaoDTBaseParams();
                                                                OperateData operateData7 = operateData5;
                                                                jubaoDTBaseParams2.v("activity_id", operateData7.title);
                                                                int i18 = operateData7.subType;
                                                                if (i18 == 1) {
                                                                    str = "\u53bb\u62c9\u9ed1";
                                                                } else if (i18 == 2) {
                                                                    str = "\u53bb\u9000\u51fa";
                                                                } else if (i18 == 4) {
                                                                    str = "\u53bb\u52a0\u5165";
                                                                } else if (i18 == 5) {
                                                                    str = "\u53bb\u5173\u6ce8";
                                                                } else if (i18 != 6) {
                                                                    str = "";
                                                                } else {
                                                                    str = "\u53bb\u5220\u9664";
                                                                }
                                                                jubaoDTBaseParams2.v(PublicAccountMessageUtilImpl.ITEM_STRUCT_FIRST_LEVEL_NAME, str);
                                                                Unit unit2 = Unit.INSTANCE;
                                                                EcommerceExtKt.elementVR(tVar2, "em_safe_tipoff_module_third_kind", jubaoDTBaseParams2);
                                                            }
                                                            return Unit.INSTANCE;
                                                        }
                                                    });
                                                    final QuickJubaoCompleteView quickJubaoCompleteView7 = QuickJubaoCompleteView.this;
                                                    final OperateData operateData6 = operateData4;
                                                    vVar6.event(new Function1<u, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.jubao.QuickJubaoCompleteView.body.1.6.2.2.1.3.2.2
                                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                        {
                                                            super(1);
                                                        }

                                                        @Override // kotlin.jvm.functions.Function1
                                                        public final Unit invoke(u uVar) {
                                                            final QuickJubaoCompleteView quickJubaoCompleteView8 = QuickJubaoCompleteView.this;
                                                            final OperateData operateData7 = operateData6;
                                                            uVar.click(new Function1<ClickParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.jubao.QuickJubaoCompleteView.body.1.6.2.2.1.3.2.2.1
                                                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                                {
                                                                    super(1);
                                                                }

                                                                @Override // kotlin.jvm.functions.Function1
                                                                public final Unit invoke(ClickParams clickParams) {
                                                                    Function1<? super OperateData, Unit> function1 = QuickJubaoCompleteView.this.operateCallback;
                                                                    if (function1 != null) {
                                                                        function1.invoke(operateData7);
                                                                    }
                                                                    return Unit.INSTANCE;
                                                                }
                                                            });
                                                            return Unit.INSTANCE;
                                                        }
                                                    });
                                                    final QuickJubaoCompleteView quickJubaoCompleteView8 = QuickJubaoCompleteView.this;
                                                    final OperateData operateData7 = operateData4;
                                                    cg.a(vVar6, new Function1<TextView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.jubao.QuickJubaoCompleteView.body.1.6.2.2.1.3.2.3
                                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                        {
                                                            super(1);
                                                        }

                                                        @Override // kotlin.jvm.functions.Function1
                                                        public final Unit invoke(TextView textView) {
                                                            final QuickJubaoCompleteView quickJubaoCompleteView9 = QuickJubaoCompleteView.this;
                                                            final OperateData operateData8 = operateData7;
                                                            textView.attr(new Function1<ce, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.jubao.QuickJubaoCompleteView.body.1.6.2.2.1.3.2.3.1
                                                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                                {
                                                                    super(1);
                                                                }

                                                                @Override // kotlin.jvm.functions.Function1
                                                                public final Unit invoke(ce ceVar) {
                                                                    h hVar;
                                                                    ce ceVar2 = ceVar;
                                                                    ceVar2.marginLeft(16.0f);
                                                                    ceVar2.marginRight(16.0f);
                                                                    ce.fontSize$default(ceVar2, 14.0f, null, 2, null);
                                                                    if (QuickJubaoCompleteView.access$isEnableStyle(QuickJubaoCompleteView.this, operateData8)) {
                                                                        hVar = JubaoThemeData.INSTANCE.getButtonTextSecondaryDefault();
                                                                    } else {
                                                                        JubaoThemeData jubaoThemeData = JubaoThemeData.INSTANCE;
                                                                        if (!VasUIToken.INSTANCE.isDarkMode()) {
                                                                            hVar = new h(1291845632L);
                                                                        } else {
                                                                            hVar = new h(1307635956L);
                                                                        }
                                                                    }
                                                                    ceVar2.color(hVar);
                                                                    OperateData operateData9 = operateData8;
                                                                    if (operateData9.type == 1) {
                                                                        ceVar2.text(operateData9.btnText);
                                                                    } else {
                                                                        int i18 = operateData9.subType;
                                                                        if (i18 != 1) {
                                                                            if (i18 != 2) {
                                                                                if (i18 == 4) {
                                                                                    ceVar2.text("\u53bb\u52a0\u5165");
                                                                                } else if (i18 != 5) {
                                                                                    if (i18 == 6) {
                                                                                        if (!QuickJubaoCompleteView.this.model.isDeleteFriend()) {
                                                                                            ceVar2.text("\u53bb\u5220\u9664");
                                                                                        } else {
                                                                                            ceVar2.text("\u5df2\u5220\u9664");
                                                                                        }
                                                                                    }
                                                                                } else if (!QuickJubaoCompleteView.this.model.isFollowAccount()) {
                                                                                    ceVar2.text("\u53bb\u5173\u6ce8");
                                                                                } else {
                                                                                    ceVar2.text("\u5df2\u5173\u6ce8");
                                                                                }
                                                                            } else if (!QuickJubaoCompleteView.this.model.isQuitGroup()) {
                                                                                ceVar2.text("\u53bb\u9000\u51fa");
                                                                            } else {
                                                                                ceVar2.text("\u5df2\u9000\u51fa");
                                                                            }
                                                                        } else if (!QuickJubaoCompleteView.this.model.isBlackFriend()) {
                                                                            ceVar2.text("\u53bb\u62c9\u9ed1");
                                                                        } else {
                                                                            ceVar2.text("\u5df2\u62c9\u9ed1");
                                                                        }
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
                            if (i3 < arrayList2.size() - 1) {
                                w.a(scrollerView2, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.jubao.QuickJubaoCompleteView$body$1$6$2$2$2
                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(v vVar) {
                                        vVar.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.jubao.QuickJubaoCompleteView$body$1$6$2$2$2.1
                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(t tVar) {
                                                t tVar2 = tVar;
                                                tVar2.marginLeft(16.0f);
                                                tVar2.marginRight(16.0f);
                                                tVar2.mo113backgroundColor(JubaoThemeData.INSTANCE.getPartingLineColor());
                                                tVar2.mo141height(0.5f);
                                                tVar2.marginBottom(12.0f);
                                                return Unit.INSTANCE;
                                            }
                                        });
                                        return Unit.INSTANCE;
                                    }
                                });
                            }
                            i3 = i17;
                        }
                        final QuickJubaoCompleteView quickJubaoCompleteView3 = QuickJubaoCompleteView.this;
                        Iterator it6 = arrayList4.iterator();
                        while (it6.hasNext()) {
                            final OperateData operateData2 = (OperateData) it6.next();
                            ah.a(scrollerView2, new Function1<ImageView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.jubao.QuickJubaoCompleteView$body$1$6$2$3$1
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                {
                                    super(1);
                                }

                                @Override // kotlin.jvm.functions.Function1
                                public final Unit invoke(ImageView imageView) {
                                    ImageView imageView2 = imageView;
                                    final QuickJubaoCompleteView quickJubaoCompleteView4 = QuickJubaoCompleteView.this;
                                    final OperateData operateData3 = operateData2;
                                    imageView2.attr(new Function1<af, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.jubao.QuickJubaoCompleteView$body$1$6$2$3$1.1
                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                        {
                                            super(1);
                                        }

                                        @Override // kotlin.jvm.functions.Function1
                                        public final Unit invoke(af afVar) {
                                            af afVar2 = afVar;
                                            afVar2.mo153width(QuickJubaoCompleteView.access$getItemWidth(QuickJubaoCompleteView.this));
                                            afVar2.mo141height((QuickJubaoCompleteView.this.getPagerData().m() - 32) * 0.3411f);
                                            afVar2.alignSelfCenter();
                                            afVar2.borderRadius(8.0f);
                                            b.a.b(afVar2, operateData3.picUrl, false, 2, null);
                                            afVar2.marginTop(12.0f);
                                            e jubaoDTBaseParams = ConstantsKt.getJubaoDTBaseParams();
                                            jubaoDTBaseParams.v("activity_id", operateData3.title);
                                            Unit unit = Unit.INSTANCE;
                                            EcommerceExtKt.elementVR(afVar2, "em_safe_tipoff_module_second_kind", jubaoDTBaseParams);
                                            return Unit.INSTANCE;
                                        }
                                    });
                                    final QuickJubaoCompleteView quickJubaoCompleteView5 = QuickJubaoCompleteView.this;
                                    final OperateData operateData4 = operateData2;
                                    imageView2.event(new Function1<ImageEvent, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.jubao.QuickJubaoCompleteView$body$1$6$2$3$1.2
                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                        {
                                            super(1);
                                        }

                                        @Override // kotlin.jvm.functions.Function1
                                        public final Unit invoke(ImageEvent imageEvent) {
                                            final QuickJubaoCompleteView quickJubaoCompleteView6 = QuickJubaoCompleteView.this;
                                            final OperateData operateData5 = operateData4;
                                            imageEvent.click(new Function1<ClickParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.jubao.QuickJubaoCompleteView.body.1.6.2.3.1.2.1
                                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                {
                                                    super(1);
                                                }

                                                @Override // kotlin.jvm.functions.Function1
                                                public final Unit invoke(ClickParams clickParams) {
                                                    Function1<? super OperateData, Unit> function1 = QuickJubaoCompleteView.this.operateCallback;
                                                    if (function1 != null) {
                                                        function1.invoke(operateData5);
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
                        }
                        w.a(scrollerView2, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.jubao.QuickJubaoCompleteView.body.1.6.2.4
                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(v vVar) {
                                vVar.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.jubao.QuickJubaoCompleteView.body.1.6.2.4.1
                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(t tVar) {
                                        tVar.mo141height(34.0f);
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
        ConditionViewKt.a(this, new Function1<ConditionView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.jubao.QuickJubaoCompleteView$body$1$7
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Unit invoke(ConditionView conditionView) {
                ConditionView conditionView2 = conditionView;
                cg.a(conditionView2, new Function1<TextView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.jubao.QuickJubaoCompleteView$body$1$7.1
                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(TextView textView) {
                        textView.attr(new Function1<ce, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.jubao.QuickJubaoCompleteView.body.1.7.1.1
                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(ce ceVar) {
                                ce ceVar2 = ceVar;
                                ceVar2.marginLeft(16.0f);
                                ceVar2.marginTop(16.0f);
                                ce.fontSize$default(ceVar2, 17.0f, null, 2, null);
                                ceVar2.fontWeight500();
                                ceVar2.text("\u8865\u5145\u4e3e\u62a5\u539f\u56e0");
                                return Unit.INSTANCE;
                            }
                        });
                        return Unit.INSTANCE;
                    }
                });
                final QuickJubaoCompleteView quickJubaoCompleteView = QuickJubaoCompleteView.this;
                bo.a(conditionView2, new Function1<ScrollerView<?, ?>, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.jubao.QuickJubaoCompleteView$body$1$7.2
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(ScrollerView<?, ?> scrollerView) {
                        ScrollerView<?, ?> scrollerView2 = scrollerView;
                        scrollerView2.attr(new Function1<ScrollerAttr, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.jubao.QuickJubaoCompleteView.body.1.7.2.1
                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(ScrollerAttr scrollerAttr) {
                                ScrollerAttr scrollerAttr2 = scrollerAttr;
                                scrollerAttr2.m140flex(1.0f);
                                scrollerAttr2.flexDirectionColumn();
                                scrollerAttr2.showScrollerIndicator(false);
                                scrollerAttr2.scrollEnable(false);
                                return Unit.INSTANCE;
                            }
                        });
                        final QuickJubaoCompleteView quickJubaoCompleteView2 = QuickJubaoCompleteView.this;
                        w.a(scrollerView2, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.jubao.QuickJubaoCompleteView.body.1.7.2.2
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(v vVar) {
                                v vVar2 = vVar;
                                vVar2.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.jubao.QuickJubaoCompleteView.body.1.7.2.2.1
                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(t tVar) {
                                        t tVar2 = tVar;
                                        tVar2.flexDirection(FlexDirection.ROW);
                                        tVar2.flexWrapWrap();
                                        tVar2.marginTop(20.0f);
                                        tVar2.marginLeft(12.0f);
                                        return Unit.INSTANCE;
                                    }
                                });
                                final QuickJubaoCompleteView quickJubaoCompleteView3 = QuickJubaoCompleteView.this;
                                Iterator<UpdateReasonData> it = quickJubaoCompleteView3.model.updateReasonList.iterator();
                                while (it.hasNext()) {
                                    final UpdateReasonData next = it.next();
                                    w.a(vVar2, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.jubao.QuickJubaoCompleteView$body$1$7$2$2$2$1
                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                        {
                                            super(1);
                                        }

                                        @Override // kotlin.jvm.functions.Function1
                                        public final Unit invoke(v vVar3) {
                                            v vVar4 = vVar3;
                                            final UpdateReasonData updateReasonData = UpdateReasonData.this;
                                            final QuickJubaoCompleteView quickJubaoCompleteView4 = quickJubaoCompleteView3;
                                            vVar4.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.jubao.QuickJubaoCompleteView$body$1$7$2$2$2$1.1
                                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                {
                                                    super(1);
                                                }

                                                @Override // kotlin.jvm.functions.Function1
                                                public final Unit invoke(t tVar) {
                                                    h hVar;
                                                    t tVar2 = tVar;
                                                    tVar2.mo141height(28.0f);
                                                    String str = UpdateReasonData.this.desc;
                                                    QuickJubaoCompleteView quickJubaoCompleteView5 = quickJubaoCompleteView4;
                                                    if (!Intrinsics.areEqual(str, (String) quickJubaoCompleteView5.curChooseReason$delegate.getValue(quickJubaoCompleteView5, QuickJubaoCompleteView.$$delegatedProperties[0]))) {
                                                        JubaoThemeData jubaoThemeData = JubaoThemeData.INSTANCE;
                                                        if (!VasUIToken.INSTANCE.isDarkMode()) {
                                                            hVar = new h(1305267404L);
                                                        } else {
                                                            hVar = new h(2570927421L);
                                                        }
                                                        tVar2.mo113backgroundColor(hVar);
                                                    } else {
                                                        tVar2.mo113backgroundColor(JubaoThemeData.INSTANCE.getConfirmBtnBgColor());
                                                    }
                                                    tVar2.marginRight(8.0f);
                                                    tVar2.marginLeft(4.0f);
                                                    tVar2.marginBottom(12.0f);
                                                    tVar2.borderRadius(8.0f);
                                                    tVar2.allCenter();
                                                    return Unit.INSTANCE;
                                                }
                                            });
                                            final UpdateReasonData updateReasonData2 = UpdateReasonData.this;
                                            final QuickJubaoCompleteView quickJubaoCompleteView5 = quickJubaoCompleteView3;
                                            cg.a(vVar4, new Function1<TextView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.jubao.QuickJubaoCompleteView$body$1$7$2$2$2$1.2
                                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                {
                                                    super(1);
                                                }

                                                @Override // kotlin.jvm.functions.Function1
                                                public final Unit invoke(TextView textView) {
                                                    final UpdateReasonData updateReasonData3 = UpdateReasonData.this;
                                                    final QuickJubaoCompleteView quickJubaoCompleteView6 = quickJubaoCompleteView5;
                                                    textView.attr(new Function1<ce, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.jubao.QuickJubaoCompleteView.body.1.7.2.2.2.1.2.1
                                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                        {
                                                            super(1);
                                                        }

                                                        @Override // kotlin.jvm.functions.Function1
                                                        public final Unit invoke(ce ceVar) {
                                                            ce ceVar2 = ceVar;
                                                            ce.fontSize$default(ceVar2, 12.0f, null, 2, null);
                                                            ceVar2.fontWeight400();
                                                            String str = UpdateReasonData.this.desc;
                                                            QuickJubaoCompleteView quickJubaoCompleteView7 = quickJubaoCompleteView6;
                                                            if (!Intrinsics.areEqual(str, (String) quickJubaoCompleteView7.curChooseReason$delegate.getValue(quickJubaoCompleteView7, QuickJubaoCompleteView.$$delegatedProperties[0]))) {
                                                                ceVar2.color(JubaoThemeData.INSTANCE.getItemViewTextColor());
                                                            } else {
                                                                ceVar2.color(JubaoThemeData.INSTANCE.getConfirmBtnTextColor());
                                                            }
                                                            ceVar2.marginRight(12.0f);
                                                            ceVar2.marginLeft(12.0f);
                                                            ceVar2.text(UpdateReasonData.this.desc);
                                                            return Unit.INSTANCE;
                                                        }
                                                    });
                                                    return Unit.INSTANCE;
                                                }
                                            });
                                            final QuickJubaoCompleteView quickJubaoCompleteView6 = quickJubaoCompleteView3;
                                            final UpdateReasonData updateReasonData3 = UpdateReasonData.this;
                                            vVar4.event(new Function1<u, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.jubao.QuickJubaoCompleteView$body$1$7$2$2$2$1.3
                                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                {
                                                    super(1);
                                                }

                                                @Override // kotlin.jvm.functions.Function1
                                                public final Unit invoke(u uVar) {
                                                    final QuickJubaoCompleteView quickJubaoCompleteView7 = QuickJubaoCompleteView.this;
                                                    final UpdateReasonData updateReasonData4 = updateReasonData3;
                                                    uVar.click(new Function1<ClickParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.jubao.QuickJubaoCompleteView.body.1.7.2.2.2.1.3.1
                                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                        {
                                                            super(1);
                                                        }

                                                        @Override // kotlin.jvm.functions.Function1
                                                        public final Unit invoke(ClickParams clickParams) {
                                                            QuickJubaoCompleteView quickJubaoCompleteView8 = QuickJubaoCompleteView.this;
                                                            quickJubaoCompleteView8.curChooseReason$delegate.setValue(quickJubaoCompleteView8, QuickJubaoCompleteView.$$delegatedProperties[0], updateReasonData4.desc);
                                                            Function1<? super UpdateReasonData, Unit> function1 = QuickJubaoCompleteView.this.onUpdateReasonSelectCallback;
                                                            if (function1 != null) {
                                                                function1.invoke(updateReasonData4);
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
        ConditionViewKt.c(this, new Function0<Object>() { // from class: com.tencent.hippykotlin.demo.pages.jubao.QuickJubaoCompleteView$body$1$8
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return Boolean.valueOf(QuickJubaoCompleteView.this.model.getOperateStatus() == 5 || QuickJubaoCompleteView.this.model.getOperateStatus() == 6);
            }
        }, new Function1<ConditionView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.jubao.QuickJubaoCompleteView$body$1$9
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Unit invoke(ConditionView conditionView) {
                final QuickJubaoCompleteView quickJubaoCompleteView = QuickJubaoCompleteView.this;
                conditionView.addChild(new JubaoSubmitLoading(), new Function1<JubaoSubmitLoading, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.jubao.QuickJubaoCompleteView$body$1$9.1
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(JubaoSubmitLoading jubaoSubmitLoading) {
                        final QuickJubaoCompleteView quickJubaoCompleteView2 = QuickJubaoCompleteView.this;
                        jubaoSubmitLoading.attr(new Function1<JubaoSubmitLoadingAttr, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.jubao.QuickJubaoCompleteView.body.1.9.1.1
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(JubaoSubmitLoadingAttr jubaoSubmitLoadingAttr) {
                                JubaoSubmitLoadingAttr jubaoSubmitLoadingAttr2 = jubaoSubmitLoadingAttr;
                                if (QuickJubaoCompleteView.this.model.getOperateStatus() == 5) {
                                    jubaoSubmitLoadingAttr2.setText("\u63d0\u4ea4\u4e2d");
                                    jubaoSubmitLoadingAttr2.setIcon("data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAAEAAAABACAMAAACdt4HsAAAAhFBMVEUAAAD///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////8g2+bRAAAALHRSTlMAtHlcjt2kZ4GI5azENj+abc/8ci/VvzrKEpT2nmLy7roc6gdVRBcMJyBPSXMoR70AAAMTSURBVFjDnZbbdqowEEAHAgZaQJQoRsWKotz+///OzABHbb0E9lNXV/d2aKIOvOWcCimFaNNKwyQakUkp4ySx7bipTa1zXl+BuQoKxBywPS9R2khPo8tFAVE/Bjzfaz4mrmGaRtGlzf9MQAHfscNPPgeGEdI+YCPsI55+N79SWIiwoICp2rYQGGCfA9utc3kdKCnAI+QPc6k2pgD78/m8eTcBj5CS/0hdcID8/V6+LNRcyM/wBF3QAOTPZv7LQq5UxfrThOABZoiEaYRO539/Z/BAWSmz66599pHm4Z8XIupqVPA635rd/7lKuQAmlD7piH93zmnKhbNRQW/RJ5rbA0RcUGDGdUb68WiVwy8iBBMaDGnYX6/FcHsiLlRgjI86MoygL1w4mweuFupBEGTD9bhgooYRCNSR490F1jCG0kJ9s9komIq9QRabZHJAoY5YMJn1gljlkwPearFCmsmBZsXYkwOVy2zpVtR6QqB0GQvKqCiKKccZcCCAUBDVhMAXAwUHovGB7z4gmMuUwOkuUEy4SScGHyFDJgQWP8QCmow5jw4ciJ8ALlkmET3WV7vDDgszSCUz+hzFckfYUElm9DHsl8SugRLtOI7l2IBL+nJZ4ywxk4/zoyXj0o/sJ+24wLwL7OkDNU6IeNRB1rsdByJAJAfsdNQAO4SegEjRRhJt7ueHw44QQJxjmxHmge3hQImvGpjUZrzQ1Bf4JqCEDx3nfhO1teEDuKcfSqxq6AnJRxJt5G9OJy6Iu5k8xjc5y/KIHyNUWMANbbPv+7H++PoW+lRwH+5uyDqt8/qDH7hfLhckPNB67DuOH77zxcJ10UcS+EVBPrEV+uXL71foc8KBP8Ts8zqdPU2UMsAvwy5gwROKzud9OqvgF8rDL/Qh4MBT2n4A3ugdGdX/F+nWPtJCMhRseEHk9wPs+4167vi4XPNC1geQjXi3ST8GLOK47gsLLsxyeEfok38LHG8BLgQCPqALh/whgP5dIJAlfEanTucPgWMfWKNuSCWdLkB0ge9EwSh0WNjOnAKzuRe3V3jBP+3SUNMfKha+AAAAAElFTkSuQmCC");
                                    jubaoSubmitLoadingAttr2.setShowAnimation(true);
                                } else {
                                    jubaoSubmitLoadingAttr2.setText("\u8865\u5145\u6210\u529f");
                                    jubaoSubmitLoadingAttr2.setIcon("data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAAFAAAABQBAMAAAB8P++eAAAAD1BMVEUAAAD///////////////+PQt5oAAAABHRSTlMAX38wWg1aggAAAH1JREFUSMftzLkNgEAMBVGOBkCiAAIK2BYWuf+aSFaacJyACDyhv/Wmqqp+3pp9PM7c3xx3EoxoOTB6FtwKfAdsSXDpSfAaZwPXcReQQUAWAZkEZBOQUUBWAZkFhDQQ0kBIQCEBhQQUch+gkgEoJKCQgEICCjlAbZ+qqvq0B5FRJNyrh4AbAAAAAElFTkSuQmCC");
                                    jubaoSubmitLoadingAttr2.setShowAnimation(false);
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
        return jubaoAnimationView$body$1;
    }
}

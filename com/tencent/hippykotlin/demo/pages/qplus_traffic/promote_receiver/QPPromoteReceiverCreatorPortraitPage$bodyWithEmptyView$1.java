package com.tencent.hippykotlin.demo.pages.qplus_traffic.promote_receiver;

import com.tencent.hippykotlin.demo.pages.base.extension.ImageAttrExtKt;
import com.tencent.hippykotlin.demo.pages.base.ktx.IPagerIdKtxKt;
import com.tencent.kuikly.core.base.ViewContainer;
import com.tencent.kuikly.core.base.h;
import com.tencent.kuikly.core.views.ImageView;
import com.tencent.kuikly.core.views.TextView;
import com.tencent.kuikly.core.views.af;
import com.tencent.kuikly.core.views.ah;
import com.tencent.kuikly.core.views.ce;
import com.tencent.kuikly.core.views.cg;
import com.tencent.kuikly.core.views.t;
import com.tencent.kuikly.core.views.v;
import com.tencent.kuikly.core.views.w;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

/* loaded from: classes31.dex */
public final class QPPromoteReceiverCreatorPortraitPage$bodyWithEmptyView$1 extends Lambda implements Function1<ViewContainer<?, ?>, Unit> {
    public static final QPPromoteReceiverCreatorPortraitPage$bodyWithEmptyView$1 INSTANCE = new QPPromoteReceiverCreatorPortraitPage$bodyWithEmptyView$1();

    @Override // kotlin.jvm.functions.Function1
    public final Unit invoke(ViewContainer<?, ?> viewContainer) {
        w.a(viewContainer, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qplus_traffic.promote_receiver.QPPromoteReceiverCreatorPortraitPage$bodyWithEmptyView$1.1
            @Override // kotlin.jvm.functions.Function1
            public final Unit invoke(v vVar) {
                v vVar2 = vVar;
                vVar2.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qplus_traffic.promote_receiver.QPPromoteReceiverCreatorPortraitPage.bodyWithEmptyView.1.1.1
                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(t tVar) {
                        t tVar2 = tVar;
                        tVar2.marginTop(120.0f);
                        tVar2.allCenter();
                        return Unit.INSTANCE;
                    }
                });
                ah.a(vVar2, new Function1<ImageView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qplus_traffic.promote_receiver.QPPromoteReceiverCreatorPortraitPage.bodyWithEmptyView.1.1.2
                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(ImageView imageView) {
                        imageView.attr(new Function1<af, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qplus_traffic.promote_receiver.QPPromoteReceiverCreatorPortraitPage.bodyWithEmptyView.1.1.2.1
                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(af afVar) {
                                af afVar2 = afVar;
                                afVar2.size(256.0f, 192.0f);
                                ImageAttrExtKt.urlToken$default(afVar2, "qecommerce_skin_emptystate_img_dongtai");
                                return Unit.INSTANCE;
                            }
                        });
                        return Unit.INSTANCE;
                    }
                });
                cg.a(vVar2, new Function1<TextView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qplus_traffic.promote_receiver.QPPromoteReceiverCreatorPortraitPage.bodyWithEmptyView.1.1.3
                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(TextView textView) {
                        textView.attr(new Function1<ce, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qplus_traffic.promote_receiver.QPPromoteReceiverCreatorPortraitPage.bodyWithEmptyView.1.1.3.1
                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(ce ceVar) {
                                h hVar;
                                ce ceVar2 = ceVar;
                                ceVar2.marginTop(16.0f);
                                hVar = IPagerIdKtxKt.getSkinColor(ceVar2).tokenColor("qecommerce_skin_color_text_primary", false);
                                ceVar2.color(hVar);
                                ce.fontSize$default(ceVar2, 17.0f, null, 2, null).fontWeightBold();
                                ceVar2.text("\u641c\u7d22\u7ed3\u679c\u4e3a\u7a7a");
                                return Unit.INSTANCE;
                            }
                        });
                        return Unit.INSTANCE;
                    }
                });
                cg.a(vVar2, new Function1<TextView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qplus_traffic.promote_receiver.QPPromoteReceiverCreatorPortraitPage.bodyWithEmptyView.1.1.4
                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(TextView textView) {
                        textView.attr(new Function1<ce, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qplus_traffic.promote_receiver.QPPromoteReceiverCreatorPortraitPage.bodyWithEmptyView.1.1.4.1
                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(ce ceVar) {
                                h hVar;
                                ce ceVar2 = ceVar;
                                ceVar2.marginTop(7.0f);
                                hVar = IPagerIdKtxKt.getSkinColor(ceVar2).tokenColor("qecommerce_skin_color_text_secondary", false);
                                ceVar2.color(hVar);
                                ce.fontSize$default(ceVar2, 14.0f, null, 2, null).fontWeight400();
                                ceVar2.fontFamily("PingFang SC");
                                ceVar2.text("\u6ca1\u6709\u641c\u7d22\u5230\u76f8\u5173\u7684\u5185\u5bb9");
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

    public QPPromoteReceiverCreatorPortraitPage$bodyWithEmptyView$1() {
        super(1);
    }
}

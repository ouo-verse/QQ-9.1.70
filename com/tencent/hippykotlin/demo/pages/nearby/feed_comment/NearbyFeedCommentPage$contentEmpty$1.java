package com.tencent.hippykotlin.demo.pages.nearby.feed_comment;

import com.tencent.hippykotlin.demo.pages.foundation.qui_token.QUIToken;
import com.tencent.hippykotlin.demo.pages.nearby.base.view.TextViewExtKt;
import com.tencent.kuikly.core.base.ViewContainer;
import com.tencent.kuikly.core.base.attr.b;
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
public final class NearbyFeedCommentPage$contentEmpty$1 extends Lambda implements Function1<ViewContainer<?, ?>, Unit> {
    public static final NearbyFeedCommentPage$contentEmpty$1 INSTANCE = new NearbyFeedCommentPage$contentEmpty$1();

    @Override // kotlin.jvm.functions.Function1
    public final Unit invoke(ViewContainer<?, ?> viewContainer) {
        w.a(viewContainer, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.feed_comment.NearbyFeedCommentPage$contentEmpty$1.1
            @Override // kotlin.jvm.functions.Function1
            public final Unit invoke(v vVar) {
                v vVar2 = vVar;
                vVar2.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.feed_comment.NearbyFeedCommentPage.contentEmpty.1.1.1
                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(t tVar) {
                        t tVar2 = tVar;
                        tVar2.m140flex(1.0f);
                        tVar2.allCenter();
                        return Unit.INSTANCE;
                    }
                });
                ah.a(vVar2, new Function1<ImageView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.feed_comment.NearbyFeedCommentPage.contentEmpty.1.1.2
                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(ImageView imageView) {
                        imageView.attr(new Function1<af, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.feed_comment.NearbyFeedCommentPage.contentEmpty.1.1.2.1
                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(af afVar) {
                                af afVar2 = afVar;
                                b.a.b(afVar2, "https://image.superqqshow.qq.com/wuji/qq_lplan/lplan_pic_resouce/3c6784d9_eBbVv6UNVeV.png", false, 2, null);
                                afVar2.size(80.0f, 80.0f);
                                afVar2.marginTop(12.0f);
                                afVar2.marginBottom(6.0f);
                                afVar2.t(QUIToken.color$default("icon_primary"));
                                afVar2.m147opacity(0.3f);
                                return Unit.INSTANCE;
                            }
                        });
                        return Unit.INSTANCE;
                    }
                });
                cg.a(vVar2, new Function1<TextView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.feed_comment.NearbyFeedCommentPage.contentEmpty.1.1.3
                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(TextView textView) {
                        textView.attr(new Function1<ce, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.feed_comment.NearbyFeedCommentPage.contentEmpty.1.1.3.1
                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(ce ceVar) {
                                ce ceVar2 = ceVar;
                                TextViewExtKt.textWithLineHeightFix(ceVar2, "\u52a8\u6001\u4e0d\u5b58\u5728");
                                ceVar2.color(QUIToken.color$default("text_secondary_light"));
                                ce.fontSize$default(ceVar2, 14.0f, null, 2, null);
                                ceVar2.lineHeight(22.0f);
                                ceVar2.textAlignCenter();
                                ceVar2.marginBottom(60.0f);
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

    public NearbyFeedCommentPage$contentEmpty$1() {
        super(1);
    }
}

package com.tencent.hippykotlin.demo.pages.nearby.feed_comment;

import com.tencent.hippykotlin.demo.pages.activity.blind_box.jiguangshang.view.BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2;
import com.tencent.hippykotlin.demo.pages.foundation.qui_token.QUIToken;
import com.tencent.hippykotlin.demo.pages.nearby.base.view.TextViewExtKt;
import com.tencent.kuikly.core.base.ViewContainer;
import com.tencent.kuikly.core.views.TextView;
import com.tencent.kuikly.core.views.ce;
import com.tencent.kuikly.core.views.cg;
import com.tencent.kuikly.core.views.t;
import com.tencent.kuikly.core.views.v;
import com.tencent.kuikly.core.views.w;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

/* loaded from: classes31.dex */
public final class NearbyFeedCommentPage$contentHeader$1 extends Lambda implements Function1<ViewContainer<?, ?>, Unit> {
    public final /* synthetic */ NearbyFeedCommentPage this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public NearbyFeedCommentPage$contentHeader$1(NearbyFeedCommentPage nearbyFeedCommentPage) {
        super(1);
        this.this$0 = nearbyFeedCommentPage;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Unit invoke(ViewContainer<?, ?> viewContainer) {
        ViewContainer<?, ?> viewContainer2 = viewContainer;
        final NearbyFeedCommentPage nearbyFeedCommentPage = this.this$0;
        w.a(viewContainer2, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.feed_comment.NearbyFeedCommentPage$contentHeader$1.1
            @Override // kotlin.jvm.functions.Function1
            public final Unit invoke(v vVar) {
                v vVar2 = vVar;
                vVar2.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.feed_comment.NearbyFeedCommentPage.contentHeader.1.1.1
                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(t tVar) {
                        t tVar2 = tVar;
                        tVar2.mo141height(14.0f);
                        tVar2.allCenter();
                        return Unit.INSTANCE;
                    }
                });
                w.a(vVar2, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.feed_comment.NearbyFeedCommentPage.contentHeader.1.1.2
                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(v vVar3) {
                        vVar3.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.feed_comment.NearbyFeedCommentPage.contentHeader.1.1.2.1
                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(t tVar) {
                                t tVar2 = tVar;
                                tVar2.size(36.0f, 5.0f);
                                tVar2.mo113backgroundColor(QUIToken.color$default("icon_tertiary"));
                                tVar2.borderRadius(3.0f);
                                return Unit.INSTANCE;
                            }
                        });
                        return Unit.INSTANCE;
                    }
                });
                return Unit.INSTANCE;
            }
        });
        w.a(viewContainer2, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.feed_comment.NearbyFeedCommentPage$contentHeader$1.2
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Unit invoke(v vVar) {
                v vVar2 = vVar;
                vVar2.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.feed_comment.NearbyFeedCommentPage.contentHeader.1.2.1
                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(t tVar) {
                        t tVar2 = tVar;
                        tVar2.mo141height(40.0f);
                        tVar2.allCenter();
                        return Unit.INSTANCE;
                    }
                });
                final NearbyFeedCommentPage nearbyFeedCommentPage2 = NearbyFeedCommentPage.this;
                cg.a(vVar2, new Function1<TextView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.feed_comment.NearbyFeedCommentPage.contentHeader.1.2.2
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(TextView textView) {
                        final NearbyFeedCommentPage nearbyFeedCommentPage3 = NearbyFeedCommentPage.this;
                        textView.attr(new Function1<ce, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.feed_comment.NearbyFeedCommentPage.contentHeader.1.2.2.1
                            {
                                super(1);
                            }

                            /* JADX WARN: Code restructure failed: missing block: B:4:0x001b, code lost:
                            
                                if (((java.lang.Boolean) r0.firstPageLoaded$delegate.getValue(r0, com.tencent.hippykotlin.demo.pages.nearby.feed_comment.NearbyFeedCommentPageViewModel.$$delegatedProperties[3])).booleanValue() == true) goto L8;
                             */
                            @Override // kotlin.jvm.functions.Function1
                            /*
                                Code decompiled incorrectly, please refer to instructions dump.
                            */
                            public final Unit invoke(ce ceVar) {
                                boolean z16;
                                String str;
                                ce ceVar2 = ceVar;
                                NearbyFeedCommentPageViewModel nearbyFeedCommentPageViewModel = NearbyFeedCommentPage.this.pageVm;
                                if (nearbyFeedCommentPageViewModel != null) {
                                    z16 = true;
                                }
                                z16 = false;
                                if (z16) {
                                    NearbyFeedCommentPageViewModel nearbyFeedCommentPageViewModel2 = NearbyFeedCommentPage.this.pageVm;
                                    if ((nearbyFeedCommentPageViewModel2 != null ? ((Number) nearbyFeedCommentPageViewModel2.commentCount$delegate.getValue(nearbyFeedCommentPageViewModel2, NearbyFeedCommentPageViewModel.$$delegatedProperties[2])).intValue() : 0) > 0) {
                                        StringBuilder m3 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("\u8bc4\u8bba ");
                                        NearbyFeedCommentPageViewModel nearbyFeedCommentPageViewModel3 = NearbyFeedCommentPage.this.pageVm;
                                        m3.append(nearbyFeedCommentPageViewModel3 != null ? Integer.valueOf(((Number) nearbyFeedCommentPageViewModel3.commentCount$delegate.getValue(nearbyFeedCommentPageViewModel3, NearbyFeedCommentPageViewModel.$$delegatedProperties[2])).intValue()) : null);
                                        str = m3.toString();
                                        TextViewExtKt.textWithLineHeightFix(ceVar2, str);
                                        ce.fontSize$default(ceVar2, 14.0f, null, 2, null);
                                        ceVar2.fontWeight500();
                                        ceVar2.color(QUIToken.color$default("text_primary"));
                                        return Unit.INSTANCE;
                                    }
                                }
                                str = "\u8bc4\u8bba";
                                TextViewExtKt.textWithLineHeightFix(ceVar2, str);
                                ce.fontSize$default(ceVar2, 14.0f, null, 2, null);
                                ceVar2.fontWeight500();
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
        w.a(viewContainer2, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.feed_comment.NearbyFeedCommentPage$contentHeader$1.3
            @Override // kotlin.jvm.functions.Function1
            public final Unit invoke(v vVar) {
                vVar.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.feed_comment.NearbyFeedCommentPage.contentHeader.1.3.1
                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(t tVar) {
                        t tVar2 = tVar;
                        tVar2.mo141height(0.5f);
                        tVar2.mo113backgroundColor(QUIToken.color$default("border_light"));
                        return Unit.INSTANCE;
                    }
                });
                return Unit.INSTANCE;
            }
        });
        return Unit.INSTANCE;
    }
}

package com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.template;

import com.tencent.hippykotlin.demo.pages.base.QQFaceImageAttr;
import com.tencent.hippykotlin.demo.pages.base.QQFaceImageView;
import com.tencent.hippykotlin.demo.pages.base.QQFaceImageViewKt;
import com.tencent.kuikly.core.base.ViewContainer;
import com.tencent.kuikly.core.base.attr.b;
import com.tencent.kuikly.core.views.ImageView;
import com.tencent.kuikly.core.views.af;
import com.tencent.kuikly.core.views.ah;
import com.tencent.kuikly.core.views.t;
import com.tencent.kuikly.core.views.v;
import com.tencent.kuikly.core.views.w;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

/* compiled from: P */
/* loaded from: classes32.dex */
public final class QSearchCommonItemTemplateView$buildAvatar$1 extends Lambda implements Function1<ViewContainer<?, ?>, Unit> {
    public final /* synthetic */ String $avatar;
    public final /* synthetic */ int $avatarType;
    public final /* synthetic */ QSearchCommonItemTemplateView $ctx;
    public final /* synthetic */ String $uin;
    public final /* synthetic */ int $uinType;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public QSearchCommonItemTemplateView$buildAvatar$1(int i3, QSearchCommonItemTemplateView qSearchCommonItemTemplateView, String str, String str2, int i16) {
        super(1);
        this.$avatarType = i3;
        this.$ctx = qSearchCommonItemTemplateView;
        this.$avatar = str;
        this.$uin = str2;
        this.$uinType = i16;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Unit invoke(ViewContainer<?, ?> viewContainer) {
        final int i3 = this.$avatarType;
        final QSearchCommonItemTemplateView qSearchCommonItemTemplateView = this.$ctx;
        final String str = this.$avatar;
        final String str2 = this.$uin;
        final int i16 = this.$uinType;
        w.a(viewContainer, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.template.QSearchCommonItemTemplateView$buildAvatar$1.1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Unit invoke(v vVar) {
                v vVar2 = vVar;
                vVar2.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.template.QSearchCommonItemTemplateView.buildAvatar.1.1.1
                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(t tVar) {
                        t tVar2 = tVar;
                        tVar2.marginRight(12.0f);
                        tVar2.size(48.0f, 48.0f);
                        tVar2.allCenter();
                        return Unit.INSTANCE;
                    }
                });
                if (i3 == 2) {
                    final QSearchCommonItemTemplateView qSearchCommonItemTemplateView2 = qSearchCommonItemTemplateView;
                    final String str3 = str;
                    final String str4 = str2;
                    final int i17 = i16;
                    int i18 = QSearchCommonItemTemplateView.$r8$clinit;
                    qSearchCommonItemTemplateView2.getClass();
                    new Function1<ViewContainer<?, ?>, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.template.QSearchCommonItemTemplateView$buildRectAvatar$1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(1);
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public final Unit invoke(ViewContainer<?, ?> viewContainer2) {
                            ViewContainer<?, ?> viewContainer3 = viewContainer2;
                            if (str3.length() > 0) {
                                final String str5 = str3;
                                ah.a(viewContainer3, new Function1<ImageView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.template.QSearchCommonItemTemplateView$buildRectAvatar$1.1
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(ImageView imageView) {
                                        final String str6 = str5;
                                        final float f16 = 52.0f;
                                        imageView.attr(new Function1<af, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.template.QSearchCommonItemTemplateView.buildRectAvatar.1.1.1
                                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                            {
                                                super(1);
                                            }

                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(af afVar) {
                                                af afVar2 = afVar;
                                                float f17 = f16;
                                                afVar2.size(f17, f17);
                                                b.a.b(afVar2, str6, false, 2, null);
                                                afVar2.borderRadius(4.0f);
                                                return Unit.INSTANCE;
                                            }
                                        });
                                        return Unit.INSTANCE;
                                    }
                                });
                            } else {
                                if (str4.length() > 0) {
                                    final int i19 = i17;
                                    final String str6 = str4;
                                    QQFaceImageViewKt.QQFaceImage(viewContainer3, new Function1<QQFaceImageView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.template.QSearchCommonItemTemplateView$buildRectAvatar$1.2
                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                        {
                                            super(1);
                                        }

                                        @Override // kotlin.jvm.functions.Function1
                                        public final Unit invoke(QQFaceImageView qQFaceImageView) {
                                            final int i26 = i19;
                                            final String str7 = str6;
                                            final float f16 = 52.0f;
                                            qQFaceImageView.attr(new Function1<QQFaceImageAttr, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.template.QSearchCommonItemTemplateView.buildRectAvatar.1.2.1
                                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                {
                                                    super(1);
                                                }

                                                @Override // kotlin.jvm.functions.Function1
                                                public final Unit invoke(QQFaceImageAttr qQFaceImageAttr) {
                                                    QQFaceImageAttr qQFaceImageAttr2 = qQFaceImageAttr;
                                                    float f17 = f16;
                                                    qQFaceImageAttr2.size(f17, f17);
                                                    qQFaceImageAttr2.src(str7, i26 != 1 ? 0 : 1);
                                                    qQFaceImageAttr2.borderRadius(4.0f);
                                                    return Unit.INSTANCE;
                                                }
                                            });
                                            return Unit.INSTANCE;
                                        }
                                    });
                                }
                            }
                            if (QSearchCommonItemTemplateView.access$getAttr(qSearchCommonItemTemplateView2).getData().littleIcon.length() > 0) {
                                final QSearchCommonItemTemplateView qSearchCommonItemTemplateView3 = qSearchCommonItemTemplateView2;
                                ah.a(viewContainer3, new Function1<ImageView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.template.QSearchCommonItemTemplateView$buildRectAvatar$1.3
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(ImageView imageView) {
                                        final QSearchCommonItemTemplateView qSearchCommonItemTemplateView4 = QSearchCommonItemTemplateView.this;
                                        final float f16 = 52.0f;
                                        imageView.attr(new Function1<af, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.template.QSearchCommonItemTemplateView.buildRectAvatar.1.3.1
                                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                            {
                                                super(1);
                                            }

                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(af afVar) {
                                                af afVar2 = afVar;
                                                afVar2.positionAbsolute();
                                                float f17 = 18;
                                                afVar2.m142left(f16 - f17);
                                                afVar2.m150top(f16 - f17);
                                                afVar2.size(24.0f, 24.0f);
                                                b.a.b(afVar2, QSearchCommonItemTemplateView.access$getAttr(qSearchCommonItemTemplateView4).getData().littleIcon, false, 2, null);
                                                return Unit.INSTANCE;
                                            }
                                        });
                                        return Unit.INSTANCE;
                                    }
                                });
                            }
                            return Unit.INSTANCE;
                        }
                    }.invoke(vVar2);
                } else {
                    QSearchCommonItemTemplateView qSearchCommonItemTemplateView3 = qSearchCommonItemTemplateView;
                    final String str5 = str;
                    final String str6 = str2;
                    final int i19 = i16;
                    int i26 = QSearchCommonItemTemplateView.$r8$clinit;
                    qSearchCommonItemTemplateView3.getClass();
                    new Function1<ViewContainer<?, ?>, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.template.QSearchCommonItemTemplateView$buildCircleAvatar$1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(1);
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public final Unit invoke(ViewContainer<?, ?> viewContainer2) {
                            ViewContainer<?, ?> viewContainer3 = viewContainer2;
                            if (str5.length() > 0) {
                                final String str7 = str5;
                                ah.a(viewContainer3, new Function1<ImageView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.template.QSearchCommonItemTemplateView$buildCircleAvatar$1.1
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(ImageView imageView) {
                                        final String str8 = str7;
                                        imageView.attr(new Function1<af, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.template.QSearchCommonItemTemplateView.buildCircleAvatar.1.1.1
                                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                            {
                                                super(1);
                                            }

                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(af afVar) {
                                                af afVar2 = afVar;
                                                afVar2.marginTop(2.0f);
                                                afVar2.size(52.0f, 52.0f);
                                                b.a.b(afVar2, str8, false, 2, null);
                                                afVar2.borderRadius(26.0f);
                                                return Unit.INSTANCE;
                                            }
                                        });
                                        return Unit.INSTANCE;
                                    }
                                });
                            } else {
                                if (str6.length() > 0) {
                                    final int i27 = i19;
                                    final String str8 = str6;
                                    QQFaceImageViewKt.QQFaceImage(viewContainer3, new Function1<QQFaceImageView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.template.QSearchCommonItemTemplateView$buildCircleAvatar$1.2
                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                        {
                                            super(1);
                                        }

                                        @Override // kotlin.jvm.functions.Function1
                                        public final Unit invoke(QQFaceImageView qQFaceImageView) {
                                            final int i28 = i27;
                                            final String str9 = str8;
                                            qQFaceImageView.attr(new Function1<QQFaceImageAttr, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.template.QSearchCommonItemTemplateView.buildCircleAvatar.1.2.1
                                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                {
                                                    super(1);
                                                }

                                                @Override // kotlin.jvm.functions.Function1
                                                public final Unit invoke(QQFaceImageAttr qQFaceImageAttr) {
                                                    QQFaceImageAttr qQFaceImageAttr2 = qQFaceImageAttr;
                                                    qQFaceImageAttr2.marginTop(2.0f);
                                                    qQFaceImageAttr2.size(52.0f, 52.0f);
                                                    qQFaceImageAttr2.src(str9, i28 != 1 ? 0 : 1);
                                                    qQFaceImageAttr2.borderRadius(26.0f);
                                                    return Unit.INSTANCE;
                                                }
                                            });
                                            return Unit.INSTANCE;
                                        }
                                    });
                                }
                            }
                            return Unit.INSTANCE;
                        }
                    }.invoke(vVar2);
                }
                return Unit.INSTANCE;
            }
        });
        return Unit.INSTANCE;
    }
}

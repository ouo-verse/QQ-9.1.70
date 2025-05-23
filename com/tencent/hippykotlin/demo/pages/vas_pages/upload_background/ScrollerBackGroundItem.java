package com.tencent.hippykotlin.demo.pages.vas_pages.upload_background;

import com.tencent.kuikly.core.base.Attr;
import com.tencent.kuikly.core.base.ComposeView;
import com.tencent.kuikly.core.base.ViewContainer;
import com.tencent.kuikly.core.base.attr.b;
import com.tencent.kuikly.core.base.event.Event;
import com.tencent.kuikly.core.base.f;
import com.tencent.kuikly.core.base.h;
import com.tencent.kuikly.core.base.k;
import com.tencent.kuikly.core.base.l;
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

/* compiled from: P */
/* loaded from: classes33.dex */
public final class ScrollerBackGroundItem extends ComposeView<k, l> {
    public final BackgroundStyleItemData data;
    public final String requiredPath = "https://qqvip-web.cdn-go.cn/cdn/latest/qqgxh/item-tag/5.png";
    public final String pickedImageUrl = "https://tianquan.gtimg.cn/shoal/vaclient/697e6ddd-cc24-48d1-923b-f795977e9bf6.png";

    public ScrollerBackGroundItem(BackgroundStyleItemData backgroundStyleItemData) {
        this.data = backgroundStyleItemData;
    }

    @Override // com.tencent.kuikly.core.base.ComposeView
    public final Function1<ViewContainer<?, ?>, Unit> body() {
        return new Function1<ViewContainer<?, ?>, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.vas_pages.upload_background.ScrollerBackGroundItem$body$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Unit invoke(ViewContainer<?, ?> viewContainer) {
                final ScrollerBackGroundItem scrollerBackGroundItem = ScrollerBackGroundItem.this;
                w.a(viewContainer, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.vas_pages.upload_background.ScrollerBackGroundItem$body$1.1
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(v vVar) {
                        v vVar2 = vVar;
                        vVar2.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.vas_pages.upload_background.ScrollerBackGroundItem.body.1.1.1
                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(t tVar) {
                                t tVar2 = tVar;
                                tVar2.flexDirectionColumn();
                                tVar2.m150top(3.0f);
                                tVar2.m142left(12.0f);
                                return Unit.INSTANCE;
                            }
                        });
                        final ScrollerBackGroundItem scrollerBackGroundItem2 = ScrollerBackGroundItem.this;
                        w.a(vVar2, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.vas_pages.upload_background.ScrollerBackGroundItem.body.1.1.2
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(v vVar3) {
                                v vVar4 = vVar3;
                                final ScrollerBackGroundItem scrollerBackGroundItem3 = ScrollerBackGroundItem.this;
                                vVar4.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.vas_pages.upload_background.ScrollerBackGroundItem.body.1.1.2.1
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(t tVar) {
                                        t tVar2 = tVar;
                                        tVar2.size(90.0f, 90.0f);
                                        if (ScrollerBackGroundItem.this.data.isFree) {
                                            tVar2.mo113backgroundColor(new h(240, 240, 240, 1.0f));
                                        } else {
                                            tVar2.mo113backgroundColor(new h(245, 245, 245, 0.5f));
                                        }
                                        tVar2.m137borderRadius(new f(10.0f, 10.0f, 10.0f, 10.0f));
                                        return Unit.INSTANCE;
                                    }
                                });
                                final ScrollerBackGroundItem scrollerBackGroundItem4 = ScrollerBackGroundItem.this;
                                ah.a(vVar4, new Function1<ImageView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.vas_pages.upload_background.ScrollerBackGroundItem.body.1.1.2.2
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(ImageView imageView) {
                                        final ScrollerBackGroundItem scrollerBackGroundItem5 = ScrollerBackGroundItem.this;
                                        imageView.attr(new Function1<af, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.vas_pages.upload_background.ScrollerBackGroundItem.body.1.1.2.2.1
                                            {
                                                super(1);
                                            }

                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(af afVar) {
                                                af afVar2 = afVar;
                                                afVar2.mo141height(90.0f);
                                                afVar2.mo153width(90.0f);
                                                b.a.b(afVar2, ScrollerBackGroundItem.this.data.backgroundImagePath, false, 2, null);
                                                return Unit.INSTANCE;
                                            }
                                        });
                                        return Unit.INSTANCE;
                                    }
                                });
                                final ScrollerBackGroundItem scrollerBackGroundItem5 = ScrollerBackGroundItem.this;
                                ah.a(vVar4, new Function1<ImageView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.vas_pages.upload_background.ScrollerBackGroundItem.body.1.1.2.3
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(ImageView imageView) {
                                        final ScrollerBackGroundItem scrollerBackGroundItem6 = ScrollerBackGroundItem.this;
                                        imageView.attr(new Function1<af, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.vas_pages.upload_background.ScrollerBackGroundItem.body.1.1.2.3.1
                                            {
                                                super(1);
                                            }

                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(af afVar) {
                                                af afVar2 = afVar;
                                                b.a.b(afVar2, ScrollerBackGroundItem.this.pickedImageUrl, false, 2, null);
                                                afVar2.size(20.0f, 20.0f);
                                                afVar2.absolutePosition(60.0f, 60.0f, 10.0f, 10.0f);
                                                afVar2.m152visibility(ScrollerBackGroundItem.this.data.isSelected());
                                                return Unit.INSTANCE;
                                            }
                                        });
                                        return Unit.INSTANCE;
                                    }
                                });
                                return Unit.INSTANCE;
                            }
                        });
                        final ScrollerBackGroundItem scrollerBackGroundItem3 = ScrollerBackGroundItem.this;
                        w.a(vVar2, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.vas_pages.upload_background.ScrollerBackGroundItem.body.1.1.3
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(v vVar3) {
                                v vVar4 = vVar3;
                                vVar4.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.vas_pages.upload_background.ScrollerBackGroundItem.body.1.1.3.1
                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(t tVar) {
                                        t tVar2 = tVar;
                                        tVar2.m150top(3.0f);
                                        tVar2.flexDirectionRow();
                                        tVar2.mo113backgroundColor(h.INSTANCE.k());
                                        return Unit.INSTANCE;
                                    }
                                });
                                final ScrollerBackGroundItem scrollerBackGroundItem4 = ScrollerBackGroundItem.this;
                                cg.a(vVar4, new Function1<TextView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.vas_pages.upload_background.ScrollerBackGroundItem.body.1.1.3.2
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(TextView textView) {
                                        final ScrollerBackGroundItem scrollerBackGroundItem5 = ScrollerBackGroundItem.this;
                                        textView.attr(new Function1<ce, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.vas_pages.upload_background.ScrollerBackGroundItem.body.1.1.3.2.1
                                            {
                                                super(1);
                                            }

                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(ce ceVar) {
                                                ce ceVar2 = ceVar;
                                                ceVar2.marginLeft(8.0f);
                                                ceVar2.marginRight(3.0f);
                                                ceVar2.text(ScrollerBackGroundItem.this.data.backgroundTitle);
                                                ce.fontSize$default(ceVar2, 14.0f, null, 2, null);
                                                ceVar2.fontWeight500();
                                                return Unit.INSTANCE;
                                            }
                                        });
                                        return Unit.INSTANCE;
                                    }
                                });
                                final ScrollerBackGroundItem scrollerBackGroundItem5 = ScrollerBackGroundItem.this;
                                ah.a(vVar4, new Function1<ImageView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.vas_pages.upload_background.ScrollerBackGroundItem.body.1.1.3.3
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(ImageView imageView) {
                                        final ScrollerBackGroundItem scrollerBackGroundItem6 = ScrollerBackGroundItem.this;
                                        imageView.attr(new Function1<af, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.vas_pages.upload_background.ScrollerBackGroundItem.body.1.1.3.3.1
                                            {
                                                super(1);
                                            }

                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(af afVar) {
                                                af afVar2 = afVar;
                                                afVar2.mo141height(10.0f);
                                                afVar2.mo153width(25.0f);
                                                afVar2.m137borderRadius(new f(1.0f, 1.0f, 1.0f, 1.0f));
                                                b.a.b(afVar2, ScrollerBackGroundItem.this.requiredPath, false, 2, null);
                                                afVar2.m152visibility(!ScrollerBackGroundItem.this.data.isFree);
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
}

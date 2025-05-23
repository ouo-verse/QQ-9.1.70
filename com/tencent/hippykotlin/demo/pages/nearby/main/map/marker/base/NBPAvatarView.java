package com.tencent.hippykotlin.demo.pages.nearby.main.map.marker.base;

import com.tencent.kuikly.core.base.Attr;
import com.tencent.kuikly.core.base.ComposeView;
import com.tencent.kuikly.core.base.ViewContainer;
import com.tencent.kuikly.core.base.a;
import com.tencent.kuikly.core.base.attr.b;
import com.tencent.kuikly.core.base.attr.d;
import com.tencent.kuikly.core.base.event.Event;
import com.tencent.kuikly.core.base.h;
import com.tencent.kuikly.core.base.u;
import com.tencent.kuikly.core.views.ImageView;
import com.tencent.kuikly.core.views.af;
import com.tencent.kuikly.core.views.ah;
import com.tencent.kuikly.core.views.t;
import com.tencent.kuikly.core.views.v;
import com.tencent.kuikly.core.views.w;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* loaded from: classes31.dex */
public final class NBPAvatarView extends ComposeView<NBPAvatarAttr, NBPAvatarEvent> {
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.tencent.kuikly.core.base.ComposeView
    public final Function1<ViewContainer<?, ?>, Unit> body() {
        final NBPAvatarAttr nBPAvatarAttr = (NBPAvatarAttr) getAttr();
        return new Function1<ViewContainer<?, ?>, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.main.map.marker.base.NBPAvatarView$body$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Unit invoke(ViewContainer<?, ?> viewContainer) {
                final NBPAvatarAttr nBPAvatarAttr2 = NBPAvatarAttr.this;
                w.a(viewContainer, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.main.map.marker.base.NBPAvatarView$body$1.1
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(v vVar) {
                        v vVar2 = vVar;
                        final NBPAvatarAttr nBPAvatarAttr3 = NBPAvatarAttr.this;
                        vVar2.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.main.map.marker.base.NBPAvatarView.body.1.1.1
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(t tVar) {
                                tVar.size(NBPAvatarAttr.this.size);
                                return Unit.INSTANCE;
                            }
                        });
                        final NBPAvatarAttr nBPAvatarAttr4 = NBPAvatarAttr.this;
                        w.a(vVar2, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.main.map.marker.base.NBPAvatarView.body.1.1.2
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(v vVar3) {
                                v vVar4 = vVar3;
                                final NBPAvatarAttr nBPAvatarAttr5 = NBPAvatarAttr.this;
                                vVar4.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.main.map.marker.base.NBPAvatarView.body.1.1.2.1
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(t tVar) {
                                        t tVar2 = tVar;
                                        tVar2.size(NBPAvatarAttr.this.size);
                                        tVar2.borderRadius(NBPAvatarAttr.this.size / 2.0f);
                                        tVar2.mo113backgroundColor(h.INSTANCE.m());
                                        return Unit.INSTANCE;
                                    }
                                });
                                final NBPAvatarAttr nBPAvatarAttr6 = NBPAvatarAttr.this;
                                ah.a(vVar4, new Function1<ImageView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.main.map.marker.base.NBPAvatarView.body.1.1.2.2
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(ImageView imageView) {
                                        final NBPAvatarAttr nBPAvatarAttr7 = NBPAvatarAttr.this;
                                        imageView.attr(new Function1<af, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.main.map.marker.base.NBPAvatarView.body.1.1.2.2.1
                                            {
                                                super(1);
                                            }

                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(af afVar) {
                                                af afVar2 = afVar;
                                                NBPAvatarAttr nBPAvatarAttr8 = NBPAvatarAttr.this;
                                                float borderWidth = nBPAvatarAttr8.size - (nBPAvatarAttr8.getBorderWidth() * 2);
                                                float f16 = NBPAvatarAttr.this.imageRenderScale;
                                                if (!(f16 == 1.0f)) {
                                                    afVar2.size(f16 * borderWidth);
                                                    float f17 = 1.0f / NBPAvatarAttr.this.imageRenderScale;
                                                    d.a.a(afVar2, null, new u(f17, f17), null, new a(0.0f, 0.0f), null, 21, null);
                                                } else {
                                                    afVar2.size(borderWidth);
                                                }
                                                b.a.b(afVar2, NBPAvatarAttr.this.url, false, 2, null);
                                                afVar2.borderRadius(borderWidth / 2.0f);
                                                Attr.absolutePosition$default(afVar2, NBPAvatarAttr.this.getBorderWidth(), NBPAvatarAttr.this.getBorderWidth(), 0.0f, 0.0f, 12, null);
                                                return Unit.INSTANCE;
                                            }
                                        });
                                        return Unit.INSTANCE;
                                    }
                                });
                                return Unit.INSTANCE;
                            }
                        });
                        if (NBPAvatarAttr.this.dressBorderUrl.length() > 0) {
                            final NBPAvatarAttr nBPAvatarAttr5 = NBPAvatarAttr.this;
                            ah.a(vVar2, new Function1<ImageView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.main.map.marker.base.NBPAvatarView.body.1.1.3
                                {
                                    super(1);
                                }

                                @Override // kotlin.jvm.functions.Function1
                                public final Unit invoke(ImageView imageView) {
                                    final NBPAvatarAttr nBPAvatarAttr6 = NBPAvatarAttr.this;
                                    imageView.attr(new Function1<af, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.main.map.marker.base.NBPAvatarView.body.1.1.3.1
                                        {
                                            super(1);
                                        }

                                        @Override // kotlin.jvm.functions.Function1
                                        public final Unit invoke(af afVar) {
                                            af afVar2 = afVar;
                                            NBPAvatarAttr nBPAvatarAttr7 = NBPAvatarAttr.this;
                                            float f16 = 2;
                                            float borderWidth = (nBPAvatarAttr7.size - (nBPAvatarAttr7.getBorderWidth() * f16)) * 1.1111112f;
                                            afVar2.size(borderWidth, borderWidth);
                                            b.a.b(afVar2, NBPAvatarAttr.this.dressBorderUrl, false, 2, null);
                                            float f17 = (NBPAvatarAttr.this.size - borderWidth) / f16;
                                            Attr.absolutePosition$default(afVar2, f17, f17, 0.0f, 0.0f, 12, null);
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
        };
    }

    @Override // com.tencent.kuikly.core.base.AbstractBaseView
    public final Attr createAttr() {
        return new NBPAvatarAttr();
    }

    @Override // com.tencent.kuikly.core.base.AbstractBaseView
    public final Event createEvent() {
        return new NBPAvatarEvent();
    }
}

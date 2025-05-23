package com.tencent.hippykotlin.demo.pages.nearby.interactive.view;

import c45.a;
import com.tencent.hippykotlin.demo.pages.nearby.base.NearbyProKtxKt;
import com.tencent.kuikly.core.base.Attr;
import com.tencent.kuikly.core.base.ComposeView;
import com.tencent.kuikly.core.base.ViewContainer;
import com.tencent.kuikly.core.base.attr.b;
import com.tencent.kuikly.core.base.event.Event;
import com.tencent.kuikly.core.base.h;
import com.tencent.kuikly.core.views.ImageView;
import com.tencent.kuikly.core.views.TextView;
import com.tencent.kuikly.core.views.af;
import com.tencent.kuikly.core.views.ah;
import com.tencent.kuikly.core.views.ce;
import com.tencent.kuikly.core.views.cg;
import com.tencent.kuikly.core.views.t;
import java.util.List;
import kotlin.Unit;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Ref;
import kotlin.text.StringsKt__StringsJVMKt;
import n25.g;
import n25.j;
import n25.l;
import n35.v;
import n35.w;
import n35.z;

/* loaded from: classes31.dex */
public final class NBPInteractiveThumbnailView extends ComposeView<NBPInteractiveThumbnailViewAttr, NBPInteractiveThumbnailViewEvent> {
    /* JADX WARN: Multi-variable type inference failed */
    public static final String access$getCustomText(NBPInteractiveThumbnailView nBPInteractiveThumbnailView) {
        l lVar;
        a aVar;
        String decodeToString;
        g gVar = ((NBPInteractiveThumbnailViewAttr) nBPInteractiveThumbnailView.getAttr()).psvFeed;
        if (gVar != null && (lVar = gVar.F) != null && (aVar = lVar.f418096i) != null) {
            decodeToString = StringsKt__StringsJVMKt.decodeToString(aVar.f30291a);
            return decodeToString;
        }
        return "";
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final v access$getImageSrc(NBPInteractiveThumbnailView nBPInteractiveThumbnailView) {
        l lVar;
        List<j> list;
        Object firstOrNull;
        w wVar;
        List<z> list2;
        Object firstOrNull2;
        g gVar = ((NBPInteractiveThumbnailViewAttr) nBPInteractiveThumbnailView.getAttr()).psvFeed;
        if (gVar != null && (lVar = gVar.F) != null && (list = lVar.f418097m) != null) {
            firstOrNull = CollectionsKt___CollectionsKt.firstOrNull((List<? extends Object>) list);
            j jVar = (j) firstOrNull;
            if (jVar != null && (wVar = jVar.f418083d) != null && (list2 = wVar.f418273d) != null) {
                firstOrNull2 = CollectionsKt___CollectionsKt.firstOrNull((List<? extends Object>) list2);
                z zVar = (z) firstOrNull2;
                if (zVar != null) {
                    return zVar.f418280d;
                }
            }
        }
        return null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final String access$getSmallIcon(NBPInteractiveThumbnailView nBPInteractiveThumbnailView) {
        l lVar;
        q25.g gVar;
        String str;
        g gVar2 = ((NBPInteractiveThumbnailViewAttr) nBPInteractiveThumbnailView.getAttr()).psvFeed;
        return (gVar2 == null || (lVar = gVar2.F) == null || (gVar = lVar.f418094f) == null || (str = gVar.f428260h) == null) ? "" : str;
    }

    @Override // com.tencent.kuikly.core.base.ComposeView
    public final Function1<ViewContainer<?, ?>, Unit> body() {
        return new Function1<ViewContainer<?, ?>, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.interactive.view.NBPInteractiveThumbnailView$body$1
            {
                super(1);
            }

            /* JADX WARN: Type inference failed for: r2v7, types: [T, java.lang.String] */
            /* JADX WARN: Type inference failed for: r3v2, types: [T, java.lang.String] */
            @Override // kotlin.jvm.functions.Function1
            public final Unit invoke(ViewContainer<?, ?> viewContainer) {
                ViewContainer<?, ?> viewContainer2 = viewContainer;
                final v access$getImageSrc = NBPInteractiveThumbnailView.access$getImageSrc(NBPInteractiveThumbnailView.this);
                final Ref.ObjectRef objectRef = new Ref.ObjectRef();
                objectRef.element = "";
                if (access$getImageSrc == null) {
                    objectRef.element = NBPInteractiveThumbnailView.access$getCustomText(NBPInteractiveThumbnailView.this);
                }
                final Ref.ObjectRef objectRef2 = new Ref.ObjectRef();
                objectRef2.element = "";
                if (((CharSequence) objectRef.element).length() == 0) {
                    objectRef2.element = NBPInteractiveThumbnailView.access$getSmallIcon(NBPInteractiveThumbnailView.this);
                }
                if (access$getImageSrc != null) {
                    ah.a(viewContainer2, new Function1<ImageView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.interactive.view.NBPInteractiveThumbnailView$body$1.1
                        {
                            super(1);
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public final Unit invoke(ImageView imageView) {
                            final v vVar = v.this;
                            imageView.attr(new Function1<af, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.interactive.view.NBPInteractiveThumbnailView.body.1.1.1
                                {
                                    super(1);
                                }

                                @Override // kotlin.jvm.functions.Function1
                                public final Unit invoke(af afVar) {
                                    af afVar2 = afVar;
                                    afVar2.size(60.0f, 60.0f);
                                    afVar2.borderRadius(4.0f);
                                    NearbyProKtxKt.srcWithIndexNode(afVar2, v.this);
                                    return Unit.INSTANCE;
                                }
                            });
                            return Unit.INSTANCE;
                        }
                    });
                } else {
                    if (((CharSequence) objectRef.element).length() > 0) {
                        com.tencent.kuikly.core.views.w.a(viewContainer2, new Function1<com.tencent.kuikly.core.views.v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.interactive.view.NBPInteractiveThumbnailView$body$1.2
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(com.tencent.kuikly.core.views.v vVar) {
                                com.tencent.kuikly.core.views.v vVar2 = vVar;
                                vVar2.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.interactive.view.NBPInteractiveThumbnailView.body.1.2.1
                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(t tVar) {
                                        tVar.mo153width(60.0f);
                                        return Unit.INSTANCE;
                                    }
                                });
                                final Ref.ObjectRef<String> objectRef3 = objectRef;
                                cg.a(vVar2, new Function1<TextView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.interactive.view.NBPInteractiveThumbnailView.body.1.2.2
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(TextView textView) {
                                        final Ref.ObjectRef<String> objectRef4 = objectRef3;
                                        textView.attr(new Function1<ce, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.interactive.view.NBPInteractiveThumbnailView.body.1.2.2.1
                                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                            {
                                                super(1);
                                            }

                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(ce ceVar) {
                                                ce ceVar2 = ceVar;
                                                ceVar2.color(new h(9474196L, 1.0f));
                                                ceVar2.lines(3);
                                                ce.fontSize$default(ceVar2, 12.0f, null, 2, null);
                                                ceVar2.fontWeight400();
                                                ceVar2.textOverFlowTail();
                                                ceVar2.text(objectRef4.element);
                                                ceVar2.fontWeight400();
                                                return Unit.INSTANCE;
                                            }
                                        });
                                        return Unit.INSTANCE;
                                    }
                                });
                                return Unit.INSTANCE;
                            }
                        });
                    } else {
                        if (((CharSequence) objectRef2.element).length() > 0) {
                            com.tencent.kuikly.core.views.w.a(viewContainer2, new Function1<com.tencent.kuikly.core.views.v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.interactive.view.NBPInteractiveThumbnailView$body$1.3
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                {
                                    super(1);
                                }

                                @Override // kotlin.jvm.functions.Function1
                                public final Unit invoke(com.tencent.kuikly.core.views.v vVar) {
                                    com.tencent.kuikly.core.views.v vVar2 = vVar;
                                    vVar2.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.interactive.view.NBPInteractiveThumbnailView.body.1.3.1
                                        @Override // kotlin.jvm.functions.Function1
                                        public final Unit invoke(t tVar) {
                                            t tVar2 = tVar;
                                            tVar2.size(60.0f, 60.0f);
                                            tVar2.borderRadius(4.0f);
                                            tVar2.mo113backgroundColor(new h(16119285L, 1.0f));
                                            tVar2.allCenter();
                                            return Unit.INSTANCE;
                                        }
                                    });
                                    final Ref.ObjectRef<String> objectRef3 = objectRef2;
                                    ah.a(vVar2, new Function1<ImageView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.interactive.view.NBPInteractiveThumbnailView.body.1.3.2
                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                        {
                                            super(1);
                                        }

                                        @Override // kotlin.jvm.functions.Function1
                                        public final Unit invoke(ImageView imageView) {
                                            final Ref.ObjectRef<String> objectRef4 = objectRef3;
                                            imageView.attr(new Function1<af, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.interactive.view.NBPInteractiveThumbnailView.body.1.3.2.1
                                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                {
                                                    super(1);
                                                }

                                                @Override // kotlin.jvm.functions.Function1
                                                public final Unit invoke(af afVar) {
                                                    af afVar2 = afVar;
                                                    afVar2.size(32.0f, 32.0f);
                                                    b.a.b(afVar2, objectRef4.element, false, 2, null);
                                                    afVar2.o();
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
                }
                return Unit.INSTANCE;
            }
        };
    }

    @Override // com.tencent.kuikly.core.base.AbstractBaseView
    public final Attr createAttr() {
        return new NBPInteractiveThumbnailViewAttr();
    }

    @Override // com.tencent.kuikly.core.base.AbstractBaseView
    public final Event createEvent() {
        return new NBPInteractiveThumbnailViewEvent();
    }
}

package com.tencent.hippykotlin.demo.pages.nearby.publish.view;

import com.tencent.hippykotlin.demo.pages.nearby.publish.NBPPublishViewModel;
import com.tencent.kuikly.core.base.Attr;
import com.tencent.kuikly.core.base.ComposeView;
import com.tencent.kuikly.core.base.ViewContainer;
import com.tencent.kuikly.core.base.attr.b;
import com.tencent.kuikly.core.base.event.ClickParams;
import com.tencent.kuikly.core.base.event.Event;
import com.tencent.kuikly.core.base.h;
import com.tencent.kuikly.core.base.m;
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
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import o25.f;

/* loaded from: classes31.dex */
public final class NBPPublishThemeSelectionItemView extends ComposeView<NBPPublishThemeSelectionItemAttr, NBPPublishThemeSelectionItemEvent> {
    /* JADX WARN: Multi-variable type inference failed */
    public static final /* synthetic */ NBPPublishThemeSelectionItemAttr access$getAttr(NBPPublishThemeSelectionItemView nBPPublishThemeSelectionItemView) {
        return (NBPPublishThemeSelectionItemAttr) nBPPublishThemeSelectionItemView.getAttr();
    }

    @Override // com.tencent.kuikly.core.base.ComposeView
    public final Function1<ViewContainer<?, ?>, Unit> body() {
        return new Function1<ViewContainer<?, ?>, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.publish.view.NBPPublishThemeSelectionItemView$body$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Unit invoke(ViewContainer<?, ?> viewContainer) {
                ViewContainer<?, ?> viewContainer2 = viewContainer;
                viewContainer2.attr(new Function1<m, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.publish.view.NBPPublishThemeSelectionItemView$body$1.1
                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(m mVar) {
                        m mVar2 = mVar;
                        mVar2.flexDirectionRow();
                        mVar2.size(mVar2.getPagerData().m(), 72.0f);
                        mVar2.alignItemsCenter();
                        mVar2.padding(10.0f, 16.0f, 10.0f, 16.0f);
                        return Unit.INSTANCE;
                    }
                });
                final NBPPublishThemeSelectionItemView nBPPublishThemeSelectionItemView = NBPPublishThemeSelectionItemView.this;
                ah.a(viewContainer2, new Function1<ImageView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.publish.view.NBPPublishThemeSelectionItemView$body$1.2
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(ImageView imageView) {
                        final NBPPublishThemeSelectionItemView nBPPublishThemeSelectionItemView2 = NBPPublishThemeSelectionItemView.this;
                        imageView.attr(new Function1<af, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.publish.view.NBPPublishThemeSelectionItemView.body.1.2.1
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(af afVar) {
                                String str;
                                af afVar2 = afVar;
                                afVar2.size(52.0f, 52.0f);
                                afVar2.marginRight(12.0f);
                                afVar2.o();
                                f fVar = NBPPublishThemeSelectionItemView.access$getAttr(NBPPublishThemeSelectionItemView.this).mapTheme;
                                if (fVar == null || (str = fVar.f421851f) == null) {
                                    str = "https://vfiles.gtimg.cn/wuji_dashboard/xy/componenthub/GOUlavEl.png";
                                }
                                b.a.b(afVar2, str, false, 2, null);
                                return Unit.INSTANCE;
                            }
                        });
                        return Unit.INSTANCE;
                    }
                });
                final NBPPublishThemeSelectionItemView nBPPublishThemeSelectionItemView2 = NBPPublishThemeSelectionItemView.this;
                w.a(viewContainer2, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.publish.view.NBPPublishThemeSelectionItemView$body$1.3
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(v vVar) {
                        v vVar2 = vVar;
                        vVar2.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.publish.view.NBPPublishThemeSelectionItemView.body.1.3.1
                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(t tVar) {
                                t tVar2 = tVar;
                                tVar2.flexDirectionColumn();
                                tVar2.m140flex(1.0f);
                                tVar2.marginRight(12.0f);
                                return Unit.INSTANCE;
                            }
                        });
                        final NBPPublishThemeSelectionItemView nBPPublishThemeSelectionItemView3 = NBPPublishThemeSelectionItemView.this;
                        cg.a(vVar2, new Function1<TextView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.publish.view.NBPPublishThemeSelectionItemView.body.1.3.2
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(TextView textView) {
                                final NBPPublishThemeSelectionItemView nBPPublishThemeSelectionItemView4 = NBPPublishThemeSelectionItemView.this;
                                textView.attr(new Function1<ce, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.publish.view.NBPPublishThemeSelectionItemView.body.1.3.2.1
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(ce ceVar) {
                                        String str;
                                        ce ceVar2 = ceVar;
                                        f fVar = NBPPublishThemeSelectionItemView.access$getAttr(NBPPublishThemeSelectionItemView.this).mapTheme;
                                        if (fVar == null || (str = fVar.f421850e) == null) {
                                            str = "\u4e0d\u9009\u62e9\u4e3b\u9898\u5730\u56fe";
                                        }
                                        ceVar2.text(str);
                                        ceVar2.color(new h(4279901214L));
                                        ce.fontSize$default(ceVar2, 17.0f, null, 2, null);
                                        return Unit.INSTANCE;
                                    }
                                });
                                return Unit.INSTANCE;
                            }
                        });
                        final NBPPublishThemeSelectionItemView nBPPublishThemeSelectionItemView4 = NBPPublishThemeSelectionItemView.this;
                        cg.a(vVar2, new Function1<TextView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.publish.view.NBPPublishThemeSelectionItemView.body.1.3.3
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(TextView textView) {
                                final NBPPublishThemeSelectionItemView nBPPublishThemeSelectionItemView5 = NBPPublishThemeSelectionItemView.this;
                                textView.attr(new Function1<ce, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.publish.view.NBPPublishThemeSelectionItemView.body.1.3.3.1
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(ce ceVar) {
                                        String str;
                                        ce ceVar2 = ceVar;
                                        f fVar = NBPPublishThemeSelectionItemView.access$getAttr(NBPPublishThemeSelectionItemView.this).mapTheme;
                                        if (fVar != null) {
                                            str = fVar.I + '\u4eba' + fVar.f421852h;
                                        } else {
                                            str = "\u4f60\u7684\u52a8\u6001\u5c06\u8f83\u96be\u88ab\u53d1\u73b0";
                                        }
                                        ceVar2.text(str);
                                        ceVar2.color(new h(4287664276L));
                                        ce.fontSize$default(ceVar2, 14.0f, null, 2, null);
                                        ceVar2.marginTop(4.0f);
                                        return Unit.INSTANCE;
                                    }
                                });
                                return Unit.INSTANCE;
                            }
                        });
                        return Unit.INSTANCE;
                    }
                });
                final NBPPublishThemeSelectionItemView nBPPublishThemeSelectionItemView3 = NBPPublishThemeSelectionItemView.this;
                ah.a(viewContainer2, new Function1<ImageView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.publish.view.NBPPublishThemeSelectionItemView$body$1.4
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(ImageView imageView) {
                        final NBPPublishThemeSelectionItemView nBPPublishThemeSelectionItemView4 = NBPPublishThemeSelectionItemView.this;
                        imageView.attr(new Function1<af, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.publish.view.NBPPublishThemeSelectionItemView.body.1.4.1
                            {
                                super(1);
                            }

                            /* JADX WARN: Code restructure failed: missing block: B:18:0x005f, code lost:
                            
                                if (r0 != false) goto L18;
                             */
                            /* JADX WARN: Code restructure failed: missing block: B:7:0x0034, code lost:
                            
                                if (r0.getSelectThemeList().size() != 0) goto L10;
                             */
                            /* JADX WARN: Code restructure failed: missing block: B:8:0x0061, code lost:
                            
                                r1 = true;
                             */
                            @Override // kotlin.jvm.functions.Function1
                            /*
                                Code decompiled incorrectly, please refer to instructions dump.
                            */
                            public final Unit invoke(af afVar) {
                                boolean contains;
                                af afVar2 = afVar;
                                afVar2.size(20.0f, 20.0f);
                                boolean z16 = false;
                                NBPPublishViewModel nBPPublishViewModel = null;
                                b.a.b(afVar2, "https://image.superqqshow.qq.com/wuji/qq_lplan/lplan_pic_resouce/3c6784d9_rF-uN1c3feV.png", false, 2, null);
                                if (NBPPublishThemeSelectionItemView.access$getAttr(NBPPublishThemeSelectionItemView.this).mapTheme == null) {
                                    NBPPublishViewModel nBPPublishViewModel2 = NBPPublishThemeSelectionItemView.access$getAttr(NBPPublishThemeSelectionItemView.this).viewModel;
                                    if (nBPPublishViewModel2 == null) {
                                        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
                                        nBPPublishViewModel2 = null;
                                    }
                                }
                                if (NBPPublishThemeSelectionItemView.access$getAttr(NBPPublishThemeSelectionItemView.this).mapTheme != null) {
                                    NBPPublishViewModel nBPPublishViewModel3 = NBPPublishThemeSelectionItemView.access$getAttr(NBPPublishThemeSelectionItemView.this).viewModel;
                                    if (nBPPublishViewModel3 != null) {
                                        nBPPublishViewModel = nBPPublishViewModel3;
                                    } else {
                                        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
                                    }
                                    contains = CollectionsKt___CollectionsKt.contains(nBPPublishViewModel.getSelectThemeList(), NBPPublishThemeSelectionItemView.access$getAttr(NBPPublishThemeSelectionItemView.this).mapTheme);
                                }
                                afVar2.m152visibility(z16);
                                return Unit.INSTANCE;
                            }
                        });
                        return Unit.INSTANCE;
                    }
                });
                final NBPPublishThemeSelectionItemView nBPPublishThemeSelectionItemView4 = NBPPublishThemeSelectionItemView.this;
                viewContainer2.event(new Function1<Event, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.publish.view.NBPPublishThemeSelectionItemView$body$1.5
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(Event event) {
                        final NBPPublishThemeSelectionItemView nBPPublishThemeSelectionItemView5 = NBPPublishThemeSelectionItemView.this;
                        event.click(new Function1<ClickParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.publish.view.NBPPublishThemeSelectionItemView.body.1.5.1
                            {
                                super(1);
                            }

                            /* JADX WARN: Multi-variable type inference failed */
                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(ClickParams clickParams) {
                                Function1<? super f, Unit> function1 = ((NBPPublishThemeSelectionItemEvent) NBPPublishThemeSelectionItemView.this.getViewEvent()).eventHandler;
                                if (function1 != null) {
                                    function1.invoke(NBPPublishThemeSelectionItemView.access$getAttr(NBPPublishThemeSelectionItemView.this).mapTheme);
                                }
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
        return new NBPPublishThemeSelectionItemAttr();
    }

    @Override // com.tencent.kuikly.core.base.AbstractBaseView
    public final Event createEvent() {
        return new NBPPublishThemeSelectionItemEvent();
    }
}

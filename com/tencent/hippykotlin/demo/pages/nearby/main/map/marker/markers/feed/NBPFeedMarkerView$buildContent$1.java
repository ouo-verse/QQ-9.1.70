package com.tencent.hippykotlin.demo.pages.nearby.main.map.marker.markers.feed;

import com.tencent.hippykotlin.demo.pages.nearby.base.NearbyProKtxKt;
import com.tencent.hippykotlin.demo.pages.nearby.base.view.TextViewExtKt;
import com.tencent.hippykotlin.demo.pages.nearby.main.map.marker.markers.feed.NBPFeedMarkerUIConfig;
import com.tencent.kuikly.core.base.Attr;
import com.tencent.kuikly.core.base.Direction;
import com.tencent.kuikly.core.base.ViewContainer;
import com.tencent.kuikly.core.base.a;
import com.tencent.kuikly.core.base.attr.b;
import com.tencent.kuikly.core.base.attr.d;
import com.tencent.kuikly.core.base.h;
import com.tencent.kuikly.core.base.j;
import com.tencent.kuikly.core.base.u;
import com.tencent.kuikly.core.directives.ConditionView;
import com.tencent.kuikly.core.directives.ConditionViewKt;
import com.tencent.kuikly.core.views.ImageView;
import com.tencent.kuikly.core.views.TextView;
import com.tencent.kuikly.core.views.af;
import com.tencent.kuikly.core.views.ah;
import com.tencent.kuikly.core.views.ce;
import com.tencent.kuikly.core.views.cg;
import com.tencent.kuikly.core.views.t;
import com.tencent.kuikly.core.views.w;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import n35.v;

/* loaded from: classes31.dex */
public final class NBPFeedMarkerView$buildContent$1 extends Lambda implements Function1<ViewContainer<?, ?>, Unit> {
    public final /* synthetic */ float $contentHeight;
    public final /* synthetic */ float $contentWidth;
    public final /* synthetic */ NBPFeedMarkerView $ctx;
    public final /* synthetic */ v $image;
    public final /* synthetic */ String $text;
    public final /* synthetic */ NBPFeedMarkerUIConfig $ui;
    public final /* synthetic */ boolean $willScale;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public NBPFeedMarkerView$buildContent$1(float f16, float f17, v vVar, NBPFeedMarkerUIConfig nBPFeedMarkerUIConfig, boolean z16, NBPFeedMarkerView nBPFeedMarkerView, String str) {
        super(1);
        this.$contentWidth = f16;
        this.$contentHeight = f17;
        this.$image = vVar;
        this.$ui = nBPFeedMarkerUIConfig;
        this.$willScale = z16;
        this.$ctx = nBPFeedMarkerView;
        this.$text = str;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Unit invoke(ViewContainer<?, ?> viewContainer) {
        final float f16 = this.$contentWidth;
        final float f17 = this.$contentHeight;
        final v vVar = this.$image;
        final NBPFeedMarkerUIConfig nBPFeedMarkerUIConfig = this.$ui;
        final boolean z16 = this.$willScale;
        final NBPFeedMarkerView nBPFeedMarkerView = this.$ctx;
        final String str = this.$text;
        w.a(viewContainer, new Function1<com.tencent.kuikly.core.views.v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.main.map.marker.markers.feed.NBPFeedMarkerView$buildContent$1.1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Unit invoke(com.tencent.kuikly.core.views.v vVar2) {
                com.tencent.kuikly.core.views.v vVar3 = vVar2;
                final float f18 = f16;
                final float f19 = f17;
                vVar3.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.main.map.marker.markers.feed.NBPFeedMarkerView.buildContent.1.1.1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(t tVar) {
                        tVar.size(f18, f19);
                        return Unit.INSTANCE;
                    }
                });
                final v vVar4 = vVar;
                final NBPFeedMarkerUIConfig nBPFeedMarkerUIConfig2 = nBPFeedMarkerUIConfig;
                final boolean z17 = z16;
                final NBPFeedMarkerView nBPFeedMarkerView2 = nBPFeedMarkerView;
                final float f26 = f16;
                final float f27 = f17;
                ah.a(vVar3, new Function1<ImageView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.main.map.marker.markers.feed.NBPFeedMarkerView.buildContent.1.1.2
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(ImageView imageView) {
                        final v vVar5 = v.this;
                        final NBPFeedMarkerUIConfig nBPFeedMarkerUIConfig3 = nBPFeedMarkerUIConfig2;
                        final boolean z18 = z17;
                        final NBPFeedMarkerView nBPFeedMarkerView3 = nBPFeedMarkerView2;
                        final float f28 = f26;
                        final float f29 = f27;
                        imageView.attr(new Function1<af, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.main.map.marker.markers.feed.NBPFeedMarkerView.buildContent.1.1.2.1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(af afVar) {
                                af afVar2 = afVar;
                                v vVar6 = v.this;
                                if (vVar6 != null) {
                                    NearbyProKtxKt.srcWithIndexNode(afVar2, vVar6);
                                } else {
                                    b.a.b(afVar2, nBPFeedMarkerUIConfig3.textFeedBg, false, 2, null);
                                }
                                if (z18) {
                                    NBPFeedMarkerView nBPFeedMarkerView4 = nBPFeedMarkerView3;
                                    if (nBPFeedMarkerView4.needScaleRenderImage) {
                                        float f36 = f28;
                                        float f37 = nBPFeedMarkerView4.imageRenderScale;
                                        afVar2.size(f36 * f37, f29 * f37);
                                        float f38 = nBPFeedMarkerView3.imageRenderRestoreScale;
                                        d.a.a(afVar2, null, new u(f38, f38), null, new a(0.0f, 0.0f), null, 21, null);
                                        afVar2.absolutePositionAllZero();
                                        return Unit.INSTANCE;
                                    }
                                }
                                afVar2.size(f28, f29);
                                afVar2.absolutePositionAllZero();
                                return Unit.INSTANCE;
                            }
                        });
                        return Unit.INSTANCE;
                    }
                });
                final v vVar5 = vVar;
                Function0<Object> function0 = new Function0<Object>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.main.map.marker.markers.feed.NBPFeedMarkerView.buildContent.1.1.3
                    {
                        super(0);
                    }

                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return Boolean.valueOf(v.this == null);
                    }
                };
                final float f28 = f16;
                final float f29 = f17;
                final String str2 = str;
                ConditionViewKt.c(vVar3, function0, new Function1<ConditionView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.main.map.marker.markers.feed.NBPFeedMarkerView.buildContent.1.1.4
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(ConditionView conditionView) {
                        final float f36 = f28;
                        final float f37 = f29;
                        final String str3 = str2;
                        w.a(conditionView, new Function1<com.tencent.kuikly.core.views.v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.main.map.marker.markers.feed.NBPFeedMarkerView.buildContent.1.1.4.1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(com.tencent.kuikly.core.views.v vVar6) {
                                com.tencent.kuikly.core.views.v vVar7 = vVar6;
                                final float f38 = f36;
                                final float f39 = f37;
                                vVar7.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.main.map.marker.markers.feed.NBPFeedMarkerView.buildContent.1.1.4.1.1
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(t tVar) {
                                        t tVar2 = tVar;
                                        tVar2.size(f38, f39);
                                        tVar2.allCenter();
                                        return Unit.INSTANCE;
                                    }
                                });
                                final String str4 = str3;
                                cg.a(vVar7, new Function1<TextView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.main.map.marker.markers.feed.NBPFeedMarkerView.buildContent.1.1.4.1.2
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(TextView textView) {
                                        final String str5 = str4;
                                        textView.attr(new Function1<ce, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.main.map.marker.markers.feed.NBPFeedMarkerView.buildContent.1.1.4.1.2.1
                                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                            {
                                                super(1);
                                            }

                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(ce ceVar) {
                                                ce ceVar2 = ceVar;
                                                ceVar2.textPostProcessor("emoji");
                                                String str6 = str5;
                                                if (str6 == null) {
                                                    str6 = "";
                                                }
                                                TextViewExtKt.textWithLineHeightFix(ceVar2, str6);
                                                ce.fontSize$default(ceVar2, 8.0f, null, 2, null);
                                                ceVar2.lineHeight(14.0f);
                                                ceVar2.fontWeight500();
                                                ceVar2.textAlignCenter();
                                                ceVar2.mo153width(40.0f);
                                                ceVar2.lines(3);
                                                ceVar2.color(new h(4285694380L));
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
                final v vVar6 = vVar;
                final String str3 = str;
                Function0<Object> function02 = new Function0<Object>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.main.map.marker.markers.feed.NBPFeedMarkerView.buildContent.1.1.5
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(0);
                    }

                    /* JADX WARN: Removed duplicated region for block: B:13:0x0024  */
                    @Override // kotlin.jvm.functions.Function0
                    /*
                        Code decompiled incorrectly, please refer to instructions dump.
                    */
                    public final Object invoke() {
                        boolean z18;
                        boolean z19 = false;
                        if (NBPFeedMarkerUIConfig.Companion.getInstance().showFeedMarkTitle && v.this != null) {
                            String str4 = str3;
                            if (str4 != null) {
                                if (str4.length() > 0) {
                                    z18 = true;
                                    if (z18) {
                                        z19 = true;
                                    }
                                }
                            }
                            z18 = false;
                            if (z18) {
                            }
                        }
                        return Boolean.valueOf(z19);
                    }
                };
                final String str4 = str;
                ConditionViewKt.b(vVar3, function02, new Function1<ConditionView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.main.map.marker.markers.feed.NBPFeedMarkerView.buildContent.1.1.6
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(ConditionView conditionView) {
                        final String str5 = str4;
                        w.a(conditionView, new Function1<com.tencent.kuikly.core.views.v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.main.map.marker.markers.feed.NBPFeedMarkerView.buildContent.1.1.6.1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(com.tencent.kuikly.core.views.v vVar7) {
                                com.tencent.kuikly.core.views.v vVar8 = vVar7;
                                vVar8.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.main.map.marker.markers.feed.NBPFeedMarkerView.buildContent.1.1.6.1.1
                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(t tVar) {
                                        t tVar2 = tVar;
                                        Attr.absolutePosition$default(tVar2, 0.0f, 0.0f, 0.0f, 0.0f, 1, null);
                                        tVar2.alignItemsCenter();
                                        tVar2.mo135backgroundLinearGradient(Direction.TO_BOTTOM, new j(new h(0L, 0.0f), 0.0f), new j(new h(0L, 0.7f), 1.0f));
                                        return Unit.INSTANCE;
                                    }
                                });
                                final String str6 = str5;
                                cg.a(vVar8, new Function1<TextView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.main.map.marker.markers.feed.NBPFeedMarkerView.buildContent.1.1.6.1.2
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(TextView textView) {
                                        final String str7 = str6;
                                        textView.attr(new Function1<ce, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.main.map.marker.markers.feed.NBPFeedMarkerView.buildContent.1.1.6.1.2.1
                                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                            {
                                                super(1);
                                            }

                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(ce ceVar) {
                                                ce ceVar2 = ceVar;
                                                NBPFeedMarkerUIConfig.Companion companion = NBPFeedMarkerUIConfig.Companion;
                                                ceVar2.margin(companion.getInstance().titleMarginTop, companion.getInstance().titleMarginLeft, companion.getInstance().titleMarginBottom, companion.getInstance().titleMarginLeft);
                                                ceVar2.lineHeight(companion.getInstance().titleLineHeight);
                                                ce.fontSize$default(ceVar2, companion.getInstance().titleFontSize, null, 2, null);
                                                ceVar2.textAlignCenter();
                                                ceVar2.lines(2);
                                                String str8 = str7;
                                                if (str8 == null) {
                                                    str8 = "";
                                                }
                                                TextViewExtKt.textWithLineHeightFix(ceVar2, str8);
                                                ceVar2.color(h.INSTANCE.m());
                                                ceVar2.textPostProcessor("emoji");
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
        return Unit.INSTANCE;
    }
}

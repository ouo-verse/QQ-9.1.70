package com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.itemview.guild.subchannel.view;

import c01.c;
import com.tencent.hippykotlin.demo.pages.activity.blind_box.yifanshang.detail.view.YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.base.ktx.IPagerIdKtxKt;
import com.tencent.kuikly.core.base.Attr;
import com.tencent.kuikly.core.base.ComposeView;
import com.tencent.kuikly.core.base.ViewContainer;
import com.tencent.kuikly.core.base.attr.b;
import com.tencent.kuikly.core.base.event.Event;
import com.tencent.kuikly.core.base.h;
import com.tencent.kuikly.core.base.m;
import com.tencent.kuikly.core.timer.TimerKt;
import com.tencent.kuikly.core.views.CanvasView;
import com.tencent.kuikly.core.views.CanvasViewKt;
import com.tencent.kuikly.core.views.ImageView;
import com.tencent.kuikly.core.views.af;
import com.tencent.kuikly.core.views.ah;
import com.tencent.kuikly.core.views.p;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.properties.ReadWriteProperty;
import kotlin.reflect.KProperty;

/* compiled from: P */
/* loaded from: classes32.dex */
public final class GuildWaveAvatarView extends ComposeView<GuildWaveAvatarAttr, GuildWaveAvatarEvent> {
    public static final /* synthetic */ KProperty<Object>[] $$delegatedProperties = {YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0.m(GuildWaveAvatarView.class, "animOffset", "getAnimOffset()F", 0), YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0.m(GuildWaveAvatarView.class, "canPlay", "getCanPlay()Z", 0)};
    public float animStep;
    public float minRadius;
    public float radiusOffsetRange;
    public float waveDistance;
    public final ReadWriteProperty animOffset$delegate = c.a(Float.valueOf(0.0f));
    public final Map<Integer, Float> lastRadiusOffset = new LinkedHashMap();
    public final ReadWriteProperty canPlay$delegate = c.a(Boolean.FALSE);

    /* JADX WARN: Type inference failed for: r0v9, types: [java.util.LinkedHashMap, java.util.Map<java.lang.Integer, java.lang.Float>] */
    public static final boolean access$canAnim(GuildWaveAvatarView guildWaveAvatarView, int i3, float f16) {
        guildWaveAvatarView.getClass();
        if (f16 < 0.0f) {
            return false;
        }
        if (!guildWaveAvatarView.getCanPlay()) {
            if (!guildWaveAvatarView.lastRadiusOffset.containsKey(Integer.valueOf(i3))) {
                return false;
            }
            Object obj = guildWaveAvatarView.lastRadiusOffset.get(Integer.valueOf(i3));
            Intrinsics.checkNotNull(obj);
            if (((Number) obj).floatValue() > f16) {
                guildWaveAvatarView.lastRadiusOffset.remove(Integer.valueOf(i3));
                return false;
            }
        } else {
            if (!guildWaveAvatarView.lastRadiusOffset.containsKey(Integer.valueOf(i3)) && f16 > guildWaveAvatarView.animStep) {
                return false;
            }
            guildWaveAvatarView.lastRadiusOffset.put(Integer.valueOf(i3), Float.valueOf(f16));
        }
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final /* synthetic */ GuildWaveAvatarAttr access$getAttr(GuildWaveAvatarView guildWaveAvatarView) {
        return (GuildWaveAvatarAttr) guildWaveAvatarView.getAttr();
    }

    public static final void access$play(final GuildWaveAvatarView guildWaveAvatarView) {
        if (!guildWaveAvatarView.getCanPlay() && guildWaveAvatarView.lastRadiusOffset.isEmpty()) {
            guildWaveAvatarView.setAnimOffset(0.0f);
            return;
        }
        guildWaveAvatarView.setAnimOffset(guildWaveAvatarView.getAnimOffset() + guildWaveAvatarView.animStep);
        if (guildWaveAvatarView.getAnimOffset() < 0.0f) {
            guildWaveAvatarView.setAnimOffset(0.0f);
        }
        Function0<Unit> function0 = new Function0<Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.itemview.guild.subchannel.view.GuildWaveAvatarView$play$1
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Unit invoke() {
                GuildWaveAvatarView.access$play(GuildWaveAvatarView.this);
                return Unit.INSTANCE;
            }
        };
        KProperty<Object>[] kPropertyArr = IPagerIdKtxKt.$$delegatedProperties;
        TimerKt.e(guildWaveAvatarView.getPagerId(), 16, function0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final void access$updatePlayStatus(GuildWaveAvatarView guildWaveAvatarView) {
        GuildWaveAvatarAttr guildWaveAvatarAttr = (GuildWaveAvatarAttr) guildWaveAvatarView.getAttr();
        ReadWriteProperty readWriteProperty = guildWaveAvatarAttr.play$delegate;
        KProperty<?>[] kPropertyArr = GuildWaveAvatarAttr.$$delegatedProperties;
        boolean z16 = false;
        if (((Boolean) readWriteProperty.getValue(guildWaveAvatarAttr, kPropertyArr[0])).booleanValue()) {
            GuildWaveAvatarAttr guildWaveAvatarAttr2 = (GuildWaveAvatarAttr) guildWaveAvatarView.getAttr();
            if (!((Boolean) guildWaveAvatarAttr2.userScrolling$delegate.getValue(guildWaveAvatarAttr2, kPropertyArr[1])).booleanValue()) {
                z16 = true;
            }
        }
        guildWaveAvatarView.canPlay$delegate.setValue(guildWaveAvatarView, $$delegatedProperties[1], Boolean.valueOf(z16));
    }

    @Override // com.tencent.kuikly.core.base.ComposeView
    public final Function1<ViewContainer<?, ?>, Unit> body() {
        return new Function1<ViewContainer<?, ?>, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.itemview.guild.subchannel.view.GuildWaveAvatarView$body$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Unit invoke(ViewContainer<?, ?> viewContainer) {
                ViewContainer<?, ?> viewContainer2 = viewContainer;
                viewContainer2.attr(new Function1<m, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.itemview.guild.subchannel.view.GuildWaveAvatarView$body$1.1
                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(m mVar) {
                        mVar.size(50.0f, 50.0f);
                        return Unit.INSTANCE;
                    }
                });
                final GuildWaveAvatarView guildWaveAvatarView = GuildWaveAvatarView.this;
                guildWaveAvatarView.getClass();
                CanvasViewKt.a(viewContainer2, new Function1<CanvasView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.itemview.guild.subchannel.view.GuildWaveAvatarView$createWaveView$1$1
                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(CanvasView canvasView) {
                        canvasView.attr(new Function1<Attr, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.itemview.guild.subchannel.view.GuildWaveAvatarView$createWaveView$1$1.1
                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(Attr attr) {
                                Attr attr2 = attr;
                                attr2.size(50.0f, 50.0f);
                                attr2.absolutePositionAllZero();
                                return Unit.INSTANCE;
                            }
                        });
                        return Unit.INSTANCE;
                    }
                }, new Function3<p, Float, Float, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.itemview.guild.subchannel.view.GuildWaveAvatarView$createWaveView$1$2
                    {
                        super(3);
                    }

                    @Override // kotlin.jvm.functions.Function3
                    public final Unit invoke(p pVar, Float f16, Float f17) {
                        p pVar2 = pVar;
                        f16.floatValue();
                        f17.floatValue();
                        int i3 = GuildWaveAvatarView.access$getAttr(GuildWaveAvatarView.this).waveCount;
                        for (int i16 = 0; i16 < i3; i16++) {
                            float animOffset = GuildWaveAvatarView.this.getAnimOffset();
                            GuildWaveAvatarView guildWaveAvatarView2 = GuildWaveAvatarView.this;
                            float f18 = (animOffset - (i16 * guildWaveAvatarView2.waveDistance)) % guildWaveAvatarView2.radiusOffsetRange;
                            if (GuildWaveAvatarView.access$canAnim(guildWaveAvatarView2, i16, f18)) {
                                GuildWaveAvatarView guildWaveAvatarView3 = GuildWaveAvatarView.this;
                                float f19 = f18 / guildWaveAvatarView3.radiusOffsetRange;
                                float f26 = guildWaveAvatarView3.minRadius + f18;
                                float f27 = GuildWaveAvatarView.access$getAttr(guildWaveAvatarView3).maxStrokeWidth - ((GuildWaveAvatarView.access$getAttr(GuildWaveAvatarView.this).maxStrokeWidth - GuildWaveAvatarView.access$getAttr(GuildWaveAvatarView.this).minStrokeWidth) * f19);
                                float f28 = GuildWaveAvatarView.access$getAttr(GuildWaveAvatarView.this).maxAlpha;
                                float f29 = GuildWaveAvatarView.access$getAttr(GuildWaveAvatarView.this).maxAlpha;
                                GuildWaveAvatarView.access$getAttr(GuildWaveAvatarView.this).getClass();
                                h hVar = new h(GuildWaveAvatarView.access$getAttr(GuildWaveAvatarView.this).colorR, GuildWaveAvatarView.access$getAttr(GuildWaveAvatarView.this).colorG, GuildWaveAvatarView.access$getAttr(GuildWaveAvatarView.this).colorB, f28 - ((f29 - 0.0f) * f19));
                                GuildWaveAvatarView.this.getClass();
                                pVar2.b();
                                pVar2.n(hVar);
                                pVar2.j(f27);
                                pVar2.k(25.0f + f26, 25.0f);
                                pVar2.a(25.0f, 25.0f, f26, 0.0f, 6.2831855f, false);
                                pVar2.m();
                            }
                        }
                        return Unit.INSTANCE;
                    }
                });
                final GuildWaveAvatarView guildWaveAvatarView2 = GuildWaveAvatarView.this;
                ah.a(viewContainer2, new Function1<ImageView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.itemview.guild.subchannel.view.GuildWaveAvatarView$body$1.2
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(ImageView imageView) {
                        final GuildWaveAvatarView guildWaveAvatarView3 = GuildWaveAvatarView.this;
                        imageView.attr(new Function1<af, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.itemview.guild.subchannel.view.GuildWaveAvatarView.body.1.2.1
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(af afVar) {
                                af afVar2 = afVar;
                                afVar2.marginLeft(6.0f);
                                afVar2.marginTop(6.0f);
                                afVar2.size(38.0f, 38.0f);
                                afVar2.borderRadius(19.0f);
                                b.a.b(afVar2, GuildWaveAvatarView.access$getAttr(GuildWaveAvatarView.this).src, false, 2, null);
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
        return new GuildWaveAvatarAttr();
    }

    @Override // com.tencent.kuikly.core.base.AbstractBaseView
    public final Event createEvent() {
        return new GuildWaveAvatarEvent();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.tencent.kuikly.core.base.ComposeView
    public final void created() {
        super.created();
        float f16 = 2;
        this.minRadius = (38.0f - ((GuildWaveAvatarAttr) getAttr()).maxStrokeWidth) / f16;
        float f17 = ((((GuildWaveAvatarAttr) getAttr()).minStrokeWidth + 50.0f) / f16) - this.minRadius;
        this.radiusOffsetRange = f17;
        this.animStep = f17 / 120;
        this.waveDistance = f17 / ((GuildWaveAvatarAttr) getAttr()).waveCount;
        if (((GuildWaveAvatarAttr) getAttr()).maxStrokeWidth >= this.waveDistance) {
            ((GuildWaveAvatarAttr) getAttr()).maxStrokeWidth = this.waveDistance;
        }
        if (((GuildWaveAvatarAttr) getAttr()).minStrokeWidth > ((GuildWaveAvatarAttr) getAttr()).maxStrokeWidth) {
            ((GuildWaveAvatarAttr) getAttr()).minStrokeWidth = ((GuildWaveAvatarAttr) getAttr()).maxStrokeWidth;
        }
        bindValueChange(new Function0<Object>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.itemview.guild.subchannel.view.GuildWaveAvatarView$created$1
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                GuildWaveAvatarAttr access$getAttr = GuildWaveAvatarView.access$getAttr(GuildWaveAvatarView.this);
                return Boolean.valueOf(((Boolean) access$getAttr.play$delegate.getValue(access$getAttr, GuildWaveAvatarAttr.$$delegatedProperties[0])).booleanValue());
            }
        }, new Function1<Object, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.itemview.guild.subchannel.view.GuildWaveAvatarView$created$2
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Unit invoke(Object obj) {
                GuildWaveAvatarView.access$updatePlayStatus(GuildWaveAvatarView.this);
                return Unit.INSTANCE;
            }
        });
        bindValueChange(new Function0<Object>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.itemview.guild.subchannel.view.GuildWaveAvatarView$created$3
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                GuildWaveAvatarAttr access$getAttr = GuildWaveAvatarView.access$getAttr(GuildWaveAvatarView.this);
                return Boolean.valueOf(((Boolean) access$getAttr.userScrolling$delegate.getValue(access$getAttr, GuildWaveAvatarAttr.$$delegatedProperties[1])).booleanValue());
            }
        }, new Function1<Object, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.itemview.guild.subchannel.view.GuildWaveAvatarView$created$4
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Unit invoke(Object obj) {
                GuildWaveAvatarView.access$updatePlayStatus(GuildWaveAvatarView.this);
                return Unit.INSTANCE;
            }
        });
        bindValueChange(new Function0<Object>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.itemview.guild.subchannel.view.GuildWaveAvatarView$created$5
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return Boolean.valueOf(GuildWaveAvatarView.this.getCanPlay());
            }
        }, new Function1<Object, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.itemview.guild.subchannel.view.GuildWaveAvatarView$created$6
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Unit invoke(Object obj) {
                if (GuildWaveAvatarView.this.getCanPlay()) {
                    if (GuildWaveAvatarView.this.getAnimOffset() == 0.0f) {
                        GuildWaveAvatarView.access$play(GuildWaveAvatarView.this);
                    }
                }
                return Unit.INSTANCE;
            }
        });
    }

    public final float getAnimOffset() {
        return ((Number) this.animOffset$delegate.getValue(this, $$delegatedProperties[0])).floatValue();
    }

    public final boolean getCanPlay() {
        return ((Boolean) this.canPlay$delegate.getValue(this, $$delegatedProperties[1])).booleanValue();
    }

    public final void setAnimOffset(float f16) {
        this.animOffset$delegate.setValue(this, $$delegatedProperties[0], Float.valueOf(f16));
    }

    @Override // com.tencent.kuikly.core.base.ComposeView
    public final void viewDestroyed() {
        this.canPlay$delegate.setValue(this, $$delegatedProperties[1], Boolean.FALSE);
    }
}

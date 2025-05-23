package com.tencent.kuikly.core.views.compose;

import com.tencent.kuikly.core.base.k;
import com.tencent.kuikly.core.base.m;
import com.tencent.kuikly.core.layout.FlexDirection;
import com.tencent.kuikly.core.views.af;
import com.tencent.kuikly.core.views.ce;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.MutablePropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.properties.ReadWriteProperty;
import kotlin.reflect.KProperty;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\u0010\n\u0002\u0010\u0007\n\u0002\b\u000b\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b5\u00106J\u001f\u0010\u0007\u001a\u00020\u00042\u0017\u0010\u0006\u001a\u0013\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u0002\u00a2\u0006\u0002\b\u0005J\u001f\u0010\t\u001a\u00020\u00042\u0017\u0010\u0006\u001a\u0013\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u00040\u0002\u00a2\u0006\u0002\b\u0005J\u0010\u0010\f\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\nH\u0016J\u0010\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u000e\u001a\u00020\rH\u0016R5\u0010\u0016\u001a\u0015\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0002\u00a2\u0006\u0002\b\u00058\u0000@\u0000X\u0080\u000e\u00a2\u0006\u0012\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R5\u0010\u001a\u001a\u0015\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0002\u00a2\u0006\u0002\b\u00058\u0000@\u0000X\u0080\u000e\u00a2\u0006\u0012\n\u0004\b\u0017\u0010\u0011\u001a\u0004\b\u0018\u0010\u0013\"\u0004\b\u0019\u0010\u0015R\u0016\u0010\u001e\u001a\u00020\u001b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001c\u0010\u001dR\"\u0010$\u001a\u00020\u001b8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001f\u0010\u001d\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#R$\u0010+\u001a\u0004\u0018\u00010\n8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b%\u0010&\u001a\u0004\b'\u0010(\"\u0004\b)\u0010*R+\u00104\u001a\u00020,2\u0006\u0010-\u001a\u00020,8F@FX\u0086\u008e\u0002\u00a2\u0006\u0012\n\u0004\b.\u0010/\u001a\u0004\b0\u00101\"\u0004\b2\u00103\u00a8\u00067"}, d2 = {"Lcom/tencent/kuikly/core/views/compose/a;", "Lcom/tencent/kuikly/core/base/k;", "Lkotlin/Function1;", "Lcom/tencent/kuikly/core/views/ce;", "", "Lkotlin/ExtensionFunctionType;", "init", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "Lcom/tencent/kuikly/core/views/af;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lcom/tencent/kuikly/core/base/h;", "color", "highlightBackgroundColor", "Lcom/tencent/kuikly/core/layout/FlexDirection;", NodeProps.FLEX_DIRECTION, "Lcom/tencent/kuikly/core/base/m;", "a", "Lkotlin/jvm/functions/Function1;", "l", "()Lkotlin/jvm/functions/Function1;", "setTitleAttrInit$core_release", "(Lkotlin/jvm/functions/Function1;)V", "titleAttrInit", "b", "k", "setImageAttrInit$core_release", "imageAttrInit", "", "c", "Z", "setFlexDirection", "d", h.F, "()Z", DomainData.DOMAIN_NAME, "(Z)V", "enableForeground", "e", "Lcom/tencent/kuikly/core/base/h;", "i", "()Lcom/tencent/kuikly/core/base/h;", "o", "(Lcom/tencent/kuikly/core/base/h;)V", "foregroundColor", "", "<set-?>", "f", "Lkotlin/properties/ReadWriteProperty;", "j", "()F", "p", "(F)V", "foregroundPercent", "<init>", "()V", "core_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes33.dex */
public final class a extends k {

    /* renamed from: g, reason: collision with root package name */
    static final /* synthetic */ KProperty<Object>[] f118483g = {Reflection.mutableProperty1(new MutablePropertyReference1Impl(a.class, "foregroundPercent", "getForegroundPercent()F", 0))};

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private Function1<? super ce, Unit> titleAttrInit;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private Function1<? super af, Unit> imageAttrInit;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private boolean setFlexDirection;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private boolean enableForeground;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private com.tencent.kuikly.core.base.h foregroundColor;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private final ReadWriteProperty foregroundPercent = c01.c.a(Float.valueOf(0.0f));

    /* renamed from: h, reason: from getter */
    public final boolean getEnableForeground() {
        return this.enableForeground;
    }

    @Override // com.tencent.kuikly.core.views.internal.GroupAttr, com.tencent.kuikly.core.base.m
    public void highlightBackgroundColor(com.tencent.kuikly.core.base.h color) {
        Intrinsics.checkNotNullParameter(color, "color");
        super.highlightBackgroundColor(color);
    }

    /* renamed from: i, reason: from getter */
    public final com.tencent.kuikly.core.base.h getForegroundColor() {
        return this.foregroundColor;
    }

    public final float j() {
        return ((Number) this.foregroundPercent.getValue(this, f118483g[0])).floatValue();
    }

    public final Function1<af, Unit> k() {
        return this.imageAttrInit;
    }

    public final Function1<ce, Unit> l() {
        return this.titleAttrInit;
    }

    public final void m(Function1<? super af, Unit> init) {
        Intrinsics.checkNotNullParameter(init, "init");
        this.imageAttrInit = init;
        if (this.setFlexDirection) {
            return;
        }
        super.flexDirection(FlexDirection.ROW);
    }

    public final void n(boolean z16) {
        this.enableForeground = z16;
    }

    public final void o(com.tencent.kuikly.core.base.h hVar) {
        this.foregroundColor = hVar;
    }

    public final void p(float f16) {
        this.foregroundPercent.setValue(this, f118483g[0], Float.valueOf(f16));
    }

    public final void q(Function1<? super ce, Unit> init) {
        Intrinsics.checkNotNullParameter(init, "init");
        this.titleAttrInit = init;
    }

    @Override // com.tencent.kuikly.core.base.m
    public m flexDirection(FlexDirection flexDirection) {
        Intrinsics.checkNotNullParameter(flexDirection, "flexDirection");
        this.setFlexDirection = true;
        return super.flexDirection(flexDirection);
    }
}

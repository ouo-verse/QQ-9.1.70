package com.tencent.kuikly.core.views;

import com.tencent.kuikly.core.base.Attr;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.dns.DomainData;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.MutablePropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.properties.ReadWriteProperty;
import kotlin.reflect.KProperty;

/* compiled from: P */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b$\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b2\u00103J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u001f\u0010\n\u001a\u00020\u00042\u0017\u0010\t\u001a\u0013\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00040\u0006\u00a2\u0006\u0002\b\bJ\u001f\u0010\f\u001a\u00020\u00042\u0017\u0010\u000b\u001a\u0013\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00040\u0006\u00a2\u0006\u0002\b\bJ\u000e\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\rR\"\u0010\u0017\u001a\u00020\u00108\u0000@\u0000X\u0080\u000e\u00a2\u0006\u0012\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R+\u0010\u001f\u001a\u00020\u00022\u0006\u0010\u0018\u001a\u00020\u00028@@@X\u0080\u008e\u0002\u00a2\u0006\u0012\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR5\u0010&\u001a\u0015\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0006\u00a2\u0006\u0002\b\b8\u0000@\u0000X\u0080\u000e\u00a2\u0006\u0012\n\u0004\b \u0010!\u001a\u0004\b\"\u0010#\"\u0004\b$\u0010%R5\u0010*\u001a\u0015\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0006\u00a2\u0006\u0002\b\b8\u0000@\u0000X\u0080\u000e\u00a2\u0006\u0012\n\u0004\b'\u0010!\u001a\u0004\b(\u0010#\"\u0004\b)\u0010%R$\u00101\u001a\u0004\u0018\u00010\r8\u0000@\u0000X\u0080\u000e\u00a2\u0006\u0012\n\u0004\b+\u0010,\u001a\u0004\b-\u0010.\"\u0004\b/\u00100\u00a8\u00064"}, d2 = {"Lcom/tencent/kuikly/core/views/ci;", "Lcom/tencent/kuikly/core/base/m;", "", "enterOrExit", "", "r", "Lkotlin/Function1;", "Lcom/tencent/kuikly/core/base/Attr;", "Lkotlin/ExtensionFunctionType;", "beginAttr", "i", "endAttr", "j", "Lcom/tencent/kuikly/core/base/b;", "animation", tl.h.F, "Lcom/tencent/kuikly/core/views/TransitionType;", "a", "Lcom/tencent/kuikly/core/views/TransitionType;", "o", "()Lcom/tencent/kuikly/core/views/TransitionType;", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "(Lcom/tencent/kuikly/core/views/TransitionType;)V", "transitionType", "<set-?>", "b", "Lkotlin/properties/ReadWriteProperty;", DomainData.DOMAIN_NAME, "()Z", "p", "(Z)V", "transitionAppear", "c", "Lkotlin/jvm/functions/Function1;", "l", "()Lkotlin/jvm/functions/Function1;", "setBeginAnimationAttr$core_release", "(Lkotlin/jvm/functions/Function1;)V", "beginAnimationAttr", "d", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "setEndAnimationAttr$core_release", "endAnimationAttr", "e", "Lcom/tencent/kuikly/core/base/b;", "k", "()Lcom/tencent/kuikly/core/base/b;", "setAnimationConfig$core_release", "(Lcom/tencent/kuikly/core/base/b;)V", "animationConfig", "<init>", "()V", "core_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes33.dex */
public final class ci extends com.tencent.kuikly.core.base.m {

    /* renamed from: f, reason: collision with root package name */
    static final /* synthetic */ KProperty<Object>[] f118439f = {Reflection.mutableProperty1(new MutablePropertyReference1Impl(ci.class, "transitionAppear", "getTransitionAppear$core_release()Z", 0))};

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private TransitionType transitionType = TransitionType.NONE;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private final ReadWriteProperty transitionAppear = c01.c.a(Boolean.TRUE);

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private Function1<? super Attr, Unit> beginAnimationAttr;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private Function1<? super Attr, Unit> endAnimationAttr;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private com.tencent.kuikly.core.base.b animationConfig;

    public final void h(com.tencent.kuikly.core.base.b animation) {
        Intrinsics.checkNotNullParameter(animation, "animation");
        this.animationConfig = animation;
    }

    public final void i(Function1<? super Attr, Unit> beginAttr) {
        Intrinsics.checkNotNullParameter(beginAttr, "beginAttr");
        this.beginAnimationAttr = beginAttr;
    }

    public final void j(Function1<? super Attr, Unit> endAttr) {
        Intrinsics.checkNotNullParameter(endAttr, "endAttr");
        this.endAnimationAttr = endAttr;
    }

    /* renamed from: k, reason: from getter */
    public final com.tencent.kuikly.core.base.b getAnimationConfig() {
        return this.animationConfig;
    }

    public final Function1<Attr, Unit> l() {
        return this.beginAnimationAttr;
    }

    public final Function1<Attr, Unit> m() {
        return this.endAnimationAttr;
    }

    public final boolean n() {
        return ((Boolean) this.transitionAppear.getValue(this, f118439f[0])).booleanValue();
    }

    /* renamed from: o, reason: from getter */
    public final TransitionType getTransitionType() {
        return this.transitionType;
    }

    public final void p(boolean z16) {
        this.transitionAppear.setValue(this, f118439f[0], Boolean.valueOf(z16));
    }

    public final void q(TransitionType transitionType) {
        Intrinsics.checkNotNullParameter(transitionType, "<set-?>");
        this.transitionType = transitionType;
    }

    public final void r(boolean enterOrExit) {
        p(enterOrExit);
    }
}

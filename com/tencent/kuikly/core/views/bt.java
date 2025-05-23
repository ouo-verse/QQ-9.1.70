package com.tencent.kuikly.core.views;

import com.heytap.databaseengine.model.UserInfo;
import com.tencent.kuikly.core.base.h;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.dns.DomainData;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.MutablePropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.properties.ReadWriteProperty;
import kotlin.reflect.KProperty;

/* compiled from: P */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0002\b#\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b,\u0010-J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006J\u000e\u0010\t\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006J\u000e\u0010\n\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006J\u000e\u0010\r\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u000bR\"\u0010\u0014\u001a\u00020\u00068\u0000@\u0000X\u0080\u000e\u00a2\u0006\u0012\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\"\u0010\u0018\u001a\u00020\u00068\u0000@\u0000X\u0080\u000e\u00a2\u0006\u0012\n\u0004\b\u0015\u0010\u000f\u001a\u0004\b\u0016\u0010\u0011\"\u0004\b\u0017\u0010\u0013R\"\u0010\u001c\u001a\u00020\u00068\u0000@\u0000X\u0080\u000e\u00a2\u0006\u0012\n\u0004\b\u0019\u0010\u000f\u001a\u0004\b\u001a\u0010\u0011\"\u0004\b\u001b\u0010\u0013R+\u0010$\u001a\u00020\u00022\u0006\u0010\u001d\u001a\u00020\u00028@@@X\u0080\u008e\u0002\u00a2\u0006\u0012\n\u0004\b\u001e\u0010\u001f\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#R\"\u0010+\u001a\u00020\u000b8\u0000@\u0000X\u0080\u000e\u00a2\u0006\u0012\n\u0004\b%\u0010&\u001a\u0004\b'\u0010(\"\u0004\b)\u0010*\u00a8\u0006."}, d2 = {"Lcom/tencent/kuikly/core/views/bt;", "Lcom/tencent/kuikly/core/base/k;", "", "on", "", "l", "Lcom/tencent/kuikly/core/base/h;", "color", DomainData.DOMAIN_NAME, "r", "p", "", "margin", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "a", "Lcom/tencent/kuikly/core/base/h;", "i", "()Lcom/tencent/kuikly/core/base/h;", "setThumbColor$core_release", "(Lcom/tencent/kuikly/core/base/h;)V", "thumbColor", "b", tl.h.F, "setOnColor$core_release", "onColor", "c", "k", "setUnOnColor$core_release", "unOnColor", "<set-?>", "d", "Lkotlin/properties/ReadWriteProperty;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "()Z", "o", "(Z)V", "isOn", "e", UserInfo.SEX_FEMALE, "j", "()F", "setThumbMargin$core_release", "(F)V", "thumbMargin", "<init>", "()V", "core_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes33.dex */
public final class bt extends com.tencent.kuikly.core.base.k {

    /* renamed from: f, reason: collision with root package name */
    static final /* synthetic */ KProperty<Object>[] f118419f = {Reflection.mutableProperty1(new MutablePropertyReference1Impl(bt.class, "isOn", "isOn$core_release()Z", 0))};

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private com.tencent.kuikly.core.base.h thumbColor;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private com.tencent.kuikly.core.base.h onColor;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private com.tencent.kuikly.core.base.h unOnColor;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private final ReadWriteProperty isOn;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private float thumbMargin;

    public bt() {
        h.Companion companion = com.tencent.kuikly.core.base.h.INSTANCE;
        this.thumbColor = companion.m();
        this.onColor = companion.f();
        this.unOnColor = companion.e();
        this.isOn = c01.c.a(Boolean.FALSE);
        this.thumbMargin = 2.0f;
    }

    /* renamed from: h, reason: from getter */
    public final com.tencent.kuikly.core.base.h getOnColor() {
        return this.onColor;
    }

    /* renamed from: i, reason: from getter */
    public final com.tencent.kuikly.core.base.h getThumbColor() {
        return this.thumbColor;
    }

    /* renamed from: j, reason: from getter */
    public final float getThumbMargin() {
        return this.thumbMargin;
    }

    /* renamed from: k, reason: from getter */
    public final com.tencent.kuikly.core.base.h getUnOnColor() {
        return this.unOnColor;
    }

    public final void l(boolean on5) {
        o(on5);
    }

    public final boolean m() {
        return ((Boolean) this.isOn.getValue(this, f118419f[0])).booleanValue();
    }

    public final void n(com.tencent.kuikly.core.base.h color) {
        Intrinsics.checkNotNullParameter(color, "color");
        this.onColor = color;
    }

    public final void o(boolean z16) {
        this.isOn.setValue(this, f118419f[0], Boolean.valueOf(z16));
    }

    public final void p(com.tencent.kuikly.core.base.h color) {
        Intrinsics.checkNotNullParameter(color, "color");
        this.thumbColor = color;
    }

    public final void q(float margin) {
        this.thumbMargin = margin;
    }

    public final void r(com.tencent.kuikly.core.base.h color) {
        Intrinsics.checkNotNullParameter(color, "color");
        this.unOnColor = color;
    }
}

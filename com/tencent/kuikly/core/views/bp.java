package com.tencent.kuikly.core.views;

import androidx.exifinterface.media.ExifInterface;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.kuikly.core.base.Attr;
import com.tencent.kuikly.core.base.ViewContainer;
import com.tencent.kuikly.core.base.h;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FloatCompanionObject;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.MutablePropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.properties.ReadWriteProperty;
import kotlin.reflect.KProperty;

/* compiled from: P */
@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b(\n\u0002\u0018\u0002\n\u0002\b\u001d\n\u0002\u0010\u000b\n\u0002\b\n\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\bf\u0010gJ\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0002H\u0016J(\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\u0002H\u0016J\u000e\u0010\u000e\u001a\u00020\r2\u0006\u0010\f\u001a\u00020\u0002J+\u0010\u0014\u001a\u00020\r2#\u0010\u0013\u001a\u001f\u0012\f\u0012\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u0010\u0012\u0004\u0012\u00020\r0\u000fj\u0002`\u0011\u00a2\u0006\u0002\b\u0012J+\u0010\u0015\u001a\u00020\r2#\u0010\u0013\u001a\u001f\u0012\f\u0012\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u0010\u0012\u0004\u0012\u00020\r0\u000fj\u0002`\u0011\u00a2\u0006\u0002\b\u0012J+\u0010\u0016\u001a\u00020\r2#\u0010\u0013\u001a\u001f\u0012\f\u0012\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u0010\u0012\u0004\u0012\u00020\r0\u000fj\u0002`\u0011\u00a2\u0006\u0002\b\u0012J\u000e\u0010\u0019\u001a\u00020\r2\u0006\u0010\u0018\u001a\u00020\u0017J\u000e\u0010\u001a\u001a\u00020\r2\u0006\u0010\u0018\u001a\u00020\u0017RC\u0010!\u001a#\u0012\f\u0012\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u0010\u0012\u0004\u0012\u00020\r\u0018\u00010\u000fj\u0004\u0018\u0001`\u0011\u00a2\u0006\u0002\b\u00128\u0000@\u0000X\u0080\u000e\u00a2\u0006\u0012\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 RC\u0010%\u001a#\u0012\f\u0012\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u0010\u0012\u0004\u0012\u00020\r\u0018\u00010\u000fj\u0004\u0018\u0001`\u0011\u00a2\u0006\u0002\b\u00128\u0000@\u0000X\u0080\u000e\u00a2\u0006\u0012\n\u0004\b\"\u0010\u001c\u001a\u0004\b#\u0010\u001e\"\u0004\b$\u0010 RC\u0010)\u001a#\u0012\f\u0012\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u0010\u0012\u0004\u0012\u00020\r\u0018\u00010\u000fj\u0004\u0018\u0001`\u0011\u00a2\u0006\u0002\b\u00128\u0000@\u0000X\u0080\u000e\u00a2\u0006\u0012\n\u0004\b&\u0010\u001c\u001a\u0004\b'\u0010\u001e\"\u0004\b(\u0010 R+\u00101\u001a\u00020\u00172\u0006\u0010*\u001a\u00020\u00178@@@X\u0080\u008e\u0002\u00a2\u0006\u0012\n\u0004\b+\u0010,\u001a\u0004\b-\u0010.\"\u0004\b/\u00100R+\u00105\u001a\u00020\u00172\u0006\u0010*\u001a\u00020\u00178@@@X\u0080\u008e\u0002\u00a2\u0006\u0012\n\u0004\b2\u0010,\u001a\u0004\b3\u0010.\"\u0004\b4\u00100R+\u00109\u001a\u00020\u00172\u0006\u0010*\u001a\u00020\u00178@@@X\u0080\u008e\u0002\u00a2\u0006\u0012\n\u0004\b6\u0010,\u001a\u0004\b7\u0010.\"\u0004\b8\u00100R+\u0010?\u001a\u00020\u00022\u0006\u0010*\u001a\u00020\u00028@@@X\u0080\u008e\u0002\u00a2\u0006\u0012\n\u0004\b:\u0010,\u001a\u0004\b;\u0010<\"\u0004\b=\u0010>R+\u0010E\u001a\u00020@2\u0006\u0010*\u001a\u00020@8@@@X\u0080\u008e\u0002\u00a2\u0006\u0012\n\u0004\b\u000e\u0010,\u001a\u0004\bA\u0010B\"\u0004\bC\u0010DR+\u0010I\u001a\u00020\u00022\u0006\u0010*\u001a\u00020\u00028@@@X\u0080\u008e\u0002\u00a2\u0006\u0012\n\u0004\bF\u0010,\u001a\u0004\bG\u0010<\"\u0004\bH\u0010>R+\u0010M\u001a\u00020\u00022\u0006\u0010*\u001a\u00020\u00028@@@X\u0080\u008e\u0002\u00a2\u0006\u0012\n\u0004\bJ\u0010,\u001a\u0004\bK\u0010<\"\u0004\bL\u0010>R+\u0010P\u001a\u00020\u00022\u0006\u0010*\u001a\u00020\u00028@@@X\u0080\u008e\u0002\u00a2\u0006\u0012\n\u0004\bG\u0010,\u001a\u0004\bN\u0010<\"\u0004\bO\u0010>R+\u0010T\u001a\u00020\u00022\u0006\u0010*\u001a\u00020\u00028@@@X\u0080\u008e\u0002\u00a2\u0006\u0012\n\u0004\bQ\u0010,\u001a\u0004\bR\u0010<\"\u0004\bS\u0010>R+\u0010X\u001a\u00020\u00022\u0006\u0010*\u001a\u00020\u00028@@@X\u0080\u008e\u0002\u00a2\u0006\u0012\n\u0004\bU\u0010,\u001a\u0004\bV\u0010<\"\u0004\bW\u0010>R+\u0010[\u001a\u00020\u00022\u0006\u0010*\u001a\u00020\u00028@@@X\u0080\u008e\u0002\u00a2\u0006\u0012\n\u0004\bR\u0010,\u001a\u0004\bY\u0010<\"\u0004\bZ\u0010>R+\u0010]\u001a\u00020\u00022\u0006\u0010*\u001a\u00020\u00028@@@X\u0080\u008e\u0002\u00a2\u0006\u0012\n\u0004\bY\u0010,\u001a\u0004\bU\u0010<\"\u0004\b\\\u0010>R\"\u0010c\u001a\u00020^8\u0000@\u0000X\u0080\u000e\u00a2\u0006\u0012\n\u0004\bV\u0010_\u001a\u0004\bQ\u0010`\"\u0004\ba\u0010bR\u0014\u0010d\u001a\u00020\u00028@X\u0080\u0004\u00a2\u0006\u0006\u001a\u0004\bJ\u0010<R\u0014\u0010e\u001a\u00020\u00028@X\u0080\u0004\u00a2\u0006\u0006\u001a\u0004\bF\u0010<\u00a8\u0006h"}, d2 = {"Lcom/tencent/kuikly/core/views/bp;", "Lcom/tencent/kuikly/core/base/k;", "", "width", "Lcom/tencent/kuikly/core/base/Attr;", "height", "top", "left", "bottom", "right", "Lcom/tencent/kuikly/core/base/m;", "padding", "progress01", "", tl.h.F, "Lkotlin/Function1;", "Lcom/tencent/kuikly/core/base/ViewContainer;", "Lcom/tencent/kuikly/core/base/ViewBuilder;", "Lkotlin/ExtensionFunctionType;", "creator", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "N", "L", "Lcom/tencent/kuikly/core/base/h;", "color", "M", "K", "a", "Lkotlin/jvm/functions/Function1;", "r", "()Lkotlin/jvm/functions/Function1;", "setProgressViewCreator$core_release", "(Lkotlin/jvm/functions/Function1;)V", "progressViewCreator", "b", QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, "setTrackViewCreator$core_release", "trackViewCreator", "c", "w", "setThumbViewCreator$core_release", "thumbViewCreator", "<set-?>", "d", "Lkotlin/properties/ReadWriteProperty;", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "()Lcom/tencent/kuikly/core/base/h;", "setProgressColor$core_release", "(Lcom/tencent/kuikly/core/base/h;)V", "progressColor", "e", HippyTKDListViewAdapter.X, "J", "trackColor", "f", "u", "I", "thumbColor", "g", "y", "()F", "setTrackThickness$core_release", "(F)V", "trackThickness", "Lcom/tencent/kuikly/core/base/w;", "v", "()Lcom/tencent/kuikly/core/base/w;", "setThumbSize$core_release", "(Lcom/tencent/kuikly/core/base/w;)V", "thumbSize", "i", "k", "B", "currentProgress", "j", "t", "H", "sliderWidth", ReportConstant.COSTREPORT_PREFIX, "G", "sliderHeight", "l", DomainData.DOMAIN_NAME, "D", NodeProps.PADDING_LEFT, QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "p", UserInfo.SEX_FEMALE, NodeProps.PADDING_TOP, "o", "E", NodeProps.PADDING_RIGHT, BdhLogUtil.LogTag.Tag_Conn, NodeProps.PADDING_BOTTOM, "", "Z", "()Z", "setDirectionHorizontal$core_release", "(Z)V", "directionHorizontal", "contentWidth", "contentHeight", "<init>", "()V", "core_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes33.dex */
public final class bp extends com.tencent.kuikly.core.base.k {

    /* renamed from: q, reason: collision with root package name */
    static final /* synthetic */ KProperty<Object>[] f118396q = {Reflection.mutableProperty1(new MutablePropertyReference1Impl(bp.class, "progressColor", "getProgressColor$core_release()Lcom/tencent/kuikly/core/base/Color;", 0)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(bp.class, "trackColor", "getTrackColor$core_release()Lcom/tencent/kuikly/core/base/Color;", 0)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(bp.class, "thumbColor", "getThumbColor$core_release()Lcom/tencent/kuikly/core/base/Color;", 0)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(bp.class, "trackThickness", "getTrackThickness$core_release()F", 0)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(bp.class, "thumbSize", "getThumbSize$core_release()Lcom/tencent/kuikly/core/base/Size;", 0)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(bp.class, "currentProgress", "getCurrentProgress$core_release()F", 0)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(bp.class, "sliderWidth", "getSliderWidth$core_release()F", 0)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(bp.class, "sliderHeight", "getSliderHeight$core_release()F", 0)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(bp.class, NodeProps.PADDING_LEFT, "getPaddingLeft$core_release()F", 0)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(bp.class, NodeProps.PADDING_TOP, "getPaddingTop$core_release()F", 0)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(bp.class, NodeProps.PADDING_RIGHT, "getPaddingRight$core_release()F", 0)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(bp.class, NodeProps.PADDING_BOTTOM, "getPaddingBottom$core_release()F", 0))};

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private Function1<? super ViewContainer<?, ?>, Unit> progressViewCreator;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private Function1<? super ViewContainer<?, ?>, Unit> trackViewCreator;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private Function1<? super ViewContainer<?, ?>, Unit> thumbViewCreator;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private final ReadWriteProperty progressColor;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private final ReadWriteProperty trackColor;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private final ReadWriteProperty thumbColor;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    private final ReadWriteProperty trackThickness;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private final ReadWriteProperty thumbSize;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private final ReadWriteProperty currentProgress;

    /* renamed from: j, reason: collision with root package name and from kotlin metadata */
    private final ReadWriteProperty sliderWidth;

    /* renamed from: k, reason: collision with root package name and from kotlin metadata */
    private final ReadWriteProperty sliderHeight;

    /* renamed from: l, reason: collision with root package name and from kotlin metadata */
    private final ReadWriteProperty paddingLeft;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private final ReadWriteProperty paddingTop;

    /* renamed from: n, reason: collision with root package name and from kotlin metadata */
    private final ReadWriteProperty paddingRight;

    /* renamed from: o, reason: collision with root package name and from kotlin metadata */
    private final ReadWriteProperty paddingBottom;

    /* renamed from: p, reason: collision with root package name and from kotlin metadata */
    private boolean directionHorizontal;

    public bp() {
        h.Companion companion = com.tencent.kuikly.core.base.h.INSTANCE;
        this.progressColor = c01.c.a(companion.c());
        this.trackColor = c01.c.a(companion.e());
        this.thumbColor = c01.c.a(companion.m());
        this.trackThickness = c01.c.a(Float.valueOf(5.0f));
        this.thumbSize = c01.c.a(new com.tencent.kuikly.core.base.w(10.0f, 10.0f));
        Float valueOf = Float.valueOf(0.0f);
        this.currentProgress = c01.c.a(valueOf);
        this.sliderWidth = c01.c.a(valueOf);
        this.sliderHeight = c01.c.a(valueOf);
        this.paddingLeft = c01.c.a(valueOf);
        this.paddingTop = c01.c.a(valueOf);
        this.paddingRight = c01.c.a(valueOf);
        this.paddingBottom = c01.c.a(valueOf);
        this.directionHorizontal = true;
    }

    public final void A(Function1<? super ViewContainer<?, ?>, Unit> creator) {
        Intrinsics.checkNotNullParameter(creator, "creator");
        this.progressViewCreator = creator;
    }

    public final void B(float f16) {
        this.currentProgress.setValue(this, f118396q[5], Float.valueOf(f16));
    }

    public final void C(float f16) {
        this.paddingBottom.setValue(this, f118396q[11], Float.valueOf(f16));
    }

    public final void D(float f16) {
        this.paddingLeft.setValue(this, f118396q[8], Float.valueOf(f16));
    }

    public final void E(float f16) {
        this.paddingRight.setValue(this, f118396q[10], Float.valueOf(f16));
    }

    public final void F(float f16) {
        this.paddingTop.setValue(this, f118396q[9], Float.valueOf(f16));
    }

    public final void G(float f16) {
        this.sliderHeight.setValue(this, f118396q[7], Float.valueOf(f16));
    }

    public final void H(float f16) {
        this.sliderWidth.setValue(this, f118396q[6], Float.valueOf(f16));
    }

    public final void I(com.tencent.kuikly.core.base.h hVar) {
        Intrinsics.checkNotNullParameter(hVar, "<set-?>");
        this.thumbColor.setValue(this, f118396q[2], hVar);
    }

    public final void J(com.tencent.kuikly.core.base.h hVar) {
        Intrinsics.checkNotNullParameter(hVar, "<set-?>");
        this.trackColor.setValue(this, f118396q[1], hVar);
    }

    public final void K(com.tencent.kuikly.core.base.h color) {
        Intrinsics.checkNotNullParameter(color, "color");
        I(color);
    }

    public final void L(Function1<? super ViewContainer<?, ?>, Unit> creator) {
        Intrinsics.checkNotNullParameter(creator, "creator");
        this.thumbViewCreator = creator;
    }

    public final void M(com.tencent.kuikly.core.base.h color) {
        Intrinsics.checkNotNullParameter(color, "color");
        J(color);
    }

    public final void N(Function1<? super ViewContainer<?, ?>, Unit> creator) {
        Intrinsics.checkNotNullParameter(creator, "creator");
        this.trackViewCreator = creator;
    }

    public final void h(float progress01) {
        B(progress01);
    }

    public final float i() {
        return (s() - p()) - m();
    }

    public final float j() {
        return (t() - n()) - o();
    }

    public final float k() {
        return ((Number) this.currentProgress.getValue(this, f118396q[5])).floatValue();
    }

    /* renamed from: l, reason: from getter */
    public final boolean getDirectionHorizontal() {
        return this.directionHorizontal;
    }

    public final float m() {
        return ((Number) this.paddingBottom.getValue(this, f118396q[11])).floatValue();
    }

    public final float n() {
        return ((Number) this.paddingLeft.getValue(this, f118396q[8])).floatValue();
    }

    public final float o() {
        return ((Number) this.paddingRight.getValue(this, f118396q[10])).floatValue();
    }

    public final float p() {
        return ((Number) this.paddingTop.getValue(this, f118396q[9])).floatValue();
    }

    public final com.tencent.kuikly.core.base.h q() {
        return (com.tencent.kuikly.core.base.h) this.progressColor.getValue(this, f118396q[0]);
    }

    public final Function1<ViewContainer<?, ?>, Unit> r() {
        return this.progressViewCreator;
    }

    public final float s() {
        return ((Number) this.sliderHeight.getValue(this, f118396q[7])).floatValue();
    }

    public final float t() {
        return ((Number) this.sliderWidth.getValue(this, f118396q[6])).floatValue();
    }

    public final com.tencent.kuikly.core.base.h u() {
        return (com.tencent.kuikly.core.base.h) this.thumbColor.getValue(this, f118396q[2]);
    }

    public final com.tencent.kuikly.core.base.w v() {
        return (com.tencent.kuikly.core.base.w) this.thumbSize.getValue(this, f118396q[4]);
    }

    public final Function1<ViewContainer<?, ?>, Unit> w() {
        return this.thumbViewCreator;
    }

    public final com.tencent.kuikly.core.base.h x() {
        return (com.tencent.kuikly.core.base.h) this.trackColor.getValue(this, f118396q[1]);
    }

    public final float y() {
        return ((Number) this.trackThickness.getValue(this, f118396q[3])).floatValue();
    }

    public final Function1<ViewContainer<?, ?>, Unit> z() {
        return this.trackViewCreator;
    }

    @Override // com.tencent.kuikly.core.base.Attr
    /* renamed from: height */
    public Attr mo141height(float height) {
        G(height);
        return super.mo141height(height);
    }

    @Override // com.tencent.kuikly.core.base.m, com.tencent.kuikly.core.base.attr.a
    public com.tencent.kuikly.core.base.m padding(float top, float left, float bottom, float right) {
        FloatCompanionObject floatCompanionObject = FloatCompanionObject.INSTANCE;
        boolean z16 = true;
        if (Float.isNaN(Float.NaN) || Float.isNaN(left) ? Float.isNaN(Float.NaN) && Float.isNaN(left) : Math.abs(left - Float.NaN) < 1.0E-5f) {
            left = 0.0f;
        }
        D(left);
        if (Float.isNaN(Float.NaN) || Float.isNaN(top) ? Float.isNaN(Float.NaN) && Float.isNaN(top) : Math.abs(top - Float.NaN) < 1.0E-5f) {
            top = 0.0f;
        }
        F(top);
        if (Float.isNaN(Float.NaN) || Float.isNaN(right) ? Float.isNaN(Float.NaN) && Float.isNaN(right) : Math.abs(right - Float.NaN) < 1.0E-5f) {
            right = 0.0f;
        }
        E(right);
        if (Float.isNaN(Float.NaN) || Float.isNaN(bottom) ? !Float.isNaN(Float.NaN) || !Float.isNaN(bottom) : Math.abs(bottom - Float.NaN) >= 1.0E-5f) {
            z16 = false;
        }
        if (z16) {
            bottom = 0.0f;
        }
        C(bottom);
        return this;
    }

    @Override // com.tencent.kuikly.core.base.Attr
    /* renamed from: width */
    public Attr mo153width(float width) {
        H(width);
        return super.mo153width(width);
    }
}

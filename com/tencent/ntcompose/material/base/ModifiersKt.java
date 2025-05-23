package com.tencent.ntcompose.material.base;

import androidx.exifinterface.media.ExifInterface;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.ams.mosaic.jsengine.animation.basic.BasicAnimation;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.kuikly.core.base.AnimationType;
import com.tencent.kuikly.core.base.Attr;
import com.tencent.kuikly.core.base.BorderStyle;
import com.tencent.kuikly.core.base.Direction;
import com.tencent.kuikly.core.base.TimingFuncType;
import com.tencent.kuikly.core.base.b;
import com.tencent.kuikly.core.base.event.Event;
import com.tencent.kuikly.core.base.f;
import com.tencent.kuikly.core.base.g;
import com.tencent.kuikly.core.base.h;
import com.tencent.kuikly.core.base.j;
import com.tencent.kuikly.core.base.t;
import com.tencent.kuikly.core.base.u;
import com.tencent.kuikly.core.base.x;
import com.tencent.kuikly.core.base.y;
import com.tencent.kuikly.core.views.internal.GroupAttr;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.ntcompose.core.ComposeRenderView;
import com.tencent.ntcompose.core.i;
import com.tencent.qqmini.miniapp.widget.CanvasView;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.ArraysKt___ArraysKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u00a0\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0017\u001a\u0012\u0010\u0003\u001a\u00020\u0000*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0001\u001a\u0012\u0010\u0004\u001a\u00020\u0000*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0001\u001a\u0016\u0010\u0007\u001a\u00020\u0000*\u00020\u00002\b\b\u0002\u0010\u0006\u001a\u00020\u0005H\u0007\u001a\u0016\u0010\t\u001a\u00020\u0000*\u00020\u00002\b\b\u0002\u0010\u0006\u001a\u00020\bH\u0007\u001a\u0016\u0010\f\u001a\u00020\u0000*\u00020\u00002\b\b\u0002\u0010\u000b\u001a\u00020\nH\u0007\u001a\u0016\u0010\u000e\u001a\u00020\u0000*\u00020\u00002\b\b\u0002\u0010\r\u001a\u00020\nH\u0007\u001a\u0012\u0010\u0010\u001a\u00020\u0000*\u00020\u00002\u0006\u0010\u000f\u001a\u00020\b\u001a\u0012\u0010\u0013\u001a\u00020\u0000*\u00020\u00002\u0006\u0010\u0012\u001a\u00020\u0011\u001a*\u0010\u0018\u001a\u00020\u0000*\u00020\u00002\u0006\u0010\u0014\u001a\u00020\b2\u0006\u0010\u0015\u001a\u00020\b2\u0006\u0010\u0016\u001a\u00020\b2\u0006\u0010\u0017\u001a\u00020\b\u001a\u0012\u0010\u001b\u001a\u00020\u0000*\u00020\u00002\u0006\u0010\u001a\u001a\u00020\u0019\u001a-\u0010!\u001a\u00020\u0000*\u00020\u00002\u0006\u0010\u001d\u001a\u00020\u001c2\u0012\u0010 \u001a\n\u0012\u0006\b\u0001\u0012\u00020\u001f0\u001e\"\u00020\u001f\u00a2\u0006\u0004\b!\u0010\"\u001a$\u0010&\u001a\u00020\u0000*\u00020\u00002\u0006\u0010#\u001a\u00020\b2\u0006\u0010\u0002\u001a\u00020\u00012\b\b\u0002\u0010%\u001a\u00020$\u001a\u0012\u0010)\u001a\u00020\u0000*\u00020\u00002\u0006\u0010(\u001a\u00020'\u001a\u0012\u0010*\u001a\u00020\u0000*\u00020\u00002\u0006\u0010(\u001a\u00020'\u001a\u0012\u0010+\u001a\u00020\u0000*\u00020\u00002\u0006\u0010(\u001a\u00020'\u001a<\u00100\u001a\u00020\u0000*\u00020\u00002\n\b\u0002\u0010,\u001a\u0004\u0018\u00010'2\n\b\u0002\u0010-\u001a\u0004\u0018\u00010'2\n\b\u0002\u0010.\u001a\u0004\u0018\u00010'2\n\b\u0002\u0010/\u001a\u0004\u0018\u00010'H\u0002\u001a*\u00105\u001a\u00020\u0000*\u00020\u00002\u0006\u00101\u001a\u00020\b2\u0006\u00102\u001a\u00020\b2\u0006\u00103\u001a\u00020\b2\u0006\u00104\u001a\u00020\u0001\u001a\u0012\u00107\u001a\u00020\u0000*\u00020\u00002\u0006\u00106\u001a\u00020\b\u001a\u0012\u0010:\u001a\u00020\u0000*\u00020\u00002\u0006\u00109\u001a\u000208\u001a\u0012\u0010=\u001a\u00020\u0000*\u00020\u00002\u0006\u0010<\u001a\u00020;\u001a\u0016\u0010?\u001a\u00020\u0000*\u00020\u00002\b\b\u0002\u0010>\u001a\u00020\bH\u0007\u001a\u0016\u0010A\u001a\u00020\u0000*\u00020\u00002\b\b\u0002\u0010@\u001a\u00020\bH\u0007\u001a\u0014\u0010C\u001a\u00020\u0000*\u00020\u00002\b\b\u0002\u0010B\u001a\u00020\n\u001a\u00a1\u0001\u0010N\u001a\u00020\u0000*\u00020\u00002\n\b\u0002\u0010D\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010E\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010@\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010F\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010G\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010H\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010I\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010J\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010K\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010M\u001a\u0004\u0018\u00010L2\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u00192\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\n\u00a2\u0006\u0004\bN\u0010O\u001a%\u0010U\u001a\u00020\u0000*\u00020\u00002\u0017\u0010T\u001a\u0013\u0012\u0004\u0012\u00020Q\u0012\u0004\u0012\u00020R0P\u00a2\u0006\u0002\bSH\u0007\u001a<\u0010`\u001a\u00020\u0000*\u00020\u00002\b\b\u0002\u0010W\u001a\u00020V2\b\b\u0002\u0010Y\u001a\u00020X2\b\b\u0002\u0010[\u001a\u00020Z2\b\b\u0002\u0010]\u001a\u00020\\2\b\b\u0002\u0010_\u001a\u00020^\u001a\u001e\u0010a\u001a\u00020\u0000*\u00020\u00002\u0006\u0010[\u001a\u00020Z2\b\b\u0002\u0010]\u001a\u00020\\H\u0007\u001a\u001e\u0010c\u001a\u00020\u0000*\u00020\u00002\u0006\u0010b\u001a\u00020\b2\b\b\u0002\u0010]\u001a\u00020\\H\u0007\u001a&\u0010d\u001a\u00020\u0000*\u00020\u00002\u0006\u0010D\u001a\u00020\b2\u0006\u0010E\u001a\u00020\b2\b\b\u0002\u0010]\u001a\u00020\\H\u0007\u001a\u001e\u0010e\u001a\u00020\u0000*\u00020\u00002\u0006\u0010Y\u001a\u00020\b2\b\b\u0002\u0010]\u001a\u00020\\H\u0007\u001a\u0014\u0010g\u001a\u00020\u0000*\u00020\u00002\b\b\u0002\u0010f\u001a\u00020\n\u001a\u0012\u0010i\u001a\u00020\u0000*\u00020\u00002\u0006\u0010h\u001a\u00020\n\u001a\u0014\u0010k\u001a\u00020\u0000*\u00020\u00002\b\b\u0002\u0010j\u001a\u00020\n\u001a\n\u0010l\u001a\u00020\u0000*\u00020\u0000\u001a\u0014\u0010m\u001a\u00020\u0000*\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0001\u001a.\u0010r\u001a\u00020\u0000*\u00020\u00002\u0006\u0010n\u001a\u00020\u00002\u0006\u0010o\u001a\u00020\u00002\b\b\u0002\u0010p\u001a\u00020\u00052\b\b\u0002\u0010q\u001a\u00020\n\u001a\u001c\u0010t\u001a\u00020\u0000*\u00020\u00002\u0006\u0010>\u001a\u00020\b2\b\b\u0002\u0010s\u001a\u00020\b\u00a8\u0006u"}, d2 = {"Lcom/tencent/ntcompose/core/i;", "Lcom/tencent/kuikly/core/base/h;", "color", "d", "c", "", NodeProps.Z_INDEX, "T", "", ExifInterface.LATITUDE_SOUTH, "", "clip", "r", "clipChildren", "E", "allBorderRadius", "j", "Lcom/tencent/kuikly/core/base/f;", NodeProps.BORDER_RADIUS, "l", "topLeft", "topRight", "bottomLeft", "bottomRight", "k", "Lzo3/g;", "shape", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "Lcom/tencent/kuikly/core/base/Direction;", "direction", "", "Lcom/tencent/kuikly/core/base/j;", "colorStops", "e", "(Lcom/tencent/ntcompose/core/i;Lcom/tencent/kuikly/core/base/Direction;[Lcom/tencent/kuikly/core/base/j;)Lcom/tencent/ntcompose/core/i;", "width", "Lcom/tencent/kuikly/core/base/BorderStyle;", "stroke", "f", "Lcom/tencent/kuikly/core/base/e;", "border", "g", "i", "o", "top", "bottom", "left", "right", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "offsetX", "offsetY", NodeProps.SHADOW_RADIUS, NodeProps.SHADOW_COLOR, "L", "elevation", "K", "Lcom/tencent/kuikly/core/base/g;", "shadow", "p", "", "accessibility", "a", "opacity", "D", com.tencent.luggage.wxa.c8.c.f123400v, "b", "visibility", BdhLogUtil.LogTag.Tag_Req, BasicAnimation.KeyPath.SCALE_X, BasicAnimation.KeyPath.SCALE_Y, "translationX", "translationY", "shadowElevation", "rotationZ", BasicAnimation.KeyPath.ROTATION_X, BasicAnimation.KeyPath.ROTATION_Y, "Lzo3/h;", "transformOrigin", "t", "(Lcom/tencent/ntcompose/core/i;Ljava/lang/Float;Ljava/lang/Float;Ljava/lang/Float;Ljava/lang/Float;Ljava/lang/Float;Ljava/lang/Float;Ljava/lang/Float;Ljava/lang/Float;Ljava/lang/Float;Lzo3/h;Lzo3/g;Ljava/lang/Boolean;)Lcom/tencent/ntcompose/core/i;", "Lkotlin/Function1;", "Lzo3/d;", "", "Lkotlin/ExtensionFunctionType;", "block", "u", "Lcom/tencent/kuikly/core/base/t;", CanvasView.ACTION_ROTATE, "Lcom/tencent/kuikly/core/base/u;", "scale", "Lcom/tencent/kuikly/core/base/y;", CanvasView.ACTION_TRANSLATE, "Lcom/tencent/kuikly/core/base/a;", "anchor", "Lcom/tencent/kuikly/core/base/x;", "skew", "N", "P", "degrees", UserInfo.SEX_FEMALE, "H", "I", "touchEnable", "M", "keepAlive", "B", "disable", BdhLogUtil.LogTag.Tag_Conn, ReportConstant.COSTREPORT_PREFIX, "w", "highlightModifier", "defaultModifier", "withAnimationDurationMs", "enable", HippyTKDListViewAdapter.X, "defaultOpacity", QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, "ntcompose_release"}, k = 2, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public final class ModifiersKt {
    public static final i B(i iVar, boolean z16) {
        Intrinsics.checkNotNullParameter(iVar, "<this>");
        return com.tencent.ntcompose.core.ModifiersKt.c(iVar, "keepAlive", Boolean.valueOf(z16), null, null, null, null, e.f339411a, 60, null);
    }

    public static final i C(i iVar, boolean z16) {
        Intrinsics.checkNotNullParameter(iVar, "<this>");
        return com.tencent.ntcompose.core.ModifiersKt.c(iVar, "lazyLoadViewDisable", Boolean.valueOf(z16), null, null, null, null, e.f339411a, 60, null);
    }

    public static final i D(i iVar, float f16) {
        Intrinsics.checkNotNullParameter(iVar, "<this>");
        return b(iVar, f16);
    }

    public static final i E(i iVar, boolean z16) {
        Intrinsics.checkNotNullParameter(iVar, "<this>");
        return r(iVar, z16);
    }

    public static final i F(i iVar, float f16, com.tencent.kuikly.core.base.a anchor) {
        Intrinsics.checkNotNullParameter(iVar, "<this>");
        Intrinsics.checkNotNullParameter(anchor, "anchor");
        return O(iVar, new t(f16, 0.0f, 0.0f, 6, null), null, null, anchor, null, 22, null);
    }

    public static final i H(i iVar, float f16, float f17, com.tencent.kuikly.core.base.a anchor) {
        Intrinsics.checkNotNullParameter(iVar, "<this>");
        Intrinsics.checkNotNullParameter(anchor, "anchor");
        return O(iVar, null, new u(f16, f17), null, anchor, null, 21, null);
    }

    public static final i I(i iVar, float f16, com.tencent.kuikly.core.base.a anchor) {
        Intrinsics.checkNotNullParameter(iVar, "<this>");
        Intrinsics.checkNotNullParameter(anchor, "anchor");
        return H(iVar, f16, f16, anchor);
    }

    public static final i K(i iVar, float f16) {
        Intrinsics.checkNotNullParameter(iVar, "<this>");
        float f17 = f16 * 0.5f;
        return L(iVar, f17, f17, f16, new h(0, 0, 0, 0.5f));
    }

    public static final i L(i iVar, float f16, float f17, float f18, h shadowColor) {
        Intrinsics.checkNotNullParameter(iVar, "<this>");
        Intrinsics.checkNotNullParameter(shadowColor, "shadowColor");
        return p(iVar, new g(f16, f17, f18, shadowColor));
    }

    public static final i M(i iVar, boolean z16) {
        Intrinsics.checkNotNullParameter(iVar, "<this>");
        return com.tencent.ntcompose.core.ModifiersKt.c(iVar, "touchEnable", Boolean.valueOf(z16), null, null, null, null, e.f339411a, 60, null);
    }

    public static final i N(i iVar, t rotate, u scale, y translate, com.tencent.kuikly.core.base.a anchor, x skew) {
        Intrinsics.checkNotNullParameter(iVar, "<this>");
        Intrinsics.checkNotNullParameter(rotate, "rotate");
        Intrinsics.checkNotNullParameter(scale, "scale");
        Intrinsics.checkNotNullParameter(translate, "translate");
        Intrinsics.checkNotNullParameter(anchor, "anchor");
        Intrinsics.checkNotNullParameter(skew, "skew");
        return com.tencent.ntcompose.core.ModifiersKt.b(iVar, "transform", rotate, scale, translate, anchor, skew, e.f339411a);
    }

    public static final i P(i iVar, y translate, com.tencent.kuikly.core.base.a anchor) {
        Intrinsics.checkNotNullParameter(iVar, "<this>");
        Intrinsics.checkNotNullParameter(translate, "translate");
        Intrinsics.checkNotNullParameter(anchor, "anchor");
        return O(iVar, null, null, translate, anchor, null, 19, null);
    }

    public static final i R(i iVar, boolean z16) {
        Intrinsics.checkNotNullParameter(iVar, "<this>");
        return com.tencent.ntcompose.core.ModifiersKt.c(iVar, NodeProps.VISIBLE, Boolean.valueOf(z16), null, null, null, null, e.f339411a, 60, null);
    }

    public static final i S(i iVar, float f16) {
        Intrinsics.checkNotNullParameter(iVar, "<this>");
        return com.tencent.ntcompose.core.ModifiersKt.c(iVar, NodeProps.Z_INDEX, Float.valueOf(f16), null, null, null, null, e.f339411a, 60, null);
    }

    public static final i T(i iVar, int i3) {
        Intrinsics.checkNotNullParameter(iVar, "<this>");
        return S(iVar, i3);
    }

    public static final i a(i iVar, String accessibility) {
        Intrinsics.checkNotNullParameter(iVar, "<this>");
        Intrinsics.checkNotNullParameter(accessibility, "accessibility");
        return com.tencent.ntcompose.core.ModifiersKt.c(iVar, "accessibility", accessibility, null, null, null, null, e.f339411a, 60, null);
    }

    public static final i b(i iVar, float f16) {
        Intrinsics.checkNotNullParameter(iVar, "<this>");
        return com.tencent.ntcompose.core.ModifiersKt.c(iVar, com.tencent.luggage.wxa.c8.c.f123400v, Float.valueOf(f16), null, null, null, null, e.f339411a, 60, null);
    }

    public static final i c(i iVar, h color) {
        Intrinsics.checkNotNullParameter(iVar, "<this>");
        Intrinsics.checkNotNullParameter(color, "color");
        return com.tencent.ntcompose.core.ModifiersKt.c(iVar, "background", color, null, null, null, null, e.f339411a, 60, null);
    }

    public static final i d(i iVar, h color) {
        Intrinsics.checkNotNullParameter(iVar, "<this>");
        Intrinsics.checkNotNullParameter(color, "color");
        return c(iVar, color);
    }

    public static final i e(i iVar, Direction direction, j... colorStops) {
        List list;
        Intrinsics.checkNotNullParameter(iVar, "<this>");
        Intrinsics.checkNotNullParameter(direction, "direction");
        Intrinsics.checkNotNullParameter(colorStops, "colorStops");
        list = ArraysKt___ArraysKt.toList(colorStops);
        return com.tencent.ntcompose.core.ModifiersKt.c(iVar, "background", direction, list, null, null, null, e.f339411a, 56, null);
    }

    public static final i f(i iVar, float f16, h color, BorderStyle stroke) {
        Intrinsics.checkNotNullParameter(iVar, "<this>");
        Intrinsics.checkNotNullParameter(color, "color");
        Intrinsics.checkNotNullParameter(stroke, "stroke");
        return g(iVar, new com.tencent.kuikly.core.base.e(f16, stroke, color));
    }

    public static final i g(i iVar, com.tencent.kuikly.core.base.e border) {
        Intrinsics.checkNotNullParameter(iVar, "<this>");
        Intrinsics.checkNotNullParameter(border, "border");
        return com.tencent.ntcompose.core.ModifiersKt.c(iVar, "border", border, null, null, null, null, e.f339411a, 60, null);
    }

    public static final i i(i iVar, com.tencent.kuikly.core.base.e border) {
        Intrinsics.checkNotNullParameter(iVar, "<this>");
        Intrinsics.checkNotNullParameter(border, "border");
        return n(iVar, null, null, border, null, 11, null);
    }

    public static final i j(i iVar, float f16) {
        Intrinsics.checkNotNullParameter(iVar, "<this>");
        return k(iVar, f16, f16, f16, f16);
    }

    public static final i k(i iVar, float f16, float f17, float f18, float f19) {
        Intrinsics.checkNotNullParameter(iVar, "<this>");
        return l(iVar, new f(f16, f17, f18, f19));
    }

    public static final i l(i iVar, f borderRadius) {
        Intrinsics.checkNotNullParameter(iVar, "<this>");
        Intrinsics.checkNotNullParameter(borderRadius, "borderRadius");
        return com.tencent.ntcompose.core.ModifiersKt.c(iVar, "clip", borderRadius, null, null, null, null, e.f339411a, 60, null);
    }

    private static final i m(i iVar, com.tencent.kuikly.core.base.e eVar, com.tencent.kuikly.core.base.e eVar2, com.tencent.kuikly.core.base.e eVar3, com.tencent.kuikly.core.base.e eVar4) {
        return com.tencent.ntcompose.core.ModifiersKt.c(iVar, "borderRect", eVar, eVar2, eVar3, eVar4, null, e.f339411a, 32, null);
    }

    public static final i o(i iVar, com.tencent.kuikly.core.base.e border) {
        Intrinsics.checkNotNullParameter(iVar, "<this>");
        Intrinsics.checkNotNullParameter(border, "border");
        return n(iVar, null, null, null, border, 7, null);
    }

    public static final i p(i iVar, g shadow) {
        Intrinsics.checkNotNullParameter(iVar, "<this>");
        Intrinsics.checkNotNullParameter(shadow, "shadow");
        return com.tencent.ntcompose.core.ModifiersKt.c(iVar, "boxShadow", shadow, null, null, null, null, e.f339411a, 60, null);
    }

    public static final i q(i iVar, zo3.g shape) {
        Intrinsics.checkNotNullParameter(iVar, "<this>");
        Intrinsics.checkNotNullParameter(shape, "shape");
        return com.tencent.ntcompose.core.ModifiersKt.c(iVar, "clip", shape, null, null, null, null, e.f339411a, 60, null);
    }

    public static final i r(i iVar, boolean z16) {
        Intrinsics.checkNotNullParameter(iVar, "<this>");
        return com.tencent.ntcompose.core.ModifiersKt.c(iVar, "cipToBounds", Boolean.valueOf(z16), null, null, null, null, e.f339411a, 60, null);
    }

    public static final i s(i iVar) {
        Intrinsics.checkNotNullParameter(iVar, "<this>");
        return com.tencent.ntcompose.core.ModifiersKt.c(iVar, "flattenDisable", 1, null, null, null, null, e.f339411a, 60, null);
    }

    public static final i u(i iVar, Function1<? super zo3.d, Unit> block) {
        Intrinsics.checkNotNullParameter(iVar, "<this>");
        Intrinsics.checkNotNullParameter(block, "block");
        zo3.d dVar = new zo3.d();
        block.invoke(dVar);
        Float f16 = dVar.getCom.tencent.ams.mosaic.jsengine.animation.basic.BasicAnimation.KeyPath.SCALE_X java.lang.String();
        Float f17 = dVar.getCom.tencent.ams.mosaic.jsengine.animation.basic.BasicAnimation.KeyPath.SCALE_Y java.lang.String();
        Float f18 = dVar.getCom.tencent.luggage.wxa.c8.c.v java.lang.String();
        Float translationX = dVar.getTranslationX();
        Float translationY = dVar.getTranslationY();
        Float shadowElevation = dVar.getShadowElevation();
        Float rotationZ = dVar.getRotationZ();
        Float rotationX = dVar.getRotationX();
        Float f19 = dVar.getCom.tencent.ams.mosaic.jsengine.animation.basic.BasicAnimation.KeyPath.ROTATION_Y java.lang.String();
        dVar.j();
        return t(iVar, f16, f17, f18, translationX, translationY, shadowElevation, rotationZ, rotationX, f19, null, dVar.getShape(), dVar.getClip());
    }

    public static final i w(i iVar, h color) {
        Intrinsics.checkNotNullParameter(iVar, "<this>");
        Intrinsics.checkNotNullParameter(color, "color");
        return com.tencent.ntcompose.core.ModifiersKt.c(iVar, "highlightBackgroundColor", color, null, null, null, null, e.f339411a, 60, null);
    }

    public static final i x(i iVar, final i highlightModifier, final i defaultModifier, final int i3, final boolean z16) {
        Intrinsics.checkNotNullParameter(iVar, "<this>");
        Intrinsics.checkNotNullParameter(highlightModifier, "highlightModifier");
        Intrinsics.checkNotNullParameter(defaultModifier, "defaultModifier");
        return com.tencent.ntcompose.core.ModifiersKt.e(iVar, "highlightModifier", new Function1<ComposeRenderView, Unit>() { // from class: com.tencent.ntcompose.material.base.ModifiersKt$highlightModifier$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(ComposeRenderView composeRenderView) {
                invoke2(composeRenderView);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(final ComposeRenderView view) {
                Intrinsics.checkNotNullParameter(view, "view");
                Object viewAttr = view.b().getViewAttr();
                GroupAttr groupAttr = viewAttr instanceof GroupAttr ? (GroupAttr) viewAttr : null;
                if (groupAttr != null) {
                    final boolean z17 = z16;
                    final int i16 = i3;
                    final i iVar2 = highlightModifier;
                    final i iVar3 = defaultModifier;
                    groupAttr.highlightCallback(new Function1<Boolean, Unit>() { // from class: com.tencent.ntcompose.material.base.ModifiersKt$highlightModifier$1.1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(1);
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
                            invoke(bool.booleanValue());
                            return Unit.INSTANCE;
                        }

                        /* JADX WARN: Type inference failed for: r12v5, types: [com.tencent.kuikly.core.base.Attr, com.tencent.kuikly.core.base.Props] */
                        /* JADX WARN: Type inference failed for: r2v5, types: [com.tencent.kuikly.core.base.Attr, com.tencent.kuikly.core.base.Props] */
                        public final void invoke(boolean z18) {
                            if (z17) {
                                int i17 = i16;
                                if (i17 > 0) {
                                    view.b().getViewAttr().setProp("animation", b.Companion.b(com.tencent.kuikly.core.base.b.INSTANCE, AnimationType.PLAIN, TimingFuncType.LINEAR, i17 / 1000.0f, 0.0f, false, null, 56, null).toString());
                                }
                                if (z18) {
                                    view.o(i.INSTANCE, iVar2);
                                } else {
                                    view.o(i.INSTANCE, iVar3);
                                }
                                if (i16 > 0) {
                                    view.b().getViewAttr().setProp("animation", "");
                                }
                            }
                        }
                    });
                }
            }
        });
    }

    public static final i z(i iVar, final float f16, final float f17) {
        Intrinsics.checkNotNullParameter(iVar, "<this>");
        return com.tencent.ntcompose.core.ModifiersKt.d(iVar, "highlightOpacity", new Function2<Attr, Event, Unit>() { // from class: com.tencent.ntcompose.material.base.ModifiersKt$highlightOpacity$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(Attr attr, Event event) {
                invoke2(attr, event);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(final Attr attr, Event event) {
                Intrinsics.checkNotNullParameter(attr, "attr");
                Intrinsics.checkNotNullParameter(event, "event");
                GroupAttr groupAttr = attr instanceof GroupAttr ? (GroupAttr) attr : null;
                if (groupAttr != null) {
                    final float f18 = f16;
                    final float f19 = f17;
                    groupAttr.highlightCallback(new Function1<Boolean, Unit>() { // from class: com.tencent.ntcompose.material.base.ModifiersKt$highlightOpacity$1.1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(1);
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
                            invoke(bool.booleanValue());
                            return Unit.INSTANCE;
                        }

                        public final void invoke(boolean z16) {
                            Attr.this.m147opacity(z16 ? f18 : f19);
                        }
                    });
                }
            }
        });
    }

    public static final i t(i iVar, Float f16, Float f17, Float f18, Float f19, Float f26, Float f27, Float f28, Float f29, Float f36, zo3.h hVar, zo3.g gVar, Boolean bool) {
        i O;
        Intrinsics.checkNotNullParameter(iVar, "<this>");
        if (f16 == null && f17 == null && f19 == null && f26 == null && f28 == null && f29 == null && f36 == null) {
            O = iVar;
        } else {
            O = O(iVar, new t(f28 != null ? f28.floatValue() : 0.0f, f29 != null ? f29.floatValue() : 0.0f, f36 != null ? f36.floatValue() : 0.0f), new u(f16 != null ? f16.floatValue() : 1.0f, f17 != null ? f17.floatValue() : 1.0f), new y(0.0f, 0.0f, f19 != null ? f19.floatValue() : 0.0f, f26 != null ? f26.floatValue() : 0.0f), new com.tencent.kuikly.core.base.a(0.5f, 0.5f), null, 16, null);
        }
        if (gVar != null) {
            O = q(O, gVar);
        }
        if (bool != null) {
            O = E(O, bool.booleanValue());
        }
        if (f27 != null) {
            O = K(O, f27.floatValue());
        }
        return f18 != null ? b(O, f18.floatValue()) : O;
    }

    public static /* synthetic */ i G(i iVar, float f16, com.tencent.kuikly.core.base.a aVar, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            aVar = com.tencent.kuikly.core.base.a.INSTANCE.a();
        }
        return F(iVar, f16, aVar);
    }

    public static /* synthetic */ i J(i iVar, float f16, com.tencent.kuikly.core.base.a aVar, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            aVar = com.tencent.kuikly.core.base.a.INSTANCE.a();
        }
        return I(iVar, f16, aVar);
    }

    public static /* synthetic */ i O(i iVar, t tVar, u uVar, y yVar, com.tencent.kuikly.core.base.a aVar, x xVar, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            tVar = t.INSTANCE.a();
        }
        if ((i3 & 2) != 0) {
            uVar = u.INSTANCE.a();
        }
        u uVar2 = uVar;
        if ((i3 & 4) != 0) {
            yVar = y.INSTANCE.a();
        }
        y yVar2 = yVar;
        if ((i3 & 8) != 0) {
            aVar = com.tencent.kuikly.core.base.a.INSTANCE.a();
        }
        com.tencent.kuikly.core.base.a aVar2 = aVar;
        if ((i3 & 16) != 0) {
            xVar = x.INSTANCE.a();
        }
        return N(iVar, tVar, uVar2, yVar2, aVar2, xVar);
    }

    public static /* synthetic */ i Q(i iVar, y yVar, com.tencent.kuikly.core.base.a aVar, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            aVar = com.tencent.kuikly.core.base.a.INSTANCE.a();
        }
        return P(iVar, yVar, aVar);
    }

    public static /* synthetic */ i h(i iVar, float f16, h hVar, BorderStyle borderStyle, int i3, Object obj) {
        if ((i3 & 4) != 0) {
            borderStyle = BorderStyle.SOLID;
        }
        return f(iVar, f16, hVar, borderStyle);
    }

    public static /* synthetic */ i A(i iVar, float f16, float f17, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            f17 = 1.0f;
        }
        return z(iVar, f16, f17);
    }

    public static /* synthetic */ i y(i iVar, i iVar2, i iVar3, int i3, boolean z16, int i16, Object obj) {
        if ((i16 & 4) != 0) {
            i3 = 150;
        }
        if ((i16 & 8) != 0) {
            z16 = true;
        }
        return x(iVar, iVar2, iVar3, i3, z16);
    }

    static /* synthetic */ i n(i iVar, com.tencent.kuikly.core.base.e eVar, com.tencent.kuikly.core.base.e eVar2, com.tencent.kuikly.core.base.e eVar3, com.tencent.kuikly.core.base.e eVar4, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            eVar = null;
        }
        if ((i3 & 2) != 0) {
            eVar2 = null;
        }
        if ((i3 & 4) != 0) {
            eVar3 = null;
        }
        if ((i3 & 8) != 0) {
            eVar4 = null;
        }
        return m(iVar, eVar, eVar2, eVar3, eVar4);
    }

    public static /* synthetic */ i v(i iVar, Float f16, Float f17, Float f18, Float f19, Float f26, Float f27, Float f28, Float f29, Float f36, zo3.h hVar, zo3.g gVar, Boolean bool, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            f16 = null;
        }
        if ((i3 & 2) != 0) {
            f17 = null;
        }
        if ((i3 & 4) != 0) {
            f18 = null;
        }
        if ((i3 & 8) != 0) {
            f19 = null;
        }
        if ((i3 & 16) != 0) {
            f26 = null;
        }
        if ((i3 & 32) != 0) {
            f27 = null;
        }
        if ((i3 & 64) != 0) {
            f28 = null;
        }
        if ((i3 & 128) != 0) {
            f29 = null;
        }
        if ((i3 & 256) != 0) {
            f36 = null;
        }
        if ((i3 & 512) != 0) {
            hVar = null;
        }
        if ((i3 & 1024) != 0) {
            gVar = null;
        }
        if ((i3 & 2048) != 0) {
            bool = null;
        }
        return t(iVar, f16, f17, f18, f19, f26, f27, f28, f29, f36, hVar, gVar, bool);
    }
}

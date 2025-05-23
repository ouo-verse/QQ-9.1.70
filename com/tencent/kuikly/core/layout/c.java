package com.tencent.kuikly.core.layout;

import androidx.exifinterface.media.ExifInterface;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import kotlin.Metadata;
import kotlin.collections.ArraysKt___ArraysJvmKt;
import kotlin.jvm.internal.FloatCompanionObject;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0014\n\u0002\b\u0013\b\u0016\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\bU\u0010VR\"\u0010\t\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\u0011\u001a\u00020\n8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\"\u0010\u0019\u001a\u00020\u00128\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\"\u0010 \u001a\u00020\u001a8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u0003\u0010\u001d\"\u0004\b\u001e\u0010\u001fR\"\u0010#\u001a\u00020\u001a8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b!\u0010\u001c\u001a\u0004\b\u0013\u0010\u001d\"\u0004\b\"\u0010\u001fR\"\u0010%\u001a\u00020\u001a8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0005\u0010\u001c\u001a\u0004\b\u000b\u0010\u001d\"\u0004\b$\u0010\u001fR\"\u0010-\u001a\u00020&8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b'\u0010(\u001a\u0004\b)\u0010*\"\u0004\b+\u0010,R\"\u00104\u001a\u00020.8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\r\u0010/\u001a\u0004\b0\u00101\"\u0004\b2\u00103R\"\u0010:\u001a\u0002058\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b0\u00106\u001a\u0004\b'\u00107\"\u0004\b8\u00109R\u0017\u0010?\u001a\u00020;8\u0006\u00a2\u0006\f\n\u0004\b\u0015\u0010<\u001a\u0004\b=\u0010>R\u0017\u0010A\u001a\u00020;8\u0006\u00a2\u0006\f\n\u0004\b=\u0010<\u001a\u0004\b@\u0010>R\u0017\u0010C\u001a\u00020;8\u0006\u00a2\u0006\f\n\u0004\bB\u0010<\u001a\u0004\b\u001b\u0010>R\u0017\u0010I\u001a\u00020D8\u0006\u00a2\u0006\f\n\u0004\bE\u0010F\u001a\u0004\bG\u0010HR\u0017\u0010K\u001a\u00020D8\u0006\u00a2\u0006\f\n\u0004\bJ\u0010F\u001a\u0004\b!\u0010HR\"\u0010N\u001a\u0002058\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bL\u00106\u001a\u0004\bL\u00107\"\u0004\bM\u00109R\"\u0010P\u001a\u0002058\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b@\u00106\u001a\u0004\bJ\u00107\"\u0004\bO\u00109R\"\u0010R\u001a\u0002058\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bG\u00106\u001a\u0004\bE\u00107\"\u0004\bQ\u00109R\"\u0010T\u001a\u0002058\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b)\u00106\u001a\u0004\bB\u00107\"\u0004\bS\u00109\u00a8\u0006W"}, d2 = {"Lcom/tencent/kuikly/core/layout/c;", "", "Lcom/tencent/kuikly/core/layout/FlexLayoutDirection;", "a", "Lcom/tencent/kuikly/core/layout/FlexLayoutDirection;", "f", "()Lcom/tencent/kuikly/core/layout/FlexLayoutDirection;", "setDirection", "(Lcom/tencent/kuikly/core/layout/FlexLayoutDirection;)V", "direction", "Lcom/tencent/kuikly/core/layout/FlexDirection;", "b", "Lcom/tencent/kuikly/core/layout/FlexDirection;", tl.h.F, "()Lcom/tencent/kuikly/core/layout/FlexDirection;", "w", "(Lcom/tencent/kuikly/core/layout/FlexDirection;)V", NodeProps.FLEX_DIRECTION, "Lcom/tencent/kuikly/core/layout/FlexJustifyContent;", "c", "Lcom/tencent/kuikly/core/layout/FlexJustifyContent;", "j", "()Lcom/tencent/kuikly/core/layout/FlexJustifyContent;", "y", "(Lcom/tencent/kuikly/core/layout/FlexJustifyContent;)V", NodeProps.JUSTIFY_CONTENT, "Lcom/tencent/kuikly/core/layout/FlexAlign;", "d", "Lcom/tencent/kuikly/core/layout/FlexAlign;", "()Lcom/tencent/kuikly/core/layout/FlexAlign;", ReportConstant.COSTREPORT_PREFIX, "(Lcom/tencent/kuikly/core/layout/FlexAlign;)V", "alignContent", "e", "u", NodeProps.ALIGN_SELF, "t", NodeProps.ALIGN_ITEMS, "Lcom/tencent/kuikly/core/layout/FlexPositionType;", "g", "Lcom/tencent/kuikly/core/layout/FlexPositionType;", "r", "()Lcom/tencent/kuikly/core/layout/FlexPositionType;", "D", "(Lcom/tencent/kuikly/core/layout/FlexPositionType;)V", "positionType", "Lcom/tencent/kuikly/core/layout/FlexWrap;", "Lcom/tencent/kuikly/core/layout/FlexWrap;", "i", "()Lcom/tencent/kuikly/core/layout/FlexWrap;", HippyTKDListViewAdapter.X, "(Lcom/tencent/kuikly/core/layout/FlexWrap;)V", NodeProps.FLEX_WRAP, "", UserInfo.SEX_FEMALE, "()F", "v", "(F)V", NodeProps.FLEX, "Lcom/tencent/kuikly/core/layout/StyleSpace;", "Lcom/tencent/kuikly/core/layout/StyleSpace;", "k", "()Lcom/tencent/kuikly/core/layout/StyleSpace;", "margin", "p", "padding", "l", "border", "", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "[F", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "()[F", "position", DomainData.DOMAIN_NAME, "dimensions", "o", BdhLogUtil.LogTag.Tag_Conn, NodeProps.MIN_WIDTH, "B", NodeProps.MIN_HEIGHT, ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, NodeProps.MAX_WIDTH, QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, NodeProps.MAX_HEIGHT, "<init>", "()V", "core_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes33.dex */
public class c {

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private float flex;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private final float[] position;

    /* renamed from: n, reason: collision with root package name and from kotlin metadata */
    private final float[] dimensions;

    /* renamed from: o, reason: collision with root package name and from kotlin metadata */
    private float minWidth;

    /* renamed from: p, reason: collision with root package name and from kotlin metadata */
    private float minHeight;

    /* renamed from: q, reason: collision with root package name and from kotlin metadata */
    private float maxWidth;

    /* renamed from: r, reason: collision with root package name and from kotlin metadata */
    private float maxHeight;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private FlexLayoutDirection direction = FlexLayoutDirection.INHERIT;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private FlexDirection flexDirection = FlexDirection.COLUMN;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private FlexJustifyContent justifyContent = FlexJustifyContent.FLEX_START;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private FlexAlign alignContent = FlexAlign.FLEX_START;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private FlexAlign alignSelf = FlexAlign.AUTO;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private FlexAlign alignItems = FlexAlign.STRETCH;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    private FlexPositionType positionType = FlexPositionType.RELATIVE;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private FlexWrap flexWrap = FlexWrap.NOWRAP;

    /* renamed from: j, reason: collision with root package name and from kotlin metadata */
    private final StyleSpace margin = new StyleSpace();

    /* renamed from: k, reason: collision with root package name and from kotlin metadata */
    private final StyleSpace padding = new StyleSpace();

    /* renamed from: l, reason: collision with root package name and from kotlin metadata */
    private final StyleSpace border = new StyleSpace();

    public c() {
        float[] fArr = new float[4];
        FloatCompanionObject floatCompanionObject = FloatCompanionObject.INSTANCE;
        ArraysKt___ArraysJvmKt.fill$default(fArr, Float.NaN, 0, 0, 6, (Object) null);
        this.position = fArr;
        float[] fArr2 = new float[2];
        ArraysKt___ArraysJvmKt.fill$default(fArr2, Float.NaN, 0, 0, 6, (Object) null);
        this.dimensions = fArr2;
        this.minWidth = Float.NaN;
        this.minHeight = Float.NaN;
        this.maxWidth = Float.NaN;
        this.maxHeight = Float.NaN;
    }

    public final void A(float f16) {
        this.maxWidth = f16;
    }

    public final void B(float f16) {
        this.minHeight = f16;
    }

    public final void C(float f16) {
        this.minWidth = f16;
    }

    public final void D(FlexPositionType flexPositionType) {
        Intrinsics.checkNotNullParameter(flexPositionType, "<set-?>");
        this.positionType = flexPositionType;
    }

    /* renamed from: a, reason: from getter */
    public final FlexAlign getAlignContent() {
        return this.alignContent;
    }

    /* renamed from: b, reason: from getter */
    public final FlexAlign getAlignItems() {
        return this.alignItems;
    }

    /* renamed from: c, reason: from getter */
    public final FlexAlign getAlignSelf() {
        return this.alignSelf;
    }

    /* renamed from: d, reason: from getter */
    public final StyleSpace getBorder() {
        return this.border;
    }

    /* renamed from: e, reason: from getter */
    public final float[] getDimensions() {
        return this.dimensions;
    }

    /* renamed from: f, reason: from getter */
    public final FlexLayoutDirection getDirection() {
        return this.direction;
    }

    /* renamed from: g, reason: from getter */
    public final float getFlex() {
        return this.flex;
    }

    /* renamed from: h, reason: from getter */
    public final FlexDirection getFlexDirection() {
        return this.flexDirection;
    }

    /* renamed from: i, reason: from getter */
    public final FlexWrap getFlexWrap() {
        return this.flexWrap;
    }

    /* renamed from: j, reason: from getter */
    public final FlexJustifyContent getJustifyContent() {
        return this.justifyContent;
    }

    /* renamed from: k, reason: from getter */
    public final StyleSpace getMargin() {
        return this.margin;
    }

    /* renamed from: l, reason: from getter */
    public final float getMaxHeight() {
        return this.maxHeight;
    }

    /* renamed from: m, reason: from getter */
    public final float getMaxWidth() {
        return this.maxWidth;
    }

    /* renamed from: n, reason: from getter */
    public final float getMinHeight() {
        return this.minHeight;
    }

    /* renamed from: o, reason: from getter */
    public final float getMinWidth() {
        return this.minWidth;
    }

    /* renamed from: p, reason: from getter */
    public final StyleSpace getPadding() {
        return this.padding;
    }

    /* renamed from: q, reason: from getter */
    public final float[] getPosition() {
        return this.position;
    }

    /* renamed from: r, reason: from getter */
    public final FlexPositionType getPositionType() {
        return this.positionType;
    }

    public final void s(FlexAlign flexAlign) {
        Intrinsics.checkNotNullParameter(flexAlign, "<set-?>");
        this.alignContent = flexAlign;
    }

    public final void t(FlexAlign flexAlign) {
        Intrinsics.checkNotNullParameter(flexAlign, "<set-?>");
        this.alignItems = flexAlign;
    }

    public final void u(FlexAlign flexAlign) {
        Intrinsics.checkNotNullParameter(flexAlign, "<set-?>");
        this.alignSelf = flexAlign;
    }

    public final void v(float f16) {
        this.flex = f16;
    }

    public final void w(FlexDirection flexDirection) {
        Intrinsics.checkNotNullParameter(flexDirection, "<set-?>");
        this.flexDirection = flexDirection;
    }

    public final void x(FlexWrap flexWrap) {
        Intrinsics.checkNotNullParameter(flexWrap, "<set-?>");
        this.flexWrap = flexWrap;
    }

    public final void y(FlexJustifyContent flexJustifyContent) {
        Intrinsics.checkNotNullParameter(flexJustifyContent, "<set-?>");
        this.justifyContent = flexJustifyContent;
    }

    public final void z(float f16) {
        this.maxHeight = f16;
    }
}

package com.tencent.ntcompose.foundation.layout.base;

import androidx.exifinterface.media.ExifInterface;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.kuikly.core.layout.FlexAlign;
import com.tencent.kuikly.core.layout.FlexDirection;
import com.tencent.kuikly.core.layout.FlexJustifyContent;
import com.tencent.kuikly.core.layout.FlexLayout;
import com.tencent.kuikly.core.layout.FlexLayoutDirection;
import com.tencent.kuikly.core.layout.FlexNode;
import com.tencent.kuikly.core.layout.FlexPositionType;
import com.tencent.kuikly.core.layout.FlexWrap;
import com.tencent.kuikly.core.layout.StyleSpace;
import com.tencent.kuikly.core.log.KLog;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.ntcompose.foundation.layout.base.Alignment;
import com.tencent.ntcompose.foundation.layout.base.a;
import com.tencent.ntcompose.foundation.layout.base.f;
import cooperation.qzone.remote.logic.RemoteHandleConst;
import java.util.Set;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.internal.FloatCompanionObject;
import kotlin.jvm.internal.Intrinsics;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000r\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010#\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0017\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u001c\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0015\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\b\t\b\u00c0\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b}\u0010~JF\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\b2\b\b\u0002\u0010\u000b\u001a\u00020\n2\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00020\fJF\u0010\u0010\u001a\u00020\u000e2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\b2\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00020\f2\u0006\u0010\u000b\u001a\u00020\nH\u0002J4\u0010\u0013\u001a\u00020\u000e*\u00020\u00022\u0006\u0010\u0011\u001a\u00020\u00022\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0012\u001a\u00020\b2\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00020\fH\u0002J$\u0010\u0018\u001a\u00020\n*\u00020\u00022\u0006\u0010\u0014\u001a\u00020\u00042\u0006\u0010\u0015\u001a\u00020\u00042\u0006\u0010\u0017\u001a\u00020\u0016H\u0002J\f\u0010\u0019\u001a\u00020\n*\u00020\u0002H\u0002J$\u0010\u001d\u001a\u00020\u000e*\u00020\u00022\u0006\u0010\u001a\u001a\u00020\u00162\u0006\u0010\u001b\u001a\u00020\u00042\u0006\u0010\u001c\u001a\u00020\u0004H\u0002J\u0018\u0010\u001e\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\f\u0010\u001f\u001a\u00020\n*\u00020\u0002H\u0002J\f\u0010 \u001a\u00020\n*\u00020\u0002H\u0002J\f\u0010!\u001a\u00020\n*\u00020\u0002H\u0002J\u0012\u0010$\u001a\u00020\n2\b\u0010#\u001a\u0004\u0018\u00010\"H\u0002J\u0014\u0010%\u001a\u00020\n*\u00020\u00022\u0006\u0010\u0017\u001a\u00020\u0016H\u0002J\u0016\u0010&\u001a\u0004\u0018\u00010\"*\u00020\u00022\u0006\u0010\u0017\u001a\u00020\u0016H\u0002J\u0014\u0010'\u001a\u00020\n*\u00020\u00022\u0006\u0010\u0017\u001a\u00020\u0016H\u0002J\u0016\u0010(\u001a\u0004\u0018\u00010\"*\u00020\u00022\u0006\u0010\u0017\u001a\u00020\u0016H\u0002J\u0014\u0010)\u001a\u00020\u000e*\u00020\u00022\u0006\u0010\u001a\u001a\u00020\u0016H\u0002J\f\u0010*\u001a\u00020\u000e*\u00020\u0002H\u0002J\f\u0010+\u001a\u00020\u000e*\u00020\u0002H\u0002J\f\u0010,\u001a\u00020\u000e*\u00020\u0002H\u0002J\f\u0010-\u001a\u00020\u000e*\u00020\u0002H\u0002J\f\u0010.\u001a\u00020\u000e*\u00020\u0002H\u0002J\f\u0010/\u001a\u00020\u000e*\u00020\u0002H\u0002J\u0014\u00101\u001a\u00020\u000e*\u00020\u00022\u0006\u00100\u001a\u00020\u0002H\u0002J\u0014\u00102\u001a\u00020\u000e*\u00020\u00022\u0006\u00100\u001a\u00020\u0002H\u0002J\u0014\u00103\u001a\u00020\u000e*\u00020\u00022\u0006\u00100\u001a\u00020\u0002H\u0002J\u0014\u00104\u001a\u00020\u000e*\u00020\u00022\u0006\u00100\u001a\u00020\u0002H\u0002J\u0014\u00105\u001a\u00020\u000e*\u00020\u00022\u0006\u00100\u001a\u00020\u0002H\u0002J\u0014\u00106\u001a\u00020\u000e*\u00020\u00022\u0006\u00100\u001a\u00020\u0002H\u0002J\u0014\u00107\u001a\u00020\u000e*\u00020\u00022\u0006\u00100\u001a\u00020\u0002H\u0002J\u0014\u00108\u001a\u00020\u000e*\u00020\u00022\u0006\u00100\u001a\u00020\u0002H\u0002J\u0014\u00109\u001a\u00020\u000e*\u00020\u00022\u0006\u00100\u001a\u00020\u0002H\u0002J\u0014\u0010=\u001a\u00020<*\u00020\u00022\u0006\u0010;\u001a\u00020:H\u0002J\u0014\u0010>\u001a\u00020\n*\u00020\u00022\u0006\u00100\u001a\u00020\u0002H\u0002J\u0016\u0010?\u001a\u00020\b*\u00020\u00022\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0002J\u0018\u0010A\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00162\u0006\u0010@\u001a\u00020\bH\u0002J\u0018\u0010B\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00162\u0006\u0010@\u001a\u00020\bH\u0002J\u0014\u0010C\u001a\u00020\u000e*\u00020\u00022\u0006\u0010\u0017\u001a\u00020\u0016H\u0002J\u001c\u0010E\u001a\u00020\u0004*\u00020\u00022\u0006\u0010\u0017\u001a\u00020\u00162\u0006\u0010D\u001a\u00020\u0004H\u0002J\u0014\u0010F\u001a\u00020\u0004*\u00020\u00022\u0006\u0010\u0017\u001a\u00020\u0016H\u0002J\f\u0010G\u001a\u00020\n*\u00020\u0002H\u0002J\u0014\u0010H\u001a\u00020\u0004*\u00020\u00022\u0006\u0010@\u001a\u00020\u0016H\u0002J\u001c\u0010I\u001a\u00020\u000e*\u00020\u00022\u0006\u0010@\u001a\u00020\u00162\u0006\u0010D\u001a\u00020\u0004H\u0002J\u0014\u0010K\u001a\u00020\u000e*\u00020\u00022\u0006\u0010J\u001a\u00020\u0004H\u0002J\u0014\u0010M\u001a\u00020\u000e*\u00020\u00022\u0006\u0010L\u001a\u00020\u0004H\u0002J\u0014\u0010N\u001a\u00020\u0004*\u00020\u00022\u0006\u0010@\u001a\u00020\u0016H\u0002J\u0014\u0010O\u001a\u00020\u0004*\u00020\u00022\u0006\u0010@\u001a\u00020\u0016H\u0002J\u0014\u0010P\u001a\u00020\u0004*\u00020\u00022\u0006\u0010@\u001a\u00020\u0016H\u0002J\u0014\u0010Q\u001a\u00020\u0004*\u00020\u00022\u0006\u0010@\u001a\u00020\u0016H\u0002J\u0014\u0010R\u001a\u00020\u0004*\u00020\u00022\u0006\u0010@\u001a\u00020\u0016H\u0002J\u0014\u0010S\u001a\u00020\u0004*\u00020\u00022\u0006\u0010@\u001a\u00020\u0016H\u0002J\u0014\u0010T\u001a\u00020\u0004*\u00020\u00022\u0006\u0010@\u001a\u00020\u0016H\u0002J\u0014\u0010U\u001a\u00020\u0004*\u00020\u00022\u0006\u0010@\u001a\u00020\u0016H\u0002J\u0014\u0010V\u001a\u00020\n*\u00020\u00022\u0006\u0010@\u001a\u00020\u0016H\u0002J\u0014\u0010W\u001a\u00020\n*\u00020\u00022\u0006\u0010@\u001a\u00020\u0016H\u0002J\u0014\u0010Z\u001a\u00020Y*\u00020\u00022\u0006\u0010X\u001a\u00020\u0002H\u0002J\u001c\u0010[\u001a\u00020\u000e*\u00020\u00022\u0006\u0010@\u001a\u00020\u00162\u0006\u0010D\u001a\u00020\u0004H\u0002J\u001c\u0010\\\u001a\u00020\u000e*\u00020\u00022\u0006\u0010@\u001a\u00020\u00162\u0006\u0010D\u001a\u00020\u0004H\u0002J\u001c\u0010]\u001a\u00020\u000e*\u00020\u00022\u0006\u0010@\u001a\u00020\u00162\u0006\u0010D\u001a\u00020\u0004H\u0002J\u0014\u0010^\u001a\u00020\u0004*\u00020\u00022\u0006\u0010@\u001a\u00020\u0016H\u0002J\u0014\u0010_\u001a\u00020\u0004*\u00020\u00022\u0006\u0010@\u001a\u00020\u0016H\u0002J\u0014\u0010`\u001a\u00020\u0004*\u00020\u00022\u0006\u0010@\u001a\u00020\u0016H\u0002J\u0014\u0010a\u001a\u00020\u0004*\u00020\u00022\u0006\u0010@\u001a\u00020\u0016H\u0002J\u0014\u0010b\u001a\u00020\u0004*\u00020\u00022\u0006\u0010@\u001a\u00020\u0016H\u0002J\u0014\u0010c\u001a\u00020\n*\u00020\u00022\u0006\u0010@\u001a\u00020\u0016H\u0002J\u001c\u0010e\u001a\u00020\u0004*\u00020\u00022\u0006\u0010@\u001a\u00020\u00162\u0006\u0010d\u001a\u00020\u0004H\u0002J\u0014\u0010f\u001a\u00020\u0004*\u00020\u00022\u0006\u0010@\u001a\u00020\u0016H\u0002J\u0014\u0010g\u001a\u00020\n*\u00020\u00022\u0006\u0010@\u001a\u00020\u0016H\u0002J\u001c\u0010h\u001a\u00020\u0004*\u00020\u00022\u0006\u0010@\u001a\u00020\u00162\u0006\u0010d\u001a\u00020\u0004H\u0002J\f\u0010i\u001a\u00020\n*\u00020\u0002H\u0002J\u0014\u0010j\u001a\u00020\u0004*\u00020\u00022\u0006\u0010@\u001a\u00020\u0016H\u0002J\u0010\u0010l\u001a\u00020k2\u0006\u0010@\u001a\u00020\u0016H\u0002J\u0010\u0010m\u001a\u00020k2\u0006\u0010@\u001a\u00020\u0016H\u0002J\u0010\u0010n\u001a\u00020k2\u0006\u0010@\u001a\u00020\u0016H\u0002J\u0010\u0010o\u001a\u00020k2\u0006\u0010@\u001a\u00020\u0016H\u0002J.\u0010r\u001a\u00020\n*\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010p\u001a\u00020\u00042\u0006\u0010q\u001a\u00020\u00162\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0002R\u0014\u0010u\u001a\u00020s8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b1\u0010tR\u001a\u0010x\u001a\b\u0012\u0004\u0012\u00020k0v8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b3\u0010wR\u001a\u0010y\u001a\b\u0012\u0004\u0012\u00020k0v8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b/\u0010wR\u001a\u0010z\u001a\b\u0012\u0004\u0012\u00020k0v8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b6\u0010wR\u001a\u0010{\u001a\b\u0012\u0004\u0012\u00020k0v8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b4\u0010wR\u0014\u0010|\u001a\u00020s8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b5\u0010t\u00a8\u0006\u007f"}, d2 = {"Lcom/tencent/ntcompose/foundation/layout/base/g;", "", "Lcom/tencent/ntcompose/foundation/layout/base/d;", "node", "", "parentMaxWidth", "Lcom/tencent/kuikly/core/layout/b;", "layoutContext", "Lcom/tencent/kuikly/core/layout/FlexLayoutDirection;", "parentDirection", "", "needLayoutAbsoluteChild", "", "dirtyList", "", "W", "Y", "absoluteChild", NodeProps.FLEX_DIRECTION, "f0", "oldDim", "newDim", "Lcom/tencent/kuikly/core/layout/FlexDirection;", "axis", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "I", "mainAxis", "paddingAndBorderAxisMain", "originDim", h.F, "b0", "J", "O", "N", "Lcom/tencent/ntcompose/foundation/layout/base/f;", "atMostSize", "L", "K", DomainData.DOMAIN_NAME, "V", "x0", "n0", "g0", "l0", "m0", "i0", "j0", "d", "parentNode", "b", "a", "c", "f", "g", "e", "j", "i", "k", "", "index", "Lcom/tencent/ntcompose/foundation/layout/base/Alignment;", "p", AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, "k0", "direction", "h0", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "o0", "value", "l", "v", BdhLogUtil.LogTag.Tag_Req, "r", "p0", "width", "u0", "height", "q0", "y", HippyTKDListViewAdapter.X, "w", UserInfo.SEX_FEMALE, "E", "D", BdhLogUtil.LogTag.Tag_Conn, "B", "P", ExifInterface.LATITUDE_SOUTH, "child", "Lcom/tencent/kuikly/core/layout/FlexAlign;", "o", "s0", "r0", "t0", "t", ReportConstant.COSTREPORT_PREFIX, "u", "d0", "c0", "T", RemoteHandleConst.PARAM_DEFAULT_VALUE, ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, "U", "H", "M", "G", "Lcom/tencent/kuikly/core/layout/StyleSpace$Type;", "v0", "w0", "Z", "a0", "paddingAndBorderAxisResolvedRow", "resolvedRowAxis", "e0", "", "[I", "dim", "", "[Lcom/tencent/kuikly/core/layout/StyleSpace$Type;", "leading", "leadingSpacing", "trailingSpacing", "trailing", com.tencent.luggage.wxa.c8.c.G, "<init>", "()V", "ntcompose_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public final class g {

    /* renamed from: a, reason: collision with root package name */
    public static final g f339269a = new g();

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private static final int[] dim;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private static final StyleSpace.Type[] leading;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private static final StyleSpace.Type[] leadingSpacing;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private static final StyleSpace.Type[] trailingSpacing;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private static final StyleSpace.Type[] trailing;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    private static final int[] pos;

    /* compiled from: P */
    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes34.dex */
    public /* synthetic */ class a {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f339276a;

        /* renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ int[] f339277b;

        /* renamed from: c, reason: collision with root package name */
        public static final /* synthetic */ int[] f339278c;

        /* renamed from: d, reason: collision with root package name */
        public static final /* synthetic */ int[] f339279d;

        /* renamed from: e, reason: collision with root package name */
        public static final /* synthetic */ int[] f339280e;

        /* renamed from: f, reason: collision with root package name */
        public static final /* synthetic */ int[] f339281f;

        static {
            int[] iArr = new int[FlexJustifyContent.values().length];
            try {
                iArr[FlexJustifyContent.CENTER.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[FlexJustifyContent.FLEX_END.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[FlexJustifyContent.SPACE_BETWEEN.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[FlexJustifyContent.SPACE_AROUND.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr[FlexJustifyContent.SPACE_EVENLY.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            f339276a = iArr;
            int[] iArr2 = new int[FlexAlign.values().length];
            try {
                iArr2[FlexAlign.FLEX_START.ordinal()] = 1;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                iArr2[FlexAlign.FLEX_END.ordinal()] = 2;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                iArr2[FlexAlign.CENTER.ordinal()] = 3;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                iArr2[FlexAlign.STRETCH.ordinal()] = 4;
            } catch (NoSuchFieldError unused9) {
            }
            f339277b = iArr2;
            int[] iArr3 = new int[Alignment.Horizontal.values().length];
            try {
                iArr3[Alignment.Horizontal.Start.ordinal()] = 1;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                iArr3[Alignment.Horizontal.End.ordinal()] = 2;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                iArr3[Alignment.Horizontal.CenterHorizontally.ordinal()] = 3;
            } catch (NoSuchFieldError unused12) {
            }
            f339278c = iArr3;
            int[] iArr4 = new int[Alignment.Vertical.values().length];
            try {
                iArr4[Alignment.Vertical.Top.ordinal()] = 1;
            } catch (NoSuchFieldError unused13) {
            }
            try {
                iArr4[Alignment.Vertical.Bottom.ordinal()] = 2;
            } catch (NoSuchFieldError unused14) {
            }
            try {
                iArr4[Alignment.Vertical.CenterVertically.ordinal()] = 3;
            } catch (NoSuchFieldError unused15) {
            }
            f339279d = iArr4;
            int[] iArr5 = new int[Alignment.values().length];
            try {
                iArr5[Alignment.TopStart.ordinal()] = 1;
            } catch (NoSuchFieldError unused16) {
            }
            try {
                iArr5[Alignment.TopCenter.ordinal()] = 2;
            } catch (NoSuchFieldError unused17) {
            }
            try {
                iArr5[Alignment.TopEnd.ordinal()] = 3;
            } catch (NoSuchFieldError unused18) {
            }
            try {
                iArr5[Alignment.CenterStart.ordinal()] = 4;
            } catch (NoSuchFieldError unused19) {
            }
            try {
                iArr5[Alignment.Center.ordinal()] = 5;
            } catch (NoSuchFieldError unused20) {
            }
            try {
                iArr5[Alignment.CenterEnd.ordinal()] = 6;
            } catch (NoSuchFieldError unused21) {
            }
            try {
                iArr5[Alignment.BottomStart.ordinal()] = 7;
            } catch (NoSuchFieldError unused22) {
            }
            try {
                iArr5[Alignment.BottomCenter.ordinal()] = 8;
            } catch (NoSuchFieldError unused23) {
            }
            try {
                iArr5[Alignment.BottomEnd.ordinal()] = 9;
            } catch (NoSuchFieldError unused24) {
            }
            f339280e = iArr5;
            int[] iArr6 = new int[FlexDirection.values().length];
            try {
                iArr6[FlexDirection.ROW.ordinal()] = 1;
            } catch (NoSuchFieldError unused25) {
            }
            try {
                iArr6[FlexDirection.ROW_REVERSE.ordinal()] = 2;
            } catch (NoSuchFieldError unused26) {
            }
            f339281f = iArr6;
        }
    }

    static {
        FlexLayout.DimensionType dimensionType = FlexLayout.DimensionType.DIMENSION_HEIGHT;
        FlexLayout.DimensionType dimensionType2 = FlexLayout.DimensionType.DIMENSION_WIDTH;
        dim = new int[]{dimensionType.ordinal(), dimensionType.ordinal(), dimensionType2.ordinal(), dimensionType2.ordinal()};
        StyleSpace.Type type = StyleSpace.Type.TOP;
        StyleSpace.Type type2 = StyleSpace.Type.BOTTOM;
        StyleSpace.Type type3 = StyleSpace.Type.LEFT;
        StyleSpace.Type type4 = StyleSpace.Type.RIGHT;
        leading = new StyleSpace.Type[]{type, type2, type3, type4};
        StyleSpace.Type type5 = StyleSpace.Type.START;
        leadingSpacing = new StyleSpace.Type[]{type, type2, type5, type5};
        StyleSpace.Type type6 = StyleSpace.Type.END;
        trailingSpacing = new StyleSpace.Type[]{type2, type, type6, type6};
        trailing = new StyleSpace.Type[]{type2, type, type4, type3};
        pos = new int[]{FlexLayout.PositionType.POSITION_TOP.ordinal(), FlexLayout.PositionType.POSITION_BOTTOM.ordinal(), FlexLayout.PositionType.POSITION_LEFT.ordinal(), FlexLayout.PositionType.POSITION_RIGHT.ordinal()};
    }

    g() {
    }

    private final float A(d dVar, FlexDirection flexDirection, float f16) {
        float z16 = z(dVar, flexDirection);
        return Float.isNaN(z16) ? f16 : z16;
    }

    private final float B(d dVar, FlexDirection flexDirection) {
        return C(dVar, flexDirection) + D(dVar, flexDirection);
    }

    private final float C(d dVar, FlexDirection flexDirection) {
        return dVar.L(Z(flexDirection), a0(flexDirection));
    }

    private final float D(d dVar, FlexDirection flexDirection) {
        return dVar.L(v0(flexDirection), w0(flexDirection));
    }

    private final float E(d dVar, FlexDirection flexDirection) {
        return dVar.S(Z(flexDirection), a0(flexDirection));
    }

    private final float F(d dVar, FlexDirection flexDirection) {
        return dVar.S(v0(flexDirection), w0(flexDirection));
    }

    private final float G(d dVar, FlexDirection flexDirection) {
        return dVar.T()[trailing[flexDirection.ordinal()].ordinal()];
    }

    private final float H(d dVar, FlexDirection flexDirection, float f16) {
        return Float.isNaN(G(dVar, flexDirection)) ? f16 : G(dVar, flexDirection);
    }

    private final boolean I(d dVar) {
        int h16 = dVar.h();
        for (int i3 = 0; i3 < h16; i3++) {
            FlexNode g16 = dVar.g(i3);
            if (g16 != null && g16.f() != FlexAlign.FLEX_START && g16.f() != FlexAlign.AUTO) {
                return true;
            }
        }
        return false;
    }

    private final boolean J(d dVar) {
        return dVar.G() == FlexPositionType.BOX || (dVar.G() == FlexPositionType.ABSOLUTE && dVar.b1() != null);
    }

    private final boolean K(d dVar, FlexDirection flexDirection) {
        f n3 = n(dVar, flexDirection);
        if (n3 == null) {
            return false;
        }
        return !(n3.getValue() == f.INSTANCE.c().getValue());
    }

    private final boolean M(d dVar) {
        return (dVar.G() == FlexPositionType.RELATIVE || dVar.G() == FlexPositionType.BOX) && dVar.i() > 0.0f;
    }

    private final boolean N(d dVar) {
        return dVar.G() == FlexPositionType.ABSOLUTE;
    }

    private final boolean O(d dVar) {
        return dVar.G() == FlexPositionType.RELATIVE;
    }

    private final boolean P(d dVar, FlexDirection flexDirection) {
        return !Float.isNaN(dVar.q()[dim[flexDirection.ordinal()]]);
    }

    private final boolean Q(d dVar, d dVar2) {
        if (!J(dVar2)) {
            return false;
        }
        Object f16 = dVar.f1();
        c cVar = f16 instanceof c ? (c) f16 : null;
        if (cVar == null) {
            return false;
        }
        return cVar.getIsMatchParentSize();
    }

    private final boolean R(d dVar) {
        return dVar.getMeasureFunction() != null;
    }

    private final boolean S(d dVar, FlexDirection flexDirection) {
        float y16 = y(dVar, flexDirection);
        return !Float.isNaN(y16) && y16 >= 0.0f;
    }

    private final boolean T(d dVar, FlexDirection flexDirection) {
        return !Float.isNaN(z(dVar, flexDirection));
    }

    private final boolean U(d dVar, FlexDirection flexDirection) {
        return !Float.isNaN(G(dVar, flexDirection));
    }

    private final boolean V(d dVar, FlexDirection flexDirection) {
        f x06 = x0(dVar, flexDirection);
        return x06 != null && x06.getValue() == f.INSTANCE.c().getValue();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:154:0x067e  */
    /* JADX WARN: Removed duplicated region for block: B:187:0x0714  */
    /* JADX WARN: Removed duplicated region for block: B:190:0x0724  */
    /* JADX WARN: Removed duplicated region for block: B:213:0x0826  */
    /* JADX WARN: Removed duplicated region for block: B:216:0x083a A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:257:0x0846  */
    /* JADX WARN: Removed duplicated region for block: B:259:0x0706  */
    /* JADX WARN: Removed duplicated region for block: B:310:0x0462  */
    /* JADX WARN: Removed duplicated region for block: B:315:0x04a1  */
    /* JADX WARN: Removed duplicated region for block: B:320:0x04c7  */
    /* JADX WARN: Removed duplicated region for block: B:323:0x049d  */
    /* JADX WARN: Removed duplicated region for block: B:329:0x031e  */
    /* JADX WARN: Removed duplicated region for block: B:335:0x033e  */
    /* JADX WARN: Removed duplicated region for block: B:357:0x03eb  */
    /* JADX WARN: Removed duplicated region for block: B:445:0x089d  */
    /* JADX WARN: Removed duplicated region for block: B:547:0x0a03  */
    /* JADX WARN: Removed duplicated region for block: B:549:0x0a0b A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:552:0x0a53  */
    /* JADX WARN: Removed duplicated region for block: B:572:0x0aab  */
    /* JADX WARN: Removed duplicated region for block: B:629:0x0a11  */
    /* JADX WARN: Type inference failed for: r61v0, types: [com.tencent.ntcompose.foundation.layout.base.g] */
    /* JADX WARN: Type inference failed for: r6v42 */
    /* JADX WARN: Type inference failed for: r6v6 */
    /* JADX WARN: Type inference failed for: r6v7, types: [com.tencent.kuikly.core.layout.FlexNode] */
    /* JADX WARN: Type inference failed for: r6v71 */
    /* JADX WARN: Type inference failed for: r6v74 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final void Y(d node, float parentMaxWidth, com.tencent.kuikly.core.layout.b layoutContext, FlexLayoutDirection parentDirection, Set<d> dirtyList, boolean needLayoutAbsoluteChild) {
        boolean z16;
        boolean z17;
        int i3;
        d dVar;
        d dVar2;
        FlexNode flexNode;
        d dVar3;
        FlexDirection flexDirection;
        FlexNode flexNode2;
        d dVar4;
        FlexDirection flexDirection2;
        float f16;
        int i16;
        float f17;
        char c16;
        int i17;
        float f18;
        float f19;
        float f26;
        int i18;
        int i19;
        FlexJustifyContent flexJustifyContent;
        float f27;
        float f28;
        float f29;
        FlexJustifyContent flexJustifyContent2;
        float f36;
        int i26;
        FlexJustifyContent flexJustifyContent3;
        FlexJustifyContent flexJustifyContent4;
        float f37;
        d dVar5;
        d dVar6;
        FlexNode flexNode3;
        float f38;
        float B;
        float r16;
        int i27;
        float f39;
        d dVar7;
        int i28;
        FlexDirection flexDirection3;
        int i29;
        float l3;
        float f46;
        d dVar8;
        d dVar9;
        FlexNode flexNode4;
        d dVar10;
        float r17;
        float B2;
        for (int h16 = node.h() - 1; -1 < h16; h16--) {
            FlexNode g16 = node.g(h16);
            if (g16 != null) {
                g16.i0();
                Unit unit = Unit.INSTANCE;
            }
        }
        if (node.getCom.tencent.mtt.hippy.views.hippylist.ViewStickEventHelper.IS_SHOW java.lang.String()) {
            FlexLayoutDirection k06 = k0(node, parentDirection);
            FlexDirection h06 = h0(node.j(), k06);
            FlexDirection q16 = q(h06, k06);
            FlexDirection flexDirection4 = FlexDirection.ROW;
            FlexDirection h07 = h0(flexDirection4, k06);
            n0(node, h06);
            g0(node);
            i0(node);
            l0(node);
            m0(node);
            o0(node, h06);
            o0(node, q16);
            node.o0(k06);
            r0(node, h06, s(node, h06) + C(node, h06) + v(node, h06));
            t0(node, h06, u(node, h06) + D(node, h06) + v(node, h06));
            r0(node, q16, s(node, q16) + C(node, q16) + v(node, q16));
            t0(node, q16, u(node, q16) + D(node, q16) + v(node, q16));
            int h17 = node.h();
            float d06 = d0(node, h07);
            if (R(node) && e0(node, parentMaxWidth, d06, h07, layoutContext)) {
                return;
            }
            boolean z18 = node.l() == FlexWrap.WRAP;
            FlexJustifyContent m3 = node.m();
            float E = E(node, h06) + w(node, h06);
            float E2 = E(node, q16) + w(node, q16);
            float d07 = d0(node, h06);
            float d08 = d0(node, q16);
            boolean P = P(node, h06);
            boolean P2 = P(node, q16);
            boolean z19 = h06 == flexDirection4 || h06 == FlexDirection.ROW_REVERSE;
            FloatCompanionObject floatCompanionObject = FloatCompanionObject.INSTANCE;
            float r18 = P ? r(node, h06) - d07 : Float.NaN;
            int i36 = 0;
            int i37 = 0;
            int i38 = 0;
            int i39 = 0;
            boolean z26 = false;
            float f47 = 0.0f;
            float f48 = 0.0f;
            d dVar11 = null;
            d dVar12 = null;
            d dVar13 = null;
            d dVar14 = null;
            d dVar15 = null;
            d dVar16 = null;
            while (i36 < h17) {
                boolean z27 = (P && m3 == FlexJustifyContent.FLEX_START) || !(P || m3 == FlexJustifyContent.CENTER);
                int i46 = z27 ? h17 : i38;
                float f49 = E;
                FlexJustifyContent flexJustifyContent5 = m3;
                int i47 = h17;
                int i48 = 0;
                int i49 = 0;
                float f56 = r18;
                int i56 = i38;
                ?? r65 = dVar13;
                d dVar17 = dVar14;
                FlexNode flexNode5 = null;
                float f57 = 0.0f;
                d dVar18 = null;
                float f58 = 0.0f;
                float f59 = 0.0f;
                int i57 = i39;
                d dVar19 = dVar11;
                boolean z28 = z27;
                int i58 = i36;
                d dVar20 = dVar12;
                boolean z29 = true;
                while (true) {
                    i17 = i58;
                    if (i56 >= h17) {
                        f18 = d08;
                        f19 = d07;
                        f26 = E;
                        i18 = i37;
                        i19 = h17;
                        dVar14 = dVar17;
                        flexJustifyContent = flexJustifyContent5;
                        f27 = f58;
                        f28 = f59;
                        f29 = 0.0f;
                        dVar12 = dVar20;
                        dVar11 = dVar19;
                        i39 = i57;
                        dVar13 = r65;
                        break;
                    }
                    FlexNode g17 = node.g(i56);
                    float f65 = d07;
                    d dVar21 = g17 instanceof d ? (d) g17 : null;
                    if (dVar21 == null) {
                        f18 = d08;
                        f26 = E;
                        i18 = i37;
                        i19 = h17;
                        i27 = i38;
                        flexJustifyContent = flexJustifyContent5;
                        f19 = f65;
                        i58 = i56 + 1;
                    } else if (dVar21.getCom.tencent.mtt.hippy.views.hippylist.ViewStickEventHelper.IS_SHOW java.lang.String()) {
                        dVar21.z0(i37);
                        dVar21.C0(null);
                        dVar21.D0(null);
                        i19 = h17;
                        FlexAlign o16 = o(node, dVar21);
                        if (o16 == FlexAlign.STRETCH && !V(dVar21, q16) && ((O(dVar21) || J(dVar21)) && P2 && !S(dVar21, q16))) {
                            float r19 = r(node, q16);
                            f n3 = n(dVar21, q16);
                            float l16 = l(dVar21, q16, ((r19 * (n3 != null ? n3.getValue() : 1.0f)) - d08) - B(dVar21, q16));
                            f39 = E;
                            p0(dVar21, q16, Math.max(l16, d0(dVar21, q16)));
                        } else {
                            f39 = E;
                            if ((O(dVar21) || J(dVar21)) && P2 && !S(dVar21, q16) && K(dVar21, q16)) {
                                f n16 = n(dVar21, q16);
                                p0(dVar21, q16, Math.max(l(dVar21, q16, ((r(node, q16) * (n16 != null ? n16.getValue() : 1.0f)) - d08) - B(dVar21, q16)), d0(dVar21, q16)));
                            } else if (N(dVar21)) {
                                if (dVar20 == null) {
                                    dVar20 = dVar21;
                                }
                                if (r65 != 0) {
                                    r65.C0(dVar21);
                                }
                                int i59 = 0;
                                while (i59 < 2) {
                                    if (i59 != 0) {
                                        flexDirection3 = FlexDirection.ROW;
                                    } else {
                                        flexDirection3 = FlexDirection.COLUMN;
                                    }
                                    if (P(node, flexDirection3) && !S(dVar21, flexDirection3) && T(dVar21, flexDirection3) && U(dVar21, flexDirection3) && !V(dVar21, flexDirection3)) {
                                        if (!K(dVar21, flexDirection3)) {
                                            i29 = i37;
                                            l3 = l(dVar21, flexDirection3, (((r(node, flexDirection3) - d0(node, flexDirection3)) - B(dVar21, flexDirection3)) - A(dVar21, flexDirection3, 0.0f)) - H(dVar21, flexDirection3, 0.0f));
                                        } else {
                                            i29 = i37;
                                            l3 = l(dVar21, flexDirection3, r(node, flexDirection3) - B(dVar21, flexDirection3));
                                        }
                                        if (K(dVar21, flexDirection3)) {
                                            f n17 = n(dVar21, flexDirection3);
                                            p0(dVar21, flexDirection3, Math.max(l3 * (n17 != null ? n17.getValue() : 1.0f), d0(dVar21, flexDirection3)));
                                        } else {
                                            p0(dVar21, flexDirection3, Math.max(l3, d0(dVar21, flexDirection3)));
                                        }
                                    } else {
                                        i29 = i37;
                                    }
                                    i57 = i59;
                                    i59++;
                                    i37 = i29;
                                }
                                i18 = i37;
                                dVar7 = dVar20;
                                i28 = i57;
                                dVar13 = dVar21;
                                if (!P && M(dVar21)) {
                                    i48++;
                                    f57 += dVar21.i();
                                    if (dVar18 == null) {
                                        dVar18 = dVar21;
                                    }
                                    if (flexNode5 != null) {
                                        flexNode5.D0(dVar21);
                                    }
                                    r17 = c0(dVar21, h06);
                                    f18 = d08;
                                    dVar10 = dVar21;
                                    flexNode5 = dVar10;
                                    dVar14 = dVar17;
                                    flexJustifyContent = flexJustifyContent5;
                                    f19 = f65;
                                    f26 = f39;
                                    dVar9 = dVar7;
                                } else if (!Q(dVar21, node)) {
                                    if (dVar19 == null) {
                                        dVar19 = dVar21;
                                    }
                                    d dVar22 = dVar17;
                                    if (dVar22 != null) {
                                        dVar22.E0(dVar21);
                                    }
                                    r17 = c0(dVar21, h06);
                                    f18 = d08;
                                    dVar10 = dVar21;
                                    dVar14 = dVar10;
                                    dVar9 = dVar7;
                                    flexJustifyContent = flexJustifyContent5;
                                    f19 = f65;
                                    f26 = f39;
                                } else {
                                    d dVar23 = dVar17;
                                    FloatCompanionObject floatCompanionObject2 = FloatCompanionObject.INSTANCE;
                                    if (z19) {
                                        f46 = Float.NaN;
                                    } else {
                                        if (S(node, h07)) {
                                            B2 = y(node, h07);
                                        } else {
                                            B2 = parentMaxWidth - B(node, h07);
                                        }
                                        f46 = l(dVar21, h07, B2 - d06);
                                    }
                                    if (K(dVar21, h06) && P && (O(dVar21) || J(dVar21))) {
                                        float B3 = f56 - B(dVar21, h06);
                                        f n18 = n(dVar21, h06);
                                        p0(dVar21, h06, B3 * (n18 != null ? n18.getValue() : 1.0f));
                                        if (!z26) {
                                            dVar9 = dVar7;
                                            f18 = d08;
                                            dVar8 = dVar21;
                                            f19 = f65;
                                            f26 = f39;
                                            flexJustifyContent = flexJustifyContent5;
                                            flexNode4 = flexNode5;
                                            dVar14 = dVar23;
                                            f29 = 0.0f;
                                            W(dVar21, f46, layoutContext, k06, needLayoutAbsoluteChild, dirtyList);
                                            dVar10 = dVar8;
                                            if (O(dVar10)) {
                                            }
                                            i49++;
                                            r17 = r(dVar10, h06) + B(dVar10, h06);
                                            flexNode5 = flexNode4;
                                        } else {
                                            f18 = d08;
                                            dVar14 = dVar23;
                                            dVar9 = dVar7;
                                            flexJustifyContent = flexJustifyContent5;
                                            f19 = f65;
                                            f26 = f39;
                                            f29 = 0.0f;
                                            flexNode4 = flexNode5;
                                            dVar10 = dVar21;
                                            if (O(dVar10)) {
                                            }
                                            i49++;
                                            r17 = r(dVar10, h06) + B(dVar10, h06);
                                            flexNode5 = flexNode4;
                                        }
                                    } else {
                                        f18 = d08;
                                        dVar8 = dVar21;
                                        dVar14 = dVar23;
                                        dVar9 = dVar7;
                                        flexJustifyContent = flexJustifyContent5;
                                        f19 = f65;
                                        f26 = f39;
                                        f29 = 0.0f;
                                        flexNode4 = flexNode5;
                                        if (!z26) {
                                            dVar10 = dVar8;
                                            W(dVar10, f46, layoutContext, k06, needLayoutAbsoluteChild, dirtyList);
                                            if (!O(dVar10) || J(dVar10)) {
                                                i49++;
                                                r17 = r(dVar10, h06) + B(dVar10, h06);
                                            } else {
                                                r17 = f29;
                                            }
                                            flexNode5 = flexNode4;
                                        }
                                        dVar10 = dVar8;
                                        if (O(dVar10)) {
                                        }
                                        i49++;
                                        r17 = r(dVar10, h06) + B(dVar10, h06);
                                        flexNode5 = flexNode4;
                                    }
                                    if (!z18 && P) {
                                        f27 = f58;
                                        i27 = i38;
                                        if (f27 + r17 > r18 && i56 != i27) {
                                            i49--;
                                            dVar11 = dVar19;
                                            dVar12 = dVar9;
                                            f28 = f59;
                                            i39 = i28;
                                            z26 = true;
                                            break;
                                        }
                                    } else {
                                        i27 = i38;
                                        f27 = f58;
                                    }
                                    if (!J(node) || (z28 && (!O(dVar10) || M(dVar10)))) {
                                        i46 = i56;
                                        z28 = false;
                                    }
                                    if (!J(node) || (z29 && (!O(dVar10) || ((o16 != FlexAlign.STRETCH && o16 != FlexAlign.FLEX_START) || Float.isNaN(y(dVar10, q16)))))) {
                                        i47 = i56;
                                        z29 = false;
                                    }
                                    if (!z28) {
                                        s0(dVar10, h06, t(dVar10, h06) + f49);
                                        if (P) {
                                            t0(dVar10, h06, (r(node, h06) - r(dVar10, h06)) - t(dVar10, h06));
                                        }
                                        f49 += r(dVar10, h06) + B(dVar10, h06);
                                        f59 = Math.max(f59, l(dVar10, q16, r(dVar10, q16) + B(dVar10, q16)));
                                    }
                                    if (z29) {
                                        s0(dVar10, q16, t(dVar10, q16) + f47 + E2);
                                        if (P2) {
                                            t0(dVar10, q16, (r(node, q16) - r(dVar10, q16)) - t(dVar10, q16));
                                        }
                                    }
                                    f58 = f27 + r17;
                                    if (!J(node)) {
                                        f56 -= r17;
                                    }
                                    i58 = i56 + 1;
                                    z26 = false;
                                    r65 = dVar13;
                                    dVar20 = dVar9;
                                    i57 = i28;
                                    dVar17 = dVar14;
                                }
                                f29 = 0.0f;
                                if (!z18) {
                                }
                                i27 = i38;
                                f27 = f58;
                                if (!J(node)) {
                                }
                                i46 = i56;
                                z28 = false;
                                if (!J(node)) {
                                }
                                i47 = i56;
                                z29 = false;
                                if (!z28) {
                                }
                                if (z29) {
                                }
                                f58 = f27 + r17;
                                if (!J(node)) {
                                }
                                i58 = i56 + 1;
                                z26 = false;
                                r65 = dVar13;
                                dVar20 = dVar9;
                                i57 = i28;
                                dVar17 = dVar14;
                            }
                        }
                        i18 = i37;
                        dVar7 = dVar20;
                        i28 = i57;
                        dVar13 = r65;
                        if (!P) {
                        }
                        if (!Q(dVar21, node)) {
                        }
                    } else {
                        i58 = i56 + 1;
                        f18 = d08;
                        f26 = E;
                        i18 = i37;
                        i19 = h17;
                        i27 = i38;
                        flexJustifyContent = flexJustifyContent5;
                        f19 = f65;
                    }
                    i56++;
                    i38 = i27;
                    h17 = i19;
                    i37 = i18;
                    d08 = f18;
                    E = f26;
                    d07 = f19;
                    flexJustifyContent5 = flexJustifyContent;
                    r65 = r65;
                }
                float max = P ? r18 - f27 : Math.max(f27, f29) - f27;
                if (i48 != 0) {
                    float f66 = max / f57;
                    d dVar24 = dVar18;
                    while (dVar24 != null) {
                        if (dVar24.getCom.tencent.mtt.hippy.views.hippylist.ViewStickEventHelper.IS_SHOW java.lang.String()) {
                            float i65 = (dVar24.i() * f66) + d0(dVar24, h06);
                            float l17 = l(dVar24, h06, i65);
                            if (!(i65 == l17)) {
                                max -= l17;
                                f57 -= dVar24.i();
                            }
                        }
                        FlexNode nextFlexChild = dVar24.getNextFlexChild();
                        dVar24 = nextFlexChild instanceof d ? (d) nextFlexChild : null;
                    }
                    float f67 = max / f57;
                    float f68 = f67 < f29 ? f29 : f67;
                    d dVar25 = dVar18;
                    while (dVar25 != null) {
                        if (dVar25.getCom.tencent.mtt.hippy.views.hippylist.ViewStickEventHelper.IS_SHOW java.lang.String()) {
                            p0(dVar25, h06, l(dVar25, h06, (dVar25.i() * f68) + d0(dVar25, h06)));
                            if (J(dVar25) && V(dVar25, h06)) {
                                Object f110 = dVar25.f1();
                                c cVar = f110 instanceof c ? (c) f110 : null;
                                if (cVar == null) {
                                    cVar = new c(null, false, null, 7, null);
                                }
                                cVar.e(h06);
                                dVar25.n1(cVar);
                            }
                            FloatCompanionObject floatCompanionObject3 = FloatCompanionObject.INSTANCE;
                            if (S(node, h07)) {
                                B = y(node, h07);
                            } else if (dVar25.j() == FlexDirection.COLUMN && dVar25.c1() != null) {
                                r16 = r(dVar25, h06);
                                f38 = r16;
                                dVar5 = dVar25;
                                W(dVar25, f38, layoutContext, k06, needLayoutAbsoluteChild, dirtyList);
                            } else if (!z19) {
                                B = parentMaxWidth - B(node, h07);
                            } else {
                                f38 = Float.NaN;
                                dVar5 = dVar25;
                                W(dVar25, f38, layoutContext, k06, needLayoutAbsoluteChild, dirtyList);
                            }
                            r16 = B - d06;
                            f38 = r16;
                            dVar5 = dVar25;
                            W(dVar25, f38, layoutContext, k06, needLayoutAbsoluteChild, dirtyList);
                        } else {
                            dVar5 = dVar25;
                        }
                        FlexNode nextFlexChild2 = dVar5.getNextFlexChild();
                        if (nextFlexChild2 instanceof d) {
                            dVar25 = (d) nextFlexChild2;
                            dVar6 = dVar5;
                            flexNode3 = null;
                        } else {
                            dVar6 = dVar5;
                            flexNode3 = null;
                            dVar25 = null;
                        }
                        dVar6.D0(flexNode3);
                    }
                    flexJustifyContent2 = flexJustifyContent;
                } else {
                    flexJustifyContent2 = flexJustifyContent;
                    if (flexJustifyContent2 != FlexJustifyContent.FLEX_START) {
                        int i66 = a.f339276a[flexJustifyContent2.ordinal()];
                        if (i66 == 1) {
                            max /= 2;
                            Unit unit2 = Unit.INSTANCE;
                        } else if (i66 == 2) {
                            Unit unit3 = Unit.INSTANCE;
                        } else {
                            if (i66 == 3) {
                                int i67 = (i48 + i49) - 1;
                                float max2 = i67 != 0 ? Math.max(max, f29) / i67 : f29;
                                Unit unit4 = Unit.INSTANCE;
                                f36 = max2;
                                max = f29;
                            } else if (i66 == 4) {
                                int i68 = i48 + i49;
                                if (i68 != 0) {
                                    max /= i68;
                                }
                                Unit unit5 = Unit.INSTANCE;
                                float f69 = max;
                                max /= 2;
                                f36 = f69;
                            } else if (i66 != 5) {
                                Unit unit6 = Unit.INSTANCE;
                            } else {
                                if (i48 + i49 != 0) {
                                    max /= r41 + 1;
                                }
                                Unit unit7 = Unit.INSTANCE;
                                f36 = max;
                            }
                            float f75 = f49 + max;
                            if (J(node)) {
                                i26 = i17;
                            } else {
                                i26 = i17;
                                for (int i69 = i46; i69 < i26; i69++) {
                                    FlexNode g18 = node.g(i69);
                                    d dVar26 = g18 instanceof d ? (d) g18 : null;
                                    if (dVar26 != null && dVar26.getCom.tencent.mtt.hippy.views.hippylist.ViewStickEventHelper.IS_SHOW java.lang.String()) {
                                        if (N(dVar26) && (T(dVar26, h06) || S(dVar26, h06))) {
                                            s0(dVar26, h06, A(dVar26, h06, f29) + w(node, h06) + C(dVar26, h06));
                                        } else {
                                            s0(dVar26, h06, t(dVar26, h06) + f75);
                                            if (P) {
                                                t0(dVar26, h06, (r(node, h06) - r(dVar26, h06)) - t(dVar26, h06));
                                            }
                                            if (O(dVar26) || J(dVar26)) {
                                                f75 += r(dVar26, h06) + f36 + B(dVar26, h06);
                                                f28 = Math.max(f28, l(dVar26, q16, r(dVar26, q16) + B(dVar26, q16)));
                                            }
                                        }
                                    }
                                }
                            }
                            float f76 = f28;
                            float f77 = f75;
                            float r26 = r(node, q16);
                            float f78 = f18;
                            if (!P2) {
                                r26 = Math.max(l(node, q16, f76 + f78), f78);
                            }
                            if (J(node)) {
                                flexJustifyContent3 = flexJustifyContent2;
                            } else {
                                d dVar27 = dVar16;
                                int i75 = i47;
                                while (i75 < i26) {
                                    FlexNode g19 = node.g(i75);
                                    d dVar28 = g19 instanceof d ? (d) g19 : null;
                                    if (dVar28 != null && dVar28.getCom.tencent.mtt.hippy.views.hippylist.ViewStickEventHelper.IS_SHOW java.lang.String()) {
                                        if (N(dVar28) && (T(dVar28, q16) || S(dVar28, q16))) {
                                            s0(dVar28, q16, A(dVar28, q16, f29) + w(node, q16) + C(dVar28, q16));
                                        } else {
                                            if (O(dVar28) || J(dVar28)) {
                                                FlexAlign o17 = o(node, dVar28);
                                                if (o17 == FlexAlign.STRETCH) {
                                                    if (!P(dVar28, q16)) {
                                                        float max3 = Math.max(l(dVar28, q16, (r26 - f78) - B(dVar28, q16)), d0(dVar28, q16));
                                                        if (K(dVar28, q16)) {
                                                            f n19 = n(dVar28, q16);
                                                            max3 *= n19 != null ? n19.getValue() : 1.0f;
                                                        }
                                                        p0(dVar28, q16, max3);
                                                        if (dVar15 == null) {
                                                            flexJustifyContent4 = flexJustifyContent2;
                                                            dVar27 = dVar28;
                                                            dVar15 = dVar27;
                                                        } else {
                                                            Intrinsics.checkNotNull(dVar27);
                                                            dVar27.F0(dVar28);
                                                            flexJustifyContent4 = flexJustifyContent2;
                                                            dVar27 = dVar28;
                                                        }
                                                        f37 = E2;
                                                        s0(dVar28, q16, t(dVar28, q16) + f47 + f37);
                                                        if (P2) {
                                                            t0(dVar28, q16, (r(node, q16) - r(dVar28, q16)) - t(dVar28, q16));
                                                        }
                                                        i75++;
                                                        flexJustifyContent2 = flexJustifyContent4;
                                                        f29 = 0.0f;
                                                    }
                                                } else if (K(dVar28, q16)) {
                                                    if (!P(dVar28, q16)) {
                                                        float max4 = Math.max(l(dVar28, q16, (r26 - f78) - B(dVar28, q16)), d0(dVar28, q16));
                                                        if (K(dVar28, q16)) {
                                                            f n26 = n(dVar28, q16);
                                                            max4 *= n26 != null ? n26.getValue() : 1.0f;
                                                        }
                                                        p0(dVar28, q16, max4);
                                                    }
                                                } else if (o17 != FlexAlign.FLEX_START) {
                                                    float r27 = (r26 - f78) - (r(dVar28, q16) + B(dVar28, q16));
                                                    flexJustifyContent4 = flexJustifyContent2;
                                                    if (o17 == FlexAlign.CENTER) {
                                                        r27 /= 2;
                                                    }
                                                    f37 = E2 + r27;
                                                    s0(dVar28, q16, t(dVar28, q16) + f47 + f37);
                                                    if (P2) {
                                                    }
                                                    i75++;
                                                    flexJustifyContent2 = flexJustifyContent4;
                                                    f29 = 0.0f;
                                                }
                                            }
                                            flexJustifyContent4 = flexJustifyContent2;
                                            f37 = E2;
                                            s0(dVar28, q16, t(dVar28, q16) + f47 + f37);
                                            if (P2) {
                                            }
                                            i75++;
                                            flexJustifyContent2 = flexJustifyContent4;
                                            f29 = 0.0f;
                                        }
                                    }
                                    flexJustifyContent4 = flexJustifyContent2;
                                    i75++;
                                    flexJustifyContent2 = flexJustifyContent4;
                                    f29 = 0.0f;
                                }
                                flexJustifyContent3 = flexJustifyContent2;
                                dVar16 = dVar27;
                            }
                            f47 += f76;
                            f48 = Math.max(f48, f77);
                            i37 = i18 + 1;
                            i36 = i26;
                            i38 = i36;
                            d08 = f78;
                            h17 = i19;
                            E = f26;
                            d07 = f19;
                            m3 = flexJustifyContent3;
                        }
                        f36 = f29;
                        float f752 = f49 + max;
                        if (J(node)) {
                        }
                        float f762 = f28;
                        float f772 = f752;
                        float r262 = r(node, q16);
                        float f782 = f18;
                        if (!P2) {
                        }
                        if (J(node)) {
                        }
                        f47 += f762;
                        f48 = Math.max(f48, f772);
                        i37 = i18 + 1;
                        i36 = i26;
                        i38 = i36;
                        d08 = f782;
                        h17 = i19;
                        E = f26;
                        d07 = f19;
                        m3 = flexJustifyContent3;
                    }
                }
                f36 = f29;
                max = f36;
                float f7522 = f49 + max;
                if (J(node)) {
                }
                float f7622 = f28;
                float f7722 = f7522;
                float r2622 = r(node, q16);
                float f7822 = f18;
                if (!P2) {
                }
                if (J(node)) {
                }
                f47 += f7622;
                f48 = Math.max(f48, f7722);
                i37 = i18 + 1;
                i36 = i26;
                i38 = i36;
                d08 = f7822;
                h17 = i19;
                E = f26;
                d07 = f19;
                m3 = flexJustifyContent3;
            }
            float f79 = d07;
            float f85 = E;
            int i76 = h17;
            float f86 = f48;
            float f87 = d08;
            if (i37 > 1 && P2) {
                float r28 = r(node, q16) - f87;
                float f88 = r28 - f47;
                FlexAlign d16 = node.d();
                if (d16 != FlexAlign.FLEX_END) {
                    if (d16 == FlexAlign.CENTER) {
                        f88 /= 2;
                    } else {
                        if (d16 == FlexAlign.STRETCH && r28 > f47) {
                            f16 = f88 / i37;
                            i16 = 0;
                            int i77 = 0;
                            while (i16 < i37) {
                                int i78 = i77;
                                int i79 = i76;
                                float f89 = 0.0f;
                                while (true) {
                                    if (i78 >= i79) {
                                        i78 = i39;
                                        break;
                                    }
                                    FlexNode g26 = node.g(i78);
                                    d dVar29 = g26 instanceof d ? (d) g26 : null;
                                    if (dVar29 != null && dVar29.getCom.tencent.mtt.hippy.views.hippylist.ViewStickEventHelper.IS_SHOW java.lang.String() && (J(dVar29) || O(dVar29))) {
                                        if (dVar29.getLineIndex() != i16) {
                                            break;
                                        } else if (P(dVar29, q16)) {
                                            f89 = Math.max(f89, r(dVar29, q16) + B(dVar29, q16));
                                        }
                                    }
                                    i39 = i78;
                                    i78++;
                                }
                                int i85 = i77 == i78 ? i78 + 1 : i78;
                                float f95 = f89 + f16;
                                if (i77 <= i85) {
                                    while (true) {
                                        FlexNode g27 = node.g(i77);
                                        d dVar30 = g27 instanceof d ? (d) g27 : null;
                                        if (dVar30 != null && dVar30.getCom.tencent.mtt.hippy.views.hippylist.ViewStickEventHelper.IS_SHOW java.lang.String() && (J(dVar30) || O(dVar30))) {
                                            int i86 = a.f339277b[o(node, dVar30).ordinal()];
                                            f17 = f16;
                                            if (i86 == 1) {
                                                c16 = 4;
                                                s0(dVar30, q16, E2 + C(dVar30, q16));
                                                Unit unit8 = Unit.INSTANCE;
                                            } else if (i86 == 2) {
                                                c16 = 4;
                                                s0(dVar30, q16, ((E2 + f95) - D(dVar30, q16)) - y(dVar30, q16));
                                                Unit unit9 = Unit.INSTANCE;
                                            } else if (i86 != 3) {
                                                c16 = 4;
                                                if (i86 == 4) {
                                                    s0(dVar30, q16, E2 + C(dVar30, q16));
                                                }
                                                Unit unit10 = Unit.INSTANCE;
                                            } else {
                                                c16 = 4;
                                                s0(dVar30, q16, E2 + ((f95 - r(dVar30, q16)) / 2.0f));
                                                Unit unit11 = Unit.INSTANCE;
                                            }
                                        } else {
                                            f17 = f16;
                                            c16 = 4;
                                        }
                                        if (i77 == i85) {
                                            break;
                                        }
                                        i77++;
                                        f16 = f17;
                                    }
                                    i39 = i77;
                                } else {
                                    f17 = f16;
                                    c16 = 4;
                                    i39 = i78;
                                }
                                E2 += f95;
                                i16++;
                                i77 = i85;
                                i76 = i79;
                                f16 = f17;
                            }
                        }
                        f16 = 0.0f;
                        i16 = 0;
                        int i772 = 0;
                        while (i16 < i37) {
                        }
                    }
                }
                E2 += f88;
                f16 = 0.0f;
                i16 = 0;
                int i7722 = 0;
                while (i16 < i37) {
                }
            }
            int i87 = i76;
            if (!P && !J(node)) {
                float F = f86 + F(node, h06) + x(node, h06);
                float max5 = Math.max(l(node, h06, F), f79);
                p0(node, h06, max5);
                if (!(F == max5) && node.m() != FlexJustifyContent.FLEX_START && node.h() != 0) {
                    h(node, h06, f85, F);
                }
                if (h06 == FlexDirection.ROW_REVERSE || h06 == FlexDirection.COLUMN_REVERSE) {
                    z16 = true;
                    if (!P2 && !J(node)) {
                        p0(node, q16, Math.max(l(node, q16, f47 + f87), f87));
                        if (q16 != FlexDirection.ROW_REVERSE || q16 == FlexDirection.COLUMN_REVERSE) {
                            z17 = true;
                            if (J(node)) {
                                j0(node);
                                d(node);
                            }
                            if (!z16 || z17) {
                                for (i3 = 0; i3 < i87; i3++) {
                                    FlexNode g28 = node.g(i3);
                                    d dVar31 = g28 instanceof d ? (d) g28 : null;
                                    if (dVar31 != null && dVar31.getCom.tencent.mtt.hippy.views.hippylist.ViewStickEventHelper.IS_SHOW java.lang.String()) {
                                        if (z16) {
                                            t0(dVar31, h06, (r(node, h06) - r(dVar31, h06)) - t(dVar31, h06));
                                        }
                                        if (z17) {
                                            t0(dVar31, q16, (r(node, q16) - r(dVar31, q16)) - t(dVar31, q16));
                                        }
                                    }
                                }
                            }
                            dVar = dVar11;
                            while (dVar != null) {
                                for (int i88 = 0; i88 < 2; i88++) {
                                    if (i88 != 0) {
                                        flexDirection2 = FlexDirection.ROW;
                                    } else {
                                        flexDirection2 = FlexDirection.COLUMN;
                                    }
                                    p0(dVar, flexDirection2, Math.max(l(dVar, flexDirection2, (r(node, flexDirection2) - d0(node, flexDirection2)) - B(dVar, flexDirection2)), d0(dVar, flexDirection2)));
                                }
                                W(dVar, r(dVar, FlexDirection.ROW), layoutContext, parentDirection, needLayoutAbsoluteChild, dirtyList);
                                FlexNode nextMatchParentSizeChild = dVar.getNextMatchParentSizeChild();
                                if (nextMatchParentSizeChild instanceof d) {
                                    dVar4 = (d) nextMatchParentSizeChild;
                                    flexNode2 = null;
                                } else {
                                    flexNode2 = null;
                                    dVar4 = null;
                                }
                                dVar.E0(flexNode2);
                                dVar = dVar4;
                            }
                            dVar2 = dVar12;
                            while (dVar2 != null) {
                                if (dVar2.getCom.tencent.mtt.hippy.views.hippylist.ViewStickEventHelper.IS_SHOW java.lang.String()) {
                                    boolean z36 = false;
                                    for (int i89 = 0; i89 < 2; i89++) {
                                        if (i89 != 0) {
                                            flexDirection = FlexDirection.ROW;
                                        } else {
                                            flexDirection = FlexDirection.COLUMN;
                                        }
                                        if (P(node, flexDirection) && !S(dVar2, flexDirection) && !Float.isNaN(z(dVar2, flexDirection)) && !Float.isNaN(G(dVar2, flexDirection)) && !V(dVar2, flexDirection)) {
                                            float max6 = Math.max(l(dVar2, flexDirection, (((r(node, flexDirection) - (x(node, flexDirection) + w(node, flexDirection))) - B(dVar2, flexDirection)) - A(dVar2, flexDirection, 0.0f)) - H(dVar2, flexDirection, 0.0f)), d0(dVar2, flexDirection));
                                            float r29 = r(dVar2, flexDirection);
                                            f n27 = n(dVar2, flexDirection);
                                            p0(dVar2, flexDirection, (n27 != null ? n27.getValue() : 1.0f) * max6);
                                            if (!z36) {
                                                z36 = m(dVar2, r29, max6, flexDirection);
                                            }
                                        }
                                        if (!Float.isNaN(G(dVar2, flexDirection)) && Float.isNaN(z(dVar2, flexDirection))) {
                                            r0(dVar2, flexDirection, (r(node, flexDirection) - r(dVar2, flexDirection)) - H(dVar2, flexDirection, 0.0f));
                                        } else if (T(dVar2, flexDirection) || S(dVar2, flexDirection)) {
                                            s0(dVar2, flexDirection, A(dVar2, flexDirection, 0.0f) + w(node, flexDirection) + C(dVar2, flexDirection));
                                        }
                                    }
                                    if (needLayoutAbsoluteChild && dVar2.h() > 0 && z36) {
                                        f0(node, dVar2, layoutContext, k06, dirtyList);
                                    }
                                }
                                FlexNode nextAbsoluteChild = dVar2.getNextAbsoluteChild();
                                if (nextAbsoluteChild instanceof d) {
                                    dVar3 = (d) nextAbsoluteChild;
                                    flexNode = null;
                                } else {
                                    flexNode = null;
                                    dVar3 = null;
                                }
                                dVar2.C0(flexNode);
                                dVar2 = dVar3;
                            }
                        }
                    }
                    z17 = false;
                    if (J(node)) {
                    }
                    if (!z16) {
                    }
                    while (i3 < i87) {
                    }
                    dVar = dVar11;
                    while (dVar != null) {
                    }
                    dVar2 = dVar12;
                    while (dVar2 != null) {
                    }
                }
            }
            z16 = false;
            if (!P2) {
                p0(node, q16, Math.max(l(node, q16, f47 + f87), f87));
                if (q16 != FlexDirection.ROW_REVERSE) {
                }
                z17 = true;
                if (J(node)) {
                }
                if (!z16) {
                }
                while (i3 < i87) {
                }
                dVar = dVar11;
                while (dVar != null) {
                }
                dVar2 = dVar12;
                while (dVar2 != null) {
                }
            }
            z17 = false;
            if (J(node)) {
            }
            if (!z16) {
            }
            while (i3 < i87) {
            }
            dVar = dVar11;
            while (dVar != null) {
            }
            dVar2 = dVar12;
            while (dVar2 != null) {
            }
        }
    }

    private final StyleSpace.Type Z(FlexDirection direction) {
        return leadingSpacing[direction.ordinal()];
    }

    private final void a(d dVar, d dVar2) {
        FlexDirection flexDirection = FlexDirection.ROW;
        float r16 = r(dVar2, flexDirection) - r(dVar, flexDirection);
        StyleSpace.Type type = StyleSpace.Type.LEFT;
        float E = r16 + dVar2.E(type) + dVar.z(type);
        StyleSpace.Type type2 = StyleSpace.Type.RIGHT;
        dVar.x0(((E - dVar2.E(type2)) - dVar.z(type2)) / 2.0f);
        FlexDirection flexDirection2 = FlexDirection.COLUMN;
        float r17 = r(dVar2, flexDirection2) - r(dVar, flexDirection2);
        StyleSpace.Type type3 = StyleSpace.Type.BOTTOM;
        dVar.y0((r17 - dVar2.E(type3)) - dVar.z(type3));
    }

    private final StyleSpace.Type a0(FlexDirection direction) {
        return leading[direction.ordinal()];
    }

    private final void b(d dVar, d dVar2) {
        FlexDirection flexDirection = FlexDirection.ROW;
        float r16 = r(dVar2, flexDirection) - r(dVar, flexDirection);
        StyleSpace.Type type = StyleSpace.Type.RIGHT;
        dVar.x0(((r16 - dVar2.E(type)) - dVar2.E(StyleSpace.Type.LEFT)) - dVar.z(type));
        FlexDirection flexDirection2 = FlexDirection.COLUMN;
        dVar.y0(r(dVar2, flexDirection2) - r(dVar, flexDirection2));
        StyleSpace.Type type2 = StyleSpace.Type.BOTTOM;
        dVar2.E(type2);
        dVar.z(type2);
    }

    private final boolean b0(d node, float parentMaxWidth) {
        if (node.getIsDirty()) {
            return true;
        }
        float n3 = node.n();
        float t16 = node.t();
        if (!((Float.isNaN(n3) || Float.isNaN(t16) || Math.abs(t16 - n3) >= 1.0E-5f) ? false : true)) {
            return true;
        }
        float o16 = node.o();
        float v3 = node.v();
        if (!((Float.isNaN(o16) || Float.isNaN(v3) || Math.abs(v3 - o16) >= 1.0E-5f) ? false : true)) {
            return true;
        }
        float p16 = node.p();
        return !(!Float.isNaN(p16) && !Float.isNaN(parentMaxWidth) && (Math.abs(parentMaxWidth - p16) > 1.0E-5f ? 1 : (Math.abs(parentMaxWidth - p16) == 1.0E-5f ? 0 : -1)) < 0);
    }

    private final void c(d dVar, d dVar2) {
        StyleSpace.Type type = StyleSpace.Type.LEFT;
        dVar.x0(dVar2.E(type) + dVar.z(type));
        FlexDirection flexDirection = FlexDirection.COLUMN;
        float r16 = r(dVar2, flexDirection) - r(dVar, flexDirection);
        StyleSpace.Type type2 = StyleSpace.Type.BOTTOM;
        dVar.y0((r16 - dVar2.E(type2)) - dVar.z(type2));
    }

    private final float c0(d dVar, FlexDirection flexDirection) {
        return d0(dVar, flexDirection) + C(dVar, flexDirection) + D(dVar, flexDirection);
    }

    private final void d(d dVar) {
        int h16 = dVar.h();
        for (int i3 = 0; i3 < h16; i3++) {
            FlexNode g16 = dVar.g(i3);
            d dVar2 = g16 instanceof d ? (d) g16 : null;
            if (dVar2 != null) {
                switch (a.f339280e[p(dVar, i3).ordinal()]) {
                    case 1:
                        k(dVar2, dVar);
                        break;
                    case 2:
                        i(dVar2, dVar);
                        break;
                    case 3:
                        j(dVar2, dVar);
                        break;
                    case 4:
                        g(dVar2, dVar);
                        break;
                    case 5:
                        e(dVar2, dVar);
                        break;
                    case 6:
                        f(dVar2, dVar);
                        break;
                    case 7:
                        c(dVar2, dVar);
                        break;
                    case 8:
                        a(dVar2, dVar);
                        break;
                    case 9:
                        b(dVar2, dVar);
                        break;
                }
            }
        }
    }

    private final float d0(d dVar, FlexDirection flexDirection) {
        return E(dVar, flexDirection) + w(dVar, flexDirection) + F(dVar, flexDirection) + x(dVar, flexDirection);
    }

    private final void e(d dVar, d dVar2) {
        FlexDirection flexDirection = FlexDirection.ROW;
        float r16 = r(dVar2, flexDirection) - r(dVar, flexDirection);
        StyleSpace.Type type = StyleSpace.Type.LEFT;
        float E = r16 + dVar2.E(type) + dVar.z(type);
        StyleSpace.Type type2 = StyleSpace.Type.RIGHT;
        dVar.x0(((E - dVar2.E(type2)) - dVar.z(type2)) / 2.0f);
        FlexDirection flexDirection2 = FlexDirection.COLUMN;
        float r17 = r(dVar2, flexDirection2) - r(dVar, flexDirection2);
        StyleSpace.Type type3 = StyleSpace.Type.TOP;
        float E2 = r17 + dVar2.E(type3) + dVar.z(type3);
        StyleSpace.Type type4 = StyleSpace.Type.BOTTOM;
        dVar.y0(((E2 - dVar2.E(type4)) - dVar.z(type4)) / 2.0f);
    }

    private final boolean e0(d dVar, float f16, float f17, FlexDirection flexDirection, com.tencent.kuikly.core.layout.b bVar) {
        float B;
        com.tencent.kuikly.core.layout.g gVar;
        boolean P = P(dVar, flexDirection);
        if (S(dVar, flexDirection)) {
            B = dVar.U();
        } else if (P) {
            B = r(dVar, flexDirection);
        } else {
            B = f16 - B(dVar, flexDirection);
        }
        float f18 = B - f17;
        if ((Float.isNaN(f18) && !Float.isNaN(dVar.N())) || (!Float.isNaN(dVar.N()) && dVar.N() < f18)) {
            f18 = dVar.N();
        }
        if (f18 < 0.0f) {
            KLog.INSTANCE.e("LayoutImpl", "layout width < 0");
            f18 = 0.0f;
        }
        if (bVar == null || (gVar = bVar.getMeasureOutput()) == null) {
            gVar = new com.tencent.kuikly.core.layout.g();
        }
        com.tencent.kuikly.core.layout.g e06 = dVar.e0(gVar, f18);
        u0(dVar, e06.getWidth() + f17);
        q0(dVar, e06.getHeight() + d0(dVar, FlexDirection.COLUMN));
        return dVar.h() == 0;
    }

    private final void f(d dVar, d dVar2) {
        FlexDirection flexDirection = FlexDirection.ROW;
        float r16 = r(dVar2, flexDirection) - r(dVar, flexDirection);
        StyleSpace.Type type = StyleSpace.Type.RIGHT;
        dVar.x0(((r16 - dVar2.E(type)) - dVar2.E(StyleSpace.Type.LEFT)) - dVar.z(type));
        FlexDirection flexDirection2 = FlexDirection.COLUMN;
        float r17 = r(dVar2, flexDirection2) - r(dVar, flexDirection2);
        StyleSpace.Type type2 = StyleSpace.Type.TOP;
        float E = r17 + dVar2.E(type2) + dVar.z(type2);
        StyleSpace.Type type3 = StyleSpace.Type.BOTTOM;
        dVar.y0(((E - dVar2.E(type3)) - dVar.z(type3)) / 2.0f);
    }

    private final void f0(d dVar, d dVar2, com.tencent.kuikly.core.layout.b bVar, FlexLayoutDirection flexLayoutDirection, Set<d> set) {
        FlexDirection h06 = h0(dVar2.j(), flexLayoutDirection);
        FlexDirection q16 = q(dVar2.j(), flexLayoutDirection);
        float s16 = s(dVar2, h06);
        float s17 = s(dVar2, q16);
        if (!Float.isNaN(s16)) {
            r0(dVar2, h06, (s16 - C(dVar2, h06)) - v(dVar2, h06));
        }
        if (!Float.isNaN(s17)) {
            r0(dVar2, q16, (s17 - C(dVar2, q16)) - v(dVar2, q16));
        }
        W(dVar2, dVar.v(), bVar, flexLayoutDirection, false, set);
    }

    private final void g(d dVar, d dVar2) {
        StyleSpace.Type type = StyleSpace.Type.LEFT;
        dVar.x0(dVar2.E(type) + dVar.z(type));
        FlexDirection flexDirection = FlexDirection.COLUMN;
        float r16 = r(dVar2, flexDirection) - r(dVar, flexDirection);
        StyleSpace.Type type2 = StyleSpace.Type.TOP;
        float E = r16 + dVar2.E(type2) + dVar.z(type2);
        StyleSpace.Type type3 = StyleSpace.Type.BOTTOM;
        dVar.y0(((E - dVar2.E(type3)) - dVar.z(type3)) / 2.0f);
    }

    private final void g0(d dVar) {
        if (N(dVar)) {
            if (L(dVar.a1())) {
                dVar.S0(FlexLayout.PositionType.POSITION_LEFT, 0.0f);
                dVar.S0(FlexLayout.PositionType.POSITION_RIGHT, 0.0f);
            }
            if (L(dVar.Z0())) {
                dVar.S0(FlexLayout.PositionType.POSITION_TOP, 0.0f);
                dVar.S0(FlexLayout.PositionType.POSITION_BOTTOM, 0.0f);
            }
        }
    }

    private final void h(d dVar, FlexDirection flexDirection, float f16, float f17) {
        float f18;
        float r16 = r(dVar, flexDirection);
        int h16 = dVar.h();
        float f19 = 0.0f;
        int i3 = 0;
        while (true) {
            if (i3 >= h16) {
                break;
            }
            FlexNode g16 = dVar.g(i3);
            d dVar2 = g16 instanceof d ? (d) g16 : null;
            if (dVar2 != null) {
                f19 += r(dVar2, flexDirection) + B(dVar2, flexDirection);
            }
            i3++;
        }
        float f26 = r16 - f19;
        int i16 = a.f339276a[dVar.m().ordinal()];
        if (i16 != 1) {
            if (i16 != 2) {
                if (i16 == 3) {
                    f18 = f16 + 0.0f;
                    r2 = f26 / (dVar.h() - 1);
                } else if (i16 != 4) {
                    r2 = i16 == 5 ? f26 / (dVar.h() + 1) : 0.0f;
                    f18 = f16 + r2;
                } else {
                    r2 = f26 / dVar.h();
                    f18 = f16 + (r2 / 2);
                }
            }
            f18 = f16 + f26;
        } else {
            f26 /= 2;
            if (f17 < r16) {
                f18 = (f26 + f16) - f16;
            }
            f18 = f16 + f26;
        }
        for (int i17 = 0; i17 < h16; i17++) {
            FlexNode g17 = dVar.g(i17);
            d dVar3 = g17 instanceof d ? (d) g17 : null;
            if (dVar3 != null) {
                s0(dVar3, flexDirection, B(dVar3, flexDirection) + f18);
                if (O(dVar3)) {
                    f18 += r(dVar3, flexDirection) + r2 + B(dVar3, flexDirection);
                }
            }
        }
    }

    private final FlexDirection h0(FlexDirection axis, FlexLayoutDirection direction) {
        if (direction != FlexLayoutDirection.RTL) {
            return axis;
        }
        int i3 = a.f339281f[axis.ordinal()];
        if (i3 != 1) {
            return i3 != 2 ? axis : FlexDirection.ROW;
        }
        return FlexDirection.ROW_REVERSE;
    }

    private final void i(d dVar, d dVar2) {
        FlexDirection flexDirection = FlexDirection.ROW;
        float r16 = r(dVar2, flexDirection);
        StyleSpace.Type type = StyleSpace.Type.LEFT;
        float E = r16 + dVar2.E(type) + dVar.z(type);
        StyleSpace.Type type2 = StyleSpace.Type.RIGHT;
        dVar.x0((((E - dVar2.E(type2)) - dVar.z(type2)) - r(dVar, flexDirection)) / 2.0f);
        StyleSpace.Type type3 = StyleSpace.Type.TOP;
        dVar.y0(dVar2.E(type3) + dVar.z(type3));
    }

    private final void i0(d dVar) {
        if (J(dVar)) {
            dVar.h();
        }
    }

    private final void j(d dVar, d dVar2) {
        FlexDirection flexDirection = FlexDirection.ROW;
        float r16 = r(dVar2, flexDirection) - r(dVar, flexDirection);
        StyleSpace.Type type = StyleSpace.Type.RIGHT;
        dVar.x0((r16 - dVar2.E(type)) - dVar2.E(StyleSpace.Type.LEFT));
        dVar.z(type);
        StyleSpace.Type type2 = StyleSpace.Type.TOP;
        dVar.y0(dVar2.E(type2) + dVar.z(type2));
    }

    /* JADX WARN: Code restructure failed: missing block: B:52:0x0114, code lost:
    
        if ((r0 != null ? r0.getMainAxis() : null) == com.tencent.kuikly.core.layout.FlexDirection.ROW_REVERSE) goto L56;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final void j0(d dVar) {
        f a16 = dVar.a1();
        Float valueOf = a16 != null ? Float.valueOf(a16.getValue()) : null;
        f.Companion companion = f.INSTANCE;
        if (!Intrinsics.areEqual(valueOf, companion.c().getValue())) {
            f Z0 = dVar.Z0();
            if (!Intrinsics.areEqual(Z0 != null ? Float.valueOf(Z0.getValue()) : null, companion.c().getValue())) {
                return;
            }
        }
        int h16 = dVar.h();
        float E = dVar.E(StyleSpace.Type.LEFT) + dVar.E(StyleSpace.Type.RIGHT);
        float E2 = dVar.E(StyleSpace.Type.TOP) + dVar.E(StyleSpace.Type.BOTTOM);
        f a17 = dVar.a1();
        boolean areEqual = Intrinsics.areEqual(a17 != null ? Float.valueOf(a17.getValue()) : null, companion.c().getValue());
        f Z02 = dVar.Z0();
        boolean areEqual2 = Intrinsics.areEqual(Z02 != null ? Float.valueOf(Z02.getValue()) : null, companion.c().getValue());
        boolean z16 = false;
        float f16 = E;
        float f17 = E2;
        for (int i3 = 0; i3 < h16; i3++) {
            FlexNode g16 = dVar.g(i3);
            d dVar2 = g16 instanceof d ? (d) g16 : null;
            if (dVar2 != null && !Q(dVar2, dVar)) {
                if (areEqual) {
                    f16 = Math.max(f16, dVar2.z(StyleSpace.Type.LEFT) + dVar2.z(StyleSpace.Type.RIGHT) + E + dVar2.v());
                }
                if (areEqual2) {
                    f17 = Math.max(f17, dVar2.z(StyleSpace.Type.TOP) + dVar2.z(StyleSpace.Type.BOTTOM) + E2 + dVar2.t());
                }
            }
        }
        Object f18 = dVar.f1();
        c cVar = f18 instanceof c ? (c) f18 : null;
        boolean z17 = dVar.i() > 0.0f;
        FlexDirection mainAxis = cVar != null ? cVar.getMainAxis() : null;
        FlexDirection flexDirection = FlexDirection.ROW;
        if (mainAxis != flexDirection) {
        }
        z16 = true;
        if (areEqual && (!z17 || !z16)) {
            p0(dVar, flexDirection, l(dVar, flexDirection, f16));
        }
        if (areEqual2) {
            if (!z17 || z16) {
                FlexDirection flexDirection2 = FlexDirection.COLUMN;
                p0(dVar, flexDirection2, l(dVar, flexDirection2, f17));
            }
        }
    }

    private final void k(d dVar, d dVar2) {
        StyleSpace.Type type = StyleSpace.Type.LEFT;
        dVar.x0(dVar2.E(type) + dVar.z(type));
        StyleSpace.Type type2 = StyleSpace.Type.TOP;
        dVar.y0(dVar2.E(type2) + dVar.z(type2));
    }

    private final FlexLayoutDirection k0(d dVar, FlexLayoutDirection flexLayoutDirection) {
        FlexLayoutDirection J = dVar.J();
        if (J != FlexLayoutDirection.INHERIT) {
            return J;
        }
        if (flexLayoutDirection == null) {
            flexLayoutDirection = FlexLayoutDirection.LTR;
        }
        return flexLayoutDirection;
    }

    private final float l(d dVar, FlexDirection flexDirection, float f16) {
        float O;
        float M;
        FloatCompanionObject floatCompanionObject = FloatCompanionObject.INSTANCE;
        if (flexDirection != FlexDirection.COLUMN && flexDirection != FlexDirection.COLUMN_REVERSE) {
            if (flexDirection == FlexDirection.ROW || flexDirection == FlexDirection.ROW_REVERSE) {
                O = dVar.P();
                M = dVar.N();
            } else {
                M = Float.NaN;
                O = Float.NaN;
            }
        } else {
            O = dVar.O();
            M = dVar.M();
        }
        if (!Float.isNaN(M) && M >= 0.0d && f16 > M) {
            f16 = M;
        }
        return (Float.isNaN(O) || ((double) O) < 0.0d || O <= f16) ? f16 : O;
    }

    private final void l0(d dVar) {
        FlexJustifyContent flexJustifyContent;
        FlexAlign flexAlign;
        if (dVar.j() != FlexDirection.COLUMN || dVar.d1() == null || dVar.c1() == null) {
            return;
        }
        a.k d16 = dVar.d1();
        com.tencent.ntcompose.foundation.layout.base.a aVar = com.tencent.ntcompose.foundation.layout.base.a.f339245a;
        if (Intrinsics.areEqual(d16, aVar.h())) {
            flexJustifyContent = FlexJustifyContent.FLEX_START;
        } else if (Intrinsics.areEqual(d16, aVar.a())) {
            flexJustifyContent = FlexJustifyContent.FLEX_END;
        } else if (Intrinsics.areEqual(d16, aVar.b())) {
            flexJustifyContent = FlexJustifyContent.CENTER;
        } else if (Intrinsics.areEqual(d16, aVar.e())) {
            flexJustifyContent = FlexJustifyContent.SPACE_BETWEEN;
        } else if (Intrinsics.areEqual(d16, aVar.d())) {
            flexJustifyContent = FlexJustifyContent.SPACE_AROUND;
        } else if (Intrinsics.areEqual(d16, aVar.f())) {
            flexJustifyContent = FlexJustifyContent.SPACE_EVENLY;
        } else {
            flexJustifyContent = FlexJustifyContent.FLEX_START;
        }
        dVar.q0(flexJustifyContent);
        Alignment.Horizontal c16 = dVar.c1();
        int i3 = c16 == null ? -1 : a.f339278c[c16.ordinal()];
        if (i3 == 1) {
            flexAlign = FlexAlign.FLEX_START;
        } else if (i3 == 2) {
            flexAlign = FlexAlign.FLEX_END;
        } else if (i3 != 3) {
            flexAlign = FlexAlign.STRETCH;
        } else {
            flexAlign = FlexAlign.CENTER;
        }
        dVar.k0(flexAlign);
        if (dVar.l() == FlexWrap.WRAP) {
            dVar.j0(dVar.e());
        }
    }

    private final boolean m(d dVar, float f16, float f17, FlexDirection flexDirection) {
        if (!Float.isNaN(f16) && !Float.isNaN(f17)) {
            if (!(f16 == f17)) {
                if (flexDirection == dVar.j()) {
                    if (dVar.m() != FlexJustifyContent.FLEX_START && !S(dVar, flexDirection)) {
                        return true;
                    }
                } else if (((dVar.e() != FlexAlign.FLEX_START && dVar.e() != FlexAlign.STRETCH) || I(dVar)) && !S(dVar, flexDirection)) {
                    return true;
                }
            }
        }
        return false;
    }

    private final void m0(d dVar) {
        FlexJustifyContent flexJustifyContent;
        FlexAlign flexAlign;
        if ((dVar.j() != FlexDirection.ROW_REVERSE && dVar.j() != FlexDirection.ROW) || dVar.g1() == null || dVar.h1() == null) {
            return;
        }
        a.d g16 = dVar.g1();
        com.tencent.ntcompose.foundation.layout.base.a aVar = com.tencent.ntcompose.foundation.layout.base.a.f339245a;
        if (Intrinsics.areEqual(g16, aVar.g())) {
            flexJustifyContent = FlexJustifyContent.FLEX_START;
        } else if (Intrinsics.areEqual(g16, aVar.c())) {
            flexJustifyContent = FlexJustifyContent.FLEX_END;
        } else if (Intrinsics.areEqual(g16, aVar.b())) {
            flexJustifyContent = FlexJustifyContent.CENTER;
        } else if (Intrinsics.areEqual(g16, aVar.e())) {
            flexJustifyContent = FlexJustifyContent.SPACE_BETWEEN;
        } else if (Intrinsics.areEqual(g16, aVar.d())) {
            flexJustifyContent = FlexJustifyContent.SPACE_AROUND;
        } else if (Intrinsics.areEqual(g16, aVar.f())) {
            flexJustifyContent = FlexJustifyContent.SPACE_EVENLY;
        } else {
            flexJustifyContent = FlexJustifyContent.FLEX_START;
        }
        dVar.q0(flexJustifyContent);
        Alignment.Vertical h16 = dVar.h1();
        int i3 = h16 == null ? -1 : a.f339279d[h16.ordinal()];
        if (i3 == 1) {
            flexAlign = FlexAlign.FLEX_START;
        } else if (i3 == 2) {
            flexAlign = FlexAlign.FLEX_END;
        } else if (i3 != 3) {
            flexAlign = FlexAlign.STRETCH;
        } else {
            flexAlign = FlexAlign.CENTER;
        }
        dVar.k0(flexAlign);
        if (dVar.l() == FlexWrap.WRAP) {
            dVar.j0(dVar.e());
        }
    }

    private final f n(d dVar, FlexDirection flexDirection) {
        if (flexDirection != FlexDirection.ROW && flexDirection != FlexDirection.ROW_REVERSE) {
            return dVar.Z0();
        }
        return dVar.a1();
    }

    private final void n0(d dVar, FlexDirection flexDirection) {
        if (dVar.a1() == null && dVar.Z0() == null) {
            return;
        }
        f a16 = dVar.a1();
        Float valueOf = a16 != null ? Float.valueOf(a16.getValue()) : null;
        if (valueOf != null && Intrinsics.areEqual(valueOf, f.INSTANCE.c().getValue()) && flexDirection != FlexDirection.ROW && flexDirection != FlexDirection.ROW_REVERSE && dVar.e() == FlexAlign.STRETCH) {
            dVar.k0(FlexAlign.FLEX_START);
        }
        f Z0 = dVar.Z0();
        Float valueOf2 = Z0 != null ? Float.valueOf(Z0.getValue()) : null;
        if (valueOf2 == null || !Intrinsics.areEqual(valueOf2, f.INSTANCE.c().getValue()) || flexDirection == FlexDirection.COLUMN || flexDirection == FlexDirection.COLUMN_REVERSE || dVar.e() != FlexAlign.STRETCH) {
            return;
        }
        dVar.k0(FlexAlign.FLEX_START);
    }

    private final FlexAlign o(d dVar, d dVar2) {
        Object f16 = dVar2.f1();
        if (f16 instanceof Alignment.Vertical) {
            int i3 = a.f339279d[((Alignment.Vertical) f16).ordinal()];
            if (i3 == 1) {
                return FlexAlign.FLEX_START;
            }
            if (i3 == 2) {
                return FlexAlign.FLEX_END;
            }
            if (i3 == 3) {
                return FlexAlign.CENTER;
            }
            throw new NoWhenBranchMatchedException();
        }
        if (f16 instanceof Alignment.Horizontal) {
            int i16 = a.f339278c[((Alignment.Horizontal) f16).ordinal()];
            if (i16 == 1) {
                return FlexAlign.FLEX_START;
            }
            if (i16 == 2) {
                return FlexAlign.FLEX_END;
            }
            if (i16 == 3) {
                return FlexAlign.CENTER;
            }
            throw new NoWhenBranchMatchedException();
        }
        if (dVar2.f() != FlexAlign.AUTO) {
            return dVar2.f();
        }
        return dVar.e();
    }

    private final void o0(d dVar, FlexDirection flexDirection) {
        if (P(dVar, flexDirection)) {
            return;
        }
        if (flexDirection != FlexDirection.COLUMN && flexDirection != FlexDirection.COLUMN_REVERSE) {
            if ((Float.isNaN(y(dVar, flexDirection)) && Float.isNaN(dVar.P()) && Float.isNaN(dVar.N())) || y(dVar, flexDirection) < 0.0f) {
                return;
            }
        } else if ((Float.isNaN(dVar.O()) && Float.isNaN(dVar.M()) && Float.isNaN(y(dVar, flexDirection))) || y(dVar, flexDirection) < 0.0f) {
            return;
        }
        p0(dVar, flexDirection, Math.max(l(dVar, flexDirection, y(dVar, flexDirection)), d0(dVar, flexDirection)));
    }

    private final Alignment p(d dVar, int i3) {
        FlexNode g16 = dVar.g(i3);
        d dVar2 = g16 instanceof d ? (d) g16 : null;
        Object f16 = dVar2 != null ? dVar2.f1() : null;
        c cVar = f16 instanceof c ? (c) f16 : null;
        Alignment alignment = cVar != null ? cVar.getAlignment() : null;
        if (alignment != null) {
            return alignment;
        }
        Alignment b16 = dVar.b1();
        return b16 == null ? Alignment.TopStart : b16;
    }

    private final void p0(d dVar, FlexDirection flexDirection, float f16) {
        dVar.q()[dim[flexDirection.ordinal()]] = f16;
    }

    private final FlexDirection q(FlexDirection axis, FlexLayoutDirection direction) {
        FlexDirection flexDirection = FlexDirection.COLUMN;
        return (axis == flexDirection || axis == FlexDirection.COLUMN_REVERSE) ? h0(FlexDirection.ROW, direction) : flexDirection;
    }

    private final void q0(d dVar, float f16) {
        dVar.v0(f16);
    }

    private final float r(d dVar, FlexDirection flexDirection) {
        return dVar.q()[dim[flexDirection.ordinal()]];
    }

    private final void r0(d dVar, FlexDirection flexDirection, float f16) {
        dVar.u()[leading[flexDirection.ordinal()].ordinal()] = f16;
    }

    private final float s(d dVar, FlexDirection flexDirection) {
        return dVar.u()[leading[flexDirection.ordinal()].ordinal()];
    }

    private final void s0(d dVar, FlexDirection flexDirection, float f16) {
        dVar.u()[pos[flexDirection.ordinal()]] = f16;
    }

    private final float t(d dVar, FlexDirection flexDirection) {
        return dVar.u()[pos[flexDirection.ordinal()]];
    }

    private final void t0(d dVar, FlexDirection flexDirection, float f16) {
        dVar.u()[trailing[flexDirection.ordinal()].ordinal()] = f16;
    }

    private final float u(d dVar, FlexDirection flexDirection) {
        return dVar.u()[trailing[flexDirection.ordinal()].ordinal()];
    }

    private final void u0(d dVar, float f16) {
        dVar.w0(f16);
    }

    private final float v(d dVar, FlexDirection flexDirection) {
        float f16 = dVar.T()[leading[flexDirection.ordinal()].ordinal()];
        if (!Float.isNaN(f16)) {
            return f16;
        }
        float f17 = dVar.T()[trailing[flexDirection.ordinal()].ordinal()];
        if (Float.isNaN(f17)) {
            return 0.0f;
        }
        return -f17;
    }

    private final StyleSpace.Type v0(FlexDirection direction) {
        return trailingSpacing[direction.ordinal()];
    }

    private final float w(d dVar, FlexDirection flexDirection) {
        return dVar.H(Z(flexDirection), a0(flexDirection));
    }

    private final StyleSpace.Type w0(FlexDirection direction) {
        return trailing[direction.ordinal()];
    }

    private final float x(d dVar, FlexDirection flexDirection) {
        return dVar.H(v0(flexDirection), w0(flexDirection));
    }

    private final f x0(d dVar, FlexDirection flexDirection) {
        if (flexDirection != FlexDirection.ROW && flexDirection != FlexDirection.ROW_REVERSE) {
            return dVar.Z0();
        }
        return dVar.a1();
    }

    private final float y(d dVar, FlexDirection flexDirection) {
        return dVar.I()[dim[flexDirection.ordinal()]];
    }

    private final float z(d dVar, FlexDirection flexDirection) {
        return dVar.T()[leading[flexDirection.ordinal()].ordinal()];
    }

    public final void W(d node, float parentMaxWidth, com.tencent.kuikly.core.layout.b layoutContext, FlexLayoutDirection parentDirection, boolean needLayoutAbsoluteChild, Set<d> dirtyList) {
        Intrinsics.checkNotNullParameter(node, "node");
        Intrinsics.checkNotNullParameter(dirtyList, "dirtyList");
        if (b0(node, parentMaxWidth)) {
            node.s0(node.v());
            node.r0(node.t());
            node.t0(parentMaxWidth);
            Y(node, parentMaxWidth, layoutContext, parentDirection, dirtyList, needLayoutAbsoluteChild);
            dirtyList.add(node);
            return;
        }
        node.Y0();
        node.d0();
    }

    private final boolean L(f atMostSize) {
        return (atMostSize == null || Intrinsics.areEqual(atMostSize, f.INSTANCE.c())) ? false : true;
    }
}

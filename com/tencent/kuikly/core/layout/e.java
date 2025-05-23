package com.tencent.kuikly.core.layout;

import androidx.exifinterface.media.ExifInterface;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.kuikly.core.layout.FlexLayout;
import com.tencent.kuikly.core.layout.StyleSpace;
import com.tencent.kuikly.core.log.KLog;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import cooperation.qzone.remote.logic.RemoteHandleConst;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.FloatCompanionObject;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010#\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b#\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0015\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\b\t\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b^\u0010_JF\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\b2\b\b\u0002\u0010\u000b\u001a\u00020\n2\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00020\fJF\u0010\u0010\u001a\u00020\u000e2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\b2\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00020\f2\u0006\u0010\u000b\u001a\u00020\nH\u0002J4\u0010\u0013\u001a\u00020\u000e*\u00020\u00022\u0006\u0010\u0011\u001a\u00020\u00022\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0012\u001a\u00020\b2\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00020\fH\u0002J$\u0010\u0018\u001a\u00020\n*\u00020\u00022\u0006\u0010\u0014\u001a\u00020\u00042\u0006\u0010\u0015\u001a\u00020\u00042\u0006\u0010\u0017\u001a\u00020\u0016H\u0002J\f\u0010\u0019\u001a\u00020\n*\u00020\u0002H\u0002J\u001c\u0010\u001c\u001a\u00020\u000e*\u00020\u00022\u0006\u0010\u001a\u001a\u00020\u00162\u0006\u0010\u001b\u001a\u00020\u0004H\u0002J\u0018\u0010\u001d\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\f\u0010\u001e\u001a\u00020\n*\u00020\u0002H\u0002J\f\u0010\u001f\u001a\u00020\n*\u00020\u0002H\u0002J\u0016\u0010 \u001a\u00020\b*\u00020\u00022\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0002J\u0018\u0010\"\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00162\u0006\u0010!\u001a\u00020\bH\u0002J\u0018\u0010#\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00162\u0006\u0010!\u001a\u00020\bH\u0002J\u0014\u0010$\u001a\u00020\u000e*\u00020\u00022\u0006\u0010\u0017\u001a\u00020\u0016H\u0002J\u001c\u0010&\u001a\u00020\u0004*\u00020\u00022\u0006\u0010\u0017\u001a\u00020\u00162\u0006\u0010%\u001a\u00020\u0004H\u0002J\u0014\u0010'\u001a\u00020\u0004*\u00020\u00022\u0006\u0010\u0017\u001a\u00020\u0016H\u0002J\f\u0010(\u001a\u00020\n*\u00020\u0002H\u0002J\u0014\u0010)\u001a\u00020\u0004*\u00020\u00022\u0006\u0010!\u001a\u00020\u0016H\u0002J\u001c\u0010*\u001a\u00020\u000e*\u00020\u00022\u0006\u0010!\u001a\u00020\u00162\u0006\u0010%\u001a\u00020\u0004H\u0002J\u0014\u0010,\u001a\u00020\u000e*\u00020\u00022\u0006\u0010+\u001a\u00020\u0004H\u0002J\u0014\u0010.\u001a\u00020\u000e*\u00020\u00022\u0006\u0010-\u001a\u00020\u0004H\u0002J\u0014\u0010/\u001a\u00020\u0004*\u00020\u00022\u0006\u0010!\u001a\u00020\u0016H\u0002J\u0014\u00100\u001a\u00020\u0004*\u00020\u00022\u0006\u0010!\u001a\u00020\u0016H\u0002J\u0014\u00101\u001a\u00020\u0004*\u00020\u00022\u0006\u0010!\u001a\u00020\u0016H\u0002J\u0014\u00102\u001a\u00020\u0004*\u00020\u00022\u0006\u0010!\u001a\u00020\u0016H\u0002J\u0014\u00103\u001a\u00020\u0004*\u00020\u00022\u0006\u0010!\u001a\u00020\u0016H\u0002J\u0014\u00104\u001a\u00020\u0004*\u00020\u00022\u0006\u0010!\u001a\u00020\u0016H\u0002J\u0014\u00105\u001a\u00020\u0004*\u00020\u00022\u0006\u0010!\u001a\u00020\u0016H\u0002J\u0014\u00106\u001a\u00020\u0004*\u00020\u00022\u0006\u0010!\u001a\u00020\u0016H\u0002J\u0014\u00107\u001a\u00020\n*\u00020\u00022\u0006\u0010!\u001a\u00020\u0016H\u0002J\u0014\u00108\u001a\u00020\n*\u00020\u00022\u0006\u0010!\u001a\u00020\u0016H\u0002J\u0014\u0010;\u001a\u00020:*\u00020\u00022\u0006\u00109\u001a\u00020\u0002H\u0002J\u001c\u0010<\u001a\u00020\u000e*\u00020\u00022\u0006\u0010!\u001a\u00020\u00162\u0006\u0010%\u001a\u00020\u0004H\u0002J\u001c\u0010=\u001a\u00020\u000e*\u00020\u00022\u0006\u0010!\u001a\u00020\u00162\u0006\u0010%\u001a\u00020\u0004H\u0002J\u001c\u0010>\u001a\u00020\u000e*\u00020\u00022\u0006\u0010!\u001a\u00020\u00162\u0006\u0010%\u001a\u00020\u0004H\u0002J\u0014\u0010?\u001a\u00020\u0004*\u00020\u00022\u0006\u0010!\u001a\u00020\u0016H\u0002J\u0014\u0010@\u001a\u00020\u0004*\u00020\u00022\u0006\u0010!\u001a\u00020\u0016H\u0002J\u0014\u0010A\u001a\u00020\u0004*\u00020\u00022\u0006\u0010!\u001a\u00020\u0016H\u0002J\u0014\u0010B\u001a\u00020\u0004*\u00020\u00022\u0006\u0010!\u001a\u00020\u0016H\u0002J\u0014\u0010C\u001a\u00020\u0004*\u00020\u00022\u0006\u0010!\u001a\u00020\u0016H\u0002J\u0014\u0010D\u001a\u00020\n*\u00020\u00022\u0006\u0010!\u001a\u00020\u0016H\u0002J\u001c\u0010F\u001a\u00020\u0004*\u00020\u00022\u0006\u0010!\u001a\u00020\u00162\u0006\u0010E\u001a\u00020\u0004H\u0002J\u0014\u0010G\u001a\u00020\u0004*\u00020\u00022\u0006\u0010!\u001a\u00020\u0016H\u0002J\u0014\u0010H\u001a\u00020\n*\u00020\u00022\u0006\u0010!\u001a\u00020\u0016H\u0002J\u001c\u0010I\u001a\u00020\u0004*\u00020\u00022\u0006\u0010!\u001a\u00020\u00162\u0006\u0010E\u001a\u00020\u0004H\u0002J\f\u0010J\u001a\u00020\n*\u00020\u0002H\u0002J\u0014\u0010K\u001a\u00020\u0004*\u00020\u00022\u0006\u0010!\u001a\u00020\u0016H\u0002J\u0010\u0010M\u001a\u00020L2\u0006\u0010!\u001a\u00020\u0016H\u0002J\u0010\u0010N\u001a\u00020L2\u0006\u0010!\u001a\u00020\u0016H\u0002J\u0010\u0010O\u001a\u00020L2\u0006\u0010!\u001a\u00020\u0016H\u0002J\u0010\u0010P\u001a\u00020L2\u0006\u0010!\u001a\u00020\u0016H\u0002J.\u0010S\u001a\u00020\n*\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010Q\u001a\u00020\u00042\u0006\u0010R\u001a\u00020\u00162\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0002R\u0014\u0010V\u001a\u00020T8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b&\u0010UR\u001a\u0010Y\u001a\b\u0012\u0004\u0012\u00020L0W8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0018\u0010XR\u001a\u0010Z\u001a\b\u0012\u0004\u0012\u00020L0W8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b;\u0010XR\u001a\u0010[\u001a\b\u0012\u0004\u0012\u00020L0W8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b#\u0010XR\u001a\u0010\\\u001a\b\u0012\u0004\u0012\u00020L0W8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b)\u0010XR\u0014\u0010]\u001a\u00020T8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b@\u0010U\u00a8\u0006`"}, d2 = {"Lcom/tencent/kuikly/core/layout/e;", "", "Lcom/tencent/kuikly/core/layout/FlexNode;", "node", "", "parentMaxWidth", "Lcom/tencent/kuikly/core/layout/b;", "layoutContext", "Lcom/tencent/kuikly/core/layout/FlexLayoutDirection;", "parentDirection", "", "needLayoutAbsoluteChild", "", "dirtyList", "", UserInfo.SEX_FEMALE, "H", "absoluteChild", NodeProps.FLEX_DIRECTION, "O", "oldDim", "newDim", "Lcom/tencent/kuikly/core/layout/FlexDirection;", "axis", "c", "w", "mainAxis", "paddingAndBorderAxisMain", "a", "K", QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, "y", AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, "direction", "P", "e", BdhLogUtil.LogTag.Tag_Req, "value", "b", "j", "B", "f", ExifInterface.LATITUDE_SOUTH, "width", "X", "height", "T", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "l", "k", "t", ReportConstant.COSTREPORT_PREFIX, "r", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "p", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, BdhLogUtil.LogTag.Tag_Conn, "child", "Lcom/tencent/kuikly/core/layout/FlexAlign;", "d", "V", "U", "W", tl.h.F, "g", "i", "M", "L", "D", RemoteHandleConst.PARAM_DEFAULT_VALUE, "o", DomainData.DOMAIN_NAME, "E", "v", HippyTKDListViewAdapter.X, "u", "Lcom/tencent/kuikly/core/layout/StyleSpace$Type;", "Y", "Z", "I", "J", "paddingAndBorderAxisResolvedRow", "resolvedRowAxis", "N", "", "[I", "dim", "", "[Lcom/tencent/kuikly/core/layout/StyleSpace$Type;", "leading", "leadingSpacing", "trailingSpacing", "trailing", com.tencent.luggage.wxa.c8.c.G, "<init>", "()V", "core_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes33.dex */
public final class e {

    /* renamed from: a, reason: collision with root package name */
    public static final e f117328a = new e();

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
    /* loaded from: classes33.dex */
    public /* synthetic */ class a {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f117335a;

        /* renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ int[] f117336b;

        /* renamed from: c, reason: collision with root package name */
        public static final /* synthetic */ int[] f117337c;

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
            f117335a = iArr;
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
            f117336b = iArr2;
            int[] iArr3 = new int[FlexDirection.values().length];
            try {
                iArr3[FlexDirection.ROW.ordinal()] = 1;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                iArr3[FlexDirection.ROW_REVERSE.ordinal()] = 2;
            } catch (NoSuchFieldError unused11) {
            }
            f117337c = iArr3;
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

    e() {
    }

    private final boolean A(FlexNode flexNode, FlexDirection flexDirection) {
        return !Float.isNaN(flexNode.q()[dim[flexDirection.ordinal()]]);
    }

    private final boolean B(FlexNode flexNode) {
        return flexNode.getMeasureFunction() != null;
    }

    private final boolean C(FlexNode flexNode, FlexDirection flexDirection) {
        float m3 = m(flexNode, flexDirection);
        return !Float.isNaN(m3) && m3 >= 0.0f;
    }

    private final boolean D(FlexNode flexNode, FlexDirection flexDirection) {
        return !Float.isNaN(n(flexNode, flexDirection));
    }

    private final boolean E(FlexNode flexNode, FlexDirection flexDirection) {
        return !Float.isNaN(u(flexNode, flexDirection));
    }

    /* JADX WARN: Removed duplicated region for block: B:118:0x04c8  */
    /* JADX WARN: Removed duplicated region for block: B:144:0x0548  */
    /* JADX WARN: Removed duplicated region for block: B:147:0x0558  */
    /* JADX WARN: Removed duplicated region for block: B:170:0x05fe  */
    /* JADX WARN: Removed duplicated region for block: B:173:0x0614 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:235:0x0312  */
    /* JADX WARN: Removed duplicated region for block: B:240:0x0351  */
    /* JADX WARN: Removed duplicated region for block: B:245:0x034d  */
    /* JADX WARN: Removed duplicated region for block: B:249:0x025c  */
    /* JADX WARN: Removed duplicated region for block: B:254:0x0274  */
    /* JADX WARN: Removed duplicated region for block: B:257:0x02aa  */
    /* JADX WARN: Removed duplicated region for block: B:259:0x02b7  */
    /* JADX WARN: Removed duplicated region for block: B:260:0x0295  */
    /* JADX WARN: Removed duplicated region for block: B:262:0x0270  */
    /* JADX WARN: Removed duplicated region for block: B:309:0x0674  */
    /* JADX WARN: Removed duplicated region for block: B:387:0x0787  */
    /* JADX WARN: Removed duplicated region for block: B:393:0x07a2 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:397:0x07e2  */
    /* JADX WARN: Removed duplicated region for block: B:436:0x089e A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:440:0x07a8  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final void H(FlexNode node, float parentMaxWidth, b layoutContext, FlexLayoutDirection parentDirection, Set<FlexNode> dirtyList, boolean needLayoutAbsoluteChild) {
        boolean z16;
        boolean z17;
        int i3;
        FlexNode flexNode;
        FlexNode flexNode2;
        FlexDirection flexDirection;
        float f16;
        int i16;
        int i17;
        int i18;
        int i19;
        float f17;
        float f18;
        int i26;
        float f19;
        FlexJustifyContent flexJustifyContent;
        float f26;
        float f27;
        float f28;
        FlexJustifyContent flexJustifyContent2;
        float f29;
        int i27;
        int i28;
        int i29;
        float f36;
        FlexJustifyContent flexJustifyContent3;
        float f37;
        FlexNode flexNode3;
        float f38;
        float p16;
        int i36;
        int i37;
        int i38;
        float f39;
        FlexNode flexNode4;
        FlexDirection flexDirection2;
        float f46;
        float f47;
        FlexNode flexNode5;
        float f48;
        float p17;
        for (int h16 = node.h() - 1; -1 < h16; h16--) {
            FlexNode g16 = node.g(h16);
            if (g16 != null) {
                g16.i0();
                Unit unit = Unit.INSTANCE;
            }
        }
        if (!node.getIsShow()) {
            return;
        }
        FlexLayoutDirection Q = Q(node, parentDirection);
        FlexDirection P = P(node.j(), Q);
        FlexDirection e16 = e(P, Q);
        FlexDirection flexDirection3 = FlexDirection.ROW;
        FlexDirection P2 = P(flexDirection3, Q);
        R(node, P);
        R(node, e16);
        node.o0(Q);
        U(node, P, g(node, P) + q(node, P) + j(node, P));
        W(node, P, i(node, P) + r(node, P) + j(node, P));
        U(node, e16, g(node, e16) + q(node, e16) + j(node, e16));
        W(node, e16, i(node, e16) + r(node, e16) + j(node, e16));
        int h17 = node.h();
        float M = M(node, P2);
        if (B(node) && N(node, parentMaxWidth, M, P2, layoutContext)) {
            return;
        }
        boolean z18 = node.l() == FlexWrap.WRAP;
        FlexJustifyContent m3 = node.m();
        float s16 = s(node, P) + k(node, P);
        float s17 = s(node, e16) + k(node, e16);
        float M2 = M(node, P);
        float M3 = M(node, e16);
        boolean A = A(node, P);
        boolean A2 = A(node, e16);
        boolean z19 = P == flexDirection3 || P == FlexDirection.ROW_REVERSE;
        FloatCompanionObject floatCompanionObject = FloatCompanionObject.INSTANCE;
        float f49 = A ? f(node, P) - M2 : Float.NaN;
        int i39 = 0;
        int i46 = 0;
        int i47 = 0;
        int i48 = 0;
        boolean z26 = false;
        float f56 = 0.0f;
        float f57 = 0.0f;
        FlexNode flexNode6 = null;
        FlexNode flexNode7 = null;
        FlexNode flexNode8 = null;
        FlexNode flexNode9 = null;
        while (true) {
            int i49 = i47;
            if (i39 >= h17) {
                break;
            }
            boolean z27 = (A && m3 == FlexJustifyContent.FLEX_START) || !(A || m3 == FlexJustifyContent.CENTER);
            FlexJustifyContent flexJustifyContent4 = m3;
            int i56 = h17;
            int i57 = 0;
            int i58 = 0;
            float f58 = s16;
            FlexNode flexNode10 = flexNode7;
            int i59 = i49;
            int i65 = z27 ? h17 : i49;
            FlexNode flexNode11 = null;
            float f59 = 0.0f;
            FlexNode flexNode12 = null;
            float f65 = 0.0f;
            float f66 = 0.0f;
            int i66 = i48;
            boolean z28 = true;
            boolean z29 = z27;
            int i67 = i39;
            FlexNode flexNode13 = flexNode6;
            boolean z36 = z29;
            while (true) {
                if (i59 >= h17) {
                    i18 = i46;
                    i19 = i67;
                    f17 = M3;
                    f18 = M2;
                    i26 = h17;
                    f19 = M;
                    flexJustifyContent = flexJustifyContent4;
                    f26 = f65;
                    f27 = f66;
                    f28 = 0.0f;
                    flexNode6 = flexNode13;
                    i48 = i66;
                    flexNode7 = flexNode10;
                    break;
                }
                i26 = h17;
                FlexNode g17 = node.g(i59);
                if (g17 == null) {
                    i18 = i46;
                    f17 = M3;
                    f18 = M2;
                    i36 = i59;
                    f19 = M;
                    i37 = i49;
                    flexJustifyContent = flexJustifyContent4;
                    i67 = i36 + 1;
                } else if (g17.getIsShow()) {
                    g17.z0(i46);
                    int i68 = i59;
                    g17.C0(null);
                    g17.D0(null);
                    FlexAlign d16 = d(node, g17);
                    int i69 = i46;
                    if (d16 == FlexAlign.STRETCH && z(g17) && A2 && !C(g17, e16)) {
                        i38 = i67;
                        S(g17, e16, Math.max(b(g17, e16, (f(node, e16) - M3) - p(g17, e16)), M(g17, e16)));
                    } else {
                        i38 = i67;
                        if (y(g17)) {
                            if (flexNode13 == null) {
                                flexNode13 = g17;
                            }
                            if (flexNode10 != null) {
                                flexNode10.C0(g17);
                            }
                            int i75 = 0;
                            while (i75 < 2) {
                                if (i75 != 0) {
                                    flexDirection2 = FlexDirection.ROW;
                                } else {
                                    flexDirection2 = FlexDirection.COLUMN;
                                }
                                if (A(node, flexDirection2) && !C(g17, flexDirection2) && D(g17, flexDirection2) && E(g17, flexDirection2)) {
                                    f46 = M3;
                                    S(g17, flexDirection2, Math.max(b(g17, flexDirection2, (((f(node, flexDirection2) - M(node, flexDirection2)) - p(g17, flexDirection2)) - o(g17, flexDirection2, 0.0f)) - v(g17, flexDirection2, 0.0f)), M(g17, flexDirection2)));
                                } else {
                                    f46 = M3;
                                }
                                i66 = i75;
                                i75++;
                                M3 = f46;
                            }
                            f39 = M3;
                            flexNode4 = g17;
                            int i76 = i66;
                            FlexNode flexNode14 = flexNode13;
                            if (!A && x(g17)) {
                                i57++;
                                f59 += g17.i();
                                if (flexNode12 == null) {
                                    flexNode12 = g17;
                                }
                                if (flexNode11 != null) {
                                    flexNode11.D0(g17);
                                }
                                f48 = L(g17, P);
                                f18 = M2;
                                flexNode11 = g17;
                                f19 = M;
                                flexJustifyContent = flexJustifyContent4;
                                i18 = i69;
                                i19 = i38;
                                f17 = f39;
                                f28 = 0.0f;
                            } else {
                                FloatCompanionObject floatCompanionObject2 = FloatCompanionObject.INSTANCE;
                                if (z19) {
                                    if (C(node, P2)) {
                                        p17 = m(node, P2);
                                    } else {
                                        p17 = parentMaxWidth - p(node, P2);
                                    }
                                    f47 = p17 - M;
                                } else {
                                    f47 = Float.NaN;
                                }
                                if (z26) {
                                    f19 = M;
                                    f28 = 0.0f;
                                    i19 = i38;
                                    f17 = f39;
                                    f18 = M2;
                                    flexNode5 = flexNode11;
                                    flexJustifyContent = flexJustifyContent4;
                                    i18 = i69;
                                    F(g17, f47, layoutContext, Q, needLayoutAbsoluteChild, dirtyList);
                                } else {
                                    f18 = M2;
                                    flexNode5 = flexNode11;
                                    f19 = M;
                                    flexJustifyContent = flexJustifyContent4;
                                    i18 = i69;
                                    i19 = i38;
                                    f17 = f39;
                                    f28 = 0.0f;
                                }
                                if (z(g17)) {
                                    f48 = f28;
                                } else {
                                    i58++;
                                    f48 = f(g17, P) + p(g17, P);
                                }
                                flexNode11 = flexNode5;
                            }
                            if (!z18 && A) {
                                f26 = f65;
                                i37 = i49;
                                i36 = i68;
                                if (f26 + f48 > f49 && i36 != i37) {
                                    i58--;
                                    flexNode6 = flexNode14;
                                    f27 = f66;
                                    flexNode7 = flexNode4;
                                    i48 = i76;
                                    z26 = true;
                                    break;
                                }
                            } else {
                                i37 = i49;
                                f26 = f65;
                                i36 = i68;
                            }
                            if (z36 && (!z(g17) || x(g17))) {
                                i65 = i36;
                                z36 = false;
                            }
                            if (z28 && (!z(g17) || ((d16 != FlexAlign.STRETCH && d16 != FlexAlign.FLEX_START) || Float.isNaN(m(g17, e16))))) {
                                i56 = i36;
                                z28 = false;
                            }
                            if (!z36) {
                                V(g17, P, h(g17, P) + f58);
                                if (A) {
                                    W(g17, P, (f(node, P) - f(g17, P)) - h(g17, P));
                                }
                                f58 += f(g17, P) + p(g17, P);
                                f66 = Math.max(f66, b(g17, e16, f(g17, e16) + p(g17, e16)));
                            }
                            if (z28) {
                                V(g17, e16, h(g17, e16) + f56 + s17);
                                if (A2) {
                                    W(g17, e16, (f(node, e16) - f(g17, e16)) - h(g17, e16));
                                }
                            }
                            f65 = f26 + f48;
                            i67 = i36 + 1;
                            z26 = false;
                            flexNode13 = flexNode14;
                            flexNode10 = flexNode4;
                            i66 = i76;
                        }
                    }
                    f39 = M3;
                    flexNode4 = flexNode10;
                    int i762 = i66;
                    FlexNode flexNode142 = flexNode13;
                    if (!A) {
                    }
                    FloatCompanionObject floatCompanionObject22 = FloatCompanionObject.INSTANCE;
                    if (z19) {
                    }
                    if (z26) {
                    }
                    if (z(g17)) {
                    }
                    flexNode11 = flexNode5;
                    if (!z18) {
                    }
                    i37 = i49;
                    f26 = f65;
                    i36 = i68;
                    if (z36) {
                        i65 = i36;
                        z36 = false;
                    }
                    if (z28) {
                        i56 = i36;
                        z28 = false;
                    }
                    if (!z36) {
                    }
                    if (z28) {
                    }
                    f65 = f26 + f48;
                    i67 = i36 + 1;
                    z26 = false;
                    flexNode13 = flexNode142;
                    flexNode10 = flexNode4;
                    i66 = i762;
                } else {
                    i67 = i59 + 1;
                    i18 = i46;
                    f17 = M3;
                    f18 = M2;
                    i36 = i59;
                    f19 = M;
                    i37 = i49;
                    flexJustifyContent = flexJustifyContent4;
                }
                i59 = i36 + 1;
                M = f19;
                i49 = i37;
                h17 = i26;
                M3 = f17;
                M2 = f18;
                flexJustifyContent4 = flexJustifyContent;
                i46 = i18;
            }
            float max = A ? f49 - f26 : Math.max(f26, f28) - f26;
            if (i57 != 0) {
                float f67 = max / f59;
                for (FlexNode flexNode15 = flexNode12; flexNode15 != null; flexNode15 = flexNode15.getNextFlexChild()) {
                    if (flexNode15.getIsShow()) {
                        float i77 = (flexNode15.i() * f67) + M(flexNode15, P);
                        float b16 = b(flexNode15, P, i77);
                        if (!(i77 == b16)) {
                            max -= b16;
                            f59 -= flexNode15.i();
                        }
                    }
                }
                float f68 = max / f59;
                float f69 = f68 < f28 ? f28 : f68;
                FlexNode flexNode16 = flexNode12;
                while (flexNode16 != null) {
                    if (flexNode16.getIsShow()) {
                        S(flexNode16, P, b(flexNode16, P, (flexNode16.i() * f69) + M(flexNode16, P)));
                        FloatCompanionObject floatCompanionObject3 = FloatCompanionObject.INSTANCE;
                        if (C(node, P2)) {
                            p16 = m(node, P2);
                        } else if (!z19) {
                            p16 = parentMaxWidth - p(node, P2);
                        } else {
                            f38 = Float.NaN;
                            flexNode3 = flexNode16;
                            F(flexNode16, f38, layoutContext, Q, needLayoutAbsoluteChild, dirtyList);
                        }
                        f38 = p16 - f19;
                        flexNode3 = flexNode16;
                        F(flexNode16, f38, layoutContext, Q, needLayoutAbsoluteChild, dirtyList);
                    } else {
                        flexNode3 = flexNode16;
                    }
                    flexNode16 = flexNode3.getNextFlexChild();
                    flexNode3.D0(null);
                }
                flexJustifyContent2 = flexJustifyContent;
            } else {
                flexJustifyContent2 = flexJustifyContent;
                if (flexJustifyContent2 != FlexJustifyContent.FLEX_START) {
                    int i78 = a.f117335a[flexJustifyContent2.ordinal()];
                    if (i78 == 1) {
                        max /= 2;
                        Unit unit2 = Unit.INSTANCE;
                    } else if (i78 == 2) {
                        Unit unit3 = Unit.INSTANCE;
                    } else {
                        if (i78 == 3) {
                            int i79 = (i57 + i58) - 1;
                            float max2 = i79 != 0 ? Math.max(max, f28) / i79 : f28;
                            Unit unit4 = Unit.INSTANCE;
                            f29 = max2;
                            max = f28;
                        } else if (i78 == 4) {
                            int i85 = i57 + i58;
                            if (i85 != 0) {
                                max /= i85;
                            }
                            Unit unit5 = Unit.INSTANCE;
                            float f75 = max;
                            max /= 2;
                            f29 = f75;
                        } else if (i78 != 5) {
                            Unit unit6 = Unit.INSTANCE;
                        } else {
                            if (i57 + i58 != 0) {
                                max /= r38 + 1;
                            }
                            Unit unit7 = Unit.INSTANCE;
                            f29 = max;
                        }
                        float f76 = f58 + max;
                        float f77 = f76;
                        i28 = i19;
                        for (i27 = i65; i27 < i28; i27++) {
                            FlexNode g18 = node.g(i27);
                            if (g18 != null && g18.getIsShow()) {
                                if (y(g18) && (D(g18, P) || C(g18, P))) {
                                    V(g18, P, o(g18, P, f28) + k(node, P) + q(g18, P));
                                } else {
                                    V(g18, P, h(g18, P) + f77);
                                    if (A) {
                                        W(g18, P, (f(node, P) - f(g18, P)) - h(g18, P));
                                    }
                                    if (z(g18)) {
                                        f77 += f(g18, P) + f29 + p(g18, P);
                                        f27 = Math.max(f27, b(g18, e16, f(g18, e16) + p(g18, e16)));
                                    }
                                }
                            }
                        }
                        float f78 = f(node, e16);
                        float f79 = f17;
                        if (!A2) {
                            f78 = Math.max(b(node, e16, f27 + f79), f79);
                        }
                        FlexNode flexNode17 = flexNode9;
                        i29 = i56;
                        while (i29 < i28) {
                            FlexNode g19 = node.g(i29);
                            if (g19 != null && g19.getIsShow()) {
                                if (y(g19) && (D(g19, e16) || C(g19, e16))) {
                                    V(g19, e16, o(g19, e16, f28) + k(node, e16) + q(g19, e16));
                                } else {
                                    if (z(g19)) {
                                        FlexAlign d17 = d(node, g19);
                                        flexJustifyContent3 = flexJustifyContent2;
                                        if (d17 == FlexAlign.STRETCH) {
                                            if (!A(g19, e16)) {
                                                S(g19, e16, Math.max(b(g19, e16, (f78 - f79) - p(g19, e16)), M(g19, e16)));
                                                if (flexNode8 == null) {
                                                    f36 = f78;
                                                    flexNode17 = g19;
                                                    flexNode8 = flexNode17;
                                                } else {
                                                    Intrinsics.checkNotNull(flexNode17);
                                                    flexNode17.F0(g19);
                                                    f36 = f78;
                                                    flexNode17 = g19;
                                                }
                                            }
                                        } else if (d17 != FlexAlign.FLEX_START) {
                                            float f85 = (f78 - f79) - (f(g19, e16) + p(g19, e16));
                                            f36 = f78;
                                            if (d17 == FlexAlign.CENTER) {
                                                f85 /= 2;
                                            }
                                            f37 = s17 + f85;
                                            V(g19, e16, h(g19, e16) + f56 + f37);
                                            if (!A2) {
                                                W(g19, e16, (f(node, e16) - f(g19, e16)) - h(g19, e16));
                                            }
                                            i29++;
                                            f78 = f36;
                                            flexJustifyContent2 = flexJustifyContent3;
                                            f28 = 0.0f;
                                        }
                                        f36 = f78;
                                    } else {
                                        f36 = f78;
                                        flexJustifyContent3 = flexJustifyContent2;
                                    }
                                    f37 = s17;
                                    V(g19, e16, h(g19, e16) + f56 + f37);
                                    if (!A2) {
                                    }
                                    i29++;
                                    f78 = f36;
                                    flexJustifyContent2 = flexJustifyContent3;
                                    f28 = 0.0f;
                                }
                            }
                            f36 = f78;
                            flexJustifyContent3 = flexJustifyContent2;
                            i29++;
                            f78 = f36;
                            flexJustifyContent2 = flexJustifyContent3;
                            f28 = 0.0f;
                        }
                        FlexJustifyContent flexJustifyContent5 = flexJustifyContent2;
                        f56 += f27;
                        f57 = Math.max(f57, f77);
                        i46 = i18 + 1;
                        M = f19;
                        M3 = f79;
                        i39 = i28;
                        i47 = i39;
                        flexNode9 = flexNode17;
                        h17 = i26;
                        M2 = f18;
                        m3 = flexJustifyContent5;
                    }
                    f29 = f28;
                    float f762 = f58 + max;
                    float f772 = f762;
                    i28 = i19;
                    while (i27 < i28) {
                    }
                    float f782 = f(node, e16);
                    float f792 = f17;
                    if (!A2) {
                    }
                    FlexNode flexNode172 = flexNode9;
                    i29 = i56;
                    while (i29 < i28) {
                    }
                    FlexJustifyContent flexJustifyContent52 = flexJustifyContent2;
                    f56 += f27;
                    f57 = Math.max(f57, f772);
                    i46 = i18 + 1;
                    M = f19;
                    M3 = f792;
                    i39 = i28;
                    i47 = i39;
                    flexNode9 = flexNode172;
                    h17 = i26;
                    M2 = f18;
                    m3 = flexJustifyContent52;
                }
            }
            f29 = f28;
            max = f29;
            float f7622 = f58 + max;
            float f7722 = f7622;
            i28 = i19;
            while (i27 < i28) {
            }
            float f7822 = f(node, e16);
            float f7922 = f17;
            if (!A2) {
            }
            FlexNode flexNode1722 = flexNode9;
            i29 = i56;
            while (i29 < i28) {
            }
            FlexJustifyContent flexJustifyContent522 = flexJustifyContent2;
            f56 += f27;
            f57 = Math.max(f57, f7722);
            i46 = i18 + 1;
            M = f19;
            M3 = f7922;
            i39 = i28;
            i47 = i39;
            flexNode9 = flexNode1722;
            h17 = i26;
            M2 = f18;
            m3 = flexJustifyContent522;
        }
        float f86 = M3;
        float f87 = M2;
        int i86 = h17;
        float f88 = f57;
        if (i46 > 1 && A2) {
            float f89 = f(node, e16) - f86;
            float f95 = f89 - f56;
            FlexAlign d18 = node.d();
            if (d18 != FlexAlign.FLEX_END) {
                if (d18 == FlexAlign.CENTER) {
                    f95 /= 2;
                } else {
                    if (d18 == FlexAlign.STRETCH && f89 > f56) {
                        f16 = f95 / i46;
                        i16 = 0;
                        int i87 = 0;
                        while (i16 < i46) {
                            int i88 = i87;
                            int i89 = i86;
                            float f96 = 0.0f;
                            while (true) {
                                if (i88 >= i89) {
                                    i88 = i48;
                                    break;
                                }
                                FlexNode g26 = node.g(i88);
                                if (g26 != null && g26.getIsShow() && z(g26)) {
                                    if (g26.getLineIndex() != i16) {
                                        break;
                                    } else if (A(g26, e16)) {
                                        f96 = Math.max(f96, f(g26, e16) + p(g26, e16));
                                    }
                                }
                                i48 = i88;
                                i88++;
                            }
                            float f97 = f96 + f16;
                            i48 = i88;
                            while (i87 < i88) {
                                FlexNode g27 = node.g(i87);
                                if (g27 != null && g27.getIsShow() && z(g27)) {
                                    int i95 = a.f117336b[d(node, g27).ordinal()];
                                    i17 = i46;
                                    if (i95 == 1) {
                                        V(g27, e16, s17 + q(g27, e16));
                                        Unit unit8 = Unit.INSTANCE;
                                    } else if (i95 == 2) {
                                        V(g27, e16, ((s17 + f97) - r(g27, e16)) - m(g27, e16));
                                        Unit unit9 = Unit.INSTANCE;
                                    } else if (i95 != 3) {
                                        if (i95 == 4) {
                                            V(g27, e16, s17 + q(g27, e16));
                                        }
                                        Unit unit10 = Unit.INSTANCE;
                                    } else {
                                        V(g27, e16, s17 + ((f97 - f(g27, e16)) / 2.0f));
                                        Unit unit11 = Unit.INSTANCE;
                                    }
                                } else {
                                    i17 = i46;
                                }
                                i48 = i87;
                                i46 = i17;
                                i87++;
                            }
                            s17 += f97;
                            i16++;
                            i87 = i88;
                            i86 = i89;
                            i46 = i46;
                        }
                    }
                    f16 = 0.0f;
                    i16 = 0;
                    int i872 = 0;
                    while (i16 < i46) {
                    }
                }
            }
            s17 += f95;
            f16 = 0.0f;
            i16 = 0;
            int i8722 = 0;
            while (i16 < i46) {
            }
        }
        int i96 = i86;
        if (!A) {
            float t16 = f88 + t(node, P) + l(node, P);
            float max3 = Math.max(b(node, P, t16), f87);
            S(node, P, max3);
            if (!(t16 == max3) && node.m() != FlexJustifyContent.FLEX_START && node.h() != 0) {
                a(node, P, f87);
            }
            if (P == FlexDirection.ROW_REVERSE || P == FlexDirection.COLUMN_REVERSE) {
                z16 = true;
                if (!A2) {
                    S(node, e16, Math.max(b(node, e16, f56 + f86), f86));
                    if (e16 == FlexDirection.ROW_REVERSE || e16 == FlexDirection.COLUMN_REVERSE) {
                        z17 = true;
                        if (!z16 || z17) {
                            for (i3 = 0; i3 < i96; i3++) {
                                FlexNode g28 = node.g(i3);
                                if (g28 != null && g28.getIsShow()) {
                                    if (z16) {
                                        W(g28, P, (f(node, P) - f(g28, P)) - h(g28, P));
                                    }
                                    if (z17) {
                                        W(g28, e16, (f(node, e16) - f(g28, e16)) - h(g28, e16));
                                    }
                                }
                            }
                        }
                        while (true) {
                            flexNode = flexNode6;
                            if (flexNode == null) {
                                return;
                            }
                            if (flexNode.getIsShow()) {
                                boolean z37 = false;
                                for (int i97 = 0; i97 < 2; i97++) {
                                    if (i97 != 0) {
                                        flexDirection = FlexDirection.ROW;
                                    } else {
                                        flexDirection = FlexDirection.COLUMN;
                                    }
                                    if (A(node, flexDirection) && !C(flexNode, flexDirection) && !Float.isNaN(n(flexNode, flexDirection)) && !Float.isNaN(u(flexNode, flexDirection))) {
                                        float max4 = Math.max(b(flexNode, flexDirection, (((f(node, flexDirection) - (l(node, flexDirection) + k(node, flexDirection))) - p(flexNode, flexDirection)) - o(flexNode, flexDirection, 0.0f)) - v(flexNode, flexDirection, 0.0f)), M(flexNode, flexDirection));
                                        float f98 = f(flexNode, flexDirection);
                                        S(flexNode, flexDirection, max4);
                                        if (!z37) {
                                            z37 = c(flexNode, f98, max4, flexDirection);
                                        }
                                    }
                                    if (!Float.isNaN(u(flexNode, flexDirection)) && Float.isNaN(n(flexNode, flexDirection))) {
                                        U(flexNode, flexDirection, (f(node, flexDirection) - f(flexNode, flexDirection)) - v(flexNode, flexDirection, 0.0f));
                                    }
                                }
                                if (needLayoutAbsoluteChild && flexNode.h() > 0 && z37) {
                                    flexNode2 = null;
                                    O(node, flexNode, layoutContext, Q, dirtyList);
                                    flexNode6 = flexNode.getNextAbsoluteChild();
                                    flexNode.C0(flexNode2);
                                }
                            }
                            flexNode2 = null;
                            flexNode6 = flexNode.getNextAbsoluteChild();
                            flexNode.C0(flexNode2);
                        }
                    }
                }
                z17 = false;
                if (!z16) {
                }
                while (i3 < i96) {
                }
                while (true) {
                    flexNode = flexNode6;
                    if (flexNode == null) {
                    }
                    flexNode6 = flexNode.getNextAbsoluteChild();
                    flexNode.C0(flexNode2);
                }
            }
        }
        z16 = false;
        if (!A2) {
        }
        z17 = false;
        if (!z16) {
        }
        while (i3 < i96) {
        }
        while (true) {
            flexNode = flexNode6;
            if (flexNode == null) {
            }
            flexNode6 = flexNode.getNextAbsoluteChild();
            flexNode.C0(flexNode2);
        }
    }

    private final StyleSpace.Type I(FlexDirection direction) {
        return leadingSpacing[direction.ordinal()];
    }

    private final StyleSpace.Type J(FlexDirection direction) {
        return leading[direction.ordinal()];
    }

    private final boolean K(FlexNode node, float parentMaxWidth) {
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

    private final float L(FlexNode flexNode, FlexDirection flexDirection) {
        return M(flexNode, flexDirection) + q(flexNode, flexDirection) + r(flexNode, flexDirection);
    }

    private final float M(FlexNode flexNode, FlexDirection flexDirection) {
        return s(flexNode, flexDirection) + k(flexNode, flexDirection) + t(flexNode, flexDirection) + l(flexNode, flexDirection);
    }

    private final boolean N(FlexNode flexNode, float f16, float f17, FlexDirection flexDirection, b bVar) {
        float p16;
        g gVar;
        boolean A = A(flexNode, flexDirection);
        if (C(flexNode, flexDirection)) {
            p16 = flexNode.U();
        } else if (A) {
            p16 = f(flexNode, flexDirection);
        } else {
            p16 = f16 - p(flexNode, flexDirection);
        }
        float f18 = p16 - f17;
        if ((Float.isNaN(f18) && !Float.isNaN(flexNode.N())) || (!Float.isNaN(flexNode.N()) && flexNode.N() < f18)) {
            f18 = flexNode.N();
        }
        if (f18 < 0.0f) {
            KLog.INSTANCE.e("LayoutImpl", "layout width < 0");
            f18 = 0.0f;
        }
        if (bVar == null || (gVar = bVar.getMeasureOutput()) == null) {
            gVar = new g();
        }
        g e06 = flexNode.e0(gVar, f18);
        X(flexNode, e06.getWidth() + f17);
        T(flexNode, e06.getHeight() + M(flexNode, FlexDirection.COLUMN));
        return flexNode.h() == 0;
    }

    private final void O(FlexNode flexNode, FlexNode flexNode2, b bVar, FlexLayoutDirection flexLayoutDirection, Set<FlexNode> set) {
        FlexDirection P = P(flexNode2.j(), flexLayoutDirection);
        FlexDirection e16 = e(flexNode2.j(), flexLayoutDirection);
        float g16 = g(flexNode2, P);
        float g17 = g(flexNode2, e16);
        if (!Float.isNaN(g16)) {
            U(flexNode2, P, (g16 - q(flexNode2, P)) - j(flexNode2, P));
        }
        if (!Float.isNaN(g17)) {
            U(flexNode2, e16, (g17 - q(flexNode2, e16)) - j(flexNode2, e16));
        }
        flexNode.Y(flexNode2, flexNode.v(), bVar, flexLayoutDirection, false, set);
    }

    private final FlexDirection P(FlexDirection axis, FlexLayoutDirection direction) {
        if (direction != FlexLayoutDirection.RTL) {
            return axis;
        }
        int i3 = a.f117337c[axis.ordinal()];
        if (i3 != 1) {
            return i3 != 2 ? axis : FlexDirection.ROW;
        }
        return FlexDirection.ROW_REVERSE;
    }

    private final FlexLayoutDirection Q(FlexNode flexNode, FlexLayoutDirection flexLayoutDirection) {
        FlexLayoutDirection J = flexNode.J();
        if (J != FlexLayoutDirection.INHERIT) {
            return J;
        }
        if (flexLayoutDirection == null) {
            flexLayoutDirection = FlexLayoutDirection.LTR;
        }
        return flexLayoutDirection;
    }

    private final void R(FlexNode flexNode, FlexDirection flexDirection) {
        if (A(flexNode, flexDirection)) {
            return;
        }
        if (flexDirection != FlexDirection.COLUMN && flexDirection != FlexDirection.COLUMN_REVERSE) {
            if ((Float.isNaN(m(flexNode, flexDirection)) && Float.isNaN(flexNode.P()) && Float.isNaN(flexNode.N())) || m(flexNode, flexDirection) <= 0.0f) {
                return;
            }
        } else if ((Float.isNaN(flexNode.O()) && Float.isNaN(flexNode.M()) && Float.isNaN(m(flexNode, flexDirection))) || m(flexNode, flexDirection) <= 0.0f) {
            return;
        }
        S(flexNode, flexDirection, Math.max(b(flexNode, flexDirection, m(flexNode, flexDirection)), M(flexNode, flexDirection)));
    }

    private final void S(FlexNode flexNode, FlexDirection flexDirection, float f16) {
        flexNode.q()[dim[flexDirection.ordinal()]] = f16;
    }

    private final void T(FlexNode flexNode, float f16) {
        flexNode.v0(f16);
    }

    private final void U(FlexNode flexNode, FlexDirection flexDirection, float f16) {
        flexNode.u()[leading[flexDirection.ordinal()].ordinal()] = f16;
    }

    private final void V(FlexNode flexNode, FlexDirection flexDirection, float f16) {
        flexNode.u()[pos[flexDirection.ordinal()]] = f16;
    }

    private final void W(FlexNode flexNode, FlexDirection flexDirection, float f16) {
        flexNode.u()[trailing[flexDirection.ordinal()].ordinal()] = f16;
    }

    private final void X(FlexNode flexNode, float f16) {
        flexNode.w0(f16);
    }

    private final StyleSpace.Type Y(FlexDirection direction) {
        return trailingSpacing[direction.ordinal()];
    }

    private final StyleSpace.Type Z(FlexDirection direction) {
        return trailing[direction.ordinal()];
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x0064  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final void a(FlexNode flexNode, FlexDirection flexDirection, float f16) {
        float f17;
        float f18 = f(flexNode, flexDirection);
        int h16 = flexNode.h();
        float f19 = 0.0f;
        for (int i3 = 0; i3 < h16; i3++) {
            FlexNode g16 = flexNode.g(i3);
            if (g16 != null) {
                f19 += f(g16, flexDirection) + p(g16, flexDirection);
            }
        }
        float f26 = f18 - f19;
        int i16 = a.f117335a[flexNode.m().ordinal()];
        if (i16 == 1) {
            f26 /= 2;
        } else if (i16 != 2) {
            if (i16 == 3) {
                f17 = f26 / (flexNode.h() - 1);
            } else if (i16 != 4) {
                r2 = i16 == 5 ? f26 / (flexNode.h() + 1) : 0.0f;
                f17 = r2;
            } else {
                r2 = f26 / flexNode.h();
                f26 = r2 / 2;
            }
            float f27 = f16 + r2;
            for (int i17 = 0; i17 < h16; i17++) {
                FlexNode g17 = flexNode.g(i17);
                if (g17 != null) {
                    V(g17, flexDirection, p(g17, flexDirection) + f27);
                    if (z(g17)) {
                        f27 += f(g17, flexDirection) + f17 + p(g17, flexDirection);
                    }
                }
            }
        }
        float f28 = r2;
        r2 = f26;
        f17 = f28;
        float f272 = f16 + r2;
        while (i17 < h16) {
        }
    }

    private final float b(FlexNode flexNode, FlexDirection flexDirection, float f16) {
        float O;
        float M;
        FloatCompanionObject floatCompanionObject = FloatCompanionObject.INSTANCE;
        if (flexDirection != FlexDirection.COLUMN && flexDirection != FlexDirection.COLUMN_REVERSE) {
            if (flexDirection == FlexDirection.ROW || flexDirection == FlexDirection.ROW_REVERSE) {
                O = flexNode.P();
                M = flexNode.N();
            } else {
                M = Float.NaN;
                O = Float.NaN;
            }
        } else {
            O = flexNode.O();
            M = flexNode.M();
        }
        if (!Float.isNaN(M) && M >= 0.0d && f16 > M) {
            f16 = M;
        }
        return (Float.isNaN(O) || ((double) O) < 0.0d || O <= f16) ? f16 : O;
    }

    private final boolean c(FlexNode flexNode, float f16, float f17, FlexDirection flexDirection) {
        if (!Float.isNaN(f16) && !Float.isNaN(f17)) {
            if (!(f16 == f17)) {
                if (flexDirection == flexNode.j()) {
                    if (flexNode.m() != FlexJustifyContent.FLEX_START && !C(flexNode, flexDirection)) {
                        return true;
                    }
                } else if (((flexNode.e() != FlexAlign.FLEX_START && flexNode.e() != FlexAlign.STRETCH) || w(flexNode)) && !C(flexNode, flexDirection)) {
                    return true;
                }
            }
        }
        return false;
    }

    private final FlexAlign d(FlexNode flexNode, FlexNode flexNode2) {
        if (flexNode2.f() != FlexAlign.AUTO) {
            return flexNode2.f();
        }
        return flexNode.e();
    }

    private final FlexDirection e(FlexDirection axis, FlexLayoutDirection direction) {
        FlexDirection flexDirection = FlexDirection.COLUMN;
        return (axis == flexDirection || axis == FlexDirection.COLUMN_REVERSE) ? P(FlexDirection.ROW, direction) : flexDirection;
    }

    private final float f(FlexNode flexNode, FlexDirection flexDirection) {
        return flexNode.q()[dim[flexDirection.ordinal()]];
    }

    private final float g(FlexNode flexNode, FlexDirection flexDirection) {
        return flexNode.u()[leading[flexDirection.ordinal()].ordinal()];
    }

    private final float h(FlexNode flexNode, FlexDirection flexDirection) {
        return flexNode.u()[pos[flexDirection.ordinal()]];
    }

    private final float i(FlexNode flexNode, FlexDirection flexDirection) {
        return flexNode.u()[trailing[flexDirection.ordinal()].ordinal()];
    }

    private final float j(FlexNode flexNode, FlexDirection flexDirection) {
        float f16 = flexNode.T()[leading[flexDirection.ordinal()].ordinal()];
        if (!Float.isNaN(f16)) {
            return f16;
        }
        float f17 = flexNode.T()[trailing[flexDirection.ordinal()].ordinal()];
        if (Float.isNaN(f17)) {
            return 0.0f;
        }
        return -f17;
    }

    private final float k(FlexNode flexNode, FlexDirection flexDirection) {
        return flexNode.H(I(flexDirection), J(flexDirection));
    }

    private final float l(FlexNode flexNode, FlexDirection flexDirection) {
        return flexNode.H(Y(flexDirection), Z(flexDirection));
    }

    private final float m(FlexNode flexNode, FlexDirection flexDirection) {
        return flexNode.I()[dim[flexDirection.ordinal()]];
    }

    private final float n(FlexNode flexNode, FlexDirection flexDirection) {
        return flexNode.T()[leading[flexDirection.ordinal()].ordinal()];
    }

    private final float o(FlexNode flexNode, FlexDirection flexDirection, float f16) {
        float n3 = n(flexNode, flexDirection);
        return Float.isNaN(n3) ? f16 : n3;
    }

    private final float p(FlexNode flexNode, FlexDirection flexDirection) {
        return q(flexNode, flexDirection) + r(flexNode, flexDirection);
    }

    private final float q(FlexNode flexNode, FlexDirection flexDirection) {
        return flexNode.L(I(flexDirection), J(flexDirection));
    }

    private final float r(FlexNode flexNode, FlexDirection flexDirection) {
        return flexNode.L(Y(flexDirection), Z(flexDirection));
    }

    private final float s(FlexNode flexNode, FlexDirection flexDirection) {
        return flexNode.S(I(flexDirection), J(flexDirection));
    }

    private final float t(FlexNode flexNode, FlexDirection flexDirection) {
        return flexNode.S(Y(flexDirection), Z(flexDirection));
    }

    private final float u(FlexNode flexNode, FlexDirection flexDirection) {
        return flexNode.T()[trailing[flexDirection.ordinal()].ordinal()];
    }

    private final float v(FlexNode flexNode, FlexDirection flexDirection, float f16) {
        return Float.isNaN(u(flexNode, flexDirection)) ? f16 : u(flexNode, flexDirection);
    }

    private final boolean w(FlexNode flexNode) {
        int h16 = flexNode.h();
        for (int i3 = 0; i3 < h16; i3++) {
            FlexNode g16 = flexNode.g(i3);
            if (g16 != null && g16.f() != FlexAlign.FLEX_START && g16.f() != FlexAlign.AUTO) {
                return true;
            }
        }
        return false;
    }

    private final boolean x(FlexNode flexNode) {
        return flexNode.G() == FlexPositionType.RELATIVE && flexNode.i() > 0.0f;
    }

    private final boolean y(FlexNode flexNode) {
        return flexNode.G() == FlexPositionType.ABSOLUTE;
    }

    private final boolean z(FlexNode flexNode) {
        return flexNode.G() == FlexPositionType.RELATIVE;
    }

    public final void F(FlexNode node, float parentMaxWidth, b layoutContext, FlexLayoutDirection parentDirection, boolean needLayoutAbsoluteChild, Set<FlexNode> dirtyList) {
        Intrinsics.checkNotNullParameter(node, "node");
        Intrinsics.checkNotNullParameter(dirtyList, "dirtyList");
        if (K(node, parentMaxWidth)) {
            node.s0(node.v());
            node.r0(node.t());
            node.t0(parentMaxWidth);
            H(node, parentMaxWidth, layoutContext, parentDirection, dirtyList, needLayoutAbsoluteChild);
            dirtyList.add(node);
            return;
        }
        node.Y0();
        node.d0();
    }

    public static /* synthetic */ void G(e eVar, FlexNode flexNode, float f16, b bVar, FlexLayoutDirection flexLayoutDirection, boolean z16, Set set, int i3, Object obj) {
        eVar.F(flexNode, f16, (i3 & 4) != 0 ? null : bVar, (i3 & 8) != 0 ? null : flexLayoutDirection, (i3 & 16) != 0 ? true : z16, set);
    }
}

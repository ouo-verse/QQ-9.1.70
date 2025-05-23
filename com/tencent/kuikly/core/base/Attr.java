package com.tencent.kuikly.core.base;

import com.tencent.aekit.plugin.core.AIInput;
import com.tencent.kuikly.core.base.attr.AccessibilityRole;
import com.tencent.kuikly.core.base.attr.c;
import com.tencent.kuikly.core.base.attr.d;
import com.tencent.kuikly.core.exception.PagerNotFoundExceptionKt;
import com.tencent.kuikly.core.layout.FlexAlign;
import com.tencent.kuikly.core.layout.FlexLayout;
import com.tencent.kuikly.core.layout.FlexNode;
import com.tencent.kuikly.core.layout.FlexPositionType;
import com.tencent.kuikly.core.layout.StyleSpace;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qqmini.miniapp.widget.CanvasView;
import com.tenpay.proxy.dlg.location.QbAddrData;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FloatCompanionObject;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u00fa\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\t\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0016\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000e\b\u0016\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003B\t\u00a2\u0006\u0006\b\u00a8\u0001\u0010\u00a9\u0001J\b\u0010\u0005\u001a\u00020\u0004H\u0016J\u0006\u0010\u0006\u001a\u00020\u0004J\u0006\u0010\u0007\u001a\u00020\u0004J\u0006\u0010\b\u001a\u00020\u0004J\u0018\u0010\u000b\u001a\u00020\u00042\u000e\u0010\n\u001a\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\tH\u0016J5\u0010\u0015\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\f2%\u0010\u0014\u001a!\u0012\u0013\u0012\u00110\u000f\u00a2\u0006\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b(\u0012\u0012\u0004\u0012\u00020\u00040\u000ej\u0002`\u0013J\u000e\u0010\u0016\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\fJ\u0016\u0010\u001a\u001a\u00020\u00002\u0006\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u0019\u001a\u00020\u0017J\u000e\u0010\u001a\u001a\u00020\u00002\u0006\u0010\u001a\u001a\u00020\u0017J\u0010\u0010\u0018\u001a\u00020\u00002\u0006\u0010\u0018\u001a\u00020\u0017H\u0016J\u0010\u0010\u0019\u001a\u00020\u00002\u0006\u0010\u0019\u001a\u00020\u0017H\u0016J\u0016\u0010\u001d\u001a\u00020\u00002\u0006\u0010\u001b\u001a\u00020\u00172\u0006\u0010\u001c\u001a\u00020\u0017J\u0010\u0010\u001b\u001a\u00020\u00002\u0006\u0010\u001b\u001a\u00020\u0017H\u0016J\u0010\u0010\u001c\u001a\u00020\u00002\u0006\u0010\u001c\u001a\u00020\u0017H\u0016J\u0016\u0010 \u001a\u00020\u00002\u0006\u0010\u001e\u001a\u00020\u00172\u0006\u0010\u001f\u001a\u00020\u0017J\u0010\u0010\u001e\u001a\u00020\u00002\u0006\u0010\u001e\u001a\u00020\u0017H\u0016J\u0010\u0010\u001f\u001a\u00020\u00002\u0006\u0010\u001f\u001a\u00020\u0017H\u0016J\u0010\u0010\"\u001a\u00020\u00002\u0006\u0010\"\u001a\u00020!H\u0016J\u000e\u0010#\u001a\u00020\u00002\u0006\u0010\"\u001a\u00020\u0017J\u0010\u0010$\u001a\u00020\u00002\u0006\u0010$\u001a\u00020\u0017H\u0016J\u0018\u0010(\u001a\u00020\u00042\u0006\u0010%\u001a\u00020\u00172\b\b\u0002\u0010'\u001a\u00020&J\u000e\u0010+\u001a\u00020\u00002\u0006\u0010*\u001a\u00020)J\u0010\u0010+\u001a\u00020\u00002\u0006\u0010-\u001a\u00020,H\u0016J+\u00103\u001a\u00020\u00002\u0006\u0010/\u001a\u00020.2\u0012\u00102\u001a\n\u0012\u0006\b\u0001\u0012\u00020100\"\u000201H\u0016\u00a2\u0006\u0004\b3\u00104J\u0010\u00106\u001a\u00020\u00002\u0006\u00106\u001a\u000205H\u0016J\u0018\u00106\u001a\u00020\u00002\u0006\u00106\u001a\u0002052\b\b\u0002\u00107\u001a\u00020&J\u0010\u00109\u001a\u00020\u00002\u0006\u00109\u001a\u000208H\u0016J\u000e\u0010<\u001a\u00020\u00002\u0006\u0010;\u001a\u00020:J&\u00109\u001a\u00020\u00002\u0006\u0010=\u001a\u00020\u00172\u0006\u0010>\u001a\u00020\u00172\u0006\u0010?\u001a\u00020\u00172\u0006\u0010@\u001a\u00020\u0017J\u000e\u00109\u001a\u00020\u00002\u0006\u0010A\u001a\u00020\u0017J\u0010\u0010C\u001a\u00020\u00002\u0006\u0010C\u001a\u00020BH\u0016J\u0010\u0010D\u001a\u00020\u00002\u0006\u0010D\u001a\u00020&H\u0016J\u0010\u0010E\u001a\u00020\u00002\u0006\u0010E\u001a\u00020\u0017H\u0016J\u0010\u0010F\u001a\u00020\u00002\u0006\u0010F\u001a\u00020&H\u0016J\u0018\u0010H\u001a\u00020\u00002\u0006\u0010H\u001a\u00020G2\u0006\u0010J\u001a\u00020IH\u0016J\u0018\u0010K\u001a\u00020\u00022\u0006\u0010H\u001a\u00020G2\u0006\u0010J\u001a\u00020IH\u0016J\u000e\u0010N\u001a\u00020\u00002\u0006\u0010M\u001a\u00020LJ\u000e\u0010N\u001a\u00020\u00002\u0006\u0010P\u001a\u00020OJ\u000e\u0010N\u001a\u00020\u00002\u0006\u0010R\u001a\u00020QJ\u000e\u0010N\u001a\u00020\u00002\u0006\u0010T\u001a\u00020SJ0\u0010N\u001a\u00020\u00002\u0006\u0010M\u001a\u00020L2\u0006\u0010P\u001a\u00020O2\u0006\u0010R\u001a\u00020Q2\u0006\u0010V\u001a\u00020U2\u0006\u0010T\u001a\u00020SH\u0016J\u0010\u0010W\u001a\u00020\u00022\u0006\u0010W\u001a\u00020\fH\u0016J\u0010\u0010Z\u001a\u00020\u00022\u0006\u0010Y\u001a\u00020XH\u0016J\u0010\u0010\\\u001a\u00020\u00022\u0006\u0010[\u001a\u00020&H\u0016J\u0010\u0010]\u001a\u00020\u00022\u0006\u0010[\u001a\u00020&H\u0016J\u0010\u0010_\u001a\u00020\u00022\u0006\u0010^\u001a\u00020&H\u0016J\u0012\u0010a\u001a\u00020\u00042\b\b\u0002\u0010`\u001a\u00020!H\u0016J\u0010\u0010b\u001a\u00020\u00042\u0006\u0010/\u001a\u00020!H\u0016J\u0010\u0010c\u001a\u00020\u00002\u0006\u0010c\u001a\u00020\u0017H\u0016J\u0010\u0010d\u001a\u00020\u00002\u0006\u0010d\u001a\u00020\u0017H\u0016J\u0010\u0010e\u001a\u00020\u00002\u0006\u0010e\u001a\u00020\u0017H\u0016J\u0010\u0010f\u001a\u00020\u00002\u0006\u0010f\u001a\u00020\u0017H\u0016J\u0010\u0010h\u001a\u00020\u00002\u0006\u0010h\u001a\u00020gH\u0016J\u000e\u0010c\u001a\u00020\u00042\u0006\u0010j\u001a\u00020iJ\u000e\u0010d\u001a\u00020\u00042\u0006\u0010j\u001a\u00020iJ\u000e\u0010f\u001a\u00020\u00042\u0006\u0010j\u001a\u00020iJ\u000e\u0010e\u001a\u00020\u00042\u0006\u0010j\u001a\u00020iJ\u0006\u0010k\u001a\u00020\u0000J\u0006\u0010l\u001a\u00020\u0000J\u0006\u0010m\u001a\u00020\u0004J.\u0010n\u001a\u00020\u00002\b\b\u0002\u0010c\u001a\u00020\u00172\b\b\u0002\u0010d\u001a\u00020\u00172\b\b\u0002\u0010e\u001a\u00020\u00172\b\b\u0002\u0010f\u001a\u00020\u0017J\u0010\u0010o\u001a\u00020\u00002\u0006\u0010o\u001a\u00020:H\u0016J\u0006\u0010p\u001a\u00020\u0000J\u0006\u0010q\u001a\u00020\u0000J\u0006\u0010r\u001a\u00020\u0000J\u0006\u0010s\u001a\u00020\u0000J(\u0010t\u001a\u00020\u00002\u0006\u0010c\u001a\u00020\u00172\u0006\u0010d\u001a\u00020\u00172\u0006\u0010e\u001a\u00020\u00172\u0006\u0010f\u001a\u00020\u0017H\u0016J\u000e\u0010u\u001a\u00020\u00002\u0006\u0010c\u001a\u00020\u0017J\u000e\u0010v\u001a\u00020\u00002\u0006\u0010d\u001a\u00020\u0017J\u000e\u0010w\u001a\u00020\u00002\u0006\u0010e\u001a\u00020\u0017J\u000e\u0010x\u001a\u00020\u00002\u0006\u0010f\u001a\u00020\u0017J\u000e\u0010t\u001a\u00020\u00002\u0006\u0010y\u001a\u00020\u0017J\u000e\u0010{\u001a\u00020\u00002\u0006\u0010z\u001a\u00020&J\u000e\u0010|\u001a\u00020\u00002\u0006\u0010|\u001a\u00020\fJ\u000e\u0010}\u001a\u00020\u00042\u0006\u0010}\u001a\u00020&J\u0010\u0010\u007f\u001a\u00020\u00042\b\b\u0002\u0010~\u001a\u00020&R,\u0010\u0081\u0001\u001a\u0005\u0018\u00010\u0080\u00018\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0018\n\u0006\b\u0081\u0001\u0010\u0082\u0001\u001a\u0006\b\u0083\u0001\u0010\u0084\u0001\"\u0006\b\u0085\u0001\u0010\u0086\u0001R'\u0010}\u001a\u00020&8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0017\n\u0005\b}\u0010\u0087\u0001\u001a\u0006\b\u0088\u0001\u0010\u0089\u0001\"\u0006\b\u008a\u0001\u0010\u008b\u0001R'\u0010\u007f\u001a\u00020&8\u0000@\u0000X\u0080\u000e\u00a2\u0006\u0017\n\u0005\b\u007f\u0010\u0087\u0001\u001a\u0006\b\u008c\u0001\u0010\u0089\u0001\"\u0006\b\u008d\u0001\u0010\u008b\u0001R)\u0010\u008e\u0001\u001a\u00020&8\u0000@\u0000X\u0080\u000e\u00a2\u0006\u0018\n\u0006\b\u008e\u0001\u0010\u0087\u0001\u001a\u0006\b\u008f\u0001\u0010\u0089\u0001\"\u0006\b\u0090\u0001\u0010\u008b\u0001R)\u0010\u0091\u0001\u001a\u00020&8\u0000@\u0000X\u0080\u000e\u00a2\u0006\u0018\n\u0006\b\u0091\u0001\u0010\u0087\u0001\u001a\u0006\b\u0092\u0001\u0010\u0089\u0001\"\u0006\b\u0093\u0001\u0010\u008b\u0001R;\u0010\u0096\u0001\u001a$\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020G\u0018\u00010\u0094\u0001j\u0011\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020G\u0018\u0001`\u0095\u00018\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u0096\u0001\u0010\u0097\u0001R)\u0010\u0098\u0001\u001a\u00020&8\u0000@\u0000X\u0080\u000e\u00a2\u0006\u0018\n\u0006\b\u0098\u0001\u0010\u0087\u0001\u001a\u0006\b\u0099\u0001\u0010\u0089\u0001\"\u0006\b\u009a\u0001\u0010\u008b\u0001R\u0085\u0001\u0010\u009d\u0001\u001a^\u0012\u0004\u0012\u00020\f\u0012\u001f\u0012\u001d\u0012\u0013\u0012\u00110\u000f\u00a2\u0006\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b(\u0012\u0012\u0004\u0012\u00020\u00040\u000e\u0018\u00010\u009b\u0001j0\u0012\u0004\u0012\u00020\f\u0012#\u0012!\u0012\u0013\u0012\u00110\u000f\u00a2\u0006\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b(\u0012\u0012\u0004\u0012\u00020\u00040\u000ej\u0002`\u0013\u0018\u0001`\u009c\u00018\u0000@\u0000X\u0080\u000e\u00a2\u0006\u0018\n\u0006\b\u009d\u0001\u0010\u009e\u0001\u001a\u0006\b\u009f\u0001\u0010\u00a0\u0001\"\u0006\b\u00a1\u0001\u0010\u00a2\u0001R)\u0010b\u001a\u0004\u0018\u00010!8\u0000@\u0000X\u0080\u000e\u00a2\u0006\u0017\n\u0005\bb\u0010\u00a3\u0001\u001a\u0006\b\u00a4\u0001\u0010\u00a5\u0001\"\u0006\b\u00a6\u0001\u0010\u00a7\u0001\u00a8\u0006\u00aa\u0001"}, d2 = {"Lcom/tencent/kuikly/core/base/Attr;", "Lcom/tencent/kuikly/core/base/Props;", "Lcom/tencent/kuikly/core/base/attr/d;", "Lcom/tencent/kuikly/core/base/attr/c;", "", "viewDidRemove", "markToFlatLayerDisable", "beginApplyAttrProperty", "endApplyAttrProperty", "Lcom/tencent/kuikly/core/base/DeclarativeBaseView;", "view", "onViewLayoutFrameDidChanged", "", "taskKey", "Lkotlin/Function1;", "Lcom/tencent/kuikly/core/layout/d;", "Lkotlin/ParameterName;", "name", AIInput.KEY_FRAME, "Lcom/tencent/kuikly/core/base/FrameTask;", "frameTask", "setPropByFrameTask", "removePropFrameTask", "", "width", "height", "size", NodeProps.MAX_WIDTH, NodeProps.MAX_HEIGHT, "maxSize", NodeProps.MIN_WIDTH, NodeProps.MIN_HEIGHT, "minSize", "", NodeProps.Z_INDEX, "zIndexF", NodeProps.FLEX, "ratio", "", "matchHeightConstraintsFirst", "aspectFitLayout", "", "hexColor", "backgroundColor", "Lcom/tencent/kuikly/core/base/h;", "color", "Lcom/tencent/kuikly/core/base/Direction;", "direction", "", "Lcom/tencent/kuikly/core/base/j;", "colorStops", "backgroundLinearGradient", "(Lcom/tencent/kuikly/core/base/Direction;[Lcom/tencent/kuikly/core/base/j;)Lcom/tencent/kuikly/core/base/Attr;", "Lcom/tencent/kuikly/core/base/g;", "boxShadow", "useShadowPath", "Lcom/tencent/kuikly/core/base/f;", NodeProps.BORDER_RADIUS, "Lcom/tencent/kuikly/core/layout/FlexAlign;", "flexAlign", "alignContent", "topLeft", "topRight", "bottomLeft", "bottomRight", "allBorderRadius", "Lcom/tencent/kuikly/core/base/e;", "border", "visibility", "opacity", "touchEnable", "Lcom/tencent/kuikly/core/base/b;", "animation", "", "value", "animate", "Lcom/tencent/kuikly/core/base/t;", CanvasView.ACTION_ROTATE, "transform", "Lcom/tencent/kuikly/core/base/u;", "scale", "Lcom/tencent/kuikly/core/base/y;", CanvasView.ACTION_TRANSLATE, "Lcom/tencent/kuikly/core/base/x;", "skew", "Lcom/tencent/kuikly/core/base/a;", "anchor", "accessibility", "Lcom/tencent/kuikly/core/base/attr/AccessibilityRole;", "role", "accessibilityRole", "enable", "autoDarkEnable", "turboDisplayAutoUpdateEnable", "rasterizeEnable", "shouldRasterize", "touches", "minimumPanTouches", "panDirection", "top", "left", "bottom", "right", "Lcom/tencent/kuikly/core/layout/FlexPositionType;", "positionType", "Lcom/tencent/kuikly/core/base/s;", "percentage", "positionAbsolute", "positionRelative", "absolutePositionAllZero", "absolutePosition", NodeProps.ALIGN_SELF, "alignSelfCenter", "alignSelfFlexStart", "alignSelfFlexEnd", "alignSelfStretch", "margin", NodeProps.MARGIN_TOP, NodeProps.MARGIN_LEFT, NodeProps.MARGIN_BOTTOM, NodeProps.MARGIN_RIGHT, "all", "clipChild", "overflow", "debugName", "keepAlive", "disable", "lazyLoadViewDisable", "Lcom/tencent/kuikly/core/layout/FlexNode;", "flexNode", "Lcom/tencent/kuikly/core/layout/FlexNode;", "getFlexNode", "()Lcom/tencent/kuikly/core/layout/FlexNode;", "setFlexNode", "(Lcom/tencent/kuikly/core/layout/FlexNode;)V", "Z", "getKeepAlive", "()Z", "setKeepAlive", "(Z)V", "getLazyLoadViewDisable$core_release", "setLazyLoadViewDisable$core_release", "isStaticAttr", "isStaticAttr$core_release", "setStaticAttr$core_release", "flatLayerDisable", "getFlatLayerDisable$core_release", "setFlatLayerDisable$core_release", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "animationMap", "Ljava/util/HashMap;", "isBeginApplyAttrProperty", "isBeginApplyAttrProperty$core_release", "setBeginApplyAttrProperty$core_release", "Ljava/util/LinkedHashMap;", "Lkotlin/collections/LinkedHashMap;", "propSetByFrameTasks", "Ljava/util/LinkedHashMap;", "getPropSetByFrameTasks$core_release", "()Ljava/util/LinkedHashMap;", "setPropSetByFrameTasks$core_release", "(Ljava/util/LinkedHashMap;)V", "Ljava/lang/Integer;", "getPanDirection$core_release", "()Ljava/lang/Integer;", "setPanDirection$core_release", "(Ljava/lang/Integer;)V", "<init>", "()V", "core_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes33.dex */
public class Attr extends Props implements com.tencent.kuikly.core.base.attr.d, com.tencent.kuikly.core.base.attr.c {
    private HashMap<String, b> animationMap;
    private boolean flatLayerDisable;
    private FlexNode flexNode;
    private boolean isBeginApplyAttrProperty;
    private boolean isStaticAttr = true;
    private boolean keepAlive;
    private boolean lazyLoadViewDisable;
    private Integer panDirection;
    private LinkedHashMap<String, Function1<com.tencent.kuikly.core.layout.d, Unit>> propSetByFrameTasks;

    public final Attr absolutePosition(float top, float left, float bottom, float right) {
        positionAbsolute();
        FloatCompanionObject floatCompanionObject = FloatCompanionObject.INSTANCE;
        boolean z16 = true;
        if (!(Float.isNaN(top) || Float.isNaN(Float.NaN) ? Float.isNaN(top) && Float.isNaN(Float.NaN) : Math.abs(Float.NaN - top) < 1.0E-5f)) {
            m150top(top);
        }
        if (!(Float.isNaN(left) || Float.isNaN(Float.NaN) ? Float.isNaN(left) && Float.isNaN(Float.NaN) : Math.abs(Float.NaN - left) < 1.0E-5f)) {
            m142left(left);
        }
        if (!(Float.isNaN(bottom) || Float.isNaN(Float.NaN) ? Float.isNaN(bottom) && Float.isNaN(Float.NaN) : Math.abs(Float.NaN - bottom) < 1.0E-5f)) {
            m138bottom(bottom);
        }
        if (Float.isNaN(right) || Float.isNaN(Float.NaN) ? !Float.isNaN(right) || !Float.isNaN(Float.NaN) : Math.abs(Float.NaN - right) >= 1.0E-5f) {
            z16 = false;
        }
        if (!z16) {
            m149right(right);
        }
        return this;
    }

    public com.tencent.kuikly.core.base.attr.d accessibility(String accessibility) {
        Intrinsics.checkNotNullParameter(accessibility, "accessibility");
        with("accessibility", accessibility);
        return this;
    }

    public com.tencent.kuikly.core.base.attr.d accessibilityRole(AccessibilityRole role) {
        Intrinsics.checkNotNullParameter(role, "role");
        with("accessibilityRole", role.getRoleName());
        return this;
    }

    public final Attr alignContent(FlexAlign flexAlign) {
        Intrinsics.checkNotNullParameter(flexAlign, "flexAlign");
        FlexNode flexNode = this.flexNode;
        if (flexNode != null) {
            flexNode.j0(flexAlign);
        }
        return this;
    }

    public final Attr alignSelfCenter() {
        m133alignSelf(FlexAlign.CENTER);
        return this;
    }

    public final Attr alignSelfFlexEnd() {
        m133alignSelf(FlexAlign.FLEX_END);
        return this;
    }

    public final Attr alignSelfFlexStart() {
        m133alignSelf(FlexAlign.FLEX_START);
        return this;
    }

    public final Attr alignSelfStretch() {
        m133alignSelf(FlexAlign.STRETCH);
        return this;
    }

    public com.tencent.kuikly.core.base.attr.d animate(b animation, Object value) {
        Intrinsics.checkNotNullParameter(animation, "animation");
        Intrinsics.checkNotNullParameter(value, "value");
        String currentObservablePropertyKey = com.tencent.kuikly.core.manager.c.f117352a.i().getCurrentObservablePropertyKey();
        if (currentObservablePropertyKey == null) {
            currentObservablePropertyKey = "";
        }
        if (currentObservablePropertyKey.length() == 0) {
            return this;
        }
        HashMap<String, b> hashMap = this.animationMap;
        if ((hashMap != null ? hashMap.get(currentObservablePropertyKey) : null) != null) {
            PagerNotFoundExceptionKt.a("\u4e0d\u652f\u6301\u65b0\u65e7\u52a8\u753b\u63a5\u53e3\u540c\u65f6\u5b58\u5728\uff08animation\u3001animate\uff09\uff0c\u8bf7\u7edf\u4e00\u5207\u6362\u5230\u65b0\u7684\u52a8\u753b\u63a5\u53e3");
            return this;
        }
        if (getPager().getAnimationManager() == null) {
            getPager().setAnimationManager(new AnimationManager());
        }
        AnimationManager animationManager = getPager().getAnimationManager();
        if (animationManager != null) {
            int nativeRef = getNativeRef();
            FlexNode flexNode = this.flexNode;
            animationManager.k(currentObservablePropertyKey, nativeRef, animation, flexNode != null ? flexNode.getIsDirty() : false);
        }
        return this;
    }

    public final void aspectFitLayout(final float ratio, final boolean matchHeightConstraintsFirst) {
        setPropByFrameTask("aspectFitLayout", new Function1<com.tencent.kuikly.core.layout.d, Unit>() { // from class: com.tencent.kuikly.core.base.Attr$aspectFitLayout$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(com.tencent.kuikly.core.layout.d dVar) {
                invoke2(dVar);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(final com.tencent.kuikly.core.layout.d it) {
                Intrinsics.checkNotNullParameter(it, "it");
                FlexNode flexNode = Attr.this.getFlexNode();
                if (flexNode != null) {
                    flexNode.m0(0.0f);
                }
                if (matchHeightConstraintsFirst) {
                    if (!(it.getHeight() == 0.0f)) {
                        com.tencent.kuikly.core.pager.b pager = Attr.this.getPager();
                        final Attr attr = Attr.this;
                        final float f16 = ratio;
                        pager.addTaskWhenPagerUpdateLayoutFinish(new Function0<Unit>() { // from class: com.tencent.kuikly.core.base.Attr$aspectFitLayout$1.1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(0);
                            }

                            @Override // kotlin.jvm.functions.Function0
                            public /* bridge */ /* synthetic */ Unit invoke() {
                                invoke2();
                                return Unit.INSTANCE;
                            }

                            /* renamed from: invoke, reason: avoid collision after fix types in other method */
                            public final void invoke2() {
                                Attr.this.mo153width(it.getHeight() * f16);
                            }
                        });
                        return;
                    }
                }
                if (!(it.getWidth() == 0.0f)) {
                    com.tencent.kuikly.core.pager.b pager2 = Attr.this.getPager();
                    final Attr attr2 = Attr.this;
                    final float f17 = ratio;
                    pager2.addTaskWhenPagerUpdateLayoutFinish(new Function0<Unit>() { // from class: com.tencent.kuikly.core.base.Attr$aspectFitLayout$1.2
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(0);
                        }

                        @Override // kotlin.jvm.functions.Function0
                        public /* bridge */ /* synthetic */ Unit invoke() {
                            invoke2();
                            return Unit.INSTANCE;
                        }

                        /* renamed from: invoke, reason: avoid collision after fix types in other method */
                        public final void invoke2() {
                            Attr.this.mo141height(it.getWidth() / f17);
                        }
                    });
                    return;
                }
                if (it.getHeight() == 0.0f) {
                    return;
                }
                com.tencent.kuikly.core.pager.b pager3 = Attr.this.getPager();
                final Attr attr3 = Attr.this;
                final float f18 = ratio;
                pager3.addTaskWhenPagerUpdateLayoutFinish(new Function0<Unit>() { // from class: com.tencent.kuikly.core.base.Attr$aspectFitLayout$1.3
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(0);
                    }

                    @Override // kotlin.jvm.functions.Function0
                    public /* bridge */ /* synthetic */ Unit invoke() {
                        invoke2();
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2() {
                        Attr.this.mo153width(it.getHeight() * f18);
                    }
                });
            }
        });
    }

    public com.tencent.kuikly.core.base.attr.d autoDarkEnable(boolean enable) {
        with("autoDarkEnable", Integer.valueOf(d.b(enable)));
        return this;
    }

    public final void beginApplyAttrProperty() {
        HashMap<String, b> hashMap = this.animationMap;
        if (hashMap != null) {
            String currentChangingPropertyKey = com.tencent.kuikly.core.manager.c.f117352a.i().getCurrentChangingPropertyKey();
            if (currentChangingPropertyKey == null) {
                currentChangingPropertyKey = "";
            }
            b bVar = hashMap.get(currentChangingPropertyKey);
            if (bVar != null) {
                this.isBeginApplyAttrProperty = true;
                setProp("animation", bVar.toString());
            }
        }
        AnimationManager animationManager = getPager().getAnimationManager();
        if (animationManager != null) {
            animationManager.l(getNativeRef(), new Function1<b, Unit>() { // from class: com.tencent.kuikly.core.base.Attr$beginApplyAttrProperty$2
                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(b bVar2) {
                    invoke2(bVar2);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(b bVar2) {
                    if (bVar2 != null) {
                        Attr attr = Attr.this;
                        attr.setBeginApplyAttrProperty$core_release(true);
                        attr.setProp("animation", bVar2.toString());
                    }
                }
            });
        }
    }

    public final Attr debugName(String debugName) {
        Intrinsics.checkNotNullParameter(debugName, "debugName");
        with("debugName", debugName);
        return this;
    }

    public final void endApplyAttrProperty() {
        if (this.isBeginApplyAttrProperty) {
            boolean z16 = false;
            this.isBeginApplyAttrProperty = false;
            FlexNode flexNode = this.flexNode;
            if (flexNode != null && flexNode.getIsDirty()) {
                z16 = true;
            }
            if (z16) {
                getPager().onLayoutView();
            }
            setProp("animation", "");
            AnimationManager animationManager = getPager().getAnimationManager();
            if (animationManager != null) {
                animationManager.e(getNativeRef());
            }
        }
    }

    /* renamed from: getFlatLayerDisable$core_release, reason: from getter */
    public final boolean getFlatLayerDisable() {
        return this.flatLayerDisable;
    }

    public final FlexNode getFlexNode() {
        return this.flexNode;
    }

    public final boolean getKeepAlive() {
        return this.keepAlive;
    }

    /* renamed from: getLazyLoadViewDisable$core_release, reason: from getter */
    public final boolean getLazyLoadViewDisable() {
        return this.lazyLoadViewDisable;
    }

    /* renamed from: getPanDirection$core_release, reason: from getter */
    public final Integer getPanDirection() {
        return this.panDirection;
    }

    public final LinkedHashMap<String, Function1<com.tencent.kuikly.core.layout.d, Unit>> getPropSetByFrameTasks$core_release() {
        return this.propSetByFrameTasks;
    }

    /* renamed from: isBeginApplyAttrProperty$core_release, reason: from getter */
    public final boolean getIsBeginApplyAttrProperty() {
        return this.isBeginApplyAttrProperty;
    }

    /* renamed from: isStaticAttr$core_release, reason: from getter */
    public final boolean getIsStaticAttr() {
        return this.isStaticAttr;
    }

    public final void keepAlive(boolean keepAlive) {
        this.keepAlive = keepAlive;
    }

    public final void lazyLoadViewDisable(boolean disable) {
        this.lazyLoadViewDisable = disable;
    }

    public final Attr maxSize(float maxWidth, float maxHeight) {
        FloatCompanionObject floatCompanionObject = FloatCompanionObject.INSTANCE;
        boolean z16 = true;
        if (!(Float.isNaN(maxWidth) || Float.isNaN(Float.NaN) ? Float.isNaN(maxWidth) && Float.isNaN(Float.NaN) : Math.abs(Float.NaN - maxWidth) < 1.0E-5f)) {
            m144maxWidth(maxWidth);
        }
        if (Float.isNaN(maxHeight) || Float.isNaN(Float.NaN) ? !Float.isNaN(maxHeight) || !Float.isNaN(Float.NaN) : Math.abs(Float.NaN - maxHeight) >= 1.0E-5f) {
            z16 = false;
        }
        if (!z16) {
            m143maxHeight(maxHeight);
        }
        return this;
    }

    public final Attr minSize(float minWidth, float minHeight) {
        FloatCompanionObject floatCompanionObject = FloatCompanionObject.INSTANCE;
        boolean z16 = true;
        if (!(Float.isNaN(minWidth) || Float.isNaN(Float.NaN) ? Float.isNaN(minWidth) && Float.isNaN(Float.NaN) : Math.abs(Float.NaN - minWidth) < 1.0E-5f)) {
            m146minWidth(minWidth);
        }
        if (Float.isNaN(minHeight) || Float.isNaN(Float.NaN) ? !Float.isNaN(minHeight) || !Float.isNaN(Float.NaN) : Math.abs(Float.NaN - minHeight) >= 1.0E-5f) {
            z16 = false;
        }
        if (!z16) {
            m145minHeight(minHeight);
        }
        return this;
    }

    public void minimumPanTouches(int touches) {
        with("minimumPanTouches", Integer.valueOf(touches));
    }

    /* JADX WARN: Code restructure failed: missing block: B:5:0x0016, code lost:
    
        r0 = kotlin.collections.MapsKt__MapsKt.toMap(r0);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void onViewLayoutFrameDidChanged(DeclarativeBaseView<?, ?> view) {
        Map map;
        Intrinsics.checkNotNullParameter(view, "view");
        if (this.propSetByFrameTasks != null) {
            com.tencent.kuikly.core.layout.d layoutFrame = view.getFlexNode().getLayoutFrame();
            LinkedHashMap<String, Function1<com.tencent.kuikly.core.layout.d, Unit>> linkedHashMap = this.propSetByFrameTasks;
            if (linkedHashMap == null || map == null) {
                return;
            }
            Iterator it = map.entrySet().iterator();
            while (it.hasNext()) {
                ((Function1) ((Map.Entry) it.next()).getValue()).invoke(layoutFrame);
            }
        }
    }

    public final Attr overflow(boolean clipChild) {
        with("overflow", Integer.valueOf(d.b(clipChild)));
        return this;
    }

    public void panDirection(int direction) {
        this.panDirection = Integer.valueOf(direction);
        with("panDirection", Integer.valueOf(direction));
    }

    public final Attr positionAbsolute() {
        m148positionType(FlexPositionType.ABSOLUTE);
        return this;
    }

    public final Attr positionRelative() {
        m148positionType(FlexPositionType.RELATIVE);
        return this;
    }

    public final void removePropFrameTask(String taskKey) {
        Intrinsics.checkNotNullParameter(taskKey, "taskKey");
        LinkedHashMap<String, Function1<com.tencent.kuikly.core.layout.d, Unit>> linkedHashMap = this.propSetByFrameTasks;
        if (linkedHashMap != null) {
            linkedHashMap.remove(taskKey);
        }
    }

    public final void setBeginApplyAttrProperty$core_release(boolean z16) {
        this.isBeginApplyAttrProperty = z16;
    }

    public final void setFlatLayerDisable$core_release(boolean z16) {
        this.flatLayerDisable = z16;
    }

    public final void setFlexNode(FlexNode flexNode) {
        this.flexNode = flexNode;
    }

    public final void setKeepAlive(boolean z16) {
        this.keepAlive = z16;
    }

    public final void setLazyLoadViewDisable$core_release(boolean z16) {
        this.lazyLoadViewDisable = z16;
    }

    public final void setPanDirection$core_release(Integer num) {
        this.panDirection = num;
    }

    public final void setPropByFrameTask(String taskKey, Function1<? super com.tencent.kuikly.core.layout.d, Unit> frameTask) {
        com.tencent.kuikly.core.layout.d a16;
        com.tencent.kuikly.core.layout.d layoutFrame;
        Intrinsics.checkNotNullParameter(taskKey, "taskKey");
        Intrinsics.checkNotNullParameter(frameTask, "frameTask");
        FlexNode flexNode = this.flexNode;
        boolean z16 = false;
        if (flexNode != null && (layoutFrame = flexNode.getLayoutFrame()) != null && !layoutFrame.f()) {
            z16 = true;
        }
        if (z16) {
            FlexNode flexNode2 = this.flexNode;
            if (flexNode2 == null || (a16 = flexNode2.getLayoutFrame()) == null) {
                a16 = com.tencent.kuikly.core.layout.d.INSTANCE.a();
            }
            frameTask.invoke(a16);
        }
        if (this.propSetByFrameTasks == null) {
            this.propSetByFrameTasks = new LinkedHashMap<>();
        }
        LinkedHashMap<String, Function1<com.tencent.kuikly.core.layout.d, Unit>> linkedHashMap = this.propSetByFrameTasks;
        if (linkedHashMap != null) {
            linkedHashMap.put(taskKey, frameTask);
        }
    }

    public final void setPropSetByFrameTasks$core_release(LinkedHashMap<String, Function1<com.tencent.kuikly.core.layout.d, Unit>> linkedHashMap) {
        this.propSetByFrameTasks = linkedHashMap;
    }

    public final void setStaticAttr$core_release(boolean z16) {
        this.isStaticAttr = z16;
    }

    public com.tencent.kuikly.core.base.attr.d shouldRasterize(boolean rasterizeEnable) {
        with("shouldRasterize", Integer.valueOf(d.b(rasterizeEnable)));
        return this;
    }

    public final Attr size(float width, float height) {
        FloatCompanionObject floatCompanionObject = FloatCompanionObject.INSTANCE;
        boolean z16 = true;
        if (!(Float.isNaN(width) || Float.isNaN(Float.NaN) ? Float.isNaN(width) && Float.isNaN(Float.NaN) : Math.abs(Float.NaN - width) < 1.0E-5f)) {
            mo153width(width);
        }
        if (Float.isNaN(height) || Float.isNaN(Float.NaN) ? !Float.isNaN(height) || !Float.isNaN(Float.NaN) : Math.abs(Float.NaN - height) >= 1.0E-5f) {
            z16 = false;
        }
        if (!z16) {
            mo141height(height);
        }
        return this;
    }

    public com.tencent.kuikly.core.base.attr.d turboDisplayAutoUpdateEnable(boolean enable) {
        with("turboDisplayAutoUpdateEnable", Integer.valueOf(d.b(enable)));
        return this;
    }

    @Override // com.tencent.kuikly.core.base.Props
    public void viewDidRemove() {
        super.viewDidRemove();
        this.flexNode = null;
        HashMap<String, b> hashMap = this.animationMap;
        if (hashMap != null) {
            hashMap.clear();
        }
        LinkedHashMap<String, Function1<com.tencent.kuikly.core.layout.d, Unit>> linkedHashMap = this.propSetByFrameTasks;
        if (linkedHashMap != null) {
            linkedHashMap.clear();
        }
        AnimationManager animationManager = getPager().getAnimationManager();
        if (animationManager != null) {
            animationManager.a(getNativeRef());
        }
    }

    public final Attr zIndexF(float zIndex) {
        with(NodeProps.Z_INDEX, Float.valueOf(zIndex));
        return this;
    }

    public final void absolutePositionAllZero() {
        absolutePosition(0.0f, 0.0f, 0.0f, 0.0f);
    }

    /* renamed from: alignSelf, reason: merged with bridge method [inline-methods] */
    public Attr m133alignSelf(FlexAlign alignSelf) {
        Intrinsics.checkNotNullParameter(alignSelf, "alignSelf");
        FlexNode flexNode = this.flexNode;
        if (flexNode != null) {
            flexNode.l0(alignSelf);
        }
        return this;
    }

    /* renamed from: animation, reason: merged with bridge method [inline-methods] */
    public Attr m134animation(b animation, Object value) {
        Intrinsics.checkNotNullParameter(animation, "animation");
        Intrinsics.checkNotNullParameter(value, "value");
        if (this.animationMap == null) {
            this.animationMap = new HashMap<>();
        }
        String currentObservablePropertyKey = com.tencent.kuikly.core.manager.c.f117352a.i().getCurrentObservablePropertyKey();
        if (currentObservablePropertyKey == null) {
            currentObservablePropertyKey = "";
        }
        if (currentObservablePropertyKey.length() == 0) {
            return this;
        }
        HashMap<String, b> hashMap = this.animationMap;
        Intrinsics.checkNotNull(hashMap);
        hashMap.put(currentObservablePropertyKey, animation);
        return this;
    }

    public final Attr backgroundColor(long hexColor) {
        mo113backgroundColor(new h(hexColor));
        return this;
    }

    @Override // 
    /* renamed from: backgroundLinearGradient, reason: merged with bridge method [inline-methods] */
    public Attr mo135backgroundLinearGradient(Direction direction, j... colorStops) {
        Intrinsics.checkNotNullParameter(direction, "direction");
        Intrinsics.checkNotNullParameter(colorStops, "colorStops");
        String str = "linear-gradient(" + direction.ordinal();
        for (j jVar : colorStops) {
            str = str + ',' + jVar;
        }
        with("backgroundImage", str + ')');
        return this;
    }

    /* renamed from: border, reason: merged with bridge method [inline-methods] */
    public Attr m136border(e border) {
        Intrinsics.checkNotNullParameter(border, "border");
        with("border", border.toString());
        return this;
    }

    /* renamed from: borderRadius, reason: merged with bridge method [inline-methods] */
    public Attr m137borderRadius(final f borderRadius) {
        Intrinsics.checkNotNullParameter(borderRadius, "borderRadius");
        setPropByFrameTask(NodeProps.BORDER_RADIUS, new Function1<com.tencent.kuikly.core.layout.d, Unit>() { // from class: com.tencent.kuikly.core.base.Attr$borderRadius$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(com.tencent.kuikly.core.layout.d dVar) {
                invoke2(dVar);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(com.tencent.kuikly.core.layout.d frame) {
                Intrinsics.checkNotNullParameter(frame, "frame");
                float min = Math.min(frame.getWidth(), frame.getHeight()) / 2.0f;
                if (Float.isNaN(min)) {
                    return;
                }
                this.with(NodeProps.BORDER_RADIUS, new f(Math.min(min, f.this.getTopLeftCornerRadius()), Math.min(min, f.this.getTopRightCornerRadius()), Math.min(min, f.this.getBottomLeftCornerRadius()), Math.min(min, f.this.getBottomRightCornerRadius())).toString());
            }
        });
        if (!getPropsMap().containsKey(NodeProps.BORDER_RADIUS)) {
            with(NodeProps.BORDER_RADIUS, new f(0.0f, 0.0f, 0.0f, 0.0f).toString());
        }
        return this;
    }

    /* renamed from: bottom, reason: merged with bridge method [inline-methods] */
    public Attr m138bottom(float bottom) {
        FlexNode flexNode = this.flexNode;
        if (flexNode != null) {
            flexNode.S0(FlexLayout.PositionType.POSITION_BOTTOM, bottom);
        }
        return this;
    }

    @Override // 
    /* renamed from: boxShadow, reason: merged with bridge method [inline-methods] */
    public Attr mo139boxShadow(g boxShadow) {
        Intrinsics.checkNotNullParameter(boxShadow, "boxShadow");
        with("boxShadow", boxShadow.toString());
        return this;
    }

    /* renamed from: flex, reason: merged with bridge method [inline-methods] */
    public Attr m140flex(float flex) {
        FlexNode flexNode = this.flexNode;
        if (flexNode != null) {
            flexNode.m0(flex);
        }
        return this;
    }

    @Override // 
    /* renamed from: height, reason: merged with bridge method [inline-methods] */
    public Attr mo141height(float height) {
        FlexNode flexNode = this.flexNode;
        if (flexNode != null) {
            flexNode.L0(height);
        }
        return this;
    }

    /* renamed from: left, reason: merged with bridge method [inline-methods] */
    public Attr m142left(float left) {
        FlexNode flexNode = this.flexNode;
        if (flexNode != null) {
            flexNode.S0(FlexLayout.PositionType.POSITION_LEFT, left);
        }
        return this;
    }

    @Override // com.tencent.kuikly.core.base.attr.c
    public Attr margin(float top, float left, float bottom, float right) {
        FlexNode flexNode;
        FlexNode flexNode2;
        FlexNode flexNode3;
        FlexNode flexNode4;
        FloatCompanionObject floatCompanionObject = FloatCompanionObject.INSTANCE;
        boolean z16 = true;
        if (!(Float.isNaN(top) || Float.isNaN(Float.NaN) ? Float.isNaN(top) && Float.isNaN(Float.NaN) : Math.abs(Float.NaN - top) < 1.0E-5f) && (flexNode4 = this.flexNode) != null) {
            flexNode4.A0(StyleSpace.Type.TOP, top);
        }
        if (!(Float.isNaN(left) || Float.isNaN(Float.NaN) ? Float.isNaN(left) && Float.isNaN(Float.NaN) : Math.abs(Float.NaN - left) < 1.0E-5f) && (flexNode3 = this.flexNode) != null) {
            flexNode3.A0(StyleSpace.Type.LEFT, left);
        }
        if (!(Float.isNaN(bottom) || Float.isNaN(Float.NaN) ? Float.isNaN(bottom) && Float.isNaN(Float.NaN) : Math.abs(Float.NaN - bottom) < 1.0E-5f) && (flexNode2 = this.flexNode) != null) {
            flexNode2.A0(StyleSpace.Type.BOTTOM, bottom);
        }
        if (Float.isNaN(right) || Float.isNaN(Float.NaN) ? !Float.isNaN(right) || !Float.isNaN(Float.NaN) : Math.abs(Float.NaN - right) >= 1.0E-5f) {
            z16 = false;
        }
        if (!z16 && (flexNode = this.flexNode) != null) {
            flexNode.A0(StyleSpace.Type.RIGHT, right);
        }
        return this;
    }

    public final void markToFlatLayerDisable() {
        this.flatLayerDisable = true;
    }

    /* renamed from: maxHeight, reason: merged with bridge method [inline-methods] */
    public Attr m143maxHeight(float maxHeight) {
        FlexNode flexNode = this.flexNode;
        if (flexNode != null) {
            flexNode.M0(maxHeight);
        }
        return this;
    }

    /* renamed from: maxWidth, reason: merged with bridge method [inline-methods] */
    public Attr m144maxWidth(float maxWidth) {
        FlexNode flexNode = this.flexNode;
        if (flexNode != null) {
            flexNode.N0(maxWidth);
        }
        return this;
    }

    /* renamed from: minHeight, reason: merged with bridge method [inline-methods] */
    public Attr m145minHeight(float minHeight) {
        FlexNode flexNode = this.flexNode;
        if (flexNode != null) {
            flexNode.O0(minHeight);
        }
        return this;
    }

    /* renamed from: minWidth, reason: merged with bridge method [inline-methods] */
    public Attr m146minWidth(float minWidth) {
        FlexNode flexNode = this.flexNode;
        if (flexNode != null) {
            flexNode.P0(minWidth);
        }
        return this;
    }

    /* renamed from: opacity, reason: merged with bridge method [inline-methods] */
    public Attr m147opacity(float opacity) {
        with("opacity", Float.valueOf(opacity));
        return this;
    }

    /* renamed from: positionType, reason: merged with bridge method [inline-methods] */
    public Attr m148positionType(FlexPositionType positionType) {
        Intrinsics.checkNotNullParameter(positionType, "positionType");
        FlexNode flexNode = this.flexNode;
        if (flexNode != null) {
            flexNode.I0(positionType);
        }
        return this;
    }

    /* renamed from: right, reason: merged with bridge method [inline-methods] */
    public Attr m149right(float right) {
        FlexNode flexNode = this.flexNode;
        if (flexNode != null) {
            flexNode.S0(FlexLayout.PositionType.POSITION_RIGHT, right);
        }
        return this;
    }

    /* renamed from: top, reason: merged with bridge method [inline-methods] */
    public Attr m150top(float top) {
        FlexNode flexNode = this.flexNode;
        if (flexNode != null) {
            flexNode.S0(FlexLayout.PositionType.POSITION_TOP, top);
        }
        return this;
    }

    /* renamed from: touchEnable, reason: merged with bridge method [inline-methods] */
    public Attr m151touchEnable(boolean touchEnable) {
        with("touchEnable", Integer.valueOf(d.b(touchEnable)));
        return this;
    }

    public final Attr transform(t rotate) {
        Intrinsics.checkNotNullParameter(rotate, "rotate");
        return (Attr) d.a.a(this, rotate, u.INSTANCE.a(), y.INSTANCE.a(), a.INSTANCE.a(), null, 16, null);
    }

    /* renamed from: visibility, reason: merged with bridge method [inline-methods] */
    public Attr m152visibility(boolean visibility) {
        with("visibility", Integer.valueOf(d.b(visibility)));
        return this;
    }

    @Override // 
    /* renamed from: width, reason: merged with bridge method [inline-methods] */
    public Attr mo153width(float width) {
        FlexNode flexNode = this.flexNode;
        if (flexNode != null) {
            flexNode.U0(width);
        }
        return this;
    }

    /* renamed from: zIndex, reason: merged with bridge method [inline-methods] */
    public Attr m154zIndex(int zIndex) {
        zIndexF(zIndex);
        return this;
    }

    @Override // 
    /* renamed from: backgroundColor, reason: merged with bridge method [inline-methods] */
    public Attr mo113backgroundColor(h color) {
        Intrinsics.checkNotNullParameter(color, "color");
        with("backgroundColor", color.toString());
        return this;
    }

    public final void bottom(final s percentage) {
        Intrinsics.checkNotNullParameter(percentage, "percentage");
        FlexNode flexNode = this.flexNode;
        if (flexNode != null) {
            flexNode.b0();
        }
        getPager().addTaskWhenPagerUpdateLayoutFinish(new Function0<Unit>() { // from class: com.tencent.kuikly.core.base.Attr$bottom$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                FlexNode flexNode2;
                com.tencent.kuikly.core.layout.d layoutFrame;
                FlexNode flexNode3 = Attr.this.getFlexNode();
                if (flexNode3 != null) {
                    flexNode3.c0();
                }
                FlexNode flexNode4 = Attr.this.getFlexNode();
                if (flexNode4 == null || (flexNode2 = flexNode4.getCom.tencent.mtt.hippy.views.common.HippyNestedScrollComponent.PRIORITY_PARENT java.lang.String()) == null || (layoutFrame = flexNode2.getLayoutFrame()) == null) {
                    return;
                }
                Attr.this.m138bottom(Float.valueOf(layoutFrame.getHeight()).floatValue() * percentage.a());
            }
        });
    }

    public final Attr boxShadow(g boxShadow, boolean useShadowPath) {
        Intrinsics.checkNotNullParameter(boxShadow, "boxShadow");
        if (useShadowPath) {
            with("useShadowPath", Integer.valueOf(d.b(useShadowPath)));
        }
        with("boxShadow", boxShadow.toString());
        return this;
    }

    public final void left(final s percentage) {
        Intrinsics.checkNotNullParameter(percentage, "percentage");
        FlexNode flexNode = this.flexNode;
        if (flexNode != null) {
            flexNode.b0();
        }
        getPager().addTaskWhenPagerUpdateLayoutFinish(new Function0<Unit>() { // from class: com.tencent.kuikly.core.base.Attr$left$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                FlexNode flexNode2;
                com.tencent.kuikly.core.layout.d layoutFrame;
                FlexNode flexNode3 = Attr.this.getFlexNode();
                if (flexNode3 != null) {
                    flexNode3.c0();
                }
                FlexNode flexNode4 = Attr.this.getFlexNode();
                if (flexNode4 == null || (flexNode2 = flexNode4.getCom.tencent.mtt.hippy.views.common.HippyNestedScrollComponent.PRIORITY_PARENT java.lang.String()) == null || (layoutFrame = flexNode2.getLayoutFrame()) == null) {
                    return;
                }
                Attr.this.m142left(Float.valueOf(layoutFrame.getWidth()).floatValue() * percentage.a());
            }
        });
    }

    public final void right(final s percentage) {
        Intrinsics.checkNotNullParameter(percentage, "percentage");
        FlexNode flexNode = this.flexNode;
        if (flexNode != null) {
            flexNode.b0();
        }
        getPager().addTaskWhenPagerUpdateLayoutFinish(new Function0<Unit>() { // from class: com.tencent.kuikly.core.base.Attr$right$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                FlexNode flexNode2;
                com.tencent.kuikly.core.layout.d layoutFrame;
                FlexNode flexNode3 = Attr.this.getFlexNode();
                if (flexNode3 != null) {
                    flexNode3.c0();
                }
                FlexNode flexNode4 = Attr.this.getFlexNode();
                if (flexNode4 == null || (flexNode2 = flexNode4.getCom.tencent.mtt.hippy.views.common.HippyNestedScrollComponent.PRIORITY_PARENT java.lang.String()) == null || (layoutFrame = flexNode2.getLayoutFrame()) == null) {
                    return;
                }
                Attr.this.m149right(Float.valueOf(layoutFrame.getWidth()).floatValue() * percentage.a());
            }
        });
    }

    public final void top(final s percentage) {
        Intrinsics.checkNotNullParameter(percentage, "percentage");
        FlexNode flexNode = this.flexNode;
        if (flexNode != null) {
            flexNode.b0();
        }
        getPager().addTaskWhenPagerUpdateLayoutFinish(new Function0<Unit>() { // from class: com.tencent.kuikly.core.base.Attr$top$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                FlexNode flexNode2;
                com.tencent.kuikly.core.layout.d layoutFrame;
                FlexNode flexNode3 = Attr.this.getFlexNode();
                if (flexNode3 != null) {
                    flexNode3.c0();
                }
                FlexNode flexNode4 = Attr.this.getFlexNode();
                if (flexNode4 == null || (flexNode2 = flexNode4.getCom.tencent.mtt.hippy.views.common.HippyNestedScrollComponent.PRIORITY_PARENT java.lang.String()) == null || (layoutFrame = flexNode2.getLayoutFrame()) == null) {
                    return;
                }
                Attr.this.m150top(Float.valueOf(layoutFrame.getHeight()).floatValue() * percentage.a());
            }
        });
    }

    public final Attr borderRadius(float topLeft, float topRight, float bottomLeft, float bottomRight) {
        m137borderRadius(new f(topLeft, topRight, bottomLeft, bottomRight));
        return this;
    }

    public final Attr transform(u scale) {
        Intrinsics.checkNotNullParameter(scale, "scale");
        return (Attr) d.a.a(this, t.INSTANCE.a(), scale, y.INSTANCE.a(), a.INSTANCE.a(), null, 16, null);
    }

    public final Attr borderRadius(float allBorderRadius) {
        m137borderRadius(new f(allBorderRadius, allBorderRadius, allBorderRadius, allBorderRadius));
        return this;
    }

    public static /* synthetic */ void aspectFitLayout$default(Attr attr, float f16, boolean z16, int i3, Object obj) {
        if (obj == null) {
            if ((i3 & 2) != 0) {
                z16 = false;
            }
            attr.aspectFitLayout(f16, z16);
            return;
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: aspectFitLayout");
    }

    public static /* synthetic */ Attr boxShadow$default(Attr attr, g gVar, boolean z16, int i3, Object obj) {
        if (obj == null) {
            if ((i3 & 2) != 0) {
                z16 = false;
            }
            return attr.boxShadow(gVar, z16);
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: boxShadow");
    }

    public static /* synthetic */ void lazyLoadViewDisable$default(Attr attr, boolean z16, int i3, Object obj) {
        if (obj == null) {
            if ((i3 & 1) != 0) {
                z16 = false;
            }
            attr.lazyLoadViewDisable(z16);
            return;
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: lazyLoadViewDisable");
    }

    public static /* synthetic */ void minimumPanTouches$default(Attr attr, int i3, int i16, Object obj) {
        if (obj == null) {
            if ((i16 & 1) != 0) {
                i3 = 1;
            }
            attr.minimumPanTouches(i3);
            return;
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: minimumPanTouches");
    }

    public final Attr marginRight(float right) {
        c.a.a(this, 0.0f, 0.0f, 0.0f, right, 7, null);
        return this;
    }

    public static /* synthetic */ Attr absolutePosition$default(Attr attr, float f16, float f17, float f18, float f19, int i3, Object obj) {
        if (obj == null) {
            if ((i3 & 1) != 0) {
                FloatCompanionObject floatCompanionObject = FloatCompanionObject.INSTANCE;
                f16 = Float.NaN;
            }
            if ((i3 & 2) != 0) {
                FloatCompanionObject floatCompanionObject2 = FloatCompanionObject.INSTANCE;
                f17 = Float.NaN;
            }
            if ((i3 & 4) != 0) {
                FloatCompanionObject floatCompanionObject3 = FloatCompanionObject.INSTANCE;
                f18 = Float.NaN;
            }
            if ((i3 & 8) != 0) {
                FloatCompanionObject floatCompanionObject4 = FloatCompanionObject.INSTANCE;
                f19 = Float.NaN;
            }
            return attr.absolutePosition(f16, f17, f18, f19);
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: absolutePosition");
    }

    public final Attr marginBottom(float bottom) {
        c.a.a(this, 0.0f, 0.0f, bottom, 0.0f, 11, null);
        return this;
    }

    public final Attr marginLeft(float left) {
        c.a.a(this, 0.0f, left, 0.0f, 0.0f, 13, null);
        return this;
    }

    public final Attr marginTop(float top) {
        c.a.a(this, top, 0.0f, 0.0f, 0.0f, 14, null);
        return this;
    }

    public final Attr size(float size) {
        FloatCompanionObject floatCompanionObject = FloatCompanionObject.INSTANCE;
        boolean z16 = true;
        if (Float.isNaN(size) || Float.isNaN(Float.NaN) ? !Float.isNaN(size) || !Float.isNaN(Float.NaN) : Math.abs(Float.NaN - size) >= 1.0E-5f) {
            z16 = false;
        }
        if (!z16) {
            mo153width(size);
            mo141height(size);
        }
        return this;
    }

    public final Attr transform(y translate) {
        Intrinsics.checkNotNullParameter(translate, "translate");
        return (Attr) d.a.a(this, t.INSTANCE.a(), u.INSTANCE.a(), translate, a.INSTANCE.a(), null, 16, null);
    }

    public final Attr transform(x skew) {
        Intrinsics.checkNotNullParameter(skew, "skew");
        return transform(t.INSTANCE.a(), u.INSTANCE.a(), y.INSTANCE.a(), a.INSTANCE.a(), skew);
    }

    public final Attr margin(float all) {
        margin(all, all, all, all);
        return this;
    }

    @Override // com.tencent.kuikly.core.base.attr.d
    public Attr transform(final t rotate, final u scale, final y translate, final a anchor, final x skew) {
        Intrinsics.checkNotNullParameter(rotate, "rotate");
        Intrinsics.checkNotNullParameter(scale, "scale");
        Intrinsics.checkNotNullParameter(translate, "translate");
        Intrinsics.checkNotNullParameter(anchor, "anchor");
        Intrinsics.checkNotNullParameter(skew, "skew");
        if (translate.getOffsetX() == 0.0f) {
            if (translate.getOffsetY() == 0.0f) {
                removePropFrameTask("transform");
                with("transform", rotate + QbAddrData.DATA_SPLITER + scale + QbAddrData.DATA_SPLITER + translate + QbAddrData.DATA_SPLITER + anchor + QbAddrData.DATA_SPLITER + skew + QbAddrData.DATA_SPLITER + rotate.b());
                return this;
            }
        }
        setPropByFrameTask("transform", new Function1<com.tencent.kuikly.core.layout.d, Unit>() { // from class: com.tencent.kuikly.core.base.Attr$transform$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(com.tencent.kuikly.core.layout.d dVar) {
                invoke2(dVar);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(com.tencent.kuikly.core.layout.d it) {
                Intrinsics.checkNotNullParameter(it, "it");
                float percentageX = y.this.getPercentageX();
                com.tencent.kuikly.core.utils.a aVar = com.tencent.kuikly.core.utils.a.f118267a;
                y yVar = new y(percentageX + (aVar.d(y.this.getOffsetX()) / Math.max(aVar.d(it.getWidth()), 0.01f)), y.this.getPercentageY() + (aVar.d(y.this.getOffsetY()) / Math.max(aVar.d(it.getHeight()), 0.01f)), 0.0f, 0.0f, 12, null);
                this.with("transform", rotate + QbAddrData.DATA_SPLITER + scale + QbAddrData.DATA_SPLITER + yVar + QbAddrData.DATA_SPLITER + anchor + QbAddrData.DATA_SPLITER + skew + QbAddrData.DATA_SPLITER + rotate.b());
            }
        });
        markToFlatLayerDisable();
        return this;
    }
}

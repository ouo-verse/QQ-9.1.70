package com.tencent.state.map;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Point;
import android.graphics.PointF;
import android.graphics.Rect;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.ScaleGestureDetector;
import android.view.TextureView;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewPropertyAnimator;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.LinearInterpolator;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.OverScroller;
import com.heytap.databaseengine.apiv3.data.Element;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.common.ParseCommon;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.hippy.qq.update.HippyQQConstants;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.luggage.wxa.c8.c;
import com.tencent.mobileqq.shortvideo.gesture.DownloadInfo;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qqmini.miniapp.widget.CanvasView;
import com.tencent.state.SquareRuntime;
import com.tencent.state.decode.RegionConfig;
import com.tencent.state.decode.RegionDecodeDrawable;
import com.tencent.state.map.BaseMapView;
import com.tencent.state.map.IMapPlayManager;
import com.tencent.state.map.MapAdapter;
import com.tencent.state.map.v2.filament.FilamentMap;
import com.tencent.state.map.v2.filament.MapViewPosition;
import com.tencent.state.square.SquareBaseKt;
import com.tencent.state.square.SquareLogger;
import com.tencent.state.square.SquareUtil;
import com.tencent.state.square.avatar.PlayerSourceHelper;
import com.tencent.state.square.chatland.data.ChatLandAvatarItem;
import com.tencent.state.square.chatland.data.ChatLandTableItem;
import com.tencent.state.square.common.ViewExtensionsKt;
import com.tencent.state.square.data.SquareAvatarItem;
import com.tencent.state.square.filamentmap.IFilamentMapController;
import com.tencent.state.square.filamentmap.ResumeEngineRenderCallback;
import com.tencent.state.square.filamentmap.SquareFilamentMapView;
import com.tencent.state.square.resource.SquarePlayManager;
import com.tencent.state.view.SquareImageView;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.ArraysKt___ArraysKt;
import kotlin.collections.CollectionsKt__MutableCollectionsJVMKt;
import kotlin.collections.CollectionsKt__MutableCollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.comparisons.ComparisonsKt__ComparisonsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.ranges.RangesKt___RangesKt;
import kotlin.text.StringsKt__StringsJVMKt;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u00c6\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010#\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010!\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0010\u0011\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\u0000\n\u0002\b\u0013\b&\u0018\u0000 \u00d2\u0001*\b\b\u0000\u0010\u0001*\u00020\u00022\u00020\u00032\u00020\u0004:\u0010\u00d1\u0001\u00d2\u0001\u00d3\u0001\u00d4\u0001\u00d5\u0001\u00d6\u0001\u00d7\u0001\u00d8\u0001B%\b\u0007\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\b\b\u0002\u0010\t\u001a\u00020\n\u00a2\u0006\u0002\u0010\u000bJ\b\u0010s\u001a\u00020tH\u0016J\u0006\u0010u\u001a\u00020tJ\u0012\u0010v\u001a\u00020A2\b\u0010w\u001a\u0004\u0018\u00010xH\u0016J'\u0010y\u001a\u0004\u0018\u0001Hz\"\b\b\u0001\u0010z*\u00020\u001a2\f\u0010{\u001a\b\u0012\u0004\u0012\u0002Hz0|H\u0016\u00a2\u0006\u0002\u0010}J\u0013\u0010~\u001a\u00020\u007f2\t\b\u0002\u0010\u0080\u0001\u001a\u00020)H\u0002J\u0015\u0010\u0081\u0001\u001a\u0005\u0018\u00010\u0082\u00012\u0007\u0010\u0083\u0001\u001a\u00020AH\u0002J\u0011\u0010\u0084\u0001\u001a\u00030\u0085\u00012\u0007\u0010\u0086\u0001\u001a\u00020\nJ\n\u0010\u0087\u0001\u001a\u0005\u0018\u00010\u0088\u0001J\b\u0010\u0089\u0001\u001a\u00030\u008a\u0001J\u001d\u0010\u008b\u0001\u001a\u00030\u008c\u00012\u0011\u0010\u008d\u0001\u001a\f\u0012\u0002\b\u00030\u008e\u0001j\u0003`\u008f\u0001H\u0014J\u001e\u0010\u0090\u0001\u001a\u0010\u0012\u0002\b\u0003\u0018\u00010\u008e\u0001j\u0005\u0018\u0001`\u008f\u00012\u0007\u0010\u0086\u0001\u001a\u00020\nJ\u001b\u0010\u0091\u0001\u001a\u00020\u007f2\u0007\u0010\u0092\u0001\u001a\u00020i2\t\b\u0002\u0010\u0093\u0001\u001a\u00020\u007fJ\t\u0010\u0094\u0001\u001a\u00020tH\u0002J\u0019\u0010\u0095\u0001\u001a\u00020t2\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010L\u001a\u00020MH\u0002J*\u0010\u0096\u0001\u001a\u00020t2\u000f\u0010\u0097\u0001\u001a\n\u0012\u0005\u0012\u00030\u0099\u00010\u0098\u00012\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010F\u001a\u00020GH\u0016J\u0019\u0010\u009a\u0001\u001a\u00020t2\u0007\u0010\u0086\u0001\u001a\u00020\n2\u0007\u0010\u009b\u0001\u001a\u00020\nJ\u0007\u0010\u009c\u0001\u001a\u00020tJ\u0015\u0010\u009d\u0001\u001a\u0004\u0018\u0001092\b\u00102\u001a\u0004\u0018\u000103H$J(\u0010\u009e\u0001\u001a\u00028\u00002\u000f\u0010\u0097\u0001\u001a\n\u0012\u0005\u0012\u00030\u0099\u00010\u009f\u00012\u0006\u0010L\u001a\u00020MH$\u00a2\u0006\u0003\u0010\u00a0\u0001J\"\u0010\u00a1\u0001\u001a\u00020M2\u000f\u0010\u0097\u0001\u001a\n\u0012\u0005\u0012\u00030\u0099\u00010\u009f\u00012\u0006\u0010\u001b\u001a\u00020\u001cH$J\u0011\u0010\u00a2\u0001\u001a\u00020_2\u0006\u0010X\u001a\u00020YH\u0014J\"\u0010\u00a3\u0001\u001a\u00030\u00a4\u00012\u0006\u0010\f\u001a\u00020\u00022\u0006\u0010^\u001a\u00020_2\u0006\u0010L\u001a\u00020MH$J\u0012\u0010\u00a5\u0001\u001a\u00020t2\u0007\u0010\u00a6\u0001\u001a\u00020xH\u0014J\t\u0010\u00a7\u0001\u001a\u00020tH\u0002J+\u0010\u00a8\u0001\u001a\u00020t2\u0006\u0010L\u001a\u00020M2\u0007\u0010\u00a9\u0001\u001a\u00020_2\u0007\u0010X\u001a\u00030\u0088\u00012\u0006\u0010R\u001a\u00020SH$J\u0013\u0010\u00aa\u0001\u001a\u00020A2\b\u0010w\u001a\u0004\u0018\u00010xH\u0016J\t\u0010\u00ab\u0001\u001a\u00020tH$J-\u0010\u00ac\u0001\u001a\u00020t2\u0007\u0010\u00ad\u0001\u001a\u00020\n2\u0007\u0010\u00ae\u0001\u001a\u00020\n2\u0007\u0010\u00af\u0001\u001a\u00020\n2\u0007\u0010\u00b0\u0001\u001a\u00020\nH\u0014J\t\u0010\u00b1\u0001\u001a\u00020tH\u0014J\u0012\u0010\u00b2\u0001\u001a\u00020t2\u0007\u0010\u00b3\u0001\u001a\u00020AH\u0016J\u0007\u0010\u00b4\u0001\u001a\u00020tJ%\u0010\u00b5\u0001\u001a\u00020t2\u0014\u0010\u00b6\u0001\u001a\u000b\u0012\u0006\b\u0001\u0012\u00020?0\u00b7\u0001\"\u00020?H\u0002\u00a2\u0006\u0003\u0010\u00b8\u0001J\"\u0010\u00b9\u0001\u001a\u00020t2\b\u0010\u00ba\u0001\u001a\u00030\u00bb\u00012\t\u0010\u00bc\u0001\u001a\u0004\u0018\u00010\n\u00a2\u0006\u0003\u0010\u00bd\u0001J\u0012\u0010\u00be\u0001\u001a\u00020t2\u0007\u0010\u00bf\u0001\u001a\u00020\u001aH\u0004J(\u0010\u00c0\u0001\u001a\u00020t2\u000f\u0010\u0097\u0001\u001a\n\u0012\u0005\u0012\u00030\u0099\u00010\u0098\u00012\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010F\u001a\u00020GJ\u0007\u0010\u00c1\u0001\u001a\u00020tJ%\u0010\u00c2\u0001\u001a\u00020t2\u0014\u0010\u00b6\u0001\u001a\u000b\u0012\u0006\b\u0001\u0012\u00020?0\u00b7\u0001\"\u00020?H\u0002\u00a2\u0006\u0003\u0010\u00b8\u0001J\u0015\u0010\u00c3\u0001\u001a\u00020A2\n\u0010\u00ba\u0001\u001a\u0005\u0018\u00010\u00bb\u0001H&J\u0017\u0010\u00c4\u0001\u001a\u00020A2\f\b\u0002\u0010\u00c5\u0001\u001a\u0005\u0018\u00010\u00c6\u0001H&J\t\u0010\u00c7\u0001\u001a\u00020tH\u0002J\u001c\u0010\u00c8\u0001\u001a\u00020t2\u0011\u0010\u008d\u0001\u001a\f\u0012\u0002\b\u00030\u008e\u0001j\u0003`\u008f\u0001H$J\t\u0010\u00c9\u0001\u001a\u00020tH\u0004J#\u0010\u00ca\u0001\u001a\u00020t2\b\u0010\u00cb\u0001\u001a\u00030\u00bb\u00012\u0007\u0010\u00cc\u0001\u001a\u00020\n2\u0007\u0010\u00b3\u0001\u001a\u00020AJ\u0010\u0010\u00cd\u0001\u001a\u00020t2\u0007\u0010\u00b3\u0001\u001a\u00020AJ \u0010\u00ce\u0001\u001a\u00030\u008c\u0001*\u00020M2\u0007\u0010\u00cf\u0001\u001a\u00020\n2\u0007\u0010\u00d0\u0001\u001a\u00020\nH\u0002R\u001e\u0010\f\u001a\u0004\u0018\u00018\u0000X\u0084\u000e\u00a2\u0006\u0010\n\u0002\u0010\u0011\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u001e\u0010\u0012\u001a\f0\u0013R\b\u0012\u0004\u0012\u00028\u00000\u0000X\u0084\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0010\u0010\u0016\u001a\u0004\u0018\u00010\u0017X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u001a0\u0019X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001a\u0010\u001b\u001a\u00020\u001cX\u0084\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 R\u0011\u0010!\u001a\u00020\"\u00a2\u0006\b\n\u0000\u001a\u0004\b#\u0010$R\u0014\u0010%\u001a\u00020\n8VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b&\u0010'R\u0014\u0010(\u001a\u00020)8VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b*\u0010+R\u001c\u0010,\u001a\u0004\u0018\u00010-X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b.\u0010/\"\u0004\b0\u00101R\u001c\u00102\u001a\u0004\u0018\u000103X\u0084\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b4\u00105\"\u0004\b6\u00107R\u001c\u00108\u001a\u0004\u0018\u000109X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b:\u0010;\"\u0004\b<\u0010=R\u0014\u0010>\u001a\b\u0012\u0004\u0012\u00020?0\u0019X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010@\u001a\u00020AX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010B\u001a\u00020\nX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010C\u001a\u00020\nX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0014\u0010D\u001a\u00020A8VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\bD\u0010ER\u001c\u0010F\u001a\u0004\u0018\u00010GX\u0084\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bH\u0010I\"\u0004\bJ\u0010KR\u001c\u0010L\u001a\u0004\u0018\u00010MX\u0084\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bN\u0010O\"\u0004\bP\u0010QR\u0014\u0010R\u001a\u00020SX\u0096\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\bT\u0010UR\u0016\u0010V\u001a\u0004\u0018\u00010\u00028VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\bW\u0010\u000eR\u001c\u0010X\u001a\u0004\u0018\u00010YX\u0084\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bZ\u0010[\"\u0004\b\\\u0010]R\u001c\u0010^\u001a\u0004\u0018\u00010_X\u0084\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b`\u0010a\"\u0004\bb\u0010cR\u001e\u0010d\u001a\f0eR\b\u0012\u0004\u0012\u00028\u00000\u0000X\u0084\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\bf\u0010gR\u0010\u0010h\u001a\u0004\u0018\u00010iX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001e\u0010j\u001a\f0kR\b\u0012\u0004\u0012\u00028\u00000\u0000X\u0084\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\bl\u0010mR\u000e\u0010n\u001a\u00020\nX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001e\u0010o\u001a\f0pR\b\u0012\u0004\u0012\u00028\u00000\u0000X\u0084\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\bq\u0010r\u00a8\u0006\u00d9\u0001"}, d2 = {"Lcom/tencent/state/map/BaseMapView;", "Adapter", "Lcom/tencent/state/map/MapAdapter;", "Landroid/widget/FrameLayout;", "Lcom/tencent/state/map/IMapView;", "context", "Landroid/content/Context;", Node.ATTRS_ATTR, "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "adapter", "getAdapter", "()Lcom/tencent/state/map/MapAdapter;", "setAdapter", "(Lcom/tencent/state/map/MapAdapter;)V", "Lcom/tencent/state/map/MapAdapter;", "animateState", "Lcom/tencent/state/map/BaseMapView$AnimateState;", "getAnimateState", "()Lcom/tencent/state/map/BaseMapView$AnimateState;", "backgroundView", "Lcom/tencent/state/decode/RegionDecodeDrawable;", "components", "", "Lcom/tencent/state/map/IMapComponent;", DownloadInfo.spKey_Config, "Lcom/tencent/state/map/MapViewConfig;", "getConfig", "()Lcom/tencent/state/map/MapViewConfig;", "setConfig", "(Lcom/tencent/state/map/MapViewConfig;)V", ParseCommon.CONTAINER, "Lcom/tencent/state/map/MapContainer;", "getContainer", "()Lcom/tencent/state/map/MapContainer;", "currentZoomLevel", "getCurrentZoomLevel", "()I", "currentZoomRatio", "", "getCurrentZoomRatio", "()F", "detectorCallback", "Lcom/tencent/state/map/ISquareViewDetectorCallback;", "getDetectorCallback", "()Lcom/tencent/state/map/ISquareViewDetectorCallback;", "setDetectorCallback", "(Lcom/tencent/state/map/ISquareViewDetectorCallback;)V", "filamentMap", "Lcom/tencent/state/square/filamentmap/SquareFilamentMapView;", "getFilamentMap", "()Lcom/tencent/state/square/filamentmap/SquareFilamentMapView;", "setFilamentMap", "(Lcom/tencent/state/square/filamentmap/SquareFilamentMapView;)V", "filamentMapController", "Lcom/tencent/state/square/filamentmap/IFilamentMapController;", "getFilamentMapController", "()Lcom/tencent/state/square/filamentmap/IFilamentMapController;", "setFilamentMapController", "(Lcom/tencent/state/square/filamentmap/IFilamentMapController;)V", "filamentPausedReasons", "Lcom/tencent/state/map/ViewportChangeReason;", "forceFilamentCacheFrameInvisible", "", "initialTouchX", "initialTouchY", "isInDetailMode", "()Z", "listener", "Lcom/tencent/state/map/IMapViewListener;", "getListener", "()Lcom/tencent/state/map/IMapViewListener;", "setListener", "(Lcom/tencent/state/map/IMapViewListener;)V", "locator", "Lcom/tencent/state/map/IMapLocator;", "getLocator", "()Lcom/tencent/state/map/IMapLocator;", "setLocator", "(Lcom/tencent/state/map/IMapLocator;)V", "manipulator", "Lcom/tencent/state/map/IMapViewManipulator;", "getManipulator", "()Lcom/tencent/state/map/IMapViewManipulator;", "mapAdapter", "getMapAdapter", "observer", "Lcom/tencent/state/map/MapViewDataObserver;", "getObserver", "()Lcom/tencent/state/map/MapViewDataObserver;", "setObserver", "(Lcom/tencent/state/map/MapViewDataObserver;)V", "rpm", "Lcom/tencent/state/map/IMapPlayManager;", "getRpm", "()Lcom/tencent/state/map/IMapPlayManager;", "setRpm", "(Lcom/tencent/state/map/IMapPlayManager;)V", "scaleState", "Lcom/tencent/state/map/BaseMapView$ScaleState;", "getScaleState", "()Lcom/tencent/state/map/BaseMapView$ScaleState;", "scaledTarget", "Landroid/view/View;", HippyTKDListViewAdapter.SCROLL_STATE, "Lcom/tencent/state/map/BaseMapView$ScrollState;", "getScrollState", "()Lcom/tencent/state/map/BaseMapView$ScrollState;", "touchSlop", "viewFinder", "Lcom/tencent/state/map/BaseMapView$ViewFinder;", "getViewFinder", "()Lcom/tencent/state/map/BaseMapView$ViewFinder;", "computeScroll", "", "destroy", "dispatchTouchEvent", "ev", "Landroid/view/MotionEvent;", "getComponent", "T", "clazz", "Ljava/lang/Class;", "(Ljava/lang/Class;)Lcom/tencent/state/map/IMapComponent;", "getContainerRect", "Landroid/graphics/RectF;", "scale", "getFilamentCacheFrameView", "Landroid/widget/ImageView;", "createIfNotExist", "getItemLocation", "Landroid/graphics/Rect;", "index", "getItemViewManager", "Lcom/tencent/state/map/IMapItemViewManager;", "getMapViewPosition", "Lcom/tencent/state/map/v2/filament/MapViewPosition;", "getScreenCenterOffset", "Landroid/graphics/Point;", "viewHolder", "Lcom/tencent/state/map/MapViewHolder;", "Lcom/tencent/state/map/ViewHolder;", "getViewHolder", "getViewLocation", "child", CanvasView.ACTION_RECT, "hideFilamentCacheFrame", "initBackground", "initialize", "dataList", "", "Lcom/tencent/state/map/MapItem;", "notifyItemChangeWithPayload", "eventId", "onBackFromDetail", "onCreateFilamentMapViewUpdater", "onCreateMapAdapter", "", "(Ljava/util/List;Lcom/tencent/state/map/IMapLocator;)Lcom/tencent/state/map/MapAdapter;", "onCreateMapLocator", "onCreateMapPlayManager", "onCreateMapViewUpdater", "Lcom/tencent/state/map/IMapViewUpdater;", "onDoubleClicked", "e", "onFilamentResume", "onInitMapAdapter", "rmp", NodeProps.ON_INTERCEPT_TOUCH_EVENT, "onMapSizeInitReadyAction", "onScrollChanged", "l", "t", "oldl", "oldt", "onScrollIdled", "onVisibilityChanged", "isVisible", "pauseAll", "pauseFilament", "reasons", "", "([Lcom/tencent/state/map/ViewportChangeReason;)V", "performItemViewClick", "uin", "", "viewId", "(Ljava/lang/String;Ljava/lang/Integer;)V", "registerComponent", HippyQQConstants.URL_COMPONENT_NAME, "reset", "resumeAll", "resumeFilament", "scaleToDetail", "scaleToMeDetail", "extra", "", "showFilamentCacheFrame", "startViewAlpha", "updateFilamentViewport", "updateItemViewVisible", "id", "type", "updateScaledItemViewVisible", "getDistanceToScreenCenter", HippyTKDListViewAdapter.X, "y", "AnimateState", "Companion", "LayoutParams", "MapViewManipulator", "ScaleState", "ScrollState", "ViewFinder", "ZoomLevel", "state_square_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes34.dex */
public abstract class BaseMapView<Adapter extends MapAdapter> extends FrameLayout implements IMapView {
    public static final String FILAMENT_STATIC_IMAGE_TAG = "FILAMENT_STATIC_IMAGE";
    private static final int FLING_VELOCITY_RATIO = 3;
    private static final int MAX_SCROLL_DURATION = 500;
    public static final long SCALE_DURATION = 500;
    private static final String TAG = "Square_MapView";
    public static final float ZOOM_IN_0_RATIO = 0.2f;
    public static final float ZOOM_IN_1_RATIO = 0.4f;
    public static final float ZOOM_IN_2_RATIO = 0.7f;
    public static final float ZOOM_IN_3_RATIO = 1.0f;
    public static final float ZOOM_IN_4_RATIO = 1.4f;
    private Adapter adapter;
    private final BaseMapView<Adapter>.AnimateState animateState;
    private RegionDecodeDrawable backgroundView;
    private final Set<IMapComponent> components;
    private MapViewConfig config;
    private final MapContainer container;
    private ISquareViewDetectorCallback detectorCallback;
    private SquareFilamentMapView filamentMap;
    private IFilamentMapController filamentMapController;
    private final Set<ViewportChangeReason> filamentPausedReasons;
    private boolean forceFilamentCacheFrameInvisible;
    private int initialTouchX;
    private int initialTouchY;
    private IMapViewListener listener;
    private IMapLocator locator;
    private final IMapViewManipulator manipulator;
    private MapViewDataObserver observer;
    private IMapPlayManager rpm;
    private final BaseMapView<Adapter>.ScaleState scaleState;
    private View scaledTarget;
    private final BaseMapView<Adapter>.ScrollState scrollState;
    private final int touchSlop;
    private final BaseMapView<Adapter>.ViewFinder viewFinder;

    /* compiled from: P */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0005R&\u0010\u0006\u001a\u000e\u0012\u0002\b\u0003\u0018\u00010\u0007j\u0004\u0018\u0001`\bX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\f\u00a8\u0006\r"}, d2 = {"Lcom/tencent/state/map/BaseMapView$LayoutParams;", "Landroid/widget/FrameLayout$LayoutParams;", "width", "", "height", "(II)V", "holder", "Lcom/tencent/state/map/MapViewHolder;", "Lcom/tencent/state/map/ViewHolder;", "getHolder", "()Lcom/tencent/state/map/MapViewHolder;", "setHolder", "(Lcom/tencent/state/map/MapViewHolder;)V", "state_square_debug"}, k = 1, mv = {1, 4, 1})
    /* loaded from: classes34.dex */
    public static final class LayoutParams extends FrameLayout.LayoutParams {
        private MapViewHolder<?> holder;

        public LayoutParams(int i3, int i16) {
            super(i3, i16);
        }

        public final MapViewHolder<?> getHolder() {
            return this.holder;
        }

        public final void setHolder(MapViewHolder<?> mapViewHolder) {
            this.holder = mapViewHolder;
        }
    }

    /* compiled from: P */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0006\n\u0002\u0010 \n\u0000\b\u0086\u0004\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004J\u001a\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0007H\u0002J\u0018\u0010\t\u001a\u0004\u0018\u00010\u00042\u0006\u0010\n\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\u0007J\u0018\u0010\f\u001a\u0004\u0018\u00010\u00042\u0006\u0010\n\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\u0007J\u001c\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00040\u000e2\u0006\u0010\n\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\u0007\u00a8\u0006\u000f"}, d2 = {"Lcom/tencent/state/map/BaseMapView$ViewFinder;", "", "(Lcom/tencent/state/map/BaseMapView;)V", "findCenterView", "Landroid/view/View;", "findNearestViewInMap", "xInMap", "", "yInMap", "findNearestViewInScreen", HippyTKDListViewAdapter.X, "y", "findTargetView", "findTargetViews", "", "state_square_debug"}, k = 1, mv = {1, 4, 1})
    /* loaded from: classes34.dex */
    public final class ViewFinder {
        public ViewFinder() {
        }

        /* JADX WARN: Multi-variable type inference failed */
        private final View findNearestViewInMap(final float xInMap, final float yInMap) {
            final RectF rectF = new RectF();
            final Ref.ObjectRef objectRef = new Ref.ObjectRef();
            objectRef.element = null;
            final Ref.IntRef intRef = new Ref.IntRef();
            intRef.element = Integer.MAX_VALUE;
            ViewExtensionsKt.forEachChild(BaseMapView.this.getContainer(), new Function1<View, Unit>() { // from class: com.tencent.state.map.BaseMapView$ViewFinder$findNearestViewInMap$1
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(View view) {
                    invoke2(view);
                    return Unit.INSTANCE;
                }

                /* JADX WARN: Multi-variable type inference failed */
                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(View child) {
                    Intrinsics.checkNotNullParameter(child, "child");
                    if (child instanceof ImageView) {
                        return;
                    }
                    float x16 = (child.getX() * BaseMapView.this.getCurrentZoomRatio()) - BaseMapView.this.getScrollX();
                    float y16 = (child.getY() * BaseMapView.this.getCurrentZoomRatio()) - BaseMapView.this.getScrollY();
                    rectF.set(x16, y16, (child.getWidth() * BaseMapView.this.getCurrentZoomRatio()) + x16, (child.getHeight() * BaseMapView.this.getCurrentZoomRatio()) + y16);
                    if (rectF.contains(xInMap, yInMap)) {
                        int hypotenuse = (int) com.tencent.state.ViewExtensionsKt.hypotenuse(xInMap - rectF.centerX(), yInMap - rectF.centerY());
                        Ref.IntRef intRef2 = intRef;
                        if (hypotenuse < intRef2.element) {
                            intRef2.element = hypotenuse;
                            objectRef.element = child;
                        }
                    }
                }
            });
            return (View) objectRef.element;
        }

        public final View findCenterView() {
            if (BaseMapView.this.getLocator() == null) {
                return null;
            }
            return findNearestViewInMap(r0.getViewPort().centerX(), r0.getViewPort().centerY());
        }

        public final View findNearestViewInScreen(float x16, float y16) {
            if (BaseMapView.this.getLocator() != null) {
                return findNearestViewInMap(r0.getViewPort().left + x16, r0.getViewPort().top + y16);
            }
            return null;
        }

        public final View findTargetView(final float x16, final float y16) {
            final RectF rectF = new RectF();
            return ViewExtensionsKt.firstTopOrNull(BaseMapView.this.getContainer(), new Function1<View, Boolean>() { // from class: com.tencent.state.map.BaseMapView$ViewFinder$findTargetView$1
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Boolean invoke(View view) {
                    return Boolean.valueOf(invoke2(view));
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final boolean invoke2(View child) {
                    Intrinsics.checkNotNullParameter(child, "child");
                    BaseMapView.this.getViewLocation(child, rectF);
                    return rectF.contains(x16, y16);
                }
            });
        }

        public final List<View> findTargetViews(final float x16, final float y16) {
            final RectF rectF = new RectF();
            final ArrayList arrayList = new ArrayList();
            ViewExtensionsKt.forEachChild(BaseMapView.this.getContainer(), new Function1<View, Unit>() { // from class: com.tencent.state.map.BaseMapView$ViewFinder$findTargetViews$1
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(View view) {
                    invoke2(view);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(View child) {
                    Intrinsics.checkNotNullParameter(child, "child");
                    if (child instanceof ImageView) {
                        return;
                    }
                    BaseMapView.this.getViewLocation(child, rectF);
                    if (rectF.contains(x16, y16)) {
                        arrayList.add(child);
                    }
                }
            });
            if (arrayList.size() > 1) {
                CollectionsKt__MutableCollectionsJVMKt.sortWith(arrayList, new Comparator<T>() { // from class: com.tencent.state.map.BaseMapView$ViewFinder$findTargetViews$$inlined$sortByDescending$1
                    /* JADX WARN: Multi-variable type inference failed */
                    @Override // java.util.Comparator
                    public final int compare(T t16, T t17) {
                        int compareValues;
                        compareValues = ComparisonsKt__ComparisonsKt.compareValues(Float.valueOf(((View) t17).getElevation()), Float.valueOf(((View) t16).getElevation()));
                        return compareValues;
                    }
                });
            }
            return arrayList;
        }
    }

    /* compiled from: P */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\t"}, d2 = {"Lcom/tencent/state/map/BaseMapView$ZoomLevel;", "", "()V", "ZOOM_IN_0", "", "ZOOM_IN_1", "ZOOM_IN_2", "ZOOM_IN_3", "ZOOM_IN_4", "state_square_debug"}, k = 1, mv = {1, 4, 1})
    /* loaded from: classes34.dex */
    public static final class ZoomLevel {
        public static final ZoomLevel INSTANCE = new ZoomLevel();
        public static final int ZOOM_IN_0 = 0;
        public static final int ZOOM_IN_1 = 1;
        public static final int ZOOM_IN_2 = 2;
        public static final int ZOOM_IN_3 = 3;
        public static final int ZOOM_IN_4 = 4;

        ZoomLevel() {
        }
    }

    public BaseMapView(Context context) {
        this(context, null, 0, 6, null);
    }

    private final RectF getContainerRect(float scale) {
        float f16 = 1 - scale;
        float f17 = 2;
        float x16 = this.container.getX() + ((this.container.getWidth() * f16) / f17);
        float y16 = this.container.getY() + ((this.container.getHeight() * f16) / f17);
        return new RectF(x16, y16, (this.container.getWidth() * scale) + x16, (this.container.getHeight() * scale) + y16);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Point getDistanceToScreenCenter(IMapLocator iMapLocator, int i3, int i16) {
        return new Point((int) (((iMapLocator.getViewPort().centerX() + getScrollX()) - (i3 * getCurrentZoomRatio())) / getCurrentZoomRatio()), (int) (((iMapLocator.getViewPort().centerY() + getScrollY()) - (i16 * getCurrentZoomRatio())) / getCurrentZoomRatio()));
    }

    private final ImageView getFilamentCacheFrameView(boolean createIfNotExist) {
        ImageView imageView = (ImageView) this.container.findViewWithTag(FILAMENT_STATIC_IMAGE_TAG);
        if (imageView != null || !createIfNotExist) {
            return imageView;
        }
        SquareImageView squareImageView = new SquareImageView(getContext());
        squareImageView.setTag(FILAMENT_STATIC_IMAGE_TAG);
        this.container.addView(squareImageView);
        com.tencent.state.ViewExtensionsKt.setVisibility(squareImageView, false);
        return squareImageView;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void hideFilamentCacheFrame() {
        SquareBaseKt.getSquareLog().d(TAG, "hideFilamentCacheFrame");
        this.forceFilamentCacheFrameInvisible = false;
        ImageView filamentCacheFrameView = getFilamentCacheFrameView(false);
        if (filamentCacheFrameView != null) {
            com.tencent.state.ViewExtensionsKt.setVisibility(filamentCacheFrameView, false);
            if (isInDetailMode()) {
                return;
            }
            filamentCacheFrameView.setImageBitmap(null);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x001b  */
    /* JADX WARN: Removed duplicated region for block: B:13:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final void initBackground(MapViewConfig config, IMapLocator locator) {
        boolean z16;
        boolean isBlank;
        if (SquareRuntime.INSTANCE.hasNearbyMark()) {
            return;
        }
        String mapBackground = config.getMapBackground();
        if (mapBackground != null) {
            isBlank = StringsKt__StringsJVMKt.isBlank(mapBackground);
            if (!isBlank) {
                z16 = false;
                if (z16) {
                    Context context = getContext();
                    Intrinsics.checkNotNullExpressionValue(context, "context");
                    RegionDecodeDrawable regionDecodeDrawable = new RegionDecodeDrawable(context);
                    this.backgroundView = regionDecodeDrawable;
                    regionDecodeDrawable.initialize(new RegionConfig("", mapBackground, config.getMapWidth(), config.getMapHeight(), com.tencent.state.ViewExtensionsKt.dip((View) this, 300), com.tencent.state.ViewExtensionsKt.dip((View) this, 400), new Rect(locator.getViewPort()), null, 128, null));
                    this.container.setBackgroundDrawable(this.backgroundView);
                    return;
                }
                return;
            }
        }
        z16 = true;
        if (z16) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void onFilamentResume() {
        IMapPlayManager iMapPlayManager = this.rpm;
        if (iMapPlayManager != null) {
            iMapPlayManager.onFilamentResume();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void pauseFilament(ViewportChangeReason... reasons) {
        boolean contains;
        IMapPlayManager iMapPlayManager;
        contains = ArraysKt___ArraysKt.contains(reasons, ViewportChangeReason.RESET);
        if (contains) {
            return;
        }
        if (SquareRuntime.INSTANCE.hasNearbyMark() || this.scaleState.getCurrent() != 0) {
            if (this.filamentPausedReasons.isEmpty() && (iMapPlayManager = this.rpm) != null) {
                IMapPlayManager.DefaultImpls.clearInvisibleFilamentAvatar$default(iMapPlayManager, null, 1, null);
            }
            CollectionsKt__MutableCollectionsKt.addAll(this.filamentPausedReasons, reasons);
            showFilamentCacheFrame();
            SquareFilamentMapView squareFilamentMapView = this.filamentMap;
            if (squareFilamentMapView != null) {
                squareFilamentMapView.pauseEngineRender();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void resumeFilament(ViewportChangeReason... reasons) {
        Set set;
        Set<ViewportChangeReason> set2 = this.filamentPausedReasons;
        set = ArraysKt___ArraysKt.toSet(reasons);
        set2.removeAll(set);
        updateFilamentViewport();
        SquareFilamentMapView squareFilamentMapView = this.filamentMap;
        if (squareFilamentMapView != null) {
            squareFilamentMapView.prepareToResumeEngineRender(new ResumeEngineRenderCallback() { // from class: com.tencent.state.map.BaseMapView$resumeFilament$1
                @Override // com.tencent.state.square.filamentmap.ResumeEngineRenderCallback
                public void onEngineResumed() {
                    Set set3;
                    Set set4;
                    Set set5;
                    set3 = BaseMapView.this.filamentPausedReasons;
                    if (set3.isEmpty()) {
                        SquareFilamentMapView filamentMap = BaseMapView.this.getFilamentMap();
                        if (filamentMap != null) {
                            filamentMap.resumeEngineRender(BaseMapView.this.getMapViewPosition());
                        }
                        BaseMapView.this.hideFilamentCacheFrame();
                        BaseMapView.this.onFilamentResume();
                        return;
                    }
                    SquareLogger squareLog = SquareBaseKt.getSquareLog();
                    StringBuilder sb5 = new StringBuilder();
                    sb5.append("[FilamentCache] cannot resume, pause reasons: ");
                    set4 = BaseMapView.this.filamentPausedReasons;
                    set5 = CollectionsKt___CollectionsKt.toSet(set4);
                    sb5.append(set5);
                    squareLog.d("Square_MapView", sb5.toString());
                }
            });
        }
    }

    @Override // android.view.View
    public void computeScroll() {
        this.scrollState.computeScroll();
    }

    public final void destroy() {
        MapViewDataObserver mapViewDataObserver = this.observer;
        if (mapViewDataObserver != null) {
            mapViewDataObserver.recycleAllViews();
        }
        Adapter adapter = this.adapter;
        if (adapter != null) {
            adapter.onDestroy();
        }
        RegionDecodeDrawable regionDecodeDrawable = this.backgroundView;
        if (regionDecodeDrawable != null) {
            regionDecodeDrawable.destroy();
        }
        SquareFilamentMapView squareFilamentMapView = this.filamentMap;
        if (squareFilamentMapView != null) {
            squareFilamentMapView.destroy();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent ev5) {
        this.scaleState.onTouchEvent(ev5);
        this.scrollState.onTouchEvent(ev5);
        return super.dispatchTouchEvent(ev5);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final Adapter getAdapter() {
        return this.adapter;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final BaseMapView<Adapter>.AnimateState getAnimateState() {
        return this.animateState;
    }

    @Override // com.tencent.state.map.IMapView
    public <T extends IMapComponent> T getComponent(Class<T> clazz) {
        Object obj;
        Intrinsics.checkNotNullParameter(clazz, "clazz");
        Iterator<T> it = this.components.iterator();
        while (true) {
            if (!it.hasNext()) {
                obj = null;
                break;
            }
            obj = it.next();
            if (clazz.isAssignableFrom(((IMapComponent) obj).getClass())) {
                break;
            }
        }
        return (T) (obj instanceof IMapComponent ? obj : null);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final MapViewConfig getConfig() {
        return this.config;
    }

    public final MapContainer getContainer() {
        return this.container;
    }

    @Override // com.tencent.state.map.IMapView
    public int getCurrentZoomLevel() {
        if (this.scaleState.isZooming()) {
            return this.scaleState.getNext();
        }
        return this.scaleState.getCurrent();
    }

    @Override // com.tencent.state.map.IMapView
    public float getCurrentZoomRatio() {
        return this.scaleState.getCurrentZoomRatio();
    }

    public final ISquareViewDetectorCallback getDetectorCallback() {
        return this.detectorCallback;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final SquareFilamentMapView getFilamentMap() {
        return this.filamentMap;
    }

    public final IFilamentMapController getFilamentMapController() {
        return this.filamentMapController;
    }

    public final Rect getItemLocation(int index) {
        Rect itemPosition;
        IMapLocator iMapLocator = this.locator;
        if (iMapLocator != null && (itemPosition = iMapLocator.getItemPosition(index)) != null) {
            return new Rect((int) (itemPosition.left * getCurrentZoomRatio()), (int) (itemPosition.top * getCurrentZoomRatio()), (int) (itemPosition.right * getCurrentZoomRatio()), (int) (itemPosition.bottom * getCurrentZoomRatio()));
        }
        return new Rect();
    }

    public final IMapItemViewManager getItemViewManager() {
        return this.observer;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final IMapViewListener getListener() {
        return this.listener;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final IMapLocator getLocator() {
        return this.locator;
    }

    @Override // com.tencent.state.map.IMapView
    public IMapViewManipulator getManipulator() {
        return this.manipulator;
    }

    @Override // com.tencent.state.map.IMapView
    /* renamed from: getMapAdapter, reason: from getter */
    public MapAdapter getAdapter() {
        return this.adapter;
    }

    public final MapViewPosition getMapViewPosition() {
        float scaleX = this.container.getScaleX();
        float scaleY = this.container.getScaleY();
        float f16 = 1;
        float f17 = 2;
        float x16 = this.container.getX() + ((this.container.getWidth() * (f16 - scaleX)) / f17);
        float y16 = this.container.getY() + ((this.container.getHeight() * (f16 - scaleY)) / f17);
        return new MapViewPosition(new RectF(x16, y16, (this.container.getWidth() * scaleX) + x16, (this.container.getHeight() * scaleY) + y16), scaleX, scaleY, getScrollX(), getScrollY());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final MapViewDataObserver getObserver() {
        return this.observer;
    }

    protected final IMapPlayManager getRpm() {
        return this.rpm;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final BaseMapView<Adapter>.ScaleState getScaleState() {
        return this.scaleState;
    }

    protected Point getScreenCenterOffset(MapViewHolder<?> viewHolder) {
        Intrinsics.checkNotNullParameter(viewHolder, "viewHolder");
        return new Point(0, 0);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final BaseMapView<Adapter>.ScrollState getScrollState() {
        return this.scrollState;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final BaseMapView<Adapter>.ViewFinder getViewFinder() {
        return this.viewFinder;
    }

    public final MapViewHolder<?> getViewHolder(int index) {
        MapViewDataObserver mapViewDataObserver = this.observer;
        if (mapViewDataObserver != null) {
            return mapViewDataObserver.getViewHolder(index);
        }
        return null;
    }

    public final RectF getViewLocation(View child, RectF rect) {
        Intrinsics.checkNotNullParameter(child, "child");
        Intrinsics.checkNotNullParameter(rect, "rect");
        float currentZoomRatio = getCurrentZoomRatio();
        float f16 = 1 - currentZoomRatio;
        float f17 = 2;
        float x16 = ((child.getX() * currentZoomRatio) + (this.container.getX() + ((this.container.getWidth() * f16) / f17))) - getScrollX();
        float y16 = ((child.getY() * currentZoomRatio) + (this.container.getY() + ((this.container.getHeight() * f16) / f17))) - getScrollY();
        rect.set(x16, y16, (child.getWidth() * currentZoomRatio) + x16, (child.getHeight() * currentZoomRatio) + y16);
        return rect;
    }

    public void initialize(List<? extends MapItem> dataList, MapViewConfig config, IMapViewListener listener) {
        List<MapItem> mutableList;
        Intrinsics.checkNotNullParameter(dataList, "dataList");
        Intrinsics.checkNotNullParameter(config, "config");
        Intrinsics.checkNotNullParameter(listener, "listener");
        this.config = config;
        mutableList = CollectionsKt___CollectionsKt.toMutableList((Collection) dataList);
        final IMapLocator onCreateMapLocator = onCreateMapLocator(mutableList, config);
        this.locator = onCreateMapLocator;
        com.tencent.state.ViewExtensionsKt.updateLayoutParams(this.container, new Function1<FrameLayout.LayoutParams, Unit>() { // from class: com.tencent.state.map.BaseMapView$initialize$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(FrameLayout.LayoutParams layoutParams) {
                invoke2(layoutParams);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(FrameLayout.LayoutParams receiver) {
                Intrinsics.checkNotNullParameter(receiver, "$receiver");
                receiver.width = IMapLocator.this.getMapWidth();
                receiver.height = IMapLocator.this.getMapHeight();
            }
        });
        this.scaleState.initialize();
        onMapSizeInitReadyAction();
        Adapter onCreateMapAdapter = onCreateMapAdapter(mutableList, onCreateMapLocator);
        this.adapter = onCreateMapAdapter;
        MapViewDataObserver mapViewDataObserver = new MapViewDataObserver(this, onCreateMapAdapter, onCreateMapLocator);
        this.observer = mapViewDataObserver;
        IMapPlayManager onCreateMapPlayManager = onCreateMapPlayManager(mapViewDataObserver);
        this.rpm = onCreateMapPlayManager;
        this.listener = listener;
        this.filamentMapController = onCreateFilamentMapViewUpdater(this.filamentMap);
        onInitMapAdapter(onCreateMapLocator, onCreateMapPlayManager, mapViewDataObserver, getManipulator());
        onCreateMapAdapter.registerAdapterDataObserver(mapViewDataObserver);
        mapViewDataObserver.initialize(dataList.size());
        initBackground(config, onCreateMapLocator);
        onCreateMapPlayManager.initialize();
        registerComponent(onCreateMapViewUpdater(onCreateMapAdapter, onCreateMapPlayManager, onCreateMapLocator));
    }

    @Override // com.tencent.state.map.IMapView
    public boolean isInDetailMode() {
        return this.scaledTarget != null;
    }

    public final void notifyItemChangeWithPayload(int index, int eventId) {
        MapViewDataObserver mapViewDataObserver = this.observer;
        if (mapViewDataObserver != null) {
            mapViewDataObserver.onItemRangeChanged(index, 1, Integer.valueOf(eventId));
        }
    }

    public final void onBackFromDetail() {
        MapViewHolder<?> mapViewHolder;
        MapItemController controller;
        Adapter adapter = this.adapter;
        if (adapter != null && (controller = adapter.getController()) != null) {
            controller.setItemAlpha(1.0f);
        }
        View view = this.scaledTarget;
        if (view == null || (mapViewHolder = MapViewKt.getMapViewHolder(view)) == null) {
            return;
        }
        getManipulator().scaleToCenter(mapViewHolder);
        mapViewHolder.onBackFromDetail();
    }

    protected abstract IFilamentMapController onCreateFilamentMapViewUpdater(SquareFilamentMapView filamentMap);

    protected abstract Adapter onCreateMapAdapter(List<MapItem> dataList, IMapLocator locator);

    protected abstract IMapLocator onCreateMapLocator(List<MapItem> dataList, MapViewConfig config);

    /* JADX INFO: Access modifiers changed from: protected */
    public IMapPlayManager onCreateMapPlayManager(MapViewDataObserver observer) {
        Intrinsics.checkNotNullParameter(observer, "observer");
        return new SquarePlayManager(observer);
    }

    protected abstract IMapViewUpdater onCreateMapViewUpdater(MapAdapter adapter, IMapPlayManager rpm, IMapLocator locator);

    /* JADX INFO: Access modifiers changed from: protected */
    public void onDoubleClicked(MotionEvent e16) {
        Intrinsics.checkNotNullParameter(e16, "e");
    }

    protected abstract void onInitMapAdapter(IMapLocator locator, IMapPlayManager rmp, IMapItemViewManager observer, IMapViewManipulator manipulator);

    protected abstract void onMapSizeInitReadyAction();

    @Override // android.view.View
    protected void onScrollChanged(int l3, int t16, int oldl, int oldt) {
        super.onScrollChanged(l3, t16, oldl, oldt);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onScrollIdled() {
        IMapPlayManager iMapPlayManager = this.rpm;
        if (iMapPlayManager != null) {
            iMapPlayManager.onScrollIdled();
        }
    }

    public void onVisibilityChanged(boolean isVisible) {
        IMapPlayManager iMapPlayManager = this.rpm;
        if (iMapPlayManager != null) {
            iMapPlayManager.onVisibilityChanged(isVisible);
        }
        MapViewDataObserver mapViewDataObserver = this.observer;
        if (mapViewDataObserver != null) {
            mapViewDataObserver.onVisibilityChanged(isVisible);
        }
        if (isVisible) {
            PlayerSourceHelper.INSTANCE.setMapZoomLevel(this.scaleState.getCurrent());
        }
    }

    public final void pauseAll() {
        IMapPlayManager iMapPlayManager = this.rpm;
        if (iMapPlayManager != null) {
            iMapPlayManager.onVisibilityChanged(false);
        }
    }

    public final void performItemViewClick(final String uin, Integer viewId) {
        View view;
        View findViewById;
        View view2;
        Intrinsics.checkNotNullParameter(uin, "uin");
        Adapter adapter = this.adapter;
        if (adapter != null) {
            int indexOf = adapter.indexOf(new Function1<MapItem, Boolean>() { // from class: com.tencent.state.map.BaseMapView$performItemViewClick$index$1
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Boolean invoke(MapItem mapItem) {
                    return Boolean.valueOf(invoke2(mapItem));
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final boolean invoke2(MapItem it) {
                    Intrinsics.checkNotNullParameter(it, "it");
                    return Intrinsics.areEqual(it.getUin(), uin);
                }
            });
            if (viewId == null) {
                MapViewHolder<?> viewHolder = getViewHolder(indexOf);
                if (viewHolder == null || (view2 = viewHolder.itemView) == null) {
                    return;
                }
                view2.performClick();
                return;
            }
            MapViewHolder<?> viewHolder2 = getViewHolder(indexOf);
            if (viewHolder2 == null || (view = viewHolder2.itemView) == null || (findViewById = view.findViewById(viewId.intValue())) == null) {
                return;
            }
            findViewById.performClick();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void registerComponent(IMapComponent component) {
        Intrinsics.checkNotNullParameter(component, "component");
        this.components.add(component);
    }

    public final void reset(List<? extends MapItem> dataList, MapViewConfig config, IMapViewListener listener) {
        Intrinsics.checkNotNullParameter(dataList, "dataList");
        Intrinsics.checkNotNullParameter(config, "config");
        Intrinsics.checkNotNullParameter(listener, "listener");
        this.components.clear();
        MapViewDataObserver mapViewDataObserver = this.observer;
        if (mapViewDataObserver != null) {
            mapViewDataObserver.recycleAllViews();
        }
        initialize(dataList, config, listener);
        IMapLocator iMapLocator = this.locator;
        if (iMapLocator != null) {
            IMapLocatorKt.updateViewPort(iMapLocator, getCurrentZoomRatio());
        }
        this.filamentPausedReasons.clear();
        this.scrollState.doScrollBy(-getScrollX(), -getScrollY(), ViewportChangeReason.RESET);
    }

    public final void resumeAll() {
        IMapPlayManager iMapPlayManager = this.rpm;
        if (iMapPlayManager != null) {
            iMapPlayManager.onVisibilityChanged(true);
        }
    }

    public abstract boolean scaleToDetail(String uin);

    public abstract boolean scaleToMeDetail(Object extra);

    protected final void setAdapter(Adapter adapter) {
        this.adapter = adapter;
    }

    protected final void setConfig(MapViewConfig mapViewConfig) {
        Intrinsics.checkNotNullParameter(mapViewConfig, "<set-?>");
        this.config = mapViewConfig;
    }

    public final void setDetectorCallback(ISquareViewDetectorCallback iSquareViewDetectorCallback) {
        this.detectorCallback = iSquareViewDetectorCallback;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void setFilamentMap(SquareFilamentMapView squareFilamentMapView) {
        this.filamentMap = squareFilamentMapView;
    }

    public final void setFilamentMapController(IFilamentMapController iFilamentMapController) {
        this.filamentMapController = iFilamentMapController;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void setListener(IMapViewListener iMapViewListener) {
        this.listener = iMapViewListener;
    }

    protected final void setLocator(IMapLocator iMapLocator) {
        this.locator = iMapLocator;
    }

    protected final void setObserver(MapViewDataObserver mapViewDataObserver) {
        this.observer = mapViewDataObserver;
    }

    protected final void setRpm(IMapPlayManager iMapPlayManager) {
        this.rpm = iMapPlayManager;
    }

    protected abstract void startViewAlpha(MapViewHolder<?> viewHolder);

    public final void updateItemViewVisible(String id5, int type, boolean isVisible) {
        View view;
        Intrinsics.checkNotNullParameter(id5, "id");
        MapViewDataObserver mapViewDataObserver = this.observer;
        MapViewHolder<?> viewHolder = getViewHolder(mapViewDataObserver != null ? mapViewDataObserver.indexOf(id5, type) : -1);
        if (viewHolder == null || (view = viewHolder.itemView) == null) {
            return;
        }
        view.setAlpha(isVisible ? 1.0f : 0.0f);
    }

    public final void updateScaledItemViewVisible(boolean isVisible) {
        MapViewHolder<?> mapViewHolder;
        View view = this.scaledTarget;
        if (view == null || (mapViewHolder = MapViewKt.getMapViewHolder(view)) == null) {
            return;
        }
        float f16 = isVisible ? 1.0f : 0.0f;
        View view2 = mapViewHolder.itemView;
        Intrinsics.checkNotNullExpressionValue(view2, "holder.itemView");
        view2.setAlpha(f16);
        SquareBaseKt.getSquareLog().d(TAG, "updateScaledItemViewVisible " + isVisible);
    }

    /* compiled from: P */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0000\b\u0086\u0004\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\"\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00062\b\b\u0002\u0010\b\u001a\u00020\tH\u0002J$\u0010\n\u001a\u00020\u000b2\u0012\u0010\f\u001a\u000e\u0012\u0002\b\u0003\u0018\u00010\rj\u0004\u0018\u0001`\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0002J$\u0010\u0011\u001a\u00020\u000b2\u0012\u0010\f\u001a\u000e\u0012\u0002\b\u0003\u0018\u00010\rj\u0004\u0018\u0001`\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0002J0\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0014\u001a\u00020\u00062\u0006\u0010\u0015\u001a\u00020\u00062\u0010\b\u0002\u0010\u0016\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\u0017J\u001e\u0010\u0018\u001a\u00020\u000b2\u0016\u0010\u0019\u001a\u0012\u0012\u0004\u0012\u00020\u001b0\u001aj\b\u0012\u0004\u0012\u00020\u001b`\u001c\u00a8\u0006\u001d"}, d2 = {"Lcom/tencent/state/map/BaseMapView$AnimateState;", "", "(Lcom/tencent/state/map/BaseMapView;)V", c.f123400v, "Landroid/view/animation/Animation;", "lower", "", "upper", "duration", "", "doEnterAnim", "", "targetHolder", "Lcom/tencent/state/map/MapViewHolder;", "Lcom/tencent/state/map/ViewHolder;", "target", "Landroid/view/View;", "doOutAnim", "scaleToCenter", "", "pivotX", "pivotY", "onFinish", "Lkotlin/Function0;", "startOtherViewAlpha", "filterSet", "Ljava/util/ArrayList;", "", "Lkotlin/collections/ArrayList;", "state_square_debug"}, k = 1, mv = {1, 4, 1})
    /* loaded from: classes34.dex */
    public final class AnimateState {
        public AnimateState() {
        }

        private final Animation alpha(float lower, float upper, long duration) {
            float f16 = BaseMapView.this.isInDetailMode() ? lower : upper;
            if (BaseMapView.this.isInDetailMode()) {
                lower = upper;
            }
            AlphaAnimation alphaAnimation = new AlphaAnimation(f16, lower);
            alphaAnimation.setDuration(duration);
            alphaAnimation.setFillAfter(true);
            return alphaAnimation;
        }

        /* JADX WARN: Type inference failed for: r2v29, types: [com.tencent.state.map.MapItem] */
        public final boolean scaleToCenter(final View target, float pivotX, float pivotY, final Function0<Unit> onFinish) {
            int avatarHeight;
            ?? data;
            Location location;
            Intrinsics.checkNotNullParameter(target, "target");
            final MapViewHolder<?> mapViewHolder = MapViewKt.getMapViewHolder(target);
            float avatarWidth = BaseMapView.this.getConfig().getAvatarConfig().getAvatarWidth();
            if (mapViewHolder != null && (data = mapViewHolder.getData()) != 0 && (location = data.getLocation()) != null) {
                avatarHeight = location.getWidth();
            } else {
                avatarHeight = BaseMapView.this.getConfig().getAvatarConfig().getAvatarHeight();
            }
            final float f16 = avatarWidth / avatarHeight;
            if (BaseMapView.this.isInDetailMode()) {
                f16 = BaseMapView.this.getCurrentZoomRatio();
            }
            float f17 = 1;
            float f18 = 2;
            float width = (BaseMapView.this.getContainer().getWidth() * (f17 - BaseMapView.this.getCurrentZoomRatio())) / f18;
            float height = (BaseMapView.this.getContainer().getHeight() * (f17 - BaseMapView.this.getCurrentZoomRatio())) / f18;
            float currentZoomRatio = width + (pivotX * BaseMapView.this.getCurrentZoomRatio());
            float width2 = (BaseMapView.this.getContainer().getWidth() / 2) - currentZoomRatio;
            float height2 = (BaseMapView.this.getContainer().getHeight() / 2) - (height + (pivotY * BaseMapView.this.getCurrentZoomRatio()));
            float currentZoomRatio2 = ((f16 / BaseMapView.this.getCurrentZoomRatio()) - f17) * width2;
            float currentZoomRatio3 = ((f16 / BaseMapView.this.getCurrentZoomRatio()) - f17) * height2;
            Point screenCenterOffset = mapViewHolder != null ? BaseMapView.this.getScreenCenterOffset(mapViewHolder) : null;
            SquareBaseKt.getSquareLog().i(BaseMapView.TAG, String.valueOf(screenCenterOffset));
            float mapOffsetY = height2 + currentZoomRatio3 + BaseMapView.this.getScaleState().getMapOffsetY() + (screenCenterOffset != null ? screenCenterOffset.y : 0);
            int mapOffsetX = BaseMapView.this.isInDetailMode() ? 0 : (int) (width2 + currentZoomRatio2 + BaseMapView.this.getScaleState().getMapOffsetX() + (screenCenterOffset != null ? screenCenterOffset.x : 0));
            int i3 = BaseMapView.this.isInDetailMode() ? 0 : (int) mapOffsetY;
            final float currentZoomRatio4 = BaseMapView.this.getCurrentZoomRatio();
            ViewPropertyAnimator animate = BaseMapView.this.getContainer().animate();
            BaseMapView.this.pauseFilament(ViewportChangeReason.SCALE_TO_CENTER);
            animate.scaleX(f16).scaleY(f16).setDuration(500L).translationX(mapOffsetX).translationY(i3).setUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.tencent.state.map.BaseMapView$AnimateState$scaleToCenter$1
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public final void onAnimationUpdate(ValueAnimator it) {
                    Intrinsics.checkNotNullExpressionValue(it, "it");
                    Object animatedValue = it.getAnimatedValue();
                    if (animatedValue != null) {
                        float floatValue = ((Float) animatedValue).floatValue();
                        float f19 = currentZoomRatio4;
                        float f26 = f19 + (floatValue * (f16 - f19));
                        BaseMapView.this.getScaleState().setCurrentZoomRatio(f26);
                        IMapLocator locator = BaseMapView.this.getLocator();
                        if (locator != null) {
                            IMapLocatorKt.updateViewPort(locator, f26);
                            return;
                        }
                        return;
                    }
                    throw new NullPointerException("null cannot be cast to non-null type kotlin.Float");
                }
            }).setListener(new AnimatorListenerAdapter() { // from class: com.tencent.state.map.BaseMapView$AnimateState$scaleToCenter$2
                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animation) {
                    MapItemController controller;
                    MapAdapter adapter = BaseMapView.this.getAdapter();
                    if (adapter != null && (controller = adapter.getController()) != null) {
                        controller.setBlockScale(false);
                    }
                    BaseMapView.this.getContainer().animate().setListener(null);
                    BaseMapView.AnimateState.this.doOutAnim(mapViewHolder, target);
                    BaseMapView.this.getScaleState().setCurrentZoomRatio(currentZoomRatio4);
                    BaseMapView.this.resumeFilament(ViewportChangeReason.SCALE_TO_CENTER, ViewportChangeReason.ZOOM);
                    Function0 function0 = onFinish;
                    if (function0 != null) {
                    }
                }

                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationStart(Animator animation) {
                    BaseMapView.AnimateState.this.doEnterAnim(mapViewHolder, target);
                }
            }).start();
            if (mapViewHolder != null) {
                BaseMapView.this.startViewAlpha(mapViewHolder);
            }
            BaseMapView baseMapView = BaseMapView.this;
            if (baseMapView.isInDetailMode()) {
                target = null;
            }
            baseMapView.scaledTarget = target;
            return BaseMapView.this.isInDetailMode();
        }

        public final void startOtherViewAlpha(final ArrayList<Integer> filterSet) {
            Intrinsics.checkNotNullParameter(filterSet, "filterSet");
            final Animation alpha$default = alpha$default(this, 0.0f, 1.0f, 0L, 4, null);
            ViewExtensionsKt.forEachChild(BaseMapView.this.getContainer(), new Function1<View, Unit>() { // from class: com.tencent.state.map.BaseMapView$AnimateState$startOtherViewAlpha$1
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(View view) {
                    invoke2(view);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(View it) {
                    boolean contains;
                    Intrinsics.checkNotNullParameter(it, "it");
                    if ((it instanceof ImageView) || (it instanceof ScrollCenterIgnoreHide)) {
                        return;
                    }
                    ViewGroup.LayoutParams layoutParams = it.getLayoutParams();
                    if (!(layoutParams instanceof BaseMapView.LayoutParams)) {
                        layoutParams = null;
                    }
                    BaseMapView.LayoutParams layoutParams2 = (BaseMapView.LayoutParams) layoutParams;
                    MapViewHolder<?> holder = layoutParams2 != null ? layoutParams2.getHolder() : null;
                    contains = CollectionsKt___CollectionsKt.contains(filterSet, holder != null ? Integer.valueOf(holder.getIndex()) : null);
                    if (contains) {
                        return;
                    }
                    if (it.getAlpha() == 0.0f && BaseMapView.this.isInDetailMode()) {
                        it.setAlpha(1.0f);
                    }
                    it.startAnimation(alpha$default);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void doEnterAnim(MapViewHolder<?> targetHolder, View target) {
            if (targetHolder != null) {
                boolean z16 = !BaseMapView.this.isInDetailMode();
                targetHolder.onCenterScaled(z16, false);
                if (z16) {
                    IMapViewListener listener = BaseMapView.this.getListener();
                    if (listener != null) {
                        int index = targetHolder.getIndex();
                        MapAdapter adapter = BaseMapView.this.getAdapter();
                        listener.onCenterScaled(true, target, index, adapter != null ? adapter.getItemData(targetHolder.getIndex()) : null);
                        return;
                    }
                    return;
                }
                IMapPlayManager rpm = BaseMapView.this.getRpm();
                if (rpm != null) {
                    rpm.onCenterScaled(false);
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void doOutAnim(MapViewHolder<?> targetHolder, View target) {
            MapItemController controller;
            if (targetHolder != null) {
                boolean isInDetailMode = BaseMapView.this.isInDetailMode();
                targetHolder.onCenterScaled(isInDetailMode, true);
                if (isInDetailMode) {
                    IMapPlayManager rpm = BaseMapView.this.getRpm();
                    if (rpm != null) {
                        rpm.onCenterScaled(true);
                        return;
                    }
                    return;
                }
                MapAdapter adapter = BaseMapView.this.getAdapter();
                if (adapter != null && (controller = adapter.getController()) != null) {
                    controller.setBlockClick(false);
                }
                IMapViewListener listener = BaseMapView.this.getListener();
                if (listener != null) {
                    int index = targetHolder.getIndex();
                    MapAdapter adapter2 = BaseMapView.this.getAdapter();
                    listener.onCenterScaled(false, target, index, adapter2 != null ? adapter2.getItemData(targetHolder.getIndex()) : null);
                }
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ boolean scaleToCenter$default(AnimateState animateState, View view, float f16, float f17, Function0 function0, int i3, Object obj) {
            if ((i3 & 8) != 0) {
                function0 = null;
            }
            return animateState.scaleToCenter(view, f16, f17, function0);
        }

        static /* synthetic */ Animation alpha$default(AnimateState animateState, float f16, float f17, long j3, int i3, Object obj) {
            if ((i3 & 4) != 0) {
                j3 = 500;
            }
            return animateState.alpha(f16, f17, j3);
        }
    }

    /* compiled from: P */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0086\u0004\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0010\u0010\u001e\u001a\u00020\u00042\u0006\u0010\u001f\u001a\u00020\u0010H\u0002J \u0010 \u001a\u00020\n2\u0006\u0010!\u001a\u00020\u00042\u0006\u0010\"\u001a\u00020\n2\u0006\u0010#\u001a\u00020\u0004H\u0002J\u0006\u0010$\u001a\u00020\u0010J\u0006\u0010%\u001a\u00020\u0010J\u0018\u0010&\u001a\u00020'2\u0006\u0010\u0019\u001a\u00020\u00042\u0006\u0010(\u001a\u00020\nH\u0002J\u0010\u0010)\u001a\u00020'2\b\u0010*\u001a\u0004\u0018\u00010+JC\u0010,\u001a\u00020'2\u0006\u0010-\u001a\u00020\n2\u0006\u0010.\u001a\u00020\n2\u0006\u0010/\u001a\u00020\u00042#\u00100\u001a\u001f\u0012\u0013\u0012\u00110\u0010\u00a2\u0006\f\b2\u0012\b\b3\u0012\u0004\b\b(4\u0012\u0004\u0012\u00020'\u0018\u000101J7\u00105\u001a\u00020'2\u0006\u0010\u001f\u001a\u00020\u00102\n\b\u0002\u00106\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u00107\u001a\u0004\u0018\u0001082\n\b\u0002\u00109\u001a\u0004\u0018\u00010:\u00a2\u0006\u0002\u0010;J \u0010<\u001a\u00020'2\u0006\u0010=\u001a\u00020\u00102\u0006\u0010>\u001a\u00020\n2\u0006\u0010?\u001a\u00020\nH\u0002R\u001a\u0010\u0003\u001a\u00020\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u00020\nX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0010X\u0082\u000e\u00a2\u0006\u0002\n\u0000R*\u0010\u0012\u001a\u001e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\n0\u0013j\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\n`\u0014X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0011\u0010\u0015\u001a\u00020\u00048F\u00a2\u0006\u0006\u001a\u0004\b\u0016\u0010\u0006R\u0011\u0010\u0017\u001a\u00020\u00048F\u00a2\u0006\u0006\u001a\u0004\b\u0018\u0010\u0006R\u001a\u0010\u0019\u001a\u00020\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u0006\"\u0004\b\u001b\u0010\bR\u000e\u0010\u001c\u001a\u00020\u001dX\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006@"}, d2 = {"Lcom/tencent/state/map/BaseMapView$ScaleState;", "", "(Lcom/tencent/state/map/BaseMapView;)V", "current", "", "getCurrent", "()I", "setCurrent", "(I)V", "currentZoomRatio", "", "getCurrentZoomRatio", "()F", "setCurrentZoomRatio", "(F)V", "isGestureZooming", "", "isMapZooming", "levelRatioMap", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "mapOffsetX", "getMapOffsetX", "mapOffsetY", "getMapOffsetY", "next", "getNext", "setNext", "scaleDetector", "Landroid/view/ScaleGestureDetector;", "getNextScaleLevel", "isZoomIn", "getZoomMapOriginDistance", "scroll", Element.ELEMENT_NAME_DISTANCE, "boxShort", "initialize", "isZooming", "onMapZoomEnd", "", "scaleTo", "onTouchEvent", "event", "Landroid/view/MotionEvent;", "scaleToTarget", "pivotX", "pivotY", "yOffSet", "endCallback", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "success", "zoomMap", "nextLevel", "duration", "", "pivotPoint", "Landroid/graphics/PointF;", "(ZLjava/lang/Integer;Ljava/lang/Long;Landroid/graphics/PointF;)V", "zoomToDetail", "isZoomOut", HippyTKDListViewAdapter.X, "y", "state_square_debug"}, k = 1, mv = {1, 4, 1})
    /* loaded from: classes34.dex */
    public final class ScaleState {
        private boolean isGestureZooming;
        private boolean isMapZooming;
        private final ScaleGestureDetector scaleDetector;
        private int current = 2;
        private int next = 2;
        private final HashMap<Integer, Float> levelRatioMap = new HashMap<>();
        private float currentZoomRatio = 1.0f;

        public ScaleState() {
            this.scaleDetector = new ScaleGestureDetector(BaseMapView.this.getContext(), new ScaleGestureDetector.SimpleOnScaleGestureListener() { // from class: com.tencent.state.map.BaseMapView$ScaleState$scaleDetector$1
                private float focusX;
                private float focusY;

                @Override // android.view.ScaleGestureDetector.SimpleOnScaleGestureListener, android.view.ScaleGestureDetector.OnScaleGestureListener
                public boolean onScale(ScaleGestureDetector detector) {
                    Intrinsics.checkNotNullParameter(detector, "detector");
                    if (SquareBaseKt.getSquareLog().isColorLevel()) {
                        SquareBaseKt.getSquareLog().i("Square_MapView", "onScale: " + detector.getScaleFactor() + ", focusX=" + detector.getFocusX() + ", focusY=" + detector.getFocusY());
                    }
                    ISquareViewDetectorCallback detectorCallback = BaseMapView.this.getDetectorCallback();
                    if (detectorCallback != null) {
                        detectorCallback.onDetectorScale();
                    }
                    return super.onScale(detector);
                }

                @Override // android.view.ScaleGestureDetector.SimpleOnScaleGestureListener, android.view.ScaleGestureDetector.OnScaleGestureListener
                public boolean onScaleBegin(ScaleGestureDetector detector) {
                    Intrinsics.checkNotNullParameter(detector, "detector");
                    if (SquareBaseKt.getSquareLog().isColorLevel()) {
                        SquareBaseKt.getSquareLog().i("Square_MapView", "onScaleBegin: " + detector.getScaleFactor() + ", focusX=" + detector.getFocusX() + ", focusY=" + detector.getFocusY());
                    }
                    BaseMapView.ScaleState.this.isGestureZooming = true;
                    this.focusX = detector.getFocusX();
                    this.focusY = detector.getFocusY();
                    BaseMapView.this.getScrollState().getScroller().forceFinished(true);
                    return super.onScaleBegin(detector);
                }

                @Override // android.view.ScaleGestureDetector.SimpleOnScaleGestureListener, android.view.ScaleGestureDetector.OnScaleGestureListener
                public void onScaleEnd(ScaleGestureDetector detector) {
                    Intrinsics.checkNotNullParameter(detector, "detector");
                    float f16 = 2;
                    BaseMapView.ScaleState.zoomMap$default(BaseMapView.ScaleState.this, detector.getScaleFactor() < 1.0f, null, null, new PointF(detector.getFocusX() + (detector.getCurrentSpanX() / f16), detector.getFocusY() + (detector.getCurrentSpanY() / f16)), 6, null);
                    BaseMapView.ScaleState.this.zoomToDetail(detector.getScaleFactor() > 1.0f, this.focusX, this.focusY);
                    BaseMapView.ScaleState.this.isGestureZooming = false;
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void onMapZoomEnd(int next, float scaleTo) {
            boolean z16 = this.current > next;
            this.current = next;
            this.isMapZooming = false;
            MapViewDataObserver observer = BaseMapView.this.getObserver();
            if (observer != null) {
                observer.checkRecycleAndFill();
            }
            BaseMapView.this.onScrollIdled();
            IMapViewListener listener = BaseMapView.this.getListener();
            if (listener != null) {
                listener.onMapZoomEnd(this.current, scaleTo, z16);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void zoomToDetail(boolean isZoomOut, float x16, float y16) {
            MapViewHolder<?> mapViewHolder;
            if (this.current == 4 && isZoomOut) {
                View findNearestViewInScreen = BaseMapView.this.getViewFinder().findNearestViewInScreen(x16, y16);
                SquareBaseKt.getSquareLog().i(BaseMapView.TAG, "findCenterView zoomMap");
                if (findNearestViewInScreen == null || (mapViewHolder = MapViewKt.getMapViewHolder(findNearestViewInScreen)) == null) {
                    return;
                }
                mapViewHolder.onZoomOverOut();
            }
        }

        public final int getCurrent() {
            return this.current;
        }

        public final float getCurrentZoomRatio() {
            return this.currentZoomRatio;
        }

        public final int getMapOffsetX() {
            return BaseMapView.this.getScrollX();
        }

        public final int getMapOffsetY() {
            return BaseMapView.this.getScrollY();
        }

        public final int getNext() {
            return this.next;
        }

        public final boolean initialize() {
            return BaseMapView.this.post(new Runnable() { // from class: com.tencent.state.map.BaseMapView$ScaleState$initialize$1
                @Override // java.lang.Runnable
                public final void run() {
                    HashMap hashMap;
                    HashMap hashMap2;
                    HashMap hashMap3;
                    HashMap hashMap4;
                    HashMap hashMap5;
                    HashMap hashMap6;
                    HashMap hashMap7;
                    HashMap hashMap8;
                    HashMap hashMap9;
                    HashMap hashMap10;
                    HashMap hashMap11;
                    IMapLocator locator = BaseMapView.this.getLocator();
                    int mapWidth = locator != null ? locator.getMapWidth() : 0;
                    IMapLocator locator2 = BaseMapView.this.getLocator();
                    int mapHeight = locator2 != null ? locator2.getMapHeight() : 0;
                    if (BaseMapView.this.getWidth() == 0 || BaseMapView.this.getHeight() == 0 || mapWidth == 0 || mapHeight == 0) {
                        hashMap = BaseMapView.ScaleState.this.levelRatioMap;
                        hashMap.put(0, Float.valueOf(0.2f));
                    } else {
                        hashMap11 = BaseMapView.ScaleState.this.levelRatioMap;
                        hashMap11.put(0, Float.valueOf(Math.max(BaseMapView.this.getWidth() / mapWidth, BaseMapView.this.getHeight() / mapHeight)));
                    }
                    hashMap2 = BaseMapView.ScaleState.this.levelRatioMap;
                    hashMap2.put(4, Float.valueOf(1.4f));
                    hashMap3 = BaseMapView.ScaleState.this.levelRatioMap;
                    hashMap3.put(3, Float.valueOf(1.0f));
                    hashMap4 = BaseMapView.ScaleState.this.levelRatioMap;
                    hashMap5 = BaseMapView.ScaleState.this.levelRatioMap;
                    Float f16 = (Float) hashMap5.get(0);
                    if (f16 == null) {
                        f16 = Float.valueOf(0.7f);
                    }
                    float floatValue = f16.floatValue();
                    hashMap6 = BaseMapView.ScaleState.this.levelRatioMap;
                    Float f17 = (Float) hashMap6.get(3);
                    if (f17 == null) {
                        f17 = Float.valueOf(1.0f);
                    }
                    Intrinsics.checkNotNullExpressionValue(f17, "levelRatioMap[ZoomLevel.\u2026_IN_3] ?: ZOOM_IN_3_RATIO");
                    float floatValue2 = floatValue + f17.floatValue();
                    float f18 = 2;
                    hashMap4.put(2, Float.valueOf(floatValue2 / f18));
                    hashMap7 = BaseMapView.ScaleState.this.levelRatioMap;
                    hashMap8 = BaseMapView.ScaleState.this.levelRatioMap;
                    Float f19 = (Float) hashMap8.get(0);
                    if (f19 == null) {
                        f19 = Float.valueOf(0.4f);
                    }
                    float floatValue3 = f19.floatValue();
                    hashMap9 = BaseMapView.ScaleState.this.levelRatioMap;
                    Float f26 = (Float) hashMap9.get(2);
                    if (f26 == null) {
                        f26 = Float.valueOf(0.7f);
                    }
                    Intrinsics.checkNotNullExpressionValue(f26, "levelRatioMap[ZoomLevel.\u2026_IN_2] ?: ZOOM_IN_2_RATIO");
                    hashMap7.put(1, Float.valueOf((floatValue3 + f26.floatValue()) / f18));
                    SquareLogger squareLog = SquareBaseKt.getSquareLog();
                    StringBuilder sb5 = new StringBuilder();
                    sb5.append("ScaleState init levelRatioMap = ");
                    hashMap10 = BaseMapView.ScaleState.this.levelRatioMap;
                    sb5.append(hashMap10);
                    squareLog.i("Square_MapView", sb5.toString());
                }
            });
        }

        public final boolean isZooming() {
            return this.isGestureZooming || this.isMapZooming;
        }

        public final void onTouchEvent(MotionEvent event) {
            MapItemController controller;
            if (BaseMapView.this.getConfig().getIsZoomEnabled()) {
                MapAdapter adapter = BaseMapView.this.getAdapter();
                if (adapter == null || (controller = adapter.getController()) == null || !controller.getBlockScale()) {
                    this.scaleDetector.onTouchEvent(event);
                }
            }
        }

        public final void scaleToTarget(float pivotX, float pivotY, int yOffSet, Function1<? super Boolean, Unit> endCallback) {
            if (this.isMapZooming) {
                return;
            }
            this.isMapZooming = true;
            float f16 = 1;
            float f17 = 2;
            float width = (BaseMapView.this.getContainer().getWidth() * (f16 - this.currentZoomRatio)) / f17;
            float height = BaseMapView.this.getContainer().getHeight();
            float f18 = this.currentZoomRatio;
            float width2 = (BaseMapView.this.getContainer().getWidth() / 2) - (width + (pivotX * f18));
            float height2 = (BaseMapView.this.getContainer().getHeight() / 2) - (((height * (f16 - f18)) / f17) + (pivotY * f18));
            float f19 = this.currentZoomRatio;
            float mapOffsetY = height2 + (((0.7f / f19) - f16) * height2) + BaseMapView.this.getScaleState().getMapOffsetY() + yOffSet;
            int mapOffsetX = BaseMapView.this.isInDetailMode() ? 0 : (int) (width2 + (((0.7f / f19) - f16) * width2) + BaseMapView.this.getScaleState().getMapOffsetX());
            int i3 = BaseMapView.this.isInDetailMode() ? 0 : (int) mapOffsetY;
            ViewPropertyAnimator animate = BaseMapView.this.getContainer().animate();
            BaseMapView.this.pauseFilament(ViewportChangeReason.SCALE_TO_TARGET);
            animate.setDuration(500L).scaleX(0.7f).scaleY(0.7f).translationX(mapOffsetX).translationY(i3).setInterpolator(new AccelerateInterpolator()).setUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.tencent.state.map.BaseMapView$ScaleState$scaleToTarget$1
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public final void onAnimationUpdate(ValueAnimator it) {
                    Intrinsics.checkNotNullExpressionValue(it, "it");
                    Object animatedValue = it.getAnimatedValue();
                    if (animatedValue != null) {
                        float currentZoomRatio = BaseMapView.ScaleState.this.getCurrentZoomRatio() + (((Float) animatedValue).floatValue() * (0.7f - BaseMapView.ScaleState.this.getCurrentZoomRatio()));
                        BaseMapView.ScaleState.this.setCurrentZoomRatio(currentZoomRatio);
                        IMapLocator locator = BaseMapView.this.getLocator();
                        if (locator != null) {
                            IMapLocatorKt.updateViewPort(locator, currentZoomRatio);
                            return;
                        }
                        return;
                    }
                    throw new NullPointerException("null cannot be cast to non-null type kotlin.Float");
                }
            }).setListener(new BaseMapView$ScaleState$scaleToTarget$2(this, animate, endCallback)).start();
        }

        public final void setCurrent(int i3) {
            this.current = i3;
        }

        public final void setCurrentZoomRatio(float f16) {
            this.currentZoomRatio = f16;
        }

        public final void setNext(int i3) {
            this.next = i3;
        }

        private final int getNextScaleLevel(boolean isZoomIn) {
            int i3;
            int coerceAtLeast;
            int coerceAtMost;
            if (isZoomIn) {
                i3 = this.current - 1;
            } else {
                i3 = this.current + 1;
            }
            coerceAtLeast = RangesKt___RangesKt.coerceAtLeast(i3, 0);
            coerceAtMost = RangesKt___RangesKt.coerceAtMost(coerceAtLeast, 4);
            return coerceAtMost;
        }

        public final void zoomMap(boolean isZoomIn, Integer nextLevel, Long duration, PointF pivotPoint) {
            int nextScaleLevel;
            int i3;
            if (this.isMapZooming) {
                return;
            }
            if (nextLevel != null) {
                nextScaleLevel = nextLevel.intValue();
            } else {
                nextScaleLevel = getNextScaleLevel(isZoomIn);
            }
            this.next = nextScaleLevel;
            if (nextScaleLevel == this.current) {
                return;
            }
            this.isMapZooming = true;
            Float f16 = this.levelRatioMap.get(Integer.valueOf(nextScaleLevel));
            if (f16 == null) {
                f16 = Float.valueOf(0.7f);
            }
            Intrinsics.checkNotNullExpressionValue(f16, "levelRatioMap[next] ?: ZOOM_IN_2_RATIO");
            final float floatValue = f16.floatValue();
            Float f17 = this.levelRatioMap.get(Integer.valueOf(this.current));
            if (f17 == null) {
                f17 = Float.valueOf(0.7f);
            }
            Intrinsics.checkNotNullExpressionValue(f17, "levelRatioMap[current] ?: ZOOM_IN_2_RATIO");
            final float floatValue2 = f17.floatValue();
            float abs = Math.abs(floatValue - floatValue2);
            boolean isColorLevel = SquareBaseKt.getSquareLog().isColorLevel();
            ViewPropertyAnimator animate = BaseMapView.this.getContainer().animate();
            if (nextScaleLevel != 0 && ((nextScaleLevel != 1 || this.current != 2) && ((nextScaleLevel != 2 || this.current != 3) && (nextScaleLevel != 3 || this.current != 4)))) {
                int i16 = BaseMapView.this.getScrollX() >= 0 ? -1 : 1;
                int i17 = BaseMapView.this.getScrollY() >= 0 ? -1 : 1;
                if (pivotPoint != null) {
                    float f18 = 2;
                    float zoomMapOriginDistance = ((getZoomMapOriginDistance(BaseMapView.this.getScrollY(), pivotPoint.y, BaseMapView.this.getHeight()) * abs) / f18) * i17;
                    float zoomMapOriginDistance2 = ((getZoomMapOriginDistance(BaseMapView.this.getScrollX(), pivotPoint.x, BaseMapView.this.getWidth()) * abs) / f18) * i16;
                    animate.translationXBy(zoomMapOriginDistance2);
                    animate.translationYBy(zoomMapOriginDistance);
                    if (SquareBaseKt.getSquareLog().isColorLevel()) {
                        SquareBaseKt.getSquareLog().i(BaseMapView.TAG, "zoomMap out: x=" + zoomMapOriginDistance2);
                        SquareBaseKt.getSquareLog().i(BaseMapView.TAG, "zoomMap out: y=" + zoomMapOriginDistance);
                    }
                }
                i3 = nextScaleLevel;
            } else {
                float f19 = 2;
                float width = (-Math.abs(BaseMapView.this.getScrollX())) + ((BaseMapView.this.getContainer().getWidth() * floatValue) / f19);
                float height = (-Math.abs(BaseMapView.this.getScrollY())) + ((BaseMapView.this.getContainer().getHeight() * floatValue) / f19);
                int width2 = BaseMapView.this.getWidth() / 2;
                int height2 = BaseMapView.this.getHeight() / 2;
                if (isColorLevel) {
                    SquareLogger squareLog = SquareBaseKt.getSquareLog();
                    StringBuilder sb5 = new StringBuilder();
                    i3 = nextScaleLevel;
                    sb5.append("zoomMap = sX:");
                    sb5.append(BaseMapView.this.getScrollX());
                    sb5.append(", sY:");
                    sb5.append(BaseMapView.this.getScrollY());
                    sb5.append(", xB:");
                    sb5.append(width);
                    sb5.append(", yB:");
                    sb5.append(height);
                    sb5.append(", xL:");
                    sb5.append(width2);
                    sb5.append(", yL:");
                    sb5.append(height2);
                    sb5.append(", px: ");
                    sb5.append(pivotPoint != null ? Float.valueOf(pivotPoint.x) : null);
                    sb5.append(", py: ");
                    sb5.append(pivotPoint != null ? Float.valueOf(pivotPoint.y) : null);
                    sb5.append(", container.width=");
                    sb5.append(BaseMapView.this.getContainer().getWidth() / 2);
                    sb5.append(", container.height=");
                    sb5.append(BaseMapView.this.getContainer().getHeight() / 2);
                    squareLog.i(BaseMapView.TAG, sb5.toString());
                } else {
                    i3 = nextScaleLevel;
                }
                int i18 = BaseMapView.this.getScrollX() >= 0 ? 1 : -1;
                int i19 = BaseMapView.this.getScrollY() >= 0 ? 1 : -1;
                float f26 = width2;
                if (width < f26) {
                    float f27 = (f26 - width) * i18;
                    animate.translationXBy(f27);
                    if (isColorLevel) {
                        SquareBaseKt.getSquareLog().i(BaseMapView.TAG, "zoomMap in: x < , " + f27);
                    }
                } else if (pivotPoint != null) {
                    float zoomMapOriginDistance3 = ((getZoomMapOriginDistance(BaseMapView.this.getScrollX(), pivotPoint.x, BaseMapView.this.getWidth()) * abs) / f19) * i18;
                    animate.translationXBy(zoomMapOriginDistance3);
                    if (isColorLevel) {
                        SquareBaseKt.getSquareLog().i(BaseMapView.TAG, "zoomMap in: x > , " + zoomMapOriginDistance3);
                    }
                }
                float f28 = height2;
                if (height < f28) {
                    float f29 = (f28 - height) * i19;
                    animate.translationYBy(f29);
                    if (isColorLevel) {
                        SquareBaseKt.getSquareLog().i(BaseMapView.TAG, "zoomMap in: y < , " + f29);
                    }
                } else if (pivotPoint != null) {
                    float zoomMapOriginDistance4 = ((getZoomMapOriginDistance(BaseMapView.this.getScrollY(), pivotPoint.y, BaseMapView.this.getHeight()) * abs) / f19) * i19;
                    animate.translationYBy(zoomMapOriginDistance4);
                    if (SquareBaseKt.getSquareLog().isColorLevel()) {
                        SquareBaseKt.getSquareLog().i(BaseMapView.TAG, "zoomMap in: y > , " + zoomMapOriginDistance4);
                    }
                }
            }
            BaseMapView.this.getContainer().setPivotX(BaseMapView.this.getContainer().getWidth() / 2.0f);
            BaseMapView.this.getContainer().setPivotY(BaseMapView.this.getContainer().getHeight() / 2.0f);
            BaseMapView.this.pauseFilament(ViewportChangeReason.ZOOM);
            animate.scaleX(floatValue).scaleY(floatValue).setDuration(duration != null ? duration.longValue() : 500L).setUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.tencent.state.map.BaseMapView$ScaleState$zoomMap$4
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public final void onAnimationUpdate(ValueAnimator it) {
                    Intrinsics.checkNotNullExpressionValue(it, "it");
                    Object animatedValue = it.getAnimatedValue();
                    if (animatedValue != null) {
                        float floatValue3 = ((Float) animatedValue).floatValue();
                        float f36 = floatValue2;
                        float f37 = f36 + (floatValue3 * (floatValue - f36));
                        BaseMapView.ScaleState.this.setCurrentZoomRatio(f37);
                        IMapLocator locator = BaseMapView.this.getLocator();
                        if (locator != null) {
                            IMapLocatorKt.updateViewPort(locator, f37);
                            return;
                        }
                        return;
                    }
                    throw new NullPointerException("null cannot be cast to non-null type kotlin.Float");
                }
            }).setListener(new BaseMapView$ScaleState$zoomMap$5(this, animate, i3, floatValue)).start();
            IMapViewListener listener = BaseMapView.this.getListener();
            if (listener != null) {
                listener.onMapZoom(isZoomIn);
            }
        }

        private final float getZoomMapOriginDistance(int scroll, float distance, int boxShort) {
            return scroll > 0 ? scroll + distance : Math.abs(scroll) + (boxShort - distance);
        }

        public static /* synthetic */ void zoomMap$default(ScaleState scaleState, boolean z16, Integer num, Long l3, PointF pointF, int i3, Object obj) {
            if ((i3 & 2) != 0) {
                num = null;
            }
            if ((i3 & 4) != 0) {
                l3 = null;
            }
            if ((i3 & 8) != 0) {
                pointF = null;
            }
            scaleState.zoomMap(z16, num, l3, pointF);
        }
    }

    /* compiled from: P */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\r\b\u0086\u0004\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0006\u0010'\u001a\u00020\u001eJ\u001e\u0010(\u001a\u00020\u001e2\u0006\u0010)\u001a\u00020\u00142\u0006\u0010*\u001a\u00020\u00142\u0006\u0010+\u001a\u00020,J\u0018\u0010-\u001a\u00020\u001e2\u0006\u0010.\u001a\u00020\u00062\u0006\u0010/\u001a\u00020\u0006H\u0002J\u0010\u00100\u001a\u0002012\u0006\u00102\u001a\u000203H\u0002J\u0010\u00104\u001a\u00020\u001e2\u0006\u00105\u001a\u00020\u0014H\u0002J\u0010\u00106\u001a\u00020\u001e2\b\u00107\u001a\u0004\u0018\u000108J\u0018\u00109\u001a\u00020\u001e2\u0006\u0010:\u001a\u00020\u00062\u0006\u0010;\u001a\u00020\u0006H\u0002J\u001e\u0010<\u001a\u00020\u001e2\u0006\u0010=\u001a\u00020\u00142\u0006\u0010>\u001a\u00020\u00142\u0006\u0010?\u001a\u00020\u0014J,\u0010@\u001a\u00020\u00142\u0006\u0010A\u001a\u00020\u00142\b\b\u0002\u0010?\u001a\u00020\u00142\b\b\u0002\u0010B\u001a\u00020\u00142\b\b\u0002\u0010C\u001a\u00020\u0014J\b\u0010D\u001a\u00020\u0004H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0005\u001a\u00020\u00068BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0007\u0010\bR\u0014\u0010\t\u001a\u00020\u00068BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\b\n\u0010\bR\u000e\u0010\u000b\u001a\u00020\fX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001b\u0010\u0013\u001a\u00020\u00148BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0015\u0010\u0016R7\u0010\u0019\u001a\u001f\u0012\u0013\u0012\u00110\u0004\u00a2\u0006\f\b\u001b\u0012\b\b\u001c\u0012\u0004\b\b(\u001d\u0012\u0004\u0012\u00020\u001e\u0018\u00010\u001aX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"R\u0011\u0010#\u001a\u00020$\u00a2\u0006\b\n\u0000\u001a\u0004\b%\u0010&\u00a8\u0006E"}, d2 = {"Lcom/tencent/state/map/BaseMapView$ScrollState;", "", "(Lcom/tencent/state/map/BaseMapView;)V", "canOverMap", "", "containerHeight", "", "getContainerHeight", "()F", "containerWidth", "getContainerWidth", "detector", "Landroid/view/GestureDetector;", "isAutoScroll", "isFlinging", "isOverScrolledX", "isOverScrolledY", "isScrollerScroll", "isScrolling", "overDistance", "", "getOverDistance", "()I", "overDistance$delegate", "Lkotlin/Lazy;", "scrollEndCallback", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "success", "", "getScrollEndCallback", "()Lkotlin/jvm/functions/Function1;", "setScrollEndCallback", "(Lkotlin/jvm/functions/Function1;)V", "scroller", "Landroid/widget/OverScroller;", "getScroller", "()Landroid/widget/OverScroller;", "computeScroll", "doScrollBy", "deltaX", "deltaY", "reason", "Lcom/tencent/state/map/ViewportChangeReason;", "fling", "velocityX", "velocityY", "getExpectedPoint", "Landroid/graphics/PointF;", "location", "Landroid/graphics/Rect;", "onScrollFinished", "from", "onTouchEvent", "event", "Landroid/view/MotionEvent;", "scrollBy", "distanceX", "distanceY", "scrollByDistance", "dx", "dy", "duration", "scrollToCenter", "index", "offset", "maxDuration", "springBack", "state_square_debug"}, k = 1, mv = {1, 4, 1})
    /* loaded from: classes34.dex */
    public final class ScrollState {
        private boolean canOverMap;
        private final GestureDetector detector;
        private boolean isAutoScroll;
        private boolean isFlinging;
        private boolean isOverScrolledX;
        private boolean isOverScrolledY;
        private boolean isScrollerScroll;
        private boolean isScrolling;

        /* renamed from: overDistance$delegate, reason: from kotlin metadata */
        private final Lazy overDistance;
        private Function1<? super Boolean, Unit> scrollEndCallback;
        private final OverScroller scroller;

        public ScrollState() {
            Lazy lazy;
            lazy = LazyKt__LazyJVMKt.lazy(new Function0<Integer>() { // from class: com.tencent.state.map.BaseMapView$ScrollState$overDistance$2
                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Integer invoke() {
                    return Integer.valueOf(invoke2());
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final int invoke2() {
                    boolean z16;
                    z16 = BaseMapView.ScrollState.this.canOverMap;
                    return z16 ? ViewExtensionsKt.calPx(BaseMapView.this.getContext(), 150) : ViewExtensionsKt.dip(BaseMapView.this.getContext(), 0);
                }
            });
            this.overDistance = lazy;
            this.scroller = new OverScroller(BaseMapView.this.getContext(), new LinearInterpolator());
            this.detector = new GestureDetector(BaseMapView.this.getContext(), new GestureDetector.SimpleOnGestureListener() { // from class: com.tencent.state.map.BaseMapView$ScrollState$detector$1
                @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
                public boolean onDoubleTap(MotionEvent e16) {
                    Intrinsics.checkNotNullParameter(e16, "e");
                    BaseMapView.this.onDoubleClicked(e16);
                    return true;
                }

                @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
                public boolean onDown(MotionEvent e16) {
                    BaseMapView.ScrollState.this.isScrolling = false;
                    BaseMapView.ScrollState.this.isOverScrolledX = false;
                    BaseMapView.ScrollState.this.isOverScrolledY = false;
                    BaseMapView.ScrollState.this.isFlinging = false;
                    BaseMapView.ScrollState.this.getScroller().forceFinished(true);
                    return false;
                }

                @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
                public boolean onFling(MotionEvent e16, MotionEvent e26, float velocityX, float velocityY) {
                    boolean z16;
                    boolean z17;
                    boolean z18;
                    boolean z19;
                    if (BaseMapView.this.isInDetailMode() || BaseMapView.this.getScaleState().isZooming()) {
                        return true;
                    }
                    z16 = BaseMapView.ScrollState.this.isOverScrolledX;
                    if (z16) {
                        z19 = BaseMapView.ScrollState.this.canOverMap;
                        if (z19) {
                            return true;
                        }
                    }
                    z17 = BaseMapView.ScrollState.this.isOverScrolledY;
                    if (z17) {
                        z18 = BaseMapView.ScrollState.this.canOverMap;
                        if (z18) {
                            return true;
                        }
                    }
                    float f16 = 3;
                    BaseMapView.ScrollState.this.fling(velocityX / f16, velocityY / f16);
                    return true;
                }

                @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
                public boolean onScroll(MotionEvent e16, MotionEvent e26, float distanceX, float distanceY) {
                    ISquareViewDetectorCallback detectorCallback = BaseMapView.this.getDetectorCallback();
                    if (detectorCallback != null) {
                        detectorCallback.onDetectorScroll();
                    }
                    if (BaseMapView.this.isInDetailMode() || BaseMapView.this.getScaleState().isZooming()) {
                        return true;
                    }
                    BaseMapView.ScrollState.this.scrollBy(distanceX, distanceY);
                    return true;
                }
            });
        }

        private final float getContainerHeight() {
            return BaseMapView.this.getContainer().getHeight() * BaseMapView.this.getCurrentZoomRatio();
        }

        private final float getContainerWidth() {
            return BaseMapView.this.getContainer().getWidth() * BaseMapView.this.getCurrentZoomRatio();
        }

        private final PointF getExpectedPoint(Rect location) {
            float containerWidth;
            float containerHeight;
            IMapLocator locator = BaseMapView.this.getLocator();
            if (locator != null) {
                if (location.centerX() < locator.getViewPort().width() / 2) {
                    containerWidth = ((getContainerWidth() - locator.getViewPort().width()) / 2) + location.left;
                } else if (getContainerWidth() - location.centerX() < locator.getViewPort().width() / 2) {
                    containerWidth = ((getContainerWidth() + locator.getViewPort().width()) / 2) - (getContainerWidth() - location.left);
                } else {
                    containerWidth = (getContainerWidth() - location.width()) / 2;
                }
                if (location.centerY() < locator.getViewPort().height() / 2) {
                    containerHeight = ((getContainerHeight() - locator.getViewPort().height()) / 2) + location.top;
                } else if (getContainerHeight() - location.centerY() < locator.getViewPort().height() / 2) {
                    containerHeight = ((getContainerHeight() + locator.getViewPort().height()) / 2) - (getContainerHeight() - location.top);
                } else {
                    containerHeight = (getContainerHeight() - location.height()) / 2;
                }
                return new PointF(containerWidth, containerHeight);
            }
            return new PointF();
        }

        private final int getOverDistance() {
            return ((Number) this.overDistance.getValue()).intValue();
        }

        private final void onScrollFinished(int from) {
            SquareBaseKt.getSquareLog().i(BaseMapView.TAG, "onScrollFinished: from=" + from + ", isAutoScroll=" + this.isAutoScroll);
            this.isAutoScroll = false;
            Function1<? super Boolean, Unit> function1 = this.scrollEndCallback;
            if (function1 != null) {
                function1.invoke(Boolean.TRUE);
            }
            this.scrollEndCallback = null;
            BaseMapView.this.onScrollIdled();
            BaseMapView.this.resumeFilament(ViewportChangeReason.SCROLL);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void scrollBy(float distanceX, float distanceY) {
            float width;
            float height;
            RectF containerRect$default = BaseMapView.getContainerRect$default(BaseMapView.this, 0.0f, 1, null);
            float f16 = 0;
            if (distanceX <= f16) {
                width = containerRect$default.left;
            } else {
                width = containerRect$default.right - BaseMapView.this.getWidth();
            }
            float scrollX = width - BaseMapView.this.getScrollX();
            if (distanceY <= f16) {
                height = containerRect$default.top;
            } else {
                height = containerRect$default.bottom - BaseMapView.this.getHeight();
            }
            float scrollY = height - BaseMapView.this.getScrollY();
            this.isOverScrolledX = containerRect$default.left - ((float) BaseMapView.this.getScrollX()) > distanceX || (containerRect$default.right - ((float) BaseMapView.this.getWidth())) - ((float) BaseMapView.this.getScrollX()) < distanceX;
            this.isOverScrolledY = containerRect$default.top - ((float) BaseMapView.this.getScrollY()) > distanceY || (containerRect$default.bottom - ((float) BaseMapView.this.getHeight())) - ((float) BaseMapView.this.getScrollY()) < distanceY;
            if (this.isOverScrolledX) {
                distanceX = this.canOverMap ? (float) (distanceX / Math.pow(1.01d, Math.abs(scrollX / 2))) : 0.0f;
            }
            if (this.isOverScrolledY) {
                distanceY = this.canOverMap ? (float) (distanceY / Math.pow(1.01d, Math.abs(scrollY / 2))) : 0.0f;
            }
            doScrollBy((int) distanceX, (int) distanceY, ViewportChangeReason.SCROLL);
            this.isScrolling = true;
        }

        private final boolean springBack() {
            RectF containerRect$default = BaseMapView.getContainerRect$default(BaseMapView.this, 0.0f, 1, null);
            this.scroller.forceFinished(true);
            if (!this.scroller.springBack(BaseMapView.this.getScrollX(), BaseMapView.this.getScrollY(), (int) containerRect$default.left, (int) (containerRect$default.right - BaseMapView.this.getWidth()), (int) containerRect$default.top, (int) (containerRect$default.bottom - BaseMapView.this.getHeight()))) {
                return false;
            }
            BaseMapView.this.invalidate();
            return true;
        }

        public final void computeScroll() {
            boolean z16 = this.isScrollerScroll;
            boolean computeScrollOffset = this.scroller.computeScrollOffset();
            this.isScrollerScroll = computeScrollOffset;
            if (computeScrollOffset) {
                doScrollBy(this.scroller.getCurrX() - BaseMapView.this.getScrollX(), this.scroller.getCurrY() - BaseMapView.this.getScrollY(), ViewportChangeReason.SCROLL);
                BaseMapView.this.postInvalidate();
            }
            if (z16 && !this.isScrollerScroll && !this.isScrolling) {
                onScrollFinished(2);
            } else {
                if (!z16 || this.isScrollerScroll) {
                    return;
                }
                BaseMapView.this.resumeFilament(ViewportChangeReason.SCROLL);
            }
        }

        public final void doScrollBy(int deltaX, int deltaY, ViewportChangeReason reason) {
            double ceil;
            double ceil2;
            Intrinsics.checkNotNullParameter(reason, "reason");
            BaseMapView.this.pauseFilament(reason);
            RegionDecodeDrawable regionDecodeDrawable = BaseMapView.this.backgroundView;
            if (regionDecodeDrawable != null) {
                int width = BaseMapView.this.getContainer().getWidth();
                SquareUtil squareUtil = SquareUtil.INSTANCE;
                float screenWidth$default = (width - SquareUtil.getScreenWidth$default(squareUtil, 0.0f, 1, null)) / ((BaseMapView.this.getContainer().getWidth() * BaseMapView.this.getCurrentZoomRatio()) - SquareUtil.getScreenWidth$default(squareUtil, 0.0f, 1, null));
                float height = (BaseMapView.this.getContainer().getHeight() - SquareUtil.getScreenHeight$default(squareUtil, 0.0f, 1, null)) / ((BaseMapView.this.getContainer().getHeight() * BaseMapView.this.getCurrentZoomRatio()) - SquareUtil.getScreenHeight$default(squareUtil, 0.0f, 1, null));
                if (BaseMapView.this.getScrollX() < 0) {
                    ceil = Math.floor(BaseMapView.this.getScrollX() * screenWidth$default);
                } else {
                    ceil = Math.ceil(BaseMapView.this.getScrollX() * screenWidth$default);
                }
                float f16 = (float) ceil;
                if (BaseMapView.this.getScrollY() < 0) {
                    ceil2 = Math.floor(BaseMapView.this.getScrollY() * height);
                } else {
                    ceil2 = Math.ceil(BaseMapView.this.getScrollY() * height);
                }
                regionDecodeDrawable.onScroll((int) f16, (int) ceil2);
            }
            BaseMapView.this.scrollBy(deltaX, deltaY);
            MapViewDataObserver observer = BaseMapView.this.getObserver();
            if (observer != null) {
                observer.checkRecycleAndFill();
            }
        }

        public final Function1<Boolean, Unit> getScrollEndCallback() {
            return this.scrollEndCallback;
        }

        public final OverScroller getScroller() {
            return this.scroller;
        }

        public final void onTouchEvent(MotionEvent event) {
            MapItemController controller;
            MapAdapter adapter = BaseMapView.this.getAdapter();
            if (adapter == null || (controller = adapter.getController()) == null || !controller.getBlockScroll()) {
                this.detector.onTouchEvent(event);
                if (event != null && event.getAction() == 1 && this.isScrolling) {
                    BaseMapView.this.postDelayed(new Runnable() { // from class: com.tencent.state.map.BaseMapView$ScrollState$onTouchEvent$1
                        @Override // java.lang.Runnable
                        public final void run() {
                            BaseMapView.ScrollState.this.isScrolling = false;
                        }
                    }, 10L);
                    if (this.isFlinging || BaseMapView.this.getScaleState().isZooming() || springBack()) {
                        return;
                    }
                    onScrollFinished(1);
                }
            }
        }

        public final void scrollByDistance(int dx5, int dy5, int duration) {
            this.scroller.startScroll(BaseMapView.this.getScrollX(), BaseMapView.this.getScrollY(), dx5, dy5, duration);
            BaseMapView.this.invalidate();
        }

        public final int scrollToCenter(int index, int duration, int offset, int maxDuration) {
            PointF expectedPoint = getExpectedPoint(BaseMapView.this.getItemLocation(index));
            float f16 = r9.left - expectedPoint.x;
            float scrollX = f16 - BaseMapView.this.getScrollX();
            float scrollY = ((r9.top - expectedPoint.y) - BaseMapView.this.getScrollY()) - offset;
            if (duration < 0) {
                duration = (int) ((((float) com.tencent.state.ViewExtensionsKt.hypotenuse(scrollX, scrollY)) / (com.tencent.state.ViewExtensionsKt.hypotenuse(BaseMapView.this.getConfig().getViewPortWidth(), BaseMapView.this.getConfig().getViewPortHeight()) / 2)) * maxDuration);
            }
            this.isAutoScroll = true;
            this.scroller.startScroll(BaseMapView.this.getScrollX(), BaseMapView.this.getScrollY(), (int) scrollX, (int) scrollY, duration);
            BaseMapView.this.invalidate();
            return duration;
        }

        public final void setScrollEndCallback(Function1<? super Boolean, Unit> function1) {
            this.scrollEndCallback = function1;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void fling(float velocityX, float velocityY) {
            RectF containerRect$default = BaseMapView.getContainerRect$default(BaseMapView.this, 0.0f, 1, null);
            this.scroller.forceFinished(true);
            this.scroller.fling(BaseMapView.this.getScrollX(), BaseMapView.this.getScrollY(), -((int) velocityX), -((int) velocityY), (int) containerRect$default.left, (int) (containerRect$default.right - BaseMapView.this.getWidth()), (int) containerRect$default.top, (int) (containerRect$default.bottom - BaseMapView.this.getHeight()), getOverDistance(), getOverDistance());
            RegionDecodeDrawable regionDecodeDrawable = BaseMapView.this.backgroundView;
            if (regionDecodeDrawable != null) {
                regionDecodeDrawable.onFling(this.scroller.getFinalX(), this.scroller.getFinalY());
            }
            BaseMapView.this.invalidate();
            this.isFlinging = true;
        }

        public static /* synthetic */ int scrollToCenter$default(ScrollState scrollState, int i3, int i16, int i17, int i18, int i19, Object obj) {
            if ((i19 & 2) != 0) {
                i16 = -1;
            }
            if ((i19 & 4) != 0) {
                i17 = 0;
            }
            if ((i19 & 8) != 0) {
                i18 = 500;
            }
            return scrollState.scrollToCenter(i3, i16, i17, i18);
        }
    }

    public BaseMapView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
    }

    /* compiled from: P */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0004\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0018\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J5\u0010\b\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\u00062#\u0010\n\u001a\u001f\u0012\u0013\u0012\u00110\f\u00a2\u0006\f\b\r\u0012\b\b\u000e\u0012\u0004\b\b(\u000f\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u000bH\u0016J=\u0010\b\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\u00062\u0006\u0010\u0010\u001a\u00020\u00062#\u0010\n\u001a\u001f\u0012\u0013\u0012\u00110\f\u00a2\u0006\f\b\r\u0012\b\b\u000e\u0012\u0004\b\b(\u000f\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u000bH\u0016J5\u0010\b\u001a\u00020\u00042\u0006\u0010\u0011\u001a\u00020\u00122#\u0010\n\u001a\u001f\u0012\u0013\u0012\u00110\f\u00a2\u0006\f\b\r\u0012\b\b\u000e\u0012\u0004\b\b(\u000f\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u000bH\u0016J=\u0010\b\u001a\u00020\u00042\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00062#\u0010\n\u001a\u001f\u0012\u0013\u0012\u00110\f\u00a2\u0006\f\b\r\u0012\b\b\u000e\u0012\u0004\b\b(\u000f\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u000bH\u0016J5\u0010\u0014\u001a\u00020\u00042\u0006\u0010\u0015\u001a\u00020\u00062#\u0010\n\u001a\u001f\u0012\u0013\u0012\u00110\f\u00a2\u0006\f\b\r\u0012\b\b\u000e\u0012\u0004\b\b(\u000f\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u000bH\u0016J\u0018\u0010\u0016\u001a\u00020\f2\u000e\u0010\u0017\u001a\n\u0012\u0002\b\u00030\u0018j\u0002`\u0019H\u0016J5\u0010\u001a\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\u00062#\u0010\n\u001a\u001f\u0012\u0013\u0012\u00110\f\u00a2\u0006\f\b\r\u0012\b\b\u000e\u0012\u0004\b\b(\u000f\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u000bH\u0016\u00a8\u0006\u001b"}, d2 = {"Lcom/tencent/state/map/BaseMapView$MapViewManipulator;", "Lcom/tencent/state/map/IMapViewManipulator;", "(Lcom/tencent/state/map/BaseMapView;)V", "adjustBackgroundLocation", "", "avatarCenterX", "", "avatarCenterY", "locateTo", "index", "endCallback", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "success", "duration", "uin", "", "type", "locateToMe", "offset", "scaleToCenter", "holder", "Lcom/tencent/state/map/MapViewHolder;", "Lcom/tencent/state/map/ViewHolder;", "scaleToTarget", "state_square_debug"}, k = 1, mv = {1, 4, 1})
    /* loaded from: classes34.dex */
    public final class MapViewManipulator implements IMapViewManipulator {
        public MapViewManipulator() {
        }

        private final void adjustBackgroundLocation(int avatarCenterX, int avatarCenterY) {
            IMapLocator locator = BaseMapView.this.getLocator();
            if (locator != null) {
                Point distanceToScreenCenter = BaseMapView.this.getDistanceToScreenCenter(locator, avatarCenterX, avatarCenterY);
                int i3 = BaseMapView.this.isInDetailMode() ? 0 : distanceToScreenCenter.x;
                int i16 = BaseMapView.this.isInDetailMode() ? 0 : distanceToScreenCenter.y;
                RegionDecodeDrawable regionDecodeDrawable = BaseMapView.this.backgroundView;
                if (regionDecodeDrawable != null) {
                    regionDecodeDrawable.onTranslate(i3, i16);
                }
            }
        }

        @Override // com.tencent.state.map.IMapViewManipulator
        public void locateTo(final String uin, Function1<? super Boolean, Unit> endCallback) {
            Intrinsics.checkNotNullParameter(uin, "uin");
            MapAdapter adapter = BaseMapView.this.getAdapter();
            if (adapter != null) {
                locateTo(adapter.indexOf(new Function1<MapItem, Boolean>() { // from class: com.tencent.state.map.BaseMapView$MapViewManipulator$locateTo$index$1
                    /* JADX INFO: Access modifiers changed from: package-private */
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Boolean invoke(MapItem mapItem) {
                        return Boolean.valueOf(invoke2(mapItem));
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final boolean invoke2(MapItem it) {
                        Intrinsics.checkNotNullParameter(it, "it");
                        return (!Intrinsics.areEqual(it.getUin(), uin) || (it instanceof ChatLandTableItem) || (it instanceof ChatLandAvatarItem)) ? false : true;
                    }
                }), endCallback);
            }
        }

        @Override // com.tencent.state.map.IMapViewManipulator
        public void locateToMe(int offset, Function1<? super Boolean, Unit> endCallback) {
            MapAdapter adapter = BaseMapView.this.getAdapter();
            if (adapter != null) {
                if (adapter.getMeIndex() >= 0) {
                    BaseMapView.this.getScrollState().setScrollEndCallback(endCallback);
                    ScrollState.scrollToCenter$default(BaseMapView.this.getScrollState(), adapter.getMeIndex(), 0, offset, 500, 2, null);
                } else if (endCallback != null) {
                    endCallback.invoke(Boolean.FALSE);
                }
            }
        }

        /* JADX WARN: Type inference failed for: r10v1, types: [com.tencent.state.map.MapItem] */
        /* JADX WARN: Type inference failed for: r2v7, types: [com.tencent.state.map.MapItem] */
        @Override // com.tencent.state.map.IMapViewManipulator
        public boolean scaleToCenter(MapViewHolder<?> holder) {
            Pair pair;
            Location location;
            Location location2;
            MapItemController controller;
            Intrinsics.checkNotNullParameter(holder, "holder");
            BaseMapView.this.forceFilamentCacheFrameInvisible = true;
            MapAdapter adapter = BaseMapView.this.getAdapter();
            if (adapter != null && (controller = adapter.getController()) != null) {
                controller.setBlockScale(true);
            }
            View view = holder.itemView;
            Intrinsics.checkNotNullExpressionValue(view, "holder.itemView");
            float x16 = view.getX() + (view.getWidth() / 2);
            float y16 = view.getY() + (view.getHeight() / 2);
            if (((MapPlayableViewHolder) (!(holder instanceof MapPlayableViewHolder) ? null : holder)) != null) {
                Location playerViewLocation = ((MapPlayableViewHolder) holder).getPlayerViewLocation();
                pair = new Pair(Integer.valueOf(playerViewLocation.getCenterX()), Integer.valueOf(playerViewLocation.getCenterY()));
            } else {
                ?? data = holder.getData();
                int centerX = (data == 0 || (location2 = data.getLocation()) == null) ? (int) x16 : location2.getCenterX();
                ?? data2 = holder.getData();
                pair = new Pair(Integer.valueOf(centerX), Integer.valueOf((data2 == 0 || (location = data2.getLocation()) == null) ? (int) y16 : location.getCenterY()));
            }
            int intValue = ((Number) pair.component1()).intValue();
            int intValue2 = ((Number) pair.component2()).intValue();
            SquareBaseKt.getSquareLog().i(BaseMapView.TAG, "scaleToCenter: viewCenterX=" + x16 + ", viewCenterY=" + y16 + ", avatarCenterX=" + intValue + ", avatarCenterY=" + intValue2);
            adjustBackgroundLocation(intValue, intValue2);
            return AnimateState.scaleToCenter$default(BaseMapView.this.getAnimateState(), view, intValue, intValue2, null, 8, null);
        }

        @Override // com.tencent.state.map.IMapViewManipulator
        public void scaleToTarget(int index, final Function1<? super Boolean, Unit> endCallback) {
            MapItem itemData;
            MapItemController controller;
            MapAdapter adapter = BaseMapView.this.getAdapter();
            if (adapter == null || (itemData = adapter.getItemData(index)) == null) {
                return;
            }
            MapAdapter adapter2 = BaseMapView.this.getAdapter();
            if (adapter2 != null && (controller = adapter2.getController()) != null) {
                controller.setBlockScale(true);
            }
            int centerX = itemData.getLocation().getCenterX();
            int centerY = itemData.getLocation().getCenterY();
            SquareBaseKt.getSquareLog().i(BaseMapView.TAG, "scaleToTarget: avatarCenterX=" + centerX + ", avatarCenterY=" + centerY);
            adjustBackgroundLocation(centerX, centerY);
            if (!(itemData instanceof SquareAvatarItem)) {
                itemData = null;
            }
            SquareAvatarItem squareAvatarItem = (SquareAvatarItem) itemData;
            BaseMapView.this.getScaleState().scaleToTarget(centerX, centerY, (squareAvatarItem == null || !squareAvatarItem.isMe()) ? 0 : ViewExtensionsKt.dip(BaseMapView.this.getContext(), 95), new Function1<Boolean, Unit>() { // from class: com.tencent.state.map.BaseMapView$MapViewManipulator$scaleToTarget$1
                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
                    invoke(bool.booleanValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(boolean z16) {
                    Function1 function1 = Function1.this;
                    if (function1 != null) {
                    }
                }
            });
        }

        @Override // com.tencent.state.map.IMapViewManipulator
        public void locateTo(final String uin, final int type, Function1<? super Boolean, Unit> endCallback) {
            Intrinsics.checkNotNullParameter(uin, "uin");
            MapAdapter adapter = BaseMapView.this.getAdapter();
            if (adapter != null) {
                locateTo(adapter.indexOf(new Function1<MapItem, Boolean>() { // from class: com.tencent.state.map.BaseMapView$MapViewManipulator$locateTo$index$2
                    /* JADX INFO: Access modifiers changed from: package-private */
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Boolean invoke(MapItem mapItem) {
                        return Boolean.valueOf(invoke2(mapItem));
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final boolean invoke2(MapItem it) {
                        Intrinsics.checkNotNullParameter(it, "it");
                        return Intrinsics.areEqual(it.getUin(), uin) && it.getType() == type;
                    }
                }), endCallback);
            }
        }

        @Override // com.tencent.state.map.IMapViewManipulator
        public void locateTo(int index, Function1<? super Boolean, Unit> endCallback) {
            if (index >= 0) {
                BaseMapView.this.getScrollState().setScrollEndCallback(endCallback);
                ScrollState.scrollToCenter$default(BaseMapView.this.getScrollState(), index, 500, 0, 0, 12, null);
            } else if (endCallback != null) {
                endCallback.invoke(Boolean.FALSE);
            }
        }

        @Override // com.tencent.state.map.IMapViewManipulator
        public void locateTo(int index, int duration, Function1<? super Boolean, Unit> endCallback) {
            if (index >= 0) {
                BaseMapView.this.getScrollState().setScrollEndCallback(endCallback);
                ScrollState.scrollToCenter$default(BaseMapView.this.getScrollState(), index, duration, 0, 0, 12, null);
            } else if (endCallback != null) {
                endCallback.invoke(Boolean.FALSE);
            }
        }
    }

    public /* synthetic */ BaseMapView(Context context, AttributeSet attributeSet, int i3, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i16 & 2) != 0 ? null : attributeSet, (i16 & 4) != 0 ? 0 : i3);
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent ev5) {
        Integer valueOf = ev5 != null ? Integer.valueOf(ev5.getActionMasked()) : null;
        if (valueOf != null && valueOf.intValue() == 0) {
            this.initialTouchX = (int) (ev5.getX() + 0.5f);
            this.initialTouchY = (int) (ev5.getY() + 0.5f);
            return false;
        }
        if (valueOf != null && valueOf.intValue() == 2) {
            return Math.abs(ev5.getX() - ((float) this.initialTouchX)) > ((float) this.touchSlop) || Math.abs(ev5.getY() - ((float) this.initialTouchY)) > ((float) this.touchSlop);
        }
        return false;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BaseMapView(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        Intrinsics.checkNotNullParameter(context, "context");
        MapContainer mapContainer = new MapContainer(context);
        this.container = mapContainer;
        this.manipulator = new MapViewManipulator();
        this.scrollState = new ScrollState();
        this.scaleState = new ScaleState();
        this.animateState = new AnimateState();
        this.viewFinder = new ViewFinder();
        ViewConfiguration viewConfiguration = ViewConfiguration.get(context);
        Intrinsics.checkNotNullExpressionValue(viewConfiguration, "ViewConfiguration.get(context)");
        this.touchSlop = viewConfiguration.getScaledTouchSlop();
        this.config = MapViewConfigKt.defaultMapConfig();
        this.components = new LinkedHashSet();
        this.filamentPausedReasons = new LinkedHashSet();
        setClickable(true);
        setClipChildren(false);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        layoutParams.gravity = 17;
        Unit unit = Unit.INSTANCE;
        addView(mapContainer, layoutParams);
        ViewPropertyAnimator animate = mapContainer.animate();
        Intrinsics.checkNotNullExpressionValue(animate, "container.animate()");
        animate.setInterpolator(new LinearInterpolator());
        mapContainer.setClipChildren(false);
    }

    private final void showFilamentCacheFrame() {
        Bitmap bitmap;
        FilamentMap container;
        TextureView engineView;
        FilamentMap container2;
        TextureView engineView2;
        ImageView filamentCacheFrameView = getFilamentCacheFrameView(true);
        if (filamentCacheFrameView == null || !com.tencent.state.ViewExtensionsKt.isVisible(filamentCacheFrameView)) {
            if (isInDetailMode()) {
                if (this.forceFilamentCacheFrameInvisible) {
                    if (filamentCacheFrameView != null) {
                        com.tencent.state.ViewExtensionsKt.setVisibility(filamentCacheFrameView, false);
                        return;
                    }
                    return;
                } else {
                    if (filamentCacheFrameView != null) {
                        com.tencent.state.ViewExtensionsKt.setVisibility(filamentCacheFrameView, true);
                        return;
                    }
                    return;
                }
            }
            SquareFilamentMapView squareFilamentMapView = this.filamentMap;
            if (squareFilamentMapView == null || (container2 = squareFilamentMapView.getContainer()) == null || (engineView2 = container2.getEngineView()) == null) {
                bitmap = null;
            } else {
                if (engineView2.getWidth() <= 0 || engineView2.getHeight() <= 0) {
                    return;
                }
                bitmap = Bitmap.createBitmap(engineView2.getWidth(), engineView2.getHeight(), Bitmap.Config.ARGB_4444);
                engineView2.getBitmap(bitmap);
            }
            if (bitmap != null && filamentCacheFrameView != null) {
                final int width = bitmap.getWidth();
                final int height = bitmap.getHeight();
                double d16 = width;
                double d17 = 2;
                final double d18 = (d16 - (d16 / 1.0d)) / d17;
                double d19 = height;
                final double d26 = (d19 - (d19 / 1.0d)) / d17;
                SquareFilamentMapView squareFilamentMapView2 = this.filamentMap;
                filamentCacheFrameView.setElevation((squareFilamentMapView2 == null || (container = squareFilamentMapView2.getContainer()) == null || (engineView = container.getEngineView()) == null) ? 0.0f : engineView.getElevation());
                filamentCacheFrameView.setImageBitmap(bitmap);
                filamentCacheFrameView.setScaleType(ImageView.ScaleType.FIT_XY);
                if (this.forceFilamentCacheFrameInvisible) {
                    com.tencent.state.ViewExtensionsKt.setVisibility(filamentCacheFrameView, false);
                } else {
                    com.tencent.state.ViewExtensionsKt.setVisibility(filamentCacheFrameView, true);
                }
                com.tencent.state.ViewExtensionsKt.updateLayoutParams(filamentCacheFrameView, new Function1<FrameLayout.LayoutParams, Unit>() { // from class: com.tencent.state.map.BaseMapView$showFilamentCacheFrame$1
                    /* JADX INFO: Access modifiers changed from: package-private */
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(FrameLayout.LayoutParams layoutParams) {
                        invoke2(layoutParams);
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(FrameLayout.LayoutParams receiver) {
                        Intrinsics.checkNotNullParameter(receiver, "$receiver");
                        float scaleX = BaseMapView.this.getContainer().getScaleX();
                        float scaleY = BaseMapView.this.getContainer().getScaleY();
                        receiver.width = (int) (width / scaleX);
                        receiver.height = (int) (height / scaleY);
                        float f16 = 1;
                        float f17 = 2;
                        float x16 = BaseMapView.this.getContainer().getX() + ((BaseMapView.this.getContainer().getWidth() * (f16 - scaleX)) / f17);
                        float y16 = BaseMapView.this.getContainer().getY() + ((BaseMapView.this.getContainer().getHeight() * (f16 - scaleY)) / f17);
                        receiver.leftMargin = (int) (((BaseMapView.this.getScrollX() - x16) - d18) / scaleX);
                        receiver.topMargin = (int) (((BaseMapView.this.getScrollY() - y16) - d26) / scaleY);
                    }
                });
                return;
            }
            SquareLogger.DefaultImpls.e$default(SquareBaseKt.getSquareLog(), TAG, "showFilamentCacheFrame, imageInfo or imageView is null", null, 4, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void updateFilamentViewport() {
        RectF containerRect$default = getContainerRect$default(this, 0.0f, 1, null);
        SquareFilamentMapView squareFilamentMapView = this.filamentMap;
        if (squareFilamentMapView != null) {
            squareFilamentMapView.onViewportChanged(this.container.getScaleX(), getScrollX(), getScrollY(), containerRect$default);
        }
    }

    static /* synthetic */ RectF getContainerRect$default(BaseMapView baseMapView, float f16, int i3, Object obj) {
        if (obj == null) {
            if ((i3 & 1) != 0) {
                f16 = baseMapView.getCurrentZoomRatio();
            }
            return baseMapView.getContainerRect(f16);
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getContainerRect");
    }

    public static /* synthetic */ RectF getViewLocation$default(BaseMapView baseMapView, View view, RectF rectF, int i3, Object obj) {
        if (obj == null) {
            if ((i3 & 2) != 0) {
                rectF = new RectF();
            }
            return baseMapView.getViewLocation(view, rectF);
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getViewLocation");
    }

    public static /* synthetic */ boolean scaleToMeDetail$default(BaseMapView baseMapView, Object obj, int i3, Object obj2) {
        if (obj2 == null) {
            if ((i3 & 1) != 0) {
                obj = null;
            }
            return baseMapView.scaleToMeDetail(obj);
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: scaleToMeDetail");
    }
}

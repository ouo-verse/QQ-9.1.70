package com.tencent.mobileqq.wink.editor.clipping.timeline.widget.dragdrop;

import android.content.ClipData;
import android.content.Context;
import android.graphics.PointF;
import android.os.Build;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
import android.widget.HorizontalScrollView;
import android.widget.RelativeLayout;
import androidx.core.widget.NestedScrollView;
import androidx.exifinterface.media.ExifInterface;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.autotemplate.filter.TAVOneClickFilmStickerEffect;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mobileqq.wink.editor.clipping.timeline.widget.panel.TimelinePanelViewController;
import com.tencent.mobileqq.wink.editor.clipping.timeline.widget.panel.event.PanelEventHandler;
import com.tencent.mobileqq.wink.editor.clipping.timeline.widget.panel.scroll.FlingHelper;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt___RangesKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u00ee\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\"\n\u0002\b\u000b\n\u0002\u0010\u0000\n\u0002\b4\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005*\u0002\u00ba\u0001\u0018\u0000 \u007f2\u00020\u00012\u00020\u00022\u00020\u0003:\u0001qB.\b\u0007\u0012\b\u0010\u00c8\u0001\u001a\u00030\u00c7\u0001\u0012\f\b\u0002\u0010\u00ca\u0001\u001a\u0005\u0018\u00010\u00c9\u0001\u0012\t\b\u0002\u0010\u00cb\u0001\u001a\u00020\u001e\u00a2\u0006\u0006\b\u00cc\u0001\u0010\u00cd\u0001J\b\u0010\u0005\u001a\u00020\u0004H\u0002J\b\u0010\u0006\u001a\u00020\u0004H\u0002J\b\u0010\u0007\u001a\u00020\u0004H\u0002J\b\u0010\t\u001a\u00020\bH\u0002J\u0012\u0010\f\u001a\u00020\u00042\b\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0002J\b\u0010\r\u001a\u00020\u0004H\u0002J\u0012\u0010\u0010\u001a\u00020\u00042\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eH\u0002J\b\u0010\u0011\u001a\u00020\u0004H\u0002J \u0010\u0018\u001a\u00020\u00042\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0017\u001a\u00020\u0016H\u0002J\u0010\u0010\u001b\u001a\u00020\u001a2\u0006\u0010\u0019\u001a\u00020\nH\u0002J\u0010\u0010\u001f\u001a\u00020\u001e2\u0006\u0010\u001d\u001a\u00020\u001cH\u0002J\u0018\u0010\"\u001a\u00020\u00042\u0006\u0010!\u001a\u00020 2\u0006\u0010\u0015\u001a\u00020\nH\u0002J \u0010%\u001a\u00020\u00042\u0006\u0010#\u001a\u00020\u001e2\u0006\u0010$\u001a\u00020\u001a2\u0006\u0010\u0015\u001a\u00020\nH\u0002J\u0018\u0010'\u001a\u00020\u001a2\u0006\u0010\u0019\u001a\u00020\n2\u0006\u0010&\u001a\u00020\u001eH\u0002J\u0018\u0010)\u001a\u00020\u001a2\u0006\u0010\u0019\u001a\u00020\n2\u0006\u0010(\u001a\u00020\u001eH\u0002J\u0010\u0010*\u001a\u00020\u001a2\u0006\u0010\u0019\u001a\u00020\nH\u0002J\u0010\u0010+\u001a\u00020\u001a2\u0006\u0010\u0019\u001a\u00020\nH\u0002J\u0010\u0010,\u001a\u00020\u001a2\u0006\u0010\u0019\u001a\u00020\nH\u0002J(\u00101\u001a\u00020\u00042\u0006\u0010-\u001a\u00020\u001e2\u0006\u0010.\u001a\u00020\u001e2\u0006\u0010/\u001a\u00020\u001e2\u0006\u00100\u001a\u00020\u001eH\u0014J\u0010\u00104\u001a\u00020\u001a2\u0006\u00103\u001a\u000202H\u0016J\b\u00105\u001a\u00020\u001eH\u0016J\b\u00106\u001a\u00020\u001eH\u0016J\u0018\u0010-\u001a\u00020\u00042\u0006\u00107\u001a\u00020\u001e2\u0006\u00108\u001a\u00020\u001eH\u0016J\u0016\u0010;\u001a\b\u0012\u0004\u0012\u00020:092\u0006\u0010\u000f\u001a\u00020\u000eH\u0016J\b\u0010<\u001a\u00020\u001cH\u0016J\b\u0010=\u001a\u00020\u001eH\u0016J\b\u0010>\u001a\u00020\u001eH\u0016J\b\u0010?\u001a\u00020\u001eH\u0016J\u001f\u0010D\u001a\u00020\u00042\u000e\u0010A\u001a\n\u0012\u0004\u0012\u00020\u001e\u0018\u00010@H\u0000\u00a2\u0006\u0004\bB\u0010CJ\u0017\u0010F\u001a\u00020\u00122\u0006\u0010E\u001a\u00020\u001eH\u0000\u00a2\u0006\u0004\bF\u0010GJ\u001f\u0010H\u001a\u00020\u00042\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0015\u001a\u00020\u0014H\u0000\u00a2\u0006\u0004\bH\u0010IJ\u0019\u0010J\u001a\u00020\u00042\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eH\u0000\u00a2\u0006\u0004\bJ\u0010KJ\u001b\u0010M\u001a\u0004\u0018\u00010\u00142\b\u0010\u000f\u001a\u0004\u0018\u00010LH\u0000\u00a2\u0006\u0004\bM\u0010NJ\u0017\u0010O\u001a\u00020\u00042\u0006\u0010\u0015\u001a\u00020\u0014H\u0000\u00a2\u0006\u0004\bO\u0010PJ\u0010\u0010R\u001a\u00020\u00042\u0006\u0010Q\u001a\u00020\u001eH\u0016J\u000f\u0010S\u001a\u00020\u0004H\u0000\u00a2\u0006\u0004\bS\u0010TJ\u001f\u0010W\u001a\u00020\u00042\u0006\u0010U\u001a\u00020\u00142\u0006\u0010V\u001a\u00020\u001eH\u0000\u00a2\u0006\u0004\bW\u0010XJ\u0010\u0010Y\u001a\u00020\u00042\u0006\u0010\u0015\u001a\u00020\u0014H\u0016J\u000f\u0010Z\u001a\u00020\u001eH\u0000\u00a2\u0006\u0004\bZ\u0010[J\u000f\u0010\\\u001a\u00020\u001eH\u0000\u00a2\u0006\u0004\b\\\u0010[J\u0017\u0010`\u001a\u00020\u00042\u0006\u0010]\u001a\u00020\u001aH\u0000\u00a2\u0006\u0004\b^\u0010_J\u000f\u0010a\u001a\u00020\u0004H\u0000\u00a2\u0006\u0004\ba\u0010TJ\u000f\u0010b\u001a\u00020\u0004H\u0000\u00a2\u0006\u0004\bb\u0010TJ\u000f\u0010c\u001a\u00020\u001aH\u0000\u00a2\u0006\u0004\bc\u0010dJ\u001f\u0010e\u001a\u00020\u00042\u0006\u0010\u0015\u001a\u00020\n2\u0006\u0010!\u001a\u00020 H\u0000\u00a2\u0006\u0004\be\u0010fJ\u0017\u0010i\u001a\u00020\u00042\u0006\u0010g\u001a\u00020\u001aH\u0000\u00a2\u0006\u0004\bh\u0010_J\u001a\u0010k\u001a\u00020\u00042\b\u0010\u0015\u001a\u0004\u0018\u00010\u00142\u0006\u0010j\u001a\u00020\u001aH\u0016J\b\u0010l\u001a\u00020\u001eH\u0016J\u0018\u0010m\u001a\u00020\u00042\u0006\u0010#\u001a\u00020\u001e2\u0006\u0010\u0019\u001a\u00020\nH\u0016J\u001c\u0010p\u001a\u00020\u00042\b\u0010n\u001a\u0004\u0018\u00010:2\b\u0010o\u001a\u0004\u0018\u00010:H\u0016J\b\u0010q\u001a\u00020\u0004H\u0016J\u001f\u0010r\u001a\u00020\u001a2\u0006\u0010\u0019\u001a\u00020\n2\u0006\u0010(\u001a\u00020\u001eH\u0000\u00a2\u0006\u0004\br\u0010sJ\u001f\u0010t\u001a\u00020\u00042\u0006\u0010#\u001a\u00020\u001e2\u0006\u0010\u0015\u001a\u00020\nH\u0000\u00a2\u0006\u0004\bt\u0010uJ\u001b\u0010w\u001a\u00020\u00042\n\b\u0002\u0010v\u001a\u0004\u0018\u00010\u0014H\u0000\u00a2\u0006\u0004\bw\u0010PJ\u0010\u0010y\u001a\u00020\u001e2\u0006\u0010x\u001a\u00020\u001eH\u0016J\u0010\u0010{\u001a\u00020\u001e2\u0006\u0010z\u001a\u00020\u001eH\u0016J\u0017\u0010~\u001a\u00020\u00042\u0006\u0010|\u001a\u00020\u001aH\u0000\u00a2\u0006\u0004\b}\u0010_J\u000f\u0010\u007f\u001a\u00020\u001eH\u0000\u00a2\u0006\u0004\b\u007f\u0010[J\u0011\u0010\u0080\u0001\u001a\u00020\u001eH\u0000\u00a2\u0006\u0005\b\u0080\u0001\u0010[J\u0017\u0010\u0083\u0001\u001a\u00020\u00042\f\u0010\u0082\u0001\u001a\u0007\u0012\u0002\b\u00030\u0081\u0001H\u0016J\u0011\u0010\u0084\u0001\u001a\u00020\u001eH\u0000\u00a2\u0006\u0005\b\u0084\u0001\u0010[J\u001b\u0010\u0086\u0001\u001a\u00020\u00042\u0007\u0010\u0085\u0001\u001a\u00020\u001eH\u0000\u00a2\u0006\u0006\b\u0086\u0001\u0010\u0087\u0001J\u001c\u0010\u008a\u0001\u001a\u00020\u00042\b\u0010\u0089\u0001\u001a\u00030\u0088\u0001H\u0000\u00a2\u0006\u0006\b\u008a\u0001\u0010\u008b\u0001J#\u0010\u008d\u0001\u001a\u00020\u00042\u0006\u0010\u0015\u001a\u00020\n2\u0007\u0010\u008c\u0001\u001a\u00020\u001aH\u0000\u00a2\u0006\u0006\b\u008d\u0001\u0010\u008e\u0001J\u001a\u0010\u008f\u0001\u001a\u00020\u001a2\u0006\u0010\u0019\u001a\u00020\nH\u0000\u00a2\u0006\u0006\b\u008f\u0001\u0010\u0090\u0001J\u0011\u0010\u0091\u0001\u001a\u00020\u0004H\u0000\u00a2\u0006\u0005\b\u0091\u0001\u0010TJ\u001c\u0010\u0094\u0001\u001a\u00020\u00042\b\u0010\u0093\u0001\u001a\u00030\u0092\u0001H\u0000\u00a2\u0006\u0006\b\u0094\u0001\u0010\u0095\u0001R\u0018\u0010\u0096\u0001\u001a\u00020\u001e8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0007\n\u0005\b{\u0010\u008a\u0001R\u001a\u0010\u0098\u0001\u001a\u0004\u0018\u00010\b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0007\n\u0005\b<\u0010\u0097\u0001R+\u0010\u009f\u0001\u001a\u0005\u0018\u00010\u0099\u00018\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0017\n\u0005\b?\u0010\u009a\u0001\u001a\u0006\b\u009b\u0001\u0010\u009c\u0001\"\u0006\b\u009d\u0001\u0010\u009e\u0001R)\u0010\u00a4\u0001\u001a\u0014\u0012\u0004\u0012\u00020\u001e0\u00a0\u0001j\t\u0012\u0004\u0012\u00020\u001e`\u00a1\u00018\u0002X\u0082\u0004\u00a2\u0006\b\n\u0006\b\u00a2\u0001\u0010\u00a3\u0001R\u001b\u0010\u00a7\u0001\u001a\u0005\u0018\u00010\u00a5\u00018\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0007\n\u0005\b=\u0010\u00a6\u0001R\u0018\u0010\u00a8\u0001\u001a\u00020\u001e8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0007\n\u0005\b6\u0010\u008a\u0001R\u0016\u0010]\u001a\u00020\u001a8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\be\u0010cR\u0019\u0010\u00ab\u0001\u001a\u00030\u00a9\u00018\u0002@\u0002X\u0082.\u00a2\u0006\u0007\n\u0005\b\"\u0010\u00aa\u0001R\u0017\u0010\u00ae\u0001\u001a\u00030\u00ac\u00018\u0002X\u0082\u0004\u00a2\u0006\u0007\n\u0005\b\r\u0010\u00ad\u0001R\u0017\u0010\u00af\u0001\u001a\u00020\u001c8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bw\u0010wR\u0018\u0010\u00b1\u0001\u001a\u00020\u001c8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0007\n\u0005\b\u00b0\u0001\u0010wR\u0017\u0010\u00b2\u0001\u001a\u00020\u001c8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\t\u0010wR\u0018\u0010\u00b3\u0001\u001a\u00020\u001c8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0007\n\u0005\b\u008a\u0001\u0010wR\u0017\u0010\u00b6\u0001\u001a\u00030\u00b4\u00018\u0002X\u0082\u0004\u00a2\u0006\u0007\n\u0005\b\u001f\u0010\u00b5\u0001R\u0017\u0010\u00b7\u0001\u001a\u00020\u001a8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bM\u0010cR\u0018\u0010\u00b8\u0001\u001a\u00020\u001a8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0007\n\u0005\b\u009b\u0001\u0010cR\u0017\u0010\u00b9\u0001\u001a\u00020\u001e8\u0002X\u0082\u0004\u00a2\u0006\b\n\u0006\b\u0084\u0001\u0010\u008a\u0001R\u0018\u0010\u00bd\u0001\u001a\u00030\u00ba\u00018\u0002X\u0082\u0004\u00a2\u0006\b\n\u0006\b\u00bb\u0001\u0010\u00bc\u0001R\u0018\u0010\u00be\u0001\u001a\u00020\u001e8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0007\n\u0005\b>\u0010\u008a\u0001R\u0016\u0010\u00c0\u0001\u001a\u00020\u001e8BX\u0082\u0004\u00a2\u0006\u0007\u001a\u0005\b\u00bf\u0001\u0010[R)\u0010\u00c4\u0001\u001a\u0014\u0012\u0004\u0012\u00020\u00120\u00c1\u0001j\t\u0012\u0004\u0012\u00020\u0012`\u00c2\u00018VX\u0096\u0004\u00a2\u0006\b\u001a\u0006\b\u00a2\u0001\u0010\u00c3\u0001R\u0017\u0010\u00c6\u0001\u001a\u00020\u001c8@X\u0080\u0004\u00a2\u0006\b\u001a\u0006\b\u00bb\u0001\u0010\u00c5\u0001\u00a8\u0006\u00ce\u0001"}, d2 = {"Lcom/tencent/mobileqq/wink/editor/clipping/timeline/widget/dragdrop/DragDropScrollView;", "Landroidx/core/widget/NestedScrollView;", "Lcom/tencent/mobileqq/wink/editor/clipping/timeline/widget/dragdrop/l;", "Lf63/b;", "", "Y", "V", "X", "Landroid/widget/HorizontalScrollView;", "H", "Landroid/view/View;", "child", "n0", "E", "", "id", "m0", "f0", "Lcom/tencent/mobileqq/wink/editor/clipping/timeline/widget/dragdrop/y;", "trackModel", "Lcom/tencent/mobileqq/wink/editor/clipping/timeline/widget/dragdrop/m;", "dragView", "Landroid/widget/RelativeLayout$LayoutParams;", "layoutParams", "i0", "view", "", "s0", "", "dp", "", "J", "Landroid/graphics/PointF;", "newPosition", "D", "positionOffset", "isEnd", "t0", "rightSpace", "a0", "xOffset", "p0", "q0", "c0", "d0", "l", "t", "oldl", "oldt", "onScrollChanged", "Landroid/view/MotionEvent;", "ev", NodeProps.ON_INTERCEPT_TOUCH_EVENT, DomainData.DOMAIN_NAME, QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, HippyTKDListViewAdapter.X, "y", "", "Lcom/tencent/mobileqq/wink/editor/clipping/timeline/widget/dragdrop/a;", "b", "e", "i", "P", "f", "", "points", "setAttractPointPosition$qq_wink_impl_release", "(Ljava/util/Set;)V", "setAttractPointPosition", "trackType", "B", "(I)Lcom/tencent/mobileqq/wink/editor/clipping/timeline/widget/dragdrop/y;", "e0", "(Lcom/tencent/mobileqq/wink/editor/clipping/timeline/widget/dragdrop/y;Lcom/tencent/mobileqq/wink/editor/clipping/timeline/widget/dragdrop/m;)V", "k0", "(Ljava/lang/String;)V", "", "K", "(Ljava/lang/Object;)Lcom/tencent/mobileqq/wink/editor/clipping/timeline/widget/dragdrop/m;", "y0", "(Lcom/tencent/mobileqq/wink/editor/clipping/timeline/widget/dragdrop/m;)V", "velocityY", "fling", "g0", "()V", "iDragView", TAVOneClickFilmStickerEffect.TRACK_INDEX, "h0", "(Lcom/tencent/mobileqq/wink/editor/clipping/timeline/widget/dragdrop/m;I)V", "k", AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, "()I", ExifInterface.LATITUDE_SOUTH, "disableBottomLine", "setDisableBottomLine$qq_wink_impl_release", "(Z)V", "setDisableBottomLine", "U", "r0", "Z", "()Z", BdhLogUtil.LogTag.Tag_Conn, "(Landroid/view/View;Landroid/graphics/PointF;)V", "canAddEmptyTrackOnDrop", "setCanAddEmptyTrackOnDrop$qq_wink_impl_release", "setCanAddEmptyTrackOnDrop", "isSelected", "r", "c", "g", "startPoint", "endPoint", "setAdsorbedPoint", "a", "o0", "(Landroid/view/View;I)Z", "u0", "(ILandroid/view/View;)V", "selectedView", UserInfo.SEX_FEMALE, "rightMargin", "j", "leftMargin", "d", "needDrawTrackBackground", "setNeedDrawTrackBackground$qq_wink_impl_release", "setNeedDrawTrackBackground", BdhLogUtil.LogTag.Tag_Req, "T", "Lf63/a;", "controller", ReportConstant.COSTREPORT_PREFIX, "M", NodeProps.MIN_WIDTH, "j0", "(I)V", "Lcom/tencent/mobileqq/wink/editor/clipping/timeline/widget/panel/event/g;", "panelEvent", "I", "(Lcom/tencent/mobileqq/wink/editor/clipping/timeline/widget/panel/event/g;)V", "available", "w0", "(Landroid/view/View;Z)V", "b0", "(Landroid/view/View;)Z", "l0", "Lcom/tencent/mobileqq/wink/editor/clipping/timeline/widget/dragdrop/i;", "dragViewModel", "x0", "(Lcom/tencent/mobileqq/wink/editor/clipping/timeline/widget/dragdrop/i;)V", "contentTopMargin", "Landroid/widget/HorizontalScrollView;", "horizontalScrollView", "Lcom/tencent/mobileqq/wink/editor/clipping/timeline/widget/dragdrop/BottomLineRelativeLayout;", "Lcom/tencent/mobileqq/wink/editor/clipping/timeline/widget/dragdrop/BottomLineRelativeLayout;", "L", "()Lcom/tencent/mobileqq/wink/editor/clipping/timeline/widget/dragdrop/BottomLineRelativeLayout;", "setContentView", "(Lcom/tencent/mobileqq/wink/editor/clipping/timeline/widget/dragdrop/BottomLineRelativeLayout;)V", "contentView", "Ljava/util/HashSet;", "Lkotlin/collections/HashSet;", tl.h.F, "Ljava/util/HashSet;", "attractPoints", "Lcom/tencent/mobileqq/wink/editor/clipping/timeline/widget/dragdrop/d;", "Lcom/tencent/mobileqq/wink/editor/clipping/timeline/widget/dragdrop/d;", "dragDropScrollViewController", "whiteLineWidth", "Lcom/tencent/mobileqq/wink/editor/clipping/timeline/widget/dragdrop/x;", "Lcom/tencent/mobileqq/wink/editor/clipping/timeline/widget/dragdrop/x;", "trackManager", "Lcom/tencent/mobileqq/wink/editor/clipping/timeline/widget/dragdrop/DragEventHandler;", "Lcom/tencent/mobileqq/wink/editor/clipping/timeline/widget/dragdrop/DragEventHandler;", "dragEventHandler", "xDistance", "G", "yDistance", "lastX", "lastY", "Lcom/tencent/mobileqq/wink/editor/clipping/timeline/widget/panel/scroll/FlingHelper;", "Lcom/tencent/mobileqq/wink/editor/clipping/timeline/widget/panel/scroll/FlingHelper;", "flingHelper", "isInMoving", "isInFling", "halfScreenWidth", "com/tencent/mobileqq/wink/editor/clipping/timeline/widget/dragdrop/DragDropScrollView$b", "N", "Lcom/tencent/mobileqq/wink/editor/clipping/timeline/widget/dragdrop/DragDropScrollView$b;", "listener", "contentViewDownWidth", "O", "screenWidth", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "()Ljava/util/ArrayList;", "trackModels", "()F", "minAttractDistance", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes21.dex */
public final class DragDropScrollView extends NestedScrollView implements l, f63.b {

    /* renamed from: C, reason: from kotlin metadata */
    private boolean disableBottomLine;

    /* renamed from: D, reason: from kotlin metadata */
    private x trackManager;

    /* renamed from: E, reason: from kotlin metadata */
    @NotNull
    private final DragEventHandler dragEventHandler;

    /* renamed from: F, reason: from kotlin metadata */
    private float xDistance;

    /* renamed from: G, reason: from kotlin metadata */
    private float yDistance;

    /* renamed from: H, reason: from kotlin metadata */
    private float lastX;

    /* renamed from: I, reason: from kotlin metadata */
    private float lastY;

    /* renamed from: J, reason: from kotlin metadata */
    @NotNull
    private final FlingHelper flingHelper;

    /* renamed from: K, reason: from kotlin metadata */
    private boolean isInMoving;

    /* renamed from: L, reason: from kotlin metadata */
    private boolean isInFling;

    /* renamed from: M, reason: from kotlin metadata */
    private final int halfScreenWidth;

    /* renamed from: N, reason: from kotlin metadata */
    @NotNull
    private final b listener;

    /* renamed from: P, reason: from kotlin metadata */
    private int contentViewDownWidth;

    @NotNull
    public Map<Integer, View> Q;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private int contentTopMargin;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private HorizontalScrollView horizontalScrollView;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private BottomLineRelativeLayout contentView;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final HashSet<Integer> attractPoints;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private d dragDropScrollViewController;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private int whiteLineWidth;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public DragDropScrollView(@NotNull Context context) {
        this(context, null, 0, 6, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    private final void D(PointF newPosition, View dragView) {
        m a16;
        int f16;
        int coerceAtMost;
        BottomLineRelativeLayout bottomLineRelativeLayout = this.contentView;
        if (bottomLineRelativeLayout == null || (a16 = n.a(dragView)) == null) {
            return;
        }
        if (a16.o()) {
            f16 = c();
        } else {
            f16 = f();
        }
        coerceAtMost = RangesKt___RangesKt.coerceAtMost(a16.m(), f16);
        if (coerceAtMost > 0) {
            if (newPosition.x + dragView.getWidth() > bottomLineRelativeLayout.getPaddingLeft() + coerceAtMost + a16.l() + a16.p()) {
                newPosition.x = r0 - dragView.getWidth();
            }
        }
    }

    private final void E() {
        BottomLineRelativeLayout bottomLineRelativeLayout = this.contentView;
        if (bottomLineRelativeLayout != null) {
            int childCount = bottomLineRelativeLayout.getChildCount();
            for (int i3 = 0; i3 < childCount; i3++) {
                View childAt = bottomLineRelativeLayout.getChildAt(i3);
                if (childAt != null) {
                    Intrinsics.checkNotNullExpressionValue(childAt, "getChildAt(i)");
                    if (!childAt.isSelected()) {
                        childAt = null;
                    }
                    if (childAt != null) {
                        childAt.bringToFront();
                    }
                }
            }
        }
    }

    public static /* synthetic */ void G(DragDropScrollView dragDropScrollView, m mVar, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            mVar = null;
        }
        dragDropScrollView.F(mVar);
    }

    private final HorizontalScrollView H() {
        final Context context = getContext();
        return new HorizontalScrollView(context) { // from class: com.tencent.mobileqq.wink.editor.clipping.timeline.widget.dragdrop.DragDropScrollView$createHorizontalScrollView$1

            /* renamed from: d, reason: collision with root package name and from kotlin metadata */
            @NotNull
            private final a listener;

            /* renamed from: e, reason: collision with root package name */
            @NotNull
            public Map<Integer, View> f319336e = new LinkedHashMap();

            /* compiled from: P */
            @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0018\u0010\b\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0006H\u0016\u00a8\u0006\t"}, d2 = {"com/tencent/mobileqq/wink/editor/clipping/timeline/widget/dragdrop/DragDropScrollView$createHorizontalScrollView$1$a", "Lcom/tencent/mobileqq/wink/editor/clipping/timeline/widget/panel/scroll/FlingHelper$a;", "", "xPos", "", "b", "", "cancel", "a", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
            /* loaded from: classes21.dex */
            public static final class a implements FlingHelper.a {

                /* renamed from: b, reason: collision with root package name */
                final /* synthetic */ DragDropScrollView f319339b;

                a(DragDropScrollView dragDropScrollView) {
                    this.f319339b = dragDropScrollView;
                }

                @Override // com.tencent.mobileqq.wink.editor.clipping.timeline.widget.panel.scroll.FlingHelper.a
                public void a(int xPos, boolean cancel) {
                    d dVar;
                    PanelEventHandler k3;
                    this.f319339b.isInFling = false;
                    this.f319339b.isInMoving = false;
                    dVar = this.f319339b.dragDropScrollViewController;
                    if (dVar != null && (k3 = dVar.k()) != null) {
                        k3.a(new com.tencent.mobileqq.wink.editor.clipping.timeline.widget.panel.event.d(cancel));
                    }
                }

                @Override // com.tencent.mobileqq.wink.editor.clipping.timeline.widget.panel.scroll.FlingHelper.a
                public void b(int xPos) {
                    DragDropScrollView$createHorizontalScrollView$1 dragDropScrollView$createHorizontalScrollView$1 = DragDropScrollView$createHorizontalScrollView$1.this;
                    dragDropScrollView$createHorizontalScrollView$1.scrollTo(xPos, dragDropScrollView$createHorizontalScrollView$1.getScrollY());
                }
            }

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.listener = new a(DragDropScrollView.this);
            }

            @Override // android.widget.HorizontalScrollView
            public void fling(int velocityX) {
                d dVar;
                FlingHelper i3;
                dVar = DragDropScrollView.this.dragDropScrollViewController;
                if (dVar != null && (i3 = dVar.i()) != null) {
                    int scrollX = getScrollX();
                    BottomLineRelativeLayout contentView = DragDropScrollView.this.getContentView();
                    Intrinsics.checkNotNull(contentView);
                    i3.f(velocityX, scrollX, contentView.getMeasuredWidth(), this.listener);
                }
                DragDropScrollView.this.isInFling = true;
            }

            @Override // android.view.View
            protected void onScrollChanged(int l3, int t16, int oldl, int oldt) {
                d dVar;
                DragEventHandler dragEventHandler;
                super.onScrollChanged(l3, t16, oldl, oldt);
                BottomLineRelativeLayout contentView = DragDropScrollView.this.getContentView();
                if (contentView != null) {
                    int childCount = contentView.getChildCount();
                    for (int i3 = 0; i3 < childCount; i3++) {
                        KeyEvent.Callback childAt = contentView.getChildAt(i3);
                        if (childAt != null) {
                            Intrinsics.checkNotNullExpressionValue(childAt, "getChildAt(i)");
                            if (childAt instanceof k) {
                                ((k) childAt).c(this, l3, t16, oldl, oldt);
                            }
                        }
                    }
                }
                dVar = DragDropScrollView.this.dragDropScrollViewController;
                if (dVar != null) {
                    dVar.v(l3);
                }
                dragEventHandler = DragDropScrollView.this.dragEventHandler;
                dragEventHandler.F(l3, t16, oldl, oldt);
            }

            /* JADX WARN: Code restructure failed: missing block: B:25:0x0063, code lost:
            
                if (r5 == false) goto L27;
             */
            @Override // android.widget.HorizontalScrollView, android.view.View
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public boolean onTouchEvent(@NotNull MotionEvent ev5) {
                d dVar;
                PanelEventHandler k3;
                boolean z16;
                boolean z17;
                boolean z18;
                d dVar2;
                FlingHelper i3;
                d dVar3;
                PanelEventHandler k16;
                Intrinsics.checkNotNullParameter(ev5, "ev");
                boolean onTouchEvent = super.onTouchEvent(ev5);
                if (onTouchEvent && ev5.getAction() == 2) {
                    z18 = DragDropScrollView.this.isInMoving;
                    if (!z18) {
                        dVar3 = DragDropScrollView.this.dragDropScrollViewController;
                        if (dVar3 != null && (k16 = dVar3.k()) != null) {
                            k16.a(new com.tencent.mobileqq.wink.editor.clipping.timeline.widget.panel.event.e());
                        }
                        DragDropScrollView.this.isInMoving = true;
                    }
                    dVar2 = DragDropScrollView.this.dragDropScrollViewController;
                    if (dVar2 != null && (i3 = dVar2.i()) != null) {
                        i3.g();
                    }
                }
                if (ev5.getAction() != 1) {
                    if (ev5.getAction() == 3) {
                        z16 = DragDropScrollView.this.isInMoving;
                        if (z16) {
                            z17 = DragDropScrollView.this.isInFling;
                        }
                    }
                    return onTouchEvent;
                }
                DragDropScrollView.this.isInMoving = false;
                dVar = DragDropScrollView.this.dragDropScrollViewController;
                if (dVar != null && (k3 = dVar.k()) != null) {
                    k3.a(new com.tencent.mobileqq.wink.editor.clipping.timeline.widget.panel.event.d(false));
                }
                return onTouchEvent;
            }
        };
    }

    private final int J(float dp5) {
        return com.tencent.videocut.utils.e.f384236a.a(dp5);
    }

    private final int O() {
        return getContext().getResources().getDisplayMetrics().widthPixels;
    }

    private final void V() {
        BottomLineRelativeLayout bottomLineRelativeLayout = new BottomLineRelativeLayout(getContext());
        bottomLineRelativeLayout.setTrackList(h());
        bottomLineRelativeLayout.setBackgroundColor(bottomLineRelativeLayout.getResources().getColor(R.color.cto));
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(i(), -1);
        layoutParams.topMargin = this.contentTopMargin;
        int i3 = this.halfScreenWidth;
        bottomLineRelativeLayout.setPadding(i3, 0, i3, 0);
        x xVar = this.trackManager;
        if (xVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("trackManager");
            xVar = null;
        }
        bottomLineRelativeLayout.setMinimumHeight((xVar.c() * 1) + (S() * 0));
        HorizontalScrollView horizontalScrollView = this.horizontalScrollView;
        if (horizontalScrollView != null) {
            horizontalScrollView.addView(bottomLineRelativeLayout, layoutParams);
        }
        bottomLineRelativeLayout.setOnDragListener(this.dragEventHandler);
        bottomLineRelativeLayout.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.wink.editor.clipping.timeline.widget.dragdrop.c
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                DragDropScrollView.W(DragDropScrollView.this, view);
            }
        });
        this.contentView = bottomLineRelativeLayout;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void W(DragDropScrollView this$0, View view) {
        PanelEventHandler k3;
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        d dVar = this$0.dragDropScrollViewController;
        if (dVar != null && (k3 = dVar.k()) != null) {
            k3.a(new com.tencent.mobileqq.wink.editor.clipping.timeline.widget.panel.event.b());
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    private final void X() {
        setFillViewport(true);
        HorizontalScrollView H = H();
        H.setOverScrollMode(2);
        H.setVerticalScrollBarEnabled(false);
        H.setHorizontalScrollBarEnabled(false);
        addView(H, new FrameLayout.LayoutParams(-1, -1));
        this.horizontalScrollView = H;
    }

    private final void Y() {
        X();
        this.whiteLineWidth = J(2.0f);
    }

    private final boolean a0(View view, int rightSpace) {
        BottomLineRelativeLayout bottomLineRelativeLayout = this.contentView;
        Intrinsics.checkNotNull(bottomLineRelativeLayout);
        if (bottomLineRelativeLayout.getRight() - view.getRight() == this.halfScreenWidth - rightSpace) {
            return true;
        }
        return false;
    }

    private final boolean c0(View view) {
        if (((int) view.getY()) + view.getMeasuredHeight() == (getScrollY() + getMeasuredHeight()) - this.contentTopMargin) {
            return true;
        }
        return false;
    }

    private final boolean d0(View view) {
        boolean z16;
        if (view.getY() == 0.0f) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16 && getScrollY() == 0) {
            return true;
        }
        return false;
    }

    private final void f0() {
        Object obj;
        boolean z16;
        BottomLineRelativeLayout bottomLineRelativeLayout = this.contentView;
        if (bottomLineRelativeLayout != null) {
            int childCount = bottomLineRelativeLayout.getChildCount();
            for (int i3 = 0; i3 < childCount; i3++) {
                View view = bottomLineRelativeLayout.getChildAt(i3);
                ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
                Intrinsics.checkNotNull(layoutParams, "null cannot be cast to non-null type android.widget.RelativeLayout.LayoutParams");
                RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) layoutParams;
                Intrinsics.checkNotNullExpressionValue(view, "view");
                m a16 = n.a(view);
                if (a16 == null) {
                    return;
                }
                Iterator<T> it = h().iterator();
                while (true) {
                    if (it.hasNext()) {
                        obj = it.next();
                        y yVar = (y) obj;
                        if (yVar.getIndex() == a16.getDragViewModel().getTrackIndex() && yVar.c(a16.getDragViewModel().getId())) {
                            z16 = true;
                        } else {
                            z16 = false;
                        }
                        if (z16) {
                            break;
                        }
                    } else {
                        obj = null;
                        break;
                    }
                }
                y yVar2 = (y) obj;
                if (yVar2 != null) {
                    i0(yVar2, a16, layoutParams2);
                    view.invalidate();
                    view.requestLayout();
                }
            }
        }
    }

    private final void i0(y trackModel, m dragView, RelativeLayout.LayoutParams layoutParams) {
        layoutParams.leftMargin = dragView.n();
        layoutParams.topMargin = trackModel.getTop() - dragView.s();
        layoutParams.width = dragView.l() + dragView.p() + dragView.getLength();
        x xVar = this.trackManager;
        if (xVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("trackManager");
            xVar = null;
        }
        layoutParams.height = xVar.c();
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void m0(String id5) {
        BottomLineRelativeLayout bottomLineRelativeLayout = this.contentView;
        if (bottomLineRelativeLayout != null) {
            int childCount = bottomLineRelativeLayout.getChildCount();
            for (int i3 = 0; i3 < childCount; i3++) {
                View childAt = bottomLineRelativeLayout.getChildAt(i3);
                if (childAt != 0) {
                    Intrinsics.checkNotNullExpressionValue(childAt, "getChildAt(i)");
                    if ((childAt instanceof m) && Intrinsics.areEqual(((m) childAt).getDragViewModel().getId(), id5)) {
                        bottomLineRelativeLayout.removeView(childAt);
                        return;
                    }
                }
            }
        }
    }

    private final void n0(View child) {
        ViewParent viewParent;
        ViewGroup viewGroup = null;
        if (child != null) {
            viewParent = child.getParent();
        } else {
            viewParent = null;
        }
        if (viewParent instanceof ViewGroup) {
            viewGroup = (ViewGroup) viewParent;
        }
        if (viewGroup != null) {
            viewGroup.removeView(child);
        }
    }

    private final boolean p0(View view, int xOffset) {
        boolean z16;
        HorizontalScrollView horizontalScrollView = this.horizontalScrollView;
        if (horizontalScrollView == null) {
            return false;
        }
        float x16 = ((view.getX() + view.getWidth()) - horizontalScrollView.getMeasuredWidth()) - horizontalScrollView.getScrollX();
        if (x16 >= 0.0f && xOffset > 0) {
            horizontalScrollView.smoothScrollBy(this.dragEventHandler.z(view.getWidth(), x16), 0);
            z16 = true;
        } else {
            z16 = false;
        }
        float x17 = view.getX() - horizontalScrollView.getScrollX();
        if (x17 <= 0.0f && xOffset < 0) {
            horizontalScrollView.smoothScrollBy(this.dragEventHandler.z(view.getWidth(), x17), 0);
            return true;
        }
        return z16;
    }

    private final boolean q0(View view) {
        boolean z16;
        com.tencent.videocut.utils.e eVar = com.tencent.videocut.utils.e.f384236a;
        int a16 = eVar.a(15.0f);
        int a17 = eVar.a(5.0f);
        boolean z17 = true;
        if (view.getY() <= getScrollY() + a16) {
            if (d0(view)) {
                return false;
            }
            smoothScrollBy(0, -a17);
            z16 = true;
        } else {
            z16 = false;
        }
        if (view.getY() + view.getMeasuredHeight() >= ((getScrollY() + getMeasuredHeight()) - this.contentTopMargin) - a16) {
            if (c0(view)) {
                return z16;
            }
            smoothScrollBy(0, a17);
        } else {
            z17 = z16;
        }
        view.setTag(R.id.ull, Boolean.valueOf(z17));
        return z17;
    }

    private final boolean s0(View view) {
        boolean startDragAndDrop;
        view.performHapticFeedback(0, 2);
        view.setAlpha(0.7f);
        G(this, null, 1, null);
        h hVar = new h(view);
        ClipData newPlainText = ClipData.newPlainText("Label", "");
        try {
            if (Build.VERSION.SDK_INT >= 24) {
                startDragAndDrop = view.startDragAndDrop(newPlainText, hVar, view, 0);
                return startDragAndDrop;
            }
            return startDrag(newPlainText, hVar, view, 0);
        } catch (Throwable th5) {
            String message = th5.getMessage();
            if (message != null) {
                w53.b.c("DragDrop-ScrollView", message);
            }
            return false;
        }
    }

    private final void t0(int positionOffset, boolean isEnd, View dragView) {
        int i3;
        TimelinePanelViewController panelViewController;
        BottomLineRelativeLayout bottomLineRelativeLayout = this.contentView;
        Intrinsics.checkNotNull(bottomLineRelativeLayout);
        ViewGroup.LayoutParams layoutParams = bottomLineRelativeLayout.getLayoutParams();
        if (isEnd) {
            if (positionOffset < 0) {
                layoutParams.width = this.contentViewDownWidth + positionOffset;
            }
        } else if (positionOffset > 0) {
            m a16 = n.a(dragView);
            if (a16 != null) {
                i3 = a16.p();
            } else {
                i3 = 0;
            }
            if (a0(dragView, i3)) {
                layoutParams.width += positionOffset;
            }
        }
        d dVar = this.dragDropScrollViewController;
        if (dVar != null && (panelViewController = dVar.getPanelViewController()) != null) {
            panelViewController.s();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean v0(DragDropScrollView this$0, View dragView, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(dragView, "$dragView");
        return this$0.s0(dragView);
    }

    @NotNull
    public final y B(int trackType) {
        x xVar = this.trackManager;
        if (xVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("trackManager");
            xVar = null;
        }
        return xVar.a(trackType);
    }

    public final void C(@NotNull View dragView, @NotNull PointF newPosition) {
        Intrinsics.checkNotNullParameter(dragView, "dragView");
        Intrinsics.checkNotNullParameter(newPosition, "newPosition");
        if (this.contentView != null) {
            if (newPosition.x < r0.getPaddingLeft()) {
                newPosition.x = r0.getPaddingLeft();
            }
            D(newPosition, dragView);
            if (newPosition.y < r0.getPaddingTop()) {
                newPosition.y = r0.getPaddingTop();
            }
        }
    }

    public final void F(@Nullable m selectedView) {
        BottomLineRelativeLayout bottomLineRelativeLayout = this.contentView;
        if (bottomLineRelativeLayout != null) {
            int childCount = bottomLineRelativeLayout.getChildCount();
            for (int i3 = 0; i3 < childCount; i3++) {
                View childAt = bottomLineRelativeLayout.getChildAt(i3);
                if (Intrinsics.areEqual(childAt, selectedView)) {
                    childAt = null;
                }
                if (childAt != null) {
                    childAt.setSelected(false);
                }
            }
        }
    }

    public final void I(@NotNull com.tencent.mobileqq.wink.editor.clipping.timeline.widget.panel.event.g panelEvent) {
        PanelEventHandler k3;
        Intrinsics.checkNotNullParameter(panelEvent, "panelEvent");
        d dVar = this.dragDropScrollViewController;
        if (dVar != null && (k3 = dVar.k()) != null) {
            k3.a(panelEvent);
        }
    }

    @Nullable
    public final m K(@Nullable Object id5) {
        BottomLineRelativeLayout bottomLineRelativeLayout = this.contentView;
        if (bottomLineRelativeLayout != null) {
            int childCount = bottomLineRelativeLayout.getChildCount();
            for (int i3 = 0; i3 < childCount; i3++) {
                KeyEvent.Callback childAt = bottomLineRelativeLayout.getChildAt(i3);
                if (childAt instanceof m) {
                    m mVar = (m) childAt;
                    if (Intrinsics.areEqual(mVar.getDragViewModel().getId(), id5)) {
                        return mVar;
                    }
                }
            }
            return null;
        }
        return null;
    }

    @Nullable
    /* renamed from: L, reason: from getter */
    public final BottomLineRelativeLayout getContentView() {
        return this.contentView;
    }

    public final int M() {
        BottomLineRelativeLayout bottomLineRelativeLayout = this.contentView;
        int i3 = 0;
        if (bottomLineRelativeLayout != null) {
            int childCount = bottomLineRelativeLayout.getChildCount();
            int i16 = 0;
            while (i3 < childCount) {
                View childAt = bottomLineRelativeLayout.getChildAt(i3);
                Intrinsics.checkNotNullExpressionValue(childAt, "it.getChildAt(i)");
                m a16 = n.a(childAt);
                if (a16 != null && a16.h() > i16) {
                    i16 = a16.h();
                }
                i3++;
            }
            i3 = i16;
        }
        return i3 + getHalfScreenWidth() + T();
    }

    public final float N() {
        return J(5.0f);
    }

    public int P() {
        BottomLineRelativeLayout bottomLineRelativeLayout = this.contentView;
        if (bottomLineRelativeLayout != null) {
            return bottomLineRelativeLayout.getPaddingStart();
        }
        return 0;
    }

    public final int Q() {
        x xVar = this.trackManager;
        if (xVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("trackManager");
            xVar = null;
        }
        return xVar.c();
    }

    /* renamed from: R, reason: from getter */
    public final int getHalfScreenWidth() {
        return this.halfScreenWidth;
    }

    public final int S() {
        x xVar = this.trackManager;
        if (xVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("trackManager");
            xVar = null;
        }
        return xVar.d();
    }

    public final int T() {
        return this.halfScreenWidth;
    }

    public final void U() {
        BottomLineRelativeLayout bottomLineRelativeLayout;
        if (!this.disableBottomLine && (bottomLineRelativeLayout = this.contentView) != null) {
            bottomLineRelativeLayout.setDrawBottomLine(false);
        }
    }

    public final boolean Z() {
        BottomLineRelativeLayout bottomLineRelativeLayout = this.contentView;
        if (bottomLineRelativeLayout != null) {
            return bottomLineRelativeLayout.getDrawBottomLine();
        }
        return false;
    }

    @Override // com.tencent.mobileqq.wink.editor.clipping.timeline.widget.dragdrop.l
    public void a() {
        int i3;
        BottomLineRelativeLayout bottomLineRelativeLayout = this.contentView;
        if (bottomLineRelativeLayout != null) {
            i3 = bottomLineRelativeLayout.getWidth();
        } else {
            i3 = 0;
        }
        this.contentViewDownWidth = i3;
    }

    @Override // com.tencent.mobileqq.wink.editor.clipping.timeline.widget.dragdrop.l
    @NotNull
    public List<AttractPoint> b(@NotNull String id5) {
        Intrinsics.checkNotNullParameter(id5, "id");
        ArrayList arrayList = new ArrayList();
        BottomLineRelativeLayout bottomLineRelativeLayout = this.contentView;
        if (bottomLineRelativeLayout != null) {
            int childCount = bottomLineRelativeLayout.getChildCount();
            for (int i3 = 0; i3 < childCount; i3++) {
                View childAt = bottomLineRelativeLayout.getChildAt(i3);
                Intrinsics.checkNotNullExpressionValue(childAt, "it.getChildAt(i)");
                m a16 = n.a(childAt);
                if (a16 == null) {
                    break;
                }
                if (!Intrinsics.areEqual(a16.getDragViewModel().getId(), id5)) {
                    arrayList.add(a16.getDragViewModel().g(0L, true));
                    arrayList.add(a16.getDragViewModel().g(0L, false));
                }
            }
        }
        Iterator<T> it = this.attractPoints.iterator();
        while (it.hasNext()) {
            arrayList.add(new AttractPoint(-1L, ((Number) it.next()).intValue(), null, false));
        }
        return arrayList;
    }

    public final boolean b0(@NotNull View view) {
        Intrinsics.checkNotNullParameter(view, "view");
        if (this.contentView == null || view.getY() + view.getHeight() < r0.getBottom() - this.contentTopMargin) {
            return false;
        }
        return true;
    }

    @Override // com.tencent.mobileqq.wink.editor.clipping.timeline.widget.dragdrop.l
    public int c() {
        return 1073741824;
    }

    @Override // com.tencent.mobileqq.wink.editor.clipping.timeline.widget.dragdrop.l
    public int d(int leftMargin) {
        HorizontalScrollView horizontalScrollView = this.horizontalScrollView;
        Intrinsics.checkNotNull(horizontalScrollView);
        return (horizontalScrollView.getScrollX() - this.halfScreenWidth) + J(leftMargin);
    }

    @Override // com.tencent.mobileqq.wink.editor.clipping.timeline.widget.dragdrop.l
    public float e() {
        return N();
    }

    public final void e0(@NotNull y trackModel, @NotNull m dragView) {
        TimelinePanelViewController panelViewController;
        Intrinsics.checkNotNullParameter(trackModel, "trackModel");
        Intrinsics.checkNotNullParameter(dragView, "dragView");
        View b16 = n.b(dragView);
        if (b16 == null) {
            return;
        }
        n0(b16);
        dragView.setDragViewModel(DragViewModel.b(dragView.getDragViewModel(), null, 0, 0, 0L, trackModel.getIndex(), null, null, 111, null));
        trackModel.k(dragView.getDragViewModel());
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        i0(trackModel, dragView, layoutParams);
        d dVar = this.dragDropScrollViewController;
        if (dVar != null && (panelViewController = dVar.getPanelViewController()) != null) {
            panelViewController.s();
        }
        BottomLineRelativeLayout bottomLineRelativeLayout = this.contentView;
        if (bottomLineRelativeLayout != null) {
            bottomLineRelativeLayout.addView(b16, layoutParams);
        }
        E();
        w0(b16, true);
        dragView.setValueChangeListener(new t(this));
    }

    @Override // com.tencent.mobileqq.wink.editor.clipping.timeline.widget.dragdrop.l
    public int f() {
        i63.b m3;
        d dVar = this.dragDropScrollViewController;
        if (dVar != null && (m3 = dVar.m()) != null) {
            return m3.d();
        }
        return 0;
    }

    @Override // androidx.core.widget.NestedScrollView
    public void fling(int velocityY) {
        int i3;
        FlingHelper flingHelper = this.flingHelper;
        int scrollY = getScrollY();
        BottomLineRelativeLayout bottomLineRelativeLayout = this.contentView;
        if (bottomLineRelativeLayout != null) {
            i3 = bottomLineRelativeLayout.getMeasuredHeight();
        } else {
            i3 = 0;
        }
        flingHelper.f(velocityY, scrollY, i3, this.listener);
    }

    @Override // com.tencent.mobileqq.wink.editor.clipping.timeline.widget.dragdrop.l
    public void g(int positionOffset, @NotNull View view) {
        int i3;
        Intrinsics.checkNotNullParameter(view, "view");
        t0(positionOffset, true, view);
        m a16 = n.a(view);
        if (a16 != null) {
            i3 = a16.p();
        } else {
            i3 = 0;
        }
        if (a0(view, i3)) {
            HorizontalScrollView horizontalScrollView = this.horizontalScrollView;
            Intrinsics.checkNotNull(horizontalScrollView);
            l((horizontalScrollView.getScrollX() + this.halfScreenWidth) - i3, 0);
        }
    }

    public final void g0() {
        int size = h().size();
        for (int i3 = 0; i3 < size; i3++) {
            y yVar = h().get(i3);
            Intrinsics.checkNotNullExpressionValue(yVar, "trackModels[i]");
            y yVar2 = yVar;
            int index = yVar2.getIndex();
            x xVar = this.trackManager;
            x xVar2 = null;
            if (xVar == null) {
                Intrinsics.throwUninitializedPropertyAccessException("trackManager");
                xVar = null;
            }
            yVar2.q(index * (xVar.c() + S()));
            int top = yVar2.getTop();
            x xVar3 = this.trackManager;
            if (xVar3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("trackManager");
            } else {
                xVar2 = xVar3;
            }
            yVar2.m(top + xVar2.c());
            yVar2.o(getHalfScreenWidth());
            yVar2.p(T());
        }
        f0();
        j0(i());
    }

    @Override // com.tencent.mobileqq.wink.editor.clipping.timeline.widget.dragdrop.l
    @NotNull
    public ArrayList<y> h() {
        x xVar = this.trackManager;
        if (xVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("trackManager");
            xVar = null;
        }
        return xVar.e();
    }

    public final void h0(@NotNull m iDragView, int trackIndex) {
        Intrinsics.checkNotNullParameter(iDragView, "iDragView");
        View b16 = n.b(iDragView);
        if (b16 == null) {
            return;
        }
        ViewGroup.LayoutParams layoutParams = b16.getLayoutParams();
        Intrinsics.checkNotNull(layoutParams, "null cannot be cast to non-null type android.widget.RelativeLayout.LayoutParams");
        RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) layoutParams;
        int i3 = layoutParams2.width;
        layoutParams2.leftMargin = iDragView.n();
        int h16 = (iDragView.h() - iDragView.n()) + iDragView.l() + iDragView.p();
        layoutParams2.width = h16;
        b16.setLayoutParams(layoutParams2);
        t0(h16 - i3, false, b16);
        x xVar = this.trackManager;
        x xVar2 = null;
        if (xVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("trackManager");
            xVar = null;
        }
        xVar.g(iDragView.getDragViewModel());
        if (iDragView.getDragViewModel().getTrackIndex() == trackIndex) {
            x xVar3 = this.trackManager;
            if (xVar3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("trackManager");
            } else {
                xVar2 = xVar3;
            }
            if (xVar2.b(iDragView.getDragViewModel())) {
                return;
            }
        }
        if (trackIndex < 0) {
            return;
        }
        k0(iDragView.getDragViewModel().getId());
        while (trackIndex >= h().size()) {
            B(iDragView.getTrackType());
        }
        y yVar = h().get(trackIndex);
        Intrinsics.checkNotNullExpressionValue(yVar, "trackModels[trackIndex]");
        e0(yVar, iDragView);
    }

    @Override // com.tencent.mobileqq.wink.editor.clipping.timeline.widget.dragdrop.l
    public int i() {
        Integer num;
        i63.b m3;
        d dVar = this.dragDropScrollViewController;
        if (dVar != null) {
            if (dVar != null && (m3 = dVar.m()) != null) {
                num = Integer.valueOf(m3.d());
            } else {
                num = null;
            }
            Intrinsics.checkNotNull(num);
            return num.intValue() + O();
        }
        throw new Exception("scaleCalculator is null, need set scaleCalculator first");
    }

    @Override // com.tencent.mobileqq.wink.editor.clipping.timeline.widget.dragdrop.l
    public int j(int rightMargin) {
        HorizontalScrollView horizontalScrollView = this.horizontalScrollView;
        Intrinsics.checkNotNull(horizontalScrollView);
        return (horizontalScrollView.getScrollX() + this.halfScreenWidth) - J(rightMargin);
    }

    public final void j0(int minWidth) {
        w53.b.a("DragDrop-ScrollView", "refreshWidth called minWidth is : " + minWidth);
        BottomLineRelativeLayout bottomLineRelativeLayout = this.contentView;
        if (bottomLineRelativeLayout != null) {
            ViewGroup.LayoutParams layoutParams = bottomLineRelativeLayout.getLayoutParams();
            layoutParams.width = minWidth;
            bottomLineRelativeLayout.setLayoutParams(layoutParams);
        }
    }

    @Override // com.tencent.mobileqq.wink.editor.clipping.timeline.widget.dragdrop.l
    public void k(@NotNull m dragView) {
        Intrinsics.checkNotNullParameter(dragView, "dragView");
        h0(dragView, -1);
    }

    public final void k0(@Nullable String id5) {
        TimelinePanelViewController panelViewController;
        Iterator<y> it = h().iterator();
        boolean z16 = false;
        while (it.hasNext()) {
            y next = it.next();
            Iterator<DragViewModel> it5 = next.d().iterator();
            while (true) {
                if (!it5.hasNext()) {
                    break;
                }
                if (Intrinsics.areEqual(id5, it5.next().getId())) {
                    next.l(id5);
                    z16 = true;
                    break;
                }
            }
            if (z16) {
                break;
            }
        }
        m0(id5);
        d dVar = this.dragDropScrollViewController;
        if (dVar != null && (panelViewController = dVar.getPanelViewController()) != null) {
            panelViewController.s();
        }
    }

    @Override // com.tencent.mobileqq.wink.editor.clipping.timeline.widget.dragdrop.l
    public void l(int x16, int y16) {
        HorizontalScrollView horizontalScrollView = this.horizontalScrollView;
        if (horizontalScrollView != null) {
            horizontalScrollView.scrollTo(x16, y16);
        }
    }

    public final void l0() {
        x xVar = this.trackManager;
        if (xVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("trackManager");
            xVar = null;
        }
        xVar.f();
    }

    @Override // com.tencent.mobileqq.wink.editor.clipping.timeline.widget.dragdrop.l
    public int m() {
        return this.halfScreenWidth;
    }

    @Override // com.tencent.mobileqq.wink.editor.clipping.timeline.widget.dragdrop.l
    public int n() {
        HorizontalScrollView horizontalScrollView = this.horizontalScrollView;
        if (horizontalScrollView != null) {
            return horizontalScrollView.getScrollX();
        }
        return 0;
    }

    public final boolean o0(@NotNull View view, int xOffset) {
        Intrinsics.checkNotNullParameter(view, "view");
        return q0(view) | p0(view, xOffset);
    }

    @Override // androidx.core.widget.NestedScrollView, android.view.ViewGroup
    public boolean onInterceptTouchEvent(@NotNull MotionEvent ev5) {
        Intrinsics.checkNotNullParameter(ev5, "ev");
        int action = ev5.getAction();
        if (action != 0) {
            if (action == 2) {
                this.xDistance += Math.abs(ev5.getX() - this.lastX);
                this.yDistance += Math.abs(ev5.getY() - this.lastY);
                this.lastX = ev5.getX();
                this.lastY = ev5.getY();
                if (this.xDistance > this.yDistance) {
                    return false;
                }
            }
        } else {
            this.yDistance = 0.0f;
            this.xDistance = 0.0f;
            this.lastX = ev5.getX();
            this.lastY = ev5.getY();
            computeScroll();
        }
        return super.onInterceptTouchEvent(ev5);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.core.widget.NestedScrollView, android.view.View
    public void onScrollChanged(int l3, int t16, int oldl, int oldt) {
        super.onScrollChanged(l3, t16, oldl, oldt);
        this.dragEventHandler.F(l3, t16, oldl, oldt);
    }

    @Override // com.tencent.mobileqq.wink.editor.clipping.timeline.widget.dragdrop.l
    public void r(@Nullable m dragView, boolean isSelected) {
        if (isSelected) {
            F(dragView);
        }
    }

    public final void r0() {
        if (!this.disableBottomLine) {
            BottomLineRelativeLayout bottomLineRelativeLayout = this.contentView;
            if (bottomLineRelativeLayout != null) {
                bottomLineRelativeLayout.setDrawBottomLine(true);
            }
            performHapticFeedback(0, 2);
        }
    }

    @Override // f63.b
    public void s(@NotNull f63.a<?> controller) {
        d dVar;
        Intrinsics.checkNotNullParameter(controller, "controller");
        d dVar2 = null;
        if (controller instanceof d) {
            dVar = (d) controller;
        } else {
            dVar = null;
        }
        if (dVar != null) {
            this.trackManager = dVar.getTrackManager();
            dVar2 = dVar;
        }
        this.dragDropScrollViewController = dVar2;
        V();
    }

    @Override // com.tencent.mobileqq.wink.editor.clipping.timeline.widget.dragdrop.l
    public void setAdsorbedPoint(@Nullable AttractPoint startPoint, @Nullable AttractPoint endPoint) {
        d dVar = this.dragDropScrollViewController;
        if (dVar != null) {
            dVar.w(startPoint, endPoint);
        }
    }

    public final void setAttractPointPosition$qq_wink_impl_release(@Nullable Set<Integer> points) {
        if (points != null && !points.isEmpty()) {
            this.attractPoints.clear();
            this.attractPoints.addAll(points);
        }
    }

    public final void setCanAddEmptyTrackOnDrop$qq_wink_impl_release(boolean canAddEmptyTrackOnDrop) {
        this.dragEventHandler.I(canAddEmptyTrackOnDrop);
    }

    public final void setContentView(@Nullable BottomLineRelativeLayout bottomLineRelativeLayout) {
        this.contentView = bottomLineRelativeLayout;
    }

    public final void setDisableBottomLine$qq_wink_impl_release(boolean disableBottomLine) {
        this.disableBottomLine = disableBottomLine;
    }

    public final void setNeedDrawTrackBackground$qq_wink_impl_release(boolean needDrawTrackBackground) {
        BottomLineRelativeLayout bottomLineRelativeLayout = this.contentView;
        if (bottomLineRelativeLayout != null) {
            bottomLineRelativeLayout.setNeedDrawTrackBackground(needDrawTrackBackground);
        }
    }

    public final void u0(int positionOffset, @NotNull View dragView) {
        d dVar;
        TimelinePanelViewController panelViewController;
        Intrinsics.checkNotNullParameter(dragView, "dragView");
        BottomLineRelativeLayout bottomLineRelativeLayout = this.contentView;
        if (bottomLineRelativeLayout != null && positionOffset + dragView.getWidth() > bottomLineRelativeLayout.getWidth() - bottomLineRelativeLayout.getPaddingRight() && (dVar = this.dragDropScrollViewController) != null && (panelViewController = dVar.getPanelViewController()) != null) {
            panelViewController.s();
        }
    }

    public final void w0(@NotNull final View dragView, boolean available) {
        Intrinsics.checkNotNullParameter(dragView, "dragView");
        if (available) {
            dragView.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.tencent.mobileqq.wink.editor.clipping.timeline.widget.dragdrop.b
                @Override // android.view.View.OnLongClickListener
                public final boolean onLongClick(View view) {
                    boolean v06;
                    v06 = DragDropScrollView.v0(DragDropScrollView.this, dragView, view);
                    return v06;
                }
            });
        } else {
            dragView.setOnLongClickListener(null);
        }
    }

    public final void x0(@NotNull DragViewModel dragViewModel) {
        Intrinsics.checkNotNullParameter(dragViewModel, "dragViewModel");
        x xVar = this.trackManager;
        if (xVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("trackManager");
            xVar = null;
        }
        xVar.g(dragViewModel);
    }

    public final void y0(@NotNull m dragView) {
        ViewParent viewParent;
        Object obj;
        Intrinsics.checkNotNullParameter(dragView, "dragView");
        View b16 = n.b(dragView);
        ViewGroup.MarginLayoutParams marginLayoutParams = null;
        if (b16 != null) {
            viewParent = b16.getParent();
        } else {
            viewParent = null;
        }
        if (viewParent == null) {
            return;
        }
        View b17 = n.b(dragView);
        if (b17 != null) {
            obj = b17.getLayoutParams();
        } else {
            obj = null;
        }
        if (obj instanceof ViewGroup.MarginLayoutParams) {
            marginLayoutParams = (ViewGroup.MarginLayoutParams) obj;
        }
        if (marginLayoutParams != null) {
            scrollTo(0, marginLayoutParams.topMargin);
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public DragDropScrollView(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public DragDropScrollView(@NotNull Context context, @Nullable AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        Intrinsics.checkNotNullParameter(context, "context");
        this.Q = new LinkedHashMap();
        this.contentTopMargin = com.tencent.videocut.utils.e.f384236a.a(10.0f);
        this.attractPoints = new HashSet<>();
        this.dragEventHandler = new DragEventHandler(this);
        this.flingHelper = new FlingHelper();
        this.halfScreenWidth = (int) (O() * 0.5f);
        this.listener = new b();
        Y();
    }

    public /* synthetic */ DragDropScrollView(Context context, AttributeSet attributeSet, int i3, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i16 & 2) != 0 ? null : attributeSet, (i16 & 4) != 0 ? 0 : i3);
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0018\u0010\b\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0006H\u0016\u00a8\u0006\t"}, d2 = {"com/tencent/mobileqq/wink/editor/clipping/timeline/widget/dragdrop/DragDropScrollView$b", "Lcom/tencent/mobileqq/wink/editor/clipping/timeline/widget/panel/scroll/FlingHelper$a;", "", "xPos", "", "b", "", "cancel", "a", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes21.dex */
    public static final class b implements FlingHelper.a {
        b() {
        }

        @Override // com.tencent.mobileqq.wink.editor.clipping.timeline.widget.panel.scroll.FlingHelper.a
        public void b(int xPos) {
            DragDropScrollView dragDropScrollView = DragDropScrollView.this;
            dragDropScrollView.scrollTo(dragDropScrollView.getScrollX(), xPos);
        }

        @Override // com.tencent.mobileqq.wink.editor.clipping.timeline.widget.panel.scroll.FlingHelper.a
        public void a(int xPos, boolean cancel) {
        }
    }
}

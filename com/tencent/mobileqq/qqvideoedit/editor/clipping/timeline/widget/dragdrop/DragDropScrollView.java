package com.tencent.mobileqq.qqvideoedit.editor.clipping.timeline.widget.dragdrop;

import android.content.ClipData;
import android.content.Context;
import android.graphics.PointF;
import android.os.Build;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
import android.widget.HorizontalScrollView;
import android.widget.RelativeLayout;
import androidx.annotation.RequiresApi;
import androidx.core.widget.NestedScrollView;
import androidx.dynamicanimation.animation.DynamicAnimation;
import androidx.exifinterface.media.ExifInterface;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.autotemplate.filter.TAVOneClickFilmStickerEffect;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qqvideoedit.editor.clipping.timeline.widget.panel.TimelinePanelViewController;
import com.tencent.mobileqq.qqvideoedit.editor.clipping.timeline.widget.panel.event.PanelEventHandler;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt___RangesKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u00e6\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\"\n\u0002\b<\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 z2\u00020\u00012\u00020\u00022\u00020\u0003:\u0001lB.\b\u0007\u0012\b\u0010\u00c2\u0001\u001a\u00030\u00c1\u0001\u0012\f\b\u0002\u0010\u00c4\u0001\u001a\u0005\u0018\u00010\u00c3\u0001\u0012\t\b\u0002\u0010\u00c5\u0001\u001a\u00020\u001e\u00a2\u0006\u0006\b\u00c6\u0001\u0010\u00c7\u0001J\b\u0010\u0005\u001a\u00020\u0004H\u0002J\b\u0010\u0006\u001a\u00020\u0004H\u0002J\b\u0010\u0007\u001a\u00020\u0004H\u0002J\b\u0010\t\u001a\u00020\bH\u0002J\u0012\u0010\f\u001a\u00020\u00042\b\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0002J\b\u0010\r\u001a\u00020\u0004H\u0002J\u0012\u0010\u0010\u001a\u00020\u00042\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eH\u0002J\b\u0010\u0011\u001a\u00020\u0004H\u0002J \u0010\u0018\u001a\u00020\u00042\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0017\u001a\u00020\u0016H\u0002J\u0010\u0010\u001b\u001a\u00020\u001a2\u0006\u0010\u0019\u001a\u00020\nH\u0002J\u0010\u0010\u001f\u001a\u00020\u001e2\u0006\u0010\u001d\u001a\u00020\u001cH\u0002J\u0018\u0010\"\u001a\u00020\u00042\u0006\u0010!\u001a\u00020 2\u0006\u0010\u0015\u001a\u00020\nH\u0002J \u0010%\u001a\u00020\u00042\u0006\u0010#\u001a\u00020\u001e2\u0006\u0010$\u001a\u00020\u001a2\u0006\u0010\u0015\u001a\u00020\nH\u0002J\u0018\u0010'\u001a\u00020\u001a2\u0006\u0010\u0019\u001a\u00020\n2\u0006\u0010&\u001a\u00020\u001eH\u0002J\u0018\u0010)\u001a\u00020\u001a2\u0006\u0010\u0019\u001a\u00020\n2\u0006\u0010(\u001a\u00020\u001eH\u0002J\u0010\u0010*\u001a\u00020\u001a2\u0006\u0010\u0019\u001a\u00020\nH\u0002J\u0010\u0010+\u001a\u00020\u001a2\u0006\u0010\u0019\u001a\u00020\nH\u0002J\u0010\u0010,\u001a\u00020\u001a2\u0006\u0010\u0019\u001a\u00020\nH\u0002J(\u00101\u001a\u00020\u00042\u0006\u0010-\u001a\u00020\u001e2\u0006\u0010.\u001a\u00020\u001e2\u0006\u0010/\u001a\u00020\u001e2\u0006\u00100\u001a\u00020\u001eH\u0014J\u0010\u00104\u001a\u00020\u001a2\u0006\u00103\u001a\u000202H\u0016J\b\u00105\u001a\u00020\u001eH\u0016J\u0018\u0010-\u001a\u00020\u00042\u0006\u00106\u001a\u00020\u001e2\u0006\u00107\u001a\u00020\u001eH\u0016J\u0016\u0010:\u001a\b\u0012\u0004\u0012\u000209082\u0006\u0010\u000f\u001a\u00020\u000eH\u0016J\b\u0010;\u001a\u00020\u001cH\u0016J\b\u0010<\u001a\u00020\u001eH\u0016J\b\u0010=\u001a\u00020\u001eH\u0017J\b\u0010>\u001a\u00020\u001eH\u0016J\u001f\u0010C\u001a\u00020\u00042\u000e\u0010@\u001a\n\u0012\u0004\u0012\u00020\u001e\u0018\u00010?H\u0000\u00a2\u0006\u0004\bA\u0010BJ\u0017\u00107\u001a\u00020\u00122\u0006\u0010D\u001a\u00020\u001eH\u0000\u00a2\u0006\u0004\b7\u0010EJ\u001f\u0010F\u001a\u00020\u00042\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0015\u001a\u00020\u0014H\u0000\u00a2\u0006\u0004\bF\u0010GJ\u0019\u0010H\u001a\u00020\u00042\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eH\u0000\u00a2\u0006\u0004\bH\u0010IJ\u0017\u0010J\u001a\u00020\u00042\u0006\u0010\u0015\u001a\u00020\u0014H\u0000\u00a2\u0006\u0004\bJ\u0010KJ\u0010\u0010M\u001a\u00020\u00042\u0006\u0010L\u001a\u00020\u001eH\u0016J\u000f\u0010N\u001a\u00020\u0004H\u0000\u00a2\u0006\u0004\bN\u0010OJ\u001f\u0010R\u001a\u00020\u00042\u0006\u0010P\u001a\u00020\u00142\u0006\u0010Q\u001a\u00020\u001eH\u0000\u00a2\u0006\u0004\bR\u0010SJ\u0010\u0010T\u001a\u00020\u00042\u0006\u0010\u0015\u001a\u00020\u0014H\u0016J\u000f\u0010U\u001a\u00020\u001eH\u0000\u00a2\u0006\u0004\bU\u0010VJ\u000f\u0010W\u001a\u00020\u001eH\u0000\u00a2\u0006\u0004\bW\u0010VJ\u0017\u0010[\u001a\u00020\u00042\u0006\u0010X\u001a\u00020\u001aH\u0000\u00a2\u0006\u0004\bY\u0010ZJ\u000f\u0010\\\u001a\u00020\u0004H\u0000\u00a2\u0006\u0004\b\\\u0010OJ\u000f\u0010]\u001a\u00020\u0004H\u0000\u00a2\u0006\u0004\b]\u0010OJ\u000f\u0010^\u001a\u00020\u001aH\u0000\u00a2\u0006\u0004\b^\u0010_J\u001f\u0010`\u001a\u00020\u00042\u0006\u0010\u0015\u001a\u00020\n2\u0006\u0010!\u001a\u00020 H\u0000\u00a2\u0006\u0004\b`\u0010aJ\u0017\u0010d\u001a\u00020\u00042\u0006\u0010b\u001a\u00020\u001aH\u0000\u00a2\u0006\u0004\bc\u0010ZJ\u001a\u0010f\u001a\u00020\u00042\b\u0010\u0015\u001a\u0004\u0018\u00010\u00142\u0006\u0010e\u001a\u00020\u001aH\u0016J\b\u0010g\u001a\u00020\u001eH\u0016J\u0018\u0010h\u001a\u00020\u00042\u0006\u0010#\u001a\u00020\u001e2\u0006\u0010\u0019\u001a\u00020\nH\u0016J\u001c\u0010k\u001a\u00020\u00042\b\u0010i\u001a\u0004\u0018\u0001092\b\u0010j\u001a\u0004\u0018\u000109H\u0016J\b\u0010l\u001a\u00020\u0004H\u0016J\u001f\u0010m\u001a\u00020\u001a2\u0006\u0010\u0019\u001a\u00020\n2\u0006\u0010(\u001a\u00020\u001eH\u0000\u00a2\u0006\u0004\bm\u0010nJ\u001f\u0010o\u001a\u00020\u00042\u0006\u0010#\u001a\u00020\u001e2\u0006\u0010\u0015\u001a\u00020\nH\u0000\u00a2\u0006\u0004\bo\u0010pJ\u001b\u0010r\u001a\u00020\u00042\n\b\u0002\u0010q\u001a\u0004\u0018\u00010\u0014H\u0000\u00a2\u0006\u0004\br\u0010KJ\u0010\u0010t\u001a\u00020\u001e2\u0006\u0010s\u001a\u00020\u001eH\u0016J\u0010\u0010v\u001a\u00020\u001e2\u0006\u0010u\u001a\u00020\u001eH\u0016J\u0017\u0010y\u001a\u00020\u00042\u0006\u0010w\u001a\u00020\u001aH\u0000\u00a2\u0006\u0004\bx\u0010ZJ\u000f\u0010z\u001a\u00020\u001eH\u0000\u00a2\u0006\u0004\bz\u0010VJ\u000f\u0010{\u001a\u00020\u001eH\u0000\u00a2\u0006\u0004\b{\u0010VJ\u0014\u0010~\u001a\u00020\u00042\n\u0010}\u001a\u0006\u0012\u0002\b\u00030|H\u0016J\u000f\u0010\u007f\u001a\u00020\u001eH\u0000\u00a2\u0006\u0004\b\u007f\u0010VJ\u001b\u0010\u0081\u0001\u001a\u00020\u00042\u0007\u0010\u0080\u0001\u001a\u00020\u001eH\u0000\u00a2\u0006\u0006\b\u0081\u0001\u0010\u0082\u0001J\u001c\u0010\u0085\u0001\u001a\u00020\u00042\b\u0010\u0084\u0001\u001a\u00030\u0083\u0001H\u0000\u00a2\u0006\u0006\b\u0085\u0001\u0010\u0086\u0001J#\u0010\u0088\u0001\u001a\u00020\u00042\u0006\u0010\u0015\u001a\u00020\n2\u0007\u0010\u0087\u0001\u001a\u00020\u001aH\u0000\u00a2\u0006\u0006\b\u0088\u0001\u0010\u0089\u0001J\u001a\u0010\u008a\u0001\u001a\u00020\u001a2\u0006\u0010\u0019\u001a\u00020\nH\u0000\u00a2\u0006\u0006\b\u008a\u0001\u0010\u008b\u0001J\u0011\u0010\u008c\u0001\u001a\u00020\u0004H\u0000\u00a2\u0006\u0005\b\u008c\u0001\u0010OJ\u001c\u0010\u008f\u0001\u001a\u00020\u00042\b\u0010\u008e\u0001\u001a\u00030\u008d\u0001H\u0000\u00a2\u0006\u0006\b\u008f\u0001\u0010\u0090\u0001R\u0017\u0010\u0091\u0001\u001a\u00020\u001e8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bv\u0010\u007fR\u001a\u0010\u0093\u0001\u001a\u0004\u0018\u00010\b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0007\n\u0005\b;\u0010\u0092\u0001R+\u0010\u009a\u0001\u001a\u0005\u0018\u00010\u0094\u00018\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0017\n\u0005\b>\u0010\u0095\u0001\u001a\u0006\b\u0096\u0001\u0010\u0097\u0001\"\u0006\b\u0098\u0001\u0010\u0099\u0001R)\u0010\u009f\u0001\u001a\u0014\u0012\u0004\u0012\u00020\u001e0\u009b\u0001j\t\u0012\u0004\u0012\u00020\u001e`\u009c\u00018\u0002X\u0082\u0004\u00a2\u0006\b\n\u0006\b\u009d\u0001\u0010\u009e\u0001R\u001b\u0010\u00a2\u0001\u001a\u0005\u0018\u00010\u00a0\u00018\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0007\n\u0005\b<\u0010\u00a1\u0001R\u0018\u0010\u00a4\u0001\u001a\u00020\u001e8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0007\n\u0005\b\u00a3\u0001\u0010\u007fR\u0016\u0010X\u001a\u00020\u001a8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\br\u0010,R\u001a\u0010\u00a8\u0001\u001a\u00030\u00a5\u00018\u0002@\u0002X\u0082.\u00a2\u0006\b\n\u0006\b\u00a6\u0001\u0010\u00a7\u0001R\u0017\u0010\u00ab\u0001\u001a\u00030\u00a9\u00018\u0002X\u0082\u0004\u00a2\u0006\u0007\n\u0005\b\t\u0010\u00aa\u0001R\u0019\u0010\u00ac\u0001\u001a\u00020\u001c8\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u0085\u0001\u0010\u0085\u0001R\u0018\u0010\u00ad\u0001\u001a\u00020\u001c8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0007\n\u0005\b\u001f\u0010\u0085\u0001R\u0019\u0010\u00ae\u0001\u001a\u00020\u001c8\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u0096\u0001\u0010\u0085\u0001R\u0018\u0010\u00af\u0001\u001a\u00020\u001c8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0007\n\u0005\b\u007f\u0010\u0085\u0001R\u0018\u0010\u00b3\u0001\u001a\u00030\u00b0\u00018\u0002X\u0082\u0004\u00a2\u0006\b\n\u0006\b\u00b1\u0001\u0010\u00b2\u0001R\u0016\u0010\u00b5\u0001\u001a\u00020\u001e8\u0002X\u0082\u0004\u00a2\u0006\u0007\n\u0005\b\u00b4\u0001\u0010\u007fR\u0017\u0010\u00b8\u0001\u001a\u00030\u00b6\u00018\u0002X\u0082\u0004\u00a2\u0006\u0007\n\u0005\b=\u0010\u00b7\u0001R\u0017\u0010\u00b9\u0001\u001a\u00020\u001e8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bU\u0010\u007fR\u0016\u0010\u00ba\u0001\u001a\u00020\u001e8BX\u0082\u0004\u00a2\u0006\u0007\u001a\u0005\b\u00b4\u0001\u0010VR)\u0010\u00be\u0001\u001a\u0014\u0012\u0004\u0012\u00020\u00120\u00bb\u0001j\t\u0012\u0004\u0012\u00020\u0012`\u00bc\u00018VX\u0096\u0004\u00a2\u0006\b\u001a\u0006\b\u009d\u0001\u0010\u00bd\u0001R\u0017\u0010\u00c0\u0001\u001a\u00020\u001c8@X\u0080\u0004\u00a2\u0006\b\u001a\u0006\b\u00b1\u0001\u0010\u00bf\u0001\u00a8\u0006\u00c8\u0001"}, d2 = {"Lcom/tencent/mobileqq/qqvideoedit/editor/clipping/timeline/widget/dragdrop/DragDropScrollView;", "Landroidx/core/widget/NestedScrollView;", "Lcom/tencent/mobileqq/qqvideoedit/editor/clipping/timeline/widget/dragdrop/n;", "Lpj2/b;", "", "U", BdhLogUtil.LogTag.Tag_Req, "T", "Landroid/widget/HorizontalScrollView;", "E", "Landroid/view/View;", "child", "k0", "B", "", "id", "j0", "c0", "Lcom/tencent/mobileqq/qqvideoedit/editor/clipping/timeline/widget/dragdrop/y;", "trackModel", "Lcom/tencent/mobileqq/qqvideoedit/editor/clipping/timeline/widget/dragdrop/o;", "dragView", "Landroid/widget/RelativeLayout$LayoutParams;", "layoutParams", "f0", "view", "", "p0", "", "dp", "", "G", "Landroid/graphics/PointF;", "newPosition", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "positionOffset", "isEnd", "q0", "rightSpace", "W", "xOffset", "m0", "n0", "Y", "Z", "l", "t", "oldl", "oldt", "onScrollChanged", "Landroid/view/MotionEvent;", "ev", NodeProps.ON_INTERCEPT_TOUCH_EVENT, DomainData.DOMAIN_NAME, HippyTKDListViewAdapter.X, "y", "", "Lcom/tencent/mobileqq/qqvideoedit/editor/clipping/timeline/widget/dragdrop/a;", "b", "e", "i", "L", "f", "", "points", "setAttractPointPosition$qqvideoedit_impl_release", "(Ljava/util/Set;)V", "setAttractPointPosition", "trackType", "(I)Lcom/tencent/mobileqq/qqvideoedit/editor/clipping/timeline/widget/dragdrop/y;", "b0", "(Lcom/tencent/mobileqq/qqvideoedit/editor/clipping/timeline/widget/dragdrop/y;Lcom/tencent/mobileqq/qqvideoedit/editor/clipping/timeline/widget/dragdrop/o;)V", "h0", "(Ljava/lang/String;)V", "v0", "(Lcom/tencent/mobileqq/qqvideoedit/editor/clipping/timeline/widget/dragdrop/o;)V", "velocityY", "fling", "d0", "()V", "iDragView", TAVOneClickFilmStickerEffect.TRACK_INDEX, "e0", "(Lcom/tencent/mobileqq/qqvideoedit/editor/clipping/timeline/widget/dragdrop/o;I)V", "p", "M", "()I", "O", "disableBottomLine", "setDisableBottomLine$qqvideoedit_impl_release", "(Z)V", "setDisableBottomLine", AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, "o0", "V", "()Z", QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, "(Landroid/view/View;Landroid/graphics/PointF;)V", "canAddEmptyTrackOnDrop", "setCanAddEmptyTrackOnDrop$qqvideoedit_impl_release", "setCanAddEmptyTrackOnDrop", "isSelected", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "c", "g", "startPoint", "endPoint", "setAdsorbedPoint", "a", "l0", "(Landroid/view/View;I)Z", "r0", "(ILandroid/view/View;)V", "selectedView", BdhLogUtil.LogTag.Tag_Conn, "rightMargin", "j", "leftMargin", "d", "needDrawTrackBackground", "setNeedDrawTrackBackground$qqvideoedit_impl_release", "setNeedDrawTrackBackground", "N", "P", "Lpj2/a;", "controller", "o", "I", NodeProps.MIN_WIDTH, "g0", "(I)V", "Lcom/tencent/mobileqq/qqvideoedit/editor/clipping/timeline/widget/panel/event/d;", "panelEvent", UserInfo.SEX_FEMALE, "(Lcom/tencent/mobileqq/qqvideoedit/editor/clipping/timeline/widget/panel/event/d;)V", "available", "t0", "(Landroid/view/View;Z)V", "X", "(Landroid/view/View;)Z", "i0", "Lcom/tencent/mobileqq/qqvideoedit/editor/clipping/timeline/widget/dragdrop/k;", "dragViewModel", "u0", "(Lcom/tencent/mobileqq/qqvideoedit/editor/clipping/timeline/widget/dragdrop/k;)V", "contentTopMargin", "Landroid/widget/HorizontalScrollView;", "horizontalScrollView", "Lcom/tencent/mobileqq/qqvideoedit/editor/clipping/timeline/widget/dragdrop/BottomLineRelativeLayout;", "Lcom/tencent/mobileqq/qqvideoedit/editor/clipping/timeline/widget/dragdrop/BottomLineRelativeLayout;", "H", "()Lcom/tencent/mobileqq/qqvideoedit/editor/clipping/timeline/widget/dragdrop/BottomLineRelativeLayout;", "setContentView", "(Lcom/tencent/mobileqq/qqvideoedit/editor/clipping/timeline/widget/dragdrop/BottomLineRelativeLayout;)V", "contentView", "Ljava/util/HashSet;", "Lkotlin/collections/HashSet;", tl.h.F, "Ljava/util/HashSet;", "attractPoints", "Lcom/tencent/mobileqq/qqvideoedit/editor/clipping/timeline/widget/dragdrop/f;", "Lcom/tencent/mobileqq/qqvideoedit/editor/clipping/timeline/widget/dragdrop/f;", "dragDropScrollViewController", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "whiteLineWidth", "Lcom/tencent/mobileqq/qqvideoedit/editor/clipping/timeline/widget/dragdrop/x;", "D", "Lcom/tencent/mobileqq/qqvideoedit/editor/clipping/timeline/widget/dragdrop/x;", "trackManager", "Lcom/tencent/mobileqq/qqvideoedit/editor/clipping/timeline/widget/dragdrop/DragEventHandler;", "Lcom/tencent/mobileqq/qqvideoedit/editor/clipping/timeline/widget/dragdrop/DragEventHandler;", "dragEventHandler", "xDistance", "yDistance", "lastX", "lastY", "Ltj2/a;", "J", "Ltj2/a;", "flingHelper", "K", "halfScreenWidth", "Landroidx/dynamicanimation/animation/DynamicAnimation$OnAnimationUpdateListener;", "Landroidx/dynamicanimation/animation/DynamicAnimation$OnAnimationUpdateListener;", "listener", "contentViewDownWidth", "screenWidth", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "()Ljava/util/ArrayList;", "trackModels", "()F", "minAttractDistance", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "qqvideoedit_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes17.dex */
public final class DragDropScrollView extends NestedScrollView implements n, pj2.b {

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
    private final tj2.a flingHelper;

    /* renamed from: K, reason: from kotlin metadata */
    private final int halfScreenWidth;

    /* renamed from: L, reason: from kotlin metadata */
    @NotNull
    private final DynamicAnimation.OnAnimationUpdateListener listener;

    /* renamed from: M, reason: from kotlin metadata */
    private int contentViewDownWidth;

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
    private f dragDropScrollViewController;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private int whiteLineWidth;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public DragDropScrollView(@NotNull Context context) {
        this(context, null, 0, 6, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    private final void A(PointF newPosition, View dragView) {
        o a16;
        int f16;
        int coerceAtMost;
        BottomLineRelativeLayout bottomLineRelativeLayout = this.contentView;
        if (bottomLineRelativeLayout == null || (a16 = p.a(dragView)) == null) {
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

    private final void B() {
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

    public static /* synthetic */ void D(DragDropScrollView dragDropScrollView, o oVar, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            oVar = null;
        }
        dragDropScrollView.C(oVar);
    }

    private final HorizontalScrollView E() {
        return new DragDropScrollView$createHorizontalScrollView$1(this, getContext());
    }

    private final int G(float dp5) {
        return com.tencent.videocut.utils.e.f384236a.a(dp5);
    }

    private final int K() {
        return getContext().getResources().getDisplayMetrics().widthPixels;
    }

    private final void R() {
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
        bottomLineRelativeLayout.setMinimumHeight((xVar.c() * 1) + (O() * 0));
        HorizontalScrollView horizontalScrollView = this.horizontalScrollView;
        if (horizontalScrollView != null) {
            horizontalScrollView.addView(bottomLineRelativeLayout, layoutParams);
        }
        bottomLineRelativeLayout.setOnDragListener(this.dragEventHandler);
        bottomLineRelativeLayout.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.qqvideoedit.editor.clipping.timeline.widget.dragdrop.d
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                DragDropScrollView.S(DragDropScrollView.this, view);
            }
        });
        this.contentView = bottomLineRelativeLayout;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void S(DragDropScrollView this$0, View view) {
        PanelEventHandler j3;
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        f fVar = this$0.dragDropScrollViewController;
        if (fVar != null && (j3 = fVar.j()) != null) {
            j3.a(new com.tencent.mobileqq.qqvideoedit.editor.clipping.timeline.widget.panel.event.b());
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    private final void T() {
        setFillViewport(true);
        HorizontalScrollView E = E();
        E.setOverScrollMode(2);
        E.setVerticalScrollBarEnabled(false);
        E.setHorizontalScrollBarEnabled(false);
        addView(E, new FrameLayout.LayoutParams(-1, -1));
        this.horizontalScrollView = E;
    }

    private final void U() {
        T();
        this.whiteLineWidth = G(2.0f);
    }

    private final boolean W(View view, int rightSpace) {
        BottomLineRelativeLayout bottomLineRelativeLayout = this.contentView;
        Intrinsics.checkNotNull(bottomLineRelativeLayout);
        if (bottomLineRelativeLayout.getRight() - view.getRight() == this.halfScreenWidth - rightSpace) {
            return true;
        }
        return false;
    }

    private final boolean Y(View view) {
        if (((int) view.getY()) + view.getMeasuredHeight() == (getScrollY() + getMeasuredHeight()) - this.contentTopMargin) {
            return true;
        }
        return false;
    }

    private final boolean Z(View view) {
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

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a0(DragDropScrollView this$0, DynamicAnimation dynamicAnimation, float f16, float f17) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.scrollTo(this$0.getScrollX(), (int) f16);
    }

    private final void c0() {
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
                o a16 = p.a(view);
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
                    f0(yVar2, a16, layoutParams2);
                    view.invalidate();
                    view.requestLayout();
                }
            }
        }
    }

    private final void f0(y trackModel, o dragView, RelativeLayout.LayoutParams layoutParams) {
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
    private final void j0(String id5) {
        BottomLineRelativeLayout bottomLineRelativeLayout = this.contentView;
        if (bottomLineRelativeLayout != null) {
            int childCount = bottomLineRelativeLayout.getChildCount();
            for (int i3 = 0; i3 < childCount; i3++) {
                View childAt = bottomLineRelativeLayout.getChildAt(i3);
                if (childAt != 0) {
                    Intrinsics.checkNotNullExpressionValue(childAt, "getChildAt(i)");
                    if ((childAt instanceof o) && Intrinsics.areEqual(((o) childAt).getDragViewModel().getId(), id5)) {
                        bottomLineRelativeLayout.removeView(childAt);
                        return;
                    }
                }
            }
        }
    }

    private final void k0(View child) {
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

    private final boolean m0(View view, int xOffset) {
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

    private final boolean n0(View view) {
        boolean z16;
        com.tencent.videocut.utils.e eVar = com.tencent.videocut.utils.e.f384236a;
        int a16 = eVar.a(15.0f);
        int a17 = eVar.a(5.0f);
        boolean z17 = true;
        if (view.getY() <= getScrollY() + a16) {
            if (Z(view)) {
                return false;
            }
            smoothScrollBy(0, -a17);
            z16 = true;
        } else {
            z16 = false;
        }
        if (view.getY() + view.getMeasuredHeight() >= ((getScrollY() + getMeasuredHeight()) - this.contentTopMargin) - a16) {
            if (Y(view)) {
                return z16;
            }
            smoothScrollBy(0, a17);
        } else {
            z17 = z16;
        }
        view.setTag(R.id.ull, Boolean.valueOf(z17));
        return z17;
    }

    private final boolean p0(View view) {
        boolean startDragAndDrop;
        view.performHapticFeedback(0, 2);
        view.setAlpha(0.7f);
        D(this, null, 1, null);
        j jVar = new j(view);
        ClipData newPlainText = ClipData.newPlainText("Label", "");
        try {
            if (Build.VERSION.SDK_INT >= 24) {
                startDragAndDrop = view.startDragAndDrop(newPlainText, jVar, view, 0);
                return startDragAndDrop;
            }
            return startDrag(newPlainText, jVar, view, 0);
        } catch (Throwable th5) {
            String message = th5.getMessage();
            if (message != null) {
                mj2.a.b("DragDrop-ScrollView", message);
            }
            return false;
        }
    }

    private final void q0(int positionOffset, boolean isEnd, View dragView) {
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
            o a16 = p.a(dragView);
            if (a16 != null) {
                i3 = a16.p();
            } else {
                i3 = 0;
            }
            if (W(dragView, i3)) {
                layoutParams.width += positionOffset;
            }
        }
        f fVar = this.dragDropScrollViewController;
        if (fVar != null && (panelViewController = fVar.getPanelViewController()) != null) {
            panelViewController.m();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean s0(DragDropScrollView this$0, View dragView, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(dragView, "$dragView");
        return this$0.p0(dragView);
    }

    public final void C(@Nullable o selectedView) {
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

    public final void F(@NotNull com.tencent.mobileqq.qqvideoedit.editor.clipping.timeline.widget.panel.event.d panelEvent) {
        PanelEventHandler j3;
        Intrinsics.checkNotNullParameter(panelEvent, "panelEvent");
        f fVar = this.dragDropScrollViewController;
        if (fVar != null && (j3 = fVar.j()) != null) {
            j3.a(panelEvent);
        }
    }

    @Nullable
    /* renamed from: H, reason: from getter */
    public final BottomLineRelativeLayout getContentView() {
        return this.contentView;
    }

    public final int I() {
        BottomLineRelativeLayout bottomLineRelativeLayout = this.contentView;
        int i3 = 0;
        if (bottomLineRelativeLayout != null) {
            int childCount = bottomLineRelativeLayout.getChildCount();
            int i16 = 0;
            while (i3 < childCount) {
                View childAt = bottomLineRelativeLayout.getChildAt(i3);
                Intrinsics.checkNotNullExpressionValue(childAt, "it.getChildAt(i)");
                o a16 = p.a(childAt);
                if (a16 != null && a16.h() > i16) {
                    i16 = a16.h();
                }
                i3++;
            }
            i3 = i16;
        }
        return i3 + getHalfScreenWidth() + P();
    }

    public final float J() {
        return G(5.0f);
    }

    @RequiresApi(17)
    public int L() {
        BottomLineRelativeLayout bottomLineRelativeLayout = this.contentView;
        if (bottomLineRelativeLayout != null) {
            return bottomLineRelativeLayout.getPaddingStart();
        }
        return 0;
    }

    public final int M() {
        x xVar = this.trackManager;
        if (xVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("trackManager");
            xVar = null;
        }
        return xVar.c();
    }

    /* renamed from: N, reason: from getter */
    public final int getHalfScreenWidth() {
        return this.halfScreenWidth;
    }

    public final int O() {
        x xVar = this.trackManager;
        if (xVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("trackManager");
            xVar = null;
        }
        return xVar.d();
    }

    public final int P() {
        return this.halfScreenWidth;
    }

    public final void Q() {
        BottomLineRelativeLayout bottomLineRelativeLayout;
        if (!this.disableBottomLine && (bottomLineRelativeLayout = this.contentView) != null) {
            bottomLineRelativeLayout.setDrawBottomLine(false);
        }
    }

    public final boolean V() {
        BottomLineRelativeLayout bottomLineRelativeLayout = this.contentView;
        if (bottomLineRelativeLayout != null) {
            return bottomLineRelativeLayout.getDrawBottomLine();
        }
        return false;
    }

    public final boolean X(@NotNull View view) {
        Intrinsics.checkNotNullParameter(view, "view");
        if (this.contentView == null || view.getY() + view.getHeight() < r0.getBottom() - this.contentTopMargin) {
            return false;
        }
        return true;
    }

    @Override // com.tencent.mobileqq.qqvideoedit.editor.clipping.timeline.widget.dragdrop.n
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

    @Override // com.tencent.mobileqq.qqvideoedit.editor.clipping.timeline.widget.dragdrop.n
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
                o a16 = p.a(childAt);
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

    public final void b0(@NotNull y trackModel, @NotNull o dragView) {
        TimelinePanelViewController panelViewController;
        Intrinsics.checkNotNullParameter(trackModel, "trackModel");
        Intrinsics.checkNotNullParameter(dragView, "dragView");
        View b16 = p.b(dragView);
        if (b16 == null) {
            return;
        }
        k0(b16);
        dragView.setDragViewModel(DragViewModel.b(dragView.getDragViewModel(), null, 0, 0, 0L, trackModel.getIndex(), null, null, 111, null));
        trackModel.k(dragView.getDragViewModel());
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        f0(trackModel, dragView, layoutParams);
        f fVar = this.dragDropScrollViewController;
        if (fVar != null && (panelViewController = fVar.getPanelViewController()) != null) {
            panelViewController.m();
        }
        BottomLineRelativeLayout bottomLineRelativeLayout = this.contentView;
        if (bottomLineRelativeLayout != null) {
            bottomLineRelativeLayout.addView(b16, layoutParams);
        }
        B();
        t0(b16, true);
        dragView.setValueChangeListener(new t(this));
    }

    @Override // com.tencent.mobileqq.qqvideoedit.editor.clipping.timeline.widget.dragdrop.n
    public int c() {
        return 1073741824;
    }

    @Override // com.tencent.mobileqq.qqvideoedit.editor.clipping.timeline.widget.dragdrop.n
    public int d(int leftMargin) {
        HorizontalScrollView horizontalScrollView = this.horizontalScrollView;
        Intrinsics.checkNotNull(horizontalScrollView);
        return (horizontalScrollView.getScrollX() - this.halfScreenWidth) + G(leftMargin);
    }

    public final void d0() {
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
            yVar2.q(index * (xVar.c() + O()));
            int top = yVar2.getTop();
            x xVar3 = this.trackManager;
            if (xVar3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("trackManager");
            } else {
                xVar2 = xVar3;
            }
            yVar2.m(top + xVar2.c());
            yVar2.o(getHalfScreenWidth());
            yVar2.p(P());
        }
        c0();
        g0(i());
    }

    @Override // com.tencent.mobileqq.qqvideoedit.editor.clipping.timeline.widget.dragdrop.n
    public float e() {
        return J();
    }

    public final void e0(@NotNull o iDragView, int trackIndex) {
        Intrinsics.checkNotNullParameter(iDragView, "iDragView");
        View b16 = p.b(iDragView);
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
        q0(h16 - i3, false, b16);
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
        h0(iDragView.getDragViewModel().getId());
        while (trackIndex >= h().size()) {
            y(iDragView.getTrackType());
        }
        y yVar = h().get(trackIndex);
        Intrinsics.checkNotNullExpressionValue(yVar, "trackModels[trackIndex]");
        b0(yVar, iDragView);
    }

    @Override // com.tencent.mobileqq.qqvideoedit.editor.clipping.timeline.widget.dragdrop.n
    public int f() {
        rj2.a l3;
        f fVar = this.dragDropScrollViewController;
        if (fVar != null && (l3 = fVar.l()) != null) {
            return l3.c();
        }
        return 0;
    }

    @Override // androidx.core.widget.NestedScrollView
    public void fling(int velocityY) {
        float f16;
        tj2.a aVar = this.flingHelper;
        float f17 = velocityY;
        float scrollY = getScrollY();
        BottomLineRelativeLayout bottomLineRelativeLayout = this.contentView;
        if (bottomLineRelativeLayout != null) {
            f16 = bottomLineRelativeLayout.getMeasuredHeight();
        } else {
            f16 = 0.0f;
        }
        aVar.b(f17, scrollY, f16, this.listener);
    }

    @Override // com.tencent.mobileqq.qqvideoedit.editor.clipping.timeline.widget.dragdrop.n
    public void g(int positionOffset, @NotNull View view) {
        int i3;
        Intrinsics.checkNotNullParameter(view, "view");
        q0(positionOffset, true, view);
        o a16 = p.a(view);
        if (a16 != null) {
            i3 = a16.p();
        } else {
            i3 = 0;
        }
        if (W(view, i3)) {
            HorizontalScrollView horizontalScrollView = this.horizontalScrollView;
            Intrinsics.checkNotNull(horizontalScrollView);
            l((horizontalScrollView.getScrollX() + this.halfScreenWidth) - i3, 0);
        }
    }

    public final void g0(int minWidth) {
        mj2.a.a("DragDrop-ScrollView", "refreshWidth called minWidth is : " + minWidth);
        BottomLineRelativeLayout bottomLineRelativeLayout = this.contentView;
        if (bottomLineRelativeLayout != null) {
            ViewGroup.LayoutParams layoutParams = bottomLineRelativeLayout.getLayoutParams();
            layoutParams.width = minWidth;
            bottomLineRelativeLayout.setLayoutParams(layoutParams);
        }
    }

    @Override // com.tencent.mobileqq.qqvideoedit.editor.clipping.timeline.widget.dragdrop.n
    @NotNull
    public ArrayList<y> h() {
        x xVar = this.trackManager;
        if (xVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("trackManager");
            xVar = null;
        }
        return xVar.e();
    }

    public final void h0(@Nullable String id5) {
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
        j0(id5);
        f fVar = this.dragDropScrollViewController;
        if (fVar != null && (panelViewController = fVar.getPanelViewController()) != null) {
            panelViewController.m();
        }
    }

    @Override // com.tencent.mobileqq.qqvideoedit.editor.clipping.timeline.widget.dragdrop.n
    public int i() {
        Integer num;
        rj2.a l3;
        f fVar = this.dragDropScrollViewController;
        if (fVar != null) {
            if (fVar != null && (l3 = fVar.l()) != null) {
                num = Integer.valueOf(l3.c());
            } else {
                num = null;
            }
            Intrinsics.checkNotNull(num);
            return num.intValue() + K();
        }
        throw new Exception("scaleCalculator is null, need set scaleCalculator first");
    }

    public final void i0() {
        x xVar = this.trackManager;
        if (xVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("trackManager");
            xVar = null;
        }
        xVar.f();
    }

    @Override // com.tencent.mobileqq.qqvideoedit.editor.clipping.timeline.widget.dragdrop.n
    public int j(int rightMargin) {
        HorizontalScrollView horizontalScrollView = this.horizontalScrollView;
        Intrinsics.checkNotNull(horizontalScrollView);
        return (horizontalScrollView.getScrollX() + this.halfScreenWidth) - G(rightMargin);
    }

    public void l(int x16, int y16) {
        HorizontalScrollView horizontalScrollView = this.horizontalScrollView;
        if (horizontalScrollView != null) {
            horizontalScrollView.scrollTo(x16, y16);
        }
    }

    public final boolean l0(@NotNull View view, int xOffset) {
        Intrinsics.checkNotNullParameter(view, "view");
        return n0(view) | m0(view, xOffset);
    }

    public int n() {
        HorizontalScrollView horizontalScrollView = this.horizontalScrollView;
        if (horizontalScrollView != null) {
            return horizontalScrollView.getScrollX();
        }
        return 0;
    }

    @Override // pj2.b
    public void o(@NotNull pj2.a<?> controller) {
        f fVar;
        Intrinsics.checkNotNullParameter(controller, "controller");
        f fVar2 = null;
        if (controller instanceof f) {
            fVar = (f) controller;
        } else {
            fVar = null;
        }
        if (fVar != null) {
            this.trackManager = fVar.getTrackManager();
            fVar2 = fVar;
        }
        this.dragDropScrollViewController = fVar2;
        R();
    }

    public final void o0() {
        if (!this.disableBottomLine) {
            BottomLineRelativeLayout bottomLineRelativeLayout = this.contentView;
            if (bottomLineRelativeLayout != null) {
                bottomLineRelativeLayout.setDrawBottomLine(true);
            }
            performHapticFeedback(0, 2);
        }
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

    @Override // com.tencent.mobileqq.qqvideoedit.editor.clipping.timeline.widget.dragdrop.n
    public void p(@NotNull o dragView) {
        Intrinsics.checkNotNullParameter(dragView, "dragView");
        e0(dragView, -1);
    }

    @Override // com.tencent.mobileqq.qqvideoedit.editor.clipping.timeline.widget.dragdrop.n
    public void q(@Nullable o dragView, boolean isSelected) {
        if (isSelected) {
            C(dragView);
        }
    }

    public final void r0(int positionOffset, @NotNull View dragView) {
        f fVar;
        TimelinePanelViewController panelViewController;
        Intrinsics.checkNotNullParameter(dragView, "dragView");
        BottomLineRelativeLayout bottomLineRelativeLayout = this.contentView;
        if (bottomLineRelativeLayout != null && positionOffset + dragView.getWidth() > bottomLineRelativeLayout.getWidth() - bottomLineRelativeLayout.getPaddingRight() && (fVar = this.dragDropScrollViewController) != null && (panelViewController = fVar.getPanelViewController()) != null) {
            panelViewController.m();
        }
    }

    @Override // com.tencent.mobileqq.qqvideoedit.editor.clipping.timeline.widget.dragdrop.n
    public void setAdsorbedPoint(@Nullable AttractPoint startPoint, @Nullable AttractPoint endPoint) {
        f fVar = this.dragDropScrollViewController;
        if (fVar != null) {
            fVar.t(startPoint, endPoint);
        }
    }

    public final void setAttractPointPosition$qqvideoedit_impl_release(@Nullable Set<Integer> points) {
        if (points != null && !points.isEmpty()) {
            this.attractPoints.clear();
            this.attractPoints.addAll(points);
        }
    }

    public final void setCanAddEmptyTrackOnDrop$qqvideoedit_impl_release(boolean canAddEmptyTrackOnDrop) {
        this.dragEventHandler.I(canAddEmptyTrackOnDrop);
    }

    public final void setContentView(@Nullable BottomLineRelativeLayout bottomLineRelativeLayout) {
        this.contentView = bottomLineRelativeLayout;
    }

    public final void setDisableBottomLine$qqvideoedit_impl_release(boolean disableBottomLine) {
        this.disableBottomLine = disableBottomLine;
    }

    public final void setNeedDrawTrackBackground$qqvideoedit_impl_release(boolean needDrawTrackBackground) {
        BottomLineRelativeLayout bottomLineRelativeLayout = this.contentView;
        if (bottomLineRelativeLayout != null) {
            bottomLineRelativeLayout.setNeedDrawTrackBackground(needDrawTrackBackground);
        }
    }

    public final void t0(@NotNull final View dragView, boolean available) {
        Intrinsics.checkNotNullParameter(dragView, "dragView");
        if (available) {
            dragView.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.tencent.mobileqq.qqvideoedit.editor.clipping.timeline.widget.dragdrop.b
                @Override // android.view.View.OnLongClickListener
                public final boolean onLongClick(View view) {
                    boolean s06;
                    s06 = DragDropScrollView.s0(DragDropScrollView.this, dragView, view);
                    return s06;
                }
            });
        } else {
            dragView.setOnLongClickListener(null);
        }
    }

    public final void u0(@NotNull DragViewModel dragViewModel) {
        Intrinsics.checkNotNullParameter(dragViewModel, "dragViewModel");
        x xVar = this.trackManager;
        if (xVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("trackManager");
            xVar = null;
        }
        xVar.g(dragViewModel);
    }

    public final void v0(@NotNull o dragView) {
        ViewParent viewParent;
        Object obj;
        Intrinsics.checkNotNullParameter(dragView, "dragView");
        View b16 = p.b(dragView);
        ViewGroup.MarginLayoutParams marginLayoutParams = null;
        if (b16 != null) {
            viewParent = b16.getParent();
        } else {
            viewParent = null;
        }
        if (viewParent == null) {
            return;
        }
        View b17 = p.b(dragView);
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

    @NotNull
    public final y y(int trackType) {
        x xVar = this.trackManager;
        if (xVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("trackManager");
            xVar = null;
        }
        return xVar.a(trackType);
    }

    public final void z(@NotNull View dragView, @NotNull PointF newPosition) {
        Intrinsics.checkNotNullParameter(dragView, "dragView");
        Intrinsics.checkNotNullParameter(newPosition, "newPosition");
        if (this.contentView != null) {
            if (newPosition.x < r0.getPaddingLeft()) {
                newPosition.x = r0.getPaddingLeft();
            }
            A(newPosition, dragView);
            if (newPosition.y < r0.getPaddingTop()) {
                newPosition.y = r0.getPaddingTop();
            }
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public DragDropScrollView(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    public /* synthetic */ DragDropScrollView(Context context, AttributeSet attributeSet, int i3, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i16 & 2) != 0 ? null : attributeSet, (i16 & 4) != 0 ? 0 : i3);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public DragDropScrollView(@NotNull Context context, @Nullable AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        Intrinsics.checkNotNullParameter(context, "context");
        this.contentTopMargin = com.tencent.videocut.utils.e.f384236a.a(10.0f);
        this.attractPoints = new HashSet<>();
        this.dragEventHandler = new DragEventHandler(this);
        this.flingHelper = new tj2.a();
        this.halfScreenWidth = (int) (K() * 0.5f);
        this.listener = new DynamicAnimation.OnAnimationUpdateListener() { // from class: com.tencent.mobileqq.qqvideoedit.editor.clipping.timeline.widget.dragdrop.c
            @Override // androidx.dynamicanimation.animation.DynamicAnimation.OnAnimationUpdateListener
            public final void onAnimationUpdate(DynamicAnimation dynamicAnimation, float f16, float f17) {
                DragDropScrollView.a0(DragDropScrollView.this, dynamicAnimation, f16, f17);
            }
        };
        U();
    }
}

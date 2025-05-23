package com.tencent.mobileqq.qqvideoedit.editor.clipping.timeline.widget.videotrack;

import android.content.Context;
import android.graphics.Point;
import android.os.Vibrator;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AlphaAnimation;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.RequiresApi;
import androidx.exifinterface.media.ExifInterface;
import androidx.lifecycle.MutableLiveData;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.ams.mosaic.jsengine.animation.basic.BasicAnimation;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qqvideoedit.editor.clipping.timeline.widget.dragdrop.DragModel;
import com.tencent.mobileqq.qqvideoedit.editor.clipping.timeline.widget.dragdrop.t;
import com.tencent.mobileqq.qqvideoedit.editor.clipping.timeline.widget.dragdrop.u;
import com.tencent.mobileqq.qqvideoedit.editor.clipping.timeline.widget.panel.TimelinePanelViewController;
import com.tencent.mobileqq.qqvideoedit.editor.clipping.timeline.widget.timeline.SliderView;
import com.tencent.mobileqq.qqvideoedit.editor.clipping.timeline.widget.videotrack.VideoTrackTimelineView;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import qj2.CommonConfig;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u00f0\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0002\b\t\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010!\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0019\n\u0002\u0018\u0002\n\u0002\b0\n\u0002\b\u0004\n\u0002\b\u0004\n\u0002\b\u0004\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007*\b\u00c5\u0001\u00c9\u0001\u00cd\u0001\u00d1\u0001\u0018\u0000 \u00db\u00012\u00020\u00012\u00020\u0002:\u0002\u00dc\u0001B-\b\u0007\u0012\u0007\u0010\u00d5\u0001\u001a\u000201\u0012\f\b\u0002\u0010\u00d7\u0001\u001a\u0005\u0018\u00010\u00d6\u0001\u0012\t\b\u0002\u0010\u00d8\u0001\u001a\u00020\t\u00a2\u0006\u0006\b\u00d9\u0001\u0010\u00da\u0001J\u0010\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0016J\u0006\u0010\b\u001a\u00020\u0007J\u000e\u0010\u000b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\tJ\u0006\u0010\f\u001a\u00020\u0007J\u0006\u0010\r\u001a\u00020\u0007J\u000e\u0010\u000f\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u000eJ\u000e\u0010\u0011\u001a\u00020\u00072\u0006\u0010\u0010\u001a\u00020\u000eJ\u0012\u0010\u0012\u001a\u00020\u00052\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003H\u0016J(\u0010\u0017\u001a\u00020\u00072\u0006\u0010\u0013\u001a\u00020\t2\u0006\u0010\u0014\u001a\u00020\t2\u0006\u0010\u0015\u001a\u00020\t2\u0006\u0010\u0016\u001a\u00020\tH\u0015J$\u0010\u001d\u001a\u00020\u00072\f\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00190\u00182\f\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u001b0\u0018H\u0007J\u000e\u0010\u001f\u001a\u00020\u00072\u0006\u0010\u001e\u001a\u00020\tJ\b\u0010!\u001a\u0004\u0018\u00010 J\u000e\u0010#\u001a\u00020\u000e2\u0006\u0010\"\u001a\u00020\tJ\u000e\u0010$\u001a\u00020\u000e2\u0006\u0010\"\u001a\u00020\tJ\u0010\u0010'\u001a\u00020\u00072\u0006\u0010&\u001a\u00020%H\u0007J\u0014\u0010*\u001a\u00020\u00072\n\u0010)\u001a\u0006\u0012\u0002\b\u00030(H\u0016J\u000e\u0010-\u001a\u00020\u00072\u0006\u0010,\u001a\u00020+J\u0010\u00100\u001a\u00020\u00072\b\u0010/\u001a\u0004\u0018\u00010.J\u0016\u00105\u001a\u00020\u00072\u0006\u00102\u001a\u0002012\u0006\u00104\u001a\u000203J\u0010\u00106\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\tH\u0002J\u0018\u00109\u001a\u00020\u00072\u0006\u00107\u001a\u0002032\u0006\u00108\u001a\u000203H\u0002J\u0018\u0010=\u001a\u00020 2\u0006\u0010:\u001a\u00020\t2\u0006\u0010<\u001a\u00020;H\u0003J\b\u0010>\u001a\u00020\u0007H\u0003J\b\u0010?\u001a\u00020\u0007H\u0002J(\u0010\u0014\u001a\u00020\u0007\"\b\b\u0000\u0010@*\u00020.2\f\u0010B\u001a\b\u0012\u0004\u0012\u00028\u00000A2\u0006\u0010C\u001a\u00020\tH\u0002J\b\u0010D\u001a\u00020\tH\u0002R\u0016\u0010F\u001a\u0002038\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bE\u0010$R\u0018\u0010)\u001a\u0004\u0018\u00010G8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bH\u0010IR\u001b\u0010M\u001a\u00020\u00018BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\bJ\u0010K\u001a\u0004\b\n\u0010LR\u001b\u0010R\u001a\u00020N8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\bO\u0010K\u001a\u0004\bP\u0010QR\u001a\u0010U\u001a\b\u0012\u0004\u0012\u00020 0A8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bS\u0010TR\u0016\u0010W\u001a\u00020\t8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bV\u00106R$\u0010_\u001a\u0004\u0018\u00010X8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bY\u0010Z\u001a\u0004\b[\u0010\\\"\u0004\b]\u0010^R\u0016\u0010c\u001a\u00020`8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\ba\u0010bR\"\u0010k\u001a\u00020d8\u0006@\u0006X\u0086.\u00a2\u0006\u0012\n\u0004\be\u0010f\u001a\u0004\bg\u0010h\"\u0004\bi\u0010jR\"\u0010n\u001a\u00020d8\u0006@\u0006X\u0086.\u00a2\u0006\u0012\n\u0004\bl\u0010f\u001a\u0004\be\u0010h\"\u0004\bm\u0010jR\u0016\u0010r\u001a\u00020o8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bp\u0010qR\u0016\u0010s\u001a\u00020o8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bP\u0010qR\u0016\u0010v\u001a\u00020t8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b6\u0010uR\u0016\u0010w\u001a\u00020\u000e8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b$\u0010lR\u0016\u0010y\u001a\u00020\u000e8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bx\u0010lR)\u0010\u0080\u0001\u001a\b\u0012\u0004\u0012\u0002030z8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b#\u0010{\u001a\u0004\b|\u0010}\"\u0004\b~\u0010\u007fR*\u0010\u0082\u0001\u001a\b\u0012\u0004\u0012\u0002030z8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0013\n\u0004\b!\u0010{\u001a\u0004\bl\u0010}\"\u0005\b\u0081\u0001\u0010\u007fR&\u0010\u0086\u0001\u001a\u00020\t8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0015\n\u0004\b\r\u00106\u001a\u0005\bx\u0010\u0083\u0001\"\u0006\b\u0084\u0001\u0010\u0085\u0001R(\u0010\u008c\u0001\u001a\u00020\u00058\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0017\n\u0005\b?\u0010\u0087\u0001\u001a\u0006\b\u0088\u0001\u0010\u0089\u0001\"\u0006\b\u008a\u0001\u0010\u008b\u0001R(\u0010\u008d\u0001\u001a\u00020\u00058\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0017\n\u0005\b\u001f\u0010\u0087\u0001\u001a\u0006\b\u008d\u0001\u0010\u0089\u0001\"\u0006\b\u008e\u0001\u0010\u008b\u0001R\u001a\u0010\u0090\u0001\u001a\u0004\u0018\u00010.8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0007\n\u0005\b\u001d\u0010\u008f\u0001R\u0019\u0010\u0092\u0001\u001a\u00020\u00058\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u0091\u0001\u0010\u0087\u0001R\u0018\u0010\u0093\u0001\u001a\u00020\u00058\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0007\n\u0005\b@\u0010\u0087\u0001R\u001b\u0010\u0096\u0001\u001a\u0005\u0018\u00010\u0094\u00018\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0007\n\u0005\b'\u0010\u0095\u0001R\u001a\u0010\u0097\u0001\u001a\u0004\u0018\u00010.8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0007\n\u0005\b9\u0010\u008f\u0001R'\u0010\u009a\u0001\u001a\u00020\t8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0016\n\u0004\b\f\u00106\u001a\u0006\b\u0098\u0001\u0010\u0083\u0001\"\u0006\b\u0099\u0001\u0010\u0085\u0001R(\u0010\u009e\u0001\u001a\u00020\t8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0017\n\u0005\b\u009b\u0001\u00106\u001a\u0006\b\u009c\u0001\u0010\u0083\u0001\"\u0006\b\u009d\u0001\u0010\u0085\u0001R,\u0010\u00a2\u0001\u001a\b\u0012\u0004\u0012\u0002030z8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0015\n\u0005\b\u009f\u0001\u0010{\u001a\u0005\b\u00a0\u0001\u0010}\"\u0005\b\u00a1\u0001\u0010\u007fR,\u0010\u00a6\u0001\u001a\b\u0012\u0004\u0012\u00020\u000e0z8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0015\n\u0005\b\u00a3\u0001\u0010{\u001a\u0005\b\u00a4\u0001\u0010}\"\u0005\b\u00a5\u0001\u0010\u007fR+\u0010\u00a9\u0001\u001a\b\u0012\u0004\u0012\u00020\u000e0z8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0014\n\u0005\b\u00a7\u0001\u0010{\u001a\u0004\bY\u0010}\"\u0005\b\u00a8\u0001\u0010\u007fR+\u0010\u00ac\u0001\u001a\b\u0012\u0004\u0012\u00020\u000e0z8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0014\n\u0005\b\u00aa\u0001\u0010{\u001a\u0004\bp\u0010}\"\u0005\b\u00ab\u0001\u0010\u007fR+\u0010\u00af\u0001\u001a\b\u0012\u0004\u0012\u00020\u00050z8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0014\n\u0005\b\u00ad\u0001\u0010{\u001a\u0004\ba\u0010}\"\u0005\b\u00ae\u0001\u0010\u007fR(\u0010\u00b3\u0001\u001a\u00020\t8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0017\n\u0005\b\u00b0\u0001\u00106\u001a\u0006\b\u00b1\u0001\u0010\u0083\u0001\"\u0006\b\u00b2\u0001\u0010\u0085\u0001R(\u0010\u00b7\u0001\u001a\u00020\t8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0017\n\u0005\b\u00b4\u0001\u00106\u001a\u0006\b\u00b5\u0001\u0010\u0083\u0001\"\u0006\b\u00b6\u0001\u0010\u0085\u0001R\u001b\u0010\u00ba\u0001\u001a\u0004\u0018\u00010 8\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u00b8\u0001\u0010\u00b9\u0001R\u001b\u0010\u00bc\u0001\u001a\u0004\u0018\u00010 8\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u00bb\u0001\u0010\u00b9\u0001R\u0018\u0010\u00be\u0001\u001a\u00020\u000e8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0007\n\u0005\b\u00bd\u0001\u0010lR(\u0010\u00c4\u0001\u001a\u0002038\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0017\n\u0005\b\u00bf\u0001\u0010$\u001a\u0006\b\u00c0\u0001\u0010\u00c1\u0001\"\u0006\b\u00c2\u0001\u0010\u00c3\u0001R\u0018\u0010\u00c8\u0001\u001a\u00030\u00c5\u00018\u0002X\u0082\u0004\u00a2\u0006\b\n\u0006\b\u00c6\u0001\u0010\u00c7\u0001R\u0018\u0010\u00cc\u0001\u001a\u00030\u00c9\u00018\u0002X\u0082\u0004\u00a2\u0006\b\n\u0006\b\u00ca\u0001\u0010\u00cb\u0001R\u0018\u0010\u00d0\u0001\u001a\u00030\u00cd\u00018\u0002X\u0082\u0004\u00a2\u0006\b\n\u0006\b\u00ce\u0001\u0010\u00cf\u0001R\u0018\u0010\u00d4\u0001\u001a\u00030\u00d1\u00018\u0002X\u0082\u0004\u00a2\u0006\b\n\u0006\b\u00d2\u0001\u0010\u00d3\u0001\u00a8\u0006\u00dd\u0001"}, d2 = {"Lcom/tencent/mobileqq/qqvideoedit/editor/clipping/timeline/widget/videotrack/VideoTrackContainerView;", "Landroid/widget/FrameLayout;", "Lpj2/b;", "Landroid/view/MotionEvent;", "ev", "", "dispatchTouchEvent", "", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "", HippyTKDListViewAdapter.X, "X", "W", "N", "", "setSliderBorderViewX", BasicAnimation.KeyPath.SCALE_X, "setSliderBorderScaleX", "onTouchEvent", "l", "t", "oldl", "oldt", "onScrollChanged", "", "Lcom/tencent/mobileqq/qqvideoedit/editor/clipping/timeline/widget/videotrack/p;", "clipModels", "", "transitionList", BdhLogUtil.LogTag.Tag_Req, "width", AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, "Lcom/tencent/mobileqq/qqvideoedit/editor/clipping/timeline/widget/videotrack/VideoTrackTimelineView;", "M", "index", "L", "J", "", "uuid", "U", "Lpj2/a;", "controller", "o", "Lcom/tencent/mobileqq/qqvideoedit/editor/clipping/timeline/reorder/a;", "listener", "setItemOnLongClickListener", "Landroid/view/View;", "view", "setHandleView", "Landroid/content/Context;", "context", "", "milliseconds", "Y", "I", "startTime", "endTime", "V", "viewId", "Lrj2/a;", "scaleCalculator", ReportConstant.COSTREPORT_PREFIX, "O", "P", "T", "", "source", "targetSize", "u", "d", "MIN_STICKER_DURATION", "Lcom/tencent/mobileqq/qqvideoedit/editor/clipping/timeline/widget/videotrack/n;", "e", "Lcom/tencent/mobileqq/qqvideoedit/editor/clipping/timeline/widget/videotrack/n;", "f", "Lkotlin/Lazy;", "()Landroid/widget/FrameLayout;", "frameRootView", "Landroid/widget/RelativeLayout;", tl.h.F, "H", "()Landroid/widget/RelativeLayout;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "i", "Ljava/util/List;", "videoTrackViews", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "cornerRadius", "Lcom/tencent/mobileqq/qqvideoedit/editor/clipping/timeline/widget/dragdrop/t;", BdhLogUtil.LogTag.Tag_Conn, "Lcom/tencent/mobileqq/qqvideoedit/editor/clipping/timeline/widget/dragdrop/t;", "getPositionChangedHandler", "()Lcom/tencent/mobileqq/qqvideoedit/editor/clipping/timeline/widget/dragdrop/t;", "setPositionChangedHandler", "(Lcom/tencent/mobileqq/qqvideoedit/editor/clipping/timeline/widget/dragdrop/t;)V", "positionChangedHandler", "Landroid/graphics/Point;", "D", "Landroid/graphics/Point;", "lastTouchPoint", "Lcom/tencent/mobileqq/qqvideoedit/editor/clipping/timeline/widget/timeline/SliderView;", "E", "Lcom/tencent/mobileqq/qqvideoedit/editor/clipping/timeline/widget/timeline/SliderView;", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "()Lcom/tencent/mobileqq/qqvideoedit/editor/clipping/timeline/widget/timeline/SliderView;", "setLeftFreedomSliderView", "(Lcom/tencent/mobileqq/qqvideoedit/editor/clipping/timeline/widget/timeline/SliderView;)V", "leftFreedomSliderView", UserInfo.SEX_FEMALE, "setRightFreedomSliderView", "rightFreedomSliderView", "Landroid/widget/ImageView;", "G", "Landroid/widget/ImageView;", "sliderTopBorderView", "sliderBottomBorderView", "Landroid/widget/TextView;", "Landroid/widget/TextView;", "sliderDurationView", "leftSliderViewRawX", "K", "rightSliderViewRawX", "Landroidx/lifecycle/MutableLiveData;", "Landroidx/lifecycle/MutableLiveData;", "B", "()Landroidx/lifecycle/MutableLiveData;", "setLeftSliderStartTime", "(Landroidx/lifecycle/MutableLiveData;)V", "leftSliderStartTime", "setRightSliderEndTime", "rightSliderEndTime", "()I", "setVideoTrackPadding", "(I)V", "videoTrackPadding", "Z", "getCanVibrate", "()Z", "setCanVibrate", "(Z)V", "canVibrate", "isClipTimeAdjust", "setClipTimeAdjust", "Landroid/view/View;", "handleView", ExifInterface.LATITUDE_SOUTH, "hasDownEvent", "hasUpEvent", "Landroid/widget/LinearLayout;", "Landroid/widget/LinearLayout;", "courseContainerView", "courseView", "getLastCourseContainerTouchDownX", "setLastCourseContainerTouchDownX", "lastCourseContainerTouchDownX", "a0", "getLastCourseContainerTranslationX", "setLastCourseContainerTranslationX", "lastCourseContainerTranslationX", "b0", "w", "setCourseViewTouchMoveTime", "courseViewTouchMoveTime", "c0", "v", "setCourseContainerViewTranslationX", "courseContainerViewTranslationX", "d0", "setLeftSliderViewMovingX", "leftSliderViewMovingX", "e0", "setRightSliderViewMovingX", "rightSliderViewMovingX", "f0", "setMovingCourseView", "movingCourseView", "g0", QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, "setLastDragViewModelStartPosition", "lastDragViewModelStartPosition", "h0", "y", "setLastDragViewModelEndPosition", "lastDragViewModelEndPosition", "i0", "Lcom/tencent/mobileqq/qqvideoedit/editor/clipping/timeline/widget/videotrack/VideoTrackTimelineView;", "backgroundView", "j0", "videoTrackTimelineView", "k0", "lastPerSpace", "l0", "getFixedMaxDuration", "()J", "setFixedMaxDuration", "(J)V", "fixedMaxDuration", "com/tencent/mobileqq/qqvideoedit/editor/clipping/timeline/widget/videotrack/VideoTrackContainerView$e", "m0", "Lcom/tencent/mobileqq/qqvideoedit/editor/clipping/timeline/widget/videotrack/VideoTrackContainerView$e;", "timeLineViewListener", "com/tencent/mobileqq/qqvideoedit/editor/clipping/timeline/widget/videotrack/VideoTrackContainerView$d", "n0", "Lcom/tencent/mobileqq/qqvideoedit/editor/clipping/timeline/widget/videotrack/VideoTrackContainerView$d;", "selectListener", "com/tencent/mobileqq/qqvideoedit/editor/clipping/timeline/widget/videotrack/VideoTrackContainerView$b", "o0", "Lcom/tencent/mobileqq/qqvideoedit/editor/clipping/timeline/widget/videotrack/VideoTrackContainerView$b;", "leftSliderListener", "com/tencent/mobileqq/qqvideoedit/editor/clipping/timeline/widget/videotrack/VideoTrackContainerView$c", "p0", "Lcom/tencent/mobileqq/qqvideoedit/editor/clipping/timeline/widget/videotrack/VideoTrackContainerView$c;", "rightSliderListener", "mContext", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "defStyle", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "q0", "a", "qqvideoedit_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes17.dex */
public final class VideoTrackContainerView extends FrameLayout implements pj2.b {

    /* renamed from: C, reason: from kotlin metadata */
    @Nullable
    private t positionChangedHandler;

    /* renamed from: D, reason: from kotlin metadata */
    @NotNull
    private Point lastTouchPoint;

    /* renamed from: E, reason: from kotlin metadata */
    public SliderView leftFreedomSliderView;

    /* renamed from: F, reason: from kotlin metadata */
    public SliderView rightFreedomSliderView;

    /* renamed from: G, reason: from kotlin metadata */
    private ImageView sliderTopBorderView;

    /* renamed from: H, reason: from kotlin metadata */
    private ImageView sliderBottomBorderView;

    /* renamed from: I, reason: from kotlin metadata */
    private TextView sliderDurationView;

    /* renamed from: J, reason: from kotlin metadata */
    private float leftSliderViewRawX;

    /* renamed from: K, reason: from kotlin metadata */
    private float rightSliderViewRawX;

    /* renamed from: L, reason: from kotlin metadata */
    @NotNull
    private MutableLiveData<Long> leftSliderStartTime;

    /* renamed from: M, reason: from kotlin metadata */
    @NotNull
    private MutableLiveData<Long> rightSliderEndTime;

    /* renamed from: N, reason: from kotlin metadata */
    private int videoTrackPadding;

    /* renamed from: P, reason: from kotlin metadata */
    private boolean canVibrate;

    /* renamed from: Q, reason: from kotlin metadata */
    private boolean isClipTimeAdjust;

    /* renamed from: R, reason: from kotlin metadata */
    @Nullable
    private View handleView;

    /* renamed from: S, reason: from kotlin metadata */
    private boolean hasDownEvent;

    /* renamed from: T, reason: from kotlin metadata */
    private boolean hasUpEvent;

    /* renamed from: U, reason: from kotlin metadata */
    @Nullable
    private LinearLayout courseContainerView;

    /* renamed from: V, reason: from kotlin metadata */
    @Nullable
    private View courseView;

    /* renamed from: W, reason: from kotlin metadata */
    private int lastCourseContainerTouchDownX;

    /* renamed from: a0, reason: collision with root package name and from kotlin metadata */
    private int lastCourseContainerTranslationX;

    /* renamed from: b0, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private MutableLiveData<Long> courseViewTouchMoveTime;

    /* renamed from: c0, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private MutableLiveData<Float> courseContainerViewTranslationX;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private long MIN_STICKER_DURATION;

    /* renamed from: d0, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private MutableLiveData<Float> leftSliderViewMovingX;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private n controller;

    /* renamed from: e0, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private MutableLiveData<Float> rightSliderViewMovingX;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy frameRootView;

    /* renamed from: f0, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private MutableLiveData<Boolean> movingCourseView;

    /* renamed from: g0, reason: collision with root package name and from kotlin metadata */
    private int lastDragViewModelStartPosition;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy rootView;

    /* renamed from: h0, reason: collision with root package name and from kotlin metadata */
    private int lastDragViewModelEndPosition;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final List<VideoTrackTimelineView> videoTrackViews;

    /* renamed from: i0, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private VideoTrackTimelineView backgroundView;

    /* renamed from: j0, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private VideoTrackTimelineView videoTrackTimelineView;

    /* renamed from: k0, reason: collision with root package name and from kotlin metadata */
    private float lastPerSpace;

    /* renamed from: l0, reason: collision with root package name and from kotlin metadata */
    private long fixedMaxDuration;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private int cornerRadius;

    /* renamed from: m0, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final e timeLineViewListener;

    /* renamed from: n0, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final d selectListener;

    /* renamed from: o0, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final b leftSliderListener;

    /* renamed from: p0, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final c rightSliderListener;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0002H\u0016J\b\u0010\b\u001a\u00020\u0004H\u0016\u00a8\u0006\t"}, d2 = {"com/tencent/mobileqq/qqvideoedit/editor/clipping/timeline/widget/videotrack/VideoTrackContainerView$b", "Luj2/a;", "", "rawX", "", "b", "moveX", "c", "a", "qqvideoedit_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes17.dex */
    public static final class b implements uj2.a {
        b() {
        }

        @Override // uj2.a
        public void a() {
            Long l3;
            VideoTrackContainerView.this.getParent().requestDisallowInterceptTouchEvent(false);
            VideoTrackContainerView.this.setClipTimeAdjust(true);
            MutableLiveData<Long> B = VideoTrackContainerView.this.B();
            n nVar = VideoTrackContainerView.this.controller;
            if (nVar != null) {
                l3 = Long.valueOf(nVar.E(VideoTrackContainerView.this.A().getX() - VideoTrackContainerView.this.L(0)));
            } else {
                l3 = null;
            }
            B.postValue(l3);
            VideoTrackContainerView.this.setCanVibrate(true);
        }

        @Override // uj2.a
        public void b(float rawX) {
            VideoTrackContainerView.this.getParent().requestDisallowInterceptTouchEvent(true);
            VideoTrackContainerView.this.leftSliderViewRawX = rawX;
            VideoTrackContainerView.this.setCanVibrate(true);
        }

        @Override // uj2.a
        public void c(float moveX) {
            long j3;
            long j16;
            float x16 = (VideoTrackContainerView.this.A().getX() + moveX) - VideoTrackContainerView.this.leftSliderViewRawX;
            n nVar = VideoTrackContainerView.this.controller;
            if (nVar != null) {
                j3 = nVar.E((VideoTrackContainerView.this.E().getX() - x16) - VideoTrackContainerView.this.A().getWidth());
            } else {
                j3 = 0;
            }
            if (j3 >= VideoTrackContainerView.this.MIN_STICKER_DURATION && x16 >= VideoTrackContainerView.this.L(0) + (VideoTrackContainerView.this.getVideoTrackPadding() * 2)) {
                if ((VideoTrackContainerView.this.leftSliderViewRawX - (com.tencent.videocut.utils.o.g() / 2)) * (moveX - (com.tencent.videocut.utils.o.g() / 2)) < 0.0f) {
                    VideoTrackContainerView videoTrackContainerView = VideoTrackContainerView.this;
                    Context context = videoTrackContainerView.getContext();
                    Intrinsics.checkNotNullExpressionValue(context, "context");
                    videoTrackContainerView.Y(context, 100L);
                }
                VideoTrackContainerView.this.A().setX(x16);
                VideoTrackContainerView.this.leftSliderViewRawX = moveX;
                VideoTrackContainerView.this.setSliderBorderViewX(x16);
                VideoTrackContainerView videoTrackContainerView2 = VideoTrackContainerView.this;
                videoTrackContainerView2.setSliderBorderScaleX(((videoTrackContainerView2.E().getX() - VideoTrackContainerView.this.A().getX()) - VideoTrackContainerView.this.A().getWidth()) / VideoTrackContainerView.this.getVideoTrackPadding());
                VideoTrackContainerView videoTrackContainerView3 = VideoTrackContainerView.this;
                n nVar2 = videoTrackContainerView3.controller;
                if (nVar2 != null) {
                    j16 = nVar2.E(VideoTrackContainerView.this.A().getX() - VideoTrackContainerView.this.L(0));
                } else {
                    j16 = 0;
                }
                Long value = VideoTrackContainerView.this.F().getValue();
                if (value == null) {
                    value = 0L;
                }
                videoTrackContainerView3.V(j16, value.longValue());
                VideoTrackContainerView.this.setCanVibrate(true);
                return;
            }
            if (j3 < VideoTrackContainerView.this.MIN_STICKER_DURATION) {
                VideoTrackContainerView videoTrackContainerView4 = VideoTrackContainerView.this;
                videoTrackContainerView4.V(0L, videoTrackContainerView4.MIN_STICKER_DURATION);
            }
            VideoTrackContainerView videoTrackContainerView5 = VideoTrackContainerView.this;
            Context context2 = videoTrackContainerView5.getContext();
            Intrinsics.checkNotNullExpressionValue(context2, "context");
            videoTrackContainerView5.Y(context2, 100L);
            VideoTrackContainerView.this.setCanVibrate(false);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0002H\u0016J\b\u0010\b\u001a\u00020\u0004H\u0016\u00a8\u0006\t"}, d2 = {"com/tencent/mobileqq/qqvideoedit/editor/clipping/timeline/widget/videotrack/VideoTrackContainerView$c", "Luj2/a;", "", "rawX", "", "b", "moveX", "c", "a", "qqvideoedit_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes17.dex */
    public static final class c implements uj2.a {
        c() {
        }

        @Override // uj2.a
        public void a() {
            Long l3;
            VideoTrackContainerView.this.getParent().requestDisallowInterceptTouchEvent(false);
            VideoTrackContainerView.this.setClipTimeAdjust(true);
            SliderView E = VideoTrackContainerView.this.E();
            E.setX(E.getX() - VideoTrackContainerView.this.E().getWidth());
            MutableLiveData<Long> F = VideoTrackContainerView.this.F();
            n nVar = VideoTrackContainerView.this.controller;
            if (nVar != null) {
                l3 = Long.valueOf(nVar.E(VideoTrackContainerView.this.E().getX() - VideoTrackContainerView.this.L(0)));
            } else {
                l3 = null;
            }
            F.postValue(l3);
            VideoTrackContainerView.this.setCanVibrate(true);
        }

        @Override // uj2.a
        public void b(float rawX) {
            VideoTrackContainerView.this.getParent().requestDisallowInterceptTouchEvent(true);
            VideoTrackContainerView.this.rightSliderViewRawX = rawX;
            VideoTrackContainerView.this.setCanVibrate(true);
        }

        @Override // uj2.a
        public void c(float moveX) {
            long j3;
            float x16 = (VideoTrackContainerView.this.E().getX() + moveX) - VideoTrackContainerView.this.rightSliderViewRawX;
            n nVar = VideoTrackContainerView.this.controller;
            long j16 = 0;
            if (nVar != null) {
                j3 = nVar.E((x16 - VideoTrackContainerView.this.A().getX()) - VideoTrackContainerView.this.A().getWidth());
            } else {
                j3 = 0;
            }
            if (j3 >= VideoTrackContainerView.this.MIN_STICKER_DURATION) {
                float width = VideoTrackContainerView.this.E().getWidth() + x16;
                VideoTrackContainerView videoTrackContainerView = VideoTrackContainerView.this;
                if (width <= videoTrackContainerView.J(videoTrackContainerView.videoTrackViews.size() - 1) - (VideoTrackContainerView.this.getVideoTrackPadding() * 2)) {
                    if ((VideoTrackContainerView.this.rightSliderViewRawX - (com.tencent.videocut.utils.o.g() / 2)) * (moveX - (com.tencent.videocut.utils.o.g() / 2)) < 0.0f) {
                        VideoTrackContainerView videoTrackContainerView2 = VideoTrackContainerView.this;
                        Context context = videoTrackContainerView2.getContext();
                        Intrinsics.checkNotNullExpressionValue(context, "context");
                        videoTrackContainerView2.Y(context, 100L);
                    }
                    VideoTrackContainerView.this.E().setX(x16);
                    VideoTrackContainerView.this.rightSliderViewRawX = moveX;
                    VideoTrackContainerView videoTrackContainerView3 = VideoTrackContainerView.this;
                    videoTrackContainerView3.setSliderBorderScaleX(((videoTrackContainerView3.E().getX() - VideoTrackContainerView.this.A().getX()) - VideoTrackContainerView.this.A().getWidth()) / VideoTrackContainerView.this.getVideoTrackPadding());
                    VideoTrackContainerView videoTrackContainerView4 = VideoTrackContainerView.this;
                    Long value = videoTrackContainerView4.B().getValue();
                    if (value == null) {
                        value = 0L;
                    }
                    long longValue = value.longValue();
                    n nVar2 = VideoTrackContainerView.this.controller;
                    if (nVar2 != null) {
                        j16 = nVar2.E(VideoTrackContainerView.this.E().getX() - VideoTrackContainerView.this.L(0));
                    }
                    videoTrackContainerView4.V(longValue, j16);
                    VideoTrackContainerView.this.setCanVibrate(true);
                    return;
                }
            }
            if (j3 < VideoTrackContainerView.this.MIN_STICKER_DURATION) {
                VideoTrackContainerView videoTrackContainerView5 = VideoTrackContainerView.this;
                videoTrackContainerView5.V(0L, videoTrackContainerView5.MIN_STICKER_DURATION);
            }
            VideoTrackContainerView videoTrackContainerView6 = VideoTrackContainerView.this;
            Context context2 = videoTrackContainerView6.getContext();
            Intrinsics.checkNotNullExpressionValue(context2, "context");
            videoTrackContainerView6.Y(context2, 100L);
            VideoTrackContainerView.this.setCanVibrate(false);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000+\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J0\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\tH\u0017\u00a8\u0006\r"}, d2 = {"com/tencent/mobileqq/qqvideoedit/editor/clipping/timeline/widget/videotrack/VideoTrackContainerView$d", "Lcom/tencent/mobileqq/qqvideoedit/editor/clipping/timeline/widget/videotrack/VideoTrackTimelineView$b;", "", "id", "", "selectedStatus", "", "isClickStartClipRegion", "isClickEndClipRegion", "Lcom/tencent/mobileqq/qqvideoedit/editor/clipping/timeline/widget/videotrack/VideoTrackTimelineView;", "view", "", "a", "qqvideoedit_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes17.dex */
    public static final class d implements VideoTrackTimelineView.b {
        d() {
        }

        @Override // com.tencent.mobileqq.qqvideoedit.editor.clipping.timeline.widget.videotrack.VideoTrackTimelineView.b
        @RequiresApi(17)
        public void a(@NotNull String id5, int selectedStatus, boolean isClickStartClipRegion, boolean isClickEndClipRegion, @NotNull VideoTrackTimelineView view) {
            Object orNull;
            VideoTrackTimelineView videoTrackTimelineView;
            Object orNull2;
            Intrinsics.checkNotNullParameter(id5, "id");
            Intrinsics.checkNotNullParameter(view, "view");
            if (!isClickStartClipRegion && !isClickEndClipRegion) {
                n nVar = VideoTrackContainerView.this.controller;
                if (nVar != null) {
                    nVar.C(id5, selectedStatus);
                    return;
                }
                return;
            }
            int indexOf = VideoTrackContainerView.this.videoTrackViews.indexOf(view);
            if (isClickStartClipRegion) {
                orNull2 = CollectionsKt___CollectionsKt.getOrNull(VideoTrackContainerView.this.videoTrackViews, indexOf - 1);
                videoTrackTimelineView = (VideoTrackTimelineView) orNull2;
            } else {
                orNull = CollectionsKt___CollectionsKt.getOrNull(VideoTrackContainerView.this.videoTrackViews, indexOf + 1);
                videoTrackTimelineView = (VideoTrackTimelineView) orNull;
            }
            if (videoTrackTimelineView == null) {
                n nVar2 = VideoTrackContainerView.this.controller;
                if (nVar2 != null) {
                    nVar2.C(id5, selectedStatus);
                    return;
                }
                return;
            }
            videoTrackTimelineView.L1(false);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000+\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0018\u0010\n\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0016J\u0018\u0010\f\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\bH\u0017J\u0018\u0010\u0010\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\b2\u0006\u0010\u000f\u001a\u00020\u000eH\u0016\u00a8\u0006\u0011"}, d2 = {"com/tencent/mobileqq/qqvideoedit/editor/clipping/timeline/widget/videotrack/VideoTrackContainerView$e", "Lcom/tencent/mobileqq/qqvideoedit/editor/clipping/timeline/widget/dragdrop/u;", "Lcom/tencent/mobileqq/qqvideoedit/editor/clipping/timeline/widget/dragdrop/h;", "dragModel", "", "c", "", "moveX", "", "left", "a", "isLeft", "d", "selected", "Landroid/view/View;", "view", "b", "qqvideoedit_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes17.dex */
    public static final class e implements u {
        e() {
        }

        @Override // com.tencent.mobileqq.qqvideoedit.editor.clipping.timeline.widget.dragdrop.u
        public void a(float moveX, boolean left) {
            if (left) {
                int lastDragViewModelStartPosition = VideoTrackContainerView.this.getLastDragViewModelStartPosition();
                VideoTrackTimelineView videoTrackTimelineView = VideoTrackContainerView.this.videoTrackTimelineView;
                Intrinsics.checkNotNull(videoTrackTimelineView);
                if (lastDragViewModelStartPosition != videoTrackTimelineView.getDragViewModel().getStartPosition()) {
                    VideoTrackContainerView videoTrackContainerView = VideoTrackContainerView.this;
                    VideoTrackTimelineView videoTrackTimelineView2 = videoTrackContainerView.videoTrackTimelineView;
                    Intrinsics.checkNotNull(videoTrackTimelineView2);
                    videoTrackContainerView.setLastDragViewModelStartPosition(videoTrackTimelineView2.getDragViewModel().getStartPosition());
                    VideoTrackContainerView.this.C().postValue(Float.valueOf(moveX));
                    return;
                }
                return;
            }
            int lastDragViewModelEndPosition = VideoTrackContainerView.this.getLastDragViewModelEndPosition();
            VideoTrackTimelineView videoTrackTimelineView3 = VideoTrackContainerView.this.videoTrackTimelineView;
            Intrinsics.checkNotNull(videoTrackTimelineView3);
            if (lastDragViewModelEndPosition != videoTrackTimelineView3.getDragViewModel().getEndPosition()) {
                VideoTrackContainerView videoTrackContainerView2 = VideoTrackContainerView.this;
                VideoTrackTimelineView videoTrackTimelineView4 = videoTrackContainerView2.videoTrackTimelineView;
                Intrinsics.checkNotNull(videoTrackTimelineView4);
                videoTrackContainerView2.setLastDragViewModelEndPosition(videoTrackTimelineView4.getDragViewModel().getEndPosition());
                VideoTrackContainerView.this.G().postValue(Float.valueOf(moveX));
            }
        }

        @Override // com.tencent.mobileqq.qqvideoedit.editor.clipping.timeline.widget.dragdrop.u
        public void b(boolean selected, @NotNull View view) {
            Intrinsics.checkNotNullParameter(view, "view");
        }

        @Override // com.tencent.mobileqq.qqvideoedit.editor.clipping.timeline.widget.dragdrop.u
        public void c(@NotNull DragModel dragModel) {
            Intrinsics.checkNotNullParameter(dragModel, "dragModel");
        }

        @Override // com.tencent.mobileqq.qqvideoedit.editor.clipping.timeline.widget.dragdrop.u
        @RequiresApi(17)
        public void d(@NotNull DragModel dragModel, boolean isLeft) {
            Intrinsics.checkNotNullParameter(dragModel, "dragModel");
            n nVar = VideoTrackContainerView.this.controller;
            if (nVar != null) {
                nVar.z(dragModel.getId(), isLeft);
            }
            VideoTrackContainerView.this.O();
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public VideoTrackContainerView(@NotNull Context mContext) {
        this(mContext, null, 0, 6, null);
        Intrinsics.checkNotNullParameter(mContext, "mContext");
    }

    private final RelativeLayout H() {
        return (RelativeLayout) this.rootView.getValue();
    }

    private final int I(int x16) {
        float f16 = x16;
        float L = L(0);
        float J = J(0) - (com.tencent.videocut.utils.e.f384236a.a(16.0f) * 2);
        if (f16 < L) {
            f16 = L;
        } else if (f16 > J) {
            f16 = J;
        }
        return (int) f16;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @RequiresApi(17)
    public final void O() {
        Iterator<T> it = this.videoTrackViews.iterator();
        while (it.hasNext()) {
            ((VideoTrackTimelineView) it.next()).M1();
        }
        VideoTrackTimelineView videoTrackTimelineView = this.backgroundView;
        if (videoTrackTimelineView != null) {
            videoTrackTimelineView.M1();
        }
    }

    private final void P() {
        Q(u());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean S(VideoTrackContainerView this$0, View view, MotionEvent motionEvent) {
        Long l3;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (motionEvent.getAction() == 2) {
            if (this$0.lastCourseContainerTouchDownX == 0) {
                int[] iArr = new int[2];
                View view2 = this$0.courseView;
                if (view2 != null) {
                    view2.getLocationOnScreen(iArr);
                }
                this$0.lastCourseContainerTouchDownX = iArr[0];
                LinearLayout linearLayout = this$0.courseContainerView;
                Intrinsics.checkNotNull(linearLayout);
                this$0.lastCourseContainerTranslationX = (int) linearLayout.getTranslationX();
            }
            int rawX = ((int) motionEvent.getRawX()) - this$0.lastCourseContainerTouchDownX;
            if (Math.abs(rawX) > 10) {
                Boolean value = this$0.movingCourseView.getValue();
                Intrinsics.checkNotNull(value);
                if (!value.booleanValue()) {
                    this$0.movingCourseView.postValue(Boolean.TRUE);
                }
                this$0.X(this$0.lastCourseContainerTranslationX + rawX);
                int I = this$0.I(this$0.lastCourseContainerTranslationX + rawX);
                MutableLiveData<Long> mutableLiveData = this$0.courseViewTouchMoveTime;
                n nVar = this$0.controller;
                if (nVar != null) {
                    l3 = Long.valueOf(nVar.E(I - this$0.L(0)));
                } else {
                    l3 = null;
                }
                mutableLiveData.postValue(l3);
                MutableLiveData<Float> mutableLiveData2 = this$0.courseContainerViewTranslationX;
                LinearLayout linearLayout2 = this$0.courseContainerView;
                Intrinsics.checkNotNull(linearLayout2);
                mutableLiveData2.postValue(Float.valueOf(linearLayout2.getTranslationX()));
            }
        } else if (motionEvent.getAction() == 1 || motionEvent.getAction() == 3) {
            this$0.movingCourseView.postValue(Boolean.FALSE);
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void T(VideoTrackContainerView this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        VideoTrackTimelineView videoTrackTimelineView = this$0.videoTrackTimelineView;
        Intrinsics.checkNotNull(videoTrackTimelineView);
        videoTrackTimelineView.D1();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void V(long startTime, long endTime) {
        TextView textView = this.sliderDurationView;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("sliderDurationView");
            textView = null;
        }
        textView.setText(Math.round((endTime - startTime) / 1000000.0d) + ReportConstant.COSTREPORT_PREFIX);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void e(VideoTrackContainerView this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        n nVar = this$0.controller;
        if (nVar != null) {
            nVar.j().a(new com.tencent.mobileqq.qqvideoedit.editor.clipping.timeline.widget.panel.event.k());
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean r(VideoTrackContainerView this$0, View view, MotionEvent motionEvent) {
        Long l3;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (motionEvent.getAction() == 0) {
            this$0.lastCourseContainerTouchDownX = (int) motionEvent.getRawX();
            LinearLayout linearLayout = this$0.courseContainerView;
            Intrinsics.checkNotNull(linearLayout);
            this$0.lastCourseContainerTranslationX = (int) linearLayout.getTranslationX();
            this$0.movingCourseView.postValue(Boolean.TRUE);
            return true;
        }
        if (motionEvent.getAction() == 2) {
            int rawX = ((int) motionEvent.getRawX()) - this$0.lastCourseContainerTouchDownX;
            if (Math.abs(rawX) > 10) {
                this$0.X(this$0.lastCourseContainerTranslationX + rawX);
                int I = this$0.I(this$0.lastCourseContainerTranslationX + rawX);
                MutableLiveData<Long> mutableLiveData = this$0.courseViewTouchMoveTime;
                n nVar = this$0.controller;
                if (nVar != null) {
                    l3 = Long.valueOf(nVar.E(I - this$0.L(0)));
                } else {
                    l3 = null;
                }
                mutableLiveData.postValue(l3);
                MutableLiveData<Float> mutableLiveData2 = this$0.courseContainerViewTranslationX;
                LinearLayout linearLayout2 = this$0.courseContainerView;
                Intrinsics.checkNotNull(linearLayout2);
                mutableLiveData2.postValue(Float.valueOf(linearLayout2.getTranslationX()));
                return true;
            }
            return true;
        }
        this$0.movingCourseView.postValue(Boolean.FALSE);
        return true;
    }

    @RequiresApi(17)
    private final VideoTrackTimelineView s(int viewId, rj2.a scaleCalculator) {
        com.tencent.mobileqq.qqvideoedit.editor.clipping.timeline.widget.videotrack.d thumbnailProvider;
        DragModel dragModel = new DragModel(VideoTrackTimelineView.class, 0L, 0L, 0L, 0, String.valueOf(viewId), 30, null);
        Context context = getContext();
        Intrinsics.checkNotNullExpressionValue(context, "context");
        VideoTrackTimelineView videoTrackTimelineView = new VideoTrackTimelineView(context, null, 0, dragModel, 6, null);
        n nVar = this.controller;
        if (nVar != null) {
            videoTrackTimelineView.setSingleBitmapWidth(com.tencent.videocut.utils.e.f384236a.a(nVar.g().getVideoTrackConfig().getSingleShowThumbWidth()));
        }
        videoTrackTimelineView.setId(viewId);
        n nVar2 = this.controller;
        if (nVar2 != null && (thumbnailProvider = nVar2.getThumbnailProvider()) != null) {
            videoTrackTimelineView.setThumbnailProvider(thumbnailProvider);
        }
        videoTrackTimelineView.setCornerRadius(this.cornerRadius);
        videoTrackTimelineView.setScaleCalculator(scaleCalculator);
        videoTrackTimelineView.u1(dragModel);
        videoTrackTimelineView.setValueChangeListener(this.positionChangedHandler);
        videoTrackTimelineView.setTimelineViewListener(this.timeLineViewListener);
        return videoTrackTimelineView;
    }

    private final <T extends View> void t(List<T> source, int targetSize) {
        boolean z16;
        List<T> list;
        List<View> list2;
        if (source.size() > targetSize && targetSize >= 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            list = source;
        } else {
            list = null;
        }
        if (list != null) {
            list2 = CollectionsKt___CollectionsKt.toList(list.subList(targetSize, source.size()));
            for (View view : list2) {
                source.remove(view);
                H().removeView(view);
            }
        }
    }

    private final int u() {
        n nVar = this.controller;
        if (nVar != null) {
            return nVar.i();
        }
        return 0;
    }

    private final FrameLayout x() {
        return (FrameLayout) this.frameRootView.getValue();
    }

    @NotNull
    public final SliderView A() {
        SliderView sliderView = this.leftFreedomSliderView;
        if (sliderView != null) {
            return sliderView;
        }
        Intrinsics.throwUninitializedPropertyAccessException("leftFreedomSliderView");
        return null;
    }

    @NotNull
    public final MutableLiveData<Long> B() {
        return this.leftSliderStartTime;
    }

    @NotNull
    public final MutableLiveData<Float> C() {
        return this.leftSliderViewMovingX;
    }

    @NotNull
    public final MutableLiveData<Boolean> D() {
        return this.movingCourseView;
    }

    @NotNull
    public final SliderView E() {
        SliderView sliderView = this.rightFreedomSliderView;
        if (sliderView != null) {
            return sliderView;
        }
        Intrinsics.throwUninitializedPropertyAccessException("rightFreedomSliderView");
        return null;
    }

    @NotNull
    public final MutableLiveData<Long> F() {
        return this.rightSliderEndTime;
    }

    @NotNull
    public final MutableLiveData<Float> G() {
        return this.rightSliderViewMovingX;
    }

    public final float J(int index) {
        if (index >= 0 && index < this.videoTrackViews.size()) {
            return this.videoTrackViews.get(index).getX() + this.videoTrackViews.get(index).getWidth();
        }
        return 0.0f;
    }

    /* renamed from: K, reason: from getter */
    public final int getVideoTrackPadding() {
        return this.videoTrackPadding;
    }

    public final float L(int index) {
        if (index >= 0 && index < this.videoTrackViews.size()) {
            return this.videoTrackViews.get(index).getX();
        }
        if (this.leftFreedomSliderView != null) {
            return (com.tencent.videocut.utils.o.g() / 2) - A().getWidth();
        }
        return com.tencent.videocut.utils.o.g() / 2;
    }

    @Nullable
    /* renamed from: M, reason: from getter */
    public final VideoTrackTimelineView getVideoTrackTimelineView() {
        return this.videoTrackTimelineView;
    }

    public final void N() {
        LinearLayout linearLayout = this.courseContainerView;
        if (linearLayout == null) {
            return;
        }
        Intrinsics.checkNotNull(linearLayout);
        linearLayout.setVisibility(4);
    }

    public final void Q(int width) {
        ViewGroup.LayoutParams layoutParams = H().getLayoutParams();
        layoutParams.width = width;
        H().setLayoutParams(layoutParams);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:40:0x00f0  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x0128  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x012d  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x0136  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x0145 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:53:0x00f7  */
    @RequiresApi(17)
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void R(@NotNull List<VideoTrackModel> clipModels, @NotNull List<Object> transitionList) {
        rj2.a l3;
        Object obj;
        TimelinePanelViewController panelViewController;
        byte b16;
        VideoTrackTimelineView s16;
        byte b17;
        byte b18;
        int lastIndex;
        n nVar;
        int lastIndex2;
        VideoTrackTimelineView videoTrackTimelineView;
        int lastIndex3;
        boolean z16;
        CommonConfig commonConfig;
        Intrinsics.checkNotNullParameter(clipModels, "clipModels");
        Intrinsics.checkNotNullParameter(transitionList, "transitionList");
        n nVar2 = this.controller;
        if (nVar2 != null && (l3 = nVar2.l()) != null) {
            t(this.videoTrackViews, clipModels.size());
            Iterator<T> it = clipModels.iterator();
            int i3 = 0;
            while (true) {
                obj = null;
                CommonConfig commonConfig2 = null;
                if (!it.hasNext()) {
                    break;
                }
                Object next = it.next();
                int i16 = i3 + 1;
                if (i3 < 0) {
                    CollectionsKt__CollectionsKt.throwIndexOverflow();
                }
                VideoTrackModel videoTrackModel = (VideoTrackModel) next;
                boolean z17 = true;
                if (this.backgroundView == null) {
                    VideoTrackTimelineView s17 = s(R.id.f97415kb, l3);
                    this.backgroundView = s17;
                    Intrinsics.checkNotNull(s17);
                    s17.setFixedLayout(true);
                    VideoTrackTimelineView videoTrackTimelineView2 = this.backgroundView;
                    Intrinsics.checkNotNull(videoTrackTimelineView2);
                    videoTrackTimelineView2.setBlackMaskViewVisibility(0);
                    VideoTrackTimelineView videoTrackTimelineView3 = this.backgroundView;
                    Intrinsics.checkNotNull(videoTrackTimelineView3);
                    videoTrackTimelineView3.f1(false);
                    H().addView(this.backgroundView);
                }
                VideoTrackTimelineView videoTrackTimelineView4 = this.backgroundView;
                Intrinsics.checkNotNull(videoTrackTimelineView4);
                videoTrackTimelineView4.setSliderViewVisibility(8);
                if (this.lastPerSpace == l3.getPerSpace()) {
                    b16 = true;
                } else {
                    b16 = false;
                }
                if (b16 == false && (videoTrackTimelineView = this.backgroundView) != null) {
                    lastIndex3 = CollectionsKt__CollectionsKt.getLastIndex(clipModels);
                    if (i3 == lastIndex3) {
                        z16 = true;
                    } else {
                        z16 = false;
                    }
                    n nVar3 = this.controller;
                    if (nVar3 != null) {
                        commonConfig = nVar3.g();
                    } else {
                        commonConfig = null;
                    }
                    videoTrackTimelineView.N1(videoTrackModel, z16, commonConfig);
                }
                this.lastPerSpace = l3.getPerSpace();
                List<VideoTrackTimelineView> list = this.videoTrackViews;
                if (i3 >= 0) {
                    lastIndex2 = CollectionsKt__CollectionsKt.getLastIndex(list);
                    if (i3 <= lastIndex2) {
                        s16 = list.get(i3);
                        b17 = false;
                        VideoTrackTimelineView videoTrackTimelineView5 = s16;
                        this.videoTrackTimelineView = videoTrackTimelineView5;
                        if (b17 == false && this.fixedMaxDuration != 0) {
                            b18 = true;
                        } else {
                            b18 = false;
                        }
                        if (b18 != false) {
                            Intrinsics.checkNotNull(videoTrackTimelineView5);
                            videoTrackTimelineView5.setSliderViewVisibility(0);
                        } else {
                            Intrinsics.checkNotNull(videoTrackTimelineView5);
                            videoTrackTimelineView5.setSliderViewVisibility(4);
                        }
                        VideoTrackTimelineView videoTrackTimelineView6 = this.videoTrackTimelineView;
                        Intrinsics.checkNotNull(videoTrackTimelineView6);
                        videoTrackTimelineView6.setFixedMaxDuration(this.fixedMaxDuration);
                        VideoTrackTimelineView videoTrackTimelineView7 = this.videoTrackTimelineView;
                        Intrinsics.checkNotNull(videoTrackTimelineView7);
                        videoTrackTimelineView7.setSourceDurationUs(videoTrackModel.getSourceData().getTimeData().getSourceDurationUs());
                        VideoTrackTimelineView videoTrackTimelineView8 = this.videoTrackTimelineView;
                        Intrinsics.checkNotNull(videoTrackTimelineView8);
                        lastIndex = CollectionsKt__CollectionsKt.getLastIndex(clipModels);
                        if (i3 != lastIndex) {
                            z17 = false;
                        }
                        nVar = this.controller;
                        if (nVar != null) {
                            commonConfig2 = nVar.g();
                        }
                        videoTrackTimelineView8.N1(videoTrackModel, z17, commonConfig2);
                        if (b18 == false) {
                            VideoTrackTimelineView videoTrackTimelineView9 = this.videoTrackTimelineView;
                            Intrinsics.checkNotNull(videoTrackTimelineView9);
                            videoTrackTimelineView9.postDelayed(new Runnable() { // from class: com.tencent.mobileqq.qqvideoedit.editor.clipping.timeline.widget.videotrack.l
                                @Override // java.lang.Runnable
                                public final void run() {
                                    VideoTrackContainerView.T(VideoTrackContainerView.this);
                                }
                            }, 10L);
                        }
                        i3 = i16;
                    }
                }
                s16 = s(View.generateViewId(), l3);
                Intrinsics.checkNotNull(s16);
                s16.f1(false);
                ViewGroup contentView = s16.getContentView();
                if (contentView != null) {
                    contentView.setOnTouchListener(new View.OnTouchListener() { // from class: com.tencent.mobileqq.qqvideoedit.editor.clipping.timeline.widget.videotrack.k
                        @Override // android.view.View.OnTouchListener
                        public final boolean onTouch(View view, MotionEvent motionEvent) {
                            boolean S;
                            S = VideoTrackContainerView.S(VideoTrackContainerView.this, view, motionEvent);
                            return S;
                        }
                    });
                }
                H().addView(s16);
                this.videoTrackViews.add(s16);
                b17 = true;
                VideoTrackTimelineView videoTrackTimelineView52 = s16;
                this.videoTrackTimelineView = videoTrackTimelineView52;
                if (b17 == false) {
                }
                b18 = false;
                if (b18 != false) {
                }
                VideoTrackTimelineView videoTrackTimelineView62 = this.videoTrackTimelineView;
                Intrinsics.checkNotNull(videoTrackTimelineView62);
                videoTrackTimelineView62.setFixedMaxDuration(this.fixedMaxDuration);
                VideoTrackTimelineView videoTrackTimelineView72 = this.videoTrackTimelineView;
                Intrinsics.checkNotNull(videoTrackTimelineView72);
                videoTrackTimelineView72.setSourceDurationUs(videoTrackModel.getSourceData().getTimeData().getSourceDurationUs());
                VideoTrackTimelineView videoTrackTimelineView82 = this.videoTrackTimelineView;
                Intrinsics.checkNotNull(videoTrackTimelineView82);
                lastIndex = CollectionsKt__CollectionsKt.getLastIndex(clipModels);
                if (i3 != lastIndex) {
                }
                nVar = this.controller;
                if (nVar != null) {
                }
                videoTrackTimelineView82.N1(videoTrackModel, z17, commonConfig2);
                if (b18 == false) {
                }
                i3 = i16;
            }
            Iterator<T> it5 = this.videoTrackViews.iterator();
            while (true) {
                if (!it5.hasNext()) {
                    break;
                }
                Object next2 = it5.next();
                if (((VideoTrackTimelineView) next2).isSelected()) {
                    obj = next2;
                    break;
                }
            }
            VideoTrackTimelineView videoTrackTimelineView10 = (VideoTrackTimelineView) obj;
            if (videoTrackTimelineView10 != null) {
                videoTrackTimelineView10.bringToFront();
            }
            P();
            n nVar4 = this.controller;
            if (nVar4 != null && (panelViewController = nVar4.getPanelViewController()) != null) {
                panelViewController.k();
            }
        }
    }

    @RequiresApi(17)
    public final void U(@NotNull String uuid) {
        Intrinsics.checkNotNullParameter(uuid, "uuid");
        List<VideoTrackTimelineView> list = this.videoTrackViews;
        ArrayList arrayList = new ArrayList();
        for (Object obj : list) {
            if (Intrinsics.areEqual(((VideoTrackTimelineView) obj).K1(), uuid)) {
                arrayList.add(obj);
            }
        }
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            ((VideoTrackTimelineView) it.next()).M1();
        }
        VideoTrackTimelineView videoTrackTimelineView = this.backgroundView;
        if (videoTrackTimelineView != null) {
            videoTrackTimelineView.M1();
        }
    }

    public final void W() {
        if (this.courseContainerView == null) {
            return;
        }
        AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
        alphaAnimation.setDuration(100L);
        LinearLayout linearLayout = this.courseContainerView;
        Intrinsics.checkNotNull(linearLayout);
        linearLayout.startAnimation(alphaAnimation);
        LinearLayout linearLayout2 = this.courseContainerView;
        Intrinsics.checkNotNull(linearLayout2);
        linearLayout2.setVisibility(0);
    }

    public final void X(int x16) {
        LinearLayout linearLayout = this.courseContainerView;
        if (linearLayout == null) {
            return;
        }
        Intrinsics.checkNotNull(linearLayout);
        linearLayout.setTranslationX(I(x16));
    }

    public final void Y(@NotNull Context context, long milliseconds) {
        Intrinsics.checkNotNullParameter(context, "context");
        Object systemService = context.getSystemService("vibrator");
        Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.os.Vibrator");
        Vibrator vibrator = (Vibrator) systemService;
        if (vibrator.hasVibrator() && this.canVibrate) {
            vibrator.vibrate(milliseconds);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(@NotNull MotionEvent ev5) {
        boolean z16;
        Intrinsics.checkNotNullParameter(ev5, "ev");
        this.lastTouchPoint = new Point((int) ev5.getRawX(), (int) ev5.getRawY());
        if (ev5.getActionMasked() != 1 && ev5.getActionMasked() != 3) {
            z16 = false;
        } else {
            z16 = true;
        }
        this.hasUpEvent = z16;
        View view = this.handleView;
        if (view != null) {
            if (!this.hasDownEvent) {
                MotionEvent obtain = MotionEvent.obtain(ev5);
                obtain.setAction(0);
                View view2 = this.handleView;
                if (view2 != null) {
                    view2.dispatchTouchEvent(obtain);
                }
                this.hasDownEvent = true;
            }
            return view.dispatchTouchEvent(ev5);
        }
        return super.dispatchTouchEvent(ev5);
    }

    @Override // pj2.b
    public void o(@NotNull pj2.a<?> controller) {
        n nVar;
        Intrinsics.checkNotNullParameter(controller, "controller");
        if (controller instanceof n) {
            nVar = (n) controller;
        } else {
            nVar = null;
        }
        this.controller = nVar;
    }

    @Override // android.view.View
    @RequiresApi(17)
    protected void onScrollChanged(int l3, int t16, int oldl, int oldt) {
        n nVar = this.controller;
        if (nVar != null) {
            nVar.y(l3);
        }
        O();
    }

    @Override // android.view.View
    public boolean onTouchEvent(@Nullable MotionEvent ev5) {
        n nVar;
        tj2.a h16;
        boolean onTouchEvent = super.onTouchEvent(ev5);
        if (onTouchEvent) {
            boolean z16 = false;
            if (ev5 != null && ev5.getAction() == 2) {
                z16 = true;
            }
            if (z16 && (nVar = this.controller) != null && (h16 = nVar.h()) != null) {
                h16.c();
            }
        }
        return onTouchEvent;
    }

    public final void q() {
        LinearLayout linearLayout = new LinearLayout(getContext());
        this.courseContainerView = linearLayout;
        Intrinsics.checkNotNull(linearLayout);
        linearLayout.setGravity(17);
        com.tencent.videocut.utils.e eVar = com.tencent.videocut.utils.e.f384236a;
        ViewGroup.MarginLayoutParams marginLayoutParams = new ViewGroup.MarginLayoutParams(eVar.a(12.0f), eVar.a(47.0f));
        marginLayoutParams.leftMargin = eVar.a(16.0f) - eVar.a(4.0f);
        x().addView(this.courseContainerView, marginLayoutParams);
        View view = new View(getContext());
        view.setBackgroundResource(R.drawable.f162675m34);
        this.courseView = view;
        ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(eVar.a(4.0f), eVar.a(47.0f));
        LinearLayout linearLayout2 = this.courseContainerView;
        Intrinsics.checkNotNull(linearLayout2);
        linearLayout2.addView(this.courseView, layoutParams);
        LinearLayout linearLayout3 = this.courseContainerView;
        Intrinsics.checkNotNull(linearLayout3);
        linearLayout3.setOnTouchListener(new View.OnTouchListener() { // from class: com.tencent.mobileqq.qqvideoedit.editor.clipping.timeline.widget.videotrack.m
            @Override // android.view.View.OnTouchListener
            public final boolean onTouch(View view2, MotionEvent motionEvent) {
                boolean r16;
                r16 = VideoTrackContainerView.r(VideoTrackContainerView.this, view2, motionEvent);
                return r16;
            }
        });
    }

    public final void setCanVibrate(boolean z16) {
        this.canVibrate = z16;
    }

    public final void setClipTimeAdjust(boolean z16) {
        this.isClipTimeAdjust = z16;
    }

    public final void setCourseContainerViewTranslationX(@NotNull MutableLiveData<Float> mutableLiveData) {
        Intrinsics.checkNotNullParameter(mutableLiveData, "<set-?>");
        this.courseContainerViewTranslationX = mutableLiveData;
    }

    public final void setCourseViewTouchMoveTime(@NotNull MutableLiveData<Long> mutableLiveData) {
        Intrinsics.checkNotNullParameter(mutableLiveData, "<set-?>");
        this.courseViewTouchMoveTime = mutableLiveData;
    }

    public final void setFixedMaxDuration(long j3) {
        this.fixedMaxDuration = j3;
    }

    public final void setHandleView(@Nullable View view) {
        this.handleView = view;
        this.hasDownEvent = false;
    }

    public final void setItemOnLongClickListener(@NotNull com.tencent.mobileqq.qqvideoedit.editor.clipping.timeline.reorder.a listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
    }

    public final void setLastCourseContainerTouchDownX(int i3) {
        this.lastCourseContainerTouchDownX = i3;
    }

    public final void setLastCourseContainerTranslationX(int i3) {
        this.lastCourseContainerTranslationX = i3;
    }

    public final void setLastDragViewModelEndPosition(int i3) {
        this.lastDragViewModelEndPosition = i3;
    }

    public final void setLastDragViewModelStartPosition(int i3) {
        this.lastDragViewModelStartPosition = i3;
    }

    public final void setLeftFreedomSliderView(@NotNull SliderView sliderView) {
        Intrinsics.checkNotNullParameter(sliderView, "<set-?>");
        this.leftFreedomSliderView = sliderView;
    }

    public final void setLeftSliderStartTime(@NotNull MutableLiveData<Long> mutableLiveData) {
        Intrinsics.checkNotNullParameter(mutableLiveData, "<set-?>");
        this.leftSliderStartTime = mutableLiveData;
    }

    public final void setLeftSliderViewMovingX(@NotNull MutableLiveData<Float> mutableLiveData) {
        Intrinsics.checkNotNullParameter(mutableLiveData, "<set-?>");
        this.leftSliderViewMovingX = mutableLiveData;
    }

    public final void setMovingCourseView(@NotNull MutableLiveData<Boolean> mutableLiveData) {
        Intrinsics.checkNotNullParameter(mutableLiveData, "<set-?>");
        this.movingCourseView = mutableLiveData;
    }

    public final void setPositionChangedHandler(@Nullable t tVar) {
        this.positionChangedHandler = tVar;
    }

    public final void setRightFreedomSliderView(@NotNull SliderView sliderView) {
        Intrinsics.checkNotNullParameter(sliderView, "<set-?>");
        this.rightFreedomSliderView = sliderView;
    }

    public final void setRightSliderEndTime(@NotNull MutableLiveData<Long> mutableLiveData) {
        Intrinsics.checkNotNullParameter(mutableLiveData, "<set-?>");
        this.rightSliderEndTime = mutableLiveData;
    }

    public final void setRightSliderViewMovingX(@NotNull MutableLiveData<Float> mutableLiveData) {
        Intrinsics.checkNotNullParameter(mutableLiveData, "<set-?>");
        this.rightSliderViewMovingX = mutableLiveData;
    }

    public final void setSliderBorderScaleX(float scaleX) {
        ImageView imageView = this.sliderTopBorderView;
        ImageView imageView2 = null;
        if (imageView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("sliderTopBorderView");
            imageView = null;
        }
        imageView.setScaleX(scaleX);
        ImageView imageView3 = this.sliderBottomBorderView;
        if (imageView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("sliderBottomBorderView");
        } else {
            imageView2 = imageView3;
        }
        imageView2.setScaleX(scaleX);
    }

    public final void setSliderBorderViewX(float x16) {
        ImageView imageView = this.sliderTopBorderView;
        TextView textView = null;
        if (imageView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("sliderTopBorderView");
            imageView = null;
        }
        imageView.setX(A().getWidth() + x16);
        ImageView imageView2 = this.sliderBottomBorderView;
        if (imageView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("sliderBottomBorderView");
            imageView2 = null;
        }
        imageView2.setX(A().getWidth() + x16);
        TextView textView2 = this.sliderDurationView;
        if (textView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("sliderDurationView");
        } else {
            textView = textView2;
        }
        textView.setX(x16 + A().getWidth() + ViewUtils.dpToPx(5.0f));
    }

    public final void setVideoTrackPadding(int i3) {
        this.videoTrackPadding = i3;
    }

    @NotNull
    public final MutableLiveData<Float> v() {
        return this.courseContainerViewTranslationX;
    }

    @NotNull
    public final MutableLiveData<Long> w() {
        return this.courseViewTouchMoveTime;
    }

    /* renamed from: y, reason: from getter */
    public final int getLastDragViewModelEndPosition() {
        return this.lastDragViewModelEndPosition;
    }

    /* renamed from: z, reason: from getter */
    public final int getLastDragViewModelStartPosition() {
        return this.lastDragViewModelStartPosition;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public VideoTrackContainerView(@NotNull Context mContext, @Nullable AttributeSet attributeSet) {
        this(mContext, attributeSet, 0, 4, null);
        Intrinsics.checkNotNullParameter(mContext, "mContext");
    }

    public /* synthetic */ VideoTrackContainerView(Context context, AttributeSet attributeSet, int i3, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i16 & 2) != 0 ? null : attributeSet, (i16 & 4) != 0 ? 0 : i3);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public VideoTrackContainerView(@NotNull Context mContext, @Nullable AttributeSet attributeSet, int i3) {
        super(mContext, attributeSet, i3);
        Lazy lazy;
        Lazy lazy2;
        Intrinsics.checkNotNullParameter(mContext, "mContext");
        this.MIN_STICKER_DURATION = 1000000L;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<FrameLayout>() { // from class: com.tencent.mobileqq.qqvideoedit.editor.clipping.timeline.widget.videotrack.VideoTrackContainerView$frameRootView$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final FrameLayout invoke() {
                return new FrameLayout(VideoTrackContainerView.this.getContext());
            }
        });
        this.frameRootView = lazy;
        lazy2 = LazyKt__LazyJVMKt.lazy(new Function0<RelativeLayout>() { // from class: com.tencent.mobileqq.qqvideoedit.editor.clipping.timeline.widget.videotrack.VideoTrackContainerView$rootView$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final RelativeLayout invoke() {
                return new RelativeLayout(VideoTrackContainerView.this.getContext());
            }
        });
        this.rootView = lazy2;
        this.videoTrackViews = new ArrayList();
        this.cornerRadius = -1;
        this.lastTouchPoint = new Point();
        this.leftSliderStartTime = new MutableLiveData<>();
        this.rightSliderEndTime = new MutableLiveData<>();
        this.videoTrackPadding = getResources().getDimensionPixelOffset(R.dimen.de9);
        this.courseViewTouchMoveTime = new MutableLiveData<>();
        this.courseContainerViewTranslationX = new MutableLiveData<>();
        this.leftSliderViewMovingX = new MutableLiveData<>();
        this.rightSliderViewMovingX = new MutableLiveData<>();
        this.movingCourseView = new MutableLiveData<>(Boolean.FALSE);
        x().addView(H(), new FrameLayout.LayoutParams(-1, -1));
        addView(x(), new FrameLayout.LayoutParams(-1, -1));
        setOverScrollMode(2);
        H().setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.qqvideoedit.editor.clipping.timeline.widget.videotrack.j
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                VideoTrackContainerView.e(VideoTrackContainerView.this, view);
            }
        });
        q();
        this.timeLineViewListener = new e();
        this.selectListener = new d();
        this.leftSliderListener = new b();
        this.rightSliderListener = new c();
    }
}

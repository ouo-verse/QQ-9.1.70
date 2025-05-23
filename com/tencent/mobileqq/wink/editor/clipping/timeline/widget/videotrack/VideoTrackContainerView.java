package com.tencent.mobileqq.wink.editor.clipping.timeline.widget.videotrack;

import android.content.Context;
import android.graphics.Point;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.IdRes;
import androidx.annotation.MainThread;
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
import com.tencent.mobileqq.shortvideo.util.ScreenUtil;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.wink.editor.clipping.timeline.widget.dragdrop.DragModel;
import com.tencent.mobileqq.wink.editor.clipping.timeline.widget.dragdrop.t;
import com.tencent.mobileqq.wink.editor.clipping.timeline.widget.dragdrop.u;
import com.tencent.mobileqq.wink.editor.clipping.timeline.widget.panel.TimelinePanelViewController;
import com.tencent.mobileqq.wink.editor.clipping.timeline.widget.panel.event.PanelEventHandler;
import com.tencent.mobileqq.wink.editor.clipping.timeline.widget.panel.scroll.FlingHelper;
import com.tencent.mobileqq.wink.editor.clipping.timeline.widget.timeline.SliderView;
import com.tencent.mobileqq.wink.editor.clipping.timeline.widget.videotrack.VideoTrackTimelineView;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.videocut.utils.s;
import g63.CommonConfig;
import g63.LayoutConfig;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0086\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0002\b\u0014\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\b\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u001b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u001f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u001c\n\u0002\b\u0002\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\b\u0004\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007*\u000e\u00c9\u0001\u00cb\u0001\u00ce\u0001\u00d1\u0001\u00d4\u0001\u00d7\u0001\u00db\u0001\b\u0016\u0018\u0000 \u00e8\u00012\u00020\u00012\u00020\u0002:\u0002\u00e9\u0001B8\b\u0007\u0012\b\u0010\u00e2\u0001\u001a\u00030\u00e1\u0001\u0012\f\b\u0002\u0010\u00e4\u0001\u001a\u0005\u0018\u00010\u00e3\u0001\u0012\t\b\u0002\u0010\u00e5\u0001\u001a\u00020\u0012\u0012\b\b\u0002\u0010f\u001a\u00020\u0012\u00a2\u0006\u0006\b\u00e6\u0001\u0010\u00e7\u0001J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0003H\u0002J\u0010\u0010\u000b\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\bH\u0002J\b\u0010\f\u001a\u00020\u0006H\u0002J\b\u0010\r\u001a\u00020\u0006H\u0002J(\u0010\u0014\u001a\u00020\u0006\"\b\b\u0000\u0010\u000f*\u00020\u000e2\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00028\u00000\u00102\u0006\u0010\u0013\u001a\u00020\u0012H\u0002J\b\u0010\u0015\u001a\u00020\u0012H\u0002J\u0010\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u0016\u001a\u00020\u0012H\u0003J\b\u0010\u0019\u001a\u00020\u0012H\u0002J\u0010\u0010\u001a\u001a\u00020\u00172\u0006\u0010\u0016\u001a\u00020\u0012H\u0003J\u0010\u0010\u001c\u001a\u00020\u001b2\u0006\u0010\u0016\u001a\u00020\u0012H\u0003J\u0010\u0010\u001e\u001a\u00020\u001d2\u0006\u0010\u0016\u001a\u00020\u0012H\u0003J\u0010\u0010\"\u001a\u00020!2\u0006\u0010 \u001a\u00020\u001fH\u0016J\u0006\u0010#\u001a\u00020\u0006J\u000e\u0010%\u001a\u00020\u00062\u0006\u0010$\u001a\u00020\u0003J\u000e\u0010(\u001a\u00020\u00062\u0006\u0010'\u001a\u00020&J\u000e\u0010*\u001a\u00020\u00062\u0006\u0010)\u001a\u00020&J\u0016\u0010,\u001a\u00020\u00062\u0006\u0010+\u001a\u00020\u00032\u0006\u0010$\u001a\u00020\u0003J\u001e\u0010.\u001a\u00020\u00062\u0006\u0010+\u001a\u00020\u00032\u0006\u0010$\u001a\u00020\u00032\u0006\u0010-\u001a\u00020!J\u0016\u0010/\u001a\u00020\u00062\u0006\u0010+\u001a\u00020\u00032\u0006\u0010$\u001a\u00020\u0003J\u000e\u00100\u001a\u00020\u00062\u0006\u0010\u0014\u001a\u00020&J\u000e\u00102\u001a\u00020\u00062\u0006\u00101\u001a\u00020&J\u0010\u00104\u001a\u00020\u00062\u0006\u00103\u001a\u00020\u0012H\u0016J\u0010\u00105\u001a\u00020!2\u0006\u0010 \u001a\u00020\u001fH\u0016J(\u00109\u001a\u00020\u00062\u0006\u00106\u001a\u00020\u00122\u0006\u0010\u0018\u001a\u00020\u00122\u0006\u00107\u001a\u00020\u00122\u0006\u00108\u001a\u00020\u0012H\u0014J\u0006\u0010:\u001a\u00020\u0006J\"\u0010@\u001a\u00020\u00062\f\u0010=\u001a\b\u0012\u0004\u0012\u00020<0;2\f\u0010?\u001a\b\u0012\u0004\u0012\u00020>0;J\u000e\u0010A\u001a\u00020\u00062\u0006\u0010'\u001a\u00020\u0012J\u000e\u0010\u000f\u001a\u00020&2\u0006\u0010B\u001a\u00020\u0012J\u0006\u0010C\u001a\u00020&J\u0006\u0010D\u001a\u00020&J\u0006\u0010E\u001a\u00020&J\u000e\u0010F\u001a\u00020&2\u0006\u0010B\u001a\u00020\u0012J\u000e\u0010I\u001a\u00020\u00062\u0006\u0010H\u001a\u00020GJ\u0014\u0010L\u001a\u00020\u00062\n\u0010K\u001a\u0006\u0012\u0002\b\u00030JH\u0016J\u000e\u0010O\u001a\u00020\u00062\u0006\u0010N\u001a\u00020MJ\u000e\u0010Q\u001a\u00020\u00062\u0006\u0010N\u001a\u00020PJ\u0010\u0010S\u001a\u00020\u00062\b\u0010R\u001a\u0004\u0018\u00010\u000eJ\u0006\u0010T\u001a\u00020\u0006J\u0006\u0010U\u001a\u00020!J\f\u0010V\u001a\b\u0012\u0004\u0012\u00020\n0;J\u0006\u0010W\u001a\u00020\u0006J\u000e\u0010Y\u001a\u00020\u00062\u0006\u0010X\u001a\u00020\u0012J\u0006\u0010Z\u001a\u00020!J\u0006\u0010[\u001a\u00020\u0006J\u0006\u0010\\\u001a\u00020\u0012J\u0006\u0010]\u001a\u00020\u0012J\u000e\u0010_\u001a\u00020\u00062\u0006\u0010^\u001a\u00020\u0012R\"\u0010f\u001a\u00020\u00128\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b`\u0010a\u001a\u0004\bb\u0010c\"\u0004\bd\u0010eR\u0016\u0010h\u001a\u00020\u00038\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bg\u0010]R\u0016\u0010k\u001a\u00020&8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bi\u0010jR\u0018\u0010K\u001a\u0004\u0018\u00010l8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bm\u0010nR\u001b\u0010t\u001a\u00020o8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\bp\u0010q\u001a\u0004\br\u0010sR\u001b\u0010y\u001a\u00020u8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\bv\u0010q\u001a\u0004\bw\u0010xR\u001a\u0010|\u001a\b\u0012\u0004\u0012\u00020\n0\u00108\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bz\u0010{R\u0016\u0010}\u001a\u00020\u00128\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\\\u0010aR*\u0010\u0085\u0001\u001a\u0004\u0018\u00010~8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0017\n\u0005\b\u007f\u0010\u0080\u0001\u001a\u0006\b\u0081\u0001\u0010\u0082\u0001\"\u0006\b\u0083\u0001\u0010\u0084\u0001R\u001a\u0010\u0087\u0001\u001a\u0004\u0018\u00010M8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0007\n\u0005\bj\u0010\u0086\u0001R\u001b\u0010\u008a\u0001\u001a\u0004\u0018\u00010P8\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u0088\u0001\u0010\u0089\u0001R\u0019\u0010\u008d\u0001\u001a\u00030\u008b\u00018\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0007\n\u0005\b\u0019\u0010\u008c\u0001R'\u0010\u0092\u0001\u001a\u00020\u00178\u0006@\u0006X\u0086.\u00a2\u0006\u0016\n\u0005\ba\u0010\u008e\u0001\u001a\u0005\bz\u0010\u008f\u0001\"\u0006\b\u0090\u0001\u0010\u0091\u0001R'\u0010\u0094\u0001\u001a\u00020\u00178\u0006@\u0006X\u0086.\u00a2\u0006\u0016\n\u0005\b]\u0010\u008e\u0001\u001a\u0005\ba\u0010\u008f\u0001\"\u0006\b\u0093\u0001\u0010\u0091\u0001R)\u0010\u009b\u0001\u001a\u00020\u000e8\u0006@\u0006X\u0086.\u00a2\u0006\u0018\n\u0006\b\u0095\u0001\u0010\u0096\u0001\u001a\u0006\b\u0097\u0001\u0010\u0098\u0001\"\u0006\b\u0099\u0001\u0010\u009a\u0001R)\u0010\u009f\u0001\u001a\u00020\u000e8\u0006@\u0006X\u0086.\u00a2\u0006\u0018\n\u0006\b\u009c\u0001\u0010\u0096\u0001\u001a\u0006\b\u009d\u0001\u0010\u0098\u0001\"\u0006\b\u009e\u0001\u0010\u009a\u0001R\u0019\u0010\u00a2\u0001\u001a\u00020\u001b8\u0002@\u0002X\u0082.\u00a2\u0006\b\n\u0006\b\u00a0\u0001\u0010\u00a1\u0001R\u0018\u0010\u00a3\u0001\u001a\u00020\u001b8\u0002@\u0002X\u0082.\u00a2\u0006\u0007\n\u0005\bw\u0010\u00a1\u0001R\u0018\u0010\u00a5\u0001\u001a\u00020\u001d8\u0002@\u0002X\u0082.\u00a2\u0006\u0007\n\u0005\bD\u0010\u00a4\u0001R\u0017\u0010\u00a6\u0001\u001a\u00020&8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bC\u0010jR\u0017\u0010\u00a7\u0001\u001a\u00020&8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bF\u0010jR\u0018\u0010\u00a9\u0001\u001a\u00020\u00128\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0007\n\u0005\b\u00a8\u0001\u0010aR\u0017\u0010\u00aa\u0001\u001a\u00020\u00128\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000f\u0010aR;\u0010\u00b1\u0001\u001a\u0016\u0012\u0011\u0012\u000f\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020!0\u00ac\u00010\u00ab\u00018\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0016\n\u0005\bV\u0010\u00ad\u0001\u001a\u0005\bj\u0010\u00ae\u0001\"\u0006\b\u00af\u0001\u0010\u00b0\u0001R<\u0010\u00b3\u0001\u001a\u0016\u0012\u0011\u0012\u000f\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020!0\u00ac\u00010\u00ab\u00018\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0017\n\u0005\bU\u0010\u00ad\u0001\u001a\u0006\b\u0095\u0001\u0010\u00ae\u0001\"\u0006\b\u00b2\u0001\u0010\u00b0\u0001R&\u0010\u00b6\u0001\u001a\u00020\u00128\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0015\n\u0005\b\u00b4\u0001\u0010a\u001a\u0005\b\u00a8\u0001\u0010c\"\u0005\b\u00b5\u0001\u0010eR.\u0010\u00b8\u0001\u001a\t\u0012\u0004\u0012\u00020\u00030\u00ab\u00018\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0016\n\u0005\b[\u0010\u00ad\u0001\u001a\u0005\b\u007f\u0010\u00ae\u0001\"\u0006\b\u00b7\u0001\u0010\u00b0\u0001R<\u0010\u00ba\u0001\u001a\u0016\u0012\u0011\u0012\u000f\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u00ac\u00010\u00ab\u00018\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0017\n\u0005\b\f\u0010\u00ad\u0001\u001a\u0006\b\u009c\u0001\u0010\u00ae\u0001\"\u0006\b\u00b9\u0001\u0010\u00b0\u0001R'\u0010\u00bf\u0001\u001a\u00020!8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0016\n\u0004\b\r\u0010.\u001a\u0006\b\u00bb\u0001\u0010\u00bc\u0001\"\u0006\b\u00bd\u0001\u0010\u00be\u0001R'\u0010\u00c1\u0001\u001a\u00020!8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0016\n\u0004\bA\u0010.\u001a\u0006\b\u00b4\u0001\u0010\u00bc\u0001\"\u0006\b\u00c0\u0001\u0010\u00be\u0001R'\u0010\u00c2\u0001\u001a\u00020!8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0016\n\u0004\b/\u0010.\u001a\u0006\b\u00c2\u0001\u0010\u00bc\u0001\"\u0006\b\u00c3\u0001\u0010\u00be\u0001R\u001a\u0010\u00c4\u0001\u001a\u0004\u0018\u00010\u000e8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0007\n\u0005\b@\u0010\u0096\u0001R\u0018\u0010\u00c6\u0001\u001a\u00020!8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0007\n\u0005\b\u00c5\u0001\u0010.R\u0017\u0010\u00c7\u0001\u001a\u00020!8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bI\u0010.R\u0017\u0010\u00c8\u0001\u001a\u00020!8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b(\u0010.R\u0016\u0010N\u001a\u00030\u00c9\u00018\u0002X\u0082\u0004\u00a2\u0006\u0007\n\u0005\b*\u0010\u00ca\u0001R\u0017\u0010\u00cd\u0001\u001a\u00030\u00cb\u00018\u0002X\u0082\u0004\u00a2\u0006\u0007\n\u0005\b\u0007\u0010\u00cc\u0001R\u0017\u0010\u00d0\u0001\u001a\u00030\u00ce\u00018\u0002X\u0082\u0004\u00a2\u0006\u0007\n\u0005\bT\u0010\u00cf\u0001R\u0017\u0010\u00d3\u0001\u001a\u00030\u00d1\u00018\u0002X\u0082\u0004\u00a2\u0006\u0007\n\u0005\bY\u0010\u00d2\u0001R\u0017\u0010\u00d6\u0001\u001a\u00030\u00d4\u00018\u0002X\u0082\u0004\u00a2\u0006\u0007\n\u0005\bW\u0010\u00d5\u0001R\u0018\u0010\u00da\u0001\u001a\u00030\u00d7\u00018\u0002X\u0082\u0004\u00a2\u0006\b\n\u0006\b\u00d8\u0001\u0010\u00d9\u0001R\u0018\u0010\u00de\u0001\u001a\u00030\u00db\u00018\u0002X\u0082\u0004\u00a2\u0006\b\n\u0006\b\u00dc\u0001\u0010\u00dd\u0001R\u0016\u0010\u00df\u0001\u001a\u00020\u00128CX\u0082\u0004\u00a2\u0006\u0007\u001a\u0005\b\u0088\u0001\u0010cR\u0016\u0010\u00e0\u0001\u001a\u00020\u00128CX\u0082\u0004\u00a2\u0006\u0007\u001a\u0005\b\u00a0\u0001\u0010c\u00a8\u0006\u00ea\u0001"}, d2 = {"Lcom/tencent/mobileqq/wink/editor/clipping/timeline/widget/videotrack/VideoTrackContainerView;", "Landroid/widget/HorizontalScrollView;", "Lf63/b;", "", "startTime", "endTime", "", "k0", "Li63/b;", "scaleCalculator", "Lcom/tencent/mobileqq/wink/editor/clipping/timeline/widget/videotrack/VideoTrackTimelineView;", "r", "b0", "c0", "Landroid/view/View;", "T", "", "source", "", "targetSize", HippyTKDListViewAdapter.X, QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, "id", "Lcom/tencent/mobileqq/wink/editor/clipping/timeline/widget/timeline/SliderView;", "t", "H", "u", "Landroid/widget/ImageView;", "v", "Landroid/widget/TextView;", "w", "Landroid/view/MotionEvent;", "ev", "", "dispatchTouchEvent", "p", "endTimeUs", "setRecordControlWidth", "", "width", "i0", "start", "j0", "startTimeUs", "Y", "needSeek", "Z", "e0", "setSliderBorderViewX", BasicAnimation.KeyPath.SCALE_X, "setSliderBorderScaleX", "velocityX", "fling", "onTouchEvent", "l", "oldl", "oldt", "onScrollChanged", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "", "Lcom/tencent/mobileqq/wink/editor/clipping/timeline/widget/videotrack/n;", "clipModels", "", "transitionList", "f0", "d0", "index", AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, "P", "O", BdhLogUtil.LogTag.Tag_Req, "", "uuid", "h0", "Lf63/a;", "controller", ReportConstant.COSTREPORT_PREFIX, "Lcom/tencent/mobileqq/wink/editor/clipping/timeline/reorder/a;", "listener", "setItemOnLongClickListener", "Lcom/tencent/mobileqq/wink/editor/clipping/timeline/reorder/c;", "setDrawBitmapListener", "view", "setHandleView", "l0", "V", "U", "n0", "offset", "m0", "X", "a0", "D", "J", NodeProps.VISIBLE, "setFreedomSliderViewVisible", "d", "I", "getSelectedType", "()I", "setSelectedType", "(I)V", "selectedType", "e", "MIN_STICKER_DURATION", "f", UserInfo.SEX_FEMALE, "STICKER_ABSORPTION_THRESHOLD_TIME_PERCENT", "Lcom/tencent/mobileqq/wink/editor/clipping/timeline/widget/videotrack/l;", tl.h.F, "Lcom/tencent/mobileqq/wink/editor/clipping/timeline/widget/videotrack/l;", "Landroid/widget/FrameLayout;", "i", "Lkotlin/Lazy;", "B", "()Landroid/widget/FrameLayout;", "frameRootView", "Landroid/widget/RelativeLayout;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "N", "()Landroid/widget/RelativeLayout;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, BdhLogUtil.LogTag.Tag_Conn, "Ljava/util/List;", "videoTrackViews", "cornerRadius", "Lcom/tencent/mobileqq/wink/editor/clipping/timeline/widget/dragdrop/t;", "E", "Lcom/tencent/mobileqq/wink/editor/clipping/timeline/widget/dragdrop/t;", "getPositionChangedHandler", "()Lcom/tencent/mobileqq/wink/editor/clipping/timeline/widget/dragdrop/t;", "setPositionChangedHandler", "(Lcom/tencent/mobileqq/wink/editor/clipping/timeline/widget/dragdrop/t;)V", "positionChangedHandler", "Lcom/tencent/mobileqq/wink/editor/clipping/timeline/reorder/a;", "itemLongClickListener", "G", "Lcom/tencent/mobileqq/wink/editor/clipping/timeline/reorder/c;", "drawBitmapListener", "Landroid/graphics/Point;", "Landroid/graphics/Point;", "lastTouchPoint", "Lcom/tencent/mobileqq/wink/editor/clipping/timeline/widget/timeline/SliderView;", "()Lcom/tencent/mobileqq/wink/editor/clipping/timeline/widget/timeline/SliderView;", "setLeftFreedomSliderView", "(Lcom/tencent/mobileqq/wink/editor/clipping/timeline/widget/timeline/SliderView;)V", "leftFreedomSliderView", "setRightFreedomSliderView", "rightFreedomSliderView", "K", "Landroid/view/View;", "y", "()Landroid/view/View;", "setBeginMaskView", "(Landroid/view/View;)V", "beginMaskView", "L", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "setEndMaskView", "endMaskView", "M", "Landroid/widget/ImageView;", "sliderTopBorderView", "sliderBottomBorderView", "Landroid/widget/TextView;", "sliderDurationView", "leftSliderViewRawX", "rightSliderViewRawX", ExifInterface.LATITUDE_SOUTH, "scrollOffset", "reorderContainerWidth", "Landroidx/lifecycle/MutableLiveData;", "Lkotlin/Pair;", "Landroidx/lifecycle/MutableLiveData;", "()Landroidx/lifecycle/MutableLiveData;", "setLeftSliderStartTime", "(Landroidx/lifecycle/MutableLiveData;)V", "leftSliderStartTime", "setRightSliderEndTime", "rightSliderEndTime", "W", "setVideoTrackPadding", "videoTrackPadding", "setLeftSliderMovingTime", "leftSliderMovingTime", "setRightSliderMovingTime", "rightSliderMovingTime", "getCanVibrate", "()Z", "setCanVibrate", "(Z)V", "canVibrate", "setClipTimeAdjust", "isClipTimeAdjust", "isSticker", "setSticker", "handleView", "g0", "hasDownEvent", "hasUpEvent", "isInMoving", "com/tencent/mobileqq/wink/editor/clipping/timeline/widget/videotrack/VideoTrackContainerView$c", "Lcom/tencent/mobileqq/wink/editor/clipping/timeline/widget/videotrack/VideoTrackContainerView$c;", "com/tencent/mobileqq/wink/editor/clipping/timeline/widget/videotrack/VideoTrackContainerView$h", "Lcom/tencent/mobileqq/wink/editor/clipping/timeline/widget/videotrack/VideoTrackContainerView$h;", "timeLineViewListener", "com/tencent/mobileqq/wink/editor/clipping/timeline/widget/videotrack/VideoTrackContainerView$g", "Lcom/tencent/mobileqq/wink/editor/clipping/timeline/widget/videotrack/VideoTrackContainerView$g;", "selectListener", "com/tencent/mobileqq/wink/editor/clipping/timeline/widget/videotrack/VideoTrackContainerView$b", "Lcom/tencent/mobileqq/wink/editor/clipping/timeline/widget/videotrack/VideoTrackContainerView$b;", "leftSliderListener", "com/tencent/mobileqq/wink/editor/clipping/timeline/widget/videotrack/VideoTrackContainerView$d", "Lcom/tencent/mobileqq/wink/editor/clipping/timeline/widget/videotrack/VideoTrackContainerView$d;", "newLeftSliderListener", "com/tencent/mobileqq/wink/editor/clipping/timeline/widget/videotrack/VideoTrackContainerView$f", "o0", "Lcom/tencent/mobileqq/wink/editor/clipping/timeline/widget/videotrack/VideoTrackContainerView$f;", "rightSliderListener", "com/tencent/mobileqq/wink/editor/clipping/timeline/widget/videotrack/VideoTrackContainerView$e", "p0", "Lcom/tencent/mobileqq/wink/editor/clipping/timeline/widget/videotrack/VideoTrackContainerView$e;", "newRightSliderListener", "leftSliderViewId", "rightSliderViewId", "Landroid/content/Context;", "mContext", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "defStyle", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;II)V", "r0", "a", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes21.dex */
public class VideoTrackContainerView extends HorizontalScrollView implements f63.b {

    /* renamed from: C, reason: from kotlin metadata */
    @NotNull
    private final List<VideoTrackTimelineView> videoTrackViews;

    /* renamed from: D, reason: from kotlin metadata */
    private int cornerRadius;

    /* renamed from: E, reason: from kotlin metadata */
    @Nullable
    private t positionChangedHandler;

    /* renamed from: F, reason: from kotlin metadata */
    @Nullable
    private com.tencent.mobileqq.wink.editor.clipping.timeline.reorder.a itemLongClickListener;

    /* renamed from: G, reason: from kotlin metadata */
    @Nullable
    private com.tencent.mobileqq.wink.editor.clipping.timeline.reorder.c drawBitmapListener;

    /* renamed from: H, reason: from kotlin metadata */
    @NotNull
    private Point lastTouchPoint;

    /* renamed from: I, reason: from kotlin metadata */
    public SliderView leftFreedomSliderView;

    /* renamed from: J, reason: from kotlin metadata */
    public SliderView rightFreedomSliderView;

    /* renamed from: K, reason: from kotlin metadata */
    public View beginMaskView;

    /* renamed from: L, reason: from kotlin metadata */
    public View endMaskView;

    /* renamed from: M, reason: from kotlin metadata */
    private ImageView sliderTopBorderView;

    /* renamed from: N, reason: from kotlin metadata */
    private ImageView sliderBottomBorderView;

    /* renamed from: P, reason: from kotlin metadata */
    private TextView sliderDurationView;

    /* renamed from: Q, reason: from kotlin metadata */
    private float leftSliderViewRawX;

    /* renamed from: R, reason: from kotlin metadata */
    private float rightSliderViewRawX;

    /* renamed from: S, reason: from kotlin metadata */
    private int scrollOffset;

    /* renamed from: T, reason: from kotlin metadata */
    private int reorderContainerWidth;

    /* renamed from: U, reason: from kotlin metadata */
    @NotNull
    private MutableLiveData<Pair<Long, Boolean>> leftSliderStartTime;

    /* renamed from: V, reason: from kotlin metadata */
    @NotNull
    private MutableLiveData<Pair<Long, Boolean>> rightSliderEndTime;

    /* renamed from: W, reason: from kotlin metadata */
    private int videoTrackPadding;

    /* renamed from: a0, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private MutableLiveData<Long> leftSliderMovingTime;

    /* renamed from: b0, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private MutableLiveData<Pair<Long, Long>> rightSliderMovingTime;

    /* renamed from: c0, reason: collision with root package name and from kotlin metadata */
    private boolean canVibrate;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private int selectedType;

    /* renamed from: d0, reason: collision with root package name and from kotlin metadata */
    private boolean isClipTimeAdjust;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private long MIN_STICKER_DURATION;

    /* renamed from: e0, reason: collision with root package name and from kotlin metadata */
    private boolean isSticker;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private float STICKER_ABSORPTION_THRESHOLD_TIME_PERCENT;

    /* renamed from: f0, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private View handleView;

    /* renamed from: g0, reason: collision with root package name and from kotlin metadata */
    private boolean hasDownEvent;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private l controller;

    /* renamed from: h0, reason: collision with root package name and from kotlin metadata */
    private boolean hasUpEvent;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy frameRootView;

    /* renamed from: i0, reason: collision with root package name and from kotlin metadata */
    private boolean isInMoving;

    /* renamed from: j0, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final c listener;

    /* renamed from: k0, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final h timeLineViewListener;

    /* renamed from: l0, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final g selectListener;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy rootView;

    /* renamed from: m0, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final b leftSliderListener;

    /* renamed from: n0, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final d newLeftSliderListener;

    /* renamed from: o0, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final f rightSliderListener;

    /* renamed from: p0, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final e newRightSliderListener;

    /* renamed from: q0, reason: collision with root package name */
    @NotNull
    public Map<Integer, View> f319556q0;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0018\u0010\t\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u0002H\u0016J\b\u0010\n\u001a\u00020\u0004H\u0016\u00a8\u0006\u000b"}, d2 = {"com/tencent/mobileqq/wink/editor/clipping/timeline/widget/videotrack/VideoTrackContainerView$b", "Lk63/a;", "", "rawX", "", "b", "Landroid/view/MotionEvent;", "event", "moveX", "c", "a", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes21.dex */
    public static final class b implements k63.a {
        b() {
        }

        @Override // k63.a
        public void a() {
            l lVar = VideoTrackContainerView.this.controller;
            if (lVar == null) {
                return;
            }
            VideoTrackContainerView.this.getParent().requestDisallowInterceptTouchEvent(false);
            VideoTrackContainerView.this.setClipTimeAdjust(true);
            VideoTrackContainerView.this.F().postValue(new Pair<>(Long.valueOf(lVar.I(VideoTrackContainerView.this.C().getX() - VideoTrackContainerView.this.T(0))), Boolean.TRUE));
            VideoTrackContainerView.this.setCanVibrate(true);
        }

        @Override // k63.a
        public void b(float rawX) {
            VideoTrackContainerView.this.getParent().requestDisallowInterceptTouchEvent(true);
            VideoTrackContainerView.this.leftSliderViewRawX = rawX;
            VideoTrackContainerView.this.setCanVibrate(true);
        }

        @Override // k63.a
        public void c(@NotNull MotionEvent event, float moveX) {
            Intrinsics.checkNotNullParameter(event, "event");
            l lVar = VideoTrackContainerView.this.controller;
            if (lVar == null) {
                return;
            }
            float x16 = (VideoTrackContainerView.this.C().getX() + moveX) - VideoTrackContainerView.this.leftSliderViewRawX;
            long I = lVar.I((VideoTrackContainerView.this.I().getX() - x16) - VideoTrackContainerView.this.C().getWidth());
            long j3 = 0;
            if (I >= VideoTrackContainerView.this.MIN_STICKER_DURATION && x16 >= VideoTrackContainerView.this.T(0) + (VideoTrackContainerView.this.getVideoTrackPadding() * 2)) {
                if ((VideoTrackContainerView.this.leftSliderViewRawX - (com.tencent.videocut.utils.o.g() / 2)) * (moveX - (com.tencent.videocut.utils.o.g() / 2)) < 0.0f) {
                    VideoTrackContainerView.this.n0();
                }
                VideoTrackContainerView.this.C().setX(x16);
                VideoTrackContainerView.this.leftSliderViewRawX = moveX;
                VideoTrackContainerView.this.setSliderBorderViewX(x16);
                VideoTrackContainerView videoTrackContainerView = VideoTrackContainerView.this;
                videoTrackContainerView.setSliderBorderScaleX(((videoTrackContainerView.I().getX() - VideoTrackContainerView.this.C().getX()) - VideoTrackContainerView.this.C().getWidth()) / VideoTrackContainerView.this.getVideoTrackPadding());
                VideoTrackContainerView videoTrackContainerView2 = VideoTrackContainerView.this;
                long I2 = lVar.I(videoTrackContainerView2.C().getX() - VideoTrackContainerView.this.T(0));
                Pair<Long, Boolean> value = VideoTrackContainerView.this.K().getValue();
                if (value != null) {
                    j3 = value.getFirst().longValue();
                }
                videoTrackContainerView2.k0(I2, j3);
                VideoTrackContainerView.this.setCanVibrate(true);
                return;
            }
            if (I < VideoTrackContainerView.this.MIN_STICKER_DURATION) {
                VideoTrackContainerView videoTrackContainerView3 = VideoTrackContainerView.this;
                videoTrackContainerView3.k0(0L, videoTrackContainerView3.MIN_STICKER_DURATION);
            }
            VideoTrackContainerView.this.n0();
            VideoTrackContainerView.this.setCanVibrate(false);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0018\u0010\b\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0006H\u0016\u00a8\u0006\t"}, d2 = {"com/tencent/mobileqq/wink/editor/clipping/timeline/widget/videotrack/VideoTrackContainerView$c", "Lcom/tencent/mobileqq/wink/editor/clipping/timeline/widget/panel/scroll/FlingHelper$a;", "", "xPos", "", "b", "", "cancel", "a", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes21.dex */
    public static final class c implements FlingHelper.a {
        c() {
        }

        @Override // com.tencent.mobileqq.wink.editor.clipping.timeline.widget.panel.scroll.FlingHelper.a
        public void a(int xPos, boolean cancel) {
            PanelEventHandler k3;
            VideoTrackContainerView.this.isInMoving = false;
            l lVar = VideoTrackContainerView.this.controller;
            if (lVar != null && (k3 = lVar.k()) != null) {
                k3.a(new com.tencent.mobileqq.wink.editor.clipping.timeline.widget.panel.event.d(cancel));
            }
        }

        @Override // com.tencent.mobileqq.wink.editor.clipping.timeline.widget.panel.scroll.FlingHelper.a
        public void b(int xPos) {
            VideoTrackContainerView videoTrackContainerView = VideoTrackContainerView.this;
            videoTrackContainerView.scrollTo(xPos, videoTrackContainerView.getScrollY());
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000-\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0006*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0018\u0010\t\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u0002H\u0016J\b\u0010\n\u001a\u00020\u0004H\u0016R\"\u0010\u0010\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\"\u0010\u0017\u001a\u00020\u00118\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0005\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\"\u0010\u001a\u001a\u00020\u00188\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\t\u0010\u0019\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001d\u00a8\u0006\u001e"}, d2 = {"com/tencent/mobileqq/wink/editor/clipping/timeline/widget/videotrack/VideoTrackContainerView$d", "Lk63/a;", "", "rawX", "", "b", "Landroid/view/MotionEvent;", "event", "moveX", "c", "a", UserInfo.SEX_FEMALE, "getAbsorptionThreshold", "()F", "setAbsorptionThreshold", "(F)V", "absorptionThreshold", "", "I", "getONE_SECOND_LENGTH", "()I", "setONE_SECOND_LENGTH", "(I)V", "ONE_SECOND_LENGTH", "", "Z", "isMinDuration", "()Z", "setMinDuration", "(Z)V", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes21.dex */
    public static final class d implements k63.a {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        private float absorptionThreshold;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata */
        private int ONE_SECOND_LENGTH;

        /* renamed from: c, reason: collision with root package name and from kotlin metadata */
        private boolean isMinDuration;

        d() {
        }

        @Override // k63.a
        public void a() {
            long totalDurationUs;
            VideoTrackContainerView.this.getParent().requestDisallowInterceptTouchEvent(false);
            VideoTrackContainerView.this.setClipTimeAdjust(true);
            VideoTrackContainerView.this.setCanVibrate(true);
            l lVar = VideoTrackContainerView.this.controller;
            if (lVar == null) {
                return;
            }
            long I = lVar.I(VideoTrackContainerView.this.C().getX() - VideoTrackContainerView.this.T(0));
            if (this.isMinDuration) {
                Pair<Long, Boolean> value = VideoTrackContainerView.this.K().getValue();
                if (value != null) {
                    totalDurationUs = value.getFirst().longValue();
                } else {
                    totalDurationUs = lVar.getTotalDurationUs();
                }
                I = totalDurationUs - VideoTrackContainerView.this.MIN_STICKER_DURATION;
            }
            VideoTrackContainerView.this.F().postValue(new Pair<>(Long.valueOf(I), Boolean.TRUE));
        }

        @Override // k63.a
        public void b(float rawX) {
            l lVar = VideoTrackContainerView.this.controller;
            if (lVar == null) {
                return;
            }
            VideoTrackContainerView.this.getParent().requestDisallowInterceptTouchEvent(true);
            VideoTrackContainerView.this.leftSliderViewRawX = rawX;
            VideoTrackContainerView.this.setCanVibrate(true);
            this.isMinDuration = false;
            this.absorptionThreshold = VideoTrackContainerView.this.STICKER_ABSORPTION_THRESHOLD_TIME_PERCENT * lVar.J(lVar.getTotalDurationUs());
            this.ONE_SECOND_LENGTH = lVar.J(VideoTrackContainerView.this.MIN_STICKER_DURATION);
        }

        @Override // k63.a
        public void c(@NotNull MotionEvent event, float moveX) {
            long j3;
            Intrinsics.checkNotNullParameter(event, "event");
            l lVar = VideoTrackContainerView.this.controller;
            if (lVar == null) {
                return;
            }
            float P = VideoTrackContainerView.this.P() - VideoTrackContainerView.this.C().getWidth();
            float x16 = (VideoTrackContainerView.this.I().getX() - VideoTrackContainerView.this.C().getWidth()) - VideoTrackContainerView.this.H();
            float x17 = VideoTrackContainerView.this.C().getX();
            float f16 = moveX - VideoTrackContainerView.this.leftSliderViewRawX;
            if ((x17 <= P && f16 < 0.0f) || (x17 >= x16 - this.ONE_SECOND_LENGTH && f16 > 0.0f)) {
                VideoTrackContainerView.this.n0();
                VideoTrackContainerView.this.setCanVibrate(false);
                if (x17 >= x16 - this.ONE_SECOND_LENGTH && f16 > 0.0f) {
                    VideoTrackContainerView.this.C().setX(x16 - this.ONE_SECOND_LENGTH);
                    this.isMinDuration = true;
                    VideoTrackContainerView videoTrackContainerView = VideoTrackContainerView.this;
                    videoTrackContainerView.k0(0L, videoTrackContainerView.MIN_STICKER_DURATION);
                } else if (x17 <= P && f16 < 0.0f) {
                    VideoTrackContainerView.this.C().setX(P);
                }
                VideoTrackContainerView videoTrackContainerView2 = VideoTrackContainerView.this;
                videoTrackContainerView2.setSliderBorderViewX(videoTrackContainerView2.C().getX());
                VideoTrackContainerView videoTrackContainerView3 = VideoTrackContainerView.this;
                videoTrackContainerView3.setSliderBorderScaleX(((videoTrackContainerView3.I().getX() - VideoTrackContainerView.this.C().getX()) - VideoTrackContainerView.this.C().getWidth()) / VideoTrackContainerView.this.getVideoTrackPadding());
                return;
            }
            if (Math.abs(x17 - P) > this.absorptionThreshold || f16 >= 0.0f) {
                List<VideoTrackTimelineView> list = VideoTrackContainerView.this.videoTrackViews;
                VideoTrackContainerView videoTrackContainerView4 = VideoTrackContainerView.this;
                for (VideoTrackTimelineView videoTrackTimelineView : list) {
                    if (Math.abs(x17 - videoTrackTimelineView.getLeft()) <= this.absorptionThreshold && (x17 - videoTrackTimelineView.getLeft()) * f16 < 0.0f) {
                        x17 = videoTrackTimelineView.getLeft();
                        videoTrackContainerView4.C().setX(videoTrackTimelineView.getLeft());
                        videoTrackContainerView4.n0();
                        videoTrackContainerView4.setCanVibrate(false);
                    }
                }
            } else {
                VideoTrackContainerView.this.C().setX(P);
                VideoTrackContainerView.this.n0();
                VideoTrackContainerView.this.setCanVibrate(false);
                x17 = P;
            }
            float min = Math.min(x16, Math.max(P, x17 + f16));
            VideoTrackContainerView.this.C().setX(min);
            VideoTrackContainerView videoTrackContainerView5 = VideoTrackContainerView.this;
            videoTrackContainerView5.i0((videoTrackContainerView5.C().getX() - VideoTrackContainerView.this.P()) + VideoTrackContainerView.this.C().getWidth());
            VideoTrackContainerView.this.setSliderBorderViewX(min);
            VideoTrackContainerView videoTrackContainerView6 = VideoTrackContainerView.this;
            videoTrackContainerView6.setSliderBorderScaleX(((videoTrackContainerView6.I().getX() - VideoTrackContainerView.this.C().getX()) - VideoTrackContainerView.this.C().getWidth()) / VideoTrackContainerView.this.getVideoTrackPadding());
            VideoTrackContainerView videoTrackContainerView7 = VideoTrackContainerView.this;
            long I = lVar.I(videoTrackContainerView7.C().getX() - VideoTrackContainerView.this.T(0));
            Pair<Long, Boolean> value = VideoTrackContainerView.this.K().getValue();
            if (value != null) {
                j3 = value.getFirst().longValue();
            } else {
                j3 = 0;
            }
            videoTrackContainerView7.k0(I, j3);
            VideoTrackContainerView.this.setCanVibrate(true);
            VideoTrackContainerView.this.leftSliderViewRawX = moveX;
            VideoTrackContainerView.this.E().postValue(Long.valueOf(lVar.I(VideoTrackContainerView.this.C().getX() - VideoTrackContainerView.this.T(0))));
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000-\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0006*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0018\u0010\t\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u0002H\u0016J\b\u0010\n\u001a\u00020\u0004H\u0016R\"\u0010\u0010\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\"\u0010\u0017\u001a\u00020\u00118\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0005\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\"\u0010\u001a\u001a\u00020\u00188\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\t\u0010\u0019\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001d\u00a8\u0006\u001e"}, d2 = {"com/tencent/mobileqq/wink/editor/clipping/timeline/widget/videotrack/VideoTrackContainerView$e", "Lk63/a;", "", "rawX", "", "b", "Landroid/view/MotionEvent;", "event", "moveX", "c", "a", UserInfo.SEX_FEMALE, "getAbsorptionThreshold", "()F", "setAbsorptionThreshold", "(F)V", "absorptionThreshold", "", "I", "getONE_SECOND_LENGTH", "()I", "setONE_SECOND_LENGTH", "(I)V", "ONE_SECOND_LENGTH", "", "Z", "isMinDuration", "()Z", "setMinDuration", "(Z)V", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes21.dex */
    public static final class e implements k63.a {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        private float absorptionThreshold;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata */
        private int ONE_SECOND_LENGTH;

        /* renamed from: c, reason: collision with root package name and from kotlin metadata */
        private boolean isMinDuration;

        e() {
        }

        @Override // k63.a
        public void a() {
            long j3;
            VideoTrackContainerView.this.getParent().requestDisallowInterceptTouchEvent(false);
            VideoTrackContainerView.this.setClipTimeAdjust(true);
            VideoTrackContainerView.this.setCanVibrate(true);
            l lVar = VideoTrackContainerView.this.controller;
            if (lVar == null) {
                return;
            }
            long I = lVar.I((VideoTrackContainerView.this.I().getX() - VideoTrackContainerView.this.T(0)) - VideoTrackContainerView.this.C().getWidth());
            if (this.isMinDuration) {
                Pair<Long, Boolean> value = VideoTrackContainerView.this.F().getValue();
                if (value != null) {
                    j3 = value.getFirst().longValue();
                } else {
                    j3 = 0;
                }
                I = j3 + VideoTrackContainerView.this.MIN_STICKER_DURATION;
            }
            VideoTrackContainerView.this.K().postValue(new Pair<>(Long.valueOf(I), Boolean.TRUE));
        }

        @Override // k63.a
        public void b(float rawX) {
            VideoTrackContainerView.this.getParent().requestDisallowInterceptTouchEvent(true);
            VideoTrackContainerView.this.rightSliderViewRawX = rawX;
            VideoTrackContainerView.this.setCanVibrate(true);
            l lVar = VideoTrackContainerView.this.controller;
            if (lVar == null) {
                return;
            }
            this.absorptionThreshold = VideoTrackContainerView.this.STICKER_ABSORPTION_THRESHOLD_TIME_PERCENT * lVar.J(lVar.getTotalDurationUs());
            this.ONE_SECOND_LENGTH = lVar.J(VideoTrackContainerView.this.MIN_STICKER_DURATION);
            this.isMinDuration = false;
        }

        @Override // k63.a
        public void c(@NotNull MotionEvent event, float moveX) {
            long j3;
            Intrinsics.checkNotNullParameter(event, "event");
            l lVar = VideoTrackContainerView.this.controller;
            if (lVar == null) {
                return;
            }
            float x16 = VideoTrackContainerView.this.C().getX() + VideoTrackContainerView.this.C().getWidth() + VideoTrackContainerView.this.H();
            float O = VideoTrackContainerView.this.O();
            float min = Math.min(VideoTrackContainerView.this.I().getX(), O);
            float f16 = moveX - VideoTrackContainerView.this.rightSliderViewRawX;
            long j16 = 0;
            if ((min <= this.ONE_SECOND_LENGTH + x16 && f16 < 0.0f) || (min >= O && f16 > 0.0f)) {
                VideoTrackContainerView.this.n0();
                VideoTrackContainerView.this.setCanVibrate(false);
                int i3 = this.ONE_SECOND_LENGTH;
                if (min <= i3 + x16 && f16 < 0.0f && i3 + x16 < O) {
                    VideoTrackContainerView.this.I().setX(x16 + this.ONE_SECOND_LENGTH);
                    this.isMinDuration = true;
                    VideoTrackContainerView videoTrackContainerView = VideoTrackContainerView.this;
                    videoTrackContainerView.k0(0L, videoTrackContainerView.MIN_STICKER_DURATION);
                    return;
                }
                if (min >= O && f16 > 0.0f) {
                    VideoTrackContainerView.this.I().setX(O);
                    VideoTrackContainerView videoTrackContainerView2 = VideoTrackContainerView.this;
                    Pair<Long, Boolean> value = videoTrackContainerView2.F().getValue();
                    if (value != null) {
                        j16 = value.getFirst().longValue();
                    }
                    videoTrackContainerView2.k0(j16, lVar.I(VideoTrackContainerView.this.I().getX() - VideoTrackContainerView.this.T(0)));
                    return;
                }
                return;
            }
            if (Math.abs(min - O) > this.absorptionThreshold || f16 < 0.0f) {
                List<VideoTrackTimelineView> list = VideoTrackContainerView.this.videoTrackViews;
                VideoTrackContainerView videoTrackContainerView3 = VideoTrackContainerView.this;
                for (VideoTrackTimelineView videoTrackTimelineView : list) {
                    if (Math.abs((min - videoTrackContainerView3.I().getWidth()) - videoTrackTimelineView.getLeft()) <= this.absorptionThreshold && ((min - videoTrackContainerView3.I().getWidth()) - videoTrackTimelineView.getLeft()) * f16 < 0.0f) {
                        min = videoTrackTimelineView.getLeft() + videoTrackContainerView3.I().getWidth();
                        videoTrackContainerView3.I().setX(videoTrackTimelineView.getLeft() + videoTrackContainerView3.I().getWidth());
                        videoTrackContainerView3.n0();
                        videoTrackContainerView3.setCanVibrate(false);
                    }
                }
            } else {
                VideoTrackContainerView.this.n0();
                VideoTrackContainerView.this.setCanVibrate(false);
                min = O;
            }
            ms.a.a("VideoTrackContainerView", "[onMoving] rightMostX = " + O + ", leftMinX = " + x16 + ",currentX = " + min + ", changeX = " + f16);
            VideoTrackContainerView.this.I().setX(Math.min(O, Math.max(x16, min + f16)));
            VideoTrackContainerView videoTrackContainerView4 = VideoTrackContainerView.this;
            videoTrackContainerView4.j0(videoTrackContainerView4.I().getX());
            VideoTrackContainerView videoTrackContainerView5 = VideoTrackContainerView.this;
            videoTrackContainerView5.setSliderBorderScaleX(((videoTrackContainerView5.I().getX() - VideoTrackContainerView.this.C().getX()) - ((float) VideoTrackContainerView.this.C().getWidth())) / ((float) VideoTrackContainerView.this.getVideoTrackPadding()));
            VideoTrackContainerView videoTrackContainerView6 = VideoTrackContainerView.this;
            Pair<Long, Boolean> value2 = videoTrackContainerView6.F().getValue();
            if (value2 != null) {
                j3 = value2.getFirst().longValue();
            } else {
                j3 = 0;
            }
            videoTrackContainerView6.k0(j3, lVar.I(VideoTrackContainerView.this.I().getX() - VideoTrackContainerView.this.T(0)));
            VideoTrackContainerView.this.setCanVibrate(true);
            VideoTrackContainerView.this.rightSliderViewRawX = moveX;
            VideoTrackContainerView.this.L().postValue(new Pair<>(Long.valueOf(lVar.I((VideoTrackContainerView.this.I().getX() - VideoTrackContainerView.this.T(0)) - VideoTrackContainerView.this.C().getWidth())), Long.valueOf(lVar.I(VideoTrackContainerView.this.C().getX() - VideoTrackContainerView.this.T(0)))));
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0018\u0010\t\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u0002H\u0016J\b\u0010\n\u001a\u00020\u0004H\u0016\u00a8\u0006\u000b"}, d2 = {"com/tencent/mobileqq/wink/editor/clipping/timeline/widget/videotrack/VideoTrackContainerView$f", "Lk63/a;", "", "rawX", "", "b", "Landroid/view/MotionEvent;", "event", "moveX", "c", "a", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes21.dex */
    public static final class f implements k63.a {
        f() {
        }

        @Override // k63.a
        public void a() {
            l lVar = VideoTrackContainerView.this.controller;
            if (lVar == null) {
                return;
            }
            VideoTrackContainerView.this.getParent().requestDisallowInterceptTouchEvent(false);
            VideoTrackContainerView.this.setClipTimeAdjust(true);
            VideoTrackContainerView.this.K().postValue(new Pair<>(Long.valueOf(lVar.I(VideoTrackContainerView.this.I().getX() - VideoTrackContainerView.this.T(0))), Boolean.TRUE));
            VideoTrackContainerView.this.setCanVibrate(true);
        }

        @Override // k63.a
        public void b(float rawX) {
            VideoTrackContainerView.this.getParent().requestDisallowInterceptTouchEvent(true);
            VideoTrackContainerView.this.rightSliderViewRawX = rawX;
            VideoTrackContainerView.this.setCanVibrate(true);
        }

        @Override // k63.a
        public void c(@NotNull MotionEvent event, float moveX) {
            long j3;
            long j16;
            Intrinsics.checkNotNullParameter(event, "event");
            float x16 = (VideoTrackContainerView.this.I().getX() + moveX) - VideoTrackContainerView.this.rightSliderViewRawX;
            l lVar = VideoTrackContainerView.this.controller;
            long j17 = 0;
            if (lVar != null) {
                j3 = lVar.I((x16 - VideoTrackContainerView.this.C().getX()) - VideoTrackContainerView.this.C().getWidth());
            } else {
                j3 = 0;
            }
            if (j3 >= VideoTrackContainerView.this.MIN_STICKER_DURATION) {
                float width = VideoTrackContainerView.this.I().getWidth() + x16;
                VideoTrackContainerView videoTrackContainerView = VideoTrackContainerView.this;
                if (width <= videoTrackContainerView.R(videoTrackContainerView.videoTrackViews.size() - 1) - (VideoTrackContainerView.this.getVideoTrackPadding() * 2)) {
                    if ((VideoTrackContainerView.this.rightSliderViewRawX - (com.tencent.videocut.utils.o.g() / 2)) * (moveX - (com.tencent.videocut.utils.o.g() / 2)) < 0.0f) {
                        VideoTrackContainerView.this.n0();
                    }
                    VideoTrackContainerView.this.I().setX(x16);
                    VideoTrackContainerView.this.rightSliderViewRawX = moveX;
                    VideoTrackContainerView videoTrackContainerView2 = VideoTrackContainerView.this;
                    videoTrackContainerView2.setSliderBorderScaleX(((videoTrackContainerView2.I().getX() - VideoTrackContainerView.this.C().getX()) - VideoTrackContainerView.this.C().getWidth()) / VideoTrackContainerView.this.getVideoTrackPadding());
                    VideoTrackContainerView videoTrackContainerView3 = VideoTrackContainerView.this;
                    Pair<Long, Boolean> value = videoTrackContainerView3.F().getValue();
                    if (value != null) {
                        j16 = value.getFirst().longValue();
                    } else {
                        j16 = 0;
                    }
                    l lVar2 = VideoTrackContainerView.this.controller;
                    if (lVar2 != null) {
                        j17 = lVar2.I(VideoTrackContainerView.this.I().getX() - VideoTrackContainerView.this.T(0));
                    }
                    videoTrackContainerView3.k0(j16, j17);
                    VideoTrackContainerView.this.setCanVibrate(true);
                    return;
                }
            }
            if (j3 < VideoTrackContainerView.this.MIN_STICKER_DURATION) {
                VideoTrackContainerView videoTrackContainerView4 = VideoTrackContainerView.this;
                videoTrackContainerView4.k0(0L, videoTrackContainerView4.MIN_STICKER_DURATION);
            }
            VideoTrackContainerView.this.n0();
            VideoTrackContainerView.this.setCanVibrate(false);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000+\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J0\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\tH\u0016\u00a8\u0006\r"}, d2 = {"com/tencent/mobileqq/wink/editor/clipping/timeline/widget/videotrack/VideoTrackContainerView$g", "Lcom/tencent/mobileqq/wink/editor/clipping/timeline/widget/videotrack/VideoTrackTimelineView$b;", "", "id", "", "selectedStatus", "", "isClickStartClipRegion", "isClickEndClipRegion", "Lcom/tencent/mobileqq/wink/editor/clipping/timeline/widget/videotrack/VideoTrackTimelineView;", "view", "", "a", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes21.dex */
    public static final class g implements VideoTrackTimelineView.b {
        g() {
        }

        @Override // com.tencent.mobileqq.wink.editor.clipping.timeline.widget.videotrack.VideoTrackTimelineView.b
        public void a(@NotNull String id5, int selectedStatus, boolean isClickStartClipRegion, boolean isClickEndClipRegion, @NotNull VideoTrackTimelineView view) {
            Object orNull;
            VideoTrackTimelineView videoTrackTimelineView;
            Object orNull2;
            Intrinsics.checkNotNullParameter(id5, "id");
            Intrinsics.checkNotNullParameter(view, "view");
            if (selectedStatus == 1) {
                l lVar = VideoTrackContainerView.this.controller;
                if (lVar != null) {
                    lVar.H();
                    return;
                }
                return;
            }
            if (!isClickStartClipRegion && !isClickEndClipRegion) {
                l lVar2 = VideoTrackContainerView.this.controller;
                if (lVar2 != null) {
                    lVar2.G(id5, selectedStatus);
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
                l lVar3 = VideoTrackContainerView.this.controller;
                if (lVar3 != null) {
                    lVar3.G(id5, selectedStatus);
                    return;
                }
                return;
            }
            videoTrackTimelineView.G1(false);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000%\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0018\u0010\b\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0006H\u0016J\u0018\u0010\f\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\nH\u0016\u00a8\u0006\r"}, d2 = {"com/tencent/mobileqq/wink/editor/clipping/timeline/widget/videotrack/VideoTrackContainerView$h", "Lcom/tencent/mobileqq/wink/editor/clipping/timeline/widget/dragdrop/u;", "Lcom/tencent/mobileqq/wink/editor/clipping/timeline/widget/dragdrop/f;", "dragModel", "", "a", "", "isLeft", "c", "selected", "Landroid/view/View;", "view", "b", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes21.dex */
    public static final class h implements u {
        h() {
        }

        @Override // com.tencent.mobileqq.wink.editor.clipping.timeline.widget.dragdrop.u
        public void a(@NotNull DragModel dragModel) {
            Intrinsics.checkNotNullParameter(dragModel, "dragModel");
        }

        @Override // com.tencent.mobileqq.wink.editor.clipping.timeline.widget.dragdrop.u
        public void b(boolean selected, @NotNull View view) {
            Intrinsics.checkNotNullParameter(view, "view");
        }

        @Override // com.tencent.mobileqq.wink.editor.clipping.timeline.widget.dragdrop.u
        public void c(@NotNull DragModel dragModel, boolean isLeft) {
            Intrinsics.checkNotNullParameter(dragModel, "dragModel");
            l lVar = VideoTrackContainerView.this.controller;
            if (lVar != null) {
                lVar.D(dragModel.getId(), isLeft);
            }
            VideoTrackContainerView.this.b0();
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public VideoTrackContainerView(@NotNull Context mContext) {
        this(mContext, null, 0, 0, 14, null);
        Intrinsics.checkNotNullParameter(mContext, "mContext");
    }

    private final FrameLayout B() {
        return (FrameLayout) this.frameRootView.getValue();
    }

    @IdRes
    private final int G() {
        return R.id.f97475kh;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final int H() {
        return 0;
    }

    @IdRes
    private final int M() {
        return R.id.f97495kj;
    }

    private final RelativeLayout N() {
        return (RelativeLayout) this.rootView.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void b0() {
        Iterator<T> it = this.videoTrackViews.iterator();
        while (it.hasNext()) {
            ((VideoTrackTimelineView) it.next()).I1();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void c(VideoTrackContainerView this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        l lVar = this$0.controller;
        if (lVar != null) {
            lVar.k().a(new com.tencent.mobileqq.wink.editor.clipping.timeline.widget.panel.event.o());
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    private final void c0() {
        d0(z());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean g0(com.tencent.mobileqq.wink.editor.clipping.timeline.reorder.a it, VideoTrackModel model, VideoTrackContainerView this$0, View view) {
        Intrinsics.checkNotNullParameter(it, "$it");
        Intrinsics.checkNotNullParameter(model, "$model");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        it.a(model.getUuid(), this$0.lastTouchPoint);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void k0(long startTime, long endTime) {
        String str = Math.rint((endTime - startTime) / 1000000.0d) + ReportConstant.COSTREPORT_PREFIX;
        TextView textView = this.sliderDurationView;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("sliderDurationView");
            textView = null;
        }
        textView.setText(str);
    }

    private final VideoTrackTimelineView r(i63.b scaleCalculator) {
        com.tencent.mobileqq.wink.editor.clipping.timeline.widget.videotrack.d thumbnailProvider;
        int generateViewId = View.generateViewId();
        DragModel dragModel = new DragModel(VideoTrackTimelineView.class, 0L, 0L, 0L, 0, String.valueOf(generateViewId), 30, null);
        Context context = getContext();
        Intrinsics.checkNotNullExpressionValue(context, "context");
        VideoTrackTimelineView videoTrackTimelineView = new VideoTrackTimelineView(context, null, 0, dragModel, this.selectedType, 6, null);
        l lVar = this.controller;
        if (lVar != null) {
            videoTrackTimelineView.setSingleBitmapWidth(com.tencent.videocut.utils.e.f384236a.a(lVar.h().getVideoTrackConfig().getSingleShowThumbWidth()));
        }
        videoTrackTimelineView.setId(generateViewId);
        l lVar2 = this.controller;
        if (lVar2 != null && (thumbnailProvider = lVar2.getThumbnailProvider()) != null) {
            videoTrackTimelineView.setThumbnailProvider(thumbnailProvider);
        }
        videoTrackTimelineView.setCornerRadius(this.cornerRadius);
        videoTrackTimelineView.setScaleCalculator(scaleCalculator);
        videoTrackTimelineView.o1(dragModel);
        videoTrackTimelineView.setSelectListener(this.selectListener);
        videoTrackTimelineView.setValueChangeListener(this.positionChangedHandler);
        videoTrackTimelineView.setDrawBitmapListener(this.drawBitmapListener);
        videoTrackTimelineView.setTimelineViewListener(this.timeLineViewListener);
        N().addView(videoTrackTimelineView, new FrameLayout.LayoutParams(-1, -1));
        this.videoTrackViews.add(videoTrackTimelineView);
        return videoTrackTimelineView;
    }

    @MainThread
    private final SliderView t(int id5) {
        SliderView sliderView = new SliderView(getContext(), null, 0, 6, null);
        sliderView.setId(id5);
        sliderView.setImageResource(R.drawable.onw);
        sliderView.setBackgroundColor(0);
        sliderView.setScaleType(ImageView.ScaleType.FIT_XY);
        return sliderView;
    }

    @MainThread
    private final SliderView u(int id5) {
        SliderView sliderView = new SliderView(getContext(), null, 0, 6, null);
        sliderView.setId(id5);
        sliderView.setImageResource(R.drawable.onx);
        sliderView.setBackgroundColor(0);
        sliderView.setScaleType(ImageView.ScaleType.FIT_XY);
        return sliderView;
    }

    @MainThread
    private final ImageView v(int id5) {
        ImageView imageView = new ImageView(getContext());
        imageView.setId(id5);
        imageView.setPivotX(0.0f);
        imageView.setBackgroundColor(imageView.getContext().getColor(R.color.f157866ck4));
        return imageView;
    }

    @MainThread
    private final TextView w(int id5) {
        int dpToPx = ViewUtils.dpToPx(4.0f);
        int dpToPx2 = ViewUtils.dpToPx(1.5f);
        TextView textView = new TextView(getContext());
        textView.setId(id5);
        textView.setGravity(17);
        textView.setTextSize(9.0f);
        textView.setTypeface(Typeface.DEFAULT_BOLD);
        textView.setTextColor(-1);
        textView.setPadding(dpToPx, dpToPx2, dpToPx, dpToPx2);
        textView.setBackgroundResource(R.drawable.f161877kw1);
        return textView;
    }

    private final <T extends View> void x(List<T> source, int targetSize) {
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
                try {
                    source.remove(view);
                    N().removeView(view);
                } catch (Exception e16) {
                    w53.b.d("VideoTrackContainerView", "cutViewListAndRelease removeView error", e16);
                }
            }
        }
    }

    private final int z() {
        l lVar = this.controller;
        if (lVar != null) {
            return lVar.j();
        }
        return 0;
    }

    @NotNull
    public final View A() {
        View view = this.endMaskView;
        if (view != null) {
            return view;
        }
        Intrinsics.throwUninitializedPropertyAccessException("endMaskView");
        return null;
    }

    @NotNull
    public final SliderView C() {
        SliderView sliderView = this.leftFreedomSliderView;
        if (sliderView != null) {
            return sliderView;
        }
        Intrinsics.throwUninitializedPropertyAccessException("leftFreedomSliderView");
        return null;
    }

    public final int D() {
        int dpToPx;
        float P = P();
        if (C().getWidth() != 0) {
            dpToPx = C().getWidth();
        } else {
            dpToPx = ViewUtils.dpToPx(14.0f);
        }
        return (int) (P - dpToPx);
    }

    @NotNull
    public final MutableLiveData<Long> E() {
        return this.leftSliderMovingTime;
    }

    @NotNull
    public final MutableLiveData<Pair<Long, Boolean>> F() {
        return this.leftSliderStartTime;
    }

    @NotNull
    public final SliderView I() {
        SliderView sliderView = this.rightFreedomSliderView;
        if (sliderView != null) {
            return sliderView;
        }
        Intrinsics.throwUninitializedPropertyAccessException("rightFreedomSliderView");
        return null;
    }

    public final int J() {
        return (int) (com.tencent.videocut.utils.o.g() - P());
    }

    @NotNull
    public final MutableLiveData<Pair<Long, Boolean>> K() {
        return this.rightSliderEndTime;
    }

    @NotNull
    public final MutableLiveData<Pair<Long, Long>> L() {
        return this.rightSliderMovingTime;
    }

    public final float O() {
        float f16;
        Float f17;
        int g16;
        CommonConfig h16;
        LayoutConfig layoutConfig;
        if (this.videoTrackViews.isEmpty()) {
            l lVar = this.controller;
            if (lVar != null && (h16 = lVar.h()) != null && (layoutConfig = h16.getLayoutConfig()) != null) {
                g16 = layoutConfig.getPanelStartOffset();
            } else {
                g16 = com.tencent.videocut.utils.o.g() / 2;
            }
            return g16;
        }
        float P = P();
        l lVar2 = this.controller;
        if (lVar2 != null) {
            long totalDurationUs = lVar2.getTotalDurationUs();
            if (this.controller != null) {
                f17 = Float.valueOf(r3.J(totalDurationUs));
            } else {
                f17 = null;
            }
            if (f17 != null) {
                f16 = f17.floatValue();
                return P + f16;
            }
        }
        f16 = ScreenUtil.SCREEN_WIDTH / 2.0f;
        return P + f16;
    }

    public final float P() {
        int g16;
        CommonConfig h16;
        LayoutConfig layoutConfig;
        if (this.videoTrackViews.isEmpty()) {
            l lVar = this.controller;
            if (lVar != null && (h16 = lVar.h()) != null && (layoutConfig = h16.getLayoutConfig()) != null) {
                g16 = layoutConfig.getPanelStartOffset();
            } else {
                g16 = com.tencent.videocut.utils.o.g() / 2;
            }
            return g16;
        }
        return this.videoTrackViews.get(0).getX() + com.tencent.videocut.utils.e.f384236a.a(16.0f);
    }

    public final float Q() {
        int g16;
        CommonConfig h16;
        LayoutConfig layoutConfig;
        l lVar = this.controller;
        if (lVar != null && (h16 = lVar.h()) != null && (layoutConfig = h16.getLayoutConfig()) != null) {
            g16 = layoutConfig.getPanelStartOffset();
        } else {
            g16 = com.tencent.videocut.utils.o.g() / 2;
        }
        return g16 - C().getWidth();
    }

    public final float R(int index) {
        if (index >= 0 && index < this.videoTrackViews.size()) {
            return this.videoTrackViews.get(index).getX() + this.videoTrackViews.get(index).getWidth();
        }
        return 0.0f;
    }

    /* renamed from: S, reason: from getter */
    public final int getVideoTrackPadding() {
        return this.videoTrackPadding;
    }

    public final float T(int index) {
        if (index >= 0 && index < this.videoTrackViews.size()) {
            return this.videoTrackViews.get(index).getX();
        }
        return (com.tencent.videocut.utils.o.g() / 2) - C().getWidth();
    }

    @NotNull
    public final List<VideoTrackTimelineView> U() {
        return this.videoTrackViews;
    }

    /* renamed from: V, reason: from getter */
    public final boolean getHasUpEvent() {
        return this.hasUpEvent;
    }

    /* renamed from: W, reason: from getter */
    public final boolean getIsClipTimeAdjust() {
        return this.isClipTimeAdjust;
    }

    public final boolean X() {
        FlingHelper i3;
        l lVar = this.controller;
        if (lVar != null && (i3 = lVar.i()) != null) {
            return i3.d();
        }
        return false;
    }

    public final void Y(long startTimeUs, long endTimeUs) {
        Z(startTimeUs, endTimeUs, true);
    }

    public final void Z(long startTimeUs, long endTimeUs, boolean needSeek) {
        if (this.isSticker) {
            SliderView C = C();
            float P = P();
            Intrinsics.checkNotNull(this.controller);
            C.setX((P + r2.J(startTimeUs)) - C().getWidth());
            SliderView I = I();
            float P2 = P();
            Intrinsics.checkNotNull(this.controller);
            I.setX(P2 + r2.J(endTimeUs));
            i0((C().getX() - P()) + C().getWidth());
            j0(I().getX());
        } else {
            SliderView C2 = C();
            float T = T(0);
            Intrinsics.checkNotNull(this.controller);
            C2.setX(T + r3.J(startTimeUs) + (this.videoTrackPadding * 2));
            SliderView I2 = I();
            float T2 = T(0);
            Intrinsics.checkNotNull(this.controller);
            I2.setX(T2 + r2.J(endTimeUs) + I().getWidth());
        }
        this.leftSliderStartTime.postValue(new Pair<>(Long.valueOf(startTimeUs), Boolean.valueOf(needSeek)));
        this.rightSliderEndTime.postValue(new Pair<>(Long.valueOf(endTimeUs), Boolean.FALSE));
        setSliderBorderViewX(C().getX());
        ms.a.a("VideoTrackContainerView", "[moveFreedomSliderView] rightSliderX = " + I().getX());
        setSliderBorderScaleX(((I().getX() - C().getX()) - ((float) C().getWidth())) / ((float) this.videoTrackPadding));
        k0(startTimeUs, endTimeUs);
    }

    public final void a0() {
        FlingHelper i3;
        this.isInMoving = false;
        l lVar = this.controller;
        if (lVar != null && (i3 = lVar.i()) != null) {
            i3.g();
        }
    }

    public final void d0(int width) {
        ViewGroup.LayoutParams layoutParams = N().getLayoutParams();
        layoutParams.width = width;
        N().setLayoutParams(layoutParams);
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

    public final void e0(long startTimeUs, long endTimeUs) {
        if (startTimeUs == 0 && endTimeUs == 0) {
            return;
        }
        if (this.isSticker) {
            SliderView C = C();
            float D = D();
            Intrinsics.checkNotNull(this.controller);
            C.setX(D + r2.J(startTimeUs));
            SliderView I = I();
            float P = P();
            Intrinsics.checkNotNull(this.controller);
            I.setX(P + r2.J(endTimeUs));
            i0((C().getX() - P()) + C().getWidth());
            j0(I().getX());
        } else {
            SliderView C2 = C();
            float Q = Q();
            Intrinsics.checkNotNull(this.controller);
            C2.setX(Q + r2.J(startTimeUs) + (this.videoTrackPadding * 2));
            SliderView I2 = I();
            float Q2 = Q();
            Intrinsics.checkNotNull(this.controller);
            I2.setX(Q2 + r2.J(endTimeUs) + I().getWidth());
        }
        setSliderBorderViewX(C().getX());
        setSliderBorderScaleX(((I().getX() - C().getX()) - C().getWidth()) / this.videoTrackPadding);
        k0(startTimeUs, endTimeUs);
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x0056  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0060  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0065  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x0058  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void f0(@NotNull List<VideoTrackModel> clipModels, @NotNull List<Object> transitionList) {
        i63.b m3;
        Object obj;
        TimelinePanelViewController panelViewController;
        VideoTrackTimelineView r16;
        boolean z16;
        int lastIndex;
        l lVar;
        final com.tencent.mobileqq.wink.editor.clipping.timeline.reorder.a aVar;
        ViewGroup contentView;
        int lastIndex2;
        Intrinsics.checkNotNullParameter(clipModels, "clipModels");
        Intrinsics.checkNotNullParameter(transitionList, "transitionList");
        l lVar2 = this.controller;
        if (lVar2 != null && (m3 = lVar2.m()) != null) {
            x(this.videoTrackViews, clipModels.size());
            Iterator<T> it = clipModels.iterator();
            int i3 = 0;
            while (true) {
                obj = null;
                CommonConfig commonConfig = null;
                if (!it.hasNext()) {
                    break;
                }
                Object next = it.next();
                int i16 = i3 + 1;
                if (i3 < 0) {
                    CollectionsKt__CollectionsKt.throwIndexOverflow();
                }
                final VideoTrackModel videoTrackModel = (VideoTrackModel) next;
                List<VideoTrackTimelineView> list = this.videoTrackViews;
                if (i3 >= 0) {
                    lastIndex2 = CollectionsKt__CollectionsKt.getLastIndex(list);
                    if (i3 <= lastIndex2) {
                        r16 = list.get(i3);
                        VideoTrackTimelineView videoTrackTimelineView = r16;
                        boolean z17 = true;
                        if (i3 != 0) {
                            z16 = true;
                        } else {
                            z16 = false;
                        }
                        lastIndex = CollectionsKt__CollectionsKt.getLastIndex(clipModels);
                        if (i3 != lastIndex) {
                            z17 = false;
                        }
                        lVar = this.controller;
                        if (lVar != null) {
                            commonConfig = lVar.h();
                        }
                        videoTrackTimelineView.J1(videoTrackModel, z16, z17, commonConfig);
                        aVar = this.itemLongClickListener;
                        if (aVar != null && (contentView = videoTrackTimelineView.getContentView()) != null) {
                            contentView.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.tencent.mobileqq.wink.editor.clipping.timeline.widget.videotrack.k
                                @Override // android.view.View.OnLongClickListener
                                public final boolean onLongClick(View view) {
                                    boolean g06;
                                    g06 = VideoTrackContainerView.g0(com.tencent.mobileqq.wink.editor.clipping.timeline.reorder.a.this, videoTrackModel, this, view);
                                    return g06;
                                }
                            });
                        }
                        i3 = i16;
                    }
                }
                r16 = r(m3);
                VideoTrackTimelineView videoTrackTimelineView2 = r16;
                boolean z172 = true;
                if (i3 != 0) {
                }
                lastIndex = CollectionsKt__CollectionsKt.getLastIndex(clipModels);
                if (i3 != lastIndex) {
                }
                lVar = this.controller;
                if (lVar != null) {
                }
                videoTrackTimelineView2.J1(videoTrackModel, z16, z172, commonConfig);
                aVar = this.itemLongClickListener;
                if (aVar != null) {
                    contentView.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.tencent.mobileqq.wink.editor.clipping.timeline.widget.videotrack.k
                        @Override // android.view.View.OnLongClickListener
                        public final boolean onLongClick(View view) {
                            boolean g06;
                            g06 = VideoTrackContainerView.g0(com.tencent.mobileqq.wink.editor.clipping.timeline.reorder.a.this, videoTrackModel, this, view);
                            return g06;
                        }
                    });
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
            VideoTrackTimelineView videoTrackTimelineView3 = (VideoTrackTimelineView) obj;
            if (videoTrackTimelineView3 != null) {
                videoTrackTimelineView3.bringToFront();
            }
            c0();
            l lVar3 = this.controller;
            if (lVar3 != null && (panelViewController = lVar3.getPanelViewController()) != null) {
                panelViewController.q();
            }
        }
    }

    @Override // android.widget.HorizontalScrollView
    public void fling(int velocityX) {
        FlingHelper i3;
        l lVar = this.controller;
        if (lVar != null && (i3 = lVar.i()) != null) {
            i3.f(velocityX, getScrollX(), N().getMeasuredWidth(), this.listener);
        }
    }

    public final void h0(@NotNull String uuid) {
        Intrinsics.checkNotNullParameter(uuid, "uuid");
        List<VideoTrackTimelineView> list = this.videoTrackViews;
        ArrayList arrayList = new ArrayList();
        for (Object obj : list) {
            if (Intrinsics.areEqual(((VideoTrackTimelineView) obj).F1(), uuid)) {
                arrayList.add(obj);
            }
        }
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            ((VideoTrackTimelineView) it.next()).I1();
        }
    }

    public final void i0(float width) {
        if (!this.isSticker) {
            return;
        }
        ViewGroup.LayoutParams layoutParams = y().getLayoutParams();
        layoutParams.width = (int) width;
        y().setLayoutParams(layoutParams);
    }

    public final void j0(float start) {
        if (!this.isSticker) {
            return;
        }
        ViewGroup.LayoutParams layoutParams = A().getLayoutParams();
        Intrinsics.checkNotNull(layoutParams, "null cannot be cast to non-null type android.widget.FrameLayout.LayoutParams");
        FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) layoutParams;
        int i3 = (int) start;
        layoutParams2.setMarginStart(i3);
        int i16 = this.reorderContainerWidth;
        if (i16 != 0) {
            layoutParams2.width = (i16 - i3) + ((int) P());
        }
        A().setLayoutParams(layoutParams2);
    }

    public final void l0() {
        this.hasUpEvent = false;
    }

    public final void m0(int offset) {
        for (VideoTrackTimelineView videoTrackTimelineView : this.videoTrackViews) {
            videoTrackTimelineView.R1();
            videoTrackTimelineView.K1(offset);
        }
    }

    public final void n0() {
        if (this.canVibrate) {
            s.f384267a.a(this);
        }
    }

    @Override // android.view.View
    protected void onScrollChanged(int l3, int t16, int oldl, int oldt) {
        l lVar = this.controller;
        if (lVar != null) {
            lVar.C(l3);
        }
        int i3 = this.scrollOffset + (l3 - oldl);
        this.scrollOffset = i3;
        m0(i3);
        b0();
    }

    @Override // android.widget.HorizontalScrollView, android.view.View
    public boolean onTouchEvent(@NotNull MotionEvent ev5) {
        FlingHelper i3;
        PanelEventHandler k3;
        PanelEventHandler k16;
        Intrinsics.checkNotNullParameter(ev5, "ev");
        boolean onTouchEvent = super.onTouchEvent(ev5);
        int action = ev5.getAction();
        if (action != 0) {
            if (action != 1) {
                if (action == 2 && onTouchEvent && !this.isInMoving) {
                    l lVar = this.controller;
                    if (lVar != null && (k16 = lVar.k()) != null) {
                        k16.a(new com.tencent.mobileqq.wink.editor.clipping.timeline.widget.panel.event.e());
                    }
                    this.isInMoving = true;
                }
            } else if (this.isInMoving && !X()) {
                this.isInMoving = false;
                l lVar2 = this.controller;
                if (lVar2 != null && (k3 = lVar2.k()) != null) {
                    k3.a(new com.tencent.mobileqq.wink.editor.clipping.timeline.widget.panel.event.d(false));
                }
            }
        } else {
            l lVar3 = this.controller;
            if (lVar3 != null && (i3 = lVar3.i()) != null && i3.d()) {
                i3.g();
            }
        }
        return onTouchEvent;
    }

    public final void p() {
        int g16;
        k63.a aVar;
        k63.a aVar2;
        int g17;
        int g18;
        CommonConfig h16;
        LayoutConfig layoutConfig;
        CommonConfig h17;
        LayoutConfig layoutConfig2;
        int g19;
        CommonConfig h18;
        LayoutConfig layoutConfig3;
        CommonConfig h19;
        LayoutConfig layoutConfig4;
        this.sliderDurationView = w(R.id.f97525km);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, ViewUtils.dip2px(16.0f));
        l lVar = this.controller;
        if (lVar != null && (h19 = lVar.h()) != null && (layoutConfig4 = h19.getLayoutConfig()) != null) {
            g16 = layoutConfig4.getPanelStartOffset();
        } else {
            g16 = com.tencent.videocut.utils.o.g() / 2;
        }
        layoutParams.setMarginStart(g16);
        layoutParams.gravity = 80;
        layoutParams.bottomMargin = ViewUtils.dpToPx(5.0f);
        FrameLayout B = B();
        TextView textView = this.sliderDurationView;
        ImageView imageView = null;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("sliderDurationView");
            textView = null;
        }
        B.addView(textView, layoutParams);
        if (this.isSticker) {
            setBeginMaskView(new View(getContext()));
            y().setBackgroundResource(R.color.bdr);
            FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(0, -1);
            l lVar2 = this.controller;
            if (lVar2 != null && (h18 = lVar2.h()) != null && (layoutConfig3 = h18.getLayoutConfig()) != null) {
                g19 = layoutConfig3.getPanelStartOffset();
            } else {
                g19 = com.tencent.videocut.utils.o.g() / 2;
            }
            layoutParams2.setMarginStart(g19);
            B().addView(y(), layoutParams2);
        }
        setLeftFreedomSliderView(t(G()));
        SliderView C = C();
        if (this.isSticker) {
            aVar = this.newLeftSliderListener;
        } else {
            aVar = this.leftSliderListener;
        }
        C.setSliderListener(aVar);
        FrameLayout.LayoutParams layoutParams3 = new FrameLayout.LayoutParams(-2, -2);
        layoutParams3.setMarginStart(D());
        B().addView(C(), layoutParams3);
        if (this.isSticker) {
            setEndMaskView(new View(getContext()));
            A().setBackgroundResource(R.color.bdr);
            FrameLayout.LayoutParams layoutParams4 = new FrameLayout.LayoutParams(0, -1);
            layoutParams4.setMarginStart(com.tencent.videocut.utils.o.g());
            B().addView(A(), layoutParams4);
        }
        setRightFreedomSliderView(u(M()));
        SliderView I = I();
        if (this.isSticker) {
            aVar2 = this.newRightSliderListener;
        } else {
            aVar2 = this.rightSliderListener;
        }
        I.setSliderListener(aVar2);
        FrameLayout.LayoutParams layoutParams5 = new FrameLayout.LayoutParams(-2, -2);
        layoutParams5.setMarginStart(J());
        B().addView(I(), layoutParams5);
        this.sliderTopBorderView = v(R.id.f97545ko);
        FrameLayout.LayoutParams layoutParams6 = new FrameLayout.LayoutParams(this.videoTrackPadding, ViewUtils.dip2px(2.0f));
        l lVar3 = this.controller;
        if (lVar3 != null && (h17 = lVar3.h()) != null && (layoutConfig2 = h17.getLayoutConfig()) != null) {
            g17 = layoutConfig2.getPanelStartOffset();
        } else {
            g17 = com.tencent.videocut.utils.o.g() / 2;
        }
        layoutParams6.setMarginStart(g17);
        layoutParams6.gravity = 48;
        FrameLayout B2 = B();
        ImageView imageView2 = this.sliderTopBorderView;
        if (imageView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("sliderTopBorderView");
            imageView2 = null;
        }
        B2.addView(imageView2, layoutParams6);
        this.sliderBottomBorderView = v(R.id.f97515kl);
        FrameLayout.LayoutParams layoutParams7 = new FrameLayout.LayoutParams(this.videoTrackPadding, ViewUtils.dip2px(2.0f));
        l lVar4 = this.controller;
        if (lVar4 != null && (h16 = lVar4.h()) != null && (layoutConfig = h16.getLayoutConfig()) != null) {
            g18 = layoutConfig.getPanelStartOffset();
        } else {
            g18 = com.tencent.videocut.utils.o.g() / 2;
        }
        layoutParams7.setMarginStart(g18);
        layoutParams7.gravity = 80;
        FrameLayout B3 = B();
        ImageView imageView3 = this.sliderBottomBorderView;
        if (imageView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("sliderBottomBorderView");
        } else {
            imageView = imageView3;
        }
        B3.addView(imageView, layoutParams7);
    }

    public final void q() {
        Iterator<VideoTrackTimelineView> it = this.videoTrackViews.iterator();
        while (it.hasNext()) {
            N().removeView(it.next());
        }
        this.videoTrackViews.clear();
    }

    @Override // f63.b
    public void s(@NotNull f63.a<?> controller) {
        l lVar;
        Intrinsics.checkNotNullParameter(controller, "controller");
        if (controller instanceof l) {
            lVar = (l) controller;
        } else {
            lVar = null;
        }
        this.controller = lVar;
    }

    public final void setBeginMaskView(@NotNull View view) {
        Intrinsics.checkNotNullParameter(view, "<set-?>");
        this.beginMaskView = view;
    }

    public final void setCanVibrate(boolean z16) {
        this.canVibrate = z16;
    }

    public final void setClipTimeAdjust(boolean z16) {
        this.isClipTimeAdjust = z16;
    }

    public final void setDrawBitmapListener(@NotNull com.tencent.mobileqq.wink.editor.clipping.timeline.reorder.c listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        this.drawBitmapListener = listener;
    }

    public final void setEndMaskView(@NotNull View view) {
        Intrinsics.checkNotNullParameter(view, "<set-?>");
        this.endMaskView = view;
    }

    public final void setFreedomSliderViewVisible(int visible) {
        C().setVisibility(visible);
        I().setVisibility(visible);
        ImageView imageView = this.sliderTopBorderView;
        TextView textView = null;
        if (imageView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("sliderTopBorderView");
            imageView = null;
        }
        imageView.setVisibility(visible);
        ImageView imageView2 = this.sliderBottomBorderView;
        if (imageView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("sliderBottomBorderView");
            imageView2 = null;
        }
        imageView2.setVisibility(visible);
        TextView textView2 = this.sliderDurationView;
        if (textView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("sliderDurationView");
        } else {
            textView = textView2;
        }
        textView.setVisibility(visible);
    }

    public final void setHandleView(@Nullable View view) {
        this.handleView = view;
        this.hasDownEvent = false;
    }

    public final void setItemOnLongClickListener(@NotNull com.tencent.mobileqq.wink.editor.clipping.timeline.reorder.a listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        this.itemLongClickListener = listener;
    }

    public final void setLeftFreedomSliderView(@NotNull SliderView sliderView) {
        Intrinsics.checkNotNullParameter(sliderView, "<set-?>");
        this.leftFreedomSliderView = sliderView;
    }

    public final void setLeftSliderMovingTime(@NotNull MutableLiveData<Long> mutableLiveData) {
        Intrinsics.checkNotNullParameter(mutableLiveData, "<set-?>");
        this.leftSliderMovingTime = mutableLiveData;
    }

    public final void setLeftSliderStartTime(@NotNull MutableLiveData<Pair<Long, Boolean>> mutableLiveData) {
        Intrinsics.checkNotNullParameter(mutableLiveData, "<set-?>");
        this.leftSliderStartTime = mutableLiveData;
    }

    public final void setPositionChangedHandler(@Nullable t tVar) {
        this.positionChangedHandler = tVar;
    }

    public final void setRecordControlWidth(long endTimeUs) {
        l lVar = this.controller;
        Intrinsics.checkNotNull(lVar);
        this.reorderContainerWidth = lVar.J(endTimeUs);
    }

    public final void setRightFreedomSliderView(@NotNull SliderView sliderView) {
        Intrinsics.checkNotNullParameter(sliderView, "<set-?>");
        this.rightFreedomSliderView = sliderView;
    }

    public final void setRightSliderEndTime(@NotNull MutableLiveData<Pair<Long, Boolean>> mutableLiveData) {
        Intrinsics.checkNotNullParameter(mutableLiveData, "<set-?>");
        this.rightSliderEndTime = mutableLiveData;
    }

    public final void setRightSliderMovingTime(@NotNull MutableLiveData<Pair<Long, Long>> mutableLiveData) {
        Intrinsics.checkNotNullParameter(mutableLiveData, "<set-?>");
        this.rightSliderMovingTime = mutableLiveData;
    }

    public final void setSelectedType(int i3) {
        this.selectedType = i3;
    }

    public final void setSliderBorderScaleX(float scaleX) {
        ms.a.a("VideoTrackContainerView", "[setSliderBorderScaleX] " + scaleX);
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
        imageView.setX(C().getWidth() + x16);
        ImageView imageView2 = this.sliderBottomBorderView;
        if (imageView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("sliderBottomBorderView");
            imageView2 = null;
        }
        imageView2.setX(C().getWidth() + x16);
        TextView textView2 = this.sliderDurationView;
        if (textView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("sliderDurationView");
        } else {
            textView = textView2;
        }
        textView.setX(x16 + C().getWidth() + ViewUtils.dpToPx(5.0f));
    }

    public final void setSticker(boolean z16) {
        this.isSticker = z16;
    }

    public final void setVideoTrackPadding(int i3) {
        this.videoTrackPadding = i3;
    }

    @NotNull
    public final View y() {
        View view = this.beginMaskView;
        if (view != null) {
            return view;
        }
        Intrinsics.throwUninitializedPropertyAccessException("beginMaskView");
        return null;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public VideoTrackContainerView(@NotNull Context mContext, @Nullable AttributeSet attributeSet) {
        this(mContext, attributeSet, 0, 0, 12, null);
        Intrinsics.checkNotNullParameter(mContext, "mContext");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public VideoTrackContainerView(@NotNull Context mContext, @Nullable AttributeSet attributeSet, int i3) {
        this(mContext, attributeSet, i3, 0, 8, null);
        Intrinsics.checkNotNullParameter(mContext, "mContext");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public VideoTrackContainerView(@NotNull Context mContext, @Nullable AttributeSet attributeSet, int i3, int i16) {
        super(mContext, attributeSet, i3);
        Lazy lazy;
        Lazy lazy2;
        Intrinsics.checkNotNullParameter(mContext, "mContext");
        this.f319556q0 = new LinkedHashMap();
        this.selectedType = i16;
        this.MIN_STICKER_DURATION = 1000000L;
        this.STICKER_ABSORPTION_THRESHOLD_TIME_PERCENT = 0.02f;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<FrameLayout>() { // from class: com.tencent.mobileqq.wink.editor.clipping.timeline.widget.videotrack.VideoTrackContainerView$frameRootView$2
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
        lazy2 = LazyKt__LazyJVMKt.lazy(new Function0<RelativeLayout>() { // from class: com.tencent.mobileqq.wink.editor.clipping.timeline.widget.videotrack.VideoTrackContainerView$rootView$2
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
        this.leftSliderMovingTime = new MutableLiveData<>();
        this.rightSliderMovingTime = new MutableLiveData<>();
        B().addView(N(), new FrameLayout.LayoutParams(-1, -1));
        addView(B(), new FrameLayout.LayoutParams(-1, -1));
        setOverScrollMode(2);
        N().setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.wink.editor.clipping.timeline.widget.videotrack.j
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                VideoTrackContainerView.c(VideoTrackContainerView.this, view);
            }
        });
        this.listener = new c();
        this.timeLineViewListener = new h();
        this.selectListener = new g();
        this.leftSliderListener = new b();
        this.newLeftSliderListener = new d();
        this.rightSliderListener = new f();
        this.newRightSliderListener = new e();
    }

    public /* synthetic */ VideoTrackContainerView(Context context, AttributeSet attributeSet, int i3, int i16, int i17, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i17 & 2) != 0 ? null : attributeSet, (i17 & 4) != 0 ? 0 : i3, (i17 & 8) != 0 ? 0 : i16);
    }
}

package com.tencent.mobileqq.wink.editor.aielimination.doodle.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.PointF;
import android.graphics.RectF;
import android.os.Looper;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.core.internal.view.SupportMenu;
import androidx.exifinterface.media.ExifInterface;
import com.heytap.databaseengine.model.UserInfo;
import com.qq.e.comm.managers.plugin.PM;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.biz.pubaccount.util.api.impl.PublicAccountMessageUtilImpl;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.photo.MimeHelper;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.mtt.hippy.views.hippylist.ViewStickEventHelper;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.TypeIntrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u00b4\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b$\n\u0002\u0018\u0002\n\u0002\b\u0019\n\u0002\u0010!\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0014\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u0000 \u00ce\u00012\u00020\u00012\u00020\u0002:\u0005\u00cf\u0001T\u00d0\u0001B*\b\u0016\u0012\b\u0010\u00c8\u0001\u001a\u00030\u00c7\u0001\u0012\b\u0010\u001c\u001a\u0004\u0018\u00010\u0013\u0012\t\u0010\u00c9\u0001\u001a\u0004\u0018\u00010z\u00a2\u0006\u0006\b\u00ca\u0001\u0010\u00cb\u0001B5\b\u0016\u0012\b\u0010\u00c8\u0001\u001a\u00030\u00c7\u0001\u0012\b\u0010\u001c\u001a\u0004\u0018\u00010\u0013\u0012\t\u0010\u00c9\u0001\u001a\u0004\u0018\u00010z\u0012\t\u0010\u00cc\u0001\u001a\u0004\u0018\u00010<\u00a2\u0006\u0006\b\u00ca\u0001\u0010\u00cd\u0001J\b\u0010\u0004\u001a\u00020\u0003H\u0002J\b\u0010\u0005\u001a\u00020\u0003H\u0002J\u0010\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\u0010\u0010\n\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\u0010\u0010\u000b\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\u0018\u0010\u000f\u001a\u00020\u00032\u000e\u0010\u000e\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\r0\fH\u0002J\u0010\u0010\u0011\u001a\u00020\u00032\u0006\u0010\u0010\u001a\u00020\bH\u0002J\b\u0010\u0012\u001a\u00020\u0003H\u0002J\n\u0010\u0014\u001a\u0004\u0018\u00010\u0013H\u0002J\u0012\u0010\u0016\u001a\u00020\u00032\b\u0010\u0015\u001a\u0004\u0018\u00010\rH\u0002J(\u0010\u001b\u001a\u00020\u00032\u0006\u0010\u0017\u001a\u00020\u00062\u0006\u0010\u0018\u001a\u00020\u00062\u0006\u0010\u0019\u001a\u00020\u00062\u0006\u0010\u001a\u001a\u00020\u0006H\u0014J\u0018\u0010\u001e\u001a\u00020\u00032\b\u0010\u001c\u001a\u0004\u0018\u00010\u00132\u0006\u0010\u001d\u001a\u00020\bJ\u0010\u0010!\u001a\u00020\b2\u0006\u0010 \u001a\u00020\u001fH\u0016J\u0012\u0010$\u001a\u00020\u00032\b\u0010#\u001a\u0004\u0018\u00010\"H\u0016J\u000e\u0010&\u001a\u00020\u00032\u0006\u0010%\u001a\u00020\bJ\u0006\u0010(\u001a\u00020'J\u0010\u0010+\u001a\u00020\u00032\u0006\u0010*\u001a\u00020)H\u0014J\u0006\u0010-\u001a\u00020,J\u0006\u0010.\u001a\u00020,J\u0006\u0010/\u001a\u00020,J\u000e\u00101\u001a\u00020,2\u0006\u00100\u001a\u00020,J\u000e\u00103\u001a\u00020,2\u0006\u00102\u001a\u00020,J\u000e\u00105\u001a\u00020,2\u0006\u00104\u001a\u00020,J\u000e\u00107\u001a\u00020,2\u0006\u00106\u001a\u00020,J\u0016\u00109\u001a\u00020,2\u0006\u00100\u001a\u00020,2\u0006\u00108\u001a\u00020,J\u0016\u0010;\u001a\u00020,2\u0006\u00102\u001a\u00020,2\u0006\u0010:\u001a\u00020,J\u0010\u0010>\u001a\u00020\u00032\b\u0010=\u001a\u0004\u0018\u00010<J\u000e\u0010@\u001a\u00020\u00032\u0006\u0010?\u001a\u00020\bJ\b\u0010A\u001a\u00020\u0003H\u0016J\b\u0010B\u001a\u00020\u0003H\u0016J\u0010\u0010C\u001a\u00020\u00032\b\u0010\u0015\u001a\u0004\u0018\u00010\rJ\u0010\u0010D\u001a\u00020\u00032\b\u0010\u0015\u001a\u0004\u0018\u00010\rJ\b\u0010E\u001a\u00020\u0003H\u0016J\b\u0010F\u001a\u00020\u0003H\u0014J\b\u0010G\u001a\u00020\u0003H\u0016J\u0012\u0010J\u001a\u00020\u00032\b\u0010I\u001a\u0004\u0018\u00010HH\u0016J\n\u0010K\u001a\u0004\u0018\u00010HH\u0016J \u0010O\u001a\u00020\u00032\u0006\u0010L\u001a\u00020,2\u0006\u0010M\u001a\u00020,2\u0006\u0010N\u001a\u00020,H\u0016J\b\u0010P\u001a\u00020,H\u0016J\u0012\u0010S\u001a\u00020\u00032\b\u0010R\u001a\u0004\u0018\u00010QH\u0016J\n\u0010T\u001a\u0004\u0018\u00010QH\u0016J\u0012\u0010W\u001a\u00020\u00032\b\u0010V\u001a\u0004\u0018\u00010UH\u0016J\n\u0010X\u001a\u0004\u0018\u00010UH\u0016J\u0018\u0010[\u001a\u00020\u00032\u0006\u0010Y\u001a\u00020,2\u0006\u0010Z\u001a\u00020,H\u0016J\u0010\u0010\\\u001a\u00020\u00032\u0006\u0010Y\u001a\u00020,H\u0016J\b\u0010]\u001a\u00020,H\u0016J\u0010\u0010^\u001a\u00020\u00032\u0006\u0010Z\u001a\u00020,H\u0016J\b\u0010_\u001a\u00020,H\u0016J\u0010\u0010a\u001a\u00020\u00032\u0006\u0010`\u001a\u00020,H\u0016J\u0016\u0010d\u001a\u00020\u00032\u0006\u0010b\u001a\u00020,2\u0006\u0010c\u001a\u00020,J\u0006\u0010e\u001a\u00020\u0003J\b\u0010f\u001a\u00020,H\u0016J\u0010\u0010h\u001a\u00020\u00032\u0006\u0010g\u001a\u00020\bH\u0016J\u000e\u0010j\u001a\u00020\u00032\u0006\u0010i\u001a\u00020\bJ\u0010\u0010l\u001a\u00020\u00032\u0006\u0010k\u001a\u00020,H\u0016J\u0010\u0010n\u001a\u00020\u00032\u0006\u0010m\u001a\u00020,H\u0016J\u0012\u0010#\u001a\u00020\u00032\b\u0010\u0015\u001a\u0004\u0018\u00010\rH\u0016J\u0012\u0010p\u001a\u00020\u00032\b\u0010o\u001a\u0004\u0018\u00010\rH\u0016J\u0010\u0010q\u001a\u00020\b2\u0006\u0010\u0015\u001a\u00020\rH\u0016J\u0010\u0010r\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\r0\fH\u0016J\n\u0010s\u001a\u0004\u0018\u00010\u0013H\u0016J\b\u00104\u001a\u0004\u0018\u00010\u0013J \u0010v\u001a\u0004\u0018\u00010\u00132\u0006\u0010\u001c\u001a\u00020\u00132\u0006\u0010t\u001a\u00020\u00062\u0006\u0010u\u001a\u00020\u0006J\u0006\u00106\u001a\u00020,J\u0006\u0010\u0017\u001a\u00020\u0006J\u0006\u0010w\u001a\u00020\u0006R\u0014\u0010y\u001a\u00020\u00068\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bx\u0010CR\u0018\u0010}\u001a\u0004\u0018\u00010z8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b{\u0010|R\u0019\u0010\u0080\u0001\u001a\u0004\u0018\u00010\u00138\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b~\u0010\u007fR\u0019\u0010\u0081\u0001\u001a\u0004\u0018\u00010\u00138\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0018\u0010\u007fR\u0018\u0010\u0083\u0001\u001a\u00020,8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0007\n\u0005\b\u0082\u0001\u0010\tR\u0017\u0010\u0084\u0001\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0016\u0010CR\u0017\u0010\u0085\u0001\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b_\u0010CR\u0017\u0010\u0086\u0001\u001a\u00020,8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0014\u0010\tR\u0017\u0010\u0087\u0001\u001a\u00020,8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b&\u0010\tR\u0017\u0010\u0088\u0001\u001a\u00020,8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\t\u0010\tR\u0017\u0010\u0089\u0001\u001a\u00020,8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0004\u0010\tR\u0017\u0010\u008a\u0001\u001a\u00020,8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\tR\u0017\u0010\u008b\u0001\u001a\u00020,8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bC\u0010\tR\u0017\u0010\u008c\u0001\u001a\u00020,8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bD\u0010\tR\u0017\u0010\u008d\u0001\u001a\u00020,8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\tR\u0017\u0010\u008e\u0001\u001a\u00020,8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\tR\u001a\u0010\u0090\u0001\u001a\u0004\u0018\u00010H8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0007\n\u0005\bp\u0010\u008f\u0001R\u0018\u0010\u0092\u0001\u001a\u00020\b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0007\n\u0005\bE\u0010\u0091\u0001R\u0018\u0010\u0093\u0001\u001a\u00020\b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0007\n\u0005\b@\u0010\u0091\u0001R\u001f\u0010\u0096\u0001\u001a\u000b\u0012\u0006\u0012\u0004\u0018\u00010\r0\u0094\u00018\u0002X\u0082\u0004\u00a2\u0006\u0007\n\u0005\be\u0010\u0095\u0001R\u001f\u0010\u0097\u0001\u001a\u000b\u0012\u0006\u0012\u0004\u0018\u00010\r0\u0094\u00018\u0002X\u0082\u0004\u00a2\u0006\u0007\n\u0005\b5\u0010\u0095\u0001R\u001a\u0010\u0099\u0001\u001a\u0004\u0018\u00010Q8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0007\n\u0005\b7\u0010\u0098\u0001R\u001a\u0010\u009b\u0001\u001a\u0004\u0018\u00010U8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0007\n\u0005\b9\u0010\u009a\u0001R\u0017\u0010\u009c\u0001\u001a\u00020,8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b;\u0010\tR\u0017\u0010\u009d\u0001\u001a\u00020,8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b1\u0010\tR\u001a\u0010\u009f\u0001\u001a\u0004\u0018\u00010<8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0007\n\u0005\b3\u0010\u009e\u0001R\u001e\u0010\u00a3\u0001\u001a\u00070\u00a0\u0001R\u00020\u00008\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u00a1\u0001\u0010\u00a2\u0001R\u0017\u0010\u00a6\u0001\u001a\u00020'8\u0002X\u0082\u0004\u00a2\u0006\b\n\u0006\b\u00a4\u0001\u0010\u00a5\u0001R\u0018\u0010\u00aa\u0001\u001a\u00030\u00a7\u00018\u0002X\u0082\u0004\u00a2\u0006\b\n\u0006\b\u00a8\u0001\u0010\u00a9\u0001R \u0010\u00ae\u0001\u001a\t\u0018\u00010\u00ab\u0001R\u00020\u00008\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u00ac\u0001\u0010\u00ad\u0001R\u0018\u0010\u00b0\u0001\u001a\u00020,8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0007\n\u0005\b\u00af\u0001\u0010\tR\u0018\u0010\u00b2\u0001\u001a\u00020,8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0007\n\u0005\b\u00b1\u0001\u0010\tR \u0010\u00b4\u0001\u001a\u000b\u0012\u0006\u0012\u0004\u0018\u00010\r0\u0094\u00018\u0002X\u0082\u0004\u00a2\u0006\b\n\u0006\b\u00b3\u0001\u0010\u0095\u0001R\u001e\u0010\u00b6\u0001\u001a\t\u0012\u0004\u0012\u00020\r0\u0094\u00018\u0002X\u0082\u0004\u00a2\u0006\b\n\u0006\b\u00b5\u0001\u0010\u0095\u0001R\u001a\u0010\u00b8\u0001\u001a\u0004\u0018\u00010\u00138\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0007\n\u0005\b\u00b7\u0001\u0010\u007fR\u0018\u0010\u00ba\u0001\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0007\n\u0005\b\u00b9\u0001\u0010CR\u001b\u0010\u00bd\u0001\u001a\u0004\u0018\u00010)8\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u00bb\u0001\u0010\u00bc\u0001R \u0010\u00bf\u0001\u001a\t\u0018\u00010\u00ab\u0001R\u00020\u00008\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u00be\u0001\u0010\u00ad\u0001R\u0018\u0010\u00c3\u0001\u001a\u00030\u00c0\u00018\u0002X\u0082\u0004\u00a2\u0006\b\n\u0006\b\u00c1\u0001\u0010\u00c2\u0001R\u001b\u0010\u00c6\u0001\u001a\u0004\u0018\u00010\"8\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u00c4\u0001\u0010\u00c5\u0001\u00a8\u0006\u00d1\u0001"}, d2 = {"Lcom/tencent/mobileqq/wink/editor/aielimination/doodle/view/DoodleView;", "Landroid/widget/FrameLayout;", "Lcom/tencent/mobileqq/wink/editor/aielimination/doodle/view/c;", "", "G", "H", "", "flag", "", UserInfo.SEX_FEMALE, "k", "o", "", "Lcom/tencent/mobileqq/wink/editor/aielimination/doodle/view/e;", "items", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "drawAll", "K", "L", "Landroid/graphics/Bitmap;", "D", PublicAccountMessageUtilImpl.ITEM_STRUCT_FIRST_LEVEL_NAME, QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "w", tl.h.F, "oldw", "oldh", MosaicConstants$JsFunction.FUNC_ON_SIZE_CHANGED, MimeHelper.IMAGE_SUBTYPE_BITMAP, "isInit", "setOriginBitmap", "Landroid/view/MotionEvent;", "event", "dispatchTouchEvent", "Landroid/view/View$OnTouchListener;", "l", "setOnTouchListener", "originImageVisible", "E", "Landroid/graphics/RectF;", QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, "Landroid/graphics/Canvas;", PM.CANVAS, "dispatchDraw", "", ReportConstant.COSTREPORT_PREFIX, "t", "u", "touchX", "V", "touchY", "W", HippyTKDListViewAdapter.X, BdhLogUtil.LogTag.Tag_Req, "y", ExifInterface.LATITUDE_SOUTH, "doodleX", "T", "doodleY", "U", "Lcom/tencent/mobileqq/wink/editor/aielimination/doodle/view/h;", "touchGestureDetector", "setDefaultTouchDetector", ViewStickEventHelper.IS_SHOW, "P", "invalidate", "refresh", "I", "J", "N", NodeProps.ON_DETACHED_FROM_WINDOW, DomainData.DOMAIN_NAME, "Lcom/tencent/mobileqq/wink/editor/aielimination/doodle/view/d;", "color", "setColor", "getColor", "scale", "pivotX", "pivotY", "setDoodleScale", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "Lcom/tencent/mobileqq/wink/editor/aielimination/doodle/view/f;", "pen", "setPen", "a", "Lcom/tencent/mobileqq/wink/editor/aielimination/doodle/view/g;", "shape", "setShape", "getShape", "transX", "transY", "setDoodleTranslation", "setDoodleTranslationX", "B", "setDoodleTranslationY", BdhLogUtil.LogTag.Tag_Conn, "paintSize", "setSize", "radius", "lineWidth", "p", AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, "getSize", "isDrawableOutside", "setIsDrawableOutside", "scrollingDoodle", "setScrollingDoodle", "minScale", "setDoodleMinScale", "maxScale", "setDoodleMaxScale", "doodleItem", "M", "X", "r", "getBitmap", "width", "height", "O", "v", "d", "mCloseDrawableWidth", "Lz53/d;", "e", "Lz53/d;", "mDoodleListener", "f", "Landroid/graphics/Bitmap;", "mBitmap", "mCloseBitmap", "i", "mCenterScale", "mCenterHeight", "mCenterWidth", "mCentreTranX", "mCentreTranY", "mRotateScale", "mScale", "mTransX", "mTransY", "mMinScale", "mMaxScale", "mSize", "Lcom/tencent/mobileqq/wink/editor/aielimination/doodle/view/d;", "mColor", "Z", "mIsDrawableOutside", "mReady", "", "Ljava/util/List;", "mItemStack", "mRedoItemStack", "Lcom/tencent/mobileqq/wink/editor/aielimination/doodle/view/f;", "mPen", "Lcom/tencent/mobileqq/wink/editor/aielimination/doodle/view/g;", "mShape", "mTouchX", "mTouchY", "Lcom/tencent/mobileqq/wink/editor/aielimination/doodle/view/h;", "mDefaultTouchDetector", "Lcom/tencent/mobileqq/wink/editor/aielimination/doodle/view/DoodleView$ForegroundView;", "a0", "Lcom/tencent/mobileqq/wink/editor/aielimination/doodle/view/DoodleView$ForegroundView;", "mForegroundView", "b0", "Landroid/graphics/RectF;", "mDoodleBound", "Landroid/graphics/PointF;", "c0", "Landroid/graphics/PointF;", "mTempPoint", "Lcom/tencent/mobileqq/wink/editor/aielimination/doodle/view/DoodleView$BackgroundView;", "d0", "Lcom/tencent/mobileqq/wink/editor/aielimination/doodle/view/DoodleView$BackgroundView;", "mOriginView", "e0", "cursorLineWidth", "f0", "cursorRadius", "g0", "mItemStackOnViewCanvas", "h0", "mPendingItemsDrawToBitmap", "i0", "mDoodleBitmap", "j0", "mFlags", "k0", "Landroid/graphics/Canvas;", "mDoodleBitmapCanvas", "l0", "mBackgroundView", "Landroid/graphics/Matrix;", "m0", "Landroid/graphics/Matrix;", "mTouchEventMatrix", "n0", "Landroid/view/View$OnTouchListener;", "mOnTouchListener", "Landroid/content/Context;", "context", "listener", "<init>", "(Landroid/content/Context;Landroid/graphics/Bitmap;Lz53/d;)V", "defaultDetector", "(Landroid/content/Context;Landroid/graphics/Bitmap;Lz53/d;Lcom/tencent/mobileqq/wink/editor/aielimination/doodle/view/h;)V", "p0", "BackgroundView", "ForegroundView", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes21.dex */
public final class DoodleView extends FrameLayout implements c {

    /* renamed from: C, reason: from kotlin metadata */
    private int mCenterWidth;

    /* renamed from: D, reason: from kotlin metadata */
    private float mCentreTranX;

    /* renamed from: E, reason: from kotlin metadata */
    private float mCentreTranY;

    /* renamed from: F, reason: from kotlin metadata */
    private float mRotateScale;

    /* renamed from: G, reason: from kotlin metadata */
    private float mScale;

    /* renamed from: H, reason: from kotlin metadata */
    private float mTransX;

    /* renamed from: I, reason: from kotlin metadata */
    private float mTransY;

    /* renamed from: J, reason: from kotlin metadata */
    private float mMinScale;

    /* renamed from: K, reason: from kotlin metadata */
    private float mMaxScale;

    /* renamed from: L, reason: from kotlin metadata */
    private float mSize;

    /* renamed from: M, reason: from kotlin metadata */
    @Nullable
    private d mColor;

    /* renamed from: N, reason: from kotlin metadata */
    private boolean mIsDrawableOutside;

    /* renamed from: P, reason: from kotlin metadata */
    private boolean mReady;

    /* renamed from: Q, reason: from kotlin metadata */
    @NotNull
    private final List<e> mItemStack;

    /* renamed from: R, reason: from kotlin metadata */
    @NotNull
    private final List<e> mRedoItemStack;

    /* renamed from: S, reason: from kotlin metadata */
    @Nullable
    private f mPen;

    /* renamed from: T, reason: from kotlin metadata */
    @Nullable
    private g mShape;

    /* renamed from: U, reason: from kotlin metadata */
    private float mTouchX;

    /* renamed from: V, reason: from kotlin metadata */
    private float mTouchY;

    /* renamed from: W, reason: from kotlin metadata */
    @Nullable
    private h mDefaultTouchDetector;

    /* renamed from: a0, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private ForegroundView mForegroundView;

    /* renamed from: b0, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final RectF mDoodleBound;

    /* renamed from: c0, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final PointF mTempPoint;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private final int mCloseDrawableWidth;

    /* renamed from: d0, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private BackgroundView mOriginView;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private z53.d mDoodleListener;

    /* renamed from: e0, reason: collision with root package name and from kotlin metadata */
    private float cursorLineWidth;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private Bitmap mBitmap;

    /* renamed from: f0, reason: collision with root package name and from kotlin metadata */
    private float cursorRadius;

    /* renamed from: g0, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final List<e> mItemStackOnViewCanvas;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private Bitmap mCloseBitmap;

    /* renamed from: h0, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final List<e> mPendingItemsDrawToBitmap;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private float mCenterScale;

    /* renamed from: i0, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private Bitmap mDoodleBitmap;

    /* renamed from: j0, reason: collision with root package name and from kotlin metadata */
    private int mFlags;

    /* renamed from: k0, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private Canvas mDoodleBitmapCanvas;

    /* renamed from: l0, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private BackgroundView mBackgroundView;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private int mCenterHeight;

    /* renamed from: m0, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Matrix mTouchEventMatrix;

    /* renamed from: n0, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private View.OnTouchListener mOnTouchListener;

    /* renamed from: o0, reason: collision with root package name */
    @NotNull
    public Map<Integer, View> f318850o0;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0004\u0018\u00002\u00020\u0001B\u001b\u0012\b\u0010\u0012\u001a\u0004\u0018\u00010\u0011\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0007\u00a2\u0006\u0004\b\u0013\u0010\u0014J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0014J\u0010\u0010\t\u001a\u00020\u00042\b\u0010\b\u001a\u0004\u0018\u00010\u0007J\u0006\u0010\n\u001a\u00020\u0004R$\u0010\b\u001a\u0004\u0018\u00010\u00078\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010\u00a8\u0006\u0015"}, d2 = {"Lcom/tencent/mobileqq/wink/editor/aielimination/doodle/view/DoodleView$BackgroundView;", "Landroid/view/View;", "Landroid/graphics/Canvas;", PM.CANVAS, "", "a", "onDraw", "Landroid/graphics/Bitmap;", MimeHelper.IMAGE_SUBTYPE_BITMAP, "c", "b", "d", "Landroid/graphics/Bitmap;", "getBitmap", "()Landroid/graphics/Bitmap;", "setBitmap", "(Landroid/graphics/Bitmap;)V", "Landroid/content/Context;", "context", "<init>", "(Lcom/tencent/mobileqq/wink/editor/aielimination/doodle/view/DoodleView;Landroid/content/Context;Landroid/graphics/Bitmap;)V", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes21.dex */
    public final class BackgroundView extends View {

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        @Nullable
        private Bitmap bitmap;

        /* renamed from: e, reason: collision with root package name */
        @NotNull
        public Map<Integer, View> f318852e = new LinkedHashMap();

        public BackgroundView(@Nullable Context context, @Nullable Bitmap bitmap) {
            super(context);
            this.bitmap = bitmap;
        }

        private final void a(Canvas canvas) {
            w53.b.a("DoodleView", "BackgroundView#doDraw");
            canvas.translate(DoodleView.this.t(), DoodleView.this.u());
            float s16 = DoodleView.this.s();
            canvas.scale(s16, s16);
            Bitmap bitmap = this.bitmap;
            if (bitmap != null) {
                canvas.drawBitmap(bitmap, 0.0f, 0.0f, (Paint) null);
            }
        }

        public final void b() {
            Bitmap bitmap = this.bitmap;
            if (bitmap != null) {
                bitmap.recycle();
            }
            this.bitmap = null;
        }

        public final void c(@Nullable Bitmap bitmap) {
            this.bitmap = bitmap;
        }

        @Override // android.view.View
        protected void onDraw(@NotNull Canvas canvas) {
            Intrinsics.checkNotNullParameter(canvas, "canvas");
            int save = canvas.save();
            a(canvas);
            canvas.restoreToCount(save);
        }

        public final void setBitmap(@Nullable Bitmap bitmap) {
            this.bitmap = bitmap;
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0004\u0018\u00002\u00020\u0001B\u0011\u0012\b\u0010\r\u001a\u0004\u0018\u00010\f\u00a2\u0006\u0004\b\u000e\u0010\u000fJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\n\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u0007H\u0016J\u0010\u0010\u000b\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0014\u00a8\u0006\u0010"}, d2 = {"Lcom/tencent/mobileqq/wink/editor/aielimination/doodle/view/DoodleView$ForegroundView;", "Landroid/view/View;", "Landroid/graphics/Canvas;", PM.CANVAS, "", "a", "b", "Landroid/view/MotionEvent;", "event", "", "onTouchEvent", "onDraw", "Landroid/content/Context;", "context", "<init>", "(Lcom/tencent/mobileqq/wink/editor/aielimination/doodle/view/DoodleView;Landroid/content/Context;)V", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes21.dex */
    public final class ForegroundView extends View {

        /* renamed from: d, reason: collision with root package name */
        @NotNull
        public Map<Integer, View> f318854d = new LinkedHashMap();

        public ForegroundView(@Nullable Context context) {
            super(context);
            setLayerType(1, null);
        }

        private final void a(Canvas canvas) {
            canvas.translate(DoodleView.this.t(), DoodleView.this.u());
            float s16 = DoodleView.this.s();
            canvas.scale(s16, s16);
            Bitmap bitmap = DoodleView.this.mDoodleBitmap;
            if (!DoodleView.this.mIsDrawableOutside && bitmap != null) {
                w53.b.a("DoodleView", "ForegroundView clipRect");
                canvas.clipRect(0, 0, bitmap.getWidth(), bitmap.getHeight());
            }
            w53.b.a("DoodleView", "ForegroundView doDraw");
            int save = canvas.save();
            List<e> list = DoodleView.this.mItemStackOnViewCanvas;
            for (e eVar : list) {
                if (eVar != null) {
                    eVar.draw(canvas);
                }
            }
            for (e eVar2 : list) {
                if (eVar2 != null) {
                    eVar2.b(canvas);
                }
            }
            canvas.restoreToCount(save);
            b(canvas);
            f fVar = DoodleView.this.mPen;
            if (fVar != null) {
                fVar.drawHelpers(canvas, DoodleView.this);
            }
            g gVar = DoodleView.this.mShape;
            if (gVar != null) {
                gVar.drawHelpers(canvas, DoodleView.this);
            }
        }

        private final void b(Canvas canvas) {
            boolean z16;
            float f16;
            float f17 = 0.0f;
            if (DoodleView.this.cursorRadius == 0.0f) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (z16) {
                return;
            }
            Paint paint = new Paint();
            paint.setColor(-1);
            paint.setStrokeWidth(DoodleView.this.cursorLineWidth);
            paint.setStyle(Paint.Style.STROKE);
            Paint paint2 = new Paint();
            paint2.setColor(getContext().getColor(R.color.cj6));
            paint2.setStyle(Paint.Style.FILL);
            Bitmap bitmap = DoodleView.this.mBitmap;
            if (bitmap != null) {
                f16 = bitmap.getWidth();
            } else {
                f16 = 0.0f;
            }
            Bitmap bitmap2 = DoodleView.this.mBitmap;
            if (bitmap2 != null) {
                f17 = bitmap2.getHeight();
            }
            w53.b.a("DoodleView", "drawCursorCircle" + f16 + ":" + f17);
            float f18 = (float) 2;
            float f19 = f16 / f18;
            float f26 = f17 / f18;
            canvas.drawCircle(f19, f26, DoodleView.this.cursorRadius + (DoodleView.this.cursorLineWidth * 1.5f), paint2);
            canvas.drawCircle(f19, f26, DoodleView.this.cursorRadius, paint);
        }

        @Override // android.view.View
        protected void onDraw(@NotNull Canvas canvas) {
            Intrinsics.checkNotNullParameter(canvas, "canvas");
            int save = canvas.save();
            a(canvas);
            canvas.restoreToCount(save);
        }

        @Override // android.view.View
        public boolean onTouchEvent(@NotNull MotionEvent event) {
            Intrinsics.checkNotNullParameter(event, "event");
            if (DoodleView.this.mDefaultTouchDetector != null) {
                h hVar = DoodleView.this.mDefaultTouchDetector;
                Intrinsics.checkNotNull(hVar);
                return hVar.onTouchEvent(event);
            }
            return false;
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public DoodleView(@NotNull Context context, @Nullable Bitmap bitmap, @Nullable z53.d dVar) {
        this(context, bitmap, dVar, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    private final Bitmap D() {
        Bitmap bitmap = this.mBitmap;
        if (bitmap == null) {
            return null;
        }
        Intrinsics.checkNotNull(bitmap);
        int width = bitmap.getWidth();
        Bitmap bitmap2 = this.mBitmap;
        Intrinsics.checkNotNull(bitmap2);
        Bitmap createBitmap = Bitmap.createBitmap(width, bitmap2.getHeight(), Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(createBitmap);
        canvas.drawColor(-1);
        for (e eVar : this.mItemStack) {
            if (eVar instanceof a) {
                ((a) eVar).h(canvas);
            }
        }
        return createBitmap;
    }

    private final boolean F(int flag) {
        if ((flag & this.mFlags) != 0) {
            return true;
        }
        return false;
    }

    private final void G() {
        Bitmap bitmap = this.mBitmap;
        if (bitmap == null) {
            return;
        }
        Intrinsics.checkNotNull(bitmap);
        int width = bitmap.getWidth();
        Bitmap bitmap2 = this.mBitmap;
        Intrinsics.checkNotNull(bitmap2);
        int height = bitmap2.getHeight();
        float f16 = width;
        float width2 = (f16 * 1.0f) / getWidth();
        float f17 = height;
        float height2 = (f17 * 1.0f) / getHeight();
        w53.b.a("DoodleView", "DoodleView init w: " + width + ", h: " + height + ", nw: " + width2 + ", nh: " + height2 + ", width: " + getWidth() + ", height: " + getHeight());
        if (width2 > height2) {
            this.mCenterScale = 1 / width2;
            this.mCenterWidth = getWidth();
            this.mCenterHeight = (int) (f17 * this.mCenterScale);
        } else {
            float f18 = 1 / height2;
            this.mCenterScale = f18;
            this.mCenterWidth = (int) (f16 * f18);
            this.mCenterHeight = getHeight();
        }
        this.mCentreTranX = (getWidth() - this.mCenterWidth) / 2.0f;
        int height3 = getHeight();
        int i3 = this.mCenterHeight;
        float f19 = (height3 - i3) / 2.0f;
        this.mCentreTranY = f19;
        w53.b.a("DoodleView", "DoodleView init mCentreTranX: " + this.mCentreTranX + ", mCentreTranY: " + f19 + ", mCenterScale: " + this.mCenterScale + ", mCenterWidth: " + this.mCenterWidth + ", mCenterHeight: " + i3);
        this.mTransY = 0.0f;
        this.mTransX = 0.0f;
        this.mScale = 1.0f;
        P(true);
    }

    private final void H() {
        Bitmap bitmap = this.mDoodleBitmap;
        if (bitmap != null) {
            bitmap.recycle();
        }
        Bitmap bitmap2 = this.mBitmap;
        Bitmap bitmap3 = null;
        Bitmap.Config config = null;
        if (bitmap2 != null) {
            if (bitmap2 != null) {
                config = bitmap2.getConfig();
            }
            bitmap3 = bitmap2.copy(config, true);
        }
        this.mDoodleBitmap = bitmap3;
        BackgroundView backgroundView = this.mBackgroundView;
        if (backgroundView != null) {
            backgroundView.c(bitmap3);
        }
        Bitmap bitmap4 = this.mDoodleBitmap;
        if (bitmap4 != null) {
            this.mDoodleBitmapCanvas = new Canvas(bitmap4);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void K(boolean drawAll) {
        List<e> list;
        Canvas canvas;
        H();
        if (drawAll) {
            list = this.mItemStack;
        } else {
            ArrayList arrayList = new ArrayList();
            arrayList.addAll(this.mItemStack);
            arrayList.removeAll(this.mItemStackOnViewCanvas);
            list = arrayList;
        }
        for (e eVar : list) {
            if ((eVar instanceof a) && (canvas = this.mDoodleBitmapCanvas) != null) {
                ((a) eVar).draw(canvas);
            }
        }
    }

    private final void L() {
        k(8);
        refresh();
    }

    private final void k(int flag) {
        this.mFlags = flag | this.mFlags;
    }

    private final void m(e item) {
        if (item != null && !this.mItemStack.contains(item)) {
            this.mItemStack.add(item);
            item.a();
            this.mPendingItemsDrawToBitmap.add(item);
            k(4);
            refresh();
            z53.d dVar = this.mDoodleListener;
            if (dVar != null) {
                dVar.a();
            }
        }
    }

    private final void o(int flag) {
        this.mFlags = (~flag) & this.mFlags;
    }

    private final void q(List<? extends e> items) {
        for (e eVar : items) {
            Canvas canvas = this.mDoodleBitmapCanvas;
            if (canvas != null && eVar != null) {
                eVar.draw(canvas);
            }
        }
    }

    public float A() {
        w53.b.a("DoodleView", "getDoodleScale: " + this.mScale);
        return this.mScale;
    }

    /* renamed from: B, reason: from getter */
    public float getMTransX() {
        return this.mTransX;
    }

    /* renamed from: C, reason: from getter */
    public float getMTransY() {
        return this.mTransY;
    }

    public final void E(boolean originImageVisible) {
        if (originImageVisible) {
            BackgroundView backgroundView = this.mOriginView;
            if (backgroundView != null) {
                backgroundView.setVisibility(0);
            }
            BackgroundView backgroundView2 = this.mBackgroundView;
            if (backgroundView2 != null) {
                backgroundView2.setVisibility(8);
            }
            this.mForegroundView.setVisibility(8);
            return;
        }
        BackgroundView backgroundView3 = this.mOriginView;
        if (backgroundView3 != null) {
            backgroundView3.setVisibility(8);
        }
        BackgroundView backgroundView4 = this.mBackgroundView;
        if (backgroundView4 != null) {
            backgroundView4.setVisibility(0);
        }
        this.mForegroundView.setVisibility(0);
    }

    public final void I(@Nullable e item) {
        if (!this.mItemStackOnViewCanvas.contains(item)) {
            this.mItemStackOnViewCanvas.add(item);
            if (this.mItemStack.contains(item)) {
                k(2);
            }
            refresh();
            return;
        }
        throw new RuntimeException("The item has been added");
    }

    public final void J(@Nullable e item) {
        if (this.mItemStackOnViewCanvas.remove(item)) {
            if (this.mItemStack.contains(item)) {
                k(2);
            } else {
                l(item);
            }
        }
        refresh();
    }

    public void M(@Nullable e doodleItem) {
        if (!this.mItemStack.remove(doodleItem)) {
            return;
        }
        this.mItemStackOnViewCanvas.remove(doodleItem);
        TypeIntrinsics.asMutableCollection(this.mPendingItemsDrawToBitmap).remove(doodleItem);
        if (doodleItem != null) {
            doodleItem.onRemove();
        }
        k(2);
        refresh();
        z53.d dVar = this.mDoodleListener;
        if (dVar != null) {
            dVar.a();
        }
    }

    public void N() {
        Bitmap D = D();
        z53.d dVar = this.mDoodleListener;
        if (dVar != null) {
            dVar.c(this, D, null);
        }
    }

    @Nullable
    public final Bitmap O(@NotNull Bitmap bitmap, int width, int height) {
        Intrinsics.checkNotNullParameter(bitmap, "bitmap");
        int width2 = bitmap.getWidth();
        int height2 = bitmap.getHeight();
        Matrix matrix = new Matrix();
        matrix.postScale(width / width2, height / height2);
        try {
            return Bitmap.createBitmap(bitmap, 0, 0, width2, height2, matrix, true);
        } catch (OutOfMemoryError unused) {
            return null;
        }
    }

    public final void P(boolean isShow) {
        int i3;
        if (isShow) {
            i3 = 2;
        } else {
            i3 = 16;
        }
        k(i3);
        refresh();
    }

    public final void Q() {
        w53.b.a("DoodleView", "stopDrawCursorCircle");
        this.cursorRadius = 0.0f;
        this.cursorLineWidth = 0.0f;
        refresh();
    }

    public final float R(float x16) {
        return (x16 * s()) + t();
    }

    public final float S(float y16) {
        return (y16 * s()) + u();
    }

    public final float T(float touchX, float doodleX) {
        return (((-doodleX) * s()) + touchX) - this.mCentreTranX;
    }

    public final float U(float touchY, float doodleY) {
        return (((-doodleY) * s()) + touchY) - this.mCentreTranY;
    }

    public final float V(float touchX) {
        return (touchX - t()) / s();
    }

    public final float W(float touchY) {
        return (touchY - u()) / s();
    }

    public boolean X(@NotNull e item) {
        Intrinsics.checkNotNullParameter(item, "item");
        if (this.mItemStack.size() > 0) {
            M(item);
            return true;
        }
        return false;
    }

    @Override // com.tencent.mobileqq.wink.editor.aielimination.doodle.view.c
    @Nullable
    /* renamed from: a, reason: from getter */
    public f getMPen() {
        return this.mPen;
    }

    /* JADX WARN: Code restructure failed: missing block: B:6:0x001b, code lost:
    
        if (r0.isRecycled() == true) goto L10;
     */
    @Override // android.view.ViewGroup, android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    protected void dispatchDraw(@NotNull Canvas canvas) {
        boolean z16;
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        w53.b.a("DoodleView", "dispatchDraw");
        Bitmap bitmap = this.mBitmap;
        if (bitmap != null) {
            if (bitmap != null) {
                z16 = true;
            }
            z16 = false;
            if (!z16) {
                if (F(2)) {
                    w53.b.a("DoodleView", "FLAG_RESET_BACKGROUND");
                    o(2);
                    o(4);
                    o(8);
                    K(false);
                    this.mPendingItemsDrawToBitmap.clear();
                    BackgroundView backgroundView = this.mBackgroundView;
                    if (backgroundView != null) {
                        backgroundView.invalidate();
                    }
                    BackgroundView backgroundView2 = this.mOriginView;
                    if (backgroundView2 != null) {
                        backgroundView2.invalidate();
                    }
                } else if (F(4)) {
                    w53.b.a("DoodleView", "FLAG_DRAW_PENDINGS_TO_BACKGROUND");
                    o(4);
                    o(8);
                    q(this.mPendingItemsDrawToBitmap);
                    this.mPendingItemsDrawToBitmap.clear();
                    BackgroundView backgroundView3 = this.mBackgroundView;
                    if (backgroundView3 != null) {
                        backgroundView3.invalidate();
                    }
                    BackgroundView backgroundView4 = this.mOriginView;
                    if (backgroundView4 != null) {
                        backgroundView4.invalidate();
                    }
                } else if (F(8)) {
                    w53.b.a("DoodleView", "FLAG_REFRESH_BACKGROUND");
                    o(8);
                    BackgroundView backgroundView5 = this.mBackgroundView;
                    if (backgroundView5 != null) {
                        backgroundView5.invalidate();
                    }
                    BackgroundView backgroundView6 = this.mOriginView;
                    if (backgroundView6 != null) {
                        backgroundView6.invalidate();
                    }
                } else if (F(16)) {
                    w53.b.a("DoodleView", "FLAG_SHOW_ORIGIN_BACKGROUND");
                    o(16);
                    H();
                    BackgroundView backgroundView7 = this.mBackgroundView;
                    if (backgroundView7 != null) {
                        backgroundView7.invalidate();
                    }
                    BackgroundView backgroundView8 = this.mOriginView;
                    if (backgroundView8 != null) {
                        backgroundView8.invalidate();
                    }
                }
                int save = canvas.save();
                super.dispatchDraw(canvas);
                canvas.restoreToCount(save);
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(@NotNull MotionEvent event) {
        Intrinsics.checkNotNullParameter(event, "event");
        View.OnTouchListener onTouchListener = this.mOnTouchListener;
        boolean z16 = false;
        if (onTouchListener != null && onTouchListener.onTouch(this, event)) {
            z16 = true;
        }
        if (z16) {
            return true;
        }
        this.mTouchX = event.getX();
        this.mTouchY = event.getY();
        MotionEvent transformedEvent = MotionEvent.obtain(event);
        this.mTouchEventMatrix.reset();
        transformedEvent.transform(this.mTouchEventMatrix);
        ForegroundView foregroundView = this.mForegroundView;
        Intrinsics.checkNotNullExpressionValue(transformedEvent, "transformedEvent");
        boolean onTouchEvent = foregroundView.onTouchEvent(transformedEvent);
        transformedEvent.recycle();
        return onTouchEvent;
    }

    @Override // com.tencent.mobileqq.wink.editor.aielimination.doodle.view.c
    @Nullable
    /* renamed from: getBitmap, reason: from getter */
    public Bitmap getMBitmap() {
        return this.mBitmap;
    }

    @Override // com.tencent.mobileqq.wink.editor.aielimination.doodle.view.c
    @Nullable
    /* renamed from: getColor, reason: from getter */
    public d getMColor() {
        return this.mColor;
    }

    @Override // com.tencent.mobileqq.wink.editor.aielimination.doodle.view.c
    @Nullable
    /* renamed from: getShape, reason: from getter */
    public g getMShape() {
        return this.mShape;
    }

    @Override // com.tencent.mobileqq.wink.editor.aielimination.doodle.view.c
    public float getSize() {
        return this.mSize / s();
    }

    @Override // android.view.View
    public void invalidate() {
        refresh();
    }

    public void l(@Nullable e item) {
        m(item);
        this.mRedoItemStack.clear();
    }

    public void n() {
        ArrayList arrayList = new ArrayList();
        arrayList.addAll(this.mItemStack);
        this.mItemStack.clear();
        this.mRedoItemStack.clear();
        this.mItemStackOnViewCanvas.clear();
        this.mPendingItemsDrawToBitmap.clear();
        int size = arrayList.size() - 1;
        if (size >= 0) {
            while (true) {
                int i3 = size - 1;
                e eVar = (e) arrayList.get(size);
                if (eVar != null) {
                    eVar.onRemove();
                }
                if (i3 < 0) {
                    break;
                } else {
                    size = i3;
                }
            }
        }
        k(2);
        refresh();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        w53.b.a("DoodleView", "onDetachedFromWindow...");
        Bitmap bitmap = this.mBitmap;
        if (bitmap != null) {
            bitmap.recycle();
        }
        this.mBitmap = null;
        Bitmap bitmap2 = this.mDoodleBitmap;
        if (bitmap2 != null) {
            bitmap2.recycle();
        }
        this.mDoodleBitmap = null;
        Bitmap bitmap3 = this.mCloseBitmap;
        if (bitmap3 != null) {
            bitmap3.recycle();
        }
        this.mCloseBitmap = null;
        BackgroundView backgroundView = this.mOriginView;
        if (backgroundView != null) {
            backgroundView.b();
        }
        BackgroundView backgroundView2 = this.mBackgroundView;
        if (backgroundView2 != null) {
            backgroundView2.b();
        }
    }

    @Override // android.view.View
    protected void onSizeChanged(int w3, int h16, int oldw, int oldh) {
        super.onSizeChanged(w3, h16, oldw, oldh);
        G();
        if (!this.mReady) {
            z53.d dVar = this.mDoodleListener;
            if (dVar != null) {
                dVar.b(this);
            }
            this.mReady = true;
        }
    }

    public final void p(float radius, float lineWidth) {
        w53.b.a("DoodleView", "drawCursorCircle");
        this.cursorRadius = radius / s();
        this.cursorLineWidth = lineWidth / s();
        refresh();
    }

    @NotNull
    public List<e> r() {
        ArrayList arrayList = new ArrayList();
        arrayList.addAll(this.mItemStack);
        return arrayList;
    }

    @Override // com.tencent.mobileqq.wink.editor.aielimination.doodle.view.c
    public void refresh() {
        if (Intrinsics.areEqual(Looper.myLooper(), Looper.getMainLooper())) {
            super.invalidate();
            this.mForegroundView.invalidate();
        } else {
            super.postInvalidate();
            this.mForegroundView.postInvalidate();
        }
    }

    public final float s() {
        return this.mCenterScale * this.mScale;
    }

    public void setColor(@Nullable d color) {
        this.mColor = color;
        refresh();
    }

    public final void setDefaultTouchDetector(@Nullable h touchGestureDetector) {
        this.mDefaultTouchDetector = touchGestureDetector;
    }

    public void setDoodleMaxScale(float maxScale) {
        this.mMaxScale = maxScale;
        setDoodleScale(this.mScale, 0.0f, 0.0f);
    }

    public void setDoodleMinScale(float minScale) {
        this.mMinScale = minScale;
        setDoodleScale(this.mScale, 0.0f, 0.0f);
    }

    public void setDoodleScale(float scale, float pivotX, float pivotY) {
        if (scale >= this.mMinScale && scale <= this.mMaxScale) {
            float R = R(pivotX);
            float S = S(pivotY);
            this.mScale = scale;
            this.mTransX = T(R, pivotX);
            this.mTransY = U(S, pivotY);
            k(8);
            refresh();
        }
    }

    public void setDoodleTranslation(float transX, float transY) {
        this.mTransX = transX;
        this.mTransY = transY;
        L();
    }

    public void setDoodleTranslationX(float transX) {
        this.mTransX = transX;
        L();
    }

    public void setDoodleTranslationY(float transY) {
        this.mTransY = transY;
        L();
    }

    public void setIsDrawableOutside(boolean isDrawableOutside) {
        this.mIsDrawableOutside = isDrawableOutside;
    }

    @Override // android.view.View
    public void setOnTouchListener(@Nullable View.OnTouchListener l3) {
        this.mOnTouchListener = l3;
        super.setOnTouchListener(l3);
    }

    public final void setOriginBitmap(@Nullable Bitmap bitmap, boolean isInit) {
        if (bitmap != null) {
            Bitmap bitmap2 = this.mBitmap;
            if (bitmap2 != null) {
                bitmap2.recycle();
            }
            this.mBitmap = bitmap;
            if (isInit) {
                BackgroundView backgroundView = this.mOriginView;
                if (backgroundView != null) {
                    backgroundView.c(bitmap.copy(bitmap.getConfig(), true));
                }
                G();
            }
            invalidate();
        }
    }

    public void setPen(@Nullable f pen) {
        if (pen != null) {
            this.mPen = pen;
            refresh();
            return;
        }
        throw new RuntimeException("Pen can't be null");
    }

    public final void setScrollingDoodle(boolean scrollingDoodle) {
        refresh();
    }

    public void setShape(@Nullable g shape) {
        if (shape != null) {
            this.mShape = shape;
            refresh();
            return;
        }
        throw new RuntimeException("Shape can't be null");
    }

    public void setSize(float paintSize) {
        this.mSize = paintSize;
        refresh();
    }

    public final float t() {
        return this.mCentreTranX + this.mTransX;
    }

    public final float u() {
        return this.mCentreTranY + this.mTransY;
    }

    /* renamed from: v, reason: from getter */
    public final int getMCenterHeight() {
        return this.mCenterHeight;
    }

    /* renamed from: w, reason: from getter */
    public final int getMCenterWidth() {
        return this.mCenterWidth;
    }

    /* JADX WARN: Code restructure failed: missing block: B:8:0x000f, code lost:
    
        if (r1 != false) goto L10;
     */
    @Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Bitmap x() {
        Bitmap bitmap = this.mCloseBitmap;
        if (bitmap != null) {
            boolean z16 = false;
            if (bitmap != null && bitmap.isRecycled()) {
                z16 = true;
            }
        }
        Bitmap bitmap2 = com.tencent.mobileqq.wink.utils.f.g(getContext().getResources(), R.drawable.on9);
        Intrinsics.checkNotNullExpressionValue(bitmap2, "bitmap");
        int i3 = this.mCloseDrawableWidth;
        float f16 = this.mCenterScale;
        this.mCloseBitmap = O(bitmap2, (int) (i3 / f16), (int) (i3 / f16));
        w53.b.a("DoodleView", "scaleBitmap " + bitmap2.getWidth() + ", " + bitmap2.getHeight() + ", " + this.mCloseDrawableWidth);
        return this.mCloseBitmap;
    }

    public final float y() {
        return (this.mCloseDrawableWidth / this.mCenterScale) / 2.0f;
    }

    @NotNull
    public final RectF z() {
        float f16 = this.mCenterWidth;
        float f17 = this.mScale;
        float f18 = f16 * f17;
        float f19 = this.mCenterHeight * f17;
        this.mTempPoint.x = R(0.0f);
        this.mTempPoint.y = S(0.0f);
        RectF rectF = this.mDoodleBound;
        PointF pointF = this.mTempPoint;
        float f26 = pointF.x;
        float f27 = pointF.y;
        rectF.set(f26, f27, f18 + f26, f19 + f27);
        return this.mDoodleBound;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DoodleView(@NotNull Context context, @Nullable Bitmap bitmap, @Nullable z53.d dVar, @Nullable h hVar) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        this.f318850o0 = new LinkedHashMap();
        this.mCloseDrawableWidth = ViewUtils.dip2px(30.0f);
        this.mRotateScale = 1.0f;
        this.mScale = 1.0f;
        this.mMinScale = 1.0f;
        this.mMaxScale = 3.0f;
        this.mItemStack = new ArrayList();
        this.mRedoItemStack = new ArrayList();
        this.mDoodleBound = new RectF();
        this.mTempPoint = new PointF();
        this.mItemStackOnViewCanvas = new ArrayList();
        this.mPendingItemsDrawToBitmap = new ArrayList();
        this.mTouchEventMatrix = new Matrix();
        setClipChildren(false);
        this.mBitmap = bitmap;
        this.mDoodleListener = dVar;
        this.mScale = 1.0f;
        this.mColor = new DoodleColor(SupportMenu.CATEGORY_MASK);
        this.mPen = DoodlePen.BRUSH;
        this.mShape = DoodleShape.HAND_WRITE;
        this.mDefaultTouchDetector = hVar;
        this.mForegroundView = new ForegroundView(context);
        this.mBackgroundView = new BackgroundView(context, this.mDoodleBitmap);
        BackgroundView backgroundView = new BackgroundView(context, this.mBitmap);
        this.mOriginView = backgroundView;
        addView(backgroundView, new ViewGroup.LayoutParams(-1, -1));
        addView(this.mBackgroundView, new ViewGroup.LayoutParams(-1, -1));
        addView(this.mForegroundView, new ViewGroup.LayoutParams(-1, -1));
    }
}

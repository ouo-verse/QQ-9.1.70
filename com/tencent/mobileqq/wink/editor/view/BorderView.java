package com.tencent.mobileqq.wink.editor.view;

import android.content.Context;
import android.graphics.Matrix;
import android.graphics.PointF;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.exifinterface.media.ExifInterface;
import camera.XEFFECT_MATERIALS_GENERAL_DATASTRUCT.MetaMaterial;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.ams.mosaic.jsengine.animation.basic.BasicAnimation;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mobileqq.wink.editor.sticker.WinkStickerModel;
import com.tencent.mobileqq.wink.editor.sticker.m;
import com.tencent.mobileqq.wink.utils.ac;
import com.tencent.mobileqq.wink.utils.u;
import com.tencent.mobileqq.winkreport.datong.WinkDTParamBuilder;
import com.tencent.mobileqq.winkreport.datong.WinkDaTongReportConstant;
import com.tencent.mobileqq.winkreport.datong.WinkDatongCurrentParams;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqmini.miniapp.widget.CanvasView;
import com.tencent.rmonitor.custom.ICustomDataEditor;
import com.tencent.videocut.model.Size;
import com.tencent.videocut.model.StickerModel;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0092\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\f\n\u0002\u0010\u0014\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u0006\n\u0002\b\u000e\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b&\n\u0002\u0010\t\n\u0002\b/\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0016\u0018\u0000 \u00c5\u00012\u00020\u0001:\u0007\n\u00c6\u0001\u0015\"M(B#\b\u0007\u0012\b\u0010\u00c0\u0001\u001a\u00030\u00bf\u0001\u0012\f\b\u0002\u0010\u00c2\u0001\u001a\u0005\u0018\u00010\u00c1\u0001\u00a2\u0006\u0006\b\u00c3\u0001\u0010\u00c4\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0012\u0010\n\u001a\u00020\t2\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0002J\b\u0010\u000b\u001a\u00020\u0002H\u0002JP\u0010\u0015\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\f2\u0006\u0010\u0010\u001a\u00020\f2\u0006\u0010\u0011\u001a\u00020\f2\u0006\u0010\u0012\u001a\u00020\f2\u0006\u0010\u0013\u001a\u00020\f2\u0006\u0010\u0014\u001a\u00020\fH\u0002J\u0018\u0010\u0018\u001a\u00020\u00022\u0006\u0010\u0016\u001a\u00020\u00042\u0006\u0010\u0017\u001a\u00020\tH\u0002J\u0012\u0010\u001b\u001a\u00020\f2\b\u0010\u001a\u001a\u0004\u0018\u00010\u0019H\u0002J\u0012\u0010\u001c\u001a\u00020\f2\b\u0010\u001a\u001a\u0004\u0018\u00010\u0019H\u0002J \u0010!\u001a\u00020\u00042\u0006\u0010\u001e\u001a\u00020\u001d2\u0006\u0010\u001f\u001a\u00020\f2\u0006\u0010 \u001a\u00020\fH\u0002JP\u0010\"\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\f2\u0006\u0010\u0010\u001a\u00020\f2\u0006\u0010\u0011\u001a\u00020\f2\u0006\u0010\u0012\u001a\u00020\f2\u0006\u0010\u0013\u001a\u00020\f2\u0006\u0010\u0014\u001a\u00020\fH\u0002J\u0010\u0010$\u001a\u00020\u00022\u0006\u0010#\u001a\u00020\tH\u0002J\u0010\u0010%\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0018\u0010(\u001a\u00020\u00042\u0006\u0010&\u001a\u00020\f2\u0006\u0010'\u001a\u00020\fH\u0002J\u0010\u0010+\u001a\u00020\t2\u0006\u0010*\u001a\u00020)H\u0002J\u0010\u0010 \u001a\u00020\t2\u0006\u0010*\u001a\u00020)H\u0002J\u0018\u0010.\u001a\u00020\u00022\u0006\u0010,\u001a\u00020\f2\u0006\u0010-\u001a\u00020\fH\u0002J\u0018\u0010/\u001a\u00020\u00022\u0006\u0010,\u001a\u00020\f2\u0006\u0010-\u001a\u00020\fH\u0002J \u00103\u001a\u00020\u00022\u0006\u00100\u001a\u00020\f2\u0006\u00101\u001a\u00020\f2\u0006\u00102\u001a\u00020\fH\u0002J\u0018\u00105\u001a\u00020\f2\u0006\u0010,\u001a\u0002042\u0006\u0010-\u001a\u000204H\u0002J\u0010\u00107\u001a\u00020\u00022\u0006\u00106\u001a\u00020\fH\u0002J\u0018\u00108\u001a\u00020\u00022\u0006\u00100\u001a\u00020\f2\u0006\u00101\u001a\u00020\fH\u0002J\u0010\u0010:\u001a\u00020\f2\u0006\u00109\u001a\u00020\fH\u0002J\u0010\u0010<\u001a\u00020\f2\u0006\u0010;\u001a\u00020\fH\u0002J8\u0010A\u001a\u00020\u00072\u0006\u0010=\u001a\u00020\u00072\u0006\u0010>\u001a\u00020\f2\u0006\u0010?\u001a\u00020\f2\u0006\u00100\u001a\u00020\f2\u0006\u00101\u001a\u00020\f2\u0006\u0010@\u001a\u00020\fH\u0002J\u0010\u0010B\u001a\u00020\t2\u0006\u0010*\u001a\u00020)H\u0016J\u0006\u0010D\u001a\u00020CJ\u0006\u0010E\u001a\u00020CJ\u0010\u0010F\u001a\u00020\t2\u0006\u0010*\u001a\u00020)H\u0016J\u0010\u0010G\u001a\u00020\t2\u0006\u0010*\u001a\u00020)H\u0016J\u0010\u0010H\u001a\u00020\t2\u0006\u0010*\u001a\u00020)H\u0016J\u0010\u0010K\u001a\u00020\u00022\b\u0010J\u001a\u0004\u0018\u00010IJ\u0006\u0010L\u001a\u00020\u0002J\u0006\u0010M\u001a\u00020\u0002J\u000e\u0010N\u001a\u00020\t2\u0006\u0010*\u001a\u00020)J\u0010\u0010O\u001a\u00020\t2\u0006\u0010*\u001a\u00020)H\u0016J\u0010\u0010R\u001a\u00020\u00022\b\u0010Q\u001a\u0004\u0018\u00010PJ\u000e\u0010U\u001a\u00020\u00022\u0006\u0010T\u001a\u00020SJ\u000e\u0010X\u001a\u00020\u00022\u0006\u0010W\u001a\u00020VJ\u000e\u0010Z\u001a\u00020\u00022\u0006\u0010Y\u001a\u00020\tJ\u0006\u0010[\u001a\u00020\u0002R\u0018\u0010]\u001a\u0004\u0018\u00010I8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bM\u0010\\R\u0018\u0010_\u001a\u0004\u0018\u00010S8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b(\u0010^R\u0018\u0010a\u001a\u0004\u0018\u00010P8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bL\u0010`R\u0018\u0010c\u001a\u0004\u0018\u00010V8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b<\u0010bR\u0014\u0010f\u001a\u00020\u00048\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bd\u0010eR\u0014\u0010g\u001a\u00020\u00048\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bA\u0010eR\u0014\u0010h\u001a\u00020C8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u000bR\u0016\u0010i\u001a\u00020\f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b3\u0010.R\u0016\u0010j\u001a\u00020\f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b/\u0010.R\u0016\u0010k\u001a\u00020\f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b.\u0010.R\u0016\u0010l\u001a\u00020\f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b[\u0010.R\"\u0010q\u001a\u00020C8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0003\u0010\u000b\u001a\u0004\bm\u0010n\"\u0004\bo\u0010pR\u0016\u0010r\u001a\u00020\f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000b\u0010.R\u0016\u0010s\u001a\u00020\f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0018\u0010.R$\u0010x\u001a\u0004\u0018\u00010\u00078\u0016@\u0016X\u0096\u000e\u00a2\u0006\u0012\n\u0004\b$\u0010t\u001a\u0004\bd\u0010u\"\u0004\bv\u0010wR\u0018\u0010z\u001a\u0004\u0018\u00010\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\by\u0010eR\u0018\u0010|\u001a\u0004\u0018\u00010\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b{\u0010eR\u0016\u0010\u007f\u001a\u00020}8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b~\u0010\u0018R\u001a\u0010\u0081\u0001\u001a\u0004\u0018\u00010\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0007\n\u0005\b\u0080\u0001\u0010eR\u0019\u0010\u0084\u0001\u001a\u00020\t8\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u0082\u0001\u0010\u0083\u0001R\u0018\u0010\u0086\u0001\u001a\u00020\f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0007\n\u0005\b\u0085\u0001\u0010.R\u0018\u0010\u0088\u0001\u001a\u00020\f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0007\n\u0005\b\u0087\u0001\u0010.R)\u0010\u008e\u0001\u001a\u00020\t8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0018\n\u0006\b\u0089\u0001\u0010\u0083\u0001\u001a\u0006\b\u008a\u0001\u0010\u008b\u0001\"\u0006\b\u008c\u0001\u0010\u008d\u0001R\u0019\u0010\u0090\u0001\u001a\u00020\t8\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u008f\u0001\u0010\u0083\u0001R\u0019\u0010\u0092\u0001\u001a\u00020\t8\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u0091\u0001\u0010\u0083\u0001R\u0019\u0010\u0094\u0001\u001a\u00020\t8\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u0093\u0001\u0010\u0083\u0001R\u0019\u0010\u0096\u0001\u001a\u00020\t8\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u0095\u0001\u0010\u0083\u0001R\u0019\u0010\u0098\u0001\u001a\u00020\t8\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u0097\u0001\u0010\u0083\u0001R\u0019\u0010\u009a\u0001\u001a\u00020\t8\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u0099\u0001\u0010\u0083\u0001R\u0019\u0010\u009c\u0001\u001a\u00020\t8\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u009b\u0001\u0010\u0083\u0001R)\u0010\u00a0\u0001\u001a\u00020\t8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0018\n\u0006\b\u009d\u0001\u0010\u0083\u0001\u001a\u0006\b\u009e\u0001\u0010\u008b\u0001\"\u0006\b\u009f\u0001\u0010\u008d\u0001R\u0019\u0010\u00a2\u0001\u001a\u00020\t8\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u00a1\u0001\u0010\u0083\u0001R(\u0010\u00a8\u0001\u001a\u00020\f8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0017\n\u0005\b\u00a3\u0001\u0010.\u001a\u0006\b\u00a4\u0001\u0010\u00a5\u0001\"\u0006\b\u00a6\u0001\u0010\u00a7\u0001R(\u0010\u00ac\u0001\u001a\u00020\f8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0017\n\u0005\b\u00a9\u0001\u0010.\u001a\u0006\b\u00aa\u0001\u0010\u00a5\u0001\"\u0006\b\u00ab\u0001\u0010\u00a7\u0001R,\u0010\u00b4\u0001\u001a\u0005\u0018\u00010\u00ad\u00018\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0018\n\u0006\b\u00ae\u0001\u0010\u00af\u0001\u001a\u0006\b\u00b0\u0001\u0010\u00b1\u0001\"\u0006\b\u00b2\u0001\u0010\u00b3\u0001R,\u0010\u00b8\u0001\u001a\u0005\u0018\u00010\u00ad\u00018\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0018\n\u0006\b\u00b5\u0001\u0010\u00af\u0001\u001a\u0006\b\u00b6\u0001\u0010\u00b1\u0001\"\u0006\b\u00b7\u0001\u0010\u00b3\u0001R\u0019\u0010\u00ba\u0001\u001a\u00020\t8\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u00b9\u0001\u0010\u0083\u0001R\u001a\u0010\u00bc\u0001\u001a\u0004\u0018\u00010\u00078\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0007\n\u0005\b\u00bb\u0001\u0010tR\u0019\u0010\u00be\u0001\u001a\u00020\t8\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u00bd\u0001\u0010\u0083\u0001R\u0015\u0010#\u001a\u00020\t8BX\u0082\u0004\u00a2\u0006\u0007\u001a\u0005\b\u001f\u0010\u008b\u0001\u00a8\u0006\u00c7\u0001"}, d2 = {"Lcom/tencent/mobileqq/wink/editor/view/BorderView;", "Landroid/widget/FrameLayout;", "", "H", "Landroid/graphics/PointF;", "correctPoint", BdhLogUtil.LogTag.Tag_Conn, "Lcom/tencent/mobileqq/wink/editor/sticker/WinkStickerModel;", com.tencent.mobileqq.msf.service.b.f250814q, "", "a", "I", "", "baseTopY", "baseBottomY", "baseRightX", "baseLeftX", "renderTopY", "renderTopX", "renderBottomY", "renderBottomX", "b", "pointF", "status", "J", "", "points", "l", "k", "Landroid/graphics/Matrix;", "matrix", HippyTKDListViewAdapter.X, "y", "j", "c", "isAdsorptionStatus", "K", "B", "left", "top", "e", "Landroid/view/MotionEvent;", "event", QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, "deltaX", "deltaY", UserInfo.SEX_FEMALE, "E", BasicAnimation.KeyPath.SCALE_X, BasicAnimation.KeyPath.SCALE_Y, BasicAnimation.KeyPath.ROTATION, "D", "", "p", "scale", "w", "v", "pointX", "g", "pointY", tl.h.F, "stickerModel", "centerX", "centerY", CanvasView.ACTION_ROTATE, QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "onTouchEvent", "", DomainData.DOMAIN_NAME, "o", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, ReportConstant.COSTREPORT_PREFIX, "r", "Lcom/tencent/mobileqq/wink/editor/view/BorderView$d;", "cutSizeCallBack", "setCutSizeCallBack", "f", "d", "t", "u", "Lcom/tencent/mobileqq/wink/editor/view/BorderView$e;", "callback", "setOperationCallback", "Lcom/tencent/mobileqq/wink/editor/view/BorderView$b;", "gestureDetectCallback", "setGestureDetectorCallback", "Lcom/tencent/mobileqq/wink/editor/view/BorderView$c;", "borderLineCallBack", "setBorderLineCallBack", "enable", "setBorderViewEventConsumable", "G", "Lcom/tencent/mobileqq/wink/editor/view/BorderView$d;", "mCutSizeCallBack", "Lcom/tencent/mobileqq/wink/editor/view/BorderView$b;", "mGestureDetectCallback", "Lcom/tencent/mobileqq/wink/editor/view/BorderView$e;", "mCallBack", "Lcom/tencent/mobileqq/wink/editor/view/BorderView$c;", "mBorderLineCallBack", "i", "Landroid/graphics/PointF;", "downPoint", "downPointBg", "minMoveDistance", "twoPointDownDistance", "twoPointDownDistanceX", "twoPointDownDistanceY", "twoPointDownRotate", "getActionIndex", "()I", "setActionIndex", "(I)V", "actionIndex", "curScaleX", "curScaleY", "Lcom/tencent/mobileqq/wink/editor/sticker/WinkStickerModel;", "()Lcom/tencent/mobileqq/wink/editor/sticker/WinkStickerModel;", "setCurStickerModel", "(Lcom/tencent/mobileqq/wink/editor/sticker/WinkStickerModel;)V", "curStickerModel", "L", "onclickLocation", "M", "onDoubleClickLocation", "", "N", "firstClickTime", "P", "onFlingLocation", AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, "Z", "hasMoveAfterDown", BdhLogUtil.LogTag.Tag_Req, "mStickerStartLeft", ExifInterface.LATITUDE_SOUTH, "mStickerStartTop", "T", "getCanConsumeAllEvent", "()Z", "setCanConsumeAllEvent", "(Z)V", "canConsumeAllEvent", "U", "mAdsorptionStatusTop", "V", "mAdsorptionStatusBottom", "W", "mAdsorptionStatusLeft", "a0", "mAdsorptionStatusRight", "b0", "isTouchInSingleZoomRotateRect", "c0", "isTouchInSingleDeleteRect", "d0", "isTouchInCreatorInfoRect", "e0", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "setStickerActive", "isStickerActive", "f0", "disallowSwipeByOthers", "g0", "getMBoundaryX", "()F", "setMBoundaryX", "(F)V", "mBoundaryX", "h0", "getMBoundaryY", "setMBoundaryY", "mBoundaryY", "Lcom/tencent/videocut/model/Size;", "i0", "Lcom/tencent/videocut/model/Size;", "getMContainerSize", "()Lcom/tencent/videocut/model/Size;", "setMContainerSize", "(Lcom/tencent/videocut/model/Size;)V", "mContainerSize", "j0", "getMRenderSize", "setMRenderSize", "mRenderSize", "k0", "mHasScaleOrRotate", "l0", "mUpdatedStickerModel", "m0", "hasStopOnDown", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "o0", "Direction", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes21.dex */
public class BorderView extends FrameLayout {

    /* renamed from: p0, reason: collision with root package name */
    private static int f322665p0 = 300;

    /* renamed from: q0, reason: collision with root package name */
    private static int f322666q0 = 150;

    /* renamed from: C, reason: from kotlin metadata */
    private final int minMoveDistance;

    /* renamed from: D, reason: from kotlin metadata */
    private float twoPointDownDistance;

    /* renamed from: E, reason: from kotlin metadata */
    private float twoPointDownDistanceX;

    /* renamed from: F, reason: from kotlin metadata */
    private float twoPointDownDistanceY;

    /* renamed from: G, reason: from kotlin metadata */
    private float twoPointDownRotate;

    /* renamed from: H, reason: from kotlin metadata */
    private int actionIndex;

    /* renamed from: I, reason: from kotlin metadata */
    private float curScaleX;

    /* renamed from: J, reason: from kotlin metadata */
    private float curScaleY;

    /* renamed from: K, reason: from kotlin metadata */
    @Nullable
    private WinkStickerModel curStickerModel;

    /* renamed from: L, reason: from kotlin metadata */
    @Nullable
    private PointF onclickLocation;

    /* renamed from: M, reason: from kotlin metadata */
    @Nullable
    private PointF onDoubleClickLocation;

    /* renamed from: N, reason: from kotlin metadata */
    private long firstClickTime;

    /* renamed from: P, reason: from kotlin metadata */
    @Nullable
    private PointF onFlingLocation;

    /* renamed from: Q, reason: from kotlin metadata */
    private boolean hasMoveAfterDown;

    /* renamed from: R, reason: from kotlin metadata */
    private float mStickerStartLeft;

    /* renamed from: S, reason: from kotlin metadata */
    private float mStickerStartTop;

    /* renamed from: T, reason: from kotlin metadata */
    private boolean canConsumeAllEvent;

    /* renamed from: U, reason: from kotlin metadata */
    private boolean mAdsorptionStatusTop;

    /* renamed from: V, reason: from kotlin metadata */
    private boolean mAdsorptionStatusBottom;

    /* renamed from: W, reason: from kotlin metadata */
    private boolean mAdsorptionStatusLeft;

    /* renamed from: a0, reason: collision with root package name and from kotlin metadata */
    private boolean mAdsorptionStatusRight;

    /* renamed from: b0, reason: collision with root package name and from kotlin metadata */
    private boolean isTouchInSingleZoomRotateRect;

    /* renamed from: c0, reason: collision with root package name and from kotlin metadata */
    private boolean isTouchInSingleDeleteRect;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private d mCutSizeCallBack;

    /* renamed from: d0, reason: collision with root package name and from kotlin metadata */
    private boolean isTouchInCreatorInfoRect;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private b mGestureDetectCallback;

    /* renamed from: e0, reason: collision with root package name and from kotlin metadata */
    private boolean isStickerActive;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private e mCallBack;

    /* renamed from: f0, reason: collision with root package name and from kotlin metadata */
    private boolean disallowSwipeByOthers;

    /* renamed from: g0, reason: collision with root package name and from kotlin metadata */
    private float mBoundaryX;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private c mBorderLineCallBack;

    /* renamed from: h0, reason: collision with root package name and from kotlin metadata */
    private float mBoundaryY;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final PointF downPoint;

    /* renamed from: i0, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private Size mContainerSize;

    /* renamed from: j0, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private Size mRenderSize;

    /* renamed from: k0, reason: collision with root package name and from kotlin metadata */
    private boolean mHasScaleOrRotate;

    /* renamed from: l0, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private WinkStickerModel mUpdatedStickerModel;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final PointF downPointBg;

    /* renamed from: m0, reason: collision with root package name and from kotlin metadata */
    private boolean hasStopOnDown;

    /* renamed from: n0, reason: collision with root package name */
    @NotNull
    public Map<Integer, View> f322686n0;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004\u00a8\u0006\u0005"}, d2 = {"Lcom/tencent/mobileqq/wink/editor/view/BorderView$Direction;", "", "(Ljava/lang/String;I)V", "Left", "Right", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes21.dex */
    public enum Direction {
        Left,
        Right
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H&J\b\u0010\u0004\u001a\u00020\u0002H&J\b\u0010\u0005\u001a\u00020\u0002H&J\b\u0010\u0006\u001a\u00020\u0002H&J\u0010\u0010\n\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u0007H&J\b\u0010\u000b\u001a\u00020\tH&J\b\u0010\f\u001a\u00020\tH&J\u0010\u0010\u000e\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\u0002H&J\u0018\u0010\u0012\u001a\u00020\t2\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\u000fH&J\u0018\u0010\u0015\u001a\u00020\t2\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0014\u001a\u00020\u0013H&\u00a8\u0006\u0016"}, d2 = {"Lcom/tencent/mobileqq/wink/editor/view/BorderView$b;", "", "", "getRenderWidth", "getRenderHeight", "i1", "K", "Lcom/tencent/mobileqq/wink/editor/view/BorderView$Direction;", "direction", "", "hc", ICustomDataEditor.STRING_ARRAY_PARAM_6, "va", "pointNum", "Sd", "", "isClickEvent", "isStickerActive", "Pb", "", "positionY", "xg", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes21.dex */
    public interface b {
        int K();

        void Pb(boolean isClickEvent, boolean isStickerActive);

        void Sd(int pointNum);

        void a6();

        int getRenderHeight();

        int getRenderWidth();

        void hc(@NotNull Direction direction);

        int i1();

        void va();

        void xg(boolean isClickEvent, float positionY);
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\bf\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H&J\b\u0010\u0004\u001a\u00020\u0002H&J\b\u0010\u0005\u001a\u00020\u0002H&J\b\u0010\u0006\u001a\u00020\u0002H&J\b\u0010\u0007\u001a\u00020\u0002H&J\n\u0010\t\u001a\u0004\u0018\u00010\bH&J\n\u0010\n\u001a\u0004\u0018\u00010\bH&J\n\u0010\u000b\u001a\u0004\u0018\u00010\bH&J\n\u0010\f\u001a\u0004\u0018\u00010\bH&\u00a8\u0006\r"}, d2 = {"Lcom/tencent/mobileqq/wink/editor/view/BorderView$c;", "", "", "dd", "B3", "N2", "b8", "R6", "Landroid/view/View;", "bb", "bc", "ga", "w7", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes21.dex */
    public interface c {
        void B3();

        void N2();

        void R6();

        void b8();

        @Nullable
        View bb();

        @Nullable
        View bc();

        void dd();

        @Nullable
        View ga();

        @Nullable
        View w7();
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H&J\b\u0010\u0005\u001a\u00020\u0004H&J\b\u0010\u0006\u001a\u00020\u0004H&\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/mobileqq/wink/editor/view/BorderView$d;", "", "", AppConstants.Key.COLUMN_IS_VALID, "Lcom/tencent/videocut/model/Size;", "a", "b", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes21.dex */
    public interface d {
        @NotNull
        Size a();

        @NotNull
        Size b();

        boolean isValid();
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0006\bf\u0018\u00002\u00020\u0001J\"\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0007\u001a\u00020\u0006H&J\u0012\u0010\n\u001a\u00020\b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H&J\u0012\u0010\f\u001a\u00020\b2\b\u0010\u000b\u001a\u0004\u0018\u00010\u0002H&J\u0010\u0010\u000f\u001a\u00020\b2\u0006\u0010\u000e\u001a\u00020\rH&J\u0012\u0010\u0010\u001a\u00020\b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H&J\b\u0010\u0011\u001a\u00020\bH&J*\u0010\u0017\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0014\u001a\u00020\u00122\u0006\u0010\u0015\u001a\u00020\u00122\u0006\u0010\u0016\u001a\u00020\u0012H&J\u001a\u0010\u001a\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0018\u001a\u00020\u00042\u0006\u0010\u0019\u001a\u00020\u0004H&J\u0012\u0010\u001b\u001a\u00020\b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H&J\u0012\u0010\u001c\u001a\u00020\b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H&J\u0012\u0010\u001d\u001a\u00020\b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H&J\b\u0010\u001f\u001a\u00020\u001eH&J\b\u0010 \u001a\u00020\u001eH&J\b\u0010!\u001a\u00020\u001eH&J\b\u0010\"\u001a\u00020\u0006H&J\b\u0010#\u001a\u00020\u0006H&\u00a8\u0006$"}, d2 = {"Lcom/tencent/mobileqq/wink/editor/view/BorderView$e;", "", "Lcom/tencent/mobileqq/wink/editor/sticker/WinkStickerModel;", "stickerModel", "Landroid/graphics/PointF;", "correctPoint", "", "isMove", "", "y2", "w2", "updatedStickerModel", "M3", "", "tipId", "q9", "A3", "M1", "", "eventX", "eventY", "screenX", "screenY", "e1", "fingerOne", "fingerTwo", "U", "Z0", "W0", "f3", "Landroid/graphics/RectF;", "U4", "K0", "h3", "N4", "u8", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes21.dex */
    public interface e {
        void A3(@Nullable WinkStickerModel stickerModel);

        @NotNull
        RectF K0();

        void M1();

        void M3(@Nullable WinkStickerModel updatedStickerModel);

        boolean N4();

        @Nullable
        WinkStickerModel U(@NotNull PointF fingerOne, @NotNull PointF fingerTwo);

        @NotNull
        RectF U4();

        void W0(@Nullable WinkStickerModel stickerModel);

        void Z0(@Nullable WinkStickerModel stickerModel);

        @Nullable
        WinkStickerModel e1(float eventX, float eventY, float screenX, float screenY);

        void f3(@Nullable WinkStickerModel stickerModel);

        @NotNull
        RectF h3();

        void q9(int tipId);

        boolean u8();

        void w2(@Nullable WinkStickerModel stickerModel);

        void y2(@NotNull WinkStickerModel stickerModel, @Nullable PointF correctPoint, boolean isMove);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public BorderView(@NotNull Context context) {
        this(context, null, 2, 0 == true ? 1 : 0);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    private final void B(PointF correctPoint) {
        if (getCurStickerModel() != null && this.mCallBack != null) {
            float g16 = g(correctPoint.x);
            float h16 = h(correctPoint.y);
            WinkStickerModel curStickerModel = getCurStickerModel();
            Intrinsics.checkNotNull(curStickerModel);
            WinkStickerModel curStickerModel2 = getCurStickerModel();
            Intrinsics.checkNotNull(curStickerModel2);
            float f16 = curStickerModel2.scaleX;
            WinkStickerModel curStickerModel3 = getCurStickerModel();
            Intrinsics.checkNotNull(curStickerModel3);
            float f17 = curStickerModel3.scaleY;
            WinkStickerModel curStickerModel4 = getCurStickerModel();
            Intrinsics.checkNotNull(curStickerModel4);
            WinkStickerModel m3 = m(curStickerModel, g16, h16, f16, f17, curStickerModel4.rotate);
            e eVar = this.mCallBack;
            Intrinsics.checkNotNull(eVar);
            eVar.y2(m3, correctPoint, true);
            e eVar2 = this.mCallBack;
            Intrinsics.checkNotNull(eVar2);
            eVar2.f3(m3);
        }
    }

    private final void C(PointF correctPoint) {
        if (getCurStickerModel() != null && this.mCallBack != null) {
            WinkStickerModel curStickerModel = getCurStickerModel();
            Intrinsics.checkNotNull(curStickerModel);
            if (curStickerModel.getIsTraceSticker()) {
                e eVar = this.mCallBack;
                Intrinsics.checkNotNull(eVar);
                eVar.q9(R.string.f21897656);
            }
            float g16 = g(correctPoint.x);
            float h16 = h(correctPoint.y);
            WinkStickerModel curStickerModel2 = getCurStickerModel();
            Intrinsics.checkNotNull(curStickerModel2);
            WinkStickerModel curStickerModel3 = getCurStickerModel();
            Intrinsics.checkNotNull(curStickerModel3);
            float f16 = curStickerModel3.scaleX;
            WinkStickerModel curStickerModel4 = getCurStickerModel();
            Intrinsics.checkNotNull(curStickerModel4);
            float f17 = curStickerModel4.scaleY;
            WinkStickerModel curStickerModel5 = getCurStickerModel();
            Intrinsics.checkNotNull(curStickerModel5);
            WinkStickerModel m3 = m(curStickerModel2, g16, h16, f16, f17, curStickerModel5.rotate);
            m3.setTraceSticker(false);
            m3.setStickerTrackerResult(null);
            m3.setEntityName(null);
            StickerModel.Type type = m3.type;
            if (type != StickerModel.Type.BOTTOM_FRAME && type != StickerModel.Type.TOP_FRAME) {
                e eVar2 = this.mCallBack;
                Intrinsics.checkNotNull(eVar2);
                eVar2.y2(m3, correctPoint, true);
            } else if (!a(m3)) {
                ms.a.a("WinkBorderView", "not  adsorption");
                e eVar3 = this.mCallBack;
                Intrinsics.checkNotNull(eVar3);
                eVar3.y2(m3, correctPoint, true);
                e eVar4 = this.mCallBack;
                Intrinsics.checkNotNull(eVar4);
                eVar4.f3(m3);
            }
        }
    }

    private final void D(float scaleX, float scaleY, float rotation) {
        if (getCurStickerModel() != null) {
            WinkStickerModel curStickerModel = getCurStickerModel();
            Intrinsics.checkNotNull(curStickerModel);
            WinkStickerModel curStickerModel2 = getCurStickerModel();
            Intrinsics.checkNotNull(curStickerModel2);
            float f16 = curStickerModel2.centerX;
            WinkStickerModel curStickerModel3 = getCurStickerModel();
            Intrinsics.checkNotNull(curStickerModel3);
            WinkStickerModel m3 = m(curStickerModel, f16, curStickerModel3.centerY, scaleX, scaleY, rotation);
            m3.setTraceSticker(false);
            m3.setStickerTrackerResult(null);
            m3.setEntityName(null);
            e eVar = this.mCallBack;
            if (eVar != null) {
                eVar.y2(m3, null, false);
            }
        }
    }

    private final void E(float deltaX, float deltaY) {
        e eVar;
        WinkStickerModel curStickerModel = getCurStickerModel();
        Intrinsics.checkNotNull(curStickerModel);
        if (curStickerModel.getIsTraceSticker() && (eVar = this.mCallBack) != null) {
            eVar.q9(R.string.f21897656);
        }
        this.mHasScaleOrRotate = true;
        WinkStickerModel curStickerModel2 = getCurStickerModel();
        Intrinsics.checkNotNull(curStickerModel2);
        float lastDownRotate = curStickerModel2.getLastDownRotate();
        if (this.twoPointDownDistance > 0.0f) {
            float f16 = deltaX / this.twoPointDownDistanceX;
            WinkStickerModel curStickerModel3 = getCurStickerModel();
            Intrinsics.checkNotNull(curStickerModel3);
            float lastDownScaleX = f16 * curStickerModel3.getLastDownScaleX();
            float f17 = deltaY / this.twoPointDownDistanceY;
            WinkStickerModel curStickerModel4 = getCurStickerModel();
            Intrinsics.checkNotNull(curStickerModel4);
            v(lastDownScaleX, f17 * curStickerModel4.getLastDownScaleY());
        }
        WinkStickerModel curStickerModel5 = getCurStickerModel();
        Intrinsics.checkNotNull(curStickerModel5);
        curStickerModel5.setDownScaleRecord(lastDownRotate);
        D(this.curScaleX, this.curScaleY, lastDownRotate * (-1));
    }

    private final void F(float deltaX, float deltaY) {
        e eVar;
        WinkStickerModel curStickerModel = getCurStickerModel();
        Intrinsics.checkNotNull(curStickerModel);
        if (curStickerModel.getIsTraceSticker() && (eVar = this.mCallBack) != null) {
            eVar.q9(R.string.f21897656);
        }
        this.mHasScaleOrRotate = true;
        float p16 = p(deltaX, deltaY) - this.twoPointDownRotate;
        WinkStickerModel curStickerModel2 = getCurStickerModel();
        Intrinsics.checkNotNull(curStickerModel2);
        float lastDownRotate = p16 + curStickerModel2.getLastDownRotate();
        if (lastDownRotate < 0.0f) {
            lastDownRotate += 360.0f;
        } else if (lastDownRotate > 360.0f) {
            lastDownRotate -= 360.0f;
        }
        if (this.twoPointDownDistance > 0.0f) {
            float sqrt = ((float) Math.sqrt((deltaX * deltaX) + (deltaY * deltaY))) / this.twoPointDownDistance;
            WinkStickerModel curStickerModel3 = getCurStickerModel();
            Intrinsics.checkNotNull(curStickerModel3);
            w(sqrt * curStickerModel3.getLastDownScaleX());
        }
        WinkStickerModel curStickerModel4 = getCurStickerModel();
        Intrinsics.checkNotNull(curStickerModel4);
        curStickerModel4.setDownScaleRecord(lastDownRotate);
        D(this.curScaleX, this.curScaleY, lastDownRotate * (-1));
    }

    private final void H() {
        Boolean bool;
        Map<String, Object> extParams = WinkDTParamBuilder.buildElementParams();
        Intrinsics.checkNotNullExpressionValue(extParams, "extParams");
        extParams.put("xsj_custom_pgid", WinkDaTongReportConstant.PageId.PG_XSJ_EDIT_PAGE);
        extParams.put("xsj_eid", WinkDaTongReportConstant.ElementId.EM_XSJ_EDIT_DELETE_CROSS_BUTTON);
        WinkStickerModel curStickerModel = getCurStickerModel();
        Boolean bool2 = null;
        if (curStickerModel != null) {
            bool = Boolean.valueOf(curStickerModel.isTextSticker());
        } else {
            bool = null;
        }
        if (bool != null) {
            WinkStickerModel curStickerModel2 = getCurStickerModel();
            if (curStickerModel2 != null) {
                bool2 = Boolean.valueOf(curStickerModel2.isTextSticker());
            }
            Intrinsics.checkNotNull(bool2);
            if (bool2.booleanValue()) {
                extParams.put(WinkDaTongReportConstant.ElementParamKey.XSJ_EDIT_DELETE_BUTTON_TYPE, WinkDaTongReportConstant.ElementParamValue.XSJ_EDIT_STICKER_TYPE_CHAR);
                VideoReport.setElementId(this, WinkDaTongReportConstant.ElementId.EM_XSJ_EDIT_DELETE_CROSS_BUTTON);
                VideoReport.reportEvent("dt_clck", this, extParams);
            }
        }
        extParams.put(WinkDaTongReportConstant.ElementParamKey.XSJ_EDIT_DELETE_BUTTON_TYPE, "paste");
        VideoReport.setElementId(this, WinkDaTongReportConstant.ElementId.EM_XSJ_EDIT_DELETE_CROSS_BUTTON);
        VideoReport.reportEvent("dt_clck", this, extParams);
    }

    private final void I() {
        c cVar = this.mBorderLineCallBack;
        if (cVar != null) {
            cVar.dd();
        }
    }

    private final void J(PointF pointF, boolean status) {
        K(status);
        B(pointF);
    }

    private final void K(boolean isAdsorptionStatus) {
        if (!isAdsorptionStatus) {
            ac.f326659a.b(getContext(), 100L);
        }
    }

    private final boolean a(WinkStickerModel newModel) {
        d dVar;
        float f16;
        float f17;
        float intValue;
        float f18;
        boolean z16 = false;
        if (newModel != null && (dVar = this.mCutSizeCallBack) != null) {
            Intrinsics.checkNotNull(dVar);
            if (dVar.isValid() && this.mBorderLineCallBack != null) {
                I();
                this.mBoundaryX = newModel.getSizeInView().f320587x * 0.008f;
                this.mBoundaryY = newModel.getSizeInView().f320588y * 0.008f;
                d dVar2 = this.mCutSizeCallBack;
                Intrinsics.checkNotNull(dVar2);
                this.mContainerSize = dVar2.a();
                d dVar3 = this.mCutSizeCallBack;
                Intrinsics.checkNotNull(dVar3);
                this.mRenderSize = dVar3.b();
                float f19 = newModel.getCenterInView().f320587x;
                float f26 = newModel.getCenterInView().f320588y;
                Size size = this.mContainerSize;
                Intrinsics.checkNotNull(size);
                Integer num = size.height;
                Intrinsics.checkNotNull(num);
                int intValue2 = num.intValue();
                Size size2 = this.mRenderSize;
                Intrinsics.checkNotNull(size2);
                Intrinsics.checkNotNull(size2.height);
                float intValue3 = (intValue2 - r2.intValue()) / 2.0f;
                Size size3 = this.mContainerSize;
                Intrinsics.checkNotNull(size3);
                Integer num2 = size3.height;
                Intrinsics.checkNotNull(num2);
                int intValue4 = num2.intValue();
                Size size4 = this.mRenderSize;
                Intrinsics.checkNotNull(size4);
                Intrinsics.checkNotNull(size4.height);
                float intValue5 = (intValue4 + r3.intValue()) / 2.0f;
                Size size5 = this.mRenderSize;
                Intrinsics.checkNotNull(size5);
                Integer num3 = size5.height;
                Intrinsics.checkNotNull(num3);
                int intValue6 = num3.intValue();
                Size size6 = this.mContainerSize;
                Intrinsics.checkNotNull(size6);
                Integer num4 = size6.height;
                Intrinsics.checkNotNull(num4);
                if (intValue6 >= num4.intValue()) {
                    Size size7 = this.mContainerSize;
                    Intrinsics.checkNotNull(size7);
                    Integer num5 = size7.height;
                    Intrinsics.checkNotNull(num5);
                    f17 = num5.intValue();
                    f16 = 0.0f;
                } else {
                    f16 = intValue3;
                    f17 = intValue5;
                }
                Size size8 = this.mContainerSize;
                Intrinsics.checkNotNull(size8);
                Integer num6 = size8.width;
                Intrinsics.checkNotNull(num6);
                int intValue7 = num6.intValue();
                Size size9 = this.mRenderSize;
                Intrinsics.checkNotNull(size9);
                Intrinsics.checkNotNull(size9.width);
                float intValue8 = (intValue7 - r3.intValue()) / 2.0f;
                Size size10 = this.mRenderSize;
                Intrinsics.checkNotNull(size10);
                Integer num7 = size10.width;
                Intrinsics.checkNotNull(num7);
                int intValue9 = num7.intValue();
                Size size11 = this.mContainerSize;
                Intrinsics.checkNotNull(size11);
                Intrinsics.checkNotNull(size11.width);
                float intValue10 = (intValue9 + r3.intValue()) / 2.0f;
                Size size12 = this.mRenderSize;
                Intrinsics.checkNotNull(size12);
                Integer num8 = size12.width;
                Intrinsics.checkNotNull(num8);
                int intValue11 = num8.intValue();
                Size size13 = this.mContainerSize;
                Intrinsics.checkNotNull(size13);
                Integer num9 = size13.width;
                Intrinsics.checkNotNull(num9);
                if (intValue11 <= num9.intValue()) {
                    f18 = intValue8;
                    intValue = intValue10;
                } else {
                    Size size14 = this.mContainerSize;
                    Intrinsics.checkNotNull(size14);
                    Integer num10 = size14.width;
                    Intrinsics.checkNotNull(num10);
                    intValue = num10.intValue();
                    f18 = 0.0f;
                }
                if (newModel.rotate == 0.0f) {
                    z16 = true;
                }
                if (z16) {
                    return c(newModel, f16, f17, intValue, f18, intValue3, intValue8, intValue5, intValue10);
                }
                return b(newModel, f16, f17, intValue, f18, intValue3, intValue8, intValue5, intValue10);
            }
        }
        return false;
    }

    private final boolean b(WinkStickerModel newModel, float baseTopY, float baseBottomY, float baseRightX, float baseLeftX, float renderTopY, float renderTopX, float renderBottomY, float renderBottomX) {
        boolean z16;
        FrameLayout.LayoutParams layoutParams;
        float f16 = newModel.getCenterInView().f320587x;
        float f17 = newModel.getCenterInView().f320588y;
        Matrix matrix = new Matrix();
        matrix.setRotate(newModel.rotate, f16, f17);
        PointF j3 = j(matrix, newModel.getLeftTopInView().f320587x, newModel.getLeftTopInView().f320588y);
        PointF j16 = j(matrix, newModel.getLeftTopInView().f320587x, newModel.getRightBottomInView().f320588y);
        PointF j17 = j(matrix, newModel.getRightBottomInView().f320587x, newModel.getLeftTopInView().f320588y);
        PointF j18 = j(matrix, newModel.getRightBottomInView().f320587x, newModel.getRightBottomInView().f320588y);
        float f18 = newModel.getOriginPointInView().f320587x;
        float f19 = newModel.getOriginPointInView().f320588y;
        boolean z17 = false;
        float[] fArr = {j16.x + f18, j3.x + f18, j18.x + f18, j17.x + f18};
        float[] fArr2 = {j16.y + f19, j3.y + f19, j18.y + f19, j17.y + f19};
        float l3 = l(fArr);
        float k3 = k(fArr);
        float l16 = l(fArr2);
        float k16 = k(fArr2);
        this.mBoundaryX = (k3 - l3) * 0.008f;
        this.mBoundaryY = (k16 - l16) * 0.008f;
        float f26 = l16 - renderTopY;
        if (Math.abs(f26) <= this.mBoundaryY) {
            c cVar = this.mBorderLineCallBack;
            Intrinsics.checkNotNull(cVar);
            if (cVar.bc() != null) {
                c cVar2 = this.mBorderLineCallBack;
                Intrinsics.checkNotNull(cVar2);
                View bc5 = cVar2.bc();
                Intrinsics.checkNotNull(bc5);
                ViewGroup.LayoutParams layoutParams2 = bc5.getLayoutParams();
                Intrinsics.checkNotNull(layoutParams2, "null cannot be cast to non-null type android.widget.FrameLayout.LayoutParams");
                FrameLayout.LayoutParams layoutParams3 = (FrameLayout.LayoutParams) layoutParams2;
                layoutParams3.topMargin = (int) baseTopY;
                c cVar3 = this.mBorderLineCallBack;
                Intrinsics.checkNotNull(cVar3);
                View bc6 = cVar3.bc();
                Intrinsics.checkNotNull(bc6);
                bc6.setLayoutParams(layoutParams3);
            }
            c cVar4 = this.mBorderLineCallBack;
            Intrinsics.checkNotNull(cVar4);
            cVar4.B3();
            J(new PointF(newModel.getLeftTopInView().f320587x + f18, (newModel.getLeftTopInView().f320588y - f26) + f19), this.mAdsorptionStatusTop);
            this.mAdsorptionStatusTop = true;
        } else {
            this.mAdsorptionStatusTop = false;
        }
        if (Math.abs(k16 - renderBottomY) <= this.mBoundaryY) {
            c cVar5 = this.mBorderLineCallBack;
            Intrinsics.checkNotNull(cVar5);
            if (cVar5.bb() != null) {
                c cVar6 = this.mBorderLineCallBack;
                Intrinsics.checkNotNull(cVar6);
                View bb5 = cVar6.bb();
                Intrinsics.checkNotNull(bb5);
                ViewGroup.LayoutParams layoutParams4 = bb5.getLayoutParams();
                Intrinsics.checkNotNull(layoutParams4, "null cannot be cast to non-null type android.widget.FrameLayout.LayoutParams");
                FrameLayout.LayoutParams layoutParams5 = (FrameLayout.LayoutParams) layoutParams4;
                Size size = this.mContainerSize;
                Intrinsics.checkNotNull(size);
                Intrinsics.checkNotNull(size.height);
                layoutParams5.bottomMargin = (int) (r8.intValue() - baseBottomY);
                c cVar7 = this.mBorderLineCallBack;
                Intrinsics.checkNotNull(cVar7);
                View bb6 = cVar7.bb();
                Intrinsics.checkNotNull(bb6);
                bb6.setLayoutParams(layoutParams5);
            }
            c cVar8 = this.mBorderLineCallBack;
            Intrinsics.checkNotNull(cVar8);
            cVar8.R6();
            J(new PointF(newModel.getLeftTopInView().f320587x + f18, newModel.getLeftTopInView().f320588y + (renderBottomY - k16) + f19), this.mAdsorptionStatusBottom);
            this.mAdsorptionStatusBottom = true;
        } else {
            this.mAdsorptionStatusBottom = false;
        }
        float f27 = l3 - renderTopX;
        FrameLayout.LayoutParams layoutParams6 = null;
        if (Math.abs(f27) <= this.mBoundaryX) {
            c cVar9 = this.mBorderLineCallBack;
            Intrinsics.checkNotNull(cVar9);
            if (cVar9.ga() != null) {
                c cVar10 = this.mBorderLineCallBack;
                Intrinsics.checkNotNull(cVar10);
                View ga5 = cVar10.ga();
                Intrinsics.checkNotNull(ga5);
                ViewGroup.LayoutParams layoutParams7 = ga5.getLayoutParams();
                if (layoutParams7 instanceof FrameLayout.LayoutParams) {
                    layoutParams = (FrameLayout.LayoutParams) layoutParams7;
                } else {
                    layoutParams = null;
                }
                if (layoutParams != null) {
                    layoutParams.leftMargin = (int) baseLeftX;
                }
                c cVar11 = this.mBorderLineCallBack;
                Intrinsics.checkNotNull(cVar11);
                View ga6 = cVar11.ga();
                Intrinsics.checkNotNull(ga6);
                ga6.setLayoutParams(layoutParams);
            }
            c cVar12 = this.mBorderLineCallBack;
            Intrinsics.checkNotNull(cVar12);
            cVar12.b8();
            J(new PointF((newModel.getLeftTopInView().f320587x + f18) - f27, newModel.getLeftTopInView().f320588y + f19), this.mAdsorptionStatusLeft);
            z16 = true;
        } else {
            z16 = false;
        }
        this.mAdsorptionStatusLeft = z16;
        if (Math.abs(k3 - renderBottomX) <= this.mBoundaryX) {
            c cVar13 = this.mBorderLineCallBack;
            Intrinsics.checkNotNull(cVar13);
            cVar13.N2();
            c cVar14 = this.mBorderLineCallBack;
            Intrinsics.checkNotNull(cVar14);
            if (cVar14.w7() != null) {
                c cVar15 = this.mBorderLineCallBack;
                Intrinsics.checkNotNull(cVar15);
                View w75 = cVar15.w7();
                Intrinsics.checkNotNull(w75);
                ViewGroup.LayoutParams layoutParams8 = w75.getLayoutParams();
                if (layoutParams8 instanceof FrameLayout.LayoutParams) {
                    layoutParams6 = (FrameLayout.LayoutParams) layoutParams8;
                }
                if (layoutParams6 != null) {
                    Size size2 = this.mContainerSize;
                    Intrinsics.checkNotNull(size2);
                    Intrinsics.checkNotNull(size2.width);
                    layoutParams6.rightMargin = (int) (r1.intValue() - baseRightX);
                }
                c cVar16 = this.mBorderLineCallBack;
                Intrinsics.checkNotNull(cVar16);
                View w76 = cVar16.w7();
                Intrinsics.checkNotNull(w76);
                w76.setLayoutParams(layoutParams6);
            }
            J(new PointF(newModel.getLeftTopInView().f320587x + f18 + (renderBottomX - k3), newModel.getLeftTopInView().f320588y + f19), this.mAdsorptionStatusRight);
            z17 = true;
        }
        this.mAdsorptionStatusRight = z17;
        return x();
    }

    private final boolean c(WinkStickerModel newModel, float baseTopY, float baseBottomY, float baseRightX, float baseLeftX, float renderTopY, float renderTopX, float renderBottomY, float renderBottomX) {
        boolean z16;
        FrameLayout.LayoutParams layoutParams;
        boolean z17;
        boolean z18;
        boolean z19;
        float f16 = newModel.getLeftTopInView().f320587x + newModel.getOriginPointInView().f320587x;
        float f17 = newModel.getLeftTopInView().f320588y + newModel.getOriginPointInView().f320588y;
        float f18 = newModel.getRightBottomInView().f320587x + newModel.getOriginPointInView().f320587x;
        float f19 = newModel.getRightBottomInView().f320588y + newModel.getOriginPointInView().f320588y;
        this.mBoundaryX = (f18 - f16) * 0.008f;
        this.mBoundaryY = (f19 - f17) * 0.008f;
        boolean z26 = true;
        boolean z27 = false;
        if (Math.abs(f17 - renderTopY) <= this.mBoundaryY) {
            c cVar = this.mBorderLineCallBack;
            Intrinsics.checkNotNull(cVar);
            if (cVar.bc() != null) {
                c cVar2 = this.mBorderLineCallBack;
                Intrinsics.checkNotNull(cVar2);
                View bc5 = cVar2.bc();
                Intrinsics.checkNotNull(bc5);
                ViewGroup.LayoutParams layoutParams2 = bc5.getLayoutParams();
                Intrinsics.checkNotNull(layoutParams2, "null cannot be cast to non-null type android.widget.FrameLayout.LayoutParams");
                FrameLayout.LayoutParams layoutParams3 = (FrameLayout.LayoutParams) layoutParams2;
                if (baseTopY == 0.0f) {
                    z19 = true;
                } else {
                    z19 = false;
                }
                if (!z19) {
                    layoutParams3.topMargin = ((int) baseTopY) - 3;
                } else {
                    layoutParams3.topMargin = (int) baseTopY;
                }
                c cVar3 = this.mBorderLineCallBack;
                Intrinsics.checkNotNull(cVar3);
                View bc6 = cVar3.bc();
                Intrinsics.checkNotNull(bc6);
                bc6.setLayoutParams(layoutParams3);
            }
            c cVar4 = this.mBorderLineCallBack;
            Intrinsics.checkNotNull(cVar4);
            cVar4.B3();
            J(new PointF(f16, renderTopY), this.mAdsorptionStatusTop);
            this.mAdsorptionStatusTop = true;
        } else {
            this.mAdsorptionStatusTop = false;
        }
        if (Math.abs(f19 - renderBottomY) <= this.mBoundaryY) {
            c cVar5 = this.mBorderLineCallBack;
            Intrinsics.checkNotNull(cVar5);
            if (cVar5.bb() != null) {
                c cVar6 = this.mBorderLineCallBack;
                Intrinsics.checkNotNull(cVar6);
                View bb5 = cVar6.bb();
                Intrinsics.checkNotNull(bb5);
                ViewGroup.LayoutParams layoutParams4 = bb5.getLayoutParams();
                Intrinsics.checkNotNull(layoutParams4, "null cannot be cast to non-null type android.widget.FrameLayout.LayoutParams");
                FrameLayout.LayoutParams layoutParams5 = (FrameLayout.LayoutParams) layoutParams4;
                Size size = this.mContainerSize;
                Intrinsics.checkNotNull(size);
                Intrinsics.checkNotNull(size.height);
                if (r9.intValue() - baseBottomY == 0.0f) {
                    z18 = true;
                } else {
                    z18 = false;
                }
                if (!z18) {
                    Size size2 = this.mContainerSize;
                    Intrinsics.checkNotNull(size2);
                    Intrinsics.checkNotNull(size2.height);
                    layoutParams5.bottomMargin = ((int) (r9.intValue() - baseBottomY)) - 3;
                } else {
                    Size size3 = this.mContainerSize;
                    Intrinsics.checkNotNull(size3);
                    Intrinsics.checkNotNull(size3.height);
                    layoutParams5.bottomMargin = (int) (r9.intValue() - baseBottomY);
                }
                c cVar7 = this.mBorderLineCallBack;
                Intrinsics.checkNotNull(cVar7);
                View bb6 = cVar7.bb();
                Intrinsics.checkNotNull(bb6);
                bb6.setLayoutParams(layoutParams5);
            }
            c cVar8 = this.mBorderLineCallBack;
            Intrinsics.checkNotNull(cVar8);
            cVar8.R6();
            J(new PointF(f16, (renderBottomY - f19) + f17), this.mAdsorptionStatusBottom);
            this.mAdsorptionStatusBottom = true;
        } else {
            this.mAdsorptionStatusBottom = false;
        }
        FrameLayout.LayoutParams layoutParams6 = null;
        if (Math.abs(f16 - renderTopX) <= this.mBoundaryX) {
            c cVar9 = this.mBorderLineCallBack;
            Intrinsics.checkNotNull(cVar9);
            if (cVar9.ga() != null) {
                c cVar10 = this.mBorderLineCallBack;
                Intrinsics.checkNotNull(cVar10);
                View ga5 = cVar10.ga();
                Intrinsics.checkNotNull(ga5);
                ViewGroup.LayoutParams layoutParams7 = ga5.getLayoutParams();
                if (layoutParams7 instanceof FrameLayout.LayoutParams) {
                    layoutParams = (FrameLayout.LayoutParams) layoutParams7;
                } else {
                    layoutParams = null;
                }
                if (baseLeftX == 0.0f) {
                    z17 = true;
                } else {
                    z17 = false;
                }
                if (!z17) {
                    if (layoutParams != null) {
                        layoutParams.leftMargin = ((int) baseLeftX) - 3;
                    }
                } else if (layoutParams != null) {
                    layoutParams.leftMargin = (int) baseLeftX;
                }
                c cVar11 = this.mBorderLineCallBack;
                Intrinsics.checkNotNull(cVar11);
                View ga6 = cVar11.ga();
                Intrinsics.checkNotNull(ga6);
                ga6.setLayoutParams(layoutParams);
            }
            c cVar12 = this.mBorderLineCallBack;
            Intrinsics.checkNotNull(cVar12);
            cVar12.b8();
            J(new PointF(renderTopX, f17), this.mAdsorptionStatusLeft);
            z16 = true;
        } else {
            z16 = false;
        }
        this.mAdsorptionStatusLeft = z16;
        if (Math.abs(f18 - renderBottomX) <= this.mBoundaryX) {
            float f26 = renderBottomX - f18;
            c cVar13 = this.mBorderLineCallBack;
            Intrinsics.checkNotNull(cVar13);
            if (cVar13.w7() != null) {
                c cVar14 = this.mBorderLineCallBack;
                Intrinsics.checkNotNull(cVar14);
                View w75 = cVar14.w7();
                Intrinsics.checkNotNull(w75);
                ViewGroup.LayoutParams layoutParams8 = w75.getLayoutParams();
                if (layoutParams8 instanceof FrameLayout.LayoutParams) {
                    layoutParams6 = (FrameLayout.LayoutParams) layoutParams8;
                }
                Size size4 = this.mContainerSize;
                Intrinsics.checkNotNull(size4);
                Intrinsics.checkNotNull(size4.width);
                if (r2.intValue() - baseRightX == 0.0f) {
                    z27 = true;
                }
                if (!z27) {
                    if (layoutParams6 != null) {
                        Size size5 = this.mContainerSize;
                        Intrinsics.checkNotNull(size5);
                        Intrinsics.checkNotNull(size5.width);
                        layoutParams6.rightMargin = ((int) (r2.intValue() - baseRightX)) - 3;
                    }
                } else if (layoutParams6 != null) {
                    Size size6 = this.mContainerSize;
                    Intrinsics.checkNotNull(size6);
                    Intrinsics.checkNotNull(size6.width);
                    layoutParams6.rightMargin = (int) (r2.intValue() - baseRightX);
                }
                c cVar15 = this.mBorderLineCallBack;
                Intrinsics.checkNotNull(cVar15);
                View w76 = cVar15.w7();
                Intrinsics.checkNotNull(w76);
                w76.setLayoutParams(layoutParams6);
            }
            c cVar16 = this.mBorderLineCallBack;
            Intrinsics.checkNotNull(cVar16);
            cVar16.N2();
            J(new PointF(f26 + f16, f17), this.mAdsorptionStatusRight);
        } else {
            z26 = false;
        }
        this.mAdsorptionStatusRight = z26;
        if (this.mAdsorptionStatusTop) {
            if (this.mAdsorptionStatusLeft) {
                B(new PointF(renderTopX, renderTopY));
            } else if (z26) {
                B(new PointF((f16 + renderBottomX) - f18, renderTopY));
            }
        }
        if (this.mAdsorptionStatusBottom) {
            if (this.mAdsorptionStatusLeft) {
                B(new PointF(renderTopX, (f17 + renderBottomY) - f19));
            } else if (this.mAdsorptionStatusRight) {
                B(new PointF((f16 + renderBottomX) - f18, (f17 + renderBottomY) - f19));
            }
        }
        return x();
    }

    private final PointF e(float left, float top) {
        int i3;
        WinkStickerModel curStickerModel = getCurStickerModel();
        Intrinsics.checkNotNull(curStickerModel);
        float f16 = 2;
        float f17 = (-curStickerModel.getSizeInView().f320587x) / f16;
        WinkStickerModel curStickerModel2 = getCurStickerModel();
        Intrinsics.checkNotNull(curStickerModel2);
        float f18 = f17 + curStickerModel2.getOriginPointInView().f320587x;
        b bVar = this.mGestureDetectCallback;
        int i16 = 0;
        if (bVar != null) {
            i3 = bVar.getRenderWidth();
        } else {
            i3 = 0;
        }
        float f19 = i3 + f18;
        WinkStickerModel curStickerModel3 = getCurStickerModel();
        Intrinsics.checkNotNull(curStickerModel3);
        float f26 = (-curStickerModel3.getSizeInView().f320588y) / f16;
        WinkStickerModel curStickerModel4 = getCurStickerModel();
        Intrinsics.checkNotNull(curStickerModel4);
        float f27 = f26 + curStickerModel4.getOriginPointInView().f320588y;
        b bVar2 = this.mGestureDetectCallback;
        if (bVar2 != null) {
            i16 = bVar2.getRenderHeight();
        }
        float f28 = i16 + f27;
        if (left < f18) {
            left = f18;
        } else if (left > f19) {
            left = f19;
        }
        if (top < f27) {
            top = f27;
        } else if (top > f28) {
            top = f28;
        }
        return new PointF(left, top);
    }

    private final float g(float pointX) {
        int i3;
        WinkStickerModel curStickerModel = getCurStickerModel();
        Intrinsics.checkNotNull(curStickerModel);
        float f16 = pointX - curStickerModel.getOriginPointInView().f320587x;
        Intrinsics.checkNotNull(getCurStickerModel());
        double ceil = Math.ceil(f16 + (r0.getSizeInView().f320587x / 2));
        b bVar = this.mGestureDetectCallback;
        if (bVar != null) {
            i3 = bVar.getRenderWidth();
        } else {
            i3 = 0;
        }
        return (float) ((ceil / (i3 / 2)) - 1);
    }

    private final float h(float pointY) {
        int i3;
        WinkStickerModel curStickerModel = getCurStickerModel();
        Intrinsics.checkNotNull(curStickerModel);
        float f16 = pointY - curStickerModel.getOriginPointInView().f320588y;
        double d16 = 1;
        Intrinsics.checkNotNull(getCurStickerModel());
        double ceil = Math.ceil(f16 + (r2.getSizeInView().f320588y / 2));
        b bVar = this.mGestureDetectCallback;
        if (bVar != null) {
            i3 = bVar.getRenderHeight();
        } else {
            i3 = 0;
        }
        return (float) (d16 - (ceil / (i3 / 2)));
    }

    private final PointF j(Matrix matrix, float x16, float y16) {
        float[] fArr = {x16, y16};
        matrix.mapPoints(fArr);
        return new PointF(fArr[0], fArr[1]);
    }

    private final float k(float[] points) {
        if (points == null) {
            return 0.0f;
        }
        float f16 = -2.14748365E9f;
        for (float f17 : points) {
            f16 = Math.max(f17, f16);
        }
        return f16;
    }

    private final float l(float[] points) {
        if (points == null) {
            return 0.0f;
        }
        float f16 = 2.14748365E9f;
        for (float f17 : points) {
            f16 = Math.min(f17, f16);
        }
        return f16;
    }

    private final WinkStickerModel m(WinkStickerModel stickerModel, float centerX, float centerY, float scaleX, float scaleY, float rotate) {
        int i3;
        int i16;
        WinkStickerModel b16 = com.tencent.mobileqq.wink.editor.sticker.e.b(stickerModel, centerX, centerY, rotate, scaleX, scaleY);
        b bVar = this.mGestureDetectCallback;
        if (bVar != null) {
            i3 = bVar.getRenderWidth();
        } else {
            i3 = 0;
        }
        b bVar2 = this.mGestureDetectCallback;
        if (bVar2 != null) {
            i16 = bVar2.getRenderHeight();
        } else {
            i16 = 0;
        }
        b16.updatePositionInView(i3, i16, b16.scaleX, b16.scaleY, b16.centerX, b16.centerY);
        this.mUpdatedStickerModel = b16;
        b16.setTraceSticker(stickerModel.getIsTraceSticker());
        b16.setStickerTrackerResult(stickerModel.getStickerTrackerResult());
        b16.setEntityName(stickerModel.getEntityName());
        b16.setTimeRangeChangedByUser(stickerModel.getIsTimeRangeChangedByUser());
        return b16;
    }

    private final float p(double deltaX, double deltaY) {
        return (float) Math.toDegrees(Math.atan2(deltaY, deltaX));
    }

    private final void v(float scaleX, float scaleY) {
        boolean z16;
        boolean z17;
        boolean z18;
        com.tencent.videocut.utils.e eVar = com.tencent.videocut.utils.e.f384236a;
        float a16 = eVar.a(12.0f);
        Intrinsics.checkNotNull(getCurStickerModel());
        float f16 = a16 / r3.width;
        float a17 = eVar.a(12.0f);
        Intrinsics.checkNotNull(getCurStickerModel());
        float f17 = a17 / r1.height;
        if (scaleX < f16) {
            scaleX = f16;
        } else if (scaleX > 1.5f) {
            scaleX = 1.5f;
        }
        if (scaleY < f17) {
            scaleY = f17;
        } else if (scaleY > 1.5f) {
            scaleY = 1.5f;
        }
        boolean z19 = true;
        if (this.curScaleX == scaleX) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            return;
        }
        this.curScaleX = scaleX;
        if (scaleX == f16) {
            z17 = true;
        } else {
            z17 = false;
        }
        if (z17) {
            ac.f326659a.b(getContext(), 100L);
        }
        if (this.curScaleY == scaleY) {
            z18 = true;
        } else {
            z18 = false;
        }
        if (z18) {
            return;
        }
        this.curScaleY = scaleY;
        if (scaleY != f17) {
            z19 = false;
        }
        if (z19) {
            ac.f326659a.b(getContext(), 100L);
        }
    }

    private final void w(float scale) {
        boolean z16;
        if (scale < 0.2f) {
            scale = 0.2f;
        }
        if (scale > 1.5f) {
            scale = 1.5f;
        }
        boolean z17 = true;
        if (this.curScaleX == scale) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            return;
        }
        this.curScaleX = scale;
        this.curScaleY = scale;
        if (scale != 0.2f) {
            z17 = false;
        }
        if (z17) {
            ac.f326659a.b(getContext(), 100L);
        }
    }

    private final boolean x() {
        if (!this.mAdsorptionStatusRight && !this.mAdsorptionStatusTop && !this.mAdsorptionStatusBottom && !this.mAdsorptionStatusLeft) {
            return false;
        }
        return true;
    }

    private final boolean y(MotionEvent event) {
        if (this.onFlingLocation == null) {
            return false;
        }
        int i3 = this.minMoveDistance * 6;
        float x16 = event.getX();
        PointF pointF = this.onFlingLocation;
        Intrinsics.checkNotNull(pointF);
        if (Math.abs(x16 - pointF.x) <= this.minMoveDistance) {
            return false;
        }
        float y16 = event.getY();
        PointF pointF2 = this.onFlingLocation;
        Intrinsics.checkNotNull(pointF2);
        if (Math.abs(y16 - pointF2.y) >= i3) {
            return false;
        }
        return true;
    }

    private final boolean z(MotionEvent event) {
        if (this.onclickLocation == null) {
            return true;
        }
        float x16 = event.getX();
        PointF pointF = this.onclickLocation;
        Intrinsics.checkNotNull(pointF);
        if (Math.abs(x16 - pointF.x) >= this.minMoveDistance) {
            return true;
        }
        float y16 = event.getY();
        PointF pointF2 = this.onclickLocation;
        Intrinsics.checkNotNull(pointF2);
        if (Math.abs(y16 - pointF2.y) >= this.minMoveDistance) {
            return true;
        }
        return false;
    }

    /* renamed from: A, reason: from getter */
    public final boolean getIsStickerActive() {
        return this.isStickerActive;
    }

    public final void G() {
        this.mCallBack = null;
        this.mBorderLineCallBack = null;
        this.mGestureDetectCallback = null;
        this.mCutSizeCallBack = null;
    }

    public final void d() {
        this.disallowSwipeByOthers = false;
    }

    public final void f() {
        this.disallowSwipeByOthers = true;
    }

    @Nullable
    /* renamed from: i, reason: from getter */
    public WinkStickerModel getCurStickerModel() {
        return this.curStickerModel;
    }

    public final int n() {
        b bVar = this.mGestureDetectCallback;
        if (bVar != null) {
            return (bVar.getRenderWidth() - bVar.i1()) / 2;
        }
        return 0;
    }

    public final int o() {
        b bVar = this.mGestureDetectCallback;
        if (bVar == null || bVar.getRenderHeight() < bVar.K()) {
            return 0;
        }
        return (bVar.getRenderHeight() - bVar.K()) / 2;
    }

    @Override // android.view.View
    public boolean onTouchEvent(@NotNull MotionEvent event) {
        Intrinsics.checkNotNullParameter(event, "event");
        this.actionIndex = event.getActionIndex();
        int action = event.getAction() & 255;
        if (action != 0) {
            if (action != 1) {
                if (action != 2) {
                    if (action != 3) {
                        if (action != 5) {
                            if (action != 6) {
                                return false;
                            }
                            return t(event);
                        }
                        return s(event);
                    }
                } else {
                    return r(event);
                }
            }
            return u(event);
        }
        return q(event);
    }

    public boolean q(@NotNull MotionEvent event) {
        boolean z16;
        e eVar;
        boolean z17;
        Intrinsics.checkNotNullParameter(event, "event");
        this.hasStopOnDown = false;
        this.downPoint.x = event.getX();
        this.downPoint.y = event.getY();
        this.downPointBg.x = event.getX() + n();
        this.downPointBg.y = event.getY() + o();
        PointF pointF = this.downPoint;
        PointF pointF2 = new PointF(pointF.x, pointF.y);
        this.onclickLocation = pointF2;
        if (this.onDoubleClickLocation == null) {
            this.onDoubleClickLocation = pointF2;
        }
        if (this.isStickerActive) {
            e eVar2 = this.mCallBack;
            if (eVar2 != null) {
                Intrinsics.checkNotNull(eVar2);
                if (eVar2.u8()) {
                    e eVar3 = this.mCallBack;
                    Intrinsics.checkNotNull(eVar3);
                    RectF h36 = eVar3.h3();
                    PointF pointF3 = this.downPoint;
                    boolean contains = h36.contains(pointF3.x, pointF3.y);
                    this.isTouchInCreatorInfoRect = contains;
                    if (contains && getCurStickerModel() != null) {
                        e eVar4 = this.mCallBack;
                        Intrinsics.checkNotNull(eVar4);
                        eVar4.A3(getCurStickerModel());
                        this.hasStopOnDown = true;
                        return true;
                    }
                }
            }
            this.isTouchInCreatorInfoRect = false;
        }
        if (this.mCallBack != null) {
            setCurStickerModel(null);
            e eVar5 = this.mCallBack;
            Intrinsics.checkNotNull(eVar5);
            PointF pointF4 = this.downPoint;
            setCurStickerModel(eVar5.e1(pointF4.x, pointF4.y, event.getRawX(), event.getRawY()));
        }
        WinkStickerModel curStickerModel = getCurStickerModel();
        if (curStickerModel != null && curStickerModel.isMosaicDoodleSticker()) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            return false;
        }
        if (this.isStickerActive && (eVar = this.mCallBack) != null) {
            Intrinsics.checkNotNull(eVar);
            RectF U4 = eVar.U4();
            PointF pointF5 = this.downPoint;
            boolean contains2 = U4.contains(pointF5.x, pointF5.y);
            this.isTouchInSingleZoomRotateRect = contains2;
            if (contains2 && getCurStickerModel() != null) {
                WinkStickerModel curStickerModel2 = getCurStickerModel();
                Intrinsics.checkNotNull(curStickerModel2);
                float f16 = curStickerModel2.getCenterInView().f320587x - this.downPointBg.x;
                WinkStickerModel curStickerModel3 = getCurStickerModel();
                Intrinsics.checkNotNull(curStickerModel3);
                float f17 = curStickerModel3.getCenterInView().f320588y - this.downPointBg.y;
                WinkStickerModel curStickerModel4 = getCurStickerModel();
                Intrinsics.checkNotNull(curStickerModel4);
                float f18 = curStickerModel4.getCenterInView().f320587x;
                WinkStickerModel curStickerModel5 = getCurStickerModel();
                Intrinsics.checkNotNull(curStickerModel5);
                PointF pointF6 = new PointF(f18, curStickerModel5.getCenterInView().f320588y);
                this.twoPointDownRotate = p(f16, f17);
                u uVar = u.f326728a;
                this.twoPointDownDistance = uVar.g(pointF6, this.downPointBg);
                this.twoPointDownDistanceX = uVar.h(pointF6, this.downPointBg);
                this.twoPointDownDistanceY = uVar.i(pointF6, this.downPointBg);
                WinkStickerModel curStickerModel6 = getCurStickerModel();
                Intrinsics.checkNotNull(curStickerModel6);
                MetaMaterial material = curStickerModel6.getMaterial();
                if (material != null && m.N(material)) {
                    z17 = true;
                } else {
                    z17 = false;
                }
                if (z17) {
                    WinkStickerModel curStickerModel7 = getCurStickerModel();
                    Intrinsics.checkNotNull(curStickerModel7);
                    this.twoPointDownDistanceX = (curStickerModel7.getCenterInView().f320587x - n()) - U4.centerX();
                    WinkStickerModel curStickerModel8 = getCurStickerModel();
                    Intrinsics.checkNotNull(curStickerModel8);
                    this.twoPointDownDistanceY = (curStickerModel8.getCenterInView().f320588y - o()) - U4.centerY();
                }
            }
            e eVar6 = this.mCallBack;
            Intrinsics.checkNotNull(eVar6);
            if (eVar6.N4()) {
                e eVar7 = this.mCallBack;
                Intrinsics.checkNotNull(eVar7);
                RectF K0 = eVar7.K0();
                PointF pointF7 = this.downPoint;
                boolean contains3 = K0.contains(pointF7.x, pointF7.y);
                this.isTouchInSingleDeleteRect = contains3;
                if (contains3 && getCurStickerModel() != null) {
                    e eVar8 = this.mCallBack;
                    Intrinsics.checkNotNull(eVar8);
                    eVar8.w2(getCurStickerModel());
                    H();
                }
            } else {
                this.isTouchInSingleDeleteRect = false;
            }
        }
        if (getCurStickerModel() == null) {
            PointF pointF8 = this.downPoint;
            this.onFlingLocation = new PointF(pointF8.x, pointF8.y);
            return this.canConsumeAllEvent;
        }
        if (QLog.isColorLevel()) {
            WinkStickerModel curStickerModel9 = getCurStickerModel();
            Intrinsics.checkNotNull(curStickerModel9);
            ms.a.f("WinkBorderView", "Sticker model got: " + curStickerModel9.id);
        }
        WinkStickerModel curStickerModel10 = getCurStickerModel();
        Intrinsics.checkNotNull(curStickerModel10);
        float f19 = curStickerModel10.getLeftTopInView().f320587x;
        WinkStickerModel curStickerModel11 = getCurStickerModel();
        Intrinsics.checkNotNull(curStickerModel11);
        this.mStickerStartLeft = f19 + curStickerModel11.getOriginPointInView().f320587x;
        WinkStickerModel curStickerModel12 = getCurStickerModel();
        Intrinsics.checkNotNull(curStickerModel12);
        float f26 = curStickerModel12.getLeftTopInView().f320588y;
        WinkStickerModel curStickerModel13 = getCurStickerModel();
        Intrinsics.checkNotNull(curStickerModel13);
        this.mStickerStartTop = f26 + curStickerModel13.getOriginPointInView().f320588y;
        WinkStickerModel curStickerModel14 = getCurStickerModel();
        Intrinsics.checkNotNull(curStickerModel14);
        WinkStickerModel curStickerModel15 = getCurStickerModel();
        Intrinsics.checkNotNull(curStickerModel15);
        curStickerModel14.setLastDownScaleX(curStickerModel15.scaleX);
        WinkStickerModel curStickerModel16 = getCurStickerModel();
        Intrinsics.checkNotNull(curStickerModel16);
        WinkStickerModel curStickerModel17 = getCurStickerModel();
        Intrinsics.checkNotNull(curStickerModel17);
        curStickerModel16.setLastDownScaleY(curStickerModel17.scaleY);
        WinkStickerModel curStickerModel18 = getCurStickerModel();
        Intrinsics.checkNotNull(curStickerModel18);
        WinkStickerModel curStickerModel19 = getCurStickerModel();
        Intrinsics.checkNotNull(curStickerModel19);
        curStickerModel18.setLastDownRotate(curStickerModel19.rotate * (-1));
        b bVar = this.mGestureDetectCallback;
        if (bVar != null) {
            bVar.a6();
        }
        return true;
    }

    public boolean r(@NotNull MotionEvent event) {
        boolean z16;
        Intrinsics.checkNotNullParameter(event, "event");
        boolean z17 = false;
        if (!this.hasStopOnDown) {
            WinkStickerModel curStickerModel = getCurStickerModel();
            if (curStickerModel != null && curStickerModel.isMosaicDoodleSticker()) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (!z16) {
                float x16 = event.getX() + n();
                float y16 = event.getY() + o();
                if (getCurStickerModel() == null) {
                    return true;
                }
                if (event.getPointerCount() == 2) {
                    float x17 = event.getX(1) - event.getX(0);
                    float y17 = event.getY(1) - event.getY(0);
                    WinkStickerModel curStickerModel2 = getCurStickerModel();
                    Intrinsics.checkNotNull(curStickerModel2);
                    MetaMaterial material = curStickerModel2.getMaterial();
                    if (material != null && m.N(material)) {
                        z17 = true;
                    }
                    if (z17) {
                        E(x17, y17);
                    } else {
                        F(x17, y17);
                    }
                } else if (event.getPointerCount() == 1) {
                    if (this.isTouchInSingleZoomRotateRect) {
                        WinkStickerModel curStickerModel3 = getCurStickerModel();
                        Intrinsics.checkNotNull(curStickerModel3);
                        MetaMaterial material2 = curStickerModel3.getMaterial();
                        if (material2 != null && m.N(material2)) {
                            z17 = true;
                        }
                        if (z17) {
                            PointF pointF = this.downPointBg;
                            E((pointF.x + this.twoPointDownDistanceX) - x16, (pointF.y + this.twoPointDownDistanceY) - y16);
                        } else {
                            WinkStickerModel curStickerModel4 = getCurStickerModel();
                            Intrinsics.checkNotNull(curStickerModel4);
                            float f16 = curStickerModel4.getCenterInView().f320587x - x16;
                            WinkStickerModel curStickerModel5 = getCurStickerModel();
                            Intrinsics.checkNotNull(curStickerModel5);
                            F(f16, curStickerModel5.getCenterInView().f320588y - y16);
                        }
                        WinkDatongCurrentParams.put(WinkDaTongReportConstant.ElementParamKey.XSJ_IS_PASTE_ONEHAND_MODIFIED, "1");
                    } else if (!this.mHasScaleOrRotate) {
                        float x18 = event.getX() - this.downPoint.x;
                        float y18 = event.getY() - this.downPoint.y;
                        float f17 = this.mStickerStartLeft + x18;
                        float f18 = this.mStickerStartTop + y18;
                        if (z(event)) {
                            this.hasMoveAfterDown = true;
                        }
                        if (!this.hasMoveAfterDown) {
                            return true;
                        }
                        C(e(f17, f18));
                    }
                }
                b bVar = this.mGestureDetectCallback;
                if (bVar != null) {
                    bVar.Sd(event.getPointerCount());
                }
                WinkDatongCurrentParams.put(WinkDaTongReportConstant.ElementParamKey.XSJ_IS_PASTE_MODIFIED, "1");
                return true;
            }
        }
        return false;
    }

    public boolean s(@NotNull MotionEvent event) {
        e eVar;
        Intrinsics.checkNotNullParameter(event, "event");
        if (getCurStickerModel() == null && (eVar = this.mCallBack) != null) {
            Intrinsics.checkNotNull(eVar);
            setCurStickerModel(eVar.U(new PointF(event.getX(0), event.getY(0)), new PointF(event.getX(1), event.getY(1))));
            if (getCurStickerModel() == null) {
                return true;
            }
            if (QLog.isColorLevel()) {
                WinkStickerModel curStickerModel = getCurStickerModel();
                Intrinsics.checkNotNull(curStickerModel);
                ms.a.f("WinkBorderView", "sticker model get with two finger: " + curStickerModel.id);
            }
            WinkStickerModel curStickerModel2 = getCurStickerModel();
            Intrinsics.checkNotNull(curStickerModel2);
            WinkStickerModel curStickerModel3 = getCurStickerModel();
            Intrinsics.checkNotNull(curStickerModel3);
            curStickerModel2.setLastDownScaleX(curStickerModel3.scaleX);
            WinkStickerModel curStickerModel4 = getCurStickerModel();
            Intrinsics.checkNotNull(curStickerModel4);
            WinkStickerModel curStickerModel5 = getCurStickerModel();
            Intrinsics.checkNotNull(curStickerModel5);
            curStickerModel4.setLastDownScaleY(curStickerModel5.scaleY);
            WinkStickerModel curStickerModel6 = getCurStickerModel();
            Intrinsics.checkNotNull(curStickerModel6);
            WinkStickerModel curStickerModel7 = getCurStickerModel();
            Intrinsics.checkNotNull(curStickerModel7);
            curStickerModel6.setLastDownRotate(curStickerModel7.rotate * (-1));
        }
        PointF pointF = new PointF(event.getX(this.actionIndex), event.getY(this.actionIndex));
        float x16 = event.getX(1) - event.getX(0);
        float y16 = event.getY(1) - event.getY(0);
        u uVar = u.f326728a;
        this.twoPointDownDistance = uVar.g(pointF, this.downPoint);
        this.twoPointDownDistanceX = uVar.h(pointF, this.downPoint);
        this.twoPointDownDistanceY = uVar.i(pointF, this.downPoint);
        this.twoPointDownRotate = p(x16, y16);
        b bVar = this.mGestureDetectCallback;
        if (bVar != null) {
            bVar.va();
        }
        return true;
    }

    public final void setActionIndex(int i3) {
        this.actionIndex = i3;
    }

    public final void setBorderLineCallBack(@NotNull c borderLineCallBack) {
        Intrinsics.checkNotNullParameter(borderLineCallBack, "borderLineCallBack");
        this.mBorderLineCallBack = borderLineCallBack;
    }

    public final void setBorderViewEventConsumable(boolean enable) {
        this.canConsumeAllEvent = enable;
    }

    public final void setCanConsumeAllEvent(boolean z16) {
        this.canConsumeAllEvent = z16;
    }

    public void setCurStickerModel(@Nullable WinkStickerModel winkStickerModel) {
        this.curStickerModel = winkStickerModel;
    }

    public final void setCutSizeCallBack(@Nullable d cutSizeCallBack) {
        this.mCutSizeCallBack = cutSizeCallBack;
    }

    public final void setGestureDetectorCallback(@NotNull b gestureDetectCallback) {
        Intrinsics.checkNotNullParameter(gestureDetectCallback, "gestureDetectCallback");
        this.mGestureDetectCallback = gestureDetectCallback;
    }

    public final void setMBoundaryX(float f16) {
        this.mBoundaryX = f16;
    }

    public final void setMBoundaryY(float f16) {
        this.mBoundaryY = f16;
    }

    public final void setMContainerSize(@Nullable Size size) {
        this.mContainerSize = size;
    }

    public final void setMRenderSize(@Nullable Size size) {
        this.mRenderSize = size;
    }

    public final void setOperationCallback(@Nullable e callback) {
        this.mCallBack = callback;
    }

    public final void setStickerActive(boolean z16) {
        this.isStickerActive = z16;
    }

    public final boolean t(@NotNull MotionEvent event) {
        Intrinsics.checkNotNullParameter(event, "event");
        if (event.getPointerId(this.actionIndex) == 0) {
            this.downPoint.x = event.getX(1);
            this.downPoint.y = event.getY(1);
        } else if (event.getPointerId(this.actionIndex) == 1) {
            this.downPoint.x = event.getX(0);
            this.downPoint.y = event.getY(0);
        }
        this.onFlingLocation = null;
        return true;
    }

    public boolean u(@NotNull MotionEvent event) {
        boolean z16;
        Direction direction;
        Intrinsics.checkNotNullParameter(event, "event");
        if (this.isTouchInCreatorInfoRect) {
            return true;
        }
        if (!z(event) && !this.hasMoveAfterDown) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (getCurStickerModel() != null) {
            WinkStickerModel curStickerModel = getCurStickerModel();
            Intrinsics.checkNotNull(curStickerModel);
            curStickerModel.setLastDownScaleX(this.curScaleX);
            WinkStickerModel curStickerModel2 = getCurStickerModel();
            Intrinsics.checkNotNull(curStickerModel2);
            curStickerModel2.setLastDownScaleY(this.curScaleY);
            if (z16) {
                if (System.currentTimeMillis() - this.firstClickTime < f322665p0 && this.onDoubleClickLocation != null) {
                    float x16 = event.getX();
                    PointF pointF = this.onDoubleClickLocation;
                    Intrinsics.checkNotNull(pointF);
                    if (Math.abs(x16 - pointF.x) < f322666q0) {
                        float y16 = event.getY();
                        PointF pointF2 = this.onDoubleClickLocation;
                        Intrinsics.checkNotNull(pointF2);
                        if (Math.abs(y16 - pointF2.y) < f322666q0) {
                            e eVar = this.mCallBack;
                            if (eVar != null) {
                                eVar.W0(getCurStickerModel());
                            }
                            this.onDoubleClickLocation = null;
                            this.firstClickTime = 0L;
                            this.isStickerActive = true;
                        }
                    }
                }
                if (!this.isTouchInSingleDeleteRect && !this.isTouchInCreatorInfoRect) {
                    this.firstClickTime = System.currentTimeMillis();
                    this.onDoubleClickLocation = this.onclickLocation;
                    e eVar2 = this.mCallBack;
                    if (eVar2 != null) {
                        eVar2.Z0(getCurStickerModel());
                    }
                }
                this.isStickerActive = true;
            }
            b bVar = this.mGestureDetectCallback;
            if (bVar != null) {
                bVar.Pb(z16, this.isStickerActive);
            }
        } else {
            b bVar2 = this.mGestureDetectCallback;
            if (bVar2 != null) {
                bVar2.xg(z16, event.getRawY());
            }
            if (z16) {
                e eVar3 = this.mCallBack;
                if (eVar3 != null) {
                    eVar3.Z0(null);
                }
                this.isStickerActive = false;
            }
        }
        if (this.onFlingLocation != null && getCurStickerModel() == null && y(event) && !this.disallowSwipeByOthers) {
            b bVar3 = this.mGestureDetectCallback;
            if (bVar3 != null) {
                float x17 = event.getX();
                PointF pointF3 = this.onFlingLocation;
                Intrinsics.checkNotNull(pointF3);
                if (x17 > pointF3.x) {
                    direction = Direction.Right;
                } else {
                    direction = Direction.Left;
                }
                bVar3.hc(direction);
            }
            e eVar4 = this.mCallBack;
            if (eVar4 != null) {
                eVar4.M1();
            }
        }
        e eVar5 = this.mCallBack;
        if (eVar5 != null) {
            eVar5.M3(this.mUpdatedStickerModel);
        }
        I();
        this.mHasScaleOrRotate = false;
        this.hasMoveAfterDown = false;
        this.mUpdatedStickerModel = null;
        return true;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public BorderView(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.checkNotNullParameter(context, "context");
        this.f322686n0 = new LinkedHashMap();
        this.downPoint = new PointF();
        this.downPointBg = new PointF();
        this.minMoveDistance = ViewConfiguration.get(getContext()).getScaledTouchSlop();
        this.curScaleX = 1.0f;
        this.curScaleY = 1.0f;
        this.canConsumeAllEvent = true;
        LayoutInflater.from(context).inflate(R.layout.hef, this);
    }

    public /* synthetic */ BorderView(Context context, AttributeSet attributeSet, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i3 & 2) != 0 ? null : attributeSet);
    }
}

package com.tencent.filament.zplan.view.controller;

import al0.a;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.PointF;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.text.TextUtils;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.ScaleGestureDetector;
import android.view.Surface;
import android.view.View;
import androidx.exifinterface.media.ExifInterface;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.filament.zplan.data.AnimationStatus;
import com.tencent.filament.zplan.data.RenderSize;
import com.tencent.filament.zplan.listener.GYScreenShotCallback;
import com.tencent.filament.zplan.listener.IAnimationSetListener;
import com.tencent.filament.zplan.util.vsync.VSyncScheduler;
import com.tencent.filament.zplan.util.vsync.b;
import com.tencent.filament.zplan.view.controller.FilamentTouchController;
import com.tencent.filament.zplan.view.controller.GYFZPlanController;
import com.tencent.filament.zplan.view.controller.GYFZPlanController$vSyncListener$2;
import com.tencent.filament.zplan.view.event.TouchEvent;
import com.tencent.filament.zplanservice.feature.FilamentFeatureUtil;
import com.tencent.filament.zplanservice.util.log.FLog;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.live2.impl.V2TXLiveDefInner;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qaddefine.QAdReportDefine$AdReporterParams;
import cooperation.qzone.QzoneIPCModule;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import org.apache.httpcore.message.TokenParser;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

@Metadata(d1 = {"\u0000\u00fc\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0015\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u001f\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010!\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\r*\u0002\u00d6\u0001\b\u0016\u0018\u0000 \u00ba\u00012\u00020\u0001:\u0004\\dkqB*\b\u0016\u0012\u0007\u0010\u00e4\u0001\u001a\u00020\u001a\u0012\t\b\u0002\u0010\u00e5\u0001\u001a\u00020\n\u0012\t\b\u0002\u0010\u00e6\u0001\u001a\u00020\n\u00a2\u0006\u0006\b\u00e7\u0001\u0010\u00e8\u0001B5\b\u0016\u0012\u0007\u0010\u00e4\u0001\u001a\u00020\u001a\u0012\t\b\u0002\u0010\u00e9\u0001\u001a\u00020\b\u0012\t\b\u0002\u0010\u00e5\u0001\u001a\u00020\n\u0012\t\b\u0002\u0010\u00e6\u0001\u001a\u00020\n\u00a2\u0006\u0006\b\u00e7\u0001\u0010\u00ea\u0001J\u0018\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0002J\b\u0010\u0007\u001a\u00020\u0005H\u0002J&\u0010\u000e\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\n2\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00050\fH\u0002J&\u0010\u0011\u001a\u00020\u00052\u0006\u0010\u000f\u001a\u00020\b2\u0006\u0010\u0010\u001a\u00020\u00022\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00050\fH\u0002J\u0010\u0010\u0013\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\u0012H\u0002J\u0010\u0010\u0016\u001a\u00020\n2\u0006\u0010\u0015\u001a\u00020\u0014H\u0002J\u0010\u0010\u0018\u001a\u00020\u00142\u0006\u0010\u0017\u001a\u00020\u0014H\u0002J\u0010\u0010\u0019\u001a\u00020\u00142\u0006\u0010\u0017\u001a\u00020\u0014H\u0002J\u0018\u0010\u001d\u001a\u00020\u00052\u0006\u0010\u001b\u001a\u00020\u001a2\b\b\u0002\u0010\u001c\u001a\u00020\nJ\u0006\u0010\u001e\u001a\u00020\u0005J\u0006\u0010\u001f\u001a\u00020\u0005J\b\u0010 \u001a\u00020\u0005H\u0016J&\u0010\"\u001a\u00020\u00052\u0006\u0010!\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\n2\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00050\fH\u0004J\u001c\u0010#\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\b2\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00050\fJ\u001e\u0010(\u001a\u00020\u00052\u0006\u0010%\u001a\u00020$2\u0006\u0010&\u001a\u00020\u00142\u0006\u0010'\u001a\u00020\u0014J\u0016\u0010*\u001a\u00020\u00052\u0006\u0010)\u001a\u00020\b2\u0006\u0010\u0015\u001a\u00020\u0014J\u000e\u0010,\u001a\u00020\u00052\u0006\u0010+\u001a\u00020\bJ\u0016\u0010/\u001a\u00020\u00052\u0006\u0010-\u001a\u00020\b2\u0006\u0010.\u001a\u00020\bJ(\u00102\u001a\u00020\u00052\u0006\u0010)\u001a\u00020\b2\u0006\u00100\u001a\u00020\b2\u0006\u0010\u0015\u001a\u00020\u00142\b\b\u0002\u00101\u001a\u00020\u0014J(\u00104\u001a\u00020\u00052\u0006\u00103\u001a\u00020\b2\u0006\u00100\u001a\u00020\b2\u0006\u0010\u0015\u001a\u00020\u00142\b\b\u0002\u0010)\u001a\u00020\bJ\u000e\u00107\u001a\u00020\u00052\u0006\u00106\u001a\u000205J\u0016\u0010:\u001a\u00020\u00052\u0006\u00108\u001a\u00020\b2\u0006\u00106\u001a\u000209J\u000e\u0010<\u001a\u00020\u00052\u0006\u00106\u001a\u00020;J\u0006\u0010=\u001a\u00020\u0005J\u0012\u0010@\u001a\u00020\u00052\n\b\u0002\u0010?\u001a\u0004\u0018\u00010>J\u0012\u0010C\u001a\u00020\u00052\n\b\u0002\u0010B\u001a\u0004\u0018\u00010AJ\u000e\u0010E\u001a\u00020\u00052\u0006\u0010D\u001a\u00020\bJ\u0016\u0010H\u001a\u00020\u00052\u0006\u0010G\u001a\u00020F2\u0006\u0010D\u001a\u00020\bJ\u0016\u0010K\u001a\u00020\u00052\u0006\u0010I\u001a\u00020\b2\u0006\u0010J\u001a\u00020\bJ&\u0010Q\u001a\u00020\u00052\u0006\u0010L\u001a\u00020\b2\u0006\u0010M\u001a\u00020\b2\u0006\u0010N\u001a\u00020\b2\u0006\u0010P\u001a\u00020OJ\u0010\u0010U\u001a\u0004\u0018\u00010T2\u0006\u0010S\u001a\u00020RJ\u0010\u0010X\u001a\u00020\u00052\u0006\u0010W\u001a\u00020VH\u0016J\u0006\u0010Y\u001a\u00020\u0005J\u000e\u0010Z\u001a\u00020\u00052\u0006\u0010D\u001a\u00020\bR$\u0010b\u001a\u0004\u0018\u00010[8\u0004@\u0004X\u0084\u000e\u00a2\u0006\u0012\n\u0004\b\\\u0010]\u001a\u0004\b^\u0010_\"\u0004\b`\u0010aR*\u0010j\u001a\u00020\u00142\u0006\u0010c\u001a\u00020\u00148F@FX\u0086\u000e\u00a2\u0006\u0012\n\u0004\bd\u0010e\u001a\u0004\bf\u0010g\"\u0004\bh\u0010iR*\u0010p\u001a\u00020\n2\u0006\u0010c\u001a\u00020\n8F@FX\u0086\u000e\u00a2\u0006\u0012\n\u0004\bk\u0010=\u001a\u0004\bl\u0010m\"\u0004\bn\u0010oR\u0016\u0010r\u001a\u00020\n8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bq\u0010=R\"\u0010v\u001a\u00020\n8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bs\u0010=\u001a\u0004\bt\u0010m\"\u0004\bu\u0010oR\"\u0010z\u001a\u00020\n8\u0004@\u0004X\u0084\u000e\u00a2\u0006\u0012\n\u0004\bw\u0010=\u001a\u0004\bx\u0010m\"\u0004\by\u0010oR\u0014\u0010~\u001a\u00020{8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b|\u0010}R(\u0010\u0085\u0001\u001a\u00020\b8\u0004@\u0004X\u0084\u000e\u00a2\u0006\u0017\n\u0005\b\u007f\u0010\u0080\u0001\u001a\u0006\b\u0081\u0001\u0010\u0082\u0001\"\u0006\b\u0083\u0001\u0010\u0084\u0001R*\u0010\u008d\u0001\u001a\u00030\u0086\u00018\u0004@\u0004X\u0084.\u00a2\u0006\u0018\n\u0006\b\u0087\u0001\u0010\u0088\u0001\u001a\u0006\b\u0089\u0001\u0010\u008a\u0001\"\u0006\b\u008b\u0001\u0010\u008c\u0001R\u001c\u0010\u0091\u0001\u001a\u0005\u0018\u00010\u008e\u00018\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u008f\u0001\u0010\u0090\u0001R\u001f\u0010\u0095\u0001\u001a\u00020T8BX\u0082\u0084\u0002\u00a2\u0006\u000f\n\u0006\b\u0092\u0001\u0010\u0093\u0001\u001a\u0005\be\u0010\u0094\u0001R\u001b\u0010\u0098\u0001\u001a\u0004\u0018\u00010V8\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u0096\u0001\u0010\u0097\u0001R\u001c\u0010\u009c\u0001\u001a\u0005\u0018\u00010\u0099\u00018\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u009a\u0001\u0010\u009b\u0001R\u001a\u0010\u00a0\u0001\u001a\u00030\u009d\u00018\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u009e\u0001\u0010\u009f\u0001R\u001a\u0010\u00a2\u0001\u001a\u00030\u009d\u00018\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u00a1\u0001\u0010\u009f\u0001R\u001a\u0010\u00a4\u0001\u001a\u00030\u009d\u00018\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u00a3\u0001\u0010\u009f\u0001R*\u0010\u00a9\u0001\u001a\u0004\u0018\u0001058\u0004@\u0004X\u0084\u000e\u00a2\u0006\u0017\n\u0005\bX\u0010\u00a5\u0001\u001a\u0006\b\u009f\u0001\u0010\u00a6\u0001\"\u0006\b\u00a7\u0001\u0010\u00a8\u0001R,\u0010\u00b1\u0001\u001a\u0005\u0018\u00010\u00aa\u00018\u0004@\u0004X\u0084\u000e\u00a2\u0006\u0018\n\u0006\b\u00ab\u0001\u0010\u00ac\u0001\u001a\u0006\b\u00ad\u0001\u0010\u00ae\u0001\"\u0006\b\u00af\u0001\u0010\u00b0\u0001R\u001b\u0010\u00b4\u0001\u001a\u0004\u0018\u00010;8\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u00b2\u0001\u0010\u00b3\u0001R\u001e\u0010\u00b8\u0001\u001a\t\u0012\u0004\u0012\u00020\u00120\u00b5\u00018\u0002X\u0082\u0004\u00a2\u0006\b\n\u0006\b\u00b6\u0001\u0010\u00b7\u0001R)\u0010%\u001a\u0004\u0018\u00010$8\u0004@\u0004X\u0084\u000e\u00a2\u0006\u0017\n\u0005\b\u0013\u0010\u00b9\u0001\u001a\u0006\b\u00ba\u0001\u0010\u00bb\u0001\"\u0006\b\u00bc\u0001\u0010\u00bd\u0001R'\u0010\u001b\u001a\u00020\u001a8\u0004@\u0004X\u0084\u000e\u00a2\u0006\u0017\n\u0005\bZ\u0010\u00be\u0001\u001a\u0006\b\u00bf\u0001\u0010\u00c0\u0001\"\u0006\b\u00c1\u0001\u0010\u00c2\u0001R\u0019\u0010\u00c5\u0001\u001a\u00030\u00c3\u00018\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0007\n\u0005\b\u0016\u0010\u00c4\u0001R\u0017\u0010\u00c6\u0001\u001a\u00020\u00148\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bU\u0010eR\u0017\u0010\u00c7\u0001\u001a\u00020\u00148\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bC\u0010eR\u0018\u0010\u00c9\u0001\u001a\u00020\u00148\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0007\n\u0005\b\u00c8\u0001\u0010eR%\u0010\u00cc\u0001\u001a\u00020\n8\u0004@\u0004X\u0084\u000e\u00a2\u0006\u0014\n\u0004\b\"\u0010=\u001a\u0005\b\u00ca\u0001\u0010m\"\u0005\b\u00cb\u0001\u0010oR\u0019\u0010\u00cd\u0001\u001a\u00030\u009d\u00018\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0007\n\u0005\b\u0007\u0010\u009f\u0001R\u0017\u0010\u00ce\u0001\u001a\u00020\u00148\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bx\u0010eR\u0017\u0010\u00cf\u0001\u001a\u00020\u00148\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bf\u0010eR.\u0010\u00d2\u0001\u001a\u00020\n2\u0006\u0010c\u001a\u00020\n8F@FX\u0086\u000e\u00a2\u0006\u0015\n\u0005\b\u00ad\u0001\u0010=\u001a\u0005\b\u00d0\u0001\u0010m\"\u0005\b\u00d1\u0001\u0010oR&\u0010\u00d5\u0001\u001a\u000f\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u00140\u00d3\u00018\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u009f\u0001\u0010\u00d4\u0001R!\u0010\u00d9\u0001\u001a\u00030\u00d6\u00018BX\u0082\u0084\u0002\u00a2\u0006\u0010\n\u0006\b\u0081\u0001\u0010\u0093\u0001\u001a\u0006\b\u00d7\u0001\u0010\u00d8\u0001R \u0010\u00dd\u0001\u001a\u00030\u00da\u00018BX\u0082\u0084\u0002\u00a2\u0006\u000f\n\u0005\b^\u0010\u0093\u0001\u001a\u0006\b\u00db\u0001\u0010\u00dc\u0001R \u0010\u00e1\u0001\u001a\u00030\u00de\u00018BX\u0082\u0084\u0002\u00a2\u0006\u000f\n\u0005\be\u0010\u0093\u0001\u001a\u0006\b\u00df\u0001\u0010\u00e0\u0001R!\u0010\u00e3\u0001\u001a\u00030\u0086\u00018BX\u0082\u0084\u0002\u00a2\u0006\u0010\n\u0006\b\u00bf\u0001\u0010\u0093\u0001\u001a\u0006\b\u00e2\u0001\u0010\u008a\u0001\u00a8\u0006\u00eb\u0001"}, d2 = {"Lcom/tencent/filament/zplan/view/controller/GYFZPlanController;", "Lcom/tencent/filament/zplan/view/controller/FilamentTouchController$b;", "", "frameTimeNanos", "frameTime", "", "W", "B", "", "from", "", "openLog", "Lkotlin/Function0;", "task", "b0", "taskName", "delay", "c0", "Ljava/lang/Runnable;", "u", "", QAdReportDefine$AdReporterParams.K_Q_AD_REPORTER_PARAM_KEY_REQUEST_ID, "w", "originCode", "w0", "v0", "Lcom/tencent/filament/zplan/data/RenderSize;", "renderSize", "update", "q0", "Y", "t0", BdhLogUtil.LogTag.Tag_Req, "funName", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "a0", "Landroid/view/Surface;", "surface", "width", "height", "d0", "uin", "j0", "path", "m0", "baseTemplateJson", "iblPath", "l0", "faceJson", QzoneIPCModule.RESULT_CODE, "k0", "avatarInfo", "h0", "Lcom/tencent/filament/zplan/view/controller/GYFZPlanController$c;", "listener", "n0", "animationPath", "Lcom/tencent/filament/zplan/listener/IAnimationSetListener;", "g0", "Luk0/a;", "o0", "Z", "Lcom/tencent/filament/zplan/listener/GYScreenShotCallback;", "callback", "u0", "Lcom/tencent/filament/zplan/view/controller/GYFZPlanController$d;", "viewerDestroyCallback", "y", "slotID", "X", "", "primitiveIndexArr", AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, "configJson", "dirPath", "s0", "slot", "materialName", "parameterName", "Landroid/graphics/Bitmap;", "texture", "e0", "Landroid/content/Context;", "context", "Landroid/view/View$OnTouchListener;", HippyTKDListViewAdapter.X, "Lcom/tencent/filament/zplan/view/event/TouchEvent;", "touchEvent", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "f0", "v", "Lcom/tencent/filament/zplan/view/controller/GYFZPlanNativeAPI;", "a", "Lcom/tencent/filament/zplan/view/controller/GYFZPlanNativeAPI;", "H", "()Lcom/tencent/filament/zplan/view/controller/GYFZPlanNativeAPI;", "p0", "(Lcom/tencent/filament/zplan/view/controller/GYFZPlanNativeAPI;)V", "nativeAPI", "value", "b", "I", "D", "()I", "setFps", "(I)V", "fps", "c", "T", "()Z", "setLogGpuError", "(Z)V", "isLogGpuError", "d", "isEnableDelayed", "e", "U", "setOffScreen", "isOffScreen", "f", BdhLogUtil.LogTag.Tag_Conn, "setAllowCameraManipulator", "allowCameraManipulator", "Ljava/util/concurrent/atomic/AtomicBoolean;", "g", "Ljava/util/concurrent/atomic/AtomicBoolean;", "attached", h.F, "Ljava/lang/String;", "G", "()Ljava/lang/String;", "setMBootConfigJson", "(Ljava/lang/String;)V", "mBootConfigJson", "Landroid/os/Handler;", "i", "Landroid/os/Handler;", "L", "()Landroid/os/Handler;", "r0", "(Landroid/os/Handler;)V", "uiHandler", "Lcom/tencent/filament/zplan/view/controller/FilamentTouchController;", "j", "Lcom/tencent/filament/zplan/view/controller/FilamentTouchController;", "filamentTouchController", "k", "Lkotlin/Lazy;", "()Landroid/view/View$OnTouchListener;", "onTouchListener", "l", "Lcom/tencent/filament/zplan/view/event/TouchEvent;", "lastTouchEvent", "Landroid/graphics/PointF;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Landroid/graphics/PointF;", "mLastPinchPoint", "", DomainData.DOMAIN_NAME, UserInfo.SEX_FEMALE, "mLastScale", "o", "mScaleDeltaSum", "p", "mRotateAvatarSum", "Lcom/tencent/filament/zplan/view/controller/GYFZPlanController$c;", "()Lcom/tencent/filament/zplan/view/controller/GYFZPlanController$c;", "setLoadAvatarListener", "(Lcom/tencent/filament/zplan/view/controller/GYFZPlanController$c;)V", "loadAvatarListener", "Lcom/tencent/filament/zplan/view/controller/GYFZPlanController$b;", "r", "Lcom/tencent/filament/zplan/view/controller/GYFZPlanController$b;", "E", "()Lcom/tencent/filament/zplan/view/controller/GYFZPlanController$b;", "setFpsListener", "(Lcom/tencent/filament/zplan/view/controller/GYFZPlanController$b;)V", "fpsListener", ReportConstant.COSTREPORT_PREFIX, "Luk0/a;", "firstFrameFinishCallback", "", "t", "Ljava/util/List;", "viewerWaitList", "Landroid/view/Surface;", "K", "()Landroid/view/Surface;", V2TXLiveDefInner.TXLivePropertyKey.kV2SetSurface, "(Landroid/view/Surface;)V", "Lcom/tencent/filament/zplan/data/RenderSize;", "J", "()Lcom/tencent/filament/zplan/data/RenderSize;", "setRenderSize", "(Lcom/tencent/filament/zplan/data/RenderSize;)V", "Lcom/tencent/filament/zplan/data/AnimationStatus;", "Lcom/tencent/filament/zplan/data/AnimationStatus;", "playStatus", "uinCurrentRequestId", "faceJsonCurrentRequestId", QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, "fJCurrentRequestIdByAInfo", "V", "setReentrant", "isReentrant", "scaleMax", "templateStatus", "drawFrameCounts", ExifInterface.LATITUDE_SOUTH, "setAvatarInfoCacheByUin", "isAvatarInfoCacheByUin", "Ljava/util/HashMap;", "Ljava/util/HashMap;", "avatarInfoCacheMap", "com/tencent/filament/zplan/view/controller/GYFZPlanController$vSyncListener$2$a", "M", "()Lcom/tencent/filament/zplan/view/controller/GYFZPlanController$vSyncListener$2$a;", "vSyncListener", "Lcom/tencent/filament/zplan/util/vsync/VSyncScheduler;", "N", "()Lcom/tencent/filament/zplan/util/vsync/VSyncScheduler;", "vSyncScheduler", "Landroid/os/HandlerThread;", "P", "()Landroid/os/HandlerThread;", "viewerHandlerThread", "O", "viewerHandler", "size", "isOffScreen_", "openCameraManipulator", "<init>", "(Lcom/tencent/filament/zplan/data/RenderSize;ZZ)V", "bootConfigJson", "(Lcom/tencent/filament/zplan/data/RenderSize;Ljava/lang/String;ZZ)V", "zplan-android_release"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes6.dex */
public class GYFZPlanController implements FilamentTouchController.b {

    /* renamed from: A, reason: from kotlin metadata */
    private boolean isReentrant;

    /* renamed from: B, reason: from kotlin metadata */
    private float scaleMax;

    /* renamed from: C, reason: from kotlin metadata */
    private int templateStatus;

    /* renamed from: D, reason: from kotlin metadata */
    private int drawFrameCounts;

    /* renamed from: E, reason: from kotlin metadata */
    private boolean isAvatarInfoCacheByUin;

    /* renamed from: F, reason: from kotlin metadata */
    private HashMap<String, Integer> avatarInfoCacheMap;

    /* renamed from: G, reason: from kotlin metadata */
    private final Lazy vSyncListener;

    /* renamed from: H, reason: from kotlin metadata */
    private final Lazy vSyncScheduler;

    /* renamed from: I, reason: from kotlin metadata */
    private final Lazy viewerHandlerThread;

    /* renamed from: J, reason: from kotlin metadata */
    private final Lazy viewerHandler;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private GYFZPlanNativeAPI nativeAPI;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private int fps;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private boolean isLogGpuError;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private boolean isEnableDelayed;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private boolean isOffScreen;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private boolean allowCameraManipulator;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    private final AtomicBoolean attached;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private String mBootConfigJson;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    protected Handler uiHandler;

    /* renamed from: j, reason: collision with root package name and from kotlin metadata */
    private FilamentTouchController filamentTouchController;

    /* renamed from: k, reason: collision with root package name and from kotlin metadata */
    private final Lazy onTouchListener;

    /* renamed from: l, reason: collision with root package name and from kotlin metadata */
    private TouchEvent lastTouchEvent;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private PointF mLastPinchPoint;

    /* renamed from: n, reason: collision with root package name and from kotlin metadata */
    private float mLastScale;

    /* renamed from: o, reason: collision with root package name and from kotlin metadata */
    private float mScaleDeltaSum;

    /* renamed from: p, reason: collision with root package name and from kotlin metadata */
    private float mRotateAvatarSum;

    /* renamed from: q, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private c loadAvatarListener;

    /* renamed from: r, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private b fpsListener;

    /* renamed from: s, reason: collision with root package name and from kotlin metadata */
    private uk0.a firstFrameFinishCallback;

    /* renamed from: t, reason: collision with root package name and from kotlin metadata */
    private final List<Runnable> viewerWaitList;

    /* renamed from: u, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private Surface surface;

    /* renamed from: v, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private RenderSize renderSize;

    /* renamed from: w, reason: collision with root package name and from kotlin metadata */
    private AnimationStatus playStatus;

    /* renamed from: x, reason: collision with root package name and from kotlin metadata */
    private int uinCurrentRequestId;

    /* renamed from: y, reason: collision with root package name and from kotlin metadata */
    private int faceJsonCurrentRequestId;

    /* renamed from: z, reason: collision with root package name and from kotlin metadata */
    private int fJCurrentRequestIdByAInfo;

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u0019\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H&\u00a2\u0006\u0004\b\u0005\u0010\u0006\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/filament/zplan/view/controller/GYFZPlanController$b;", "", "", "fps", "", "a", "(Ljava/lang/Float;)V", "zplan-android_release"}, k = 1, mv = {1, 4, 2})
    /* loaded from: classes6.dex */
    public interface b {
        void a(@Nullable Float fps);
    }

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0018\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H&\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/filament/zplan/view/controller/GYFZPlanController$c;", "", "", "result", QAdReportDefine$AdReporterParams.K_Q_AD_REPORTER_PARAM_KEY_REQUEST_ID, "", "a", "zplan-android_release"}, k = 1, mv = {1, 4, 2})
    /* loaded from: classes6.dex */
    public interface c {
        void a(int result, int requestId);
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H&\u00a8\u0006\u0004"}, d2 = {"Lcom/tencent/filament/zplan/view/controller/GYFZPlanController$d;", "", "", "a", "zplan-android_release"}, k = 1, mv = {1, 4, 2})
    /* loaded from: classes6.dex */
    public interface d {
        void a();
    }

    public /* synthetic */ GYFZPlanController(RenderSize renderSize, boolean z16, boolean z17, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(renderSize, (i3 & 2) != 0 ? false : z16, (i3 & 4) != 0 ? false : z17);
    }

    private final void B() {
        ArrayList arrayList = new ArrayList();
        synchronized (this.viewerWaitList) {
            arrayList.addAll(this.viewerWaitList);
            this.viewerWaitList.clear();
            Unit unit = Unit.INSTANCE;
        }
        int size = arrayList.size();
        if (size == 0) {
            return;
        }
        FLog.INSTANCE.i("GYFZPlanController", "evaluateViewerWaitList, total:" + size);
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            ((Runnable) it.next()).run();
        }
    }

    private final View.OnTouchListener I() {
        return (View.OnTouchListener) this.onTouchListener.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final GYFZPlanController$vSyncListener$2.a M() {
        return (GYFZPlanController$vSyncListener$2.a) this.vSyncListener.getValue();
    }

    private final VSyncScheduler N() {
        return (VSyncScheduler) this.vSyncScheduler.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Handler O() {
        return (Handler) this.viewerHandler.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final HandlerThread P() {
        return (HandlerThread) this.viewerHandlerThread.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void W(final long frameTimeNanos, long frameTime) {
        final Float f16;
        GYFZPlanNativeAPI gYFZPlanNativeAPI;
        if (this.nativeAPI == null) {
            return;
        }
        boolean z16 = true;
        this.drawFrameCounts++;
        synchronized (this.playStatus) {
            if (this.playStatus.getPlayState() == AnimationStatus.PLAY_STATE.PLAYING) {
                AnimationStatus animationStatus = this.playStatus;
                animationStatus.setTotalFrameTime(animationStatus.getTotalFrameTime() + ((frameTimeNanos / 1000) - this.playStatus.getLastFrameTime()));
                if (this.playStatus.getIsFirstFrame() && !this.playStatus.getIsFirstFrameSuccess()) {
                    if (!this.attached.get() || (gYFZPlanNativeAPI = this.nativeAPI) == null || !gYFZPlanNativeAPI.tick(this.playStatus.getTotalFrameTime(), true, true)) {
                        z16 = false;
                    }
                    this.playStatus.setFirstFrameSuccess(z16);
                    if (this.playStatus.getIsFirstFrameSuccess()) {
                        if (this.firstFrameFinishCallback != null) {
                            Handler handler = this.uiHandler;
                            if (handler == null) {
                                Intrinsics.throwUninitializedPropertyAccessException("uiHandler");
                            }
                            handler.post(new Runnable() { // from class: com.tencent.filament.zplan.view.controller.GYFZPlanController$onDrawFrame$$inlined$synchronized$lambda$1
                                @Override // java.lang.Runnable
                                public final void run() {
                                    uk0.a aVar;
                                    aVar = GYFZPlanController.this.firstFrameFinishCallback;
                                    if (aVar != null) {
                                        aVar.a(0);
                                    }
                                    FLog.INSTANCE.i("GYFZPlanController", "first frame finish called");
                                }
                            });
                        }
                        this.playStatus.setFirstFrame(false);
                    }
                } else {
                    GYFZPlanNativeAPI gYFZPlanNativeAPI2 = this.nativeAPI;
                    if (gYFZPlanNativeAPI2 != null) {
                        gYFZPlanNativeAPI2.tick(this.playStatus.getTotalFrameTime(), false, false);
                    }
                }
            } else if (this.playStatus.getPlayState() == AnimationStatus.PLAY_STATE.PAUSED) {
                AnimationStatus animationStatus2 = this.playStatus;
                animationStatus2.setOffsetDuration(animationStatus2.getOffsetDuration() + ((frameTimeNanos / 1000) - this.playStatus.getLastFrameTime()));
            }
            this.playStatus.setLastFrameTime(frameTimeNanos / 1000);
            Unit unit = Unit.INSTANCE;
        }
        if (this.fpsListener != null && this.drawFrameCounts % 30 == 0) {
            GYFZPlanNativeAPI gYFZPlanNativeAPI3 = this.nativeAPI;
            if (gYFZPlanNativeAPI3 != null) {
                f16 = Float.valueOf(gYFZPlanNativeAPI3.getFPS(false));
            } else {
                f16 = null;
            }
            Handler handler2 = this.uiHandler;
            if (handler2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("uiHandler");
            }
            handler2.post(new Runnable() { // from class: com.tencent.filament.zplan.view.controller.GYFZPlanController$onDrawFrame$2
                @Override // java.lang.Runnable
                public final void run() {
                    GYFZPlanController.b fpsListener = GYFZPlanController.this.getFpsListener();
                    if (fpsListener != null) {
                        fpsListener.a(f16);
                    }
                }
            });
        }
    }

    private final void b0(final String from, final boolean openLog, final Function0<Unit> task) {
        u(new Runnable() { // from class: com.tencent.filament.zplan.view.controller.GYFZPlanController$postToViewerThread$2
            @Override // java.lang.Runnable
            public final void run() {
                GYFZPlanController.this.A(from, openLog, task);
            }
        });
        B();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void c0(final String taskName, final long delay, final Function0<Unit> task) {
        FLog.INSTANCE.i("GYFZPlanController", "addTaskDelayed. name: " + taskName + ", delay: " + delay + ", " + this);
        u(new Runnable() { // from class: com.tencent.filament.zplan.view.controller.GYFZPlanController$postToViewerThreadDelayed$1
            @Override // java.lang.Runnable
            public final void run() {
                Handler O;
                O = GYFZPlanController.this.O();
                O.postDelayed(new Runnable() { // from class: com.tencent.filament.zplan.view.controller.GYFZPlanController$postToViewerThreadDelayed$1.1
                    @Override // java.lang.Runnable
                    public final void run() {
                        FLog fLog = FLog.INSTANCE;
                        fLog.i("GYFZPlanController", "before doTask: " + taskName + ", " + GYFZPlanController.this);
                        task.invoke();
                        fLog.i("GYFZPlanController", "after doTask: " + taskName + ", " + GYFZPlanController.this);
                    }
                }, delay);
            }
        });
        B();
    }

    public static /* synthetic */ void i0(GYFZPlanController gYFZPlanController, String str, String str2, int i3, String str3, int i16, Object obj) {
        if (obj == null) {
            if ((i16 & 8) != 0) {
                str3 = "";
            }
            gYFZPlanController.h0(str, str2, i3, str3);
            return;
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: setAvatarWithAvatarInfoAndFaceJson");
    }

    private final void u(Runnable task) {
        synchronized (this.viewerWaitList) {
            this.viewerWaitList.add(task);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final int v0(int originCode) {
        if (originCode == 0) {
            return 0;
        }
        return (-100) - originCode;
    }

    private final boolean w(final int requestId) {
        if (this.templateStatus != 0) {
            Handler handler = this.uiHandler;
            if (handler == null) {
                Intrinsics.throwUninitializedPropertyAccessException("uiHandler");
            }
            handler.post(new Runnable() { // from class: com.tencent.filament.zplan.view.controller.GYFZPlanController$checkTemplateStatusForAvatarLoad$1
                @Override // java.lang.Runnable
                public final void run() {
                    int i3;
                    GYFZPlanController.c loadAvatarListener = GYFZPlanController.this.getLoadAvatarListener();
                    if (loadAvatarListener != null) {
                        i3 = GYFZPlanController.this.templateStatus;
                        loadAvatarListener.a(i3, requestId);
                    }
                }
            });
            return false;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final int w0(int originCode) {
        if (originCode != 0 && originCode != 1) {
            return (-300) - originCode;
        }
        return 0;
    }

    public static /* synthetic */ void z(GYFZPlanController gYFZPlanController, d dVar, int i3, Object obj) {
        if (obj == null) {
            if ((i3 & 1) != 0) {
                dVar = null;
            }
            gYFZPlanController.y(dVar);
            return;
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: dealloc");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void A(@NotNull final String funName, final boolean openLog, @NotNull final Function0<Unit> task) {
        Intrinsics.checkNotNullParameter(funName, "funName");
        Intrinsics.checkNotNullParameter(task, "task");
        O().post(new Runnable() { // from class: com.tencent.filament.zplan.view.controller.GYFZPlanController$doTaskOnViewerThread$1
            @Override // java.lang.Runnable
            public final void run() {
                al0.a aVar = new al0.a(0L, 0L, false, 0, null, 31, null);
                if (openLog) {
                    FLog.INSTANCE.i("GYFZPlanController", "before doTask: " + funName + ", " + GYFZPlanController.this);
                }
                Function0 function0 = task;
                a.Companion companion = al0.a.INSTANCE;
                aVar.l(companion.b());
                function0.invoke();
                aVar.i(companion.b());
                if (openLog) {
                    FLog.INSTANCE.i("GYFZPlanController", "after doTask: " + funName + TokenParser.SP + aVar + ", " + GYFZPlanController.this);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: C, reason: from getter */
    public final boolean getAllowCameraManipulator() {
        return this.allowCameraManipulator;
    }

    /* renamed from: D, reason: from getter */
    public final int getFps() {
        return this.fps;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Nullable
    /* renamed from: E, reason: from getter */
    public final b getFpsListener() {
        return this.fpsListener;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Nullable
    /* renamed from: F, reason: from getter */
    public final c getLoadAvatarListener() {
        return this.loadAvatarListener;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @NotNull
    /* renamed from: G, reason: from getter */
    public final String getMBootConfigJson() {
        return this.mBootConfigJson;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Nullable
    /* renamed from: H, reason: from getter */
    public final GYFZPlanNativeAPI getNativeAPI() {
        return this.nativeAPI;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @NotNull
    /* renamed from: J, reason: from getter */
    public final RenderSize getRenderSize() {
        return this.renderSize;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Nullable
    /* renamed from: K, reason: from getter */
    public final Surface getSurface() {
        return this.surface;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @NotNull
    public final Handler L() {
        Handler handler = this.uiHandler;
        if (handler == null) {
            Intrinsics.throwUninitializedPropertyAccessException("uiHandler");
        }
        return handler;
    }

    public final void Q(@NotNull final int[] primitiveIndexArr, @NotNull final String slotID) {
        Intrinsics.checkNotNullParameter(primitiveIndexArr, "primitiveIndexArr");
        Intrinsics.checkNotNullParameter(slotID, "slotID");
        a0("hidePrimitivesInSlot", new Function0<Unit>() { // from class: com.tencent.filament.zplan.view.controller.GYFZPlanController$hidePrimitivesInSlot$1
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
                GYFZPlanNativeAPI nativeAPI = GYFZPlanController.this.getNativeAPI();
                if (nativeAPI != null) {
                    nativeAPI.hidePrimitivesInSlot(primitiveIndexArr, slotID);
                }
            }
        });
    }

    public void R() {
        A("init", true, new Function0<Unit>() { // from class: com.tencent.filament.zplan.view.controller.GYFZPlanController$init$1
            /* JADX INFO: Access modifiers changed from: package-private */
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
                GYFZPlanController gYFZPlanController = GYFZPlanController.this;
                Surface surface = GYFZPlanController.this.getSurface();
                RenderSize renderSize = GYFZPlanController.this.getRenderSize();
                Thread currentThread = Thread.currentThread();
                Intrinsics.checkNotNullExpressionValue(currentThread, "Thread.currentThread()");
                gYFZPlanController.p0(new GYFZPlanNativeAPI(surface, renderSize, currentThread.getId(), GYFZPlanController.this.getIsOffScreen(), GYFZPlanController.this.getIsLogGpuError(), null, GYFZPlanController.this.getAllowCameraManipulator(), GYFZPlanController.this.getMBootConfigJson(), 32, null));
                GYFZPlanNativeAPI nativeAPI = GYFZPlanController.this.getNativeAPI();
                if (nativeAPI != null) {
                    RenderSize renderSize2 = GYFZPlanController.this.getRenderSize();
                    Intrinsics.checkNotNull(renderSize2);
                    int width = renderSize2.getWidth();
                    RenderSize renderSize3 = GYFZPlanController.this.getRenderSize();
                    Intrinsics.checkNotNull(renderSize3);
                    nativeAPI.setViewPort(width, renderSize3.getHeight());
                }
                GYFZPlanController.this.r0(new Handler(Looper.getMainLooper()));
            }
        });
    }

    /* renamed from: S, reason: from getter */
    public final boolean getIsAvatarInfoCacheByUin() {
        return this.isAvatarInfoCacheByUin;
    }

    /* renamed from: T, reason: from getter */
    public final boolean getIsLogGpuError() {
        return this.isLogGpuError;
    }

    /* renamed from: U, reason: from getter */
    public final boolean getIsOffScreen() {
        return this.isOffScreen;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: V, reason: from getter */
    public final boolean getIsReentrant() {
        return this.isReentrant;
    }

    public final void X(@NotNull final String slotID) {
        Intrinsics.checkNotNullParameter(slotID, "slotID");
        a0("onlyShowSlot", new Function0<Unit>() { // from class: com.tencent.filament.zplan.view.controller.GYFZPlanController$onlyShowSlot$1
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
                GYFZPlanNativeAPI nativeAPI = GYFZPlanController.this.getNativeAPI();
                if (nativeAPI != null) {
                    nativeAPI.onlyShowSlot(slotID);
                }
            }
        });
    }

    public final void Y() {
        synchronized (this.playStatus) {
            this.playStatus.setPlayState(AnimationStatus.PLAY_STATE.PAUSED);
            Unit unit = Unit.INSTANCE;
        }
    }

    public final void Z() {
        if (this.nativeAPI == null) {
            return;
        }
        N().o();
        synchronized (this.playStatus) {
            this.playStatus.playFromHead();
            Unit unit = Unit.INSTANCE;
        }
    }

    public final void a0(@NotNull final String from, @NotNull final Function0<Unit> task) {
        Intrinsics.checkNotNullParameter(from, "from");
        Intrinsics.checkNotNullParameter(task, "task");
        u(new Runnable() { // from class: com.tencent.filament.zplan.view.controller.GYFZPlanController$postToViewerThread$1
            @Override // java.lang.Runnable
            public final void run() {
                GYFZPlanController.this.A(from, true, task);
            }
        });
        B();
    }

    public final void d0(@NotNull final Surface surface, final int width, final int height) {
        Intrinsics.checkNotNullParameter(surface, "surface");
        this.surface = surface;
        a0("reAttachSurface", new Function0<Unit>() { // from class: com.tencent.filament.zplan.view.controller.GYFZPlanController$reAttachSurface$1
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
                AtomicBoolean atomicBoolean;
                GYFZPlanNativeAPI nativeAPI = GYFZPlanController.this.getNativeAPI();
                if (nativeAPI != null) {
                    nativeAPI.attach(surface);
                }
                GYFZPlanNativeAPI nativeAPI2 = GYFZPlanController.this.getNativeAPI();
                if (nativeAPI2 != null) {
                    nativeAPI2.setViewPort(width, height);
                }
                atomicBoolean = GYFZPlanController.this.attached;
                atomicBoolean.set(true);
            }
        });
    }

    public final void e0(@NotNull final String slot, @NotNull final String materialName, @NotNull final String parameterName, @NotNull final Bitmap texture) {
        Intrinsics.checkNotNullParameter(slot, "slot");
        Intrinsics.checkNotNullParameter(materialName, "materialName");
        Intrinsics.checkNotNullParameter(parameterName, "parameterName");
        Intrinsics.checkNotNullParameter(texture, "texture");
        a0("replaceMaterialTexture", new Function0<Unit>() { // from class: com.tencent.filament.zplan.view.controller.GYFZPlanController$replaceMaterialTexture$1
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
                int width = texture.getWidth();
                int height = texture.getHeight();
                ByteBuffer allocate = ByteBuffer.allocate(texture.getRowBytes() * texture.getHeight());
                Intrinsics.checkNotNullExpressionValue(allocate, "ByteBuffer.allocate(size)");
                texture.copyPixelsToBuffer(allocate);
                byte[] byteArray = allocate.array();
                GYFZPlanNativeAPI nativeAPI = GYFZPlanController.this.getNativeAPI();
                if (nativeAPI != null) {
                    String str = slot;
                    String str2 = materialName;
                    String str3 = parameterName;
                    Intrinsics.checkNotNullExpressionValue(byteArray, "byteArray");
                    nativeAPI.replaceMaterialTexture(str, str2, str3, byteArray, width, height);
                }
            }
        });
    }

    public final void f0() {
        this.lastTouchEvent = null;
        this.mLastPinchPoint = null;
        this.mLastScale = 0.0f;
        this.mScaleDeltaSum = 0.0f;
        this.mRotateAvatarSum = 0.0f;
    }

    public final void g0(@NotNull String animationPath, @NotNull IAnimationSetListener listener) {
        Intrinsics.checkNotNullParameter(animationPath, "animationPath");
        Intrinsics.checkNotNullParameter(listener, "listener");
        a0("setAnimationWithPath", new GYFZPlanController$setAnimationWithPath$1(this, animationPath, listener));
    }

    public final void h0(@NotNull String avatarInfo, @NotNull String faceJson, int requestId, @NotNull String uin) {
        Intrinsics.checkNotNullParameter(avatarInfo, "avatarInfo");
        Intrinsics.checkNotNullParameter(faceJson, "faceJson");
        Intrinsics.checkNotNullParameter(uin, "uin");
        if (!w(requestId)) {
            return;
        }
        if (TextUtils.isEmpty(avatarInfo) && !TextUtils.isEmpty(uin)) {
            k0(uin, faceJson, requestId, -1);
        } else {
            this.fJCurrentRequestIdByAInfo = requestId;
            a0("setAvatarWithAvatarInfoAndFaceJson", new GYFZPlanController$setAvatarWithAvatarInfoAndFaceJson$1(this, avatarInfo, faceJson, requestId, uin));
        }
    }

    public final void j0(@NotNull String uin, final int requestId) {
        Intrinsics.checkNotNullParameter(uin, "uin");
        if (!w(requestId)) {
            return;
        }
        this.uinCurrentRequestId = requestId;
        if (getIsAvatarInfoCacheByUin() && this.avatarInfoCacheMap.containsKey(uin)) {
            final Ref.IntRef intRef = new Ref.IntRef();
            Integer num = this.avatarInfoCacheMap.get(uin);
            Intrinsics.checkNotNull(num);
            Intrinsics.checkNotNullExpressionValue(num, "avatarInfoCacheMap[uin]!!");
            intRef.element = num.intValue();
            a0("applyAvatarInfo", new Function0<Unit>() { // from class: com.tencent.filament.zplan.view.controller.GYFZPlanController$setAvatarWithUin$1
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
                    GYFZPlanNativeAPI nativeAPI = GYFZPlanController.this.getNativeAPI();
                    if (nativeAPI != null) {
                        nativeAPI.applyAvatarInfo(intRef.element);
                    }
                    GYFZPlanNativeAPI nativeAPI2 = GYFZPlanController.this.getNativeAPI();
                    if (nativeAPI2 != null) {
                        nativeAPI2.renderWarmup(false);
                    }
                    GYFZPlanController.this.L().post(new Runnable() { // from class: com.tencent.filament.zplan.view.controller.GYFZPlanController$setAvatarWithUin$1.1
                        @Override // java.lang.Runnable
                        public final void run() {
                            GYFZPlanController.c loadAvatarListener = GYFZPlanController.this.getLoadAvatarListener();
                            if (loadAvatarListener != null) {
                                loadAvatarListener.a(0, requestId);
                            }
                        }
                    });
                }
            });
            return;
        }
        a0("setAvatarWithUin", new GYFZPlanController$setAvatarWithUin$2(this, uin, requestId));
    }

    public final void k0(@NotNull String uin, @NotNull String faceJson, int requestId, int resultCode) {
        Intrinsics.checkNotNullParameter(uin, "uin");
        Intrinsics.checkNotNullParameter(faceJson, "faceJson");
        if (!w(requestId)) {
            return;
        }
        this.faceJsonCurrentRequestId = requestId;
        a0("setAvatarWithAvatarInfo", new GYFZPlanController$setAvatarWithUinAndFaceJson$1(this, uin, faceJson, requestId, resultCode));
    }

    public final void l0(@NotNull final String baseTemplateJson, @NotNull final String iblPath) {
        Intrinsics.checkNotNullParameter(baseTemplateJson, "baseTemplateJson");
        Intrinsics.checkNotNullParameter(iblPath, "iblPath");
        a0("setBaseTemplateInfo", new Function0<Unit>() { // from class: com.tencent.filament.zplan.view.controller.GYFZPlanController$setBaseTemplateInfo$1
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
                int w06;
                int i3;
                GYFZPlanController gYFZPlanController = GYFZPlanController.this;
                if (gYFZPlanController.getNativeAPI() == null) {
                    w06 = -170;
                } else {
                    GYFZPlanController gYFZPlanController2 = GYFZPlanController.this;
                    GYFZPlanNativeAPI nativeAPI = gYFZPlanController2.getNativeAPI();
                    Intrinsics.checkNotNull(nativeAPI);
                    w06 = gYFZPlanController2.w0(nativeAPI.setBaseTemplateInfo(baseTemplateJson, iblPath));
                }
                gYFZPlanController.templateStatus = w06;
                FLog fLog = FLog.INSTANCE;
                StringBuilder sb5 = new StringBuilder();
                sb5.append("setBaseTemplateInfo result ");
                i3 = GYFZPlanController.this.templateStatus;
                sb5.append(i3);
                fLog.d("GYFZPlanController", sb5.toString());
            }
        });
    }

    public final void m0(@NotNull final String path) {
        Intrinsics.checkNotNullParameter(path, "path");
        a0("setBaseTemplatePath", new Function0<Unit>() { // from class: com.tencent.filament.zplan.view.controller.GYFZPlanController$setBaseTemplatePath$1
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
                int w06;
                int i3;
                GYFZPlanController gYFZPlanController = GYFZPlanController.this;
                if (gYFZPlanController.getNativeAPI() == null) {
                    w06 = -170;
                } else {
                    GYFZPlanController gYFZPlanController2 = GYFZPlanController.this;
                    GYFZPlanNativeAPI nativeAPI = gYFZPlanController2.getNativeAPI();
                    Intrinsics.checkNotNull(nativeAPI);
                    w06 = gYFZPlanController2.w0(nativeAPI.setBaseTemplatePath(path));
                }
                gYFZPlanController.templateStatus = w06;
                FLog fLog = FLog.INSTANCE;
                StringBuilder sb5 = new StringBuilder();
                sb5.append("setBaseTemplatePath result ");
                i3 = GYFZPlanController.this.templateStatus;
                sb5.append(i3);
                fLog.d("GYFZPlanController", sb5.toString());
            }
        });
    }

    public final void n0(@NotNull c listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        this.loadAvatarListener = listener;
    }

    public final void o0(@NotNull uk0.a listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        this.firstFrameFinishCallback = listener;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void p0(@Nullable GYFZPlanNativeAPI gYFZPlanNativeAPI) {
        this.nativeAPI = gYFZPlanNativeAPI;
    }

    @Override // com.tencent.filament.zplan.view.controller.FilamentTouchController.b
    public void q(@NotNull TouchEvent touchEvent) {
        final float f16;
        Intrinsics.checkNotNullParameter(touchEvent, "touchEvent");
        try {
            if (touchEvent.getTouchCount() == 2) {
                float f17 = 0.0f;
                if (a.f106344a[touchEvent.getState().ordinal()] != 1) {
                    float f18 = this.mLastScale;
                    Float scale = touchEvent.getScale();
                    if (this.mLastPinchPoint != null && f18 != 0.0f && scale != null) {
                        final Ref.FloatRef floatRef = new Ref.FloatRef();
                        float floatValue = scale.floatValue() - f18;
                        floatRef.element = floatValue;
                        float f19 = this.mScaleDeltaSum + floatValue;
                        this.mScaleDeltaSum = f19;
                        if (f19 < 0.0f) {
                            this.mScaleDeltaSum = 0.0f;
                            scale = Float.valueOf(f18);
                            floatRef.element = 0.0f;
                        } else {
                            float f26 = this.scaleMax;
                            if (f19 > f26) {
                                this.mScaleDeltaSum = f26;
                                scale = Float.valueOf(f18);
                                floatRef.element = 0.0f;
                            }
                        }
                        this.mLastScale = scale.floatValue();
                        final float f27 = touchEvent.getLocation().x;
                        final float height = this.renderSize.getHeight() - touchEvent.getLocation().y;
                        b0("scrollCameraManipulator", false, new Function0<Unit>() { // from class: com.tencent.filament.zplan.view.controller.GYFZPlanController$doReceiveTouchEvent$1
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
                                GYFZPlanNativeAPI nativeAPI = GYFZPlanController.this.getNativeAPI();
                                if (nativeAPI != null) {
                                    nativeAPI.scrollCameraManipulator(f27, height, (-1) * floatRef.element * 100);
                                }
                            }
                        });
                    }
                    return;
                }
                this.mLastPinchPoint = touchEvent.getLocation();
                Float scale2 = touchEvent.getScale();
                if (scale2 != null) {
                    f17 = scale2.floatValue();
                }
                this.mLastScale = f17;
            } else {
                TouchEvent touchEvent2 = this.lastTouchEvent;
                if (touchEvent2 != null) {
                    Intrinsics.checkNotNull(touchEvent2);
                    if (touchEvent2.getLocation().x - touchEvent.getLocation().x > 0) {
                        f16 = -0.1f;
                        this.mRotateAvatarSum += f16;
                        b0("rotateAvatar", false, new Function0<Unit>() { // from class: com.tencent.filament.zplan.view.controller.GYFZPlanController$doReceiveTouchEvent$2
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
                                GYFZPlanNativeAPI nativeAPI = GYFZPlanController.this.getNativeAPI();
                                if (nativeAPI != null) {
                                    nativeAPI.rotateAvatar(0.0f, 1.0f, 0.0f, f16);
                                }
                            }
                        });
                    }
                }
                f16 = 0.1f;
                this.mRotateAvatarSum += f16;
                b0("rotateAvatar", false, new Function0<Unit>() { // from class: com.tencent.filament.zplan.view.controller.GYFZPlanController$doReceiveTouchEvent$2
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
                        GYFZPlanNativeAPI nativeAPI = GYFZPlanController.this.getNativeAPI();
                        if (nativeAPI != null) {
                            nativeAPI.rotateAvatar(0.0f, 1.0f, 0.0f, f16);
                        }
                    }
                });
            }
            this.lastTouchEvent = touchEvent;
        } catch (Exception e16) {
            FLog.INSTANCE.e("GYFZPlanController", "process this event error", e16);
        }
    }

    public final void q0(@NotNull final RenderSize renderSize, boolean update) {
        Intrinsics.checkNotNullParameter(renderSize, "renderSize");
        this.renderSize = renderSize;
        if (update) {
            a0("setRenderSize", new Function0<Unit>() { // from class: com.tencent.filament.zplan.view.controller.GYFZPlanController$setRenderSize$1
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
                    GYFZPlanNativeAPI nativeAPI = GYFZPlanController.this.getNativeAPI();
                    if (nativeAPI != null) {
                        nativeAPI.setViewPort(renderSize.getWidth(), renderSize.getHeight());
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void r0(@NotNull Handler handler) {
        Intrinsics.checkNotNullParameter(handler, "<set-?>");
        this.uiHandler = handler;
    }

    public final void s0(@NotNull final String configJson, @NotNull final String dirPath) {
        Intrinsics.checkNotNullParameter(configJson, "configJson");
        Intrinsics.checkNotNullParameter(dirPath, "dirPath");
        a0("setupConfigJson", new Function0<Unit>() { // from class: com.tencent.filament.zplan.view.controller.GYFZPlanController$setupConfigJson$1
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
                GYFZPlanNativeAPI nativeAPI = GYFZPlanController.this.getNativeAPI();
                if (nativeAPI != null) {
                    nativeAPI.setupConfigJson(configJson, dirPath);
                }
            }
        });
    }

    public final void t0() {
        synchronized (this.playStatus) {
            this.playStatus.stop();
            Unit unit = Unit.INSTANCE;
        }
        N().p();
    }

    public final void u0(@Nullable GYScreenShotCallback callback) {
        a0("takeScreenShot", new GYFZPlanController$takeScreenShot$1(this, callback));
    }

    public final void v(@NotNull final String slotID) {
        Intrinsics.checkNotNullParameter(slotID, "slotID");
        a0("onlyShowSlot", new Function0<Unit>() { // from class: com.tencent.filament.zplan.view.controller.GYFZPlanController$calculateScrollUpperLimit$1
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
                float f16;
                float f17;
                Float nGetScrollDeltaSumUpperLimit;
                GYFZPlanController gYFZPlanController = GYFZPlanController.this;
                GYFZPlanNativeAPI nativeAPI = gYFZPlanController.getNativeAPI();
                gYFZPlanController.scaleMax = (nativeAPI == null || (nGetScrollDeltaSumUpperLimit = nativeAPI.nGetScrollDeltaSumUpperLimit(slotID)) == null) ? 2.0f : nGetScrollDeltaSumUpperLimit.floatValue();
                f16 = GYFZPlanController.this.scaleMax;
                if (f16 > 1.5f) {
                    GYFZPlanController gYFZPlanController2 = GYFZPlanController.this;
                    f17 = gYFZPlanController2.scaleMax;
                    gYFZPlanController2.scaleMax = f17 - 1.5f;
                }
            }
        });
    }

    @Nullable
    public final View.OnTouchListener x(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        if (this.filamentTouchController == null) {
            this.filamentTouchController = new FilamentTouchController(context, this);
        }
        return I();
    }

    public final void y(@Nullable d viewerDestroyCallback) {
        N().p();
        this.loadAvatarListener = null;
        this.fpsListener = null;
        this.firstFrameFinishCallback = null;
        this.filamentTouchController = null;
        this.templateStatus = 0;
        O().removeCallbacksAndMessages(null);
        a0("dealloc", new GYFZPlanController$dealloc$1(this, viewerDestroyCallback));
    }

    public GYFZPlanController(@NotNull RenderSize size, boolean z16, boolean z17) {
        Lazy lazy;
        Lazy lazy2;
        Lazy lazy3;
        Lazy lazy4;
        Lazy lazy5;
        Intrinsics.checkNotNullParameter(size, "size");
        this.fps = 30;
        this.isLogGpuError = true;
        this.isEnableDelayed = FilamentFeatureUtil.f106409g.i();
        this.attached = new AtomicBoolean(false);
        this.mBootConfigJson = "";
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<View.OnTouchListener>() { // from class: com.tencent.filament.zplan.view.controller.GYFZPlanController$onTouchListener$2

            /* JADX INFO: Access modifiers changed from: package-private */
            @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u00032\u000e\u0010\u0005\u001a\n \u0004*\u0004\u0018\u00010\u00060\u0006H\n\u00a2\u0006\u0002\b\u0007"}, d2 = {"<anonymous>", "", "<anonymous parameter 0>", "Landroid/view/View;", "kotlin.jvm.PlatformType", "event", "Landroid/view/MotionEvent;", "onTouch"}, k = 3, mv = {1, 4, 2})
            /* loaded from: classes6.dex */
            public static final class a implements View.OnTouchListener {
                a() {
                }

                @Override // android.view.View.OnTouchListener
                public final boolean onTouch(View view, MotionEvent motionEvent) {
                    FilamentTouchController filamentTouchController;
                    FilamentTouchController filamentTouchController2;
                    ScaleGestureDetector o16;
                    FilamentTouchController filamentTouchController3;
                    GestureDetector m3;
                    if (motionEvent != null) {
                        int pointerCount = motionEvent.getPointerCount();
                        filamentTouchController = GYFZPlanController.this.filamentTouchController;
                        if (filamentTouchController != null) {
                            filamentTouchController.z(motionEvent);
                        }
                        if (pointerCount == 1) {
                            filamentTouchController3 = GYFZPlanController.this.filamentTouchController;
                            if (filamentTouchController3 != null && (m3 = filamentTouchController3.m()) != null) {
                                m3.onTouchEvent(motionEvent);
                            }
                        } else {
                            filamentTouchController2 = GYFZPlanController.this.filamentTouchController;
                            if (filamentTouchController2 != null && (o16 = filamentTouchController2.o()) != null) {
                                o16.onTouchEvent(motionEvent);
                            }
                        }
                    }
                    return true;
                }
            }

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final View.OnTouchListener invoke() {
                return new a();
            }
        });
        this.onTouchListener = lazy;
        this.viewerWaitList = new ArrayList();
        this.renderSize = new RenderSize(0, 0);
        this.playStatus = new AnimationStatus();
        this.uinCurrentRequestId = -1;
        this.faceJsonCurrentRequestId = -1;
        this.fJCurrentRequestIdByAInfo = -1;
        this.isReentrant = true;
        this.scaleMax = 1.5f;
        this.isAvatarInfoCacheByUin = true;
        this.avatarInfoCacheMap = new HashMap<>();
        lazy2 = LazyKt__LazyJVMKt.lazy(new Function0<GYFZPlanController$vSyncListener$2.a>() { // from class: com.tencent.filament.zplan.view.controller.GYFZPlanController$vSyncListener$2

            @Metadata(d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0016\u00a8\u0006\u0007"}, d2 = {"com/tencent/filament/zplan/view/controller/GYFZPlanController$vSyncListener$2$a", "Lcom/tencent/filament/zplan/util/vsync/b;", "", "totalTime", "frameTime", "", "d", "zplan-android_release"}, k = 1, mv = {1, 4, 2})
            /* loaded from: classes6.dex */
            public static final class a implements b {
                a() {
                }

                @Override // com.tencent.filament.zplan.util.vsync.b
                public void d(long totalTime, long frameTime) {
                    GYFZPlanController.this.W(totalTime, frameTime);
                }
            }

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final a invoke() {
                return new a();
            }
        });
        this.vSyncListener = lazy2;
        lazy3 = LazyKt__LazyJVMKt.lazy(new Function0<VSyncScheduler>() { // from class: com.tencent.filament.zplan.view.controller.GYFZPlanController$vSyncScheduler$2

            @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/filament/zplan/view/controller/GYFZPlanController$vSyncScheduler$2$a", "Ljava/util/concurrent/Executor;", "Ljava/lang/Runnable;", "command", "", "execute", "zplan-android_release"}, k = 1, mv = {1, 4, 2})
            /* loaded from: classes6.dex */
            public static final class a implements Executor {
                a() {
                }

                @Override // java.util.concurrent.Executor
                public void execute(@Nullable Runnable command) {
                    Handler O;
                    if (command != null) {
                        O = GYFZPlanController.this.O();
                        O.post(command);
                    }
                }
            }

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final VSyncScheduler invoke() {
                GYFZPlanController$vSyncListener$2.a M;
                M = GYFZPlanController.this.M();
                return new VSyncScheduler(M, GYFZPlanController.this.getFps(), new a());
            }
        });
        this.vSyncScheduler = lazy3;
        lazy4 = LazyKt__LazyJVMKt.lazy(GYFZPlanController$viewerHandlerThread$2.INSTANCE);
        this.viewerHandlerThread = lazy4;
        lazy5 = LazyKt__LazyJVMKt.lazy(new Function0<Handler>() { // from class: com.tencent.filament.zplan.view.controller.GYFZPlanController$viewerHandler$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final Handler invoke() {
                HandlerThread P;
                P = GYFZPlanController.this.P();
                return new Handler(P.getLooper());
            }
        });
        this.viewerHandler = lazy5;
        this.isOffScreen = z16;
        this.allowCameraManipulator = z17;
        this.renderSize = size;
        R();
    }

    public /* synthetic */ GYFZPlanController(RenderSize renderSize, String str, boolean z16, boolean z17, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(renderSize, (i3 & 2) != 0 ? "" : str, (i3 & 4) != 0 ? false : z16, (i3 & 8) != 0 ? false : z17);
    }

    public GYFZPlanController(@NotNull RenderSize size, @NotNull String bootConfigJson, boolean z16, boolean z17) {
        Lazy lazy;
        Lazy lazy2;
        Lazy lazy3;
        Lazy lazy4;
        Lazy lazy5;
        Intrinsics.checkNotNullParameter(size, "size");
        Intrinsics.checkNotNullParameter(bootConfigJson, "bootConfigJson");
        this.fps = 30;
        this.isLogGpuError = true;
        this.isEnableDelayed = FilamentFeatureUtil.f106409g.i();
        this.attached = new AtomicBoolean(false);
        this.mBootConfigJson = "";
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<View.OnTouchListener>() { // from class: com.tencent.filament.zplan.view.controller.GYFZPlanController$onTouchListener$2

            /* JADX INFO: Access modifiers changed from: package-private */
            @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u00032\u000e\u0010\u0005\u001a\n \u0004*\u0004\u0018\u00010\u00060\u0006H\n\u00a2\u0006\u0002\b\u0007"}, d2 = {"<anonymous>", "", "<anonymous parameter 0>", "Landroid/view/View;", "kotlin.jvm.PlatformType", "event", "Landroid/view/MotionEvent;", "onTouch"}, k = 3, mv = {1, 4, 2})
            /* loaded from: classes6.dex */
            public static final class a implements View.OnTouchListener {
                a() {
                }

                @Override // android.view.View.OnTouchListener
                public final boolean onTouch(View view, MotionEvent motionEvent) {
                    FilamentTouchController filamentTouchController;
                    FilamentTouchController filamentTouchController2;
                    ScaleGestureDetector o16;
                    FilamentTouchController filamentTouchController3;
                    GestureDetector m3;
                    if (motionEvent != null) {
                        int pointerCount = motionEvent.getPointerCount();
                        filamentTouchController = GYFZPlanController.this.filamentTouchController;
                        if (filamentTouchController != null) {
                            filamentTouchController.z(motionEvent);
                        }
                        if (pointerCount == 1) {
                            filamentTouchController3 = GYFZPlanController.this.filamentTouchController;
                            if (filamentTouchController3 != null && (m3 = filamentTouchController3.m()) != null) {
                                m3.onTouchEvent(motionEvent);
                            }
                        } else {
                            filamentTouchController2 = GYFZPlanController.this.filamentTouchController;
                            if (filamentTouchController2 != null && (o16 = filamentTouchController2.o()) != null) {
                                o16.onTouchEvent(motionEvent);
                            }
                        }
                    }
                    return true;
                }
            }

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final View.OnTouchListener invoke() {
                return new a();
            }
        });
        this.onTouchListener = lazy;
        this.viewerWaitList = new ArrayList();
        this.renderSize = new RenderSize(0, 0);
        this.playStatus = new AnimationStatus();
        this.uinCurrentRequestId = -1;
        this.faceJsonCurrentRequestId = -1;
        this.fJCurrentRequestIdByAInfo = -1;
        this.isReentrant = true;
        this.scaleMax = 1.5f;
        this.isAvatarInfoCacheByUin = true;
        this.avatarInfoCacheMap = new HashMap<>();
        lazy2 = LazyKt__LazyJVMKt.lazy(new Function0<GYFZPlanController$vSyncListener$2.a>() { // from class: com.tencent.filament.zplan.view.controller.GYFZPlanController$vSyncListener$2

            @Metadata(d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0016\u00a8\u0006\u0007"}, d2 = {"com/tencent/filament/zplan/view/controller/GYFZPlanController$vSyncListener$2$a", "Lcom/tencent/filament/zplan/util/vsync/b;", "", "totalTime", "frameTime", "", "d", "zplan-android_release"}, k = 1, mv = {1, 4, 2})
            /* loaded from: classes6.dex */
            public static final class a implements b {
                a() {
                }

                @Override // com.tencent.filament.zplan.util.vsync.b
                public void d(long totalTime, long frameTime) {
                    GYFZPlanController.this.W(totalTime, frameTime);
                }
            }

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final a invoke() {
                return new a();
            }
        });
        this.vSyncListener = lazy2;
        lazy3 = LazyKt__LazyJVMKt.lazy(new Function0<VSyncScheduler>() { // from class: com.tencent.filament.zplan.view.controller.GYFZPlanController$vSyncScheduler$2

            @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/filament/zplan/view/controller/GYFZPlanController$vSyncScheduler$2$a", "Ljava/util/concurrent/Executor;", "Ljava/lang/Runnable;", "command", "", "execute", "zplan-android_release"}, k = 1, mv = {1, 4, 2})
            /* loaded from: classes6.dex */
            public static final class a implements Executor {
                a() {
                }

                @Override // java.util.concurrent.Executor
                public void execute(@Nullable Runnable command) {
                    Handler O;
                    if (command != null) {
                        O = GYFZPlanController.this.O();
                        O.post(command);
                    }
                }
            }

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final VSyncScheduler invoke() {
                GYFZPlanController$vSyncListener$2.a M;
                M = GYFZPlanController.this.M();
                return new VSyncScheduler(M, GYFZPlanController.this.getFps(), new a());
            }
        });
        this.vSyncScheduler = lazy3;
        lazy4 = LazyKt__LazyJVMKt.lazy(GYFZPlanController$viewerHandlerThread$2.INSTANCE);
        this.viewerHandlerThread = lazy4;
        lazy5 = LazyKt__LazyJVMKt.lazy(new Function0<Handler>() { // from class: com.tencent.filament.zplan.view.controller.GYFZPlanController$viewerHandler$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final Handler invoke() {
                HandlerThread P;
                P = GYFZPlanController.this.P();
                return new Handler(P.getLooper());
            }
        });
        this.viewerHandler = lazy5;
        this.isOffScreen = z16;
        this.allowCameraManipulator = z17;
        this.mBootConfigJson = bootConfigJson;
        this.renderSize = size;
        R();
    }
}

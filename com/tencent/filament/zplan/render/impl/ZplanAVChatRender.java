package com.tencent.filament.zplan.render.impl;

import al0.a;
import android.content.Context;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.view.Surface;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import androidx.exifinterface.media.ExifInterface;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.filament.zplan.animation.FilamentAnimation;
import com.tencent.filament.zplan.constant.AVChatRenderEventsType;
import com.tencent.filament.zplan.data.AVChatAvatarRenderInfo;
import com.tencent.filament.zplan.data.AvatarAIInfo;
import com.tencent.filament.zplan.data.ZPlanPinchFaceModel;
import com.tencent.filament.zplan.engine.ZplanAVChatViewer;
import com.tencent.filament.zplan.f;
import com.tencent.filament.zplan.util.vsync.VSyncScheduler;
import com.tencent.filament.zplan.view.AVFilamentTextureView;
import com.tencent.filament.zplanservice.util.log.FLog;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.qqmini.sdk.launcher.MiniSDKConst;
import com.tencent.thread.monitor.plugin.proxy.BaseHandlerThread;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.locks.ReentrantLock;
import kotlin.Metadata;
import kotlin.Triple;
import kotlin.Unit;
import kotlin.collections.ArraysKt___ArraysJvmKt;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt__MutableCollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.apache.httpcore.message.TokenParser;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0094\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010#\n\u0002\b\u0006\n\u0002\u0010%\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0014\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b1\b\u0000\u0018\u0000 \u00ea\u00012\u00020\u0001:\u0001[Bf\u0012\u0007\u0010\u00cb\u0001\u001a\u00020\u0010\u0012\u0007\u0010\u00ce\u0001\u001a\u00020\u0010\u0012\u0007\u0010\u00d1\u0001\u001a\u00020\u0010\u0012\t\b\u0002\u0010\u00d5\u0001\u001a\u00020\u001a\u0012\t\b\u0002\u0010\u00d8\u0001\u001a\u00020\u001a\u0012\t\b\u0002\u0010\u00db\u0001\u001a\u00020\u001a\u0012\t\b\u0002\u0010\u00e1\u0001\u001a\u00020\n\u0012\t\b\u0002\u0010\u00e5\u0001\u001a\u00020\u0002\u0012\t\b\u0002\u0010\u00e7\u0001\u001a\u00020\u0002\u00a2\u0006\u0006\b\u00e8\u0001\u0010\u00e9\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0006\u001a\u00020\u0004H\u0002J\b\u0010\u0007\u001a\u00020\u0004H\u0002J\b\u0010\b\u001a\u00020\u0004H\u0002J\b\u0010\t\u001a\u00020\u0004H\u0002J\u0010\u0010\f\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\nH\u0002J\u0010\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\rH\u0002J\u001e\u0010\u0014\u001a\u00020\u00042\u0006\u0010\u0011\u001a\u00020\u00102\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00040\u0012H\u0002J\u0010\u0010\u0015\u001a\u00020\u00042\u0006\u0010\u0013\u001a\u00020\rH\u0002J\b\u0010\u0016\u001a\u00020\u0004H\u0002J\u0018\u0010\u0019\u001a\u00020\u00022\u0006\u0010\u0017\u001a\u00020\u00022\u0006\u0010\u0018\u001a\u00020\u0002H\u0002J\u0010\u0010\u001c\u001a\u00020\u00022\u0006\u0010\u001b\u001a\u00020\u001aH\u0002J\u0010\u0010\u001d\u001a\u00020\u00022\u0006\u0010\u0017\u001a\u00020\u0002H\u0002J\u0010\u0010\u001e\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\nH\u0002J\b\u0010\u001f\u001a\u00020\u0002H\u0002J\u0010\u0010\"\u001a\u00020\u00042\u0006\u0010!\u001a\u00020 H\u0016J!\u0010'\u001a\u00020&2\u0006\u0010$\u001a\u00020#2\b\u0010%\u001a\u0004\u0018\u00010\u0002H\u0016\u00a2\u0006\u0004\b'\u0010(J\u0010\u0010+\u001a\u00020\u00042\u0006\u0010*\u001a\u00020)H\u0016J\u0010\u0010,\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010-\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010.\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u00100\u001a\u00020\u00042\u0006\u0010/\u001a\u00020\u0002H\u0016J\u0010\u00101\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J(\u00106\u001a\u00020\u00042\u0006\u00102\u001a\u00020\u001a2\u0006\u00103\u001a\u00020\u001a2\u0006\u00104\u001a\u00020\u001a2\u0006\u00105\u001a\u00020\u001aH\u0016J\u0018\u00109\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u00108\u001a\u000207H\u0016J\b\u0010:\u001a\u00020\u0004H\u0016J\b\u0010;\u001a\u00020\u0004H\u0016J\b\u0010<\u001a\u00020\u0004H\u0016J\b\u0010=\u001a\u00020\u0004H\u0016J4\u0010A\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\"\u0010@\u001a\u001e\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u00100>j\u000e\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u0010`?H\u0016J*\u0010E\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010B\u001a\u00020\u00022\b\u0010*\u001a\u0004\u0018\u00010C2\u0006\u0010D\u001a\u00020\u001aH\u0016J\u0010\u0010G\u001a\u00020\u00042\u0006\u0010F\u001a\u00020\u001aH\u0016J\u0010\u0010I\u001a\u00020\u00042\u0006\u0010H\u001a\u00020\u0010H\u0016J\u0010\u0010J\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016JC\u0010Q\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010K\u001a\u00020\u00102\f\u0010N\u001a\b\u0012\u0004\u0012\u00020M0L2\f\u0010O\u001a\b\u0012\u0004\u0012\u00020\u00100L2\u0006\u0010P\u001a\u00020\u0002H\u0016\u00a2\u0006\u0004\bQ\u0010RJ*\u0010V\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010S\u001a\u00020\u00102\u0006\u0010T\u001a\u00020\u00102\b\u0010U\u001a\u0004\u0018\u00010\u0010H\u0016J\u0018\u0010X\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010W\u001a\u00020\u0010H\u0016J8\u0010\\\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010S\u001a\u00020\u00102\u0006\u0010Y\u001a\u00020\u001a2\u0006\u0010Z\u001a\u00020\u001a2\u0006\u0010E\u001a\u00020\u001a2\u0006\u0010[\u001a\u00020\u001aH\u0016J\u0012\u0010Y\u001a\u00020\u00042\b\u0010*\u001a\u0004\u0018\u00010]H\u0016J(\u0010`\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010^\u001a\u00020\u00102\u0006\u0010_\u001a\u00020\u001a2\u0006\u0010P\u001a\u00020\u0002H\u0016J \u0010c\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010a\u001a\u00020\u00102\u0006\u0010b\u001a\u00020\u0010H\u0016J\u0010\u0010Z\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010e\u001a\u00020\u00042\u0006\u0010d\u001a\u00020\u0010H\u0016J\u0010\u0010f\u001a\u00020\u00042\u0006\u0010d\u001a\u00020\u0010H\u0016J\u001c\u0010g\u001a\u00020\u00042\u0006\u0010\u0011\u001a\u00020\u00102\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00040\u0012R\u0016\u0010j\u001a\u00020h8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b[\u0010iR\u0018\u0010m\u001a\u0004\u0018\u00010k8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bE\u0010lR\u0018\u0010o\u001a\u0004\u0018\u00010h8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bn\u0010iR\u0016\u0010r\u001a\u00020p8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bI\u0010qR\u0018\u0010u\u001a\u0004\u0018\u00010s8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bV\u0010tR\u001a\u0010x\u001a\b\u0012\u0004\u0012\u00020\r0v8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\\\u0010wR\u0018\u0010{\u001a\u0004\u0018\u00010y8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bZ\u0010zR\u0018\u0010~\u001a\u0004\u0018\u00010|8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b,\u0010}R\u001a\u0010\u0081\u0001\u001a\u0004\u0018\u00010\u007f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0007\n\u0005\b0\u0010\u0080\u0001R\u001a\u0010\u0083\u0001\u001a\u0004\u0018\u00010 8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0007\n\u0005\bA\u0010\u0082\u0001R\u001c\u0010\u0087\u0001\u001a\u0005\u0018\u00010\u0084\u00018\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u0085\u0001\u0010\u0086\u0001R\u001a\u0010\u0089\u0001\u001a\u0004\u0018\u00010)8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0007\n\u0005\b1\u0010\u0088\u0001RB\u0010\u008c\u0001\u001a,\u0012\u0004\u0012\u00020\u001a\u0012\u000b\u0012\t\u0012\u0005\u0012\u00030\u008a\u00010L0>j\u0015\u0012\u0004\u0012\u00020\u001a\u0012\u000b\u0012\t\u0012\u0005\u0012\u00030\u008a\u00010L`?8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0007\n\u0005\bX\u0010\u008b\u0001RB\u0010\u008d\u0001\u001a,\u0012\u0004\u0012\u00020\u001a\u0012\u000b\u0012\t\u0012\u0005\u0012\u00030\u008a\u00010L0>j\u0015\u0012\u0004\u0012\u00020\u001a\u0012\u000b\u0012\t\u0012\u0005\u0012\u00030\u008a\u00010L`?8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0007\n\u0005\b-\u0010\u008b\u0001R\u001d\u0010\u0090\u0001\u001a\t\u0012\u0004\u0012\u00020\u00100\u008e\u00018\u0002X\u0082\u0004\u00a2\u0006\u0007\n\u0005\b+\u0010\u008f\u0001R\u0017\u0010P\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0007\n\u0005\b.\u0010\u0091\u0001R\u001b\u0010\u0094\u0001\u001a\u0004\u0018\u00010]8\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u0092\u0001\u0010\u0093\u0001R'\u0010\u0097\u0001\u001a\u0011\u0012\u0004\u0012\u00020\u001a\u0012\u0006\u0012\u0004\u0018\u00010C0\u0095\u00018\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0007\n\u0005\bY\u0010\u0096\u0001R%\u0010\u0098\u0001\u001a\u000f\u0012\u0004\u0012\u00020\u001a\u0012\u0004\u0012\u00020\u001a0\u0095\u00018\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0007\n\u0005\bf\u0010\u0096\u0001R&\u0010\u009a\u0001\u001a\u000f\u0012\u0004\u0012\u00020\u001a\u0012\u0004\u0012\u00020\n0\u0095\u00018\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u0099\u0001\u0010\u0096\u0001R\u0019\u0010\u009d\u0001\u001a\u00030\u009b\u00018\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0007\n\u0005\bc\u0010\u009c\u0001R\u0019\u0010\u009e\u0001\u001a\u00030\u009b\u00018\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0007\n\u0005\bJ\u0010\u009c\u0001R%\u0010\u00a1\u0001\u001a\u000f\u0012\u0004\u0012\u00020\u001a\u0012\u0004\u0012\u00020\u00020\u009f\u00018\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0007\n\u0005\b`\u0010\u00a0\u0001R$\u0010\u00a3\u0001\u001a\u0010\u0012\u0004\u0012\u00020\u0010\u0012\u0005\u0012\u00030\u00a2\u00010\u0095\u00018\u0002X\u0082\u0004\u00a2\u0006\u0007\n\u0005\bQ\u0010\u0096\u0001R\u0019\u0010\u00a6\u0001\u001a\u00020\u001a8\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u00a4\u0001\u0010\u00a5\u0001R\u0018\u0010\u00a7\u0001\u001a\u00020\u001a8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0007\n\u0005\b'\u0010\u00a5\u0001R\u0019\u0010\u00a9\u0001\u001a\u00020\u001a8\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u00a8\u0001\u0010\u00a5\u0001R\u0018\u0010\u00aa\u0001\u001a\u00020\u001a8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0007\n\u0005\b6\u0010\u00a5\u0001R\u0018\u0010\u00ab\u0001\u001a\u00020\u001a8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0007\n\u0005\be\u0010\u00a5\u0001R\u0018\u0010\u00ac\u0001\u001a\u00020\u001a8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0007\n\u0005\b\"\u0010\u00a5\u0001R\u0018\u0010\u00ad\u0001\u001a\u00020\u001a8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0007\n\u0005\b9\u0010\u00a5\u0001R\u0019\u0010\u00af\u0001\u001a\u00020\u001a8\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u00ae\u0001\u0010\u00a5\u0001R\u0019\u0010\u00b1\u0001\u001a\u00020\u001a8\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u00b0\u0001\u0010\u00a5\u0001R\u0019\u0010\u00b3\u0001\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u00b2\u0001\u0010\u0091\u0001R\u0019\u0010\u00b4\u0001\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u00a5\u0001\u0010\u0091\u0001R\u0019\u0010\u00b6\u0001\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u00b5\u0001\u0010\u0091\u0001R-\u0010\u00b9\u0001\u001a\u0016\u0012\u0004\u0012\u00020\u001a\u0012\u000b\u0012\t\u0012\u0004\u0012\u0002070\u00b7\u00010\u009f\u00018\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u00b8\u0001\u0010\u00a0\u0001R)\u0010\u00bc\u0001\u001a\u0012\u0012\u0004\u0012\u00020\u001a\u0012\u0007\u0012\u0005\u0018\u00010\u00ba\u00010\u009f\u00018\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u00bb\u0001\u0010\u00a0\u0001R\u0019\u0010\u00be\u0001\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u00bd\u0001\u0010\u0091\u0001R\u0019\u0010\u00c0\u0001\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u00bf\u0001\u0010\u0091\u0001R\u0019\u0010\u00c2\u0001\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u00c1\u0001\u0010\u0091\u0001R\u0019\u0010\u00c4\u0001\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u00c3\u0001\u0010\u0091\u0001R\u0019\u0010\u00c6\u0001\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u00c5\u0001\u0010\u0091\u0001R\u001c\u0010\u00cb\u0001\u001a\u00020\u00108\u0006\u00a2\u0006\u0010\n\u0006\b\u00c7\u0001\u0010\u00c8\u0001\u001a\u0006\b\u00c9\u0001\u0010\u00ca\u0001R\u001c\u0010\u00ce\u0001\u001a\u00020\u00108\u0006\u00a2\u0006\u0010\n\u0006\b\u00cc\u0001\u0010\u00c8\u0001\u001a\u0006\b\u00cd\u0001\u0010\u00ca\u0001R\u001c\u0010\u00d1\u0001\u001a\u00020\u00108\u0006\u00a2\u0006\u0010\n\u0006\b\u00cf\u0001\u0010\u00c8\u0001\u001a\u0006\b\u00d0\u0001\u0010\u00ca\u0001R\u001c\u0010\u00d5\u0001\u001a\u00020\u001a8\u0006\u00a2\u0006\u0010\n\u0006\b\u00d2\u0001\u0010\u00a5\u0001\u001a\u0006\b\u00d3\u0001\u0010\u00d4\u0001R\u001c\u0010\u00d8\u0001\u001a\u00020\u001a8\u0006\u00a2\u0006\u0010\n\u0006\b\u00d6\u0001\u0010\u00a5\u0001\u001a\u0006\b\u00d7\u0001\u0010\u00d4\u0001R\u001c\u0010\u00db\u0001\u001a\u00020\u001a8\u0006\u00a2\u0006\u0010\n\u0006\b\u00d9\u0001\u0010\u00a5\u0001\u001a\u0006\b\u00da\u0001\u0010\u00d4\u0001R)\u0010\u00e1\u0001\u001a\u00020\n8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0018\n\u0006\b\u00dc\u0001\u0010\u00b5\u0001\u001a\u0006\b\u00dd\u0001\u0010\u00de\u0001\"\u0006\b\u00df\u0001\u0010\u00e0\u0001R\u001c\u0010\u00e5\u0001\u001a\u00020\u00028\u0006\u00a2\u0006\u0010\n\u0006\b\u00e2\u0001\u0010\u0091\u0001\u001a\u0006\b\u00e3\u0001\u0010\u00e4\u0001R\u001c\u0010\u00e7\u0001\u001a\u00020\u00028\u0006\u00a2\u0006\u0010\n\u0006\b\u0091\u0001\u0010\u0091\u0001\u001a\u0006\b\u00e6\u0001\u0010\u00e4\u0001\u00a8\u0006\u00eb\u0001"}, d2 = {"Lcom/tencent/filament/zplan/render/impl/ZplanAVChatRender;", "Lcom/tencent/filament/zplan/f;", "", "isLocal", "", "R0", "L0", "E0", "K0", "M0", "", "frameTimeNanos", "O0", "Ljava/lang/Runnable;", "runnable", "A0", "", "from", "Lkotlin/Function0;", "task", "C0", "x0", "D0", "needRecord", "needRenderImmediately", "P0", "", "viewIndex", "y0", "Q0", "S0", "J0", "Lcom/tencent/filament/zplan/view/AVFilamentTextureView;", "filamentTextureView", "D", "Landroid/content/Context;", "context", "enableTouch", "Landroid/view/View;", QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, "(Landroid/content/Context;Ljava/lang/Boolean;)Landroid/view/View;", "Luk0/b;", "listener", "o", h.F, DomainData.DOMAIN_NAME, "p", "isHorizontal", "i", "l", "width", "height", "left", "bottom", "B", "Lcom/tencent/filament/zplan/data/AvatarAIInfo;", "avatarAIInfo", "E", "onResume", MiniSDKConst.NOTIFY_EVENT_ONPAUSE, MosaicConstants$JsFunction.FUNC_ON_DESTROY, "onFinish", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "resourcePathMap", "j", "isMale", "Lcom/tencent/filament/zplan/a;", "delayFrame", "b", "index", "z0", "iblPath", "d", "v", "pinchFaceConfigPath", "", "Lcom/tencent/filament/zplan/data/ZPlanPinchFaceModel;", "pinchFaceModels", "itemIdArray", "isFemale", HippyTKDListViewAdapter.X, "(ZLjava/lang/String;[Lcom/tencent/filament/zplan/data/ZPlanPinchFaceModel;[Ljava/lang/String;Z)V", "slotName", "textureAbsPath", "jsonAbsPath", "e", "lutPath", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "r", "g", "a", "f", "Lcom/tencent/filament/zplan/b;", "animationGltfPath", "animationID", "w", "gltfPath", "imageName", "u", "path", BdhLogUtil.LogTag.Tag_Conn, ReportConstant.COSTREPORT_PREFIX, "B0", "Landroid/os/Handler;", "Landroid/os/Handler;", "uiHandler", "Landroid/os/HandlerThread;", "Landroid/os/HandlerThread;", "viewerHandlerThread", "c", "viewerHandler", "Ljava/util/concurrent/locks/ReentrantLock;", "Ljava/util/concurrent/locks/ReentrantLock;", "viewerHandlerLock", "Lcom/tencent/filament/zplan/engine/ZplanAVChatViewer;", "Lcom/tencent/filament/zplan/engine/ZplanAVChatViewer;", "filamentViewer", "", "Ljava/util/List;", "viewerWaitList", "Landroid/view/Surface;", "Landroid/view/Surface;", "renderSurface", "Lcom/tencent/filament/zplan/util/vsync/VSyncScheduler;", "Lcom/tencent/filament/zplan/util/vsync/VSyncScheduler;", "vSyncScheduler", "Lcom/tencent/filament/zplan/util/vsync/b;", "Lcom/tencent/filament/zplan/util/vsync/b;", "vSyncListener", "Lcom/tencent/filament/zplan/view/AVFilamentTextureView;", "filamentView", "Luk0/c;", "k", "Luk0/c;", "filamentRenderListener", "Luk0/b;", "renderEventsCallback", "Lcom/tencent/filament/zplan/animation/FilamentAnimation;", "Ljava/util/HashMap;", "maleAnimationMap", "femaleAnimation", "", "Ljava/util/Set;", "makeupSet", "Z", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "Lcom/tencent/filament/zplan/b;", "animationListener", "", "Ljava/util/Map;", "reloadAvatarListener", "reloadAvatarDelayFrame", "t", "reloadAvatarRenderTime", "Ljava/util/concurrent/atomic/AtomicBoolean;", "Ljava/util/concurrent/atomic/AtomicBoolean;", "destroy", "useRecordCallback", "Ljava/util/concurrent/ConcurrentHashMap;", "Ljava/util/concurrent/ConcurrentHashMap;", "hasReloadAvatar", "Lal0/a;", "startupSteps", "y", "I", "localAvatarIndex", "remoteAvatarIndex", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "curSmallViewIndex", "surfaceWidth", "surfaceHeight", "smallViewWidth", "smallViewHeight", UserInfo.SEX_FEMALE, "smallViewLeftMargin", "G", "smallViewBottomMargin", "H", "needRestoreLocalViewCreate", "needRestoreRemoteViewCreate", "J", "isDoubleHorizontal", "Ljava/util/concurrent/CopyOnWriteArrayList;", "K", "mUinToAIInfoCacheList", "Lcom/tencent/filament/zplan/data/AVChatAvatarRenderInfo;", "L", "mRenderViewInfoMap", "M", "mIsPlayingAnimation", "N", "mIsLocalNeedPopTransform", "O", "mIsRemoteNeedPopTransform", "P", "mIsLocalTransformInit", AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, "mIsRemoteTransformInit", BdhLogUtil.LogTag.Tag_Req, "Ljava/lang/String;", "H0", "()Ljava/lang/String;", "filamatPath", ExifInterface.LATITUDE_SOUTH, "G0", "bodyResJsonPath", "T", "F0", "aiBundlePath", "U", "getOriginFps", "()I", "originFps", "V", "getTargetFps", "targetFps", "W", "I0", "renderMaxTargetWidth", "X", "getDelayRenderMs", "()J", "setDelayRenderMs", "(J)V", "delayRenderMs", "Y", "N0", "()Z", "isRenderDebug", "getEnableInterpolate", "enableInterpolate", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IIIJZZ)V", "c0", "zplan-android_release"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes6.dex */
public final class ZplanAVChatRender implements f {

    /* renamed from: a0, reason: collision with root package name */
    private static final List<Float> f105873a0;

    /* renamed from: b0, reason: collision with root package name */
    private static final List<Float> f105874b0;

    /* renamed from: A, reason: from kotlin metadata */
    private volatile int curSmallViewIndex;

    /* renamed from: B, reason: from kotlin metadata */
    private int surfaceWidth;

    /* renamed from: C, reason: from kotlin metadata */
    private int surfaceHeight;

    /* renamed from: D, reason: from kotlin metadata */
    private int smallViewWidth;

    /* renamed from: E, reason: from kotlin metadata */
    private int smallViewHeight;

    /* renamed from: F, reason: from kotlin metadata */
    private int smallViewLeftMargin;

    /* renamed from: G, reason: from kotlin metadata */
    private int smallViewBottomMargin;

    /* renamed from: H, reason: from kotlin metadata */
    private boolean needRestoreLocalViewCreate;

    /* renamed from: I, reason: from kotlin metadata */
    private boolean needRestoreRemoteViewCreate;

    /* renamed from: J, reason: from kotlin metadata */
    private boolean isDoubleHorizontal;

    /* renamed from: K, reason: from kotlin metadata */
    private volatile ConcurrentHashMap<Integer, CopyOnWriteArrayList<AvatarAIInfo>> mUinToAIInfoCacheList;

    /* renamed from: L, reason: from kotlin metadata */
    private ConcurrentHashMap<Integer, AVChatAvatarRenderInfo> mRenderViewInfoMap;

    /* renamed from: M, reason: from kotlin metadata */
    private boolean mIsPlayingAnimation;

    /* renamed from: N, reason: from kotlin metadata */
    private boolean mIsLocalNeedPopTransform;

    /* renamed from: O, reason: from kotlin metadata */
    private boolean mIsRemoteNeedPopTransform;

    /* renamed from: P, reason: from kotlin metadata */
    private boolean mIsLocalTransformInit;

    /* renamed from: Q, reason: from kotlin metadata */
    private boolean mIsRemoteTransformInit;

    /* renamed from: R, reason: from kotlin metadata */
    @NotNull
    private final String filamatPath;

    /* renamed from: S, reason: from kotlin metadata */
    @NotNull
    private final String bodyResJsonPath;

    /* renamed from: T, reason: from kotlin metadata */
    @NotNull
    private final String aiBundlePath;

    /* renamed from: U, reason: from kotlin metadata */
    private final int originFps;

    /* renamed from: V, reason: from kotlin metadata */
    private final int targetFps;

    /* renamed from: W, reason: from kotlin metadata */
    private final int renderMaxTargetWidth;

    /* renamed from: X, reason: from kotlin metadata */
    private long delayRenderMs;

    /* renamed from: Y, reason: from kotlin metadata */
    private final boolean isRenderDebug;

    /* renamed from: Z, reason: from kotlin metadata */
    private final boolean enableInterpolate;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private Handler uiHandler;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private HandlerThread viewerHandlerThread;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private Handler viewerHandler;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private ReentrantLock viewerHandlerLock;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private ZplanAVChatViewer filamentViewer;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private final List<Runnable> viewerWaitList;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    private Surface renderSurface;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private VSyncScheduler vSyncScheduler;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private com.tencent.filament.zplan.util.vsync.b vSyncListener;

    /* renamed from: j, reason: collision with root package name and from kotlin metadata */
    private AVFilamentTextureView filamentView;

    /* renamed from: k, reason: collision with root package name and from kotlin metadata */
    private uk0.c filamentRenderListener;

    /* renamed from: l, reason: collision with root package name and from kotlin metadata */
    private uk0.b renderEventsCallback;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private HashMap<Integer, FilamentAnimation[]> maleAnimationMap;

    /* renamed from: n, reason: collision with root package name and from kotlin metadata */
    private HashMap<Integer, FilamentAnimation[]> femaleAnimation;

    /* renamed from: o, reason: collision with root package name and from kotlin metadata */
    private final Set<String> makeupSet;

    /* renamed from: p, reason: collision with root package name and from kotlin metadata */
    private boolean isFemale;

    /* renamed from: q, reason: collision with root package name and from kotlin metadata */
    private com.tencent.filament.zplan.b animationListener;

    /* renamed from: r, reason: collision with root package name and from kotlin metadata */
    private Map<Integer, com.tencent.filament.zplan.a> reloadAvatarListener;

    /* renamed from: s, reason: collision with root package name and from kotlin metadata */
    private Map<Integer, Integer> reloadAvatarDelayFrame;

    /* renamed from: t, reason: collision with root package name and from kotlin metadata */
    private Map<Integer, Long> reloadAvatarRenderTime;

    /* renamed from: u, reason: collision with root package name and from kotlin metadata */
    private AtomicBoolean destroy;

    /* renamed from: v, reason: collision with root package name and from kotlin metadata */
    private AtomicBoolean useRecordCallback;

    /* renamed from: w, reason: collision with root package name and from kotlin metadata */
    private ConcurrentHashMap<Integer, Boolean> hasReloadAvatar;

    /* renamed from: x, reason: collision with root package name and from kotlin metadata */
    private final Map<String, al0.a> startupSteps;

    /* renamed from: y, reason: collision with root package name and from kotlin metadata */
    private volatile int localAvatarIndex;

    /* renamed from: z, reason: collision with root package name and from kotlin metadata */
    private volatile int remoteAvatarIndex;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0016\u00a8\u0006\u0007"}, d2 = {"com/tencent/filament/zplan/render/impl/ZplanAVChatRender$b", "Lcom/tencent/filament/zplan/util/vsync/b;", "", "totalTime", "frameTime", "", "d", "zplan-android_release"}, k = 1, mv = {1, 4, 2})
    /* loaded from: classes6.dex */
    public static final class b implements com.tencent.filament.zplan.util.vsync.b {
        b() {
        }

        @Override // com.tencent.filament.zplan.util.vsync.b
        public void d(long totalTime, long frameTime) {
            ZplanAVChatRender.this.O0(frameTime);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/filament/zplan/render/impl/ZplanAVChatRender$c", "Ljava/util/concurrent/Executor;", "Ljava/lang/Runnable;", "command", "", "execute", "zplan-android_release"}, k = 1, mv = {1, 4, 2})
    /* loaded from: classes6.dex */
    public static final class c implements Executor {
        c() {
        }

        @Override // java.util.concurrent.Executor
        public void execute(@Nullable Runnable command) {
            if (command != null) {
                ReentrantLock reentrantLock = ZplanAVChatRender.this.viewerHandlerLock;
                reentrantLock.lock();
                try {
                    Handler handler = ZplanAVChatRender.this.viewerHandler;
                    if (handler != null) {
                        handler.post(command);
                    }
                } finally {
                    reentrantLock.unlock();
                }
            }
        }
    }

    static {
        List<Float> listOf;
        List<Float> listOf2;
        Float valueOf = Float.valueOf(0.0f);
        listOf = CollectionsKt__CollectionsKt.listOf((Object[]) new Float[]{valueOf, Float.valueOf(-20.0f), valueOf});
        f105873a0 = listOf;
        listOf2 = CollectionsKt__CollectionsKt.listOf((Object[]) new Float[]{Float.valueOf(-0.006f), Float.valueOf(19.208f), Float.valueOf(-17.162f)});
        f105874b0 = listOf2;
    }

    public ZplanAVChatRender(@NotNull String filamatPath, @NotNull String bodyResJsonPath, @NotNull String aiBundlePath, int i3, int i16, int i17, long j3, boolean z16, boolean z17) {
        Intrinsics.checkNotNullParameter(filamatPath, "filamatPath");
        Intrinsics.checkNotNullParameter(bodyResJsonPath, "bodyResJsonPath");
        Intrinsics.checkNotNullParameter(aiBundlePath, "aiBundlePath");
        this.filamatPath = filamatPath;
        this.bodyResJsonPath = bodyResJsonPath;
        this.aiBundlePath = aiBundlePath;
        this.originFps = i3;
        this.targetFps = i16;
        this.renderMaxTargetWidth = i17;
        this.delayRenderMs = j3;
        this.isRenderDebug = z16;
        this.enableInterpolate = z17;
        this.viewerHandlerLock = new ReentrantLock();
        this.viewerWaitList = new ArrayList();
        this.maleAnimationMap = new HashMap<>();
        this.femaleAnimation = new HashMap<>();
        this.makeupSet = new LinkedHashSet();
        this.reloadAvatarListener = new LinkedHashMap();
        this.reloadAvatarDelayFrame = new LinkedHashMap();
        this.reloadAvatarRenderTime = new LinkedHashMap();
        this.destroy = new AtomicBoolean(false);
        this.useRecordCallback = new AtomicBoolean(false);
        this.hasReloadAvatar = new ConcurrentHashMap<>();
        this.startupSteps = new LinkedHashMap();
        this.localAvatarIndex = -1;
        this.remoteAvatarIndex = -1;
        this.curSmallViewIndex = -1;
        this.surfaceWidth = -1;
        this.surfaceHeight = -1;
        this.smallViewWidth = -1;
        this.smallViewHeight = -1;
        this.smallViewLeftMargin = -1;
        this.smallViewBottomMargin = -1;
        this.mUinToAIInfoCacheList = new ConcurrentHashMap<>();
        this.mRenderViewInfoMap = new ConcurrentHashMap<>();
        this.uiHandler = new Handler(Looper.getMainLooper());
        L0();
        M0();
        K0();
    }

    private final void A0(final Runnable runnable) {
        if (Intrinsics.areEqual(Looper.myLooper(), Looper.getMainLooper())) {
            runnable.run();
        } else {
            this.uiHandler.post(new Runnable() { // from class: com.tencent.filament.zplan.render.impl.ZplanAVChatRender$doOnUiThread$1
                @Override // java.lang.Runnable
                public final void run() {
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void C0(String from, Function0<Unit> task) {
        int i3;
        al0.a aVar = new al0.a(0L, 0L, false, 0, null, 31, null);
        a.Companion companion = al0.a.INSTANCE;
        aVar.l(companion.b());
        task.invoke();
        aVar.i(companion.b());
        FLog fLog = FLog.INSTANCE;
        StringBuilder sb5 = new StringBuilder();
        sb5.append("doTask: ");
        sb5.append(from);
        sb5.append(TokenParser.SP);
        sb5.append(aVar);
        sb5.append(", threadId: ");
        Thread currentThread = Thread.currentThread();
        Intrinsics.checkNotNullExpressionValue(currentThread, "Thread.currentThread()");
        sb5.append(currentThread.getId());
        fLog.i("FilamentAVChatRender", sb5.toString());
        this.startupSteps.put(from, aVar);
        if (Intrinsics.areEqual("reloadAvatar", from)) {
            int i16 = 3;
            if (this.localAvatarIndex >= 0 && this.reloadAvatarListener.get(Integer.valueOf(this.localAvatarIndex)) != null) {
                this.hasReloadAvatar.put(Integer.valueOf(this.localAvatarIndex), Boolean.TRUE);
                this.reloadAvatarRenderTime.put(Integer.valueOf(this.localAvatarIndex), Long.valueOf(System.nanoTime()));
                int round = (int) Math.round(aVar.f() / (1000.0d / this.targetFps));
                Map<Integer, Integer> map = this.reloadAvatarDelayFrame;
                Integer valueOf = Integer.valueOf(this.localAvatarIndex);
                Integer num = this.reloadAvatarDelayFrame.get(Integer.valueOf(this.localAvatarIndex));
                if (num != null) {
                    i3 = num.intValue();
                } else {
                    i3 = 3;
                }
                map.put(valueOf, Integer.valueOf(Math.max(round, i3)));
                fLog.i("FilamentAVChatRender", "doTask: " + from + ", reload local AvatarRenderTime: " + this.reloadAvatarRenderTime + ", delay: " + round + ", reloadAvatarDelayFrame: " + this.reloadAvatarDelayFrame);
            }
            if (this.remoteAvatarIndex >= 0 && this.reloadAvatarListener.get(Integer.valueOf(this.remoteAvatarIndex)) != null) {
                this.hasReloadAvatar.put(Integer.valueOf(this.remoteAvatarIndex), Boolean.TRUE);
                this.reloadAvatarRenderTime.put(Integer.valueOf(this.remoteAvatarIndex), Long.valueOf(System.nanoTime()));
                int round2 = (int) Math.round(aVar.f() / (1000.0d / this.targetFps));
                Map<Integer, Integer> map2 = this.reloadAvatarDelayFrame;
                Integer valueOf2 = Integer.valueOf(this.remoteAvatarIndex);
                Integer num2 = this.reloadAvatarDelayFrame.get(Integer.valueOf(this.remoteAvatarIndex));
                if (num2 != null) {
                    i16 = num2.intValue();
                }
                map2.put(valueOf2, Integer.valueOf(Math.max(round2, i16)));
                fLog.i("FilamentAVChatRender", "doTask: " + from + ", reload remote AvatarRenderTime: " + this.reloadAvatarRenderTime + ", delay: " + round2 + ", reloadAvatarDelayFrame: " + this.reloadAvatarDelayFrame);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void D0() {
        if (this.filamentViewer == null) {
            FLog.INSTANCE.e("FilamentAVChatRender", "evaluateViewerWaitList, return");
            return;
        }
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
        FLog.INSTANCE.i("FilamentAVChatRender", "evaluateViewerWaitList, total:" + size);
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            ((Runnable) it.next()).run();
        }
    }

    private final void E0() {
        ReentrantLock reentrantLock = this.viewerHandlerLock;
        reentrantLock.lock();
        try {
            Handler handler = this.viewerHandler;
            if (handler != null) {
                Intrinsics.checkNotNull(handler);
                handler.removeCallbacksAndMessages(null);
            }
            if (this.viewerHandlerThread != null) {
                FLog fLog = FLog.INSTANCE;
                StringBuilder sb5 = new StringBuilder();
                sb5.append("finishViewerThread  threadId: ");
                HandlerThread handlerThread = this.viewerHandlerThread;
                Intrinsics.checkNotNull(handlerThread);
                sb5.append(handlerThread.getThreadId());
                fLog.i("FilamentAVChatRender", sb5.toString());
                HandlerThread handlerThread2 = this.viewerHandlerThread;
                Intrinsics.checkNotNull(handlerThread2);
                handlerThread2.quitSafely();
                fLog.i("FilamentAVChatRender", "finishViewerThread quitSafely end.");
                this.viewerHandlerThread = null;
            }
            Unit unit = Unit.INSTANCE;
        } finally {
            reentrantLock.unlock();
        }
    }

    private final boolean J0() {
        boolean z16;
        boolean z17 = true;
        if (this.localAvatarIndex >= 0 && this.mRenderViewInfoMap.get(Integer.valueOf(this.localAvatarIndex)) != null) {
            AVChatAvatarRenderInfo aVChatAvatarRenderInfo = this.mRenderViewInfoMap.get(Integer.valueOf(this.localAvatarIndex));
            Intrinsics.checkNotNull(aVChatAvatarRenderInfo);
            if (aVChatAvatarRenderInfo.getFirstRenderTimestamp() >= 0) {
                z16 = true;
                if (z16 && this.remoteAvatarIndex >= 0 && this.mRenderViewInfoMap.get(Integer.valueOf(this.remoteAvatarIndex)) != null) {
                    AVChatAvatarRenderInfo aVChatAvatarRenderInfo2 = this.mRenderViewInfoMap.get(Integer.valueOf(this.remoteAvatarIndex));
                    Intrinsics.checkNotNull(aVChatAvatarRenderInfo2);
                    if (aVChatAvatarRenderInfo2.getFirstRenderTimestamp() < 0) {
                        z17 = false;
                    }
                    return z17;
                }
                return z16;
            }
        }
        z16 = false;
        return z16 ? z16 : z16;
    }

    private final void K0() {
        ReentrantLock reentrantLock = this.viewerHandlerLock;
        reentrantLock.lock();
        try {
            if (this.viewerHandler == null) {
                L0();
            }
            Handler handler = this.viewerHandler;
            if (handler != null) {
                handler.post(new Runnable() { // from class: com.tencent.filament.zplan.render.impl.ZplanAVChatRender$initViewer$$inlined$withLock$lambda$1
                    @Override // java.lang.Runnable
                    public final void run() {
                        ZplanAVChatViewer zplanAVChatViewer;
                        ZplanAVChatViewer zplanAVChatViewer2;
                        ZplanAVChatViewer zplanAVChatViewer3;
                        ZplanAVChatViewer zplanAVChatViewer4;
                        boolean z16;
                        boolean z17;
                        boolean z18;
                        boolean z19;
                        uk0.b bVar;
                        uk0.b bVar2;
                        zplanAVChatViewer = ZplanAVChatRender.this.filamentViewer;
                        if (zplanAVChatViewer == null) {
                            FLog fLog = FLog.INSTANCE;
                            fLog.i("FilamentAVChatRender", "initViewer");
                            ZplanAVChatRender.this.filamentViewer = new ZplanAVChatViewer(ZplanAVChatRender.this.getFilamatPath(), ZplanAVChatRender.this.getBodyResJsonPath(), ZplanAVChatRender.this.getAiBundlePath(), ZplanAVChatRender.this.getRenderMaxTargetWidth(), ZplanAVChatRender.this.getIsRenderDebug());
                            zplanAVChatViewer2 = ZplanAVChatRender.this.filamentViewer;
                            if (zplanAVChatViewer2 != null) {
                                zplanAVChatViewer2.loadSpotLight();
                            }
                            zplanAVChatViewer3 = ZplanAVChatRender.this.filamentViewer;
                            if (zplanAVChatViewer3 != null) {
                                zplanAVChatViewer3.loadSun();
                            }
                            zplanAVChatViewer4 = ZplanAVChatRender.this.filamentViewer;
                            if (zplanAVChatViewer4 != null) {
                                StringBuilder sb5 = new StringBuilder();
                                sb5.append("createAvatar restore remote=");
                                z16 = ZplanAVChatRender.this.needRestoreLocalViewCreate;
                                sb5.append(z16);
                                sb5.append(" local=");
                                z17 = ZplanAVChatRender.this.needRestoreRemoteViewCreate;
                                sb5.append(z17);
                                fLog.i("FilamentAVChatRender", sb5.toString());
                                z18 = ZplanAVChatRender.this.needRestoreLocalViewCreate;
                                if (z18) {
                                    ZplanAVChatRender.this.h(true);
                                    bVar2 = ZplanAVChatRender.this.renderEventsCallback;
                                    if (bVar2 != null) {
                                        bVar2.a(true, AVChatRenderEventsType.EVENT_CREATE_AVATAR_RESTORE);
                                    }
                                }
                                z19 = ZplanAVChatRender.this.needRestoreRemoteViewCreate;
                                if (z19) {
                                    ZplanAVChatRender.this.h(false);
                                    bVar = ZplanAVChatRender.this.renderEventsCallback;
                                    if (bVar != null) {
                                        bVar.a(false, AVChatRenderEventsType.EVENT_CREATE_AVATAR_RESTORE);
                                    }
                                }
                            }
                        }
                    }
                });
            }
        } finally {
            reentrantLock.unlock();
        }
    }

    private final void L0() {
        ReentrantLock reentrantLock = this.viewerHandlerLock;
        reentrantLock.lock();
        try {
            if (this.viewerHandlerThread == null) {
                FLog fLog = FLog.INSTANCE;
                fLog.i("FilamentAVChatRender", "initViewerThread");
                BaseHandlerThread baseHandlerThread = new BaseHandlerThread("filament_viewer_thread");
                this.viewerHandlerThread = baseHandlerThread;
                Intrinsics.checkNotNull(baseHandlerThread);
                baseHandlerThread.start();
                StringBuilder sb5 = new StringBuilder();
                sb5.append("initViewerThread  threadId: ");
                HandlerThread handlerThread = this.viewerHandlerThread;
                Intrinsics.checkNotNull(handlerThread);
                sb5.append(handlerThread.getThreadId());
                fLog.i("FilamentAVChatRender", sb5.toString());
                HandlerThread handlerThread2 = this.viewerHandlerThread;
                Intrinsics.checkNotNull(handlerThread2);
                this.viewerHandler = new Handler(handlerThread2.getLooper());
            }
            Unit unit = Unit.INSTANCE;
        } finally {
            reentrantLock.unlock();
        }
    }

    private final void M0() {
        if (this.vSyncListener == null || this.vSyncScheduler == null) {
            FLog.INSTANCE.i("FilamentAVChatRender", "initVsyncScheduler");
            this.vSyncListener = new b();
            com.tencent.filament.zplan.util.vsync.b bVar = this.vSyncListener;
            Intrinsics.checkNotNull(bVar);
            this.vSyncScheduler = new VSyncScheduler(bVar, this.targetFps, new c());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:128:? A[ADDED_TO_REGION, RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:129:0x01b5  */
    /* JADX WARN: Removed duplicated region for block: B:132:0x013c  */
    /* JADX WARN: Removed duplicated region for block: B:137:0x0146  */
    /* JADX WARN: Removed duplicated region for block: B:141:0x0171  */
    /* JADX WARN: Removed duplicated region for block: B:146:0x017b  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0049  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0068  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x008a  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x01af  */
    /* JADX WARN: Removed duplicated region for block: B:64:0x01bd  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x01e1 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:71:0x01ef A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:76:0x0216  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x0264  */
    /* JADX WARN: Removed duplicated region for block: B:82:0x0271  */
    /* JADX WARN: Removed duplicated region for block: B:92:0x0269  */
    /* JADX WARN: Removed duplicated region for block: B:93:0x021c  */
    /* JADX WARN: Removed duplicated region for block: B:95:0x02f0 A[ADDED_TO_REGION] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void O0(long frameTimeNanos) {
        Surface surface;
        boolean z16;
        boolean z17;
        boolean z18;
        boolean z19;
        ZplanAVChatViewer zplanAVChatViewer;
        ZplanAVChatViewer zplanAVChatViewer2;
        ZplanAVChatViewer zplanAVChatViewer3;
        boolean Q0;
        long j3;
        long j16;
        long j17;
        Integer num;
        long j18;
        long nanos;
        Long l3;
        long j19;
        long j26;
        ZplanAVChatViewer zplanAVChatViewer4;
        boolean z26;
        boolean z27;
        D0();
        if (this.filamentViewer != null && (surface = this.renderSurface) != null) {
            if (surface != null) {
                z16 = surface.isValid();
            } else {
                z16 = false;
            }
            if (z16) {
                boolean z28 = this.useRecordCallback.get();
                if (this.localAvatarIndex >= 0) {
                    Boolean bool = this.hasReloadAvatar.get(Integer.valueOf(this.localAvatarIndex));
                    if (bool != null) {
                        z27 = bool.booleanValue();
                    } else {
                        z27 = false;
                    }
                    if (z27) {
                        z17 = true;
                        if (this.remoteAvatarIndex >= 0) {
                            Boolean bool2 = this.hasReloadAvatar.get(Integer.valueOf(this.remoteAvatarIndex));
                            if (bool2 != null) {
                                z26 = bool2.booleanValue();
                            } else {
                                z26 = false;
                            }
                            if (z26) {
                                z18 = true;
                                if ((this.localAvatarIndex < 0 && (zplanAVChatViewer4 = this.filamentViewer) != null && zplanAVChatViewer4.check3DMMReady(this.localAvatarIndex)) || (this.remoteAvatarIndex >= 0 && (zplanAVChatViewer = this.filamentViewer) != null && zplanAVChatViewer.check3DMMReady(this.remoteAvatarIndex))) {
                                    z19 = true;
                                } else {
                                    z19 = false;
                                }
                                if (!z19 && J0()) {
                                    if (this.mIsPlayingAnimation) {
                                        if (this.localAvatarIndex >= 0) {
                                            ZplanAVChatViewer zplanAVChatViewer5 = this.filamentViewer;
                                            if (zplanAVChatViewer5 != null) {
                                                zplanAVChatViewer5.stopAnimation(this.localAvatarIndex);
                                            }
                                            if (this.mIsLocalNeedPopTransform) {
                                                ZplanAVChatViewer zplanAVChatViewer6 = this.filamentViewer;
                                                if (zplanAVChatViewer6 != null) {
                                                    int i3 = this.localAvatarIndex;
                                                    List<Float> list = f105874b0;
                                                    zplanAVChatViewer6.setTranslationOffset(i3, -list.get(0).floatValue(), -list.get(1).floatValue(), -list.get(2).floatValue());
                                                }
                                                this.mIsLocalNeedPopTransform = false;
                                            }
                                        }
                                        if (this.remoteAvatarIndex >= 0) {
                                            ZplanAVChatViewer zplanAVChatViewer7 = this.filamentViewer;
                                            if (zplanAVChatViewer7 != null) {
                                                zplanAVChatViewer7.stopAnimation(this.remoteAvatarIndex);
                                            }
                                            if (this.mIsRemoteNeedPopTransform) {
                                                ZplanAVChatViewer zplanAVChatViewer8 = this.filamentViewer;
                                                if (zplanAVChatViewer8 != null) {
                                                    int i16 = this.remoteAvatarIndex;
                                                    List<Float> list2 = f105874b0;
                                                    zplanAVChatViewer8.setTranslationOffset(i16, -list2.get(0).floatValue(), -list2.get(1).floatValue(), -list2.get(2).floatValue());
                                                }
                                                this.mIsRemoteNeedPopTransform = false;
                                            }
                                        }
                                    }
                                    this.mIsPlayingAnimation = false;
                                } else {
                                    FLog.INSTANCE.d("FilamentAVChatRender", "playAnimation " + frameTimeNanos + " is3DMMReady=" + z19);
                                    if (this.mIsLocalTransformInit && (zplanAVChatViewer3 = this.filamentViewer) != null && !this.mIsLocalNeedPopTransform) {
                                        if (zplanAVChatViewer3 != null) {
                                            int i17 = this.localAvatarIndex;
                                            List<Float> list3 = f105874b0;
                                            zplanAVChatViewer3.setTranslationOffset(i17, list3.get(0).floatValue(), list3.get(1).floatValue(), list3.get(2).floatValue());
                                        }
                                        this.mIsLocalNeedPopTransform = true;
                                    }
                                    if (this.mIsRemoteTransformInit && (zplanAVChatViewer2 = this.filamentViewer) != null && !this.mIsRemoteNeedPopTransform) {
                                        if (zplanAVChatViewer2 != null) {
                                            int i18 = this.remoteAvatarIndex;
                                            List<Float> list4 = f105874b0;
                                            zplanAVChatViewer2.setTranslationOffset(i18, list4.get(0).floatValue(), list4.get(1).floatValue(), list4.get(2).floatValue());
                                        }
                                        this.mIsRemoteNeedPopTransform = true;
                                    }
                                    S0(frameTimeNanos);
                                    this.mIsPlayingAnimation = true;
                                }
                                long currentTimeMillis = System.currentTimeMillis();
                                if (this.enableInterpolate) {
                                    Q0 = P0(z28, !z19);
                                } else {
                                    Q0 = Q0(z28);
                                }
                                if (this.isRenderDebug) {
                                    FLog.INSTANCE.d("FilamentAVChatRender", "[onDrawFrame] cost:" + (System.currentTimeMillis() - currentTimeMillis) + "ms");
                                }
                                if (!Q0 && z28) {
                                    return;
                                }
                                if (!z28 && z17 && this.reloadAvatarListener.get(Integer.valueOf(this.localAvatarIndex)) != null) {
                                    TimeUnit timeUnit = TimeUnit.MILLISECONDS;
                                    long j27 = 1000 / this.targetFps;
                                    num = this.reloadAvatarDelayFrame.get(Integer.valueOf(this.localAvatarIndex));
                                    if (num == null) {
                                        j18 = num.intValue();
                                    } else {
                                        j18 = 3;
                                    }
                                    nanos = timeUnit.toNanos(j27 * j18);
                                    FLog fLog = FLog.INSTANCE;
                                    fLog.i("FilamentAVChatRender", "reloadAvatarListener local " + frameTimeNanos + ", " + this.reloadAvatarRenderTime.get(Integer.valueOf(this.localAvatarIndex)) + ", diffTime: " + nanos);
                                    l3 = this.reloadAvatarRenderTime.get(Integer.valueOf(this.localAvatarIndex));
                                    if (l3 == null) {
                                        j19 = l3.longValue();
                                    } else {
                                        j19 = 0;
                                    }
                                    if (frameTimeNanos - j19 > nanos) {
                                        al0.a aVar = new al0.a(0L, 0L, false, 0, null, 31, null);
                                        TimeUnit timeUnit2 = TimeUnit.NANOSECONDS;
                                        Long l16 = this.reloadAvatarRenderTime.get(Integer.valueOf(this.localAvatarIndex));
                                        if (l16 != null) {
                                            j26 = l16.longValue();
                                        } else {
                                            j26 = 0;
                                        }
                                        aVar.l(timeUnit2.toMillis(j26));
                                        aVar.i(timeUnit2.toMillis(frameTimeNanos));
                                        this.startupSteps.put("local_delayFrame", aVar);
                                        fLog.i("FilamentAVChatRender", "reloadAvatarListener?.success(), local delayFrame:" + aVar);
                                        if (this.localAvatarIndex >= 0) {
                                            com.tencent.filament.zplan.a aVar2 = this.reloadAvatarListener.get(Integer.valueOf(this.localAvatarIndex));
                                            if (aVar2 != null) {
                                                aVar2.a(true, this.startupSteps);
                                            }
                                            this.reloadAvatarListener.put(Integer.valueOf(this.localAvatarIndex), null);
                                        }
                                    }
                                }
                                if (!z28 && z18 && this.reloadAvatarListener.get(Integer.valueOf(this.remoteAvatarIndex)) != null) {
                                    TimeUnit timeUnit3 = TimeUnit.MILLISECONDS;
                                    long j28 = 1000 / this.targetFps;
                                    Integer num2 = this.reloadAvatarDelayFrame.get(Integer.valueOf(this.remoteAvatarIndex));
                                    if (num2 != null) {
                                        j3 = num2.intValue();
                                    } else {
                                        j3 = 3;
                                    }
                                    long nanos2 = timeUnit3.toNanos(j28 * j3);
                                    FLog fLog2 = FLog.INSTANCE;
                                    fLog2.i("FilamentAVChatRender", "reloadAvatarListener remote " + frameTimeNanos + ", " + this.reloadAvatarRenderTime.get(Integer.valueOf(this.remoteAvatarIndex)) + ", diffTime: " + nanos2);
                                    Long l17 = this.reloadAvatarRenderTime.get(Integer.valueOf(this.remoteAvatarIndex));
                                    if (l17 != null) {
                                        j16 = l17.longValue();
                                    } else {
                                        j16 = 0;
                                    }
                                    if (frameTimeNanos - j16 > nanos2) {
                                        al0.a aVar3 = new al0.a(0L, 0L, false, 0, null, 31, null);
                                        TimeUnit timeUnit4 = TimeUnit.NANOSECONDS;
                                        Long l18 = this.reloadAvatarRenderTime.get(Integer.valueOf(this.remoteAvatarIndex));
                                        if (l18 != null) {
                                            j17 = l18.longValue();
                                        } else {
                                            j17 = 0;
                                        }
                                        aVar3.l(timeUnit4.toMillis(j17));
                                        aVar3.i(timeUnit4.toMillis(frameTimeNanos));
                                        this.startupSteps.put("remote_delayFrame", aVar3);
                                        fLog2.i("FilamentAVChatRender", "reloadAvatarListener?.success(),remote delayFrame:" + aVar3 + " remoteAvatarIndex=" + this.remoteAvatarIndex + " localAvatarIndex=" + this.localAvatarIndex + " curSmallViewIndex=" + this.curSmallViewIndex);
                                        if (this.remoteAvatarIndex >= 0) {
                                            com.tencent.filament.zplan.a aVar4 = this.reloadAvatarListener.get(Integer.valueOf(this.remoteAvatarIndex));
                                            if (aVar4 != null) {
                                                aVar4.a(false, this.startupSteps);
                                            }
                                            this.reloadAvatarListener.put(Integer.valueOf(this.remoteAvatarIndex), null);
                                            if (this.localAvatarIndex < 0 || this.curSmallViewIndex != this.localAvatarIndex) {
                                                R0(false);
                                                return;
                                            }
                                            return;
                                        }
                                        return;
                                    }
                                    return;
                                }
                                return;
                            }
                        }
                        z18 = false;
                        if (this.localAvatarIndex < 0) {
                        }
                        z19 = false;
                        if (!z19) {
                        }
                        FLog.INSTANCE.d("FilamentAVChatRender", "playAnimation " + frameTimeNanos + " is3DMMReady=" + z19);
                        if (this.mIsLocalTransformInit) {
                            if (zplanAVChatViewer3 != null) {
                            }
                            this.mIsLocalNeedPopTransform = true;
                        }
                        if (this.mIsRemoteTransformInit) {
                            if (zplanAVChatViewer2 != null) {
                            }
                            this.mIsRemoteNeedPopTransform = true;
                        }
                        S0(frameTimeNanos);
                        this.mIsPlayingAnimation = true;
                        long currentTimeMillis2 = System.currentTimeMillis();
                        if (this.enableInterpolate) {
                        }
                        if (this.isRenderDebug) {
                        }
                        if (!Q0) {
                        }
                        if (!z28) {
                            TimeUnit timeUnit5 = TimeUnit.MILLISECONDS;
                            long j272 = 1000 / this.targetFps;
                            num = this.reloadAvatarDelayFrame.get(Integer.valueOf(this.localAvatarIndex));
                            if (num == null) {
                            }
                            nanos = timeUnit5.toNanos(j272 * j18);
                            FLog fLog3 = FLog.INSTANCE;
                            fLog3.i("FilamentAVChatRender", "reloadAvatarListener local " + frameTimeNanos + ", " + this.reloadAvatarRenderTime.get(Integer.valueOf(this.localAvatarIndex)) + ", diffTime: " + nanos);
                            l3 = this.reloadAvatarRenderTime.get(Integer.valueOf(this.localAvatarIndex));
                            if (l3 == null) {
                            }
                            if (frameTimeNanos - j19 > nanos) {
                            }
                        }
                        if (!z28) {
                            return;
                        } else {
                            return;
                        }
                    }
                }
                z17 = false;
                if (this.remoteAvatarIndex >= 0) {
                }
                z18 = false;
                if (this.localAvatarIndex < 0) {
                }
                z19 = false;
                if (!z19) {
                }
                FLog.INSTANCE.d("FilamentAVChatRender", "playAnimation " + frameTimeNanos + " is3DMMReady=" + z19);
                if (this.mIsLocalTransformInit) {
                }
                if (this.mIsRemoteTransformInit) {
                }
                S0(frameTimeNanos);
                this.mIsPlayingAnimation = true;
                long currentTimeMillis22 = System.currentTimeMillis();
                if (this.enableInterpolate) {
                }
                if (this.isRenderDebug) {
                }
                if (!Q0) {
                }
                if (!z28) {
                }
                if (!z28) {
                }
            }
        }
        FLog.INSTANCE.d("FilamentAVChatRender", "onDrawFrame failed filamentViewer=" + this.filamentViewer + " renderSurface=" + this.renderSurface);
    }

    /* JADX WARN: Removed duplicated region for block: B:42:0x02ea A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:46:0x0024 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final boolean P0(boolean needRecord, boolean needRenderImmediately) {
        boolean z16;
        long j3;
        AvatarAIInfo avatarAIInfo;
        long j16;
        Object firstOrNull;
        AvatarAIInfo avatarAIInfo2;
        AVChatAvatarRenderInfo aVChatAvatarRenderInfo;
        Object removeFirst;
        long currentTimeMillis = System.currentTimeMillis();
        if (this.isRenderDebug) {
            FLog.INSTANCE.d("FilamentAVChatRender", "[onInterpolateFrame] start.");
        }
        boolean z17 = false;
        for (Map.Entry<Integer, CopyOnWriteArrayList<AvatarAIInfo>> entry : this.mUinToAIInfoCacheList.entrySet()) {
            int intValue = entry.getKey().intValue();
            CopyOnWriteArrayList<AvatarAIInfo> value = entry.getValue();
            if (value != null && value.size() != 0) {
                AVChatAvatarRenderInfo aVChatAvatarRenderInfo2 = this.mRenderViewInfoMap.get(Integer.valueOf(intValue));
                if (aVChatAvatarRenderInfo2 != null) {
                    j16 = aVChatAvatarRenderInfo2.getFirstRenderTimestamp();
                } else {
                    j16 = 0;
                }
                if (intValue == this.localAvatarIndex && this.localAvatarIndex >= 0 && this.originFps == this.targetFps) {
                    if (this.mUinToAIInfoCacheList.get(Integer.valueOf(this.localAvatarIndex)) != null) {
                        CopyOnWriteArrayList<AvatarAIInfo> copyOnWriteArrayList = this.mUinToAIInfoCacheList.get(Integer.valueOf(this.localAvatarIndex));
                        Intrinsics.checkNotNull(copyOnWriteArrayList);
                        if (copyOnWriteArrayList.size() > 0) {
                            CopyOnWriteArrayList<AvatarAIInfo> copyOnWriteArrayList2 = this.mUinToAIInfoCacheList.get(Integer.valueOf(this.localAvatarIndex));
                            if (copyOnWriteArrayList2 != null) {
                                removeFirst = CollectionsKt__MutableCollectionsKt.removeFirst(copyOnWriteArrayList2);
                                avatarAIInfo2 = (AvatarAIInfo) removeFirst;
                            } else {
                                avatarAIInfo2 = null;
                            }
                            if (avatarAIInfo2 != null) {
                                ZplanAVChatViewer zplanAVChatViewer = this.filamentViewer;
                                if (zplanAVChatViewer != null) {
                                    zplanAVChatViewer.applyAIDataToAvatar(this.localAvatarIndex, avatarAIInfo2, 1.0f, true);
                                }
                                AVChatAvatarRenderInfo aVChatAvatarRenderInfo3 = this.mRenderViewInfoMap.get(Integer.valueOf(intValue));
                                if (aVChatAvatarRenderInfo3 != null) {
                                    aVChatAvatarRenderInfo3.setLastAvatarAIData(avatarAIInfo2);
                                }
                                if (this.isRenderDebug) {
                                    FLog.INSTANCE.d("FilamentAVChatRender", "[onNormalDraw][" + intValue + "] applyAIDataToAvatar id=" + avatarAIInfo2.getFrameId() + " pts=" + avatarAIInfo2.getPts());
                                }
                                if (j16 <= 0 && (aVChatAvatarRenderInfo = this.mRenderViewInfoMap.get(Integer.valueOf(intValue))) != null) {
                                    aVChatAvatarRenderInfo.setFirstRenderTimestamp(currentTimeMillis);
                                }
                                z17 = true;
                            }
                        }
                    }
                    if (this.isRenderDebug) {
                        FLog.INSTANCE.d("FilamentAVChatRender", "[onNormalDraw][" + intValue + "] end.");
                    }
                } else {
                    if (this.isRenderDebug) {
                        FLog.INSTANCE.d("FilamentAVChatRender", "[onInterpolateFrame][" + intValue + "] firstRenderTimestamp=" + j16);
                    }
                    if (j16 <= 0) {
                        if (value.isEmpty()) {
                            FLog.INSTANCE.d("FilamentAVChatRender", "[onInterpolateFrame][" + intValue + "] first render error for empty list.");
                        } else {
                            try {
                                ZplanAVChatViewer zplanAVChatViewer2 = this.filamentViewer;
                                if (zplanAVChatViewer2 != null) {
                                    firstOrNull = CollectionsKt___CollectionsKt.firstOrNull((List<? extends Object>) value);
                                    AvatarAIInfo avatarAIInfo3 = (AvatarAIInfo) firstOrNull;
                                    if (avatarAIInfo3 != null) {
                                        zplanAVChatViewer2.applyAIDataToAvatar(intValue, avatarAIInfo3, 1.0f, true);
                                        avatarAIInfo3.setApplyTimestamp(0L);
                                        AVChatAvatarRenderInfo aVChatAvatarRenderInfo4 = this.mRenderViewInfoMap.get(Integer.valueOf(intValue));
                                        if (aVChatAvatarRenderInfo4 != null) {
                                            aVChatAvatarRenderInfo4.setLastAvatarAIData(avatarAIInfo3);
                                        }
                                        AVChatAvatarRenderInfo aVChatAvatarRenderInfo5 = this.mRenderViewInfoMap.get(Integer.valueOf(intValue));
                                        if (aVChatAvatarRenderInfo5 != null) {
                                            aVChatAvatarRenderInfo5.setFirstRenderTimestamp(currentTimeMillis);
                                        }
                                        FLog.INSTANCE.d("FilamentAVChatRender", "[onInterpolateFrame][" + intValue + "] first frameId=" + avatarAIInfo3.getFrameId() + " cap=" + avatarAIInfo3.getPts() + " ats=" + avatarAIInfo3.getApplyTimestamp() + " fpts=" + currentTimeMillis + " ratio=1.0");
                                        try {
                                            if (!value.isEmpty()) {
                                                CollectionsKt__MutableCollectionsKt.removeFirst(value);
                                            }
                                        } catch (Exception e16) {
                                            FLog.INSTANCE.e("FilamentAVChatRender", "[onInterpolateFrame][" + intValue + "] removeFirst error: " + e16);
                                        }
                                        z17 = true;
                                    }
                                }
                            } catch (Exception e17) {
                                FLog.INSTANCE.e("FilamentAVChatRender", "[onInterpolateFrame][" + intValue + "] error: " + e17);
                            }
                        }
                    } else if (y0(intValue)) {
                        z17 = true;
                    }
                }
            } else {
                AVChatAvatarRenderInfo aVChatAvatarRenderInfo6 = this.mRenderViewInfoMap.get(Integer.valueOf(intValue));
                if (aVChatAvatarRenderInfo6 != null) {
                    j3 = aVChatAvatarRenderInfo6.getLastFrameCacheTimestamp();
                } else {
                    j3 = 0;
                }
                long currentTimeMillis2 = System.currentTimeMillis();
                if (this.isRenderDebug) {
                    FLog.INSTANCE.d("FilamentAVChatRender", "[onInterpolateFrame][" + intValue + "] size=0 return.");
                }
                if (j3 > 0 && currentTimeMillis2 - j3 > 2000 && this.localAvatarIndex < 0 && this.remoteAvatarIndex >= 0) {
                    AVChatAvatarRenderInfo aVChatAvatarRenderInfo7 = this.mRenderViewInfoMap.get(Integer.valueOf(intValue));
                    if (aVChatAvatarRenderInfo7 != null) {
                        avatarAIInfo = aVChatAvatarRenderInfo7.getLastAvatarAIData();
                    } else {
                        avatarAIInfo = null;
                    }
                    if (avatarAIInfo != null) {
                        ZplanAVChatViewer zplanAVChatViewer3 = this.filamentViewer;
                        if (zplanAVChatViewer3 != null) {
                            zplanAVChatViewer3.applyAIDataToAvatar(intValue, avatarAIInfo, 1.0f, true);
                        }
                        ZplanAVChatViewer zplanAVChatViewer4 = this.filamentViewer;
                        if (zplanAVChatViewer4 != null) {
                            zplanAVChatViewer4.render(needRecord);
                        }
                        AVChatAvatarRenderInfo aVChatAvatarRenderInfo8 = this.mRenderViewInfoMap.get(Integer.valueOf(intValue));
                        if (aVChatAvatarRenderInfo8 != null) {
                            aVChatAvatarRenderInfo8.setContinuousCacheEmptyCnt(0);
                            if (!this.isRenderDebug) {
                                FLog.INSTANCE.d("FilamentAVChatRender", "[onInterpolateFrame][" + intValue + "] render for long time no data.");
                            }
                        }
                    }
                    if (!this.isRenderDebug) {
                    }
                }
            }
        }
        boolean J0 = J0();
        if (this.isRenderDebug) {
            FLog.INSTANCE.d("FilamentAVChatRender", "[onInterpolateFrame] needRender=" + z17 + " hasAvatarNeedRender=" + J0 + " needRenderImmediately=" + needRenderImmediately + " filamentViewer=" + this.filamentViewer);
        }
        if (!needRenderImmediately && !z17 && J0) {
            return false;
        }
        ZplanAVChatViewer zplanAVChatViewer5 = this.filamentViewer;
        if (zplanAVChatViewer5 != null) {
            z16 = zplanAVChatViewer5.render(needRecord);
        } else {
            z16 = false;
        }
        if (!z16) {
            return false;
        }
        return true;
    }

    private final boolean Q0(boolean needRecord) {
        long j3;
        AVChatAvatarRenderInfo aVChatAvatarRenderInfo;
        Object removeFirst;
        AvatarAIInfo avatarAIInfo;
        long j16;
        AVChatAvatarRenderInfo aVChatAvatarRenderInfo2;
        Object removeFirst2;
        long currentTimeMillis = System.currentTimeMillis();
        AvatarAIInfo avatarAIInfo2 = null;
        if (this.localAvatarIndex >= 0 && this.mUinToAIInfoCacheList.get(Integer.valueOf(this.localAvatarIndex)) != null) {
            CopyOnWriteArrayList<AvatarAIInfo> copyOnWriteArrayList = this.mUinToAIInfoCacheList.get(Integer.valueOf(this.localAvatarIndex));
            Intrinsics.checkNotNull(copyOnWriteArrayList);
            if (copyOnWriteArrayList.size() > 0) {
                CopyOnWriteArrayList<AvatarAIInfo> copyOnWriteArrayList2 = this.mUinToAIInfoCacheList.get(Integer.valueOf(this.localAvatarIndex));
                if (copyOnWriteArrayList2 != null) {
                    removeFirst2 = CollectionsKt__MutableCollectionsKt.removeFirst(copyOnWriteArrayList2);
                    avatarAIInfo = (AvatarAIInfo) removeFirst2;
                } else {
                    avatarAIInfo = null;
                }
                if (avatarAIInfo != null) {
                    ZplanAVChatViewer zplanAVChatViewer = this.filamentViewer;
                    if (zplanAVChatViewer != null) {
                        zplanAVChatViewer.applyAIDataToAvatar(this.localAvatarIndex, avatarAIInfo, 1.0f, true);
                    }
                    AVChatAvatarRenderInfo aVChatAvatarRenderInfo3 = this.mRenderViewInfoMap.get(Integer.valueOf(this.localAvatarIndex));
                    if (aVChatAvatarRenderInfo3 != null) {
                        aVChatAvatarRenderInfo3.setLastAvatarAIData(avatarAIInfo);
                    }
                }
                AVChatAvatarRenderInfo aVChatAvatarRenderInfo4 = this.mRenderViewInfoMap.get(Integer.valueOf(this.localAvatarIndex));
                if (aVChatAvatarRenderInfo4 != null) {
                    j16 = aVChatAvatarRenderInfo4.getFirstRenderTimestamp();
                } else {
                    j16 = 0;
                }
                if (j16 <= 0 && (aVChatAvatarRenderInfo2 = this.mRenderViewInfoMap.get(Integer.valueOf(this.localAvatarIndex))) != null) {
                    aVChatAvatarRenderInfo2.setFirstRenderTimestamp(currentTimeMillis);
                }
            }
        }
        if (this.remoteAvatarIndex >= 0 && this.mUinToAIInfoCacheList.get(Integer.valueOf(this.remoteAvatarIndex)) != null) {
            CopyOnWriteArrayList<AvatarAIInfo> copyOnWriteArrayList3 = this.mUinToAIInfoCacheList.get(Integer.valueOf(this.remoteAvatarIndex));
            Intrinsics.checkNotNull(copyOnWriteArrayList3);
            if (copyOnWriteArrayList3.size() > 0) {
                CopyOnWriteArrayList<AvatarAIInfo> copyOnWriteArrayList4 = this.mUinToAIInfoCacheList.get(Integer.valueOf(this.remoteAvatarIndex));
                if (copyOnWriteArrayList4 != null) {
                    removeFirst = CollectionsKt__MutableCollectionsKt.removeFirst(copyOnWriteArrayList4);
                    avatarAIInfo2 = (AvatarAIInfo) removeFirst;
                }
                if (avatarAIInfo2 != null) {
                    ZplanAVChatViewer zplanAVChatViewer2 = this.filamentViewer;
                    if (zplanAVChatViewer2 != null) {
                        zplanAVChatViewer2.applyAIDataToAvatar(this.remoteAvatarIndex, avatarAIInfo2, 1.0f, true);
                    }
                    AVChatAvatarRenderInfo aVChatAvatarRenderInfo5 = this.mRenderViewInfoMap.get(Integer.valueOf(this.remoteAvatarIndex));
                    if (aVChatAvatarRenderInfo5 != null) {
                        aVChatAvatarRenderInfo5.setLastAvatarAIData(avatarAIInfo2);
                    }
                }
                AVChatAvatarRenderInfo aVChatAvatarRenderInfo6 = this.mRenderViewInfoMap.get(Integer.valueOf(this.remoteAvatarIndex));
                if (aVChatAvatarRenderInfo6 != null) {
                    j3 = aVChatAvatarRenderInfo6.getFirstRenderTimestamp();
                } else {
                    j3 = 0;
                }
                if (j3 <= 0 && (aVChatAvatarRenderInfo = this.mRenderViewInfoMap.get(Integer.valueOf(this.remoteAvatarIndex))) != null) {
                    aVChatAvatarRenderInfo.setFirstRenderTimestamp(currentTimeMillis);
                }
            }
        }
        ZplanAVChatViewer zplanAVChatViewer3 = this.filamentViewer;
        if (zplanAVChatViewer3 != null) {
            return zplanAVChatViewer3.render(needRecord);
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void R0(boolean isLocal) {
        if (isLocal) {
            ZplanAVChatViewer zplanAVChatViewer = this.filamentViewer;
            if (zplanAVChatViewer != null) {
                zplanAVChatViewer.updateViewport(this.localAvatarIndex, 0, 0, this.surfaceWidth, this.surfaceHeight);
            }
            ZplanAVChatViewer zplanAVChatViewer2 = this.filamentViewer;
            if (zplanAVChatViewer2 != null) {
                zplanAVChatViewer2.updateViewport(this.remoteAvatarIndex, this.smallViewLeftMargin, this.smallViewBottomMargin, this.smallViewWidth, this.smallViewHeight);
            }
            ZplanAVChatViewer zplanAVChatViewer3 = this.filamentViewer;
            if (zplanAVChatViewer3 != null) {
                zplanAVChatViewer3.setAvatarViewZoder(this.localAvatarIndex, 0);
            }
            ZplanAVChatViewer zplanAVChatViewer4 = this.filamentViewer;
            if (zplanAVChatViewer4 != null) {
                zplanAVChatViewer4.setAvatarViewZoder(this.remoteAvatarIndex, 1);
            }
            this.curSmallViewIndex = this.remoteAvatarIndex;
            return;
        }
        ZplanAVChatViewer zplanAVChatViewer5 = this.filamentViewer;
        if (zplanAVChatViewer5 != null) {
            zplanAVChatViewer5.updateViewport(this.remoteAvatarIndex, 0, 0, this.surfaceWidth, this.surfaceHeight);
        }
        ZplanAVChatViewer zplanAVChatViewer6 = this.filamentViewer;
        if (zplanAVChatViewer6 != null) {
            zplanAVChatViewer6.updateViewport(this.localAvatarIndex, this.smallViewLeftMargin, this.smallViewBottomMargin, this.smallViewWidth, this.smallViewHeight);
        }
        ZplanAVChatViewer zplanAVChatViewer7 = this.filamentViewer;
        if (zplanAVChatViewer7 != null) {
            zplanAVChatViewer7.setAvatarViewZoder(this.localAvatarIndex, 1);
        }
        ZplanAVChatViewer zplanAVChatViewer8 = this.filamentViewer;
        if (zplanAVChatViewer8 != null) {
            zplanAVChatViewer8.setAvatarViewZoder(this.remoteAvatarIndex, 0);
        }
        this.curSmallViewIndex = this.localAvatarIndex;
    }

    private final void S0(long frameTimeNanos) {
        HashMap<Integer, FilamentAnimation[]> hashMap;
        ZplanAVChatViewer zplanAVChatViewer;
        ZplanAVChatViewer zplanAVChatViewer2;
        ZplanAVChatViewer zplanAVChatViewer3;
        ZplanAVChatViewer zplanAVChatViewer4;
        com.tencent.filament.zplan.b bVar = this.animationListener;
        if (bVar != null) {
            Triple<Integer, Double, Boolean> a16 = bVar.a(frameTimeNanos);
            int intValue = a16.component1().intValue();
            double doubleValue = a16.component2().doubleValue();
            boolean booleanValue = a16.component3().booleanValue();
            if (this.isFemale) {
                hashMap = this.femaleAnimation;
            } else {
                hashMap = this.maleAnimationMap;
            }
            FilamentAnimation[] filamentAnimationArr = hashMap.get(Integer.valueOf(intValue));
            if (filamentAnimationArr != null) {
                for (FilamentAnimation filamentAnimation : filamentAnimationArr) {
                    if (booleanValue) {
                        String path = filamentAnimation.getPath();
                        if (path != null) {
                            if (this.localAvatarIndex >= 0 && (zplanAVChatViewer4 = this.filamentViewer) != null) {
                                zplanAVChatViewer4.playAnimation(this.localAvatarIndex, path, doubleValue);
                            }
                            if (this.remoteAvatarIndex >= 0 && (zplanAVChatViewer3 = this.filamentViewer) != null) {
                                zplanAVChatViewer3.playAnimation(this.remoteAvatarIndex, path, doubleValue);
                            }
                        }
                    } else {
                        String path2 = filamentAnimation.getPath();
                        if (path2 != null) {
                            if (this.localAvatarIndex >= 0 && (zplanAVChatViewer2 = this.filamentViewer) != null) {
                                zplanAVChatViewer2.playAnimation(this.localAvatarIndex, path2, filamentAnimation.getDuration() * doubleValue);
                            }
                            if (this.remoteAvatarIndex >= 0 && (zplanAVChatViewer = this.filamentViewer) != null) {
                                zplanAVChatViewer.playAnimation(this.remoteAvatarIndex, path2, filamentAnimation.getDuration() * doubleValue);
                            }
                        }
                    }
                }
            }
        }
    }

    private final void x0(Runnable task) {
        synchronized (this.viewerWaitList) {
            this.viewerWaitList.add(task);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:50:0x031e  */
    /* JADX WARN: Removed duplicated region for block: B:53:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final boolean y0(int viewIndex) {
        long j3;
        AvatarAIInfo avatarAIInfo;
        String str;
        Object firstOrNull;
        AvatarAIInfo avatarAIInfo2;
        long j16;
        AvatarAIInfo avatarAIInfo3;
        String str2;
        AvatarAIInfo lastAvatarAIData;
        AvatarAIInfo avatarAIInfo4;
        CopyOnWriteArrayList<AvatarAIInfo> copyOnWriteArrayList = this.mUinToAIInfoCacheList.get(Integer.valueOf(viewIndex));
        if (copyOnWriteArrayList != null) {
            Intrinsics.checkNotNullExpressionValue(copyOnWriteArrayList, "mUinToAIInfoCacheList[viewIndex] ?: return false");
            AVChatAvatarRenderInfo aVChatAvatarRenderInfo = this.mRenderViewInfoMap.get(Integer.valueOf(viewIndex));
            if (aVChatAvatarRenderInfo != null) {
                j3 = aVChatAvatarRenderInfo.getFirstRenderTimestamp();
            } else {
                j3 = 0;
            }
            long currentTimeMillis = System.currentTimeMillis() - j3;
            if (this.isRenderDebug) {
                FLog.INSTANCE.d("FilamentAVChatRender", "[checkApplyAIData][" + viewIndex + "] size=" + Integer.valueOf(copyOnWriteArrayList.size()).intValue() + " cts=" + currentTimeMillis);
            }
            Iterator<AvatarAIInfo> it = copyOnWriteArrayList.iterator();
            while (it.hasNext()) {
                AvatarAIInfo next = it.next();
                if (currentTimeMillis >= next.getPts()) {
                    AVChatAvatarRenderInfo aVChatAvatarRenderInfo2 = this.mRenderViewInfoMap.get(Integer.valueOf(viewIndex));
                    if (aVChatAvatarRenderInfo2 != null) {
                        aVChatAvatarRenderInfo2.setLastAvatarAIData(next);
                    }
                    if (this.isRenderDebug) {
                        FLog.INSTANCE.d("FilamentAVChatRender", "[checkApplyAIData][" + viewIndex + "] skip id=" + next.getFrameId() + " cap=" + next.getPts() + " rt=" + currentTimeMillis);
                    }
                    copyOnWriteArrayList.remove(next);
                }
            }
            if (copyOnWriteArrayList.isEmpty()) {
                AVChatAvatarRenderInfo aVChatAvatarRenderInfo3 = this.mRenderViewInfoMap.get(Integer.valueOf(viewIndex));
                if (aVChatAvatarRenderInfo3 != null) {
                    avatarAIInfo4 = aVChatAvatarRenderInfo3.getLastAvatarAIData();
                } else {
                    avatarAIInfo4 = null;
                }
                ZplanAVChatViewer zplanAVChatViewer = this.filamentViewer;
                if (zplanAVChatViewer != null && avatarAIInfo4 != null) {
                    Intrinsics.checkNotNull(zplanAVChatViewer);
                    zplanAVChatViewer.applyAIDataToAvatar(viewIndex, avatarAIInfo4, 1.0f, true);
                    avatarAIInfo4.setApplyTimestamp(currentTimeMillis);
                    if (this.isRenderDebug) {
                        FLog.INSTANCE.d("FilamentAVChatRender", "[onInterpolateFrame][" + viewIndex + "] last origin, id=" + avatarAIInfo4.getFrameId() + " cap=" + avatarAIInfo4.getPts() + " rt=" + currentTimeMillis + " ratio=1.0");
                    }
                }
                AVChatAvatarRenderInfo aVChatAvatarRenderInfo4 = this.mRenderViewInfoMap.get(Integer.valueOf(viewIndex));
                if (aVChatAvatarRenderInfo4 != null) {
                    aVChatAvatarRenderInfo4.setContinuousCacheEmptyCnt(aVChatAvatarRenderInfo4.getContinuousCacheEmptyCnt() + 1);
                    if (aVChatAvatarRenderInfo4.getContinuousCacheEmptyCnt() > 5) {
                        aVChatAvatarRenderInfo4.reset();
                        if (aVChatAvatarRenderInfo4.getCurDelayRenderMs() <= 0) {
                            aVChatAvatarRenderInfo4.setCurDelayRenderMs(this.delayRenderMs);
                        }
                        if (this.isRenderDebug) {
                            FLog.INSTANCE.d("FilamentAVChatRender", "[onInterpolateFrame][" + viewIndex + "] reset, curDelay=" + aVChatAvatarRenderInfo4.getCurDelayRenderMs());
                        }
                    }
                }
            } else {
                AVChatAvatarRenderInfo aVChatAvatarRenderInfo5 = this.mRenderViewInfoMap.get(Integer.valueOf(viewIndex));
                if (aVChatAvatarRenderInfo5 != null) {
                    avatarAIInfo = aVChatAvatarRenderInfo5.getLastAvatarAIData();
                } else {
                    avatarAIInfo = null;
                }
                if (avatarAIInfo != null) {
                    try {
                        firstOrNull = CollectionsKt___CollectionsKt.firstOrNull((List<? extends Object>) copyOnWriteArrayList);
                        avatarAIInfo2 = (AvatarAIInfo) firstOrNull;
                    } catch (Exception e16) {
                        e = e16;
                        str = "FilamentAVChatRender";
                    }
                    if (avatarAIInfo2 != null) {
                        AVChatAvatarRenderInfo aVChatAvatarRenderInfo6 = this.mRenderViewInfoMap.get(Integer.valueOf(viewIndex));
                        if (aVChatAvatarRenderInfo6 != null && (lastAvatarAIData = aVChatAvatarRenderInfo6.getLastAvatarAIData()) != null) {
                            j16 = lastAvatarAIData.getPts();
                        } else {
                            j16 = 0;
                        }
                        if (currentTimeMillis < j16) {
                            FLog.INSTANCE.e("FilamentAVChatRender", "[onInterpolateFrame][" + viewIndex + "] early: curRenderTimeOffset=" + currentTimeMillis + " lastPopFrameTimestamp=" + j16);
                            return false;
                        }
                        float min = Math.min(Math.max(((float) (currentTimeMillis - j16)) / ((float) (Long.valueOf(avatarAIInfo2.getPts()).longValue() - j16)), 0.0f), 1.0f);
                        if (this.isRenderDebug) {
                            FLog.INSTANCE.d("FilamentAVChatRender", "[checkApplyAIData][" + viewIndex + "] lastPopFrameTimestamp=" + j16 + " ratio=" + min);
                        }
                        if (this.filamentViewer != null) {
                            AVChatAvatarRenderInfo aVChatAvatarRenderInfo7 = this.mRenderViewInfoMap.get(Integer.valueOf(viewIndex));
                            if (aVChatAvatarRenderInfo7 != null) {
                                avatarAIInfo3 = aVChatAvatarRenderInfo7.getLastAvatarAIData();
                            } else {
                                avatarAIInfo3 = null;
                            }
                            if (avatarAIInfo3 == null || avatarAIInfo3.getApplyTimestamp() >= 0) {
                                str2 = "FilamentAVChatRender";
                            } else {
                                ZplanAVChatViewer zplanAVChatViewer2 = this.filamentViewer;
                                if (zplanAVChatViewer2 != null) {
                                    str2 = "FilamentAVChatRender";
                                    try {
                                        zplanAVChatViewer2.applyAIDataToAvatar(viewIndex, avatarAIInfo3, 1.0f, true);
                                    } catch (Exception e17) {
                                        e = e17;
                                        str = str2;
                                        FLog.INSTANCE.e(str, "[onInterpolateFrame][" + viewIndex + "] error: " + e + '.');
                                        if (!this.isRenderDebug) {
                                        }
                                    }
                                } else {
                                    str2 = "FilamentAVChatRender";
                                }
                                avatarAIInfo3.setApplyTimestamp(currentTimeMillis);
                            }
                            ZplanAVChatViewer zplanAVChatViewer3 = this.filamentViewer;
                            if (zplanAVChatViewer3 != null) {
                                zplanAVChatViewer3.applyAIDataToAvatar(viewIndex, avatarAIInfo2, min, false);
                            }
                            avatarAIInfo2.setApplyTimestamp(currentTimeMillis);
                            if (this.isRenderDebug) {
                                str = str2;
                                try {
                                    FLog.INSTANCE.d(str, "[onInterpolateFrame][" + viewIndex + "] interpolate id=" + avatarAIInfo2.getFrameId() + " lastCap=" + j16 + " cap=" + avatarAIInfo2.getPts() + " rt=" + currentTimeMillis + " ratio=" + min);
                                } catch (Exception e18) {
                                    e = e18;
                                    FLog.INSTANCE.e(str, "[onInterpolateFrame][" + viewIndex + "] error: " + e + '.');
                                    if (!this.isRenderDebug) {
                                    }
                                }
                            } else {
                                str = str2;
                            }
                            if (!this.isRenderDebug) {
                                FLog.INSTANCE.d(str, "[onInterpolateFrame][" + viewIndex + "] end.");
                                return true;
                            }
                            return true;
                        }
                    } else {
                        return false;
                    }
                } else {
                    FLog.INSTANCE.e("FilamentAVChatRender", "[onInterpolateFrame][" + viewIndex + "] error: last aidata is null.");
                    return false;
                }
            }
            str = "FilamentAVChatRender";
            if (!this.isRenderDebug) {
            }
        } else {
            return false;
        }
    }

    @Override // com.tencent.filament.zplan.f
    public void B(final int width, final int height, final int left, final int bottom) {
        this.smallViewWidth = width;
        this.smallViewHeight = height;
        this.smallViewLeftMargin = left;
        this.smallViewBottomMargin = bottom;
        B0("switchToBigView", new Function0<Unit>() { // from class: com.tencent.filament.zplan.render.impl.ZplanAVChatRender$updateSmallViewLayoutParams$1
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

            /* JADX WARN: Code restructure failed: missing block: B:3:0x0008, code lost:
            
                r1 = r7.this$0.filamentViewer;
             */
            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public final void invoke2() {
                int i3;
                ZplanAVChatViewer zplanAVChatViewer;
                int i16;
                i3 = ZplanAVChatRender.this.curSmallViewIndex;
                if (i3 < 0 || zplanAVChatViewer == null) {
                    return;
                }
                i16 = ZplanAVChatRender.this.curSmallViewIndex;
                zplanAVChatViewer.updateViewport(i16, left, bottom, width, height);
            }
        });
    }

    public final void B0(@NotNull final String from, @NotNull final Function0<Unit> task) {
        Intrinsics.checkNotNullParameter(from, "from");
        Intrinsics.checkNotNullParameter(task, "task");
        if (this.destroy.get()) {
            return;
        }
        if (this.filamentViewer != null) {
            ReentrantLock reentrantLock = this.viewerHandlerLock;
            reentrantLock.lock();
            try {
                Handler handler = this.viewerHandler;
                if (handler != null) {
                    handler.post(new Runnable() { // from class: com.tencent.filament.zplan.render.impl.ZplanAVChatRender$doOnViewerThread$$inlined$withLock$lambda$1
                        @Override // java.lang.Runnable
                        public final void run() {
                            ZplanAVChatRender.this.D0();
                            ZplanAVChatRender.this.C0(from, task);
                        }
                    });
                }
                return;
            } finally {
                reentrantLock.unlock();
            }
        }
        x0(new Runnable() { // from class: com.tencent.filament.zplan.render.impl.ZplanAVChatRender$doOnViewerThread$2
            @Override // java.lang.Runnable
            public final void run() {
                ZplanAVChatRender.this.C0(from, task);
            }
        });
    }

    @Override // com.tencent.filament.zplan.f
    public void C(@NotNull final String path) {
        Intrinsics.checkNotNullParameter(path, "path");
        B0("update3DMMPath", new Function0<Unit>() { // from class: com.tencent.filament.zplan.render.impl.ZplanAVChatRender$update3DMMPath$1
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

            /* JADX WARN: Code restructure failed: missing block: B:12:0x003c, code lost:
            
                if (r0.check3DMMReady(r3) == true) goto L14;
             */
            /* JADX WARN: Code restructure failed: missing block: B:13:0x003e, code lost:
            
                r1 = true;
             */
            /* JADX WARN: Code restructure failed: missing block: B:22:0x0048, code lost:
            
                r0 = r4.this$0.filamentViewer;
             */
            /* JADX WARN: Code restructure failed: missing block: B:25:0x005a, code lost:
            
                if (r0.check3DMMReady(r3) == true) goto L14;
             */
            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public final void invoke2() {
                ZplanAVChatViewer zplanAVChatViewer;
                ZplanAVChatViewer zplanAVChatViewer2;
                int i3;
                int i16;
                ZplanAVChatViewer zplanAVChatViewer3;
                int i17;
                uk0.b bVar;
                ZplanAVChatViewer zplanAVChatViewer4;
                int i18;
                zplanAVChatViewer = ZplanAVChatRender.this.filamentViewer;
                if (zplanAVChatViewer == null) {
                    FLog.INSTANCE.e("FilamentAVChatRender", "update3DMMPath for view is null.");
                }
                zplanAVChatViewer2 = ZplanAVChatRender.this.filamentViewer;
                if (zplanAVChatViewer2 != null) {
                    zplanAVChatViewer2.update3DMMPath(path);
                }
                i3 = ZplanAVChatRender.this.localAvatarIndex;
                boolean z16 = false;
                if (i3 >= 0) {
                    zplanAVChatViewer4 = ZplanAVChatRender.this.filamentViewer;
                    if (zplanAVChatViewer4 != null) {
                        i18 = ZplanAVChatRender.this.localAvatarIndex;
                    }
                } else {
                    i16 = ZplanAVChatRender.this.remoteAvatarIndex;
                    if (i16 >= 0 && zplanAVChatViewer3 != null) {
                        i17 = ZplanAVChatRender.this.remoteAvatarIndex;
                    }
                }
                bVar = ZplanAVChatRender.this.renderEventsCallback;
                if (bVar != null) {
                    bVar.a(z16, AVChatRenderEventsType.EVENT_UPDATE_3DMM_PATH);
                }
            }
        });
    }

    @Override // com.tencent.filament.zplan.f
    public void D(@NotNull final AVFilamentTextureView filamentTextureView) {
        Intrinsics.checkNotNullParameter(filamentTextureView, "filamentTextureView");
        this.filamentView = filamentTextureView;
        Context context = filamentTextureView.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "filamentTextureView.context");
        z(context, Boolean.FALSE);
        this.surfaceWidth = filamentTextureView.getWidth();
        this.surfaceHeight = filamentTextureView.getHeight();
        B0("onSurfaceCreate", new Function0<Unit>() { // from class: com.tencent.filament.zplan.render.impl.ZplanAVChatRender$initTextureView$1
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

            /* JADX WARN: Code restructure failed: missing block: B:3:0x0008, code lost:
            
                r1 = r2.this$0.filamentViewer;
             */
            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public final void invoke2() {
                ZplanAVChatViewer zplanAVChatViewer;
                Surface curSurface = filamentTextureView.getCurSurface();
                if (curSurface != null && zplanAVChatViewer != null) {
                    zplanAVChatViewer.createSwapChain(curSurface);
                }
                ZplanAVChatRender.this.renderSurface = filamentTextureView.getCurSurface();
            }
        });
    }

    @Override // com.tencent.filament.zplan.f
    public void E(boolean isLocal, @NotNull AvatarAIInfo avatarAIInfo) {
        CopyOnWriteArrayList<AvatarAIInfo> copyOnWriteArrayList;
        Object removeFirst;
        CopyOnWriteArrayList<AvatarAIInfo> copyOnWriteArrayList2;
        Object removeFirst2;
        Intrinsics.checkNotNullParameter(avatarAIInfo, "avatarAIInfo");
        int i3 = isLocal ? this.localAvatarIndex : this.remoteAvatarIndex;
        if (i3 >= 0 && !(!Intrinsics.areEqual(this.hasReloadAvatar.get(Integer.valueOf(i3)), Boolean.TRUE))) {
            if ((isLocal && this.originFps == this.targetFps) || !this.enableInterpolate) {
                if (this.mUinToAIInfoCacheList.get(Integer.valueOf(i3)) == null) {
                    this.mUinToAIInfoCacheList.put(Integer.valueOf(i3), new CopyOnWriteArrayList<>());
                }
                CopyOnWriteArrayList<AvatarAIInfo> copyOnWriteArrayList3 = this.mUinToAIInfoCacheList.get(Integer.valueOf(i3));
                if ((copyOnWriteArrayList3 != null ? copyOnWriteArrayList3.size() : 0) > 5 && (copyOnWriteArrayList2 = this.mUinToAIInfoCacheList.get(Integer.valueOf(i3))) != null) {
                    removeFirst2 = CollectionsKt__MutableCollectionsKt.removeFirst(copyOnWriteArrayList2);
                }
                avatarAIInfo.setOriginPts(avatarAIInfo.getPts());
                CopyOnWriteArrayList<AvatarAIInfo> copyOnWriteArrayList4 = this.mUinToAIInfoCacheList.get(Integer.valueOf(i3));
                if (copyOnWriteArrayList4 != null) {
                    copyOnWriteArrayList4.add(avatarAIInfo);
                }
                if (this.mRenderViewInfoMap.get(Integer.valueOf(i3)) == null) {
                    this.mRenderViewInfoMap.put(Integer.valueOf(i3), new AVChatAvatarRenderInfo(avatarAIInfo.getPts(), 0L, null));
                }
                if (this.isRenderDebug) {
                    FLog.INSTANCE.d("FilamentAVChatRender", "applyAIDataToAvatar[" + i3 + "] normal id=" + avatarAIInfo.getFrameId() + " pts=" + avatarAIInfo.getPts());
                    return;
                }
                return;
            }
            long currentTimeMillis = System.currentTimeMillis();
            if (this.mRenderViewInfoMap.get(Integer.valueOf(i3)) == null) {
                this.mRenderViewInfoMap.put(Integer.valueOf(i3), new AVChatAvatarRenderInfo(avatarAIInfo.getPts(), 0L, null));
                AVChatAvatarRenderInfo aVChatAvatarRenderInfo = this.mRenderViewInfoMap.get(Integer.valueOf(i3));
                if (aVChatAvatarRenderInfo != null) {
                    aVChatAvatarRenderInfo.setCurDelayRenderMs(this.delayRenderMs);
                }
                AVChatAvatarRenderInfo aVChatAvatarRenderInfo2 = this.mRenderViewInfoMap.get(Integer.valueOf(i3));
                if (aVChatAvatarRenderInfo2 != null) {
                    aVChatAvatarRenderInfo2.setLastFrameCacheTimestamp(currentTimeMillis);
                }
                FLog.INSTANCE.d("FilamentAVChatRender", "applyAIDataToAvatar[" + i3 + "] first frame pts=" + avatarAIInfo.getPts());
            } else {
                AVChatAvatarRenderInfo aVChatAvatarRenderInfo3 = this.mRenderViewInfoMap.get(Integer.valueOf(i3));
                Intrinsics.checkNotNull(aVChatAvatarRenderInfo3);
                if (aVChatAvatarRenderInfo3.getFirstRenderTimestamp() == 0 && this.mUinToAIInfoCacheList.get(Integer.valueOf(i3)) != null) {
                    CopyOnWriteArrayList<AvatarAIInfo> copyOnWriteArrayList5 = this.mUinToAIInfoCacheList.get(Integer.valueOf(i3));
                    if (copyOnWriteArrayList5 != null) {
                        copyOnWriteArrayList5.clear();
                    }
                    AVChatAvatarRenderInfo aVChatAvatarRenderInfo4 = this.mRenderViewInfoMap.get(Integer.valueOf(i3));
                    if (aVChatAvatarRenderInfo4 != null) {
                        aVChatAvatarRenderInfo4.reset();
                    }
                    AVChatAvatarRenderInfo aVChatAvatarRenderInfo5 = this.mRenderViewInfoMap.get(Integer.valueOf(i3));
                    if (aVChatAvatarRenderInfo5 != null && aVChatAvatarRenderInfo5.getCurDelayRenderMs() <= 0) {
                        aVChatAvatarRenderInfo5.setCurDelayRenderMs(this.delayRenderMs);
                    }
                    if (this.isRenderDebug) {
                        FLog.INSTANCE.d("FilamentAVChatRender", "applyAIDataToAvatar[" + i3 + "] reset before render.");
                    }
                }
                if (this.mUinToAIInfoCacheList.get(Integer.valueOf(i3)) != null) {
                    CopyOnWriteArrayList<AvatarAIInfo> copyOnWriteArrayList6 = this.mUinToAIInfoCacheList.get(Integer.valueOf(i3));
                    int size = copyOnWriteArrayList6 != null ? copyOnWriteArrayList6.size() : 0;
                    if (size > 2) {
                        CopyOnWriteArrayList<AvatarAIInfo> copyOnWriteArrayList7 = this.mUinToAIInfoCacheList.get(Integer.valueOf(i3));
                        if (copyOnWriteArrayList7 != null) {
                            copyOnWriteArrayList7.clear();
                        }
                        AVChatAvatarRenderInfo aVChatAvatarRenderInfo6 = this.mRenderViewInfoMap.get(Integer.valueOf(i3));
                        if (aVChatAvatarRenderInfo6 != null) {
                            aVChatAvatarRenderInfo6.reset();
                        }
                        AVChatAvatarRenderInfo aVChatAvatarRenderInfo7 = this.mRenderViewInfoMap.get(Integer.valueOf(i3));
                        if (aVChatAvatarRenderInfo7 != null && aVChatAvatarRenderInfo7.getCurDelayRenderMs() <= 0) {
                            aVChatAvatarRenderInfo7.setCurDelayRenderMs(this.delayRenderMs);
                        }
                        FLog.INSTANCE.d("FilamentAVChatRender", "applyAIDataToAvatar[" + i3 + "] size=" + size + " too long to clear.");
                    }
                }
                AVChatAvatarRenderInfo aVChatAvatarRenderInfo8 = this.mRenderViewInfoMap.get(Integer.valueOf(i3));
                Intrinsics.checkNotNull(aVChatAvatarRenderInfo8);
                if (aVChatAvatarRenderInfo8.getFirstFrameTimestamp() == 0) {
                    AVChatAvatarRenderInfo aVChatAvatarRenderInfo9 = this.mRenderViewInfoMap.get(Integer.valueOf(i3));
                    Intrinsics.checkNotNull(aVChatAvatarRenderInfo9);
                    aVChatAvatarRenderInfo9.setFirstFrameTimestamp(avatarAIInfo.getPts());
                    AVChatAvatarRenderInfo aVChatAvatarRenderInfo10 = this.mRenderViewInfoMap.get(Integer.valueOf(i3));
                    if (aVChatAvatarRenderInfo10 != null) {
                        aVChatAvatarRenderInfo10.setLastFrameCacheTimestamp(currentTimeMillis);
                    }
                }
            }
            if (this.mUinToAIInfoCacheList.get(Integer.valueOf(i3)) == null) {
                this.mUinToAIInfoCacheList.put(Integer.valueOf(i3), new CopyOnWriteArrayList<>());
            }
            CopyOnWriteArrayList<AvatarAIInfo> copyOnWriteArrayList8 = this.mUinToAIInfoCacheList.get(Integer.valueOf(i3));
            if ((copyOnWriteArrayList8 != null ? copyOnWriteArrayList8.size() : 0) > 5 && (copyOnWriteArrayList = this.mUinToAIInfoCacheList.get(Integer.valueOf(i3))) != null) {
                removeFirst = CollectionsKt__MutableCollectionsKt.removeFirst(copyOnWriteArrayList);
            }
            AVChatAvatarRenderInfo aVChatAvatarRenderInfo11 = this.mRenderViewInfoMap.get(Integer.valueOf(i3));
            Intrinsics.checkNotNull(aVChatAvatarRenderInfo11);
            long lastFrameCacheTimestamp = currentTimeMillis - aVChatAvatarRenderInfo11.getLastFrameCacheTimestamp();
            AVChatAvatarRenderInfo aVChatAvatarRenderInfo12 = this.mRenderViewInfoMap.get(Integer.valueOf(i3));
            if (lastFrameCacheTimestamp <= (aVChatAvatarRenderInfo12 != null ? aVChatAvatarRenderInfo12.getLastCacheEndSmoothDelay() : 0L)) {
                lastFrameCacheTimestamp = (long) ((((float) r10) * 0.7d) + (((float) lastFrameCacheTimestamp) * 0.3d));
            }
            long max = Math.max(lastFrameCacheTimestamp, this.delayRenderMs);
            AVChatAvatarRenderInfo aVChatAvatarRenderInfo13 = this.mRenderViewInfoMap.get(Integer.valueOf(i3));
            if (aVChatAvatarRenderInfo13 != null) {
                aVChatAvatarRenderInfo13.setLastCacheEndSmoothDelay(max);
            }
            avatarAIInfo.setOriginPts(avatarAIInfo.getPts());
            long pts = avatarAIInfo.getPts();
            AVChatAvatarRenderInfo aVChatAvatarRenderInfo14 = this.mRenderViewInfoMap.get(Integer.valueOf(i3));
            Intrinsics.checkNotNull(aVChatAvatarRenderInfo14);
            long firstFrameTimestamp = pts - aVChatAvatarRenderInfo14.getFirstFrameTimestamp();
            AVChatAvatarRenderInfo aVChatAvatarRenderInfo15 = this.mRenderViewInfoMap.get(Integer.valueOf(i3));
            Intrinsics.checkNotNull(aVChatAvatarRenderInfo15);
            avatarAIInfo.setPts(firstFrameTimestamp + aVChatAvatarRenderInfo15.getCurDelayRenderMs());
            avatarAIInfo.setApplyTimestamp(-1L);
            AVChatAvatarRenderInfo aVChatAvatarRenderInfo16 = this.mRenderViewInfoMap.get(Integer.valueOf(i3));
            if (aVChatAvatarRenderInfo16 != null) {
                aVChatAvatarRenderInfo16.setLastFrameCacheTimestamp(currentTimeMillis);
            }
            CopyOnWriteArrayList<AvatarAIInfo> copyOnWriteArrayList9 = this.mUinToAIInfoCacheList.get(Integer.valueOf(i3));
            if (copyOnWriteArrayList9 != null) {
                copyOnWriteArrayList9.add(avatarAIInfo);
            }
            if (this.isRenderDebug) {
                FLog fLog = FLog.INSTANCE;
                StringBuilder sb5 = new StringBuilder();
                sb5.append("applyAIDataToAvatar[");
                sb5.append(i3);
                sb5.append("] enqueue pts_offset=");
                sb5.append(avatarAIInfo.getPts());
                sb5.append(" size=");
                CopyOnWriteArrayList<AvatarAIInfo> copyOnWriteArrayList10 = this.mUinToAIInfoCacheList.get(Integer.valueOf(i3));
                sb5.append(copyOnWriteArrayList10 != null ? Integer.valueOf(copyOnWriteArrayList10.size()) : null);
                sb5.append(" id=");
                sb5.append(avatarAIInfo.getFrameId());
                fLog.d("FilamentAVChatRender", sb5.toString());
                return;
            }
            return;
        }
        FLog.INSTANCE.d("FilamentAVChatRender", "applyAIDataToAvatar[" + i3 + "] failed. " + this.hasReloadAvatar.get(Integer.valueOf(i3)));
    }

    @NotNull
    /* renamed from: F0, reason: from getter */
    public final String getAiBundlePath() {
        return this.aiBundlePath;
    }

    @NotNull
    /* renamed from: G0, reason: from getter */
    public final String getBodyResJsonPath() {
        return this.bodyResJsonPath;
    }

    @NotNull
    /* renamed from: H0, reason: from getter */
    public final String getFilamatPath() {
        return this.filamatPath;
    }

    /* renamed from: I0, reason: from getter */
    public final int getRenderMaxTargetWidth() {
        return this.renderMaxTargetWidth;
    }

    /* renamed from: N0, reason: from getter */
    public final boolean getIsRenderDebug() {
        return this.isRenderDebug;
    }

    @Override // com.tencent.filament.zplan.f
    public void b(final boolean isLocal, final boolean isMale, @Nullable final com.tencent.filament.zplan.a listener, final int delayFrame) {
        B0("reloadAvatar", new Function0<Unit>() { // from class: com.tencent.filament.zplan.render.impl.ZplanAVChatRender$reloadAvatar$1
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
                ConcurrentHashMap concurrentHashMap;
                Map map;
                ZplanAVChatViewer zplanAVChatViewer;
                ZplanAVChatViewer zplanAVChatViewer2;
                uk0.b bVar;
                ZplanAVChatViewer zplanAVChatViewer3;
                List list;
                List list2;
                List list3;
                Map map2;
                FLog fLog = FLog.INSTANCE;
                fLog.i("FilamentAVChatRender", "reloadAvatar start");
                int i3 = isLocal ? ZplanAVChatRender.this.localAvatarIndex : ZplanAVChatRender.this.remoteAvatarIndex;
                if (i3 < 0) {
                    return;
                }
                concurrentHashMap = ZplanAVChatRender.this.hasReloadAvatar;
                concurrentHashMap.put(Integer.valueOf(i3), Boolean.FALSE);
                com.tencent.filament.zplan.a aVar = listener;
                if (aVar != null) {
                    map2 = ZplanAVChatRender.this.reloadAvatarListener;
                    map2.put(Integer.valueOf(i3), aVar);
                }
                map = ZplanAVChatRender.this.reloadAvatarDelayFrame;
                map.put(Integer.valueOf(i3), Integer.valueOf(delayFrame));
                zplanAVChatViewer = ZplanAVChatRender.this.filamentViewer;
                if (zplanAVChatViewer != null) {
                    zplanAVChatViewer.reloadAvatar(i3, isMale);
                }
                zplanAVChatViewer2 = ZplanAVChatRender.this.filamentViewer;
                if (zplanAVChatViewer2 != null) {
                    list = ZplanAVChatRender.f105873a0;
                    float floatValue = ((Number) list.get(0)).floatValue();
                    list2 = ZplanAVChatRender.f105873a0;
                    float floatValue2 = ((Number) list2.get(1)).floatValue();
                    list3 = ZplanAVChatRender.f105873a0;
                    zplanAVChatViewer2.setTranslationOffset(i3, floatValue, floatValue2, ((Number) list3.get(2)).floatValue());
                }
                if (isLocal) {
                    ZplanAVChatRender.this.mIsLocalTransformInit = true;
                } else {
                    ZplanAVChatRender.this.mIsRemoteTransformInit = true;
                }
                bVar = ZplanAVChatRender.this.renderEventsCallback;
                if (bVar != null) {
                    zplanAVChatViewer3 = ZplanAVChatRender.this.filamentViewer;
                    bVar.a(zplanAVChatViewer3 != null, AVChatRenderEventsType.EVENT_RELOAD_AVATAR);
                }
                fLog.i("FilamentAVChatRender", "reloadAvatar end");
            }
        });
    }

    @Override // com.tencent.filament.zplan.f
    public void d(@NotNull final String iblPath) {
        Intrinsics.checkNotNullParameter(iblPath, "iblPath");
        B0("loadLight", new Function0<Unit>() { // from class: com.tencent.filament.zplan.render.impl.ZplanAVChatRender$loadLight$1
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
                ZplanAVChatViewer zplanAVChatViewer;
                uk0.b bVar;
                ZplanAVChatViewer zplanAVChatViewer2;
                zplanAVChatViewer = ZplanAVChatRender.this.filamentViewer;
                if (zplanAVChatViewer != null) {
                    zplanAVChatViewer.loadLight(iblPath);
                }
                bVar = ZplanAVChatRender.this.renderEventsCallback;
                if (bVar != null) {
                    zplanAVChatViewer2 = ZplanAVChatRender.this.filamentViewer;
                    bVar.a(zplanAVChatViewer2 != null, AVChatRenderEventsType.EVENT_LOAD_LIGHT);
                }
            }
        });
    }

    @Override // com.tencent.filament.zplan.f
    public void e(final boolean isLocal, @NotNull final String slotName, @NotNull final String textureAbsPath, @Nullable final String jsonAbsPath) {
        Intrinsics.checkNotNullParameter(slotName, "slotName");
        Intrinsics.checkNotNullParameter(textureAbsPath, "textureAbsPath");
        B0("updateMakeupSlotTexture", new Function0<Unit>() { // from class: com.tencent.filament.zplan.render.impl.ZplanAVChatRender$updateMakeupSlotTexture$1
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
                Set set;
                ZplanAVChatViewer zplanAVChatViewer;
                uk0.b bVar;
                ZplanAVChatViewer zplanAVChatViewer2;
                int i3 = isLocal ? ZplanAVChatRender.this.localAvatarIndex : ZplanAVChatRender.this.remoteAvatarIndex;
                set = ZplanAVChatRender.this.makeupSet;
                set.add(slotName);
                zplanAVChatViewer = ZplanAVChatRender.this.filamentViewer;
                if (zplanAVChatViewer != null) {
                    zplanAVChatViewer.updateMakeupSlotTexture(i3, slotName, textureAbsPath, jsonAbsPath);
                }
                bVar = ZplanAVChatRender.this.renderEventsCallback;
                if (bVar != null) {
                    zplanAVChatViewer2 = ZplanAVChatRender.this.filamentViewer;
                    bVar.a(zplanAVChatViewer2 != null, AVChatRenderEventsType.EVENT_UPDATE_MAKE_UP_SLOT_TEXTURE);
                }
            }
        });
    }

    @Override // com.tencent.filament.zplan.f
    public void f(final boolean isLocal, @NotNull final String slotName, final int r16, final int g16, final int b16, final int a16) {
        Intrinsics.checkNotNullParameter(slotName, "slotName");
        B0("updateMakeupSlotColor", new Function0<Unit>() { // from class: com.tencent.filament.zplan.render.impl.ZplanAVChatRender$updateMakeupSlotColor$1
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
                ZplanAVChatViewer zplanAVChatViewer;
                uk0.b bVar;
                ZplanAVChatViewer zplanAVChatViewer2;
                int i3 = isLocal ? ZplanAVChatRender.this.localAvatarIndex : ZplanAVChatRender.this.remoteAvatarIndex;
                zplanAVChatViewer = ZplanAVChatRender.this.filamentViewer;
                if (zplanAVChatViewer != null) {
                    zplanAVChatViewer.updateMakeupSlotColor(i3, slotName, r16, g16, b16, a16);
                }
                bVar = ZplanAVChatRender.this.renderEventsCallback;
                if (bVar != null) {
                    zplanAVChatViewer2 = ZplanAVChatRender.this.filamentViewer;
                    bVar.a(zplanAVChatViewer2 != null, AVChatRenderEventsType.EVENT_UPDATE_MAKEUP_SLOT_COLOR);
                }
            }
        });
    }

    @Override // com.tencent.filament.zplan.f
    public void g(final boolean isLocal) {
        B0("mirrorAvatar", new Function0<Unit>() { // from class: com.tencent.filament.zplan.render.impl.ZplanAVChatRender$mirrorAvatar$1
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

            /* JADX WARN: Code restructure failed: missing block: B:5:0x0013, code lost:
            
                r1 = r2.this$0.filamentViewer;
             */
            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public final void invoke2() {
                ZplanAVChatViewer zplanAVChatViewer;
                int i3 = isLocal ? ZplanAVChatRender.this.localAvatarIndex : ZplanAVChatRender.this.remoteAvatarIndex;
                if (i3 < 0 || zplanAVChatViewer == null) {
                    return;
                }
                zplanAVChatViewer.mirrorAvatar(i3);
            }
        });
    }

    @Override // com.tencent.filament.zplan.f
    public boolean h(boolean isLocal) {
        if (this.filamentViewer == null) {
            if (isLocal) {
                this.needRestoreLocalViewCreate = true;
            } else {
                this.needRestoreRemoteViewCreate = true;
            }
            FLog.INSTANCE.i("FilamentAVChatRender", "must init filamentViewer before createAvatarView.");
            return false;
        }
        FLog fLog = FLog.INSTANCE;
        fLog.d("FilamentAVChatRender", "createAvatarView " + isLocal + " local=" + this.localAvatarIndex + " remote=" + this.remoteAvatarIndex + " smallIndex=" + this.curSmallViewIndex + " isDoubleHorizontal=" + this.isDoubleHorizontal + TokenParser.SP + this.surfaceWidth + TokenParser.SP + this.surfaceHeight);
        if (isLocal) {
            if (this.localAvatarIndex >= 0) {
                this.needRestoreLocalViewCreate = false;
                return false;
            }
            B0("createAvatarView", new Function0<Unit>() { // from class: com.tencent.filament.zplan.render.impl.ZplanAVChatRender$createAvatarView$1
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
                    ZplanAVChatViewer zplanAVChatViewer;
                    ZplanAVChatViewer zplanAVChatViewer2;
                    boolean z16;
                    int i3;
                    int i16;
                    ZplanAVChatViewer zplanAVChatViewer3;
                    ZplanAVChatViewer zplanAVChatViewer4;
                    int i17;
                    int i18;
                    int i19;
                    int i26;
                    int i27;
                    int i28;
                    int i29;
                    ZplanAVChatViewer zplanAVChatViewer5;
                    ZplanAVChatViewer zplanAVChatViewer6;
                    int i36;
                    int i37;
                    int i38;
                    int i39;
                    ZplanAVChatViewer zplanAVChatViewer7;
                    int i46;
                    int i47;
                    int i48;
                    zplanAVChatViewer = ZplanAVChatRender.this.filamentViewer;
                    if (zplanAVChatViewer == null) {
                        return;
                    }
                    ZplanAVChatRender zplanAVChatRender = ZplanAVChatRender.this;
                    zplanAVChatViewer2 = zplanAVChatRender.filamentViewer;
                    Intrinsics.checkNotNull(zplanAVChatViewer2);
                    zplanAVChatRender.localAvatarIndex = zplanAVChatViewer2.createAvatar();
                    ZplanAVChatRender.this.needRestoreLocalViewCreate = false;
                    z16 = ZplanAVChatRender.this.isDoubleHorizontal;
                    if (z16) {
                        zplanAVChatViewer7 = ZplanAVChatRender.this.filamentViewer;
                        if (zplanAVChatViewer7 != null) {
                            i46 = ZplanAVChatRender.this.localAvatarIndex;
                            i47 = ZplanAVChatRender.this.surfaceWidth;
                            i48 = ZplanAVChatRender.this.surfaceHeight;
                            zplanAVChatViewer7.updateViewport(i46, 0, 0, i47 / 2, i48);
                            return;
                        }
                        return;
                    }
                    i3 = ZplanAVChatRender.this.curSmallViewIndex;
                    i16 = ZplanAVChatRender.this.remoteAvatarIndex;
                    if (i3 == i16) {
                        zplanAVChatViewer5 = ZplanAVChatRender.this.filamentViewer;
                        if (zplanAVChatViewer5 != null) {
                            i37 = ZplanAVChatRender.this.localAvatarIndex;
                            i38 = ZplanAVChatRender.this.surfaceWidth;
                            i39 = ZplanAVChatRender.this.surfaceHeight;
                            zplanAVChatViewer5.updateViewport(i37, 0, 0, i38, i39);
                        }
                        zplanAVChatViewer6 = ZplanAVChatRender.this.filamentViewer;
                        if (zplanAVChatViewer6 != null) {
                            i36 = ZplanAVChatRender.this.localAvatarIndex;
                            zplanAVChatViewer6.setAvatarViewZoder(i36, 0);
                            return;
                        }
                        return;
                    }
                    zplanAVChatViewer3 = ZplanAVChatRender.this.filamentViewer;
                    if (zplanAVChatViewer3 != null) {
                        i19 = ZplanAVChatRender.this.localAvatarIndex;
                        i26 = ZplanAVChatRender.this.smallViewLeftMargin;
                        i27 = ZplanAVChatRender.this.smallViewBottomMargin;
                        i28 = ZplanAVChatRender.this.smallViewWidth;
                        i29 = ZplanAVChatRender.this.smallViewHeight;
                        zplanAVChatViewer3.updateViewport(i19, i26, i27, i28, i29);
                    }
                    zplanAVChatViewer4 = ZplanAVChatRender.this.filamentViewer;
                    if (zplanAVChatViewer4 != null) {
                        i18 = ZplanAVChatRender.this.localAvatarIndex;
                        zplanAVChatViewer4.setAvatarViewZoder(i18, 1);
                    }
                    ZplanAVChatRender zplanAVChatRender2 = ZplanAVChatRender.this;
                    i17 = zplanAVChatRender2.localAvatarIndex;
                    zplanAVChatRender2.curSmallViewIndex = i17;
                }
            });
        } else {
            if (this.remoteAvatarIndex >= 0) {
                this.needRestoreRemoteViewCreate = false;
                return false;
            }
            B0("createAvatarView", new Function0<Unit>() { // from class: com.tencent.filament.zplan.render.impl.ZplanAVChatRender$createAvatarView$2
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
                    ZplanAVChatViewer zplanAVChatViewer;
                    ZplanAVChatViewer zplanAVChatViewer2;
                    boolean z16;
                    int i3;
                    int i16;
                    ZplanAVChatViewer zplanAVChatViewer3;
                    ZplanAVChatViewer zplanAVChatViewer4;
                    int i17;
                    int i18;
                    int i19;
                    int i26;
                    ZplanAVChatViewer zplanAVChatViewer5;
                    int i27;
                    int i28;
                    int i29;
                    zplanAVChatViewer = ZplanAVChatRender.this.filamentViewer;
                    if (zplanAVChatViewer == null) {
                        return;
                    }
                    ZplanAVChatRender zplanAVChatRender = ZplanAVChatRender.this;
                    zplanAVChatViewer2 = zplanAVChatRender.filamentViewer;
                    Intrinsics.checkNotNull(zplanAVChatViewer2);
                    zplanAVChatRender.remoteAvatarIndex = zplanAVChatViewer2.createAvatar();
                    ZplanAVChatRender.this.needRestoreRemoteViewCreate = false;
                    z16 = ZplanAVChatRender.this.isDoubleHorizontal;
                    if (z16) {
                        zplanAVChatViewer5 = ZplanAVChatRender.this.filamentViewer;
                        if (zplanAVChatViewer5 != null) {
                            i27 = ZplanAVChatRender.this.remoteAvatarIndex;
                            i28 = ZplanAVChatRender.this.surfaceWidth;
                            i29 = ZplanAVChatRender.this.surfaceHeight;
                            zplanAVChatViewer5.updateViewport(i27, 0, 0, i28 / 2, i29);
                            return;
                        }
                        return;
                    }
                    i3 = ZplanAVChatRender.this.curSmallViewIndex;
                    i16 = ZplanAVChatRender.this.localAvatarIndex;
                    if (i3 == i16) {
                        zplanAVChatViewer3 = ZplanAVChatRender.this.filamentViewer;
                        if (zplanAVChatViewer3 != null) {
                            i18 = ZplanAVChatRender.this.remoteAvatarIndex;
                            i19 = ZplanAVChatRender.this.surfaceWidth;
                            i26 = ZplanAVChatRender.this.surfaceHeight;
                            zplanAVChatViewer3.updateViewport(i18, 0, 0, i19, i26);
                        }
                        zplanAVChatViewer4 = ZplanAVChatRender.this.filamentViewer;
                        if (zplanAVChatViewer4 != null) {
                            i17 = ZplanAVChatRender.this.remoteAvatarIndex;
                            zplanAVChatViewer4.setAvatarViewZoder(i17, 0);
                        }
                    }
                }
            });
        }
        fLog.d("FilamentAVChatRender", "createAvatarView end local=" + this.localAvatarIndex + " remote=" + this.remoteAvatarIndex);
        return true;
    }

    @Override // com.tencent.filament.zplan.f
    public void i(final boolean isHorizontal) {
        B0("changeViewMode", new Function0<Unit>() { // from class: com.tencent.filament.zplan.render.impl.ZplanAVChatRender$changeViewMode$1
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
                boolean z16;
                ZplanAVChatViewer zplanAVChatViewer;
                ZplanAVChatViewer zplanAVChatViewer2;
                ZplanAVChatViewer zplanAVChatViewer3;
                ZplanAVChatViewer zplanAVChatViewer4;
                int i3;
                int i16;
                int i17;
                int i18;
                int i19;
                int i26;
                int i27;
                int i28;
                int i29;
                int i36;
                int i37;
                ZplanAVChatViewer zplanAVChatViewer5;
                ZplanAVChatViewer zplanAVChatViewer6;
                int i38;
                int i39;
                int i46;
                int i47;
                int i48;
                int i49;
                int i56;
                ZplanAVChatRender.this.isDoubleHorizontal = isHorizontal;
                z16 = ZplanAVChatRender.this.isDoubleHorizontal;
                if (z16) {
                    zplanAVChatViewer5 = ZplanAVChatRender.this.filamentViewer;
                    if (zplanAVChatViewer5 != null) {
                        i48 = ZplanAVChatRender.this.localAvatarIndex;
                        i49 = ZplanAVChatRender.this.surfaceWidth;
                        i56 = ZplanAVChatRender.this.surfaceHeight;
                        zplanAVChatViewer5.updateViewport(i48, 0, 0, i49 / 2, i56);
                    }
                    zplanAVChatViewer6 = ZplanAVChatRender.this.filamentViewer;
                    if (zplanAVChatViewer6 != null) {
                        i38 = ZplanAVChatRender.this.remoteAvatarIndex;
                        i39 = ZplanAVChatRender.this.surfaceWidth;
                        int i57 = i39 / 2;
                        i46 = ZplanAVChatRender.this.surfaceWidth;
                        i47 = ZplanAVChatRender.this.surfaceHeight;
                        zplanAVChatViewer6.updateViewport(i38, i57, 0, i46 / 2, i47);
                    }
                    ZplanAVChatRender.this.curSmallViewIndex = -1;
                    return;
                }
                zplanAVChatViewer = ZplanAVChatRender.this.filamentViewer;
                if (zplanAVChatViewer != null) {
                    i29 = ZplanAVChatRender.this.remoteAvatarIndex;
                    i36 = ZplanAVChatRender.this.surfaceWidth;
                    i37 = ZplanAVChatRender.this.surfaceHeight;
                    zplanAVChatViewer.updateViewport(i29, 0, 0, i36, i37);
                }
                zplanAVChatViewer2 = ZplanAVChatRender.this.filamentViewer;
                if (zplanAVChatViewer2 != null) {
                    i18 = ZplanAVChatRender.this.localAvatarIndex;
                    i19 = ZplanAVChatRender.this.smallViewLeftMargin;
                    i26 = ZplanAVChatRender.this.smallViewBottomMargin;
                    i27 = ZplanAVChatRender.this.smallViewWidth;
                    i28 = ZplanAVChatRender.this.smallViewHeight;
                    zplanAVChatViewer2.updateViewport(i18, i19, i26, i27, i28);
                }
                zplanAVChatViewer3 = ZplanAVChatRender.this.filamentViewer;
                if (zplanAVChatViewer3 != null) {
                    i17 = ZplanAVChatRender.this.remoteAvatarIndex;
                    zplanAVChatViewer3.setAvatarViewZoder(i17, 0);
                }
                zplanAVChatViewer4 = ZplanAVChatRender.this.filamentViewer;
                if (zplanAVChatViewer4 != null) {
                    i16 = ZplanAVChatRender.this.localAvatarIndex;
                    zplanAVChatViewer4.setAvatarViewZoder(i16, 1);
                }
                ZplanAVChatRender zplanAVChatRender = ZplanAVChatRender.this;
                i3 = zplanAVChatRender.localAvatarIndex;
                zplanAVChatRender.curSmallViewIndex = i3;
            }
        });
    }

    @Override // com.tencent.filament.zplan.f
    public void j(final boolean isLocal, @NotNull final HashMap<String, String> resourcePathMap) {
        Intrinsics.checkNotNullParameter(resourcePathMap, "resourcePathMap");
        B0("updateAvatarResource", new Function0<Unit>() { // from class: com.tencent.filament.zplan.render.impl.ZplanAVChatRender$updateAvatarResource$1
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
                ZplanAVChatViewer zplanAVChatViewer;
                uk0.b bVar;
                ZplanAVChatViewer zplanAVChatViewer2;
                int i3 = isLocal ? ZplanAVChatRender.this.localAvatarIndex : ZplanAVChatRender.this.remoteAvatarIndex;
                zplanAVChatViewer = ZplanAVChatRender.this.filamentViewer;
                if (zplanAVChatViewer != null) {
                    zplanAVChatViewer.updateAvatar(i3, resourcePathMap);
                }
                bVar = ZplanAVChatRender.this.renderEventsCallback;
                if (bVar != null) {
                    zplanAVChatViewer2 = ZplanAVChatRender.this.filamentViewer;
                    bVar.a(zplanAVChatViewer2 != null, AVChatRenderEventsType.EVENT_UPDATE_AVATAR);
                }
            }
        });
    }

    @Override // com.tencent.filament.zplan.f
    public void l(final boolean isLocal) {
        B0("switchToBigView", new Function0<Unit>() { // from class: com.tencent.filament.zplan.render.impl.ZplanAVChatRender$switchToBigView$1
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
                ZplanAVChatRender.this.R0(isLocal);
            }
        });
    }

    @Override // com.tencent.filament.zplan.f
    public void m(final boolean isLocal, @NotNull final String lutPath) {
        Intrinsics.checkNotNullParameter(lutPath, "lutPath");
        B0("loadLut", new Function0<Unit>() { // from class: com.tencent.filament.zplan.render.impl.ZplanAVChatRender$loadLut$1
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
                ZplanAVChatViewer zplanAVChatViewer;
                uk0.b bVar;
                ZplanAVChatViewer zplanAVChatViewer2;
                int i3 = isLocal ? ZplanAVChatRender.this.localAvatarIndex : ZplanAVChatRender.this.remoteAvatarIndex;
                zplanAVChatViewer = ZplanAVChatRender.this.filamentViewer;
                if (zplanAVChatViewer != null) {
                    zplanAVChatViewer.loadLut(i3, lutPath);
                }
                bVar = ZplanAVChatRender.this.renderEventsCallback;
                if (bVar != null) {
                    zplanAVChatViewer2 = ZplanAVChatRender.this.filamentViewer;
                    bVar.a(zplanAVChatViewer2 != null, AVChatRenderEventsType.EVENT_LOAD_LUT);
                }
            }
        });
    }

    @Override // com.tencent.filament.zplan.f
    public void n(final boolean isLocal) {
        if (this.filamentViewer == null) {
            FLog.INSTANCE.i("FilamentAVChatRender", "must init filamentViewer before removeAvatarView.");
            return;
        }
        FLog.INSTANCE.d("FilamentAVChatRender", "removeAvatarView " + isLocal + " local=" + this.localAvatarIndex + " remote=" + this.remoteAvatarIndex + " smallIndex=" + this.curSmallViewIndex + " isDoubleHorizontal=" + this.isDoubleHorizontal);
        B0("changeViewMode", new Function0<Unit>() { // from class: com.tencent.filament.zplan.render.impl.ZplanAVChatRender$removeAvatarView$1
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

            /* JADX WARN: Code restructure failed: missing block: B:25:0x00bc, code lost:
            
                if (r0 == r1) goto L27;
             */
            /* JADX WARN: Code restructure failed: missing block: B:52:0x017a, code lost:
            
                if (r0 == r1) goto L51;
             */
            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public final void invoke2() {
                ZplanAVChatViewer zplanAVChatViewer;
                ConcurrentHashMap concurrentHashMap;
                int i3;
                ConcurrentHashMap concurrentHashMap2;
                int i16;
                int i17;
                boolean z16;
                int i18;
                int i19;
                ConcurrentHashMap concurrentHashMap3;
                int i26;
                ConcurrentHashMap concurrentHashMap4;
                int i27;
                ConcurrentHashMap concurrentHashMap5;
                int i28;
                int i29;
                int i36;
                int i37;
                ZplanAVChatViewer zplanAVChatViewer2;
                ConcurrentHashMap concurrentHashMap6;
                int i38;
                ConcurrentHashMap concurrentHashMap7;
                int i39;
                int i46;
                boolean z17;
                int i47;
                int i48;
                ConcurrentHashMap concurrentHashMap8;
                int i49;
                ConcurrentHashMap concurrentHashMap9;
                int i56;
                ConcurrentHashMap concurrentHashMap10;
                int i57;
                int i58;
                if (isLocal) {
                    zplanAVChatViewer2 = ZplanAVChatRender.this.filamentViewer;
                    if (zplanAVChatViewer2 != null) {
                        i58 = ZplanAVChatRender.this.localAvatarIndex;
                        zplanAVChatViewer2.remoteAvatar(i58);
                    }
                    concurrentHashMap6 = ZplanAVChatRender.this.mUinToAIInfoCacheList;
                    i38 = ZplanAVChatRender.this.localAvatarIndex;
                    CopyOnWriteArrayList copyOnWriteArrayList = (CopyOnWriteArrayList) concurrentHashMap6.get(Integer.valueOf(i38));
                    if (copyOnWriteArrayList != null) {
                        copyOnWriteArrayList.clear();
                    }
                    concurrentHashMap7 = ZplanAVChatRender.this.mRenderViewInfoMap;
                    i39 = ZplanAVChatRender.this.localAvatarIndex;
                    if (concurrentHashMap7.get(Integer.valueOf(i39)) != null) {
                        concurrentHashMap8 = ZplanAVChatRender.this.mRenderViewInfoMap;
                        i49 = ZplanAVChatRender.this.localAvatarIndex;
                        AVChatAvatarRenderInfo aVChatAvatarRenderInfo = (AVChatAvatarRenderInfo) concurrentHashMap8.get(Integer.valueOf(i49));
                        if (aVChatAvatarRenderInfo != null) {
                            aVChatAvatarRenderInfo.setLastAvatarAIData(null);
                        }
                        concurrentHashMap9 = ZplanAVChatRender.this.mRenderViewInfoMap;
                        i56 = ZplanAVChatRender.this.localAvatarIndex;
                        AVChatAvatarRenderInfo aVChatAvatarRenderInfo2 = (AVChatAvatarRenderInfo) concurrentHashMap9.get(Integer.valueOf(i56));
                        if (aVChatAvatarRenderInfo2 != null) {
                            aVChatAvatarRenderInfo2.setFirstRenderTimestamp(0L);
                        }
                        concurrentHashMap10 = ZplanAVChatRender.this.mRenderViewInfoMap;
                        i57 = ZplanAVChatRender.this.localAvatarIndex;
                        AVChatAvatarRenderInfo aVChatAvatarRenderInfo3 = (AVChatAvatarRenderInfo) concurrentHashMap10.get(Integer.valueOf(i57));
                        if (aVChatAvatarRenderInfo3 != null) {
                            aVChatAvatarRenderInfo3.setFirstFrameTimestamp(0L);
                        }
                    }
                    ZplanAVChatRender.this.localAvatarIndex = -1;
                    i46 = ZplanAVChatRender.this.remoteAvatarIndex;
                    if (i46 >= 0) {
                        z17 = ZplanAVChatRender.this.isDoubleHorizontal;
                        if (!z17) {
                            i47 = ZplanAVChatRender.this.curSmallViewIndex;
                            i48 = ZplanAVChatRender.this.remoteAvatarIndex;
                        }
                        ZplanAVChatRender.this.R0(false);
                    }
                } else {
                    zplanAVChatViewer = ZplanAVChatRender.this.filamentViewer;
                    if (zplanAVChatViewer != null) {
                        i29 = ZplanAVChatRender.this.remoteAvatarIndex;
                        zplanAVChatViewer.remoteAvatar(i29);
                    }
                    concurrentHashMap = ZplanAVChatRender.this.mUinToAIInfoCacheList;
                    i3 = ZplanAVChatRender.this.remoteAvatarIndex;
                    CopyOnWriteArrayList copyOnWriteArrayList2 = (CopyOnWriteArrayList) concurrentHashMap.get(Integer.valueOf(i3));
                    if (copyOnWriteArrayList2 != null) {
                        copyOnWriteArrayList2.clear();
                    }
                    concurrentHashMap2 = ZplanAVChatRender.this.mRenderViewInfoMap;
                    i16 = ZplanAVChatRender.this.remoteAvatarIndex;
                    if (concurrentHashMap2.get(Integer.valueOf(i16)) != null) {
                        concurrentHashMap3 = ZplanAVChatRender.this.mRenderViewInfoMap;
                        i26 = ZplanAVChatRender.this.remoteAvatarIndex;
                        AVChatAvatarRenderInfo aVChatAvatarRenderInfo4 = (AVChatAvatarRenderInfo) concurrentHashMap3.get(Integer.valueOf(i26));
                        if (aVChatAvatarRenderInfo4 != null) {
                            aVChatAvatarRenderInfo4.setLastAvatarAIData(null);
                        }
                        concurrentHashMap4 = ZplanAVChatRender.this.mRenderViewInfoMap;
                        i27 = ZplanAVChatRender.this.remoteAvatarIndex;
                        AVChatAvatarRenderInfo aVChatAvatarRenderInfo5 = (AVChatAvatarRenderInfo) concurrentHashMap4.get(Integer.valueOf(i27));
                        if (aVChatAvatarRenderInfo5 != null) {
                            aVChatAvatarRenderInfo5.setFirstRenderTimestamp(0L);
                        }
                        concurrentHashMap5 = ZplanAVChatRender.this.mRenderViewInfoMap;
                        i28 = ZplanAVChatRender.this.remoteAvatarIndex;
                        AVChatAvatarRenderInfo aVChatAvatarRenderInfo6 = (AVChatAvatarRenderInfo) concurrentHashMap5.get(Integer.valueOf(i28));
                        if (aVChatAvatarRenderInfo6 != null) {
                            aVChatAvatarRenderInfo6.setFirstFrameTimestamp(0L);
                        }
                    }
                    ZplanAVChatRender.this.remoteAvatarIndex = -1;
                    i17 = ZplanAVChatRender.this.localAvatarIndex;
                    if (i17 >= 0) {
                        z16 = ZplanAVChatRender.this.isDoubleHorizontal;
                        if (!z16) {
                            i18 = ZplanAVChatRender.this.curSmallViewIndex;
                            i19 = ZplanAVChatRender.this.localAvatarIndex;
                        }
                        ZplanAVChatRender.this.R0(true);
                    }
                }
                FLog fLog = FLog.INSTANCE;
                StringBuilder sb5 = new StringBuilder();
                sb5.append("removeAvatarView end local=");
                i36 = ZplanAVChatRender.this.localAvatarIndex;
                sb5.append(i36);
                sb5.append(" remote=");
                i37 = ZplanAVChatRender.this.remoteAvatarIndex;
                sb5.append(i37);
                fLog.d("FilamentAVChatRender", sb5.toString());
            }
        });
    }

    @Override // com.tencent.filament.zplan.f
    public void o(@NotNull uk0.b listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        this.renderEventsCallback = listener;
    }

    @Override // wk0.b
    public void onDestroy() {
        FLog.INSTANCE.i("FilamentRender_LifeCycle", MosaicConstants$JsFunction.FUNC_ON_DESTROY);
        B0(MosaicConstants$JsFunction.FUNC_ON_DESTROY, new Function0<Unit>() { // from class: com.tencent.filament.zplan.render.impl.ZplanAVChatRender$onDestroy$1
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
                AtomicBoolean atomicBoolean;
                boolean z16;
                ConcurrentHashMap concurrentHashMap;
                ConcurrentHashMap concurrentHashMap2;
                int i3;
                int i16;
                ZplanAVChatViewer zplanAVChatViewer;
                ZplanAVChatViewer zplanAVChatViewer2;
                ZplanAVChatViewer zplanAVChatViewer3;
                int i17;
                int i18;
                ZplanAVChatViewer zplanAVChatViewer4;
                ZplanAVChatViewer zplanAVChatViewer5;
                int i19;
                int i26;
                atomicBoolean = ZplanAVChatRender.this.destroy;
                atomicBoolean.set(true);
                z16 = ZplanAVChatRender.this.mIsPlayingAnimation;
                if (z16) {
                    zplanAVChatViewer4 = ZplanAVChatRender.this.filamentViewer;
                    if (zplanAVChatViewer4 != null) {
                        i26 = ZplanAVChatRender.this.localAvatarIndex;
                        zplanAVChatViewer4.stopAnimation(i26);
                    }
                    zplanAVChatViewer5 = ZplanAVChatRender.this.filamentViewer;
                    if (zplanAVChatViewer5 != null) {
                        i19 = ZplanAVChatRender.this.remoteAvatarIndex;
                        zplanAVChatViewer5.stopAnimation(i19);
                    }
                }
                concurrentHashMap = ZplanAVChatRender.this.hasReloadAvatar;
                concurrentHashMap.clear();
                concurrentHashMap2 = ZplanAVChatRender.this.mUinToAIInfoCacheList;
                concurrentHashMap2.clear();
                ZplanAVChatRender zplanAVChatRender = ZplanAVChatRender.this;
                i3 = zplanAVChatRender.localAvatarIndex;
                zplanAVChatRender.z0(i3);
                ZplanAVChatRender zplanAVChatRender2 = ZplanAVChatRender.this;
                i16 = zplanAVChatRender2.remoteAvatarIndex;
                zplanAVChatRender2.z0(i16);
                zplanAVChatViewer = ZplanAVChatRender.this.filamentViewer;
                if (zplanAVChatViewer != null) {
                    i18 = ZplanAVChatRender.this.localAvatarIndex;
                    zplanAVChatViewer.remoteAvatar(i18);
                }
                zplanAVChatViewer2 = ZplanAVChatRender.this.filamentViewer;
                if (zplanAVChatViewer2 != null) {
                    i17 = ZplanAVChatRender.this.remoteAvatarIndex;
                    zplanAVChatViewer2.remoteAvatar(i17);
                }
                zplanAVChatViewer3 = ZplanAVChatRender.this.filamentViewer;
                if (zplanAVChatViewer3 != null) {
                    zplanAVChatViewer3.destroy();
                }
                ZplanAVChatRender.this.filamentViewer = null;
                ZplanAVChatRender.this.renderSurface = null;
            }
        });
        A0(new Runnable() { // from class: com.tencent.filament.zplan.render.impl.ZplanAVChatRender$onDestroy$2
            @Override // java.lang.Runnable
            public final void run() {
                VSyncScheduler vSyncScheduler;
                AVFilamentTextureView aVFilamentTextureView;
                ViewParent viewParent;
                AVFilamentTextureView aVFilamentTextureView2;
                AVFilamentTextureView aVFilamentTextureView3;
                vSyncScheduler = ZplanAVChatRender.this.vSyncScheduler;
                if (vSyncScheduler != null) {
                    vSyncScheduler.p();
                }
                aVFilamentTextureView = ZplanAVChatRender.this.filamentView;
                if (aVFilamentTextureView != null) {
                    viewParent = aVFilamentTextureView.getParent();
                } else {
                    viewParent = null;
                }
                if (viewParent != null) {
                    aVFilamentTextureView3 = ZplanAVChatRender.this.filamentView;
                    ((ViewGroup) viewParent).removeView(aVFilamentTextureView3);
                }
                aVFilamentTextureView2 = ZplanAVChatRender.this.filamentView;
                if (aVFilamentTextureView2 != null) {
                    aVFilamentTextureView2.a();
                }
                ZplanAVChatRender.this.filamentView = null;
            }
        });
    }

    @Override // wk0.b
    public void onFinish() {
        FLog.INSTANCE.i("FilamentRender_LifeCycle", "onFinish");
        E0();
    }

    @Override // wk0.b
    public void onPause() {
        FLog.INSTANCE.i("FilamentRender_LifeCycle", MiniSDKConst.NOTIFY_EVENT_ONPAUSE);
        this.uiHandler.post(new Runnable() { // from class: com.tencent.filament.zplan.render.impl.ZplanAVChatRender$onPause$1
            @Override // java.lang.Runnable
            public final void run() {
                VSyncScheduler vSyncScheduler;
                FLog.INSTANCE.i("FilamentRender_LifeCycle", "onPause startScheduleVSync");
                vSyncScheduler = ZplanAVChatRender.this.vSyncScheduler;
                if (vSyncScheduler != null) {
                    vSyncScheduler.p();
                }
            }
        });
    }

    @Override // wk0.b
    public void onResume() {
        FLog.INSTANCE.i("FilamentRender_LifeCycle", "onResume");
        this.destroy.set(false);
        L0();
        M0();
        K0();
        this.uiHandler.post(new Runnable() { // from class: com.tencent.filament.zplan.render.impl.ZplanAVChatRender$onResume$1
            @Override // java.lang.Runnable
            public final void run() {
                VSyncScheduler vSyncScheduler;
                FLog.INSTANCE.i("FilamentRender_LifeCycle", "onResume startScheduleVSync");
                vSyncScheduler = ZplanAVChatRender.this.vSyncScheduler;
                if (vSyncScheduler != null) {
                    vSyncScheduler.o();
                }
            }
        });
    }

    @Override // com.tencent.filament.zplan.f
    public boolean p(boolean isLocal) {
        if (isLocal) {
            if (!this.needRestoreLocalViewCreate && this.localAvatarIndex < 0) {
                return false;
            }
        } else if (!this.needRestoreRemoteViewCreate && this.remoteAvatarIndex < 0) {
            return false;
        }
        return true;
    }

    @Override // com.tencent.filament.zplan.f
    public void r(@Nullable com.tencent.filament.zplan.b listener) {
        this.animationListener = listener;
    }

    @Override // com.tencent.filament.zplan.f
    public void s(@NotNull final String path) {
        Intrinsics.checkNotNullParameter(path, "path");
        B0("updateMaterialRootPath", new Function0<Unit>() { // from class: com.tencent.filament.zplan.render.impl.ZplanAVChatRender$updateMaterialRootPath$1
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

            /* JADX WARN: Code restructure failed: missing block: B:12:0x003c, code lost:
            
                if (r0.check3DMMReady(r3) == true) goto L14;
             */
            /* JADX WARN: Code restructure failed: missing block: B:13:0x003e, code lost:
            
                r1 = true;
             */
            /* JADX WARN: Code restructure failed: missing block: B:22:0x0048, code lost:
            
                r0 = r4.this$0.filamentViewer;
             */
            /* JADX WARN: Code restructure failed: missing block: B:25:0x005a, code lost:
            
                if (r0.check3DMMReady(r3) == true) goto L14;
             */
            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public final void invoke2() {
                ZplanAVChatViewer zplanAVChatViewer;
                ZplanAVChatViewer zplanAVChatViewer2;
                int i3;
                int i16;
                ZplanAVChatViewer zplanAVChatViewer3;
                int i17;
                uk0.b bVar;
                ZplanAVChatViewer zplanAVChatViewer4;
                int i18;
                zplanAVChatViewer = ZplanAVChatRender.this.filamentViewer;
                if (zplanAVChatViewer == null) {
                    FLog.INSTANCE.e("FilamentAVChatRender", "updateMaterialRootPath for view is null.");
                }
                zplanAVChatViewer2 = ZplanAVChatRender.this.filamentViewer;
                if (zplanAVChatViewer2 != null) {
                    zplanAVChatViewer2.updateMaterialRootPath(path);
                }
                i3 = ZplanAVChatRender.this.localAvatarIndex;
                boolean z16 = false;
                if (i3 >= 0) {
                    zplanAVChatViewer4 = ZplanAVChatRender.this.filamentViewer;
                    if (zplanAVChatViewer4 != null) {
                        i18 = ZplanAVChatRender.this.localAvatarIndex;
                    }
                } else {
                    i16 = ZplanAVChatRender.this.remoteAvatarIndex;
                    if (i16 >= 0 && zplanAVChatViewer3 != null) {
                        i17 = ZplanAVChatRender.this.remoteAvatarIndex;
                    }
                }
                bVar = ZplanAVChatRender.this.renderEventsCallback;
                if (bVar != null) {
                    bVar.a(z16, AVChatRenderEventsType.EVENT_UPDATE_MATERIAL_ROOT_PATH);
                }
            }
        });
    }

    @Override // com.tencent.filament.zplan.f
    public void u(final boolean isLocal, @NotNull final String gltfPath, @NotNull final String imageName) {
        Intrinsics.checkNotNullParameter(gltfPath, "gltfPath");
        Intrinsics.checkNotNullParameter(imageName, "imageName");
        B0("updateAvatarViewBg", new Function0<Unit>() { // from class: com.tencent.filament.zplan.render.impl.ZplanAVChatRender$updateAvatarViewBg$1
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
                ZplanAVChatViewer zplanAVChatViewer;
                int i3 = isLocal ? ZplanAVChatRender.this.localAvatarIndex : ZplanAVChatRender.this.remoteAvatarIndex;
                zplanAVChatViewer = ZplanAVChatRender.this.filamentViewer;
                if (zplanAVChatViewer != null) {
                    zplanAVChatViewer.updateAvatarViewBg(i3, gltfPath, imageName);
                }
            }
        });
    }

    @Override // com.tencent.filament.zplan.f
    public void v(final boolean isLocal) {
        B0("applyPinchFace", new Function0<Unit>() { // from class: com.tencent.filament.zplan.render.impl.ZplanAVChatRender$applyPinchFace$1
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
                ZplanAVChatViewer zplanAVChatViewer;
                uk0.b bVar;
                ZplanAVChatViewer zplanAVChatViewer2;
                int i3 = isLocal ? ZplanAVChatRender.this.localAvatarIndex : ZplanAVChatRender.this.remoteAvatarIndex;
                zplanAVChatViewer = ZplanAVChatRender.this.filamentViewer;
                if (zplanAVChatViewer != null) {
                    zplanAVChatViewer.applyPinchFace(i3);
                }
                bVar = ZplanAVChatRender.this.renderEventsCallback;
                if (bVar != null) {
                    zplanAVChatViewer2 = ZplanAVChatRender.this.filamentViewer;
                    bVar.a(zplanAVChatViewer2 != null, AVChatRenderEventsType.EVENT_APPLY_PINCH_FACE);
                }
            }
        });
    }

    @Override // com.tencent.filament.zplan.f
    public void w(final boolean isLocal, @NotNull final String animationGltfPath, final int animationID, final boolean isFemale) {
        Intrinsics.checkNotNullParameter(animationGltfPath, "animationGltfPath");
        B0("loadAnimation", new Function0<Unit>() { // from class: com.tencent.filament.zplan.render.impl.ZplanAVChatRender$loadAnimation$1
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
                ZplanAVChatViewer zplanAVChatViewer;
                Object[] plus;
                int i3 = isLocal ? ZplanAVChatRender.this.localAvatarIndex : ZplanAVChatRender.this.remoteAvatarIndex;
                if (i3 < 0) {
                    return;
                }
                zplanAVChatViewer = ZplanAVChatRender.this.filamentViewer;
                FilamentAnimation[] loadAnimation = zplanAVChatViewer != null ? zplanAVChatViewer.loadAnimation(i3, animationGltfPath) : null;
                if (loadAnimation != null) {
                    HashMap hashMap = isFemale ? ZplanAVChatRender.this.femaleAnimation : ZplanAVChatRender.this.maleAnimationMap;
                    FilamentAnimation[] filamentAnimationArr = (FilamentAnimation[]) hashMap.get(Integer.valueOf(animationID));
                    if (filamentAnimationArr != null) {
                        plus = ArraysKt___ArraysJvmKt.plus((Object[]) filamentAnimationArr, (Object[]) loadAnimation);
                        loadAnimation = (FilamentAnimation[]) plus;
                    }
                    hashMap.put(Integer.valueOf(animationID), loadAnimation);
                }
                ZplanAVChatRender.this.isFemale = isFemale;
            }
        });
    }

    @Override // com.tencent.filament.zplan.f
    public void x(final boolean isLocal, @NotNull final String pinchFaceConfigPath, @NotNull final ZPlanPinchFaceModel[] pinchFaceModels, @NotNull final String[] itemIdArray, final boolean isFemale) {
        Intrinsics.checkNotNullParameter(pinchFaceConfigPath, "pinchFaceConfigPath");
        Intrinsics.checkNotNullParameter(pinchFaceModels, "pinchFaceModels");
        Intrinsics.checkNotNullParameter(itemIdArray, "itemIdArray");
        B0("loadPinchFaceConfig", new Function0<Unit>() { // from class: com.tencent.filament.zplan.render.impl.ZplanAVChatRender$loadPinchFaceConfig$1
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
                ZplanAVChatViewer zplanAVChatViewer;
                uk0.b bVar;
                ZplanAVChatViewer zplanAVChatViewer2;
                int i3 = isLocal ? ZplanAVChatRender.this.localAvatarIndex : ZplanAVChatRender.this.remoteAvatarIndex;
                zplanAVChatViewer = ZplanAVChatRender.this.filamentViewer;
                if (zplanAVChatViewer != null) {
                    zplanAVChatViewer.loadPinchFaceConfig(i3, pinchFaceConfigPath, pinchFaceModels, itemIdArray, isFemale);
                }
                bVar = ZplanAVChatRender.this.renderEventsCallback;
                if (bVar != null) {
                    zplanAVChatViewer2 = ZplanAVChatRender.this.filamentViewer;
                    bVar.a(zplanAVChatViewer2 != null, AVChatRenderEventsType.EVENT_APPLY_PINCH_FACE);
                }
            }
        });
    }

    @Override // wk0.b
    @NotNull
    public View z(@NotNull Context context, @Nullable Boolean enableTouch) {
        Intrinsics.checkNotNullParameter(context, "context");
        FLog.INSTANCE.i("FilamentRender_LifeCycle", "getView: " + context);
        if (this.filamentView == null) {
            this.filamentView = new AVFilamentTextureView(new AVFilamentTextureView.FilamentTextureParam(false, enableTouch, 1, null), context);
        }
        AVFilamentTextureView aVFilamentTextureView = this.filamentView;
        if (aVFilamentTextureView != null) {
            aVFilamentTextureView.setFilamentRenderListener(new ZplanAVChatRender$getView$2(this));
        }
        AVFilamentTextureView aVFilamentTextureView2 = this.filamentView;
        Intrinsics.checkNotNull(aVFilamentTextureView2);
        return aVFilamentTextureView2;
    }

    public void z0(int index) {
        boolean z16;
        ZplanAVChatViewer zplanAVChatViewer = this.filamentViewer;
        if (zplanAVChatViewer != null) {
            zplanAVChatViewer.cleanAvatar(index);
        }
        for (String str : this.makeupSet) {
            ZplanAVChatViewer zplanAVChatViewer2 = this.filamentViewer;
            if (zplanAVChatViewer2 != null) {
                zplanAVChatViewer2.updateMakeupSlotTexture(index, str, null, null);
            }
        }
        this.makeupSet.clear();
        uk0.b bVar = this.renderEventsCallback;
        if (bVar != null) {
            if (this.filamentViewer != null) {
                z16 = true;
            } else {
                z16 = false;
            }
            bVar.a(z16, AVChatRenderEventsType.EVENT_CLEAN_AVATAR);
        }
    }
}

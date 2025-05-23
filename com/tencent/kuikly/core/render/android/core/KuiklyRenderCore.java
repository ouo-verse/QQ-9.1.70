package com.tencent.kuikly.core.render.android.core;

import android.graphics.RectF;
import android.os.Handler;
import android.os.Looper;
import android.util.SizeF;
import android.util.SparseArray;
import android.view.View;
import androidx.exifinterface.media.ExifInterface;
import com.tencent.kuikly.core.render.android.KuiklyContextParams;
import com.tencent.kuikly.core.render.android.context.KuiklyRenderContextMethod;
import com.tencent.kuikly.core.render.android.context.KuiklyRenderNativeMethod;
import com.tencent.kuikly.core.render.android.exception.ErrorReason;
import com.tencent.kuikly.core.render.android.exception.KRKotlinBizException;
import com.tencent.kuikly.core.render.android.layer.KuiklyRenderLayerHandler;
import com.tencent.kuikly.core.render.android.scheduler.KuiklyRenderCoreUIScheduler;
import com.tencent.kuikly.core.render.android.scheduler.KuiklyRenderThreadManager;
import com.tencent.kuikly.core.render.android.scheduler.a;
import com.tencent.kuikly.core.render.android.turbo.KuiklyTurboDisplayRenderLayerHandler;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.raft.measure.utils.MeasureConst;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsJVMKt;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.jvm.internal.StringCompanionObject;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u00d6\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\u0000\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0010\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 92\u00020\u00012\u00020\u0002:\u0001DB\u0013\u0012\n\b\u0002\u0010z\u001a\u0004\u0018\u00010u\u00a2\u0006\u0004\b{\u0010yJ\b\u0010\u0004\u001a\u00020\u0003H\u0002J\"\u0010\n\u001a\u0004\u0018\u00010\b2\u0006\u0010\u0006\u001a\u00020\u00052\u000e\u0010\t\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\b0\u0007H\u0002J\"\u0010\u000b\u001a\u0004\u0018\u00010\b2\u0006\u0010\u0006\u001a\u00020\u00052\u000e\u0010\t\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\b0\u0007H\u0002J\"\u0010\f\u001a\u0004\u0018\u00010\b2\u0006\u0010\u0006\u001a\u00020\u00052\u000e\u0010\t\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\b0\u0007H\u0002J\"\u0010\r\u001a\u0004\u0018\u00010\b2\u0006\u0010\u0006\u001a\u00020\u00052\u000e\u0010\t\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\b0\u0007H\u0002J\"\u0010\u000e\u001a\u0004\u0018\u00010\b2\u0006\u0010\u0006\u001a\u00020\u00052\u000e\u0010\t\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\b0\u0007H\u0002J\u0018\u0010\u0010\u001a\u00020\u000f2\u000e\u0010\t\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\b0\u0007H\u0002J\u0012\u0010\u0012\u001a\u00020\u000f2\b\u0010\u0011\u001a\u0004\u0018\u00010\bH\u0002J\"\u0010\u0013\u001a\u0004\u0018\u00010\b2\u0006\u0010\u0006\u001a\u00020\u00052\u000e\u0010\t\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\b0\u0007H\u0002J \u0010\u0014\u001a\u00020\b2\u0006\u0010\u0006\u001a\u00020\u00052\u000e\u0010\t\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\b0\u0007H\u0002J\"\u0010\u0015\u001a\u0004\u0018\u00010\b2\u0006\u0010\u0006\u001a\u00020\u00052\u000e\u0010\t\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\b0\u0007H\u0002J\"\u0010\u0016\u001a\u0004\u0018\u00010\b2\u0006\u0010\u0006\u001a\u00020\u00052\u000e\u0010\t\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\b0\u0007H\u0002J\"\u0010\u0017\u001a\u0004\u0018\u00010\b2\u0006\u0010\u0006\u001a\u00020\u00052\u000e\u0010\t\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\b0\u0007H\u0002J\"\u0010\u0018\u001a\u0004\u0018\u00010\b2\u0006\u0010\u0006\u001a\u00020\u00052\u000e\u0010\t\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\b0\u0007H\u0002J\"\u0010\u0019\u001a\u0004\u0018\u00010\b2\u0006\u0010\u0006\u001a\u00020\u00052\u000e\u0010\t\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\b0\u0007H\u0002J\"\u0010\u001a\u001a\u0004\u0018\u00010\b2\u0006\u0010\u0006\u001a\u00020\u00052\u000e\u0010\t\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\b0\u0007H\u0002J\"\u0010\u001b\u001a\u0004\u0018\u00010\b2\u0006\u0010\u0006\u001a\u00020\u00052\u000e\u0010\t\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\b0\u0007H\u0002J\"\u0010\u001c\u001a\u0004\u0018\u00010\b2\u0006\u0010\u0006\u001a\u00020\u00052\u000e\u0010\t\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\b0\u0007H\u0002J\"\u0010\u001d\u001a\u0004\u0018\u00010\b2\u0006\u0010\u0006\u001a\u00020\u00052\u000e\u0010\t\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\b0\u0007H\u0002J\"\u0010\u001e\u001a\u0004\u0018\u00010\b2\u0006\u0010\u0006\u001a\u00020\u00052\u000e\u0010\t\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\b0\u0007H\u0002J\"\u0010\u001f\u001a\u0004\u0018\u00010\b2\u0006\u0010\u0006\u001a\u00020\u00052\u000e\u0010\t\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\b0\u0007H\u0002J*\u0010%\u001a\u00020\u00032\b\b\u0002\u0010!\u001a\u00020 2\b\b\u0002\u0010\"\u001a\u00020\u000f2\f\u0010$\u001a\b\u0012\u0004\u0012\u00020\u00030#H\u0002J \u0010&\u001a\u00020\u000f2\u0006\u0010\u0006\u001a\u00020\u00052\u000e\u0010\t\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\b0\u0007H\u0002J\u0010\u0010'\u001a\u00020\u000f2\u0006\u0010\u0006\u001a\u00020\u0005H\u0002J\u0018\u0010-\u001a\u00020,2\u0006\u0010)\u001a\u00020(2\u0006\u0010+\u001a\u00020*H\u0002J\u0016\u0010.\u001a\u00020\u00032\f\u0010$\u001a\b\u0012\u0004\u0012\u00020\u00030#H\u0002JV\u00109\u001a\u00020\u00032\u0006\u0010)\u001a\u00020(2\u0006\u00100\u001a\u00020/2\u0006\u00101\u001a\u00020/2\u0012\u00103\u001a\u000e\u0012\u0004\u0012\u00020/\u0012\u0004\u0012\u00020\b022\b\u00104\u001a\u0004\u0018\u00010/2\u0006\u0010+\u001a\u00020*2\u0006\u00106\u001a\u0002052\u0006\u00108\u001a\u000207H\u0016J\u0010\u0010<\u001a\u00020\u00032\u0006\u0010;\u001a\u00020:H\u0016J\b\u0010=\u001a\u00020\u0003H\u0016J\u0018\u0010@\u001a\u00020\u00032\u0006\u0010>\u001a\u00020/2\u0006\u0010?\u001a\u00020\bH\u0016J#\u0010D\u001a\u0004\u0018\u00018\u0000\"\b\b\u0000\u0010B*\u00020A2\u0006\u0010C\u001a\u00020/H\u0016\u00a2\u0006\u0004\bD\u0010EJ\u0012\u0010I\u001a\u0004\u0018\u00010H2\u0006\u0010G\u001a\u00020FH\u0016J\b\u0010J\u001a\u00020\u0003H\u0016J\b\u0010K\u001a\u00020\u0003H\u0016J\b\u0010L\u001a\u00020\u0003H\u0016J\b\u0010M\u001a\u00020\u0003H\u0016J\u001a\u0010O\u001a\u00020\u00032\u0010\u0010$\u001a\f\u0012\u0004\u0012\u00020\u00030#j\u0002`NH\u0016J;\u0010P\u001a\u00020\u00032\u0006\u00100\u001a\u00020/2\u0006\u00101\u001a\u00020/2\u0012\u00103\u001a\u000e\u0012\u0004\u0012\u00020/\u0012\u0004\u0012\u00020\b022\u0006\u0010;\u001a\u000205H\u0000\u00a2\u0006\u0004\bP\u0010QJ\u0010\u0010T\u001a\u00020\u00032\u0006\u0010S\u001a\u00020RH\u0016J\u0010\u0010V\u001a\u00020\u00032\u0006\u0010S\u001a\u00020UH\u0016J\u0010\u0010X\u001a\u00020\u00032\u0006\u0010S\u001a\u00020WH\u0016J\"\u0010Z\u001a\u0004\u0018\u00010\b2\u0006\u0010Y\u001a\u00020\u00052\u000e\u0010\t\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\b0\u0007H\u0016R\"\u0010`\u001a\u00020/8\u0000@\u0000X\u0080\u000e\u00a2\u0006\u0012\n\u0004\bD\u0010[\u001a\u0004\b\\\u0010]\"\u0004\b^\u0010_R\u0018\u0010b\u001a\u0004\u0018\u00010,8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bI\u0010aR\u0018\u0010e\u001a\u0004\u0018\u00010c8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bO\u0010dRX\u0010k\u001aF\u0012B\u0012@\u0012\u0013\u0012\u00110\u0005\u00a2\u0006\f\bh\u0012\b\bC\u0012\u0004\b\b(Y\u0012\u001b\u0012\u0019\u0012\u0006\u0012\u0004\u0018\u00010\b0\u0007\u00a2\u0006\f\bh\u0012\b\bC\u0012\u0004\b\b(\t\u0012\u0006\u0012\u0004\u0018\u00010\b0gj\u0002`i0f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b@\u0010jR\u0018\u0010m\u001a\u0004\u0018\u00010W8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b=\u0010lR\u0016\u0010n\u001a\u00020\u000f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bL\u0010&R\u0018\u0010p\u001a\u0004\u0018\u0001078\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bM\u0010oR\u0018\u0010s\u001a\u0004\u0018\u00010q8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bZ\u0010rR\u0018\u0010+\u001a\u0004\u0018\u00010*8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bV\u0010tR$\u0010z\u001a\u0004\u0018\u00010u8\u0000@\u0000X\u0080\u000e\u00a2\u0006\u0012\n\u0004\bT\u0010v\u001a\u0004\bB\u0010w\"\u0004\bx\u0010y\u00a8\u0006|"}, d2 = {"Lcom/tencent/kuikly/core/render/android/core/KuiklyRenderCore;", "Lcom/tencent/kuikly/core/render/android/core/b;", "Lcom/tencent/kuikly/core/render/android/context/c;", "", "W", "Lcom/tencent/kuikly/core/render/android/context/KuiklyRenderNativeMethod;", "method", "", "", "args", "b0", AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, "e0", "X", "m0", "", "Y", "result", "o0", "i0", "K", "O", "L", "N", BdhLogUtil.LogTag.Tag_Req, "f0", "k0", "M", "j0", "l0", ExifInterface.LATITUDE_SOUTH, "n0", "", "delayMs", "sync", "Lkotlin/Function0;", "task", "c0", "Z", "a0", "Lcom/tencent/kuikly/core/render/android/d;", "renderView", "Lcom/tencent/kuikly/core/render/android/g;", "contextParams", "Lcom/tencent/kuikly/core/render/android/layer/a;", "P", "g0", "", "contextCode", "url", "", "params", "assetsPath", "Lcom/tencent/kuikly/core/render/android/core/a;", "contextInitCallback", "Lcom/tencent/kuikly/core/render/android/core/c;", "renderCoreDelegate", "l", "Lcom/tencent/kuikly/core/render/android/layer/b;", "initCallback", "k", "e", "event", "data", "d", "Li01/a;", "T", "name", "a", "(Ljava/lang/String;)Li01/a;", "", "tag", "Landroid/view/View;", "b", "destroy", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "f", "g", "Lcom/tencent/kuikly/core/render/android/scheduler/KuiklyRenderCoreTask;", "c", "V", "(Ljava/lang/String;Ljava/lang/String;Ljava/util/Map;Lcom/tencent/kuikly/core/render/android/core/a;)V", "Lcom/tencent/kuikly/core/render/android/f;", "listener", "j", "Lcom/tencent/kuikly/core/render/android/context/a;", "i", "Lcom/tencent/kuikly/core/render/android/exception/a;", "h0", "methodId", tl.h.F, "Ljava/lang/String;", "U", "()Ljava/lang/String;", "setInstanceId$core_render_android_debug", "(Ljava/lang/String;)V", "instanceId", "Lcom/tencent/kuikly/core/render/android/layer/a;", "renderLayerHandler", "Lcom/tencent/kuikly/core/render/android/scheduler/KuiklyRenderCoreUIScheduler;", "Lcom/tencent/kuikly/core/render/android/scheduler/KuiklyRenderCoreUIScheduler;", "uiScheduler", "Landroid/util/SparseArray;", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "Lcom/tencent/kuikly/core/render/android/context/KuiklyRenderNativeMethodCallback;", "Landroid/util/SparseArray;", "nativeMethodRegistry", "Lcom/tencent/kuikly/core/render/android/exception/a;", "exceptionListener", "syncingPerformTaskMainThreadToContextThread", "Lcom/tencent/kuikly/core/render/android/core/c;", "coreDelegate", "Lcom/tencent/kuikly/core/render/android/core/d;", "Lcom/tencent/kuikly/core/render/android/core/d;", "initContextHandlerTask", "Lcom/tencent/kuikly/core/render/android/g;", "Lcom/tencent/kuikly/core/render/android/context/b;", "Lcom/tencent/kuikly/core/render/android/context/b;", "()Lcom/tencent/kuikly/core/render/android/context/b;", "setContextHandler$core_render_android_debug", "(Lcom/tencent/kuikly/core/render/android/context/b;)V", "contextHandler", "<init>", "core-render-android_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes7.dex */
public final class KuiklyRenderCore implements com.tencent.kuikly.core.render.android.core.b, com.tencent.kuikly.core.render.android.context.c {

    /* renamed from: k, reason: collision with root package name */
    private static long f117543k;

    /* renamed from: l, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private String instanceId;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private com.tencent.kuikly.core.render.android.layer.a renderLayerHandler;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private KuiklyRenderCoreUIScheduler uiScheduler;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private final SparseArray<Function2<KuiklyRenderNativeMethod, List<? extends Object>, Object>> nativeMethodRegistry;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private com.tencent.kuikly.core.render.android.exception.a exceptionListener;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private boolean syncingPerformTaskMainThreadToContextThread;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    private com.tencent.kuikly.core.render.android.core.c coreDelegate;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private com.tencent.kuikly.core.render.android.core.d initContextHandlerTask;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private KuiklyContextParams contextParams;

    /* renamed from: j, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private com.tencent.kuikly.core.render.android.context.b contextHandler;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\b\u0010\tR\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0016\u0010\u0006\u001a\u00020\u00058\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u0007\u00a8\u0006\n"}, d2 = {"Lcom/tencent/kuikly/core/render/android/core/KuiklyRenderCore$a;", "", "", "SYNC_CALL_TYPE", "I", "", "instanceIdProducer", "J", "<init>", "()V", "core-render-android_debug"}, k = 1, mv = {1, 4, 1})
    /* renamed from: com.tencent.kuikly.core.render.android.core.KuiklyRenderCore$a, reason: from kotlin metadata */
    /* loaded from: classes7.dex */
    public static final class Companion {
        Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000'\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002@\u0012\u0013\u0012\u00110\u0002\u00a2\u0006\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\b(\u0005\u0012\u001b\u0012\u0019\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u0006\u00a2\u0006\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\b(\b\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u0001j\u0002`\tJ#\u0010\n\u001a\u0004\u0018\u00010\u00072\u0006\u0010\u0005\u001a\u00020\u00022\u000e\u0010\b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u0006H\u0096\u0002\u00a8\u0006\u000b"}, d2 = {"com/tencent/kuikly/core/render/android/core/KuiklyRenderCore$b", "Lkotlin/Function2;", "Lcom/tencent/kuikly/core/render/android/context/KuiklyRenderNativeMethod;", "Lkotlin/ParameterName;", "name", "methodId", "", "", "args", "Lcom/tencent/kuikly/core/render/android/context/KuiklyRenderNativeMethodCallback;", "a", "core-render-android_debug"}, k = 1, mv = {1, 4, 1})
    /* loaded from: classes7.dex */
    public static final class b implements Function2<KuiklyRenderNativeMethod, List<? extends Object>, Object> {
        b() {
        }

        @Override // kotlin.jvm.functions.Function2
        @Nullable
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Object invoke(@NotNull KuiklyRenderNativeMethod methodId, @NotNull List<? extends Object> args) {
            Intrinsics.checkNotNullParameter(methodId, "methodId");
            Intrinsics.checkNotNullParameter(args, "args");
            return KuiklyRenderCore.this.R(methodId, args);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000'\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002@\u0012\u0013\u0012\u00110\u0002\u00a2\u0006\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\b(\u0005\u0012\u001b\u0012\u0019\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u0006\u00a2\u0006\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\b(\b\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u0001j\u0002`\tJ#\u0010\n\u001a\u0004\u0018\u00010\u00072\u0006\u0010\u0005\u001a\u00020\u00022\u000e\u0010\b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u0006H\u0096\u0002\u00a8\u0006\u000b"}, d2 = {"com/tencent/kuikly/core/render/android/core/KuiklyRenderCore$c", "Lkotlin/Function2;", "Lcom/tencent/kuikly/core/render/android/context/KuiklyRenderNativeMethod;", "Lkotlin/ParameterName;", "name", "methodId", "", "", "args", "Lcom/tencent/kuikly/core/render/android/context/KuiklyRenderNativeMethodCallback;", "a", "core-render-android_debug"}, k = 1, mv = {1, 4, 1})
    /* loaded from: classes7.dex */
    public static final class c implements Function2<KuiklyRenderNativeMethod, List<? extends Object>, Object> {
        c() {
        }

        @Override // kotlin.jvm.functions.Function2
        @Nullable
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Object invoke(@NotNull KuiklyRenderNativeMethod methodId, @NotNull List<? extends Object> args) {
            Intrinsics.checkNotNullParameter(methodId, "methodId");
            Intrinsics.checkNotNullParameter(args, "args");
            return KuiklyRenderCore.this.f0(methodId, args);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000'\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002@\u0012\u0013\u0012\u00110\u0002\u00a2\u0006\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\b(\u0005\u0012\u001b\u0012\u0019\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u0006\u00a2\u0006\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\b(\b\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u0001j\u0002`\tJ#\u0010\n\u001a\u0004\u0018\u00010\u00072\u0006\u0010\u0005\u001a\u00020\u00022\u000e\u0010\b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u0006H\u0096\u0002\u00a8\u0006\u000b"}, d2 = {"com/tencent/kuikly/core/render/android/core/KuiklyRenderCore$d", "Lkotlin/Function2;", "Lcom/tencent/kuikly/core/render/android/context/KuiklyRenderNativeMethod;", "Lkotlin/ParameterName;", "name", "methodId", "", "", "args", "Lcom/tencent/kuikly/core/render/android/context/KuiklyRenderNativeMethodCallback;", "a", "core-render-android_debug"}, k = 1, mv = {1, 4, 1})
    /* loaded from: classes7.dex */
    public static final class d implements Function2<KuiklyRenderNativeMethod, List<? extends Object>, Object> {
        d() {
        }

        @Override // kotlin.jvm.functions.Function2
        @Nullable
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Object invoke(@NotNull KuiklyRenderNativeMethod methodId, @NotNull List<? extends Object> args) {
            Intrinsics.checkNotNullParameter(methodId, "methodId");
            Intrinsics.checkNotNullParameter(args, "args");
            return KuiklyRenderCore.this.k0(methodId, args);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000'\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002@\u0012\u0013\u0012\u00110\u0002\u00a2\u0006\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\b(\u0005\u0012\u001b\u0012\u0019\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u0006\u00a2\u0006\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\b(\b\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u0001j\u0002`\tJ#\u0010\n\u001a\u0004\u0018\u00010\u00072\u0006\u0010\u0005\u001a\u00020\u00022\u000e\u0010\b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u0006H\u0096\u0002\u00a8\u0006\u000b"}, d2 = {"com/tencent/kuikly/core/render/android/core/KuiklyRenderCore$e", "Lkotlin/Function2;", "Lcom/tencent/kuikly/core/render/android/context/KuiklyRenderNativeMethod;", "Lkotlin/ParameterName;", "name", "methodId", "", "", "args", "Lcom/tencent/kuikly/core/render/android/context/KuiklyRenderNativeMethodCallback;", "a", "core-render-android_debug"}, k = 1, mv = {1, 4, 1})
    /* loaded from: classes7.dex */
    public static final class e implements Function2<KuiklyRenderNativeMethod, List<? extends Object>, Object> {
        e() {
        }

        @Override // kotlin.jvm.functions.Function2
        @Nullable
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Object invoke(@NotNull KuiklyRenderNativeMethod methodId, @NotNull List<? extends Object> args) {
            Intrinsics.checkNotNullParameter(methodId, "methodId");
            Intrinsics.checkNotNullParameter(args, "args");
            return KuiklyRenderCore.this.j0(methodId, args);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000'\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002@\u0012\u0013\u0012\u00110\u0002\u00a2\u0006\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\b(\u0005\u0012\u001b\u0012\u0019\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u0006\u00a2\u0006\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\b(\b\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u0001j\u0002`\tJ#\u0010\n\u001a\u0004\u0018\u00010\u00072\u0006\u0010\u0005\u001a\u00020\u00022\u000e\u0010\b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u0006H\u0096\u0002\u00a8\u0006\u000b"}, d2 = {"com/tencent/kuikly/core/render/android/core/KuiklyRenderCore$f", "Lkotlin/Function2;", "Lcom/tencent/kuikly/core/render/android/context/KuiklyRenderNativeMethod;", "Lkotlin/ParameterName;", "name", "methodId", "", "", "args", "Lcom/tencent/kuikly/core/render/android/context/KuiklyRenderNativeMethodCallback;", "a", "core-render-android_debug"}, k = 1, mv = {1, 4, 1})
    /* loaded from: classes7.dex */
    public static final class f implements Function2<KuiklyRenderNativeMethod, List<? extends Object>, Object> {
        f() {
        }

        @Override // kotlin.jvm.functions.Function2
        @Nullable
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Object invoke(@NotNull KuiklyRenderNativeMethod methodId, @NotNull List<? extends Object> args) {
            Intrinsics.checkNotNullParameter(methodId, "methodId");
            Intrinsics.checkNotNullParameter(args, "args");
            return KuiklyRenderCore.this.l0(methodId, args);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000'\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002@\u0012\u0013\u0012\u00110\u0002\u00a2\u0006\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\b(\u0005\u0012\u001b\u0012\u0019\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u0006\u00a2\u0006\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\b(\b\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u0001j\u0002`\tJ#\u0010\n\u001a\u0004\u0018\u00010\u00072\u0006\u0010\u0005\u001a\u00020\u00022\u000e\u0010\b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u0006H\u0096\u0002\u00a8\u0006\u000b"}, d2 = {"com/tencent/kuikly/core/render/android/core/KuiklyRenderCore$g", "Lkotlin/Function2;", "Lcom/tencent/kuikly/core/render/android/context/KuiklyRenderNativeMethod;", "Lkotlin/ParameterName;", "name", "methodId", "", "", "args", "Lcom/tencent/kuikly/core/render/android/context/KuiklyRenderNativeMethodCallback;", "a", "core-render-android_debug"}, k = 1, mv = {1, 4, 1})
    /* loaded from: classes7.dex */
    public static final class g implements Function2<KuiklyRenderNativeMethod, List<? extends Object>, Object> {
        g() {
        }

        @Override // kotlin.jvm.functions.Function2
        @Nullable
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Object invoke(@NotNull KuiklyRenderNativeMethod methodId, @NotNull List<? extends Object> args) {
            Intrinsics.checkNotNullParameter(methodId, "methodId");
            Intrinsics.checkNotNullParameter(args, "args");
            return KuiklyRenderCore.this.M(methodId, args);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000'\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002@\u0012\u0013\u0012\u00110\u0002\u00a2\u0006\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\b(\u0005\u0012\u001b\u0012\u0019\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u0006\u00a2\u0006\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\b(\b\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u0001j\u0002`\tJ#\u0010\n\u001a\u0004\u0018\u00010\u00072\u0006\u0010\u0005\u001a\u00020\u00022\u000e\u0010\b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u0006H\u0096\u0002\u00a8\u0006\u000b"}, d2 = {"com/tencent/kuikly/core/render/android/core/KuiklyRenderCore$h", "Lkotlin/Function2;", "Lcom/tencent/kuikly/core/render/android/context/KuiklyRenderNativeMethod;", "Lkotlin/ParameterName;", "name", "methodId", "", "", "args", "Lcom/tencent/kuikly/core/render/android/context/KuiklyRenderNativeMethodCallback;", "a", "core-render-android_debug"}, k = 1, mv = {1, 4, 1})
    /* loaded from: classes7.dex */
    public static final class h implements Function2<KuiklyRenderNativeMethod, List<? extends Object>, Object> {
        h() {
        }

        @Override // kotlin.jvm.functions.Function2
        @Nullable
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Object invoke(@NotNull KuiklyRenderNativeMethod methodId, @NotNull List<? extends Object> args) {
            Intrinsics.checkNotNullParameter(methodId, "methodId");
            Intrinsics.checkNotNullParameter(args, "args");
            return KuiklyRenderCore.this.S(methodId, args);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000'\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002@\u0012\u0013\u0012\u00110\u0002\u00a2\u0006\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\b(\u0005\u0012\u001b\u0012\u0019\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u0006\u00a2\u0006\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\b(\b\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u0001j\u0002`\tJ#\u0010\n\u001a\u0004\u0018\u00010\u00072\u0006\u0010\u0005\u001a\u00020\u00022\u000e\u0010\b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u0006H\u0096\u0002\u00a8\u0006\u000b"}, d2 = {"com/tencent/kuikly/core/render/android/core/KuiklyRenderCore$i", "Lkotlin/Function2;", "Lcom/tencent/kuikly/core/render/android/context/KuiklyRenderNativeMethod;", "Lkotlin/ParameterName;", "name", "methodId", "", "", "args", "Lcom/tencent/kuikly/core/render/android/context/KuiklyRenderNativeMethodCallback;", "a", "core-render-android_debug"}, k = 1, mv = {1, 4, 1})
    /* loaded from: classes7.dex */
    public static final class i implements Function2<KuiklyRenderNativeMethod, List<? extends Object>, Object> {
        i() {
        }

        @Override // kotlin.jvm.functions.Function2
        @Nullable
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Object invoke(@NotNull KuiklyRenderNativeMethod methodId, @NotNull List<? extends Object> args) {
            Intrinsics.checkNotNullParameter(methodId, "methodId");
            Intrinsics.checkNotNullParameter(args, "args");
            return KuiklyRenderCore.this.n0(methodId, args);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000'\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002@\u0012\u0013\u0012\u00110\u0002\u00a2\u0006\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\b(\u0005\u0012\u001b\u0012\u0019\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u0006\u00a2\u0006\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\b(\b\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u0001j\u0002`\tJ#\u0010\n\u001a\u0004\u0018\u00010\u00072\u0006\u0010\u0005\u001a\u00020\u00022\u000e\u0010\b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u0006H\u0096\u0002\u00a8\u0006\u000b"}, d2 = {"com/tencent/kuikly/core/render/android/core/KuiklyRenderCore$j", "Lkotlin/Function2;", "Lcom/tencent/kuikly/core/render/android/context/KuiklyRenderNativeMethod;", "Lkotlin/ParameterName;", "name", "methodId", "", "", "args", "Lcom/tencent/kuikly/core/render/android/context/KuiklyRenderNativeMethodCallback;", "a", "core-render-android_debug"}, k = 1, mv = {1, 4, 1})
    /* loaded from: classes7.dex */
    public static final class j implements Function2<KuiklyRenderNativeMethod, List<? extends Object>, Object> {
        j() {
        }

        @Override // kotlin.jvm.functions.Function2
        @Nullable
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Object invoke(@NotNull KuiklyRenderNativeMethod methodId, @NotNull List<? extends Object> args) {
            Intrinsics.checkNotNullParameter(methodId, "methodId");
            Intrinsics.checkNotNullParameter(args, "args");
            return KuiklyRenderCore.this.Q(methodId, args);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000'\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002@\u0012\u0013\u0012\u00110\u0002\u00a2\u0006\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\b(\u0005\u0012\u001b\u0012\u0019\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u0006\u00a2\u0006\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\b(\b\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u0001j\u0002`\tJ#\u0010\n\u001a\u0004\u0018\u00010\u00072\u0006\u0010\u0005\u001a\u00020\u00022\u000e\u0010\b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u0006H\u0096\u0002\u00a8\u0006\u000b"}, d2 = {"com/tencent/kuikly/core/render/android/core/KuiklyRenderCore$k", "Lkotlin/Function2;", "Lcom/tencent/kuikly/core/render/android/context/KuiklyRenderNativeMethod;", "Lkotlin/ParameterName;", "name", "methodId", "", "", "args", "Lcom/tencent/kuikly/core/render/android/context/KuiklyRenderNativeMethodCallback;", "a", "core-render-android_debug"}, k = 1, mv = {1, 4, 1})
    /* loaded from: classes7.dex */
    public static final class k implements Function2<KuiklyRenderNativeMethod, List<? extends Object>, Object> {
        k() {
        }

        @Override // kotlin.jvm.functions.Function2
        @Nullable
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Object invoke(@NotNull KuiklyRenderNativeMethod methodId, @NotNull List<? extends Object> args) {
            Intrinsics.checkNotNullParameter(methodId, "methodId");
            Intrinsics.checkNotNullParameter(args, "args");
            return KuiklyRenderCore.this.e0(methodId, args);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000'\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002@\u0012\u0013\u0012\u00110\u0002\u00a2\u0006\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\b(\u0005\u0012\u001b\u0012\u0019\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u0006\u00a2\u0006\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\b(\b\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u0001j\u0002`\tJ#\u0010\n\u001a\u0004\u0018\u00010\u00072\u0006\u0010\u0005\u001a\u00020\u00022\u000e\u0010\b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u0006H\u0096\u0002\u00a8\u0006\u000b"}, d2 = {"com/tencent/kuikly/core/render/android/core/KuiklyRenderCore$l", "Lkotlin/Function2;", "Lcom/tencent/kuikly/core/render/android/context/KuiklyRenderNativeMethod;", "Lkotlin/ParameterName;", "name", "methodId", "", "", "args", "Lcom/tencent/kuikly/core/render/android/context/KuiklyRenderNativeMethodCallback;", "a", "core-render-android_debug"}, k = 1, mv = {1, 4, 1})
    /* loaded from: classes7.dex */
    public static final class l implements Function2<KuiklyRenderNativeMethod, List<? extends Object>, Object> {
        l() {
        }

        @Override // kotlin.jvm.functions.Function2
        @Nullable
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Object invoke(@NotNull KuiklyRenderNativeMethod methodId, @NotNull List<? extends Object> args) {
            Intrinsics.checkNotNullParameter(methodId, "methodId");
            Intrinsics.checkNotNullParameter(args, "args");
            return KuiklyRenderCore.this.X(methodId, args);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000'\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002@\u0012\u0013\u0012\u00110\u0002\u00a2\u0006\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\b(\u0005\u0012\u001b\u0012\u0019\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u0006\u00a2\u0006\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\b(\b\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u0001j\u0002`\tJ#\u0010\n\u001a\u0004\u0018\u00010\u00072\u0006\u0010\u0005\u001a\u00020\u00022\u000e\u0010\b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u0006H\u0096\u0002\u00a8\u0006\u000b"}, d2 = {"com/tencent/kuikly/core/render/android/core/KuiklyRenderCore$m", "Lkotlin/Function2;", "Lcom/tencent/kuikly/core/render/android/context/KuiklyRenderNativeMethod;", "Lkotlin/ParameterName;", "name", "methodId", "", "", "args", "Lcom/tencent/kuikly/core/render/android/context/KuiklyRenderNativeMethodCallback;", "a", "core-render-android_debug"}, k = 1, mv = {1, 4, 1})
    /* loaded from: classes7.dex */
    public static final class m implements Function2<KuiklyRenderNativeMethod, List<? extends Object>, Object> {
        m() {
        }

        @Override // kotlin.jvm.functions.Function2
        @Nullable
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Object invoke(@NotNull KuiklyRenderNativeMethod methodId, @NotNull List<? extends Object> args) {
            Intrinsics.checkNotNullParameter(methodId, "methodId");
            Intrinsics.checkNotNullParameter(args, "args");
            return KuiklyRenderCore.this.m0(methodId, args);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000'\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002@\u0012\u0013\u0012\u00110\u0002\u00a2\u0006\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\b(\u0005\u0012\u001b\u0012\u0019\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u0006\u00a2\u0006\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\b(\b\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u0001j\u0002`\tJ#\u0010\n\u001a\u0004\u0018\u00010\u00072\u0006\u0010\u0005\u001a\u00020\u00022\u000e\u0010\b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u0006H\u0096\u0002\u00a8\u0006\u000b"}, d2 = {"com/tencent/kuikly/core/render/android/core/KuiklyRenderCore$n", "Lkotlin/Function2;", "Lcom/tencent/kuikly/core/render/android/context/KuiklyRenderNativeMethod;", "Lkotlin/ParameterName;", "name", "methodId", "", "", "args", "Lcom/tencent/kuikly/core/render/android/context/KuiklyRenderNativeMethodCallback;", "a", "core-render-android_debug"}, k = 1, mv = {1, 4, 1})
    /* loaded from: classes7.dex */
    public static final class n implements Function2<KuiklyRenderNativeMethod, List<? extends Object>, Object> {
        n() {
        }

        @Override // kotlin.jvm.functions.Function2
        @Nullable
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Object invoke(@NotNull KuiklyRenderNativeMethod methodId, @NotNull List<? extends Object> args) {
            Intrinsics.checkNotNullParameter(methodId, "methodId");
            Intrinsics.checkNotNullParameter(args, "args");
            return KuiklyRenderCore.this.i0(methodId, args);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000'\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002@\u0012\u0013\u0012\u00110\u0002\u00a2\u0006\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\b(\u0005\u0012\u001b\u0012\u0019\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u0006\u00a2\u0006\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\b(\b\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u0001j\u0002`\tJ#\u0010\n\u001a\u0004\u0018\u00010\u00072\u0006\u0010\u0005\u001a\u00020\u00022\u000e\u0010\b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u0006H\u0096\u0002\u00a8\u0006\u000b"}, d2 = {"com/tencent/kuikly/core/render/android/core/KuiklyRenderCore$o", "Lkotlin/Function2;", "Lcom/tencent/kuikly/core/render/android/context/KuiklyRenderNativeMethod;", "Lkotlin/ParameterName;", "name", "methodId", "", "", "args", "Lcom/tencent/kuikly/core/render/android/context/KuiklyRenderNativeMethodCallback;", "a", "core-render-android_debug"}, k = 1, mv = {1, 4, 1})
    /* loaded from: classes7.dex */
    public static final class o implements Function2<KuiklyRenderNativeMethod, List<? extends Object>, Object> {
        o() {
        }

        @Override // kotlin.jvm.functions.Function2
        @Nullable
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Object invoke(@NotNull KuiklyRenderNativeMethod methodId, @NotNull List<? extends Object> args) {
            Intrinsics.checkNotNullParameter(methodId, "methodId");
            Intrinsics.checkNotNullParameter(args, "args");
            return KuiklyRenderCore.this.K(methodId, args);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000'\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002@\u0012\u0013\u0012\u00110\u0002\u00a2\u0006\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\b(\u0005\u0012\u001b\u0012\u0019\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u0006\u00a2\u0006\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\b(\b\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u0001j\u0002`\tJ#\u0010\n\u001a\u0004\u0018\u00010\u00072\u0006\u0010\u0005\u001a\u00020\u00022\u000e\u0010\b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u0006H\u0096\u0002\u00a8\u0006\u000b"}, d2 = {"com/tencent/kuikly/core/render/android/core/KuiklyRenderCore$p", "Lkotlin/Function2;", "Lcom/tencent/kuikly/core/render/android/context/KuiklyRenderNativeMethod;", "Lkotlin/ParameterName;", "name", "methodId", "", "", "args", "Lcom/tencent/kuikly/core/render/android/context/KuiklyRenderNativeMethodCallback;", "a", "core-render-android_debug"}, k = 1, mv = {1, 4, 1})
    /* loaded from: classes7.dex */
    public static final class p implements Function2<KuiklyRenderNativeMethod, List<? extends Object>, Object> {
        p() {
        }

        @Override // kotlin.jvm.functions.Function2
        @Nullable
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Object invoke(@NotNull KuiklyRenderNativeMethod methodId, @NotNull List<? extends Object> args) {
            Intrinsics.checkNotNullParameter(methodId, "methodId");
            Intrinsics.checkNotNullParameter(args, "args");
            return KuiklyRenderCore.this.O(methodId, args);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000'\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002@\u0012\u0013\u0012\u00110\u0002\u00a2\u0006\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\b(\u0005\u0012\u001b\u0012\u0019\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u0006\u00a2\u0006\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\b(\b\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u0001j\u0002`\tJ#\u0010\n\u001a\u0004\u0018\u00010\u00072\u0006\u0010\u0005\u001a\u00020\u00022\u000e\u0010\b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u0006H\u0096\u0002\u00a8\u0006\u000b"}, d2 = {"com/tencent/kuikly/core/render/android/core/KuiklyRenderCore$q", "Lkotlin/Function2;", "Lcom/tencent/kuikly/core/render/android/context/KuiklyRenderNativeMethod;", "Lkotlin/ParameterName;", "name", "methodId", "", "", "args", "Lcom/tencent/kuikly/core/render/android/context/KuiklyRenderNativeMethodCallback;", "a", "core-render-android_debug"}, k = 1, mv = {1, 4, 1})
    /* loaded from: classes7.dex */
    public static final class q implements Function2<KuiklyRenderNativeMethod, List<? extends Object>, Object> {
        q() {
        }

        @Override // kotlin.jvm.functions.Function2
        @Nullable
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Object invoke(@NotNull KuiklyRenderNativeMethod methodId, @NotNull List<? extends Object> args) {
            Intrinsics.checkNotNullParameter(methodId, "methodId");
            Intrinsics.checkNotNullParameter(args, "args");
            return KuiklyRenderCore.this.L(methodId, args);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000'\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002@\u0012\u0013\u0012\u00110\u0002\u00a2\u0006\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\b(\u0005\u0012\u001b\u0012\u0019\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u0006\u00a2\u0006\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\b(\b\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u0001j\u0002`\tJ#\u0010\n\u001a\u0004\u0018\u00010\u00072\u0006\u0010\u0005\u001a\u00020\u00022\u000e\u0010\b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u0006H\u0096\u0002\u00a8\u0006\u000b"}, d2 = {"com/tencent/kuikly/core/render/android/core/KuiklyRenderCore$r", "Lkotlin/Function2;", "Lcom/tencent/kuikly/core/render/android/context/KuiklyRenderNativeMethod;", "Lkotlin/ParameterName;", "name", "methodId", "", "", "args", "Lcom/tencent/kuikly/core/render/android/context/KuiklyRenderNativeMethodCallback;", "a", "core-render-android_debug"}, k = 1, mv = {1, 4, 1})
    /* loaded from: classes7.dex */
    public static final class r implements Function2<KuiklyRenderNativeMethod, List<? extends Object>, Object> {
        r() {
        }

        @Override // kotlin.jvm.functions.Function2
        @Nullable
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Object invoke(@NotNull KuiklyRenderNativeMethod methodId, @NotNull List<? extends Object> args) {
            Intrinsics.checkNotNullParameter(methodId, "methodId");
            Intrinsics.checkNotNullParameter(args, "args");
            return KuiklyRenderCore.this.N(methodId, args);
        }
    }

    public KuiklyRenderCore() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object K(KuiklyRenderNativeMethod method, List<? extends Object> args) {
        SizeF sizeF;
        float f16;
        com.tencent.kuikly.core.render.android.layer.a aVar = this.renderLayerHandler;
        if (aVar != null) {
            sizeF = aVar.k(((Number) com.tencent.kuikly.core.render.android.css.ktx.b.o(args)).intValue(), new SizeF(((Number) com.tencent.kuikly.core.render.android.css.ktx.b.v(args)).floatValue(), ((Number) com.tencent.kuikly.core.render.android.css.ktx.b.d(args)).floatValue()));
        } else {
            sizeF = null;
        }
        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
        Locale locale = Locale.ENGLISH;
        Object[] objArr = new Object[2];
        float f17 = 0.0f;
        if (sizeF != null) {
            f16 = sizeF.getWidth();
        } else {
            f16 = 0.0f;
        }
        objArr[0] = Float.valueOf(f16);
        if (sizeF != null) {
            f17 = sizeF.getHeight();
        }
        objArr[1] = Float.valueOf(f17);
        String format = String.format(locale, "%.2f|%.2f", Arrays.copyOf(objArr, 2));
        Intrinsics.checkNotNullExpressionValue(format, "java.lang.String.format(locale, format, *args)");
        return format;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:10:0x0020  */
    /* JADX WARN: Removed duplicated region for block: B:13:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object L(KuiklyRenderNativeMethod method, List<? extends Object> args) {
        Function1<Object, Unit> function1;
        com.tencent.kuikly.core.render.android.layer.a aVar;
        boolean z16;
        final String str = (String) com.tencent.kuikly.core.render.android.css.ktx.b.b(args);
        if (str != null) {
            if (str.length() > 0) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (z16) {
                function1 = new Function1<Object, Unit>() { // from class: com.tencent.kuikly.core.render.android.core.KuiklyRenderCore$callModuleMethod$callback$1
                    /* JADX INFO: Access modifiers changed from: package-private */
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(Object obj) {
                        invoke2(obj);
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(@Nullable final Object obj) {
                        KuiklyRenderCore.d0(KuiklyRenderCore.this, 0.0f, false, new Function0<Unit>() { // from class: com.tencent.kuikly.core.render.android.core.KuiklyRenderCore$callModuleMethod$callback$1.1
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
                                List<? extends Object> listOf;
                                com.tencent.kuikly.core.render.android.context.b contextHandler = KuiklyRenderCore.this.getContextHandler();
                                if (contextHandler != null) {
                                    KuiklyRenderContextMethod kuiklyRenderContextMethod = KuiklyRenderContextMethod.KuiklyRenderContextMethodFireCallback;
                                    listOf = CollectionsKt__CollectionsKt.listOf(KuiklyRenderCore.this.getInstanceId(), str, obj);
                                    contextHandler.call(kuiklyRenderContextMethod, listOf);
                                }
                            }
                        }, 3, null);
                    }
                };
                aVar = this.renderLayerHandler;
                if (aVar != null) {
                    return null;
                }
                return aVar.f((String) com.tencent.kuikly.core.render.android.css.ktx.b.o(args), (String) com.tencent.kuikly.core.render.android.css.ktx.b.v(args), com.tencent.kuikly.core.render.android.css.ktx.b.d(args), function1);
            }
        }
        function1 = null;
        aVar = this.renderLayerHandler;
        if (aVar != null) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object M(KuiklyRenderNativeMethod method, List<? extends Object> args) {
        com.tencent.kuikly.core.render.android.layer.a aVar = this.renderLayerHandler;
        if (aVar != null) {
            return aVar.q(((Number) com.tencent.kuikly.core.render.android.css.ktx.b.o(args)).intValue(), (String) com.tencent.kuikly.core.render.android.css.ktx.b.v(args), (String) com.tencent.kuikly.core.render.android.css.ktx.b.d(args));
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r11v4, types: [T, com.tencent.kuikly.core.render.android.core.KuiklyRenderCore$callTDFModuleMethod$$inlined$let$lambda$2] */
    /* JADX WARN: Type inference failed for: r13v2, types: [T, com.tencent.kuikly.core.render.android.core.KuiklyRenderCore$callTDFModuleMethod$$inlined$let$lambda$1] */
    /* JADX WARN: Type inference failed for: r2v0, types: [T, java.lang.CharSequence, java.lang.Object, java.lang.String] */
    public final Object N(KuiklyRenderNativeMethod method, List<? extends Object> args) {
        boolean z16;
        final Ref.ObjectRef objectRef = new Ref.ObjectRef();
        objectRef.element = null;
        final Ref.ObjectRef objectRef2 = new Ref.ObjectRef();
        objectRef2.element = null;
        final Ref.ObjectRef objectRef3 = new Ref.ObjectRef();
        objectRef3.element = null;
        String str = (String) com.tencent.kuikly.core.render.android.css.ktx.b.b(args);
        if (str != null) {
            JSONObject jSONObject = new JSONObject(str);
            final ?? successCallbackId = jSONObject.optString(MeasureConst.SLI_TYPE_SUCCESS);
            objectRef3.element = successCallbackId;
            final String errorCallbackId = jSONObject.optString("error");
            Intrinsics.checkNotNullExpressionValue(successCallbackId, "successCallbackId");
            boolean z17 = true;
            if (successCallbackId.length() > 0) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (z16) {
                objectRef.element = new Function1<Object, Unit>() { // from class: com.tencent.kuikly.core.render.android.core.KuiklyRenderCore$callTDFModuleMethod$$inlined$let$lambda$1
                    /* JADX INFO: Access modifiers changed from: package-private */
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(Object obj) {
                        invoke2(obj);
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(@Nullable final Object obj) {
                        KuiklyRenderCore.d0(this, 0.0f, false, new Function0<Unit>() { // from class: com.tencent.kuikly.core.render.android.core.KuiklyRenderCore$callTDFModuleMethod$$inlined$let$lambda$1.1
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
                                List<? extends Object> listOf;
                                com.tencent.kuikly.core.render.android.context.b contextHandler = this.getContextHandler();
                                if (contextHandler != null) {
                                    KuiklyRenderContextMethod kuiklyRenderContextMethod = KuiklyRenderContextMethod.KuiklyRenderContextMethodFireCallback;
                                    listOf = CollectionsKt__CollectionsKt.listOf(this.getInstanceId(), successCallbackId, obj);
                                    contextHandler.call(kuiklyRenderContextMethod, listOf);
                                }
                            }
                        }, 3, null);
                    }
                };
            }
            Intrinsics.checkNotNullExpressionValue(errorCallbackId, "errorCallbackId");
            if (errorCallbackId.length() <= 0) {
                z17 = false;
            }
            if (z17) {
                objectRef2.element = new Function1<Object, Unit>() { // from class: com.tencent.kuikly.core.render.android.core.KuiklyRenderCore$callTDFModuleMethod$$inlined$let$lambda$2
                    /* JADX INFO: Access modifiers changed from: package-private */
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(Object obj) {
                        invoke2(obj);
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(@Nullable final Object obj) {
                        KuiklyRenderCore.d0(this, 0.0f, false, new Function0<Unit>() { // from class: com.tencent.kuikly.core.render.android.core.KuiklyRenderCore$callTDFModuleMethod$$inlined$let$lambda$2.1
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
                                List<? extends Object> listOf;
                                com.tencent.kuikly.core.render.android.context.b contextHandler = this.getContextHandler();
                                if (contextHandler != null) {
                                    KuiklyRenderContextMethod kuiklyRenderContextMethod = KuiklyRenderContextMethod.KuiklyRenderContextMethodFireCallback;
                                    listOf = CollectionsKt__CollectionsKt.listOf(this.getInstanceId(), errorCallbackId, obj);
                                    contextHandler.call(kuiklyRenderContextMethod, listOf);
                                }
                            }
                        }, 3, null);
                    }
                };
            }
        }
        com.tencent.kuikly.core.render.android.layer.a aVar = this.renderLayerHandler;
        if (aVar == null) {
            return null;
        }
        return aVar.j((String) com.tencent.kuikly.core.render.android.css.ktx.b.o(args), (String) com.tencent.kuikly.core.render.android.css.ktx.b.v(args), (String) com.tencent.kuikly.core.render.android.css.ktx.b.d(args), (String) objectRef3.element, (Function1) objectRef.element, (Function1) objectRef2.element);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:10:0x0020  */
    /* JADX WARN: Removed duplicated region for block: B:13:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object O(KuiklyRenderNativeMethod method, List<? extends Object> args) {
        Function1<Object, Unit> function1;
        com.tencent.kuikly.core.render.android.layer.a aVar;
        boolean z16;
        final String str = (String) com.tencent.kuikly.core.render.android.css.ktx.b.b(args);
        if (str != null) {
            if (str.length() > 0) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (z16) {
                function1 = new Function1<Object, Unit>() { // from class: com.tencent.kuikly.core.render.android.core.KuiklyRenderCore$callViewMethod$callback$1
                    /* JADX INFO: Access modifiers changed from: package-private */
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(Object obj) {
                        invoke2(obj);
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(@Nullable final Object obj) {
                        KuiklyRenderCore.d0(KuiklyRenderCore.this, 0.0f, false, new Function0<Unit>() { // from class: com.tencent.kuikly.core.render.android.core.KuiklyRenderCore$callViewMethod$callback$1.1
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
                                List<? extends Object> listOf;
                                com.tencent.kuikly.core.render.android.context.b contextHandler = KuiklyRenderCore.this.getContextHandler();
                                if (contextHandler != null) {
                                    KuiklyRenderContextMethod kuiklyRenderContextMethod = KuiklyRenderContextMethod.KuiklyRenderContextMethodFireCallback;
                                    listOf = CollectionsKt__CollectionsKt.listOf(KuiklyRenderCore.this.getInstanceId(), str, obj);
                                    contextHandler.call(kuiklyRenderContextMethod, listOf);
                                }
                            }
                        }, 3, null);
                    }
                };
                aVar = this.renderLayerHandler;
                if (aVar != null) {
                    return null;
                }
                aVar.r(((Number) com.tencent.kuikly.core.render.android.css.ktx.b.o(args)).intValue(), (String) com.tencent.kuikly.core.render.android.css.ktx.b.v(args), (String) com.tencent.kuikly.core.render.android.css.ktx.b.d(args), function1);
                return Unit.INSTANCE;
            }
        }
        function1 = null;
        aVar = this.renderLayerHandler;
        if (aVar != null) {
        }
    }

    private final com.tencent.kuikly.core.render.android.layer.a P(com.tencent.kuikly.core.render.android.d renderView, KuiklyContextParams contextParams) {
        String str;
        boolean z16;
        com.tencent.kuikly.core.render.android.core.c cVar = this.coreDelegate;
        if (cVar != null) {
            str = cVar.V0();
        } else {
            str = null;
        }
        if (str != null) {
            if (str.length() > 0) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (z16) {
                KuiklyTurboDisplayRenderLayerHandler kuiklyTurboDisplayRenderLayerHandler = new KuiklyTurboDisplayRenderLayerHandler();
                kuiklyTurboDisplayRenderLayerHandler.I(renderView, contextParams, str);
                kuiklyTurboDisplayRenderLayerHandler.M(this.uiScheduler);
                return kuiklyTurboDisplayRenderLayerHandler;
            }
        }
        KuiklyRenderLayerHandler kuiklyRenderLayerHandler = new KuiklyRenderLayerHandler();
        kuiklyRenderLayerHandler.C(renderView, contextParams);
        return kuiklyRenderLayerHandler;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object Q(KuiklyRenderNativeMethod method, List<? extends Object> args) {
        com.tencent.kuikly.core.render.android.layer.a aVar = this.renderLayerHandler;
        if (aVar != null) {
            aVar.s(((Number) com.tencent.kuikly.core.render.android.css.ktx.b.o(args)).intValue(), (String) com.tencent.kuikly.core.render.android.css.ktx.b.v(args));
            return Unit.INSTANCE;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object R(KuiklyRenderNativeMethod method, List<? extends Object> args) {
        com.tencent.kuikly.core.render.android.layer.a aVar = this.renderLayerHandler;
        if (aVar != null) {
            aVar.c(((Number) com.tencent.kuikly.core.render.android.css.ktx.b.o(args)).intValue(), (String) com.tencent.kuikly.core.render.android.css.ktx.b.v(args));
            return Unit.INSTANCE;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object S(KuiklyRenderNativeMethod method, List<? extends Object> args) {
        Object o16 = com.tencent.kuikly.core.render.android.css.ktx.b.o(args);
        if (!(o16 instanceof String)) {
            o16 = null;
        }
        String str = (String) o16;
        if (str == null) {
            str = "";
        }
        KRKotlinBizException kRKotlinBizException = new KRKotlinBizException(str);
        com.tencent.kuikly.core.render.android.exception.a aVar = this.exceptionListener;
        if (aVar != null) {
            aVar.b(kRKotlinBizException, ErrorReason.CALL_KOTLIN);
        }
        return null;
    }

    private final void W() {
        this.nativeMethodRegistry.put(KuiklyRenderNativeMethod.KuiklyRenderNativeMethodCreateRenderView.getValue(), new j());
        this.nativeMethodRegistry.put(KuiklyRenderNativeMethod.KuiklyRenderNativeMethodRemoveRenderView.getValue(), new k());
        this.nativeMethodRegistry.put(KuiklyRenderNativeMethod.KuiklyRenderNativeMethodInsertSubRenderView.getValue(), new l());
        this.nativeMethodRegistry.put(KuiklyRenderNativeMethod.KuiklyRenderNativeMethodSetViewProp.getValue(), new m());
        this.nativeMethodRegistry.put(KuiklyRenderNativeMethod.KuiklyRenderNativeMethodSetRenderViewFrame.getValue(), new n());
        this.nativeMethodRegistry.put(KuiklyRenderNativeMethod.KuiklyRenderNativeMethodCalculateRenderViewSize.getValue(), new o());
        this.nativeMethodRegistry.put(KuiklyRenderNativeMethod.KuiklyRenderNativeMethodCallViewMethod.getValue(), new p());
        this.nativeMethodRegistry.put(KuiklyRenderNativeMethod.KuiklyRenderNativeMethodCallModuleMethod.getValue(), new q());
        this.nativeMethodRegistry.put(KuiklyRenderNativeMethod.KuiklyRenderNativeMethodCallTDFNativeMethod.getValue(), new r());
        this.nativeMethodRegistry.put(KuiklyRenderNativeMethod.KuiklyRenderNativeMethodCreateShadow.getValue(), new b());
        this.nativeMethodRegistry.put(KuiklyRenderNativeMethod.KuiklyRenderNativeMethodRemoveShadow.getValue(), new c());
        this.nativeMethodRegistry.put(KuiklyRenderNativeMethod.KuiklyRenderNativeMethodSetShadowProp.getValue(), new d());
        this.nativeMethodRegistry.put(KuiklyRenderNativeMethod.KuiklyRenderNativeMethodSetShadowForView.getValue(), new e());
        this.nativeMethodRegistry.put(KuiklyRenderNativeMethod.KuiklyRenderNativeMethodSetTimeout.getValue(), new f());
        this.nativeMethodRegistry.put(KuiklyRenderNativeMethod.KuiklyRenderNativeMethodCallShadowMethod.getValue(), new g());
        this.nativeMethodRegistry.put(KuiklyRenderNativeMethod.KuiklyRenderNativeMethodFireFatalException.getValue(), new h());
        this.nativeMethodRegistry.put(KuiklyRenderNativeMethod.KuiklyRenderNativeMethodSyncFlushUI.getValue(), new i());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object X(KuiklyRenderNativeMethod method, List<? extends Object> args) {
        com.tencent.kuikly.core.render.android.layer.a aVar = this.renderLayerHandler;
        if (aVar != null) {
            aVar.l(((Number) com.tencent.kuikly.core.render.android.css.ktx.b.o(args)).intValue(), ((Number) com.tencent.kuikly.core.render.android.css.ktx.b.v(args)).intValue(), ((Number) com.tencent.kuikly.core.render.android.css.ktx.b.d(args)).intValue());
            return Unit.INSTANCE;
        }
        return null;
    }

    private final boolean Y(List<? extends Object> args) {
        Integer num = (Integer) com.tencent.kuikly.core.render.android.css.ktx.b.b(args);
        if (num != null && num.intValue() == 1) {
            return true;
        }
        return false;
    }

    /* JADX WARN: Removed duplicated region for block: B:41:0x004c  */
    /* JADX WARN: Removed duplicated region for block: B:43:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final boolean Z(KuiklyRenderNativeMethod method, List<? extends Object> args) {
        int i3;
        if (method != KuiklyRenderNativeMethod.KuiklyRenderNativeMethodCallModuleMethod && method != KuiklyRenderNativeMethod.KuiklyRenderNativeMethodCallTDFNativeMethod) {
            if (method == KuiklyRenderNativeMethod.KuiklyRenderNativeMethodCalculateRenderViewSize || method == KuiklyRenderNativeMethod.KuiklyRenderNativeMethodCreateShadow || method == KuiklyRenderNativeMethod.KuiklyRenderNativeMethodRemoveShadow || method == KuiklyRenderNativeMethod.KuiklyRenderNativeMethodSetShadowForView || method == KuiklyRenderNativeMethod.KuiklyRenderNativeMethodSetShadowProp || method == KuiklyRenderNativeMethod.KuiklyRenderNativeMethodSetTimeout || method == KuiklyRenderNativeMethod.KuiklyRenderNativeMethodCallShadowMethod || method == KuiklyRenderNativeMethod.KuiklyRenderNativeMethodSyncFlushUI) {
                return true;
            }
            return false;
        }
        if (args.size() >= 6) {
            Object obj = args.get(5);
            if (!(obj instanceof Integer)) {
                obj = null;
            }
            Integer num = (Integer) obj;
            if (num != null) {
                i3 = num.intValue();
                if (i3 != 1) {
                    return true;
                }
                return false;
            }
        }
        i3 = 0;
        if (i3 != 1) {
        }
    }

    private final boolean a0(KuiklyRenderNativeMethod method) {
        if (method != KuiklyRenderNativeMethod.KuiklyRenderNativeMethodCreateRenderView && method != KuiklyRenderNativeMethod.KuiklyRenderNativeMethodRemoveRenderView && method != KuiklyRenderNativeMethod.KuiklyRenderNativeMethodInsertSubRenderView && method != KuiklyRenderNativeMethod.KuiklyRenderNativeMethodSetViewProp && method != KuiklyRenderNativeMethod.KuiklyRenderNativeMethodSetRenderViewFrame) {
            return false;
        }
        return true;
    }

    private final Object b0(final KuiklyRenderNativeMethod method, final List<? extends Object> args) {
        final Function2<KuiklyRenderNativeMethod, List<? extends Object>, Object> function2 = this.nativeMethodRegistry.get(method.getValue());
        if (function2 != null) {
            KuiklyRenderThreadManager.f118203b.a(this.contextParams);
            if (Z(method, args)) {
                return function2.invoke(method, args);
            }
            KuiklyRenderCoreUIScheduler kuiklyRenderCoreUIScheduler = this.uiScheduler;
            if (kuiklyRenderCoreUIScheduler != null) {
                KuiklyRenderCoreUIScheduler.v(kuiklyRenderCoreUIScheduler, 0L, a0(method), new Function0<Unit>() { // from class: com.tencent.kuikly.core.render.android.core.KuiklyRenderCore$performNativeMethodWithMethod$$inlined$also$lambda$1
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
                        Function2.this.invoke(method, args);
                    }
                }, 1, null);
                return null;
            }
            return null;
        }
        return null;
    }

    private final void c0(float delayMs, boolean sync, Function0<Unit> task) {
        long j3;
        Long K0;
        KuiklyContextParams kuiklyContextParams = this.contextParams;
        if (kuiklyContextParams != null) {
            com.tencent.kuikly.core.render.android.core.c cVar = this.coreDelegate;
            if (cVar != null && (K0 = cVar.K0()) != null) {
                j3 = K0.longValue();
            } else {
                j3 = 500;
            }
            KuiklyRenderThreadManager.f118203b.h(kuiklyContextParams, task, delayMs, sync, j3);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void d0(KuiklyRenderCore kuiklyRenderCore, float f16, boolean z16, Function0 function0, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            f16 = 0.0f;
        }
        if ((i3 & 2) != 0) {
            z16 = false;
        }
        kuiklyRenderCore.c0(f16, z16, function0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object e0(KuiklyRenderNativeMethod method, List<? extends Object> args) {
        com.tencent.kuikly.core.render.android.layer.a aVar = this.renderLayerHandler;
        if (aVar != null) {
            aVar.u(((Number) com.tencent.kuikly.core.render.android.css.ktx.b.o(args)).intValue());
            return Unit.INSTANCE;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object f0(KuiklyRenderNativeMethod method, List<? extends Object> args) {
        com.tencent.kuikly.core.render.android.layer.a aVar = this.renderLayerHandler;
        if (aVar != null) {
            aVar.d(((Number) com.tencent.kuikly.core.render.android.css.ktx.b.o(args)).intValue());
            return Unit.INSTANCE;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v1, types: [com.tencent.kuikly.core.render.android.core.KuiklyRenderCore$sam$java_lang_Runnable$0] */
    public final void g0(final Function0<Unit> task) {
        Handler handler = new Handler(Looper.getMainLooper());
        if (task != null) {
            task = new Runnable() { // from class: com.tencent.kuikly.core.render.android.core.KuiklyRenderCore$sam$java_lang_Runnable$0
                @Override // java.lang.Runnable
                public final /* synthetic */ void run() {
                    Intrinsics.checkNotNullExpressionValue(Function0.this.invoke(), "invoke(...)");
                }
            };
        }
        handler.post((Runnable) task);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object i0(KuiklyRenderNativeMethod method, List<? extends Object> args) {
        RectF rectF = new RectF(((Number) com.tencent.kuikly.core.render.android.css.ktx.b.v(args)).floatValue(), ((Number) com.tencent.kuikly.core.render.android.css.ktx.b.d(args)).floatValue(), ((Number) com.tencent.kuikly.core.render.android.css.ktx.b.b(args)).floatValue(), ((Number) com.tencent.kuikly.core.render.android.css.ktx.b.q(args)).floatValue());
        com.tencent.kuikly.core.render.android.layer.a aVar = this.renderLayerHandler;
        if (aVar != null) {
            aVar.h(((Number) com.tencent.kuikly.core.render.android.css.ktx.b.o(args)).intValue(), rectF);
            return Unit.INSTANCE;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object j0(KuiklyRenderNativeMethod method, final List<? extends Object> args) {
        final i01.b o16;
        KuiklyRenderCoreUIScheduler kuiklyRenderCoreUIScheduler;
        com.tencent.kuikly.core.render.android.layer.a aVar = this.renderLayerHandler;
        if (aVar != null && (o16 = aVar.o(((Number) com.tencent.kuikly.core.render.android.css.ktx.b.o(args)).intValue())) != null && (kuiklyRenderCoreUIScheduler = this.uiScheduler) != null) {
            a.C5875a.a(kuiklyRenderCoreUIScheduler, 0L, new Function0<Unit>() { // from class: com.tencent.kuikly.core.render.android.core.KuiklyRenderCore$setShadow$1
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
                    com.tencent.kuikly.core.render.android.layer.a aVar2;
                    aVar2 = KuiklyRenderCore.this.renderLayerHandler;
                    if (aVar2 != null) {
                        aVar2.i(((Number) com.tencent.kuikly.core.render.android.css.ktx.b.o(args)).intValue(), o16);
                    }
                }
            }, 1, null);
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object k0(KuiklyRenderNativeMethod method, List<? extends Object> args) {
        com.tencent.kuikly.core.render.android.layer.a aVar = this.renderLayerHandler;
        if (aVar != null) {
            aVar.t(((Number) com.tencent.kuikly.core.render.android.css.ktx.b.o(args)).intValue(), (String) com.tencent.kuikly.core.render.android.css.ktx.b.v(args), com.tencent.kuikly.core.render.android.css.ktx.b.d(args));
            return Unit.INSTANCE;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object l0(KuiklyRenderNativeMethod method, List<? extends Object> args) {
        c0(((Number) com.tencent.kuikly.core.render.android.css.ktx.b.o(args)).floatValue(), false, new com.tencent.kuikly.core.render.android.core.e(this, com.tencent.kuikly.core.render.android.css.ktx.b.v(args)));
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object m0(KuiklyRenderNativeMethod method, List<? extends Object> args) {
        Object d16 = com.tencent.kuikly.core.render.android.css.ktx.b.d(args);
        if (Y(args)) {
            int intValue = ((Number) com.tencent.kuikly.core.render.android.css.ktx.b.o(args)).intValue();
            boolean z16 = true;
            if (((Number) com.tencent.kuikly.core.render.android.css.ktx.b.q(args)).intValue() != 1) {
                z16 = false;
            }
            d16 = new KuiklyRenderCore$setViewProp$1(this, z16, intValue, args);
        }
        com.tencent.kuikly.core.render.android.layer.a aVar = this.renderLayerHandler;
        if (aVar != null) {
            aVar.p(((Number) com.tencent.kuikly.core.render.android.css.ktx.b.o(args)).intValue(), (String) com.tencent.kuikly.core.render.android.css.ktx.b.v(args), d16);
            return Unit.INSTANCE;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object n0(KuiklyRenderNativeMethod method, List<? extends Object> args) {
        KuiklyRenderCoreUIScheduler kuiklyRenderCoreUIScheduler = this.uiScheduler;
        if (kuiklyRenderCoreUIScheduler != null) {
            KuiklyRenderCoreUIScheduler.q(kuiklyRenderCoreUIScheduler, false, false, 2, null);
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean o0(Object result) {
        if (!(result instanceof Map)) {
            return false;
        }
        return Intrinsics.areEqual(((Map) result).get("kr_sync_callback_key"), (Object) 1);
    }

    @Nullable
    /* renamed from: T, reason: from getter */
    public final com.tencent.kuikly.core.render.android.context.b getContextHandler() {
        return this.contextHandler;
    }

    @NotNull
    /* renamed from: U, reason: from getter */
    public final String getInstanceId() {
        return this.instanceId;
    }

    public final void V(@NotNull String contextCode, @NotNull String url, @NotNull Map<String, ? extends Object> params, @NotNull a initCallback) {
        List<? extends Object> listOf;
        Intrinsics.checkNotNullParameter(contextCode, "contextCode");
        Intrinsics.checkNotNullParameter(url, "url");
        Intrinsics.checkNotNullParameter(params, "params");
        Intrinsics.checkNotNullParameter(initCallback, "initCallback");
        KuiklyRenderThreadManager kuiklyRenderThreadManager = KuiklyRenderThreadManager.f118203b;
        kuiklyRenderThreadManager.a(this.contextParams);
        if (this.contextHandler == null) {
            this.contextHandler = new com.tencent.kuikly.core.render.android.context.h();
        }
        com.tencent.kuikly.core.render.android.context.b bVar = this.contextHandler;
        if (bVar != null) {
            bVar.setRenderExceptionListener(this.exceptionListener);
            bVar.registerCallNative(this);
            initCallback.onStart();
            bVar.init(contextCode);
            initCallback.onFinish();
            initCallback.c();
            boolean d16 = kuiklyRenderThreadManager.d();
            KuiklyRenderContextMethod kuiklyRenderContextMethod = KuiklyRenderContextMethod.KuiklyRenderContextMethodCreateInstance;
            listOf = CollectionsKt__CollectionsKt.listOf(this.instanceId, url, params, Integer.valueOf(d16 ? 1 : 0));
            bVar.call(kuiklyRenderContextMethod, listOf);
            initCallback.a();
        }
        this.initContextHandlerTask = null;
    }

    @Override // com.tencent.kuikly.core.render.android.core.b
    @Nullable
    public <T extends i01.a> T a(@NotNull String name) {
        Intrinsics.checkNotNullParameter(name, "name");
        com.tencent.kuikly.core.render.android.layer.a aVar = this.renderLayerHandler;
        if (aVar != null) {
            return (T) aVar.a(name);
        }
        return null;
    }

    @Override // com.tencent.kuikly.core.render.android.core.b
    @Nullable
    public View b(int tag) {
        com.tencent.kuikly.core.render.android.layer.a aVar = this.renderLayerHandler;
        if (aVar != null) {
            return aVar.b(tag);
        }
        return null;
    }

    @Override // com.tencent.kuikly.core.render.android.core.b
    public void c(@NotNull Function0<Unit> task) {
        Intrinsics.checkNotNullParameter(task, "task");
        KuiklyRenderCoreUIScheduler kuiklyRenderCoreUIScheduler = this.uiScheduler;
        if (kuiklyRenderCoreUIScheduler != null) {
            kuiklyRenderCoreUIScheduler.s(task);
        }
    }

    @Override // com.tencent.kuikly.core.render.android.core.b
    public void d(@NotNull final String event, @NotNull final Object data) {
        Intrinsics.checkNotNullParameter(event, "event");
        Intrinsics.checkNotNullParameter(data, "data");
        d0(this, 0.0f, false, new Function0<Unit>() { // from class: com.tencent.kuikly.core.render.android.core.KuiklyRenderCore$sendEvent$1
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
                List<? extends Object> listOf;
                com.tencent.kuikly.core.render.android.context.b contextHandler = KuiklyRenderCore.this.getContextHandler();
                if (contextHandler != null) {
                    KuiklyRenderContextMethod kuiklyRenderContextMethod = KuiklyRenderContextMethod.KuiklyRenderContextMethodUpdateInstance;
                    listOf = CollectionsKt__CollectionsKt.listOf(KuiklyRenderCore.this.getInstanceId(), event, data);
                    contextHandler.call(kuiklyRenderContextMethod, listOf);
                }
            }
        }, 3, null);
    }

    @Override // com.tencent.kuikly.core.render.android.core.b
    public void destroy() {
        g0(new Function0<Unit>() { // from class: com.tencent.kuikly.core.render.android.core.KuiklyRenderCore$destroy$1
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
                com.tencent.kuikly.core.render.android.layer.a aVar;
                aVar = KuiklyRenderCore.this.renderLayerHandler;
                if (aVar != null) {
                    aVar.n();
                }
            }
        });
        d0(this, 0.0f, false, new Function0<Unit>() { // from class: com.tencent.kuikly.core.render.android.core.KuiklyRenderCore$destroy$2
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
                List<? extends Object> listOf;
                com.tencent.kuikly.core.render.android.context.b contextHandler = KuiklyRenderCore.this.getContextHandler();
                if (contextHandler != null) {
                    KuiklyRenderContextMethod kuiklyRenderContextMethod = KuiklyRenderContextMethod.KuiklyRenderContextMethodDestroyInstance;
                    listOf = CollectionsKt__CollectionsJVMKt.listOf(KuiklyRenderCore.this.getInstanceId());
                    contextHandler.call(kuiklyRenderContextMethod, listOf);
                }
                com.tencent.kuikly.core.render.android.context.b contextHandler2 = KuiklyRenderCore.this.getContextHandler();
                if (contextHandler2 != null) {
                    contextHandler2.destroy();
                }
                KuiklyRenderCore.this.g0(new Function0<Unit>() { // from class: com.tencent.kuikly.core.render.android.core.KuiklyRenderCore$destroy$2.1
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
                        com.tencent.kuikly.core.render.android.layer.a aVar;
                        aVar = KuiklyRenderCore.this.renderLayerHandler;
                        if (aVar != null) {
                            aVar.onDestroy();
                        }
                    }
                });
            }
        }, 3, null);
        KuiklyRenderCoreUIScheduler kuiklyRenderCoreUIScheduler = this.uiScheduler;
        if (kuiklyRenderCoreUIScheduler != null) {
            kuiklyRenderCoreUIScheduler.i();
        }
        this.exceptionListener = null;
        com.tencent.kuikly.core.render.android.core.d dVar = this.initContextHandlerTask;
        if (dVar != null) {
            dVar.a();
        }
        this.initContextHandlerTask = null;
    }

    @Override // com.tencent.kuikly.core.render.android.core.b
    public void e() {
        com.tencent.kuikly.core.render.android.layer.a aVar = this.renderLayerHandler;
        if (aVar != null) {
            aVar.e();
        }
    }

    @Override // com.tencent.kuikly.core.render.android.core.b
    public void f() {
        d0(this, 0.0f, false, new Function0<Unit>() { // from class: com.tencent.kuikly.core.render.android.core.KuiklyRenderCore$asyncFlushFirstScreenUITasksToQueue$1
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
                KuiklyRenderCoreUIScheduler kuiklyRenderCoreUIScheduler;
                kuiklyRenderCoreUIScheduler = KuiklyRenderCore.this.uiScheduler;
                if (kuiklyRenderCoreUIScheduler != null) {
                    kuiklyRenderCoreUIScheduler.p(true, true);
                }
            }
        }, 3, null);
    }

    @Override // com.tencent.kuikly.core.render.android.core.b
    public void g() {
        KuiklyRenderCoreUIScheduler kuiklyRenderCoreUIScheduler = this.uiScheduler;
        if (kuiklyRenderCoreUIScheduler != null) {
            kuiklyRenderCoreUIScheduler.m();
        }
    }

    @Override // com.tencent.kuikly.core.render.android.context.c
    @Nullable
    public Object h(@NotNull KuiklyRenderNativeMethod methodId, @NotNull List<? extends Object> args) {
        Intrinsics.checkNotNullParameter(methodId, "methodId");
        Intrinsics.checkNotNullParameter(args, "args");
        KuiklyRenderThreadManager.f118203b.a(this.contextParams);
        return b0(methodId, args);
    }

    public void h0(@NotNull com.tencent.kuikly.core.render.android.exception.a listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        this.exceptionListener = listener;
    }

    @Override // com.tencent.kuikly.core.render.android.core.b
    public void i(@NotNull com.tencent.kuikly.core.render.android.context.a listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        com.tencent.kuikly.core.render.android.context.b bVar = this.contextHandler;
        if (bVar != null) {
            bVar.setBridgeStatusListener(listener);
        }
    }

    @Override // com.tencent.kuikly.core.render.android.core.b
    public void j(@NotNull com.tencent.kuikly.core.render.android.f listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        KuiklyRenderCoreUIScheduler kuiklyRenderCoreUIScheduler = this.uiScheduler;
        if (kuiklyRenderCoreUIScheduler != null) {
            kuiklyRenderCoreUIScheduler.z(listener);
        }
    }

    @Override // com.tencent.kuikly.core.render.android.core.b
    public void k(@NotNull com.tencent.kuikly.core.render.android.layer.b initCallback) {
        Intrinsics.checkNotNullParameter(initCallback, "initCallback");
        com.tencent.kuikly.core.render.android.layer.a aVar = this.renderLayerHandler;
        if (aVar != null) {
            aVar.m(initCallback);
        }
    }

    @Override // com.tencent.kuikly.core.render.android.core.b
    public void l(@NotNull com.tencent.kuikly.core.render.android.d renderView, @NotNull String contextCode, @NotNull String url, @NotNull Map<String, ? extends Object> params, @Nullable String assetsPath, @NotNull KuiklyContextParams contextParams, @NotNull a contextInitCallback, @NotNull com.tencent.kuikly.core.render.android.core.c renderCoreDelegate) {
        Intrinsics.checkNotNullParameter(renderView, "renderView");
        Intrinsics.checkNotNullParameter(contextCode, "contextCode");
        Intrinsics.checkNotNullParameter(url, "url");
        Intrinsics.checkNotNullParameter(params, "params");
        Intrinsics.checkNotNullParameter(contextParams, "contextParams");
        Intrinsics.checkNotNullParameter(contextInitCallback, "contextInitCallback");
        Intrinsics.checkNotNullParameter(renderCoreDelegate, "renderCoreDelegate");
        this.contextParams = contextParams;
        this.coreDelegate = renderCoreDelegate;
        KuiklyRenderCoreUIScheduler kuiklyRenderCoreUIScheduler = new KuiklyRenderCoreUIScheduler(contextParams, new Function0<Unit>() { // from class: com.tencent.kuikly.core.render.android.core.KuiklyRenderCore$init$1
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
                List<? extends Object> listOf;
                com.tencent.kuikly.core.render.android.context.b contextHandler = KuiklyRenderCore.this.getContextHandler();
                if (contextHandler != null) {
                    KuiklyRenderContextMethod kuiklyRenderContextMethod = KuiklyRenderContextMethod.KuiklyRenderContextMethodLayoutView;
                    listOf = CollectionsKt__CollectionsJVMKt.listOf(KuiklyRenderCore.this.getInstanceId());
                    contextHandler.call(kuiklyRenderContextMethod, listOf);
                }
            }
        });
        kuiklyRenderCoreUIScheduler.w(renderCoreDelegate.c1());
        kuiklyRenderCoreUIScheduler.y(this.exceptionListener);
        Unit unit = Unit.INSTANCE;
        this.uiScheduler = kuiklyRenderCoreUIScheduler;
        this.renderLayerHandler = P(renderView, contextParams);
        W();
        com.tencent.kuikly.core.render.android.core.d dVar = new com.tencent.kuikly.core.render.android.core.d(this, contextInitCallback, contextCode, url, params);
        this.initContextHandlerTask = dVar;
        if (contextParams.e()) {
            this.instanceId = "100000000";
        }
        contextParams.f(this.instanceId);
        if (contextParams.d()) {
            dVar.b();
        } else {
            c0(0.0f, false, dVar);
        }
    }

    @Override // com.tencent.kuikly.core.render.android.core.b
    public void m() {
        d0(this, 0.0f, true, new Function0<Unit>() { // from class: com.tencent.kuikly.core.render.android.core.KuiklyRenderCore$syncFlushAllRenderTasks$1
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
                KuiklyRenderCoreUIScheduler kuiklyRenderCoreUIScheduler;
                kuiklyRenderCoreUIScheduler = KuiklyRenderCore.this.uiScheduler;
                if (kuiklyRenderCoreUIScheduler != null) {
                    KuiklyRenderCoreUIScheduler.q(kuiklyRenderCoreUIScheduler, true, false, 2, null);
                }
            }
        }, 1, null);
        KuiklyRenderCoreUIScheduler kuiklyRenderCoreUIScheduler = this.uiScheduler;
        if (kuiklyRenderCoreUIScheduler != null) {
            kuiklyRenderCoreUIScheduler.n();
        }
    }

    public KuiklyRenderCore(@Nullable com.tencent.kuikly.core.render.android.context.b bVar) {
        this.contextHandler = bVar;
        long j3 = f117543k;
        f117543k = 1 + j3;
        this.instanceId = String.valueOf(j3);
        this.nativeMethodRegistry = new SparseArray<>();
    }

    public /* synthetic */ KuiklyRenderCore(com.tencent.kuikly.core.render.android.context.b bVar, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? null : bVar);
    }
}

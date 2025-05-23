package com.tencent.kuikly.core.render.android.expand;

import android.content.Context;
import android.content.Intent;
import android.util.Size;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.annotation.UiThread;
import androidx.exifinterface.media.ExifInterface;
import com.huawei.hms.support.hianalytics.HiAnalyticsConstant;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.common.ParseCommon;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.kuikly.core.pager.Pager;
import com.tencent.kuikly.core.render.android.KuiklyRenderView;
import com.tencent.kuikly.core.render.android.b;
import com.tencent.kuikly.core.render.android.context.KuiklyRenderCoreExecuteMode;
import com.tencent.kuikly.core.render.android.e;
import com.tencent.kuikly.core.render.android.exception.ErrorReason;
import com.tencent.kuikly.core.render.android.expand.a;
import com.tencent.kuikly.core.render.android.expand.component.KRAPNGView;
import com.tencent.kuikly.core.render.android.expand.component.KRActivityIndicatorView;
import com.tencent.kuikly.core.render.android.expand.component.KRCanvasView;
import com.tencent.kuikly.core.render.android.expand.component.KRHoverView;
import com.tencent.kuikly.core.render.android.expand.component.KRImageView;
import com.tencent.kuikly.core.render.android.expand.component.KRMaskView;
import com.tencent.kuikly.core.render.android.expand.component.KRModalView;
import com.tencent.kuikly.core.render.android.expand.component.KRRichTextShadow;
import com.tencent.kuikly.core.render.android.expand.component.KRRichTextView;
import com.tencent.kuikly.core.render.android.expand.component.KRSnapshotView;
import com.tencent.kuikly.core.render.android.expand.component.KRTextAreaView;
import com.tencent.kuikly.core.render.android.expand.component.KRTextFieldView;
import com.tencent.kuikly.core.render.android.expand.component.KRVideoView;
import com.tencent.kuikly.core.render.android.expand.component.KRView;
import com.tencent.kuikly.core.render.android.expand.component.KRWrapperImageView;
import com.tencent.kuikly.core.render.android.expand.component.blur.KRBlurView;
import com.tencent.kuikly.core.render.android.expand.component.list.KRRecyclerContentView;
import com.tencent.kuikly.core.render.android.expand.component.lottie.KRLottieView;
import com.tencent.kuikly.core.render.android.expand.component.pag.KRPAGView;
import com.tencent.kuikly.core.render.android.expand.module.KRLogModule;
import com.tencent.kuikly.core.render.android.expand.module.KRNetworkModule;
import com.tencent.kuikly.core.render.android.expand.module.KRReflectionModule;
import com.tencent.kuikly.core.render.android.expand.module.KRSQLiteModule;
import com.tencent.kuikly.core.render.android.expand.module.KRSnapshotModule;
import com.tencent.kuikly.core.render.android.expand.module.KRTurboDisplayModule;
import com.tencent.kuikly.core.render.android.expand.module.b;
import com.tencent.kuikly.core.render.android.expand.module.c;
import com.tencent.kuikly.core.render.android.expand.module.f;
import com.tencent.kuikly.core.render.android.expand.module.g;
import com.tencent.kuikly.core.render.android.expand.module.j;
import com.tencent.kuikly.core.render.android.expand.module.k;
import com.tencent.kuikly.core.render.android.expand.module.m;
import com.tencent.kuikly.core.render.android.expand.module.q;
import com.tencent.kuikly.core.render.android.performace.KRMonitorType;
import com.tencent.kuikly.core.render.android.performace.KRPerformanceManager;
import com.tencent.kuikly.core.render.android.performace.frame.d;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mobileqq.zplan.scheme.ISchemeApi;
import com.tencent.qqmini.sdk.launcher.MiniSDKConst;
import cooperation.qzone.QzoneIPCModule;
import d01.o;
import d01.u;
import d01.w;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u00a9\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0003\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\b\u000b\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\b\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005*\u0001U\u0018\u0000 \u00102\u00020\u0001:\u00017B\u000f\u0012\u0006\u0010Z\u001a\u00020X\u00a2\u0006\u0004\b[\u0010\\J \u0010\u0007\u001a\u00020\u00042\u0016\u0010\u0006\u001a\u0012\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u0002j\u0002`\u0005H\u0002J\u0012\u0010\t\u001a\u00020\u00042\b\u0010\b\u001a\u0004\u0018\u00010\u0003H\u0002J\u0012\u0010\r\u001a\u0004\u0018\u00010\f2\u0006\u0010\u000b\u001a\u00020\nH\u0002J\u0012\u0010\u0010\u001a\u00020\u00042\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eH\u0002J\u0012\u0010\u0011\u001a\u00020\u00042\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eH\u0002J\u0018\u0010\u0016\u001a\u00020\u00042\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0015\u001a\u00020\u0014H\u0002J\u0012\u0010\u0017\u001a\u00020\u00042\b\u0010\b\u001a\u0004\u0018\u00010\u0003H\u0002J\u0010\u0010\u001a\u001a\u00020\u00042\u0006\u0010\u0019\u001a\u00020\u0018H\u0002J\u0010\u0010\u001b\u001a\u00020\u00042\u0006\u0010\u0019\u001a\u00020\u0018H\u0002J\u0010\u0010\u001c\u001a\u00020\u00042\u0006\u0010\u0019\u001a\u00020\u0018H\u0002J\u0010\u0010 \u001a\u00020\u001f2\u0006\u0010\u001e\u001a\u00020\u001dH\u0002JL\u0010'\u001a\u00020\u00042\u0006\u0010\"\u001a\u00020!2\u0006\u0010#\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\n2\u0012\u0010%\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u00010$2\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u000e2\n\b\u0002\u0010&\u001a\u0004\u0018\u00010\nH\u0007J\u0010\u0010)\u001a\u00020\u00042\u0006\u0010(\u001a\u00020\u001dH\u0007J\b\u0010*\u001a\u00020\u0004H\u0007J\b\u0010+\u001a\u00020\u0004H\u0007J\b\u0010,\u001a\u00020\u0004H\u0007J\u0018\u0010/\u001a\u00020\u00042\u0006\u0010-\u001a\u00020\n2\u0006\u0010.\u001a\u00020\u0001H\u0007J \u00104\u001a\u00020\u00042\u0006\u00101\u001a\u0002002\u0006\u00102\u001a\u0002002\b\u0010.\u001a\u0004\u0018\u000103J\u0006\u00105\u001a\u00020\u0004R\u001b\u0010;\u001a\u0002068FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b7\u00108\u001a\u0004\b9\u0010:R\u001e\u0010?\u001a\n\u0012\u0004\u0012\u00020!\u0018\u00010<8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b=\u0010>R\u0018\u0010B\u001a\u0004\u0018\u00010\u00038\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b@\u0010AR\u0018\u0010E\u001a\u0004\u0018\u00010\f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bC\u0010DR$\u0010%\u001a\u0010\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u0001\u0018\u00010$8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bF\u0010GR\u0018\u0010\u000b\u001a\u0004\u0018\u00010\n8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bH\u0010IR\u0018\u0010#\u001a\u0004\u0018\u00010\n8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bJ\u0010IR\u0018\u0010&\u001a\u0004\u0018\u00010\n8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b \u0010IR\u0016\u0010N\u001a\u00020K8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bL\u0010MR\u0016\u0010Q\u001a\u00020O8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b9\u0010PR1\u0010T\u001a\u0018\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u0002j\u0002`\u00050R8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0016\u00108\u001a\u0004\bL\u0010SR\u0014\u0010W\u001a\u00020U8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\r\u0010VR\u0014\u0010Z\u001a\u00020X8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0011\u0010Y\u00a8\u0006]"}, d2 = {"Lcom/tencent/kuikly/core/render/android/expand/KuiklyRenderViewDelegator;", "", "Lkotlin/Function1;", "Lcom/tencent/kuikly/core/render/android/KuiklyRenderView;", "", "Lcom/tencent/kuikly/core/render/android/expand/KuiklyRenderViewPendingTask;", "task", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "kuiklyRenderView", BdhLogUtil.LogTag.Tag_Conn, "", "pageName", "Lcom/tencent/kuikly/core/render/android/performace/KRPerformanceManager;", "l", "Landroid/util/Size;", "size", DomainData.DOMAIN_NAME, QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "", "throwable", "Lcom/tencent/kuikly/core/render/android/exception/ErrorReason;", HiAnalyticsConstant.HaKey.BI_KEY_ERRORREASON, "k", "v", "Lcom/tencent/kuikly/core/render/android/b;", "kuiklyRenderExport", HippyTKDListViewAdapter.X, "w", "y", "Landroid/content/Context;", "context", "Li01/c;", h.F, "Landroid/view/ViewGroup;", ParseCommon.CONTAINER, "contextCode", "", ISchemeApi.KEY_PAGE_DATA, "assetsPath", "p", "newContext", QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, "r", ReportConstant.COSTREPORT_PREFIX, "t", "event", "data", "B", "", "requestCode", QzoneIPCModule.RESULT_CODE, "Landroid/content/Intent;", "o", "u", "Ll01/a;", "a", "Lkotlin/Lazy;", "j", "()Ll01/a;", "unitConverter", "Ljava/lang/ref/WeakReference;", "b", "Ljava/lang/ref/WeakReference;", "containerViewWeakRef", "c", "Lcom/tencent/kuikly/core/render/android/KuiklyRenderView;", "renderView", "d", "Lcom/tencent/kuikly/core/render/android/performace/KRPerformanceManager;", "performanceManager", "e", "Ljava/util/Map;", "f", "Ljava/lang/String;", "g", "", "i", "Z", "isLoadFinish", "Lcom/tencent/kuikly/core/render/android/context/KuiklyRenderCoreExecuteMode;", "Lcom/tencent/kuikly/core/render/android/context/KuiklyRenderCoreExecuteMode;", "executeMode", "", "()Ljava/util/List;", "pendingTaskList", "com/tencent/kuikly/core/render/android/expand/KuiklyRenderViewDelegator$c", "Lcom/tencent/kuikly/core/render/android/expand/KuiklyRenderViewDelegator$c;", "renderViewCallback", "Lcom/tencent/kuikly/core/render/android/expand/a;", "Lcom/tencent/kuikly/core/render/android/expand/a;", "delegate", "<init>", "(Lcom/tencent/kuikly/core/render/android/expand/a;)V", "core-render-android_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes7.dex */
public final class KuiklyRenderViewDelegator {

    /* renamed from: n */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: a, reason: from kotlin metadata */
    @NotNull
    private final Lazy unitConverter;

    /* renamed from: b, reason: from kotlin metadata */
    private WeakReference<ViewGroup> containerViewWeakRef;

    /* renamed from: c, reason: from kotlin metadata */
    private KuiklyRenderView renderView;

    /* renamed from: d, reason: from kotlin metadata */
    private KRPerformanceManager performanceManager;

    /* renamed from: e, reason: from kotlin metadata */
    private Map<String, ? extends Object> com.tencent.mobileqq.zplan.scheme.ISchemeApi.KEY_PAGE_DATA java.lang.String;

    /* renamed from: f, reason: from kotlin metadata */
    private String pageName;

    /* renamed from: g, reason: from kotlin metadata */
    private String contextCode;

    /* renamed from: h */
    private String assetsPath;

    /* renamed from: i, reason: from kotlin metadata */
    private volatile boolean isLoadFinish;

    /* renamed from: j, reason: from kotlin metadata */
    private KuiklyRenderCoreExecuteMode executeMode;

    /* renamed from: k, reason: from kotlin metadata */
    private final Lazy pendingTaskList;

    /* renamed from: l, reason: from kotlin metadata */
    private final c renderViewCallback;

    /* renamed from: m */
    private final a delegate;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/kuikly/core/render/android/expand/KuiklyRenderViewDelegator$a;", "", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "core-render-android_debug"}, k = 1, mv = {1, 4, 1})
    /* renamed from: com.tencent.kuikly.core.render.android.expand.KuiklyRenderViewDelegator$a */
    /* loaded from: classes7.dex */
    public static final class Companion {
        Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0006H\u0016\u00a8\u0006\b\u00b8\u0006\u0000"}, d2 = {"com/tencent/kuikly/core/render/android/expand/KuiklyRenderViewDelegator$initPerformanceManager$1$1", "Lcom/tencent/kuikly/core/render/android/performace/a;", "Lj01/a;", "data", "", "a", "Lcom/tencent/kuikly/core/render/android/performace/c;", "b", "core-render-android_debug"}, k = 1, mv = {1, 4, 1})
    /* loaded from: classes7.dex */
    public static final class b implements com.tencent.kuikly.core.render.android.performace.a {
        b() {
        }

        @Override // com.tencent.kuikly.core.render.android.performace.a
        public void a(@NotNull j01.a data) {
            Intrinsics.checkNotNullParameter(data, "data");
            KuiklyRenderViewDelegator.this.delegate.pg(data);
        }

        @Override // com.tencent.kuikly.core.render.android.performace.a
        public void b(@NotNull com.tencent.kuikly.core.render.android.performace.c data) {
            Intrinsics.checkNotNullParameter(data, "data");
            KuiklyRenderViewDelegator.this.delegate.le(data);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0010\n\u0002\u0010\u0003\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0004\u001a\u00020\u0002H\u0016J\b\u0010\u0005\u001a\u00020\u0002H\u0016J\b\u0010\u0006\u001a\u00020\u0002H\u0016J\b\u0010\u0007\u001a\u00020\u0002H\u0016J\b\u0010\b\u001a\u00020\u0002H\u0016J\b\u0010\t\u001a\u00020\u0002H\u0016J\b\u0010\n\u001a\u00020\u0002H\u0016J\b\u0010\u000b\u001a\u00020\u0002H\u0016J\b\u0010\f\u001a\u00020\u0002H\u0016J\b\u0010\r\u001a\u00020\u0002H\u0016J\b\u0010\u000e\u001a\u00020\u0002H\u0016J\b\u0010\u000f\u001a\u00020\u0002H\u0016J\b\u0010\u0010\u001a\u00020\u0002H\u0016J\b\u0010\u0011\u001a\u00020\u0002H\u0016J\b\u0010\u0012\u001a\u00020\u0002H\u0016J\u0018\u0010\u0017\u001a\u00020\u00022\u0006\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0016\u001a\u00020\u0015H\u0016\u00a8\u0006\u0018"}, d2 = {"com/tencent/kuikly/core/render/android/expand/KuiklyRenderViewDelegator$c", "Lcom/tencent/kuikly/core/render/android/e;", "", "onInit", "l", "j", "f", "k", "i", h.F, "d", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "g", "c", "a", "e", "onResume", MiniSDKConst.NOTIFY_EVENT_ONPAUSE, MosaicConstants$JsFunction.FUNC_ON_DESTROY, "", "throwable", "Lcom/tencent/kuikly/core/render/android/exception/ErrorReason;", HiAnalyticsConstant.HaKey.BI_KEY_ERRORREASON, "b", "core-render-android_debug"}, k = 1, mv = {1, 4, 1})
    /* loaded from: classes7.dex */
    public static final class c implements e {
        c() {
        }

        @Override // com.tencent.kuikly.core.render.android.e
        public void a() {
            KRPerformanceManager kRPerformanceManager = KuiklyRenderViewDelegator.this.performanceManager;
            if (kRPerformanceManager != null) {
                kRPerformanceManager.a();
            }
        }

        @Override // com.tencent.kuikly.core.render.android.e
        public void b(@NotNull Throwable throwable, @NotNull ErrorReason r36) {
            Intrinsics.checkNotNullParameter(throwable, "throwable");
            Intrinsics.checkNotNullParameter(r36, "errorReason");
            KRPerformanceManager kRPerformanceManager = KuiklyRenderViewDelegator.this.performanceManager;
            if (kRPerformanceManager != null) {
                kRPerformanceManager.b(throwable, r36);
            }
            KuiklyRenderViewDelegator.this.k(throwable, r36);
        }

        @Override // com.tencent.kuikly.core.render.android.e
        public void c() {
            KRPerformanceManager kRPerformanceManager = KuiklyRenderViewDelegator.this.performanceManager;
            if (kRPerformanceManager != null) {
                kRPerformanceManager.c();
            }
        }

        @Override // com.tencent.kuikly.core.render.android.e
        public void d() {
            KRPerformanceManager kRPerformanceManager = KuiklyRenderViewDelegator.this.performanceManager;
            if (kRPerformanceManager != null) {
                kRPerformanceManager.d();
            }
        }

        @Override // com.tencent.kuikly.core.render.android.e
        public void e() {
            Map emptyMap;
            KuiklyRenderViewDelegator.this.isLoadFinish = true;
            KuiklyRenderViewDelegator.this.delegate.Sa();
            KRPerformanceManager kRPerformanceManager = KuiklyRenderViewDelegator.this.performanceManager;
            if (kRPerformanceManager != null) {
                kRPerformanceManager.e();
            }
            a.C5872a.l(KuiklyRenderViewDelegator.this.delegate, true, null, KuiklyRenderViewDelegator.this.executeMode, 2, null);
            KuiklyRenderViewDelegator kuiklyRenderViewDelegator = KuiklyRenderViewDelegator.this;
            emptyMap = MapsKt__MapsKt.emptyMap();
            kuiklyRenderViewDelegator.B(Pager.PAGER_EVENT_FIRST_FRAME_PAINT, emptyMap);
        }

        @Override // com.tencent.kuikly.core.render.android.e
        public void f() {
            d dVar;
            KRPerformanceManager kRPerformanceManager = KuiklyRenderViewDelegator.this.performanceManager;
            if (kRPerformanceManager != null) {
                kRPerformanceManager.f();
            }
            KRPerformanceManager kRPerformanceManager2 = KuiklyRenderViewDelegator.this.performanceManager;
            if (kRPerformanceManager2 != null && (dVar = (d) kRPerformanceManager2.r("KRFrameMonitor")) != null) {
                KuiklyRenderView kuiklyRenderView = KuiklyRenderViewDelegator.this.renderView;
                if (kuiklyRenderView != null) {
                    kuiklyRenderView.setViewTreeUpdateListener(dVar.getDriveFrameDetector());
                }
                KuiklyRenderView kuiklyRenderView2 = KuiklyRenderViewDelegator.this.renderView;
                if (kuiklyRenderView2 != null) {
                    kuiklyRenderView2.setKotlinBridgeStatusListener(dVar.getDriveFrameDetector());
                }
            }
        }

        @Override // com.tencent.kuikly.core.render.android.e
        public void g() {
            KRPerformanceManager kRPerformanceManager = KuiklyRenderViewDelegator.this.performanceManager;
            if (kRPerformanceManager != null) {
                kRPerformanceManager.g();
            }
        }

        @Override // com.tencent.kuikly.core.render.android.e
        public void h() {
            KRPerformanceManager kRPerformanceManager = KuiklyRenderViewDelegator.this.performanceManager;
            if (kRPerformanceManager != null) {
                kRPerformanceManager.h();
            }
        }

        @Override // com.tencent.kuikly.core.render.android.e
        public void i() {
            KRPerformanceManager kRPerformanceManager = KuiklyRenderViewDelegator.this.performanceManager;
            if (kRPerformanceManager != null) {
                kRPerformanceManager.i();
            }
        }

        @Override // com.tencent.kuikly.core.render.android.e
        public void j() {
            KRPerformanceManager kRPerformanceManager = KuiklyRenderViewDelegator.this.performanceManager;
            if (kRPerformanceManager != null) {
                kRPerformanceManager.j();
            }
        }

        @Override // com.tencent.kuikly.core.render.android.e
        public void k() {
            KRPerformanceManager kRPerformanceManager = KuiklyRenderViewDelegator.this.performanceManager;
            if (kRPerformanceManager != null) {
                kRPerformanceManager.k();
            }
        }

        @Override // com.tencent.kuikly.core.render.android.e
        public void l() {
            KRPerformanceManager kRPerformanceManager = KuiklyRenderViewDelegator.this.performanceManager;
            if (kRPerformanceManager != null) {
                kRPerformanceManager.l();
            }
        }

        @Override // com.tencent.kuikly.core.render.android.e
        public void m() {
            KRPerformanceManager kRPerformanceManager = KuiklyRenderViewDelegator.this.performanceManager;
            if (kRPerformanceManager != null) {
                kRPerformanceManager.m();
            }
        }

        @Override // com.tencent.kuikly.core.render.android.e
        public void onDestroy() {
            KRPerformanceManager kRPerformanceManager = KuiklyRenderViewDelegator.this.performanceManager;
            if (kRPerformanceManager != null) {
                kRPerformanceManager.onDestroy();
            }
        }

        @Override // com.tencent.kuikly.core.render.android.e
        public void onInit() {
            KRPerformanceManager kRPerformanceManager = KuiklyRenderViewDelegator.this.performanceManager;
            if (kRPerformanceManager != null) {
                kRPerformanceManager.onInit();
            }
        }

        @Override // com.tencent.kuikly.core.render.android.e
        public void onPause() {
            KRPerformanceManager kRPerformanceManager = KuiklyRenderViewDelegator.this.performanceManager;
            if (kRPerformanceManager != null) {
                kRPerformanceManager.onPause();
            }
        }

        @Override // com.tencent.kuikly.core.render.android.e
        public void onResume() {
            KRPerformanceManager kRPerformanceManager = KuiklyRenderViewDelegator.this.performanceManager;
            if (kRPerformanceManager != null) {
                kRPerformanceManager.onResume();
            }
        }
    }

    public KuiklyRenderViewDelegator(@NotNull a delegate) {
        Lazy lazy;
        Lazy lazy2;
        Intrinsics.checkNotNullParameter(delegate, "delegate");
        this.delegate = delegate;
        lazy = LazyKt__LazyJVMKt.lazy(LazyThreadSafetyMode.NONE, (Function0) new Function0<l01.a>() { // from class: com.tencent.kuikly.core.render.android.expand.KuiklyRenderViewDelegator$unitConverter$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final l01.a invoke() {
                return new l01.a(Boolean.valueOf(KuiklyRenderViewDelegator.this.delegate.getUseHostDisplayMetrics()));
            }
        });
        this.unitConverter = lazy;
        this.executeMode = KuiklyRenderCoreExecuteMode.JVM;
        lazy2 = LazyKt__LazyJVMKt.lazy(new Function0<List<Function1<? super KuiklyRenderView, ? extends Unit>>>() { // from class: com.tencent.kuikly.core.render.android.expand.KuiklyRenderViewDelegator$pendingTaskList$2
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final List<Function1<? super KuiklyRenderView, ? extends Unit>> invoke() {
                return new ArrayList();
            }
        });
        this.pendingTaskList = lazy2;
        KuiklyRenderClassLoad kuiklyRenderClassLoad = KuiklyRenderClassLoad.f117708b;
        this.renderViewCallback = new c();
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void A(Function1<? super KuiklyRenderView, Unit> function1) {
        KuiklyRenderView kuiklyRenderView = this.renderView;
        if (kuiklyRenderView != null) {
            function1.invoke(kuiklyRenderView);
        } else {
            i().add(function1);
        }
    }

    private final void C(KuiklyRenderView kuiklyRenderView) {
        if (kuiklyRenderView != null) {
            Iterator<T> it = i().iterator();
            while (it.hasNext()) {
                ((Function1) it.next()).invoke(kuiklyRenderView);
            }
            i().clear();
        }
    }

    public final i01.c h(Context context) {
        KeyEvent.Callback inflate = LayoutInflater.from(context.getApplicationContext()).cloneInContext(context).inflate(R.layout.fdl, (ViewGroup) null);
        if (inflate != null) {
            return (i01.c) inflate;
        }
        throw new NullPointerException("null cannot be cast to non-null type com.tencent.kuikly.core.render.android.export.IKuiklyRenderViewExport");
    }

    private final List<Function1<KuiklyRenderView, Unit>> i() {
        return (List) this.pendingTaskList.getValue();
    }

    public final void k(Throwable throwable, ErrorReason r56) {
        w.f392617a.b("KuiklyRenderViewDelegator", "handleException, isLoadFinish: " + this.isLoadFinish + ", errorReason: " + r56 + ", error: " + com.tencent.kuikly.core.render.android.css.ktx.b.m(throwable));
        if (!this.isLoadFinish) {
            KuiklyRenderView kuiklyRenderView = this.renderView;
            if (kuiklyRenderView != null) {
                kuiklyRenderView.L(this.renderViewCallback);
            }
            KuiklyRenderView kuiklyRenderView2 = this.renderView;
            if (kuiklyRenderView2 != null) {
                kuiklyRenderView2.o();
            }
            this.delegate.onPageLoadComplete(false, r56, this.executeMode);
        }
        this.delegate.Ia(throwable, r56, this.executeMode);
        o l3 = u.f392615m.l();
        if (l3 != null) {
            l3.uncaughtException(throwable);
            return;
        }
        throw throwable;
    }

    private final KRPerformanceManager l(String pageName) {
        List<KRMonitorType> ec5 = this.delegate.ec();
        if (!ec5.isEmpty()) {
            KRPerformanceManager kRPerformanceManager = new KRPerformanceManager(pageName, this.executeMode, ec5);
            kRPerformanceManager.t(new b());
            return kRPerformanceManager;
        }
        return this.performanceManager;
    }

    private final void m(Size size) {
        ViewGroup viewGroup;
        String str;
        String str2;
        FrameLayout.LayoutParams layoutParams;
        KuiklyRenderView kuiklyRenderView;
        w wVar = w.f392617a;
        wVar.a("KuiklyRenderViewDelegator", "initRenderView, executeMode: " + this.executeMode + ", pageName: " + this.pageName);
        WeakReference<ViewGroup> weakReference = this.containerViewWeakRef;
        if (weakReference != null) {
            viewGroup = weakReference.get();
        } else {
            viewGroup = null;
        }
        if (viewGroup == null) {
            wVar.c("KuiklyRenderViewDelegator", "init render view container view is null, " + this.pageName);
            return;
        }
        Context context = viewGroup.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "containerView.context");
        KuiklyRenderView kuiklyRenderView2 = new KuiklyRenderView(context, this.executeMode, this.delegate.ng(), this.delegate);
        kuiklyRenderView2.F(this.renderViewCallback);
        v(kuiklyRenderView2);
        String str3 = this.contextCode;
        if (str3 == null) {
            str = "";
        } else {
            str = str3;
        }
        String str4 = this.pageName;
        if (str4 == null) {
            str2 = "";
        } else {
            str2 = str4;
        }
        Map<String, ? extends Object> map = this.com.tencent.mobileqq.zplan.scheme.ISchemeApi.KEY_PAGE_DATA java.lang.String;
        if (map == null) {
            map = MapsKt__MapsKt.emptyMap();
        }
        kuiklyRenderView2.x(str, str2, map, size, this.assetsPath);
        if (size == null) {
            layoutParams = new FrameLayout.LayoutParams(-1, -1);
        } else {
            layoutParams = new FrameLayout.LayoutParams(size.getWidth(), size.getHeight());
        }
        kuiklyRenderView2.setLayoutParams(layoutParams);
        Unit unit = Unit.INSTANCE;
        this.renderView = kuiklyRenderView2;
        viewGroup.addView(kuiklyRenderView2);
        this.delegate.p9();
        KuiklyRenderView kuiklyRenderView3 = this.renderView;
        if (kuiklyRenderView3 != null) {
            kuiklyRenderView3.p();
        }
        if (this.delegate.h4()) {
            KuiklyRenderView kuiklyRenderView4 = this.renderView;
            if (kuiklyRenderView4 != null) {
                kuiklyRenderView4.J();
            }
        } else if (this.delegate.c1() && (kuiklyRenderView = this.renderView) != null) {
            kuiklyRenderView.l();
        }
        this.pageName = null;
        this.com.tencent.mobileqq.zplan.scheme.ISchemeApi.KEY_PAGE_DATA java.lang.String = null;
        this.contextCode = null;
        C(this.renderView);
    }

    private final void n(Size size) {
        m(size);
    }

    public static /* synthetic */ void q(KuiklyRenderViewDelegator kuiklyRenderViewDelegator, ViewGroup viewGroup, String str, String str2, Map map, Size size, String str3, int i3, Object obj) {
        Size size2;
        String str4;
        if ((i3 & 16) != 0) {
            size2 = null;
        } else {
            size2 = size;
        }
        if ((i3 & 32) != 0) {
            str4 = null;
        } else {
            str4 = str3;
        }
        kuiklyRenderViewDelegator.p(viewGroup, str, str2, map, size2, str4);
    }

    private final void v(KuiklyRenderView kuiklyRenderView) {
        com.tencent.kuikly.core.render.android.b e16;
        if (kuiklyRenderView != null && (e16 = kuiklyRenderView.e()) != null) {
            w(e16);
            x(e16);
            y(e16);
        }
    }

    private final void w(com.tencent.kuikly.core.render.android.b kuiklyRenderExport) {
        kuiklyRenderExport.a("KRMemoryCacheModule", new Function0<i01.a>() { // from class: com.tencent.kuikly.core.render.android.expand.KuiklyRenderViewDelegator$registerModule$1$1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final i01.a invoke() {
                return new j();
            }
        });
        kuiklyRenderExport.a("KRSharedPreferencesModule", new Function0<i01.a>() { // from class: com.tencent.kuikly.core.render.android.expand.KuiklyRenderViewDelegator$registerModule$1$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final i01.a invoke() {
                return new q();
            }
        });
        kuiklyRenderExport.a("KRNotifyModule", new Function0<i01.a>() { // from class: com.tencent.kuikly.core.render.android.expand.KuiklyRenderViewDelegator$registerModule$1$3
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final i01.a invoke() {
                return new k();
            }
        });
        kuiklyRenderExport.a("KRSnapshotModule", new Function0<i01.a>() { // from class: com.tencent.kuikly.core.render.android.expand.KuiklyRenderViewDelegator$registerModule$1$4
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final i01.a invoke() {
                return new KRSnapshotModule();
            }
        });
        kuiklyRenderExport.a("KRRouterModule", new Function0<i01.a>() { // from class: com.tencent.kuikly.core.render.android.expand.KuiklyRenderViewDelegator$registerModule$1$5
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final i01.a invoke() {
                return new com.tencent.kuikly.core.render.android.expand.module.o();
            }
        });
        kuiklyRenderExport.a("KRNetworkModule", new Function0<i01.a>() { // from class: com.tencent.kuikly.core.render.android.expand.KuiklyRenderViewDelegator$registerModule$1$6
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final i01.a invoke() {
                return new KRNetworkModule();
            }
        });
        kuiklyRenderExport.a("KRCalendarModule", new Function0<i01.a>() { // from class: com.tencent.kuikly.core.render.android.expand.KuiklyRenderViewDelegator$registerModule$1$7
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final i01.a invoke() {
                return new c();
            }
        });
        kuiklyRenderExport.a("KRCodecModule", new Function0<i01.a>() { // from class: com.tencent.kuikly.core.render.android.expand.KuiklyRenderViewDelegator$registerModule$1$8
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final i01.a invoke() {
                return new com.tencent.kuikly.core.render.android.expand.module.e();
            }
        });
        kuiklyRenderExport.a("KRReflectionModule", new Function0<i01.a>() { // from class: com.tencent.kuikly.core.render.android.expand.KuiklyRenderViewDelegator$registerModule$1$9
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final i01.a invoke() {
                return new KRReflectionModule();
            }
        });
        kuiklyRenderExport.a("KRLogModule", new Function0<i01.a>() { // from class: com.tencent.kuikly.core.render.android.expand.KuiklyRenderViewDelegator$registerModule$1$10
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final i01.a invoke() {
                return new KRLogModule();
            }
        });
        kuiklyRenderExport.a("KRKeyboardModule", new Function0<i01.a>() { // from class: com.tencent.kuikly.core.render.android.expand.KuiklyRenderViewDelegator$registerModule$1$11
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final i01.a invoke() {
                return new com.tencent.kuikly.core.render.android.expand.module.h();
            }
        });
        kuiklyRenderExport.a("KRPerformanceModule", new Function0<i01.a>() { // from class: com.tencent.kuikly.core.render.android.expand.KuiklyRenderViewDelegator$registerModule$$inlined$with$lambda$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final i01.a invoke() {
                return new m(KuiklyRenderViewDelegator.this.performanceManager);
            }
        });
        kuiklyRenderExport.a("KRTurboDisplayModule", new Function0<i01.a>() { // from class: com.tencent.kuikly.core.render.android.expand.KuiklyRenderViewDelegator$registerModule$1$13
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final i01.a invoke() {
                return new KRTurboDisplayModule();
            }
        });
        kuiklyRenderExport.a("KRFontModule", new Function0<i01.a>() { // from class: com.tencent.kuikly.core.render.android.expand.KuiklyRenderViewDelegator$registerModule$1$14
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final i01.a invoke() {
                return new g();
            }
        });
        kuiklyRenderExport.a("KRDiskCacheModule", new Function0<i01.a>() { // from class: com.tencent.kuikly.core.render.android.expand.KuiklyRenderViewDelegator$registerModule$1$15
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final i01.a invoke() {
                return new f();
            }
        });
        kuiklyRenderExport.a("KRAccessibilityModule", new Function0<i01.a>() { // from class: com.tencent.kuikly.core.render.android.expand.KuiklyRenderViewDelegator$registerModule$1$16
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final i01.a invoke() {
                return new b();
            }
        });
        kuiklyRenderExport.a("KRSQLiteModule", new Function0<i01.a>() { // from class: com.tencent.kuikly.core.render.android.expand.KuiklyRenderViewDelegator$registerModule$1$17
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final i01.a invoke() {
                return new KRSQLiteModule();
            }
        });
        this.delegate.registerExternalModule(kuiklyRenderExport);
        this.delegate.Ff(kuiklyRenderExport);
    }

    private final void x(com.tencent.kuikly.core.render.android.b bVar) {
        b.a.a(bVar, "KRView", new Function1<Context, i01.c>() { // from class: com.tencent.kuikly.core.render.android.expand.KuiklyRenderViewDelegator$registerRenderView$1$1
            @Override // kotlin.jvm.functions.Function1
            @NotNull
            public final i01.c invoke(@NotNull Context context) {
                Intrinsics.checkNotNullParameter(context, "context");
                return new KRView(context);
            }
        }, null, 4, null);
        bVar.g("KRRichTextView", new Function1<Context, i01.c>() { // from class: com.tencent.kuikly.core.render.android.expand.KuiklyRenderViewDelegator$registerRenderView$1$2
            @Override // kotlin.jvm.functions.Function1
            @NotNull
            public final i01.c invoke(@NotNull Context context) {
                Intrinsics.checkNotNullParameter(context, "context");
                return new KRRichTextView(context);
            }
        }, new Function0<i01.b>() { // from class: com.tencent.kuikly.core.render.android.expand.KuiklyRenderViewDelegator$registerRenderView$1$3
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final i01.b invoke() {
                return new KRRichTextShadow();
            }
        });
        bVar.g("KRGradientRichTextView", new Function1<Context, i01.c>() { // from class: com.tencent.kuikly.core.render.android.expand.KuiklyRenderViewDelegator$registerRenderView$1$4
            @Override // kotlin.jvm.functions.Function1
            @NotNull
            public final i01.c invoke(@NotNull Context context) {
                Intrinsics.checkNotNullParameter(context, "context");
                return new KRRichTextView(context);
            }
        }, new Function0<i01.b>() { // from class: com.tencent.kuikly.core.render.android.expand.KuiklyRenderViewDelegator$registerRenderView$1$5
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final i01.b invoke() {
                return new KRRichTextShadow();
            }
        });
        b.a.a(bVar, "KRImageView", new Function1<Context, i01.c>() { // from class: com.tencent.kuikly.core.render.android.expand.KuiklyRenderViewDelegator$registerRenderView$1$6
            @Override // kotlin.jvm.functions.Function1
            @NotNull
            public final i01.c invoke(@NotNull Context context) {
                Intrinsics.checkNotNullParameter(context, "context");
                return new KRImageView(context);
            }
        }, null, 4, null);
        b.a.a(bVar, "KRWrapperImageView", new Function1<Context, i01.c>() { // from class: com.tencent.kuikly.core.render.android.expand.KuiklyRenderViewDelegator$registerRenderView$1$7
            @Override // kotlin.jvm.functions.Function1
            @NotNull
            public final i01.c invoke(@NotNull Context context) {
                Intrinsics.checkNotNullParameter(context, "context");
                return new KRWrapperImageView(context);
            }
        }, null, 4, null);
        b.a.a(bVar, "KRListView", new Function1<Context, i01.c>() { // from class: com.tencent.kuikly.core.render.android.expand.KuiklyRenderViewDelegator$registerRenderView$$inlined$with$lambda$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            @NotNull
            public final i01.c invoke(@NotNull Context context) {
                i01.c h16;
                Intrinsics.checkNotNullParameter(context, "context");
                h16 = KuiklyRenderViewDelegator.this.h(context);
                return h16;
            }
        }, null, 4, null);
        b.a.a(bVar, "KRScrollView", new Function1<Context, i01.c>() { // from class: com.tencent.kuikly.core.render.android.expand.KuiklyRenderViewDelegator$registerRenderView$$inlined$with$lambda$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            @NotNull
            public final i01.c invoke(@NotNull Context context) {
                i01.c h16;
                Intrinsics.checkNotNullParameter(context, "context");
                h16 = KuiklyRenderViewDelegator.this.h(context);
                return h16;
            }
        }, null, 4, null);
        b.a.a(bVar, "KRScrollContentView", new Function1<Context, i01.c>() { // from class: com.tencent.kuikly.core.render.android.expand.KuiklyRenderViewDelegator$registerRenderView$1$10
            @Override // kotlin.jvm.functions.Function1
            @NotNull
            public final i01.c invoke(@NotNull Context context) {
                Intrinsics.checkNotNullParameter(context, "context");
                return new KRRecyclerContentView(context);
            }
        }, null, 4, null);
        b.a.a(bVar, "KRTextFieldView", new Function1<Context, i01.c>() { // from class: com.tencent.kuikly.core.render.android.expand.KuiklyRenderViewDelegator$registerRenderView$$inlined$with$lambda$3
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            @NotNull
            public final i01.c invoke(@NotNull Context context) {
                Intrinsics.checkNotNullParameter(context, "context");
                return new KRTextFieldView(context, KuiklyRenderViewDelegator.this.delegate.Re());
            }
        }, null, 4, null);
        b.a.a(bVar, "KRTextAreaView", new Function1<Context, i01.c>() { // from class: com.tencent.kuikly.core.render.android.expand.KuiklyRenderViewDelegator$registerRenderView$$inlined$with$lambda$4
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            @NotNull
            public final i01.c invoke(@NotNull Context context) {
                Intrinsics.checkNotNullParameter(context, "context");
                return new KRTextAreaView(context, KuiklyRenderViewDelegator.this.delegate.Re());
            }
        }, null, 4, null);
        b.a.a(bVar, "KRCanvasView", new Function1<Context, i01.c>() { // from class: com.tencent.kuikly.core.render.android.expand.KuiklyRenderViewDelegator$registerRenderView$1$13
            @Override // kotlin.jvm.functions.Function1
            @NotNull
            public final i01.c invoke(@NotNull Context context) {
                Intrinsics.checkNotNullParameter(context, "context");
                return new KRCanvasView(context);
            }
        }, null, 4, null);
        b.a.a(bVar, "KRHoverView", new Function1<Context, i01.c>() { // from class: com.tencent.kuikly.core.render.android.expand.KuiklyRenderViewDelegator$registerRenderView$1$14
            @Override // kotlin.jvm.functions.Function1
            @NotNull
            public final i01.c invoke(@NotNull Context context) {
                Intrinsics.checkNotNullParameter(context, "context");
                return new KRHoverView(context);
            }
        }, null, 4, null);
        b.a.a(bVar, "KRActivityIndicatorView", new Function1<Context, i01.c>() { // from class: com.tencent.kuikly.core.render.android.expand.KuiklyRenderViewDelegator$registerRenderView$1$15
            @Override // kotlin.jvm.functions.Function1
            @NotNull
            public final i01.c invoke(@NotNull Context context) {
                Intrinsics.checkNotNullParameter(context, "context");
                return new KRActivityIndicatorView(context);
            }
        }, null, 4, null);
        b.a.a(bVar, "KRBlurView", new Function1<Context, i01.c>() { // from class: com.tencent.kuikly.core.render.android.expand.KuiklyRenderViewDelegator$registerRenderView$1$16
            @Override // kotlin.jvm.functions.Function1
            @NotNull
            public final i01.c invoke(@NotNull Context context) {
                Intrinsics.checkNotNullParameter(context, "context");
                return new KRBlurView(context);
            }
        }, null, 4, null);
        b.a.a(bVar, "KRPAGView", new Function1<Context, i01.c>() { // from class: com.tencent.kuikly.core.render.android.expand.KuiklyRenderViewDelegator$registerRenderView$1$17
            @Override // kotlin.jvm.functions.Function1
            @NotNull
            public final i01.c invoke(@NotNull Context context) {
                Intrinsics.checkNotNullParameter(context, "context");
                return new KRPAGView(context);
            }
        }, null, 4, null);
        b.a.a(bVar, "KRMaskView", new Function1<Context, i01.c>() { // from class: com.tencent.kuikly.core.render.android.expand.KuiklyRenderViewDelegator$registerRenderView$1$18
            @Override // kotlin.jvm.functions.Function1
            @NotNull
            public final i01.c invoke(@NotNull Context context) {
                Intrinsics.checkNotNullParameter(context, "context");
                return new KRMaskView(context);
            }
        }, null, 4, null);
        b.a.a(bVar, "KRVideoView", new Function1<Context, i01.c>() { // from class: com.tencent.kuikly.core.render.android.expand.KuiklyRenderViewDelegator$registerRenderView$1$19
            @Override // kotlin.jvm.functions.Function1
            @NotNull
            public final i01.c invoke(@NotNull Context context) {
                Intrinsics.checkNotNullParameter(context, "context");
                return new KRVideoView(context);
            }
        }, null, 4, null);
        b.a.a(bVar, "KRAPNGView", new Function1<Context, i01.c>() { // from class: com.tencent.kuikly.core.render.android.expand.KuiklyRenderViewDelegator$registerRenderView$1$20
            @Override // kotlin.jvm.functions.Function1
            @NotNull
            public final i01.c invoke(@NotNull Context context) {
                Intrinsics.checkNotNullParameter(context, "context");
                return new KRAPNGView(context);
            }
        }, null, 4, null);
        b.a.a(bVar, "KRLottieView", new Function1<Context, i01.c>() { // from class: com.tencent.kuikly.core.render.android.expand.KuiklyRenderViewDelegator$registerRenderView$1$21
            @Override // kotlin.jvm.functions.Function1
            @NotNull
            public final i01.c invoke(@NotNull Context context) {
                Intrinsics.checkNotNullParameter(context, "context");
                return new KRLottieView(context);
            }
        }, null, 4, null);
        b.a.a(bVar, "KRModalView", new Function1<Context, i01.c>() { // from class: com.tencent.kuikly.core.render.android.expand.KuiklyRenderViewDelegator$registerRenderView$1$22
            @Override // kotlin.jvm.functions.Function1
            @NotNull
            public final i01.c invoke(@NotNull Context context) {
                Intrinsics.checkNotNullParameter(context, "context");
                return new KRModalView(context);
            }
        }, null, 4, null);
        b.a.a(bVar, "KRSnapshotView", new Function1<Context, i01.c>() { // from class: com.tencent.kuikly.core.render.android.expand.KuiklyRenderViewDelegator$registerRenderView$1$23
            @Override // kotlin.jvm.functions.Function1
            @NotNull
            public final i01.c invoke(@NotNull Context context) {
                Intrinsics.checkNotNullParameter(context, "context");
                return new KRSnapshotView(context);
            }
        }, null, 4, null);
        this.delegate.registerExternalRenderView(bVar);
    }

    private final void y(com.tencent.kuikly.core.render.android.b kuiklyRenderExport) {
        this.delegate.registerViewExternalPropHandler(kuiklyRenderExport);
    }

    @UiThread
    public final void B(@NotNull final String event, @NotNull final Object data) {
        Intrinsics.checkNotNullParameter(event, "event");
        Intrinsics.checkNotNullParameter(data, "data");
        A(new Function1<KuiklyRenderView, Unit>() { // from class: com.tencent.kuikly.core.render.android.expand.KuiklyRenderViewDelegator$sendEvent$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(KuiklyRenderView kuiklyRenderView) {
                invoke2(kuiklyRenderView);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@NotNull KuiklyRenderView it) {
                Intrinsics.checkNotNullParameter(it, "it");
                it.d(event, data);
            }
        });
    }

    @NotNull
    public final l01.a j() {
        return (l01.a) this.unitConverter.getValue();
    }

    public final void o(final int requestCode, final int r36, @Nullable final Intent data) {
        A(new Function1<KuiklyRenderView, Unit>() { // from class: com.tencent.kuikly.core.render.android.expand.KuiklyRenderViewDelegator$onActivityResult$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(KuiklyRenderView kuiklyRenderView) {
                invoke2(kuiklyRenderView);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@NotNull KuiklyRenderView it) {
                Intrinsics.checkNotNullParameter(it, "it");
                it.s(requestCode, r36, data);
            }
        });
    }

    @UiThread
    public final void p(@NotNull ViewGroup r26, @NotNull String contextCode, @NotNull String pageName, @NotNull Map<String, ? extends Object> r56, @Nullable Size size, @Nullable String assetsPath) {
        Intrinsics.checkNotNullParameter(r26, "container");
        Intrinsics.checkNotNullParameter(contextCode, "contextCode");
        Intrinsics.checkNotNullParameter(pageName, "pageName");
        Intrinsics.checkNotNullParameter(r56, "pageData");
        this.executeMode = this.delegate.C2();
        this.containerViewWeakRef = new WeakReference<>(r26);
        this.performanceManager = l(pageName);
        this.pageName = pageName;
        this.contextCode = contextCode;
        this.com.tencent.mobileqq.zplan.scheme.ISchemeApi.KEY_PAGE_DATA java.lang.String = r56;
        this.assetsPath = assetsPath;
        n(size);
    }

    @UiThread
    public final void r() {
        A(new Function1<KuiklyRenderView, Unit>() { // from class: com.tencent.kuikly.core.render.android.expand.KuiklyRenderViewDelegator$onDetach$1
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(KuiklyRenderView kuiklyRenderView) {
                invoke2(kuiklyRenderView);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@NotNull KuiklyRenderView it) {
                Intrinsics.checkNotNullParameter(it, "it");
                it.o();
            }
        });
    }

    @UiThread
    public final void s() {
        A(new Function1<KuiklyRenderView, Unit>() { // from class: com.tencent.kuikly.core.render.android.expand.KuiklyRenderViewDelegator$onPause$1
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(KuiklyRenderView kuiklyRenderView) {
                invoke2(kuiklyRenderView);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@NotNull KuiklyRenderView it) {
                Intrinsics.checkNotNullParameter(it, "it");
                it.B();
            }
        });
    }

    @UiThread
    public final void t() {
        A(new Function1<KuiklyRenderView, Unit>() { // from class: com.tencent.kuikly.core.render.android.expand.KuiklyRenderViewDelegator$onResume$1
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(KuiklyRenderView kuiklyRenderView) {
                invoke2(kuiklyRenderView);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@NotNull KuiklyRenderView it) {
                Intrinsics.checkNotNullParameter(it, "it");
                it.H();
            }
        });
    }

    public final void u() {
        A(new Function1<KuiklyRenderView, Unit>() { // from class: com.tencent.kuikly.core.render.android.expand.KuiklyRenderViewDelegator$performAfterFirstScreenUITasks$1
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(KuiklyRenderView kuiklyRenderView) {
                invoke2(kuiklyRenderView);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@NotNull KuiklyRenderView it) {
                Intrinsics.checkNotNullParameter(it, "it");
                it.C();
            }
        });
    }

    @UiThread
    public final void z(@NotNull Context newContext) {
        Intrinsics.checkNotNullParameter(newContext, "newContext");
        KuiklyRenderView kuiklyRenderView = this.renderView;
        if (kuiklyRenderView != null) {
            kuiklyRenderView.G(newContext);
        }
    }
}

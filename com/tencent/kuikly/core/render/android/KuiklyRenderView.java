package com.tencent.kuikly.core.render.android;

import android.R;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Build;
import android.util.Size;
import android.util.SizeF;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.exifinterface.media.ExifInterface;
import com.heytap.databaseengine.model.UserInfo;
import com.huawei.hms.support.hianalytics.HiAnalyticsConstant;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.kuikly.core.pager.Pager;
import com.tencent.kuikly.core.render.android.context.KuiklyRenderCoreExecuteMode;
import com.tencent.kuikly.core.render.android.context.KuiklyRenderNativeContextHandler;
import com.tencent.kuikly.core.render.android.context.d;
import com.tencent.kuikly.core.render.android.core.KuiklyRenderCore;
import com.tencent.kuikly.core.render.android.css.ktx.KRCSSViewExtensionKt;
import com.tencent.kuikly.core.render.android.exception.ErrorReason;
import com.tencent.kuikly.core.render.android.expand.KuiklyRenderClassLoad;
import com.tencent.mobileqq.guild.mainframe.api.IGuildMainFrameApi;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import cooperation.qzone.QzoneIPCModule;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.collections.MapsKt__MapsJVMKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u00bd\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006*\u0001\u007f\b\u0007\u0018\u0000 ]2\u00020\u00012\u00020\u00022\u00020\u0003:\u0001LB7\u0012\u0007\u0010\u009b\u0001\u001a\u00020,\u0012\n\b\u0002\u0010\u008a\u0001\u001a\u00030\u0088\u0001\u0012\t\b\u0002\u0010\u008c\u0001\u001a\u00020'\u0012\f\b\u0002\u0010\u008f\u0001\u001a\u0005\u0018\u00010\u008d\u0001\u00a2\u0006\u0006\b\u009c\u0001\u0010\u009d\u0001J\u0018\u0010\b\u001a\u00020\u00072\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004H\u0002J\u0018\u0010\t\u001a\u00020\u00072\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004H\u0002J>\u0010\u0013\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\n2\u0012\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000e0\r2\u0006\u0010\u0011\u001a\u00020\u00102\b\u0010\u0012\u001a\u0004\u0018\u00010\nH\u0002J\u0010\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0015\u001a\u00020\u0014H\u0002J0\u0010\u0018\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000e0\r2\u0012\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000e0\r2\u0006\u0010\u0011\u001a\u00020\u0010H\u0002J\b\u0010\u0019\u001a\u00020\u0007H\u0002J/\u0010 \u001a\u00020\u00072%\u0010\u001f\u001a!\u0012\u0013\u0012\u00110\u0016\u00a2\u0006\f\b\u001b\u0012\b\b\u001c\u0012\u0004\b\b(\u001d\u0012\u0004\u0012\u00020\u00070\u001aj\u0002`\u001eH\u0002J\b\u0010!\u001a\u00020\u0007H\u0002J\u001c\u0010#\u001a\u00020\u00072\u0006\u0010\"\u001a\u00020\u00042\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u000eH\u0002J\b\u0010%\u001a\u00020$H\u0002J\u0010\u0010&\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\nH\u0002J\b\u0010(\u001a\u00020'H\u0002J\b\u0010*\u001a\u00020)H\u0002J\b\u0010+\u001a\u00020)H\u0002J\u000e\u0010.\u001a\u00020\u00072\u0006\u0010-\u001a\u00020,J@\u00100\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010/\u001a\u00020\n2\u0012\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000e0\r2\b\u0010\u0011\u001a\u0004\u0018\u00010)2\b\u0010\u0012\u001a\u0004\u0018\u00010\nH\u0016J\b\u00101\u001a\u00020\u0007H\u0016J\u0018\u00104\u001a\u00020\u00072\u0006\u00102\u001a\u00020\n2\u0006\u00103\u001a\u00020\u000eH\u0016J\u001a\u00108\u001a\u00020\u00072\b\u00106\u001a\u0004\u0018\u0001052\u0006\u00107\u001a\u00020\u0004H\u0016J\b\u00109\u001a\u00020\u0007H\u0016J\b\u0010:\u001a\u00020\u0007H\u0016J\b\u0010;\u001a\u00020\u0007H\u0016J\b\u0010<\u001a\u00020\u0007H\u0016J\b\u0010=\u001a\u00020\u0007H\u0016J\b\u0010>\u001a\u00020\u0007H\u0016J\u001a\u0010A\u001a\u00020\u00072\u0010\u0010\u001f\u001a\f\u0012\u0004\u0012\u00020\u00070?j\u0002`@H\u0016J\u0010\u0010D\u001a\u00020\u00072\u0006\u0010C\u001a\u00020BH\u0016J\u0010\u0010E\u001a\u00020\u00072\u0006\u0010C\u001a\u00020BH\u0016J\"\u0010I\u001a\u00020\u00072\u0006\u0010F\u001a\u00020\u00042\u0006\u0010G\u001a\u00020\u00042\b\u00103\u001a\u0004\u0018\u00010HH\u0016J#\u0010L\u001a\u0004\u0018\u00018\u0000\"\b\b\u0000\u0010K*\u00020J2\u0006\u0010\u001c\u001a\u00020\nH\u0016\u00a2\u0006\u0004\bL\u0010MJ\u0012\u0010O\u001a\u0004\u0018\u0001052\u0006\u0010N\u001a\u00020\u0004H\u0016J(\u0010R\u001a\u00020\u00072\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010P\u001a\u00020\u00042\u0006\u0010Q\u001a\u00020\u0004H\u0014J\n\u0010S\u001a\u0004\u0018\u00010\nH\u0016J\b\u0010T\u001a\u00020'H\u0016J\u0011\u0010V\u001a\u0004\u0018\u00010UH\u0016\u00a2\u0006\u0004\bV\u0010WJ\u0012\u0010Z\u001a\u00020'2\b\u0010Y\u001a\u0004\u0018\u00010XH\u0016J\u000e\u0010\\\u001a\u00020\u00072\u0006\u0010C\u001a\u00020[J\u000e\u0010]\u001a\u00020\u00072\u0006\u0010C\u001a\u00020[J\u000e\u0010`\u001a\u00020\u00072\u0006\u0010_\u001a\u00020^J\u000e\u0010b\u001a\u00020\u00072\u0006\u0010_\u001a\u00020aR\u0018\u0010d\u001a\u0004\u0018\u00010\u00168\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b4\u0010cR\u0014\u0010h\u001a\u00020e8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bf\u0010gR\u0018\u0010j\u001a\u0004\u0018\u00010\u00108\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bE\u0010iR9\u0010m\u001a%\u0012\u0013\u0012\u00110\u0010\u00a2\u0006\f\b\u001b\u0012\b\b\u001c\u0012\u0004\b\b(\u0011\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u001aj\u0004\u0018\u0001`k8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0006\u0010lR\u0014\u0010q\u001a\u00020n8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bo\u0010pRd\u0010u\u001aP\u0012#\u0012!\u0012\u0013\u0012\u00110\u0016\u00a2\u0006\f\b\u001b\u0012\b\b\u001c\u0012\u0004\b\b(\u001d\u0012\u0004\u0012\u00020\u00070\u001aj\u0002`\u001e0rj'\u0012#\u0012!\u0012\u0013\u0012\u00110\u0016\u00a2\u0006\f\b\u001b\u0012\b\b\u001c\u0012\u0004\b\b(\u001d\u0012\u0004\u0012\u00020\u00070\u001aj\u0002`\u001e`s8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b%\u0010tR.\u0010z\u001a\u001a\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000e0wj\u0002`x\u0018\u00010v8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b>\u0010yR&\u0010{\u001a\u0012\u0012\u0004\u0012\u00020[0rj\b\u0012\u0004\u0012\u00020[`s8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b!\u0010tR!\u0010~\u001a\b\u0012\u0004\u0012\u00020B0v8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\b\u0010|\u001a\u0004\b\u0005\u0010}R\u0018\u0010\u0081\u0001\u001a\u00020\u007f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0007\n\u0005\b\\\u0010\u0080\u0001R\u001b\u0010\u0084\u0001\u001a\u0005\u0018\u00010\u0082\u00018\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0007\n\u0005\b.\u0010\u0083\u0001R\u001b\u0010\u0087\u0001\u001a\u0005\u0018\u00010\u0085\u00018\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0007\n\u0005\b9\u0010\u0086\u0001R\u0019\u0010\u008a\u0001\u001a\u00030\u0088\u00018\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0007\n\u0005\b\t\u0010\u0089\u0001R\u0016\u0010\u008c\u0001\u001a\u00020'8\u0002X\u0082\u0004\u00a2\u0006\u0007\n\u0005\b<\u0010\u008b\u0001R\u0019\u0010\u008f\u0001\u001a\u0005\u0018\u00010\u008d\u00018\u0002X\u0082\u0004\u00a2\u0006\u0007\n\u0005\b\u0019\u0010\u008e\u0001R\u0018\u0010\u0093\u0001\u001a\u00030\u0090\u00018VX\u0096\u0004\u00a2\u0006\b\u001a\u0006\b\u0091\u0001\u0010\u0092\u0001R\u0018\u0010\u0097\u0001\u001a\u00030\u0094\u00018VX\u0096\u0004\u00a2\u0006\b\u001a\u0006\b\u0095\u0001\u0010\u0096\u0001R\u0017\u0010\u009a\u0001\u001a\u00030\u0098\u00018VX\u0096\u0004\u00a2\u0006\u0007\u001a\u0005\bf\u0010\u0099\u0001\u00a8\u0006\u009e\u0001"}, d2 = {"Lcom/tencent/kuikly/core/render/android/KuiklyRenderView;", "Landroid/widget/FrameLayout;", "Lcom/tencent/kuikly/core/render/android/d;", "Lcom/tencent/kuikly/core/render/android/core/c;", "", "w", tl.h.F, "", "E", "I", "", "contextCode", "url", "", "", "params", "Landroid/util/SizeF;", "size", "assetsPath", QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, "Lcom/tencent/kuikly/core/render/android/g;", "contextParams", "Lcom/tencent/kuikly/core/render/android/core/b;", DomainData.DOMAIN_NAME, "t", "K", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "core", "Lcom/tencent/kuikly/core/render/android/RenderCoreLazyTask;", "task", "k", "D", "state", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "Lcom/tencent/kuikly/core/render/android/context/b;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "y", "", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "Landroid/util/Size;", "u", "v", "Landroid/content/Context;", "newContext", "G", "pageName", HippyTKDListViewAdapter.X, "p", "event", "data", "d", "Landroid/view/View;", "child", "index", "addView", "H", "B", "o", "J", "l", BdhLogUtil.LogTag.Tag_Conn, "Lkotlin/Function0;", "Lcom/tencent/kuikly/core/render/android/scheduler/KuiklyRenderCoreTask;", "c", "Lcom/tencent/kuikly/core/render/android/c;", "callback", "g", "f", "requestCode", QzoneIPCModule.RESULT_CODE, "Landroid/content/Intent;", ReportConstant.COSTREPORT_PREFIX, "Li01/e;", "T", "a", "(Ljava/lang/String;)Li01/e;", "tag", "b", "oldw", "oldh", MosaicConstants$JsFunction.FUNC_ON_SIZE_CHANGED, "V0", "c1", "", "K0", "()Ljava/lang/Long;", "Landroid/view/MotionEvent;", "ev", "dispatchTouchEvent", "Lcom/tencent/kuikly/core/render/android/e;", UserInfo.SEX_FEMALE, "L", "Lcom/tencent/kuikly/core/render/android/f;", "listener", "setViewTreeUpdateListener", "Lcom/tencent/kuikly/core/render/android/context/a;", "setKotlinBridgeStatusListener", "Lcom/tencent/kuikly/core/render/android/core/b;", "renderCore", "Lcom/tencent/kuikly/core/render/android/j;", "e", "Lcom/tencent/kuikly/core/render/android/j;", "kuiklyRenderViewContext", "Landroid/util/SizeF;", "lastSize", "Lcom/tencent/kuikly/core/render/android/InitRenderCoreLazyTask;", "Lkotlin/jvm/functions/Function1;", "initRenderCoreLazyTask", "Lcom/tencent/kuikly/core/render/android/h;", "i", "Lcom/tencent/kuikly/core/render/android/h;", "renderExport", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "Ljava/util/ArrayList;", "coreLazyTaskList", "", "Lkotlin/Pair;", "Lcom/tencent/kuikly/core/render/android/RenderCoreLazyEvent;", "Ljava/util/List;", "coreEventLazyEventList", "lifecycleCallbacks", "Lkotlin/Lazy;", "()Ljava/util/List;", "kuiklyRenderLifecycleCallbacks", "com/tencent/kuikly/core/render/android/KuiklyRenderView$b", "Lcom/tencent/kuikly/core/render/android/KuiklyRenderView$b;", "exceptionListener", "Lcom/tencent/kuikly/core/render/android/context/d;", "Lcom/tencent/kuikly/core/render/android/context/d;", "kuiklyDexClassLoader", "Lcom/tencent/kuikly/core/render/android/core/a;", "Lcom/tencent/kuikly/core/render/android/core/a;", "contextInitCallback", "Lcom/tencent/kuikly/core/render/android/context/KuiklyRenderCoreExecuteMode;", "Lcom/tencent/kuikly/core/render/android/context/KuiklyRenderCoreExecuteMode;", "executeMode", "Z", "enablePreloadCoreClassInDexMode", "Lcom/tencent/kuikly/core/render/android/expand/a;", "Lcom/tencent/kuikly/core/render/android/expand/a;", "delegate", "Landroid/view/ViewGroup;", "getView", "()Landroid/view/ViewGroup;", "view", "Lcom/tencent/kuikly/core/render/android/a;", "getKuiklyRenderContext", "()Lcom/tencent/kuikly/core/render/android/a;", "kuiklyRenderContext", "Lcom/tencent/kuikly/core/render/android/b;", "()Lcom/tencent/kuikly/core/render/android/b;", "kuiklyRenderExport", "context", "<init>", "(Landroid/content/Context;Lcom/tencent/kuikly/core/render/android/context/KuiklyRenderCoreExecuteMode;ZLcom/tencent/kuikly/core/render/android/expand/a;)V", "core-render-android_debug"}, k = 1, mv = {1, 4, 1})
@SuppressLint({"ViewConstructor"})
/* loaded from: classes7.dex */
public final class KuiklyRenderView extends FrameLayout implements d, com.tencent.kuikly.core.render.android.core.c {

    /* renamed from: L, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: C, reason: from kotlin metadata */
    private List<Pair<String, Object>> coreEventLazyEventList;

    /* renamed from: D, reason: from kotlin metadata */
    private ArrayList<e> lifecycleCallbacks;

    /* renamed from: E, reason: from kotlin metadata */
    private final Lazy kuiklyRenderLifecycleCallbacks;

    /* renamed from: F, reason: from kotlin metadata */
    private b exceptionListener;

    /* renamed from: G, reason: from kotlin metadata */
    private com.tencent.kuikly.core.render.android.context.d kuiklyDexClassLoader;

    /* renamed from: H, reason: from kotlin metadata */
    private com.tencent.kuikly.core.render.android.core.a contextInitCallback;

    /* renamed from: I, reason: from kotlin metadata */
    private KuiklyRenderCoreExecuteMode executeMode;

    /* renamed from: J, reason: from kotlin metadata */
    private final boolean enablePreloadCoreClassInDexMode;

    /* renamed from: K, reason: from kotlin metadata */
    private final com.tencent.kuikly.core.render.android.expand.a delegate;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private com.tencent.kuikly.core.render.android.core.b renderCore;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private final j kuiklyRenderViewContext;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private SizeF lastSize;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private Function1<? super SizeF, Unit> initRenderCoreLazyTask;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private final h renderExport;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private ArrayList<Function1<com.tencent.kuikly.core.render.android.core.b, Unit>> coreLazyTaskList;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0013\n\u0002\u0010\b\n\u0002\b\u0019\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b-\u0010.R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0005\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u0004R\u0014\u0010\u0006\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u0004R\u0014\u0010\u0007\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\u0004R\u0014\u0010\b\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\b\u0010\u0004R\u0014\u0010\t\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\t\u0010\u0004R\u0014\u0010\n\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\n\u0010\u0004R\u0014\u0010\u000b\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\u0004R\u0014\u0010\f\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\f\u0010\u0004R\u0014\u0010\r\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\r\u0010\u0004R\u0014\u0010\u000e\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\u0004R\u0014\u0010\u000f\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\u0004R\u0014\u0010\u0010\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\u0004R\u0014\u0010\u0011\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\u0004R\u0014\u0010\u0012\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\u0004R\u0014\u0010\u0013\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0013\u0010\u0004R\u0014\u0010\u0014\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0014\u0010\u0004R\u0014\u0010\u0015\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0015\u0010\u0004R\u0014\u0010\u0017\u001a\u00020\u00168\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0017\u0010\u0018R\u0014\u0010\u0019\u001a\u00020\u00168\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0019\u0010\u0018R\u0014\u0010\u001a\u001a\u00020\u00168\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u001a\u0010\u0018R\u0014\u0010\u001b\u001a\u00020\u00168\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u001b\u0010\u0018R\u0014\u0010\u001c\u001a\u00020\u00168\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u001c\u0010\u0018R\u0014\u0010\u001d\u001a\u00020\u00168\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u001d\u0010\u0018R\u0014\u0010\u001e\u001a\u00020\u00168\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u001e\u0010\u0018R\u0014\u0010\u001f\u001a\u00020\u00168\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u001f\u0010\u0018R\u0014\u0010 \u001a\u00020\u00168\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b \u0010\u0018R\u0014\u0010!\u001a\u00020\u00168\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b!\u0010\u0018R\u0014\u0010\"\u001a\u00020\u00168\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\"\u0010\u0018R\u0014\u0010#\u001a\u00020\u00168\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b#\u0010\u0018R\u0014\u0010$\u001a\u00020\u00168\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b$\u0010\u0018R\u0014\u0010%\u001a\u00020\u00168\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b%\u0010\u0018R\u0014\u0010&\u001a\u00020\u00168\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b&\u0010\u0018R\u0014\u0010'\u001a\u00020\u00168\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b'\u0010\u0018R\u0014\u0010(\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b(\u0010\u0004R\u0014\u0010)\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b)\u0010\u0004R\u0014\u0010*\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b*\u0010\u0004R\u0014\u0010+\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b+\u0010\u0004R\u0014\u0010,\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b,\u0010\u0004\u00a8\u0006/"}, d2 = {"Lcom/tencent/kuikly/core/render/android/KuiklyRenderView$a;", "", "", "ACCESSIBILITY_RUNNING", "Ljava/lang/String;", "ACTIVITY_HEIGHT", "ACTIVITY_WIDTH", "ANDROID_BOTTOM_NAV_BAR_HEIGHT", IGuildMainFrameApi.APP_VERSION, "DENSITY", "DEVICE_HEIGHT", "DEVICE_WIDTH", "EVENT_ROOT_VIEW_SIZE_CHANGED", "NATIVE_BUILD", "OS_VERSION", "PAGER_EVENT_FIRST_FRAME_PAINT", "PARAMS", "PLATFORM", "ROOT_VIEW_HEIGHT", "ROOT_VIEW_WIDTH", "SAFE_AREA_INSETS", "SCALE_FONT_ENABLE", "", "STATE_CREATE_INSTANCE_FINISH", "I", "STATE_CREATE_INSTANCE_START", "STATE_DESTROY", "STATE_FIRST_FRAME_PAINT", "STATE_INIT", "STATE_INIT_CONTEXT_FINISH", "STATE_INIT_CONTEXT_START", "STATE_INIT_CORE_FINISH", "STATE_INIT_CORE_START", "STATE_INIT_LAYER_READ_CACHE_FINISH", "STATE_INIT_LAYER_READ_CACHE_START", "STATE_INIT_LAYER_RENDER_CACHE_FINISH", "STATE_INIT_LAYER_RENDER_CACHE_START", "STATE_PAUSE", "STATE_PRELOAD_DEX_CLASS_FINISH", "STATE_RESUME", "STATUS_BAR_HEIGHT", "VIEW_DID_APPEAR", "VIEW_DID_APPEAR_VALUE", "VIEW_DID_DISAPPEAR", "VIEW_DID_DISAPPEAR_VALUE", "<init>", "()V", "core-render-android_debug"}, k = 1, mv = {1, 4, 1})
    /* renamed from: com.tencent.kuikly.core.render.android.KuiklyRenderView$a, reason: from kotlin metadata */
    /* loaded from: classes7.dex */
    public static final class Companion {
        Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016\u00a8\u0006\b"}, d2 = {"com/tencent/kuikly/core/render/android/KuiklyRenderView$b", "Lcom/tencent/kuikly/core/render/android/exception/a;", "", "throwable", "Lcom/tencent/kuikly/core/render/android/exception/ErrorReason;", HiAnalyticsConstant.HaKey.BI_KEY_ERRORREASON, "", "b", "core-render-android_debug"}, k = 1, mv = {1, 4, 1})
    /* loaded from: classes7.dex */
    public static final class b implements com.tencent.kuikly.core.render.android.exception.a {
        b() {
        }

        @Override // com.tencent.kuikly.core.render.android.exception.a
        public void b(@NotNull Throwable throwable, @NotNull ErrorReason errorReason) {
            Intrinsics.checkNotNullParameter(throwable, "throwable");
            Intrinsics.checkNotNullParameter(errorReason, "errorReason");
            Iterator it = KuiklyRenderView.this.lifecycleCallbacks.iterator();
            while (it.hasNext()) {
                ((e) it.next()).b(throwable, errorReason);
            }
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0004\u001a\u00020\u0002H\u0016J\b\u0010\u0005\u001a\u00020\u0002H\u0016J\b\u0010\u0006\u001a\u00020\u0002H\u0016\u00a8\u0006\u0007"}, d2 = {"com/tencent/kuikly/core/render/android/KuiklyRenderView$c", "Lcom/tencent/kuikly/core/render/android/core/a;", "", "onStart", "onFinish", "c", "a", "core-render-android_debug"}, k = 1, mv = {1, 4, 1})
    /* loaded from: classes7.dex */
    public static final class c implements com.tencent.kuikly.core.render.android.core.a {
        c() {
        }

        @Override // com.tencent.kuikly.core.render.android.core.a
        public void a() {
            KuiklyRenderView.r(KuiklyRenderView.this, 11, null, 2, null);
        }

        @Override // com.tencent.kuikly.core.render.android.core.a
        public void c() {
            KuiklyRenderView.r(KuiklyRenderView.this, 10, null, 2, null);
        }

        @Override // com.tencent.kuikly.core.render.android.core.a
        public void onFinish() {
            KuiklyRenderView.r(KuiklyRenderView.this, 5, null, 2, null);
        }

        @Override // com.tencent.kuikly.core.render.android.core.a
        public void onStart() {
            KuiklyRenderView.r(KuiklyRenderView.this, 4, null, 2, null);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public KuiklyRenderView(@NotNull Context context, @NotNull KuiklyRenderCoreExecuteMode executeMode, boolean z16, @Nullable com.tencent.kuikly.core.render.android.expand.a aVar) {
        super(context);
        boolean z17;
        boolean z18;
        boolean z19;
        Lazy lazy;
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(executeMode, "executeMode");
        this.executeMode = executeMode;
        this.enablePreloadCoreClassInDexMode = z16;
        this.delegate = aVar;
        if (aVar != null && aVar.Cc() && (context instanceof j)) {
            context = ((j) context).getBaseContext();
            Intrinsics.checkNotNull(context);
        }
        Context context2 = context;
        if (aVar != null) {
            z17 = aVar.Cc();
        } else {
            z17 = false;
        }
        if (aVar != null) {
            z18 = aVar.getUseHostDisplayMetrics();
        } else {
            z18 = false;
        }
        if (aVar != null) {
            z19 = aVar.u0();
        } else {
            z19 = false;
        }
        this.kuiklyRenderViewContext = new j(context2, this, z17, z18, z19);
        this.renderExport = new h(getKuiklyRenderContext());
        this.coreLazyTaskList = new ArrayList<>();
        this.lifecycleCallbacks = new ArrayList<>();
        lazy = LazyKt__LazyJVMKt.lazy(LazyThreadSafetyMode.NONE, (Function0) new Function0<List<com.tencent.kuikly.core.render.android.c>>() { // from class: com.tencent.kuikly.core.render.android.KuiklyRenderView$kuiklyRenderLifecycleCallbacks$2
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final List<c> invoke() {
                return new ArrayList();
            }
        });
        this.kuiklyRenderLifecycleCallbacks = lazy;
        this.exceptionListener = new b();
        setClipChildren(false);
    }

    private final boolean A() {
        return com.tencent.kuikly.core.render.android.expand.module.b.INSTANCE.a(getContext());
    }

    private final void D() {
        com.tencent.kuikly.core.render.android.core.b bVar = this.renderCore;
        if (bVar != null) {
            Iterator<Function1<com.tencent.kuikly.core.render.android.core.b, Unit>> it = this.coreLazyTaskList.iterator();
            while (it.hasNext()) {
                it.next().invoke(bVar);
            }
            this.coreLazyTaskList.clear();
        }
    }

    private final void E(int w3, int h16) {
        Function1<? super SizeF, Unit> function1 = this.initRenderCoreLazyTask;
        if (function1 == null) {
            return;
        }
        if (function1 != null) {
            function1.invoke(new SizeF(w3, h16));
        }
        this.initRenderCoreLazyTask = null;
    }

    private final void I(int w3, int h16) {
        Map mapOf;
        SizeF sizeF = new SizeF(w3, h16);
        if (this.lastSize == null) {
            this.lastSize = sizeF;
            return;
        }
        if (!Intrinsics.areEqual(r6, sizeF)) {
            Size u16 = u();
            Size v3 = v();
            mapOf = MapsKt__MapsKt.mapOf(TuplesKt.to("width", Float.valueOf(com.tencent.kuikly.core.render.android.css.ktx.b.x(getKuiklyRenderContext(), sizeF.getWidth()))), TuplesKt.to("height", Float.valueOf(com.tencent.kuikly.core.render.android.css.ktx.b.x(getKuiklyRenderContext(), sizeF.getHeight()))), TuplesKt.to("activityWidth", Float.valueOf(com.tencent.kuikly.core.render.android.css.ktx.b.x(getKuiklyRenderContext(), u16.getWidth()))), TuplesKt.to("activityHeight", Float.valueOf(com.tencent.kuikly.core.render.android.css.ktx.b.x(getKuiklyRenderContext(), u16.getHeight()))), TuplesKt.to("deviceWidth", Float.valueOf(com.tencent.kuikly.core.render.android.css.ktx.b.x(getKuiklyRenderContext(), v3.getWidth()))), TuplesKt.to("deviceHeight", Float.valueOf(com.tencent.kuikly.core.render.android.css.ktx.b.x(getKuiklyRenderContext(), v3.getHeight()))));
            d(Pager.PAGER_EVENT_ROOT_VIEW_SIZE_CHANGED, mapOf);
            this.lastSize = sizeF;
        }
    }

    private final void K() {
        List<Pair<String, Object>> list = this.coreEventLazyEventList;
        if (list != null) {
            for (Pair<String, Object> pair : list) {
                com.tencent.kuikly.core.render.android.core.b bVar = this.renderCore;
                if (bVar != null) {
                    bVar.d(pair.getFirst(), pair.getSecond());
                }
            }
            this.coreEventLazyEventList = null;
        }
    }

    private final void k(Function1<? super com.tencent.kuikly.core.render.android.core.b, Unit> task) {
        com.tencent.kuikly.core.render.android.core.b bVar = this.renderCore;
        if (bVar != null) {
            Intrinsics.checkNotNull(bVar);
            task.invoke(bVar);
        } else {
            this.coreLazyTaskList.add(task);
        }
    }

    private final com.tencent.kuikly.core.render.android.context.b m() {
        com.tencent.kuikly.core.render.android.context.f fVar = new com.tencent.kuikly.core.render.android.context.f(this.kuiklyDexClassLoader);
        this.kuiklyDexClassLoader = null;
        return fVar;
    }

    private final com.tencent.kuikly.core.render.android.core.b n(KuiklyContextParams contextParams) {
        com.tencent.kuikly.core.render.android.context.b hVar;
        int i3 = i.f118113a[this.executeMode.ordinal()];
        if (i3 != 1) {
            if (i3 != 2) {
                if (i3 != 3) {
                    if (i3 == 4) {
                        hVar = m();
                    } else {
                        throw new NoWhenBranchMatchedException();
                    }
                } else {
                    hVar = new com.tencent.kuikly.core.render.android.context.g();
                }
            } else {
                hVar = new KuiklyRenderNativeContextHandler();
            }
        } else {
            hVar = new com.tencent.kuikly.core.render.android.context.h();
        }
        if (hVar != null) {
            ((com.tencent.kuikly.core.render.android.context.e) hVar).setContextParams(contextParams);
            KuiklyRenderCore kuiklyRenderCore = new KuiklyRenderCore(hVar);
            kuiklyRenderCore.h0(this.exceptionListener);
            return kuiklyRenderCore;
        }
        throw new NullPointerException("null cannot be cast to non-null type com.tencent.kuikly.core.render.android.context.KuiklyRenderCommonContextHandler");
    }

    private final void q(int state, Object params) {
        switch (state) {
            case 0:
                Iterator<T> it = this.lifecycleCallbacks.iterator();
                while (it.hasNext()) {
                    ((e) it.next()).onInit();
                }
                return;
            case 1:
                Iterator<T> it5 = this.lifecycleCallbacks.iterator();
                while (it5.hasNext()) {
                    ((e) it5.next()).l();
                }
                return;
            case 2:
                Iterator<T> it6 = this.lifecycleCallbacks.iterator();
                while (it6.hasNext()) {
                    ((e) it6.next()).j();
                }
                return;
            case 3:
                Iterator<T> it7 = this.lifecycleCallbacks.iterator();
                while (it7.hasNext()) {
                    ((e) it7.next()).f();
                }
                return;
            case 4:
                Iterator<T> it8 = this.lifecycleCallbacks.iterator();
                while (it8.hasNext()) {
                    ((e) it8.next()).k();
                }
                return;
            case 5:
                Iterator<T> it9 = this.lifecycleCallbacks.iterator();
                while (it9.hasNext()) {
                    ((e) it9.next()).i();
                }
                return;
            case 6:
                Iterator<T> it10 = this.lifecycleCallbacks.iterator();
                while (it10.hasNext()) {
                    ((e) it10.next()).h();
                }
                return;
            case 7:
                Iterator<T> it11 = this.lifecycleCallbacks.iterator();
                while (it11.hasNext()) {
                    ((e) it11.next()).d();
                }
                return;
            case 8:
                Iterator<T> it12 = this.lifecycleCallbacks.iterator();
                while (it12.hasNext()) {
                    ((e) it12.next()).m();
                }
                return;
            case 9:
                Iterator<T> it13 = this.lifecycleCallbacks.iterator();
                while (it13.hasNext()) {
                    ((e) it13.next()).g();
                }
                return;
            case 10:
                Iterator<T> it14 = this.lifecycleCallbacks.iterator();
                while (it14.hasNext()) {
                    ((e) it14.next()).c();
                }
                return;
            case 11:
                Iterator<T> it15 = this.lifecycleCallbacks.iterator();
                while (it15.hasNext()) {
                    ((e) it15.next()).a();
                }
                return;
            case 12:
                Iterator<T> it16 = this.lifecycleCallbacks.iterator();
                while (it16.hasNext()) {
                    ((e) it16.next()).e();
                }
                return;
            case 13:
                Iterator<T> it17 = this.lifecycleCallbacks.iterator();
                while (it17.hasNext()) {
                    ((e) it17.next()).onResume();
                }
                return;
            case 14:
                Iterator<T> it18 = this.lifecycleCallbacks.iterator();
                while (it18.hasNext()) {
                    ((e) it18.next()).onPause();
                }
                return;
            case 15:
                Iterator<T> it19 = this.lifecycleCallbacks.iterator();
                while (it19.hasNext()) {
                    ((e) it19.next()).onDestroy();
                }
                return;
            default:
                return;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void r(KuiklyRenderView kuiklyRenderView, int i3, Object obj, int i16, Object obj2) {
        if ((i16 & 2) != 0) {
            obj = null;
        }
        kuiklyRenderView.q(i3, obj);
    }

    private final Map<String, Object> t(Map<String, ? extends Object> params, SizeF size) {
        Map<String, Object> O1;
        Size u16 = u();
        Size v3 = v();
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put("rootViewWidth", Float.valueOf(com.tencent.kuikly.core.render.android.css.ktx.b.x(this.kuiklyRenderViewContext, size.getWidth())));
        linkedHashMap.put("rootViewHeight", Float.valueOf(com.tencent.kuikly.core.render.android.css.ktx.b.x(this.kuiklyRenderViewContext, size.getHeight())));
        j jVar = this.kuiklyRenderViewContext;
        Context context = getContext();
        Intrinsics.checkNotNullExpressionValue(context, "context");
        linkedHashMap.put("statusBarHeight", Float.valueOf(com.tencent.kuikly.core.render.android.css.ktx.b.x(jVar, KRCSSViewExtensionKt.u(context))));
        linkedHashMap.put("platform", "android");
        linkedHashMap.put("deviceWidth", Float.valueOf(com.tencent.kuikly.core.render.android.css.ktx.b.x(this.kuiklyRenderViewContext, v3.getWidth())));
        linkedHashMap.put("deviceHeight", Float.valueOf(com.tencent.kuikly.core.render.android.css.ktx.b.x(this.kuiklyRenderViewContext, v3.getHeight())));
        linkedHashMap.put("osVersion", String.valueOf(Build.VERSION.SDK_INT));
        Context context2 = getContext();
        Intrinsics.checkNotNullExpressionValue(context2, "context");
        linkedHashMap.put("appVersion", KRCSSViewExtensionKt.v(context2));
        linkedHashMap.put("param", params);
        linkedHashMap.put("nativeBuild", 9);
        StringBuilder sb5 = new StringBuilder();
        a kuiklyRenderContext = getKuiklyRenderContext();
        Context context3 = getContext();
        Intrinsics.checkNotNullExpressionValue(context3, "context");
        sb5.append(com.tencent.kuikly.core.render.android.css.ktx.b.x(kuiklyRenderContext, KRCSSViewExtensionKt.u(context3)));
        sb5.append(" 0 0 0");
        linkedHashMap.put("safeAreaInsets", sb5.toString());
        linkedHashMap.put("activityWidth", Float.valueOf(com.tencent.kuikly.core.render.android.css.ktx.b.x(getKuiklyRenderContext(), u16.getWidth())));
        linkedHashMap.put("activityHeight", Float.valueOf(com.tencent.kuikly.core.render.android.css.ktx.b.x(getKuiklyRenderContext(), u16.getHeight())));
        a kuiklyRenderContext2 = getKuiklyRenderContext();
        Context context4 = getContext();
        Intrinsics.checkNotNullExpressionValue(context4, "context");
        linkedHashMap.put("androidBottomNavBarHeight", Float.valueOf(com.tencent.kuikly.core.render.android.css.ktx.b.x(kuiklyRenderContext2, KRCSSViewExtensionKt.s(context4))));
        Resources system = Resources.getSystem();
        Intrinsics.checkNotNullExpressionValue(system, "Resources.getSystem()");
        linkedHashMap.put("density", Float.valueOf(system.getDisplayMetrics().density));
        linkedHashMap.put("isAccessibilityRunning", Integer.valueOf(A() ? 1 : 0));
        com.tencent.kuikly.core.render.android.expand.a aVar = this.delegate;
        if (aVar != null && (O1 = aVar.O1()) != null) {
            linkedHashMap.putAll(O1);
        }
        return linkedHashMap;
    }

    private final Size u() {
        View findViewById;
        Context context = getContext();
        Intrinsics.checkNotNullExpressionValue(context, "context");
        Activity i3 = KRCSSViewExtensionKt.i(context);
        if (i3 != null && (findViewById = i3.findViewById(R.id.content)) != null) {
            return new Size(findViewById.getWidth(), findViewById.getHeight());
        }
        return new Size(0, 0);
    }

    private final Size v() {
        Context context = getContext();
        Intrinsics.checkNotNullExpressionValue(context, "context");
        return KRCSSViewExtensionKt.k(context);
    }

    private final List<com.tencent.kuikly.core.render.android.c> w() {
        return (List) this.kuiklyRenderLifecycleCallbacks.getValue();
    }

    private final void y(String contextCode) {
        if (this.executeMode == KuiklyRenderCoreExecuteMode.DEX && this.enablePreloadCoreClassInDexMode) {
            d.Companion companion = com.tencent.kuikly.core.render.android.context.d.INSTANCE;
            ClassLoader classLoader = KuiklyRenderView.class.getClassLoader();
            Intrinsics.checkNotNullExpressionValue(classLoader, "javaClass.classLoader");
            com.tencent.kuikly.core.render.android.context.d a16 = companion.a(contextCode, classLoader);
            KuiklyRenderClassLoad.c(KuiklyRenderClassLoad.f117708b, a16, false, 2, null);
            Unit unit = Unit.INSTANCE;
            this.kuiklyDexClassLoader = a16;
        }
        r(this, 1, null, 2, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void z(String contextCode, String url, Map<String, ? extends Object> params, SizeF size, String assetsPath) {
        r(this, 2, null, 2, null);
        KuiklyContextParams kuiklyContextParams = new KuiklyContextParams(this.executeMode, url, params, assetsPath);
        this.kuiklyRenderViewContext.d(kuiklyContextParams);
        c cVar = new c();
        this.contextInitCallback = cVar;
        com.tencent.kuikly.core.render.android.core.b n3 = n(kuiklyContextParams);
        n3.l(this, contextCode, url, t(params, size), assetsPath, kuiklyContextParams, cVar, this);
        Unit unit = Unit.INSTANCE;
        this.renderCore = n3;
        r(this, 3, null, 2, null);
        K();
        D();
    }

    public void B() {
        Map mapOf;
        mapOf = MapsKt__MapsJVMKt.mapOf(TuplesKt.to(Pager.PAGER_EVENT_DID_DISAPPEAR, "1"));
        d(Pager.PAGER_EVENT_DID_DISAPPEAR, mapOf);
        r(this, 14, null, 2, null);
    }

    public void C() {
        k(new Function1<com.tencent.kuikly.core.render.android.core.b, Unit>() { // from class: com.tencent.kuikly.core.render.android.KuiklyRenderView$performAfterFirstScreenUITasks$1
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(com.tencent.kuikly.core.render.android.core.b bVar) {
                invoke2(bVar);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@NotNull com.tencent.kuikly.core.render.android.core.b it) {
                Intrinsics.checkNotNullParameter(it, "it");
                it.g();
            }
        });
    }

    public final void F(@NotNull e callback) {
        Intrinsics.checkNotNullParameter(callback, "callback");
        this.lifecycleCallbacks.add(callback);
    }

    public final void G(@NotNull Context newContext) {
        Intrinsics.checkNotNullParameter(newContext, "newContext");
        this.kuiklyRenderViewContext.e(newContext);
    }

    public void H() {
        Map mapOf;
        mapOf = MapsKt__MapsJVMKt.mapOf(TuplesKt.to(Pager.PAGER_EVENT_DID_APPEAR, "1"));
        d(Pager.PAGER_EVENT_DID_APPEAR, mapOf);
        r(this, 13, null, 2, null);
    }

    public void J() {
        k(new Function1<com.tencent.kuikly.core.render.android.core.b, Unit>() { // from class: com.tencent.kuikly.core.render.android.KuiklyRenderView$syncFlushAllRenderTasks$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(com.tencent.kuikly.core.render.android.core.b bVar) {
                invoke2(bVar);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@NotNull com.tencent.kuikly.core.render.android.core.b it) {
                Intrinsics.checkNotNullParameter(it, "it");
                if (KuiklyRenderView.this.getChildCount() <= 0) {
                    it.m();
                }
            }
        });
    }

    @Override // com.tencent.kuikly.core.render.android.core.c
    @Nullable
    public Long K0() {
        com.tencent.kuikly.core.render.android.expand.a aVar = this.delegate;
        if (aVar != null) {
            return aVar.getEmbedSceneSyncTimeout();
        }
        return null;
    }

    public final void L(@NotNull e callback) {
        Intrinsics.checkNotNullParameter(callback, "callback");
        this.lifecycleCallbacks.remove(callback);
    }

    @Override // com.tencent.kuikly.core.render.android.core.c
    @Nullable
    public String V0() {
        com.tencent.kuikly.core.render.android.expand.a aVar = this.delegate;
        if (aVar != null) {
            return aVar.V0();
        }
        return null;
    }

    @Override // com.tencent.kuikly.core.render.android.d
    @Nullable
    public <T extends i01.e> T a(@NotNull String name) {
        Intrinsics.checkNotNullParameter(name, "name");
        com.tencent.kuikly.core.render.android.core.b bVar = this.renderCore;
        if (bVar != null) {
            return (T) bVar.a(name);
        }
        return null;
    }

    @Override // android.view.ViewGroup
    public void addView(@Nullable View child, int index) {
        super.addView(child, index);
        r(this, 12, null, 2, null);
    }

    @Override // com.tencent.kuikly.core.render.android.d
    @Nullable
    public View b(int tag) {
        com.tencent.kuikly.core.render.android.core.b bVar = this.renderCore;
        if (bVar != null) {
            return bVar.b(tag);
        }
        return null;
    }

    @Override // com.tencent.kuikly.core.render.android.d
    public void c(@NotNull final Function0<Unit> task) {
        Intrinsics.checkNotNullParameter(task, "task");
        k(new Function1<com.tencent.kuikly.core.render.android.core.b, Unit>() { // from class: com.tencent.kuikly.core.render.android.KuiklyRenderView$performWhenViewDidLoad$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(com.tencent.kuikly.core.render.android.core.b bVar) {
                invoke2(bVar);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@NotNull com.tencent.kuikly.core.render.android.core.b it) {
                Intrinsics.checkNotNullParameter(it, "it");
                it.c(Function0.this);
            }
        });
    }

    @Override // com.tencent.kuikly.core.render.android.core.c
    public boolean c1() {
        com.tencent.kuikly.core.render.android.expand.a aVar = this.delegate;
        if (aVar != null) {
            return aVar.c1();
        }
        return false;
    }

    @Override // com.tencent.kuikly.core.render.android.d
    public void d(@NotNull String event, @NotNull Object data) {
        Intrinsics.checkNotNullParameter(event, "event");
        Intrinsics.checkNotNullParameter(data, "data");
        com.tencent.kuikly.core.render.android.core.b bVar = this.renderCore;
        if (bVar != null) {
            bVar.d(event, data);
            return;
        }
        List list = this.coreEventLazyEventList;
        if (list == null) {
            list = new ArrayList();
            this.coreEventLazyEventList = list;
        }
        list.add(TuplesKt.to(event, data));
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(@Nullable MotionEvent ev5) {
        com.tencent.kuikly.core.render.android.core.b bVar;
        boolean dispatchTouchEvent = super.dispatchTouchEvent(ev5);
        if (dispatchTouchEvent && (bVar = this.renderCore) != null) {
            bVar.e();
        }
        return dispatchTouchEvent;
    }

    @Override // com.tencent.kuikly.core.render.android.d
    @NotNull
    public com.tencent.kuikly.core.render.android.b e() {
        return this.renderExport;
    }

    @Override // com.tencent.kuikly.core.render.android.d
    public void f(@NotNull com.tencent.kuikly.core.render.android.c callback) {
        Intrinsics.checkNotNullParameter(callback, "callback");
        w().remove(callback);
    }

    @Override // com.tencent.kuikly.core.render.android.d
    public void g(@NotNull com.tencent.kuikly.core.render.android.c callback) {
        Intrinsics.checkNotNullParameter(callback, "callback");
        w().add(callback);
    }

    @Override // com.tencent.kuikly.core.render.android.d
    @NotNull
    public a getKuiklyRenderContext() {
        return this.kuiklyRenderViewContext;
    }

    public void l() {
        k(new Function1<com.tencent.kuikly.core.render.android.core.b, Unit>() { // from class: com.tencent.kuikly.core.render.android.KuiklyRenderView$asyncFlushFirstScreenUITasksToQueue$1
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(com.tencent.kuikly.core.render.android.core.b bVar) {
                invoke2(bVar);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@NotNull com.tencent.kuikly.core.render.android.core.b it) {
                Intrinsics.checkNotNullParameter(it, "it");
                it.f();
            }
        });
    }

    public void o() {
        r(this, 15, null, 2, null);
        com.tencent.kuikly.core.render.android.core.b bVar = this.renderCore;
        if (bVar != null) {
            bVar.destroy();
        }
        this.contextInitCallback = null;
        com.tencent.kuikly.core.render.android.css.animation.e.INSTANCE.b();
    }

    @Override // android.view.View
    protected void onSizeChanged(int w3, int h16, int oldw, int oldh) {
        super.onSizeChanged(w3, h16, oldw, oldh);
        E(w3, h16);
        I(w3, h16);
    }

    public void p() {
        k(new Function1<com.tencent.kuikly.core.render.android.core.b, Unit>() { // from class: com.tencent.kuikly.core.render.android.KuiklyRenderView$didCreateRenderView$1

            /* compiled from: P */
            @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0004\u001a\u00020\u0002H\u0016J\b\u0010\u0005\u001a\u00020\u0002H\u0016J\b\u0010\u0006\u001a\u00020\u0002H\u0016\u00a8\u0006\u0007"}, d2 = {"com/tencent/kuikly/core/render/android/KuiklyRenderView$didCreateRenderView$1$a", "Lcom/tencent/kuikly/core/render/android/layer/b;", "", "c", "b", "a", "d", "core-render-android_debug"}, k = 1, mv = {1, 4, 1})
            /* loaded from: classes7.dex */
            public static final class a implements com.tencent.kuikly.core.render.android.layer.b {
                a() {
                }

                @Override // com.tencent.kuikly.core.render.android.layer.b
                public void a() {
                    KuiklyRenderView.r(KuiklyRenderView.this, 8, null, 2, null);
                }

                @Override // com.tencent.kuikly.core.render.android.layer.b
                public void b() {
                    KuiklyRenderView.r(KuiklyRenderView.this, 7, null, 2, null);
                }

                @Override // com.tencent.kuikly.core.render.android.layer.b
                public void c() {
                    KuiklyRenderView.r(KuiklyRenderView.this, 6, null, 2, null);
                }

                @Override // com.tencent.kuikly.core.render.android.layer.b
                public void d() {
                    KuiklyRenderView.r(KuiklyRenderView.this, 9, null, 2, null);
                }
            }

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(com.tencent.kuikly.core.render.android.core.b bVar) {
                invoke2(bVar);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@NotNull com.tencent.kuikly.core.render.android.core.b it) {
                com.tencent.kuikly.core.render.android.core.b bVar;
                Intrinsics.checkNotNullParameter(it, "it");
                bVar = KuiklyRenderView.this.renderCore;
                if (bVar != null) {
                    bVar.k(new a());
                }
            }
        });
    }

    public void s(int requestCode, int resultCode, @Nullable Intent data) {
        List list;
        list = CollectionsKt___CollectionsKt.toList(w());
        Iterator it = list.iterator();
        while (it.hasNext()) {
            ((com.tencent.kuikly.core.render.android.c) it.next()).onActivityResult(requestCode, resultCode, data);
        }
    }

    public final void setKotlinBridgeStatusListener(@NotNull com.tencent.kuikly.core.render.android.context.a listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        com.tencent.kuikly.core.render.android.core.b bVar = this.renderCore;
        if (bVar != null) {
            bVar.i(listener);
        }
    }

    public final void setViewTreeUpdateListener(@NotNull f listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        com.tencent.kuikly.core.render.android.core.b bVar = this.renderCore;
        if (bVar != null) {
            bVar.j(listener);
        }
    }

    public void x(@NotNull final String contextCode, @NotNull final String pageName, @NotNull final Map<String, ? extends Object> params, @Nullable Size size, @Nullable final String assetsPath) {
        Intrinsics.checkNotNullParameter(contextCode, "contextCode");
        Intrinsics.checkNotNullParameter(pageName, "pageName");
        Intrinsics.checkNotNullParameter(params, "params");
        r(this, 0, null, 2, null);
        com.tencent.kuikly.core.render.android.css.ktx.b.l();
        y(contextCode);
        Function1<SizeF, Unit> function1 = new Function1<SizeF, Unit>() { // from class: com.tencent.kuikly.core.render.android.KuiklyRenderView$init$initRenderCoreLazyTask$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(SizeF sizeF) {
                invoke2(sizeF);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@NotNull SizeF sz5) {
                Intrinsics.checkNotNullParameter(sz5, "sz");
                KuiklyRenderView.this.z(contextCode, pageName, params, sz5, assetsPath);
            }
        };
        if (size != null) {
            SizeF sizeF = new SizeF(size.getWidth(), size.getHeight());
            function1.invoke(sizeF);
            this.lastSize = sizeF;
        } else {
            SizeF sizeF2 = this.lastSize;
            if (sizeF2 == null) {
                this.initRenderCoreLazyTask = function1;
            } else {
                function1.invoke(sizeF2);
            }
        }
    }

    @Override // com.tencent.kuikly.core.render.android.d
    @NotNull
    public ViewGroup getView() {
        return this;
    }
}

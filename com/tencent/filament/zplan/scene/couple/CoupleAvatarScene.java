package com.tencent.filament.zplan.scene.couple;

import android.graphics.Point;
import android.graphics.PointF;
import android.graphics.SurfaceTexture;
import androidx.exifinterface.media.ExifInterface;
import com.google.gson.Gson;
import com.tencent.ams.dynamicwidget.report.LinkReportConstant$BizKey;
import com.tencent.filament.zplan.app.impl.FilamentNativeAppV2305;
import com.tencent.filament.zplan.app.scene.BaseSceneV2305;
import com.tencent.filament.zplan.avatar.CameraParams;
import com.tencent.filament.zplan.avatar.FovProjection;
import com.tencent.filament.zplan.avatar.IndirectLight;
import com.tencent.filament.zplan.avatar.LensProjection;
import com.tencent.filament.zplan.avatar.LightsParams;
import com.tencent.filament.zplan.avatar.ZPlanAvatarResourceHelper;
import com.tencent.filament.zplan.avatar.exception.BlackListResourceException;
import com.tencent.filament.zplan.avatar.exception.FetchFileException;
import com.tencent.filament.zplan.avatar.exception.IllegalViewerException;
import com.tencent.filament.zplan.avatar.model.BootResourceModel;
import com.tencent.filament.zplan.avatar.model.ReloadAvatarResourceModel;
import com.tencent.filament.zplan.avatar.model.Resource;
import com.tencent.filament.zplan.engine.FilamentViewerV2;
import com.tencent.filament.zplan.engine.FilamentViewerV2305;
import com.tencent.filament.zplan.engine.js.FilamentFileUtil;
import com.tencent.filament.zplan.scene.couple.CoupleAvatarScene;
import com.tencent.filament.zplan.scene.couple.config.AvatarConfig;
import com.tencent.filament.zplan.scene.couple.config.BpConfig;
import com.tencent.filament.zplan.scene.couple.config.ItemConfig;
import com.tencent.filament.zplan.scene.couple.config.SceneConfig;
import com.tencent.filament.zplan.scene.couple.config.d;
import com.tencent.filament.zplan.view.event.TouchEvent;
import com.tencent.filament.zplan.view.event.TouchEventType;
import com.tencent.filament.zplanservice.feature.FilamentFeatureUtil;
import com.tencent.filament.zplanservice.feature.model.FilamentUrlTemplate;
import com.tencent.filament.zplanservice.util.log.FLog;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.rmonitor.custom.ICustomDataEditor;
import com.tencent.zplan.common.model.AppTheme;
import com.tencent.zplan.common.utils.h;
import com.tencent.zplan.zplantracing.ZPlanSpanFactory;
import com.tencent.zplan.zplantracing.c;
import dl0.g;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.coroutines.AbstractCoroutineContextElement;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineExceptionHandler;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Deferred;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.SupervisorKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONArray;
import org.json.JSONObject;
import sk0.b;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u00a6\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0006\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u0003\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007*\u0002\u00a9\u0001\u0018\u0000 \u00b8\u00012\u00020\u00012\u00020\u0002:\u0004\u00b9\u0001\u00ba\u0001B$\u0012\b\u0010\u0010\u001a\u0004\u0018\u00010\u000f\u0012\u000f\u0010\u00b5\u0001\u001a\n\u0012\u0005\u0012\u00030\u00b4\u00010\u00b3\u0001\u00a2\u0006\u0006\b\u00b6\u0001\u0010\u00b7\u0001J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0003H\u0016J \u0010\r\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\nH\u0016J \u0010\u000e\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\nH\u0016J%\u0010\u0014\u001a\u00020\u00132\b\u0010\u0010\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\u0012\u001a\u00020\u0011H\u0082@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0014\u0010\u0015J%\u0010\u0017\u001a\u00020\u00062\b\u0010\u0010\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\u0016\u001a\u00020\u0013H\u0082@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0017\u0010\u0018JA\u0010\u001e\u001a\u00020\u001d2\b\u0010\u0010\u001a\u0004\u0018\u00010\u000f2\b\u0010\u0019\u001a\u0004\u0018\u00010\u00112\b\u0010\u001a\u001a\u0004\u0018\u00010\u00112\u0006\u0010\u001b\u001a\u00020\u00112\u0006\u0010\u001c\u001a\u00020\u0011H\u0082@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u001e\u0010\u001fJ\u001a\u0010\"\u001a\u00020\u00062\u0006\u0010 \u001a\u00020\n2\b\u0010!\u001a\u0004\u0018\u00010\u0011H\u0016J\b\u0010#\u001a\u00020\u0006H\u0016J\b\u0010$\u001a\u00020\u0006H\u0016J\b\u0010%\u001a\u00020\u0003H\u0016J\u001c\u0010)\u001a\u0004\u0018\u00010(2\u0006\u0010'\u001a\u00020&2\b\u0010\u0010\u001a\u0004\u0018\u00010\u000fH\u0002J\u001c\u0010,\u001a\u00020+2\b\u0010\u0010\u001a\u0004\u0018\u00010\u000f2\b\u0010*\u001a\u0004\u0018\u00010\u0011H\u0002J\u001c\u0010-\u001a\u00020+2\b\u0010\u0010\u001a\u0004\u0018\u00010\u000f2\b\u0010*\u001a\u0004\u0018\u00010\u0011H\u0002J\u001e\u00101\u001a\u00020\u00062\u0006\u0010.\u001a\u00020\u00112\f\u00100\u001a\b\u0012\u0004\u0012\u00020\u00060/H\u0002JJ\u0010>\u001a\u00020\u00062\b\u0010\u0010\u001a\u0004\u0018\u00010\u000f2\u0006\u00103\u001a\u0002022\u0006\u00105\u001a\u0002042\u0006\u00107\u001a\u0002062\u0006\u00108\u001a\u0002042\u0006\u00109\u001a\u0002062\u0006\u0010;\u001a\u00020:2\u0006\u0010=\u001a\u00020<H\u0002JJ\u0010?\u001a\u00020\u00062\b\u0010\u0010\u001a\u0004\u0018\u00010\u000f2\u0006\u00103\u001a\u0002022\u0006\u00105\u001a\u0002042\u0006\u00107\u001a\u0002062\u0006\u00108\u001a\u0002042\u0006\u00109\u001a\u0002062\u0006\u0010;\u001a\u00020:2\u0006\u0010=\u001a\u00020<H\u0002J\u001a\u0010B\u001a\u00020\u00062\b\u0010\u0010\u001a\u0004\u0018\u00010\u000f2\u0006\u0010A\u001a\u00020@H\u0002JL\u0010I\u001a\u00020E2\b\u0010\u0010\u001a\u0004\u0018\u00010\u000f2\u0006\u0010A\u001a\u00020@2\u0006\u0010C\u001a\u0002062\u0006\u0010D\u001a\u0002042\n\b\u0002\u0010F\u001a\u0004\u0018\u00010E2\b\b\u0002\u0010=\u001a\u00020<2\n\b\u0002\u0010H\u001a\u0004\u0018\u00010GH\u0002J \u0010L\u001a\b\u0012\u0004\u0012\u0002020K2\b\u0010\u0010\u001a\u0004\u0018\u00010\u000f2\u0006\u0010J\u001a\u00020\u0011H\u0002J\"\u0010M\u001a\u00020\u00062\b\u0010\u0010\u001a\u0004\u0018\u00010\u000f2\u0006\u00103\u001a\u0002022\u0006\u0010J\u001a\u00020\u0011H\u0002J\"\u0010P\u001a\u00020\u00062\b\u0010O\u001a\u0004\u0018\u00010N2\u0006\u00103\u001a\u0002022\u0006\u0010J\u001a\u00020\u0011H\u0002J \u0010R\u001a\b\u0012\u0004\u0012\u0002040K2\b\u0010\u0010\u001a\u0004\u0018\u00010\u000f2\u0006\u0010Q\u001a\u000206H\u0002J8\u0010V\u001a\b\u0012\u0004\u0012\u00020:0K2\b\u0010\u0010\u001a\u0004\u0018\u00010\u000f2\u0006\u0010S\u001a\u00020\n2\u0006\u0010U\u001a\u00020T2\u0006\u00107\u001a\u0002062\u0006\u00109\u001a\u000206H\u0002J(\u0010X\u001a\b\u0012\u0004\u0012\u00020\u001d0K2\b\u0010\u0010\u001a\u0004\u0018\u00010\u000f2\u0006\u0010W\u001a\u00020\n2\u0006\u0010C\u001a\u000206H\u0002J<\u0010[\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u001d\u0012\u0004\u0012\u00020\u001d0Z0K2\b\u0010\u0010\u001a\u0004\u0018\u00010\u000f2\u0006\u0010Y\u001a\u00020\n2\u0006\u00107\u001a\u0002062\u0006\u00109\u001a\u000206H\u0002J\"\u0010\\\u001a\u0002062\b\u0010\u0010\u001a\u0004\u0018\u00010\u000f2\u0006\u0010D\u001a\u0002042\u0006\u0010C\u001a\u000206H\u0002J\u001a\u0010_\u001a\u00020\u00062\u0006\u0010]\u001a\u00020\u00132\b\u0010^\u001a\u0004\u0018\u00010\u0011H\u0002J\u0010\u0010`\u001a\u00020\u00062\u0006\u0010]\u001a\u00020\u0013H\u0002J\u0010\u0010a\u001a\u00020\u00062\u0006\u0010]\u001a\u00020\u0013H\u0002J\u001c\u0010b\u001a\u00020\u00062\b\u0010\u0010\u001a\u0004\u0018\u00010\u000f2\b\u0010*\u001a\u0004\u0018\u00010\u0011H\u0002J\u001a\u0010e\u001a\u00020\u00062\b\u0010\u0010\u001a\u0004\u0018\u00010\u000f2\u0006\u0010d\u001a\u00020cH\u0002J\u001a\u0010f\u001a\u00020\u00062\b\u0010\u0010\u001a\u0004\u0018\u00010\u000f2\u0006\u0010d\u001a\u00020cH\u0002J\u001a\u0010g\u001a\u00020\u00062\b\u0010\u0010\u001a\u0004\u0018\u00010\u000f2\u0006\u0010d\u001a\u00020cH\u0002J&\u0010l\u001a\u00020\u00062\b\u0010\u0010\u001a\u0004\u0018\u00010\u000f2\u0006\u0010i\u001a\u00020h2\n\u0010k\u001a\u00060\u0003j\u0002`jH\u0002J\u0018\u0010p\u001a\u00020o2\u0006\u0010A\u001a\u00020@2\u0006\u0010n\u001a\u00020mH\u0002JE\u0010u\u001a\u00020\u00062\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u000f2\u0006\u0010q\u001a\u00020\u00112\b\u0010r\u001a\u0004\u0018\u0001062\n\b\u0002\u0010s\u001a\u0004\u0018\u00010<2\n\b\u0002\u0010t\u001a\u0004\u0018\u00010\u0011H\u0002\u00a2\u0006\u0004\bu\u0010vJ\u0012\u0010w\u001a\u00020\u00062\b\u0010r\u001a\u0004\u0018\u00010\u0011H\u0002J\u001c\u0010x\u001a\u00020+2\b\u0010\u0010\u001a\u0004\u0018\u00010\u000f2\b\u0010*\u001a\u0004\u0018\u00010\u0011H\u0002J\u001c\u0010y\u001a\u00020+2\b\u0010\u0010\u001a\u0004\u0018\u00010\u000f2\b\u0010*\u001a\u0004\u0018\u00010\u0011H\u0002J\u001c\u0010z\u001a\u00020\u00062\b\u0010\u0010\u001a\u0004\u0018\u00010\u000f2\b\u0010*\u001a\u0004\u0018\u00010\u0011H\u0002J\u0010\u0010}\u001a\u00020\u00062\u0006\u0010|\u001a\u00020{H\u0002R\u0016\u0010\u0081\u0001\u001a\u00020~8\u0002X\u0082\u0004\u00a2\u0006\u0007\n\u0005\b\u007f\u0010\u0080\u0001R\u0018\u0010\u0085\u0001\u001a\u00030\u0082\u00018\u0002X\u0082\u0004\u00a2\u0006\b\n\u0006\b\u0083\u0001\u0010\u0084\u0001R\u0018\u0010\u0089\u0001\u001a\u00030\u0086\u00018\u0002X\u0082\u0004\u00a2\u0006\b\n\u0006\b\u0087\u0001\u0010\u0088\u0001R\u0018\u0010\u008b\u0001\u001a\u00030\u0086\u00018\u0002X\u0082\u0004\u00a2\u0006\b\n\u0006\b\u008a\u0001\u0010\u0088\u0001R\u001a\u0010;\u001a\u0004\u0018\u00010:8\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u008c\u0001\u0010\u008d\u0001R\u001b\u0010\u0090\u0001\u001a\u0004\u0018\u00010E8\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u008e\u0001\u0010\u008f\u0001R\u001b\u0010\u0092\u0001\u001a\u0004\u0018\u00010E8\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u0091\u0001\u0010\u008f\u0001R\u001b\u0010\u0095\u0001\u001a\u0004\u0018\u00010G8\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u0093\u0001\u0010\u0094\u0001R\u001b\u0010\u0097\u0001\u001a\u0004\u0018\u00010G8\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u0096\u0001\u0010\u0094\u0001R!\u0010\u009c\u0001\u001a\n\u0012\u0005\u0012\u00030\u0099\u00010\u0098\u00018\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u009a\u0001\u0010\u009b\u0001R\u0019\u0010\u009f\u0001\u001a\u00020&8\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u009d\u0001\u0010\u009e\u0001R\u0018\u0010\u00a1\u0001\u001a\u00030\u0086\u00018\u0002X\u0082\u0004\u00a2\u0006\b\n\u0006\b\u00a0\u0001\u0010\u0088\u0001R\u0018\u0010\u00a3\u0001\u001a\u00030\u0086\u00018\u0002X\u0082\u0004\u00a2\u0006\b\n\u0006\b\u00a2\u0001\u0010\u0088\u0001R\u0019\u0010\u00a6\u0001\u001a\u00020<8\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u00a4\u0001\u0010\u00a5\u0001R\u0019\u0010\u00a8\u0001\u001a\u00020<8\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u00a7\u0001\u0010\u00a5\u0001R\u0018\u0010\u00ac\u0001\u001a\u00030\u00a9\u00018\u0002X\u0082\u0004\u00a2\u0006\b\n\u0006\b\u00aa\u0001\u0010\u00ab\u0001R \u0010\u00b2\u0001\u001a\u00030\u00ad\u00018\u0016X\u0096\u0004\u00a2\u0006\u0010\n\u0006\b\u00ae\u0001\u0010\u00af\u0001\u001a\u0006\b\u00b0\u0001\u0010\u00b1\u0001\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u00bb\u0001"}, d2 = {"Lcom/tencent/filament/zplan/scene/couple/CoupleAvatarScene;", "Lcom/tencent/filament/zplan/app/scene/BaseSceneV2305;", "Lkotlinx/coroutines/CoroutineScope;", "", "totalTime", "frameTime", "", "d", "Landroid/graphics/SurfaceTexture;", "surfaceTexture", "", "width", "height", "u", ReportConstant.COSTREPORT_PREFIX, "Lcom/tencent/zplan/zplantracing/c;", "spanContext", "", "roomBpUrl", "Lcom/tencent/filament/zplan/scene/couple/config/BpConfig;", "U0", "(Lcom/tencent/zplan/zplantracing/c;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "bpConfig", "O0", "(Lcom/tencent/zplan/zplantracing/c;Lcom/tencent/filament/zplan/scene/couple/config/BpConfig;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "bpUrl", "detailBpUrl", "faceAnimUrl", "bodyAnimUrl", "Lcom/tencent/filament/zplan/scene/couple/config/a;", "S0", "(Lcom/tencent/zplan/zplantracing/c;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "errorCode", "errorMessage", "o", DomainData.DOMAIN_NAME, QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "B", "", "now", "Lcom/tencent/filament/zplan/business/api/a;", "y0", "eventData", "Lkotlinx/coroutines/Job;", "c1", "B0", "taskName", "Lkotlin/Function0;", "task", "g1", "Lcom/tencent/filament/zplan/avatar/model/BootResourceModel;", "bootResource", "Lcom/tencent/filament/zplan/avatar/model/ReloadAvatarResourceModel;", "leftAvatarResourceModel", "Lorg/json/JSONObject;", "leftAvatarCharacter", "rightAvatarResourceModel", "rightAvatarCharacter", "Lcom/tencent/filament/zplan/scene/couple/config/c;", "sceneConfig", "", "enableCrossFade", "G0", "F0", "Lcom/tencent/filament/zplan/engine/FilamentViewerV2305;", "viewer", "C0", "avatarCharacter", "avatarResourceModel", "Lxk0/a;", "oldAvatarAsset", "Lcom/tencent/filament/zplan/scene/couple/config/d;", "transform", "J0", "bodyTypeName", "Lkotlinx/coroutines/Deferred;", "P0", "z0", "Lcom/tencent/zplan/zplantracing/b;", "bootSpan", "N0", "avatarInfo", "R0", WadlProxyConsts.SCENE_ID, "Lcom/tencent/zplan/common/model/AppTheme;", "theme", "T0", "singleAnimId", "V0", "coupleAnimationId", "Lkotlin/Pair;", "Q0", "A0", "roomConfig", "indirectLightPath", "E0", "D0", "H0", "d1", "Lcom/tencent/filament/zplan/view/event/TouchEvent;", "touchEvent", ICustomDataEditor.STRING_ARRAY_PARAM_1, "Y0", "Z0", "Lcom/tencent/filament/zplan/view/event/TouchEventType;", "touchEventType", "Lcom/tencent/filament/zplan/engine/RenderObjectId;", "tapedRenderObjectId", "X0", "Landroid/graphics/PointF;", "touchPoint", "Landroid/graphics/Point;", "I0", "eventType", "data", "isSuccess", "errorMsg", "L0", "(Lcom/tencent/zplan/zplantracing/c;Ljava/lang/String;Lorg/json/JSONObject;Ljava/lang/Boolean;Ljava/lang/String;)V", "W0", "f1", "e1", "h1", "", "throwable", "b1", "Lcom/tencent/filament/zplanservice/feature/model/FilamentUrlTemplate;", "G", "Lcom/tencent/filament/zplanservice/feature/model/FilamentUrlTemplate;", "urlTemplate", "Lcl0/a;", "H", "Lcl0/a;", "coupleSceneUrlTemplate", "Ljava/util/concurrent/atomic/AtomicBoolean;", "I", "Ljava/util/concurrent/atomic/AtomicBoolean;", "booted", "J", "avatarCreated", "K", "Lcom/tencent/filament/zplan/scene/couple/config/c;", "L", "Lxk0/a;", "leftAvatar", "M", "rightAvatar", "N", "Lcom/tencent/filament/zplan/scene/couple/config/d;", "leftTransform", "P", "rightTransform", "", "Lxk0/d;", AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, "Ljava/util/List;", "sceneItemList", BdhLogUtil.LogTag.Tag_Req, "D", "animationBeginTime", ExifInterface.LATITUDE_SOUTH, "needRecordFrame", "T", "hasRecordFrame", "U", "Z", "hasDownloadFromNet", "V", "hasPaused", "com/tencent/filament/zplan/scene/couple/CoupleAvatarScene$recordFrameListener$1", "W", "Lcom/tencent/filament/zplan/scene/couple/CoupleAvatarScene$recordFrameListener$1;", "recordFrameListener", "Lkotlin/coroutines/CoroutineContext;", "X", "Lkotlin/coroutines/CoroutineContext;", "getCoroutineContext", "()Lkotlin/coroutines/CoroutineContext;", "coroutineContext", "Ljava/lang/ref/WeakReference;", "Lcom/tencent/filament/zplan/app/impl/FilamentNativeAppV2305;", "app", "<init>", "(Lcom/tencent/zplan/zplantracing/c;Ljava/lang/ref/WeakReference;)V", "Y", "AvatarTarget", "b", "zplan-android_release"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes6.dex */
public final class CoupleAvatarScene extends BaseSceneV2305 implements CoroutineScope {

    /* renamed from: Y, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: G, reason: from kotlin metadata */
    private final FilamentUrlTemplate urlTemplate;

    /* renamed from: H, reason: from kotlin metadata */
    private final cl0.a coupleSceneUrlTemplate;

    /* renamed from: I, reason: from kotlin metadata */
    private final AtomicBoolean booted;

    /* renamed from: J, reason: from kotlin metadata */
    private final AtomicBoolean avatarCreated;

    /* renamed from: K, reason: from kotlin metadata */
    private SceneConfig sceneConfig;

    /* renamed from: L, reason: from kotlin metadata */
    private xk0.a leftAvatar;

    /* renamed from: M, reason: from kotlin metadata */
    private xk0.a rightAvatar;

    /* renamed from: N, reason: from kotlin metadata */
    private d leftTransform;

    /* renamed from: P, reason: from kotlin metadata */
    private d rightTransform;

    /* renamed from: Q, reason: from kotlin metadata */
    private List<xk0.d> sceneItemList;

    /* renamed from: R, reason: from kotlin metadata */
    private double animationBeginTime;

    /* renamed from: S, reason: from kotlin metadata */
    private final AtomicBoolean needRecordFrame;

    /* renamed from: T, reason: from kotlin metadata */
    private final AtomicBoolean hasRecordFrame;

    /* renamed from: U, reason: from kotlin metadata */
    private boolean hasDownloadFromNet;

    /* renamed from: V, reason: from kotlin metadata */
    private boolean hasPaused;

    /* renamed from: W, reason: from kotlin metadata */
    private final CoupleAvatarScene$recordFrameListener$1 recordFrameListener;

    /* renamed from: X, reason: from kotlin metadata */
    @NotNull
    private final CoroutineContext coroutineContext;

    /* compiled from: P */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005\u00a8\u0006\u0006"}, d2 = {"Lcom/tencent/filament/zplan/scene/couple/CoupleAvatarScene$AvatarTarget;", "", "(Ljava/lang/String;I)V", "AVATAR_TARGET_LEFT", "AVATAR_TARGET_RIGHT", "AVATAR_TARGET_UNKNOWN", "zplan-android_release"}, k = 1, mv = {1, 4, 2})
    /* loaded from: classes6.dex */
    public enum AvatarTarget {
        AVATAR_TARGET_LEFT,
        AVATAR_TARGET_RIGHT,
        AVATAR_TARGET_UNKNOWN
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000!\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u00012\u00020\u0002J\u0018\u0010\b\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0005H\u0016\u00a8\u0006\t\u00b8\u0006\u0000"}, d2 = {"kotlinx/coroutines/CoroutineExceptionHandlerKt$CoroutineExceptionHandler$1", "Lkotlin/coroutines/AbstractCoroutineContextElement;", "Lkotlinx/coroutines/CoroutineExceptionHandler;", "Lkotlin/coroutines/CoroutineContext;", "context", "", "exception", "", "handleException", "kotlinx-coroutines-core"}, k = 1, mv = {1, 4, 2})
    /* loaded from: classes6.dex */
    public static final class a extends AbstractCoroutineContextElement implements CoroutineExceptionHandler {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ CoupleAvatarScene f105916d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(CoroutineContext.Key key, CoupleAvatarScene coupleAvatarScene) {
            super(key);
            this.f105916d = coupleAvatarScene;
        }

        @Override // kotlinx.coroutines.CoroutineExceptionHandler
        public void handleException(@NotNull CoroutineContext context, @NotNull Throwable exception) {
            FLog.INSTANCE.e("CoupleAvatarScene", "there is an error in coroutine.", exception);
            this.f105916d.b1(exception);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0015\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b(\u0010)J\u001c\u0010\b\u001a\u00020\u0007*\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0005H\u0002J$\u0010\u000b\u001a\u00020\u0007*\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u0007H\u0002J,\u0010\r\u001a\u00020\u0007*\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\u0007H\u0002J\u001c\u0010\u000f\u001a\u00020\u0007*\u00020\u00022\u0006\u0010\u000e\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\u0007H\u0002J$\u0010\u0010\u001a\u00020\u0007*\u00020\u00022\u0006\u0010\u000e\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\u0007H\u0002J\u0014\u0010\u0012\u001a\u00020\u0007*\u00020\u00022\u0006\u0010\u0011\u001a\u00020\u0003H\u0002J$\u0010\u0013\u001a\u00020\u0007*\u00020\u00022\u0006\u0010\u0011\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u0007H\u0002J,\u0010\u0014\u001a\u00020\u0007*\u00020\u00022\u0006\u0010\u0011\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\u0007H\u0002J\f\u0010\u0016\u001a\u00020\u0015*\u0004\u0018\u00010\u0007R\u0014\u0010\u0017\u001a\u00020\u00078\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0017\u0010\u0018R\u0014\u0010\u0019\u001a\u00020\u00078\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0019\u0010\u0018R\u0014\u0010\u001a\u001a\u00020\u00078\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u001a\u0010\u0018R\u0014\u0010\u001b\u001a\u00020\u00078\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u001b\u0010\u0018R\u0014\u0010\u001c\u001a\u00020\u00078\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u001c\u0010\u0018R\u0014\u0010\u001d\u001a\u00020\u00078\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u001d\u0010\u0018R\u0014\u0010\u001e\u001a\u00020\u00078\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u001e\u0010\u0018R\u0014\u0010\u001f\u001a\u00020\u00078\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u001f\u0010\u0018R\u0014\u0010 \u001a\u00020\u00078\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b \u0010\u0018R\u0014\u0010!\u001a\u00020\u00078\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b!\u0010\u0018R\u0014\u0010\"\u001a\u00020\u00078\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\"\u0010\u0018R\u0014\u0010#\u001a\u00020\u00078\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b#\u0010\u0018R\u0014\u0010$\u001a\u00020\u00078\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b$\u0010\u0018R\u0014\u0010%\u001a\u00020\u00078\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b%\u0010\u0018R\u0014\u0010&\u001a\u00020\u00078\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b&\u0010\u0018R\u0014\u0010'\u001a\u00020\u00078\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b'\u0010\u0018\u00a8\u0006*"}, d2 = {"Lcom/tencent/filament/zplan/scene/couple/CoupleAvatarScene$b;", "", "Lcl0/a;", "", WadlProxyConsts.SCENE_ID, "Lcom/tencent/zplan/common/model/AppTheme;", "theme", "", DomainData.DOMAIN_NAME, "side", "gender", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "part", "l", "singleAnimId", "p", "o", "coupleAnimationId", "j", "k", "i", "Lcom/tencent/filament/zplan/scene/couple/CoupleAvatarScene$AvatarTarget;", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "EVENT_CHANGE_DRESS", "Ljava/lang/String;", "EVENT_CHANGE_SCENE", "EVENT_LOAD_SCENE", "EVENT_PLAY_COUPLE_ANIMATION", "EVENT_PLAY_SINGLE_ANIMATION", "EVENT_REQUEST_OBJECT_NODE_POINT", "EVENT_SET_VIEWPORT", "EVENT_TOUCH", "HEAD_POINT_X", "HEAD_POINT_Y", "KEY_RENDER_OBJECT_NODE_NAME", "KEY_RENDER_OBJECT_TYPE", "KEY_REQUEST_POINT_DATA_ID", "TAG", "VALUE_RENDER_OBJECT_LEFT_AVATAR", "VALUE_RENDER_OBJECT_RIGHT_AVATAR", "<init>", "()V", "zplan-android_release"}, k = 1, mv = {1, 4, 2})
    /* renamed from: com.tencent.filament.zplan.scene.couple.CoupleAvatarScene$b, reason: from kotlin metadata */
    /* loaded from: classes6.dex */
    public static final class Companion {
        Companion() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final String i(cl0.a aVar, int i3, String str, String str2, String str3) {
            String replace$default;
            String replace$default2;
            String replace$default3;
            String replace$default4;
            replace$default = StringsKt__StringsJVMKt.replace$default(aVar.getCoupleAnimAvatarAnimUrl(), "{id}", String.valueOf(i3), false, 4, (Object) null);
            replace$default2 = StringsKt__StringsJVMKt.replace$default(replace$default, "{side}", str, false, 4, (Object) null);
            replace$default3 = StringsKt__StringsJVMKt.replace$default(replace$default2, "{gender}", str2, false, 4, (Object) null);
            replace$default4 = StringsKt__StringsJVMKt.replace$default(replace$default3, "{part}", str3, false, 4, (Object) null);
            return replace$default4;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final String j(cl0.a aVar, int i3) {
            String replace$default;
            replace$default = StringsKt__StringsJVMKt.replace$default(aVar.getCoupleAnimAvatarBpUrl(), "{id}", String.valueOf(i3), false, 4, (Object) null);
            return replace$default;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final String k(cl0.a aVar, int i3, String str, String str2) {
            String replace$default;
            String replace$default2;
            String replace$default3;
            replace$default = StringsKt__StringsJVMKt.replace$default(aVar.getCoupleAnimAvatarDetailBpUrl(), "{id}", String.valueOf(i3), false, 4, (Object) null);
            replace$default2 = StringsKt__StringsJVMKt.replace$default(replace$default, "{side}", str, false, 4, (Object) null);
            replace$default3 = StringsKt__StringsJVMKt.replace$default(replace$default2, "{gender}", str2, false, 4, (Object) null);
            return replace$default3;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final String l(cl0.a aVar, int i3, String str, String str2, String str3) {
            String replace$default;
            String replace$default2;
            String replace$default3;
            String replace$default4;
            replace$default = StringsKt__StringsJVMKt.replace$default(aVar.getSceneAvatarAnimUrl(), "{id}", String.valueOf(i3), false, 4, (Object) null);
            replace$default2 = StringsKt__StringsJVMKt.replace$default(replace$default, "{side}", str, false, 4, (Object) null);
            replace$default3 = StringsKt__StringsJVMKt.replace$default(replace$default2, "{gender}", str2, false, 4, (Object) null);
            replace$default4 = StringsKt__StringsJVMKt.replace$default(replace$default3, "{part}", str3, false, 4, (Object) null);
            return replace$default4;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final String m(cl0.a aVar, int i3, String str, String str2) {
            String replace$default;
            String replace$default2;
            String replace$default3;
            replace$default = StringsKt__StringsJVMKt.replace$default(aVar.getSceneAvatarBpUrl(), "{id}", String.valueOf(i3), false, 4, (Object) null);
            replace$default2 = StringsKt__StringsJVMKt.replace$default(replace$default, "{side}", str, false, 4, (Object) null);
            replace$default3 = StringsKt__StringsJVMKt.replace$default(replace$default2, "{gender}", str2, false, 4, (Object) null);
            return replace$default3;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final String n(cl0.a aVar, int i3, AppTheme appTheme) {
            String str;
            String replace$default;
            String replace$default2;
            if (appTheme == AppTheme.DAY) {
                str = LinkReportConstant$BizKey.BP;
            } else {
                str = "bp_night";
            }
            replace$default = StringsKt__StringsJVMKt.replace$default(aVar.getSceneBpUrl(), "{id}", String.valueOf(i3), false, 4, (Object) null);
            replace$default2 = StringsKt__StringsJVMKt.replace$default(replace$default, "{bp_theme}", str, false, 4, (Object) null);
            return replace$default2;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final String o(cl0.a aVar, int i3, String str, String str2) {
            String replace$default;
            String replace$default2;
            String replace$default3;
            replace$default = StringsKt__StringsJVMKt.replace$default(aVar.getSingleAnimAvatarAnimUrl(), "{id}", String.valueOf(i3), false, 4, (Object) null);
            replace$default2 = StringsKt__StringsJVMKt.replace$default(replace$default, "{gender}", str, false, 4, (Object) null);
            replace$default3 = StringsKt__StringsJVMKt.replace$default(replace$default2, "{part}", str2, false, 4, (Object) null);
            return replace$default3;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final String p(cl0.a aVar, int i3, String str) {
            String replace$default;
            String replace$default2;
            replace$default = StringsKt__StringsJVMKt.replace$default(aVar.getSingleAnimAvatarBpUrl(), "{id}", String.valueOf(i3), false, 4, (Object) null);
            replace$default2 = StringsKt__StringsJVMKt.replace$default(replace$default, "{gender}", str, false, 4, (Object) null);
            return replace$default2;
        }

        @NotNull
        public final AvatarTarget q(@Nullable String str) {
            AvatarTarget avatarTarget = AvatarTarget.AVATAR_TARGET_LEFT;
            if (!Intrinsics.areEqual(str, avatarTarget.toString())) {
                AvatarTarget avatarTarget2 = AvatarTarget.AVATAR_TARGET_RIGHT;
                if (!Intrinsics.areEqual(str, avatarTarget2.toString())) {
                    return AvatarTarget.AVATAR_TARGET_UNKNOWN;
                }
                return avatarTarget2;
            }
            return avatarTarget;
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J$\u0010\b\u001a\u00020\u00072\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u0006\u001a\u0004\u0018\u00010\u0004H\u0016\u00a8\u0006\t"}, d2 = {"com/tencent/filament/zplan/scene/couple/CoupleAvatarScene$c", "Lsk0/b;", "Lcom/tencent/zplan/zplantracing/c;", "spanContext", "", "type", "data", "", "handleEvent", "zplan-android_release"}, k = 1, mv = {1, 4, 2})
    /* loaded from: classes6.dex */
    public static final class c implements b {
        c() {
        }

        @Override // sk0.b
        public void handleEvent(@Nullable com.tencent.zplan.zplantracing.c spanContext, @NotNull String type, @Nullable String data) {
            Intrinsics.checkNotNullParameter(type, "type");
            switch (type.hashCode()) {
                case -1362498963:
                    if (type.equals("CoupleAvatarScene.PlaySingleAnimation")) {
                        CoupleAvatarScene.this.f1(spanContext, data);
                        return;
                    }
                    return;
                case -721728116:
                    if (type.equals("CoupleAvatarScene.ChangeDress")) {
                        CoupleAvatarScene.this.B0(spanContext, data);
                        return;
                    }
                    return;
                case -708322335:
                    if (!type.equals("CoupleAvatarScene.ChangeScene")) {
                        return;
                    }
                    break;
                case -151220147:
                    if (type.equals("CoupleAvatarScene.SetViewport")) {
                        CoupleAvatarScene.this.h1(spanContext, data);
                        return;
                    }
                    return;
                case 574521771:
                    if (!type.equals("CoupleAvatarScene.LoadScene")) {
                        return;
                    }
                    break;
                case 656014837:
                    if (type.equals("CoupleAvatarScene.PlayCoupleAnimation")) {
                        CoupleAvatarScene.this.e1(spanContext, data);
                        return;
                    }
                    return;
                case 1719579098:
                    if (type.equals("onTouchEvent")) {
                        CoupleAvatarScene.this.d1(spanContext, data);
                        return;
                    }
                    return;
                case 2040533098:
                    if (type.equals("requestRenderObjectNodePoint")) {
                        CoupleAvatarScene.this.W0(data);
                        return;
                    }
                    return;
                default:
                    return;
            }
            CoupleAvatarScene.this.c1(spanContext, data);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CoupleAvatarScene(@Nullable com.tencent.zplan.zplantracing.c cVar, @NotNull WeakReference<FilamentNativeAppV2305> app) {
        super(cVar, app);
        sk0.a configuration;
        g qqmcProxy;
        cl0.a d16;
        sk0.a configuration2;
        FilamentUrlTemplate urlTemplate;
        Intrinsics.checkNotNullParameter(app, "app");
        FilamentNativeAppV2305 filamentNativeAppV2305 = app.get();
        this.urlTemplate = (filamentNativeAppV2305 == null || (configuration2 = filamentNativeAppV2305.getConfiguration()) == null || (urlTemplate = configuration2.getUrlTemplate()) == null) ? FilamentFeatureUtil.f106409g.F() : urlTemplate;
        FilamentNativeAppV2305 filamentNativeAppV23052 = app.get();
        this.coupleSceneUrlTemplate = (filamentNativeAppV23052 == null || (configuration = filamentNativeAppV23052.getConfiguration()) == null || (qqmcProxy = configuration.getQqmcProxy()) == null || (d16 = qqmcProxy.d()) == null) ? new cl0.a(null, 1, null) : d16;
        this.booted = new AtomicBoolean(false);
        this.avatarCreated = new AtomicBoolean(false);
        this.sceneItemList = new ArrayList();
        this.needRecordFrame = new AtomicBoolean(false);
        this.hasRecordFrame = new AtomicBoolean(false);
        this.recordFrameListener = new CoupleAvatarScene$recordFrameListener$1(this, app);
        c cVar2 = new c();
        FilamentNativeAppV2305 filamentNativeAppV23053 = app.get();
        if (filamentNativeAppV23053 != null) {
            filamentNativeAppV23053.addEventListener("CoupleAvatarScene.LoadScene", cVar2);
        }
        if (filamentNativeAppV23053 != null) {
            filamentNativeAppV23053.addEventListener("CoupleAvatarScene.ChangeScene", cVar2);
        }
        if (filamentNativeAppV23053 != null) {
            filamentNativeAppV23053.addEventListener("CoupleAvatarScene.ChangeDress", cVar2);
        }
        if (filamentNativeAppV23053 != null) {
            filamentNativeAppV23053.addEventListener("onTouchEvent", cVar2);
        }
        if (filamentNativeAppV23053 != null) {
            filamentNativeAppV23053.addEventListener("requestRenderObjectNodePoint", cVar2);
        }
        if (filamentNativeAppV23053 != null) {
            filamentNativeAppV23053.addEventListener("CoupleAvatarScene.PlaySingleAnimation", cVar2);
        }
        if (filamentNativeAppV23053 != null) {
            filamentNativeAppV23053.addEventListener("CoupleAvatarScene.PlayCoupleAnimation", cVar2);
        }
        if (filamentNativeAppV23053 != null) {
            filamentNativeAppV23053.addEventListener("CoupleAvatarScene.SetViewport", cVar2);
        }
        this.coroutineContext = SupervisorKt.SupervisorJob$default((Job) null, 1, (Object) null).plus(Dispatchers.getIO()).plus(new a(CoroutineExceptionHandler.INSTANCE, this));
    }

    private final JSONObject A0(com.tencent.zplan.zplantracing.c spanContext, ReloadAvatarResourceModel avatarResourceModel, JSONObject avatarCharacter) {
        JSONObject jSONObject = new JSONObject();
        JSONArray jSONArray = new JSONArray();
        jSONArray.mo162put("HandHeldSlot");
        Unit unit = Unit.INSTANCE;
        jSONObject.put("hideSlotPart", jSONArray);
        JSONObject o16 = ZPlanAvatarResourceHelper.f105660o.o(avatarResourceModel, avatarCharacter, false, false, false, spanContext);
        o16.put("avatarMask", jSONObject);
        return o16;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Job B0(com.tencent.zplan.zplantracing.c spanContext, String eventData) {
        Job launch$default;
        launch$default = BuildersKt__Builders_commonKt.launch$default(this, null, null, new CoupleAvatarScene$changeDress$1(this, eventData, spanContext, null), 3, null);
        return launch$default;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void C0(com.tencent.zplan.zplantracing.c spanContext, FilamentViewerV2305 viewer) {
        List<xk0.d> list;
        synchronized (this.sceneItemList) {
            list = CollectionsKt___CollectionsKt.toList(this.sceneItemList);
            this.sceneItemList.clear();
        }
        for (xk0.d dVar : list) {
            dVar.b(spanContext, viewer);
            viewer.deleteRenderObject(spanContext, dVar.getRenderObjectId());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void D0(BpConfig roomConfig) {
        String str;
        boolean z16;
        LensProjection lensProjection;
        FovProjection fovProjection;
        FilamentViewerV2305 viewer = getViewer();
        if (viewer != null) {
            CameraParams camera2 = roomConfig.getCamera();
            if (viewer.getViewportWidth() != 0 && viewer.getViewportHeight() != 0) {
                float viewportWidth = (viewer.getViewportWidth() * 1.0f) / viewer.getViewportHeight();
                if (camera2 != null && (fovProjection = camera2.getFovProjection()) != null) {
                    fovProjection.setAspect(viewportWidth);
                }
                if (camera2 != null && (lensProjection = camera2.getLensProjection()) != null) {
                    lensProjection.setAspect(viewportWidth);
                }
            }
            try {
                str = new Gson().toJson(camera2);
            } catch (Throwable unused) {
                FLog.INSTANCE.e("CoupleAvatarScene", "configCamera failed");
                str = "";
            }
            if (str != null && str.length() != 0) {
                z16 = false;
            } else {
                z16 = true;
            }
            if (z16) {
                return;
            }
            viewer.setCamera(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void E0(BpConfig roomConfig, String indirectLightPath) {
        LightsParams lights;
        FilamentViewerV2305 viewer = getViewer();
        if (viewer != null && (lights = roomConfig.getLights()) != null) {
            IndirectLight indirectLight = lights.getIndirectLight();
            if (indirectLight != null) {
                if (indirectLightPath == null) {
                    indirectLightPath = "";
                }
                indirectLight.setPath(indirectLightPath);
            }
            viewer.setLights(lights);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void F0(com.tencent.zplan.zplantracing.c spanContext, BootResourceModel bootResource, ReloadAvatarResourceModel leftAvatarResourceModel, JSONObject leftAvatarCharacter, ReloadAvatarResourceModel rightAvatarResourceModel, JSONObject rightAvatarCharacter, SceneConfig sceneConfig, boolean enableCrossFade) throws IllegalViewerException {
        int collectionSizeOrDefault;
        D0(sceneConfig.getRoom());
        E0(sceneConfig.getRoom(), bootResource.getIndirectLightPath());
        H0(sceneConfig.getRoom());
        FilamentViewerV2305 viewer = getViewer();
        if (viewer != null) {
            C0(spanContext, viewer);
            viewer.garbageCollect();
            List<ItemConfig> c16 = sceneConfig.getRoom().c();
            collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(c16, 10);
            ArrayList arrayList = new ArrayList(collectionSizeOrDefault);
            for (ItemConfig itemConfig : c16) {
                xk0.d dVar = new xk0.d(viewer.createGltfRenderObject(spanContext));
                dVar.e(spanContext, viewer, itemConfig);
                arrayList.add(dVar);
            }
            synchronized (this.sceneItemList) {
                this.sceneItemList.addAll(arrayList);
            }
            d h16 = sceneConfig.getRoom().h(AvatarTarget.AVATAR_TARGET_LEFT, leftAvatarResourceModel.getGender());
            this.leftTransform = h16;
            xk0.a J0 = J0(spanContext, viewer, leftAvatarCharacter, leftAvatarResourceModel, this.leftAvatar, enableCrossFade, h16);
            AvatarConfig leftAvatarConfig = sceneConfig.getLeftAvatarConfig();
            leftAvatarConfig.l(true);
            leftAvatarConfig.n(this.leftTransform);
            Unit unit = Unit.INSTANCE;
            J0.m(spanContext, viewer, leftAvatarConfig, false);
            this.leftAvatar = J0;
            d h17 = sceneConfig.getRoom().h(AvatarTarget.AVATAR_TARGET_RIGHT, rightAvatarResourceModel.getGender());
            this.rightTransform = h17;
            xk0.a J02 = J0(spanContext, viewer, rightAvatarCharacter, rightAvatarResourceModel, this.rightAvatar, enableCrossFade, h17);
            AvatarConfig rightAvatarConfig = sceneConfig.getRightAvatarConfig();
            rightAvatarConfig.l(true);
            rightAvatarConfig.n(this.rightTransform);
            J02.m(spanContext, viewer, rightAvatarConfig, false);
            this.rightAvatar = J02;
            this.sceneConfig = sceneConfig;
            this.avatarCreated.set(true);
            this.hasRecordFrame.set(false);
            return;
        }
        throw new IllegalViewerException();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void G0(final com.tencent.zplan.zplantracing.c spanContext, final BootResourceModel bootResource, final ReloadAvatarResourceModel leftAvatarResourceModel, final JSONObject leftAvatarCharacter, final ReloadAvatarResourceModel rightAvatarResourceModel, final JSONObject rightAvatarCharacter, final SceneConfig sceneConfig, final boolean enableCrossFade) throws IllegalViewerException {
        final FilamentViewerV2305 viewer = getViewer();
        if (viewer != null) {
            g1("configAndCleanItems", new Function0<Unit>() { // from class: com.tencent.filament.zplan.scene.couple.CoupleAvatarScene$configRenderObjectsSplitFunction$1
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
                    CoupleAvatarScene.this.D0(sceneConfig.getRoom());
                    CoupleAvatarScene.this.E0(sceneConfig.getRoom(), bootResource.getIndirectLightPath());
                    CoupleAvatarScene.this.H0(sceneConfig.getRoom());
                    CoupleAvatarScene.this.C0(spanContext, viewer);
                    viewer.garbageCollect();
                }
            });
            g1("createSceneItemsAndBindAnimation", new Function0<Unit>() { // from class: com.tencent.filament.zplan.scene.couple.CoupleAvatarScene$configRenderObjectsSplitFunction$2
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
                    int collectionSizeOrDefault;
                    List list;
                    List list2;
                    List<ItemConfig> c16 = sceneConfig.getRoom().c();
                    collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(c16, 10);
                    ArrayList arrayList = new ArrayList(collectionSizeOrDefault);
                    for (ItemConfig itemConfig : c16) {
                        xk0.d dVar = new xk0.d(viewer.createGltfRenderObject(spanContext));
                        dVar.e(spanContext, viewer, itemConfig);
                        arrayList.add(dVar);
                    }
                    list = CoupleAvatarScene.this.sceneItemList;
                    synchronized (list) {
                        list2 = CoupleAvatarScene.this.sceneItemList;
                        list2.addAll(arrayList);
                        Unit unit = Unit.INSTANCE;
                    }
                }
            });
            g1("createLeftAvatarRenderObjectAndBindAnimation", new Function0<Unit>() { // from class: com.tencent.filament.zplan.scene.couple.CoupleAvatarScene$configRenderObjectsSplitFunction$3
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
                    xk0.a aVar;
                    d dVar;
                    xk0.a J0;
                    d dVar2;
                    CoupleAvatarScene.this.leftTransform = sceneConfig.getRoom().h(CoupleAvatarScene.AvatarTarget.AVATAR_TARGET_LEFT, leftAvatarResourceModel.getGender());
                    CoupleAvatarScene coupleAvatarScene = CoupleAvatarScene.this;
                    c cVar = spanContext;
                    FilamentViewerV2305 filamentViewerV2305 = viewer;
                    JSONObject jSONObject = leftAvatarCharacter;
                    ReloadAvatarResourceModel reloadAvatarResourceModel = leftAvatarResourceModel;
                    aVar = coupleAvatarScene.leftAvatar;
                    boolean z16 = enableCrossFade;
                    dVar = CoupleAvatarScene.this.leftTransform;
                    J0 = coupleAvatarScene.J0(cVar, filamentViewerV2305, jSONObject, reloadAvatarResourceModel, aVar, z16, dVar);
                    c cVar2 = spanContext;
                    FilamentViewerV2305 filamentViewerV23052 = viewer;
                    AvatarConfig leftAvatarConfig = sceneConfig.getLeftAvatarConfig();
                    leftAvatarConfig.l(true);
                    dVar2 = CoupleAvatarScene.this.leftTransform;
                    leftAvatarConfig.n(dVar2);
                    Unit unit = Unit.INSTANCE;
                    J0.m(cVar2, filamentViewerV23052, leftAvatarConfig, false);
                    coupleAvatarScene.leftAvatar = J0;
                }
            });
            g1("createRightAvatarRenderObjectAndBindAnimation", new Function0<Unit>() { // from class: com.tencent.filament.zplan.scene.couple.CoupleAvatarScene$configRenderObjectsSplitFunction$4
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
                    xk0.a aVar;
                    d dVar;
                    xk0.a J0;
                    d dVar2;
                    AtomicBoolean atomicBoolean;
                    AtomicBoolean atomicBoolean2;
                    CoupleAvatarScene.this.rightTransform = sceneConfig.getRoom().h(CoupleAvatarScene.AvatarTarget.AVATAR_TARGET_RIGHT, rightAvatarResourceModel.getGender());
                    CoupleAvatarScene coupleAvatarScene = CoupleAvatarScene.this;
                    c cVar = spanContext;
                    FilamentViewerV2305 filamentViewerV2305 = viewer;
                    JSONObject jSONObject = rightAvatarCharacter;
                    ReloadAvatarResourceModel reloadAvatarResourceModel = rightAvatarResourceModel;
                    aVar = coupleAvatarScene.rightAvatar;
                    boolean z16 = enableCrossFade;
                    dVar = CoupleAvatarScene.this.rightTransform;
                    J0 = coupleAvatarScene.J0(cVar, filamentViewerV2305, jSONObject, reloadAvatarResourceModel, aVar, z16, dVar);
                    c cVar2 = spanContext;
                    FilamentViewerV2305 filamentViewerV23052 = viewer;
                    AvatarConfig rightAvatarConfig = sceneConfig.getRightAvatarConfig();
                    rightAvatarConfig.l(true);
                    dVar2 = CoupleAvatarScene.this.rightTransform;
                    rightAvatarConfig.n(dVar2);
                    Unit unit = Unit.INSTANCE;
                    J0.m(cVar2, filamentViewerV23052, rightAvatarConfig, false);
                    coupleAvatarScene.rightAvatar = J0;
                    CoupleAvatarScene.this.sceneConfig = sceneConfig;
                    atomicBoolean = CoupleAvatarScene.this.avatarCreated;
                    atomicBoolean.set(true);
                    atomicBoolean2 = CoupleAvatarScene.this.hasRecordFrame;
                    atomicBoolean2.set(false);
                }
            });
            return;
        }
        throw new IllegalViewerException();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void H0(BpConfig roomConfig) {
        FilamentViewerV2305 viewer;
        JSONObject shadow = roomConfig.getShadow();
        if (shadow != null && (viewer = getViewer()) != null) {
            String jSONObject = shadow.toString();
            Intrinsics.checkNotNullExpressionValue(jSONObject, "shadow.toString()");
            viewer.setGlobalMaterialParams(jSONObject);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Point I0(FilamentViewerV2305 viewer, PointF touchPoint) {
        return new Point((int) touchPoint.x, viewer.getViewportHeight() - ((int) touchPoint.y));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final xk0.a J0(com.tencent.zplan.zplantracing.c spanContext, FilamentViewerV2305 viewer, JSONObject avatarCharacter, ReloadAvatarResourceModel avatarResourceModel, xk0.a oldAvatarAsset, boolean enableCrossFade, d transform) {
        if (oldAvatarAsset != null) {
            viewer.updateRenderObjectAvatar(spanContext, oldAvatarAsset.getRenderObjectId(), A0(spanContext, avatarResourceModel, avatarCharacter));
        } else {
            long createAvatarRenderObject = viewer.createAvatarRenderObject(spanContext);
            if (enableCrossFade) {
                oldAvatarAsset = new xk0.b(createAvatarRenderObject, avatarCharacter);
            } else {
                oldAvatarAsset = new xk0.a(createAvatarRenderObject, avatarCharacter);
            }
            viewer.updateRenderObjectAvatar(spanContext, createAvatarRenderObject, A0(spanContext, avatarResourceModel, avatarCharacter));
        }
        if (transform != null) {
            viewer.setRenderObjectTransform(oldAvatarAsset.getRenderObjectId(), transform.toString());
        }
        viewer.setRenderObjectHittable(oldAvatarAsset.getRenderObjectId(), true);
        return oldAvatarAsset;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ xk0.a K0(CoupleAvatarScene coupleAvatarScene, com.tencent.zplan.zplantracing.c cVar, FilamentViewerV2305 filamentViewerV2305, JSONObject jSONObject, ReloadAvatarResourceModel reloadAvatarResourceModel, xk0.a aVar, boolean z16, d dVar, int i3, Object obj) {
        xk0.a aVar2;
        boolean z17;
        d dVar2;
        if ((i3 & 16) != 0) {
            aVar2 = null;
        } else {
            aVar2 = aVar;
        }
        if ((i3 & 32) != 0) {
            z17 = false;
        } else {
            z17 = z16;
        }
        if ((i3 & 64) != 0) {
            dVar2 = null;
        } else {
            dVar2 = dVar;
        }
        return coupleAvatarScene.J0(cVar, filamentViewerV2305, jSONObject, reloadAvatarResourceModel, aVar2, z17, dVar2);
    }

    private final void L0(com.tencent.zplan.zplantracing.c spanContext, String eventType, JSONObject data, Boolean isSuccess, String errorMsg) {
        if (data == null) {
            data = new JSONObject();
        }
        FilamentNativeAppV2305 filamentNativeAppV2305 = j().get();
        if (filamentNativeAppV2305 != null) {
            data.put("isSuccess", isSuccess);
            filamentNativeAppV2305.dispatchEvent(spanContext, eventType, data.put("errMsg", errorMsg).toString());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void M0(CoupleAvatarScene coupleAvatarScene, com.tencent.zplan.zplantracing.c cVar, String str, JSONObject jSONObject, Boolean bool, String str2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            cVar = null;
        }
        com.tencent.zplan.zplantracing.c cVar2 = cVar;
        if ((i3 & 8) != 0) {
            bool = Boolean.TRUE;
        }
        Boolean bool2 = bool;
        if ((i3 & 16) != 0) {
            str2 = "";
        }
        coupleAvatarScene.L0(cVar2, str, jSONObject, bool2, str2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final synchronized void N0(com.tencent.zplan.zplantracing.b bootSpan, BootResourceModel bootResource, String bodyTypeName) {
        boolean z16;
        if (this.booted.get()) {
            return;
        }
        FilamentViewerV2305 viewer = getViewer();
        if (viewer != null) {
            boolean z17 = !Intrinsics.areEqual(bodyTypeName, "BodyType40");
            FilamentFeatureUtil filamentFeatureUtil = FilamentFeatureUtil.f106409g;
            z16 = viewer.boot(bootResource, "", false, false, z17, filamentFeatureUtil.K(), filamentFeatureUtil.j());
        } else {
            z16 = false;
        }
        if (!z16) {
            if (bootSpan != null) {
                bootSpan.a("boot fail");
            }
            o(201024, "boot fail");
        } else {
            if (bootSpan != null) {
                bootSpan.b();
            }
            this.booted.set(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Deferred<BootResourceModel> P0(com.tencent.zplan.zplantracing.c spanContext, String bodyTypeName) {
        Deferred<BootResourceModel> async$default;
        async$default = BuildersKt__Builders_commonKt.async$default(this, null, null, new CoupleAvatarScene$fetchBootResourceAndBootAsync$1(this, spanContext, bodyTypeName, null), 3, null);
        return async$default;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Deferred<Pair<AvatarConfig, AvatarConfig>> Q0(com.tencent.zplan.zplantracing.c spanContext, int coupleAnimationId, JSONObject leftAvatarCharacter, JSONObject rightAvatarCharacter) {
        Deferred<Pair<AvatarConfig, AvatarConfig>> async$default;
        async$default = BuildersKt__Builders_commonKt.async$default(this, null, null, new CoupleAvatarScene$fetchCoupleAnimResourceAsync$1(this, coupleAnimationId, leftAvatarCharacter, spanContext, rightAvatarCharacter, null), 3, null);
        return async$default;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Deferred<ReloadAvatarResourceModel> R0(com.tencent.zplan.zplantracing.c spanContext, JSONObject avatarInfo) {
        Deferred<ReloadAvatarResourceModel> async$default;
        async$default = BuildersKt__Builders_commonKt.async$default(this, null, null, new CoupleAvatarScene$fetchReloadAvatarResourceAsync$1(this, spanContext, avatarInfo, null), 3, null);
        return async$default;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Deferred<SceneConfig> T0(com.tencent.zplan.zplantracing.c spanContext, int sceneId, AppTheme theme, JSONObject leftAvatarCharacter, JSONObject rightAvatarCharacter) {
        Deferred<SceneConfig> async$default;
        async$default = BuildersKt__Builders_commonKt.async$default(this, null, null, new CoupleAvatarScene$fetchSceneResourceAsync$1(this, sceneId, theme, spanContext, leftAvatarCharacter, rightAvatarCharacter, null), 3, null);
        return async$default;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Deferred<AvatarConfig> V0(com.tencent.zplan.zplantracing.c spanContext, int singleAnimId, JSONObject avatarCharacter) {
        Deferred<AvatarConfig> async$default;
        async$default = BuildersKt__Builders_commonKt.async$default(this, null, null, new CoupleAvatarScene$fetchSingleAnimResourceAsync$1(this, avatarCharacter, singleAnimId, spanContext, null), 3, null);
        return async$default;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void W0(final String data) {
        final String str;
        final String str2;
        boolean z16;
        FLog.INSTANCE.i("CoupleAvatarScene", "eventData: " + data);
        final JSONObject b16 = h.f385294a.b(data);
        if (b16 != null) {
            str = b16.optString("renderObjectType", "");
        } else {
            str = null;
        }
        if (b16 != null) {
            str2 = b16.optString("renderObjectNodeName", "");
        } else {
            str2 = null;
        }
        boolean z17 = false;
        if (str != null && str.length() != 0) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (!z16) {
            if (str2 == null || str2.length() == 0) {
                z17 = true;
            }
            if (!z17) {
                k().d("getRenderObjectNodePoint", new Function0<Unit>() { // from class: com.tencent.filament.zplan.scene.couple.CoupleAvatarScene$getRenderObjectNodePoint$1
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
                        FilamentViewerV2305 viewer;
                        Long l3;
                        xk0.a aVar;
                        xk0.a aVar2;
                        viewer = CoupleAvatarScene.this.getViewer();
                        if (viewer != null) {
                            String str3 = str;
                            JSONObject jSONObject = null;
                            if (str3 != null) {
                                int hashCode = str3.hashCode();
                                if (hashCode != 545145493) {
                                    if (hashCode == 604954336 && str3.equals("renderObjectRightAvatar")) {
                                        aVar2 = CoupleAvatarScene.this.rightAvatar;
                                        if (aVar2 != null) {
                                            l3 = Long.valueOf(aVar2.getRenderObjectId());
                                        }
                                        l3 = null;
                                    }
                                } else if (str3.equals("renderObjectLeftAvatar")) {
                                    aVar = CoupleAvatarScene.this.leftAvatar;
                                    if (aVar != null) {
                                        l3 = Long.valueOf(aVar.getRenderObjectId());
                                    }
                                    l3 = null;
                                }
                                if (l3 == null && l3.longValue() != 0) {
                                    Point nodeCoordinateForRenderObject = viewer.getNodeCoordinateForRenderObject(l3.longValue(), str2);
                                    if (nodeCoordinateForRenderObject == null) {
                                        FLog.INSTANCE.e("CoupleAvatarScene", "doOnFirstRenderEnd, getNodeCoordinateForRenderObject failed, point null.");
                                        CoupleAvatarScene.M0(CoupleAvatarScene.this, null, "onGetNodePoint", b16, Boolean.FALSE, "renderObject head point invalid", 1, null);
                                        return;
                                    }
                                    CoupleAvatarScene coupleAvatarScene = CoupleAvatarScene.this;
                                    JSONObject b17 = h.f385294a.b(data);
                                    if (b17 != null) {
                                        b17.put("headPointX", nodeCoordinateForRenderObject.x);
                                        jSONObject = b17.put("headPointY", nodeCoordinateForRenderObject.y);
                                    }
                                    CoupleAvatarScene.M0(coupleAvatarScene, null, "onGetNodePoint", jSONObject, Boolean.TRUE, null, 17, null);
                                    return;
                                }
                                CoupleAvatarScene.M0(CoupleAvatarScene.this, null, "onGetNodePoint", b16, Boolean.FALSE, "renderObject point request object id invalid", 1, null);
                            }
                            l3 = 0L;
                            if (l3 == null) {
                            }
                            CoupleAvatarScene.M0(CoupleAvatarScene.this, null, "onGetNodePoint", b16, Boolean.FALSE, "renderObject point request object id invalid", 1, null);
                        }
                    }
                });
                return;
            }
        }
        M0(this, null, "onGetNodePoint", b16, Boolean.FALSE, "renderObject point request info invalid", 1, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void X0(com.tencent.zplan.zplantracing.c spanContext, TouchEventType touchEventType, long tapedRenderObjectId) {
        AvatarTarget avatarTarget;
        FilamentNativeAppV2305 filamentNativeAppV2305 = j().get();
        if (filamentNativeAppV2305 != null) {
            Intrinsics.checkNotNullExpressionValue(filamentNativeAppV2305, "app.get() ?: return");
            xk0.a aVar = this.leftAvatar;
            if (aVar != null && aVar.getRenderObjectId() == tapedRenderObjectId) {
                avatarTarget = AvatarTarget.AVATAR_TARGET_LEFT;
            } else {
                xk0.a aVar2 = this.rightAvatar;
                if (aVar2 != null && aVar2.getRenderObjectId() == tapedRenderObjectId) {
                    avatarTarget = AvatarTarget.AVATAR_TARGET_RIGHT;
                } else {
                    avatarTarget = AvatarTarget.AVATAR_TARGET_UNKNOWN;
                }
            }
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("touchEventType", touchEventType);
            jSONObject.put("touchEventTarget", avatarTarget);
            Unit unit = Unit.INSTANCE;
            filamentNativeAppV2305.dispatchEvent(spanContext, "CoupleAvatarScene.Touch", jSONObject.toString());
        }
    }

    private final void Y0(final com.tencent.zplan.zplantracing.c spanContext, final TouchEvent touchEvent) {
        k().d("handleDoubleTapEvent", new Function0<Unit>() { // from class: com.tencent.filament.zplan.scene.couple.CoupleAvatarScene$handleDoubleTapEvent$1
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
                FilamentViewerV2305 viewer;
                Point I0;
                viewer = CoupleAvatarScene.this.getViewer();
                if (viewer != null) {
                    I0 = CoupleAvatarScene.this.I0(viewer, touchEvent.getLocation());
                    long hitRenderObjectIDAt = viewer.getHitRenderObjectIDAt(I0);
                    FLog.INSTANCE.i("CoupleAvatarScene", "handleDoubleTapEvent, point:" + I0 + ", tapedRenderObjectId:" + hitRenderObjectIDAt);
                    CoupleAvatarScene.this.X0(spanContext, touchEvent.getType(), hitRenderObjectIDAt);
                }
            }
        });
    }

    private final void Z0(final com.tencent.zplan.zplantracing.c spanContext, final TouchEvent touchEvent) {
        k().d("handleLongPressEvent", new Function0<Unit>() { // from class: com.tencent.filament.zplan.scene.couple.CoupleAvatarScene$handleLongPressEvent$1
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
                FilamentViewerV2305 viewer;
                Point I0;
                viewer = CoupleAvatarScene.this.getViewer();
                if (viewer != null) {
                    I0 = CoupleAvatarScene.this.I0(viewer, touchEvent.getLocation());
                    long hitRenderObjectIDAt = viewer.getHitRenderObjectIDAt(I0);
                    FLog.INSTANCE.i("CoupleAvatarScene", "handleLongPressEvent, point:" + I0 + ", tapedRenderObjectId:" + hitRenderObjectIDAt);
                    CoupleAvatarScene.this.X0(spanContext, touchEvent.getType(), hitRenderObjectIDAt);
                }
            }
        });
    }

    private final void a1(final com.tencent.zplan.zplantracing.c spanContext, final TouchEvent touchEvent) {
        k().d("handleTapUpEvent", new Function0<Unit>() { // from class: com.tencent.filament.zplan.scene.couple.CoupleAvatarScene$handleTapUpEvent$1
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
                FilamentViewerV2305 viewer;
                Point I0;
                viewer = CoupleAvatarScene.this.getViewer();
                if (viewer != null) {
                    I0 = CoupleAvatarScene.this.I0(viewer, touchEvent.getLocation());
                    long hitRenderObjectIDAt = viewer.getHitRenderObjectIDAt(I0);
                    FLog.INSTANCE.i("CoupleAvatarScene", "handleTapUpEvent, point:" + I0 + ", tapedRenderObjectId:" + hitRenderObjectIDAt);
                    CoupleAvatarScene.this.X0(spanContext, touchEvent.getType(), hitRenderObjectIDAt);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void b1(Throwable throwable) {
        String str = "";
        if (throwable instanceof FetchFileException) {
            FetchFileException fetchFileException = (FetchFileException) throwable;
            int errorCode = fetchFileException.getErrorCode();
            String errorMessage = fetchFileException.getErrorMessage();
            if (errorMessage != null) {
                str = errorMessage;
            }
            o(errorCode, str);
            return;
        }
        if (throwable instanceof BlackListResourceException) {
            String message = throwable.getMessage();
            if (message != null) {
                str = message;
            }
            o(201005, str);
            return;
        }
        if (throwable instanceof IllegalViewerException) {
            String message2 = throwable.getMessage();
            if (message2 != null) {
                str = message2;
            }
            o(201025, str);
            return;
        }
        String message3 = throwable.getMessage();
        if (message3 != null) {
            str = message3;
        }
        o(201000, str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Job c1(com.tencent.zplan.zplantracing.c spanContext, String eventData) {
        Job launch$default;
        launch$default = BuildersKt__Builders_commonKt.launch$default(this, null, null, new CoupleAvatarScene$loadScene$1(this, eventData, spanContext, null), 3, null);
        return launch$default;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void d1(com.tencent.zplan.zplantracing.c spanContext, String eventData) {
        if (eventData != null) {
            TouchEvent touchEvent = (TouchEvent) new Gson().fromJson(eventData, TouchEvent.class);
            int i3 = com.tencent.filament.zplan.scene.couple.a.f105920a[touchEvent.getType().ordinal()];
            if (i3 != 1) {
                if (i3 != 2) {
                    if (i3 == 3) {
                        Intrinsics.checkNotNullExpressionValue(touchEvent, "touchEvent");
                        Z0(spanContext, touchEvent);
                        return;
                    }
                    return;
                }
                Intrinsics.checkNotNullExpressionValue(touchEvent, "touchEvent");
                Y0(spanContext, touchEvent);
                return;
            }
            Intrinsics.checkNotNullExpressionValue(touchEvent, "touchEvent");
            a1(spanContext, touchEvent);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Job e1(com.tencent.zplan.zplantracing.c spanContext, String eventData) {
        Job launch$default;
        launch$default = BuildersKt__Builders_commonKt.launch$default(this, null, null, new CoupleAvatarScene$playCoupleAnimation$1(this, eventData, spanContext, null), 3, null);
        return launch$default;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Job f1(com.tencent.zplan.zplantracing.c spanContext, String eventData) {
        Job launch$default;
        launch$default = BuildersKt__Builders_commonKt.launch$default(this, null, null, new CoupleAvatarScene$playSingleAnimation$1(this, eventData, spanContext, null), 3, null);
        return launch$default;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void g1(final String taskName, final Function0<Unit> task) {
        k().d(taskName + "_CoupleAvatarScene", new Function0<Unit>() { // from class: com.tencent.filament.zplan.scene.couple.CoupleAvatarScene$postToFilamentThread$1
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
                try {
                    task.invoke();
                } catch (Throwable th5) {
                    FLog.INSTANCE.e("CoupleAvatarScene", taskName + " failed, t:" + th5);
                    CoupleAvatarScene.this.b1(th5);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void h1(com.tencent.zplan.zplantracing.c spanContext, String eventData) {
        JSONObject b16 = h.f385294a.b(eventData);
        if (b16 != null) {
            final int optInt = b16.optInt("width", 0);
            final int optInt2 = b16.optInt("height", 0);
            if (optInt > 0 && optInt2 > 0) {
                k().d("CoupleAvatarScene.setViewport", new Function0<Unit>() { // from class: com.tencent.filament.zplan.scene.couple.CoupleAvatarScene$setViewport$1
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
                        FilamentViewerV2305 viewer;
                        SceneConfig sceneConfig;
                        viewer = CoupleAvatarScene.this.getViewer();
                        if (viewer != null) {
                            viewer.setViewPort(optInt, optInt2);
                        }
                        sceneConfig = CoupleAvatarScene.this.sceneConfig;
                        BpConfig room = sceneConfig != null ? sceneConfig.getRoom() : null;
                        if (room != null) {
                            CoupleAvatarScene.this.D0(room);
                        }
                    }
                });
            }
        }
    }

    private final com.tencent.filament.zplan.business.api.a y0(double now, com.tencent.zplan.zplantracing.c spanContext) {
        double d16 = this.animationBeginTime;
        double d17 = 0.0d;
        if (d16 == 0.0d) {
            this.animationBeginTime = now;
        } else {
            d17 = now - d16;
        }
        FilamentViewerV2305 viewer = getViewer();
        if (viewer != null) {
            for (xk0.d dVar : this.sceneItemList) {
                if (dVar.getCurrentItemTrack() != null) {
                    viewer.applyAnimation(dVar.getRenderObjectId(), d17);
                }
            }
            xk0.a aVar = this.leftAvatar;
            if (aVar != null) {
                aVar.a(viewer, d17);
            }
            xk0.a aVar2 = this.rightAvatar;
            if (aVar2 != null) {
                aVar2.a(viewer, d17);
            }
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void z0(com.tencent.zplan.zplantracing.c spanContext, final BootResourceModel bootResource, final String bodyTypeName) {
        if (this.booted.get()) {
            return;
        }
        final com.tencent.zplan.zplantracing.b startSpan = ZPlanSpanFactory.INSTANCE.startSpan("boot", spanContext);
        k().d("boot", new Function0<Unit>() { // from class: com.tencent.filament.zplan.scene.couple.CoupleAvatarScene$bootAsync$1
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
                CoupleAvatarScene.this.N0(startSpan, bootResource, bodyTypeName);
            }
        });
    }

    @Override // com.tencent.filament.zplan.app.scene.BaseSceneV2305
    public long B() {
        return FilamentFeatureUtil.f106409g.r().getSurfaceDestroyTimeout();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0062  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x003e  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0023  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final /* synthetic */ Object O0(com.tencent.zplan.zplantracing.c cVar, BpConfig bpConfig, Continuation<? super Unit> continuation) {
        CoupleAvatarScene$doFetchSplitShaderWithGltf$1 coupleAvatarScene$doFetchSplitShaderWithGltf$1;
        Object coroutine_suspended;
        int i3;
        CoupleAvatarScene coupleAvatarScene;
        com.tencent.zplan.zplantracing.c cVar2;
        Iterator it;
        if (continuation instanceof CoupleAvatarScene$doFetchSplitShaderWithGltf$1) {
            coupleAvatarScene$doFetchSplitShaderWithGltf$1 = (CoupleAvatarScene$doFetchSplitShaderWithGltf$1) continuation;
            int i16 = coupleAvatarScene$doFetchSplitShaderWithGltf$1.label;
            if ((i16 & Integer.MIN_VALUE) != 0) {
                coupleAvatarScene$doFetchSplitShaderWithGltf$1.label = i16 - Integer.MIN_VALUE;
                Object obj = coupleAvatarScene$doFetchSplitShaderWithGltf$1.result;
                coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i3 = coupleAvatarScene$doFetchSplitShaderWithGltf$1.label;
                if (i3 == 0) {
                    if (i3 == 1) {
                        it = (Iterator) coupleAvatarScene$doFetchSplitShaderWithGltf$1.L$2;
                        cVar2 = (com.tencent.zplan.zplantracing.c) coupleAvatarScene$doFetchSplitShaderWithGltf$1.L$1;
                        coupleAvatarScene = (CoupleAvatarScene) coupleAvatarScene$doFetchSplitShaderWithGltf$1.L$0;
                        ResultKt.throwOnFailure(obj);
                    } else {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                } else {
                    ResultKt.throwOnFailure(obj);
                    if (bpConfig.c().isEmpty()) {
                        return Unit.INSTANCE;
                    }
                    Iterator it5 = bpConfig.c().iterator();
                    coupleAvatarScene = this;
                    cVar2 = cVar;
                    it = it5;
                }
                while (it.hasNext()) {
                    String mesh = ((ItemConfig) it.next()).getMesh();
                    if (mesh != null) {
                        FLog.INSTANCE.i("CoupleAvatarScene", "doFetchSplitShaderWithGltf, path:" + mesh);
                        ZPlanAvatarResourceHelper zPlanAvatarResourceHelper = ZPlanAvatarResourceHelper.f105660o;
                        FilamentUrlTemplate filamentUrlTemplate = coupleAvatarScene.urlTemplate;
                        coupleAvatarScene$doFetchSplitShaderWithGltf$1.L$0 = coupleAvatarScene;
                        coupleAvatarScene$doFetchSplitShaderWithGltf$1.L$1 = cVar2;
                        coupleAvatarScene$doFetchSplitShaderWithGltf$1.L$2 = it;
                        coupleAvatarScene$doFetchSplitShaderWithGltf$1.label = 1;
                        if (zPlanAvatarResourceHelper.c0(cVar2, mesh, filamentUrlTemplate, coupleAvatarScene$doFetchSplitShaderWithGltf$1) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                    }
                }
                return Unit.INSTANCE;
            }
        }
        coupleAvatarScene$doFetchSplitShaderWithGltf$1 = new CoupleAvatarScene$doFetchSplitShaderWithGltf$1(this, continuation);
        Object obj2 = coupleAvatarScene$doFetchSplitShaderWithGltf$1.result;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i3 = coupleAvatarScene$doFetchSplitShaderWithGltf$1.label;
        if (i3 == 0) {
        }
        while (it.hasNext()) {
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Failed to find 'out' block for switch in B:7:0x002b. Please report as an issue. */
    /* JADX WARN: Removed duplicated region for block: B:11:0x0037  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x004f  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0224 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0225  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x006e  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x01f9 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:31:0x01fa  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x008f  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x01ce A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:36:0x00ac  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x01b0 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:41:0x01b1  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x00c5  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x0147  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x0153  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x0177  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x00e7  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x002e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final /* synthetic */ Object S0(com.tencent.zplan.zplantracing.c cVar, String str, String str2, String str3, String str4, Continuation<? super AvatarConfig> continuation) {
        CoupleAvatarScene$fetchSceneAvatarConfig$1 coupleAvatarScene$fetchSceneAvatarConfig$1;
        Object coroutine_suspended;
        boolean z16;
        String str5;
        String str6;
        CoupleAvatarScene coupleAvatarScene;
        BpConfig bpConfig;
        String str7;
        Object obj;
        boolean z17;
        BpConfig bpConfig2;
        String str8;
        String str9;
        com.tencent.zplan.zplantracing.c cVar2;
        BpConfig bpConfig3;
        String str10;
        CoupleAvatarScene coupleAvatarScene2;
        com.tencent.zplan.zplantracing.c cVar3;
        BpConfig bpConfig4;
        String str11;
        BpConfig bpConfig5;
        boolean z18;
        Object h06;
        BpConfig bpConfig6;
        String str12;
        com.tencent.zplan.zplantracing.c cVar4;
        BpConfig bpConfig7;
        CoupleAvatarScene coupleAvatarScene3;
        Object h07;
        BpConfig bpConfig8;
        CoupleAvatarScene coupleAvatarScene4;
        Resource resource;
        BpConfig bpConfig9;
        com.tencent.zplan.zplantracing.c cVar5 = cVar;
        if (continuation instanceof CoupleAvatarScene$fetchSceneAvatarConfig$1) {
            coupleAvatarScene$fetchSceneAvatarConfig$1 = (CoupleAvatarScene$fetchSceneAvatarConfig$1) continuation;
            int i3 = coupleAvatarScene$fetchSceneAvatarConfig$1.label;
            if ((i3 & Integer.MIN_VALUE) != 0) {
                coupleAvatarScene$fetchSceneAvatarConfig$1.label = i3 - Integer.MIN_VALUE;
                Object obj2 = coupleAvatarScene$fetchSceneAvatarConfig$1.result;
                coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                boolean z19 = false;
                switch (coupleAvatarScene$fetchSceneAvatarConfig$1.label) {
                    case 0:
                        ResultKt.throwOnFailure(obj2);
                        if (str != null && str.length() != 0) {
                            z16 = false;
                        } else {
                            z16 = true;
                        }
                        if (!z16) {
                            coupleAvatarScene$fetchSceneAvatarConfig$1.L$0 = this;
                            coupleAvatarScene$fetchSceneAvatarConfig$1.L$1 = cVar5;
                            str5 = str2;
                            coupleAvatarScene$fetchSceneAvatarConfig$1.L$2 = str5;
                            coupleAvatarScene$fetchSceneAvatarConfig$1.L$3 = str3;
                            str6 = str4;
                            coupleAvatarScene$fetchSceneAvatarConfig$1.L$4 = str6;
                            coupleAvatarScene$fetchSceneAvatarConfig$1.label = 1;
                            Object U0 = U0(cVar5, str, coupleAvatarScene$fetchSceneAvatarConfig$1);
                            if (U0 == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                            coupleAvatarScene = this;
                            obj = U0;
                            str7 = str3;
                            bpConfig = (BpConfig) obj;
                            if (str5 == null && str5.length() != 0) {
                                z17 = false;
                            } else {
                                z17 = true;
                            }
                            if (!z17) {
                                coupleAvatarScene$fetchSceneAvatarConfig$1.L$0 = coupleAvatarScene;
                                coupleAvatarScene$fetchSceneAvatarConfig$1.L$1 = cVar5;
                                coupleAvatarScene$fetchSceneAvatarConfig$1.L$2 = str7;
                                coupleAvatarScene$fetchSceneAvatarConfig$1.L$3 = str6;
                                coupleAvatarScene$fetchSceneAvatarConfig$1.L$4 = bpConfig;
                                coupleAvatarScene$fetchSceneAvatarConfig$1.label = 2;
                                obj2 = coupleAvatarScene.U0(cVar5, str5, coupleAvatarScene$fetchSceneAvatarConfig$1);
                                if (obj2 == coroutine_suspended) {
                                    return coroutine_suspended;
                                }
                                String str13 = str6;
                                cVar2 = cVar5;
                                bpConfig3 = bpConfig;
                                str10 = str7;
                                str9 = str13;
                                bpConfig2 = (BpConfig) obj2;
                                String str14 = str10;
                                bpConfig = bpConfig3;
                                cVar5 = cVar2;
                                str8 = str14;
                                coupleAvatarScene$fetchSceneAvatarConfig$1.L$0 = coupleAvatarScene;
                                coupleAvatarScene$fetchSceneAvatarConfig$1.L$1 = cVar5;
                                coupleAvatarScene$fetchSceneAvatarConfig$1.L$2 = str8;
                                coupleAvatarScene$fetchSceneAvatarConfig$1.L$3 = str9;
                                coupleAvatarScene$fetchSceneAvatarConfig$1.L$4 = bpConfig;
                                coupleAvatarScene$fetchSceneAvatarConfig$1.L$5 = bpConfig2;
                                coupleAvatarScene$fetchSceneAvatarConfig$1.label = 3;
                                if (coupleAvatarScene.O0(cVar5, bpConfig, coupleAvatarScene$fetchSceneAvatarConfig$1) == coroutine_suspended) {
                                    return coroutine_suspended;
                                }
                                coupleAvatarScene2 = coupleAvatarScene;
                                cVar3 = cVar5;
                                bpConfig4 = bpConfig2;
                                BpConfig bpConfig10 = bpConfig;
                                str11 = str9;
                                bpConfig5 = bpConfig10;
                                coupleAvatarScene$fetchSceneAvatarConfig$1.L$0 = coupleAvatarScene2;
                                coupleAvatarScene$fetchSceneAvatarConfig$1.L$1 = cVar3;
                                coupleAvatarScene$fetchSceneAvatarConfig$1.L$2 = str8;
                                coupleAvatarScene$fetchSceneAvatarConfig$1.L$3 = str11;
                                coupleAvatarScene$fetchSceneAvatarConfig$1.L$4 = bpConfig5;
                                coupleAvatarScene$fetchSceneAvatarConfig$1.L$5 = bpConfig4;
                                coupleAvatarScene$fetchSceneAvatarConfig$1.label = 4;
                                if (coupleAvatarScene2.O0(cVar3, bpConfig4, coupleAvatarScene$fetchSceneAvatarConfig$1) == coroutine_suspended) {
                                    return coroutine_suspended;
                                }
                                String str15 = str11;
                                com.tencent.zplan.zplantracing.c cVar6 = cVar3;
                                CoupleAvatarScene coupleAvatarScene5 = coupleAvatarScene2;
                                String str16 = str8;
                                ZPlanAvatarResourceHelper zPlanAvatarResourceHelper = ZPlanAvatarResourceHelper.f105660o;
                                FilamentUrlTemplate filamentUrlTemplate = coupleAvatarScene5.urlTemplate;
                                coupleAvatarScene$fetchSceneAvatarConfig$1.L$0 = coupleAvatarScene5;
                                coupleAvatarScene$fetchSceneAvatarConfig$1.L$1 = cVar6;
                                coupleAvatarScene$fetchSceneAvatarConfig$1.L$2 = str15;
                                coupleAvatarScene$fetchSceneAvatarConfig$1.L$3 = bpConfig5;
                                coupleAvatarScene$fetchSceneAvatarConfig$1.L$4 = bpConfig4;
                                coupleAvatarScene$fetchSceneAvatarConfig$1.L$5 = null;
                                coupleAvatarScene$fetchSceneAvatarConfig$1.label = 5;
                                z18 = true;
                                h06 = ZPlanAvatarResourceHelper.h0(zPlanAvatarResourceHelper, cVar6, str16, filamentUrlTemplate, false, coupleAvatarScene$fetchSceneAvatarConfig$1, 8, null);
                                if (h06 == coroutine_suspended) {
                                    return coroutine_suspended;
                                }
                                bpConfig6 = bpConfig5;
                                str12 = str15;
                                obj2 = h06;
                                cVar4 = cVar6;
                                bpConfig7 = bpConfig4;
                                coupleAvatarScene3 = coupleAvatarScene5;
                                Resource resource2 = (Resource) obj2;
                                ZPlanAvatarResourceHelper zPlanAvatarResourceHelper2 = ZPlanAvatarResourceHelper.f105660o;
                                FilamentUrlTemplate filamentUrlTemplate2 = coupleAvatarScene3.urlTemplate;
                                coupleAvatarScene$fetchSceneAvatarConfig$1.L$0 = coupleAvatarScene3;
                                coupleAvatarScene$fetchSceneAvatarConfig$1.L$1 = bpConfig6;
                                coupleAvatarScene$fetchSceneAvatarConfig$1.L$2 = bpConfig7;
                                coupleAvatarScene$fetchSceneAvatarConfig$1.L$3 = resource2;
                                coupleAvatarScene$fetchSceneAvatarConfig$1.L$4 = null;
                                coupleAvatarScene$fetchSceneAvatarConfig$1.label = 6;
                                CoupleAvatarScene$fetchSceneAvatarConfig$1 coupleAvatarScene$fetchSceneAvatarConfig$12 = coupleAvatarScene$fetchSceneAvatarConfig$1;
                                BpConfig bpConfig11 = bpConfig6;
                                h07 = ZPlanAvatarResourceHelper.h0(zPlanAvatarResourceHelper2, cVar4, str12, filamentUrlTemplate2, false, coupleAvatarScene$fetchSceneAvatarConfig$12, 8, null);
                                if (h07 != coroutine_suspended) {
                                    return coroutine_suspended;
                                }
                                bpConfig8 = bpConfig7;
                                coupleAvatarScene4 = coupleAvatarScene3;
                                resource = resource2;
                                obj2 = h07;
                                bpConfig9 = bpConfig11;
                                Resource resource3 = (Resource) obj2;
                                if (!coupleAvatarScene4.hasDownloadFromNet || resource.d() || resource3.d()) {
                                    z19 = z18;
                                }
                                coupleAvatarScene4.hasDownloadFromNet = z19;
                                FilamentFileUtil filamentFileUtil = FilamentFileUtil.INSTANCE;
                                return new AvatarConfig(FilamentFileUtil.filePathInDir$default(filamentFileUtil, resource.e(), null, "gltf", 2, null), FilamentFileUtil.filePathInDir$default(filamentFileUtil, resource3.e(), null, "gltf", 2, null), bpConfig9, bpConfig8, false, false, 48, null);
                            }
                            bpConfig2 = new BpConfig(null, null, null, null, null, null, null, null, null, null, 1023, null);
                            String str17 = str6;
                            str8 = str7;
                            str9 = str17;
                            coupleAvatarScene$fetchSceneAvatarConfig$1.L$0 = coupleAvatarScene;
                            coupleAvatarScene$fetchSceneAvatarConfig$1.L$1 = cVar5;
                            coupleAvatarScene$fetchSceneAvatarConfig$1.L$2 = str8;
                            coupleAvatarScene$fetchSceneAvatarConfig$1.L$3 = str9;
                            coupleAvatarScene$fetchSceneAvatarConfig$1.L$4 = bpConfig;
                            coupleAvatarScene$fetchSceneAvatarConfig$1.L$5 = bpConfig2;
                            coupleAvatarScene$fetchSceneAvatarConfig$1.label = 3;
                            if (coupleAvatarScene.O0(cVar5, bpConfig, coupleAvatarScene$fetchSceneAvatarConfig$1) == coroutine_suspended) {
                            }
                        } else {
                            str5 = str2;
                            str6 = str4;
                            coupleAvatarScene = this;
                            bpConfig = new BpConfig(null, null, null, null, null, null, null, null, null, null, 1023, null);
                            str7 = str3;
                            if (str5 == null) {
                            }
                            z17 = true;
                            if (!z17) {
                            }
                        }
                        break;
                    case 1:
                        String str18 = (String) coupleAvatarScene$fetchSceneAvatarConfig$1.L$4;
                        str7 = (String) coupleAvatarScene$fetchSceneAvatarConfig$1.L$3;
                        String str19 = (String) coupleAvatarScene$fetchSceneAvatarConfig$1.L$2;
                        com.tencent.zplan.zplantracing.c cVar7 = (com.tencent.zplan.zplantracing.c) coupleAvatarScene$fetchSceneAvatarConfig$1.L$1;
                        coupleAvatarScene = (CoupleAvatarScene) coupleAvatarScene$fetchSceneAvatarConfig$1.L$0;
                        ResultKt.throwOnFailure(obj2);
                        str6 = str18;
                        cVar5 = cVar7;
                        obj = obj2;
                        str5 = str19;
                        bpConfig = (BpConfig) obj;
                        if (str5 == null) {
                        }
                        z17 = true;
                        if (!z17) {
                        }
                        break;
                    case 2:
                        bpConfig3 = (BpConfig) coupleAvatarScene$fetchSceneAvatarConfig$1.L$4;
                        str9 = (String) coupleAvatarScene$fetchSceneAvatarConfig$1.L$3;
                        str10 = (String) coupleAvatarScene$fetchSceneAvatarConfig$1.L$2;
                        cVar2 = (com.tencent.zplan.zplantracing.c) coupleAvatarScene$fetchSceneAvatarConfig$1.L$1;
                        coupleAvatarScene = (CoupleAvatarScene) coupleAvatarScene$fetchSceneAvatarConfig$1.L$0;
                        ResultKt.throwOnFailure(obj2);
                        bpConfig2 = (BpConfig) obj2;
                        String str142 = str10;
                        bpConfig = bpConfig3;
                        cVar5 = cVar2;
                        str8 = str142;
                        coupleAvatarScene$fetchSceneAvatarConfig$1.L$0 = coupleAvatarScene;
                        coupleAvatarScene$fetchSceneAvatarConfig$1.L$1 = cVar5;
                        coupleAvatarScene$fetchSceneAvatarConfig$1.L$2 = str8;
                        coupleAvatarScene$fetchSceneAvatarConfig$1.L$3 = str9;
                        coupleAvatarScene$fetchSceneAvatarConfig$1.L$4 = bpConfig;
                        coupleAvatarScene$fetchSceneAvatarConfig$1.L$5 = bpConfig2;
                        coupleAvatarScene$fetchSceneAvatarConfig$1.label = 3;
                        if (coupleAvatarScene.O0(cVar5, bpConfig, coupleAvatarScene$fetchSceneAvatarConfig$1) == coroutine_suspended) {
                        }
                        break;
                    case 3:
                        bpConfig4 = (BpConfig) coupleAvatarScene$fetchSceneAvatarConfig$1.L$5;
                        bpConfig5 = (BpConfig) coupleAvatarScene$fetchSceneAvatarConfig$1.L$4;
                        str11 = (String) coupleAvatarScene$fetchSceneAvatarConfig$1.L$3;
                        str8 = (String) coupleAvatarScene$fetchSceneAvatarConfig$1.L$2;
                        cVar3 = (com.tencent.zplan.zplantracing.c) coupleAvatarScene$fetchSceneAvatarConfig$1.L$1;
                        coupleAvatarScene2 = (CoupleAvatarScene) coupleAvatarScene$fetchSceneAvatarConfig$1.L$0;
                        ResultKt.throwOnFailure(obj2);
                        coupleAvatarScene$fetchSceneAvatarConfig$1.L$0 = coupleAvatarScene2;
                        coupleAvatarScene$fetchSceneAvatarConfig$1.L$1 = cVar3;
                        coupleAvatarScene$fetchSceneAvatarConfig$1.L$2 = str8;
                        coupleAvatarScene$fetchSceneAvatarConfig$1.L$3 = str11;
                        coupleAvatarScene$fetchSceneAvatarConfig$1.L$4 = bpConfig5;
                        coupleAvatarScene$fetchSceneAvatarConfig$1.L$5 = bpConfig4;
                        coupleAvatarScene$fetchSceneAvatarConfig$1.label = 4;
                        if (coupleAvatarScene2.O0(cVar3, bpConfig4, coupleAvatarScene$fetchSceneAvatarConfig$1) == coroutine_suspended) {
                        }
                        String str152 = str11;
                        com.tencent.zplan.zplantracing.c cVar62 = cVar3;
                        CoupleAvatarScene coupleAvatarScene52 = coupleAvatarScene2;
                        String str162 = str8;
                        ZPlanAvatarResourceHelper zPlanAvatarResourceHelper3 = ZPlanAvatarResourceHelper.f105660o;
                        FilamentUrlTemplate filamentUrlTemplate3 = coupleAvatarScene52.urlTemplate;
                        coupleAvatarScene$fetchSceneAvatarConfig$1.L$0 = coupleAvatarScene52;
                        coupleAvatarScene$fetchSceneAvatarConfig$1.L$1 = cVar62;
                        coupleAvatarScene$fetchSceneAvatarConfig$1.L$2 = str152;
                        coupleAvatarScene$fetchSceneAvatarConfig$1.L$3 = bpConfig5;
                        coupleAvatarScene$fetchSceneAvatarConfig$1.L$4 = bpConfig4;
                        coupleAvatarScene$fetchSceneAvatarConfig$1.L$5 = null;
                        coupleAvatarScene$fetchSceneAvatarConfig$1.label = 5;
                        z18 = true;
                        h06 = ZPlanAvatarResourceHelper.h0(zPlanAvatarResourceHelper3, cVar62, str162, filamentUrlTemplate3, false, coupleAvatarScene$fetchSceneAvatarConfig$1, 8, null);
                        if (h06 == coroutine_suspended) {
                        }
                        break;
                    case 4:
                        bpConfig4 = (BpConfig) coupleAvatarScene$fetchSceneAvatarConfig$1.L$5;
                        bpConfig5 = (BpConfig) coupleAvatarScene$fetchSceneAvatarConfig$1.L$4;
                        str11 = (String) coupleAvatarScene$fetchSceneAvatarConfig$1.L$3;
                        str8 = (String) coupleAvatarScene$fetchSceneAvatarConfig$1.L$2;
                        cVar3 = (com.tencent.zplan.zplantracing.c) coupleAvatarScene$fetchSceneAvatarConfig$1.L$1;
                        coupleAvatarScene2 = (CoupleAvatarScene) coupleAvatarScene$fetchSceneAvatarConfig$1.L$0;
                        ResultKt.throwOnFailure(obj2);
                        String str1522 = str11;
                        com.tencent.zplan.zplantracing.c cVar622 = cVar3;
                        CoupleAvatarScene coupleAvatarScene522 = coupleAvatarScene2;
                        String str1622 = str8;
                        ZPlanAvatarResourceHelper zPlanAvatarResourceHelper32 = ZPlanAvatarResourceHelper.f105660o;
                        FilamentUrlTemplate filamentUrlTemplate32 = coupleAvatarScene522.urlTemplate;
                        coupleAvatarScene$fetchSceneAvatarConfig$1.L$0 = coupleAvatarScene522;
                        coupleAvatarScene$fetchSceneAvatarConfig$1.L$1 = cVar622;
                        coupleAvatarScene$fetchSceneAvatarConfig$1.L$2 = str1522;
                        coupleAvatarScene$fetchSceneAvatarConfig$1.L$3 = bpConfig5;
                        coupleAvatarScene$fetchSceneAvatarConfig$1.L$4 = bpConfig4;
                        coupleAvatarScene$fetchSceneAvatarConfig$1.L$5 = null;
                        coupleAvatarScene$fetchSceneAvatarConfig$1.label = 5;
                        z18 = true;
                        h06 = ZPlanAvatarResourceHelper.h0(zPlanAvatarResourceHelper32, cVar622, str1622, filamentUrlTemplate32, false, coupleAvatarScene$fetchSceneAvatarConfig$1, 8, null);
                        if (h06 == coroutine_suspended) {
                        }
                        break;
                    case 5:
                        BpConfig bpConfig12 = (BpConfig) coupleAvatarScene$fetchSceneAvatarConfig$1.L$4;
                        BpConfig bpConfig13 = (BpConfig) coupleAvatarScene$fetchSceneAvatarConfig$1.L$3;
                        String str20 = (String) coupleAvatarScene$fetchSceneAvatarConfig$1.L$2;
                        cVar4 = (com.tencent.zplan.zplantracing.c) coupleAvatarScene$fetchSceneAvatarConfig$1.L$1;
                        CoupleAvatarScene coupleAvatarScene6 = (CoupleAvatarScene) coupleAvatarScene$fetchSceneAvatarConfig$1.L$0;
                        ResultKt.throwOnFailure(obj2);
                        z18 = true;
                        bpConfig6 = bpConfig13;
                        bpConfig7 = bpConfig12;
                        coupleAvatarScene3 = coupleAvatarScene6;
                        str12 = str20;
                        Resource resource22 = (Resource) obj2;
                        ZPlanAvatarResourceHelper zPlanAvatarResourceHelper22 = ZPlanAvatarResourceHelper.f105660o;
                        FilamentUrlTemplate filamentUrlTemplate22 = coupleAvatarScene3.urlTemplate;
                        coupleAvatarScene$fetchSceneAvatarConfig$1.L$0 = coupleAvatarScene3;
                        coupleAvatarScene$fetchSceneAvatarConfig$1.L$1 = bpConfig6;
                        coupleAvatarScene$fetchSceneAvatarConfig$1.L$2 = bpConfig7;
                        coupleAvatarScene$fetchSceneAvatarConfig$1.L$3 = resource22;
                        coupleAvatarScene$fetchSceneAvatarConfig$1.L$4 = null;
                        coupleAvatarScene$fetchSceneAvatarConfig$1.label = 6;
                        CoupleAvatarScene$fetchSceneAvatarConfig$1 coupleAvatarScene$fetchSceneAvatarConfig$122 = coupleAvatarScene$fetchSceneAvatarConfig$1;
                        BpConfig bpConfig112 = bpConfig6;
                        h07 = ZPlanAvatarResourceHelper.h0(zPlanAvatarResourceHelper22, cVar4, str12, filamentUrlTemplate22, false, coupleAvatarScene$fetchSceneAvatarConfig$122, 8, null);
                        if (h07 != coroutine_suspended) {
                        }
                        break;
                    case 6:
                        resource = (Resource) coupleAvatarScene$fetchSceneAvatarConfig$1.L$3;
                        BpConfig bpConfig14 = (BpConfig) coupleAvatarScene$fetchSceneAvatarConfig$1.L$2;
                        bpConfig9 = (BpConfig) coupleAvatarScene$fetchSceneAvatarConfig$1.L$1;
                        coupleAvatarScene4 = (CoupleAvatarScene) coupleAvatarScene$fetchSceneAvatarConfig$1.L$0;
                        ResultKt.throwOnFailure(obj2);
                        bpConfig8 = bpConfig14;
                        z18 = true;
                        Resource resource32 = (Resource) obj2;
                        if (!coupleAvatarScene4.hasDownloadFromNet) {
                            break;
                        }
                        z19 = z18;
                        coupleAvatarScene4.hasDownloadFromNet = z19;
                        FilamentFileUtil filamentFileUtil2 = FilamentFileUtil.INSTANCE;
                        return new AvatarConfig(FilamentFileUtil.filePathInDir$default(filamentFileUtil2, resource.e(), null, "gltf", 2, null), FilamentFileUtil.filePathInDir$default(filamentFileUtil2, resource32.e(), null, "gltf", 2, null), bpConfig9, bpConfig8, false, false, 48, null);
                    default:
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
            }
        }
        coupleAvatarScene$fetchSceneAvatarConfig$1 = new CoupleAvatarScene$fetchSceneAvatarConfig$1(this, continuation);
        Object obj22 = coupleAvatarScene$fetchSceneAvatarConfig$1.result;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        boolean z192 = false;
        switch (coupleAvatarScene$fetchSceneAvatarConfig$1.label) {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Removed duplicated region for block: B:19:0x00ab  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x00d4 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:23:0x00d5  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x00a0 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:34:0x00a1  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x005e  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0029  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final /* synthetic */ Object U0(com.tencent.zplan.zplantracing.c cVar, String str, Continuation<? super BpConfig> continuation) {
        CoupleAvatarScene$fetchSceneRoomConfig$1 coupleAvatarScene$fetchSceneRoomConfig$1;
        Object coroutine_suspended;
        int i3;
        boolean z16;
        com.tencent.zplan.zplantracing.c cVar2;
        Object h06;
        CoupleAvatarScene coupleAvatarScene;
        Object a16;
        com.tencent.zplan.zplantracing.c cVar3;
        BpConfig bpConfig;
        if (continuation instanceof CoupleAvatarScene$fetchSceneRoomConfig$1) {
            coupleAvatarScene$fetchSceneRoomConfig$1 = (CoupleAvatarScene$fetchSceneRoomConfig$1) continuation;
            int i16 = coupleAvatarScene$fetchSceneRoomConfig$1.label;
            if ((i16 & Integer.MIN_VALUE) != 0) {
                coupleAvatarScene$fetchSceneRoomConfig$1.label = i16 - Integer.MIN_VALUE;
                Object obj = coupleAvatarScene$fetchSceneRoomConfig$1.result;
                coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i3 = coupleAvatarScene$fetchSceneRoomConfig$1.label;
                z16 = true;
                if (i3 == 0) {
                    if (i3 != 1) {
                        if (i3 != 2) {
                            if (i3 == 3) {
                                BpConfig bpConfig2 = (BpConfig) coupleAvatarScene$fetchSceneRoomConfig$1.L$0;
                                ResultKt.throwOnFailure(obj);
                                return bpConfig2;
                            }
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        cVar3 = (com.tencent.zplan.zplantracing.c) coupleAvatarScene$fetchSceneRoomConfig$1.L$1;
                        coupleAvatarScene = (CoupleAvatarScene) coupleAvatarScene$fetchSceneRoomConfig$1.L$0;
                        ResultKt.throwOnFailure(obj);
                        bpConfig = (BpConfig) obj;
                        if (bpConfig == null) {
                            bpConfig = new BpConfig(null, null, null, null, null, null, null, null, null, null, 1023, null);
                        }
                        coupleAvatarScene$fetchSceneRoomConfig$1.L$0 = bpConfig;
                        coupleAvatarScene$fetchSceneRoomConfig$1.L$1 = null;
                        coupleAvatarScene$fetchSceneRoomConfig$1.label = 3;
                        if (coupleAvatarScene.O0(cVar3, bpConfig, coupleAvatarScene$fetchSceneRoomConfig$1) != coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        return bpConfig;
                    }
                    com.tencent.zplan.zplantracing.c cVar4 = (com.tencent.zplan.zplantracing.c) coupleAvatarScene$fetchSceneRoomConfig$1.L$1;
                    coupleAvatarScene = (CoupleAvatarScene) coupleAvatarScene$fetchSceneRoomConfig$1.L$0;
                    ResultKt.throwOnFailure(obj);
                    h06 = obj;
                    cVar2 = cVar4;
                } else {
                    ResultKt.throwOnFailure(obj);
                    ZPlanAvatarResourceHelper zPlanAvatarResourceHelper = ZPlanAvatarResourceHelper.f105660o;
                    FilamentUrlTemplate filamentUrlTemplate = this.urlTemplate;
                    coupleAvatarScene$fetchSceneRoomConfig$1.L$0 = this;
                    cVar2 = cVar;
                    coupleAvatarScene$fetchSceneRoomConfig$1.L$1 = cVar2;
                    coupleAvatarScene$fetchSceneRoomConfig$1.label = 1;
                    h06 = ZPlanAvatarResourceHelper.h0(zPlanAvatarResourceHelper, cVar, str, filamentUrlTemplate, false, coupleAvatarScene$fetchSceneRoomConfig$1, 8, null);
                    if (h06 == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    coupleAvatarScene = this;
                }
                Resource resource = (Resource) h06;
                if (!coupleAvatarScene.hasDownloadFromNet && !resource.d()) {
                    z16 = false;
                }
                coupleAvatarScene.hasDownloadFromNet = z16;
                BpConfig.Companion companion = BpConfig.INSTANCE;
                String e16 = resource.e();
                coupleAvatarScene$fetchSceneRoomConfig$1.L$0 = coupleAvatarScene;
                coupleAvatarScene$fetchSceneRoomConfig$1.L$1 = cVar2;
                coupleAvatarScene$fetchSceneRoomConfig$1.label = 2;
                a16 = companion.a(e16, coupleAvatarScene$fetchSceneRoomConfig$1);
                if (a16 != coroutine_suspended) {
                    return coroutine_suspended;
                }
                cVar3 = cVar2;
                obj = a16;
                bpConfig = (BpConfig) obj;
                if (bpConfig == null) {
                }
                coupleAvatarScene$fetchSceneRoomConfig$1.L$0 = bpConfig;
                coupleAvatarScene$fetchSceneRoomConfig$1.L$1 = null;
                coupleAvatarScene$fetchSceneRoomConfig$1.label = 3;
                if (coupleAvatarScene.O0(cVar3, bpConfig, coupleAvatarScene$fetchSceneRoomConfig$1) != coroutine_suspended) {
                }
            }
        }
        coupleAvatarScene$fetchSceneRoomConfig$1 = new CoupleAvatarScene$fetchSceneRoomConfig$1(this, continuation);
        Object obj2 = coupleAvatarScene$fetchSceneRoomConfig$1.result;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i3 = coupleAvatarScene$fetchSceneRoomConfig$1.label;
        z16 = true;
        if (i3 == 0) {
        }
        Resource resource2 = (Resource) h06;
        if (!coupleAvatarScene.hasDownloadFromNet) {
            z16 = false;
        }
        coupleAvatarScene.hasDownloadFromNet = z16;
        BpConfig.Companion companion2 = BpConfig.INSTANCE;
        String e162 = resource2.e();
        coupleAvatarScene$fetchSceneRoomConfig$1.L$0 = coupleAvatarScene;
        coupleAvatarScene$fetchSceneRoomConfig$1.L$1 = cVar2;
        coupleAvatarScene$fetchSceneRoomConfig$1.label = 2;
        a16 = companion2.a(e162, coupleAvatarScene$fetchSceneRoomConfig$1);
        if (a16 != coroutine_suspended) {
        }
    }

    @Override // com.tencent.filament.zplan.util.vsync.b
    public void d(long totalTime, long frameTime) {
        FilamentViewerV2305 viewer = getViewer();
        if (viewer != null && getAttached().get() && this.avatarCreated.get()) {
            y0(frameTime / 1000000000, null);
            if (this.needRecordFrame.get() && !this.hasRecordFrame.get()) {
                this.hasRecordFrame.set(true);
                viewer.recordFrame(this.recordFrameListener);
                FilamentViewerV2.render$default(viewer, true, null, 2, null);
                return;
            }
            FilamentViewerV2.render$default(viewer, false, null, 2, null);
        }
    }

    @Override // kotlinx.coroutines.CoroutineScope
    @NotNull
    public CoroutineContext getCoroutineContext() {
        return this.coroutineContext;
    }

    @Override // com.tencent.filament.zplan.app.scene.BaseSceneV2305, com.tencent.filament.zplan.app.scene.BaseSceneV2308
    public void n() {
        super.n();
        this.booted.set(false);
        this.avatarCreated.set(false);
    }

    @Override // com.tencent.filament.zplan.app.scene.BaseSceneV2308
    public void o(int errorCode, @Nullable String errorMessage) {
        Integer num;
        super.o(errorCode, errorMessage);
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("errorCode", errorCode);
        jSONObject.put("errorMessage", errorMessage);
        SceneConfig sceneConfig = this.sceneConfig;
        if (sceneConfig != null) {
            num = Integer.valueOf(sceneConfig.getSceneId());
        } else {
            num = null;
        }
        jSONObject.put(WadlProxyConsts.SCENE_ID, num);
        jSONObject.put("hasNetProcess", this.hasDownloadFromNet);
        jSONObject.put("hasPaused", this.hasPaused);
        Unit unit = Unit.INSTANCE;
        M0(this, null, "onFilamentRenderFail", jSONObject, null, null, 25, null);
    }

    @Override // com.tencent.filament.zplan.app.scene.BaseSceneV2308
    public void q() {
        super.q();
        this.hasPaused = true;
    }

    @Override // com.tencent.filament.zplan.app.scene.BaseSceneV2305, com.tencent.filament.zplan.app.scene.BaseSceneV2308
    public void s(@NotNull SurfaceTexture surfaceTexture, int width, int height) {
        Intrinsics.checkNotNullParameter(surfaceTexture, "surfaceTexture");
        super.s(surfaceTexture, width, height);
        k().d("configCamera", new Function0<Unit>() { // from class: com.tencent.filament.zplan.scene.couple.CoupleAvatarScene$onSurfaceTextureAvailable$1
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
                SceneConfig sceneConfig;
                sceneConfig = CoupleAvatarScene.this.sceneConfig;
                BpConfig room = sceneConfig != null ? sceneConfig.getRoom() : null;
                if (room != null) {
                    CoupleAvatarScene.this.D0(room);
                }
            }
        });
    }

    @Override // com.tencent.filament.zplan.app.scene.BaseSceneV2305, com.tencent.filament.zplan.app.scene.BaseSceneV2308
    public void u(@NotNull SurfaceTexture surfaceTexture, int width, int height) {
        Intrinsics.checkNotNullParameter(surfaceTexture, "surfaceTexture");
        super.u(surfaceTexture, width, height);
        k().d("configCamera", new Function0<Unit>() { // from class: com.tencent.filament.zplan.scene.couple.CoupleAvatarScene$onSurfaceTextureSizeChanged$1
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
                SceneConfig sceneConfig;
                sceneConfig = CoupleAvatarScene.this.sceneConfig;
                BpConfig room = sceneConfig != null ? sceneConfig.getRoom() : null;
                if (room != null) {
                    CoupleAvatarScene.this.D0(room);
                }
            }
        });
    }
}

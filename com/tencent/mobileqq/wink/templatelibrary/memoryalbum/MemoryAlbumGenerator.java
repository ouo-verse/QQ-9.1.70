package com.tencent.mobileqq.wink.templatelibrary.memoryalbum;

import androidx.exifinterface.media.ExifInterface;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import camera.XEFFECT_MATERIALS_GENERAL_DATASTRUCT.MetaCategory;
import camera.XEFFECT_MATERIALS_GENERAL_DATASTRUCT.MetaMaterial;
import com.tencent.biz.pubaccount.util.api.impl.PublicAccountMessageUtilImpl;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.activity.photo.album.QAlbumCustomAlbumConstants;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.BusinessHandler;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.wink.WinkCoroutineScopes;
import com.tencent.mobileqq.wink.db.memoryalbumdb.WinkMemoryAlbumDBHelper;
import com.tencent.mobileqq.wink.edit.manager.WinkEditorResourceManager;
import com.tencent.mobileqq.wink.launcher.network.WinkRecommendDataServiceHandler;
import com.tencent.mobileqq.wink.picker.MediaType;
import com.tencent.mobileqq.wink.picker.core.repository.a;
import com.tencent.mobileqq.wink.utils.ak;
import com.tencent.mobileqq.wink.utils.ar;
import com.tencent.mobileqq.winkreport.dengta.WinkDengtaReportConstant;
import com.tencent.opentelemetry.semconv.trace.attributes.SemanticAttributes;
import com.tencent.qphone.base.util.QLog;
import com.tencent.thread.monitor.plugin.proxy.BaseTimer;
import com.tencent.videocut.utils.LiveDataExtKt;
import cooperation.qqcircle.report.QCircleWeakNetReporter;
import e93.QZoneAlbumInfo;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.CollectionsKt__MutableCollectionsJVMKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.comparisons.ComparisonsKt__ComparisonsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugProbes;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt__MathJVMKt;
import kotlin.text.StringsKt__StringsJVMKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CancellableContinuation;
import kotlinx.coroutines.CancellableContinuationImpl;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.SupervisorKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u00c0\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010$\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010%\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0010\b\u00c6\u0002\u0018\u00002\u00020\u00012\u00020\u0002B\t\b\u0002\u00a2\u0006\u0004\bx\u0010yJ!\u0010\u0007\u001a\u00020\u00062\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\u0082@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0007\u0010\bJ!\u0010\n\u001a\u00020\u00062\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\u0082@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\n\u0010\bJ\u0013\u0010\u000b\u001a\u00020\u0006H\u0082@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u000b\u0010\fJ\u0019\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u000e0\rH\u0082@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u000f\u0010\fJ\u0010\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0010\u001a\u00020\u000eH\u0002J!\u0010\u0014\u001a\u00020\u00112\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u000e0\rH\u0082@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0014\u0010\bJ!\u0010\u0016\u001a\u00020\u00062\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u000e0\rH\u0082@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0016\u0010\bJ\u0010\u0010\u0019\u001a\u00020\u00062\u0006\u0010\u0018\u001a\u00020\u0017H\u0002J\u0012\u0010\u001c\u001a\u0004\u0018\u00010\u00172\u0006\u0010\u001b\u001a\u00020\u001aH\u0002J\u0016\u0010 \u001a\u00020\u00062\f\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u001e0\u001dH\u0002J\u0013\u0010!\u001a\u00020\u0011H\u0082@\u00f8\u0001\u0000\u00a2\u0006\u0004\b!\u0010\fJ!\u0010\"\u001a\u00020\u00062\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00040\rH\u0082@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\"\u0010\bJ\u0010\u0010$\u001a\u00020\u00112\u0006\u0010#\u001a\u00020\u0004H\u0002J\u001c\u0010&\u001a\b\u0012\u0004\u0012\u00020\u001a0\u00032\f\u0010%\u001a\b\u0012\u0004\u0012\u00020\u001a0\rH\u0002J$\u0010'\u001a\b\u0012\u0004\u0012\u00020\u001a0\u00032\f\u0010%\u001a\b\u0012\u0004\u0012\u00020\u001a0\u00032\u0006\u0010#\u001a\u00020\u0004H\u0002J\u0016\u0010)\u001a\u00020\u00062\f\u0010(\u001a\b\u0012\u0004\u0012\u00020\u00040\rH\u0002J)\u0010,\u001a\u00020\u00062\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00040\r2\u0006\u0010+\u001a\u00020*H\u0082@\u00f8\u0001\u0000\u00a2\u0006\u0004\b,\u0010-J'\u00100\u001a\b\u0012\u0004\u0012\u00020\u00060\u00032\f\u0010/\u001a\b\u0012\u0004\u0012\u00020\u001a0.H\u0082@\u00f8\u0001\u0000\u00a2\u0006\u0004\b0\u00101J\u0010\u00102\u001a\u00020\u00062\u0006\u0010#\u001a\u00020\u0004H\u0002J$\u00105\u001a\b\u0012\u0004\u0012\u00020\u001a0\u00032\f\u0010%\u001a\b\u0012\u0004\u0012\u00020\u001a0\u00032\u0006\u00104\u001a\u000203H\u0002J\u001c\u00106\u001a\b\u0012\u0004\u0012\u00020\u001a0\u00032\f\u0010%\u001a\b\u0012\u0004\u0012\u00020\u001a0\u0003H\u0002J\u0016\u00108\u001a\u00020\u001a2\f\u00107\u001a\b\u0012\u0004\u0012\u00020\u001a0\u0003H\u0002J\b\u00109\u001a\u00020\u0006H\u0002J\b\u0010:\u001a\u00020\u0006H\u0002J\b\u0010;\u001a\u00020\u0006H\u0002J\u001e\u0010=\u001a\u00020\u00062\u0014\u0010\u0013\u001a\u0010\u0012\u0004\u0012\u00020\u001a\u0012\u0004\u0012\u00020\u000e\u0018\u00010<H\u0002J\u0016\u0010?\u001a\u00020\u00062\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020>0\rH\u0002J\u0010\u0010A\u001a\u00020\u00062\u0006\u0010@\u001a\u00020*H\u0002J\b\u0010B\u001a\u00020\u0011H\u0002J\u0018\u0010E\u001a\u00020*2\u0006\u0010C\u001a\u00020*2\u0006\u0010D\u001a\u00020\u001aH\u0002J\u0016\u0010H\u001a\u00020\u00062\u000e\u0010G\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010FJ\b\u0010I\u001a\u00020\u0006H\u0016J\b\u0010J\u001a\u00020\u0011H\u0016J\u001e\u0010K\u001a\u00020\u00112\u0014\u0010\u0013\u001a\u0010\u0012\u0004\u0012\u00020\u001a\u0012\u0004\u0012\u00020\u000e\u0018\u00010<H\u0016J\b\u0010L\u001a\u00020\u0006H\u0014R\u0014\u0010O\u001a\u00020\u001a8\u0002X\u0082D\u00a2\u0006\u0006\n\u0004\bM\u0010NR\u0018\u0010S\u001a\u0004\u0018\u00010P8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bQ\u0010RR\u0018\u0010V\u001a\u0004\u0018\u00010T8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bJ\u0010UR \u0010Z\u001a\u000e\u0012\u0004\u0012\u00020\u001a\u0012\u0004\u0012\u00020\u00170W8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bX\u0010YR \u0010[\u001a\u000e\u0012\u0004\u0012\u00020\u001a\u0012\u0004\u0012\u00020\u000e0W8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bI\u0010YR\"\u0010\u0013\u001a\u000e\u0012\u0004\u0012\u00020\u001a\u0012\u0004\u0012\u00020\u000e0\\8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b]\u0010^R \u0010b\u001a\u000e\u0012\u0004\u0012\u00020\u001a\u0012\u0004\u0012\u00020`0_8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bL\u0010aR\u0018\u0010f\u001a\u0004\u0018\u00010c8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bd\u0010eR\u0014\u0010i\u001a\u00020g8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bK\u0010hR\u0016\u0010m\u001a\u00020j8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bk\u0010lR\u0016\u0010o\u001a\u00020j8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bn\u0010lR \u0010q\u001a\u000e\u0012\u0004\u0012\u00020\u001a\u0012\u0004\u0012\u00020\u001a0\\8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bp\u0010^R\u0014\u0010s\u001a\u00020g8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\br\u0010hR\u001e\u0010G\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010F8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bt\u0010uR\u0014\u0010w\u001a\u00020\u001a8VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\bQ\u0010v\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006z"}, d2 = {"Lcom/tencent/mobileqq/wink/templatelibrary/memoryalbum/MemoryAlbumGenerator;", "Lx83/b;", "", "", "Ls53/a;", "preLoadAlbum", "", "v0", "(Ljava/util/List;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "queryAlbums", "u0", "a0", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "", "Lcom/tencent/mobileqq/activity/photo/LocalMediaInfo;", "t0", "mediaInfo", "", "Z", "mediaList", "r0", "queryDataList", "Y", "Ls53/b;", "it", "m0", "", PublicAccountMessageUtilImpl.ITEM_STRUCT_FIRST_LEVEL_NAME, "X", "Ljava/util/ArrayList;", "Lcamera/XEFFECT_MATERIALS_GENERAL_DATASTRUCT/MetaMaterial;", "materials", "s0", "U", "h0", "album", ExifInterface.LATITUDE_SOUTH, "photos", "i0", AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, "albums", "n0", "", "start1", "p0", "(Ljava/util/List;JLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Ljava/util/HashSet;", "unFaceDetectIdMap", BdhLogUtil.LogTag.Tag_Req, "(Ljava/util/HashSet;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "T", "", "count", "k0", "q0", "list", "f0", "O", "b0", "P", "", "d0", "Lcamera/XEFFECT_MATERIALS_GENERAL_DATASTRUCT/MetaCategory;", "c0", QCircleWeakNetReporter.KEY_COST, "j0", "W", "timestamp", "format", "V", "Lcom/tencent/mobileqq/wink/newalbum/director/datasource/a;", "dataConsumer", "l0", "f", "d", "j", tl.h.F, "b", "Ljava/lang/String;", "TAG", "Ljava/util/Timer;", "c", "Ljava/util/Timer;", SemanticAttributes.FaasTriggerValues.TIMER, "Lkotlinx/coroutines/Job;", "Lkotlinx/coroutines/Job;", "startJob", "Ljava/util/concurrent/ConcurrentHashMap;", "e", "Ljava/util/concurrent/ConcurrentHashMap;", "memoryPhotoMap", "originPhotoMap", "", "g", "Ljava/util/Map;", "Ljava/util/HashMap;", "Lcom/tencent/mobileqq/wink/templatelibrary/memoryalbum/l;", "Ljava/util/HashMap;", "configMap", "Lcom/tencent/mobileqq/wink/picker/core/repository/h;", "i", "Lcom/tencent/mobileqq/wink/picker/core/repository/h;", "localMediaRepository", "Lkotlinx/coroutines/CoroutineScope;", "Lkotlinx/coroutines/CoroutineScope;", "fileScope", "Ljava/util/concurrent/atomic/AtomicBoolean;", "k", "Ljava/util/concurrent/atomic/AtomicBoolean;", "haveGenerated", "l", "isGenerating", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "dengTaParams", DomainData.DOMAIN_NAME, "mainScope", "o", "Lcom/tencent/mobileqq/wink/newalbum/director/datasource/a;", "()Ljava/lang/String;", "logTag", "<init>", "()V", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes21.dex */
public final class MemoryAlbumGenerator extends x83.b {

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private static Timer timer;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private static Job startJob;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private static com.tencent.mobileqq.wink.picker.core.repository.h localMediaRepository;

    /* renamed from: o, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private static volatile com.tencent.mobileqq.wink.newalbum.director.datasource.a<s53.a> dataConsumer;

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final MemoryAlbumGenerator f326501a = new MemoryAlbumGenerator();

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final String TAG = "WinkNewAlbum_MemoryAlbumGenerator";

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final ConcurrentHashMap<String, s53.b> memoryPhotoMap = new ConcurrentHashMap<>();

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final ConcurrentHashMap<String, LocalMediaInfo> originPhotoMap = new ConcurrentHashMap<>();

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static Map<String, LocalMediaInfo> mediaList = new LinkedHashMap();

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final HashMap<String, WinkMemoryAlbumConfig> configMap = new HashMap<>();

    /* renamed from: j, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final CoroutineScope fileScope = CoroutineScopeKt.CoroutineScope(SupervisorKt.SupervisorJob$default((Job) null, 1, (Object) null).plus(WinkCoroutineScopes.f317652a.b()));

    /* renamed from: k, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static AtomicBoolean haveGenerated = new AtomicBoolean(false);

    /* renamed from: l, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static AtomicBoolean isGenerating = new AtomicBoolean(false);

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final Map<String, String> dengTaParams = new LinkedHashMap();

    /* renamed from: n, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final CoroutineScope mainScope = CoroutineScopeKt.MainScope();

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u000e\u0010\u0003\u001a\n \u0004*\u0004\u0018\u0001H\u0002H\u00022\u000e\u0010\u0005\u001a\n \u0004*\u0004\u0018\u0001H\u0002H\u0002H\n\u00a2\u0006\u0004\b\u0006\u0010\u0007\u00a8\u0006\b"}, d2 = {"<anonymous>", "", "T", "a", "kotlin.jvm.PlatformType", "b", "compare", "(Ljava/lang/Object;Ljava/lang/Object;)I", "kotlin/comparisons/ComparisonsKt__ComparisonsKt$compareBy$2"}, k = 3, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes21.dex */
    public static final class a<T> implements Comparator {
        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.util.Comparator
        public final int compare(T t16, T t17) {
            int compareValues;
            MemoryAlbumGenerator memoryAlbumGenerator = MemoryAlbumGenerator.f326501a;
            s53.b X = memoryAlbumGenerator.X((String) t16);
            Intrinsics.checkNotNull(X);
            Long valueOf = Long.valueOf(X.getTimestamp());
            s53.b X2 = memoryAlbumGenerator.X((String) t17);
            Intrinsics.checkNotNull(X2);
            compareValues = ComparisonsKt__ComparisonsKt.compareValues(valueOf, Long.valueOf(X2.getTimestamp()));
            return compareValues;
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u000e\u0010\u0003\u001a\n \u0004*\u0004\u0018\u0001H\u0002H\u00022\u000e\u0010\u0005\u001a\n \u0004*\u0004\u0018\u0001H\u0002H\u0002H\n\u00a2\u0006\u0004\b\u0006\u0010\u0007\u00a8\u0006\b"}, d2 = {"<anonymous>", "", "T", "a", "kotlin.jvm.PlatformType", "b", "compare", "(Ljava/lang/Object;Ljava/lang/Object;)I", "kotlin/comparisons/ComparisonsKt__ComparisonsKt$compareByDescending$1"}, k = 3, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes21.dex */
    public static final class b<T> implements Comparator {
        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.util.Comparator
        public final int compare(T t16, T t17) {
            int compareValues;
            MemoryAlbumGenerator memoryAlbumGenerator = MemoryAlbumGenerator.f326501a;
            s53.b X = memoryAlbumGenerator.X((String) t17);
            Intrinsics.checkNotNull(X);
            Long valueOf = Long.valueOf(X.getTimestamp());
            s53.b X2 = memoryAlbumGenerator.X((String) t16);
            Intrinsics.checkNotNull(X2);
            compareValues = ComparisonsKt__ComparisonsKt.compareValues(valueOf, Long.valueOf(X2.getTimestamp()));
            return compareValues;
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u000e\u0010\u0003\u001a\n \u0004*\u0004\u0018\u0001H\u0002H\u00022\u000e\u0010\u0005\u001a\n \u0004*\u0004\u0018\u0001H\u0002H\u0002H\n\u00a2\u0006\u0004\b\u0006\u0010\u0007\u00a8\u0006\b"}, d2 = {"<anonymous>", "", "T", "a", "kotlin.jvm.PlatformType", "b", "compare", "(Ljava/lang/Object;Ljava/lang/Object;)I", "kotlin/comparisons/ComparisonsKt__ComparisonsKt$compareByDescending$1"}, k = 3, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes21.dex */
    public static final class c<T> implements Comparator {
        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.util.Comparator
        public final int compare(T t16, T t17) {
            int compareValues;
            MemoryAlbumGenerator memoryAlbumGenerator = MemoryAlbumGenerator.f326501a;
            s53.b X = memoryAlbumGenerator.X((String) t17);
            Intrinsics.checkNotNull(X);
            Integer valueOf = Integer.valueOf(X.getMediaType());
            s53.b X2 = memoryAlbumGenerator.X((String) t16);
            Intrinsics.checkNotNull(X2);
            compareValues = ComparisonsKt__ComparisonsKt.compareValues(valueOf, Integer.valueOf(X2.getMediaType()));
            return compareValues;
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u000e\u0010\u0003\u001a\n \u0004*\u0004\u0018\u0001H\u0002H\u00022\u000e\u0010\u0005\u001a\n \u0004*\u0004\u0018\u0001H\u0002H\u0002H\n\u00a2\u0006\u0004\b\u0006\u0010\u0007\u00a8\u0006\b"}, d2 = {"<anonymous>", "", "T", "a", "kotlin.jvm.PlatformType", "b", "compare", "(Ljava/lang/Object;Ljava/lang/Object;)I", "kotlin/comparisons/ComparisonsKt__ComparisonsKt$thenBy$1"}, k = 3, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes21.dex */
    public static final class d<T> implements Comparator {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ Comparator f326516d;

        public d(Comparator comparator) {
            this.f326516d = comparator;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.util.Comparator
        public final int compare(T t16, T t17) {
            int compareValues;
            int compare = this.f326516d.compare(t16, t17);
            if (compare == 0) {
                MemoryAlbumGenerator memoryAlbumGenerator = MemoryAlbumGenerator.f326501a;
                s53.b X = memoryAlbumGenerator.X((String) t16);
                Intrinsics.checkNotNull(X);
                Long valueOf = Long.valueOf(X.getTimestamp());
                s53.b X2 = memoryAlbumGenerator.X((String) t17);
                Intrinsics.checkNotNull(X2);
                compareValues = ComparisonsKt__ComparisonsKt.compareValues(valueOf, Long.valueOf(X2.getTimestamp()));
                return compareValues;
            }
            return compare;
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u000e\u0010\u0003\u001a\n \u0004*\u0004\u0018\u0001H\u0002H\u00022\u000e\u0010\u0005\u001a\n \u0004*\u0004\u0018\u0001H\u0002H\u0002H\n\u00a2\u0006\u0004\b\u0006\u0010\u0007\u00a8\u0006\b"}, d2 = {"<anonymous>", "", "T", "a", "kotlin.jvm.PlatformType", "b", "compare", "(Ljava/lang/Object;Ljava/lang/Object;)I", "kotlin/comparisons/ComparisonsKt__ComparisonsKt$thenByDescending$1"}, k = 3, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes21.dex */
    public static final class e<T> implements Comparator {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ Comparator f326517d;

        public e(Comparator comparator) {
            this.f326517d = comparator;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.util.Comparator
        public final int compare(T t16, T t17) {
            int compareValues;
            int compare = this.f326517d.compare(t16, t17);
            if (compare == 0) {
                MemoryAlbumGenerator memoryAlbumGenerator = MemoryAlbumGenerator.f326501a;
                s53.b X = memoryAlbumGenerator.X((String) t17);
                Intrinsics.checkNotNull(X);
                Integer valueOf = Integer.valueOf(X.getHaveFace());
                s53.b X2 = memoryAlbumGenerator.X((String) t16);
                Intrinsics.checkNotNull(X2);
                compareValues = ComparisonsKt__ComparisonsKt.compareValues(valueOf, Integer.valueOf(X2.getHaveFace()));
                return compareValues;
            }
            return compare;
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u000e\u0010\u0003\u001a\n \u0004*\u0004\u0018\u0001H\u0002H\u00022\u000e\u0010\u0005\u001a\n \u0004*\u0004\u0018\u0001H\u0002H\u0002H\n\u00a2\u0006\u0004\b\u0006\u0010\u0007\u00a8\u0006\b"}, d2 = {"<anonymous>", "", "T", "a", "kotlin.jvm.PlatformType", "b", "compare", "(Ljava/lang/Object;Ljava/lang/Object;)I", "kotlin/comparisons/ComparisonsKt__ComparisonsKt$thenByDescending$1"}, k = 3, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes21.dex */
    public static final class f<T> implements Comparator {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ Comparator f326518d;

        public f(Comparator comparator) {
            this.f326518d = comparator;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.util.Comparator
        public final int compare(T t16, T t17) {
            boolean z16;
            int compareValues;
            int compare = this.f326518d.compare(t16, t17);
            if (compare == 0) {
                String str = (String) t17;
                MemoryAlbumGenerator memoryAlbumGenerator = MemoryAlbumGenerator.f326501a;
                s53.b X = memoryAlbumGenerator.X(str);
                Intrinsics.checkNotNull(X);
                int width = X.getWidth();
                s53.b X2 = memoryAlbumGenerator.X(str);
                Intrinsics.checkNotNull(X2);
                boolean z17 = true;
                if (width < X2.getHeight()) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                Boolean valueOf = Boolean.valueOf(z16);
                String str2 = (String) t16;
                s53.b X3 = memoryAlbumGenerator.X(str2);
                Intrinsics.checkNotNull(X3);
                int width2 = X3.getWidth();
                s53.b X4 = memoryAlbumGenerator.X(str2);
                Intrinsics.checkNotNull(X4);
                if (width2 >= X4.getHeight()) {
                    z17 = false;
                }
                compareValues = ComparisonsKt__ComparisonsKt.compareValues(valueOf, Boolean.valueOf(z17));
                return compareValues;
            }
            return compare;
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016\u00a8\u0006\t"}, d2 = {"com/tencent/mobileqq/wink/templatelibrary/memoryalbum/MemoryAlbumGenerator$g", "Lcom/tencent/mobileqq/wink/picker/core/repository/a$b;", "Le93/j;", "qZoneAlbumInfo", "", "a", "Lcom/tencent/mobileqq/wink/picker/core/repository/b;", "mediaRepoData", "b", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes21.dex */
    public static final class g implements a.b {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ CancellableContinuation<List<LocalMediaInfo>> f326519a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ List<LocalMediaInfo> f326520b;

        /* JADX WARN: Multi-variable type inference failed */
        g(CancellableContinuation<? super List<LocalMediaInfo>> cancellableContinuation, List<LocalMediaInfo> list) {
            this.f326519a = cancellableContinuation;
            this.f326520b = list;
        }

        @Override // com.tencent.mobileqq.wink.picker.core.repository.a.b
        public void a(@NotNull QZoneAlbumInfo qZoneAlbumInfo) {
            Intrinsics.checkNotNullParameter(qZoneAlbumInfo, "qZoneAlbumInfo");
        }

        @Override // com.tencent.mobileqq.wink.picker.core.repository.a.b
        public void b(@NotNull com.tencent.mobileqq.wink.picker.core.repository.b mediaRepoData) {
            List list;
            Intrinsics.checkNotNullParameter(mediaRepoData, "mediaRepoData");
            w53.b.f(MemoryAlbumGenerator.f326501a.c(), "onQueryNextFinish mediaRepoData size " + mediaRepoData.e().size());
            if (this.f326519a.isActive() && !this.f326519a.isCancelled()) {
                if (mediaRepoData.getIsSuccess()) {
                    List<LocalMediaInfo> list2 = this.f326520b;
                    list = CollectionsKt___CollectionsKt.toList(mediaRepoData.e());
                    ArrayList arrayList = new ArrayList();
                    for (Object obj : list) {
                        if (MemoryAlbumGenerator.f326501a.Z((LocalMediaInfo) obj)) {
                            arrayList.add(obj);
                        }
                    }
                    list2.addAll(arrayList);
                    if (mediaRepoData.getHasMore()) {
                        com.tencent.mobileqq.wink.picker.core.repository.h hVar = MemoryAlbumGenerator.localMediaRepository;
                        if (hVar != null) {
                            hVar.a(QAlbumCustomAlbumConstants.RECENT_ALBUM_ID, 1000, null);
                            return;
                        }
                        return;
                    }
                    w53.b.f(MemoryAlbumGenerator.f326501a.c(), "onQueryNextFinish resume size " + this.f326520b.size());
                    CancellableContinuation<List<LocalMediaInfo>> cancellableContinuation = this.f326519a;
                    Result.Companion companion = Result.INSTANCE;
                    cancellableContinuation.resumeWith(Result.m476constructorimpl(this.f326520b));
                    return;
                }
                CancellableContinuation<List<LocalMediaInfo>> cancellableContinuation2 = this.f326519a;
                Result.Companion companion2 = Result.INSTANCE;
                cancellableContinuation2.resumeWith(Result.m476constructorimpl(ResultKt.createFailure(new Throwable("query media list failed"))));
            }
        }
    }

    MemoryAlbumGenerator() {
    }

    private final void O() {
        BaseTimer baseTimer = new BaseTimer();
        timer = baseTimer;
        baseTimer.schedule(new TimerTask() { // from class: com.tencent.mobileqq.wink.templatelibrary.memoryalbum.MemoryAlbumGenerator$afterJobStart$1
            @Override // java.util.TimerTask, java.lang.Runnable
            public void run() {
                Job job;
                job = MemoryAlbumGenerator.startJob;
                if (job != null) {
                    job.cancel((CancellationException) TimeOutCancellation.INSTANCE);
                }
            }
        }, 60000L);
    }

    private final void P() {
        originPhotoMap.clear();
        memoryPhotoMap.clear();
        haveGenerated.set(false);
        isGenerating.set(false);
    }

    private final List<String> Q(List<String> photos, s53.a album) {
        int roundToInt;
        int max = Math.max(50, album.d().getMaxPhotoCnt());
        if (photos.size() <= max) {
            return photos;
        }
        ArrayList arrayList = new ArrayList();
        float size = photos.size() / max;
        for (int i3 = 0; i3 < max; i3++) {
            roundToInt = MathKt__MathJVMKt.roundToInt(i3 * size);
            arrayList.add(photos.get(roundToInt));
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object R(HashSet<String> hashSet, Continuation<? super List<Unit>> continuation) {
        return SupervisorKt.supervisorScope(new MemoryAlbumGenerator$faceDetectIn$2(hashSet, null), continuation);
    }

    private final boolean S(s53.a album) {
        List<String> n3 = album.n();
        if (n3.size() < album.d().getMinPhotoCnt()) {
            return false;
        }
        List<String> i06 = i0(n3);
        if (i06.size() < album.d().getMinPhotoCnt()) {
            return false;
        }
        List<String> Q = Q(i06, album);
        album.c();
        album.b(Q);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void T(s53.a album) {
        List<String> sortedWith;
        int collectionSizeOrDefault;
        String joinToString$default;
        String replace$default;
        String joinToString$default2;
        sortedWith = CollectionsKt___CollectionsKt.sortedWith(k0(album.n(), album.d().getMaxPhotoCnt()), new a());
        album.q(f0(sortedWith));
        album.p(X(album.getCoverPhotoId()));
        album.c();
        List<String> list = sortedWith;
        collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(list, 10);
        ArrayList arrayList = new ArrayList(collectionSizeOrDefault);
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            s53.b X = f326501a.X((String) it.next());
            Intrinsics.checkNotNull(X);
            arrayList.add(X);
        }
        album.a(arrayList);
        album.b(sortedWith);
        s53.b X2 = X(sortedWith.get(sortedWith.size() - 1));
        Intrinsics.checkNotNull(X2);
        album.t(X2.getTimestamp());
        List<String> list2 = sortedWith;
        joinToString$default = CollectionsKt___CollectionsKt.joinToString$default(list2, ",", null, null, 0, null, null, 62, null);
        String b16 = ak.f326673a.b(joinToString$default);
        album.s(album.getCom.tencent.mobileqq.wink.api.QQWinkConstants.STORY_ID java.lang.String() + b16);
        WinkMemoryAlbumConfig d16 = album.d();
        replace$default = StringsKt__StringsJVMKt.replace$default(album.d().getStoryName(), "%m", String.valueOf(Integer.parseInt(pa3.a.f425848a.a(album.getTimestamp(), "MM"))), false, 4, (Object) null);
        d16.m(replace$default);
        String c16 = c();
        String storyName = album.d().getStoryName();
        int size = sortedWith.size();
        joinToString$default2 = CollectionsKt___CollectionsKt.joinToString$default(list2, ",", null, null, 0, null, null, 62, null);
        w53.b.f(c16, "sortPhotoInAlbum end " + storyName + " size " + size + " " + joinToString$default2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object U(Continuation<? super Boolean> continuation) {
        return SupervisorKt.supervisorScope(new MemoryAlbumGenerator$generateAlbums$2(null), continuation);
    }

    private final long V(long timestamp, String format) {
        Date date = new Date(timestamp);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(format);
        String format2 = simpleDateFormat.format(date);
        Calendar calendar = Calendar.getInstance();
        try {
            calendar.setTime(simpleDateFormat.parse(format2));
        } catch (Exception e16) {
            e16.printStackTrace();
        }
        return calendar.getTimeInMillis();
    }

    private final boolean W() {
        if (!isGenerating.get() && !haveGenerated.get()) {
            return false;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final s53.b X(String item) {
        return memoryPhotoMap.get(item);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:14:0x00d0 A[LOOP:0: B:12:0x00ca->B:14:0x00d0, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:24:0x00c1 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:25:0x003b  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0024  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object Y(List<LocalMediaInfo> list, Continuation<? super Unit> continuation) {
        MemoryAlbumGenerator$handleMediaResult$1 memoryAlbumGenerator$handleMediaResult$1;
        Object obj;
        Object coroutine_suspended;
        int i3;
        if (continuation instanceof MemoryAlbumGenerator$handleMediaResult$1) {
            memoryAlbumGenerator$handleMediaResult$1 = (MemoryAlbumGenerator$handleMediaResult$1) continuation;
            int i16 = memoryAlbumGenerator$handleMediaResult$1.label;
            if ((i16 & Integer.MIN_VALUE) != 0) {
                memoryAlbumGenerator$handleMediaResult$1.label = i16 - Integer.MIN_VALUE;
                obj = memoryAlbumGenerator$handleMediaResult$1.result;
                coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i3 = memoryAlbumGenerator$handleMediaResult$1.label;
                if (i3 == 0) {
                    if (i3 != 1) {
                        if (i3 == 2) {
                            ResultKt.throwOnFailure(obj);
                            for (s53.b bVar : (List) obj) {
                                f326501a.m0(bVar);
                                bVar.z(originPhotoMap.get(bVar.getId()));
                            }
                            return Unit.INSTANCE;
                        }
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.throwOnFailure(obj);
                } else {
                    ResultKt.throwOnFailure(obj);
                    ArrayList arrayList = new ArrayList();
                    w53.b.f(c(), "queryDataList size " + list.size());
                    for (LocalMediaInfo localMediaInfo : list) {
                        s53.b bVar2 = new s53.b();
                        String str = localMediaInfo.path;
                        Intrinsics.checkNotNullExpressionValue(str, "it.path");
                        bVar2.A(str);
                        bVar2.B(localMediaInfo.modifiedDate * 1000);
                        bVar2.x(localMediaInfo.mMediaType);
                        bVar2.u((int) localMediaInfo.mDuration);
                        bVar2.D(localMediaInfo.mediaWidth);
                        bVar2.w(localMediaInfo.mediaHeight);
                        arrayList.add(bVar2);
                        originPhotoMap.put(bVar2.getId(), localMediaInfo);
                    }
                    WinkMemoryAlbumDBHelper winkMemoryAlbumDBHelper = WinkMemoryAlbumDBHelper.f318173a;
                    memoryAlbumGenerator$handleMediaResult$1.label = 1;
                    if (winkMemoryAlbumDBHelper.e(arrayList, memoryAlbumGenerator$handleMediaResult$1) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                }
                WinkMemoryAlbumDBHelper winkMemoryAlbumDBHelper2 = WinkMemoryAlbumDBHelper.f318173a;
                memoryAlbumGenerator$handleMediaResult$1.label = 2;
                obj = winkMemoryAlbumDBHelper2.a(memoryAlbumGenerator$handleMediaResult$1);
                if (obj == coroutine_suspended) {
                    return coroutine_suspended;
                }
                while (r11.hasNext()) {
                }
                return Unit.INSTANCE;
            }
        }
        memoryAlbumGenerator$handleMediaResult$1 = new MemoryAlbumGenerator$handleMediaResult$1(this, continuation);
        obj = memoryAlbumGenerator$handleMediaResult$1.result;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i3 = memoryAlbumGenerator$handleMediaResult$1.label;
        if (i3 == 0) {
        }
        WinkMemoryAlbumDBHelper winkMemoryAlbumDBHelper22 = WinkMemoryAlbumDBHelper.f318173a;
        memoryAlbumGenerator$handleMediaResult$1.label = 2;
        obj = winkMemoryAlbumDBHelper22.a(memoryAlbumGenerator$handleMediaResult$1);
        if (obj == coroutine_suspended) {
        }
        while (r11.hasNext()) {
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean Z(LocalMediaInfo mediaInfo) {
        boolean startsWith$default;
        e93.i.X(mediaInfo, d93.b.f393235a.a(mediaInfo, com.tencent.mobileqq.wink.picker.qcircle.c.f324971a.d()));
        if (QLog.isColorLevel()) {
            QLog.d(c(), 1, "isMediaValid, path:" + mediaInfo.path + ", validStatus:" + e93.i.x(mediaInfo));
        }
        String str = mediaInfo.path;
        Intrinsics.checkNotNullExpressionValue(str, "mediaInfo.path");
        String a16 = u53.g.a();
        Intrinsics.checkNotNullExpressionValue(a16, "getCameraPath()");
        startsWith$default = StringsKt__StringsJVMKt.startsWith$default(str, a16, false, 2, null);
        if (startsWith$default && e93.i.x(mediaInfo) == 0) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object a0(Continuation<? super Unit> continuation) {
        return BuildersKt.withContext(Dispatchers.getMain(), new MemoryAlbumGenerator$notifyProducedEnd$2(null), continuation);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void b0() {
        Job job;
        Timer timer2 = timer;
        if (timer2 != null) {
            timer2.cancel();
        }
        boolean z16 = false;
        haveGenerated.set(false);
        isGenerating.set(false);
        com.tencent.mobileqq.wink.picker.core.repository.h hVar = localMediaRepository;
        if (hVar != null) {
            hVar.j();
        }
        Job job2 = startJob;
        if (job2 != null && job2.isActive()) {
            z16 = true;
        }
        if (z16 && (job = startJob) != null) {
            job.cancel((CancellationException) ExitCancellation.INSTANCE);
        }
        BuildersKt__Builders_commonKt.launch$default(mainScope, null, null, new MemoryAlbumGenerator$onCancel$1(null), 3, null);
    }

    private final void c0(List<MetaCategory> it) {
        Job launch$default;
        launch$default = BuildersKt__Builders_commonKt.launch$default(fileScope, null, null, new MemoryAlbumGenerator$onMemoryAlbumConfigUpdate$1(it, null), 3, null);
        startJob = launch$default;
        O();
    }

    private final void d0(Map<String, ? extends LocalMediaInfo> mediaList2) {
        Integer num;
        Map<String, LocalMediaInfo> mutableMap;
        String c16 = c();
        if (mediaList2 != null) {
            num = Integer.valueOf(mediaList2.size());
        } else {
            num = null;
        }
        w53.b.a(c16, "onPrepareStart, mediaList:" + num);
        haveGenerated.set(false);
        isGenerating.set(true);
        if (mediaList2 != null) {
            mutableMap = MapsKt__MapsKt.toMutableMap(mediaList2);
            mediaList = mutableMap;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void e0(List it) {
        MemoryAlbumGenerator memoryAlbumGenerator = f326501a;
        w53.b.f(memoryAlbumGenerator.c(), "onStartProcess, memoryAlbumListLiveData update:" + it.size());
        Intrinsics.checkNotNullExpressionValue(it, "it");
        memoryAlbumGenerator.c0(it);
    }

    private final String f0(List<String> list) {
        Comparator comparator = new Comparator() { // from class: com.tencent.mobileqq.wink.templatelibrary.memoryalbum.c
            @Override // java.util.Comparator
            public final int compare(Object obj, Object obj2) {
                int g06;
                g06 = MemoryAlbumGenerator.g0((String) obj, (String) obj2);
                return g06;
            }
        };
        ArrayList arrayList = new ArrayList();
        arrayList.addAll(list);
        CollectionsKt__MutableCollectionsJVMKt.sortWith(arrayList, comparator);
        return (String) arrayList.get(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int g0(String s16, String s26) {
        boolean z16;
        boolean z17;
        MemoryAlbumGenerator memoryAlbumGenerator = f326501a;
        Intrinsics.checkNotNullExpressionValue(s16, "s1");
        s53.b X = memoryAlbumGenerator.X(s16);
        Intrinsics.checkNotNull(X);
        Intrinsics.checkNotNullExpressionValue(s26, "s2");
        s53.b X2 = memoryAlbumGenerator.X(s26);
        Intrinsics.checkNotNull(X2);
        if (X.getMediaType() == X2.getMediaType()) {
            if (X.getWidth() < X.getHeight()) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (X2.getWidth() < X2.getHeight()) {
                z17 = true;
            } else {
                z17 = false;
            }
            if (z16 == z17) {
                if (X.getHaveFace() == X2.getHaveFace()) {
                    if (X.getTimestamp() == X2.getTimestamp()) {
                        return 0;
                    }
                    if (X.getTimestamp() < X2.getTimestamp()) {
                        return -1;
                    }
                } else if (X2.getHaveFace() != 1) {
                    return -1;
                }
            } else if (z16 && !z17) {
                return -1;
            }
        } else if (X.getMediaType() <= X2.getMediaType()) {
            return -1;
        }
        return 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0063  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x00fd  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x0047  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0023  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:24:0x00c4 -> B:10:0x00c7). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object h0(List<s53.a> list, Continuation<? super Unit> continuation) {
        MemoryAlbumGenerator$queryAlbumsByConfig$1 memoryAlbumGenerator$queryAlbumsByConfig$1;
        Object coroutine_suspended;
        int i3;
        Iterator<Map.Entry<String, WinkMemoryAlbumConfig>> it;
        MemoryAlbumGenerator memoryAlbumGenerator;
        List<s53.a> list2;
        List list3;
        boolean z16;
        if (continuation instanceof MemoryAlbumGenerator$queryAlbumsByConfig$1) {
            memoryAlbumGenerator$queryAlbumsByConfig$1 = (MemoryAlbumGenerator$queryAlbumsByConfig$1) continuation;
            int i16 = memoryAlbumGenerator$queryAlbumsByConfig$1.label;
            if ((i16 & Integer.MIN_VALUE) != 0) {
                memoryAlbumGenerator$queryAlbumsByConfig$1.label = i16 - Integer.MIN_VALUE;
                Object obj = memoryAlbumGenerator$queryAlbumsByConfig$1.result;
                coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i3 = memoryAlbumGenerator$queryAlbumsByConfig$1.label;
                if (i3 == 0) {
                    if (i3 == 1) {
                        list3 = (List) memoryAlbumGenerator$queryAlbumsByConfig$1.L$4;
                        it = (Iterator) memoryAlbumGenerator$queryAlbumsByConfig$1.L$3;
                        List list4 = (List) memoryAlbumGenerator$queryAlbumsByConfig$1.L$2;
                        List<s53.a> list5 = (List) memoryAlbumGenerator$queryAlbumsByConfig$1.L$1;
                        memoryAlbumGenerator = (MemoryAlbumGenerator) memoryAlbumGenerator$queryAlbumsByConfig$1.L$0;
                        ResultKt.throwOnFailure(obj);
                        list3.addAll((Collection) obj);
                        list3 = list4;
                        list2 = list5;
                        while (it.hasNext()) {
                            Map.Entry<String, WinkMemoryAlbumConfig> next = it.next();
                            if (QLog.isColorLevel()) {
                                QLog.d(f326501a.c(), 1, "queryAlbumsByConfig, config:" + next.getValue().b());
                            }
                            if (next.getValue().getStorySQL().length() > 0) {
                                z16 = true;
                            } else {
                                z16 = false;
                            }
                            if (z16) {
                                WinkMemoryAlbumDBHelper winkMemoryAlbumDBHelper = WinkMemoryAlbumDBHelper.f318173a;
                                WinkMemoryAlbumConfig value = next.getValue();
                                memoryAlbumGenerator$queryAlbumsByConfig$1.L$0 = memoryAlbumGenerator;
                                memoryAlbumGenerator$queryAlbumsByConfig$1.L$1 = list2;
                                memoryAlbumGenerator$queryAlbumsByConfig$1.L$2 = list3;
                                memoryAlbumGenerator$queryAlbumsByConfig$1.L$3 = it;
                                memoryAlbumGenerator$queryAlbumsByConfig$1.L$4 = list3;
                                memoryAlbumGenerator$queryAlbumsByConfig$1.label = 1;
                                Object b16 = winkMemoryAlbumDBHelper.b(value, memoryAlbumGenerator$queryAlbumsByConfig$1);
                                if (b16 == coroutine_suspended) {
                                    return coroutine_suspended;
                                }
                                list5 = list2;
                                obj = b16;
                                list4 = list3;
                                list3.addAll((Collection) obj);
                                list3 = list4;
                                list2 = list5;
                                while (it.hasNext()) {
                                }
                            }
                        }
                        w53.b.f(memoryAlbumGenerator.c(), "generateAlbums filter before " + list3.size());
                        ArrayList arrayList = new ArrayList();
                        for (Object obj2 : list3) {
                            if (f326501a.S((s53.a) obj2)) {
                                arrayList.add(obj2);
                            }
                        }
                        list2.addAll(arrayList);
                        w53.b.f(memoryAlbumGenerator.c(), "generateAlbums filter after " + list2.size());
                        return Unit.INSTANCE;
                    }
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
                ArrayList arrayList2 = new ArrayList();
                it = configMap.entrySet().iterator();
                memoryAlbumGenerator = this;
                list2 = list;
                list3 = arrayList2;
                while (it.hasNext()) {
                }
                w53.b.f(memoryAlbumGenerator.c(), "generateAlbums filter before " + list3.size());
                ArrayList arrayList3 = new ArrayList();
                while (r12.hasNext()) {
                }
                list2.addAll(arrayList3);
                w53.b.f(memoryAlbumGenerator.c(), "generateAlbums filter after " + list2.size());
                return Unit.INSTANCE;
            }
        }
        memoryAlbumGenerator$queryAlbumsByConfig$1 = new MemoryAlbumGenerator$queryAlbumsByConfig$1(this, continuation);
        Object obj3 = memoryAlbumGenerator$queryAlbumsByConfig$1.result;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i3 = memoryAlbumGenerator$queryAlbumsByConfig$1.label;
        if (i3 == 0) {
        }
    }

    private final List<String> i0(List<String> photos) {
        List<String> sortedWith;
        sortedWith = CollectionsKt___CollectionsKt.sortedWith(photos, new b());
        ArrayList arrayList = new ArrayList();
        long j3 = Long.MAX_VALUE;
        for (String str : sortedWith) {
            s53.b X = X(str);
            Intrinsics.checkNotNull(X);
            if (j3 - X.getTimestamp() > 60000) {
                s53.b X2 = X(str);
                Intrinsics.checkNotNull(X2);
                j3 = X2.getTimestamp();
                arrayList.add(str);
            }
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void j0(long cost) {
        String str;
        Map<String, String> map = dengTaParams;
        map.put(WinkDengtaReportConstant.Params.REPORT_PARMA_MEMORY_ALBUM_LOAD_ALL_TIME, String.valueOf(cost));
        ar arVar = ar.f326685a;
        if (arVar.c(WinkDengtaReportConstant.Params.REPORT_PARMA_MEMORY_ALBUM_HAS_LOAD, false)) {
            str = "1";
        } else {
            str = "0";
        }
        map.put(WinkDengtaReportConstant.Params.REPORT_PARMA_MEMORY_ALBUM_HAS_LOAD, str);
        com.tencent.mobileqq.wink.report.e.o(com.tencent.mobileqq.wink.report.e.f326265a, WinkDengtaReportConstant.Action.PERFORMANCE_MEMORY_ALBUM_LOAD_TIME, map, false, 4, null);
        arVar.m(WinkDengtaReportConstant.Params.REPORT_PARMA_MEMORY_ALBUM_HAS_LOAD, true);
    }

    private final List<String> k0(List<String> photos, int count) {
        int collectionSizeOrDefault;
        if (photos.size() < count) {
            return photos;
        }
        int size = photos.size() / 5;
        ArrayList arrayList = new ArrayList();
        for (int i3 = 0; i3 < 5; i3++) {
            arrayList.add(new ArrayList());
        }
        Iterator<T> it = photos.iterator();
        int i16 = 0;
        while (true) {
            int i17 = 4;
            if (!it.hasNext()) {
                break;
            }
            Object next = it.next();
            int i18 = i16 + 1;
            if (i16 < 0) {
                CollectionsKt__CollectionsKt.throwIndexOverflow();
            }
            String str = (String) next;
            int i19 = i16 / size;
            if (i19 < 5) {
                i17 = i19;
            }
            ((List) arrayList.get(i17)).add(str);
            i16 = i18;
        }
        collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(arrayList, 10);
        ArrayList arrayList2 = new ArrayList(collectionSizeOrDefault);
        Iterator it5 = arrayList.iterator();
        while (it5.hasNext()) {
            arrayList2.add(f326501a.q0((List) it5.next()));
        }
        ArrayList arrayList3 = new ArrayList();
        int i26 = count / 5;
        for (int i27 = 0; i27 < count; i27++) {
            int i28 = i27 / i26;
            if (i28 >= 5) {
                i28 = 4;
            }
            arrayList3.add(((List) arrayList2.get(i28)).get(i27 % i26));
        }
        return arrayList3;
    }

    private final void m0(s53.b it) {
        memoryPhotoMap.put(it.getId(), it);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void n0(List<s53.a> albums) {
        Unit unit;
        long timestamp;
        for (s53.a aVar : albums) {
            MemoryAlbumGenerator memoryAlbumGenerator = f326501a;
            s53.b X = memoryAlbumGenerator.X(aVar.n().get(aVar.n().size() - 1));
            if (X != null) {
                aVar.t(memoryAlbumGenerator.V(X.getTimestamp(), "yyyy\u5e74MM\u6708dd\u65e5"));
                if (aVar.d().getUseTodayAsTriggerTime()) {
                    timestamp = memoryAlbumGenerator.V(Calendar.getInstance().getTimeInMillis(), "yyyy\u5e74MM\u6708dd\u65e5");
                } else {
                    timestamp = aVar.getTimestamp();
                }
                aVar.u(timestamp);
                unit = Unit.INSTANCE;
            } else {
                unit = null;
            }
            if (unit == null) {
                aVar.t(0L);
            }
        }
        CollectionsKt__MutableCollectionsJVMKt.sortWith(albums, new Comparator() { // from class: com.tencent.mobileqq.wink.templatelibrary.memoryalbum.b
            @Override // java.util.Comparator
            public final int compare(Object obj, Object obj2) {
                int o06;
                o06 = MemoryAlbumGenerator.o0((s53.a) obj, (s53.a) obj2);
                return o06;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int o0(s53.a aVar, s53.a aVar2) {
        if (aVar.getTriggerTimestamp() == aVar2.getTriggerTimestamp()) {
            if (aVar.d().getPriorityIndex() == aVar2.d().getPriorityIndex()) {
                if (aVar.getTimestamp() <= aVar2.getTimestamp()) {
                    if (aVar.getTimestamp() < aVar2.getTimestamp()) {
                        return 1;
                    }
                    return 0;
                }
            } else if (aVar.d().getPriorityIndex() <= aVar2.d().getPriorityIndex()) {
                if (aVar.d().getPriorityIndex() < aVar2.d().getPriorityIndex()) {
                    return 1;
                }
                return 0;
            }
        } else if (aVar.getTriggerTimestamp() < aVar2.getTriggerTimestamp()) {
            return 1;
        }
        return -1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object p0(List<s53.a> list, long j3, Continuation<? super Unit> continuation) {
        Object coroutine_suspended;
        Object coroutineScope = CoroutineScopeKt.coroutineScope(new MemoryAlbumGenerator$sortPhotoInAlbums$2(list, j3, null), continuation);
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (coroutineScope == coroutine_suspended) {
            return coroutineScope;
        }
        return Unit.INSTANCE;
    }

    private final List<String> q0(List<String> photos) {
        List<String> sortedWith;
        sortedWith = CollectionsKt___CollectionsKt.sortedWith(photos, new d(new f(new e(new c()))));
        return sortedWith;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object r0(List<LocalMediaInfo> list, Continuation<? super Boolean> continuation) {
        return SupervisorKt.supervisorScope(new MemoryAlbumGenerator$startHandleMediaList$2(list, null), continuation);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void s0(ArrayList<MetaMaterial> materials) {
        configMap.clear();
        for (MetaMaterial metaMaterial : materials) {
            WinkMemoryAlbumConfig winkMemoryAlbumConfig = new WinkMemoryAlbumConfig(metaMaterial);
            HashMap<String, WinkMemoryAlbumConfig> hashMap = configMap;
            String str = metaMaterial.f30533id;
            Intrinsics.checkNotNullExpressionValue(str, "it.id");
            hashMap.put(str, winkMemoryAlbumConfig);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object t0(Continuation<? super List<LocalMediaInfo>> continuation) {
        Continuation intercepted;
        Object coroutine_suspended;
        List mutableList;
        intercepted = IntrinsicsKt__IntrinsicsJvmKt.intercepted(continuation);
        CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(intercepted, 1);
        cancellableContinuationImpl.initCancellability();
        if (!mediaList.isEmpty()) {
            Result.Companion companion = Result.INSTANCE;
            mutableList = CollectionsKt___CollectionsKt.toMutableList(mediaList.values());
            cancellableContinuationImpl.resumeWith(Result.m476constructorimpl(mutableList));
        } else {
            ArrayList arrayList = new ArrayList();
            localMediaRepository = new com.tencent.mobileqq.wink.picker.core.repository.h(MediaType.LOCAL_ALL, com.tencent.mobileqq.wink.picker.qcircle.c.f324971a.c());
            com.tencent.mobileqq.wink.picker.core.repository.h hVar = localMediaRepository;
            if (hVar != null) {
                hVar.mediaQueryListener = new g(cancellableContinuationImpl, arrayList);
            }
            com.tencent.mobileqq.wink.picker.core.repository.h hVar2 = localMediaRepository;
            if (hVar2 != null) {
                hVar2.a(QAlbumCustomAlbumConstants.RECENT_ALBUM_ID, 1000, null);
            }
        }
        Object result = cancellableContinuationImpl.getResult();
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (result == coroutine_suspended) {
            DebugProbes.probeCoroutineSuspended(continuation);
        }
        return result;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object u0(List<s53.a> list, Continuation<? super Unit> continuation) {
        return BuildersKt.withContext(Dispatchers.getMain(), new MemoryAlbumGenerator$updateAllData$2(list, null), continuation);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object v0(List<s53.a> list, Continuation<? super Unit> continuation) {
        return BuildersKt.withContext(Dispatchers.getMain(), new MemoryAlbumGenerator$updatePreloadData$2(list, null), continuation);
    }

    @Override // x83.a
    @NotNull
    public String c() {
        return TAG;
    }

    @Override // x83.a
    public boolean d() {
        w83.b bVar = w83.b.f445025a;
        if (!bVar.O()) {
            QLog.d(c(), 1, "isExtraSwitchOpen, isMemoryAlbumOpen is false ");
            return false;
        }
        if (!bVar.K()) {
            return true;
        }
        QLog.d(c(), 1, "isExtraSwitchOpen, isHitExpC is true ");
        return false;
    }

    @Override // x83.a
    public void f() {
        Job job;
        boolean z16 = true;
        QLog.d(c(), 1, "onDestroyProcess ");
        dataConsumer = null;
        Timer timer2 = timer;
        if (timer2 != null) {
            timer2.cancel();
        }
        P();
        com.tencent.mobileqq.wink.picker.core.repository.h hVar = localMediaRepository;
        if (hVar != null) {
            hVar.j();
        }
        Job job2 = startJob;
        if (job2 == null || !job2.isActive()) {
            z16 = false;
        }
        if (z16 && (job = startJob) != null) {
            job.cancel((CancellationException) ExitCancellation.INSTANCE);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // x83.a
    public void h() {
        super.h();
        BuildersKt__Builders_commonKt.launch$default(mainScope, null, null, new MemoryAlbumGenerator$onStartSwitchClose$1(null), 3, null);
    }

    @Override // x83.b
    public boolean j(@Nullable Map<String, ? extends LocalMediaInfo> mediaList2) {
        Integer num;
        String c16 = c();
        if (mediaList2 != null) {
            num = Integer.valueOf(mediaList2.size());
        } else {
            num = null;
        }
        QLog.d(c16, 1, "onStartProcess, media size:" + num);
        if (W()) {
            w53.b.f(c(), "onStartProcess, getIsMemoryAlbumGenerated is true ");
            return false;
        }
        d0(mediaList2);
        MutableLiveData<List<MetaCategory>> l16 = WinkEditorResourceManager.a1().l1();
        Intrinsics.checkNotNullExpressionValue(l16, "getInstance().memoryAlbumListLiveData");
        LiveDataExtKt.b(l16, new Observer() { // from class: com.tencent.mobileqq.wink.templatelibrary.memoryalbum.a
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                MemoryAlbumGenerator.e0((List) obj);
            }
        });
        if (!NetworkUtil.isNetworkAvailable()) {
            WinkEditorResourceManager.a1().b3();
            return true;
        }
        BusinessHandler businessHandler = com.tencent.mobileqq.wink.b.a().getBusinessHandler(WinkRecommendDataServiceHandler.class.getName());
        Intrinsics.checkNotNull(businessHandler, "null cannot be cast to non-null type com.tencent.mobileqq.wink.launcher.network.WinkRecommendDataServiceHandler");
        ((WinkRecommendDataServiceHandler) businessHandler).m3("XsjRemberTemplate");
        return true;
    }

    public final void l0(@Nullable com.tencent.mobileqq.wink.newalbum.director.datasource.a<s53.a> dataConsumer2) {
        dataConsumer = dataConsumer2;
    }
}

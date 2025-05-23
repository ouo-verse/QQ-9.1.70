package com.tencent.filament.zplan.business.impl;

import al0.a;
import android.os.Build;
import android.os.Looper;
import cl0.c;
import cl0.f;
import com.google.gson.Gson;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.filament.zplan.animation.ZPlanAction;
import com.tencent.filament.zplan.avatar.AvatarCheckResult;
import com.tencent.filament.zplan.avatar.BusinessSceneConfig;
import com.tencent.filament.zplan.avatar.CameraParams;
import com.tencent.filament.zplan.avatar.Directional;
import com.tencent.filament.zplan.avatar.IndirectLight;
import com.tencent.filament.zplan.avatar.LightsParams;
import com.tencent.filament.zplan.avatar.ZPlanAvatarResourceHelper;
import com.tencent.filament.zplan.avatar.model.BootResourceModel;
import com.tencent.filament.zplan.avatar.model.EnumUserGender;
import com.tencent.filament.zplan.avatar.model.ReloadAvatarResourceModel;
import com.tencent.filament.zplan.business.api.IBusinessScene;
import com.tencent.filament.zplan.business.api.SceneType;
import com.tencent.filament.zplan.business.api.b;
import com.tencent.filament.zplan.business.impl.AbsBusinessScene;
import com.tencent.filament.zplan.data.FetchActionData;
import com.tencent.filament.zplan.engine.FilamentViewerV2;
import com.tencent.filament.zplan.engine.js.FilamentEventDispatcher;
import com.tencent.filament.zplanservice.download.FetchBootResourcesOptions;
import com.tencent.filament.zplanservice.download.ZPlanAvatarCheckResult;
import com.tencent.filament.zplanservice.download.ZPlanAvatarInterfaceResult;
import com.tencent.filament.zplanservice.download.ZPlanAvatarMask;
import com.tencent.filament.zplanservice.download.ZPlanAvatarService;
import com.tencent.filament.zplanservice.download.ZPlanAvatarServiceException;
import com.tencent.filament.zplanservice.feature.FilamentFeatureUtil;
import com.tencent.filament.zplanservice.feature.model.FilamentUrlTemplate;
import com.tencent.filament.zplanservice.util.log.FLog;
import com.tencent.filament.zplanservice.verify.FilamentVerificationHelper;
import com.tencent.filament.zplanservice.verify.ResourceCheckAlgorithmSelect;
import com.tencent.filament.zplanservice.verify.ResourceCheckCode;
import com.tencent.filament.zplanservice.verify.ResourceCheckResult;
import com.tencent.map.geolocation.TencentLocation;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.qqmini.sdk.launcher.MiniSDKConst;
import com.tencent.zplan.zplantracing.ZPlanSpanFactory;
import dl0.k;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.ArraysKt___ArraysKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.coroutines.AbstractCoroutineContextElement;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CompletableJob;
import kotlinx.coroutines.CoroutineExceptionHandler;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.GlobalScope;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.JobKt;
import kotlinx.coroutines.SupervisorKt;
import org.apache.httpcore.message.TokenParser;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import tl.h;
import wx4.d;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u009a\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0006\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u001d\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\b&\u0018\u0000 \u00b6\u00012\u00020\u0001:\u0006\u00b7\u0001\u00b8\u0001\u00b9\u0001B\t\u00a2\u0006\u0006\b\u00b4\u0001\u0010\u00b5\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J/\u0010\f\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0006\u0010\b\u001a\u00020\u00022\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\n0\tH\u0002\u00a2\u0006\u0004\b\f\u0010\rJ\u0016\u0010\u0011\u001a\u00020\u00042\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000eH\u0002J\u0012\u0010\u0014\u001a\u00020\u00132\b\u0010\u0012\u001a\u0004\u0018\u00010\u0002H\u0002J$\u0010\u001a\u001a\u00020\u00042\u0006\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0018\u001a\u00020\u00172\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u0006H\u0002J$\u0010\u001b\u001a\u00020\u00042\u0006\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0018\u001a\u00020\u00172\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u0006H\u0002J\u001c\u0010\u001f\u001a\u0004\u0018\u00010\u001e2\u0006\u0010\u001d\u001a\u00020\u001c2\b\u0010\u0019\u001a\u0004\u0018\u00010\u0006H\u0016J\u001d\u0010 \u001a\u00020\u00042\b\u0010\u0019\u001a\u0004\u0018\u00010\u0006H\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0004\b \u0010!J\u0013\u0010\"\u001a\u00020\u0004H\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\"\u0010#J$\u0010&\u001a\u00020\u00042\u0006\u0010$\u001a\u00020\u00022\b\u0010%\u001a\u0004\u0018\u00010\u00022\b\u0010\u0019\u001a\u0004\u0018\u00010\u0006H\u0016J\u001f\u0010'\u001a\u00020\u00042\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u0006H\u0082@\u00f8\u0001\u0000\u00a2\u0006\u0004\b'\u0010!J\b\u0010(\u001a\u00020\u0004H\u0016J\u0013\u0010)\u001a\u00020\u0004H\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0004\b)\u0010#J\u0012\u0010,\u001a\u00020\u00042\b\u0010+\u001a\u0004\u0018\u00010*H\u0016J\u0012\u0010/\u001a\u00020\u00042\b\u0010.\u001a\u0004\u0018\u00010-H\u0016J\u0012\u00102\u001a\u00020\u00042\b\u00101\u001a\u0004\u0018\u000100H\u0016J\u0010\u00105\u001a\u00020\u00042\u0006\u00104\u001a\u000203H\u0016J\b\u00107\u001a\u000206H\u0016J\b\u00108\u001a\u000206H\u0016J\b\u00109\u001a\u000206H\u0016J\n\u0010:\u001a\u0004\u0018\u00010\u0017H\u0016J\u001c\u0010=\u001a\u00020\u00042\u0006\u0010;\u001a\u00020\u00022\f\u0010.\u001a\b\u0012\u0004\u0012\u00020\u00040<J%\u0010>\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0018\u001a\u00020\u0017H\u0082@\u00f8\u0001\u0000\u00a2\u0006\u0004\b>\u0010?J/\u0010C\u001a\u0004\u0018\u00010B2\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0006\u0010A\u001a\u00020@2\u0006\u0010\u0018\u001a\u00020\u0017H\u0082@\u00f8\u0001\u0000\u00a2\u0006\u0004\bC\u0010DJ%\u0010E\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0018\u001a\u00020\u0017H\u0082@\u00f8\u0001\u0000\u00a2\u0006\u0004\bE\u0010?J\u001b\u0010G\u001a\u00020F2\u0006\u0010A\u001a\u00020@H\u0082@\u00f8\u0001\u0000\u00a2\u0006\u0004\bG\u0010HJ\u001b\u0010I\u001a\u00020F2\u0006\u0010A\u001a\u00020@H\u0082@\u00f8\u0001\u0000\u00a2\u0006\u0004\bI\u0010HJ)\u0010L\u001a\u000e\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020K0J2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0082@\u00f8\u0001\u0000\u00a2\u0006\u0004\bL\u0010!J#\u0010M\u001a\u00020F2\u0006\u0010A\u001a\u00020@2\u0006\u0010\u0018\u001a\u00020\u0017H\u0082@\u00f8\u0001\u0000\u00a2\u0006\u0004\bM\u0010NJ1\u0010O\u001a\u000e\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u00150J2\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0018\u001a\u00020\u0017H\u0082@\u00f8\u0001\u0000\u00a2\u0006\u0004\bO\u0010?J+\u0010T\u001a\u00020\n2\u0006\u0010A\u001a\u00020@2\u0006\u0010Q\u001a\u00020P2\u0006\u0010S\u001a\u00020RH\u0082@\u00f8\u0001\u0000\u00a2\u0006\u0004\bT\u0010UJ)\u0010V\u001a\b\u0012\u0004\u0012\u00020\n0\t2\u0006\u0010A\u001a\u00020@2\u0006\u0010Q\u001a\u00020PH\u0082@\u00f8\u0001\u0000\u00a2\u0006\u0004\bV\u0010WJ7\u0010X\u001a\u0014\u0012\u0004\u0012\u00020\u0013\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\t0J2\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0006\u0010Q\u001a\u00020PH\u0082@\u00f8\u0001\u0000\u00a2\u0006\u0004\bX\u0010YJ-\u0010[\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010K\u0012\u0004\u0012\u00020Z0J2\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u0006H\u0082@\u00f8\u0001\u0000\u00a2\u0006\u0004\b[\u0010!J5\u0010\\\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u0015\u0012\u0004\u0012\u00020Z0J2\u0006\u0010\u0018\u001a\u00020\u00172\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u0006H\u0082@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\\\u0010]J;\u0010^\u001a\u0016\u0012\f\u0012\n\u0012\u0004\u0012\u00020\n\u0018\u00010\t\u0012\u0004\u0012\u00020Z0J2\u0006\u0010Q\u001a\u00020P2\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u0006H\u0082@\u00f8\u0001\u0000\u00a2\u0006\u0004\b^\u0010_J\b\u0010a\u001a\u00020`H\u0016J\u001b\u0010d\u001a\u00020\u00172\u0006\u0010c\u001a\u00020bH\u00a6@\u00f8\u0001\u0000\u00a2\u0006\u0004\bd\u0010eJ)\u0010f\u001a\u00020\u00042\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\n0\t2\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u0006H&\u00a2\u0006\u0004\bf\u0010gJ\u0014\u0010j\u001a\u0004\u0018\u00010i2\b\u0010h\u001a\u0004\u0018\u00010\u0002H&J\u001f\u0010l\u001a\n\u0012\u0004\u0012\u00020k\u0018\u00010\t2\u0006\u0010Q\u001a\u00020PH&\u00a2\u0006\u0004\bl\u0010mJ\b\u0010n\u001a\u00020\u0002H&J\n\u0010p\u001a\u0004\u0018\u00010oH&J\b\u0010q\u001a\u000206H&J\b\u0010r\u001a\u000206H\u0016J\b\u0010s\u001a\u000206H\u0016J\b\u0010t\u001a\u000206H\u0016J\b\u0010u\u001a\u000206H\u0016R$\u0010+\u001a\u0004\u0018\u00010*8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b+\u0010v\u001a\u0004\bw\u0010x\"\u0004\by\u0010zR%\u0010{\u001a\u0004\u0018\u00010-8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0013\n\u0004\b{\u0010|\u001a\u0004\b}\u0010~\"\u0005\b\u007f\u0010\u0080\u0001R+\u0010\u0081\u0001\u001a\u0004\u0018\u0001008\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0018\n\u0006\b\u0081\u0001\u0010\u0082\u0001\u001a\u0006\b\u0083\u0001\u0010\u0084\u0001\"\u0006\b\u0085\u0001\u0010\u0086\u0001R+\u0010\u0087\u0001\u001a\u0004\u0018\u0001038\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0018\n\u0006\b\u0087\u0001\u0010\u0088\u0001\u001a\u0006\b\u0089\u0001\u0010\u008a\u0001\"\u0006\b\u008b\u0001\u0010\u008c\u0001R\u001d\u0010\u008e\u0001\u001a\u00030\u008d\u00018\u0006\u00a2\u0006\u0010\n\u0006\b\u008e\u0001\u0010\u008f\u0001\u001a\u0006\b\u0090\u0001\u0010\u0091\u0001R\u001d\u0010\u0093\u0001\u001a\u00030\u0092\u00018\u0006\u00a2\u0006\u0010\n\u0006\b\u0093\u0001\u0010\u0094\u0001\u001a\u0006\b\u0095\u0001\u0010\u0096\u0001R)\u0010h\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0017\n\u0005\bh\u0010\u0097\u0001\u001a\u0006\b\u0098\u0001\u0010\u0099\u0001\"\u0006\b\u009a\u0001\u0010\u009b\u0001R\u001c\u0010\u009d\u0001\u001a\u0005\u0018\u00010\u009c\u00018\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u009d\u0001\u0010\u009e\u0001R\u0019\u0010\u009f\u0001\u001a\u0002068\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u009f\u0001\u0010\u00a0\u0001R\u0018\u0010\u00a2\u0001\u001a\u00030\u00a1\u00018\u0002X\u0082\u0004\u00a2\u0006\b\n\u0006\b\u00a2\u0001\u0010\u00a3\u0001R\u0017\u0010\u00a4\u0001\u001a\u0002068\u0002X\u0082\u0004\u00a2\u0006\b\n\u0006\b\u00a4\u0001\u0010\u00a0\u0001R\u0018\u0010\u00a6\u0001\u001a\u00030\u00a5\u00018\u0002X\u0082\u0004\u00a2\u0006\b\n\u0006\b\u00a6\u0001\u0010\u00a7\u0001R!\u0010\u00a8\u0001\u001a\u0004\u0018\u00010@8\u0004X\u0084\u0004\u00a2\u0006\u0010\n\u0006\b\u00a8\u0001\u0010\u00a9\u0001\u001a\u0006\b\u00aa\u0001\u0010\u00ab\u0001R\u0018\u0010\u00ad\u0001\u001a\u00030\u00ac\u00018\u0002X\u0082\u0004\u00a2\u0006\b\n\u0006\b\u00ad\u0001\u0010\u00ae\u0001R \u0010\u00b0\u0001\u001a\u00030\u00af\u00018\u0004X\u0084\u0004\u00a2\u0006\u0010\n\u0006\b\u00b0\u0001\u0010\u00b1\u0001\u001a\u0006\b\u00b2\u0001\u0010\u00b3\u0001\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u00ba\u0001"}, d2 = {"Lcom/tencent/filament/zplan/business/impl/AbsBusinessScene;", "Lcom/tencent/filament/zplan/business/api/IBusinessScene;", "", "indirectLightPath", "", "setCameraAndLight", "Lcom/tencent/zplan/zplantracing/c;", "spanContext", "avatarString", "", "Lcom/tencent/filament/zplan/animation/ZPlanAction;", "actionArray", "loadAvatarAndAnim", "(Lcom/tencent/zplan/zplantracing/c;Ljava/lang/String;[Lcom/tencent/filament/zplan/animation/ZPlanAction;)V", "", "Lcom/tencent/filament/zplanservice/download/ZPlanAvatarCheckResult;", "checkResultList", "reportCppCheckResult", "shaderDir", "Lcom/tencent/filament/zplan/avatar/AvatarCheckResult;", "checkShader", "Lcom/tencent/filament/zplan/avatar/model/ReloadAvatarResourceModel;", "avatarResource", "Lorg/json/JSONObject;", "avatarInfo", "zplanSpanContext", "reloadAvatar", "updateAvatarAssetsAndReloadAvatar", "", "now", "Lcom/tencent/filament/zplan/business/api/a;", "animate", "onLaunch", "(Lcom/tencent/zplan/zplantracing/c;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", MiniSDKConst.NOTIFY_EVENT_ONPAUSE, "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "event", "eventData", "processDispatchEvent", "onCostumeChange", "onFirstRenderEnd", "onTerminate", "Lcom/tencent/filament/zplan/engine/js/FilamentEventDispatcher;", "dispatcher", "setEventDispatcher", "Lcom/tencent/filament/zplan/business/api/b;", "task", "setExecuteFunk", "Lcom/tencent/filament/zplan/engine/FilamentViewerV2;", "viewer", "setViewer", "Lcom/tencent/filament/zplan/business/api/c;", "listener", "setReloadAvatarListener", "", "canRender", "needRecordFirstFrame", "launchOnIOThread", "getAvatarMask", "funName", "Lkotlin/Function0;", "doTask", "loadAvatarResource", "(Lcom/tencent/zplan/zplantracing/c;Lorg/json/JSONObject;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lcom/tencent/filament/zplanservice/download/ZPlanAvatarService;", "avatarService", "Lcom/tencent/filament/zplan/business/impl/a;", "fetchAvatarResourceWithCpp", "(Lcom/tencent/zplan/zplantracing/c;Lcom/tencent/filament/zplanservice/download/ZPlanAvatarService;Lorg/json/JSONObject;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "innerLoadAvatarResource", "Lcom/tencent/filament/zplanservice/download/ZPlanAvatarInterfaceResult;", "fetchIndirectLightWithCpp", "(Lcom/tencent/filament/zplanservice/download/ZPlanAvatarService;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "fetchBootWithCpp", "Lkotlin/Pair;", "Lcom/tencent/filament/zplan/avatar/model/BootResourceModel;", "executeBoot", "fetchAvatarWithCpp", "(Lcom/tencent/filament/zplanservice/download/ZPlanAvatarService;Lorg/json/JSONObject;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "fetchAvatar", "Lcom/tencent/filament/zplan/avatar/model/EnumUserGender;", "gender", "", "actionId", "fetchIdActionWithCpp", "(Lcom/tencent/filament/zplanservice/download/ZPlanAvatarService;Lcom/tencent/filament/zplan/avatar/model/EnumUserGender;JLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "fetchActionArrayWithCpp", "(Lcom/tencent/filament/zplanservice/download/ZPlanAvatarService;Lcom/tencent/filament/zplan/avatar/model/EnumUserGender;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "fetchAction", "(Lcom/tencent/zplan/zplantracing/c;Lcom/tencent/filament/zplan/avatar/model/EnumUserGender;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lal0/a;", "fetchBootResourceWithStatistic", "fetchReloadAvatarResourceWithStatistic", "(Lorg/json/JSONObject;Lcom/tencent/zplan/zplantracing/c;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "fetchActionWithStatistic", "(Lcom/tencent/filament/zplan/avatar/model/EnumUserGender;Lcom/tencent/zplan/zplantracing/c;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lcom/tencent/filament/zplan/business/api/SceneType;", "getSceneType", "Lcom/tencent/filament/zplan/business/impl/AbsBusinessScene$FetchAvatarInfoFrom;", "from", "fetchAvatarInfo", "(Lcom/tencent/filament/zplan/business/impl/AbsBusinessScene$FetchAvatarInfoFrom;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "loadAnimation", "([Lcom/tencent/filament/zplan/animation/ZPlanAction;Lcom/tencent/zplan/zplantracing/c;)V", "bodyTypeName", "Lcom/tencent/filament/zplan/avatar/CameraParams;", "getBodyTypeCamera", "Lcom/tencent/filament/zplan/data/FetchActionData;", "getActionDataArray", "(Lcom/tencent/filament/zplan/avatar/model/EnumUserGender;)[Lcom/tencent/filament/zplan/data/FetchActionData;", "getSceneConfig", "Lcom/tencent/filament/zplan/avatar/LightsParams;", "getLightConfigAfterThemeChange", "needApplyShoesHeight", "enablePlanarReflection", "enablePlanarShadow", "enablePelvisOffset", "disableGlassesMetallic", "Lcom/tencent/filament/zplan/engine/js/FilamentEventDispatcher;", "getDispatcher", "()Lcom/tencent/filament/zplan/engine/js/FilamentEventDispatcher;", "setDispatcher", "(Lcom/tencent/filament/zplan/engine/js/FilamentEventDispatcher;)V", "exeTask", "Lcom/tencent/filament/zplan/business/api/b;", "getExeTask", "()Lcom/tencent/filament/zplan/business/api/b;", "setExeTask", "(Lcom/tencent/filament/zplan/business/api/b;)V", "viewerV2", "Lcom/tencent/filament/zplan/engine/FilamentViewerV2;", "getViewerV2", "()Lcom/tencent/filament/zplan/engine/FilamentViewerV2;", "setViewerV2", "(Lcom/tencent/filament/zplan/engine/FilamentViewerV2;)V", "reloadAvatarCompleteListener", "Lcom/tencent/filament/zplan/business/api/c;", "getReloadAvatarCompleteListener", "()Lcom/tencent/filament/zplan/business/api/c;", "setReloadAvatarCompleteListener", "(Lcom/tencent/filament/zplan/business/api/c;)V", "Ljava/util/concurrent/atomic/AtomicBoolean;", "firstRenderEnd", "Ljava/util/concurrent/atomic/AtomicBoolean;", "getFirstRenderEnd", "()Ljava/util/concurrent/atomic/AtomicBoolean;", "Lcom/tencent/filament/zplanservice/feature/model/FilamentUrlTemplate;", "urlTemplate", "Lcom/tencent/filament/zplanservice/feature/model/FilamentUrlTemplate;", "getUrlTemplate", "()Lcom/tencent/filament/zplanservice/feature/model/FilamentUrlTemplate;", "Ljava/lang/String;", "getBodyTypeName", "()Ljava/lang/String;", "setBodyTypeName", "(Ljava/lang/String;)V", "Lcom/tencent/filament/zplan/business/impl/AbsBusinessScene$Booter;", "booter", "Lcom/tencent/filament/zplan/business/impl/AbsBusinessScene$Booter;", "booted", "Z", "Lcl0/f;", "checkConfig", "Lcl0/f;", "enableCppDownload", "Lcl0/c;", "cppDownloadConfig", "Lcl0/c;", "service", "Lcom/tencent/filament/zplanservice/download/ZPlanAvatarService;", "getService", "()Lcom/tencent/filament/zplanservice/download/ZPlanAvatarService;", "Lkotlinx/coroutines/CompletableJob;", "job", "Lkotlinx/coroutines/CompletableJob;", "Lkotlinx/coroutines/CoroutineScope;", "scope", "Lkotlinx/coroutines/CoroutineScope;", "getScope", "()Lkotlinx/coroutines/CoroutineScope;", "<init>", "()V", "Companion", "Booter", "b", "FetchAvatarInfoFrom", "zplan-android_release"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes6.dex */
public abstract class AbsBusinessScene implements IBusinessScene {

    @NotNull
    public static final String TAG = "FilamentNativeApp_AbsBusinessScene";

    @Nullable
    private String bodyTypeName;
    private boolean booted;
    private Booter booter;
    private final f checkConfig;
    private final c cppDownloadConfig;

    @Nullable
    private FilamentEventDispatcher dispatcher;
    private final boolean enableCppDownload;

    @Nullable
    private b exeTask;

    @NotNull
    private final AtomicBoolean firstRenderEnd = new AtomicBoolean(false);
    private final CompletableJob job;

    @Nullable
    private com.tencent.filament.zplan.business.api.c reloadAvatarCompleteListener;

    @NotNull
    private final CoroutineScope scope;

    @Nullable
    private final ZPlanAvatarService service;

    @NotNull
    private final FilamentUrlTemplate urlTemplate;

    @Nullable
    private FilamentViewerV2 viewerV2;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\b\b\u0000\u0018\u00002\u00060\u0001j\u0002`\u0002B_\u0012\u0006\u0010\u000f\u001a\u00020\u000b\u0012\u0006\u0010\u0015\u001a\u00020\u0010\u0012\b\u0010\u001b\u001a\u0004\u0018\u00010\u0016\u0012\b\u0010!\u001a\u0004\u0018\u00010\u001c\u0012\u0006\u0010'\u001a\u00020\"\u0012\u0006\u0010*\u001a\u00020\"\u0012\u0006\u0010-\u001a\u00020\"\u0012\u0006\u00100\u001a\u00020\"\u0012\u0006\u00103\u001a\u00020\"\u0012\n\b\u0002\u00109\u001a\u0004\u0018\u000104\u00a2\u0006\u0004\b:\u0010;J\b\u0010\u0004\u001a\u00020\u0003H\u0016R\u001d\u0010\n\u001a\u0004\u0018\u00010\u00058BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0006\u0010\u0007\u001a\u0004\b\b\u0010\tR\u0017\u0010\u000f\u001a\u00020\u000b8\u0006\u00a2\u0006\f\n\u0004\b\b\u0010\f\u001a\u0004\b\r\u0010\u000eR\u0017\u0010\u0015\u001a\u00020\u00108\u0006\u00a2\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014R\u0019\u0010\u001b\u001a\u0004\u0018\u00010\u00168\u0006\u00a2\u0006\f\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0019\u0010\u001aR\u0019\u0010!\u001a\u0004\u0018\u00010\u001c8\u0006\u00a2\u0006\f\n\u0004\b\u001d\u0010\u001e\u001a\u0004\b\u001f\u0010 R\u0017\u0010'\u001a\u00020\"8\u0006\u00a2\u0006\f\n\u0004\b#\u0010$\u001a\u0004\b%\u0010&R\u0017\u0010*\u001a\u00020\"8\u0006\u00a2\u0006\f\n\u0004\b(\u0010$\u001a\u0004\b)\u0010&R\u0017\u0010-\u001a\u00020\"8\u0006\u00a2\u0006\f\n\u0004\b+\u0010$\u001a\u0004\b,\u0010&R\u0017\u00100\u001a\u00020\"8\u0006\u00a2\u0006\f\n\u0004\b.\u0010$\u001a\u0004\b/\u0010&R\u0017\u00103\u001a\u00020\"8\u0006\u00a2\u0006\f\n\u0004\b1\u0010$\u001a\u0004\b2\u0010&R\u0019\u00109\u001a\u0004\u0018\u0001048\u0006\u00a2\u0006\f\n\u0004\b5\u00106\u001a\u0004\b7\u00108\u00a8\u0006<"}, d2 = {"Lcom/tencent/filament/zplan/business/impl/AbsBusinessScene$Booter;", "Ljava/lang/Runnable;", "Lkotlinx/coroutines/Runnable;", "", TencentLocation.RUN_MODE, "Ldl0/k;", "d", "Lkotlin/Lazy;", "e", "()Ldl0/k;", "toggleProxy", "Lcom/tencent/filament/zplan/avatar/model/BootResourceModel;", "Lcom/tencent/filament/zplan/avatar/model/BootResourceModel;", "getBootResource", "()Lcom/tencent/filament/zplan/avatar/model/BootResourceModel;", "bootResource", "", "f", "Ljava/lang/String;", "getSceneConfig", "()Ljava/lang/String;", "sceneConfig", "Lcom/tencent/filament/zplan/engine/FilamentViewerV2;", h.F, "Lcom/tencent/filament/zplan/engine/FilamentViewerV2;", "getViewerV2", "()Lcom/tencent/filament/zplan/engine/FilamentViewerV2;", "viewerV2", "Lcom/tencent/filament/zplan/engine/js/FilamentEventDispatcher;", "i", "Lcom/tencent/filament/zplan/engine/js/FilamentEventDispatcher;", "getDispatcher", "()Lcom/tencent/filament/zplan/engine/js/FilamentEventDispatcher;", "dispatcher", "", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Z", "getEnablePlanarReflection", "()Z", "enablePlanarReflection", BdhLogUtil.LogTag.Tag_Conn, "getEnablePlanarShadow", "enablePlanarShadow", "D", "getEnablePelvisOffset", "enablePelvisOffset", "E", "getUseZPlanMaterial", "useZPlanMaterial", UserInfo.SEX_FEMALE, "getEnableOpenGLLocalShaderBinary", "enableOpenGLLocalShaderBinary", "Lcom/tencent/zplan/zplantracing/c;", "G", "Lcom/tencent/zplan/zplantracing/c;", "getZplanSpanContext", "()Lcom/tencent/zplan/zplantracing/c;", "zplanSpanContext", "<init>", "(Lcom/tencent/filament/zplan/avatar/model/BootResourceModel;Ljava/lang/String;Lcom/tencent/filament/zplan/engine/FilamentViewerV2;Lcom/tencent/filament/zplan/engine/js/FilamentEventDispatcher;ZZZZZLcom/tencent/zplan/zplantracing/c;)V", "zplan-android_release"}, k = 1, mv = {1, 4, 2})
    /* loaded from: classes6.dex */
    public static final class Booter implements Runnable {

        /* renamed from: C, reason: from kotlin metadata */
        private final boolean enablePlanarShadow;

        /* renamed from: D, reason: from kotlin metadata */
        private final boolean enablePelvisOffset;

        /* renamed from: E, reason: from kotlin metadata */
        private final boolean useZPlanMaterial;

        /* renamed from: F, reason: from kotlin metadata */
        private final boolean enableOpenGLLocalShaderBinary;

        /* renamed from: G, reason: from kotlin metadata */
        @Nullable
        private final com.tencent.zplan.zplantracing.c zplanSpanContext;

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        private final Lazy toggleProxy;

        /* renamed from: e, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final BootResourceModel bootResource;

        /* renamed from: f, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final String sceneConfig;

        /* renamed from: h, reason: collision with root package name and from kotlin metadata */
        @Nullable
        private final FilamentViewerV2 viewerV2;

        /* renamed from: i, reason: collision with root package name and from kotlin metadata */
        @Nullable
        private final FilamentEventDispatcher dispatcher;

        /* renamed from: m, reason: collision with root package name and from kotlin metadata */
        private final boolean enablePlanarReflection;

        public Booter(@NotNull BootResourceModel bootResource, @NotNull String sceneConfig, @Nullable FilamentViewerV2 filamentViewerV2, @Nullable FilamentEventDispatcher filamentEventDispatcher, boolean z16, boolean z17, boolean z18, boolean z19, boolean z26, @Nullable com.tencent.zplan.zplantracing.c cVar) {
            Lazy lazy;
            Intrinsics.checkNotNullParameter(bootResource, "bootResource");
            Intrinsics.checkNotNullParameter(sceneConfig, "sceneConfig");
            this.bootResource = bootResource;
            this.sceneConfig = sceneConfig;
            this.viewerV2 = filamentViewerV2;
            this.dispatcher = filamentEventDispatcher;
            this.enablePlanarReflection = z16;
            this.enablePlanarShadow = z17;
            this.enablePelvisOffset = z18;
            this.useZPlanMaterial = z19;
            this.enableOpenGLLocalShaderBinary = z26;
            this.zplanSpanContext = cVar;
            lazy = LazyKt__LazyJVMKt.lazy(new Function0<k>() { // from class: com.tencent.filament.zplan.business.impl.AbsBusinessScene$Booter$toggleProxy$2
                /* JADX WARN: Can't rename method to resolve collision */
                @Override // kotlin.jvm.functions.Function0
                @Nullable
                public final k invoke() {
                    return (k) fl0.a.f399763a.a(k.class);
                }
            });
            this.toggleProxy = lazy;
        }

        private final k e() {
            return (k) this.toggleProxy.getValue();
        }

        @Override // java.lang.Runnable
        public void run() {
            String str;
            Boolean bool;
            com.tencent.zplan.zplantracing.b startSpan = ZPlanSpanFactory.INSTANCE.startSpan("boot", this.zplanSpanContext);
            try {
                JSONObject jSONObject = new JSONObject(this.sceneConfig);
                JSONObject jSONObject2 = jSONObject.getJSONObject("lights");
                jSONObject2.getJSONObject("indirectLight").put("path", this.bootResource.getIndirectLightPath());
                k e16 = e();
                int i3 = 28;
                if (e16 != null) {
                    i3 = e16.d("zplan_filament_support_spotlight_min_api_level", 28);
                }
                int i16 = Build.VERSION.SDK_INT;
                if (i16 < i3) {
                    FLog.INSTANCE.i(AbsBusinessScene.TAG, "boot sceneConfig remove spotLights, " + i16);
                    jSONObject2.remove("spotLights");
                }
                str = jSONObject.toString();
            } catch (JSONException e17) {
                FLog.INSTANCE.e(AbsBusinessScene.TAG, "parse indirectLight fail. ", e17);
                str = this.sceneConfig;
            }
            String str2 = str;
            Intrinsics.checkNotNullExpressionValue(str2, "try {\n                va\u2026sceneConfig\n            }");
            FilamentViewerV2 filamentViewerV2 = this.viewerV2;
            if (filamentViewerV2 != null) {
                bool = Boolean.valueOf(filamentViewerV2.boot(this.bootResource, str2, this.enablePlanarReflection, this.enablePlanarShadow, this.enablePelvisOffset, this.useZPlanMaterial, this.enableOpenGLLocalShaderBinary));
            } else {
                bool = null;
            }
            if (Intrinsics.areEqual(bool, Boolean.FALSE)) {
                if (startSpan != null) {
                    startSpan.a("boot fail");
                }
                FilamentEventDispatcher filamentEventDispatcher = this.dispatcher;
                if (filamentEventDispatcher != null) {
                    filamentEventDispatcher.onEvent("onFilamentRenderFail", "boot fail");
                }
            }
            if (startSpan != null) {
                startSpan.b();
            }
        }
    }

    /* compiled from: P */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004\u00a8\u0006\u0005"}, d2 = {"Lcom/tencent/filament/zplan/business/impl/AbsBusinessScene$FetchAvatarInfoFrom;", "", "(Ljava/lang/String;I)V", "ON_LAUNCH", "ON_COSTUME_CHANGE", "zplan-android_release"}, k = 1, mv = {1, 4, 2})
    /* loaded from: classes6.dex */
    public enum FetchAvatarInfoFrom {
        ON_LAUNCH,
        ON_COSTUME_CHANGE
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000!\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u00012\u00020\u0002J\u0018\u0010\b\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0005H\u0016\u00a8\u0006\t\u00b8\u0006\u0000"}, d2 = {"kotlinx/coroutines/CoroutineExceptionHandlerKt$CoroutineExceptionHandler$1", "Lkotlin/coroutines/AbstractCoroutineContextElement;", "Lkotlinx/coroutines/CoroutineExceptionHandler;", "Lkotlin/coroutines/CoroutineContext;", "context", "", "exception", "", "handleException", "kotlinx-coroutines-core"}, k = 1, mv = {1, 4, 2})
    /* loaded from: classes6.dex */
    public static final class a extends AbstractCoroutineContextElement implements CoroutineExceptionHandler {
        public a(CoroutineContext.Key key) {
            super(key);
        }

        @Override // kotlinx.coroutines.CoroutineExceptionHandler
        public void handleException(@NotNull CoroutineContext context, @NotNull Throwable exception) {
            FLog.INSTANCE.e(AbsBusinessScene.TAG, "there is an error in coroutine.", exception);
        }
    }

    public AbsBusinessScene() {
        ZPlanAvatarService zPlanAvatarService;
        FilamentFeatureUtil filamentFeatureUtil = FilamentFeatureUtil.f106409g;
        FilamentUrlTemplate F = filamentFeatureUtil.F();
        this.urlTemplate = F;
        f p16 = filamentFeatureUtil.p();
        FLog fLog = FLog.INSTANCE;
        fLog.i(TAG, "checkConfig:" + p16);
        Unit unit = Unit.INSTANCE;
        this.checkConfig = p16;
        boolean g16 = filamentFeatureUtil.g();
        fLog.i(TAG, "enableCppDownload:" + g16);
        this.enableCppDownload = g16;
        c o16 = filamentFeatureUtil.o();
        fLog.i(TAG, "cppDownloadConfig:" + o16);
        this.cppDownloadConfig = o16;
        if (g16) {
            zPlanAvatarService = new ZPlanAvatarService(new com.tencent.filament.zplanservice.download.a(F.toString(), o16.getEnableCheck(), ResourceCheckAlgorithmSelect.INSTANCE.a(o16.getCheckSelect())));
        } else {
            zPlanAvatarService = null;
        }
        this.service = zPlanAvatarService;
        CompletableJob SupervisorJob$default = SupervisorKt.SupervisorJob$default((Job) null, 1, (Object) null);
        this.job = SupervisorJob$default;
        this.scope = CoroutineScopeKt.CoroutineScope(SupervisorJob$default.plus(Dispatchers.getIO()).plus(new a(CoroutineExceptionHandler.INSTANCE)));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final AvatarCheckResult checkShader(String shaderDir) {
        if (!this.checkConfig.getEnableCheck()) {
            return AvatarCheckResult.INSTANCE.a();
        }
        if (shaderDir == null) {
            return AvatarCheckResult.INSTANCE.a();
        }
        long currentTimeMillis = System.currentTimeMillis();
        return AvatarCheckResult.INSTANCE.b(this.urlTemplate.getMaterialSplitUrl(), shaderDir, FilamentVerificationHelper.f106448a.a(shaderDir, ResourceCheckAlgorithmSelect.INSTANCE.a(this.checkConfig.getCheckSelect())), System.currentTimeMillis() - currentTimeMillis);
    }

    static /* synthetic */ Object fetchActionWithStatistic$default(AbsBusinessScene absBusinessScene, EnumUserGender enumUserGender, com.tencent.zplan.zplantracing.c cVar, Continuation continuation, int i3, Object obj) {
        if (obj == null) {
            if ((i3 & 2) != 0) {
                cVar = null;
            }
            return absBusinessScene.fetchActionWithStatistic(enumUserGender, cVar, continuation);
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: fetchActionWithStatistic");
    }

    static /* synthetic */ Object fetchBootResourceWithStatistic$default(AbsBusinessScene absBusinessScene, com.tencent.zplan.zplantracing.c cVar, Continuation continuation, int i3, Object obj) {
        if (obj == null) {
            if ((i3 & 1) != 0) {
                cVar = null;
            }
            return absBusinessScene.fetchBootResourceWithStatistic(cVar, continuation);
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: fetchBootResourceWithStatistic");
    }

    static /* synthetic */ Object fetchReloadAvatarResourceWithStatistic$default(AbsBusinessScene absBusinessScene, JSONObject jSONObject, com.tencent.zplan.zplantracing.c cVar, Continuation continuation, int i3, Object obj) {
        if (obj == null) {
            if ((i3 & 2) != 0) {
                cVar = null;
            }
            return absBusinessScene.fetchReloadAvatarResourceWithStatistic(jSONObject, cVar, continuation);
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: fetchReloadAvatarResourceWithStatistic");
    }

    public static /* synthetic */ void loadAnimation$default(AbsBusinessScene absBusinessScene, ZPlanAction[] zPlanActionArr, com.tencent.zplan.zplantracing.c cVar, int i3, Object obj) {
        if (obj == null) {
            if ((i3 & 2) != 0) {
                cVar = null;
            }
            absBusinessScene.loadAnimation(zPlanActionArr, cVar);
            return;
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: loadAnimation");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void loadAvatarAndAnim(com.tencent.zplan.zplantracing.c spanContext, final String avatarString, final ZPlanAction[] actionArray) {
        final com.tencent.zplan.zplantracing.b startSpan = ZPlanSpanFactory.INSTANCE.startSpan("loadAvatarAndAnim", spanContext);
        doTask("loadAvatarAndAnim", new Function0<Unit>() { // from class: com.tencent.filament.zplan.business.impl.AbsBusinessScene$loadAvatarAndAnim$1
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
                ZPlanSpanFactory zPlanSpanFactory = ZPlanSpanFactory.INSTANCE;
                com.tencent.zplan.zplantracing.b startSpan2 = zPlanSpanFactory.startSpan("reloadAvatar", startSpan);
                al0.a aVar = new al0.a(0L, 0L, false, 0, null, 31, null);
                a.Companion companion = al0.a.INSTANCE;
                aVar.l(companion.b());
                FilamentViewerV2 viewerV2 = AbsBusinessScene.this.getViewerV2();
                if (viewerV2 != null) {
                    viewerV2.reloadAvatar(startSpan2 != null ? startSpan2.c() : null, avatarString);
                }
                if (startSpan2 != null) {
                    startSpan2.b();
                }
                com.tencent.zplan.zplantracing.b startSpan3 = zPlanSpanFactory.startSpan("loadAnim", startSpan);
                AbsBusinessScene.this.loadAnimation(actionArray, startSpan3 != null ? startSpan3.c() : null);
                if (startSpan3 != null) {
                    startSpan3.b();
                    Unit unit = Unit.INSTANCE;
                }
                aVar.i(companion.b());
                com.tencent.zplan.zplantracing.b bVar = startSpan;
                if (bVar != null) {
                    bVar.b();
                }
                com.tencent.filament.zplan.business.api.c reloadAvatarCompleteListener = AbsBusinessScene.this.getReloadAvatarCompleteListener();
                if (reloadAvatarCompleteListener != null) {
                    reloadAvatarCompleteListener.a(aVar);
                }
            }
        });
    }

    static /* synthetic */ Object onCostumeChange$default(AbsBusinessScene absBusinessScene, com.tencent.zplan.zplantracing.c cVar, Continuation continuation, int i3, Object obj) {
        if (obj == null) {
            if ((i3 & 1) != 0) {
                cVar = null;
            }
            return absBusinessScene.onCostumeChange(cVar, continuation);
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: onCostumeChange");
    }

    static /* synthetic */ Object onLaunch$suspendImpl(AbsBusinessScene absBusinessScene, com.tencent.zplan.zplantracing.c cVar, Continuation continuation) {
        Object coroutine_suspended;
        Object coroutineScope = CoroutineScopeKt.coroutineScope(new AbsBusinessScene$onLaunch$2(absBusinessScene, cVar, null), continuation);
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (coroutineScope == coroutine_suspended) {
            return coroutineScope;
        }
        return Unit.INSTANCE;
    }

    static /* synthetic */ Object onPause$suspendImpl(AbsBusinessScene absBusinessScene, Continuation continuation) {
        FLog.INSTANCE.i(TAG, "AbsBusinessScene onPause");
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Removed duplicated region for block: B:12:0x0055  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0036  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0023  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static /* synthetic */ Object onTerminate$suspendImpl(AbsBusinessScene absBusinessScene, Continuation continuation) {
        AbsBusinessScene$onTerminate$1 absBusinessScene$onTerminate$1;
        Object coroutine_suspended;
        int i3;
        ZPlanAvatarService zPlanAvatarService;
        if (continuation instanceof AbsBusinessScene$onTerminate$1) {
            absBusinessScene$onTerminate$1 = (AbsBusinessScene$onTerminate$1) continuation;
            int i16 = absBusinessScene$onTerminate$1.label;
            if ((i16 & Integer.MIN_VALUE) != 0) {
                absBusinessScene$onTerminate$1.label = i16 - Integer.MIN_VALUE;
                Object obj = absBusinessScene$onTerminate$1.result;
                coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i3 = absBusinessScene$onTerminate$1.label;
                if (i3 == 0) {
                    if (i3 == 1) {
                        absBusinessScene = (AbsBusinessScene) absBusinessScene$onTerminate$1.L$0;
                        ResultKt.throwOnFailure(obj);
                    } else {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                } else {
                    ResultKt.throwOnFailure(obj);
                    FLog.INSTANCE.i(TAG, "onTerminate");
                    CompletableJob completableJob = absBusinessScene.job;
                    absBusinessScene$onTerminate$1.L$0 = absBusinessScene;
                    absBusinessScene$onTerminate$1.label = 1;
                    if (JobKt.cancelAndJoin(completableJob, absBusinessScene$onTerminate$1) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                }
                zPlanAvatarService = absBusinessScene.service;
                if (zPlanAvatarService != null) {
                    zPlanAvatarService.E();
                }
                return Unit.INSTANCE;
            }
        }
        absBusinessScene$onTerminate$1 = new AbsBusinessScene$onTerminate$1(absBusinessScene, continuation);
        Object obj2 = absBusinessScene$onTerminate$1.result;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i3 = absBusinessScene$onTerminate$1.label;
        if (i3 == 0) {
        }
        zPlanAvatarService = absBusinessScene.service;
        if (zPlanAvatarService != null) {
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void reloadAvatar(ReloadAvatarResourceModel avatarResource, JSONObject avatarInfo, com.tencent.zplan.zplantracing.c zplanSpanContext) {
        updateAvatarAssetsAndReloadAvatar(avatarResource, avatarInfo, zplanSpanContext);
    }

    static /* synthetic */ void reloadAvatar$default(AbsBusinessScene absBusinessScene, ReloadAvatarResourceModel reloadAvatarResourceModel, JSONObject jSONObject, com.tencent.zplan.zplantracing.c cVar, int i3, Object obj) {
        if (obj == null) {
            if ((i3 & 4) != 0) {
                cVar = null;
            }
            absBusinessScene.reloadAvatar(reloadAvatarResourceModel, jSONObject, cVar);
            return;
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: reloadAvatar");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void reportCppCheckResult(List<ZPlanAvatarCheckResult> checkResultList) {
        String joinToString$default;
        String joinToString$default2;
        String joinToString$default3;
        String joinToString$default4;
        String joinToString$default5;
        Map<String, String> mapOf;
        if (!this.cppDownloadConfig.getEnableCheck()) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        ArrayList arrayList3 = new ArrayList();
        ArrayList arrayList4 = new ArrayList();
        ArrayList arrayList5 = new ArrayList();
        for (ZPlanAvatarCheckResult zPlanAvatarCheckResult : checkResultList) {
            ResourceCheckResult checkResult = zPlanAvatarCheckResult.getCheckResult();
            if (!checkResult.passVerification()) {
                arrayList.add(checkResult.getFailList());
                arrayList2.add(zPlanAvatarCheckResult.getUrl());
                arrayList3.add(zPlanAvatarCheckResult.getDir());
            } else if (checkResult.getCode() != ResourceCheckCode.COMPLETED) {
                arrayList4.add(zPlanAvatarCheckResult.getUrl());
                arrayList5.add(checkResult.getCode());
            }
        }
        d.Companion companion = d.INSTANCE;
        joinToString$default = CollectionsKt___CollectionsKt.joinToString$default(arrayList, ";", null, null, 0, null, new Function1<String[], CharSequence>() { // from class: com.tencent.filament.zplan.business.impl.AbsBusinessScene$reportCppCheckResult$reportParams$1
            @Override // kotlin.jvm.functions.Function1
            @NotNull
            public final CharSequence invoke(@NotNull String[] it) {
                String joinToString$default6;
                Intrinsics.checkNotNullParameter(it, "it");
                joinToString$default6 = ArraysKt___ArraysKt.joinToString$default(it, ",", (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, (Function1) null, 62, (Object) null);
                return joinToString$default6;
            }
        }, 30, null);
        joinToString$default2 = CollectionsKt___CollectionsKt.joinToString$default(arrayList2, ";", null, null, 0, null, null, 62, null);
        joinToString$default3 = CollectionsKt___CollectionsKt.joinToString$default(arrayList3, ";", null, null, 0, null, null, 62, null);
        joinToString$default4 = CollectionsKt___CollectionsKt.joinToString$default(arrayList4, ";", null, null, 0, null, null, 62, null);
        joinToString$default5 = CollectionsKt___CollectionsKt.joinToString$default(arrayList5, ";", null, null, 0, null, new Function1<ResourceCheckCode, CharSequence>() { // from class: com.tencent.filament.zplan.business.impl.AbsBusinessScene$reportCppCheckResult$reportParams$2
            @Override // kotlin.jvm.functions.Function1
            @NotNull
            public final CharSequence invoke(@NotNull ResourceCheckCode it) {
                Intrinsics.checkNotNullParameter(it, "it");
                return String.valueOf(it.getValue());
            }
        }, 30, null);
        mapOf = MapsKt__MapsKt.mapOf(TuplesKt.to("enableCppDownload", String.valueOf(companion.b(this.enableCppDownload))), TuplesKt.to("check_select", String.valueOf(this.cppDownloadConfig.getCheckSelect())), TuplesKt.to("scene", String.valueOf(Reflection.getOrCreateKotlinClass(getClass()).getSimpleName())), TuplesKt.to("fail_list", joinToString$default), TuplesKt.to("fail_urls", joinToString$default2), TuplesKt.to("fail_dirs", joinToString$default3), TuplesKt.to("pass_verify", String.valueOf(companion.b(arrayList.isEmpty()))), TuplesKt.to("abnormal_code_urls", joinToString$default4), TuplesKt.to("abnormal_codes", joinToString$default5));
        dl0.h hVar = (dl0.h) fl0.a.f399763a.a(dl0.h.class);
        if (hVar != null) {
            hVar.a("filament_resource_verify", mapOf);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void setCameraAndLight(final String indirectLightPath) {
        doTask("setBodyTypeCameraAndLight", new Function0<Unit>() { // from class: com.tencent.filament.zplan.business.impl.AbsBusinessScene$setCameraAndLight$1
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
                BusinessSceneConfig businessSceneConfig;
                LightsParams lightsParams;
                String sceneConfig = AbsBusinessScene.this.getSceneConfig();
                CameraParams cameraParams = null;
                try {
                    businessSceneConfig = (BusinessSceneConfig) new Gson().fromJson(sceneConfig, BusinessSceneConfig.class);
                } catch (Throwable th5) {
                    FLog.INSTANCE.e(AbsBusinessScene.TAG, "parse scene config fail. " + sceneConfig + TokenParser.SP + th5.getMessage());
                    businessSceneConfig = null;
                }
                if (businessSceneConfig == null || (lightsParams = businessSceneConfig.getLights()) == null) {
                    lightsParams = new LightsParams(new Directional(null, 0, 0.0f, null, false, 31, null), new IndirectLight(null, 0.0f, 3, null), null, 4, null);
                }
                IndirectLight indirectLight = lightsParams.getIndirectLight();
                if (indirectLight != null) {
                    indirectLight.setPath(indirectLightPath);
                }
                k kVar = (k) fl0.a.f399763a.a(k.class);
                int d16 = kVar != null ? kVar.d("zplan_filament_support_spotlight_min_api_level", 28) : 28;
                int i3 = Build.VERSION.SDK_INT;
                if (i3 < d16) {
                    FLog.INSTANCE.i(AbsBusinessScene.TAG, "boot sceneConfig remove spotLights, " + i3);
                    lightsParams.setSpotLights(new ArrayList());
                }
                FilamentViewerV2 viewerV2 = AbsBusinessScene.this.getViewerV2();
                if (viewerV2 != null) {
                    viewerV2.setLights(lightsParams);
                }
                AbsBusinessScene absBusinessScene = AbsBusinessScene.this;
                CameraParams bodyTypeCamera = absBusinessScene.getBodyTypeCamera(absBusinessScene.getBodyTypeName());
                if (bodyTypeCamera != null) {
                    cameraParams = bodyTypeCamera;
                } else if (businessSceneConfig != null) {
                    cameraParams = businessSceneConfig.getCamera();
                }
                if (cameraParams == null) {
                    cameraParams = new CameraParams(null, null, null, null, null, 31, null);
                }
                FilamentViewerV2 viewerV22 = AbsBusinessScene.this.getViewerV2();
                if (viewerV22 != null) {
                    viewerV22.setCamera(cameraParams);
                }
            }
        });
    }

    private final void updateAvatarAssetsAndReloadAvatar(ReloadAvatarResourceModel avatarResource, JSONObject avatarInfo, com.tencent.zplan.zplantracing.c zplanSpanContext) {
        JSONObject p16 = ZPlanAvatarResourceHelper.p(ZPlanAvatarResourceHelper.f105660o, avatarResource, avatarInfo, needApplyShoesHeight(), false, disableGlassesMetallic(), zplanSpanContext, 8, null);
        FilamentViewerV2 filamentViewerV2 = this.viewerV2;
        if (filamentViewerV2 != null) {
            filamentViewerV2.reloadAvatar(p16, getAvatarMask(), zplanSpanContext);
        }
    }

    static /* synthetic */ void updateAvatarAssetsAndReloadAvatar$default(AbsBusinessScene absBusinessScene, ReloadAvatarResourceModel reloadAvatarResourceModel, JSONObject jSONObject, com.tencent.zplan.zplantracing.c cVar, int i3, Object obj) {
        if (obj == null) {
            if ((i3 & 4) != 0) {
                cVar = null;
            }
            absBusinessScene.updateAvatarAssetsAndReloadAvatar(reloadAvatarResourceModel, jSONObject, cVar);
            return;
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: updateAvatarAssetsAndReloadAvatar");
    }

    @Override // com.tencent.filament.zplan.business.api.IBusinessScene
    @Nullable
    public com.tencent.filament.zplan.business.api.a animate(double now, @Nullable com.tencent.zplan.zplantracing.c zplanSpanContext) {
        return null;
    }

    @Override // com.tencent.filament.zplan.business.api.IBusinessScene
    /* renamed from: canRender */
    public boolean getCanRender() {
        return true;
    }

    public boolean disableGlassesMetallic() {
        return false;
    }

    public final void doTask(@NotNull String funName, @NotNull Function0<Unit> task) {
        Intrinsics.checkNotNullParameter(funName, "funName");
        Intrinsics.checkNotNullParameter(task, "task");
        b bVar = this.exeTask;
        if (bVar != null) {
            bVar.a(funName, task);
        }
    }

    public boolean enablePelvisOffset() {
        return false;
    }

    public boolean enablePlanarReflection() {
        return false;
    }

    public boolean enablePlanarShadow() {
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Removed duplicated region for block: B:17:0x00aa  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x00c9  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x003a  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0023  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final /* synthetic */ Object executeBoot(com.tencent.zplan.zplantracing.c cVar, Continuation<? super Pair<AvatarCheckResult, BootResourceModel>> continuation) {
        AbsBusinessScene$executeBoot$1 absBusinessScene$executeBoot$1;
        Object coroutine_suspended;
        int i3;
        final com.tencent.zplan.zplantracing.b startSpan;
        com.tencent.zplan.zplantracing.c cVar2;
        final AbsBusinessScene absBusinessScene;
        final BootResourceModel bootResourceModel;
        boolean z16;
        AvatarCheckResult a16;
        Boolean boxBoolean;
        if (continuation instanceof AbsBusinessScene$executeBoot$1) {
            absBusinessScene$executeBoot$1 = (AbsBusinessScene$executeBoot$1) continuation;
            int i16 = absBusinessScene$executeBoot$1.label;
            if ((i16 & Integer.MIN_VALUE) != 0) {
                absBusinessScene$executeBoot$1.label = i16 - Integer.MIN_VALUE;
                Object obj = absBusinessScene$executeBoot$1.result;
                coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i3 = absBusinessScene$executeBoot$1.label;
                if (i3 == 0) {
                    if (i3 == 1) {
                        startSpan = (com.tencent.zplan.zplantracing.b) absBusinessScene$executeBoot$1.L$1;
                        absBusinessScene = (AbsBusinessScene) absBusinessScene$executeBoot$1.L$0;
                        ResultKt.throwOnFailure(obj);
                    } else {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                } else {
                    ResultKt.throwOnFailure(obj);
                    startSpan = ZPlanSpanFactory.INSTANCE.startSpan("executeBoot", cVar);
                    if (startSpan != null) {
                        cVar2 = startSpan.c();
                    } else {
                        cVar2 = null;
                    }
                    absBusinessScene$executeBoot$1.L$0 = this;
                    absBusinessScene$executeBoot$1.L$1 = startSpan;
                    absBusinessScene$executeBoot$1.label = 1;
                    obj = fetchBootResourceWithStatistic(cVar2, absBusinessScene$executeBoot$1);
                    if (obj == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    absBusinessScene = this;
                }
                Pair pair = (Pair) obj;
                bootResourceModel = (BootResourceModel) pair.component1();
                al0.a aVar = (al0.a) pair.component2();
                if (bootResourceModel == null && (boxBoolean = Boxing.boxBoolean(bootResourceModel.getDownloadFromNet())) != null) {
                    z16 = boxBoolean.booleanValue();
                } else {
                    z16 = false;
                }
                FLog.INSTANCE.i(TAG, "fetchBootResource, downloadFromNet: " + z16 + ", statistic: " + aVar + ", bootResource: " + bootResourceModel);
                if (bootResourceModel != null) {
                    if (startSpan != null) {
                        startSpan.a(al0.a.INSTANCE.c(aVar).toString());
                    }
                    throw new Exception(al0.a.INSTANCE.c(aVar).toString());
                }
                JSONObject c16 = al0.a.INSTANCE.c(aVar);
                d.Companion companion = d.INSTANCE;
                c16.put("downloadFromNet", companion.b(z16));
                c16.put("useCache", companion.b(bootResourceModel.getUseCache()));
                FilamentEventDispatcher filamentEventDispatcher = absBusinessScene.dispatcher;
                if (filamentEventDispatcher != null) {
                    String jSONObject = c16.toString();
                    Intrinsics.checkNotNullExpressionValue(jSONObject, "json.toString()");
                    filamentEventDispatcher.onEvent("onBootResourceReady", jSONObject);
                }
                com.tencent.zplan.zplantracing.b startSpan2 = ZPlanSpanFactory.INSTANCE.startSpan("checkBoot", startSpan);
                if (absBusinessScene.checkConfig.getEnableCheck()) {
                    a16 = bootResourceModel.a(absBusinessScene.urlTemplate, ResourceCheckAlgorithmSelect.INSTANCE.a(absBusinessScene.checkConfig.getCheckSelect()));
                } else {
                    a16 = AvatarCheckResult.INSTANCE.a();
                }
                if (startSpan2 != null) {
                    startSpan2.b();
                }
                if (a16.getPassVerify()) {
                    absBusinessScene.doTask("boot", new Function0<Unit>() { // from class: com.tencent.filament.zplan.business.impl.AbsBusinessScene$executeBoot$2
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
                            AbsBusinessScene.Booter booter;
                            booter = AbsBusinessScene.this.booter;
                            if (booter == null) {
                                AbsBusinessScene absBusinessScene2 = AbsBusinessScene.this;
                                BootResourceModel bootResourceModel2 = bootResourceModel;
                                String sceneConfig = absBusinessScene2.getSceneConfig();
                                FilamentViewerV2 viewerV2 = AbsBusinessScene.this.getViewerV2();
                                FilamentEventDispatcher dispatcher = AbsBusinessScene.this.getDispatcher();
                                boolean enablePlanarReflection = AbsBusinessScene.this.enablePlanarReflection();
                                boolean enablePlanarShadow = AbsBusinessScene.this.enablePlanarShadow();
                                boolean enablePelvisOffset = AbsBusinessScene.this.enablePelvisOffset();
                                FilamentFeatureUtil filamentFeatureUtil = FilamentFeatureUtil.f106409g;
                                boolean K = filamentFeatureUtil.K();
                                boolean j3 = filamentFeatureUtil.j();
                                com.tencent.zplan.zplantracing.b bVar = startSpan;
                                AbsBusinessScene.Booter booter2 = new AbsBusinessScene.Booter(bootResourceModel2, sceneConfig, viewerV2, dispatcher, enablePlanarReflection, enablePlanarShadow, enablePelvisOffset, K, j3, bVar != null ? bVar.c() : null);
                                booter2.run();
                                Unit unit = Unit.INSTANCE;
                                absBusinessScene2.booter = booter2;
                            }
                        }
                    });
                }
                if (startSpan != null) {
                    startSpan.b();
                }
                return new Pair(a16, bootResourceModel);
            }
        }
        absBusinessScene$executeBoot$1 = new AbsBusinessScene$executeBoot$1(this, continuation);
        Object obj2 = absBusinessScene$executeBoot$1.result;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i3 = absBusinessScene$executeBoot$1.label;
        if (i3 == 0) {
        }
        Pair pair2 = (Pair) obj2;
        bootResourceModel = (BootResourceModel) pair2.component1();
        al0.a aVar2 = (al0.a) pair2.component2();
        if (bootResourceModel == null) {
        }
        z16 = false;
        FLog.INSTANCE.i(TAG, "fetchBootResource, downloadFromNet: " + z16 + ", statistic: " + aVar2 + ", bootResource: " + bootResourceModel);
        if (bootResourceModel != null) {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Removed duplicated region for block: B:12:0x006d  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x00a4  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x00dd  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x007e  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x003a  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0023  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final /* synthetic */ Object fetchAction(com.tencent.zplan.zplantracing.c cVar, EnumUserGender enumUserGender, Continuation<? super Pair<AvatarCheckResult, ZPlanAction[]>> continuation) {
        AbsBusinessScene$fetchAction$1 absBusinessScene$fetchAction$1;
        Object coroutine_suspended;
        int i3;
        com.tencent.zplan.zplantracing.b startSpan;
        com.tencent.zplan.zplantracing.c cVar2;
        AbsBusinessScene absBusinessScene;
        ZPlanAction[] zPlanActionArr;
        boolean z16;
        if (continuation instanceof AbsBusinessScene$fetchAction$1) {
            absBusinessScene$fetchAction$1 = (AbsBusinessScene$fetchAction$1) continuation;
            int i16 = absBusinessScene$fetchAction$1.label;
            if ((i16 & Integer.MIN_VALUE) != 0) {
                absBusinessScene$fetchAction$1.label = i16 - Integer.MIN_VALUE;
                Object obj = absBusinessScene$fetchAction$1.result;
                coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i3 = absBusinessScene$fetchAction$1.label;
                if (i3 == 0) {
                    if (i3 == 1) {
                        startSpan = (com.tencent.zplan.zplantracing.b) absBusinessScene$fetchAction$1.L$1;
                        absBusinessScene = (AbsBusinessScene) absBusinessScene$fetchAction$1.L$0;
                        ResultKt.throwOnFailure(obj);
                    } else {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                } else {
                    ResultKt.throwOnFailure(obj);
                    startSpan = ZPlanSpanFactory.INSTANCE.startSpan("fetchAction", cVar);
                    if (startSpan != null) {
                        cVar2 = startSpan.c();
                    } else {
                        cVar2 = null;
                    }
                    absBusinessScene$fetchAction$1.L$0 = this;
                    absBusinessScene$fetchAction$1.L$1 = startSpan;
                    absBusinessScene$fetchAction$1.label = 1;
                    obj = fetchActionWithStatistic(enumUserGender, cVar2, absBusinessScene$fetchAction$1);
                    if (obj == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    absBusinessScene = this;
                }
                Pair pair = (Pair) obj;
                zPlanActionArr = (ZPlanAction[]) pair.component1();
                al0.a aVar = (al0.a) pair.component2();
                if (zPlanActionArr == null) {
                    z16 = false;
                    for (ZPlanAction zPlanAction : zPlanActionArr) {
                        if (zPlanAction.getDownloadFromNet()) {
                            z16 = true;
                        }
                    }
                } else {
                    z16 = false;
                }
                FLog.INSTANCE.i(TAG, "fetchActionResource, downloadFromNet: " + z16 + ", statistic:" + aVar);
                if (zPlanActionArr != null) {
                    FilamentEventDispatcher filamentEventDispatcher = absBusinessScene.dispatcher;
                    if (filamentEventDispatcher != null) {
                        String jSONObject = al0.a.INSTANCE.c(aVar).toString();
                        Intrinsics.checkNotNullExpressionValue(jSONObject, "actionStatistic.toJSON().toString()");
                        filamentEventDispatcher.onEvent("onFilamentRenderFail", jSONObject);
                    }
                    if (startSpan != null) {
                        startSpan.a(al0.a.INSTANCE.c(aVar).toString());
                    }
                    throw new Exception(al0.a.INSTANCE.c(aVar).toString());
                }
                JSONObject c16 = al0.a.INSTANCE.c(aVar);
                c16.put("downloadFromNet", d.INSTANCE.b(z16));
                FilamentEventDispatcher filamentEventDispatcher2 = absBusinessScene.dispatcher;
                if (filamentEventDispatcher2 != null) {
                    String jSONObject2 = c16.toString();
                    Intrinsics.checkNotNullExpressionValue(jSONObject2, "json.toString()");
                    filamentEventDispatcher2.onEvent("onAnimationResourceReady", jSONObject2);
                }
                com.tencent.zplan.zplantracing.b startSpan2 = ZPlanSpanFactory.INSTANCE.startSpan("checkAction", startSpan);
                AvatarCheckResult a16 = AvatarCheckResult.INSTANCE.a();
                if (absBusinessScene.checkConfig.getEnableCheck()) {
                    for (ZPlanAction zPlanAction2 : zPlanActionArr) {
                        a16 = a16.c(zPlanAction2.a(absBusinessScene.urlTemplate, ResourceCheckAlgorithmSelect.INSTANCE.a(absBusinessScene.checkConfig.getCheckSelect())));
                    }
                }
                if (startSpan2 != null) {
                    startSpan2.b();
                }
                if (startSpan != null) {
                    startSpan.b();
                }
                return new Pair(a16, zPlanActionArr);
            }
        }
        absBusinessScene$fetchAction$1 = new AbsBusinessScene$fetchAction$1(this, continuation);
        Object obj2 = absBusinessScene$fetchAction$1.result;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i3 = absBusinessScene$fetchAction$1.label;
        if (i3 == 0) {
        }
        Pair pair2 = (Pair) obj2;
        zPlanActionArr = (ZPlanAction[]) pair2.component1();
        al0.a aVar2 = (al0.a) pair2.component2();
        if (zPlanActionArr == null) {
        }
        FLog.INSTANCE.i(TAG, "fetchActionResource, downloadFromNet: " + z16 + ", statistic:" + aVar2);
        if (zPlanActionArr != null) {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ Object fetchActionArrayWithCpp(ZPlanAvatarService zPlanAvatarService, EnumUserGender enumUserGender, Continuation<? super ZPlanAction[]> continuation) {
        return CoroutineScopeKt.coroutineScope(new AbsBusinessScene$fetchActionArrayWithCpp$2(this, enumUserGender, zPlanAvatarService, null), continuation);
    }

    final /* synthetic */ Object fetchActionWithStatistic(EnumUserGender enumUserGender, com.tencent.zplan.zplantracing.c cVar, Continuation<? super Pair<ZPlanAction[], al0.a>> continuation) {
        return SupervisorKt.supervisorScope(new AbsBusinessScene$fetchActionWithStatistic$2(this, cVar, enumUserGender, null), continuation);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Removed duplicated region for block: B:17:0x00b0  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x00cf  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x003a  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0023  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final /* synthetic */ Object fetchAvatar(com.tencent.zplan.zplantracing.c cVar, JSONObject jSONObject, Continuation<? super Pair<AvatarCheckResult, ReloadAvatarResourceModel>> continuation) {
        AbsBusinessScene$fetchAvatar$1 absBusinessScene$fetchAvatar$1;
        Object coroutine_suspended;
        int i3;
        com.tencent.zplan.zplantracing.b startSpan;
        com.tencent.zplan.zplantracing.c cVar2;
        AbsBusinessScene absBusinessScene;
        ReloadAvatarResourceModel reloadAvatarResourceModel;
        boolean z16;
        AvatarCheckResult a16;
        Boolean boxBoolean;
        if (continuation instanceof AbsBusinessScene$fetchAvatar$1) {
            absBusinessScene$fetchAvatar$1 = (AbsBusinessScene$fetchAvatar$1) continuation;
            int i16 = absBusinessScene$fetchAvatar$1.label;
            if ((i16 & Integer.MIN_VALUE) != 0) {
                absBusinessScene$fetchAvatar$1.label = i16 - Integer.MIN_VALUE;
                Object obj = absBusinessScene$fetchAvatar$1.result;
                coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i3 = absBusinessScene$fetchAvatar$1.label;
                if (i3 == 0) {
                    if (i3 == 1) {
                        startSpan = (com.tencent.zplan.zplantracing.b) absBusinessScene$fetchAvatar$1.L$1;
                        absBusinessScene = (AbsBusinessScene) absBusinessScene$fetchAvatar$1.L$0;
                        ResultKt.throwOnFailure(obj);
                    } else {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                } else {
                    ResultKt.throwOnFailure(obj);
                    startSpan = ZPlanSpanFactory.INSTANCE.startSpan("fetchAvatar", cVar);
                    if (startSpan != null) {
                        cVar2 = startSpan.c();
                    } else {
                        cVar2 = null;
                    }
                    absBusinessScene$fetchAvatar$1.L$0 = this;
                    absBusinessScene$fetchAvatar$1.L$1 = startSpan;
                    absBusinessScene$fetchAvatar$1.label = 1;
                    obj = fetchReloadAvatarResourceWithStatistic(jSONObject, cVar2, absBusinessScene$fetchAvatar$1);
                    if (obj == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    absBusinessScene = this;
                }
                Pair pair = (Pair) obj;
                reloadAvatarResourceModel = (ReloadAvatarResourceModel) pair.component1();
                al0.a aVar = (al0.a) pair.component2();
                if (reloadAvatarResourceModel == null && (boxBoolean = Boxing.boxBoolean(reloadAvatarResourceModel.getDownloadFromNet())) != null) {
                    z16 = boxBoolean.booleanValue();
                } else {
                    z16 = false;
                }
                FLog.INSTANCE.i(TAG, "fetchAvatarResource, downloadFromNet: " + z16 + ", statistic: " + aVar + ", avatarResource: " + reloadAvatarResourceModel);
                if (reloadAvatarResourceModel != null) {
                    if (startSpan != null) {
                        startSpan.a(al0.a.INSTANCE.c(aVar).toString());
                    }
                    throw new Exception(al0.a.INSTANCE.c(aVar).toString());
                }
                JSONObject c16 = al0.a.INSTANCE.c(aVar);
                d.Companion companion = d.INSTANCE;
                c16.put("downloadFromNet", companion.b(z16));
                c16.put("useCache", companion.b(reloadAvatarResourceModel.getUseCache()));
                FilamentEventDispatcher filamentEventDispatcher = absBusinessScene.dispatcher;
                if (filamentEventDispatcher != null) {
                    String jSONObject2 = c16.toString();
                    Intrinsics.checkNotNullExpressionValue(jSONObject2, "json.toString()");
                    filamentEventDispatcher.onEvent("onAvatarResourceReady", jSONObject2);
                }
                com.tencent.zplan.zplantracing.b startSpan2 = ZPlanSpanFactory.INSTANCE.startSpan("checkAvatar", startSpan);
                if (absBusinessScene.checkConfig.getEnableCheck()) {
                    a16 = reloadAvatarResourceModel.a(absBusinessScene.urlTemplate, ResourceCheckAlgorithmSelect.INSTANCE.a(absBusinessScene.checkConfig.getCheckSelect()));
                } else {
                    a16 = AvatarCheckResult.INSTANCE.a();
                }
                if (startSpan2 != null) {
                    startSpan2.b();
                }
                if (startSpan != null) {
                    startSpan.b();
                }
                return new Pair(a16, reloadAvatarResourceModel);
            }
        }
        absBusinessScene$fetchAvatar$1 = new AbsBusinessScene$fetchAvatar$1(this, continuation);
        Object obj2 = absBusinessScene$fetchAvatar$1.result;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i3 = absBusinessScene$fetchAvatar$1.label;
        if (i3 == 0) {
        }
        Pair pair2 = (Pair) obj2;
        reloadAvatarResourceModel = (ReloadAvatarResourceModel) pair2.component1();
        al0.a aVar2 = (al0.a) pair2.component2();
        if (reloadAvatarResourceModel == null) {
        }
        z16 = false;
        FLog.INSTANCE.i(TAG, "fetchAvatarResource, downloadFromNet: " + z16 + ", statistic: " + aVar2 + ", avatarResource: " + reloadAvatarResourceModel);
        if (reloadAvatarResourceModel != null) {
        }
    }

    @Nullable
    public abstract Object fetchAvatarInfo(@NotNull FetchAvatarInfoFrom fetchAvatarInfoFrom, @NotNull Continuation<? super JSONObject> continuation);

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ Object fetchAvatarResourceWithCpp(com.tencent.zplan.zplantracing.c cVar, ZPlanAvatarService zPlanAvatarService, JSONObject jSONObject, Continuation<? super com.tencent.filament.zplan.business.impl.a> continuation) {
        return CoroutineScopeKt.coroutineScope(new AbsBusinessScene$fetchAvatarResourceWithCpp$2(this, cVar, jSONObject, zPlanAvatarService, null), continuation);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Removed duplicated region for block: B:15:0x00fc  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0048  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x002a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final /* synthetic */ Object fetchAvatarWithCpp(ZPlanAvatarService zPlanAvatarService, JSONObject jSONObject, Continuation<? super ZPlanAvatarInterfaceResult> continuation) {
        AbsBusinessScene$fetchAvatarWithCpp$1 absBusinessScene$fetchAvatarWithCpp$1;
        Object coroutine_suspended;
        int i3;
        JSONArray jSONArray;
        String[] strArr;
        al0.a aVar;
        AbsBusinessScene absBusinessScene;
        al0.a aVar2;
        FilamentEventDispatcher filamentEventDispatcher;
        try {
            if (continuation instanceof AbsBusinessScene$fetchAvatarWithCpp$1) {
                absBusinessScene$fetchAvatarWithCpp$1 = (AbsBusinessScene$fetchAvatarWithCpp$1) continuation;
                int i16 = absBusinessScene$fetchAvatarWithCpp$1.label;
                if ((i16 & Integer.MIN_VALUE) != 0) {
                    absBusinessScene$fetchAvatarWithCpp$1.label = i16 - Integer.MIN_VALUE;
                    Object obj = absBusinessScene$fetchAvatarWithCpp$1.result;
                    coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    i3 = absBusinessScene$fetchAvatarWithCpp$1.label;
                    if (i3 == 0) {
                        if (i3 == 1) {
                            aVar2 = (al0.a) absBusinessScene$fetchAvatarWithCpp$1.L$2;
                            aVar = (al0.a) absBusinessScene$fetchAvatarWithCpp$1.L$1;
                            absBusinessScene = (AbsBusinessScene) absBusinessScene$fetchAvatarWithCpp$1.L$0;
                            ResultKt.throwOnFailure(obj);
                        } else {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                    } else {
                        ResultKt.throwOnFailure(obj);
                        JSONObject avatarMask = getAvatarMask();
                        if (avatarMask != null) {
                            jSONArray = avatarMask.optJSONArray("hideSlotPart");
                        } else {
                            jSONArray = null;
                        }
                        if (jSONArray == null || (strArr = fx4.b.g(jSONArray)) == null) {
                            strArr = new String[0];
                        }
                        aVar = new al0.a(0L, 0L, false, 0, null, 31, null);
                        aVar.l(al0.a.INSTANCE.b());
                        String jSONObject2 = jSONObject.toString();
                        Intrinsics.checkNotNullExpressionValue(jSONObject2, "avatarInfo.toString()");
                        ZPlanAvatarMask zPlanAvatarMask = new ZPlanAvatarMask(strArr);
                        boolean needApplyShoesHeight = needApplyShoesHeight();
                        absBusinessScene$fetchAvatarWithCpp$1.L$0 = this;
                        absBusinessScene$fetchAvatarWithCpp$1.L$1 = aVar;
                        absBusinessScene$fetchAvatarWithCpp$1.L$2 = aVar;
                        absBusinessScene$fetchAvatarWithCpp$1.label = 1;
                        obj = zPlanAvatarService.y(jSONObject2, zPlanAvatarMask, needApplyShoesHeight, absBusinessScene$fetchAvatarWithCpp$1);
                        if (obj == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        absBusinessScene = this;
                        aVar2 = aVar;
                    }
                    ZPlanAvatarInterfaceResult zPlanAvatarInterfaceResult = (ZPlanAvatarInterfaceResult) obj;
                    a.Companion companion = al0.a.INSTANCE;
                    aVar2.i(companion.b());
                    String result = zPlanAvatarInterfaceResult.getResult();
                    boolean isDownload = zPlanAvatarInterfaceResult.isDownload();
                    FLog.INSTANCE.i(TAG, "fetchAvatarResource, downloadFromNet: " + isDownload + ", statistic: " + aVar + ", avatarResource: " + result);
                    JSONObject c16 = companion.c(aVar);
                    c16.put("downloadFromNet", d.INSTANCE.b(isDownload));
                    filamentEventDispatcher = absBusinessScene.dispatcher;
                    if (filamentEventDispatcher != null) {
                        String jSONObject3 = c16.toString();
                        Intrinsics.checkNotNullExpressionValue(jSONObject3, "json.toString()");
                        filamentEventDispatcher.onEvent("onAvatarResourceReady", jSONObject3);
                    }
                    return zPlanAvatarInterfaceResult;
                }
            }
            if (i3 == 0) {
            }
            ZPlanAvatarInterfaceResult zPlanAvatarInterfaceResult2 = (ZPlanAvatarInterfaceResult) obj;
            a.Companion companion2 = al0.a.INSTANCE;
            aVar2.i(companion2.b());
            String result2 = zPlanAvatarInterfaceResult2.getResult();
            boolean isDownload2 = zPlanAvatarInterfaceResult2.isDownload();
            FLog.INSTANCE.i(TAG, "fetchAvatarResource, downloadFromNet: " + isDownload2 + ", statistic: " + aVar + ", avatarResource: " + result2);
            JSONObject c162 = companion2.c(aVar);
            c162.put("downloadFromNet", d.INSTANCE.b(isDownload2));
            filamentEventDispatcher = absBusinessScene.dispatcher;
            if (filamentEventDispatcher != null) {
            }
            return zPlanAvatarInterfaceResult2;
        } catch (ZPlanAvatarServiceException e16) {
            FLog.INSTANCE.e(TAG, "fetchAvatar fail. " + e16);
            throw e16;
        }
        absBusinessScene$fetchAvatarWithCpp$1 = new AbsBusinessScene$fetchAvatarWithCpp$1(this, continuation);
        Object obj2 = absBusinessScene$fetchAvatarWithCpp$1.result;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i3 = absBusinessScene$fetchAvatarWithCpp$1.label;
    }

    final /* synthetic */ Object fetchBootResourceWithStatistic(com.tencent.zplan.zplantracing.c cVar, Continuation<? super Pair<BootResourceModel, al0.a>> continuation) {
        return CoroutineScopeKt.coroutineScope(new AbsBusinessScene$fetchBootResourceWithStatistic$2(this, cVar, null), continuation);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Removed duplicated region for block: B:15:0x00f1  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0045  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x002a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final /* synthetic */ Object fetchBootWithCpp(ZPlanAvatarService zPlanAvatarService, Continuation<? super ZPlanAvatarInterfaceResult> continuation) {
        AbsBusinessScene$fetchBootWithCpp$1 absBusinessScene$fetchBootWithCpp$1;
        Object coroutine_suspended;
        int i3;
        al0.a aVar;
        al0.a aVar2;
        final AbsBusinessScene absBusinessScene;
        FilamentEventDispatcher filamentEventDispatcher;
        try {
            if (continuation instanceof AbsBusinessScene$fetchBootWithCpp$1) {
                absBusinessScene$fetchBootWithCpp$1 = (AbsBusinessScene$fetchBootWithCpp$1) continuation;
                int i16 = absBusinessScene$fetchBootWithCpp$1.label;
                if ((i16 & Integer.MIN_VALUE) != 0) {
                    absBusinessScene$fetchBootWithCpp$1.label = i16 - Integer.MIN_VALUE;
                    Object obj = absBusinessScene$fetchBootWithCpp$1.result;
                    coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    i3 = absBusinessScene$fetchBootWithCpp$1.label;
                    if (i3 == 0) {
                        if (i3 == 1) {
                            aVar = (al0.a) absBusinessScene$fetchBootWithCpp$1.L$2;
                            aVar2 = (al0.a) absBusinessScene$fetchBootWithCpp$1.L$1;
                            absBusinessScene = (AbsBusinessScene) absBusinessScene$fetchBootWithCpp$1.L$0;
                            ResultKt.throwOnFailure(obj);
                        } else {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                    } else {
                        ResultKt.throwOnFailure(obj);
                        al0.a aVar3 = new al0.a(0L, 0L, false, 0, null, 31, null);
                        aVar3.l(al0.a.INSTANCE.b());
                        boolean enablePlanarShadow = enablePlanarShadow();
                        boolean enablePlanarReflection = enablePlanarReflection();
                        FilamentFeatureUtil filamentFeatureUtil = FilamentFeatureUtil.f106409g;
                        FetchBootResourcesOptions fetchBootResourcesOptions = new FetchBootResourcesOptions(enablePlanarShadow, enablePlanarReflection, filamentFeatureUtil.K(), filamentFeatureUtil.j(), filamentFeatureUtil.d(), filamentFeatureUtil.k(), enablePelvisOffset(), false, 128, null);
                        absBusinessScene$fetchBootWithCpp$1.L$0 = this;
                        absBusinessScene$fetchBootWithCpp$1.L$1 = aVar3;
                        absBusinessScene$fetchBootWithCpp$1.L$2 = aVar3;
                        absBusinessScene$fetchBootWithCpp$1.label = 1;
                        Object A = zPlanAvatarService.A(fetchBootResourcesOptions, absBusinessScene$fetchBootWithCpp$1);
                        if (A == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        aVar = aVar3;
                        aVar2 = aVar;
                        obj = A;
                        absBusinessScene = this;
                    }
                    ZPlanAvatarInterfaceResult zPlanAvatarInterfaceResult = (ZPlanAvatarInterfaceResult) obj;
                    a.Companion companion = al0.a.INSTANCE;
                    aVar.i(companion.b());
                    final String result = zPlanAvatarInterfaceResult.getResult();
                    boolean isDownload = zPlanAvatarInterfaceResult.isDownload();
                    FLog.INSTANCE.i(TAG, "fetchBootResource, downloadFromNet: " + isDownload + ", statistic: " + aVar2 + ", bootResource: " + result);
                    JSONObject c16 = companion.c(aVar2);
                    c16.put("downloadFromNet", d.INSTANCE.b(isDownload));
                    filamentEventDispatcher = absBusinessScene.dispatcher;
                    if (filamentEventDispatcher != null) {
                        String jSONObject = c16.toString();
                        Intrinsics.checkNotNullExpressionValue(jSONObject, "json.toString()");
                        filamentEventDispatcher.onEvent("onBootResourceReady", jSONObject);
                    }
                    absBusinessScene.doTask("boot", new Function0<Unit>() { // from class: com.tencent.filament.zplan.business.impl.AbsBusinessScene$fetchBootWithCpp$2
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
                            z16 = AbsBusinessScene.this.booted;
                            if (z16) {
                                return;
                            }
                            FLog.INSTANCE.i(AbsBusinessScene.TAG, "boot, viewerV2=" + AbsBusinessScene.this.getViewerV2());
                            FilamentViewerV2 viewerV2 = AbsBusinessScene.this.getViewerV2();
                            if (viewerV2 == null || !viewerV2.boot(result)) {
                                return;
                            }
                            AbsBusinessScene.this.booted = true;
                        }
                    });
                    return zPlanAvatarInterfaceResult;
                }
            }
            if (i3 == 0) {
            }
            ZPlanAvatarInterfaceResult zPlanAvatarInterfaceResult2 = (ZPlanAvatarInterfaceResult) obj;
            a.Companion companion2 = al0.a.INSTANCE;
            aVar.i(companion2.b());
            final String result2 = zPlanAvatarInterfaceResult2.getResult();
            boolean isDownload2 = zPlanAvatarInterfaceResult2.isDownload();
            FLog.INSTANCE.i(TAG, "fetchBootResource, downloadFromNet: " + isDownload2 + ", statistic: " + aVar2 + ", bootResource: " + result2);
            JSONObject c162 = companion2.c(aVar2);
            c162.put("downloadFromNet", d.INSTANCE.b(isDownload2));
            filamentEventDispatcher = absBusinessScene.dispatcher;
            if (filamentEventDispatcher != null) {
            }
            absBusinessScene.doTask("boot", new Function0<Unit>() { // from class: com.tencent.filament.zplan.business.impl.AbsBusinessScene$fetchBootWithCpp$2
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
                    z16 = AbsBusinessScene.this.booted;
                    if (z16) {
                        return;
                    }
                    FLog.INSTANCE.i(AbsBusinessScene.TAG, "boot, viewerV2=" + AbsBusinessScene.this.getViewerV2());
                    FilamentViewerV2 viewerV2 = AbsBusinessScene.this.getViewerV2();
                    if (viewerV2 == null || !viewerV2.boot(result2)) {
                        return;
                    }
                    AbsBusinessScene.this.booted = true;
                }
            });
            return zPlanAvatarInterfaceResult2;
        } catch (ZPlanAvatarServiceException e16) {
            FLog.INSTANCE.e(TAG, "fetchBoot fail. " + e16);
            throw e16;
        }
        absBusinessScene$fetchBootWithCpp$1 = new AbsBusinessScene$fetchBootWithCpp$1(this, continuation);
        Object obj2 = absBusinessScene$fetchBootWithCpp$1.result;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i3 = absBusinessScene$fetchBootWithCpp$1.label;
    }

    final /* synthetic */ Object fetchIdActionWithCpp(ZPlanAvatarService zPlanAvatarService, EnumUserGender enumUserGender, long j3, Continuation<? super ZPlanAction> continuation) {
        return CoroutineScopeKt.coroutineScope(new AbsBusinessScene$fetchIdActionWithCpp$2(zPlanAvatarService, j3, enumUserGender, null), continuation);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Removed duplicated region for block: B:15:0x00cd  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0045  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x002a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final /* synthetic */ Object fetchIndirectLightWithCpp(ZPlanAvatarService zPlanAvatarService, Continuation<? super ZPlanAvatarInterfaceResult> continuation) {
        AbsBusinessScene$fetchIndirectLightWithCpp$1 absBusinessScene$fetchIndirectLightWithCpp$1;
        Object coroutine_suspended;
        int i3;
        al0.a aVar;
        al0.a aVar2;
        AbsBusinessScene absBusinessScene;
        FilamentEventDispatcher filamentEventDispatcher;
        try {
            if (continuation instanceof AbsBusinessScene$fetchIndirectLightWithCpp$1) {
                absBusinessScene$fetchIndirectLightWithCpp$1 = (AbsBusinessScene$fetchIndirectLightWithCpp$1) continuation;
                int i16 = absBusinessScene$fetchIndirectLightWithCpp$1.label;
                if ((i16 & Integer.MIN_VALUE) != 0) {
                    absBusinessScene$fetchIndirectLightWithCpp$1.label = i16 - Integer.MIN_VALUE;
                    Object obj = absBusinessScene$fetchIndirectLightWithCpp$1.result;
                    coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    i3 = absBusinessScene$fetchIndirectLightWithCpp$1.label;
                    if (i3 == 0) {
                        if (i3 == 1) {
                            aVar = (al0.a) absBusinessScene$fetchIndirectLightWithCpp$1.L$2;
                            aVar2 = (al0.a) absBusinessScene$fetchIndirectLightWithCpp$1.L$1;
                            absBusinessScene = (AbsBusinessScene) absBusinessScene$fetchIndirectLightWithCpp$1.L$0;
                            ResultKt.throwOnFailure(obj);
                        } else {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                    } else {
                        ResultKt.throwOnFailure(obj);
                        al0.a aVar3 = new al0.a(0L, 0L, false, 0, null, 31, null);
                        aVar3.l(al0.a.INSTANCE.b());
                        absBusinessScene$fetchIndirectLightWithCpp$1.L$0 = this;
                        absBusinessScene$fetchIndirectLightWithCpp$1.L$1 = aVar3;
                        absBusinessScene$fetchIndirectLightWithCpp$1.L$2 = aVar3;
                        absBusinessScene$fetchIndirectLightWithCpp$1.label = 1;
                        Object C = zPlanAvatarService.C(absBusinessScene$fetchIndirectLightWithCpp$1);
                        if (C == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        aVar = aVar3;
                        aVar2 = aVar;
                        obj = C;
                        absBusinessScene = this;
                    }
                    ZPlanAvatarInterfaceResult zPlanAvatarInterfaceResult = (ZPlanAvatarInterfaceResult) obj;
                    a.Companion companion = al0.a.INSTANCE;
                    aVar.i(companion.b());
                    String result = zPlanAvatarInterfaceResult.getResult();
                    boolean isDownload = zPlanAvatarInterfaceResult.isDownload();
                    FLog.INSTANCE.i(TAG, "fetchIndirectLight, downloadFromNet: " + isDownload + ", statistic: " + aVar2 + ", indirectLightPath: " + result);
                    JSONObject c16 = companion.c(aVar2);
                    c16.put("downloadFromNet", d.INSTANCE.b(isDownload));
                    filamentEventDispatcher = absBusinessScene.dispatcher;
                    if (filamentEventDispatcher != null) {
                        String jSONObject = c16.toString();
                        Intrinsics.checkNotNullExpressionValue(jSONObject, "json.toString()");
                        filamentEventDispatcher.onEvent("onIndirectLightResourceReady", jSONObject);
                    }
                    return zPlanAvatarInterfaceResult;
                }
            }
            if (i3 == 0) {
            }
            ZPlanAvatarInterfaceResult zPlanAvatarInterfaceResult2 = (ZPlanAvatarInterfaceResult) obj;
            a.Companion companion2 = al0.a.INSTANCE;
            aVar.i(companion2.b());
            String result2 = zPlanAvatarInterfaceResult2.getResult();
            boolean isDownload2 = zPlanAvatarInterfaceResult2.isDownload();
            FLog.INSTANCE.i(TAG, "fetchIndirectLight, downloadFromNet: " + isDownload2 + ", statistic: " + aVar2 + ", indirectLightPath: " + result2);
            JSONObject c162 = companion2.c(aVar2);
            c162.put("downloadFromNet", d.INSTANCE.b(isDownload2));
            filamentEventDispatcher = absBusinessScene.dispatcher;
            if (filamentEventDispatcher != null) {
            }
            return zPlanAvatarInterfaceResult2;
        } catch (ZPlanAvatarServiceException e16) {
            FLog.INSTANCE.e(TAG, "fetchIndirectLight fail. " + e16);
            throw e16;
        }
        absBusinessScene$fetchIndirectLightWithCpp$1 = new AbsBusinessScene$fetchIndirectLightWithCpp$1(this, continuation);
        Object obj2 = absBusinessScene$fetchIndirectLightWithCpp$1.result;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i3 = absBusinessScene$fetchIndirectLightWithCpp$1.label;
    }

    final /* synthetic */ Object fetchReloadAvatarResourceWithStatistic(JSONObject jSONObject, com.tencent.zplan.zplantracing.c cVar, Continuation<? super Pair<ReloadAvatarResourceModel, al0.a>> continuation) {
        return CoroutineScopeKt.coroutineScope(new AbsBusinessScene$fetchReloadAvatarResourceWithStatistic$2(this, cVar, jSONObject, null), continuation);
    }

    @Nullable
    public abstract FetchActionData[] getActionDataArray(@NotNull EnumUserGender gender);

    @Nullable
    public JSONObject getAvatarMask() {
        JSONObject jSONObject = new JSONObject();
        JSONArray jSONArray = new JSONArray();
        jSONArray.mo162put("HandHeldSlot");
        Unit unit = Unit.INSTANCE;
        jSONObject.put("hideSlotPart", jSONArray);
        return jSONObject;
    }

    @Nullable
    public abstract CameraParams getBodyTypeCamera(@Nullable String bodyTypeName);

    @Nullable
    public final String getBodyTypeName() {
        return this.bodyTypeName;
    }

    @Nullable
    public final FilamentEventDispatcher getDispatcher() {
        return this.dispatcher;
    }

    @Nullable
    public final b getExeTask() {
        return this.exeTask;
    }

    @NotNull
    public final AtomicBoolean getFirstRenderEnd() {
        return this.firstRenderEnd;
    }

    @Nullable
    public abstract LightsParams getLightConfigAfterThemeChange();

    @Nullable
    public final com.tencent.filament.zplan.business.api.c getReloadAvatarCompleteListener() {
        return this.reloadAvatarCompleteListener;
    }

    @NotNull
    public abstract String getSceneConfig();

    @Override // com.tencent.filament.zplan.business.api.IBusinessScene
    @NotNull
    public SceneType getSceneType() {
        return SceneType.NONE;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @NotNull
    public final CoroutineScope getScope() {
        return this.scope;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Nullable
    public final ZPlanAvatarService getService() {
        return this.service;
    }

    @NotNull
    public final FilamentUrlTemplate getUrlTemplate() {
        return this.urlTemplate;
    }

    @Nullable
    public final FilamentViewerV2 getViewerV2() {
        return this.viewerV2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ Object innerLoadAvatarResource(com.tencent.zplan.zplantracing.c cVar, JSONObject jSONObject, Continuation<? super Unit> continuation) {
        Object coroutine_suspended;
        Object coroutineScope = CoroutineScopeKt.coroutineScope(new AbsBusinessScene$innerLoadAvatarResource$2(this, cVar, jSONObject, null), continuation);
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (coroutineScope == coroutine_suspended) {
            return coroutineScope;
        }
        return Unit.INSTANCE;
    }

    @Override // com.tencent.filament.zplan.business.api.IBusinessScene
    /* renamed from: launchOnIOThread */
    public boolean getMEnableFilamentPreLaunch() {
        return false;
    }

    public abstract void loadAnimation(@NotNull ZPlanAction[] actionArray, @Nullable com.tencent.zplan.zplantracing.c zplanSpanContext);

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ Object loadAvatarResource(com.tencent.zplan.zplantracing.c cVar, JSONObject jSONObject, Continuation<? super Unit> continuation) {
        Job launch$default;
        Object coroutine_suspended;
        Object coroutine_suspended2;
        Object coroutine_suspended3;
        if (!this.checkConfig.getEnableCheck()) {
            Object innerLoadAvatarResource = innerLoadAvatarResource(cVar, jSONObject, continuation);
            coroutine_suspended3 = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (innerLoadAvatarResource == coroutine_suspended3) {
                return innerLoadAvatarResource;
            }
        } else if (!(!Intrinsics.areEqual(Looper.myLooper(), Looper.getMainLooper()))) {
            launch$default = BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getIO()), null, null, new AbsBusinessScene$loadAvatarResource$2(this, cVar, jSONObject, null), 3, null);
            coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (launch$default == coroutine_suspended) {
                return launch$default;
            }
        } else {
            Object innerLoadAvatarResource2 = innerLoadAvatarResource(cVar, jSONObject, continuation);
            coroutine_suspended2 = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (innerLoadAvatarResource2 == coroutine_suspended2) {
                return innerLoadAvatarResource2;
            }
        }
        return Unit.INSTANCE;
    }

    public abstract boolean needApplyShoesHeight();

    @Override // com.tencent.filament.zplan.business.api.IBusinessScene
    /* renamed from: needRecordFirstFrame */
    public boolean getNeedRecordFirstFrame() {
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ Object onCostumeChange(com.tencent.zplan.zplantracing.c cVar, Continuation<? super Unit> continuation) {
        Object coroutine_suspended;
        Object coroutineScope = CoroutineScopeKt.coroutineScope(new AbsBusinessScene$onCostumeChange$2(this, cVar, null), continuation);
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (coroutineScope == coroutine_suspended) {
            return coroutineScope;
        }
        return Unit.INSTANCE;
    }

    @Override // com.tencent.filament.zplan.business.api.IBusinessScene
    public void onFirstRenderEnd() {
        FLog.INSTANCE.i(TAG, "onFirstRenderEnd");
        this.firstRenderEnd.set(true);
    }

    @Override // com.tencent.filament.zplan.business.api.IBusinessScene
    @Nullable
    public Object onLaunch(@Nullable com.tencent.zplan.zplantracing.c cVar, @NotNull Continuation<? super Unit> continuation) {
        return onLaunch$suspendImpl(this, cVar, continuation);
    }

    @Override // com.tencent.filament.zplan.business.api.IBusinessScene
    @Nullable
    public Object onPause(@NotNull Continuation<? super Unit> continuation) {
        return onPause$suspendImpl(this, continuation);
    }

    @Override // com.tencent.filament.zplan.business.api.IBusinessScene
    @Nullable
    public Object onTerminate(@NotNull Continuation<? super Unit> continuation) {
        return onTerminate$suspendImpl(this, continuation);
    }

    @Override // com.tencent.filament.zplan.business.api.IBusinessScene
    public void processDispatchEvent(@NotNull String event, @Nullable String eventData, @Nullable com.tencent.zplan.zplantracing.c zplanSpanContext) {
        LightsParams lightConfigAfterThemeChange;
        Intrinsics.checkNotNullParameter(event, "event");
        int hashCode = event.hashCode();
        if (hashCode != -1359158767) {
            if (hashCode != -697710292) {
                if (hashCode == 2078387242 && event.equals("onThemeChanged") && (lightConfigAfterThemeChange = getLightConfigAfterThemeChange()) != null) {
                    BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getIO()), null, null, new AbsBusinessScene$processDispatchEvent$$inlined$let$lambda$1(null, this, lightConfigAfterThemeChange), 3, null);
                    return;
                }
                return;
            }
            if (event.equals("SetBackgroundPlane")) {
                BuildersKt__Builders_commonKt.launch$default(GlobalScope.INSTANCE, Dispatchers.getIO(), null, new AbsBusinessScene$processDispatchEvent$3(this, eventData, null), 2, null);
                return;
            }
            return;
        }
        if (event.equals("onCostumeChange")) {
            BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getMain()), null, null, new AbsBusinessScene$processDispatchEvent$1(this, zplanSpanContext, null), 3, null);
        }
    }

    public final void setBodyTypeName(@Nullable String str) {
        this.bodyTypeName = str;
    }

    public final void setDispatcher(@Nullable FilamentEventDispatcher filamentEventDispatcher) {
        this.dispatcher = filamentEventDispatcher;
    }

    @Override // com.tencent.filament.zplan.business.api.IBusinessScene
    public void setEventDispatcher(@Nullable FilamentEventDispatcher dispatcher) {
        this.dispatcher = dispatcher;
    }

    public final void setExeTask(@Nullable b bVar) {
        this.exeTask = bVar;
    }

    @Override // com.tencent.filament.zplan.business.api.IBusinessScene
    public void setExecuteFunk(@Nullable b task) {
        this.exeTask = task;
    }

    public final void setReloadAvatarCompleteListener(@Nullable com.tencent.filament.zplan.business.api.c cVar) {
        this.reloadAvatarCompleteListener = cVar;
    }

    @Override // com.tencent.filament.zplan.business.api.IBusinessScene
    public void setReloadAvatarListener(@NotNull com.tencent.filament.zplan.business.api.c listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        this.reloadAvatarCompleteListener = listener;
    }

    @Override // com.tencent.filament.zplan.business.api.IBusinessScene
    public void setViewer(@Nullable FilamentViewerV2 viewer) {
        this.viewerV2 = viewer;
    }

    public final void setViewerV2(@Nullable FilamentViewerV2 filamentViewerV2) {
        this.viewerV2 = filamentViewerV2;
    }
}

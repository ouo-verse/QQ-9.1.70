package com.tencent.filament.zplan.avatar;

import android.net.http.Headers;
import android.text.TextUtils;
import androidx.exifinterface.media.ExifInterface;
import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.heytap.databaseengine.model.UserInfo;
import com.huawei.hms.support.hianalytics.HiAnalyticsConstant;
import com.tencent.ark.ark;
import com.tencent.component.network.module.base.QDLog;
import com.tencent.filament.zplan.animation.ZPlanAction;
import com.tencent.filament.zplan.avatar.exception.BlackListResourceException;
import com.tencent.filament.zplan.avatar.exception.FetchFileException;
import com.tencent.filament.zplan.avatar.model.AvatarResourceModel;
import com.tencent.filament.zplan.avatar.model.AvatarSlot;
import com.tencent.filament.zplan.avatar.model.BootResourceModel;
import com.tencent.filament.zplan.avatar.model.ColorType;
import com.tencent.filament.zplan.avatar.model.EnumUserGender;
import com.tencent.filament.zplan.avatar.model.MakeUpConfig;
import com.tencent.filament.zplan.avatar.model.ReloadAvatarResourceModel;
import com.tencent.filament.zplan.avatar.model.Resource;
import com.tencent.filament.zplan.avatar.model.TorsoSlot;
import com.tencent.filament.zplan.avatar.model.ZPlanCommonGltfFAsset;
import com.tencent.filament.zplan.avatar.model.ZPlanDressUpFAsset;
import com.tencent.filament.zplan.avatar.model.ZPlanDressUpFAssetInfo;
import com.tencent.filament.zplan.avatar.model.ZPlanFAsset;
import com.tencent.filament.zplan.avatar.model.ZPlanFAssetInfo;
import com.tencent.filament.zplan.avatar.model.ZPlanMakeUpFAsset;
import com.tencent.filament.zplan.avatar.model.ZPlanMakeUpFAssetInfo;
import com.tencent.filament.zplan.avatar.model.ZPlanPinchFaceModel;
import com.tencent.filament.zplan.avatar.model.ZPlanUgcFAsset;
import com.tencent.filament.zplan.avatar.model.ZPlanUgcFAssetInfo;
import com.tencent.filament.zplan.avatar.model.ZPlanUpdateHairInfo;
import com.tencent.filament.zplan.bgplane.Backdrop;
import com.tencent.filament.zplan.business.impl.AbsBusinessScene;
import com.tencent.filament.zplan.engine.js.FilamentFileUtil;
import com.tencent.filament.zplan.engine.js.FilamentMD5Util;
import com.tencent.filament.zplan.engine.js.FilamentZipUtil;
import com.tencent.filament.zplanservice.download.FetchBootResourcesOptions;
import com.tencent.filament.zplanservice.download.ZPlanAvatarFileDownloadDescriptor;
import com.tencent.filament.zplanservice.download.ZPlanAvatarInterfaceResult;
import com.tencent.filament.zplanservice.download.ZPlanAvatarMask;
import com.tencent.filament.zplanservice.download.ZPlanAvatarService;
import com.tencent.filament.zplanservice.download.ZPlanAvatarServiceException;
import com.tencent.filament.zplanservice.feature.FilamentFeatureUtil;
import com.tencent.filament.zplanservice.feature.model.FilamentUrlTemplate;
import com.tencent.filament.zplanservice.util.log.FLog;
import com.tencent.filament.zplanservice.verify.FilamentVerificationHelper;
import com.tencent.filament.zplanservice.verify.ResourceCheckAlgorithmSelect;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.predownload.schedule.PreDownloadConstants;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mtt.hippy.annotation.HippyControllerProps;
import com.tencent.qqlive.tvkplayer.tools.utils.TVKCommonParamEnum;
import com.tencent.qqmini.sdk.report.MiniAppReportManager2;
import com.tencent.zplan.zplantracing.ZPlanSpanFactory;
import dl0.j;
import dl0.k;
import el0.ETagInfo;
import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentSkipListSet;
import java.util.concurrent.locks.ReentrantLock;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.ArraysKt___ArraysKt;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.SafeContinuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugProbes;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.text.StringsKt__StringNumberConversionsKt;
import kotlin.text.StringsKt__StringsJVMKt;
import kotlin.text.StringsKt__StringsKt;
import kotlinx.coroutines.AwaitKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Deferred;
import kotlinx.coroutines.Dispatchers;
import oicq.wlogin_sdk.tools.util;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import tl.h;

@Metadata(d1 = {"\u0000\u00ba\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0015\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010$\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0006\n\u0002\b\u0015\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u000b\b\u0002\u00a2\u0006\u0006\b\u00df\u0001\u0010\u00e0\u0001J\u0018\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002J,\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\r2\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u000bH\u0002J\u0010\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0010\u001a\u00020\u000fH\u0002J\u001a\u0010\u0017\u001a\u00020\u00162\b\u0010\u0014\u001a\u0004\u0018\u00010\u00132\u0006\u0010\u0015\u001a\u00020\u0002H\u0002J\u001a\u0010\u0019\u001a\u00020\u00112\u0006\u0010\u0010\u001a\u00020\u000f2\b\u0010\u0018\u001a\u0004\u0018\u00010\u0002H\u0002J\u0010\u0010\u001a\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\u000bH\u0002J\u0010\u0010\u001c\u001a\u00020\u00022\u0006\u0010\u001b\u001a\u00020\u0005H\u0002J \u0010 \u001a\u00020\u00162\u0006\u0010\u001d\u001a\u00020\u00022\u0006\u0010\u001e\u001a\u00020\u00022\u0006\u0010\u001f\u001a\u00020\u0002H\u0002J \u0010\"\u001a\u00020\u00162\u0006\u0010\u001d\u001a\u00020\u00022\u0006\u0010\u001e\u001a\u00020\u00022\u0006\u0010!\u001a\u00020\u0002H\u0002JD\u0010(\u001a\u00020\u00112\b\u0010$\u001a\u0004\u0018\u00010#2\u0006\u0010\u001d\u001a\u00020\u00022\u0006\u0010\u0018\u001a\u00020\u00022\u0006\u0010%\u001a\u00020\u00162\b\u0010&\u001a\u0004\u0018\u00010\u00022\u0006\u0010'\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u000bH\u0002J \u0010+\u001a\u00020\u00112\u0006\u0010\u001d\u001a\u00020\u00022\u0006\u0010)\u001a\u00020\u00022\u0006\u0010*\u001a\u00020\u0016H\u0002J \u0010.\u001a\u00020\u00112\u0006\u0010\u001d\u001a\u00020\u00022\u0006\u0010,\u001a\u00020\t2\u0006\u0010-\u001a\u00020\u0002H\u0002J\u0010\u00100\u001a\u00020\u00162\u0006\u0010/\u001a\u00020\u0005H\u0002J \u00102\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\u000b2\u0006\u00101\u001a\u00020\u0016H\u0002J\u0018\u00103\u001a\u00020\u00112\u0006\u0010\u001d\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\u000bH\u0002J\u0010\u00105\u001a\u00020\u00162\u0006\u00104\u001a\u00020\u0013H\u0002J&\u0010:\u001a\u0002092\b\u00106\u001a\u0004\u0018\u00010\u00132\b\u00107\u001a\u0004\u0018\u00010\u00132\b\u00108\u001a\u0004\u0018\u00010\u0013H\u0002J \u0010>\u001a\u00020=2\u0006\u0010;\u001a\u00020\u00052\u0006\u0010<\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\u000bH\u0002J\u0010\u0010?\u001a\u00020\u00162\u0006\u0010;\u001a\u00020\u0005H\u0002J\u0010\u0010@\u001a\u00020\u00072\u0006\u00104\u001a\u00020\u0013H\u0002J\u0010\u0010A\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\u000bH\u0002J\u001a\u0010E\u001a\u00020\u0011*\b\u0012\u0004\u0012\u00020\u00130B2\u0006\u0010D\u001a\u00020CH\u0002J\u0010\u0010G\u001a\u00020\u00162\u0006\u0010F\u001a\u00020\u0005H\u0002J\u001e\u0010K\u001a\u00020\u00132\u0006\u0010I\u001a\u00020H2\f\u0010J\u001a\b\u0012\u0004\u0012\u00020\u00050BH\u0002J\u0010\u0010L\u001a\u00020\u00132\u0006\u0010I\u001a\u00020HH\u0002JB\u0010T\u001a\u00020\u00132\u0014\u0010N\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u00020M2\u0012\u0010P\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020O0M2\u0006\u0010R\u001a\u00020Q2\u0006\u0010S\u001a\u00020\u0013H\u0002J%\u0010V\u001a\u00020U2\b\u0010$\u001a\u0004\u0018\u00010#2\u0006\u0010\f\u001a\u00020\u000bH\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0004\bV\u0010WJ7\u0010X\u001a\u00020H2\b\u0010$\u001a\u0004\u0018\u00010#2\u0006\u00104\u001a\u00020\u00132\u0006\u0010\f\u001a\u00020\u000b2\b\b\u0002\u00101\u001a\u00020\u0016H\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0004\bX\u0010YJ7\u0010Z\u001a\u00020H2\b\u0010$\u001a\u0004\u0018\u00010#2\u0006\u00104\u001a\u00020\u00132\u0006\u0010\f\u001a\u00020\u000b2\b\b\u0002\u00101\u001a\u00020\u0016H\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0004\bZ\u0010YJ-\u0010\\\u001a\u00020[2\b\u0010$\u001a\u0004\u0018\u00010#2\u0006\u00104\u001a\u00020\u00132\u0006\u0010\f\u001a\u00020\u000bH\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\\\u0010]J7\u0010^\u001a\u00020H2\b\u0010$\u001a\u0004\u0018\u00010#2\u0006\u00104\u001a\u00020\u00132\u0006\u0010\f\u001a\u00020\u000b2\b\b\u0002\u00101\u001a\u00020\u0016H\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0004\b^\u0010YJ%\u0010_\u001a\u00020U2\b\u0010$\u001a\u0004\u0018\u00010#2\u0006\u0010\f\u001a\u00020\u000bH\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0004\b_\u0010WJ%\u0010`\u001a\u00020U2\b\u0010$\u001a\u0004\u0018\u00010#2\u0006\u0010\f\u001a\u00020\u000bH\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0004\b`\u0010WJ\u0006\u0010a\u001a\u00020\u0011J5\u0010c\u001a\u00020b2\b\u0010$\u001a\u0004\u0018\u00010#2\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u000bH\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0004\bc\u0010dJ5\u0010e\u001a\u00020b2\b\u0010$\u001a\u0004\u0018\u00010#2\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u000bH\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0004\be\u0010dJ=\u0010h\u001a\u00020b2\b\u0010$\u001a\u0004\u0018\u00010#2\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010f\u001a\u00020\u00022\u0006\u0010g\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\u000bH\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0004\bh\u0010iJ=\u0010j\u001a\u00020b2\b\u0010$\u001a\u0004\u0018\u00010#2\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010f\u001a\u00020\u00022\u0006\u0010g\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\u000bH\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0004\bj\u0010iJ'\u0010m\u001a\u0004\u0018\u00010l2\b\u0010k\u001a\u0004\u0018\u00010\u00022\u0006\u0010\f\u001a\u00020\u000bH\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0004\bm\u0010nJ=\u0010p\u001a\u00020o2\b\u0010$\u001a\u0004\u0018\u00010#2\u0006\u0010\u001d\u001a\u00020\u00022\u0006\u0010;\u001a\u00020\u00052\u0006\u0010<\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\u000bH\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0004\bp\u0010qJ\u000e\u0010r\u001a\u00020\u00112\u0006\u0010\u0010\u001a\u00020\u000fJM\u0010y\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00110x0B2\b\u0010$\u001a\u0004\u0018\u00010#2\u0012\u0010u\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020t0s2\u0006\u0010w\u001a\u00020v2\u0006\u0010\f\u001a\u00020\u000bH\u0082@\u00f8\u0001\u0000\u00a2\u0006\u0004\by\u0010zJ-\u0010|\u001a\u00020\u00112\b\u0010$\u001a\u0004\u0018\u00010#2\u0006\u0010{\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\u000bH\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0004\b|\u0010}J%\u0010~\u001a\u00020\u00112\b\u0010$\u001a\u0004\u0018\u00010#2\u0006\u0010\f\u001a\u00020\u000bH\u0082@\u00f8\u0001\u0000\u00a2\u0006\u0004\b~\u0010WJ%\u0010\u007f\u001a\u00020\u00112\b\u0010$\u001a\u0004\u0018\u00010#2\u0006\u0010\f\u001a\u00020\u000bH\u0082@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u007f\u0010WJ'\u0010\u0080\u0001\u001a\u00020o2\b\u0010$\u001a\u0004\u0018\u00010#2\u0006\u0010\f\u001a\u00020\u000bH\u0082@\u00f8\u0001\u0000\u00a2\u0006\u0005\b\u0080\u0001\u0010WJ'\u0010\u0081\u0001\u001a\u00020o2\b\u0010$\u001a\u0004\u0018\u00010#2\u0006\u0010\f\u001a\u00020\u000bH\u0082@\u00f8\u0001\u0000\u00a2\u0006\u0005\b\u0081\u0001\u0010WJ'\u0010\u0082\u0001\u001a\u00020o2\b\u0010$\u001a\u0004\u0018\u00010#2\u0006\u0010\f\u001a\u00020\u000bH\u0082@\u00f8\u0001\u0000\u00a2\u0006\u0005\b\u0082\u0001\u0010WJ'\u0010\u0083\u0001\u001a\u00020o2\b\u0010$\u001a\u0004\u0018\u00010#2\u0006\u0010\f\u001a\u00020\u000bH\u0082@\u00f8\u0001\u0000\u00a2\u0006\u0005\b\u0083\u0001\u0010WJH\u0010\u0085\u0001\u001a\u001b\u0012\u0011\u0012\u000f\u0012\u0004\u0012\u00020\u0002\u0012\u0005\u0012\u00030\u0084\u00010s\u0012\u0004\u0012\u00020\u00160\r2\b\u0010$\u001a\u0004\u0018\u00010#2\u0006\u00104\u001a\u00020\u00132\u0006\u0010\f\u001a\u00020\u000bH\u0082@\u00f8\u0001\u0000\u00a2\u0006\u0005\b\u0085\u0001\u0010]J+\u0010\u0087\u0001\u001a\u000f\u0012\u0004\u0012\u00020\u0002\u0012\u0005\u0012\u00030\u0086\u00010s2\u0006\u00104\u001a\u00020\u0013H\u0082@\u00f8\u0001\u0000\u00a2\u0006\u0006\b\u0087\u0001\u0010\u0088\u0001J:\u0010\u0089\u0001\u001a\u00020o2\b\u0010$\u001a\u0004\u0018\u00010#2\u0006\u0010\u001d\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\u000b2\b\b\u0002\u0010%\u001a\u00020\u0016H\u0082@\u00f8\u0001\u0000\u00a2\u0006\u0006\b\u0089\u0001\u0010\u008a\u0001J:\u0010\u008b\u0001\u001a\u00020o2\b\u0010$\u001a\u0004\u0018\u00010#2\u0006\u0010\u001d\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\u000b2\b\b\u0002\u0010%\u001a\u00020\u0016H\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0006\b\u008b\u0001\u0010\u008a\u0001JP\u0010\u008e\u0001\u001a\u00020o2\b\u0010$\u001a\u0004\u0018\u00010#2\u0006\u0010\u001d\u001a\u00020\u00022\u000b\b\u0002\u0010\u008c\u0001\u001a\u0004\u0018\u00010\u00022\u0007\u0010\u008d\u0001\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\u000b2\b\b\u0002\u0010%\u001a\u00020\u0016H\u0080@\u00f8\u0001\u0000\u00a2\u0006\u0006\b\u008e\u0001\u0010\u008f\u0001J'\u0010\u0090\u0001\u001a\u00020o2\b\u0010$\u001a\u0004\u0018\u00010#2\u0006\u0010\f\u001a\u00020\u000bH\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0005\b\u0090\u0001\u0010WJ'\u0010\u0091\u0001\u001a\u00020o2\b\u0010$\u001a\u0004\u0018\u00010#2\u0006\u0010\f\u001a\u00020\u000bH\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0005\b\u0091\u0001\u0010WJO\u0010\u0092\u0001\u001a\u001a\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020t0s\u0012\u0004\u0012\u00020\u00160\r2\b\u0010$\u001a\u0004\u0018\u00010#2\u0006\u00104\u001a\u00020\u00132\u0006\u0010\f\u001a\u00020\u000b2\u0006\u00101\u001a\u00020\u0016H\u0082@\u00f8\u0001\u0000\u00a2\u0006\u0005\b\u0092\u0001\u0010YJ/\u0010\u0093\u0001\u001a\u00020o2\b\u0010$\u001a\u0004\u0018\u00010#2\u0006\u00104\u001a\u00020\u00132\u0006\u0010\f\u001a\u00020\u000bH\u0082@\u00f8\u0001\u0000\u00a2\u0006\u0005\b\u0093\u0001\u0010]JD\u0010\u0095\u0001\u001a\u000f\u0012\u0005\u0012\u00030\u0094\u0001\u0012\u0004\u0012\u00020\u00160\r2\b\u0010$\u001a\u0004\u0018\u00010#2\u0006\u00104\u001a\u00020\u00132\u0006\u0010\f\u001a\u00020\u000b2\u0006\u00101\u001a\u00020\u0016H\u0082@\u00f8\u0001\u0000\u00a2\u0006\u0005\b\u0095\u0001\u0010YJ4\u0010\u0096\u0001\u001a\u000f\u0012\u0005\u0012\u00030\u0094\u0001\u0012\u0004\u0012\u00020\u00160\r2\b\u0010$\u001a\u0004\u0018\u00010#2\u0006\u0010\f\u001a\u00020\u000bH\u0082@\u00f8\u0001\u0000\u00a2\u0006\u0005\b\u0096\u0001\u0010WJ2\u0010\u0097\u0001\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020=0s2\u0006\u00104\u001a\u00020\u00132\u0006\u0010\f\u001a\u00020\u000bH\u0082@\u00f8\u0001\u0000\u00a2\u0006\u0006\b\u0097\u0001\u0010\u0098\u0001J'\u0010\u0099\u0001\u001a\u00020o2\b\u0010$\u001a\u0004\u0018\u00010#2\u0006\u0010\f\u001a\u00020\u000bH\u0082@\u00f8\u0001\u0000\u00a2\u0006\u0005\b\u0099\u0001\u0010WJ1\u0010\u009b\u0001\u001a\t\u0012\u0005\u0012\u00030\u009a\u00010\u00042\u0006\u00104\u001a\u00020\u00132\n\b\u0002\u0010$\u001a\u0004\u0018\u00010#H\u0082@\u00f8\u0001\u0000\u00a2\u0006\u0006\b\u009b\u0001\u0010\u009c\u0001J<\u0010\u009d\u0001\u001a\u000f\u0012\u0005\u0012\u00030\u0094\u0001\u0012\u0004\u0012\u00020\u00160\r2\b\u0010$\u001a\u0004\u0018\u00010#2\u0006\u00104\u001a\u00020\u00132\u0006\u0010\f\u001a\u00020\u000bH\u0082@\u00f8\u0001\u0000\u00a2\u0006\u0005\b\u009d\u0001\u0010]J+\u0010\u009f\u0001\u001a\u00030\u009e\u00012\u0006\u00104\u001a\u00020\u00132\n\b\u0002\u0010$\u001a\u0004\u0018\u00010#H\u0082@\u00f8\u0001\u0000\u00a2\u0006\u0006\b\u009f\u0001\u0010\u009c\u0001J+\u0010\u00a0\u0001\u001a\u00030\u009e\u00012\u0006\u00104\u001a\u00020\u00132\n\b\u0002\u0010$\u001a\u0004\u0018\u00010#H\u0082@\u00f8\u0001\u0000\u00a2\u0006\u0006\b\u00a0\u0001\u0010\u009c\u0001J\u0017\u0010\u00a1\u0001\u001a\u00020\u00162\u0006\u0010\u001d\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\u000bJ'\u0010\u00a2\u0001\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u001d\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\u000bH\u0082@\u00f8\u0001\u0000\u00a2\u0006\u0005\b\u00a2\u0001\u0010nJ\u0019\u0010\u00a3\u0001\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u001d\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\u000bJ\u001f\u0010\u00a4\u0001\u001a\u00020\u00022\u0006\u0010;\u001a\u00020\u00052\u0006\u0010<\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\u000bJ\u0012\u0010\u00a6\u0001\u001a\u0004\u0018\u00010\u00022\u0007\u0010\u00a5\u0001\u001a\u00020\u0013J\u0018\u0010\u00a8\u0001\u001a\u00020\u00132\u0007\u0010\u00a7\u0001\u001a\u00020U2\u0006\u0010I\u001a\u00020HJ\u0018\u0010\u00aa\u0001\u001a\u00020\u00132\u0006\u00104\u001a\u00020\u00132\u0007\u0010\u00a9\u0001\u001a\u00020\u0013JC\u0010\u00ae\u0001\u001a\u00020\u00132\u0006\u0010I\u001a\u00020H2\u0007\u0010\u00a5\u0001\u001a\u00020\u00132\u0007\u0010\u00ab\u0001\u001a\u00020\u00162\t\b\u0002\u0010\u00ac\u0001\u001a\u00020\u00162\t\b\u0002\u0010\u00ad\u0001\u001a\u00020\u00162\n\b\u0002\u0010$\u001a\u0004\u0018\u00010#J\u0014\u0010\u00b0\u0001\u001a\u0004\u0018\u00010Q2\t\u0010\u00af\u0001\u001a\u0004\u0018\u00010\u0013R\u001d\u0010\u00b3\u0001\u001a\b\u0012\u0004\u0012\u00020\u00050\u00048\u0002X\u0082\u0004\u00a2\u0006\b\n\u0006\b\u00b1\u0001\u0010\u00b2\u0001R\u0018\u0010\u00b7\u0001\u001a\u00030\u00b4\u00018\u0002X\u0082\u0004\u00a2\u0006\b\n\u0006\b\u00b5\u0001\u0010\u00b6\u0001R0\u0010\u00bb\u0001\u001a\u001b\u0012\u0004\u0012\u00020\u0002\u0012\u0011\u0012\u000f\u0012\u000b\u0012\t\u0012\u0004\u0012\u00020o0\u00b8\u00010B0s8\u0002X\u0082\u0004\u00a2\u0006\b\n\u0006\b\u00b9\u0001\u0010\u00ba\u0001R\u0018\u0010\u00bd\u0001\u001a\u00030\u00b4\u00018\u0002X\u0082\u0004\u00a2\u0006\b\n\u0006\b\u00bc\u0001\u0010\u00b6\u0001R\u0018\u0010\u00c1\u0001\u001a\u00030\u00be\u00018\u0002X\u0082\u0004\u00a2\u0006\b\n\u0006\b\u00bf\u0001\u0010\u00c0\u0001R\u001a\u0010\u00c5\u0001\u001a\u0005\u0018\u00010\u00c2\u00018\u0002X\u0082\u0004\u00a2\u0006\b\n\u0006\b\u00c3\u0001\u0010\u00c4\u0001R\u001a\u0010\u00c9\u0001\u001a\u0005\u0018\u00010\u00c6\u00018\u0002X\u0082\u0004\u00a2\u0006\b\n\u0006\b\u00c7\u0001\u0010\u00c8\u0001R\u001e\u0010\u00cd\u0001\u001a\t\u0012\u0004\u0012\u00020H0\u00ca\u00018\u0002X\u0082\u0004\u00a2\u0006\b\n\u0006\b\u00cb\u0001\u0010\u00cc\u0001R\u001e\u0010\u00cf\u0001\u001a\t\u0012\u0004\u0012\u00020U0\u00ca\u00018\u0002X\u0082\u0004\u00a2\u0006\b\n\u0006\b\u00ce\u0001\u0010\u00cc\u0001R \u0010\u00d3\u0001\u001a\t\u0012\u0004\u0012\u00020\u00020\u00d0\u00018\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u00d1\u0001\u0010\u00d2\u0001R\u0017\u0010\u00d5\u0001\u001a\u00020\u00168\u0002X\u0082\u0004\u00a2\u0006\b\n\u0006\b\u00d4\u0001\u0010\u00a2\u0001R\u0018\u0010\u00d9\u0001\u001a\u00030\u00d6\u00018\u0002X\u0082\u0004\u00a2\u0006\b\n\u0006\b\u00d7\u0001\u0010\u00d8\u0001R\u0018\u0010\u00dd\u0001\u001a\u00030\u00da\u00018\u0002X\u0082\u0004\u00a2\u0006\b\n\u0006\b\u00db\u0001\u0010\u00dc\u0001R\u0017\u0010\u00de\u0001\u001a\u00020\u00168\u0002X\u0082\u0004\u00a2\u0006\b\n\u0006\b\u00a8\u0001\u0010\u00a2\u0001\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u00e1\u0001"}, d2 = {"Lcom/tencent/filament/zplan/avatar/ZPlanAvatarResourceHelper;", "", "", "resBlackListJsonString", "", "", HippyTKDListViewAdapter.X, "Lcom/tencent/filament/zplan/avatar/model/EnumUserGender;", "gender", "", "actionId", "Lcom/tencent/filament/zplanservice/feature/model/FilamentUrlTemplate;", "urlTemplate", "Lkotlin/Pair;", "D0", "Lel0/a;", "eTagInfo", "", "H0", "Lorg/json/JSONObject;", "eTagJSONObject", "eTagFromChannel", "", "r", "unzipDirPath", "M0", "v0", "ugcId", "L0", "url", "tmpDir", "targetDir", "G0", "unzipDir", "F0", "Lcom/tencent/zplan/zplantracing/c;", "zplanSpanContext", "shouldVerifyMd5", "filePath", HiAnalyticsConstant.HaKey.BI_KEY_RESULT, "E0", "path", "isDownloadFromNet", "C0", "errorCode", "errorMsg", "B0", "slotID", "r0", "useLod2", "m0", "w", "avatarPbJson", "I0", "hatSlotInfo", "headDressSlotInfo", "hairSlotInfo", "Lcom/tencent/filament/zplan/avatar/model/ZPlanUpdateHairInfo;", "o0", "slotId", "itemId", "Lcom/tencent/filament/zplan/avatar/model/ZPlanFAssetInfo;", "v", "t0", "j0", "n0", "", "Lorg/json/JSONArray;", HippyControllerProps.ARRAY, "u", "slot", "s0", "Lcom/tencent/filament/zplan/avatar/model/ReloadAvatarResourceModel;", "avatarResource", "resourceIds", "x0", "A0", "", "avatarSlotGltfs", "Lcom/tencent/filament/zplan/avatar/model/MakeUpConfig;", "makeupSlotTextures", "Lcom/tencent/filament/zplan/avatar/model/a;", "colorSlotInfo", "target", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "Lcom/tencent/filament/zplan/avatar/model/BootResourceModel;", "G", "(Lcom/tencent/zplan/zplantracing/c;Lcom/tencent/filament/zplanservice/feature/model/FilamentUrlTemplate;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Y", "(Lcom/tencent/zplan/zplantracing/c;Lorg/json/JSONObject;Lcom/tencent/filament/zplanservice/feature/model/FilamentUrlTemplate;ZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "X", "Lcom/tencent/filament/zplan/avatar/model/AvatarResourceModel;", "D", "(Lcom/tencent/zplan/zplantracing/c;Lorg/json/JSONObject;Lcom/tencent/filament/zplanservice/feature/model/FilamentUrlTemplate;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "V", "H", UserInfo.SEX_FEMALE, ReportConstant.COSTREPORT_PREFIX, "Lcom/tencent/filament/zplan/animation/ZPlanAction;", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "(Lcom/tencent/zplan/zplantracing/c;Lcom/tencent/filament/zplan/avatar/model/EnumUserGender;ILcom/tencent/filament/zplanservice/feature/model/FilamentUrlTemplate;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, "faceActionPath", "bodyActionPath", BdhLogUtil.LogTag.Tag_Conn, "(Lcom/tencent/zplan/zplantracing/c;Lcom/tencent/filament/zplan/avatar/model/EnumUserGender;Ljava/lang/String;Ljava/lang/String;Lcom/tencent/filament/zplanservice/feature/model/FilamentUrlTemplate;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "B", "jsonString", "Lcom/tencent/filament/zplan/bgplane/Backdrop;", "k0", "(Ljava/lang/String;Lcom/tencent/filament/zplanservice/feature/model/FilamentUrlTemplate;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lcom/tencent/filament/zplan/avatar/model/b;", "y", "(Lcom/tencent/zplan/zplantracing/c;Ljava/lang/String;JJLcom/tencent/filament/zplanservice/feature/model/FilamentUrlTemplate;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "q0", "", "Lcom/tencent/filament/zplan/avatar/model/ZPlanFAsset;", "slotAssetMap", "Lkotlinx/coroutines/CoroutineScope;", "coroutineScope", "Lkotlinx/coroutines/Deferred;", "d0", "(Lcom/tencent/zplan/zplantracing/c;Ljava/util/Map;Lkotlinx/coroutines/CoroutineScope;Lcom/tencent/filament/zplanservice/feature/model/FilamentUrlTemplate;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "gltfPath", "c0", "(Lcom/tencent/zplan/zplantracing/c;Ljava/lang/String;Lcom/tencent/filament/zplanservice/feature/model/FilamentUrlTemplate;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "a0", "e0", ExifInterface.LATITUDE_SOUTH, "P", BdhLogUtil.LogTag.Tag_Req, AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, "Lcom/tencent/filament/zplan/avatar/model/ZPlanUgcFAsset;", "f0", "Lcom/tencent/filament/zplan/avatar/model/ZPlanUgcFAssetInfo;", "z0", "(Lorg/json/JSONObject;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "i0", "(Lcom/tencent/zplan/zplantracing/c;Ljava/lang/String;Lcom/tencent/filament/zplanservice/feature/model/FilamentUrlTemplate;ZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "g0", WadlProxyConsts.PARAM_FILENAME, "fileExtension", "L", "(Lcom/tencent/zplan/zplantracing/c;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/tencent/filament/zplanservice/feature/model/FilamentUrlTemplate;ZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "O", "N", "J0", "E", "Lcom/tencent/filament/zplan/avatar/model/ZPlanCommonGltfFAsset;", "J", "K", "K0", "(Lorg/json/JSONObject;Lcom/tencent/filament/zplanservice/feature/model/FilamentUrlTemplate;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "U", "Lcom/tencent/filament/zplan/avatar/model/ZPlanPinchFaceModel;", "y0", "(Lorg/json/JSONObject;Lcom/tencent/zplan/zplantracing/c;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "I", "", "T", "b0", "u0", "Z", "N0", "p0", "avatarInfo", "l0", "bootResource", DomainData.DOMAIN_NAME, "faceStruct", "t", "needApplyShoesHeight", "showOnlyHead", "disableGlassesMetallic", "o", "colorInfo", "w0", "a", "Ljava/util/List;", "resBlackList", "Ljava/util/concurrent/locks/ReentrantLock;", "b", "Ljava/util/concurrent/locks/ReentrantLock;", "etagFileLock", "Lkotlin/coroutines/Continuation;", "c", "Ljava/util/Map;", "taskMap", "d", "taskMapLock", "Lcom/tencent/filament/zplan/avatar/ZPlanAvatarDownloader;", "e", "Lcom/tencent/filament/zplan/avatar/ZPlanAvatarDownloader;", QDLog.TAG_DOWNLOAD, "Ldl0/j;", "f", "Ldl0/j;", "threadPoolProxy", "Ldl0/h;", "g", "Ldl0/h;", "reportProxy", "Lcom/tencent/filament/zplan/avatar/b;", h.F, "Lcom/tencent/filament/zplan/avatar/b;", "avatarResourceCache", "i", "bootResourceCache", "Ljava/util/concurrent/ConcurrentSkipListSet;", "j", "Ljava/util/concurrent/ConcurrentSkipListSet;", "eTagsFromChannel", "k", "enableCppDownload", "Lcl0/c;", "l", "Lcl0/c;", "cppDownloadConfig", "Lcom/tencent/filament/zplanservice/download/ZPlanAvatarService;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lcom/tencent/filament/zplanservice/download/ZPlanAvatarService;", "avatarService", "downloadAgainWhenFileNotFound", "<init>", "()V", "zplan-android_release"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes6.dex */
public final class ZPlanAvatarResourceHelper {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private static final List<Long> resBlackList;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private static final ReentrantLock etagFileLock;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private static final Map<String, List<Continuation<Resource>>> taskMap;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private static final ReentrantLock taskMapLock;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private static final ZPlanAvatarDownloader downloader;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private static final j threadPoolProxy;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    private static final dl0.h reportProxy;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private static final b<ReloadAvatarResourceModel> avatarResourceCache;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private static final b<BootResourceModel> bootResourceCache;

    /* renamed from: j, reason: collision with root package name and from kotlin metadata */
    private static ConcurrentSkipListSet<String> eTagsFromChannel;

    /* renamed from: k, reason: collision with root package name and from kotlin metadata */
    private static final boolean enableCppDownload;

    /* renamed from: l, reason: collision with root package name and from kotlin metadata */
    private static final cl0.c cppDownloadConfig;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private static final ZPlanAvatarService avatarService;

    /* renamed from: n, reason: collision with root package name and from kotlin metadata */
    private static final boolean downloadAgainWhenFileNotFound;

    /* renamed from: o, reason: collision with root package name */
    @NotNull
    public static final ZPlanAvatarResourceHelper f105660o;

    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/filament/zplan/avatar/ZPlanAvatarResourceHelper$a", "Lcom/tencent/filament/zplan/avatar/d;", "Lorg/json/JSONObject;", ark.ARKMETADATA_JSON, "", "a", "zplan-android_release"}, k = 1, mv = {1, 4, 2})
    /* loaded from: classes6.dex */
    public static final class a implements d {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ ETagInfo f105670a;

        a(ETagInfo eTagInfo) {
            this.f105670a = eTagInfo;
        }

        @Override // com.tencent.filament.zplan.avatar.d
        public void a(@Nullable JSONObject json) {
            ZPlanAvatarResourceHelper zPlanAvatarResourceHelper = ZPlanAvatarResourceHelper.f105660o;
            if (!zPlanAvatarResourceHelper.r(json, this.f105670a.getETag())) {
                FLog.INSTANCE.i("FilamentNativeApp[ZPlanAvatarResourceHelper]", "checkNeedWriteEtagFile false, eTagFromChannel: " + this.f105670a.getETag());
                return;
            }
            FLog.INSTANCE.i("FilamentNativeApp[ZPlanAvatarResourceHelper]", "saveETagAndFassetPathIfNeed, try writeEtagFile, eTagInfo: " + this.f105670a);
            ZPlanAvatarResourceHelper.c(zPlanAvatarResourceHelper).o(this.f105670a.getETag(), this.f105670a.getFassetCachePath(), this.f105670a.getUrl());
        }
    }

    static {
        List<Long> emptyList;
        ZPlanAvatarResourceHelper zPlanAvatarResourceHelper = new ZPlanAvatarResourceHelper();
        f105660o = zPlanAvatarResourceHelper;
        etagFileLock = new ReentrantLock();
        taskMap = new LinkedHashMap();
        taskMapLock = new ReentrantLock();
        fl0.a aVar = fl0.a.f399763a;
        threadPoolProxy = (j) aVar.a(j.class);
        reportProxy = (dl0.h) aVar.a(dl0.h.class);
        avatarResourceCache = new b<>();
        bootResourceCache = new b<>();
        eTagsFromChannel = new ConcurrentSkipListSet<>();
        FilamentFeatureUtil filamentFeatureUtil = FilamentFeatureUtil.f106409g;
        boolean g16 = filamentFeatureUtil.g();
        FLog fLog = FLog.INSTANCE;
        fLog.i("FilamentNativeApp[ZPlanAvatarResourceHelper]V2", "enableCppDownload:" + g16);
        enableCppDownload = g16;
        cl0.c o16 = filamentFeatureUtil.o();
        fLog.i("FilamentNativeApp[ZPlanAvatarResourceHelper]", "cppDownloadConfig:" + o16);
        cppDownloadConfig = o16;
        avatarService = new ZPlanAvatarService(new com.tencent.filament.zplanservice.download.a(filamentFeatureUtil.F().getRawString(), o16.getEnableCheck(), ResourceCheckAlgorithmSelect.INSTANCE.a(o16.getCheckSelect())));
        downloader = new ZPlanAvatarDownloader(FilamentFileUtil.INSTANCE.pathAppend(FilamentFileUtil.systemCacheDirectory(), "avatarDownload"));
        downloadAgainWhenFileNotFound = filamentFeatureUtil.H();
        if (!filamentFeatureUtil.l()) {
            emptyList = CollectionsKt__CollectionsKt.emptyList();
        } else {
            emptyList = zPlanAvatarResourceHelper.x(filamentFeatureUtil.B());
        }
        resBlackList = emptyList;
    }

    ZPlanAvatarResourceHelper() {
    }

    private final JSONObject A0(ReloadAvatarResourceModel avatarResource) {
        JSONObject jSONObject = new JSONObject();
        for (Map.Entry<String, ZPlanUgcFAsset> entry : avatarResource.v().entrySet()) {
            jSONObject.put(entry.getKey(), entry.getValue().getJsonPath());
        }
        return jSONObject;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void B0(String url, int errorCode, String errorMsg) {
        ReentrantLock reentrantLock = taskMapLock;
        reentrantLock.lock();
        try {
            List<Continuation<Resource>> remove = taskMap.remove(url);
            if (remove != null) {
                for (Continuation<Resource> continuation : remove) {
                    FetchFileException fetchFileException = new FetchFileException(FetchFileException.Type.DOWNLOAD_FAIL, errorCode, errorMsg, url);
                    Result.Companion companion = Result.INSTANCE;
                    continuation.resumeWith(Result.m476constructorimpl(ResultKt.createFailure(fetchFileException)));
                }
            }
        } finally {
            reentrantLock.unlock();
        }
    }

    private final void C0(String url, String path, boolean isDownloadFromNet) {
        ReentrantLock reentrantLock = taskMapLock;
        reentrantLock.lock();
        try {
            List<Continuation<Resource>> remove = taskMap.remove(url);
            if (remove != null) {
                Iterator<Continuation<Resource>> it = remove.iterator();
                while (it.hasNext()) {
                    it.next().resumeWith(Result.m476constructorimpl(new Resource(path, isDownloadFromNet, false, 4, null)));
                }
            }
        } finally {
            reentrantLock.unlock();
        }
    }

    private final Pair<String, String> D0(EnumUserGender gender, int actionId, FilamentUrlTemplate urlTemplate) {
        String fFaceAnimResUrl;
        String fBodyAnimResUrl;
        String replace$default;
        String replace$default2;
        int i3 = e.f105677a[gender.ordinal()];
        if (i3 != 1) {
            if (i3 == 2) {
                fFaceAnimResUrl = urlTemplate.getMFaceAnimResUrl();
                fBodyAnimResUrl = urlTemplate.getMBodyAnimResUrl();
            } else {
                throw new RuntimeException("fetchAction, gender is illegal");
            }
        } else {
            fFaceAnimResUrl = urlTemplate.getFFaceAnimResUrl();
            fBodyAnimResUrl = urlTemplate.getFBodyAnimResUrl();
        }
        replace$default = StringsKt__StringsJVMKt.replace$default(fFaceAnimResUrl, "{action_id}", String.valueOf(actionId), false, 4, (Object) null);
        replace$default2 = StringsKt__StringsJVMKt.replace$default(fBodyAnimResUrl, "{action_id}", String.valueOf(actionId), false, 4, (Object) null);
        return new Pair<>(replace$default, replace$default2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void E0(com.tencent.zplan.zplantracing.c zplanSpanContext, String url, String unzipDirPath, boolean shouldVerifyMd5, String filePath, int statusCode, FilamentUrlTemplate urlTemplate) {
        String substringBeforeLast$default;
        boolean F0;
        if (statusCode != 200 && statusCode != 304) {
            FLog.INSTANCE.e("FilamentNativeApp[ZPlanAvatarResourceHelper]", "download fail. statusCode: " + statusCode + ", url: " + url);
            B0(url, statusCode, String.valueOf(statusCode));
            return;
        }
        if (filePath == null) {
            FLog.INSTANCE.e("FilamentNativeApp[ZPlanAvatarResourceHelper]", "download fail. filePath is null, url: " + url);
            B0(url, 301000, "filePath is null");
            return;
        }
        String md5 = FilamentMD5Util.md5(url + Math.random());
        StringBuilder sb5 = new StringBuilder();
        String str = File.separator;
        Intrinsics.checkNotNullExpressionValue(str, "File.separator");
        substringBeforeLast$default = StringsKt__StringsKt.substringBeforeLast$default(unzipDirPath, str, (String) null, 2, (Object) null);
        sb5.append(substringBeforeLast$default);
        sb5.append('/');
        sb5.append(md5);
        String sb6 = sb5.toString();
        ZPlanSpanFactory zPlanSpanFactory = ZPlanSpanFactory.INSTANCE;
        com.tencent.zplan.zplantracing.b startSpan = zPlanSpanFactory.startSpan("unzip", zplanSpanContext);
        if (!FilamentZipUtil.unzip(filePath, sb6)) {
            FLog.INSTANCE.e("FilamentNativeApp[ZPlanAvatarResourceHelper]", "unzip fail. url: " + url);
            if (startSpan != null) {
                startSpan.a("unzip fail");
            }
            B0(url, 301002, "unzip fail");
            return;
        }
        if (startSpan != null) {
            startSpan.b();
        }
        if (shouldVerifyMd5 && !FAssetChecker.f105632b.b(sb6)) {
            FLog.INSTANCE.e("FilamentNativeApp[ZPlanAvatarResourceHelper]", "verify md5 fail. url: " + url);
            FilamentFileUtil.INSTANCE.deleteDirSafely(sb6);
            B0(url, 301003, "verify md5 fail");
            return;
        }
        if (FilamentFeatureUtil.f106409g.p().getEnableGenerate()) {
            FilamentVerificationHelper.f106448a.b(sb6, com.tencent.filament.zplanservice.util.c.c(url));
        }
        com.tencent.zplan.zplantracing.b startSpan2 = zPlanSpanFactory.startSpan("rename", zplanSpanContext);
        if (u0(url, urlTemplate)) {
            F0 = G0(url, sb6, unzipDirPath);
        } else {
            F0 = F0(url, sb6, unzipDirPath);
        }
        if (!F0) {
            FLog.INSTANCE.e("FilamentNativeApp[ZPlanAvatarResourceHelper]", "rename fail. url: " + url);
            if (startSpan2 != null) {
                startSpan2.a("rename fail");
            }
            B0(url, 301004, "rename fail");
            return;
        }
        if (startSpan2 != null) {
            startSpan2.b();
        }
        C0(url, unzipDirPath, true);
    }

    private final boolean F0(String url, String tmpDir, String unzipDir) {
        File file = new File(tmpDir);
        File file2 = new File(unzipDir);
        boolean renameTo = file.renameTo(file2);
        if (!file2.exists()) {
            FLog.INSTANCE.e("FilamentNativeApp[ZPlanAvatarResourceHelper]", "renameDir fail. result: " + renameTo + ", url: " + url);
            return false;
        }
        return true;
    }

    private final boolean G0(String url, String tmpDir, String targetDir) {
        String[] list = new File(tmpDir).list();
        if (list == null) {
            FLog.INSTANCE.e("FilamentNativeApp[ZPlanAvatarResourceHelper]", "renameSingleFile fail. childFilenameList is null. url: " + url);
            return false;
        }
        File file = new File(targetDir);
        if (!file.exists()) {
            file.mkdirs();
        }
        for (String childFilename : list) {
            FilamentFileUtil filamentFileUtil = FilamentFileUtil.INSTANCE;
            Intrinsics.checkNotNullExpressionValue(childFilename, "childFilename");
            String pathAppend = filamentFileUtil.pathAppend(tmpDir, childFilename);
            File file2 = new File(filamentFileUtil.pathAppend(targetDir, childFilename));
            boolean renameTo = new File(pathAppend).renameTo(file2);
            if (!file2.exists()) {
                FLog.INSTANCE.e("FilamentNativeApp[ZPlanAvatarResourceHelper]", "renameSingleFile fail. result: " + renameTo + ", url: " + url + ", file:" + childFilename);
                return false;
            }
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void H0(ETagInfo eTagInfo) {
        downloader.i(eTagInfo.getUrl(), new a(eTagInfo));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean I0(JSONObject avatarPbJson) {
        JSONArray jSONArray;
        JSONObject optJSONObject = avatarPbJson.optJSONObject("avatar_info");
        if (optJSONObject != null) {
            jSONArray = optJSONObject.optJSONArray("slot_arr");
        } else {
            jSONArray = null;
        }
        if (jSONArray != null && jSONArray.length() > 0) {
            int length = jSONArray.length();
            for (int i3 = 0; i3 < length; i3++) {
                JSONObject optJSONObject2 = jSONArray.optJSONObject(i3);
                if (optJSONObject2 != null) {
                    long optLong = optJSONObject2.optLong(MiniAppReportManager2.KEY_SLOT_ID);
                    AvatarSlot avatarSlot = AvatarSlot.cfgpb_AvatarSlot_EN_SLOT_SHOES;
                    if (optLong == avatarSlot.getValue()) {
                        FLog.INSTANCE.i("FilamentNativeApp[ZPlanAvatarResourceHelper]", "fetchTorsoFAssetsWithAvatar, avatar info has slot " + avatarSlot + ", delete default torso feet.");
                        return false;
                    }
                }
            }
            return true;
        }
        return true;
    }

    private final String L0(long ugcId) {
        String str;
        if (ugcId < 40000000000L) {
            str = "/QQShowShipping/Game/";
        } else {
            str = "/QQShowDev/Game/";
        }
        return "https://ugc.superqqshow.qq.com" + str;
    }

    public static /* synthetic */ Object M(ZPlanAvatarResourceHelper zPlanAvatarResourceHelper, com.tencent.zplan.zplantracing.c cVar, String str, String str2, String str3, FilamentUrlTemplate filamentUrlTemplate, boolean z16, Continuation continuation, int i3, Object obj) {
        String str4;
        boolean z17;
        if ((i3 & 4) != 0) {
            str4 = null;
        } else {
            str4 = str2;
        }
        if ((i3 & 32) != 0) {
            z17 = false;
        } else {
            z17 = z16;
        }
        return zPlanAvatarResourceHelper.L(cVar, str, str4, str3, filamentUrlTemplate, z17, continuation);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void M0(ETagInfo eTagInfo, String unzipDirPath) {
        boolean z16;
        String substringBeforeLast$default;
        boolean F0;
        String url = eTagInfo.getUrl();
        FilamentUrlTemplate F = FilamentFeatureUtil.f106409g.F();
        String fassetCachePath = eTagInfo.getFassetCachePath();
        if (unzipDirPath != null && unzipDirPath.length() != 0) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (z16) {
            FLog.INSTANCE.e("FilamentNativeApp[ZPlanAvatarResourceHelper]", "unZipAndSaveFassetResourceIfNeed failed. unzipDirPath empty.");
            return;
        }
        if (FAssetChecker.f105632b.d(unzipDirPath, url, F)) {
            return;
        }
        FLog fLog = FLog.INSTANCE;
        fLog.i("FilamentNativeApp[ZPlanAvatarResourceHelper]", "verifyResourceExist false, try save unzipFile.");
        StringBuilder sb5 = new StringBuilder();
        String str = File.separator;
        Intrinsics.checkNotNullExpressionValue(str, "File.separator");
        substringBeforeLast$default = StringsKt__StringsKt.substringBeforeLast$default(unzipDirPath, str, (String) null, 2, (Object) null);
        sb5.append(substringBeforeLast$default);
        sb5.append('/');
        sb5.append(FilamentMD5Util.md5(url + Math.random()));
        String sb6 = sb5.toString();
        if (!FilamentZipUtil.unzip(fassetCachePath, sb6)) {
            fLog.e("FilamentNativeApp[ZPlanAvatarResourceHelper]", "unZipAndSaveFassetResourceIfNeed fail, isUnzipSuccess false.");
            return;
        }
        if (u0(url, F)) {
            F0 = G0(url, sb6, unzipDirPath);
        } else {
            F0 = F0(url, sb6, unzipDirPath);
        }
        if (!F0) {
            fLog.e("FilamentNativeApp[ZPlanAvatarResourceHelper]", "unZipAndSaveFassetResourceIfNeed fail, isRenameSuccess false.");
        }
    }

    public static /* synthetic */ Object W(ZPlanAvatarResourceHelper zPlanAvatarResourceHelper, com.tencent.zplan.zplantracing.c cVar, JSONObject jSONObject, FilamentUrlTemplate filamentUrlTemplate, boolean z16, Continuation continuation, int i3, Object obj) throws FetchFileException, BlackListResourceException, RuntimeException {
        if ((i3 & 8) != 0) {
            z16 = false;
        }
        return zPlanAvatarResourceHelper.V(cVar, jSONObject, filamentUrlTemplate, z16, continuation);
    }

    public static final /* synthetic */ ZPlanAvatarDownloader c(ZPlanAvatarResourceHelper zPlanAvatarResourceHelper) {
        return downloader;
    }

    public static /* synthetic */ Object h0(ZPlanAvatarResourceHelper zPlanAvatarResourceHelper, com.tencent.zplan.zplantracing.c cVar, String str, FilamentUrlTemplate filamentUrlTemplate, boolean z16, Continuation continuation, int i3, Object obj) {
        if ((i3 & 8) != 0) {
            z16 = false;
        }
        return zPlanAvatarResourceHelper.g0(cVar, str, filamentUrlTemplate, z16, continuation);
    }

    private final EnumUserGender j0(JSONObject avatarPbJson) {
        EnumUserGender a16 = EnumUserGender.INSTANCE.a(avatarPbJson.optInt("gender"));
        if (a16 == EnumUserGender.GENDER_UNINIT) {
            return EnumUserGender.GENDER_FEMALE;
        }
        return a16;
    }

    private final String m0(EnumUserGender gender, FilamentUrlTemplate urlTemplate, boolean useLod2) {
        String str;
        String defaultTorsoUrl;
        String replace$default;
        int i3 = e.f105678b[gender.ordinal()];
        if (i3 != 1) {
            if (i3 == 2) {
                if (useLod2) {
                    str = "M_Face_Lod2/SK_CH_M_Facial";
                } else {
                    str = "M_Face/SK_CH_M_Facial";
                }
            } else {
                throw new RuntimeException("fetchTorsoFAssetsWithAvatar, gender is illegal");
            }
        } else if (useLod2) {
            str = "Face_Lod2/SK_CH_Face";
        } else {
            str = "Face/SK_CH_Face";
        }
        String str2 = str;
        if (FilamentFeatureUtil.f106409g.e()) {
            FLog.INSTANCE.i("FilamentNativeApp[ZPlanAvatarResourceHelper]", "defaultTorsoV2 Enabled");
            defaultTorsoUrl = urlTemplate.getDefaultTorsoUrlV2();
        } else {
            defaultTorsoUrl = urlTemplate.getDefaultTorsoUrl();
        }
        replace$default = StringsKt__StringsJVMKt.replace$default(defaultTorsoUrl, "{filename}", str2, false, 4, (Object) null);
        return replace$default;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String n0(FilamentUrlTemplate urlTemplate) {
        String substringBeforeLast$default;
        substringBeforeLast$default = StringsKt__StringsKt.substringBeforeLast$default(urlTemplate.getMaterialSplitUrl(), '/', (String) null, 2, (Object) null);
        return substringBeforeLast$default;
    }

    private final ZPlanUpdateHairInfo o0(JSONObject hatSlotInfo, JSONObject headDressSlotInfo, JSONObject hairSlotInfo) {
        boolean z16 = false;
        ZPlanUpdateHairInfo zPlanUpdateHairInfo = new ZPlanUpdateHairInfo(false, null, 2, null);
        if (hatSlotInfo == null) {
            return zPlanUpdateHairInfo;
        }
        if (hairSlotInfo == null) {
            return zPlanUpdateHairInfo;
        }
        Object opt = hairSlotInfo.opt("item_data");
        if (!(opt instanceof JSONObject)) {
            return zPlanUpdateHairInfo;
        }
        String optString = ((JSONObject) opt).optString("additional_info");
        if (optString == null || optString.length() == 0) {
            z16 = true;
        }
        if (z16) {
            return zPlanUpdateHairInfo;
        }
        try {
            JSONObject jSONObject = new JSONObject(optString);
            if (!jSONObject.has("id")) {
                return zPlanUpdateHairInfo;
            }
            long optLong = jSONObject.optLong("id");
            FLog.INSTANCE.i("FilamentNativeApp[ZPlanAvatarResourceHelper]", "getUpdateHairInfo hairItemId: " + optLong);
            return new ZPlanUpdateHairInfo(true, Long.valueOf(optLong));
        } catch (Throwable th5) {
            FLog.INSTANCE.e("FilamentNativeApp[ZPlanAvatarResourceHelper]", "getUpdateHairInfo error:", th5);
            return zPlanUpdateHairInfo;
        }
    }

    public static /* synthetic */ JSONObject p(ZPlanAvatarResourceHelper zPlanAvatarResourceHelper, ReloadAvatarResourceModel reloadAvatarResourceModel, JSONObject jSONObject, boolean z16, boolean z17, boolean z18, com.tencent.zplan.zplantracing.c cVar, int i3, Object obj) {
        boolean z19;
        boolean z26;
        com.tencent.zplan.zplantracing.c cVar2;
        if ((i3 & 8) != 0) {
            z19 = false;
        } else {
            z19 = z17;
        }
        if ((i3 & 16) != 0) {
            z26 = false;
        } else {
            z26 = z18;
        }
        if ((i3 & 32) != 0) {
            cVar2 = null;
        } else {
            cVar2 = cVar;
        }
        return zPlanAvatarResourceHelper.o(reloadAvatarResourceModel, jSONObject, z16, z19, z26, cVar2);
    }

    private final JSONObject q(Map<String, String> avatarSlotGltfs, Map<String, MakeUpConfig> makeupSlotTextures, com.tencent.filament.zplan.avatar.model.a colorSlotInfo, JSONObject target) {
        JSONObject jSONObject = new JSONObject();
        for (Map.Entry<String, String> entry : avatarSlotGltfs.entrySet()) {
            jSONObject.put(entry.getKey(), entry.getValue());
        }
        JSONObject jSONObject2 = new JSONObject();
        jSONObject2.put("slotGltfMap", jSONObject);
        target.put("dressUpInfo", jSONObject2);
        JSONObject jSONObject3 = new JSONObject();
        for (Map.Entry<String, MakeUpConfig> entry2 : makeupSlotTextures.entrySet()) {
            jSONObject3.put(entry2.getKey(), entry2.getValue().a());
        }
        JSONObject jSONObject4 = new JSONObject();
        jSONObject4.put("slotMakeupTextureMap", jSONObject3);
        target.put("makeUpInfo", jSONObject4);
        colorSlotInfo.a(target);
        return target;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean r(JSONObject eTagJSONObject, String eTagFromChannel) {
        String str;
        boolean z16;
        boolean z17;
        String str2 = null;
        if (eTagJSONObject != null) {
            str = eTagJSONObject.optString(Headers.ETAG);
        } else {
            str = null;
        }
        if (eTagJSONObject != null) {
            str2 = eTagJSONObject.optString("filepath");
        }
        if (str != null && str.length() != 0) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (!z16) {
            if (str2 != null && str2.length() != 0) {
                z17 = false;
            } else {
                z17 = true;
            }
            if (!z17 && new File(str2).exists() && !(!Intrinsics.areEqual(str, eTagFromChannel))) {
                return false;
            }
        }
        return true;
    }

    private final boolean r0(long slotID) {
        if (slotID == AvatarSlot.cfgpb_AvatarSlot_EN_SLOT_BODY.getValue()) {
            return true;
        }
        return false;
    }

    private final boolean s0(long slot) {
        if ((AvatarSlot.cfgpb_AvatarSlot_EN_SLOT_HAT.getValue() > slot || slot > AvatarSlot.cfgpb_AvatarSlot_EN_SLOT_HAIR.getValue()) && AvatarSlot.cfgpb_AvatarSlot_EN_SLOT_MASK.getValue() != slot && AvatarSlot.cfgpb_AvatarSlot_EN_SLOT_EARRINGS.getValue() != slot && ((AvatarSlot.cfgpb_AvatarSlot_EN_SLOT_OUTLINE.getValue() > slot || slot > AvatarSlot.cfgpb_AvatarSlot_EN_SLOT_EYESOCKET.getValue()) && AvatarSlot.cfgpb_AvatarSlot_EN_SLOT_LIPSTICK.getValue() != slot && AvatarSlot.cfgpb_AvatarSlot_EN_SLOT_AEGYOSAL.getValue() != slot && AvatarSlot.cfgpb_AvatarSlot_EN_SLOT_BEARD.getValue() != slot)) {
            return false;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean t0(long slotId) {
        if (slotId >= AvatarSlot.cfgpb_AvatarSlot_EN_SLOT_OUTLINE.getValue() && slotId <= AvatarSlot.cfgpb_AvatarSlot_EN_SLOT_BEARD.getValue() && slotId != AvatarSlot.cfgpb_AvatarSlot_EN_SLOT_EYEBROW.getValue()) {
            return true;
        }
        return false;
    }

    private final void u(List<JSONObject> list, JSONArray jSONArray) {
        int length = jSONArray.length();
        if (length <= 0) {
            return;
        }
        for (int i3 = 0; i3 < length; i3++) {
            JSONObject optJSONObject = jSONArray.optJSONObject(i3);
            Intrinsics.checkNotNullExpressionValue(optJSONObject, "array.optJSONObject(i)");
            list.add(optJSONObject);
        }
    }

    private final ZPlanFAssetInfo v(long slotId, long itemId, FilamentUrlTemplate urlTemplate) {
        String replace$default;
        String makeupUrl;
        String replace$default2;
        if (!t0(slotId)) {
            replace$default = StringsKt__StringsJVMKt.replace$default(urlTemplate.getDressupUrl(), "{res_id}", String.valueOf(itemId), false, 4, (Object) null);
            return new ZPlanDressUpFAssetInfo(slotId, itemId, replace$default);
        }
        if (FilamentFeatureUtil.f106409g.f()) {
            makeupUrl = urlTemplate.getMakeupUrlV2();
        } else {
            makeupUrl = urlTemplate.getMakeupUrl();
        }
        replace$default2 = StringsKt__StringsJVMKt.replace$default(makeupUrl, "{res_id}", String.valueOf(itemId), false, 4, (Object) null);
        return new ZPlanMakeUpFAssetInfo(slotId, itemId, replace$default2);
    }

    private final String v0(FilamentUrlTemplate urlTemplate) {
        return urlTemplate.getKawaiiConfig();
    }

    private final void w(String url, FilamentUrlTemplate urlTemplate) {
        String N0;
        if (!enableCppDownload && (N0 = N0(url, urlTemplate)) != null && new File(N0).exists()) {
            FilamentFileUtil.INSTANCE.deleteDirSafely(N0);
        }
    }

    private final List<Long> x(String resBlackListJsonString) {
        boolean z16;
        JSONArray jSONArray;
        ArrayList arrayList = new ArrayList();
        FLog.INSTANCE.i("FilamentNativeApp[ZPlanAvatarResourceHelper]", "extractBlackListFromJson: " + resBlackListJsonString);
        if (resBlackListJsonString != null && resBlackListJsonString.length() != 0) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (z16) {
            return arrayList;
        }
        try {
            jSONArray = new JSONObject(resBlackListJsonString).optJSONArray("res_black_list");
        } catch (JSONException e16) {
            FLog.INSTANCE.e("FilamentNativeApp[ZPlanAvatarResourceHelper]", "extractBlackListFromJson, exception", e16);
            jSONArray = null;
        }
        if (jSONArray != null && jSONArray.length() > 0) {
            int length = jSONArray.length();
            for (int i3 = 0; i3 < length; i3++) {
                arrayList.add(Long.valueOf(jSONArray.optLong(i3)));
            }
        }
        return arrayList;
    }

    private final JSONObject x0(ReloadAvatarResourceModel avatarResource, List<Long> resourceIds) {
        JSONObject jSONObject = new JSONObject();
        JSONArray jSONArray = new JSONArray();
        JSONObject jSONObject2 = new JSONObject();
        for (ZPlanPinchFaceModel zPlanPinchFaceModel : avatarResource.s()) {
            JSONObject jSONObject3 = new JSONObject();
            jSONObject3.put("groupID", zPlanPinchFaceModel.getGroupID());
            jSONObject3.put(com.tencent.luggage.wxa.c8.c.G, zPlanPinchFaceModel.getPos());
            Unit unit = Unit.INSTANCE;
            jSONArray.mo162put(jSONObject3);
        }
        JSONArray jSONArray2 = new JSONArray();
        Iterator<Long> it = resourceIds.iterator();
        while (it.hasNext()) {
            jSONArray2.mo162put(String.valueOf(it.next().longValue()));
        }
        jSONObject2.put("control_points", jSONArray);
        jSONObject2.put("goodIDs", jSONArray2);
        jSONObject2.put("blinkRatio", 1);
        jSONObject.put("userData", jSONObject2);
        jSONObject.put("configJsonPath", avatarResource.getPinchFaceConfigPath());
        jSONObject.put("gender", EnumUserGender.INSTANCE.b(avatarResource.getGender().getValue()));
        return jSONObject;
    }

    /* JADX WARN: Removed duplicated region for block: B:29:0x0081 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:30:0x0082  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x0041  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0024  */
    @Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object A(@Nullable com.tencent.zplan.zplantracing.c cVar, @NotNull EnumUserGender enumUserGender, int i3, @NotNull FilamentUrlTemplate filamentUrlTemplate, @NotNull Continuation<? super ZPlanAction> continuation) throws FetchFileException, RuntimeException {
        ZPlanAvatarResourceHelper$fetchActionWithCpp$1 zPlanAvatarResourceHelper$fetchActionWithCpp$1;
        Object obj;
        Object coroutine_suspended;
        int i16;
        Deferred async$default;
        Deferred async$default2;
        ZPlanAvatarInterfaceResult zPlanAvatarInterfaceResult;
        Object first;
        Object first2;
        try {
            if (continuation instanceof ZPlanAvatarResourceHelper$fetchActionWithCpp$1) {
                zPlanAvatarResourceHelper$fetchActionWithCpp$1 = (ZPlanAvatarResourceHelper$fetchActionWithCpp$1) continuation;
                int i17 = zPlanAvatarResourceHelper$fetchActionWithCpp$1.label;
                if ((i17 & Integer.MIN_VALUE) != 0) {
                    zPlanAvatarResourceHelper$fetchActionWithCpp$1.label = i17 - Integer.MIN_VALUE;
                    obj = zPlanAvatarResourceHelper$fetchActionWithCpp$1.result;
                    coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    i16 = zPlanAvatarResourceHelper$fetchActionWithCpp$1.label;
                    boolean z16 = true;
                    if (i16 == 0) {
                        if (i16 != 1) {
                            if (i16 == 2) {
                                zPlanAvatarInterfaceResult = (ZPlanAvatarInterfaceResult) zPlanAvatarResourceHelper$fetchActionWithCpp$1.L$0;
                                ResultKt.throwOnFailure(obj);
                                ZPlanAvatarInterfaceResult zPlanAvatarInterfaceResult2 = (ZPlanAvatarInterfaceResult) obj;
                                String result = zPlanAvatarInterfaceResult.getResult();
                                String result2 = zPlanAvatarInterfaceResult2.getResult();
                                first = ArraysKt___ArraysKt.first(zPlanAvatarInterfaceResult.getAllFiles());
                                String url = ((ZPlanAvatarFileDownloadDescriptor) first).getUrl();
                                first2 = ArraysKt___ArraysKt.first(zPlanAvatarInterfaceResult2.getAllFiles());
                                ZPlanAction zPlanAction = new ZPlanAction(result, result2, url, ((ZPlanAvatarFileDownloadDescriptor) first2).getUrl());
                                if (!zPlanAvatarInterfaceResult.isDownload() && !zPlanAvatarInterfaceResult2.isDownload()) {
                                    z16 = false;
                                }
                                zPlanAction.f(z16);
                                return zPlanAction;
                            }
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        async$default2 = (Deferred) zPlanAvatarResourceHelper$fetchActionWithCpp$1.L$0;
                        ResultKt.throwOnFailure(obj);
                    } else {
                        ResultKt.throwOnFailure(obj);
                        CoroutineScope CoroutineScope = CoroutineScopeKt.CoroutineScope(Dispatchers.getIO());
                        async$default = BuildersKt__Builders_commonKt.async$default(CoroutineScope, null, null, new ZPlanAvatarResourceHelper$fetchActionWithCpp$facePathDeferred$1(i3, enumUserGender, null), 3, null);
                        async$default2 = BuildersKt__Builders_commonKt.async$default(CoroutineScope, null, null, new ZPlanAvatarResourceHelper$fetchActionWithCpp$bodyPathDeferred$1(i3, enumUserGender, null), 3, null);
                        zPlanAvatarResourceHelper$fetchActionWithCpp$1.L$0 = async$default2;
                        zPlanAvatarResourceHelper$fetchActionWithCpp$1.label = 1;
                        obj = async$default.await(zPlanAvatarResourceHelper$fetchActionWithCpp$1);
                        if (obj == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                    }
                    ZPlanAvatarInterfaceResult zPlanAvatarInterfaceResult3 = (ZPlanAvatarInterfaceResult) obj;
                    zPlanAvatarResourceHelper$fetchActionWithCpp$1.L$0 = zPlanAvatarInterfaceResult3;
                    zPlanAvatarResourceHelper$fetchActionWithCpp$1.label = 2;
                    obj = async$default2.await(zPlanAvatarResourceHelper$fetchActionWithCpp$1);
                    if (obj != coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    zPlanAvatarInterfaceResult = zPlanAvatarInterfaceResult3;
                    ZPlanAvatarInterfaceResult zPlanAvatarInterfaceResult22 = (ZPlanAvatarInterfaceResult) obj;
                    String result3 = zPlanAvatarInterfaceResult.getResult();
                    String result22 = zPlanAvatarInterfaceResult22.getResult();
                    first = ArraysKt___ArraysKt.first(zPlanAvatarInterfaceResult.getAllFiles());
                    String url2 = ((ZPlanAvatarFileDownloadDescriptor) first).getUrl();
                    first2 = ArraysKt___ArraysKt.first(zPlanAvatarInterfaceResult22.getAllFiles());
                    ZPlanAction zPlanAction2 = new ZPlanAction(result3, result22, url2, ((ZPlanAvatarFileDownloadDescriptor) first2).getUrl());
                    if (!zPlanAvatarInterfaceResult.isDownload()) {
                        z16 = false;
                    }
                    zPlanAction2.f(z16);
                    return zPlanAction2;
                }
            }
            if (i16 == 0) {
            }
            ZPlanAvatarInterfaceResult zPlanAvatarInterfaceResult32 = (ZPlanAvatarInterfaceResult) obj;
            zPlanAvatarResourceHelper$fetchActionWithCpp$1.L$0 = zPlanAvatarInterfaceResult32;
            zPlanAvatarResourceHelper$fetchActionWithCpp$1.label = 2;
            obj = async$default2.await(zPlanAvatarResourceHelper$fetchActionWithCpp$1);
            if (obj != coroutine_suspended) {
            }
        } catch (ZPlanAvatarServiceException e16) {
            throw new FetchFileException(FetchFileException.Type.DOWNLOAD_FAIL, e16.getError().getErrorCode().getValue(), String.valueOf(e16.getError().getErrorMsg()), "");
        }
        zPlanAvatarResourceHelper$fetchActionWithCpp$1 = new ZPlanAvatarResourceHelper$fetchActionWithCpp$1(this, continuation);
        obj = zPlanAvatarResourceHelper$fetchActionWithCpp$1.result;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i16 = zPlanAvatarResourceHelper$fetchActionWithCpp$1.label;
        boolean z162 = true;
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x015f  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x016b  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0178  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x018c  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x014e A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:40:0x014f  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x0072  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x002f  */
    @Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object B(@Nullable com.tencent.zplan.zplantracing.c cVar, @NotNull EnumUserGender enumUserGender, @NotNull String str, @NotNull String str2, @NotNull FilamentUrlTemplate filamentUrlTemplate, @NotNull Continuation<? super ZPlanAction> continuation) throws FetchFileException, RuntimeException {
        ZPlanAvatarResourceHelper$fetchActionWithPath$1 zPlanAvatarResourceHelper$fetchActionWithPath$1;
        Object coroutine_suspended;
        int i3;
        com.tencent.zplan.zplantracing.b startSpan;
        String replace$default;
        String replace$default2;
        String str3;
        Resource resource;
        FilamentUrlTemplate filamentUrlTemplate2;
        com.tencent.zplan.zplantracing.b bVar;
        CoroutineScope coroutineScope;
        Deferred async$default;
        String str4;
        CoroutineScope coroutineScope2;
        Deferred async$default2;
        Object await;
        String str5;
        boolean z16;
        String str6;
        boolean z17;
        if (continuation instanceof ZPlanAvatarResourceHelper$fetchActionWithPath$1) {
            zPlanAvatarResourceHelper$fetchActionWithPath$1 = (ZPlanAvatarResourceHelper$fetchActionWithPath$1) continuation;
            int i16 = zPlanAvatarResourceHelper$fetchActionWithPath$1.label;
            if ((i16 & Integer.MIN_VALUE) != 0) {
                zPlanAvatarResourceHelper$fetchActionWithPath$1.label = i16 - Integer.MIN_VALUE;
                ZPlanAvatarResourceHelper$fetchActionWithPath$1 zPlanAvatarResourceHelper$fetchActionWithPath$12 = zPlanAvatarResourceHelper$fetchActionWithPath$1;
                Object obj = zPlanAvatarResourceHelper$fetchActionWithPath$12.result;
                coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i3 = zPlanAvatarResourceHelper$fetchActionWithPath$12.label;
                boolean z18 = true;
                if (i3 == 0) {
                    if (i3 != 1) {
                        if (i3 != 2) {
                            if (i3 == 3) {
                                z16 = zPlanAvatarResourceHelper$fetchActionWithPath$12.Z$0;
                                str6 = (String) zPlanAvatarResourceHelper$fetchActionWithPath$12.L$3;
                                str3 = (String) zPlanAvatarResourceHelper$fetchActionWithPath$12.L$2;
                                str5 = (String) zPlanAvatarResourceHelper$fetchActionWithPath$12.L$1;
                                bVar = (com.tencent.zplan.zplantracing.b) zPlanAvatarResourceHelper$fetchActionWithPath$12.L$0;
                                ResultKt.throwOnFailure(obj);
                                Resource resource2 = (Resource) obj;
                                String path = resource2.getPath();
                                boolean downloadFromNet = resource2.getDownloadFromNet();
                                if (bVar != null) {
                                    bVar.e("faceDownload", String.valueOf(z16));
                                }
                                if (bVar != null) {
                                    bVar.e("bodyDownload", String.valueOf(downloadFromNet));
                                }
                                if (bVar != null) {
                                    if (!z16 && !downloadFromNet) {
                                        z17 = false;
                                    } else {
                                        z17 = true;
                                    }
                                    bVar.e("downloadFromNet", String.valueOf(z17));
                                }
                                if (bVar != null) {
                                    bVar.b();
                                }
                                ZPlanAction zPlanAction = new ZPlanAction(str6, path, str5, str3);
                                if (!z16 && !downloadFromNet) {
                                    z18 = false;
                                }
                                zPlanAction.f(z18);
                                return zPlanAction;
                            }
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        coroutineScope2 = (CoroutineScope) zPlanAvatarResourceHelper$fetchActionWithPath$12.L$4;
                        str3 = (String) zPlanAvatarResourceHelper$fetchActionWithPath$12.L$3;
                        str4 = (String) zPlanAvatarResourceHelper$fetchActionWithPath$12.L$2;
                        startSpan = (com.tencent.zplan.zplantracing.b) zPlanAvatarResourceHelper$fetchActionWithPath$12.L$1;
                        filamentUrlTemplate2 = (FilamentUrlTemplate) zPlanAvatarResourceHelper$fetchActionWithPath$12.L$0;
                        ResultKt.throwOnFailure(obj);
                        resource = (Resource) obj;
                        com.tencent.zplan.zplantracing.b bVar2 = startSpan;
                        coroutineScope = coroutineScope2;
                        replace$default = str4;
                        bVar = bVar2;
                    } else {
                        ResultKt.throwOnFailure(obj);
                        return obj;
                    }
                } else {
                    ResultKt.throwOnFailure(obj);
                    if (enableCppDownload) {
                        zPlanAvatarResourceHelper$fetchActionWithPath$12.label = 1;
                        obj = C(cVar, enumUserGender, str, str2, filamentUrlTemplate, zPlanAvatarResourceHelper$fetchActionWithPath$12);
                        if (obj == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        return obj;
                    }
                    startSpan = ZPlanSpanFactory.INSTANCE.startSpan("fetchActionWithPath", cVar);
                    String animPathUrl = filamentUrlTemplate.getAnimPathUrl();
                    if (!TextUtils.isEmpty(animPathUrl)) {
                        replace$default = StringsKt__StringsJVMKt.replace$default(animPathUrl, "{action_path}", str, false, 4, (Object) null);
                        replace$default2 = StringsKt__StringsJVMKt.replace$default(animPathUrl, "{action_path}", str2, false, 4, (Object) null);
                        CoroutineScope CoroutineScope = CoroutineScopeKt.CoroutineScope(Dispatchers.getIO());
                        if (!TextUtils.isEmpty(str)) {
                            async$default = BuildersKt__Builders_commonKt.async$default(CoroutineScope, null, null, new ZPlanAvatarResourceHelper$fetchActionWithPath$facePathDeferred$1(startSpan, replace$default, filamentUrlTemplate, null), 3, null);
                            zPlanAvatarResourceHelper$fetchActionWithPath$12.L$0 = filamentUrlTemplate;
                            zPlanAvatarResourceHelper$fetchActionWithPath$12.L$1 = startSpan;
                            zPlanAvatarResourceHelper$fetchActionWithPath$12.L$2 = replace$default;
                            zPlanAvatarResourceHelper$fetchActionWithPath$12.L$3 = replace$default2;
                            zPlanAvatarResourceHelper$fetchActionWithPath$12.L$4 = CoroutineScope;
                            zPlanAvatarResourceHelper$fetchActionWithPath$12.label = 2;
                            Object await2 = async$default.await(zPlanAvatarResourceHelper$fetchActionWithPath$12);
                            if (await2 == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                            str3 = replace$default2;
                            obj = await2;
                            str4 = replace$default;
                            coroutineScope2 = CoroutineScope;
                            filamentUrlTemplate2 = filamentUrlTemplate;
                            resource = (Resource) obj;
                            com.tencent.zplan.zplantracing.b bVar22 = startSpan;
                            coroutineScope = coroutineScope2;
                            replace$default = str4;
                            bVar = bVar22;
                        } else {
                            str3 = replace$default2;
                            resource = new Resource(null, false, false, 7, null);
                            filamentUrlTemplate2 = filamentUrlTemplate;
                            bVar = startSpan;
                            coroutineScope = CoroutineScope;
                        }
                    } else {
                        throw new RuntimeException("fetchActionWithPath, animTemplate is empty");
                    }
                }
                String path2 = resource.getPath();
                boolean downloadFromNet2 = resource.getDownloadFromNet();
                async$default2 = BuildersKt__Builders_commonKt.async$default(coroutineScope, null, null, new ZPlanAvatarResourceHelper$fetchActionWithPath$bodyPathDeferred$1(bVar, str3, filamentUrlTemplate2, null), 3, null);
                zPlanAvatarResourceHelper$fetchActionWithPath$12.L$0 = bVar;
                zPlanAvatarResourceHelper$fetchActionWithPath$12.L$1 = replace$default;
                zPlanAvatarResourceHelper$fetchActionWithPath$12.L$2 = str3;
                zPlanAvatarResourceHelper$fetchActionWithPath$12.L$3 = path2;
                zPlanAvatarResourceHelper$fetchActionWithPath$12.L$4 = null;
                zPlanAvatarResourceHelper$fetchActionWithPath$12.Z$0 = downloadFromNet2;
                zPlanAvatarResourceHelper$fetchActionWithPath$12.label = 3;
                await = async$default2.await(zPlanAvatarResourceHelper$fetchActionWithPath$12);
                if (await != coroutine_suspended) {
                    return coroutine_suspended;
                }
                str5 = replace$default;
                z16 = downloadFromNet2;
                obj = await;
                str6 = path2;
                Resource resource22 = (Resource) obj;
                String path3 = resource22.getPath();
                boolean downloadFromNet3 = resource22.getDownloadFromNet();
                if (bVar != null) {
                }
                if (bVar != null) {
                }
                if (bVar != null) {
                }
                if (bVar != null) {
                }
                ZPlanAction zPlanAction2 = new ZPlanAction(str6, path3, str5, str3);
                if (!z16) {
                    z18 = false;
                }
                zPlanAction2.f(z18);
                return zPlanAction2;
            }
        }
        zPlanAvatarResourceHelper$fetchActionWithPath$1 = new ZPlanAvatarResourceHelper$fetchActionWithPath$1(this, continuation);
        ZPlanAvatarResourceHelper$fetchActionWithPath$1 zPlanAvatarResourceHelper$fetchActionWithPath$122 = zPlanAvatarResourceHelper$fetchActionWithPath$1;
        Object obj2 = zPlanAvatarResourceHelper$fetchActionWithPath$122.result;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i3 = zPlanAvatarResourceHelper$fetchActionWithPath$122.label;
        boolean z182 = true;
        if (i3 == 0) {
        }
        String path22 = resource.getPath();
        boolean downloadFromNet22 = resource.getDownloadFromNet();
        async$default2 = BuildersKt__Builders_commonKt.async$default(coroutineScope, null, null, new ZPlanAvatarResourceHelper$fetchActionWithPath$bodyPathDeferred$1(bVar, str3, filamentUrlTemplate2, null), 3, null);
        zPlanAvatarResourceHelper$fetchActionWithPath$122.L$0 = bVar;
        zPlanAvatarResourceHelper$fetchActionWithPath$122.L$1 = replace$default;
        zPlanAvatarResourceHelper$fetchActionWithPath$122.L$2 = str3;
        zPlanAvatarResourceHelper$fetchActionWithPath$122.L$3 = path22;
        zPlanAvatarResourceHelper$fetchActionWithPath$122.L$4 = null;
        zPlanAvatarResourceHelper$fetchActionWithPath$122.Z$0 = downloadFromNet22;
        zPlanAvatarResourceHelper$fetchActionWithPath$122.label = 3;
        await = async$default2.await(zPlanAvatarResourceHelper$fetchActionWithPath$122);
        if (await != coroutine_suspended) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:61:0x016a A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:62:0x016b  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x00ba  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0044  */
    @Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object C(@Nullable com.tencent.zplan.zplantracing.c cVar, @NotNull EnumUserGender enumUserGender, @NotNull String str, @NotNull String str2, @NotNull FilamentUrlTemplate filamentUrlTemplate, @NotNull Continuation<? super ZPlanAction> continuation) throws FetchFileException, RuntimeException {
        ZPlanAvatarResourceHelper$fetchActionWithPathWithCpp$1 zPlanAvatarResourceHelper$fetchActionWithPathWithCpp$1;
        Object obj;
        Object coroutine_suspended;
        int i3;
        Ref.BooleanRef booleanRef;
        String path;
        String str3;
        Ref.BooleanRef booleanRef2;
        Ref.BooleanRef booleanRef3;
        Object first;
        ZPlanAvatarServiceException e16;
        String str4;
        String str5;
        Exception e17;
        String str6;
        ZPlanAvatarInterfaceResult zPlanAvatarInterfaceResult;
        Object first2;
        boolean z16;
        EnumUserGender enumUserGender2 = enumUserGender;
        String str7 = str;
        String str8 = str2;
        if (continuation instanceof ZPlanAvatarResourceHelper$fetchActionWithPathWithCpp$1) {
            zPlanAvatarResourceHelper$fetchActionWithPathWithCpp$1 = (ZPlanAvatarResourceHelper$fetchActionWithPathWithCpp$1) continuation;
            int i16 = zPlanAvatarResourceHelper$fetchActionWithPathWithCpp$1.label;
            if ((i16 & Integer.MIN_VALUE) != 0) {
                zPlanAvatarResourceHelper$fetchActionWithPathWithCpp$1.label = i16 - Integer.MIN_VALUE;
                obj = zPlanAvatarResourceHelper$fetchActionWithPathWithCpp$1.result;
                coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i3 = zPlanAvatarResourceHelper$fetchActionWithPathWithCpp$1.label;
                if (i3 == 0) {
                    if (i3 != 1) {
                        if (i3 == 2) {
                            Ref.BooleanRef booleanRef4 = (Ref.BooleanRef) zPlanAvatarResourceHelper$fetchActionWithPathWithCpp$1.L$5;
                            String str9 = (String) zPlanAvatarResourceHelper$fetchActionWithPathWithCpp$1.L$4;
                            String str10 = (String) zPlanAvatarResourceHelper$fetchActionWithPathWithCpp$1.L$3;
                            String str11 = (String) zPlanAvatarResourceHelper$fetchActionWithPathWithCpp$1.L$2;
                            String str12 = (String) zPlanAvatarResourceHelper$fetchActionWithPathWithCpp$1.L$1;
                            EnumUserGender enumUserGender3 = (EnumUserGender) zPlanAvatarResourceHelper$fetchActionWithPathWithCpp$1.L$0;
                            try {
                                ResultKt.throwOnFailure(obj);
                                path = str9;
                                str7 = str12;
                                str3 = str10;
                                str8 = str11;
                                booleanRef3 = booleanRef4;
                                enumUserGender2 = enumUserGender3;
                                zPlanAvatarInterfaceResult = (ZPlanAvatarInterfaceResult) obj;
                                first2 = ArraysKt___ArraysKt.first(zPlanAvatarInterfaceResult.getAllFiles());
                                String url = ((ZPlanAvatarFileDownloadDescriptor) first2).getUrl();
                                FLog fLog = FLog.INSTANCE;
                                str4 = "";
                            } catch (ZPlanAvatarServiceException e18) {
                                e16 = e18;
                                enumUserGender2 = enumUserGender3;
                                str8 = str11;
                                str7 = str12;
                                str4 = "";
                                str5 = ", e:";
                                FLog.INSTANCE.e("FilamentNativeApp[ZPlanAvatarResourceHelper]V2", "fetchActionWithPathWithCpp fail. gender:" + enumUserGender2 + ", faceActionPath:" + str7 + ", bodyActionPath:" + str8 + str5 + e16);
                                throw new FetchFileException(FetchFileException.Type.FILE_IS_BROKEN, e16.getError().getErrorCode().getValue(), e16.getError().getErrorMsg() + " gender:" + enumUserGender2 + ", faceActionPath:" + str7 + ", bodyActionPath:" + str8, str4);
                            } catch (Exception e19) {
                                e17 = e19;
                                enumUserGender2 = enumUserGender3;
                                str8 = str11;
                                str7 = str12;
                                str6 = ", e:";
                                FLog.INSTANCE.e("FilamentNativeApp[ZPlanAvatarResourceHelper]V2", "fetchActionWithPathWithCpp fail. gender:" + enumUserGender2 + ", faceActionPath:" + str7 + ", bodyActionPath:" + str8 + str6 + e17);
                                throw e17;
                            }
                            try {
                                StringBuilder sb5 = new StringBuilder();
                                str6 = ", e:";
                                try {
                                    sb5.append("fetchActionWithPathWithCpp succ, ");
                                    sb5.append("gender:");
                                    sb5.append(enumUserGender2);
                                    sb5.append(", faceActionPath:");
                                    sb5.append(str7);
                                    sb5.append(", bodyActionPath:");
                                    sb5.append(str8);
                                    fLog.i("FilamentNativeApp[ZPlanAvatarResourceHelper]V2", sb5.toString());
                                    ZPlanAction zPlanAction = new ZPlanAction(path, zPlanAvatarInterfaceResult.getResult(), str3, url);
                                    if (!booleanRef3.element && !zPlanAvatarInterfaceResult.isDownload()) {
                                        z16 = false;
                                        zPlanAction.f(z16);
                                        return zPlanAction;
                                    }
                                    z16 = true;
                                    zPlanAction.f(z16);
                                    return zPlanAction;
                                } catch (ZPlanAvatarServiceException e26) {
                                    e16 = e26;
                                    str5 = str6;
                                    FLog.INSTANCE.e("FilamentNativeApp[ZPlanAvatarResourceHelper]V2", "fetchActionWithPathWithCpp fail. gender:" + enumUserGender2 + ", faceActionPath:" + str7 + ", bodyActionPath:" + str8 + str5 + e16);
                                    throw new FetchFileException(FetchFileException.Type.FILE_IS_BROKEN, e16.getError().getErrorCode().getValue(), e16.getError().getErrorMsg() + " gender:" + enumUserGender2 + ", faceActionPath:" + str7 + ", bodyActionPath:" + str8, str4);
                                } catch (Exception e27) {
                                    e17 = e27;
                                    FLog.INSTANCE.e("FilamentNativeApp[ZPlanAvatarResourceHelper]V2", "fetchActionWithPathWithCpp fail. gender:" + enumUserGender2 + ", faceActionPath:" + str7 + ", bodyActionPath:" + str8 + str6 + e17);
                                    throw e17;
                                }
                            } catch (ZPlanAvatarServiceException e28) {
                                e16 = e28;
                                str5 = ", e:";
                                FLog.INSTANCE.e("FilamentNativeApp[ZPlanAvatarResourceHelper]V2", "fetchActionWithPathWithCpp fail. gender:" + enumUserGender2 + ", faceActionPath:" + str7 + ", bodyActionPath:" + str8 + str5 + e16);
                                throw new FetchFileException(FetchFileException.Type.FILE_IS_BROKEN, e16.getError().getErrorCode().getValue(), e16.getError().getErrorMsg() + " gender:" + enumUserGender2 + ", faceActionPath:" + str7 + ", bodyActionPath:" + str8, str4);
                            }
                        }
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    Ref.BooleanRef booleanRef5 = (Ref.BooleanRef) zPlanAvatarResourceHelper$fetchActionWithPathWithCpp$1.L$3;
                    String str13 = (String) zPlanAvatarResourceHelper$fetchActionWithPathWithCpp$1.L$2;
                    String str14 = (String) zPlanAvatarResourceHelper$fetchActionWithPathWithCpp$1.L$1;
                    EnumUserGender enumUserGender4 = (EnumUserGender) zPlanAvatarResourceHelper$fetchActionWithPathWithCpp$1.L$0;
                    try {
                        ResultKt.throwOnFailure(obj);
                        booleanRef2 = booleanRef5;
                        enumUserGender2 = enumUserGender4;
                        str8 = str13;
                        str7 = str14;
                    } catch (ZPlanAvatarServiceException e29) {
                        e16 = e29;
                        enumUserGender2 = enumUserGender4;
                        str4 = "";
                        str5 = ", e:";
                        str8 = str13;
                        str7 = str14;
                        FLog.INSTANCE.e("FilamentNativeApp[ZPlanAvatarResourceHelper]V2", "fetchActionWithPathWithCpp fail. gender:" + enumUserGender2 + ", faceActionPath:" + str7 + ", bodyActionPath:" + str8 + str5 + e16);
                        throw new FetchFileException(FetchFileException.Type.FILE_IS_BROKEN, e16.getError().getErrorCode().getValue(), e16.getError().getErrorMsg() + " gender:" + enumUserGender2 + ", faceActionPath:" + str7 + ", bodyActionPath:" + str8, str4);
                    } catch (Exception e36) {
                        e17 = e36;
                        enumUserGender2 = enumUserGender4;
                        str6 = ", e:";
                        str8 = str13;
                        str7 = str14;
                        FLog.INSTANCE.e("FilamentNativeApp[ZPlanAvatarResourceHelper]V2", "fetchActionWithPathWithCpp fail. gender:" + enumUserGender2 + ", faceActionPath:" + str7 + ", bodyActionPath:" + str8 + str6 + e17);
                        throw e17;
                    }
                } else {
                    ResultKt.throwOnFailure(obj);
                    FLog fLog2 = FLog.INSTANCE;
                    fLog2.i("FilamentNativeApp[ZPlanAvatarResourceHelper]V2", "fetchActionWithPathWithCpp, gender:" + enumUserGender2 + ", faceActionPath:" + str7 + ", bodyActionPath:" + str8);
                    if (!TextUtils.isEmpty(filamentUrlTemplate.getAnimPathUrl())) {
                        try {
                            try {
                                CoroutineScopeKt.CoroutineScope(Dispatchers.getIO());
                                booleanRef = new Ref.BooleanRef();
                                Resource resource = new Resource(null, false, false, 7, null);
                                path = resource.getPath();
                                booleanRef.element = resource.getDownloadFromNet();
                                if (TextUtils.isEmpty(str)) {
                                    str3 = "";
                                    ZPlanAvatarService zPlanAvatarService = avatarService;
                                    zPlanAvatarResourceHelper$fetchActionWithPathWithCpp$1.L$0 = enumUserGender2;
                                    zPlanAvatarResourceHelper$fetchActionWithPathWithCpp$1.L$1 = str7;
                                    zPlanAvatarResourceHelper$fetchActionWithPathWithCpp$1.L$2 = str8;
                                    zPlanAvatarResourceHelper$fetchActionWithPathWithCpp$1.L$3 = str3;
                                    zPlanAvatarResourceHelper$fetchActionWithPathWithCpp$1.L$4 = path;
                                    zPlanAvatarResourceHelper$fetchActionWithPathWithCpp$1.L$5 = booleanRef;
                                    Ref.BooleanRef booleanRef6 = booleanRef;
                                    zPlanAvatarResourceHelper$fetchActionWithPathWithCpp$1.label = 2;
                                    obj = zPlanAvatarService.x(str8, zPlanAvatarResourceHelper$fetchActionWithPathWithCpp$1);
                                    if (obj == coroutine_suspended) {
                                        return coroutine_suspended;
                                    }
                                    booleanRef3 = booleanRef6;
                                    zPlanAvatarInterfaceResult = (ZPlanAvatarInterfaceResult) obj;
                                    first2 = ArraysKt___ArraysKt.first(zPlanAvatarInterfaceResult.getAllFiles());
                                    String url2 = ((ZPlanAvatarFileDownloadDescriptor) first2).getUrl();
                                    FLog fLog3 = FLog.INSTANCE;
                                    str4 = "";
                                    StringBuilder sb52 = new StringBuilder();
                                    str6 = ", e:";
                                    sb52.append("fetchActionWithPathWithCpp succ, ");
                                    sb52.append("gender:");
                                    sb52.append(enumUserGender2);
                                    sb52.append(", faceActionPath:");
                                    sb52.append(str7);
                                    sb52.append(", bodyActionPath:");
                                    sb52.append(str8);
                                    fLog3.i("FilamentNativeApp[ZPlanAvatarResourceHelper]V2", sb52.toString());
                                    ZPlanAction zPlanAction2 = new ZPlanAction(path, zPlanAvatarInterfaceResult.getResult(), str3, url2);
                                    if (!booleanRef3.element) {
                                        z16 = false;
                                        zPlanAction2.f(z16);
                                        return zPlanAction2;
                                    }
                                    z16 = true;
                                    zPlanAction2.f(z16);
                                    return zPlanAction2;
                                }
                                ZPlanAvatarService zPlanAvatarService2 = avatarService;
                                zPlanAvatarResourceHelper$fetchActionWithPathWithCpp$1.L$0 = enumUserGender2;
                                zPlanAvatarResourceHelper$fetchActionWithPathWithCpp$1.L$1 = str7;
                                zPlanAvatarResourceHelper$fetchActionWithPathWithCpp$1.L$2 = str8;
                                zPlanAvatarResourceHelper$fetchActionWithPathWithCpp$1.L$3 = booleanRef;
                                zPlanAvatarResourceHelper$fetchActionWithPathWithCpp$1.label = 1;
                                Object x16 = zPlanAvatarService2.x(str7, zPlanAvatarResourceHelper$fetchActionWithPathWithCpp$1);
                                if (x16 == coroutine_suspended) {
                                    return coroutine_suspended;
                                }
                                booleanRef2 = booleanRef;
                                obj = x16;
                            } catch (ZPlanAvatarServiceException e37) {
                                e16 = e37;
                                str4 = "";
                                str5 = ", e:";
                                FLog.INSTANCE.e("FilamentNativeApp[ZPlanAvatarResourceHelper]V2", "fetchActionWithPathWithCpp fail. gender:" + enumUserGender2 + ", faceActionPath:" + str7 + ", bodyActionPath:" + str8 + str5 + e16);
                                throw new FetchFileException(FetchFileException.Type.FILE_IS_BROKEN, e16.getError().getErrorCode().getValue(), e16.getError().getErrorMsg() + " gender:" + enumUserGender2 + ", faceActionPath:" + str7 + ", bodyActionPath:" + str8, str4);
                            }
                        } catch (Exception e38) {
                            e17 = e38;
                            str6 = ", e:";
                            FLog.INSTANCE.e("FilamentNativeApp[ZPlanAvatarResourceHelper]V2", "fetchActionWithPathWithCpp fail. gender:" + enumUserGender2 + ", faceActionPath:" + str7 + ", bodyActionPath:" + str8 + str6 + e17);
                            throw e17;
                        }
                    } else {
                        fLog2.e("FilamentNativeApp[ZPlanAvatarResourceHelper]V2", "fetchActionWithPathWithCpp fail, animTemplate is empty. gender:" + enumUserGender2 + ", faceActionPath:" + str7 + ", bodyActionPath:" + str8);
                        throw new RuntimeException("fetchActionWithPathWithCpp, animTemplate is empty");
                    }
                }
                ZPlanAvatarInterfaceResult zPlanAvatarInterfaceResult2 = (ZPlanAvatarInterfaceResult) obj;
                String result = zPlanAvatarInterfaceResult2.getResult();
                first = ArraysKt___ArraysKt.first(zPlanAvatarInterfaceResult2.getAllFiles());
                String url3 = ((ZPlanAvatarFileDownloadDescriptor) first).getUrl();
                booleanRef2.element = zPlanAvatarInterfaceResult2.isDownload();
                booleanRef = booleanRef2;
                path = result;
                str3 = url3;
                ZPlanAvatarService zPlanAvatarService3 = avatarService;
                zPlanAvatarResourceHelper$fetchActionWithPathWithCpp$1.L$0 = enumUserGender2;
                zPlanAvatarResourceHelper$fetchActionWithPathWithCpp$1.L$1 = str7;
                zPlanAvatarResourceHelper$fetchActionWithPathWithCpp$1.L$2 = str8;
                zPlanAvatarResourceHelper$fetchActionWithPathWithCpp$1.L$3 = str3;
                zPlanAvatarResourceHelper$fetchActionWithPathWithCpp$1.L$4 = path;
                zPlanAvatarResourceHelper$fetchActionWithPathWithCpp$1.L$5 = booleanRef;
                Ref.BooleanRef booleanRef62 = booleanRef;
                zPlanAvatarResourceHelper$fetchActionWithPathWithCpp$1.label = 2;
                obj = zPlanAvatarService3.x(str8, zPlanAvatarResourceHelper$fetchActionWithPathWithCpp$1);
                if (obj == coroutine_suspended) {
                }
            }
        }
        zPlanAvatarResourceHelper$fetchActionWithPathWithCpp$1 = new ZPlanAvatarResourceHelper$fetchActionWithPathWithCpp$1(this, continuation);
        obj = zPlanAvatarResourceHelper$fetchActionWithPathWithCpp$1.result;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i3 = zPlanAvatarResourceHelper$fetchActionWithPathWithCpp$1.label;
        if (i3 == 0) {
        }
        ZPlanAvatarInterfaceResult zPlanAvatarInterfaceResult22 = (ZPlanAvatarInterfaceResult) obj;
        String result2 = zPlanAvatarInterfaceResult22.getResult();
        first = ArraysKt___ArraysKt.first(zPlanAvatarInterfaceResult22.getAllFiles());
        String url32 = ((ZPlanAvatarFileDownloadDescriptor) first).getUrl();
        booleanRef2.element = zPlanAvatarInterfaceResult22.isDownload();
        booleanRef = booleanRef2;
        path = result2;
        str3 = url32;
        ZPlanAvatarService zPlanAvatarService32 = avatarService;
        zPlanAvatarResourceHelper$fetchActionWithPathWithCpp$1.L$0 = enumUserGender2;
        zPlanAvatarResourceHelper$fetchActionWithPathWithCpp$1.L$1 = str7;
        zPlanAvatarResourceHelper$fetchActionWithPathWithCpp$1.L$2 = str8;
        zPlanAvatarResourceHelper$fetchActionWithPathWithCpp$1.L$3 = str3;
        zPlanAvatarResourceHelper$fetchActionWithPathWithCpp$1.L$4 = path;
        zPlanAvatarResourceHelper$fetchActionWithPathWithCpp$1.L$5 = booleanRef;
        Ref.BooleanRef booleanRef622 = booleanRef;
        zPlanAvatarResourceHelper$fetchActionWithPathWithCpp$1.label = 2;
        obj = zPlanAvatarService32.x(str8, zPlanAvatarResourceHelper$fetchActionWithPathWithCpp$1);
        if (obj == coroutine_suspended) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x008d A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:20:0x008e  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x005a  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x002d  */
    @Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object D(@Nullable com.tencent.zplan.zplantracing.c cVar, @NotNull JSONObject jSONObject, @NotNull FilamentUrlTemplate filamentUrlTemplate, @NotNull Continuation<? super AvatarResourceModel> continuation) throws FetchFileException, BlackListResourceException, RuntimeException {
        ZPlanAvatarResourceHelper$fetchAvatarResource$1 zPlanAvatarResourceHelper$fetchAvatarResource$1;
        Object obj;
        Object coroutine_suspended;
        int i3;
        FilamentUrlTemplate filamentUrlTemplate2;
        JSONObject jSONObject2;
        ZPlanAvatarResourceHelper zPlanAvatarResourceHelper;
        BootResourceModel bootResourceModel;
        com.tencent.zplan.zplantracing.c cVar2 = cVar;
        if (continuation instanceof ZPlanAvatarResourceHelper$fetchAvatarResource$1) {
            zPlanAvatarResourceHelper$fetchAvatarResource$1 = (ZPlanAvatarResourceHelper$fetchAvatarResource$1) continuation;
            int i16 = zPlanAvatarResourceHelper$fetchAvatarResource$1.label;
            if ((i16 & Integer.MIN_VALUE) != 0) {
                zPlanAvatarResourceHelper$fetchAvatarResource$1.label = i16 - Integer.MIN_VALUE;
                ZPlanAvatarResourceHelper$fetchAvatarResource$1 zPlanAvatarResourceHelper$fetchAvatarResource$12 = zPlanAvatarResourceHelper$fetchAvatarResource$1;
                obj = zPlanAvatarResourceHelper$fetchAvatarResource$12.result;
                coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i3 = zPlanAvatarResourceHelper$fetchAvatarResource$12.label;
                if (i3 == 0) {
                    if (i3 != 1) {
                        if (i3 == 2) {
                            bootResourceModel = (BootResourceModel) zPlanAvatarResourceHelper$fetchAvatarResource$12.L$0;
                            ResultKt.throwOnFailure(obj);
                            ReloadAvatarResourceModel reloadAvatarResourceModel = (ReloadAvatarResourceModel) obj;
                            return new AvatarResourceModel(bootResourceModel.getShaderDir(), bootResourceModel.getIndirectLightPath(), reloadAvatarResourceModel.u(), reloadAvatarResourceModel.getPinchFaceConfigPath(), reloadAvatarResourceModel.s(), reloadAvatarResourceModel.getEyelashGltfFAsset(), reloadAvatarResourceModel.getGender(), reloadAvatarResourceModel.getPantsLength(), reloadAvatarResourceModel.getShoeHeight(), bootResourceModel.getKawaiiPath(), reloadAvatarResourceModel.getBodyTypePath(), reloadAvatarResourceModel.getAiBodyRefPath(), reloadAvatarResourceModel.v(), bootResourceModel.getLutTexturePath());
                        }
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    FilamentUrlTemplate filamentUrlTemplate3 = (FilamentUrlTemplate) zPlanAvatarResourceHelper$fetchAvatarResource$12.L$3;
                    JSONObject jSONObject3 = (JSONObject) zPlanAvatarResourceHelper$fetchAvatarResource$12.L$2;
                    com.tencent.zplan.zplantracing.c cVar3 = (com.tencent.zplan.zplantracing.c) zPlanAvatarResourceHelper$fetchAvatarResource$12.L$1;
                    ZPlanAvatarResourceHelper zPlanAvatarResourceHelper2 = (ZPlanAvatarResourceHelper) zPlanAvatarResourceHelper$fetchAvatarResource$12.L$0;
                    ResultKt.throwOnFailure(obj);
                    filamentUrlTemplate2 = filamentUrlTemplate3;
                    cVar2 = cVar3;
                    zPlanAvatarResourceHelper = zPlanAvatarResourceHelper2;
                    jSONObject2 = jSONObject3;
                } else {
                    ResultKt.throwOnFailure(obj);
                    zPlanAvatarResourceHelper$fetchAvatarResource$12.L$0 = this;
                    zPlanAvatarResourceHelper$fetchAvatarResource$12.L$1 = cVar2;
                    zPlanAvatarResourceHelper$fetchAvatarResource$12.L$2 = jSONObject;
                    zPlanAvatarResourceHelper$fetchAvatarResource$12.L$3 = filamentUrlTemplate;
                    zPlanAvatarResourceHelper$fetchAvatarResource$12.label = 1;
                    Object F = F(cVar2, filamentUrlTemplate, zPlanAvatarResourceHelper$fetchAvatarResource$12);
                    if (F == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    filamentUrlTemplate2 = filamentUrlTemplate;
                    jSONObject2 = jSONObject;
                    obj = F;
                    zPlanAvatarResourceHelper = this;
                }
                BootResourceModel bootResourceModel2 = (BootResourceModel) obj;
                zPlanAvatarResourceHelper$fetchAvatarResource$12.L$0 = bootResourceModel2;
                zPlanAvatarResourceHelper$fetchAvatarResource$12.L$1 = null;
                zPlanAvatarResourceHelper$fetchAvatarResource$12.L$2 = null;
                zPlanAvatarResourceHelper$fetchAvatarResource$12.L$3 = null;
                zPlanAvatarResourceHelper$fetchAvatarResource$12.label = 2;
                obj = W(zPlanAvatarResourceHelper, cVar2, jSONObject2, filamentUrlTemplate2, false, zPlanAvatarResourceHelper$fetchAvatarResource$12, 8, null);
                if (obj != coroutine_suspended) {
                    return coroutine_suspended;
                }
                bootResourceModel = bootResourceModel2;
                ReloadAvatarResourceModel reloadAvatarResourceModel2 = (ReloadAvatarResourceModel) obj;
                return new AvatarResourceModel(bootResourceModel.getShaderDir(), bootResourceModel.getIndirectLightPath(), reloadAvatarResourceModel2.u(), reloadAvatarResourceModel2.getPinchFaceConfigPath(), reloadAvatarResourceModel2.s(), reloadAvatarResourceModel2.getEyelashGltfFAsset(), reloadAvatarResourceModel2.getGender(), reloadAvatarResourceModel2.getPantsLength(), reloadAvatarResourceModel2.getShoeHeight(), bootResourceModel.getKawaiiPath(), reloadAvatarResourceModel2.getBodyTypePath(), reloadAvatarResourceModel2.getAiBodyRefPath(), reloadAvatarResourceModel2.v(), bootResourceModel.getLutTexturePath());
            }
        }
        zPlanAvatarResourceHelper$fetchAvatarResource$1 = new ZPlanAvatarResourceHelper$fetchAvatarResource$1(this, continuation);
        ZPlanAvatarResourceHelper$fetchAvatarResource$1 zPlanAvatarResourceHelper$fetchAvatarResource$122 = zPlanAvatarResourceHelper$fetchAvatarResource$1;
        obj = zPlanAvatarResourceHelper$fetchAvatarResource$122.result;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i3 = zPlanAvatarResourceHelper$fetchAvatarResource$122.label;
        if (i3 == 0) {
        }
        BootResourceModel bootResourceModel22 = (BootResourceModel) obj;
        zPlanAvatarResourceHelper$fetchAvatarResource$122.L$0 = bootResourceModel22;
        zPlanAvatarResourceHelper$fetchAvatarResource$122.L$1 = null;
        zPlanAvatarResourceHelper$fetchAvatarResource$122.L$2 = null;
        zPlanAvatarResourceHelper$fetchAvatarResource$122.L$3 = null;
        zPlanAvatarResourceHelper$fetchAvatarResource$122.label = 2;
        obj = W(zPlanAvatarResourceHelper, cVar2, jSONObject2, filamentUrlTemplate2, false, zPlanAvatarResourceHelper$fetchAvatarResource$122, 8, null);
        if (obj != coroutine_suspended) {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Code restructure failed: missing block: B:75:0x00ca, code lost:
    
        r1 = kotlin.text.StringsKt__StringsKt.split$default((java.lang.CharSequence) r15, new java.lang.String[]{"/"}, false, 0, 6, (java.lang.Object) null);
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:14:0x01a1  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x01b9  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x01ca  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x01da  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x01a3  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x022e  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x0046  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x002b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final /* synthetic */ Object E(com.tencent.zplan.zplantracing.c cVar, JSONObject jSONObject, FilamentUrlTemplate filamentUrlTemplate, Continuation<? super Resource> continuation) {
        ZPlanAvatarResourceHelper$fetchBodyTypeWithAvatar$1 zPlanAvatarResourceHelper$fetchBodyTypeWithAvatar$1;
        Object coroutine_suspended;
        int i3;
        JSONArray jSONArray;
        String replace$default;
        com.tencent.zplan.zplantracing.b bVar;
        Ref.ObjectRef objectRef;
        String str;
        T t16;
        List split$default;
        Object last;
        boolean exists;
        boolean z16;
        boolean z17;
        boolean z18;
        if (continuation instanceof ZPlanAvatarResourceHelper$fetchBodyTypeWithAvatar$1) {
            zPlanAvatarResourceHelper$fetchBodyTypeWithAvatar$1 = (ZPlanAvatarResourceHelper$fetchBodyTypeWithAvatar$1) continuation;
            int i16 = zPlanAvatarResourceHelper$fetchBodyTypeWithAvatar$1.label;
            if ((i16 & Integer.MIN_VALUE) != 0) {
                zPlanAvatarResourceHelper$fetchBodyTypeWithAvatar$1.label = i16 - Integer.MIN_VALUE;
                ZPlanAvatarResourceHelper$fetchBodyTypeWithAvatar$1 zPlanAvatarResourceHelper$fetchBodyTypeWithAvatar$12 = zPlanAvatarResourceHelper$fetchBodyTypeWithAvatar$1;
                Object obj = zPlanAvatarResourceHelper$fetchBodyTypeWithAvatar$12.result;
                coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i3 = zPlanAvatarResourceHelper$fetchBodyTypeWithAvatar$12.label;
                boolean z19 = true;
                if (i3 == 0) {
                    if (i3 == 1) {
                        objectRef = (Ref.ObjectRef) zPlanAvatarResourceHelper$fetchBodyTypeWithAvatar$12.L$1;
                        bVar = (com.tencent.zplan.zplantracing.b) zPlanAvatarResourceHelper$fetchBodyTypeWithAvatar$12.L$0;
                        try {
                            ResultKt.throwOnFailure(obj);
                        } catch (FetchFileException e16) {
                            e = e16;
                            if (e.getType() != FetchFileException.Type.DOWNLOAD_FAIL && e.getErrorCode() == 404) {
                                if (bVar != null) {
                                    bVar.a("404, " + e.getErrorMessage());
                                }
                                return new Resource(null, true, false, 5, null);
                            }
                            if (bVar != null) {
                                bVar.a("fetch url failed, " + e.getErrorMessage());
                            }
                            FLog.INSTANCE.e("FilamentNativeApp[ZPlanAvatarResourceHelper]", "fetchBodyTypeWithAvatar error, fetch url failed", e);
                            return new Resource(null, true, false, 5, null);
                        }
                    } else {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                } else {
                    ResultKt.throwOnFailure(obj);
                    com.tencent.zplan.zplantracing.b startSpan = ZPlanSpanFactory.INSTANCE.startSpan("fetchBodyType", cVar);
                    ArrayList<JSONObject> arrayList = new ArrayList();
                    JSONObject optJSONObject = jSONObject.optJSONObject("makeup_info");
                    com.tencent.zplan.zplantracing.c cVar2 = null;
                    if (optJSONObject != null) {
                        jSONArray = optJSONObject.optJSONArray("slot_arr");
                    } else {
                        jSONArray = null;
                    }
                    if (jSONArray == null) {
                        FLog.INSTANCE.e("FilamentNativeApp[ZPlanAvatarResourceHelper]", "fetchBodyTypeWithAvatar, makeUpSlotArray empty");
                        if (startSpan != null) {
                            startSpan.a("makeUpSlotArray empty");
                        }
                        return new Resource(null, false, false, 7, null);
                    }
                    u(arrayList, jSONArray);
                    Ref.ObjectRef objectRef2 = new Ref.ObjectRef();
                    objectRef2.element = null;
                    for (JSONObject jSONObject2 : arrayList) {
                        if (f105660o.r0(jSONObject2.optLong(MiniAppReportManager2.KEY_SLOT_ID))) {
                            JSONObject optJSONObject2 = jSONObject2.optJSONObject("item_data");
                            if (optJSONObject2 != null) {
                                str = optJSONObject2.optString("model");
                            } else {
                                str = null;
                            }
                            if (str != null && split$default != null) {
                                last = CollectionsKt___CollectionsKt.last((List<? extends Object>) split$default);
                                t16 = (String) last;
                            } else {
                                t16 = 0;
                            }
                            objectRef2.element = t16;
                        }
                    }
                    if (TextUtils.isEmpty((String) objectRef2.element)) {
                        FLog.INSTANCE.e("FilamentNativeApp[ZPlanAvatarResourceHelper]", "fetchBodyTypeWithAvatar, no bodyType model");
                        if (startSpan != null) {
                            startSpan.a("no bodyType model");
                        }
                        return new Resource(null, false, false, 7, null);
                    }
                    String bodyTypeUrl = filamentUrlTemplate.getBodyTypeUrl();
                    String str2 = (String) objectRef2.element;
                    Intrinsics.checkNotNull(str2);
                    replace$default = StringsKt__StringsJVMKt.replace$default(bodyTypeUrl, "{res_name}", str2, false, 4, (Object) null);
                    if (!TextUtils.isEmpty(bodyTypeUrl) && !TextUtils.isEmpty(replace$default)) {
                        if (startSpan != null) {
                            try {
                                cVar2 = startSpan.c();
                            } catch (FetchFileException e17) {
                                e = e17;
                                bVar = startSpan;
                                if (e.getType() != FetchFileException.Type.DOWNLOAD_FAIL) {
                                }
                                if (bVar != null) {
                                }
                                FLog.INSTANCE.e("FilamentNativeApp[ZPlanAvatarResourceHelper]", "fetchBodyTypeWithAvatar error, fetch url failed", e);
                                return new Resource(null, true, false, 5, null);
                            }
                        }
                        zPlanAvatarResourceHelper$fetchBodyTypeWithAvatar$12.L$0 = startSpan;
                        zPlanAvatarResourceHelper$fetchBodyTypeWithAvatar$12.L$1 = objectRef2;
                        zPlanAvatarResourceHelper$fetchBodyTypeWithAvatar$12.label = 1;
                        obj = h0(this, cVar2, replace$default, filamentUrlTemplate, false, zPlanAvatarResourceHelper$fetchBodyTypeWithAvatar$12, 8, null);
                        if (obj == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        bVar = startSpan;
                        objectRef = objectRef2;
                    } else {
                        FLog.INSTANCE.e("FilamentNativeApp[ZPlanAvatarResourceHelper]", "bodyTypeTemplate: " + bodyTypeUrl + ", url: " + replace$default);
                        if (startSpan != null) {
                            startSpan.a("bodyTypeTemplate isEmpty or url isEmpty");
                        }
                        return new Resource(null, false, false, 7, null);
                    }
                }
                Resource resource = (Resource) obj;
                String path = resource.getPath();
                boolean downloadFromNet = resource.getDownloadFromNet();
                boolean hit304 = resource.getHit304();
                String str3 = path + '/' + ((String) objectRef.element) + ".txt";
                exists = new File(str3).exists();
                FLog fLog = FLog.INSTANCE;
                StringBuilder sb5 = new StringBuilder();
                sb5.append("fetchBodyTypeWithAvatar result=");
                if (!exists) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                sb5.append(z16);
                sb5.append(", bodyTypePath=");
                sb5.append(str3);
                fLog.i("FilamentNativeApp[ZPlanAvatarResourceHelper]", sb5.toString());
                if (bVar != null) {
                    if (downloadFromNet) {
                        z18 = true;
                    } else {
                        z18 = false;
                    }
                    bVar.e("downloadFromNet", String.valueOf(z18));
                }
                if (!exists) {
                    if (bVar != null) {
                        bVar.b();
                    }
                    if (!hit304) {
                        z19 = false;
                    }
                    return new Resource(str3, downloadFromNet, z19);
                }
                if (bVar != null) {
                    bVar.a("fileExist false");
                }
                if (hit304) {
                    z17 = true;
                } else {
                    z17 = false;
                }
                return new Resource(null, downloadFromNet, z17, 1, null);
            }
        }
        zPlanAvatarResourceHelper$fetchBodyTypeWithAvatar$1 = new ZPlanAvatarResourceHelper$fetchBodyTypeWithAvatar$1(this, continuation);
        ZPlanAvatarResourceHelper$fetchBodyTypeWithAvatar$1 zPlanAvatarResourceHelper$fetchBodyTypeWithAvatar$122 = zPlanAvatarResourceHelper$fetchBodyTypeWithAvatar$1;
        Object obj2 = zPlanAvatarResourceHelper$fetchBodyTypeWithAvatar$122.result;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i3 = zPlanAvatarResourceHelper$fetchBodyTypeWithAvatar$122.label;
        boolean z192 = true;
        if (i3 == 0) {
        }
        Resource resource2 = (Resource) obj2;
        String path2 = resource2.getPath();
        boolean downloadFromNet2 = resource2.getDownloadFromNet();
        boolean hit3042 = resource2.getHit304();
        String str32 = path2 + '/' + ((String) objectRef.element) + ".txt";
        exists = new File(str32).exists();
        FLog fLog2 = FLog.INSTANCE;
        StringBuilder sb52 = new StringBuilder();
        sb52.append("fetchBodyTypeWithAvatar result=");
        if (!exists) {
        }
        sb52.append(z16);
        sb52.append(", bodyTypePath=");
        sb52.append(str32);
        fLog2.i("FilamentNativeApp[ZPlanAvatarResourceHelper]", sb52.toString());
        if (bVar != null) {
        }
        if (!exists) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x00df  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x004b  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x002f  */
    @Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object F(@Nullable com.tencent.zplan.zplantracing.c cVar, @NotNull FilamentUrlTemplate filamentUrlTemplate, @NotNull Continuation<? super BootResourceModel> continuation) throws FetchFileException, BlackListResourceException, RuntimeException {
        ZPlanAvatarResourceHelper$fetchBootResource$1 zPlanAvatarResourceHelper$fetchBootResource$1;
        Object coroutine_suspended;
        int i3;
        String str;
        String str2;
        boolean z16;
        if (continuation instanceof ZPlanAvatarResourceHelper$fetchBootResource$1) {
            zPlanAvatarResourceHelper$fetchBootResource$1 = (ZPlanAvatarResourceHelper$fetchBootResource$1) continuation;
            int i16 = zPlanAvatarResourceHelper$fetchBootResource$1.label;
            if ((i16 & Integer.MIN_VALUE) != 0) {
                zPlanAvatarResourceHelper$fetchBootResource$1.label = i16 - Integer.MIN_VALUE;
                Object obj = zPlanAvatarResourceHelper$fetchBootResource$1.result;
                coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i3 = zPlanAvatarResourceHelper$fetchBootResource$1.label;
                if (i3 == 0) {
                    if (i3 != 1) {
                        if (i3 == 2) {
                            z16 = zPlanAvatarResourceHelper$fetchBootResource$1.Z$0;
                            str2 = (String) zPlanAvatarResourceHelper$fetchBootResource$1.L$0;
                            ResultKt.throwOnFailure(obj);
                            BootResourceModel bootResourceModel = (BootResourceModel) obj;
                            FLog.INSTANCE.i("FilamentNativeApp[ZPlanAvatarResourceHelper]", "bootResourceModel=" + bootResourceModel);
                            if (z16) {
                                bootResourceCache.a(str2, bootResourceModel);
                            }
                            return bootResourceModel;
                        }
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.throwOnFailure(obj);
                    return obj;
                }
                ResultKt.throwOnFailure(obj);
                if (enableCppDownload) {
                    zPlanAvatarResourceHelper$fetchBootResource$1.label = 1;
                    obj = H(cVar, filamentUrlTemplate, zPlanAvatarResourceHelper$fetchBootResource$1);
                    if (obj == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    return obj;
                }
                boolean c16 = FilamentFeatureUtil.f106409g.c();
                if (c16) {
                    str = filamentUrlTemplate.toString();
                    b<BootResourceModel> bVar = bootResourceCache;
                    BootResourceModel c17 = bVar.c(str);
                    if (c17 != null) {
                        if (c17.t()) {
                            BootResourceModel g16 = BootResourceModel.g(c17, null, null, null, null, 15, null);
                            g16.v(true);
                            return g16;
                        }
                        FLog.INSTANCE.w("FilamentNativeApp[ZPlanAvatarResourceHelper]", "fetchBootResource, cache inValid");
                    } else {
                        FLog.INSTANCE.i("FilamentNativeApp[ZPlanAvatarResourceHelper]", "not hit cache, bootResourceCache=" + bVar);
                    }
                    bVar.d();
                } else {
                    str = "";
                }
                zPlanAvatarResourceHelper$fetchBootResource$1.L$0 = str;
                zPlanAvatarResourceHelper$fetchBootResource$1.Z$0 = c16;
                zPlanAvatarResourceHelper$fetchBootResource$1.label = 2;
                Object G = G(cVar, filamentUrlTemplate, zPlanAvatarResourceHelper$fetchBootResource$1);
                if (G == coroutine_suspended) {
                    return coroutine_suspended;
                }
                str2 = str;
                obj = G;
                z16 = c16;
                BootResourceModel bootResourceModel2 = (BootResourceModel) obj;
                FLog.INSTANCE.i("FilamentNativeApp[ZPlanAvatarResourceHelper]", "bootResourceModel=" + bootResourceModel2);
                if (z16) {
                }
                return bootResourceModel2;
            }
        }
        zPlanAvatarResourceHelper$fetchBootResource$1 = new ZPlanAvatarResourceHelper$fetchBootResource$1(this, continuation);
        Object obj2 = zPlanAvatarResourceHelper$fetchBootResource$1.result;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i3 = zPlanAvatarResourceHelper$fetchBootResource$1.label;
        if (i3 == 0) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x0216  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0226  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x01f4 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:33:0x01f5  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x01d5 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:38:0x01d6  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x01ab A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:43:0x01ac  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x0185 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0186  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x00d5  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0033  */
    @Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object G(@Nullable com.tencent.zplan.zplantracing.c cVar, @NotNull FilamentUrlTemplate filamentUrlTemplate, @NotNull Continuation<? super BootResourceModel> continuation) throws FetchFileException, BlackListResourceException, RuntimeException {
        ZPlanAvatarResourceHelper$fetchBootResourceNotUseCache$1 zPlanAvatarResourceHelper$fetchBootResourceNotUseCache$1;
        Object coroutine_suspended;
        int i3;
        com.tencent.zplan.zplantracing.b startSpan;
        Deferred async$default;
        Deferred async$default2;
        Deferred async$default3;
        Deferred async$default4;
        Deferred async$default5;
        Deferred deferred;
        String path;
        Object await;
        Deferred deferred2;
        Deferred deferred3;
        Deferred deferred4;
        boolean z16;
        Object await2;
        String str;
        boolean z17;
        Deferred deferred5;
        Deferred deferred6;
        String str2;
        String path2;
        boolean z18;
        Deferred deferred7;
        boolean z19;
        boolean z26;
        String str3;
        boolean z27;
        boolean z28;
        String str4;
        String str5;
        com.tencent.zplan.zplantracing.b bVar;
        if (continuation instanceof ZPlanAvatarResourceHelper$fetchBootResourceNotUseCache$1) {
            zPlanAvatarResourceHelper$fetchBootResourceNotUseCache$1 = (ZPlanAvatarResourceHelper$fetchBootResourceNotUseCache$1) continuation;
            int i16 = zPlanAvatarResourceHelper$fetchBootResourceNotUseCache$1.label;
            if ((i16 & Integer.MIN_VALUE) != 0) {
                zPlanAvatarResourceHelper$fetchBootResourceNotUseCache$1.label = i16 - Integer.MIN_VALUE;
                Object obj = zPlanAvatarResourceHelper$fetchBootResourceNotUseCache$1.result;
                coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i3 = zPlanAvatarResourceHelper$fetchBootResourceNotUseCache$1.label;
                boolean z29 = true;
                if (i3 == 0) {
                    if (i3 != 1) {
                        if (i3 != 2) {
                            if (i3 != 3) {
                                if (i3 != 4) {
                                    if (i3 == 5) {
                                        z26 = zPlanAvatarResourceHelper$fetchBootResourceNotUseCache$1.Z$2;
                                        z27 = zPlanAvatarResourceHelper$fetchBootResourceNotUseCache$1.Z$1;
                                        z28 = zPlanAvatarResourceHelper$fetchBootResourceNotUseCache$1.Z$0;
                                        path2 = (String) zPlanAvatarResourceHelper$fetchBootResourceNotUseCache$1.L$3;
                                        str4 = (String) zPlanAvatarResourceHelper$fetchBootResourceNotUseCache$1.L$2;
                                        str5 = (String) zPlanAvatarResourceHelper$fetchBootResourceNotUseCache$1.L$1;
                                        bVar = (com.tencent.zplan.zplantracing.b) zPlanAvatarResourceHelper$fetchBootResourceNotUseCache$1.L$0;
                                        ResultKt.throwOnFailure(obj);
                                        FLog fLog = FLog.INSTANCE;
                                        fLog.i("FilamentNativeApp[ZPlanAvatarResourceHelper]V2", "fetchBootResourceNotUseCache succ.");
                                        BootResourceModel bootResourceModel = new BootResourceModel((String) obj, str5, str4, path2);
                                        if (!z28 && !z27 && !z26) {
                                            z29 = false;
                                        }
                                        bootResourceModel.u(z29);
                                        if (bVar != null) {
                                            bVar.e("downloadFromNet", String.valueOf(bootResourceModel.getDownloadFromNet()));
                                        }
                                        if (bVar != null) {
                                            bVar.b();
                                        }
                                        fLog.i("FilamentNativeApp[ZPlanAvatarResourceHelper]V2", "fetchBootResourceNotUseCache apply.");
                                        return bootResourceModel;
                                    }
                                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                                }
                                z26 = zPlanAvatarResourceHelper$fetchBootResourceNotUseCache$1.Z$2;
                                z19 = zPlanAvatarResourceHelper$fetchBootResourceNotUseCache$1.Z$1;
                                z18 = zPlanAvatarResourceHelper$fetchBootResourceNotUseCache$1.Z$0;
                                String str6 = (String) zPlanAvatarResourceHelper$fetchBootResourceNotUseCache$1.L$4;
                                String str7 = (String) zPlanAvatarResourceHelper$fetchBootResourceNotUseCache$1.L$3;
                                str3 = (String) zPlanAvatarResourceHelper$fetchBootResourceNotUseCache$1.L$2;
                                deferred7 = (Deferred) zPlanAvatarResourceHelper$fetchBootResourceNotUseCache$1.L$1;
                                startSpan = (com.tencent.zplan.zplantracing.b) zPlanAvatarResourceHelper$fetchBootResourceNotUseCache$1.L$0;
                                ResultKt.throwOnFailure(obj);
                                path2 = str6;
                                str = str7;
                                zPlanAvatarResourceHelper$fetchBootResourceNotUseCache$1.L$0 = startSpan;
                                zPlanAvatarResourceHelper$fetchBootResourceNotUseCache$1.L$1 = str3;
                                zPlanAvatarResourceHelper$fetchBootResourceNotUseCache$1.L$2 = str;
                                zPlanAvatarResourceHelper$fetchBootResourceNotUseCache$1.L$3 = path2;
                                zPlanAvatarResourceHelper$fetchBootResourceNotUseCache$1.L$4 = null;
                                zPlanAvatarResourceHelper$fetchBootResourceNotUseCache$1.Z$0 = z18;
                                zPlanAvatarResourceHelper$fetchBootResourceNotUseCache$1.Z$1 = z19;
                                zPlanAvatarResourceHelper$fetchBootResourceNotUseCache$1.Z$2 = z26;
                                zPlanAvatarResourceHelper$fetchBootResourceNotUseCache$1.label = 5;
                                obj = deferred7.await(zPlanAvatarResourceHelper$fetchBootResourceNotUseCache$1);
                                if (obj != coroutine_suspended) {
                                    return coroutine_suspended;
                                }
                                z27 = z19;
                                z28 = z18;
                                str4 = str;
                                str5 = str3;
                                bVar = startSpan;
                                FLog fLog2 = FLog.INSTANCE;
                                fLog2.i("FilamentNativeApp[ZPlanAvatarResourceHelper]V2", "fetchBootResourceNotUseCache succ.");
                                BootResourceModel bootResourceModel2 = new BootResourceModel((String) obj, str5, str4, path2);
                                if (!z28) {
                                    z29 = false;
                                }
                                bootResourceModel2.u(z29);
                                if (bVar != null) {
                                }
                                if (bVar != null) {
                                }
                                fLog2.i("FilamentNativeApp[ZPlanAvatarResourceHelper]V2", "fetchBootResourceNotUseCache apply.");
                                return bootResourceModel2;
                            }
                            z17 = zPlanAvatarResourceHelper$fetchBootResourceNotUseCache$1.Z$1;
                            z16 = zPlanAvatarResourceHelper$fetchBootResourceNotUseCache$1.Z$0;
                            str = (String) zPlanAvatarResourceHelper$fetchBootResourceNotUseCache$1.L$4;
                            str2 = (String) zPlanAvatarResourceHelper$fetchBootResourceNotUseCache$1.L$3;
                            deferred6 = (Deferred) zPlanAvatarResourceHelper$fetchBootResourceNotUseCache$1.L$2;
                            deferred5 = (Deferred) zPlanAvatarResourceHelper$fetchBootResourceNotUseCache$1.L$1;
                            startSpan = (com.tencent.zplan.zplantracing.b) zPlanAvatarResourceHelper$fetchBootResourceNotUseCache$1.L$0;
                            ResultKt.throwOnFailure(obj);
                            Resource resource = (Resource) obj;
                            path2 = resource.getPath();
                            boolean downloadFromNet = resource.getDownloadFromNet();
                            zPlanAvatarResourceHelper$fetchBootResourceNotUseCache$1.L$0 = startSpan;
                            zPlanAvatarResourceHelper$fetchBootResourceNotUseCache$1.L$1 = deferred6;
                            zPlanAvatarResourceHelper$fetchBootResourceNotUseCache$1.L$2 = str2;
                            zPlanAvatarResourceHelper$fetchBootResourceNotUseCache$1.L$3 = str;
                            zPlanAvatarResourceHelper$fetchBootResourceNotUseCache$1.L$4 = path2;
                            zPlanAvatarResourceHelper$fetchBootResourceNotUseCache$1.Z$0 = z16;
                            zPlanAvatarResourceHelper$fetchBootResourceNotUseCache$1.Z$1 = z17;
                            zPlanAvatarResourceHelper$fetchBootResourceNotUseCache$1.Z$2 = downloadFromNet;
                            zPlanAvatarResourceHelper$fetchBootResourceNotUseCache$1.label = 4;
                            if (deferred5.await(zPlanAvatarResourceHelper$fetchBootResourceNotUseCache$1) != coroutine_suspended) {
                                return coroutine_suspended;
                            }
                            z18 = z16;
                            deferred7 = deferred6;
                            z19 = z17;
                            z26 = downloadFromNet;
                            str3 = str2;
                            zPlanAvatarResourceHelper$fetchBootResourceNotUseCache$1.L$0 = startSpan;
                            zPlanAvatarResourceHelper$fetchBootResourceNotUseCache$1.L$1 = str3;
                            zPlanAvatarResourceHelper$fetchBootResourceNotUseCache$1.L$2 = str;
                            zPlanAvatarResourceHelper$fetchBootResourceNotUseCache$1.L$3 = path2;
                            zPlanAvatarResourceHelper$fetchBootResourceNotUseCache$1.L$4 = null;
                            zPlanAvatarResourceHelper$fetchBootResourceNotUseCache$1.Z$0 = z18;
                            zPlanAvatarResourceHelper$fetchBootResourceNotUseCache$1.Z$1 = z19;
                            zPlanAvatarResourceHelper$fetchBootResourceNotUseCache$1.Z$2 = z26;
                            zPlanAvatarResourceHelper$fetchBootResourceNotUseCache$1.label = 5;
                            obj = deferred7.await(zPlanAvatarResourceHelper$fetchBootResourceNotUseCache$1);
                            if (obj != coroutine_suspended) {
                            }
                        } else {
                            boolean z36 = zPlanAvatarResourceHelper$fetchBootResourceNotUseCache$1.Z$0;
                            String str8 = (String) zPlanAvatarResourceHelper$fetchBootResourceNotUseCache$1.L$4;
                            deferred2 = (Deferred) zPlanAvatarResourceHelper$fetchBootResourceNotUseCache$1.L$3;
                            deferred4 = (Deferred) zPlanAvatarResourceHelper$fetchBootResourceNotUseCache$1.L$2;
                            deferred3 = (Deferred) zPlanAvatarResourceHelper$fetchBootResourceNotUseCache$1.L$1;
                            startSpan = (com.tencent.zplan.zplantracing.b) zPlanAvatarResourceHelper$fetchBootResourceNotUseCache$1.L$0;
                            ResultKt.throwOnFailure(obj);
                            path = str8;
                            z16 = z36;
                            Resource resource2 = (Resource) obj;
                            String path3 = resource2.getPath();
                            boolean downloadFromNet2 = resource2.getDownloadFromNet();
                            zPlanAvatarResourceHelper$fetchBootResourceNotUseCache$1.L$0 = startSpan;
                            zPlanAvatarResourceHelper$fetchBootResourceNotUseCache$1.L$1 = deferred4;
                            zPlanAvatarResourceHelper$fetchBootResourceNotUseCache$1.L$2 = deferred2;
                            zPlanAvatarResourceHelper$fetchBootResourceNotUseCache$1.L$3 = path;
                            zPlanAvatarResourceHelper$fetchBootResourceNotUseCache$1.L$4 = path3;
                            zPlanAvatarResourceHelper$fetchBootResourceNotUseCache$1.Z$0 = z16;
                            zPlanAvatarResourceHelper$fetchBootResourceNotUseCache$1.Z$1 = downloadFromNet2;
                            zPlanAvatarResourceHelper$fetchBootResourceNotUseCache$1.label = 3;
                            await2 = deferred3.await(zPlanAvatarResourceHelper$fetchBootResourceNotUseCache$1);
                            if (await2 != coroutine_suspended) {
                                return coroutine_suspended;
                            }
                            str = path3;
                            z17 = downloadFromNet2;
                            obj = await2;
                            deferred5 = deferred4;
                            deferred6 = deferred2;
                            str2 = path;
                            Resource resource3 = (Resource) obj;
                            path2 = resource3.getPath();
                            boolean downloadFromNet3 = resource3.getDownloadFromNet();
                            zPlanAvatarResourceHelper$fetchBootResourceNotUseCache$1.L$0 = startSpan;
                            zPlanAvatarResourceHelper$fetchBootResourceNotUseCache$1.L$1 = deferred6;
                            zPlanAvatarResourceHelper$fetchBootResourceNotUseCache$1.L$2 = str2;
                            zPlanAvatarResourceHelper$fetchBootResourceNotUseCache$1.L$3 = str;
                            zPlanAvatarResourceHelper$fetchBootResourceNotUseCache$1.L$4 = path2;
                            zPlanAvatarResourceHelper$fetchBootResourceNotUseCache$1.Z$0 = z16;
                            zPlanAvatarResourceHelper$fetchBootResourceNotUseCache$1.Z$1 = z17;
                            zPlanAvatarResourceHelper$fetchBootResourceNotUseCache$1.Z$2 = downloadFromNet3;
                            zPlanAvatarResourceHelper$fetchBootResourceNotUseCache$1.label = 4;
                            if (deferred5.await(zPlanAvatarResourceHelper$fetchBootResourceNotUseCache$1) != coroutine_suspended) {
                            }
                        }
                    } else {
                        async$default5 = (Deferred) zPlanAvatarResourceHelper$fetchBootResourceNotUseCache$1.L$4;
                        deferred = (Deferred) zPlanAvatarResourceHelper$fetchBootResourceNotUseCache$1.L$3;
                        async$default3 = (Deferred) zPlanAvatarResourceHelper$fetchBootResourceNotUseCache$1.L$2;
                        async$default2 = (Deferred) zPlanAvatarResourceHelper$fetchBootResourceNotUseCache$1.L$1;
                        startSpan = (com.tencent.zplan.zplantracing.b) zPlanAvatarResourceHelper$fetchBootResourceNotUseCache$1.L$0;
                        ResultKt.throwOnFailure(obj);
                    }
                } else {
                    ResultKt.throwOnFailure(obj);
                    FLog fLog3 = FLog.INSTANCE;
                    StringBuilder sb5 = new StringBuilder();
                    sb5.append("fetchBootResourceNotUseCache begin. enableCppDownload: ");
                    boolean z37 = enableCppDownload;
                    sb5.append(z37);
                    sb5.append(',');
                    sb5.append("enableCppDownload: ");
                    sb5.append(z37);
                    fLog3.i("FilamentNativeApp[ZPlanAvatarResourceHelper]V2", sb5.toString());
                    startSpan = ZPlanSpanFactory.INSTANCE.startSpan("fetchBootResource", cVar);
                    CoroutineScope CoroutineScope = CoroutineScopeKt.CoroutineScope(Dispatchers.getIO());
                    async$default = BuildersKt__Builders_commonKt.async$default(CoroutineScope, null, null, new ZPlanAvatarResourceHelper$fetchBootResourceNotUseCache$indirectLightPathDeferred$1(startSpan, filamentUrlTemplate, null), 3, null);
                    async$default2 = BuildersKt__Builders_commonKt.async$default(CoroutineScope, null, null, new ZPlanAvatarResourceHelper$fetchBootResourceNotUseCache$kawaiiPathDeferred$1(startSpan, filamentUrlTemplate, null), 3, null);
                    async$default3 = BuildersKt__Builders_commonKt.async$default(CoroutineScope, null, null, new ZPlanAvatarResourceHelper$fetchBootResourceNotUseCache$lutTexturePathDeferred$1(startSpan, filamentUrlTemplate, null), 3, null);
                    async$default4 = BuildersKt__Builders_commonKt.async$default(CoroutineScope, null, null, new ZPlanAvatarResourceHelper$fetchBootResourceNotUseCache$fetchShadowPlaneShader$1(startSpan, filamentUrlTemplate, null), 3, null);
                    async$default5 = BuildersKt__Builders_commonKt.async$default(CoroutineScope, null, null, new ZPlanAvatarResourceHelper$fetchBootResourceNotUseCache$fetchShaderDir$1(filamentUrlTemplate, null), 3, null);
                    zPlanAvatarResourceHelper$fetchBootResourceNotUseCache$1.L$0 = startSpan;
                    zPlanAvatarResourceHelper$fetchBootResourceNotUseCache$1.L$1 = async$default2;
                    zPlanAvatarResourceHelper$fetchBootResourceNotUseCache$1.L$2 = async$default3;
                    zPlanAvatarResourceHelper$fetchBootResourceNotUseCache$1.L$3 = async$default4;
                    zPlanAvatarResourceHelper$fetchBootResourceNotUseCache$1.L$4 = async$default5;
                    zPlanAvatarResourceHelper$fetchBootResourceNotUseCache$1.label = 1;
                    obj = async$default.await(zPlanAvatarResourceHelper$fetchBootResourceNotUseCache$1);
                    if (obj == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    deferred = async$default4;
                }
                Resource resource4 = (Resource) obj;
                path = resource4.getPath();
                boolean downloadFromNet4 = resource4.getDownloadFromNet();
                zPlanAvatarResourceHelper$fetchBootResourceNotUseCache$1.L$0 = startSpan;
                zPlanAvatarResourceHelper$fetchBootResourceNotUseCache$1.L$1 = async$default3;
                zPlanAvatarResourceHelper$fetchBootResourceNotUseCache$1.L$2 = deferred;
                zPlanAvatarResourceHelper$fetchBootResourceNotUseCache$1.L$3 = async$default5;
                zPlanAvatarResourceHelper$fetchBootResourceNotUseCache$1.L$4 = path;
                zPlanAvatarResourceHelper$fetchBootResourceNotUseCache$1.Z$0 = downloadFromNet4;
                zPlanAvatarResourceHelper$fetchBootResourceNotUseCache$1.label = 2;
                await = async$default2.await(zPlanAvatarResourceHelper$fetchBootResourceNotUseCache$1);
                if (await != coroutine_suspended) {
                    return coroutine_suspended;
                }
                deferred2 = async$default5;
                deferred3 = async$default3;
                deferred4 = deferred;
                z16 = downloadFromNet4;
                obj = await;
                Resource resource22 = (Resource) obj;
                String path32 = resource22.getPath();
                boolean downloadFromNet22 = resource22.getDownloadFromNet();
                zPlanAvatarResourceHelper$fetchBootResourceNotUseCache$1.L$0 = startSpan;
                zPlanAvatarResourceHelper$fetchBootResourceNotUseCache$1.L$1 = deferred4;
                zPlanAvatarResourceHelper$fetchBootResourceNotUseCache$1.L$2 = deferred2;
                zPlanAvatarResourceHelper$fetchBootResourceNotUseCache$1.L$3 = path;
                zPlanAvatarResourceHelper$fetchBootResourceNotUseCache$1.L$4 = path32;
                zPlanAvatarResourceHelper$fetchBootResourceNotUseCache$1.Z$0 = z16;
                zPlanAvatarResourceHelper$fetchBootResourceNotUseCache$1.Z$1 = downloadFromNet22;
                zPlanAvatarResourceHelper$fetchBootResourceNotUseCache$1.label = 3;
                await2 = deferred3.await(zPlanAvatarResourceHelper$fetchBootResourceNotUseCache$1);
                if (await2 != coroutine_suspended) {
                }
            }
        }
        zPlanAvatarResourceHelper$fetchBootResourceNotUseCache$1 = new ZPlanAvatarResourceHelper$fetchBootResourceNotUseCache$1(this, continuation);
        Object obj2 = zPlanAvatarResourceHelper$fetchBootResourceNotUseCache$1.result;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i3 = zPlanAvatarResourceHelper$fetchBootResourceNotUseCache$1.label;
        boolean z292 = true;
        if (i3 == 0) {
        }
        Resource resource42 = (Resource) obj2;
        path = resource42.getPath();
        boolean downloadFromNet42 = resource42.getDownloadFromNet();
        zPlanAvatarResourceHelper$fetchBootResourceNotUseCache$1.L$0 = startSpan;
        zPlanAvatarResourceHelper$fetchBootResourceNotUseCache$1.L$1 = async$default3;
        zPlanAvatarResourceHelper$fetchBootResourceNotUseCache$1.L$2 = deferred;
        zPlanAvatarResourceHelper$fetchBootResourceNotUseCache$1.L$3 = async$default5;
        zPlanAvatarResourceHelper$fetchBootResourceNotUseCache$1.L$4 = path;
        zPlanAvatarResourceHelper$fetchBootResourceNotUseCache$1.Z$0 = downloadFromNet42;
        zPlanAvatarResourceHelper$fetchBootResourceNotUseCache$1.label = 2;
        await = async$default2.await(zPlanAvatarResourceHelper$fetchBootResourceNotUseCache$1);
        if (await != coroutine_suspended) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:29:0x00a9 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:30:0x00aa  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x004e  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0030  */
    @Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object H(@Nullable com.tencent.zplan.zplantracing.c cVar, @NotNull FilamentUrlTemplate filamentUrlTemplate, @NotNull Continuation<? super BootResourceModel> continuation) throws FetchFileException, BlackListResourceException, RuntimeException {
        ZPlanAvatarResourceHelper$fetchBootResourceWithCpp$1 zPlanAvatarResourceHelper$fetchBootResourceWithCpp$1;
        Object coroutine_suspended;
        int i3;
        Deferred async$default;
        Deferred async$default2;
        Deferred deferred;
        Object await;
        ZPlanAvatarInterfaceResult zPlanAvatarInterfaceResult;
        ZPlanAvatarInterfaceResult zPlanAvatarInterfaceResult2;
        try {
            if (continuation instanceof ZPlanAvatarResourceHelper$fetchBootResourceWithCpp$1) {
                zPlanAvatarResourceHelper$fetchBootResourceWithCpp$1 = (ZPlanAvatarResourceHelper$fetchBootResourceWithCpp$1) continuation;
                int i16 = zPlanAvatarResourceHelper$fetchBootResourceWithCpp$1.label;
                if ((i16 & Integer.MIN_VALUE) != 0) {
                    zPlanAvatarResourceHelper$fetchBootResourceWithCpp$1.label = i16 - Integer.MIN_VALUE;
                    Object obj = zPlanAvatarResourceHelper$fetchBootResourceWithCpp$1.result;
                    coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    i3 = zPlanAvatarResourceHelper$fetchBootResourceWithCpp$1.label;
                    boolean z16 = true;
                    if (i3 == 0) {
                        if (i3 != 1) {
                            if (i3 == 2) {
                                zPlanAvatarInterfaceResult = (ZPlanAvatarInterfaceResult) zPlanAvatarResourceHelper$fetchBootResourceWithCpp$1.L$0;
                                ResultKt.throwOnFailure(obj);
                                zPlanAvatarInterfaceResult2 = (ZPlanAvatarInterfaceResult) obj;
                                JsonObject jsonObject = (JsonObject) new Gson().fromJson(zPlanAvatarInterfaceResult.getResult(), JsonObject.class);
                                FLog fLog = FLog.INSTANCE;
                                fLog.i("FilamentNativeApp[ZPlanAvatarResourceHelper]V2", "fetchBootResourceWithCpp succ. result:" + zPlanAvatarInterfaceResult.getResult());
                                JsonElement jsonElement = jsonObject.get("shaderRootPath");
                                Intrinsics.checkNotNullExpressionValue(jsonElement, "jsonObj.get(\"shaderRootPath\")");
                                String asString = jsonElement.getAsString();
                                String result = zPlanAvatarInterfaceResult2.getResult();
                                JsonElement jsonElement2 = jsonObject.get("kawaiiBodySkeletonLimitsPath");
                                Intrinsics.checkNotNullExpressionValue(jsonElement2, "jsonObj.get(\"kawaiiBodySkeletonLimitsPath\")");
                                String asString2 = jsonElement2.getAsString();
                                Intrinsics.checkNotNullExpressionValue(asString2, "jsonObj.get(\"kawaiiBodyS\u2026etonLimitsPath\").asString");
                                JsonElement jsonElement3 = jsonObject.get("lutTexturePath");
                                Intrinsics.checkNotNullExpressionValue(jsonElement3, "jsonObj.get(\"lutTexturePath\")");
                                BootResourceModel bootResourceModel = new BootResourceModel(asString, result, asString2, jsonElement3.getAsString());
                                if (!zPlanAvatarInterfaceResult2.isDownload() && !zPlanAvatarInterfaceResult.isDownload()) {
                                    z16 = false;
                                }
                                bootResourceModel.u(z16);
                                fLog.i("FilamentNativeApp[ZPlanAvatarResourceHelper]V2", "fetchBootResourceWithCpp apply. enableCppDownload: " + enableCppDownload);
                                return bootResourceModel;
                            }
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        deferred = (Deferred) zPlanAvatarResourceHelper$fetchBootResourceWithCpp$1.L$0;
                        ResultKt.throwOnFailure(obj);
                    } else {
                        ResultKt.throwOnFailure(obj);
                        CoroutineScope CoroutineScope = CoroutineScopeKt.CoroutineScope(Dispatchers.getIO());
                        async$default = BuildersKt__Builders_commonKt.async$default(CoroutineScope, null, null, new ZPlanAvatarResourceHelper$fetchBootResourceWithCpp$fetchBootResource$1(new FetchBootResourcesOptions(false, false, false, false, false, false, false, false, 255, null), null), 3, null);
                        async$default2 = BuildersKt__Builders_commonKt.async$default(CoroutineScope, null, null, new ZPlanAvatarResourceHelper$fetchBootResourceWithCpp$fetchIndirectLight$1(null), 3, null);
                        FLog.INSTANCE.i("FilamentNativeApp[ZPlanAvatarResourceHelper]V2", "fetchBootResourceWithCpp start.");
                        zPlanAvatarResourceHelper$fetchBootResourceWithCpp$1.L$0 = async$default2;
                        zPlanAvatarResourceHelper$fetchBootResourceWithCpp$1.label = 1;
                        Object await2 = async$default.await(zPlanAvatarResourceHelper$fetchBootResourceWithCpp$1);
                        if (await2 == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        deferred = async$default2;
                        obj = await2;
                    }
                    ZPlanAvatarInterfaceResult zPlanAvatarInterfaceResult3 = (ZPlanAvatarInterfaceResult) obj;
                    zPlanAvatarResourceHelper$fetchBootResourceWithCpp$1.L$0 = zPlanAvatarInterfaceResult3;
                    zPlanAvatarResourceHelper$fetchBootResourceWithCpp$1.label = 2;
                    await = deferred.await(zPlanAvatarResourceHelper$fetchBootResourceWithCpp$1);
                    if (await != coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    zPlanAvatarInterfaceResult = zPlanAvatarInterfaceResult3;
                    obj = await;
                    zPlanAvatarInterfaceResult2 = (ZPlanAvatarInterfaceResult) obj;
                    JsonObject jsonObject2 = (JsonObject) new Gson().fromJson(zPlanAvatarInterfaceResult.getResult(), JsonObject.class);
                    FLog fLog2 = FLog.INSTANCE;
                    fLog2.i("FilamentNativeApp[ZPlanAvatarResourceHelper]V2", "fetchBootResourceWithCpp succ. result:" + zPlanAvatarInterfaceResult.getResult());
                    JsonElement jsonElement4 = jsonObject2.get("shaderRootPath");
                    Intrinsics.checkNotNullExpressionValue(jsonElement4, "jsonObj.get(\"shaderRootPath\")");
                    String asString3 = jsonElement4.getAsString();
                    String result2 = zPlanAvatarInterfaceResult2.getResult();
                    JsonElement jsonElement22 = jsonObject2.get("kawaiiBodySkeletonLimitsPath");
                    Intrinsics.checkNotNullExpressionValue(jsonElement22, "jsonObj.get(\"kawaiiBodySkeletonLimitsPath\")");
                    String asString22 = jsonElement22.getAsString();
                    Intrinsics.checkNotNullExpressionValue(asString22, "jsonObj.get(\"kawaiiBodyS\u2026etonLimitsPath\").asString");
                    JsonElement jsonElement32 = jsonObject2.get("lutTexturePath");
                    Intrinsics.checkNotNullExpressionValue(jsonElement32, "jsonObj.get(\"lutTexturePath\")");
                    BootResourceModel bootResourceModel2 = new BootResourceModel(asString3, result2, asString22, jsonElement32.getAsString());
                    if (!zPlanAvatarInterfaceResult2.isDownload()) {
                        z16 = false;
                    }
                    bootResourceModel2.u(z16);
                    fLog2.i("FilamentNativeApp[ZPlanAvatarResourceHelper]V2", "fetchBootResourceWithCpp apply. enableCppDownload: " + enableCppDownload);
                    return bootResourceModel2;
                }
            }
            if (i3 == 0) {
            }
            ZPlanAvatarInterfaceResult zPlanAvatarInterfaceResult32 = (ZPlanAvatarInterfaceResult) obj;
            zPlanAvatarResourceHelper$fetchBootResourceWithCpp$1.L$0 = zPlanAvatarInterfaceResult32;
            zPlanAvatarResourceHelper$fetchBootResourceWithCpp$1.label = 2;
            await = deferred.await(zPlanAvatarResourceHelper$fetchBootResourceWithCpp$1);
            if (await != coroutine_suspended) {
            }
        } catch (ZPlanAvatarServiceException e16) {
            FLog.INSTANCE.e("FilamentNativeApp[ZPlanAvatarResourceHelper]V2", "fetchBootResourceWithCpp fail. e:" + e16);
            throw new FetchFileException(FetchFileException.Type.DOWNLOAD_FAIL, e16.getError().getErrorCode().getValue(), String.valueOf(e16.getError().getErrorMsg()), "");
        } catch (Exception e17) {
            FLog.INSTANCE.e("FilamentNativeApp[ZPlanAvatarResourceHelper]V2", "fetchBootResourceWithCpp fail. e:" + e17);
            throw e17;
        }
        zPlanAvatarResourceHelper$fetchBootResourceWithCpp$1 = new ZPlanAvatarResourceHelper$fetchBootResourceWithCpp$1(this, continuation);
        Object obj2 = zPlanAvatarResourceHelper$fetchBootResourceWithCpp$1.result;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i3 = zPlanAvatarResourceHelper$fetchBootResourceWithCpp$1.label;
        boolean z162 = true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Removed duplicated region for block: B:12:0x00b0  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x00bc  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x003e  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0027  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final /* synthetic */ Object I(com.tencent.zplan.zplantracing.c cVar, JSONObject jSONObject, FilamentUrlTemplate filamentUrlTemplate, Continuation<? super Pair<? extends ZPlanCommonGltfFAsset, Boolean>> continuation) {
        ZPlanAvatarResourceHelper$fetchEyelashGltfFAssetWithAvatar$1 zPlanAvatarResourceHelper$fetchEyelashGltfFAssetWithAvatar$1;
        Object coroutine_suspended;
        int i3;
        String fEyelashResUrl;
        com.tencent.zplan.zplantracing.c cVar2;
        com.tencent.zplan.zplantracing.b bVar;
        String str;
        if (continuation instanceof ZPlanAvatarResourceHelper$fetchEyelashGltfFAssetWithAvatar$1) {
            zPlanAvatarResourceHelper$fetchEyelashGltfFAssetWithAvatar$1 = (ZPlanAvatarResourceHelper$fetchEyelashGltfFAssetWithAvatar$1) continuation;
            int i16 = zPlanAvatarResourceHelper$fetchEyelashGltfFAssetWithAvatar$1.label;
            if ((i16 & Integer.MIN_VALUE) != 0) {
                zPlanAvatarResourceHelper$fetchEyelashGltfFAssetWithAvatar$1.label = i16 - Integer.MIN_VALUE;
                ZPlanAvatarResourceHelper$fetchEyelashGltfFAssetWithAvatar$1 zPlanAvatarResourceHelper$fetchEyelashGltfFAssetWithAvatar$12 = zPlanAvatarResourceHelper$fetchEyelashGltfFAssetWithAvatar$1;
                Object obj = zPlanAvatarResourceHelper$fetchEyelashGltfFAssetWithAvatar$12.result;
                coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i3 = zPlanAvatarResourceHelper$fetchEyelashGltfFAssetWithAvatar$12.label;
                if (i3 == 0) {
                    if (i3 == 1) {
                        str = (String) zPlanAvatarResourceHelper$fetchEyelashGltfFAssetWithAvatar$12.L$1;
                        bVar = (com.tencent.zplan.zplantracing.b) zPlanAvatarResourceHelper$fetchEyelashGltfFAssetWithAvatar$12.L$0;
                        ResultKt.throwOnFailure(obj);
                    } else {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                } else {
                    ResultKt.throwOnFailure(obj);
                    com.tencent.zplan.zplantracing.b startSpan = ZPlanSpanFactory.INSTANCE.startSpan("fetchEyelashGltf", cVar);
                    int i17 = e.f105679c[j0(jSONObject).ordinal()];
                    if (i17 != 1) {
                        if (i17 == 2) {
                            fEyelashResUrl = filamentUrlTemplate.getMEyelashResUrl();
                        } else {
                            throw new RuntimeException("gender is illegal");
                        }
                    } else {
                        fEyelashResUrl = filamentUrlTemplate.getFEyelashResUrl();
                    }
                    String str2 = fEyelashResUrl;
                    if (startSpan != null) {
                        cVar2 = startSpan.c();
                    } else {
                        cVar2 = null;
                    }
                    zPlanAvatarResourceHelper$fetchEyelashGltfFAssetWithAvatar$12.L$0 = startSpan;
                    zPlanAvatarResourceHelper$fetchEyelashGltfFAssetWithAvatar$12.L$1 = str2;
                    zPlanAvatarResourceHelper$fetchEyelashGltfFAssetWithAvatar$12.label = 1;
                    obj = M(this, cVar2, str2, null, "gltf", filamentUrlTemplate, false, zPlanAvatarResourceHelper$fetchEyelashGltfFAssetWithAvatar$12, 36, null);
                    if (obj == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    bVar = startSpan;
                    str = str2;
                }
                Resource resource = (Resource) obj;
                String path = resource.getPath();
                boolean downloadFromNet = resource.getDownloadFromNet();
                ZPlanFAssetInfo zPlanFAssetInfo = new ZPlanFAssetInfo(String.valueOf(AvatarSlot.cfgpb_AvatarSlot_EN_SLOT_EYELASH.getValue()), str);
                if (bVar != null) {
                    bVar.e("downloadFormNet", String.valueOf(downloadFromNet));
                }
                if (bVar != null) {
                    bVar.b();
                }
                return new Pair(new ZPlanCommonGltfFAsset(zPlanFAssetInfo, path), Boxing.boxBoolean(downloadFromNet));
            }
        }
        zPlanAvatarResourceHelper$fetchEyelashGltfFAssetWithAvatar$1 = new ZPlanAvatarResourceHelper$fetchEyelashGltfFAssetWithAvatar$1(this, continuation);
        ZPlanAvatarResourceHelper$fetchEyelashGltfFAssetWithAvatar$1 zPlanAvatarResourceHelper$fetchEyelashGltfFAssetWithAvatar$122 = zPlanAvatarResourceHelper$fetchEyelashGltfFAssetWithAvatar$1;
        Object obj2 = zPlanAvatarResourceHelper$fetchEyelashGltfFAssetWithAvatar$122.result;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i3 = zPlanAvatarResourceHelper$fetchEyelashGltfFAssetWithAvatar$122.label;
        if (i3 == 0) {
        }
        Resource resource2 = (Resource) obj2;
        String path2 = resource2.getPath();
        boolean downloadFromNet2 = resource2.getDownloadFromNet();
        ZPlanFAssetInfo zPlanFAssetInfo2 = new ZPlanFAssetInfo(String.valueOf(AvatarSlot.cfgpb_AvatarSlot_EN_SLOT_EYELASH.getValue()), str);
        if (bVar != null) {
        }
        if (bVar != null) {
        }
        return new Pair(new ZPlanCommonGltfFAsset(zPlanFAssetInfo2, path2), Boxing.boxBoolean(downloadFromNet2));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0199  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0224  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x02e0  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x00a4  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0046  */
    /* JADX WARN: Type inference failed for: r26v2 */
    /* JADX WARN: Type inference failed for: r26v4 */
    /* JADX WARN: Type inference failed for: r26v6 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final /* synthetic */ Object J(com.tencent.zplan.zplantracing.c cVar, JSONObject jSONObject, FilamentUrlTemplate filamentUrlTemplate, boolean z16, Continuation<? super Pair<? extends ZPlanCommonGltfFAsset, Boolean>> continuation) {
        ZPlanAvatarResourceHelper$fetchFace$1 zPlanAvatarResourceHelper$fetchFace$1;
        Object coroutine_suspended;
        int i3;
        boolean z17;
        Object obj;
        Object obj2;
        Object obj3;
        Object obj4;
        Object obj5;
        ZPlanAvatarResourceHelper zPlanAvatarResourceHelper;
        com.tencent.zplan.zplantracing.c cVar2;
        FilamentUrlTemplate filamentUrlTemplate2;
        String str;
        ZPlanFAssetInfo zPlanFAssetInfo;
        boolean downloadFromNet;
        com.tencent.filament.zplan.util.Result c16;
        Map<String, String> mutableMapOf;
        dl0.h hVar;
        ZPlanCommonGltfFAsset zPlanCommonGltfFAsset;
        boolean z18;
        String str2;
        Object obj6;
        ZPlanFAssetInfo zPlanFAssetInfo2;
        ZPlanAvatarResourceHelper zPlanAvatarResourceHelper2;
        com.tencent.filament.zplan.util.Result result;
        boolean z19;
        ?? r26;
        com.tencent.filament.zplan.util.Result c17;
        Map<String, String> mutableMapOf2;
        Map<String, String> mutableMapOf3;
        if (continuation instanceof ZPlanAvatarResourceHelper$fetchFace$1) {
            zPlanAvatarResourceHelper$fetchFace$1 = (ZPlanAvatarResourceHelper$fetchFace$1) continuation;
            int i16 = zPlanAvatarResourceHelper$fetchFace$1.label;
            if ((i16 & Integer.MIN_VALUE) != 0) {
                zPlanAvatarResourceHelper$fetchFace$1.label = i16 - Integer.MIN_VALUE;
                ZPlanAvatarResourceHelper$fetchFace$1 zPlanAvatarResourceHelper$fetchFace$12 = zPlanAvatarResourceHelper$fetchFace$1;
                Object obj7 = zPlanAvatarResourceHelper$fetchFace$12.result;
                coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i3 = zPlanAvatarResourceHelper$fetchFace$12.label;
                if (i3 != 0) {
                    ResultKt.throwOnFailure(obj7);
                    String m06 = m0(j0(jSONObject), filamentUrlTemplate, z16);
                    ZPlanFAssetInfo zPlanFAssetInfo3 = new ZPlanFAssetInfo(TorsoSlot.FACE.getKey(), m06);
                    zPlanAvatarResourceHelper$fetchFace$12.L$0 = this;
                    zPlanAvatarResourceHelper$fetchFace$12.L$1 = cVar;
                    zPlanAvatarResourceHelper$fetchFace$12.L$2 = filamentUrlTemplate;
                    zPlanAvatarResourceHelper$fetchFace$12.L$3 = m06;
                    zPlanAvatarResourceHelper$fetchFace$12.L$4 = zPlanFAssetInfo3;
                    zPlanAvatarResourceHelper$fetchFace$12.label = 1;
                    z17 = true;
                    obj = "verify_result";
                    obj2 = "verify_msg";
                    obj3 = "verify_code";
                    obj4 = "from_download";
                    obj5 = "url";
                    obj7 = M(this, cVar, m06, null, "gltf", filamentUrlTemplate, false, zPlanAvatarResourceHelper$fetchFace$12, 36, null);
                    if (obj7 == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    zPlanAvatarResourceHelper = this;
                    cVar2 = cVar;
                    filamentUrlTemplate2 = filamentUrlTemplate;
                    str = m06;
                    zPlanFAssetInfo = zPlanFAssetInfo3;
                } else {
                    if (i3 != 1) {
                        if (i3 != 2) {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        boolean z26 = zPlanAvatarResourceHelper$fetchFace$12.Z$0;
                        result = (com.tencent.filament.zplan.util.Result) zPlanAvatarResourceHelper$fetchFace$12.L$4;
                        zPlanFAssetInfo2 = (ZPlanFAssetInfo) zPlanAvatarResourceHelper$fetchFace$12.L$3;
                        str = (String) zPlanAvatarResourceHelper$fetchFace$12.L$2;
                        filamentUrlTemplate2 = (FilamentUrlTemplate) zPlanAvatarResourceHelper$fetchFace$12.L$1;
                        zPlanAvatarResourceHelper2 = (ZPlanAvatarResourceHelper) zPlanAvatarResourceHelper$fetchFace$12.L$0;
                        ResultKt.throwOnFailure(obj7);
                        r26 = 1;
                        obj = "verify_result";
                        obj2 = "verify_msg";
                        obj3 = "verify_code";
                        obj4 = "from_download";
                        obj5 = "url";
                        str2 = "zplan_face_verification";
                        z19 = z26;
                        obj6 = "success";
                        String path = ((Resource) obj7).getPath();
                        c17 = FAssetChecker.f105632b.c(com.tencent.filament.zplanservice.util.c.b(path), str);
                        if (FaceVerificationCode.INSTANCE.a(c17.getCode()).isPassed()) {
                            zPlanAvatarResourceHelper2.w(str, filamentUrlTemplate2);
                            Pair[] pairArr = new Pair[8];
                            pairArr[0] = TuplesKt.to(obj, "fail");
                            pairArr[r26] = TuplesKt.to(obj2, result.getMessage());
                            pairArr[2] = TuplesKt.to(obj3, String.valueOf(result.getCode()));
                            pairArr[3] = TuplesKt.to(obj4, String.valueOf(z19));
                            pairArr[4] = TuplesKt.to("retry_result", "fail");
                            pairArr[5] = TuplesKt.to("retry_msg", c17.getMessage());
                            pairArr[6] = TuplesKt.to("retry_code", String.valueOf(c17.getCode()));
                            pairArr[7] = TuplesKt.to(obj5, str);
                            mutableMapOf3 = MapsKt__MapsKt.mutableMapOf(pairArr);
                            dl0.h hVar2 = reportProxy;
                            if (hVar2 != null) {
                                hVar2.a(str2, mutableMapOf3);
                            }
                            throw new FetchFileException(FetchFileException.Type.VERIFY_FAIL, 301006, "verify face fail. reason:" + result.getMessage(), str);
                        }
                        ZPlanFAssetInfo zPlanFAssetInfo4 = zPlanFAssetInfo2;
                        String str3 = str2;
                        Pair[] pairArr2 = new Pair[8];
                        pairArr2[0] = TuplesKt.to(obj, "fail");
                        pairArr2[r26] = TuplesKt.to(obj2, result.getMessage());
                        pairArr2[2] = TuplesKt.to(obj3, String.valueOf(result.getCode()));
                        pairArr2[3] = TuplesKt.to(obj4, String.valueOf(z19));
                        pairArr2[4] = TuplesKt.to("retry_result", obj6);
                        pairArr2[5] = TuplesKt.to("retry_msg", c17.getMessage());
                        pairArr2[6] = TuplesKt.to("retry_code", String.valueOf(c17.getCode()));
                        pairArr2[7] = TuplesKt.to(obj5, str);
                        mutableMapOf2 = MapsKt__MapsKt.mutableMapOf(pairArr2);
                        dl0.h hVar3 = reportProxy;
                        if (hVar3 != null) {
                            hVar3.a(str3, mutableMapOf2);
                        }
                        zPlanCommonGltfFAsset = new ZPlanCommonGltfFAsset(zPlanFAssetInfo4, path);
                        z18 = r26;
                        return new Pair(zPlanCommonGltfFAsset, Boxing.boxBoolean(z18));
                    }
                    ZPlanFAssetInfo zPlanFAssetInfo5 = (ZPlanFAssetInfo) zPlanAvatarResourceHelper$fetchFace$12.L$4;
                    str = (String) zPlanAvatarResourceHelper$fetchFace$12.L$3;
                    filamentUrlTemplate2 = (FilamentUrlTemplate) zPlanAvatarResourceHelper$fetchFace$12.L$2;
                    com.tencent.zplan.zplantracing.c cVar3 = (com.tencent.zplan.zplantracing.c) zPlanAvatarResourceHelper$fetchFace$12.L$1;
                    ZPlanAvatarResourceHelper zPlanAvatarResourceHelper3 = (ZPlanAvatarResourceHelper) zPlanAvatarResourceHelper$fetchFace$12.L$0;
                    ResultKt.throwOnFailure(obj7);
                    obj = "verify_result";
                    obj2 = "verify_msg";
                    obj3 = "verify_code";
                    obj4 = "from_download";
                    obj5 = "url";
                    z17 = true;
                    zPlanAvatarResourceHelper = zPlanAvatarResourceHelper3;
                    zPlanFAssetInfo = zPlanFAssetInfo5;
                    cVar2 = cVar3;
                }
                Resource resource = (Resource) obj7;
                String path2 = resource.getPath();
                downloadFromNet = resource.getDownloadFromNet();
                c16 = FAssetChecker.f105632b.c(com.tencent.filament.zplanservice.util.c.b(path2), str);
                if (enableCppDownload && !FaceVerificationCode.INSTANCE.a(c16.getCode()).isPassed()) {
                    zPlanAvatarResourceHelper.w(str, filamentUrlTemplate2);
                    zPlanAvatarResourceHelper$fetchFace$12.L$0 = zPlanAvatarResourceHelper;
                    zPlanAvatarResourceHelper$fetchFace$12.L$1 = filamentUrlTemplate2;
                    zPlanAvatarResourceHelper$fetchFace$12.L$2 = str;
                    zPlanAvatarResourceHelper$fetchFace$12.L$3 = zPlanFAssetInfo;
                    zPlanAvatarResourceHelper$fetchFace$12.L$4 = c16;
                    zPlanAvatarResourceHelper$fetchFace$12.Z$0 = downloadFromNet;
                    zPlanAvatarResourceHelper$fetchFace$12.label = 2;
                    str2 = "zplan_face_verification";
                    com.tencent.zplan.zplantracing.c cVar4 = cVar2;
                    obj6 = "success";
                    Object M = M(zPlanAvatarResourceHelper, cVar4, str, null, "gltf", filamentUrlTemplate2, false, zPlanAvatarResourceHelper$fetchFace$12, 36, null);
                    if (M == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    zPlanFAssetInfo2 = zPlanFAssetInfo;
                    zPlanAvatarResourceHelper2 = zPlanAvatarResourceHelper;
                    result = c16;
                    z19 = downloadFromNet;
                    obj7 = M;
                    r26 = z17;
                    String path3 = ((Resource) obj7).getPath();
                    c17 = FAssetChecker.f105632b.c(com.tencent.filament.zplanservice.util.c.b(path3), str);
                    if (FaceVerificationCode.INSTANCE.a(c17.getCode()).isPassed()) {
                    }
                } else {
                    Pair[] pairArr3 = new Pair[5];
                    pairArr3[0] = TuplesKt.to(obj, "success");
                    pairArr3[z17 ? 1 : 0] = TuplesKt.to(obj2, c16.getMessage());
                    pairArr3[2] = TuplesKt.to(obj3, String.valueOf(c16.getCode()));
                    pairArr3[3] = TuplesKt.to(obj4, String.valueOf(downloadFromNet));
                    pairArr3[4] = TuplesKt.to(obj5, str);
                    mutableMapOf = MapsKt__MapsKt.mutableMapOf(pairArr3);
                    hVar = reportProxy;
                    if (hVar != null) {
                        hVar.a("zplan_face_verification", mutableMapOf);
                    }
                    zPlanCommonGltfFAsset = new ZPlanCommonGltfFAsset(zPlanFAssetInfo, path2);
                    z18 = downloadFromNet;
                    return new Pair(zPlanCommonGltfFAsset, Boxing.boxBoolean(z18));
                }
            }
        }
        zPlanAvatarResourceHelper$fetchFace$1 = new ZPlanAvatarResourceHelper$fetchFace$1(this, continuation);
        ZPlanAvatarResourceHelper$fetchFace$1 zPlanAvatarResourceHelper$fetchFace$122 = zPlanAvatarResourceHelper$fetchFace$1;
        Object obj72 = zPlanAvatarResourceHelper$fetchFace$122.result;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i3 = zPlanAvatarResourceHelper$fetchFace$122.label;
        if (i3 != 0) {
        }
        Resource resource2 = (Resource) obj72;
        String path22 = resource2.getPath();
        downloadFromNet = resource2.getDownloadFromNet();
        c16 = FAssetChecker.f105632b.c(com.tencent.filament.zplanservice.util.c.b(path22), str);
        if (enableCppDownload) {
        }
        Pair[] pairArr32 = new Pair[5];
        pairArr32[0] = TuplesKt.to(obj, "success");
        pairArr32[z17 ? 1 : 0] = TuplesKt.to(obj2, c16.getMessage());
        pairArr32[2] = TuplesKt.to(obj3, String.valueOf(c16.getCode()));
        pairArr32[3] = TuplesKt.to(obj4, String.valueOf(downloadFromNet));
        pairArr32[4] = TuplesKt.to(obj5, str);
        mutableMapOf = MapsKt__MapsKt.mutableMapOf(pairArr32);
        hVar = reportProxy;
        if (hVar != null) {
        }
        zPlanCommonGltfFAsset = new ZPlanCommonGltfFAsset(zPlanFAssetInfo, path22);
        z18 = downloadFromNet;
        return new Pair(zPlanCommonGltfFAsset, Boxing.boxBoolean(z18));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ Object J0(com.tencent.zplan.zplantracing.c cVar, JSONObject jSONObject, FilamentUrlTemplate filamentUrlTemplate, boolean z16, Continuation<? super Pair<? extends Map<String, ZPlanFAsset>, Boolean>> continuation) {
        return CoroutineScopeKt.coroutineScope(new ZPlanAvatarResourceHelper$slotFAssetMapWithAvatar$2(cVar, jSONObject, filamentUrlTemplate, z16, null), continuation);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Removed duplicated region for block: B:12:0x00a3  */
    /* JADX WARN: Removed duplicated region for block: B:15:0x00ad  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0040  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x002b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final /* synthetic */ Object K(com.tencent.zplan.zplantracing.c cVar, FilamentUrlTemplate filamentUrlTemplate, Continuation<? super Pair<? extends ZPlanCommonGltfFAsset, Boolean>> continuation) {
        ZPlanAvatarResourceHelper$fetchFeet$1 zPlanAvatarResourceHelper$fetchFeet$1;
        Object coroutine_suspended;
        int i3;
        String defaultTorsoUrl;
        String replace$default;
        int i16;
        ZPlanFAssetInfo zPlanFAssetInfo;
        Resource resource;
        if (continuation instanceof ZPlanAvatarResourceHelper$fetchFeet$1) {
            zPlanAvatarResourceHelper$fetchFeet$1 = (ZPlanAvatarResourceHelper$fetchFeet$1) continuation;
            int i17 = zPlanAvatarResourceHelper$fetchFeet$1.label;
            if ((i17 & Integer.MIN_VALUE) != 0) {
                zPlanAvatarResourceHelper$fetchFeet$1.label = i17 - Integer.MIN_VALUE;
                ZPlanAvatarResourceHelper$fetchFeet$1 zPlanAvatarResourceHelper$fetchFeet$12 = zPlanAvatarResourceHelper$fetchFeet$1;
                Object obj = zPlanAvatarResourceHelper$fetchFeet$12.result;
                coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i3 = zPlanAvatarResourceHelper$fetchFeet$12.label;
                boolean z16 = false;
                if (i3 == 0) {
                    if (i3 == 1) {
                        i16 = zPlanAvatarResourceHelper$fetchFeet$12.I$0;
                        zPlanFAssetInfo = (ZPlanFAssetInfo) zPlanAvatarResourceHelper$fetchFeet$12.L$0;
                        ResultKt.throwOnFailure(obj);
                    } else {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                } else {
                    ResultKt.throwOnFailure(obj);
                    if (FilamentFeatureUtil.f106409g.e()) {
                        FLog.INSTANCE.i("FilamentNativeApp[ZPlanAvatarResourceHelper]", "defaultTorsoV2 Enabled");
                        defaultTorsoUrl = filamentUrlTemplate.getDefaultTorsoUrlV2();
                    } else {
                        defaultTorsoUrl = filamentUrlTemplate.getDefaultTorsoUrl();
                    }
                    replace$default = StringsKt__StringsJVMKt.replace$default(defaultTorsoUrl, "{filename}", "Feet/SK_CH_N_Feet", false, 4, (Object) null);
                    ZPlanFAssetInfo zPlanFAssetInfo2 = new ZPlanFAssetInfo(TorsoSlot.FEET.getKey(), replace$default);
                    zPlanAvatarResourceHelper$fetchFeet$12.L$0 = zPlanFAssetInfo2;
                    zPlanAvatarResourceHelper$fetchFeet$12.I$0 = 0;
                    zPlanAvatarResourceHelper$fetchFeet$12.label = 1;
                    Object M = M(this, cVar, replace$default, null, "gltf", filamentUrlTemplate, false, zPlanAvatarResourceHelper$fetchFeet$12, 36, null);
                    if (M == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    i16 = 0;
                    zPlanFAssetInfo = zPlanFAssetInfo2;
                    obj = M;
                }
                resource = (Resource) obj;
                String path = resource.getPath();
                if (resource.getDownloadFromNet()) {
                    i16 = 1;
                }
                ZPlanCommonGltfFAsset zPlanCommonGltfFAsset = new ZPlanCommonGltfFAsset(zPlanFAssetInfo, path);
                if (i16 != 0) {
                    z16 = true;
                }
                return new Pair(zPlanCommonGltfFAsset, Boxing.boxBoolean(z16));
            }
        }
        zPlanAvatarResourceHelper$fetchFeet$1 = new ZPlanAvatarResourceHelper$fetchFeet$1(this, continuation);
        ZPlanAvatarResourceHelper$fetchFeet$1 zPlanAvatarResourceHelper$fetchFeet$122 = zPlanAvatarResourceHelper$fetchFeet$1;
        Object obj2 = zPlanAvatarResourceHelper$fetchFeet$122.result;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i3 = zPlanAvatarResourceHelper$fetchFeet$122.label;
        boolean z162 = false;
        if (i3 == 0) {
        }
        resource = (Resource) obj2;
        String path2 = resource.getPath();
        if (resource.getDownloadFromNet()) {
        }
        ZPlanCommonGltfFAsset zPlanCommonGltfFAsset2 = new ZPlanCommonGltfFAsset(zPlanFAssetInfo, path2);
        if (i16 != 0) {
        }
        return new Pair(zPlanCommonGltfFAsset2, Boxing.boxBoolean(z162));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ Object K0(JSONObject jSONObject, FilamentUrlTemplate filamentUrlTemplate, Continuation<? super Map<Long, ZPlanFAssetInfo>> continuation) {
        Continuation intercepted;
        JSONArray jSONArray;
        JSONArray jSONArray2;
        Object coroutine_suspended;
        String str;
        JSONObject jSONObject2;
        JSONArray jSONArray3;
        intercepted = IntrinsicsKt__IntrinsicsJvmKt.intercepted(continuation);
        SafeContinuation safeContinuation = new SafeContinuation(intercepted);
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        ArrayList<JSONObject> arrayList = new ArrayList();
        JSONObject optJSONObject = jSONObject.optJSONObject("avatar_info");
        if (optJSONObject != null) {
            jSONArray = optJSONObject.optJSONArray("slot_arr");
        } else {
            jSONArray = null;
        }
        if (jSONArray != null) {
            f105660o.u(arrayList, jSONArray);
        }
        JSONObject optJSONObject2 = jSONObject.optJSONObject("makeup_info");
        if (optJSONObject2 != null) {
            jSONArray2 = optJSONObject2.optJSONArray("slot_arr");
        } else {
            jSONArray2 = null;
        }
        if (jSONArray2 != null) {
            f105660o.u(arrayList, jSONArray2);
        }
        JSONObject jSONObject3 = null;
        JSONObject jSONObject4 = null;
        JSONObject jSONObject5 = null;
        for (JSONObject jSONObject6 : arrayList) {
            long optLong = jSONObject6.optLong(MiniAppReportManager2.KEY_SLOT_ID);
            long optLong2 = jSONObject6.optLong("item_id");
            k kVar = (k) fl0.a.f399763a.a(k.class);
            if (kVar != null) {
                str = kVar.a("zplan_lite_slot_mask");
            } else {
                str = null;
            }
            if (TextUtils.isEmpty(str)) {
                FLog.INSTANCE.e("FilamentNativeApp[ZPlanAvatarResourceHelper]", "slotMask is empty");
                str = "{\"slot_id\": [110, 116]}";
            }
            if (str != null) {
                jSONObject2 = com.tencent.zplan.common.utils.h.f385294a.b(str);
            } else {
                jSONObject2 = null;
            }
            if (jSONObject2 != null) {
                jSONArray3 = jSONObject2.optJSONArray(MiniAppReportManager2.KEY_SLOT_ID);
            } else {
                jSONArray3 = null;
            }
            if (jSONArray3 != null) {
                int length = jSONArray3.length();
                int i3 = 0;
                while (i3 < length) {
                    JSONObject jSONObject7 = jSONObject6;
                    if (optLong == jSONArray3.optLong(i3, 0L)) {
                        break;
                    }
                    i3++;
                    jSONObject6 = jSONObject7;
                }
            }
            JSONObject jSONObject8 = jSONObject6;
            linkedHashMap.put(Boxing.boxLong(optLong), f105660o.v(optLong, optLong2, filamentUrlTemplate));
            if (optLong == AvatarSlot.cfgpb_AvatarSlot_EN_SLOT_HAT.getValue()) {
                jSONObject3 = jSONObject8;
            } else if (optLong == AvatarSlot.cfgpb_AvatarSlot_EN_SLOT_HEADDRESS.getValue()) {
                jSONObject4 = jSONObject8;
            } else if (optLong == AvatarSlot.cfgpb_AvatarSlot_EN_SLOT_HAIR.getValue()) {
                jSONObject5 = jSONObject8;
            }
        }
        ZPlanAvatarResourceHelper zPlanAvatarResourceHelper = f105660o;
        ZPlanUpdateHairInfo o06 = zPlanAvatarResourceHelper.o0(jSONObject3, jSONObject4, jSONObject5);
        if (o06.getNeedUpdate()) {
            AvatarSlot avatarSlot = AvatarSlot.cfgpb_AvatarSlot_EN_SLOT_HAIR;
            Long boxLong = Boxing.boxLong(avatarSlot.getValue());
            long value = avatarSlot.getValue();
            Long itemId = o06.getItemId();
            Intrinsics.checkNotNull(itemId);
            linkedHashMap.put(boxLong, zPlanAvatarResourceHelper.v(value, itemId.longValue(), filamentUrlTemplate));
        }
        safeContinuation.resumeWith(Result.m476constructorimpl(linkedHashMap));
        Object orThrow = safeContinuation.getOrThrow();
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (orThrow == coroutine_suspended) {
            DebugProbes.probeCoroutineSuspended(continuation);
        }
        return orThrow;
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x01ed  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x01f8  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x021b  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x00d8  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x0143  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x0073  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x002e  */
    @Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object L(@Nullable com.tencent.zplan.zplantracing.c cVar, @NotNull String str, @Nullable String str2, @NotNull String str3, @NotNull FilamentUrlTemplate filamentUrlTemplate, boolean z16, @NotNull Continuation<? super Resource> continuation) {
        ZPlanAvatarResourceHelper$fetchFileWithUrl$1 zPlanAvatarResourceHelper$fetchFileWithUrl$1;
        Object coroutine_suspended;
        int i3;
        com.tencent.zplan.zplantracing.c cVar2;
        String str4;
        String str5;
        FilamentUrlTemplate filamentUrlTemplate2;
        boolean z17;
        com.tencent.zplan.zplantracing.b bVar;
        ZPlanAvatarResourceHelper zPlanAvatarResourceHelper;
        String path;
        String filePathInDir;
        com.tencent.zplan.zplantracing.c cVar3;
        String str6;
        String str7;
        String str8;
        String str9;
        String filePathInDir2;
        String str10 = str;
        if (continuation instanceof ZPlanAvatarResourceHelper$fetchFileWithUrl$1) {
            zPlanAvatarResourceHelper$fetchFileWithUrl$1 = (ZPlanAvatarResourceHelper$fetchFileWithUrl$1) continuation;
            int i16 = zPlanAvatarResourceHelper$fetchFileWithUrl$1.label;
            if ((i16 & Integer.MIN_VALUE) != 0) {
                zPlanAvatarResourceHelper$fetchFileWithUrl$1.label = i16 - Integer.MIN_VALUE;
                ZPlanAvatarResourceHelper$fetchFileWithUrl$1 zPlanAvatarResourceHelper$fetchFileWithUrl$12 = zPlanAvatarResourceHelper$fetchFileWithUrl$1;
                Object obj = zPlanAvatarResourceHelper$fetchFileWithUrl$12.result;
                coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i3 = zPlanAvatarResourceHelper$fetchFileWithUrl$12.label;
                if (i3 == 0) {
                    if (i3 != 1) {
                        if (i3 == 2) {
                            str7 = (String) zPlanAvatarResourceHelper$fetchFileWithUrl$12.L$4;
                            bVar = (com.tencent.zplan.zplantracing.b) zPlanAvatarResourceHelper$fetchFileWithUrl$12.L$3;
                            str6 = (String) zPlanAvatarResourceHelper$fetchFileWithUrl$12.L$2;
                            str9 = (String) zPlanAvatarResourceHelper$fetchFileWithUrl$12.L$1;
                            str8 = (String) zPlanAvatarResourceHelper$fetchFileWithUrl$12.L$0;
                            ResultKt.throwOnFailure(obj);
                            Resource resource = (Resource) obj;
                            String path2 = resource.getPath();
                            boolean downloadFromNet = resource.getDownloadFromNet();
                            boolean hit304 = resource.getHit304();
                            FilamentFileUtil filamentFileUtil = FilamentFileUtil.INSTANCE;
                            filePathInDir2 = filamentFileUtil.filePathInDir(path2, str9, str6);
                            FLog fLog = FLog.INSTANCE;
                            fLog.w("FilamentNativeApp[ZPlanAvatarResourceHelper]", "fetchFileWithUrl download again for url:" + str8 + " and extension:" + str6 + ", filePathAgain:" + filePathInDir2 + ", downloadFromNet:" + downloadFromNet);
                            if (filePathInDir2 == null) {
                                if (bVar != null) {
                                    bVar.b();
                                }
                                return new Resource(filePathInDir2, downloadFromNet, hit304);
                            }
                            fLog.i("FilamentNativeApp[ZPlanAvatarResourceHelper]", "not found file after retry. delete " + str7);
                            filamentFileUtil.deleteDirSafely(path2);
                            str5 = str6;
                            str10 = str8;
                            path = str7;
                            if (bVar != null) {
                                bVar.a("found no " + str5 + " in dir: " + path);
                            }
                            throw new FetchFileException(FetchFileException.Type.FILE_NOT_FOUND, 201002, "found no " + str5 + " in dir: " + path + " \u274c", str10);
                        }
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    z17 = zPlanAvatarResourceHelper$fetchFileWithUrl$12.Z$0;
                    bVar = (com.tencent.zplan.zplantracing.b) zPlanAvatarResourceHelper$fetchFileWithUrl$12.L$5;
                    filamentUrlTemplate2 = (FilamentUrlTemplate) zPlanAvatarResourceHelper$fetchFileWithUrl$12.L$4;
                    str5 = (String) zPlanAvatarResourceHelper$fetchFileWithUrl$12.L$3;
                    String str11 = (String) zPlanAvatarResourceHelper$fetchFileWithUrl$12.L$2;
                    str10 = (String) zPlanAvatarResourceHelper$fetchFileWithUrl$12.L$1;
                    zPlanAvatarResourceHelper = (ZPlanAvatarResourceHelper) zPlanAvatarResourceHelper$fetchFileWithUrl$12.L$0;
                    ResultKt.throwOnFailure(obj);
                    str4 = str11;
                } else {
                    ResultKt.throwOnFailure(obj);
                    com.tencent.zplan.zplantracing.b startSpan = ZPlanSpanFactory.INSTANCE.startSpan("fetchFileWithUrl", cVar);
                    if (startSpan != null) {
                        startSpan.e("url", str10);
                    }
                    if (startSpan != null) {
                        cVar2 = startSpan.c();
                    } else {
                        cVar2 = null;
                    }
                    zPlanAvatarResourceHelper$fetchFileWithUrl$12.L$0 = this;
                    zPlanAvatarResourceHelper$fetchFileWithUrl$12.L$1 = str10;
                    str4 = str2;
                    zPlanAvatarResourceHelper$fetchFileWithUrl$12.L$2 = str4;
                    zPlanAvatarResourceHelper$fetchFileWithUrl$12.L$3 = str3;
                    zPlanAvatarResourceHelper$fetchFileWithUrl$12.L$4 = filamentUrlTemplate;
                    zPlanAvatarResourceHelper$fetchFileWithUrl$12.L$5 = startSpan;
                    zPlanAvatarResourceHelper$fetchFileWithUrl$12.Z$0 = z16;
                    zPlanAvatarResourceHelper$fetchFileWithUrl$12.label = 1;
                    obj = g0(cVar2, str, filamentUrlTemplate, z16, zPlanAvatarResourceHelper$fetchFileWithUrl$12);
                    if (obj == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    str5 = str3;
                    filamentUrlTemplate2 = filamentUrlTemplate;
                    z17 = z16;
                    bVar = startSpan;
                    zPlanAvatarResourceHelper = this;
                }
                Resource resource2 = (Resource) obj;
                path = resource2.getPath();
                boolean downloadFromNet2 = resource2.getDownloadFromNet();
                boolean hit3042 = resource2.getHit304();
                FilamentFileUtil filamentFileUtil2 = FilamentFileUtil.INSTANCE;
                filePathInDir = filamentFileUtil2.filePathInDir(path, str4, str5);
                if (filePathInDir == null) {
                    if (new File(filePathInDir).length() > 0) {
                        if (bVar != null) {
                            bVar.b();
                        }
                        return new Resource(filePathInDir, downloadFromNet2, hit3042);
                    }
                    FLog.INSTANCE.e("FilamentNativeApp[ZPlanAvatarResourceHelper]", "fetchFileWithUrl fail. file is empty. filePath:" + filePathInDir + ", url:" + str10);
                    if (bVar != null) {
                        bVar.a("file is empty. filePath:" + filePathInDir);
                    }
                    throw new FetchFileException(FetchFileException.Type.FILE_IS_EMPTY, 201022, "file is empty. filePath:" + filePathInDir, str10);
                }
                FLog.INSTANCE.i("FilamentNativeApp[ZPlanAvatarResourceHelper]", "not found file. delete " + path);
                filamentFileUtil2.deleteDirSafely(path);
                if (!downloadFromNet2 && downloadAgainWhenFileNotFound) {
                    if (bVar != null) {
                        bVar.e(TVKCommonParamEnum.REQ_PARAM_KEY_RETRY, String.valueOf(true));
                    }
                    if (bVar != null) {
                        cVar3 = bVar.c();
                    } else {
                        cVar3 = null;
                    }
                    zPlanAvatarResourceHelper$fetchFileWithUrl$12.L$0 = str10;
                    zPlanAvatarResourceHelper$fetchFileWithUrl$12.L$1 = str4;
                    zPlanAvatarResourceHelper$fetchFileWithUrl$12.L$2 = str5;
                    zPlanAvatarResourceHelper$fetchFileWithUrl$12.L$3 = bVar;
                    zPlanAvatarResourceHelper$fetchFileWithUrl$12.L$4 = path;
                    zPlanAvatarResourceHelper$fetchFileWithUrl$12.L$5 = null;
                    zPlanAvatarResourceHelper$fetchFileWithUrl$12.label = 2;
                    obj = zPlanAvatarResourceHelper.g0(cVar3, str10, filamentUrlTemplate2, z17, zPlanAvatarResourceHelper$fetchFileWithUrl$12);
                    if (obj == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    str6 = str5;
                    str7 = path;
                    str8 = str10;
                    str9 = str4;
                    Resource resource3 = (Resource) obj;
                    String path22 = resource3.getPath();
                    boolean downloadFromNet3 = resource3.getDownloadFromNet();
                    boolean hit3043 = resource3.getHit304();
                    FilamentFileUtil filamentFileUtil3 = FilamentFileUtil.INSTANCE;
                    filePathInDir2 = filamentFileUtil3.filePathInDir(path22, str9, str6);
                    FLog fLog2 = FLog.INSTANCE;
                    fLog2.w("FilamentNativeApp[ZPlanAvatarResourceHelper]", "fetchFileWithUrl download again for url:" + str8 + " and extension:" + str6 + ", filePathAgain:" + filePathInDir2 + ", downloadFromNet:" + downloadFromNet3);
                    if (filePathInDir2 == null) {
                    }
                }
                if (bVar != null) {
                }
                throw new FetchFileException(FetchFileException.Type.FILE_NOT_FOUND, 201002, "found no " + str5 + " in dir: " + path + " \u274c", str10);
            }
        }
        zPlanAvatarResourceHelper$fetchFileWithUrl$1 = new ZPlanAvatarResourceHelper$fetchFileWithUrl$1(this, continuation);
        ZPlanAvatarResourceHelper$fetchFileWithUrl$1 zPlanAvatarResourceHelper$fetchFileWithUrl$122 = zPlanAvatarResourceHelper$fetchFileWithUrl$1;
        Object obj2 = zPlanAvatarResourceHelper$fetchFileWithUrl$122.result;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i3 = zPlanAvatarResourceHelper$fetchFileWithUrl$122.label;
        if (i3 == 0) {
        }
        Resource resource22 = (Resource) obj2;
        path = resource22.getPath();
        boolean downloadFromNet22 = resource22.getDownloadFromNet();
        boolean hit30422 = resource22.getHit304();
        FilamentFileUtil filamentFileUtil22 = FilamentFileUtil.INSTANCE;
        filePathInDir = filamentFileUtil22.filePathInDir(path, str4, str5);
        if (filePathInDir == null) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x007d  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0096  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0099  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x00a2  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x003e  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0025  */
    @Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object N(@Nullable com.tencent.zplan.zplantracing.c cVar, @NotNull FilamentUrlTemplate filamentUrlTemplate, @NotNull Continuation<? super Resource> continuation) {
        ZPlanAvatarResourceHelper$fetchIndirectLightToPath$1 zPlanAvatarResourceHelper$fetchIndirectLightToPath$1;
        Object coroutine_suspended;
        int i3;
        com.tencent.zplan.zplantracing.b startSpan;
        com.tencent.zplan.zplantracing.c cVar2;
        Resource resource;
        if (continuation instanceof ZPlanAvatarResourceHelper$fetchIndirectLightToPath$1) {
            zPlanAvatarResourceHelper$fetchIndirectLightToPath$1 = (ZPlanAvatarResourceHelper$fetchIndirectLightToPath$1) continuation;
            int i16 = zPlanAvatarResourceHelper$fetchIndirectLightToPath$1.label;
            if ((i16 & Integer.MIN_VALUE) != 0) {
                zPlanAvatarResourceHelper$fetchIndirectLightToPath$1.label = i16 - Integer.MIN_VALUE;
                ZPlanAvatarResourceHelper$fetchIndirectLightToPath$1 zPlanAvatarResourceHelper$fetchIndirectLightToPath$12 = zPlanAvatarResourceHelper$fetchIndirectLightToPath$1;
                Object obj = zPlanAvatarResourceHelper$fetchIndirectLightToPath$12.result;
                coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i3 = zPlanAvatarResourceHelper$fetchIndirectLightToPath$12.label;
                boolean z16 = true;
                if (i3 == 0) {
                    if (i3 != 1) {
                        if (i3 == 2) {
                            startSpan = (com.tencent.zplan.zplantracing.b) zPlanAvatarResourceHelper$fetchIndirectLightToPath$12.L$0;
                            ResultKt.throwOnFailure(obj);
                            resource = (Resource) obj;
                            if (startSpan != null) {
                                startSpan.e("downloadFromNet", String.valueOf(resource.d()));
                            }
                            if (resource.e().length() != 0) {
                                z16 = false;
                            }
                            if (!z16) {
                                if (startSpan != null) {
                                    startSpan.a("path null");
                                }
                            } else if (startSpan != null) {
                                startSpan.b();
                            }
                            return resource;
                        }
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.throwOnFailure(obj);
                    return obj;
                }
                ResultKt.throwOnFailure(obj);
                if (enableCppDownload) {
                    zPlanAvatarResourceHelper$fetchIndirectLightToPath$12.label = 1;
                    obj = O(cVar, filamentUrlTemplate, zPlanAvatarResourceHelper$fetchIndirectLightToPath$12);
                    if (obj == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    return obj;
                }
                startSpan = ZPlanSpanFactory.INSTANCE.startSpan("fetchIndirectLight", cVar);
                if (startSpan != null) {
                    cVar2 = startSpan.c();
                } else {
                    cVar2 = null;
                }
                String lightResUrl = filamentUrlTemplate.getLightResUrl();
                zPlanAvatarResourceHelper$fetchIndirectLightToPath$12.L$0 = startSpan;
                zPlanAvatarResourceHelper$fetchIndirectLightToPath$12.label = 2;
                obj = M(this, cVar2, lightResUrl, null, "ktx", filamentUrlTemplate, true, zPlanAvatarResourceHelper$fetchIndirectLightToPath$12, 4, null);
                if (obj == coroutine_suspended) {
                    return coroutine_suspended;
                }
                resource = (Resource) obj;
                if (startSpan != null) {
                }
                if (resource.e().length() != 0) {
                }
                if (!z16) {
                }
                return resource;
            }
        }
        zPlanAvatarResourceHelper$fetchIndirectLightToPath$1 = new ZPlanAvatarResourceHelper$fetchIndirectLightToPath$1(this, continuation);
        ZPlanAvatarResourceHelper$fetchIndirectLightToPath$1 zPlanAvatarResourceHelper$fetchIndirectLightToPath$122 = zPlanAvatarResourceHelper$fetchIndirectLightToPath$1;
        Object obj2 = zPlanAvatarResourceHelper$fetchIndirectLightToPath$122.result;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i3 = zPlanAvatarResourceHelper$fetchIndirectLightToPath$122.label;
        boolean z162 = true;
        if (i3 == 0) {
        }
    }

    @Nullable
    public final String N0(@NotNull String url, @NotNull FilamentUrlTemplate urlTemplate) {
        boolean startsWith$default;
        boolean startsWith$default2;
        String md5;
        boolean z16;
        boolean startsWith$default3;
        boolean startsWith$default4;
        String replace$default;
        Intrinsics.checkNotNullParameter(url, "url");
        Intrinsics.checkNotNullParameter(urlTemplate, "urlTemplate");
        if (enableCppDownload) {
            return avatarService.v(url);
        }
        String systemCacheDirectory = FilamentFileUtil.systemCacheDirectory();
        String n06 = n0(urlTemplate);
        startsWith$default = StringsKt__StringsJVMKt.startsWith$default(systemCacheDirectory, PreDownloadConstants.SDCRAD_DEFAULT, false, 2, null);
        if (startsWith$default) {
            startsWith$default3 = StringsKt__StringsJVMKt.startsWith$default(url, "https://ugc.superqqshow.qq.com", false, 2, null);
            if (!startsWith$default3) {
                startsWith$default4 = StringsKt__StringsJVMKt.startsWith$default(url, n06, false, 2, null);
                if (startsWith$default4) {
                    com.tencent.filament.zplanservice.util.a aVar = new com.tencent.filament.zplanservice.util.a(n06);
                    return FilamentFileUtil.INSTANCE.pathAppend(systemCacheDirectory, aVar.c() + '/' + aVar.b());
                }
                com.tencent.filament.zplanservice.util.a aVar2 = new com.tencent.filament.zplanservice.util.a(url);
                if (!aVar2.a()) {
                    return null;
                }
                replace$default = StringsKt__StringsJVMKt.replace$default(FilamentFileUtil.INSTANCE.pathAppend(systemCacheDirectory, aVar2.c() + '/' + aVar2.b()), ".fasset", "", false, 4, (Object) null);
                return replace$default;
            }
            String c16 = com.tencent.filament.zplanservice.util.c.c(url);
            return FilamentFileUtil.INSTANCE.pathAppend(systemCacheDirectory, "ugc/" + c16);
        }
        startsWith$default2 = StringsKt__StringsJVMKt.startsWith$default(url, n06, false, 2, null);
        if (startsWith$default2) {
            md5 = FilamentMD5Util.md5(n06);
        } else {
            md5 = FilamentMD5Util.md5(url);
        }
        if (md5.length() == 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            FLog.INSTANCE.i("FilamentNativeApp[ZPlanAvatarResourceHelper]", "urlMD5 is empty");
            return null;
        }
        if (md5 != null) {
            String substring = md5.substring(0, 2);
            Intrinsics.checkNotNullExpressionValue(substring, "(this as java.lang.Strin\u2026ing(startIndex, endIndex)");
            String substring2 = md5.substring(2);
            Intrinsics.checkNotNullExpressionValue(substring2, "(this as java.lang.String).substring(startIndex)");
            return FilamentFileUtil.INSTANCE.pathAppend(systemCacheDirectory, substring + '/' + substring2);
        }
        throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x0034  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0023  */
    @Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object O(@Nullable com.tencent.zplan.zplantracing.c cVar, @NotNull FilamentUrlTemplate filamentUrlTemplate, @NotNull Continuation<? super Resource> continuation) {
        ZPlanAvatarResourceHelper$fetchIndirectLightToPathWithCpp$1 zPlanAvatarResourceHelper$fetchIndirectLightToPathWithCpp$1;
        Object coroutine_suspended;
        int i3;
        try {
            if (continuation instanceof ZPlanAvatarResourceHelper$fetchIndirectLightToPathWithCpp$1) {
                zPlanAvatarResourceHelper$fetchIndirectLightToPathWithCpp$1 = (ZPlanAvatarResourceHelper$fetchIndirectLightToPathWithCpp$1) continuation;
                int i16 = zPlanAvatarResourceHelper$fetchIndirectLightToPathWithCpp$1.label;
                if ((i16 & Integer.MIN_VALUE) != 0) {
                    zPlanAvatarResourceHelper$fetchIndirectLightToPathWithCpp$1.label = i16 - Integer.MIN_VALUE;
                    Object obj = zPlanAvatarResourceHelper$fetchIndirectLightToPathWithCpp$1.result;
                    coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    i3 = zPlanAvatarResourceHelper$fetchIndirectLightToPathWithCpp$1.label;
                    if (i3 == 0) {
                        if (i3 == 1) {
                            ResultKt.throwOnFailure(obj);
                        } else {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                    } else {
                        ResultKt.throwOnFailure(obj);
                        ZPlanAvatarService zPlanAvatarService = avatarService;
                        zPlanAvatarResourceHelper$fetchIndirectLightToPathWithCpp$1.label = 1;
                        obj = zPlanAvatarService.C(zPlanAvatarResourceHelper$fetchIndirectLightToPathWithCpp$1);
                        if (obj == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                    }
                    ZPlanAvatarInterfaceResult zPlanAvatarInterfaceResult = (ZPlanAvatarInterfaceResult) obj;
                    return new Resource(zPlanAvatarInterfaceResult.getResult(), zPlanAvatarInterfaceResult.isDownload(), false, 4, null);
                }
            }
            if (i3 == 0) {
            }
            ZPlanAvatarInterfaceResult zPlanAvatarInterfaceResult2 = (ZPlanAvatarInterfaceResult) obj;
            return new Resource(zPlanAvatarInterfaceResult2.getResult(), zPlanAvatarInterfaceResult2.isDownload(), false, 4, null);
        } catch (ZPlanAvatarServiceException e16) {
            throw new FetchFileException(FetchFileException.Type.DOWNLOAD_FAIL, e16.getError().getErrorCode().getValue(), String.valueOf(e16.getError().getErrorMsg()), "");
        }
        zPlanAvatarResourceHelper$fetchIndirectLightToPathWithCpp$1 = new ZPlanAvatarResourceHelper$fetchIndirectLightToPathWithCpp$1(this, continuation);
        Object obj2 = zPlanAvatarResourceHelper$fetchIndirectLightToPathWithCpp$1.result;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i3 = zPlanAvatarResourceHelper$fetchIndirectLightToPathWithCpp$1.label;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:14:0x006c  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x007c  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x003a  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0024  */
    /* JADX WARN: Type inference failed for: r12v4, types: [com.tencent.zplan.zplantracing.b] */
    /* JADX WARN: Type inference failed for: r12v8 */
    /* JADX WARN: Type inference failed for: r12v9 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final /* synthetic */ Object P(com.tencent.zplan.zplantracing.c cVar, FilamentUrlTemplate filamentUrlTemplate, Continuation<? super Resource> continuation) {
        ZPlanAvatarResourceHelper$fetchKawaiiPath$1 zPlanAvatarResourceHelper$fetchKawaiiPath$1;
        Object coroutine_suspended;
        int i3;
        com.tencent.zplan.zplantracing.c cVar2;
        try {
            if (continuation instanceof ZPlanAvatarResourceHelper$fetchKawaiiPath$1) {
                zPlanAvatarResourceHelper$fetchKawaiiPath$1 = (ZPlanAvatarResourceHelper$fetchKawaiiPath$1) continuation;
                int i16 = zPlanAvatarResourceHelper$fetchKawaiiPath$1.label;
                if ((i16 & Integer.MIN_VALUE) != 0) {
                    zPlanAvatarResourceHelper$fetchKawaiiPath$1.label = i16 - Integer.MIN_VALUE;
                    ZPlanAvatarResourceHelper$fetchKawaiiPath$1 zPlanAvatarResourceHelper$fetchKawaiiPath$12 = zPlanAvatarResourceHelper$fetchKawaiiPath$1;
                    Object obj = zPlanAvatarResourceHelper$fetchKawaiiPath$12.result;
                    coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    i3 = zPlanAvatarResourceHelper$fetchKawaiiPath$12.label;
                    if (i3 == 0) {
                        if (i3 == 1) {
                            com.tencent.zplan.zplantracing.b bVar = (com.tencent.zplan.zplantracing.b) zPlanAvatarResourceHelper$fetchKawaiiPath$12.L$0;
                            ResultKt.throwOnFailure(obj);
                            cVar = bVar;
                        } else {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                    } else {
                        ResultKt.throwOnFailure(obj);
                        com.tencent.zplan.zplantracing.b startSpan = ZPlanSpanFactory.INSTANCE.startSpan("fetchKawaii", cVar);
                        String v06 = v0(filamentUrlTemplate);
                        if (startSpan != null) {
                            cVar2 = startSpan.c();
                        } else {
                            cVar2 = null;
                        }
                        zPlanAvatarResourceHelper$fetchKawaiiPath$12.L$0 = startSpan;
                        zPlanAvatarResourceHelper$fetchKawaiiPath$12.label = 1;
                        obj = M(this, cVar2, v06, null, ark.ARKMETADATA_JSON, filamentUrlTemplate, false, zPlanAvatarResourceHelper$fetchKawaiiPath$12, 36, null);
                        cVar = startSpan;
                        if (obj == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                    }
                    Resource resource = (Resource) obj;
                    if (cVar != 0) {
                        cVar.e("downloadFromNet", String.valueOf(resource.d()));
                    }
                    if (cVar != 0) {
                        cVar.b();
                    }
                    return resource;
                }
            }
            if (i3 == 0) {
            }
            Resource resource2 = (Resource) obj;
            if (cVar != 0) {
            }
            if (cVar != 0) {
            }
            return resource2;
        } catch (FetchFileException e16) {
            if (cVar != 0) {
                cVar.a("fetch Kawaii failed");
            }
            throw FetchFileException.copy$default(e16, null, 0, "fetch Kawaii failed \u274c", null, 11, null);
        }
        zPlanAvatarResourceHelper$fetchKawaiiPath$1 = new ZPlanAvatarResourceHelper$fetchKawaiiPath$1(this, continuation);
        ZPlanAvatarResourceHelper$fetchKawaiiPath$1 zPlanAvatarResourceHelper$fetchKawaiiPath$122 = zPlanAvatarResourceHelper$fetchKawaiiPath$1;
        Object obj2 = zPlanAvatarResourceHelper$fetchKawaiiPath$122.result;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i3 = zPlanAvatarResourceHelper$fetchKawaiiPath$122.label;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Can't wrap try/catch for region: R(12:1|(2:3|(10:5|6|7|(1:(1:(6:11|12|13|(1:15)|(1:17)|18)(2:21|22))(2:23|24))(2:25|(2:27|(1:29)(1:24))(2:30|(3:(1:33)|34|35)(7:(1:37)(1:41)|38|(1:40)|13|(0)|(0)|18)))|42|(1:44)|45|(0)|(0)|18))|46|6|7|(0)(0)|42|(0)|45|(0)|(0)|18) */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:15:0x00ba  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x00ca  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0040  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x009b  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0025  */
    /* JADX WARN: Type inference failed for: r12v10 */
    /* JADX WARN: Type inference failed for: r12v5 */
    /* JADX WARN: Type inference failed for: r12v9 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final /* synthetic */ Object Q(com.tencent.zplan.zplantracing.c cVar, FilamentUrlTemplate filamentUrlTemplate, Continuation<? super Resource> continuation) {
        ZPlanAvatarResourceHelper$fetchLightAiBodyRefPath$1 zPlanAvatarResourceHelper$fetchLightAiBodyRefPath$1;
        Object coroutine_suspended;
        int i3;
        Resource resource;
        com.tencent.zplan.zplantracing.b bVar;
        com.tencent.zplan.zplantracing.c cVar2;
        if (continuation instanceof ZPlanAvatarResourceHelper$fetchLightAiBodyRefPath$1) {
            zPlanAvatarResourceHelper$fetchLightAiBodyRefPath$1 = (ZPlanAvatarResourceHelper$fetchLightAiBodyRefPath$1) continuation;
            int i16 = zPlanAvatarResourceHelper$fetchLightAiBodyRefPath$1.label;
            if ((i16 & Integer.MIN_VALUE) != 0) {
                zPlanAvatarResourceHelper$fetchLightAiBodyRefPath$1.label = i16 - Integer.MIN_VALUE;
                ZPlanAvatarResourceHelper$fetchLightAiBodyRefPath$1 zPlanAvatarResourceHelper$fetchLightAiBodyRefPath$12 = zPlanAvatarResourceHelper$fetchLightAiBodyRefPath$1;
                Object obj = zPlanAvatarResourceHelper$fetchLightAiBodyRefPath$12.result;
                coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i3 = zPlanAvatarResourceHelper$fetchLightAiBodyRefPath$12.label;
                if (i3 == 0) {
                    if (i3 != 1) {
                        if (i3 == 2) {
                            com.tencent.zplan.zplantracing.b bVar2 = (com.tencent.zplan.zplantracing.b) zPlanAvatarResourceHelper$fetchLightAiBodyRefPath$12.L$0;
                            ResultKt.throwOnFailure(obj);
                            cVar = bVar2;
                            resource = (Resource) obj;
                            bVar = cVar;
                            if (bVar != null) {
                                bVar.e("downloadFromNet", String.valueOf(resource.d()));
                            }
                            if (bVar != null) {
                                bVar.b();
                            }
                            return resource;
                        }
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.throwOnFailure(obj);
                    return obj;
                }
                ResultKt.throwOnFailure(obj);
                if (enableCppDownload) {
                    zPlanAvatarResourceHelper$fetchLightAiBodyRefPath$12.label = 1;
                    obj = R(cVar, filamentUrlTemplate, zPlanAvatarResourceHelper$fetchLightAiBodyRefPath$12);
                    if (obj == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    return obj;
                }
                com.tencent.zplan.zplantracing.b startSpan = ZPlanSpanFactory.INSTANCE.startSpan("fetchLightAiBody", cVar);
                String lightAIBodyDriveRefPoseUrl = filamentUrlTemplate.getLightAIBodyDriveRefPoseUrl();
                if (TextUtils.isEmpty(lightAIBodyDriveRefPoseUrl)) {
                    if (startSpan != null) {
                        startSpan.a("url is null");
                    }
                    return new Resource(null, false, false, 7, null);
                }
                if (startSpan != null) {
                    cVar2 = startSpan.c();
                } else {
                    cVar2 = null;
                }
                zPlanAvatarResourceHelper$fetchLightAiBodyRefPath$12.L$0 = startSpan;
                zPlanAvatarResourceHelper$fetchLightAiBodyRefPath$12.label = 2;
                obj = M(this, cVar2, lightAIBodyDriveRefPoseUrl, null, ark.ARKMETADATA_JSON, filamentUrlTemplate, false, zPlanAvatarResourceHelper$fetchLightAiBodyRefPath$12, 36, null);
                cVar = startSpan;
                if (obj == coroutine_suspended) {
                    return coroutine_suspended;
                }
                resource = (Resource) obj;
                bVar = cVar;
                if (bVar != null) {
                }
                if (bVar != null) {
                }
                return resource;
                if (cVar != 0) {
                    cVar.a(e.getErrorMessage());
                }
                FLog.INSTANCE.e("FilamentNativeApp[ZPlanAvatarResourceHelper]", "fetchAiBodyRefPath exception", e);
                resource = new Resource(null, true, false, 5, null);
                bVar = cVar;
                if (bVar != null) {
                }
                if (bVar != null) {
                }
                return resource;
            }
        }
        zPlanAvatarResourceHelper$fetchLightAiBodyRefPath$1 = new ZPlanAvatarResourceHelper$fetchLightAiBodyRefPath$1(this, continuation);
        ZPlanAvatarResourceHelper$fetchLightAiBodyRefPath$1 zPlanAvatarResourceHelper$fetchLightAiBodyRefPath$122 = zPlanAvatarResourceHelper$fetchLightAiBodyRefPath$1;
        Object obj2 = zPlanAvatarResourceHelper$fetchLightAiBodyRefPath$122.result;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i3 = zPlanAvatarResourceHelper$fetchLightAiBodyRefPath$122.label;
        if (i3 == 0) {
        }
        if (cVar != 0) {
        }
        FLog.INSTANCE.e("FilamentNativeApp[ZPlanAvatarResourceHelper]", "fetchAiBodyRefPath exception", e);
        resource = new Resource(null, true, false, 5, null);
        bVar = cVar;
        if (bVar != null) {
        }
        if (bVar != null) {
        }
        return resource;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0037  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0026  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final /* synthetic */ Object R(com.tencent.zplan.zplantracing.c cVar, FilamentUrlTemplate filamentUrlTemplate, Continuation<? super Resource> continuation) {
        ZPlanAvatarResourceHelper$fetchLightAiBodyRefPathWithCpp$1 zPlanAvatarResourceHelper$fetchLightAiBodyRefPathWithCpp$1;
        Object coroutine_suspended;
        int i3;
        try {
            if (continuation instanceof ZPlanAvatarResourceHelper$fetchLightAiBodyRefPathWithCpp$1) {
                zPlanAvatarResourceHelper$fetchLightAiBodyRefPathWithCpp$1 = (ZPlanAvatarResourceHelper$fetchLightAiBodyRefPathWithCpp$1) continuation;
                int i16 = zPlanAvatarResourceHelper$fetchLightAiBodyRefPathWithCpp$1.label;
                if ((i16 & Integer.MIN_VALUE) != 0) {
                    zPlanAvatarResourceHelper$fetchLightAiBodyRefPathWithCpp$1.label = i16 - Integer.MIN_VALUE;
                    Object obj = zPlanAvatarResourceHelper$fetchLightAiBodyRefPathWithCpp$1.result;
                    coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    i3 = zPlanAvatarResourceHelper$fetchLightAiBodyRefPathWithCpp$1.label;
                    if (i3 == 0) {
                        if (i3 == 1) {
                            ResultKt.throwOnFailure(obj);
                        } else {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                    } else {
                        ResultKt.throwOnFailure(obj);
                        FLog.INSTANCE.i("FilamentNativeApp[ZPlanAvatarResourceHelper]V2", "fetchLightAiBodyRefPathWithCpp.");
                        ZPlanAvatarService zPlanAvatarService = avatarService;
                        zPlanAvatarResourceHelper$fetchLightAiBodyRefPathWithCpp$1.label = 1;
                        obj = zPlanAvatarService.w(zPlanAvatarResourceHelper$fetchLightAiBodyRefPathWithCpp$1);
                        if (obj == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                    }
                    ZPlanAvatarInterfaceResult zPlanAvatarInterfaceResult = (ZPlanAvatarInterfaceResult) obj;
                    FLog.INSTANCE.i("FilamentNativeApp[ZPlanAvatarResourceHelper]V2", "fetchLightAiBodyRefPathWithCpp succ.");
                    return new Resource(zPlanAvatarInterfaceResult.getResult(), zPlanAvatarInterfaceResult.isDownload(), false, 4, null);
                }
            }
            if (i3 == 0) {
            }
            ZPlanAvatarInterfaceResult zPlanAvatarInterfaceResult2 = (ZPlanAvatarInterfaceResult) obj;
            FLog.INSTANCE.i("FilamentNativeApp[ZPlanAvatarResourceHelper]V2", "fetchLightAiBodyRefPathWithCpp succ.");
            return new Resource(zPlanAvatarInterfaceResult2.getResult(), zPlanAvatarInterfaceResult2.isDownload(), false, 4, null);
        } catch (ZPlanAvatarServiceException e16) {
            FLog.INSTANCE.e("FilamentNativeApp[ZPlanAvatarResourceHelper]V2", "fetchLightAiBodyRefPathWithCpp fail. e:" + e16.toString());
            return new Resource(null, true, false, 5, null);
        }
        zPlanAvatarResourceHelper$fetchLightAiBodyRefPathWithCpp$1 = new ZPlanAvatarResourceHelper$fetchLightAiBodyRefPathWithCpp$1(this, continuation);
        Object obj2 = zPlanAvatarResourceHelper$fetchLightAiBodyRefPathWithCpp$1.result;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i3 = zPlanAvatarResourceHelper$fetchLightAiBodyRefPathWithCpp$1.label;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:14:0x006c  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x007c  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x003a  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0024  */
    /* JADX WARN: Type inference failed for: r12v4, types: [com.tencent.zplan.zplantracing.b] */
    /* JADX WARN: Type inference failed for: r12v8 */
    /* JADX WARN: Type inference failed for: r12v9 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final /* synthetic */ Object S(com.tencent.zplan.zplantracing.c cVar, FilamentUrlTemplate filamentUrlTemplate, Continuation<? super Resource> continuation) {
        ZPlanAvatarResourceHelper$fetchLutToFolder$1 zPlanAvatarResourceHelper$fetchLutToFolder$1;
        Object coroutine_suspended;
        int i3;
        com.tencent.zplan.zplantracing.c cVar2;
        try {
            if (continuation instanceof ZPlanAvatarResourceHelper$fetchLutToFolder$1) {
                zPlanAvatarResourceHelper$fetchLutToFolder$1 = (ZPlanAvatarResourceHelper$fetchLutToFolder$1) continuation;
                int i16 = zPlanAvatarResourceHelper$fetchLutToFolder$1.label;
                if ((i16 & Integer.MIN_VALUE) != 0) {
                    zPlanAvatarResourceHelper$fetchLutToFolder$1.label = i16 - Integer.MIN_VALUE;
                    ZPlanAvatarResourceHelper$fetchLutToFolder$1 zPlanAvatarResourceHelper$fetchLutToFolder$12 = zPlanAvatarResourceHelper$fetchLutToFolder$1;
                    Object obj = zPlanAvatarResourceHelper$fetchLutToFolder$12.result;
                    coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    i3 = zPlanAvatarResourceHelper$fetchLutToFolder$12.label;
                    if (i3 == 0) {
                        if (i3 == 1) {
                            com.tencent.zplan.zplantracing.b bVar = (com.tencent.zplan.zplantracing.b) zPlanAvatarResourceHelper$fetchLutToFolder$12.L$0;
                            ResultKt.throwOnFailure(obj);
                            cVar = bVar;
                        } else {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                    } else {
                        ResultKt.throwOnFailure(obj);
                        com.tencent.zplan.zplantracing.b startSpan = ZPlanSpanFactory.INSTANCE.startSpan("fetchLut", cVar);
                        if (startSpan != null) {
                            cVar2 = startSpan.c();
                        } else {
                            cVar2 = null;
                        }
                        String lutResUrl = filamentUrlTemplate.getLutResUrl();
                        zPlanAvatarResourceHelper$fetchLutToFolder$12.L$0 = startSpan;
                        zPlanAvatarResourceHelper$fetchLutToFolder$12.label = 1;
                        obj = M(this, cVar2, lutResUrl, null, "png", filamentUrlTemplate, false, zPlanAvatarResourceHelper$fetchLutToFolder$12, 36, null);
                        cVar = startSpan;
                        if (obj == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                    }
                    Resource resource = (Resource) obj;
                    if (cVar != 0) {
                        cVar.e("downloadFromNet", String.valueOf(resource.d()));
                    }
                    if (cVar != 0) {
                        cVar.b();
                    }
                    return resource;
                }
            }
            if (i3 == 0) {
            }
            Resource resource2 = (Resource) obj;
            if (cVar != 0) {
            }
            if (cVar != 0) {
            }
            return resource2;
        } catch (FetchFileException e16) {
            if (cVar != 0) {
                cVar.a(e16.getErrorMessage());
            }
            throw FetchFileException.copy$default(e16, null, 0, "fetch lut failed \u274c", null, 11, null);
        }
        zPlanAvatarResourceHelper$fetchLutToFolder$1 = new ZPlanAvatarResourceHelper$fetchLutToFolder$1(this, continuation);
        ZPlanAvatarResourceHelper$fetchLutToFolder$1 zPlanAvatarResourceHelper$fetchLutToFolder$122 = zPlanAvatarResourceHelper$fetchLutToFolder$1;
        Object obj2 = zPlanAvatarResourceHelper$fetchLutToFolder$122.result;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i3 = zPlanAvatarResourceHelper$fetchLutToFolder$122.label;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ Object T(JSONObject jSONObject, com.tencent.zplan.zplantracing.c cVar, Continuation<? super Double> continuation) {
        JSONArray jSONArray;
        JSONObject jSONObject2;
        boolean z16;
        com.tencent.zplan.zplantracing.b startSpan = ZPlanSpanFactory.INSTANCE.startSpan("fetchPantsLength", cVar);
        JSONObject optJSONObject = jSONObject.optJSONObject("avatar_info");
        String str = null;
        if (optJSONObject != null) {
            jSONArray = optJSONObject.optJSONArray("slot_arr");
        } else {
            jSONArray = null;
        }
        double d16 = 0.0d;
        if (jSONArray != null && jSONArray.length() > 0) {
            int length = jSONArray.length();
            int i3 = 0;
            while (true) {
                if (i3 < length) {
                    jSONObject2 = jSONArray.optJSONObject(i3);
                    if (jSONObject2 != null && jSONObject2.optLong(MiniAppReportManager2.KEY_SLOT_ID) == AvatarSlot.cfgpb_AvatarSlot_EN_SLOT_BOTTOM.getValue()) {
                        break;
                    }
                    i3++;
                } else {
                    jSONObject2 = null;
                    break;
                }
            }
            if (jSONObject2 == null) {
                int i16 = 0;
                while (true) {
                    if (i16 < length) {
                        JSONObject optJSONObject2 = jSONArray.optJSONObject(i16);
                        if (optJSONObject2 != null && optJSONObject2.optLong(MiniAppReportManager2.KEY_SLOT_ID) == AvatarSlot.cfgpb_AvatarSlot_EN_SLOT_SUIT.getValue()) {
                            jSONObject2 = optJSONObject2;
                            break;
                        }
                        i16++;
                    } else {
                        break;
                    }
                }
            }
            if (jSONObject2 != null) {
                JSONObject optJSONObject3 = jSONObject2.optJSONObject("item_data");
                if (optJSONObject3 != null) {
                    str = optJSONObject3.optString("additional_info");
                }
                if (str != null && str.length() != 0) {
                    z16 = false;
                } else {
                    z16 = true;
                }
                if (z16) {
                    if (startSpan != null) {
                        startSpan.e("hasSlot", String.valueOf(false));
                    }
                    if (startSpan != null) {
                        startSpan.b();
                    }
                    return Boxing.boxDouble(0.0d);
                }
                try {
                    d16 = Double.parseDouble(str);
                } catch (NumberFormatException e16) {
                    FLog.INSTANCE.e("FilamentNativeApp[ZPlanAvatarResourceHelper]", "fetchPantsLengthWithAvatar, additionalInfo to Double exception", e16);
                }
            }
            if (startSpan != null) {
                startSpan.b();
            }
            return Boxing.boxDouble(d16);
        }
        if (startSpan != null) {
            startSpan.e("hasSlot", String.valueOf(false));
        }
        if (startSpan != null) {
            startSpan.b();
        }
        return Boxing.boxDouble(0.0d);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Removed duplicated region for block: B:12:0x0069  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0079  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0037  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0024  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final /* synthetic */ Object U(com.tencent.zplan.zplantracing.c cVar, FilamentUrlTemplate filamentUrlTemplate, Continuation<? super Resource> continuation) {
        ZPlanAvatarResourceHelper$fetchPinchFaceConfigJsonPath$1 zPlanAvatarResourceHelper$fetchPinchFaceConfigJsonPath$1;
        Object coroutine_suspended;
        int i3;
        com.tencent.zplan.zplantracing.b startSpan;
        com.tencent.zplan.zplantracing.c cVar2;
        if (continuation instanceof ZPlanAvatarResourceHelper$fetchPinchFaceConfigJsonPath$1) {
            zPlanAvatarResourceHelper$fetchPinchFaceConfigJsonPath$1 = (ZPlanAvatarResourceHelper$fetchPinchFaceConfigJsonPath$1) continuation;
            int i16 = zPlanAvatarResourceHelper$fetchPinchFaceConfigJsonPath$1.label;
            if ((i16 & Integer.MIN_VALUE) != 0) {
                zPlanAvatarResourceHelper$fetchPinchFaceConfigJsonPath$1.label = i16 - Integer.MIN_VALUE;
                ZPlanAvatarResourceHelper$fetchPinchFaceConfigJsonPath$1 zPlanAvatarResourceHelper$fetchPinchFaceConfigJsonPath$12 = zPlanAvatarResourceHelper$fetchPinchFaceConfigJsonPath$1;
                Object obj = zPlanAvatarResourceHelper$fetchPinchFaceConfigJsonPath$12.result;
                coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i3 = zPlanAvatarResourceHelper$fetchPinchFaceConfigJsonPath$12.label;
                if (i3 == 0) {
                    if (i3 == 1) {
                        startSpan = (com.tencent.zplan.zplantracing.b) zPlanAvatarResourceHelper$fetchPinchFaceConfigJsonPath$12.L$0;
                        ResultKt.throwOnFailure(obj);
                    } else {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                } else {
                    ResultKt.throwOnFailure(obj);
                    startSpan = ZPlanSpanFactory.INSTANCE.startSpan("fetchPinchFaceConfig", cVar);
                    if (startSpan != null) {
                        cVar2 = startSpan.c();
                    } else {
                        cVar2 = null;
                    }
                    String pinchFaceConfigUrl = filamentUrlTemplate.getPinchFaceConfigUrl();
                    zPlanAvatarResourceHelper$fetchPinchFaceConfigJsonPath$12.L$0 = startSpan;
                    zPlanAvatarResourceHelper$fetchPinchFaceConfigJsonPath$12.label = 1;
                    obj = M(this, cVar2, pinchFaceConfigUrl, null, ark.ARKMETADATA_JSON, filamentUrlTemplate, false, zPlanAvatarResourceHelper$fetchPinchFaceConfigJsonPath$12, 36, null);
                    if (obj == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                }
                Resource resource = (Resource) obj;
                if (startSpan != null) {
                    startSpan.e("downloadFromNet", String.valueOf(resource.d()));
                }
                if (startSpan != null) {
                    startSpan.b();
                }
                return resource;
            }
        }
        zPlanAvatarResourceHelper$fetchPinchFaceConfigJsonPath$1 = new ZPlanAvatarResourceHelper$fetchPinchFaceConfigJsonPath$1(this, continuation);
        ZPlanAvatarResourceHelper$fetchPinchFaceConfigJsonPath$1 zPlanAvatarResourceHelper$fetchPinchFaceConfigJsonPath$122 = zPlanAvatarResourceHelper$fetchPinchFaceConfigJsonPath$1;
        Object obj2 = zPlanAvatarResourceHelper$fetchPinchFaceConfigJsonPath$122.result;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i3 = zPlanAvatarResourceHelper$fetchPinchFaceConfigJsonPath$122.label;
        if (i3 == 0) {
        }
        Resource resource2 = (Resource) obj2;
        if (startSpan != null) {
        }
        if (startSpan != null) {
        }
        return resource2;
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x0107  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0047  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x002b  */
    @Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object V(@Nullable com.tencent.zplan.zplantracing.c cVar, @NotNull JSONObject jSONObject, @NotNull FilamentUrlTemplate filamentUrlTemplate, boolean z16, @NotNull Continuation<? super ReloadAvatarResourceModel> continuation) throws FetchFileException, BlackListResourceException, RuntimeException {
        ZPlanAvatarResourceHelper$fetchReloadAvatarResource$1 zPlanAvatarResourceHelper$fetchReloadAvatarResource$1;
        Object coroutine_suspended;
        int i3;
        String str;
        boolean z17;
        String str2;
        if (continuation instanceof ZPlanAvatarResourceHelper$fetchReloadAvatarResource$1) {
            zPlanAvatarResourceHelper$fetchReloadAvatarResource$1 = (ZPlanAvatarResourceHelper$fetchReloadAvatarResource$1) continuation;
            int i16 = zPlanAvatarResourceHelper$fetchReloadAvatarResource$1.label;
            if ((i16 & Integer.MIN_VALUE) != 0) {
                zPlanAvatarResourceHelper$fetchReloadAvatarResource$1.label = i16 - Integer.MIN_VALUE;
                ZPlanAvatarResourceHelper$fetchReloadAvatarResource$1 zPlanAvatarResourceHelper$fetchReloadAvatarResource$12 = zPlanAvatarResourceHelper$fetchReloadAvatarResource$1;
                Object obj = zPlanAvatarResourceHelper$fetchReloadAvatarResource$12.result;
                coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i3 = zPlanAvatarResourceHelper$fetchReloadAvatarResource$12.label;
                if (i3 == 0) {
                    if (i3 != 1) {
                        if (i3 == 2) {
                            z17 = zPlanAvatarResourceHelper$fetchReloadAvatarResource$12.Z$0;
                            str2 = (String) zPlanAvatarResourceHelper$fetchReloadAvatarResource$12.L$0;
                            ResultKt.throwOnFailure(obj);
                            ReloadAvatarResourceModel reloadAvatarResourceModel = (ReloadAvatarResourceModel) obj;
                            if (z17) {
                                avatarResourceCache.a(str2, reloadAvatarResourceModel);
                            }
                            return reloadAvatarResourceModel;
                        }
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.throwOnFailure(obj);
                    return obj;
                }
                ResultKt.throwOnFailure(obj);
                if (enableCppDownload) {
                    zPlanAvatarResourceHelper$fetchReloadAvatarResource$12.label = 1;
                    obj = Y(cVar, jSONObject, filamentUrlTemplate, z16, zPlanAvatarResourceHelper$fetchReloadAvatarResource$12);
                    if (obj == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    return obj;
                }
                boolean c16 = FilamentFeatureUtil.f106409g.c();
                if (c16) {
                    StringBuilder sb5 = new StringBuilder();
                    sb5.append(jSONObject);
                    sb5.append(util.base64_pad_url);
                    sb5.append(filamentUrlTemplate);
                    sb5.append(util.base64_pad_url);
                    sb5.append(z16);
                    str = sb5.toString();
                    b<ReloadAvatarResourceModel> bVar = avatarResourceCache;
                    ReloadAvatarResourceModel c17 = bVar.c(str);
                    if (c17 != null) {
                        if (c17.E()) {
                            ReloadAvatarResourceModel k3 = ReloadAvatarResourceModel.k(c17, null, null, null, null, null, 0.0d, 0.0d, null, null, null, 1023, null);
                            k3.G(true);
                            return k3;
                        }
                        FLog.INSTANCE.w("FilamentNativeApp[ZPlanAvatarResourceHelper]", "fetchReloadAvatarResource, cache inValid");
                    } else {
                        FLog.INSTANCE.i("FilamentNativeApp[ZPlanAvatarResourceHelper]", "not hit cache, avatarResourceCache=" + bVar);
                    }
                    bVar.d();
                } else {
                    str = "";
                }
                String str3 = str;
                zPlanAvatarResourceHelper$fetchReloadAvatarResource$12.L$0 = str3;
                zPlanAvatarResourceHelper$fetchReloadAvatarResource$12.Z$0 = c16;
                zPlanAvatarResourceHelper$fetchReloadAvatarResource$12.label = 2;
                Object X = X(cVar, jSONObject, filamentUrlTemplate, z16, zPlanAvatarResourceHelper$fetchReloadAvatarResource$12);
                if (X == coroutine_suspended) {
                    return coroutine_suspended;
                }
                z17 = c16;
                obj = X;
                str2 = str3;
                ReloadAvatarResourceModel reloadAvatarResourceModel2 = (ReloadAvatarResourceModel) obj;
                if (z17) {
                }
                return reloadAvatarResourceModel2;
            }
        }
        zPlanAvatarResourceHelper$fetchReloadAvatarResource$1 = new ZPlanAvatarResourceHelper$fetchReloadAvatarResource$1(this, continuation);
        ZPlanAvatarResourceHelper$fetchReloadAvatarResource$1 zPlanAvatarResourceHelper$fetchReloadAvatarResource$122 = zPlanAvatarResourceHelper$fetchReloadAvatarResource$1;
        Object obj2 = zPlanAvatarResourceHelper$fetchReloadAvatarResource$122.result;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i3 = zPlanAvatarResourceHelper$fetchReloadAvatarResource$122.label;
        if (i3 == 0) {
        }
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:7:0x0029. Please report as an issue. */
    /* JADX WARN: Removed duplicated region for block: B:11:0x0035  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0963  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0969  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x098b  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x099d  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x096b  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x0965  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x0089  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0942 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:38:0x0943  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x00e5  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x08f4 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:43:0x08f5  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x013d  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x086c  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x08ac A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:50:0x08ad  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x01a7  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x0853 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:55:0x0854  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x020e  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x07e9 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:60:0x07ea  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x026f  */
    /* JADX WARN: Removed duplicated region for block: B:64:0x0794 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:65:0x0795  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x02c3  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x06c0  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x0741 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:73:0x0742  */
    /* JADX WARN: Removed duplicated region for block: B:74:0x06f2  */
    /* JADX WARN: Removed duplicated region for block: B:75:0x0327  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x068d A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:79:0x068e  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x0380  */
    /* JADX WARN: Removed duplicated region for block: B:83:0x063b A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:84:0x063c  */
    /* JADX WARN: Removed duplicated region for block: B:85:0x03eb  */
    /* JADX WARN: Removed duplicated region for block: B:88:0x0598  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x002c  */
    /* JADX WARN: Removed duplicated region for block: B:91:0x05e3 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:92:0x05e4  */
    /* JADX WARN: Removed duplicated region for block: B:93:0x059d  */
    /* JADX WARN: Removed duplicated region for block: B:94:0x044b  */
    @Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object X(@Nullable com.tencent.zplan.zplantracing.c cVar, @NotNull JSONObject jSONObject, @NotNull FilamentUrlTemplate filamentUrlTemplate, boolean z16, @NotNull Continuation<? super ReloadAvatarResourceModel> continuation) throws FetchFileException, BlackListResourceException, RuntimeException {
        ZPlanAvatarResourceHelper$fetchReloadAvatarResourceNotUseCache$1 zPlanAvatarResourceHelper$fetchReloadAvatarResourceNotUseCache$1;
        ZPlanAvatarResourceHelper$fetchReloadAvatarResourceNotUseCache$1 zPlanAvatarResourceHelper$fetchReloadAvatarResourceNotUseCache$12;
        Object coroutine_suspended;
        com.tencent.zplan.zplantracing.b startSpan;
        com.tencent.zplan.zplantracing.b startSpan2;
        CoroutineScope CoroutineScope;
        Deferred async$default;
        Deferred async$default2;
        Deferred async$default3;
        Deferred async$default4;
        Deferred async$default5;
        Deferred async$default6;
        Deferred async$default7;
        Deferred async$default8;
        Deferred async$default9;
        Deferred async$default10;
        boolean z17;
        List mutableListOf;
        ZPlanAvatarResourceHelper zPlanAvatarResourceHelper;
        Object obj;
        Deferred deferred;
        EnumUserGender enumUserGender;
        Deferred deferred2;
        Deferred deferred3;
        Deferred deferred4;
        Object obj2;
        FilamentUrlTemplate filamentUrlTemplate2;
        Deferred deferred5;
        List list;
        Deferred deferred6;
        Deferred deferred7;
        Object d06;
        Object obj3;
        Object obj4;
        Deferred deferred8;
        List list2;
        List list3;
        Deferred deferred9;
        Deferred deferred10;
        boolean z18;
        Map<String, ZPlanFAsset> map;
        Deferred deferred11;
        EnumUserGender enumUserGender2;
        Deferred deferred12;
        Deferred deferred13;
        FilamentUrlTemplate filamentUrlTemplate3;
        Deferred deferred14;
        boolean z19;
        Object await;
        Object obj5;
        Object obj6;
        Deferred deferred15;
        EnumUserGender enumUserGender3;
        FilamentUrlTemplate filamentUrlTemplate4;
        Deferred deferred16;
        Map<String, ZPlanFAsset> map2;
        Deferred deferred17;
        List list4;
        Deferred deferred18;
        Object await2;
        Object obj7;
        EnumUserGender enumUserGender4;
        Deferred deferred19;
        boolean z26;
        Deferred deferred20;
        Deferred deferred21;
        List list5;
        Deferred deferred22;
        Deferred deferred23;
        boolean z27;
        FilamentUrlTemplate filamentUrlTemplate5;
        CoroutineScope coroutineScope;
        String str;
        Deferred deferred24;
        Map<String, ZPlanFAsset> map3;
        ZPlanCommonGltfFAsset zPlanCommonGltfFAsset;
        Object obj8;
        Deferred deferred25;
        Deferred deferred26;
        Deferred deferred27;
        ZPlanCommonGltfFAsset zPlanCommonGltfFAsset2;
        List list6;
        boolean z28;
        boolean z29;
        Object await3;
        Object obj9;
        Object obj10;
        Deferred deferred28;
        ZPlanCommonGltfFAsset zPlanCommonGltfFAsset3;
        Deferred deferred29;
        String str2;
        Deferred deferred30;
        Deferred deferred31;
        boolean z36;
        List list7;
        Deferred deferred32;
        com.tencent.zplan.zplantracing.b bVar;
        EnumUserGender enumUserGender5;
        Deferred async$default11;
        String path;
        Object await4;
        Object obj11;
        Object obj12;
        Deferred deferred33;
        Map<String, ZPlanFAsset> map4;
        Deferred deferred34;
        String str3;
        boolean z37;
        List list8;
        ZPlanCommonGltfFAsset zPlanCommonGltfFAsset4;
        boolean z38;
        boolean z39;
        Object await5;
        Object obj13;
        Object obj14;
        ZPlanCommonGltfFAsset zPlanCommonGltfFAsset5;
        boolean z46;
        boolean z47;
        String str4;
        Map<String, ZPlanFAsset> map5;
        List list9;
        String str5;
        String str6;
        boolean z48;
        boolean z49;
        List list10;
        Object obj15;
        Object obj16;
        com.tencent.zplan.zplantracing.b bVar2;
        Map map6;
        com.tencent.zplan.zplantracing.b bVar3;
        boolean z55;
        boolean z56;
        String str7;
        String str8;
        Map<String, ZPlanFAsset> map7;
        ZPlanCommonGltfFAsset zPlanCommonGltfFAsset6;
        boolean z57;
        Deferred deferred35;
        String str9;
        boolean z58;
        boolean z59;
        Object await6;
        Object obj17;
        Object obj18;
        String str10;
        com.tencent.zplan.zplantracing.b bVar4;
        boolean z65;
        EnumUserGender enumUserGender6;
        Map<String, ZPlanFAsset> map8;
        Map map9;
        Deferred deferred36;
        String str11;
        ZPlanCommonGltfFAsset zPlanCommonGltfFAsset7;
        Object await7;
        Object obj19;
        Object obj20;
        Map<String, ZPlanFAsset> map10;
        boolean z66;
        com.tencent.zplan.zplantracing.b bVar5;
        String str12;
        Deferred deferred37;
        String str13;
        List list11;
        boolean z67;
        boolean z68;
        Object await8;
        Object obj21;
        boolean z69;
        boolean z75;
        Map map11;
        double d16;
        List list12;
        String str14;
        ZPlanCommonGltfFAsset zPlanCommonGltfFAsset8;
        com.tencent.zplan.zplantracing.b bVar6;
        String str15;
        boolean z76;
        EnumUserGender enumUserGender7;
        String str16;
        Map<String, ZPlanFAsset> map12;
        com.tencent.zplan.zplantracing.b bVar7;
        if (continuation instanceof ZPlanAvatarResourceHelper$fetchReloadAvatarResourceNotUseCache$1) {
            zPlanAvatarResourceHelper$fetchReloadAvatarResourceNotUseCache$1 = (ZPlanAvatarResourceHelper$fetchReloadAvatarResourceNotUseCache$1) continuation;
            int i3 = zPlanAvatarResourceHelper$fetchReloadAvatarResourceNotUseCache$1.label;
            if ((i3 & Integer.MIN_VALUE) != 0) {
                zPlanAvatarResourceHelper$fetchReloadAvatarResourceNotUseCache$1.label = i3 - Integer.MIN_VALUE;
                zPlanAvatarResourceHelper$fetchReloadAvatarResourceNotUseCache$12 = zPlanAvatarResourceHelper$fetchReloadAvatarResourceNotUseCache$1;
                Object obj22 = zPlanAvatarResourceHelper$fetchReloadAvatarResourceNotUseCache$12.result;
                coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                switch (zPlanAvatarResourceHelper$fetchReloadAvatarResourceNotUseCache$12.label) {
                    case 0:
                        ResultKt.throwOnFailure(obj22);
                        ZPlanSpanFactory zPlanSpanFactory = ZPlanSpanFactory.INSTANCE;
                        startSpan = zPlanSpanFactory.startSpan("fetchReloadAvatarResource", cVar);
                        startSpan2 = zPlanSpanFactory.startSpan("fetchSplitShader", startSpan != null ? startSpan.c() : null);
                        CoroutineScope = CoroutineScopeKt.CoroutineScope(Dispatchers.getIO());
                        async$default = BuildersKt__Builders_commonKt.async$default(CoroutineScope, null, null, new ZPlanAvatarResourceHelper$fetchReloadAvatarResourceNotUseCache$slotAssetMapDeferred$1(startSpan, jSONObject, filamentUrlTemplate, z16, null), 3, null);
                        async$default2 = BuildersKt__Builders_commonKt.async$default(CoroutineScope, null, null, new ZPlanAvatarResourceHelper$fetchReloadAvatarResourceNotUseCache$pinchFaceConfigPathDeferred$1(startSpan, filamentUrlTemplate, null), 3, null);
                        async$default3 = BuildersKt__Builders_commonKt.async$default(CoroutineScope, null, null, new ZPlanAvatarResourceHelper$fetchReloadAvatarResourceNotUseCache$pinchFaceDataDeferred$1(jSONObject, startSpan, null), 3, null);
                        async$default4 = BuildersKt__Builders_commonKt.async$default(CoroutineScope, null, null, new ZPlanAvatarResourceHelper$fetchReloadAvatarResourceNotUseCache$eyelashGltfFAssetDeferred$1(startSpan, jSONObject, filamentUrlTemplate, null), 3, null);
                        EnumUserGender j06 = j0(jSONObject);
                        async$default5 = BuildersKt__Builders_commonKt.async$default(CoroutineScope, null, null, new ZPlanAvatarResourceHelper$fetchReloadAvatarResourceNotUseCache$pantsLengthDeferred$1(jSONObject, startSpan, null), 3, null);
                        async$default6 = BuildersKt__Builders_commonKt.async$default(CoroutineScope, null, null, new ZPlanAvatarResourceHelper$fetchReloadAvatarResourceNotUseCache$shoeHeightDeferred$1(jSONObject, startSpan, null), 3, null);
                        async$default7 = BuildersKt__Builders_commonKt.async$default(CoroutineScope, null, null, new ZPlanAvatarResourceHelper$fetchReloadAvatarResourceNotUseCache$bodyTypePathDeferred$1(startSpan, jSONObject, filamentUrlTemplate, null), 3, null);
                        async$default8 = BuildersKt__Builders_commonKt.async$default(CoroutineScope, null, null, new ZPlanAvatarResourceHelper$fetchReloadAvatarResourceNotUseCache$aiBodyRefPathDeferred$1(startSpan, filamentUrlTemplate, null), 3, null);
                        async$default9 = BuildersKt__Builders_commonKt.async$default(CoroutineScope, null, null, new ZPlanAvatarResourceHelper$fetchReloadAvatarResourceNotUseCache$ugcResDataDeferred$1(startSpan, jSONObject, filamentUrlTemplate, null), 3, null);
                        async$default10 = BuildersKt__Builders_commonKt.async$default(CoroutineScope, null, null, new ZPlanAvatarResourceHelper$fetchReloadAvatarResourceNotUseCache$fetchTexturePacker$1(startSpan2, filamentUrlTemplate, null), 3, null);
                        z17 = false;
                        mutableListOf = CollectionsKt__CollectionsKt.mutableListOf(async$default10);
                        zPlanAvatarResourceHelper$fetchReloadAvatarResourceNotUseCache$12.L$0 = this;
                        zPlanAvatarResourceHelper$fetchReloadAvatarResourceNotUseCache$12.L$1 = filamentUrlTemplate;
                        zPlanAvatarResourceHelper$fetchReloadAvatarResourceNotUseCache$12.L$2 = startSpan;
                        zPlanAvatarResourceHelper$fetchReloadAvatarResourceNotUseCache$12.L$3 = startSpan2;
                        zPlanAvatarResourceHelper$fetchReloadAvatarResourceNotUseCache$12.L$4 = CoroutineScope;
                        zPlanAvatarResourceHelper$fetchReloadAvatarResourceNotUseCache$12.L$5 = async$default2;
                        zPlanAvatarResourceHelper$fetchReloadAvatarResourceNotUseCache$12.L$6 = async$default3;
                        zPlanAvatarResourceHelper$fetchReloadAvatarResourceNotUseCache$12.L$7 = async$default4;
                        zPlanAvatarResourceHelper$fetchReloadAvatarResourceNotUseCache$12.L$8 = j06;
                        zPlanAvatarResourceHelper$fetchReloadAvatarResourceNotUseCache$12.L$9 = async$default5;
                        zPlanAvatarResourceHelper$fetchReloadAvatarResourceNotUseCache$12.L$10 = async$default6;
                        zPlanAvatarResourceHelper$fetchReloadAvatarResourceNotUseCache$12.L$11 = async$default7;
                        zPlanAvatarResourceHelper$fetchReloadAvatarResourceNotUseCache$12.L$12 = async$default8;
                        zPlanAvatarResourceHelper$fetchReloadAvatarResourceNotUseCache$12.L$13 = async$default9;
                        zPlanAvatarResourceHelper$fetchReloadAvatarResourceNotUseCache$12.L$14 = mutableListOf;
                        zPlanAvatarResourceHelper$fetchReloadAvatarResourceNotUseCache$12.label = 1;
                        Object await9 = async$default.await(zPlanAvatarResourceHelper$fetchReloadAvatarResourceNotUseCache$12);
                        if (await9 == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        zPlanAvatarResourceHelper = this;
                        obj = coroutine_suspended;
                        deferred = async$default6;
                        enumUserGender = j06;
                        deferred2 = async$default4;
                        deferred3 = async$default3;
                        deferred4 = async$default8;
                        obj2 = await9;
                        filamentUrlTemplate2 = filamentUrlTemplate;
                        deferred5 = async$default9;
                        list = mutableListOf;
                        deferred6 = async$default5;
                        deferred7 = async$default7;
                        Pair pair = (Pair) obj2;
                        List list13 = list;
                        Map<String, ZPlanFAsset> map13 = (Map) pair.component1();
                        boolean booleanValue = ((Boolean) pair.component2()).booleanValue();
                        com.tencent.zplan.zplantracing.c c16 = startSpan2 == null ? startSpan2.c() : null;
                        zPlanAvatarResourceHelper$fetchReloadAvatarResourceNotUseCache$12.L$0 = filamentUrlTemplate2;
                        zPlanAvatarResourceHelper$fetchReloadAvatarResourceNotUseCache$12.L$1 = startSpan;
                        zPlanAvatarResourceHelper$fetchReloadAvatarResourceNotUseCache$12.L$2 = startSpan2;
                        zPlanAvatarResourceHelper$fetchReloadAvatarResourceNotUseCache$12.L$3 = CoroutineScope;
                        zPlanAvatarResourceHelper$fetchReloadAvatarResourceNotUseCache$12.L$4 = async$default2;
                        zPlanAvatarResourceHelper$fetchReloadAvatarResourceNotUseCache$12.L$5 = deferred3;
                        zPlanAvatarResourceHelper$fetchReloadAvatarResourceNotUseCache$12.L$6 = deferred2;
                        zPlanAvatarResourceHelper$fetchReloadAvatarResourceNotUseCache$12.L$7 = enumUserGender;
                        zPlanAvatarResourceHelper$fetchReloadAvatarResourceNotUseCache$12.L$8 = deferred6;
                        zPlanAvatarResourceHelper$fetchReloadAvatarResourceNotUseCache$12.L$9 = deferred;
                        zPlanAvatarResourceHelper$fetchReloadAvatarResourceNotUseCache$12.L$10 = deferred7;
                        zPlanAvatarResourceHelper$fetchReloadAvatarResourceNotUseCache$12.L$11 = deferred4;
                        zPlanAvatarResourceHelper$fetchReloadAvatarResourceNotUseCache$12.L$12 = deferred5;
                        Deferred deferred38 = deferred;
                        zPlanAvatarResourceHelper$fetchReloadAvatarResourceNotUseCache$12.L$13 = list13;
                        zPlanAvatarResourceHelper$fetchReloadAvatarResourceNotUseCache$12.L$14 = map13;
                        zPlanAvatarResourceHelper$fetchReloadAvatarResourceNotUseCache$12.L$15 = list13;
                        zPlanAvatarResourceHelper$fetchReloadAvatarResourceNotUseCache$12.Z$0 = booleanValue;
                        zPlanAvatarResourceHelper$fetchReloadAvatarResourceNotUseCache$12.label = 2;
                        Deferred deferred39 = deferred3;
                        Deferred deferred40 = deferred2;
                        com.tencent.zplan.zplantracing.c cVar2 = c16;
                        Deferred deferred41 = deferred7;
                        EnumUserGender enumUserGender8 = enumUserGender;
                        Deferred deferred42 = deferred6;
                        Deferred deferred43 = deferred5;
                        d06 = zPlanAvatarResourceHelper.d0(cVar2, map13, CoroutineScope, filamentUrlTemplate2, zPlanAvatarResourceHelper$fetchReloadAvatarResourceNotUseCache$12);
                        obj3 = obj;
                        if (d06 != obj3) {
                            return obj3;
                        }
                        obj4 = obj3;
                        deferred8 = deferred41;
                        list2 = list13;
                        list3 = list2;
                        deferred9 = deferred38;
                        deferred10 = deferred43;
                        z18 = booleanValue;
                        map = map13;
                        deferred11 = async$default2;
                        enumUserGender2 = enumUserGender8;
                        deferred12 = deferred42;
                        deferred13 = deferred39;
                        filamentUrlTemplate3 = filamentUrlTemplate2;
                        obj22 = d06;
                        deferred14 = deferred40;
                        list2.addAll((Collection) obj22);
                        zPlanAvatarResourceHelper$fetchReloadAvatarResourceNotUseCache$12.L$0 = filamentUrlTemplate3;
                        zPlanAvatarResourceHelper$fetchReloadAvatarResourceNotUseCache$12.L$1 = startSpan;
                        zPlanAvatarResourceHelper$fetchReloadAvatarResourceNotUseCache$12.L$2 = startSpan2;
                        zPlanAvatarResourceHelper$fetchReloadAvatarResourceNotUseCache$12.L$3 = CoroutineScope;
                        zPlanAvatarResourceHelper$fetchReloadAvatarResourceNotUseCache$12.L$4 = deferred13;
                        zPlanAvatarResourceHelper$fetchReloadAvatarResourceNotUseCache$12.L$5 = deferred14;
                        zPlanAvatarResourceHelper$fetchReloadAvatarResourceNotUseCache$12.L$6 = enumUserGender2;
                        zPlanAvatarResourceHelper$fetchReloadAvatarResourceNotUseCache$12.L$7 = deferred12;
                        zPlanAvatarResourceHelper$fetchReloadAvatarResourceNotUseCache$12.L$8 = deferred9;
                        zPlanAvatarResourceHelper$fetchReloadAvatarResourceNotUseCache$12.L$9 = deferred8;
                        zPlanAvatarResourceHelper$fetchReloadAvatarResourceNotUseCache$12.L$10 = deferred4;
                        zPlanAvatarResourceHelper$fetchReloadAvatarResourceNotUseCache$12.L$11 = deferred10;
                        zPlanAvatarResourceHelper$fetchReloadAvatarResourceNotUseCache$12.L$12 = list3;
                        Map<String, ZPlanFAsset> map14 = map;
                        zPlanAvatarResourceHelper$fetchReloadAvatarResourceNotUseCache$12.L$13 = map14;
                        zPlanAvatarResourceHelper$fetchReloadAvatarResourceNotUseCache$12.L$14 = null;
                        zPlanAvatarResourceHelper$fetchReloadAvatarResourceNotUseCache$12.L$15 = null;
                        z19 = z18;
                        zPlanAvatarResourceHelper$fetchReloadAvatarResourceNotUseCache$12.Z$0 = z19;
                        FilamentUrlTemplate filamentUrlTemplate6 = filamentUrlTemplate3;
                        zPlanAvatarResourceHelper$fetchReloadAvatarResourceNotUseCache$12.label = 3;
                        await = deferred11.await(zPlanAvatarResourceHelper$fetchReloadAvatarResourceNotUseCache$12);
                        obj5 = obj4;
                        if (await != obj5) {
                            return obj5;
                        }
                        obj6 = obj5;
                        deferred15 = deferred13;
                        enumUserGender3 = enumUserGender2;
                        filamentUrlTemplate4 = filamentUrlTemplate6;
                        deferred16 = deferred14;
                        map2 = map14;
                        Deferred deferred44 = deferred4;
                        deferred17 = deferred9;
                        list4 = list3;
                        deferred18 = deferred44;
                        Resource resource = (Resource) await;
                        boolean z77 = z19;
                        String path2 = resource.getPath();
                        boolean downloadFromNet = resource.getDownloadFromNet();
                        zPlanAvatarResourceHelper$fetchReloadAvatarResourceNotUseCache$12.L$0 = filamentUrlTemplate4;
                        zPlanAvatarResourceHelper$fetchReloadAvatarResourceNotUseCache$12.L$1 = startSpan;
                        zPlanAvatarResourceHelper$fetchReloadAvatarResourceNotUseCache$12.L$2 = startSpan2;
                        zPlanAvatarResourceHelper$fetchReloadAvatarResourceNotUseCache$12.L$3 = CoroutineScope;
                        zPlanAvatarResourceHelper$fetchReloadAvatarResourceNotUseCache$12.L$4 = deferred15;
                        zPlanAvatarResourceHelper$fetchReloadAvatarResourceNotUseCache$12.L$5 = enumUserGender3;
                        zPlanAvatarResourceHelper$fetchReloadAvatarResourceNotUseCache$12.L$6 = deferred12;
                        zPlanAvatarResourceHelper$fetchReloadAvatarResourceNotUseCache$12.L$7 = deferred17;
                        zPlanAvatarResourceHelper$fetchReloadAvatarResourceNotUseCache$12.L$8 = deferred8;
                        zPlanAvatarResourceHelper$fetchReloadAvatarResourceNotUseCache$12.L$9 = deferred18;
                        zPlanAvatarResourceHelper$fetchReloadAvatarResourceNotUseCache$12.L$10 = deferred10;
                        zPlanAvatarResourceHelper$fetchReloadAvatarResourceNotUseCache$12.L$11 = list4;
                        zPlanAvatarResourceHelper$fetchReloadAvatarResourceNotUseCache$12.L$12 = map2;
                        zPlanAvatarResourceHelper$fetchReloadAvatarResourceNotUseCache$12.L$13 = path2;
                        Deferred deferred45 = deferred15;
                        zPlanAvatarResourceHelper$fetchReloadAvatarResourceNotUseCache$12.Z$0 = z77;
                        zPlanAvatarResourceHelper$fetchReloadAvatarResourceNotUseCache$12.Z$1 = downloadFromNet;
                        zPlanAvatarResourceHelper$fetchReloadAvatarResourceNotUseCache$12.label = 4;
                        await2 = deferred16.await(zPlanAvatarResourceHelper$fetchReloadAvatarResourceNotUseCache$12);
                        obj7 = obj6;
                        if (await2 != obj7) {
                            return obj7;
                        }
                        enumUserGender4 = enumUserGender3;
                        deferred19 = deferred12;
                        z26 = z77;
                        deferred20 = deferred45;
                        deferred21 = deferred10;
                        list5 = list4;
                        deferred22 = deferred18;
                        deferred23 = deferred8;
                        z27 = downloadFromNet;
                        Map<String, ZPlanFAsset> map15 = map2;
                        filamentUrlTemplate5 = filamentUrlTemplate4;
                        coroutineScope = CoroutineScope;
                        str = path2;
                        deferred24 = deferred17;
                        map3 = map15;
                        Pair pair2 = (Pair) await2;
                        List list14 = list5;
                        zPlanCommonGltfFAsset = (ZPlanCommonGltfFAsset) pair2.component1();
                        boolean booleanValue2 = ((Boolean) pair2.component2()).booleanValue();
                        if (zPlanCommonGltfFAsset.getGltfFilePath() == null) {
                            deferred25 = deferred22;
                            deferred26 = deferred24;
                            deferred27 = deferred23;
                            obj8 = obj7;
                            zPlanCommonGltfFAsset2 = zPlanCommonGltfFAsset;
                            list6 = list14;
                            z28 = booleanValue2;
                            async$default11 = BuildersKt__Builders_commonKt.async$default(coroutineScope, null, null, new ZPlanAvatarResourceHelper$fetchReloadAvatarResourceNotUseCache$fetchEyslashShaderJob$1(startSpan2, zPlanCommonGltfFAsset, filamentUrlTemplate5, null), 3, null);
                            list6.add(async$default11);
                        } else {
                            obj8 = obj7;
                            deferred25 = deferred22;
                            deferred26 = deferred24;
                            deferred27 = deferred23;
                            zPlanCommonGltfFAsset2 = zPlanCommonGltfFAsset;
                            list6 = list14;
                            z28 = booleanValue2;
                        }
                        zPlanAvatarResourceHelper$fetchReloadAvatarResourceNotUseCache$12.L$0 = startSpan;
                        zPlanAvatarResourceHelper$fetchReloadAvatarResourceNotUseCache$12.L$1 = startSpan2;
                        Deferred deferred46 = deferred20;
                        zPlanAvatarResourceHelper$fetchReloadAvatarResourceNotUseCache$12.L$2 = deferred46;
                        EnumUserGender enumUserGender9 = enumUserGender4;
                        zPlanAvatarResourceHelper$fetchReloadAvatarResourceNotUseCache$12.L$3 = enumUserGender9;
                        Deferred deferred47 = deferred19;
                        zPlanAvatarResourceHelper$fetchReloadAvatarResourceNotUseCache$12.L$4 = deferred47;
                        Deferred deferred48 = deferred26;
                        zPlanAvatarResourceHelper$fetchReloadAvatarResourceNotUseCache$12.L$5 = deferred48;
                        Deferred deferred49 = deferred25;
                        zPlanAvatarResourceHelper$fetchReloadAvatarResourceNotUseCache$12.L$6 = deferred49;
                        zPlanAvatarResourceHelper$fetchReloadAvatarResourceNotUseCache$12.L$7 = deferred21;
                        zPlanAvatarResourceHelper$fetchReloadAvatarResourceNotUseCache$12.L$8 = list6;
                        zPlanAvatarResourceHelper$fetchReloadAvatarResourceNotUseCache$12.L$9 = map3;
                        zPlanAvatarResourceHelper$fetchReloadAvatarResourceNotUseCache$12.L$10 = str;
                        zPlanAvatarResourceHelper$fetchReloadAvatarResourceNotUseCache$12.L$11 = zPlanCommonGltfFAsset2;
                        zPlanAvatarResourceHelper$fetchReloadAvatarResourceNotUseCache$12.L$12 = null;
                        zPlanAvatarResourceHelper$fetchReloadAvatarResourceNotUseCache$12.L$13 = null;
                        zPlanAvatarResourceHelper$fetchReloadAvatarResourceNotUseCache$12.Z$0 = z26;
                        zPlanAvatarResourceHelper$fetchReloadAvatarResourceNotUseCache$12.Z$1 = z27;
                        z29 = z28;
                        zPlanAvatarResourceHelper$fetchReloadAvatarResourceNotUseCache$12.Z$2 = z29;
                        List list15 = list6;
                        zPlanAvatarResourceHelper$fetchReloadAvatarResourceNotUseCache$12.label = 5;
                        await3 = deferred27.await(zPlanAvatarResourceHelper$fetchReloadAvatarResourceNotUseCache$12);
                        ZPlanCommonGltfFAsset zPlanCommonGltfFAsset9 = zPlanCommonGltfFAsset2;
                        obj9 = obj8;
                        if (await3 != obj9) {
                            return obj9;
                        }
                        obj10 = obj9;
                        deferred28 = deferred48;
                        zPlanCommonGltfFAsset3 = zPlanCommonGltfFAsset9;
                        deferred29 = deferred49;
                        str2 = str;
                        deferred30 = deferred21;
                        deferred31 = deferred47;
                        z36 = z26;
                        list7 = list15;
                        deferred32 = deferred46;
                        bVar = startSpan;
                        enumUserGender5 = enumUserGender9;
                        Resource resource2 = (Resource) await3;
                        boolean z78 = z29;
                        path = resource2.getPath();
                        boolean downloadFromNet2 = resource2.getDownloadFromNet();
                        zPlanAvatarResourceHelper$fetchReloadAvatarResourceNotUseCache$12.L$0 = bVar;
                        zPlanAvatarResourceHelper$fetchReloadAvatarResourceNotUseCache$12.L$1 = startSpan2;
                        zPlanAvatarResourceHelper$fetchReloadAvatarResourceNotUseCache$12.L$2 = deferred32;
                        zPlanAvatarResourceHelper$fetchReloadAvatarResourceNotUseCache$12.L$3 = enumUserGender5;
                        zPlanAvatarResourceHelper$fetchReloadAvatarResourceNotUseCache$12.L$4 = deferred31;
                        zPlanAvatarResourceHelper$fetchReloadAvatarResourceNotUseCache$12.L$5 = deferred28;
                        zPlanAvatarResourceHelper$fetchReloadAvatarResourceNotUseCache$12.L$6 = deferred30;
                        zPlanAvatarResourceHelper$fetchReloadAvatarResourceNotUseCache$12.L$7 = list7;
                        zPlanAvatarResourceHelper$fetchReloadAvatarResourceNotUseCache$12.L$8 = map3;
                        zPlanAvatarResourceHelper$fetchReloadAvatarResourceNotUseCache$12.L$9 = str2;
                        zPlanAvatarResourceHelper$fetchReloadAvatarResourceNotUseCache$12.L$10 = zPlanCommonGltfFAsset3;
                        zPlanAvatarResourceHelper$fetchReloadAvatarResourceNotUseCache$12.L$11 = path;
                        zPlanAvatarResourceHelper$fetchReloadAvatarResourceNotUseCache$12.Z$0 = z36;
                        zPlanAvatarResourceHelper$fetchReloadAvatarResourceNotUseCache$12.Z$1 = z27;
                        Deferred deferred50 = deferred28;
                        zPlanAvatarResourceHelper$fetchReloadAvatarResourceNotUseCache$12.Z$2 = z78;
                        zPlanAvatarResourceHelper$fetchReloadAvatarResourceNotUseCache$12.Z$3 = downloadFromNet2;
                        zPlanAvatarResourceHelper$fetchReloadAvatarResourceNotUseCache$12.label = 6;
                        await4 = deferred29.await(zPlanAvatarResourceHelper$fetchReloadAvatarResourceNotUseCache$12);
                        obj11 = obj10;
                        if (await4 != obj11) {
                            return obj11;
                        }
                        obj12 = obj11;
                        deferred33 = deferred30;
                        map4 = map3;
                        deferred34 = deferred50;
                        str3 = str2;
                        z37 = z36;
                        list8 = list7;
                        zPlanCommonGltfFAsset4 = zPlanCommonGltfFAsset3;
                        z38 = z78;
                        z39 = downloadFromNet2;
                        Resource resource3 = (Resource) await4;
                        boolean z79 = z38;
                        String path3 = resource3.getPath();
                        boolean downloadFromNet3 = resource3.getDownloadFromNet();
                        zPlanAvatarResourceHelper$fetchReloadAvatarResourceNotUseCache$12.L$0 = bVar;
                        zPlanAvatarResourceHelper$fetchReloadAvatarResourceNotUseCache$12.L$1 = startSpan2;
                        zPlanAvatarResourceHelper$fetchReloadAvatarResourceNotUseCache$12.L$2 = deferred32;
                        zPlanAvatarResourceHelper$fetchReloadAvatarResourceNotUseCache$12.L$3 = enumUserGender5;
                        zPlanAvatarResourceHelper$fetchReloadAvatarResourceNotUseCache$12.L$4 = deferred31;
                        zPlanAvatarResourceHelper$fetchReloadAvatarResourceNotUseCache$12.L$5 = deferred34;
                        zPlanAvatarResourceHelper$fetchReloadAvatarResourceNotUseCache$12.L$6 = list8;
                        zPlanAvatarResourceHelper$fetchReloadAvatarResourceNotUseCache$12.L$7 = map4;
                        zPlanAvatarResourceHelper$fetchReloadAvatarResourceNotUseCache$12.L$8 = str3;
                        zPlanAvatarResourceHelper$fetchReloadAvatarResourceNotUseCache$12.L$9 = zPlanCommonGltfFAsset4;
                        zPlanAvatarResourceHelper$fetchReloadAvatarResourceNotUseCache$12.L$10 = path;
                        zPlanAvatarResourceHelper$fetchReloadAvatarResourceNotUseCache$12.L$11 = path3;
                        zPlanAvatarResourceHelper$fetchReloadAvatarResourceNotUseCache$12.Z$0 = z37;
                        zPlanAvatarResourceHelper$fetchReloadAvatarResourceNotUseCache$12.Z$1 = z27;
                        Map<String, ZPlanFAsset> map16 = map4;
                        zPlanAvatarResourceHelper$fetchReloadAvatarResourceNotUseCache$12.Z$2 = z79;
                        boolean z85 = z39;
                        zPlanAvatarResourceHelper$fetchReloadAvatarResourceNotUseCache$12.Z$3 = z85;
                        zPlanAvatarResourceHelper$fetchReloadAvatarResourceNotUseCache$12.Z$4 = downloadFromNet3;
                        zPlanAvatarResourceHelper$fetchReloadAvatarResourceNotUseCache$12.label = 7;
                        await5 = deferred33.await(zPlanAvatarResourceHelper$fetchReloadAvatarResourceNotUseCache$12);
                        obj13 = obj12;
                        if (await5 != obj13) {
                            return obj13;
                        }
                        obj14 = obj13;
                        zPlanCommonGltfFAsset5 = zPlanCommonGltfFAsset4;
                        z46 = z85;
                        z47 = downloadFromNet3;
                        str4 = path3;
                        map5 = map16;
                        list9 = list8;
                        str5 = str3;
                        str6 = path;
                        z48 = z37;
                        z49 = z79;
                        Pair pair3 = (Pair) await5;
                        boolean z86 = z49;
                        Map map17 = (Map) pair3.component1();
                        boolean booleanValue3 = ((Boolean) pair3.component2()).booleanValue();
                        list10 = list9;
                        zPlanAvatarResourceHelper$fetchReloadAvatarResourceNotUseCache$12.L$0 = bVar;
                        zPlanAvatarResourceHelper$fetchReloadAvatarResourceNotUseCache$12.L$1 = startSpan2;
                        zPlanAvatarResourceHelper$fetchReloadAvatarResourceNotUseCache$12.L$2 = deferred32;
                        zPlanAvatarResourceHelper$fetchReloadAvatarResourceNotUseCache$12.L$3 = enumUserGender5;
                        zPlanAvatarResourceHelper$fetchReloadAvatarResourceNotUseCache$12.L$4 = deferred31;
                        zPlanAvatarResourceHelper$fetchReloadAvatarResourceNotUseCache$12.L$5 = deferred34;
                        zPlanAvatarResourceHelper$fetchReloadAvatarResourceNotUseCache$12.L$6 = map5;
                        zPlanAvatarResourceHelper$fetchReloadAvatarResourceNotUseCache$12.L$7 = str5;
                        zPlanAvatarResourceHelper$fetchReloadAvatarResourceNotUseCache$12.L$8 = zPlanCommonGltfFAsset5;
                        zPlanAvatarResourceHelper$fetchReloadAvatarResourceNotUseCache$12.L$9 = str6;
                        zPlanAvatarResourceHelper$fetchReloadAvatarResourceNotUseCache$12.L$10 = str4;
                        zPlanAvatarResourceHelper$fetchReloadAvatarResourceNotUseCache$12.L$11 = map17;
                        zPlanAvatarResourceHelper$fetchReloadAvatarResourceNotUseCache$12.Z$0 = z48;
                        zPlanAvatarResourceHelper$fetchReloadAvatarResourceNotUseCache$12.Z$1 = z27;
                        ZPlanCommonGltfFAsset zPlanCommonGltfFAsset10 = zPlanCommonGltfFAsset5;
                        zPlanAvatarResourceHelper$fetchReloadAvatarResourceNotUseCache$12.Z$2 = z86;
                        zPlanAvatarResourceHelper$fetchReloadAvatarResourceNotUseCache$12.Z$3 = z46;
                        zPlanAvatarResourceHelper$fetchReloadAvatarResourceNotUseCache$12.Z$4 = z47;
                        zPlanAvatarResourceHelper$fetchReloadAvatarResourceNotUseCache$12.Z$5 = booleanValue3;
                        zPlanAvatarResourceHelper$fetchReloadAvatarResourceNotUseCache$12.label = 8;
                        obj15 = obj14;
                        if (AwaitKt.awaitAll(list10, zPlanAvatarResourceHelper$fetchReloadAvatarResourceNotUseCache$12) != obj15) {
                            return obj15;
                        }
                        obj16 = obj15;
                        bVar2 = bVar;
                        map6 = map17;
                        bVar3 = startSpan2;
                        z55 = z46;
                        z56 = booleanValue3;
                        str7 = str5;
                        str8 = str6;
                        map7 = map5;
                        zPlanCommonGltfFAsset6 = zPlanCommonGltfFAsset10;
                        z57 = z47;
                        deferred35 = deferred32;
                        str9 = str4;
                        z58 = z48;
                        z59 = z86;
                        if (bVar3 != null) {
                            bVar3.b();
                            Unit unit = Unit.INSTANCE;
                        }
                        zPlanAvatarResourceHelper$fetchReloadAvatarResourceNotUseCache$12.L$0 = bVar2;
                        zPlanAvatarResourceHelper$fetchReloadAvatarResourceNotUseCache$12.L$1 = enumUserGender5;
                        zPlanAvatarResourceHelper$fetchReloadAvatarResourceNotUseCache$12.L$2 = deferred31;
                        zPlanAvatarResourceHelper$fetchReloadAvatarResourceNotUseCache$12.L$3 = deferred34;
                        zPlanAvatarResourceHelper$fetchReloadAvatarResourceNotUseCache$12.L$4 = zPlanCommonGltfFAsset6;
                        zPlanAvatarResourceHelper$fetchReloadAvatarResourceNotUseCache$12.L$5 = str8;
                        zPlanAvatarResourceHelper$fetchReloadAvatarResourceNotUseCache$12.L$6 = str9;
                        zPlanAvatarResourceHelper$fetchReloadAvatarResourceNotUseCache$12.L$7 = map6;
                        zPlanAvatarResourceHelper$fetchReloadAvatarResourceNotUseCache$12.L$8 = map7;
                        zPlanAvatarResourceHelper$fetchReloadAvatarResourceNotUseCache$12.L$9 = str7;
                        zPlanAvatarResourceHelper$fetchReloadAvatarResourceNotUseCache$12.L$10 = null;
                        zPlanAvatarResourceHelper$fetchReloadAvatarResourceNotUseCache$12.L$11 = null;
                        zPlanAvatarResourceHelper$fetchReloadAvatarResourceNotUseCache$12.Z$0 = z58;
                        zPlanAvatarResourceHelper$fetchReloadAvatarResourceNotUseCache$12.Z$1 = z27;
                        zPlanAvatarResourceHelper$fetchReloadAvatarResourceNotUseCache$12.Z$2 = z59;
                        zPlanAvatarResourceHelper$fetchReloadAvatarResourceNotUseCache$12.Z$3 = z55;
                        boolean z87 = z57;
                        zPlanAvatarResourceHelper$fetchReloadAvatarResourceNotUseCache$12.Z$4 = z87;
                        com.tencent.zplan.zplantracing.b bVar8 = bVar2;
                        zPlanAvatarResourceHelper$fetchReloadAvatarResourceNotUseCache$12.Z$5 = z56;
                        zPlanAvatarResourceHelper$fetchReloadAvatarResourceNotUseCache$12.label = 9;
                        await6 = deferred35.await(zPlanAvatarResourceHelper$fetchReloadAvatarResourceNotUseCache$12);
                        Map map18 = map6;
                        obj17 = obj16;
                        if (await6 != obj17) {
                            return obj17;
                        }
                        obj18 = obj17;
                        str10 = str9;
                        bVar4 = bVar8;
                        ZPlanCommonGltfFAsset zPlanCommonGltfFAsset11 = zPlanCommonGltfFAsset6;
                        z65 = z87;
                        enumUserGender6 = enumUserGender5;
                        map8 = map7;
                        map9 = map18;
                        deferred36 = deferred31;
                        str11 = str8;
                        zPlanCommonGltfFAsset7 = zPlanCommonGltfFAsset11;
                        List list16 = (List) await6;
                        zPlanAvatarResourceHelper$fetchReloadAvatarResourceNotUseCache$12.L$0 = bVar4;
                        zPlanAvatarResourceHelper$fetchReloadAvatarResourceNotUseCache$12.L$1 = deferred34;
                        zPlanAvatarResourceHelper$fetchReloadAvatarResourceNotUseCache$12.L$2 = str11;
                        zPlanAvatarResourceHelper$fetchReloadAvatarResourceNotUseCache$12.L$3 = str10;
                        zPlanAvatarResourceHelper$fetchReloadAvatarResourceNotUseCache$12.L$4 = map9;
                        zPlanAvatarResourceHelper$fetchReloadAvatarResourceNotUseCache$12.L$5 = map8;
                        zPlanAvatarResourceHelper$fetchReloadAvatarResourceNotUseCache$12.L$6 = str7;
                        zPlanAvatarResourceHelper$fetchReloadAvatarResourceNotUseCache$12.L$7 = list16;
                        zPlanAvatarResourceHelper$fetchReloadAvatarResourceNotUseCache$12.L$8 = zPlanCommonGltfFAsset7;
                        zPlanAvatarResourceHelper$fetchReloadAvatarResourceNotUseCache$12.L$9 = enumUserGender6;
                        zPlanAvatarResourceHelper$fetchReloadAvatarResourceNotUseCache$12.Z$0 = z58;
                        zPlanAvatarResourceHelper$fetchReloadAvatarResourceNotUseCache$12.Z$1 = z27;
                        zPlanAvatarResourceHelper$fetchReloadAvatarResourceNotUseCache$12.Z$2 = z59;
                        zPlanAvatarResourceHelper$fetchReloadAvatarResourceNotUseCache$12.Z$3 = z55;
                        zPlanAvatarResourceHelper$fetchReloadAvatarResourceNotUseCache$12.Z$4 = z65;
                        zPlanAvatarResourceHelper$fetchReloadAvatarResourceNotUseCache$12.Z$5 = z56;
                        zPlanAvatarResourceHelper$fetchReloadAvatarResourceNotUseCache$12.label = 10;
                        await7 = deferred36.await(zPlanAvatarResourceHelper$fetchReloadAvatarResourceNotUseCache$12);
                        String str17 = str10;
                        obj19 = obj18;
                        if (await7 != obj19) {
                            return obj19;
                        }
                        obj20 = obj19;
                        map10 = map8;
                        z66 = z58;
                        bVar5 = bVar4;
                        str12 = str17;
                        deferred37 = deferred34;
                        str13 = str7;
                        list11 = list16;
                        z67 = z65;
                        z68 = z55;
                        double doubleValue = ((Number) await7).doubleValue();
                        zPlanAvatarResourceHelper$fetchReloadAvatarResourceNotUseCache$12.L$0 = bVar5;
                        zPlanAvatarResourceHelper$fetchReloadAvatarResourceNotUseCache$12.L$1 = str11;
                        zPlanAvatarResourceHelper$fetchReloadAvatarResourceNotUseCache$12.L$2 = str12;
                        zPlanAvatarResourceHelper$fetchReloadAvatarResourceNotUseCache$12.L$3 = map9;
                        zPlanAvatarResourceHelper$fetchReloadAvatarResourceNotUseCache$12.L$4 = map10;
                        zPlanAvatarResourceHelper$fetchReloadAvatarResourceNotUseCache$12.L$5 = str13;
                        zPlanAvatarResourceHelper$fetchReloadAvatarResourceNotUseCache$12.L$6 = list11;
                        zPlanAvatarResourceHelper$fetchReloadAvatarResourceNotUseCache$12.L$7 = zPlanCommonGltfFAsset7;
                        zPlanAvatarResourceHelper$fetchReloadAvatarResourceNotUseCache$12.L$8 = enumUserGender6;
                        zPlanAvatarResourceHelper$fetchReloadAvatarResourceNotUseCache$12.L$9 = null;
                        zPlanAvatarResourceHelper$fetchReloadAvatarResourceNotUseCache$12.Z$0 = z66;
                        zPlanAvatarResourceHelper$fetchReloadAvatarResourceNotUseCache$12.Z$1 = z27;
                        zPlanAvatarResourceHelper$fetchReloadAvatarResourceNotUseCache$12.Z$2 = z59;
                        zPlanAvatarResourceHelper$fetchReloadAvatarResourceNotUseCache$12.Z$3 = z68;
                        zPlanAvatarResourceHelper$fetchReloadAvatarResourceNotUseCache$12.Z$4 = z67;
                        zPlanAvatarResourceHelper$fetchReloadAvatarResourceNotUseCache$12.Z$5 = z56;
                        zPlanAvatarResourceHelper$fetchReloadAvatarResourceNotUseCache$12.D$0 = doubleValue;
                        zPlanAvatarResourceHelper$fetchReloadAvatarResourceNotUseCache$12.label = 11;
                        await8 = deferred37.await(zPlanAvatarResourceHelper$fetchReloadAvatarResourceNotUseCache$12);
                        obj21 = obj20;
                        if (await8 != obj21) {
                            return obj21;
                        }
                        z69 = z27;
                        z75 = z66;
                        map11 = map9;
                        d16 = doubleValue;
                        list12 = list11;
                        str14 = str11;
                        zPlanCommonGltfFAsset8 = zPlanCommonGltfFAsset7;
                        bVar6 = bVar5;
                        str15 = str13;
                        z76 = z59;
                        enumUserGender7 = enumUserGender6;
                        Map<String, ZPlanFAsset> map19 = map10;
                        obj22 = await8;
                        str16 = str12;
                        map12 = map19;
                        double doubleValue2 = ((Number) obj22).doubleValue();
                        bVar7 = bVar6;
                        ReloadAvatarResourceModel reloadAvatarResourceModel = new ReloadAvatarResourceModel(map12, str15, list12, zPlanCommonGltfFAsset8, enumUserGender7, d16, doubleValue2, str14, !(str16.length() != 0 ? true : z17) ? null : str16, map11);
                        reloadAvatarResourceModel.F((!z75 || z69 || z76 || z68 || z67 || z56) ? true : z17);
                        if (bVar7 != null) {
                            bVar7.e("downloadFromNet", String.valueOf(reloadAvatarResourceModel.getDownloadFromNet()));
                            Unit unit2 = Unit.INSTANCE;
                        }
                        if (bVar7 != null) {
                            bVar7.b();
                            Unit unit3 = Unit.INSTANCE;
                        }
                        return reloadAvatarResourceModel;
                    case 1:
                        List list17 = (List) zPlanAvatarResourceHelper$fetchReloadAvatarResourceNotUseCache$12.L$14;
                        Deferred deferred51 = (Deferred) zPlanAvatarResourceHelper$fetchReloadAvatarResourceNotUseCache$12.L$13;
                        Deferred deferred52 = (Deferred) zPlanAvatarResourceHelper$fetchReloadAvatarResourceNotUseCache$12.L$12;
                        deferred7 = (Deferred) zPlanAvatarResourceHelper$fetchReloadAvatarResourceNotUseCache$12.L$11;
                        Deferred deferred53 = (Deferred) zPlanAvatarResourceHelper$fetchReloadAvatarResourceNotUseCache$12.L$10;
                        deferred6 = (Deferred) zPlanAvatarResourceHelper$fetchReloadAvatarResourceNotUseCache$12.L$9;
                        EnumUserGender enumUserGender10 = (EnumUserGender) zPlanAvatarResourceHelper$fetchReloadAvatarResourceNotUseCache$12.L$8;
                        Deferred deferred54 = (Deferred) zPlanAvatarResourceHelper$fetchReloadAvatarResourceNotUseCache$12.L$7;
                        Deferred deferred55 = (Deferred) zPlanAvatarResourceHelper$fetchReloadAvatarResourceNotUseCache$12.L$6;
                        Deferred deferred56 = (Deferred) zPlanAvatarResourceHelper$fetchReloadAvatarResourceNotUseCache$12.L$5;
                        CoroutineScope coroutineScope2 = (CoroutineScope) zPlanAvatarResourceHelper$fetchReloadAvatarResourceNotUseCache$12.L$4;
                        com.tencent.zplan.zplantracing.b bVar9 = (com.tencent.zplan.zplantracing.b) zPlanAvatarResourceHelper$fetchReloadAvatarResourceNotUseCache$12.L$3;
                        com.tencent.zplan.zplantracing.b bVar10 = (com.tencent.zplan.zplantracing.b) zPlanAvatarResourceHelper$fetchReloadAvatarResourceNotUseCache$12.L$2;
                        FilamentUrlTemplate filamentUrlTemplate7 = (FilamentUrlTemplate) zPlanAvatarResourceHelper$fetchReloadAvatarResourceNotUseCache$12.L$1;
                        ZPlanAvatarResourceHelper zPlanAvatarResourceHelper2 = (ZPlanAvatarResourceHelper) zPlanAvatarResourceHelper$fetchReloadAvatarResourceNotUseCache$12.L$0;
                        ResultKt.throwOnFailure(obj22);
                        deferred = deferred53;
                        enumUserGender = enumUserGender10;
                        obj = coroutine_suspended;
                        z17 = false;
                        list = list17;
                        zPlanAvatarResourceHelper = zPlanAvatarResourceHelper2;
                        deferred5 = deferred51;
                        deferred3 = deferred55;
                        startSpan2 = bVar9;
                        obj2 = obj22;
                        deferred4 = deferred52;
                        deferred2 = deferred54;
                        startSpan = bVar10;
                        filamentUrlTemplate2 = filamentUrlTemplate7;
                        async$default2 = deferred56;
                        CoroutineScope = coroutineScope2;
                        Pair pair4 = (Pair) obj2;
                        List list132 = list;
                        Map<String, ZPlanFAsset> map132 = (Map) pair4.component1();
                        boolean booleanValue4 = ((Boolean) pair4.component2()).booleanValue();
                        if (startSpan2 == null) {
                        }
                        zPlanAvatarResourceHelper$fetchReloadAvatarResourceNotUseCache$12.L$0 = filamentUrlTemplate2;
                        zPlanAvatarResourceHelper$fetchReloadAvatarResourceNotUseCache$12.L$1 = startSpan;
                        zPlanAvatarResourceHelper$fetchReloadAvatarResourceNotUseCache$12.L$2 = startSpan2;
                        zPlanAvatarResourceHelper$fetchReloadAvatarResourceNotUseCache$12.L$3 = CoroutineScope;
                        zPlanAvatarResourceHelper$fetchReloadAvatarResourceNotUseCache$12.L$4 = async$default2;
                        zPlanAvatarResourceHelper$fetchReloadAvatarResourceNotUseCache$12.L$5 = deferred3;
                        zPlanAvatarResourceHelper$fetchReloadAvatarResourceNotUseCache$12.L$6 = deferred2;
                        zPlanAvatarResourceHelper$fetchReloadAvatarResourceNotUseCache$12.L$7 = enumUserGender;
                        zPlanAvatarResourceHelper$fetchReloadAvatarResourceNotUseCache$12.L$8 = deferred6;
                        zPlanAvatarResourceHelper$fetchReloadAvatarResourceNotUseCache$12.L$9 = deferred;
                        zPlanAvatarResourceHelper$fetchReloadAvatarResourceNotUseCache$12.L$10 = deferred7;
                        zPlanAvatarResourceHelper$fetchReloadAvatarResourceNotUseCache$12.L$11 = deferred4;
                        zPlanAvatarResourceHelper$fetchReloadAvatarResourceNotUseCache$12.L$12 = deferred5;
                        Deferred deferred382 = deferred;
                        zPlanAvatarResourceHelper$fetchReloadAvatarResourceNotUseCache$12.L$13 = list132;
                        zPlanAvatarResourceHelper$fetchReloadAvatarResourceNotUseCache$12.L$14 = map132;
                        zPlanAvatarResourceHelper$fetchReloadAvatarResourceNotUseCache$12.L$15 = list132;
                        zPlanAvatarResourceHelper$fetchReloadAvatarResourceNotUseCache$12.Z$0 = booleanValue4;
                        zPlanAvatarResourceHelper$fetchReloadAvatarResourceNotUseCache$12.label = 2;
                        Deferred deferred392 = deferred3;
                        Deferred deferred402 = deferred2;
                        com.tencent.zplan.zplantracing.c cVar22 = c16;
                        Deferred deferred412 = deferred7;
                        EnumUserGender enumUserGender82 = enumUserGender;
                        Deferred deferred422 = deferred6;
                        Deferred deferred432 = deferred5;
                        d06 = zPlanAvatarResourceHelper.d0(cVar22, map132, CoroutineScope, filamentUrlTemplate2, zPlanAvatarResourceHelper$fetchReloadAvatarResourceNotUseCache$12);
                        obj3 = obj;
                        if (d06 != obj3) {
                        }
                        break;
                    case 2:
                        boolean z88 = zPlanAvatarResourceHelper$fetchReloadAvatarResourceNotUseCache$12.Z$0;
                        List list18 = (List) zPlanAvatarResourceHelper$fetchReloadAvatarResourceNotUseCache$12.L$15;
                        Map<String, ZPlanFAsset> map20 = (Map) zPlanAvatarResourceHelper$fetchReloadAvatarResourceNotUseCache$12.L$14;
                        List list19 = (List) zPlanAvatarResourceHelper$fetchReloadAvatarResourceNotUseCache$12.L$13;
                        Deferred deferred57 = (Deferred) zPlanAvatarResourceHelper$fetchReloadAvatarResourceNotUseCache$12.L$12;
                        Deferred deferred58 = (Deferred) zPlanAvatarResourceHelper$fetchReloadAvatarResourceNotUseCache$12.L$11;
                        deferred8 = (Deferred) zPlanAvatarResourceHelper$fetchReloadAvatarResourceNotUseCache$12.L$10;
                        Deferred deferred59 = (Deferred) zPlanAvatarResourceHelper$fetchReloadAvatarResourceNotUseCache$12.L$9;
                        Deferred deferred60 = (Deferred) zPlanAvatarResourceHelper$fetchReloadAvatarResourceNotUseCache$12.L$8;
                        EnumUserGender enumUserGender11 = (EnumUserGender) zPlanAvatarResourceHelper$fetchReloadAvatarResourceNotUseCache$12.L$7;
                        Deferred deferred61 = (Deferred) zPlanAvatarResourceHelper$fetchReloadAvatarResourceNotUseCache$12.L$6;
                        Deferred deferred62 = (Deferred) zPlanAvatarResourceHelper$fetchReloadAvatarResourceNotUseCache$12.L$5;
                        Deferred deferred63 = (Deferred) zPlanAvatarResourceHelper$fetchReloadAvatarResourceNotUseCache$12.L$4;
                        CoroutineScope coroutineScope3 = (CoroutineScope) zPlanAvatarResourceHelper$fetchReloadAvatarResourceNotUseCache$12.L$3;
                        com.tencent.zplan.zplantracing.b bVar11 = (com.tencent.zplan.zplantracing.b) zPlanAvatarResourceHelper$fetchReloadAvatarResourceNotUseCache$12.L$2;
                        com.tencent.zplan.zplantracing.b bVar12 = (com.tencent.zplan.zplantracing.b) zPlanAvatarResourceHelper$fetchReloadAvatarResourceNotUseCache$12.L$1;
                        FilamentUrlTemplate filamentUrlTemplate8 = (FilamentUrlTemplate) zPlanAvatarResourceHelper$fetchReloadAvatarResourceNotUseCache$12.L$0;
                        ResultKt.throwOnFailure(obj22);
                        deferred11 = deferred63;
                        filamentUrlTemplate3 = filamentUrlTemplate8;
                        map = map20;
                        obj4 = coroutine_suspended;
                        deferred9 = deferred59;
                        enumUserGender2 = enumUserGender11;
                        deferred13 = deferred62;
                        z18 = z88;
                        z17 = false;
                        CoroutineScope = coroutineScope3;
                        startSpan = bVar12;
                        deferred4 = deferred58;
                        deferred10 = deferred57;
                        list3 = list19;
                        list2 = list18;
                        deferred14 = deferred61;
                        deferred12 = deferred60;
                        startSpan2 = bVar11;
                        list2.addAll((Collection) obj22);
                        zPlanAvatarResourceHelper$fetchReloadAvatarResourceNotUseCache$12.L$0 = filamentUrlTemplate3;
                        zPlanAvatarResourceHelper$fetchReloadAvatarResourceNotUseCache$12.L$1 = startSpan;
                        zPlanAvatarResourceHelper$fetchReloadAvatarResourceNotUseCache$12.L$2 = startSpan2;
                        zPlanAvatarResourceHelper$fetchReloadAvatarResourceNotUseCache$12.L$3 = CoroutineScope;
                        zPlanAvatarResourceHelper$fetchReloadAvatarResourceNotUseCache$12.L$4 = deferred13;
                        zPlanAvatarResourceHelper$fetchReloadAvatarResourceNotUseCache$12.L$5 = deferred14;
                        zPlanAvatarResourceHelper$fetchReloadAvatarResourceNotUseCache$12.L$6 = enumUserGender2;
                        zPlanAvatarResourceHelper$fetchReloadAvatarResourceNotUseCache$12.L$7 = deferred12;
                        zPlanAvatarResourceHelper$fetchReloadAvatarResourceNotUseCache$12.L$8 = deferred9;
                        zPlanAvatarResourceHelper$fetchReloadAvatarResourceNotUseCache$12.L$9 = deferred8;
                        zPlanAvatarResourceHelper$fetchReloadAvatarResourceNotUseCache$12.L$10 = deferred4;
                        zPlanAvatarResourceHelper$fetchReloadAvatarResourceNotUseCache$12.L$11 = deferred10;
                        zPlanAvatarResourceHelper$fetchReloadAvatarResourceNotUseCache$12.L$12 = list3;
                        Map<String, ZPlanFAsset> map142 = map;
                        zPlanAvatarResourceHelper$fetchReloadAvatarResourceNotUseCache$12.L$13 = map142;
                        zPlanAvatarResourceHelper$fetchReloadAvatarResourceNotUseCache$12.L$14 = null;
                        zPlanAvatarResourceHelper$fetchReloadAvatarResourceNotUseCache$12.L$15 = null;
                        z19 = z18;
                        zPlanAvatarResourceHelper$fetchReloadAvatarResourceNotUseCache$12.Z$0 = z19;
                        FilamentUrlTemplate filamentUrlTemplate62 = filamentUrlTemplate3;
                        zPlanAvatarResourceHelper$fetchReloadAvatarResourceNotUseCache$12.label = 3;
                        await = deferred11.await(zPlanAvatarResourceHelper$fetchReloadAvatarResourceNotUseCache$12);
                        obj5 = obj4;
                        if (await != obj5) {
                        }
                        break;
                    case 3:
                        boolean z89 = zPlanAvatarResourceHelper$fetchReloadAvatarResourceNotUseCache$12.Z$0;
                        map2 = (Map) zPlanAvatarResourceHelper$fetchReloadAvatarResourceNotUseCache$12.L$13;
                        list4 = (List) zPlanAvatarResourceHelper$fetchReloadAvatarResourceNotUseCache$12.L$12;
                        Deferred deferred64 = (Deferred) zPlanAvatarResourceHelper$fetchReloadAvatarResourceNotUseCache$12.L$11;
                        deferred18 = (Deferred) zPlanAvatarResourceHelper$fetchReloadAvatarResourceNotUseCache$12.L$10;
                        Deferred deferred65 = (Deferred) zPlanAvatarResourceHelper$fetchReloadAvatarResourceNotUseCache$12.L$9;
                        Deferred deferred66 = (Deferred) zPlanAvatarResourceHelper$fetchReloadAvatarResourceNotUseCache$12.L$8;
                        Deferred deferred67 = (Deferred) zPlanAvatarResourceHelper$fetchReloadAvatarResourceNotUseCache$12.L$7;
                        EnumUserGender enumUserGender12 = (EnumUserGender) zPlanAvatarResourceHelper$fetchReloadAvatarResourceNotUseCache$12.L$6;
                        Deferred deferred68 = (Deferred) zPlanAvatarResourceHelper$fetchReloadAvatarResourceNotUseCache$12.L$5;
                        Deferred deferred69 = (Deferred) zPlanAvatarResourceHelper$fetchReloadAvatarResourceNotUseCache$12.L$4;
                        CoroutineScope coroutineScope4 = (CoroutineScope) zPlanAvatarResourceHelper$fetchReloadAvatarResourceNotUseCache$12.L$3;
                        com.tencent.zplan.zplantracing.b bVar13 = (com.tencent.zplan.zplantracing.b) zPlanAvatarResourceHelper$fetchReloadAvatarResourceNotUseCache$12.L$2;
                        com.tencent.zplan.zplantracing.b bVar14 = (com.tencent.zplan.zplantracing.b) zPlanAvatarResourceHelper$fetchReloadAvatarResourceNotUseCache$12.L$1;
                        filamentUrlTemplate4 = (FilamentUrlTemplate) zPlanAvatarResourceHelper$fetchReloadAvatarResourceNotUseCache$12.L$0;
                        ResultKt.throwOnFailure(obj22);
                        await = obj22;
                        obj6 = coroutine_suspended;
                        enumUserGender3 = enumUserGender12;
                        deferred16 = deferred68;
                        deferred15 = deferred69;
                        CoroutineScope = coroutineScope4;
                        startSpan2 = bVar13;
                        deferred17 = deferred66;
                        deferred12 = deferred67;
                        startSpan = bVar14;
                        deferred8 = deferred65;
                        deferred10 = deferred64;
                        z19 = z89;
                        z17 = false;
                        Resource resource4 = (Resource) await;
                        boolean z772 = z19;
                        String path22 = resource4.getPath();
                        boolean downloadFromNet4 = resource4.getDownloadFromNet();
                        zPlanAvatarResourceHelper$fetchReloadAvatarResourceNotUseCache$12.L$0 = filamentUrlTemplate4;
                        zPlanAvatarResourceHelper$fetchReloadAvatarResourceNotUseCache$12.L$1 = startSpan;
                        zPlanAvatarResourceHelper$fetchReloadAvatarResourceNotUseCache$12.L$2 = startSpan2;
                        zPlanAvatarResourceHelper$fetchReloadAvatarResourceNotUseCache$12.L$3 = CoroutineScope;
                        zPlanAvatarResourceHelper$fetchReloadAvatarResourceNotUseCache$12.L$4 = deferred15;
                        zPlanAvatarResourceHelper$fetchReloadAvatarResourceNotUseCache$12.L$5 = enumUserGender3;
                        zPlanAvatarResourceHelper$fetchReloadAvatarResourceNotUseCache$12.L$6 = deferred12;
                        zPlanAvatarResourceHelper$fetchReloadAvatarResourceNotUseCache$12.L$7 = deferred17;
                        zPlanAvatarResourceHelper$fetchReloadAvatarResourceNotUseCache$12.L$8 = deferred8;
                        zPlanAvatarResourceHelper$fetchReloadAvatarResourceNotUseCache$12.L$9 = deferred18;
                        zPlanAvatarResourceHelper$fetchReloadAvatarResourceNotUseCache$12.L$10 = deferred10;
                        zPlanAvatarResourceHelper$fetchReloadAvatarResourceNotUseCache$12.L$11 = list4;
                        zPlanAvatarResourceHelper$fetchReloadAvatarResourceNotUseCache$12.L$12 = map2;
                        zPlanAvatarResourceHelper$fetchReloadAvatarResourceNotUseCache$12.L$13 = path22;
                        Deferred deferred452 = deferred15;
                        zPlanAvatarResourceHelper$fetchReloadAvatarResourceNotUseCache$12.Z$0 = z772;
                        zPlanAvatarResourceHelper$fetchReloadAvatarResourceNotUseCache$12.Z$1 = downloadFromNet4;
                        zPlanAvatarResourceHelper$fetchReloadAvatarResourceNotUseCache$12.label = 4;
                        await2 = deferred16.await(zPlanAvatarResourceHelper$fetchReloadAvatarResourceNotUseCache$12);
                        obj7 = obj6;
                        if (await2 != obj7) {
                        }
                        break;
                    case 4:
                        boolean z95 = zPlanAvatarResourceHelper$fetchReloadAvatarResourceNotUseCache$12.Z$1;
                        boolean z96 = zPlanAvatarResourceHelper$fetchReloadAvatarResourceNotUseCache$12.Z$0;
                        String str18 = (String) zPlanAvatarResourceHelper$fetchReloadAvatarResourceNotUseCache$12.L$13;
                        Map<String, ZPlanFAsset> map21 = (Map) zPlanAvatarResourceHelper$fetchReloadAvatarResourceNotUseCache$12.L$12;
                        List list20 = (List) zPlanAvatarResourceHelper$fetchReloadAvatarResourceNotUseCache$12.L$11;
                        Deferred deferred70 = (Deferred) zPlanAvatarResourceHelper$fetchReloadAvatarResourceNotUseCache$12.L$10;
                        Deferred deferred71 = (Deferred) zPlanAvatarResourceHelper$fetchReloadAvatarResourceNotUseCache$12.L$9;
                        Deferred deferred72 = (Deferred) zPlanAvatarResourceHelper$fetchReloadAvatarResourceNotUseCache$12.L$8;
                        Deferred deferred73 = (Deferred) zPlanAvatarResourceHelper$fetchReloadAvatarResourceNotUseCache$12.L$7;
                        Deferred deferred74 = (Deferred) zPlanAvatarResourceHelper$fetchReloadAvatarResourceNotUseCache$12.L$6;
                        EnumUserGender enumUserGender13 = (EnumUserGender) zPlanAvatarResourceHelper$fetchReloadAvatarResourceNotUseCache$12.L$5;
                        Deferred deferred75 = (Deferred) zPlanAvatarResourceHelper$fetchReloadAvatarResourceNotUseCache$12.L$4;
                        CoroutineScope coroutineScope5 = (CoroutineScope) zPlanAvatarResourceHelper$fetchReloadAvatarResourceNotUseCache$12.L$3;
                        com.tencent.zplan.zplantracing.b bVar15 = (com.tencent.zplan.zplantracing.b) zPlanAvatarResourceHelper$fetchReloadAvatarResourceNotUseCache$12.L$2;
                        com.tencent.zplan.zplantracing.b bVar16 = (com.tencent.zplan.zplantracing.b) zPlanAvatarResourceHelper$fetchReloadAvatarResourceNotUseCache$12.L$1;
                        FilamentUrlTemplate filamentUrlTemplate9 = (FilamentUrlTemplate) zPlanAvatarResourceHelper$fetchReloadAvatarResourceNotUseCache$12.L$0;
                        ResultKt.throwOnFailure(obj22);
                        await2 = obj22;
                        obj7 = coroutine_suspended;
                        deferred19 = deferred74;
                        enumUserGender4 = enumUserGender13;
                        deferred20 = deferred75;
                        z26 = z96;
                        str = str18;
                        map3 = map21;
                        deferred21 = deferred70;
                        deferred22 = deferred71;
                        deferred24 = deferred73;
                        z27 = z95;
                        z17 = false;
                        startSpan2 = bVar15;
                        filamentUrlTemplate5 = filamentUrlTemplate9;
                        list5 = list20;
                        deferred23 = deferred72;
                        coroutineScope = coroutineScope5;
                        startSpan = bVar16;
                        Pair pair22 = (Pair) await2;
                        List list142 = list5;
                        zPlanCommonGltfFAsset = (ZPlanCommonGltfFAsset) pair22.component1();
                        boolean booleanValue22 = ((Boolean) pair22.component2()).booleanValue();
                        if (zPlanCommonGltfFAsset.getGltfFilePath() == null) {
                        }
                        zPlanAvatarResourceHelper$fetchReloadAvatarResourceNotUseCache$12.L$0 = startSpan;
                        zPlanAvatarResourceHelper$fetchReloadAvatarResourceNotUseCache$12.L$1 = startSpan2;
                        Deferred deferred462 = deferred20;
                        zPlanAvatarResourceHelper$fetchReloadAvatarResourceNotUseCache$12.L$2 = deferred462;
                        EnumUserGender enumUserGender92 = enumUserGender4;
                        zPlanAvatarResourceHelper$fetchReloadAvatarResourceNotUseCache$12.L$3 = enumUserGender92;
                        Deferred deferred472 = deferred19;
                        zPlanAvatarResourceHelper$fetchReloadAvatarResourceNotUseCache$12.L$4 = deferred472;
                        Deferred deferred482 = deferred26;
                        zPlanAvatarResourceHelper$fetchReloadAvatarResourceNotUseCache$12.L$5 = deferred482;
                        Deferred deferred492 = deferred25;
                        zPlanAvatarResourceHelper$fetchReloadAvatarResourceNotUseCache$12.L$6 = deferred492;
                        zPlanAvatarResourceHelper$fetchReloadAvatarResourceNotUseCache$12.L$7 = deferred21;
                        zPlanAvatarResourceHelper$fetchReloadAvatarResourceNotUseCache$12.L$8 = list6;
                        zPlanAvatarResourceHelper$fetchReloadAvatarResourceNotUseCache$12.L$9 = map3;
                        zPlanAvatarResourceHelper$fetchReloadAvatarResourceNotUseCache$12.L$10 = str;
                        zPlanAvatarResourceHelper$fetchReloadAvatarResourceNotUseCache$12.L$11 = zPlanCommonGltfFAsset2;
                        zPlanAvatarResourceHelper$fetchReloadAvatarResourceNotUseCache$12.L$12 = null;
                        zPlanAvatarResourceHelper$fetchReloadAvatarResourceNotUseCache$12.L$13 = null;
                        zPlanAvatarResourceHelper$fetchReloadAvatarResourceNotUseCache$12.Z$0 = z26;
                        zPlanAvatarResourceHelper$fetchReloadAvatarResourceNotUseCache$12.Z$1 = z27;
                        z29 = z28;
                        zPlanAvatarResourceHelper$fetchReloadAvatarResourceNotUseCache$12.Z$2 = z29;
                        List list152 = list6;
                        zPlanAvatarResourceHelper$fetchReloadAvatarResourceNotUseCache$12.label = 5;
                        await3 = deferred27.await(zPlanAvatarResourceHelper$fetchReloadAvatarResourceNotUseCache$12);
                        ZPlanCommonGltfFAsset zPlanCommonGltfFAsset92 = zPlanCommonGltfFAsset2;
                        obj9 = obj8;
                        if (await3 != obj9) {
                        }
                        break;
                    case 5:
                        boolean z97 = zPlanAvatarResourceHelper$fetchReloadAvatarResourceNotUseCache$12.Z$2;
                        boolean z98 = zPlanAvatarResourceHelper$fetchReloadAvatarResourceNotUseCache$12.Z$1;
                        z36 = zPlanAvatarResourceHelper$fetchReloadAvatarResourceNotUseCache$12.Z$0;
                        zPlanCommonGltfFAsset3 = (ZPlanCommonGltfFAsset) zPlanAvatarResourceHelper$fetchReloadAvatarResourceNotUseCache$12.L$11;
                        str2 = (String) zPlanAvatarResourceHelper$fetchReloadAvatarResourceNotUseCache$12.L$10;
                        Map<String, ZPlanFAsset> map22 = (Map) zPlanAvatarResourceHelper$fetchReloadAvatarResourceNotUseCache$12.L$9;
                        List list21 = (List) zPlanAvatarResourceHelper$fetchReloadAvatarResourceNotUseCache$12.L$8;
                        Deferred deferred76 = (Deferred) zPlanAvatarResourceHelper$fetchReloadAvatarResourceNotUseCache$12.L$7;
                        Deferred deferred77 = (Deferred) zPlanAvatarResourceHelper$fetchReloadAvatarResourceNotUseCache$12.L$6;
                        Deferred deferred78 = (Deferred) zPlanAvatarResourceHelper$fetchReloadAvatarResourceNotUseCache$12.L$5;
                        deferred31 = (Deferred) zPlanAvatarResourceHelper$fetchReloadAvatarResourceNotUseCache$12.L$4;
                        EnumUserGender enumUserGender14 = (EnumUserGender) zPlanAvatarResourceHelper$fetchReloadAvatarResourceNotUseCache$12.L$3;
                        Deferred deferred79 = (Deferred) zPlanAvatarResourceHelper$fetchReloadAvatarResourceNotUseCache$12.L$2;
                        com.tencent.zplan.zplantracing.b bVar17 = (com.tencent.zplan.zplantracing.b) zPlanAvatarResourceHelper$fetchReloadAvatarResourceNotUseCache$12.L$1;
                        bVar = (com.tencent.zplan.zplantracing.b) zPlanAvatarResourceHelper$fetchReloadAvatarResourceNotUseCache$12.L$0;
                        ResultKt.throwOnFailure(obj22);
                        await3 = obj22;
                        obj10 = coroutine_suspended;
                        deferred29 = deferred77;
                        deferred28 = deferred78;
                        startSpan2 = bVar17;
                        list7 = list21;
                        deferred30 = deferred76;
                        enumUserGender5 = enumUserGender14;
                        z27 = z98;
                        map3 = map22;
                        z29 = z97;
                        z17 = false;
                        deferred32 = deferred79;
                        Resource resource22 = (Resource) await3;
                        boolean z782 = z29;
                        path = resource22.getPath();
                        boolean downloadFromNet22 = resource22.getDownloadFromNet();
                        zPlanAvatarResourceHelper$fetchReloadAvatarResourceNotUseCache$12.L$0 = bVar;
                        zPlanAvatarResourceHelper$fetchReloadAvatarResourceNotUseCache$12.L$1 = startSpan2;
                        zPlanAvatarResourceHelper$fetchReloadAvatarResourceNotUseCache$12.L$2 = deferred32;
                        zPlanAvatarResourceHelper$fetchReloadAvatarResourceNotUseCache$12.L$3 = enumUserGender5;
                        zPlanAvatarResourceHelper$fetchReloadAvatarResourceNotUseCache$12.L$4 = deferred31;
                        zPlanAvatarResourceHelper$fetchReloadAvatarResourceNotUseCache$12.L$5 = deferred28;
                        zPlanAvatarResourceHelper$fetchReloadAvatarResourceNotUseCache$12.L$6 = deferred30;
                        zPlanAvatarResourceHelper$fetchReloadAvatarResourceNotUseCache$12.L$7 = list7;
                        zPlanAvatarResourceHelper$fetchReloadAvatarResourceNotUseCache$12.L$8 = map3;
                        zPlanAvatarResourceHelper$fetchReloadAvatarResourceNotUseCache$12.L$9 = str2;
                        zPlanAvatarResourceHelper$fetchReloadAvatarResourceNotUseCache$12.L$10 = zPlanCommonGltfFAsset3;
                        zPlanAvatarResourceHelper$fetchReloadAvatarResourceNotUseCache$12.L$11 = path;
                        zPlanAvatarResourceHelper$fetchReloadAvatarResourceNotUseCache$12.Z$0 = z36;
                        zPlanAvatarResourceHelper$fetchReloadAvatarResourceNotUseCache$12.Z$1 = z27;
                        Deferred deferred502 = deferred28;
                        zPlanAvatarResourceHelper$fetchReloadAvatarResourceNotUseCache$12.Z$2 = z782;
                        zPlanAvatarResourceHelper$fetchReloadAvatarResourceNotUseCache$12.Z$3 = downloadFromNet22;
                        zPlanAvatarResourceHelper$fetchReloadAvatarResourceNotUseCache$12.label = 6;
                        await4 = deferred29.await(zPlanAvatarResourceHelper$fetchReloadAvatarResourceNotUseCache$12);
                        obj11 = obj10;
                        if (await4 != obj11) {
                        }
                        break;
                    case 6:
                        boolean z99 = zPlanAvatarResourceHelper$fetchReloadAvatarResourceNotUseCache$12.Z$3;
                        boolean z100 = zPlanAvatarResourceHelper$fetchReloadAvatarResourceNotUseCache$12.Z$2;
                        boolean z101 = zPlanAvatarResourceHelper$fetchReloadAvatarResourceNotUseCache$12.Z$1;
                        boolean z102 = zPlanAvatarResourceHelper$fetchReloadAvatarResourceNotUseCache$12.Z$0;
                        String str19 = (String) zPlanAvatarResourceHelper$fetchReloadAvatarResourceNotUseCache$12.L$11;
                        ZPlanCommonGltfFAsset zPlanCommonGltfFAsset12 = (ZPlanCommonGltfFAsset) zPlanAvatarResourceHelper$fetchReloadAvatarResourceNotUseCache$12.L$10;
                        String str20 = (String) zPlanAvatarResourceHelper$fetchReloadAvatarResourceNotUseCache$12.L$9;
                        Map<String, ZPlanFAsset> map23 = (Map) zPlanAvatarResourceHelper$fetchReloadAvatarResourceNotUseCache$12.L$8;
                        List list22 = (List) zPlanAvatarResourceHelper$fetchReloadAvatarResourceNotUseCache$12.L$7;
                        Deferred deferred80 = (Deferred) zPlanAvatarResourceHelper$fetchReloadAvatarResourceNotUseCache$12.L$6;
                        Deferred deferred81 = (Deferred) zPlanAvatarResourceHelper$fetchReloadAvatarResourceNotUseCache$12.L$5;
                        Deferred deferred82 = (Deferred) zPlanAvatarResourceHelper$fetchReloadAvatarResourceNotUseCache$12.L$4;
                        EnumUserGender enumUserGender15 = (EnumUserGender) zPlanAvatarResourceHelper$fetchReloadAvatarResourceNotUseCache$12.L$3;
                        Deferred deferred83 = (Deferred) zPlanAvatarResourceHelper$fetchReloadAvatarResourceNotUseCache$12.L$2;
                        com.tencent.zplan.zplantracing.b bVar18 = (com.tencent.zplan.zplantracing.b) zPlanAvatarResourceHelper$fetchReloadAvatarResourceNotUseCache$12.L$1;
                        bVar = (com.tencent.zplan.zplantracing.b) zPlanAvatarResourceHelper$fetchReloadAvatarResourceNotUseCache$12.L$0;
                        ResultKt.throwOnFailure(obj22);
                        await4 = obj22;
                        obj12 = coroutine_suspended;
                        map4 = map23;
                        deferred33 = deferred80;
                        z39 = z99;
                        z17 = false;
                        enumUserGender5 = enumUserGender15;
                        zPlanCommonGltfFAsset4 = zPlanCommonGltfFAsset12;
                        str3 = str20;
                        z27 = z101;
                        path = str19;
                        list8 = list22;
                        startSpan2 = bVar18;
                        z37 = z102;
                        z38 = z100;
                        deferred32 = deferred83;
                        deferred34 = deferred81;
                        deferred31 = deferred82;
                        Resource resource32 = (Resource) await4;
                        boolean z792 = z38;
                        String path32 = resource32.getPath();
                        boolean downloadFromNet32 = resource32.getDownloadFromNet();
                        zPlanAvatarResourceHelper$fetchReloadAvatarResourceNotUseCache$12.L$0 = bVar;
                        zPlanAvatarResourceHelper$fetchReloadAvatarResourceNotUseCache$12.L$1 = startSpan2;
                        zPlanAvatarResourceHelper$fetchReloadAvatarResourceNotUseCache$12.L$2 = deferred32;
                        zPlanAvatarResourceHelper$fetchReloadAvatarResourceNotUseCache$12.L$3 = enumUserGender5;
                        zPlanAvatarResourceHelper$fetchReloadAvatarResourceNotUseCache$12.L$4 = deferred31;
                        zPlanAvatarResourceHelper$fetchReloadAvatarResourceNotUseCache$12.L$5 = deferred34;
                        zPlanAvatarResourceHelper$fetchReloadAvatarResourceNotUseCache$12.L$6 = list8;
                        zPlanAvatarResourceHelper$fetchReloadAvatarResourceNotUseCache$12.L$7 = map4;
                        zPlanAvatarResourceHelper$fetchReloadAvatarResourceNotUseCache$12.L$8 = str3;
                        zPlanAvatarResourceHelper$fetchReloadAvatarResourceNotUseCache$12.L$9 = zPlanCommonGltfFAsset4;
                        zPlanAvatarResourceHelper$fetchReloadAvatarResourceNotUseCache$12.L$10 = path;
                        zPlanAvatarResourceHelper$fetchReloadAvatarResourceNotUseCache$12.L$11 = path32;
                        zPlanAvatarResourceHelper$fetchReloadAvatarResourceNotUseCache$12.Z$0 = z37;
                        zPlanAvatarResourceHelper$fetchReloadAvatarResourceNotUseCache$12.Z$1 = z27;
                        Map<String, ZPlanFAsset> map162 = map4;
                        zPlanAvatarResourceHelper$fetchReloadAvatarResourceNotUseCache$12.Z$2 = z792;
                        boolean z852 = z39;
                        zPlanAvatarResourceHelper$fetchReloadAvatarResourceNotUseCache$12.Z$3 = z852;
                        zPlanAvatarResourceHelper$fetchReloadAvatarResourceNotUseCache$12.Z$4 = downloadFromNet32;
                        zPlanAvatarResourceHelper$fetchReloadAvatarResourceNotUseCache$12.label = 7;
                        await5 = deferred33.await(zPlanAvatarResourceHelper$fetchReloadAvatarResourceNotUseCache$12);
                        obj13 = obj12;
                        if (await5 != obj13) {
                        }
                        break;
                    case 7:
                        boolean z103 = zPlanAvatarResourceHelper$fetchReloadAvatarResourceNotUseCache$12.Z$4;
                        boolean z104 = zPlanAvatarResourceHelper$fetchReloadAvatarResourceNotUseCache$12.Z$3;
                        boolean z105 = zPlanAvatarResourceHelper$fetchReloadAvatarResourceNotUseCache$12.Z$2;
                        boolean z106 = zPlanAvatarResourceHelper$fetchReloadAvatarResourceNotUseCache$12.Z$1;
                        boolean z107 = zPlanAvatarResourceHelper$fetchReloadAvatarResourceNotUseCache$12.Z$0;
                        String str21 = (String) zPlanAvatarResourceHelper$fetchReloadAvatarResourceNotUseCache$12.L$11;
                        String str22 = (String) zPlanAvatarResourceHelper$fetchReloadAvatarResourceNotUseCache$12.L$10;
                        ZPlanCommonGltfFAsset zPlanCommonGltfFAsset13 = (ZPlanCommonGltfFAsset) zPlanAvatarResourceHelper$fetchReloadAvatarResourceNotUseCache$12.L$9;
                        String str23 = (String) zPlanAvatarResourceHelper$fetchReloadAvatarResourceNotUseCache$12.L$8;
                        Map<String, ZPlanFAsset> map24 = (Map) zPlanAvatarResourceHelper$fetchReloadAvatarResourceNotUseCache$12.L$7;
                        List list23 = (List) zPlanAvatarResourceHelper$fetchReloadAvatarResourceNotUseCache$12.L$6;
                        deferred34 = (Deferred) zPlanAvatarResourceHelper$fetchReloadAvatarResourceNotUseCache$12.L$5;
                        Deferred deferred84 = (Deferred) zPlanAvatarResourceHelper$fetchReloadAvatarResourceNotUseCache$12.L$4;
                        EnumUserGender enumUserGender16 = (EnumUserGender) zPlanAvatarResourceHelper$fetchReloadAvatarResourceNotUseCache$12.L$3;
                        Deferred deferred85 = (Deferred) zPlanAvatarResourceHelper$fetchReloadAvatarResourceNotUseCache$12.L$2;
                        com.tencent.zplan.zplantracing.b bVar19 = (com.tencent.zplan.zplantracing.b) zPlanAvatarResourceHelper$fetchReloadAvatarResourceNotUseCache$12.L$1;
                        bVar = (com.tencent.zplan.zplantracing.b) zPlanAvatarResourceHelper$fetchReloadAvatarResourceNotUseCache$12.L$0;
                        ResultKt.throwOnFailure(obj22);
                        await5 = obj22;
                        z46 = z104;
                        obj14 = coroutine_suspended;
                        zPlanCommonGltfFAsset5 = zPlanCommonGltfFAsset13;
                        list9 = list23;
                        z47 = z103;
                        z17 = false;
                        deferred31 = deferred84;
                        enumUserGender5 = enumUserGender16;
                        deferred32 = deferred85;
                        str4 = str21;
                        z48 = z107;
                        z49 = z105;
                        str5 = str23;
                        startSpan2 = bVar19;
                        z27 = z106;
                        map5 = map24;
                        str6 = str22;
                        Pair pair32 = (Pair) await5;
                        boolean z862 = z49;
                        Map map172 = (Map) pair32.component1();
                        boolean booleanValue32 = ((Boolean) pair32.component2()).booleanValue();
                        list10 = list9;
                        zPlanAvatarResourceHelper$fetchReloadAvatarResourceNotUseCache$12.L$0 = bVar;
                        zPlanAvatarResourceHelper$fetchReloadAvatarResourceNotUseCache$12.L$1 = startSpan2;
                        zPlanAvatarResourceHelper$fetchReloadAvatarResourceNotUseCache$12.L$2 = deferred32;
                        zPlanAvatarResourceHelper$fetchReloadAvatarResourceNotUseCache$12.L$3 = enumUserGender5;
                        zPlanAvatarResourceHelper$fetchReloadAvatarResourceNotUseCache$12.L$4 = deferred31;
                        zPlanAvatarResourceHelper$fetchReloadAvatarResourceNotUseCache$12.L$5 = deferred34;
                        zPlanAvatarResourceHelper$fetchReloadAvatarResourceNotUseCache$12.L$6 = map5;
                        zPlanAvatarResourceHelper$fetchReloadAvatarResourceNotUseCache$12.L$7 = str5;
                        zPlanAvatarResourceHelper$fetchReloadAvatarResourceNotUseCache$12.L$8 = zPlanCommonGltfFAsset5;
                        zPlanAvatarResourceHelper$fetchReloadAvatarResourceNotUseCache$12.L$9 = str6;
                        zPlanAvatarResourceHelper$fetchReloadAvatarResourceNotUseCache$12.L$10 = str4;
                        zPlanAvatarResourceHelper$fetchReloadAvatarResourceNotUseCache$12.L$11 = map172;
                        zPlanAvatarResourceHelper$fetchReloadAvatarResourceNotUseCache$12.Z$0 = z48;
                        zPlanAvatarResourceHelper$fetchReloadAvatarResourceNotUseCache$12.Z$1 = z27;
                        ZPlanCommonGltfFAsset zPlanCommonGltfFAsset102 = zPlanCommonGltfFAsset5;
                        zPlanAvatarResourceHelper$fetchReloadAvatarResourceNotUseCache$12.Z$2 = z862;
                        zPlanAvatarResourceHelper$fetchReloadAvatarResourceNotUseCache$12.Z$3 = z46;
                        zPlanAvatarResourceHelper$fetchReloadAvatarResourceNotUseCache$12.Z$4 = z47;
                        zPlanAvatarResourceHelper$fetchReloadAvatarResourceNotUseCache$12.Z$5 = booleanValue32;
                        zPlanAvatarResourceHelper$fetchReloadAvatarResourceNotUseCache$12.label = 8;
                        obj15 = obj14;
                        if (AwaitKt.awaitAll(list10, zPlanAvatarResourceHelper$fetchReloadAvatarResourceNotUseCache$12) != obj15) {
                        }
                        break;
                    case 8:
                        boolean z108 = zPlanAvatarResourceHelper$fetchReloadAvatarResourceNotUseCache$12.Z$5;
                        boolean z109 = zPlanAvatarResourceHelper$fetchReloadAvatarResourceNotUseCache$12.Z$4;
                        boolean z110 = zPlanAvatarResourceHelper$fetchReloadAvatarResourceNotUseCache$12.Z$3;
                        boolean z111 = zPlanAvatarResourceHelper$fetchReloadAvatarResourceNotUseCache$12.Z$2;
                        boolean z112 = zPlanAvatarResourceHelper$fetchReloadAvatarResourceNotUseCache$12.Z$1;
                        boolean z113 = zPlanAvatarResourceHelper$fetchReloadAvatarResourceNotUseCache$12.Z$0;
                        Map map25 = (Map) zPlanAvatarResourceHelper$fetchReloadAvatarResourceNotUseCache$12.L$11;
                        String str24 = (String) zPlanAvatarResourceHelper$fetchReloadAvatarResourceNotUseCache$12.L$10;
                        String str25 = (String) zPlanAvatarResourceHelper$fetchReloadAvatarResourceNotUseCache$12.L$9;
                        ZPlanCommonGltfFAsset zPlanCommonGltfFAsset14 = (ZPlanCommonGltfFAsset) zPlanAvatarResourceHelper$fetchReloadAvatarResourceNotUseCache$12.L$8;
                        String str26 = (String) zPlanAvatarResourceHelper$fetchReloadAvatarResourceNotUseCache$12.L$7;
                        Map<String, ZPlanFAsset> map26 = (Map) zPlanAvatarResourceHelper$fetchReloadAvatarResourceNotUseCache$12.L$6;
                        Deferred deferred86 = (Deferred) zPlanAvatarResourceHelper$fetchReloadAvatarResourceNotUseCache$12.L$5;
                        Deferred deferred87 = (Deferred) zPlanAvatarResourceHelper$fetchReloadAvatarResourceNotUseCache$12.L$4;
                        EnumUserGender enumUserGender17 = (EnumUserGender) zPlanAvatarResourceHelper$fetchReloadAvatarResourceNotUseCache$12.L$3;
                        Deferred deferred88 = (Deferred) zPlanAvatarResourceHelper$fetchReloadAvatarResourceNotUseCache$12.L$2;
                        com.tencent.zplan.zplantracing.b bVar20 = (com.tencent.zplan.zplantracing.b) zPlanAvatarResourceHelper$fetchReloadAvatarResourceNotUseCache$12.L$1;
                        com.tencent.zplan.zplantracing.b bVar21 = (com.tencent.zplan.zplantracing.b) zPlanAvatarResourceHelper$fetchReloadAvatarResourceNotUseCache$12.L$0;
                        ResultKt.throwOnFailure(obj22);
                        z56 = z108;
                        bVar2 = bVar21;
                        z57 = z109;
                        map6 = map25;
                        str9 = str24;
                        deferred35 = deferred88;
                        bVar3 = bVar20;
                        z17 = false;
                        enumUserGender5 = enumUserGender17;
                        z27 = z112;
                        obj16 = coroutine_suspended;
                        z55 = z110;
                        z58 = z113;
                        str8 = str25;
                        str7 = str26;
                        deferred31 = deferred87;
                        z59 = z111;
                        zPlanCommonGltfFAsset6 = zPlanCommonGltfFAsset14;
                        map7 = map26;
                        deferred34 = deferred86;
                        if (bVar3 != null) {
                        }
                        zPlanAvatarResourceHelper$fetchReloadAvatarResourceNotUseCache$12.L$0 = bVar2;
                        zPlanAvatarResourceHelper$fetchReloadAvatarResourceNotUseCache$12.L$1 = enumUserGender5;
                        zPlanAvatarResourceHelper$fetchReloadAvatarResourceNotUseCache$12.L$2 = deferred31;
                        zPlanAvatarResourceHelper$fetchReloadAvatarResourceNotUseCache$12.L$3 = deferred34;
                        zPlanAvatarResourceHelper$fetchReloadAvatarResourceNotUseCache$12.L$4 = zPlanCommonGltfFAsset6;
                        zPlanAvatarResourceHelper$fetchReloadAvatarResourceNotUseCache$12.L$5 = str8;
                        zPlanAvatarResourceHelper$fetchReloadAvatarResourceNotUseCache$12.L$6 = str9;
                        zPlanAvatarResourceHelper$fetchReloadAvatarResourceNotUseCache$12.L$7 = map6;
                        zPlanAvatarResourceHelper$fetchReloadAvatarResourceNotUseCache$12.L$8 = map7;
                        zPlanAvatarResourceHelper$fetchReloadAvatarResourceNotUseCache$12.L$9 = str7;
                        zPlanAvatarResourceHelper$fetchReloadAvatarResourceNotUseCache$12.L$10 = null;
                        zPlanAvatarResourceHelper$fetchReloadAvatarResourceNotUseCache$12.L$11 = null;
                        zPlanAvatarResourceHelper$fetchReloadAvatarResourceNotUseCache$12.Z$0 = z58;
                        zPlanAvatarResourceHelper$fetchReloadAvatarResourceNotUseCache$12.Z$1 = z27;
                        zPlanAvatarResourceHelper$fetchReloadAvatarResourceNotUseCache$12.Z$2 = z59;
                        zPlanAvatarResourceHelper$fetchReloadAvatarResourceNotUseCache$12.Z$3 = z55;
                        boolean z872 = z57;
                        zPlanAvatarResourceHelper$fetchReloadAvatarResourceNotUseCache$12.Z$4 = z872;
                        com.tencent.zplan.zplantracing.b bVar82 = bVar2;
                        zPlanAvatarResourceHelper$fetchReloadAvatarResourceNotUseCache$12.Z$5 = z56;
                        zPlanAvatarResourceHelper$fetchReloadAvatarResourceNotUseCache$12.label = 9;
                        await6 = deferred35.await(zPlanAvatarResourceHelper$fetchReloadAvatarResourceNotUseCache$12);
                        Map map182 = map6;
                        obj17 = obj16;
                        if (await6 != obj17) {
                        }
                        break;
                    case 9:
                        boolean z114 = zPlanAvatarResourceHelper$fetchReloadAvatarResourceNotUseCache$12.Z$5;
                        boolean z115 = zPlanAvatarResourceHelper$fetchReloadAvatarResourceNotUseCache$12.Z$4;
                        boolean z116 = zPlanAvatarResourceHelper$fetchReloadAvatarResourceNotUseCache$12.Z$3;
                        boolean z117 = zPlanAvatarResourceHelper$fetchReloadAvatarResourceNotUseCache$12.Z$2;
                        boolean z118 = zPlanAvatarResourceHelper$fetchReloadAvatarResourceNotUseCache$12.Z$1;
                        boolean z119 = zPlanAvatarResourceHelper$fetchReloadAvatarResourceNotUseCache$12.Z$0;
                        String str27 = (String) zPlanAvatarResourceHelper$fetchReloadAvatarResourceNotUseCache$12.L$9;
                        map8 = (Map) zPlanAvatarResourceHelper$fetchReloadAvatarResourceNotUseCache$12.L$8;
                        Map map27 = (Map) zPlanAvatarResourceHelper$fetchReloadAvatarResourceNotUseCache$12.L$7;
                        String str28 = (String) zPlanAvatarResourceHelper$fetchReloadAvatarResourceNotUseCache$12.L$6;
                        str11 = (String) zPlanAvatarResourceHelper$fetchReloadAvatarResourceNotUseCache$12.L$5;
                        ZPlanCommonGltfFAsset zPlanCommonGltfFAsset15 = (ZPlanCommonGltfFAsset) zPlanAvatarResourceHelper$fetchReloadAvatarResourceNotUseCache$12.L$4;
                        Deferred deferred89 = (Deferred) zPlanAvatarResourceHelper$fetchReloadAvatarResourceNotUseCache$12.L$3;
                        Deferred deferred90 = (Deferred) zPlanAvatarResourceHelper$fetchReloadAvatarResourceNotUseCache$12.L$2;
                        EnumUserGender enumUserGender18 = (EnumUserGender) zPlanAvatarResourceHelper$fetchReloadAvatarResourceNotUseCache$12.L$1;
                        com.tencent.zplan.zplantracing.b bVar22 = (com.tencent.zplan.zplantracing.b) zPlanAvatarResourceHelper$fetchReloadAvatarResourceNotUseCache$12.L$0;
                        ResultKt.throwOnFailure(obj22);
                        z56 = z114;
                        deferred36 = deferred90;
                        await6 = obj22;
                        obj18 = coroutine_suspended;
                        str10 = str28;
                        z17 = false;
                        z58 = z119;
                        map9 = map27;
                        z59 = z117;
                        str7 = str27;
                        z65 = z115;
                        z27 = z118;
                        bVar4 = bVar22;
                        z55 = z116;
                        zPlanCommonGltfFAsset7 = zPlanCommonGltfFAsset15;
                        deferred34 = deferred89;
                        enumUserGender6 = enumUserGender18;
                        List list162 = (List) await6;
                        zPlanAvatarResourceHelper$fetchReloadAvatarResourceNotUseCache$12.L$0 = bVar4;
                        zPlanAvatarResourceHelper$fetchReloadAvatarResourceNotUseCache$12.L$1 = deferred34;
                        zPlanAvatarResourceHelper$fetchReloadAvatarResourceNotUseCache$12.L$2 = str11;
                        zPlanAvatarResourceHelper$fetchReloadAvatarResourceNotUseCache$12.L$3 = str10;
                        zPlanAvatarResourceHelper$fetchReloadAvatarResourceNotUseCache$12.L$4 = map9;
                        zPlanAvatarResourceHelper$fetchReloadAvatarResourceNotUseCache$12.L$5 = map8;
                        zPlanAvatarResourceHelper$fetchReloadAvatarResourceNotUseCache$12.L$6 = str7;
                        zPlanAvatarResourceHelper$fetchReloadAvatarResourceNotUseCache$12.L$7 = list162;
                        zPlanAvatarResourceHelper$fetchReloadAvatarResourceNotUseCache$12.L$8 = zPlanCommonGltfFAsset7;
                        zPlanAvatarResourceHelper$fetchReloadAvatarResourceNotUseCache$12.L$9 = enumUserGender6;
                        zPlanAvatarResourceHelper$fetchReloadAvatarResourceNotUseCache$12.Z$0 = z58;
                        zPlanAvatarResourceHelper$fetchReloadAvatarResourceNotUseCache$12.Z$1 = z27;
                        zPlanAvatarResourceHelper$fetchReloadAvatarResourceNotUseCache$12.Z$2 = z59;
                        zPlanAvatarResourceHelper$fetchReloadAvatarResourceNotUseCache$12.Z$3 = z55;
                        zPlanAvatarResourceHelper$fetchReloadAvatarResourceNotUseCache$12.Z$4 = z65;
                        zPlanAvatarResourceHelper$fetchReloadAvatarResourceNotUseCache$12.Z$5 = z56;
                        zPlanAvatarResourceHelper$fetchReloadAvatarResourceNotUseCache$12.label = 10;
                        await7 = deferred36.await(zPlanAvatarResourceHelper$fetchReloadAvatarResourceNotUseCache$12);
                        String str172 = str10;
                        obj19 = obj18;
                        if (await7 != obj19) {
                        }
                        break;
                    case 10:
                        boolean z120 = zPlanAvatarResourceHelper$fetchReloadAvatarResourceNotUseCache$12.Z$5;
                        boolean z121 = zPlanAvatarResourceHelper$fetchReloadAvatarResourceNotUseCache$12.Z$4;
                        boolean z122 = zPlanAvatarResourceHelper$fetchReloadAvatarResourceNotUseCache$12.Z$3;
                        boolean z123 = zPlanAvatarResourceHelper$fetchReloadAvatarResourceNotUseCache$12.Z$2;
                        boolean z124 = zPlanAvatarResourceHelper$fetchReloadAvatarResourceNotUseCache$12.Z$1;
                        boolean z125 = zPlanAvatarResourceHelper$fetchReloadAvatarResourceNotUseCache$12.Z$0;
                        EnumUserGender enumUserGender19 = (EnumUserGender) zPlanAvatarResourceHelper$fetchReloadAvatarResourceNotUseCache$12.L$9;
                        ZPlanCommonGltfFAsset zPlanCommonGltfFAsset16 = (ZPlanCommonGltfFAsset) zPlanAvatarResourceHelper$fetchReloadAvatarResourceNotUseCache$12.L$8;
                        list11 = (List) zPlanAvatarResourceHelper$fetchReloadAvatarResourceNotUseCache$12.L$7;
                        String str29 = (String) zPlanAvatarResourceHelper$fetchReloadAvatarResourceNotUseCache$12.L$6;
                        Map<String, ZPlanFAsset> map28 = (Map) zPlanAvatarResourceHelper$fetchReloadAvatarResourceNotUseCache$12.L$5;
                        Map map29 = (Map) zPlanAvatarResourceHelper$fetchReloadAvatarResourceNotUseCache$12.L$4;
                        String str30 = (String) zPlanAvatarResourceHelper$fetchReloadAvatarResourceNotUseCache$12.L$3;
                        String str31 = (String) zPlanAvatarResourceHelper$fetchReloadAvatarResourceNotUseCache$12.L$2;
                        Deferred deferred91 = (Deferred) zPlanAvatarResourceHelper$fetchReloadAvatarResourceNotUseCache$12.L$1;
                        com.tencent.zplan.zplantracing.b bVar23 = (com.tencent.zplan.zplantracing.b) zPlanAvatarResourceHelper$fetchReloadAvatarResourceNotUseCache$12.L$0;
                        ResultKt.throwOnFailure(obj22);
                        z56 = z120;
                        deferred37 = deferred91;
                        await7 = obj22;
                        obj20 = coroutine_suspended;
                        map10 = map28;
                        z17 = false;
                        str11 = str31;
                        bVar5 = bVar23;
                        enumUserGender6 = enumUserGender19;
                        z27 = z124;
                        z55 = z122;
                        zPlanCommonGltfFAsset7 = zPlanCommonGltfFAsset16;
                        z66 = z125;
                        z59 = z123;
                        z65 = z121;
                        str12 = str30;
                        str13 = str29;
                        map9 = map29;
                        z67 = z65;
                        z68 = z55;
                        double doubleValue3 = ((Number) await7).doubleValue();
                        zPlanAvatarResourceHelper$fetchReloadAvatarResourceNotUseCache$12.L$0 = bVar5;
                        zPlanAvatarResourceHelper$fetchReloadAvatarResourceNotUseCache$12.L$1 = str11;
                        zPlanAvatarResourceHelper$fetchReloadAvatarResourceNotUseCache$12.L$2 = str12;
                        zPlanAvatarResourceHelper$fetchReloadAvatarResourceNotUseCache$12.L$3 = map9;
                        zPlanAvatarResourceHelper$fetchReloadAvatarResourceNotUseCache$12.L$4 = map10;
                        zPlanAvatarResourceHelper$fetchReloadAvatarResourceNotUseCache$12.L$5 = str13;
                        zPlanAvatarResourceHelper$fetchReloadAvatarResourceNotUseCache$12.L$6 = list11;
                        zPlanAvatarResourceHelper$fetchReloadAvatarResourceNotUseCache$12.L$7 = zPlanCommonGltfFAsset7;
                        zPlanAvatarResourceHelper$fetchReloadAvatarResourceNotUseCache$12.L$8 = enumUserGender6;
                        zPlanAvatarResourceHelper$fetchReloadAvatarResourceNotUseCache$12.L$9 = null;
                        zPlanAvatarResourceHelper$fetchReloadAvatarResourceNotUseCache$12.Z$0 = z66;
                        zPlanAvatarResourceHelper$fetchReloadAvatarResourceNotUseCache$12.Z$1 = z27;
                        zPlanAvatarResourceHelper$fetchReloadAvatarResourceNotUseCache$12.Z$2 = z59;
                        zPlanAvatarResourceHelper$fetchReloadAvatarResourceNotUseCache$12.Z$3 = z68;
                        zPlanAvatarResourceHelper$fetchReloadAvatarResourceNotUseCache$12.Z$4 = z67;
                        zPlanAvatarResourceHelper$fetchReloadAvatarResourceNotUseCache$12.Z$5 = z56;
                        zPlanAvatarResourceHelper$fetchReloadAvatarResourceNotUseCache$12.D$0 = doubleValue3;
                        zPlanAvatarResourceHelper$fetchReloadAvatarResourceNotUseCache$12.label = 11;
                        await8 = deferred37.await(zPlanAvatarResourceHelper$fetchReloadAvatarResourceNotUseCache$12);
                        obj21 = obj20;
                        if (await8 != obj21) {
                        }
                        break;
                    case 11:
                        double d17 = zPlanAvatarResourceHelper$fetchReloadAvatarResourceNotUseCache$12.D$0;
                        boolean z126 = zPlanAvatarResourceHelper$fetchReloadAvatarResourceNotUseCache$12.Z$5;
                        boolean z127 = zPlanAvatarResourceHelper$fetchReloadAvatarResourceNotUseCache$12.Z$4;
                        boolean z128 = zPlanAvatarResourceHelper$fetchReloadAvatarResourceNotUseCache$12.Z$3;
                        boolean z129 = zPlanAvatarResourceHelper$fetchReloadAvatarResourceNotUseCache$12.Z$2;
                        boolean z130 = zPlanAvatarResourceHelper$fetchReloadAvatarResourceNotUseCache$12.Z$1;
                        boolean z131 = zPlanAvatarResourceHelper$fetchReloadAvatarResourceNotUseCache$12.Z$0;
                        EnumUserGender enumUserGender20 = (EnumUserGender) zPlanAvatarResourceHelper$fetchReloadAvatarResourceNotUseCache$12.L$8;
                        ZPlanCommonGltfFAsset zPlanCommonGltfFAsset17 = (ZPlanCommonGltfFAsset) zPlanAvatarResourceHelper$fetchReloadAvatarResourceNotUseCache$12.L$7;
                        List list24 = (List) zPlanAvatarResourceHelper$fetchReloadAvatarResourceNotUseCache$12.L$6;
                        String str32 = (String) zPlanAvatarResourceHelper$fetchReloadAvatarResourceNotUseCache$12.L$5;
                        Map<String, ZPlanFAsset> map30 = (Map) zPlanAvatarResourceHelper$fetchReloadAvatarResourceNotUseCache$12.L$4;
                        Map map31 = (Map) zPlanAvatarResourceHelper$fetchReloadAvatarResourceNotUseCache$12.L$3;
                        String str33 = (String) zPlanAvatarResourceHelper$fetchReloadAvatarResourceNotUseCache$12.L$2;
                        String str34 = (String) zPlanAvatarResourceHelper$fetchReloadAvatarResourceNotUseCache$12.L$1;
                        com.tencent.zplan.zplantracing.b bVar24 = (com.tencent.zplan.zplantracing.b) zPlanAvatarResourceHelper$fetchReloadAvatarResourceNotUseCache$12.L$0;
                        ResultKt.throwOnFailure(obj22);
                        map11 = map31;
                        str16 = str33;
                        z56 = z126;
                        z67 = z127;
                        z68 = z128;
                        z69 = z130;
                        z75 = z131;
                        list12 = list24;
                        str15 = str32;
                        map12 = map30;
                        zPlanCommonGltfFAsset8 = zPlanCommonGltfFAsset17;
                        z17 = false;
                        str14 = str34;
                        z76 = z129;
                        enumUserGender7 = enumUserGender20;
                        bVar6 = bVar24;
                        d16 = d17;
                        double doubleValue22 = ((Number) obj22).doubleValue();
                        bVar7 = bVar6;
                        ReloadAvatarResourceModel reloadAvatarResourceModel2 = new ReloadAvatarResourceModel(map12, str15, list12, zPlanCommonGltfFAsset8, enumUserGender7, d16, doubleValue22, str14, !(str16.length() != 0 ? true : z17) ? null : str16, map11);
                        reloadAvatarResourceModel2.F((!z75 || z69 || z76 || z68 || z67 || z56) ? true : z17);
                        if (bVar7 != null) {
                        }
                        if (bVar7 != null) {
                        }
                        return reloadAvatarResourceModel2;
                    default:
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
            }
        }
        zPlanAvatarResourceHelper$fetchReloadAvatarResourceNotUseCache$1 = new ZPlanAvatarResourceHelper$fetchReloadAvatarResourceNotUseCache$1(this, continuation);
        zPlanAvatarResourceHelper$fetchReloadAvatarResourceNotUseCache$12 = zPlanAvatarResourceHelper$fetchReloadAvatarResourceNotUseCache$1;
        Object obj222 = zPlanAvatarResourceHelper$fetchReloadAvatarResourceNotUseCache$12.result;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (zPlanAvatarResourceHelper$fetchReloadAvatarResourceNotUseCache$12.label) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x00a6  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x00b2  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x00bf  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x008c A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:38:0x008d  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x004e  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0025  */
    @Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object Y(@Nullable com.tencent.zplan.zplantracing.c cVar, @NotNull JSONObject jSONObject, @NotNull FilamentUrlTemplate filamentUrlTemplate, boolean z16, @NotNull Continuation<? super ReloadAvatarResourceModel> continuation) throws FetchFileException, BlackListResourceException, RuntimeException {
        ZPlanAvatarResourceHelper$fetchReloadAvatarResourceWithCpp$1 zPlanAvatarResourceHelper$fetchReloadAvatarResourceWithCpp$1;
        Object coroutine_suspended;
        int i3;
        com.tencent.zplan.zplantracing.b startSpan;
        Object w3;
        com.tencent.zplan.zplantracing.b bVar;
        ZPlanAvatarInterfaceResult zPlanAvatarInterfaceResult;
        JSONObject jSONObject2;
        ZPlanAvatarInterfaceResult zPlanAvatarInterfaceResult2;
        boolean z17;
        if (continuation instanceof ZPlanAvatarResourceHelper$fetchReloadAvatarResourceWithCpp$1) {
            zPlanAvatarResourceHelper$fetchReloadAvatarResourceWithCpp$1 = (ZPlanAvatarResourceHelper$fetchReloadAvatarResourceWithCpp$1) continuation;
            int i16 = zPlanAvatarResourceHelper$fetchReloadAvatarResourceWithCpp$1.label;
            if ((i16 & Integer.MIN_VALUE) != 0) {
                zPlanAvatarResourceHelper$fetchReloadAvatarResourceWithCpp$1.label = i16 - Integer.MIN_VALUE;
                Object obj = zPlanAvatarResourceHelper$fetchReloadAvatarResourceWithCpp$1.result;
                coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i3 = zPlanAvatarResourceHelper$fetchReloadAvatarResourceWithCpp$1.label;
                boolean z18 = false;
                if (i3 == 0) {
                    if (i3 != 1) {
                        if (i3 == 2) {
                            zPlanAvatarInterfaceResult = (ZPlanAvatarInterfaceResult) zPlanAvatarResourceHelper$fetchReloadAvatarResourceWithCpp$1.L$2;
                            bVar = (com.tencent.zplan.zplantracing.b) zPlanAvatarResourceHelper$fetchReloadAvatarResourceWithCpp$1.L$1;
                            jSONObject2 = (JSONObject) zPlanAvatarResourceHelper$fetchReloadAvatarResourceWithCpp$1.L$0;
                            ResultKt.throwOnFailure(obj);
                            zPlanAvatarInterfaceResult2 = (ZPlanAvatarInterfaceResult) obj;
                            if (zPlanAvatarInterfaceResult.isDownload() && !zPlanAvatarInterfaceResult2.isDownload()) {
                                z17 = false;
                            } else {
                                z17 = true;
                            }
                            if (bVar != null) {
                                bVar.e("downloadFromNet", String.valueOf(z17));
                            }
                            if (bVar != null) {
                                bVar.b();
                            }
                            try {
                                ReloadAvatarResourceModel a16 = f.a(jSONObject2, zPlanAvatarInterfaceResult, zPlanAvatarInterfaceResult2.getResult());
                                if (z17) {
                                    z18 = true;
                                }
                                a16.F(z18);
                                return a16;
                            } catch (JSONException e16) {
                                FLog.INSTANCE.i("FilamentNativeApp[ZPlanAvatarResourceHelper]V2", "fetchReloadAvatarResourceWithCpp fail. there is an exception when parse result. " + e16.getMessage());
                                throw new FetchFileException(FetchFileException.Type.DOWNLOAD_FAIL, -1, "parse result fail. " + e16.getMessage(), "");
                            }
                        }
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    startSpan = (com.tencent.zplan.zplantracing.b) zPlanAvatarResourceHelper$fetchReloadAvatarResourceWithCpp$1.L$1;
                    jSONObject = (JSONObject) zPlanAvatarResourceHelper$fetchReloadAvatarResourceWithCpp$1.L$0;
                    ResultKt.throwOnFailure(obj);
                } else {
                    ResultKt.throwOnFailure(obj);
                    startSpan = ZPlanSpanFactory.INSTANCE.startSpan("fetchReloadAvatarResourceWithCpp", cVar);
                    ZPlanAvatarService zPlanAvatarService = avatarService;
                    String jSONObject3 = jSONObject.toString();
                    Intrinsics.checkNotNullExpressionValue(jSONObject3, "avatarPbJson.toString()");
                    ZPlanAvatarMask zPlanAvatarMask = new ZPlanAvatarMask(new String[0]);
                    zPlanAvatarResourceHelper$fetchReloadAvatarResourceWithCpp$1.L$0 = jSONObject;
                    zPlanAvatarResourceHelper$fetchReloadAvatarResourceWithCpp$1.L$1 = startSpan;
                    zPlanAvatarResourceHelper$fetchReloadAvatarResourceWithCpp$1.label = 1;
                    obj = zPlanAvatarService.y(jSONObject3, zPlanAvatarMask, true, zPlanAvatarResourceHelper$fetchReloadAvatarResourceWithCpp$1);
                    if (obj == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                }
                ZPlanAvatarInterfaceResult zPlanAvatarInterfaceResult3 = (ZPlanAvatarInterfaceResult) obj;
                ZPlanAvatarService zPlanAvatarService2 = avatarService;
                zPlanAvatarResourceHelper$fetchReloadAvatarResourceWithCpp$1.L$0 = jSONObject;
                zPlanAvatarResourceHelper$fetchReloadAvatarResourceWithCpp$1.L$1 = startSpan;
                zPlanAvatarResourceHelper$fetchReloadAvatarResourceWithCpp$1.L$2 = zPlanAvatarInterfaceResult3;
                zPlanAvatarResourceHelper$fetchReloadAvatarResourceWithCpp$1.label = 2;
                w3 = zPlanAvatarService2.w(zPlanAvatarResourceHelper$fetchReloadAvatarResourceWithCpp$1);
                if (w3 != coroutine_suspended) {
                    return coroutine_suspended;
                }
                JSONObject jSONObject4 = jSONObject;
                bVar = startSpan;
                zPlanAvatarInterfaceResult = zPlanAvatarInterfaceResult3;
                obj = w3;
                jSONObject2 = jSONObject4;
                zPlanAvatarInterfaceResult2 = (ZPlanAvatarInterfaceResult) obj;
                if (zPlanAvatarInterfaceResult.isDownload()) {
                }
                z17 = true;
                if (bVar != null) {
                }
                if (bVar != null) {
                }
                ReloadAvatarResourceModel a162 = f.a(jSONObject2, zPlanAvatarInterfaceResult, zPlanAvatarInterfaceResult2.getResult());
                if (z17) {
                }
                a162.F(z18);
                return a162;
            }
        }
        zPlanAvatarResourceHelper$fetchReloadAvatarResourceWithCpp$1 = new ZPlanAvatarResourceHelper$fetchReloadAvatarResourceWithCpp$1(this, continuation);
        Object obj2 = zPlanAvatarResourceHelper$fetchReloadAvatarResourceWithCpp$1.result;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i3 = zPlanAvatarResourceHelper$fetchReloadAvatarResourceWithCpp$1.label;
        boolean z182 = false;
        if (i3 == 0) {
        }
        ZPlanAvatarInterfaceResult zPlanAvatarInterfaceResult32 = (ZPlanAvatarInterfaceResult) obj2;
        ZPlanAvatarService zPlanAvatarService22 = avatarService;
        zPlanAvatarResourceHelper$fetchReloadAvatarResourceWithCpp$1.L$0 = jSONObject;
        zPlanAvatarResourceHelper$fetchReloadAvatarResourceWithCpp$1.L$1 = startSpan;
        zPlanAvatarResourceHelper$fetchReloadAvatarResourceWithCpp$1.L$2 = zPlanAvatarInterfaceResult32;
        zPlanAvatarResourceHelper$fetchReloadAvatarResourceWithCpp$1.label = 2;
        w3 = zPlanAvatarService22.w(zPlanAvatarResourceHelper$fetchReloadAvatarResourceWithCpp$1);
        if (w3 != coroutine_suspended) {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0036  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0023  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final /* synthetic */ Object Z(String str, FilamentUrlTemplate filamentUrlTemplate, Continuation<? super String> continuation) {
        ZPlanAvatarResourceHelper$fetchShadersDirectory$1 zPlanAvatarResourceHelper$fetchShadersDirectory$1;
        Object coroutine_suspended;
        int i3;
        try {
            if (continuation instanceof ZPlanAvatarResourceHelper$fetchShadersDirectory$1) {
                zPlanAvatarResourceHelper$fetchShadersDirectory$1 = (ZPlanAvatarResourceHelper$fetchShadersDirectory$1) continuation;
                int i16 = zPlanAvatarResourceHelper$fetchShadersDirectory$1.label;
                if ((i16 & Integer.MIN_VALUE) != 0) {
                    zPlanAvatarResourceHelper$fetchShadersDirectory$1.label = i16 - Integer.MIN_VALUE;
                    Object obj = zPlanAvatarResourceHelper$fetchShadersDirectory$1.result;
                    coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    i3 = zPlanAvatarResourceHelper$fetchShadersDirectory$1.label;
                    if (i3 == 0) {
                        if (i3 == 1) {
                            str = (String) zPlanAvatarResourceHelper$fetchShadersDirectory$1.L$0;
                            ResultKt.throwOnFailure(obj);
                        } else {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                    } else {
                        ResultKt.throwOnFailure(obj);
                        if (enableCppDownload) {
                            ZPlanAvatarService zPlanAvatarService = avatarService;
                            zPlanAvatarResourceHelper$fetchShadersDirectory$1.L$0 = str;
                            zPlanAvatarResourceHelper$fetchShadersDirectory$1.label = 1;
                            obj = zPlanAvatarService.u(zPlanAvatarResourceHelper$fetchShadersDirectory$1);
                            if (obj == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                        } else {
                            return N0(str, filamentUrlTemplate);
                        }
                    }
                    return obj;
                }
            }
            if (i3 == 0) {
            }
            return obj;
        } catch (ZPlanAvatarServiceException e16) {
            FLog.INSTANCE.e("FilamentNativeApp[ZPlanAvatarResourceHelper]V2", "fetchShadersDirectory fail. url:" + str);
            throw new RuntimeException(e16.toString());
        }
        zPlanAvatarResourceHelper$fetchShadersDirectory$1 = new ZPlanAvatarResourceHelper$fetchShadersDirectory$1(this, continuation);
        Object obj2 = zPlanAvatarResourceHelper$fetchShadersDirectory$1.result;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i3 = zPlanAvatarResourceHelper$fetchShadersDirectory$1.label;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Removed duplicated region for block: B:12:0x00f5  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0054  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x002e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final /* synthetic */ Object a0(com.tencent.zplan.zplantracing.c cVar, FilamentUrlTemplate filamentUrlTemplate, Continuation<? super Unit> continuation) {
        ZPlanAvatarResourceHelper$fetchShadowPlaneShader$1 zPlanAvatarResourceHelper$fetchShadowPlaneShader$1;
        Object coroutine_suspended;
        int i3;
        FilamentUrlTemplate filamentUrlTemplate2;
        ZPlanAvatarService zPlanAvatarService;
        com.tencent.zplan.zplantracing.b bVar;
        String replace$default;
        com.tencent.zplan.zplantracing.c cVar2;
        if (continuation instanceof ZPlanAvatarResourceHelper$fetchShadowPlaneShader$1) {
            zPlanAvatarResourceHelper$fetchShadowPlaneShader$1 = (ZPlanAvatarResourceHelper$fetchShadowPlaneShader$1) continuation;
            int i16 = zPlanAvatarResourceHelper$fetchShadowPlaneShader$1.label;
            if ((i16 & Integer.MIN_VALUE) != 0) {
                zPlanAvatarResourceHelper$fetchShadowPlaneShader$1.label = i16 - Integer.MIN_VALUE;
                ZPlanAvatarResourceHelper$fetchShadowPlaneShader$1 zPlanAvatarResourceHelper$fetchShadowPlaneShader$12 = zPlanAvatarResourceHelper$fetchShadowPlaneShader$1;
                Object obj = zPlanAvatarResourceHelper$fetchShadowPlaneShader$12.result;
                coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i3 = zPlanAvatarResourceHelper$fetchShadowPlaneShader$12.label;
                if (i3 == 0) {
                    if (i3 != 1) {
                        if (i3 == 2) {
                            bVar = (com.tencent.zplan.zplantracing.b) zPlanAvatarResourceHelper$fetchShadowPlaneShader$12.L$0;
                            ResultKt.throwOnFailure(obj);
                        } else {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                    } else {
                        bVar = (com.tencent.zplan.zplantracing.b) zPlanAvatarResourceHelper$fetchShadowPlaneShader$12.L$1;
                        FilamentUrlTemplate filamentUrlTemplate3 = (FilamentUrlTemplate) zPlanAvatarResourceHelper$fetchShadowPlaneShader$12.L$0;
                        try {
                            ResultKt.throwOnFailure(obj);
                        } catch (ZPlanAvatarServiceException e16) {
                            e = e16;
                            filamentUrlTemplate2 = filamentUrlTemplate3;
                            FLog.INSTANCE.e("FilamentNativeApp[ZPlanAvatarResourceHelper]V2", "fetchShadowPlaneShader fail. urlTemplate:" + filamentUrlTemplate2);
                            throw new FetchFileException(FetchFileException.Type.FILE_IS_EMPTY, e.getError().getErrorCode().getValue(), String.valueOf(e.getError().getErrorMsg()), "shadowPlane.filamat");
                        }
                    }
                } else {
                    ResultKt.throwOnFailure(obj);
                    com.tencent.zplan.zplantracing.b startSpan = ZPlanSpanFactory.INSTANCE.startSpan("fetchShadowPlaneShaderSpan", cVar);
                    if (!enableCppDownload) {
                        replace$default = StringsKt__StringsJVMKt.replace$default(filamentUrlTemplate.getMaterialSplitUrl(), "{file_name}", com.tencent.filament.zplanservice.util.c.c("shadowPlane.filamat"), false, 4, (Object) null);
                        if (startSpan != null) {
                            cVar2 = startSpan.c();
                        } else {
                            cVar2 = null;
                        }
                        zPlanAvatarResourceHelper$fetchShadowPlaneShader$12.L$0 = startSpan;
                        zPlanAvatarResourceHelper$fetchShadowPlaneShader$12.label = 2;
                        if (h0(this, cVar2, replace$default, filamentUrlTemplate, false, zPlanAvatarResourceHelper$fetchShadowPlaneShader$12, 8, null) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                    } else {
                        try {
                            zPlanAvatarService = avatarService;
                            filamentUrlTemplate2 = filamentUrlTemplate;
                        } catch (ZPlanAvatarServiceException e17) {
                            e = e17;
                            filamentUrlTemplate2 = filamentUrlTemplate;
                        }
                        try {
                            zPlanAvatarResourceHelper$fetchShadowPlaneShader$12.L$0 = filamentUrlTemplate2;
                            zPlanAvatarResourceHelper$fetchShadowPlaneShader$12.L$1 = startSpan;
                            zPlanAvatarResourceHelper$fetchShadowPlaneShader$12.label = 1;
                            if (zPlanAvatarService.t("shadowPlane", "filamat", zPlanAvatarResourceHelper$fetchShadowPlaneShader$12) == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                        } catch (ZPlanAvatarServiceException e18) {
                            e = e18;
                            FLog.INSTANCE.e("FilamentNativeApp[ZPlanAvatarResourceHelper]V2", "fetchShadowPlaneShader fail. urlTemplate:" + filamentUrlTemplate2);
                            throw new FetchFileException(FetchFileException.Type.FILE_IS_EMPTY, e.getError().getErrorCode().getValue(), String.valueOf(e.getError().getErrorMsg()), "shadowPlane.filamat");
                        }
                    }
                    bVar = startSpan;
                }
                if (bVar != null) {
                    bVar.b();
                }
                return Unit.INSTANCE;
            }
        }
        zPlanAvatarResourceHelper$fetchShadowPlaneShader$1 = new ZPlanAvatarResourceHelper$fetchShadowPlaneShader$1(this, continuation);
        ZPlanAvatarResourceHelper$fetchShadowPlaneShader$1 zPlanAvatarResourceHelper$fetchShadowPlaneShader$122 = zPlanAvatarResourceHelper$fetchShadowPlaneShader$1;
        Object obj2 = zPlanAvatarResourceHelper$fetchShadowPlaneShader$122.result;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i3 = zPlanAvatarResourceHelper$fetchShadowPlaneShader$122.label;
        if (i3 == 0) {
        }
        if (bVar != null) {
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ Object b0(JSONObject jSONObject, com.tencent.zplan.zplantracing.c cVar, Continuation<? super Double> continuation) {
        JSONArray jSONArray;
        JSONObject optJSONObject;
        com.tencent.zplan.zplantracing.b startSpan = ZPlanSpanFactory.INSTANCE.startSpan("fetchShoeHeight", cVar);
        JSONObject optJSONObject2 = jSONObject.optJSONObject("avatar_info");
        if (optJSONObject2 != null) {
            jSONArray = optJSONObject2.optJSONArray("slot_arr");
        } else {
            jSONArray = null;
        }
        double d16 = 0.0d;
        if (jSONArray != null && jSONArray.length() > 0) {
            int length = jSONArray.length();
            for (int i3 = 0; i3 < length; i3++) {
                JSONObject optJSONObject3 = jSONArray.optJSONObject(i3);
                if (optJSONObject3 != null && optJSONObject3.optLong(MiniAppReportManager2.KEY_SLOT_ID) == AvatarSlot.cfgpb_AvatarSlot_EN_SLOT_SHOES.getValue() && (optJSONObject = optJSONObject3.optJSONObject("item_data")) != null) {
                    d16 = optJSONObject.optDouble("shoe_height");
                    FLog.INSTANCE.i("FilamentNativeApp[ZPlanAvatarResourceHelper]", "fetchShoeHeightWithAvatar shoeHeight is " + d16);
                }
            }
            if (startSpan != null) {
                startSpan.b();
            }
            return Boxing.boxDouble(d16 * 0.01d);
        }
        if (startSpan != null) {
            startSpan.e("hasSlot", String.valueOf(false));
        }
        if (startSpan != null) {
            startSpan.b();
        }
        return Boxing.boxDouble(0.0d);
    }

    /* JADX WARN: Can't wrap try/catch for region: R(10:1|(2:3|(7:5|6|7|(1:(1:(3:11|12|13)(2:15|16))(4:17|18|19|20))(2:22|(4:24|(1:26)|19|20)(4:27|(1:29)|12|13))|30|31|32))|33|6|7|(0)(0)|30|31|32|(1:(0))) */
    /* JADX WARN: Removed duplicated region for block: B:22:0x003f  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0024  */
    @Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object c0(@Nullable com.tencent.zplan.zplantracing.c cVar, @NotNull String str, @NotNull FilamentUrlTemplate filamentUrlTemplate, @NotNull Continuation<? super Unit> continuation) throws FetchFileException {
        ZPlanAvatarResourceHelper$fetchSplitShaderWithGltf$1 zPlanAvatarResourceHelper$fetchSplitShaderWithGltf$1;
        Object coroutine_suspended;
        int i3;
        if (continuation instanceof ZPlanAvatarResourceHelper$fetchSplitShaderWithGltf$1) {
            zPlanAvatarResourceHelper$fetchSplitShaderWithGltf$1 = (ZPlanAvatarResourceHelper$fetchSplitShaderWithGltf$1) continuation;
            int i16 = zPlanAvatarResourceHelper$fetchSplitShaderWithGltf$1.label;
            if ((i16 & Integer.MIN_VALUE) != 0) {
                zPlanAvatarResourceHelper$fetchSplitShaderWithGltf$1.label = i16 - Integer.MIN_VALUE;
                Object obj = zPlanAvatarResourceHelper$fetchSplitShaderWithGltf$1.result;
                coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i3 = zPlanAvatarResourceHelper$fetchSplitShaderWithGltf$1.label;
                if (i3 == 0) {
                    if (i3 != 1) {
                        if (i3 == 2) {
                            ResultKt.throwOnFailure(obj);
                            return Unit.INSTANCE;
                        }
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    str = (String) zPlanAvatarResourceHelper$fetchSplitShaderWithGltf$1.L$0;
                    ResultKt.throwOnFailure(obj);
                    return Unit.INSTANCE;
                }
                ResultKt.throwOnFailure(obj);
                if (enableCppDownload) {
                    ZPlanAvatarService zPlanAvatarService = avatarService;
                    zPlanAvatarResourceHelper$fetchSplitShaderWithGltf$1.L$0 = str;
                    zPlanAvatarResourceHelper$fetchSplitShaderWithGltf$1.label = 1;
                    if (zPlanAvatarService.D(str, zPlanAvatarResourceHelper$fetchSplitShaderWithGltf$1) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    return Unit.INSTANCE;
                }
                ZPlanAvatarResourceHelper$fetchSplitShaderWithGltf$2 zPlanAvatarResourceHelper$fetchSplitShaderWithGltf$2 = new ZPlanAvatarResourceHelper$fetchSplitShaderWithGltf$2(cVar, str, filamentUrlTemplate, null);
                zPlanAvatarResourceHelper$fetchSplitShaderWithGltf$1.label = 2;
                if (CoroutineScopeKt.coroutineScope(zPlanAvatarResourceHelper$fetchSplitShaderWithGltf$2, zPlanAvatarResourceHelper$fetchSplitShaderWithGltf$1) == coroutine_suspended) {
                    return coroutine_suspended;
                }
                return Unit.INSTANCE;
                FLog.INSTANCE.e("FilamentNativeApp[ZPlanAvatarResourceHelper]V2", "fetchSplitShaderWithGltf fail. gltfPath:" + str);
                throw new FetchFileException(FetchFileException.Type.FILE_IS_BROKEN, e.getError().getErrorCode().getValue(), e.getError().getErrorMsg() + " gltfPath:" + str, "");
            }
        }
        zPlanAvatarResourceHelper$fetchSplitShaderWithGltf$1 = new ZPlanAvatarResourceHelper$fetchSplitShaderWithGltf$1(this, continuation);
        Object obj2 = zPlanAvatarResourceHelper$fetchSplitShaderWithGltf$1.result;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i3 = zPlanAvatarResourceHelper$fetchSplitShaderWithGltf$1.label;
        if (i3 == 0) {
        }
        FLog.INSTANCE.e("FilamentNativeApp[ZPlanAvatarResourceHelper]V2", "fetchSplitShaderWithGltf fail. gltfPath:" + str);
        throw new FetchFileException(FetchFileException.Type.FILE_IS_BROKEN, e.getError().getErrorCode().getValue(), e.getError().getErrorMsg() + " gltfPath:" + str, "");
    }

    final /* synthetic */ Object d0(com.tencent.zplan.zplantracing.c cVar, Map<String, ZPlanFAsset> map, CoroutineScope coroutineScope, FilamentUrlTemplate filamentUrlTemplate, Continuation<? super List<Deferred<Unit>>> continuation) {
        String gltfFilePath;
        Deferred async$default;
        com.tencent.zplan.zplantracing.b startSpan = ZPlanSpanFactory.INSTANCE.startSpan("fetchSplitShaderWithSlotAssetMap", cVar);
        ArrayList arrayList = new ArrayList();
        Iterator<Map.Entry<String, ZPlanFAsset>> it = map.entrySet().iterator();
        while (it.hasNext()) {
            ZPlanFAsset value = it.next().getValue();
            if ((value instanceof ZPlanCommonGltfFAsset) && (gltfFilePath = ((ZPlanCommonGltfFAsset) value).getGltfFilePath()) != null) {
                async$default = BuildersKt__Builders_commonKt.async$default(coroutineScope, null, null, new ZPlanAvatarResourceHelper$fetchSplitShaderWithSlotAssetMap$fetchShaderJob$1(cVar, gltfFilePath, filamentUrlTemplate, null), 3, null);
                arrayList.add(async$default);
            }
        }
        if (startSpan != null) {
            startSpan.b();
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Can't wrap try/catch for region: R(10:1|(2:3|(7:5|6|7|(1:(1:(3:11|12|(3:(1:23)|24|25)(4:16|(1:18)|19|20))(2:26|27))(3:28|29|30))(2:32|(4:34|(1:36)|29|30)(4:37|(1:39)(1:44)|40|(1:42)(6:43|12|(1:14)|(0)|24|25)))|45|46|47))|48|6|7|(0)(0)|45|46|47|(1:(0))) */
    /* JADX WARN: Removed duplicated region for block: B:23:0x015b  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x0056  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0031  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final /* synthetic */ Object e0(com.tencent.zplan.zplantracing.c cVar, FilamentUrlTemplate filamentUrlTemplate, Continuation<? super Unit> continuation) {
        ZPlanAvatarResourceHelper$fetchTexturePacker$1 zPlanAvatarResourceHelper$fetchTexturePacker$1;
        Object coroutine_suspended;
        int i3;
        String replace$default;
        com.tencent.zplan.zplantracing.c cVar2;
        String str;
        com.tencent.zplan.zplantracing.b bVar;
        File file;
        if (continuation instanceof ZPlanAvatarResourceHelper$fetchTexturePacker$1) {
            zPlanAvatarResourceHelper$fetchTexturePacker$1 = (ZPlanAvatarResourceHelper$fetchTexturePacker$1) continuation;
            int i16 = zPlanAvatarResourceHelper$fetchTexturePacker$1.label;
            if ((i16 & Integer.MIN_VALUE) != 0) {
                zPlanAvatarResourceHelper$fetchTexturePacker$1.label = i16 - Integer.MIN_VALUE;
                ZPlanAvatarResourceHelper$fetchTexturePacker$1 zPlanAvatarResourceHelper$fetchTexturePacker$12 = zPlanAvatarResourceHelper$fetchTexturePacker$1;
                Object obj = zPlanAvatarResourceHelper$fetchTexturePacker$12.result;
                coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i3 = zPlanAvatarResourceHelper$fetchTexturePacker$12.label;
                String str2 = "texture_packer.json";
                if (i3 == 0) {
                    if (i3 != 1) {
                        if (i3 == 2) {
                            str = (String) zPlanAvatarResourceHelper$fetchTexturePacker$12.L$2;
                            str2 = (String) zPlanAvatarResourceHelper$fetchTexturePacker$12.L$1;
                            bVar = (com.tencent.zplan.zplantracing.b) zPlanAvatarResourceHelper$fetchTexturePacker$12.L$0;
                            ResultKt.throwOnFailure(obj);
                            String pathAppend = FilamentFileUtil.INSTANCE.pathAppend(((Resource) obj).e(), str2);
                            file = new File(pathAppend);
                            if (!file.exists() && file.length() == 0) {
                                FLog.INSTANCE.e("FilamentNativeApp[ZPlanAvatarResourceHelper]V2", "fetchTexturePacker fail. file is empty. filePath:" + pathAppend + ", url:" + str);
                                if (bVar != null) {
                                    bVar.a("file is empty. filePath:" + pathAppend + ", url:" + str);
                                }
                                throw new FetchFileException(FetchFileException.Type.FILE_IS_EMPTY, 201022, "file is empty. filePath:" + pathAppend, str);
                            }
                            if (bVar != null) {
                                bVar.b();
                            }
                            return Unit.INSTANCE;
                        }
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.throwOnFailure(obj);
                    return Unit.INSTANCE;
                }
                ResultKt.throwOnFailure(obj);
                if (enableCppDownload) {
                    ZPlanAvatarService zPlanAvatarService = avatarService;
                    zPlanAvatarResourceHelper$fetchTexturePacker$12.label = 1;
                    if (zPlanAvatarService.t("texture_packer", ark.ARKMETADATA_JSON, zPlanAvatarResourceHelper$fetchTexturePacker$12) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    return Unit.INSTANCE;
                }
                com.tencent.zplan.zplantracing.b startSpan = ZPlanSpanFactory.INSTANCE.startSpan("fetchTexturePacker", cVar);
                replace$default = StringsKt__StringsJVMKt.replace$default(filamentUrlTemplate.getMaterialSplitUrl(), "{file_name}", com.tencent.filament.zplanservice.util.c.c("texture_packer.json"), false, 4, (Object) null);
                if (startSpan != null) {
                    cVar2 = startSpan.c();
                } else {
                    cVar2 = null;
                }
                zPlanAvatarResourceHelper$fetchTexturePacker$12.L$0 = startSpan;
                zPlanAvatarResourceHelper$fetchTexturePacker$12.L$1 = "texture_packer.json";
                zPlanAvatarResourceHelper$fetchTexturePacker$12.L$2 = replace$default;
                zPlanAvatarResourceHelper$fetchTexturePacker$12.label = 2;
                Object h06 = h0(this, cVar2, replace$default, filamentUrlTemplate, false, zPlanAvatarResourceHelper$fetchTexturePacker$12, 8, null);
                if (h06 == coroutine_suspended) {
                    return coroutine_suspended;
                }
                str = replace$default;
                bVar = startSpan;
                obj = h06;
                String pathAppend2 = FilamentFileUtil.INSTANCE.pathAppend(((Resource) obj).e(), str2);
                file = new File(pathAppend2);
                if (!file.exists()) {
                }
                if (bVar != null) {
                }
                return Unit.INSTANCE;
                FLog.INSTANCE.e("FilamentNativeApp[ZPlanAvatarResourceHelper]V2", "fetchTexturePacker fail. deprecatedFetchShaderDirFile fail.");
                throw new FetchFileException(FetchFileException.Type.FILE_IS_EMPTY, e.getError().getErrorCode().getValue(), String.valueOf(e.getError().getErrorMsg()), "texture_packer.json");
            }
        }
        zPlanAvatarResourceHelper$fetchTexturePacker$1 = new ZPlanAvatarResourceHelper$fetchTexturePacker$1(this, continuation);
        ZPlanAvatarResourceHelper$fetchTexturePacker$1 zPlanAvatarResourceHelper$fetchTexturePacker$122 = zPlanAvatarResourceHelper$fetchTexturePacker$1;
        Object obj2 = zPlanAvatarResourceHelper$fetchTexturePacker$122.result;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i3 = zPlanAvatarResourceHelper$fetchTexturePacker$122.label;
        String str22 = "texture_packer.json";
        if (i3 == 0) {
        }
        FLog.INSTANCE.e("FilamentNativeApp[ZPlanAvatarResourceHelper]V2", "fetchTexturePacker fail. deprecatedFetchShaderDirFile fail.");
        throw new FetchFileException(FetchFileException.Type.FILE_IS_EMPTY, e.getError().getErrorCode().getValue(), String.valueOf(e.getError().getErrorMsg()), "texture_packer.json");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ Object f0(com.tencent.zplan.zplantracing.c cVar, JSONObject jSONObject, FilamentUrlTemplate filamentUrlTemplate, Continuation<? super Pair<? extends Map<String, ZPlanUgcFAsset>, Boolean>> continuation) {
        return CoroutineScopeKt.coroutineScope(new ZPlanAvatarResourceHelper$fetchUgcResDataWithAvatar$2(cVar, jSONObject, filamentUrlTemplate, null), continuation);
    }

    @Nullable
    public final Object g0(@Nullable final com.tencent.zplan.zplantracing.c cVar, @NotNull final String str, @NotNull final FilamentUrlTemplate filamentUrlTemplate, final boolean z16, @NotNull Continuation<? super Resource> continuation) {
        Continuation intercepted;
        boolean z17;
        Object coroutine_suspended;
        if (!enableCppDownload) {
            intercepted = IntrinsicsKt__IntrinsicsJvmKt.intercepted(continuation);
            SafeContinuation safeContinuation = new SafeContinuation(intercepted);
            final String N0 = f105660o.N0(str, filamentUrlTemplate);
            if (N0 == null) {
                FLog.INSTANCE.e("FilamentNativeApp[ZPlanAvatarResourceHelper]", "fetchZipFileWithUrl fail. unzipDirPath is null. url: " + str);
                FetchFileException fetchFileException = new FetchFileException(FetchFileException.Type.UNZIP_FAIL, 301005, "unzipDirPath is null", str);
                Result.Companion companion = Result.INSTANCE;
                safeContinuation.resumeWith(Result.m476constructorimpl(ResultKt.createFailure(fetchFileException)));
            } else if (FAssetChecker.f105632b.d(N0, str, filamentUrlTemplate)) {
                safeContinuation.resumeWith(Result.m476constructorimpl(new Resource(N0, false, false, 6, null)));
            } else {
                ReentrantLock reentrantLock = taskMapLock;
                reentrantLock.lock();
                try {
                    Map<String, List<Continuation<Resource>>> map = taskMap;
                    if (map.containsKey(str)) {
                        List<Continuation<Resource>> list = map.get(str);
                        if (list != null) {
                            Boxing.boxBoolean(list.add(safeContinuation));
                        }
                        z17 = true;
                    } else {
                        ArrayList arrayList = new ArrayList();
                        arrayList.add(safeContinuation);
                        map.put(str, arrayList);
                        z17 = false;
                    }
                    Unit unit = Unit.INSTANCE;
                    if (!z17) {
                        final com.tencent.zplan.zplantracing.b startSpan = ZPlanSpanFactory.INSTANCE.startSpan("download", cVar);
                        if (startSpan != null) {
                            startSpan.e("url", str);
                        }
                        downloader.e(str, new gl0.a() { // from class: com.tencent.filament.zplan.avatar.ZPlanAvatarResourceHelper$fetchZipFileWithUrl$$inlined$suspendCoroutine$lambda$1
                            @Override // gl0.a
                            public void a(@Nullable final String filePath, final int statusCode, @Nullable Map<String, ? extends List<String>> rspHeader) {
                                j jVar;
                                com.tencent.zplan.zplantracing.b bVar = com.tencent.zplan.zplantracing.b.this;
                                if (bVar != null) {
                                    bVar.b();
                                }
                                ZPlanAvatarResourceHelper zPlanAvatarResourceHelper = ZPlanAvatarResourceHelper.f105660o;
                                jVar = ZPlanAvatarResourceHelper.threadPoolProxy;
                                if (jVar != null) {
                                    j.a.a(jVar, new Runnable() { // from class: com.tencent.filament.zplan.avatar.ZPlanAvatarResourceHelper$fetchZipFileWithUrl$$inlined$suspendCoroutine$lambda$1.2
                                        @Override // java.lang.Runnable
                                        public final void run() {
                                            ZPlanAvatarResourceHelper zPlanAvatarResourceHelper2 = ZPlanAvatarResourceHelper.f105660o;
                                            ZPlanAvatarResourceHelper$fetchZipFileWithUrl$$inlined$suspendCoroutine$lambda$1 zPlanAvatarResourceHelper$fetchZipFileWithUrl$$inlined$suspendCoroutine$lambda$1 = ZPlanAvatarResourceHelper$fetchZipFileWithUrl$$inlined$suspendCoroutine$lambda$1.this;
                                            zPlanAvatarResourceHelper2.E0(cVar, str, N0, z16, filePath, statusCode, filamentUrlTemplate);
                                        }
                                    }, 0L, 2, null);
                                }
                            }

                            @Override // gl0.a
                            public void b(@NotNull final String errorMsg) {
                                j jVar;
                                Intrinsics.checkNotNullParameter(errorMsg, "errorMsg");
                                FLog.INSTANCE.e("FilamentNativeApp[ZPlanAvatarResourceHelper]", "download fail. errorMsg: " + errorMsg + ", url: " + str);
                                com.tencent.zplan.zplantracing.b bVar = com.tencent.zplan.zplantracing.b.this;
                                if (bVar != null) {
                                    bVar.a(errorMsg);
                                }
                                ZPlanAvatarResourceHelper zPlanAvatarResourceHelper = ZPlanAvatarResourceHelper.f105660o;
                                jVar = ZPlanAvatarResourceHelper.threadPoolProxy;
                                if (jVar != null) {
                                    j.a.a(jVar, new Runnable() { // from class: com.tencent.filament.zplan.avatar.ZPlanAvatarResourceHelper$fetchZipFileWithUrl$$inlined$suspendCoroutine$lambda$1.1
                                        @Override // java.lang.Runnable
                                        public final void run() {
                                            ZPlanAvatarResourceHelper.f105660o.B0(str, 301001, errorMsg);
                                        }
                                    }, 0L, 2, null);
                                }
                            }
                        });
                    }
                } finally {
                    reentrantLock.unlock();
                }
            }
            Object orThrow = safeContinuation.getOrThrow();
            coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (orThrow == coroutine_suspended) {
                DebugProbes.probeCoroutineSuspended(continuation);
            }
            return orThrow;
        }
        return i0(cVar, str, filamentUrlTemplate, z16, continuation);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0037  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0023  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final /* synthetic */ Object i0(com.tencent.zplan.zplantracing.c cVar, String str, FilamentUrlTemplate filamentUrlTemplate, boolean z16, Continuation<? super Resource> continuation) {
        ZPlanAvatarResourceHelper$fetchZipFileWithUrlCpp$1 zPlanAvatarResourceHelper$fetchZipFileWithUrlCpp$1;
        Object coroutine_suspended;
        int i3;
        try {
            if (continuation instanceof ZPlanAvatarResourceHelper$fetchZipFileWithUrlCpp$1) {
                zPlanAvatarResourceHelper$fetchZipFileWithUrlCpp$1 = (ZPlanAvatarResourceHelper$fetchZipFileWithUrlCpp$1) continuation;
                int i16 = zPlanAvatarResourceHelper$fetchZipFileWithUrlCpp$1.label;
                if ((i16 & Integer.MIN_VALUE) != 0) {
                    zPlanAvatarResourceHelper$fetchZipFileWithUrlCpp$1.label = i16 - Integer.MIN_VALUE;
                    Object obj = zPlanAvatarResourceHelper$fetchZipFileWithUrlCpp$1.result;
                    coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    i3 = zPlanAvatarResourceHelper$fetchZipFileWithUrlCpp$1.label;
                    if (i3 == 0) {
                        if (i3 == 1) {
                            str = (String) zPlanAvatarResourceHelper$fetchZipFileWithUrlCpp$1.L$0;
                            ResultKt.throwOnFailure(obj);
                        } else {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                    } else {
                        ResultKt.throwOnFailure(obj);
                        ZPlanAvatarService zPlanAvatarService = avatarService;
                        zPlanAvatarResourceHelper$fetchZipFileWithUrlCpp$1.L$0 = str;
                        zPlanAvatarResourceHelper$fetchZipFileWithUrlCpp$1.label = 1;
                        obj = zPlanAvatarService.s(str, zPlanAvatarResourceHelper$fetchZipFileWithUrlCpp$1);
                        if (obj == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                    }
                    ZPlanAvatarInterfaceResult zPlanAvatarInterfaceResult = (ZPlanAvatarInterfaceResult) obj;
                    return new Resource(zPlanAvatarInterfaceResult.getResult(), zPlanAvatarInterfaceResult.isDownload(), false, 4, null);
                }
            }
            if (i3 == 0) {
            }
            ZPlanAvatarInterfaceResult zPlanAvatarInterfaceResult2 = (ZPlanAvatarInterfaceResult) obj;
            return new Resource(zPlanAvatarInterfaceResult2.getResult(), zPlanAvatarInterfaceResult2.isDownload(), false, 4, null);
        } catch (ZPlanAvatarServiceException e16) {
            FLog.INSTANCE.i("FilamentNativeApp[ZPlanAvatarResourceHelper]V2", "fetchZipFileWithUrlCpp fail. url:" + str + " error:" + e16.toString());
            throw new FetchFileException(FetchFileException.Type.DOWNLOAD_FAIL, e16.getError().getErrorCode().getValue(), e16.getError().getErrorMsg(), str);
        }
        zPlanAvatarResourceHelper$fetchZipFileWithUrlCpp$1 = new ZPlanAvatarResourceHelper$fetchZipFileWithUrlCpp$1(this, continuation);
        Object obj2 = zPlanAvatarResourceHelper$fetchZipFileWithUrlCpp$1.result;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i3 = zPlanAvatarResourceHelper$fetchZipFileWithUrlCpp$1.label;
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x017d  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x017e  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x0156 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:31:0x0157  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0145 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:38:0x0146  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x007e  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0031  */
    @Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object k0(@Nullable String str, @NotNull FilamentUrlTemplate filamentUrlTemplate, @NotNull Continuation<? super Backdrop> continuation) {
        ZPlanAvatarResourceHelper$getBackdrop$1 zPlanAvatarResourceHelper$getBackdrop$1;
        Object coroutine_suspended;
        int i3;
        JSONObject jSONObject;
        String optString;
        String substringAfterLast$default;
        String substringBeforeLast$default;
        String replace$default;
        Deferred async$default;
        Deferred async$default2;
        Object await;
        ZPlanAvatarResourceHelper zPlanAvatarResourceHelper;
        String e16;
        Deferred deferred;
        String str2;
        Object await2;
        String str3;
        JSONObject jSONObject2;
        FilamentUrlTemplate filamentUrlTemplate2 = filamentUrlTemplate;
        try {
            if (continuation instanceof ZPlanAvatarResourceHelper$getBackdrop$1) {
                zPlanAvatarResourceHelper$getBackdrop$1 = (ZPlanAvatarResourceHelper$getBackdrop$1) continuation;
                int i16 = zPlanAvatarResourceHelper$getBackdrop$1.label;
                if ((i16 & Integer.MIN_VALUE) != 0) {
                    zPlanAvatarResourceHelper$getBackdrop$1.label = i16 - Integer.MIN_VALUE;
                    Object obj = zPlanAvatarResourceHelper$getBackdrop$1.result;
                    coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    i3 = zPlanAvatarResourceHelper$getBackdrop$1.label;
                    boolean z16 = true;
                    if (i3 == 0) {
                        if (i3 != 1) {
                            if (i3 != 2) {
                                if (i3 == 3) {
                                    String str4 = (String) zPlanAvatarResourceHelper$getBackdrop$1.L$1;
                                    jSONObject2 = (JSONObject) zPlanAvatarResourceHelper$getBackdrop$1.L$0;
                                    ResultKt.throwOnFailure(obj);
                                    str3 = str4;
                                    String e17 = ((Resource) obj).e();
                                    int i17 = jSONObject2.getInt("isDark");
                                    if (jSONObject2.getBoolean("hideGroups")) {
                                        z16 = false;
                                    }
                                    return new Backdrop(str3, e17, i17, z16, null, null, 48, null);
                                }
                                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                            }
                            str2 = (String) zPlanAvatarResourceHelper$getBackdrop$1.L$2;
                            deferred = (Deferred) zPlanAvatarResourceHelper$getBackdrop$1.L$1;
                            JSONObject jSONObject3 = (JSONObject) zPlanAvatarResourceHelper$getBackdrop$1.L$0;
                            ResultKt.throwOnFailure(obj);
                            jSONObject = jSONObject3;
                            zPlanAvatarResourceHelper$getBackdrop$1.L$0 = jSONObject;
                            zPlanAvatarResourceHelper$getBackdrop$1.L$1 = str2;
                            zPlanAvatarResourceHelper$getBackdrop$1.L$2 = null;
                            zPlanAvatarResourceHelper$getBackdrop$1.label = 3;
                            await2 = deferred.await(zPlanAvatarResourceHelper$getBackdrop$1);
                            if (await2 != coroutine_suspended) {
                                return coroutine_suspended;
                            }
                            str3 = str2;
                            JSONObject jSONObject4 = jSONObject;
                            obj = await2;
                            jSONObject2 = jSONObject4;
                            String e172 = ((Resource) obj).e();
                            int i172 = jSONObject2.getInt("isDark");
                            if (jSONObject2.getBoolean("hideGroups")) {
                            }
                            return new Backdrop(str3, e172, i172, z16, null, null, 48, null);
                        }
                        async$default2 = (Deferred) zPlanAvatarResourceHelper$getBackdrop$1.L$3;
                        JSONObject jSONObject5 = (JSONObject) zPlanAvatarResourceHelper$getBackdrop$1.L$2;
                        FilamentUrlTemplate filamentUrlTemplate3 = (FilamentUrlTemplate) zPlanAvatarResourceHelper$getBackdrop$1.L$1;
                        zPlanAvatarResourceHelper = (ZPlanAvatarResourceHelper) zPlanAvatarResourceHelper$getBackdrop$1.L$0;
                        ResultKt.throwOnFailure(obj);
                        jSONObject = jSONObject5;
                        filamentUrlTemplate2 = filamentUrlTemplate3;
                        await = obj;
                    } else {
                        ResultKt.throwOnFailure(obj);
                        if (str != null && (optString = (jSONObject = new JSONObject(str)).optString("path")) != null) {
                            substringAfterLast$default = StringsKt__StringsKt.substringAfterLast$default(optString, "Game/", (String) null, 2, (Object) null);
                            substringBeforeLast$default = StringsKt__StringsKt.substringBeforeLast$default(substringAfterLast$default, '/', (String) null, 2, (Object) null);
                            String c16 = com.tencent.filament.zplanservice.util.c.c(optString);
                            replace$default = StringsKt__StringsJVMKt.replace$default(filamentUrlTemplate.getBackgroundPlaneTextures(), "{texture_path}", substringBeforeLast$default + '/' + c16 + '/' + c16, false, 4, (Object) null);
                            String backgroundPlane = filamentUrlTemplate.getBackgroundPlane();
                            FLog.INSTANCE.i("FilamentNativeApp[ZPlanAvatarResourceHelper]", "getBackdrop imageUrl=" + replace$default + " gltfUrl=" + backgroundPlane);
                            CoroutineScope CoroutineScope = CoroutineScopeKt.CoroutineScope(Dispatchers.getIO());
                            async$default = BuildersKt__Builders_commonKt.async$default(CoroutineScope, null, null, new ZPlanAvatarResourceHelper$getBackdrop$fetchGltfJob$1(backgroundPlane, filamentUrlTemplate2, null), 3, null);
                            async$default2 = BuildersKt__Builders_commonKt.async$default(CoroutineScope, null, null, new ZPlanAvatarResourceHelper$getBackdrop$imagePath$1(replace$default, filamentUrlTemplate2, null), 3, null);
                            zPlanAvatarResourceHelper$getBackdrop$1.L$0 = this;
                            zPlanAvatarResourceHelper$getBackdrop$1.L$1 = filamentUrlTemplate2;
                            zPlanAvatarResourceHelper$getBackdrop$1.L$2 = jSONObject;
                            zPlanAvatarResourceHelper$getBackdrop$1.L$3 = async$default2;
                            zPlanAvatarResourceHelper$getBackdrop$1.label = 1;
                            await = async$default.await(zPlanAvatarResourceHelper$getBackdrop$1);
                            if (await == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                            zPlanAvatarResourceHelper = this;
                        } else {
                            return null;
                        }
                    }
                    e16 = ((Resource) await).e();
                    zPlanAvatarResourceHelper$getBackdrop$1.L$0 = jSONObject;
                    zPlanAvatarResourceHelper$getBackdrop$1.L$1 = async$default2;
                    zPlanAvatarResourceHelper$getBackdrop$1.L$2 = e16;
                    zPlanAvatarResourceHelper$getBackdrop$1.L$3 = null;
                    zPlanAvatarResourceHelper$getBackdrop$1.label = 2;
                    if (zPlanAvatarResourceHelper.c0(null, e16, filamentUrlTemplate2, zPlanAvatarResourceHelper$getBackdrop$1) != coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    deferred = async$default2;
                    str2 = e16;
                    zPlanAvatarResourceHelper$getBackdrop$1.L$0 = jSONObject;
                    zPlanAvatarResourceHelper$getBackdrop$1.L$1 = str2;
                    zPlanAvatarResourceHelper$getBackdrop$1.L$2 = null;
                    zPlanAvatarResourceHelper$getBackdrop$1.label = 3;
                    await2 = deferred.await(zPlanAvatarResourceHelper$getBackdrop$1);
                    if (await2 != coroutine_suspended) {
                    }
                }
            }
            if (i3 == 0) {
            }
            e16 = ((Resource) await).e();
            zPlanAvatarResourceHelper$getBackdrop$1.L$0 = jSONObject;
            zPlanAvatarResourceHelper$getBackdrop$1.L$1 = async$default2;
            zPlanAvatarResourceHelper$getBackdrop$1.L$2 = e16;
            zPlanAvatarResourceHelper$getBackdrop$1.L$3 = null;
            zPlanAvatarResourceHelper$getBackdrop$1.label = 2;
            if (zPlanAvatarResourceHelper.c0(null, e16, filamentUrlTemplate2, zPlanAvatarResourceHelper$getBackdrop$1) != coroutine_suspended) {
            }
        } catch (Throwable th5) {
            FLog.INSTANCE.e("FilamentNativeApp[ZPlanAvatarResourceHelper]", "parse json failed: ", th5);
        }
        zPlanAvatarResourceHelper$getBackdrop$1 = new ZPlanAvatarResourceHelper$getBackdrop$1(this, continuation);
        Object obj2 = zPlanAvatarResourceHelper$getBackdrop$1.result;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i3 = zPlanAvatarResourceHelper$getBackdrop$1.label;
        boolean z162 = true;
        return null;
    }

    /* JADX WARN: Code restructure failed: missing block: B:19:0x0064, code lost:
    
        r1 = kotlin.text.StringsKt__StringsKt.split$default((java.lang.CharSequence) r2, new java.lang.String[]{"/"}, false, 0, 6, (java.lang.Object) null);
     */
    @Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final String l0(@NotNull JSONObject avatarInfo) {
        JSONArray jSONArray;
        String str;
        List split$default;
        Object last;
        Intrinsics.checkNotNullParameter(avatarInfo, "avatarInfo");
        JSONObject optJSONObject = avatarInfo.optJSONObject("makeup_info");
        if (optJSONObject != null) {
            jSONArray = optJSONObject.optJSONArray("slot_arr");
        } else {
            jSONArray = null;
        }
        if (jSONArray == null) {
            FLog.INSTANCE.e("FilamentNativeApp[ZPlanAvatarResourceHelper]", "getBodyTypeName, makeUpSlotArray empty");
            return null;
        }
        ArrayList<JSONObject> arrayList = new ArrayList();
        u(arrayList, jSONArray);
        while (true) {
            String str2 = null;
            for (JSONObject jSONObject : arrayList) {
                if (f105660o.r0(jSONObject.optLong(MiniAppReportManager2.KEY_SLOT_ID))) {
                    JSONObject optJSONObject2 = jSONObject.optJSONObject("item_data");
                    if (optJSONObject2 != null) {
                        str = optJSONObject2.optString("model");
                    } else {
                        str = null;
                    }
                    if (str != null && split$default != null) {
                        last = CollectionsKt___CollectionsKt.last((List<? extends Object>) split$default);
                        str2 = (String) last;
                    }
                }
            }
            return str2;
        }
    }

    @NotNull
    public final JSONObject n(@NotNull BootResourceModel bootResource, @NotNull ReloadAvatarResourceModel avatarResource) {
        Intrinsics.checkNotNullParameter(bootResource, "bootResource");
        Intrinsics.checkNotNullParameter(avatarResource, "avatarResource");
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("shaderDir", bootResource.getShaderDir());
        jSONObject.put("indirectLightPath", bootResource.getIndirectLightPath());
        jSONObject.put("pinchFaceConfigPath", avatarResource.getPinchFaceConfigPath());
        jSONObject.put("kawaiiPath", bootResource.getKawaiiPath());
        jSONObject.put("aiBodyRefPath", avatarResource.getAiBodyRefPath());
        jSONObject.put("lutTexturePath", bootResource.getLutTexturePath());
        return jSONObject;
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:0x0078, code lost:
    
        if (s0(r12.longValue()) != false) goto L13;
     */
    @NotNull
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final JSONObject o(@NotNull ReloadAvatarResourceModel avatarResource, @NotNull JSONObject avatarInfo, boolean needApplyShoesHeight, boolean showOnlyHead, boolean disableGlassesMetallic, @Nullable com.tencent.zplan.zplantracing.c zplanSpanContext) {
        double d16;
        Iterator<Map.Entry<String, ZPlanFAsset>> it;
        boolean z16;
        Long longOrNull;
        Intrinsics.checkNotNullParameter(avatarResource, "avatarResource");
        Intrinsics.checkNotNullParameter(avatarInfo, "avatarInfo");
        com.tencent.zplan.zplantracing.b startSpan = ZPlanSpanFactory.INSTANCE.startSpan("updateAvatarAssetsAndReloadAvatar", zplanSpanContext);
        final LinkedHashMap linkedHashMap = new LinkedHashMap();
        final ArrayList arrayList = new ArrayList();
        final LinkedHashMap linkedHashMap2 = new LinkedHashMap();
        Function2<String, String, Unit> function2 = new Function2<String, String, Unit>() { // from class: com.tencent.filament.zplan.avatar.ZPlanAvatarResourceHelper$buildAvatarInfo$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(String str, String str2) {
                invoke2(str, str2);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@NotNull String slot, @Nullable String str) {
                Intrinsics.checkNotNullParameter(slot, "slot");
                FLog.INSTANCE.i(AbsBusinessScene.TAG, "updateResource slot: " + slot + ", gltf: " + str);
                linkedHashMap.put(slot, str);
            }
        };
        Function3<String, String, String, Unit> function3 = new Function3<String, String, String, Unit>() { // from class: com.tencent.filament.zplan.avatar.ZPlanAvatarResourceHelper$buildAvatarInfo$2
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(3);
            }

            @Override // kotlin.jvm.functions.Function3
            public /* bridge */ /* synthetic */ Unit invoke(String str, String str2, String str3) {
                invoke2(str, str2, str3);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@NotNull String slot, @NotNull String pngPath, @NotNull String jsonPath) {
                Intrinsics.checkNotNullParameter(slot, "slot");
                Intrinsics.checkNotNullParameter(pngPath, "pngPath");
                Intrinsics.checkNotNullParameter(jsonPath, "jsonPath");
                linkedHashMap2.put(slot, new MakeUpConfig(pngPath, jsonPath));
                arrayList.add(slot);
            }
        };
        ArrayList arrayList2 = new ArrayList();
        Iterator<Map.Entry<String, ZPlanFAsset>> it5 = avatarResource.u().entrySet().iterator();
        while (it5.hasNext()) {
            Map.Entry<String, ZPlanFAsset> next = it5.next();
            String key = next.getKey();
            ZPlanFAsset value = next.getValue();
            if (showOnlyHead) {
                longOrNull = StringsKt__StringNumberConversionsKt.toLongOrNull(key);
                if (!Intrinsics.areEqual(key, "Feet")) {
                    if (longOrNull != null) {
                    }
                }
                it = it5;
                it5 = it;
            }
            if (value instanceof ZPlanCommonGltfFAsset) {
                function2.invoke2(key, ((ZPlanCommonGltfFAsset) value).getGltfFilePath());
                if (value instanceof ZPlanDressUpFAsset) {
                    arrayList2.add(Long.valueOf(((ZPlanDressUpFAsset) value).getAssetInfo().getItemId()));
                }
            } else if (value instanceof ZPlanMakeUpFAsset) {
                FilamentFileUtil filamentFileUtil = FilamentFileUtil.INSTANCE;
                ZPlanMakeUpFAsset zPlanMakeUpFAsset = (ZPlanMakeUpFAsset) value;
                String filePathInDir$default = FilamentFileUtil.filePathInDir$default(filamentFileUtil, zPlanMakeUpFAsset.getDirPath(), null, "ktx2", 2, null);
                it = it5;
                String filePathInDir$default2 = FilamentFileUtil.filePathInDir$default(filamentFileUtil, zPlanMakeUpFAsset.getDirPath(), null, "png", 2, null);
                String filePathInDir$default3 = FilamentFileUtil.filePathInDir$default(filamentFileUtil, zPlanMakeUpFAsset.getDirPath(), null, ark.ARKMETADATA_JSON, 2, null);
                boolean z17 = false;
                if (filePathInDir$default != null && filePathInDir$default.length() != 0) {
                    z16 = false;
                } else {
                    z16 = true;
                }
                if (!z16) {
                    if (filePathInDir$default3 == null) {
                        filePathInDir$default3 = "";
                    }
                    function3.invoke2(key, filePathInDir$default, filePathInDir$default3);
                } else {
                    if (filePathInDir$default2 == null || filePathInDir$default2.length() == 0) {
                        z17 = true;
                    }
                    if (!z17) {
                        if (filePathInDir$default3 == null) {
                            filePathInDir$default3 = "";
                        }
                        function3.invoke2(key, filePathInDir$default2, filePathInDir$default3);
                    } else {
                        FLog.INSTANCE.e(AbsBusinessScene.TAG, "cannot find ktx2/png/json file in dir: " + zPlanMakeUpFAsset.getDirPath());
                    }
                }
                arrayList2.add(Long.valueOf(zPlanMakeUpFAsset.getAssetInfo().getItemId()));
                it5 = it;
            }
            it = it5;
            it5 = it;
        }
        ZPlanCommonGltfFAsset eyelashGltfFAsset = avatarResource.getEyelashGltfFAsset();
        if (eyelashGltfFAsset != null) {
            function2.invoke2(eyelashGltfFAsset.getAssetInfo().getSlot(), eyelashGltfFAsset.getGltfFilePath());
        }
        com.tencent.filament.zplan.avatar.model.a w06 = w0(avatarInfo.optJSONObject("color_info"));
        if (w06 == null) {
            w06 = new com.tencent.filament.zplan.avatar.model.a();
        }
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("pantsLength", avatarResource.getPantsLength());
        if (needApplyShoesHeight) {
            d16 = avatarResource.getShoeHeight();
        } else {
            d16 = 0.0d;
        }
        jSONObject.put("shoesHeight", d16);
        jSONObject.put("pinchFace", x0(avatarResource, arrayList2));
        jSONObject.put("bodyTypeConfigPath", avatarResource.getBodyTypePath());
        jSONObject.put("ugcResMap", A0(avatarResource));
        jSONObject.put("disableGlassesMetallic", disableGlassesMetallic);
        jSONObject.put("chunkLoadAvatar", FilamentFeatureUtil.f106409g.a());
        JSONObject q16 = q(linkedHashMap, linkedHashMap2, w06, jSONObject);
        if (startSpan != null) {
            startSpan.b();
        }
        return q16;
    }

    @NotNull
    public final String p0(long slotId, long itemId, @NotNull FilamentUrlTemplate urlTemplate) {
        String replace$default;
        String replace$default2;
        Intrinsics.checkNotNullParameter(urlTemplate, "urlTemplate");
        if (t0(slotId)) {
            replace$default2 = StringsKt__StringsJVMKt.replace$default(urlTemplate.getMakeupUrl(), "{res_id}", String.valueOf(itemId), false, 4, (Object) null);
            return replace$default2;
        }
        replace$default = StringsKt__StringsJVMKt.replace$default(urlTemplate.getDressupUrl(), "{res_id}", String.valueOf(itemId), false, 4, (Object) null);
        return replace$default;
    }

    public final void q0(@NotNull ETagInfo eTagInfo) {
        Intrinsics.checkNotNullParameter(eTagInfo, "eTagInfo");
        BuildersKt__Builders_commonKt.async$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getIO()), null, null, new ZPlanAvatarResourceHelper$handleETagInfoFromChannel$1(eTagInfo, null), 3, null);
    }

    public final void s() {
        FLog fLog = FLog.INSTANCE;
        StringBuilder sb5 = new StringBuilder();
        sb5.append("before clearCache, bootResourceCache=");
        b<BootResourceModel> bVar = bootResourceCache;
        sb5.append(bVar);
        sb5.append(", avatarResourceCache=");
        b<ReloadAvatarResourceModel> bVar2 = avatarResourceCache;
        sb5.append(bVar2);
        fLog.i("FilamentNativeApp[ZPlanAvatarResourceHelper]", sb5.toString());
        bVar.b();
        bVar2.b();
        fLog.i("FilamentNativeApp[ZPlanAvatarResourceHelper]", "after clearCache, bootResourceCache=" + bVar + ", avatarResourceCache=" + bVar2);
    }

    @NotNull
    public final JSONObject t(@NotNull JSONObject avatarPbJson, @NotNull JSONObject faceStruct) {
        JSONArray jSONArray;
        JSONArray jSONArray2;
        JSONArray jSONArray3;
        JSONArray jSONArray4;
        List<JSONArray> mutableListOf;
        JSONArray jSONArray5;
        JSONArray jSONArray6;
        JSONArray jSONArray7;
        JSONArray jSONArray8;
        Intrinsics.checkNotNullParameter(avatarPbJson, "avatarPbJson");
        Intrinsics.checkNotNullParameter(faceStruct, "faceStruct");
        JSONObject b16 = com.tencent.zplan.common.utils.h.f385294a.b(avatarPbJson.toString());
        Intrinsics.checkNotNull(b16);
        JSONObject optJSONObject = b16.optJSONObject("avatar_info");
        JSONArray jSONArray9 = null;
        if (optJSONObject != null) {
            jSONArray = optJSONObject.optJSONArray("slot_arr");
        } else {
            jSONArray = null;
        }
        JSONObject optJSONObject2 = b16.optJSONObject("makeup_info");
        if (optJSONObject2 != null) {
            jSONArray2 = optJSONObject2.optJSONArray("slot_arr");
        } else {
            jSONArray2 = null;
        }
        JSONObject optJSONObject3 = b16.optJSONObject("color_info");
        if (optJSONObject3 != null) {
            jSONArray3 = optJSONObject3.optJSONArray("slot_arr");
        } else {
            jSONArray3 = null;
        }
        JSONObject optJSONObject4 = b16.optJSONObject("face_info");
        if (optJSONObject4 != null) {
            jSONArray4 = optJSONObject4.optJSONArray("slot_arr");
        } else {
            jSONArray4 = null;
        }
        mutableListOf = CollectionsKt__CollectionsKt.mutableListOf(jSONArray, jSONArray2, jSONArray3, jSONArray4);
        for (JSONArray jSONArray10 : mutableListOf) {
            if (jSONArray10 != null) {
                for (int length = jSONArray10.length() - 1; length >= 0; length--) {
                    JSONObject optJSONObject5 = jSONArray10.optJSONObject(length);
                    if (optJSONObject5 != null && f105660o.s0(optJSONObject5.optLong(MiniAppReportManager2.KEY_SLOT_ID))) {
                        jSONArray10.remove(length);
                    }
                }
            }
        }
        ZPlanAvatarResourceHelper$combineAvatarInfoWithFaceStr$2 zPlanAvatarResourceHelper$combineAvatarInfoWithFaceStr$2 = ZPlanAvatarResourceHelper$combineAvatarInfoWithFaceStr$2.INSTANCE;
        JSONObject optJSONObject6 = faceStruct.optJSONObject("ControlPoint");
        if (optJSONObject6 != null) {
            jSONArray5 = optJSONObject6.optJSONArray("FacePoint");
        } else {
            jSONArray5 = null;
        }
        zPlanAvatarResourceHelper$combineAvatarInfoWithFaceStr$2.invoke(jSONArray5, AvatarSlot.cfgpb_AvatarSlot_EN_SLOT_OUTLINE.getValue(), jSONArray4);
        if (optJSONObject6 != null) {
            jSONArray6 = optJSONObject6.optJSONArray("EyesBrowPoint");
        } else {
            jSONArray6 = null;
        }
        zPlanAvatarResourceHelper$combineAvatarInfoWithFaceStr$2.invoke(jSONArray6, AvatarSlot.cfgpb_AvatarSlot_EN_SLOT_EYEBROW.getValue(), jSONArray4);
        if (optJSONObject6 != null) {
            jSONArray7 = optJSONObject6.optJSONArray("EyePoint");
        } else {
            jSONArray7 = null;
        }
        zPlanAvatarResourceHelper$combineAvatarInfoWithFaceStr$2.invoke(jSONArray7, AvatarSlot.cfgpb_AvatarSlot_EN_SLOT_EYE.getValue(), jSONArray4);
        if (optJSONObject6 != null) {
            jSONArray8 = optJSONObject6.optJSONArray("NosePoint");
        } else {
            jSONArray8 = null;
        }
        zPlanAvatarResourceHelper$combineAvatarInfoWithFaceStr$2.invoke(jSONArray8, AvatarSlot.cfgpb_AvatarSlot_EN_SLOT_NOSE.getValue(), jSONArray4);
        if (optJSONObject6 != null) {
            jSONArray9 = optJSONObject6.optJSONArray("MouthPoint");
        }
        zPlanAvatarResourceHelper$combineAvatarInfoWithFaceStr$2.invoke(jSONArray9, AvatarSlot.cfgpb_AvatarSlot_EN_SLOT_LIPS.getValue(), jSONArray4);
        ZPlanAvatarResourceHelper$combineAvatarInfoWithFaceStr$3.INSTANCE.invoke2(faceStruct.optJSONArray("Colors"), jSONArray3);
        ZPlanAvatarResourceHelper$combineAvatarInfoWithFaceStr$4.INSTANCE.invoke2(faceStruct.optJSONArray("Makeup"), jSONArray, jSONArray2);
        return b16;
    }

    public final boolean u0(@NotNull String url, @NotNull FilamentUrlTemplate urlTemplate) {
        boolean startsWith$default;
        Intrinsics.checkNotNullParameter(url, "url");
        Intrinsics.checkNotNullParameter(urlTemplate, "urlTemplate");
        startsWith$default = StringsKt__StringsJVMKt.startsWith$default(url, n0(urlTemplate), false, 2, null);
        return startsWith$default;
    }

    @Nullable
    public final com.tencent.filament.zplan.avatar.model.a w0(@Nullable JSONObject colorInfo) {
        JSONArray optJSONArray;
        long j3;
        JSONObject optJSONObject;
        if (colorInfo == null || (optJSONArray = colorInfo.optJSONArray("slot_arr")) == null) {
            return null;
        }
        int length = optJSONArray.length();
        com.tencent.filament.zplan.avatar.model.a aVar = new com.tencent.filament.zplan.avatar.model.a();
        for (int i3 = 0; i3 < length; i3++) {
            JSONObject optJSONObject2 = optJSONArray.optJSONObject(i3);
            if (optJSONObject2 != null) {
                int optInt = optJSONObject2.optInt("color_type");
                String valueOf = String.valueOf(optJSONObject2.optInt(MiniAppReportManager2.KEY_SLOT_ID));
                if (optInt != 0) {
                    if (optInt != 1) {
                        if (optInt == 2 && (optJSONObject = optJSONObject2.optJSONObject("gradient_type")) != null) {
                            aVar.d(optJSONObject.optDouble("progress"));
                        }
                    } else {
                        JSONObject optJSONObject3 = optJSONObject2.optJSONObject("gradient_type");
                        if (optJSONObject3 != null) {
                            JSONObject optJSONObject4 = optJSONObject3.optJSONObject("from_color");
                            long j16 = 0;
                            if (optJSONObject4 != null) {
                                j3 = optJSONObject4.optLong("custom_color");
                            } else {
                                j3 = 0;
                            }
                            JSONObject optJSONObject5 = optJSONObject3.optJSONObject("to_color");
                            if (optJSONObject5 != null) {
                                j16 = optJSONObject5.optLong("custom_color");
                            }
                            double optDouble = optJSONObject3.optDouble("progress");
                            com.tencent.filament.zplan.util.b bVar = com.tencent.filament.zplan.util.b.f106240a;
                            aVar.c(valueOf, bVar.a(j3), bVar.a(j16), optDouble, ColorType.SRGB);
                        }
                    }
                } else {
                    JSONObject optJSONObject6 = optJSONObject2.optJSONObject("single_color");
                    if (optJSONObject6 != null) {
                        aVar.b(valueOf, com.tencent.filament.zplan.util.b.f106240a.a(optJSONObject6.optLong("custom_color")), ColorType.SRGB);
                    }
                }
            }
        }
        return aVar;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:14:0x00f6  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x010a  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0116  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x00f1 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:34:0x00f2  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x0066  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x002d  */
    /* JADX WARN: Type inference failed for: r15v0, types: [com.tencent.filament.zplan.avatar.model.b, T] */
    /* JADX WARN: Type inference failed for: r1v6, types: [com.tencent.filament.zplan.avatar.model.b, T] */
    @Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object y(@Nullable com.tencent.zplan.zplantracing.c cVar, @NotNull String str, long j3, long j16, @NotNull FilamentUrlTemplate filamentUrlTemplate, @NotNull Continuation<? super Resource> continuation) {
        ZPlanAvatarResourceHelper$fetchAIGCResourceToFolder$1 zPlanAvatarResourceHelper$fetchAIGCResourceToFolder$1;
        Object coroutine_suspended;
        int i3;
        com.tencent.zplan.zplantracing.b bVar;
        Deferred async$default;
        FilamentUrlTemplate filamentUrlTemplate2;
        Ref.ObjectRef objectRef;
        CoroutineScope coroutineScope;
        com.tencent.zplan.zplantracing.b bVar2;
        Ref.ObjectRef objectRef2;
        Deferred async$default2;
        Ref.ObjectRef objectRef3;
        if (continuation instanceof ZPlanAvatarResourceHelper$fetchAIGCResourceToFolder$1) {
            zPlanAvatarResourceHelper$fetchAIGCResourceToFolder$1 = (ZPlanAvatarResourceHelper$fetchAIGCResourceToFolder$1) continuation;
            int i16 = zPlanAvatarResourceHelper$fetchAIGCResourceToFolder$1.label;
            if ((i16 & Integer.MIN_VALUE) != 0) {
                zPlanAvatarResourceHelper$fetchAIGCResourceToFolder$1.label = i16 - Integer.MIN_VALUE;
                Object obj = zPlanAvatarResourceHelper$fetchAIGCResourceToFolder$1.result;
                coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i3 = zPlanAvatarResourceHelper$fetchAIGCResourceToFolder$1.label;
                if (i3 == 0) {
                    if (i3 != 1) {
                        if (i3 == 2) {
                            objectRef3 = (Ref.ObjectRef) zPlanAvatarResourceHelper$fetchAIGCResourceToFolder$1.L$1;
                            bVar = (com.tencent.zplan.zplantracing.b) zPlanAvatarResourceHelper$fetchAIGCResourceToFolder$1.L$0;
                            try {
                                ResultKt.throwOnFailure(obj);
                                if (bVar != null) {
                                    bVar.e("downloadFromNet", String.valueOf(((Resource) objectRef3.element).d()));
                                }
                                if (bVar != null) {
                                    bVar.b();
                                }
                                return (Resource) objectRef3.element;
                            } catch (FetchFileException e16) {
                                e = e16;
                                if (bVar != null) {
                                }
                                throw FetchFileException.copy$default(e, null, 0, "fetch AIGCResource failed \u274c", null, 11, null);
                            }
                        }
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    objectRef = (Ref.ObjectRef) zPlanAvatarResourceHelper$fetchAIGCResourceToFolder$1.L$4;
                    coroutineScope = (CoroutineScope) zPlanAvatarResourceHelper$fetchAIGCResourceToFolder$1.L$3;
                    objectRef2 = (Ref.ObjectRef) zPlanAvatarResourceHelper$fetchAIGCResourceToFolder$1.L$2;
                    bVar2 = (com.tencent.zplan.zplantracing.b) zPlanAvatarResourceHelper$fetchAIGCResourceToFolder$1.L$1;
                    filamentUrlTemplate2 = (FilamentUrlTemplate) zPlanAvatarResourceHelper$fetchAIGCResourceToFolder$1.L$0;
                    try {
                        ResultKt.throwOnFailure(obj);
                    } catch (FetchFileException e17) {
                        e = e17;
                        bVar = bVar2;
                        if (bVar != null) {
                        }
                        throw FetchFileException.copy$default(e, null, 0, "fetch AIGCResource failed \u274c", null, 11, null);
                    }
                } else {
                    ResultKt.throwOnFailure(obj);
                    com.tencent.zplan.zplantracing.b startSpan = ZPlanSpanFactory.INSTANCE.startSpan("fetchAIGCResource", cVar);
                    Ref.ObjectRef objectRef4 = new Ref.ObjectRef();
                    objectRef4.element = new Resource(null, false, false, 7, null);
                    CoroutineScope CoroutineScope = CoroutineScopeKt.CoroutineScope(Dispatchers.getIO());
                    try {
                        async$default = BuildersKt__Builders_commonKt.async$default(CoroutineScope, null, null, new ZPlanAvatarResourceHelper$fetchAIGCResourceToFolder$deferred$1(startSpan, str, filamentUrlTemplate, null), 3, null);
                        zPlanAvatarResourceHelper$fetchAIGCResourceToFolder$1.L$0 = filamentUrlTemplate;
                        zPlanAvatarResourceHelper$fetchAIGCResourceToFolder$1.L$1 = startSpan;
                        zPlanAvatarResourceHelper$fetchAIGCResourceToFolder$1.L$2 = objectRef4;
                        zPlanAvatarResourceHelper$fetchAIGCResourceToFolder$1.L$3 = CoroutineScope;
                        zPlanAvatarResourceHelper$fetchAIGCResourceToFolder$1.L$4 = objectRef4;
                        zPlanAvatarResourceHelper$fetchAIGCResourceToFolder$1.label = 1;
                        Object await = async$default.await(zPlanAvatarResourceHelper$fetchAIGCResourceToFolder$1);
                        if (await == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        filamentUrlTemplate2 = filamentUrlTemplate;
                        objectRef = objectRef4;
                        coroutineScope = CoroutineScope;
                        bVar2 = startSpan;
                        obj = await;
                        objectRef2 = objectRef;
                    } catch (FetchFileException e18) {
                        e = e18;
                        bVar = startSpan;
                        if (bVar != null) {
                            bVar.a(e.getErrorMessage());
                        }
                        throw FetchFileException.copy$default(e, null, 0, "fetch AIGCResource failed \u274c", null, 11, null);
                    }
                }
                objectRef.element = (Resource) obj;
                async$default2 = BuildersKt__Builders_commonKt.async$default(coroutineScope, null, null, new ZPlanAvatarResourceHelper$fetchAIGCResourceToFolder$fetchAIGCShaderJob$1(bVar2, objectRef2, filamentUrlTemplate2, null), 3, null);
                zPlanAvatarResourceHelper$fetchAIGCResourceToFolder$1.L$0 = bVar2;
                zPlanAvatarResourceHelper$fetchAIGCResourceToFolder$1.L$1 = objectRef2;
                zPlanAvatarResourceHelper$fetchAIGCResourceToFolder$1.L$2 = null;
                zPlanAvatarResourceHelper$fetchAIGCResourceToFolder$1.L$3 = null;
                zPlanAvatarResourceHelper$fetchAIGCResourceToFolder$1.L$4 = null;
                zPlanAvatarResourceHelper$fetchAIGCResourceToFolder$1.label = 2;
                if (async$default2.await(zPlanAvatarResourceHelper$fetchAIGCResourceToFolder$1) != coroutine_suspended) {
                    return coroutine_suspended;
                }
                objectRef3 = objectRef2;
                bVar = bVar2;
                if (bVar != null) {
                }
                if (bVar != null) {
                }
                return (Resource) objectRef3.element;
            }
        }
        zPlanAvatarResourceHelper$fetchAIGCResourceToFolder$1 = new ZPlanAvatarResourceHelper$fetchAIGCResourceToFolder$1(this, continuation);
        Object obj2 = zPlanAvatarResourceHelper$fetchAIGCResourceToFolder$1.result;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i3 = zPlanAvatarResourceHelper$fetchAIGCResourceToFolder$1.label;
        if (i3 == 0) {
        }
        objectRef.element = (Resource) obj2;
        async$default2 = BuildersKt__Builders_commonKt.async$default(coroutineScope, null, null, new ZPlanAvatarResourceHelper$fetchAIGCResourceToFolder$fetchAIGCShaderJob$1(bVar2, objectRef2, filamentUrlTemplate2, null), 3, null);
        zPlanAvatarResourceHelper$fetchAIGCResourceToFolder$1.L$0 = bVar2;
        zPlanAvatarResourceHelper$fetchAIGCResourceToFolder$1.L$1 = objectRef2;
        zPlanAvatarResourceHelper$fetchAIGCResourceToFolder$1.L$2 = null;
        zPlanAvatarResourceHelper$fetchAIGCResourceToFolder$1.L$3 = null;
        zPlanAvatarResourceHelper$fetchAIGCResourceToFolder$1.L$4 = null;
        zPlanAvatarResourceHelper$fetchAIGCResourceToFolder$1.label = 2;
        if (async$default2.await(zPlanAvatarResourceHelper$fetchAIGCResourceToFolder$1) != coroutine_suspended) {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ Object y0(JSONObject jSONObject, com.tencent.zplan.zplantracing.c cVar, Continuation<? super List<ZPlanPinchFaceModel>> continuation) {
        JSONArray jSONArray;
        JSONArray optJSONArray;
        com.tencent.zplan.zplantracing.b startSpan = ZPlanSpanFactory.INSTANCE.startSpan("loadPinchFaceData", cVar);
        ArrayList arrayList = new ArrayList();
        JSONObject optJSONObject = jSONObject.optJSONObject("face_info");
        if (optJSONObject != null) {
            jSONArray = optJSONObject.optJSONArray("slot_arr");
        } else {
            jSONArray = null;
        }
        if (jSONArray != null && jSONArray.length() > 0) {
            int length = jSONArray.length();
            for (int i3 = 0; i3 < length; i3++) {
                Object opt = jSONArray.opt(i3);
                if ((opt instanceof JSONObject) && (optJSONArray = ((JSONObject) opt).optJSONArray("control_points")) != null && optJSONArray.length() > 0) {
                    int length2 = optJSONArray.length();
                    for (int i16 = 0; i16 < length2; i16++) {
                        Object obj = optJSONArray.get(i16);
                        if (obj instanceof JSONObject) {
                            JSONObject jSONObject2 = (JSONObject) obj;
                            arrayList.add(new ZPlanPinchFaceModel(jSONObject2.optLong("control_index"), jSONObject2.optDouble("x_per") * 0.01d));
                        }
                    }
                }
            }
            if (startSpan != null) {
                startSpan.b();
            }
            return arrayList;
        }
        if (startSpan != null) {
            startSpan.e("hasSlot", String.valueOf(false));
        }
        if (startSpan != null) {
            startSpan.b();
        }
        return arrayList;
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x011a  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0126  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0133  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0147  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x0106 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:39:0x0107  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x006b  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x002c  */
    @Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object z(@Nullable com.tencent.zplan.zplantracing.c cVar, @NotNull EnumUserGender enumUserGender, int i3, @NotNull FilamentUrlTemplate filamentUrlTemplate, @NotNull Continuation<? super ZPlanAction> continuation) throws FetchFileException, RuntimeException {
        ZPlanAvatarResourceHelper$fetchAction$1 zPlanAvatarResourceHelper$fetchAction$1;
        Object coroutine_suspended;
        int i16;
        Deferred async$default;
        Deferred async$default2;
        com.tencent.zplan.zplantracing.b bVar;
        String str;
        Deferred deferred;
        String str2;
        Object await;
        String str3;
        com.tencent.zplan.zplantracing.b bVar2;
        boolean z16;
        boolean z17;
        if (continuation instanceof ZPlanAvatarResourceHelper$fetchAction$1) {
            zPlanAvatarResourceHelper$fetchAction$1 = (ZPlanAvatarResourceHelper$fetchAction$1) continuation;
            int i17 = zPlanAvatarResourceHelper$fetchAction$1.label;
            if ((i17 & Integer.MIN_VALUE) != 0) {
                zPlanAvatarResourceHelper$fetchAction$1.label = i17 - Integer.MIN_VALUE;
                ZPlanAvatarResourceHelper$fetchAction$1 zPlanAvatarResourceHelper$fetchAction$12 = zPlanAvatarResourceHelper$fetchAction$1;
                Object obj = zPlanAvatarResourceHelper$fetchAction$12.result;
                coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i16 = zPlanAvatarResourceHelper$fetchAction$12.label;
                if (i16 == 0) {
                    if (i16 != 1) {
                        if (i16 != 2) {
                            if (i16 == 3) {
                                z16 = zPlanAvatarResourceHelper$fetchAction$12.Z$0;
                                str3 = (String) zPlanAvatarResourceHelper$fetchAction$12.L$3;
                                str = (String) zPlanAvatarResourceHelper$fetchAction$12.L$2;
                                str2 = (String) zPlanAvatarResourceHelper$fetchAction$12.L$1;
                                bVar2 = (com.tencent.zplan.zplantracing.b) zPlanAvatarResourceHelper$fetchAction$12.L$0;
                                ResultKt.throwOnFailure(obj);
                            } else {
                                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                            }
                        } else {
                            deferred = (Deferred) zPlanAvatarResourceHelper$fetchAction$12.L$3;
                            str = (String) zPlanAvatarResourceHelper$fetchAction$12.L$2;
                            str2 = (String) zPlanAvatarResourceHelper$fetchAction$12.L$1;
                            bVar = (com.tencent.zplan.zplantracing.b) zPlanAvatarResourceHelper$fetchAction$12.L$0;
                            ResultKt.throwOnFailure(obj);
                            Resource resource = (Resource) obj;
                            String path = resource.getPath();
                            boolean downloadFromNet = resource.getDownloadFromNet();
                            zPlanAvatarResourceHelper$fetchAction$12.L$0 = bVar;
                            zPlanAvatarResourceHelper$fetchAction$12.L$1 = str2;
                            zPlanAvatarResourceHelper$fetchAction$12.L$2 = str;
                            zPlanAvatarResourceHelper$fetchAction$12.L$3 = path;
                            zPlanAvatarResourceHelper$fetchAction$12.Z$0 = downloadFromNet;
                            zPlanAvatarResourceHelper$fetchAction$12.label = 3;
                            await = deferred.await(zPlanAvatarResourceHelper$fetchAction$12);
                            if (await != coroutine_suspended) {
                                return coroutine_suspended;
                            }
                            str3 = path;
                            bVar2 = bVar;
                            z16 = downloadFromNet;
                            obj = await;
                        }
                    } else {
                        ResultKt.throwOnFailure(obj);
                        return obj;
                    }
                } else {
                    ResultKt.throwOnFailure(obj);
                    if (enableCppDownload) {
                        zPlanAvatarResourceHelper$fetchAction$12.label = 1;
                        obj = A(cVar, enumUserGender, i3, filamentUrlTemplate, zPlanAvatarResourceHelper$fetchAction$12);
                        if (obj == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        return obj;
                    }
                    com.tencent.zplan.zplantracing.b startSpan = ZPlanSpanFactory.INSTANCE.startSpan("fetchAction", cVar);
                    Pair<String, String> D0 = D0(enumUserGender, i3, filamentUrlTemplate);
                    String component1 = D0.component1();
                    String component2 = D0.component2();
                    CoroutineScope CoroutineScope = CoroutineScopeKt.CoroutineScope(Dispatchers.getIO());
                    async$default = BuildersKt__Builders_commonKt.async$default(CoroutineScope, null, null, new ZPlanAvatarResourceHelper$fetchAction$facePathDeferred$1(startSpan, component1, filamentUrlTemplate, null), 3, null);
                    async$default2 = BuildersKt__Builders_commonKt.async$default(CoroutineScope, null, null, new ZPlanAvatarResourceHelper$fetchAction$bodyPathDeferred$1(startSpan, component2, filamentUrlTemplate, null), 3, null);
                    zPlanAvatarResourceHelper$fetchAction$12.L$0 = startSpan;
                    zPlanAvatarResourceHelper$fetchAction$12.L$1 = component1;
                    zPlanAvatarResourceHelper$fetchAction$12.L$2 = component2;
                    zPlanAvatarResourceHelper$fetchAction$12.L$3 = async$default2;
                    zPlanAvatarResourceHelper$fetchAction$12.label = 2;
                    Object await2 = async$default.await(zPlanAvatarResourceHelper$fetchAction$12);
                    if (await2 == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    bVar = startSpan;
                    obj = await2;
                    str = component2;
                    deferred = async$default2;
                    str2 = component1;
                    Resource resource2 = (Resource) obj;
                    String path2 = resource2.getPath();
                    boolean downloadFromNet2 = resource2.getDownloadFromNet();
                    zPlanAvatarResourceHelper$fetchAction$12.L$0 = bVar;
                    zPlanAvatarResourceHelper$fetchAction$12.L$1 = str2;
                    zPlanAvatarResourceHelper$fetchAction$12.L$2 = str;
                    zPlanAvatarResourceHelper$fetchAction$12.L$3 = path2;
                    zPlanAvatarResourceHelper$fetchAction$12.Z$0 = downloadFromNet2;
                    zPlanAvatarResourceHelper$fetchAction$12.label = 3;
                    await = deferred.await(zPlanAvatarResourceHelper$fetchAction$12);
                    if (await != coroutine_suspended) {
                    }
                }
                Resource resource3 = (Resource) obj;
                String path3 = resource3.getPath();
                boolean downloadFromNet3 = resource3.getDownloadFromNet();
                if (bVar2 != null) {
                    bVar2.e("faceDownload", String.valueOf(z16));
                }
                if (bVar2 != null) {
                    bVar2.e("bodyDownload", String.valueOf(downloadFromNet3));
                }
                boolean z18 = false;
                if (bVar2 != null) {
                    if (!z16 && !downloadFromNet3) {
                        z17 = false;
                    } else {
                        z17 = true;
                    }
                    bVar2.e("downloadFromNet", String.valueOf(z17));
                }
                if (bVar2 != null) {
                    bVar2.b();
                }
                ZPlanAction zPlanAction = new ZPlanAction(str3, path3, str2, str);
                if (!z16 || downloadFromNet3) {
                    z18 = true;
                }
                zPlanAction.f(z18);
                return zPlanAction;
            }
        }
        zPlanAvatarResourceHelper$fetchAction$1 = new ZPlanAvatarResourceHelper$fetchAction$1(this, continuation);
        ZPlanAvatarResourceHelper$fetchAction$1 zPlanAvatarResourceHelper$fetchAction$122 = zPlanAvatarResourceHelper$fetchAction$1;
        Object obj2 = zPlanAvatarResourceHelper$fetchAction$122.result;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i16 = zPlanAvatarResourceHelper$fetchAction$122.label;
        if (i16 == 0) {
        }
        Resource resource32 = (Resource) obj2;
        String path32 = resource32.getPath();
        boolean downloadFromNet32 = resource32.getDownloadFromNet();
        if (bVar2 != null) {
        }
        if (bVar2 != null) {
        }
        boolean z182 = false;
        if (bVar2 != null) {
        }
        if (bVar2 != null) {
        }
        ZPlanAction zPlanAction2 = new ZPlanAction(str3, path32, str2, str);
        if (!z16) {
        }
        z182 = true;
        zPlanAction2.f(z182);
        return zPlanAction2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ Object z0(JSONObject jSONObject, Continuation<? super Map<String, ZPlanUgcFAssetInfo>> continuation) {
        Continuation intercepted;
        JSONArray jSONArray;
        Object coroutine_suspended;
        JSONObject optJSONObject;
        boolean z16;
        String replace$default;
        intercepted = IntrinsicsKt__IntrinsicsJvmKt.intercepted(continuation);
        SafeContinuation safeContinuation = new SafeContinuation(intercepted);
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        JSONObject optJSONObject2 = jSONObject.optJSONObject("avatar_info");
        if (optJSONObject2 != null) {
            jSONArray = optJSONObject2.optJSONArray("slot_arr");
        } else {
            jSONArray = null;
        }
        if (jSONArray != null && jSONArray.length() != 0) {
            int length = jSONArray.length();
            for (int i3 = 0; i3 < length; i3++) {
                JSONObject optJSONObject3 = jSONArray.optJSONObject(i3);
                if (optJSONObject3 != null) {
                    int optInt = optJSONObject3.optInt(MiniAppReportManager2.KEY_SLOT_ID);
                    JSONObject optJSONObject4 = optJSONObject3.optJSONObject("custom_data");
                    if (optJSONObject4 != null) {
                        long optLong = optJSONObject4.optLong("ugc_id");
                        if (optLong != 0 && (optJSONObject = optJSONObject3.optJSONObject("item_data")) != null) {
                            String optString = optJSONObject.optString("local_ugc_texture_path");
                            if (optString != null && optString.length() != 0) {
                                z16 = false;
                            } else {
                                z16 = true;
                            }
                            if (!z16) {
                                linkedHashMap.put(String.valueOf(optInt), new ZPlanUgcFAssetInfo(optInt, optLong, optString, true));
                            } else {
                                String optString2 = optJSONObject.optString("ugc_texture_path");
                                if (optString2 != null) {
                                    StringBuilder sb5 = new StringBuilder();
                                    sb5.append(f105660o.L0(optLong));
                                    replace$default = StringsKt__StringsJVMKt.replace$default(optString2, "Texture", "Filement", false, 4, (Object) null);
                                    sb5.append(replace$default);
                                    sb5.append(".zip");
                                    linkedHashMap.put(String.valueOf(optInt), new ZPlanUgcFAssetInfo(optInt, optLong, sb5.toString(), false, 8, null));
                                }
                            }
                        }
                    }
                }
            }
            safeContinuation.resumeWith(Result.m476constructorimpl(linkedHashMap));
        } else {
            safeContinuation.resumeWith(Result.m476constructorimpl(linkedHashMap));
        }
        Object orThrow = safeContinuation.getOrThrow();
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (orThrow == coroutine_suspended) {
            DebugProbes.probeCoroutineSuspended(continuation);
        }
        return orThrow;
    }
}

package com.tencent.mobileqq.wink.editor.aielimination;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.drawable.Animatable;
import android.os.Bundle;
import androidx.exifinterface.media.ExifInterface;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import com.airbnb.lottie.LottieAnimationView;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.ad.tangram.statistics.metric.AdMetricTag;
import com.tencent.aelight.camera.constants.AECameraConstants;
import com.tencent.aelight.camera.pref.api.IPrefRecorder;
import com.tencent.biz.pubaccount.util.api.impl.PublicAccountMessageUtilImpl;
import com.tencent.bugly.common.constants.Constants;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.intervideo.nowproxy.NowProxyConstants;
import com.tencent.libra.LoadState;
import com.tencent.libra.listener.IPicLoadStateListener;
import com.tencent.libra.request.Option;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.activity.photo.MimeHelper;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.common.picload.QQPicLoader;
import com.tencent.mobileqq.data.troop.TroopMemberInfo;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.transfile.NetResp;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qaddefine.QAdReportDefine$AdReporterParams;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import com.tencent.mobileqq.vas.api.IVasYellowDiamondPay;
import com.tencent.mobileqq.vas.api.RemoteProxy;
import com.tencent.mobileqq.wink.WinkCoroutineScopes;
import com.tencent.mobileqq.wink.api.QQWinkConstants;
import com.tencent.mobileqq.wink.context.WinkContext;
import com.tencent.mobileqq.wink.editor.aielimination.model.AIEliminationButtonStatus;
import com.tencent.mobileqq.wink.editor.aielimination.model.AIEliminationDoActionType;
import com.tencent.mobileqq.wink.editor.aielimination.model.AIEliminationScene;
import com.tencent.mobileqq.wink.editor.aielimination.model.AIEliminationTabName;
import com.tencent.mobileqq.wink.editor.cu;
import com.tencent.mobileqq.wink.share.WinkShareCommonModel;
import com.tencent.mobileqq.winkreport.datong.WinkDTParamBuilder;
import com.tencent.mobileqq.winkreport.datong.WinkDaTongReportConstant;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.opentelemetry.semconv.trace.attributes.SemanticAttributes;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.utils.JsonUtils;
import com.tencent.rmonitor.custom.ICustomDataEditor;
import com.tencent.videocut.model.MediaClip;
import com.tencent.videocut.model.ResourceModel;
import cooperation.qzone.QZoneHelper;
import cooperation.qzone.QZoneShareManager;
import java.io.File;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CancellationException;
import kotlin.ExceptionsKt__ExceptionsKt;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsJVMKt;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.coroutines.AbstractCoroutineContextElement;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.SafeContinuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugProbes;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.TypeIntrinsics;
import kotlin.text.StringsKt__StringNumberConversionsKt;
import kotlin.text.StringsKt__StringsJVMKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineExceptionHandler;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.SupervisorKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONArray;
import qshadow.ShadowAIGCStatus$PayInfo;
import qshadow.ShadowAIGCStatus$UsageInfo;
import y53.a;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u00fa\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u0000\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\u0015\n\u0002\u0010\u0006\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b!\u0018\u0000 \u00ec\u00012\u00020\u0001:\u0002\u00ed\u0001B\t\u00a2\u0006\u0006\b\u00ea\u0001\u0010\u00eb\u0001J\u0014\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u0002H\u0002J\u0018\u0010\u0007\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0003H\u0002J\b\u0010\b\u001a\u00020\u0003H\u0002J\b\u0010\t\u001a\u00020\u0003H\u0002J\u001f\u0010\u000b\u001a\u0004\u0018\u00010\u00032\b\u0010\n\u001a\u0004\u0018\u00010\u0003H\u0082@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u000b\u0010\fJ\b\u0010\u000e\u001a\u0004\u0018\u00010\rJ\b\u0010\u000f\u001a\u0004\u0018\u00010\u0003J\u0006\u0010\u0010\u001a\u00020\u0003J\u0006\u0010\u0012\u001a\u00020\u0011J\u0010\u0010\u0016\u001a\u00020\u00152\b\u0010\u0014\u001a\u0004\u0018\u00010\u0013J\u0006\u0010\u0018\u001a\u00020\u0017J\b\u0010\u001a\u001a\u0004\u0018\u00010\u0019J\b\u0010\u001b\u001a\u0004\u0018\u00010\u0019J\u0006\u0010\u001c\u001a\u00020\u0015J\u0010\u0010\u001f\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u001e\u001a\u00020\u001dJ\u0010\u0010 \u001a\u0004\u0018\u00010\u00032\u0006\u0010\u001e\u001a\u00020\u001dJ\"\u0010$\u001a\u00020\u00152\u0006\u0010!\u001a\u00020\u00032\b\u0010\"\u001a\u0004\u0018\u00010\u00032\b\u0010#\u001a\u0004\u0018\u00010\u0003J\u0010\u0010&\u001a\u00020\u00152\b\u0010%\u001a\u0004\u0018\u00010\u0019J\u0006\u0010'\u001a\u00020\u0015J\u0006\u0010(\u001a\u00020\u0003J\u0006\u0010*\u001a\u00020)J\b\u0010+\u001a\u0004\u0018\u00010\u0019J\b\u0010,\u001a\u0004\u0018\u00010\u0019J\u0006\u0010.\u001a\u00020-J\b\u0010/\u001a\u0004\u0018\u00010\u0003J\u000e\u00101\u001a\u00020\u00152\u0006\u00100\u001a\u00020\u0003J\u0086\u0001\u0010;\u001a\u00020\u00152\u0006\u00102\u001a\u00020\u00032\u0006\u0010%\u001a\u00020\u00192\b\u00103\u001a\u0004\u0018\u00010\u00032d\u0010:\u001a`\u0012\u0013\u0012\u00110\u0003\u00a2\u0006\f\b5\u0012\b\b6\u0012\u0004\b\b(2\u0012\u0013\u0012\u001107\u00a2\u0006\f\b5\u0012\b\b6\u0012\u0004\b\b(8\u0012\u0015\u0012\u0013\u0018\u00010\u0019\u00a2\u0006\f\b5\u0012\b\b6\u0012\u0004\b\b(%\u0012\u0015\u0012\u0013\u0018\u00010\u0003\u00a2\u0006\f\b5\u0012\b\b6\u0012\u0004\b\b(9\u0012\u0004\u0012\u00020\u001504J\u0006\u0010<\u001a\u00020\u0003J\u000e\u0010?\u001a\u00020\u00152\u0006\u0010>\u001a\u00020=J\u0006\u0010@\u001a\u00020\u0015J\u0006\u0010A\u001a\u00020\u0015J\u0006\u0010B\u001a\u00020\u0015J \u0010F\u001a\u0012\u0012\u0004\u0012\u00020\r0Dj\b\u0012\u0004\u0012\u00020\r`E2\b\u0010C\u001a\u0004\u0018\u00010\rJ\u001f\u0010H\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030GH\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0004\bH\u0010IJ\u0006\u0010J\u001a\u00020\u0015J\u0006\u0010L\u001a\u00020KJ\u0006\u0010M\u001a\u00020KJ\u0006\u0010N\u001a\u00020KJ\u0006\u0010O\u001a\u00020-J\u001e\u0010S\u001a\u00020\u00152\u0006\u0010P\u001a\u00020-2\u0006\u0010Q\u001a\u00020-2\u0006\u0010R\u001a\u00020KJ\u0016\u0010W\u001a\u00020\u00152\u0006\u0010U\u001a\u00020T2\u0006\u0010:\u001a\u00020VJ\u0006\u0010X\u001a\u00020KJ\u001a\u0010[\u001a\u00020\u00132\b\u0010Y\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010Z\u001a\u00020-J\u0018\u0010_\u001a\u00020\u00152\u0006\u0010]\u001a\u00020\\2\b\b\u0002\u0010^\u001a\u00020-J\u0016\u0010b\u001a\u00020\u00152\u0006\u0010`\u001a\u00020K2\u0006\u0010a\u001a\u00020KJ\u0006\u0010c\u001a\u00020-J\u000e\u0010f\u001a\u00020e2\u0006\u0010d\u001a\u00020KR$\u0010i\u001a\u0012\u0012\u0004\u0012\u00020\r0Dj\b\u0012\u0004\u0012\u00020\r`E8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bg\u0010hR&\u0010k\u001a\u0012\u0012\u0004\u0012\u00020\u00170Dj\b\u0012\u0004\u0012\u00020\u0017`E8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bj\u0010hR\u0016\u0010n\u001a\u00020K8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bl\u0010mR\u0018\u0010r\u001a\u0004\u0018\u00010o8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bp\u0010qR\u0016\u0010u\u001a\u00020\u00118\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bs\u0010tR\"\u0010}\u001a\u00020v8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bw\u0010x\u001a\u0004\by\u0010z\"\u0004\b{\u0010|R*\u0010\u0085\u0001\u001a\u0004\u0018\u00010~8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0017\n\u0005\b\u007f\u0010\u0080\u0001\u001a\u0006\b\u0081\u0001\u0010\u0082\u0001\"\u0006\b\u0083\u0001\u0010\u0084\u0001R*\u0010\u008d\u0001\u001a\u00030\u0086\u00018\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0018\n\u0006\b\u0087\u0001\u0010\u0088\u0001\u001a\u0006\b\u0089\u0001\u0010\u008a\u0001\"\u0006\b\u008b\u0001\u0010\u008c\u0001R\u001a\u0010\u008f\u0001\u001a\u0004\u0018\u00010\u00038\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0007\n\u0005\bm\u0010\u008e\u0001R6\u0010\u0097\u0001\u001a\u000f\u0012\u0004\u0012\u00020\u0003\u0012\u0005\u0012\u00030\u0090\u00010\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0018\n\u0006\b\u0091\u0001\u0010\u0092\u0001\u001a\u0006\b\u0093\u0001\u0010\u0094\u0001\"\u0006\b\u0095\u0001\u0010\u0096\u0001R\u0019\u0010\u009a\u0001\u001a\u00020\u00178\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u0098\u0001\u0010\u0099\u0001R\u0019\u0010\u009d\u0001\u001a\u00020-8\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u009b\u0001\u0010\u009c\u0001R\u001c\u0010\u00a1\u0001\u001a\u00020\u00038\u0006\u00a2\u0006\u0010\n\u0006\b\u009e\u0001\u0010\u008e\u0001\u001a\u0006\b\u009f\u0001\u0010\u00a0\u0001R,\u0010\u00a9\u0001\u001a\u0005\u0018\u00010\u00a2\u00018\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0018\n\u0006\b\u00a3\u0001\u0010\u00a4\u0001\u001a\u0006\b\u00a5\u0001\u0010\u00a6\u0001\"\u0006\b\u00a7\u0001\u0010\u00a8\u0001R\u001b\u0010\u00ab\u0001\u001a\u0004\u0018\u00010\u00038\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u00aa\u0001\u0010\u008e\u0001R)\u0010\u00b0\u0001\u001a\u00020\u00038\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0018\n\u0006\b\u00ac\u0001\u0010\u008e\u0001\u001a\u0006\b\u00ad\u0001\u0010\u00a0\u0001\"\u0006\b\u00ae\u0001\u0010\u00af\u0001R+\u0010\u00b7\u0001\u001a\u0004\u0018\u00010K8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0018\n\u0006\b\u00b1\u0001\u0010\u00b2\u0001\u001a\u0006\b\u00b3\u0001\u0010\u00b4\u0001\"\u0006\b\u00b5\u0001\u0010\u00b6\u0001R)\u0010\u00be\u0001\u001a\u00030\u00b8\u00018\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0017\n\u0005\b\u00b9\u0001\u0010p\u001a\u0006\b\u00ba\u0001\u0010\u00bb\u0001\"\u0006\b\u00bc\u0001\u0010\u00bd\u0001R \u0010\u00c1\u0001\u001a\u000b \u00bf\u0001*\u0004\u0018\u00010\u00030\u00038\u0002X\u0082\u0004\u00a2\u0006\b\n\u0006\b\u00c0\u0001\u0010\u008e\u0001R\u0017\u0010\u00c3\u0001\u001a\u00020\u00038\u0002X\u0082\u0004\u00a2\u0006\b\n\u0006\b\u00c2\u0001\u0010\u008e\u0001R5\u0010\u00c8\u0001\u001a \u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u00c4\u0001j\u000f\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003`\u00c5\u00018\u0002X\u0082\u0004\u00a2\u0006\b\n\u0006\b\u00c6\u0001\u0010\u00c7\u0001R\u001e\u0010\u00cc\u0001\u001a\t\u0012\u0004\u0012\u00020-0\u00c9\u00018\u0002X\u0082\u0004\u00a2\u0006\b\n\u0006\b\u00ca\u0001\u0010\u00cb\u0001R#\u0010\u00d2\u0001\u001a\t\u0012\u0004\u0012\u00020-0\u00cd\u00018\u0006\u00a2\u0006\u0010\n\u0006\b\u00ce\u0001\u0010\u00cf\u0001\u001a\u0006\b\u00d0\u0001\u0010\u00d1\u0001R\u001e\u0010\u00d4\u0001\u001a\t\u0012\u0004\u0012\u00020-0\u00c9\u00018\u0002X\u0082\u0004\u00a2\u0006\b\n\u0006\b\u00d3\u0001\u0010\u00cb\u0001R#\u0010\u00d6\u0001\u001a\t\u0012\u0004\u0012\u00020-0\u00cd\u00018\u0006\u00a2\u0006\u0010\n\u0006\b\u009c\u0001\u0010\u00cf\u0001\u001a\u0006\b\u00d5\u0001\u0010\u00d1\u0001R\u001e\u0010\u00d8\u0001\u001a\t\u0012\u0004\u0012\u00020-0\u00c9\u00018\u0002X\u0082\u0004\u00a2\u0006\b\n\u0006\b\u00d7\u0001\u0010\u00cb\u0001R#\u0010\u00db\u0001\u001a\t\u0012\u0004\u0012\u00020-0\u00cd\u00018\u0006\u00a2\u0006\u0010\n\u0006\b\u00d9\u0001\u0010\u00cf\u0001\u001a\u0006\b\u00da\u0001\u0010\u00d1\u0001R\u001e\u0010\u00dd\u0001\u001a\t\u0012\u0004\u0012\u0002070\u00c9\u00018\u0002X\u0082\u0004\u00a2\u0006\b\n\u0006\b\u00dc\u0001\u0010\u00cb\u0001R#\u0010\u00e0\u0001\u001a\t\u0012\u0004\u0012\u0002070\u00cd\u00018\u0006\u00a2\u0006\u0010\n\u0006\b\u00de\u0001\u0010\u00cf\u0001\u001a\u0006\b\u00df\u0001\u0010\u00d1\u0001R\u001e\u0010\u00e2\u0001\u001a\t\u0012\u0004\u0012\u0002070\u00c9\u00018\u0002X\u0082\u0004\u00a2\u0006\b\n\u0006\b\u00e1\u0001\u0010\u00cb\u0001R#\u0010\u00e5\u0001\u001a\t\u0012\u0004\u0012\u0002070\u00cd\u00018\u0006\u00a2\u0006\u0010\n\u0006\b\u00e3\u0001\u0010\u00cf\u0001\u001a\u0006\b\u00e4\u0001\u0010\u00d1\u0001R\u001b\u0010\u00e7\u0001\u001a\u0004\u0018\u00010\u00038\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u00e6\u0001\u0010\u008e\u0001R\u0019\u0010\u00e9\u0001\u001a\u00020-8\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u00e8\u0001\u0010\u009c\u0001\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u00ee\u0001"}, d2 = {"Lcom/tencent/mobileqq/wink/editor/aielimination/WinkAiEliminationViewModel;", "Landroidx/lifecycle/ViewModel;", "", "", "r2", "missionID", WadlProxyConsts.PARAM_FILENAME, ICustomDataEditor.STRING_ARRAY_PARAM_2, "m2", ICustomDataEditor.NUMBER_PARAM_2, "targetUrl", "X1", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lcom/tencent/videocut/model/MediaClip;", "d2", SemanticAttributes.DbSystemValues.H2, "p2", "Lcom/tencent/mobileqq/wink/editor/aielimination/model/AIEliminationScene;", "x2", "Landroid/os/Bundle;", "arguments", "", "K2", "Lcom/tencent/mobileqq/wink/editor/aielimination/model/a;", "e2", "Lcom/tencent/mobileqq/wink/editor/aielimination/model/b;", "f2", "h3", "J2", "Landroid/graphics/Bitmap;", MimeHelper.IMAGE_SUBTYPE_BITMAP, "Y2", ICustomDataEditor.STRING_ARRAY_PARAM_3, "originImagePath", "maskImagePath", "resultImagePath", "L2", PublicAccountMessageUtilImpl.ITEM_STRUCT_FIRST_LEVEL_NAME, "W2", "T1", "v2", "Lcom/tencent/mobileqq/activity/photo/LocalMediaInfo;", "w2", "g3", "S2", "", "N2", "g2", "originImageUrl", "j3", QAdReportDefine$AdReporterParams.K_Q_AD_REPORTER_PARAM_KEY_REQUEST_ID, "maskPath", "Lkotlin/Function4;", "Lkotlin/ParameterName;", "name", "", "code", "errorMsg", "callback", "U2", "b2", "Lcom/tencent/mobileqq/wink/editor/aielimination/model/AIEliminationDoActionType;", "action", "W1", "S1", "k3", "I2", "clip", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "i3", "", "Z1", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "V2", "", "q2", NowProxyConstants.AccountInfoKey.A2, Constants.BASE_IN_PLUGIN_VERSION, "O2", "isSuccessApply", "isCancel", AdMetricTag.RESPONSE_CODE, "T2", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "Lcom/tencent/mobileqq/vas/api/IVasYellowDiamondPay$a;", "R2", "H2", "shareImgPath", "isShareDefault", "t2", "Lcom/airbnb/lottie/LottieAnimationView;", "posterImage", "defaultPoster", "P2", "paySource", RemoteProxy.KEY_RESULT_TYPE, "U1", "M2", "shareType", "Lcom/tencent/mobileqq/wink/share/WinkShareCommonModel;", "C2", "i", "Ljava/util/ArrayList;", "mediaClips", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "eliminationList", BdhLogUtil.LogTag.Tag_Conn, "I", "selectIndex", "Lkotlinx/coroutines/Job;", "D", "Lkotlinx/coroutines/Job;", "eliminationJob", "E", "Lcom/tencent/mobileqq/wink/editor/aielimination/model/AIEliminationScene;", "mScene", "Lcom/tencent/mobileqq/wink/editor/aielimination/model/AIEliminationButtonStatus;", UserInfo.SEX_FEMALE, "Lcom/tencent/mobileqq/wink/editor/aielimination/model/AIEliminationButtonStatus;", "o2", "()Lcom/tencent/mobileqq/wink/editor/aielimination/model/AIEliminationButtonStatus;", "d3", "(Lcom/tencent/mobileqq/wink/editor/aielimination/model/AIEliminationButtonStatus;)V", "mButtonStatus", "Lcom/tencent/mobileqq/wink/editor/aielimination/WinkEliminateOperatorPart;", "G", "Lcom/tencent/mobileqq/wink/editor/aielimination/WinkEliminateOperatorPart;", "z2", "()Lcom/tencent/mobileqq/wink/editor/aielimination/WinkEliminateOperatorPart;", "f3", "(Lcom/tencent/mobileqq/wink/editor/aielimination/WinkEliminateOperatorPart;)V", "selectedPart", "Lcom/tencent/mobileqq/wink/editor/aielimination/model/AIEliminationTabName;", "H", "Lcom/tencent/mobileqq/wink/editor/aielimination/model/AIEliminationTabName;", "y2", "()Lcom/tencent/mobileqq/wink/editor/aielimination/model/AIEliminationTabName;", "e3", "(Lcom/tencent/mobileqq/wink/editor/aielimination/model/AIEliminationTabName;)V", "selectTabName", "Ljava/lang/String;", "mOriginImageUrl", "", "J", "Ljava/util/Map;", "c2", "()Ljava/util/Map;", "setConfigData", "(Ljava/util/Map;)V", "configData", "K", "Lcom/tencent/mobileqq/wink/editor/aielimination/model/a;", "copiedAIEliminationData", "L", "Z", "isHotStart", "M", "k2", "()Ljava/lang/String;", "currentTraceId", "Lcom/tencent/mobileqq/wink/editor/aielimination/model/c;", "N", "Lcom/tencent/mobileqq/wink/editor/aielimination/model/c;", "getCountAndPayInfo", "()Lcom/tencent/mobileqq/wink/editor/aielimination/model/c;", "b3", "(Lcom/tencent/mobileqq/wink/editor/aielimination/model/c;)V", "countAndPayInfo", "P", "currentPath", AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, "i2", "setCurrentRequestId", "(Ljava/lang/String;)V", "currentRequestId", BdhLogUtil.LogTag.Tag_Req, "Ljava/lang/Integer;", ICustomDataEditor.STRING_PARAM_2, "()Ljava/lang/Integer;", "setPrePageSource", "(Ljava/lang/Integer;)V", "prePageSource", "", ExifInterface.LATITUDE_SOUTH, "j2", "()D", "c3", "(D)V", "currentSeekBarValue", "kotlin.jvm.PlatformType", "T", "cacheFilePath", "U", "shareCacheFilePath", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "V", "Ljava/util/HashMap;", "shareUrlCacheMap", "Landroidx/lifecycle/MutableLiveData;", "W", "Landroidx/lifecycle/MutableLiveData;", "_showUndoLiveData", "Landroidx/lifecycle/LiveData;", "X", "Landroidx/lifecycle/LiveData;", Constants.MMCCID, "()Landroidx/lifecycle/LiveData;", "showUndoLiveData", "Y", "_showRedoLiveData", "F2", "showRedoLiveData", "a0", "_showEliminatePanelLiveData", "b0", "E2", "showEliminatePanelLivaData", "c0", "_shareLimitLivaData", "d0", "B2", "shareLimitLivaData", "e0", "_doActionResultLivaData", "f0", "l2", "doActionResultLivaData", "g0", "mCurrentMaskPath", "h0", "isInit", "<init>", "()V", "i0", "a", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes21.dex */
public final class WinkAiEliminationViewModel extends ViewModel {

    /* renamed from: C, reason: from kotlin metadata */
    private int selectIndex;

    /* renamed from: D, reason: from kotlin metadata */
    @Nullable
    private Job eliminationJob;

    /* renamed from: G, reason: from kotlin metadata */
    @Nullable
    private WinkEliminateOperatorPart selectedPart;

    /* renamed from: I, reason: from kotlin metadata */
    @Nullable
    private String mOriginImageUrl;

    /* renamed from: L, reason: from kotlin metadata */
    private boolean isHotStart;

    /* renamed from: M, reason: from kotlin metadata */
    @NotNull
    private final String currentTraceId;

    /* renamed from: N, reason: from kotlin metadata */
    @Nullable
    private com.tencent.mobileqq.wink.editor.aielimination.model.c countAndPayInfo;

    /* renamed from: P, reason: from kotlin metadata */
    @Nullable
    private String currentPath;

    /* renamed from: Q, reason: from kotlin metadata */
    @NotNull
    private String currentRequestId;

    /* renamed from: R, reason: from kotlin metadata */
    @Nullable
    private Integer prePageSource;

    /* renamed from: S, reason: from kotlin metadata */
    private double currentSeekBarValue;

    /* renamed from: T, reason: from kotlin metadata */
    private final String cacheFilePath;

    /* renamed from: U, reason: from kotlin metadata */
    @NotNull
    private final String shareCacheFilePath;

    /* renamed from: V, reason: from kotlin metadata */
    @NotNull
    private final HashMap<String, String> shareUrlCacheMap;

    /* renamed from: W, reason: from kotlin metadata */
    @NotNull
    private final MutableLiveData<Boolean> _showUndoLiveData;

    /* renamed from: X, reason: from kotlin metadata */
    @NotNull
    private final LiveData<Boolean> showUndoLiveData;

    /* renamed from: Y, reason: from kotlin metadata */
    @NotNull
    private final MutableLiveData<Boolean> _showRedoLiveData;

    /* renamed from: Z, reason: from kotlin metadata */
    @NotNull
    private final LiveData<Boolean> showRedoLiveData;

    /* renamed from: a0, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final MutableLiveData<Boolean> _showEliminatePanelLiveData;

    /* renamed from: b0, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final LiveData<Boolean> showEliminatePanelLivaData;

    /* renamed from: c0, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final MutableLiveData<Long> _shareLimitLivaData;

    /* renamed from: d0, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final LiveData<Long> shareLimitLivaData;

    /* renamed from: e0, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final MutableLiveData<Long> _doActionResultLivaData;

    /* renamed from: f0, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final LiveData<Long> doActionResultLivaData;

    /* renamed from: g0, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private String mCurrentMaskPath;

    /* renamed from: h0, reason: collision with root package name and from kotlin metadata */
    private boolean isInit;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final ArrayList<MediaClip> mediaClips = new ArrayList<>();

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private ArrayList<com.tencent.mobileqq.wink.editor.aielimination.model.a> eliminationList = new ArrayList<>();

    /* renamed from: E, reason: from kotlin metadata */
    @NotNull
    private AIEliminationScene mScene = AIEliminationScene.OTHER;

    /* renamed from: F, reason: from kotlin metadata */
    @NotNull
    private AIEliminationButtonStatus mButtonStatus = AIEliminationButtonStatus.NORMAL;

    /* renamed from: H, reason: from kotlin metadata */
    @NotNull
    private AIEliminationTabName selectTabName = AIEliminationTabName.AI_ELIMINATE;

    /* renamed from: J, reason: from kotlin metadata */
    @NotNull
    private Map<String, Object> configData = new LinkedHashMap();

    /* renamed from: K, reason: from kotlin metadata */
    @NotNull
    private com.tencent.mobileqq.wink.editor.aielimination.model.a copiedAIEliminationData = new com.tencent.mobileqq.wink.editor.aielimination.model.a(new ArrayList(), null, 2, null);

    /* compiled from: P */
    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes21.dex */
    public /* synthetic */ class b {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f318787a;

        static {
            int[] iArr = new int[AIEliminationTabName.values().length];
            try {
                iArr[AIEliminationTabName.REMOVE_WATERMARK.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[AIEliminationTabName.REMOVE_TEXT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            f318787a = iArr;
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000!\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u00012\u00020\u0002J\u0018\u0010\b\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0005H\u0016\u00a8\u0006\t\u00b8\u0006\u0000"}, d2 = {"kotlinx/coroutines/CoroutineExceptionHandlerKt$CoroutineExceptionHandler$1", "Lkotlin/coroutines/AbstractCoroutineContextElement;", "Lkotlinx/coroutines/CoroutineExceptionHandler;", "Lkotlin/coroutines/CoroutineContext;", "context", "", "exception", "", "handleException", "kotlinx-coroutines-core"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes21.dex */
    public static final class d extends AbstractCoroutineContextElement implements CoroutineExceptionHandler {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ Function4 f318790d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ String f318791e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public d(CoroutineExceptionHandler.Companion companion, Function4 function4, String str) {
            super(companion);
            this.f318790d = function4;
            this.f318791e = str;
        }

        @Override // kotlinx.coroutines.CoroutineExceptionHandler
        public void handleException(@NotNull CoroutineContext context, @NotNull Throwable exception) {
            String stackTraceToString;
            long j3;
            stackTraceToString = ExceptionsKt__ExceptionsKt.stackTraceToString(exception);
            w53.b.c("WinkAiEliminationViewModel", "requestAIElimination exception: " + stackTraceToString);
            ((IPrefRecorder) QRoute.api(IPrefRecorder.class)).milestoneEnd(IPrefRecorder.MILESTONE_AI_ELIMINATE_BACKEND_REQUEST);
            ((IPrefRecorder) QRoute.api(IPrefRecorder.class)).milestoneEnd(IPrefRecorder.MILESTONE_AI_ELIMINATE_UPLOAD_IMG);
            ((IPrefRecorder) QRoute.api(IPrefRecorder.class)).milestoneEnd(IPrefRecorder.MILESTONE_AI_ELIMINATE_DOWNLOAD_IMG);
            if (!(exception instanceof CancellationException)) {
                w53.b.c("WinkAiEliminationViewModel", "requestAIElimination error " + exception);
                Function4 function4 = this.f318790d;
                String str = this.f318791e;
                if (exception instanceof IllegalStateException) {
                    j3 = -1002;
                } else {
                    j3 = TroopMemberInfo.VALUE_MEMBER_CLOSE_SHARE_LBS;
                }
                function4.invoke(str, Long.valueOf(j3), null, "upload fail");
            }
        }
    }

    public WinkAiEliminationViewModel() {
        String str;
        WinkContext.Companion companion = WinkContext.INSTANCE;
        if (!companion.l()) {
            str = "";
        } else {
            str = companion.d().getTraceId();
        }
        this.currentTraceId = str;
        this.currentRequestId = "";
        this.currentSeekBarValue = 25.0d;
        String str2 = u53.a.f438365f;
        this.cacheFilePath = str2;
        this.shareCacheFilePath = str2 + File.separator + "share_cache";
        this.shareUrlCacheMap = new HashMap<>();
        MutableLiveData<Boolean> mutableLiveData = new MutableLiveData<>();
        this._showUndoLiveData = mutableLiveData;
        this.showUndoLiveData = mutableLiveData;
        MutableLiveData<Boolean> mutableLiveData2 = new MutableLiveData<>();
        this._showRedoLiveData = mutableLiveData2;
        this.showRedoLiveData = mutableLiveData2;
        MutableLiveData<Boolean> mutableLiveData3 = new MutableLiveData<>();
        this._showEliminatePanelLiveData = mutableLiveData3;
        this.showEliminatePanelLivaData = mutableLiveData3;
        MutableLiveData<Long> mutableLiveData4 = new MutableLiveData<>();
        this._shareLimitLivaData = mutableLiveData4;
        this.shareLimitLivaData = mutableLiveData4;
        MutableLiveData<Long> mutableLiveData5 = new MutableLiveData<>();
        this._doActionResultLivaData = mutableLiveData5;
        this.doActionResultLivaData = mutableLiveData5;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Q2(WinkAiEliminationViewModel this$0, LoadState loadState, Option option) {
        Animatable animatable;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        boolean z16 = false;
        if (loadState != null && loadState.isFinishSuccess()) {
            z16 = true;
        }
        if (z16) {
            if (option != null) {
                animatable = option.getAnimatable();
            } else {
                animatable = null;
            }
            if (animatable instanceof r01.c) {
                QLog.d("WinkAiEliminationViewModel", 1, this$0.hashCode() + " anim load success");
                Animatable animatable2 = option.getAnimatable();
                Intrinsics.checkNotNull(animatable2, "null cannot be cast to non-null type com.tencent.libra.base.LibraAnimatable");
                r01.c cVar = (r01.c) animatable2;
                cVar.setLoopCount(65535);
                cVar.start();
                return;
            }
        }
        QLog.d("WinkAiEliminationViewModel", 1, this$0.hashCode() + " anim load error");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:12:0x00cf  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0043  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0023  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object X1(String str, Continuation<? super String> continuation) {
        WinkAiEliminationViewModel$downloadByUrl$1 winkAiEliminationViewModel$downloadByUrl$1;
        int i3;
        boolean z16;
        String str2;
        WinkAiEliminationViewModel winkAiEliminationViewModel;
        boolean isBlank;
        boolean isBlank2;
        if (continuation instanceof WinkAiEliminationViewModel$downloadByUrl$1) {
            winkAiEliminationViewModel$downloadByUrl$1 = (WinkAiEliminationViewModel$downloadByUrl$1) continuation;
            int i16 = winkAiEliminationViewModel$downloadByUrl$1.label;
            if ((i16 & Integer.MIN_VALUE) != 0) {
                winkAiEliminationViewModel$downloadByUrl$1.label = i16 - Integer.MIN_VALUE;
                Object obj = winkAiEliminationViewModel$downloadByUrl$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i3 = winkAiEliminationViewModel$downloadByUrl$1.label;
                if (i3 == 0) {
                    if (i3 == 1) {
                        str = (String) winkAiEliminationViewModel$downloadByUrl$1.L$1;
                        winkAiEliminationViewModel = (WinkAiEliminationViewModel) winkAiEliminationViewModel$downloadByUrl$1.L$0;
                        ResultKt.throwOnFailure(obj);
                    } else {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                } else {
                    ResultKt.throwOnFailure(obj);
                    w53.b.f("WinkAiEliminationViewModel", "downloadByUrl " + str);
                    if (str != null && str.length() != 0) {
                        z16 = false;
                    } else {
                        z16 = true;
                    }
                    if (z16) {
                        return null;
                    }
                    str2 = this.shareUrlCacheMap.get(str);
                    if (str2 == null) {
                        String str3 = this.shareCacheFilePath + File.separator + System.currentTimeMillis() + ".png";
                        winkAiEliminationViewModel$downloadByUrl$1.L$0 = this;
                        winkAiEliminationViewModel$downloadByUrl$1.L$1 = str;
                        winkAiEliminationViewModel$downloadByUrl$1.L$2 = str3;
                        winkAiEliminationViewModel$downloadByUrl$1.L$3 = winkAiEliminationViewModel$downloadByUrl$1;
                        winkAiEliminationViewModel$downloadByUrl$1.label = 1;
                        SafeContinuation safeContinuation = new SafeContinuation(IntrinsicsKt.intercepted(winkAiEliminationViewModel$downloadByUrl$1));
                        y53.a.c().a(str, str3, new c(safeContinuation, str3));
                        obj = safeContinuation.getOrThrow();
                        if (obj == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
                            DebugProbes.probeCoroutineSuspended(winkAiEliminationViewModel$downloadByUrl$1);
                        }
                        if (obj == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        winkAiEliminationViewModel = this;
                    }
                    return str2;
                }
                str2 = (String) obj;
                isBlank = StringsKt__StringsJVMKt.isBlank(str);
                if (!isBlank) {
                    isBlank2 = StringsKt__StringsJVMKt.isBlank(str2);
                    if (!isBlank2) {
                        winkAiEliminationViewModel.shareUrlCacheMap.put(str, str2);
                    }
                }
                return str2;
            }
        }
        winkAiEliminationViewModel$downloadByUrl$1 = new WinkAiEliminationViewModel$downloadByUrl$1(this, continuation);
        Object obj2 = winkAiEliminationViewModel$downloadByUrl$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i3 = winkAiEliminationViewModel$downloadByUrl$1.label;
        if (i3 == 0) {
        }
        str2 = (String) obj2;
        isBlank = StringsKt__StringsJVMKt.isBlank(str);
        if (!isBlank) {
        }
        return str2;
    }

    private final String a2(String missionID, String fileName) {
        w53.b.f("PicMosaicView", "genExportFilePath... fileName:" + fileName);
        String str = this.cacheFilePath;
        String str2 = File.separator;
        String str3 = str + str2 + missionID;
        File file = new File(str3);
        if (!file.exists()) {
            file.mkdirs();
        }
        return str3 + str2 + "output_" + missionID + "_" + fileName;
    }

    private final String m2() {
        return System.currentTimeMillis() + ".jpg";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String n2() {
        AIEliminationTabName aIEliminationTabName;
        int i3;
        WinkEliminateOperatorPart winkEliminateOperatorPart = this.selectedPart;
        if (winkEliminateOperatorPart != null) {
            aIEliminationTabName = winkEliminateOperatorPart.x9();
        } else {
            aIEliminationTabName = null;
        }
        if (aIEliminationTabName == null) {
            i3 = -1;
        } else {
            i3 = b.f318787a[aIEliminationTabName.ordinal()];
        }
        if (i3 != 1) {
            if (i3 != 2) {
                return "image_agent_auto_removal";
            }
            return "image_agent_text_removal";
        }
        return "image_agent_watermark_removal";
    }

    private final Map<String, String> r2() {
        boolean z16;
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put("join_url_android", "mqqapi://kuikly/open?aid=jhan.hz.rk.kjrk_aixckt&trace_detail=base64-eyJhcHBpZCI6Im91dHNpZGUiLCJwYWdlX2lkIjoiMTAwMSJ9&version=1&kr_turbo_display=yellowDiamond&src_type=web&qqmc_config=vas_kuikly_config&page_name=vas_qqvip_pay&bundle_name=vas_qqvip_pay&pay_type=yellowDiamond&business_type=yellowDiamond%2CdeluxeDiamond&half_pay=1&modal_mode=1&month=1&policy_id=hz-liushi1");
        linkedHashMap.put("renew_url_android", "mqqapi://kuikly/open?aid=jhan.hz.rk.kjrk_aixcwyw&trace_detail=base64-eyJhcHBpZCI6Im91dHNpZGUiLCJwYWdlX2lkIjoiMTAwMSJ9&version=1&kr_turbo_display=yellowDiamond&src_type=web&qqmc_config=vas_kuikly_config&page_name=vas_qqvip_pay&bundle_name=vas_qqvip_pay&pay_type=yellowDiamond&business_type=yellowDiamond%2CdeluxeDiamond&half_pay=1&modal_mode=1&month=1&policy_id=hz-liushi1");
        linkedHashMap.put("item_aid_android", "jhan.hz.rk.kjrk_aixcatzf");
        linkedHashMap.put("item_id_android", "117434_df377409");
        String loadAsString = ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).loadAsString("qzone_ai_eliminate_yellow_diamond_config", "");
        if (loadAsString.length() == 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            w53.b.c("WinkAiEliminationViewModel", "[getPayConfigData] isEmpty");
            return linkedHashMap;
        }
        try {
            w53.b.c("WinkAiEliminationViewModel", "[getPayConfigData] configJsonData: " + loadAsString);
            Map<String, Object> mapForJson = JsonUtils.getMapForJson(loadAsString);
            Intrinsics.checkNotNull(mapForJson, "null cannot be cast to non-null type kotlin.collections.MutableMap<kotlin.String, kotlin.String>");
            return TypeIntrinsics.asMutableMap(mapForJson);
        } catch (Exception e16) {
            w53.b.c("WinkAiEliminationViewModel", "[getPayConfigData] exception: " + e16);
            return linkedHashMap;
        }
    }

    public static /* synthetic */ Bundle u2(WinkAiEliminationViewModel winkAiEliminationViewModel, String str, boolean z16, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            z16 = true;
        }
        return winkAiEliminationViewModel.t2(str, z16);
    }

    public final int A2() {
        int i3;
        Map<Integer, ShadowAIGCStatus$UsageInfo> b16;
        ShadowAIGCStatus$UsageInfo shadowAIGCStatus$UsageInfo;
        PBInt32Field pBInt32Field;
        com.tencent.mobileqq.wink.editor.aielimination.model.c cVar = this.countAndPayInfo;
        if (cVar != null && (b16 = cVar.b()) != null && (shadowAIGCStatus$UsageInfo = b16.get(2)) != null && (pBInt32Field = shadowAIGCStatus$UsageInfo.available) != null) {
            i3 = pBInt32Field.get();
        } else {
            i3 = 0;
        }
        w53.b.a("WinkAiEliminationViewModel", "getShareFreeUnusedTimes: " + i3);
        return i3;
    }

    @NotNull
    public final LiveData<Long> B2() {
        return this.shareLimitLivaData;
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x0042  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0052  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0060  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0070  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x007e  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x008c  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x00a8  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x00ac  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0034  */
    @NotNull
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final WinkShareCommonModel C2(int shareType) {
        boolean z16;
        String str;
        boolean z17;
        String str2;
        boolean z18;
        String str3;
        int i3;
        boolean z19;
        boolean z26;
        boolean z27;
        boolean z28;
        a aVar = new a();
        String title = aVar.getTitle();
        String descForQq = aVar.getDescForQq();
        String desc = aVar.getDesc();
        String preview = aVar.getPreview();
        String str4 = (String) this.configData.get("shareH5ContentTitle");
        boolean z29 = false;
        if (str4 != null) {
            if (str4.length() > 0) {
                z28 = true;
            } else {
                z28 = false;
            }
            if (z28) {
                z16 = true;
                if (z16) {
                    title = str4;
                }
                str = (String) this.configData.get("shareH5ContentDesc");
                if (str != null) {
                    if (str.length() > 0) {
                        z27 = true;
                    } else {
                        z27 = false;
                    }
                    if (z27) {
                        z17 = true;
                        if (z17) {
                            descForQq = str;
                        }
                        str2 = (String) this.configData.get("shareH5ContentOutsideDesc");
                        if (str2 != null) {
                            if (str2.length() > 0) {
                                z26 = true;
                            } else {
                                z26 = false;
                            }
                            if (z26) {
                                z18 = true;
                                if (z18) {
                                    desc = str2;
                                }
                                str3 = (String) this.configData.get("shareH5ContentPreviewImg");
                                if (str3 != null) {
                                    if (str3.length() > 0) {
                                        z19 = true;
                                    } else {
                                        z19 = false;
                                    }
                                    if (z19) {
                                        z29 = true;
                                    }
                                }
                                if (z29) {
                                    preview = str3;
                                }
                                WinkShareCommonModel winkShareCommonModel = new WinkShareCommonModel(title, preview, desc, aVar.getSchemaUrl());
                                winkShareCommonModel.setShareExternalUrl(aVar.getShareUrl());
                                winkShareCommonModel.setDescForQq(descForQq);
                                winkShareCommonModel.setRequestQQId(52133);
                                if (shareType != 1) {
                                    i3 = 52134;
                                } else {
                                    i3 = 52135;
                                }
                                winkShareCommonModel.setRequestQZoneId(i3);
                                winkShareCommonModel.setRequestArkBusId("qzone_auto_removal");
                                winkShareCommonModel.setRequestGuildId(52133);
                                winkShareCommonModel.setRequestQZoneAlbumId(52133);
                                winkShareCommonModel.setNewArkRequest(true);
                                winkShareCommonModel.setQzonePublishParams(t2(null, true));
                                Bundle bundle = new Bundle();
                                bundle.putInt(WinkShareCommonModel.EXTRA_PARAMS_QZONE_ALBUM_COME_FROM, 4);
                                winkShareCommonModel.setExtraParams(bundle);
                                return winkShareCommonModel;
                            }
                        }
                        z18 = false;
                        if (z18) {
                        }
                        str3 = (String) this.configData.get("shareH5ContentPreviewImg");
                        if (str3 != null) {
                        }
                        if (z29) {
                        }
                        WinkShareCommonModel winkShareCommonModel2 = new WinkShareCommonModel(title, preview, desc, aVar.getSchemaUrl());
                        winkShareCommonModel2.setShareExternalUrl(aVar.getShareUrl());
                        winkShareCommonModel2.setDescForQq(descForQq);
                        winkShareCommonModel2.setRequestQQId(52133);
                        if (shareType != 1) {
                        }
                        winkShareCommonModel2.setRequestQZoneId(i3);
                        winkShareCommonModel2.setRequestArkBusId("qzone_auto_removal");
                        winkShareCommonModel2.setRequestGuildId(52133);
                        winkShareCommonModel2.setRequestQZoneAlbumId(52133);
                        winkShareCommonModel2.setNewArkRequest(true);
                        winkShareCommonModel2.setQzonePublishParams(t2(null, true));
                        Bundle bundle2 = new Bundle();
                        bundle2.putInt(WinkShareCommonModel.EXTRA_PARAMS_QZONE_ALBUM_COME_FROM, 4);
                        winkShareCommonModel2.setExtraParams(bundle2);
                        return winkShareCommonModel2;
                    }
                }
                z17 = false;
                if (z17) {
                }
                str2 = (String) this.configData.get("shareH5ContentOutsideDesc");
                if (str2 != null) {
                }
                z18 = false;
                if (z18) {
                }
                str3 = (String) this.configData.get("shareH5ContentPreviewImg");
                if (str3 != null) {
                }
                if (z29) {
                }
                WinkShareCommonModel winkShareCommonModel22 = new WinkShareCommonModel(title, preview, desc, aVar.getSchemaUrl());
                winkShareCommonModel22.setShareExternalUrl(aVar.getShareUrl());
                winkShareCommonModel22.setDescForQq(descForQq);
                winkShareCommonModel22.setRequestQQId(52133);
                if (shareType != 1) {
                }
                winkShareCommonModel22.setRequestQZoneId(i3);
                winkShareCommonModel22.setRequestArkBusId("qzone_auto_removal");
                winkShareCommonModel22.setRequestGuildId(52133);
                winkShareCommonModel22.setRequestQZoneAlbumId(52133);
                winkShareCommonModel22.setNewArkRequest(true);
                winkShareCommonModel22.setQzonePublishParams(t2(null, true));
                Bundle bundle22 = new Bundle();
                bundle22.putInt(WinkShareCommonModel.EXTRA_PARAMS_QZONE_ALBUM_COME_FROM, 4);
                winkShareCommonModel22.setExtraParams(bundle22);
                return winkShareCommonModel22;
            }
        }
        z16 = false;
        if (z16) {
        }
        str = (String) this.configData.get("shareH5ContentDesc");
        if (str != null) {
        }
        z17 = false;
        if (z17) {
        }
        str2 = (String) this.configData.get("shareH5ContentOutsideDesc");
        if (str2 != null) {
        }
        z18 = false;
        if (z18) {
        }
        str3 = (String) this.configData.get("shareH5ContentPreviewImg");
        if (str3 != null) {
        }
        if (z29) {
        }
        WinkShareCommonModel winkShareCommonModel222 = new WinkShareCommonModel(title, preview, desc, aVar.getSchemaUrl());
        winkShareCommonModel222.setShareExternalUrl(aVar.getShareUrl());
        winkShareCommonModel222.setDescForQq(descForQq);
        winkShareCommonModel222.setRequestQQId(52133);
        if (shareType != 1) {
        }
        winkShareCommonModel222.setRequestQZoneId(i3);
        winkShareCommonModel222.setRequestArkBusId("qzone_auto_removal");
        winkShareCommonModel222.setRequestGuildId(52133);
        winkShareCommonModel222.setRequestQZoneAlbumId(52133);
        winkShareCommonModel222.setNewArkRequest(true);
        winkShareCommonModel222.setQzonePublishParams(t2(null, true));
        Bundle bundle222 = new Bundle();
        bundle222.putInt(WinkShareCommonModel.EXTRA_PARAMS_QZONE_ALBUM_COME_FROM, 4);
        winkShareCommonModel222.setExtraParams(bundle222);
        return winkShareCommonModel222;
    }

    public final int D2() {
        int i3;
        Map<Integer, ShadowAIGCStatus$UsageInfo> b16;
        ShadowAIGCStatus$UsageInfo shadowAIGCStatus$UsageInfo;
        PBInt32Field pBInt32Field;
        com.tencent.mobileqq.wink.editor.aielimination.model.c cVar = this.countAndPayInfo;
        if (cVar != null && (b16 = cVar.b()) != null && (shadowAIGCStatus$UsageInfo = b16.get(3)) != null && (pBInt32Field = shadowAIGCStatus$UsageInfo.available) != null) {
            i3 = pBInt32Field.get();
        } else {
            i3 = 0;
        }
        w53.b.a("WinkAiEliminationViewModel", "getShareUnusedTimes: " + i3);
        return i3;
    }

    @NotNull
    public final LiveData<Boolean> E2() {
        return this.showEliminatePanelLivaData;
    }

    @NotNull
    public final LiveData<Boolean> F2() {
        return this.showRedoLiveData;
    }

    @NotNull
    public final LiveData<Boolean> G2() {
        return this.showUndoLiveData;
    }

    public final int H2() {
        ShadowAIGCStatus$PayInfo payInfo;
        PBEnumField pBEnumField;
        com.tencent.mobileqq.wink.editor.aielimination.model.c cVar = this.countAndPayInfo;
        if (cVar != null && (payInfo = cVar.getPayInfo()) != null && (pBEnumField = payInfo.type) != null) {
            return pBEnumField.get();
        }
        return 0;
    }

    public final void I2() {
        this._showEliminatePanelLiveData.postValue(Boolean.TRUE);
    }

    public final void J2() {
        boolean z16;
        String str;
        String str2;
        String str3;
        String str4;
        String str5;
        String str6;
        String str7;
        String str8;
        String str9;
        String str10;
        String str11;
        String str12;
        String str13;
        JSONArray jSONArray;
        List shuffled;
        List take;
        JSONArray jSONArray2;
        List shuffled2;
        List take2;
        this.configData.put("guidePage", "https://qq-video.cdn-go.cn/url-resource/latest/defaultmode/AIeliminate/PhotoGallery_7.png");
        this.configData.put("guidePageLottie", "https://downv6.qq.com/video_story/wezone_url/defaultmode/AIeliminate/photos9.zip");
        this.configData.put("defaultQzoneTopicUin", "3037348892");
        this.configData.put("defaultQzoneTopicTitle", "AI\u62ef\u6551\u5e9f\u7247");
        this.configData.put("userQzoneTopicUin", "3037348892");
        this.configData.put("userQzoneTopicTitle", "AI\u62ef\u6551\u5e9f\u7247");
        String loadAsString = ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).loadAsString("qzone_ai_eliminate_share_image_config", "");
        if (loadAsString.length() == 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            w53.b.c("WinkAiEliminationViewModel", "[initConfigData] isEmpty");
            return;
        }
        try {
            Map<String, Object> configMap = JsonUtils.getMapForJson(loadAsString);
            Intrinsics.checkNotNullExpressionValue(configMap, "configMap");
            String str14 = null;
            if (!configMap.containsKey("guidePage")) {
                str = "WinkAiEliminationViewModel";
                str3 = "";
            } else {
                Object obj = configMap.get("guidePage");
                str3 = "";
                if (obj instanceof JSONArray) {
                    jSONArray2 = (JSONArray) obj;
                } else {
                    jSONArray2 = null;
                }
                List pageUrls = com.tencent.mobileqq.jsonconverter.a.d(jSONArray2, String.class.getGenericSuperclass());
                Map<String, Object> map = this.configData;
                Intrinsics.checkNotNullExpressionValue(pageUrls, "pageUrls");
                shuffled2 = CollectionsKt__CollectionsJVMKt.shuffled(pageUrls);
                str = "WinkAiEliminationViewModel";
                try {
                    take2 = CollectionsKt___CollectionsKt.take(shuffled2, 1);
                    map.put("guidePage", ((String) take2.get(0)).toString());
                } catch (Exception e16) {
                    e = e16;
                    str2 = str;
                    w53.b.c(str2, "[initConfigData] exception: " + e);
                    w53.b.f(str2, "[initConfigData] guidePage: " + this.configData);
                }
            }
            if (configMap.containsKey("guidePageLottie")) {
                Object obj2 = configMap.get("guidePageLottie");
                if (obj2 instanceof JSONArray) {
                    jSONArray = (JSONArray) obj2;
                } else {
                    jSONArray = null;
                }
                List pageUrls2 = com.tencent.mobileqq.jsonconverter.a.d(jSONArray, String.class.getGenericSuperclass());
                Intrinsics.checkNotNullExpressionValue(pageUrls2, "pageUrls");
                shuffled = CollectionsKt__CollectionsJVMKt.shuffled(pageUrls2);
                take = CollectionsKt___CollectionsKt.take(shuffled, 1);
                this.configData.put("guidePageLottie", ((String) take.get(0)).toString());
            }
            Map<String, Object> map2 = this.configData;
            Object obj3 = configMap.get("defaultQzoneTopicUin");
            if (obj3 instanceof String) {
                str4 = (String) obj3;
            } else {
                str4 = null;
            }
            if (str4 == null) {
                str4 = "3037348892";
            }
            map2.put("defaultQzoneTopicUin", str4);
            Map<String, Object> map3 = this.configData;
            Object obj4 = configMap.get("defaultQzoneTopicTitle");
            if (obj4 instanceof String) {
                str5 = (String) obj4;
            } else {
                str5 = null;
            }
            if (str5 == null) {
                str5 = "AI\u62ef\u6551\u5e9f\u7247";
            }
            map3.put("defaultQzoneTopicTitle", str5);
            Map<String, Object> map4 = this.configData;
            Object obj5 = configMap.get("userQzoneTopicUin");
            if (obj5 instanceof String) {
                str6 = (String) obj5;
            } else {
                str6 = null;
            }
            if (str6 == null) {
                str7 = "3037348892";
            } else {
                str7 = str6;
            }
            map4.put("userQzoneTopicUin", str7);
            Map<String, Object> map5 = this.configData;
            Object obj6 = configMap.get("userQzoneTopicTitle");
            if (obj6 instanceof String) {
                str8 = (String) obj6;
            } else {
                str8 = null;
            }
            if (str8 == null) {
                str9 = "AI\u62ef\u6551\u5e9f\u7247";
            } else {
                str9 = str8;
            }
            map5.put("userQzoneTopicTitle", str9);
            Map<String, Object> map6 = this.configData;
            Object obj7 = configMap.get("shareH5ContentTitle");
            if (obj7 instanceof String) {
                str10 = (String) obj7;
            } else {
                str10 = null;
            }
            if (str10 == null) {
                str10 = str3;
            }
            map6.put("shareH5ContentTitle", str10);
            Map<String, Object> map7 = this.configData;
            Object obj8 = configMap.get("shareH5ContentDesc");
            if (obj8 instanceof String) {
                str11 = (String) obj8;
            } else {
                str11 = null;
            }
            if (str11 == null) {
                str11 = str3;
            }
            map7.put("shareH5ContentDesc", str11);
            Map<String, Object> map8 = this.configData;
            Object obj9 = configMap.get("shareH5ContentOutsideDesc");
            if (obj9 instanceof String) {
                str12 = (String) obj9;
            } else {
                str12 = null;
            }
            if (str12 == null) {
                str12 = str3;
            }
            map8.put("shareH5ContentOutsideDesc", str12);
            Map<String, Object> map9 = this.configData;
            Object obj10 = configMap.get("shareH5ContentPreviewImg");
            if (obj10 instanceof String) {
                str14 = (String) obj10;
            }
            if (str14 == null) {
                str13 = str3;
            } else {
                str13 = str14;
            }
            map9.put("shareH5ContentPreviewImg", str13);
            str2 = str;
        } catch (Exception e17) {
            e = e17;
            str = "WinkAiEliminationViewModel";
        }
        w53.b.f(str2, "[initConfigData] guidePage: " + this.configData);
    }

    public final void K2(@Nullable Bundle arguments) {
        ArrayList arrayList;
        Object obj;
        String str;
        Integer intOrNull;
        if (this.isInit) {
            return;
        }
        this.isInit = true;
        String str2 = null;
        if (arguments != null) {
            arrayList = arguments.getParcelableArrayList("KEY_MEDIA_CLIP");
        } else {
            arrayList = null;
        }
        if (!(arrayList instanceof ArrayList)) {
            arrayList = null;
        }
        if (arrayList != null) {
            this.mediaClips.clear();
            this.mediaClips.addAll(arrayList);
        }
        if (arguments != null) {
            int intValue = Integer.valueOf(arguments.getInt("KEY_SCENE")).intValue();
            AIEliminationScene aIEliminationScene = AIEliminationScene.QZONE_HOME_PAGE;
            if (intValue != aIEliminationScene.getScene()) {
                aIEliminationScene = AIEliminationScene.WINK_EDITOR;
                if (intValue != aIEliminationScene.getScene()) {
                    aIEliminationScene = AIEliminationScene.AIO_EDITOR;
                    if (intValue != aIEliminationScene.getScene()) {
                        aIEliminationScene = AIEliminationScene.OTHER;
                    }
                }
            }
            this.mScene = aIEliminationScene;
        }
        if (arguments != null) {
            obj = arguments.get("key_attrs");
        } else {
            obj = null;
        }
        Map map = (Map) obj;
        if (map != null && (str = (String) map.get("source")) != null) {
            intOrNull = StringsKt__StringNumberConversionsKt.toIntOrNull(str);
            this.prePageSource = intOrNull;
        }
        J2();
        this.selectTabName = AIEliminationTabName.AI_ELIMINATE;
        if (arguments != null) {
            str2 = arguments.getString("KEY_IMAGE_PATH");
        }
        this.currentPath = str2;
    }

    public final void L2(@NotNull String originImagePath, @Nullable String maskImagePath, @Nullable String resultImagePath) {
        Intrinsics.checkNotNullParameter(originImagePath, "originImagePath");
        if (resultImagePath != null) {
            W2(new com.tencent.mobileqq.wink.editor.aielimination.model.b(originImagePath, maskImagePath, resultImagePath));
            T1();
        }
    }

    public final boolean M2() {
        if (com.tencent.mobileqq.wink.editor.util.h.f322638a.h() && this.mScene == AIEliminationScene.AIO_EDITOR) {
            return true;
        }
        return false;
    }

    public final boolean N2() {
        return e2().f();
    }

    public final boolean O2() {
        ShadowAIGCStatus$PayInfo payInfo;
        PBEnumField pBEnumField;
        com.tencent.mobileqq.wink.editor.aielimination.model.c cVar = this.countAndPayInfo;
        if (cVar == null || (payInfo = cVar.getPayInfo()) == null || (pBEnumField = payInfo.type) == null || pBEnumField.get() != 2) {
            return false;
        }
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void P2(@NotNull LottieAnimationView posterImage, boolean defaultPoster) {
        Intrinsics.checkNotNullParameter(posterImage, "posterImage");
        Option needShowLoadingDrawable = Option.obtain().setPreferDecoder(com.tencent.libra.extension.a.class).setNeedShowLoadingDrawable(false);
        String str = "https://downv6.qq.com/video_story/wezone_url/defaultmode/AIeliminate/photos9.zip";
        if (!defaultPoster) {
            Object obj = this.configData.get("guidePageLottie");
            if (obj != 0) {
                str = obj;
            }
            str = str;
        }
        Option option = needShowLoadingDrawable.setUrl(str).setTargetView(posterImage);
        QQPicLoader qQPicLoader = QQPicLoader.f201806a;
        Intrinsics.checkNotNullExpressionValue(option, "option");
        qQPicLoader.e(option, new IPicLoadStateListener() { // from class: com.tencent.mobileqq.wink.editor.aielimination.z
            @Override // com.tencent.libra.listener.IPicLoadStateListener
            public final void onStateChange(LoadState loadState, Option option2) {
                WinkAiEliminationViewModel.Q2(WinkAiEliminationViewModel.this, loadState, option2);
            }
        });
    }

    public final void R2(@NotNull Activity activity, @NotNull IVasYellowDiamondPay.a callback) {
        ShadowAIGCStatus$PayInfo payInfo;
        PBEnumField pBEnumField;
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(callback, "callback");
        com.tencent.mobileqq.wink.editor.aielimination.model.c cVar = this.countAndPayInfo;
        if (cVar != null && (payInfo = cVar.getPayInfo()) != null && (pBEnumField = payInfo.type) != null) {
            ((IVasYellowDiamondPay) QRoute.api(IVasYellowDiamondPay.class)).payFromAIEliminate(activity, pBEnumField.get(), r2(), callback);
        }
    }

    public final void S1() {
        this.currentRequestId = "";
        Job job = this.eliminationJob;
        if (job != null) {
            Job.DefaultImpls.cancel$default(job, (CancellationException) null, 1, (Object) null);
        }
    }

    @Nullable
    public final com.tencent.mobileqq.wink.editor.aielimination.model.b S2() {
        return e2().g();
    }

    public final void T1() {
        this.copiedAIEliminationData = e2().b();
    }

    public final void T2(boolean isSuccessApply, boolean isCancel, int responseCode) {
        if (isCancel) {
            ((IPrefRecorder) QRoute.api(IPrefRecorder.class)).clearTimeEvent(IPrefRecorder.MILESTONE_AI_ELIMINATE_DOWNLOAD_IMG);
            ((IPrefRecorder) QRoute.api(IPrefRecorder.class)).clearTimeEvent(IPrefRecorder.MILESTONE_AI_ELIMINATE_BACKEND_REQUEST);
            ((IPrefRecorder) QRoute.api(IPrefRecorder.class)).clearTimeEvent(IPrefRecorder.MILESTONE_AI_ELIMINATE_UPLOAD_IMG);
        }
        cu.u(isSuccessApply, isCancel, responseCode, this.isHotStart, this.selectTabName.getTabName());
    }

    public final void U1(int paySource, int resultType) {
        Map<String, Object> map = WinkDTParamBuilder.buildElementParams();
        Integer valueOf = Integer.valueOf(paySource);
        Intrinsics.checkNotNullExpressionValue(map, "map");
        map.put(WinkDaTongReportConstant.ElementParamKey.PAY_SOURCE, valueOf);
        map.put("result_type", Integer.valueOf(resultType));
        VideoReport.reportEvent(WinkDaTongReportConstant.EventId.EV_QZ_PAY_RESULT, map);
    }

    public final void U2(@NotNull String requestId, @NotNull com.tencent.mobileqq.wink.editor.aielimination.model.b item, @Nullable String maskPath, @NotNull Function4<? super String, ? super Long, ? super com.tencent.mobileqq.wink.editor.aielimination.model.b, ? super String, Unit> callback) {
        Job launch$default;
        Intrinsics.checkNotNullParameter(requestId, "requestId");
        Intrinsics.checkNotNullParameter(item, "item");
        Intrinsics.checkNotNullParameter(callback, "callback");
        this.currentRequestId = requestId;
        launch$default = BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(SupervisorKt.SupervisorJob$default((Job) null, 1, (Object) null).plus(WinkCoroutineScopes.f317652a.c())), new d(CoroutineExceptionHandler.INSTANCE, callback, requestId), null, new WinkAiEliminationViewModel$requestAIElimination$1(this, item, maskPath, requestId, callback, null), 2, null);
        this.eliminationJob = launch$default;
    }

    public final void V2() {
        w53.b.f("WinkAiEliminationViewModel", "requestShareAddTime");
        W1(AIEliminationDoActionType.Share);
    }

    public final void W1(@NotNull AIEliminationDoActionType action) {
        Intrinsics.checkNotNullParameter(action, "action");
        BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(SupervisorKt.SupervisorJob$default((Job) null, 1, (Object) null).plus(WinkCoroutineScopes.f317652a.c())), null, null, new WinkAiEliminationViewModel$doAction$1(action, this, null), 3, null);
    }

    public final void W2(@Nullable com.tencent.mobileqq.wink.editor.aielimination.model.b item) {
        if (item != null) {
            e2().a(item);
        }
        k3();
    }

    @Nullable
    public final String Y2(@NotNull Bitmap bitmap) {
        Intrinsics.checkNotNullParameter(bitmap, "bitmap");
        String a26 = a2(WinkContext.INSTANCE.d().getMissionId(), "mask_" + m2());
        w53.b.f("WinkAiEliminationViewModel", "saveEliminationData... path:" + a26);
        if (com.tencent.mobileqq.wink.utils.f.v(a26, bitmap, Bitmap.CompressFormat.JPEG, 100) == null) {
            a26 = null;
        }
        this.mCurrentMaskPath = a26;
        bitmap.recycle();
        return this.mCurrentMaskPath;
    }

    @Nullable
    public final Object Z1(@NotNull Continuation<? super Map<String, String>> continuation) {
        return BuildersKt.withContext(WinkCoroutineScopes.f317652a.e(), new WinkAiEliminationViewModel$fetchShareImg$2(this, null), continuation);
    }

    @Nullable
    public final String a3(@NotNull Bitmap bitmap) {
        Intrinsics.checkNotNullParameter(bitmap, "bitmap");
        String a26 = a2(WinkContext.INSTANCE.d().getMissionId(), "origin_" + m2());
        w53.b.f("WinkAiEliminationViewModel", "saveOriginBitmapToPath... path:" + a26);
        if (com.tencent.mobileqq.wink.utils.f.v(a26, bitmap, Bitmap.CompressFormat.JPEG, 100) == null) {
            a26 = "";
        }
        this.currentPath = a26;
        return a26;
    }

    @NotNull
    public final String b2() {
        if (getMScene() == AIEliminationScene.AIO_EDITOR) {
            return "aio_auto_removal";
        }
        return "qzone_auto_removal";
    }

    public final void b3(@Nullable com.tencent.mobileqq.wink.editor.aielimination.model.c cVar) {
        this.countAndPayInfo = cVar;
    }

    @NotNull
    public final Map<String, Object> c2() {
        return this.configData;
    }

    public final void c3(double d16) {
        this.currentSeekBarValue = d16;
    }

    @Nullable
    public final MediaClip d2() {
        Object orNull;
        orNull = CollectionsKt___CollectionsKt.getOrNull(this.mediaClips, this.selectIndex);
        return (MediaClip) orNull;
    }

    public final void d3(@NotNull AIEliminationButtonStatus aIEliminationButtonStatus) {
        Intrinsics.checkNotNullParameter(aIEliminationButtonStatus, "<set-?>");
        this.mButtonStatus = aIEliminationButtonStatus;
    }

    @NotNull
    public final com.tencent.mobileqq.wink.editor.aielimination.model.a e2() {
        if (this.eliminationList.size() <= this.selectIndex) {
            this.eliminationList.add(new com.tencent.mobileqq.wink.editor.aielimination.model.a(new ArrayList(), null, 2, null));
        }
        com.tencent.mobileqq.wink.editor.aielimination.model.a aVar = this.eliminationList.get(this.selectIndex);
        Intrinsics.checkNotNullExpressionValue(aVar, "eliminationList[selectIndex]");
        return aVar;
    }

    public final void e3(@NotNull AIEliminationTabName aIEliminationTabName) {
        Intrinsics.checkNotNullParameter(aIEliminationTabName, "<set-?>");
        this.selectTabName = aIEliminationTabName;
    }

    @Nullable
    public final com.tencent.mobileqq.wink.editor.aielimination.model.b f2() {
        return e2().d();
    }

    public final void f3(@Nullable WinkEliminateOperatorPart winkEliminateOperatorPart) {
        this.selectedPart = winkEliminateOperatorPart;
    }

    @Nullable
    /* renamed from: g2, reason: from getter */
    public final String getMCurrentMaskPath() {
        return this.mCurrentMaskPath;
    }

    @Nullable
    public final com.tencent.mobileqq.wink.editor.aielimination.model.b g3() {
        return e2().h();
    }

    @Nullable
    public final String h2() {
        Object orNull;
        ResourceModel resourceModel;
        String str;
        orNull = CollectionsKt___CollectionsKt.getOrNull(this.mediaClips, this.selectIndex);
        MediaClip mediaClip = (MediaClip) orNull;
        if (mediaClip != null && (resourceModel = mediaClip.resource) != null && (str = resourceModel.path) != null) {
            this.currentPath = str;
        }
        return this.currentPath;
    }

    @Nullable
    public final com.tencent.mobileqq.wink.editor.aielimination.model.b h3() {
        com.tencent.mobileqq.wink.editor.aielimination.model.b f26 = f2();
        this.eliminationList.set(this.selectIndex, this.copiedAIEliminationData);
        if (Intrinsics.areEqual(f26, e2().d())) {
            return null;
        }
        return e2().d();
    }

    @NotNull
    /* renamed from: i2, reason: from getter */
    public final String getCurrentRequestId() {
        return this.currentRequestId;
    }

    @NotNull
    public final ArrayList<MediaClip> i3(@Nullable MediaClip clip) {
        if (clip != null) {
            this.mediaClips.set(this.selectIndex, clip);
        }
        return this.mediaClips;
    }

    /* renamed from: j2, reason: from getter */
    public final double getCurrentSeekBarValue() {
        return this.currentSeekBarValue;
    }

    public final void j3(@NotNull String originImageUrl) {
        boolean z16;
        Intrinsics.checkNotNullParameter(originImageUrl, "originImageUrl");
        String str = this.mOriginImageUrl;
        if (str != null && str.length() != 0) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (z16) {
            this.mOriginImageUrl = originImageUrl;
        }
    }

    @NotNull
    /* renamed from: k2, reason: from getter */
    public final String getCurrentTraceId() {
        return this.currentTraceId;
    }

    public final void k3() {
        this._showUndoLiveData.postValue(Boolean.valueOf(!e2().f()));
        this._showRedoLiveData.postValue(Boolean.valueOf(!e2().e()));
    }

    @NotNull
    public final LiveData<Long> l2() {
        return this.doActionResultLivaData;
    }

    @NotNull
    /* renamed from: o2, reason: from getter */
    public final AIEliminationButtonStatus getMButtonStatus() {
        return this.mButtonStatus;
    }

    @NotNull
    public final String p2() {
        String dstMediaPath;
        com.tencent.mobileqq.wink.editor.aielimination.model.b f26 = f2();
        if (f26 == null || (dstMediaPath = f26.getDstMediaPath()) == null) {
            String h26 = h2();
            if (h26 == null) {
                return "";
            }
            return h26;
        }
        return dstMediaPath;
    }

    public final int q2() {
        int i3;
        Map<Integer, ShadowAIGCStatus$UsageInfo> b16;
        ShadowAIGCStatus$UsageInfo shadowAIGCStatus$UsageInfo;
        PBInt32Field pBInt32Field;
        com.tencent.mobileqq.wink.editor.aielimination.model.c cVar = this.countAndPayInfo;
        if (cVar != null && (b16 = cVar.b()) != null && (shadowAIGCStatus$UsageInfo = b16.get(1)) != null && (pBInt32Field = shadowAIGCStatus$UsageInfo.available) != null) {
            i3 = pBInt32Field.get();
        } else {
            i3 = 0;
        }
        w53.b.a("WinkAiEliminationViewModel", "getNormalUnusedTimes: " + i3);
        return i3;
    }

    @Nullable
    /* renamed from: s2, reason: from getter */
    public final Integer getPrePageSource() {
        return this.prePageSource;
    }

    @NotNull
    public final Bundle t2(@Nullable String shareImgPath, boolean isShareDefault) {
        int i3;
        String str;
        Map<String, Object> map;
        String str2;
        ArrayList<String> arrayListOf;
        Bundle bundle = new Bundle();
        if (shareImgPath != null) {
            arrayListOf = CollectionsKt__CollectionsKt.arrayListOf(shareImgPath);
            bundle.putStringArrayList("images", arrayListOf);
        }
        bundle.putString(QZoneShareManager.QZONE_SHARE_THIRD_PARTY_APPID, QQWinkConstants.QZONE_SHARE_VALUE_ELIMINATE_EVENT);
        bundle.putString(QZoneShareManager.QZONE_SHARE_THIRD_PARTY_URL, QQWinkConstants.QZONE_SHARE_VALUE_ELIMINATE_SCHEMA);
        bundle.putInt(QZoneHelper.Constants.KEY_PUBLISH_COME_FROM, 4);
        Integer num = this.prePageSource;
        if (num != null) {
            i3 = num.intValue();
        } else {
            i3 = -1;
        }
        bundle.putInt(QZoneHelper.Constants.KEY_PUBLISH_SUB_COME_FROM, i3);
        bundle.putBoolean("key_need_save_draft", false);
        Map<String, Object> map2 = this.configData;
        if (isShareDefault) {
            str = "defaultQzoneTopicTitle";
        } else {
            str = "userQzoneTopicTitle";
        }
        String str3 = (String) map2.get(str);
        if (isShareDefault) {
            map = this.configData;
            str2 = "defaultQzoneTopicUin";
        } else {
            map = this.configData;
            str2 = "userQzoneTopicUin";
        }
        String str4 = (String) map.get(str2);
        if (!Intrinsics.areEqual(str3, "none") && !Intrinsics.areEqual(str4, "none")) {
            bundle.putString("tagtitle", str3);
            bundle.putString("taguin", str4);
        }
        return bundle;
    }

    @NotNull
    public final String v2() {
        return a2(WinkContext.INSTANCE.d().getMissionId(), "remove_result" + m2());
    }

    @NotNull
    public final LocalMediaInfo w2() {
        HashMap<String, Serializable> hashMapOf;
        LocalMediaInfo c16 = ba3.a.c(p2());
        hashMapOf = MapsKt__MapsKt.hashMapOf(TuplesKt.to(AECameraConstants.MEDIA_FROM, AECameraConstants.MEDIA_FROM_EDIT));
        c16.extData = hashMapOf;
        Intrinsics.checkNotNullExpressionValue(c16, "buildLocalMediaInfosForP\u2026EDIA_FROM_EDIT)\n        }");
        return c16;
    }

    @NotNull
    /* renamed from: x2, reason: from getter */
    public final AIEliminationScene getMScene() {
        return this.mScene;
    }

    @NotNull
    /* renamed from: y2, reason: from getter */
    public final AIEliminationTabName getSelectTabName() {
        return this.selectTabName;
    }

    @Nullable
    /* renamed from: z2, reason: from getter */
    public final WinkEliminateOperatorPart getSelectedPart() {
        return this.selectedPart;
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016\u00a8\u0006\t"}, d2 = {"com/tencent/mobileqq/wink/editor/aielimination/WinkAiEliminationViewModel$c", "Ly53/a$a;", "Lcom/tencent/mobileqq/transfile/NetResp;", "resp", "", "a", "", "progress", "onProgressUpdate", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes21.dex */
    public static final class c implements a.InterfaceC11592a {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Continuation<String> f318788a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ String f318789b;

        /* JADX WARN: Multi-variable type inference failed */
        c(Continuation<? super String> continuation, String str) {
            this.f318788a = continuation;
            this.f318789b = str;
        }

        @Override // y53.a.InterfaceC11592a
        public void a(@Nullable NetResp resp) {
            Unit unit;
            if (resp != null) {
                Continuation<String> continuation = this.f318788a;
                String str = this.f318789b;
                if (resp.mResult == 0) {
                    continuation.resumeWith(Result.m476constructorimpl(str));
                } else {
                    w53.b.c("WinkAiEliminationViewModel", "download share image onResp: error result is not ok");
                    continuation.resumeWith(Result.m476constructorimpl(""));
                }
                unit = Unit.INSTANCE;
            } else {
                unit = null;
            }
            if (unit == null) {
                Continuation<String> continuation2 = this.f318788a;
                w53.b.c("WinkAiEliminationViewModel", "download share image onResp: error resp is null");
                continuation2.resumeWith(Result.m476constructorimpl(""));
            }
        }

        @Override // y53.a.InterfaceC11592a
        public void onProgressUpdate(int progress) {
        }
    }
}

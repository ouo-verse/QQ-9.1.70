package com.tencent.mobileqq.wink.magicstudio;

import androidx.core.util.Consumer;
import androidx.exifinterface.media.ExifInterface;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import camera.XEFFECT_MATERIALS_GENERAL_DATASTRUCT.MetaCategory;
import camera.XEFFECT_MATERIALS_GENERAL_DATASTRUCT.MetaMaterial;
import com.heytap.databaseengine.model.UserInfo;
import com.qzone.module.covercomponent.model.CoverDBCacheData;
import com.tencent.aelight.camera.pref.api.IPrefRecorder;
import com.tencent.biz.richframework.network.VSNetworkHelper;
import com.tencent.biz.richframework.network.request.BaseRequest;
import com.tencent.biz.richframework.util.RFWSaveUtil;
import com.tencent.biz.richframework.util.bean.RFWSaveMediaResultBean;
import com.tencent.component.network.downloader.impl.ipc.Const;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.BusinessHandler;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.icgame.api.impl.room.report.AudienceReportConst;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.transfile.NetResp;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.QQTheme;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.wink.api.QQWinkConstants;
import com.tencent.mobileqq.wink.api.QQWinkTempConstants;
import com.tencent.mobileqq.wink.edit.manager.WinkEditorResourceManager;
import com.tencent.mobileqq.wink.launcher.network.WinkRecommendDataServiceHandler;
import com.tencent.mobileqq.wink.magicstudio.model.GenerateInfo;
import com.tencent.mobileqq.wink.magicstudio.model.JumpInfo;
import com.tencent.mobileqq.wink.magicstudio.model.MagicStudioButtonInfo;
import com.tencent.mobileqq.wink.magicstudio.model.MagicStudioButtonReq;
import com.tencent.mobileqq.wink.magicstudio.model.MagicStudioPicStyle;
import com.tencent.mobileqq.wink.magicstudio.model.MagicStudioPrompt;
import com.tencent.mobileqq.wink.magicstudio.model.MagicStudioServerStatusReq;
import com.tencent.mobileqq.wink.magicstudio.model.MagicStudioTip;
import com.tencent.mobileqq.wink.request.QQWinkAIGCDoActionReq;
import com.tencent.mobileqq.wink.utils.an;
import com.tencent.qphone.base.util.BaseApplication;
import common.config.service.QzoneConfig;
import cooperation.qzone.report.datong.QZoneDTLoginReporter;
import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugProbes;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function5;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CancellableContinuation;
import kotlinx.coroutines.CancellableContinuationImpl;
import kotlinx.coroutines.Dispatchers;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONArray;
import org.json.JSONObject;
import org.light.aigc.AIGCClient;
import org.light.aigc.bean.AIGCContentOutput;
import org.light.aigc.bean.AIGCRequest;
import org.light.aigc.net.IGenerateCallback;
import qshadow.ShadowAIGCSafe$SafeCheckReply;
import qshadow.ShadowAIGCServerStatus$GetServerStatusReply;
import qshadow.ShadowAIGCServerStatus$GetServerStatusRequest;
import qshadow.ShadowAIGCStatus$DoActionReply;
import qshadow.ShadowAIGCStatus$DoActionRequest;
import qshadow.ShadowAIGCStatus$GetStatusReply;
import y53.a;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u00e8\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u001e\n\u0002\u0010\u0003\n\u0000\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u000b\b\u0002\u00a2\u0006\u0006\b\u009a\u0001\u0010\u009b\u0001J\u0018\u0010\u0006\u001a\u00020\u00052\u000e\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0002H\u0002J\u001b\u0010\n\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u0007H\u0082@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\n\u0010\u000bJ#\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\u0007H\u0082@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0010\u0010\u0011J\b\u0010\u0012\u001a\u00020\u0005H\u0002J\b\u0010\u0013\u001a\u00020\u0005H\u0002J3\u0010\u0019\u001a\u001a\u0012\u0004\u0012\u00020\u0017\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\f0\u00180\u00162\u0006\u0010\u0015\u001a\u00020\u0014H\u0082@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0019\u0010\u001aJ\u001e\u0010\u001c\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\f0\u00182\b\u0010\u001b\u001a\u0004\u0018\u00010\fH\u0002J:\u0010$\u001a\u00020\u00052\u0006\u0010\u001d\u001a\u00020\f2\u0006\u0010\u001e\u001a\u00020\f2\f\u0010 \u001a\b\u0012\u0004\u0012\u00020\f0\u001f2\u0006\u0010\"\u001a\u00020!2\n\b\u0002\u0010#\u001a\u0004\u0018\u00010\fH\u0002J\u0010\u0010&\u001a\u00020\u00052\u0006\u0010%\u001a\u00020!H\u0002J\u0018\u0010)\u001a\u00020\u00052\u0006\u0010\u001e\u001a\u00020\f2\u0006\u0010(\u001a\u00020'H\u0002J\b\u0010+\u001a\u00020*H\u0002J\u0018\u0010.\u001a\u00020\u00052\u0006\u0010,\u001a\u00020!2\u0006\u0010-\u001a\u00020\fH\u0002J\u0018\u00100\u001a\u00020\f2\u0006\u0010\u001d\u001a\u00020\f2\u0006\u0010/\u001a\u00020\fH\u0002J\u0010\u00101\u001a\u00020\f2\u0006\u0010,\u001a\u00020!H\u0002J/\u00109\u001a\u00020\u00052'\u00108\u001a#\u0012\u0015\u0012\u0013\u0018\u000103\u00a2\u0006\f\b4\u0012\b\b5\u0012\u0004\b\b(6\u0012\u0004\u0012\u00020\u000502j\u0002`7J\u0006\u0010:\u001a\u00020\u0005J(\u0010?\u001a\b\u0012\u0004\u0012\u00020>0\u00022\u0006\u0010;\u001a\u00020\u00032\b\b\u0002\u0010<\u001a\u00020!2\b\b\u0002\u0010=\u001a\u00020!Ja\u0010F\u001a\u001a\u0012\u0004\u0012\u00020\u0017\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\f0\u00180\u00162\u0006\u0010@\u001a\u00020\f2\u0006\u0010A\u001a\u00020\f2\u0006\u0010B\u001a\u00020\f2\u0006\u0010C\u001a\u00020\f2\n\b\u0002\u0010D\u001a\u0004\u0018\u00010\u00072\b\b\u0002\u0010E\u001a\u00020!H\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0004\bF\u0010GJ3\u0010H\u001a\u001a\u0012\u0004\u0012\u00020\u0017\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\f0\u00180\u00162\u0006\u0010\u0015\u001a\u00020\u0014H\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0004\bH\u0010\u001aJ1\u0010I\u001a\u00020\f2\u0006\u0010\u001d\u001a\u00020\f2\b\b\u0002\u0010\"\u001a\u00020!2\n\b\u0002\u0010#\u001a\u0004\u0018\u00010\fH\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0004\bI\u0010JJ1\u0010K\u001a\u00020\f2\u0006\u0010\u001d\u001a\u00020\f2\b\b\u0002\u0010\"\u001a\u00020!2\n\b\u0002\u0010#\u001a\u0004\u0018\u00010\fH\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0004\bK\u0010JJ\u0016\u0010M\u001a\u00020\u00052\u000e\u0010L\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\f0\u0002J\u001e\u0010O\u001a\u00020\u00052\u0006\u0010N\u001a\u00020\u00072\u0006\u0010\u001d\u001a\u00020\f2\u0006\u0010(\u001a\u00020'J\u0010\u0010P\u001a\u0004\u0018\u00010\f2\u0006\u0010-\u001a\u00020\fJ\u001d\u0010Q\u001a\u0004\u0018\u00010\f2\u0006\u0010-\u001a\u00020\fH\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0004\bQ\u0010RJ\u000e\u0010S\u001a\u00020!2\u0006\u0010-\u001a\u00020\fJ\u001b\u0010T\u001a\u00020\f2\u0006\u0010\u001d\u001a\u00020\fH\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0004\bT\u0010RJ\u001f\u0010U\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00070\u0016H\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0004\bU\u0010VJ\u0010\u0010W\u001a\u00020\f2\b\b\u0002\u0010,\u001a\u00020!J\u0006\u0010X\u001a\u00020\fJ\u001b\u0010Z\u001a\u00020\t2\u0006\u0010Y\u001a\u00020\u0007H\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0004\bZ\u0010\u000bJ\u001b\u0010\\\u001a\u00020\u000f2\u0006\u0010[\u001a\u00020\u0007H\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\\\u0010\u000bJ\u000e\u0010^\u001a\u00020\u00052\u0006\u0010 \u001a\u00020]J\u001c\u0010b\u001a\u00020\u00052\b\b\u0002\u0010`\u001a\u00020_2\n\b\u0002\u0010a\u001a\u0004\u0018\u00010\fJ\u0006\u0010c\u001a\u00020\u0005R\u0018\u0010g\u001a\u0004\u0018\u00010d8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\be\u0010fR2\u0010m\u001a\u001e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020i0hj\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020i`j8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bk\u0010lR \u0010q\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00020n8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bo\u0010pR\u001d\u0010x\u001a\b\u0012\u0004\u0012\u00020s0r8\u0006\u00a2\u0006\f\n\u0004\bt\u0010u\u001a\u0004\bv\u0010wR#\u0010\u007f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020z0\u00020y8\u0006\u00a2\u0006\f\n\u0004\b{\u0010|\u001a\u0004\b}\u0010~R \u0010\u0082\u0001\u001a\b\u0012\u0004\u0012\u00020\u00050y8\u0006\u00a2\u0006\u000e\n\u0005\b\u0080\u0001\u0010|\u001a\u0005\b\u0081\u0001\u0010~R,\u0010\u008a\u0001\u001a\u0005\u0018\u00010\u0083\u00018\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0018\n\u0006\b\u0084\u0001\u0010\u0085\u0001\u001a\u0006\b\u0086\u0001\u0010\u0087\u0001\"\u0006\b\u0088\u0001\u0010\u0089\u0001R \u0010\u008f\u0001\u001a\u00020\f8BX\u0082\u0084\u0002\u00a2\u0006\u0010\n\u0006\b\u008b\u0001\u0010\u008c\u0001\u001a\u0006\b\u008d\u0001\u0010\u008e\u0001R \u0010\u0092\u0001\u001a\u00020\f8BX\u0082\u0084\u0002\u00a2\u0006\u0010\n\u0006\b\u0090\u0001\u0010\u008c\u0001\u001a\u0006\b\u0091\u0001\u0010\u008e\u0001R\u001c\u0010\u0096\u0001\u001a\u0005\u0018\u00010\u0093\u00018\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u0094\u0001\u0010\u0095\u0001Re\u0010\u0099\u0001\u001aQ\u0012!\u0012\u001f\u0012\u0015\u0012\u0013\u0018\u000103\u00a2\u0006\f\b4\u0012\b\b5\u0012\u0004\b\b(6\u0012\u0004\u0012\u00020\u0005020rj*\u0012%\u0012#\u0012\u0015\u0012\u0013\u0018\u000103\u00a2\u0006\f\b4\u0012\b\b5\u0012\u0004\b\b(6\u0012\u0004\u0012\u00020\u000502j\u0002`7`\u0097\u00018\u0002X\u0082\u0004\u00a2\u0006\u0007\n\u0005\b\u0098\u0001\u0010u\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u009c\u0001"}, d2 = {"Lcom/tencent/mobileqq/wink/magicstudio/MagicStudioDataSource;", "", "", "Lcamera/XEFFECT_MATERIALS_GENERAL_DATASTRUCT/MetaCategory;", "data", "", "W", "", WadlProxyConsts.SCENE_ID, "Lcom/tencent/mobileqq/wink/magicstudio/model/e;", "K", "(ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "", "busId", "action", "Lqshadow/ShadowAIGCStatus$DoActionReply;", HippyTKDListViewAdapter.X, "(Ljava/lang/String;ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "X", "g0", "Lorg/light/aigc/bean/AIGCRequest;", Const.BUNDLE_KEY_REQUEST, "Lkotlin/Pair;", "Lorg/light/aigc/bean/AIGCContentOutput;", "", "h0", "(Lorg/light/aigc/bean/AIGCRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "extra", "b0", "url", "aigcImgCachePath", "Lkotlinx/coroutines/CancellableContinuation;", "it", "", "withMilestone", "milestoneTag", "B", "isError", "u", "Li83/g;", "listener", "Z", "Lcom/tencent/mobileqq/wink/magicstudio/model/MagicStudioServerStatusReq;", UserInfo.SEX_FEMALE, "isNight", "path", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "tag", "H", "I", "Lkotlin/Function1;", "Lcom/tencent/mobileqq/wink/magicstudio/ab;", "Lkotlin/ParameterName;", "name", "info", "Lcom/tencent/mobileqq/wink/magicstudio/PageInfoCallback;", "callback", "f0", "U", "category", "limitMaterialSize", "sortMaterials", "Lcom/tencent/mobileqq/wink/magicstudio/model/MagicStudioPicStyle;", "c0", "desc", "styleId", "picPath", "safeId", "baseImageIndex", "isRetry", "j0", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;ZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "i0", "y", "(Ljava/lang/String;ZLjava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "r", CoverDBCacheData.URLS, "D", "id", BdhLogUtil.LogTag.Tag_Conn, "N", "O", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Y", "p0", "q0", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", BdhLogUtil.LogTag.Tag_Req, "L", "scene", "J", "actionId", "w", "", "o0", "", "code", "errorMsg", "l0", "t", "Lorg/light/aigc/AIGCClient;", "b", "Lorg/light/aigc/AIGCClient;", "aigcClient", "Ljava/util/HashMap;", "Lcamera/XEFFECT_MATERIALS_GENERAL_DATASTRUCT/MetaMaterial;", "Lkotlin/collections/HashMap;", "c", "Ljava/util/HashMap;", "templateMap", "Landroidx/lifecycle/Observer;", "d", "Landroidx/lifecycle/Observer;", "materialObserver", "Ljava/util/ArrayList;", "Lcom/tencent/mobileqq/wink/magicstudio/model/f;", "e", "Ljava/util/ArrayList;", "getMagicStudioStylesLocal", "()Ljava/util/ArrayList;", "magicStudioStylesLocal", "Landroidx/lifecycle/MutableLiveData;", "Lcom/tencent/mobileqq/wink/magicstudio/model/c;", "f", "Landroidx/lifecycle/MutableLiveData;", "G", "()Landroidx/lifecycle/MutableLiveData;", "aigcGenerateLiveData", "g", "M", "cancelToNext", "Lcom/tencent/mobileqq/wink/magicstudio/model/d;", tl.h.F, "Lcom/tencent/mobileqq/wink/magicstudio/model/d;", AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, "()Lcom/tencent/mobileqq/wink/magicstudio/model/d;", "k0", "(Lcom/tencent/mobileqq/wink/magicstudio/model/d;)V", "jumpInfo", "i", "Lkotlin/Lazy;", "P", "()Ljava/lang/String;", "dayPagPath", "j", "T", "nightPagPath", "Lcom/tencent/mobileqq/widget/QQToast;", "k", "Lcom/tencent/mobileqq/widget/QQToast;", "qqToast", "Lkotlin/collections/ArrayList;", "l", "pageInfoCallBacks", "<init>", "()V", "qq-wink-temp-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes21.dex */
public final class MagicStudioDataSource {

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private static volatile AIGCClient aigcClient;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final Observer<List<MetaCategory>> materialObserver;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private static volatile JumpInfo jumpInfo;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final Lazy dayPagPath;

    /* renamed from: j, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final Lazy nightPagPath;

    /* renamed from: k, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private static QQToast qqToast;

    /* renamed from: l, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final ArrayList<Function1<PageInfoCallbackInfo, Unit>> pageInfoCallBacks;

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final MagicStudioDataSource f323652a = new MagicStudioDataSource();

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static HashMap<String, MetaMaterial> templateMap = new HashMap<>();

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final ArrayList<com.tencent.mobileqq.wink.magicstudio.model.f> magicStudioStylesLocal = new ArrayList<>();

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final MutableLiveData<List<GenerateInfo>> aigcGenerateLiveData = new MutableLiveData<>();

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final MutableLiveData<Unit> cancelToNext = new MutableLiveData<>();

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0004\u001a\u00020\u0002H\u0016\u00a8\u0006\u0005"}, d2 = {"com/tencent/mobileqq/wink/magicstudio/MagicStudioDataSource$d", "Li83/g;", "", "onSuccess", "onFailed", "qq-wink-temp-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes21.dex */
    public static final class d implements i83.g {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ AtomicInteger f323670a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ AtomicInteger f323671b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ int f323672c;

        d(AtomicInteger atomicInteger, AtomicInteger atomicInteger2, int i3) {
            this.f323670a = atomicInteger;
            this.f323671b = atomicInteger2;
            this.f323672c = i3;
        }

        @Override // i83.g
        public void onFailed() {
            if (MagicStudioDataSource.E(this.f323672c, this.f323670a.incrementAndGet())) {
                if (this.f323671b.get() <= 0) {
                    MagicStudioDataSource.f323652a.u(true);
                    return;
                }
                w53.b.f("MagicStudioDataSource", "downloadUrlsAndSaveToSystem successCount = " + this.f323671b.get());
                MagicStudioDataSource.f323652a.u(false);
            }
        }

        @Override // i83.g
        public void onSuccess() {
            int incrementAndGet = this.f323670a.incrementAndGet();
            this.f323671b.incrementAndGet();
            if (MagicStudioDataSource.E(this.f323672c, incrementAndGet)) {
                w53.b.f("MagicStudioDataSource", "downloadUrlsAndSaveToSystem1 successCount = " + this.f323671b.get());
                MagicStudioDataSource.f323652a.u(false);
            }
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u001a\u0010\n\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016\u00a8\u0006\u000b"}, d2 = {"com/tencent/mobileqq/wink/magicstudio/MagicStudioDataSource$e", "Lorg/light/aigc/net/IGenerateCallback;", "Lorg/light/aigc/bean/AIGCContentOutput;", "output", "", "onSuccess", "", "errorCode", "", "errorMsg", "onError", "qq-wink-temp-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes21.dex */
    public static final class e implements IGenerateCallback {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ CancellableContinuation<Pair<? extends AIGCContentOutput, ? extends Map<String, String>>> f323673a;

        /* JADX WARN: Multi-variable type inference failed */
        e(CancellableContinuation<? super Pair<? extends AIGCContentOutput, ? extends Map<String, String>>> cancellableContinuation) {
            this.f323673a = cancellableContinuation;
        }

        @Override // org.light.aigc.net.IGenerateCallback
        public void onError(long errorCode, @Nullable String errorMsg) {
            w53.b.f("AIGCSDKHelper", "requestAigc onError: " + errorCode + ", errorMsg: " + errorMsg);
            if (this.f323673a.isActive() && !this.f323673a.isCancelled()) {
                CancellableContinuation<Pair<? extends AIGCContentOutput, ? extends Map<String, String>>> cancellableContinuation = this.f323673a;
                Result.Companion companion = Result.INSTANCE;
                cancellableContinuation.resumeWith(Result.m476constructorimpl(ResultKt.createFailure(new Exception(errorCode + "," + errorMsg))));
            }
        }

        @Override // org.light.aigc.net.IGenerateCallback
        public void onSuccess(@Nullable AIGCContentOutput output) {
            w53.b.f("AIGCSDKHelper", "requestAigc onSuccess:" + output);
            if (this.f323673a.isActive() && !this.f323673a.isCancelled()) {
                if (output == null) {
                    CancellableContinuation<Pair<? extends AIGCContentOutput, ? extends Map<String, String>>> cancellableContinuation = this.f323673a;
                    Result.Companion companion = Result.INSTANCE;
                    cancellableContinuation.resumeWith(Result.m476constructorimpl(ResultKt.createFailure(new RuntimeException("empty result"))));
                } else {
                    CancellableContinuation<Pair<? extends AIGCContentOutput, ? extends Map<String, String>>> cancellableContinuation2 = this.f323673a;
                    Result.Companion companion2 = Result.INSTANCE;
                    cancellableContinuation2.resumeWith(Result.m476constructorimpl(TuplesKt.to(output, MagicStudioDataSource.f323652a.b0(output.extra))));
                }
            }
        }
    }

    static {
        Lazy lazy;
        Lazy lazy2;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<String>() { // from class: com.tencent.mobileqq.wink.magicstudio.MagicStudioDataSource$dayPagPath$2
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final String invoke() {
                String I;
                I = MagicStudioDataSource.f323652a.I(false);
                return I;
            }
        });
        dayPagPath = lazy;
        lazy2 = LazyKt__LazyJVMKt.lazy(new Function0<String>() { // from class: com.tencent.mobileqq.wink.magicstudio.MagicStudioDataSource$nightPagPath$2
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final String invoke() {
                String I;
                I = MagicStudioDataSource.f323652a.I(true);
                return I;
            }
        });
        nightPagPath = lazy2;
        materialObserver = new Observer() { // from class: com.tencent.mobileqq.wink.magicstudio.g
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                MagicStudioDataSource.g((List) obj);
            }
        };
        pageInfoCallBacks = new ArrayList<>();
    }

    MagicStudioDataSource() {
    }

    private final void A(boolean isNight, String path) {
        String str;
        if (isNight) {
            str = "https://qq-video.cdn-go.cn/android/latest/darkmode/8953/qvideo_aigc_selection_loading.pag";
        } else {
            str = "https://qq-video.cdn-go.cn/android/latest/defaultmode/8953/qvideo_aigc_selection_loading.pag";
        }
        y53.a.c().a(str, path, new a());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void B(String url, String aigcImgCachePath, CancellableContinuation<? super String> it, boolean withMilestone, String milestoneTag) {
        y53.a.c().a(url, aigcImgCachePath, new b(it, withMilestone, milestoneTag, aigcImgCachePath));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean E(int i3, int i16) {
        if (i16 >= i3) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final MagicStudioServerStatusReq F() {
        ShadowAIGCServerStatus$GetServerStatusRequest shadowAIGCServerStatus$GetServerStatusRequest = new ShadowAIGCServerStatus$GetServerStatusRequest();
        shadowAIGCServerStatus$GetServerStatusRequest.busi_id.set(r93.h.f430993a.e());
        return new MagicStudioServerStatusReq(shadowAIGCServerStatus$GetServerStatusRequest);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String H(String url, String tag) {
        int lastIndexOf$default;
        String str;
        boolean z16;
        lastIndexOf$default = StringsKt__StringsKt.lastIndexOf$default((CharSequence) url, '.', 0, false, 6, (Object) null);
        if (lastIndexOf$default > 0) {
            str = url.substring(lastIndexOf$default);
            Intrinsics.checkNotNullExpressionValue(str, "this as java.lang.String).substring(startIndex)");
        } else {
            str = "";
        }
        int length = str.length();
        int i3 = 0;
        while (true) {
            if (i3 < length) {
                if (str.charAt(i3) == '?') {
                    z16 = true;
                } else {
                    z16 = false;
                }
                if (z16) {
                    break;
                }
                i3++;
            } else {
                i3 = -1;
                break;
            }
        }
        if (i3 != -1) {
            str = str.substring(0, i3);
            Intrinsics.checkNotNullExpressionValue(str, "this as java.lang.String\u2026ing(startIndex, endIndex)");
        }
        String L = L();
        File file = new File(L);
        if (!file.exists()) {
            file.mkdirs();
        }
        return L + "aigc_" + tag + str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String I(boolean isNight) {
        String str;
        if (isNight) {
            str = "night";
        } else {
            str = "isNight";
        }
        String L = L();
        File file = new File(L);
        if (!file.exists()) {
            file.mkdirs();
        }
        return L + "aigc_" + str + ".pag";
    }

    private final Object K(final int i3, Continuation<? super MagicStudioButtonInfo> continuation) {
        Continuation intercepted;
        Object coroutine_suspended;
        intercepted = IntrinsicsKt__IntrinsicsJvmKt.intercepted(continuation);
        final CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(intercepted, 1);
        cancellableContinuationImpl.initCancellability();
        final int j3 = w93.e.f445096a.j(new MagicStudioButtonReq(i3), new Function5<BaseRequest, Boolean, Long, String, ShadowAIGCStatus$GetStatusReply, Unit>() { // from class: com.tencent.mobileqq.wink.magicstudio.MagicStudioDataSource$getButtonInfoReply$2$seq$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(5);
            }

            @Override // kotlin.jvm.functions.Function5
            public /* bridge */ /* synthetic */ Unit invoke(BaseRequest baseRequest, Boolean bool, Long l3, String str, ShadowAIGCStatus$GetStatusReply shadowAIGCStatus$GetStatusReply) {
                invoke(baseRequest, bool.booleanValue(), l3.longValue(), str, shadowAIGCStatus$GetStatusReply);
                return Unit.INSTANCE;
            }

            public final void invoke(@NotNull BaseRequest baseRequest, boolean z16, long j16, @Nullable String str, @Nullable ShadowAIGCStatus$GetStatusReply shadowAIGCStatus$GetStatusReply) {
                MagicStudioButtonInfo magicStudioButtonInfo;
                Intrinsics.checkNotNullParameter(baseRequest, "<anonymous parameter 0>");
                if (shadowAIGCStatus$GetStatusReply != null && j16 == 0 && z16) {
                    if (i3 == 3) {
                        String str2 = shadowAIGCStatus$GetStatusReply.button_info.text.get();
                        Intrinsics.checkNotNullExpressionValue(str2, "rsp.button_info.text.get()");
                        String str3 = shadowAIGCStatus$GetStatusReply.button_info.description.get();
                        Intrinsics.checkNotNullExpressionValue(str3, "rsp.button_info.description.get()");
                        magicStudioButtonInfo = new MagicStudioButtonInfo(str2, str3, MagicStudioButtonInfo.INSTANCE.b(shadowAIGCStatus$GetStatusReply.button_info.type.get()), shadowAIGCStatus$GetStatusReply.button_info.detail.get(), false, 16, null);
                    } else {
                        String str4 = shadowAIGCStatus$GetStatusReply.button_info.text.get();
                        if (str4.length() == 0) {
                            str4 = "\u7acb\u5373\u521b\u4f5c";
                        }
                        String str5 = str4;
                        Intrinsics.checkNotNullExpressionValue(str5, "rsp.button_info.text.get().ifEmpty { \"\u7acb\u5373\u521b\u4f5c\" }");
                        String str6 = shadowAIGCStatus$GetStatusReply.button_info.description.get();
                        if (str6.length() == 0) {
                            str6 = "\u4eca\u5929\u673a\u4f1a\u8fd8\u52692\u6b21";
                        }
                        String str7 = str6;
                        Intrinsics.checkNotNullExpressionValue(str7, "rsp.button_info.descript\u2026().ifEmpty { \"\u4eca\u5929\u673a\u4f1a\u8fd8\u52692\u6b21\" }");
                        magicStudioButtonInfo = new MagicStudioButtonInfo(str5, str7, MagicStudioButtonInfo.INSTANCE.b(shadowAIGCStatus$GetStatusReply.button_info.type.get()), shadowAIGCStatus$GetStatusReply.button_info.detail.get(), false, 16, null);
                    }
                    cancellableContinuationImpl.resumeWith(Result.m476constructorimpl(magicStudioButtonInfo));
                    return;
                }
                MagicStudioDataSource.f323652a.l0(j16, str);
                CancellableContinuation<MagicStudioButtonInfo> cancellableContinuation = cancellableContinuationImpl;
                Result.Companion companion = Result.INSTANCE;
                cancellableContinuation.resumeWith(Result.m476constructorimpl(ResultKt.createFailure(new IllegalStateException("rsp invalid " + shadowAIGCStatus$GetStatusReply + " " + j16 + " " + z16))));
            }
        });
        cancellableContinuationImpl.invokeOnCancellation(new Function1<Throwable, Unit>() { // from class: com.tencent.mobileqq.wink.magicstudio.MagicStudioDataSource$getButtonInfoReply$2$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Throwable th5) {
                invoke2(th5);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@Nullable Throwable th5) {
                VSNetworkHelper.getInstance().cancelRequest(MobileQQ.sMobileQQ, j3);
            }
        });
        Object result = cancellableContinuationImpl.getResult();
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (result == coroutine_suspended) {
            DebugProbes.probeCoroutineSuspended(continuation);
        }
        return result;
    }

    private final String P() {
        return (String) dayPagPath.getValue();
    }

    public static /* synthetic */ String S(MagicStudioDataSource magicStudioDataSource, boolean z16, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            z16 = QQTheme.isNowThemeIsNight();
        }
        return magicStudioDataSource.R(z16);
    }

    private final String T() {
        return (String) nightPagPath.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void V() {
        BusinessHandler businessHandler = com.tencent.mobileqq.wink.b.a().getBusinessHandler(WinkRecommendDataServiceHandler.class.getName());
        Intrinsics.checkNotNull(businessHandler, "null cannot be cast to non-null type com.tencent.mobileqq.wink.launcher.network.WinkRecommendDataServiceHandler");
        ((WinkRecommendDataServiceHandler) businessHandler).m3("qzoneMagicStudio");
    }

    private final void W(List<MetaCategory> data) {
        String str;
        Map<String, String> additionalFields;
        Map<String, String> additionalFields2;
        boolean z16;
        String str2;
        String str3;
        boolean z17;
        boolean z18;
        if (data != null && !data.isEmpty()) {
            if (QzoneConfig.isNotSkipMagicStudioSafeCheck()) {
                str = "\u53d1\u8868\u54c1\u68c0\u540e\u83b7\u5f97\u539f\u56fe";
            } else {
                str = "\u53d1\u8868\u5e76\u4fdd\u5b58\u56fe\u7247";
            }
            String str4 = str;
            ArrayList arrayList = new ArrayList();
            ArrayList<com.tencent.mobileqq.wink.magicstudio.model.f> arrayList2 = new ArrayList();
            ArrayList arrayList3 = new ArrayList();
            ArrayList arrayList4 = new ArrayList();
            templateMap.clear();
            for (MetaCategory metaCategory : data) {
                if (Intrinsics.areEqual("styleExhibition", metaCategory.f30532id)) {
                    arrayList4.addAll(d0(this, metaCategory, false, false, 6, null));
                } else if (Intrinsics.areEqual("share", metaCategory.f30532id)) {
                    ArrayList<MetaMaterial> arrayList5 = metaCategory.materials;
                    Intrinsics.checkNotNullExpressionValue(arrayList5, "category.materials");
                    for (MetaMaterial metaMaterial : arrayList5) {
                        String str5 = metaMaterial.additionalFields.get("share_info");
                        if (str5 != null && str5.length() != 0) {
                            z16 = false;
                        } else {
                            z16 = true;
                        }
                        if (!z16) {
                            com.tencent.mobileqq.wink.magicstudio.model.h.f323788a.d(String.valueOf(metaMaterial.additionalFields.get("share_info")));
                        }
                    }
                } else if (Intrinsics.areEqual(AudienceReportConst.PROTOCOL, metaCategory.f30532id)) {
                    ArrayList<MetaMaterial> arrayList6 = metaCategory.materials;
                    Intrinsics.checkNotNullExpressionValue(arrayList6, "category.materials");
                    for (MetaMaterial metaMaterial2 : arrayList6) {
                        try {
                            Result.Companion companion = Result.INSTANCE;
                            StringBuilder sb5 = new StringBuilder();
                            JSONArray jSONArray = new JSONArray(metaMaterial2.additionalFields.get("protocol_content"));
                            int length = jSONArray.length() - 2;
                            if (length >= 0) {
                                int i3 = 0;
                                while (true) {
                                    sb5.append(jSONArray.get(i3) + "\n");
                                    if (i3 == length) {
                                        break;
                                    } else {
                                        i3++;
                                    }
                                }
                            }
                            com.tencent.mobileqq.wink.magicstudio.model.h hVar = com.tencent.mobileqq.wink.magicstudio.model.h.f323788a;
                            String sb6 = sb5.toString();
                            Intrinsics.checkNotNullExpressionValue(sb6, "stringBuilder.toString()");
                            hVar.b(sb6);
                            if (jSONArray.length() > 0) {
                                hVar.c(jSONArray.get(jSONArray.length() - 1).toString());
                            }
                            Result.m476constructorimpl(Unit.INSTANCE);
                        } catch (Throwable th5) {
                            Result.Companion companion2 = Result.INSTANCE;
                            Result.m476constructorimpl(ResultKt.createFailure(th5));
                        }
                    }
                } else if (Intrinsics.areEqual("template", metaCategory.f30532id)) {
                    ArrayList<MetaMaterial> arrayList7 = metaCategory.materials;
                    Intrinsics.checkNotNullExpressionValue(arrayList7, "category.materials");
                    for (MetaMaterial it : arrayList7) {
                        HashMap<String, MetaMaterial> hashMap = templateMap;
                        String str6 = it.f30533id;
                        Intrinsics.checkNotNullExpressionValue(str6, "it.id");
                        Intrinsics.checkNotNullExpressionValue(it, "it");
                        hashMap.put(str6, y53.b.b(it));
                        MetaMaterial metaMaterial3 = templateMap.get(it.f30533id);
                        if (metaMaterial3 != null) {
                            Intrinsics.checkNotNullExpressionValue(metaMaterial3, "templateMap[it.id]");
                            com.tencent.mobileqq.wink.editor.c.E1(metaMaterial3, str4);
                        }
                    }
                } else if (Intrinsics.areEqual("style", metaCategory.f30532id)) {
                    ArrayList<MetaMaterial> arrayList8 = metaCategory.materials;
                    Intrinsics.checkNotNullExpressionValue(arrayList8, "category.materials");
                    for (MetaMaterial metaMaterial4 : arrayList8) {
                        String id5 = metaMaterial4.f30533id;
                        String thumbUrl = metaMaterial4.thumbUrl;
                        String valueOf = String.valueOf(metaMaterial4.additionalFields.get("default_template_id"));
                        String valueOf2 = String.valueOf(metaMaterial4.additionalFields.get("default_prompt_tip"));
                        String valueOf3 = String.valueOf(metaMaterial4.additionalFields.get("default_prompt"));
                        String valueOf4 = String.valueOf(metaMaterial4.additionalFields.get("name"));
                        String str7 = metaMaterial4.additionalFields.get("default_publish_topic");
                        if (str7 == null) {
                            str2 = "";
                        } else {
                            str2 = str7;
                        }
                        String str8 = metaMaterial4.additionalFields.get("style_model_id");
                        if (str8 == null) {
                            str3 = "";
                        } else {
                            str3 = str8;
                        }
                        String str9 = metaMaterial4.additionalFields.get("support_mode");
                        if (str9 == null) {
                            str9 = "0";
                        }
                        Intrinsics.checkNotNullExpressionValue(id5, "id");
                        Intrinsics.checkNotNullExpressionValue(thumbUrl, "thumbUrl");
                        com.tencent.mobileqq.wink.magicstudio.model.f fVar = new com.tencent.mobileqq.wink.magicstudio.model.f(id5, valueOf, null, thumbUrl, valueOf2, valueOf3, valueOf4, str2, str3, false, false, str9, 1540, null);
                        fVar.y(fVar.r(String.valueOf(metaMaterial4.additionalFields.get("template_switch_map"))));
                        fVar.w(new ArrayList());
                        List<String> s16 = fVar.s(metaMaterial4.additionalFields.get("style_model_id_list"));
                        if (s16 != null) {
                            for (String str10 : s16) {
                                List<Pair<String, Integer>> h16 = fVar.h();
                                Intrinsics.checkNotNull(h16);
                                h16.add(TuplesKt.to(str10, 0));
                            }
                        }
                        if (fVar.h() != null) {
                            z17 = true;
                            if (!r8.isEmpty()) {
                                z18 = true;
                                fVar.t(z18);
                                arrayList2.add(fVar);
                            }
                        } else {
                            z17 = true;
                        }
                        z18 = false;
                        fVar.t(z18);
                        arrayList2.add(fVar);
                    }
                } else if (Intrinsics.areEqual("prompt_2", metaCategory.f30532id)) {
                    ArrayList<MetaMaterial> arrayList9 = metaCategory.materials;
                    Intrinsics.checkNotNullExpressionValue(arrayList9, "category.materials");
                    for (MetaMaterial metaMaterial5 : arrayList9) {
                        String str11 = metaMaterial5.f30533id;
                        Intrinsics.checkNotNullExpressionValue(str11, "it.id");
                        arrayList3.add(new MagicStudioPrompt(str11, String.valueOf(metaMaterial5.additionalFields.get("name")), String.valueOf(metaMaterial5.additionalFields.get("default_prompt_input")), String.valueOf(metaMaterial5.additionalFields.get("default_style_id"))));
                    }
                } else if (Intrinsics.areEqual("announcement", metaCategory.f30532id)) {
                    ArrayList<MetaMaterial> arrayList10 = metaCategory.materials;
                    Intrinsics.checkNotNullExpressionValue(arrayList10, "category.materials");
                    for (MetaMaterial metaMaterial6 : arrayList10) {
                        String str12 = metaMaterial6.f30533id;
                        Intrinsics.checkNotNullExpressionValue(str12, "it.id");
                        String valueOf5 = String.valueOf(metaMaterial6.additionalFields.get(QZoneDTLoginReporter.SCHEMA));
                        String str13 = metaMaterial6.showName;
                        Intrinsics.checkNotNullExpressionValue(str13, "it.showName");
                        arrayList.add(new MagicStudioTip(str12, valueOf5, str13, String.valueOf(metaMaterial6.additionalFields.get("topic"))));
                    }
                }
            }
            for (com.tencent.mobileqq.wink.magicstudio.model.f fVar2 : arrayList2) {
                if (templateMap.get(fVar2.getTemplateID()) == null) {
                    Iterator<T> it5 = pageInfoCallBacks.iterator();
                    while (it5.hasNext()) {
                        ((Function1) it5.next()).invoke(new PageInfoCallbackInfo(arrayList, arrayList2, arrayList3, arrayList4));
                    }
                } else {
                    Map<String, String> m3 = fVar2.m();
                    if (m3 != null) {
                        for (Map.Entry<String, String> entry : m3.entrySet()) {
                            fVar2.n().put(entry.getKey(), templateMap.get(entry.getValue()));
                        }
                    }
                    fVar2.x(templateMap.get(fVar2.getTemplateID()));
                    MetaMaterial template = fVar2.getTemplate();
                    if (template != null && (additionalFields2 = template.additionalFields) != null) {
                        Intrinsics.checkNotNullExpressionValue(additionalFields2, "additionalFields");
                        additionalFields2.put(QQWinkConstants.BUSINESS_MAIGC_STUDIO_STYLE_NAME, fVar2.getStyleName());
                    }
                    MetaMaterial template2 = fVar2.getTemplate();
                    if (template2 != null && (additionalFields = template2.additionalFields) != null) {
                        Intrinsics.checkNotNullExpressionValue(additionalFields, "additionalFields");
                        additionalFields.put(QQWinkConstants.BUSINESS_MAIGC_STUDIO, QQWinkConstants.BUSINESS_MAIGC_STUDIO);
                    }
                }
            }
            ArrayList<com.tencent.mobileqq.wink.magicstudio.model.f> arrayList11 = magicStudioStylesLocal;
            arrayList11.clear();
            arrayList11.addAll(arrayList2);
            Iterator<T> it6 = pageInfoCallBacks.iterator();
            while (it6.hasNext()) {
                ((Function1) it6.next()).invoke(new PageInfoCallbackInfo(arrayList, arrayList2, arrayList3, arrayList4));
            }
            return;
        }
        Iterator<T> it7 = pageInfoCallBacks.iterator();
        while (it7.hasNext()) {
            ((Function1) it7.next()).invoke(null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final synchronized void X() {
        try {
            if (aigcClient == null) {
                aigcClient = com.tencent.mobileqq.wink.aigc.utils.b.f317941a.i();
            }
        } finally {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Z(String aigcImgCachePath, final i83.g listener) {
        try {
            RFWSaveUtil.insertMedia(BaseApplication.context, aigcImgCachePath, new Consumer() { // from class: com.tencent.mobileqq.wink.magicstudio.k
                @Override // androidx.core.util.Consumer
                public final void accept(Object obj) {
                    MagicStudioDataSource.a0(i83.g.this, (RFWSaveMediaResultBean) obj);
                }
            });
        } catch (Exception e16) {
            w53.b.d("MagicStudioDataSource", "downloadUrlAndSaveToSystem save failed", e16);
            listener.onFailed();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a0(i83.g listener, RFWSaveMediaResultBean rFWSaveMediaResultBean) {
        Intrinsics.checkNotNullParameter(listener, "$listener");
        w53.b.a("MagicStudioDataSource", "saveMediaToSystem result " + rFWSaveMediaResultBean.isSuccess);
        if (rFWSaveMediaResultBean.isSuccess) {
            listener.onSuccess();
        } else {
            listener.onFailed();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Map<String, String> b0(String extra) {
        Map<String, String> emptyMap;
        try {
            JSONObject jSONObject = new JSONObject(extra);
            JSONObject optJSONObject = jSONObject.optJSONObject(QQWinkTempConstants.MAIGC_STUDIO_PUBLISH_TRANS);
            HashMap hashMap = new HashMap();
            String jSONObject2 = optJSONObject.toString();
            Intrinsics.checkNotNullExpressionValue(jSONObject2, "transferInfo.toString()");
            hashMap.put(QQWinkTempConstants.MAIGC_STUDIO_PUBLISH_TRANS, jSONObject2);
            String optString = jSONObject.optString(QQWinkTempConstants.MAIGC_STUDIO_AIGC_RESULT_REPORT_INFO);
            Intrinsics.checkNotNullExpressionValue(optString, "jsonObject.optString(MAI\u2026_AIGC_RESULT_REPORT_INFO)");
            hashMap.put(QQWinkTempConstants.MAIGC_STUDIO_AIGC_RESULT_REPORT_INFO, optString);
            return hashMap;
        } catch (Throwable th5) {
            w53.b.d("MagicStudioDataSource", "parseAigcExtra fail", th5);
            emptyMap = MapsKt__MapsKt.emptyMap();
            return emptyMap;
        }
    }

    public static /* synthetic */ List d0(MagicStudioDataSource magicStudioDataSource, MetaCategory metaCategory, boolean z16, boolean z17, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            z16 = true;
        }
        if ((i3 & 4) != 0) {
            z17 = true;
        }
        return magicStudioDataSource.c0(metaCategory, z16, z17);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int e0(MagicStudioPicStyle magicStudioPicStyle, MagicStudioPicStyle magicStudioPicStyle2) {
        if (magicStudioPicStyle.getPriority() <= magicStudioPicStyle2.getPriority()) {
            return -1;
        }
        return 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void g(List list) {
        f323652a.W(list);
    }

    private final void g0() {
        AIGCClient aIGCClient = aigcClient;
        if (aIGCClient != null) {
            aIGCClient.release();
        }
        aigcClient = null;
    }

    private final Object h0(AIGCRequest aIGCRequest, Continuation<? super Pair<? extends AIGCContentOutput, ? extends Map<String, String>>> continuation) {
        Continuation intercepted;
        Object coroutine_suspended;
        intercepted = IntrinsicsKt__IntrinsicsJvmKt.intercepted(continuation);
        CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(intercepted, 1);
        cancellableContinuationImpl.initCancellability();
        f323652a.X();
        AIGCClient aIGCClient = aigcClient;
        if (aIGCClient != null) {
            aIGCClient.generateAIGCContent(aIGCRequest, new e(cancellableContinuationImpl));
        }
        Object result = cancellableContinuationImpl.getResult();
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (result == coroutine_suspended) {
            DebugProbes.probeCoroutineSuspended(continuation);
        }
        return result;
    }

    public static /* synthetic */ void m0(MagicStudioDataSource magicStudioDataSource, long j3, String str, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            j3 = 0;
        }
        if ((i3 & 2) != 0) {
            str = null;
        }
        magicStudioDataSource.l0(j3, str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void n0(long j3, String str) {
        boolean z16;
        boolean z17;
        boolean z18;
        QQToast qQToast = qqToast;
        boolean z19 = true;
        if (qQToast != null && qQToast.isShowing()) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            return;
        }
        if (1000 <= j3 && j3 < 10000) {
            z17 = true;
        } else {
            z17 = false;
        }
        if (z17 || (j3 >= -9999 && j3 <= -1000)) {
            if (str != null && str.length() != 0) {
                z18 = false;
            } else {
                z18 = true;
            }
            if (!z18) {
                QQToast makeText = QQToast.makeText(BaseApplication.getContext(), str, 0);
                qqToast = makeText;
                if (makeText != null) {
                    makeText.show();
                    return;
                }
                return;
            }
        }
        if (str != null && str.length() != 0) {
            z19 = false;
        }
        if (z19) {
            QQToast makeText2 = QQToast.makeText(BaseApplication.getContext(), "\u9b54\u6cd5\u5931\u7075\u5566\uff0c\u8bf7\u7a0d\u540e\u518d\u8bd5\uff5e", 0);
            qqToast = makeText2;
            if (makeText2 != null) {
                makeText2.show();
                return;
            }
            return;
        }
        QQToast makeText3 = QQToast.makeText(BaseApplication.getContext(), str, 0);
        qqToast = makeText3;
        if (makeText3 != null) {
            makeText3.show();
        }
    }

    public static /* synthetic */ Object s(MagicStudioDataSource magicStudioDataSource, String str, boolean z16, String str2, Continuation continuation, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            z16 = false;
        }
        if ((i3 & 4) != 0) {
            str2 = null;
        }
        return magicStudioDataSource.r(str, z16, str2, continuation);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void u(boolean isError) {
        final String str;
        if (isError) {
            str = "\u56fe\u7247\u4fdd\u5b58\u5931\u8d25";
        } else {
            str = "\u56fe\u7247\u5df2\u4fdd\u5b58";
        }
        ThreadManagerV2.getUIHandlerV2().postDelayed(new Runnable() { // from class: com.tencent.mobileqq.wink.magicstudio.j
            @Override // java.lang.Runnable
            public final void run() {
                MagicStudioDataSource.v(str);
            }
        }, 200L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void v(String text) {
        Intrinsics.checkNotNullParameter(text, "$text");
        QQToast.makeText(BaseApplication.getContext(), text, 1).show();
    }

    private final Object x(String str, int i3, Continuation<? super ShadowAIGCStatus$DoActionReply> continuation) {
        Continuation intercepted;
        Object coroutine_suspended;
        intercepted = IntrinsicsKt__IntrinsicsJvmKt.intercepted(continuation);
        final CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(intercepted, 1);
        cancellableContinuationImpl.initCancellability();
        ShadowAIGCStatus$DoActionRequest shadowAIGCStatus$DoActionRequest = new ShadowAIGCStatus$DoActionRequest();
        shadowAIGCStatus$DoActionRequest.busi_id.set(str);
        shadowAIGCStatus$DoActionRequest.action.set(i3);
        final int j3 = w93.e.f445096a.j(new QQWinkAIGCDoActionReq(shadowAIGCStatus$DoActionRequest), new Function5<BaseRequest, Boolean, Long, String, ShadowAIGCStatus$DoActionReply, Unit>() { // from class: com.tencent.mobileqq.wink.magicstudio.MagicStudioDataSource$doActionNet$2$seq$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(5);
            }

            @Override // kotlin.jvm.functions.Function5
            public /* bridge */ /* synthetic */ Unit invoke(BaseRequest baseRequest, Boolean bool, Long l3, String str2, ShadowAIGCStatus$DoActionReply shadowAIGCStatus$DoActionReply) {
                invoke(baseRequest, bool.booleanValue(), l3.longValue(), str2, shadowAIGCStatus$DoActionReply);
                return Unit.INSTANCE;
            }

            public final void invoke(@NotNull BaseRequest baseRequest, boolean z16, long j16, @Nullable String str2, @Nullable ShadowAIGCStatus$DoActionReply shadowAIGCStatus$DoActionReply) {
                Intrinsics.checkNotNullParameter(baseRequest, "<anonymous parameter 0>");
                if (shadowAIGCStatus$DoActionReply != null && j16 == 0 && z16) {
                    cancellableContinuationImpl.resumeWith(Result.m476constructorimpl(shadowAIGCStatus$DoActionReply));
                    return;
                }
                if (!(str2 == null || str2.length() == 0)) {
                    MagicStudioDataSource.f323652a.l0(j16, str2);
                    CancellableContinuation<ShadowAIGCStatus$DoActionReply> cancellableContinuation = cancellableContinuationImpl;
                    Result.Companion companion = Result.INSTANCE;
                    cancellableContinuation.resumeWith(Result.m476constructorimpl(ResultKt.createFailure(new IllegalStateException("rsp invalid " + shadowAIGCStatus$DoActionReply + " " + j16 + " " + z16))));
                    return;
                }
                CancellableContinuation<ShadowAIGCStatus$DoActionReply> cancellableContinuation2 = cancellableContinuationImpl;
                Result.Companion companion2 = Result.INSTANCE;
                cancellableContinuation2.resumeWith(Result.m476constructorimpl(ResultKt.createFailure(new IllegalStateException("rsp invalid " + shadowAIGCStatus$DoActionReply + " " + j16 + " " + z16))));
            }
        });
        cancellableContinuationImpl.invokeOnCancellation(new Function1<Throwable, Unit>() { // from class: com.tencent.mobileqq.wink.magicstudio.MagicStudioDataSource$doActionNet$2$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Throwable th5) {
                invoke2(th5);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@Nullable Throwable th5) {
                VSNetworkHelper.getInstance().cancelRequest(MobileQQ.sMobileQQ, j3);
            }
        });
        Object result = cancellableContinuationImpl.getResult();
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (result == coroutine_suspended) {
            DebugProbes.probeCoroutineSuspended(continuation);
        }
        return result;
    }

    public static /* synthetic */ Object z(MagicStudioDataSource magicStudioDataSource, String str, boolean z16, String str2, Continuation continuation, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            z16 = false;
        }
        if ((i3 & 4) != 0) {
            str2 = null;
        }
        return magicStudioDataSource.y(str, z16, str2, continuation);
    }

    public final void C(int id5, @NotNull String url, @NotNull i83.g listener) {
        Intrinsics.checkNotNullParameter(url, "url");
        Intrinsics.checkNotNullParameter(listener, "listener");
        String H = H(url, "qrcode-" + System.currentTimeMillis() + id5);
        if (new File(H).exists()) {
            Z(H, listener);
        } else {
            y53.a.c().a(url, H, new c(H, listener));
        }
    }

    public final void D(@NotNull List<String> urls) {
        boolean z16;
        Intrinsics.checkNotNullParameter(urls, "urls");
        if (!NetworkUtil.isNetworkAvailable()) {
            u(true);
            return;
        }
        AtomicInteger atomicInteger = new AtomicInteger(0);
        AtomicInteger atomicInteger2 = new AtomicInteger(0);
        int size = urls.size();
        int i3 = 0;
        for (Object obj : urls) {
            int i16 = i3 + 1;
            if (i3 < 0) {
                CollectionsKt__CollectionsKt.throwIndexOverflow();
            }
            String str = (String) obj;
            if (str != null && str.length() != 0) {
                z16 = false;
            } else {
                z16 = true;
            }
            if (!z16) {
                f323652a.C(i3, str, new d(atomicInteger2, atomicInteger, size));
            }
            i3 = i16;
        }
    }

    @NotNull
    public final MutableLiveData<List<GenerateInfo>> G() {
        return aigcGenerateLiveData;
    }

    @Nullable
    public final Object J(int i3, @NotNull Continuation<? super MagicStudioButtonInfo> continuation) {
        return K(i3, continuation);
    }

    @NotNull
    public final String L() {
        String str = u53.e.f438384a + "/opening_ending_cache/";
        File file = new File(str);
        if (!file.exists()) {
            file.mkdirs();
        }
        return str;
    }

    @NotNull
    public final MutableLiveData<Unit> M() {
        return cancelToNext;
    }

    @Nullable
    public final String N(@NotNull String path) {
        Intrinsics.checkNotNullParameter(path, "path");
        return an.e(an.f326680a, path, 1920, 90, false, 8, null);
    }

    @Nullable
    public final Object O(@NotNull String str, @NotNull Continuation<? super String> continuation) {
        return BuildersKt.withContext(Dispatchers.getIO(), new MagicStudioDataSource$getCompressPathByAsync$2(str, null), continuation);
    }

    @Nullable
    public final JumpInfo Q() {
        return jumpInfo;
    }

    @NotNull
    public final String R(boolean isNight) {
        String P;
        if (isNight) {
            P = T();
        } else {
            P = P();
        }
        if (!new File(P).exists()) {
            A(isNight, P);
        }
        return P;
    }

    public final void U() {
        if (!NetworkUtil.isNetworkAvailable()) {
            Iterator<T> it = pageInfoCallBacks.iterator();
            while (it.hasNext()) {
                ((Function1) it.next()).invoke(null);
            }
            return;
        }
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.wink.magicstudio.h
            @Override // java.lang.Runnable
            public final void run() {
                MagicStudioDataSource.V();
            }
        }, 128, null, false);
    }

    public final boolean Y(@NotNull String path) {
        Intrinsics.checkNotNullParameter(path, "path");
        try {
            return com.tencent.mobileqq.wink.utils.f.l(path);
        } catch (Exception unused) {
            return true;
        }
    }

    @NotNull
    public final List<MagicStudioPicStyle> c0(@NotNull MetaCategory category, boolean limitMaterialSize, boolean sortMaterials) {
        Intrinsics.checkNotNullParameter(category, "category");
        ArrayList arrayList = new ArrayList();
        ArrayList<MagicStudioPicStyle> arrayList2 = new ArrayList();
        ArrayList<MagicStudioPicStyle> arrayList3 = new ArrayList();
        ArrayList<MetaMaterial> arrayList4 = category.materials;
        Intrinsics.checkNotNullExpressionValue(arrayList4, "category.materials");
        for (MetaMaterial it : arrayList4) {
            MagicStudioPicStyle.Companion companion = MagicStudioPicStyle.INSTANCE;
            Intrinsics.checkNotNullExpressionValue(it, "it");
            MagicStudioPicStyle a16 = companion.a(it, category);
            if (sortMaterials) {
                if (com.tencent.mobileqq.wink.editor.c.h0(it) == 0) {
                    arrayList3.add(a16);
                } else {
                    arrayList2.add(a16);
                }
            } else {
                arrayList.add(a16);
            }
        }
        if (!sortMaterials) {
            return arrayList;
        }
        Collections.sort(arrayList2, new Comparator() { // from class: com.tencent.mobileqq.wink.magicstudio.l
            @Override // java.util.Comparator
            public final int compare(Object obj, Object obj2) {
                int e06;
                e06 = MagicStudioDataSource.e0((MagicStudioPicStyle) obj, (MagicStudioPicStyle) obj2);
                return e06;
            }
        });
        for (MagicStudioPicStyle magicStudioPicStyle : arrayList2) {
            if (!limitMaterialSize || arrayList.size() < 8) {
                arrayList.add(magicStudioPicStyle);
            }
        }
        for (MagicStudioPicStyle magicStudioPicStyle2 : arrayList3) {
            if (!limitMaterialSize || arrayList.size() < 8) {
                arrayList.add(magicStudioPicStyle2);
            }
        }
        return arrayList;
    }

    public final void f0(@NotNull Function1<? super PageInfoCallbackInfo, Unit> callback) {
        Intrinsics.checkNotNullParameter(callback, "callback");
        ArrayList<Function1<PageInfoCallbackInfo, Unit>> arrayList = pageInfoCallBacks;
        if (arrayList.size() == 0) {
            WinkEditorResourceManager.a1().C1().observeForever(materialObserver);
        }
        arrayList.add(callback);
    }

    @Nullable
    public final Object i0(@NotNull AIGCRequest aIGCRequest, @NotNull Continuation<? super Pair<? extends AIGCContentOutput, ? extends Map<String, String>>> continuation) {
        return h0(aIGCRequest, continuation);
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x003b  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x002c  */
    @Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object j0(@NotNull String str, @NotNull String str2, @NotNull String str3, @NotNull String str4, @Nullable Integer num, boolean z16, @NotNull Continuation<? super Pair<? extends AIGCContentOutput, ? extends Map<String, String>>> continuation) {
        MagicStudioDataSource$requestMakeAigc$1 magicStudioDataSource$requestMakeAigc$1;
        Object coroutine_suspended;
        int i3;
        if (continuation instanceof MagicStudioDataSource$requestMakeAigc$1) {
            magicStudioDataSource$requestMakeAigc$1 = (MagicStudioDataSource$requestMakeAigc$1) continuation;
            int i16 = magicStudioDataSource$requestMakeAigc$1.label;
            if ((i16 & Integer.MIN_VALUE) != 0) {
                magicStudioDataSource$requestMakeAigc$1.label = i16 - Integer.MIN_VALUE;
                Object obj = magicStudioDataSource$requestMakeAigc$1.result;
                coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i3 = magicStudioDataSource$requestMakeAigc$1.label;
                if (i3 == 0) {
                    if (i3 == 1) {
                        ResultKt.throwOnFailure(obj);
                    } else {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                } else {
                    ResultKt.throwOnFailure(obj);
                    ((IPrefRecorder) QRoute.api(IPrefRecorder.class)).milestone(IPrefRecorder.MILESTONE_MAGIC_GALLERY_MIN_GENERATE_IMAGE);
                    AIGCRequest g16 = com.tencent.mobileqq.wink.aigc.utils.b.f317941a.g(r93.h.f430993a.e(), str, str2, str3, str4, num, z16);
                    magicStudioDataSource$requestMakeAigc$1.label = 1;
                    obj = h0(g16, magicStudioDataSource$requestMakeAigc$1);
                    if (obj == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                }
                Pair pair = (Pair) obj;
                ((IPrefRecorder) QRoute.api(IPrefRecorder.class)).milestoneEnd(IPrefRecorder.MILESTONE_MAGIC_GALLERY_MIN_GENERATE_IMAGE);
                return pair;
            }
        }
        magicStudioDataSource$requestMakeAigc$1 = new MagicStudioDataSource$requestMakeAigc$1(this, continuation);
        Object obj2 = magicStudioDataSource$requestMakeAigc$1.result;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i3 = magicStudioDataSource$requestMakeAigc$1.label;
        if (i3 == 0) {
        }
        Pair pair2 = (Pair) obj2;
        ((IPrefRecorder) QRoute.api(IPrefRecorder.class)).milestoneEnd(IPrefRecorder.MILESTONE_MAGIC_GALLERY_MIN_GENERATE_IMAGE);
        return pair2;
    }

    public final void k0(@Nullable JumpInfo jumpInfo2) {
        jumpInfo = jumpInfo2;
    }

    public final void l0(final long code, @Nullable final String errorMsg) {
        ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.mobileqq.wink.magicstudio.i
            @Override // java.lang.Runnable
            public final void run() {
                MagicStudioDataSource.n0(code, errorMsg);
            }
        });
    }

    /* JADX WARN: Code restructure failed: missing block: B:5:0x000c, code lost:
    
        r8 = kotlin.text.StringsKt__StringsKt.split$default((java.lang.CharSequence) r1, new java.lang.String[]{","}, false, 0, 6, (java.lang.Object) null);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void o0(@NotNull Throwable it) {
        List emptyList;
        Intrinsics.checkNotNullParameter(it, "it");
        try {
            String message = it.getMessage();
            if (message == null || emptyList == null) {
                emptyList = CollectionsKt__CollectionsKt.emptyList();
            }
            if (emptyList.size() == 2) {
                l0(Long.parseLong((String) emptyList.get(0)), (String) emptyList.get(1));
            }
        } catch (Exception unused) {
            l0(0L, "");
        }
    }

    @Nullable
    public final Object p0(@NotNull String str, @NotNull Continuation<? super String> continuation) {
        Continuation intercepted;
        Object coroutine_suspended;
        intercepted = IntrinsicsKt__IntrinsicsJvmKt.intercepted(continuation);
        final CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(intercepted, 1);
        cancellableContinuationImpl.initCancellability();
        final int j3 = w93.e.f445096a.j(com.tencent.mobileqq.wink.aigc.utils.b.f317941a.e(r93.h.f430993a.e(), str), new Function5<BaseRequest, Boolean, Long, String, ShadowAIGCSafe$SafeCheckReply, Unit>() { // from class: com.tencent.mobileqq.wink.magicstudio.MagicStudioDataSource$triggerSafe$2$seq$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(5);
            }

            @Override // kotlin.jvm.functions.Function5
            public /* bridge */ /* synthetic */ Unit invoke(BaseRequest baseRequest, Boolean bool, Long l3, String str2, ShadowAIGCSafe$SafeCheckReply shadowAIGCSafe$SafeCheckReply) {
                invoke(baseRequest, bool.booleanValue(), l3.longValue(), str2, shadowAIGCSafe$SafeCheckReply);
                return Unit.INSTANCE;
            }

            public final void invoke(@NotNull BaseRequest baseRequest, boolean z16, long j16, @Nullable String str2, @Nullable ShadowAIGCSafe$SafeCheckReply shadowAIGCSafe$SafeCheckReply) {
                Intrinsics.checkNotNullParameter(baseRequest, "<anonymous parameter 0>");
                if (shadowAIGCSafe$SafeCheckReply != null && j16 == 0 && z16) {
                    String str3 = shadowAIGCSafe$SafeCheckReply.msg_id.get();
                    if (str3 == null || str3.length() == 0) {
                        QQToast.makeText(BaseApplication.getContext(), "\u5b89\u5168\u63a5\u53e3ID\u4e3a\u7a7a", 0).show();
                    }
                    CancellableContinuation<String> cancellableContinuation = cancellableContinuationImpl;
                    Result.Companion companion = Result.INSTANCE;
                    cancellableContinuation.resumeWith(Result.m476constructorimpl(shadowAIGCSafe$SafeCheckReply.msg_id.get()));
                    return;
                }
                CancellableContinuation<String> cancellableContinuation2 = cancellableContinuationImpl;
                Result.Companion companion2 = Result.INSTANCE;
                cancellableContinuation2.resumeWith(Result.m476constructorimpl(ResultKt.createFailure(new IllegalStateException("rsp invalid " + shadowAIGCSafe$SafeCheckReply + " " + j16 + " " + str2 + " " + z16))));
            }
        });
        cancellableContinuationImpl.invokeOnCancellation(new Function1<Throwable, Unit>() { // from class: com.tencent.mobileqq.wink.magicstudio.MagicStudioDataSource$triggerSafe$2$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Throwable th5) {
                invoke2(th5);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@Nullable Throwable th5) {
                VSNetworkHelper.getInstance().cancelRequest(MobileQQ.sMobileQQ, j3);
            }
        });
        Object result = cancellableContinuationImpl.getResult();
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (result == coroutine_suspended) {
            DebugProbes.probeCoroutineSuspended(continuation);
        }
        return result;
    }

    @Nullable
    public final Object q0(@NotNull Continuation<? super Pair<Integer, Integer>> continuation) {
        Continuation intercepted;
        Object coroutine_suspended;
        intercepted = IntrinsicsKt__IntrinsicsJvmKt.intercepted(continuation);
        final CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(intercepted, 1);
        cancellableContinuationImpl.initCancellability();
        ((IPrefRecorder) QRoute.api(IPrefRecorder.class)).milestone(IPrefRecorder.MILESTONE_MAGIC_GALLERY_REQUEST_COUNT);
        final int j3 = w93.e.f445096a.j(f323652a.F(), new Function5<BaseRequest, Boolean, Long, String, ShadowAIGCServerStatus$GetServerStatusReply, Unit>() { // from class: com.tencent.mobileqq.wink.magicstudio.MagicStudioDataSource$triggerServerStatus$2$seq$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(5);
            }

            @Override // kotlin.jvm.functions.Function5
            public /* bridge */ /* synthetic */ Unit invoke(BaseRequest baseRequest, Boolean bool, Long l3, String str, ShadowAIGCServerStatus$GetServerStatusReply shadowAIGCServerStatus$GetServerStatusReply) {
                invoke(baseRequest, bool.booleanValue(), l3.longValue(), str, shadowAIGCServerStatus$GetServerStatusReply);
                return Unit.INSTANCE;
            }

            public final void invoke(@NotNull BaseRequest baseRequest, boolean z16, long j16, @Nullable String str, @Nullable ShadowAIGCServerStatus$GetServerStatusReply shadowAIGCServerStatus$GetServerStatusReply) {
                Intrinsics.checkNotNullParameter(baseRequest, "<anonymous parameter 0>");
                ((IPrefRecorder) QRoute.api(IPrefRecorder.class)).milestoneEnd(IPrefRecorder.MILESTONE_MAGIC_GALLERY_REQUEST_COUNT);
                if (shadowAIGCServerStatus$GetServerStatusReply != null && j16 == 0 && z16) {
                    int i3 = shadowAIGCServerStatus$GetServerStatusReply.capacity.get();
                    int i16 = shadowAIGCServerStatus$GetServerStatusReply.collection_capacity.get();
                    CancellableContinuation<Pair<Integer, Integer>> cancellableContinuation = cancellableContinuationImpl;
                    Result.Companion companion = Result.INSTANCE;
                    cancellableContinuation.resumeWith(Result.m476constructorimpl(TuplesKt.to(Integer.valueOf(i3), Integer.valueOf(i16))));
                    return;
                }
                CancellableContinuation<Pair<Integer, Integer>> cancellableContinuation2 = cancellableContinuationImpl;
                Result.Companion companion2 = Result.INSTANCE;
                cancellableContinuation2.resumeWith(Result.m476constructorimpl(ResultKt.createFailure(new IllegalStateException("rsp invalid " + shadowAIGCServerStatus$GetServerStatusReply + " " + j16 + " " + str + " " + z16))));
            }
        });
        cancellableContinuationImpl.invokeOnCancellation(new Function1<Throwable, Unit>() { // from class: com.tencent.mobileqq.wink.magicstudio.MagicStudioDataSource$triggerServerStatus$2$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Throwable th5) {
                invoke2(th5);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@Nullable Throwable th5) {
                VSNetworkHelper.getInstance().cancelRequest(MobileQQ.sMobileQQ, j3);
            }
        });
        Object result = cancellableContinuationImpl.getResult();
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (result == coroutine_suspended) {
            DebugProbes.probeCoroutineSuspended(continuation);
        }
        return result;
    }

    @Nullable
    public final Object r(@NotNull String str, boolean z16, @Nullable String str2, @NotNull Continuation<? super String> continuation) {
        Continuation intercepted;
        Object coroutine_suspended;
        intercepted = IntrinsicsKt__IntrinsicsJvmKt.intercepted(continuation);
        CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(intercepted, 1);
        cancellableContinuationImpl.initCancellability();
        MagicStudioDataSource magicStudioDataSource = f323652a;
        String d16 = com.tencent.open.base.g.d(str);
        Intrinsics.checkNotNullExpressionValue(d16, "toMD5(url)");
        String H = magicStudioDataSource.H(str, d16);
        if (z16) {
            ((IPrefRecorder) QRoute.api(IPrefRecorder.class)).milestone(str2);
        }
        if (!new File(H).exists()) {
            magicStudioDataSource.B(str, H, cancellableContinuationImpl, z16, str2);
        } else {
            cancellableContinuationImpl.resumeWith(Result.m476constructorimpl(H));
        }
        Object result = cancellableContinuationImpl.getResult();
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (result == coroutine_suspended) {
            DebugProbes.probeCoroutineSuspended(continuation);
        }
        return result;
    }

    public final void t() {
        WinkEditorResourceManager.a1().C1().removeObserver(materialObserver);
        pageInfoCallBacks.clear();
        g0();
    }

    @Nullable
    public final Object w(int i3, @NotNull Continuation<? super ShadowAIGCStatus$DoActionReply> continuation) {
        return x(r93.h.f430993a.e(), i3, continuation);
    }

    @Nullable
    public final Object y(@NotNull String str, boolean z16, @Nullable String str2, @NotNull Continuation<? super String> continuation) {
        Continuation intercepted;
        Object coroutine_suspended;
        intercepted = IntrinsicsKt__IntrinsicsJvmKt.intercepted(continuation);
        CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(intercepted, 1);
        cancellableContinuationImpl.initCancellability();
        MagicStudioDataSource magicStudioDataSource = f323652a;
        String H = magicStudioDataSource.H(str, String.valueOf(System.nanoTime()));
        if (z16) {
            ((IPrefRecorder) QRoute.api(IPrefRecorder.class)).milestone(str2);
        }
        magicStudioDataSource.B(str, H, cancellableContinuationImpl, z16, str2);
        Object result = cancellableContinuationImpl.getResult();
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (result == coroutine_suspended) {
            DebugProbes.probeCoroutineSuspended(continuation);
        }
        return result;
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016\u00a8\u0006\t"}, d2 = {"com/tencent/mobileqq/wink/magicstudio/MagicStudioDataSource$a", "Ly53/a$a;", "Lcom/tencent/mobileqq/transfile/NetResp;", "resp", "", "a", "", "progress", "onProgressUpdate", "qq-wink-temp-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes21.dex */
    public static final class a implements a.InterfaceC11592a {
        a() {
        }

        @Override // y53.a.InterfaceC11592a
        public void a(@Nullable NetResp resp) {
        }

        @Override // y53.a.InterfaceC11592a
        public void onProgressUpdate(int progress) {
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016\u00a8\u0006\t"}, d2 = {"com/tencent/mobileqq/wink/magicstudio/MagicStudioDataSource$b", "Ly53/a$a;", "Lcom/tencent/mobileqq/transfile/NetResp;", "resp", "", "a", "", "progress", "onProgressUpdate", "qq-wink-temp-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes21.dex */
    public static final class b implements a.InterfaceC11592a {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ CancellableContinuation<String> f323664a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ boolean f323665b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ String f323666c;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ String f323667d;

        /* JADX WARN: Multi-variable type inference failed */
        b(CancellableContinuation<? super String> cancellableContinuation, boolean z16, String str, String str2) {
            this.f323664a = cancellableContinuation;
            this.f323665b = z16;
            this.f323666c = str;
            this.f323667d = str2;
        }

        @Override // y53.a.InterfaceC11592a
        public void a(@Nullable NetResp resp) {
            if (this.f323664a.isActive() && !this.f323664a.isCancelled()) {
                if (resp != null && resp.mResult == 0) {
                    if (this.f323665b) {
                        ((IPrefRecorder) QRoute.api(IPrefRecorder.class)).milestoneEnd(this.f323666c);
                    }
                    CancellableContinuation<String> cancellableContinuation = this.f323664a;
                    Result.Companion companion = Result.INSTANCE;
                    cancellableContinuation.resumeWith(Result.m476constructorimpl(this.f323667d));
                    return;
                }
                CancellableContinuation<String> cancellableContinuation2 = this.f323664a;
                Result.Companion companion2 = Result.INSTANCE;
                cancellableContinuation2.resumeWith(Result.m476constructorimpl(ResultKt.createFailure(new IllegalStateException("download fail"))));
            }
        }

        @Override // y53.a.InterfaceC11592a
        public void onProgressUpdate(int progress) {
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016\u00a8\u0006\t"}, d2 = {"com/tencent/mobileqq/wink/magicstudio/MagicStudioDataSource$c", "Ly53/a$a;", "Lcom/tencent/mobileqq/transfile/NetResp;", "resp", "", "a", "", "progress", "onProgressUpdate", "qq-wink-temp-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes21.dex */
    public static final class c implements a.InterfaceC11592a {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f323668a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ i83.g f323669b;

        c(String str, i83.g gVar) {
            this.f323668a = str;
            this.f323669b = gVar;
        }

        @Override // y53.a.InterfaceC11592a
        public void a(@Nullable NetResp resp) {
            if (resp != null && resp.mResult == 0) {
                MagicStudioDataSource.f323652a.Z(this.f323668a, this.f323669b);
            } else {
                this.f323669b.onFailed();
            }
        }

        @Override // y53.a.InterfaceC11592a
        public void onProgressUpdate(int progress) {
        }
    }
}

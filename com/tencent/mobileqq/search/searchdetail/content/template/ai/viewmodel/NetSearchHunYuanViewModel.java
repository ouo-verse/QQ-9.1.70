package com.tencent.mobileqq.search.searchdetail.content.template.ai.viewmodel;

import androidx.exifinterface.media.ExifInterface;
import androidx.lifecycle.MediatorLiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelKt;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.ViewModelStoreOwner;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.eventbus.SimpleEventReceiver;
import com.tencent.bugly.common.constants.Constants;
import com.tencent.intervideo.nowproxy.NowProxyConstants;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.guild.util.Logger;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.search.searchdetail.content.template.ai.depositary.NetSearchHunYuanDepositary;
import com.tencent.mobileqq.search.searchdetail.content.template.ai.viewmodel.b;
import com.tencent.mobileqq.search.searchdetail.eventbus.ContentScrollStateChangeEvent;
import com.tencent.mobileqq.search.util.af;
import com.tencent.mobileqq.search.util.ah;
import com.tencent.mobileqq.search.util.n;
import com.tencent.mobileqq.search.util.p;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qaddefine.QAdReportDefine$AdReporterParams;
import com.tencent.mobileqq.utils.PackageUtil;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.opentelemetry.semconv.trace.attributes.SemanticAttributes;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.tvkplayer.tools.utils.TVKCommonParamEnum;
import com.tencent.qqnt.kernel.nativeinterface.ICheckAIAuthCallback;
import com.tencent.qqnt.kernel.nativeinterface.SearchAICard;
import com.tencent.qqnt.kernel.nativeinterface.SearchListDetail;
import com.tencent.qqnt.kernel.nativeinterface.SearchModelInfo;
import com.tencent.qqnt.kernel.nativeinterface.SearchOpenSourceInfo;
import com.tencent.qqnt.kernel.nativeinterface.UfsCheckAIAuthRsp;
import com.tencent.rmonitor.custom.ICustomDataEditor;
import com.tencent.util.QQToastUtil;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u00c0\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b!\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0014\u0018\u0000 \u00ac\u00012\u00020\u00012\u00020\u00022\b\u0012\u0004\u0012\u00020\u00040\u00032\u00020\u0005:\u0002\u00ad\u0001B#\u0012\u0006\u0010\\\u001a\u00020W\u0012\u0006\u0010a\u001a\u00020\r\u0012\b\b\u0002\u0010f\u001a\u00020\u001c\u00a2\u0006\u0006\b\u00aa\u0001\u0010\u00ab\u0001J\b\u0010\u0007\u001a\u00020\u0006H\u0002J\b\u0010\b\u001a\u00020\u0006H\u0002J\b\u0010\t\u001a\u00020\u0006H\u0002J\b\u0010\n\u001a\u00020\u0006H\u0002J\b\u0010\u000b\u001a\u00020\u0006H\u0002J\b\u0010\f\u001a\u00020\u0006H\u0002J\u0010\u0010\u000f\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\rH\u0002J\u0010\u0010\u0011\u001a\u00020\u00062\u0006\u0010\u0010\u001a\u00020\rH\u0002J\u0010\u0010\u0013\u001a\u00020\u00062\u0006\u0010\u0012\u001a\u00020\rH\u0002J\u0018\u0010\u0018\u001a\u00020\u00062\u0006\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0017\u001a\u00020\u0016H\u0002J\u0016\u0010\u001b\u001a\u00020\u00062\f\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00060\u0019H\u0002J$\u0010 \u001a\u00020\u00062\u0006\u0010\u001d\u001a\u00020\u001c2\b\b\u0002\u0010\u001e\u001a\u00020\r2\b\b\u0002\u0010\u001f\u001a\u00020\rH\u0002J\b\u0010!\u001a\u00020\u0006H\u0002J\u0010\u0010#\u001a\u00020\u00062\u0006\u0010\"\u001a\u00020\rH\u0002J\"\u0010*\u001a\u00020\u00062\f\u0010&\u001a\b\u0012\u0004\u0012\u00020%0$2\n\u0010)\u001a\u00060'j\u0002`(H\u0002J\b\u0010+\u001a\u00020\u0006H\u0002J\u0010\u0010.\u001a\u00020\u00062\u0006\u0010-\u001a\u00020,H\u0002J\b\u0010/\u001a\u00020,H\u0002J\u0010\u00102\u001a\u00020\u00062\u0006\u00101\u001a\u000200H\u0002J\u0006\u00103\u001a\u00020\rJ\u000f\u00104\u001a\u0004\u0018\u00010\u001c\u00a2\u0006\u0004\b4\u00105J\u0006\u00107\u001a\u000206J\u0012\u00109\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\r08J\u0006\u0010:\u001a\u00020\u0006J\b\u0010<\u001a\u00020;H\u0016J\u0006\u0010=\u001a\u00020\rJ\u000e\u0010?\u001a\u00020\u00062\u0006\u0010>\u001a\u00020\u0014J\u0006\u0010@\u001a\u00020\u0006J\u000e\u0010A\u001a\u00020\u00062\u0006\u0010-\u001a\u00020,J\u0006\u0010B\u001a\u00020\u0006J\u0014\u0010C\u001a\u00020\u00062\f\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00060\u0019J\u0016\u0010E\u001a\u00020\u00062\f\u0010D\u001a\b\u0012\u0004\u0012\u00020%0$H\u0016J\u0018\u0010G\u001a\u00020\u00062\u0006\u0010F\u001a\u00020\r2\u0006\u0010\u0012\u001a\u00020\rH\u0016J\u0010\u0010H\u001a\u00020\u00062\u0006\u0010>\u001a\u000206H\u0016J \u0010J\u001a\u00020\u00062\u0006\u0010I\u001a\u00020\r2\u0006\u0010\u001e\u001a\u00020\r2\u0006\u0010\u001f\u001a\u00020\rH\u0016J\u0010\u0010L\u001a\u00020\u00062\u0006\u0010K\u001a\u00020\rH\u0016J\b\u0010M\u001a\u00020\u0006H\u0016J\b\u0010N\u001a\u00020\u0006H\u0016J\u0006\u0010O\u001a\u00020,J\u000e\u0010P\u001a\u00020\u00062\u0006\u0010-\u001a\u00020,J\u0006\u0010Q\u001a\u00020,J\u0012\u0010S\u001a\u00020\u00062\b\u0010R\u001a\u0004\u0018\u00010\u0004H\u0016J\u0014\u0010V\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040U0TH\u0016R\u0017\u0010\\\u001a\u00020W8\u0006\u00a2\u0006\f\n\u0004\bX\u0010Y\u001a\u0004\bZ\u0010[R\u0017\u0010a\u001a\u00020\r8\u0006\u00a2\u0006\f\n\u0004\b]\u0010^\u001a\u0004\b_\u0010`R\u0017\u0010f\u001a\u00020\u001c8\u0006\u00a2\u0006\f\n\u0004\bb\u0010c\u001a\u0004\bd\u0010eR\u0016\u0010i\u001a\u00020;8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bg\u0010hR\u0016\u0010m\u001a\u00020j8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bk\u0010lR%\u0010t\u001a\u0010\u0012\f\u0012\n o*\u0004\u0018\u00010,0,0n8\u0006\u00a2\u0006\f\n\u0004\bp\u0010q\u001a\u0004\br\u0010sR%\u0010w\u001a\u0010\u0012\f\u0012\n o*\u0004\u0018\u00010,0,0n8\u0006\u00a2\u0006\f\n\u0004\bu\u0010q\u001a\u0004\bv\u0010sR%\u0010z\u001a\u0010\u0012\f\u0012\n o*\u0004\u0018\u00010\r0\r0n8\u0006\u00a2\u0006\f\n\u0004\bx\u0010q\u001a\u0004\by\u0010sR%\u0010|\u001a\u0010\u0012\f\u0012\n o*\u0004\u0018\u00010,0,0n8\u0006\u00a2\u0006\f\n\u0004\bc\u0010q\u001a\u0004\b{\u0010sR2\u0010\u0081\u0001\u001a\u0010\u0012\f\u0012\n o*\u0004\u0018\u00010\r0\r0n8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0013\n\u0004\b}\u0010q\u001a\u0004\b~\u0010s\"\u0005\b\u007f\u0010\u0080\u0001R\u0019\u0010\u0084\u0001\u001a\u0002068\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u0082\u0001\u0010\u0083\u0001R\u0018\u0010\u0086\u0001\u001a\u00020\r8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0007\n\u0005\b\u0085\u0001\u0010^R\u001e\u0010\u0088\u0001\u001a\b\u0012\u0004\u0012\u00020\u001c0n8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0007\n\u0005\b\u0087\u0001\u0010qR%\u0010\u008b\u0001\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\r088\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u0089\u0001\u0010\u008a\u0001R$\u0010\u008d\u0001\u001a\u0010\u0012\f\u0012\n o*\u0004\u0018\u00010\r0\r0n8\u0002X\u0082\u0004\u00a2\u0006\u0007\n\u0005\b\u008c\u0001\u0010qR$\u0010\u008f\u0001\u001a\u0010\u0012\f\u0012\n o*\u0004\u0018\u00010\r0\r0n8\u0002X\u0082\u0004\u00a2\u0006\u0007\n\u0005\b\u008e\u0001\u0010qR\u001c\u0010\u0093\u0001\u001a\u0005\u0018\u00010\u0090\u00018\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u0091\u0001\u0010\u0092\u0001R#\u0010\u0099\u0001\u001a\n\u0012\u0005\u0012\u00030\u0095\u00010\u0094\u00018\u0006\u00a2\u0006\u000f\n\u0005\bE\u0010\u0096\u0001\u001a\u0006\b\u0097\u0001\u0010\u0098\u0001R\u0018\u0010\u009d\u0001\u001a\u00030\u009a\u00018\u0002X\u0082\u0004\u00a2\u0006\b\n\u0006\b\u009b\u0001\u0010\u009c\u0001R(\u0010\u00a0\u0001\u001a\u0010\u0012\f\u0012\n o*\u0004\u0018\u00010,0,0n8\u0006\u00a2\u0006\u000e\n\u0005\b\u009e\u0001\u0010q\u001a\u0005\b\u009f\u0001\u0010sR(\u0010\u00a4\u0001\u001a\u00020\r2\u0007\u0010\u00a1\u0001\u001a\u00020\r8\u0006@BX\u0086\u000e\u00a2\u0006\u000e\n\u0005\b\u00a2\u0001\u0010^\u001a\u0005\b\u00a3\u0001\u0010`R4\u0010\u00a7\u0001\u001a\u001c\u0012\u0018\u0012\u0016\u0012\u0004\u0012\u00020% o*\n\u0012\u0004\u0012\u00020%\u0018\u00010$0$0n8\u0006\u00a2\u0006\u000e\n\u0005\b\u00a5\u0001\u0010q\u001a\u0005\b\u00a6\u0001\u0010sR\u0018\u0010-\u001a\u00020,8\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u00a8\u0001\u0010\u00a9\u0001\u00a8\u0006\u00ae\u0001"}, d2 = {"Lcom/tencent/mobileqq/search/searchdetail/content/template/ai/viewmodel/NetSearchHunYuanViewModel;", "Landroidx/lifecycle/ViewModel;", "Landroidx/lifecycle/ViewModelStoreOwner;", "Lcom/tencent/biz/richframework/eventbus/SimpleEventReceiver;", "Lcom/tencent/biz/richframework/eventbus/SimpleBaseEvent;", "Lcom/tencent/mobileqq/search/searchdetail/content/template/ai/depositary/NetSearchHunYuanDepositary$b;", "", "m2", "N2", "L2", "K2", ICustomDataEditor.STRING_ARRAY_PARAM_3, "k2", "", "newContent", "Q2", "appendStr", "d2", "str", "f2", "Lcom/tencent/qqnt/kernel/nativeinterface/SearchModelInfo;", "searchModelInfo", "Lcom/tencent/qqnt/kernel/nativeinterface/SearchOpenSourceInfo;", "openSourceInfo", "R2", "Lkotlin/Function0;", "jump2AIOFun", ICustomDataEditor.NUMBER_PARAM_2, "", "newState", "errorCode", "fallbackTips", "S2", "U2", "reason", "g2", "", "Lcom/tencent/qqnt/kernel/nativeinterface/SearchListDetail;", "subList", "Ljava/lang/StringBuilder;", "Lkotlin/text/StringBuilder;", "logBuilder", "e2", "I2", "", NodeProps.VISIBLE, "Y2", "i2", "Lcom/tencent/qqnt/kernel/nativeinterface/ICheckAIAuthCallback;", "result", "P2", "w2", ICustomDataEditor.STRING_PARAM_2, "()Ljava/lang/Integer;", "Lcom/tencent/mobileqq/search/searchdetail/content/template/ai/depositary/NetSearchHunYuanDepositary$c;", "r2", "Lkotlin/Pair;", "q2", "W2", "Landroidx/lifecycle/ViewModelStore;", "getViewModelStore", NowProxyConstants.AccountInfoKey.A2, "modelInfo", "l2", "O2", "M2", MosaicConstants$JsFunction.FUNC_ON_DESTROY, "J2", "searchItems", ExifInterface.LATITUDE_SOUTH, "contentUUID", "s0", "V0", QAdReportDefine$AdReporterParams.K_Q_AD_REPORTER_PARAM_KEY_ERROR_TYPE, "I1", "content", "M0", QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, "onComplete", SemanticAttributes.DbSystemValues.H2, "V2", "j2", "event", "onReceiveEvent", "Ljava/util/ArrayList;", "Ljava/lang/Class;", "getEventClass", "Lcom/tencent/qqnt/kernel/nativeinterface/SearchAICard;", "i", "Lcom/tencent/qqnt/kernel/nativeinterface/SearchAICard;", "p2", "()Lcom/tencent/qqnt/kernel/nativeinterface/SearchAICard;", "aiCard", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Ljava/lang/String;", "v2", "()Ljava/lang/String;", "keyWord", BdhLogUtil.LogTag.Tag_Conn, "I", "getUserSource", "()I", "userSource", "D", "Landroidx/lifecycle/ViewModelStore;", "_viewModelStore", "Lcom/tencent/mobileqq/search/searchdetail/content/template/ai/depositary/NetSearchHunYuanDepositary;", "E", "Lcom/tencent/mobileqq/search/searchdetail/content/template/ai/depositary/NetSearchHunYuanDepositary;", "hunYuanDepositary", "Landroidx/lifecycle/MutableLiveData;", "kotlin.jvm.PlatformType", UserInfo.SEX_FEMALE, "Landroidx/lifecycle/MutableLiveData;", "F2", "()Landroidx/lifecycle/MutableLiveData;", "isShowExpandedBtn", "G", "t2", "hasShowExpandedBtn", "H", "B2", "title", Constants.MMCCID, "isShowMoreChatBtn", "J", "x2", "setModeShowNameLiveData", "(Landroidx/lifecycle/MutableLiveData;)V", "modeShowNameLiveData", "K", "Lcom/tencent/mobileqq/search/searchdetail/content/template/ai/depositary/NetSearchHunYuanDepositary$c;", "currentModeInfo", "L", "lastSelectedModeRealName", "M", "dataState", "N", "Lkotlin/Pair;", "currentErrorInfo", "P", "_originalContent", AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, "_loadingDot", "Lkotlinx/coroutines/Job;", BdhLogUtil.LogTag.Tag_Req, "Lkotlinx/coroutines/Job;", "_loadingDotJob", "Landroidx/lifecycle/MediatorLiveData;", "Lcom/tencent/mobileqq/search/searchdetail/content/template/ai/viewmodel/a;", "Landroidx/lifecycle/MediatorLiveData;", "u2", "()Landroidx/lifecycle/MediatorLiveData;", "hunYuanLiveData", "Lcom/tencent/mobileqq/search/searchdetail/content/template/ai/viewmodel/g;", "T", "Lcom/tencent/mobileqq/search/searchdetail/content/template/ai/viewmodel/g;", "streamAnimImpl", "U", "H2", "isShowRefContainer", "<set-?>", "V", "z2", "refTitle", "W", "y2", "refList", "X", "Z", "<init>", "(Lcom/tencent/qqnt/kernel/nativeinterface/SearchAICard;Ljava/lang/String;I)V", "Y", "a", "qqsearch-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes18.dex */
public final class NetSearchHunYuanViewModel extends ViewModel implements ViewModelStoreOwner, SimpleEventReceiver<SimpleBaseEvent>, NetSearchHunYuanDepositary.b {

    /* renamed from: C, reason: from kotlin metadata */
    private final int userSource;

    /* renamed from: D, reason: from kotlin metadata */
    @NotNull
    private ViewModelStore _viewModelStore;

    /* renamed from: E, reason: from kotlin metadata */
    @NotNull
    private NetSearchHunYuanDepositary hunYuanDepositary;

    /* renamed from: F, reason: from kotlin metadata */
    @NotNull
    private final MutableLiveData<Boolean> isShowExpandedBtn;

    /* renamed from: G, reason: from kotlin metadata */
    @NotNull
    private final MutableLiveData<Boolean> hasShowExpandedBtn;

    /* renamed from: H, reason: from kotlin metadata */
    @NotNull
    private final MutableLiveData<String> title;

    /* renamed from: I, reason: from kotlin metadata */
    @NotNull
    private final MutableLiveData<Boolean> isShowMoreChatBtn;

    /* renamed from: J, reason: from kotlin metadata */
    @NotNull
    private MutableLiveData<String> modeShowNameLiveData;

    /* renamed from: K, reason: from kotlin metadata */
    @NotNull
    private NetSearchHunYuanDepositary.ModelInfo currentModeInfo;

    /* renamed from: L, reason: from kotlin metadata */
    @NotNull
    private String lastSelectedModeRealName;

    /* renamed from: M, reason: from kotlin metadata */
    @NotNull
    private MutableLiveData<Integer> dataState;

    /* renamed from: N, reason: from kotlin metadata */
    @NotNull
    private Pair<String, String> currentErrorInfo;

    /* renamed from: P, reason: from kotlin metadata */
    @NotNull
    private final MutableLiveData<String> _originalContent;

    /* renamed from: Q, reason: from kotlin metadata */
    @NotNull
    private final MutableLiveData<String> _loadingDot;

    /* renamed from: R, reason: from kotlin metadata */
    @Nullable
    private Job _loadingDotJob;

    /* renamed from: S, reason: from kotlin metadata */
    @NotNull
    private final MediatorLiveData<HunYuanData> hunYuanLiveData;

    /* renamed from: T, reason: from kotlin metadata */
    @NotNull
    private final g streamAnimImpl;

    /* renamed from: U, reason: from kotlin metadata */
    @NotNull
    private final MutableLiveData<Boolean> isShowRefContainer;

    /* renamed from: V, reason: from kotlin metadata */
    @NotNull
    private String refTitle;

    /* renamed from: W, reason: from kotlin metadata */
    @NotNull
    private final MutableLiveData<List<SearchListDetail>> refList;

    /* renamed from: X, reason: from kotlin metadata */
    private boolean visible;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final SearchAICard aiCard;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String keyWord;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
    @DebugMetadata(c = "com.tencent.mobileqq.search.searchdetail.content.template.ai.viewmodel.NetSearchHunYuanViewModel$1", f = "NetSearchHunYuanViewModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: com.tencent.mobileqq.search.searchdetail.content.template.ai.viewmodel.NetSearchHunYuanViewModel$1, reason: invalid class name */
    /* loaded from: classes18.dex */
    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        AnonymousClass1(Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @NotNull
        public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
            return new AnonymousClass1(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            boolean isBlank;
            boolean isBlank2;
            IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label == 0) {
                ResultKt.throwOnFailure(obj);
                String str = NetSearchHunYuanViewModel.this.getAiCard().reference.title.text;
                Intrinsics.checkNotNullExpressionValue(str, "aiCard.reference.title.text");
                isBlank = StringsKt__StringsJVMKt.isBlank(str);
                if (!isBlank) {
                    NetSearchHunYuanViewModel netSearchHunYuanViewModel = NetSearchHunYuanViewModel.this;
                    String str2 = netSearchHunYuanViewModel.getAiCard().reference.title.text;
                    Intrinsics.checkNotNullExpressionValue(str2, "aiCard.reference.title.text");
                    netSearchHunYuanViewModel.refTitle = str2;
                }
                Intrinsics.checkNotNullExpressionValue(NetSearchHunYuanViewModel.this.getAiCard().reference.listList, "aiCard.reference.listList");
                if (!r11.isEmpty()) {
                    ArrayList<SearchListDetail> subList = NetSearchHunYuanViewModel.this.getAiCard().reference.listList;
                    NetSearchHunYuanViewModel.this.y2().setValue(subList);
                    StringBuilder sb5 = new StringBuilder("card ref total count=" + NetSearchHunYuanViewModel.this.getAiCard().reference.listList.size() + " title=" + NetSearchHunYuanViewModel.this.getAiCard().reference.title.text);
                    NetSearchHunYuanViewModel netSearchHunYuanViewModel2 = NetSearchHunYuanViewModel.this;
                    Intrinsics.checkNotNullExpressionValue(subList, "subList");
                    netSearchHunYuanViewModel2.e2(subList, sb5);
                    Logger.a d16 = Logger.f235387a.d();
                    String sb6 = sb5.toString();
                    Intrinsics.checkNotNullExpressionValue(sb6, "logBuilder.toString()");
                    d16.i("QQSearch.NetDetail.NetSearchHunYuanViewModel", 1, sb6);
                }
                NetSearchHunYuanViewModel.this.lastSelectedModeRealName = ah.f284994a.h("lastSelectedAIModel", "");
                NetSearchHunYuanViewModel netSearchHunYuanViewModel3 = NetSearchHunYuanViewModel.this;
                SearchModelInfo searchModelInfo = netSearchHunYuanViewModel3.getAiCard().aiInfo.modelInfo;
                Intrinsics.checkNotNullExpressionValue(searchModelInfo, "aiCard.aiInfo.modelInfo");
                SearchOpenSourceInfo searchOpenSourceInfo = NetSearchHunYuanViewModel.this.getAiCard().aiInfo.openSourceInfo;
                Intrinsics.checkNotNullExpressionValue(searchOpenSourceInfo, "aiCard.aiInfo.openSourceInfo");
                netSearchHunYuanViewModel3.R2(searchModelInfo, searchOpenSourceInfo);
                NetSearchHunYuanViewModel.this.x2().setValue(NetSearchHunYuanViewModel.this.getAiCard().aiInfo.modelInfo.modelShowName);
                String str3 = NetSearchHunYuanViewModel.this.getAiCard().content.text;
                Intrinsics.checkNotNullExpressionValue(str3, "aiCard.content.text");
                isBlank2 = StringsKt__StringsJVMKt.isBlank(str3);
                if (!(!isBlank2)) {
                    NetSearchHunYuanViewModel.this.g2("init");
                } else {
                    Logger logger = Logger.f235387a;
                    NetSearchHunYuanViewModel netSearchHunYuanViewModel4 = NetSearchHunYuanViewModel.this;
                    logger.d().i("QQSearch.NetDetail.NetSearchHunYuanViewModel", 1, "use cache ui card title=" + netSearchHunYuanViewModel4.getAiCard().title.text + " refListCount=" + netSearchHunYuanViewModel4.getAiCard().reference.listList.size() + " content=" + af.b(netSearchHunYuanViewModel4.getAiCard().content.text, 0, 2, null) + " modeName=" + netSearchHunYuanViewModel4.getAiCard().bottomTitle.text + " questionId=" + netSearchHunYuanViewModel4.getAiCard().getAiInfo().questionId);
                    NetSearchHunYuanViewModel netSearchHunYuanViewModel5 = NetSearchHunYuanViewModel.this;
                    String str4 = netSearchHunYuanViewModel5.getAiCard().content.text;
                    Intrinsics.checkNotNullExpressionValue(str4, "aiCard.content.text");
                    netSearchHunYuanViewModel5.Q2(str4);
                    NetSearchHunYuanViewModel.T2(NetSearchHunYuanViewModel.this, 3, null, null, 6, null);
                }
                return Unit.INSTANCE;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }

        @Override // kotlin.jvm.functions.Function2
        @Nullable
        public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0006\u001a\u00020\u0004H\u0016\u00a8\u0006\u0007"}, d2 = {"com/tencent/mobileqq/search/searchdetail/content/template/ai/viewmodel/NetSearchHunYuanViewModel$b", "Lcom/tencent/mobileqq/search/searchdetail/content/template/ai/viewmodel/b;", "", "content", "", "a", "onAnimationEnd", "qqsearch-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes18.dex */
    public static final class b implements com.tencent.mobileqq.search.searchdetail.content.template.ai.viewmodel.b {
        b() {
        }

        @Override // com.tencent.mobileqq.search.searchdetail.content.template.ai.viewmodel.b
        public void a(@NotNull String content) {
            Intrinsics.checkNotNullParameter(content, "content");
            NetSearchHunYuanViewModel.this.f2(content);
            NetSearchHunYuanViewModel.this.m2();
        }

        @Override // com.tencent.mobileqq.search.searchdetail.content.template.ai.viewmodel.b
        public void onAnimationCancel() {
            b.a.a(this);
        }

        @Override // com.tencent.mobileqq.search.searchdetail.content.template.ai.viewmodel.b
        public void onAnimationEnd() {
            af afVar = af.f284993a;
            QLog.i("QS.QQSearch.NetDetail.NetSearchHunYuanViewModel", 1, "onAnimationEnd state=" + NetSearchHunYuanViewModel.this.dataState.getValue(), null);
            NetSearchHunYuanViewModel.this.m2();
        }
    }

    public /* synthetic */ NetSearchHunYuanViewModel(SearchAICard searchAICard, String str, int i3, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this(searchAICard, str, (i16 & 4) != 0 ? 0 : i3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void C2(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void D2(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void E2(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    private final void I2() {
        Logger logger = Logger.f235387a;
        logger.d().i("QQSearch.NetDetail.NetSearchHunYuanViewModel", 1, "onFinish");
        k2();
        T2(this, 3, null, null, 6, null);
        Boolean value = this.isShowExpandedBtn.getValue();
        Boolean bool = Boolean.TRUE;
        if (!Intrinsics.areEqual(value, bool)) {
            boolean z16 = false;
            if (this.refList.getValue() != null && (!r1.isEmpty())) {
                z16 = true;
            }
            if (z16) {
                this.isShowRefContainer.setValue(bool);
            }
        }
        if (!Intrinsics.areEqual(this.isShowExpandedBtn.getValue(), bool)) {
            Y2(true);
            if (QLog.isColorLevel()) {
                logger.d().d("QQSearch.NetDetail.NetSearchHunYuanViewModel", 2, "showMoreChatBtn onComplete");
            }
        }
    }

    private final void K2() {
        if (this.visible) {
            this.streamAnimImpl.l();
            a3();
        }
    }

    private final void L2() {
        this.streamAnimImpl.k();
        k2();
    }

    private final void N2() {
        List<SearchListDetail> emptyList;
        MutableLiveData<List<SearchListDetail>> mutableLiveData = this.refList;
        emptyList = CollectionsKt__CollectionsKt.emptyList();
        mutableLiveData.setValue(emptyList);
        this.currentModeInfo.c(new SearchOpenSourceInfo());
        k2();
        Q2("");
        this.lastSelectedModeRealName = "";
        MutableLiveData<Boolean> mutableLiveData2 = this.isShowExpandedBtn;
        Boolean bool = Boolean.FALSE;
        mutableLiveData2.setValue(bool);
        this.hasShowExpandedBtn.setValue(bool);
        this.isShowMoreChatBtn.setValue(bool);
        this.isShowRefContainer.setValue(bool);
    }

    private final void P2(ICheckAIAuthCallback result) {
        NetSearchHunYuanDepositary netSearchHunYuanDepositary = this.hunYuanDepositary;
        String str = this.keyWord;
        String str2 = this.aiCard.aiInfo.questionId;
        Intrinsics.checkNotNullExpressionValue(str2, "aiCard.aiInfo.questionId");
        netSearchHunYuanDepositary.v(str, str2, this.aiCard.aiInfo.robotUin, result);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Q2(String newContent) {
        af afVar = af.f284993a;
        QLog.i("QS.QQSearch.NetDetail.NetSearchHunYuanViewModel", 1, "setContentWithoutAnim: newContent=" + newContent.length(), null);
        this.streamAnimImpl.h();
        this._originalContent.setValue(newContent);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void R2(SearchModelInfo searchModelInfo, SearchOpenSourceInfo openSourceInfo) {
        Logger.f235387a.d().i("QQSearch.NetDetail.NetSearchHunYuanViewModel", 1, "setCurrentModeInfo " + searchModelInfo + " " + openSourceInfo);
        this.currentModeInfo.d(searchModelInfo);
        this.currentModeInfo.c(openSourceInfo);
    }

    private final void S2(int newState, String errorCode, String fallbackTips) {
        af afVar = af.f284993a;
        QLog.i("QS.QQSearch.NetDetail.NetSearchHunYuanViewModel", 1, "setDataState oldState=" + this.dataState.getValue() + " --> newState=" + newState + " errorCode=" + errorCode + " fallbackTips=" + fallbackTips, null);
        this.dataState.setValue(Integer.valueOf(newState));
        this.currentErrorInfo = new Pair<>(errorCode, fallbackTips);
    }

    static /* synthetic */ void T2(NetSearchHunYuanViewModel netSearchHunYuanViewModel, int i3, String str, String str2, int i16, Object obj) {
        if ((i16 & 2) != 0) {
            str = "";
        }
        if ((i16 & 4) != 0) {
            str2 = "";
        }
        netSearchHunYuanViewModel.S2(i3, str, str2);
    }

    private final void U2() {
        QQToastUtil.showQQToastInUiThread(1, "\u7f51\u7edc\u8bf7\u6c42\u5f02\u5e38\uff0c\u8bf7\u7a0d\u540e\u91cd\u8bd5");
    }

    private final void Y2(boolean visible) {
        boolean z16;
        MutableLiveData<Boolean> mutableLiveData = this.isShowMoreChatBtn;
        if (visible && h2()) {
            z16 = true;
        } else {
            z16 = false;
        }
        mutableLiveData.setValue(Boolean.valueOf(z16));
    }

    private final void a3() {
        Job launch$default;
        Boolean bool;
        if (i2()) {
            af afVar = af.f284993a;
            if (QLog.isDebugVersion()) {
                String str = "QS.QQSearch.NetDetail.NetSearchHunYuanViewModel";
                Job job = this._loadingDotJob;
                if (job != null) {
                    bool = Boolean.valueOf(job.isActive());
                } else {
                    bool = null;
                }
                QLog.d(str, 2, "startLoadingDotJob " + bool, (Throwable) null);
            }
            Job job2 = this._loadingDotJob;
            boolean z16 = false;
            if (job2 != null && job2.isActive()) {
                z16 = true;
            }
            if (!z16) {
                launch$default = BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), Dispatchers.getMain(), null, new NetSearchHunYuanViewModel$startLoadingDotJob$2(this, null), 2, null);
                this._loadingDotJob = launch$default;
            }
        }
    }

    private final void d2(String appendStr) {
        this.streamAnimImpl.g(appendStr);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void e2(List<SearchListDetail> subList, StringBuilder logBuilder) {
        logBuilder.append(" subCount=" + subList.size());
        for (SearchListDetail searchListDetail : subList) {
            logBuilder.append(", icon=" + searchListDetail.icon.iconLink);
            logBuilder.append(", title=" + searchListDetail.title.text);
            logBuilder.append(", url=" + searchListDetail.jumpLink.jumpLink);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void f2(String str) {
        MutableLiveData<String> mutableLiveData = this._originalContent;
        mutableLiveData.setValue(((Object) mutableLiveData.getValue()) + str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void g2(String reason) {
        boolean isBlank;
        boolean z16;
        isBlank = StringsKt__StringsJVMKt.isBlank(this.lastSelectedModeRealName);
        if ((!isBlank) && Intrinsics.areEqual(this.lastSelectedModeRealName, this.currentModeInfo.getSearchModelInfo().modelRealName)) {
            z16 = true;
        } else {
            z16 = false;
        }
        Logger.f235387a.d().i("QQSearch.NetDetail.NetSearchHunYuanViewModel", 1, "begin searchHunYuan " + reason + " " + getKeyWord() + " model=" + this.currentModeInfo.getSearchModelInfo().modelRealName);
        T2(this, 1, null, null, 6, null);
        NetSearchHunYuanDepositary netSearchHunYuanDepositary = this.hunYuanDepositary;
        String str = this.aiCard.getAiInfo().prompt;
        Intrinsics.checkNotNullExpressionValue(str, "aiCard.getAiInfo().prompt");
        String str2 = this.keyWord;
        String str3 = this.currentModeInfo.getSearchModelInfo().modelRealName;
        Intrinsics.checkNotNullExpressionValue(str3, "currentModeInfo.searchModelInfo.modelRealName");
        netSearchHunYuanDepositary.x(str, str2, str3, z16, this);
    }

    private final boolean i2() {
        Integer value;
        Integer value2 = this.dataState.getValue();
        if ((value2 == null || value2.intValue() != 2) && ((value = this.dataState.getValue()) == null || value.intValue() != 9)) {
            return false;
        }
        return true;
    }

    private final void k2() {
        Job job = this._loadingDotJob;
        if (job != null) {
            Job.DefaultImpls.cancel$default(job, (CancellationException) null, 1, (Object) null);
        }
        this._loadingDot.setValue("");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void m2() {
        Integer value;
        if (!this.streamAnimImpl.j() && (value = this.dataState.getValue()) != null && value.intValue() == 9) {
            I2();
        }
    }

    private final void n2(final Function0<Unit> jump2AIOFun) {
        P2(new ICheckAIAuthCallback() { // from class: com.tencent.mobileqq.search.searchdetail.content.template.ai.viewmodel.f
            @Override // com.tencent.qqnt.kernel.nativeinterface.ICheckAIAuthCallback
            public final void onResult(int i3, String str, UfsCheckAIAuthRsp ufsCheckAIAuthRsp) {
                NetSearchHunYuanViewModel.o2(Function0.this, this, i3, str, ufsCheckAIAuthRsp);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void o2(Function0 jump2AIOFun, NetSearchHunYuanViewModel this$0, int i3, String str, UfsCheckAIAuthRsp ufsCheckAIAuthRsp) {
        Intrinsics.checkNotNullParameter(jump2AIOFun, "$jump2AIOFun");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        QLog.i("QQSearch.NetDetail.NetSearchHunYuanViewModel", 1, "sendCheckUUIDReq errorCod: " + i3 + ", errorMsg: " + str);
        if (n.e(i3)) {
            jump2AIOFun.invoke();
        } else {
            this$0.U2();
        }
    }

    @NotNull
    public final String A2() {
        String str = this.aiCard.getAiInfo().defaultText;
        Intrinsics.checkNotNullExpressionValue(str, "aiCard.getAiInfo().defaultText");
        return str;
    }

    @NotNull
    public final MutableLiveData<String> B2() {
        return this.title;
    }

    @NotNull
    public final MutableLiveData<Boolean> F2() {
        return this.isShowExpandedBtn;
    }

    @NotNull
    public final MutableLiveData<Boolean> G2() {
        return this.isShowMoreChatBtn;
    }

    @NotNull
    public final MutableLiveData<Boolean> H2() {
        return this.isShowRefContainer;
    }

    @Override // com.tencent.mobileqq.search.searchdetail.content.template.ai.depositary.NetSearchHunYuanDepositary.b
    public void I1(@NotNull String errorType, @NotNull String errorCode, @NotNull String fallbackTips) {
        Intrinsics.checkNotNullParameter(errorType, "errorType");
        Intrinsics.checkNotNullParameter(errorCode, "errorCode");
        Intrinsics.checkNotNullParameter(fallbackTips, "fallbackTips");
        QLog.e("QQSearch.NetDetail.NetSearchHunYuanViewModel", 1, "request hunyuan errorType=" + errorType + " errorCode=" + errorCode + " fallbackTips=" + fallbackTips);
        if (Intrinsics.areEqual(errorType, "backEndError")) {
            S2(8, errorCode, fallbackTips);
        } else if (Intrinsics.areEqual(errorType, "timeout")) {
            S2(6, errorCode, fallbackTips);
        } else {
            S2(4, errorCode, fallbackTips);
        }
        k2();
    }

    public final void J2(@NotNull Function0<Unit> jump2AIOFun) {
        Intrinsics.checkNotNullParameter(jump2AIOFun, "jump2AIOFun");
        n2(jump2AIOFun);
    }

    @Override // com.tencent.mobileqq.search.searchdetail.content.template.ai.depositary.NetSearchHunYuanDepositary.b
    public void M0(@NotNull String content) {
        Intrinsics.checkNotNullParameter(content, "content");
        QLog.e("QQSearch.NetDetail.NetSearchHunYuanViewModel", 1, "request hunyuan onFailedSensitive");
        Q2(content);
        T2(this, 7, null, null, 6, null);
        k2();
    }

    public final void M2(boolean visible) {
        if (visible) {
            this.visible = true;
            a3();
            this.streamAnimImpl.l();
            SimpleEventBus.getInstance().registerReceiver(this);
            return;
        }
        this.visible = false;
        k2();
        this.streamAnimImpl.k();
        SimpleEventBus.getInstance().unRegisterReceiver(this);
    }

    public final void O2() {
        if (j2()) {
            g2(TVKCommonParamEnum.REQ_PARAM_KEY_RETRY);
        }
    }

    @Override // com.tencent.mobileqq.search.searchdetail.content.template.ai.depositary.NetSearchHunYuanDepositary.b
    public void S(@NotNull List<SearchListDetail> searchItems) {
        Intrinsics.checkNotNullParameter(searchItems, "searchItems");
        this.refList.postValue(searchItems);
        StringBuilder sb5 = new StringBuilder("onReceiveRef total count=" + searchItems.size());
        e2(searchItems, sb5);
        Logger.a d16 = Logger.f235387a.d();
        String sb6 = sb5.toString();
        Intrinsics.checkNotNullExpressionValue(sb6, "logBuilder.toString()");
        d16.i("QQSearch.NetDetail.NetSearchHunYuanViewModel", 1, sb6);
    }

    @Override // com.tencent.mobileqq.search.searchdetail.content.template.ai.depositary.NetSearchHunYuanDepositary.b
    public void V0(@NotNull NetSearchHunYuanDepositary.ModelInfo modelInfo) {
        Intrinsics.checkNotNullParameter(modelInfo, "modelInfo");
        af afVar = af.f284993a;
        QLog.i("QS.QQSearch.NetDetail.NetSearchHunYuanViewModel", 1, "onReceiveModeName " + modelInfo, null);
        this.modeShowNameLiveData.postValue(modelInfo.getSearchModelInfo().modelShowName);
        R2(modelInfo.getSearchModelInfo(), modelInfo.getOpenSourceInfo());
    }

    public final void V2(boolean visible) {
        Integer value;
        this.isShowExpandedBtn.setValue(Boolean.valueOf(visible));
        if (visible) {
            this.hasShowExpandedBtn.setValue(Boolean.TRUE);
            return;
        }
        boolean z16 = false;
        if (this.refList.getValue() != null && (!r4.isEmpty())) {
            z16 = true;
        }
        if (z16 && (value = this.dataState.getValue()) != null && value.intValue() == 3) {
            this.isShowRefContainer.setValue(Boolean.TRUE);
        }
        Integer value2 = this.dataState.getValue();
        if (value2 != null && value2.intValue() == 3) {
            Y2(true);
        }
    }

    public final void W2() {
        Boolean value = this.isShowExpandedBtn.getValue();
        Boolean bool = Boolean.TRUE;
        if (!Intrinsics.areEqual(value, bool)) {
            boolean z16 = false;
            if (this.refList.getValue() != null && (!r0.isEmpty())) {
                z16 = true;
            }
            if (z16) {
                this.isShowRefContainer.setValue(bool);
            }
            Y2(true);
            Logger logger = Logger.f235387a;
            if (QLog.isColorLevel()) {
                logger.d().d("QQSearch.NetDetail.NetSearchHunYuanViewModel", 2, "showMoreChatBtn onComplete");
            }
        }
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    @NotNull
    public ArrayList<Class<SimpleBaseEvent>> getEventClass() {
        ArrayList<Class<SimpleBaseEvent>> arrayListOf;
        arrayListOf = CollectionsKt__CollectionsKt.arrayListOf(ContentScrollStateChangeEvent.class);
        return arrayListOf;
    }

    @Override // androidx.lifecycle.ViewModelStoreOwner
    @NotNull
    /* renamed from: getViewModelStore, reason: from getter */
    public ViewModelStore get_viewModelStore() {
        return this._viewModelStore;
    }

    public final boolean h2() {
        boolean z16;
        ap2.b a16;
        String packageName = this.aiCard.getPackageName();
        if (packageName != null && packageName.length() != 0) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (!z16 && (a16 = p.f285069a.a()) != null && a16.getAiCardMoreBtnCheckAppInstalled()) {
            boolean isAppInstalled = PackageUtil.isAppInstalled(BaseApplication.getContext(), packageName);
            QLog.i("QQSearch.NetDetail.NetSearchHunYuanViewModel", 1, "buttonEnable, packageName:" + packageName + ", installed:" + isAppInstalled);
            if (isAppInstalled) {
                return false;
            }
        }
        String str = this.aiCard.button.title;
        Intrinsics.checkNotNullExpressionValue(str, "aiCard.button.title");
        if (str.length() <= 0) {
            return false;
        }
        return true;
    }

    public final boolean j2() {
        Integer value;
        Integer value2 = this.dataState.getValue();
        if ((value2 == null || value2.intValue() != 4) && ((value = this.dataState.getValue()) == null || value.intValue() != 6)) {
            return false;
        }
        return true;
    }

    public final void l2(@NotNull SearchModelInfo modelInfo) {
        Intrinsics.checkNotNullParameter(modelInfo, "modelInfo");
        if (!(!Intrinsics.areEqual(modelInfo.modelRealName, this.currentModeInfo.getSearchModelInfo().modelRealName))) {
            af afVar = af.f284993a;
            if (QLog.isDebugVersion()) {
                QLog.d("QS.QQSearch.NetDetail.NetSearchHunYuanViewModel", 2, "changeModel=" + modelInfo.modelRealName + " already this mode! ", (Throwable) null);
            }
            String str = modelInfo.modelRealName;
            Intrinsics.checkNotNullExpressionValue(str, "modelInfo.modelRealName");
            this.lastSelectedModeRealName = str;
            ah ahVar = ah.f284994a;
            String str2 = modelInfo.modelRealName;
            Intrinsics.checkNotNullExpressionValue(str2, "modelInfo.modelRealName");
            ahVar.r("lastSelectedAIModel", str2);
            return;
        }
        this.hunYuanDepositary.l();
        this.hunYuanDepositary = new NetSearchHunYuanDepositary();
        N2();
        R2(modelInfo, new SearchOpenSourceInfo());
        String str3 = modelInfo.modelRealName;
        Intrinsics.checkNotNullExpressionValue(str3, "modelInfo.modelRealName");
        this.lastSelectedModeRealName = str3;
        this.modeShowNameLiveData.setValue(modelInfo.modelShowName);
        ah ahVar2 = ah.f284994a;
        String str4 = modelInfo.modelRealName;
        Intrinsics.checkNotNullExpressionValue(str4, "modelInfo.modelRealName");
        ahVar2.r("lastSelectedAIModel", str4);
        g2("changeModel");
    }

    @Override // com.tencent.mobileqq.search.searchdetail.content.template.ai.depositary.NetSearchHunYuanDepositary.b
    public void onComplete() {
        Logger.f235387a.d().i("QQSearch.NetDetail.NetSearchHunYuanViewModel", 1, "onComplete");
        T2(this, 9, null, null, 6, null);
    }

    public final void onDestroy() {
        this.hunYuanDepositary.l();
        k2();
        this.streamAnimImpl.h();
        SimpleEventBus.getInstance().unRegisterReceiver(this);
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public void onReceiveEvent(@Nullable SimpleBaseEvent event) {
        if ((event instanceof ContentScrollStateChangeEvent) && i2()) {
            af afVar = af.f284993a;
            ContentScrollStateChangeEvent contentScrollStateChangeEvent = (ContentScrollStateChangeEvent) event;
            QLog.i("QS.QQSearch.NetDetail.NetSearchHunYuanViewModel", 1, "onReceiveEvent scroll state=" + contentScrollStateChangeEvent.getState() + " dataState=" + this.dataState.getValue(), null);
            if (contentScrollStateChangeEvent.getState() == 0) {
                K2();
            } else if (contentScrollStateChangeEvent.getState() == 1) {
                L2();
            }
        }
    }

    @NotNull
    /* renamed from: p2, reason: from getter */
    public final SearchAICard getAiCard() {
        return this.aiCard;
    }

    @NotNull
    public final Pair<String, String> q2() {
        return new Pair<>(this.currentErrorInfo.getFirst(), this.currentErrorInfo.getSecond());
    }

    @NotNull
    /* renamed from: r2, reason: from getter */
    public final NetSearchHunYuanDepositary.ModelInfo getCurrentModeInfo() {
        return this.currentModeInfo;
    }

    @Override // com.tencent.mobileqq.search.searchdetail.content.template.ai.depositary.NetSearchHunYuanDepositary.b
    public void s0(@NotNull String contentUUID, @NotNull String str) {
        Intrinsics.checkNotNullParameter(contentUUID, "contentUUID");
        Intrinsics.checkNotNullParameter(str, "str");
        af afVar = af.f284993a;
        if (QLog.isDebugVersion()) {
            String substring = str.substring(0, Math.min(str.length(), 2));
            Intrinsics.checkNotNullExpressionValue(substring, "this as java.lang.String\u2026ing(startIndex, endIndex)");
            QLog.d("QS.QQSearch.NetDetail.NetSearchHunYuanViewModel", 2, "onReceiveContent " + contentUUID + " " + substring, (Throwable) null);
        }
        d2(str);
        this.aiCard.getAiInfo().questionId = contentUUID;
    }

    @Nullable
    public final Integer s2() {
        return this.dataState.getValue();
    }

    @NotNull
    public final MutableLiveData<Boolean> t2() {
        return this.hasShowExpandedBtn;
    }

    @NotNull
    public final MediatorLiveData<HunYuanData> u2() {
        return this.hunYuanLiveData;
    }

    @NotNull
    /* renamed from: v2, reason: from getter */
    public final String getKeyWord() {
        return this.keyWord;
    }

    @NotNull
    /* renamed from: w2, reason: from getter */
    public final String getLastSelectedModeRealName() {
        return this.lastSelectedModeRealName;
    }

    @NotNull
    public final MutableLiveData<String> x2() {
        return this.modeShowNameLiveData;
    }

    @NotNull
    public final MutableLiveData<List<SearchListDetail>> y2() {
        return this.refList;
    }

    @Override // com.tencent.mobileqq.search.searchdetail.content.template.ai.depositary.NetSearchHunYuanDepositary.b
    public void z() {
        T2(this, 2, null, null, 6, null);
        a3();
    }

    @NotNull
    /* renamed from: z2, reason: from getter */
    public final String getRefTitle() {
        return this.refTitle;
    }

    public NetSearchHunYuanViewModel(@NotNull SearchAICard aiCard, @NotNull String keyWord, int i3) {
        List emptyList;
        Intrinsics.checkNotNullParameter(aiCard, "aiCard");
        Intrinsics.checkNotNullParameter(keyWord, "keyWord");
        this.aiCard = aiCard;
        this.keyWord = keyWord;
        this.userSource = i3;
        this._viewModelStore = new ViewModelStore();
        this.hunYuanDepositary = new NetSearchHunYuanDepositary();
        Boolean bool = Boolean.FALSE;
        this.isShowExpandedBtn = new MutableLiveData<>(bool);
        this.hasShowExpandedBtn = new MutableLiveData<>(bool);
        this.title = new MutableLiveData<>(aiCard.title.text);
        this.isShowMoreChatBtn = new MutableLiveData<>(bool);
        this.modeShowNameLiveData = new MutableLiveData<>("");
        this.currentModeInfo = new NetSearchHunYuanDepositary.ModelInfo(new SearchModelInfo(), new SearchOpenSourceInfo());
        this.lastSelectedModeRealName = "";
        this.dataState = new MutableLiveData<>(1);
        this.currentErrorInfo = new Pair<>("", "");
        MutableLiveData<String> mutableLiveData = new MutableLiveData<>("");
        this._originalContent = mutableLiveData;
        MutableLiveData<String> mutableLiveData2 = new MutableLiveData<>("");
        this._loadingDot = mutableLiveData2;
        final MediatorLiveData<HunYuanData> mediatorLiveData = new MediatorLiveData<>();
        final Function1<String, Unit> function1 = new Function1<String, Unit>() { // from class: com.tencent.mobileqq.search.searchdetail.content.template.ai.viewmodel.NetSearchHunYuanViewModel$hunYuanLiveData$1$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(String str) {
                invoke2(str);
                return Unit.INSTANCE;
            }

            /* JADX WARN: Multi-variable type inference failed */
            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(String str) {
                MutableLiveData mutableLiveData3;
                MediatorLiveData<HunYuanData> mediatorLiveData2 = mediatorLiveData;
                Integer num = (Integer) this.dataState.getValue();
                if (num == null) {
                    num = 1;
                }
                int intValue = num.intValue();
                mutableLiveData3 = this._loadingDot;
                mediatorLiveData2.postValue(new HunYuanData(intValue, str + mutableLiveData3.getValue()));
            }
        };
        mediatorLiveData.addSource(mutableLiveData, new Observer() { // from class: com.tencent.mobileqq.search.searchdetail.content.template.ai.viewmodel.c
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                NetSearchHunYuanViewModel.C2(Function1.this, obj);
            }
        });
        MutableLiveData<Integer> mutableLiveData3 = this.dataState;
        final Function1<Integer, Unit> function12 = new Function1<Integer, Unit>() { // from class: com.tencent.mobileqq.search.searchdetail.content.template.ai.viewmodel.NetSearchHunYuanViewModel$hunYuanLiveData$1$2
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Integer num) {
                invoke2(num);
                return Unit.INSTANCE;
            }

            /* JADX WARN: Multi-variable type inference failed */
            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Integer num) {
                MutableLiveData mutableLiveData4;
                MutableLiveData mutableLiveData5;
                MediatorLiveData<HunYuanData> mediatorLiveData2 = mediatorLiveData;
                Integer num2 = (Integer) this.dataState.getValue();
                if (num2 == null) {
                    num2 = 1;
                }
                int intValue = num2.intValue();
                mutableLiveData4 = this._originalContent;
                Object value = mutableLiveData4.getValue();
                mutableLiveData5 = this._loadingDot;
                Object value2 = mutableLiveData5.getValue();
                StringBuilder sb5 = new StringBuilder();
                sb5.append(value);
                sb5.append(value2);
                mediatorLiveData2.postValue(new HunYuanData(intValue, sb5.toString()));
            }
        };
        mediatorLiveData.addSource(mutableLiveData3, new Observer() { // from class: com.tencent.mobileqq.search.searchdetail.content.template.ai.viewmodel.d
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                NetSearchHunYuanViewModel.D2(Function1.this, obj);
            }
        });
        final Function1<String, Unit> function13 = new Function1<String, Unit>() { // from class: com.tencent.mobileqq.search.searchdetail.content.template.ai.viewmodel.NetSearchHunYuanViewModel$hunYuanLiveData$1$3
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(String str) {
                invoke2(str);
                return Unit.INSTANCE;
            }

            /* JADX WARN: Multi-variable type inference failed */
            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(String str) {
                MutableLiveData mutableLiveData4;
                MediatorLiveData<HunYuanData> mediatorLiveData2 = mediatorLiveData;
                Integer num = (Integer) this.dataState.getValue();
                if (num == null) {
                    num = 1;
                }
                int intValue = num.intValue();
                mutableLiveData4 = this._originalContent;
                mediatorLiveData2.postValue(new HunYuanData(intValue, mutableLiveData4.getValue() + str));
            }
        };
        mediatorLiveData.addSource(mutableLiveData2, new Observer() { // from class: com.tencent.mobileqq.search.searchdetail.content.template.ai.viewmodel.e
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                NetSearchHunYuanViewModel.E2(Function1.this, obj);
            }
        });
        this.hunYuanLiveData = mediatorLiveData;
        this.streamAnimImpl = new g(new b());
        this.isShowRefContainer = new MutableLiveData<>(bool);
        this.refTitle = "\u53c2\u8003\u8d44\u6599\uff1a";
        emptyList = CollectionsKt__CollectionsKt.emptyList();
        this.refList = new MutableLiveData<>(emptyList);
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), Dispatchers.getMain(), null, new AnonymousClass1(null), 2, null);
        this.visible = true;
    }
}

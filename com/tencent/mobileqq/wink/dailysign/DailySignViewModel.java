package com.tencent.mobileqq.wink.dailysign;

import android.os.SystemClock;
import android.text.TextUtils;
import androidx.exifinterface.media.ExifInterface;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import camera.XEFFECT_MATERIALS_GENERAL_DATASTRUCT.MetaCategory;
import camera.XEFFECT_MATERIALS_GENERAL_DATASTRUCT.MetaMaterial;
import com.google.gson.JsonObject;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.biz.richframework.part.BaseViewModel;
import com.tencent.bugly.common.constants.Constants;
import com.tencent.intervideo.nowproxy.NowProxyConstants;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.shortvideo.gesture.DownloadInfo;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qaddefine.QAdReportDefine$AdReporterParams;
import com.tencent.mobileqq.wink.WinkConfig;
import com.tencent.mobileqq.wink.context.WinkContext;
import com.tencent.mobileqq.wink.edit.manager.WinkEditorResourceManager;
import com.tencent.mobileqq.wink.editor.WinkEditorViewModel;
import com.tencent.mobileqq.wink.editor.dr;
import com.tencent.mobileqq.wink.editor.draft.WinkEditData;
import com.tencent.mobileqq.wink.editor.draft.WinkEditDataWrapper;
import com.tencent.mobileqq.wink.editor.model.WinkTavCutScene;
import com.tencent.mobileqq.winkreport.datong.WinkDTParamBuilder;
import com.tencent.mobileqq.winkreport.dengta.WinkDengtaReportConstant;
import com.tencent.opentelemetry.semconv.trace.attributes.SemanticAttributes;
import com.tencent.qcircle.weishi.module.publisher.entity.TemplateBean;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.rmonitor.custom.ICustomDataEditor;
import com.tencent.videocut.model.MediaModel;
import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Result;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.SupervisorKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONException;
import org.json.JSONObject;
import org.light.LightConstants;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u00aa\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u000b\n\u0002\u0010\t\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010!\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b \n\u0002\u0010%\n\u0002\b\u0014\n\u0002\u0018\u0002\n\u0002\b\f\u0018\u0000 \u00ae\u00012\u00020\u0001:\u0002\u00af\u0001B\t\u00a2\u0006\u0006\b\u00ac\u0001\u0010\u00ad\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0018\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0002J\u0010\u0010\u000e\u001a\u00020\r2\u0006\u0010\f\u001a\u00020\u0006H\u0002J\b\u0010\u0010\u001a\u00020\u000fH\u0016J\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\b0\u0011J\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\b0\u0011J\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\b0\u0011J\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\b0\u0011J\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00160\u0011J(\u0010\u001b\u001a$\u0012 \u0012\u001e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u00190\u0018j\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u0019`\u001a0\u0011J\f\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00060\u0011J\b\u0010\u001d\u001a\u0004\u0018\u00010\u000fJ\u000e\u0010\u001f\u001a\u00020\n2\u0006\u0010\u001e\u001a\u00020\bJ\u000e\u0010 \u001a\u00020\n2\u0006\u0010\u001e\u001a\u00020\bJ\u000e\u0010!\u001a\u00020\n2\u0006\u0010\u001e\u001a\u00020\bJ\u000e\u0010\"\u001a\u00020\n2\u0006\u0010\u001e\u001a\u00020\bJ\u000e\u0010$\u001a\u00020\n2\u0006\u0010#\u001a\u00020\u0016J\u0016\u0010'\u001a\u00020\n2\u0006\u0010%\u001a\u00020\u000f2\u0006\u0010&\u001a\u00020\bJ\u000e\u0010(\u001a\u00020\n2\u0006\u0010\u0007\u001a\u00020\u0006J\u0006\u0010)\u001a\u00020\nJ\u000e\u0010+\u001a\u00020\n2\u0006\u0010*\u001a\u00020\u0002J\u0006\u0010,\u001a\u00020\u0002J\u001a\u00100\u001a\u00020\n2\u0012\u0010/\u001a\u000e\u0012\u0004\u0012\u00020.\u0012\u0004\u0012\u00020.0-J\u0006\u00101\u001a\u00020\nJ*\u00103\u001a\u00020\n2\"\u00102\u001a\u001e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u000f0\u0018j\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u000f`\u001aJ\u0006\u00104\u001a\u00020\u000fJ\u0010\u00106\u001a\u00020\b2\b\u00105\u001a\u0004\u0018\u00010\u000fJT\u00109\u001a\u001e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u000f0\u0018j\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u000f`\u001a2\u0006\u00107\u001a\u00020\b2(\b\u0002\u00108\u001a\"\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u0018j\u0010\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u000f\u0018\u0001`\u001aJ\u001e\u0010>\u001a\u00020\n2\u0006\u0010;\u001a\u00020:2\u0006\u0010<\u001a\u00020:2\u0006\u0010=\u001a\u00020\bJ\u0006\u0010?\u001a\u00020\nR$\u0010F\u001a\u0004\u0018\u00010\u000f8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b@\u0010A\u001a\u0004\bB\u0010C\"\u0004\bD\u0010ER\u0014\u0010J\u001a\u00020G8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bH\u0010IR\u001b\u0010P\u001a\u00020K8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\bL\u0010M\u001a\u0004\bN\u0010OR\u001c\u0010T\u001a\b\u0012\u0004\u0012\u00020\u00160Q8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bR\u0010SR\u0016\u0010W\u001a\u00020.8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bU\u0010VR\u0016\u0010\u0003\u001a\u00020\u00028\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bX\u0010YR\"\u0010\\\u001a\u000e\u0012\u0004\u0012\u00020.\u0012\u0004\u0012\u00020.0-8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bZ\u0010[R$\u0010c\u001a\u0004\u0018\u00010\u00168\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b]\u0010^\u001a\u0004\b_\u0010`\"\u0004\ba\u0010bR#\u0010f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040d0\u00118\u0002X\u0082\u0004\u00f8\u0001\u0000\u00a2\u0006\u0006\n\u0004\bV\u0010eR&\u0010l\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040d0g8\u0006\u00f8\u0001\u0000\u00a2\u0006\f\n\u0004\bh\u0010i\u001a\u0004\bj\u0010kR#\u0010r\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020n0m0\u00118\u0006\u00a2\u0006\f\n\u0004\bo\u0010e\u001a\u0004\bp\u0010qR\"\u0010&\u001a\u00020\b8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bs\u0010t\u001a\u0004\bu\u0010v\"\u0004\bw\u0010xR\"\u0010~\u001a\u00020.8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\by\u0010V\u001a\u0004\bz\u0010{\"\u0004\b|\u0010}R'\u0010\u0082\u0001\u001a\u0004\u0018\u00010\u000f8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0014\n\u0004\b\u007f\u0010A\u001a\u0005\b\u0080\u0001\u0010C\"\u0005\b\u0081\u0001\u0010ER&\u0010\u0086\u0001\u001a\u00020\b8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0015\n\u0005\b\u0083\u0001\u0010t\u001a\u0005\b\u0084\u0001\u0010v\"\u0005\b\u0085\u0001\u0010xR(\u0010\u008a\u0001\u001a\u0004\u0018\u00010\u000f8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0015\n\u0005\b\u0087\u0001\u0010A\u001a\u0005\b\u0088\u0001\u0010C\"\u0005\b\u0089\u0001\u0010ER(\u0010\u008e\u0001\u001a\u0004\u0018\u00010\u000f8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0015\n\u0005\b\u008b\u0001\u0010A\u001a\u0005\b\u008c\u0001\u0010C\"\u0005\b\u008d\u0001\u0010ER&\u0010\u0092\u0001\u001a\u000f\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u000f0\u008f\u00018\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u0090\u0001\u0010\u0091\u0001R\u0018\u0010\u0094\u0001\u001a\u00020\b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0007\n\u0005\b\u0093\u0001\u0010tR\u001c\u0010\u0096\u0001\u001a\b\u0012\u0004\u0012\u00020\b0\u00118\u0002X\u0082\u0004\u00a2\u0006\u0007\n\u0005\b\u0095\u0001\u0010eR\u001c\u0010\u0098\u0001\u001a\b\u0012\u0004\u0012\u00020\b0\u00118\u0002X\u0082\u0004\u00a2\u0006\u0007\n\u0005\b\u0097\u0001\u0010eR\u001c\u0010\u009a\u0001\u001a\b\u0012\u0004\u0012\u00020\b0\u00118\u0002X\u0082\u0004\u00a2\u0006\u0007\n\u0005\b\u0099\u0001\u0010eR\u001c\u0010\u009c\u0001\u001a\b\u0012\u0004\u0012\u00020\b0\u00118\u0002X\u0082\u0004\u00a2\u0006\u0007\n\u0005\b\u009b\u0001\u0010eR\u001c\u0010\u009e\u0001\u001a\b\u0012\u0004\u0012\u00020\u00160\u00118\u0002X\u0082\u0004\u00a2\u0006\u0007\n\u0005\b\u009d\u0001\u0010eR7\u0010\u009f\u0001\u001a$\u0012 \u0012\u001e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u00190\u0018j\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u0019`\u001a0\u00118\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bt\u0010eR\u001c\u0010\u00a1\u0001\u001a\b\u0012\u0004\u0012\u00020\u00060\u00118\u0002X\u0082\u0004\u00a2\u0006\u0007\n\u0005\b\u00a0\u0001\u0010eR\u0018\u0010\u00a3\u0001\u001a\u00020\u000f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0007\n\u0005\b\u00a2\u0001\u0010AR*\u0010\u00ab\u0001\u001a\u00030\u00a4\u00018\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0018\n\u0006\b\u00a5\u0001\u0010\u00a6\u0001\u001a\u0006\b\u00a7\u0001\u0010\u00a8\u0001\"\u0006\b\u00a9\u0001\u0010\u00aa\u0001\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u00b0\u0001"}, d2 = {"Lcom/tencent/mobileqq/wink/dailysign/DailySignViewModel;", "Lcom/tencent/biz/richframework/part/BaseViewModel;", "Lcom/tencent/mobileqq/wink/dailysign/DailySignConfig;", "dailySignConfig", "Lcom/tencent/mobileqq/wink/dailysign/al;", ICustomDataEditor.STRING_ARRAY_PARAM_2, "Lorg/json/JSONObject;", "it", "", "isInit", "", "z2", "jsonObject", "", SemanticAttributes.DbSystemValues.H2, "", "getLogTag", "Landroidx/lifecycle/MutableLiveData;", "m2", "r2", "j2", ICustomDataEditor.NUMBER_PARAM_2, "Lcamera/XEFFECT_MATERIALS_GENERAL_DATASTRUCT/MetaMaterial;", "l2", "Ljava/util/HashMap;", "", "Lkotlin/collections/HashMap;", "b2", ICustomDataEditor.STRING_PARAM_2, "t2", "enable", NowProxyConstants.AccountInfoKey.A2, "B2", "J2", "K2", "sticker", "X1", "path", "isUseCustomBackground", "W1", "Z1", Constants.BASE_IN_PLUGIN_VERSION, DownloadInfo.spKey_Config, "I2", "q2", "Lkotlin/Pair;", "", "size", "H2", Constants.MMCCID, "hashMap", "y2", "c2", "missionId", "E2", "startExport", "assetData", "C2", "", "startTime", WinkDengtaReportConstant.Params.REPORT_PREPARE_PLAY_TIME, WinkDengtaReportConstant.Params.REPORT_IS_FROM_TAKE_SAME, "F2", "w2", "i", "Ljava/lang/String;", "k2", "()Ljava/lang/String;", "setDraftMusicMid", "(Ljava/lang/String;)V", "draftMusicMid", "Lkotlinx/coroutines/CoroutineScope;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lkotlinx/coroutines/CoroutineScope;", "viewModelScope", "Lcom/tencent/mobileqq/wink/dailysign/DailyDataSource;", BdhLogUtil.LogTag.Tag_Conn, "Lkotlin/Lazy;", "i2", "()Lcom/tencent/mobileqq/wink/dailysign/DailyDataSource;", "dataSource", "", "D", "Ljava/util/List;", "allBackgroundPic", "E", "I", "backPicPathRandomIndex", UserInfo.SEX_FEMALE, "Lcom/tencent/mobileqq/wink/dailysign/DailySignConfig;", "G", "Lkotlin/Pair;", "playerSize", "H", "Lcamera/XEFFECT_MATERIALS_GENERAL_DATASTRUCT/MetaMaterial;", "getDailySignMeta", "()Lcamera/XEFFECT_MATERIALS_GENERAL_DATASTRUCT/MetaMaterial;", "setDailySignMeta", "(Lcamera/XEFFECT_MATERIALS_GENERAL_DATASTRUCT/MetaMaterial;)V", "dailySignMeta", "Lkotlin/Result;", "Landroidx/lifecycle/MutableLiveData;", "_previewDataPrepared", "Landroidx/lifecycle/LiveData;", "J", "Landroidx/lifecycle/LiveData;", "o2", "()Landroidx/lifecycle/LiveData;", "previewDataPrepared", "", "Lcamera/XEFFECT_MATERIALS_GENERAL_DATASTRUCT/MetaCategory;", "K", "g2", "()Landroidx/lifecycle/MutableLiveData;", "dailySignMoodListLiveData", "L", "Z", "v2", "()Z", "setUseCustomBackground", "(Z)V", "M", "f2", "()I", "setCustomTextLen", "(I)V", "customTextLen", "N", "d2", "setCurrentEmotionName", "currentEmotionName", "P", "u2", "setRandomText", "isRandomText", AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, "e2", "setCurrentPresetTextId", "currentPresetTextId", BdhLogUtil.LogTag.Tag_Req, "getCurrentRandomText", "setCurrentRandomText", "currentRandomText", "", ExifInterface.LATITUDE_SOUTH, "Ljava/util/Map;", "dengTaParams", "T", "isReportedDengTa", "U", "moodStickerPanelLiveData", "V", "textEditPanelLiveData", "W", "dialogLiveData", "X", "netWorkErrorLiveData", "Y", "moodStickerLiveData", "backPicLiveData", "a0", "textLiveData", "b0", "textPagEntityName", "Lcom/tencent/mobileqq/wink/dailysign/as;", "c0", "Lcom/tencent/mobileqq/wink/dailysign/as;", "p2", "()Lcom/tencent/mobileqq/wink/dailysign/as;", "setPublishConfig", "(Lcom/tencent/mobileqq/wink/dailysign/as;)V", "publishConfig", "<init>", "()V", "d0", "a", "qq-wink-temp-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes21.dex */
public final class DailySignViewModel extends BaseViewModel {

    /* renamed from: C, reason: from kotlin metadata */
    @NotNull
    private final Lazy dataSource;

    /* renamed from: D, reason: from kotlin metadata */
    @NotNull
    private List<MetaMaterial> allBackgroundPic;

    /* renamed from: E, reason: from kotlin metadata */
    private int backPicPathRandomIndex;

    /* renamed from: F, reason: from kotlin metadata */
    private DailySignConfig dailySignConfig;

    /* renamed from: G, reason: from kotlin metadata */
    private Pair<Integer, Integer> playerSize;

    /* renamed from: H, reason: from kotlin metadata */
    @Nullable
    private MetaMaterial dailySignMeta;

    /* renamed from: I, reason: from kotlin metadata */
    @NotNull
    private final MutableLiveData<Result<al>> _previewDataPrepared;

    /* renamed from: J, reason: from kotlin metadata */
    @NotNull
    private final LiveData<Result<al>> previewDataPrepared;

    /* renamed from: K, reason: from kotlin metadata */
    @NotNull
    private final MutableLiveData<List<MetaCategory>> dailySignMoodListLiveData;

    /* renamed from: L, reason: from kotlin metadata */
    private boolean isUseCustomBackground;

    /* renamed from: M, reason: from kotlin metadata */
    private int customTextLen;

    /* renamed from: N, reason: from kotlin metadata */
    @Nullable
    private String currentEmotionName;

    /* renamed from: P, reason: from kotlin metadata */
    private boolean isRandomText;

    /* renamed from: Q, reason: from kotlin metadata */
    @Nullable
    private String currentPresetTextId;

    /* renamed from: R, reason: from kotlin metadata */
    @Nullable
    private String currentRandomText;

    /* renamed from: S, reason: from kotlin metadata */
    @NotNull
    private Map<String, String> dengTaParams;

    /* renamed from: T, reason: from kotlin metadata */
    private boolean isReportedDengTa;

    /* renamed from: U, reason: from kotlin metadata */
    @NotNull
    private final MutableLiveData<Boolean> moodStickerPanelLiveData;

    /* renamed from: V, reason: from kotlin metadata */
    @NotNull
    private final MutableLiveData<Boolean> textEditPanelLiveData;

    /* renamed from: W, reason: from kotlin metadata */
    @NotNull
    private final MutableLiveData<Boolean> dialogLiveData;

    /* renamed from: X, reason: from kotlin metadata */
    @NotNull
    private final MutableLiveData<Boolean> netWorkErrorLiveData;

    /* renamed from: Y, reason: from kotlin metadata */
    @NotNull
    private final MutableLiveData<MetaMaterial> moodStickerLiveData;

    /* renamed from: Z, reason: from kotlin metadata */
    @NotNull
    private final MutableLiveData<HashMap<String, Object>> backPicLiveData;

    /* renamed from: a0, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final MutableLiveData<JSONObject> textLiveData;

    /* renamed from: b0, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private String textPagEntityName;

    /* renamed from: c0, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private as publishConfig;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private String draftMusicMid;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final CoroutineScope viewModelScope = CoroutineScopeKt.CoroutineScope(SupervisorKt.SupervisorJob$default((Job) null, 1, (Object) null).plus(Dispatchers.getMain()));

    public DailySignViewModel() {
        Lazy lazy;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<DailyDataSource>() { // from class: com.tencent.mobileqq.wink.dailysign.DailySignViewModel$dataSource$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final DailyDataSource invoke() {
                return DailyDataSource.f318060a;
            }
        });
        this.dataSource = lazy;
        this.allBackgroundPic = new ArrayList();
        MutableLiveData<Result<al>> mutableLiveData = new MutableLiveData<>();
        this._previewDataPrepared = mutableLiveData;
        this.previewDataPrepared = mutableLiveData;
        this.dailySignMoodListLiveData = new MutableLiveData<>();
        this.isRandomText = true;
        this.dengTaParams = new LinkedHashMap();
        this.moodStickerPanelLiveData = new MutableLiveData<>();
        this.textEditPanelLiveData = new MutableLiveData<>();
        this.dialogLiveData = new MutableLiveData<>();
        this.netWorkErrorLiveData = new MutableLiveData<>();
        this.moodStickerLiveData = new MutableLiveData<>();
        this.backPicLiveData = new MutableLiveData<>();
        this.textLiveData = new MutableLiveData<>();
        this.textPagEntityName = "";
        this.publishConfig = new as();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final al a2(DailySignConfig dailySignConfig) {
        int i3;
        HashMap hashMapOf;
        boolean z16;
        List mutableList;
        int collectionSizeOrDefault;
        Pair<Integer, Integer> pair;
        Object obj;
        Map<String, String> mutableMapOf;
        Map mutableMapOf2;
        WinkEditData copy;
        long downLoadSoTime = dailySignConfig.getDownLoadSoTime();
        List<String> mediaPath = dailySignConfig.getMediaPath();
        Intrinsics.checkNotNull(mediaPath);
        long loadPicTime = dailySignConfig.getLoadPicTime();
        MetaMaterial metaMaterial = dailySignConfig.getMetaMaterial();
        Intrinsics.checkNotNull(metaMaterial);
        long loadMateTime = dailySignConfig.getLoadMateTime();
        Map<String, String> assetDataMap = dailySignConfig.getAssetDataMap();
        boolean needDownLoadSo = dailySignConfig.getNeedDownLoadSo();
        boolean needDownLoadTemplate = dailySignConfig.getNeedDownLoadTemplate();
        long loadAllResourceTime = dailySignConfig.getLoadAllResourceTime();
        this.dailySignMeta = metaMaterial;
        String str = com.tencent.mobileqq.wink.editor.c.g0(metaMaterial) + File.separator + TemplateBean.TEMPLATE_JSON;
        if (assetDataMap == null) {
            hashMapOf = null;
            i3 = 0;
        } else {
            i3 = 0;
            hashMapOf = MapsKt__MapsKt.hashMapOf(TuplesKt.to(LightConstants.EventKey.EVENT_SCRIPT_PARAMS, new JSONObject(assetDataMap).toString()));
        }
        if (mediaPath.isEmpty()) {
            mutableList = new ArrayList();
            z16 = needDownLoadSo;
        } else {
            JsonObject jsonObject = new JsonObject();
            z16 = needDownLoadSo;
            jsonObject.addProperty("path", mediaPath.get(i3));
            if (hashMapOf != null) {
            }
            mutableList = CollectionsKt___CollectionsKt.toMutableList((Collection) com.tencent.mobileqq.wink.utils.o.f326724a.i(mediaPath));
        }
        List list = mutableList;
        WinkEditDataWrapper f16 = com.tencent.mobileqq.wink.editor.draft.c.f(new ArrayList(mutableList), 0, 0, 6, null);
        String missionId = WinkContext.INSTANCE.d().getMissionId();
        ArrayList<WinkEditData> editDatas = f16.getEditDatas();
        collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(editDatas, 10);
        ArrayList arrayList = new ArrayList(collectionSizeOrDefault);
        Iterator it = editDatas.iterator();
        while (it.hasNext()) {
            WinkEditData winkEditData = (WinkEditData) it.next();
            Iterator it5 = it;
            MetaMaterial metaMaterial2 = this.dailySignMeta;
            Intrinsics.checkNotNull(metaMaterial2);
            String str2 = metaMaterial2.f30533id;
            long j3 = loadMateTime;
            MetaMaterial metaMaterial3 = this.dailySignMeta;
            Intrinsics.checkNotNull(metaMaterial3);
            mutableMapOf2 = MapsKt__MapsKt.mutableMapOf(new Pair(str2, metaMaterial3));
            copy = winkEditData.copy((r37 & 1) != 0 ? winkEditData.mediaModel : null, (r37 & 2) != 0 ? winkEditData.durationUs : 0L, (r37 & 4) != 0 ? winkEditData.stickerModelMap : null, (r37 & 8) != 0 ? winkEditData.filterModelMap : null, (r37 & 16) != 0 ? winkEditData.filterMaterialMap : null, (r37 & 32) != 0 ? winkEditData.stickerExtraMap : null, (r37 & 64) != 0 ? winkEditData.openHDR : false, (r37 & 128) != 0 ? winkEditData.effectModelMap : null, (r37 & 256) != 0 ? winkEditData.renderModelStr : null, (r37 & 512) != 0 ? winkEditData.templateMaterialMap : mutableMapOf2, (r37 & 1024) != 0 ? winkEditData.stretchData : null, (r37 & 2048) != 0 ? winkEditData.assetData : hashMapOf, (r37 & 4096) != 0 ? winkEditData.isLakData : false, (r37 & 8192) != 0 ? winkEditData.mosaicData : null, (r37 & 16384) != 0 ? winkEditData.challengeData : null, (r37 & 32768) != 0 ? winkEditData.manualDeletedChallengeTag : null, (r37 & 65536) != 0 ? winkEditData.isAIElimination : false, (r37 & 131072) != 0 ? winkEditData.aiTemplate : null);
            arrayList.add(copy);
            it = it5;
            loadMateTime = j3;
        }
        long j16 = loadMateTime;
        WinkEditDataWrapper copy$default = WinkEditDataWrapper.copy$default(f16, missionId, null, new ArrayList(arrayList), null, str, null, null, 0L, false, null, null, false, 0, 0.0f, 0.0f, null, false, null, null, false, 0L, null, null, false, 0L, false, null, false, null, false, null, 0, null, false, false, null, false, false, false, null, null, null, null, false, -22, 4095, null);
        w53.b.a(getTAG(), "createPreviewData: " + com.tencent.mobileqq.wink.editor.c.g0(metaMaterial));
        WinkEditorViewModel.EditMode editMode = WinkEditorViewModel.EditMode.Video;
        ArrayList<WinkEditData> editDatas2 = copy$default.getEditDatas();
        Boolean bool = Boolean.TRUE;
        Pair<Integer, Integer> pair2 = this.playerSize;
        if (pair2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("playerSize");
            pair2 = null;
        }
        int intValue = pair2.getFirst().intValue();
        Pair<Integer, Integer> pair3 = this.playerSize;
        if (pair3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("playerSize");
            pair = null;
        } else {
            pair = pair3;
        }
        int intValue2 = pair.getSecond().intValue();
        Boolean bool2 = u53.i.f438428a;
        if (bool2 == null) {
            bool2 = Boolean.FALSE;
        }
        Intrinsics.checkNotNullExpressionValue(bool2, "if (WinkEditPerformanceW\u2026Config.isOpenFFmpegDecode");
        boolean booleanValue = bool2.booleanValue();
        Integer softDecodeThreadCnt = u53.i.f438429b;
        Intrinsics.checkNotNullExpressionValue(softDecodeThreadCnt, "softDecodeThreadCnt");
        dr.WinkTavCutParams winkTavCutParams = new dr.WinkTavCutParams(false, editMode, editDatas2, str, bool, intValue, intValue2, null, hashMapOf, booleanValue, softDecodeThreadCnt.intValue(), WinkConfig.f317649a.b(), false, copy$default.isFromQzoneText(), copy$default.getTextQzoneText(), WinkTavCutScene.Preview, false, false, 0, 0, false, null, 4128768, null);
        Pair[] pairArr = new Pair[8];
        String str3 = "0";
        pairArr[0] = TuplesKt.to(WinkDengtaReportConstant.Params.AVATAR_SHARE_LOAD_RESULT, "0");
        pairArr[1] = TuplesKt.to(WinkDengtaReportConstant.Params.AVATAR_SHARE_LOAD_ALL_RESOURCE_TIME, String.valueOf(loadAllResourceTime));
        pairArr[2] = TuplesKt.to(WinkDengtaReportConstant.Params.AVATAR_SHARE_LOAD_LIGHT_BUNDLE_TIME, String.valueOf(downLoadSoTime));
        pairArr[3] = TuplesKt.to(WinkDengtaReportConstant.Params.AVATAR_SHARE_LOAD_TEMPLATE_TIME, String.valueOf(j16));
        pairArr[4] = TuplesKt.to(WinkDengtaReportConstant.Params.REPORT_PARMA_BACK_PIC_LOAD_TIME, String.valueOf(loadPicTime));
        if (z16) {
            obj = "0";
        } else {
            obj = "1";
        }
        pairArr[5] = TuplesKt.to(WinkDengtaReportConstant.Params.REPORT_PARAM_EDITOR_RES_READY, obj);
        if (!needDownLoadTemplate) {
            str3 = "1";
        }
        pairArr[6] = TuplesKt.to(WinkDengtaReportConstant.Params.REPORT_PARAM_TEMPLATE_RES_READY, str3);
        pairArr[7] = TuplesKt.to(WinkDengtaReportConstant.Params.REPORT_TEMPLATE_TYPE, dailySignConfig.getTemplateType().getSecond());
        mutableMapOf = MapsKt__MapsKt.mutableMapOf(pairArr);
        this.dengTaParams = mutableMapOf;
        return new al(list, metaMaterial, hashMapOf, copy$default, winkTavCutParams);
    }

    private final float h2(JSONObject jsonObject) {
        return (float) jsonObject.optDouble("height", 90.0d);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final DailyDataSource i2() {
        return (DailyDataSource) this.dataSource.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void x2(DailySignViewModel this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.dailySignMoodListLiveData.postValue(WinkEditorResourceManager.a1().I0());
    }

    private final void z2(JSONObject it, boolean isInit) {
        boolean z16 = false;
        if (isInit) {
            if (this.publishConfig.getInitTextInfo() == null) {
                this.publishConfig.k(it);
                it.remove("eventType");
                it.put("isSendToSDK", false);
                this.publishConfig.q(it.optBoolean("needShowHint"));
                Z1(it);
            }
            if (this.publishConfig.getOriginInputText().length() == 0) {
                z16 = true;
            }
            if (z16) {
                as asVar = this.publishConfig;
                String optString = it.optString("text");
                Intrinsics.checkNotNullExpressionValue(optString, "it.optString(TYPE_TEXT)");
                asVar.r(optString);
            }
        } else {
            this.publishConfig.k(it);
            this.publishConfig.q(it.optBoolean("needShowHint"));
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("text", it.optString("text"));
            jSONObject.put("height", Float.valueOf(h2(it)));
            jSONObject.put("isRandomChange", it.optBoolean("isRandomChange"));
            jSONObject.put("isSendToSDK", false);
            jSONObject.put("needShowHint", this.publishConfig.getNeedShowHint());
            Z1(jSONObject);
        }
        this.publishConfig.m(h2(it));
        this.isRandomText = it.optBoolean("isRandomChange");
        as asVar2 = this.publishConfig;
        String optString2 = it.optString("text");
        Intrinsics.checkNotNullExpressionValue(optString2, "it.optString(TYPE_TEXT)");
        asVar2.l(optString2);
        if (!this.isRandomText) {
            this.currentPresetTextId = "";
            this.customTextLen = this.publishConfig.getInputText().length();
        } else {
            this.currentPresetTextId = it.optString("presetTextId");
            this.currentRandomText = this.publishConfig.getInputText();
        }
    }

    public final void A2(boolean enable) {
        this.moodStickerPanelLiveData.postValue(Boolean.valueOf(enable));
    }

    public final void B2(boolean enable) {
        this.textEditPanelLiveData.postValue(Boolean.valueOf(enable));
    }

    @NotNull
    public final HashMap<String, String> C2(boolean startExport, @Nullable HashMap<String, String> assetData) {
        boolean z16;
        HashMap<String, String> hashMap = new HashMap<>();
        if (assetData != null) {
            try {
                String str = assetData.get(LightConstants.EventKey.EVENT_SCRIPT_PARAMS);
                if (str != null) {
                    JSONObject jSONObject = new JSONObject(str);
                    jSONObject.put("startExport", startExport);
                    if (!startExport) {
                        String back = jSONObject.optString("updateBackPic");
                        Intrinsics.checkNotNullExpressionValue(back, "back");
                        boolean z17 = true;
                        if (back.length() > 0) {
                            z16 = true;
                        } else {
                            z16 = false;
                        }
                        if (z16) {
                            hashMap.put("event.script.updateBackPic", back);
                            jSONObject.remove("updateBackPic");
                        }
                        String motion = jSONObject.optString("updateEmotion");
                        Intrinsics.checkNotNullExpressionValue(motion, "motion");
                        if (motion.length() <= 0) {
                            z17 = false;
                        }
                        if (z17) {
                            hashMap.put("event.script.updateEmotion", motion);
                            jSONObject.remove("updateEmotion");
                        }
                    } else {
                        String str2 = assetData.get("event.script.updateEmotion");
                        if (str2 != null) {
                            jSONObject.put("updateEmotion", str2);
                        }
                        String str3 = assetData.get("event.script.updateBackPic");
                        if (str3 != null) {
                            jSONObject.put("updateBackPic", str3);
                        }
                        JsonObject jsonObject = new JsonObject();
                        jsonObject.addProperty("text", this.publishConfig.getInputText());
                        jsonObject.addProperty("height", Float.valueOf(this.publishConfig.getInputTextHeight()));
                        jsonObject.addProperty("name", this.publishConfig.getTextPagEntityName());
                        jsonObject.addProperty("isRandomChange", Boolean.valueOf(this.isRandomText));
                        jsonObject.addProperty("needShowHint", Boolean.valueOf(this.publishConfig.getNeedShowHint()));
                        jSONObject.put("updateText", jsonObject.toString());
                    }
                    String jSONObject2 = jSONObject.toString();
                    Intrinsics.checkNotNullExpressionValue(jSONObject2, "paramsJson.toString()");
                    hashMap.put(LightConstants.EventKey.EVENT_SCRIPT_PARAMS, jSONObject2);
                    Unit unit = Unit.INSTANCE;
                }
            } catch (Exception e16) {
                w53.b.c("DailySignDataSource", "prepareAssetData " + startExport + " " + e16);
                Unit unit2 = Unit.INSTANCE;
            }
        }
        return hashMap;
    }

    public final void D2() {
        BuildersKt__Builders_commonKt.launch$default(this.viewModelScope, null, null, new DailySignViewModel$randomBackPic$1(this, null), 3, null);
    }

    public final boolean E2(@Nullable String missionId) {
        WinkEditDataWrapper c16;
        MediaModel copy;
        String str;
        if (TextUtils.isEmpty(missionId) || (c16 = com.tencent.mobileqq.wink.editor.draft.a.c(missionId)) == null) {
            return false;
        }
        HashMap<String, String> C2 = C2(false, c16.getEditDatas().get(0).getAssetData());
        w53.b.f("DailySignDataSource", "loadMediaDataFromDraft winkEditDataWrapper:" + c16);
        WinkEditDataWrapper c17 = com.tencent.mobileqq.wink.editor.draft.a.c(missionId);
        WinkEditData winkEditData = c17.getEditDatas().get(0);
        copy = r14.copy((r39 & 1) != 0 ? r14.id : null, (r39 & 2) != 0 ? r14.name : null, (r39 & 4) != 0 ? r14.version : null, (r39 & 8) != 0 ? r14.createTime : null, (r39 & 16) != 0 ? r14.updateTime : null, (r39 & 32) != 0 ? r14.duration : null, (r39 & 64) != 0 ? r14.videos : null, (r39 & 128) != 0 ? r14.audios : new HashMap(), (r39 & 256) != 0 ? r14.stickers : null, (r39 & 512) != 0 ? r14.backgroundModel : null, (r39 & 1024) != 0 ? r14.filterModels : null, (r39 & 2048) != 0 ? r14.specialEffects : null, (r39 & 4096) != 0 ? r14.transitions : null, (r39 & 8192) != 0 ? r14.templateModel : null, (r39 & 16384) != 0 ? r14.coverInfo : null, (r39 & 32768) != 0 ? r14.exportSetting : null, (r39 & 65536) != 0 ? r14.openHDR : null, (r39 & 131072) != 0 ? r14.hdrModels : null, (r39 & 262144) != 0 ? r14.smoothModels : null, (r39 & 524288) != 0 ? r14.openSuperHDR : null, (r39 & 1048576) != 0 ? c17.getEditDatas().get(0).getMediaModel().unknownFields() : null);
        winkEditData.setMediaModel(copy);
        HashMap<String, String> assetData = c17.getEditDatas().get(0).getAssetData();
        if (assetData != null) {
            str = assetData.get(LightConstants.EventKey.EVENT_SCRIPT_PARAMS);
        } else {
            str = null;
        }
        if (str != null) {
            String updateText = new JSONObject(str).optString("updateText");
            w53.b.f("DailySignDataSource", "loadMediaDataFromDraft updateText:" + updateText);
            if (!TextUtils.isEmpty(updateText)) {
                DailySignConfig dailySignConfig = this.dailySignConfig;
                if (dailySignConfig == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("dailySignConfig");
                    dailySignConfig = null;
                }
                Map<String, String> assetDataMap = dailySignConfig.getAssetDataMap();
                if (assetDataMap != null) {
                    Intrinsics.checkNotNullExpressionValue(updateText, "updateText");
                    assetDataMap.put("updateText", updateText);
                }
                Z1(new JSONObject(updateText));
            }
        }
        WinkEditorViewModel.EditMode editMode = WinkEditorViewModel.EditMode.Video;
        ArrayList<WinkEditData> editDatas = c17.getEditDatas();
        String templateFilePath = c17.getTemplateFilePath();
        Boolean bool = Boolean.TRUE;
        Pair<Integer, Integer> pair = this.playerSize;
        if (pair == null) {
            Intrinsics.throwUninitializedPropertyAccessException("playerSize");
            pair = null;
        }
        int intValue = pair.getFirst().intValue();
        Pair<Integer, Integer> pair2 = this.playerSize;
        if (pair2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("playerSize");
            pair2 = null;
        }
        int intValue2 = pair2.getSecond().intValue();
        Boolean bool2 = u53.i.f438428a;
        if (bool2 == null) {
            bool2 = Boolean.FALSE;
        }
        Intrinsics.checkNotNullExpressionValue(bool2, "if (WinkEditPerformanceW\u2026Config.isOpenFFmpegDecode");
        boolean booleanValue = bool2.booleanValue();
        Integer softDecodeThreadCnt = u53.i.f438429b;
        Intrinsics.checkNotNullExpressionValue(softDecodeThreadCnt, "softDecodeThreadCnt");
        dr.WinkTavCutParams winkTavCutParams = new dr.WinkTavCutParams(false, editMode, editDatas, templateFilePath, bool, intValue, intValue2, null, C2, booleanValue, softDecodeThreadCnt.intValue(), WinkConfig.f317649a.b(), false, c17.isFromQzoneText(), c17.getTextQzoneText(), WinkTavCutScene.Preview, false, false, 0, 0, false, null, 4128768, null);
        String selectMusicMid = c17.getSelectMusicMid();
        if (selectMusicMid == null) {
            selectMusicMid = "";
        }
        this.draftMusicMid = selectMusicMid;
        BuildersKt__Builders_commonKt.launch$default(this.viewModelScope, null, null, new DailySignViewModel$recoveryFromMissionId$1(this, c17, winkTavCutParams, null), 3, null);
        this.isReportedDengTa = true;
        return true;
    }

    public final void F2(long startTime, long preparePlayerTime, boolean isFromTakeSame) {
        String str;
        if (this.isReportedDengTa) {
            return;
        }
        this.isReportedDengTa = true;
        this.dengTaParams.put(WinkDengtaReportConstant.Params.REPORT_PARMA_LOAD_TIME, String.valueOf(SystemClock.elapsedRealtime() - startTime));
        this.dengTaParams.put(WinkDengtaReportConstant.Params.REPORT_PREPARE_PLAY_TIME, String.valueOf(preparePlayerTime));
        Map<String, String> map = this.dengTaParams;
        if (isFromTakeSame) {
            str = "1";
        } else {
            str = "0";
        }
        map.put(WinkDengtaReportConstant.Params.REPORT_IS_FROM_TAKE_SAME, str);
        com.tencent.mobileqq.wink.report.e.o(com.tencent.mobileqq.wink.report.e.f326265a, WinkDengtaReportConstant.Action.DAILY_SIGN_LOAD_TIME, this.dengTaParams, false, 4, null);
    }

    public final void G2() {
        BuildersKt__Builders_commonKt.launch$default(this.viewModelScope, null, null, new DailySignViewModel$requestAndProcessData$1(this, null), 3, null);
    }

    public final void H2(@NotNull Pair<Integer, Integer> size) {
        Intrinsics.checkNotNullParameter(size, "size");
        this.playerSize = size;
    }

    public final void I2(@NotNull DailySignConfig config) {
        Intrinsics.checkNotNullParameter(config, "config");
        this.dailySignConfig = config;
    }

    public final void J2(boolean enable) {
        this.dialogLiveData.postValue(Boolean.valueOf(enable));
    }

    public final void K2(boolean enable) {
        this.netWorkErrorLiveData.postValue(Boolean.valueOf(enable));
    }

    public final void W1(@NotNull String path, boolean isUseCustomBackground) {
        Intrinsics.checkNotNullParameter(path, "path");
        this.isUseCustomBackground = isUseCustomBackground;
        this.publishConfig.j(path);
        HashMap<String, Object> hashMap = new HashMap<>();
        hashMap.put("path", path);
        hashMap.put("isCustomPic", Boolean.valueOf(isUseCustomBackground));
        this.backPicLiveData.postValue(hashMap);
    }

    public final void X1(@NotNull MetaMaterial sticker) {
        Intrinsics.checkNotNullParameter(sticker, "sticker");
        this.currentEmotionName = sticker.showName;
        this.publishConfig.n(sticker);
        this.moodStickerLiveData.postValue(sticker);
    }

    public final void Z1(@NotNull JSONObject it) {
        Intrinsics.checkNotNullParameter(it, "it");
        if (Intrinsics.areEqual(it.optString("text"), this.publishConfig.getInputText())) {
            return;
        }
        this.textLiveData.postValue(it);
    }

    @NotNull
    public final MutableLiveData<HashMap<String, Object>> b2() {
        return this.backPicLiveData;
    }

    @NotNull
    public final String c2() {
        Object orNull;
        String str;
        orNull = CollectionsKt___CollectionsKt.getOrNull(this.allBackgroundPic, this.backPicPathRandomIndex);
        MetaMaterial metaMaterial = (MetaMaterial) orNull;
        if (metaMaterial != null) {
            str = metaMaterial.f30533id;
        } else {
            str = null;
        }
        if (str == null) {
            return "";
        }
        return str;
    }

    @Nullable
    /* renamed from: d2, reason: from getter */
    public final String getCurrentEmotionName() {
        return this.currentEmotionName;
    }

    @Nullable
    /* renamed from: e2, reason: from getter */
    public final String getCurrentPresetTextId() {
        return this.currentPresetTextId;
    }

    /* renamed from: f2, reason: from getter */
    public final int getCustomTextLen() {
        return this.customTextLen;
    }

    @NotNull
    public final MutableLiveData<List<MetaCategory>> g2() {
        return this.dailySignMoodListLiveData;
    }

    @Override // com.tencent.biz.richframework.part.BaseViewModel
    @NotNull
    /* renamed from: getLogTag */
    public String getTAG() {
        return "DailySignViewModel";
    }

    @NotNull
    public final MutableLiveData<Boolean> j2() {
        return this.dialogLiveData;
    }

    @Nullable
    /* renamed from: k2, reason: from getter */
    public final String getDraftMusicMid() {
        return this.draftMusicMid;
    }

    @NotNull
    public final MutableLiveData<MetaMaterial> l2() {
        return this.moodStickerLiveData;
    }

    @NotNull
    public final MutableLiveData<Boolean> m2() {
        return this.moodStickerPanelLiveData;
    }

    @NotNull
    public final MutableLiveData<Boolean> n2() {
        return this.netWorkErrorLiveData;
    }

    @NotNull
    public final LiveData<Result<al>> o2() {
        return this.previewDataPrepared;
    }

    @NotNull
    /* renamed from: p2, reason: from getter */
    public final as getPublishConfig() {
        return this.publishConfig;
    }

    @NotNull
    public final DailySignConfig q2() {
        DailySignConfig dailySignConfig = this.dailySignConfig;
        if (dailySignConfig == null) {
            Intrinsics.throwUninitializedPropertyAccessException("dailySignConfig");
            return null;
        }
        return dailySignConfig;
    }

    @NotNull
    public final MutableLiveData<Boolean> r2() {
        return this.textEditPanelLiveData;
    }

    @NotNull
    public final MutableLiveData<JSONObject> s2() {
        return this.textLiveData;
    }

    @Nullable
    public final String t2() {
        MetaMaterial metaMaterial = this.dailySignMeta;
        if (metaMaterial != null) {
            return com.tencent.mobileqq.wink.editor.c.g0(metaMaterial) + File.separator + this.publishConfig.getTextPagEntityName();
        }
        return null;
    }

    /* renamed from: u2, reason: from getter */
    public final boolean getIsRandomText() {
        return this.isRandomText;
    }

    /* renamed from: v2, reason: from getter */
    public final boolean getIsUseCustomBackground() {
        return this.isUseCustomBackground;
    }

    public final void w2() {
        WinkEditorResourceManager.a1().a3(new Runnable() { // from class: com.tencent.mobileqq.wink.dailysign.ar
            @Override // java.lang.Runnable
            public final void run() {
                DailySignViewModel.x2(DailySignViewModel.this);
            }
        });
    }

    /* JADX WARN: Removed duplicated region for block: B:30:0x008a A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:34:0x006c A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void y2(@NotNull HashMap<String, String> hashMap) {
        String str;
        boolean isBlank;
        boolean z16;
        boolean isBlank2;
        Intrinsics.checkNotNullParameter(hashMap, "hashMap");
        if (hashMap.containsKey("material_result") && (str = hashMap.get("material_result")) != null) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                String optString = jSONObject.optString("eventType");
                if (optString != null) {
                    switch (optString.hashCode()) {
                        case -2108582394:
                            if (!optString.equals("showEmotionPanel")) {
                                break;
                            } else {
                                A2(true);
                                Unit unit = Unit.INSTANCE;
                                return;
                            }
                        case -1548150928:
                            if (!optString.equals("showTextEditPanel")) {
                                break;
                            } else {
                                this.publishConfig.u(jSONObject.optString("entityName") + ".PAG");
                                as asVar = this.publishConfig;
                                String optString2 = jSONObject.optString("text");
                                Intrinsics.checkNotNullExpressionValue(optString2, "it.optString(TYPE_TEXT)");
                                asVar.l(optString2);
                                B2(true);
                                Unit unit2 = Unit.INSTANCE;
                                return;
                            }
                        case -595263633:
                            if (!optString.equals("onTextUpdated")) {
                                break;
                            } else {
                                z2(jSONObject, false);
                                break;
                            }
                        case 990995497:
                            if (!optString.equals("onTemplateInit")) {
                                break;
                            } else {
                                z2(jSONObject, true);
                                Unit unit3 = Unit.INSTANCE;
                                return;
                            }
                        case 1003372902:
                            if (!optString.equals("onItemReport")) {
                                break;
                            } else {
                                JSONObject optJSONObject = jSONObject.optJSONObject(QAdReportDefine$AdReporterParams.K_Q_AD_REPORTER_PARAM_KEY_REPORT_PARAMS);
                                if (optJSONObject != null) {
                                    Intrinsics.checkNotNullExpressionValue(optJSONObject, "optJSONObject(REPORT_PARAMS)");
                                    Map<String, Object> map = WinkDTParamBuilder.buildElementParams();
                                    String optString3 = optJSONObject.optString("xsj_custom_pgid");
                                    Intrinsics.checkNotNullExpressionValue(optString3, "reportParams.optString(\"xsj_custom_pgid\")");
                                    isBlank = StringsKt__StringsJVMKt.isBlank(optString3);
                                    if (isBlank) {
                                        return;
                                    }
                                    Iterator keys = optJSONObject.keys();
                                    Intrinsics.checkNotNullExpressionValue(keys, "reportParams.keys()");
                                    while (keys.hasNext()) {
                                        String str2 = (String) keys.next();
                                        String optString4 = optJSONObject.optString(str2);
                                        if (optString4 != null) {
                                            isBlank2 = StringsKt__StringsJVMKt.isBlank(optString4);
                                            if (!isBlank2) {
                                                z16 = false;
                                                if (z16) {
                                                    Intrinsics.checkNotNullExpressionValue(map, "map");
                                                    map.put(str2, optString4);
                                                }
                                            }
                                        }
                                        z16 = true;
                                        if (z16) {
                                        }
                                    }
                                    map.putAll(DailySignFragment.INSTANCE.a(q2()));
                                    VideoReport.reportEvent("ev_xsj_abnormal_clck", map);
                                    Unit unit4 = Unit.INSTANCE;
                                    return;
                                }
                                return;
                            }
                    }
                }
                Unit unit5 = Unit.INSTANCE;
            } catch (JSONException e16) {
                w53.b.d(getTAG(), "onProcessAssetData: fail result ", e16);
                Unit unit6 = Unit.INSTANCE;
            }
        }
    }
}

package com.tencent.mobileqq.wink.lowthresholdltemplate;

import android.os.Bundle;
import android.os.SystemClock;
import androidx.core.app.NotificationCompat;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import camera.XEFFECT_MATERIALS_GENERAL_DATASTRUCT.MetaMaterial;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.aelight.camera.download.api.AEResInfo;
import com.tencent.aelight.camera.download.api.IAEMultiDownloadCallBack;
import com.tencent.aelight.camera.entry.api.IAECameraLauncher;
import com.tencent.biz.richframework.part.BaseViewModel;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.profilecard.api.IProfileCardConst;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.shortvideo.gesture.DownloadInfo;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qaddefine.QAdReportDefine$AdReporterParams;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.wink.WinkConfig;
import com.tencent.mobileqq.wink.api.QQWinkConstants;
import com.tencent.mobileqq.wink.context.WinkContext;
import com.tencent.mobileqq.wink.edit.manager.WinkEditorResourceManager;
import com.tencent.mobileqq.wink.editor.WinkEditorViewModel;
import com.tencent.mobileqq.wink.editor.dr;
import com.tencent.mobileqq.wink.editor.draft.WinkEditData;
import com.tencent.mobileqq.wink.editor.draft.WinkEditDataWrapper;
import com.tencent.mobileqq.wink.editor.model.WinkTavCutScene;
import com.tencent.mobileqq.wink.editor.music.viewmodel.MusicVolumeControlViewModel;
import com.tencent.mobileqq.wink.lowthresholdltemplate.b;
import com.tencent.mobileqq.wink.lowthresholdltemplate.p;
import com.tencent.mobileqq.wink.publish.OneClickPublishingHelper;
import com.tencent.mobileqq.winkreport.datong.WinkDaTongReportConstant;
import com.tencent.mobileqq.winkreport.dengta.WinkDengtaReportConstant;
import com.tencent.opentelemetry.semconv.trace.attributes.SemanticAttributes;
import com.tencent.rmonitor.custom.ICustomDataEditor;
import com.tencent.tavcut.core.session.ICutSession;
import com.tencent.upload.network.session.cache.SessionDbHelper;
import com.tencent.videocut.model.BackgroundModel;
import com.tencent.videocut.model.MediaClip;
import com.tencent.videocut.model.MediaModel;
import com.tencent.videocut.model.ResourceModel;
import com.tencent.videocut.model.SizeF;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.ExceptionsKt__ExceptionsKt;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.collections.MapsKt__MapsJVMKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.coroutines.AbstractCoroutineContextElement;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.SafeContinuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugProbes;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineExceptionHandler;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.SupervisorKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;
import org.light.LightAsset;
import org.light.LightConstants;

@Metadata(d1 = {"\u0000\u0096\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0017\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b_\u0010`J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0010\u0010\u000b\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\u0002H\u0002J\u001f\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\n0\fH\u0082@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\r\u0010\u000eJr\u0010\u001a\u001a\u00020\u00192\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\u000f2\u001a\u0010\u0013\u001a\u0016\u0012\f\u0012\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0012\u0012\u0004\u0012\u00020\u000f0\f2\u0012\u0010\u0015\u001a\u000e\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u000f0\f2\u0014\u0010\u0017\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u00162\u0012\u0010\u0018\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\n0\fH\u0002JJ\u0010#\u001a\u00020\u00062\u0006\u0010\u001b\u001a\u00020\n2\u0006\u0010\u0010\u001a\u00020\u000f2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001c2\u0006\u0010\u001e\u001a\u00020\u000f2\u0006\u0010\u001f\u001a\u00020\u000f2\u0006\u0010 \u001a\u00020\u000f2\u0006\u0010!\u001a\u00020\n2\u0006\u0010\"\u001a\u00020\nH\u0002J\u0010\u0010%\u001a\u00020\u00062\u0006\u0010$\u001a\u00020\u000fH\u0002J\b\u0010&\u001a\u00020\u0002H\u0016J\u000e\u0010)\u001a\u00020\u00062\u0006\u0010(\u001a\u00020'J\u001e\u0010,\u001a\u00020\u00062\u0006\u0010*\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010+\u001a\u00020\u0002J\b\u0010-\u001a\u00020\u0006H\u0014J\u0006\u0010.\u001a\u00020\u0006J\u0016\u00102\u001a\u00020\u00062\u0006\u00100\u001a\u00020/2\u0006\u00101\u001a\u00020\u000fJ\u0006\u00103\u001a\u00020\u0006R\u0014\u00107\u001a\u0002048\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b5\u00106R\u001b\u0010=\u001a\u0002088BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b9\u0010:\u001a\u0004\b;\u0010<R#\u0010B\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00190?0>8\u0002X\u0082\u0004\u00f8\u0001\u0000\u00a2\u0006\u0006\n\u0004\b@\u0010AR&\u0010H\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00190?0C8\u0006\u00f8\u0001\u0000\u00a2\u0006\f\n\u0004\bD\u0010E\u001a\u0004\bF\u0010GR \u0010L\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020J0I0>8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bK\u0010AR#\u0010O\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020J0I0C8\u0006\u00a2\u0006\f\n\u0004\bM\u0010E\u001a\u0004\bN\u0010GR\u0016\u0010R\u001a\u00020\u000f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bP\u0010QR\u0018\u00100\u001a\u0004\u0018\u00010/8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bS\u0010TR\u0016\u0010V\u001a\u00020\u000f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bU\u0010QR\u0016\u0010X\u001a\u00020\n8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bQ\u0010WR\u0016\u0010[\u001a\u00020'8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bY\u0010ZR\u0016\u0010^\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\\\u0010]\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006a"}, d2 = {"Lcom/tencent/mobileqq/wink/lowthresholdltemplate/WinkTemplateSharePreviewViewModel;", "Lcom/tencent/biz/richframework/part/BaseViewModel;", "", "publishContent", "Lcom/tencent/mobileqq/wink/editor/draft/WinkEditDataWrapper;", "winkEditDataWrapper", "", "g2", "b2", IProfileCardConst.KEY_FROM_TYPE, "", "d2", "Lkotlin/Pair;", "c2", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "", "startTime", "loadLightTime", "", "loadImageResult", "Lcamera/XEFFECT_MATERIALS_GENERAL_DATASTRUCT/MetaMaterial;", "loadMateResult", "", "assetDataMap", "needDownLoad", "Lcom/tencent/mobileqq/wink/lowthresholdltemplate/a;", "W1", "result", "", NotificationCompat.CATEGORY_ERROR, "lightCost", "templateCost", "imgCost", "needDownLoadSo", "needDownLoadTemplate", SemanticAttributes.DbSystemValues.H2, "readyCost", "i2", "getLogTag", "Lcom/tencent/mobileqq/wink/lowthresholdltemplate/p;", DownloadInfo.spKey_Config, "k2", "publish", "missionId", "j2", "onCleared", "f2", "Lcom/tencent/tavcut/core/session/ICutSession;", SessionDbHelper.SESSION_ID, "coverTimeUs", "e2", "U1", "Lkotlinx/coroutines/CoroutineScope;", "i", "Lkotlinx/coroutines/CoroutineScope;", "viewModelScope", "Lcom/tencent/mobileqq/wink/lowthresholdltemplate/r;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lkotlin/Lazy;", "X1", "()Lcom/tencent/mobileqq/wink/lowthresholdltemplate/r;", "dataSource", "Landroidx/lifecycle/MutableLiveData;", "Lkotlin/Result;", BdhLogUtil.LogTag.Tag_Conn, "Landroidx/lifecycle/MutableLiveData;", "_prepared", "Landroidx/lifecycle/LiveData;", "D", "Landroidx/lifecycle/LiveData;", "Z1", "()Landroidx/lifecycle/LiveData;", "prepared", "Lt73/a;", "Lcom/tencent/mobileqq/wink/lowthresholdltemplate/b;", "E", "_previewEvent", UserInfo.SEX_FEMALE, ICustomDataEditor.STRING_ARRAY_PARAM_2, "previewEvent", "G", "J", "coverTime", "H", "Lcom/tencent/tavcut/core/session/ICutSession;", "I", "loadedTime", "Z", "publishling", "K", "Lcom/tencent/mobileqq/wink/lowthresholdltemplate/p;", "winkTemplateShareConfig", "L", "Ljava/lang/String;", "currentMissionId", "<init>", "()V", "qq-wink-temp-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes21.dex */
public final class WinkTemplateSharePreviewViewModel extends BaseViewModel {

    /* renamed from: C, reason: from kotlin metadata */
    @NotNull
    private final MutableLiveData<Result<com.tencent.mobileqq.wink.lowthresholdltemplate.a>> _prepared;

    /* renamed from: D, reason: from kotlin metadata */
    @NotNull
    private final LiveData<Result<com.tencent.mobileqq.wink.lowthresholdltemplate.a>> prepared;

    /* renamed from: E, reason: from kotlin metadata */
    @NotNull
    private final MutableLiveData<t73.a<com.tencent.mobileqq.wink.lowthresholdltemplate.b>> _previewEvent;

    /* renamed from: F, reason: from kotlin metadata */
    @NotNull
    private final LiveData<t73.a<com.tencent.mobileqq.wink.lowthresholdltemplate.b>> previewEvent;

    /* renamed from: G, reason: from kotlin metadata */
    private long coverTime;

    /* renamed from: H, reason: from kotlin metadata */
    @Nullable
    private ICutSession session;

    /* renamed from: I, reason: from kotlin metadata */
    private long loadedTime;

    /* renamed from: J, reason: from kotlin metadata */
    private boolean publishling;

    /* renamed from: K, reason: from kotlin metadata */
    private p winkTemplateShareConfig;

    /* renamed from: L, reason: from kotlin metadata */
    @NotNull
    private String currentMissionId;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final CoroutineScope viewModelScope = CoroutineScopeKt.CoroutineScope(SupervisorKt.SupervisorJob$default((Job) null, 1, (Object) null).plus(Dispatchers.getMain()));

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy dataSource;

    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\"\u0010\t\u001a\u00020\b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016\u00a8\u0006\n"}, d2 = {"com/tencent/mobileqq/wink/lowthresholdltemplate/WinkTemplateSharePreviewViewModel$a", "Lcom/tencent/aelight/camera/download/api/IAEMultiDownloadCallBack;", "Lcom/tencent/aelight/camera/download/api/AEResInfo;", "aeResInfo", "", "downloaded", "", QAdReportDefine$AdReporterParams.K_Q_AD_REPORTER_PARAM_KEY_ERROR_TYPE, "", "onAEMultiDownloadFinish", "qq-wink-temp-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes21.dex */
    public static final class a implements IAEMultiDownloadCallBack {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Continuation<Pair<Boolean, Boolean>> f323415a;

        /* JADX WARN: Multi-variable type inference failed */
        a(Continuation<? super Pair<Boolean, Boolean>> continuation) {
            this.f323415a = continuation;
        }

        @Override // com.tencent.aelight.camera.download.api.IAEMultiDownloadCallBack
        public void onAEMultiDownloadFinish(@Nullable AEResInfo aeResInfo, boolean downloaded, int errorType) {
            String str;
            if (aeResInfo != null) {
                str = aeResInfo.agentType;
            } else {
                str = null;
            }
            w53.b.a("WinkTemplateShareDataSource", "onAEMultiDownloadFinish aeResInfo = " + str + " downloaded = " + downloaded + ", error = " + errorType);
            Continuation<Pair<Boolean, Boolean>> continuation = this.f323415a;
            Result.Companion companion = Result.INSTANCE;
            continuation.resumeWith(Result.m476constructorimpl(new Pair(Boolean.valueOf(downloaded), Boolean.TRUE)));
        }
    }

    @Metadata(d1 = {"\u0000!\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u00012\u00020\u0002J\u0018\u0010\b\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0005H\u0016\u00a8\u0006\t\u00b8\u0006\u0000"}, d2 = {"kotlinx/coroutines/CoroutineExceptionHandlerKt$CoroutineExceptionHandler$1", "Lkotlin/coroutines/AbstractCoroutineContextElement;", "Lkotlinx/coroutines/CoroutineExceptionHandler;", "Lkotlin/coroutines/CoroutineContext;", "context", "", "exception", "", "handleException", "kotlinx-coroutines-core"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes21.dex */
    public static final class b extends AbstractCoroutineContextElement implements CoroutineExceptionHandler {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ WinkTemplateSharePreviewViewModel f323416d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(CoroutineExceptionHandler.Companion companion, WinkTemplateSharePreviewViewModel winkTemplateSharePreviewViewModel) {
            super(companion);
            this.f323416d = winkTemplateSharePreviewViewModel;
        }

        @Override // kotlinx.coroutines.CoroutineExceptionHandler
        public void handleException(@NotNull CoroutineContext context, @NotNull Throwable exception) {
            String stackTraceToString;
            String tag = this.f323416d.getTAG();
            stackTraceToString = ExceptionsKt__ExceptionsKt.stackTraceToString(exception);
            w53.b.c(tag, "requestAndProcessData exception: " + stackTraceToString);
        }
    }

    public WinkTemplateSharePreviewViewModel() {
        Lazy lazy;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<WinkTemplateShareRepo>() { // from class: com.tencent.mobileqq.wink.lowthresholdltemplate.WinkTemplateSharePreviewViewModel$dataSource$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final WinkTemplateShareRepo invoke() {
                return WinkTemplateShareRepo.f323423a;
            }
        });
        this.dataSource = lazy;
        MutableLiveData<Result<com.tencent.mobileqq.wink.lowthresholdltemplate.a>> mutableLiveData = new MutableLiveData<>();
        this._prepared = mutableLiveData;
        this.prepared = mutableLiveData;
        MutableLiveData<t73.a<com.tencent.mobileqq.wink.lowthresholdltemplate.b>> mutableLiveData2 = new MutableLiveData<>();
        this._previewEvent = mutableLiveData2;
        this.previewEvent = mutableLiveData2;
        this.currentMissionId = "";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final com.tencent.mobileqq.wink.lowthresholdltemplate.a W1(long startTime, long loadLightTime, Pair<? extends List<String>, Long> loadImageResult, Pair<MetaMaterial, Long> loadMateResult, Map<String, String> assetDataMap, Pair<Boolean, Boolean> needDownLoad) {
        String joinToString$default;
        Object firstOrNull;
        HashMap hashMapOf;
        HashMap hashMap;
        int collectionSizeOrDefault;
        BackgroundModel backgroundModel;
        MediaModel copy;
        WinkEditData copy2;
        BackgroundModel copy3;
        String joinToString$default2;
        List<String> component1 = loadImageResult.component1();
        long longValue = loadImageResult.component2().longValue();
        MetaMaterial component12 = loadMateResult.component1();
        long longValue2 = loadMateResult.component2().longValue();
        String X0 = WinkEditorResourceManager.a1().X0(component12);
        String m3 = WinkEditorResourceManager.a1().m(component12);
        Intrinsics.checkNotNullExpressionValue(m3, "getInstance().getDownloadFolder(mate)");
        if (!FileUtils.fileExists(X0)) {
            ArrayList<String> childFiles = FileUtils.getChildFiles(m3);
            Intrinsics.checkNotNullExpressionValue(childFiles, "getChildFiles(templateFolder)");
            joinToString$default2 = CollectionsKt___CollectionsKt.joinToString$default(childFiles, ";", null, null, 0, null, null, 62, null);
            w53.b.c(getTAG(), "createPreviewData " + X0 + " not exist. folder files: " + joinToString$default2);
        }
        LightAsset Load = LightAsset.Load(X0, 0);
        if (Load == null || Load.getErrorCode() != 0) {
            Integer valueOf = Load != null ? Integer.valueOf(Load.getErrorCode()) : null;
            ArrayList<String> childFiles2 = FileUtils.getChildFiles(m3);
            Intrinsics.checkNotNullExpressionValue(childFiles2, "getChildFiles(templateFolder)");
            joinToString$default = CollectionsKt___CollectionsKt.joinToString$default(childFiles2, ";", null, null, 0, null, null, 62, null);
            w53.b.c(getTAG(), "createPreviewData loadAsset failed. errorCode: " + valueOf + " file path: " + X0 + ". folder files: " + joinToString$default);
        }
        if (Load != null) {
            Load.performFinalize();
        }
        WinkEditorResourceManager.a1().i0(component12);
        List<String> list = component1;
        List arrayList = list == null || list.isEmpty() ? new ArrayList() : CollectionsKt___CollectionsKt.toMutableList((Collection) com.tencent.mobileqq.wink.utils.o.f326724a.i(component1));
        p pVar = this.winkTemplateShareConfig;
        if (pVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("winkTemplateShareConfig");
            pVar = null;
        }
        List<LocalMediaInfo> d16 = pVar.d().d();
        if (d16 != null) {
            arrayList.addAll(d16);
        }
        WinkEditDataWrapper f16 = com.tencent.mobileqq.wink.editor.draft.c.f(new ArrayList(arrayList), 0, 0, 6, null);
        firstOrNull = CollectionsKt___CollectionsKt.firstOrNull((List<? extends Object>) f16.getEditDatas());
        WinkEditData winkEditData = (WinkEditData) firstOrNull;
        if (winkEditData != null) {
            if (winkEditData.getTemplateMaterialMap() == null) {
                winkEditData.setTemplateMaterialMap(new LinkedHashMap());
            }
            Map<String, MetaMaterial> templateMaterialMap = winkEditData.getTemplateMaterialMap();
            if (templateMaterialMap != null) {
                String str = component12.f30533id;
                Intrinsics.checkNotNullExpressionValue(str, "mate.id");
                templateMaterialMap.put(str, component12);
            }
        }
        if (assetDataMap == null) {
            hashMap = null;
        } else {
            hashMapOf = MapsKt__MapsKt.hashMapOf(TuplesKt.to(LightConstants.EventKey.EVENT_SCRIPT_PARAMS, new JSONObject(assetDataMap).toString()));
            hashMap = hashMapOf;
        }
        String missionId = WinkContext.INSTANCE.d().getMissionId();
        if ((this.currentMissionId.length() > 0) && ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("qqcircle_avatar_forward_feed_mission_id", true)) {
            missionId = this.currentMissionId;
        }
        w53.b.f(getTAG(), "createPreviewData, newMissionId:" + missionId);
        MusicVolumeControlViewModel.VolumeType volumeType = MusicVolumeControlViewModel.VolumeType.TEMPLATE;
        ArrayList<WinkEditData> editDatas = f16.getEditDatas();
        collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(editDatas, 10);
        ArrayList arrayList2 = new ArrayList(collectionSizeOrDefault);
        for (WinkEditData winkEditData2 : editDatas) {
            MediaModel mediaModel = winkEditData2.getMediaModel();
            BackgroundModel backgroundModel2 = winkEditData2.getMediaModel().backgroundModel;
            if (backgroundModel2 != null) {
                copy3 = backgroundModel2.copy((r24 & 1) != 0 ? backgroundModel2.id : null, (r24 & 2) != 0 ? backgroundModel2.renderSize : new SizeF(1080.0f, 1920.0f, null, 4, null), (r24 & 4) != 0 ? backgroundModel2.bgFillMode : null, (r24 & 8) != 0 ? backgroundModel2.bgColor : null, (r24 & 16) != 0 ? backgroundModel2.bgPagPath : null, (r24 & 32) != 0 ? backgroundModel2.ratioType : null, (r24 & 64) != 0 ? backgroundModel2.resPack : null, (r24 & 128) != 0 ? backgroundModel2.categoryId : null, (r24 & 256) != 0 ? backgroundModel2.fillScale : 0.0f, (r24 & 512) != 0 ? backgroundModel2.imageEffect : 0, (r24 & 1024) != 0 ? backgroundModel2.unknownFields() : null);
                backgroundModel = copy3;
            } else {
                backgroundModel = null;
            }
            copy = mediaModel.copy((r39 & 1) != 0 ? mediaModel.id : null, (r39 & 2) != 0 ? mediaModel.name : null, (r39 & 4) != 0 ? mediaModel.version : null, (r39 & 8) != 0 ? mediaModel.createTime : null, (r39 & 16) != 0 ? mediaModel.updateTime : null, (r39 & 32) != 0 ? mediaModel.duration : null, (r39 & 64) != 0 ? mediaModel.videos : null, (r39 & 128) != 0 ? mediaModel.audios : null, (r39 & 256) != 0 ? mediaModel.stickers : null, (r39 & 512) != 0 ? mediaModel.backgroundModel : backgroundModel, (r39 & 1024) != 0 ? mediaModel.filterModels : null, (r39 & 2048) != 0 ? mediaModel.specialEffects : null, (r39 & 4096) != 0 ? mediaModel.transitions : null, (r39 & 8192) != 0 ? mediaModel.templateModel : null, (r39 & 16384) != 0 ? mediaModel.coverInfo : null, (r39 & 32768) != 0 ? mediaModel.exportSetting : null, (r39 & 65536) != 0 ? mediaModel.openHDR : null, (r39 & 131072) != 0 ? mediaModel.hdrModels : null, (r39 & 262144) != 0 ? mediaModel.smoothModels : null, (r39 & 524288) != 0 ? mediaModel.openSuperHDR : null, (r39 & 1048576) != 0 ? mediaModel.unknownFields() : null);
            copy2 = winkEditData2.copy((r37 & 1) != 0 ? winkEditData2.mediaModel : copy, (r37 & 2) != 0 ? winkEditData2.durationUs : 0L, (r37 & 4) != 0 ? winkEditData2.stickerModelMap : null, (r37 & 8) != 0 ? winkEditData2.filterModelMap : null, (r37 & 16) != 0 ? winkEditData2.filterMaterialMap : null, (r37 & 32) != 0 ? winkEditData2.stickerExtraMap : null, (r37 & 64) != 0 ? winkEditData2.openHDR : false, (r37 & 128) != 0 ? winkEditData2.effectModelMap : null, (r37 & 256) != 0 ? winkEditData2.renderModelStr : null, (r37 & 512) != 0 ? winkEditData2.templateMaterialMap : null, (r37 & 1024) != 0 ? winkEditData2.stretchData : null, (r37 & 2048) != 0 ? winkEditData2.assetData : hashMap, (r37 & 4096) != 0 ? winkEditData2.isLakData : false, (r37 & 8192) != 0 ? winkEditData2.mosaicData : null, (r37 & 16384) != 0 ? winkEditData2.challengeData : null, (r37 & 32768) != 0 ? winkEditData2.manualDeletedChallengeTag : null, (r37 & 65536) != 0 ? winkEditData2.isAIElimination : false, (r37 & 131072) != 0 ? winkEditData2.aiTemplate : null);
            arrayList2.add(copy2);
        }
        WinkEditDataWrapper copy$default = WinkEditDataWrapper.copy$default(f16, missionId, null, new ArrayList(arrayList2), null, X0, null, null, 0L, false, "fakeMid_template_bgm", null, false, 0, 0.0f, 1.0f, volumeType, false, null, null, false, 0L, null, null, false, 0L, false, null, false, null, true, null, 0, null, false, false, null, false, false, false, null, null, null, null, false, -536920598, 4095, null);
        w53.b.f("WinkTemplateShareDataSource", "createPreviewData: " + com.tencent.mobileqq.wink.editor.c.g0(component12));
        WinkEditorViewModel.EditMode editMode = WinkEditorViewModel.EditMode.Video;
        ArrayList<WinkEditData> editDatas2 = copy$default.getEditDatas();
        Boolean bool = Boolean.TRUE;
        Boolean bool2 = u53.i.f438428a;
        if (bool2 == null) {
            bool2 = Boolean.FALSE;
        }
        Intrinsics.checkNotNullExpressionValue(bool2, "if (WinkEditPerformanceW\u2026Config.isOpenFFmpegDecode");
        boolean booleanValue = bool2.booleanValue();
        Integer softDecodeThreadCnt = u53.i.f438429b;
        Intrinsics.checkNotNullExpressionValue(softDecodeThreadCnt, "softDecodeThreadCnt");
        dr.WinkTavCutParams winkTavCutParams = new dr.WinkTavCutParams(false, editMode, editDatas2, X0, bool, 1080, 1920, null, hashMap, booleanValue, softDecodeThreadCnt.intValue(), WinkConfig.f317649a.b(), false, copy$default.isFromQzoneText(), copy$default.getTextQzoneText(), WinkTavCutScene.Preview, false, false, 0, 0, false, null, 4128768, null);
        h2(true, startTime, null, loadLightTime - startTime, longValue2 - startTime, longValue - startTime, needDownLoad.getFirst().booleanValue(), needDownLoad.getSecond().booleanValue());
        return new com.tencent.mobileqq.wink.lowthresholdltemplate.a(arrayList, component12, hashMap, copy$default, winkTavCutParams);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final r X1() {
        return (r) this.dataSource.getValue();
    }

    private final WinkEditDataWrapper b2(WinkEditDataWrapper winkEditDataWrapper) {
        ResourceModel resourceModel;
        int collectionSizeOrDefault;
        List mutableListOf;
        MediaModel copy;
        WinkEditData copy2;
        MediaClip mediaClip = winkEditDataWrapper.getEditDatas().get(0).getMediaModel().videos.get(0);
        ResourceModel resourceModel2 = mediaClip.resource;
        ResourceModel resourceModel3 = null;
        if (resourceModel2 != null) {
            resourceModel = resourceModel2.copy((r35 & 1) != 0 ? resourceModel2.id : null, (r35 & 2) != 0 ? resourceModel2.path : null, (r35 & 4) != 0 ? Long.valueOf(resourceModel2.scaleDuration) : 3520000L, (r35 & 8) != 0 ? Long.valueOf(resourceModel2.sourceStart) : null, (r35 & 16) != 0 ? Long.valueOf(resourceModel2.sourceDuration) : 3520000L, (r35 & 32) != 0 ? Long.valueOf(resourceModel2.selectStart) : null, (r35 & 64) != 0 ? Long.valueOf(resourceModel2.selectDuration) : 3520000L, (r35 & 128) != 0 ? resourceModel2.type : null, (r35 & 256) != 0 ? resourceModel2.size : null, (r35 & 512) != 0 ? Float.valueOf(resourceModel2.volume) : null, (r35 & 1024) != 0 ? resourceModel2.extras : null, (r35 & 2048) != 0 ? resourceModel2.picClipRect : null, (r35 & 4096) != 0 ? resourceModel2.reversePath : null, (r35 & 8192) != 0 ? resourceModel2.normalPath : null, (r35 & 16384) != 0 ? resourceModel2.isReverseMode : null, (r35 & 32768) != 0 ? Float.valueOf(resourceModel2.deblurScore) : null, (r35 & 65536) != 0 ? resourceModel2.unknownFields() : null);
        } else {
            resourceModel = null;
        }
        MediaClip copy$default = MediaClip.copy$default(mediaClip, resourceModel, null, null, null, null, null, null, 126, null);
        MediaClip mediaClip2 = winkEditDataWrapper.getEditDatas().get(0).getMediaModel().videos.get(1);
        ResourceModel resourceModel4 = mediaClip2.resource;
        if (resourceModel4 != null) {
            resourceModel3 = resourceModel4.copy((r35 & 1) != 0 ? resourceModel4.id : null, (r35 & 2) != 0 ? resourceModel4.path : null, (r35 & 4) != 0 ? Long.valueOf(resourceModel4.scaleDuration) : 5680000L, (r35 & 8) != 0 ? Long.valueOf(resourceModel4.sourceStart) : null, (r35 & 16) != 0 ? Long.valueOf(resourceModel4.sourceDuration) : 5680000L, (r35 & 32) != 0 ? Long.valueOf(resourceModel4.selectStart) : null, (r35 & 64) != 0 ? Long.valueOf(resourceModel4.selectDuration) : 5680000L, (r35 & 128) != 0 ? resourceModel4.type : null, (r35 & 256) != 0 ? resourceModel4.size : null, (r35 & 512) != 0 ? Float.valueOf(resourceModel4.volume) : null, (r35 & 1024) != 0 ? resourceModel4.extras : null, (r35 & 2048) != 0 ? resourceModel4.picClipRect : null, (r35 & 4096) != 0 ? resourceModel4.reversePath : null, (r35 & 8192) != 0 ? resourceModel4.normalPath : null, (r35 & 16384) != 0 ? resourceModel4.isReverseMode : null, (r35 & 32768) != 0 ? Float.valueOf(resourceModel4.deblurScore) : null, (r35 & 65536) != 0 ? resourceModel4.unknownFields() : null);
        }
        MediaClip copy$default2 = MediaClip.copy$default(mediaClip2, resourceModel3, null, null, null, null, null, null, 126, null);
        ArrayList<WinkEditData> editDatas = winkEditDataWrapper.getEditDatas();
        collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(editDatas, 10);
        ArrayList arrayList = new ArrayList(collectionSizeOrDefault);
        for (WinkEditData winkEditData : editDatas) {
            MediaModel mediaModel = winkEditData.getMediaModel();
            mutableListOf = CollectionsKt__CollectionsKt.mutableListOf(copy$default, copy$default2);
            copy = mediaModel.copy((r39 & 1) != 0 ? mediaModel.id : null, (r39 & 2) != 0 ? mediaModel.name : null, (r39 & 4) != 0 ? mediaModel.version : null, (r39 & 8) != 0 ? mediaModel.createTime : null, (r39 & 16) != 0 ? mediaModel.updateTime : null, (r39 & 32) != 0 ? mediaModel.duration : null, (r39 & 64) != 0 ? mediaModel.videos : mutableListOf, (r39 & 128) != 0 ? mediaModel.audios : null, (r39 & 256) != 0 ? mediaModel.stickers : null, (r39 & 512) != 0 ? mediaModel.backgroundModel : null, (r39 & 1024) != 0 ? mediaModel.filterModels : null, (r39 & 2048) != 0 ? mediaModel.specialEffects : null, (r39 & 4096) != 0 ? mediaModel.transitions : null, (r39 & 8192) != 0 ? mediaModel.templateModel : null, (r39 & 16384) != 0 ? mediaModel.coverInfo : null, (r39 & 32768) != 0 ? mediaModel.exportSetting : null, (r39 & 65536) != 0 ? mediaModel.openHDR : null, (r39 & 131072) != 0 ? mediaModel.hdrModels : null, (r39 & 262144) != 0 ? mediaModel.smoothModels : null, (r39 & 524288) != 0 ? mediaModel.openSuperHDR : null, (r39 & 1048576) != 0 ? mediaModel.unknownFields() : null);
            copy2 = winkEditData.copy((r37 & 1) != 0 ? winkEditData.mediaModel : copy, (r37 & 2) != 0 ? winkEditData.durationUs : 0L, (r37 & 4) != 0 ? winkEditData.stickerModelMap : null, (r37 & 8) != 0 ? winkEditData.filterModelMap : null, (r37 & 16) != 0 ? winkEditData.filterMaterialMap : null, (r37 & 32) != 0 ? winkEditData.stickerExtraMap : null, (r37 & 64) != 0 ? winkEditData.openHDR : false, (r37 & 128) != 0 ? winkEditData.effectModelMap : null, (r37 & 256) != 0 ? winkEditData.renderModelStr : null, (r37 & 512) != 0 ? winkEditData.templateMaterialMap : null, (r37 & 1024) != 0 ? winkEditData.stretchData : null, (r37 & 2048) != 0 ? winkEditData.assetData : null, (r37 & 4096) != 0 ? winkEditData.isLakData : false, (r37 & 8192) != 0 ? winkEditData.mosaicData : null, (r37 & 16384) != 0 ? winkEditData.challengeData : null, (r37 & 32768) != 0 ? winkEditData.manualDeletedChallengeTag : null, (r37 & 65536) != 0 ? winkEditData.isAIElimination : false, (r37 & 131072) != 0 ? winkEditData.aiTemplate : null);
            arrayList.add(copy2);
        }
        return WinkEditDataWrapper.copy$default(winkEditDataWrapper, null, null, new ArrayList(arrayList), null, null, null, null, 0L, false, null, null, false, 0, 0.0f, 0.0f, null, false, null, null, false, 0L, null, null, false, 0L, false, null, false, null, false, null, 0, null, false, false, null, false, false, false, null, null, null, null, false, -5, 4095, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object c2(Continuation<? super Pair<Boolean, Boolean>> continuation) {
        Continuation intercepted;
        Object coroutine_suspended;
        intercepted = IntrinsicsKt__IntrinsicsJvmKt.intercepted(continuation);
        SafeContinuation safeContinuation = new SafeContinuation(intercepted);
        if (((IAECameraLauncher) QRoute.api(IAECameraLauncher.class)).isCameraResReady(new a(safeContinuation))) {
            Result.Companion companion = Result.INSTANCE;
            safeContinuation.resumeWith(Result.m476constructorimpl(new Pair(Boxing.boxBoolean(true), Boxing.boxBoolean(false))));
        }
        Object orThrow = safeContinuation.getOrThrow();
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (orThrow == coroutine_suspended) {
            DebugProbes.probeCoroutineSuspended(continuation);
        }
        return orThrow;
    }

    private final boolean d2(String fromType) {
        if (!Intrinsics.areEqual(fromType, QQWinkConstants.WinkLowLevelTemplateShareConstant.QQ_AVATAR_ALBUM) && !Intrinsics.areEqual(fromType, QQWinkConstants.WinkLowLevelTemplateShareConstant.QQ_AVATAR_HISTORY)) {
            return false;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void g2(String publishContent, WinkEditDataWrapper winkEditDataWrapper) {
        int collectionSizeOrDefault;
        int collectionSizeOrDefault2;
        WinkEditDataWrapper copy$default;
        MediaModel copy;
        WinkEditData copy2;
        p pVar;
        int i3;
        ResourceModel resourceModel;
        ResourceModel copy3;
        List<MediaClip> list = winkEditDataWrapper.getEditDatas().get(0).getMediaModel().videos;
        collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(list, 10);
        ArrayList arrayList = new ArrayList(collectionSizeOrDefault);
        for (MediaClip mediaClip : list) {
            ResourceModel resourceModel2 = mediaClip.resource;
            if (resourceModel2 != null) {
                copy3 = resourceModel2.copy((r35 & 1) != 0 ? resourceModel2.id : null, (r35 & 2) != 0 ? resourceModel2.path : null, (r35 & 4) != 0 ? Long.valueOf(resourceModel2.scaleDuration) : 10000000L, (r35 & 8) != 0 ? Long.valueOf(resourceModel2.sourceStart) : null, (r35 & 16) != 0 ? Long.valueOf(resourceModel2.sourceDuration) : 10000000L, (r35 & 32) != 0 ? Long.valueOf(resourceModel2.selectStart) : null, (r35 & 64) != 0 ? Long.valueOf(resourceModel2.selectDuration) : 10000000L, (r35 & 128) != 0 ? resourceModel2.type : null, (r35 & 256) != 0 ? resourceModel2.size : null, (r35 & 512) != 0 ? Float.valueOf(resourceModel2.volume) : null, (r35 & 1024) != 0 ? resourceModel2.extras : null, (r35 & 2048) != 0 ? resourceModel2.picClipRect : null, (r35 & 4096) != 0 ? resourceModel2.reversePath : null, (r35 & 8192) != 0 ? resourceModel2.normalPath : null, (r35 & 16384) != 0 ? resourceModel2.isReverseMode : null, (r35 & 32768) != 0 ? Float.valueOf(resourceModel2.deblurScore) : null, (r35 & 65536) != 0 ? resourceModel2.unknownFields() : null);
                resourceModel = copy3;
            } else {
                resourceModel = null;
            }
            arrayList.add(MediaClip.copy$default(mediaClip, resourceModel, null, null, null, null, null, null, 126, null));
        }
        ArrayList arrayList2 = new ArrayList(arrayList);
        p pVar2 = this.winkTemplateShareConfig;
        if (pVar2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("winkTemplateShareConfig");
            pVar2 = null;
        }
        String str = pVar2.getCom.tencent.mobileqq.profilecard.api.IProfileCardConst.KEY_FROM_TYPE java.lang.String();
        if (d2(str)) {
            copy$default = b2(winkEditDataWrapper);
        } else {
            ArrayList<WinkEditData> editDatas = winkEditDataWrapper.getEditDatas();
            collectionSizeOrDefault2 = CollectionsKt__IterablesKt.collectionSizeOrDefault(editDatas, 10);
            ArrayList arrayList3 = new ArrayList(collectionSizeOrDefault2);
            for (WinkEditData winkEditData : editDatas) {
                ArrayList arrayList4 = arrayList3;
                copy = r6.copy((r39 & 1) != 0 ? r6.id : null, (r39 & 2) != 0 ? r6.name : null, (r39 & 4) != 0 ? r6.version : null, (r39 & 8) != 0 ? r6.createTime : null, (r39 & 16) != 0 ? r6.updateTime : null, (r39 & 32) != 0 ? r6.duration : null, (r39 & 64) != 0 ? r6.videos : arrayList2, (r39 & 128) != 0 ? r6.audios : null, (r39 & 256) != 0 ? r6.stickers : null, (r39 & 512) != 0 ? r6.backgroundModel : null, (r39 & 1024) != 0 ? r6.filterModels : null, (r39 & 2048) != 0 ? r6.specialEffects : null, (r39 & 4096) != 0 ? r6.transitions : null, (r39 & 8192) != 0 ? r6.templateModel : null, (r39 & 16384) != 0 ? r6.coverInfo : null, (r39 & 32768) != 0 ? r6.exportSetting : null, (r39 & 65536) != 0 ? r6.openHDR : null, (r39 & 131072) != 0 ? r6.hdrModels : null, (r39 & 262144) != 0 ? r6.smoothModels : null, (r39 & 524288) != 0 ? r6.openSuperHDR : null, (r39 & 1048576) != 0 ? winkEditData.getMediaModel().unknownFields() : null);
                copy2 = winkEditData.copy((r37 & 1) != 0 ? winkEditData.mediaModel : copy, (r37 & 2) != 0 ? winkEditData.durationUs : 0L, (r37 & 4) != 0 ? winkEditData.stickerModelMap : null, (r37 & 8) != 0 ? winkEditData.filterModelMap : null, (r37 & 16) != 0 ? winkEditData.filterMaterialMap : null, (r37 & 32) != 0 ? winkEditData.stickerExtraMap : null, (r37 & 64) != 0 ? winkEditData.openHDR : false, (r37 & 128) != 0 ? winkEditData.effectModelMap : null, (r37 & 256) != 0 ? winkEditData.renderModelStr : null, (r37 & 512) != 0 ? winkEditData.templateMaterialMap : null, (r37 & 1024) != 0 ? winkEditData.stretchData : null, (r37 & 2048) != 0 ? winkEditData.assetData : null, (r37 & 4096) != 0 ? winkEditData.isLakData : false, (r37 & 8192) != 0 ? winkEditData.mosaicData : null, (r37 & 16384) != 0 ? winkEditData.challengeData : null, (r37 & 32768) != 0 ? winkEditData.manualDeletedChallengeTag : null, (r37 & 65536) != 0 ? winkEditData.isAIElimination : false, (r37 & 131072) != 0 ? winkEditData.aiTemplate : null);
                arrayList4.add(copy2);
                arrayList3 = arrayList4;
            }
            copy$default = WinkEditDataWrapper.copy$default(winkEditDataWrapper, null, null, new ArrayList(arrayList3), null, null, null, null, 0L, false, null, null, false, 0, 0.0f, 0.0f, null, false, null, null, false, 0L, null, null, false, 0L, false, null, false, null, false, null, 0, null, false, false, null, false, false, false, null, null, null, null, false, -5, 4095, null);
        }
        com.tencent.mobileqq.wink.editor.draft.a.h(copy$default, winkEditDataWrapper.getMissionId());
        com.tencent.mobileqq.wink.editor.draft.a.i(copy$default, winkEditDataWrapper.getMissionId());
        Bundle bundle = new Bundle();
        p pVar3 = this.winkTemplateShareConfig;
        if (pVar3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("winkTemplateShareConfig");
            pVar = null;
        } else {
            pVar = pVar3;
        }
        bundle.putString(QQWinkConstants.WINK_PUBLISH_TASK_ID, pVar.c().getTaskId());
        bundle.putString(WinkDaTongReportConstant.ElementParamKey.XSJ_AVATAR_PREVIEW_SOURCE, str);
        if (Intrinsics.areEqual(str, QQWinkConstants.WinkLowLevelTemplateShareConstant.QCIRCLE_AVATAR)) {
            i3 = 27;
        } else {
            i3 = 26;
        }
        OneClickPublishingHelper oneClickPublishingHelper = OneClickPublishingHelper.f325628a;
        String missionId = winkEditDataWrapper.getMissionId();
        Intrinsics.checkNotNull(missionId);
        OneClickPublishingHelper.z(oneClickPublishingHelper, i3, missionId, null, publishContent, bundle, false, 32, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void h2(boolean result, long startTime, Throwable err, long lightCost, long templateCost, long imgCost, boolean needDownLoadSo, boolean needDownLoadTemplate) {
        String str;
        boolean z16;
        int i3;
        Object obj;
        Map mapOf;
        p pVar = this.winkTemplateShareConfig;
        String str2 = null;
        if (pVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("winkTemplateShareConfig");
            pVar = null;
        }
        p.PerformanceConfig performanceConfig = pVar.getPerformanceConfig();
        if (performanceConfig != null) {
            str = performanceConfig.getDENGTALoadResultTimeKey();
        } else {
            str = null;
        }
        if (str != null && str.length() != 0) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (z16) {
            return;
        }
        if (result) {
            this.loadedTime = SystemClock.elapsedRealtime();
        }
        com.tencent.mobileqq.wink.report.e eVar = com.tencent.mobileqq.wink.report.e.f326265a;
        p pVar2 = this.winkTemplateShareConfig;
        if (pVar2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("winkTemplateShareConfig");
            pVar2 = null;
        }
        p.PerformanceConfig performanceConfig2 = pVar2.getPerformanceConfig();
        if (performanceConfig2 != null) {
            str2 = performanceConfig2.getDENGTALoadResultTimeKey();
        }
        Intrinsics.checkNotNull(str2);
        Pair[] pairArr = new Pair[8];
        if (err instanceof TemplateShareException) {
            i3 = ((TemplateShareException) err).getCode();
        } else if (err != null) {
            i3 = -1;
        } else {
            i3 = 0;
        }
        pairArr[0] = TuplesKt.to(WinkDengtaReportConstant.Params.AVATAR_SHARE_LOAD_RESULT, String.valueOf(i3));
        pairArr[1] = TuplesKt.to(WinkDengtaReportConstant.Params.AVATAR_SHARE_LOAD_ALL_RESOURCE_TIME, String.valueOf(this.loadedTime - startTime));
        String str3 = "0";
        pairArr[2] = TuplesKt.to(WinkDengtaReportConstant.Params.AVATAR_SHARE_LOAD_USER_INFO_TIME, "0");
        pairArr[3] = TuplesKt.to(WinkDengtaReportConstant.Params.AVATAR_SHARE_LOAD_LIGHT_BUNDLE_TIME, String.valueOf(lightCost));
        pairArr[4] = TuplesKt.to(WinkDengtaReportConstant.Params.AVATAR_SHARE_LOAD_TEMPLATE_TIME, String.valueOf(templateCost));
        pairArr[5] = TuplesKt.to(WinkDengtaReportConstant.Params.AVATAR_SHARE_LOAD_IMAGE_TIME, String.valueOf(imgCost));
        if (needDownLoadSo) {
            obj = "0";
        } else {
            obj = "1";
        }
        pairArr[6] = TuplesKt.to(WinkDengtaReportConstant.Params.REPORT_PARAM_EDITOR_RES_READY, obj);
        if (!needDownLoadTemplate) {
            str3 = "1";
        }
        pairArr[7] = TuplesKt.to(WinkDengtaReportConstant.Params.REPORT_PARAM_TEMPLATE_RES_READY, str3);
        mapOf = MapsKt__MapsKt.mapOf(pairArr);
        com.tencent.mobileqq.wink.report.e.o(eVar, str2, mapOf, false, 4, null);
    }

    private final void i2(long readyCost) {
        String str;
        boolean z16;
        Map mapOf;
        p pVar = this.winkTemplateShareConfig;
        String str2 = null;
        if (pVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("winkTemplateShareConfig");
            pVar = null;
        }
        p.PerformanceConfig performanceConfig = pVar.getPerformanceConfig();
        if (performanceConfig != null) {
            str = performanceConfig.getDENGTAPlayReadyTimeKey();
        } else {
            str = null;
        }
        if (str != null && str.length() != 0) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (z16) {
            return;
        }
        com.tencent.mobileqq.wink.report.e eVar = com.tencent.mobileqq.wink.report.e.f326265a;
        p pVar2 = this.winkTemplateShareConfig;
        if (pVar2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("winkTemplateShareConfig");
            pVar2 = null;
        }
        p.PerformanceConfig performanceConfig2 = pVar2.getPerformanceConfig();
        if (performanceConfig2 != null) {
            str2 = performanceConfig2.getDENGTAPlayReadyTimeKey();
        }
        String str3 = str2;
        Intrinsics.checkNotNull(str3);
        mapOf = MapsKt__MapsJVMKt.mapOf(TuplesKt.to(WinkDengtaReportConstant.Params.AVATAR_SHARE_READY_PLAY_TIME, String.valueOf(readyCost)));
        com.tencent.mobileqq.wink.report.e.o(eVar, str3, mapOf, false, 4, null);
    }

    @NotNull
    public final LiveData<Result<com.tencent.mobileqq.wink.lowthresholdltemplate.a>> Z1() {
        return this.prepared;
    }

    @NotNull
    public final LiveData<t73.a<com.tencent.mobileqq.wink.lowthresholdltemplate.b>> a2() {
        return this.previewEvent;
    }

    public final void e2(@NotNull ICutSession session, long coverTimeUs) {
        Intrinsics.checkNotNullParameter(session, "session");
        Result<com.tencent.mobileqq.wink.lowthresholdltemplate.a> value = this._prepared.getValue();
        boolean z16 = false;
        if (value != null && Result.m483isSuccessimpl(value.getValue())) {
            z16 = true;
        }
        if (!z16) {
            return;
        }
        t73.b.a(this._previewEvent, b.d.f323442a);
        this.coverTime = coverTimeUs;
        this.session = session;
        i2(SystemClock.elapsedRealtime() - this.loadedTime);
    }

    public final void f2() {
        Result<com.tencent.mobileqq.wink.lowthresholdltemplate.a> value = this._prepared.getValue();
        ICutSession iCutSession = this.session;
        boolean z16 = false;
        if (value != null && Result.m483isSuccessimpl(value.getValue())) {
            z16 = true;
        }
        if (z16 && iCutSession != null) {
            Object value2 = value.getValue();
            ResultKt.throwOnFailure(value2);
            t73.b.b(this._previewEvent, b.C9054b.f323440a);
            Object value3 = value.getValue();
            ResultKt.throwOnFailure(value3);
            BuildersKt__Builders_commonKt.launch$default(this.viewModelScope, null, null, new WinkTemplateSharePreviewViewModel$onSaveShare$1(this, (com.tencent.mobileqq.wink.lowthresholdltemplate.a) value2, iCutSession, ((com.tencent.mobileqq.wink.lowthresholdltemplate.a) value3).getWinkEditDataWrapper(), null), 3, null);
            return;
        }
        t73.b.a(this._previewEvent, b.c.f323441a);
    }

    @Override // com.tencent.biz.richframework.part.BaseViewModel
    @NotNull
    /* renamed from: getLogTag */
    public String getTAG() {
        return "WinkTemplateSharePreviewViewModel";
    }

    public final void j2(boolean publish, @NotNull String publishContent, @NotNull String missionId) {
        Intrinsics.checkNotNullParameter(publishContent, "publishContent");
        Intrinsics.checkNotNullParameter(missionId, "missionId");
        w53.b.f(getTAG(), "requestAndProcessData begin. publish: " + publish + ", missionId:" + missionId);
        this.publishling = publish;
        this.currentMissionId = missionId;
        BuildersKt__Builders_commonKt.launch$default(this.viewModelScope, new b(CoroutineExceptionHandler.INSTANCE, this), null, new WinkTemplateSharePreviewViewModel$requestAndProcessData$1(publish, this, publishContent, SystemClock.elapsedRealtime(), null), 2, null);
    }

    public final void k2(@NotNull p config) {
        Intrinsics.checkNotNullParameter(config, "config");
        this.winkTemplateShareConfig = config;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.lifecycle.ViewModel
    public void onCleared() {
        super.onCleared();
        this.session = null;
        if (!this.publishling) {
            CoroutineScopeKt.cancel$default(this.viewModelScope, null, 1, null);
        }
    }

    public final void U1() {
    }
}

package com.tencent.mobileqq.wink.lowthresholdltemplate;

import android.text.TextUtils;
import android.view.View;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import camera.XEFFECT_MATERIALS_GENERAL_DATASTRUCT.MetaCategory;
import camera.XEFFECT_MATERIALS_GENERAL_DATASTRUCT.MetaMaterial;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.aelight.camera.download.api.AEResInfo;
import com.tencent.aelight.camera.download.api.IAEMultiDownloadCallBack;
import com.tencent.aelight.camera.entry.api.IAECameraLauncher;
import com.tencent.biz.richframework.part.BaseViewModel;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qaddefine.QAdReportDefine$AdReporterParams;
import com.tencent.mobileqq.wink.WinkConfig;
import com.tencent.mobileqq.wink.context.WinkContext;
import com.tencent.mobileqq.wink.edit.manager.WinkEditorResourceManager;
import com.tencent.mobileqq.wink.editor.WinkEditorViewModel;
import com.tencent.mobileqq.wink.editor.dr;
import com.tencent.mobileqq.wink.editor.draft.WinkEditData;
import com.tencent.mobileqq.wink.editor.draft.WinkEditDataWrapper;
import com.tencent.mobileqq.wink.editor.model.WinkTavCutScene;
import com.tencent.mobileqq.wink.listener.ResDownLoadListener;
import com.tencent.mobileqq.winkreport.datong.WinkDTParamBuilder;
import com.tencent.qcircle.weishi.module.publisher.entity.TemplateBean;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.constants.ClickPolicy;
import com.tencent.qqlive.module.videoreport.constants.ExposurePolicy;
import com.tencent.rmonitor.custom.ICustomDataEditor;
import com.tencent.videocut.model.BackgroundModel;
import com.tencent.videocut.model.MediaModel;
import com.tencent.videocut.model.SizeF;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.SafeContinuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugProbes;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.SupervisorKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u00002\u00020\u0001:\u0001EB\u0007\u00a2\u0006\u0004\bC\u0010DJ8\u0010\n\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00020\u00042\u0012\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00070\u0004H\u0002J\u001f\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00070\u0004H\u0082@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u000b\u0010\fJ\b\u0010\u000e\u001a\u00020\rH\u0016J\u000e\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0010\u001a\u00020\u000fJ\u000e\u0010\u0014\u001a\u00020\u00112\u0006\u0010\u0013\u001a\u00020\rJ'\u0010\u0015\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00070\u00042\u0006\u0010\u0013\u001a\u00020\rH\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0015\u0010\u0016J\u001b\u0010\u0017\u001a\u00020\u00052\u0006\u0010\u0013\u001a\u00020\rH\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0017\u0010\u0016J.\u0010\u001d\u001a\u00020\u00112\u0006\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u001a\u001a\u00020\r2\u0016\b\u0002\u0010\u001c\u001a\u0010\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\r\u0018\u00010\u001bJ.\u0010\u001e\u001a\u00020\u00112\u0006\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u001a\u001a\u00020\r2\u0016\b\u0002\u0010\u001c\u001a\u0010\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\r\u0018\u00010\u001bR\u0014\u0010\"\u001a\u00020\u001f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b \u0010!R#\u0010'\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0$0#8\u0002X\u0082\u0004\u00f8\u0001\u0000\u00a2\u0006\u0006\n\u0004\b%\u0010&R&\u0010-\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0$0(8\u0006\u00f8\u0001\u0000\u00a2\u0006\f\n\u0004\b)\u0010*\u001a\u0004\b+\u0010,R\"\u0010\u0010\u001a\u00020\u000f8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b.\u0010/\u001a\u0004\b0\u00101\"\u0004\b2\u00103R\u001b\u00109\u001a\u0002048BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b5\u00106\u001a\u0004\b7\u00108R*\u0010B\u001a\n\u0012\u0004\u0012\u00020;\u0018\u00010:8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b<\u0010=\u001a\u0004\b>\u0010?\"\u0004\b@\u0010A\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006F"}, d2 = {"Lcom/tencent/mobileqq/wink/lowthresholdltemplate/WinkPhotoTemplateViewModel;", "Lcom/tencent/biz/richframework/part/BaseViewModel;", "", "loadLightTime", "Lkotlin/Pair;", "Lcamera/XEFFECT_MATERIALS_GENERAL_DATASTRUCT/MetaMaterial;", "loadMateResult", "", "needDownLoad", "Lcom/tencent/mobileqq/wink/lowthresholdltemplate/WinkPhotoTemplateViewModel$a;", "P1", ICustomDataEditor.STRING_ARRAY_PARAM_2, "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "", "getLogTag", "", "height", "", "c2", "templateId", "b2", "Q1", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "X1", "Landroid/view/View;", "view", "eid", "", "extParams", "T1", "R1", "Lkotlinx/coroutines/CoroutineScope;", "i", "Lkotlinx/coroutines/CoroutineScope;", "viewModelScope", "Landroidx/lifecycle/MutableLiveData;", "Lkotlin/Result;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Landroidx/lifecycle/MutableLiveData;", "_prepared", "Landroidx/lifecycle/LiveData;", BdhLogUtil.LogTag.Tag_Conn, "Landroidx/lifecycle/LiveData;", "Z1", "()Landroidx/lifecycle/LiveData;", "prepared", "D", "I", "getHeight", "()I", "setHeight", "(I)V", "Lcom/tencent/mobileqq/wink/lowthresholdltemplate/r;", "E", "Lkotlin/Lazy;", "W1", "()Lcom/tencent/mobileqq/wink/lowthresholdltemplate/r;", "dataSource", "", "Lcom/tencent/mobileqq/activity/photo/LocalMediaInfo;", UserInfo.SEX_FEMALE, "Ljava/util/List;", "getMediaList", "()Ljava/util/List;", "d2", "(Ljava/util/List;)V", "mediaList", "<init>", "()V", "a", "qq-wink-temp-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes21.dex */
public final class WinkPhotoTemplateViewModel extends BaseViewModel {

    /* renamed from: C, reason: from kotlin metadata */
    @NotNull
    private final LiveData<Result<a>> prepared;

    /* renamed from: D, reason: from kotlin metadata */
    private int height;

    /* renamed from: E, reason: from kotlin metadata */
    @NotNull
    private final Lazy dataSource;

    /* renamed from: F, reason: from kotlin metadata */
    @Nullable
    private List<? extends LocalMediaInfo> mediaList;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final CoroutineScope viewModelScope = CoroutineScopeKt.CoroutineScope(SupervisorKt.SupervisorJob$default((Job) null, 1, (Object) null).plus(Dispatchers.getMain()));

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final MutableLiveData<Result<a>> _prepared;

    @Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0016\u0018\u00002\u00020\u0001BE\u0012\u000e\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0002\u0012\u0006\u0010\r\u001a\u00020\t\u0012\u0014\u0010\u0014\u001a\u0010\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u000e\u0012\u0006\u0010\u0019\u001a\u00020\u0015\u0012\u0006\u0010\u001e\u001a\u00020\u001a\u00a2\u0006\u0004\b\u001f\u0010 R\u001f\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007R\u0017\u0010\r\u001a\u00020\t8\u0006\u00a2\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\u0004\u0010\fR%\u0010\u0014\u001a\u0010\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u000e8\u0006\u00a2\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013R\u0017\u0010\u0019\u001a\u00020\u00158\u0006\u00a2\u0006\f\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\n\u0010\u0018R\u0017\u0010\u001e\u001a\u00020\u001a8\u0006\u00a2\u0006\f\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u0010\u0010\u001d\u00a8\u0006!"}, d2 = {"Lcom/tencent/mobileqq/wink/lowthresholdltemplate/WinkPhotoTemplateViewModel$a;", "", "", "Lcom/tencent/mobileqq/activity/photo/LocalMediaInfo;", "a", "Ljava/util/List;", "getLocalMedias", "()Ljava/util/List;", "localMedias", "Lcamera/XEFFECT_MATERIALS_GENERAL_DATASTRUCT/MetaMaterial;", "b", "Lcamera/XEFFECT_MATERIALS_GENERAL_DATASTRUCT/MetaMaterial;", "()Lcamera/XEFFECT_MATERIALS_GENERAL_DATASTRUCT/MetaMaterial;", WadlProxyConsts.KEY_MATERIAL, "", "", "c", "Ljava/util/Map;", "getAssetData", "()Ljava/util/Map;", "assetData", "Lcom/tencent/mobileqq/wink/editor/draft/WinkEditDataWrapper;", "d", "Lcom/tencent/mobileqq/wink/editor/draft/WinkEditDataWrapper;", "()Lcom/tencent/mobileqq/wink/editor/draft/WinkEditDataWrapper;", "winkEditDataWrapper", "Lcom/tencent/mobileqq/wink/editor/dr$c;", "e", "Lcom/tencent/mobileqq/wink/editor/dr$c;", "()Lcom/tencent/mobileqq/wink/editor/dr$c;", "winkTavCutParams", "<init>", "(Ljava/util/List;Lcamera/XEFFECT_MATERIALS_GENERAL_DATASTRUCT/MetaMaterial;Ljava/util/Map;Lcom/tencent/mobileqq/wink/editor/draft/WinkEditDataWrapper;Lcom/tencent/mobileqq/wink/editor/dr$c;)V", "qq-wink-temp-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes21.dex */
    public static class a {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        @Nullable
        private final List<LocalMediaInfo> localMedias;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final MetaMaterial material;

        /* renamed from: c, reason: collision with root package name and from kotlin metadata */
        @Nullable
        private final Map<String, String> assetData;

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final WinkEditDataWrapper winkEditDataWrapper;

        /* renamed from: e, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final dr.WinkTavCutParams winkTavCutParams;

        /* JADX WARN: Multi-variable type inference failed */
        public a(@Nullable List<? extends LocalMediaInfo> list, @NotNull MetaMaterial material, @Nullable Map<String, String> map, @NotNull WinkEditDataWrapper winkEditDataWrapper, @NotNull dr.WinkTavCutParams winkTavCutParams) {
            Intrinsics.checkNotNullParameter(material, "material");
            Intrinsics.checkNotNullParameter(winkEditDataWrapper, "winkEditDataWrapper");
            Intrinsics.checkNotNullParameter(winkTavCutParams, "winkTavCutParams");
            this.localMedias = list;
            this.material = material;
            this.assetData = map;
            this.winkEditDataWrapper = winkEditDataWrapper;
            this.winkTavCutParams = winkTavCutParams;
        }

        @NotNull
        /* renamed from: a, reason: from getter */
        public final MetaMaterial getMaterial() {
            return this.material;
        }

        @NotNull
        /* renamed from: b, reason: from getter */
        public final WinkEditDataWrapper getWinkEditDataWrapper() {
            return this.winkEditDataWrapper;
        }

        @NotNull
        /* renamed from: c, reason: from getter */
        public final dr.WinkTavCutParams getWinkTavCutParams() {
            return this.winkTavCutParams;
        }
    }

    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016\u00a8\u0006\t"}, d2 = {"com/tencent/mobileqq/wink/lowthresholdltemplate/WinkPhotoTemplateViewModel$b", "Lcom/tencent/mobileqq/wink/listener/ResDownLoadListener;", "", "isSuccess", "", "onDownloadFinish", "", "progress", "onProgressUpdate", "qq-wink-temp-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes21.dex */
    public static final class b implements ResDownLoadListener {

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ MetaMaterial f323409b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ Continuation<Pair<MetaMaterial, Boolean>> f323410c;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ Ref.BooleanRef f323411d;

        /* JADX WARN: Multi-variable type inference failed */
        b(MetaMaterial metaMaterial, Continuation<? super Pair<MetaMaterial, Boolean>> continuation, Ref.BooleanRef booleanRef) {
            this.f323409b = metaMaterial;
            this.f323410c = continuation;
            this.f323411d = booleanRef;
        }

        @Override // com.tencent.mobileqq.wink.listener.ResDownLoadListener
        public void onDownloadFinish(boolean isSuccess) {
            w53.b.f(WinkPhotoTemplateViewModel.this.getTAG(), "downloadMaterialed: " + isSuccess);
            if (isSuccess) {
                WinkEditorResourceManager.a1().i0(this.f323409b);
                Continuation<Pair<MetaMaterial, Boolean>> continuation = this.f323410c;
                Result.Companion companion = Result.INSTANCE;
                continuation.resumeWith(Result.m476constructorimpl(new Pair(this.f323409b, Boolean.valueOf(this.f323411d.element))));
                return;
            }
            Continuation<Pair<MetaMaterial, Boolean>> continuation2 = this.f323410c;
            Result.Companion companion2 = Result.INSTANCE;
            continuation2.resumeWith(Result.m476constructorimpl(ResultKt.createFailure(new IllegalStateException("download mate fail"))));
        }

        @Override // com.tencent.mobileqq.wink.listener.ResDownLoadListener
        public void onProgressUpdate(int progress) {
            w53.b.a(WinkPhotoTemplateViewModel.this.getTAG(), "downloadMaterial: " + progress);
        }
    }

    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\"\u0010\t\u001a\u00020\b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016\u00a8\u0006\n"}, d2 = {"com/tencent/mobileqq/wink/lowthresholdltemplate/WinkPhotoTemplateViewModel$c", "Lcom/tencent/aelight/camera/download/api/IAEMultiDownloadCallBack;", "Lcom/tencent/aelight/camera/download/api/AEResInfo;", "aeResInfo", "", "downloaded", "", QAdReportDefine$AdReporterParams.K_Q_AD_REPORTER_PARAM_KEY_ERROR_TYPE, "", "onAEMultiDownloadFinish", "qq-wink-temp-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes21.dex */
    public static final class c implements IAEMultiDownloadCallBack {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Continuation<Pair<Boolean, Boolean>> f323412a;

        /* JADX WARN: Multi-variable type inference failed */
        c(Continuation<? super Pair<Boolean, Boolean>> continuation) {
            this.f323412a = continuation;
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
            Continuation<Pair<Boolean, Boolean>> continuation = this.f323412a;
            Result.Companion companion = Result.INSTANCE;
            continuation.resumeWith(Result.m476constructorimpl(new Pair(Boolean.valueOf(downloaded), Boolean.TRUE)));
        }
    }

    public WinkPhotoTemplateViewModel() {
        Lazy lazy;
        MutableLiveData<Result<a>> mutableLiveData = new MutableLiveData<>();
        this._prepared = mutableLiveData;
        this.prepared = mutableLiveData;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<WinkTemplateShareRepo>() { // from class: com.tencent.mobileqq.wink.lowthresholdltemplate.WinkPhotoTemplateViewModel$dataSource$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final WinkTemplateShareRepo invoke() {
                return WinkTemplateShareRepo.f323423a;
            }
        });
        this.dataSource = lazy;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final a P1(long loadLightTime, Pair<MetaMaterial, Long> loadMateResult, Pair<Boolean, Boolean> needDownLoad) {
        int collectionSizeOrDefault;
        BackgroundModel backgroundModel;
        MediaModel copy;
        WinkEditData copy2;
        BackgroundModel copy3;
        w53.b.f(getTAG(), "createPreviewData ");
        MetaMaterial component1 = loadMateResult.component1();
        loadMateResult.component2().longValue();
        String str = com.tencent.mobileqq.wink.editor.c.g0(component1) + File.separator + TemplateBean.TEMPLATE_JSON;
        WinkEditorResourceManager.a1().i0(component1);
        ArrayList arrayList = new ArrayList();
        List<? extends LocalMediaInfo> list = this.mediaList;
        if (list != null) {
            arrayList.addAll(list);
        }
        w53.b.f(getTAG(), "media size  " + arrayList.size());
        WinkEditDataWrapper f16 = com.tencent.mobileqq.wink.editor.draft.c.f(new ArrayList(arrayList), 0, 0, 6, null);
        String missionId = WinkContext.INSTANCE.d().getMissionId();
        ArrayList<WinkEditData> editDatas = f16.getEditDatas();
        collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(editDatas, 10);
        ArrayList arrayList2 = new ArrayList(collectionSizeOrDefault);
        for (WinkEditData winkEditData : editDatas) {
            MediaModel mediaModel = winkEditData.getMediaModel();
            BackgroundModel backgroundModel2 = winkEditData.getMediaModel().backgroundModel;
            if (backgroundModel2 != null) {
                copy3 = backgroundModel2.copy((r24 & 1) != 0 ? backgroundModel2.id : null, (r24 & 2) != 0 ? backgroundModel2.renderSize : new SizeF(com.tencent.videocut.utils.o.g(), this.height, null, 4, null), (r24 & 4) != 0 ? backgroundModel2.bgFillMode : null, (r24 & 8) != 0 ? backgroundModel2.bgColor : null, (r24 & 16) != 0 ? backgroundModel2.bgPagPath : null, (r24 & 32) != 0 ? backgroundModel2.ratioType : null, (r24 & 64) != 0 ? backgroundModel2.resPack : null, (r24 & 128) != 0 ? backgroundModel2.categoryId : null, (r24 & 256) != 0 ? backgroundModel2.fillScale : 0.0f, (r24 & 512) != 0 ? backgroundModel2.imageEffect : 0, (r24 & 1024) != 0 ? backgroundModel2.unknownFields() : null);
                backgroundModel = copy3;
            } else {
                backgroundModel = null;
            }
            copy = mediaModel.copy((r39 & 1) != 0 ? mediaModel.id : null, (r39 & 2) != 0 ? mediaModel.name : null, (r39 & 4) != 0 ? mediaModel.version : null, (r39 & 8) != 0 ? mediaModel.createTime : null, (r39 & 16) != 0 ? mediaModel.updateTime : null, (r39 & 32) != 0 ? mediaModel.duration : null, (r39 & 64) != 0 ? mediaModel.videos : null, (r39 & 128) != 0 ? mediaModel.audios : null, (r39 & 256) != 0 ? mediaModel.stickers : null, (r39 & 512) != 0 ? mediaModel.backgroundModel : backgroundModel, (r39 & 1024) != 0 ? mediaModel.filterModels : null, (r39 & 2048) != 0 ? mediaModel.specialEffects : null, (r39 & 4096) != 0 ? mediaModel.transitions : null, (r39 & 8192) != 0 ? mediaModel.templateModel : null, (r39 & 16384) != 0 ? mediaModel.coverInfo : null, (r39 & 32768) != 0 ? mediaModel.exportSetting : null, (r39 & 65536) != 0 ? mediaModel.openHDR : null, (r39 & 131072) != 0 ? mediaModel.hdrModels : null, (r39 & 262144) != 0 ? mediaModel.smoothModels : null, (r39 & 524288) != 0 ? mediaModel.openSuperHDR : null, (r39 & 1048576) != 0 ? mediaModel.unknownFields() : null);
            copy2 = winkEditData.copy((r37 & 1) != 0 ? winkEditData.mediaModel : copy, (r37 & 2) != 0 ? winkEditData.durationUs : 0L, (r37 & 4) != 0 ? winkEditData.stickerModelMap : null, (r37 & 8) != 0 ? winkEditData.filterModelMap : null, (r37 & 16) != 0 ? winkEditData.filterMaterialMap : null, (r37 & 32) != 0 ? winkEditData.stickerExtraMap : null, (r37 & 64) != 0 ? winkEditData.openHDR : false, (r37 & 128) != 0 ? winkEditData.effectModelMap : null, (r37 & 256) != 0 ? winkEditData.renderModelStr : null, (r37 & 512) != 0 ? winkEditData.templateMaterialMap : null, (r37 & 1024) != 0 ? winkEditData.stretchData : null, (r37 & 2048) != 0 ? winkEditData.assetData : null, (r37 & 4096) != 0 ? winkEditData.isLakData : false, (r37 & 8192) != 0 ? winkEditData.mosaicData : null, (r37 & 16384) != 0 ? winkEditData.challengeData : null, (r37 & 32768) != 0 ? winkEditData.manualDeletedChallengeTag : null, (r37 & 65536) != 0 ? winkEditData.isAIElimination : false, (r37 & 131072) != 0 ? winkEditData.aiTemplate : null);
            arrayList2.add(copy2);
        }
        WinkEditDataWrapper copy$default = WinkEditDataWrapper.copy$default(f16, missionId, null, new ArrayList(arrayList2), null, str, null, null, 0L, false, null, null, false, 0, 0.0f, 0.0f, null, false, null, null, false, 0L, null, null, false, 0L, false, null, false, null, true, null, 0, null, false, false, null, false, false, false, null, null, null, null, false, -536870934, 4095, null);
        w53.b.f(getTAG(), "createPreviewData: " + com.tencent.mobileqq.wink.editor.c.g0(component1));
        WinkEditorViewModel.EditMode editMode = WinkEditorViewModel.EditMode.Video;
        ArrayList<WinkEditData> editDatas2 = copy$default.getEditDatas();
        Boolean bool = Boolean.TRUE;
        int g16 = com.tencent.videocut.utils.o.g();
        int i3 = this.height;
        Boolean bool2 = u53.i.f438428a;
        if (bool2 == null) {
            bool2 = Boolean.FALSE;
        }
        Intrinsics.checkNotNullExpressionValue(bool2, "if (WinkEditPerformanceW\u2026Config.isOpenFFmpegDecode");
        boolean booleanValue = bool2.booleanValue();
        Integer softDecodeThreadCnt = u53.i.f438429b;
        Intrinsics.checkNotNullExpressionValue(softDecodeThreadCnt, "softDecodeThreadCnt");
        return new a(arrayList, component1, null, copy$default, new dr.WinkTavCutParams(false, editMode, editDatas2, str, bool, g16, i3, null, null, booleanValue, softDecodeThreadCnt.intValue(), WinkConfig.f317649a.b(), false, copy$default.isFromQzoneText(), copy$default.getTextQzoneText(), WinkTavCutScene.Preview, false, false, 0, 0, false, null, 4128768, null));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void S1(WinkPhotoTemplateViewModel winkPhotoTemplateViewModel, View view, String str, Map map, int i3, Object obj) {
        if ((i3 & 4) != 0) {
            map = null;
        }
        winkPhotoTemplateViewModel.R1(view, str, map);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void U1(WinkPhotoTemplateViewModel winkPhotoTemplateViewModel, View view, String str, Map map, int i3, Object obj) {
        if ((i3 & 4) != 0) {
            map = null;
        }
        winkPhotoTemplateViewModel.T1(view, str, map);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final r W1() {
        return (r) this.dataSource.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object a2(Continuation<? super Pair<Boolean, Boolean>> continuation) {
        Continuation intercepted;
        Object coroutine_suspended;
        intercepted = IntrinsicsKt__IntrinsicsJvmKt.intercepted(continuation);
        SafeContinuation safeContinuation = new SafeContinuation(intercepted);
        if (((IAECameraLauncher) QRoute.api(IAECameraLauncher.class)).isCameraResReady(new c(safeContinuation))) {
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

    /* JADX WARN: Removed duplicated region for block: B:11:0x0095 A[PHI: r8
  0x0095: PHI (r8v6 java.lang.Object) = (r8v5 java.lang.Object), (r8v1 java.lang.Object) binds: [B:22:0x0092, B:10:0x0028] A[DONT_GENERATE, DONT_INLINE], RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0076  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x008f  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0094 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0045  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0024  */
    @Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object Q1(@NotNull String str, @NotNull Continuation<? super Pair<MetaMaterial, Boolean>> continuation) {
        WinkPhotoTemplateViewModel$downloadMaterial$1 winkPhotoTemplateViewModel$downloadMaterial$1;
        Object obj;
        Object coroutine_suspended;
        int i3;
        WinkPhotoTemplateViewModel winkPhotoTemplateViewModel;
        MetaMaterial metaMaterial;
        Continuation intercepted;
        Object coroutine_suspended2;
        if (continuation instanceof WinkPhotoTemplateViewModel$downloadMaterial$1) {
            winkPhotoTemplateViewModel$downloadMaterial$1 = (WinkPhotoTemplateViewModel$downloadMaterial$1) continuation;
            int i16 = winkPhotoTemplateViewModel$downloadMaterial$1.label;
            if ((i16 & Integer.MIN_VALUE) != 0) {
                winkPhotoTemplateViewModel$downloadMaterial$1.label = i16 - Integer.MIN_VALUE;
                obj = winkPhotoTemplateViewModel$downloadMaterial$1.result;
                coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i3 = winkPhotoTemplateViewModel$downloadMaterial$1.label;
                if (i3 == 0) {
                    if (i3 != 1) {
                        if (i3 == 2) {
                            ResultKt.throwOnFailure(obj);
                            return obj;
                        }
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    winkPhotoTemplateViewModel = (WinkPhotoTemplateViewModel) winkPhotoTemplateViewModel$downloadMaterial$1.L$0;
                    ResultKt.throwOnFailure(obj);
                } else {
                    ResultKt.throwOnFailure(obj);
                    winkPhotoTemplateViewModel$downloadMaterial$1.L$0 = this;
                    winkPhotoTemplateViewModel$downloadMaterial$1.label = 1;
                    obj = X1(str, winkPhotoTemplateViewModel$downloadMaterial$1);
                    if (obj == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    winkPhotoTemplateViewModel = this;
                }
                metaMaterial = (MetaMaterial) obj;
                winkPhotoTemplateViewModel$downloadMaterial$1.L$0 = winkPhotoTemplateViewModel;
                winkPhotoTemplateViewModel$downloadMaterial$1.L$1 = metaMaterial;
                winkPhotoTemplateViewModel$downloadMaterial$1.label = 2;
                intercepted = IntrinsicsKt__IntrinsicsJvmKt.intercepted(winkPhotoTemplateViewModel$downloadMaterial$1);
                SafeContinuation safeContinuation = new SafeContinuation(intercepted);
                Ref.BooleanRef booleanRef = new Ref.BooleanRef();
                booleanRef.element = true;
                if (WinkEditorResourceManager.a1().q(metaMaterial)) {
                    booleanRef.element = false;
                }
                WinkEditorResourceManager.a1().f0(metaMaterial, new b(metaMaterial, safeContinuation, booleanRef));
                obj = safeContinuation.getOrThrow();
                coroutine_suspended2 = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                if (obj == coroutine_suspended2) {
                    DebugProbes.probeCoroutineSuspended(winkPhotoTemplateViewModel$downloadMaterial$1);
                }
                if (obj != coroutine_suspended) {
                    return coroutine_suspended;
                }
                return obj;
            }
        }
        winkPhotoTemplateViewModel$downloadMaterial$1 = new WinkPhotoTemplateViewModel$downloadMaterial$1(this, continuation);
        obj = winkPhotoTemplateViewModel$downloadMaterial$1.result;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i3 = winkPhotoTemplateViewModel$downloadMaterial$1.label;
        if (i3 == 0) {
        }
        metaMaterial = (MetaMaterial) obj;
        winkPhotoTemplateViewModel$downloadMaterial$1.L$0 = winkPhotoTemplateViewModel;
        winkPhotoTemplateViewModel$downloadMaterial$1.L$1 = metaMaterial;
        winkPhotoTemplateViewModel$downloadMaterial$1.label = 2;
        intercepted = IntrinsicsKt__IntrinsicsJvmKt.intercepted(winkPhotoTemplateViewModel$downloadMaterial$1);
        SafeContinuation safeContinuation2 = new SafeContinuation(intercepted);
        Ref.BooleanRef booleanRef2 = new Ref.BooleanRef();
        booleanRef2.element = true;
        if (WinkEditorResourceManager.a1().q(metaMaterial)) {
        }
        WinkEditorResourceManager.a1().f0(metaMaterial, new b(metaMaterial, safeContinuation2, booleanRef2));
        obj = safeContinuation2.getOrThrow();
        coroutine_suspended2 = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (obj == coroutine_suspended2) {
        }
        if (obj != coroutine_suspended) {
        }
    }

    public final void R1(@NotNull View view, @NotNull String eid, @Nullable Map<String, String> extParams) {
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(eid, "eid");
        VideoReport.setElementId(view, eid);
        Map<String, Object> buildElementParams = WinkDTParamBuilder.buildElementParams();
        if (extParams != null) {
            buildElementParams.putAll(extParams);
        }
        VideoReport.setElementExposePolicy(view, ExposurePolicy.REPORT_NONE);
        VideoReport.setElementClickPolicy(view, ClickPolicy.REPORT_NONE);
        VideoReport.setElementParams(view, buildElementParams);
        VideoReport.reportEvent("dt_clck", view, extParams);
    }

    public final void T1(@NotNull View view, @NotNull String eid, @Nullable Map<String, String> extParams) {
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(eid, "eid");
        VideoReport.setElementId(view, eid);
        Map<String, Object> buildElementParams = WinkDTParamBuilder.buildElementParams();
        if (extParams != null) {
            buildElementParams.putAll(extParams);
        }
        w53.b.c(getTAG(), "dtImplViewReport  dt_imp " + view + " " + eid);
        VideoReport.setElementParams(view, buildElementParams);
        VideoReport.setElementExposePolicy(view, ExposurePolicy.REPORT_NONE);
        VideoReport.setElementClickPolicy(view, ClickPolicy.REPORT_NONE);
        VideoReport.reportEvent("dt_imp", view, extParams);
    }

    @Nullable
    public final Object X1(@NotNull String str, @NotNull Continuation<? super MetaMaterial> continuation) {
        w53.b.f(getTAG(), " getMaterial " + str);
        if (TextUtils.isEmpty(str)) {
            str = "dapian_qingxukadian";
        }
        w53.b.f(getTAG(), " getMaterial~~~~~ " + ((Object) str));
        ArrayList<MetaCategory> arrayList = WinkEditorResourceManager.a1().Q1().get(0).subCategories;
        if (arrayList != null) {
            Iterator<MetaCategory> it = arrayList.iterator();
            while (it.hasNext()) {
                ArrayList<MetaMaterial> arrayList2 = it.next().materials;
                Intrinsics.checkNotNullExpressionValue(arrayList2, "subCategory.materials");
                for (MetaMaterial material : arrayList2) {
                    if (material.f30533id.equals(str)) {
                        w53.b.a(getTAG(), "getMaterial  equals  " + material.f30533id);
                        Intrinsics.checkNotNullExpressionValue(material, "material");
                        return material;
                    }
                }
            }
        }
        return new MetaMaterial();
    }

    @NotNull
    public final LiveData<Result<a>> Z1() {
        return this.prepared;
    }

    public final void b2(@NotNull String templateId) {
        Intrinsics.checkNotNullParameter(templateId, "templateId");
        w53.b.f(getTAG(), "requestAndProcessData");
        BuildersKt__Builders_commonKt.launch$default(this.viewModelScope, null, null, new WinkPhotoTemplateViewModel$requestAndProcessData$1(this, templateId, null), 3, null);
    }

    public final void c2(int height) {
        this.height = height;
        w53.b.c(getTAG(), "setBarHeight  " + this.height);
    }

    public final void d2(@Nullable List<? extends LocalMediaInfo> list) {
        this.mediaList = list;
    }

    @Override // com.tencent.biz.richframework.part.BaseViewModel
    @NotNull
    /* renamed from: getLogTag */
    public String getTAG() {
        return "WinkPhotoTemplateViewModel";
    }
}

package com.tencent.mobileqq.wink.preview.viewmodel;

import android.view.Surface;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import camera.XEFFECT_MATERIALS_GENERAL_DATASTRUCT.MetaMaterial;
import com.heytap.databaseengine.model.UserInfo;
import com.qzone.module.covercomponent.model.CoverDBCacheData;
import com.tencent.aelight.camera.download.api.AEResInfo;
import com.tencent.aelight.camera.download.api.IAEMultiDownloadCallBack;
import com.tencent.aelight.camera.entry.api.IAECameraLauncher;
import com.tencent.biz.richframework.part.BaseViewModel;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qaddefine.QAdReportDefine$AdReporterParams;
import com.tencent.mobileqq.wink.WinkConfig;
import com.tencent.mobileqq.wink.api.QQWinkConstants;
import com.tencent.mobileqq.wink.edit.manager.WinkEditorResourceManager;
import com.tencent.mobileqq.wink.editor.WinkEditorViewModel;
import com.tencent.mobileqq.wink.editor.dr;
import com.tencent.mobileqq.wink.editor.draft.WinkEditData;
import com.tencent.mobileqq.wink.editor.draft.WinkEditDataWrapper;
import com.tencent.mobileqq.wink.editor.export.WinkExportUtils;
import com.tencent.mobileqq.wink.editor.model.WinkTavCutScene;
import com.tencent.mobileqq.wink.editor.music.viewmodel.MusicVolumeControlViewModel;
import com.tencent.mobileqq.wink.editor.music.vo.WinkEditorMusicInfo;
import com.tencent.mobileqq.wink.preview.datasource.WinkBasePreviewShareDataSource;
import com.tencent.mobileqq.wink.utils.o;
import com.tencent.mobileqq.wink.utils.y;
import com.tencent.qcircle.weishi.module.publisher.entity.TemplateBean;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.rmonitor.custom.ICustomDataEditor;
import com.tencent.tavcut.core.session.ICutSession;
import com.tencent.upload.network.session.cache.SessionDbHelper;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.SafeContinuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugProbes;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.SupervisorKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;
import org.light.AudioOutputConfig;
import org.light.ClipPlaceHolder;
import org.light.LightAsset;
import org.light.LightConstants;
import org.light.LightEngine;
import org.light.MovieController;
import org.light.RendererConfig;
import org.light.VideoOutputConfig;
import u53.i;

@Metadata(d1 = {"\u0000|\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010$\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u001e\b&\u0018\u0000 K2\u00020\u0001:\u0003LMNB\u0007\u00a2\u0006\u0004\bI\u0010JJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002Jb\u0010\u0011\u001a\u00020\u00102\u001a\u0010\n\u001a\u0016\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u0007\u0012\u0004\u0012\u00020\t\u0018\u00010\u00062\u0012\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\t0\u00062\u0014\u0010\r\u001a\u0010\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b\u0018\u00010\f2\u0012\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u000e0\u0006H\u0002J\u001f\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u000e0\u0006H\u0082@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0012\u0010\u0013J\b\u0010\u0015\u001a\u00020\u0014H&J\b\u0010\u0016\u001a\u00020\u000eH&J\b\u0010\u0018\u001a\u00020\u0017H\u0014J\u0018\u0010\u001a\u001a\u00020\u00172\u000e\u0010\u0019\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007H\u0016J\u0016\u0010\u001e\u001a\u00020\u00172\u0006\u0010\u001c\u001a\u00020\u001b2\u0006\u0010\u001d\u001a\u00020\tJ\u0006\u0010\u001f\u001a\u00020\u0017J\b\u0010 \u001a\u00020\bH\u0016R\u0014\u0010$\u001a\u00020!8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\"\u0010#R#\u0010)\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00100&0%8\u0002X\u0082\u0004\u00f8\u0001\u0000\u00a2\u0006\u0006\n\u0004\b'\u0010(R&\u0010/\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00100&0*8\u0006\u00f8\u0001\u0000\u00a2\u0006\f\n\u0004\b+\u0010,\u001a\u0004\b-\u0010.R \u00103\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u000201000%8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b2\u0010(R#\u00106\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u000201000*8\u0006\u00a2\u0006\f\n\u0004\b4\u0010,\u001a\u0004\b5\u0010.R\"\u0010=\u001a\u00020\u000e8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b7\u00108\u001a\u0004\b9\u0010:\"\u0004\b;\u0010<R\"\u0010@\u001a\u0010\u0012\f\u0012\n >*\u0004\u0018\u00010\u000e0\u000e0%8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b?\u0010(R%\u0010D\u001a\u0010\u0012\f\u0012\n >*\u0004\u0018\u00010\u000e0\u000e0%8\u0006\u00a2\u0006\f\n\u0004\bA\u0010(\u001a\u0004\bB\u0010CR\u0018\u0010\u001c\u001a\u0004\u0018\u00010\u001b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bE\u0010FR\u0016\u0010H\u001a\u00020\t8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bG\u0010G\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006O"}, d2 = {"Lcom/tencent/mobileqq/wink/preview/viewmodel/WinkBasePreviewShareViewModel;", "Lcom/tencent/biz/richframework/part/BaseViewModel;", "Lcamera/XEFFECT_MATERIALS_GENERAL_DATASTRUCT/MetaMaterial;", WadlProxyConsts.KEY_MATERIAL, "", "T1", "Lkotlin/Pair;", "", "", "", "loadImageResult", "loadMateResult", "", "assertData", "", "needDownLoad", "Lcom/tencent/mobileqq/wink/preview/viewmodel/WinkBasePreviewShareViewModel$b;", "R1", "X1", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lcom/tencent/mobileqq/wink/preview/datasource/WinkBasePreviewShareDataSource;", "S1", "Z1", "", "onCleared", CoverDBCacheData.URLS, "e2", "Lcom/tencent/tavcut/core/session/ICutSession;", SessionDbHelper.SESSION_ID, "coverTimeUs", "c2", "d2", "getLogTag", "Lkotlinx/coroutines/CoroutineScope;", "i", "Lkotlinx/coroutines/CoroutineScope;", "viewModelScope", "Landroidx/lifecycle/MutableLiveData;", "Lkotlin/Result;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Landroidx/lifecycle/MutableLiveData;", "_prepared", "Landroidx/lifecycle/LiveData;", BdhLogUtil.LogTag.Tag_Conn, "Landroidx/lifecycle/LiveData;", "U1", "()Landroidx/lifecycle/LiveData;", "prepared", "Lt73/a;", "Lcom/tencent/mobileqq/wink/preview/viewmodel/WinkBasePreviewShareViewModel$c;", "D", "_previewEvent", "E", "W1", "previewEvent", UserInfo.SEX_FEMALE, "Z", ICustomDataEditor.STRING_ARRAY_PARAM_2, "()Z", "f2", "(Z)V", "isPublishing", "kotlin.jvm.PlatformType", "G", "_isSyncQzone", "H", "b2", "()Landroidx/lifecycle/MutableLiveData;", "isSyncQzone", "I", "Lcom/tencent/tavcut/core/session/ICutSession;", "J", "coverTime", "<init>", "()V", "K", "a", "b", "c", "qq-wink-temp-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes21.dex */
public abstract class WinkBasePreviewShareViewModel extends BaseViewModel {

    /* renamed from: C, reason: from kotlin metadata */
    @NotNull
    private final LiveData<Result<PreviewData>> prepared;

    /* renamed from: D, reason: from kotlin metadata */
    @NotNull
    private final MutableLiveData<t73.a<c>> _previewEvent;

    /* renamed from: E, reason: from kotlin metadata */
    @NotNull
    private final LiveData<t73.a<c>> previewEvent;

    /* renamed from: F, reason: from kotlin metadata */
    private boolean isPublishing;

    /* renamed from: G, reason: from kotlin metadata */
    @NotNull
    private final MutableLiveData<Boolean> _isSyncQzone;

    /* renamed from: H, reason: from kotlin metadata */
    @NotNull
    private final MutableLiveData<Boolean> isSyncQzone;

    /* renamed from: I, reason: from kotlin metadata */
    @Nullable
    private ICutSession session;

    /* renamed from: J, reason: from kotlin metadata */
    private long coverTime;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final CoroutineScope viewModelScope = CoroutineScopeKt.CoroutineScope(SupervisorKt.SupervisorJob$default((Job) null, 1, (Object) null).plus(Dispatchers.getMain()));

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final MutableLiveData<Result<PreviewData>> _prepared;

    @Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010 \n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0086\b\u0018\u00002\u00020\u0001B/\u0012\u000e\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\t\u0012\u0006\u0010\u0013\u001a\u00020\u000f\u0012\u0006\u0010\u0018\u001a\u00020\u0014\u0012\u0006\u0010\u001d\u001a\u00020\u0019\u00a2\u0006\u0004\b\u001e\u0010\u001fJ\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u001f\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\t8\u0006\u00a2\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\u0017\u0010\u0013\u001a\u00020\u000f8\u0006\u00a2\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\n\u0010\u0012R\u0017\u0010\u0018\u001a\u00020\u00148\u0006\u00a2\u0006\f\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0010\u0010\u0017R\u0017\u0010\u001d\u001a\u00020\u00198\u0006\u00a2\u0006\f\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u0015\u0010\u001c\u00a8\u0006 "}, d2 = {"Lcom/tencent/mobileqq/wink/preview/viewmodel/WinkBasePreviewShareViewModel$b;", "", "", "toString", "", "hashCode", "other", "", "equals", "", "a", "Ljava/util/List;", "getLocalImagePaths", "()Ljava/util/List;", "localImagePaths", "Lcamera/XEFFECT_MATERIALS_GENERAL_DATASTRUCT/MetaMaterial;", "b", "Lcamera/XEFFECT_MATERIALS_GENERAL_DATASTRUCT/MetaMaterial;", "()Lcamera/XEFFECT_MATERIALS_GENERAL_DATASTRUCT/MetaMaterial;", WadlProxyConsts.KEY_MATERIAL, "Lcom/tencent/mobileqq/wink/editor/draft/WinkEditDataWrapper;", "c", "Lcom/tencent/mobileqq/wink/editor/draft/WinkEditDataWrapper;", "()Lcom/tencent/mobileqq/wink/editor/draft/WinkEditDataWrapper;", "winkEditDataWrapper", "Lcom/tencent/mobileqq/wink/editor/dr$c;", "d", "Lcom/tencent/mobileqq/wink/editor/dr$c;", "()Lcom/tencent/mobileqq/wink/editor/dr$c;", "winkTavCutParams", "<init>", "(Ljava/util/List;Lcamera/XEFFECT_MATERIALS_GENERAL_DATASTRUCT/MetaMaterial;Lcom/tencent/mobileqq/wink/editor/draft/WinkEditDataWrapper;Lcom/tencent/mobileqq/wink/editor/dr$c;)V", "qq-wink-temp-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.wink.preview.viewmodel.WinkBasePreviewShareViewModel$b, reason: from toString */
    /* loaded from: classes21.dex */
    public static final /* data */ class PreviewData {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
        @Nullable
        private final List<String> localImagePaths;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
        @NotNull
        private final MetaMaterial material;

        /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
        @NotNull
        private final WinkEditDataWrapper winkEditDataWrapper;

        /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
        @NotNull
        private final dr.WinkTavCutParams winkTavCutParams;

        public PreviewData(@Nullable List<String> list, @NotNull MetaMaterial material, @NotNull WinkEditDataWrapper winkEditDataWrapper, @NotNull dr.WinkTavCutParams winkTavCutParams) {
            Intrinsics.checkNotNullParameter(material, "material");
            Intrinsics.checkNotNullParameter(winkEditDataWrapper, "winkEditDataWrapper");
            Intrinsics.checkNotNullParameter(winkTavCutParams, "winkTavCutParams");
            this.localImagePaths = list;
            this.material = material;
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

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof PreviewData)) {
                return false;
            }
            PreviewData previewData = (PreviewData) other;
            if (Intrinsics.areEqual(this.localImagePaths, previewData.localImagePaths) && Intrinsics.areEqual(this.material, previewData.material) && Intrinsics.areEqual(this.winkEditDataWrapper, previewData.winkEditDataWrapper) && Intrinsics.areEqual(this.winkTavCutParams, previewData.winkTavCutParams)) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            int hashCode;
            List<String> list = this.localImagePaths;
            if (list == null) {
                hashCode = 0;
            } else {
                hashCode = list.hashCode();
            }
            return (((((hashCode * 31) + this.material.hashCode()) * 31) + this.winkEditDataWrapper.hashCode()) * 31) + this.winkTavCutParams.hashCode();
        }

        @NotNull
        public String toString() {
            return "PreviewData(localImagePaths=" + this.localImagePaths + ", material=" + this.material + ", winkEditDataWrapper=" + this.winkEditDataWrapper + ", winkTavCutParams=" + this.winkTavCutParams + ")";
        }
    }

    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0004\u0004\u0005\u0006\u0007B\t\b\u0004\u00a2\u0006\u0004\b\u0002\u0010\u0003\u0082\u0001\u0004\b\t\n\u000b\u00a8\u0006\f"}, d2 = {"Lcom/tencent/mobileqq/wink/preview/viewmodel/WinkBasePreviewShareViewModel$c;", "", "<init>", "()V", "a", "b", "c", "d", "Lcom/tencent/mobileqq/wink/preview/viewmodel/WinkBasePreviewShareViewModel$c$a;", "Lcom/tencent/mobileqq/wink/preview/viewmodel/WinkBasePreviewShareViewModel$c$b;", "Lcom/tencent/mobileqq/wink/preview/viewmodel/WinkBasePreviewShareViewModel$c$c;", "Lcom/tencent/mobileqq/wink/preview/viewmodel/WinkBasePreviewShareViewModel$c$d;", "qq-wink-temp-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes21.dex */
    public static abstract class c {

        @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\n\b\u0086\b\u0018\u00002\u00020\u0001B!\u0012\u0006\u0010\u000f\u001a\u00020\n\u0012\u0006\u0010\u0014\u001a\u00020\u0010\u0012\b\u0010\u0017\u001a\u0004\u0018\u00010\u0002\u00a2\u0006\u0004\b\u0018\u0010\u0019J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u00d6\u0003R\u0017\u0010\u000f\u001a\u00020\n8\u0006\u00a2\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000eR\u0017\u0010\u0014\u001a\u00020\u00108\u0006\u00a2\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0011\u0010\u0013R\u0019\u0010\u0017\u001a\u0004\u0018\u00010\u00028\u0006\u00a2\u0006\f\n\u0004\b\r\u0010\u0015\u001a\u0004\b\u000b\u0010\u0016\u00a8\u0006\u001a"}, d2 = {"Lcom/tencent/mobileqq/wink/preview/viewmodel/WinkBasePreviewShareViewModel$c$a;", "Lcom/tencent/mobileqq/wink/preview/viewmodel/WinkBasePreviewShareViewModel$c;", "", "toString", "", "hashCode", "", "other", "", "equals", "Lcom/tencent/mobileqq/wink/editor/draft/WinkEditDataWrapper;", "a", "Lcom/tencent/mobileqq/wink/editor/draft/WinkEditDataWrapper;", "c", "()Lcom/tencent/mobileqq/wink/editor/draft/WinkEditDataWrapper;", "winkEditDataWrapper", "Lcamera/XEFFECT_MATERIALS_GENERAL_DATASTRUCT/MetaMaterial;", "b", "Lcamera/XEFFECT_MATERIALS_GENERAL_DATASTRUCT/MetaMaterial;", "()Lcamera/XEFFECT_MATERIALS_GENERAL_DATASTRUCT/MetaMaterial;", WadlProxyConsts.KEY_MATERIAL, "Ljava/lang/String;", "()Ljava/lang/String;", QQWinkConstants.COVER_PATH, "<init>", "(Lcom/tencent/mobileqq/wink/editor/draft/WinkEditDataWrapper;Lcamera/XEFFECT_MATERIALS_GENERAL_DATASTRUCT/MetaMaterial;Ljava/lang/String;)V", "qq-wink-temp-impl_release"}, k = 1, mv = {1, 7, 1})
        /* renamed from: com.tencent.mobileqq.wink.preview.viewmodel.WinkBasePreviewShareViewModel$c$a, reason: from toString */
        /* loaded from: classes21.dex */
        public static final /* data */ class SaveShare extends c {

            /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
            @NotNull
            private final WinkEditDataWrapper winkEditDataWrapper;

            /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
            @NotNull
            private final MetaMaterial material;

            /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
            @Nullable
            private final String coverPath;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public SaveShare(@NotNull WinkEditDataWrapper winkEditDataWrapper, @NotNull MetaMaterial material, @Nullable String str) {
                super(null);
                Intrinsics.checkNotNullParameter(winkEditDataWrapper, "winkEditDataWrapper");
                Intrinsics.checkNotNullParameter(material, "material");
                this.winkEditDataWrapper = winkEditDataWrapper;
                this.material = material;
                this.coverPath = str;
            }

            @Nullable
            /* renamed from: a, reason: from getter */
            public final String getCoverPath() {
                return this.coverPath;
            }

            @NotNull
            /* renamed from: b, reason: from getter */
            public final MetaMaterial getMaterial() {
                return this.material;
            }

            @NotNull
            /* renamed from: c, reason: from getter */
            public final WinkEditDataWrapper getWinkEditDataWrapper() {
                return this.winkEditDataWrapper;
            }

            public boolean equals(@Nullable Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof SaveShare)) {
                    return false;
                }
                SaveShare saveShare = (SaveShare) other;
                if (Intrinsics.areEqual(this.winkEditDataWrapper, saveShare.winkEditDataWrapper) && Intrinsics.areEqual(this.material, saveShare.material) && Intrinsics.areEqual(this.coverPath, saveShare.coverPath)) {
                    return true;
                }
                return false;
            }

            public int hashCode() {
                int hashCode;
                int hashCode2 = ((this.winkEditDataWrapper.hashCode() * 31) + this.material.hashCode()) * 31;
                String str = this.coverPath;
                if (str == null) {
                    hashCode = 0;
                } else {
                    hashCode = str.hashCode();
                }
                return hashCode2 + hashCode;
            }

            @NotNull
            public String toString() {
                return "SaveShare(winkEditDataWrapper=" + this.winkEditDataWrapper + ", material=" + this.material + ", coverPath=" + this.coverPath + ")";
            }
        }

        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003\u00a8\u0006\u0004"}, d2 = {"Lcom/tencent/mobileqq/wink/preview/viewmodel/WinkBasePreviewShareViewModel$c$b;", "Lcom/tencent/mobileqq/wink/preview/viewmodel/WinkBasePreviewShareViewModel$c;", "<init>", "()V", "qq-wink-temp-impl_release"}, k = 1, mv = {1, 7, 1})
        /* loaded from: classes21.dex */
        public static final class b extends c {

            /* renamed from: a, reason: collision with root package name */
            @NotNull
            public static final b f325445a = new b();

            b() {
                super(null);
            }
        }

        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003\u00a8\u0006\u0004"}, d2 = {"Lcom/tencent/mobileqq/wink/preview/viewmodel/WinkBasePreviewShareViewModel$c$c;", "Lcom/tencent/mobileqq/wink/preview/viewmodel/WinkBasePreviewShareViewModel$c;", "<init>", "()V", "qq-wink-temp-impl_release"}, k = 1, mv = {1, 7, 1})
        /* renamed from: com.tencent.mobileqq.wink.preview.viewmodel.WinkBasePreviewShareViewModel$c$c, reason: collision with other inner class name */
        /* loaded from: classes21.dex */
        public static final class C9076c extends c {

            /* renamed from: a, reason: collision with root package name */
            @NotNull
            public static final C9076c f325446a = new C9076c();

            C9076c() {
                super(null);
            }
        }

        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003\u00a8\u0006\u0004"}, d2 = {"Lcom/tencent/mobileqq/wink/preview/viewmodel/WinkBasePreviewShareViewModel$c$d;", "Lcom/tencent/mobileqq/wink/preview/viewmodel/WinkBasePreviewShareViewModel$c;", "<init>", "()V", "qq-wink-temp-impl_release"}, k = 1, mv = {1, 7, 1})
        /* loaded from: classes21.dex */
        public static final class d extends c {

            /* renamed from: a, reason: collision with root package name */
            @NotNull
            public static final d f325447a = new d();

            d() {
                super(null);
            }
        }

        public /* synthetic */ c(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        c() {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Metadata(d1 = {"\u0000\u001c\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u00032\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\n\u00a2\u0006\u0002\b\t"}, d2 = {"<anonymous>", "", "aeResInfo", "Lcom/tencent/aelight/camera/download/api/AEResInfo;", "kotlin.jvm.PlatformType", "downloaded", "", QAdReportDefine$AdReporterParams.K_Q_AD_REPORTER_PARAM_KEY_ERROR_TYPE, "", "onAEMultiDownloadFinish"}, k = 3, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes21.dex */
    public static final class d implements IAEMultiDownloadCallBack {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Continuation<Pair<Boolean, Boolean>> f325448a;

        /* JADX WARN: Multi-variable type inference failed */
        d(Continuation<? super Pair<Boolean, Boolean>> continuation) {
            this.f325448a = continuation;
        }

        @Override // com.tencent.aelight.camera.download.api.IAEMultiDownloadCallBack
        public final void onAEMultiDownloadFinish(AEResInfo aEResInfo, boolean z16, int i3) {
            String str;
            if (aEResInfo != null) {
                str = aEResInfo.agentType;
            } else {
                str = null;
            }
            w53.b.a("WinkBasePreviewShareViewModel", "onAEMultiDownloadFinish aeResInfo = " + str + " downloaded = " + z16 + ", error = " + i3);
            Continuation<Pair<Boolean, Boolean>> continuation = this.f325448a;
            Result.Companion companion = Result.INSTANCE;
            continuation.resumeWith(Result.m476constructorimpl(new Pair(Boolean.valueOf(z16), Boolean.TRUE)));
        }
    }

    public WinkBasePreviewShareViewModel() {
        MutableLiveData<Result<PreviewData>> mutableLiveData = new MutableLiveData<>();
        this._prepared = mutableLiveData;
        this.prepared = mutableLiveData;
        MutableLiveData<t73.a<c>> mutableLiveData2 = new MutableLiveData<>();
        this._previewEvent = mutableLiveData2;
        this.previewEvent = mutableLiveData2;
        MutableLiveData<Boolean> mutableLiveData3 = new MutableLiveData<>(Boolean.FALSE);
        this._isSyncQzone = mutableLiveData3;
        this.isSyncQzone = mutableLiveData3;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final PreviewData R1(Pair<? extends List<String>, Long> loadImageResult, Pair<MetaMaterial, Long> loadMateResult, Map<String, String> assertData, Pair<Boolean, Boolean> needDownLoad) {
        ArrayList arrayList;
        HashMap hashMap;
        String str = com.tencent.mobileqq.wink.editor.c.g0(loadMateResult.getFirst()) + File.separator + TemplateBean.TEMPLATE_JSON;
        List<String> list = null;
        if (loadImageResult != null) {
            arrayList = new ArrayList(o.f326724a.i(loadImageResult.getFirst()));
        } else {
            arrayList = null;
        }
        WinkEditDataWrapper copy$default = WinkEditDataWrapper.copy$default(com.tencent.mobileqq.wink.editor.draft.c.f(arrayList, 0, 0, 6, null), null, null, null, null, str, null, null, 0L, false, "fakeMid_template_bgm", null, false, 0, 0.0f, 1.0f, MusicVolumeControlViewModel.VolumeType.TEMPLATE, false, null, null, false, 0L, WinkEditorMusicInfo.H, null, false, 0L, false, null, false, null, false, null, 0, null, false, false, null, false, false, false, null, null, null, null, false, -2155025, 4095, null);
        HashMap hashMap2 = new HashMap();
        if (assertData != null) {
            hashMap = MapsKt__MapsKt.hashMapOf(TuplesKt.to(LightConstants.EventKey.EVENT_SCRIPT_PARAMS, new JSONObject(assertData).toString()));
        } else {
            hashMap = hashMap2;
        }
        w53.b.a("WinkBasePreviewShareViewModel", "createPreviewData: " + com.tencent.mobileqq.wink.editor.c.g0(loadMateResult.getFirst()));
        boolean z16 = false;
        WinkEditorViewModel.EditMode editMode = WinkEditorViewModel.EditMode.Video;
        ArrayList<WinkEditData> editDatas = copy$default.getEditDatas();
        Boolean valueOf = Boolean.valueOf(Z1());
        int i3 = 1080;
        int i16 = 1920;
        Surface surface = null;
        Boolean bool = i.f438428a;
        if (bool == null) {
            bool = Boolean.FALSE;
        }
        Intrinsics.checkNotNullExpressionValue(bool, "if (WinkEditPerformanceW\u2026Config.isOpenFFmpegDecode");
        boolean booleanValue = bool.booleanValue();
        Integer softDecodeThreadCnt = i.f438429b;
        Intrinsics.checkNotNullExpressionValue(softDecodeThreadCnt, "softDecodeThreadCnt");
        dr.WinkTavCutParams winkTavCutParams = new dr.WinkTavCutParams(z16, editMode, editDatas, str, valueOf, i3, i16, surface, hashMap, booleanValue, softDecodeThreadCnt.intValue(), WinkConfig.f317649a.b(), false, copy$default.isFromQzoneText(), copy$default.getTextQzoneText(), WinkTavCutScene.Preview, false, false, 0, 0, false, null, 4128768, null);
        if (loadImageResult != null) {
            list = loadImageResult.getFirst();
        }
        return new PreviewData(list, loadMateResult.getFirst(), copy$default, winkTavCutParams);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final int T1(MetaMaterial material) {
        MovieController assetForMovie;
        ClipPlaceHolder[] clipPlaceHolders;
        WinkExportUtils.R();
        y yVar = y.f326739a;
        BaseApplication context = BaseApplication.context;
        Intrinsics.checkNotNullExpressionValue(context, "context");
        yVar.b(context);
        LightAsset Load = LightAsset.Load(WinkEditorResourceManager.a1().m(material), 0);
        LightEngine make = LightEngine.make(new VideoOutputConfig(30.0f, 0), new AudioOutputConfig(), new RendererConfig());
        if (Load != null && make != null && (assetForMovie = make.setAssetForMovie(Load)) != null && (clipPlaceHolders = assetForMovie.getClipPlaceHolders()) != null) {
            int length = clipPlaceHolders.length;
            w53.b.a("WinkBasePreviewShareViewModel", "[getHolderCount]:" + clipPlaceHolders.length);
            return length;
        }
        return 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object X1(Continuation<? super Pair<Boolean, Boolean>> continuation) {
        Continuation intercepted;
        Object coroutine_suspended;
        intercepted = IntrinsicsKt__IntrinsicsJvmKt.intercepted(continuation);
        SafeContinuation safeContinuation = new SafeContinuation(intercepted);
        if (((IAECameraLauncher) QRoute.api(IAECameraLauncher.class)).isCameraResReady(new d(safeContinuation))) {
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

    @NotNull
    public abstract WinkBasePreviewShareDataSource S1();

    @NotNull
    public final LiveData<Result<PreviewData>> U1() {
        return this.prepared;
    }

    @NotNull
    public final LiveData<t73.a<c>> W1() {
        return this.previewEvent;
    }

    public abstract boolean Z1();

    /* renamed from: a2, reason: from getter */
    public final boolean getIsPublishing() {
        return this.isPublishing;
    }

    @NotNull
    public final MutableLiveData<Boolean> b2() {
        return this.isSyncQzone;
    }

    public final void c2(@NotNull ICutSession session, long coverTimeUs) {
        Intrinsics.checkNotNullParameter(session, "session");
        Result<PreviewData> value = this._prepared.getValue();
        boolean z16 = false;
        if (value != null && Result.m483isSuccessimpl(value.getValue())) {
            z16 = true;
        }
        if (!z16) {
            return;
        }
        this.session = session;
        this.coverTime = coverTimeUs;
        t73.b.a(this._previewEvent, c.d.f325447a);
    }

    public final void d2() {
        Result<PreviewData> value = this._prepared.getValue();
        ICutSession iCutSession = this.session;
        boolean z16 = false;
        if (value != null && Result.m483isSuccessimpl(value.getValue())) {
            z16 = true;
        }
        if (z16 && iCutSession != null) {
            Object value2 = value.getValue();
            ResultKt.throwOnFailure(value2);
            t73.b.b(this._previewEvent, c.b.f325445a);
            Object value3 = value.getValue();
            ResultKt.throwOnFailure(value3);
            BuildersKt__Builders_commonKt.launch$default(this.viewModelScope, null, null, new WinkBasePreviewShareViewModel$onSaveShare$1(this, (PreviewData) value2, iCutSession, ((PreviewData) value3).getWinkEditDataWrapper(), null), 3, null);
            return;
        }
        t73.b.a(this._previewEvent, c.C9076c.f325446a);
    }

    public void e2(@Nullable List<String> urls) {
        BuildersKt__Builders_commonKt.launch$default(this.viewModelScope, null, null, new WinkBasePreviewShareViewModel$requestAndProcessData$1(this, urls, null), 3, null);
    }

    public final void f2(boolean z16) {
        this.isPublishing = z16;
    }

    @Override // com.tencent.biz.richframework.part.BaseViewModel
    @NotNull
    /* renamed from: getLogTag */
    public String getTAG() {
        return "WinkBasePreviewShareViewModel";
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.lifecycle.ViewModel
    public void onCleared() {
        super.onCleared();
        this.session = null;
        CoroutineScopeKt.cancel$default(this.viewModelScope, null, 1, null);
    }
}

package com.tencent.mobileqq.wink.editor.template;

import android.content.Context;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import camera.XEFFECT_MATERIALS_GENERAL_DATASTRUCT.MetaMaterial;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.aelight.camera.download.api.IAEResUtil;
import com.tencent.biz.richframework.part.BaseViewModel;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.wink.edit.manager.WinkEditorResourceManager;
import com.tencent.mobileqq.wink.edit.util.AECameraPrefsUtil;
import com.tencent.mobileqq.wink.editor.hdr.WinkHDRPicQualityDetectUtils;
import com.tencent.rmonitor.custom.ICustomDataEditor;
import com.tencent.videocut.model.MediaClip;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u001f\u0018\u0000 H2\u00020\u0001:\u0003IJKB\t\b\u0000\u00a2\u0006\u0004\bF\u0010GJ(\u0010\n\u001a\u00020\t2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0007J0\u0010\f\u001a\u00020\t2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\u0004J \u0010\u0010\u001a\u0012\u0012\u0004\u0012\u00020\u000e0\rj\b\u0012\u0004\u0012\u00020\u000e`\u000f2\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002J\u0016\u0010\u0013\u001a\u00020\u00042\u000e\u0010\u0012\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\u0011J\u0010\u0010\u0015\u001a\u00020\t2\b\u0010\u0014\u001a\u0004\u0018\u00010\u000eJ\u0014\u0010\u0018\u001a\u00020\t2\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00160\u0011J\u000e\u0010\u001a\u001a\u00020\t2\u0006\u0010\u0019\u001a\u00020\u0004J\u0010\u0010\u001b\u001a\u00020\t2\b\u0010\u0014\u001a\u0004\u0018\u00010\u000eJ\u0006\u0010\u001c\u001a\u00020\u0004J\u000e\u0010\u001e\u001a\u00020\t2\u0006\u0010\u001d\u001a\u00020\u0004J\u0006\u0010\u001f\u001a\u00020\u0004J\u000e\u0010 \u001a\u00020\t2\u0006\u0010\u001d\u001a\u00020\u0004J\b\u0010!\u001a\u00020\u000eH\u0016R\u001a\u0010&\u001a\b\u0012\u0004\u0012\u00020#0\"8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b$\u0010%R\u001d\u0010,\u001a\b\u0012\u0004\u0012\u00020#0'8\u0006\u00a2\u0006\f\n\u0004\b(\u0010)\u001a\u0004\b*\u0010+R\u001a\u0010/\u001a\b\u0012\u0004\u0012\u00020-0\"8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b.\u0010%R\u001d\u00102\u001a\b\u0012\u0004\u0012\u00020-0'8\u0006\u00a2\u0006\f\n\u0004\b0\u0010)\u001a\u0004\b1\u0010+R\u001a\u00104\u001a\b\u0012\u0004\u0012\u00020\u00040\"8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b3\u0010%R\u001d\u00107\u001a\b\u0012\u0004\u0012\u00020\u00040'8\u0006\u00a2\u0006\f\n\u0004\b5\u0010)\u001a\u0004\b6\u0010+R(\u0010=\u001a\u0004\u0018\u00010\u00022\b\u00108\u001a\u0004\u0018\u00010\u00028\u0006@BX\u0086\u000e\u00a2\u0006\f\n\u0004\b9\u0010:\u001a\u0004\b;\u0010<R\u0018\u0010@\u001a\u0004\u0018\u00010\u000e8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b>\u0010?R$\u0010E\u001a\u00020\u00042\u0006\u00108\u001a\u00020\u00048\u0006@BX\u0086\u000e\u00a2\u0006\f\n\u0004\bA\u0010B\u001a\u0004\bC\u0010D\u00a8\u0006L"}, d2 = {"Lcom/tencent/mobileqq/wink/editor/template/x;", "Lcom/tencent/biz/richframework/part/BaseViewModel;", "Lcamera/XEFFECT_MATERIALS_GENERAL_DATASTRUCT/MetaMaterial;", WadlProxyConsts.KEY_MATERIAL, "", "isFromTemplateColl", "isOriginalVolumeChangedManually", "Landroid/content/Context;", "context", "", "b2", "hidePlayerUntilTemplateFinish", "c2", "Ljava/util/ArrayList;", "", "Lkotlin/collections/ArrayList;", "O1", "", "agentTypes", "T1", "templatePath", "S1", "Lcom/tencent/videocut/model/MediaClip;", "mediaClips", "d2", "completed", "X1", "W1", "M1", "showed", ICustomDataEditor.STRING_ARRAY_PARAM_2, "L1", "Z1", "getLogTag", "Landroidx/lifecycle/MutableLiveData;", "Lcom/tencent/mobileqq/wink/editor/template/x$b;", "i", "Landroidx/lifecycle/MutableLiveData;", "_updateTemplateActionLiveData", "Landroidx/lifecycle/LiveData;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Landroidx/lifecycle/LiveData;", "P1", "()Landroidx/lifecycle/LiveData;", "updateTemplateActionLiveData", "Lcom/tencent/mobileqq/wink/editor/template/x$c;", BdhLogUtil.LogTag.Tag_Conn, "_updateTemplateClipsActionLiveData", "D", "Q1", "updateTemplateClipsActionLiveData", "E", "_updateTemplateCompletedLiveData", UserInfo.SEX_FEMALE, "R1", "updateTemplateCompletedLiveData", "<set-?>", "G", "Lcamera/XEFFECT_MATERIALS_GENERAL_DATASTRUCT/MetaMaterial;", "N1", "()Lcamera/XEFFECT_MATERIALS_GENERAL_DATASTRUCT/MetaMaterial;", "curTemplateMaterial", "H", "Ljava/lang/String;", "templateFilePath", "I", "Z", "U1", "()Z", "isUseTemplate", "<init>", "()V", "J", "a", "b", "c", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes21.dex */
public final class x extends BaseViewModel {

    /* renamed from: C, reason: from kotlin metadata */
    @NotNull
    private final MutableLiveData<UpdateTemplateClipsAction> _updateTemplateClipsActionLiveData;

    /* renamed from: D, reason: from kotlin metadata */
    @NotNull
    private final LiveData<UpdateTemplateClipsAction> updateTemplateClipsActionLiveData;

    /* renamed from: E, reason: from kotlin metadata */
    @NotNull
    private final MutableLiveData<Boolean> _updateTemplateCompletedLiveData;

    /* renamed from: F, reason: from kotlin metadata */
    @NotNull
    private final LiveData<Boolean> updateTemplateCompletedLiveData;

    /* renamed from: G, reason: from kotlin metadata */
    @Nullable
    private MetaMaterial curTemplateMaterial;

    /* renamed from: H, reason: from kotlin metadata */
    @Nullable
    private String templateFilePath;

    /* renamed from: I, reason: from kotlin metadata */
    private boolean isUseTemplate;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final MutableLiveData<UpdateTemplateAction> _updateTemplateActionLiveData;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final LiveData<UpdateTemplateAction> updateTemplateActionLiveData;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0086\b\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\r\u001a\u00020\u0007\u0012\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000e\u00a2\u0006\u0004\b\u0013\u0010\u0014J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\r\u001a\u00020\u00078\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u001d\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000e8\u0006\u00a2\u0006\f\n\u0004\b\u000b\u0010\u0010\u001a\u0004\b\t\u0010\u0011\u00a8\u0006\u0015"}, d2 = {"Lcom/tencent/mobileqq/wink/editor/template/x$c;", "", "", "toString", "", "hashCode", "other", "", "equals", "a", "Z", "b", "()Z", "modifyClipsDuration", "", "Lcom/tencent/videocut/model/MediaClip;", "Ljava/util/List;", "()Ljava/util/List;", "mediaClips", "<init>", "(ZLjava/util/List;)V", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.wink.editor.template.x$c, reason: from toString */
    /* loaded from: classes21.dex */
    public static final /* data */ class UpdateTemplateClipsAction {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
        private final boolean modifyClipsDuration;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
        @NotNull
        private final List<MediaClip> mediaClips;

        /* JADX WARN: Multi-variable type inference failed */
        public UpdateTemplateClipsAction(boolean z16, @NotNull List<? extends MediaClip> mediaClips) {
            Intrinsics.checkNotNullParameter(mediaClips, "mediaClips");
            this.modifyClipsDuration = z16;
            this.mediaClips = mediaClips;
        }

        @NotNull
        public final List<MediaClip> a() {
            return this.mediaClips;
        }

        /* renamed from: b, reason: from getter */
        public final boolean getModifyClipsDuration() {
            return this.modifyClipsDuration;
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof UpdateTemplateClipsAction)) {
                return false;
            }
            UpdateTemplateClipsAction updateTemplateClipsAction = (UpdateTemplateClipsAction) other;
            if (this.modifyClipsDuration == updateTemplateClipsAction.modifyClipsDuration && Intrinsics.areEqual(this.mediaClips, updateTemplateClipsAction.mediaClips)) {
                return true;
            }
            return false;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r0v1, types: [int] */
        /* JADX WARN: Type inference failed for: r0v4 */
        /* JADX WARN: Type inference failed for: r0v5 */
        public int hashCode() {
            boolean z16 = this.modifyClipsDuration;
            ?? r06 = z16;
            if (z16) {
                r06 = 1;
            }
            return (r06 * 31) + this.mediaClips.hashCode();
        }

        @NotNull
        public String toString() {
            return "UpdateTemplateClipsAction(modifyClipsDuration=" + this.modifyClipsDuration + ", mediaClips=" + this.mediaClips + ")";
        }
    }

    public x() {
        MutableLiveData<UpdateTemplateAction> mutableLiveData = new MutableLiveData<>();
        this._updateTemplateActionLiveData = mutableLiveData;
        this.updateTemplateActionLiveData = mutableLiveData;
        MutableLiveData<UpdateTemplateClipsAction> mutableLiveData2 = new MutableLiveData<>();
        this._updateTemplateClipsActionLiveData = mutableLiveData2;
        this.updateTemplateClipsActionLiveData = mutableLiveData2;
        MutableLiveData<Boolean> mutableLiveData3 = new MutableLiveData<>();
        this._updateTemplateCompletedLiveData = mutableLiveData3;
        this.updateTemplateCompletedLiveData = mutableLiveData3;
    }

    public final boolean L1() {
        boolean b16 = AECameraPrefsUtil.c().b(AECameraPrefsUtil.f318484v, false, 0);
        Z1(true);
        return b16;
    }

    public final boolean M1() {
        return AECameraPrefsUtil.c().b(AECameraPrefsUtil.f318483u, false, 0);
    }

    @Nullable
    /* renamed from: N1, reason: from getter */
    public final MetaMaterial getCurTemplateMaterial() {
        return this.curTemplateMaterial;
    }

    @NotNull
    public final ArrayList<String> O1(@Nullable MetaMaterial material) {
        ArrayList<String> arrayList = new ArrayList<>();
        if (material != null) {
            this.templateFilePath = WinkEditorResourceManager.a1().i2(material);
        }
        String str = this.templateFilePath;
        if (str != null) {
            arrayList = com.tencent.mobileqq.wink.utils.ah.f326668a.b(str);
        }
        ms.a.f("WinkEditorTemplateViewModel", "bundle load needList :" + arrayList);
        return arrayList;
    }

    @NotNull
    public final LiveData<UpdateTemplateAction> P1() {
        return this.updateTemplateActionLiveData;
    }

    @NotNull
    public final LiveData<UpdateTemplateClipsAction> Q1() {
        return this.updateTemplateClipsActionLiveData;
    }

    @NotNull
    public final LiveData<Boolean> R1() {
        return this.updateTemplateCompletedLiveData;
    }

    public final void S1(@Nullable String templatePath) {
        if (templatePath != null) {
            this.templateFilePath = templatePath;
        }
    }

    public final boolean T1(@Nullable List<String> agentTypes) {
        if (agentTypes != null) {
            for (String str : agentTypes) {
                if (!((IAEResUtil) QRoute.api(IAEResUtil.class)).isAEResExist(str)) {
                    ms.a.f("WinkEditorTemplateViewModel", "bundle load not exit" + str);
                    return false;
                }
            }
        }
        ms.a.f("WinkEditorTemplateViewModel", "bundle load isAllBundleExit \uff1a true");
        return true;
    }

    /* renamed from: U1, reason: from getter */
    public final boolean getIsUseTemplate() {
        return this.isUseTemplate;
    }

    public final void W1(@Nullable String templatePath) {
        boolean z16;
        w53.b.a(getLogTag(), "jobBeforeUsingTemplate " + templatePath);
        if (templatePath != null && templatePath.length() != 0) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (!z16) {
            WinkHDRPicQualityDetectUtils.f320445a.d();
        }
    }

    public final void X1(boolean completed) {
        this._updateTemplateCompletedLiveData.postValue(Boolean.valueOf(completed));
    }

    public final void Z1(boolean showed) {
        AECameraPrefsUtil.c().h(AECameraPrefsUtil.f318484v, showed, 0);
    }

    public final void a2(boolean showed) {
        AECameraPrefsUtil.c().h(AECameraPrefsUtil.f318483u, showed, 0);
    }

    public final void b2(@Nullable MetaMaterial material, boolean isFromTemplateColl, boolean isOriginalVolumeChangedManually, @NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        c2(material, isFromTemplateColl, isOriginalVolumeChangedManually, context, false);
    }

    public final void c2(@Nullable MetaMaterial material, boolean isFromTemplateColl, boolean isOriginalVolumeChangedManually, @NotNull Context context, boolean hidePlayerUntilTemplateFinish) {
        Intrinsics.checkNotNullParameter(context, "context");
        w53.b.a("WinkEditorTemplateViewModel", "updateTemplate isFromTemplateColl:" + isFromTemplateColl + ", isOriginalVolumeChangedManually:" + isOriginalVolumeChangedManually + ", hidePlayerUntilTemplateFinish:" + hidePlayerUntilTemplateFinish);
        if (material == null) {
            this.curTemplateMaterial = null;
            this.templateFilePath = null;
            this.isUseTemplate = false;
        } else {
            this.curTemplateMaterial = material;
            this.templateFilePath = WinkEditorResourceManager.a1().i2(material);
            this.isUseTemplate = true;
        }
        String str = this.templateFilePath;
        if (str != null && !com.tencent.mobileqq.wink.utils.ah.f326668a.f(str)) {
            QQToast.makeText(context, context.getString(R.string.f241317rj), 0).show();
        }
        this._updateTemplateActionLiveData.postValue(new UpdateTemplateAction(this.templateFilePath, material, isFromTemplateColl, isOriginalVolumeChangedManually, true, false, 0L, 0, null, hidePlayerUntilTemplateFinish, 480, null));
    }

    public final void d2(@NotNull List<? extends MediaClip> mediaClips) {
        Intrinsics.checkNotNullParameter(mediaClips, "mediaClips");
        this._updateTemplateClipsActionLiveData.postValue(new UpdateTemplateClipsAction(false, mediaClips));
    }

    @Override // com.tencent.biz.richframework.part.BaseViewModel
    @NotNull
    public String getLogTag() {
        return "WinkTemplateViewModel";
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0010\t\n\u0002\b\r\b\u0086\b\u0018\u00002\u00020\u0001Bg\u0012\b\u0010\r\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u0013\u001a\u0004\u0018\u00010\u000e\u0012\u0006\u0010\u0018\u001a\u00020\u0007\u0012\u0006\u0010\u001b\u001a\u00020\u0007\u0012\b\b\u0002\u0010\u001d\u001a\u00020\u0007\u0012\b\b\u0002\u0010\u001f\u001a\u00020\u0007\u0012\b\b\u0002\u0010#\u001a\u00020 \u0012\b\b\u0002\u0010&\u001a\u00020\u0004\u0012\b\b\u0002\u0010)\u001a\u00020\u0002\u0012\b\b\u0002\u0010*\u001a\u00020\u0007\u00a2\u0006\u0004\b+\u0010,J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0019\u0010\r\u001a\u0004\u0018\u00010\u00028\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u0019\u0010\u0013\u001a\u0004\u0018\u00010\u000e8\u0006\u00a2\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012R\u0017\u0010\u0018\u001a\u00020\u00078\u0006\u00a2\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017R\u0017\u0010\u001b\u001a\u00020\u00078\u0006\u00a2\u0006\f\n\u0004\b\u0019\u0010\u0015\u001a\u0004\b\u001a\u0010\u0017R\u0017\u0010\u001d\u001a\u00020\u00078\u0006\u00a2\u0006\f\n\u0004\b\u001c\u0010\u0015\u001a\u0004\b\u0019\u0010\u0017R\u0017\u0010\u001f\u001a\u00020\u00078\u0006\u00a2\u0006\f\n\u0004\b\u001e\u0010\u0015\u001a\u0004\b\u0014\u0010\u0017R\u0017\u0010#\u001a\u00020 8\u0006\u00a2\u0006\f\n\u0004\b\u0011\u0010!\u001a\u0004\b\u000f\u0010\"R\u0017\u0010&\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u0016\u0010$\u001a\u0004\b\u001c\u0010%R\"\u0010)\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u000b\u0010\n\u001a\u0004\b\t\u0010\f\"\u0004\b'\u0010(R\u0017\u0010*\u001a\u00020\u00078\u0006\u00a2\u0006\f\n\u0004\b\u001a\u0010\u0015\u001a\u0004\b\u001e\u0010\u0017\u00a8\u0006-"}, d2 = {"Lcom/tencent/mobileqq/wink/editor/template/x$b;", "", "", "toString", "", "hashCode", "other", "", "equals", "a", "Ljava/lang/String;", "i", "()Ljava/lang/String;", "templatePath", "Lcamera/XEFFECT_MATERIALS_GENERAL_DATASTRUCT/MetaMaterial;", "b", "Lcamera/XEFFECT_MATERIALS_GENERAL_DATASTRUCT/MetaMaterial;", "g", "()Lcamera/XEFFECT_MATERIALS_GENERAL_DATASTRUCT/MetaMaterial;", "metaMaterial", "c", "Z", tl.h.F, "()Z", "modifyClipsDuration", "d", "j", "isOriginalVolumeChangedManually", "e", "enableTemplateImageStickerEdit", "f", "enableOriginVolume", "", "J", "()J", "currentTimeUs", "I", "()I", "fillMode", "setColor", "(Ljava/lang/String;)V", "color", "hidePlayerUntilTemplateFinish", "<init>", "(Ljava/lang/String;Lcamera/XEFFECT_MATERIALS_GENERAL_DATASTRUCT/MetaMaterial;ZZZZJILjava/lang/String;Z)V", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.wink.editor.template.x$b, reason: from toString */
    /* loaded from: classes21.dex */
    public static final /* data */ class UpdateTemplateAction {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
        @Nullable
        private final String templatePath;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
        @Nullable
        private final MetaMaterial metaMaterial;

        /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
        private final boolean modifyClipsDuration;

        /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
        private final boolean isOriginalVolumeChangedManually;

        /* renamed from: e, reason: collision with root package name and from kotlin metadata and from toString */
        private final boolean enableTemplateImageStickerEdit;

        /* renamed from: f, reason: collision with root package name and from kotlin metadata and from toString */
        private final boolean enableOriginVolume;

        /* renamed from: g, reason: collision with root package name and from kotlin metadata and from toString */
        private final long currentTimeUs;

        /* renamed from: h, reason: collision with root package name and from kotlin metadata and from toString */
        private final int fillMode;

        /* renamed from: i, reason: collision with root package name and from kotlin metadata and from toString */
        @NotNull
        private String color;

        /* renamed from: j, reason: collision with root package name and from kotlin metadata and from toString */
        private final boolean hidePlayerUntilTemplateFinish;

        public UpdateTemplateAction(@Nullable String str, @Nullable MetaMaterial metaMaterial, boolean z16, boolean z17, boolean z18, boolean z19, long j3, int i3, @NotNull String color, boolean z26) {
            Intrinsics.checkNotNullParameter(color, "color");
            this.templatePath = str;
            this.metaMaterial = metaMaterial;
            this.modifyClipsDuration = z16;
            this.isOriginalVolumeChangedManually = z17;
            this.enableTemplateImageStickerEdit = z18;
            this.enableOriginVolume = z19;
            this.currentTimeUs = j3;
            this.fillMode = i3;
            this.color = color;
            this.hidePlayerUntilTemplateFinish = z26;
        }

        @NotNull
        /* renamed from: a, reason: from getter */
        public final String getColor() {
            return this.color;
        }

        /* renamed from: b, reason: from getter */
        public final long getCurrentTimeUs() {
            return this.currentTimeUs;
        }

        /* renamed from: c, reason: from getter */
        public final boolean getEnableOriginVolume() {
            return this.enableOriginVolume;
        }

        /* renamed from: d, reason: from getter */
        public final boolean getEnableTemplateImageStickerEdit() {
            return this.enableTemplateImageStickerEdit;
        }

        /* renamed from: e, reason: from getter */
        public final int getFillMode() {
            return this.fillMode;
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof UpdateTemplateAction)) {
                return false;
            }
            UpdateTemplateAction updateTemplateAction = (UpdateTemplateAction) other;
            if (Intrinsics.areEqual(this.templatePath, updateTemplateAction.templatePath) && Intrinsics.areEqual(this.metaMaterial, updateTemplateAction.metaMaterial) && this.modifyClipsDuration == updateTemplateAction.modifyClipsDuration && this.isOriginalVolumeChangedManually == updateTemplateAction.isOriginalVolumeChangedManually && this.enableTemplateImageStickerEdit == updateTemplateAction.enableTemplateImageStickerEdit && this.enableOriginVolume == updateTemplateAction.enableOriginVolume && this.currentTimeUs == updateTemplateAction.currentTimeUs && this.fillMode == updateTemplateAction.fillMode && Intrinsics.areEqual(this.color, updateTemplateAction.color) && this.hidePlayerUntilTemplateFinish == updateTemplateAction.hidePlayerUntilTemplateFinish) {
                return true;
            }
            return false;
        }

        /* renamed from: f, reason: from getter */
        public final boolean getHidePlayerUntilTemplateFinish() {
            return this.hidePlayerUntilTemplateFinish;
        }

        @Nullable
        /* renamed from: g, reason: from getter */
        public final MetaMaterial getMetaMaterial() {
            return this.metaMaterial;
        }

        /* renamed from: h, reason: from getter */
        public final boolean getModifyClipsDuration() {
            return this.modifyClipsDuration;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public int hashCode() {
            int hashCode;
            String str = this.templatePath;
            int i3 = 0;
            if (str == null) {
                hashCode = 0;
            } else {
                hashCode = str.hashCode();
            }
            int i16 = hashCode * 31;
            MetaMaterial metaMaterial = this.metaMaterial;
            if (metaMaterial != null) {
                i3 = metaMaterial.hashCode();
            }
            int i17 = (i16 + i3) * 31;
            boolean z16 = this.modifyClipsDuration;
            int i18 = 1;
            int i19 = z16;
            if (z16 != 0) {
                i19 = 1;
            }
            int i26 = (i17 + i19) * 31;
            boolean z17 = this.isOriginalVolumeChangedManually;
            int i27 = z17;
            if (z17 != 0) {
                i27 = 1;
            }
            int i28 = (i26 + i27) * 31;
            boolean z18 = this.enableTemplateImageStickerEdit;
            int i29 = z18;
            if (z18 != 0) {
                i29 = 1;
            }
            int i36 = (i28 + i29) * 31;
            boolean z19 = this.enableOriginVolume;
            int i37 = z19;
            if (z19 != 0) {
                i37 = 1;
            }
            int a16 = (((((((i36 + i37) * 31) + androidx.fragment.app.a.a(this.currentTimeUs)) * 31) + this.fillMode) * 31) + this.color.hashCode()) * 31;
            boolean z26 = this.hidePlayerUntilTemplateFinish;
            if (!z26) {
                i18 = z26 ? 1 : 0;
            }
            return a16 + i18;
        }

        @Nullable
        /* renamed from: i, reason: from getter */
        public final String getTemplatePath() {
            return this.templatePath;
        }

        /* renamed from: j, reason: from getter */
        public final boolean getIsOriginalVolumeChangedManually() {
            return this.isOriginalVolumeChangedManually;
        }

        @NotNull
        public String toString() {
            return "UpdateTemplateAction(templatePath=" + this.templatePath + ", metaMaterial=" + this.metaMaterial + ", modifyClipsDuration=" + this.modifyClipsDuration + ", isOriginalVolumeChangedManually=" + this.isOriginalVolumeChangedManually + ", enableTemplateImageStickerEdit=" + this.enableTemplateImageStickerEdit + ", enableOriginVolume=" + this.enableOriginVolume + ", currentTimeUs=" + this.currentTimeUs + ", fillMode=" + this.fillMode + ", color=" + this.color + ", hidePlayerUntilTemplateFinish=" + this.hidePlayerUntilTemplateFinish + ")";
        }

        public /* synthetic */ UpdateTemplateAction(String str, MetaMaterial metaMaterial, boolean z16, boolean z17, boolean z18, boolean z19, long j3, int i3, String str2, boolean z26, int i16, DefaultConstructorMarker defaultConstructorMarker) {
            this(str, metaMaterial, z16, z17, (i16 & 16) != 0 ? false : z18, (i16 & 32) != 0 ? true : z19, (i16 & 64) != 0 ? 0L : j3, (i16 & 128) != 0 ? -1 : i3, (i16 & 256) != 0 ? "" : str2, (i16 & 512) != 0 ? false : z26);
        }
    }
}

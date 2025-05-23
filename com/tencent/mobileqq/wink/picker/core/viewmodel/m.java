package com.tencent.mobileqq.wink.picker.core.viewmodel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.biz.richframework.part.BaseViewModel;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.wink.picker.MediaPickerScene;
import com.tencent.mobileqq.wink.picker.MediaProcessState;
import com.tencent.mobileqq.wink.picker.MediaProcessStateType;
import com.tencent.mobileqq.wink.picker.utils.PhotoListLogicPreDealDialog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u0000 12\u00020\u00012\u00020\u0002:\u00012B\u0007\u00a2\u0006\u0004\b/\u00100J\b\u0010\u0004\u001a\u00020\u0003H\u0016J\b\u0010\u0006\u001a\u00020\u0005H\u0016J\u0010\u0010\t\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0007H\u0016J\u0010\u0010\f\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\nH\u0016J\u0018\u0010\u0010\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\n2\u0006\u0010\u000f\u001a\u00020\u000eH\u0016J\u0018\u0010\u0014\u001a\u00020\u00052\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0013\u001a\u00020\u0007H\u0016J\u0010\u0010\u0015\u001a\u00020\u00052\u0006\u0010\u000f\u001a\u00020\u000eH\u0016J\u0010\u0010\u0016\u001a\u00020\u00052\u0006\u0010\u000f\u001a\u00020\u000eH\u0016J\u0010\u0010\u0017\u001a\u00020\u00052\u0006\u0010\u000f\u001a\u00020\u000eH\u0016J\b\u0010\u0018\u001a\u00020\u0005H\u0016J\u0018\u0010\u001a\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\u0019\u001a\u00020\nH\u0016R\u0016\u0010\u001e\u001a\u00020\u001b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001c\u0010\u001dR\u001a\u0010\"\u001a\b\u0012\u0004\u0012\u00020 0\u001f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0016\u0010!R\u001d\u0010(\u001a\b\u0012\u0004\u0012\u00020 0#8\u0006\u00a2\u0006\f\n\u0004\b$\u0010%\u001a\u0004\b&\u0010'R\u001a\u0010+\u001a\b\u0012\u0004\u0012\u00020)0\u001f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b*\u0010!R\u001d\u0010.\u001a\b\u0012\u0004\u0012\u00020)0#8\u0006\u00a2\u0006\f\n\u0004\b,\u0010%\u001a\u0004\b-\u0010'\u00a8\u00063"}, d2 = {"Lcom/tencent/mobileqq/wink/picker/core/viewmodel/m;", "Lcom/tencent/biz/richframework/part/BaseViewModel;", "Lcom/tencent/mobileqq/wink/picker/core/viewmodel/b;", "", "getLogTag", "", "E0", "", "isError", "b0", "", "toCompressedMediaNum", "y0", "itemIndex", "", "progress", "e", "Lcom/tencent/mobileqq/wink/picker/utils/PhotoListLogicPreDealDialog$PreDealStep;", "step", "useVideoTemplate", "g0", "W0", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "i0", "z0", "errorMsgResId", "l1", "Lcom/tencent/mobileqq/wink/picker/MediaPickerScene;", "i", "Lcom/tencent/mobileqq/wink/picker/MediaPickerScene;", "mediaPickerScene", "Landroidx/lifecycle/MutableLiveData;", "Lcom/tencent/mobileqq/wink/picker/MediaProcessStateType;", "Landroidx/lifecycle/MutableLiveData;", "_downloadQZoneMediaStateMutableLiveData", "Landroidx/lifecycle/LiveData;", BdhLogUtil.LogTag.Tag_Conn, "Landroidx/lifecycle/LiveData;", "N1", "()Landroidx/lifecycle/LiveData;", "downloadQZoneMediaStateLiveData", "Lcom/tencent/mobileqq/wink/picker/c;", "D", "_processMediaStateMutableLiveData", "E", "O1", "processMediaStateLiveData", "<init>", "()V", UserInfo.SEX_FEMALE, "a", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes21.dex */
public final class m extends BaseViewModel implements b {

    /* renamed from: C, reason: from kotlin metadata */
    @NotNull
    private final LiveData<MediaProcessStateType> downloadQZoneMediaStateLiveData;

    /* renamed from: D, reason: from kotlin metadata */
    @NotNull
    private final MutableLiveData<MediaProcessState> _processMediaStateMutableLiveData;

    /* renamed from: E, reason: from kotlin metadata */
    @NotNull
    private final LiveData<MediaProcessState> processMediaStateLiveData;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private MediaPickerScene mediaPickerScene = MediaPickerScene.STANDARD;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final MutableLiveData<MediaProcessStateType> _downloadQZoneMediaStateMutableLiveData;

    public m() {
        MutableLiveData<MediaProcessStateType> mutableLiveData = new MutableLiveData<>();
        this._downloadQZoneMediaStateMutableLiveData = mutableLiveData;
        this.downloadQZoneMediaStateLiveData = mutableLiveData;
        MutableLiveData<MediaProcessState> mutableLiveData2 = new MutableLiveData<>();
        this._processMediaStateMutableLiveData = mutableLiveData2;
        this.processMediaStateLiveData = mutableLiveData2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void P1(m this$0, boolean z16, PhotoListLogicPreDealDialog.PreDealStep step) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(step, "$step");
        this$0._processMediaStateMutableLiveData.setValue(new MediaProcessState(this$0.mediaPickerScene, MediaProcessStateType.UPDATE_STEP, 0, 0, 0.0f, 0, z16, step, 60, null));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Q1(m this$0, float f16) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0._processMediaStateMutableLiveData.setValue(new MediaProcessState(this$0.mediaPickerScene, MediaProcessStateType.UPDATE_VIDEO_TEMPLATE_PROGRESS, 0, 0, f16, 0, false, null, 236, null));
    }

    @Override // com.tencent.mobileqq.wink.picker.core.viewmodel.b
    public void E0() {
        this._downloadQZoneMediaStateMutableLiveData.postValue(MediaProcessStateType.SHOW);
    }

    @NotNull
    public final LiveData<MediaProcessStateType> N1() {
        return this.downloadQZoneMediaStateLiveData;
    }

    @NotNull
    public final LiveData<MediaProcessState> O1() {
        return this.processMediaStateLiveData;
    }

    @Override // com.tencent.mobileqq.wink.picker.core.viewmodel.b
    public void W0(final float progress) {
        ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.mobileqq.wink.picker.core.viewmodel.l
            @Override // java.lang.Runnable
            public final void run() {
                m.Q1(m.this, progress);
            }
        });
    }

    @Override // com.tencent.mobileqq.wink.picker.core.viewmodel.b
    public void b0(boolean isError) {
        if (isError) {
            this._downloadQZoneMediaStateMutableLiveData.postValue(MediaProcessStateType.ERROR);
        } else {
            this._downloadQZoneMediaStateMutableLiveData.postValue(MediaProcessStateType.DISMISS);
        }
    }

    @Override // com.tencent.mobileqq.wink.picker.core.viewmodel.b
    public void e(int itemIndex, float progress) {
        this._processMediaStateMutableLiveData.postValue(new MediaProcessState(this.mediaPickerScene, MediaProcessStateType.UPDATE_COMPRESS_PROGRESS, 0, itemIndex, progress, 0, false, null, 228, null));
    }

    @Override // com.tencent.mobileqq.wink.picker.core.viewmodel.b
    public void g0(@NotNull final PhotoListLogicPreDealDialog.PreDealStep step, final boolean useVideoTemplate) {
        Intrinsics.checkNotNullParameter(step, "step");
        ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.mobileqq.wink.picker.core.viewmodel.k
            @Override // java.lang.Runnable
            public final void run() {
                m.P1(m.this, useVideoTemplate, step);
            }
        });
    }

    @Override // com.tencent.biz.richframework.part.BaseViewModel
    @NotNull
    /* renamed from: getLogTag */
    public String getTAG() {
        return "WinkNextStepUIStateViewModel";
    }

    @Override // com.tencent.mobileqq.wink.picker.core.viewmodel.b
    public void i0(float progress) {
        this._processMediaStateMutableLiveData.postValue(new MediaProcessState(this.mediaPickerScene, MediaProcessStateType.UPDATE_EXPORT_PROGRESS, 0, 0, progress, 0, false, null, 236, null));
    }

    @Override // com.tencent.mobileqq.wink.picker.core.viewmodel.b
    public void l1(boolean isError, int errorMsgResId) {
        if (isError) {
            this._processMediaStateMutableLiveData.postValue(new MediaProcessState(this.mediaPickerScene, MediaProcessStateType.ERROR, errorMsgResId, 0, 0.0f, 0, false, null, 248, null));
        } else {
            this._processMediaStateMutableLiveData.postValue(new MediaProcessState(this.mediaPickerScene, MediaProcessStateType.DISMISS, 0, 0, 0.0f, 0, false, null, 252, null));
        }
    }

    @Override // com.tencent.mobileqq.wink.picker.core.viewmodel.b
    public void m(float progress) {
        this._processMediaStateMutableLiveData.postValue(new MediaProcessState(this.mediaPickerScene, MediaProcessStateType.UPDATE_TEMPLATE_LIB_PREPROCESS, 0, 0, progress, 0, false, null, 236, null));
    }

    @Override // com.tencent.mobileqq.wink.picker.core.viewmodel.b
    public void y0(int toCompressedMediaNum) {
        this._processMediaStateMutableLiveData.postValue(new MediaProcessState(this.mediaPickerScene, MediaProcessStateType.SHOW, toCompressedMediaNum, 0, 0.0f, 0, false, null, 248, null));
    }

    @Override // com.tencent.mobileqq.wink.picker.core.viewmodel.b
    public void z0() {
        this._processMediaStateMutableLiveData.postValue(new MediaProcessState(this.mediaPickerScene, MediaProcessStateType.FINISH, 0, 0, 0.0f, 0, false, null, 252, null));
    }
}

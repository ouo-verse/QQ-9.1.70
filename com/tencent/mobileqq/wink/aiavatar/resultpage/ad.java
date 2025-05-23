package com.tencent.mobileqq.wink.aiavatar.resultpage;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.biz.richframework.part.BaseViewModel;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.wink.aiavatar.resultpage.v;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0017\u0018\u0000 )2\u00020\u0001:\u0001*B\u0007\u00a2\u0006\u0004\b'\u0010(J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u0016\u0010\t\u001a\u00020\u00042\u000e\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006J\u000e\u0010\f\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\nJ\u0006\u0010\r\u001a\u00020\u0004J\u0006\u0010\u000e\u001a\u00020\u0002J\b\u0010\u000f\u001a\u00020\u0007H\u0016R\u001a\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\n0\u00108\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u001d\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\n0\u00148\u0006\u00a2\u0006\f\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018R\u0016\u0010\u001c\u001a\u00020\n8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001a\u0010\u001bR\u001a\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u00040\u00108\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001d\u0010\u0012R\u001d\u0010!\u001a\b\u0012\u0004\u0012\u00020\u00040\u00148\u0006\u00a2\u0006\f\n\u0004\b\u001f\u0010\u0016\u001a\u0004\b \u0010\u0018R\"\u0010#\u001a\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u00060\u00108\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\"\u0010\u0012R%\u0010&\u001a\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u00060\u00148\u0006\u00a2\u0006\f\n\u0004\b$\u0010\u0016\u001a\u0004\b%\u0010\u0018\u00a8\u0006+"}, d2 = {"Lcom/tencent/mobileqq/wink/aiavatar/resultpage/ad;", "Lcom/tencent/biz/richframework/part/BaseViewModel;", "", "isFirstCropView", "", "R1", "", "", "imagePaths", "Q1", "Lcom/tencent/mobileqq/wink/aiavatar/resultpage/v;", "state", "S1", "L1", "P1", "getLogTag", "Landroidx/lifecycle/MutableLiveData;", "i", "Landroidx/lifecycle/MutableLiveData;", "_uiState", "Landroidx/lifecycle/LiveData;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Landroidx/lifecycle/LiveData;", "O1", "()Landroidx/lifecycle/LiveData;", "uiState", BdhLogUtil.LogTag.Tag_Conn, "Lcom/tencent/mobileqq/wink/aiavatar/resultpage/v;", "lastUiState", "D", "_onAvatarCropViewSelect", "E", "M1", "onAvatarCropViewSelect", UserInfo.SEX_FEMALE, "_onReplaceOriginImages", "G", "N1", "onReplaceOriginImages", "<init>", "()V", "H", "a", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes21.dex */
public final class ad extends BaseViewModel {

    /* renamed from: C, reason: from kotlin metadata */
    @NotNull
    private v lastUiState;

    /* renamed from: D, reason: from kotlin metadata */
    @NotNull
    private final MutableLiveData<Unit> _onAvatarCropViewSelect;

    /* renamed from: E, reason: from kotlin metadata */
    @NotNull
    private final LiveData<Unit> onAvatarCropViewSelect;

    /* renamed from: F, reason: from kotlin metadata */
    @NotNull
    private final MutableLiveData<List<String>> _onReplaceOriginImages;

    /* renamed from: G, reason: from kotlin metadata */
    @NotNull
    private final LiveData<List<String>> onReplaceOriginImages;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final MutableLiveData<v> _uiState;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final LiveData<v> uiState;

    public ad() {
        MutableLiveData<v> mutableLiveData = new MutableLiveData<>();
        this._uiState = mutableLiveData;
        this.uiState = mutableLiveData;
        this.lastUiState = new v.Init(null, null, 3, null);
        MutableLiveData<Unit> mutableLiveData2 = new MutableLiveData<>();
        this._onAvatarCropViewSelect = mutableLiveData2;
        this.onAvatarCropViewSelect = mutableLiveData2;
        MutableLiveData<List<String>> mutableLiveData3 = new MutableLiveData<>();
        this._onReplaceOriginImages = mutableLiveData3;
        this.onReplaceOriginImages = mutableLiveData3;
    }

    public final void L1() {
        this._uiState.postValue(this.lastUiState);
        this._onAvatarCropViewSelect.postValue(Unit.INSTANCE);
    }

    @NotNull
    public final LiveData<Unit> M1() {
        return this.onAvatarCropViewSelect;
    }

    @NotNull
    public final LiveData<List<String>> N1() {
        return this.onReplaceOriginImages;
    }

    @NotNull
    public final LiveData<v> O1() {
        return this.uiState;
    }

    public final boolean P1() {
        if (!(this._uiState.getValue() instanceof v.FirstGenerating) && !(this._uiState.getValue() instanceof v.f) && !(this._uiState.getValue() instanceof v.l) && !(this._uiState.getValue() instanceof v.i)) {
            return false;
        }
        return true;
    }

    public final void Q1(@Nullable List<String> imagePaths) {
        this._onReplaceOriginImages.postValue(imagePaths);
    }

    public final void R1(boolean isFirstCropView) {
        v value = this._uiState.getValue();
        if (value != null) {
            value.b(isFirstCropView);
        }
        this._onAvatarCropViewSelect.postValue(Unit.INSTANCE);
    }

    public final void S1(@NotNull v state) {
        v vVar;
        Intrinsics.checkNotNullParameter(state, "state");
        v value = this._uiState.getValue();
        if (value == null) {
            value = new v.Init(null, null, 3, null);
        }
        if ((value instanceof v.Init) || (value instanceof v.GenerateSuccess)) {
            this.lastUiState = value;
        }
        if (state instanceof v.i) {
            if (!(this._uiState.getValue() instanceof v.Init)) {
                this._uiState.getValue();
                if (!(this._uiState.getValue() instanceof v.FirstGenerating)) {
                    if (!(this._uiState.getValue() instanceof v.f) && !(this._uiState.getValue() instanceof v.FirstGenerateFailed)) {
                        vVar = v.l.f317850b;
                    } else {
                        vVar = v.f.f317841b;
                    }
                }
            }
            vVar = new v.FirstGenerating(null, null, 3, null);
        } else if (state instanceof v.GenerateFailed) {
            if (!(this.uiState.getValue() instanceof v.FirstGenerating) && !(this.uiState.getValue() instanceof v.f)) {
                v.GenerateFailed generateFailed = (v.GenerateFailed) state;
                vVar = new v.OtherGenerateFailed(generateFailed.getErrorCode(), generateFailed.getErrorMsg());
            } else {
                v.GenerateFailed generateFailed2 = (v.GenerateFailed) state;
                vVar = new v.FirstGenerateFailed(generateFailed2.getErrorCode(), generateFailed2.getErrorMsg());
            }
        } else {
            vVar = state;
        }
        MutableLiveData<v> mutableLiveData = this._uiState;
        vVar.b(state.getIsFirstAvatarSelected());
        mutableLiveData.postValue(vVar);
    }

    @Override // com.tencent.biz.richframework.part.BaseViewModel
    @NotNull
    public String getLogTag() {
        return "WinkAIAvatarResultUIStateViewModel";
    }
}
